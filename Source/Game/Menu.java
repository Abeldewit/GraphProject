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
  JButton button = new JButton("PLAY");
  JPanel panel2 = new JPanel();
  JButton btn3 = new JButton("Settings");
  button.setPreferredSize(new Dimension(50,50));
  JPanel panel = new JPanel(new BorderLayout());
  // panel.setMaximumSize(new Dimension(300,100));

  panel.add(panel2, BorderLayout.CENTER);
  panel.add(btn3, BorderLayout.PAGE_END);
  panel.add(button, BorderLayout.PAGE_START);


  Menu.add(panel);




ActionListener listener = new ClickListener(); button.addActionListener(listener);


Menu.setVisible(true);
 }


 }
