package co.com.banco.appservice.adapters;

import co.com.banco.appservice.adapters.database.jpa.repositories.JPACuentaDataRepository;
import co.com.banco.gateway.CuentaRepository;
import co.com.banco.model.Cuenta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor

@Component
public class CuentaRepositoryAdapter implements CuentaRepository {
    private final JPACuentaDataRepository jpaCuentaDataRepository;

    @Override
    public Flux<Cuenta> encontrarCuentas(String estado) {
        return null;
    }

    @Override
    public Mono<Cuenta> encontrarCuentaPorId(Integer id) {
        return null;
    }

    @Override
    public Mono<Cuenta> guardarCuenta(Cuenta cuenta) {
        return null;
    }

    @Override
    public Mono<Cuenta> buscarPorNumeroCuenta(String numeroCuenta) {
        return null;
    }
}
