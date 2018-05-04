package EAnalysis.BinPacking;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Channel {
	public JTextArea display;

	public JScrollPane spane;

	public String description;

	public int lineNumber = 0;

	public Channel(String d) {
		display = new JTextArea();
		spane = new JScrollPane(display);
		spane.setPreferredSize(new Dimension(700, 500));
		description = d;
	}
}