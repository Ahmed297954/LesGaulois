package village_gaulois;

import personnages.Gaulois;

public class Village {
  private String nom;
  private Gaulois chef;
  private int nbVillageois = 0;
  private Gaulois[] villageois;
  
  
  
  public Village(String nom,final int NB_VILLAGEOIS_MAX) {
	  this.nom = nom;
	  this.villageois = new Gaulois[NB_VILLAGEOIS_MAX];
  }
  
  public String getNom() {
	return nom;
  }
 
  public void setChef(Gaulois chef) {
	this.chef = chef;
	chef.setVillage(this);
  }
  public Gaulois getChef() {
	return chef;
}
  
  public void ajouterVillageois(Gaulois gaulois){
	  if(nbVillageois < villageois.length) {
	    villageois[nbVillageois] = gaulois;
	    nbVillageois++;
	    gaulois.setVillage(this);
	  }
	 
  }
  
  public Gaulois trouverVillageois(int numVillageois) {
	  if(numVillageois > nbVillageois || numVillageois < 1) {
		  System.out.println("Il n’y a pas autant d’habitants dans notre village !");
	      return null;
	  }else {
		  return villageois[numVillageois -1];
	  }
  }
  
  public void afficherVillage() {
	  System.out.println("Dans le village \"" + nom + "\" du chef "+ chef + " vivent les légendaires gaulois : \n");
	  for(Gaulois gaulois : villageois) {
		  if(gaulois != null) {
		    System.out.println(gaulois);
		  }
	  }
  }
  
  public static void main(String[] args) {
	  Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
	  Village village = new Village("Village des Irréductibles", 30);
	  village.setChef(abraracourcix);
	  village.trouverVillageois(30);
	  Gaulois asterix = new Gaulois("Astérix", 8);
	  village.ajouterVillageois(asterix);
	  Gaulois gaulois = village.trouverVillageois(1);
	  System.out.println(gaulois);
	  gaulois = village.trouverVillageois(2);
	  System.out.println(gaulois);
	  System.out.println("\n");
	  village.afficherVillage();
      Gaulois obelix = new Gaulois("Obélix", 25);
      village.ajouterVillageois(obelix);
      village.afficherVillage();
      Gaulois doublepolemix = new Gaulois("Doublepolémix", 4);
      abraracourcix.sePresenter();
      asterix.sePresenter();
      doublepolemix.sePresenter();
      
	  
	  
	  
	  
	  
  }
  
}
