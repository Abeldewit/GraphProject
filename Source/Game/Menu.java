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
import java.awt.GridLayout;
public class Menu
{
public static void main(String[] args)

 {

  JFrame Menu = new JFrame();

  final int FRAME_WIDTH = 700;
  final int FRAME_HEIGHT = 700;
  Menu.setSize(FRAME_WIDTH, FRAME_HEIGHT);
  Menu.setTitle("Chromatic Craziness 1.1");
  Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  JButton play = new JButton("PLAY");
  JPanel panel2 = new JPanel();
  JButton settings = new JButton("Settings");
  play.setPreferredSize(new Dimension(100,50));
  JPanel panel = new JPanel(new GridLayout());
  panel.setMaximumSize(new Dimension(300,100));



   Menu.add(play, BorderLayout.PAGE_START);
   Menu.add(settings, BorderLayout.PAGE_END);

  Menu.add(panel);




ActionListener listener = new ClickListener(); play.addActionListener(listener);


Menu.setVisible(true);
 }


 }
