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
import org.osate.aadl2.Element;

/**
 * Base implementation that makes sure messages counts are updated. Also makes
 * sure that that Elements used for reporting all come from the same Resource.
 * Delegates the actual reporting functionality to the abstract methods
 * {@link #errorImpl(Element, String, String[], Object[])},
 * {@link #warningImpl(Element, String, String[], Object[])},
 * and {@link #infoImpl(Element, String, String[], Object[])}.
 *
 * @author aarong
 */
public abstract class AbstractAnalysisErrorReporter extends AbstractErrorReporter implements AnalysisErrorReporter {
	/** The EMF Resource of the object model. */
	protected final Resource resource;

	protected AbstractAnalysisErrorReporter(final Resource rsrc) {
		super();
		resource = rsrc;
	}

	private void checkResource(final Element where) {
		if (where.eResource() != resource) {
			throw new IllegalArgumentException("Object is not from the error reporter's resource");
		}
	}

	private final void checkAttributes(final String[] attrs, final Object[] values) {
		if (attrs == null) {
			throw new IllegalArgumentException("Attributes list is null");
		}
		if (values == null) {
			throw new IllegalArgumentException("Values list is null");
		}
		if (attrs.length != values.length) {
			throw new IllegalArgumentException("The lengths of the attributes and values lists are not equal");
		}
	}

	@Override
	public final void error(final Element where, final String message, final String[] attrs, final Object[] values) {
		checkResource(where);
		checkAttributes(attrs, values);
		errorImpl(where, message, attrs, values);
		incError();
	}

	/**
	 * Actual implementation of the error method.  It is guaranteed that
	 * <ul>
	 * <li><code>where</code> is from the resource of the error reporter
	 * <li><code>attrs</code> is non-<code>null</code>
	 * <li><code>values</code> is non-<code>null</code>
	 * <li>the lengths of <code>attrs</code> and <code>values</code> are equal
	 */
	protected abstract void errorImpl(Element where, String message, String[] attrs, Object[] values);

	@Override
	public final void warning(final Element where, final String message, final String[] attrs, final Object[] values) {
		checkResource(where);
		checkAttributes(attrs, values);
		warningImpl(where, message, attrs, values);
		incWarning();
	}

	/**
	 * Actual implementation of the warning method.  It is guaranteed that
	 * <ul>
	 * <li><code>where</code> is from the resource of the error reporter
	 * <li><code>attrs</code> is non-<code>null</code>
	 * <li><code>values</code> is non-<code>null</code>
	 * <li>the lengths of <code>attrs</code> and <code>values</code> are equal
	 */
	protected abstract void warningImpl(Element where, String message, String[] attrs, Object[] values);

	@Override
	public final void info(final Element where, final String message, final String[] attrs, final Object[] values) {
		checkResource(where);
		checkAttributes(attrs, values);
		infoImpl(where, message, attrs, values);
		incInfo();
	}

	/**
	 * Actual implementation of the info method.  It is guaranteed that
	 * <ul>
	 * <li><code>where</code> is from the resource of the error reporter
	 * <li><code>attrs</code> is non-<code>null</code>
	 * <li><code>values</code> is non-<code>null</code>
	 * <li>the lengths of <code>attrs</code> and <code>values</code> are equal
	 */
	protected abstract void infoImpl(Element where, String message, String[] attrs, Object[] values);
}
