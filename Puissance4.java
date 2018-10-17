import java.util.Scanner;

public class Puissance4 {

  static Scanner saisie;
  static int nbCol = 7, nbLig =6;
  static int[][] grille = new int[nbCol][nbLig];
  static String[] joueur = new String[3];
  static int joueurEnCours = 1;

public static void main(String[] args) {
  saisie = new Scanner(System.in);
  initJoueurs();
  tirageAuSort();


}

  public static void initJoueurs() {
    for (int i=1; i<3; i++) {
      System.out.println("Joueur " + (i) + " entrez votre prénom : ");
      joueur[i] = saisie.nextLine();
    }
    System.out.println(joueur[1] + " / " + joueur[2]);
  }

  public static void tirageAuSort() {
    int hasard = (int)(Math.random() * 10);
    System.out.println(hasard);
    if (hasard%2==0) {
      joueurEnCours = 1;}
    else { joueurEnCours = 2;}
    System.out.println("C'est " + joueur[joueurEnCours] + " qui commence");
  }

  
}
