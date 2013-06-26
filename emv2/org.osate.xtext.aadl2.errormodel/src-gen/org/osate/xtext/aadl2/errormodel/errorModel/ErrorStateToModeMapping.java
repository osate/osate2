/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.Element;
import org.osate.aadl2.Mode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error State To Mode Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping#getErrorState <em>Error State</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping#getMappedModes <em>Mapped Modes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorStateToModeMapping()
 * @model
 * @generated
 */
public interface ErrorStateToModeMapping extends EObject, Element
{
  /**
   * Returns the value of the '<em><b>Error State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Error State</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Error State</em>' reference.
   * @see #setErrorState(ErrorBehaviorState)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorStateToModeMapping_ErrorState()
   * @model
   * @generated
   */
  ErrorBehaviorState getErrorState();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping#getErrorState <em>Error State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Error State</em>' reference.
   * @see #getErrorState()
   * @generated
   */
  void setErrorState(ErrorBehaviorState value);

  /**
   * Returns the value of the '<em><b>Mapped Modes</b></em>' reference list.
   * The list contents are of type {@link org.osate.aadl2.Mode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mapped Modes</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mapped Modes</em>' reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorStateToModeMapping_MappedModes()
   * @model
   * @generated
   */
  EList<Mode> getMappedModes();

} // ErrorStateToModeMapping
