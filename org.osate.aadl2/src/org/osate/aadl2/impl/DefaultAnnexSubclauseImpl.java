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
 * $Id: DefaultAnnexSubclauseImpl.java,v 1.7 2008-07-31 18:24:29 lwrage Exp $
 */
package org.osate.aadl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.DefaultAnnexSubclause;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Default Annex Subclause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.DefaultAnnexSubclauseImpl#getSourceText <em>Source Text</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.DefaultAnnexSubclauseImpl#getParsedAnnexSubclause <em>Parsed Annex Subclause</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefaultAnnexSubclauseImpl extends AnnexSubclauseImpl implements DefaultAnnexSubclause {
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
	 * The cached value of the '{@link #getParsedAnnexSubclause() <em>Parsed Annex Subclause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParsedAnnexSubclause()
	 * @generated
	 * @ordered
	 */
	protected AnnexSubclause parsedAnnexSubclause;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefaultAnnexSubclauseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getDefaultAnnexSubclause();
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
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__SOURCE_TEXT,
					oldSourceText, sourceText));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnnexSubclause getParsedAnnexSubclause() {
		return parsedAnnexSubclause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParsedAnnexSubclause(AnnexSubclause newParsedAnnexSubclause, NotificationChain msgs) {
		AnnexSubclause oldParsedAnnexSubclause = parsedAnnexSubclause;
		parsedAnnexSubclause = newParsedAnnexSubclause;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__PARSED_ANNEX_SUBCLAUSE, oldParsedAnnexSubclause,
					newParsedAnnexSubclause);
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
	public void setParsedAnnexSubclause(AnnexSubclause newParsedAnnexSubclause) {
		if (newParsedAnnexSubclause != parsedAnnexSubclause) {
			NotificationChain msgs = null;
			if (parsedAnnexSubclause != null) {
				msgs = ((InternalEObject) parsedAnnexSubclause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__PARSED_ANNEX_SUBCLAUSE, null, msgs);
			}
			if (newParsedAnnexSubclause != null) {
				msgs = ((InternalEObject) newParsedAnnexSubclause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__PARSED_ANNEX_SUBCLAUSE, null, msgs);
			}
			msgs = basicSetParsedAnnexSubclause(newParsedAnnexSubclause, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__PARSED_ANNEX_SUBCLAUSE, newParsedAnnexSubclause,
					newParsedAnnexSubclause));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnnexSubclause createParsedAnnexSubclause(EClass eClass) {
		AnnexSubclause newParsedAnnexSubclause = (AnnexSubclause) create(eClass);
		setParsedAnnexSubclause(newParsedAnnexSubclause);
		return newParsedAnnexSubclause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnnexSubclause createParsedAnnexSubclause() {
		return createParsedAnnexSubclause(Aadl2Package.eINSTANCE.getAnnexSubclause());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__PARSED_ANNEX_SUBCLAUSE:
			return basicSetParsedAnnexSubclause(null, msgs);
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
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__SOURCE_TEXT:
			return getSourceText();
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__PARSED_ANNEX_SUBCLAUSE:
			return getParsedAnnexSubclause();
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
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__SOURCE_TEXT:
			setSourceText((String) newValue);
			return;
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__PARSED_ANNEX_SUBCLAUSE:
			setParsedAnnexSubclause((AnnexSubclause) newValue);
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
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__SOURCE_TEXT:
			setSourceText(SOURCE_TEXT_EDEFAULT);
			return;
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__PARSED_ANNEX_SUBCLAUSE:
			setParsedAnnexSubclause((AnnexSubclause) null);
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
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__SOURCE_TEXT:
			return SOURCE_TEXT_EDEFAULT == null ? sourceText != null : !SOURCE_TEXT_EDEFAULT.equals(sourceText);
		case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE__PARSED_ANNEX_SUBCLAUSE:
			return parsedAnnexSubclause != null;
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

} // DefaultAnnexSubclauseImpl
