/**
 * 
 */
package objectProgramming.crazyAnimals.animal;

/**
 * @author jakub
 *
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
	Species(String name){
		this.name = name;
	}
	public abstract int [] getStats();
	public abstract void clearStats();
	public String getName() {return name;}
}
