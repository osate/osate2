/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Namespace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A namespace is an element in a model that contains a set of named elements that can be identified by name.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Namespace#getOwnedMember <em>Owned Member</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Namespace#getMember <em>Member</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getNamespace()
 * @model abstract="true"
 * @generated
 */
public interface Namespace extends NamedElement
{
   /**
	 * Returns the value of the '<em><b>Owned Member</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement}.
	 * It is bidirectional and its opposite is '{@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A collection of NamedElements owned by the Namespace.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Member</em>' containment reference list.
	 * @see #isSetOwnedMember()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getNamespace_OwnedMember()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getNamespace
	 * @model opposite="namespace" containment="true" unsettable="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.topcased.org/documentation documentation='A collection of NamedElements owned by the Namespace.'"
	 * @generated
	 */
   EList<NamedElement> getOwnedMember();

   /**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Namespace#getOwnedMember <em>Owned Member</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Owned Member</em>' containment reference list is set.
	 * @see #getOwnedMember()
	 * @generated
	 */
   boolean isSetOwnedMember();

   /**
	 * Returns the value of the '<em><b>Member</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement}.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A collection of NamedElements identifiable within the Namespace, either by being owned or by being introduced by importing or inheritance.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Member</em>' containment reference list.
	 * @see #isSetMember()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getNamespace_Member()
	 * @model containment="true" unsettable="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.topcased.org/documentation documentation='A collection of NamedElements identifiable within the Namespace, either by being owned or by being introduced by importing or inheritance.'"
	 * @generated
	 */
   EList<NamedElement> getMember();

   /**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Namespace#getMember <em>Member</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Member</em>' containment reference list is set.
	 * @see #getMember()
	 * @generated
	 */
   boolean isSetMember();

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * All the members of a Namespace are distinguishable within it.
	 * membersAreDistinguishable()
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='membersAreDistinguishable()'"
	 * @generated
	 */
   boolean members_distinguishable(DiagnosticChain diagnostics, Map<Object, Object> context);

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query getNamesOfMember() gives a set of all of the names that a member would have in a Namespace. In general a member can have multiple names in a Namespace if it is imported more than once with different aliases. Those semantics are specified by overriding the getNamesOfMember operation. The specification here simply returns a set containing a single name, or the empty set if no name.
	 * if member->includes(element) then
	 *   Set{}->including(element.name)
	 * else
	 *   Set{}
	 * endif
	 * <!-- end-model-doc -->
	 * @model dataType="fr.tpt.aadl.annex.behavior.aadlba.String" ordered="false" elementRequired="true" elementOrdered="false"
	 *        annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='if member->includes(element) then\r\n  Set{}->including(element.name)\r\nelse\r\n  Set{}\r\nendif'"
	 * @generated
	 */
   EList<String> getNamesOfMember(NamedElement element);

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Boolean query membersAreDistinguishable() determines whether all of the namespaces members are distinguishable within it.
	 * self.member->forAll( memb | self.member->excluding(memb)->forAll(other | memb.isDistinguishableFrom(other, self)))
	 * <!-- end-model-doc -->
	 * @model dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean" required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.member->forAll( memb | self.member->excluding(memb)->forAll(other | memb.isDistinguishableFrom(other, self)))'"
	 * @generated
	 */
   boolean membersAreDistinguishable();

} // Namespace
