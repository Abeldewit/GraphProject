
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Component
extends JComponent
{

public void paintComponent(Graphics g)
{
  int[][] coords = new int[20][2];


    coords[0][1] = 20;
    coords[1][1] = 50;
    coords[2][1] = 95;
    coords[3][1] = 190;
    coords[4][1] = 300;
    coords[5][1] = 370;
    coords[6][1] = 480;
    coords[7][1] = 565;
    coords[8][1] = 620;
    coords[9][1] = 650;
    coords[10][1] = 650;
    coords[11][1] = 620;
    coords[12][1] = 565;
    coords[13][1] = 480;
    coords[14][1] = 370;
    coords[15][1] = 300;
    coords[16][1] = 190;
    coords[17][1] = 95;
    coords[18][1] = 50;
    coords[19][1] = 20;

    coords[0][0] = 370;
    coords[1][0] = 480;
    coords[2][0] = 570;
    coords[3][0] = 620;
    coords[4][0] = 650;
    coords[5][0] = 650;
    coords[6][0] = 620;
    coords[7][0] = 570;
    coords[8][0] = 480;
    coords[9][0] = 370;
    coords[10][0] = 300;
    coords[11][0] = 210;
    coords[12][0] = 100;
    coords[13][0] = 50;
    coords[14][0] = 20;
    coords[15][0] = 20;
    coords[16][0] = 50;
    coords[17][0] = 100;
    coords[18][0] = 210;
    coords[19][0] = 300;





  g.setColor(Color.WHITE);
  g.drawString("Chromatic Craziness",10,30);



  //goes through the array and draws circles and lines on and between the coordinates respectively
int counter = 0;
  for (int i = 0; i < 20; i++)
    {
      int x = coords[counter][0];
      int y = coords[counter][1];
      counter++;

      int counter2 = 0;
      for(int k = 0; k < 20; k++)
      {
        int a = coords[counter2][0];
        int b = coords[counter2][1];
        counter2++;
        g.setColor(Color.RED);
        g.drawLine(x,y,a,b);
      }
      }


      int n = 0;
  for (int i = 0; i < 20; ++i)
    {
      int r = 25;
      int x = coords[n][0];
      int y = coords[n][1];
      n++;
      g.setColor(Color.BLACK);
      g.drawOval(x-(r/2),y-(r/2),r,r);
      g.setColor(Color.WHITE);
      g.fillOval(x-(r/2),y-(r/2),r,r);
      }
      g.setColor(Color.WHITE);
      //g.drawString("SUCH GRAPH",20,500);
      //g.drawString("MUCH WOW",500,50);


}
}
