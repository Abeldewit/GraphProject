import javax.swing.JFrame;
import java.awt.event.*;

public class ClickableWrapper{

	public static void main(String[] args){

		JFrame window = new JFrame();
		window.setSize(300,300);
		window.setTitle("Clickable Bullshit");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ClickableVertex c = new ClickableVertex(80,80);
		ClickableVertex d = new ClickableVertex(90,90);

		window.add( c );
		window.add(d);

		window.setVisible(true);

	}
}
