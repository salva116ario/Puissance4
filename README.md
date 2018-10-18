# Puissance4
Jeu de Puissance 4 - Simplon LPS 3

Ce jeu se joue à deux joueurs sur une grille de hauteur 6 et de largeur 7 (voir par exemple https://fr.wikipedia.org/wiki/Puissance₄). Les joueurs laissent tomber chacun leur tour un jeton dans une colonne. Lorsqu’un joueur aligne 4 jetons de sa couleur (en ligne ou en diagonale), il a gagné. Il peut arriver qu’aucun joueur ne parvienne à aligner 4 jetons, donnant lieu à un match nul.
La grille de jeu pourra être modélisée par un tableau de 6 lignes par 7 colonnes. Chaque case du tableau pouvant contenir l’information : case vide, case occupée par un jeton d’un joueur, case occupée par un jeton de l’autre joueur. Il faut choisir un type pour le tableau et un codage permettant de représenter ces informations.
_______________________________________________________________________

## CODAGE DE LA GRILLE DE JEU :

LIGNE 5   0,5   1,5   2,5   3,5   4,5   5,5   6,5
LIGNE 4   0,4   1,4   2,4   3,4   4,4   5,4   6,4
LIGNE 3   0,3   1,3   2,3   3,3   4,3   5,3   6,3
LIGNE 2   0,2   1,2   2,2   3,2   4,2   5,2   6,2
LIGNE 1   0,1   1,1   2,1   3,1   4,1   5,1   6,1
LIGNE 0   0,0   1,0   2,0   3,0   4,0   5,0   6,0
          COL0  COL1  COL2  COL3  COL4  COL5  COL6

Les variables nbCol, nbLig et nbJetonsNecessaires sont modifiables pour que le jeu puisse être évolutif.
On pourra changer le nombre de colonnes et de lignes du tableau, ainsi que le nombre de jetons à aligner pour gagner.

_______________________________________________________________________

## INITIALISATION DU JEU      
A. INIT GRILLE DE JEU & INIT DEUX JOUEURSS
   Pour simplifier le code, on utilise joueur[1] & joueur[2] à qui on associe un jeton[1] ('O') et un jeton[2] ('@'). On remplira les cases du tableau avec la valeur 1 ou 2 correspondant au joueur qui a posé un jeton dans telle case. 0 correspondra à une case vide (valeur par défaut de toutes les cases au début du jeu).

B. TIRAGE AU SORT pour savoir qui démarre la partie.
__________________________________________________________________________


## UN TOUR DE JEU LAMBDA
1. ON AFFICHE LA GRILLE
2. AFFICHER LE NOM DU JOUEUR ET LUI DEMANDER SON CHOIX DE COLONNE
   Try/Catch pour gérer les exceptions : saisie d'une lettre au lieu d'un nombre / saisie d'une colonne hors grille
3. VERIFIER SI UNE PLACE EST LIBRE DANS LA COLONNE (= vérifier si la ligne 5 de la colonne choisie est libre)
   SI NON - > REVENIR A (2)
4. ON PLACE LE JETON DANS LA COLONNE
   Les variables ligneEnCours et colEnCours vont permettre d'effectuer les vérifications qui suivent à partir de la position du dernier jeton posé

## VERIFICATIONS FIN DE PARTIE
5. VERIF HORIZONTALE
   On passe en revue la ligne où le dernier jeton a été posé : si 4 jetons du joueur venant de jouer sont alignés, la partie s'arrête avec un message de vitctoire.
6. VERIF VERTICALE
   Idem que la verif horizontale sur la colonne où le dernier jeton a été posé.
7. VERIF DIAGONALE
   On part de la position du dernier jeton posé, et on vérifie le contenu des cases en diagonale, d'abord vers le haut puis vers le bas (chaque diagonale nécessite donc deux boucles while successives), et ce pour les deux diagonales.
   On boucle toutes les cases possibles et on vérifie l'alignement du nombre nécessaire de jetons pour gagner avec un système de compteur.
8. VERIF GRILLE PLEINE
   Chaque affichage de grille incrémente un compteur. Si le compteur indique que toutes les cases ont été remplies sans qu'il y ait eu un vainqueur, on termine la partie sur un match nul.
__________________________________________________________________________
  Si aucune méthode de vérif n'a provoqué la fin de la partie accompagnée d'un message de victoire ou de match nul =>
## ON CHANGE DE JOUEUR ET ON REVIENT A (1) POUR UN NOUVEAU TOUR DE JEU
__________________________________________________________________________
