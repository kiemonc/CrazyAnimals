/**
 * 
 */
package objectProgramming.crazyAnimals.animal;

/**
 * Typ wyliczeniowy umożliwia pobranie nazwy gatunku zwierzęcia oraz wykonanie metod pobrania i wyczyszczenia statystyk dla każdego z nich
 * @author jakub
 */
public enum Species {
	CAT("Cats"){
		@Override
		public int [] getStats() {
			return Cat.stats.getStats();
		}

		@Override
		public void clearStats() {
			Cat.stats.clearStats();
		}
	},	
	COW("Cows") {
		@Override
		public int[] getStats() {
			return Cow.stats.getStats();
		}

		@Override
		public void clearStats() {
			Cow.stats.clearStats();
		}
	},
	MOUSE("Mice"){
		@Override
		public int[] getStats() {
			return Mouse.stats.getStats();
		}

		@Override
		public void clearStats() {
			Mouse.stats.clearStats();
		}
	},
	SHEEP("Sheeps"){
		@Override
		public int[] getStats() {
			return Sheep.stats.getStats();
		}

		@Override
		public void clearStats() {
			Sheep.stats.clearStats();
		}
	},
	WOLF("Wolves"){
		@Override
		public int[] getStats() {
			return Wolf.stats.getStats();
		}

		@Override
		public void clearStats() {
			Wolf.stats.clearStats();
		}
	};
	String name;
	/**
	 * Konstruktor pozwala zainicjalizować nazwę gatunku
	 * @param name nazwa gatunku
	 */
	Species(String name){
		this.name = name;
	}
	/**
	 * Pozwala pobrać statystyki dla danego gatunku
	 * @return dwuwymiarowa tablica zawierająca statystyki
	 */
	public abstract int [] getStats();
	/**
	 * Wywołuje metodę clearStats() na klasie gatunku
	 */
	public abstract void clearStats();
	/**
	 * Pozwala pobrać nazwę gatunku
	 * @return nazwa gatunku
	 */
	public String getName() {return name;}
}
