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
 *
 * $Id: DefaultAnnexLibraryImpl.java,v 1.7 2008-07-31 18:24:29 lwrage Exp $
 */
package org.osate.aadl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.DefaultAnnexLibrary;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Default Annex Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.DefaultAnnexLibraryImpl#getSourceText <em>Source Text</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.DefaultAnnexLibraryImpl#getParsedAnnexLibrary <em>Parsed Annex Library</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefaultAnnexLibraryImpl extends AnnexLibraryImpl implements DefaultAnnexLibrary {
	/**
	 * The default value of the '{@link #getSourceText() <em>Source Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceText()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceText() <em>Source Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceText()
	 * @generated
	 * @ordered
	 */
	protected String sourceText = SOURCE_TEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParsedAnnexLibrary() <em>Parsed Annex Library</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParsedAnnexLibrary()
	 * @generated
	 * @ordered
	 */
	protected AnnexLibrary parsedAnnexLibrary;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefaultAnnexLibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getDefaultAnnexLibrary();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSourceText() {
		return sourceText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSourceText(String newSourceText) {
		String oldSourceText = sourceText;
		sourceText = newSourceText;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.DEFAULT_ANNEX_LIBRARY__SOURCE_TEXT,
					oldSourceText, sourceText));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnnexLibrary getParsedAnnexLibrary() {
		return parsedAnnexLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParsedAnnexLibrary(AnnexLibrary newParsedAnnexLibrary, NotificationChain msgs) {
		AnnexLibrary oldParsedAnnexLibrary = parsedAnnexLibrary;
		parsedAnnexLibrary = newParsedAnnexLibrary;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.DEFAULT_ANNEX_LIBRARY__PARSED_ANNEX_LIBRARY, oldParsedAnnexLibrary,
					newParsedAnnexLibrary);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParsedAnnexLibrary(AnnexLibrary newParsedAnnexLibrary) {
		if (newParsedAnnexLibrary != parsedAnnexLibrary) {
			NotificationChain msgs = null;
			if (parsedAnnexLibrary != null) {
				msgs = ((InternalEObject) parsedAnnexLibrary).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.DEFAULT_ANNEX_LIBRARY__PARSED_ANNEX_LIBRARY, null, msgs);
			}
			if (newParsedAnnexLibrary != null) {
				msgs = ((InternalEObject) newParsedAnnexLibrary).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.DEFAULT_ANNEX_LIBRARY__PARSED_ANNEX_LIBRARY, null, msgs);
			}
			msgs = basicSetParsedAnnexLibrary(newParsedAnnexLibrary, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.DEFAULT_ANNEX_LIBRARY__PARSED_ANNEX_LIBRARY, newParsedAnnexLibrary,
					newParsedAnnexLibrary));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnnexLibrary createParsedAnnexLibrary(EClass eClass) {
		AnnexLibrary newParsedAnnexLibrary = (AnnexLibrary) create(eClass);
		setParsedAnnexLibrary(newParsedAnnexLibrary);
		return newParsedAnnexLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnnexLibrary createParsedAnnexLibrary() {
		return createParsedAnnexLibrary(Aadl2Package.eINSTANCE.getAnnexLibrary());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.DEFAULT_ANNEX_LIBRARY__PARSED_ANNEX_LIBRARY:
			return basicSetParsedAnnexLibrary(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.DEFAULT_ANNEX_LIBRARY__SOURCE_TEXT:
			return getSourceText();
		case Aadl2Package.DEFAULT_ANNEX_LIBRARY__PARSED_ANNEX_LIBRARY:
			return getParsedAnnexLibrary();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.DEFAULT_ANNEX_LIBRARY__SOURCE_TEXT:
			setSourceText((String) newValue);
			return;
		case Aadl2Package.DEFAULT_ANNEX_LIBRARY__PARSED_ANNEX_LIBRARY:
			setParsedAnnexLibrary((AnnexLibrary) newValue);
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
		case Aadl2Package.DEFAULT_ANNEX_LIBRARY__SOURCE_TEXT:
			setSourceText(SOURCE_TEXT_EDEFAULT);
			return;
		case Aadl2Package.DEFAULT_ANNEX_LIBRARY__PARSED_ANNEX_LIBRARY:
			setParsedAnnexLibrary((AnnexLibrary) null);
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
		case Aadl2Package.DEFAULT_ANNEX_LIBRARY__SOURCE_TEXT:
			return SOURCE_TEXT_EDEFAULT == null ? sourceText != null : !SOURCE_TEXT_EDEFAULT.equals(sourceText);
		case Aadl2Package.DEFAULT_ANNEX_LIBRARY__PARSED_ANNEX_LIBRARY:
			return parsedAnnexLibrary != null;
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
		result.append(" (sourceText: ");
		result.append(sourceText);
		result.append(')');
		return result.toString();
	}

} // DefaultAnnexLibraryImpl
