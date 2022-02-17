package br.com.joaotozzi.cifraapi.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransposicaoAcorde {

	private static HashMap<String, List<String>> tabelaDeTransposicao = new HashMap<String, List<String>>();

	public static String mudarTom(String acordeOriginal, String tomOriginal, String tomAlvo) {

		if (tabelaDeTransposicao.isEmpty()) {
			
			tabelaDeTransposicao.put("A", new ArrayList<String>());
			tabelaDeTransposicao.get("A").add("A#");
			tabelaDeTransposicao.get("A").add("_A");
			tabelaDeTransposicao.get("A").add("Bb");
			tabelaDeTransposicao.get("A").add("B");
			tabelaDeTransposicao.get("A").add("B#");
			tabelaDeTransposicao.get("A").add("Cb");
			tabelaDeTransposicao.get("A").add("C");
			tabelaDeTransposicao.get("A").add("C#");
			tabelaDeTransposicao.get("A").add("_D");
			tabelaDeTransposicao.get("A").add("Db");
			tabelaDeTransposicao.get("A").add("D");
			tabelaDeTransposicao.get("A").add("D#");
			tabelaDeTransposicao.get("A").add("_E");
			tabelaDeTransposicao.get("A").add("Eb");
			tabelaDeTransposicao.get("A").add("E");
			tabelaDeTransposicao.get("A").add("E#");
			tabelaDeTransposicao.get("A").add("_F#");
			tabelaDeTransposicao.get("A").add("Fb");
			tabelaDeTransposicao.get("A").add("F");
			tabelaDeTransposicao.get("A").add("F#");
			tabelaDeTransposicao.get("A").add("_G");
			tabelaDeTransposicao.get("A").add("Gb");
			tabelaDeTransposicao.get("A").add("G");
			tabelaDeTransposicao.get("A").add("G#");
			tabelaDeTransposicao.get("A").add("_A");
			tabelaDeTransposicao.get("A").add("Ab");
			tabelaDeTransposicao.get("A").add("A");
			
			tabelaDeTransposicao.put("Bb", new ArrayList<String>());
			tabelaDeTransposicao.get("Bb").add("B");
			tabelaDeTransposicao.get("Bb").add("B#");
			tabelaDeTransposicao.get("Bb").add("Cb");
			tabelaDeTransposicao.get("Bb").add("C");
			tabelaDeTransposicao.get("Bb").add("C#");
			tabelaDeTransposicao.get("Bb").add("_C");
			tabelaDeTransposicao.get("Bb").add("Db");
			tabelaDeTransposicao.get("Bb").add("D");
			tabelaDeTransposicao.get("Bb").add("D#");
			tabelaDeTransposicao.get("Bb").add("_D");
			tabelaDeTransposicao.get("Bb").add("Eb");
			tabelaDeTransposicao.get("Bb").add("E");
			tabelaDeTransposicao.get("Bb").add("E#");
			tabelaDeTransposicao.get("Bb").add("Fb");
			tabelaDeTransposicao.get("Bb").add("F");
			tabelaDeTransposicao.get("Bb").add("F#");
			tabelaDeTransposicao.get("Bb").add("_G");
			tabelaDeTransposicao.get("Bb").add("_F");
			tabelaDeTransposicao.get("Bb").add("Gb");
			tabelaDeTransposicao.get("Bb").add("G");
			tabelaDeTransposicao.get("Bb").add("G#");
			tabelaDeTransposicao.get("Bb").add("_G");
			tabelaDeTransposicao.get("Bb").add("Ab");
			tabelaDeTransposicao.get("Bb").add("A");
			tabelaDeTransposicao.get("Bb").add("A#");
			tabelaDeTransposicao.get("Bb").add("_A");
			tabelaDeTransposicao.get("Bb").add("Bb");
			
			tabelaDeTransposicao.put("B", new ArrayList<String>());
			tabelaDeTransposicao.get("B").add("B#");
			tabelaDeTransposicao.get("B").add("Cb");
			tabelaDeTransposicao.get("B").add("C");
			tabelaDeTransposicao.get("B").add("C#");
			tabelaDeTransposicao.get("B").add("_D");
			tabelaDeTransposicao.get("B").add("Db");
			tabelaDeTransposicao.get("B").add("D");
			tabelaDeTransposicao.get("B").add("D#");
			tabelaDeTransposicao.get("B").add("_E");
			tabelaDeTransposicao.get("B").add("Eb");
			tabelaDeTransposicao.get("B").add("E");
			tabelaDeTransposicao.get("B").add("E#");
			tabelaDeTransposicao.get("B").add("Fb");
			tabelaDeTransposicao.get("B").add("F");
			tabelaDeTransposicao.get("B").add("F#");
			tabelaDeTransposicao.get("B").add("_G");
			tabelaDeTransposicao.get("B").add("_G#");
			tabelaDeTransposicao.get("B").add("Gb");
			tabelaDeTransposicao.get("B").add("G");
			tabelaDeTransposicao.get("B").add("G#");
			tabelaDeTransposicao.get("B").add("_A");
			tabelaDeTransposicao.get("B").add("Ab");
			tabelaDeTransposicao.get("B").add("A");
			tabelaDeTransposicao.get("B").add("A#");
			tabelaDeTransposicao.get("B").add("_B");
			tabelaDeTransposicao.get("B").add("Bb");
			tabelaDeTransposicao.get("B").add("B");
			
			tabelaDeTransposicao.put("C", new ArrayList<String>());
			tabelaDeTransposicao.get("C").add("C#");
			tabelaDeTransposicao.get("C").add("_C");
			tabelaDeTransposicao.get("C").add("Db");
			tabelaDeTransposicao.get("C").add("D");
			tabelaDeTransposicao.get("C").add("D#");
			tabelaDeTransposicao.get("C").add("_D");
			tabelaDeTransposicao.get("C").add("Eb");
			tabelaDeTransposicao.get("C").add("E");
			tabelaDeTransposicao.get("C").add("E#");
			tabelaDeTransposicao.get("C").add("Fb");
			tabelaDeTransposicao.get("C").add("F");
			tabelaDeTransposicao.get("C").add("F#");
			tabelaDeTransposicao.get("C").add("_G");
			tabelaDeTransposicao.get("C").add("Gb");
			tabelaDeTransposicao.get("C").add("G");
			tabelaDeTransposicao.get("C").add("G#");
			tabelaDeTransposicao.get("C").add("_A");
			tabelaDeTransposicao.get("C").add("_G");
			tabelaDeTransposicao.get("C").add("Ab");
			tabelaDeTransposicao.get("C").add("A");
			tabelaDeTransposicao.get("C").add("A#");
			tabelaDeTransposicao.get("C").add("_A");
			tabelaDeTransposicao.get("C").add("Bb");
			tabelaDeTransposicao.get("C").add("B");
			tabelaDeTransposicao.get("C").add("B#");
			tabelaDeTransposicao.get("C").add("Cb");
			tabelaDeTransposicao.get("C").add("C");
					
			tabelaDeTransposicao.put("Db", new ArrayList<String>());
			tabelaDeTransposicao.get("Db").add("D");
			tabelaDeTransposicao.get("Db").add("D#");
			tabelaDeTransposicao.get("Db").add("_D");
			tabelaDeTransposicao.get("Db").add("Eb");
			tabelaDeTransposicao.get("Db").add("E");
			tabelaDeTransposicao.get("Db").add("E#");
			tabelaDeTransposicao.get("Db").add("Fb");
			tabelaDeTransposicao.get("Db").add("F");
			tabelaDeTransposicao.get("Db").add("F#");
			tabelaDeTransposicao.get("Db").add("_F");
			tabelaDeTransposicao.get("Db").add("Gb");
			tabelaDeTransposicao.get("Db").add("G");
			tabelaDeTransposicao.get("Db").add("G#");
			tabelaDeTransposicao.get("Db").add("_G");
			tabelaDeTransposicao.get("Db").add("Ab");
			tabelaDeTransposicao.get("Db").add("A");
			tabelaDeTransposicao.get("Db").add("A#");
			tabelaDeTransposicao.get("Db").add("_Ab");
			tabelaDeTransposicao.get("Db").add("_A");
			tabelaDeTransposicao.get("Db").add("Bb");
			tabelaDeTransposicao.get("Db").add("B");
			tabelaDeTransposicao.get("Db").add("B#");
			tabelaDeTransposicao.get("Db").add("Cb");
			tabelaDeTransposicao.get("Db").add("C");
			tabelaDeTransposicao.get("Db").add("C#");
			tabelaDeTransposicao.get("Db").add("_C");
			tabelaDeTransposicao.get("Db").add("Db");
			
			tabelaDeTransposicao.put("D", new ArrayList<String>());
			tabelaDeTransposicao.get("D").add("D#");
			tabelaDeTransposicao.get("D").add("_D");
			tabelaDeTransposicao.get("D").add("Eb");
			tabelaDeTransposicao.get("D").add("E");
			tabelaDeTransposicao.get("D").add("E#");
			tabelaDeTransposicao.get("D").add("Fb");
			tabelaDeTransposicao.get("D").add("F");
			tabelaDeTransposicao.get("D").add("F#");
			tabelaDeTransposicao.get("D").add("_G");
			tabelaDeTransposicao.get("D").add("Gb");
			tabelaDeTransposicao.get("D").add("G");
			tabelaDeTransposicao.get("D").add("G#");
			tabelaDeTransposicao.get("D").add("_A");
			tabelaDeTransposicao.get("D").add("Ab");
			tabelaDeTransposicao.get("D").add("A");
			tabelaDeTransposicao.get("D").add("A#");
			tabelaDeTransposicao.get("D").add("_B");
			tabelaDeTransposicao.get("D").add("_A");
			tabelaDeTransposicao.get("D").add("Bb");
			tabelaDeTransposicao.get("D").add("B");
			tabelaDeTransposicao.get("D").add("B#");
			tabelaDeTransposicao.get("D").add("Cb");
			tabelaDeTransposicao.get("D").add("C");
			tabelaDeTransposicao.get("D").add("C#");
			tabelaDeTransposicao.get("D").add("_D");
			tabelaDeTransposicao.get("D").add("Db");
			tabelaDeTransposicao.get("D").add("D");
			
			tabelaDeTransposicao.put("Eb", new ArrayList<String>());
			tabelaDeTransposicao.get("Eb").add("E");
			tabelaDeTransposicao.get("Eb").add("E#");
			tabelaDeTransposicao.get("Eb").add("Fb");
			tabelaDeTransposicao.get("Eb").add("F");
			tabelaDeTransposicao.get("Eb").add("F#");
			tabelaDeTransposicao.get("Eb").add("_F");
			tabelaDeTransposicao.get("Eb").add("Gb");
			tabelaDeTransposicao.get("Eb").add("G");
			tabelaDeTransposicao.get("Eb").add("G#");
			tabelaDeTransposicao.get("Eb").add("_G");
			tabelaDeTransposicao.get("Eb").add("Ab");
			tabelaDeTransposicao.get("Eb").add("A");
			tabelaDeTransposicao.get("Eb").add("A#");
			tabelaDeTransposicao.get("Eb").add("_A");
			tabelaDeTransposicao.get("Eb").add("Bb");
			tabelaDeTransposicao.get("Eb").add("B");
			tabelaDeTransposicao.get("Eb").add("B#");
			tabelaDeTransposicao.get("Eb").add("_Bb");
			tabelaDeTransposicao.get("Eb").add("Cb");
			tabelaDeTransposicao.get("Eb").add("C");
			tabelaDeTransposicao.get("Eb").add("C#");
			tabelaDeTransposicao.get("Eb").add("_C");
			tabelaDeTransposicao.get("Eb").add("Db");
			tabelaDeTransposicao.get("Eb").add("D");
			tabelaDeTransposicao.get("Eb").add("D#");
			tabelaDeTransposicao.get("Eb").add("_D");
			tabelaDeTransposicao.get("Eb").add("Eb");
			
			tabelaDeTransposicao.put("E", new ArrayList<String>());
			tabelaDeTransposicao.get("E").add("E#");
			tabelaDeTransposicao.get("E").add("Fb");
			tabelaDeTransposicao.get("E").add("F");
			tabelaDeTransposicao.get("E").add("F#");
			tabelaDeTransposicao.get("E").add("_G");
			tabelaDeTransposicao.get("E").add("Gb");
			tabelaDeTransposicao.get("E").add("G");
			tabelaDeTransposicao.get("E").add("G#");
			tabelaDeTransposicao.get("E").add("_A");
			tabelaDeTransposicao.get("E").add("Ab");
			tabelaDeTransposicao.get("E").add("A");
			tabelaDeTransposicao.get("E").add("A#");
			tabelaDeTransposicao.get("E").add("_B");
			tabelaDeTransposicao.get("E").add("Bb");
			tabelaDeTransposicao.get("E").add("B");
			tabelaDeTransposicao.get("E").add("B#");
			tabelaDeTransposicao.get("E").add("_C#");
			tabelaDeTransposicao.get("E").add("Cb");
			tabelaDeTransposicao.get("E").add("C");
			tabelaDeTransposicao.get("E").add("C#");
			tabelaDeTransposicao.get("E").add("_D");
			tabelaDeTransposicao.get("E").add("Db");
			tabelaDeTransposicao.get("E").add("D");
			tabelaDeTransposicao.get("E").add("D#");
			tabelaDeTransposicao.get("E").add("_E");
			tabelaDeTransposicao.get("E").add("Eb");
			tabelaDeTransposicao.get("E").add("E");
			
			tabelaDeTransposicao.put("F", new ArrayList<String>());
			tabelaDeTransposicao.get("F").add("F#");
			tabelaDeTransposicao.get("F").add("_F");
			tabelaDeTransposicao.get("F").add("Gb");
			tabelaDeTransposicao.get("F").add("G");
			tabelaDeTransposicao.get("F").add("G#");
			tabelaDeTransposicao.get("F").add("_G");
			tabelaDeTransposicao.get("F").add("Ab");
			tabelaDeTransposicao.get("F").add("A");
			tabelaDeTransposicao.get("F").add("A#");
			tabelaDeTransposicao.get("F").add("_A");
			tabelaDeTransposicao.get("F").add("Bb");
			tabelaDeTransposicao.get("F").add("B");
			tabelaDeTransposicao.get("F").add("B#");
			tabelaDeTransposicao.get("F").add("Cb");
			tabelaDeTransposicao.get("F").add("C");
			tabelaDeTransposicao.get("F").add("C#");
			tabelaDeTransposicao.get("F").add("_D");
			tabelaDeTransposicao.get("F").add("_C");
			tabelaDeTransposicao.get("F").add("Db");
			tabelaDeTransposicao.get("F").add("D");
			tabelaDeTransposicao.get("F").add("D#");
			tabelaDeTransposicao.get("F").add("_D");
			tabelaDeTransposicao.get("F").add("Eb");
			tabelaDeTransposicao.get("F").add("E");
			tabelaDeTransposicao.get("F").add("E#");
			tabelaDeTransposicao.get("F").add("Fb");
			tabelaDeTransposicao.get("F").add("F");
			
			tabelaDeTransposicao.put("F#", new ArrayList<String>());
			tabelaDeTransposicao.get("F#").add("_G");
			tabelaDeTransposicao.get("F#").add("Gb");
			tabelaDeTransposicao.get("F#").add("G");
			tabelaDeTransposicao.get("F#").add("G#");
			tabelaDeTransposicao.get("F#").add("_A");
			tabelaDeTransposicao.get("F#").add("Ab");
			tabelaDeTransposicao.get("F#").add("A");
			tabelaDeTransposicao.get("F#").add("A#");
			tabelaDeTransposicao.get("F#").add("_B");
			tabelaDeTransposicao.get("F#").add("Bb");
			tabelaDeTransposicao.get("F#").add("B");
			tabelaDeTransposicao.get("F#").add("B#");
			tabelaDeTransposicao.get("F#").add("Cb");
			tabelaDeTransposicao.get("F#").add("C");
			tabelaDeTransposicao.get("F#").add("C#");
			tabelaDeTransposicao.get("F#").add("_D");
			tabelaDeTransposicao.get("F#").add("_D#");
			tabelaDeTransposicao.get("F#").add("Db");
			tabelaDeTransposicao.get("F#").add("D");
			tabelaDeTransposicao.get("F#").add("D#");
			tabelaDeTransposicao.get("F#").add("_E");
			tabelaDeTransposicao.get("F#").add("Eb");
			tabelaDeTransposicao.get("F#").add("E");
			tabelaDeTransposicao.get("F#").add("E#");
			tabelaDeTransposicao.get("F#").add("Fb");
			tabelaDeTransposicao.get("F#").add("F");
			tabelaDeTransposicao.get("F#").add("F#");
			
			tabelaDeTransposicao.put("G", new ArrayList<String>());
			tabelaDeTransposicao.get("G").add("G#");
			tabelaDeTransposicao.get("G").add("_G");
			tabelaDeTransposicao.get("G").add("Ab");
			tabelaDeTransposicao.get("G").add("A");
			tabelaDeTransposicao.get("G").add("A#");
			tabelaDeTransposicao.get("G").add("_A");
			tabelaDeTransposicao.get("G").add("Bb");
			tabelaDeTransposicao.get("G").add("B");
			tabelaDeTransposicao.get("G").add("B#");
			tabelaDeTransposicao.get("G").add("Cb");
			tabelaDeTransposicao.get("G").add("C");
			tabelaDeTransposicao.get("G").add("C#");
			tabelaDeTransposicao.get("G").add("_D");
			tabelaDeTransposicao.get("G").add("Db");
			tabelaDeTransposicao.get("G").add("D");
			tabelaDeTransposicao.get("G").add("D#");
			tabelaDeTransposicao.get("G").add("_E");
			tabelaDeTransposicao.get("G").add("_D");
			tabelaDeTransposicao.get("G").add("Eb");
			tabelaDeTransposicao.get("G").add("E");
			tabelaDeTransposicao.get("G").add("E#");
			tabelaDeTransposicao.get("G").add("Fb");
			tabelaDeTransposicao.get("G").add("F");
			tabelaDeTransposicao.get("G").add("F#");
			tabelaDeTransposicao.get("G").add("_G");
			tabelaDeTransposicao.get("G").add("Gb");
			tabelaDeTransposicao.get("G").add("G");
			
			tabelaDeTransposicao.put("Ab", new ArrayList<String>());
			tabelaDeTransposicao.get("Ab").add("A");
			tabelaDeTransposicao.get("Ab").add("A#");
			tabelaDeTransposicao.get("Ab").add("_A");
			tabelaDeTransposicao.get("Ab").add("Bb");
			tabelaDeTransposicao.get("Ab").add("B");
			tabelaDeTransposicao.get("Ab").add("B#");
			tabelaDeTransposicao.get("Ab").add("Cb");
			tabelaDeTransposicao.get("Ab").add("C");
			tabelaDeTransposicao.get("Ab").add("C#");
			tabelaDeTransposicao.get("Ab").add("_C");
			tabelaDeTransposicao.get("Ab").add("Db");
			tabelaDeTransposicao.get("Ab").add("D");
			tabelaDeTransposicao.get("Ab").add("D#");
			tabelaDeTransposicao.get("Ab").add("_D");
			tabelaDeTransposicao.get("Ab").add("Eb");
			tabelaDeTransposicao.get("Ab").add("E");
			tabelaDeTransposicao.get("Ab").add("E#");
			tabelaDeTransposicao.get("Ab").add("_Eb");
			tabelaDeTransposicao.get("Ab").add("Fb");
			tabelaDeTransposicao.get("Ab").add("F");
			tabelaDeTransposicao.get("Ab").add("F#");
			tabelaDeTransposicao.get("Ab").add("_F");
			tabelaDeTransposicao.get("Ab").add("Gb");
			tabelaDeTransposicao.get("Ab").add("G");
			tabelaDeTransposicao.get("Ab").add("G#");
			tabelaDeTransposicao.get("Ab").add("_G");
			tabelaDeTransposicao.get("Ab").add("Ab");	

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
