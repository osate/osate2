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
