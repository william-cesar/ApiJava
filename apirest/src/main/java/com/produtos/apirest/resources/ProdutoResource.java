package com.produtos.apirest.resources;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    public Produto listaProduto(@PathVariable(value="id") long id){
       return produtoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Não encontrado"));
    }

    @PostMapping("/produto")
    public ResponseEntity<String> salvaProduto(@RequestBody Produto produto){
        produtoRepository.save(produto);
        return ResponseEntity.ok("Produto cadastrado com sucesso.");
    }

    @DeleteMapping("/produto/{id}")
    public ResponseEntity<String> deletaProduto(@PathVariable (value = "id") long id){
        produtoRepository.deleteById(id);
        return ResponseEntity.ok("Produto removido com sucesso.");
    }

    @PutMapping("/produto/{id}")
    public ResponseEntity<String> atualizaProduto(@PathVariable (value="id") long id, @RequestBody Produto produto){
        produtoRepository.save(produto);
        return ResponseEntity.ok("Produto atualizado com sucesso.");
    }

}
