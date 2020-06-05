package objectProgramming.crazyAnimals.swing;
import objectProgramming.crazyAnimals.main.Main;
import objectProgramming.crazyAnimals.main.Parameters;

import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 
 import javax.swing.JButton;
 import javax.swing.JPanel;
import javax.swing.JFrame;
 
 @SuppressWarnings("serial")
public class StartPanel extends JPanel{
 
	public static final int HEIGHT = 160;
 	public static final int WIDTH = 280;
 	private JButton startButton;
 	private JButton parametersButton;
 	private StartPanel panel;
 	private JFrame parent;
 	private Parameters parameters;
 
 	public StartPanel(JFrame frame) {
 		parent = frame;
 		startButton = new StartButton();
 		parametersButton = new ParametersButton();
 		setLayout(null);
 		setPreferredSize(new Dimension(WIDTH, HEIGHT));
 		add(startButton);
 		add(parametersButton);
 		panel = this;
 		startButton.setBounds(50, 20, 180, 50);
 		parametersButton.setBounds(50, 90, 180, 50);
 	}
 	/**
 	 * Ustawia referencje do parametrów
 	 * @param parameters - referencja do parametrów
 	 */
 	public void setParameters(Parameters parameters) {
 		this.parameters = parameters;
 	}
 
 	class StartButton extends JButton implements ActionListener {
 
		private static final long serialVersionUID = 1L;

		StartButton() {
 			super("Start simulation");
 			addActionListener(this);
 		}
 
 		@Override
 		public void actionPerformed(ActionEvent e) {
 			parent.setVisible(false);
 			if(parameters!=null) Main.runSimulation(parameters);
 			else Main.runSimulation();
 		}
 	}
 
 	class ParametersButton extends JButton implements ActionListener {
 
		private static final long serialVersionUID = 1L;

		ParametersButton() {
 			super("Configure parameters");
 			addActionListener(this);
 		}
 
 		@Override
 		public void actionPerformed(ActionEvent e) {
 			ParametersFrame frame = new ParametersFrame(panel);
 			frame.showFrame();
 		}
 	}
 
 }