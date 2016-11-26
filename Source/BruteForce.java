public class BruteForce {
  public static void main(String[] args) {
    int colourAmount = 1;
    int[] colourArray = new int[n];

    for(int i = 0; i < n; i++) {
      colourArray[i] = 0;
    }

    int testCase = 10;
    boolean whilebool = true;
    boolean firsttry = true;

    //calculate upper bound to prevent redundant calculations
    int upperBound = (int) Math.sqrt(2*m) + 1;

    int low = 0;
    int high = upperBound;

    //binary search (start in the middle, if that colour works go lower, if it doesnt go higher )
    while(high >= low)
    {
      int middle = (low + high) / 2;
      System.out.println("Testing " + middle);
      graphColour(0,adjecentMatrix,n,middle,colourArray);
      if(test == true)
      {
        high = middle -1;
      }
      if(test == false)
      {
        low = middle + 1;
      }
    }

   System.out.println("Got it!");
   //graphColour(0,adjecentMatrix,n,testCase,colourArray);

 }

 public static void graphColour(int k,int[][] G, int n, int m, int[] x)
 {
   test = false;
   boolean sufficientC = true;
//color ok
   for(int c = 1; c <= m; c++)
   {
   //	System.out.println("    Testing colour " + c);
       if(isSafe(k,c,G,n,x))
       {
         x[k] = c; if(k+1 < n)
         {
           graphColour(k+1,G,n,m,x);
         } else
         {
           //vertex
           for(int z = 0; z < n; z++)
           {

          //		System.out.println("        Testing vertex " + z);

             if(x[z] != 0)
             {
               //System.out.println("Sufficient colours");
           //		System.out.print(x[k]);
               test = true;
               sufficientC = true;

             } else
             {
           //		System.out.println("Too little colours");
               sufficientC = false;
             }

           }
         }
       }

   }
 }




 public static boolean isSafe(int k, int c,int[][] G, int n, int[] x)
 {
   for(int i = 0; i <  n; i++)
   {
     if(G[k][i] == 1 && c == x[i])
     {
       return false;
     }
   }
   return true;
 }

  }
}
