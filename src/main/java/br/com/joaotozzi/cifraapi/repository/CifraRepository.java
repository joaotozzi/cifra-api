package br.com.joaotozzi.cifraapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joaotozzi.cifraapi.model.Cifra;

public interface CifraRepository extends JpaRepository<Cifra, Long>{

	List<Cifra> findByTituloContainingIgnoreCase(String titulo);

}
