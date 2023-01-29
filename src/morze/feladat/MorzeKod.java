package morze.feladat;

public class MorzeKod {

	private String betuJel;
	private String morzeJel;

	public MorzeKod(String betuJel, String morzeJel) {
		this.betuJel = betuJel;
		this.morzeJel = morzeJel;
	}

	public String getBetuJel() {
		return betuJel;
	}

	public String getMorzeJel() {
		return morzeJel;
	}

	public String BetuKodolas(String jelzes) {

		String forditas;

		if (jelzes.equals(morzeJel)) {
			forditas = this.betuJel;
		} else {
			forditas = "";
		}

		return forditas;

	}

	@Override
	public String toString() {

		return "Betű: " + this.betuJel + ", morzejel:  " + this.morzeJel;
	}

}
