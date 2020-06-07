package objectProgramming.crazyAnimals.swing;
import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 
 import javax.swing.JButton;
 import javax.swing.JPanel;
import objectProgramming.crazyAnimals.animal.*;
import objectProgramming.crazyAnimals.area.IField;
import objectProgramming.crazyAnimals.area.Feed;
import java.util.List;
import java.util.Random;
import java.util.LinkedList;
import java.awt.Color;


/**
 * Panel pojedyńczego pola. Grupuje informacje o polu i obrazuje pole. 
 * @author Mikołaj
 *
 */
@SuppressWarnings("serial")
public class FieldPanel2 extends JPanel{
 
	private int eatableSize;
	private int [] position = new int[2];
 	private JPanel panel;
 	private IField field;
 	private List<IEatable> eatableList;
 	private Color darkGreen;
 	
 	/**
 	 * Ustawia kolor panelu w zależności od typu pola, który symbolizuje.
 	 * Oblicza wartości rozmiarów i pozycji zawartych komponentów.
 	 * @param size - rozmiar pola
 	 * @param field - referencja do pola, które ten panel ma symbolizować
 	 */
 	public FieldPanel2(int size, IField field) {
 		panel = this;
 		this.field = field;
 		setLayout(null);
 		setSize(new Dimension(size, size));
 		if(field instanceof objectProgramming.crazyAnimals.area.Waterhole) {
 			setBackground(Color.cyan);
 		} else {
 			setBackground(Color.green);
 		}
 		eatableSize = size*4/10;
 		position[0] = size*1/20;
 		position[1] = size*11/20;
 		repaint();
 		eatableList = new LinkedList<>();
 		darkGreen = new Color(0, 100, 0);
 	}

 	/**
 	 * Wrysowuje odpowiednie kwadraciki w pole, w kolorach odpowiadających danemu Eatable
 	 */
 	@Override
 	public void paintComponent(Graphics g) {
 		super.paintComponent(g);
 		int i = 0;
 		for(IEatable eatable : eatableList) {
 			if(eatable instanceof Animal) {
 				if(eatable instanceof Cat) {
 					g.setColor(Color.black);
	 			} else if(eatable instanceof Cow) {
	 				g.setColor(Color.magenta);
	 			} else if(eatable instanceof Mouse) {
	 				g.setColor(Color.gray);
	 			} else if(eatable instanceof Sheep) {
	 				g.setColor(Color.white);
	 			} else if(eatable instanceof Wolf) {
	 				g.setColor(Color.orange);
	 			}
 				g.fillRect(position[i%2], position[i/2], eatableSize, eatableSize);
 				i++;
 			} else {
 				if(((Feed) eatable).getName()=="grass") {
 					g.setColor(new Color(0, 100, 0));
 				} else if(((Feed) eatable).getName()=="cheese") {
 					g.setColor(Color.yellow);
 				}
 				g.fillRect(position[1], position[1], eatableSize, eatableSize);
 			}
 		}
 	}
 	
 	/**
 	 * Aktualizuje stan pola
 	 */
 	void update() {
 		List<IEatable> newList = field.getEatable();
 		if(newList != null && !eatableList.equals(newList)) {
 			eatableList = newList;
 			repaint();
 		}
 	}
 	
 	/**
 	 * Zamyka wszystkie okna pomocnicze sulacji otwarte z poziomy danego pola
 	 */
 	public void finilize() {

 	}

 }