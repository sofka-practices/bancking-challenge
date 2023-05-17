package co.com.banco.gateway;

import co.com.banco.model.Persona;
import reactor.core.publisher.Mono;

public interface PersonaRepository {
    Mono<Persona> save(Persona persona);
    Mono<Persona> encontrarPersonaPorId(Integer id);
    Mono<Persona> encontrarPorTipoYNumeroDocumento(String tipoDocumento, String numeroDocumento);
}
