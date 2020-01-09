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
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.Property#isInherit <em>Inherit</em>}</li>
 *   <li>{@link org.osate.aadl2.Property#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.osate.aadl2.Property#getAppliesToMetaclasses <em>Applies To Metaclass</em>}</li>
 *   <li>{@link org.osate.aadl2.Property#getAppliesToClassifiers <em>Applies To Classifier</em>}</li>
 *   <li>{@link org.osate.aadl2.Property#getAppliesTos <em>Applies To</em>}</li>
 *   <li>{@link org.osate.aadl2.Property#isEmptyListDefault <em>Empty List Default</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getProperty()
 * @model
 * @generated
 */
public interface Property extends BasicProperty, AbstractNamedValue {
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
	PropertyEvaluationResult evaluate(EvaluationContext ctx, int depth);

	EvaluatedProperty evaluateDefault(EvaluationContext ctx);

}
