package br.com.joaotozzi.cifraapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joaotozzi.cifraapi.model.Cifra;

public interface CifraRepository extends JpaRepository<Cifra, Long>{

}
