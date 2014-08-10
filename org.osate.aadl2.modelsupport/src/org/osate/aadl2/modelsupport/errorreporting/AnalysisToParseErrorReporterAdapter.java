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
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.Element;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.parsesupport.LocationReference;
import org.osate.internal.workspace.AadlWorkspace;
import org.osate.workspace.IAadlProject;

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
				final IResource aaxlFile = OsateResourceUtil.convertToIResource(rsrc);
				IResource aadlFile = null;
				if (aaxlFile != null) {
					final IAadlProject proj = AadlWorkspace.getAadlWorkspace().getAadlProject(aaxlFile);
					if (proj != null) {
						aadlFile = proj.getAadlFile((IFile) aaxlFile);
					}
				}

				return new AnalysisToParseErrorReporterAdapter(rsrc, perFactory.getReporterFor(aadlFile));
			}
		}
	}
}
