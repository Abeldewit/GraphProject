import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.io.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;

public class Drawer extends JPanel{
<<<<<<< HEAD

	private VertexShape[] vertecies;
	private EdgeShape[] edges;

=======
	
	private VertexShape[] vertecies;
	private EdgeShape[] edges;
	
>>>>>>> origin/master
	private static JLabel chrField = new JLabel();
	private static JTextField vertexField = new JTextField(5);
	private static JTextField edgeField = new JTextField(5);
	private static JButton startButton = new JButton("generate");
	private static JPanel graphicPanel;
<<<<<<< HEAD

	private static int chromatic_number = 0;

	public Drawer() {

=======
	
	private static int chromatic_number = 0;
	
	public Drawer() {
		
>>>>>>> origin/master
		graphicPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try{
<<<<<<< HEAD
					BufferedImage image = ImageIO.read(new File("resources/background5.jpeg"));
=======
					BufferedImage image = ImageIO.read(new File("Resources/background5.jpeg"));
>>>>>>> origin/master
					g.drawImage(image, 0, 0, null);
				}catch(IOException e) {e.printStackTrace();}
            }
        };
<<<<<<< HEAD

		class StartButtonListener implements ActionListener{

			public void actionPerformed(ActionEvent event){

				Graphics g = graphicPanel.getGraphics();
				Graphics2D g_2D = (Graphics2D) g;

				drawBackground();

				//collecting the input
				int e = Integer.parseInt(edgeField.getText());
				int v = Integer.parseInt(vertexField.getText());

				//generating random graph
				graphGen randomgraph = new graphGen(v, e);
				int[][] adjacencyMatrix = randomgraph.getMatrix();

				//bruteforcing solution


=======
		
		class StartButtonListener implements ActionListener{
			
			public void actionPerformed(ActionEvent event){
				
				Graphics g = graphicPanel.getGraphics();
				Graphics2D g_2D = (Graphics2D) g;
				
				drawBackground();
				
				//collecting the input
				int e = Integer.parseInt(edgeField.getText());
				int v = Integer.parseInt(vertexField.getText());
				
				//generating random graph
				graphGen randomgraph = new graphGen(v, e);
				int[][] adjacencyMatrix = randomgraph.getMatrix();
				
				//bruteforcing solution
				
				
>>>>>>> origin/master
				//defining the new set
				GraphShape graph = new GraphShape(v,e,adjacencyMatrix);
				vertecies = graph.getVertecies();
				edges = graph.getEdges();
<<<<<<< HEAD

=======
				
>>>>>>> origin/master
				//drawing the edges
				for(int i=0;i<edges.length;i++){
					drawEdge(edges[i]);
				}
<<<<<<< HEAD

=======
				
>>>>>>> origin/master
				//drawing the vertecies
				for(int i=0;i<vertecies.length;i++){
					drawVertex(vertecies[i]);
				}
			}
		}
		//listener
		class MousePressListener implements MouseListener{

			public void mousePressed(MouseEvent event) {

				changeColor(event);
				updateHint();
			}
			public void mouseReleased(MouseEvent event) {}
			public void mouseClicked(MouseEvent event){}
			public void mouseEntered(MouseEvent event){}
			public void mouseExited(MouseEvent event) {}
		}
		startButton.addActionListener(new StartButtonListener());
		graphicPanel.addMouseListener(new MousePressListener());
	}
<<<<<<< HEAD

	public void drawBackground(){

		//accessing the graphicPanel
		Graphics g = graphicPanel.getGraphics();
		Graphics2D g_2D = (Graphics2D) g;

		g_2D.setStroke(new BasicStroke( 4.0F ));

		//redrawing empty background
		try{
			BufferedImage image = ImageIO.read(new File("resources/background5.jpeg"));
			g.drawImage(image, 0, 0, null);
		}catch(IOException ex) {ex.printStackTrace();}

	}

	public void drawVertex( VertexShape vertex ){

		//accessing the graphicPanel
		Graphics g = graphicPanel.getGraphics();
		Graphics2D g_2D = (Graphics2D) g;

=======
	
	public void drawBackground(){
		
		//accessing the graphicPanel
		Graphics g = graphicPanel.getGraphics();
		Graphics2D g_2D = (Graphics2D) g;
		
		g_2D.setStroke(new BasicStroke( 4.0F ));
				
		//redrawing empty background
		try{
			BufferedImage image = ImageIO.read(new File("Resources/background5.jpeg"));
			g.drawImage(image, 0, 0, null);
		}catch(IOException ex) {ex.printStackTrace();}
		
	}
	
	public void drawVertex( VertexShape vertex ){
		
		//accessing the graphicPanel
		Graphics g = graphicPanel.getGraphics();
		Graphics2D g_2D = (Graphics2D) g;
		
>>>>>>> origin/master
		//drawing shapes
		g_2D.setColor(Color.black);
		g_2D.draw(vertex.getShape());
		g_2D.setColor(vertex.getColor());
		g_2D.fill(vertex.getShape());
<<<<<<< HEAD

	}

	public void drawEdge( EdgeShape edge ){

		//accessing the graphicPanel
		Graphics g = graphicPanel.getGraphics();
		Graphics2D g_2D = (Graphics2D) g;

=======
		
	}
	
	public void drawEdge( EdgeShape edge ){
		
		//accessing the graphicPanel
		Graphics g = graphicPanel.getGraphics();
		Graphics2D g_2D = (Graphics2D) g;
		
>>>>>>> origin/master
		//drawing shapes
		g_2D.setStroke(new BasicStroke( 10.0F ));
		if(edge.getVertexA().getColor() != edge.getVertexB().getColor()){
			g_2D.setColor(Color.green);
			g_2D.draw(edge.getShape());
			g_2D.setStroke(new BasicStroke( 4.0F ));
		}else{
			g_2D.setColor(Color.red);
			g_2D.draw(edge.getShape());
			g_2D.setStroke(new BasicStroke( 4.0F ));
		}
	}
<<<<<<< HEAD

	public void changeColor(MouseEvent event){

		//accessing the graphic panel
		Graphics g = graphicPanel.getGraphics();
		Graphics2D g_2D = (Graphics2D) g;

		VertexShape vertexToChange = null;

=======
	
	public void changeColor(MouseEvent event){
				
		//accessing the graphic panel
		Graphics g = graphicPanel.getGraphics();
		Graphics2D g_2D = (Graphics2D) g;
		
		VertexShape vertexToChange = null;
				
>>>>>>> origin/master
		//drawing shapes
		for(int i=0;i<vertecies.length;i++){
			if(vertecies[i].withinBorders(event.getX(),event.getY())){
				System.out.println("Vertex "+i+" to change");
				vertexToChange = vertecies[i];
				vertexToChange.nextColor();
				drawVertex( vertexToChange );
				break;
			}
		}
	}
<<<<<<< HEAD

	public void updateHint(){

		//accessing the graphic panel
		Graphics g = graphicPanel.getGraphics();
		Graphics2D g_2D = (Graphics2D) g;

=======
	
	public void updateHint(){
		
		//accessing the graphic panel
		Graphics g = graphicPanel.getGraphics();
		Graphics2D g_2D = (Graphics2D) g;
		
>>>>>>> origin/master
		//redrawing the shapes
		for(int i=0;i<edges.length;i++){
			drawEdge(edges[i]);
		}
		for(int i=0;i<vertecies.length;i++){
			drawVertex(vertecies[i]);
		}
	}
<<<<<<< HEAD

=======
	
>>>>>>> origin/master
	public void solve(){
		for(int i=0;i<vertecies.length;i++){
			for(int j=0;j<edges.length;j++){
				if(vertecies[i] == edges[j].getVertexA() ||
				   vertecies[i] == edges[j].getVertexB()    ){
<<<<<<< HEAD

=======
					   
>>>>>>> origin/master
				}
			}
		}
	}
<<<<<<< HEAD

	public static void main(){

		Drawer d = new Drawer();

		JLabel vertexLabel = new JLabel("Vertecies: ");
		JLabel edgeLabel = new JLabel("     Edges: ");
		vertexLabel.setForeground(Color.WHITE);
		edgeLabel.setForeground(Color.WHITE);
		JPanel controlPanel = new JPanel(){
		@Override
		protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try{
	BufferedImage image = ImageIO.read(new File("resources/background5.jpeg"));
	g.drawImage(image, 0, 0, null);
}catch(IOException e) {e.printStackTrace();}
		}
};
		controlPanel.setPreferredSize(new Dimension(150,150));
=======
	
	public static void main(String[] args){
		
		Drawer d = new Drawer();
		
		JLabel vertexLabel = new JLabel("Vertecies: ");
		JLabel edgeLabel = new JLabel("Edges: ");
		
		JPanel controlPanel = new JPanel();
>>>>>>> origin/master
		controlPanel.add(vertexLabel);
		controlPanel.add(vertexField);
		controlPanel.add(edgeLabel);
		controlPanel.add(edgeField);
		controlPanel.add(startButton);
<<<<<<< HEAD



		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.add(controlPanel, BorderLayout.LINE_END);
		contentPanel.add(graphicPanel, BorderLayout.CENTER);
		contentPanel.setPreferredSize(new Dimension(900, 723));



		JFrame frame = new JFrame();

=======
		
		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.add(controlPanel, BorderLayout.SOUTH);
		contentPanel.add(graphicPanel, BorderLayout.CENTER);
		contentPanel.setPreferredSize(new Dimension(900, 723));
		
		JFrame frame = new JFrame();
		
>>>>>>> origin/master
		frame.setSize(1100, 723);
		frame.add(contentPanel);
		frame.setVisible(true);
		frame.setResizable(false);
<<<<<<< HEAD
	}
}
=======
	}	
}
>>>>>>> origin/master
