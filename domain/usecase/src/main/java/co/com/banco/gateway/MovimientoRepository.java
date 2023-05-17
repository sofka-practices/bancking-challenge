package co.com.banco.gateway;

import co.com.banco.model.Movimiento;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

public interface MovimientoRepository {
    Flux<Movimiento> findAll();

    Flux<Movimiento> verMovimientos();

    Mono<Movimiento> encontrarPorId(Integer id);

    Mono<Movimiento> crearMovimiento(Movimiento movimiento);

    Flux<Movimiento> generarReporteEntreFechas(Date inicio, Date fin);

    Mono<Void> deleteById(Integer id);

    Flux<Movimiento> encontrarMovimientosPorCuentaAsociada(Integer id);
}
