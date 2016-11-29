import java.awt.*;
import java.lang.*;
import java.util.*;
import javax.swing.JPanel;
import javax.swing.JComponent;

public class ArcDiagramComponent extends JComponent {
	public void paintComponent(Graphics g) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many vertices should there be? The maximum is 9!");
		int v = in.nextInt(); //number of vertices
		System.out.println("How many edges should there be?");
		int e = in.nextInt(); //number of edges
		
		//creates a random graph
		graphGen randomMat = new graphGen(v, e);
		int[][] adjMat = randomMat.getMatrix();
		
		Graphics2D g2 = (Graphics2D) g;
		

		Color lines = new Color (163, 183, 183);
		Color color9 = new Color (112, 0, 0);
		Color color8 = new Color (184, 0, 0);
		Color color7 = new Color (247, 13, 13);
		Color color6 = new Color (255, 65, 13);
		Color color5 = new Color (249, 132, 15);
		Color color4 = new Color (243, 226, 3);
		Color color3 = new Color (170, 212, 14);
		Color color2 = new Color (110, 163, 25);
		Color color1 = new Color (77, 124, 14);
		
		//drawArc arc1 = new drawArc(int x, int y, int width, int height, int startAngle, int arcAngle)		
		
		Color[] colors = new Color[10];
		colors[0] = color1;
		colors[1] = color2;
		colors[2] = color3;
		colors[3] = color4;
		colors[4] = color5;
		colors[5] = color6;
		colors[6] = color7;
		colors[7] = color8;
		colors[8] = color9;
		
		int[][] coords = new int[v][2];
		for (int d = 0; d < v; d++) {
			coords[d][0] = 30+(d+1)*100;
			coords[d][1] = 350;
		}
	 
		//goes through the array and draws circles and lines on and between the coordinates respectively

		for (int i = 0; i < v; i++) {
			int x = coords[i][0];
			int y = coords[i][1];
			for(int k = 0; k < v; k++) {
				int a = coords[k][0];
				int b = coords[k][1];
				g2.setColor(lines);
				if (adjMat[i][k] == 1) {
					if (a-x == 100) {
						g2.drawLine(x,y,a,b);
					} else {
						if ((a-x)%200 == 0) {
							g2.drawArc(x,y-(((a-x)/100)*40),a-x,(((a-x)/100)*80),0,180);
						} else {
							g2.drawArc(x,y-(((a-x)/100)*40),a-x,(((a-x)/100)*80),180,180);
						}
					}
				}
			}
		}
		for (int i = 0; i < v; i++) {
			int r = 50;
			int x = coords[i][0];
			int y = coords[i][1];
			g2.setColor(colors[i]);
			g2.drawOval(x-(r/2),y-(r/2),r,r);
			g2.setColor(colors[i]);
			g2.fillOval(x-(r/2),y-(r/2),r,r);
		}
	}
}