package co.com.banco.appservice.adapters;

import co.com.banco.appservice.adapters.database.jpa.repositories.JPAPersonaDataRepository;
import co.com.banco.gateway.PersonaRepository;
import co.com.banco.model.Persona;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class PersonaRepositoryAdapter implements PersonaRepository {
    private final JPAPersonaDataRepository jpaPersonaDataRepository;
    @Override
    public Mono<Persona> save(Persona persona) {
        return null;
    }

    @Override
    public Mono<Persona> encontrarPersonaPorId(Integer id) {
        return null;
    }

    @Override
    public Mono<Persona> encontrarPorTipoYNumeroDocumento(String tipoDocumento, String numeroDocumento) {
        return null;
    }
}
