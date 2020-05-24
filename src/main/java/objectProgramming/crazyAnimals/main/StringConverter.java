package objectProgramming.crazyAnimals.main;

import java.util.List;

import com.beust.jcommander.converters.IParameterSplitter;

import java.util.ArrayList;


/**
 * Klasa obsługująca parser. Konwertuje string na listę.
 * @author Mikołaj
 *
 */
public class StringConverter implements IParameterSplitter{
	/**
	 * Metoda konwertuje string licz oddzielonych przecinkami, na tablice liczb o długości 5
	 * @param value - łańcuch wejściowy
	 * @return lista liczb
	 */
	  @Override
	  public List<String> split(String value) {
	    String [] strings = value.split(",");
	    List<String> numbersAsString = new ArrayList<>();
	    for(int i = 0;  i < 5; i++){
	        numbersAsString.add(strings[i]);
	    }
	    return numbersAsString;
	  }
}