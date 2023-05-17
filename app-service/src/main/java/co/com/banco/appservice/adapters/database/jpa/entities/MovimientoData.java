package co.com.banco.appservice.adapters.database.jpa.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "T_MOVIMIENTOS")
public class MovimientoData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha_movimiento", nullable = false)
    private Date fechaMovimiento;

    @NotEmpty
    @Size(min = 6, max = 10, message = "El número de cuenta debe tener 6 digitos.")
    @Column(name = "tipo_movimiento")
    private String tipoMovimiento;

    @Column(name = "valor_movimiento", nullable = false)
    private Long valorMovimiento;

    @PositiveOrZero
    @Column(name = "saldo", nullable = false)
    private Long saldo;

    @PositiveOrZero
    @Column(name = "saldo_anterior", nullable = false)
    private Long saldoAnterior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id")
    private CuentaData cuentaData;

}