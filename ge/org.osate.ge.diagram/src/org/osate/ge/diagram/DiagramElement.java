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
package org.osate.ge.diagram;

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
 *   <li>{@link org.osate.ge.diagram.DiagramElement#getUuid <em>Uuid</em>}</li>
 *   <li>{@link org.osate.ge.diagram.DiagramElement#getId <em>Id</em>}</li>
 *   <li>{@link org.osate.ge.diagram.DiagramElement#getBo <em>Bo</em>}</li>
 *   <li>{@link org.osate.ge.diagram.DiagramElement#isManual <em>Manual</em>}</li>
 *   <li>{@link org.osate.ge.diagram.DiagramElement#getAutoContentsFilter <em>Auto Contents Filter</em>}</li>
 *   <li>{@link org.osate.ge.diagram.DiagramElement#getPosition <em>Position</em>}</li>
 *   <li>{@link org.osate.ge.diagram.DiagramElement#getSize <em>Size</em>}</li>
 *   <li>{@link org.osate.ge.diagram.DiagramElement#getDockArea <em>Dock Area</em>}</li>
 *   <li>{@link org.osate.ge.diagram.DiagramElement#getBendpoints <em>Bendpoints</em>}</li>
 *   <li>{@link org.osate.ge.diagram.DiagramElement#getPrimaryLabelPosition <em>Primary Label Position</em>}</li>
 *   <li>{@link org.osate.ge.diagram.DiagramElement#getBackground <em>Background</em>}</li>
 *   <li>{@link org.osate.ge.diagram.DiagramElement#getOutline <em>Outline</em>}</li>
 *   <li>{@link org.osate.ge.diagram.DiagramElement#getFontColor <em>Font Color</em>}</li>
 *   <li>{@link org.osate.ge.diagram.DiagramElement#getFontSize <em>Font Size</em>}</li>
 *   <li>{@link org.osate.ge.diagram.DiagramElement#getLineWidth <em>Line Width</em>}</li>
 *   <li>{@link org.osate.ge.diagram.DiagramElement#getPrimaryLabelVisible <em>Primary Label Visible</em>}</li>
 *   <li>{@link org.osate.ge.diagram.DiagramElement#getImage <em>Image</em>}</li>
 *   <li>{@link org.osate.ge.diagram.DiagramElement#getShowAsImage <em>Show As Image</em>}</li>
 *   <li>{@link org.osate.ge.diagram.DiagramElement#getContentFilters <em>Content Filters</em>}</li>
 *   <li>{@link org.osate.ge.diagram.DiagramElement#getBoData <em>Bo Data</em>}</li>
 * </ul>
 *
 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement()
 * @model kind="class"
 * @generated
 */
public class DiagramElement extends DiagramNode {
	/**
	 * The default value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated
	 * @ordered
	 */
	protected static final String UUID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated
	 * @ordered
	 */
	protected String uuid = UUID_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final Long ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected Long id = ID_EDEFAULT;

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
	 * The default value of the '{@link #getBackground() <em>Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackground()
	 * @generated
	 * @ordered
	 */
	protected static final String BACKGROUND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBackground() <em>Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackground()
	 * @generated
	 * @ordered
	 */
	protected String background = BACKGROUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutline() <em>Outline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutline()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTLINE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutline() <em>Outline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutline()
	 * @generated
	 * @ordered
	 */
	protected String outline = OUTLINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFontColor() <em>Font Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontColor()
	 * @generated
	 * @ordered
	 */
	protected static final String FONT_COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFontColor() <em>Font Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontColor()
	 * @generated
	 * @ordered
	 */
	protected String fontColor = FONT_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getFontSize() <em>Font Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontSize()
	 * @generated
	 * @ordered
	 */
	protected static final Double FONT_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFontSize() <em>Font Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontSize()
	 * @generated
	 * @ordered
	 */
	protected Double fontSize = FONT_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLineWidth() <em>Line Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineWidth()
	 * @generated
	 * @ordered
	 */
	protected static final Double LINE_WIDTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLineWidth() <em>Line Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineWidth()
	 * @generated
	 * @ordered
	 */
	protected Double lineWidth = LINE_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrimaryLabelVisible() <em>Primary Label Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryLabelVisible()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean PRIMARY_LABEL_VISIBLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimaryLabelVisible() <em>Primary Label Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryLabelVisible()
	 * @generated
	 * @ordered
	 */
	protected Boolean primaryLabelVisible = PRIMARY_LABEL_VISIBLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getImage() <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected static final String IMAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImage() <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected String image = IMAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getShowAsImage() <em>Show As Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShowAsImage()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean SHOW_AS_IMAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShowAsImage() <em>Show As Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShowAsImage()
	 * @generated
	 * @ordered
	 */
	protected Boolean showAsImage = SHOW_AS_IMAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContentFilters() <em>Content Filters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentFilters()
	 * @generated
	 * @ordered
	 */
	protected ContentFilters contentFilters;

	/**
	 * The default value of the '{@link #getBoData() <em>Bo Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoData()
	 * @generated
	 * @ordered
	 */
	protected static final String BO_DATA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBoData() <em>Bo Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoData()
	 * @generated
	 * @ordered
	 */
	protected String boData = BO_DATA_EDEFAULT;

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
	 * Returns the value of the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uuid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A unique identifier for the diagram element. The UUID is unique within a diagram. Since diagram files may be copied, this UUID is not guaranteed to be universally unique. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Uuid</em>' attribute.
	 * @see #setUuid(String)
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement_Uuid()
	 * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramElement#getUuid <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uuid</em>' attribute.
	 * @see #getUuid()
	 * @generated
	 */
	public void setUuid(String newUuid) {
		String oldUuid = uuid;
		uuid = newUuid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__UUID, oldUuid, uuid));
	}

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(Long)
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.LongObject"
	 * @generated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramElement#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	public void setId(Long newId) {
		Long oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__ID, oldId, id));
	}

	/**
	 * Returns the value of the '<em><b>Bo</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bo</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bo</em>' containment reference.
	 * @see #setBo(RelativeBusinessObjectReference)
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement_Bo()
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
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramElement#getBo <em>Bo</em>}' containment reference.
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
				msgs = bo.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_ELEMENT__BO, null, msgs);
			if (newBo != null)
				msgs = newBo.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_ELEMENT__BO, null, msgs);
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
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Deprecated. Should be set to true for all newly saved elements. Retained for compatibility with versions of OSATE <= 2.5.0
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Manual</em>' attribute.
	 * @see #setManual(boolean)
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement_Manual()
	 * @model default="false" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 * @generated
	 */
	public boolean isManual() {
		return manual;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramElement#isManual <em>Manual</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Deprecated
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Auto Contents Filter</em>' attribute.
	 * @see #setAutoContentsFilter(String)
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement_AutoContentsFilter()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	public String getAutoContentsFilter() {
		return autoContentsFilter;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramElement#getAutoContentsFilter <em>Auto Contents Filter</em>}' attribute.
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
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement_Position()
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
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramElement#getPosition <em>Position</em>}' containment reference.
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
				msgs = position.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_ELEMENT__POSITION, null, msgs);
			if (newPosition != null)
				msgs = newPosition.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_ELEMENT__POSITION, null, msgs);
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
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement_Size()
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
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramElement#getSize <em>Size</em>}' containment reference.
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
				msgs = size.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_ELEMENT__SIZE, null, msgs);
			if (newSize != null)
				msgs = newSize.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_ELEMENT__SIZE, null, msgs);
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
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement_DockArea()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	public String getDockArea() {
		return dockArea;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramElement#getDockArea <em>Dock Area</em>}' attribute.
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
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement_Bendpoints()
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
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramElement#getBendpoints <em>Bendpoints</em>}' containment reference.
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
				msgs = bendpoints.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_ELEMENT__BENDPOINTS, null, msgs);
			if (newBendpoints != null)
				msgs = newBendpoints.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_ELEMENT__BENDPOINTS, null, msgs);
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
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement_PrimaryLabelPosition()
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
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramElement#getPrimaryLabelPosition <em>Primary Label Position</em>}' containment reference.
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
				msgs = primaryLabelPosition.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_ELEMENT__PRIMARY_LABEL_POSITION, null, msgs);
			if (newPrimaryLabelPosition != null)
				msgs = newPrimaryLabelPosition.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_ELEMENT__PRIMARY_LABEL_POSITION, null, msgs);
			msgs = basicSetPrimaryLabelPosition(newPrimaryLabelPosition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__PRIMARY_LABEL_POSITION, newPrimaryLabelPosition, newPrimaryLabelPosition));
	}

	/**
	 * Returns the value of the '<em><b>Background</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Background</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Background</em>' attribute.
	 * @see #setBackground(String)
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement_Background()
	 * @model dataType="org.osate.ge.diagram.Color"
	 * @generated
	 */
	public String getBackground() {
		return background;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramElement#getBackground <em>Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Background</em>' attribute.
	 * @see #getBackground()
	 * @generated
	 */
	public void setBackground(String newBackground) {
		String oldBackground = background;
		background = newBackground;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__BACKGROUND, oldBackground, background));
	}

	/**
	 * Returns the value of the '<em><b>Outline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outline</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outline</em>' attribute.
	 * @see #setOutline(String)
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement_Outline()
	 * @model dataType="org.osate.ge.diagram.Color"
	 * @generated
	 */
	public String getOutline() {
		return outline;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramElement#getOutline <em>Outline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outline</em>' attribute.
	 * @see #getOutline()
	 * @generated
	 */
	public void setOutline(String newOutline) {
		String oldOutline = outline;
		outline = newOutline;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__OUTLINE, oldOutline, outline));
	}

	/**
	 * Returns the value of the '<em><b>Font Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Color</em>' attribute.
	 * @see #setFontColor(String)
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement_FontColor()
	 * @model dataType="org.osate.ge.diagram.Color"
	 * @generated
	 */
	public String getFontColor() {
		return fontColor;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramElement#getFontColor <em>Font Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Color</em>' attribute.
	 * @see #getFontColor()
	 * @generated
	 */
	public void setFontColor(String newFontColor) {
		String oldFontColor = fontColor;
		fontColor = newFontColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__FONT_COLOR, oldFontColor, fontColor));
	}

	/**
	 * Returns the value of the '<em><b>Font Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Size</em>' attribute.
	 * @see #setFontSize(Double)
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement_FontSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DoubleObject"
	 * @generated
	 */
	public Double getFontSize() {
		return fontSize;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramElement#getFontSize <em>Font Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Size</em>' attribute.
	 * @see #getFontSize()
	 * @generated
	 */
	public void setFontSize(Double newFontSize) {
		Double oldFontSize = fontSize;
		fontSize = newFontSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__FONT_SIZE, oldFontSize, fontSize));
	}

	/**
	 * Returns the value of the '<em><b>Line Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Width</em>' attribute.
	 * @see #setLineWidth(Double)
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement_LineWidth()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DoubleObject"
	 * @generated
	 */
	public Double getLineWidth() {
		return lineWidth;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramElement#getLineWidth <em>Line Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Width</em>' attribute.
	 * @see #getLineWidth()
	 * @generated
	 */
	public void setLineWidth(Double newLineWidth) {
		Double oldLineWidth = lineWidth;
		lineWidth = newLineWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__LINE_WIDTH, oldLineWidth, lineWidth));
	}

	/**
	 * Returns the value of the '<em><b>Primary Label Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Label Visible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Label Visible</em>' attribute.
	 * @see #setPrimaryLabelVisible(Boolean)
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement_PrimaryLabelVisible()
	 * @model
	 * @generated
	 */
	public Boolean getPrimaryLabelVisible() {
		return primaryLabelVisible;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramElement#getPrimaryLabelVisible <em>Primary Label Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Label Visible</em>' attribute.
	 * @see #getPrimaryLabelVisible()
	 * @generated
	 */
	public void setPrimaryLabelVisible(Boolean newPrimaryLabelVisible) {
		Boolean oldPrimaryLabelVisible = primaryLabelVisible;
		primaryLabelVisible = newPrimaryLabelVisible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__PRIMARY_LABEL_VISIBLE, oldPrimaryLabelVisible, primaryLabelVisible));
	}

	/**
	 * Returns the value of the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image</em>' attribute.
	 * @see #setImage(String)
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement_Image()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramElement#getImage <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image</em>' attribute.
	 * @see #getImage()
	 * @generated
	 */
	public void setImage(String newImage) {
		String oldImage = image;
		image = newImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__IMAGE, oldImage, image));
	}

	/**
	 * Returns the value of the '<em><b>Show As Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Show As Image</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Show As Image</em>' attribute.
	 * @see #setShowAsImage(Boolean)
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement_ShowAsImage()
	 * @model
	 * @generated
	 */
	public Boolean getShowAsImage() {
		return showAsImage;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramElement#getShowAsImage <em>Show As Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show As Image</em>' attribute.
	 * @see #getShowAsImage()
	 * @generated
	 */
	public void setShowAsImage(Boolean newShowAsImage) {
		Boolean oldShowAsImage = showAsImage;
		showAsImage = newShowAsImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__SHOW_AS_IMAGE, oldShowAsImage, showAsImage));
	}

	/**
	 * Returns the value of the '<em><b>Content Filters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Value	Deprecated
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Content Filters</em>' containment reference.
	 * @see #setContentFilters(ContentFilters)
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement_ContentFilters()
	 * @model containment="true"
	 * @generated
	 */
	public ContentFilters getContentFilters() {
		return contentFilters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContentFilters(ContentFilters newContentFilters, NotificationChain msgs) {
		ContentFilters oldContentFilters = contentFilters;
		contentFilters = newContentFilters;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__CONTENT_FILTERS, oldContentFilters, newContentFilters);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramElement#getContentFilters <em>Content Filters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content Filters</em>' containment reference.
	 * @see #getContentFilters()
	 * @generated
	 */
	public void setContentFilters(ContentFilters newContentFilters) {
		if (newContentFilters != contentFilters) {
			NotificationChain msgs = null;
			if (contentFilters != null)
				msgs = contentFilters.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_ELEMENT__CONTENT_FILTERS, null, msgs);
			if (newContentFilters != null)
				msgs = newContentFilters.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DIAGRAM_ELEMENT__CONTENT_FILTERS, null, msgs);
			msgs = basicSetContentFilters(newContentFilters, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__CONTENT_FILTERS, newContentFilters, newContentFilters));
	}

	/**
	 * Returns the value of the '<em><b>Bo Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Data which is associated with the element's business objects. Used for embedded business objects.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bo Data</em>' attribute.
	 * @see #setBoData(String)
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement_BoData()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	public String getBoData() {
		return boData;
	}

	/**
	 * Sets the value of the '{@link org.osate.ge.diagram.DiagramElement#getBoData <em>Bo Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bo Data</em>' attribute.
	 * @see #getBoData()
	 * @generated
	 */
	public void setBoData(String newBoData) {
		String oldBoData = boData;
		boData = newBoData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DIAGRAM_ELEMENT__BO_DATA, oldBoData, boData));
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
			case DiagramPackage.DIAGRAM_ELEMENT__CONTENT_FILTERS:
				return basicSetContentFilters(null, msgs);
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
			case DiagramPackage.DIAGRAM_ELEMENT__UUID:
				return getUuid();
			case DiagramPackage.DIAGRAM_ELEMENT__ID:
				return getId();
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
			case DiagramPackage.DIAGRAM_ELEMENT__BACKGROUND:
				return getBackground();
			case DiagramPackage.DIAGRAM_ELEMENT__OUTLINE:
				return getOutline();
			case DiagramPackage.DIAGRAM_ELEMENT__FONT_COLOR:
				return getFontColor();
			case DiagramPackage.DIAGRAM_ELEMENT__FONT_SIZE:
				return getFontSize();
			case DiagramPackage.DIAGRAM_ELEMENT__LINE_WIDTH:
				return getLineWidth();
			case DiagramPackage.DIAGRAM_ELEMENT__PRIMARY_LABEL_VISIBLE:
				return getPrimaryLabelVisible();
			case DiagramPackage.DIAGRAM_ELEMENT__IMAGE:
				return getImage();
			case DiagramPackage.DIAGRAM_ELEMENT__SHOW_AS_IMAGE:
				return getShowAsImage();
			case DiagramPackage.DIAGRAM_ELEMENT__CONTENT_FILTERS:
				return getContentFilters();
			case DiagramPackage.DIAGRAM_ELEMENT__BO_DATA:
				return getBoData();
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
			case DiagramPackage.DIAGRAM_ELEMENT__UUID:
				setUuid((String)newValue);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__ID:
				setId((Long)newValue);
				return;
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
			case DiagramPackage.DIAGRAM_ELEMENT__BACKGROUND:
				setBackground((String)newValue);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__OUTLINE:
				setOutline((String)newValue);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__FONT_COLOR:
				setFontColor((String)newValue);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__FONT_SIZE:
				setFontSize((Double)newValue);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__LINE_WIDTH:
				setLineWidth((Double)newValue);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__PRIMARY_LABEL_VISIBLE:
				setPrimaryLabelVisible((Boolean)newValue);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__IMAGE:
				setImage((String)newValue);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__SHOW_AS_IMAGE:
				setShowAsImage((Boolean)newValue);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__CONTENT_FILTERS:
				setContentFilters((ContentFilters)newValue);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__BO_DATA:
				setBoData((String)newValue);
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
			case DiagramPackage.DIAGRAM_ELEMENT__UUID:
				setUuid(UUID_EDEFAULT);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__ID:
				setId(ID_EDEFAULT);
				return;
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
			case DiagramPackage.DIAGRAM_ELEMENT__BACKGROUND:
				setBackground(BACKGROUND_EDEFAULT);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__OUTLINE:
				setOutline(OUTLINE_EDEFAULT);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__FONT_COLOR:
				setFontColor(FONT_COLOR_EDEFAULT);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__FONT_SIZE:
				setFontSize(FONT_SIZE_EDEFAULT);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__LINE_WIDTH:
				setLineWidth(LINE_WIDTH_EDEFAULT);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__PRIMARY_LABEL_VISIBLE:
				setPrimaryLabelVisible(PRIMARY_LABEL_VISIBLE_EDEFAULT);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__IMAGE:
				setImage(IMAGE_EDEFAULT);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__SHOW_AS_IMAGE:
				setShowAsImage(SHOW_AS_IMAGE_EDEFAULT);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__CONTENT_FILTERS:
				setContentFilters((ContentFilters)null);
				return;
			case DiagramPackage.DIAGRAM_ELEMENT__BO_DATA:
				setBoData(BO_DATA_EDEFAULT);
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
			case DiagramPackage.DIAGRAM_ELEMENT__UUID:
				return UUID_EDEFAULT == null ? uuid != null : !UUID_EDEFAULT.equals(uuid);
			case DiagramPackage.DIAGRAM_ELEMENT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
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
			case DiagramPackage.DIAGRAM_ELEMENT__BACKGROUND:
				return BACKGROUND_EDEFAULT == null ? background != null : !BACKGROUND_EDEFAULT.equals(background);
			case DiagramPackage.DIAGRAM_ELEMENT__OUTLINE:
				return OUTLINE_EDEFAULT == null ? outline != null : !OUTLINE_EDEFAULT.equals(outline);
			case DiagramPackage.DIAGRAM_ELEMENT__FONT_COLOR:
				return FONT_COLOR_EDEFAULT == null ? fontColor != null : !FONT_COLOR_EDEFAULT.equals(fontColor);
			case DiagramPackage.DIAGRAM_ELEMENT__FONT_SIZE:
				return FONT_SIZE_EDEFAULT == null ? fontSize != null : !FONT_SIZE_EDEFAULT.equals(fontSize);
			case DiagramPackage.DIAGRAM_ELEMENT__LINE_WIDTH:
				return LINE_WIDTH_EDEFAULT == null ? lineWidth != null : !LINE_WIDTH_EDEFAULT.equals(lineWidth);
			case DiagramPackage.DIAGRAM_ELEMENT__PRIMARY_LABEL_VISIBLE:
				return PRIMARY_LABEL_VISIBLE_EDEFAULT == null ? primaryLabelVisible != null : !PRIMARY_LABEL_VISIBLE_EDEFAULT.equals(primaryLabelVisible);
			case DiagramPackage.DIAGRAM_ELEMENT__IMAGE:
				return IMAGE_EDEFAULT == null ? image != null : !IMAGE_EDEFAULT.equals(image);
			case DiagramPackage.DIAGRAM_ELEMENT__SHOW_AS_IMAGE:
				return SHOW_AS_IMAGE_EDEFAULT == null ? showAsImage != null : !SHOW_AS_IMAGE_EDEFAULT.equals(showAsImage);
			case DiagramPackage.DIAGRAM_ELEMENT__CONTENT_FILTERS:
				return contentFilters != null;
			case DiagramPackage.DIAGRAM_ELEMENT__BO_DATA:
				return BO_DATA_EDEFAULT == null ? boData != null : !BO_DATA_EDEFAULT.equals(boData);
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
		result.append(" (uuid: ");
		result.append(uuid);
		result.append(", id: ");
		result.append(id);
		result.append(", manual: ");
		result.append(manual);
		result.append(", autoContentsFilter: ");
		result.append(autoContentsFilter);
		result.append(", dockArea: ");
		result.append(dockArea);
		result.append(", background: ");
		result.append(background);
		result.append(", outline: ");
		result.append(outline);
		result.append(", fontColor: ");
		result.append(fontColor);
		result.append(", fontSize: ");
		result.append(fontSize);
		result.append(", lineWidth: ");
		result.append(lineWidth);
		result.append(", primaryLabelVisible: ");
		result.append(primaryLabelVisible);
		result.append(", image: ");
		result.append(image);
		result.append(", showAsImage: ");
		result.append(showAsImage);
		result.append(", boData: ");
		result.append(boData);
		result.append(')');
		return result.toString();
	}

} // DiagramElement
