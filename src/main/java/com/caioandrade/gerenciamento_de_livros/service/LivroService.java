package com.caioandrade.gerenciamento_de_livros.service;

import com.caioandrade.gerenciamento_de_livros.controller.dtos.CreateLivroDTO;
import com.caioandrade.gerenciamento_de_livros.infrastructure.entities.LivroEntity;
import com.caioandrade.gerenciamento_de_livros.infrastructure.repositories.LivroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Long novoLivro(CreateLivroDTO createLivroDTO) {
        var entity = new LivroEntity(
                null,
                createLivroDTO.titulo(),
                createLivroDTO.autor(),
                createLivroDTO.editora(),
                createLivroDTO.dataLancamento(),
                createLivroDTO.preco()
        );

        var livroSalvo = livroRepository.save(entity);
        return livroSalvo.getId();
    }

    public List<LivroEntity> listarLivros() {
        return livroRepository.findAll();
    }

    public Optional<LivroEntity> buscarLivroPorId(Long id) {
        return livroRepository.findById(id);
    }

    public void deletarLivroPorId(Long id) {
        livroRepository.deleteById(id);
    }

    public List<LivroEntity> buscarLivroPorAutor(String autor) {
        return livroRepository.findByAutor(autor);
    }

    public List<LivroEntity> buscarLivroPorDataLancamento(LocalDate dataLancamento) {
        return livroRepository.findByDataLancamentoAfter(dataLancamento);
    }
}
