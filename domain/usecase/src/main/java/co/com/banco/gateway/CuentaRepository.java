package co.com.banco.gateway;

import co.com.banco.model.Cuenta;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CuentaRepository {
    Flux<Cuenta> encontrarCuentas(String estado);

    Mono<Cuenta> encontrarCuentaPorId(Integer id);

    Mono<Cuenta> guardarCuenta(Cuenta cuenta);

    Mono<Cuenta> buscarPorNumeroCuenta(String numeroCuenta);
}
