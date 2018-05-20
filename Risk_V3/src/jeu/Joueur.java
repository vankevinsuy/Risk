package jeu;

public class Joueur {
	private String icone;
	private String name;

	public Joueur(String icone, String name) {
		super();
		this.icone = icone;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getIcone() {
		return icone;
	}
}
