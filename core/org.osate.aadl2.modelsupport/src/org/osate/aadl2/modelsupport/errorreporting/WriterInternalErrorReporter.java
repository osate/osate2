/* Created on Sep 15, 2005
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
