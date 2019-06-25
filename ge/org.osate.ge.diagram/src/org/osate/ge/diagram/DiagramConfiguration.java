/**
 */
package org.osate.ge.diagram;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ge.diagram.DiagramConfiguration#getType <em>Type</em>}</li>
 *   <li>{@link org.osate.ge.diagram.DiagramConfiguration#getEnabledAadlProperties <em>Enabled Aadl Properties</em>}</li>
 *   <li>{@link org.osate.ge.diagram.DiagramConfiguration#getContext <em>Context</em>}</li>
 *   <li>{@link org.osate.ge.diagram.DiagramConfiguration#getConnectionPrimaryLabelsVisible <em>Connection Primary Labels Visible</em>}</li>
 * </ul>
 *
 * @see org.osate.ge.diagram.DiagramPackage#getDiagramConfiguration()
 * @model kind="class"
 * @generated
 */
public class DiagramConfiguration extends MinimalEObjectImpl.Container implements EObject {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEnabledAadlProperties() <em>Enabled Aadl Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnabledAadlProperties()
	 * @generated
	 * @ordered
	 */
	protected AadlPropertiesSet enabledAadlProperties;

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected CanonicalBusinessObjectReference context;

	/**
	 * The default value of the '{@link #getConnectionPrimaryLabelsVisible() <em>Connection Primary Labels Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionPrimaryLabelsVisible()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean CONNECTION_PRIMARY_LABELS_VISIBLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConnectionPrimaryLabelsVisible() <em>Connection Primary Labels Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionPrimaryLabelsVisible()
	 * @generated
	 * @ordered
	 */
	protected Boolean connectionPrimaryLabelsVisible = CONNECTION_PRIMARY_LABELS_VISIBLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramConfiguration() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.DIAGRAM_CONFIGURATION;
	}

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramConfiguration_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramConfiguration#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_CONFIGURATION__TYPE, oldType, type));
	}

	/**
	 * Returns the value of the '<em><b>Enabled Aadl Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Aadl Properties</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Aadl Properties</em>' containment reference.
	 * @see #setEnabledAadlProperties(AadlPropertiesSet)
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramConfiguration_EnabledAadlProperties()
	 * @model containment="true"
	 * @generated
	 */
	public AadlPropertiesSet getEnabledAadlProperties() {
		return enabledAadlProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEnabledAadlProperties(AadlPropertiesSet newEnabledAadlProperties, NotificationChain msgs) {
		AadlPropertiesSet oldEnabledAadlProperties = enabledAadlProperties;
		enabledAadlProperties = newEnabledAadlProperties;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_CONFIGURATION__ENABLED_AADL_PROPERTIES, oldEnabledAadlProperties, newEnabledAadlProperties);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramConfiguration#getEnabledAadlProperties <em>Enabled Aadl Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Aadl Properties</em>' containment reference.
	 * @see #getEnabledAadlProperties()
	 * @generated
	 */
	public void setEnabledAadlProperties(AadlPropertiesSet newEnabledAadlProperties) {
		if (newEnabledAadlProperties != enabledAadlProperties) {
			NotificationChain msgs = null;
			if (enabledAadlProperties != null)
				msgs = enabledAadlProperties.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_CONFIGURATION__ENABLED_AADL_PROPERTIES, null, msgs);
			if (newEnabledAadlProperties != null)
				msgs = newEnabledAadlProperties.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_CONFIGURATION__ENABLED_AADL_PROPERTIES, null, msgs);
			msgs = basicSetEnabledAadlProperties(newEnabledAadlProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_CONFIGURATION__ENABLED_AADL_PROPERTIES, newEnabledAadlProperties, newEnabledAadlProperties));
	}

	/**
	 * Returns the value of the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' containment reference.
	 * @see #setContext(CanonicalBusinessObjectReference)
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramConfiguration_Context()
	 * @model containment="true"
	 * @generated
	 */
	public CanonicalBusinessObjectReference getContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContext(CanonicalBusinessObjectReference newContext, NotificationChain msgs) {
		CanonicalBusinessObjectReference oldContext = context;
		context = newContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_CONFIGURATION__CONTEXT, oldContext, newContext);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramConfiguration#getContext <em>Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' containment reference.
	 * @see #getContext()
	 * @generated
	 */
	public void setContext(CanonicalBusinessObjectReference newContext) {
		if (newContext != context) {
			NotificationChain msgs = null;
			if (context != null)
				msgs = context.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_CONFIGURATION__CONTEXT, null, msgs);
			if (newContext != null)
				msgs = newContext.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_CONFIGURATION__CONTEXT, null, msgs);
			msgs = basicSetContext(newContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_CONFIGURATION__CONTEXT, newContext, newContext));
	}

	/**
	 * Returns the value of the '<em><b>Connection Primary Labels Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Primary Labels Visible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Primary Labels Visible</em>' attribute.
	 * @see #setConnectionPrimaryLabelsVisible(Boolean)
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramConfiguration_ConnectionPrimaryLabelsVisible()
	 * @model
	 * @generated
	 */
	public Boolean getConnectionPrimaryLabelsVisible() {
		return connectionPrimaryLabelsVisible;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramConfiguration#getConnectionPrimaryLabelsVisible <em>Connection Primary Labels Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Primary Labels Visible</em>' attribute.
	 * @see #getConnectionPrimaryLabelsVisible()
	 * @generated
	 */
	public void setConnectionPrimaryLabelsVisible(Boolean newConnectionPrimaryLabelsVisible) {
		Boolean oldConnectionPrimaryLabelsVisible = connectionPrimaryLabelsVisible;
		connectionPrimaryLabelsVisible = newConnectionPrimaryLabelsVisible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_CONFIGURATION__CONNECTION_PRIMARY_LABELS_VISIBLE, oldConnectionPrimaryLabelsVisible, connectionPrimaryLabelsVisible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramPackage.DIAGRAM_CONFIGURATION__ENABLED_AADL_PROPERTIES:
				return basicSetEnabledAadlProperties(null, msgs);
			case DiagramPackage.DIAGRAM_CONFIGURATION__CONTEXT:
				return basicSetContext(null, msgs);
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
			case DiagramPackage.DIAGRAM_CONFIGURATION__TYPE:
				return getType();
			case DiagramPackage.DIAGRAM_CONFIGURATION__ENABLED_AADL_PROPERTIES:
				return getEnabledAadlProperties();
			case DiagramPackage.DIAGRAM_CONFIGURATION__CONTEXT:
				return getContext();
			case DiagramPackage.DIAGRAM_CONFIGURATION__CONNECTION_PRIMARY_LABELS_VISIBLE:
				return getConnectionPrimaryLabelsVisible();
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
			case DiagramPackage.DIAGRAM_CONFIGURATION__TYPE:
				setType((String)newValue);
				return;
			case DiagramPackage.DIAGRAM_CONFIGURATION__ENABLED_AADL_PROPERTIES:
				setEnabledAadlProperties((AadlPropertiesSet)newValue);
				return;
			case DiagramPackage.DIAGRAM_CONFIGURATION__CONTEXT:
				setContext((CanonicalBusinessObjectReference)newValue);
				return;
			case DiagramPackage.DIAGRAM_CONFIGURATION__CONNECTION_PRIMARY_LABELS_VISIBLE:
				setConnectionPrimaryLabelsVisible((Boolean)newValue);
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
			case DiagramPackage.DIAGRAM_CONFIGURATION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case DiagramPackage.DIAGRAM_CONFIGURATION__ENABLED_AADL_PROPERTIES:
				setEnabledAadlProperties((AadlPropertiesSet)null);
				return;
			case DiagramPackage.DIAGRAM_CONFIGURATION__CONTEXT:
				setContext((CanonicalBusinessObjectReference)null);
				return;
			case DiagramPackage.DIAGRAM_CONFIGURATION__CONNECTION_PRIMARY_LABELS_VISIBLE:
				setConnectionPrimaryLabelsVisible(CONNECTION_PRIMARY_LABELS_VISIBLE_EDEFAULT);
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
			case DiagramPackage.DIAGRAM_CONFIGURATION__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case DiagramPackage.DIAGRAM_CONFIGURATION__ENABLED_AADL_PROPERTIES:
				return enabledAadlProperties != null;
			case DiagramPackage.DIAGRAM_CONFIGURATION__CONTEXT:
				return context != null;
			case DiagramPackage.DIAGRAM_CONFIGURATION__CONNECTION_PRIMARY_LABELS_VISIBLE:
				return CONNECTION_PRIMARY_LABELS_VISIBLE_EDEFAULT == null ? connectionPrimaryLabelsVisible != null : !CONNECTION_PRIMARY_LABELS_VISIBLE_EDEFAULT.equals(connectionPrimaryLabelsVisible);
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
		result.append(" (type: ");
		result.append(type);
		result.append(", connectionPrimaryLabelsVisible: ");
		result.append(connectionPrimaryLabelsVisible);
		result.append(')');
		return result.toString();
	}

} // DiagramConfiguration
