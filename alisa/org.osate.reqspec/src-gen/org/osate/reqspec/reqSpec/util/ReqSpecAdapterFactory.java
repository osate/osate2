/**
 */
package org.osate.reqspec.reqSpec.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.osate.reqspec.reqSpec.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage
 * @generated
 */
public class ReqSpecAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ReqSpecPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqSpecAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = ReqSpecPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReqSpecSwitch<Adapter> modelSwitch =
    new ReqSpecSwitch<Adapter>()
    {
      @Override
      public Adapter caseReqSpec(ReqSpec object)
      {
        return createReqSpecAdapter();
      }
      @Override
      public Adapter caseReqSpecContainer(ReqSpecContainer object)
      {
        return createReqSpecContainerAdapter();
      }
      @Override
      public Adapter caseContractualElement(ContractualElement object)
      {
        return createContractualElementAdapter();
      }
      @Override
      public Adapter caseReqRoot(ReqRoot object)
      {
        return createReqRootAdapter();
      }
      @Override
      public Adapter caseStakeholderGoals(StakeholderGoals object)
      {
        return createStakeholderGoalsAdapter();
      }
      @Override
      public Adapter caseReqDocument(ReqDocument object)
      {
        return createReqDocumentAdapter();
      }
      @Override
      public Adapter caseDocumentSection(DocumentSection object)
      {
        return createDocumentSectionAdapter();
      }
      @Override
      public Adapter caseReqSpecs(ReqSpecs object)
      {
        return createReqSpecsAdapter();
      }
      @Override
      public Adapter caseReqSpecFolder(ReqSpecFolder object)
      {
        return createReqSpecFolderAdapter();
      }
      @Override
      public Adapter caseGoalFolder(GoalFolder object)
      {
        return createGoalFolderAdapter();
      }
      @Override
      public Adapter caseGoal(Goal object)
      {
        return createGoalAdapter();
      }
      @Override
      public Adapter caseRequirement(Requirement object)
      {
        return createRequirementAdapter();
      }
      @Override
      public Adapter caseReqPredicate(ReqPredicate object)
      {
        return createReqPredicateAdapter();
      }
      @Override
      public Adapter caseInformalPredicate(InformalPredicate object)
      {
        return createInformalPredicateAdapter();
      }
      @Override
      public Adapter caseXPredicate(XPredicate object)
      {
        return createXPredicateAdapter();
      }
      @Override
      public Adapter caseSPeARPredicate(SPeARPredicate object)
      {
        return createSPeARPredicateAdapter();
      }
      @Override
      public Adapter caseExternalDocument(ExternalDocument object)
      {
        return createExternalDocumentAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.osate.reqspec.reqSpec.ReqSpec <em>Req Spec</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.reqspec.reqSpec.ReqSpec
   * @generated
   */
  public Adapter createReqSpecAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.reqspec.reqSpec.ReqSpecContainer <em>Container</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.reqspec.reqSpec.ReqSpecContainer
   * @generated
   */
  public Adapter createReqSpecContainerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.reqspec.reqSpec.ContractualElement <em>Contractual Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.reqspec.reqSpec.ContractualElement
   * @generated
   */
  public Adapter createContractualElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.reqspec.reqSpec.ReqRoot <em>Req Root</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.reqspec.reqSpec.ReqRoot
   * @generated
   */
  public Adapter createReqRootAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.reqspec.reqSpec.StakeholderGoals <em>Stakeholder Goals</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.reqspec.reqSpec.StakeholderGoals
   * @generated
   */
  public Adapter createStakeholderGoalsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.reqspec.reqSpec.ReqDocument <em>Req Document</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.reqspec.reqSpec.ReqDocument
   * @generated
   */
  public Adapter createReqDocumentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.reqspec.reqSpec.DocumentSection <em>Document Section</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.reqspec.reqSpec.DocumentSection
   * @generated
   */
  public Adapter createDocumentSectionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.reqspec.reqSpec.ReqSpecs <em>Req Specs</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.reqspec.reqSpec.ReqSpecs
   * @generated
   */
  public Adapter createReqSpecsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.reqspec.reqSpec.ReqSpecFolder <em>Folder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.reqspec.reqSpec.ReqSpecFolder
   * @generated
   */
  public Adapter createReqSpecFolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.reqspec.reqSpec.GoalFolder <em>Goal Folder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.reqspec.reqSpec.GoalFolder
   * @generated
   */
  public Adapter createGoalFolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.reqspec.reqSpec.Goal <em>Goal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.reqspec.reqSpec.Goal
   * @generated
   */
  public Adapter createGoalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.reqspec.reqSpec.Requirement <em>Requirement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.reqspec.reqSpec.Requirement
   * @generated
   */
  public Adapter createRequirementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.reqspec.reqSpec.ReqPredicate <em>Req Predicate</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.reqspec.reqSpec.ReqPredicate
   * @generated
   */
  public Adapter createReqPredicateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.reqspec.reqSpec.InformalPredicate <em>Informal Predicate</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.reqspec.reqSpec.InformalPredicate
   * @generated
   */
  public Adapter createInformalPredicateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.reqspec.reqSpec.XPredicate <em>XPredicate</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.reqspec.reqSpec.XPredicate
   * @generated
   */
  public Adapter createXPredicateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.reqspec.reqSpec.SPeARPredicate <em>SPe AR Predicate</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.reqspec.reqSpec.SPeARPredicate
   * @generated
   */
  public Adapter createSPeARPredicateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.reqspec.reqSpec.ExternalDocument <em>External Document</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.reqspec.reqSpec.ExternalDocument
   * @generated
   */
  public Adapter createExternalDocumentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //ReqSpecAdapterFactory
