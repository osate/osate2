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
import org.osate.aadl2.parsesupport.LocationReference;

/**
 * @author aarong
 */
public final class AnalysisToParseErrorReporterAdapter extends AbstractAnalysisErrorReporter {
	private static final LocationReference MISSING_LOCATION = new LocationReference("Missing location reference!", 0);

	/** The parse error reporter to delegate to. */
	private final ParseErrorReporter parseErrReporter;

	private AnalysisToParseErrorReporterAdapter(final Resource rsrc, final ParseErrorReporter delegate) {
		super(rsrc);
		parseErrReporter = delegate;
	}

	private LocationReference getLocationReference(final Element obj) {
		final LocationReference lr = obj.getLocationReference();
		return (lr == null) ? MISSING_LOCATION : lr;
	}

	@Override
	protected void errorImpl(Element where, String message, final String[] attrs, final Object[] values) {
		parseErrReporter.error(getLocationReference(where), message);
	}

	@Override
	protected void warningImpl(Element where, String message, final String[] attrs, final Object[] values) {
		parseErrReporter.warning(getLocationReference(where), message);
	}

	@Override
	protected void infoImpl(Element where, String message, final String[] attrs, final Object[] values) {
		parseErrReporter.info(getLocationReference(where), message);
	}

	@Override
	protected void deleteMessagesImpl() {
		parseErrReporter.deleteMessages();
	}

	/**
	 * It is required the provided {@link ParseErrorReporterFactory} be able
	 * to handle <code>null</code> IResources.  This is so that
	 * Resources associated with standard property sets may be handled.  These
	 * files do not exist in the Eclipse workspace, and thus it is impossible
	 * to get IResources for them.
	 */
	public static final class Factory implements AnalysisErrorReporterFactory {
		/** Factory for creating parse error reporter delegate objects. */
		private final ParseErrorReporterFactory perFactory;

		public Factory(final ParseErrorReporterFactory fact) {
			perFactory = fact;
		}

		@Override
		public AnalysisErrorReporter getReporterFor(final Resource rsrc) {
			if (rsrc == null) {
				throw new IllegalArgumentException(
						"Cannot create a MarkerAnalysisErrorReporter when the Resource is null");
			} else {
				return new AnalysisToParseErrorReporterAdapter(rsrc, perFactory.getReporterFor(rsrc));
			}
		}
	}
}
