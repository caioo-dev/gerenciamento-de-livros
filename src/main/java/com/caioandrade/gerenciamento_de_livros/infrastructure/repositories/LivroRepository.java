package com.caioandrade.gerenciamento_de_livros.infrastructure.repositories;

import com.caioandrade.gerenciamento_de_livros.infrastructure.entities.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LivroRepository extends JpaRepository <LivroEntity, Long> {
    List<LivroEntity> findByAutor(String autor);

    List<LivroEntity> findByDataLancamentoAfter(LocalDate dataLancamento);
}