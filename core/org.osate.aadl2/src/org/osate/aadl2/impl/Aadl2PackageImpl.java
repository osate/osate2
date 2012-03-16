/**
 * <copyright>
 * Copyright  2011 by Carnegie Mellon University, all rights reserved.
 * 
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 * 
 * NO WARRANTY
 * 
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
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
 */
package org.osate.aadl2.impl;

import java.io.IOException;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.uml2.uml.UMLPackage;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.util.Aadl2Validator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Aadl2PackageImpl extends EPackageImpl implements Aadl2Package {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected String packageFilename = "aadl2.ecore";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyAssociationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaclassReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyOwnerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namespaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generalizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directedRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annexSubclauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modalElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modeFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass prototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuralFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass refinableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass prototypeBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containedNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containmentPathElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modalPropertyValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behavioralFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayDimensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arraySizeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentImplementationReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subcomponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modeTransitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modeTransitionTriggerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass triggerPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directedFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureConnectionEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portConnectionEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processorPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureGroupConnectionEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureGroupTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groupExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass busAccessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass accessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass accessConnectionEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass busClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass busSubcomponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass busEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataAccessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterConnectionEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endToEndFlowElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataSubcomponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventDataPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subprogramAccessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass calledSubprogramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subprogramClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subprogramSubcomponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subprogramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subprogramGroupAccessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subprogramGroupClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subprogramGroupSubcomponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subprogramGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subcomponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentPrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modeBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractSubcomponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modalPathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowSegmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractConnectionEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implementationExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endToEndFlowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endToEndFlowSegmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractSubcomponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass accessConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureGroupConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processorSubprogramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annexLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultAnnexLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultAnnexSubclauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass publicPackageSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageRenameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aadlPackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass privatePackageSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentTypeRenameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureGroupTypeRenameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behavioredImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subprogramCallSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass busSubcomponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataSubcomponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deviceSubcomponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deviceSubcomponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deviceClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memorySubcomponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memorySubcomponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processSubcomponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processSubcomponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processorSubcomponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processorSubcomponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processorClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemSubcomponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemSubcomponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subprogramSubcomponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subprogramGroupSubcomponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threadSubcomponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threadEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threadSubcomponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threadClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threadGroupSubcomponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threadGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threadGroupSubcomponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threadGroupClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualBusSubcomponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualBusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vitualBusSubcomponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualBusClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualProcessorSubcomponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualProcessorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualProcessorSubcomponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractPrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualProcessorClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass busTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass busImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass busPrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataPrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deviceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deviceImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass devicePrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryPrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processorTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processPrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processorImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processorPrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subprogramTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subprogramImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subprogramPrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subprogramGroupTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subprogramGroupImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subprogramGroupPrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemPrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threadTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threadImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threadPrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threadGroupTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threadGroupImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threadGroupPrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualBusTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualBusImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualBusPrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualProcessorTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualProcessorImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualProcessorPrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentPrototypeBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentPrototypeActualEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureGroupPrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureGroupPrototypeBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureGroupPrototypeActualEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featurePrototypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featurePrototypeBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featurePrototypeActualEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass accessSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featurePrototypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processorCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subprogramCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicPropertyAssociationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyConstantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractNamedValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arraySizePropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numberValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rangeValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recordValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computedValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertySetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalNamespaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nonListTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aadlBooleanEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aadlStringEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aadlIntegerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numberTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aadlRealEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rangeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recordTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recordFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum directionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum portCategoryEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum flowKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum accessTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum accessCategoryEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum componentCategoryEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum connectionKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum elementNameKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum operationKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stringEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType booleanEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType integerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType realEDataType = null;

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
	 * @see org.osate.aadl2.Aadl2Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Aadl2PackageImpl() {
		super(eNS_URI, Aadl2Factory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Aadl2Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @generated
	 */
	public static Aadl2Package init() {
		if (isInited)
			return (Aadl2Package) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);

		// Obtain or create and register package
		Aadl2PackageImpl theAadl2Package = (Aadl2PackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Aadl2PackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new Aadl2PackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Load packages
		theAadl2Package.loadPackage();

		// Fix loaded packages
		theAadl2Package.fixPackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put(theAadl2Package, new EValidator.Descriptor() {
			public EValidator getEValidator() {
				return Aadl2Validator.INSTANCE;
			}
		});

		// Mark meta-data to indicate it can't be changed
		theAadl2Package.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Aadl2Package.eNS_URI, theAadl2Package);
		return theAadl2Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElement() {
		if (elementEClass == null) {
			elementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(0);
		}
		return elementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElement_OwnedElement() {
		return (EReference) getElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElement_OwnedComment() {
		return (EReference) getElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComment() {
		if (commentEClass == null) {
			commentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(1);
		}
		return commentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComment_Body() {
		return (EAttribute) getComment().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		if (typeEClass == null) {
			typeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers().get(4);
		}
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		if (namedElementEClass == null) {
			namedElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(5);
		}
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute) getNamedElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_QualifiedName() {
		return (EAttribute) getNamedElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedElement_OwnedPropertyAssociation() {
		return (EReference) getNamedElement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyAssociation() {
		if (propertyAssociationEClass == null) {
			propertyAssociationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(6);
		}
		return propertyAssociationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyAssociation_Property() {
		return (EReference) getPropertyAssociation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyAssociation_AppliesTo() {
		return (EReference) getPropertyAssociation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyAssociation_InBinding() {
		return (EReference) getPropertyAssociation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyAssociation_Append() {
		return (EAttribute) getPropertyAssociation().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyAssociation_Constant() {
		return (EAttribute) getPropertyAssociation().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyAssociation_OwnedValue() {
		return (EReference) getPropertyAssociation().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		if (propertyEClass == null) {
			propertyEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(7);
		}
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Inherit() {
		return (EAttribute) getProperty().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProperty_DefaultValue() {
		return (EReference) getProperty().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProperty_AppliesToMetaclass() {
		return (EReference) getProperty().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProperty_AppliesToClassifier() {
		return (EReference) getProperty().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProperty_AppliesTo() {
		return (EReference) getProperty().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_EmptyListDefault() {
		return (EAttribute) getProperty().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicProperty() {
		if (basicPropertyEClass == null) {
			basicPropertyEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(8);
		}
		return basicPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicProperty_PropertyType() {
		return (EReference) getBasicProperty().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicProperty_OwnedPropertyType() {
		return (EReference) getBasicProperty().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedElement() {
		if (typedElementEClass == null) {
			typedElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(9);
		}
		return typedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedElement_Type() {
		return (EReference) getTypedElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyType() {
		if (propertyTypeEClass == null) {
			propertyTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(10);
		}
		return propertyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyExpression() {
		if (propertyExpressionEClass == null) {
			propertyExpressionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(13);
		}
		return propertyExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetaclassReference() {
		if (metaclassReferenceEClass == null) {
			metaclassReferenceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(14);
		}
		return metaclassReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetaclassReference_AnnexName() {
		return (EAttribute) getMetaclassReference().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetaclassReference_MetaclassName() {
		return (EAttribute) getMetaclassReference().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyOwner() {
		if (propertyOwnerEClass == null) {
			propertyOwnerEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(15);
		}
		return propertyOwnerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifier() {
		if (classifierEClass == null) {
			classifierEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(16);
		}
		return classifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifier_ClassifierFeature() {
		return (EReference) getClassifier().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifier_InheritedMember() {
		return (EReference) getClassifier().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifier_Generalization() {
		return (EReference) getClassifier().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifier_General() {
		return (EReference) getClassifier().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifier_OwnedAnnexSubclause() {
		return (EReference) getClassifier().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifier_OwnedPrototype() {
		return (EReference) getClassifier().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifier_OwnedPrototypeBinding() {
		return (EReference) getClassifier().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifier_NoPrototypes() {
		return (EAttribute) getClassifier().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifier_NoAnnexes() {
		return (EAttribute) getClassifier().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifier_NoProperties() {
		return (EAttribute) getClassifier().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamespace() {
		if (namespaceEClass == null) {
			namespaceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(17);
		}
		return namespaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamespace_OwnedMember() {
		return (EReference) getNamespace().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamespace_Member() {
		return (EReference) getNamespace().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifierFeature() {
		if (classifierFeatureEClass == null) {
			classifierFeatureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(18);
		}
		return classifierFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierFeature_FeaturingClassifier() {
		return (EReference) getClassifierFeature().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneralization() {
		if (generalizationEClass == null) {
			generalizationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(19);
		}
		return generalizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneralization_General() {
		return (EReference) getGeneralization().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneralization_Specific() {
		return (EReference) getGeneralization().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirectedRelationship() {
		if (directedRelationshipEClass == null) {
			directedRelationshipEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(20);
		}
		return directedRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDirectedRelationship_Source() {
		return (EReference) getDirectedRelationship().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDirectedRelationship_Target() {
		return (EReference) getDirectedRelationship().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationship() {
		if (relationshipEClass == null) {
			relationshipEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(21);
		}
		return relationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationship_RelatedElement() {
		return (EReference) getRelationship().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnexSubclause() {
		if (annexSubclauseEClass == null) {
			annexSubclauseEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(22);
		}
		return annexSubclauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModalElement() {
		if (modalElementEClass == null) {
			modalElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(23);
		}
		return modalElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModalElement_InMode() {
		return (EReference) getModalElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMode() {
		if (modeEClass == null) {
			modeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(24);
		}
		return modeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMode_Initial() {
		return (EAttribute) getMode().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMode_Derived() {
		return (EAttribute) getMode().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModeFeature() {
		if (modeFeatureEClass == null) {
			modeFeatureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(25);
		}
		return modeFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrototype() {
		if (prototypeEClass == null) {
			prototypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(26);
		}
		return prototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrototype_Refined() {
		return (EReference) getPrototype().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructuralFeature() {
		if (structuralFeatureEClass == null) {
			structuralFeatureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(27);
		}
		return structuralFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRefinableElement() {
		if (refinableElementEClass == null) {
			refinableElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(28);
		}
		return refinableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRefinableElement_RefinementContext() {
		return (EReference) getRefinableElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRefinableElement_RefinedElement() {
		return (EReference) getRefinableElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureClassifier() {
		if (featureClassifierEClass == null) {
			featureClassifierEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(45);
		}
		return featureClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrototypeBinding() {
		if (prototypeBindingEClass == null) {
			prototypeBindingEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(30);
		}
		return prototypeBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrototypeBinding_Formal() {
		return (EReference) getPrototypeBinding().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainedNamedElement() {
		if (containedNamedElementEClass == null) {
			containedNamedElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(31);
		}
		return containedNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainedNamedElement_ContainmentPathElement() {
		return (EReference) getContainedNamedElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainmentPathElement() {
		if (containmentPathElementEClass == null) {
			containmentPathElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(32);
		}
		return containmentPathElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainmentPathElement_ArrayRange() {
		return (EReference) getContainmentPathElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainmentPathElement_NamedElement() {
		return (EReference) getContainmentPathElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArrayRange() {
		if (arrayRangeEClass == null) {
			arrayRangeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(33);
		}
		return arrayRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArrayRange_LowerBound() {
		return (EAttribute) getArrayRange().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArrayRange_UpperBound() {
		return (EAttribute) getArrayRange().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModalPropertyValue() {
		if (modalPropertyValueEClass == null) {
			modalPropertyValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(35);
		}
		return modalPropertyValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModalPropertyValue_OwnedValue() {
		return (EReference) getModalPropertyValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehavioralFeature() {
		if (behavioralFeatureEClass == null) {
			behavioralFeatureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(36);
		}
		return behavioralFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArrayDimension() {
		if (arrayDimensionEClass == null) {
			arrayDimensionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(38);
		}
		return arrayDimensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrayDimension_Size() {
		return (EReference) getArrayDimension().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArraySize() {
		if (arraySizeEClass == null) {
			arraySizeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(39);
		}
		return arraySizeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArraySize_Size() {
		return (EAttribute) getArraySize().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArraySize_SizeProperty() {
		return (EReference) getArraySize().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArrayableElement() {
		if (arrayableElementEClass == null) {
			arrayableElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(40);
		}
		return arrayableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrayableElement_ArrayDimension() {
		return (EReference) getArrayableElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentImplementationReference() {
		if (componentImplementationReferenceEClass == null) {
			componentImplementationReferenceEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Aadl2Package.eNS_URI).getEClassifiers().get(41);
		}
		return componentImplementationReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentImplementationReference_Implementation() {
		return (EReference) getComponentImplementationReference().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentImplementationReference_OwnedPrototypeBinding() {
		return (EReference) getComponentImplementationReference().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentImplementation() {
		if (componentImplementationEClass == null) {
			componentImplementationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(42);
		}
		return componentImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentImplementation_Type() {
		return (EReference) getComponentImplementation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentImplementation_OwnedSubcomponent() {
		return (EReference) getComponentImplementation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentImplementation_Extended() {
		return (EReference) getComponentImplementation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentImplementation_OwnedFlowImplementation() {
		return (EReference) getComponentImplementation().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentImplementation_OwnedConnection() {
		return (EReference) getComponentImplementation().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentImplementation_OwnedExtension() {
		return (EReference) getComponentImplementation().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentImplementation_OwnedRealization() {
		return (EReference) getComponentImplementation().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentImplementation_OwnedEndToEndFlow() {
		return (EReference) getComponentImplementation().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentImplementation_OwnedAbstractSubcomponent() {
		return (EReference) getComponentImplementation().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentImplementation_OwnedAccessConnection() {
		return (EReference) getComponentImplementation().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentImplementation_OwnedParameterConnection() {
		return (EReference) getComponentImplementation().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentImplementation_OwnedPortConnection() {
		return (EReference) getComponentImplementation().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentImplementation_OwnedFeatureConnection() {
		return (EReference) getComponentImplementation().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentImplementation_OwnedFeatureGroupConnection() {
		return (EReference) getComponentImplementation().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentImplementation_NoSubcomponents() {
		return (EAttribute) getComponentImplementation().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentImplementation_NoConnections() {
		return (EAttribute) getComponentImplementation().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentImplementation_NoCalls() {
		return (EAttribute) getComponentImplementation().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentClassifier() {
		if (componentClassifierEClass == null) {
			componentClassifierEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(43);
		}
		return componentClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentClassifier_OwnedMode() {
		return (EReference) getComponentClassifier().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentClassifier_OwnedModeTransition() {
		return (EReference) getComponentClassifier().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentClassifier_NoFlows() {
		return (EAttribute) getComponentClassifier().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentClassifier_NoModes() {
		return (EAttribute) getComponentClassifier().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubcomponentType() {
		if (subcomponentTypeEClass == null) {
			subcomponentTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(44);
		}
		return subcomponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModeTransition() {
		if (modeTransitionEClass == null) {
			modeTransitionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(46);
		}
		return modeTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModeTransition_Source() {
		return (EReference) getModeTransition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModeTransition_Destination() {
		return (EReference) getModeTransition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModeTransition_OwnedTrigger() {
		return (EReference) getModeTransition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModeTransitionTrigger() {
		if (modeTransitionTriggerEClass == null) {
			modeTransitionTriggerEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(47);
		}
		return modeTransitionTriggerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTriggerPort() {
		if (triggerPortEClass == null) {
			triggerPortEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(123);
		}
		return triggerPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTriggerPort_Context() {
		return (EReference) getTriggerPort().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTriggerPort_Port() {
		return (EReference) getTriggerPort().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContext() {
		if (contextEClass == null) {
			contextEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(60);
		}
		return contextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPort() {
		if (portEClass == null) {
			portEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(83);
		}
		return portEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_Category() {
		return (EAttribute) getPort().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirectedFeature() {
		if (directedFeatureEClass == null) {
			directedFeatureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(64);
		}
		return directedFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDirectedFeature_Direction() {
		return (EAttribute) getDirectedFeature().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeature() {
		if (featureEClass == null) {
			featureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(49);
		}
		return featureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_Prototype() {
		return (EReference) getFeature().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_FeatureClassifier() {
		return (EReference) getFeature().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_Classifier() {
		return (EReference) getFeature().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_Refined() {
		return (EReference) getFeature().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureConnectionEnd() {
		if (featureConnectionEndEClass == null) {
			featureConnectionEndEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(50);
		}
		return featureConnectionEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectionEnd() {
		if (connectionEndEClass == null) {
			connectionEndEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(51);
		}
		return connectionEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortConnectionEnd() {
		if (portConnectionEndEClass == null) {
			portConnectionEndEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(79);
		}
		return portConnectionEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessorPort() {
		if (processorPortEClass == null) {
			processorPortEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(269);
		}
		return processorPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalEvent() {
		if (internalEventEClass == null) {
			internalEventEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(270);
		}
		return internalEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentType() {
		if (componentTypeEClass == null) {
			componentTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(48);
		}
		return componentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentType_OwnedFeature() {
		return (EReference) getComponentType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentType_Extended() {
		return (EReference) getComponentType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentType_OwnedFlowSpecification() {
		return (EReference) getComponentType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentType_OwnedExtension() {
		return (EReference) getComponentType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentType_OwnedFeatureGroup() {
		return (EReference) getComponentType().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentType_OwnedAbstractFeature() {
		return (EReference) getComponentType().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentType_NoFeatures() {
		return (EAttribute) getComponentType().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowSpecification() {
		if (flowSpecificationEClass == null) {
			flowSpecificationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(53);
		}
		return flowSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowSpecification_Refined() {
		return (EReference) getFlowSpecification().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlowSpecification_Kind() {
		return (EAttribute) getFlowSpecification().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowSpecification_OutEnd() {
		return (EReference) getFlowSpecification().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowSpecification_InEnd() {
		return (EReference) getFlowSpecification().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlow() {
		if (flowEClass == null) {
			flowEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(54);
		}
		return flowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeExtension() {
		if (typeExtensionEClass == null) {
			typeExtensionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(61);
		}
		return typeExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeExtension_Extended() {
		return (EReference) getTypeExtension().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureGroup() {
		if (featureGroupEClass == null) {
			featureGroupEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(62);
		}
		return featureGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureGroup_Inverse() {
		return (EAttribute) getFeatureGroup().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroup_FeatureType() {
		return (EReference) getFeatureGroup().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroup_FeatureGroupType() {
		return (EReference) getFeatureGroup().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroup_FeatureGroupPrototype() {
		return (EReference) getFeatureGroup().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureGroupConnectionEnd() {
		if (featureGroupConnectionEndEClass == null) {
			featureGroupConnectionEndEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(66);
		}
		return featureGroupConnectionEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureType() {
		if (featureTypeEClass == null) {
			featureTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(67);
		}
		return featureTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallContext() {
		if (callContextEClass == null) {
			callContextEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(63);
		}
		return callContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureGroupType() {
		if (featureGroupTypeEClass == null) {
			featureGroupTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(68);
		}
		return featureGroupTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroupType_OwnedFeature() {
		return (EReference) getFeatureGroupType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroupType_Extended() {
		return (EReference) getFeatureGroupType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroupType_Inverse() {
		return (EReference) getFeatureGroupType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroupType_OwnedExtension() {
		return (EReference) getFeatureGroupType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroupType_OwnedBusAccess() {
		return (EReference) getFeatureGroupType().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroupType_OwnedDataAccess() {
		return (EReference) getFeatureGroupType().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroupType_OwnedDataPort() {
		return (EReference) getFeatureGroupType().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroupType_OwnedEventDataPort() {
		return (EReference) getFeatureGroupType().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroupType_OwnedEventPort() {
		return (EReference) getFeatureGroupType().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroupType_OwnedFeatureGroup() {
		return (EReference) getFeatureGroupType().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroupType_OwnedParameter() {
		return (EReference) getFeatureGroupType().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroupType_OwnedSubprogramAccess() {
		return (EReference) getFeatureGroupType().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroupType_OwnedSubprogramGroupAccess() {
		return (EReference) getFeatureGroupType().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroupType_OwnedAbstractFeature() {
		return (EReference) getFeatureGroupType().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroupExtension() {
		if (groupExtensionEClass == null) {
			groupExtensionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(69);
		}
		return groupExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGroupExtension_Extended() {
		return (EReference) getGroupExtension().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusAccess() {
		if (busAccessEClass == null) {
			busAccessEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(70);
		}
		return busAccessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusAccess_BusFeatureClassifier() {
		return (EReference) getBusAccess().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAccess() {
		if (accessEClass == null) {
			accessEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(71);
		}
		return accessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccess_Kind() {
		return (EAttribute) getAccess().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccess_Category() {
		return (EAttribute) getAccess().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAccessConnectionEnd() {
		if (accessConnectionEndEClass == null) {
			accessConnectionEndEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(72);
		}
		return accessConnectionEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusClassifier() {
		if (busClassifierEClass == null) {
			busClassifierEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(181);
		}
		return busClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusSubcomponentType() {
		if (busSubcomponentTypeEClass == null) {
			busSubcomponentTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(75);
		}
		return busSubcomponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBus() {
		if (busEClass == null) {
			busEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers().get(76);
		}
		return busEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataAccess() {
		if (dataAccessEClass == null) {
			dataAccessEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(77);
		}
		return dataAccessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataAccess_DataFeatureClassifier() {
		return (EReference) getDataAccess().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterConnectionEnd() {
		if (parameterConnectionEndEClass == null) {
			parameterConnectionEndEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(78);
		}
		return parameterConnectionEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowElement() {
		if (flowElementEClass == null) {
			flowElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(56);
		}
		return flowElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndToEndFlowElement() {
		if (endToEndFlowElementEClass == null) {
			endToEndFlowElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(57);
		}
		return endToEndFlowElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowEnd() {
		if (flowEndEClass == null) {
			flowEndEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(59);
		}
		return flowEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowEnd_Context() {
		return (EReference) getFlowEnd().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowEnd_Feature() {
		return (EReference) getFlowEnd().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataClassifier() {
		if (dataClassifierEClass == null) {
			dataClassifierEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(185);
		}
		return dataClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataSubcomponentType() {
		if (dataSubcomponentTypeEClass == null) {
			dataSubcomponentTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(80);
		}
		return dataSubcomponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getData() {
		if (dataEClass == null) {
			dataEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(81);
		}
		return dataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataPort() {
		if (dataPortEClass == null) {
			dataPortEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(82);
		}
		return dataPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataPort_DataFeatureClassifier() {
		return (EReference) getDataPort().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventDataPort() {
		if (eventDataPortEClass == null) {
			eventDataPortEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(85);
		}
		return eventDataPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventDataPort_DataFeatureClassifier() {
		return (EReference) getEventDataPort().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventPort() {
		if (eventPortEClass == null) {
			eventPortEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(86);
		}
		return eventPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		if (parameterEClass == null) {
			parameterEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(87);
		}
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameter_DataFeatureClassifier() {
		return (EReference) getParameter().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubprogramAccess() {
		if (subprogramAccessEClass == null) {
			subprogramAccessEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(88);
		}
		return subprogramAccessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramAccess_SubprogramFeatureClassifier() {
		return (EReference) getSubprogramAccess().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCalledSubprogram() {
		if (calledSubprogramEClass == null) {
			calledSubprogramEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(29);
		}
		return calledSubprogramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubprogramClassifier() {
		if (subprogramClassifierEClass == null) {
			subprogramClassifierEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(197);
		}
		return subprogramClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubprogramSubcomponentType() {
		if (subprogramSubcomponentTypeEClass == null) {
			subprogramSubcomponentTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(89);
		}
		return subprogramSubcomponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubprogram() {
		if (subprogramEClass == null) {
			subprogramEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(90);
		}
		return subprogramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubprogramGroupAccess() {
		if (subprogramGroupAccessEClass == null) {
			subprogramGroupAccessEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(91);
		}
		return subprogramGroupAccessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramGroupAccess_SubprogramGroupFeatureClassifier() {
		return (EReference) getSubprogramGroupAccess().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubprogramGroupClassifier() {
		if (subprogramGroupClassifierEClass == null) {
			subprogramGroupClassifierEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(201);
		}
		return subprogramGroupClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubprogramGroupSubcomponentType() {
		if (subprogramGroupSubcomponentTypeEClass == null) {
			subprogramGroupSubcomponentTypeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Aadl2Package.eNS_URI).getEClassifiers().get(92);
		}
		return subprogramGroupSubcomponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubprogramGroup() {
		if (subprogramGroupEClass == null) {
			subprogramGroupEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(93);
		}
		return subprogramGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractFeature() {
		if (abstractFeatureEClass == null) {
			abstractFeatureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(94);
		}
		return abstractFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractFeature_FeaturePrototype() {
		return (EReference) getAbstractFeature().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubcomponent() {
		if (subcomponentEClass == null) {
			subcomponentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(97);
		}
		return subcomponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubcomponent_SubcomponentType() {
		return (EReference) getSubcomponent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubcomponent_Classifier() {
		return (EReference) getSubcomponent().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubcomponent_OwnedPrototypeBinding() {
		return (EReference) getSubcomponent().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubcomponent_Prototype() {
		return (EReference) getSubcomponent().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubcomponent_OwnedModeBinding() {
		return (EReference) getSubcomponent().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubcomponent_AllModes() {
		return (EAttribute) getSubcomponent().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubcomponent_ImplementationReference() {
		return (EReference) getSubcomponent().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubcomponent_Refined() {
		return (EReference) getSubcomponent().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentPrototype() {
		if (componentPrototypeEClass == null) {
			componentPrototypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(52);
		}
		return componentPrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentPrototype_Array() {
		return (EAttribute) getComponentPrototype().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentPrototype_ConstrainingClassifier() {
		return (EReference) getComponentPrototype().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModeBinding() {
		if (modeBindingEClass == null) {
			modeBindingEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(98);
		}
		return modeBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModeBinding_ParentMode() {
		return (EReference) getModeBinding().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModeBinding_DerivedMode() {
		return (EReference) getModeBinding().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractSubcomponentType() {
		if (abstractSubcomponentTypeEClass == null) {
			abstractSubcomponentTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(109);
		}
		return abstractSubcomponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractClassifier() {
		if (abstractClassifierEClass == null) {
			abstractClassifierEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(147);
		}
		return abstractClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstract() {
		if (abstractEClass == null) {
			abstractEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(108);
		}
		return abstractEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowImplementation() {
		if (flowImplementationEClass == null) {
			flowImplementationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(99);
		}
		return flowImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlowImplementation_Kind() {
		return (EAttribute) getFlowImplementation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowImplementation_Specification() {
		return (EReference) getFlowImplementation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowImplementation_OwnedFlowSegment() {
		return (EReference) getFlowImplementation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModalPath() {
		if (modalPathEClass == null) {
			modalPathEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(55);
		}
		return modalPathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModalPath_InModeOrTransition() {
		return (EReference) getModalPath().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowSegment() {
		if (flowSegmentEClass == null) {
			flowSegmentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(100);
		}
		return flowSegmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowSegment_FlowElement() {
		return (EReference) getFlowSegment().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowSegment_Context() {
		return (EReference) getFlowSegment().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnection() {
		if (connectionEClass == null) {
			connectionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(101);
		}
		return connectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnection_Destination() {
		return (EReference) getConnection().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnection_Source() {
		return (EReference) getConnection().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnection_Bidirectional() {
		return (EAttribute) getConnection().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnection_Refined() {
		return (EReference) getConnection().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractConnectionEnd() {
		if (abstractConnectionEndEClass == null) {
			abstractConnectionEndEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(102);
		}
		return abstractConnectionEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectedElement() {
		if (connectedElementEClass == null) {
			connectedElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(117);
		}
		return connectedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectedElement_Context() {
		return (EReference) getConnectedElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectedElement_ConnectionEnd() {
		return (EReference) getConnectedElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplementationExtension() {
		if (implementationExtensionEClass == null) {
			implementationExtensionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(103);
		}
		return implementationExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImplementationExtension_Extended() {
		return (EReference) getImplementationExtension().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRealization() {
		if (realizationEClass == null) {
			realizationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(104);
		}
		return realizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRealization_Implemented() {
		return (EReference) getRealization().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndToEndFlow() {
		if (endToEndFlowEClass == null) {
			endToEndFlowEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(105);
		}
		return endToEndFlowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndToEndFlow_Refined() {
		return (EReference) getEndToEndFlow().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndToEndFlow_OwnedEndToEndFlowSegment() {
		return (EReference) getEndToEndFlow().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndToEndFlowSegment() {
		if (endToEndFlowSegmentEClass == null) {
			endToEndFlowSegmentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(106);
		}
		return endToEndFlowSegmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndToEndFlowSegment_FlowElement() {
		return (EReference) getEndToEndFlowSegment().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndToEndFlowSegment_Context() {
		return (EReference) getEndToEndFlowSegment().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractSubcomponent() {
		if (abstractSubcomponentEClass == null) {
			abstractSubcomponentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(107);
		}
		return abstractSubcomponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractSubcomponent_AbstractSubcomponentType() {
		return (EReference) getAbstractSubcomponent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementName() {
		if (elementNameEClass == null) {
			elementNameEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(118);
		}
		return elementNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementName_Kind() {
		return (EAttribute) getElementName().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAccessConnection() {
		if (accessConnectionEClass == null) {
			accessConnectionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(110);
		}
		return accessConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccessConnection_AccessCategory() {
		return (EAttribute) getAccessConnection().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterConnection() {
		if (parameterConnectionEClass == null) {
			parameterConnectionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(111);
		}
		return parameterConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortConnection() {
		if (portConnectionEClass == null) {
			portConnectionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(112);
		}
		return portConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureConnection() {
		if (featureConnectionEClass == null) {
			featureConnectionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(113);
		}
		return featureConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureGroupConnection() {
		if (featureGroupConnectionEClass == null) {
			featureGroupConnectionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(114);
		}
		return featureGroupConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessorSubprogram() {
		if (processorSubprogramEClass == null) {
			processorSubprogramEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(271);
		}
		return processorSubprogramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnexLibrary() {
		if (annexLibraryEClass == null) {
			annexLibraryEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(120);
		}
		return annexLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefaultAnnexLibrary() {
		if (defaultAnnexLibraryEClass == null) {
			defaultAnnexLibraryEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(121);
		}
		return defaultAnnexLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefaultAnnexLibrary_SourceText() {
		return (EAttribute) getDefaultAnnexLibrary().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefaultAnnexSubclause() {
		if (defaultAnnexSubclauseEClass == null) {
			defaultAnnexSubclauseEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(122);
		}
		return defaultAnnexSubclauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefaultAnnexSubclause_SourceText() {
		return (EAttribute) getDefaultAnnexSubclause().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPublicPackageSection() {
		if (publicPackageSectionEClass == null) {
			publicPackageSectionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(124);
		}
		return publicPackageSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPublicPackageSection_PrivateSection() {
		return (EReference) getPublicPackageSection().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageSection() {
		if (packageSectionEClass == null) {
			packageSectionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(125);
		}
		return packageSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageSection_OwnedPackageRename() {
		return (EReference) getPackageSection().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageSection_OwnedComponentTypeRename() {
		return (EReference) getPackageSection().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageSection_OwnedClassifier() {
		return (EReference) getPackageSection().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageSection_OwnedFeatureGroupTypeRename() {
		return (EReference) getPackageSection().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageSection_OwnedAnnexLibrary() {
		return (EReference) getPackageSection().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageSection_ImportedUnit() {
		return (EReference) getPackageSection().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackageSection_NoAnnexes() {
		return (EAttribute) getPackageSection().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackageSection_NoProperties() {
		return (EAttribute) getPackageSection().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageRename() {
		if (packageRenameEClass == null) {
			packageRenameEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(126);
		}
		return packageRenameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageRename_RenamedPackage() {
		return (EReference) getPackageRename().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackageRename_RenameAll() {
		return (EAttribute) getPackageRename().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAadlPackage() {
		if (aadlPackageEClass == null) {
			aadlPackageEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(127);
		}
		return aadlPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAadlPackage_OwnedPublicSection() {
		return (EReference) getAadlPackage().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAadlPackage_OwnedPrivateSection() {
		return (EReference) getAadlPackage().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAadlPackage_PublicSection() {
		return (EReference) getAadlPackage().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAadlPackage_PrivateSection() {
		return (EReference) getAadlPackage().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelUnit() {
		if (modelUnitEClass == null) {
			modelUnitEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(128);
		}
		return modelUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrivatePackageSection() {
		if (privatePackageSectionEClass == null) {
			privatePackageSectionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(129);
		}
		return privatePackageSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrivatePackageSection_PublicSection() {
		return (EReference) getPrivatePackageSection().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentTypeRename() {
		if (componentTypeRenameEClass == null) {
			componentTypeRenameEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(130);
		}
		return componentTypeRenameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentTypeRename_Category() {
		return (EAttribute) getComponentTypeRename().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentTypeRename_RenamedComponentType() {
		return (EReference) getComponentTypeRename().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureGroupTypeRename() {
		if (featureGroupTypeRenameEClass == null) {
			featureGroupTypeRenameEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(131);
		}
		return featureGroupTypeRenameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroupTypeRename_RenamedFeatureGroupType() {
		return (EReference) getFeatureGroupTypeRename().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractType() {
		if (abstractTypeEClass == null) {
			abstractTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(146);
		}
		return abstractTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractType_OwnedBusAccess() {
		return (EReference) getAbstractType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractType_OwnedDataAccess() {
		return (EReference) getAbstractType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractType_OwnedSubprogramAccess() {
		return (EReference) getAbstractType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractType_OwnedDataPort() {
		return (EReference) getAbstractType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractType_OwnedEventPort() {
		return (EReference) getAbstractType().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractType_OwnedEventDataPort() {
		return (EReference) getAbstractType().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractType_OwnedSubprogramGroupAccess() {
		return (EReference) getAbstractType().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractImplementation() {
		if (abstractImplementationEClass == null) {
			abstractImplementationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(166);
		}
		return abstractImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractImplementation_OwnedBusSubcomponent() {
		return (EReference) getAbstractImplementation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractImplementation_OwnedDataSubcomponent() {
		return (EReference) getAbstractImplementation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractImplementation_OwnedDeviceSubcomponent() {
		return (EReference) getAbstractImplementation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractImplementation_OwnedMemorySubcomponent() {
		return (EReference) getAbstractImplementation().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractImplementation_OwnedProcessSubcomponent() {
		return (EReference) getAbstractImplementation().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractImplementation_OwnedProcessorSubcomponent() {
		return (EReference) getAbstractImplementation().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractImplementation_OwnedSystemSubcomponent() {
		return (EReference) getAbstractImplementation().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractImplementation_OwnedSubprogramSubcomponent() {
		return (EReference) getAbstractImplementation().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractImplementation_OwnedSubprogramGroupSubcomponent() {
		return (EReference) getAbstractImplementation().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractImplementation_OwnedThreadSubcomponent() {
		return (EReference) getAbstractImplementation().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractImplementation_OwnedThreadGroupSubcomponent() {
		return (EReference) getAbstractImplementation().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractImplementation_OwnedVirtualBusSubcomponent() {
		return (EReference) getAbstractImplementation().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractImplementation_OwnedVirtualProcessorSubcomponent() {
		return (EReference) getAbstractImplementation().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehavioredImplementation() {
		if (behavioredImplementationEClass == null) {
			behavioredImplementationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(144);
		}
		return behavioredImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehavioredImplementation_CallSpecification() {
		return (EReference) getBehavioredImplementation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehavioredImplementation_OwnedSubprogramCallSequence() {
		return (EReference) getBehavioredImplementation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallSpecification() {
		if (callSpecificationEClass == null) {
			callSpecificationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(142);
		}
		return callSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubprogramCallSequence() {
		if (subprogramCallSequenceEClass == null) {
			subprogramCallSequenceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(141);
		}
		return subprogramCallSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramCallSequence_OwnedCallSpecification() {
		return (EReference) getSubprogramCallSequence().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusSubcomponent() {
		if (busSubcomponentEClass == null) {
			busSubcomponentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(167);
		}
		return busSubcomponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusSubcomponent_BusSubcomponentType() {
		return (EReference) getBusSubcomponent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataSubcomponent() {
		if (dataSubcomponentEClass == null) {
			dataSubcomponentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(168);
		}
		return dataSubcomponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataSubcomponent_DataSubcomponentType() {
		return (EReference) getDataSubcomponent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeviceSubcomponent() {
		if (deviceSubcomponentEClass == null) {
			deviceSubcomponentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(169);
		}
		return deviceSubcomponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeviceSubcomponent_DeviceSubcomponentType() {
		return (EReference) getDeviceSubcomponent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDevice() {
		if (deviceEClass == null) {
			deviceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(163);
		}
		return deviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeviceSubcomponentType() {
		if (deviceSubcomponentTypeEClass == null) {
			deviceSubcomponentTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(162);
		}
		return deviceSubcomponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeviceClassifier() {
		if (deviceClassifierEClass == null) {
			deviceClassifierEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(189);
		}
		return deviceClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemorySubcomponent() {
		if (memorySubcomponentEClass == null) {
			memorySubcomponentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(170);
		}
		return memorySubcomponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemorySubcomponent_MemorySubcomponentType() {
		return (EReference) getMemorySubcomponent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemory() {
		if (memoryEClass == null) {
			memoryEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(161);
		}
		return memoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemorySubcomponentType() {
		if (memorySubcomponentTypeEClass == null) {
			memorySubcomponentTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(160);
		}
		return memorySubcomponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemoryClassifier() {
		if (memoryClassifierEClass == null) {
			memoryClassifierEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(193);
		}
		return memoryClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessSubcomponent() {
		if (processSubcomponentEClass == null) {
			processSubcomponentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(171);
		}
		return processSubcomponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessSubcomponent_ProcessSubcomponentType() {
		return (EReference) getProcessSubcomponent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcess() {
		if (processEClass == null) {
			processEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(159);
		}
		return processEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessSubcomponentType() {
		if (processSubcomponentTypeEClass == null) {
			processSubcomponentTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(158);
		}
		return processSubcomponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessClassifier() {
		if (processClassifierEClass == null) {
			processClassifierEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(213);
		}
		return processClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessorSubcomponent() {
		if (processorSubcomponentEClass == null) {
			processorSubcomponentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(172);
		}
		return processorSubcomponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessorSubcomponent_ProcessorSubcomponentType() {
		return (EReference) getProcessorSubcomponent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessor() {
		if (processorEClass == null) {
			processorEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(165);
		}
		return processorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessorSubcomponentType() {
		if (processorSubcomponentTypeEClass == null) {
			processorSubcomponentTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(164);
		}
		return processorSubcomponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessorClassifier() {
		if (processorClassifierEClass == null) {
			processorClassifierEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(209);
		}
		return processorClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemSubcomponent() {
		if (systemSubcomponentEClass == null) {
			systemSubcomponentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(173);
		}
		return systemSubcomponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemSubcomponent_SystemSubcomponentType() {
		return (EReference) getSystemSubcomponent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystem() {
		if (systemEClass == null) {
			systemEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(157);
		}
		return systemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemSubcomponentType() {
		if (systemSubcomponentTypeEClass == null) {
			systemSubcomponentTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(156);
		}
		return systemSubcomponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemClassifier() {
		if (systemClassifierEClass == null) {
			systemClassifierEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(205);
		}
		return systemClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubprogramSubcomponent() {
		if (subprogramSubcomponentEClass == null) {
			subprogramSubcomponentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(174);
		}
		return subprogramSubcomponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramSubcomponent_SubprogramSubcomponentType() {
		return (EReference) getSubprogramSubcomponent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubprogramGroupSubcomponent() {
		if (subprogramGroupSubcomponentEClass == null) {
			subprogramGroupSubcomponentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(175);
		}
		return subprogramGroupSubcomponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramGroupSubcomponent_SubprogramGroupSubcomponentType() {
		return (EReference) getSubprogramGroupSubcomponent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThreadSubcomponent() {
		if (threadSubcomponentEClass == null) {
			threadSubcomponentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(176);
		}
		return threadSubcomponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreadSubcomponent_ThreadSubcomponentType() {
		return (EReference) getThreadSubcomponent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThread() {
		if (threadEClass == null) {
			threadEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(155);
		}
		return threadEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThreadSubcomponentType() {
		if (threadSubcomponentTypeEClass == null) {
			threadSubcomponentTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(154);
		}
		return threadSubcomponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThreadClassifier() {
		if (threadClassifierEClass == null) {
			threadClassifierEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(217);
		}
		return threadClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThreadGroupSubcomponent() {
		if (threadGroupSubcomponentEClass == null) {
			threadGroupSubcomponentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(177);
		}
		return threadGroupSubcomponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreadGroupSubcomponent_ThreadGroupSubcomponentType() {
		return (EReference) getThreadGroupSubcomponent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThreadGroup() {
		if (threadGroupEClass == null) {
			threadGroupEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(153);
		}
		return threadGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThreadGroupSubcomponentType() {
		if (threadGroupSubcomponentTypeEClass == null) {
			threadGroupSubcomponentTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(152);
		}
		return threadGroupSubcomponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThreadGroupClassifier() {
		if (threadGroupClassifierEClass == null) {
			threadGroupClassifierEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(221);
		}
		return threadGroupClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualBusSubcomponent() {
		if (virtualBusSubcomponentEClass == null) {
			virtualBusSubcomponentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(178);
		}
		return virtualBusSubcomponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualBusSubcomponent_VirtualBusSubcomponentType() {
		return (EReference) getVirtualBusSubcomponent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualBus() {
		if (virtualBusEClass == null) {
			virtualBusEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(151);
		}
		return virtualBusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVitualBusSubcomponentType() {
		if (vitualBusSubcomponentTypeEClass == null) {
			vitualBusSubcomponentTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(150);
		}
		return vitualBusSubcomponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualBusClassifier() {
		if (virtualBusClassifierEClass == null) {
			virtualBusClassifierEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(225);
		}
		return virtualBusClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualProcessorSubcomponent() {
		if (virtualProcessorSubcomponentEClass == null) {
			virtualProcessorSubcomponentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(179);
		}
		return virtualProcessorSubcomponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualProcessorSubcomponent_VirtualProcessorSubcomponentType() {
		return (EReference) getVirtualProcessorSubcomponent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualProcessor() {
		if (virtualProcessorEClass == null) {
			virtualProcessorEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(149);
		}
		return virtualProcessorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualProcessorSubcomponentType() {
		if (virtualProcessorSubcomponentTypeEClass == null) {
			virtualProcessorSubcomponentTypeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Aadl2Package.eNS_URI).getEClassifiers().get(148);
		}
		return virtualProcessorSubcomponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractPrototype() {
		if (abstractPrototypeEClass == null) {
			abstractPrototypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(180);
		}
		return abstractPrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualProcessorClassifier() {
		if (virtualProcessorClassifierEClass == null) {
			virtualProcessorClassifierEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(229);
		}
		return virtualProcessorClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusType() {
		if (busTypeEClass == null) {
			busTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(182);
		}
		return busTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusType_OwnedBusAccess() {
		return (EReference) getBusType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusType_OwnedDataPort() {
		return (EReference) getBusType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusType_OwnedEventDataPort() {
		return (EReference) getBusType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusType_OwnedEventPort() {
		return (EReference) getBusType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusImplementation() {
		if (busImplementationEClass == null) {
			busImplementationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(183);
		}
		return busImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusImplementation_OwnedVirtualBusSubcomponent() {
		return (EReference) getBusImplementation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusPrototype() {
		if (busPrototypeEClass == null) {
			busPrototypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(184);
		}
		return busPrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataType() {
		if (dataTypeEClass == null) {
			dataTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(186);
		}
		return dataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataType_OwnedSubprogramAccess() {
		return (EReference) getDataType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataType_OwnedSubprogramGroupAccess() {
		return (EReference) getDataType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataImplementation() {
		if (dataImplementationEClass == null) {
			dataImplementationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(187);
		}
		return dataImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataImplementation_OwnedDataSubcomponent() {
		return (EReference) getDataImplementation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataImplementation_OwnedSubprogramSubcomponent() {
		return (EReference) getDataImplementation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataPrototype() {
		if (dataPrototypeEClass == null) {
			dataPrototypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(188);
		}
		return dataPrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeviceType() {
		if (deviceTypeEClass == null) {
			deviceTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(190);
		}
		return deviceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeviceType_OwnedDataPort() {
		return (EReference) getDeviceType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeviceType_OwnedEventDataPort() {
		return (EReference) getDeviceType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeviceType_OwnedEventPort() {
		return (EReference) getDeviceType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeviceType_OwnedBusAccess() {
		return (EReference) getDeviceType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeviceType_OwnedSubprogramAccess() {
		return (EReference) getDeviceType().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeviceType_OwnedSubprogramGroupAccess() {
		return (EReference) getDeviceType().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeviceImplementation() {
		if (deviceImplementationEClass == null) {
			deviceImplementationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(191);
		}
		return deviceImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeviceImplementation_OwnedBusSubcomponent() {
		return (EReference) getDeviceImplementation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeviceImplementation_OwnedDataSubcomponent() {
		return (EReference) getDeviceImplementation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeviceImplementation_OwnedVirtualBusSubcomponent() {
		return (EReference) getDeviceImplementation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDevicePrototype() {
		if (devicePrototypeEClass == null) {
			devicePrototypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(192);
		}
		return devicePrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemoryType() {
		if (memoryTypeEClass == null) {
			memoryTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(194);
		}
		return memoryTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemoryType_OwnedBusAccess() {
		return (EReference) getMemoryType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemoryType_OwnedDataPort() {
		return (EReference) getMemoryType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemoryType_OwnedEventDataPort() {
		return (EReference) getMemoryType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemoryType_OwnedEventPort() {
		return (EReference) getMemoryType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemoryImplementation() {
		if (memoryImplementationEClass == null) {
			memoryImplementationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(195);
		}
		return memoryImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemoryImplementation_OwnedBusSubcomponent() {
		return (EReference) getMemoryImplementation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemoryImplementation_OwnedMemorySubcomponent() {
		return (EReference) getMemoryImplementation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemoryPrototype() {
		if (memoryPrototypeEClass == null) {
			memoryPrototypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(196);
		}
		return memoryPrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessType() {
		if (processTypeEClass == null) {
			processTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(214);
		}
		return processTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessType_OwnedDataPort() {
		return (EReference) getProcessType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessType_OwnedEventDataPort() {
		return (EReference) getProcessType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessType_OwnedEventPort() {
		return (EReference) getProcessType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessType_OwnedDataAccess() {
		return (EReference) getProcessType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessType_OwnedSubprogramAccess() {
		return (EReference) getProcessType().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessType_OwnedSubprogramGroupAccess() {
		return (EReference) getProcessType().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessorType() {
		if (processorTypeEClass == null) {
			processorTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(210);
		}
		return processorTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessorType_OwnedDataPort() {
		return (EReference) getProcessorType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessorType_OwnedEventDataPort() {
		return (EReference) getProcessorType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessorType_OwnedEventPort() {
		return (EReference) getProcessorType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessorType_OwnedBusAccess() {
		return (EReference) getProcessorType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessorType_OwnedSubprogramAccess() {
		return (EReference) getProcessorType().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessorType_OwnedSubprogramGroupAccess() {
		return (EReference) getProcessorType().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessImplementation() {
		if (processImplementationEClass == null) {
			processImplementationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(215);
		}
		return processImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessImplementation_OwnedDataSubcomponent() {
		return (EReference) getProcessImplementation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessImplementation_OwnedSubprogramSubcomponent() {
		return (EReference) getProcessImplementation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessImplementation_OwnedSubprogramGroupSubcomponent() {
		return (EReference) getProcessImplementation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessImplementation_OwnedThreadSubcomponent() {
		return (EReference) getProcessImplementation().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessImplementation_OwnedThreadGroupSubcomponent() {
		return (EReference) getProcessImplementation().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessPrototype() {
		if (processPrototypeEClass == null) {
			processPrototypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(216);
		}
		return processPrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessorImplementation() {
		if (processorImplementationEClass == null) {
			processorImplementationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(211);
		}
		return processorImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessorImplementation_OwnedBusSubcomponent() {
		return (EReference) getProcessorImplementation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessorImplementation_OwnedMemorySubcomponent() {
		return (EReference) getProcessorImplementation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessorImplementation_OwnedVirtualBusSubcomponent() {
		return (EReference) getProcessorImplementation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessorImplementation_OwnedVirtualProcessorSubcomponent() {
		return (EReference) getProcessorImplementation().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessorPrototype() {
		if (processorPrototypeEClass == null) {
			processorPrototypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(212);
		}
		return processorPrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubprogramType() {
		if (subprogramTypeEClass == null) {
			subprogramTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(198);
		}
		return subprogramTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramType_OwnedEventDataPort() {
		return (EReference) getSubprogramType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramType_OwnedEventPort() {
		return (EReference) getSubprogramType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramType_OwnedParameter() {
		return (EReference) getSubprogramType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramType_OwnedDataAccess() {
		return (EReference) getSubprogramType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramType_OwnedSubprogramAccess() {
		return (EReference) getSubprogramType().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramType_OwnedSubprogramGroupAccess() {
		return (EReference) getSubprogramType().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubprogramImplementation() {
		if (subprogramImplementationEClass == null) {
			subprogramImplementationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(199);
		}
		return subprogramImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramImplementation_OwnedDataSubcomponent() {
		return (EReference) getSubprogramImplementation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubprogramPrototype() {
		if (subprogramPrototypeEClass == null) {
			subprogramPrototypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(200);
		}
		return subprogramPrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubprogramGroupType() {
		if (subprogramGroupTypeEClass == null) {
			subprogramGroupTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(202);
		}
		return subprogramGroupTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramGroupType_OwnedSubprogramAccess() {
		return (EReference) getSubprogramGroupType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramGroupType_OwnedSubprogramGroupAccess() {
		return (EReference) getSubprogramGroupType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubprogramGroupImplementation() {
		if (subprogramGroupImplementationEClass == null) {
			subprogramGroupImplementationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(203);
		}
		return subprogramGroupImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramGroupImplementation_OwnedSubprogramSubcomponent() {
		return (EReference) getSubprogramGroupImplementation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramGroupImplementation_OwnedSubprogramGroupSubcomponent() {
		return (EReference) getSubprogramGroupImplementation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramGroupImplementation_OwnedDataSubcomponent() {
		return (EReference) getSubprogramGroupImplementation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubprogramGroupPrototype() {
		if (subprogramGroupPrototypeEClass == null) {
			subprogramGroupPrototypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(204);
		}
		return subprogramGroupPrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemType() {
		if (systemTypeEClass == null) {
			systemTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(206);
		}
		return systemTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemType_OwnedBusAccess() {
		return (EReference) getSystemType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemType_OwnedDataAccess() {
		return (EReference) getSystemType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemType_OwnedDataPort() {
		return (EReference) getSystemType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemType_OwnedSubprogramGroupAccess() {
		return (EReference) getSystemType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemType_OwnedSubprogramAccess() {
		return (EReference) getSystemType().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemType_OwnedEventPort() {
		return (EReference) getSystemType().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemType_OwnedEventDataPort() {
		return (EReference) getSystemType().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemImplementation() {
		if (systemImplementationEClass == null) {
			systemImplementationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(207);
		}
		return systemImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemImplementation_OwnedBusSubcomponent() {
		return (EReference) getSystemImplementation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemImplementation_OwnedDataSubcomponent() {
		return (EReference) getSystemImplementation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemImplementation_OwnedDeviceSubcomponent() {
		return (EReference) getSystemImplementation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemImplementation_OwnedMemorySubcomponent() {
		return (EReference) getSystemImplementation().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemImplementation_OwnedProcessSubcomponent() {
		return (EReference) getSystemImplementation().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemImplementation_OwnedProcessorSubcomponent() {
		return (EReference) getSystemImplementation().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemImplementation_OwnedSubprogramSubcomponent() {
		return (EReference) getSystemImplementation().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemImplementation_OwnedSubprogramGroupSubcomponent() {
		return (EReference) getSystemImplementation().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemImplementation_OwnedSystemSubcomponent() {
		return (EReference) getSystemImplementation().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemImplementation_OwnedVirtualBusSubcomponent() {
		return (EReference) getSystemImplementation().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemImplementation_OwnedVirtualProcessorSubcomponent() {
		return (EReference) getSystemImplementation().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemPrototype() {
		if (systemPrototypeEClass == null) {
			systemPrototypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(208);
		}
		return systemPrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThreadType() {
		if (threadTypeEClass == null) {
			threadTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(218);
		}
		return threadTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreadType_OwnedDataPort() {
		return (EReference) getThreadType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreadType_OwnedEventDataPort() {
		return (EReference) getThreadType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreadType_OwnedEventPort() {
		return (EReference) getThreadType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreadType_OwnedDataAccess() {
		return (EReference) getThreadType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreadType_OwnedSubprogramAccess() {
		return (EReference) getThreadType().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreadType_OwnedSubprogramGroupAccess() {
		return (EReference) getThreadType().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThreadImplementation() {
		if (threadImplementationEClass == null) {
			threadImplementationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(219);
		}
		return threadImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreadImplementation_OwnedSubprogramGroupSubcomponent() {
		return (EReference) getThreadImplementation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreadImplementation_OwnedSubprogramSubcomponent() {
		return (EReference) getThreadImplementation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreadImplementation_OwnedDataSubcomponent() {
		return (EReference) getThreadImplementation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThreadPrototype() {
		if (threadPrototypeEClass == null) {
			threadPrototypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(220);
		}
		return threadPrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThreadGroupType() {
		if (threadGroupTypeEClass == null) {
			threadGroupTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(222);
		}
		return threadGroupTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreadGroupType_OwnedDataPort() {
		return (EReference) getThreadGroupType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreadGroupType_OwnedEventDataPort() {
		return (EReference) getThreadGroupType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreadGroupType_OwnedEventPort() {
		return (EReference) getThreadGroupType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreadGroupType_OwnedDataAccess() {
		return (EReference) getThreadGroupType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreadGroupType_OwnedSubprogramAccess() {
		return (EReference) getThreadGroupType().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreadGroupType_OwnedSubprogramGroupAccess() {
		return (EReference) getThreadGroupType().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThreadGroupImplementation() {
		if (threadGroupImplementationEClass == null) {
			threadGroupImplementationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(223);
		}
		return threadGroupImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreadGroupImplementation_OwnedDataSubcomponent() {
		return (EReference) getThreadGroupImplementation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreadGroupImplementation_OwnedThreadSubcomponent() {
		return (EReference) getThreadGroupImplementation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreadGroupImplementation_OwnedThreadGroupSubcomponent() {
		return (EReference) getThreadGroupImplementation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreadGroupImplementation_OwnedSubprogramSubcomponent() {
		return (EReference) getThreadGroupImplementation().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreadGroupImplementation_OwnedSubprogramGroupSubcomponent() {
		return (EReference) getThreadGroupImplementation().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThreadGroupPrototype() {
		if (threadGroupPrototypeEClass == null) {
			threadGroupPrototypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(224);
		}
		return threadGroupPrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualBusType() {
		if (virtualBusTypeEClass == null) {
			virtualBusTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(226);
		}
		return virtualBusTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualBusType_OwnedDataPort() {
		return (EReference) getVirtualBusType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualBusType_OwnedEventDataPort() {
		return (EReference) getVirtualBusType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualBusType_OwnedEventPort() {
		return (EReference) getVirtualBusType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualBusImplementation() {
		if (virtualBusImplementationEClass == null) {
			virtualBusImplementationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(227);
		}
		return virtualBusImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualBusImplementation_OwnedVirtualBusSubcomponent() {
		return (EReference) getVirtualBusImplementation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualBusPrototype() {
		if (virtualBusPrototypeEClass == null) {
			virtualBusPrototypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(228);
		}
		return virtualBusPrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualProcessorType() {
		if (virtualProcessorTypeEClass == null) {
			virtualProcessorTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(230);
		}
		return virtualProcessorTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualProcessorType_OwnedDataPort() {
		return (EReference) getVirtualProcessorType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualProcessorType_OwnedEventDataPort() {
		return (EReference) getVirtualProcessorType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualProcessorType_OwnedEventPort() {
		return (EReference) getVirtualProcessorType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualProcessorType_OwnedSubprogramAccess() {
		return (EReference) getVirtualProcessorType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualProcessorType_OwnedSubprogramGroupAccess() {
		return (EReference) getVirtualProcessorType().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualProcessorImplementation() {
		if (virtualProcessorImplementationEClass == null) {
			virtualProcessorImplementationEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Aadl2Package.eNS_URI).getEClassifiers().get(231);
		}
		return virtualProcessorImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualProcessorImplementation_OwnedVirtualBusSubcomponent() {
		return (EReference) getVirtualProcessorImplementation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualProcessorImplementation_OwnedVirtualProcessorSubcomponent() {
		return (EReference) getVirtualProcessorImplementation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualProcessorPrototype() {
		if (virtualProcessorPrototypeEClass == null) {
			virtualProcessorPrototypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(232);
		}
		return virtualProcessorPrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentPrototypeBinding() {
		if (componentPrototypeBindingEClass == null) {
			componentPrototypeBindingEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(132);
		}
		return componentPrototypeBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentPrototypeBinding_Actual() {
		return (EReference) getComponentPrototypeBinding().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentPrototypeActual() {
		if (componentPrototypeActualEClass == null) {
			componentPrototypeActualEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(133);
		}
		return componentPrototypeActualEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentPrototypeActual_Category() {
		return (EAttribute) getComponentPrototypeActual().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentPrototypeActual_Binding() {
		return (EReference) getComponentPrototypeActual().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentPrototypeActual_SubcomponentType() {
		return (EReference) getComponentPrototypeActual().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureGroupPrototype() {
		if (featureGroupPrototypeEClass == null) {
			featureGroupPrototypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(96);
		}
		return featureGroupPrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroupPrototype_ConstrainingFeatureGroupType() {
		return (EReference) getFeatureGroupPrototype().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureGroupPrototypeBinding() {
		if (featureGroupPrototypeBindingEClass == null) {
			featureGroupPrototypeBindingEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(134);
		}
		return featureGroupPrototypeBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroupPrototypeBinding_Actual() {
		return (EReference) getFeatureGroupPrototypeBinding().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureGroupPrototypeActual() {
		if (featureGroupPrototypeActualEClass == null) {
			featureGroupPrototypeActualEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(135);
		}
		return featureGroupPrototypeActualEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroupPrototypeActual_Binding() {
		return (EReference) getFeatureGroupPrototypeActual().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroupPrototypeActual_FeatureType() {
		return (EReference) getFeatureGroupPrototypeActual().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeaturePrototype() {
		if (featurePrototypeEClass == null) {
			featurePrototypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(95);
		}
		return featurePrototypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeaturePrototype_Direction() {
		return (EAttribute) getFeaturePrototype().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeaturePrototype_ConstrainingClassifier() {
		return (EReference) getFeaturePrototype().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeaturePrototypeBinding() {
		if (featurePrototypeBindingEClass == null) {
			featurePrototypeBindingEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(137);
		}
		return featurePrototypeBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeaturePrototypeBinding_Actual() {
		return (EReference) getFeaturePrototypeBinding().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeaturePrototypeActual() {
		if (featurePrototypeActualEClass == null) {
			featurePrototypeActualEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(136);
		}
		return featurePrototypeActualEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAccessSpecification() {
		if (accessSpecificationEClass == null) {
			accessSpecificationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(138);
		}
		return accessSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccessSpecification_Kind() {
		return (EAttribute) getAccessSpecification().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccessSpecification_Category() {
		return (EAttribute) getAccessSpecification().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAccessSpecification_Classifier() {
		return (EReference) getAccessSpecification().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortSpecification() {
		if (portSpecificationEClass == null) {
			portSpecificationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(139);
		}
		return portSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPortSpecification_Direction() {
		return (EAttribute) getPortSpecification().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPortSpecification_Category() {
		return (EAttribute) getPortSpecification().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortSpecification_Classifier() {
		return (EReference) getPortSpecification().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeaturePrototypeReference() {
		if (featurePrototypeReferenceEClass == null) {
			featurePrototypeReferenceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(140);
		}
		return featurePrototypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeaturePrototypeReference_Direction() {
		return (EAttribute) getFeaturePrototypeReference().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeaturePrototypeReference_Prototype() {
		return (EReference) getFeaturePrototypeReference().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessorCall() {
		if (processorCallEClass == null) {
			processorCallEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(143);
		}
		return processorCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessorCall_SubprogramAccessName() {
		return (EAttribute) getProcessorCall().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubprogramCall() {
		if (subprogramCallEClass == null) {
			subprogramCallEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(145);
		}
		return subprogramCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramCall_CalledSubprogram() {
		return (EReference) getSubprogramCall().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramCall_Context() {
		return (EReference) getSubprogramCall().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicPropertyAssociation() {
		if (basicPropertyAssociationEClass == null) {
			basicPropertyAssociationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(233);
		}
		return basicPropertyAssociationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicPropertyAssociation_Property() {
		return (EReference) getBasicPropertyAssociation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicPropertyAssociation_OwnedValue() {
		return (EReference) getBasicPropertyAssociation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyConstant() {
		if (propertyConstantEClass == null) {
			propertyConstantEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(234);
		}
		return propertyConstantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyConstant_PropertyType() {
		return (EReference) getPropertyConstant().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyConstant_OwnedPropertyType() {
		return (EReference) getPropertyConstant().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyConstant_ConstantValue() {
		return (EReference) getPropertyConstant().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractNamedValue() {
		if (abstractNamedValueEClass == null) {
			abstractNamedValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(11);
		}
		return abstractNamedValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArraySizeProperty() {
		if (arraySizePropertyEClass == null) {
			arraySizePropertyEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(12);
		}
		return arraySizePropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyValue() {
		if (propertyValueEClass == null) {
			propertyValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(236);
		}
		return propertyValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerationLiteral() {
		if (enumerationLiteralEClass == null) {
			enumerationLiteralEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(239);
		}
		return enumerationLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitLiteral() {
		if (unitLiteralEClass == null) {
			unitLiteralEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(238);
		}
		return unitLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitLiteral_BaseUnit() {
		return (EReference) getUnitLiteral().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitLiteral_Factor() {
		return (EReference) getUnitLiteral().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumberValue() {
		if (numberValueEClass == null) {
			numberValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(237);
		}
		return numberValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumberValue_Unit() {
		return (EReference) getNumberValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringLiteral() {
		if (stringLiteralEClass == null) {
			stringLiteralEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(235);
		}
		return stringLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringLiteral_Value() {
		return (EAttribute) getStringLiteral().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifierValue() {
		if (classifierValueEClass == null) {
			classifierValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(240);
		}
		return classifierValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierValue_Classifier() {
		return (EReference) getClassifierValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceValue() {
		if (referenceValueEClass == null) {
			referenceValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(241);
		}
		return referenceValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanLiteral() {
		if (booleanLiteralEClass == null) {
			booleanLiteralEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(242);
		}
		return booleanLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanLiteral_Value() {
		return (EAttribute) getBooleanLiteral().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRangeValue() {
		if (rangeValueEClass == null) {
			rangeValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(243);
		}
		return rangeValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRangeValue_Minimum() {
		return (EReference) getRangeValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRangeValue_Maximum() {
		return (EReference) getRangeValue().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRangeValue_Delta() {
		return (EReference) getRangeValue().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerLiteral() {
		if (integerLiteralEClass == null) {
			integerLiteralEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(244);
		}
		return integerLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerLiteral_Base() {
		return (EAttribute) getIntegerLiteral().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerLiteral_Value() {
		return (EAttribute) getIntegerLiteral().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRealLiteral() {
		if (realLiteralEClass == null) {
			realLiteralEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(245);
		}
		return realLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRealLiteral_Value() {
		return (EAttribute) getRealLiteral().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperation() {
		if (operationEClass == null) {
			operationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(246);
		}
		return operationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperation_Op() {
		return (EAttribute) getOperation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperation_OwnedPropertyExpression() {
		return (EReference) getOperation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecordValue() {
		if (recordValueEClass == null) {
			recordValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(248);
		}
		return recordValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecordValue_OwnedFieldValue() {
		return (EReference) getRecordValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputedValue() {
		if (computedValueEClass == null) {
			computedValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(249);
		}
		return computedValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComputedValue_Function() {
		return (EAttribute) getComputedValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListValue() {
		if (listValueEClass == null) {
			listValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(250);
		}
		return listValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getListValue_OwnedListElement() {
		return (EReference) getListValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedValue() {
		if (namedValueEClass == null) {
			namedValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(251);
		}
		return namedValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedValue_NamedValue() {
		return (EReference) getNamedValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertySet() {
		if (propertySetEClass == null) {
			propertySetEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(252);
		}
		return propertySetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertySet_OwnedPropertyType() {
		return (EReference) getPropertySet().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertySet_OwnedProperty() {
		return (EReference) getPropertySet().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertySet_OwnedPropertyConstant() {
		return (EReference) getPropertySet().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertySet_ImportedUnit() {
		return (EReference) getPropertySet().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobalNamespace() {
		if (globalNamespaceEClass == null) {
			globalNamespaceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(253);
		}
		return globalNamespaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGlobalNamespace_Package() {
		return (EReference) getGlobalNamespace().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGlobalNamespace_PropertySet() {
		return (EReference) getGlobalNamespace().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNonListType() {
		if (nonListTypeEClass == null) {
			nonListTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(254);
		}
		return nonListTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAadlBoolean() {
		if (aadlBooleanEClass == null) {
			aadlBooleanEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(255);
		}
		return aadlBooleanEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAadlString() {
		if (aadlStringEClass == null) {
			aadlStringEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(256);
		}
		return aadlStringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAadlInteger() {
		if (aadlIntegerEClass == null) {
			aadlIntegerEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(257);
		}
		return aadlIntegerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumberType() {
		if (numberTypeEClass == null) {
			numberTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(258);
		}
		return numberTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumberType_OwnedUnitsType() {
		return (EReference) getNumberType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumberType_UnitsType() {
		return (EReference) getNumberType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumberType_Range() {
		return (EReference) getNumberType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitsType() {
		if (unitsTypeEClass == null) {
			unitsTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(259);
		}
		return unitsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerationType() {
		if (enumerationTypeEClass == null) {
			enumerationTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(260);
		}
		return enumerationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumerationType_OwnedLiteral() {
		return (EReference) getEnumerationType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumericRange() {
		if (numericRangeEClass == null) {
			numericRangeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(261);
		}
		return numericRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumericRange_UpperBound() {
		return (EReference) getNumericRange().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumericRange_LowerBound() {
		return (EReference) getNumericRange().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAadlReal() {
		if (aadlRealEClass == null) {
			aadlRealEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(262);
		}
		return aadlRealEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifierType() {
		if (classifierTypeEClass == null) {
			classifierTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(263);
		}
		return classifierTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierType_ClassifierReference() {
		return (EReference) getClassifierType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRangeType() {
		if (rangeTypeEClass == null) {
			rangeTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(264);
		}
		return rangeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRangeType_OwnedNumberType() {
		return (EReference) getRangeType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRangeType_NumberType() {
		return (EReference) getRangeType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecordType() {
		if (recordTypeEClass == null) {
			recordTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(265);
		}
		return recordTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecordType_OwnedField() {
		return (EReference) getRecordType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecordField() {
		if (recordFieldEClass == null) {
			recordFieldEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(266);
		}
		return recordFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceType() {
		if (referenceTypeEClass == null) {
			referenceTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(267);
		}
		return referenceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceType_NamedElementReference() {
		return (EReference) getReferenceType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListType() {
		if (listTypeEClass == null) {
			listTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(268);
		}
		return listTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getListType_OwnedElementType() {
		return (EReference) getListType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getListType_ElementType() {
		return (EReference) getListType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDirectionType() {
		if (directionTypeEEnum == null) {
			directionTypeEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(65);
		}
		return directionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPortCategory() {
		if (portCategoryEEnum == null) {
			portCategoryEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(84);
		}
		return portCategoryEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFlowKind() {
		if (flowKindEEnum == null) {
			flowKindEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(58);
		}
		return flowKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAccessType() {
		if (accessTypeEEnum == null) {
			accessTypeEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(73);
		}
		return accessTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAccessCategory() {
		if (accessCategoryEEnum == null) {
			accessCategoryEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(74);
		}
		return accessCategoryEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getComponentCategory() {
		if (componentCategoryEEnum == null) {
			componentCategoryEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(115);
		}
		return componentCategoryEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConnectionKind() {
		if (connectionKindEEnum == null) {
			connectionKindEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(116);
		}
		return connectionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getElementNameKind() {
		if (elementNameKindEEnum == null) {
			elementNameKindEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(119);
		}
		return elementNameKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOperationKind() {
		if (operationKindEEnum == null) {
			operationKindEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(247);
		}
		return operationKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getString() {
		if (stringEDataType == null) {
			stringEDataType = (EDataType) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(2);
		}
		return stringEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getBoolean() {
		if (booleanEDataType == null) {
			booleanEDataType = (EDataType) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(3);
		}
		return booleanEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getInteger() {
		if (integerEDataType == null) {
			integerEDataType = (EDataType) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI)
					.getEClassifiers().get(34);
		}
		return integerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getReal() {
		if (realEDataType == null) {
			realEDataType = (EDataType) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI).getEClassifiers()
					.get(37);
		}
		return realEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Aadl2Factory getAadl2Factory() {
		return (Aadl2Factory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isLoaded = false;

	/**
	 * Laods the package and any sub-packages from their serialized form.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void loadPackage() {
		if (isLoaded)
			return;
		isLoaded = true;

		URL url = getClass().getResource(packageFilename);
		if (url == null) {
			throw new RuntimeException("Missing serialized package: " + packageFilename);
		}
		URI uri = URI.createURI(url.toString());
		Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
		try {
			resource.load(null);
		} catch (IOException exception) {
			throw new WrappedException(exception);
		}
		initializeFromLoadedEPackage(this, (EPackage) resource.getContents().get(0));
		createResource(eNS_URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isFixed = false;

	/**
	 * Fixes up the loaded package, to make it appear as if it had been programmatically built.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fixPackageContents() {
		if (isFixed)
			return;
		isFixed = true;
		fixEClassifiers();
	}

	/**
	 * Sets the instance class on the given classifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void fixInstanceClass(EClassifier eClassifier) {
		if (eClassifier.getInstanceClassName() == null) {
			eClassifier.setInstanceClassName("org.osate.aadl2." + eClassifier.getName());
			setGeneratedClassName(eClassifier);
		}
	}

} //Aadl2PackageImpl
