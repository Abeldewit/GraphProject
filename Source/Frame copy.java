import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.lang.Object;
import javax.imageio.*;
import java.awt.image.BufferedImage;

public class Frame
{
public static void main(String[] args)

 {
  JFrame frame = new JFrame();
  try{
  BufferedImage img = ImageIO.read(new File("background3.jpeg"));
  ImageIcon icon = new ImageIcon(img);
  JLabel contentPane = new JLabel();
  contentPane.setIcon(icon);
  contentPane.setLayout(new BorderLayout());
  frame.setContentPane(contentPane);
} catch(IOException e) {e.printStackTrace();}

  final int FRAME_WIDTH = 700;
  final int FRAME_HEIGHT = 700;
  frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

    frame.setTitle("Chromatic Craziness 1.1");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


  Component component = new Component();
  frame.add(component);
  frame.setVisible(true);
  frame.getContentPane().setBackground(Color.BLACK);
  Container c = frame.getContentPane();
  // try{
  //   c.add( new JPanelWithBackground("background2.jpeg"));
  // }
  // catch (Exception e) {e.printStackTrace();}






  }

}
