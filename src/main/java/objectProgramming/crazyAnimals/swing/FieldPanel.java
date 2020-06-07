package objectProgramming.crazyAnimals.swing;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import objectProgramming.crazyAnimals.animal.*;
import objectProgramming.crazyAnimals.area.IField;
import objectProgramming.crazyAnimals.area.Feed;
import java.util.List;
import java.util.LinkedList;
import java.awt.Color;


/**
 * Panel pojedyńczego pola. Grupuje informacje o polu i obrazuje pole. 
 * @author Mikołaj
 *
 */
@SuppressWarnings("serial")
public class FieldPanel extends JPanel implements MouseListener{
 
	private int eatableSize;
	private int [] position = new int[2];
 	private IField field;
 	private List<IEatable> eatableList;
 	private Color darkGreen;
 	public List<AnimalStatsFrame> animalStatsFrames;
 	private int size;
 	
 	/**
 	 * Ustawia kolor panelu w zależności od typu pola, który symbolizuje.
 	 * Oblicza wartości rozmiarów i pozycji zawartych komponentów.
 	 * @param size - rozmiar pola
 	 * @param field - referencja do pola, które ten panel ma symbolizować
 	 */
 	public FieldPanel(int size, IField field) {
 		this.field = field;
 		this.size = size;
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
 		addMouseListener(this);
 		animalStatsFrames = new LinkedList<>();
 		update();
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
 					g.setColor(darkGreen);
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
 		if(animalStatsFrames.size() > 0) {
 			for(AnimalStatsFrame frame : animalStatsFrames) {
 				frame.update();
 			}
 		}
 	}
 	
 	/**
 	 * Zamyka wszystkie okna pomocnicze sulacji otwarte z poziomy danego pola
 	 */
 	public void finilize() {
 		for(AnimalStatsFrame frame : animalStatsFrames) {
 			frame.dispose();
 		}
 	}
 	
 	private IAnimal getClickedAnimal(int x, int y) {
 		int clickedPosition;
 		
 		/**
 		 * |0|1|
 		 * |2|3|
 		 */
  		if(y < size/2) {
  			if(x < size/2) {
  				clickedPosition = 0;
  			} else {
  				clickedPosition = 1;
  			}
 		} else {
  			if(x < size/2) {
  				clickedPosition = 2;
  			} else {
  				clickedPosition = 3;
  			}
 		}
  		if(clickedPosition < eatableList.size() && eatableList.get(clickedPosition) instanceof Animal) {
  			return (IAnimal) eatableList.get(clickedPosition);
  		} else {
  			return null;
  		}
 	}
 	
 	/**
 	 * Reaguje na kliknięcie myszki na dany panel
 	 */
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		IAnimal clickedAnimal = getClickedAnimal(e.getX(),e.getY());
		if(clickedAnimal != null) {
			animalStatsFrames.add(new AnimalStatsFrame(clickedAnimal, animalStatsFrames));
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

 }