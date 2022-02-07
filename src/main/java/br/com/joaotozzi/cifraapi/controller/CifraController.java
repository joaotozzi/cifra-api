package br.com.joaotozzi.cifraapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.joaotozzi.cifraapi.dto.CifraDTO;
import br.com.joaotozzi.cifraapi.dto.CifraDetalhadaDTO;
import br.com.joaotozzi.cifraapi.form.CadastroCifraForm;
import br.com.joaotozzi.cifraapi.form.CifraForm;
import br.com.joaotozzi.cifraapi.form.LinhaForm;
import br.com.joaotozzi.cifraapi.form.SecaoForm;
import br.com.joaotozzi.cifraapi.model.Cifra;
import br.com.joaotozzi.cifraapi.model.Linha;
import br.com.joaotozzi.cifraapi.model.Secao;
import br.com.joaotozzi.cifraapi.repository.CifraRepository;
import br.com.joaotozzi.cifraapi.repository.LinhaRepository;
import br.com.joaotozzi.cifraapi.repository.SecaoRepository;
import br.com.joaotozzi.cifraapi.utils.CifraConversor;

@RestController
@RequestMapping("/")
public class CifraController {
	
	@Autowired
	private CifraRepository cifraRepository;
	
	@Autowired
	private SecaoRepository secaoRepository;
	
	@Autowired
	private LinhaRepository linhaRepository;
	
	@GetMapping
	public List<CifraDTO> listar (){
		List<Cifra> cifras = cifraRepository.findAll();
		return CifraConversor.converterCifrasParaCifrasDTO(cifras);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CifraDetalhadaDTO> consultarCifra (@PathVariable Long id){
		Optional<Cifra> optional = cifraRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new CifraDetalhadaDTO(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid CadastroCifraForm cifraForm,
			UriComponentsBuilder uriBuilder) {

		//cadastrando a cifra
		Cifra cifra = new Cifra(cifraForm);
		cifraRepository.save(cifra);
		
		//cadastrando seções
		for (SecaoForm secaoForm : cifraForm.getSecoes()) {
			Secao secao = new Secao(secaoForm, cifra);
			secaoRepository.save(secao);
			
			//cadastrando linhas
			for (LinhaForm linhaForm : secaoForm.getLinhas()) {
				linhaRepository.save(new Linha(linhaForm, secao));
			}
		}	

		URI uri = uriBuilder.path("/musicas/{id}").buildAndExpand(cifra.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}
	
	@PutMapping
	@Transactional
	public void atualizarCifra(@RequestBody CifraForm cifraForm) {
		Optional<Cifra> optional = cifraRepository.findById(cifraForm.getId());
		if (optional.isPresent()) {
			
			//atualizando a cifra
			Cifra cifra = optional.get();
			cifra.setTitulo(cifraForm.getTitulo());
			cifra.setCompositor(cifraForm.getCompositor());
			cifra.setVersao(cifraForm.getVersao());
			cifra.setLinkYoutube(cifraForm.getLinkYoutube());
			cifra.setAndamento(cifraForm.getAndamento());
			cifra.setTomOriginal(cifraForm.getTomOriginal());
			
			
			// apagando as seções e linhas existentes
			List<Secao> secoes = secaoRepository.findByCifraId(cifraForm.getId());
			if (!secoes.isEmpty()) {
				for (Secao secao : secoes) {
					
					List<Linha> linhas = linhaRepository.findBySecaoId(secao.getId());
					if(!linhas.isEmpty()) {
						for (Linha linha : linhas) {
							linhaRepository.deleteById(linha.getId());
						}
					}
					
					secaoRepository.deleteById(secao.getId());
				
				}
			}

			// recadastrando as seções e linhas
			for (SecaoForm secaoForm : cifraForm.getSecoes()) {
				Secao secao = new Secao(secaoForm, cifra);
				secaoRepository.save(secao);
				
				//cadastrando linhas
				for (LinhaForm linhaForm : secaoForm.getLinhas()) {
					linhaRepository.save(new Linha(linhaForm, secao));
				}
			}	
		}
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		Optional<Cifra> optional = cifraRepository.findById(id);
		if (optional.isPresent()) {
			cifraRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
}
