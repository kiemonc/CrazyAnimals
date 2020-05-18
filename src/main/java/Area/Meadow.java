package Area;

import java.util.List;
import java.util.LinkedList;
import java.util.Random;


/**
 * @author Miko³aj
 * Klasa odpowiada za przechowywanie informacji o stanie ³¹ki. Klasa sk³ada siê z pól sk³adowych. Rozmieszcza wopoje oraz po¿ywienie podczas inicjalizacji planszy. 
 * Rozmieszcza nowe po¿ywienie podczas trwania symulacji.
 * Zawiera dwuwymiarow¹ listê pól.
 */
public final class Meadow implements IMeadow {
	
	private int width;
	private int height;
	private List<List<IField>> fields;
	private List<IField> fieldsWithoutFeed;
	private Random random = new Random(0);
	
/**
 * Konstruktor klasy Meadow tworzy ³¹ke z zadanymi parametrami pocz¹tkowymi
 * Generuje dwuwymiarow¹ listê pól oraz dodaje pola do listy pól bez po¿ywienia
 * @param width Szerokoœæ ³¹ki
 * @param height Wysokoœæ ³¹ki
 * @param numWaterholes Iloœæ wodopoi
 * @param numFeeds Pocz¹tkowa iloœæ po¿ywienia
 */
	public Meadow(int width, int height, int numWaterholes, int numFeeds) {
		fields = new LinkedList<List<IField>>();
		//wiersze i kolumny s¹ numerowane tak samo jak w macierzy
		//pole o wspó³rzêdnych (0,0) znajduje siê w lewym górnym rogu.
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
 * Inicjalizuje po¿ywienie w liczbie zadanej w parametrze. Inicjalizacja odbywa siê w sposób losowy.	
 * @param numFeeds Liczba po¿ywienia
 */
	private void initialFeed(int numFeeds) {
		//lista przechowuje wspó³rzêdne pól, na których nie zosta³o jeszcze po³o¿one po¿ywienie
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
 * Metoda inicjalizuje wodopoje w takiej iloœci jaka zosta³a podana w argumencie. Podmienia referencje do wodopoi w liœcie pól. Rozmieszcza wodopoje jedynie na brzegach planszy.
 * Podmienia pola w liœcie pól nie posiadaj¹cych po¿ywienia na wygenerowane wodopoje.
 * @param numWaterholes - iloœæ wodopi
 */
	private void initialWaterholes(int numWaterholes) {
		//lista dwuwymiarowej tablicy licz ca³owitych zawieraj¹ca wspó³rzêdne pól, które nie s¹ wodopojami 
		//int[0] - x; int[1] - y
		List<int[]> usualFields = new LinkedList<int[]>();
		
		for(int i = 0; i < width; i++) {
			//góra
			int [] coordinates = {i,0};
			usualFields.add(coordinates);
			
			//dó³
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
 * Metoda wyszukuje i tworzy listê s¹siadów
 * @param field Pole, którego s¹siadów nale¿y znalezæ
 * @return lista najbli¿szych s¹siadów
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
 * Dok³ada po¿ywienie w poszczególnych iteracjach symulacji. Dok³ada tak¹ iloœæ po¿ywienia by utrzymywaæ sta³¹ wartoœæ po¿ywienia na ³¹cem jednak liczba do³o¿onego po¿ywienia w danej iteracji nie mo¿e przekroczyæ zadanej wartoœci.
 */
	private void spreadNewFeed() {
		List<IField> list = getRandomFields(height*width/10);
		for(IField field : list) {
			field.putNewFeed();
		}
	}

/**
 * Wykonuje rutynowe czynoœci, które s¹ niezbêdne podczas iterowania symulacji, czyli m.in. rozk³ada nowe po¿ywienie
 */
	public void doIteration() {
		spreadNewFeed();
	}

	
/**
 * Zwraca listê losowych pól w liczbie zadanej w parametrze
 * @param numFields liczba pól do zwrócenia
 * @return List<IField> lista losowych pól
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