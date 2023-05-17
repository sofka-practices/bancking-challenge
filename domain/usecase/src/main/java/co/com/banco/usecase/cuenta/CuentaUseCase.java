package co.com.banco.usecase.cuenta;

import co.com.banco.common.ex.BusinessException;
import co.com.banco.gateway.CuentaRepository;
import co.com.banco.model.Cuenta;
import co.com.banco.usecase.cliente.ClienteUseCase;
import co.com.banco.usecase.persona.PersonaUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static co.com.banco.common.ValidationUtils.validarCamposCuenta;
import static co.com.banco.common.ValidationUtils.validarIdNulo;

@RequiredArgsConstructor
public class CuentaUseCase {

    public static final String INACTIVO = "INACTIVO";
    public static final String ACTIVO = "ACTIVO";
    private final CuentaRepository cuentaRepository;
    private final ClienteUseCase clienteUseCase;
    private final PersonaUseCase personaUseCase;

    public Flux<Cuenta> obtenerCuentas() {
        return cuentaRepository.encontrarCuentas(ACTIVO);
    }

    public Mono<Cuenta> obtenerCuentaPor(Integer id) {
        validarIdNulo(id);
        return cuentaRepository.encontrarCuentaPorId(id)
                .filter(cuentaEncontrada -> !cuentaEncontrada.getEstado().equalsIgnoreCase(ACTIVO))
                .switchIfEmpty(Mono.defer(() ->{
            throw new BusinessException(BusinessException.Type.CUENTA_NO_ENCONTRADA);
        }));
    }


    public Mono<Cuenta> guardar(Cuenta cuenta) {
        validarCamposCuenta(cuenta);
        validarTipoCuenta(cuenta.getTipoCuenta());
        validarSiExisteClienteYPersona(cuenta);
        validarSiExisteCuenta(cuenta);
        return cuentaRepository.guardarCuenta(cuenta);
    }


    public Mono<Void> eliminar(Integer id) {
        return obtenerCuentaPor(id).flatMap(cuentaEncontrada -> {
            cuentaEncontrada.setEstado(INACTIVO);
           return cuentaRepository.guardarCuenta(cuentaEncontrada);
        }).then();
    }

    public Mono<Cuenta> actualizar(Integer id, Cuenta cuenta) {
        validarIdNulo(id);
        validarCamposCuenta(cuenta);
        validarTipoCuenta(cuenta.getTipoCuenta());
        return cuentaRepository.buscarPorNumeroCuenta(cuenta.getNumeroCuenta()).filter(cuentaEnBaseDeDatos -> {
            return !cuentaEnBaseDeDatos.getEstado().equalsIgnoreCase(ACTIVO);
        }) .switchIfEmpty(Mono.defer(() ->{
            throw new BusinessException(BusinessException.Type.CUENTA_NO_ENCONTRADA);
        })).flatMap(cuentaEnBaseDeDatos -> {
            cuentaEnBaseDeDatos.setTipoCuenta(cuenta.getTipoCuenta());
            cuentaEnBaseDeDatos.setEstado(cuenta.getEstado());
            cuentaEnBaseDeDatos.setSaldoInicial(cuenta.getSaldoInicial());
            return cuentaRepository.guardarCuenta(cuentaEnBaseDeDatos);
        });
    }

    private void validarTipoCuenta(String tipoCuenta) {
        if (!tipoCuenta.equalsIgnoreCase("AHORRO") && !tipoCuenta.equalsIgnoreCase("CORRIENTE")) {
            throw new BusinessException(BusinessException.Type.TIPO_CUENTA_NO_VALIDO);
        }
    }

    private Mono<Void> validarSiExisteCuenta(Cuenta cuenta) {
        return cuentaRepository.buscarPorNumeroCuenta(cuenta.getNumeroCuenta()).switchIfEmpty(Mono.defer(() -> {
            throw new BusinessException(BusinessException.Type.CUENTA_YA_EXISTE);
        })).then();
    }

    private Mono<Void> validarSiExisteClienteYPersona(Cuenta cuenta) {
        return Flux.just(
                clienteUseCase.validarSiExisteCliente(cuenta),
                personaUseCase.validarSiExistePersona(cuenta)
        ).then();
    }


}
