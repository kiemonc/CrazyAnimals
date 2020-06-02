/**
 * 
 */
package objectProgramming.crazyAnimals.main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	private static final String filePath = "data.csv";
	/**
	 * Zapisuje parametry i statystyki symulacji do pliku
	 * @param parameters obiekt z parametrami początkowymi symulacji
	 */
	public static void saveToFile(Parameters parameters) {
		try {
			PrintWriter writer = new PrintWriter(new FileWriter(filePath, true));
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
			writer.println(params);
			writer.close();
		} catch (IOException e) {
			System.out.print("File error");
		}
	}
}
