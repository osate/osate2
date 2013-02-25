/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.declarative.util ;

import fr.tpt.aadl.annex.behavior.aadlba.ActualPortHolder ;
import fr.tpt.aadl.annex.behavior.aadlba.BasicAction ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorNamedElement ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition ;
import fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction ;
import fr.tpt.aadl.annex.behavior.aadlba.CompletionRelativeTimeout ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchRelativeTimeout ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerCondition ;
import fr.tpt.aadl.annex.behavior.aadlba.ElementHolder ;
import fr.tpt.aadl.annex.behavior.aadlba.ElementValues ;
import fr.tpt.aadl.annex.behavior.aadlba.GroupableElement ;
import fr.tpt.aadl.annex.behavior.aadlba.IndexableElement ;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValue ;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant ;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable ;
import fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel ;
import fr.tpt.aadl.annex.behavior.aadlba.PortHolder ;
import fr.tpt.aadl.annex.behavior.aadlba.Target ;
import fr.tpt.aadl.annex.behavior.aadlba.Value ;
import fr.tpt.aadl.annex.behavior.aadlba.ValueConstant ;
import fr.tpt.aadl.annex.behavior.aadlba.ValueVariable ;

import fr.tpt.aadl.annex.behavior.declarative.* ;

import org.eclipse.emf.common.notify.Adapter ;
import org.eclipse.emf.common.notify.Notifier ;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl ;

import org.eclipse.emf.ecore.EObject ;

import org.osate.aadl2.ArrayDimension ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ComponentClassifier ;
import org.osate.aadl2.Data ;
import org.osate.aadl2.DataClassifier ;
import org.osate.aadl2.DataSubcomponentType ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.FeatureClassifier ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.Namespace ;
import org.osate.aadl2.SubcomponentType ;
import org.osate.aadl2.Type ;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage
 * @generated
 */
public class DeclarativeAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static DeclarativePackage modelPackage ;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeclarativeAdapterFactory()
  {
    if(modelPackage == null)
    {
      modelPackage = DeclarativePackage.eINSTANCE ;
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
    if(object == modelPackage)
    {
      return true ;
    }
    if(object instanceof EObject)
    {
      return ((EObject) object).eClass().getEPackage() == modelPackage ;
    }
    return false ;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DeclarativeSwitch<Adapter> modelSwitch =
        new DeclarativeSwitch<Adapter>()
        {
          @Override
          public Adapter caseArrayableIdentifier(ArrayableIdentifier object)
          {
            return createArrayableIdentifierAdapter() ;
          }

          @Override
          public Adapter caseCommAction(CommAction object)
          {
            return createCommActionAdapter() ;
          }

          @Override
          public Adapter caseDeclarativeArrayDimension(DeclarativeArrayDimension object)
          {
            return createDeclarativeArrayDimensionAdapter() ;
          }

          @Override
          public Adapter caseDeclarativeBehaviorElement(DeclarativeBehaviorElement object)
          {
            return createDeclarativeBehaviorElementAdapter() ;
          }

          @Override
          public Adapter caseDeclarativeBehaviorTransition(DeclarativeBehaviorTransition object)
          {
            return createDeclarativeBehaviorTransitionAdapter() ;
          }

          @Override
          public Adapter caseDeclarativeTime(DeclarativeTime object)
          {
            return createDeclarativeTimeAdapter() ;
          }

          @Override
          public Adapter caseEnumeration(Enumeration object)
          {
            return createEnumerationAdapter() ;
          }

          @Override
          public Adapter caseIdentifier(Identifier object)
          {
            return createIdentifierAdapter() ;
          }

          @Override
          public Adapter caseNamedValue(NamedValue object)
          {
            return createNamedValueAdapter() ;
          }

          @Override
          public Adapter caseQualifiedNamedElement(QualifiedNamedElement object)
          {
            return createQualifiedNamedElementAdapter() ;
          }

          @Override
          public Adapter caseReference(Reference object)
          {
            return createReferenceAdapter() ;
          }

          @Override
          public Adapter caseElement(Element object)
          {
            return createElementAdapter() ;
          }

          @Override
          public Adapter caseNamedElement(NamedElement object)
          {
            return createNamedElementAdapter() ;
          }

          @Override
          public Adapter caseBehaviorElement(BehaviorElement object)
          {
            return createBehaviorElementAdapter() ;
          }

          @Override
          public Adapter caseBehaviorNamedElement(BehaviorNamedElement object)
          {
            return createBehaviorNamedElementAdapter() ;
          }

          @Override
          public Adapter caseBehaviorState(BehaviorState object)
          {
            return createBehaviorStateAdapter() ;
          }

          @Override
          public Adapter caseBehaviorActions(BehaviorActions object)
          {
            return createBehaviorActionsAdapter() ;
          }

          @Override
          public Adapter caseBehaviorAction(BehaviorAction object)
          {
            return createBehaviorActionAdapter() ;
          }

          @Override
          public Adapter caseBasicAction(BasicAction object)
          {
            return createBasicActionAdapter() ;
          }

          @Override
          public Adapter caseCommunicationAction(CommunicationAction object)
          {
            return createCommunicationActionAdapter() ;
          }

          @Override
          public Adapter caseArrayDimension(ArrayDimension object)
          {
            return createArrayDimensionAdapter() ;
          }

          @Override
          public Adapter caseBehaviorTransition(BehaviorTransition object)
          {
            return createBehaviorTransitionAdapter() ;
          }

          @Override
          public Adapter caseBehaviorTime(BehaviorTime object)
          {
            return createBehaviorTimeAdapter() ;
          }

          @Override
          public Adapter caseDispatchTriggerCondition(DispatchTriggerCondition object)
          {
            return createDispatchTriggerConditionAdapter() ;
          }

          @Override
          public Adapter caseDispatchRelativeTimeout(DispatchRelativeTimeout object)
          {
            return createDispatchRelativeTimeoutAdapter() ;
          }

          @Override
          public Adapter caseCompletionRelativeTimeout(CompletionRelativeTimeout object)
          {
            return createCompletionRelativeTimeoutAdapter() ;
          }

          @Override
          public Adapter caseNamespace(Namespace object)
          {
            return createNamespaceAdapter() ;
          }

          @Override
          public Adapter caseType(Type object)
          {
            return createTypeAdapter() ;
          }

          @Override
          public Adapter caseClassifier(Classifier object)
          {
            return createClassifierAdapter() ;
          }

          @Override
          public Adapter caseSubcomponentType(SubcomponentType object)
          {
            return createSubcomponentTypeAdapter() ;
          }

          @Override
          public Adapter caseFeatureClassifier(FeatureClassifier object)
          {
            return createFeatureClassifierAdapter() ;
          }

          @Override
          public Adapter caseComponentClassifier(ComponentClassifier object)
          {
            return createComponentClassifierAdapter() ;
          }

          @Override
          public Adapter caseData(Data object)
          {
            return createDataAdapter() ;
          }

          @Override
          public Adapter caseDataSubcomponentType(DataSubcomponentType object)
          {
            return createDataSubcomponentTypeAdapter() ;
          }

          @Override
          public Adapter caseDataClassifier(DataClassifier object)
          {
            return createDataClassifierAdapter() ;
          }

          @Override
          public Adapter caseValue(Value object)
          {
            return createValueAdapter() ;
          }

          @Override
          public Adapter caseValueConstant(ValueConstant object)
          {
            return createValueConstantAdapter() ;
          }

          @Override
          public Adapter caseIntegerValue(IntegerValue object)
          {
            return createIntegerValueAdapter() ;
          }

          @Override
          public Adapter caseIntegerValueConstant(IntegerValueConstant object)
          {
            return createIntegerValueConstantAdapter() ;
          }

          @Override
          public Adapter caseValueVariable(ValueVariable object)
          {
            return createValueVariableAdapter() ;
          }

          @Override
          public Adapter caseIntegerValueVariable(IntegerValueVariable object)
          {
            return createIntegerValueVariableAdapter() ;
          }

          @Override
          public Adapter caseIndexableElement(IndexableElement object)
          {
            return createIndexableElementAdapter() ;
          }

          @Override
          public Adapter caseElementHolder(ElementHolder object)
          {
            return createElementHolderAdapter() ;
          }

          @Override
          public Adapter caseGroupableElement(GroupableElement object)
          {
            return createGroupableElementAdapter() ;
          }

          @Override
          public Adapter casePortHolder(PortHolder object)
          {
            return createPortHolderAdapter() ;
          }

          @Override
          public Adapter caseActualPortHolder(ActualPortHolder object)
          {
            return createActualPortHolderAdapter() ;
          }

          @Override
          public Adapter caseElementValues(ElementValues object)
          {
            return createElementValuesAdapter() ;
          }

          @Override
          public Adapter caseParameterLabel(ParameterLabel object)
          {
            return createParameterLabelAdapter() ;
          }

          @Override
          public Adapter caseTarget(Target object)
          {
            return createTargetAdapter() ;
          }

          @Override
          public Adapter caseDispatchTrigger(DispatchTrigger object)
          {
            return createDispatchTriggerAdapter() ;
          }

          @Override
          public Adapter defaultCase(EObject object)
          {
            return createEObjectAdapter() ;
          }
        } ;

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
    return modelSwitch.doSwitch((EObject) target) ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.declarative.ArrayableIdentifier <em>Arrayable Identifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.declarative.ArrayableIdentifier
   * @generated
   */
  public Adapter createArrayableIdentifierAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.declarative.CommAction <em>Comm Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.declarative.CommAction
   * @generated
   */
  public Adapter createCommActionAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.declarative.DeclarativeArrayDimension <em>Array Dimension</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativeArrayDimension
   * @generated
   */
  public Adapter createDeclarativeArrayDimensionAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.declarative.DeclarativeBehaviorElement <em>Behavior Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativeBehaviorElement
   * @generated
   */
  public Adapter createDeclarativeBehaviorElementAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.declarative.DeclarativeBehaviorTransition <em>Behavior Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativeBehaviorTransition
   * @generated
   */
  public Adapter createDeclarativeBehaviorTransitionAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.declarative.DeclarativeTime <em>Time</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativeTime
   * @generated
   */
  public Adapter createDeclarativeTimeAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.declarative.Enumeration <em>Enumeration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.declarative.Enumeration
   * @generated
   */
  public Adapter createEnumerationAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.declarative.Identifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.declarative.Identifier
   * @generated
   */
  public Adapter createIdentifierAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.declarative.NamedValue <em>Named Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.declarative.NamedValue
   * @generated
   */
  public Adapter createNamedValueAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.declarative.QualifiedNamedElement <em>Qualified Named Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.declarative.QualifiedNamedElement
   * @generated
   */
  public Adapter createQualifiedNamedElementAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.declarative.Reference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.declarative.Reference
   * @generated
   */
  public Adapter createReferenceAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.Element
   * @generated
   */
  public Adapter createElementAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.NamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.NamedElement
   * @generated
   */
  public Adapter createNamedElementAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement <em>Behavior Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement
   * @generated
   */
  public Adapter createBehaviorElementAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorNamedElement <em>Behavior Named Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorNamedElement
   * @generated
   */
  public Adapter createBehaviorNamedElementAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState <em>Behavior State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorState
   * @generated
   */
  public Adapter createBehaviorStateAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions <em>Behavior Actions</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions
   * @generated
   */
  public Adapter createBehaviorActionsAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction <em>Behavior Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction
   * @generated
   */
  public Adapter createBehaviorActionAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BasicAction <em>Basic Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BasicAction
   * @generated
   */
  public Adapter createBasicActionAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction <em>Communication Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction
   * @generated
   */
  public Adapter createCommunicationActionAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.ArrayDimension <em>Array Dimension</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.ArrayDimension
   * @generated
   */
  public Adapter createArrayDimensionAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition <em>Behavior Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition
   * @generated
   */
  public Adapter createBehaviorTransitionAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime <em>Behavior Time</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime
   * @generated
   */
  public Adapter createBehaviorTimeAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerCondition <em>Dispatch Trigger Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerCondition
   * @generated
   */
  public Adapter createDispatchTriggerConditionAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchRelativeTimeout <em>Dispatch Relative Timeout</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchRelativeTimeout
   * @generated
   */
  public Adapter createDispatchRelativeTimeoutAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.CompletionRelativeTimeout <em>Completion Relative Timeout</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.CompletionRelativeTimeout
   * @generated
   */
  public Adapter createCompletionRelativeTimeoutAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.Namespace <em>Namespace</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.Namespace
   * @generated
   */
  public Adapter createNamespaceAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.Type
   * @generated
   */
  public Adapter createTypeAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.Classifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.Classifier
   * @generated
   */
  public Adapter createClassifierAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.SubcomponentType <em>Subcomponent Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.SubcomponentType
   * @generated
   */
  public Adapter createSubcomponentTypeAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.FeatureClassifier <em>Feature Classifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.FeatureClassifier
   * @generated
   */
  public Adapter createFeatureClassifierAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.ComponentClassifier <em>Component Classifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.ComponentClassifier
   * @generated
   */
  public Adapter createComponentClassifierAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.Data <em>Data</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.Data
   * @generated
   */
  public Adapter createDataAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.DataSubcomponentType <em>Data Subcomponent Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.DataSubcomponentType
   * @generated
   */
  public Adapter createDataSubcomponentTypeAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.DataClassifier <em>Data Classifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.DataClassifier
   * @generated
   */
  public Adapter createDataClassifierAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.Value
   * @generated
   */
  public Adapter createValueAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueConstant <em>Value Constant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ValueConstant
   * @generated
   */
  public Adapter createValueConstantAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValue <em>Integer Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValue
   * @generated
   */
  public Adapter createIntegerValueAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant <em>Integer Value Constant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant
   * @generated
   */
  public Adapter createIntegerValueConstantAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable <em>Value Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ValueVariable
   * @generated
   */
  public Adapter createValueVariableAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable <em>Integer Value Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable
   * @generated
   */
  public Adapter createIntegerValueVariableAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.IndexableElement <em>Indexable Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.IndexableElement
   * @generated
   */
  public Adapter createIndexableElementAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.ElementHolder <em>Element Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ElementHolder
   * @generated
   */
  public Adapter createElementHolderAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.GroupableElement <em>Groupable Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.GroupableElement
   * @generated
   */
  public Adapter createGroupableElementAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.PortHolder <em>Port Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.PortHolder
   * @generated
   */
  public Adapter createPortHolderAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.ActualPortHolder <em>Actual Port Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ActualPortHolder
   * @generated
   */
  public Adapter createActualPortHolderAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.ElementValues <em>Element Values</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ElementValues
   * @generated
   */
  public Adapter createElementValuesAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel <em>Parameter Label</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel
   * @generated
   */
  public Adapter createParameterLabelAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Target <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.Target
   * @generated
   */
  public Adapter createTargetAdapter()
  {
    return null ;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger <em>Dispatch Trigger</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger
   * @generated
   */
  public Adapter createDispatchTriggerAdapter()
  {
    return null ;
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
    return null ;
  }

} //DeclarativeAdapterFactory
