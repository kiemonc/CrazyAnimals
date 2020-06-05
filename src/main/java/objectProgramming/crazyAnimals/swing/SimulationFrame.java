package objectProgramming.crazyAnimals.swing;


import objectProgramming.crazyAnimals.area.Meadow;
import objectProgramming.crazyAnimals.area.IField;
import javax.swing.*;
import java.util.List;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.LinkedList;

public class SimulationFrame extends JFrame {
	
	List<FieldPanel> panels;
	private static final long serialVersionUID = -6866565494360362395L;
	private JFrame frame;
	/**
	 * Konstruktor okienka głównego symulacji. Ustawia podstawowe właściwości okienka.
	 * 
	 */
	public SimulationFrame(Meadow meadow) {
		super("Crazy Animals");
		frame = this;
		setLayout(null);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		setResizable(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
 		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		initalizePanels(meadow, dimension.height);
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
			fieldSize = maxSize*9/10/width;
		} else {
			fieldSize = maxSize*9/10/height;
		}
		int offset = 1/10*maxSize;
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				FieldPanel field = new FieldPanel(fieldSize, fields.get(i).get(j));
				panels.add(field);
				field.setBounds(offset+fieldSize*j, offset+fieldSize*i, fieldSize, fieldSize);
				frame.add(field);
			}
		}
	}
	
	public void update() {
		for(FieldPanel field : panels) {
			field.updateButtons();
		}
	}
	
	
	
}