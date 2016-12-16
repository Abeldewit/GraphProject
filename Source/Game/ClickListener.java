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
public class ClickListener implements ActionListener {

public void actionPerformed(ActionEvent event) {
  JFrame frame = new JFrame();
  final int FRAME_WIDTH = 700;
  final int FRAME_HEIGHT = 700;
  frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
  frame.setTitle("Chromatic Craziness ");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  Component2 component2 = new Component2();

  try{
  BufferedImage img = ImageIO.read(new File("resources/background5.jpeg"));
  ImageIcon icon = new ImageIcon(img);
  JLabel contentPane = new JLabel();
  contentPane.setIcon(icon);
  contentPane.setLayout(new BorderLayout());
  frame.setContentPane(contentPane);
  frame.getContentPane().setBackground(Color.BLACK);
  Container c = frame.getContentPane();
  contentPane.add(component2);
  } catch(IOException e) {e.printStackTrace();}

  JPanel panel = new JPanel();
  panel.setLayout(new GridLayout(3,3));




ImageIcon water = new ImageIcon("resources/Bitter.jpeg");
  JButton Bitter= new JButton(water);
ImageIcon time = new ImageIcon("resources/timefrenzy.jpeg");
  JButton mode2= new JButton(time);
  ImageIcon random = new ImageIcon("resources/random.jpeg");
  JButton mode3= new JButton(random);


  Bitter.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e)
      {
        frame.setVisible(false);
         Drawer.main();
      }
  });
  mode2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e)
      {
        frame.setVisible(false);
         Drawer.main();
      }
  });
  mode3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e)
      {
        frame.setVisible(false);
         Drawer.main();
      }
  });




  panel.add(Bitter);
  panel.add(mode2);
  panel.add(mode3);
  frame.add(panel);


  panel.setOpaque(false);

  frame.setVisible(true);



}
}
