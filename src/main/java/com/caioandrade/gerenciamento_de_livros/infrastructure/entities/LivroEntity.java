package com.caioandrade.gerenciamento_de_livros.infrastructure.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_livro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String autor;

    private String editora;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataLancamento;

    private BigDecimal preco;
}
