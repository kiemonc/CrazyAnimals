package Area;

import java.util.List;
public interface IMeadow {
	
	public List<IField> getNeighbours(IField field);
	public List<IField> getRandomFields(int numFields);
	public void doIteration();
}
