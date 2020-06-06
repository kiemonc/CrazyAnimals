package objectProgramming.crazyAnimals.swing;
/**
 * 
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

import objectProgramming.crazyAnimals.main.BadParametersException;
import objectProgramming.crazyAnimals.main.Parameters;

/**
 * Klasa pozwalająca wyświetlić okno do zadawania parametrów początkowych symulacji
 * @author jakub
 */
public class ParametersFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private List<JFormattedTextField> textFieldList = new LinkedList<>();
	private JButton confirm = new JButton("Confirm"), close = new JButton("Close"), setFilePath = new JButton("Set file path"), setDefaults = new JButton("Set defaults");
	private JLabel error = new JLabel("Invalid format of parameters"), confirmed = new JLabel("Parameters saved"), filePath, info = new JLabel("* \"-1\" - does not matter");
	private Parameters parameters;
	private StartPanel startPanel;
	
	/**
	 * Konstruktor klasy tworzy nowe okienko o odpowiednich parametrach oraz wywyłuje metody rozmieszczające na nim poszczególne elementy
	 */
	ParametersFrame(StartPanel panel, Parameters parameters){
		super("Parameters");
		startPanel=panel;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(390, 480);
		setResizable(false);
		setLocation(200, 200);
		setLayout(null);
		this.startPanel = panel;
		showLabels(initiateLabels());
		textFieldList = initiateTextFields();
		showTextFields(textFieldList);
		
		filePath = new JLabel();
		add(setFilePath);
		add(filePath);
		setFilePath.setBounds(20, 350, 130, 20);
		filePath.setBounds(20, 330, 300, 20);
		setFilePath.addActionListener(this);
		add(setDefaults);
		setDefaults.setBounds(210, 350, 130, 20);
		setDefaults.addActionListener(this);
		info.setBounds(20, 420, 200, 20);
		add(info);
		
		confirm.setBounds(100, 400, 80, 20);
		confirm.addActionListener(this);
		add(confirm);
		close.setBounds(200, 400, 80, 20);
		close.addActionListener(this);
		add(close);
		error.setBounds(110, 500, 180, 20);
		error.setForeground(Color.red);
		add(error);
		confirmed.setBounds(130, 500, 180, 20);
		add(confirmed);
		
		setValues(parameters);
		setParameters();
		}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if(source == confirm) {
			try {
				setParameters();
				parameters.setParametrs();
				error.setBounds(110, 500, 180, 20);
				confirmed.setBounds(130, 380, 180, 20);
				startPanel.setParameters(parameters);
			}
			catch (NumberFormatException | BadParametersException e) {
				error.setBounds(110, 380, 180, 20);
				confirmed.setBounds(130, 500, 180, 20);
			}
		}
		if(source == close) {
			dispose();
		}
		if(source == setFilePath) {
			try{
				JFileChooser fileChooser = new JFileChooser(new File(parameters.path));
				fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
				fileChooser.setFileFilter(new FileNameExtensionFilter("CSV file", ".csv"));
				fileChooser.showOpenDialog(fileChooser);
				if(!fileChooser.getSelectedFile().getPath().contains(".csv"))
					parameters.path = fileChooser.getSelectedFile().getPath() + ".csv";
				else parameters.path = fileChooser.getSelectedFile().getPath();
			filePath.setText("File path: " + parameters.path);
			}
			catch(NullPointerException e) {
				
			}
		}
		if(source == setDefaults) {
			setValues(null);
		}
	}
	/**
	 * Metoda ustawia wszystkie pola na wartości domyślne lub zapisane w argumencie
	 * @param parameters obiekt zawierający parametry symulacji (gdy null pobierane są wartości domyślne)
	 */
	private void setValues(Parameters parameters) {
		if(parameters == null)
			parameters = new Parameters(new Random());
		try {
			parameters.setParametrs();
			textFieldList.get(0).setText(parameters.meadowWidth + "");
			textFieldList.get(1).setText(parameters.meadowHeight + "");
			textFieldList.get(2).setText(parameters.numWaterholes + "");
			textFieldList.get(3).setText(parameters.maxIterationNum + "");
			for(int i = 0; i < 5; i++) {
				textFieldList.get(4 + 2 * i).setText(parameters.startMinNum[i] + "");
				textFieldList.get(5 + 2 * i).setText(parameters.startMaxNum[i] + "");
			}
			for(int i = 0; i < 5; i++) {
				textFieldList.get(14 + 2 * i).setText(parameters.endMinNum[i] + "");
				textFieldList.get(15 + 2 * i).setText(parameters.endMaxNum[i] + "");
			}
			filePath.setText("File path: " + parameters.path);
			this.parameters = parameters;
		} catch (BadParametersException e) {
			
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
		endNumberOfAnimals = new JLabel("End number of animals: *");
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
	 * Metoda tworzy pola tekstowe i dodaje je do listy
	 * @return lista stworzonych pól tekstowych
	 */
	private List<JFormattedTextField> initiateTextFields() {
		List<JFormattedTextField> textList = new LinkedList<>();
		for(int i = 0; i < 24; i++)
			textList.add(new JFormattedTextField());
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
			if(param.meadowWidth < 2 || param.meadowWidth > 30 ) {
				setRedBackground(index - 1);
				ifThrow = true;
			}
			param.meadowHeight = getTextFieldValue(index++);
			if(param.meadowHeight < 2 || param.meadowHeight > 30) {
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
				if(param.endMinNum[i] != -1 && param.startMinNum[i] < param.endMinNum[i]) {
					setRedBackground(4 + 2 * i);
					setRedBackground(14 + 2 * i);
					ifThrow = true;
				}
				if(param.endMaxNum[i] != -1 && param.startMaxNum[i] > param.endMaxNum[i]) {
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
		//TODO dodać ustawienie wartości parameters.path
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
	/**
	 * Wyświetla okienko z parameterami
	 */
	public void showFrame() {
		setVisible(true);
	}
}
