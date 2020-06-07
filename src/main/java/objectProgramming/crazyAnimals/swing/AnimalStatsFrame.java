/**
 * 
 */
package objectProgramming.crazyAnimals.swing;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import objectProgramming.crazyAnimals.animal.*;

/**
 * Klasa odpowiada za wyświetlanie okienka ze statystykami dla danego zwierzęcia
 * @author jakub
 */
@SuppressWarnings("serial")
public class AnimalStatsFrame extends JFrame implements ActionListener {

	private int [] values;
	private JLabel nr, xy, species, hunger, thirst, age, isMale, iterationsToMove;
	private List<JLabel> labelsList = new LinkedList<>();
	private JButton close = new JButton("Close");
	private IAnimal animal;
	private List<AnimalStatsFrame> animalStatsFrames;
	/**
	 * Konstruktor tworzy okienko oraz umieszcza na nim etykiety z wartościami parametrów zwierzęcia podanego jako argument
	 * @param animal referencja do zwierzęcia, dla którego wyświetlane są statystyki
	 * @param animalStatsFrames referencja do listy okienek z której to okienko jest usuwane gdy zwierzę umarło
	 */
	public AnimalStatsFrame(IAnimal animal, List<AnimalStatsFrame> animalStatsFrames) {
		super("Animal stats");
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dimension.width*4/7, dimension.height*1/7);
		setSize(250, 340);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		setResizable(false);
		setAlwaysOnTop(true);
		this.animal = animal;
		this.animalStatsFrames = animalStatsFrames;
		values = animal.getStats();
		
		nr = new JLabel("Number: " + values[5]);
		labelsList.add(nr);
		xy = new JLabel("Position (x, y): (" + values[6] + ", " + values[7] + ")");
		labelsList.add(xy);
		species = new JLabel("Species: " + (animal instanceof Cat ? "cat" : (animal instanceof Cow ? "cow" : (animal instanceof Mouse ? "mouse" : (animal instanceof Sheep ? "sheep" : (animal instanceof Wolf ? "wolf" : ""))))));
		labelsList.add(species);
		hunger = new JLabel("Hunger: " + values[0]);
		labelsList.add(hunger);
		thirst = new JLabel("Thirst: " + values[1]);
		labelsList.add(thirst);
		age = new JLabel("Age: " + values[2]);
		labelsList.add(age);
		isMale = new JLabel("Gender: " + (values[3] == 0 ? "female" : "male"));
		labelsList.add(isMale);
		iterationsToMove = new JLabel("Iterations to move: " + values[4]);
		labelsList.add(iterationsToMove);
		
		for(int i = 0; i < labelsList.size(); i++) {
			add(labelsList.get(i));
			labelsList.get(i).setBounds(30, 20 + i * 30, 150, 30);
		}
		
		close.setBounds(60, 270, 100, 20);
		close.addActionListener(this);
		add(close);
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @SuppressWarnings("unlikely-arg-type")
			@Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	((Animal)animal).setHasPanel(false);
				animalStatsFrames.remove(this);
		    }
		});
		}
	
	/**
	 * Metoda przechwytuje zdarzenie i zamyka okienko jeżeli jego źródłem jest przycisk close
	 * @param e przechwycone zdarzenie
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == close) {
			dispose();
			((Animal)animal).setHasPanel(false);
			animalStatsFrames.remove(this);
		}
	}
	/**
	 * Metoda aktualizuje wyświetlane statystyki według aktualnego stanu symulacji
	 */
	public void update() {
		if(animal.isDead()) {
			this.dispose();
			((Animal)animal).setHasPanel(false);
			animalStatsFrames.remove(this);
			return;
		}
		values = animal.getStats();
		nr.setText("Number: " + values[5]);
		xy.setText("Position (x, y): (" + values[6] + ", " + values[7] + ")");
		species.setText("Species: " + (animal instanceof Cat ? "cat" : (animal instanceof Cow ? "cow" : (animal instanceof Mouse ? "mouse" : (animal instanceof Sheep ? "sheep" : (animal instanceof Wolf ? "wolf" : ""))))));
		hunger.setText("Hunger: " + values[0]);
		thirst.setText("Thirst: " + values[1]);
		age.setText("Age: " + values[2]);
		isMale.setText("Gender: " + (values[3] == 0 ? "female" : "male"));
		iterationsToMove.setText("Iterations to move: " + values[4]);
	}
	
}
