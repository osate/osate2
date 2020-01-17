/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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
