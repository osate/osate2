/**
 */
package com.rockwellcollins.atc.resolute.resolute.util;

import com.rockwellcollins.atc.resolute.resolute.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage
 * @generated
 */
public class ResoluteAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ResolutePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResoluteAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = ResolutePackage.eINSTANCE;
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
  protected ResoluteSwitch<Adapter> modelSwitch =
    new ResoluteSwitch<Adapter>()
    {
      @Override
      public Adapter caseResoluteLibrary(ResoluteLibrary object)
      {
        return createResoluteLibraryAdapter();
      }
      @Override
      public Adapter caseDefinition(Definition object)
      {
        return createDefinitionAdapter();
      }
      @Override
      public Adapter caseType(Type object)
      {
        return createTypeAdapter();
      }
      @Override
      public Adapter caseBaseType(BaseType object)
      {
        return createBaseTypeAdapter();
      }
      @Override
      public Adapter caseArg(Arg object)
      {
        return createArgAdapter();
      }
      @Override
      public Adapter caseConstantDefinition(ConstantDefinition object)
      {
        return createConstantDefinitionAdapter();
      }
      @Override
      public Adapter caseFunctionDefinition(FunctionDefinition object)
      {
        return createFunctionDefinitionAdapter();
      }
      @Override
      public Adapter caseDefinitionBody(DefinitionBody object)
      {
        return createDefinitionBodyAdapter();
      }
      @Override
      public Adapter caseClaimText(ClaimText object)
      {
        return createClaimTextAdapter();
      }
      @Override
      public Adapter caseClaimTextVar(ClaimTextVar object)
      {
        return createClaimTextVarAdapter();
      }
      @Override
      public Adapter caseExpr(Expr object)
      {
        return createExprAdapter();
      }
      @Override
      public Adapter caseLetBinding(LetBinding object)
      {
        return createLetBindingAdapter();
      }
      @Override
      public Adapter caseResoluteSubclause(ResoluteSubclause object)
      {
        return createResoluteSubclauseAdapter();
      }
      @Override
      public Adapter caseNestedDotID(NestedDotID object)
      {
        return createNestedDotIDAdapter();
      }
      @Override
      public Adapter caseProveStatement(ProveStatement object)
      {
        return createProveStatementAdapter();
      }
      @Override
      public Adapter caseListType(ListType object)
      {
        return createListTypeAdapter();
      }
      @Override
      public Adapter caseSetType(SetType object)
      {
        return createSetTypeAdapter();
      }
      @Override
      public Adapter caseQuantArg(QuantArg object)
      {
        return createQuantArgAdapter();
      }
      @Override
      public Adapter caseFunctionBody(FunctionBody object)
      {
        return createFunctionBodyAdapter();
      }
      @Override
      public Adapter caseClaimBody(ClaimBody object)
      {
        return createClaimBodyAdapter();
      }
      @Override
      public Adapter caseClaimString(ClaimString object)
      {
        return createClaimStringAdapter();
      }
      @Override
      public Adapter caseClaimArg(ClaimArg object)
      {
        return createClaimArgAdapter();
      }
      @Override
      public Adapter caseBinaryExpr(BinaryExpr object)
      {
        return createBinaryExprAdapter();
      }
      @Override
      public Adapter caseInstanceOfExpr(InstanceOfExpr object)
      {
        return createInstanceOfExprAdapter();
      }
      @Override
      public Adapter caseUnaryExpr(UnaryExpr object)
      {
        return createUnaryExprAdapter();
      }
      @Override
      public Adapter caseCastExpr(CastExpr object)
      {
        return createCastExprAdapter();
      }
      @Override
      public Adapter caseIdExpr(IdExpr object)
      {
        return createIdExprAdapter();
      }
      @Override
      public Adapter caseThisExpr(ThisExpr object)
      {
        return createThisExprAdapter();
      }
      @Override
      public Adapter caseFailExpr(FailExpr object)
      {
        return createFailExprAdapter();
      }
      @Override
      public Adapter caseIntExpr(IntExpr object)
      {
        return createIntExprAdapter();
      }
      @Override
      public Adapter caseRealExpr(RealExpr object)
      {
        return createRealExprAdapter();
      }
      @Override
      public Adapter caseBoolExpr(BoolExpr object)
      {
        return createBoolExprAdapter();
      }
      @Override
      public Adapter caseStringExpr(StringExpr object)
      {
        return createStringExprAdapter();
      }
      @Override
      public Adapter caseIfThenElseExpr(IfThenElseExpr object)
      {
        return createIfThenElseExprAdapter();
      }
      @Override
      public Adapter caseQuantifiedExpr(QuantifiedExpr object)
      {
        return createQuantifiedExprAdapter();
      }
      @Override
      public Adapter caseBuiltInFnCallExpr(BuiltInFnCallExpr object)
      {
        return createBuiltInFnCallExprAdapter();
      }
      @Override
      public Adapter caseFnCallExpr(FnCallExpr object)
      {
        return createFnCallExprAdapter();
      }
      @Override
      public Adapter caseListFilterMapExpr(ListFilterMapExpr object)
      {
        return createListFilterMapExprAdapter();
      }
      @Override
      public Adapter caseListExpr(ListExpr object)
      {
        return createListExprAdapter();
      }
      @Override
      public Adapter caseSetFilterMapExpr(SetFilterMapExpr object)
      {
        return createSetFilterMapExprAdapter();
      }
      @Override
      public Adapter caseSetExpr(SetExpr object)
      {
        return createSetExprAdapter();
      }
      @Override
      public Adapter caseLetExpr(LetExpr object)
      {
        return createLetExprAdapter();
      }
      @Override
      public Adapter caseElement(Element object)
      {
        return createElementAdapter();
      }
      @Override
      public Adapter caseNamedElement(NamedElement object)
      {
        return createNamedElementAdapter();
      }
      @Override
      public Adapter caseAnnexLibrary(AnnexLibrary object)
      {
        return createAnnexLibraryAdapter();
      }
      @Override
      public Adapter caseNamespace(Namespace object)
      {
        return createNamespaceAdapter();
      }
      @Override
      public Adapter caseModalElement(ModalElement object)
      {
        return createModalElementAdapter();
      }
      @Override
      public Adapter caseAnnexSubclause(AnnexSubclause object)
      {
        return createAnnexSubclauseAdapter();
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
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.ResoluteLibrary <em>Library</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.ResoluteLibrary
   * @generated
   */
  public Adapter createResoluteLibraryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.Definition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.Definition
   * @generated
   */
  public Adapter createDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.Type
   * @generated
   */
  public Adapter createTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.BaseType <em>Base Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.BaseType
   * @generated
   */
  public Adapter createBaseTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.Arg <em>Arg</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.Arg
   * @generated
   */
  public Adapter createArgAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.ConstantDefinition <em>Constant Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.ConstantDefinition
   * @generated
   */
  public Adapter createConstantDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.FunctionDefinition <em>Function Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.FunctionDefinition
   * @generated
   */
  public Adapter createFunctionDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.DefinitionBody <em>Definition Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.DefinitionBody
   * @generated
   */
  public Adapter createDefinitionBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.ClaimText <em>Claim Text</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.ClaimText
   * @generated
   */
  public Adapter createClaimTextAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.ClaimTextVar <em>Claim Text Var</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.ClaimTextVar
   * @generated
   */
  public Adapter createClaimTextVarAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.Expr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.Expr
   * @generated
   */
  public Adapter createExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.LetBinding <em>Let Binding</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.LetBinding
   * @generated
   */
  public Adapter createLetBindingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.ResoluteSubclause <em>Subclause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.ResoluteSubclause
   * @generated
   */
  public Adapter createResoluteSubclauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.NestedDotID <em>Nested Dot ID</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.NestedDotID
   * @generated
   */
  public Adapter createNestedDotIDAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.ProveStatement <em>Prove Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.ProveStatement
   * @generated
   */
  public Adapter createProveStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.ListType <em>List Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.ListType
   * @generated
   */
  public Adapter createListTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.SetType <em>Set Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.SetType
   * @generated
   */
  public Adapter createSetTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.QuantArg <em>Quant Arg</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.QuantArg
   * @generated
   */
  public Adapter createQuantArgAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.FunctionBody <em>Function Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.FunctionBody
   * @generated
   */
  public Adapter createFunctionBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.ClaimBody <em>Claim Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.ClaimBody
   * @generated
   */
  public Adapter createClaimBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.ClaimString <em>Claim String</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.ClaimString
   * @generated
   */
  public Adapter createClaimStringAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.ClaimArg <em>Claim Arg</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.ClaimArg
   * @generated
   */
  public Adapter createClaimArgAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.BinaryExpr <em>Binary Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.BinaryExpr
   * @generated
   */
  public Adapter createBinaryExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.InstanceOfExpr <em>Instance Of Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.InstanceOfExpr
   * @generated
   */
  public Adapter createInstanceOfExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.UnaryExpr <em>Unary Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.UnaryExpr
   * @generated
   */
  public Adapter createUnaryExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.CastExpr <em>Cast Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.CastExpr
   * @generated
   */
  public Adapter createCastExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.IdExpr <em>Id Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.IdExpr
   * @generated
   */
  public Adapter createIdExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.ThisExpr <em>This Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.ThisExpr
   * @generated
   */
  public Adapter createThisExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.FailExpr <em>Fail Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.FailExpr
   * @generated
   */
  public Adapter createFailExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.IntExpr <em>Int Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.IntExpr
   * @generated
   */
  public Adapter createIntExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.RealExpr <em>Real Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.RealExpr
   * @generated
   */
  public Adapter createRealExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.BoolExpr <em>Bool Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.BoolExpr
   * @generated
   */
  public Adapter createBoolExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.StringExpr <em>String Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.StringExpr
   * @generated
   */
  public Adapter createStringExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr <em>If Then Else Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr
   * @generated
   */
  public Adapter createIfThenElseExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.QuantifiedExpr <em>Quantified Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.QuantifiedExpr
   * @generated
   */
  public Adapter createQuantifiedExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.BuiltInFnCallExpr <em>Built In Fn Call Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.BuiltInFnCallExpr
   * @generated
   */
  public Adapter createBuiltInFnCallExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.FnCallExpr <em>Fn Call Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.FnCallExpr
   * @generated
   */
  public Adapter createFnCallExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.ListFilterMapExpr <em>List Filter Map Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.ListFilterMapExpr
   * @generated
   */
  public Adapter createListFilterMapExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.ListExpr <em>List Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.ListExpr
   * @generated
   */
  public Adapter createListExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.SetFilterMapExpr <em>Set Filter Map Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.SetFilterMapExpr
   * @generated
   */
  public Adapter createSetFilterMapExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.SetExpr <em>Set Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.SetExpr
   * @generated
   */
  public Adapter createSetExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.resolute.resolute.LetExpr <em>Let Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.resolute.resolute.LetExpr
   * @generated
   */
  public Adapter createLetExprAdapter()
  {
    return null;
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
    return null;
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
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.AnnexLibrary <em>Annex Library</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.AnnexLibrary
   * @generated
   */
  public Adapter createAnnexLibraryAdapter()
  {
    return null;
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
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.ModalElement <em>Modal Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.ModalElement
   * @generated
   */
  public Adapter createModalElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.AnnexSubclause <em>Annex Subclause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.AnnexSubclause
   * @generated
   */
  public Adapter createAnnexSubclauseAdapter()
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

} //ResoluteAdapterFactory
