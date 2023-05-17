package co.com.banco.appservice.adapters;

import co.com.banco.appservice.adapters.database.jpa.repositories.JPAMovimientoDataRepository;
import co.com.banco.gateway.MovimientoRepository;
import co.com.banco.model.Movimiento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@RequiredArgsConstructor
@Component

public class MovimientoRepositoryAdapter implements MovimientoRepository {
    private final JPAMovimientoDataRepository jpaMovimientoDataRepository;
    @Override
    public Flux<Movimiento> findAll() {
        return null;
    }

    @Override
    public Flux<Movimiento> verMovimientos() {
        return null;
    }

    @Override
    public Mono<Movimiento> encontrarPorId(Integer id) {
        return null;
    }

    @Override
    public Mono<Movimiento> crearMovimiento(Movimiento movimiento) {
        return null;
    }

    @Override
    public Flux<Movimiento> generarReporteEntreFechas(Date inicio, Date fin) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return null;
    }

    @Override
    public Flux<Movimiento> encontrarMovimientosPorCuentaAsociada(Integer id) {
        return null;
    }
}
