package Area;

import java.util.List;
public interface IMeadow {
	
	public List<IField> getNeighbours(IField field);
	public void doIteration();
}
