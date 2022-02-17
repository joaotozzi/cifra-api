package br.com.joaotozzi.cifraapi.utils;

import br.com.joaotozzi.cifraapi.model.Cifra;
import br.com.joaotozzi.cifraapi.model.Linha;
import br.com.joaotozzi.cifraapi.model.Secao;

public class TransposicaoCifra {

	public static Cifra mudarTom(Cifra cifra, String novoTom) {

		for (Secao secao : cifra.getSecoes()) {
			for (Linha linha : secao.getLinhas()) {

				linha.setConteudo(mudarTom(linha.getConteudo(), cifra.getTomOriginal(), novoTom));
			}
		}
		return cifra;
	}

	private static String mudarTom(String conteudo, String tomOriginal, String novoTom) {
		String[] partes = conteudo.replace("[", "=[").replace("]", "]=").split("=");

		StringBuilder novoConteudo = new StringBuilder();

		for (String parte : partes) {
			if (parte.contains("[")) {
				String parteTemporaria = TransposicaoAcorde.mudarTom(parte.replace("[", "").replace("]", ""),
						tomOriginal, novoTom);

				novoConteudo.append("[" + parteTemporaria + "]");
			} else {
				novoConteudo.append(parte);
			}
		}

		return novoConteudo.toString();
	}

}
