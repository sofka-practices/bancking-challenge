package co.com.banco.gateway;

import co.com.banco.model.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteRepository {
    Flux<Cliente> encontrarClientes(String estado);

    Mono<Cliente> encontrarPorId(Integer id);

    Mono<Cliente> guardarCliente(Cliente cliente);
}
