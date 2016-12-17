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
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;

public class Drawer extends JPanel{


	private static VertexShape[] vertecies;
	private static EdgeShape[] edges;
	private static int chromatic_number = 0;
	private static int time = 60;
	private static boolean gameOn = true;
	static int score = 0;

	private static JFrame frame;
	private static JLabel timeField = new JLabel("   Time Left: "+time+" s");
	private static JLabel chrField = new JLabel("   Chromatic Number: "+chromatic_number);
	private static JLabel scoreField = new JLabel("   Score: "+score);
	private static JTextField vertexField = new JTextField(5);
	private static JTextField edgeField = new JTextField(5);
	private static JButton startButton = new JButton("generate");
	private static JPanel controlPanel;
	private static JPanel graphicPanel;

	static int interval;
	static Timer timer;
	static int greenEdges;

	public Drawer() {

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

		controlPanel = new JPanel();

		class StartButtonListener implements ActionListener{

			public void actionPerformed(ActionEvent event) {

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
				Force brute = new Force(v,e,adjacencyMatrix);
				chromatic_number = brute.getChr();
				System.out.println("CHR received");
				chrField.setText("   Chromatic Number: "+chromatic_number);

				//defining the new set
				GraphShape graph = new GraphShape(v,e,adjacencyMatrix);
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
		class MousePressListener implements MouseListener{

			public void mousePressed(MouseEvent event) {

				changeColor(event);
				updateHint();
				updateScore();

				//checking whether the game should finish
					boolean red = false;
					for(int i=0;i<edges.length;i++) {
						if(edges[i].getColor() == Color.red) {
							red = true;
						}
					}
					if(red == false) {
						if(countUsedColors() - chromatic_number == 0) {
							System.out.println("You've won with score: " + score);
							timer.cancel();
							gameOver();
						} else if(countUsedColors() - chromatic_number > 0) {
							System.out.println("Solved but to many colors");
						} else {
							System.out.println("You're smarter than the system!");
							gameOver();
						}
					}

			}

			public void mouseReleased(MouseEvent event) {}
			public void mouseClicked(MouseEvent event){}
			public void mouseEntered(MouseEvent event){}
			public void mouseExited(MouseEvent event) {}
		}
		startButton.addActionListener(new StartButtonListener());
		graphicPanel.addMouseListener(new MousePressListener());
	}

	public static void drawBackground(){

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

	public static void drawVertex( VertexShape vertex ){

		//accessing the graphicPanel
		Graphics g = graphicPanel.getGraphics();
		Graphics2D g_2D = (Graphics2D) g;

		//drawing shapes
		g_2D.setColor(Color.black);
		g_2D.draw(vertex.getShape());
		g_2D.setColor(vertex.getColor());
		g_2D.fill(vertex.getShape());

	}

	public void drawEdge( EdgeShape edge ){

		//accessing the graphicPanel
		Graphics g = graphicPanel.getGraphics();
		Graphics2D g_2D = (Graphics2D) g;

		//drawing shapes
		g_2D.setStroke(new BasicStroke( 1.0F ));
		if(edge.getVertexA().getColor() != edge.getVertexB().getColor()){
			edge.setColor(Color.green);
			g_2D.setColor(Color.green);
			g_2D.draw(edge.getShape());
			g_2D.setStroke(new BasicStroke( 4.0F ));
		}else{
			edge.setColor(Color.red);
			g_2D.setColor(Color.red);
			g_2D.draw(edge.getShape());
			g_2D.setStroke(new BasicStroke( 4.0F ));
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

	public static void startTimer(int start){

		int delay = 1000;
		int period = 1000;
		timer = new Timer();
		interval = start;
		timer.scheduleAtFixedRate(new TimerTask() {

			public void run() {
				if(interval<60){
					timeField.setText("   Time Left: "+interval+" s");
					updateScore();
				}
				System.out.println(setInterval());
				if(interval ==0){
				gameOver();
				timer.cancel();
				}
			}
		}, delay, period);
	}

	private static final int setInterval() {
		return --interval;
	}

	public static void gameOver(){

		System.out.println("GAME OVER");
		frame.dispose();
		new GameOver(100);

	}

	public static void updateScore(){

		boolean valid = true;

		for(int i=0;i<edges.length;i++){
			if(edges[i].getColor() == Color.red){
				score = 0;
				System.out.println("score set to none");
				scoreField.setText("   Score: "+score);
				valid = false;
				break;
			}
		}
		if(valid){
			score = vertecies.length * edges.length * interval - 100 * (countUsedColors() - chromatic_number);
			scoreField.setText("   Score: "+score);
		}
	}

	public static int countUsedColors(){
		ArrayList<Color> usedColours = new ArrayList<Color>();

		for(int i=0;i<vertecies.length;i++){
			if(i==0){
				usedColours.add(vertecies[0].getColor());
			}else{
				if(!usedColours.contains(vertecies[i].getColor())){
					usedColours.add(vertecies[i].getColor());
				}
			}
		}
		return (usedColours.size());
	}

	public static void main(String args[]){

		Drawer d = new Drawer();

		JLabel vertexLabel = new JLabel("Vertecies:  ");
		JLabel edgeLabel = new JLabel("    Edges:    ");

		vertexLabel.setForeground(Color.WHITE);
		edgeLabel.setForeground(Color.WHITE);
		timeField.setForeground(Color.WHITE);
		chrField.setForeground(Color.WHITE);
		scoreField.setForeground(Color.WHITE);


		controlPanel = new JPanel(){
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
		controlPanel.add(chrField);
		controlPanel.add(timeField);
		controlPanel.add(scoreField);

		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.add(controlPanel, BorderLayout.LINE_END);
		contentPanel.add(graphicPanel, BorderLayout.CENTER);
		contentPanel.setPreferredSize(new Dimension(900, 723));

		frame = new JFrame();

		frame.setSize(1100, 723);
		frame.add(contentPanel);
		frame.setVisible(true);
		frame.setResizable(false);

		startTimer(70);
	}
}
