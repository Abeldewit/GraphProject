import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.lang.Object;
import javax.imageio.*;
import java.awt.image.BufferedImage;

public class TextField extends JFrame {
	JFrame inputFrame;
	final JTextField jtfUneditable0,jtfUneditable1, jtfText1, jtfUneditable2, jtfText2;
	String display = "";
	String instruction = "Please enter the number of Vertices first!";
	double vertices = 0;
	int edges = 0;
	int max = 0;
	int min = 0;
	TextHandler handler = null;

	public static void main(String[] Args) {
		TextField field1 = new TextField();

		field1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public TextField() {
		super("Starting Screen Chromatic Craziness 1.1");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		handler = new TextHandler();



		jtfUneditable0 = new JTextField(instruction,30);
		jtfUneditable1 = new JTextField("Please enter the amount of vertices (max. 9).",30);
		jtfText1 = new JTextField(10);
		jtfText2 = new JTextField(10);
		jtfUneditable2 = new JTextField("Please enter the amount of edges.",30);

		inputFrame = new JFrame();

		jtfUneditable0.setEditable(false);
		jtfUneditable1.setEditable(false);
		jtfUneditable2.setEditable(false);

		container.add(jtfUneditable0);

		container.add(jtfUneditable1);
		jtfUneditable1.addActionListener(handler);

		container.add(jtfText1);
		jtfText1.addActionListener(handler);

		container.add(jtfUneditable2);
		jtfUneditable2.addActionListener(handler);

		container.add(jtfText2);
		jtfText2.addActionListener(handler);

		setSize(600, 150);
		setResizable(false);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
	}

	public class TextHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jtfText1) {
				vertices = Integer.parseInt(e.getActionCommand());
				if (vertices <= 9 && vertices >= 2) {
					max = (int) ((vertices*vertices)-vertices)/2;
					min = (int) Math.ceil(vertices/2);
					display = "No more than " + max + " and no less than " + min + " edges are possible! ";
					JOptionPane.showMessageDialog(null, display);
					jtfText1.setEditable(false);
				} else if (vertices > 9) {
					display = "Please type in a lower number!";
					JOptionPane.showMessageDialog(null, display);
				} else if (vertices < 2) {
					display = "Please type in a higher number!";
					JOptionPane.showMessageDialog(null, display);
				}
			} else if (e.getSource() == jtfText2) {
				edges = Integer.parseInt(e.getActionCommand());
				if (edges <= max && edges >= min) {
					jtfText2.setEditable(false);
					setVisible(false);
					dispose();
				} else if (edges > max && edges > min) {
					display = "The amount of edges is too high, please type in a lower number!";
					JOptionPane.showMessageDialog(null, display);
				} else if (edges <= max && edges < min) {
					display = "The amount of edges is too low, please type in a higher number!";
					JOptionPane.showMessageDialog(null, display);
				}
			}
		}
	}
	public double getVertices() {
		return vertices;
	}
	public int getEdges() {
		return edges;
	}
}
