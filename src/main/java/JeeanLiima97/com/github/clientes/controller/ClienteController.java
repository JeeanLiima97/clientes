package JeeanLiima97.com.github.clientes.controller;


import JeeanLiima97.com.github.clientes.model.entity.Cliente;
import JeeanLiima97.com.github.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }


}
