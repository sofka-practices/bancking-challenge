package co.com.banco.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Cliente {
    private Integer id;
    private String password;
    private String usuario;
    private String estado;
    private Persona persona;
    private List<Cuenta> cuentaDataList;
}
