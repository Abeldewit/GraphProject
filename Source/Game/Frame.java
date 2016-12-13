import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.lang.Object;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;

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
		int l = component.getV();
		int[][] coords = component.getCoords();
		for (int i=0; i<l;i++ ) {
			int x = coords[i][0];
			int y = coords[i][1];
			ClickableVertex c = new ClickableVertex(x,y);
			System.out.println(c);
			frame.add(c);
		}
		frame.add(component);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.BLACK);
		Container c = frame.getContentPane();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
