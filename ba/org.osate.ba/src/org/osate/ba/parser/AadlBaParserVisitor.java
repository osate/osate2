/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2013 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 2.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * https://www.eclipse.org/legal/epl-2.0/
 */

package org.osate.ba.parser ;

import java.util.Iterator ;
import java.util.List ;

import org.antlr.v4.runtime.CommonToken ;
import org.antlr.v4.runtime.Token ;
import org.antlr.v4.runtime.misc.NotNull ;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor ;
import org.antlr.v4.runtime.tree.TerminalNode ;
import org.eclipse.emf.common.util.BasicEList ;
import org.osate.aadl2.Aadl2Factory ;
import org.osate.aadl2.BooleanLiteral ;
import org.osate.aadl2.ClassifierValue ;
import org.osate.aadl2.DataClassifier ;
import org.osate.aadl2.IntegerLiteral ;
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.ModalPropertyValue ;
import org.osate.aadl2.ProcessorClassifier ;
import org.osate.aadl2.PropertyAssociation ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.RangeValue ;
import org.osate.aadl2.RealLiteral ;
import org.osate.aadl2.RecordValue ;
import org.osate.aadl2.ReferenceValue ;
import org.osate.aadl2.StringLiteral ;
import org.osate.aadl2.parsesupport.AObject ;
import org.osate.ba.aadlba.AadlBaFactory ;
import org.osate.ba.aadlba.Any ;
import org.osate.ba.aadlba.BehaviorActionCollection ;
import org.osate.ba.aadlba.BehaviorActions ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.aadlba.BehaviorIntegerLiteral ;
import org.osate.ba.aadlba.BehaviorRealLiteral ;
import org.osate.ba.aadlba.BehaviorState ;
import org.osate.ba.aadlba.BinaryAddingOperator ;
import org.osate.ba.aadlba.BinaryNumericOperator ;
import org.osate.ba.aadlba.ElementValues ;
import org.osate.ba.aadlba.ElseStatement ;
import org.osate.ba.aadlba.Factor ;
import org.osate.ba.aadlba.IfStatement ;
import org.osate.ba.aadlba.IntegerValue ;
import org.osate.ba.aadlba.IterativeVariable ;
import org.osate.ba.aadlba.LogicalOperator ;
import org.osate.ba.aadlba.LowerBound ;
import org.osate.ba.aadlba.MultiplyingOperator ;
import org.osate.ba.aadlba.ParameterLabel ;
import org.osate.ba.aadlba.Relation ;
import org.osate.ba.aadlba.RelationalOperator ;
import org.osate.ba.aadlba.Term ;
import org.osate.ba.aadlba.UnaryAddingOperator ;
import org.osate.ba.aadlba.UnaryBooleanOperator ;
import org.osate.ba.aadlba.UnaryNumericOperator ;
import org.osate.ba.aadlba.UpperBound ;
import org.osate.ba.aadlba.Value ;
import org.osate.ba.analyzers.DeclarativeUtils ;
import org.osate.ba.declarative.DeclarativeArrayDimension ;
import org.osate.ba.declarative.DeclarativeClassifierValue ;
import org.osate.ba.declarative.DeclarativeFactory ;
import org.osate.ba.declarative.DeclarativeIntegerLiteral ;
import org.osate.ba.declarative.DeclarativePropertyExpression ;
import org.osate.ba.declarative.DeclarativePropertyName ;
import org.osate.ba.declarative.DeclarativePropertyReference ;
import org.osate.ba.declarative.DeclarativeRealLiteral ;
import org.osate.ba.declarative.DeclarativeReferenceValue ;
import org.osate.ba.declarative.Identifier ;
import org.osate.ba.declarative.NamedValue ;
import org.osate.ba.declarative.QualifiedNamedElement ;
import org.osate.ba.declarative.Reference ;
import org.osate.ba.parser.AadlBaParser.Array_identifierContext ;
import org.osate.ba.parser.AadlBaParser.Behavior_actionContext ;
import org.osate.ba.parser.AadlBaParser.Behavior_state_listContext ;
import org.osate.ba.parser.AadlBaParser.Behavior_transitionContext ;
import org.osate.ba.parser.AadlBaParser.Behavior_variableContext ;
import org.osate.ba.parser.AadlBaParser.Behavior_variable_listContext ;
import org.osate.ba.parser.AadlBaParser.Binary_adding_operatorContext ;
import org.osate.ba.parser.AadlBaParser.Boolean_property_valueContext ;
import org.osate.ba.parser.AadlBaParser.Classifier_property_valueContext ;
import org.osate.ba.parser.AadlBaParser.Data_classifier_property_associationContext ;
import org.osate.ba.parser.AadlBaParser.Dispatch_conjunctionContext ;
import org.osate.ba.parser.AadlBaParser.Elsif_statementContext ;
import org.osate.ba.parser.AadlBaParser.FactorContext ;
import org.osate.ba.parser.AadlBaParser.Field_property_associationContext ;
import org.osate.ba.parser.AadlBaParser.In_bindingContext ;
import org.osate.ba.parser.AadlBaParser.Integer_property_valueContext ;
import org.osate.ba.parser.AadlBaParser.Integer_valueContext ;
import org.osate.ba.parser.AadlBaParser.Integer_value_constantContext ;
import org.osate.ba.parser.AadlBaParser.List_property_valueContext ;
import org.osate.ba.parser.AadlBaParser.Logical_operatorContext ;
import org.osate.ba.parser.AadlBaParser.Mode_switch_trigger_conjunctionContext ;
import org.osate.ba.parser.AadlBaParser.Multiplying_operatorContext ;
import org.osate.ba.parser.AadlBaParser.Numeric_property_valueContext ;
import org.osate.ba.parser.AadlBaParser.Numeric_range_property_valueContext ;
import org.osate.ba.parser.AadlBaParser.Parameter_labelContext ;
import org.osate.ba.parser.AadlBaParser.Property_nameContext ;
import org.osate.ba.parser.AadlBaParser.Property_refContext ;
import org.osate.ba.parser.AadlBaParser.Property_referenceContext ;
import org.osate.ba.parser.AadlBaParser.Property_valueContext ;
import org.osate.ba.parser.AadlBaParser.Qualifiable_propertyContext ;
import org.osate.ba.parser.AadlBaParser.Real_literalContext ;
import org.osate.ba.parser.AadlBaParser.Real_property_valueContext ;
import org.osate.ba.parser.AadlBaParser.Record_property_valueContext ;
import org.osate.ba.parser.AadlBaParser.ReferenceContext ;
import org.osate.ba.parser.AadlBaParser.Reference_property_valueContext ;
import org.osate.ba.parser.AadlBaParser.RelationContext ;
import org.osate.ba.parser.AadlBaParser.Signed_intContext ;
import org.osate.ba.parser.AadlBaParser.Signed_realContext ;
import org.osate.ba.parser.AadlBaParser.TermContext ;
import org.osate.ba.parser.AadlBaParser.Unique_component_classifier_referenceContext ;
import org.osate.ba.parser.AadlBaParser.Unit_referenceContext ;
import org.osate.ba.parser.AadlBaParser.Value_constantContext ;
import org.osate.ba.parser.AadlBaParser.Value_constant_or_variableContext ;
import org.osate.ba.utils.AadlBaLocationReference ;


/**
 * This class provides an empty implementation of {@link AadlBaVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class AadlBaParserVisitor<T> extends AbstractParseTreeVisitor<T>
                                                                       implements
                                                                       AadlBaVisitor<T>
{
  protected BehaviorAnnex _ba = null ;

  protected AadlBaFactory _baFact = AadlBaFactory.eINSTANCE ;
  
  protected Aadl2Factory _coreFact = Aadl2Factory.eINSTANCE ;

  protected DeclarativeFactory _decl = DeclarativeFactory.eINSTANCE ;

  protected String _filename ;

  protected final static String behaviorElementId = "" ;

  protected int _annexOffset = 0 ;
  
  public AadlBaParserVisitor(String filename, int annexOffset)
  {
    _filename = filename ;
    _annexOffset = annexOffset ;
  }

  /**
   * Sets obj's location reference based on full token informations.
   *
   * @param obj the AObject to be set
   * @param src the token 
   */
  protected void setLocationReference(AObject obj,
                                    Token token)
  {
    int offset = ((CommonToken) token).getStartIndex() ;
    int length = token.getText().length() ;
    int column = token.getCharPositionInLine() + 1 ; // Zero index based.
    int line = token.getLine() ;

    AadlBaLocationReference location =
          new AadlBaLocationReference(_annexOffset, _filename, line, offset,
                length, column, behaviorElementId) ;

    obj.setLocationReference(location) ;
  }

  protected void setLocationReference(AObject obj,
                                    TerminalNode node)
  {
    setLocationReference(obj, node.getSymbol()) ;
  }

  public void setAnnexOffset(int offset)
  {
    _annexOffset = offset ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitNumeral(@NotNull AadlBaParser.NumeralContext ctx)
  {
    String tmp = ctx.INTEGER_LIT().getText() ;
    tmp = tmp.replaceAll("_", "") ;
    ctx.result = new Integer(Integer.parseInt(tmp)) ;
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitUnary_boolean_operator(@NotNull AadlBaParser.Unary_boolean_operatorContext ctx)
  {
    ctx.result = UnaryBooleanOperator.NOT ;
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitDispatch_condition(@NotNull AadlBaParser.Dispatch_conditionContext ctx)
  {
    visitChildren(ctx) ;
    
    // Location reference is set in behavior_condition
    ctx.result = _baFact.createDispatchCondition() ;

    if(ctx.dispatch_trigger_condition() != null)
    {
      ctx.result
            .setDispatchTriggerCondition(ctx.dispatch_trigger_condition().result) ;
    }

    if(ctx.FROZEN() != null)
    {
      for(ReferenceContext rc : ctx.reference())
      {
        ctx.result.getFrozenPorts().add(rc.result) ;
      }
    }

    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitDispatch_conjunction(@NotNull AadlBaParser.Dispatch_conjunctionContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = _baFact.createDispatchConjunction() ;

    ctx.result.setLocationReference(ctx.reference(0).result
          .getLocationReference()) ;

    for(ReferenceContext rc : ctx.reference())
    {
      ctx.result.getDispatchTriggers().add(rc.result) ;
    }

    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitDispatch_trigger_logical_expression(@NotNull AadlBaParser.Dispatch_trigger_logical_expressionContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = _baFact.createDispatchTriggerLogicalExpression() ;

    ctx.result.setLocationReference(ctx.dispatch_conjunction(0).result
          .getLocationReference()) ;

    for(Dispatch_conjunctionContext dcc : ctx.dispatch_conjunction())
    {
      ctx.result.getDispatchConjunctions().add(dcc.result) ;
    }

    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitFor_statement(@NotNull AadlBaParser.For_statementContext ctx)
  {
    visitChildren(ctx) ;
    ctx.result = ctx.for_condition().result ;
    ctx.result.setBehaviorActions(ctx.behavior_actions().result) ;
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitBehavior_variable_list(@NotNull AadlBaParser.Behavior_variable_listContext ctx)
  {
    visitChildren(ctx) ;
    
    DeclarativeUtils
          .setEcontainer(ctx.ba,
                         ctx.unique_component_classifier_reference().result) ;

    List<Data_classifier_property_associationContext> dcpaList = ctx.data_classifier_property_association();
    
    for(Behavior_variableContext bvc : ctx.behavior_variable())
    {
      bvc.result
            .setDataClassifier((DataClassifier) ctx.unique_component_classifier_reference().result) ;

      for(Data_classifier_property_associationContext dcpa: dcpaList)
      {
        PropertyAssociation pa = _coreFact.createPropertyAssociation();
        pa.setProperty(dcpa.property_ref().result);
        ModalPropertyValue mpv = _coreFact.createModalPropertyValue();
        mpv.setOwnedValue(clonePropertyExpression(dcpa.property_value().result));
        pa.getOwnedValues().add(mpv);
        bvc.result.getOwnedPropertyAssociations().add(pa);
      }
      ctx.ba.getVariables().add(bvc.result) ;
    }

    return null ;
  }

  private PropertyExpression clonePropertyExpression(PropertyExpression sourcePropertyExpression)
  {
    PropertyExpression targetPropertyExpression = null;
    if(sourcePropertyExpression instanceof ListValue)
    {
      ListValue sourceLV = (ListValue) sourcePropertyExpression;
      ListValue targetLV = _coreFact.createListValue();
      for(PropertyExpression propInList: sourceLV.getOwnedListElements())
      {
        targetLV.getOwnedListElements().add(clonePropertyExpression(propInList));
      }
      targetPropertyExpression = targetLV; 
    }
    else if(sourcePropertyExpression instanceof StringLiteral)
    {
      StringLiteral sourceSL = (StringLiteral) sourcePropertyExpression;
      StringLiteral targetSL = _coreFact.createStringLiteral();
      targetSL.setValue(sourceSL.getValue());
      targetPropertyExpression = targetSL;
    }
    else if(sourcePropertyExpression instanceof IntegerLiteral)
    {
      IntegerLiteral sourceIL = (IntegerLiteral) sourcePropertyExpression;
      IntegerLiteral targetIL = _coreFact.createIntegerLiteral();
      targetIL.setValue(sourceIL.getValue());
      targetIL.setUnit(sourceIL.getUnit());
      targetPropertyExpression = targetIL;
    }
    else if(sourcePropertyExpression instanceof RealLiteral)
    {
      RealLiteral sourceRL = (RealLiteral) sourcePropertyExpression;
      RealLiteral targetRL = _coreFact.createRealLiteral();
      targetRL.setValue(sourceRL.getValue());
      targetRL.setUnit(sourceRL.getUnit());
      targetPropertyExpression = targetRL;
    }
    else if(sourcePropertyExpression instanceof RecordValue)
    {
      RecordValue sourceRV = (RecordValue) sourcePropertyExpression;
      RecordValue targetRV = _coreFact.createRecordValue();
      targetRV.getOwnedFieldValues().addAll(sourceRV.getOwnedFieldValues());
      targetPropertyExpression = targetRV;
    }
    else if(sourcePropertyExpression instanceof BooleanLiteral)
    {
      BooleanLiteral sourceBL = (BooleanLiteral) sourcePropertyExpression;
      BooleanLiteral targetBL = _coreFact.createBooleanLiteral();
      targetBL.setValue(sourceBL.getValue());
      targetPropertyExpression = targetBL;
    }
    else if(sourcePropertyExpression instanceof RangeValue)
    {
      RangeValue sourceRV = (RangeValue) sourcePropertyExpression;
      RangeValue targetRV = _coreFact.createRangeValue();
      targetRV.setMinimum(clonePropertyExpression(sourceRV.getMinimum()));
      targetRV.setMaximum(clonePropertyExpression(sourceRV.getMaximum()));
      targetPropertyExpression = targetRV;
    }
    else if(sourcePropertyExpression instanceof DeclarativeReferenceValue)
    {
      DeclarativeReferenceValue sourceDRV = (DeclarativeReferenceValue) sourcePropertyExpression;
      ReferenceValue targetRV = _coreFact.createReferenceValue();
      targetRV.setPath(sourceDRV.getRef());
      targetPropertyExpression = targetRV;
    }
    else if(sourcePropertyExpression instanceof DeclarativeClassifierValue)
    {
      DeclarativeClassifierValue sourceDCV = (DeclarativeClassifierValue) sourcePropertyExpression;
      ClassifierValue targetCV = _coreFact.createClassifierValue();
      targetCV.setClassifier(sourceDCV.getClassifier());
      targetPropertyExpression = targetCV;
    }
    return targetPropertyExpression;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitParameter_label(@NotNull AadlBaParser.Parameter_labelContext ctx)
  {
    visitChildren(ctx) ;
    ctx.result = ctx.value_expression().result ;
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitRelation(@NotNull AadlBaParser.RelationContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = _baFact.createRelation() ;

    ctx.result.setFirstExpression(ctx.simple_expression(0).result) ;
    ctx.result.setLocationReference(ctx.simple_expression(0).result
          .getLocationReference()) ;
    if(ctx.relational_operator() != null)
    {
      ctx.result.setRelationalOperator(ctx.relational_operator().result) ;
      ctx.result.setSecondExpression(ctx.simple_expression(1).result) ;
    }

    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitBinary_numeric_operator(@NotNull AadlBaParser.Binary_numeric_operatorContext ctx)
  {
    ctx.result = BinaryNumericOperator.MULTIPLY_MULTIPLY ;
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitSubprogram_parameter_list(@NotNull AadlBaParser.Subprogram_parameter_listContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = new BasicEList<ParameterLabel>() ;

    for(Parameter_labelContext plc : ctx.parameter_label())
    {
      ctx.result.add(plc.result) ;
    }

    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitMultiplying_operator(@NotNull AadlBaParser.Multiplying_operatorContext ctx)
  {
    if(ctx.STAR() != null)
    {
      ctx.result = MultiplyingOperator.MULTIPLY ;
    }
    else if(ctx.DIVIDE() != null)
    {
      ctx.result = MultiplyingOperator.DIVIDE ;
    }
    else if(ctx.MOD() != null)
    {
      ctx.result = MultiplyingOperator.MOD ;
    }
    else
    {
      ctx.result = MultiplyingOperator.REM ;
    }

    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitDispatch_trigger_condition(@NotNull AadlBaParser.Dispatch_trigger_conditionContext ctx)
  {
    visitChildren(ctx) ;
    
    if(ctx.dispatch_trigger_logical_expression() != null)
    {
      ctx.result = ctx.dispatch_trigger_logical_expression().result ;
    }
    else if(ctx.TIMEOUT() != null)
    {
      if(ctx.behavior_time() != null)
      {
        ctx.result = ctx.behavior_time().result ;
      }
      else
      {
        ctx.result = _baFact.createDispatchRelativeTimeout() ;
        setLocationReference(ctx.result, ctx.TIMEOUT()) ;
      }
    }
    else
    {
      ctx.result = _baFact.createDispatchTriggerConditionStop() ;
      setLocationReference(ctx.result, ctx.STOP()) ;
    }

    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitBinary_adding_operator(@NotNull AadlBaParser.Binary_adding_operatorContext ctx)
  {
    if(ctx.PLUS() != null)
    {
      ctx.result = BinaryAddingOperator.PLUS ;
    }
    else
    {
      ctx.result = BinaryAddingOperator.MINUS ;
    }

    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitBehavior_action(@NotNull AadlBaParser.Behavior_actionContext ctx)
  {
    visitChildren(ctx) ;
    
    if(ctx.basic_action() != null)
    {
      ctx.result = ctx.basic_action().result ;
    }
    else if(ctx.if_statement() != null)
    {
      ctx.result = ctx.if_statement().result ;
    }
    else if(ctx.for_statement() != null)
    {
      ctx.result = ctx.for_statement().result ;
    }
    else if(ctx.while_statement() != null)
    {
      ctx.result = ctx.while_statement().result ;
    }
    else if(ctx.dountil_statement() != null)
    {
      ctx.result = ctx.dountil_statement().result ;
    }
    else if(ctx.behavior_action_block() != null)
    {
      ctx.result = ctx.behavior_action_block().result ;
    }
    else
    {
      ctx.result = ctx.forall_statement().result ;
    }

    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitAssignment_action(@NotNull AadlBaParser.Assignment_actionContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = _baFact.createAssignmentAction() ;
    ctx.result.setLocationReference(ctx.target().result.getLocationReference()) ;
    ctx.result.setTarget(ctx.target().result) ;

    if(ctx.value_expression() != null)
    {
      ctx.result.setValueExpression(ctx.value_expression().result) ;
    }
    else
    {
      Any any = _baFact.createAny() ;
      setLocationReference(any, ctx.ANY()) ;
      ctx.result.setValueExpression(any) ;
    }

    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitLogical_operator(@NotNull AadlBaParser.Logical_operatorContext ctx)
  {
    if(ctx.AND() != null)
    {
      ctx.result = LogicalOperator.AND ;
    }
    else if(ctx.OR() != null)
    {
      ctx.result = LogicalOperator.OR ;
    }
    else
    {
      ctx.result = LogicalOperator.XOR ;
    }

    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitCommunication_action(@NotNull AadlBaParser.Communication_actionContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = _decl.createCommAction() ;

    if(ctx.reference() != null)
    {
      ctx.result.setReference(ctx.reference().result) ;
      ctx.result.setLocationReference(ctx.reference().result
            .getLocationReference()) ;

      if(ctx.INTERROG() != null)
      {
        ctx.result.setPortDequeue(true) ;

        if(ctx.target() != null)
        {
          ctx.result.setTarget(ctx.target().result) ;
        }
      }
      else if(ctx.GGREATER() != null)
      {
        ctx.result.setPortFreeze(true) ;
      }
      else if(ctx.EXCLLESS() != null)
      {
        ctx.result.setLock(true) ;
      }
      else if(ctx.EXCLGREATER() != null)
      {
        ctx.result.setUnlock(true) ;
      }
      else
      {
        if(ctx.subprogram_parameter_list() != null)
        {
          ctx.result.getParameters()
                .addAll(ctx.subprogram_parameter_list().result) ;
        }
      }
    }
    else if(ctx.qualified_named_element() != null)
    {
      ctx.result.setLocationReference(ctx.qualified_named_element().result
            .getLocationReference()) ;
      ctx.result.setQualifiedName(ctx.qualified_named_element().result) ;

      if(ctx.subprogram_parameter_list() != null)
      {
        ctx.result.getParameters()
              .addAll(ctx.subprogram_parameter_list().result) ;
      }
    }
    else
    {
      if(ctx.EXCLLESS() != null)
      {
        ctx.result.setLock(true) ;
      }
      else
      {
        ctx.result.setUnlock(true) ;
      }

      setLocationReference(ctx.result, ctx.STAR()) ;
    }

    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitBehavior_action_block(@NotNull AadlBaParser.Behavior_action_blockContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = ctx.action_block().result ;

    if(ctx.TIMEOUT() != null)
    {
      ctx.result.setTimeout(ctx.behavior_time().result) ;
    }

    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitValue_variable(@NotNull AadlBaParser.Value_variableContext ctx)
  {
    visitChildren(ctx) ;
    
    Reference tmp = ctx.reference().result ;

    if(ctx.TICK() != null)
    {
      if(ctx.COUNT() != null)
      {
        NamedValue nv = _decl.createNamedValue() ;
        nv.setReference(tmp) ;
        nv.setCount(true) ;
        nv.setLocationReference(tmp.getLocationReference()) ;
        ctx.result = nv ;
      }
      else
      {
        NamedValue nv = _decl.createNamedValue() ;
        nv.setReference(tmp) ;
        nv.setFresh(true) ;
        nv.setLocationReference(tmp.getLocationReference()) ;
        ctx.result = nv ;
      }
    }
    else if(ctx.INTERROG() != null)
    {
      NamedValue nv = _decl.createNamedValue() ;
      nv.setReference(tmp) ;
      nv.setDequeue(true) ;
      nv.setLocationReference(tmp.getLocationReference()) ;
      ctx.result = nv ;
    }
    else
    {
      ctx.result = tmp ;
    }

    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitQualifiable_named_element(@NotNull AadlBaParser.Qualifiable_named_elementContext ctx)
  {
    Identifier nameId = _decl.createIdentifier() ;
    nameId.setId(ctx.id2) ;
    setLocationReference(nameId, ctx.identifier2) ;
    ctx.result.setBaName(nameId) ;

    if(!ctx.id1.equals(""))
    {
      Identifier nameSpaceId = _decl.createIdentifier() ;
      nameSpaceId.setId(ctx.id1) ;
      setLocationReference(nameSpaceId, ctx.identifier1) ;
      ctx.result.setBaNamespace(nameSpaceId) ;
      setLocationReference(ctx.result, ctx.identifier1) ;
    }
    else
    {
      setLocationReference(ctx.result, ctx.identifier2) ;
    }

    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitInteger_literal(@NotNull AadlBaParser.Integer_literalContext ctx)
  {
    String str = ctx.INTEGER_LIT().getText() ;
    BehaviorIntegerLiteral tmp = _decl.createDeclarativeIntegerLiteral() ;
    tmp.setValue(str) ;
    setLocationReference(tmp, ctx.INTEGER_LIT()) ;
    ctx.result = (DeclarativeIntegerLiteral) tmp ;
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitString_literal(@NotNull AadlBaParser.String_literalContext ctx)
  {
    ctx.result = _decl.createDeclarativeStringLiteral();
    String str = ctx.STRING_LITERAL().getText() ;
    // stripout the quotes
    ctx.result.setValue(str.substring(1,str.length()-1)) ;
    setLocationReference(ctx.result, ctx.STRING_LITERAL());
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitUnary_numeric_operator(@NotNull AadlBaParser.Unary_numeric_operatorContext ctx)
  {
    ctx.result = UnaryNumericOperator.ABS;
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitQualified_named_element(@NotNull AadlBaParser.Qualified_named_elementContext ctx)
  {
    ctx.result = _decl.createQualifiedNamedElement();
    Identifier nameId = _decl.createIdentifier();
    nameId.setId(ctx.nameId);
    setLocationReference(nameId, ctx.id2); 
    ctx.result.setBaName(nameId);
   
    if (ctx.id1 != null)
    {
      Identifier nameSpaceId = _decl.createIdentifier();
      nameSpaceId.setId(ctx.namespaceId);
      setLocationReference(nameSpaceId, ctx.id1); 
      ctx.result.setBaNamespace(nameSpaceId);
      setLocationReference(ctx.result, ctx.id1);
    }
    else
    {
      setLocationReference(ctx.result, ctx.id2);
    }
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitBoolean_literal(@NotNull AadlBaParser.Boolean_literalContext ctx)
  {
    ctx.result = _baFact.createBehaviorBooleanLiteral();
    
    TerminalNode node = null ;
    
    if(ctx.TRUE() != null)
    {
      ctx.result.setValue(true) ;
      node = ctx.TRUE() ;
    }
    else
    {
      ctx.result.setValue(false) ;
      node = ctx.FALSE() ;
    }
    
    setLocationReference(ctx.result, node) ;
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitAction_block(@NotNull AadlBaParser.Action_blockContext ctx)
  {
    visitChildren(ctx) ;
    ctx.result = _baFact.createBehaviorActionBlock() ;
    ctx.result.setContent(ctx.behavior_actions().result) ;
    setLocationReference(ctx.result, ctx.LCURLY(0)) ;
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitDountil_statement(@NotNull AadlBaParser.Dountil_statementContext ctx)
  {
    visitChildren(ctx) ;
    ctx.result = _baFact.createWhileOrDoUntilStatement();
    setLocationReference(ctx.result, ctx.DO()); 
    ctx.result.setDoUntil(true);
    ctx.result.setBehaviorActions(ctx.behavior_actions().result);
    ctx.result.setLogicalValueExpression(ctx.value_expression().result);
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitArray_identifier(@NotNull AadlBaParser.Array_identifierContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = _decl.createArrayableIdentifier() ;
    ctx.result.setId(ctx.IDENT().getText());
    setLocationReference(ctx.result, ctx.IDENT()); 
    
    if(! ctx.integer_value().isEmpty())
    {
      for(Integer_valueContext ivc : ctx.integer_value())
      {
        ctx.result.getArrayIndexes().add(ivc.result) ;
      }
    }
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitIf_statement(@NotNull AadlBaParser.If_statementContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = _baFact.createIfStatement() ;
    setLocationReference(ctx.result, ctx.IF(0)); 
    ctx.result.setLogicalValueExpression(ctx.value_expression().result) ;
    ctx.result.setBehaviorActions(ctx.behavior_actions(0).result);
    
    IfStatement previousState = ctx.result ;
    
    if(! ctx.elsif_statement().isEmpty())
    {
      IfStatement elsifStat = null ;
      
      for(Elsif_statementContext isc : ctx.elsif_statement())
      {
        elsifStat = isc.result ;
        previousState.setElseStatement(elsifStat) ;
        previousState = elsifStat ;
      }
    }
    
    if(ctx.ELSE() != null)
    {
      ElseStatement elseStat = _baFact.createElseStatement();
      setLocationReference(elseStat, ctx.ELSE());
      elseStat.setBehaviorActions(ctx.behavior_actions(1).result);
      previousState.setElseStatement(elseStat);
    }
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitWhile_statement(@NotNull AadlBaParser.While_statementContext ctx)
  {
    visitChildren(ctx) ;
    ctx.result = ctx.while_condition().result ;
    ctx.result.setBehaviorActions(ctx.behavior_actions().result) ;
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitBehavior_state_list(@NotNull AadlBaParser.Behavior_state_listContext ctx)
  {
    visitChildren(ctx) ;
    
    BehaviorState bs = null ;
    
    for(TerminalNode bsId : ctx.IDENT())
    {
      bs = _baFact.createBehaviorState() ;
      
      bs.setName(bsId.getText()) ;
      
      setLocationReference(bs, bsId) ; 
      
      if(ctx.INITIAL() != null)
      {
        bs.setInitial(true) ;
        ctx.ba.setInitialState(bs);
      }
      
      if(ctx.COMPLETE() != null)
      {
        bs.setComplete(true) ;
      }
      
      if(ctx.FINAL() != null)
      {
        bs.setFinal(true) ;
      }
      
      ctx.ba.getStates().add(bs) ;
    }
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitTimed_action(@NotNull AadlBaParser.Timed_actionContext ctx)
  {
    ctx.result = _baFact.createTimedAction() ;
    setLocationReference(ctx.result, ctx.COMPUTATION()) ;
    
    if(ctx.in_binding() != null)
    {
      ctx.in_binding().ta = ctx.result ;
    }
    
    visitChildren(ctx) ;
    
    ctx.result.setLowerTime(ctx.behavior_time(0).result) ;
    
    if(ctx.behavior_time().size() == 2)
    {
      ctx.result.setUpperTime(ctx.behavior_time(1).result);
    }
    
    return null ;
  }
  
  @Override
  public T visitProcessor_parameter_list(@NotNull AadlBaParser.Processor_parameter_listContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = new BasicEList<ProcessorClassifier>() ;

    for(Unique_component_classifier_referenceContext uccrc : ctx.unique_component_classifier_reference())
    {
      DeclarativeUtils.setEcontainer(_ba,uccrc.result) ;
      ctx.result.add(uccrc.result) ;
    }
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitForall_condition(@NotNull AadlBaParser.Forall_conditionContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = _baFact.createForOrForAllStatement() ;
    ctx.result.setForAll(true) ;
    setLocationReference(ctx.result, ctx.FORALL()) ;

    IterativeVariable itVar = _baFact.createIterativeVariable() ;
    itVar.setName(ctx.IDENT().getText()) ;
    setLocationReference(itVar, ctx.IDENT()) ;
    ctx.result.setIterativeVariable(itVar) ;

    DeclarativeUtils
          .setEcontainer(_ba,
                         ctx.unique_component_classifier_reference().result) ;
    itVar.setDataClassifier((DataClassifier) ctx.unique_component_classifier_reference().result) ;

    ctx.result.setIteratedValues(ctx.element_values().result) ;
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitBasic_action(@NotNull AadlBaParser.Basic_actionContext ctx)
  {
    visitChildren(ctx) ;
    
    if(ctx.assignment_action() != null)
    {
      ctx.result = ctx.assignment_action().result ;
    }
    else if(ctx.communication_action() != null)
    {
      ctx.result = ctx.communication_action().result ;
    }
    else
    {
      ctx.result = ctx.timed_action().result ;
    }
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitSimple_expression(@NotNull AadlBaParser.Simple_expressionContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = _baFact.createSimpleExpression();
    
    if(ctx.unary_adding_operator() != null)
    {
      ctx.result.setUnaryAddingOperator(ctx.unary_adding_operator().result);
    }
    
    Iterator<TermContext> termIt = ctx.term().iterator() ;
    Term tmp = termIt.next().result ;
    ctx.result.getTerms().add(tmp);
    ctx.result.setLocationReference(tmp.getLocationReference());
    
    for(Binary_adding_operatorContext op : ctx.binary_adding_operator())
    {
      tmp = termIt.next().result ;
      ctx.result.getTerms().add(tmp);
      ctx.result.getBinaryAddingOperators().add(op.result);
    }
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitFor_condition(@NotNull AadlBaParser.For_conditionContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = _baFact.createForOrForAllStatement() ;
    ctx.result.setForAll(false) ;
    setLocationReference(ctx.result, ctx.FOR()) ;

    IterativeVariable itVar = _baFact.createIterativeVariable() ;
    itVar.setName(ctx.IDENT().getText()) ;
    setLocationReference(itVar, ctx.IDENT()) ;
    ctx.result.setIterativeVariable(itVar) ;

    DeclarativeUtils
          .setEcontainer(_ba,
                         ctx.unique_component_classifier_reference().result) ;
    itVar.setDataClassifier((DataClassifier) ctx.unique_component_classifier_reference().result) ;

    ctx.result.setIteratedValues(ctx.element_values().result) ;
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitBehavior_time(@NotNull AadlBaParser.Behavior_timeContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = _decl.createDeclarativeTime() ;
    ctx.result.setIntegerValue(ctx.integer_value().result);
    ctx.result.setLocationReference(ctx.integer_value().result.
                                                        getLocationReference());
    Identifier id = _decl.createIdentifier() ;
    id.setId(ctx.IDENT().getText());
    setLocationReference(id, ctx.IDENT()) ;
    ctx.result.setUnitId(id);
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitUnary_adding_operator(@NotNull AadlBaParser.Unary_adding_operatorContext ctx)
  {
    if(ctx.PLUS() != null)
    {
      ctx.result = UnaryAddingOperator.PLUS ;
    }
    else
    {
      ctx.result = UnaryAddingOperator.MINUS ;
    }
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitInteger_range(@NotNull AadlBaParser.Integer_rangeContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = _baFact.createIntegerRange();
    Iterator<Integer_valueContext> it = ctx.integer_value().iterator() ;
    IntegerValue tmp = it.next().result ;
    ctx.result.setLowerIntegerValue(tmp);
    ctx.result.setUpperIntegerValue(it.next().result);
    ctx.result.setLocationReference(tmp.getLocationReference());
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitUnique_component_classifier_reference(@NotNull AadlBaParser.Unique_component_classifier_referenceContext ctx)
  {
    ctx.result = _decl.createQualifiedNamedElement() ;
    // Location reference is set in visitQualifiable_named_element.
    ctx.qualifiable_named_element().result = ctx.result ;
    visitChildren(ctx) ;
    visitQualifiable_named_element(ctx.qualifiable_named_element()) ;
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitBehavior_condition(@NotNull AadlBaParser.Behavior_conditionContext ctx)
  {
    visitChildren(ctx) ;
    
    if(ctx.ON() != null)
    {
      if(ctx.dispatch_condition() != null &&
            ctx.dispatch_condition().result != null)
      {
        setLocationReference(ctx.dispatch_condition().result, ctx.ON()) ;
        ctx.result = ctx.dispatch_condition().result ;
      }
      else
      {
        if(ctx.mode_switch_trigger_logical_expression()!=null &&
            ctx.mode_switch_trigger_logical_expression().result!=null)
        {
          setLocationReference(ctx.mode_switch_trigger_logical_expression().result, ctx.ON()) ;
          ctx.result = ctx.mode_switch_trigger_logical_expression().result ;
        }
      }
    }
    else
    {
      if(ctx.execute_condition() != null &&
            ctx.execute_condition().result != null)
      {
        ctx.result = ctx.execute_condition().result ;
      }
      else
      {
        ctx.result = null ;
      }
    }
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitBehavior_variable(@NotNull AadlBaParser.Behavior_variableContext ctx)
  {
    ctx.result = _baFact.createBehaviorVariable() ;
    visitChildren(ctx) ;
    setLocationReference(ctx.result, ctx.IDENT());
    ctx.result.setName(ctx.IDENT().getText()) ;
    
    DeclarativeArrayDimension dad = null ;
    
    for(Integer_value_constantContext ivcc : ctx.integer_value_constant())
    {
      dad = _decl.createDeclarativeArrayDimension();
      dad.setLocationReference(ivcc.result.getLocationReference()) ;
      dad.setDimension(ivcc.result) ;
      ctx.result.getArrayDimensions().add(dad); 
    }
        
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitFactor(@NotNull AadlBaParser.FactorContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = _baFact.createFactor();
    Iterator<Value_constant_or_variableContext> it = ctx.value_constant_or_variable().iterator() ;
    Value tmpValue = it.next().result ;
    ctx.result.setFirstValue(tmpValue) ;
    ctx.result.setLocationReference(tmpValue.getLocationReference()) ;

    if(ctx.binary_numeric_operator() != null)
    {
      ctx.result.setBinaryNumericOperator(ctx.binary_numeric_operator().result);
      ctx.result.setSecondValue(it.next().result);
    }
    else if(ctx.unary_numeric_operator() != null)
    {
      ctx.result.setUnaryNumericOperator(ctx.unary_numeric_operator().result);
    }
    else if(ctx.unary_boolean_operator() != null)
    {
      ctx.result.setUnaryBooleanOperator(ctx.unary_boolean_operator().result);
    }
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitRelational_operator(@NotNull AadlBaParser.Relational_operatorContext ctx)
  {
    if(ctx.EQUAL() != null)
    {
      ctx.result = RelationalOperator.EQUAL ;
    }
    else if(ctx.NOTEQUAL() != null)
    {
      ctx.result = RelationalOperator.NOT_EQUAL;
    }
    else if(ctx.LESSTHAN() != null)
    {
      ctx.result = RelationalOperator.LESS_THAN;
    }
    else if(ctx.LESSOREQUAL() != null)
    {
      ctx.result = RelationalOperator.LESS_OR_EQUAL_THAN;
    }
    else if(ctx.GREATERTHAN() != null)
    {
      ctx.result = RelationalOperator.GREATER_THAN;
    }
    else
    {
      ctx.result = RelationalOperator.GREATER_OR_EQUAL_THAN;
    }
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitBehavior_annex(@NotNull AadlBaParser.Behavior_annexContext ctx)
  {
    _ba = _baFact.createBehaviorAnnex();
    ctx.result = _ba ;
    
    for(Behavior_variable_listContext balc : ctx.behavior_variable_list())
    {
      balc.ba = _ba ;
    }
    
    for(Behavior_state_listContext bslc : ctx.behavior_state_list())
    {
      bslc.ba = _ba ;
    }
    
    visitChildren(ctx) ;

    if(ctx.TRANSITIONS() != null)
    {
      for(Behavior_transitionContext btc : ctx.behavior_transition())
      {
        ctx.result.getTransitions().add(btc.result) ;
      }
    }
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitElement_values(@NotNull AadlBaParser.Element_valuesContext ctx)
  {
    visitChildren(ctx) ;
    
    if(ctx.integer_range() != null)
    {
      ctx.result = ctx.integer_range().result ;
    }
    else
    {
      ctx.result = (ElementValues) ctx.reference().result ;
    }
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitReference(@NotNull AadlBaParser.ReferenceContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = _decl.createReference() ;
    
    ctx.result.setLocationReference(ctx.array_identifier(0).result.
                                                        getLocationReference());
    
    for(Array_identifierContext aic : ctx.array_identifier())
    {
      ctx.result.getIds().add(aic.result) ;
    }
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitValue_expression(@NotNull AadlBaParser.Value_expressionContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = _baFact.createValueExpression();
    
    Iterator<RelationContext> reIt = ctx.relation().iterator();
    Relation tmpRe = reIt.next().result ; 
    ctx.result.getRelations().add(tmpRe) ;
    ctx.result.setLocationReference(tmpRe.getLocationReference());
    
    if(! ctx.logical_operator().isEmpty())
    {
      for(Logical_operatorContext loc : ctx.logical_operator())
      {
        tmpRe = reIt.next().result ;
        ctx.result.getRelations().add(tmpRe) ;
        ctx.result.getLogicalOperators().add(loc.result);
      }
    }
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitNumeric_literal(@NotNull AadlBaParser.Numeric_literalContext ctx)
  {
    visitChildren(ctx) ;
    
    if(ctx.integer_literal() != null)
    {
      ctx.result = ctx.integer_literal().result ;
    }
    else
    {
      ctx.result = ctx.real_literal().result ;
    }
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitInteger_value(@NotNull AadlBaParser.Integer_valueContext ctx)
  {
    visitChildren(ctx) ;
    
    Value result = null ;
    
    if(ctx.integer_value_constant() != null)
    {
      result = ctx.integer_value_constant().result ;
    }
    else
    {
      result = ctx.value_variable().result ;
    }
    
    ctx.result = (IntegerValue) result ;
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitWhile_condition(@NotNull AadlBaParser.While_conditionContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = _baFact.createWhileOrDoUntilStatement();
    setLocationReference(ctx.result, ctx.WHILE()); 
    ctx.result.setDoUntil(false);
    ctx.result.setLogicalValueExpression(ctx.value_expression().result);
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitInteger_value_constant(@NotNull AadlBaParser.Integer_value_constantContext ctx)
  {
    visitChildren(ctx) ;
    
    if(ctx.integer_literal() != null)
    {
      ctx.result = ctx.integer_literal().result ; 
    }
    else
    {
      ctx.result = ctx.property_reference().result ;
    }
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitTerm(@NotNull AadlBaParser.TermContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = _baFact.createTerm();
    
    Iterator<FactorContext> factIt = ctx.factor().iterator() ;
    Factor tmpFact = factIt.next().result ;
    ctx.result.getFactors().add(tmpFact) ;
    ctx.result.setLocationReference(tmpFact.getLocationReference());
    
    for(Multiplying_operatorContext mec : ctx.multiplying_operator())
    {
      ctx.result.getMultiplyingOperators().add(mec.result);
      tmpFact = factIt.next().result ;
      ctx.result.getFactors().add(tmpFact);
    }
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitForall_statement(@NotNull AadlBaParser.Forall_statementContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = ctx.forall_condition().result ;    
    ctx.result.setBehaviorActions(ctx.behavior_actions().result) ;
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitTarget(@NotNull AadlBaParser.TargetContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = ctx.reference().result ;
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitExecute_condition(@NotNull AadlBaParser.Execute_conditionContext ctx)
  {
    visitChildren(ctx) ;
    
    if(ctx.value_expression() != null)
    {
      ctx.result = ctx.value_expression().result ;
    }
    else if (ctx.TIMEOUT() != null)
    {
      ctx.result = _baFact.createExecutionTimeoutCatch();
      setLocationReference(ctx.result, ctx.TIMEOUT());
    }
    else
    {
      ctx.result = _baFact.createOtherwise() ;
      setLocationReference(ctx.result, ctx.OTHERWISE());
    }
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitBehavior_actions(@NotNull AadlBaParser.Behavior_actionsContext ctx)
  {
    visitChildren(ctx) ;
    
    BehaviorActions firstAction = ctx.behavior_action(0).result ;
    
    if(ctx.behavior_action().size() > 1)
    {
      BehaviorActionCollection tmp = null ;
      
      if(ctx.SEMICOLON().size() > 0)
      {
        tmp = _baFact.createBehaviorActionSequence() ;
      }
      else
      {
        tmp = _baFact.createBehaviorActionSet() ;
      }
      
      tmp.setLocationReference(firstAction.getLocationReference()) ;
      
      for(Behavior_actionContext bac : ctx.behavior_action())
      {
        tmp.getActions().add(bac.result) ;
      }
        
      ctx.result = tmp ;   
    }
    else
    {
      ctx.result = firstAction ;
    }
    
    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitBehavior_transition(@NotNull AadlBaParser.Behavior_transitionContext ctx)
  {
    visitChildren(ctx) ;
    
    Identifier id = null ;
    TerminalNode node = null ;

    ctx.result = _decl.createDeclarativeBehaviorTransition() ;

    int srcStatesIndex = 0 ;

    if(ctx.transId != null)
    {
      ctx.result.setName(ctx.transId.getText()) ;
      setLocationReference(ctx.result, ctx.transId) ;
      srcStatesIndex++ ;

      if(ctx.numeral() != null)
      {
        ctx.result.setPriority(ctx.numeral().result) ;
      }
    }

    if(ctx.result.getLocationReference() == null)
    {
      setLocationReference(ctx.result, ctx.IDENT(srcStatesIndex)) ;
    }

    while(srcStatesIndex < ctx.IDENT().size() - 1)
    {
      node = ctx.IDENT(srcStatesIndex) ;
      id = _decl.createIdentifier() ;
      id.setId(node.getText()) ;
      setLocationReference(id, node) ;
      ctx.result.getSrcStates().add(id) ;
      srcStatesIndex++ ;
    }

    // behavior condition can be null.
    if(ctx.behavior_condition() != null &&
          ctx.behavior_condition().result != null)
    {
      _ba.getConditions().add(ctx.behavior_condition().result) ;
      ctx.result.setCondition(ctx.behavior_condition().result) ;
    }

    id = _decl.createIdentifier() ;
    id.setId(ctx.destId.getText()) ;
    setLocationReference(id, ctx.destId) ;
    ctx.result.setDestState(id) ;

    if(ctx.behavior_action_block() != null)
    {
      _ba.getActions().add(ctx.behavior_action_block().result) ;
      ctx.result.setActionBlock(ctx.behavior_action_block().result) ;
    }
    
    return null ;
  }

  @Override
  public T visitElsif_statement(Elsif_statementContext ctx)
  {
    visitChildren(ctx) ;
    IfStatement elsifStat = _baFact.createIfStatement() ;
    ctx.result = elsifStat ;
    elsifStat.setElif(true);
    setLocationReference(elsifStat, ctx.ELSIF());
    elsifStat.setLogicalValueExpression(ctx.value_expression().result) ;
    elsifStat.setBehaviorActions(ctx.behavior_actions().result);
    return null ;
  }

  @Override
  public T visitReal_literal(Real_literalContext ctx)
  {
    String str = ctx.REAL_LIT().getText() ;
    DeclarativeRealLiteral tmp = _decl.createDeclarativeRealLiteral();
    str = str.replaceAll("_", "") ;
    tmp.setValue(str);
    setLocationReference(tmp, ctx.REAL_LIT());
    ctx.result = tmp ;
    return null ;
  }

  @Override
  public T visitIn_binding(In_bindingContext ctx)
  {
    visitChildren(ctx) ;
    ctx.ta.getProcessorClassifier().addAll(ctx.processor_parameter_list().result) ;
    return null ;
  }

  @Override
  public T visitProperty_reference(Property_referenceContext ctx)
  {
    visitChildren(ctx) ;
    
    DeclarativePropertyReference result = _decl.createDeclarativePropertyReference() ;
    
    if(ctx.h1 != null)
    {
      result.setPropertySet(true);
      
      if(ctx.IDENT() != null)
      {
        Identifier nameSpaceId = _decl.createIdentifier() ;
        nameSpaceId.setId(ctx.IDENT().getText()) ;
        setLocationReference(nameSpaceId, ctx.IDENT()) ;
        
        Identifier dummy = _decl.createIdentifier() ;
        dummy.setId("");
        
        QualifiedNamedElement qne = _decl.createQualifiedNamedElement() ;
        qne.setBaNamespace(nameSpaceId);
        qne.setBaName(dummy); // Dummy. Do not use !
        qne.setLocationReference(nameSpaceId.getLocationReference());
        
        result.setQualifiedName(qne);
      }
    }
    else
    {
      if(ctx.reference() != null)
      {
        result.setReference(ctx.reference().result);
        result.setLocationReference(ctx.reference().result.getLocationReference());
      }
      else
      {
        result.setQualifiedName(ctx.qualified_named_element().result) ;
        result.setLocationReference(ctx.qualified_named_element().result.getLocationReference());
      }
    }
    
    for(Property_nameContext pnc : ctx.property_name())
    {
      result.getPropertyNames().add(pnc.result) ;
    }
    
    ctx.result = result ;
    
    return null ;
  }

  @Override
  public T visitValue_constant(Value_constantContext ctx)
  {
    visitChildren(ctx) ;
    
    if(ctx.numeric_literal() != null)
    {
      ctx.result = ctx.numeric_literal().result ;
    }
    else if(ctx.string_literal() != null)
    {
      ctx.result = ctx.string_literal().result ; 
    }
    else if(ctx.boolean_literal() != null)
    {
      ctx.result = ctx.boolean_literal().result ;
    }
    else
    {
      ctx.result = ctx.property_reference().result ;
    }
    
    return null ;
  }

  @Override
  public T visitProperty_name(Property_nameContext ctx)
  {
    visitChildren(ctx) ;
    
    DeclarativePropertyName result = _decl.createDeclarativePropertyName() ;
    setLocationReference(result, ctx.IDENT());
    
    Identifier propertyName = _decl.createIdentifier() ;
    setLocationReference(propertyName, ctx.IDENT());
    propertyName.setId(ctx.IDENT().getText());
    result.setPropertyName(propertyName);
    
    if(ctx.UPPER_BOUND() != null)
    {
      UpperBound upField = _baFact.createUpperBound() ;
      setLocationReference(upField, ctx.UPPER_BOUND()) ;
      result.setField(upField) ;
    }
    else if(ctx.LOWER_BOUND() != null)
    {
      LowerBound lowerField = _baFact.createLowerBound() ;
      setLocationReference(lowerField, ctx.LOWER_BOUND()) ;
      result.setField(lowerField) ;
    }
    else if(false == ctx.integer_value().isEmpty())
    {
      for(Integer_valueContext ivc : ctx.integer_value())
      {
        result.getIndexes().add(ivc.result) ;
      }
    }
    
    ctx.result = result ;
    
    return null ;
  }

  @Override
  public T visitMode_switch_trigger_conjunction(@NotNull AadlBaParser.Mode_switch_trigger_conjunctionContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = _baFact.createModeSwitchConjunction();
    
    ctx.result.setLocationReference(ctx.reference(0).result
                                    .getLocationReference()) ;

    for(ReferenceContext rc : ctx.reference())
    {
      ctx.result.getModeSwitchTriggers().add(rc.result) ;
    }

    return null ;
  }

  @Override
  public T visitMode_switch_trigger_logical_expression(@NotNull AadlBaParser.Mode_switch_trigger_logical_expressionContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = _baFact.createModeSwitchTriggerLogicalExpression() ;

    ctx.result.setLocationReference(ctx.mode_switch_trigger_conjunction(0).result
          .getLocationReference()) ;

    for(Mode_switch_trigger_conjunctionContext dcc : ctx.mode_switch_trigger_conjunction())
    {
      ctx.result.getModeSwitchConjunctions().add(dcc.result) ;
    }

    return null ;
  }

  /**
   * {@inheritDoc}
   * <p/>
   * The default implementation returns the result of calling
   * {@link #visitChildren} on {@code ctx}.
   */
  @Override
  public T visitValue_constant_or_variable(
                                           Value_constant_or_variableContext ctx)
  {
    visitChildren(ctx) ;
    
    if(ctx.value_constant() != null)
    {
      ctx.result = ctx.value_constant().result ;
    }
    else if(ctx.value_variable() != null)
    {
      ctx.result = ctx.value_variable().result ;
    }
    else
    {
      ctx.result = ctx.value_expression().result ;
    }

    return null ;
  }

  @Override
  public T visitData_classifier_property_association(
                                                     Data_classifier_property_associationContext ctx)
  {
    visitChildren(ctx) ;
    ctx.result = _decl.createDeclarativePropertyAssociation();
    ctx.result.setProperty(ctx.property_ref().result);
    ctx.result.setOwnedValue(ctx.property_value().result);
    return null ;
  }

  @Override
  public T visitQualifiable_property(Qualifiable_propertyContext ctx)
  {
    visitChildren(ctx) ;
    
    ctx.result = _decl.createQualifiedNamedElement();
    
    Identifier nameId = _decl.createIdentifier() ;
    nameId.setId(ctx.id2) ;
    setLocationReference(nameId, ctx.identifier2) ;
    ctx.result.setBaName(nameId) ;

    if(!ctx.id1.equals(""))
    {
      Identifier nameSpaceId = _decl.createIdentifier() ;
      nameSpaceId.setId(ctx.id1) ;
      setLocationReference(nameSpaceId, ctx.identifier1) ;
      ctx.result.setBaNamespace(nameSpaceId) ;
      setLocationReference(ctx.result, ctx.identifier1) ;
    }
    else
    {
      setLocationReference(ctx.result, ctx.identifier2) ;
    }

    return null ;
  }

  @Override
  public T visitProperty_ref(Property_refContext ctx)
  {
    visitChildren(ctx) ;
    ctx.result = ctx.qualifiable_property().result;
    return null ;
  }

  @Override
  public T visitProperty_value(Property_valueContext ctx)
  {
    visitChildren(ctx) ;
    
    if(ctx.list_property_value() != null)
    {
      ctx.result = (DeclarativePropertyExpression) ctx.list_property_value().result;
    }
    else if(ctx.string_literal()!=null)
    {
      ctx.result = (DeclarativePropertyExpression) ctx.string_literal().result;
    }
    else if(ctx.integer_property_value()!=null)
    {
      ctx.result = (DeclarativePropertyExpression) ctx.integer_property_value().result;
    }
    else if(ctx.real_property_value()!=null)
    {
      ctx.result = (DeclarativePropertyExpression) ctx.real_property_value().result;
    }
    else if(ctx.record_property_value()!=null)
    {
      ctx.result = (DeclarativePropertyExpression) ctx.record_property_value().result;
    }
    else if(ctx.boolean_property_value()!=null)
    {
      ctx.result = (DeclarativePropertyExpression) ctx.boolean_property_value().result;
    }
    else if(ctx.numeric_range_property_value()!=null)
    {
      ctx.result = (DeclarativePropertyExpression) ctx.numeric_range_property_value().result;
    }
    else if(ctx.reference_property_value()!=null)
    {
      ctx.result = (DeclarativePropertyExpression) ctx.reference_property_value().result;
    }
    else if (ctx.classifier_property_value()!=null)
    {
      ctx.result = (DeclarativePropertyExpression) ctx.classifier_property_value().result; 
    }
    return null ;
  }
  
  @Override
  public T visitList_property_value(List_property_valueContext ctx)
  {
    visitChildren(ctx) ;
    ctx.result = _decl.createDeclarativeListValue();
    
    for(Property_valueContext pvc: ctx.property_value())
    {
      ctx.result.getOwnedListElements().add(pvc.result);
    }
    return null ;
  }

  @Override
  public T visitUnit_reference(Unit_referenceContext ctx)
  {
    visitChildren(ctx) ;
    ctx.result = ctx.qualifiable_property().result;
    return null ;
  }

  @Override
  public T visitSigned_int(Signed_intContext ctx)
  {
    visitChildren(ctx) ;
    ctx.result = Integer.parseInt(ctx.getText());
    return null ;
  }

  @Override
  public T visitInteger_property_value(Integer_property_valueContext ctx)
  {
    visitChildren(ctx) ;
    ctx.result = _decl.createDeclarativeIntegerLiteral() ;
    ctx.result.setValue(ctx.signed_int().result);
    if(ctx.unit_reference()!=null)
      ctx.result.setUnit(ctx.unit_reference().result);
    return null ;
  }

  @Override
  public T visitReal_property_value(Real_property_valueContext ctx)
  {
    visitChildren(ctx) ;
    ctx.result = _decl.createDeclarativeRealLiteral() ;
    ctx.result.setValue(ctx.signed_real().result);
    if(ctx.unit_reference()!=null)
      ctx.result.setUnit(ctx.unit_reference().result);
    return null ;
  }

  @Override
  public T visitSigned_real(Signed_realContext ctx)
  {
    visitChildren(ctx) ;
    ctx.result = Double.parseDouble(ctx.getText());
    return null ;
  }

  @Override
  public T visitRecord_property_value(Record_property_valueContext ctx)
  {
    visitChildren(ctx) ;
    ctx.result = _decl.createDeclarativeRecordValue();
    for(Field_property_associationContext assignCtx: ctx.field_assign)
    {
      ctx.result.getOwnedFieldValues().add(assignCtx.result);      
    }
    return null ;
  }

  @Override
  public T visitField_property_association(
                                           Field_property_associationContext ctx)
  {
    visitChildren(ctx) ;
    ctx.result = _decl.createDeclarativeBasicPropertyAssociation();
    ctx.result.setBasicPropertyName(ctx.property.getText());
    ctx.result.setOwnedValue(ctx.property_value().result);
    return null ;
  }

  @Override
  public T visitBoolean_property_value(Boolean_property_valueContext ctx)
  {
    visitChildren(ctx) ;
    ctx.result = _decl.createDeclarativeBooleanLiteral();
    if(ctx.getText().equalsIgnoreCase("true"))
      ctx.result.setValue(true);
    else
      ctx.result.setValue(false);
    return null ;
  }

  @Override
  public T visitNumeric_range_property_value(
                                             Numeric_range_property_valueContext ctx)
  {
    visitChildren(ctx) ;
    ctx.result = _decl.createDeclarativeRangeValue();
    ctx.result.setMinimum(ctx.lower_bound.result);
    ctx.result.setMaximum(ctx.upper_bound.result);
    return null ;
  }

  @Override
  public T visitNumeric_property_value(Numeric_property_valueContext ctx)
  {
    visitChildren(ctx) ;
    if(ctx.real_property_value()!=null)
      ctx.result = (DeclarativePropertyExpression) ctx.real_property_value().result;
    else if(ctx.integer_property_value()!=null)
      ctx.result = (DeclarativePropertyExpression) ctx.integer_property_value().result;
    return null ;
  }

  @Override
  public T visitReference_property_value(Reference_property_valueContext ctx)
  {
    visitChildren(ctx) ;
    ctx.result =  _decl.createDeclarativeReferenceValue();
    ctx.result.setRef(ctx.reference().result);
    return null ;
  }

  @Override
  public T visitClassifier_property_value(Classifier_property_valueContext ctx)
  {
    visitChildren(ctx) ;
    ctx.result = _decl.createDeclarativeClassifierValue();
    ctx.result.setClassifier(ctx.unique_component_classifier_reference().result);
    return null ;
  }
}