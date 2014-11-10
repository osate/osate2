/**
 * <copyright>
 * Copyright  2008 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
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
 *
 * $Id: SystemOperationModeImpl.java,v 1.7 2010-05-07 20:01:28 lwrage Exp $
 */
package org.osate.aadl2.instance.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.ocl.ecore.OCL;
import org.osate.aadl2.Mode;
import org.osate.aadl2.impl.ModeImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Operation Mode</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.SystemOperationModeImpl#getCurrentModes <em>Current Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemOperationModeImpl extends ModeImpl implements SystemOperationMode {
	/**
	 * The cached value of the '{@link #getCurrentModes() <em>Current Mode</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentModes()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeInstance> currentModes;

	private Boolean isInitial = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemOperationModeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.SYSTEM_OPERATION_MODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ModeInstance> getCurrentModes() {
		if (currentModes == null) {
			currentModes = new EObjectResolvingEList<ModeInstance>(ModeInstance.class, this,
					InstancePackage.SYSTEM_OPERATION_MODE__CURRENT_MODE);
		}
		return currentModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case InstancePackage.SYSTEM_OPERATION_MODE__CURRENT_MODE:
			return getCurrentModes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case InstancePackage.SYSTEM_OPERATION_MODE__CURRENT_MODE:
			getCurrentModes().clear();
			getCurrentModes().addAll((Collection<? extends ModeInstance>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case InstancePackage.SYSTEM_OPERATION_MODE__CURRENT_MODE:
			getCurrentModes().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case InstancePackage.SYSTEM_OPERATION_MODE__CURRENT_MODE:
			return currentModes != null && !currentModes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final OCL EOCL_ENV = OCL.newInstance();

	/**
	 * returns initial mode as true if it is a SOM without modes ("no Modes" aka NORMAL_SOM_NME)
	 * or if all of the modes are initial mode
	 */
	@Override
	public final boolean isInitial() {
		if (isInitial == null) {
			Boolean value = Boolean.TRUE;
			final Iterator<ModeInstance> i = getCurrentModes().iterator();
			// Is the list empty?
			if (!i.hasNext()) {
				// The SOM has no modes. Check to make sure, it is the only SOM, i.e., "No Modes". Otherwise it is not initial
				if (((SystemInstance) eContainer()).getSystemOperationModes().size() != 1) {
					value = Boolean.FALSE;
				}
			} else {
				while (i.hasNext()) {
					final ModeInstance mi = i.next();
					final Mode m = mi.getMode();
					if (!m.isInitial()) {
						value = Boolean.FALSE;
						break;
					}
				}
			}
			isInitial = value;
		}
		return isInitial.booleanValue();
	}

	@Override
	public boolean isDerived() {
		return false;
	}

	@Override
	public String toString() {
		/*
		 * Don't return a string with spaces in it becase this is used to
		 * create a name for the object, and we cannot have spaces in our
		 * name, or else it messes up the XML/XMI processing.
		 */
		final StringBuffer name = new StringBuffer();
		EList ml = getCurrentModes();
		for (Iterator it = ml.iterator(); it.hasNext();) {
			final ModeInstance mi = (ModeInstance) it.next();
			final ComponentInstance ci = (ComponentInstance) mi.eContainer();
			name.append(ci.getComponentInstancePath());
			if (name.length() > 0) {
				name.append(".");
			}
			name.append(mi.getName());
			if (it.hasNext()) {
				name.append(" # ");
			}
		}
		return name.toString();
	}

} // SystemOperationModeImpl
