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
package org.osate.aadl2.impl;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceFactory;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.properties.EvaluatedProperty;
import org.osate.aadl2.properties.EvaluationContext;
import org.osate.aadl2.properties.InvalidModelException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ReferenceValueImpl extends ContainedNamedElementImpl implements ReferenceValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getReferenceValue();
	}

	public PropertyExpression instantiate(InstanceObject root) throws InvalidModelException {
		List<InstanceObject> iol = root.findInstanceObjects(getContainmentPathElements());
		if (iol.size() == 0) {
			// reference to a non-instantiated element, e.g., subprogram or call sequence
			return null;
		} else if (iol.size() > 1) {
			throw new InvalidModelException(this, "Reference refers to more than one instance object");
		} else {
			final InstanceObject io = iol.get(0);
			final InstanceReferenceValue irv = InstanceFactory.eINSTANCE.createInstanceReferenceValue();
			irv.setReferencedInstanceObject(io);
			return irv;
		}
	}

	public PropertyExpression instantiate(FeatureInstance root) throws InvalidModelException {
		final List<InstanceObject> iol = root.findInstanceObjects(getContainmentPathElements());
		if (iol.size() == 0) {
			throw new InvalidModelException(this, "Reference does not refer to a nested feature");
		} else if (iol.size() > 1) {
			throw new InvalidModelException(this, "Reference refers to more than one feature");
		} else {
			final InstanceObject io = iol.get(0);
			final InstanceReferenceValue irv = InstanceFactory.eINSTANCE.createInstanceReferenceValue();
			irv.setReferencedInstanceObject(io);
			return irv;
		}
	}

	// TODO: LW features can have reference properties too
	public EvaluatedProperty evaluate(EvaluationContext ctx, int depth) {
		return new EvaluatedProperty(EcoreUtil.copy(this));
	}

	public boolean sameAs(PropertyExpression other) {
		// TODO: implement comparison of reference values
		return false;
	}

} // ReferenceValueImpl
