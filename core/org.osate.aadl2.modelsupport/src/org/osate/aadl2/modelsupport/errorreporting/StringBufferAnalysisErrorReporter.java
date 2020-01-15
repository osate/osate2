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

import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.Element;

public final class StringBufferAnalysisErrorReporter extends AbstractAnalysisErrorReporter {
	/** The system end-of-line character */
	private static final String END_OF_LINE = System.getProperty("line.separator");

	/** The string buffer is provided by the user, so that they can
	 * extract the information from it.  We assume that the buffer is
	 * locked by itself to coordinate concurrent access.
	 */
	private final StringBuffer buffer;

	private final String errorLead;
	private final String warningLead;
	private final String infoLead;

	private StringBufferAnalysisErrorReporter(final Resource rsrc, final String error, final String warning,
			final String info, final StringBuffer sb) {
		super(rsrc);
		buffer = sb;
		errorLead = error;
		warningLead = warning;
		infoLead = info;
	}

	private void outputMessage(final String lead, final String message, final String[] attrs, final Object[] values) {
		synchronized (buffer) {
			buffer.append(lead);
			buffer.append(message);
			buffer.append(END_OF_LINE);

			for (int i = 0; i < attrs.length; i++) {
				buffer.append("  ");
				buffer.append(attrs[i]);
				buffer.append(" = ");
				buffer.append(values[i].toString());
				buffer.append(END_OF_LINE);
			}
		}
	}

	@Override
	protected void errorImpl(final Element where, final String message, final String[] attrs, final Object[] values) {
		outputMessage(errorLead, message, attrs, values);
	}

	@Override
	protected void warningImpl(final Element where, final String message, final String[] attrs, final Object[] values) {
		outputMessage(warningLead, message, attrs, values);
	}

	@Override
	protected void infoImpl(final Element where, final String message, final String[] attrs, final Object[] values) {
		outputMessage(infoLead, message, attrs, values);
	}

	@Override
	protected void deleteMessagesImpl() {
		/*
		 * Do nothing. Doesn't make sense to clear the string buffer
		 * because it is shared across error reporters.
		 */
//		synchronized (buffer) {
//			buffer.setLength(0);
//		}
	}

	/**
	 * Creates analysis error reporters that all report to the same
	 * given string buffer.  Access to the string buffer is coordinated by
	 * synchronizing on the string buffer itself.  The string buffer
	 * should be locked when retreiving the string from it as well.
	 *
	 * @author aarong
	 */
	public static final class Factory implements AnalysisErrorReporterFactory {
		private final StringBuffer buffer;
		private final String errorLead;
		private final String warningLead;
		private final String infoLead;

		public Factory(final String error, final String warning, final String info, final StringBuffer buffer) {
			this.buffer = buffer;
			errorLead = error;
			warningLead = warning;
			infoLead = info;
		}

		@Override
		public AnalysisErrorReporter getReporterFor(final Resource rsrc) {
			return new StringBufferAnalysisErrorReporter(rsrc, errorLead, warningLead, infoLead, buffer);
		}
	}
}
