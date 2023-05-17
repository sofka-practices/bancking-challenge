package co.com.banco.appservice.adapters.database.jpa.entities;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "T_CUENTAS")
public class CuentaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(min = 6, max = 6, message = "El número de cuenta debe tener 6 digitos.")
    @Column(name = "numero_cuenta", unique = true)
    private String numeroCuenta;

    @NotEmpty
    @Column(name = "tipo_cuenta")
    private String tipoCuenta;

    @PositiveOrZero
    @Column(name = "saldo_actual", nullable = false)
    private Long saldoInicial;

    @NotEmpty
    @Column(name = "estado_cuenta")
    private String estado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cuentaData")
    private List<MovimientoData> movimientoDataList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private ClienteEntity clienteData;
}
