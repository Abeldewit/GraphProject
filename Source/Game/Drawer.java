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
import java.lang.*;

public class Drawer extends JPanel implements Runnable {

	private VertexShape[] vertecies;
	private EdgeShape[] edges;
	final  ThreadGroup graphshapegroup = new  ThreadGroup("graphshape");
	public static int version = 0;

	private static JLabel chrField = new JLabel();
	private static JTextField vertexField = new JTextField(5);
	private static JTextField edgeField = new JTextField(5);
	private static JButton startButton = new JButton("generate");
	private static JPanel graphicPanel;


	private static int chromatic_number = 0;

	public Drawer() {
		version++;
		System.out.println("Drawer is printed ");

		graphicPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try{

					BufferedImage image = ImageIO.read(new File("resources/background5.jpeg"));

					g.drawImage(image, 0, 0, null);
				}catch(IOException e) {e.printStackTrace();}
            }
        };


		class StartButtonListener implements ActionListener, Runnable{
			Drawer d;
			StartButtonListener(Drawer d){
				this.d = d;
			}

			public void run(){
				synchronized(this){
					Thread t =  Thread.currentThread();
					t.setName("Startbutton "+ d.getV());
					System.out.print(Thread.currentThread().getName() + "\n ");

				};
			}
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






				//defining the new set
				GraphShape graph = new GraphShape(v,e,adjacencyMatrix);
				Thread t = new Thread(graphshapegroup,graph);
				t.start();

				vertecies = graph.getVertecies();
				edges = graph.getEdges();




				//drawing the edges
				for(int i=0;i<edges.length;i++){
					drawEdge(edges[i]);
				}

				//drawing the vertecies
				for(int i=0;i<vertecies.length;i++){
					drawVertex(vertecies[i]);
				}
			}
		}
		//listener
		class MousePressListener implements MouseListener, Runnable{
			Drawer d;
			MousePressListener(Drawer d){
				this.d = d;

			}
			public  void run(){
				synchronized(this){
					System.out.println("I am 2 ");
					Thread t = Thread.currentThread();
					String name = t.getName();
					t.setName("MousePress thread " + d.version);

					System.out.print(Thread.currentThread().getName()+ "\n");
				}
			}
			public void mousePressed(MouseEvent event) {

				changeColor(event);
				updateHint();
			}
			public void mouseReleased(MouseEvent event) {}
			public void mouseClicked(MouseEvent event){}
			public void mouseEntered(MouseEvent event){}
			public void mouseExited(MouseEvent event) {}
		}
		StartButtonListener n = new StartButtonListener(this);
		MousePressListener l = new MousePressListener(this);
		startButton.addActionListener(n);
		graphicPanel.addMouseListener(l);
		new Thread(n).start();
		new Thread(l).start();

	}


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

		//drawing shapes
		g_2D.setColor(Color.black);
		g_2D.draw(vertex.getShape());
		g_2D.setColor(vertex.getColor());
		g_2D.fill(vertex.getShape());


	}
	public void run(){

	}
	public int getV(){
		return version;
	}
	public void drawEdge( EdgeShape edge ){

		//accessing the graphicPanel
		Graphics g = graphicPanel.getGraphics();
		Graphics2D g_2D = (Graphics2D) g;


		//drawing shapes
		g_2D.setStroke(new BasicStroke());
		if(edge.getVertexA().getColor() != edge.getVertexB().getColor()){
			g_2D.setColor(Color.green);
			g_2D.draw(edge.getShape());
			g_2D.setStroke(new BasicStroke());
		}else{
			g_2D.setColor(Color.red);
			g_2D.draw(edge.getShape());
			g_2D.setStroke(new BasicStroke());
		}
	}


	public void changeColor(MouseEvent event){

		//accessing the graphic panel
		Graphics g = graphicPanel.getGraphics();
		Graphics2D g_2D = (Graphics2D) g;

		VertexShape vertexToChange = null;


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


	public void updateHint(){

		//accessing the graphic panel
		Graphics g = graphicPanel.getGraphics();
		Graphics2D g_2D = (Graphics2D) g;


		//redrawing the shapes
		for(int i=0;i<edges.length;i++){
			drawEdge(edges[i]);
		}
		for(int i=0;i<vertecies.length;i++){
			drawVertex(vertecies[i]);
		}
	}

	public void solve(){
		for(int i=0;i<vertecies.length;i++){
			for(int j=0;j<edges.length;j++){
				if(vertecies[i] == edges[j].getVertexA() ||
				   vertecies[i] == edges[j].getVertexB()    ){

				}
			}
		}
	}

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

		controlPanel.add(vertexLabel);
		controlPanel.add(vertexField);
		controlPanel.add(edgeLabel);
		controlPanel.add(edgeField);
		controlPanel.add(startButton);




		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.add(controlPanel, BorderLayout.LINE_END);
		contentPanel.add(graphicPanel, BorderLayout.CENTER);
		contentPanel.setPreferredSize(new Dimension(900, 723));



		JFrame frame = new JFrame();


		frame.setSize(1100, 723);
		frame.add(contentPanel);
		frame.setVisible(true);
		frame.setResizable(false);

	}
}
