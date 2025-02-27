package com.caioandrade.gerenciamento_de_livros.controller;

import com.caioandrade.gerenciamento_de_livros.controller.dtos.CreateLivroDTO;
import com.caioandrade.gerenciamento_de_livros.infrastructure.entities.LivroEntity;
import com.caioandrade.gerenciamento_de_livros.service.LivroService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("livro")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity<LivroEntity> novoLivro(@RequestBody CreateLivroDTO createLivroDTO) {
        var livroId = livroService.novoLivro(createLivroDTO);
        return ResponseEntity.created(URI.create("/livro/" + livroId.toString())).build();

    }

    @GetMapping
    public List<LivroEntity> listarLivros(){
        return livroService.listarLivros();
    }

    @GetMapping("{id}")
    public ResponseEntity<LivroEntity> buscarLivroPorId(@PathVariable Long id){
        var livro = livroService.buscarLivroPorId(id);
        if (livro.isPresent()) {
            return ResponseEntity.ok(livro.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public void deletarLivroPorId(@PathVariable Long id){
        livroService.deletarLivroPorId(id);
    }

    @GetMapping("autor/{autor}")
    public List<LivroEntity> listarLivrosPorAutor(@PathVariable String autor){
        return livroService.buscarLivroPorAutor(autor);
    }

    @GetMapping("dataLancamento")
    public List<LivroEntity> buscarLivroPorDataLancamento(@RequestParam
                                                          @DateTimeFormat(pattern = "dd/MM/yyyy")
                                                              LocalDate dataLancamento){
        return livroService.buscarLivroPorDataLancamento(dataLancamento);
    }
}
