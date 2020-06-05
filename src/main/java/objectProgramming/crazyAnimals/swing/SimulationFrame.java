package objectProgramming.crazyAnimals.swing;


import objectProgramming.crazyAnimals.area.Meadow;
import objectProgramming.crazyAnimals.main.BadParametersException;
import objectProgramming.crazyAnimals.main.Parameters;
import objectProgramming.crazyAnimals.main.Simulation;
import objectProgramming.crazyAnimals.area.IField;
import javax.swing.*;
import javax.swing.border.Border;

import java.util.List;
import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class SimulationFrame extends JFrame {
	
	List<FieldPanel> panels;
	StatsPanel stats;
	LegendPanel legend;
	private static final long serialVersionUID = -6866565494360362395L;
	private JFrame frame;
	private Simulation simulation;
	private Timer timer;
	/**
	 * Konstruktor okienka głównego symulacji. Ustawia podstawowe właściwości okienka.
	 * 
	 */
	public SimulationFrame(Simulation simulation) {
		super("Crazy Animals");
		frame = this;
		
		setLayout(null);
		this.simulation = simulation;
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		setResizable(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
 		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		initalizePanels(simulation.getMeadow(), dimension.height);
		stats = new StatsPanel();
		legend = new LegendPanel();
		add(stats);
		add(legend);
		stats.setBounds(dimension.height - dimension.height/10, 50, dimension.width - dimension.height, 50);
		legend.setBounds(dimension.height - dimension.height/10, 100, dimension.width - dimension.height, 200);
		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				simulation.doIteration();
				for(FieldPanel field : panels) {
					field.updateButtons();
				}
				stats.update();
			}
			
		});
		timer.start();
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
				/**
				if(i==0 && j!= width-1) {
					blackline = BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK);
				} else if(i==0 && j== width-1) {
					blackline = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK);
				} else if(j < width - 1){
					blackline = BorderFactory.createMatteBorder(0, 1, 1, 0, Color.BLACK);
				} else {
					blackline = BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK);
				}
				**/
				FieldPanel field = new FieldPanel(fieldSize, fields.get(i).get(j));
				panels.add(field);
				field.setBounds(offset+(fieldSize)*j, offset+(fieldSize)*i, fieldSize, fieldSize);
				field.setBorder(blackline);
				frame.add(field);
			}
		}
	}
	
	public void update() {
		for(FieldPanel field : panels) {
			field.updateButtons();
		}
		stats.update();
	}
	
	
	public static void main(String[] args) {
		Parameters parameters = new Parameters(new Random(0));
		parameters.initializeNumAnimals();
		try {
			parameters.setParametrs();
		} catch (BadParametersException e) {
			e.printStackTrace();
		}
		Simulation simulation = new Simulation(parameters, new Random(0));

 		EventQueue.invokeLater(new Runnable() {
 			@Override
 			public void run() {
 				new SimulationFrame(simulation);
 			}
 		});
	}
}