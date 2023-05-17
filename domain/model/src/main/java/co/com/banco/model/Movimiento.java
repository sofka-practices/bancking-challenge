package co.com.banco.model;

import co.com.banco.model.Cuenta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Movimiento {
    private Integer id;
    private Date fechaMovimiento;
    private String tipoMovimiento;
    private Long valorMovimiento;
    private Long saldo;
    private Long saldoAnterior;
    private Cuenta cuenta;
}
