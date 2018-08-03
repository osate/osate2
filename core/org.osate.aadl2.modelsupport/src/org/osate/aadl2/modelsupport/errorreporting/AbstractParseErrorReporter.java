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

import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.parsesupport.LocationReference;

/**
 * Base implementation that insures messages counts are updated.  Delegates
 * the actual reporting functionality to the abstract methods
 * {@link #errorImpl(String, int, String)},
 * {@link #warning(String, int, String)}, and
 * {@link #infoImpl(String, int, String)}.
 *
 * @author aarong
 */
public abstract class AbstractParseErrorReporter extends AbstractErrorReporter implements ParseErrorReporter {

	protected AbstractParseErrorReporter() {
		super();
	}

	private Resource contextResource;

	public void setContextResource(Resource res) {
		contextResource = res;
	}

	public Resource getContextResource() {
		return contextResource;
	}

	@Override
	public final void error(final LocationReference loc, final String message) {
		errorImpl(loc.getFilename(), loc.getLine(), message);
		incError();
	}

	@Override
	public final void error(final String filename, final int line, final String message) {
		errorImpl(filename, line, message);
		incError();
	}

	protected abstract void errorImpl(String filename, int line, String message);

	@Override
	public final void warning(final LocationReference loc, final String message) {
		warningImpl(loc.getFilename(), loc.getLine(), message);
		incWarning();
	}

	@Override
	public final void warning(final String filename, final int line, final String message) {
		warningImpl(filename, line, message);
		incWarning();
	}

	protected abstract void warningImpl(String filename, int line, String message);

	@Override
	public final void info(final LocationReference loc, final String message) {
		infoImpl(loc.getFilename(), loc.getLine(), message);
		incInfo();
	}

	@Override
	public final void info(final String filename, final int line, final String message) {
		infoImpl(filename, line, message);
		incInfo();
	}

	protected abstract void infoImpl(String filename, int line, String message);
}
