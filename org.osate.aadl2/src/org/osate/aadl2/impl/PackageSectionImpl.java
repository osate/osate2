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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentTypeRename;
import org.osate.aadl2.FeatureGroupTypeRename;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageRename;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.util.Aadl2Util;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Section</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedMembers <em>Owned Member</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedPackageRenames <em>Owned Package Rename</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedComponentTypeRenames <em>Owned Component Type Rename</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedClassifiers <em>Owned Classifier</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedFeatureGroupTypeRenames <em>Owned Feature Group Type Rename</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getOwnedAnnexLibraries <em>Owned Annex Library</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getImportedUnits <em>Imported Unit</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#isNoAnnexes <em>No Annexes</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#isNoProperties <em>No Properties</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageSectionImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PackageSectionImpl extends NamespaceImpl implements PackageSection {
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
	 * The cached value of the '{@link #getOwnedClassifiers() <em>Owned Classifier</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedClassifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<Classifier> ownedClassifiers;

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
	 * The cached value of the '{@link #getImportedUnits() <em>Imported Unit</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedUnits()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelUnit> importedUnits;

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
	 * The array of subset feature identifiers for the '{@link #getOwnedMembers() <em>Owned Member</em>}' reference list.
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
	@Override
	public EList<Classifier> getOwnedClassifiers() {
		if (ownedClassifiers == null) {
			ownedClassifiers = new EObjectContainmentEList<Classifier>(Classifier.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_CLASSIFIER);
		}
		return ownedClassifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Classifier createOwnedClassifier(EClass eClass) {
		Classifier newOwnedClassifier = (Classifier) create(eClass);
		getOwnedClassifiers().add(newOwnedClassifier);
		return newOwnedClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PackageRename> getOwnedPackageRenames() {
		if (ownedPackageRenames == null) {
			ownedPackageRenames = new EObjectContainmentEList<PackageRename>(PackageRename.class, this,
					Aadl2Package.PACKAGE_SECTION__OWNED_PACKAGE_RENAME);
		}
		return ownedPackageRenames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public EList<ComponentTypeRename> getOwnedComponentTypeRenames() {
		if (ownedComponentTypeRenames == null) {
			ownedComponentTypeRenames = new EObjectContainmentEList<ComponentTypeRename>(ComponentTypeRename.class,
					this, Aadl2Package.PACKAGE_SECTION__OWNED_COMPONENT_TYPE_RENAME);
		}
		return ownedComponentTypeRenames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public boolean isNoAnnexes() {
		return noAnnexes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNoAnnexes(boolean newNoAnnexes) {
		boolean oldNoAnnexes = noAnnexes;
		noAnnexes = newNoAnnexes;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.PACKAGE_SECTION__NO_ANNEXES,
					oldNoAnnexes, noAnnexes));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isNoProperties() {
		return noProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNoProperties(boolean newNoProperties) {
		boolean oldNoProperties = noProperties;
		noProperties = newNoProperties;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.PACKAGE_SECTION__NO_PROPERTIES,
					oldNoProperties, noProperties));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FeatureGroupTypeRename> getOwnedFeatureGroupTypeRenames() {
		if (ownedFeatureGroupTypeRenames == null) {
			ownedFeatureGroupTypeRenames = new EObjectContainmentEList<FeatureGroupTypeRename>(
					FeatureGroupTypeRename.class, this, Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE_RENAME);
		}
		return ownedFeatureGroupTypeRenames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
	public AnnexLibrary createOwnedAnnexLibrary() {
		return createOwnedAnnexLibrary(Aadl2Package.eINSTANCE.getAnnexLibrary());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ModelUnit> getImportedUnits() {
		if (importedUnits == null) {
			importedUnits = new EObjectResolvingEList<ModelUnit>(ModelUnit.class, this,
					Aadl2Package.PACKAGE_SECTION__IMPORTED_UNIT);
		}
		return importedUnits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.PACKAGE_SECTION__OWNED_PACKAGE_RENAME:
			return ((InternalEList<?>) getOwnedPackageRenames()).basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_COMPONENT_TYPE_RENAME:
			return ((InternalEList<?>) getOwnedComponentTypeRenames()).basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_CLASSIFIER:
			return ((InternalEList<?>) getOwnedClassifiers()).basicRemove(otherEnd, msgs);
		case Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE_RENAME:
			return ((InternalEList<?>) getOwnedFeatureGroupTypeRenames()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.PACKAGE_SECTION__OWNED_PACKAGE_RENAME:
			return getOwnedPackageRenames();
		case Aadl2Package.PACKAGE_SECTION__OWNED_COMPONENT_TYPE_RENAME:
			return getOwnedComponentTypeRenames();
		case Aadl2Package.PACKAGE_SECTION__OWNED_CLASSIFIER:
			return getOwnedClassifiers();
		case Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE_RENAME:
			return getOwnedFeatureGroupTypeRenames();
		case Aadl2Package.PACKAGE_SECTION__OWNED_ANNEX_LIBRARY:
			return getOwnedAnnexLibraries();
		case Aadl2Package.PACKAGE_SECTION__IMPORTED_UNIT:
			return getImportedUnits();
		case Aadl2Package.PACKAGE_SECTION__NO_ANNEXES:
			return isNoAnnexes();
		case Aadl2Package.PACKAGE_SECTION__NO_PROPERTIES:
			return isNoProperties();
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
			getOwnedPackageRenames().addAll((Collection<? extends PackageRename>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_COMPONENT_TYPE_RENAME:
			getOwnedComponentTypeRenames().clear();
			getOwnedComponentTypeRenames().addAll((Collection<? extends ComponentTypeRename>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_CLASSIFIER:
			getOwnedClassifiers().clear();
			getOwnedClassifiers().addAll((Collection<? extends Classifier>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE_RENAME:
			getOwnedFeatureGroupTypeRenames().clear();
			getOwnedFeatureGroupTypeRenames().addAll((Collection<? extends FeatureGroupTypeRename>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_ANNEX_LIBRARY:
			getOwnedAnnexLibraries().clear();
			getOwnedAnnexLibraries().addAll((Collection<? extends AnnexLibrary>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__IMPORTED_UNIT:
			getImportedUnits().clear();
			getImportedUnits().addAll((Collection<? extends ModelUnit>) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__NO_ANNEXES:
			setNoAnnexes((Boolean) newValue);
			return;
		case Aadl2Package.PACKAGE_SECTION__NO_PROPERTIES:
			setNoProperties((Boolean) newValue);
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
		case Aadl2Package.PACKAGE_SECTION__OWNED_CLASSIFIER:
			getOwnedClassifiers().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE_RENAME:
			getOwnedFeatureGroupTypeRenames().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_ANNEX_LIBRARY:
			getOwnedAnnexLibraries().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__IMPORTED_UNIT:
			getImportedUnits().clear();
			return;
		case Aadl2Package.PACKAGE_SECTION__NO_ANNEXES:
			setNoAnnexes(NO_ANNEXES_EDEFAULT);
			return;
		case Aadl2Package.PACKAGE_SECTION__NO_PROPERTIES:
			setNoProperties(NO_PROPERTIES_EDEFAULT);
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
		case Aadl2Package.PACKAGE_SECTION__OWNED_MEMBER:
			return isSetOwnedMembers();
		case Aadl2Package.PACKAGE_SECTION__OWNED_PACKAGE_RENAME:
			return ownedPackageRenames != null && !ownedPackageRenames.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_COMPONENT_TYPE_RENAME:
			return ownedComponentTypeRenames != null && !ownedComponentTypeRenames.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_CLASSIFIER:
			return ownedClassifiers != null && !ownedClassifiers.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE_RENAME:
			return ownedFeatureGroupTypeRenames != null && !ownedFeatureGroupTypeRenames.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__OWNED_ANNEX_LIBRARY:
			return ownedAnnexLibraries != null && !ownedAnnexLibraries.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__IMPORTED_UNIT:
			return importedUnits != null && !importedUnits.isEmpty();
		case Aadl2Package.PACKAGE_SECTION__NO_ANNEXES:
			return noAnnexes != NO_ANNEXES_EDEFAULT;
		case Aadl2Package.PACKAGE_SECTION__NO_PROPERTIES:
			return noProperties != NO_PROPERTIES_EDEFAULT;
		case Aadl2Package.PACKAGE_SECTION__NAME:
			return isSetName();
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
		if (eIsProxy()) {
			return super.toString();
		}

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
		return super.isSetOwnedMembers() || eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_PACKAGE_RENAME)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_COMPONENT_TYPE_RENAME)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_CLASSIFIER)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE_RENAME)
				|| eIsSet(Aadl2Package.PACKAGE_SECTION__OWNED_ANNEX_LIBRARY);
	}

	/**
	 * Returns the name of the package.
	 */
	@Override
	public String getName() {
		return ((AadlPackage) getOwner()).getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setName(String newName) {
		// DB: Ticket #249. Causes problem with model merge operations. Because getName() is derived from the name of the containing package,
		// EMF compare computes a difference between the package section since the package has been renamed.
		// Removing exception throw for now.
		// throw new UnsupportedOperationException(
		// "Cannot set name of package secton.");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSetName() {
		return false;
	}

	/**
	 * name lookup of externally visible names.
	 * Does not resolve renames; does not lookup when private package section
	 */
	@Override
	public NamedElement findNamedElement(String name) {
		if (this instanceof PublicPackageSection) {
			for (NamedElement namedElement : getMembers()) {
				if (namedElement.hasName() && namedElement.getName().equalsIgnoreCase(name)) {
					if (namedElement instanceof PackageRename || namedElement instanceof ComponentTypeRename
							|| namedElement instanceof FeatureGroupTypeRename) {
						return null;
					} else {
						return namedElement;
					}
				}
			}
			return null;
		}
		return null;
	}

	/**
	 * name lookup from within package.
	 * It searches through all internally visible elements resolving renames as appropriate
	 */
	@Override
	public NamedElement findInternallyVisibleNamedElement(String name) {
		NamedElement result = super.findNamedElement(name);
		if (result instanceof ComponentTypeRename) {
			return ((ComponentTypeRename) result).getRenamedComponentType();
		} else if (result instanceof FeatureGroupTypeRename) {
			return ((FeatureGroupTypeRename) result).getRenamedFeatureGroupType();
		} else if (result instanceof PackageRename) {
			return ((PackageRename) result).getRenamedPackage();
		} else if (result != null) {
			// non renames NamedElement was found
			return result;
		} else {
			// now we need to look in renames all
			for (PackageRename packageRename : getOwnedPackageRenames()) {
				if (packageRename.isRenameAll() && packageRename.getRenamedPackage() != null
						&& packageRename.getRenamedPackage().getPublicSection() != null) {
					result = packageRename.getRenamedPackage().getPublicSection().findNamedElement(name);
					if (result != null) {
						return result;
					}
				}
			}
			// now we need to look in unnamed ComponentTypeRename or unnamed
			// FeatureGroupRename
			for (ComponentTypeRename ctRename : getOwnedComponentTypeRenames()) {
				if (ctRename.getName() == null && !Aadl2Util.isNull(ctRename.getRenamedComponentType())
						&& name.equalsIgnoreCase(ctRename.getRenamedComponentType().getName())) {
					return ctRename.getRenamedComponentType();
				}
			}
			for (FeatureGroupTypeRename fgtRename : getOwnedFeatureGroupTypeRenames()) {
				try {
					if (fgtRename.getName() == null && !Aadl2Util.isNull(fgtRename.getRenamedFeatureGroupType())
							&& name.equalsIgnoreCase(fgtRename.getRenamedFeatureGroupType().getName())) {
						return fgtRename.getRenamedFeatureGroupType();
					}
				} catch (AssertionError ae) {
					return null;
				}
			}
			return null;
		}
	}
} // PackageSectionImpl
