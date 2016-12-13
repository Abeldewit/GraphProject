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
<<<<<<< HEAD
		window.add(d)

=======
		
>>>>>>> 9bccca092540538bc41a3205c8b74c96b028d34e
		window.setVisible(true);
		
	}
}
