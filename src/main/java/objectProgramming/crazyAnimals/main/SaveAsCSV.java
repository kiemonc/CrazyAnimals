/**
 * 
 */
package objectProgramming.crazyAnimals.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import objectProgramming.crazyAnimals.animal.AnimalStats;
import objectProgramming.crazyAnimals.area.Feed;

/**
 * @author jakub
 *
 */
public class SaveAsCSV {
	/**
	 * Zawiera ścieżkę do pliku w którym są zapisywane dane
	 */
	private static String filePath = "data.csv";
	private static String firstRow = "date, meadow height, meadow width, number of waterholes, max iterations number, "
			+ "min cats on start, min cows on start, min mouses on start, min sheeps on start, min wolves on start, "
			+ "max cats on start, max cows on start, max mouses on start, max sheeps on start, max wolves on start, "
			+ "min cats at the end, min cows at the end, min mouses at the end, min sheeps at the end, min wolves at the end, "
			+ "max cats at the end, max cows at the end, max mouses at the end, max sheeps at the end, max wolves at the end, "
			+ "created cheese, max number of cheese, eaten cheese, destroyed cheese, "
			+ "created grass, max number of grass, eaten grass, destroyed grass, "
			+ "current population of cats, current population of cows, current population of mouses, current population of sheeps, current population of wolves, "
			+ "max population of cats, max population of cows, max population of mouses, max population of sheeps, max population of wolves";
	/**
	 * Zapisuje parametry i statystyki symulacji do pliku (wersja konsolowa)
	 * @param parameters obiekt z parametrami początkowymi symulacji
	 */
	public static void saveToFile(Parameters parameters) throws IOException{
		/**
		System.out.print("Enter file path (.csv): ");
		Scanner scanner = new Scanner(System.in);
		String tmp = scanner.nextLine();
		scanner.close();
		**/
		
		String tmp = parameters.path;
		File file;
		if(tmp != "-")
			filePath = tmp;
		if(!filePath.contains(".csv")) {
			filePath += ".csv";
		}
		try {
			file = new File(filePath);
			PrintWriter writer;
			if(file.exists()) 
				writer = new PrintWriter(new FileWriter(file, true));
			else {
				writer = new PrintWriter(new FileWriter(file));
				writer.println(firstRow);
			}
			
			writer.println(getParamsAndStats(parameters));
			writer.close();
		} catch (IOException e) {
			System.out.println("File error");
			throw e;
		}
	}
	/**
	 * Zapisuje parametry i statystyki symulacji do pliku (wersja okienkowa)
	 * @param parameters obiekt z parametrami początkowymi symulacji
	 */
	public static void saveToFileInFrame(Parameters parameters) throws IOException{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
		fileChooser.setFileFilter(new FileNameExtensionFilter("CSV file", ".csv"));
		fileChooser.showOpenDialog(fileChooser);
		try {
			File file;
			if(!fileChooser.getSelectedFile().getPath().contains(".csv"))
				file = new File(fileChooser.getSelectedFile().getPath() + ".csv");
			else file = fileChooser.getSelectedFile();
			PrintWriter writer;
			if(file.exists()) 
				writer = new PrintWriter(new FileWriter(file, true));
			else {
				writer = new PrintWriter(new FileWriter(file));
				writer.println(firstRow);
			}
			
			writer.println(getParamsAndStats(parameters));
			writer.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Please try again", "File error", JOptionPane.INFORMATION_MESSAGE);
			throw e;
		}
	}
	/**
	 * Pobiera parametry początkowe i statystyki symulacji
	 * @param parameters obiekt z parametrami początkowymi symulacji
	 * @return wartości oddzielone przecinkami
	 */
	private static String getParamsAndStats(Parameters parameters) {
		String params = new String("");
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		params += format.format(new Date());
		params += ", " + parameters.meadowHeight + ", " + parameters.meadowWidth + ", " + parameters.numWaterholes + ", " + parameters.maxIterationNum;
		for(int i = 0; i < 5; i++)
			params += ", " + parameters.startMinNum[i];
		for(int i = 0; i < 5; i++)
			params += ", " + parameters.startMaxNum[i];
		for(int i = 0; i < 5; i++)
			params += ", " + parameters.endMinNum[i];
		for(int i = 0; i < 5; i++)
			params += ", " + parameters.endMaxNum[i];
		for(int i = 0; i < 2; i++) {
			params += ", " + Feed.getNumAll(i == 0 ? "cheese" : "grass");
			params += ", " + Feed.getNumMax(i == 0 ? "cheese" : "grass");
			params += ", " + Feed.getNumEaten(i == 0 ? "cheese" : "grass");
			params += ", " + Feed.getNumDestroyed(i == 0 ? "cheese" : "grass");
		}
		for(int i = 0; i < 5; i++)
			params += ", " + AnimalStats.getCurrentPopulation()[i];
		for(int i = 0; i < 5; i++)
			params += ", " + AnimalStats.getMaxPopulation()[i];
		return params;
	}
}
