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

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Element;

/**
 * An implementation of
 * {@link edu.cmu.sei.aadl.model.pluginsupport.AnalysisErrorReporter} that outputs
 * the messages to a Java {@link java.io.Writer}. Includes a
 * {@link #SYSTEM_OUT_FACTORY prototype reference to a factory that creates
 * reporters that print to the system out}.
 *
 * <p>
 * The class defines a nested class
 * {@link edu.cmu.sei.aadl.model.pluginsupport.WriterAnalysisErrorReporter.Factory}
 * that implements a factory.
 *
 * @author aarong
 */
public final class WriterAnalysisErrorReporter extends AbstractAnalysisErrorReporter {
	/**
	 * Singleton reference to a factory that creates reporters that send the
	 * messages to {@link System#out}.
	 */
	public static final Factory SYSTEM_OUT_FACTORY = new Factory(new OutputStreamWriter(System.out));

	/**
	 * Singleton reference to a factory that creates reporters that send the
	 * messages to {@link System#err}.
	 */
	public static final Factory SYSTEM_ERR_FACTORY = new Factory(new OutputStreamWriter(System.err));

	/** The system end-of-line character */
	private static final String END_OF_LINE = System.getProperty("line.separator");

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
	public WriterAnalysisErrorReporter(final Resource rsrc, final Writer writer) {
		super(rsrc);
		if (writer == null) {
			throw new IllegalArgumentException("The provided writer is null.");
		}
		this.writer = writer;
	}

	private void writeMessage(final Element where, final String type, final String message, final String[] attrs,
			final Object[] values) {
		try {
			final String loc = EcoreUtil.getURI(where).toString();
			writer.write(type);
			writer.write(": ");
			writer.write(message);
			writer.write(" at ");
			writer.write(loc);
			writer.write(END_OF_LINE);
			writer.flush();

			for (int i = 0; i < attrs.length; i++) {
				writer.write("  ");
				writer.write(attrs[i]);
				writer.write(" = ");
				writer.write(values[i].toString());
				writer.write(END_OF_LINE);
				writer.flush();
			}
		} catch (final IOException e) {
			throw new RuntimeException("Problem using writer", e);
		}
	}

	@Override
	protected void errorImpl(final Element where, final String message, final String[] attrs, final Object[] values) {
		writeMessage(where, "ERROR", message, attrs, values);
	}

	@Override
	protected void warningImpl(final Element where, final String message, final String[] attrs, final Object[] values) {
		writeMessage(where, "WARNING", message, attrs, values);
	}

	@Override
	protected void infoImpl(final Element where, final String message, final String[] attrs, final Object[] values) {
		writeMessage(where, "INFO", message, attrs, values);
	}

	@Override
	protected void deleteMessagesImpl() {
		// Nothing to do because we cannot undo writing
	}

	public static final class Factory implements AnalysisErrorReporterFactory {
		final Writer writer;

		public Factory(final Writer writer) {
			this.writer = writer;
		}

		/**
		 * The given AADL IResource is allowed to be <code>null</code>.
		 */
		@Override
		public AnalysisErrorReporter getReporterFor(final Resource rsrc) {
			return new WriterAnalysisErrorReporter(rsrc, writer);
		}
	}
}
