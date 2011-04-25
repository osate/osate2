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
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getAliases <em>Aliases</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getDeclarations <em>Declarations</em>}</li>
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
public abstract class PackageSectionImpl extends NamespaceImpl implements PackageSection {
	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap imports;

	/**
	 * The cached value of the '{@link #getAliases() <em>Aliases</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAliases()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap aliases;

	/**
	 * The cached value of the '{@link #getDeclarations() <em>Declarations</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclarations()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap declarations;

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
			EList<NamedElement> ownedMembers = (EList<NamedElement>) cache.get(eResource, this,
					Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			if (ownedMembers == null) {
				cache.put(eResource, this, Aadl2Package.eINSTANCE.getNamespace_OwnedMember(),
						ownedMembers = new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this,
								Aadl2Package.PACKAGE_SECTION__OWNED_MEMBER, OWNED_MEMBER_ESUBSETS));
			}
			return ownedMembers;
		}
		return new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this,
				Aadl2Package.PACKAGE_SECTION__OWNED_MEMBER, OWNED_MEMBER_ESUBSETS);
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
			Aadl2Package.PACKAGE_SECTION__OWNED_COMPONENT_TYPE_RENAME, Aadl2Package.PACKAGE_SECTION__OWNED_CLASSIFIER,
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
			EList<Classifier> ownedClassifiers = (EList<Classifier>) cache.get(eResource, this,
					Aadl2Package.eINSTANCE.getPackageSection_OwnedClassifier());
			if (ownedClassifiers == null) {
				cache.put(eResource, this, Aadl2Package.eINSTANCE.getPackageSection_OwnedClassifier(),
						ownedClassifiers = new DerivedUnionEObjectEList<Classifier>(Classifier.class, this,
								Aadl2Package.PACKAGE_SECTION__OWNED_CLASSIFIER, OWNED_CLASSIFIER_ESUBSETS));
			}
			return ownedClassifiers;
		}
		return new DerivedUnionEObjectEList<Classifier>(Classifier.class, this,
				Aadl2Package.PACKAGE_SECTION__OWNED_CLASSIFIER, OWNED_CLASSIFIER_ESUBSETS);
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
			Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_IMPLEMENTATION, Aadl2Package.PACKAGE_SECTION__OWNED_BUS_TYPE,
			Aadl2Package.PACKAGE_SECTION__OWNED_BUS_IMPLEMENTATION, Aadl2Package.PACKAGE_SECTION__OWNED_DATA_TYPE,
			Aadl2Package.PACKAGE_SECTION__OWNED_DATA_IMPLEMENTATION, Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_TYPE,
			Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_IMPLEMENTATION, Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_TYPE,
			Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_IMPLEMENTATION,
			Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_TYPE, Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_TYPE,
			Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_IMPLEMENTATION,
			Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_IMPLEMENTATION,
			Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_TYPE,
			Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_IMPLEMENTATION,
			Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_TYPE,
			Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_IMPLEMENTATION,
			Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_TYPE, Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_IMPLEMENTATION,
			Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_TYPE, Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_IMPLEMENTATION,
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
	public FeatureMap getImports() {
		if (imports == null) {
			imports = new BasicFeatureMap(this, Aadl2Package.PACKAGE_SECTION__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAliases() {
		if (aliases == null) {
			aliases = new BasicFeatureMap(this, Aadl2Package.PACKAGE_SECTION__ALIASES);
		}
		return aliases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getDeclarations() {
		if (declarations == null) {
			declarations = new BasicFeatureMap(this, Aadl2Package.PACKAGE_SECTION__DECLARATIONS);
		}
		return declarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PackageRename> getOwnedPackageRenames() {
		return getAliases().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedPackageRename());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageRename createOwnedPackageRename() {
		PackageRename newOwnedPackageRename = (PackageRename) create(Aadl2Package.eINSTANCE.getPackageRename());
		getOwnedPackageRenames().add(newOwnedPackageRename);
		return newOwnedPackageRename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentTypeRename> getOwnedComponentTypeRenames() {
		return getAliases().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedComponentTypeRename());
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
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.PACKAGE_SECTION__NO_PROPERTIES,
					oldNoProperties, noProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertySet> getImportedPropertySets() {
		return getImports().list(Aadl2Package.eINSTANCE.getPackageSection_ImportedPropertySet());
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
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.PACKAGE_SECTION__NO_ANNEXES,
					oldNoAnnexes, noAnnexes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureGroupTypeRename> getOwnedFeatureGroupTypeRenames() {
		return getAliases().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedFeatureGroupTypeRename());
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
			ownedAnnexLibraries = new EObjectContainmentEList<AnnexLibrary>(AnnexLibrary.class, this,
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
		return getImports().list(Aadl2Package.eINSTANCE.getPackageSection_ImportedPackage());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractType> getOwnedAbstractTypes() {
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedAbstractType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractType createOwnedAbstractType() {
		AbstractType newOwnedAbstractType = (AbstractType) create(Aadl2Package.eINSTANCE.getAbstractType());
		getOwnedAbstractTypes().add(newOwnedAbstractType);
		return newOwnedAbstractType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractImplementation> getOwnedAbstractImplementations() {
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedAbstractImplementation());
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
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedBusType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusType createOwnedBusType() {
		BusType newOwnedBusType = (BusType) create(Aadl2Package.eINSTANCE.getBusType());
		getOwnedBusTypes().add(newOwnedBusType);
		return newOwnedBusType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BusImplementation> getOwnedBusImplementations() {
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedBusImplementation());
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
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedDataType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType createOwnedDataType() {
		DataType newOwnedDataType = (DataType) create(Aadl2Package.eINSTANCE.getDataType());
		getOwnedDataTypes().add(newOwnedDataType);
		return newOwnedDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataImplementation> getOwnedDataImplementations() {
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedDataImplementation());
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
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedDeviceType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeviceType createOwnedDeviceType() {
		DeviceType newOwnedDeviceType = (DeviceType) create(Aadl2Package.eINSTANCE.getDeviceType());
		getOwnedDeviceTypes().add(newOwnedDeviceType);
		return newOwnedDeviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeviceImplementation> getOwnedDeviceImplementations() {
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedDeviceImplementation());
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
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedMemoryType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryType createOwnedMemoryType() {
		MemoryType newOwnedMemoryType = (MemoryType) create(Aadl2Package.eINSTANCE.getMemoryType());
		getOwnedMemoryTypes().add(newOwnedMemoryType);
		return newOwnedMemoryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MemoryImplementation> getOwnedMemoryImplementations() {
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedMemoryImplementation());
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
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedProcessType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessType createOwnedProcessType() {
		ProcessType newOwnedProcessType = (ProcessType) create(Aadl2Package.eINSTANCE.getProcessType());
		getOwnedProcessTypes().add(newOwnedProcessType);
		return newOwnedProcessType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcessorType> getOwnedProcessorTypes() {
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedProcessorType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessorType createOwnedProcessorType() {
		ProcessorType newOwnedProcessorType = (ProcessorType) create(Aadl2Package.eINSTANCE.getProcessorType());
		getOwnedProcessorTypes().add(newOwnedProcessorType);
		return newOwnedProcessorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcessImplementation> getOwnedProcessImplementations() {
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedProcessImplementation());
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
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedProcessorImplementation());
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
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedFeatureGroupType());
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
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedVirtualProcessorImplementation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualProcessorImplementation createOwnedVirtualProcessorImplementation() {
		VirtualProcessorImplementation newOwnedVirtualProcessorImplementation = (VirtualProcessorImplementation) create(Aadl2Package.eINSTANCE
				.getVirtualProcessorImplementation());
		getOwnedVirtualProcessorImplementations().add(newOwnedVirtualProcessorImplementation);
		return newOwnedVirtualProcessorImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VirtualProcessorType> getOwnedVirtualProcessorTypes() {
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedVirtualProcessorType());
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
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedThreadGroupImplementation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreadGroupImplementation createOwnedThreadGroupImplementation() {
		ThreadGroupImplementation newOwnedThreadGroupImplementation = (ThreadGroupImplementation) create(Aadl2Package.eINSTANCE
				.getThreadGroupImplementation());
		getOwnedThreadGroupImplementations().add(newOwnedThreadGroupImplementation);
		return newOwnedThreadGroupImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ThreadImplementation> getOwnedThreadImplementations() {
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedThreadImplementation());
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
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedVirtualBusType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualBusType createOwnedVirtualBusType() {
		VirtualBusType newOwnedVirtualBusType = (VirtualBusType) create(Aadl2Package.eINSTANCE.getVirtualBusType());
		getOwnedVirtualBusTypes().add(newOwnedVirtualBusType);
		return newOwnedVirtualBusType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ThreadGroupType> getOwnedThreadGroupTypes() {
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedThreadGroupType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreadGroupType createOwnedThreadGroupType() {
		ThreadGroupType newOwnedThreadGroupType = (ThreadGroupType) create(Aadl2Package.eINSTANCE.getThreadGroupType());
		getOwnedThreadGroupTypes().add(newOwnedThreadGroupType);
		return newOwnedThreadGroupType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ThreadType> getOwnedThreadTypes() {
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedThreadType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreadType createOwnedThreadType() {
		ThreadType newOwnedThreadType = (ThreadType) create(Aadl2Package.eINSTANCE.getThreadType());
		getOwnedThreadTypes().add(newOwnedThreadType);
		return newOwnedThreadType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemType> getOwnedSystemTypes() {
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedSystemType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemType createOwnedSystemType() {
		SystemType newOwnedSystemType = (SystemType) create(Aadl2Package.eINSTANCE.getSystemType());
		getOwnedSystemTypes().add(newOwnedSystemType);
		return newOwnedSystemType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubprogramType> getOwnedSubprogramTypes() {
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedSubprogramType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramType createOwnedSubprogramType() {
		SubprogramType newOwnedSubprogramType = (SubprogramType) create(Aadl2Package.eINSTANCE.getSubprogramType());
		getOwnedSubprogramTypes().add(newOwnedSubprogramType);
		return newOwnedSubprogramType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubprogramGroupType> getOwnedSubprogramGroupTypes() {
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedSubprogramGroupType());
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
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedSystemImplementation());
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
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedSubprogramGroupImplementation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramGroupImplementation createOwnedSubprogramGroupImplementation() {
		SubprogramGroupImplementation newOwnedSubprogramGroupImplementation = (SubprogramGroupImplementation) create(Aadl2Package.eINSTANCE
				.getSubprogramGroupImplementation());
		getOwnedSubprogramGroupImplementations().add(newOwnedSubprogramGroupImplementation);
		return newOwnedSubprogramGroupImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubprogramImplementation> getOwnedSubprogramImplementations() {
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedSubprogramImplementation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramImplementation createOwnedSubprogramImplementation() {
		SubprogramImplementation newOwnedSubprogramImplementation = (SubprogramImplementation) create(Aadl2Package.eINSTANCE
				.getSubprogramImplementation());
		getOwnedSubprogramImplementations().add(newOwnedSubprogramImplementation);
		return newOwnedSubprogramImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VirtualBusImplementation> getOwnedVirtualBusImplementations() {
		return getDeclarations().list(Aadl2Package.eINSTANCE.getPackageSection_OwnedVirtualBusImplementation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualBusImplementation createOwnedVirtualBusImplementation() {
		VirtualBusImplementation newOwnedVirtualBusImplementation = (VirtualBusImplementation) create(Aadl2Package.eINSTANCE
				.getVirtualBusImplementation());
		getOwnedVirtualBusImplementations().add(newOwnedVirtualBusImplementation);
		return newOwnedVirtualBusImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.PACKAGE_SECTION__IMPORTS:
			return ((InternalEList<?>) getImports()).basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__ALIASES:
			return ((InternalEList<?>) getAliases()).basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__DECLARATIONS:
			return ((InternalEList<?>) getDeclarations()).basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_ANNEX_LIBRARY:
			return ((InternalEList<?>) getOwnedAnnexLibraries()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.PACKAGE_SECTION__IMPORTS:
			if (coreType)
				return getImports();
			return ((FeatureMap.Internal) getImports()).getWrapper();
		case Aadl2Package.PACKAGE_SECTION__ALIASES:
			if (coreType)
				return getAliases();
			return ((FeatureMap.Internal) getAliases()).getWrapper();
		case Aadl2Package.PACKAGE_SECTION__DECLARATIONS:
			if (coreType)
				return getDeclarations();
			return ((FeatureMap.Internal) getDeclarations()).getWrapper();
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
		case Aadl2Package.PACKAGE_SECTION__IMPORTS:
			((FeatureMap.Internal) getImports()).set(newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__ALIASES:
			((FeatureMap.Internal) getAliases()).set(newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__DECLARATIONS:
			((FeatureMap.Internal) getDeclarations()).set(newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_PACKAGE_RENAME:
			getOwnedPackageRenames().clear();
			getOwnedPackageRenames().addAll((Collection<? extends PackageRename>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_COMPONENT_TYPE_RENAME:
			getOwnedComponentTypeRenames().clear();
			getOwnedComponentTypeRenames().addAll((Collection<? extends ComponentTypeRename>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE_RENAME:
			getOwnedFeatureGroupTypeRenames().clear();
			getOwnedFeatureGroupTypeRenames().addAll((Collection<? extends FeatureGroupTypeRename>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_ANNEX_LIBRARY:
			getOwnedAnnexLibraries().clear();
			getOwnedAnnexLibraries().addAll((Collection<? extends AnnexLibrary>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__IMPORTED_PACKAGE:
			getImportedPackages().clear();
			getImportedPackages().addAll((Collection<? extends AadlPackage>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__NO_ANNEXES:
			setNoAnnexes((Boolean) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_TYPE:
			getOwnedAbstractTypes().clear();
			getOwnedAbstractTypes().addAll((Collection<? extends AbstractType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_IMPLEMENTATION:
			getOwnedAbstractImplementations().clear();
			getOwnedAbstractImplementations().addAll((Collection<? extends AbstractImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_BUS_TYPE:
			getOwnedBusTypes().clear();
			getOwnedBusTypes().addAll((Collection<? extends BusType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_BUS_IMPLEMENTATION:
			getOwnedBusImplementations().clear();
			getOwnedBusImplementations().addAll((Collection<? extends BusImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_DATA_TYPE:
			getOwnedDataTypes().clear();
			getOwnedDataTypes().addAll((Collection<? extends DataType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_DATA_IMPLEMENTATION:
			getOwnedDataImplementations().clear();
			getOwnedDataImplementations().addAll((Collection<? extends DataImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_TYPE:
			getOwnedDeviceTypes().clear();
			getOwnedDeviceTypes().addAll((Collection<? extends DeviceType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_IMPLEMENTATION:
			getOwnedDeviceImplementations().clear();
			getOwnedDeviceImplementations().addAll((Collection<? extends DeviceImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_TYPE:
			getOwnedMemoryTypes().clear();
			getOwnedMemoryTypes().addAll((Collection<? extends MemoryType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_IMPLEMENTATION:
			getOwnedMemoryImplementations().clear();
			getOwnedMemoryImplementations().addAll((Collection<? extends MemoryImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_TYPE:
			getOwnedProcessTypes().clear();
			getOwnedProcessTypes().addAll((Collection<? extends ProcessType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_TYPE:
			getOwnedProcessorTypes().clear();
			getOwnedProcessorTypes().addAll((Collection<? extends ProcessorType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_IMPLEMENTATION:
			getOwnedProcessImplementations().clear();
			getOwnedProcessImplementations().addAll((Collection<? extends ProcessImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_IMPLEMENTATION:
			getOwnedProcessorImplementations().clear();
			getOwnedProcessorImplementations().addAll((Collection<? extends ProcessorImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_TYPE:
			getOwnedSubprogramTypes().clear();
			getOwnedSubprogramTypes().addAll((Collection<? extends SubprogramType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_IMPLEMENTATION:
			getOwnedSubprogramImplementations().clear();
			getOwnedSubprogramImplementations().addAll((Collection<? extends SubprogramImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_TYPE:
			getOwnedSubprogramGroupTypes().clear();
			getOwnedSubprogramGroupTypes().addAll((Collection<? extends SubprogramGroupType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_IMPLEMENTATION:
			getOwnedSubprogramGroupImplementations().clear();
			getOwnedSubprogramGroupImplementations().addAll(
					(Collection<? extends SubprogramGroupImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_TYPE:
			getOwnedSystemTypes().clear();
			getOwnedSystemTypes().addAll((Collection<? extends SystemType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_IMPLEMENTATION:
			getOwnedSystemImplementations().clear();
			getOwnedSystemImplementations().addAll((Collection<? extends SystemImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_TYPE:
			getOwnedThreadTypes().clear();
			getOwnedThreadTypes().addAll((Collection<? extends ThreadType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_IMPLEMENTATION:
			getOwnedThreadImplementations().clear();
			getOwnedThreadImplementations().addAll((Collection<? extends ThreadImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_GROUP_TYPE:
			getOwnedThreadGroupTypes().clear();
			getOwnedThreadGroupTypes().addAll((Collection<? extends ThreadGroupType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_GROUP_IMPLEMENTATION:
			getOwnedThreadGroupImplementations().clear();
			getOwnedThreadGroupImplementations().addAll((Collection<? extends ThreadGroupImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_BUS_TYPE:
			getOwnedVirtualBusTypes().clear();
			getOwnedVirtualBusTypes().addAll((Collection<? extends VirtualBusType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_BUS_IMPLEMENTATION:
			getOwnedVirtualBusImplementations().clear();
			getOwnedVirtualBusImplementations().addAll((Collection<? extends VirtualBusImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_PROCESSOR_TYPE:
			getOwnedVirtualProcessorTypes().clear();
			getOwnedVirtualProcessorTypes().addAll((Collection<? extends VirtualProcessorType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_PROCESSOR_IMPLEMENTATION:
			getOwnedVirtualProcessorImplementations().clear();
			getOwnedVirtualProcessorImplementations().addAll(
					(Collection<? extends VirtualProcessorImplementation>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE:
			getOwnedFeatureGroupTypes().clear();
			getOwnedFeatureGroupTypes().addAll((Collection<? extends FeatureGroupType>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__NO_PROPERTIES:
			setNoProperties((Boolean) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__IMPORTED_PROPERTY_SET:
			getImportedPropertySets().clear();
			getImportedPropertySets().addAll((Collection<? extends PropertySet>) newValue);
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
		case Aadl2Package.PACKAGE_SECTION__IMPORTS:
			getImports().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__ALIASES:
			getAliases().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__DECLARATIONS:
			getDeclarations().clear();
			return;
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
		case Aadl2Package.PACKAGE_SECTION__IMPORTS:
			return imports != null && !imports.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__ALIASES:
			return aliases != null && !aliases.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__DECLARATIONS:
			return declarations != null && !declarations.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_PACKAGE_RENAME:
			return !getOwnedPackageRenames().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_COMPONENT_TYPE_RENAME:
			return !getOwnedComponentTypeRenames().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE_RENAME:
			return !getOwnedFeatureGroupTypeRenames().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_ANNEX_LIBRARY:
			return ownedAnnexLibraries != null && !ownedAnnexLibraries.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__IMPORTED_PACKAGE:
			return !getImportedPackages().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__NO_ANNEXES:
			return noAnnexes != NO_ANNEXES_EDEFAULT;
		case Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_TYPE:
			return !getOwnedAbstractTypes().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_IMPLEMENTATION:
			return !getOwnedAbstractImplementations().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_BUS_TYPE:
			return !getOwnedBusTypes().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_BUS_IMPLEMENTATION:
			return !getOwnedBusImplementations().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_DATA_TYPE:
			return !getOwnedDataTypes().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_DATA_IMPLEMENTATION:
			return !getOwnedDataImplementations().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_TYPE:
			return !getOwnedDeviceTypes().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_IMPLEMENTATION:
			return !getOwnedDeviceImplementations().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_TYPE:
			return !getOwnedMemoryTypes().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_IMPLEMENTATION:
			return !getOwnedMemoryImplementations().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_TYPE:
			return !getOwnedProcessTypes().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_TYPE:
			return !getOwnedProcessorTypes().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_IMPLEMENTATION:
			return !getOwnedProcessImplementations().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_IMPLEMENTATION:
			return !getOwnedProcessorImplementations().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_TYPE:
			return !getOwnedSubprogramTypes().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_IMPLEMENTATION:
			return !getOwnedSubprogramImplementations().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_TYPE:
			return !getOwnedSubprogramGroupTypes().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_IMPLEMENTATION:
			return !getOwnedSubprogramGroupImplementations().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_TYPE:
			return !getOwnedSystemTypes().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_IMPLEMENTATION:
			return !getOwnedSystemImplementations().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_TYPE:
			return !getOwnedThreadTypes().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_IMPLEMENTATION:
			return !getOwnedThreadImplementations().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_GROUP_TYPE:
			return !getOwnedThreadGroupTypes().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_GROUP_IMPLEMENTATION:
			return !getOwnedThreadGroupImplementations().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_BUS_TYPE:
			return !getOwnedVirtualBusTypes().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_BUS_IMPLEMENTATION:
			return !getOwnedVirtualBusImplementations().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_PROCESSOR_TYPE:
			return !getOwnedVirtualProcessorTypes().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_PROCESSOR_IMPLEMENTATION:
			return !getOwnedVirtualProcessorImplementations().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE:
			return !getOwnedFeatureGroupTypes().isEmpty();
		case Aadl2Package.PACKAGE_SECTION__NO_PROPERTIES:
			return noProperties != NO_PROPERTIES_EDEFAULT;
		case Aadl2Package.PACKAGE_SECTION__IMPORTED_PROPERTY_SET:
			return !getImportedPropertySets().isEmpty();
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
		result.append(" (imports: ");
		result.append(imports);
		result.append(", aliases: ");
		result.append(aliases);
		result.append(", declarations: ");
		result.append(declarations);
		result.append(", noAnnexes: ");
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
		return super.isSetOwnedMembers() || eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_PACKAGE_RENAME)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_COMPONENT_TYPE_RENAME) || isSetOwnedClassifiers()
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
			getOwnedAbstractImplementations().add((AbstractImplementation) classifier);
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
			getOwnedDeviceImplementations().add((DeviceImplementation) classifier);
		} else if (classifier instanceof DeviceType) {
			getOwnedDeviceTypes().add((DeviceType) classifier);
		} else if (classifier instanceof FeatureGroupType) {
			getOwnedFeatureGroupTypes().add((FeatureGroupType) classifier);
		} else if (classifier instanceof MemoryImplementation) {
			getOwnedMemoryImplementations().add((MemoryImplementation) classifier);
		} else if (classifier instanceof MemoryType) {
			getOwnedMemoryTypes().add((MemoryType) classifier);
		} else if (classifier instanceof ProcessImplementation) {
			getOwnedProcessImplementations().add((ProcessImplementation) classifier);
		} else if (classifier instanceof ProcessorImplementation) {
			getOwnedProcessorImplementations().add((ProcessorImplementation) classifier);
		} else if (classifier instanceof ProcessorType) {
			getOwnedProcessorTypes().add((ProcessorType) classifier);
		} else if (classifier instanceof ProcessType) {
			getOwnedProcessTypes().add((ProcessType) classifier);
		} else if (classifier instanceof SubprogramGroupImplementation) {
			getOwnedSubprogramGroupImplementations().add((SubprogramGroupImplementation) classifier);
		} else if (classifier instanceof SubprogramGroupType) {
			getOwnedSubprogramGroupTypes().add((SubprogramGroupType) classifier);
		} else if (classifier instanceof SubprogramImplementation) {
			getOwnedSubprogramImplementations().add((SubprogramImplementation) classifier);
		} else if (classifier instanceof SubprogramType) {
			getOwnedSubprogramTypes().add((SubprogramType) classifier);
		} else if (classifier instanceof SystemImplementation) {
			getOwnedSystemImplementations().add((SystemImplementation) classifier);
		} else if (classifier instanceof SystemType) {
			getOwnedSystemTypes().add((SystemType) classifier);
		} else if (classifier instanceof ThreadGroupImplementation) {
			getOwnedThreadGroupImplementations().add((ThreadGroupImplementation) classifier);
		} else if (classifier instanceof ThreadGroupType) {
			getOwnedThreadGroupTypes().add((ThreadGroupType) classifier);
		} else if (classifier instanceof ThreadImplementation) {
			getOwnedThreadImplementations().add((ThreadImplementation) classifier);
		} else if (classifier instanceof ThreadType) {
			getOwnedThreadTypes().add((ThreadType) classifier);
		} else if (classifier instanceof VirtualBusImplementation) {
			getOwnedVirtualBusImplementations().add((VirtualBusImplementation) classifier);
		} else if (classifier instanceof VirtualBusType) {
			getOwnedVirtualBusTypes().add((VirtualBusType) classifier);
		} else if (classifier instanceof VirtualProcessorImplementation) {
			getOwnedVirtualProcessorImplementations().add((VirtualProcessorImplementation) classifier);
		} else if (classifier instanceof VirtualProcessorType) {
			getOwnedVirtualProcessorTypes().add((VirtualProcessorType) classifier);
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
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.PACKAGE_SECTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetName() {
		return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
			return ((FeatureGroupTypeRename) result).getRenamedFeatureGroupType();
		else if (result != null) {
			// If result is a PackageRename, the PackageRename is returned and not the renamed AadlPackage.
			return result;
		} else {
			for (PackageRename packageRename : getOwnedPackageRenames()) {
				//packageRename.getRenamedPackage() might be null if this method is called before name resolution.
				if (packageRename.isRenameAll() && packageRename.getRenamedPackage() != null
						&& packageRename.getRenamedPackage().getPublicSection() != null) {
					result = packageRename.getRenamedPackage().getPublicSection().findNamedElement(name, true);
					if (result != null)
						return result;
				}
			}
			return null;
		}
	}
} //PackageSectionImpl
