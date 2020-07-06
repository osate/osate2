// Generated from AadlBa.g by ANTLR 4.4
 
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
  
  package org.osate.ba.parser;
  
  import org.eclipse.emf.common.util.BasicEList ;

  import org.eclipse.emf.common.util.EList;

  import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;  
  
  import org.osate.aadl2.parsesupport.AObject;
  import org.osate.aadl2.parsesupport.LocationReference;
  
  import org.osate.annexsupport.AnnexHighlighterPositionAcceptor ;
  
  import org.osate.ba.aadlba.*;
  import org.osate.ba.declarative.* ;
  import org.osate.ba.analyzers.DeclarativeUtils ;
  
  import org.osate.ba.utils.AadlBaLocationReference ;
  
  import org.osate.aadl2.* ;
  import org.osate.aadl2.parsesupport.ParseUtil ;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AadlBaParser}.
 */
public interface AadlBaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#behavior_annex}.
	 * @param ctx the parse tree
	 */
	void enterBehavior_annex(@NotNull AadlBaParser.Behavior_annexContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#behavior_annex}.
	 * @param ctx the parse tree
	 */
	void exitBehavior_annex(@NotNull AadlBaParser.Behavior_annexContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#behavior_variable}.
	 * @param ctx the parse tree
	 */
	void enterBehavior_variable(@NotNull AadlBaParser.Behavior_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#behavior_variable}.
	 * @param ctx the parse tree
	 */
	void exitBehavior_variable(@NotNull AadlBaParser.Behavior_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#record_property_value}.
	 * @param ctx the parse tree
	 */
	void enterRecord_property_value(@NotNull AadlBaParser.Record_property_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#record_property_value}.
	 * @param ctx the parse tree
	 */
	void exitRecord_property_value(@NotNull AadlBaParser.Record_property_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#dispatch_conjunction}.
	 * @param ctx the parse tree
	 */
	void enterDispatch_conjunction(@NotNull AadlBaParser.Dispatch_conjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#dispatch_conjunction}.
	 * @param ctx the parse tree
	 */
	void exitDispatch_conjunction(@NotNull AadlBaParser.Dispatch_conjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#real_property_value}.
	 * @param ctx the parse tree
	 */
	void enterReal_property_value(@NotNull AadlBaParser.Real_property_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#real_property_value}.
	 * @param ctx the parse tree
	 */
	void exitReal_property_value(@NotNull AadlBaParser.Real_property_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#integer_literal}.
	 * @param ctx the parse tree
	 */
	void enterInteger_literal(@NotNull AadlBaParser.Integer_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#integer_literal}.
	 * @param ctx the parse tree
	 */
	void exitInteger_literal(@NotNull AadlBaParser.Integer_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#assignment_action}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_action(@NotNull AadlBaParser.Assignment_actionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#assignment_action}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_action(@NotNull AadlBaParser.Assignment_actionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#property_value}.
	 * @param ctx the parse tree
	 */
	void enterProperty_value(@NotNull AadlBaParser.Property_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#property_value}.
	 * @param ctx the parse tree
	 */
	void exitProperty_value(@NotNull AadlBaParser.Property_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#elsif_statement}.
	 * @param ctx the parse tree
	 */
	void enterElsif_statement(@NotNull AadlBaParser.Elsif_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#elsif_statement}.
	 * @param ctx the parse tree
	 */
	void exitElsif_statement(@NotNull AadlBaParser.Elsif_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#basic_action}.
	 * @param ctx the parse tree
	 */
	void enterBasic_action(@NotNull AadlBaParser.Basic_actionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#basic_action}.
	 * @param ctx the parse tree
	 */
	void exitBasic_action(@NotNull AadlBaParser.Basic_actionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#simple_expression}.
	 * @param ctx the parse tree
	 */
	void enterSimple_expression(@NotNull AadlBaParser.Simple_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#simple_expression}.
	 * @param ctx the parse tree
	 */
	void exitSimple_expression(@NotNull AadlBaParser.Simple_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#dispatch_condition}.
	 * @param ctx the parse tree
	 */
	void enterDispatch_condition(@NotNull AadlBaParser.Dispatch_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#dispatch_condition}.
	 * @param ctx the parse tree
	 */
	void exitDispatch_condition(@NotNull AadlBaParser.Dispatch_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#array_identifier}.
	 * @param ctx the parse tree
	 */
	void enterArray_identifier(@NotNull AadlBaParser.Array_identifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#array_identifier}.
	 * @param ctx the parse tree
	 */
	void exitArray_identifier(@NotNull AadlBaParser.Array_identifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelation(@NotNull AadlBaParser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelation(@NotNull AadlBaParser.RelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#property_name}.
	 * @param ctx the parse tree
	 */
	void enterProperty_name(@NotNull AadlBaParser.Property_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#property_name}.
	 * @param ctx the parse tree
	 */
	void exitProperty_name(@NotNull AadlBaParser.Property_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(@NotNull AadlBaParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(@NotNull AadlBaParser.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#execute_condition}.
	 * @param ctx the parse tree
	 */
	void enterExecute_condition(@NotNull AadlBaParser.Execute_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#execute_condition}.
	 * @param ctx the parse tree
	 */
	void exitExecute_condition(@NotNull AadlBaParser.Execute_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#string_property_value}.
	 * @param ctx the parse tree
	 */
	void enterString_property_value(@NotNull AadlBaParser.String_property_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#string_property_value}.
	 * @param ctx the parse tree
	 */
	void exitString_property_value(@NotNull AadlBaParser.String_property_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#mode_switch_trigger_conjunction}.
	 * @param ctx the parse tree
	 */
	void enterMode_switch_trigger_conjunction(@NotNull AadlBaParser.Mode_switch_trigger_conjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#mode_switch_trigger_conjunction}.
	 * @param ctx the parse tree
	 */
	void exitMode_switch_trigger_conjunction(@NotNull AadlBaParser.Mode_switch_trigger_conjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#classifier_property_value}.
	 * @param ctx the parse tree
	 */
	void enterClassifier_property_value(@NotNull AadlBaParser.Classifier_property_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#classifier_property_value}.
	 * @param ctx the parse tree
	 */
	void exitClassifier_property_value(@NotNull AadlBaParser.Classifier_property_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#unit_reference}.
	 * @param ctx the parse tree
	 */
	void enterUnit_reference(@NotNull AadlBaParser.Unit_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#unit_reference}.
	 * @param ctx the parse tree
	 */
	void exitUnit_reference(@NotNull AadlBaParser.Unit_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#logical_operator}.
	 * @param ctx the parse tree
	 */
	void enterLogical_operator(@NotNull AadlBaParser.Logical_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#logical_operator}.
	 * @param ctx the parse tree
	 */
	void exitLogical_operator(@NotNull AadlBaParser.Logical_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#timed_action}.
	 * @param ctx the parse tree
	 */
	void enterTimed_action(@NotNull AadlBaParser.Timed_actionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#timed_action}.
	 * @param ctx the parse tree
	 */
	void exitTimed_action(@NotNull AadlBaParser.Timed_actionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#action_block}.
	 * @param ctx the parse tree
	 */
	void enterAction_block(@NotNull AadlBaParser.Action_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#action_block}.
	 * @param ctx the parse tree
	 */
	void exitAction_block(@NotNull AadlBaParser.Action_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement(@NotNull AadlBaParser.While_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement(@NotNull AadlBaParser.While_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#numeric_range_property_value}.
	 * @param ctx the parse tree
	 */
	void enterNumeric_range_property_value(@NotNull AadlBaParser.Numeric_range_property_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#numeric_range_property_value}.
	 * @param ctx the parse tree
	 */
	void exitNumeric_range_property_value(@NotNull AadlBaParser.Numeric_range_property_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#numeric_literal}.
	 * @param ctx the parse tree
	 */
	void enterNumeric_literal(@NotNull AadlBaParser.Numeric_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#numeric_literal}.
	 * @param ctx the parse tree
	 */
	void exitNumeric_literal(@NotNull AadlBaParser.Numeric_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#property_reference}.
	 * @param ctx the parse tree
	 */
	void enterProperty_reference(@NotNull AadlBaParser.Property_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#property_reference}.
	 * @param ctx the parse tree
	 */
	void exitProperty_reference(@NotNull AadlBaParser.Property_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#processor_parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterProcessor_parameter_list(@NotNull AadlBaParser.Processor_parameter_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#processor_parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitProcessor_parameter_list(@NotNull AadlBaParser.Processor_parameter_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#communication_action}.
	 * @param ctx the parse tree
	 */
	void enterCommunication_action(@NotNull AadlBaParser.Communication_actionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#communication_action}.
	 * @param ctx the parse tree
	 */
	void exitCommunication_action(@NotNull AadlBaParser.Communication_actionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#unary_boolean_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_boolean_operator(@NotNull AadlBaParser.Unary_boolean_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#unary_boolean_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_boolean_operator(@NotNull AadlBaParser.Unary_boolean_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#binary_numeric_operator}.
	 * @param ctx the parse tree
	 */
	void enterBinary_numeric_operator(@NotNull AadlBaParser.Binary_numeric_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#binary_numeric_operator}.
	 * @param ctx the parse tree
	 */
	void exitBinary_numeric_operator(@NotNull AadlBaParser.Binary_numeric_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#field_property_association}.
	 * @param ctx the parse tree
	 */
	void enterField_property_association(@NotNull AadlBaParser.Field_property_associationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#field_property_association}.
	 * @param ctx the parse tree
	 */
	void exitField_property_association(@NotNull AadlBaParser.Field_property_associationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#value_constant_or_variable}.
	 * @param ctx the parse tree
	 */
	void enterValue_constant_or_variable(@NotNull AadlBaParser.Value_constant_or_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#value_constant_or_variable}.
	 * @param ctx the parse tree
	 */
	void exitValue_constant_or_variable(@NotNull AadlBaParser.Value_constant_or_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#relational_operator}.
	 * @param ctx the parse tree
	 */
	void enterRelational_operator(@NotNull AadlBaParser.Relational_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#relational_operator}.
	 * @param ctx the parse tree
	 */
	void exitRelational_operator(@NotNull AadlBaParser.Relational_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#value_variable}.
	 * @param ctx the parse tree
	 */
	void enterValue_variable(@NotNull AadlBaParser.Value_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#value_variable}.
	 * @param ctx the parse tree
	 */
	void exitValue_variable(@NotNull AadlBaParser.Value_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#qualified_named_element}.
	 * @param ctx the parse tree
	 */
	void enterQualified_named_element(@NotNull AadlBaParser.Qualified_named_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#qualified_named_element}.
	 * @param ctx the parse tree
	 */
	void exitQualified_named_element(@NotNull AadlBaParser.Qualified_named_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#behavior_time}.
	 * @param ctx the parse tree
	 */
	void enterBehavior_time(@NotNull AadlBaParser.Behavior_timeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#behavior_time}.
	 * @param ctx the parse tree
	 */
	void exitBehavior_time(@NotNull AadlBaParser.Behavior_timeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#qualifiable_property}.
	 * @param ctx the parse tree
	 */
	void enterQualifiable_property(@NotNull AadlBaParser.Qualifiable_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#qualifiable_property}.
	 * @param ctx the parse tree
	 */
	void exitQualifiable_property(@NotNull AadlBaParser.Qualifiable_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#forall_statement}.
	 * @param ctx the parse tree
	 */
	void enterForall_statement(@NotNull AadlBaParser.Forall_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#forall_statement}.
	 * @param ctx the parse tree
	 */
	void exitForall_statement(@NotNull AadlBaParser.Forall_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(@NotNull AadlBaParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(@NotNull AadlBaParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#element_values}.
	 * @param ctx the parse tree
	 */
	void enterElement_values(@NotNull AadlBaParser.Element_valuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#element_values}.
	 * @param ctx the parse tree
	 */
	void exitElement_values(@NotNull AadlBaParser.Element_valuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#data_classifier_property_association}.
	 * @param ctx the parse tree
	 */
	void enterData_classifier_property_association(@NotNull AadlBaParser.Data_classifier_property_associationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#data_classifier_property_association}.
	 * @param ctx the parse tree
	 */
	void exitData_classifier_property_association(@NotNull AadlBaParser.Data_classifier_property_associationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#dountil_statement}.
	 * @param ctx the parse tree
	 */
	void enterDountil_statement(@NotNull AadlBaParser.Dountil_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#dountil_statement}.
	 * @param ctx the parse tree
	 */
	void exitDountil_statement(@NotNull AadlBaParser.Dountil_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#integer_value_constant}.
	 * @param ctx the parse tree
	 */
	void enterInteger_value_constant(@NotNull AadlBaParser.Integer_value_constantContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#integer_value_constant}.
	 * @param ctx the parse tree
	 */
	void exitInteger_value_constant(@NotNull AadlBaParser.Integer_value_constantContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#behavior_state_list}.
	 * @param ctx the parse tree
	 */
	void enterBehavior_state_list(@NotNull AadlBaParser.Behavior_state_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#behavior_state_list}.
	 * @param ctx the parse tree
	 */
	void exitBehavior_state_list(@NotNull AadlBaParser.Behavior_state_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#mode_switch_trigger_logical_expression}.
	 * @param ctx the parse tree
	 */
	void enterMode_switch_trigger_logical_expression(@NotNull AadlBaParser.Mode_switch_trigger_logical_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#mode_switch_trigger_logical_expression}.
	 * @param ctx the parse tree
	 */
	void exitMode_switch_trigger_logical_expression(@NotNull AadlBaParser.Mode_switch_trigger_logical_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#in_binding}.
	 * @param ctx the parse tree
	 */
	void enterIn_binding(@NotNull AadlBaParser.In_bindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#in_binding}.
	 * @param ctx the parse tree
	 */
	void exitIn_binding(@NotNull AadlBaParser.In_bindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_literal(@NotNull AadlBaParser.Boolean_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_literal(@NotNull AadlBaParser.Boolean_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#behavior_transition}.
	 * @param ctx the parse tree
	 */
	void enterBehavior_transition(@NotNull AadlBaParser.Behavior_transitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#behavior_transition}.
	 * @param ctx the parse tree
	 */
	void exitBehavior_transition(@NotNull AadlBaParser.Behavior_transitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#signed_int}.
	 * @param ctx the parse tree
	 */
	void enterSigned_int(@NotNull AadlBaParser.Signed_intContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#signed_int}.
	 * @param ctx the parse tree
	 */
	void exitSigned_int(@NotNull AadlBaParser.Signed_intContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#property_ref}.
	 * @param ctx the parse tree
	 */
	void enterProperty_ref(@NotNull AadlBaParser.Property_refContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#property_ref}.
	 * @param ctx the parse tree
	 */
	void exitProperty_ref(@NotNull AadlBaParser.Property_refContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#forall_condition}.
	 * @param ctx the parse tree
	 */
	void enterForall_condition(@NotNull AadlBaParser.Forall_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#forall_condition}.
	 * @param ctx the parse tree
	 */
	void exitForall_condition(@NotNull AadlBaParser.Forall_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#for_condition}.
	 * @param ctx the parse tree
	 */
	void enterFor_condition(@NotNull AadlBaParser.For_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#for_condition}.
	 * @param ctx the parse tree
	 */
	void exitFor_condition(@NotNull AadlBaParser.For_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(@NotNull AadlBaParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(@NotNull AadlBaParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#numeral}.
	 * @param ctx the parse tree
	 */
	void enterNumeral(@NotNull AadlBaParser.NumeralContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#numeral}.
	 * @param ctx the parse tree
	 */
	void exitNumeral(@NotNull AadlBaParser.NumeralContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#boolean_property_value}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_property_value(@NotNull AadlBaParser.Boolean_property_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#boolean_property_value}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_property_value(@NotNull AadlBaParser.Boolean_property_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(@NotNull AadlBaParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(@NotNull AadlBaParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#unary_numeric_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_numeric_operator(@NotNull AadlBaParser.Unary_numeric_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#unary_numeric_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_numeric_operator(@NotNull AadlBaParser.Unary_numeric_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#list_property_value}.
	 * @param ctx the parse tree
	 */
	void enterList_property_value(@NotNull AadlBaParser.List_property_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#list_property_value}.
	 * @param ctx the parse tree
	 */
	void exitList_property_value(@NotNull AadlBaParser.List_property_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#binary_adding_operator}.
	 * @param ctx the parse tree
	 */
	void enterBinary_adding_operator(@NotNull AadlBaParser.Binary_adding_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#binary_adding_operator}.
	 * @param ctx the parse tree
	 */
	void exitBinary_adding_operator(@NotNull AadlBaParser.Binary_adding_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#multiplying_operator}.
	 * @param ctx the parse tree
	 */
	void enterMultiplying_operator(@NotNull AadlBaParser.Multiplying_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#multiplying_operator}.
	 * @param ctx the parse tree
	 */
	void exitMultiplying_operator(@NotNull AadlBaParser.Multiplying_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#integer_range}.
	 * @param ctx the parse tree
	 */
	void enterInteger_range(@NotNull AadlBaParser.Integer_rangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#integer_range}.
	 * @param ctx the parse tree
	 */
	void exitInteger_range(@NotNull AadlBaParser.Integer_rangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#while_condition}.
	 * @param ctx the parse tree
	 */
	void enterWhile_condition(@NotNull AadlBaParser.While_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#while_condition}.
	 * @param ctx the parse tree
	 */
	void exitWhile_condition(@NotNull AadlBaParser.While_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#value_expression}.
	 * @param ctx the parse tree
	 */
	void enterValue_expression(@NotNull AadlBaParser.Value_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#value_expression}.
	 * @param ctx the parse tree
	 */
	void exitValue_expression(@NotNull AadlBaParser.Value_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#behavior_action}.
	 * @param ctx the parse tree
	 */
	void enterBehavior_action(@NotNull AadlBaParser.Behavior_actionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#behavior_action}.
	 * @param ctx the parse tree
	 */
	void exitBehavior_action(@NotNull AadlBaParser.Behavior_actionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#unary_adding_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_adding_operator(@NotNull AadlBaParser.Unary_adding_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#unary_adding_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_adding_operator(@NotNull AadlBaParser.Unary_adding_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#reference_property_value}.
	 * @param ctx the parse tree
	 */
	void enterReference_property_value(@NotNull AadlBaParser.Reference_property_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#reference_property_value}.
	 * @param ctx the parse tree
	 */
	void exitReference_property_value(@NotNull AadlBaParser.Reference_property_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#behavior_actions}.
	 * @param ctx the parse tree
	 */
	void enterBehavior_actions(@NotNull AadlBaParser.Behavior_actionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#behavior_actions}.
	 * @param ctx the parse tree
	 */
	void exitBehavior_actions(@NotNull AadlBaParser.Behavior_actionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#integer_property_value}.
	 * @param ctx the parse tree
	 */
	void enterInteger_property_value(@NotNull AadlBaParser.Integer_property_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#integer_property_value}.
	 * @param ctx the parse tree
	 */
	void exitInteger_property_value(@NotNull AadlBaParser.Integer_property_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#subprogram_parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterSubprogram_parameter_list(@NotNull AadlBaParser.Subprogram_parameter_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#subprogram_parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitSubprogram_parameter_list(@NotNull AadlBaParser.Subprogram_parameter_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#value_constant}.
	 * @param ctx the parse tree
	 */
	void enterValue_constant(@NotNull AadlBaParser.Value_constantContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#value_constant}.
	 * @param ctx the parse tree
	 */
	void exitValue_constant(@NotNull AadlBaParser.Value_constantContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#integer_value}.
	 * @param ctx the parse tree
	 */
	void enterInteger_value(@NotNull AadlBaParser.Integer_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#integer_value}.
	 * @param ctx the parse tree
	 */
	void exitInteger_value(@NotNull AadlBaParser.Integer_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#behavior_variable_list}.
	 * @param ctx the parse tree
	 */
	void enterBehavior_variable_list(@NotNull AadlBaParser.Behavior_variable_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#behavior_variable_list}.
	 * @param ctx the parse tree
	 */
	void exitBehavior_variable_list(@NotNull AadlBaParser.Behavior_variable_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#behavior_condition}.
	 * @param ctx the parse tree
	 */
	void enterBehavior_condition(@NotNull AadlBaParser.Behavior_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#behavior_condition}.
	 * @param ctx the parse tree
	 */
	void exitBehavior_condition(@NotNull AadlBaParser.Behavior_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#signed_real}.
	 * @param ctx the parse tree
	 */
	void enterSigned_real(@NotNull AadlBaParser.Signed_realContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#signed_real}.
	 * @param ctx the parse tree
	 */
	void exitSigned_real(@NotNull AadlBaParser.Signed_realContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#target}.
	 * @param ctx the parse tree
	 */
	void enterTarget(@NotNull AadlBaParser.TargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#target}.
	 * @param ctx the parse tree
	 */
	void exitTarget(@NotNull AadlBaParser.TargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#unique_component_classifier_reference}.
	 * @param ctx the parse tree
	 */
	void enterUnique_component_classifier_reference(@NotNull AadlBaParser.Unique_component_classifier_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#unique_component_classifier_reference}.
	 * @param ctx the parse tree
	 */
	void exitUnique_component_classifier_reference(@NotNull AadlBaParser.Unique_component_classifier_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void enterString_literal(@NotNull AadlBaParser.String_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void exitString_literal(@NotNull AadlBaParser.String_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#dispatch_trigger_condition}.
	 * @param ctx the parse tree
	 */
	void enterDispatch_trigger_condition(@NotNull AadlBaParser.Dispatch_trigger_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#dispatch_trigger_condition}.
	 * @param ctx the parse tree
	 */
	void exitDispatch_trigger_condition(@NotNull AadlBaParser.Dispatch_trigger_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_statement(@NotNull AadlBaParser.For_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_statement(@NotNull AadlBaParser.For_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#real_literal}.
	 * @param ctx the parse tree
	 */
	void enterReal_literal(@NotNull AadlBaParser.Real_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#real_literal}.
	 * @param ctx the parse tree
	 */
	void exitReal_literal(@NotNull AadlBaParser.Real_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#dispatch_trigger_logical_expression}.
	 * @param ctx the parse tree
	 */
	void enterDispatch_trigger_logical_expression(@NotNull AadlBaParser.Dispatch_trigger_logical_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#dispatch_trigger_logical_expression}.
	 * @param ctx the parse tree
	 */
	void exitDispatch_trigger_logical_expression(@NotNull AadlBaParser.Dispatch_trigger_logical_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#numeric_property_value}.
	 * @param ctx the parse tree
	 */
	void enterNumeric_property_value(@NotNull AadlBaParser.Numeric_property_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#numeric_property_value}.
	 * @param ctx the parse tree
	 */
	void exitNumeric_property_value(@NotNull AadlBaParser.Numeric_property_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#behavior_action_block}.
	 * @param ctx the parse tree
	 */
	void enterBehavior_action_block(@NotNull AadlBaParser.Behavior_action_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#behavior_action_block}.
	 * @param ctx the parse tree
	 */
	void exitBehavior_action_block(@NotNull AadlBaParser.Behavior_action_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#parameter_label}.
	 * @param ctx the parse tree
	 */
	void enterParameter_label(@NotNull AadlBaParser.Parameter_labelContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#parameter_label}.
	 * @param ctx the parse tree
	 */
	void exitParameter_label(@NotNull AadlBaParser.Parameter_labelContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlBaParser#qualifiable_named_element}.
	 * @param ctx the parse tree
	 */
	void enterQualifiable_named_element(@NotNull AadlBaParser.Qualifiable_named_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlBaParser#qualifiable_named_element}.
	 * @param ctx the parse tree
	 */
	void exitQualifiable_named_element(@NotNull AadlBaParser.Qualifiable_named_elementContext ctx);
}