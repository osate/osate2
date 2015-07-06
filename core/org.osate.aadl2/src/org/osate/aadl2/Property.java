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
 * $Id: Property.java,v 1.13 2011-04-11 13:35:55 lwrage Exp $
 */
package org.osate.aadl2;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.properties.EvaluatedProperty;
import org.osate.aadl2.properties.EvaluationContext;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyEvaluationResult;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLProperties::Definitions.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.aadl2.Property#isInherit <em>Inherit</em>}</li>
 *   <li>{@link org.osate.aadl2.Property#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.osate.aadl2.Property#getAppliesToMetaclasses <em>Applies To Metaclass</em>}</li>
 *   <li>{@link org.osate.aadl2.Property#getAppliesToClassifiers <em>Applies To Classifier</em>}</li>
 *   <li>{@link org.osate.aadl2.Property#getAppliesTos <em>Applies To</em>}</li>
 *   <li>{@link org.osate.aadl2.Property#isEmptyListDefault <em>Empty List Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.aadl2.Aadl2Package#getProperty()
 * @model
 * @generated
 */
public interface Property extends BasicProperty, AbstractNamedValue, ArraySizeProperty {
	/**
	 * Returns the value of the '<em><b>Inherit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Definitions.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inherit</em>' attribute.
	 * @see #setInherit(boolean)
	 * @see org.osate.aadl2.Aadl2Package#getProperty_Inherit()
	 * @model dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isInherit();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.Property#isInherit <em>Inherit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inherit</em>' attribute.
	 * @see #isInherit()
	 * @generated
	 */
	void setInherit(boolean value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Definitions.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Value</em>' containment reference.
	 * @see #setDefaultValue(PropertyExpression)
	 * @see org.osate.aadl2.Aadl2Package#getProperty_DefaultValue()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	PropertyExpression getDefaultValue();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.Property#getDefaultValue <em>Default Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' containment reference.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(PropertyExpression value);

	/**
	 * Returns the value of the '<em><b>Applies To</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.PropertyOwner}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applies To</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Definitions.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Applies To</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getProperty_AppliesTo()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<PropertyOwner> getAppliesTos();

	/**
	 * Creates a new {@link org.osate.aadl2.PropertyOwner} and appends it to the '<em><b>Applies To</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.osate.aadl2.PropertyOwner} to create.
	 * @return The new {@link org.osate.aadl2.PropertyOwner}.
	 * @see #getAppliesTos()
	 * @generated
	 */
	PropertyOwner createAppliesTo(EClass eClass);

	/**
	 * Returns the value of the '<em><b>Empty List Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Empty List Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Definitions.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Empty List Default</em>' attribute.
	 * @see #setEmptyListDefault(boolean)
	 * @see org.osate.aadl2.Aadl2Package#getProperty_EmptyListDefault()
	 * @model dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isEmptyListDefault();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.Property#isEmptyListDefault <em>Empty List Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Empty List Default</em>' attribute.
	 * @see #isEmptyListDefault()
	 * @generated
	 */
	void setEmptyListDefault(boolean value);

	/**
	 * Creates a new {@link org.osate.aadl2.PropertyExpression} and sets the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.osate.aadl2.PropertyExpression} to create.
	 * @return The new {@link org.osate.aadl2.PropertyExpression}.
	 * @see #getDefaultValue()
	 * @generated
	 */
	PropertyExpression createDefaultValue(EClass eClass);

	/**
	 * Returns the value of the '<em><b>Applies To Metaclass</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.MetaclassReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applies To Metaclass</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Definitions.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Applies To Metaclass</em>' reference list.
	 * @see org.osate.aadl2.Aadl2Package#getProperty_AppliesToMetaclass()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<MetaclassReference> getAppliesToMetaclasses();

	/**
	 * Returns the value of the '<em><b>Applies To Classifier</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.Classifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applies To Classifier</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Definitions.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Applies To Classifier</em>' reference list.
	 * @see org.osate.aadl2.Aadl2Package#getProperty_AppliesToClassifier()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<Classifier> getAppliesToClassifiers();

	/**
	 * Evaluate a referenced property.
	 *
	 * @return The evaluated property values, one per append operation.
	 * @throws InvalidModelException Thrown if there is a problem with the
	 * model that prevents the property value from being evaluated.
	 */
	PropertyEvaluationResult evaluate(EvaluationContext ctx);

	EvaluatedProperty evaluateDefault(EvaluationContext ctx);

}
