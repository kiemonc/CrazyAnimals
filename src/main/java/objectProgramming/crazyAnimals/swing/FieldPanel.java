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
import java.util.LinkedList;
import java.awt.Color;

 public class FieldPanel extends JPanel{
 

	private static final long serialVersionUID = -3130896061420606792L;
	private int buttonSize;
	private int [] position = new int[2];
 	List<EatableButton> eatableButtons;
 	private JPanel panel;
 	private IField field;
 	
 	/**
 	 * Ustawia kolor panelu w zależności od typu pola, który symbolizuje 
 	 * @param size - rozmiar pola
 	 * @param field - referencja do pola, które ten panel ma symbolizować
 	 */
 	public FieldPanel(int size, IField field) {
 		panel = this;
 		this.field = field;
 		setLayout(null);
 		setSize(new Dimension(size, size));
 		if(field instanceof objectProgramming.crazyAnimals.area.Waterhole) {
 			setBackground(Color.cyan);
 		} else {
 			setBackground(Color.green);
 		}
 		initializeButtons(size);
 	}
 
 	
 	/**
 	 * Przycisk, odpowiedzialny za wyświetlanie położenia zwierzęcia lub pożywienia na planszy. Po kliknieciu uruchamia odpowiednie okno ze statystykami danego obieku.
 	 * @author Mikołaj
 	 *
 	 */
 	class EatableButton extends JButton implements ActionListener {

		private static final long serialVersionUID = -8313704398963260970L;
		private IEatable eatable;
		public EatableButton() {
 			addActionListener(this);
		}
		/**
		 * Uaktualnia stan przycisku, zmienia kolor.
		 * @param eatable - obiekt który przycisk ma symbolizować
		 */
		void update(IEatable eatable) {
 			this.eatable = eatable;
 			if(eatable instanceof Cat) {
 				setBackground(Color.black);
 			} else if(eatable instanceof Cow) {
 				setBackground(Color.magenta);
 			} else if(eatable instanceof Mouse) {
 				setBackground(Color.gray);
 			} else if(eatable instanceof Sheep) {
 				setBackground(Color.white);
 			} else if(eatable instanceof Wolf) {
 				setBackground(Color.orange);
 			} else if(eatable instanceof Feed) {
 				if(((Feed) eatable).getName()=="grass") {
 					setBackground(Color.getHSBColor(116, 2, 42));
 				} else if(((Feed) eatable).getName()=="cheese") {
 					setBackground(Color.yellow);
 				}
 			}
 		}
		
		/**
		 * Uruchamia okno ze statystykami
		 */
 		@Override
 		public void actionPerformed(ActionEvent e) {
 			if(eatable instanceof Animal) {
 				new AnimalStatsFrame((IAnimal) eatable);
 			}
 		}
 	}
 	
 	/**
 	 * Inicjalizuje przyciski. Rozmieszcza przyciski i ustawia na niewidocze.
 	 */
 	private void initializeButtons(int size) {
 		eatableButtons = new LinkedList<>();
 		buttonSize = size*4/10;
 		position[0] = size*1/20;
 		position[1] = size*11/20;
 		
 		for(int i = 0; i < 4; i++) {
 			eatableButtons.add(new EatableButton());
 		}
 		for(EatableButton button : eatableButtons) {
 			button.setVisible(false);
 		}
 		eatableButtons.get(0).setBounds(position[0], position[0], buttonSize, buttonSize);
 		eatableButtons.get(1).setBounds(position[1], position[0], buttonSize, buttonSize);
 		eatableButtons.get(2).setBounds(position[0], position[1], buttonSize, buttonSize);
 		eatableButtons.get(3).setBounds(position[1], position[1], buttonSize, buttonSize);
 		for(EatableButton button : eatableButtons) {
 			panel.add(button);
 		}
 	}
 	
 	/**
 	 * Aktaulizuje stan każdego z przycisków. Pożywienie umieszcza w prawym dolnym przycisku
 	 */
 	public void updateButtons() {
 		for(EatableButton button : eatableButtons) {
 			button.setVisible(false);
 		}
 		int i = 0;
 		List<IEatable> objects = field.getEatable();
 		if(objects!=null) {
	 		for(IEatable eatable : objects) {
	 			if(eatable instanceof Animal) {
	 				eatableButtons.get(i).update(eatable);
	 				eatableButtons.get(i).setVisible(true);
	 				i++;
	 			} else {
	 				eatableButtons.get(3).update(eatable);
	 				eatableButtons.get(3).setVisible(true);
	 			}
	 		}
 		}
 	}

 }