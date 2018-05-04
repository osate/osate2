/**
 * <copyright>
 * Copyright  2005 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.aadl2.modelsupport.errorreporting;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.eclipse.core.resources.IResource;

/**
 * An implementation of
 * {@link edu.cmu.sei.aadl.model.pluginsupport.ParseErrorReporter} that outputs
 * the messages to a Java {@link java.io.Writer}. Includes a
 * {@link #SYSTEM_OUT_FACTORY prototype reference to a factory that creates
 * reporters that print to the system out}.
 *
 * <p>
 * The class defines a nested class
 * {@link edu.cmu.sei.aadl.model.pluginsupport.WriterParseErrorReporter.Factory}
 * that implements a factory.
 *
 * @author aarong
 */
public final class WriterParseErrorReporter extends AbstractParseErrorReporter {
	/**
	 * Singleton reference to an error reporter that sends the messages to
	 * {@link System#out}.
	 */
	public static final WriterParseErrorReporter SYSTEM_OUT = new WriterParseErrorReporter(
			new OutputStreamWriter(System.out));

	/**
	 * Singleton reference to an error reporter that sends the messages to
	 * {@link System#err}.
	 */
	public static final WriterParseErrorReporter SYSTEM_ERR = new WriterParseErrorReporter(
			new OutputStreamWriter(System.err));

	/**
	 * Singleton reference to an factory that creates reporters that send the
	 * messages to {@link System#out}.
	 */
	public static final Factory SYSTEM_OUT_FACTORY = new Factory(new OutputStreamWriter(System.out));

	/** The system end-of-line character */
	private final String END_OF_LINE = System.getProperty("line.separator");

	/** The writer. */
	private final Writer writer;

	/**
	 * Create a new error reporter that writes the error messages to the given
	 * {@link Writer} object. The caller is responsible for providing any
	 * buffering, i.e., the writer will be used as provided and is not further
	 * wrapped.
	 *
	 * @param writer
	 *            The writer to use.
	 * @exception IllegalArgumentException
	 *                Thrown if <code>writer</code> is <code>null</code>.
	 */
	public WriterParseErrorReporter(final Writer writer) {
		super();
		if (writer == null) {
			throw new IllegalArgumentException("The provided writer is null.");
		}
		this.writer = writer;
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
	protected void errorImpl(final String filename, final int line, final String message) {
		writeMessage("Error parsing " + filename + " at line " + line + ": " + message);
	}

	@Override
	protected void warningImpl(final String filename, final int line, final String message) {
		writeMessage("Warning checking " + filename + " at line " + line + ": " + message);
	}

	@Override
	protected void infoImpl(final String filename, final int line, final String message) {
		writeMessage(filename + " at line " + line + ": " + message);
	}

	@Override
	protected void deleteMessagesImpl() {
		// Nothing to do because we cannot undo writing
	}

	public static final class Factory implements ParseErrorReporterFactory {
		final WriterParseErrorReporter reporter;

		public Factory(final Writer writer) {
			reporter = new WriterParseErrorReporter(writer);
		}

		/**
		 * The given AADL IResource is allowed to be <code>null</code>.
		 */
		@Override
		public ParseErrorReporter getReporterFor(final IResource aadlRsrc) {
			return reporter;
		}
	}
}
