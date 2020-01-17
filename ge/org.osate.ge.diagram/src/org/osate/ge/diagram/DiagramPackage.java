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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.osate.ge.diagram.DiagramFactory
 * @model kind="package"
 * @generated
 */
public class DiagramPackage extends EPackageImpl {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "diagram";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "http://osate.org/diagram";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "diagram";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final DiagramPackage eINSTANCE = org.osate.ge.diagram.DiagramPackage.init();

	/**
	 * The meta object id for the '{@link org.osate.ge.diagram.DiagramNode <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.ge.diagram.DiagramNode
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramNode()
	 * @generated
	 */
	public static final int DIAGRAM_NODE = 1;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_NODE__ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_NODE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.ge.diagram.Diagram <em>Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.ge.diagram.Diagram
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagram()
	 * @generated
	 */
	public static final int DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM__ELEMENT = DIAGRAM_NODE__ELEMENT;

	/**
	 * The feature id for the '<em><b>Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM__CONFIG = DIAGRAM_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Format Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM__FORMAT_VERSION = DIAGRAM_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_FEATURE_COUNT = DIAGRAM_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_OPERATION_COUNT = DIAGRAM_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.ge.diagram.DiagramElement <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.ge.diagram.DiagramElement
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement()
	 * @generated
	 */
	public static final int DIAGRAM_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT__ELEMENT = DIAGRAM_NODE__ELEMENT;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT__UUID = DIAGRAM_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT__ID = DIAGRAM_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Bo</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT__BO = DIAGRAM_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Manual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT__MANUAL = DIAGRAM_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Auto Contents Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT__AUTO_CONTENTS_FILTER = DIAGRAM_NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT__POSITION = DIAGRAM_NODE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT__SIZE = DIAGRAM_NODE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Dock Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT__DOCK_AREA = DIAGRAM_NODE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Bendpoints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT__BENDPOINTS = DIAGRAM_NODE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Primary Label Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT__PRIMARY_LABEL_POSITION = DIAGRAM_NODE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Background</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT__BACKGROUND = DIAGRAM_NODE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Outline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT__OUTLINE = DIAGRAM_NODE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT__FONT_COLOR = DIAGRAM_NODE_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Font Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT__FONT_SIZE = DIAGRAM_NODE_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Line Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT__LINE_WIDTH = DIAGRAM_NODE_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Primary Label Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT__PRIMARY_LABEL_VISIBLE = DIAGRAM_NODE_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT__IMAGE = DIAGRAM_NODE_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Show As Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT__SHOW_AS_IMAGE = DIAGRAM_NODE_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Content Filters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT__CONTENT_FILTERS = DIAGRAM_NODE_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Bo Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT__BO_DATA = DIAGRAM_NODE_FEATURE_COUNT + 19;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT_FEATURE_COUNT = DIAGRAM_NODE_FEATURE_COUNT + 20;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_ELEMENT_OPERATION_COUNT = DIAGRAM_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.ge.diagram.Point <em>Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.ge.diagram.Point
	 * @see org.osate.ge.diagram.DiagramPackage#getPoint()
	 * @generated
	 */
	public static final int POINT = 3;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int POINT__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int POINT__Y = 1;

	/**
	 * The number of structural features of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int POINT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int POINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.ge.diagram.Dimension <em>Dimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.ge.diagram.Dimension
	 * @see org.osate.ge.diagram.DiagramPackage#getDimension()
	 * @generated
	 */
	public static final int DIMENSION = 4;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIMENSION__WIDTH = 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIMENSION__HEIGHT = 1;

	/**
	 * The number of structural features of the '<em>Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIMENSION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIMENSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.ge.diagram.BendpointList <em>Bendpoint List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.ge.diagram.BendpointList
	 * @see org.osate.ge.diagram.DiagramPackage#getBendpointList()
	 * @generated
	 */
	public static final int BENDPOINT_LIST = 5;

	/**
	 * The feature id for the '<em><b>Point</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BENDPOINT_LIST__POINT = 0;

	/**
	 * The number of structural features of the '<em>Bendpoint List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BENDPOINT_LIST_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Bendpoint List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BENDPOINT_LIST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.ge.diagram.AadlPropertiesSet <em>Aadl Properties Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.ge.diagram.AadlPropertiesSet
	 * @see org.osate.ge.diagram.DiagramPackage#getAadlPropertiesSet()
	 * @generated
	 */
	public static final int AADL_PROPERTIES_SET = 6;

	/**
	 * The feature id for the '<em><b>Property</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int AADL_PROPERTIES_SET__PROPERTY = 0;

	/**
	 * The number of structural features of the '<em>Aadl Properties Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int AADL_PROPERTIES_SET_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Aadl Properties Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int AADL_PROPERTIES_SET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.ge.diagram.Reference <em>Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.ge.diagram.Reference
	 * @see org.osate.ge.diagram.DiagramPackage#getReference()
	 * @generated
	 */
	public static final int REFERENCE = 10;

	/**
	 * The feature id for the '<em><b>Seg</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REFERENCE__SEG = 0;

	/**
	 * The number of structural features of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REFERENCE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.ge.diagram.CanonicalBusinessObjectReference <em>Canonical Business Object Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.ge.diagram.CanonicalBusinessObjectReference
	 * @see org.osate.ge.diagram.DiagramPackage#getCanonicalBusinessObjectReference()
	 * @generated
	 */
	public static final int CANONICAL_BUSINESS_OBJECT_REFERENCE = 7;

	/**
	 * The feature id for the '<em><b>Seg</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CANONICAL_BUSINESS_OBJECT_REFERENCE__SEG = REFERENCE__SEG;

	/**
	 * The number of structural features of the '<em>Canonical Business Object Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CANONICAL_BUSINESS_OBJECT_REFERENCE_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Canonical Business Object Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CANONICAL_BUSINESS_OBJECT_REFERENCE_OPERATION_COUNT = REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.ge.diagram.RelativeBusinessObjectReference <em>Relative Business Object Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.ge.diagram.RelativeBusinessObjectReference
	 * @see org.osate.ge.diagram.DiagramPackage#getRelativeBusinessObjectReference()
	 * @generated
	 */
	public static final int RELATIVE_BUSINESS_OBJECT_REFERENCE = 8;

	/**
	 * The feature id for the '<em><b>Seg</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RELATIVE_BUSINESS_OBJECT_REFERENCE__SEG = REFERENCE__SEG;

	/**
	 * The number of structural features of the '<em>Relative Business Object Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RELATIVE_BUSINESS_OBJECT_REFERENCE_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Relative Business Object Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RELATIVE_BUSINESS_OBJECT_REFERENCE_OPERATION_COUNT = REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.ge.diagram.DiagramConfiguration <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.ge.diagram.DiagramConfiguration
	 * @see org.osate.ge.diagram.DiagramPackage#getDiagramConfiguration()
	 * @generated
	 */
	public static final int DIAGRAM_CONFIGURATION = 9;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_CONFIGURATION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Enabled Aadl Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_CONFIGURATION__ENABLED_AADL_PROPERTIES = 1;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_CONFIGURATION__CONTEXT = 2;

	/**
	 * The feature id for the '<em><b>Connection Primary Labels Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_CONFIGURATION__CONNECTION_PRIMARY_LABELS_VISIBLE = 3;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_CONFIGURATION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.ge.diagram.ContentFilters <em>Content Filters</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.ge.diagram.ContentFilters
	 * @see org.osate.ge.diagram.DiagramPackage#getContentFilters()
	 * @generated
	 */
	public static final int CONTENT_FILTERS = 11;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONTENT_FILTERS__FILTER = 0;

	/**
	 * The number of structural features of the '<em>Content Filters</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONTENT_FILTERS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Content Filters</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONTENT_FILTERS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '<em>Color</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.osate.ge.diagram.DiagramPackage#getColor()
	 * @generated
	 */
	public static final int COLOR = 12;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagramNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagramElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dimensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bendpointListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aadlPropertiesSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass canonicalBusinessObjectReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relativeBusinessObjectReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagramConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contentFiltersEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType colorEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.osate.ge.diagram.DiagramPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DiagramPackage() {
		super(eNS_URI, DiagramFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link DiagramPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DiagramPackage init() {
		if (isInited) return (DiagramPackage)EPackage.Registry.INSTANCE.getEPackage(DiagramPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDiagramPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DiagramPackage theDiagramPackage = registeredDiagramPackage instanceof DiagramPackage ? (DiagramPackage)registeredDiagramPackage : new DiagramPackage();

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDiagramPackage.createPackageContents();

		// Initialize created meta-data
		theDiagramPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDiagramPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DiagramPackage.eNS_URI, theDiagramPackage);
		return theDiagramPackage;
	}


	/**
	 * Returns the meta object for class '{@link org.osate.ge.diagram.Diagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram</em>'.
	 * @see org.osate.ge.diagram.Diagram
	 * @generated
	 */
	public EClass getDiagram() {
		return diagramEClass;
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.ge.diagram.Diagram#getConfig <em>Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Config</em>'.
	 * @see org.osate.ge.diagram.Diagram#getConfig()
	 * @see #getDiagram()
	 * @generated
	 */
	public EReference getDiagram_Config() {
		return (EReference)diagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.osate.ge.diagram.Diagram#getFormatVersion <em>Format Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format Version</em>'.
	 * @see org.osate.ge.diagram.Diagram#getFormatVersion()
	 * @see #getDiagram()
	 * @generated
	 */
	public EAttribute getDiagram_FormatVersion() {
		return (EAttribute)diagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link org.osate.ge.diagram.DiagramNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.osate.ge.diagram.DiagramNode
	 * @generated
	 */
	public EClass getDiagramNode() {
		return diagramNodeEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.ge.diagram.DiagramNode#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element</em>'.
	 * @see org.osate.ge.diagram.DiagramNode#getElement()
	 * @see #getDiagramNode()
	 * @generated
	 */
	public EReference getDiagramNode_Element() {
		return (EReference)diagramNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.osate.ge.diagram.DiagramElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.osate.ge.diagram.DiagramElement
	 * @generated
	 */
	public EClass getDiagramElement() {
		return diagramElementEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.osate.ge.diagram.DiagramElement#getUuid <em>Uuid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uuid</em>'.
	 * @see org.osate.ge.diagram.DiagramElement#getUuid()
	 * @see #getDiagramElement()
	 * @generated
	 */
	public EAttribute getDiagramElement_Uuid() {
		return (EAttribute)diagramElementEClass.getEStructuralFeatures().get(0);
	}


	/**
	 * Returns the meta object for the attribute '{@link org.osate.ge.diagram.DiagramElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.osate.ge.diagram.DiagramElement#getId()
	 * @see #getDiagramElement()
	 * @generated
	 */
	public EAttribute getDiagramElement_Id() {
		return (EAttribute)diagramElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.ge.diagram.DiagramElement#getBo <em>Bo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bo</em>'.
	 * @see org.osate.ge.diagram.DiagramElement#getBo()
	 * @see #getDiagramElement()
	 * @generated
	 */
	public EReference getDiagramElement_Bo() {
		return (EReference)diagramElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.osate.ge.diagram.DiagramElement#isManual <em>Manual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Manual</em>'.
	 * @see org.osate.ge.diagram.DiagramElement#isManual()
	 * @see #getDiagramElement()
	 * @generated
	 */
	public EAttribute getDiagramElement_Manual() {
		return (EAttribute)diagramElementEClass.getEStructuralFeatures().get(3);
	}


	/**
	 * Returns the meta object for the attribute '{@link org.osate.ge.diagram.DiagramElement#getAutoContentsFilter <em>Auto Contents Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auto Contents Filter</em>'.
	 * @see org.osate.ge.diagram.DiagramElement#getAutoContentsFilter()
	 * @see #getDiagramElement()
	 * @generated
	 */
	public EAttribute getDiagramElement_AutoContentsFilter() {
		return (EAttribute)diagramElementEClass.getEStructuralFeatures().get(4);
	}


	/**
	 * Returns the meta object for the containment reference '{@link org.osate.ge.diagram.DiagramElement#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Position</em>'.
	 * @see org.osate.ge.diagram.DiagramElement#getPosition()
	 * @see #getDiagramElement()
	 * @generated
	 */
	public EReference getDiagramElement_Position() {
		return (EReference)diagramElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.ge.diagram.DiagramElement#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Size</em>'.
	 * @see org.osate.ge.diagram.DiagramElement#getSize()
	 * @see #getDiagramElement()
	 * @generated
	 */
	public EReference getDiagramElement_Size() {
		return (EReference)diagramElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.osate.ge.diagram.DiagramElement#getDockArea <em>Dock Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dock Area</em>'.
	 * @see org.osate.ge.diagram.DiagramElement#getDockArea()
	 * @see #getDiagramElement()
	 * @generated
	 */
	public EAttribute getDiagramElement_DockArea() {
		return (EAttribute)diagramElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.ge.diagram.DiagramElement#getBendpoints <em>Bendpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bendpoints</em>'.
	 * @see org.osate.ge.diagram.DiagramElement#getBendpoints()
	 * @see #getDiagramElement()
	 * @generated
	 */
	public EReference getDiagramElement_Bendpoints() {
		return (EReference)diagramElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.ge.diagram.DiagramElement#getPrimaryLabelPosition <em>Primary Label Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Primary Label Position</em>'.
	 * @see org.osate.ge.diagram.DiagramElement#getPrimaryLabelPosition()
	 * @see #getDiagramElement()
	 * @generated
	 */
	public EReference getDiagramElement_PrimaryLabelPosition() {
		return (EReference)diagramElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.osate.ge.diagram.DiagramElement#getBackground <em>Background</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Background</em>'.
	 * @see org.osate.ge.diagram.DiagramElement#getBackground()
	 * @see #getDiagramElement()
	 * @generated
	 */
	public EAttribute getDiagramElement_Background() {
		return (EAttribute)diagramElementEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.osate.ge.diagram.DiagramElement#getOutline <em>Outline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Outline</em>'.
	 * @see org.osate.ge.diagram.DiagramElement#getOutline()
	 * @see #getDiagramElement()
	 * @generated
	 */
	public EAttribute getDiagramElement_Outline() {
		return (EAttribute)diagramElementEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.osate.ge.diagram.DiagramElement#getFontColor <em>Font Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font Color</em>'.
	 * @see org.osate.ge.diagram.DiagramElement#getFontColor()
	 * @see #getDiagramElement()
	 * @generated
	 */
	public EAttribute getDiagramElement_FontColor() {
		return (EAttribute)diagramElementEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.osate.ge.diagram.DiagramElement#getFontSize <em>Font Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font Size</em>'.
	 * @see org.osate.ge.diagram.DiagramElement#getFontSize()
	 * @see #getDiagramElement()
	 * @generated
	 */
	public EAttribute getDiagramElement_FontSize() {
		return (EAttribute)diagramElementEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.osate.ge.diagram.DiagramElement#getLineWidth <em>Line Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Width</em>'.
	 * @see org.osate.ge.diagram.DiagramElement#getLineWidth()
	 * @see #getDiagramElement()
	 * @generated
	 */
	public EAttribute getDiagramElement_LineWidth() {
		return (EAttribute)diagramElementEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.osate.ge.diagram.DiagramElement#getPrimaryLabelVisible <em>Primary Label Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primary Label Visible</em>'.
	 * @see org.osate.ge.diagram.DiagramElement#getPrimaryLabelVisible()
	 * @see #getDiagramElement()
	 * @generated
	 */
	public EAttribute getDiagramElement_PrimaryLabelVisible() {
		return (EAttribute)diagramElementEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.osate.ge.diagram.DiagramElement#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see org.osate.ge.diagram.DiagramElement#getImage()
	 * @see #getDiagramElement()
	 * @generated
	 */
	public EAttribute getDiagramElement_Image() {
		return (EAttribute)diagramElementEClass.getEStructuralFeatures().get(16);
	}


	/**
	 * Returns the meta object for the attribute '{@link org.osate.ge.diagram.DiagramElement#getShowAsImage <em>Show As Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Show As Image</em>'.
	 * @see org.osate.ge.diagram.DiagramElement#getShowAsImage()
	 * @see #getDiagramElement()
	 * @generated
	 */
	public EAttribute getDiagramElement_ShowAsImage() {
		return (EAttribute)diagramElementEClass.getEStructuralFeatures().get(17);
	}


	/**
	 * Returns the meta object for the containment reference '{@link org.osate.ge.diagram.DiagramElement#getContentFilters <em>Content Filters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content Filters</em>'.
	 * @see org.osate.ge.diagram.DiagramElement#getContentFilters()
	 * @see #getDiagramElement()
	 * @generated
	 */
	public EReference getDiagramElement_ContentFilters() {
		return (EReference)diagramElementEClass.getEStructuralFeatures().get(18);
	}


	/**
	 * Returns the meta object for the attribute '{@link org.osate.ge.diagram.DiagramElement#getBoData <em>Bo Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bo Data</em>'.
	 * @see org.osate.ge.diagram.DiagramElement#getBoData()
	 * @see #getDiagramElement()
	 * @generated
	 */
	public EAttribute getDiagramElement_BoData() {
		return (EAttribute)diagramElementEClass.getEStructuralFeatures().get(19);
	}


	/**
	 * Returns the meta object for class '{@link org.osate.ge.diagram.Point <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point</em>'.
	 * @see org.osate.ge.diagram.Point
	 * @generated
	 */
	public EClass getPoint() {
		return pointEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.osate.ge.diagram.Point#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.osate.ge.diagram.Point#getX()
	 * @see #getPoint()
	 * @generated
	 */
	public EAttribute getPoint_X() {
		return (EAttribute)pointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.osate.ge.diagram.Point#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.osate.ge.diagram.Point#getY()
	 * @see #getPoint()
	 * @generated
	 */
	public EAttribute getPoint_Y() {
		return (EAttribute)pointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link org.osate.ge.diagram.Dimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dimension</em>'.
	 * @see org.osate.ge.diagram.Dimension
	 * @generated
	 */
	public EClass getDimension() {
		return dimensionEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.osate.ge.diagram.Dimension#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.osate.ge.diagram.Dimension#getWidth()
	 * @see #getDimension()
	 * @generated
	 */
	public EAttribute getDimension_Width() {
		return (EAttribute)dimensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.osate.ge.diagram.Dimension#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.osate.ge.diagram.Dimension#getHeight()
	 * @see #getDimension()
	 * @generated
	 */
	public EAttribute getDimension_Height() {
		return (EAttribute)dimensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link org.osate.ge.diagram.BendpointList <em>Bendpoint List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bendpoint List</em>'.
	 * @see org.osate.ge.diagram.BendpointList
	 * @generated
	 */
	public EClass getBendpointList() {
		return bendpointListEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.ge.diagram.BendpointList#getPoint <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Point</em>'.
	 * @see org.osate.ge.diagram.BendpointList#getPoint()
	 * @see #getBendpointList()
	 * @generated
	 */
	public EReference getBendpointList_Point() {
		return (EReference)bendpointListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.osate.ge.diagram.AadlPropertiesSet <em>Aadl Properties Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aadl Properties Set</em>'.
	 * @see org.osate.ge.diagram.AadlPropertiesSet
	 * @generated
	 */
	public EClass getAadlPropertiesSet() {
		return aadlPropertiesSetEClass;
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.osate.ge.diagram.AadlPropertiesSet#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Property</em>'.
	 * @see org.osate.ge.diagram.AadlPropertiesSet#getProperty()
	 * @see #getAadlPropertiesSet()
	 * @generated
	 */
	public EAttribute getAadlPropertiesSet_Property() {
		return (EAttribute)aadlPropertiesSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.osate.ge.diagram.CanonicalBusinessObjectReference <em>Canonical Business Object Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Canonical Business Object Reference</em>'.
	 * @see org.osate.ge.diagram.CanonicalBusinessObjectReference
	 * @generated
	 */
	public EClass getCanonicalBusinessObjectReference() {
		return canonicalBusinessObjectReferenceEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.osate.ge.diagram.RelativeBusinessObjectReference <em>Relative Business Object Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relative Business Object Reference</em>'.
	 * @see org.osate.ge.diagram.RelativeBusinessObjectReference
	 * @generated
	 */
	public EClass getRelativeBusinessObjectReference() {
		return relativeBusinessObjectReferenceEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.osate.ge.diagram.DiagramConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.osate.ge.diagram.DiagramConfiguration
	 * @generated
	 */
	public EClass getDiagramConfiguration() {
		return diagramConfigurationEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.osate.ge.diagram.DiagramConfiguration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.osate.ge.diagram.DiagramConfiguration#getType()
	 * @see #getDiagramConfiguration()
	 * @generated
	 */
	public EAttribute getDiagramConfiguration_Type() {
		return (EAttribute)diagramConfigurationEClass.getEStructuralFeatures().get(0);
	}


	/**
	 * Returns the meta object for the containment reference '{@link org.osate.ge.diagram.DiagramConfiguration#getEnabledAadlProperties <em>Enabled Aadl Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Enabled Aadl Properties</em>'.
	 * @see org.osate.ge.diagram.DiagramConfiguration#getEnabledAadlProperties()
	 * @see #getDiagramConfiguration()
	 * @generated
	 */
	public EReference getDiagramConfiguration_EnabledAadlProperties() {
		return (EReference)diagramConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.ge.diagram.DiagramConfiguration#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context</em>'.
	 * @see org.osate.ge.diagram.DiagramConfiguration#getContext()
	 * @see #getDiagramConfiguration()
	 * @generated
	 */
	public EReference getDiagramConfiguration_Context() {
		return (EReference)diagramConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.osate.ge.diagram.DiagramConfiguration#getConnectionPrimaryLabelsVisible <em>Connection Primary Labels Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection Primary Labels Visible</em>'.
	 * @see org.osate.ge.diagram.DiagramConfiguration#getConnectionPrimaryLabelsVisible()
	 * @see #getDiagramConfiguration()
	 * @generated
	 */
	public EAttribute getDiagramConfiguration_ConnectionPrimaryLabelsVisible() {
		return (EAttribute)diagramConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for class '{@link org.osate.ge.diagram.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see org.osate.ge.diagram.Reference
	 * @generated
	 */
	public EClass getReference() {
		return referenceEClass;
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.osate.ge.diagram.Reference#getSeg <em>Seg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Seg</em>'.
	 * @see org.osate.ge.diagram.Reference#getSeg()
	 * @see #getReference()
	 * @generated
	 */
	public EAttribute getReference_Seg() {
		return (EAttribute)referenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.osate.ge.diagram.ContentFilters <em>Content Filters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Content Filters</em>'.
	 * @see org.osate.ge.diagram.ContentFilters
	 * @generated
	 */
	public EClass getContentFilters() {
		return contentFiltersEClass;
	}


	/**
	 * Returns the meta object for the attribute list '{@link org.osate.ge.diagram.ContentFilters#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Filter</em>'.
	 * @see org.osate.ge.diagram.ContentFilters#getFilter()
	 * @see #getContentFilters()
	 * @generated
	 */
	public EAttribute getContentFilters_Filter() {
		return (EAttribute)contentFiltersEClass.getEStructuralFeatures().get(0);
	}


	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Color</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	public EDataType getColor() {
		return colorEDataType;
	}

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public DiagramFactory getDiagramFactory() {
		return (DiagramFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		diagramEClass = createEClass(DIAGRAM);
		createEReference(diagramEClass, DIAGRAM__CONFIG);
		createEAttribute(diagramEClass, DIAGRAM__FORMAT_VERSION);

		diagramNodeEClass = createEClass(DIAGRAM_NODE);
		createEReference(diagramNodeEClass, DIAGRAM_NODE__ELEMENT);

		diagramElementEClass = createEClass(DIAGRAM_ELEMENT);
		createEAttribute(diagramElementEClass, DIAGRAM_ELEMENT__UUID);
		createEAttribute(diagramElementEClass, DIAGRAM_ELEMENT__ID);
		createEReference(diagramElementEClass, DIAGRAM_ELEMENT__BO);
		createEAttribute(diagramElementEClass, DIAGRAM_ELEMENT__MANUAL);
		createEAttribute(diagramElementEClass, DIAGRAM_ELEMENT__AUTO_CONTENTS_FILTER);
		createEReference(diagramElementEClass, DIAGRAM_ELEMENT__POSITION);
		createEReference(diagramElementEClass, DIAGRAM_ELEMENT__SIZE);
		createEAttribute(diagramElementEClass, DIAGRAM_ELEMENT__DOCK_AREA);
		createEReference(diagramElementEClass, DIAGRAM_ELEMENT__BENDPOINTS);
		createEReference(diagramElementEClass, DIAGRAM_ELEMENT__PRIMARY_LABEL_POSITION);
		createEAttribute(diagramElementEClass, DIAGRAM_ELEMENT__BACKGROUND);
		createEAttribute(diagramElementEClass, DIAGRAM_ELEMENT__OUTLINE);
		createEAttribute(diagramElementEClass, DIAGRAM_ELEMENT__FONT_COLOR);
		createEAttribute(diagramElementEClass, DIAGRAM_ELEMENT__FONT_SIZE);
		createEAttribute(diagramElementEClass, DIAGRAM_ELEMENT__LINE_WIDTH);
		createEAttribute(diagramElementEClass, DIAGRAM_ELEMENT__PRIMARY_LABEL_VISIBLE);
		createEAttribute(diagramElementEClass, DIAGRAM_ELEMENT__IMAGE);
		createEAttribute(diagramElementEClass, DIAGRAM_ELEMENT__SHOW_AS_IMAGE);
		createEReference(diagramElementEClass, DIAGRAM_ELEMENT__CONTENT_FILTERS);
		createEAttribute(diagramElementEClass, DIAGRAM_ELEMENT__BO_DATA);

		pointEClass = createEClass(POINT);
		createEAttribute(pointEClass, POINT__X);
		createEAttribute(pointEClass, POINT__Y);

		dimensionEClass = createEClass(DIMENSION);
		createEAttribute(dimensionEClass, DIMENSION__WIDTH);
		createEAttribute(dimensionEClass, DIMENSION__HEIGHT);

		bendpointListEClass = createEClass(BENDPOINT_LIST);
		createEReference(bendpointListEClass, BENDPOINT_LIST__POINT);

		aadlPropertiesSetEClass = createEClass(AADL_PROPERTIES_SET);
		createEAttribute(aadlPropertiesSetEClass, AADL_PROPERTIES_SET__PROPERTY);

		canonicalBusinessObjectReferenceEClass = createEClass(CANONICAL_BUSINESS_OBJECT_REFERENCE);

		relativeBusinessObjectReferenceEClass = createEClass(RELATIVE_BUSINESS_OBJECT_REFERENCE);

		diagramConfigurationEClass = createEClass(DIAGRAM_CONFIGURATION);
		createEAttribute(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__TYPE);
		createEReference(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__ENABLED_AADL_PROPERTIES);
		createEReference(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__CONTEXT);
		createEAttribute(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__CONNECTION_PRIMARY_LABELS_VISIBLE);

		referenceEClass = createEClass(REFERENCE);
		createEAttribute(referenceEClass, REFERENCE__SEG);

		contentFiltersEClass = createEClass(CONTENT_FILTERS);
		createEAttribute(contentFiltersEClass, CONTENT_FILTERS__FILTER);

		// Create data types
		colorEDataType = createEDataType(COLOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		diagramEClass.getESuperTypes().add(this.getDiagramNode());
		diagramElementEClass.getESuperTypes().add(this.getDiagramNode());
		canonicalBusinessObjectReferenceEClass.getESuperTypes().add(this.getReference());
		relativeBusinessObjectReferenceEClass.getESuperTypes().add(this.getReference());

		// Initialize classes, features, and operations; add parameters
		initEClass(diagramEClass, Diagram.class, "Diagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDiagram_Config(), this.getDiagramConfiguration(), null, "config", null, 0, 1, Diagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagram_FormatVersion(), theXMLTypePackage.getInt(), "formatVersion", "0", 0, 1, Diagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(diagramNodeEClass, DiagramNode.class, "DiagramNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDiagramNode_Element(), this.getDiagramElement(), null, "element", null, 0, -1, DiagramNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(diagramElementEClass, DiagramElement.class, "DiagramElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDiagramElement_Uuid(), theXMLTypePackage.getString(), "uuid", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagramElement_Id(), theXMLTypePackage.getLongObject(), "id", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagramElement_Bo(), this.getRelativeBusinessObjectReference(), null, "bo", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagramElement_Manual(), theXMLTypePackage.getBoolean(), "manual", "false", 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagramElement_AutoContentsFilter(), theXMLTypePackage.getString(), "autoContentsFilter", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagramElement_Position(), this.getPoint(), null, "position", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagramElement_Size(), this.getDimension(), null, "size", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagramElement_DockArea(), theXMLTypePackage.getString(), "dockArea", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagramElement_Bendpoints(), this.getBendpointList(), null, "bendpoints", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagramElement_PrimaryLabelPosition(), this.getPoint(), null, "primaryLabelPosition", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagramElement_Background(), this.getColor(), "background", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagramElement_Outline(), this.getColor(), "outline", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagramElement_FontColor(), this.getColor(), "fontColor", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagramElement_FontSize(), theXMLTypePackage.getDoubleObject(), "fontSize", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagramElement_LineWidth(), theXMLTypePackage.getDoubleObject(), "lineWidth", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagramElement_PrimaryLabelVisible(), ecorePackage.getEBooleanObject(), "primaryLabelVisible", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagramElement_Image(), theXMLTypePackage.getString(), "image", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagramElement_ShowAsImage(), ecorePackage.getEBooleanObject(), "showAsImage", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagramElement_ContentFilters(), this.getContentFilters(), null, "contentFilters", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagramElement_BoData(), theXMLTypePackage.getString(), "boData", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pointEClass, Point.class, "Point", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPoint_X(), theXMLTypePackage.getDouble(), "x", null, 0, 1, Point.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPoint_Y(), theXMLTypePackage.getDouble(), "y", null, 0, 1, Point.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dimensionEClass, Dimension.class, "Dimension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDimension_Width(), theXMLTypePackage.getDouble(), "width", null, 0, 1, Dimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDimension_Height(), theXMLTypePackage.getDouble(), "height", null, 0, 1, Dimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bendpointListEClass, BendpointList.class, "BendpointList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBendpointList_Point(), this.getPoint(), null, "point", null, 0, -1, BendpointList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aadlPropertiesSetEClass, AadlPropertiesSet.class, "AadlPropertiesSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAadlPropertiesSet_Property(), theXMLTypePackage.getString(), "property", null, 0, -1, AadlPropertiesSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(canonicalBusinessObjectReferenceEClass, CanonicalBusinessObjectReference.class, "CanonicalBusinessObjectReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(relativeBusinessObjectReferenceEClass, RelativeBusinessObjectReference.class, "RelativeBusinessObjectReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(diagramConfigurationEClass, DiagramConfiguration.class, "DiagramConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDiagramConfiguration_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagramConfiguration_EnabledAadlProperties(), this.getAadlPropertiesSet(), null, "enabledAadlProperties", null, 0, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagramConfiguration_Context(), this.getCanonicalBusinessObjectReference(), null, "context", null, 0, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagramConfiguration_ConnectionPrimaryLabelsVisible(), ecorePackage.getEBooleanObject(), "connectionPrimaryLabelsVisible", null, 0, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceEClass, Reference.class, "Reference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReference_Seg(), theXMLTypePackage.getString(), "seg", null, 0, -1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contentFiltersEClass, ContentFilters.class, "ContentFilters", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContentFilters_Filter(), theXMLTypePackage.getString(), "filter", null, 0, -1, ContentFilters.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize data types
		initEDataType(colorEDataType, String.class, "Color", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public interface Literals {
		/**
		 * The meta object literal for the '{@link org.osate.ge.diagram.Diagram <em>Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.ge.diagram.Diagram
		 * @see org.osate.ge.diagram.DiagramPackage#getDiagram()
		 * @generated
		 */
		public static final EClass DIAGRAM = eINSTANCE.getDiagram();

		/**
		 * The meta object literal for the '<em><b>Config</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference DIAGRAM__CONFIG = eINSTANCE.getDiagram_Config();

		/**
		 * The meta object literal for the '<em><b>Format Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute DIAGRAM__FORMAT_VERSION = eINSTANCE.getDiagram_FormatVersion();

		/**
		 * The meta object literal for the '{@link org.osate.ge.diagram.DiagramNode <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.ge.diagram.DiagramNode
		 * @see org.osate.ge.diagram.DiagramPackage#getDiagramNode()
		 * @generated
		 */
		public static final EClass DIAGRAM_NODE = eINSTANCE.getDiagramNode();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference DIAGRAM_NODE__ELEMENT = eINSTANCE.getDiagramNode_Element();

		/**
		 * The meta object literal for the '{@link org.osate.ge.diagram.DiagramElement <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.ge.diagram.DiagramElement
		 * @see org.osate.ge.diagram.DiagramPackage#getDiagramElement()
		 * @generated
		 */
		public static final EClass DIAGRAM_ELEMENT = eINSTANCE.getDiagramElement();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute DIAGRAM_ELEMENT__UUID = eINSTANCE.getDiagramElement_Uuid();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute DIAGRAM_ELEMENT__ID = eINSTANCE.getDiagramElement_Id();

		/**
		 * The meta object literal for the '<em><b>Bo</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference DIAGRAM_ELEMENT__BO = eINSTANCE.getDiagramElement_Bo();

		/**
		 * The meta object literal for the '<em><b>Manual</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute DIAGRAM_ELEMENT__MANUAL = eINSTANCE.getDiagramElement_Manual();

		/**
		 * The meta object literal for the '<em><b>Auto Contents Filter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute DIAGRAM_ELEMENT__AUTO_CONTENTS_FILTER = eINSTANCE.getDiagramElement_AutoContentsFilter();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference DIAGRAM_ELEMENT__POSITION = eINSTANCE.getDiagramElement_Position();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference DIAGRAM_ELEMENT__SIZE = eINSTANCE.getDiagramElement_Size();

		/**
		 * The meta object literal for the '<em><b>Dock Area</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute DIAGRAM_ELEMENT__DOCK_AREA = eINSTANCE.getDiagramElement_DockArea();

		/**
		 * The meta object literal for the '<em><b>Bendpoints</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference DIAGRAM_ELEMENT__BENDPOINTS = eINSTANCE.getDiagramElement_Bendpoints();

		/**
		 * The meta object literal for the '<em><b>Primary Label Position</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference DIAGRAM_ELEMENT__PRIMARY_LABEL_POSITION = eINSTANCE.getDiagramElement_PrimaryLabelPosition();

		/**
		 * The meta object literal for the '<em><b>Background</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute DIAGRAM_ELEMENT__BACKGROUND = eINSTANCE.getDiagramElement_Background();

		/**
		 * The meta object literal for the '<em><b>Outline</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute DIAGRAM_ELEMENT__OUTLINE = eINSTANCE.getDiagramElement_Outline();

		/**
		 * The meta object literal for the '<em><b>Font Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute DIAGRAM_ELEMENT__FONT_COLOR = eINSTANCE.getDiagramElement_FontColor();

		/**
		 * The meta object literal for the '<em><b>Font Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute DIAGRAM_ELEMENT__FONT_SIZE = eINSTANCE.getDiagramElement_FontSize();

		/**
		 * The meta object literal for the '<em><b>Line Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute DIAGRAM_ELEMENT__LINE_WIDTH = eINSTANCE.getDiagramElement_LineWidth();

		/**
		 * The meta object literal for the '<em><b>Primary Label Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute DIAGRAM_ELEMENT__PRIMARY_LABEL_VISIBLE = eINSTANCE.getDiagramElement_PrimaryLabelVisible();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute DIAGRAM_ELEMENT__IMAGE = eINSTANCE.getDiagramElement_Image();

		/**
		 * The meta object literal for the '<em><b>Show As Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute DIAGRAM_ELEMENT__SHOW_AS_IMAGE = eINSTANCE.getDiagramElement_ShowAsImage();

		/**
		 * The meta object literal for the '<em><b>Content Filters</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference DIAGRAM_ELEMENT__CONTENT_FILTERS = eINSTANCE.getDiagramElement_ContentFilters();

		/**
		 * The meta object literal for the '<em><b>Bo Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute DIAGRAM_ELEMENT__BO_DATA = eINSTANCE.getDiagramElement_BoData();

		/**
		 * The meta object literal for the '{@link org.osate.ge.diagram.Point <em>Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.ge.diagram.Point
		 * @see org.osate.ge.diagram.DiagramPackage#getPoint()
		 * @generated
		 */
		public static final EClass POINT = eINSTANCE.getPoint();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute POINT__X = eINSTANCE.getPoint_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute POINT__Y = eINSTANCE.getPoint_Y();

		/**
		 * The meta object literal for the '{@link org.osate.ge.diagram.Dimension <em>Dimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.ge.diagram.Dimension
		 * @see org.osate.ge.diagram.DiagramPackage#getDimension()
		 * @generated
		 */
		public static final EClass DIMENSION = eINSTANCE.getDimension();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute DIMENSION__WIDTH = eINSTANCE.getDimension_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute DIMENSION__HEIGHT = eINSTANCE.getDimension_Height();

		/**
		 * The meta object literal for the '{@link org.osate.ge.diagram.BendpointList <em>Bendpoint List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.ge.diagram.BendpointList
		 * @see org.osate.ge.diagram.DiagramPackage#getBendpointList()
		 * @generated
		 */
		public static final EClass BENDPOINT_LIST = eINSTANCE.getBendpointList();

		/**
		 * The meta object literal for the '<em><b>Point</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference BENDPOINT_LIST__POINT = eINSTANCE.getBendpointList_Point();

		/**
		 * The meta object literal for the '{@link org.osate.ge.diagram.AadlPropertiesSet <em>Aadl Properties Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.ge.diagram.AadlPropertiesSet
		 * @see org.osate.ge.diagram.DiagramPackage#getAadlPropertiesSet()
		 * @generated
		 */
		public static final EClass AADL_PROPERTIES_SET = eINSTANCE.getAadlPropertiesSet();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute AADL_PROPERTIES_SET__PROPERTY = eINSTANCE.getAadlPropertiesSet_Property();

		/**
		 * The meta object literal for the '{@link org.osate.ge.diagram.CanonicalBusinessObjectReference <em>Canonical Business Object Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.ge.diagram.CanonicalBusinessObjectReference
		 * @see org.osate.ge.diagram.DiagramPackage#getCanonicalBusinessObjectReference()
		 * @generated
		 */
		public static final EClass CANONICAL_BUSINESS_OBJECT_REFERENCE = eINSTANCE.getCanonicalBusinessObjectReference();

		/**
		 * The meta object literal for the '{@link org.osate.ge.diagram.RelativeBusinessObjectReference <em>Relative Business Object Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.ge.diagram.RelativeBusinessObjectReference
		 * @see org.osate.ge.diagram.DiagramPackage#getRelativeBusinessObjectReference()
		 * @generated
		 */
		public static final EClass RELATIVE_BUSINESS_OBJECT_REFERENCE = eINSTANCE.getRelativeBusinessObjectReference();

		/**
		 * The meta object literal for the '{@link org.osate.ge.diagram.DiagramConfiguration <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.ge.diagram.DiagramConfiguration
		 * @see org.osate.ge.diagram.DiagramPackage#getDiagramConfiguration()
		 * @generated
		 */
		public static final EClass DIAGRAM_CONFIGURATION = eINSTANCE.getDiagramConfiguration();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute DIAGRAM_CONFIGURATION__TYPE = eINSTANCE.getDiagramConfiguration_Type();

		/**
		 * The meta object literal for the '<em><b>Enabled Aadl Properties</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference DIAGRAM_CONFIGURATION__ENABLED_AADL_PROPERTIES = eINSTANCE.getDiagramConfiguration_EnabledAadlProperties();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference DIAGRAM_CONFIGURATION__CONTEXT = eINSTANCE.getDiagramConfiguration_Context();

		/**
		 * The meta object literal for the '<em><b>Connection Primary Labels Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute DIAGRAM_CONFIGURATION__CONNECTION_PRIMARY_LABELS_VISIBLE = eINSTANCE.getDiagramConfiguration_ConnectionPrimaryLabelsVisible();

		/**
		 * The meta object literal for the '{@link org.osate.ge.diagram.Reference <em>Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.ge.diagram.Reference
		 * @see org.osate.ge.diagram.DiagramPackage#getReference()
		 * @generated
		 */
		public static final EClass REFERENCE = eINSTANCE.getReference();

		/**
		 * The meta object literal for the '<em><b>Seg</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute REFERENCE__SEG = eINSTANCE.getReference_Seg();

		/**
		 * The meta object literal for the '{@link org.osate.ge.diagram.ContentFilters <em>Content Filters</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.ge.diagram.ContentFilters
		 * @see org.osate.ge.diagram.DiagramPackage#getContentFilters()
		 * @generated
		 */
		public static final EClass CONTENT_FILTERS = eINSTANCE.getContentFilters();

		/**
		 * The meta object literal for the '<em><b>Filter</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute CONTENT_FILTERS__FILTER = eINSTANCE.getContentFilters_Filter();

		/**
		 * The meta object literal for the '<em>Color</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.osate.ge.diagram.DiagramPackage#getColor()
		 * @generated
		 */
		public static final EDataType COLOR = eINSTANCE.getColor();

	}

} //DiagramPackage
