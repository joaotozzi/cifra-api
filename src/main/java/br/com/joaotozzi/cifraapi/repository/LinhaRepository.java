package br.com.joaotozzi.cifraapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joaotozzi.cifraapi.model.Linha;

public interface LinhaRepository extends JpaRepository<Linha, Long>{

	List<Linha> findBySecaoId(long id);

}
