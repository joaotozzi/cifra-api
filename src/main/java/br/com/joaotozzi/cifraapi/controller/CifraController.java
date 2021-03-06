package br.com.joaotozzi.cifraapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
import br.com.joaotozzi.cifraapi.utils.TransposicaoCifra;
import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin
@RestController
@RequestMapping("/cifras")
public class CifraController {
	
	@Autowired
	private CifraRepository cifraRepository;
	
	@Autowired
	private SecaoRepository secaoRepository;
	
	@Autowired
	private LinhaRepository linhaRepository;
	
	@GetMapping
	@Operation(summary = "Listar as cifras")
	public List<CifraDTO> listar (@RequestParam(required = false) String titulo){
		if(titulo == null) {
			List<Cifra> cifras = cifraRepository.findAll();
			return CifraConversor.converterCifrasParaCifrasDTO(cifras);
		}
		
		List<Cifra> cifras = cifraRepository.findByTituloContainingIgnoreCase(titulo);
		return CifraConversor.converterCifrasParaCifrasDTO(cifras);

	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Consultar uma cifra pelo id")
	public ResponseEntity<CifraDetalhadaDTO> consultarCifra (@PathVariable Long id){
		Optional<Cifra> optional = cifraRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new CifraDetalhadaDTO(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@GetMapping("/{id}/tom/{tom}")
	@Operation(summary = "Consultar uma cifra em outro tom")
	public ResponseEntity<CifraDetalhadaDTO> consultarCifraEmOutroTom (@PathVariable Long id, @PathVariable String tom){
		Optional<Cifra> optional = cifraRepository.findById(id);
		if (optional.isPresent()) {
			
			Cifra cifra =  TransposicaoCifra.mudarTom(optional.get(), tom);
			return ResponseEntity.ok(new CifraDetalhadaDTO(cifra));
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping
	@Transactional
	@Operation(summary = "Cadastrar uma nova cifra")
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid CadastroCifraForm cifraForm,
			UriComponentsBuilder uriBuilder) {

		//cadastrando a cifra
		Cifra cifra = new Cifra(cifraForm);
		cifraRepository.save(cifra);
		
		//cadastrando se????es
		for (SecaoForm secaoForm : cifraForm.getSecoes()) {
			Secao secao = new Secao(secaoForm, cifra);
			secaoRepository.save(secao);
			
			//cadastrando linhas
			for (LinhaForm linhaForm : secaoForm.getLinhas()) {
				linhaRepository.save(new Linha(linhaForm, secao));
			}
		}	

		URI uri = uriBuilder.path("/cifras/{id}").buildAndExpand(cifra.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}
	
	@PutMapping
	@Transactional
	@Operation(summary = "Atualizar uma cifra existente")
	public void atualizarCifra(@RequestBody CifraForm cifraForm) {
		Optional<Cifra> optional = cifraRepository.findById(cifraForm.getId());
		if (optional.isPresent()) {
			
			//atualizando a cifra
			Cifra cifra = optional.get();
			cifra.setTitulo(cifraForm.getTitulo());
			cifra.setCompositor(cifraForm.getCompositor());
			cifra.setLinkYoutube(cifraForm.getLinkYoutube());
			cifra.setAndamento(cifraForm.getAndamento());
			cifra.setTomOriginal(cifraForm.getTomOriginal());
			
			
			// apagando as se????es e linhas existentes
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

			// recadastrando as se????es e linhas
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
	@Operation(summary = "Apagar uma cifra")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		Optional<Cifra> optional = cifraRepository.findById(id);
		if (optional.isPresent()) {
			cifraRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
}
