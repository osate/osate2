<<<<<<< HEAD
/**
 */
package org.osate.alisa.workbench.alisa.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.osate.alisa.workbench.alisa.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AlisaFactoryImpl extends EFactoryImpl implements AlisaFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AlisaFactory init()
  {
    try
    {
      AlisaFactory theAlisaFactory = (AlisaFactory)EPackage.Registry.INSTANCE.getEFactory(AlisaPackage.eNS_URI);
      if (theAlisaFactory != null)
      {
        return theAlisaFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new AlisaFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlisaFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case AlisaPackage.ALISA_WORK_AREA: return createAlisaWorkArea();
      case AlisaPackage.ASSURANCE_PLAN: return createAssurancePlan();
      case AlisaPackage.ASSURANCE_TASK: return createAssuranceTask();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlisaWorkArea createAlisaWorkArea()
  {
    AlisaWorkAreaImpl alisaWorkArea = new AlisaWorkAreaImpl();
    return alisaWorkArea;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssurancePlan createAssurancePlan()
  {
    AssurancePlanImpl assurancePlan = new AssurancePlanImpl();
    return assurancePlan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssuranceTask createAssuranceTask()
  {
    AssuranceTaskImpl assuranceTask = new AssuranceTaskImpl();
    return assuranceTask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlisaPackage getAlisaPackage()
  {
    return (AlisaPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static AlisaPackage getPackage()
  {
    return AlisaPackage.eINSTANCE;
  }

} //AlisaFactoryImpl
=======
/**
 */
package org.osate.alisa.workbench.alisa.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.osate.alisa.workbench.alisa.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AlisaFactoryImpl extends EFactoryImpl implements AlisaFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AlisaFactory init()
  {
    try
    {
      AlisaFactory theAlisaFactory = (AlisaFactory)EPackage.Registry.INSTANCE.getEFactory(AlisaPackage.eNS_URI);
      if (theAlisaFactory != null)
      {
        return theAlisaFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new AlisaFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlisaFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case AlisaPackage.ALISA_WORK_AREA: return createAlisaWorkArea();
      case AlisaPackage.ASSURANCE_PLAN: return createAssurancePlan();
      case AlisaPackage.ASSURANCE_TASK: return createAssuranceTask();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlisaWorkArea createAlisaWorkArea()
  {
    AlisaWorkAreaImpl alisaWorkArea = new AlisaWorkAreaImpl();
    return alisaWorkArea;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssurancePlan createAssurancePlan()
  {
    AssurancePlanImpl assurancePlan = new AssurancePlanImpl();
    return assurancePlan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssuranceTask createAssuranceTask()
  {
    AssuranceTaskImpl assuranceTask = new AssuranceTaskImpl();
    return assuranceTask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlisaPackage getAlisaPackage()
  {
    return (AlisaPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static AlisaPackage getPackage()
  {
    return AlisaPackage.eINSTANCE;
  }

} //AlisaFactoryImpl
>>>>>>> refs/remotes/origin/PeterWork
