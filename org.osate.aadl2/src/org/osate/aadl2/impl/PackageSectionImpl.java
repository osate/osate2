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
 * $Id: PackageSectionImpl.java,v 1.43 2011-04-11 13:35:52 lwrage Exp $
 */
package org.osate.aadl2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.BusImplementation;
import org.osate.aadl2.BusType;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentTypeRename;
import org.osate.aadl2.DataImplementation;
import org.osate.aadl2.DataType;
import org.osate.aadl2.DeviceImplementation;
import org.osate.aadl2.DeviceType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeatureGroupTypeRename;
import org.osate.aadl2.MemoryImplementation;
import org.osate.aadl2.MemoryType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageRename;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.ProcessType;
import org.osate.aadl2.ProcessorImplementation;
import org.osate.aadl2.ProcessorType;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.SubprogramGroupImplementation;
import org.osate.aadl2.SubprogramGroupType;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.SystemType;
import org.osate.aadl2.ThreadGroupImplementation;
import org.osate.aadl2.ThreadGroupType;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.ThreadType;
import org.osate.aadl2.VirtualBusImplementation;
import org.osate.aadl2.VirtualBusType;
import org.osate.aadl2.VirtualProcessorImplementation;
import org.osate.aadl2.VirtualProcessorType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Section</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedMembers <em>Owned Member</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedClassifiers <em>Owned Classifier</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedPackageRenames <em>Owned Package Rename</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedComponentTypeRenames <em>Owned Component Type Rename</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedFeatureGroupTypeRenames <em>Owned Feature Group Type Rename</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedAnnexLibraries <em>Owned Annex Library</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getImportedPackages <em>Imported Package</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#isNoAnnexes <em>No Annexes</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedAbstractTypes <em>Owned Abstract Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedAbstractImplementations <em>Owned Abstract Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedBusTypes <em>Owned Bus Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedBusImplementations <em>Owned Bus Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedDataTypes <em>Owned Data Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedDataImplementations <em>Owned Data Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedDeviceTypes <em>Owned Device Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedDeviceImplementations <em>Owned Device Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedMemoryTypes <em>Owned Memory Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedMemoryImplementations <em>Owned Memory Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedProcessTypes <em>Owned Process Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedProcessorTypes <em>Owned Processor Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedProcessImplementations <em>Owned Process Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedProcessorImplementations <em>Owned Processor Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedSubprogramTypes <em>Owned Subprogram Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedSubprogramImplementations <em>Owned Subprogram Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedSubprogramGroupTypes <em>Owned Subprogram Group Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedSubprogramGroupImplementations <em>Owned Subprogram Group Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedSystemTypes <em>Owned System Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedSystemImplementations <em>Owned System Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedThreadTypes <em>Owned Thread Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedThreadImplementations <em>Owned Thread Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedThreadGroupTypes <em>Owned Thread Group Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedThreadGroupImplementations <em>Owned Thread Group Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedVirtualBusTypes <em>Owned Virtual Bus Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedVirtualBusImplementations <em>Owned Virtual Bus Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedVirtualProcessorTypes <em>Owned Virtual Processor Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedVirtualProcessorImplementations <em>Owned Virtual Processor Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedFeatureGroupTypes <em>Owned Feature Group Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#isNoProperties <em>No Properties</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getImportedPropertySets <em>Imported Property Set</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PackageSectionImpl extends NamespaceImpl implements
		PackageSection {
	/**
	 * The cached value of the '{@link #getOwnedPackageRenames() <em>Owned Package Rename</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPackageRenames()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageRename> ownedPackageRenames;

	/**
	 * The cached value of the '{@link #getOwnedComponentTypeRenames() <em>Owned Component Type Rename</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedComponentTypeRenames()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentTypeRename> ownedComponentTypeRenames;

	/**
	 * The cached value of the '{@link #getOwnedFeatureGroupTypeRenames() <em>Owned Feature Group Type Rename</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedFeatureGroupTypeRenames()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureGroupTypeRename> ownedFeatureGroupTypeRenames;

	/**
	 * The cached value of the '{@link #getOwnedAnnexLibraries() <em>Owned Annex Library</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAnnexLibraries()
	 * @generated
	 * @ordered
	 */
	protected EList<AnnexLibrary> ownedAnnexLibraries;

	/**
	 * The cached value of the '{@link #getImportedPackages() <em>Imported Package</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<AadlPackage> importedPackages;

	/**
	 * The default value of the '{@link #isNoAnnexes() <em>No Annexes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoAnnexes()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NO_ANNEXES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNoAnnexes() <em>No Annexes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoAnnexes()
	 * @generated
	 * @ordered
	 */
	protected boolean noAnnexes = NO_ANNEXES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedAbstractTypes() <em>Owned Abstract Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAbstractTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractType> ownedAbstractTypes;

	/**
	 * The cached value of the '{@link #getOwnedAbstractImplementations() <em>Owned Abstract Implementation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAbstractImplementations()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractImplementation> ownedAbstractImplementations;

	/**
	 * The cached value of the '{@link #getOwnedBusTypes() <em>Owned Bus Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedBusTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<BusType> ownedBusTypes;

	/**
	 * The cached value of the '{@link #getOwnedBusImplementations() <em>Owned Bus Implementation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedBusImplementations()
	 * @generated
	 * @ordered
	 */
	protected EList<BusImplementation> ownedBusImplementations;

	/**
	 * The cached value of the '{@link #getOwnedDataTypes() <em>Owned Data Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDataTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<DataType> ownedDataTypes;

	/**
	 * The cached value of the '{@link #getOwnedDataImplementations() <em>Owned Data Implementation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDataImplementations()
	 * @generated
	 * @ordered
	 */
	protected EList<DataImplementation> ownedDataImplementations;

	/**
	 * The cached value of the '{@link #getOwnedDeviceTypes() <em>Owned Device Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDeviceTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<DeviceType> ownedDeviceTypes;

	/**
	 * The cached value of the '{@link #getOwnedDeviceImplementations() <em>Owned Device Implementation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDeviceImplementations()
	 * @generated
	 * @ordered
	 */
	protected EList<DeviceImplementation> ownedDeviceImplementations;

	/**
	 * The cached value of the '{@link #getOwnedMemoryTypes() <em>Owned Memory Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMemoryTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<MemoryType> ownedMemoryTypes;

	/**
	 * The cached value of the '{@link #getOwnedMemoryImplementations() <em>Owned Memory Implementation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMemoryImplementations()
	 * @generated
	 * @ordered
	 */
	protected EList<MemoryImplementation> ownedMemoryImplementations;

	/**
	 * The cached value of the '{@link #getOwnedProcessTypes() <em>Owned Process Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedProcessTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessType> ownedProcessTypes;

	/**
	 * The cached value of the '{@link #getOwnedProcessorTypes() <em>Owned Processor Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedProcessorTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessorType> ownedProcessorTypes;

	/**
	 * The cached value of the '{@link #getOwnedProcessImplementations() <em>Owned Process Implementation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedProcessImplementations()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessImplementation> ownedProcessImplementations;

	/**
	 * The cached value of the '{@link #getOwnedProcessorImplementations() <em>Owned Processor Implementation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedProcessorImplementations()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessorImplementation> ownedProcessorImplementations;

	/**
	 * The cached value of the '{@link #getOwnedSubprogramTypes() <em>Owned Subprogram Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubprogramTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<SubprogramType> ownedSubprogramTypes;

	/**
	 * The cached value of the '{@link #getOwnedSubprogramImplementations() <em>Owned Subprogram Implementation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubprogramImplementations()
	 * @generated
	 * @ordered
	 */
	protected EList<SubprogramImplementation> ownedSubprogramImplementations;

	/**
	 * The cached value of the '{@link #getOwnedSubprogramGroupTypes() <em>Owned Subprogram Group Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubprogramGroupTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<SubprogramGroupType> ownedSubprogramGroupTypes;

	/**
	 * The cached value of the '{@link #getOwnedSubprogramGroupImplementations() <em>Owned Subprogram Group Implementation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubprogramGroupImplementations()
	 * @generated
	 * @ordered
	 */
	protected EList<SubprogramGroupImplementation> ownedSubprogramGroupImplementations;

	/**
	 * The cached value of the '{@link #getOwnedSystemTypes() <em>Owned System Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSystemTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemType> ownedSystemTypes;

	/**
	 * The cached value of the '{@link #getOwnedSystemImplementations() <em>Owned System Implementation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSystemImplementations()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemImplementation> ownedSystemImplementations;

	/**
	 * The cached value of the '{@link #getOwnedThreadTypes() <em>Owned Thread Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedThreadTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ThreadType> ownedThreadTypes;

	/**
	 * The cached value of the '{@link #getOwnedThreadImplementations() <em>Owned Thread Implementation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedThreadImplementations()
	 * @generated
	 * @ordered
	 */
	protected EList<ThreadImplementation> ownedThreadImplementations;

	/**
	 * The cached value of the '{@link #getOwnedThreadGroupTypes() <em>Owned Thread Group Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedThreadGroupTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ThreadGroupType> ownedThreadGroupTypes;

	/**
	 * The cached value of the '{@link #getOwnedThreadGroupImplementations() <em>Owned Thread Group Implementation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedThreadGroupImplementations()
	 * @generated
	 * @ordered
	 */
	protected EList<ThreadGroupImplementation> ownedThreadGroupImplementations;

	/**
	 * The cached value of the '{@link #getOwnedVirtualBusTypes() <em>Owned Virtual Bus Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedVirtualBusTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<VirtualBusType> ownedVirtualBusTypes;

	/**
	 * The cached value of the '{@link #getOwnedVirtualBusImplementations() <em>Owned Virtual Bus Implementation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedVirtualBusImplementations()
	 * @generated
	 * @ordered
	 */
	protected EList<VirtualBusImplementation> ownedVirtualBusImplementations;

	/**
	 * The cached value of the '{@link #getOwnedVirtualProcessorTypes() <em>Owned Virtual Processor Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedVirtualProcessorTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<VirtualProcessorType> ownedVirtualProcessorTypes;

	/**
	 * The cached value of the '{@link #getOwnedVirtualProcessorImplementations() <em>Owned Virtual Processor Implementation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedVirtualProcessorImplementations()
	 * @generated
	 * @ordered
	 */
	protected EList<VirtualProcessorImplementation> ownedVirtualProcessorImplementations;

	/**
	 * The cached value of the '{@link #getOwnedFeatureGroupTypes() <em>Owned Feature Group Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedFeatureGroupTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureGroupType> ownedFeatureGroupTypes;

	/**
	 * The default value of the '{@link #isNoProperties() <em>No Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoProperties()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NO_PROPERTIES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNoProperties() <em>No Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoProperties()
	 * @generated
	 * @ordered
	 */
	protected boolean noProperties = NO_PROPERTIES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImportedPropertySets() <em>Imported Property Set</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedPropertySets()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertySet> importedPropertySets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageSectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getPackageSection();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NamedElement> getOwnedMembers() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<NamedElement> ownedMembers = (EList<NamedElement>) cache.get(
					eResource, this,
					Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			if (ownedMembers == null) {
				cache.put(
						eResource,
						this,
						Aadl2Package.eINSTANCE.getNamespace_OwnedMember(),
						ownedMembers = new DerivedUnionEObjectEList<NamedElement>(
								NamedElement.class, this,
								Aadl2Package.PACKAGE_SECTION__OWNED_MEMBER,
								OWNED_MEMBER_ESUBSETS));
			}
			return ownedMembers;
		}
		return new DerivedUnionEObjectEList<NamedElement>(NamedElement.class,
				this, Aadl2Package.PACKAGE_SECTION__OWNED_MEMBER,
				OWNED_MEMBER_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedMembers() <em>Owned Member</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMembers()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_MEMBER_ESUBSETS = new int[] {
			Aadl2Package.PACKAGE_SECTION__OWNED_PACKAGE_RENAME,
			Aadl2Package.PACKAGE_SECTION__OWNED_COMPONENT_TYPE_RENAME,
			Aadl2Package.PACKAGE_SECTION__OWNED_CLASSIFIER,
			Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE_RENAME,
			Aadl2Package.PACKAGE_SECTION__OWNED_ANNEX_LIBRARY };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classifier> getOwnedClassifiers() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<Classifier> ownedClassifiers = (EList<Classifier>) cache.get(
					eResource, this,
					Aadl2Package.eINSTANCE.getPackageSection_OwnedClassifier());
			if (ownedClassifiers == null) {
				cache.put(
						eResource,
						this,
						Aadl2Package.eINSTANCE
								.getPackageSection_OwnedClassifier(),
						ownedClassifiers = new DerivedUnionEObjectEList<Classifier>(
								Classifier.class, this,
								Aadl2Package.PACKAGE_SECTION__OWNED_CLASSIFIER,
								OWNED_CLASSIFIER_ESUBSETS));
			}
			return ownedClassifiers;
		}
		return new DerivedUnionEObjectEList<Classifier>(Classifier.class, this,
				Aadl2Package.PACKAGE_SECTION__OWNED_CLASSIFIER,
				OWNED_CLASSIFIER_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedClassifiers() <em>Owned Classifier</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedClassifiers()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_CLASSIFIER_ESUBSETS = new int[] {
			Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_TYPE,
			Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_IMPLEMENTATION,
			Aadl2Package.PACKAGE_SECTION__OWNED_BUS_TYPE,
			Aadl2Package.PACKAGE_SECTION__OWNED_BUS_IMPLEMENTATION,
			Aadl2Package.PACKAGE_SECTION__OWNED_DATA_TYPE,
			Aadl2Package.PACKAGE_SECTION__OWNED_DATA_IMPLEMENTATION,
			Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_TYPE,
			Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_IMPLEMENTATION,
			Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_TYPE,
			Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_IMPLEMENTATION,
			Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_TYPE,
			Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_TYPE,
			Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_IMPLEMENTATION,
			Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_IMPLEMENTATION,
			Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_TYPE,
			Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_IMPLEMENTATION,
			Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_TYPE,
			Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_IMPLEMENTATION,
			Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_TYPE,
			Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_IMPLEMENTATION,
			Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_TYPE,
			Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_IMPLEMENTATION,
			Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_GROUP_TYPE,
			Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_GROUP_IMPLEMENTATION,
			Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_BUS_TYPE,
			Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_BUS_IMPLEMENTATION,
			Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_PROCESSOR_TYPE,
			Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_PROCESSOR_IMPLEMENTATION,
			Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PackageRename> getOwnedPackageRenames() {
		if (ownedPackageRenames == null) {
			ownedPackageRenames = new EObjectContainmentEList<PackageRename>(
					PackageRename.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_PACKAGE_RENAME);
		}
		return ownedPackageRenames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageRename createOwnedPackageRename() {
		PackageRename newOwnedPackageRename = (PackageRename) create(Aadl2Package.eINSTANCE
				.getPackageRename());
		getOwnedPackageRenames().add(newOwnedPackageRename);
		return newOwnedPackageRename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentTypeRename> getOwnedComponentTypeRenames() {
		if (ownedComponentTypeRenames == null) {
			ownedComponentTypeRenames = new EObjectContainmentEList<ComponentTypeRename>(
					ComponentTypeRename.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_COMPONENT_TYPE_RENAME);
		}
		return ownedComponentTypeRenames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentTypeRename createOwnedComponentTypeRename() {
		ComponentTypeRename newOwnedComponentTypeRename = (ComponentTypeRename) create(Aadl2Package.eINSTANCE
				.getComponentTypeRename());
		getOwnedComponentTypeRenames().add(newOwnedComponentTypeRename);
		return newOwnedComponentTypeRename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNoProperties() {
		return noProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoProperties(boolean newNoProperties) {
		boolean oldNoProperties = noProperties;
		noProperties = newNoProperties;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.PACKAGE_SECTION__NO_PROPERTIES,
					oldNoProperties, noProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertySet> getImportedPropertySets() {
		if (importedPropertySets == null) {
			importedPropertySets = new EObjectResolvingEList<PropertySet>(
					PropertySet.class, this,
					Aadl2Package.PACKAGE_SECTION__IMPORTED_PROPERTY_SET);
		}
		return importedPropertySets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNoAnnexes() {
		return noAnnexes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoAnnexes(boolean newNoAnnexes) {
		boolean oldNoAnnexes = noAnnexes;
		noAnnexes = newNoAnnexes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.PACKAGE_SECTION__NO_ANNEXES, oldNoAnnexes,
					noAnnexes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureGroupTypeRename> getOwnedFeatureGroupTypeRenames() {
		if (ownedFeatureGroupTypeRenames == null) {
			ownedFeatureGroupTypeRenames = new EObjectContainmentEList<FeatureGroupTypeRename>(
					FeatureGroupTypeRename.class,
					this,
					Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE_RENAME);
		}
		return ownedFeatureGroupTypeRenames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureGroupTypeRename createOwnedFeatureGroupTypeRename() {
		FeatureGroupTypeRename newOwnedFeatureGroupTypeRename = (FeatureGroupTypeRename) create(Aadl2Package.eINSTANCE
				.getFeatureGroupTypeRename());
		getOwnedFeatureGroupTypeRenames().add(newOwnedFeatureGroupTypeRename);
		return newOwnedFeatureGroupTypeRename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnnexLibrary> getOwnedAnnexLibraries() {
		if (ownedAnnexLibraries == null) {
			ownedAnnexLibraries = new EObjectContainmentEList<AnnexLibrary>(
					AnnexLibrary.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_ANNEX_LIBRARY);
		}
		return ownedAnnexLibraries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnexLibrary createOwnedAnnexLibrary(EClass eClass) {
		AnnexLibrary newOwnedAnnexLibrary = (AnnexLibrary) create(eClass);
		getOwnedAnnexLibraries().add(newOwnedAnnexLibrary);
		return newOwnedAnnexLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnexLibrary createOwnedAnnexLibrary() {
		return createOwnedAnnexLibrary(Aadl2Package.eINSTANCE.getAnnexLibrary());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AadlPackage> getImportedPackages() {
		if (importedPackages == null) {
			importedPackages = new EObjectResolvingEList<AadlPackage>(
					AadlPackage.class, this,
					Aadl2Package.PACKAGE_SECTION__IMPORTED_PACKAGE);
		}
		return importedPackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractType> getOwnedAbstractTypes() {
		if (ownedAbstractTypes == null) {
			ownedAbstractTypes = new EObjectContainmentEList<AbstractType>(
					AbstractType.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_TYPE);
		}
		return ownedAbstractTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractType createOwnedAbstractType() {
		AbstractType newOwnedAbstractType = (AbstractType) create(Aadl2Package.eINSTANCE
				.getAbstractType());
		getOwnedAbstractTypes().add(newOwnedAbstractType);
		return newOwnedAbstractType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractImplementation> getOwnedAbstractImplementations() {
		if (ownedAbstractImplementations == null) {
			ownedAbstractImplementations = new EObjectContainmentEList<AbstractImplementation>(
					AbstractImplementation.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_IMPLEMENTATION);
		}
		return ownedAbstractImplementations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractImplementation createOwnedAbstractImplementation() {
		AbstractImplementation newOwnedAbstractImplementation = (AbstractImplementation) create(Aadl2Package.eINSTANCE
				.getAbstractImplementation());
		getOwnedAbstractImplementations().add(newOwnedAbstractImplementation);
		return newOwnedAbstractImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BusType> getOwnedBusTypes() {
		if (ownedBusTypes == null) {
			ownedBusTypes = new EObjectContainmentEList<BusType>(BusType.class,
					this, Aadl2Package.PACKAGE_SECTION__OWNED_BUS_TYPE);
		}
		return ownedBusTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusType createOwnedBusType() {
		BusType newOwnedBusType = (BusType) create(Aadl2Package.eINSTANCE
				.getBusType());
		getOwnedBusTypes().add(newOwnedBusType);
		return newOwnedBusType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BusImplementation> getOwnedBusImplementations() {
		if (ownedBusImplementations == null) {
			ownedBusImplementations = new EObjectContainmentEList<BusImplementation>(
					BusImplementation.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_BUS_IMPLEMENTATION);
		}
		return ownedBusImplementations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusImplementation createOwnedBusImplementation() {
		BusImplementation newOwnedBusImplementation = (BusImplementation) create(Aadl2Package.eINSTANCE
				.getBusImplementation());
		getOwnedBusImplementations().add(newOwnedBusImplementation);
		return newOwnedBusImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataType> getOwnedDataTypes() {
		if (ownedDataTypes == null) {
			ownedDataTypes = new EObjectContainmentEList<DataType>(
					DataType.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_DATA_TYPE);
		}
		return ownedDataTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType createOwnedDataType() {
		DataType newOwnedDataType = (DataType) create(Aadl2Package.eINSTANCE
				.getDataType());
		getOwnedDataTypes().add(newOwnedDataType);
		return newOwnedDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataImplementation> getOwnedDataImplementations() {
		if (ownedDataImplementations == null) {
			ownedDataImplementations = new EObjectContainmentEList<DataImplementation>(
					DataImplementation.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_DATA_IMPLEMENTATION);
		}
		return ownedDataImplementations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataImplementation createOwnedDataImplementation() {
		DataImplementation newOwnedDataImplementation = (DataImplementation) create(Aadl2Package.eINSTANCE
				.getDataImplementation());
		getOwnedDataImplementations().add(newOwnedDataImplementation);
		return newOwnedDataImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeviceType> getOwnedDeviceTypes() {
		if (ownedDeviceTypes == null) {
			ownedDeviceTypes = new EObjectContainmentEList<DeviceType>(
					DeviceType.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_TYPE);
		}
		return ownedDeviceTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeviceType createOwnedDeviceType() {
		DeviceType newOwnedDeviceType = (DeviceType) create(Aadl2Package.eINSTANCE
				.getDeviceType());
		getOwnedDeviceTypes().add(newOwnedDeviceType);
		return newOwnedDeviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeviceImplementation> getOwnedDeviceImplementations() {
		if (ownedDeviceImplementations == null) {
			ownedDeviceImplementations = new EObjectContainmentEList<DeviceImplementation>(
					DeviceImplementation.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_IMPLEMENTATION);
		}
		return ownedDeviceImplementations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeviceImplementation createOwnedDeviceImplementation() {
		DeviceImplementation newOwnedDeviceImplementation = (DeviceImplementation) create(Aadl2Package.eINSTANCE
				.getDeviceImplementation());
		getOwnedDeviceImplementations().add(newOwnedDeviceImplementation);
		return newOwnedDeviceImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MemoryType> getOwnedMemoryTypes() {
		if (ownedMemoryTypes == null) {
			ownedMemoryTypes = new EObjectContainmentEList<MemoryType>(
					MemoryType.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_TYPE);
		}
		return ownedMemoryTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryType createOwnedMemoryType() {
		MemoryType newOwnedMemoryType = (MemoryType) create(Aadl2Package.eINSTANCE
				.getMemoryType());
		getOwnedMemoryTypes().add(newOwnedMemoryType);
		return newOwnedMemoryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MemoryImplementation> getOwnedMemoryImplementations() {
		if (ownedMemoryImplementations == null) {
			ownedMemoryImplementations = new EObjectContainmentEList<MemoryImplementation>(
					MemoryImplementation.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_IMPLEMENTATION);
		}
		return ownedMemoryImplementations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryImplementation createOwnedMemoryImplementation() {
		MemoryImplementation newOwnedMemoryImplementation = (MemoryImplementation) create(Aadl2Package.eINSTANCE
				.getMemoryImplementation());
		getOwnedMemoryImplementations().add(newOwnedMemoryImplementation);
		return newOwnedMemoryImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcessType> getOwnedProcessTypes() {
		if (ownedProcessTypes == null) {
			ownedProcessTypes = new EObjectContainmentEList<ProcessType>(
					ProcessType.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_TYPE);
		}
		return ownedProcessTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessType createOwnedProcessType() {
		ProcessType newOwnedProcessType = (ProcessType) create(Aadl2Package.eINSTANCE
				.getProcessType());
		getOwnedProcessTypes().add(newOwnedProcessType);
		return newOwnedProcessType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcessorType> getOwnedProcessorTypes() {
		if (ownedProcessorTypes == null) {
			ownedProcessorTypes = new EObjectContainmentEList<ProcessorType>(
					ProcessorType.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_TYPE);
		}
		return ownedProcessorTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessorType createOwnedProcessorType() {
		ProcessorType newOwnedProcessorType = (ProcessorType) create(Aadl2Package.eINSTANCE
				.getProcessorType());
		getOwnedProcessorTypes().add(newOwnedProcessorType);
		return newOwnedProcessorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcessImplementation> getOwnedProcessImplementations() {
		if (ownedProcessImplementations == null) {
			ownedProcessImplementations = new EObjectContainmentEList<ProcessImplementation>(
					ProcessImplementation.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_IMPLEMENTATION);
		}
		return ownedProcessImplementations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessImplementation createOwnedProcessImplementation() {
		ProcessImplementation newOwnedProcessImplementation = (ProcessImplementation) create(Aadl2Package.eINSTANCE
				.getProcessImplementation());
		getOwnedProcessImplementations().add(newOwnedProcessImplementation);
		return newOwnedProcessImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcessorImplementation> getOwnedProcessorImplementations() {
		if (ownedProcessorImplementations == null) {
			ownedProcessorImplementations = new EObjectContainmentEList<ProcessorImplementation>(
					ProcessorImplementation.class,
					this,
					Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_IMPLEMENTATION);
		}
		return ownedProcessorImplementations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessorImplementation createOwnedProcessorImplementation() {
		ProcessorImplementation newOwnedProcessorImplementation = (ProcessorImplementation) create(Aadl2Package.eINSTANCE
				.getProcessorImplementation());
		getOwnedProcessorImplementations().add(newOwnedProcessorImplementation);
		return newOwnedProcessorImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureGroupType> getOwnedFeatureGroupTypes() {
		if (ownedFeatureGroupTypes == null) {
			ownedFeatureGroupTypes = new EObjectContainmentEList<FeatureGroupType>(
					FeatureGroupType.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE);
		}
		return ownedFeatureGroupTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureGroupType createOwnedFeatureGroupType() {
		FeatureGroupType newOwnedFeatureGroupType = (FeatureGroupType) create(Aadl2Package.eINSTANCE
				.getFeatureGroupType());
		getOwnedFeatureGroupTypes().add(newOwnedFeatureGroupType);
		return newOwnedFeatureGroupType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VirtualProcessorImplementation> getOwnedVirtualProcessorImplementations() {
		if (ownedVirtualProcessorImplementations == null) {
			ownedVirtualProcessorImplementations = new EObjectContainmentEList<VirtualProcessorImplementation>(
					VirtualProcessorImplementation.class,
					this,
					Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_PROCESSOR_IMPLEMENTATION);
		}
		return ownedVirtualProcessorImplementations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualProcessorImplementation createOwnedVirtualProcessorImplementation() {
		VirtualProcessorImplementation newOwnedVirtualProcessorImplementation = (VirtualProcessorImplementation) create(Aadl2Package.eINSTANCE
				.getVirtualProcessorImplementation());
		getOwnedVirtualProcessorImplementations().add(
				newOwnedVirtualProcessorImplementation);
		return newOwnedVirtualProcessorImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VirtualProcessorType> getOwnedVirtualProcessorTypes() {
		if (ownedVirtualProcessorTypes == null) {
			ownedVirtualProcessorTypes = new EObjectContainmentEList<VirtualProcessorType>(
					VirtualProcessorType.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_PROCESSOR_TYPE);
		}
		return ownedVirtualProcessorTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualProcessorType createOwnedVirtualProcessorType() {
		VirtualProcessorType newOwnedVirtualProcessorType = (VirtualProcessorType) create(Aadl2Package.eINSTANCE
				.getVirtualProcessorType());
		getOwnedVirtualProcessorTypes().add(newOwnedVirtualProcessorType);
		return newOwnedVirtualProcessorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ThreadGroupImplementation> getOwnedThreadGroupImplementations() {
		if (ownedThreadGroupImplementations == null) {
			ownedThreadGroupImplementations = new EObjectContainmentEList<ThreadGroupImplementation>(
					ThreadGroupImplementation.class,
					this,
					Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_GROUP_IMPLEMENTATION);
		}
		return ownedThreadGroupImplementations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreadGroupImplementation createOwnedThreadGroupImplementation() {
		ThreadGroupImplementation newOwnedThreadGroupImplementation = (ThreadGroupImplementation) create(Aadl2Package.eINSTANCE
				.getThreadGroupImplementation());
		getOwnedThreadGroupImplementations().add(
				newOwnedThreadGroupImplementation);
		return newOwnedThreadGroupImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ThreadImplementation> getOwnedThreadImplementations() {
		if (ownedThreadImplementations == null) {
			ownedThreadImplementations = new EObjectContainmentEList<ThreadImplementation>(
					ThreadImplementation.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_IMPLEMENTATION);
		}
		return ownedThreadImplementations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreadImplementation createOwnedThreadImplementation() {
		ThreadImplementation newOwnedThreadImplementation = (ThreadImplementation) create(Aadl2Package.eINSTANCE
				.getThreadImplementation());
		getOwnedThreadImplementations().add(newOwnedThreadImplementation);
		return newOwnedThreadImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VirtualBusType> getOwnedVirtualBusTypes() {
		if (ownedVirtualBusTypes == null) {
			ownedVirtualBusTypes = new EObjectContainmentEList<VirtualBusType>(
					VirtualBusType.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_BUS_TYPE);
		}
		return ownedVirtualBusTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualBusType createOwnedVirtualBusType() {
		VirtualBusType newOwnedVirtualBusType = (VirtualBusType) create(Aadl2Package.eINSTANCE
				.getVirtualBusType());
		getOwnedVirtualBusTypes().add(newOwnedVirtualBusType);
		return newOwnedVirtualBusType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ThreadGroupType> getOwnedThreadGroupTypes() {
		if (ownedThreadGroupTypes == null) {
			ownedThreadGroupTypes = new EObjectContainmentEList<ThreadGroupType>(
					ThreadGroupType.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_GROUP_TYPE);
		}
		return ownedThreadGroupTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreadGroupType createOwnedThreadGroupType() {
		ThreadGroupType newOwnedThreadGroupType = (ThreadGroupType) create(Aadl2Package.eINSTANCE
				.getThreadGroupType());
		getOwnedThreadGroupTypes().add(newOwnedThreadGroupType);
		return newOwnedThreadGroupType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ThreadType> getOwnedThreadTypes() {
		if (ownedThreadTypes == null) {
			ownedThreadTypes = new EObjectContainmentEList<ThreadType>(
					ThreadType.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_TYPE);
		}
		return ownedThreadTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreadType createOwnedThreadType() {
		ThreadType newOwnedThreadType = (ThreadType) create(Aadl2Package.eINSTANCE
				.getThreadType());
		getOwnedThreadTypes().add(newOwnedThreadType);
		return newOwnedThreadType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemType> getOwnedSystemTypes() {
		if (ownedSystemTypes == null) {
			ownedSystemTypes = new EObjectContainmentEList<SystemType>(
					SystemType.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_TYPE);
		}
		return ownedSystemTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemType createOwnedSystemType() {
		SystemType newOwnedSystemType = (SystemType) create(Aadl2Package.eINSTANCE
				.getSystemType());
		getOwnedSystemTypes().add(newOwnedSystemType);
		return newOwnedSystemType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubprogramType> getOwnedSubprogramTypes() {
		if (ownedSubprogramTypes == null) {
			ownedSubprogramTypes = new EObjectContainmentEList<SubprogramType>(
					SubprogramType.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_TYPE);
		}
		return ownedSubprogramTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramType createOwnedSubprogramType() {
		SubprogramType newOwnedSubprogramType = (SubprogramType) create(Aadl2Package.eINSTANCE
				.getSubprogramType());
		getOwnedSubprogramTypes().add(newOwnedSubprogramType);
		return newOwnedSubprogramType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubprogramGroupType> getOwnedSubprogramGroupTypes() {
		if (ownedSubprogramGroupTypes == null) {
			ownedSubprogramGroupTypes = new EObjectContainmentEList<SubprogramGroupType>(
					SubprogramGroupType.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_TYPE);
		}
		return ownedSubprogramGroupTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramGroupType createOwnedSubprogramGroupType() {
		SubprogramGroupType newOwnedSubprogramGroupType = (SubprogramGroupType) create(Aadl2Package.eINSTANCE
				.getSubprogramGroupType());
		getOwnedSubprogramGroupTypes().add(newOwnedSubprogramGroupType);
		return newOwnedSubprogramGroupType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemImplementation> getOwnedSystemImplementations() {
		if (ownedSystemImplementations == null) {
			ownedSystemImplementations = new EObjectContainmentEList<SystemImplementation>(
					SystemImplementation.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_IMPLEMENTATION);
		}
		return ownedSystemImplementations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemImplementation createOwnedSystemImplementation() {
		SystemImplementation newOwnedSystemImplementation = (SystemImplementation) create(Aadl2Package.eINSTANCE
				.getSystemImplementation());
		getOwnedSystemImplementations().add(newOwnedSystemImplementation);
		return newOwnedSystemImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubprogramGroupImplementation> getOwnedSubprogramGroupImplementations() {
		if (ownedSubprogramGroupImplementations == null) {
			ownedSubprogramGroupImplementations = new EObjectContainmentEList<SubprogramGroupImplementation>(
					SubprogramGroupImplementation.class,
					this,
					Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_IMPLEMENTATION);
		}
		return ownedSubprogramGroupImplementations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramGroupImplementation createOwnedSubprogramGroupImplementation() {
		SubprogramGroupImplementation newOwnedSubprogramGroupImplementation = (SubprogramGroupImplementation) create(Aadl2Package.eINSTANCE
				.getSubprogramGroupImplementation());
		getOwnedSubprogramGroupImplementations().add(
				newOwnedSubprogramGroupImplementation);
		return newOwnedSubprogramGroupImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubprogramImplementation> getOwnedSubprogramImplementations() {
		if (ownedSubprogramImplementations == null) {
			ownedSubprogramImplementations = new EObjectContainmentEList<SubprogramImplementation>(
					SubprogramImplementation.class,
					this,
					Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_IMPLEMENTATION);
		}
		return ownedSubprogramImplementations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramImplementation createOwnedSubprogramImplementation() {
		SubprogramImplementation newOwnedSubprogramImplementation = (SubprogramImplementation) create(Aadl2Package.eINSTANCE
				.getSubprogramImplementation());
		getOwnedSubprogramImplementations().add(
				newOwnedSubprogramImplementation);
		return newOwnedSubprogramImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VirtualBusImplementation> getOwnedVirtualBusImplementations() {
		if (ownedVirtualBusImplementations == null) {
			ownedVirtualBusImplementations = new EObjectContainmentEList<VirtualBusImplementation>(
					VirtualBusImplementation.class,
					this,
					Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_BUS_IMPLEMENTATION);
		}
		return ownedVirtualBusImplementations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualBusImplementation createOwnedVirtualBusImplementation() {
		VirtualBusImplementation newOwnedVirtualBusImplementation = (VirtualBusImplementation) create(Aadl2Package.eINSTANCE
				.getVirtualBusImplementation());
		getOwnedVirtualBusImplementations().add(
				newOwnedVirtualBusImplementation);
		return newOwnedVirtualBusImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.PACKAGE_SECTION__OWNED_PACKAGE_RENAME:
			return ((InternalEList<?>) getOwnedPackageRenames()).basicRemove(
					otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_COMPONENT_TYPE_RENAME:
			return ((InternalEList<?>) getOwnedComponentTypeRenames())
					.basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE_RENAME:
			return ((InternalEList<?>) getOwnedFeatureGroupTypeRenames())
					.basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_ANNEX_LIBRARY:
			return ((InternalEList<?>) getOwnedAnnexLibraries()).basicRemove(
					otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_TYPE:
			return ((InternalEList<?>) getOwnedAbstractTypes()).basicRemove(
					otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_IMPLEMENTATION:
			return ((InternalEList<?>) getOwnedAbstractImplementations())
					.basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_BUS_TYPE:
			return ((InternalEList<?>) getOwnedBusTypes()).basicRemove(
					otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_BUS_IMPLEMENTATION:
			return ((InternalEList<?>) getOwnedBusImplementations())
					.basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_DATA_TYPE:
			return ((InternalEList<?>) getOwnedDataTypes()).basicRemove(
					otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_DATA_IMPLEMENTATION:
			return ((InternalEList<?>) getOwnedDataImplementations())
					.basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_TYPE:
			return ((InternalEList<?>) getOwnedDeviceTypes()).basicRemove(
					otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_IMPLEMENTATION:
			return ((InternalEList<?>) getOwnedDeviceImplementations())
					.basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_TYPE:
			return ((InternalEList<?>) getOwnedMemoryTypes()).basicRemove(
					otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_IMPLEMENTATION:
			return ((InternalEList<?>) getOwnedMemoryImplementations())
					.basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_TYPE:
			return ((InternalEList<?>) getOwnedProcessTypes()).basicRemove(
					otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_TYPE:
			return ((InternalEList<?>) getOwnedProcessorTypes()).basicRemove(
					otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_IMPLEMENTATION:
			return ((InternalEList<?>) getOwnedProcessImplementations())
					.basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_IMPLEMENTATION:
			return ((InternalEList<?>) getOwnedProcessorImplementations())
					.basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_TYPE:
			return ((InternalEList<?>) getOwnedSubprogramTypes()).basicRemove(
					otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_IMPLEMENTATION:
			return ((InternalEList<?>) getOwnedSubprogramImplementations())
					.basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_TYPE:
			return ((InternalEList<?>) getOwnedSubprogramGroupTypes())
					.basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_IMPLEMENTATION:
			return ((InternalEList<?>) getOwnedSubprogramGroupImplementations())
					.basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_TYPE:
			return ((InternalEList<?>) getOwnedSystemTypes()).basicRemove(
					otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_IMPLEMENTATION:
			return ((InternalEList<?>) getOwnedSystemImplementations())
					.basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_TYPE:
			return ((InternalEList<?>) getOwnedThreadTypes()).basicRemove(
					otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_IMPLEMENTATION:
			return ((InternalEList<?>) getOwnedThreadImplementations())
					.basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_GROUP_TYPE:
			return ((InternalEList<?>) getOwnedThreadGroupTypes()).basicRemove(
					otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_GROUP_IMPLEMENTATION:
			return ((InternalEList<?>) getOwnedThreadGroupImplementations())
					.basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_BUS_TYPE:
			return ((InternalEList<?>) getOwnedVirtualBusTypes()).basicRemove(
					otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_BUS_IMPLEMENTATION:
			return ((InternalEList<?>) getOwnedVirtualBusImplementations())
					.basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_PROCESSOR_TYPE:
			return ((InternalEList<?>) getOwnedVirtualProcessorTypes())
					.basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_PROCESSOR_IMPLEMENTATION:
			return ((InternalEList<?>) getOwnedVirtualProcessorImplementations())
					.basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE:
			return ((InternalEList<?>) getOwnedFeatureGroupTypes())
					.basicRemove(otherEnd, msgs);
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
		case Aadl2Package.PACKAGE_SECTION__OWNED_CLASSIFIER:
			return getOwnedClassifiers();
		case Aadl2Package.PACKAGE_SECTION__OWNED_PACKAGE_RENAME:
			return getOwnedPackageRenames();
		case Aadl2Package.PACKAGE_SECTION__OWNED_COMPONENT_TYPE_RENAME:
			return getOwnedComponentTypeRenames();
		case Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE_RENAME:
			return getOwnedFeatureGroupTypeRenames();
		case Aadl2Package.PACKAGE_SECTION__OWNED_ANNEX_LIBRARY:
			return getOwnedAnnexLibraries();
		case Aadl2Package.PACKAGE_SECTION__IMPORTED_PACKAGE:
			return getImportedPackages();
		case Aadl2Package.PACKAGE_SECTION__NO_ANNEXES:
			return isNoAnnexes();
		case Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_TYPE:
			return getOwnedAbstractTypes();
		case Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_IMPLEMENTATION:
			return getOwnedAbstractImplementations();
		case Aadl2Package.PACKAGE_SECTION__OWNED_BUS_TYPE:
			return getOwnedBusTypes();
		case Aadl2Package.PACKAGE_SECTION__OWNED_BUS_IMPLEMENTATION:
			return getOwnedBusImplementations();
		case Aadl2Package.PACKAGE_SECTION__OWNED_DATA_TYPE:
			return getOwnedDataTypes();
		case Aadl2Package.PACKAGE_SECTION__OWNED_DATA_IMPLEMENTATION:
			return getOwnedDataImplementations();
		case Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_TYPE:
			return getOwnedDeviceTypes();
		case Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_IMPLEMENTATION:
			return getOwnedDeviceImplementations();
		case Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_TYPE:
			return getOwnedMemoryTypes();
		case Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_IMPLEMENTATION:
			return getOwnedMemoryImplementations();
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_TYPE:
			return getOwnedProcessTypes();
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_TYPE:
			return getOwnedProcessorTypes();
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_IMPLEMENTATION:
			return getOwnedProcessImplementations();
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_IMPLEMENTATION:
			return getOwnedProcessorImplementations();
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_TYPE:
			return getOwnedSubprogramTypes();
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_IMPLEMENTATION:
			return getOwnedSubprogramImplementations();
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_TYPE:
			return getOwnedSubprogramGroupTypes();
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_IMPLEMENTATION:
			return getOwnedSubprogramGroupImplementations();
		case Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_TYPE:
			return getOwnedSystemTypes();
		case Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_IMPLEMENTATION:
			return getOwnedSystemImplementations();
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_TYPE:
			return getOwnedThreadTypes();
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_IMPLEMENTATION:
			return getOwnedThreadImplementations();
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_GROUP_TYPE:
			return getOwnedThreadGroupTypes();
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_GROUP_IMPLEMENTATION:
			return getOwnedThreadGroupImplementations();
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_BUS_TYPE:
			return getOwnedVirtualBusTypes();
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_BUS_IMPLEMENTATION:
			return getOwnedVirtualBusImplementations();
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_PROCESSOR_TYPE:
			return getOwnedVirtualProcessorTypes();
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_PROCESSOR_IMPLEMENTATION:
			return getOwnedVirtualProcessorImplementations();
		case Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE:
			return getOwnedFeatureGroupTypes();
		case Aadl2Package.PACKAGE_SECTION__NO_PROPERTIES:
			return isNoProperties();
		case Aadl2Package.PACKAGE_SECTION__IMPORTED_PROPERTY_SET:
			return getImportedPropertySets();
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
		case Aadl2Package.PACKAGE_SECTION__OWNED_PACKAGE_RENAME:
			getOwnedPackageRenames().clear();
			getOwnedPackageRenames().addAll(
					(Collection<? extends PackageRename>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_COMPONENT_TYPE_RENAME:
			getOwnedComponentTypeRenames().clear();
			getOwnedComponentTypeRenames().addAll(
					(Collection<? extends ComponentTypeRename>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE_RENAME:
			getOwnedFeatureGroupTypeRenames().clear();
			getOwnedFeatureGroupTypeRenames().addAll(
					(Collection<? extends FeatureGroupTypeRename>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_ANNEX_LIBRARY:
			getOwnedAnnexLibraries().clear();
			getOwnedAnnexLibraries().addAll(
					(Collection<? extends AnnexLibrary>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__IMPORTED_PACKAGE:
			getImportedPackages().clear();
			getImportedPackages().addAll(
					(Collection<? extends AadlPackage>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__NO_ANNEXES:
			setNoAnnexes((Boolean) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_TYPE:
			getOwnedAbstractTypes().clear();
			getOwnedAbstractTypes().addAll(
					(Collection<? extends AbstractType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_IMPLEMENTATION:
			getOwnedAbstractImplementations().clear();
			getOwnedAbstractImplementations().addAll(
					(Collection<? extends AbstractImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_BUS_TYPE:
			getOwnedBusTypes().clear();
			getOwnedBusTypes().addAll((Collection<? extends BusType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_BUS_IMPLEMENTATION:
			getOwnedBusImplementations().clear();
			getOwnedBusImplementations().addAll(
					(Collection<? extends BusImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_DATA_TYPE:
			getOwnedDataTypes().clear();
			getOwnedDataTypes().addAll(
					(Collection<? extends DataType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_DATA_IMPLEMENTATION:
			getOwnedDataImplementations().clear();
			getOwnedDataImplementations().addAll(
					(Collection<? extends DataImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_TYPE:
			getOwnedDeviceTypes().clear();
			getOwnedDeviceTypes().addAll(
					(Collection<? extends DeviceType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_IMPLEMENTATION:
			getOwnedDeviceImplementations().clear();
			getOwnedDeviceImplementations().addAll(
					(Collection<? extends DeviceImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_TYPE:
			getOwnedMemoryTypes().clear();
			getOwnedMemoryTypes().addAll(
					(Collection<? extends MemoryType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_IMPLEMENTATION:
			getOwnedMemoryImplementations().clear();
			getOwnedMemoryImplementations().addAll(
					(Collection<? extends MemoryImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_TYPE:
			getOwnedProcessTypes().clear();
			getOwnedProcessTypes().addAll(
					(Collection<? extends ProcessType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_TYPE:
			getOwnedProcessorTypes().clear();
			getOwnedProcessorTypes().addAll(
					(Collection<? extends ProcessorType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_IMPLEMENTATION:
			getOwnedProcessImplementations().clear();
			getOwnedProcessImplementations().addAll(
					(Collection<? extends ProcessImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_IMPLEMENTATION:
			getOwnedProcessorImplementations().clear();
			getOwnedProcessorImplementations().addAll(
					(Collection<? extends ProcessorImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_TYPE:
			getOwnedSubprogramTypes().clear();
			getOwnedSubprogramTypes().addAll(
					(Collection<? extends SubprogramType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_IMPLEMENTATION:
			getOwnedSubprogramImplementations().clear();
			getOwnedSubprogramImplementations().addAll(
					(Collection<? extends SubprogramImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_TYPE:
			getOwnedSubprogramGroupTypes().clear();
			getOwnedSubprogramGroupTypes().addAll(
					(Collection<? extends SubprogramGroupType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_IMPLEMENTATION:
			getOwnedSubprogramGroupImplementations().clear();
			getOwnedSubprogramGroupImplementations()
					.addAll((Collection<? extends SubprogramGroupImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_TYPE:
			getOwnedSystemTypes().clear();
			getOwnedSystemTypes().addAll(
					(Collection<? extends SystemType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_IMPLEMENTATION:
			getOwnedSystemImplementations().clear();
			getOwnedSystemImplementations().addAll(
					(Collection<? extends SystemImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_TYPE:
			getOwnedThreadTypes().clear();
			getOwnedThreadTypes().addAll(
					(Collection<? extends ThreadType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_IMPLEMENTATION:
			getOwnedThreadImplementations().clear();
			getOwnedThreadImplementations().addAll(
					(Collection<? extends ThreadImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_GROUP_TYPE:
			getOwnedThreadGroupTypes().clear();
			getOwnedThreadGroupTypes().addAll(
					(Collection<? extends ThreadGroupType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_GROUP_IMPLEMENTATION:
			getOwnedThreadGroupImplementations().clear();
			getOwnedThreadGroupImplementations().addAll(
					(Collection<? extends ThreadGroupImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_BUS_TYPE:
			getOwnedVirtualBusTypes().clear();
			getOwnedVirtualBusTypes().addAll(
					(Collection<? extends VirtualBusType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_BUS_IMPLEMENTATION:
			getOwnedVirtualBusImplementations().clear();
			getOwnedVirtualBusImplementations().addAll(
					(Collection<? extends VirtualBusImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_PROCESSOR_TYPE:
			getOwnedVirtualProcessorTypes().clear();
			getOwnedVirtualProcessorTypes().addAll(
					(Collection<? extends VirtualProcessorType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_PROCESSOR_IMPLEMENTATION:
			getOwnedVirtualProcessorImplementations().clear();
			getOwnedVirtualProcessorImplementations()
					.addAll((Collection<? extends VirtualProcessorImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE:
			getOwnedFeatureGroupTypes().clear();
			getOwnedFeatureGroupTypes().addAll(
					(Collection<? extends FeatureGroupType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__NO_PROPERTIES:
			setNoProperties((Boolean) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__IMPORTED_PROPERTY_SET:
			getImportedPropertySets().clear();
			getImportedPropertySets().addAll(
					(Collection<? extends PropertySet>) newValue);
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
		case Aadl2Package.PACKAGE_SECTION__OWNED_PACKAGE_RENAME:
			getOwnedPackageRenames().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_COMPONENT_TYPE_RENAME:
			getOwnedComponentTypeRenames().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE_RENAME:
			getOwnedFeatureGroupTypeRenames().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_ANNEX_LIBRARY:
			getOwnedAnnexLibraries().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__IMPORTED_PACKAGE:
			getImportedPackages().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__NO_ANNEXES:
			setNoAnnexes(NO_ANNEXES_EDEFAULT);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_TYPE:
			getOwnedAbstractTypes().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_IMPLEMENTATION:
			getOwnedAbstractImplementations().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_BUS_TYPE:
			getOwnedBusTypes().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_BUS_IMPLEMENTATION:
			getOwnedBusImplementations().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_DATA_TYPE:
			getOwnedDataTypes().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_DATA_IMPLEMENTATION:
			getOwnedDataImplementations().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_TYPE:
			getOwnedDeviceTypes().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_IMPLEMENTATION:
			getOwnedDeviceImplementations().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_TYPE:
			getOwnedMemoryTypes().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_IMPLEMENTATION:
			getOwnedMemoryImplementations().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_TYPE:
			getOwnedProcessTypes().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_TYPE:
			getOwnedProcessorTypes().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_IMPLEMENTATION:
			getOwnedProcessImplementations().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_IMPLEMENTATION:
			getOwnedProcessorImplementations().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_TYPE:
			getOwnedSubprogramTypes().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_IMPLEMENTATION:
			getOwnedSubprogramImplementations().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_TYPE:
			getOwnedSubprogramGroupTypes().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_IMPLEMENTATION:
			getOwnedSubprogramGroupImplementations().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_TYPE:
			getOwnedSystemTypes().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_IMPLEMENTATION:
			getOwnedSystemImplementations().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_TYPE:
			getOwnedThreadTypes().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_IMPLEMENTATION:
			getOwnedThreadImplementations().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_GROUP_TYPE:
			getOwnedThreadGroupTypes().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_GROUP_IMPLEMENTATION:
			getOwnedThreadGroupImplementations().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_BUS_TYPE:
			getOwnedVirtualBusTypes().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_BUS_IMPLEMENTATION:
			getOwnedVirtualBusImplementations().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_PROCESSOR_TYPE:
			getOwnedVirtualProcessorTypes().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_PROCESSOR_IMPLEMENTATION:
			getOwnedVirtualProcessorImplementations().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE:
			getOwnedFeatureGroupTypes().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__NO_PROPERTIES:
			setNoProperties(NO_PROPERTIES_EDEFAULT);
			return;
		case Aadl2Package.PACKAGE_SECTION__IMPORTED_PROPERTY_SET:
			getImportedPropertySets().clear();
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
		case Aadl2Package.PACKAGE_SECTION__OWNED_CLASSIFIER:
			return isSetOwnedClassifiers();
		case Aadl2Package.PACKAGE_SECTION__OWNED_PACKAGE_RENAME:
			return ownedPackageRenames != null
					&& !ownedPackageRenames.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_COMPONENT_TYPE_RENAME:
			return ownedComponentTypeRenames != null
					&& !ownedComponentTypeRenames.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE_RENAME:
			return ownedFeatureGroupTypeRenames != null
					&& !ownedFeatureGroupTypeRenames.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_ANNEX_LIBRARY:
			return ownedAnnexLibraries != null
					&& !ownedAnnexLibraries.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__IMPORTED_PACKAGE:
			return importedPackages != null && !importedPackages.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__NO_ANNEXES:
			return noAnnexes != NO_ANNEXES_EDEFAULT;
		case Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_TYPE:
			return ownedAbstractTypes != null && !ownedAbstractTypes.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_IMPLEMENTATION:
			return ownedAbstractImplementations != null
					&& !ownedAbstractImplementations.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_BUS_TYPE:
			return ownedBusTypes != null && !ownedBusTypes.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_BUS_IMPLEMENTATION:
			return ownedBusImplementations != null
					&& !ownedBusImplementations.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_DATA_TYPE:
			return ownedDataTypes != null && !ownedDataTypes.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_DATA_IMPLEMENTATION:
			return ownedDataImplementations != null
					&& !ownedDataImplementations.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_TYPE:
			return ownedDeviceTypes != null && !ownedDeviceTypes.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_IMPLEMENTATION:
			return ownedDeviceImplementations != null
					&& !ownedDeviceImplementations.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_TYPE:
			return ownedMemoryTypes != null && !ownedMemoryTypes.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_IMPLEMENTATION:
			return ownedMemoryImplementations != null
					&& !ownedMemoryImplementations.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_TYPE:
			return ownedProcessTypes != null && !ownedProcessTypes.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_TYPE:
			return ownedProcessorTypes != null
					&& !ownedProcessorTypes.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_IMPLEMENTATION:
			return ownedProcessImplementations != null
					&& !ownedProcessImplementations.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_IMPLEMENTATION:
			return ownedProcessorImplementations != null
					&& !ownedProcessorImplementations.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_TYPE:
			return ownedSubprogramTypes != null
					&& !ownedSubprogramTypes.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_IMPLEMENTATION:
			return ownedSubprogramImplementations != null
					&& !ownedSubprogramImplementations.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_TYPE:
			return ownedSubprogramGroupTypes != null
					&& !ownedSubprogramGroupTypes.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_IMPLEMENTATION:
			return ownedSubprogramGroupImplementations != null
					&& !ownedSubprogramGroupImplementations.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_TYPE:
			return ownedSystemTypes != null && !ownedSystemTypes.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_IMPLEMENTATION:
			return ownedSystemImplementations != null
					&& !ownedSystemImplementations.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_TYPE:
			return ownedThreadTypes != null && !ownedThreadTypes.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_IMPLEMENTATION:
			return ownedThreadImplementations != null
					&& !ownedThreadImplementations.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_GROUP_TYPE:
			return ownedThreadGroupTypes != null
					&& !ownedThreadGroupTypes.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_GROUP_IMPLEMENTATION:
			return ownedThreadGroupImplementations != null
					&& !ownedThreadGroupImplementations.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_BUS_TYPE:
			return ownedVirtualBusTypes != null
					&& !ownedVirtualBusTypes.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_BUS_IMPLEMENTATION:
			return ownedVirtualBusImplementations != null
					&& !ownedVirtualBusImplementations.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_PROCESSOR_TYPE:
			return ownedVirtualProcessorTypes != null
					&& !ownedVirtualProcessorTypes.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_PROCESSOR_IMPLEMENTATION:
			return ownedVirtualProcessorImplementations != null
					&& !ownedVirtualProcessorImplementations.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE:
			return ownedFeatureGroupTypes != null
					&& !ownedFeatureGroupTypes.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__NO_PROPERTIES:
			return noProperties != NO_PROPERTIES_EDEFAULT;
		case Aadl2Package.PACKAGE_SECTION__IMPORTED_PROPERTY_SET:
			return importedPropertySets != null
					&& !importedPropertySets.isEmpty();
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
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (noAnnexes: ");
		result.append(noAnnexes);
		result.append(", noProperties: ");
		result.append(noProperties);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedMembers() {
		return super.isSetOwnedMembers()
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_PACKAGE_RENAME)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_COMPONENT_TYPE_RENAME)
				|| isSetOwnedClassifiers()
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE_RENAME)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_ANNEX_LIBRARY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedClassifiers() {
		return eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_TYPE)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_IMPLEMENTATION)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_BUS_TYPE)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_BUS_IMPLEMENTATION)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_DATA_TYPE)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_DATA_IMPLEMENTATION)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_TYPE)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_IMPLEMENTATION)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_TYPE)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_IMPLEMENTATION)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_TYPE)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_TYPE)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_IMPLEMENTATION)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_IMPLEMENTATION)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_TYPE)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_IMPLEMENTATION)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_TYPE)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_IMPLEMENTATION)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_TYPE)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_IMPLEMENTATION)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_TYPE)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_IMPLEMENTATION)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_GROUP_TYPE)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_GROUP_IMPLEMENTATION)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_BUS_TYPE)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_BUS_IMPLEMENTATION)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_PROCESSOR_TYPE)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_PROCESSOR_IMPLEMENTATION)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE);
	}

	/**
	 * @author dionisio
	 *
	 * switch to add the classifier in the proper list
	 */
	public void addClassifier(Classifier classifier) {
		if (classifier instanceof AbstractImplementation) {
			getOwnedAbstractImplementations().add(
					(AbstractImplementation) classifier);
		} else if (classifier instanceof AbstractType) {
			getOwnedAbstractTypes().add((AbstractType) classifier);
		} else if (classifier instanceof BusImplementation) {
			getOwnedBusImplementations().add((BusImplementation) classifier);
		} else if (classifier instanceof BusType) {
			getOwnedBusTypes().add((BusType) classifier);
		} else if (classifier instanceof DataImplementation) {
			getOwnedDataImplementations().add((DataImplementation) classifier);
		} else if (classifier instanceof DataType) {
			getOwnedDataTypes().add((DataType) classifier);
		} else if (classifier instanceof DeviceImplementation) {
			getOwnedDeviceImplementations().add(
					(DeviceImplementation) classifier);
		} else if (classifier instanceof DeviceType) {
			getOwnedDeviceTypes().add((DeviceType) classifier);
		} else if (classifier instanceof FeatureGroupType) {
			getOwnedFeatureGroupTypes().add((FeatureGroupType) classifier);
		} else if (classifier instanceof MemoryImplementation) {
			getOwnedMemoryImplementations().add(
					(MemoryImplementation) classifier);
		} else if (classifier instanceof MemoryType) {
			getOwnedMemoryTypes().add((MemoryType) classifier);
		} else if (classifier instanceof ProcessImplementation) {
			getOwnedProcessImplementations().add(
					(ProcessImplementation) classifier);
		} else if (classifier instanceof ProcessorImplementation) {
			getOwnedProcessorImplementations().add(
					(ProcessorImplementation) classifier);
		} else if (classifier instanceof ProcessorType) {
			getOwnedProcessorTypes().add((ProcessorType) classifier);
		} else if (classifier instanceof ProcessType) {
			getOwnedProcessTypes().add((ProcessType) classifier);
		} else if (classifier instanceof SubprogramGroupImplementation) {
			getOwnedSubprogramGroupImplementations().add(
					(SubprogramGroupImplementation) classifier);
		} else if (classifier instanceof SubprogramGroupType) {
			getOwnedSubprogramGroupTypes()
					.add((SubprogramGroupType) classifier);
		} else if (classifier instanceof SubprogramImplementation) {
			getOwnedSubprogramImplementations().add(
					(SubprogramImplementation) classifier);
		} else if (classifier instanceof SubprogramType) {
			getOwnedSubprogramTypes().add((SubprogramType) classifier);
		} else if (classifier instanceof SystemImplementation) {
			getOwnedSystemImplementations().add(
					(SystemImplementation) classifier);
		} else if (classifier instanceof SystemType) {
			getOwnedSystemTypes().add((SystemType) classifier);
		} else if (classifier instanceof ThreadGroupImplementation) {
			getOwnedThreadGroupImplementations().add(
					(ThreadGroupImplementation) classifier);
		} else if (classifier instanceof ThreadGroupType) {
			getOwnedThreadGroupTypes().add((ThreadGroupType) classifier);
		} else if (classifier instanceof ThreadImplementation) {
			getOwnedThreadImplementations().add(
					(ThreadImplementation) classifier);
		} else if (classifier instanceof ThreadType) {
			getOwnedThreadTypes().add((ThreadType) classifier);
		} else if (classifier instanceof VirtualBusImplementation) {
			getOwnedVirtualBusImplementations().add(
					(VirtualBusImplementation) classifier);
		} else if (classifier instanceof VirtualBusType) {
			getOwnedVirtualBusTypes().add((VirtualBusType) classifier);
		} else if (classifier instanceof VirtualProcessorImplementation) {
			getOwnedVirtualProcessorImplementations().add(
					(VirtualProcessorImplementation) classifier);
		} else if (classifier instanceof VirtualProcessorType) {
			getOwnedVirtualProcessorTypes().add(
					(VirtualProcessorType) classifier);
		}
	}

	/**
	 * Returns the name of the package.
	 */
	@Override
	public String getName() {
		return ((AadlPackage) eContainer()).getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.PACKAGE_SECTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetName() {
		return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
				.equals(name);
	}

	/**
	 * Default behavior for {@link PackageSection} is to search through all internally visible elements.
	 */
	@Override
	public NamedElement findNamedElement(String name) {
		return findNamedElement(name, false);
	}

	protected NamedElement findInternallyVisibleNamedElement(String name) {
		NamedElement result = super.findNamedElement(name);
		if (result instanceof ComponentTypeRename)
			return ((ComponentTypeRename) result).getRenamedComponentType();
		else if (result instanceof FeatureGroupTypeRename)
			return ((FeatureGroupTypeRename) result)
					.getRenamedFeatureGroupType();
		else if (result != null) {
			// If result is a PackageRename, the PackageRename is returned and not the renamed AadlPackage.
			return result;
		} else {
			for (PackageRename packageRename : getOwnedPackageRenames()) {
				//packageRename.getRenamedPackage() might be null if this method is called before name resolution.
				if (packageRename.isRenameAll()
						&& packageRename.getRenamedPackage() != null
						&& packageRename.getRenamedPackage().getPublicSection() != null) {
					result = packageRename.getRenamedPackage()
							.getPublicSection().findNamedElement(name, true);
					if (result != null)
						return result;
				}
			}
			return null;
		}
	}
} //PackageSectionImpl
