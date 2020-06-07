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
import objectProgramming.crazyAnimals.animal.AnimalStats;
import objectProgramming.crazyAnimals.area.Feed;

/**
 * Klasa odpowiada za zapisywanie parametrów i statystyk do pliku 
 * @author jakub
 */
public class SaveAsCSV {
	/**
	 * Zawiera pierwszą linię pliku, jest ona dodawana tylko gdy plik był pusty
	 */
	private static String firstRow = "date, meadow height, meadow width, number of waterholes, max iterations number, "
			+ "min cats on start, min cows on start, min mouses on start, min sheeps on start, min wolves on start, "
			+ "max cats on start, max cows on start, max mouses on start, max sheeps on start, max wolves on start, "
			+ "min cats at the end, min cows at the end, min mouses at the end, min sheeps at the end, min wolves at the end, "
			+ "max cats at the end, max cows at the end, max mouses at the end, max sheeps at the end, max wolves at the end, "
			+ "current number of cheese, max number of cheese, eaten cheese, destroyed cheese, "
			+ "current number of grass, max number of grass, eaten grass, destroyed grass, "
			+ "current population of cats, current population of cows, current population of mouses, current population of sheeps, current population of wolves, "
			+ "max population of cats, max population of cows, max population of mouses, max population of sheeps, max population of wolves";
	/**
	 * Zapisuje parametry i statystyki symulacji do pliku
	 * @param parameters obiekt z parametrami początkowymi symulacji
	 * @throws IOException gdy zapis pliku się nie powiódł
	 */
	public static void saveToFile(Parameters parameters) throws IOException{
		String tmp = parameters.path;
		if(!tmp.contains(".csv"))
			tmp += ".csv";
		try {
			File file = new File(tmp);
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
