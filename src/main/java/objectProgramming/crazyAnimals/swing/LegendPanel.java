/**
 * 
 */
package objectProgramming.crazyAnimals.swing;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author jakub
 *
 */
@SuppressWarnings("serial")
public class LegendPanel extends JPanel {
	
	private String [] names = {"Cat", "Cow", "Mouse", "Sheep", "Wolf", "Grass", "Cheese", "Meadow", "Waterhole"};
	private Color [] colors = {Color.black, Color.magenta, Color.gray, Color.white, Color.orange, Color.pink, Color.yellow, Color.green, Color.cyan};
	private JPanel buttonAndName;
	
	public LegendPanel() {
		for(int i = 0; i < 9; i++) {
			JButton tmp = new JButton("");
			buttonAndName = new JPanel();
			tmp.setBackground(colors[i]);
			buttonAndName.add(tmp);
			buttonAndName.add(new JLabel(" - " + names[i] + " "));
			add(buttonAndName);
		}
	}
}
