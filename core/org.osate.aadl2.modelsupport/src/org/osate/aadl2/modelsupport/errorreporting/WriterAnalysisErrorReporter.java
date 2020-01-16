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
