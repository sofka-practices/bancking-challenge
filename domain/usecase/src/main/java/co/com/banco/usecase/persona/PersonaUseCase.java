package co.com.banco.usecase.persona;

import co.com.banco.gateway.PersonaRepository;
import co.com.banco.model.Cliente;
import co.com.banco.common.ex.BusinessException;
import co.com.banco.model.Cuenta;
import co.com.banco.model.Persona;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Objects;


@RequiredArgsConstructor
public class PersonaUseCase {

    private final PersonaRepository personaRepository;

    public Mono<Persona> encontrarPorTipoYNumeroDocumento(String tipoDocumento, String numeroDocumento) {
        return personaRepository.encontrarPorTipoYNumeroDocumento(tipoDocumento, numeroDocumento)
                .switchIfEmpty(Mono.defer(() -> {
                    throw new BusinessException(BusinessException.Type.ERROR_PERSONA_NO_REGISTRADA);
                }));
    }

    public Mono<Persona> guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public Mono<Persona> editarPersona(Cliente cliente, Persona persona) {
        if (cliente.getPersona().getId() == null) {
            throw new BusinessException(BusinessException.Type.ERROR_CAMPO_NULL_PERSONA);
        }
        persona.setNombre(cliente.getPersona().getNombre());
        persona.setApellido(cliente.getPersona().getApellido());
        persona.setDireccion(cliente.getPersona().getDireccion());
        persona.setTelefono(cliente.getPersona().getTelefono());
        return guardarPersona(persona);
    }

    public Mono<Void> validarSiExistePersona(Cuenta cuenta) {
       return personaRepository.encontrarPorTipoYNumeroDocumento(
                cuenta.getCliente().getPersona().getTipoDocumento(),
                cuenta.getCliente().getPersona().getNumeroDocumento()
        ).switchIfEmpty(Mono.defer(() -> {
           throw new BusinessException(BusinessException.Type.ERROR_PERSONA_NO_REGISTRADA);
       })).then();
    }

}
