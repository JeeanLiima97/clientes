package JeeanLiima97.com.github.clientes.controller;

import JeeanLiima97.com.github.clientes.controller.dto.ServicoPrestadoDTO;
import JeeanLiima97.com.github.clientes.model.entity.Cliente;
import JeeanLiima97.com.github.clientes.model.entity.ServicoPrestado;
import JeeanLiima97.com.github.clientes.model.repository.ClienteRepository;
import JeeanLiima97.com.github.clientes.model.repository.ServicoPrestaadoRepository;
import JeeanLiima97.com.github.clientes.util.BigDecimalConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/servicos-prestados")
public class ServicoPrestadoController {

    @Autowired
    ServicoPrestaadoRepository servicoPrestaadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private BigDecimalConverter bigDecimalConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto) {
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idCliente = dto.getIdCliente();
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente Inexistente"));


        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor(bigDecimalConverter.converter(dto.getPreco()));
        return servicoPrestaadoRepository.save(servicoPrestado);
    }

    @GetMapping
    public List<ServicoPrestado> getAll() {
        return servicoPrestaadoRepository.findAll();
    }


}
