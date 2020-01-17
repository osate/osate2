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
package org.osate.aadl2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
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
 * </p>
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
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getPackageSection();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedElement> getOwnedMembers() {
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
	protected static final int[] OWNED_MEMBER_ESUBSETS = new int[] { Aadl2Package.PACKAGE_SECTION__OWNED_PACKAGE_RENAME,
			Aadl2Package.PACKAGE_SECTION__OWNED_COMPONENT_TYPE_RENAME, Aadl2Package.PACKAGE_SECTION__OWNED_CLASSIFIER,
			Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE_RENAME,
			Aadl2Package.PACKAGE_SECTION__OWNED_ANNEX_LIBRARY };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public ComponentTypeRename createOwnedComponentTypeRename() {
		ComponentTypeRename newOwnedComponentTypeRename = (ComponentTypeRename) create(
				Aadl2Package.eINSTANCE.getComponentTypeRename());
		getOwnedComponentTypeRenames().add(newOwnedComponentTypeRename);
		return newOwnedComponentTypeRename;
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
	public FeatureGroupTypeRename createOwnedFeatureGroupTypeRename() {
		FeatureGroupTypeRename newOwnedFeatureGroupTypeRename = (FeatureGroupTypeRename) create(
				Aadl2Package.eINSTANCE.getFeatureGroupTypeRename());
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
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
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
	public String getName() {
		AadlPackage owner = (AadlPackage) getOwner();
		return owner != null ? owner.getName() : "";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
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
