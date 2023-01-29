package morze.feladat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class FajlKezeles {

	public List<MorzeKod> AbcBeolvasas(String fajlnev, String elvalaszto) {

		List<MorzeKod> kodok = new ArrayList<MorzeKod>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev), "UTF-8"))) {

			br.readLine();
			while (br.ready()) {

				String[] sor = br.readLine().split(elvalaszto);

				MorzeKod kod = new MorzeKod(sor[0], sor[1]);
				kodok.add(kod);

			}

		} catch (Exception e) {
			System.err.println("Hiba a fájl olvasásakor!");
		}

		return kodok;
	}

	public List<Idezetek> IdezetekBeolvasasa(String fajlnev, String elvalaszto) {

		List<Idezetek> idezet = new ArrayList<Idezetek>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev), "UTF-8"))) {

			while (br.ready()) {

				String[] sor = br.readLine().split(elvalaszto);

				Idezetek egysor = new Idezetek(sor[0], sor[1]);
				idezet.add(egysor);

			}

		} catch (Exception e) {
			System.err.println("Hiba a fájl olvasásakor!");
		}

		return idezet;
	}

	public void FajlbaIras(List<Idezetek> idezet, List<MorzeKod> kodok, String fajlnev) {

		Feladatok feladat = new Feladatok();

		StringBuilder kiiras = new StringBuilder();

		try (OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fajlnev, false), "UTF-8")) {

			for (Idezetek item : idezet) {
				kiiras.append(feladat.Morze2Szoveg(item.getSzerzo(), kodok) + " : ");
				kiiras.append(feladat.IdezetKodolas(item.getIdezet(), kodok) + "\n");
			}

			out.write(kiiras.toString());

		} catch (Exception e) {
			System.err.println("Hiba az adatok fájlba írásakor!");
		}

	}

}
