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
