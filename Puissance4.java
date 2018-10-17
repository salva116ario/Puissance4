import java.util.Scanner;

public class Puissance4 {

static Scanner saisie;
static int nbCol = 7, nbLig = 6;
static int nbJetonsNecessaires = 4;
static int joueurEnCours = 1, ligneEnCours = 0, colEnCours = 0;
static int[][] grille = new int[nbCol][nbLig];
static String[] joueur = new String[3];
static int compteur = 0;
static boolean partieFinie = false;

public static void main(String[] args) {
        saisie = new Scanner(System.in);
        initJoueurs();
        tirageAuSort();
        affichageGrille();

          do {
          choixColonne();
          affichageGrille();
          if (verifHoriz()) {
            finPartie();
          }
          if (verifVertic()) {
            finPartie();
          }
          if (verifGrillePleine()){
            partieNul();
          }
          joueurEnCours =( joueurEnCours == 1) ? 2 : 1;
        } while(!partieFinie);

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
          joueurEnCours = 1;
        }
        else { joueurEnCours = 2;}
        System.out.println("C'est " + joueur[joueurEnCours] + " qui commence");
}

public static void affichageGrille() {

        compteur++;
        System.out.println("\nTOUR N°"+compteur);

        System.out.println("C'est à " + joueur[joueurEnCours] + " de jouer.");
        char jeton = ' ';

        for (int i= nbLig-1; i>=0; i--) {

          for (int j=0; j<nbCol; j++) {
            if (grille[j][i] == 0) {
              jeton = ' ';
            }
            if (grille[j][i] == 1) {
              jeton = '1';
            }
            if (grille[j][i] == 2) {
              jeton = '2';
            }
                        System.out.print("| "+jeton+" ");
          }
                System.out.println("|");
        }
        System.out.println("| 0 | 1 | 2 | 3 | 4 | 5 | 6 |");
}


public static void choixColonne(){
        int colChoix;
        boolean choixValide;
        do {
                System.out.println("Veuillez choisir votre colonne : ");
                colChoix= saisie.nextInt();
                choixValide = true;
                if (grille[colChoix][nbLig-1]!=0) {
                        System.out.println("Erreur colonne pleine.");
                        choixValide = false;
                }
        } while(choixValide == false);

        for (int i=0; i<nbLig; i++) {
                if (grille[colChoix][i]==0) {
                        grille[colChoix][i]=joueurEnCours;
                        ligneEnCours = i;
                        i = nbLig;
                        colEnCours = colChoix;
                }
        }
}

public static boolean verifHoriz() {
  int compteurJeton = 0;

  for (int i=0; i<nbCol; i++) {
    if (grille[i][ligneEnCours] != joueurEnCours) {
      compteurJeton = 0;
    }
    if (grille[i][ligneEnCours] == joueurEnCours) {
      compteurJeton++;
    }

    if (compteurJeton == nbJetonsNecessaires) {
      return true;
    }
  }
  return false;
}

public static boolean verifVertic() {
  int compteurJeton = 0;
  for (int i=0; i<nbLig; i++) {
    if (grille[colEnCours][i] != joueurEnCours) {
      compteurJeton = 0;
    }
    if (grille[colEnCours][i] == joueurEnCours) {
      compteurJeton++;
    }
    if (compteurJeton == nbJetonsNecessaires) {
      return true;
    }
  }
  return false;
}

public static boolean verifDiag() {
  int colTest = colEnCours,ligneTest = ligneEnCours;
  int compteurJeton = 1;
  boolean continueWhile;

  while (colTest>=0  && ligneTest>=0 && continueWhile) {
    colTest --;
    ligneTest --;
    if (grille[colTest][ligneTest] == joueurEnCours) {
      compteurJeton++;
    } else {
      continueWhile = false;
    }
    continueWhile = true;
  while (colTest<=nbCol && ligneTest<nbLig && continueWhile ) {
    colTest ++;
    ligneTest ++;
    if (grille[colTest][ligneTest] == joueurEnCours) {
      compteurJeton++;
      if (compteurJeton == nbJetonsNecessaires) {
        return true;
      }
    } else {
      continueWhile = false;
    }
  }

    return false;
  }



}


public static boolean verifGrillePleine() {
  return compteur == nbLig * nbCol;
}

public static void finPartie(){
  partieFinie = true;
  System.out.println("La partie est terminée : "+joueur[joueurEnCours]+" gagne");
}

public static void partieNul(){
  partieFinie = true;
  System.out.println("La grille est pleine, match nul");
}



}
