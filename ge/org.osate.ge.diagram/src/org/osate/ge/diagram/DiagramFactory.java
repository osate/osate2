/**
 */
package org.osate.ge.diagram;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.ge.diagram.DiagramPackage
 * @generated
 */
public class DiagramFactory extends EFactoryImpl {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final DiagramFactory eINSTANCE = init();

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DiagramFactory init() {
		try {
			DiagramFactory theDiagramFactory = (DiagramFactory)EPackage.Registry.INSTANCE.getEFactory(DiagramPackage.eNS_URI);
			if (theDiagramFactory != null) {
				return theDiagramFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DiagramFactory();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramFactory() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DiagramPackage.DIAGRAM: return createDiagram();
			case DiagramPackage.DIAGRAM_NODE: return createDiagramNode();
			case DiagramPackage.DIAGRAM_ELEMENT: return createDiagramElement();
			case DiagramPackage.POINT: return createPoint();
			case DiagramPackage.DIMENSION: return createDimension();
			case DiagramPackage.BENDPOINT_LIST: return createBendpointList();
			case DiagramPackage.AADL_PROPERTIES_SET: return createAadlPropertiesSet();
			case DiagramPackage.CANONICAL_BUSINESS_OBJECT_REFERENCE: return createCanonicalBusinessObjectReference();
			case DiagramPackage.RELATIVE_BUSINESS_OBJECT_REFERENCE: return createRelativeBusinessObjectReference();
			case DiagramPackage.DIAGRAM_CONFIGURATION: return createDiagramConfiguration();
			case DiagramPackage.CONTENT_FILTERS: return createContentFilters();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DiagramPackage.COLOR:
				return createColorFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DiagramPackage.COLOR:
				return convertColorToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram createDiagram() {
		Diagram diagram = new Diagram();
		return diagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramNode createDiagramNode() {
		DiagramNode diagramNode = new DiagramNode();
		return diagramNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramElement createDiagramElement() {
		DiagramElement diagramElement = new DiagramElement();
		return diagramElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point createPoint() {
		Point point = new Point();
		return point;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dimension createDimension() {
		Dimension dimension = new Dimension();
		return dimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BendpointList createBendpointList() {
		BendpointList bendpointList = new BendpointList();
		return bendpointList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AadlPropertiesSet createAadlPropertiesSet() {
		AadlPropertiesSet aadlPropertiesSet = new AadlPropertiesSet();
		return aadlPropertiesSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CanonicalBusinessObjectReference createCanonicalBusinessObjectReference() {
		CanonicalBusinessObjectReference canonicalBusinessObjectReference = new CanonicalBusinessObjectReference();
		return canonicalBusinessObjectReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelativeBusinessObjectReference createRelativeBusinessObjectReference() {
		RelativeBusinessObjectReference relativeBusinessObjectReference = new RelativeBusinessObjectReference();
		return relativeBusinessObjectReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramConfiguration createDiagramConfiguration() {
		DiagramConfiguration diagramConfiguration = new DiagramConfiguration();
		return diagramConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContentFilters createContentFilters() {
		ContentFilters contentFilters = new ContentFilters();
		return contentFilters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createColorFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertColorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramPackage getDiagramPackage() {
		return (DiagramPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DiagramPackage getPackage() {
		return DiagramPackage.eINSTANCE;
	}

} //DiagramFactory
