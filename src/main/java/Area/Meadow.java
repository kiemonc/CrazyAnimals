package Area;

import java.util.LinkedList;

import java.util.Random;


/**
 * 
 * Klasa odpowiada za przechowywanie informacji o stanie łąki. Klasa składa się z pól składowych. Rozmieszcza wopoje oraz pożywienie podczas inicjalizacji planszy. 
 * Rozmieszcza nowe pożywienie podczas trwania symulacji.
 * Zawiera dwuwymiarową LinkedListę pól.
 * @author Mikołaj
 */
public final class Meadow implements IMeadow {
	
	private int width;
	private int height;
	private LinkedList<LinkedList<IField>> fields;
	private LinkedList<IField> fieldsWithoutFeed;
	private Random random = new Random(0);
	
/**
 * Konstruktor klasy Meadow tworzy łąke z zadanymi parametrami początkowymi
 * Generuje dwuwymiarową LinkedListę pól oraz dodaje pola do LinkedListy pól bez pożywienia
 * @param width Szerokość łąki
 * @param height Wysokość łąki
 * @param numWaterholes Ilość wodopoi
 * @param numFeeds Początkowa ilość pożywienia
 */
	public Meadow(int width, int height, int numWaterholes, int numFeeds) {
		fields = new LinkedList<LinkedList<IField>>();
		fieldsWithoutFeed = new LinkedList<IField>();
		this.width = width;
		this.height = height;
		//wiersze i kolumny są numerowane tak samo jak w macierzy
		//pole o współrzędnych (0,0) znajduje się w lewym górnym rogu.
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
 * Inicjalizuje pożywienie w liczbie zadanej w parametrze. Inicjalizacja odbywa się w sposób losowy.	
 * @param numFeeds Liczba pożywienia
 */
	private void initialFeed(int numFeeds) {
		//LinkedLista przechowuje współrzędne pól, na których nie zostało jeszcze położone pożywienie
		//int[0] - x; int[1] - y
		LinkedList<int[]> coordinates = new LinkedList<int[]>();
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
 * Metoda inicjalizuje wodopoje w takiej ilości jaka została podana w argumencie. Podmienia referencje do wodopoi w liście pól. Rozmieszcza wodopoje jedynie na brzegach planszy.
 * Podmienia pola w liście pól nie posiadających pożywienia na wygenerowane wodopoje.
 * @param numWaterholes - ilość wodopi
 */
	private void initialWaterholes(int numWaterholes) {
		//LinkedLista dwuwymiarowej tablicy licz całowitych zawierająca współrzędne pól, które nie są wodopojami 
		//int[0] - x; int[1] - y
		LinkedList<int[]> usualFields = new LinkedList<int[]>();
		
		for(int i = 0; i < width; i++) {
			//góra
			int [] coordinates = {i,0};
			usualFields.add(coordinates);
			
			//dół
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
	

	public LinkedList<IField> getNeighbours(IField field) {
		int x = field.getCoordinates()[0];
		int y = field.getCoordinates()[1];
		LinkedList<IField> neighbours = new LinkedList<IField>();
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
 * Dokłada pożywienie w poszczególnych iteracjach symulacji. Dokłada taką ilość pożywienia by utrzymywać stałą wartość pożywienia na łącem jednak liczba dołożonego pożywienia w danej iteracji nie może przekroczyć zadanej wartości.
 */
	private void spreadNewFeed() {
		LinkedList<IField> LinkedList = getRandomFields(height*width/10);
		for(IField field : LinkedList) {
			field.putNewFeed();
		}
	}


	public void doIteration() {
		spreadNewFeed();
	}

	

	public LinkedList<IField> getRandomFields(int numFields) {
		LinkedList<IField> allFields = new LinkedList<IField>();
		for(int i = 0; i < height; i++) {
			allFields.addAll(fields.get(i));
		}
		
		LinkedList<IField> randomFields = new LinkedList<IField>();
		
		for(int i = 0; i < numFields; i++) {
			if(allFields.isEmpty()) break;
			int randomIndex = random.nextInt(allFields.size());
			randomFields.add(allFields.get(randomIndex));
			allFields.remove(randomIndex);
		}
		
		return randomFields;
	}
	
	@Override
	public String toString() {
		String string = "";
		string += printLine();
		for(LinkedList<IField> row : fields) {
			string += "|";
			for(IField field : row) {
				string += field;
				string += "|";
			}
			string += "\n";
		}
		string += printLine();
		return string;
	}
	
	private String printLine() {
		String string = "";
		for(int i = 0; i < width*4+width+1; i++) {
			string += "_";
		}
		string += "\n";
		return string;
	}
	
}
