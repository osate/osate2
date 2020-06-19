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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Element;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.Activator;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

/**
 * An implementation of {@link edu.cmu.sei.aadl.model.pluginsupport.AnalysisErrorReporter}
 * that reports errors as markers on the aaxl object models.  Internal errors
 * are logged to the Eclipse "error" view.  The reporter is parameterized by
 * the name of the marker type to create.
 *
 * <p>A marker is created when the maximum number of messages has been exceeded
 * that indicates this fact.
 *
 * <p>
 * The class defines a nested class
 * {@link edu.cmu.sei.aadl.model.pluginsupport.MarkerAnalysisErrorReporter.Factory}
 * that implements a factory.
 *
 * @author aarong
 */
public final class MarkerAnalysisErrorReporter extends AbstractAnalysisErrorReporter {
	/** The name of the marker type to use. */
	private final String markerType;

	/** The IResource to attach the markers to. */
	private final IResource iResource;

	/**
	 * Create a new error reporter that uses the given marker types.
	 * Assumes that <code>resource</code> is not <code>null</code>.
	 */
	public MarkerAnalysisErrorReporter(final Resource rsrc, final IResource irsrc, final String mType) {
		super(rsrc);
		iResource = irsrc;
		markerType = mType;
	}

	private void createMarker(final Element where, final String message, final int severity, final String[] attrs,
			final Object[] values) {
		if (iResource.exists()) {
			try {
				IMarker marker_p = iResource.createMarker(markerType);
				marker_p.setAttribute(IMarker.SEVERITY, severity);
				marker_p.setAttribute(IMarker.MESSAGE, message);
				marker_p.setAttribute(AadlConstants.AADLURI, EcoreUtil.getURI(where).toString());

				for (int i = 0; i < attrs.length; i++) {
					marker_p.setAttribute(markerType + "." + attrs[i], values[i]);
				}
			} catch (CoreException e1) {
				Activator.logThrowable(e1);
			}
			return;
		} else {
			Activator.logErrorMessage("Couldn't find IResource.");
		}
	}

	@Override
	protected void errorImpl(final Element where, final String message, final String[] attrs, final Object[] values) {
		createMarker(where, message, IMarker.SEVERITY_ERROR, attrs, values);
	}

	@Override
	protected void warningImpl(final Element where, final String message, final String[] attrs, final Object[] values) {
		createMarker(where, message, IMarker.SEVERITY_WARNING, attrs, values);
	}

	@Override
	protected void infoImpl(final Element where, final String message, final String[] attrs, final Object[] values) {
		createMarker(where, message, IMarker.SEVERITY_INFO, attrs, values);
	}

	@Override
	protected void deleteMessagesImpl() {
		if (iResource.exists()) {
			try {
				iResource.deleteMarkers(markerType, false, IResource.DEPTH_INFINITE);
			} catch (final CoreException e1) {
				Activator.logThrowable(e1);
			}
		}
	}

	/**
	 * Factory for creating Marker error reporters.  Parameterized by the
	 * marker type to use.  Can optionally be parameterized by another
	 * {@link ParseErrorReporterFactory} that is used when it is unable to
	 * find an {@link IResource} for the given Resource.
	 *
	 * @author aarong
	 */
	public static final class Factory implements AnalysisErrorReporterFactory {
		/** The name of the marker type to use. */
		private final String markerType;

		/**
		 * Secondary factory to use in case an IResource cannot be found.
		 * Allowed to be <code>null</code>.
		 */
		private final AnalysisErrorReporterFactory secondaryFactory;

		public Factory(final String mt, final AnalysisErrorReporterFactory sndFact) {
			markerType = mt;
			secondaryFactory = sndFact;
		}

		public Factory(final String mt) {
			this(mt, null);
		}

		@Override
		public AnalysisErrorReporter getReporterFor(final Resource rsrc) {
			if (rsrc == null) {
				throw new IllegalArgumentException(
						"Cannot create a MarkerAnalysisErrorReporter when the Resource is null");
			}
			final IFile irsrc = OsateResourceUtil.toIFile(rsrc.getURI());
			if (irsrc.exists()) {
				return new MarkerAnalysisErrorReporter(rsrc, irsrc, markerType);
			} else {
				// Try the secondary factory
				if (secondaryFactory != null) {
					return secondaryFactory.getReporterFor(rsrc);
				} else {
					throw new IllegalArgumentException("Couldn't find IResource");
				}
			}
		}
	}
}
