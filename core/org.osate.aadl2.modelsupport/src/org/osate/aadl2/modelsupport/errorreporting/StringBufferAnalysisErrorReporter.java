/* Created on Mar 21, 2006
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
