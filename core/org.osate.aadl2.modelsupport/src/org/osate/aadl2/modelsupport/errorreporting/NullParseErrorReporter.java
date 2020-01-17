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

/**
 * An implementation of
 * {@link edu.cmu.sei.aadl.model.pluginsupport.ParseErrorReporter} that silently
 * discards all reported errors.
 *
 * <p>
 * Contains singleton references to {@link #prototype a canonical null reporter}
 * and to {@link #factory a factory object}.
 *
 * @author aarong
 */
public final class NullParseErrorReporter extends AbstractParseErrorReporter {
	/**
	 * Singleton reference to the unique instance.
	 */
	public static final NullParseErrorReporter prototype = new NullParseErrorReporter();

	/**
	 * Singleton reference to the factory.
	 */
	public static final Factory factory = new Factory();

	/**
	 * Private constructor to enforce singleton pattern.  Use the
	 * {@link #prototype singleton reference} instead.
	 */
	private NullParseErrorReporter() {
		super();
	}

	@Override
	protected void errorImpl(final String filename, final int line, final String message) {
		// do nothing
	}

	@Override
	protected void warningImpl(final String filename, final int line, final String message) {
		// do nothing
	}

	@Override
	protected void infoImpl(final String filename, final int line, final String message) {
		// do nothing
	}

	@Override
	protected void deleteMessagesImpl() {
		// Nothing to do because we don't do anything with messages
	}

	private static final class Factory implements ParseErrorReporterFactory {
		public Factory() {
			// do nothing;
		}

		/**
		 * The given AADL IResource is allowed to be <code>null</code>.
		 */
		@Override
		public ParseErrorReporter getReporterFor(final Resource aadlRsrc) {
			return NullParseErrorReporter.prototype;
		}
	}
}
