/**
 */
package org.osate.results.results;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Report Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.results.results.ResultReportEntry#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.results.results.ResultReportEntry#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.results.results.ResultReportEntry#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.results.results.ResultReportEntry#getDecription <em>Decription</em>}</li>
 *   <li>{@link org.osate.results.results.ResultReportEntry#getHeading <em>Heading</em>}</li>
 *   <li>{@link org.osate.results.results.ResultReportEntry#getResultData <em>Result Data</em>}</li>
 *   <li>{@link org.osate.results.results.ResultReportEntry#getIssue <em>Issue</em>}</li>
 *   <li>{@link org.osate.results.results.ResultReportEntry#getRow <em>Row</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.results.results.ResultsPackage#getResultReportEntry()
 * @model
 * @generated
 */
public interface ResultReportEntry extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.osate.results.results.ResultsPackage#getResultReportEntry_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.results.results.ResultReportEntry#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Title</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Title</em>' attribute.
   * @see #setTitle(String)
   * @see org.osate.results.results.ResultsPackage#getResultReportEntry_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.osate.results.results.ResultReportEntry#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(EObject)
   * @see org.osate.results.results.ResultsPackage#getResultReportEntry_Target()
   * @model
   * @generated
   */
  EObject getTarget();

  /**
   * Sets the value of the '{@link org.osate.results.results.ResultReportEntry#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(EObject value);

  /**
   * Returns the value of the '<em><b>Decription</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Decription</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decription</em>' attribute.
   * @see #setDecription(String)
   * @see org.osate.results.results.ResultsPackage#getResultReportEntry_Decription()
   * @model
   * @generated
   */
  String getDecription();

  /**
   * Sets the value of the '{@link org.osate.results.results.ResultReportEntry#getDecription <em>Decription</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Decription</em>' attribute.
   * @see #getDecription()
   * @generated
   */
  void setDecription(String value);

  /**
   * Returns the value of the '<em><b>Heading</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Heading</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Heading</em>' attribute.
   * @see #setHeading(String)
   * @see org.osate.results.results.ResultsPackage#getResultReportEntry_Heading()
   * @model
   * @generated
   */
  String getHeading();

  /**
   * Sets the value of the '{@link org.osate.results.results.ResultReportEntry#getHeading <em>Heading</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Heading</em>' attribute.
   * @see #getHeading()
   * @generated
   */
  void setHeading(String value);

  /**
   * Returns the value of the '<em><b>Result Data</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result Data</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Result Data</em>' containment reference.
   * @see #setResultData(ResultData)
   * @see org.osate.results.results.ResultsPackage#getResultReportEntry_ResultData()
   * @model containment="true"
   * @generated
   */
  ResultData getResultData();

  /**
   * Sets the value of the '{@link org.osate.results.results.ResultReportEntry#getResultData <em>Result Data</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result Data</em>' containment reference.
   * @see #getResultData()
   * @generated
   */
  void setResultData(ResultData value);

  /**
   * Returns the value of the '<em><b>Issue</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.results.results.ReportIssue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Issue</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Issue</em>' containment reference list.
   * @see org.osate.results.results.ResultsPackage#getResultReportEntry_Issue()
   * @model containment="true"
   * @generated
   */
  EList<ReportIssue> getIssue();

  /**
   * Returns the value of the '<em><b>Row</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.results.results.ResultContributor}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Row</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Row</em>' containment reference list.
   * @see org.osate.results.results.ResultsPackage#getResultReportEntry_Row()
   * @model containment="true"
   * @generated
   */
  EList<ResultContributor> getRow();

} // ResultReportEntry
