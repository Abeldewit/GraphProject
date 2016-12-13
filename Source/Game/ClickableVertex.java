import javax.swing.*;
import java.io.*;
import sun.audio.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.*;

public class ClickableVertex extends JComponent{

	private int x;
	private int y;
	private int origin_X;
	private int origin_Y;
	private int size = 50;
	private Ellipse2D.Double circle;
	private Color shapecolor;

	private static Color[] colors = {

		Color.red,
		Color.blue,
		Color.yellow,
		Color.green,
		Color.black,
		Color.cyan,
		Color.orange,
		Color.magenta,
		Color.white,
		Color.gray

	};

	public ClickableVertex ( int x, int y ){


		this.x = x;
		this.y = y;
		origin_X = x + size/2;
		origin_Y = y + size/2;

		shapecolor = Color.red;

		circle = new Ellipse2D.Double(x,y,size,size);

		class MousePressListener implements MouseListener{

			public void mousePressed(MouseEvent event) {

				if(withinBorders(event.getX(),event.getY())){
					int next = getNextColor();
					if(next == 10){next = 0;}
					setShapeColor(colors[next]);
					repaint();
				}
			}
			public void mouseReleased(MouseEvent event) {}
			public void mouseClicked(MouseEvent event){
				System.out.println("It has been clicked");
			}
			public void mouseEntered(MouseEvent event){}
			public void mouseExited(MouseEvent event) {}

			public boolean withinBorders (int x, int y){
				System.out.println("It has been clicked within borders");

				return	( Math.sqrt(Math.pow((x - origin_X),2) + Math.pow((y-origin_Y),2)) < size/2 );

			}

			public void setShapeColor(Color color){
				System.out.println(color);
				shapecolor = color;
			}

			public int getNextColor (){
				for(int i=0;i<colors.length;i++){
					if(shapecolor == colors[i]){
						return (i+1);
					}
				}
				return (5);
			}
		}

		MouseListener listener = new MousePressListener();
		addMouseListener(listener);
	}

	public void paintComponent( Graphics g ){

		Graphics2D g_2D = (Graphics2D) g;
		Rectangle2D.Double origin = new Rectangle2D.Double(origin_X- 0.5, origin_Y - 0.5, 1, 1);
		g_2D.setColor(Color.black);
		g_2D.setStroke(new BasicStroke(8.0F));
		g_2D.draw(circle);
		g_2D.setColor(shapecolor);
		g_2D.fill(circle);
		//g_2D.draw(circle);
	}
	// Duplicate
	// public boolean withinBorders (int x, int y){
	//
	// 	return	( Math.sqrt(Math.pow((x - origin_X),2) + Math.pow((y-origin_Y),2)) < size/2 );
	//
	// }
}
