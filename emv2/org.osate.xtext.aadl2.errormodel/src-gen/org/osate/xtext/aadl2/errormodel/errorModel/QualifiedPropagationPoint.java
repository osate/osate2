/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Propagation Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint#getSubcomponents <em>Subcomponents</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint#getPropagationPoint <em>Propagation Point</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getQualifiedPropagationPoint()
 * @model
 * @generated
 */
public interface QualifiedPropagationPoint extends EObject, Element
{
  /**
   * Returns the value of the '<em><b>Subcomponents</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subcomponents</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subcomponents</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getQualifiedPropagationPoint_Subcomponents()
   * @model containment="true"
   * @generated
   */
  EList<SubcomponentElement> getSubcomponents();

  /**
   * Returns the value of the '<em><b>Propagation Point</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Propagation Point</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Propagation Point</em>' reference.
   * @see #setPropagationPoint(PropagationPoint)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getQualifiedPropagationPoint_PropagationPoint()
   * @model
   * @generated
   */
  PropagationPoint getPropagationPoint();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint#getPropagationPoint <em>Propagation Point</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Propagation Point</em>' reference.
   * @see #getPropagationPoint()
   * @generated
   */
  void setPropagationPoint(PropagationPoint value);

} // QualifiedPropagationPoint
