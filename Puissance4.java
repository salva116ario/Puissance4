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
	static char[] jeton = { ' ', 'O', '@' };


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

			if (verifDiag()) {
				finPartie();
			}

			if (verifGrillePleine()) {
				partieNul();
			}

			joueurEnCours = (joueurEnCours == 1) ? 2 : 1;

		} while (!partieFinie);

	}


	public static void initJoueurs() {
		for (int i = 1; i < 3; i++) {
			System.out.println("Joueur " + (i) + " entrez votre prénom : ");
			joueur[i] = saisie.nextLine();
		}
		System.out.println(joueur[1] + " " + jeton[1] + "  vs  " + joueur[2] + " " + jeton[2]);
	}


	public static void tirageAuSort() {
		int hasard = (int) (Math.random() * 10);
		joueurEnCours = (hasard % 2 == 0) ? 1 : 2;
		System.out.println("C'est " + joueur[joueurEnCours] + " qui commence...\n");
	}


	public static void affichageGrille() {

		compteur++;
		System.out.println("\nTOUR NUMERO " + compteur);

		for (int i = nbLig - 1; i >= 0; i--) {

			for (int j = 0; j < nbCol; j++) {
				System.out.print("| " + jeton[grille[j][i]] + " ");
			}

			System.out.println("|");
		}

		for (int i = 0; i < nbCol; i++) {
			System.out.print("|---");
		}

		System.out.println("|");

		for (int i = 0; i < nbCol; i++) {
			System.out.print("| " + i + " ");
		}

		System.out.println("|");
	}


	public static void choixColonne() {
		int colChoix;
		boolean choixValide;

		do {
			System.out.println("\n" + joueur[joueurEnCours] + " (" + jeton[joueurEnCours]
					+ ") , veuillez choisir votre colonne : ");
			colChoix = saisie.nextInt();
			choixValide = true;
			if (grille[colChoix][nbLig - 1] != 0) {
				System.out.println("Erreur colonne pleine.");
				choixValide = false;
			}
		} while (choixValide == false);

		for (int i = 0; i < nbLig; i++) {
			if (grille[colChoix][i] == 0) {
				grille[colChoix][i] = joueurEnCours;
				ligneEnCours = i;
				i = nbLig;
				colEnCours = colChoix;
			}
		}
	}


	public static boolean verifHoriz() {

		int compteurJeton = 0;

		for (int i = 0; i < nbCol; i++) {

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

		for (int i = 0; i < nbLig; i++) {
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

		int colTest = colEnCours;
		int ligneTest = ligneEnCours;
		int compteurJeton = 1;
		boolean continueWhile = true;

		// verif première diagonale
		while (colTest > 0 && ligneTest > 0 && continueWhile) {
			colTest--;
			ligneTest--;

			if (grille[colTest][ligneTest] == joueurEnCours) {
				compteurJeton++;
			} else {
				continueWhile = false;
			}
		}

		continueWhile = true;
		colTest = colEnCours;
		ligneTest = ligneEnCours;
		while (colTest < nbCol - 1 && ligneTest < nbLig - 1 && continueWhile) {
			colTest++;
			ligneTest++;
			if (grille[colTest][ligneTest] == joueurEnCours) {
				compteurJeton++;
			} else {
				continueWhile = false;
			}
		}

		if (compteurJeton >= nbJetonsNecessaires) {
			return true;
		}


		// vérif deuxième diagonale
		compteurJeton = 1;
		continueWhile = true;
		colTest = colEnCours;
		ligneTest = ligneEnCours;
		while (colTest > 0 && ligneTest < nbLig - 1 && continueWhile) {
			colTest--;
			ligneTest++;
			if (grille[colTest][ligneTest] == joueurEnCours) {
				compteurJeton++;
			} else {
				continueWhile = false;
			}
		}

		continueWhile = true;
		colTest = colEnCours;
		ligneTest = ligneEnCours;
		while (colTest < nbCol - 1 && ligneTest > 0 && continueWhile) {
			colTest++;
			ligneTest--;
			if (grille[colTest][ligneTest] == joueurEnCours) {
				compteurJeton++;
			} else {
				continueWhile = false;
			}
		}
		if (compteurJeton >= nbJetonsNecessaires) {
			return true;
		}

		return false;
	}


	public static boolean verifGrillePleine() {
		return compteur == nbLig * nbCol;
	}


	public static void finPartie() {
		partieFinie = true;
		System.out.println("La partie est terminée : " + joueur[joueurEnCours] + " gagne");
	}


	public static void partieNul() {
		partieFinie = true;
		System.out.println("La grille est pleine, match nul");
	}

}
