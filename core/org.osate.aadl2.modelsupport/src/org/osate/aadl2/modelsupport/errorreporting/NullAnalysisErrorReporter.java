/* Created on Sep 14, 2005
 */
package org.osate.aadl2.modelsupport.errorreporting;

import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.Element;

public final class NullAnalysisErrorReporter extends AbstractAnalysisErrorReporter {
	public static final Factory factory = new Factory();

	private NullAnalysisErrorReporter(final Resource resource) {
		super(resource);
	}

	@Override
	protected void errorImpl(final Element where, final String message, final String[] attrs, final Object[] values) {
		// Do nothing
	}

	@Override
	protected void warningImpl(final Element where, final String message, final String[] attrs, final Object[] values) {
		// Do nothing
	}

	@Override
	protected void infoImpl(final Element where, final String message, final String[] attrs, final Object[] values) {
		// Do nothing
	}

	@Override
	protected void deleteMessagesImpl() {
		// Do nothing
	}

	private static final class Factory implements AnalysisErrorReporterFactory {
		@Override
		public AnalysisErrorReporter getReporterFor(final Resource rsrc) {
			return new NullAnalysisErrorReporter(rsrc);
		}
	}
}
