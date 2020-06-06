package objectProgramming.crazyAnimals.swing;
import objectProgramming.crazyAnimals.main.Main;
import objectProgramming.crazyAnimals.main.Parameters;

import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
 import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
 
 @SuppressWarnings("serial")
public class StartPanel extends JPanel{
 
	public static final int HEIGHT = 190;
 	public static final int WIDTH = 220;
 	private JButton startButton;
 	private JButton parametersButton;
 	private JButton infoButton;
 	private StartPanel panel;
 	private JFrame parent;
 	private Parameters parameters;

 
 	public StartPanel (JFrame frame, Parameters parameters) {
 		parent = frame;
 		this.parameters = parameters;
 		startButton = new StartButton();
 		parametersButton = new ParametersButton();
 		infoButton = new InfoButton();
 		setLayout(null);
 		setPreferredSize(new Dimension(WIDTH, HEIGHT));
 		add(startButton);
 		add(parametersButton);
 		add(infoButton);
 		panel = this;
 		startButton.setBounds(10,10,200,50);
 		parametersButton.setBounds(10,70,200,50);
 		infoButton.setBounds(10,130,200,50);
 	}
 	/**
 	 * Ustawia referencje do parametrów
 	 * @param parameters - referencja do parametrów
 	 */
 	public void setParameters(Parameters parameters) {
 		this.parameters = parameters;
 	}
 
 	class StartButton extends JButton implements ActionListener {


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
 	
 	class InfoButton extends JButton implements ActionListener {


		InfoButton() {
 			super("Info");
 			addActionListener(this);
 		}
 
 		@Override
 		public void actionPerformed(ActionEvent e) {
 			JOptionPane.showMessageDialog(parent,"CrazyAnimals V1.0.0\nAuthors: Mikołaj Chmielecki & Jakub Mroziński");
 			
 		}
 	}
 	
 
 	class ParametersButton extends JButton implements ActionListener {
 
		private ParametersFrame frame;

		ParametersButton() {
 			super("Configure parameters");
 			
 			addActionListener(this);
 		}
 
 		@Override
 		public void actionPerformed(ActionEvent e) {
 			frame = new ParametersFrame(panel, parameters);
 			frame.showFrame();
 		}
 	}
 
 }