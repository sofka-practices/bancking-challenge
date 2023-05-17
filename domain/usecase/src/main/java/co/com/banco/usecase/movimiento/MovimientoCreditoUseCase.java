package co.com.banco.usecase.movimiento;

import co.com.banco.model.Movimiento;
import co.com.banco.gateway.CuentaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class MovimientoCreditoUseCase {

    private final CuentaRepository cuentaRepository;

    public Mono<Movimiento> construirMovimientoCredito(Movimiento movimiento) {
        if (movimiento.getId() == null) {
            return construirNuevoMovimiento(movimiento);
        }
        return construirReversionMovimiento(movimiento);
    }

    private Mono<Movimiento> construirReversionMovimiento(Movimiento movimiento) {
        return Mono.just(movimiento).map(movimiento1 -> {
            movimiento1.setSaldo(movimiento.getSaldoAnterior() + movimiento.getValorMovimiento());
            movimiento1.getCuenta().setSaldoInicial(movimiento.getSaldo());
            return movimiento1;
        });

    }

    private Mono<Movimiento> construirNuevoMovimiento(Movimiento movimiento) {
        return cuentaRepository.encontrarCuentaPorId(movimiento.getCuenta().getId()).map(cuentaConsultada -> {
            movimiento.setSaldo(cuentaConsultada.getSaldoInicial() + movimiento.getValorMovimiento());
            movimiento.setSaldoAnterior(cuentaConsultada.getSaldoInicial());
            movimiento.getCuenta().setSaldoInicial(movimiento.getSaldo());
            return movimiento;
        });

    }
}
