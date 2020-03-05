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
