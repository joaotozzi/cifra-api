package br.com.joaotozzi.cifraapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joaotozzi.cifraapi.model.Secao;

public interface SecaoRepository extends JpaRepository<Secao, Long> {
	
	List<Secao> findByCifraId(long id);

}
