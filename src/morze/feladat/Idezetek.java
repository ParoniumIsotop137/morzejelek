package morze.feladat;

public class Idezetek {

	private String szerzo;
	private String idezet;

	public Idezetek(String szerzo, String idezet) {
		this.szerzo = szerzo;
		this.idezet = idezet;
	}

	public String getSzerzo() {
		return szerzo;
	}

	public String getIdezet() {
		return idezet;
	}

	@Override
	public String toString() {
		return "Szerző: " + szerzo + ", idézet: " + this.idezet;
	}

}
