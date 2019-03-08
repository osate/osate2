/**
 */
package com.rockwellcollins.atc.resolute.resolute.impl;

import com.rockwellcollins.atc.resolute.resolute.Arg;
import com.rockwellcollins.atc.resolute.resolute.BaseType;
import com.rockwellcollins.atc.resolute.resolute.BinaryExpr;
import com.rockwellcollins.atc.resolute.resolute.BoolExpr;
import com.rockwellcollins.atc.resolute.resolute.BuiltInFnCallExpr;
import com.rockwellcollins.atc.resolute.resolute.CastExpr;
import com.rockwellcollins.atc.resolute.resolute.ClaimArg;
import com.rockwellcollins.atc.resolute.resolute.ClaimBody;
import com.rockwellcollins.atc.resolute.resolute.ClaimString;
import com.rockwellcollins.atc.resolute.resolute.ClaimText;
import com.rockwellcollins.atc.resolute.resolute.ClaimTextVar;
import com.rockwellcollins.atc.resolute.resolute.ConstantDefinition;
import com.rockwellcollins.atc.resolute.resolute.Definition;
import com.rockwellcollins.atc.resolute.resolute.DefinitionBody;
import com.rockwellcollins.atc.resolute.resolute.Expr;
import com.rockwellcollins.atc.resolute.resolute.FailExpr;
import com.rockwellcollins.atc.resolute.resolute.FnCallExpr;
import com.rockwellcollins.atc.resolute.resolute.FunctionBody;
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition;
import com.rockwellcollins.atc.resolute.resolute.IdExpr;
import com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr;
import com.rockwellcollins.atc.resolute.resolute.InstanceOfExpr;
import com.rockwellcollins.atc.resolute.resolute.IntExpr;
import com.rockwellcollins.atc.resolute.resolute.LetBinding;
import com.rockwellcollins.atc.resolute.resolute.LetExpr;
import com.rockwellcollins.atc.resolute.resolute.ListExpr;
import com.rockwellcollins.atc.resolute.resolute.ListFilterMapExpr;
import com.rockwellcollins.atc.resolute.resolute.ListType;
import com.rockwellcollins.atc.resolute.resolute.NestedDotID;
import com.rockwellcollins.atc.resolute.resolute.ProveStatement;
import com.rockwellcollins.atc.resolute.resolute.QuantArg;
import com.rockwellcollins.atc.resolute.resolute.QuantifiedExpr;
import com.rockwellcollins.atc.resolute.resolute.RealExpr;
import com.rockwellcollins.atc.resolute.resolute.ResoluteFactory;
import com.rockwellcollins.atc.resolute.resolute.ResoluteLibrary;
import com.rockwellcollins.atc.resolute.resolute.ResolutePackage;
import com.rockwellcollins.atc.resolute.resolute.ResoluteSubclause;
import com.rockwellcollins.atc.resolute.resolute.SetExpr;
import com.rockwellcollins.atc.resolute.resolute.SetFilterMapExpr;
import com.rockwellcollins.atc.resolute.resolute.SetType;
import com.rockwellcollins.atc.resolute.resolute.StringExpr;
import com.rockwellcollins.atc.resolute.resolute.ThisExpr;
import com.rockwellcollins.atc.resolute.resolute.Type;
import com.rockwellcollins.atc.resolute.resolute.UnaryExpr;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.aadl2.Aadl2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResolutePackageImpl extends EPackageImpl implements ResolutePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass resoluteLibraryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass definitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass baseTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass argEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constantDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass definitionBodyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass claimTextEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass claimTextVarEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass letBindingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass resoluteSubclauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nestedDotIDEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass proveStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass listTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass setTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass quantArgEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionBodyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass claimBodyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass claimStringEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass claimArgEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass binaryExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass instanceOfExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unaryExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass castExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass idExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass thisExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass failExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass intExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass realExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass boolExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifThenElseExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass quantifiedExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass builtInFnCallExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fnCallExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass listFilterMapExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass listExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass setFilterMapExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass setExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass letExprEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ResolutePackageImpl()
  {
    super(eNS_URI, ResoluteFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link ResolutePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ResolutePackage init()
  {
    if (isInited) return (ResolutePackage)EPackage.Registry.INSTANCE.getEPackage(ResolutePackage.eNS_URI);

    // Obtain or create and register package
    ResolutePackageImpl theResolutePackage = (ResolutePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ResolutePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ResolutePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();
    Aadl2Package.eINSTANCE.eClass();

    // Create package meta-data objects
    theResolutePackage.createPackageContents();

    // Initialize created meta-data
    theResolutePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theResolutePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ResolutePackage.eNS_URI, theResolutePackage);
    return theResolutePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getResoluteLibrary()
  {
    return resoluteLibraryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResoluteLibrary_Definitions()
  {
    return (EReference)resoluteLibraryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDefinition()
  {
    return definitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getType()
  {
    return typeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBaseType()
  {
    return baseTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBaseType_ParamType()
  {
    return (EReference)baseTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBaseType_Type()
  {
    return (EAttribute)baseTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getArg()
  {
    return argEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArg_Type()
  {
    return (EReference)argEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstantDefinition()
  {
    return constantDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstantDefinition_Type()
  {
    return (EReference)constantDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstantDefinition_Expr()
  {
    return (EReference)constantDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunctionDefinition()
  {
    return functionDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionDefinition_Args()
  {
    return (EReference)functionDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionDefinition_Body()
  {
    return (EReference)functionDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDefinitionBody()
  {
    return definitionBodyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDefinitionBody_Expr()
  {
    return (EReference)definitionBodyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClaimText()
  {
    return claimTextEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClaimTextVar()
  {
    return claimTextVarEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpr()
  {
    return exprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLetBinding()
  {
    return letBindingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLetBinding_Type()
  {
    return (EReference)letBindingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLetBinding_Expr()
  {
    return (EReference)letBindingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getResoluteSubclause()
  {
    return resoluteSubclauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResoluteSubclause_Proves()
  {
    return (EReference)resoluteSubclauseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNestedDotID()
  {
    return nestedDotIDEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNestedDotID_Base()
  {
    return (EReference)nestedDotIDEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNestedDotID_Sub()
  {
    return (EReference)nestedDotIDEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProveStatement()
  {
    return proveStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProveStatement_Expr()
  {
    return (EReference)proveStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getListType()
  {
    return listTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getListType_Type()
  {
    return (EReference)listTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSetType()
  {
    return setTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSetType_Type()
  {
    return (EReference)setTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQuantArg()
  {
    return quantArgEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQuantArg_Expr()
  {
    return (EReference)quantArgEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunctionBody()
  {
    return functionBodyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionBody_Type()
  {
    return (EReference)functionBodyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClaimBody()
  {
    return claimBodyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClaimBody_Claim()
  {
    return (EReference)claimBodyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClaimString()
  {
    return claimStringEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClaimString_Str()
  {
    return (EAttribute)claimStringEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClaimArg()
  {
    return claimArgEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClaimArg_Arg()
  {
    return (EReference)claimArgEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClaimArg_Unit()
  {
    return (EReference)claimArgEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBinaryExpr()
  {
    return binaryExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinaryExpr_Left()
  {
    return (EReference)binaryExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBinaryExpr_Op()
  {
    return (EAttribute)binaryExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinaryExpr_Right()
  {
    return (EReference)binaryExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInstanceOfExpr()
  {
    return instanceOfExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInstanceOfExpr_Expr()
  {
    return (EReference)instanceOfExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInstanceOfExpr_Type()
  {
    return (EReference)instanceOfExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnaryExpr()
  {
    return unaryExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnaryExpr_Op()
  {
    return (EAttribute)unaryExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnaryExpr_Expr()
  {
    return (EReference)unaryExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCastExpr()
  {
    return castExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCastExpr_Type()
  {
    return (EReference)castExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCastExpr_Expr()
  {
    return (EReference)castExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIdExpr()
  {
    return idExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIdExpr_Id()
  {
    return (EReference)idExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getThisExpr()
  {
    return thisExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getThisExpr_Sub()
  {
    return (EReference)thisExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFailExpr()
  {
    return failExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFailExpr_Val()
  {
    return (EReference)failExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFailExpr_Failmsg()
  {
    return (EReference)failExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIntExpr()
  {
    return intExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIntExpr_Val()
  {
    return (EReference)intExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRealExpr()
  {
    return realExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRealExpr_Val()
  {
    return (EReference)realExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBoolExpr()
  {
    return boolExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBoolExpr_Val()
  {
    return (EReference)boolExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringExpr()
  {
    return stringExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStringExpr_Val()
  {
    return (EReference)stringExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfThenElseExpr()
  {
    return ifThenElseExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfThenElseExpr_Cond()
  {
    return (EReference)ifThenElseExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfThenElseExpr_Then()
  {
    return (EReference)ifThenElseExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfThenElseExpr_Else()
  {
    return (EReference)ifThenElseExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQuantifiedExpr()
  {
    return quantifiedExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getQuantifiedExpr_Quant()
  {
    return (EAttribute)quantifiedExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQuantifiedExpr_Args()
  {
    return (EReference)quantifiedExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQuantifiedExpr_Expr()
  {
    return (EReference)quantifiedExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBuiltInFnCallExpr()
  {
    return builtInFnCallExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBuiltInFnCallExpr_Fn()
  {
    return (EAttribute)builtInFnCallExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBuiltInFnCallExpr_Args()
  {
    return (EReference)builtInFnCallExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFnCallExpr()
  {
    return fnCallExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFnCallExpr_Fn()
  {
    return (EReference)fnCallExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFnCallExpr_Args()
  {
    return (EReference)fnCallExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getListFilterMapExpr()
  {
    return listFilterMapExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getListFilterMapExpr_Map()
  {
    return (EReference)listFilterMapExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getListFilterMapExpr_Args()
  {
    return (EReference)listFilterMapExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getListFilterMapExpr_Filter()
  {
    return (EReference)listFilterMapExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getListExpr()
  {
    return listExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getListExpr_Exprs()
  {
    return (EReference)listExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSetFilterMapExpr()
  {
    return setFilterMapExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSetFilterMapExpr_Map()
  {
    return (EReference)setFilterMapExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSetFilterMapExpr_Args()
  {
    return (EReference)setFilterMapExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSetFilterMapExpr_Filter()
  {
    return (EReference)setFilterMapExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSetExpr()
  {
    return setExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSetExpr_Exprs()
  {
    return (EReference)setExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLetExpr()
  {
    return letExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLetExpr_Binding()
  {
    return (EReference)letExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLetExpr_Expr()
  {
    return (EReference)letExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResoluteFactory getResoluteFactory()
  {
    return (ResoluteFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    resoluteLibraryEClass = createEClass(RESOLUTE_LIBRARY);
    createEReference(resoluteLibraryEClass, RESOLUTE_LIBRARY__DEFINITIONS);

    definitionEClass = createEClass(DEFINITION);

    typeEClass = createEClass(TYPE);

    baseTypeEClass = createEClass(BASE_TYPE);
    createEReference(baseTypeEClass, BASE_TYPE__PARAM_TYPE);
    createEAttribute(baseTypeEClass, BASE_TYPE__TYPE);

    argEClass = createEClass(ARG);
    createEReference(argEClass, ARG__TYPE);

    constantDefinitionEClass = createEClass(CONSTANT_DEFINITION);
    createEReference(constantDefinitionEClass, CONSTANT_DEFINITION__TYPE);
    createEReference(constantDefinitionEClass, CONSTANT_DEFINITION__EXPR);

    functionDefinitionEClass = createEClass(FUNCTION_DEFINITION);
    createEReference(functionDefinitionEClass, FUNCTION_DEFINITION__ARGS);
    createEReference(functionDefinitionEClass, FUNCTION_DEFINITION__BODY);

    definitionBodyEClass = createEClass(DEFINITION_BODY);
    createEReference(definitionBodyEClass, DEFINITION_BODY__EXPR);

    claimTextEClass = createEClass(CLAIM_TEXT);

    claimTextVarEClass = createEClass(CLAIM_TEXT_VAR);

    exprEClass = createEClass(EXPR);

    letBindingEClass = createEClass(LET_BINDING);
    createEReference(letBindingEClass, LET_BINDING__TYPE);
    createEReference(letBindingEClass, LET_BINDING__EXPR);

    resoluteSubclauseEClass = createEClass(RESOLUTE_SUBCLAUSE);
    createEReference(resoluteSubclauseEClass, RESOLUTE_SUBCLAUSE__PROVES);

    nestedDotIDEClass = createEClass(NESTED_DOT_ID);
    createEReference(nestedDotIDEClass, NESTED_DOT_ID__BASE);
    createEReference(nestedDotIDEClass, NESTED_DOT_ID__SUB);

    proveStatementEClass = createEClass(PROVE_STATEMENT);
    createEReference(proveStatementEClass, PROVE_STATEMENT__EXPR);

    listTypeEClass = createEClass(LIST_TYPE);
    createEReference(listTypeEClass, LIST_TYPE__TYPE);

    setTypeEClass = createEClass(SET_TYPE);
    createEReference(setTypeEClass, SET_TYPE__TYPE);

    quantArgEClass = createEClass(QUANT_ARG);
    createEReference(quantArgEClass, QUANT_ARG__EXPR);

    functionBodyEClass = createEClass(FUNCTION_BODY);
    createEReference(functionBodyEClass, FUNCTION_BODY__TYPE);

    claimBodyEClass = createEClass(CLAIM_BODY);
    createEReference(claimBodyEClass, CLAIM_BODY__CLAIM);

    claimStringEClass = createEClass(CLAIM_STRING);
    createEAttribute(claimStringEClass, CLAIM_STRING__STR);

    claimArgEClass = createEClass(CLAIM_ARG);
    createEReference(claimArgEClass, CLAIM_ARG__ARG);
    createEReference(claimArgEClass, CLAIM_ARG__UNIT);

    binaryExprEClass = createEClass(BINARY_EXPR);
    createEReference(binaryExprEClass, BINARY_EXPR__LEFT);
    createEAttribute(binaryExprEClass, BINARY_EXPR__OP);
    createEReference(binaryExprEClass, BINARY_EXPR__RIGHT);

    instanceOfExprEClass = createEClass(INSTANCE_OF_EXPR);
    createEReference(instanceOfExprEClass, INSTANCE_OF_EXPR__EXPR);
    createEReference(instanceOfExprEClass, INSTANCE_OF_EXPR__TYPE);

    unaryExprEClass = createEClass(UNARY_EXPR);
    createEAttribute(unaryExprEClass, UNARY_EXPR__OP);
    createEReference(unaryExprEClass, UNARY_EXPR__EXPR);

    castExprEClass = createEClass(CAST_EXPR);
    createEReference(castExprEClass, CAST_EXPR__TYPE);
    createEReference(castExprEClass, CAST_EXPR__EXPR);

    idExprEClass = createEClass(ID_EXPR);
    createEReference(idExprEClass, ID_EXPR__ID);

    thisExprEClass = createEClass(THIS_EXPR);
    createEReference(thisExprEClass, THIS_EXPR__SUB);

    failExprEClass = createEClass(FAIL_EXPR);
    createEReference(failExprEClass, FAIL_EXPR__VAL);
    createEReference(failExprEClass, FAIL_EXPR__FAILMSG);

    intExprEClass = createEClass(INT_EXPR);
    createEReference(intExprEClass, INT_EXPR__VAL);

    realExprEClass = createEClass(REAL_EXPR);
    createEReference(realExprEClass, REAL_EXPR__VAL);

    boolExprEClass = createEClass(BOOL_EXPR);
    createEReference(boolExprEClass, BOOL_EXPR__VAL);

    stringExprEClass = createEClass(STRING_EXPR);
    createEReference(stringExprEClass, STRING_EXPR__VAL);

    ifThenElseExprEClass = createEClass(IF_THEN_ELSE_EXPR);
    createEReference(ifThenElseExprEClass, IF_THEN_ELSE_EXPR__COND);
    createEReference(ifThenElseExprEClass, IF_THEN_ELSE_EXPR__THEN);
    createEReference(ifThenElseExprEClass, IF_THEN_ELSE_EXPR__ELSE);

    quantifiedExprEClass = createEClass(QUANTIFIED_EXPR);
    createEAttribute(quantifiedExprEClass, QUANTIFIED_EXPR__QUANT);
    createEReference(quantifiedExprEClass, QUANTIFIED_EXPR__ARGS);
    createEReference(quantifiedExprEClass, QUANTIFIED_EXPR__EXPR);

    builtInFnCallExprEClass = createEClass(BUILT_IN_FN_CALL_EXPR);
    createEAttribute(builtInFnCallExprEClass, BUILT_IN_FN_CALL_EXPR__FN);
    createEReference(builtInFnCallExprEClass, BUILT_IN_FN_CALL_EXPR__ARGS);

    fnCallExprEClass = createEClass(FN_CALL_EXPR);
    createEReference(fnCallExprEClass, FN_CALL_EXPR__FN);
    createEReference(fnCallExprEClass, FN_CALL_EXPR__ARGS);

    listFilterMapExprEClass = createEClass(LIST_FILTER_MAP_EXPR);
    createEReference(listFilterMapExprEClass, LIST_FILTER_MAP_EXPR__MAP);
    createEReference(listFilterMapExprEClass, LIST_FILTER_MAP_EXPR__ARGS);
    createEReference(listFilterMapExprEClass, LIST_FILTER_MAP_EXPR__FILTER);

    listExprEClass = createEClass(LIST_EXPR);
    createEReference(listExprEClass, LIST_EXPR__EXPRS);

    setFilterMapExprEClass = createEClass(SET_FILTER_MAP_EXPR);
    createEReference(setFilterMapExprEClass, SET_FILTER_MAP_EXPR__MAP);
    createEReference(setFilterMapExprEClass, SET_FILTER_MAP_EXPR__ARGS);
    createEReference(setFilterMapExprEClass, SET_FILTER_MAP_EXPR__FILTER);

    setExprEClass = createEClass(SET_EXPR);
    createEReference(setExprEClass, SET_EXPR__EXPRS);

    letExprEClass = createEClass(LET_EXPR);
    createEReference(letExprEClass, LET_EXPR__BINDING);
    createEReference(letExprEClass, LET_EXPR__EXPR);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    Aadl2Package theAadl2Package = (Aadl2Package)EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    resoluteLibraryEClass.getESuperTypes().add(theAadl2Package.getAnnexLibrary());
    definitionEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
    baseTypeEClass.getESuperTypes().add(this.getType());
    argEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
    argEClass.getESuperTypes().add(this.getClaimTextVar());
    constantDefinitionEClass.getESuperTypes().add(this.getDefinition());
    constantDefinitionEClass.getESuperTypes().add(this.getClaimTextVar());
    functionDefinitionEClass.getESuperTypes().add(theAadl2Package.getNamespace());
    functionDefinitionEClass.getESuperTypes().add(this.getDefinition());
    definitionBodyEClass.getESuperTypes().add(theAadl2Package.getElement());
    claimTextEClass.getESuperTypes().add(theAadl2Package.getElement());
    exprEClass.getESuperTypes().add(theAadl2Package.getElement());
    letBindingEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
    letBindingEClass.getESuperTypes().add(this.getClaimTextVar());
    resoluteSubclauseEClass.getESuperTypes().add(theAadl2Package.getAnnexSubclause());
    proveStatementEClass.getESuperTypes().add(theAadl2Package.getElement());
    listTypeEClass.getESuperTypes().add(this.getType());
    setTypeEClass.getESuperTypes().add(this.getType());
    quantArgEClass.getESuperTypes().add(this.getArg());
    functionBodyEClass.getESuperTypes().add(this.getDefinitionBody());
    claimBodyEClass.getESuperTypes().add(this.getDefinitionBody());
    claimStringEClass.getESuperTypes().add(this.getClaimText());
    claimArgEClass.getESuperTypes().add(this.getClaimText());
    binaryExprEClass.getESuperTypes().add(this.getExpr());
    instanceOfExprEClass.getESuperTypes().add(this.getExpr());
    unaryExprEClass.getESuperTypes().add(this.getExpr());
    castExprEClass.getESuperTypes().add(this.getExpr());
    idExprEClass.getESuperTypes().add(this.getExpr());
    thisExprEClass.getESuperTypes().add(this.getExpr());
    failExprEClass.getESuperTypes().add(this.getExpr());
    intExprEClass.getESuperTypes().add(this.getExpr());
    realExprEClass.getESuperTypes().add(this.getExpr());
    boolExprEClass.getESuperTypes().add(this.getExpr());
    stringExprEClass.getESuperTypes().add(this.getExpr());
    ifThenElseExprEClass.getESuperTypes().add(this.getExpr());
    quantifiedExprEClass.getESuperTypes().add(this.getExpr());
    builtInFnCallExprEClass.getESuperTypes().add(this.getExpr());
    fnCallExprEClass.getESuperTypes().add(this.getExpr());
    listFilterMapExprEClass.getESuperTypes().add(this.getExpr());
    listExprEClass.getESuperTypes().add(this.getExpr());
    setFilterMapExprEClass.getESuperTypes().add(this.getExpr());
    setExprEClass.getESuperTypes().add(this.getExpr());
    letExprEClass.getESuperTypes().add(this.getExpr());

    // Initialize classes and features; add operations and parameters
    initEClass(resoluteLibraryEClass, ResoluteLibrary.class, "ResoluteLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getResoluteLibrary_Definitions(), this.getDefinition(), null, "definitions", null, 0, -1, ResoluteLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(definitionEClass, Definition.class, "Definition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(typeEClass, Type.class, "Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(baseTypeEClass, BaseType.class, "BaseType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBaseType_ParamType(), this.getType(), null, "paramType", null, 0, 1, BaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBaseType_Type(), theEcorePackage.getEString(), "type", null, 0, 1, BaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(argEClass, Arg.class, "Arg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getArg_Type(), this.getType(), null, "type", null, 0, 1, Arg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(constantDefinitionEClass, ConstantDefinition.class, "ConstantDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConstantDefinition_Type(), this.getType(), null, "type", null, 0, 1, ConstantDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConstantDefinition_Expr(), this.getExpr(), null, "expr", null, 0, 1, ConstantDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionDefinitionEClass, FunctionDefinition.class, "FunctionDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFunctionDefinition_Args(), this.getArg(), null, "args", null, 0, -1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunctionDefinition_Body(), this.getDefinitionBody(), null, "body", null, 0, 1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(definitionBodyEClass, DefinitionBody.class, "DefinitionBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDefinitionBody_Expr(), this.getExpr(), null, "expr", null, 0, 1, DefinitionBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(claimTextEClass, ClaimText.class, "ClaimText", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(claimTextVarEClass, ClaimTextVar.class, "ClaimTextVar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(exprEClass, Expr.class, "Expr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(letBindingEClass, LetBinding.class, "LetBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLetBinding_Type(), this.getType(), null, "type", null, 0, 1, LetBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLetBinding_Expr(), this.getExpr(), null, "expr", null, 0, 1, LetBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resoluteSubclauseEClass, ResoluteSubclause.class, "ResoluteSubclause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getResoluteSubclause_Proves(), this.getProveStatement(), null, "proves", null, 0, -1, ResoluteSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nestedDotIDEClass, NestedDotID.class, "NestedDotID", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNestedDotID_Base(), theAadl2Package.getNamedElement(), null, "base", null, 0, 1, NestedDotID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNestedDotID_Sub(), this.getNestedDotID(), null, "sub", null, 0, 1, NestedDotID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(proveStatementEClass, ProveStatement.class, "ProveStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getProveStatement_Expr(), this.getExpr(), null, "expr", null, 0, 1, ProveStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(listTypeEClass, ListType.class, "ListType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getListType_Type(), this.getType(), null, "type", null, 0, 1, ListType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(setTypeEClass, SetType.class, "SetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSetType_Type(), this.getType(), null, "type", null, 0, 1, SetType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(quantArgEClass, QuantArg.class, "QuantArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getQuantArg_Expr(), this.getExpr(), null, "expr", null, 0, 1, QuantArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionBodyEClass, FunctionBody.class, "FunctionBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFunctionBody_Type(), this.getType(), null, "type", null, 0, 1, FunctionBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(claimBodyEClass, ClaimBody.class, "ClaimBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClaimBody_Claim(), this.getClaimText(), null, "claim", null, 0, -1, ClaimBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(claimStringEClass, ClaimString.class, "ClaimString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getClaimString_Str(), theEcorePackage.getEString(), "str", null, 0, 1, ClaimString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(claimArgEClass, ClaimArg.class, "ClaimArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClaimArg_Arg(), this.getClaimTextVar(), null, "arg", null, 0, 1, ClaimArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClaimArg_Unit(), theAadl2Package.getUnitLiteral(), null, "unit", null, 0, 1, ClaimArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(binaryExprEClass, BinaryExpr.class, "BinaryExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBinaryExpr_Left(), this.getExpr(), null, "left", null, 0, 1, BinaryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBinaryExpr_Op(), theEcorePackage.getEString(), "op", null, 0, 1, BinaryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBinaryExpr_Right(), this.getExpr(), null, "right", null, 0, 1, BinaryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(instanceOfExprEClass, InstanceOfExpr.class, "InstanceOfExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInstanceOfExpr_Expr(), this.getExpr(), null, "expr", null, 0, 1, InstanceOfExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInstanceOfExpr_Type(), this.getBaseType(), null, "type", null, 0, 1, InstanceOfExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unaryExprEClass, UnaryExpr.class, "UnaryExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnaryExpr_Op(), theEcorePackage.getEString(), "op", null, 0, 1, UnaryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnaryExpr_Expr(), this.getExpr(), null, "expr", null, 0, 1, UnaryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(castExprEClass, CastExpr.class, "CastExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCastExpr_Type(), this.getBaseType(), null, "type", null, 0, 1, CastExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCastExpr_Expr(), this.getExpr(), null, "expr", null, 0, 1, CastExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(idExprEClass, IdExpr.class, "IdExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIdExpr_Id(), theAadl2Package.getNamedElement(), null, "id", null, 0, 1, IdExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(thisExprEClass, ThisExpr.class, "ThisExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getThisExpr_Sub(), this.getNestedDotID(), null, "sub", null, 0, 1, ThisExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(failExprEClass, FailExpr.class, "FailExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFailExpr_Val(), this.getExpr(), null, "val", null, 0, 1, FailExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFailExpr_Failmsg(), this.getClaimText(), null, "failmsg", null, 0, -1, FailExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(intExprEClass, IntExpr.class, "IntExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIntExpr_Val(), theAadl2Package.getIntegerLiteral(), null, "val", null, 0, 1, IntExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(realExprEClass, RealExpr.class, "RealExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRealExpr_Val(), theAadl2Package.getRealLiteral(), null, "val", null, 0, 1, RealExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(boolExprEClass, BoolExpr.class, "BoolExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBoolExpr_Val(), theAadl2Package.getBooleanLiteral(), null, "val", null, 0, 1, BoolExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stringExprEClass, StringExpr.class, "StringExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStringExpr_Val(), theAadl2Package.getStringLiteral(), null, "val", null, 0, 1, StringExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ifThenElseExprEClass, IfThenElseExpr.class, "IfThenElseExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIfThenElseExpr_Cond(), this.getExpr(), null, "cond", null, 0, 1, IfThenElseExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfThenElseExpr_Then(), this.getExpr(), null, "then", null, 0, 1, IfThenElseExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfThenElseExpr_Else(), this.getExpr(), null, "else", null, 0, 1, IfThenElseExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(quantifiedExprEClass, QuantifiedExpr.class, "QuantifiedExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getQuantifiedExpr_Quant(), theEcorePackage.getEString(), "quant", null, 0, 1, QuantifiedExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQuantifiedExpr_Args(), this.getArg(), null, "args", null, 0, -1, QuantifiedExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQuantifiedExpr_Expr(), this.getExpr(), null, "expr", null, 0, 1, QuantifiedExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(builtInFnCallExprEClass, BuiltInFnCallExpr.class, "BuiltInFnCallExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBuiltInFnCallExpr_Fn(), theEcorePackage.getEString(), "fn", null, 0, 1, BuiltInFnCallExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBuiltInFnCallExpr_Args(), this.getExpr(), null, "args", null, 0, -1, BuiltInFnCallExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fnCallExprEClass, FnCallExpr.class, "FnCallExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFnCallExpr_Fn(), this.getFunctionDefinition(), null, "fn", null, 0, 1, FnCallExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFnCallExpr_Args(), this.getExpr(), null, "args", null, 0, -1, FnCallExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(listFilterMapExprEClass, ListFilterMapExpr.class, "ListFilterMapExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getListFilterMapExpr_Map(), this.getExpr(), null, "map", null, 0, 1, ListFilterMapExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getListFilterMapExpr_Args(), this.getArg(), null, "args", null, 0, -1, ListFilterMapExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getListFilterMapExpr_Filter(), this.getExpr(), null, "filter", null, 0, 1, ListFilterMapExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(listExprEClass, ListExpr.class, "ListExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getListExpr_Exprs(), this.getExpr(), null, "exprs", null, 0, -1, ListExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(setFilterMapExprEClass, SetFilterMapExpr.class, "SetFilterMapExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSetFilterMapExpr_Map(), this.getExpr(), null, "map", null, 0, 1, SetFilterMapExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSetFilterMapExpr_Args(), this.getArg(), null, "args", null, 0, -1, SetFilterMapExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSetFilterMapExpr_Filter(), this.getExpr(), null, "filter", null, 0, 1, SetFilterMapExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(setExprEClass, SetExpr.class, "SetExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSetExpr_Exprs(), this.getExpr(), null, "exprs", null, 0, -1, SetExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(letExprEClass, LetExpr.class, "LetExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLetExpr_Binding(), this.getLetBinding(), null, "binding", null, 0, 1, LetExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLetExpr_Expr(), this.getExpr(), null, "expr", null, 0, 1, LetExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //ResolutePackageImpl
