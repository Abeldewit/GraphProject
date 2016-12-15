public class testAlgo{
	public static void main(String[] args){
		
		int v = 16;
		int e = 110;
		
		graphGen randomgraph = new graphGen(v, e);
		int[][] graph = randomgraph.getMatrix();
		
		Track Chr = new Track();
		
		int M = 0; // Number of colors
			
		while(!Chr.graphColoring(graph, M, v)){
			M++;
		}
		
		System.out.println("Chromatic number:"+M);
	}
}