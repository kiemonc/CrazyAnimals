package objectProgramming.crazyAnimals.swing;


import objectProgramming.crazyAnimals.area.Meadow;
import objectProgramming.crazyAnimals.main.Parameters;
import objectProgramming.crazyAnimals.main.SaveAsCSV;
import objectProgramming.crazyAnimals.main.Simulation;
import objectProgramming.crazyAnimals.area.IField;
import javax.swing.*;
import javax.swing.border.Border;

import java.util.List;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Główne okno symulacji. Grupuje panele niezbędne do przeprowadzenia sumulacji: panel opisu oznaczeń, panele poszczególnych pól, panel kontroli oraz panel statystyk.
 * @author Mikołaj
 *
 */
@SuppressWarnings("serial")
public class SimulationFrame extends JFrame {
	
	List<FieldPanel2> panels;
	StatsPanel stats;
	LegendPanel legend;
	private JFrame frame;
	private Simulation simulation;
	private StartFrame startFrame;
	private Parameters parameters;
	boolean gameOver;
	
	/**
	 * Steruje wykonywaniem kolejnych iteracji symulacji
	 */
	private Timer timer = new Timer(100, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			doIteration();
		}
		
	});
	
	/**
	 * Konstruktor okienka głównego symulacji. Ustawia podstawowe właściwości okienka. Dodaje wymienione w opisie panele.
	 * Ustawia rozmiar okna na całą wielkość ekranu.
	 * @param simulation - referencja do aktualnie przeprowadzanej symulacji
	 * @param startFrame - referencja do startowego okienka aplikacji
	 * @param parameters - referencja do przyjętych parametrów
	 */
	public SimulationFrame(Simulation simulation, StartFrame startFrame, Parameters parameters) {
		super("Crazy Animals");
		frame = this;
		this.startFrame = startFrame;
		this.simulation = simulation;
		this.parameters = parameters;
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
 		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);

		initalizePanels(simulation.getMeadow(), dimension.height);
	
		stats = new StatsPanel(simulation.getItertionNum());
		legend = new LegendPanel();
		add(stats);
		add(legend);
		stats.setBounds(dimension.height - dimension.height/10, 50, dimension.width - dimension.height, 50);
		legend.setBounds(dimension.height - dimension.height/10, 100, dimension.width - dimension.height, 200);

		ControlPanel controlPanel = new ControlPanel(timer,this);
		controlPanel.setBounds(dimension.height - dimension.height/10, 200, dimension.width - dimension.height, 50);
		add(controlPanel);
		

	}
	
	/**
	 * Czynności wykonywane podczas symulacji. Sprawdza czy nastąpił koniec symulacji.
	 */
	void doIteration() {
		if(!simulation.ifEnd()) {
			updateState();
		} else {
			gameOver();
		}
	}
	
	/**
	 * Aktualizuje stan wszystkich paneli.
	 */
	private void updateState() {
		simulation.doIteration();
		for(FieldPanel2 field : panels) {
			field.update();
		}
		stats.update(simulation.getItertionNum());
	}
	
	/**
	 * Inicjalizuje pola w okienku. Oblicza wymiary i odpowienio je rozmieszcza
	 * @param meadow - referencja do łąki
	 * @param maxSize - wysokość ekranu w px
	 */
	private void initalizePanels(Meadow meadow, int maxSize) {
		panels = new LinkedList<>();
		LinkedList<LinkedList<IField>> fields = meadow.getAllFields();
		int width = fields.get(0).size();
		int height = fields.size();
		int fieldSize;
		if(width > height) {
			fieldSize = maxSize*4/5/width;
		} else {
			fieldSize = maxSize*4/5/height;
		}
		int offset = maxSize/20;
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				Border blackline = BorderFactory.createLineBorder(Color.BLACK,1);
				FieldPanel2 field = new FieldPanel2(fieldSize, fields.get(i).get(j));
				panels.add(field);
				field.setBounds(offset+(fieldSize)*j, offset+(fieldSize)*i, fieldSize, fieldSize);
				field.setBorder(blackline);
				frame.add(field);
			}
		}
	}
	
	/**
	 * Kończenie symulacji. Zapisuje plik statystyk. Wyświetla komunikat o końcu symulacji. Zamyka otwarte okna pomocnicze.
	 */
	void gameOver() {
		//updateState();
		for(FieldPanel2 panel : panels) {
			panel.finilize();
		}
		timer.stop();
		JOptionPane.showMessageDialog(frame,"End of simulation");
		try {
			SaveAsCSV.saveToFile(parameters);
			JOptionPane.showMessageDialog(frame,"File with statistics saved.\nPath: " + parameters.path);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame,"Saving file failed","Error",  JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		this.dispose();
		startFrame.setVisible(true);
	}
}