/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EM2 Annex Subclause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EM2AnnexSubclause#getTypes <em>Types</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EM2AnnexSubclause#getEbsm <em>Ebsm</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EM2AnnexSubclause#getEp <em>Ep</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EM2AnnexSubclause#getCeb <em>Ceb</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EM2AnnexSubclause#getCompeb <em>Compeb</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEM2AnnexSubclause()
 * @model
 * @generated
 */
public interface EM2AnnexSubclause extends EObject
{
  /**
   * Returns the value of the '<em><b>Types</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeSet}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Types</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEM2AnnexSubclause_Types()
   * @model containment="true"
   * @generated
   */
  EList<ErrorTypeSet> getTypes();

  /**
   * Returns the value of the '<em><b>Ebsm</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ebsm</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ebsm</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEM2AnnexSubclause_Ebsm()
   * @model containment="true"
   * @generated
   */
  EList<ErrorBehaviorStateMachine> getEbsm();

  /**
   * Returns the value of the '<em><b>Ep</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ep</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ep</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEM2AnnexSubclause_Ep()
   * @model containment="true"
   * @generated
   */
  EList<ErrorPropagations> getEp();

  /**
   * Returns the value of the '<em><b>Ceb</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ceb</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ceb</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEM2AnnexSubclause_Ceb()
   * @model containment="true"
   * @generated
   */
  EList<ComponentErrorBehavior> getCeb();

  /**
   * Returns the value of the '<em><b>Compeb</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Compeb</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Compeb</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEM2AnnexSubclause_Compeb()
   * @model containment="true"
   * @generated
   */
  EList<CompositeErrorBehavior> getCompeb();

} // EM2AnnexSubclause
