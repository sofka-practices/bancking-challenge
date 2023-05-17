package co.com.banco.appservice.adapters;

import co.com.banco.appservice.adapters.database.jpa.repositories.JPAClienteDataRepository;
import co.com.banco.gateway.ClienteRepository;
import co.com.banco.model.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class ClienteRepositoryAdapter implements ClienteRepository {
    private final JPAClienteDataRepository jpaClienteDataRepository;

    @Override
    public Flux<Cliente> encontrarClientes(String estado) {
        return null;
    }

    @Override
    public Mono<Cliente> encontrarPorId(Integer id) {
        return null;
    }

    @Override
    public Mono<Cliente> guardarCliente(Cliente cliente) {
        return null;
    }
}
