/**
 *
 *   Copyright (c)  2012 CEA LIST.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *
 *   Contributors:
 *       CEA LIST - initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.discovery.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.infra.discovery.DiscoveryPackage;
import org.eclipse.papyrus.infra.discovery.Message;
import org.eclipse.papyrus.infra.discovery.Severity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.MessageImpl#getTitle <em>Title</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.MessageImpl#getMessage <em>Message</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.MessageImpl#getIcon <em>Icon</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageImpl extends MinimalEObjectImpl implements Message {
	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected static final Severity ICON_EDEFAULT = Severity.INFO;

	/**
	 * The cached value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected Severity icon = ICON_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected MessageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiscoveryPackage.Literals.MESSAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.MESSAGE__TITLE, oldTitle, title));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.MESSAGE__MESSAGE, oldMessage, message));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Severity getIcon() {
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setIcon(Severity newIcon) {
		Severity oldIcon = icon;
		icon = newIcon == null ? ICON_EDEFAULT : newIcon;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.MESSAGE__ICON, oldIcon, icon));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case DiscoveryPackage.MESSAGE__TITLE:
			return getTitle();
		case DiscoveryPackage.MESSAGE__MESSAGE:
			return getMessage();
		case DiscoveryPackage.MESSAGE__ICON:
			return getIcon();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case DiscoveryPackage.MESSAGE__TITLE:
			setTitle((String) newValue);
			return;
		case DiscoveryPackage.MESSAGE__MESSAGE:
			setMessage((String) newValue);
			return;
		case DiscoveryPackage.MESSAGE__ICON:
			setIcon((Severity) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case DiscoveryPackage.MESSAGE__TITLE:
			setTitle(TITLE_EDEFAULT);
			return;
		case DiscoveryPackage.MESSAGE__MESSAGE:
			setMessage(MESSAGE_EDEFAULT);
			return;
		case DiscoveryPackage.MESSAGE__ICON:
			setIcon(ICON_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case DiscoveryPackage.MESSAGE__TITLE:
			return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
		case DiscoveryPackage.MESSAGE__MESSAGE:
			return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
		case DiscoveryPackage.MESSAGE__ICON:
			return icon != ICON_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (title: ");
		result.append(title);
		result.append(", message: ");
		result.append(message);
		result.append(", icon: ");
		result.append(icon);
		result.append(')');
		return result.toString();
	}

} // MessageImpl
