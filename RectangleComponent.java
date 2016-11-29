import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.*;




public class Component
extends JComponent
{
public void paintComponent(Graphics g)
{

g.drawOval(50,50,100,100);
g.setcolor(Color.GREEN);
g.fillOval(50,50,100,100);

}
}
