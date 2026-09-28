package br.com.fatec.ninjas.repository;

import br.com.fatec.ninjas.model.Cla;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClaRepository extends JpaRepository<Cla, Long> {
    List<Cla> findByNomeIgnoreCase(String nome);
    List<Cla> findByDescricaoContainingIgnoreCase(String descricao);
}
