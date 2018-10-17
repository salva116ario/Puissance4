import java.util.Scanner;

public class Puissance4 {

  static Scanner saisie;
  static int nbCol = 7, nbLig =6;
  static int[][] grille = new int[nbCol][nbLig];
  static String[] joueur = new String[2];

public static void main(String[] args) {
  saisie = new Scanner(System.in);
  initJoueurs();


}

  public static void initJoueurs() {
    for (int i=0; i<2; i++) {
      System.out.println("Joueur " + (i+1) + " entrez votre prénom : ");
      joueur[i] = saisie.nextLine();
    }
    System.out.println(joueur[0] + " / " + joueur[1]);
  }


}
