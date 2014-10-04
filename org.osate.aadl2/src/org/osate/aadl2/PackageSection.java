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
 * $Id: PackageSection.java,v 1.36 2009-03-31 15:50:14 lwrage Exp $
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
 * </p>
 *
 * @see org.osate.aadl2.Aadl2Package#getPackageSection()
 * @model abstract="true"
 * @generated
 */
public interface PackageSection extends Namespace {
	/**
	 * Returns the value of the '<em><b>Owned Package Rename</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.PackageRename}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * </p>
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
