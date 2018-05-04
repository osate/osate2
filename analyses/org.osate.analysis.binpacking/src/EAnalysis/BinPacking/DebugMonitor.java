package EAnalysis.BinPacking;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class DebugMonitor {
	public static Channel[] channels;

	public static Channel mergedChannel;

	public static int mergedLineNumber = 0;

	static JTabbedPane tabPane = new JTabbedPane();

	public static Vector channelsList = new Vector();

	static {
		mergedChannel = createChannel("All");
	}

	public static void print(Channel n, String s) {
		n.display.append("[" + Integer.toString(mergedLineNumber) + "]" + Integer.toString(n.lineNumber++) + ":" + s);
		mergedChannel.display.append("[" + Integer.toString(mergedLineNumber++) + "]" + s);
	}

	public static void println(Channel n, String s) {
		print(n, s + "\n");
	}

	public static Channel createChannel(String description) {
		Channel n = new Channel(description);
		channelsList.add(n);
		tabPane.addTab(description, n.spane);
		return n;
	}

	public static void show() {
		JOptionPane.showMessageDialog(null, tabPane, "DebugMonitor", JOptionPane.PLAIN_MESSAGE);
	}
}