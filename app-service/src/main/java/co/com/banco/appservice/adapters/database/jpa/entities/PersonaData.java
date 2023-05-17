package co.com.banco.appservice.adapters.database.jpa.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "T_PERSONAS")
public class PersonaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(min = 6, max = 10)
    @Column(name = "numero_documento", unique = true)
    private String numeroDocumento;

    @NotEmpty
    @Column(name = "tipo_documento", length = 20)
    private String tipoDocumento;

    @NotEmpty
    @Size(min = 3, max = 50)
    @Column(name = "nombre", length = 50)
    private String nombre;

    @NotEmpty
    @Size(min = 3, max = 50)
    @Column(name = "apellido", length = 50)
    private String apellido;

    @NotEmpty
    @Size(min = 3, max = 15)
    @Column(name = "genero")
    private String genero;

    @NotEmpty
    @Size(min = 5, max = 50)
    @Column(name = "direccion")
    private String direccion;

    @NotEmpty
    @Size(min = 9, max = 12)
    @Column(name = "telefono")
    private String telefono;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "personaData")
    private List<ClienteEntity> clienteDataList;
}