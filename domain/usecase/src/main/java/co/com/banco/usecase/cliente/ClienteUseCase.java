package co.com.banco.usecase.cliente;

import co.com.banco.gateway.ClienteRepository;
import co.com.banco.model.Cliente;
import co.com.banco.common.ex.BusinessException;
import co.com.banco.model.Cuenta;
import co.com.banco.usecase.persona.PersonaUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import static co.com.banco.common.ValidationUtils.validarCamposCliente;
import static co.com.banco.common.ValidationUtils.validarIdNulo;

@RequiredArgsConstructor
public class ClienteUseCase {

    public static final String ESTADO_INACTIVO = "INACTIVO";
    public static final String ESTADO_ACTIVO = "ACTIVO";
    private final ClienteRepository clienteRepository;
    private final PersonaUseCase personaUseCase;

    public Flux<Cliente> obtenerClientes() {
        return clienteRepository.encontrarClientes(ESTADO_ACTIVO);
    }

    public Mono<Cliente> obtenerPor(Integer id) {
        validarIdNulo(id);
        return clienteRepository.encontrarPorId(id)
                .filter(cliente -> !cliente.getEstado().equalsIgnoreCase(ESTADO_ACTIVO))
                .switchIfEmpty(Mono.defer(() -> {
                    throw new BusinessException(BusinessException.Type.ERROR_CLIENTE_NO_REGISTRADO);
                }));
    }


    public Mono<Cliente> guardar(Cliente cliente) {
        validarCamposCliente(cliente);
        return personaUseCase.encontrarPorTipoYNumeroDocumento(
                cliente.getPersona().getTipoDocumento(), cliente.getPersona().getNumeroDocumento()
        ).switchIfEmpty(Mono.defer(() -> {
            throw new BusinessException(BusinessException.Type.PERSONA_EXISTE);
        })).flatMap(persona -> personaUseCase.guardarPersona(cliente.getPersona()))
        .flatMap(personaCreada -> {
            cliente.setPersona(personaCreada);
            return clienteRepository.guardarCliente(cliente);
        });
    }


    public Mono<Void> inactivarPor(Integer id) {
        return obtenerPor(id).flatMap(clienteEncontrado -> {
            clienteEncontrado.setEstado(ESTADO_INACTIVO);
            return clienteRepository.guardarCliente(clienteEncontrado);
        }).then();

    }

    public Mono<Cliente> actualizar(Integer id, Cliente cliente) {
        validarCamposCliente(cliente);

        return personaUseCase.encontrarPorTipoYNumeroDocumento(
                cliente.getPersona().getTipoDocumento(), cliente.getPersona().getNumeroDocumento()
        ).switchIfEmpty(Mono.defer(() -> {
            throw new BusinessException(BusinessException.Type.ERROR_PERSONA_NO_REGISTRADA);
        })).flatMap(persona -> personaUseCase.editarPersona( cliente, persona))
                .flatMap(personaActualizada -> obtenerPor(id).flatMap(clienteEnBaseDeDatos -> {
            clienteEnBaseDeDatos.setPassword(cliente.getPassword());
            clienteEnBaseDeDatos.setPersona(personaActualizada);
            return clienteRepository.guardarCliente(clienteEnBaseDeDatos);
        }));
    }

    public Mono<Void> validarSiExisteCliente(Cuenta cuenta) {
        return clienteRepository.encontrarPorId(cuenta.getCliente().getId()).switchIfEmpty(Mono.defer(()->{
            throw new BusinessException(BusinessException.Type.ERROR_PERSONA_NO_REGISTRADA);
        })).then();
    }

}
