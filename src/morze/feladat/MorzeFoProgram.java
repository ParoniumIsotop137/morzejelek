package morze.feladat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MorzeFoProgram {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		FajlKezeles fajl = new FajlKezeles();
		Feladatok feladat = new Feladatok();

		List<MorzeKod> kodok = new ArrayList<MorzeKod>();
		List<Idezetek> idezet = new ArrayList<Idezetek>();

		kodok = fajl.AbcBeolvasas("F:\\Kurs\\Feladatok\\MorzeJelek\\morzeabc.txt", "\t");

		// kodok.stream().forEach(System.out::println);

		System.out.println("3. feladat: A morze abc " + kodok.size() + " db karakter kódját tartalmazza.");
		System.out.print("\n4. feladat: Kérek egy karaktert: ");
		String valasz = sc.nextLine();
		feladat.KarakterKereses(kodok, valasz);

		idezet = fajl.IdezetekBeolvasasa("F:\\Kurs\\Feladatok\\MorzeJelek\\morze.txt", ";");

		// idezet.stream().forEach(System.out::println);

		System.out.println(
				"\n7. feladat: Az első idézet szerzője: " + feladat.Morze2Szoveg(idezet.get(0).getSzerzo(), kodok));

		System.out.println("\n8. feladat: A leghosszabb idézet szerzője és az idézet: "
				+ feladat.LeghosszabbIdezet(idezet, kodok));

		System.out.println("\n9. feladat: Arisztotelész idézetei: ");
		feladat.KikeresIdezeteket(idezet, kodok);
		fajl.FajlbaIras(idezet, kodok, "F:\\Kurs\\Feladatok\\MorzeJelek\\forditas.txt");
		System.out.println("\n10. feladat: forditas.txt");
	}

}
