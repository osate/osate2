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
package org.osate.aadl2.operations;

import java.util.Iterator;
import java.util.ListIterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Component Implementation</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#getAllSubcomponents() <em>Get All Subcomponents</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComponentImplementationOperations extends NamedElementOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentImplementationOperations() {
		super();
	}

	public static EList<Subcomponent> getAllSubcomponents(ComponentImplementation componentImplementation) {
		final EList<Classifier> ancestors = componentImplementation.getSelfPlusAllExtended();
		final BasicEList<Subcomponent> returnlist = new BasicEList<Subcomponent>();
		// Process from farthest ancestor to self
		for (ListIterator<Classifier> li = ancestors.listIterator(ancestors.size()); li.hasPrevious();) {
			final ComponentImplementation current = (ComponentImplementation) li.previous();
			final EList<Subcomponent> currentItems = current.getOwnedSubcomponents();
			if (currentItems != null) {
				for (Iterator<Subcomponent> i = currentItems.iterator(); i.hasNext();) {
					final Subcomponent fe = i.next();
					final Subcomponent rfe = fe.getRefined();
					if (rfe != null) {
						returnlist.remove(rfe);
					}
					returnlist.add(fe);
				}
			}
		}
		return returnlist;
	}

} // ComponentImplementationOperations