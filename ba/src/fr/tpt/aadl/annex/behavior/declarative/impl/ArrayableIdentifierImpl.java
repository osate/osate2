/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.declarative.impl ;

import fr.tpt.aadl.annex.behavior.aadlba.IntegerValue ;

import fr.tpt.aadl.annex.behavior.declarative.ArrayableIdentifier ;
import fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage ;

import java.util.Collection ;

import org.eclipse.emf.common.notify.NotificationChain ;

import org.eclipse.emf.common.util.EList ;

import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.InternalEObject ;

import org.eclipse.emf.ecore.util.EObjectContainmentEList ;
import org.eclipse.emf.ecore.util.InternalEList ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Arrayable Identifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.impl.ArrayableIdentifierImpl#getArrayIndexes <em>Array Indexes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArrayableIdentifierImpl extends IdentifierImpl implements
                                                           ArrayableIdentifier
{
  /**
   * The cached value of the '{@link #getArrayIndexes() <em>Array Indexes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArrayIndexes()
   * @generated
   * @ordered
   */
  protected EList<IntegerValue> arrayIndexes ;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ArrayableIdentifierImpl()
  {
    super() ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return DeclarativePackage.Literals.ARRAYABLE_IDENTIFIER ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<IntegerValue> getArrayIndexes()
  {
    if(arrayIndexes == null)
    {
      arrayIndexes =
            new EObjectContainmentEList.Unsettable<IntegerValue>(
                  IntegerValue.class, this,
                  DeclarativePackage.ARRAYABLE_IDENTIFIER__ARRAY_INDEXES) ;
    }
    return arrayIndexes ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetArrayIndexes()
  {
    if(arrayIndexes != null)
      ((InternalEList.Unsettable<?>) arrayIndexes).unset() ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetArrayIndexes()
  {
    return arrayIndexes != null &&
          ((InternalEList.Unsettable<?>) arrayIndexes).isSet() ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd,
                                          int featureID,
                                          NotificationChain msgs)
  {
    switch ( featureID )
    {
      case DeclarativePackage.ARRAYABLE_IDENTIFIER__ARRAY_INDEXES :
        return ((InternalEList<?>) getArrayIndexes()).basicRemove(otherEnd,
                                                                  msgs) ;
    }
    return super.eInverseRemove(otherEnd, featureID, msgs) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID,
                     boolean resolve,
                     boolean coreType)
  {
    switch ( featureID )
    {
      case DeclarativePackage.ARRAYABLE_IDENTIFIER__ARRAY_INDEXES :
        return getArrayIndexes() ;
    }
    return super.eGet(featureID, resolve, coreType) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID,
                   Object newValue)
  {
    switch ( featureID )
    {
      case DeclarativePackage.ARRAYABLE_IDENTIFIER__ARRAY_INDEXES :
        getArrayIndexes().clear() ;
        getArrayIndexes().addAll((Collection<? extends IntegerValue>) newValue) ;
        return ;
    }
    super.eSet(featureID, newValue) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch ( featureID )
    {
      case DeclarativePackage.ARRAYABLE_IDENTIFIER__ARRAY_INDEXES :
        unsetArrayIndexes() ;
        return ;
    }
    super.eUnset(featureID) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch ( featureID )
    {
      case DeclarativePackage.ARRAYABLE_IDENTIFIER__ARRAY_INDEXES :
        return isSetArrayIndexes() ;
    }
    return super.eIsSet(featureID) ;
  }

} //ArrayableIdentifierImpl
