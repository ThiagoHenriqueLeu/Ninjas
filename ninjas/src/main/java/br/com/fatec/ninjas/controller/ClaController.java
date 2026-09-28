package br.com.fatec.ninjas.controller;

import br.com.fatec.ninjas.model.Cla;
import br.com.fatec.ninjas.service.ClaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cla")
public class ClaController {
    private final ClaService service;

    public ClaController(ClaService service){
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cla cadastrar(@Valid @RequestBody Cla cla){
       return service.cadastrar(cla);
    }

    @GetMapping
    public List<Cla> listar(){
       return service.listar();
    }

    @GetMapping("/id/{id}")
    public Cla pesquisarPorId(@PathVariable Long id){
       return service.pesquisarPorId(id);
    }

    @GetMapping("/nome/{nome}")
    public List<Cla> pesquisarPorNome(@PathVariable String nome){
       return service.pesquisarPorNome(nome);
    }

    @GetMapping("/descricao/{descricao}")
    public List<Cla> pesquisarPorDescricao(@PathVariable String descricao){
       return service.pesquisarPorDescricao(descricao);
    }

    @PutMapping("/{id}")
    public Cla atualizar(@PathVariable Long id, @Valid @RequestBody Cla cla){
       return service.atualizar(id, cla);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
