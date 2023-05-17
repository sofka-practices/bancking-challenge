package co.com.banco.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Persona {
    private Integer id;
    private String numeroDocumento;
    private String tipoDocumento;
    private String nombre;
    private String apellido;
    private String genero;
    private String direccion;
    private String telefono;
}
