import java.util.*;

public class mainClass {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int v = in.nextInt();
    int e = in.nextInt();
    if(e < (v/2) || e > ((v*v-v)/2)) {
      System.out.println("Dont mess with us, you're out of bounds");
      e = in.nextInt();
    }

    graphGen game1 = new graphGen(v,e);

    int[][] gameMatrix = game1.getMatrix();


    for(int i = 0; i < gameMatrix.length; i++) {
      for(int j = 0; j < gameMatrix.length; j++) {
        System.out.print(gameMatrix[i][j] + " ");
      }
      System.out.println();
    }


  }
}
