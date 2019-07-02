/**
 */
package org.osate.ge.diagram;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ge.diagram.Diagram#getConfig <em>Config</em>}</li>
 *   <li>{@link org.osate.ge.diagram.Diagram#getFormatVersion <em>Format Version</em>}</li>
 * </ul>
 *
 * @see org.osate.ge.diagram.DiagramPackage#getDiagram()
 * @model kind="class"
 * @generated
 */
public class Diagram extends DiagramNode {
	/**
	 * The cached value of the '{@link #getConfig() <em>Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfig()
	 * @generated
	 * @ordered
	 */
	protected DiagramConfiguration config;

	/**
	 * The default value of the '{@link #getFormatVersion() <em>Format Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormatVersion()
	 * @generated
	 * @ordered
	 */
	protected static final int FORMAT_VERSION_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getFormatVersion() <em>Format Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormatVersion()
	 * @generated
	 * @ordered
	 */
	protected int formatVersion = FORMAT_VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.DIAGRAM;
	}

	/**
	 * Returns the value of the '<em><b>Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Config</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Config</em>' containment reference.
	 * @see #setConfig(DiagramConfiguration)
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagram_Config()
	 * @model containment="true"
	 * @generated
	 */
	public DiagramConfiguration getConfig() {
		return config;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfig(DiagramConfiguration newConfig, NotificationChain msgs) {
		DiagramConfiguration oldConfig = config;
		config = newConfig;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM__CONFIG, oldConfig, newConfig);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.diagram.Diagram#getConfig <em>Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config</em>' containment reference.
	 * @see #getConfig()
	 * @generated
	 */
	public void setConfig(DiagramConfiguration newConfig) {
		if (newConfig != config) {
			NotificationChain msgs = null;
			if (config != null)
				msgs = config.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM__CONFIG, null, msgs);
			if (newConfig != null)
				msgs = newConfig.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM__CONFIG, null, msgs);
			msgs = basicSetConfig(newConfig, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM__CONFIG, newConfig, newConfig));
	}

	/**
	 * Returns the value of the '<em><b>Format Version</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Format Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format Version</em>' attribute.
	 * @see #setFormatVersion(int)
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagram_FormatVersion()
	 * @model default="0" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 * @generated
	 */
	public int getFormatVersion() {
		return formatVersion;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.diagram.Diagram#getFormatVersion <em>Format Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format Version</em>' attribute.
	 * @see #getFormatVersion()
	 * @generated
	 */
	public void setFormatVersion(int newFormatVersion) {
		int oldFormatVersion = formatVersion;
		formatVersion = newFormatVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM__FORMAT_VERSION, oldFormatVersion, formatVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramPackage.DIAGRAM__CONFIG:
				return basicSetConfig(null, msgs);
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
			case DiagramPackage.DIAGRAM__CONFIG:
				return getConfig();
			case DiagramPackage.DIAGRAM__FORMAT_VERSION:
				return getFormatVersion();
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
			case DiagramPackage.DIAGRAM__CONFIG:
				setConfig((DiagramConfiguration)newValue);
				return;
			case DiagramPackage.DIAGRAM__FORMAT_VERSION:
				setFormatVersion((Integer)newValue);
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
			case DiagramPackage.DIAGRAM__CONFIG:
				setConfig((DiagramConfiguration)null);
				return;
			case DiagramPackage.DIAGRAM__FORMAT_VERSION:
				setFormatVersion(FORMAT_VERSION_EDEFAULT);
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
			case DiagramPackage.DIAGRAM__CONFIG:
				return config != null;
			case DiagramPackage.DIAGRAM__FORMAT_VERSION:
				return formatVersion != FORMAT_VERSION_EDEFAULT;
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
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (formatVersion: ");
		result.append(formatVersion);
		result.append(')');
		return result.toString();
	}

} // Diagram
