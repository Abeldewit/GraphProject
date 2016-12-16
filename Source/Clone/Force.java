public class Force{

	private static int chr;
	
	public Force(int v, int e, int[][] graph){

		int M = 0; // Number of colors
		GraphColoring n = new GraphColoring();
		
		System.out.println("entered graph coloring");
		while(n.graphColor(graph,M) == 0){
		 	M++;
		}
		
		System.out.println(n.graphColor(graph,M));
		M = n.graphColor(graph,M);
		System.out.println("Chromatic number:"+M);
		
		this.chr = M;
	}
	
	public int getChr(){
		return chr;
	}
}
class GraphColoring
{
    private int V, numOfColors;
    private int[] color;
    private int[][] graph;

    /** Function to assign color **/
    public int graphColor(int[][] g, int noc)
    {
        V = g.length;
        numOfColors = noc;
        color = new int[V];
        graph = g;

        try
        {
            solve(0);
            System.out.println("No solution");
						return 0;
        }
        catch (Exception e)
        {
            System.out.println("\nSolution exists ");
            int chroma = display();
						return chroma;
        }
    }
    /** function to assign colors recursively **/
    public void solve(int v) throws Exception
    {
        /** base case - solution found **/
        if (v == V)
            throw new Exception("Solution found");
        /** try all colours **/
        for (int c = 1; c <= numOfColors; c++)
        {
            if (isPossible(v, c))
            {
                /** assign and proceed with next vertex **/
                color[v] = c;
                solve(v + 1);
                /** wrong assignement **/
                color[v] = 0;
            }
        }
    }
    /** function to check if it is valid to allot that color to vertex **/
    public boolean isPossible(int v, int c)
    {
        for (int i = 0; i < V; i++)
            if (graph[v][i] == 1 && c == color[i])
                return false;
        return true;
    }
    /** display solution **/
    public int display()
    {
				int max=0;
        System.out.print("\nColors : ");
        for (int i = 0; i < V; i++)
            System.out.print(color[i] +" ");
        System.out.println();
				for (int i = 0; i<V; i++ ) {
						if(color[i] > max) {
							max = color[i];
						}
				}
				return max;
    }
}
