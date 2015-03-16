/**
 */
package org.osate.results.results;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Report</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.results.results.ResultReport#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.results.results.ResultReport#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.results.results.ResultReport#getRoot <em>Root</em>}</li>
 *   <li>{@link org.osate.results.results.ResultReport#getDecription <em>Decription</em>}</li>
 *   <li>{@link org.osate.results.results.ResultReport#getHeading <em>Heading</em>}</li>
 *   <li>{@link org.osate.results.results.ResultReport#getContent <em>Content</em>}</li>
 *   <li>{@link org.osate.results.results.ResultReport#getResultData <em>Result Data</em>}</li>
 *   <li>{@link org.osate.results.results.ResultReport#getIssue <em>Issue</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.results.results.ResultsPackage#getResultReport()
 * @model
 * @generated
 */
public interface ResultReport extends EObject
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
   * @see org.osate.results.results.ResultsPackage#getResultReport_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.results.results.ResultReport#getName <em>Name</em>}' attribute.
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
   * @see org.osate.results.results.ResultsPackage#getResultReport_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.osate.results.results.ResultReport#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

  /**
   * Returns the value of the '<em><b>Root</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Root</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Root</em>' reference.
   * @see #setRoot(EObject)
   * @see org.osate.results.results.ResultsPackage#getResultReport_Root()
   * @model
   * @generated
   */
  EObject getRoot();

  /**
   * Sets the value of the '{@link org.osate.results.results.ResultReport#getRoot <em>Root</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Root</em>' reference.
   * @see #getRoot()
   * @generated
   */
  void setRoot(EObject value);

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
   * @see org.osate.results.results.ResultsPackage#getResultReport_Decription()
   * @model
   * @generated
   */
  String getDecription();

  /**
   * Sets the value of the '{@link org.osate.results.results.ResultReport#getDecription <em>Decription</em>}' attribute.
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
   * @see org.osate.results.results.ResultsPackage#getResultReport_Heading()
   * @model
   * @generated
   */
  String getHeading();

  /**
   * Sets the value of the '{@link org.osate.results.results.ResultReport#getHeading <em>Heading</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Heading</em>' attribute.
   * @see #getHeading()
   * @generated
   */
  void setHeading(String value);

  /**
   * Returns the value of the '<em><b>Content</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.results.results.ResultReportEntry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Content</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content</em>' containment reference list.
   * @see org.osate.results.results.ResultsPackage#getResultReport_Content()
   * @model containment="true"
   * @generated
   */
  EList<ResultReportEntry> getContent();

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
   * @see org.osate.results.results.ResultsPackage#getResultReport_ResultData()
   * @model containment="true"
   * @generated
   */
  ResultData getResultData();

  /**
   * Sets the value of the '{@link org.osate.results.results.ResultReport#getResultData <em>Result Data</em>}' containment reference.
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
   * @see org.osate.results.results.ResultsPackage#getResultReport_Issue()
   * @model containment="true"
   * @generated
   */
  EList<ReportIssue> getIssue();

} // ResultReport
