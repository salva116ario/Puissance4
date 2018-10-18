# Puissance4
Jeu de Puissance 4 - Simplon LPS 3

Ce jeu se joue à deux joueurs sur une grille de hauteur 6 et de largeur 7 (voir par exemple https://fr.wikipedia.org/wiki/Puissance₄). Les joueurs laissent tomber chacun leur tour un jeton dans une colonne. Lorsqu’un joueur aligne 4 jetons de sa couleur (en ligne ou en diagonale), il a gagné. Il peut arriver qu’aucun joueur ne parvienne à aligner 4 jetons, donnant lieu à un match nul.

La grille de jeu pourra être modélisée par un tableau de 6 lignes par 7 colonnes. Chaque case du tableau pouvant contenir l’information : case vide, case occupée par un jeton d’un joueur, case occupée par un jeton de l’autre joueur. Il faut choisir un type pour le tableau et un codage permettant de représenter ces informations.


CODAGE DE LA GRILLE DE JEU :

LIGNE 5   0,5   1,5   2,5   3,5   4,5   5,5   6,5
LIGNE 4   0,4   1,4   2,4   3,4   4,4   5,4   6,4
LIGNE 3   0,3   1,3   2,3   3,3   4,3   5,3   6,3
LIGNE 2   0,2   1,2   2,2   3,2   4,2   5,2   6,2
LIGNE 1   0,1   1,1   2,1   3,1   4,1   5,1   6,1
LIGNE 0   0,0   1,0   2,0   3,0   4,0   5,0   6,0
          COL0  COL1  COL2  COL3  COL4  COL5  COL6

_______________________________________________________________________

## INIT DU JEU      
A. INIT GRILLE DE JEU + CREER DEUX JOUEURS
   Saisie prénoms : joueur1 / joueur2
B. TIRAGE AU SORT : qui démarre la partie ?
   On attribue un SYMBOLE de jeton à chaque joueur
__________________________________________________________________________


## UN TOUR DE JEU LAMBDA
1. AFFICHER GRILLE
2. AFFICHER LE NOM DU JOUEUR ET LUI DEMANDER SON CHOIX DE COLONNE
3. VERIFIER SI UNE PLACE EST LIBRE DANS LA COLONNE
   SI NON - > REVENIR A (2)
4. ON PLACE LE JETON DANS LA COLONNE
  ## VERIFICATIONS FIN DE PARTIE
5. VERIF HORIZONTALE
6. VERIF VERTICALE
7. VERIF DIAGONALE
8. VERIF GRILLE PLEINE ?
__________________________________________________________________________

  UN JOUEUR A GAGNE ? => MESSAGE DE VICTOIRE => FIN DU JEU
## SINON => CHANGEMENT DE JOUEUR ET RETOUR A (1)
__________________________________________________________________________
