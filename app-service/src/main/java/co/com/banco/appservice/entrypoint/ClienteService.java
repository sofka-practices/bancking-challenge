package co.com.banco.appservice.entrypoint;

import co.com.banco.model.Cliente;
import co.com.banco.usecase.cliente.ClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;


@CrossOrigin(
        origins = {"http://localhost:4200"},
        methods = {RequestMethod.GET, RequestMethod.PATCH, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteUseCase clienteUseCase;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Cliente> verTodosLosClientes() {
        return clienteUseCase.obtenerClientes();
    }


}