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
import org.osate.aadl2.modelsupport.Activator;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

/**
 * An implementation of
 * {@link edu.cmu.sei.aadl.model.pluginsupport.ParseErrorReporter} that reports
 * errors as markers on the aadl text files. The marker type is specified via a
 * string identifier when the error reporter is created.
 * <p>
 * The class defines a nested class
 * {@link edu.cmu.sei.aadl.model.pluginsupport.MarkerParseErrorReporter.Factory}
 * that implements a factory.
 *
 * @author aarong
 */
public final class MarkerParseErrorReporter extends AbstractParseErrorReporter {
	/** The name of the marker type used for error markers. */
	private final String markerType;

	/** The resource to attach the markers to. */
	private final IResource resource;

	/**
	 * Create a new error reporter that uses the given marker types.
	 * Assumes that <code>rsrc</code> is not <code>null</code>.
	 */
	public MarkerParseErrorReporter(final IResource rsrc, final String mt) {
		super();
		resource = rsrc;
		markerType = mt;
	}

	private void createMarker(final String markerType, final String filename, final int line, final String message,
			final int severity) {
		if (resource.exists()) {
			try {
				final IMarker marker_p = resource.createMarker(markerType);
				marker_p.setAttribute(IMarker.SEVERITY, severity);
				marker_p.setAttribute(IMarker.LINE_NUMBER, line);
				marker_p.setAttribute(IMarker.MESSAGE, message);
			} catch (CoreException e1) {
				Activator.logThrowable(e1);
			}
		} else {
			Activator.logErrorMessage("Couldn't find IResource for " + filename);
		}
	}

	@Override
	protected void errorImpl(final String filename, final int line, final String message) {
		createMarker(markerType, filename, line, message, IMarker.SEVERITY_ERROR);

	}

	@Override
	protected void warningImpl(final String filename, final int line, final String message) {
		createMarker(markerType, filename, line, message, IMarker.SEVERITY_WARNING);
	}

	@Override
	protected void infoImpl(final String filename, final int line, final String message) {
		createMarker(markerType, filename, line, message, IMarker.SEVERITY_INFO);
	}

	@Override
	protected void deleteMessagesImpl() {
		if (resource.exists()) {
			try {
				resource.deleteMarkers(markerType, false, IResource.DEPTH_INFINITE);
			} catch (final CoreException e1) {
				Activator.logThrowable(e1);
			}
		}
	}

	/**
	 * Factory for creating Marker error reporters.  Parameterized by the
	 * marker type to use.  Is also parameterized by another
	 * {@link ParseErrorReporterFactory} that is used when the given
	 * {@link IResource} is <code>null</code>; this happens,
	 * for example, when dealing with the standard AADL property sets, which
	 * currently do not exist inside the workspace and thus cannot be mapped
	 * to an IFile.
	 *
	 * <p>The secondary factory must be non-<code>null</code> and must be
	 * capable of handling <code>null</code> IResources.
	 *
	 * @author aarong
	 */
	public static final class Factory implements ParseErrorReporterFactory {
		/** The name of the marker type to use. */
		private final String markerType;

		/**
		 * Secondary factory to use in case an IResource cannot be found.
		 * Allowed to be <code>null</code>.
		 */
		private final ParseErrorReporterFactory secondaryFactory;

		public Factory(final String mt, final ParseErrorReporterFactory sndFact) {
			if (sndFact == null) {
				throw new IllegalArgumentException("The secondary factory must not be null");
			}
			markerType = mt;
			secondaryFactory = sndFact;
		}

		@Override
		public ParseErrorReporter getReporterFor(final Resource resource) {
			IFile aadlRsrc = OsateResourceUtil.toIFile(resource.getURI());
			if (aadlRsrc.exists()) {
				return new MarkerParseErrorReporter(aadlRsrc, markerType);
			} else {
				// Try the secondary factory
				return secondaryFactory.getReporterFor(null);
			}
		}
	}
}
