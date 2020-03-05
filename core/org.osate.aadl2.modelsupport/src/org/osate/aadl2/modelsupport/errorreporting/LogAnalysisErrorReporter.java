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
