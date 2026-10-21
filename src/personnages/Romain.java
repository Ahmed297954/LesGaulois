package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	
	Equipement[] equipements = new Equipement[2];
    private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified() : "La force d'un romain doit être positive";
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0 : "La force du coup doit être négatif";

		int forceInitiale = force;

		force -= forceCoup;
		if (force < 1) {
			force = 0;
			parler("J'abandonne !");
		} else {
			parler("Aïe");
		}
		assert forceInitiale > force : "La force du romain n'a pas diminué";

		assert isInvariantVerified() : "La force du romain est devenue négative";
	}

	public boolean isInvariantVerified() {
		return force >= 0;
	}
	
	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
		case 2:
			System.out.println("Le soldat "+nom+" est déjà bien protégé !");
		    break;
		case 1:
			if(equipement == equipements[0]) {
				System.out.println("Le soldat "+nom+" possède déjà un "+equipement+" !");
			    break;
			}
		case 0:
			equipements[nbEquipement] = equipement;
			nbEquipement++;
			System.out.println("Le soldat "+nom+" s’équipe avec un "+equipement+".");
		    break;
		default :
		    break;
		}
	}
	
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);

	}

}