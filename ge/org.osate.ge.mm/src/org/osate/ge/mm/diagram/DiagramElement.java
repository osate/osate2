/**
 */
package org.osate.ge.mm.diagram;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ge.mm.diagram.DiagramElement#getBo <em>Bo</em>}</li>
 *   <li>{@link org.osate.ge.mm.diagram.DiagramElement#isManual <em>Manual</em>}</li>
 *   <li>{@link org.osate.ge.mm.diagram.DiagramElement#getAutoContentsFilter <em>Auto Contents Filter</em>}</li>
 *   <li>{@link org.osate.ge.mm.diagram.DiagramElement#getPosition <em>Position</em>}</li>
 *   <li>{@link org.osate.ge.mm.diagram.DiagramElement#getSize <em>Size</em>}</li>
 *   <li>{@link org.osate.ge.mm.diagram.DiagramElement#getDockArea <em>Dock Area</em>}</li>
 *   <li>{@link org.osate.ge.mm.diagram.DiagramElement#getBendpoints <em>Bendpoints</em>}</li>
 *   <li>{@link org.osate.ge.mm.diagram.DiagramElement#getPrimaryLabelPosition <em>Primary Label Position</em>}</li>
 * </ul>
 *
 * @see org.osate.ge.mm.diagram.DiagramPackage#getDiagramElement()
 * @model kind="class"
 * @generated
 */
public class DiagramElement extends DiagramNode {
	/**
	 * The cached value of the '{@link #getBo() <em>Bo</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBo()
	 * @generated
	 * @ordered
	 */
	protected RelativeBusinessObjectReference bo;

	/**
	 * The default value of the '{@link #isManual() <em>Manual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isManual()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MANUAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isManual() <em>Manual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isManual()
	 * @generated
	 * @ordered
	 */
	protected boolean manual = MANUAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getAutoContentsFilter() <em>Auto Contents Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutoContentsFilter()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTO_CONTENTS_FILTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAutoContentsFilter() <em>Auto Contents Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutoContentsFilter()
	 * @generated
	 * @ordered
	 */
	protected String autoContentsFilter = AUTO_CONTENTS_FILTER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected Point position;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected Dimension size;

	/**
	 * The default value of the '{@link #getDockArea() <em>Dock Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDockArea()
	 * @generated
	 * @ordered
	 */
	protected static final String DOCK_AREA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDockArea() <em>Dock Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDockArea()
	 * @generated
	 * @ordered
	 */
	protected String dockArea = DOCK_AREA_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBendpoints() <em>Bendpoints</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBendpoints()
	 * @generated
	 * @ordered
	 */
	protected BendpointList bendpoints;

	/**
	 * The cached value of the '{@link #getPrimaryLabelPosition() <em>Primary Label Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryLabelPosition()
	 * @generated
	 * @ordered
	 */
	protected Point primaryLabelPosition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramElement() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.DIAGRAM_ELEMENT;
	}

	/**
	 * Returns the value of the '<em><b>Bo</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bo</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bo</em>' containment reference.
	 * @see #setBo(RelativeBusinessObjectReference)
	 * @see org.osate.ge.mm.diagram.DiagramPackage#getDiagramElement_Bo()
	 * @model containment="true"
	 * @generated
	 */
	public RelativeBusinessObjectReference getBo() {
		return bo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBo(RelativeBusinessObjectReference newBo, NotificationChain msgs) {
		RelativeBusinessObjectReference oldBo = bo;
		bo = newBo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__BO, oldBo, newBo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.mm.diagram.DiagramElement#getBo <em>Bo</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bo</em>' containment reference.
	 * @see #getBo()
	 * @generated
	 */
	public void setBo(RelativeBusinessObjectReference newBo) {
		if (newBo != bo) {
			NotificationChain msgs = null;
			if (bo != null)
				msgs = ((InternalEObject)bo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_ELEMENT__BO, null, msgs);
			if (newBo != null)
				msgs = ((InternalEObject)newBo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_ELEMENT__BO, null, msgs);
			msgs = basicSetBo(newBo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__BO, newBo, newBo));
	}

	/**
	 * Returns the value of the '<em><b>Manual</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manual</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manual</em>' attribute.
	 * @see #setManual(boolean)
	 * @see org.osate.ge.mm.diagram.DiagramPackage#getDiagramElement_Manual()
	 * @model default="false" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 * @generated
	 */
	public boolean isManual() {
		return manual;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.mm.diagram.DiagramElement#isManual <em>Manual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manual</em>' attribute.
	 * @see #isManual()
	 * @generated
	 */
	public void setManual(boolean newManual) {
		boolean oldManual = manual;
		manual = newManual;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__MANUAL, oldManual, manual));
	}

	/**
	 * Returns the value of the '<em><b>Auto Contents Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Contents Filter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Contents Filter</em>' attribute.
	 * @see #setAutoContentsFilter(String)
	 * @see org.osate.ge.mm.diagram.DiagramPackage#getDiagramElement_AutoContentsFilter()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	public String getAutoContentsFilter() {
		return autoContentsFilter;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.mm.diagram.DiagramElement#getAutoContentsFilter <em>Auto Contents Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Contents Filter</em>' attribute.
	 * @see #getAutoContentsFilter()
	 * @generated
	 */
	public void setAutoContentsFilter(String newAutoContentsFilter) {
		String oldAutoContentsFilter = autoContentsFilter;
		autoContentsFilter = newAutoContentsFilter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__AUTO_CONTENTS_FILTER, oldAutoContentsFilter, autoContentsFilter));
	}

	/**
	 * Returns the value of the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' containment reference.
	 * @see #setPosition(Point)
	 * @see org.osate.ge.mm.diagram.DiagramPackage#getDiagramElement_Position()
	 * @model containment="true"
	 * @generated
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPosition(Point newPosition, NotificationChain msgs) {
		Point oldPosition = position;
		position = newPosition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__POSITION, oldPosition, newPosition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.mm.diagram.DiagramElement#getPosition <em>Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' containment reference.
	 * @see #getPosition()
	 * @generated
	 */
	public void setPosition(Point newPosition) {
		if (newPosition != position) {
			NotificationChain msgs = null;
			if (position != null)
				msgs = ((InternalEObject)position).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_ELEMENT__POSITION, null, msgs);
			if (newPosition != null)
				msgs = ((InternalEObject)newPosition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_ELEMENT__POSITION, null, msgs);
			msgs = basicSetPosition(newPosition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__POSITION, newPosition, newPosition));
	}

	/**
	 * Returns the value of the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' containment reference.
	 * @see #setSize(Dimension)
	 * @see org.osate.ge.mm.diagram.DiagramPackage#getDiagramElement_Size()
	 * @model containment="true"
	 * @generated
	 */
	public Dimension getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSize(Dimension newSize, NotificationChain msgs) {
		Dimension oldSize = size;
		size = newSize;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__SIZE, oldSize, newSize);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.mm.diagram.DiagramElement#getSize <em>Size</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' containment reference.
	 * @see #getSize()
	 * @generated
	 */
	public void setSize(Dimension newSize) {
		if (newSize != size) {
			NotificationChain msgs = null;
			if (size != null)
				msgs = ((InternalEObject)size).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_ELEMENT__SIZE, null, msgs);
			if (newSize != null)
				msgs = ((InternalEObject)newSize).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_ELEMENT__SIZE, null, msgs);
			msgs = basicSetSize(newSize, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__SIZE, newSize, newSize));
	}

	/**
	 * Returns the value of the '<em><b>Dock Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dock Area</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dock Area</em>' attribute.
	 * @see #setDockArea(String)
	 * @see org.osate.ge.mm.diagram.DiagramPackage#getDiagramElement_DockArea()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	public String getDockArea() {
		return dockArea;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.mm.diagram.DiagramElement#getDockArea <em>Dock Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dock Area</em>' attribute.
	 * @see #getDockArea()
	 * @generated
	 */
	public void setDockArea(String newDockArea) {
		String oldDockArea = dockArea;
		dockArea = newDockArea;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__DOCK_AREA, oldDockArea, dockArea));
	}

	/**
	 * Returns the value of the '<em><b>Bendpoints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bendpoints</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bendpoints</em>' containment reference.
	 * @see #setBendpoints(BendpointList)
	 * @see org.osate.ge.mm.diagram.DiagramPackage#getDiagramElement_Bendpoints()
	 * @model containment="true"
	 * @generated
	 */
	public BendpointList getBendpoints() {
		return bendpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBendpoints(BendpointList newBendpoints, NotificationChain msgs) {
		BendpointList oldBendpoints = bendpoints;
		bendpoints = newBendpoints;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__BENDPOINTS, oldBendpoints, newBendpoints);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.mm.diagram.DiagramElement#getBendpoints <em>Bendpoints</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bendpoints</em>' containment reference.
	 * @see #getBendpoints()
	 * @generated
	 */
	public void setBendpoints(BendpointList newBendpoints) {
		if (newBendpoints != bendpoints) {
			NotificationChain msgs = null;
			if (bendpoints != null)
				msgs = ((InternalEObject)bendpoints).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_ELEMENT__BENDPOINTS, null, msgs);
			if (newBendpoints != null)
				msgs = ((InternalEObject)newBendpoints).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_ELEMENT__BENDPOINTS, null, msgs);
			msgs = basicSetBendpoints(newBendpoints, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__BENDPOINTS, newBendpoints, newBendpoints));
	}

	/**
	 * Returns the value of the '<em><b>Primary Label Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Only supported for connections.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Primary Label Position</em>' containment reference.
	 * @see #setPrimaryLabelPosition(Point)
	 * @see org.osate.ge.mm.diagram.DiagramPackage#getDiagramElement_PrimaryLabelPosition()
	 * @model containment="true"
	 * @generated
	 */
	public Point getPrimaryLabelPosition() {
		return primaryLabelPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrimaryLabelPosition(Point newPrimaryLabelPosition, NotificationChain msgs) {
		Point oldPrimaryLabelPosition = primaryLabelPosition;
		primaryLabelPosition = newPrimaryLabelPosition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__PRIMARY_LABEL_POSITION, oldPrimaryLabelPosition, newPrimaryLabelPosition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.mm.diagram.DiagramElement#getPrimaryLabelPosition <em>Primary Label Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Label Position</em>' containment reference.
	 * @see #getPrimaryLabelPosition()
	 * @generated
	 */
	public void setPrimaryLabelPosition(Point newPrimaryLabelPosition) {
		if (newPrimaryLabelPosition != primaryLabelPosition) {
			NotificationChain msgs = null;
			if (primaryLabelPosition != null)
				msgs = ((InternalEObject)primaryLabelPosition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_ELEMENT__PRIMARY_LABEL_POSITION, null, msgs);
			if (newPrimaryLabelPosition != null)
				msgs = ((InternalEObject)newPrimaryLabelPosition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_ELEMENT__PRIMARY_LABEL_POSITION, null, msgs);
			msgs = basicSetPrimaryLabelPosition(newPrimaryLabelPosition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__PRIMARY_LABEL_POSITION, newPrimaryLabelPosition, newPrimaryLabelPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramPackage.DIAGRAM_ELEMENT__BO:
				return basicSetBo(null, msgs);
			case DiagramPackage.DIAGRAM_ELEMENT__POSITION:
				return basicSetPosition(null, msgs);
			case DiagramPackage.DIAGRAM_ELEMENT__SIZE:
				return basicSetSize(null, msgs);
			case DiagramPackage.DIAGRAM_ELEMENT__BENDPOINTS:
				return basicSetBendpoints(null, msgs);
			case DiagramPackage.DIAGRAM_ELEMENT__PRIMARY_LABEL_POSITION:
				return basicSetPrimaryLabelPosition(null, msgs);
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
			case DiagramPackage.DIAGRAM_ELEMENT__BO:
				return getBo();
			case DiagramPackage.DIAGRAM_ELEMENT__MANUAL:
				return isManual();
			case DiagramPackage.DIAGRAM_ELEMENT__AUTO_CONTENTS_FILTER:
				return getAutoContentsFilter();
			case DiagramPackage.DIAGRAM_ELEMENT__POSITION:
				return getPosition();
			case DiagramPackage.DIAGRAM_ELEMENT__SIZE:
				return getSize();
			case DiagramPackage.DIAGRAM_ELEMENT__DOCK_AREA:
				return getDockArea();
			case DiagramPackage.DIAGRAM_ELEMENT__BENDPOINTS:
				return getBendpoints();
			case DiagramPackage.DIAGRAM_ELEMENT__PRIMARY_LABEL_POSITION:
				return getPrimaryLabelPosition();
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
			case DiagramPackage.DIAGRAM_ELEMENT__BO:
				setBo((RelativeBusinessObjectReference)newValue);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__MANUAL:
				setManual((Boolean)newValue);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__AUTO_CONTENTS_FILTER:
				setAutoContentsFilter((String)newValue);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__POSITION:
				setPosition((Point)newValue);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__SIZE:
				setSize((Dimension)newValue);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__DOCK_AREA:
				setDockArea((String)newValue);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__BENDPOINTS:
				setBendpoints((BendpointList)newValue);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__PRIMARY_LABEL_POSITION:
				setPrimaryLabelPosition((Point)newValue);
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
			case DiagramPackage.DIAGRAM_ELEMENT__BO:
				setBo((RelativeBusinessObjectReference)null);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__MANUAL:
				setManual(MANUAL_EDEFAULT);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__AUTO_CONTENTS_FILTER:
				setAutoContentsFilter(AUTO_CONTENTS_FILTER_EDEFAULT);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__POSITION:
				setPosition((Point)null);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__SIZE:
				setSize((Dimension)null);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__DOCK_AREA:
				setDockArea(DOCK_AREA_EDEFAULT);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__BENDPOINTS:
				setBendpoints((BendpointList)null);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__PRIMARY_LABEL_POSITION:
				setPrimaryLabelPosition((Point)null);
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
			case DiagramPackage.DIAGRAM_ELEMENT__BO:
				return bo != null;
			case DiagramPackage.DIAGRAM_ELEMENT__MANUAL:
				return manual != MANUAL_EDEFAULT;
			case DiagramPackage.DIAGRAM_ELEMENT__AUTO_CONTENTS_FILTER:
				return AUTO_CONTENTS_FILTER_EDEFAULT == null ? autoContentsFilter != null : !AUTO_CONTENTS_FILTER_EDEFAULT.equals(autoContentsFilter);
			case DiagramPackage.DIAGRAM_ELEMENT__POSITION:
				return position != null;
			case DiagramPackage.DIAGRAM_ELEMENT__SIZE:
				return size != null;
			case DiagramPackage.DIAGRAM_ELEMENT__DOCK_AREA:
				return DOCK_AREA_EDEFAULT == null ? dockArea != null : !DOCK_AREA_EDEFAULT.equals(dockArea);
			case DiagramPackage.DIAGRAM_ELEMENT__BENDPOINTS:
				return bendpoints != null;
			case DiagramPackage.DIAGRAM_ELEMENT__PRIMARY_LABEL_POSITION:
				return primaryLabelPosition != null;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (manual: ");
		result.append(manual);
		result.append(", autoContentsFilter: ");
		result.append(autoContentsFilter);
		result.append(", dockArea: ");
		result.append(dockArea);
		result.append(')');
		return result.toString();
	}

} // DiagramElement
