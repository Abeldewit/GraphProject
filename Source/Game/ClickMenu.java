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
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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
  Menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  ImageIcon play1 = new ImageIcon("play.jpeg");

  JButton play = new JButton(play1);

  JButton settings = new JButton("Settings");

  JButton Highscores = new JButton("High scores");

  JButton test = new JButton("TEST");

  play.setPreferredSize(new Dimension(150,150));
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
    panel.setBackground(Color.black);
      panel.setLayout(new GridLayout(3,3,1,1));
      JButton component= new JButton("Component");

      panel.add(settings);
      panel.add(Highscores );
      panel.add(test);
      Menu.add(panel, BorderLayout.PAGE_END);



  ActionListener listener = new ClickListener();
  play.addActionListener(listener);
  ActionListener listener3 = new ClickListener3();
  settings.addActionListener(listener3);
  ActionListener listener4 = new ClickListener4();
  Highscores.addActionListener(listener4);
  ActionListener listener5 = new ClickListener5();
  test.addActionListener(listener5);

  test.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e)
    {
       Menu.dispose();
    }
  });
  play.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e)
    {
       Menu.dispose();
    }
  });
  settings.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e)
    {
       Menu.dispose();
    }
  });
  Highscores.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e)
    {
       Menu.dispose();
    }
  });


  Menu.setVisible(true);
  Menu.getContentPane().setBackground(Color.BLACK);
  Container c = Menu.getContentPane();
  File Music = new File ("Music.wav");
  PlaySound(Music);
  System.out.print("Chopin Waltz No.2");


      }
      static void PlaySound(File Sound){
     try{
         Clip clip = AudioSystem.getClip();
         clip.open(AudioSystem.getAudioInputStream(Sound));
         clip.start();
         Thread.sleep(clip.getMicrosecondLength()/1000);
     }
     catch (Exception e) {
     }
     }
      }
