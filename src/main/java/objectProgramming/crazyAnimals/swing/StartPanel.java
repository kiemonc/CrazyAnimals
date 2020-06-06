package objectProgramming.crazyAnimals.swing;
import objectProgramming.crazyAnimals.main.Main;
import objectProgramming.crazyAnimals.main.Parameters;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
 

/**
 * Panel startowy grupuje 3 przyciski: start symulacji, konfigurajca oraz informacje o projekcie.
 * W momencie kliknięcia w jeden z nich wywołuje odpowiednie akcje.
 * @author Mikołaj
 *
 */
 @SuppressWarnings("serial")
public class StartPanel extends JPanel implements ActionListener{
 
	public static final int HEIGHT = 190;
 	public static final int WIDTH = 220;
 	private JButton startButton;
 	private JButton parametersButton;
 	private JButton infoButton;
 	private StartPanel panel;
 	private JFrame parent;
 	private Parameters parameters;

 /**
  * Dodaje przyciski oraz odpowiednie je wyrównuje
  * @param frame - referencja do Frame, gdzie panel jest wykorzystywany
  * @param parameters - parametry domyślne
  */
 	public StartPanel (JFrame frame, Parameters parameters) {
 		parent = frame;
 		this.parameters = parameters;
 		startButton = new JButton("Start simulation");
 		parametersButton = new JButton("Configure parameters");
 		infoButton = new JButton("Info");
 		startButton.addActionListener(this);
 		parametersButton.addActionListener(this);
 		infoButton.addActionListener(this);
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

/**
 * Przechwytuje zdarzenia po kliknięciu 1 z 3 przycisków.
 * Wykonuje akcje przypisane do danego przycisku.
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == startButton) {
			parent.setVisible(false);
 			if(parameters!=null) Main.runSimulation(parameters);
 			else Main.runSimulation();
		}
		if(source == parametersButton) {
			ParametersFrame frame = new ParametersFrame(panel, parameters);
			frame.showFrame();
		}
		if(source == infoButton) {
 			JOptionPane.showMessageDialog(parent,"CrazyAnimals V1.0.0\nAuthors: Mikołaj Chmielecki & Jakub Mroziński");
		}
		
	}
 
 }