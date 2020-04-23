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
 
grammar AadlBa; /* COMPLIANCE : ANTLR 4.4 */

options
{
 language = Java;
}

@lexer::header
{
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
 
 import org.osate.ba.texteditor.AadlBaHighlighter ;
 import org.osate.ba.texteditor.DefaultAadlBaHighlighter ;
 import org.osate.annexsupport.AnnexHighlighterPositionAcceptor ;
}

@lexer::members
{
  public static final short KEYWORD_MAX_ID = 40 ;
  public static final short PUNCTUATION_MAX_ID = 70 ;
  public static final short EOF_ID = 0 ;
  public static final short ERR_MAX_ID = 73 ;
  
  protected int _annexOffset = 0 ;
  
  // Default highlighter does nothing.
  protected AadlBaHighlighter _ht = new DefaultAadlBaHighlighter() ;
  
  public void setHighlighter(AadlBaHighlighter ht)
  {
    _ht = ht ;
  }
  
  @Override
  public void emit(Token token)
  {
    super.emit(token) ;
    
    int type = token.getType() ;
    
    if(type != EOF_ID && type != IDENT)
    {
      if (type <= KEYWORD_MAX_ID) // Select only keyword. 
      {
        _ht.addToHighlighting(_annexOffset, token,
                              AnnexHighlighterPositionAcceptor.KEYWORD_ID);
      }
      else if(type <= PUNCTUATION_MAX_ID)
      {
        _ht.addToHighlighting(_annexOffset, token,
                              AnnexHighlighterPositionAcceptor.PUNCTUATION_ID);
      }
      else if(type <= ERR_MAX_ID)
      {
        _ht.addToHighlighting(_annexOffset, token,
                              AnnexHighlighterPositionAcceptor.INVALID_TOKEN_ID);
      }
      else
      {
        switch (type)
        {
          case STRING_LITERAL :
          {
            _ht.addToHighlighting(_annexOffset, token,
                                  AnnexHighlighterPositionAcceptor.STRING_ID) ;
            break ;
          }
                  
          case INTEGER_LIT :
          case REAL_LIT :
          {
            _ht.addToHighlighting(_annexOffset, token,
                                  AnnexHighlighterPositionAcceptor.NUMBER_ID) ;
            break ;
          }

          case SL_COMMENT :
          {
            _ht.addToHighlighting(_annexOffset, token,
                                  AnnexHighlighterPositionAcceptor.COMMENT_ID) ;
            break ;
          }
        }
      }
    }
  }
  
  public void setAnnexOffset(int offset)
  {
   _annexOffset = offset;
  }
}

@parser::header
{ 
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
}
  
@parser::members
{
  protected BehaviorAnnex _ba = null ;
  
  protected void notifyDuplicateSymbol(List<TerminalNode> left,
                                       List<TerminalNode> right,
                                       String symbolName)
  {
    Token token ;
        
    if(left.size() > 1)
    {
      token = left.get(left.size() -1).getSymbol() ;
    }
    else
    {
      token = right.get(right.size() -1).getSymbol() ;
    }
        
    notifyErrorListeners(token, "unbalanced " + symbolName, null);
  }
  
  protected void integerLiteralChecker(TerminalNode integerLiteral)
  {
    try
    {
      String str = integerLiteral.getText() ;
      ParseUtil.parseAadlInteger(str);
    }
    catch(IllegalArgumentException ex)
    {
      notifyErrorListeners(integerLiteral.getSymbol(),
                           "mal-formatted integer literal input \'" + 
                           integerLiteral.getText() + '\'', null) ;
    }
  }
  
  protected void realLiteralChecker(TerminalNode realLiteral)
  {
    try
    {
      String str = realLiteral.getText() ;
      str = str.replaceAll("_", "") ;
      ParseUtil.parseAadlReal(str) ;
    }
    catch (IllegalArgumentException ex)
    {
      notifyErrorListeners(realLiteral.getSymbol(),
                           "mal-formatted real literal input \'" + 
                           realLiteral.getText() + '\'', null) ;
    }
  }
}

//  Grammar

//---------------------------------------------------------
//---------------------------------------------------------
// BEGIN : ANNEX D.3 Behavior Specification
//---------------------------------------------------------

// behavior_annex ::=
//   [ variables { behavior_variable }+ ]
//   [ states { behavior_state }+ ]
//   [ transitions { behavior_transition }+ ]
behavior_annex returns [BehaviorAnnex result]
  : 
   ( VARIABLES (behavior_variable_list[$result])+ )?
   
   ( STATES (behavior_state_list[$result])+ )?
   
   ( TRANSITIONS (behavior_transition)+ )?
;

// behavior_variable ::= 
//   local_variable_declarator { , local_variable_declarator }* 
//   : data_unique_component_classifier_reference;
behavior_variable_list[BehaviorAnnex ba] locals[int variableCount]
  :
    behavior_variable
    {
      $variableCount = 0 ;
    }
    
    ( 
      (separator=COMMA)? behavior_variable
      {
        $variableCount++ ;
            
        if($separator == null) 
        {
          try
          {
            notifyErrorListeners($ctx.behavior_variable($variableCount -1).getStop(),
                                 "missing behavior variable separator \',\'", null);
          }
          catch(Exception e)
          {
            notifyErrorListeners("missing behavior variable separator \',\'") ;
          }
        }
        else
        {
          $ctx.separator = null ;
        }
      }
    )*
        
    COLON unique_component_classifier_reference 
    (ASSIGN value_constant)?
    (LCURLY (property_associations+=data_classifier_property_association)+ RCURLY)? (SEMICOLON)?
    {
      if($SEMICOLON() == null)
      {
        try
        {
           notifyErrorListeners($ctx.unique_component_classifier_reference().getStop(),
                                "unterminated behavior variable (missing ending \';\')", null) ;
        }
        catch(Exception e)
        {
          notifyErrorListeners("unterminated behavior variable (missing ending \';\')") ;
        }
      }
    }
;

// declarator ::= identifier { array_size }*
// array_size :: [ integer_value_constant ]
behavior_variable returns [BehaviorVariable result]
  :
    IDENT ( LBRACK integer_value_constant RBRACK )*
;

data_classifier_property_association returns [DeclarativePropertyAssociation result]
  :
	property=property_ref PROPERTYASSIGN ownedValue=property_value SEMICOLON
;


// property ::= 
//   { propertyset_identifier :: }* property_identifier
property_ref returns [QualifiedNamedElement result]
  :
   ( qualifiable_property[$result])
;


// qualifiable_named_element ::= 
//   { package_identifier :: }* component_type_identifier
qualifiable_property [QualifiedNamedElement result] locals[String id1, String id2]
  @init
  {
    $id1 = "";
    $id2 = "";
  }
  :
    ( identifier1=IDENT DOUBLECOLON
      { 
        $id1=$id1+($id1.length() == 0 ? "":"::") + $identifier1.text ;
      }
    )*
    
    identifier2=IDENT { $id2=$identifier2.text ; }
;


property_value returns [DeclarativePropertyExpression result]
  :
  	record_property_value
  	| reference_property_value
  	| classifier_property_value
  	| string_property_value
  	| numeric_range_property_value
  	| integer_property_value
  	| real_property_value
  	| list_property_value
  	| boolean_property_value  	
;

list_property_value returns [DeclarativeListValue result]
  :
    LPAREN ownedListElement+=property_value (COMMA ownedListElement+=property_value)* RPAREN
;

reference_property_value returns [DeclarativeReferenceValue result] :
	REFERENCE LPAREN reference RPAREN
;

boolean_property_value returns [BehaviorBooleanLiteral result]: 
	boolean_literal
;

numeric_range_property_value returns [DeclarativeRangeValue result] : 
	lower_bound=numeric_property_value DOTDOT upper_bound=numeric_property_value
;

record_property_value returns [DeclarativeRecordValue result]: 
	LBRACK field_assign+=field_property_association (field_assign+=field_property_association)* RBRACK
;

field_property_association returns [DeclarativeBasicPropertyAssociation result]:
	property=IDENT PROPERTYASSIGN property_value SEMICOLON
;


classifier_property_value returns [DeclarativeClassifierValue result]:
	CLASSIFIER LPAREN classifier=unique_component_classifier_reference RPAREN
;


// unit ::= 
//   { propertyset_identifier :: }* unit_identifier
unit_reference returns [QualifiedNamedElement result]
  :
   ( qualifiable_property[$result])
;

integer_property_value returns [BehaviorIntegerLiteral result]:
	value=signed_int (unit=unit_reference)?
	;

signed_int returns [Integer result]:
	('+'|'-')?integer_literal ;

real_property_value returns [BehaviorRealLiteral result]:
	value=signed_real (unit=unit_reference)?
	;

string_property_value returns [BehaviorStringLiteral result]
  :
   STRING_LITERAL
;

signed_real returns [Double result]:
	('+'|'-')?real_literal ;

numeric_property_value returns [DeclarativePropertyExpression result]:
	integer_property_value
	| real_property_value;


// qualifiable_named_element ::= 
//   { package_identifier :: }* component_type_identifier
//   [ . component_implementation_identifier ]
qualifiable_named_element [QualifiedNamedElement result] locals[String id1, String id2]
  @init
  {
    $id1 = "";
    $id2 = "";
  }
  :
    ( identifier1=IDENT DOUBLECOLON
      { 
        $id1=$id1+($id1.length() == 0 ? "":"::") + $identifier1.text ;
      }
    )*
    
    identifier2=IDENT { $id2=$identifier2.text ; }
    
    ( DOT identifier3=IDENT { $id2=$id2+"." + $identifier3.text ; } )?
;

// unique_component_classifier_reference ::= 
//   { package_identifier :: }* component_type_identifier
//   [ . component_implementation_identifier ]
unique_component_classifier_reference returns [QualifiedNamedElement result]
  :
   ( qualifiable_named_element[$result] )
;

// behavior_state ::=
//   behavior_state_identifier { , behavior_state_identifier }* 
//   : behavior_state_kind state;

// behavior_state_kind ::=
//   [ initial ][ complete ][ final ]
behavior_state_list [BehaviorAnnex ba] locals[int stateCount]
  :
    IDENT
    {
      $stateCount = 0 ;
    }
    (
      (separator=COMMA)? IDENT
      {
        $stateCount++ ;
        
        if($separator == null) 
        {
          try
          {
            notifyErrorListeners($IDENT($stateCount -1).getSymbol(),
                                 "missing behavior state separator \',\'", null);
          }
          catch(Exception e)
          {
            notifyErrorListeners("missing behavior state separator \',\'") ;
          }
        }
        else
        {
          $ctx.separator = null ;
        }
      }
    )*
    
    COLON 
    
    ( INITIAL )? 
    ( COMPLETE )? 
    ( FINAL )?

    STATE (SEMICOLON)?
    {
      if($SEMICOLON() == null)
      {
        try
        {
          notifyErrorListeners($STATE().getSymbol(),
                               "unterminated behavior state (missing ending \';\')", null) ;
        }
        catch(Exception e)
        {
          notifyErrorListeners("unterminated behavior state (missing ending \';\')") ;
        }
      }
    }
;

// behavior_transition ::=
//   [ transition_identifier [ [ behavior_transition_priority ] ] : ]
//   source_state_identifier { , source_state_identifier }* 
//    -[ behavior_condition ]->
//   destination_state_identifier [ behavior_action_block ] ;

// behavior_transition_priority ::= numeral
behavior_transition returns [DeclarativeBehaviorTransition result] locals[int srcCount]
  :
   ( transId=IDENT ( LBRACK numeral RBRACK )? COLON )?
   
   IDENT
   {
     if($transId != null)
     {
       $srcCount = 1 ;
     }
     else
     {
       $srcCount = 0 ;
     }
   }
   (
     (separator=COMMA)? IDENT
     {
       $srcCount++ ;
            
       if($separator == null) 
       {
         try
         {
           notifyErrorListeners($ctx.IDENT($srcCount -1).getSymbol(),
                                 "missing behavior state source separator \',\'", null);
         }
         catch(Exception e)
         {
           notifyErrorListeners("missing behavior state source separator \',\'") ;
         }
       }
       else
       {
         $ctx.separator = null ;
       }
     }
   )*
   
   LTRANS behavior_condition RTRANS
    
   destId=IDENT 
   
   ( behavior_action_block )? 
       
   (SEMICOLON)?
   {
     if($SEMICOLON() == null)
     {
       try
       {
         Token token = null ;
       
         if($ctx.behavior_action_block() != null)
         {
           token = $ctx.behavior_action_block().getStop() ;
         }
         else
         {
           token = $destId ;
         }
         
         notifyErrorListeners(token,
                              "unterminated behavior transition (missing ending \';\')", null) ;
       }
       catch(Exception e)
       {
         notifyErrorListeners("unterminated behavior transition (missing ending \';\')") ;
       }
     }
   }
;

// behavior_action_block ::=
// { behavior_actions } [ timeout behavior_time]
behavior_action_block returns [BehaviorActionBlock result]
  : action_block ( TIMEOUT behavior_time )?
;

action_block returns [BehaviorActionBlock result]
  : 
      LCURLY behavior_actions RCURLY
    |
      (LCURLY)+ behavior_actions (RCURLY)+
      {
        notifyDuplicateSymbol($LCURLY(), $RCURLY(), "{}") ;
      }
;

// behavior_condition ::= 
//   dispatch_condition
// | execute_condition
behavior_condition returns [BehaviorCondition result]
  :
      ( ON dispatch_condition )
    |
      ( ON mode_switch_trigger_logical_expression)
    |
      ( execute_condition )?
;

/**
 * Document: AADL Behavior Annex draft 
 * Version : 0.94 
 * Type : Naming rules
 * Section : D.3 Behavior Specification 
 * Object : Check naming rule D.3.(N1)
 * Keys : empty execute condition always true
 */
// execute_condition ::=
// [ logical_value_expression | behavior_action_block_timeout_catch | otherwise ]
execute_condition returns [ExecuteCondition result]
  : 
     value_expression
   |
     TIMEOUT
   |       
     OTHERWISE
;

integer_value_constant returns [IntegerValueConstant result]
 :
     integer_literal
   |
     // Ambiguous case.
     property_reference  
;

//---------------------------------------------------------
// END : ANNEX D.3 Behavior Specification
//---------------------------------------------------------
//---------------------------------------------------------


//---------------------------------------------------------
//---------------------------------------------------------
// BEGIN : ANNEX D.4 Thread Dispatch Behavior Specification
//---------------------------------------------------------

// dispatch_condition ::= 
//   on dispatch [ dispatch_trigger_condition ] 
//   [ frozen frozen_ports ]

// frozen_ports ::=
//   in_port_name { , in_port_name }*

dispatch_condition returns [DispatchCondition result] locals[int count]
  :
   DISPATCH ( dispatch_trigger_condition )?
   ( 
     FROZEN reference
     {
       $count = 0 ;
     }
     (
       (separator=COMMA)? reference
       {
         $count++ ;
            
         if($separator == null) 
         {
           try
           {
             notifyErrorListeners($ctx.reference($count -1).getStop(),
                                 "missing frozen port separator \',\'", null);
           }
           catch(Exception e)
           {
             notifyErrorListeners("missing frozen port separator \',\'") ;
           }
         }
         else
         {
           $ctx.separator = null ;
         }
       }
     )*
   )?
;

// dispatch_trigger_condition ::=
// dispatch_trigger_logical_expression
// | provides_subprogram_access_name
// | stop
// | completion_relative_timeout_condition_and_catch
// | dispatch_relative_timeout_catch

// completion_relative_timeout_condition_and_catch ::=
// timeout behavior_time

// dispatch_relative_timeout_catch ::=
// timeout
dispatch_trigger_condition returns [DispatchTriggerCondition result]
   : // Ambiguity between subprogram access name and a dispatch trigger !
     // A dispatch trigger logical expression with only one
     // dispatch conjunction which is only one dispatch trigger (single name)
     // can't be distinguish from a subprogram access name.
     // subprogram access name are parsed as dispatch trigger logical
     // expression.
     
       // Ambiguous case.
       dispatch_trigger_logical_expression
     |
       ( TIMEOUT ( behavior_time )? )
     |
       STOP
;

mode_switch_trigger_logical_expression returns [ModeSwitchTriggerLogicalExpression
                                             result]
   : 
     mode_switch_trigger_conjunction ( OR mode_switch_trigger_conjunction )*
;

// dispatch_trigger_logical_expression ::=
// dispatch_conjunction { or dispatch_conjunction }*
dispatch_trigger_logical_expression returns [DispatchTriggerLogicalExpression
                                             result]
   : 
     dispatch_conjunction ( OR dispatch_conjunction )*
;

// dispatch_conjunction ::=
// dispatch_trigger { and dispatch_trigger }*

// dispatch_trigger ::=
// in_event_port_name
// | in_event_data_port_name
dispatch_conjunction returns [DispatchConjunction result]
   :
     reference ( AND reference )*
;

mode_switch_trigger_conjunction returns [ModeSwitchConjunction result]
   :
     reference ( AND reference )*
;

//---------------------------------------------------------
// END : ANNEX D.4 Thread Dispatch Behavior Specification
//---------------------------------------------------------
//---------------------------------------------------------

//---------------------------------------------------------
//---------------------------------------------------------
// BEGIN : ANNEX D.6 Behavior Action Language
//---------------------------------------------------------

// behavior_actions ::=
//   behavior_action
// | behavior_action_sequence
// | behavior_action_set

// behavior_action_sequence ::=
//   behavior_action { ; behavior_action }+

// behavior_action_set ::=
//   behavior_action { & behavior_action }+ 
behavior_actions returns [BehaviorActions result] locals[int actionCount]
  :
   behavior_action
   {
     $actionCount = 0 ;
   }
   ( 
       ( 
         (separator=SEMICOLON)? behavior_action
         {
           $actionCount++ ;
         
           if($separator == null) 
           {
             try
             {
               notifyErrorListeners($ctx.behavior_action($actionCount -1).getStop(),
                 "missing behavior action sequence separator \';\'", null);
             }
             catch (Exception e)
             {
               notifyErrorListeners("missing behavior action sequence separator \';\'");
             }
           }
           else
           {
             $ctx.separator = null ;
           }
         }
       )*
       (ending=SEMICOLON)?
       {
         if($ending != null)
         {
           notifyErrorListeners($ending, "extraneous input \'" + $ending.text +
                            "\', delete it", null);
         }
       }
     |  
       ( 
         (separator=CONCAT)? behavior_action
         {
           $actionCount++ ;
         
           if($separator == null) 
           {
             try
             {
               notifyErrorListeners($ctx.behavior_action($actionCount -1).getStop(),
                 "missing behavior action set separator \'&\'", null);
             }
             catch (Exception e)
             {
               notifyErrorListeners("missing behavior action set separator \'&\'");
             }
           }
           else
           {
             $ctx.separator = null ;
           }
         }
       )*
       (ending=CONCAT)?
       {
         if($ending != null)
         {
           notifyErrorListeners($ending, "extraneous input \'" + $ending.text +
                              "\', delete it", null);
         }
       }
   )
;

// behavior_action ::=
//   basic_action 
// | behavior_action_block
// | if ( logical_value_expression ) behavior_actions
//  { elsif ( logical_value_expression ) behavior_actions }*
//  [ else behavior_actions ]   
//  end if 
// | for ( 
//  element_identifier  : data_unique_component_classifier_reference 
//  in element_values ) { behavior_actions }
// | forall ( 
//  element_identifier : data_unique_component_classifier_reference
//  in element_values ) { behavior_actions }
// | while ( logical_value_expression ) { behavior_actions }
// | do behavior_actions until ( logical_value_expression )
behavior_action returns [BehaviorAction result]
 :
     basic_action
   | 
     if_statement
   |
     for_statement
   |
     while_statement
   |
     dountil_statement
   |
     behavior_action_block
   | 
     forall_statement
;

// if ( logical_value_expression ) behavior_actions
//  { elsif ( logical_value_expression ) behavior_actions }*
//  [ else behavior_actions ]   
// end if 
if_statement returns [IfStatement result]
  :
      IF LPAREN value_expression RPAREN behavior_actions 
      ( elsif_statement )*
      ( ELSE behavior_actions )?
      END IF
    |
      // Error alternatives. 
      IF (LPAREN)+ value_expression (RPAREN)+ behavior_actions 
      ( elsif_statement )*
      ( ELSE behavior_actions )?
      (END IF | ERR_END)?
      {
        if($ERR_END() != null)
        {
          String msg = "mismatched input \'" + $ERR_END().getText() + "\' expecting \'end if\'" ;
          notifyErrorListeners($ERR_END().getSymbol(), msg, null) ;
        }
        else if($END() == null)
        {
          notifyErrorListeners("unterminated if statement (missing \'end if\')") ;
        }
        
        if($LPAREN().size() > 1 ||
           $RPAREN().size() > 1)
        {  
          notifyDuplicateSymbol($LPAREN(), $RPAREN(), "()") ;
        }
      }
;

// elsif ( logical_value_expression ) behavior_actions
elsif_statement returns [IfStatement result]
  :
    (ELSIF | ERR_ELSIF) (LPAREN)+ value_expression (RPAREN)+ behavior_actions
    {
      if($LPAREN().size() > 1 ||
         $RPAREN().size() > 1   )
      {  
          notifyDuplicateSymbol($LPAREN(), $RPAREN(), "()") ;
      }
      
      if($ERR_ELSIF() != null)
      {
        String msg = "mismatched input \'" + $ERR_ELSIF().getText() + "\' expecting \'"
            + AadlBaLexer.tokenNames[AadlBaLexer.ELSIF] + '\'' ;
          notifyErrorListeners($ERR_ELSIF().getSymbol(), msg, null) ;
      }
    }
;

// for (element_identifier  : data_unique_component_classifier_reference 
//  in element_values ) { behavior_actions }
for_statement returns [ForOrForAllStatement result]
  :
      for_condition LCURLY behavior_actions RCURLY
    |
      for_condition (LCURLY)+ behavior_actions (RCURLY)+
      {
        notifyDuplicateSymbol($LCURLY(), $RCURLY(), "{}") ;
      }
;  

for_condition returns [ForOrForAllStatement result]
    :

        FOR LPAREN IDENT COLON unique_component_classifier_reference
        IN element_values RPAREN
      |
        FOR (LPAREN)+ IDENT COLON unique_component_classifier_reference
        IN element_values (RPAREN)+
        {
          notifyDuplicateSymbol($LPAREN(), $LPAREN(), "()") ;
        }
;

// forall (element_identifier  : data_unique_component_classifier_reference 
//  in element_values ) { behavior_actions }
forall_statement returns [ForOrForAllStatement result]
  :
      forall_condition LCURLY behavior_actions RCURLY
    |
      forall_condition (LCURLY)+ behavior_actions (RCURLY)+
      {
        notifyDuplicateSymbol($LCURLY(), $RCURLY(), "{}") ;
      }
;  

forall_condition returns [ForOrForAllStatement result]
    :
        FORALL LPAREN IDENT COLON unique_component_classifier_reference
        IN element_values RPAREN
      |
        FORALL (LPAREN)+ IDENT COLON unique_component_classifier_reference
        IN element_values (RPAREN)+
        {
          notifyDuplicateSymbol($LPAREN(), $LPAREN(), "()") ;
        }
;

// while ( logical_value_expression ) { behavior_actions }
while_statement returns [WhileOrDoUntilStatement result]
  :
      while_condition LCURLY behavior_actions RCURLY
    |
      while_condition (LCURLY)+ behavior_actions (RCURLY)+ 
      {
        notifyDuplicateSymbol($LCURLY(), $RCURLY(), "{}") ;
      }
;

while_condition returns [WhileOrDoUntilStatement result]
  :
      WHILE LPAREN value_expression RPAREN
    |
      WHILE (LPAREN)+ value_expression (RPAREN)+
      {
        notifyDuplicateSymbol($LPAREN(), $LPAREN(), "()") ;
      } 
;

// do behavior_actions until ( logical_value_expression )
dountil_statement returns [WhileOrDoUntilStatement result]
  :
      DO behavior_actions UNTIL LPAREN value_expression RPAREN
    |
      DO behavior_actions UNTIL (LPAREN)+ value_expression (RPAREN)+
      {
        notifyDuplicateSymbol($LPAREN(), $LPAREN(), "()") ;
      }
;

// element_values ::=
//   integer_range
// | event_data_port_name
// | array_data_component_reference
element_values returns [ElementValues result]
  : 
     integer_range
   |
     reference
;

// basic_action ::=
//   assignment_action
// | communication_action
// | timed_action
basic_action returns [BasicAction result]
  :
     assignment_action
   |
     communication_action
   |
     timed_action
;

// assignment_action ::= 
//   target := ( value_expression | any )
assignment_action returns [AssignmentAction result]
  :
     target (ASSIGN | EQUAL) ( value_expression | ANY )
     {
       if($EQUAL() != null)
       {
         notifyErrorListeners($EQUAL().getSymbol(),
           "mismatched input \'" + $EQUAL().getText() + "\' expecting " + 
             AadlBaLexer.tokenNames[AadlBaLexer.ASSIGN], null) ;
       }
     }  
;

// target ::= 
// | outgoing_port_name
// | outgoing_subprogram_parameter 
// | data_component_reference
// | outgoing_port_prototype_name
target returns [Target result]
  : reference 
;

// qualified_named_element ::= 
//   { package_identifier :: }+ component_type_identifier
//   [ . component_implementation_identifier ]
qualified_named_element returns [QualifiedNamedElement result]
                        locals [String namespaceId, String nameId]
@init
{
  $namespaceId = "";
  $nameId = "";
}
  :
    ( id1=IDENT DOUBLECOLON
      { 
        $namespaceId=$namespaceId+($namespaceId.length() == 0 ? "":"::") + $id1.text ;
      }
    )+
    
    id2=IDENT
    { 
      $nameId=$id2.text ;
    }
    ( DOT id3=IDENT
      {
        $nameId=$nameId+ "." + $id3.text ;
      }
    )?
;

// communication_action ::= 
//   subprogram_prototype_name ! [ ( subprogram_parameter_list ) ]
// | required_subprogram_access_name ! [ ( subprogram_parameter_list ) ]
// | subprogram_classifier_name ! [ ( subprogram_parameter_list ) ]
// | output_port_name ! [ ( value_expression ) ]
// | input_port_name >>
// | input_port_name ? [ ( target ) ]
// | required_data_access_name !<
// | required_data_access_name !>
// | required_data_access_name . provided_subprogram_access_name ! [ ( subprogram_parameter_list ) ]
// | data_subcomponent_name . provided_subprogram_access_name ! [ ( subprogram_parameter_list ) ]
// | local_variable_name . provided_subprogram_access_name ! [ ( subprogram_parameter_list ) ]
// | *!<
// | *!>
communication_action returns [CommAction result]
  : // Ambiguity between name without array indexes and unqualified
    // subprogram unique component classifier reference without component
    // implementation.
    // unqualified subprogram unique component classifier reference 
    // without component are parsed as reference.
        
    // Ambiguity between value expression and a subprogram parameter list
    // with only one parameter label which can be a value expression or a target.
    // Value expressions are parsed as subprogram parameter list
    // with only one parameter label.
    
    // Ambiguity between name.name without array index and unqualified
    // unique component classifier reference with component implementation.
    // these uccr are parsed as reference.
    
      qualified_named_element EXCLAM (LPAREN subprogram_parameter_list RPAREN)?
    |
      reference
      (
          INTERROG (LPAREN target RPAREN)?
        |
          GGREATER
        |
          EXCLLESS
        |
          EXCLGREATER
        |
          EXCLAM (LPAREN subprogram_parameter_list RPAREN)?
        |
          INTERROG ((LPAREN)+ target (RPAREN)+)?
          {
            notifyDuplicateSymbol($LPAREN(), $RPAREN(), "()") ;
          }
        |
          EXCLAM ((LPAREN)+ subprogram_parameter_list (RPAREN)+)?
          {
            notifyDuplicateSymbol($LPAREN(), $RPAREN(), "()") ;
          }
      )
    |
      STAR
      ( 
          EXCLLESS
        | 
          EXCLGREATER
      )
    |
      qualified_named_element EXCLAM ((LPAREN)+ subprogram_parameter_list (RPAREN)+)?
      {
        notifyDuplicateSymbol($LPAREN(), $RPAREN(), "()") ;
      }
;

// timed_action ::= 
//   computation ( behavior_time [ .. behavior_time ] ) [ in_binding ]
timed_action returns [TimedAction result]
  :
     COMPUTATION LPAREN behavior_time (DOTDOT behavior_time)? RPAREN
       (in_binding [$result])?
   |
     COMPUTATION (LPAREN)+ behavior_time (DOTDOT behavior_time)? (RPAREN)+ (in_binding [$result])?
     {
       notifyDuplicateSymbol($LPAREN(), $RPAREN(), "()") ;
     }
;

// in_binding ::=
//    in binding ( processor_parameter_list )
in_binding [TimedAction ta]
  :
      IN BINDING LPAREN processor_parameter_list RPAREN
    |
      IN BINDING (LPAREN)+ processor_parameter_list (RPAREN)+
      {
        notifyDuplicateSymbol($LPAREN(), $RPAREN(), "()") ;
      }
;

// processor_parameter_list ::=
//   processor_unique_component_classifier_reference
//                      { , processor_unique_component_classifier_reference }*
processor_parameter_list returns [EList<ProcessorClassifier> result] locals[int count]
  :
    unique_component_classifier_reference
    {
      $count = 0 ;
    }
    (
      (separator=COMMA)? unique_component_classifier_reference
      {
        $count++ ;
        
        if($separator == null) 
        {
          try
          {
            notifyErrorListeners($ctx.unique_component_classifier_reference($count -1).getStop(),
                                 "missing processor parameter separator \',\'", null);
          }
          catch(Exception e)
          {
            notifyErrorListeners("missing processor parameter separator \',\'") ;
          }
        }
        else
        {
          $ctx.separator = null ;
        }
      }
    )*  
;

// subprogram_parameter_list ::=
//   parameter_label { , parameter_label }*
subprogram_parameter_list returns [EList<ParameterLabel> result] locals [int count]
  : 
   parameter_label
   {
     $count = 0 ;
   }
   (
     (separator=COMMA)? parameter_label
     {
       $count++ ;
            
       if($separator == null) 
       {
         try
         {
           notifyErrorListeners($ctx.parameter_label($count -1).getStop(),
                               "missing subprogram parameter separator \',\'", null);
         }
         catch(Exception e)
         {
           notifyErrorListeners("missing subprogram parameter separator \',\'") ;
         }
       }
       else
       {
         $ctx.separator = null ;
       }
     }
   )*
;

// parameter_label ::=
//   in_parameter_value_expression | out_parameter_target
parameter_label returns [ParameterLabel result]
  : // Ambiguity between a value expression with a single value and a target.
    // Targets are parsed as value expression.

    value_expression
;

// reference ::=
//   name | data component reference

// name ::=
//   { thread_group_identifier . }*
//   {
//     [ subprogram_group_access_identifier . ]
//     [ subprogram_group_identifier . ]
//     [ feature_group_identifier . ]
//   }*
//   identifier { array_index }*

// array_index ::=
//   [ integer_value ]

// data_component_reference ::=
//   data_subcomponent_name { . data_field }*
// | data_access_feature_name { . data_field }*
// | local_variable_identifier { . data_field }* 
// | data_access_feature_prototype_name { . data_field }*

// subprogram_parameter ::=
//   subprogram_parameter_name {. data_field }*

// data_field ::=
//   data_subcomponent_name
// | data_access_name
// | data_access_prototype_name

reference returns [Reference result]
  :
    array_identifier (DOT array_identifier)*
;

// array_identifier ::=
//   identifier { integer_value }*
array_identifier returns [ArrayableIdentifier result]
  :
    IDENT (LBRACK integer_value RBRACK)*
;

//---------------------------------------------------------
// END : ANNEX D.6 Behavior Action Language
//---------------------------------------------------------
//---------------------------------------------------------

//---------------------------------------------------------
//---------------------------------------------------------
// BEGIN : ANNEX D.7 Behavior Expression Language
//---------------------------------------------------------

// value_constant ::= 
//   boolean_literal
// | numeric_literal 
// | string_literal
// | property_constant
// | property_reference
value_constant returns [ValueConstant result]
  : // Ambiguity between qualified or unqualified  property constant and
    // qualified or unqualified property reference with only one property name and
    // no property field. so property constants are parsed as property references
    // (see property reference). 
   
       numeric_literal
     |
       property_reference
     |
       boolean_literal
     |
       string_literal
;

/** 
 * Document: AADL Behavior Annex draft
 * Version : 0.94 
 * Type : Legality rule
 * Section : D.7 Behavior Expression Language
 * Object : Check Legality rule D.7.(L2) 
 * Keys : parentheses on operators precedence
 */
// value ::=
//   value_variable
// | value_constant
// | ( value_expression )
value_constant_or_variable returns [Value result]
  :
     value_constant
   |  
     value_variable
   |
     LPAREN value_expression RPAREN
   |
     (LPAREN)+ value_expression (RPAREN)+
     {
       notifyDuplicateSymbol($LPAREN(), $RPAREN(), "()") ;
     }
;

// value_variable ::=
//   incoming_port_name
// | incoming_port_name ?
// | incoming_subprogram_parameter
// | incoming_port_prototype_name
// | data_component_reference
// | port_name ’ count
// | port_name ’ fresh
value_variable returns [ValueVariable result]
  : 
     reference
     (
         INTERROG
       |
         TICK (COUNT | FRESH)
     )?
;

/** 
 * Document: AADL Behavior Annex draft
 * Version : 0.94 
 * Type : Legality rule
 * Section : D.7 Behavior Expression Language
 * Object : Check Legality rule D.7.(L1) 
 * Keys : operators precedence
 */ 
// value_expression ::=
//   relation { logical_operator relation }* 
value_expression returns [ValueExpression result]
  :
    relation (logical_operator relation)*
;

// relation ::=
//   simple_expression [ relational_operator simple_expression ]
relation returns [Relation result]
  :
    simple_expression (relational_operator simple_expression)?
;

// simple_expression ::= 
//   [ unary_adding_operator ] term { binary_adding_operator term }*
simple_expression returns [SimpleExpression result]
  :
    (unary_adding_operator)? term (binary_adding_operator term)*
;

// term ::= 
//   factor { multiplying_operator factor }*
term returns [Term result]
  :
   factor (multiplying_operator factor)*
;

// factor ::= 
//   value [ binary_numeric_operator value ] 
// | unary_numeric_operator value 
// | unary_boolean_operator value
factor returns [Factor result]
  :
     value_constant_or_variable (binary_numeric_operator value_constant_or_variable)?
   |
     unary_numeric_operator value_constant_or_variable
   |
     unary_boolean_operator value_constant_or_variable
;



// logical_operator ::= and | or | xor
logical_operator returns [LogicalOperator result]
  :
     AND | OR | XOR
;

// relational_operator ::= = | != | < | <= | > | >=
relational_operator returns [RelationalOperator result]
  :
     EQUAL
   |
     NOTEQUAL
   |
     LESSTHAN
   |
     LESSOREQUAL
   |
     GREATERTHAN
   |
     GREATEROREQUAL
   |
     ERR_EQUALEQUAL
     {
       notifyErrorListeners($ERR_EQUALEQUAL().getSymbol(),
                            "mismatched input \'" + $ERR_EQUALEQUAL().getText() +
                            "\' expecting " + 
                            AadlBaLexer.tokenNames[AadlBaLexer.EQUAL], null) ;
     }
;

// binary_adding_operator ::= + | - 
binary_adding_operator returns [BinaryAddingOperator result]
  :
    PLUS | MINUS
;

// unary_adding_operator ::=  + | -
unary_adding_operator returns [UnaryAddingOperator result]
  :
    PLUS | MINUS
;

// multiplying_operator ::=  * | / | mod | rem
multiplying_operator returns [MultiplyingOperator result]
  :
    STAR | DIVIDE | MOD | REM
;

// binary_numeric_operator ::= **
binary_numeric_operator returns [BinaryNumericOperator result]
  :
    STARSTAR
;

// unary_numeric_operator ::= abs
unary_numeric_operator returns [UnaryNumericOperator result]
  :
    ABS
;

// unary_boolean_operator ::= not
unary_boolean_operator returns [UnaryBooleanOperator result]
  :
    NOT
;

// boolean_literal ::= true | false
boolean_literal returns [BehaviorBooleanLiteral result]
  :
    TRUE | FALSE
;

// integer_range ::= integer_value .. integer_value
integer_range returns [IntegerRange result]
  :
    integer_value DOTDOT integer_value
;

// integer_value ::= 
//   integer_value_variable 
// | integer_value_constant
integer_value returns [IntegerValue result]
  : 
     integer_value_constant
   |
     value_variable              
;

// behavior_time ::= integer_value unit_identifier
behavior_time returns [DeclarativeTime result]
  :
    integer_value IDENT
;

// property_constant ::=
//   # [ property_set_identifier :: ] property_constant_identifier

// property_reference ::=
//   # [ property_set_identifier :: ] property_value_name { . field_record_property_name }*
// | own_component_element_reference # property_name { . field_record_property_name }*
// | unique_component_classifier_reference # property_name { . field_record_property_name }*

// component_element_reference ::=
//   subcomponent_name
// | local_variable_name
// | binded_prototype_name
// | feature_name

// Ambiguity between qualified or unqualified  property constant and
// qualified or unqualified property reference with only one property name and
// no property field. so property constants are parsed as property references
// (see property reference).

// Ambiguity between a unique component classifier reference without namespace
// and a component element reference.
// Ambiguity between a property literal and a property name without field.

property_reference returns [DeclarativePropertyReference result]
  :
    (   
        ( h1=HASH (IDENT DOUBLECOLON)? )
      | 
        ( 
          (   qualified_named_element
            | 
              reference
          )
          h2=HASH
        )
    )
    
    property_name (DOT property_name)*
;  
    
// property_name ::=
//   property_identifier [ property_field ]

// property_field ::=
//   [ integer_value ]* (enumeration and list properties supported only)
// | . item_list_identifier (enumeration and list properties supported only)
// | . upper_bound (range properties supported only)
// | . lower_bound (range properties supported only)
// Ambiguity between a property literal and a property name without field.
property_name returns [DeclarativePropertyName result]
  :
IDENT  (   
           ( LBRACK integer_value RBRACK )+
         |
           ( 
             DOT
             (
                 UPPER_BOUND
               |
                 LOWER_BOUND
             )
           )
       )?  
;

// numeric_literal ::= <refer to [AS5506A 15.4]>
// numeric literal without optional sign and unit
numeric_literal returns [NumericLiteral result]
  :
    integer_literal | real_literal
;

real_literal returns [BehaviorRealLiteral result]
  :
    REAL_LIT
    {
      realLiteralChecker($ctx.REAL_LIT()) ;
    }
;

integer_literal returns [BehaviorIntegerLiteral result]
 :
    INTEGER_LIT
    {
      integerLiteralChecker($ctx.INTEGER_LIT());
    }
;

// string_literal ::= <refer to [AS5506A 15.5]>
string_literal returns [BehaviorStringLiteral result]
  :
   STRING_LITERAL
;

// numeral ::= <refer to [AS5506A 15.4.1]>
numeral returns [Integer result]
  :
    INTEGER_LIT
    {
      integerLiteralChecker($ctx.INTEGER_LIT());
    }
;

//---------------------------------------------------------
// END : ANNEX D.7 Behavior Expression Language
//---------------------------------------------------------
//---------------------------------------------------------

// AADL Behavior Annex Tokens
// Keywords

ABS            : 'abs'; 
AND            : 'and';
ANY            : 'any';
BINDING        : 'binding';
CLASSIFIER     : 'classifier';
COMPLETE       : 'complete';
COMPUTATION    : 'computation';
COUNT          : 'count';
DISPATCH       : 'dispatch';
DO             : 'do';
ELSE           : 'else';
ELSIF          : 'elsif';
END            : 'end';
FALSE          : 'false';
FINAL          : 'final';
FOR            : 'for';
FORALL         : 'forall';
FRESH          : 'fresh';
FROZEN         : 'frozen';
IF             : 'if';
IN             : 'in';
INITIAL        : 'initial';
LOWER_BOUND    : 'lower_bound' ;
MOD            : 'mod';
NOT            : 'not';
ON             : 'on';
OR             : 'or';
OTHERWISE      : 'otherwise';
REFERENCE      : 'reference';
VARIABLES      : 'variables';
REM            : 'rem';
STATE          : 'state';
STATES         : 'states';
STOP           : 'stop';
TIMEOUT        : 'timeout';
TRANSITIONS    : 'transitions';
TRUE           : 'true';
UNTIL          : 'until';
UPPER_BOUND    : 'upper_bound' ;
WHILE          : 'while';
XOR            : 'xor';


// SIGNS
LBRACK         : '[';
RBRACK         : ']';
COMMA          : ',' ;
LTRANS         : '-[';
RTRANS         : ']->';
LPAREN         : '(' ;
RPAREN         : ')' ;
CONCAT         : '&';
LCURLY         : '{' ;
RCURLY         : '}' ;
COLON          : ':' ;
ASSIGN         : ':=';
PROPERTYASSIGN : '=>';
EXCLAM         : '!';
INTERROG       : '?';
GGREATER       : '>>';
EXCLLESS       : '!<';
EXCLGREATER    : '!>';
DOT            : '.' ;
TICK           : '\'';
EQUAL          : '=';
NOTEQUAL       : '!=';
LESSTHAN       : '<';
LESSOREQUAL    : '<=';
GREATERTHAN    : '>';
GREATEROREQUAL : '>=';
PLUS           : '+' ;
MINUS          : '-' ;
STAR           : '*' ;
DIVIDE         : '/';
STARSTAR       : '**' ;
DOTDOT         : '..' ;
SEMICOLON      : ';' ;
DOUBLECOLON    : '::';
HASH           : '#';

//INVALID TOKENS

ERR_EQUALEQUAL : '==' ;
ERR_END        : 'endif' ;
ERR_ELSIF      : 'elif' ;

// OTHERS STUFFS IMPORT FROM AADL2.g file (OSATE2)

IDENT : LETTER 
      ( 
        ('_')? 
        (LETTER|'0'..'9')
      )*
;

fragment
LETTER : ('a'..'z');

STRING_LITERAL:'"' ('""' |ESC|~('"'|'\\'))* '"';

REAL_LIT :  (DIGIT)+('_' (DIGIT)+)*
    (
      ( '.' (DIGIT)+('_' (DIGIT)+)* ( EXPONENT )?)
    )
;

INTEGER_LIT : 
    (DIGIT)+('_' (DIGIT)+)*
    (
      ( '#' BASED_INTEGER  '#' ( INT_EXPONENT )? )
      | (INT_EXPONENT)?
    )
;

fragment
DIGIT : ( '0'..'9' ) ;

fragment
EXPONENT : ('e') ('+'|'-')? ( DIGIT )+ ;

fragment
INT_EXPONENT : ('e') ('+')? ( DIGIT )+ ;

fragment
EXTENDED_DIGIT : ( DIGIT | 'a'..'f' ) ;

fragment
BASED_INTEGER : ( EXTENDED_DIGIT ) ( ('_')? EXTENDED_DIGIT )* ;

fragment
BASE : DIGIT ( DIGIT )? ;

// hexadecimal digit (again, note it's protected)
fragment
HEX_DIGIT : ('0'..'9'
            | 'a'..'f')
;

WS : ( ' '
     | '\r' '\n' 
     | '\r' 
     | '\n' 
     | '\t' 
     )
     -> skip
;   

// Single-line comments
SL_COMMENT
  : ('--' (~('\n'|'\r' ))*)
    -> channel (HIDDEN)
;



// escape sequence -- note that this is protected; it can only be called
//   from another lexer rule -- it will not ever directly return a token to
//   the parser
// There are various ambiguities hushed in this rule.  The optional
// '0'...'9' digit matches should be matched here rather than letting
// them go back to STRING_LITERAL to be matched.  ANTLR does the
// right thing by matching immediately; hence, it's ok to shut off
// the FOLLOW ambig warnings.
fragment
ESC
  : '\\'
    ( 'n'
    | 'r'
    | 't'
    | 'b'
    | 'f'
    | '"'
    | '\''
    | '\\'
    | ('u')+ HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    | '0'..'3'
      (
        /* options {
          warnWhenFollowAmbig = false;
        } */
        '0'..'7'
        (
          /* options {
            warnWhenFollowAmbig = false;
          } */
          '0'..'7'
        )?
      )?
    | '4'..'7'
      (
        /* options {
          warnWhenFollowAmbig = false;
        } */
        '0'..'7'
      )?
    )
;