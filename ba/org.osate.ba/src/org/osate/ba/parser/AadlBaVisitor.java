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
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AadlBaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AadlBaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#behavior_annex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehavior_annex(@NotNull AadlBaParser.Behavior_annexContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#behavior_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehavior_variable(@NotNull AadlBaParser.Behavior_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#record_property_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecord_property_value(@NotNull AadlBaParser.Record_property_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#dispatch_conjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDispatch_conjunction(@NotNull AadlBaParser.Dispatch_conjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#real_property_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal_property_value(@NotNull AadlBaParser.Real_property_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#integer_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger_literal(@NotNull AadlBaParser.Integer_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#assignment_action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_action(@NotNull AadlBaParser.Assignment_actionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#property_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty_value(@NotNull AadlBaParser.Property_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#elsif_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsif_statement(@NotNull AadlBaParser.Elsif_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#basic_action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasic_action(@NotNull AadlBaParser.Basic_actionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#simple_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_expression(@NotNull AadlBaParser.Simple_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#dispatch_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDispatch_condition(@NotNull AadlBaParser.Dispatch_conditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#array_identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_identifier(@NotNull AadlBaParser.Array_identifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation(@NotNull AadlBaParser.RelationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#property_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty_name(@NotNull AadlBaParser.Property_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(@NotNull AadlBaParser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#execute_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecute_condition(@NotNull AadlBaParser.Execute_conditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#mode_switch_trigger_conjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMode_switch_trigger_conjunction(@NotNull AadlBaParser.Mode_switch_trigger_conjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#classifier_property_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassifier_property_value(@NotNull AadlBaParser.Classifier_property_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#unit_reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnit_reference(@NotNull AadlBaParser.Unit_referenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#logical_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_operator(@NotNull AadlBaParser.Logical_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#timed_action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimed_action(@NotNull AadlBaParser.Timed_actionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#action_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction_block(@NotNull AadlBaParser.Action_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#while_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_statement(@NotNull AadlBaParser.While_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#numeric_range_property_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric_range_property_value(@NotNull AadlBaParser.Numeric_range_property_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#numeric_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric_literal(@NotNull AadlBaParser.Numeric_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#property_reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty_reference(@NotNull AadlBaParser.Property_referenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#processor_parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcessor_parameter_list(@NotNull AadlBaParser.Processor_parameter_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#communication_action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommunication_action(@NotNull AadlBaParser.Communication_actionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#unary_boolean_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_boolean_operator(@NotNull AadlBaParser.Unary_boolean_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#binary_numeric_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary_numeric_operator(@NotNull AadlBaParser.Binary_numeric_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#field_property_association}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField_property_association(@NotNull AadlBaParser.Field_property_associationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#value_constant_or_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_constant_or_variable(@NotNull AadlBaParser.Value_constant_or_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#relational_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational_operator(@NotNull AadlBaParser.Relational_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#value_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_variable(@NotNull AadlBaParser.Value_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#qualified_named_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualified_named_element(@NotNull AadlBaParser.Qualified_named_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#behavior_time}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehavior_time(@NotNull AadlBaParser.Behavior_timeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#qualifiable_property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiable_property(@NotNull AadlBaParser.Qualifiable_propertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#forall_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForall_statement(@NotNull AadlBaParser.Forall_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(@NotNull AadlBaParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#element_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement_values(@NotNull AadlBaParser.Element_valuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#data_classifier_property_association}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_classifier_property_association(@NotNull AadlBaParser.Data_classifier_property_associationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#dountil_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDountil_statement(@NotNull AadlBaParser.Dountil_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#integer_value_constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger_value_constant(@NotNull AadlBaParser.Integer_value_constantContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#behavior_state_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehavior_state_list(@NotNull AadlBaParser.Behavior_state_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#mode_switch_trigger_logical_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMode_switch_trigger_logical_expression(@NotNull AadlBaParser.Mode_switch_trigger_logical_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#in_binding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn_binding(@NotNull AadlBaParser.In_bindingContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#boolean_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_literal(@NotNull AadlBaParser.Boolean_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#behavior_transition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehavior_transition(@NotNull AadlBaParser.Behavior_transitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#signed_int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSigned_int(@NotNull AadlBaParser.Signed_intContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#property_ref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty_ref(@NotNull AadlBaParser.Property_refContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#forall_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForall_condition(@NotNull AadlBaParser.Forall_conditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#for_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_condition(@NotNull AadlBaParser.For_conditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(@NotNull AadlBaParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#numeral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeral(@NotNull AadlBaParser.NumeralContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#boolean_property_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_property_value(@NotNull AadlBaParser.Boolean_property_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(@NotNull AadlBaParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#unary_numeric_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_numeric_operator(@NotNull AadlBaParser.Unary_numeric_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#list_property_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_property_value(@NotNull AadlBaParser.List_property_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#binary_adding_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary_adding_operator(@NotNull AadlBaParser.Binary_adding_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#multiplying_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplying_operator(@NotNull AadlBaParser.Multiplying_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#integer_range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger_range(@NotNull AadlBaParser.Integer_rangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#while_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_condition(@NotNull AadlBaParser.While_conditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#value_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_expression(@NotNull AadlBaParser.Value_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#behavior_action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehavior_action(@NotNull AadlBaParser.Behavior_actionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#unary_adding_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_adding_operator(@NotNull AadlBaParser.Unary_adding_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#reference_property_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference_property_value(@NotNull AadlBaParser.Reference_property_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#behavior_actions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehavior_actions(@NotNull AadlBaParser.Behavior_actionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#integer_property_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger_property_value(@NotNull AadlBaParser.Integer_property_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#subprogram_parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubprogram_parameter_list(@NotNull AadlBaParser.Subprogram_parameter_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#value_constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_constant(@NotNull AadlBaParser.Value_constantContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#integer_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger_value(@NotNull AadlBaParser.Integer_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#behavior_variable_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehavior_variable_list(@NotNull AadlBaParser.Behavior_variable_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#behavior_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehavior_condition(@NotNull AadlBaParser.Behavior_conditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#signed_real}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSigned_real(@NotNull AadlBaParser.Signed_realContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget(@NotNull AadlBaParser.TargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#unique_component_classifier_reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnique_component_classifier_reference(@NotNull AadlBaParser.Unique_component_classifier_referenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#string_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_literal(@NotNull AadlBaParser.String_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#dispatch_trigger_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDispatch_trigger_condition(@NotNull AadlBaParser.Dispatch_trigger_conditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#for_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_statement(@NotNull AadlBaParser.For_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#real_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal_literal(@NotNull AadlBaParser.Real_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#dispatch_trigger_logical_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDispatch_trigger_logical_expression(@NotNull AadlBaParser.Dispatch_trigger_logical_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#numeric_property_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric_property_value(@NotNull AadlBaParser.Numeric_property_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#behavior_action_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehavior_action_block(@NotNull AadlBaParser.Behavior_action_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#parameter_label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_label(@NotNull AadlBaParser.Parameter_labelContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlBaParser#qualifiable_named_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiable_named_element(@NotNull AadlBaParser.Qualifiable_named_elementContext ctx);
}