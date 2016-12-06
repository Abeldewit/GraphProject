import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Component2
extends JComponent
{

public void paintComponent(Graphics g)
{
  g.setColor(Color.BLACK);
  g.setFont(new Font("TimesRoman", Font.PLAIN, 70));
  g.drawString("TEST",150,50);



}
}
