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
