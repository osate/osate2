/* Created on Sep 14, 2005
 */
package org.osate.aadl2.modelsupport.errorreporting;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Element;
import org.osgi.framework.Bundle;

/**
 * An analysis error reporter to sends error messages to the Eclipse "Error"
 * view/log.
 *
 * <p>
 * The class defines a nested class {@link LogAnalysisErrorReporter.Factory}
 * that implements a factory.
 *
 * @author aarong
 */
public final class LogAnalysisErrorReporter extends AbstractAnalysisErrorReporter {
	private final Bundle bundle;
	private final ILog log;

	/**
	 * Private constructor to enforce singleton pattern.  Use the
	 * {@link #prototype singleton reference} instead.
	 */
	private LogAnalysisErrorReporter(final Bundle bundle, final Resource resource) {
		super(resource);
		this.bundle = bundle;
		log = Platform.getLog(bundle);
	}

	private void logMessage(final Element where, final int type, final String message) {
		final String loc = EcoreUtil.getURI(where).toString();
		final String fullMessage = message + " (" + loc + ")";
		final IStatus status = new Status(type, bundle.getSymbolicName(), IStatus.OK, fullMessage, null);
		log.log(status);
	}

	@Override
	protected void errorImpl(final Element where, final String message, final String[] attrs, final Object[] values) {
		logMessage(where, IStatus.ERROR, message);
	}

	@Override
	protected void warningImpl(final Element where, final String message, final String[] attrs, final Object[] values) {
		logMessage(where, IStatus.WARNING, message);
	}

	@Override
	protected void infoImpl(final Element where, final String message, final String[] attrs, final Object[] values) {
		logMessage(where, IStatus.INFO, message);
	}

	@Override
	protected void deleteMessagesImpl() {
		// Do nothing
	}

	public static final class Factory implements AnalysisErrorReporterFactory {
		private final Bundle bundle;

		public Factory(final Bundle b) {
			bundle = b;
		}

		@Override
		public AnalysisErrorReporter getReporterFor(final Resource rsrc) {
			return new LogAnalysisErrorReporter(bundle, rsrc);
		}
	}
//
//	/**
//	 * TODO compatibility for Topcased 0.7: it uses the 01162006 interface
//	 */
//	public static AnalysisErrorReporterFactory factory = new Factory(null);

}
