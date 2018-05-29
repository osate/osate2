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

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.osgi.framework.Bundle;

/**
 * An implementation of
 * {@link edu.cmu.sei.aadl.model.pluginsupport.ParseErrorReporter} that reports
 * errors to the Eclipse "error" log.
 *
 * <p>
 * The class defines a nested class {@link LogParseErrorReporter.Factory}
 * that implements a factory.
 *
 * @author aarong
 */
public final class LogParseErrorReporter extends AbstractParseErrorReporter {
	private final Bundle bundle;
	private final ILog log;

	public LogParseErrorReporter(final Bundle bundle) {
		super();
		this.bundle = bundle;
		log = Platform.getLog(bundle);
	}

	private void logMessage(final String filename, final int line, final int type, final String message) {
		final String fullMessage = message + " (" + filename + ":" + line + ")";
		final IStatus status = new Status(type, bundle.getSymbolicName(), IStatus.OK, fullMessage, null);
		log.log(status);
	}

	@Override
	protected void errorImpl(final String filename, final int line, final String message) {
		logMessage(filename, line, IStatus.ERROR, message);
	}

	@Override
	protected void warningImpl(final String filename, final int line, final String message) {
		logMessage(filename, line, IStatus.WARNING, message);
	}

	@Override
	protected void infoImpl(final String filename, final int line, final String message) {
		logMessage(filename, line, IStatus.INFO, message);
	}

	@Override
	protected void deleteMessagesImpl() {
		// Nothing to do because we don't do anything with messages
	}

	public static final class Factory implements ParseErrorReporterFactory {
		private final LogParseErrorReporter reporterPrototype;

		public Factory(final Bundle bundle) {
			reporterPrototype = new LogParseErrorReporter(bundle);
		}

		/**
		 * The given AADL Resource is allowed to be <code>null</code>.
		 */
		@Override
		public ParseErrorReporter getReporterFor(final Resource aadlRsrc) {
			return reporterPrototype;
		}
	}

//
//	/**
//	 * TODO compatibility for Topcased 0.7: it uses the 01162006 interface
//	 */
//	public static ParseErrorReporterFactory factory = new Factory(null);
}
