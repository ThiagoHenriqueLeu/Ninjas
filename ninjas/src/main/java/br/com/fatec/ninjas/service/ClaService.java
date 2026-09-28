package br.com.fatec.ninjas.service;

import br.com.fatec.ninjas.model.Cla;
import br.com.fatec.ninjas.repository.ClaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ClaService {
    private final ClaRepository repository;

    public ClaService(ClaRepository repository){
        this.repository = repository;
    }

    @Transactional
    public Cla cadastrar(Cla cla){
      cla.setId(null);
       return repository.save(cla);
    }

    public List<Cla> listar(){
       return repository.findAll();
    }

    public Cla pesquisarPorId(Long id){
       return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cla nao encontrado"));
    }

    public List<Cla> pesquisarPorNome(String nome){
       return repository.findByNomeIgnoreCase(nome);
    }

    public List<Cla> pesquisarPorDescricao(String descricao){
       return repository.findByDescricaoContainingIgnoreCase(descricao);
    }

    @Transactional
    public Cla atualizar(Long id, Cla dados){
        Cla cla = pesquisarPorId(id);
      cla.setNome(dados.getNome());
      cla.setDescricao(dados.getDescricao());
      cla.setHabilidade(dados.getHabilidade());
      cla.setFundador(dados.getFundador());
       return repository.save(cla);
    }

    @Transactional
    public void deletar(Long id){
        repository.delete(pesquisarPorId(id));
    }
}
