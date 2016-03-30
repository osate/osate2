package org.osate.analysis.scheduling;

/** to test the file input stream read to float, integet (the primitive type)
 *
 *  created by Jun Li, May 13, 1999.
 */
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestDataInputStream {

	public static void main(String[] args) {
		FileInputStream inStream = null;
		try {
			inStream = new java.io.FileInputStream(args[0]);
		} catch (FileNotFoundException exc) {
			System.out.println("no file found!");
		}

		int number = 0;
		try {
			number = inStream.available();
		} catch (IOException ioExc) {
		}

		byte[] buf = new byte[number];
		try {
			inStream.read(buf);
		} catch (IOException ioExc) {
		}

		ByteArrayInputStream ba = new ByteArrayInputStream(buf);

		int counter = 0;
		int period = 0;
		int deadline = 0;
		int executionTime = 0;
		int phaseOffset = 0;
		int priority = 0;
		int ARCID = 0;
		DataInputStream dataIn = new DataInputStream(ba);

		for (;;) {
			try {
				period = dataIn.readShort();
				deadline = dataIn.readInt();
				executionTime = dataIn.readInt();
				phaseOffset = dataIn.readInt();
				priority = dataIn.readInt();
				ARCID = dataIn.readInt();
			} catch (EOFException efExc) {
				System.out.println(period + "\t" + deadline + "\t" + executionTime + "\t" + phaseOffset + "\t"
						+ priority + "\t" + ARCID);
				continue;
			} catch (IOException ioExc) {
				System.out.println("the end of the file.");
				break;
			}
		}

	}
}
