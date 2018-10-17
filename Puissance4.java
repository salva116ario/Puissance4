public class Puissance4 {

public static void main(String[] args) {
    int col = 7;
    int lig = 6;
    int[][] grille = new int[col][lig];
    for (int i=0; i < lig; i++) {
      for (int j=0; j < col; j++) {
        System.out.print("|"+ j + "," + i);
      }
      System.out.println("|");
    }
}


}
