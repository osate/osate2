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
 * A representation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A named element is an element in a model that may have a name.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getName <em>Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getNamespace <em>Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getNamedElement()
 * @model abstract="true"
 * @generated
 */
public interface NamedElement extends Element
{
   /**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the NamedElement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getNamedElement_Name()
	 * @model dataType="fr.tpt.aadl.annex.behavior.aadlba.String" ordered="false"
	 *        annotation="http://www.topcased.org/documentation documentation='The name of the NamedElement.'"
	 * @generated
	 */
   String getName();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
   void setName(String value);

   /**
	 * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Qualified Name</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Name</em>' attribute.
	 * @see #setQualifiedName(String)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getNamedElement_QualifiedName()
	 * @model dataType="fr.tpt.aadl.annex.behavior.aadlba.String" ordered="false"
	 * @generated
	 */
   String getQualifiedName();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #getQualifiedName()
	 * @generated
	 */
   void setQualifiedName(String value);

   /**
	 * Returns the value of the '<em><b>Namespace</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fr.tpt.aadl.annex.behavior.aadlba.Namespace#getOwnedMember <em>Owned Member</em>}'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the namespace that owns the NamedElement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Namespace</em>' container reference.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getNamedElement_Namespace()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Namespace#getOwnedMember
	 * @model opposite="ownedMember" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.topcased.org/documentation documentation='Specifies the namespace that owns the NamedElement.'"
	 * @generated
	 */
   Namespace getNamespace();

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If there is no name, or one of the containing namespaces has no name, there is no qualified name.
	 * (self.name->isEmpty() or self.allNamespaces()->select(ns | ns.name->isEmpty())->notEmpty()) implies self.qualifiedName->isEmpty()
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='(self.name->isEmpty() or self.allNamespaces()->select(ns | ns.name->isEmpty())->notEmpty()) implies self.qualifiedName->isEmpty()'"
	 * @generated
	 */
   boolean has_no_qualified_name(DiagnosticChain diagnostics, Map<Object, Object> context);

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * When there is a name, and all of the containing namespaces have a name, the qualified name is constructed from the names of the containing namespaces.
	 * (self.name->notEmpty() and self.allNamespaces()->select(ns | ns.name->isEmpty())->isEmpty()) 
	 * implies 
	 * self.qualifiedName = self.allNamespaces()->iterate(ns: Namespace; result: String = self.name | ns.name.concat(self.separator()).concat(result))
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='(self.name->notEmpty() and self.allNamespaces()->select(ns | ns.name->isEmpty())->isEmpty()) \r\nimplies \r\nself.qualifiedName = self.allNamespaces()->iterate(ns: Namespace; result: String = self.name | ns.name.concat(self.separator()).concat(result))'"
	 * @generated
	 */
   boolean has_qualified_name(DiagnosticChain diagnostics, Map<Object, Object> context);

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query allNamespaces() gives the sequence of namespaces in which the NamedElement is nested, working outwards.
	 * if self.namespace->isEmpty() then 
	 *   Sequence{}
	 * else
	 *   self.namespace.allNamespaces()->prepend(self.namespace)
	 * endif
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='if self.namespace->isEmpty() then \r\n  Sequence{}\r\nelse\r\n  self.namespace.allNamespaces()->prepend(self.namespace)\r\nendif'"
	 * @generated
	 */
   EList<Namespace> allNamespaces();

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query isDistinguishableFrom() determines whether two NamedElements may logically co-exist within a Namespace. By default, two named elements are distinguishable if (a) they have unrelated types or (b) they have related types but different names.
	 * if self.oclIsKindOf(n.oclType) or n.oclIsKindOf(self.oclType) then
	 *   ns.getNamesOfMember(self)->intersection(ns.getNamesOfMember(n))->isEmpty()
	 * else
	 *   true
	 * endif
	 * <!-- end-model-doc -->
	 * @model dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean" required="true" ordered="false" nRequired="true" nOrdered="false" nsRequired="true" nsOrdered="false"
	 *        annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='if self.oclIsKindOf(n.oclType) or n.oclIsKindOf(self.oclType) then\r\n  ns.getNamesOfMember(self)->intersection(ns.getNamesOfMember(n))->isEmpty()\r\nelse\r\n  true\r\nendif'"
	 * @generated
	 */
   boolean isDistinguishableFrom(NamedElement n, Namespace ns);

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query separator() gives the string that is used to separate names when constructing a qualified name.
	 * '.'
	 * <!-- end-model-doc -->
	 * @model dataType="fr.tpt.aadl.annex.behavior.aadlba.String" required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='\'.\''"
	 * @generated
	 */
   String separator();

} // NamedElement
