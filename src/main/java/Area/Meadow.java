package Area;

import java.util.List;
import java.util.LinkedList;
import java.util.Random;


/**
 * @author Miko�aj
 * Klasa odpowiada za przechowywanie informacji o stanie ��ki. Klasa sk�ada si� z p�l sk�adowych. Rozmieszcza wopoje oraz po�ywienie podczas inicjalizacji planszy. 
 * Rozmieszcza nowe po�ywienie podczas trwania symulacji.
 * Zawiera dwuwymiarow� list� p�l.
 */
public final class Meadow implements IMeadow {
	
	private int width;
	private int height;
	private List<List<IField>> fields;
	private List<IField> fieldsWithoutFeed;
	private Random random = new Random(0);
	
/**
 * Konstruktor klasy Meadow tworzy ��ke z zadanymi parametrami pocz�tkowymi
 * Generuje dwuwymiarow� list� p�l oraz dodaje pola do listy p�l bez po�ywienia
 * @param width Szeroko�� ��ki
 * @param height Wysoko�� ��ki
 * @param numWaterholes Ilo�� wodopoi
 * @param numFeeds Pocz�tkowa ilo�� po�ywienia
 */
	public Meadow(int width, int height, int numWaterholes, int numFeeds) {
		fields = new LinkedList<List<IField>>();
		//wiersze i kolumny s� numerowane tak samo jak w macierzy
		//pole o wsp�rz�dnych (0,0) znajduje si� w lewym g�rnym rogu.
		for(int y = 0; y < height; y++) {
			fields.add(new LinkedList<IField>());
			for(int x = 0; x < width; x++) {
				Field field = new Field(x,y);
				fields.get(y).add(field);
				fieldsWithoutFeed.add(field);
			}
		}
		initialWaterholes(numWaterholes);
		initialFeed(numFeeds);
	}
	
/**
 * Inicjalizuje po�ywienie w liczbie zadanej w parametrze. Inicjalizacja odbywa si� w spos�b losowy.	
 * @param numFeeds Liczba po�ywienia
 */
	private void initialFeed(int numFeeds) {
		//lista przechowuje wsp�rz�dne p�l, na kt�rych nie zosta�o jeszcze po�o�one po�ywienie
		//int[0] - x; int[1] - y
		List<int[]> coordinates = new LinkedList<int[]>();
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				int [] newCoordinates = {x,y};
				coordinates.add(newCoordinates);
			}
		}
		
		for(int i = 0; i < numFeeds; i++) {
			if(coordinates.isEmpty()) break;
			int randomIndex = random.nextInt(coordinates.size());
			int [] newCoordinates = coordinates.get(randomIndex);
			fields.get(newCoordinates[1]).get(newCoordinates[0]).putNewFeed();
		}
	}
	
/**
 * Metoda inicjalizuje wodopoje w takiej ilo�ci jaka zosta�a podana w argumencie. Podmienia referencje do wodopoi w li�cie p�l. Rozmieszcza wodopoje jedynie na brzegach planszy.
 * Podmienia pola w li�cie p�l nie posiadaj�cych po�ywienia na wygenerowane wodopoje.
 * @param numWaterholes - ilo�� wodopi
 */
	private void initialWaterholes(int numWaterholes) {
		//lista dwuwymiarowej tablicy licz ca�owitych zawieraj�ca wsp�rz�dne p�l, kt�re nie s� wodopojami 
		//int[0] - x; int[1] - y
		List<int[]> usualFields = new LinkedList<int[]>();
		
		for(int i = 0; i < width; i++) {
			//g�ra
			int [] coordinates = {i,0};
			usualFields.add(coordinates);
			
			//d�
			coordinates[0] = i;
			coordinates[1] = height-1;
			usualFields.add(coordinates);
		}
		
		for(int i = 0; i < height; i++) {
			//lewa
			int [] coordinates = {0,i};
			usualFields.add(coordinates);
			
			//prawa
			coordinates[0] = width-1;
			coordinates[1] = i;
			usualFields.add(coordinates);
		}
		
		for(int i = 0; i < numWaterholes; i++) {
			if(usualFields.isEmpty()) break;
			int randomIndex = random.nextInt(usualFields.size());
			int [] coordinates = usualFields.get(randomIndex);
			fields.get(coordinates[1]).set(coordinates[0], new Waterhole(coordinates[0], coordinates[1]));
			usualFields.remove(randomIndex);
		}
	}
	
/**
 * Metoda wyszukuje i tworzy list� s�siad�w
 * @param field Pole, kt�rego s�siad�w nale�y znalez�
 * @return lista najbli�szych s�siad�w
 */
	public List<IField> getNeighbours(IField field) {
		int x = field.getCoordinates()[0];
		int y = field.getCoordinates()[1];
		List<IField> neighbours = new LinkedList<IField>();
		if(x > 0) {
			neighbours.add(fields.get(y).get(x-1));
			if(y > 0) {
				neighbours.add(fields.get(y-1).get(x-1));
			}
		}
		if(x < width-1) {
			neighbours.add(fields.get(y).get(x+1));
			if(y < height-1) {
				neighbours.add(fields.get(y+1).get(x+1));
			}
		}
		if(y > 0) {
			neighbours.add(fields.get(y-1).get(x));
			if(x < width-1) {
				neighbours.add(fields.get(y-1).get(x+1));
			}
		}
		if(y < height-1) {
			neighbours.add(fields.get(y+1).get(x));
			if(x > 0) {
				neighbours.add(fields.get(y+1).get(x-1));
			}
		}
		
		return neighbours;
	}
	
/**
 * Dok�ada po�ywienie w poszczeg�lnych iteracjach symulacji. Dok�ada tak� ilo�� po�ywienia by utrzymywa� sta�� warto�� po�ywienia na ��cem jednak liczba do�o�onego po�ywienia w danej iteracji nie mo�e przekroczy� zadanej warto�ci.
 */
	private void spreadNewFeed() {
		List<IField> list = getRandomFields(height*width/10);
		for(IField field : list) {
			field.putNewFeed();
		}
	}

/**
 * Wykonuje rutynowe czyno�ci, kt�re s� niezb�dne podczas iterowania symulacji, czyli m.in. rozk�ada nowe po�ywienie
 */
	public void doIteration() {
		spreadNewFeed();
	}

	
/**
 * Zwraca list� losowych p�l w liczbie zadanej w parametrze
 * @param numFields liczba p�l do zwr�cenia
 * @return List<IField> lista losowych p�l
 */
	public List<IField> getRandomFields(int numFields) {
		List<IField> allFields = new LinkedList<IField>();
		for(int i = 0; i < height; i++) {
			allFields.addAll(fields.get(i));
		}
		
		List<IField> randomFields = new LinkedList<IField>();
		
		for(int i = 0; i < numFields; i++) {
			if(allFields.isEmpty()) break;
			int randomIndex = random.nextInt(allFields.size());
			randomFields.set(i, allFields.get(randomIndex));
			allFields.remove(randomIndex);
		}
		
		return randomFields;
	}

	
}