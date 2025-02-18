package com.caioandrade.gerenciamento_de_livros.service;

import com.caioandrade.gerenciamento_de_livros.infrastructure.entities.LivroEntity;
import com.caioandrade.gerenciamento_de_livros.infrastructure.repositories.LivroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public LivroEntity novoLivro(LivroEntity livro) {
        livroRepository.save(livro);
        return livro;
    }

    public List<LivroEntity> listarLivros() {
        return livroRepository.findAll();
    }

    public LivroEntity buscarLivroPorId(Long id) {
        return livroRepository.findById(id).get();
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
