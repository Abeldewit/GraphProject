import java.awt.event.ActionEvent; import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.lang.Object;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
/**
   An action listener that prints a message.
*/
public class ClickMenu implements ActionListener {

public void actionPerformed(ActionEvent event) {

  JFrame Menu = new JFrame();

  final int FRAME_WIDTH = 700;
  final int FRAME_HEIGHT = 700;
  Menu.setSize(FRAME_WIDTH, FRAME_HEIGHT);
  Menu.setTitle("Chromatic Craziness 1.1");
  Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  JButton play = new JButton("PLAY");

  JButton settings = new JButton("Settings");
  play.setPreferredSize(new Dimension(100,50));
  JButton Highscores = new JButton("High scores");


  try{
  BufferedImage img = ImageIO.read(new File("background3.jpeg"));
  ImageIcon icon = new ImageIcon(img);
  JLabel contentPane = new JLabel();
  contentPane.setIcon(icon);
  contentPane.setLayout(new BorderLayout());
  Menu.setContentPane(contentPane);
} catch(IOException e) {e.printStackTrace();}



   Menu.add(play, BorderLayout.PAGE_START);
  Menu.setTitle("Chromatic Craziness 1.1");
  Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


  JPanel panel = new JPanel();
      panel.setLayout(new GridLayout(2,2,1,1));
      JButton component= new JButton("Component");

      panel.add(settings);
      panel.add(Highscores );
      Menu.add(panel, BorderLayout.PAGE_END);



ActionListener listener = new ClickListener();
play.addActionListener(listener);
ActionListener listener3 = new ClickListener3();
settings.addActionListener(listener3);
ActionListener listener4 = new ClickListener4();
Highscores.addActionListener(listener4);



Menu.setVisible(true);
Menu.getContentPane().setBackground(Color.BLACK);
Container c = Menu.getContentPane();


}
}
