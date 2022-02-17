package br.com.joaotozzi.cifraapi.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransposicaoAcorde {

	private static HashMap<String, List<String>> tabelaDeTransposicao;

	public static String mudarTom(String acordeOriginal, String tomOriginal, String tomAlvo) {

		if (tabelaDeTransposicao == null) {
			tabelaDeTransposicao = new HashMap<String, List<String>>();
			tabelaDeTransposicao.put("C",
					new ArrayList<String>(List.of("C#", "_C", "Db", "D", "D#", "_D", "Eb", "E", "E#", "Fb", "F", "F#",
							"_G", "Gb", "G", "G#", "_A", "_G", "Ab", "A", "A#", "_A", "Bb", "B", "B#", "Cb", "C")));
			tabelaDeTransposicao.put("Db",
					new ArrayList<String>(List.of("D", "D#", "_D", "Eb", "E", "E#", "Fb", "F", "F#", "_F", "Gb", "G",
							"G#", "_G", "Ab", "A", "A#", "_Ab", "_A", "Bb", "B", "B#", "Cb", "C", "C#", "_C", "Db")));
			tabelaDeTransposicao.put("D",
					new ArrayList<String>(List.of("D#", "_D", "Eb", "E", "E#", "Fb", "F", "F#", "_G", "Gb", "G", "G#",
							"_A", "Ab", "A", "A#", "_B", "_A", "Bb", "B", "B#", "Cb", "C", "C#", "_D", "Db", "D")));
			tabelaDeTransposicao.put("Eb",
					new ArrayList<String>(List.of("E", "E#", "Fb", "F", "F#", "_F", "Gb", "G", "G#", "_G", "Ab", "A",
							"A#", "_A", "Bb", "B", "B#", "_Bb", "Cb", "C", "C#", "_C", "Db", "D", "D#", "_D", "Eb")));
			tabelaDeTransposicao.put("E",
					new ArrayList<String>(List.of("E#", "Fb", "F", "F#", "_G", "Gb", "G", "G#", "_A", "Ab", "A", "A#",
							"_B", "Bb", "B", "B#", "_C#", "Cb", "C", "C#", "_D", "Db", "D", "D#", "_E", "Eb", "E")));
			tabelaDeTransposicao.put("F",
					new ArrayList<String>(List.of("F#", "_F", "Gb", "G", "G#", "_G", "Ab", "A", "A#", "_A", "Bb", "B",
							"B#", "Cb", "C", "C#", "_D", "_C", "Db", "D", "D#", "_D", "Eb", "E", "E#", "Fb", "F")));
			tabelaDeTransposicao.put("F#",
					new ArrayList<String>(List.of("_G", "Gb", "G", "G#", "_A", "Ab", "A", "A#", "_B", "Bb", "B", "B#",
							"Cb", "C", "C#", "_D", "_D#", "Db", "D", "D#", "_E", "Eb", "E", "E#", "Fb", "F", "F#")));
			tabelaDeTransposicao.put("G",
					new ArrayList<String>(List.of("G#", "_G", "Ab", "A", "A#", "_A", "Bb", "B", "B#", "Cb", "C", "C#",
							"_D", "Db", "D", "D#", "_E", "_D", "Eb", "E", "E#", "Fb", "F", "F#", "_G", "Gb", "G")));
			tabelaDeTransposicao.put("Ab",
					new ArrayList<String>(List.of("A", "A#", "_A", "Bb", "B", "B#", "Cb", "C", "C#", "_C", "Db", "D",
							"D#", "_D", "Eb", "E", "E#", "_Eb", "Fb", "F", "F#", "_F", "Gb", "G", "G#", "_G", "Ab")));
			tabelaDeTransposicao.put("A",
					new ArrayList<String>(List.of("A#", "_A", "Bb", "B", "B#", "Cb", "C", "C#", "_D", "Db", "D", "D#",
							"_E", "Eb", "E", "E#", "_F#", "Fb", "F", "F#", "_G", "Gb", "G", "G#", "_A", "Ab", "A")));
			tabelaDeTransposicao.put("Bb",
					new ArrayList<String>(List.of("B", "B#", "Cb", "C", "C#", "_C", "Db", "D", "D#", "_D", "Eb", "E",
							"E#", "Fb", "F", "F#", "_G", "_F", "Gb", "G", "G#", "_G", "Ab", "A", "A#", "_A", "Bb")));
			tabelaDeTransposicao.put("B",
					new ArrayList<String>(List.of("B#", "Cb", "C", "C#", "_D", "Db", "D", "D#", "_E", "Eb", "E", "E#",
							"Fb", "F", "F#", "_G", "_G#", "Gb", "G", "G#", "_A", "Ab", "A", "A#", "_B", "Bb", "B")));
		}

		List<String> notasAcordeOriginal = extrairNotas(acordeOriginal);
		List<String> notasAcordeAlvo = new ArrayList<String>();

		for (String nota : notasAcordeOriginal) {
			int posicao = tabelaDeTransposicao.get(tomOriginal).indexOf(nota);
			notasAcordeAlvo.add(tabelaDeTransposicao.get(tomAlvo).get(posicao).replace("_", ""));
		}

		return substituirNotasDoAcorde(acordeOriginal, notasAcordeOriginal, notasAcordeAlvo);
	}

	private static List<String> extrairNotas(String cifra) {

		Pattern p = Pattern.compile("[A-G][#|b]?");
		Matcher m = p.matcher(cifra);

		List<String> notas = new ArrayList<String>();

		while (m.find()) {
			notas.add(m.group());
		}

		return notas;
	}

	private static String substituirNotasDoAcorde(String acorde, List<String> notasAcordeAtual,
			List<String> notasNovoAcorde) {

		if (notasAcordeAtual.size() == 1) {
			return acorde.replace(notasAcordeAtual.get(0), notasNovoAcorde.get(0));
		}

		return acorde.substring(0, acorde.lastIndexOf(notasAcordeAtual.get(1))).replace(notasAcordeAtual.get(0),
				notasNovoAcorde.get(0))
				+ acorde.substring(acorde.lastIndexOf(notasAcordeAtual.get(1))).replace(notasAcordeAtual.get(1),
						notasNovoAcorde.get(1));
	}

}
