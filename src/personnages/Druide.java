package personnages;

public class Druide {
  private String nom;
  private int effetPotion = 1;
  private Chaudron chaudron;
  
  private String prendreParole() {
	  return "Le druide "+ nom + ":";
  }
  public void parler(String texte) {
	 System.out.println(prendreParole() + "\"" + texte + "\""); 
  }
  
  
  
  public Druide(String nom, int effetPotion) {
	this.nom = nom;
	this.effetPotion = effetPotion;
	this.chaudron = new Chaudron();
}
  public void fabriquerPotion(int quantite, int forcePotion) {
	  chaudron.remplirChaudron(quantite,forcePotion);
      parler("J'ai concoté " + quantite + " doses de potion magique. Elle a une force de " + forcePotion +	".");
  }
  
  public void booster(Gaulois gaulois) {
	  boolean contientPotion = chaudron.resterPotion();
	  String nomGaulois = gaulois.getNom();
      if(contientPotion) {
    	if (nomGaulois.equals("Obélix")) {
		  parler("Non, " + nomGaulois +" Non!...Et tu le sais très bien!");
		} else {
          int forcePotion = chaudron.prendreLouche();
		  gaulois.boirePotion(forcePotion);
		  parler("Tiens "+ nomGaulois + " un peu de potion magique.");
		}  
      }else {
    	parler("Désolé " + nomGaulois + " il n'y a plus une seule goote de potion.");
      }
  
  }
  
  public String getNom() {
	return nom;
  }
}
