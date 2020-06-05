package objectProgramming.crazyAnimals.swing;
/**
 * 
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

import objectProgramming.crazyAnimals.main.Parameters;

/**
 * Klasa pozwalająca wyświetlić okno do zadawania parametrów początkowych symulacji                 //do edycji (actionPerformed() drugi "if")
 * @author jakub
 */
public class ParametersFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private List<JFormattedTextField> textFieldList = new LinkedList<>();
	private JButton confirm = new JButton("Confirm"), close = new JButton("Close");
	private JLabel error = new JLabel("Invalid format of parameters"), confirmed = new JLabel("Parameters saved");
	private Parameters parameters;
	
	/**
	 * Konstruktor klasy tworzy nowe okienko o odpowiednich parametrach oraz wywyłuje metody rozmieszczające na nim poszczególne elementy
	 */
	ParametersFrame(){
		super("Parameters");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(390, 430);
		setResizable(false);
		setLocation(200, 200);
		setLayout(null);
		
		showLabels(initiateLabels());
		textFieldList = initiateTextFields();
		showTextFields(textFieldList);
		
		confirm.setBounds(100, 360, 80, 20);
		confirm.addActionListener(this);
		add(confirm);
		close.setBounds(200, 360, 80, 20);
		close.addActionListener(this);
		add(close);
		error.setBounds(110, 450, 180, 20);
		add(error);
		confirmed.setBounds(130, 450, 180, 20);
		add(confirmed);
		
		setParameters();
		}
	/**
	 * Metoda "chwilowa" - do testów
	 * @param args nieużywane
	 */
	public static void main(String [] args) {
		ParametersFrame frame = new ParametersFrame();
		frame.showFrame();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if(source == confirm) {
			try {
				setParameters();
				error.setBounds(110, 450, 180, 20);
				confirmed.setBounds(130, 335, 180, 20);
			}
			catch (NumberFormatException e) {
				error.setBounds(110, 335, 180, 20);
				confirmed.setBounds(130, 450, 180, 20);
			}
		}
		if(source == close) {
			dispose();
			setVisible(false);//  <----- po dołączeniu do głównego okienka zastąpić tym linijkę powyżej
		}
	}
	/**
	 * Metoda tworzy etykiety, ustawia na nich odpowiedznie napisy i dodaje je do listy
	 * @return lista stworzonych etykiet
	 */
	private List<JLabel> initiateLabels() {
		JLabel width, height, numWaterholes, maxIterationNum, initialNumberOfAnimals, endNumberOfAnimals;
		JLabel [] initialAnimals = new JLabel[5], endAnimals = new JLabel[5], min = new JLabel[2], max = new JLabel[2];
		List<JLabel> labelList = new LinkedList<>();
		width = new JLabel("Meadow width:");
		labelList.add(width);
		height = new JLabel("Meadow height:");
		labelList.add(height);
		numWaterholes = new JLabel("Number of waterholes:");
		labelList.add(numWaterholes);
		maxIterationNum = new JLabel("Max number of iterations:");
		labelList.add(maxIterationNum);
		initialNumberOfAnimals = new JLabel("Initial number of animals:");
		labelList.add(initialNumberOfAnimals);
		initialAnimals[0] = new JLabel("Cats: ");
		initialAnimals[1] = new JLabel("Cows: ");
		initialAnimals[2] = new JLabel("Mouses: ");
		initialAnimals[3] = new JLabel("Sheeps: ");
		initialAnimals[4] = new JLabel("Wolevs: ");
		for(int i = 0; i < 5; i++) 
			labelList.add(initialAnimals[i]);
		endNumberOfAnimals = new JLabel("End number of animals:");
		labelList.add(endNumberOfAnimals);
		endAnimals[0] = new JLabel("Cats: ");
		endAnimals[1] = new JLabel("Cows: ");
		endAnimals[2] = new JLabel("Mouses: ");
		endAnimals[3] = new JLabel("Sheeps: ");
		endAnimals[4] = new JLabel("Wolevs: ");
		for(int i = 0; i < 5; i++) 
			labelList.add(endAnimals[i]);
		for(int i = 0; i < 2; i++) {
			min[i] = new JLabel("Minimum: ");
			max[i] = new JLabel("Maximum: ");
			labelList.add(min[i]);
			labelList.add(max[i]);
		}
		return labelList;
	}
	/**
	 * Metoda umieszcza etykiety przyjęte jako argument w odpowiednim miejscu okienka
	 * @param labelList lista etykiet która ma zostać wyświetlona
	 */
	private void showLabels(List<JLabel> labelList) {
		for(int i = 0; i < labelList.size(); i++) {
			if(i < 5 || i == 10)
				labelList.get(i).setBounds(20, 10 + 20 * i, 150, 20);
			else if(i < 16)
				labelList.get(i).setBounds(40, 10 + 20 * i, 130, 20);
			else 
				labelList.get(i).setBounds(180 + (i % 2 == 0 ? 0 : 80), (i < 18 ? 90 : 210), 60, 20);
			add(labelList.get(i));
		}
	}
	/**
	 * Metoda tworzy pola tekstowe, ustawia na nich odpowiedznie napisy i dodaje je do listy
	 * @return lista stworzonych pól tekstowych
	 */
	private List<JFormattedTextField> initiateTextFields() {
		JFormattedTextField width, height, numWaterholes, maxIterationNum;
		JFormattedTextField [] initialMinAnimals = new JFormattedTextField[5], initialMaxAnimals = new JFormattedTextField[5], endMinAnimals = new JFormattedTextField[5], endMaxAnimals = new JFormattedTextField[5];
		List<JFormattedTextField> textList = new LinkedList<>();
		width = new JFormattedTextField("10");
		textList.add(width);
		height = new JFormattedTextField("10");
		textList.add(height);
		numWaterholes = new JFormattedTextField("10");
		textList.add(numWaterholes);
		maxIterationNum = new JFormattedTextField("20");
		textList.add(maxIterationNum);
		for(int i = 0; i < 5; i++) {
			initialMinAnimals[i] = new JFormattedTextField("5");
			initialMaxAnimals[i] = new JFormattedTextField("5");
			textList.add(initialMinAnimals[i]);
			textList.add(initialMaxAnimals[i]);
		}
		for(int i = 0; i < 5; i++) {
			endMinAnimals[i] = new JFormattedTextField("5");
			endMaxAnimals[i] = new JFormattedTextField("5");
			textList.add(endMinAnimals[i]);
			textList.add(endMaxAnimals[i]);
		}
		return textList;
	}
	/**
	 * Metoda umieszcza pola tekstowe przyjęte jako argument w odpowiednim miejscu okienka
	 * @param textList lista pól tekstowych która ma zostać wyświetlona
	 */
	private void showTextFields(List<JFormattedTextField> textList) {
		for(int i = 0; i < textList.size(); i++) {
			if(i < 4)
				textList.get(i).setBounds(180, 10 + 20 * i, 140, 20);
			else if(i % 2 == 0)
				textList.get(i).setBounds(180, (i < 14 ? 70 : 90) + 20 * (i / 2), 65, 20);
			else
				textList.get(i).setBounds(255, (i < 14 ? 70 : 90) + 20 * (i / 2), 65, 20);
			add(textList.get(i));
		}
	}
	/**
	 * Zapisuje wartości pól do zmiennej parameters
	 * @throws NumberFormatException gdy w którymś polu są niepoprawne dane
	 */
	private void setParameters() throws NumberFormatException{
		int index = 0;
		boolean ifThrow = false;
		for(int i = 0; i < textFieldList.size(); i++) {
			setWhiteBackground(i);
		}
		try {
			Parameters param = new Parameters(new Random(1));
			param.meadowWidth = getTextFieldValue(index++);
			if(param.meadowWidth < 2 || param.meadowWidth > 100 ) {
				setRedBackground(index - 1);
				ifThrow = true;
			}
			param.meadowHeight = getTextFieldValue(index++);
			if(param.meadowHeight < 2 || param.meadowHeight > 100) {
				setRedBackground(index - 1);
				ifThrow = true;
			}
			param.numWaterholes = getTextFieldValue(index++);
			if(param.numWaterholes < 0 || param.numWaterholes > param.meadowHeight * param.meadowWidth) {
				setRedBackground(index - 1);
				ifThrow = true;
			}
			param.maxIterationNum = getTextFieldValue(index++);
			if(param.maxIterationNum < 2 || param.maxIterationNum > 1000000) {
				setRedBackground(index - 1);
				ifThrow = true;
			}
			for(int i = 0; i < 5; i++) {
				param.startMinNum[i] = getTextFieldValue(index++);
				param.startMaxNum[i] = getTextFieldValue(index++);
				if(param.startMaxNum[i] < param.startMinNum[i]) {
					setRedBackground(index - 1);
					setRedBackground(index - 2);
					ifThrow = true;
				}
			}
			for(int i = 0; i < 5; i++) {
				param.endMinNum[i] = getTextFieldValue(index++);
				param.endMaxNum[i] = getTextFieldValue(index++);
				if((param.endMaxNum[i] != -1 && param.endMinNum[i] != -1) && (param.endMaxNum[i] < param.endMinNum[i])) {
					setRedBackground(index - 1);
					setRedBackground(index - 2);
					ifThrow = true;
				}
			}
			for(int i = 0; i < 5; i++) {
				if(param.startMinNum[i] < param.endMinNum[i]) {
					setRedBackground(4 + 2 * i);
					setRedBackground(14 + 2 * i);
					ifThrow = true;
				}
				if(param.startMaxNum[i] > param.endMaxNum[i]) {
					setRedBackground(5 + 2 * i);
					setRedBackground(15 + 2 * i);
					ifThrow = true;
				}
			}
			int sum = 0;
			for(int i = 0; i < 5; i++)
				sum += param.startMaxNum[i];
			if(sum > param.meadowHeight * param.meadowWidth) {
				setRedBackground(0);
				setRedBackground(1);
				for(int i = 0; i< 5; i++)
					setRedBackground(5 + 2 * i);
				ifThrow = true;
			}
			if(ifThrow)
				throw(new NumberFormatException());
			parameters = param;
		}
		catch (NumberFormatException e) {
			throw e;
		}
	}
	/**
	 * Pozwala pobrać wartość z danego pola tekstowego
	 * @param index odpowiedni indeks pola w liście pól tekstowych
	 * @return wartość pola
	 * @throws NumberFormatException gdy w polu znajdzie się liczba
	 */
	private int getTextFieldValue(int index) throws NumberFormatException{
		int tmp;
		try {
			tmp = Integer.parseInt(textFieldList.get(index).getText());
			return tmp;
		}
		catch (NumberFormatException e){
			setRedBackground(index);
			throw e;
		}
	}
	/**
	 * Zmienia tło pola tekstowego o podanym indeksie na kolor czerwony
	 * @param index indeks pola tekstowego
	 */
	private void setRedBackground(int index) {
		textFieldList.get(index).setBackground(Color.red);
	}
	/**
	 * Zmienia tło pola tekstowego o podanym indeksie na kolor biały
	 * @param index indeks pola tekstowego
	 */
	private void setWhiteBackground(int index) {
		textFieldList.get(index).setBackground(Color.white);
	}
	/**
	 * Pozwala pobrać parametry zapisane podczas wyświetlania tego okna
	 * @return parametry symulacji
	 */
	public Parameters getParameters() {
		return parameters;
	}
	public void showFrame() {
		setVisible(true);
	}
}
