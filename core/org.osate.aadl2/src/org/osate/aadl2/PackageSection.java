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
package org.osate.aadl2;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLProperties::Associations.</p>
 * <p>From package AADLDetails::NoneSupport.</p>
 * <p>From package AADLConstructs::Packaging.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedPackageRenames <em>Owned Package Rename</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedComponentTypeRenames <em>Owned Component Type Rename</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedClassifiers <em>Owned Classifier</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedFeatureGroupTypeRenames <em>Owned Feature Group Type Rename</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedAnnexLibraries <em>Owned Annex Library</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getImportedUnits <em>Imported Unit</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#isNoAnnexes <em>No Annexes</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#isNoProperties <em>No Properties</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getPackageSection()
 * @model abstract="true"
 *        annotation="duplicates"
 * @generated
 */
public interface PackageSection extends Namespace {
	/**
	 * Returns the value of the '<em><b>Owned Package Rename</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.PackageRename}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Package Rename</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Packaging.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Package Rename</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedPackageRename()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<PackageRename> getOwnedPackageRenames();

	/**
	 * Creates a new {@link org.osate.aadl2.PackageRename} and appends it to the '<em><b>Owned Package Rename</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.PackageRename}.
	 * @see #getOwnedPackageRenames()
	 * @generated
	 */
	PackageRename createOwnedPackageRename();

	/**
	 * Returns the value of the '<em><b>Owned Component Type Rename</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.ComponentTypeRename}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Component Type Rename</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Packaging.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Component Type Rename</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedComponentTypeRename()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<ComponentTypeRename> getOwnedComponentTypeRenames();

	/**
	 * Creates a new {@link org.osate.aadl2.ComponentTypeRename} and appends it to the '<em><b>Owned Component Type Rename</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ComponentTypeRename}.
	 * @see #getOwnedComponentTypeRenames()
	 * @generated
	 */
	ComponentTypeRename createOwnedComponentTypeRename();

	/**
	 * Returns the value of the '<em><b>No Annexes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Annexes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::NoneSupport.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>No Annexes</em>' attribute.
	 * @see #setNoAnnexes(boolean)
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_NoAnnexes()
	 * @model dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isNoAnnexes();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.PackageSection#isNoAnnexes <em>No Annexes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Annexes</em>' attribute.
	 * @see #isNoAnnexes()
	 * @generated
	 */
	void setNoAnnexes(boolean value);

	/**
	 * Returns the value of the '<em><b>No Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Properties</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Associations.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>No Properties</em>' attribute.
	 * @see #setNoProperties(boolean)
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_NoProperties()
	 * @model dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isNoProperties();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.PackageSection#isNoProperties <em>No Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Properties</em>' attribute.
	 * @see #isNoProperties()
	 * @generated
	 */
	void setNoProperties(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Classifier</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.Classifier}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Classifier</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Packaging.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Classifier</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedClassifier()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<Classifier> getOwnedClassifiers();

	/**
	 * Creates a new {@link org.osate.aadl2.Classifier} and appends it to the '<em><b>Owned Classifier</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.osate.aadl2.Classifier} to create.
	 * @return The new {@link org.osate.aadl2.Classifier}.
	 * @see #getOwnedClassifiers()
	 * @generated
	 */
	Classifier createOwnedClassifier(EClass eClass);

	/**
	 * Returns the value of the '<em><b>Owned Feature Group Type Rename</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.FeatureGroupTypeRename}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Feature Group Type Rename</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Packaging.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Feature Group Type Rename</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedFeatureGroupTypeRename()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<FeatureGroupTypeRename> getOwnedFeatureGroupTypeRenames();

	/**
	 * Creates a new {@link org.osate.aadl2.FeatureGroupTypeRename} and appends it to the '<em><b>Owned Feature Group Type Rename</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.FeatureGroupTypeRename}.
	 * @see #getOwnedFeatureGroupTypeRenames()
	 * @generated
	 */
	FeatureGroupTypeRename createOwnedFeatureGroupTypeRename();

	/**
	 * Returns the value of the '<em><b>Owned Annex Library</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.AnnexLibrary}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Annex Library</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Packaging.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Annex Library</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedAnnexLibrary()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<AnnexLibrary> getOwnedAnnexLibraries();

	/**
	 * Creates a new {@link org.osate.aadl2.AnnexLibrary} and appends it to the '<em><b>Owned Annex Library</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.osate.aadl2.AnnexLibrary} to create.
	 * @return The new {@link org.osate.aadl2.AnnexLibrary}.
	 * @see #getOwnedAnnexLibraries()
	 * @generated
	 */
	AnnexLibrary createOwnedAnnexLibrary(EClass eClass);

	/**
	 * Creates a new {@link org.osate.aadl2.DefaultAnnexLibrary} and appends it to the '<em><b>Owned Annex Library</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.DefaultAnnexLibrary}.
	 * @see #getOwnedAnnexLibraries()
	 * @generated
	 */
	AnnexLibrary createOwnedAnnexLibrary();

	/**
	 * Returns the value of the '<em><b>Imported Unit</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.ModelUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Unit</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Packaging.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Imported Unit</em>' reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_ImportedUnit()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ModelUnit> getImportedUnits();

	/**
	 * name lookup from within package.
	 * It searches through all internally visible elements resolving renames as appropriate
	 */
	NamedElement findInternallyVisibleNamedElement(String name);

} // PackageSection
