/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel;
import fr.tpt.aadl.annex.behavior.aadlba.SubprogramParameterList;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subprogram Parameter List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramParameterListImpl#getParameterList <em>Parameter List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubprogramParameterListImpl extends ElementImpl implements SubprogramParameterList
{
   /**
	 * The cached value of the '{@link #getParameterList() <em>Parameter List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getParameterList()
	 * @generated
	 * @ordered
	 */
   protected EList<ParameterLabel> parameterList;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected SubprogramParameterListImpl()
   {
		super();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   protected EClass eStaticClass()
   {
		return AadlBaPackage.Literals.SUBPROGRAM_PARAMETER_LIST;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EList<ParameterLabel> getParameterList()
   {
		if (parameterList == null) {
			parameterList = new EObjectContainmentEList.Unsettable<ParameterLabel>(ParameterLabel.class, this, AadlBaPackage.SUBPROGRAM_PARAMETER_LIST__PARAMETER_LIST);
		}
		return parameterList;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void unsetParameterList()
   {
		if (parameterList != null) ((InternalEList.Unsettable<?>)parameterList).unset();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSetParameterList()
   {
		return parameterList != null && ((InternalEList.Unsettable<?>)parameterList).isSet();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
   {
		switch (featureID) {
			case AadlBaPackage.SUBPROGRAM_PARAMETER_LIST__PARAMETER_LIST:
				return ((InternalEList<?>)getParameterList()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public Object eGet(int featureID, boolean resolve, boolean coreType)
   {
		switch (featureID) {
			case AadlBaPackage.SUBPROGRAM_PARAMETER_LIST__PARAMETER_LIST:
				return getParameterList();
		}
		return super.eGet(featureID, resolve, coreType);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @SuppressWarnings("unchecked")
   @Override
   public void eSet(int featureID, Object newValue)
   {
		switch (featureID) {
			case AadlBaPackage.SUBPROGRAM_PARAMETER_LIST__PARAMETER_LIST:
				getParameterList().clear();
				getParameterList().addAll((Collection<? extends ParameterLabel>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public void eUnset(int featureID)
   {
		switch (featureID) {
			case AadlBaPackage.SUBPROGRAM_PARAMETER_LIST__PARAMETER_LIST:
				unsetParameterList();
				return;
		}
		super.eUnset(featureID);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public boolean eIsSet(int featureID)
   {
		switch (featureID) {
			case AadlBaPackage.SUBPROGRAM_PARAMETER_LIST__PARAMETER_LIST:
				return isSetParameterList();
		}
		return super.eIsSet(featureID);
	}

} //SubprogramParameterListImpl
