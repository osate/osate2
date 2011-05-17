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
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedAbstractTypes <em>Owned Abstract Type</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedAbstractImplementations <em>Owned Abstract Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedBusTypes <em>Owned Bus Type</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedBusImplementations <em>Owned Bus Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedDataTypes <em>Owned Data Type</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedDataImplementations <em>Owned Data Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedDeviceTypes <em>Owned Device Type</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedDeviceImplementations <em>Owned Device Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedMemoryTypes <em>Owned Memory Type</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedMemoryImplementations <em>Owned Memory Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedProcessTypes <em>Owned Process Type</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedProcessorTypes <em>Owned Processor Type</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedProcessImplementations <em>Owned Process Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedProcessorImplementations <em>Owned Processor Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedSubprogramTypes <em>Owned Subprogram Type</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedSubprogramImplementations <em>Owned Subprogram Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedSubprogramGroupTypes <em>Owned Subprogram Group Type</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedSubprogramGroupImplementations <em>Owned Subprogram Group Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedSystemTypes <em>Owned System Type</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedSystemImplementations <em>Owned System Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedThreadTypes <em>Owned Thread Type</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedThreadImplementations <em>Owned Thread Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedThreadGroupTypes <em>Owned Thread Group Type</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedThreadGroupImplementations <em>Owned Thread Group Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedVirtualBusTypes <em>Owned Virtual Bus Type</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedVirtualBusImplementations <em>Owned Virtual Bus Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedVirtualProcessorTypes <em>Owned Virtual Processor Type</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedVirtualProcessorImplementations <em>Owned Virtual Processor Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.PackageSection#getOwnedFeatureGroupTypes <em>Owned Feature Group Type</em>}</li>
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
	 * Returns the value of the '<em><b>No Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Properties</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
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
	 * Returns the value of the '<em><b>No Annexes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Annexes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
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
	 * Returns the value of the '<em><b>Owned Classifier</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.Classifier}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * </p>
	 * This feature is a derived union.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Classifier</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Classifier</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedClassifier()
	 * @model containment="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<Classifier> getOwnedClassifiers();

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
	 * The list contents are of type {@link org.osate.aadl2.AadlUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Unit</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Unit</em>' reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_ImportedUnit()
	 * @model ordered="false"
	 * @generated
	 */
	EList<AadlUnit> getImportedUnits();

	/**
	 * Returns the value of the '<em><b>Owned Abstract Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.AbstractType}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Abstract Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Abstract Type</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedAbstractType()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AbstractType> getOwnedAbstractTypes();

	/**
	 * Creates a new {@link org.osate.aadl2.AbstractType} and appends it to the '<em><b>Owned Abstract Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.AbstractType}.
	 * @see #getOwnedAbstractTypes()
	 * @generated
	 */
	AbstractType createOwnedAbstractType();

	/**
	 * Returns the value of the '<em><b>Owned Abstract Implementation</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.AbstractImplementation}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Abstract Implementation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Abstract Implementation</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedAbstractImplementation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AbstractImplementation> getOwnedAbstractImplementations();

	/**
	 * Creates a new {@link org.osate.aadl2.AbstractImplementation} and appends it to the '<em><b>Owned Abstract Implementation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.AbstractImplementation}.
	 * @see #getOwnedAbstractImplementations()
	 * @generated
	 */
	AbstractImplementation createOwnedAbstractImplementation();

	/**
	 * Returns the value of the '<em><b>Owned Bus Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.BusType}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Bus Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Bus Type</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedBusType()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<BusType> getOwnedBusTypes();

	/**
	 * Creates a new {@link org.osate.aadl2.BusType} and appends it to the '<em><b>Owned Bus Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.BusType}.
	 * @see #getOwnedBusTypes()
	 * @generated
	 */
	BusType createOwnedBusType();

	/**
	 * Returns the value of the '<em><b>Owned Bus Implementation</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.BusImplementation}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Bus Implementation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Bus Implementation</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedBusImplementation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<BusImplementation> getOwnedBusImplementations();

	/**
	 * Creates a new {@link org.osate.aadl2.BusImplementation} and appends it to the '<em><b>Owned Bus Implementation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.BusImplementation}.
	 * @see #getOwnedBusImplementations()
	 * @generated
	 */
	BusImplementation createOwnedBusImplementation();

	/**
	 * Returns the value of the '<em><b>Owned Data Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.DataType}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Data Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Data Type</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedDataType()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<DataType> getOwnedDataTypes();

	/**
	 * Creates a new {@link org.osate.aadl2.DataType} and appends it to the '<em><b>Owned Data Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.DataType}.
	 * @see #getOwnedDataTypes()
	 * @generated
	 */
	DataType createOwnedDataType();

	/**
	 * Returns the value of the '<em><b>Owned Data Implementation</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.DataImplementation}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Data Implementation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Data Implementation</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedDataImplementation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<DataImplementation> getOwnedDataImplementations();

	/**
	 * Creates a new {@link org.osate.aadl2.DataImplementation} and appends it to the '<em><b>Owned Data Implementation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.DataImplementation}.
	 * @see #getOwnedDataImplementations()
	 * @generated
	 */
	DataImplementation createOwnedDataImplementation();

	/**
	 * Returns the value of the '<em><b>Owned Device Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.DeviceType}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Device Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Device Type</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedDeviceType()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<DeviceType> getOwnedDeviceTypes();

	/**
	 * Creates a new {@link org.osate.aadl2.DeviceType} and appends it to the '<em><b>Owned Device Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.DeviceType}.
	 * @see #getOwnedDeviceTypes()
	 * @generated
	 */
	DeviceType createOwnedDeviceType();

	/**
	 * Returns the value of the '<em><b>Owned Device Implementation</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.DeviceImplementation}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Device Implementation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Device Implementation</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedDeviceImplementation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<DeviceImplementation> getOwnedDeviceImplementations();

	/**
	 * Creates a new {@link org.osate.aadl2.DeviceImplementation} and appends it to the '<em><b>Owned Device Implementation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.DeviceImplementation}.
	 * @see #getOwnedDeviceImplementations()
	 * @generated
	 */
	DeviceImplementation createOwnedDeviceImplementation();

	/**
	 * Returns the value of the '<em><b>Owned Memory Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.MemoryType}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Memory Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Memory Type</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedMemoryType()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<MemoryType> getOwnedMemoryTypes();

	/**
	 * Creates a new {@link org.osate.aadl2.MemoryType} and appends it to the '<em><b>Owned Memory Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.MemoryType}.
	 * @see #getOwnedMemoryTypes()
	 * @generated
	 */
	MemoryType createOwnedMemoryType();

	/**
	 * Returns the value of the '<em><b>Owned Memory Implementation</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.MemoryImplementation}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Memory Implementation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Memory Implementation</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedMemoryImplementation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<MemoryImplementation> getOwnedMemoryImplementations();

	/**
	 * Creates a new {@link org.osate.aadl2.MemoryImplementation} and appends it to the '<em><b>Owned Memory Implementation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.MemoryImplementation}.
	 * @see #getOwnedMemoryImplementations()
	 * @generated
	 */
	MemoryImplementation createOwnedMemoryImplementation();

	/**
	 * Returns the value of the '<em><b>Owned Process Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.ProcessType}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Process Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Process Type</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedProcessType()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ProcessType> getOwnedProcessTypes();

	/**
	 * Creates a new {@link org.osate.aadl2.ProcessType} and appends it to the '<em><b>Owned Process Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ProcessType}.
	 * @see #getOwnedProcessTypes()
	 * @generated
	 */
	ProcessType createOwnedProcessType();

	/**
	 * Returns the value of the '<em><b>Owned Processor Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.ProcessorType}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Processor Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Processor Type</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedProcessorType()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ProcessorType> getOwnedProcessorTypes();

	/**
	 * Creates a new {@link org.osate.aadl2.ProcessorType} and appends it to the '<em><b>Owned Processor Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ProcessorType}.
	 * @see #getOwnedProcessorTypes()
	 * @generated
	 */
	ProcessorType createOwnedProcessorType();

	/**
	 * Returns the value of the '<em><b>Owned Process Implementation</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.ProcessImplementation}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Process Implementation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Process Implementation</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedProcessImplementation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ProcessImplementation> getOwnedProcessImplementations();

	/**
	 * Creates a new {@link org.osate.aadl2.ProcessImplementation} and appends it to the '<em><b>Owned Process Implementation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ProcessImplementation}.
	 * @see #getOwnedProcessImplementations()
	 * @generated
	 */
	ProcessImplementation createOwnedProcessImplementation();

	/**
	 * Returns the value of the '<em><b>Owned Processor Implementation</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.ProcessorImplementation}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Processor Implementation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Processor Implementation</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedProcessorImplementation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ProcessorImplementation> getOwnedProcessorImplementations();

	/**
	 * Creates a new {@link org.osate.aadl2.ProcessorImplementation} and appends it to the '<em><b>Owned Processor Implementation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ProcessorImplementation}.
	 * @see #getOwnedProcessorImplementations()
	 * @generated
	 */
	ProcessorImplementation createOwnedProcessorImplementation();

	/**
	 * Returns the value of the '<em><b>Owned Feature Group Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.FeatureGroupType}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Feature Group Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Feature Group Type</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedFeatureGroupType()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<FeatureGroupType> getOwnedFeatureGroupTypes();

	/**
	 * Creates a new {@link org.osate.aadl2.FeatureGroupType} and appends it to the '<em><b>Owned Feature Group Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.FeatureGroupType}.
	 * @see #getOwnedFeatureGroupTypes()
	 * @generated
	 */
	FeatureGroupType createOwnedFeatureGroupType();

	/**
	 * Returns the value of the '<em><b>Owned Virtual Processor Implementation</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.VirtualProcessorImplementation}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Virtual Processor Implementation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Virtual Processor Implementation</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedVirtualProcessorImplementation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VirtualProcessorImplementation> getOwnedVirtualProcessorImplementations();

	/**
	 * Creates a new {@link org.osate.aadl2.VirtualProcessorImplementation} and appends it to the '<em><b>Owned Virtual Processor Implementation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.VirtualProcessorImplementation}.
	 * @see #getOwnedVirtualProcessorImplementations()
	 * @generated
	 */
	VirtualProcessorImplementation createOwnedVirtualProcessorImplementation();

	/**
	 * Returns the value of the '<em><b>Owned Virtual Processor Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.VirtualProcessorType}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Virtual Processor Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Virtual Processor Type</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedVirtualProcessorType()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VirtualProcessorType> getOwnedVirtualProcessorTypes();

	/**
	 * Creates a new {@link org.osate.aadl2.VirtualProcessorType} and appends it to the '<em><b>Owned Virtual Processor Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.VirtualProcessorType}.
	 * @see #getOwnedVirtualProcessorTypes()
	 * @generated
	 */
	VirtualProcessorType createOwnedVirtualProcessorType();

	/**
	 * Returns the value of the '<em><b>Owned Thread Group Implementation</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.ThreadGroupImplementation}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Thread Group Implementation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Thread Group Implementation</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedThreadGroupImplementation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ThreadGroupImplementation> getOwnedThreadGroupImplementations();

	/**
	 * Creates a new {@link org.osate.aadl2.ThreadGroupImplementation} and appends it to the '<em><b>Owned Thread Group Implementation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ThreadGroupImplementation}.
	 * @see #getOwnedThreadGroupImplementations()
	 * @generated
	 */
	ThreadGroupImplementation createOwnedThreadGroupImplementation();

	/**
	 * Returns the value of the '<em><b>Owned Thread Implementation</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.ThreadImplementation}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Thread Implementation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Thread Implementation</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedThreadImplementation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ThreadImplementation> getOwnedThreadImplementations();

	/**
	 * Creates a new {@link org.osate.aadl2.ThreadImplementation} and appends it to the '<em><b>Owned Thread Implementation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ThreadImplementation}.
	 * @see #getOwnedThreadImplementations()
	 * @generated
	 */
	ThreadImplementation createOwnedThreadImplementation();

	/**
	 * Returns the value of the '<em><b>Owned Virtual Bus Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.VirtualBusType}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Virtual Bus Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Virtual Bus Type</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedVirtualBusType()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VirtualBusType> getOwnedVirtualBusTypes();

	/**
	 * Creates a new {@link org.osate.aadl2.VirtualBusType} and appends it to the '<em><b>Owned Virtual Bus Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.VirtualBusType}.
	 * @see #getOwnedVirtualBusTypes()
	 * @generated
	 */
	VirtualBusType createOwnedVirtualBusType();

	/**
	 * Returns the value of the '<em><b>Owned Thread Group Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.ThreadGroupType}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Thread Group Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Thread Group Type</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedThreadGroupType()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ThreadGroupType> getOwnedThreadGroupTypes();

	/**
	 * Creates a new {@link org.osate.aadl2.ThreadGroupType} and appends it to the '<em><b>Owned Thread Group Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ThreadGroupType}.
	 * @see #getOwnedThreadGroupTypes()
	 * @generated
	 */
	ThreadGroupType createOwnedThreadGroupType();

	/**
	 * Returns the value of the '<em><b>Owned Thread Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.ThreadType}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Thread Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Thread Type</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedThreadType()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ThreadType> getOwnedThreadTypes();

	/**
	 * Creates a new {@link org.osate.aadl2.ThreadType} and appends it to the '<em><b>Owned Thread Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ThreadType}.
	 * @see #getOwnedThreadTypes()
	 * @generated
	 */
	ThreadType createOwnedThreadType();

	/**
	 * Returns the value of the '<em><b>Owned System Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.SystemType}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned System Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned System Type</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedSystemType()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SystemType> getOwnedSystemTypes();

	/**
	 * Creates a new {@link org.osate.aadl2.SystemType} and appends it to the '<em><b>Owned System Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.SystemType}.
	 * @see #getOwnedSystemTypes()
	 * @generated
	 */
	SystemType createOwnedSystemType();

	/**
	 * Returns the value of the '<em><b>Owned Subprogram Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.SubprogramType}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Subprogram Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Subprogram Type</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedSubprogramType()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SubprogramType> getOwnedSubprogramTypes();

	/**
	 * Creates a new {@link org.osate.aadl2.SubprogramType} and appends it to the '<em><b>Owned Subprogram Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.SubprogramType}.
	 * @see #getOwnedSubprogramTypes()
	 * @generated
	 */
	SubprogramType createOwnedSubprogramType();

	/**
	 * Returns the value of the '<em><b>Owned Subprogram Group Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.SubprogramGroupType}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Subprogram Group Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Subprogram Group Type</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedSubprogramGroupType()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SubprogramGroupType> getOwnedSubprogramGroupTypes();

	/**
	 * Creates a new {@link org.osate.aadl2.SubprogramGroupType} and appends it to the '<em><b>Owned Subprogram Group Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.SubprogramGroupType}.
	 * @see #getOwnedSubprogramGroupTypes()
	 * @generated
	 */
	SubprogramGroupType createOwnedSubprogramGroupType();

	/**
	 * Returns the value of the '<em><b>Owned System Implementation</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.SystemImplementation}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned System Implementation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned System Implementation</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedSystemImplementation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SystemImplementation> getOwnedSystemImplementations();

	/**
	 * Creates a new {@link org.osate.aadl2.SystemImplementation} and appends it to the '<em><b>Owned System Implementation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.SystemImplementation}.
	 * @see #getOwnedSystemImplementations()
	 * @generated
	 */
	SystemImplementation createOwnedSystemImplementation();

	/**
	 * Returns the value of the '<em><b>Owned Subprogram Group Implementation</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.SubprogramGroupImplementation}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Subprogram Group Implementation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Subprogram Group Implementation</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedSubprogramGroupImplementation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SubprogramGroupImplementation> getOwnedSubprogramGroupImplementations();

	/**
	 * Creates a new {@link org.osate.aadl2.SubprogramGroupImplementation} and appends it to the '<em><b>Owned Subprogram Group Implementation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.SubprogramGroupImplementation}.
	 * @see #getOwnedSubprogramGroupImplementations()
	 * @generated
	 */
	SubprogramGroupImplementation createOwnedSubprogramGroupImplementation();

	/**
	 * Returns the value of the '<em><b>Owned Subprogram Implementation</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.SubprogramImplementation}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Subprogram Implementation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Subprogram Implementation</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedSubprogramImplementation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SubprogramImplementation> getOwnedSubprogramImplementations();

	/**
	 * Creates a new {@link org.osate.aadl2.SubprogramImplementation} and appends it to the '<em><b>Owned Subprogram Implementation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.SubprogramImplementation}.
	 * @see #getOwnedSubprogramImplementations()
	 * @generated
	 */
	SubprogramImplementation createOwnedSubprogramImplementation();

	/**
	 * Returns the value of the '<em><b>Owned Virtual Bus Implementation</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.VirtualBusImplementation}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PackageSection#getOwnedClassifiers() <em>Owned Classifier</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Virtual Bus Implementation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Virtual Bus Implementation</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPackageSection_OwnedVirtualBusImplementation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VirtualBusImplementation> getOwnedVirtualBusImplementations();

	/**
	 * Creates a new {@link org.osate.aadl2.VirtualBusImplementation} and appends it to the '<em><b>Owned Virtual Bus Implementation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.VirtualBusImplementation}.
	 * @see #getOwnedVirtualBusImplementations()
	 * @generated
	 */
	VirtualBusImplementation createOwnedVirtualBusImplementation();

	/**
	 * @author dionisio
	 *
	 * switch to add the classifier in the proper list
	 */
	void addClassifier(Classifier classifier);

	/**
	 * Search the namespace for a specific name.  If searching from outside of the package, then
	 * {@code externallyVisibleElementsOnly} should be {@code true}.  If searching from inside the
	 * package, then {@code externallyVisibleElementsOnly} should be {@code false}.  If the flag is
	 * set to {@code false}, then this method will search through all owned members.  It will also
	 * search through all {@link PackageRename} objects that have the
	 * {@link PackageRename#isRenameAll() renameAll} flag set to {@code true}.  If the result is a
	 * {@link ComponentTypeRename} or a {@link FeatureGroupTypeRename}, then this method will
	 * return the classifier that is renamed.  This means that when
	 * {@code externallyVisibleElementsOnly} is {@code false}, this method can return a
	 * {@link NamedElement} that is a member of a different {@link AadlPackage}.  If
	 * {@code externallyVisibleElementsOnly} is {@code true} and this method is called on a
	 * {@link PublicPackageSection}, then this method searches through some of the owned members.
	 * The search will not include instances of {@link PackageRename}, {@link ComponentTypeRename},
	 * or {@link FeatureGroupTypeRename}.  If {@code externallyVisibleElementsOnly} is {@code true}
	 * and this method is called on a {@link PrivatePackageSection}, then this method will return
	 * {@code null} because there are no elements of a {@link PrivatePackageSection} that are
	 * externally visible.
	 */
	NamedElement findNamedElement(String name, boolean externallyVisibleElementsOnly);
} // PackageSection
