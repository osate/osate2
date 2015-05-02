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
 *
 * $Id: MetaclassReferenceImpl.java,v 1.6 2009-06-03 17:46:26 lwrage Exp $
 */
package org.osate.aadl2.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.MetaclassReference;
import org.osate.aadl2.parsesupport.ParseUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metaclass Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.MetaclassReferenceImpl#getAnnexName <em>Annex Name</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.MetaclassReferenceImpl#getMetaclassNames <em>Metaclass Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetaclassReferenceImpl extends PropertyOwnerImpl implements MetaclassReference {
	/**
	 * The default value of the '{@link #getAnnexName() <em>Annex Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnexName()
	 * @generated
	 * @ordered
	 */
	protected static final String ANNEX_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAnnexName() <em>Annex Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnexName()
	 * @generated
	 * @ordered
	 */
	protected String annexName = ANNEX_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMetaclassNames() <em>Metaclass Name</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaclassNames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> metaclassNames;

	protected boolean resolved = false;
	protected EClass metaclass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetaclassReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getMetaclassReference();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAnnexName() {
		return annexName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAnnexName(String newAnnexName) {
		String oldAnnexName = annexName;
		annexName = newAnnexName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.METACLASS_REFERENCE__ANNEX_NAME,
					oldAnnexName, annexName));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getMetaclassNames() {
		if (metaclassNames == null) {
			metaclassNames = new EDataTypeEList<String>(String.class, this,
					Aadl2Package.METACLASS_REFERENCE__METACLASS_NAME);
		}
		return metaclassNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.METACLASS_REFERENCE__ANNEX_NAME:
			return getAnnexName();
		case Aadl2Package.METACLASS_REFERENCE__METACLASS_NAME:
			return getMetaclassNames();
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
		case Aadl2Package.METACLASS_REFERENCE__ANNEX_NAME:
			setAnnexName((String) newValue);
			return;
		case Aadl2Package.METACLASS_REFERENCE__METACLASS_NAME:
			getMetaclassNames().clear();
			getMetaclassNames().addAll((Collection<? extends String>) newValue);
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
		case Aadl2Package.METACLASS_REFERENCE__ANNEX_NAME:
			setAnnexName(ANNEX_NAME_EDEFAULT);
			return;
		case Aadl2Package.METACLASS_REFERENCE__METACLASS_NAME:
			getMetaclassNames().clear();
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
		case Aadl2Package.METACLASS_REFERENCE__ANNEX_NAME:
			return ANNEX_NAME_EDEFAULT == null ? annexName != null : !ANNEX_NAME_EDEFAULT.equals(annexName);
		case Aadl2Package.METACLASS_REFERENCE__METACLASS_NAME:
			return metaclassNames != null && !metaclassNames.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (annexName: ");
		result.append(annexName);
		result.append(", metaclassName: ");
		result.append(metaclassNames);
		result.append(')');
		return result.toString();
	}

	protected String errorMessage = null;

	protected void resolveMetaclass() {

		if (resolved) {
			return;
		}

		StringBuilder metaclassName = new StringBuilder();

		for (Iterator<String> iter = getMetaclassNames().iterator(); iter.hasNext();) {
			StringBuilder namePart = new StringBuilder(iter.next().toLowerCase());

			namePart.setCharAt(0, Character.toUpperCase(namePart.charAt(0)));
			metaclassName.append(namePart);
		}
		resolved = true;

		if (metaclassName.toString().equalsIgnoreCase("all")) {
			metaclass = Aadl2Package.eINSTANCE.getNamedElement();
		} else if (metaclassName.toString().equalsIgnoreCase("package")) {
			metaclass = Aadl2Package.eINSTANCE.getAadlPackage();
		} else {
			EPackage pack = Aadl2Package.eINSTANCE;

			if (getAnnexName() != null) {
				pack = getAnnexEPackage(getAnnexName());
			}

			EClassifier searchResult = getEClassifier(pack, metaclassName.toString());
			if (searchResult instanceof EClass) {
				EClass searchResultAsEClass = (EClass) searchResult;

				if (Aadl2Package.eINSTANCE.getNamedElement().isSuperTypeOf(searchResultAsEClass)) {
					metaclass = searchResultAsEClass;
				} else {
					errorMessage = "' is not a named element";
				}
			} else {
				errorMessage = "' does not exist in " + (getAnnexName() == null ? "AADL2" : getAnnexName());
			}

			if (errorMessage != null) {
				StringBuilder errorMessageBuilder = new StringBuilder("Metaclass '");
				for (Iterator<String> iter = getMetaclassNames().iterator(); iter.hasNext();) {
					errorMessageBuilder.append(iter.next());
					if (iter.hasNext()) {
						errorMessageBuilder.append(' ');
					}
				}
				errorMessageBuilder.append(errorMessage);
				errorMessage = errorMessageBuilder.toString();
			}
		}
	}

	@Override
	public EClass getMetaclass() {
		resolveMetaclass();
		return metaclass;
	}

	@Override
	public String getErrorMessage() {
		resolveMetaclass();
		return errorMessage;
	}

	public EClassifier getEClassifier(EPackage pack, String name) {
		for (EClassifier eClassifier : pack.getEClassifiers()) {
			if (eClassifier.getName().equalsIgnoreCase(name)) {
				return eClassifier;
			}
		}
		return null;
	}

	public EPackage getAnnexEPackage(String annexname) {

		String NSURI = ParseUtil.getAnnexNS(annexname);
		if (NSURI != null) {
			EPackage pack = EPackage.Registry.INSTANCE.getEPackage(NSURI);
			return pack;
		}

		return Aadl2Package.eINSTANCE;
	}

} // MetaclassReferenceImpl
