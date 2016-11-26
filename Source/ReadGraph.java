import java.io.*;
import java.util.*;

		class ColEdge
			{
			int u;
			int v;
			}

public class ReadGraph
		{
		public int n;
		public int[] x;
		public int[][]G;
		public static boolean test = true;

		public final static boolean DEBUG = false;

		public final static String COMMENT = "//";

		public static void main( String args[] )
			{
			if( args.length < 1 )
				{
				System.out.println("Error! No filename specified.");
				System.exit(0);
				}


			String inputfile = args[0];

			boolean seen[] = null;

			//! n is the number of vertices in the graph
			int n = -1;

			//! m is the number of edges in the graph
			int m = -1;

			//! e will contain the edges of the graph
			ColEdge e[] = null;

			try 	{
			    	FileReader fr = new FileReader(inputfile);
			        BufferedReader br = new BufferedReader(fr);

			        String record = new String();

					//! THe first few lines of the file are allowed to be comments, staring with a // symbol.
					//! These comments are only allowed at the top of the file.

					//! -----------------------------------------
			        while ((record = br.readLine()) != null)
						{
						if( record.startsWith("//") ) continue;
						break; // Saw a line that did not start with a comment -- time to start reading the data in!
						}

					if( record.startsWith("VERTICES = ") )
						{
						n = Integer.parseInt( record.substring(11) );
						if(true) System.out.println(COMMENT + " Number of vertices = "+n);
						}

					seen = new boolean[n+1];

					record = br.readLine();

					if( record.startsWith("EDGES = ") )
						{
						m = Integer.parseInt( record.substring(8) );
						if(true) System.out.println(COMMENT + " Expected number of edges = "+m);
						}

					e = new ColEdge[m];

					for( int d=0; d<m; d++)
						{
						if(DEBUG) System.out.println(COMMENT + " Reading edge "+(d+1));
						record = br.readLine();
						String data[] = record.split(" ");
						if( data.length != 2 )
								{
								System.out.println("Error! Malformed edge line: "+record);
								System.exit(0);
								}
						e[d] = new ColEdge();

						e[d].u = Integer.parseInt(data[0]);
						e[d].v = Integer.parseInt(data[1]);

						seen[ e[d].u ] = true;
						seen[ e[d].v ] = true;

						if(DEBUG) System.out.println(COMMENT + " Edge: "+ e[d].u +" "+e[d].v);

						}

					String surplus = br.readLine();
					if( surplus != null )
						{
						if( surplus.length() >= 2 ) if(DEBUG) System.out.println(COMMENT + " Warning: there appeared to be data in your file after the last edge: '"+surplus+"'");
						}

					}
			catch (IOException ex)
				{
		        // catch possible io errors from readLine()
			    System.out.println("Error! Problem reading file "+inputfile);
				System.exit(0);
				}

			for( int x=1; x<=n; x++ )
				{
				if( seen[x] == false )
					{
					if(DEBUG) System.out.println(COMMENT + " Warning: vertex "+x+" didn't appear in any edge : it will be considered a disconnected vertex on its own.");
					}
				}

			//! At this point e[0] will be the first edge, with e[0].u referring to one endpoint and e[0].v to the other
			//! e[1] will be the second edge...
			//! (and so on)
			//! e[m-1] will be the last edge
			//!
			//! there will be n vertices in the graph, numbered 1 to n

			//! INSERT YOUR CODE HERE!

			//declare
			int NUM_VERTECIES = n;
			int[] num_of_connected_edges = new int[NUM_VERTECIES];
			int[][] adjecentMatrix = new int[n][n];
			Scanner in = new Scanner(System.in);
			System.out.println("There are " + n + " verticies");

			 //Printing out every edge
			 /*
			 for(int i = 0; i < m; i++)
			 {
				 System.out.println("Edge " + (i+1) + " connects " + e[i].u + " and " +e[i].v);
			 }
			 */

			 //make the matrix
			 for(int i = 0; i < m; i++)
			 {
				 adjecentMatrix[e[i].u-1][e[i].v-1] = 1;
				 adjecentMatrix[e[i].v-1][e[i].u-1] = 1;
			 }

			 //printing the matrix
			 /*
			 System.out.println(); for(int i = 0; i < adjecentMatrix.length; i++) {
			 for(int j = 0; j < adjecentMatrix.length; j++) {
			 System.out.print(adjecentMatrix[i][j] + "   "); } System.out.println(); }
			 */

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
