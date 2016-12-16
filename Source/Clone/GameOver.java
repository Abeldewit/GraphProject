import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.io.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;



public class GameOver{

	private static int score;
	private static JPanel graphicPanel;
	
	public GameOver(int score){
		
		graphicPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try{
					BufferedImage image = ImageIO.read(new File("resources/Gameover.png"));
					g.drawImage(image, 0, 0, null);
				}catch(IOException e) {e.printStackTrace();}
            }
        };
		
		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.add(graphicPanel, BorderLayout.CENTER);
		
		JFrame frame = new JFrame();
		
		frame.setSize(1100, 723);
		frame.add(contentPanel);
		frame.setVisible(true);
		frame.setResizable(false);
		
		File prompt = new File ("resources/Gameover.wav");
		Menu.PlaySound(prompt);
	}
}