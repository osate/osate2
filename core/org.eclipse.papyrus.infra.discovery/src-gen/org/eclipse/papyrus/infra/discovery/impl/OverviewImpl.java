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
import org.eclipse.papyrus.infra.discovery.Overview;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Overview</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.OverviewImpl#getSummary <em>Summary</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.OverviewImpl#getScreenshot <em>Screenshot</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.discovery.impl.OverviewImpl#getUrl <em>Url</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OverviewImpl extends MinimalEObjectImpl implements Overview {
	/**
	 * The default value of the '{@link #getSummary() <em>Summary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getSummary()
	 * @generated
	 * @ordered
	 */
	protected static final String SUMMARY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSummary() <em>Summary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getSummary()
	 * @generated
	 * @ordered
	 */
	protected String summary = SUMMARY_EDEFAULT;

	/**
	 * The default value of the '{@link #getScreenshot() <em>Screenshot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getScreenshot()
	 * @generated
	 * @ordered
	 */
	protected static final String SCREENSHOT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getScreenshot() <em>Screenshot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getScreenshot()
	 * @generated
	 * @ordered
	 */
	protected String screenshot = SCREENSHOT_EDEFAULT;

	/**
	 * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String URL_EDEFAULT = "http://www.eclipse.org/modeling";

	/**
	 * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected String url = URL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected OverviewImpl() {
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
		return DiscoveryPackage.Literals.OVERVIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setSummary(String newSummary) {
		String oldSummary = summary;
		summary = newSummary;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.OVERVIEW__SUMMARY, oldSummary, summary));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String getScreenshot() {
		return screenshot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setScreenshot(String newScreenshot) {
		String oldScreenshot = screenshot;
		screenshot = newScreenshot;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.OVERVIEW__SCREENSHOT, oldScreenshot, screenshot));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setUrl(String newUrl) {
		String oldUrl = url;
		url = newUrl;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DiscoveryPackage.OVERVIEW__URL, oldUrl, url));
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
		case DiscoveryPackage.OVERVIEW__SUMMARY:
			return getSummary();
		case DiscoveryPackage.OVERVIEW__SCREENSHOT:
			return getScreenshot();
		case DiscoveryPackage.OVERVIEW__URL:
			return getUrl();
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
		case DiscoveryPackage.OVERVIEW__SUMMARY:
			setSummary((String) newValue);
			return;
		case DiscoveryPackage.OVERVIEW__SCREENSHOT:
			setScreenshot((String) newValue);
			return;
		case DiscoveryPackage.OVERVIEW__URL:
			setUrl((String) newValue);
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
		case DiscoveryPackage.OVERVIEW__SUMMARY:
			setSummary(SUMMARY_EDEFAULT);
			return;
		case DiscoveryPackage.OVERVIEW__SCREENSHOT:
			setScreenshot(SCREENSHOT_EDEFAULT);
			return;
		case DiscoveryPackage.OVERVIEW__URL:
			setUrl(URL_EDEFAULT);
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
		case DiscoveryPackage.OVERVIEW__SUMMARY:
			return SUMMARY_EDEFAULT == null ? summary != null : !SUMMARY_EDEFAULT.equals(summary);
		case DiscoveryPackage.OVERVIEW__SCREENSHOT:
			return SCREENSHOT_EDEFAULT == null ? screenshot != null : !SCREENSHOT_EDEFAULT.equals(screenshot);
		case DiscoveryPackage.OVERVIEW__URL:
			return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
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
		result.append(" (summary: ");
		result.append(summary);
		result.append(", screenshot: ");
		result.append(screenshot);
		result.append(", url: ");
		result.append(url);
		result.append(')');
		return result.toString();
	}

} // OverviewImpl
