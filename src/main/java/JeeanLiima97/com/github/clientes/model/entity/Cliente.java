package JeeanLiima97.com.github.clientes.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
// Gera os metodos(get,set, tostring) através do lombok;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 155)
    private String nome;
    @Column(nullable = false, length = 11)
    private String cpf;
    @Column
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }
}
