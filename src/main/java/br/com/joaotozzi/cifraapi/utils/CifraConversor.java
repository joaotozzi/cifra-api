package br.com.joaotozzi.cifraapi.utils;

import java.util.List;
import java.util.stream.Collectors;

import br.com.joaotozzi.cifraapi.dto.CifraDTO;
import br.com.joaotozzi.cifraapi.model.Cifra;

public class CifraConversor {

	public static List<CifraDTO> converterCifrasParaCifrasDTO(List<Cifra> cifras) {
		return cifras.stream().map(CifraDTO::new).collect(Collectors.toList());
	}
	
}
