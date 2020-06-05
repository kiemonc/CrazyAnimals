/**
 * 
 */
package objectProgramming.crazyAnimals.swing;

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
public class AnimalStatsFrame extends JFrame implements ActionListener{

	
	private int [] values;
	private JLabel species, hunger, thirst, age, isMale, iterationsToMove;
	private List<JLabel> labelsList = new LinkedList<>();
	private JButton close = new JButton("Close");
	/**
	 * Konstruktor tworzy okienko oraz umieszcza na nim etykiety z wartościami parametrów zwierzęcia podanego jako argument
	 * @param animal referencja do zwierzęcia, dla którego wyświetlane są statystyki
	 */
	public AnimalStatsFrame(IAnimal animal) {
		super("Animal stats");
		setLocation(200, 200);
		setSize(250, 280);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		setResizable(false);
		
		values = animal.getStats();
		
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
		
		close.setBounds(60, 210, 100, 20);
		close.addActionListener(this);
		add(close);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == close) {
			dispose();
		}
	}
}
