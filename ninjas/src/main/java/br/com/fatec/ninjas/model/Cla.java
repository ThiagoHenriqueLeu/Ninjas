package br.com.fatec.ninjas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "cla")
public class Cla {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Nome e obrigatorio")
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "Descricao e obrigatoria")
    @Size(max = 2000)
    @Column(nullable = false, length = 2000)
    private String descricao;

    @NotBlank(message = "Habilidade e obrigatoria")
    @Size(max = 255)
    @Column(nullable = false)
    private String habilidade;

    @Size(max = 100, message = "Fundador deve ter no maximo 100 caracteres")
    @Column(length = 100)
    private String fundador;

}
