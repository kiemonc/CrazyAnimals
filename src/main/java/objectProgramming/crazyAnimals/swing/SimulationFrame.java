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
 * GĹ‚Ăłwne okno symulacji. Grupuje panele niezbÄ™dne do przeprowadzenia sumulacji: panel opisu oznaczeĹ„, panele poszczegĂłlnych pĂłl, panel kontroli oraz panel statystyk.
 * @author MikoĹ‚aj
 *
 */
@SuppressWarnings("serial")
public class SimulationFrame extends JFrame {
	
	List<FieldPanel> panels;
	StatsPanel stats;
	LegendPanel legend;
	private JFrame frame;
	private Simulation simulation;
	private StartFrame startFrame;
	private Parameters parameters;
	private JLabel canClick = new JLabel("Clicking on the animal shows a window with its statistics"), simulationStats = new JLabel("Simulation statistics: ");
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
	 * Konstruktor okienka gĹ‚Ăłwnego symulacji. Ustawia podstawowe wĹ‚aĹ›ciwoĹ›ci okienka. Dodaje wymienione w opisie panele.
	 * Ustawia rozmiar okna na caĹ‚Ä… wielkoĹ›Ä‡ ekranu.
	 * @param simulation - referencja do aktualnie przeprowadzanej symulacji
	 * @param startFrame - referencja do startowego okienka aplikacji
	 * @param parameters - referencja do przyjÄ™tych parametrĂłw
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
		add(canClick);
		add(simulationStats);
		stats.setBounds(dimension.height - dimension.height/10, 80, dimension.width - dimension.height, 50);
		legend.setBounds(dimension.height - dimension.height/10, 130, dimension.width - dimension.height, 200);
		canClick.setBounds(50, dimension.height - 50, 500, 20);
		simulationStats.setBounds(dimension.height - dimension.height/10 + 50, 60, dimension.width - dimension.height, 20);
		
		ControlPanel controlPanel = new ControlPanel(timer,this,parameters.runAtStart);
		if(parameters.runAtStart) {
			timer.start();
		}
		controlPanel.setBounds(dimension.height - dimension.height/10, 200, dimension.width - dimension.height, 50);
		add(controlPanel);
		

	}
	
	/**
	 * CzynnoĹ›ci wykonywane podczas symulacji. Sprawdza czy nastÄ…piĹ‚ koniec symulacji.
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
		for(FieldPanel field : panels) {
			field.update();
		}
		stats.update(simulation.getItertionNum());
	}
	
	/**
	 * Inicjalizuje pola w okienku. Oblicza wymiary i odpowienio je rozmieszcza
	 * @param meadow - referencja do Ĺ‚Ä…ki
	 * @param maxSize - wysokoĹ›Ä‡ ekranu w px
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
				FieldPanel field = new FieldPanel(fieldSize, fields.get(i).get(j));
				panels.add(field);
				field.setBounds(offset+(fieldSize)*j, offset+(fieldSize)*i, fieldSize, fieldSize);
				field.setBorder(blackline);
				frame.add(field);
			}
		}
	}
	
	/**
	 * KoĹ„czenie symulacji. Zapisuje plik statystyk. WyĹ›wietla komunikat o koĹ„cu symulacji. Zamyka otwarte okna pomocnicze.
	 */
	void gameOver() {
		//updateState();
		for(FieldPanel panel : panels) {
			panel.finilize();
		}
		timer.stop();
		String endMessage = simulation.getEndMessage();
		if(endMessage == null) {
			endMessage = "user ingeration";
		}
		JOptionPane.showMessageDialog(frame,"End of simulation\nReason: " + endMessage + ".");
		try {
			SaveAsCSV.saveToFile(parameters);
			JOptionPane.showMessageDialog(frame,"File with statistics saved.\nPath: " + parameters.path);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame,"Saving file failed","Error",  JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		this.dispose();
		if(startFrame != null) {
			startFrame.setVisible(true);
		}
	}
}