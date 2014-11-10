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
 * $Id: NamedElement.java,v 1.30 2010-05-04 18:13:32 lwrage Exp $
 */
package org.osate.aadl2;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.impl.NamedElementImpl;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyIsListException;
import org.osate.aadl2.properties.PropertyIsModalException;
import org.osate.aadl2.properties.PropertyNotPresentException;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Named Element</b></em>'. <!-- end-user-doc --> <!-- begin-model-doc
 * --> A named element is an element in a model that may have a name. <!--
 * end-model-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.osate.aadl2.NamedElement#getName <em>Name</em>}</li>
 * <li>{@link org.osate.aadl2.NamedElement#getQualifiedName <em>Qualified
 * Name</em>}</li>
 * <li>{@link org.osate.aadl2.NamedElement#getNamespace <em>Namespace
 * </em>}</li>
 * <li>{@link org.osate.aadl2.NamedElement#getOwnedPropertyAssociations
 * <em>Owned Property Association</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.aadl2.Aadl2Package#getNamedElement()
 * @model abstract="true"
 * @generated
 */
public interface NamedElement extends Element {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The
	 * name of the NamedElement. <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.osate.aadl2.Aadl2Package#getNamedElement_Name()
	 * @model dataType="org.osate.aadl2.String" ordered="false"
	 *        annotation="http://www.topcased.org/documentation documentation='The name of the NamedElement.'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.NamedElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Qualified Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> A name
	 * which allows the NamedElement to be identified within a hierarchy of
	 * nested Namespaces. It is constructed from the names of the containing
	 * namespaces starting at the root of the hierarchy and ending with the name
	 * of the NamedElement itself. <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Qualified Name</em>' attribute.
	 * @see org.osate.aadl2.Aadl2Package#getNamedElement_QualifiedName()
	 * @model dataType="org.osate.aadl2.String" transient="true"
	 *        changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.topcased.org/documentation documentation='A name which allows the NamedElement to be identified within a hierarchy of nested Namespaces. It is constructed from the names of the containing namespaces starting at the root of the hierarchy and ending with the name of the NamedElement itself.'"
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Returns the value of the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.PropertyAssociation}.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Owned Property Association</em>' containment
	 * reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Associations.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Property Association</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getNamedElement_OwnedPropertyAssociation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<PropertyAssociation> getOwnedPropertyAssociations();

	/**
	 * Creates a new {@link org.osate.aadl2.PropertyAssociation} and appends it to the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.PropertyAssociation}.
	 * @see #getOwnedPropertyAssociations()
	 * @generated
	 */
	PropertyAssociation createOwnedPropertyAssociation();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> If
	 * there is no name, or one of the containing namespaces has no name, there
	 * is no qualified name. (self.name->isEmpty() or
	 * self.allNamespaces()->select(ns | ns.name->isEmpty())->notEmpty())
	 * implies self.qualifiedName->isEmpty()
	 *
	 * @param diagnostics The chain of diagnostics to which problems are to be
	 *            appended.
	 * @param context The cache of context-specific information. <!--
	 *            end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='(self.name->isEmpty() or self.allNamespaces()->select(ns | ns.name->isEmpty())->notEmpty()) implies self.qualifiedName->isEmpty()'"
	 * @generated
	 */
	boolean has_no_qualified_name(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * When there is a name, and all of the containing namespaces have a name,
	 * the qualified name is constructed from the names of the containing
	 * namespaces. (self.name->notEmpty() and self.allNamespaces()->select(ns |
	 * ns.name->isEmpty())->isEmpty()) implies self.qualifiedName =
	 * self.allNamespaces()->iterate(ns: Namespace; result: String = self.name |
	 * ns.name.concat(self.separator()).concat(result))
	 *
	 * @param diagnostics The chain of diagnostics to which problems are to be
	 *            appended.
	 * @param context The cache of context-specific information. <!--
	 *            end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='(self.name->notEmpty() and self.allNamespaces()->select(ns | ns.name->isEmpty())->isEmpty()) \r\nimplies \r\nself.qualifiedName = self.allNamespaces()->iterate(ns: Namespace; result: String = self.name | ns.name.concat(self.separator()).concat(result))'"
	 * @generated
	 */
	boolean has_qualified_name(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true" ordered="false"
	 * @generated
	 */
	Namespace getNamespace();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * The query allNamespaces() gives the sequence of namespaces in which the
	 * NamedElement is nested, working outwards. if self.namespace->isEmpty()
	 * then Sequence{} else
	 * self.namespace.allNamespaces()->prepend(self.namespace) endif <!--
	 * end-model-doc -->
	 *
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='if self.namespace->isEmpty() then \r\n  Sequence{}\r\nelse\r\n  self.namespace.allNamespaces()->prepend(self.namespace)\r\nendif'"
	 * @generated
	 */
	EList<Namespace> allNamespaces();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * The query isDistinguishableFrom() determines whether two NamedElements
	 * may logically co-exist within a Namespace. By default, two named elements
	 * are distinguishable if (a) they have unrelated types or (b) they have
	 * related types but different names. if self.oclIsKindOf(n.oclType) or
	 * n.oclIsKindOf(self.oclType) then
	 * ns.getNamesOfMember(self)->intersection(ns
	 * .getNamesOfMember(n))->isEmpty() else true endif <!-- end-model-doc -->
	 *
	 * @model dataType="org.osate.aadl2.Boolean" required="true"
	 *        ordered="false" nRequired="true" nOrdered="false"
	 *        nsRequired="true" nsOrdered="false" annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='if self.oclIsKindOf(n.oclType) or n.oclIsKindOf(self.oclType) then\r\n  ns.getNamesOfMember(self)->intersection(ns.getNamesOfMember(n))->isEmpty()\r\nelse\r\n  true\r\nendif'"
	 * @generated
	 */
	boolean isDistinguishableFrom(NamedElement n, Namespace ns);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * The query separator() gives the string that is used to separate names
	 * when constructing a qualified name. '.' <!-- end-model-doc -->
	 *
	 * @model dataType="org.osate.aadl2.String" required="true"
	 *        ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='\'.\''"
	 * @generated
	 */
	String separator();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * When there is a name, and all of the containing namespaces have a name,
	 * the qualified name is constructed from the names of the containing
	 * namespaces. if self.name->notEmpty() and self.allNamespaces()->select(ns
	 * | ns.name->isEmpty())->isEmpty() then self.allNamespaces()->iterate(ns:
	 * Namespace; result: String = self.name |
	 * ns.name.concat(self.separator()).concat(result)) else '' endif <!--
	 * end-model-doc -->
	 *
	 * @model dataType="org.osate.aadl2.String" required="true"
	 *        ordered="false" annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='if self.name->notEmpty() and self.allNamespaces()->select(ns | ns.name->isEmpty())->isEmpty() then\r\n  self.allNamespaces()->iterate(ns: Namespace; result: String = self.name | ns.name.concat(self.separator()).concat(result))\r\nelse \r\n  \'\' \r\nendif'"
	 * @generated
	 */
	String qualifiedName();

	/**
	 * Get the component name including array indices
	 *
	 * @return name as string
	 */
	String getFullName();

	/**
	 * Returns {@code true} if this {@code NamedElement} has a name. This method
	 * will check for {@code null} and the empty string.
	 *
	 * @return {@code true} if object has a name; {@code false} otherwise.
	 */
	boolean hasName();

	/**
	 * Retrieves the property value of a non-modal, single-valued property. Use
	 * this method if you know the property can only have a single value and is
	 * not modal. This method may also be safely used to look up a modal
	 * property value on an instance object when the current system operation
	 * mode is non-null; in this case the returned value is that value
	 * associated with the current system operation mode.
	 *
	 * @param property Property
	 * @return The PropertyValue. This will never be null.
	 * @throws InvalidModelException Thrown if the property value cannot be
	 *             retrieved because the model is incomplete or otherwise
	 *             invalid.
	 * @throws PropertyNotPresentException Thrown if the property is undefined
	 *             for this NamedElement.
	 * @throws PropertyIsModalException Thrown if this NamedElement is modal and
	 *             declarative.
	 * @throws IllegalStateException Thrown if the lookup encounters a cycle of
	 *             property reference dependencies.
	 * @throws IllegalArgumentException Thrown if property is null.
	 * @throws PropertyDoesNotApplyToHolderException Thrown if the Property
	 *             property does not apply to this NamedElement.
	 * @throws PropertyIsListException Thrown if the property is not scalar.
	 * @see org.osate.aadl2.instance.SystemInstance#setCurrentSystemOperationMode(org.osate.aadl2.instance.SystemOperationMode)
	 */
	PropertyExpression getSimplePropertyValue(Property property) throws InvalidModelException,
			PropertyNotPresentException, PropertyIsModalException, IllegalStateException, IllegalArgumentException,
			PropertyDoesNotApplyToHolderException, PropertyIsListException;

	/**
	 * Get the property value for a particular model element and property. The
	 * property value is computed based on the rules in the AADL spec. The
	 * returned value is a structure that further refines the property value
	 * based on modes.
	 *
	 * @param property The property whose value is to be retieved.
	 * @return The property value. This will never be <code>null</code>.
	 * @throws IllegalStateException Thrown if the lookup encounters a cycle of
	 *             property reference dependencies.
	 * @throws InvalidModelException Thrown if the property value cannot be
	 *             retrieved because the model is incomplete or otherwise
	 *             invalid.
	 * @throws PropertyDoesNotApplyToHolderException Thrown if the given
	 *             property does not apply to the property holder, i.e.,
	 *             {@link #acceptsProperty(Property)} returns <code>false</code>
	 *             .
	 * @throws IllegalArgumentException Thrown if property is <code>null</code>.
	 */
	PropertyAcc getPropertyValue(Property property) throws IllegalStateException, InvalidModelException,
			PropertyDoesNotApplyToHolderException, IllegalArgumentException;

	/**
	 * Query whether this object accepts values for the given property. That is,
	 * does the given property apply to this element?
	 *
	 * @param property The property definition to test.
	 * @return <code>true</code> if the given property applies to this element.
	 */
	boolean acceptsProperty(Property property);

	/**
	 * Helper routine for computing the value of the property. As the name
	 * suggests, this method is not intended for use by clients of the model,
	 * but is used during the property lookup process. It should really be a
	 * protected method in {@link NamedElementImpl}, but because of the way that
	 * EMF deals with multiple inheritance, not all implementations of
	 * NamedElement actually extend from NamedElementImpl.
	 * <p>
	 * In particular, this method does not create a new property value
	 * accumulator&mdash;it uses the one provided&mdash;and it does not look up
	 * the default value of the property.
	 *
	 * @param property The property whose value is to be retrieved. It must be
	 *            the case that this property is accepted by the property
	 *            holder, i.e., {@link #acceptsProperty(Property)} must return
	 *            <code>true</code>.
	 * @param paa The working property value accumulator to add results to.
	 * @param fromInstanceSlaveCall <code>true</code> if the call is performing
	 *            a lookup on the declarative model on behalf of an instance
	 *            model object. When <code>true</code> the lookup algorithm
	 *            ignores the "inherits" attribute on property definitions when
	 *            it would mean that the lookup should defer to the containing
	 *            component implementation. Also disables the interpretation of
	 *            contained property associations in the declarative model
	 *            because they have already been applied to the instance model
	 *            at this point. The expectation is that the instance model
	 *            lookup itself is not ignoring the inherits attribute, and thus
	 *            any inherited property values will still be found correctly.
	 *            Interpreting the inherits attribute during the declarative
	 *            model search is redundant and causes problems later on. This
	 *            flag does not affect lookup for feature declarations because
	 *            in that case the inherit flag defers to the component type or
	 *            feature group type.
	 * @throws InvalidModelException Thrown if the property value cannot be
	 *             retrieved because the model is incomplete or otherwise
	 *             invalid.
	 */
	void getPropertyValueInternal(Property property, PropertyAcc pas, boolean fromInstanceSlaveCall)
			throws InvalidModelException;

	/**
	 * Set property association for given property definition with specified
	 * value list. The property association is assumed to apply to all modes;
	 * all previous property associations for this property are removed from the
	 * property holder. The {@link PropertyAssociation#isDerived()} status of
	 * the association is set to <code>false</code>.
	 * <p>
	 * When the property is not list-valued, i.e., <code>pd.isList()</code> is
	 * <code>false</code>, the provided list of values must be of length 1,
	 * i.e., <code>pvl.size() == 1</code>.
	 * <p>
	 * When invoked on an instance model object (i.e., a subtype of
	 * {@link InstanceObject}), the property association is made to apply only
	 * to current system operation mode as determined from the containing system
	 * instance's {@link SystemInstance#getCurrentSystemOperationMode()} method.
	 *
	 * @param pd property definition object
	 * @param pvl List of property value objects.
	 * @return PropertyAssociation that has been set
	 * @exception IllegalArgumentException Thrown if the property value cannot
	 *                be set. This could be because the given property doesn't
	 *                apply to this property holder, the property value isn't
	 *                list-valued and the given list does not have exactly 1
	 *                element, or because of type mismatch issues.
	 */
	PropertyAssociation setPropertyValue(Property pd, List<? extends PropertyExpression> pvl);

	/**
	 * Check that the proposed association is legal for this property holder. If
	 * the association is legal, then the method returns normally, otherwise it
	 * throws an <code>IllegalArgumentException</code> describing the problem.
	 *
	 * @throws IllegalArgumentException (see description)
	 */
	void checkPropertyAssociation(final Property pd, final Collection<? extends PropertyExpression> vals);

	/**
	 * Remove all the local property associations for the given property
	 * definition. Only the property associations directly contained in the
	 * NamedElement are affected, that is, any contained property associations
	 * declared in this component, but applicable to another component are not
	 * searched.
	 *
	 * @param pd The property definition
	 */
	void removePropertyAssociations(Property pd);

	/**
	 * Modify the modal property associations so that there are no local
	 * associations for the given property for the given modes. Does not affect
	 * the property's non-modal association. This method may both remove
	 * associations (if all the association's modes are in the given list) and
	 * modify associations (if some of the association's modes are in the given
	 * list). Only the property associations directly contained in the
	 * NamedElement are affected, that is, any contained property associations
	 * declared in this component, but applicable to another component are not
	 * searched.
	 *
	 * @param pd The property definition
	 * @param modes list of modes
	 */
	void removePropertyAssociations(Property pd, List<? extends Mode> modes);

	/**
	 * Set property association for given property definition to the specified
	 * value list in the given modes. The existing value list is replaced for
	 * the given modes. The {@link PropertyAssociation#isDerived()} status of
	 * the association is set to <code>false</code>.
	 * <p>
	 * When the property is not list-valued, i.e., <code>pd.isList()</code> is
	 * <code>false</code>, the provided list of values must be of length 1,
	 * i.e., <code>pvl.size() == 1</code>.
	 * <p>
	 * Unlike {@link #setPropertyValue(Property, List)}, this method is not
	 * affected by the current system operation mode.
	 *
	 * @param pd property definition object
	 * @param pvl List of property value objects
	 * @param modes list of modes.
	 * @return PropertyAssociation that has been set
	 * @exception IllegalArgumentException Thrown if the property value cannot
	 *                be set. This could be because the given property doesn't
	 *                apply to this property holder, the property value isn't
	 *                list-valued and the given list does not have exactly 1
	 *                element, or because of type mismatch issues.
	 */
	PropertyAssociation setPropertyValue(Property pd, List<? extends PropertyExpression> pvl, List<? extends Mode> modes);

	public List<? extends PropertyExpression> getPropertyValueList(final Property property);

	public PropertyAssociation setPropertyValue(final Property pd, final PropertyValue pv);

	/**
	 * DB: Added for OCL.
	 * @param property
	 * @param mode
	 * @return
	 * @throws InvalidModelException
	 * @throws IllegalArgumentException
	 * @throws PropertyIsModalException
	 * @throws IllegalStateException
	 * @throws PropertyDoesNotApplyToHolderException
	 */
	EList<PropertyExpression> getPropertyValues(String propertySetName, String propertyName)
			throws InvalidModelException, IllegalArgumentException, PropertyIsModalException, IllegalStateException,
			PropertyDoesNotApplyToHolderException;

	PropertyExpression getNonModalPropertyValue(Property pd);

} // NamedElement
