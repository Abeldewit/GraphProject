import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.lang.Object;
import javax.imageio.*;
import java.awt.image.BufferedImage;

public class Frame {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		try {
			BufferedImage img = ImageIO.read(new File("background5.jpeg"));
			ImageIcon icon = new ImageIcon(img);
			JLabel contentPane = new JLabel();
			contentPane.setIcon(icon);
			contentPane.setLayout(new BorderLayout());
			frame.setContentPane(contentPane);
		} catch(IOException e) {e.printStackTrace();}

		final int FRAME_WIDTH = 1100;
		final int FRAME_HEIGHT = 723;
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setResizable(false);
		frame.setTitle("Chromatic Craziness");
		TextField input = new TextField();

		int e = 0;
		int v = 0;
		while (e == 0 || v == 0 || v > 9 || e < Math.ceil(v/2) || e > ((v*v)-v)/2) {
			e = input.getEdges();
			v = (int) input.getVertices();
			System.out.print("");
		}
		graphGen randomMat = new graphGen(v, e);
		int[][] adjacencyMatrix = randomMat.getMatrix();

		ArcDiagramComponent component = new ArcDiagramComponent(v, e, adjacencyMatrix);
		// This is the number of vertexes
		int l = component.getV();
		int[][] coords = component.getCoords();
		frame.add(component);
		// ORDER IS IMPORTANT
		ClickableVertex[] set = new ClickableVertex[l+1];
		for (int i=0; i<l;i++ ) {
			int x = coords[i][0];
			int y = coords[i][1];
			ClickableVertex c = new ClickableVertex(x,y);
			set[l] = c;
			System.out.println(c);
			frame.add(c);
		}
		ClickableVertex d = new ClickableVertex(80,80);
		frame.add(d);

		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.BLACK);
		Container c = frame.getContentPane();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
