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
package org.osate.aadl2.parsesupport;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AObject</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.cmu.sei.aadl.model.core.impl.AObjectImpl#getComment <em>Comment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AObjectImpl extends EObjectImpl implements AObject {

	/** hold locatipon reference for defining identifier
	 */
	protected LocationReference locationReference;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AObjectImpl() {
		super();
	}

	public final Object getAdapter(final Class adapter) {
		// defer to the platform
		return Platform.getAdapterManager().getAdapter(this, adapter);
	}

	/**
	 * Returns  the '<em><b>location reference</b></em>' attribute.
	 *
	 */
	public LocationReference getLocationReference() {
		return locationReference;
	}

	/**
	 * sets  the '<em><b>location reference</b></em>' attribute.
	 *
	 */
	public void setLocationReference(String fn, int ln) {
		if (locationReference == null) {
			locationReference = new LocationReference(fn, ln);
		} else {
			locationReference.setFilename(fn);
			locationReference.setLine(ln);
		}
	}

	/**
	 * sets  the '<em><b>location reference</b></em>' attribute.
	 *
	 */
	public void setLocationReference(LocationReference lr) {
		locationReference = lr;
	}

} // AObjectImpl
