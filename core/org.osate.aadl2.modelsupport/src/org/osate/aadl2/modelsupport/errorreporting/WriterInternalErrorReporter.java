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
package org.osate.aadl2.modelsupport.errorreporting;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * An internal error reporter to sends internal error messages to the given
 * Writer. Includes a {@link #SYSTEM_OUT prototype reference} to an instance
 * that sends the errors to {@link System#out}.
 *
 * @author aarong
 */
public final class WriterInternalErrorReporter extends AbstractInternalErrorReporter {
	/** The system end-of-line character */
	private static final String END_OF_LINE = System.getProperty("line.separator");

	/** Prototype reference that writes to the standard out. */
	public static final WriterInternalErrorReporter SYSTEM_OUT = new WriterInternalErrorReporter(
			new OutputStreamWriter(System.out));

	/** Prototype reference that writes to the standard err. */
	public static final WriterInternalErrorReporter SYSTEM_ERR = new WriterInternalErrorReporter(
			new OutputStreamWriter(System.err));

	/** The writer to use. */
	private final Writer writer;

	public WriterInternalErrorReporter(final Writer w) {
		writer = w;
	}

	private void writeMessage(final String message) {
		try {
			writer.write(message);
			writer.write(END_OF_LINE);
			writer.flush();
		} catch (final IOException e) {
			throw new RuntimeException("Problem using writer", e);
		}
	}

	@Override
	public void internalErrorImpl(final String message) {
		writeMessage("** INTERNAL ERROR: " + message);
	}

	@Override
	public void internalErrorImpl(final Exception e) {
		writeMessage("** INTERNAL ERROR: Exception \"" + e.getMessage() + "\"");
	}
}
