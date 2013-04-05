/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.Element;
import org.osate.aadl2.Subcomponent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Propagation Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint#getSubcomponent <em>Subcomponent</em>}</li>
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
	 * Returns the value of the '<em><b>Subcomponent</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subcomponent</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Subcomponent</em>' reference.
	 * @see #setSubcomponent(Subcomponent)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getQualifiedPropagationPoint_Subcomponent()
	 * @model
	 * @generated
	 */
  Subcomponent getSubcomponent();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint#getSubcomponent <em>Subcomponent</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subcomponent</em>' reference.
	 * @see #getSubcomponent()
	 * @generated
	 */
  void setSubcomponent(Subcomponent value);

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
