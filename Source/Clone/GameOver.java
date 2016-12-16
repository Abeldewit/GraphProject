public class GameOver{}

	private static int score;
	private static JPanel graphicPanel;
	
	public GameOver(int score){
		
		
		
		controlPanel = new JPanel();
		
		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.add(graphicPanel, BorderLayout.CENTER);
		
		JFrame frame = new JFrame();
		
		frame.setSize(1100, 723);
		frame.add(contentPanel);
		frame.setVisible(true);
		frame.setResizable(false);
	}