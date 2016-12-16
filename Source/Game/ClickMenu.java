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

JFrame frame;

  public ClickMenu(JFrame f){
    frame = f;

  }
public void actionPerformed(ActionEvent event) {

  frame.setVisible(true);

  }

      }
