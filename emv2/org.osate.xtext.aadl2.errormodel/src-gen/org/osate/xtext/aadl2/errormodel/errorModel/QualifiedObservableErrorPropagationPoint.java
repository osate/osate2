/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.Element;
import org.osate.aadl2.Subcomponent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Observable Error Propagation Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedObservableErrorPropagationPoint#getSubcomponent <em>Subcomponent</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedObservableErrorPropagationPoint#getObservablePoint <em>Observable Point</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getQualifiedObservableErrorPropagationPoint()
 * @model
 * @generated
 */
public interface QualifiedObservableErrorPropagationPoint extends EObject, Element
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
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getQualifiedObservableErrorPropagationPoint_Subcomponent()
	 * @model
	 * @generated
	 */
  Subcomponent getSubcomponent();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedObservableErrorPropagationPoint#getSubcomponent <em>Subcomponent</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subcomponent</em>' reference.
	 * @see #getSubcomponent()
	 * @generated
	 */
  void setSubcomponent(Subcomponent value);

  /**
	 * Returns the value of the '<em><b>Observable Point</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Observable Point</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Observable Point</em>' reference.
	 * @see #setObservablePoint(ErrorPropagation)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getQualifiedObservableErrorPropagationPoint_ObservablePoint()
	 * @model
	 * @generated
	 */
  ErrorPropagation getObservablePoint();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedObservableErrorPropagationPoint#getObservablePoint <em>Observable Point</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Observable Point</em>' reference.
	 * @see #getObservablePoint()
	 * @generated
	 */
  void setObservablePoint(ErrorPropagation value);

} // QualifiedObservableErrorPropagationPoint
