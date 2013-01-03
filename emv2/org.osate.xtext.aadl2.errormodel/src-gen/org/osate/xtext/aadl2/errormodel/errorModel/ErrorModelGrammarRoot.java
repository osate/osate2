/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Grammar Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelGrammarRoot#getEml <em>Eml</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelGrammarRoot#getEmsc <em>Emsc</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelGrammarRoot()
 * @model
 * @generated
 */
public interface ErrorModelGrammarRoot extends EObject
{
  /**
	 * Returns the value of the '<em><b>Eml</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Eml</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Eml</em>' containment reference.
	 * @see #setEml(ErrorModelLibrary)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelGrammarRoot_Eml()
	 * @model containment="true"
	 * @generated
	 */
  ErrorModelLibrary getEml();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelGrammarRoot#getEml <em>Eml</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eml</em>' containment reference.
	 * @see #getEml()
	 * @generated
	 */
  void setEml(ErrorModelLibrary value);

  /**
	 * Returns the value of the '<em><b>Emsc</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Emsc</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Emsc</em>' containment reference.
	 * @see #setEmsc(ErrorModelSubclause)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelGrammarRoot_Emsc()
	 * @model containment="true"
	 * @generated
	 */
  ErrorModelSubclause getEmsc();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelGrammarRoot#getEmsc <em>Emsc</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Emsc</em>' containment reference.
	 * @see #getEmsc()
	 * @generated
	 */
  void setEmsc(ErrorModelSubclause value);

} // ErrorModelGrammarRoot
