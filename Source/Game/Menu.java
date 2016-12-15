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
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class Menu
{
private static int i = 1;


public Menu(){
  JFrame Menu = new JFrame();

  Clip audio;

  final int FRAME_WIDTH = 700;
  final int FRAME_HEIGHT = 700;
  Menu.setSize(FRAME_WIDTH, FRAME_HEIGHT);
  Menu.setTitle("Chromatic Craziness 1.1");
  Menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  ImageIcon play1 = new ImageIcon("resources/play.jpeg");

  JButton play = new JButton(play1);
  ImageIcon music = new ImageIcon("resources/music.png");
  JButton settings = new JButton(music);
  ImageIcon high = new ImageIcon("resources/Highscores.png");

  JButton Highscores = new JButton(high);



  play.setPreferredSize(new Dimension(150,150));
  try{
  BufferedImage img = ImageIO.read(new File("resources/background.png"));
  ImageIcon icon = new ImageIcon(img);
  JLabel contentPane = new JLabel();
  contentPane.setIcon(icon);
  contentPane.setLayout(new BorderLayout());
  Menu.setContentPane(contentPane);
} catch(IOException e) {e.printStackTrace();}



<<<<<<< HEAD
   Menu.add(play, BorderLayout.PAGE_START);
   Menu.setTitle("Chromatic Craziness 1.1");
   Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
=======
    Menu.add(play, BorderLayout.PAGE_START);
    Menu.setTitle("Chromatic Craziness 1.1");
    Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
>>>>>>> origin/master

      JPanel panel = new JPanel();
      panel.setBackground(Color.black);
      panel.setLayout(new GridLayout(1,2,1,1));
      panel.setPreferredSize(new Dimension(150,150));
      JButton component= new JButton("Component");

      panel.add(settings);
      panel.add(Highscores );
        Menu.add(panel, BorderLayout.PAGE_END);




ActionListener listener = new ClickListener();
play.addActionListener(listener);
ActionListener listener4 = new ClickListener4(Menu);
Highscores.addActionListener(listener4);
// ActionListener listener5 = new ClickListener5();


play.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e)
    {
       Menu.setVisible(false);
    }
});
settings.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e)
    {

      i++;
      if ( (i & 1) == 0){
          clip.stop();
      }
      else
      {
          clip.start();
      }


    }
});
Highscores.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e)
    {
       Menu.setVisible(false);
    }
});


Menu.setVisible(true);
Menu.getContentPane().setBackground(Color.BLACK);
Container c = Menu.getContentPane();



File Music = new File ("resources/resonance.wav");

PlaySound(Music);


}
  private static Clip clip;




public static void main(String[] args){

new Menu();

 }



//method for music
public void PlaySound(File Sound){
   try{
     clip = AudioSystem.getClip();
     clip.open(AudioSystem.getAudioInputStream(Sound));
     clip.start();
     clip.loop(5);
     Thread.sleep(clip.getMicrosecondLength()/1000);


   } catch (Exception e) {return;}

}


// public void Visible() {
//   Menu.setVisible(true);
// }





 }
