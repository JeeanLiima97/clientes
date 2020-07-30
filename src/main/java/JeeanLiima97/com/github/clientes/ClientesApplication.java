package JeeanLiima97.com.github.clientes;

import JeeanLiima97.com.github.clientes.model.entity.Cliente;
import JeeanLiima97.com.github.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientesApplication {
    // Testando o persist de um cliente
//    @Bean
//    public CommandLineRunner run(@Autowired ClienteRepository repository){
//        return args -> {
//            Cliente cliente = Cliente.builder().cpf("3013123213").nome("Jean").build();
//            repository.save(cliente);
//
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(ClientesApplication.class, args);
    }

}
