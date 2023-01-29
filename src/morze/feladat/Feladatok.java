package morze.feladat;

import java.util.List;

public class Feladatok {

	public void KarakterKereses(List<MorzeKod> kodok, String valasz) {

		int i = 0;

		while (i < kodok.size() && !kodok.get(i).getBetuJel().equals(valasz)) {
			i++;
		}
		if (i < kodok.size()) {
			System.out.println("A " + valasz + " karakter morze kódja: " + kodok.get(i).getMorzeJel());
		} else {
			System.out.println("Nem található a kódtárban ilyen karakter!");
		}

	}

	public String Morze2Szoveg(String szoveg, List<MorzeKod> kodok) {

		String[] betuk = szoveg.split("   ");
		StringBuilder kiiras = new StringBuilder();

		for (int i = 0; i < betuk.length; i++) {
			for (MorzeKod item : kodok) {
				if (betuk[i].equals(item.getMorzeJel())) {
					kiiras.append(item.BetuKodolas(betuk[i]));
				}
			}
		}

		return kiiras.toString();

	}

	public String LeghosszabbIdezet(List<Idezetek> idezet, List<MorzeKod> kodok) {

		int max = 0;

		for (int i = 0; i < idezet.size(); i++) {
			if (idezet.get(i).getIdezet().length() > idezet.get(max).getIdezet().length()) {
				max = i;
			}
		}

		Idezetek szoveg = idezet.get(max);

		StringBuilder kiiras = new StringBuilder();
		kiiras.append(Morze2Szoveg(szoveg.getSzerzo(), kodok) + " : ");
		kiiras.append(IdezetKodolas(idezet.get(max).getIdezet(), kodok));
		return kiiras.toString();

	}

	public String IdezetKodolas(String idezet, List<MorzeKod> kodok) {

		StringBuilder kiiras = new StringBuilder();

		String[] szavak = idezet.split("       ");

		for (int i = 0; i < szavak.length; i++) {
			kiiras.append(Morze2Szoveg(szavak[i], kodok) + " ");
		}

		return kiiras.toString();

	}

	public void KikeresIdezeteket(List<Idezetek> idezet, List<MorzeKod> kodok) {

		StringBuilder kiiras = new StringBuilder();

		for (Idezetek item : idezet) {
			if (item.getSzerzo().equals(idezet.get(0).getSzerzo())) {
				kiiras.append("- " + IdezetKodolas(item.getIdezet(), kodok) + "\n");
			}
		}
		System.out.println(kiiras.toString());

	}

}
