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
public class ClickListener5 implements ActionListener {
//settings
public void actionPerformed(ActionEvent event) {

  JFrame frame = new JFrame();
  try {
    BufferedImage img = ImageIO.read(new File("background3.jpeg"));
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
  frame.add(component);
  frame.setVisible(true);
  frame.getContentPane().setBackground(Color.BLACK);
  Container c = frame.getContentPane();
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
}
