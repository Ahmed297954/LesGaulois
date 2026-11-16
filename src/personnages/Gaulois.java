package personnages;

import objets.Equipement;
import village_gaulois.Musee;
import village_gaulois.Village;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private Village village;

	private int force ;
	private int nbTrophees = 0;
	private Equipement[] trophees = new Equipement[100];
	

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}



	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}


	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophees = romain.recevoirCoup((force / 2) * effetPotion);
		effetPotion--;
		if (effetPotion < 1) {
			effetPotion = 1;
		}
		for (int i = 0; trophees != null && i < trophees.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophees[i];
		}
	}
    
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public void sePresenter() {
		if (village == null) {
			parler("Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.");
		} else if (village.getChef() == this) {
			parler("Bonjour, je m'appelle " + nom + " . Je suis le chef le village : " + village.getNom() + ".");
		} else {
			parler("Bonjour, je m'appelle " + nom + " . J'habite dans le village : " + village.getNom() + ".");
		}
	}
	
	
	public void faireUneDonnation(Musee musee) {
		if(nbTrophees > 0) {
			String texte = "Je donne au musee tous mes trophees : \n";
			for(int i =0 ; i< nbTrophees; ++i) {
				musee.donnerTrophees(this, trophees[i]);
				texte += "- "+ trophees[i]+"\n";
			}
			nbTrophees = 0;
			parler(texte);
		}
	}
	
	

}



