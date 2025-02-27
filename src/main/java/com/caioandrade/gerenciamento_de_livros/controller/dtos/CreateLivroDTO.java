package com.caioandrade.gerenciamento_de_livros.controller.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateLivroDTO (String titulo, String autor, String editora,
                              @JsonFormat(pattern = "dd/MM/yyyy") LocalDate dataLancamento, BigDecimal preco) {

}
