/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */
 
grammar AadlBa;

options {
  k=*;
  language = Java;
  backtrack = true;
}

@header { 
  package fr.tpt.aadl.annex.behavior.parser;
  
  //import org.antlr.runtime;
  
  import org.eclipse.emf.common.util.BasicEList ;

  import org.antlr.runtime.BaseRecognizer;
  import org.antlr.runtime.BitSet;
  import org.antlr.runtime.DFA;
  import org.antlr.runtime.EarlyExitException;
  import org.antlr.runtime.FailedPredicateException;
  import org.antlr.runtime.MismatchedNotSetException;
  import org.antlr.runtime.MismatchedRangeException;
  import org.antlr.runtime.MismatchedSetException;
  import org.antlr.runtime.MismatchedTokenException;
  import org.antlr.runtime.MismatchedTreeNodeException;
  import org.antlr.runtime.NoViableAltException;
  import org.antlr.runtime.Parser;
  import org.antlr.runtime.RecognitionException;
  import org.antlr.runtime.Token;
  import org.antlr.runtime.TokenStream;
  
  import org.eclipse.emf.common.util.EList;

  import edu.cmu.sei.aadl.modelsupport.errorreporting.ParseErrorReporter;  
  import edu.cmu.sei.aadl.aadl2.parsesupport.AObject;
  
  import edu.cmu.sei.aadl.aadl2.parsesupport.LocationReference;
  
  import fr.tpt.aadl.annex.behavior.aadlba.*;
}
  
@lexer::header{
  package fr.tpt.aadl.annex.behavior.parser;
  
  import edu.cmu.sei.aadl.modelsupport.errorreporting.ParseErrorReporter;
}

@members {
  /**
  * Aadl Ba metamodel factory.
  */
  protected AadlBaFactory _fact = AadlBaFactory.eINSTANCE ;
  

  /**
   * The error reporter to use.
   */
  protected ParseErrorReporter errReporter = null;
  
  /**
   * The aadl filename to be parsed.
   */
  private String filename;
  
  /**
   * Set the error reporter to use.
   */
   
  public void setParseErrorReporter(final ParseErrorReporter reporter) {
      errReporter = reporter;
  }
  
  public void setFilename(String fn){
    filename=fn;
  }
  
  public String getFilename(){
    return filename;
  }
  
  public void nameCopy(Name src, Name dest)
  {
    dest.setLocationReference(src.getLocationReference());
    dest.setIdentifierOwned(src.getIdentifierOwned());
    dest.getArrayIndexes().addAll(src.getArrayIndexes());
  }
  
  /**
   * Reports a parser error.
   * @param e  antlr error exception 
   */
  public  void reportError(RecognitionException e)  {
        String description=null;
        if (e instanceof MismatchedTokenException){
          MismatchedTokenException mte = (MismatchedTokenException) e;
          if (mte.expecting != -1)
            description = "Expecting: "+tokenNames[mte.expecting]+", found: "+mte.token.getText();
          else
            description = "Unexpected token '"+mte.token.getText()+"'";
        } else if (e instanceof MismatchedTreeNodeException){
          description = "Unexpected Tree Node Exception";
        } else if (e instanceof NoViableAltException){
          NoViableAltException nva = (NoViableAltException) e;
          description = "No viable alternative: "+nva.grammarDecisionDescription;
        } else if (e instanceof EarlyExitException){
          EarlyExitException ee = (EarlyExitException) e;
          description = "Early Exit";
        } else if (e instanceof FailedPredicateException){
          FailedPredicateException fp = (FailedPredicateException)e;
          description = "Semantic error: "+fp.predicateText;
        } else if (e instanceof MismatchedRangeException){
          MismatchedRangeException mr = (MismatchedRangeException)e;
          description = "Mismatched range: ";
        } else if (e instanceof MismatchedSetException){
          MismatchedSetException ms = (MismatchedSetException)e;
          description = "Mismatched set";
        } else if (e instanceof MismatchedNotSetException){
          description="Mismatched of inverse of a set";
        } 
        description += " at line " + e.line + " col " + e.charPositionInLine ;
        //TODO : remove clean code.
        System.err.println(description);
        errReporter.error(this.getFilename(), e.line, description);
  }

  /**
   * Reports parser error.
   * @param e  any exception 
   */
  public  void reportError(Exception e) {
    //AadlParserPlugin.INSTANCE.log(e);
    errReporter.error(this.getFilename(), 0, e.toString());
  }

  /**
   * Sets obj's location reference based on full token informations.
   *
   * @param obj the AObject to be set
   * @param src the token 
   */ 
  private void setLocationReference(AObject obj, Token src){
    
    String description = "file " + this.getFilename() + " col " + src.getCharPositionInLine() ;
    
    obj.setLocationReference(new LocationReference(description, src.getLine()));
  
  }
}

@lexer::members {
  public static final int COMMENT_CHANNEL=10;
  
  protected String filename=null;
  
  public void setFilename(String n){
   filename=n;
  }
  
  /**
   * the current resource being parsed
   */
  protected ParseErrorReporter errReporter = null;
  
  /**
   * Set the Parse Error Reporter with which to produce error messages.
   */
  public void setParseErrorReporter(final ParseErrorReporter reporter) {
      errReporter = reporter;
  }
      
  /**
   * Report lexer error
   * @param e  antlr error exception 
   */
  public  void reportError(RecognitionException e) {
        String description=null;
        if (e instanceof MismatchedTokenException){
          MismatchedTokenException mte = (MismatchedTokenException) e;
            String found = (mte.token != null ) ? mte.token.getText() : "null";
            String expecting = (mte.expecting < AadlBaParser.tokenNames.length && mte.expecting >=0) ? 
                AadlBaParser.tokenNames[mte.expecting] : "null";
            description = "Expecting: "+expecting+", found: "+found;
        } else if (e instanceof MismatchedTreeNodeException){
          description = "Unexpected Tree Node Exception";
        } else if (e instanceof NoViableAltException){
          NoViableAltException nva = (NoViableAltException) e;
          description = "No viable alternative: "+nva.grammarDecisionDescription;
        } else if (e instanceof EarlyExitException){
          EarlyExitException ee = (EarlyExitException) e;
          description = "Early Exit";
        } else if (e instanceof FailedPredicateException){
          FailedPredicateException fp = (FailedPredicateException)e;
          description = "Semantic error: "+fp.predicateText;
        } else if (e instanceof MismatchedRangeException){
          MismatchedRangeException mr = (MismatchedRangeException)e;
          description = "Mismatched range: ";
        } else if (e instanceof MismatchedSetException){
          MismatchedSetException ms = (MismatchedSetException)e;
          description = "Mismatched set";
        } else if (e instanceof MismatchedNotSetException){
          description="Mismatched of inverse of a set";
        } 
        description += " at line " + e.line + " col " + e.charPositionInLine ;
        //TODO : remove clean code.
        System.err.println(description);
        errReporter.error(this.getFilename(), e.line, description);
  }
  
  public String getFilename(){
    return filename;
  }
  
}

// AADL Behavior Annex Tokens
// Keywords

ABS            : 'abs';
AND            : 'and';
ANY            : 'any';
CATCH          : 'catch';
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
MOD            : 'mod';
NOT            : 'not';
ON             : 'on';
OR             : 'or';
OTHERWISE      : 'otherwise';
VARIABLES      : 'variables';
REM            : 'rem';
STATE          : 'state';
STATES         : 'states';
STOP           : 'stop';
TIMEOUT        : 'timeout';
TRANSITIONS    : 'transitions';
TRUE           : 'true';
UNTIL          : 'until';
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

//  Grammar

//---------------------------------------------------------
//---------------------------------------------------------
// BEGIN : ANNEX D.3 Behavior Specification
//---------------------------------------------------------

// behavior_annex ::=
//   [ variables { behavior_variable }+ ]
//   [ states { behavior_state }+ ]
//   [ transitions { behavior_transition }+ ]
behavior_annex returns [BehaviorAnnex BehAnnex] 
 @init{
   BehAnnex = _fact.createBehaviorAnnex();
   
   BehAnnex.setLocationReference(new LocationReference(this.getFilename(), input.get(0).getLine())) ; 
      
 }
  : 
   ( VARIABLES
       ( BehVar=behavior_variable { BehAnnex.getBehaviorVariables().add(BehVar);} )+
   )?
   
   ( STATES
       ( BehStat=behavior_state { BehAnnex.getBehaviorStates().add(BehStat); } )+
   )?
   
   ( TRANSITIONS 
       ( BehTrans=behavior_transition {BehAnnex.getBehaviorTransitions().add(BehTrans); } )+ 
   )?
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// behavior_variable ::= 
//   local_variable_declarator { , local_variable_declarator }* 
//   : data_unique_component_classifier_reference;
behavior_variable returns [BehaviorVariable BehVar]
 @init{
   BehVar = _fact.createBehaviorVariable();
 }
  :
   Decl=declarator { BehVar.getLocalVariableDeclarators().add(Decl); BehVar.setLocationReference(Decl.getLocationReference());}  
   ( COMMA Decl=declarator { BehVar.getLocalVariableDeclarators().add(Decl); } )* 
     COLON 
     DataClassRef=unique_component_classifier_reference
     {
        BehVar.setDataUniqueComponentClassifierReference(DataClassRef);
     }
     SEMICOLON
;
catch [RecognitionException ex] {
  reportError(ex);
  
  consumeUntil(input,SEMICOLON);
  input.consume();
}

  
// unique_component_classifier_reference ::= 
//   { package_identifier :: }* component_type_identifier
//   [ . component_implementation_identifier ]
unique_component_classifier_reference returns [UniqueComponentClassifierReference DataClassRef]
 @init{
   DataClassRef = _fact.createUniqueComponentClassifierReference();
   String id1 = "";
   String id2 = "";
 }
  :
   (
    ( identifier1=IDENT DOUBLECOLON { id1=id1+(id1.length() == 0 ? "":"::")+identifier1.getText(); } )*
      identifier2=IDENT { id2=identifier2.getText(); }
    ( DOT identifier3=IDENT { id2=id2+"."+identifier3.getText(); } )?
   )
   {
    DataClassRef.setName(id2);
    
    if (! id1.equals(""))
    {
      DataClassRef.setNamespace(id1);
      DataClassRef.setQualifiedName(id1+"::"+id2);
      DataClassRef.setNamespaceSeparator("::");
    }
    else
    {
      DataClassRef.setQualifiedName(id2);
    } 
    setLocationReference(DataClassRef, identifier2); 
   }
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// behavior_state ::=
//   behavior_state_identifier { , behavior_state_identifier }* 
//   : behavior_state_kind state;

// behavior_state_kind ::=
//   [ initial ][ complete ][ final ]
behavior_state returns [BehaviorState BehStat]
 @init{
   BehStat = _fact.createBehaviorState();
 }
  :
    identifier=IDENT 
     {
        Identifier Id = _fact.createIdentifier();
        Id.setId(identifier.getText());
        setLocationReference(Id, identifier); 
        BehStat.getIdentifiers().add(Id);
        BehStat.setLocationReference(Id.getLocationReference()) ; 
      } 
   ( COMMA identifier=IDENT 
     {
      Identifier Id = _fact.createIdentifier();
      Id.setId(identifier.getText());
      setLocationReference(Id, identifier); 
      BehStat.getIdentifiers().add(Id);
     } 
   )*
   COLON 
   (
     (INITIAL  { BehStat.setInitial(true)  ; } )? 
     (COMPLETE { BehStat.setComplete(true) ; } )?
     (FINAL    { BehStat.setFinal(true)    ; } )?
   )
   STATE SEMICOLON
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// behavior_transition ::=
//   [ transition_identifier [ [ behavior_transition_priority ] ] : ]
//   source_state_identifier { , source_state_identifier }* 
//    -[ behavior_condition ]->
//   destination_state_identifier [ behavior_action_block ] ;

// behavior_transition_priority ::= numeral
behavior_transition returns [BehaviorTransition BehTrans]
 @init{
   BehTrans = _fact.createBehaviorTransition();
 }
  :
   ( identifier=IDENT 
     {
      Identifier Id = _fact.createIdentifier();
      Id.setId(identifier.getText());
      setLocationReference(Id, identifier); 
      BehTrans.setTransitionIdentifier(Id);
      BehTrans.setLocationReference(Id.getLocationReference()) ; 
     } // SG XXX as no behaviour transition priority object is provided, numeral location reference is set in numeral method
     ( LBRACK Num=numeral RBRACK { BehTrans.setBehaviorTransitionPriority(Num);} )? 
     COLON
   )?  
   
   identifier=IDENT 
   { 
    Identifier Id = _fact.createIdentifier();
    Id.setId(identifier.getText());
    setLocationReference(Id, identifier); 
    BehTrans.getSourceStateIdentifiers().add(Id);
    BehTrans.setLocationReference(Id.getLocationReference()) ; 
   }
   
   ( COMMA identifier=IDENT 
     { 
      Identifier Id = _fact.createIdentifier();
      Id.setId(identifier.getText());
      setLocationReference(Id, identifier); 
      BehTrans.getSourceStateIdentifiers().add(Id);
     } 
   )*
   
   ( identifier=LTRANS BehCond=behavior_condition
     { 
       if (BehCond != null) // If no behavior condition is specified, behavior_condition is not call so BehCond is null.
       {
         BehTrans.setBehaviorConditionOwned(BehCond);
         setLocationReference(BehCond, identifier) ; 
       }
     } 
     RTRANS
   )
    
   identifier=IDENT 
   {
     Identifier Id = _fact.createIdentifier();
     Id.setId(identifier.getText());
     setLocationReference(Id, identifier); 
     BehTrans.setDestinationStateIdentifier(Id);
   }
    
   ( BehActionBlock=behavior_action_block 
        { BehTrans.setBehaviorActionBlockOwned(BehActionBlock); }
   )? 
       
   SEMICOLON
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// behavior_action_block ::=
// { behavior_actions } [ timeout behavior_time]
behavior_action_block returns [BehaviorActionBlock BehActionBlock]
 @init{
         BehActionBlock = _fact.createBehaviorActionBlock() ;
 }
  : identifier=LCURLY BehActions=behavior_actions RCURLY 
    {
       BehActionBlock.setBehaviorActionsOwned(BehActions) ;
       setLocationReference(BehActionBlock, identifier);
    }
      
    ( TIMEOUT BehTime=behavior_time
      {
        BehActionBlock.setBehaviorTimeOwned(BehTime) ;
      }
    )?
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// behavior_condition ::= 
//   dispatch_condition
// | execute_condition
behavior_condition returns [BehaviorCondition BehCond]
 @init{
 }
  :
   (
     ON DisCond=dispatch_condition
   |
     ( ExecCond=execute_condition )?
   )
   {
    if (DisCond != null){
      BehCond = DisCond;
    } 
    else{
      BehCond = ExecCond;
    }
   }
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

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
execute_condition returns [ExecuteCondition ExecCond]
 @init
 {
    ExecCond= null ;
 }
  : // Location reference is set in behavior_transition
   ( 
       identifier=TIMEOUT
       {
         ExecCond = _fact.createTimeoutCatch();
         setLocationReference(ExecCond, identifier);
       }
     |
       identifier=OTHERWISE
       {
         ExecCond = _fact.createOtherwise() ;
         setLocationReference(ExecCond, identifier);
       }
     |       
       ValExpr=value_expression
       { 
         ExecCond = ValExpr ;
       }
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// declarator ::= identifier { array_size }*
// array_size :: [ integer_value_constant ]
declarator returns [Declarator Decl]
 @init{
   Decl = _fact.createDeclarator();
 }
  :
   identifier=IDENT { 
                      setLocationReference(Decl, identifier);
                      Identifier Id = _fact.createIdentifier() ;
                      Id.setId(identifier.getText());
                      setLocationReference(Id, identifier);
                      Decl.setIdentifierOwned(Id);
                    }
   ( LBRACK IntValue=value_constant RBRACK
       { 
         Decl.getArraySizes().add(IntValue); 
       }
   )*
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
//   in_port_identifier { , in_port_identifier }*

dispatch_condition returns [DispatchCondition DisCond]
 @init{
   DisCond = _fact.createDispatchCondition (); // Location reference is set in behavior_transition
 }
  :
   DISPATCH 
   ( DisTriggCond=dispatch_trigger_condition
     {
       DisCond.setDispatchTriggerConditionOwned (DisTriggCond);
     }
   )? 
  
   ( FROZEN identifier=IDENT 
     {
      Identifier Id = _fact.createIdentifier();
      Id.setId(identifier.getText());
      setLocationReference(Id, identifier); 
      DisCond.getFrozenPorts().add(Id); 
     }
    ( COMMA identifier=IDENT
      {
       Identifier Id = _fact.createIdentifier();
       Id.setId(identifier.getText());
       setLocationReference(Id, identifier); 
       DisCond.getFrozenPorts().add(Id);
      }
    )*
   )?
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// dispatch_trigger_condition ::=
// dispatch_trigger_logical_expression
// | provides_subprogram_access_identifier
// | stop
// | completion_relative_timeout_condition_and_catch
// | dispatch_relative_timeout_catch

// completion_relative_timeout_condition_and_catch ::=
// timeout behavior_time

// dispatch_relative_timeout_catch ::=
// timeout
dispatch_trigger_condition returns [DispatchTriggerCondition DisTriggCond]
 @init{
   DisTriggCond = null ;
 }
   : // Ambiguity between subprogram access identifier and a dispatch trigger !
     // A dispatch trigger logical expression with only one
     // dispatch conjunction which is only one dispatch trigger (a identifier)
     // can't be distinguish from a subprogram access identifier.
     // subprogram access identifiers are parsed as dispatch trigger logical
     // expression
       identifier=STOP
       { DisTriggCond = _fact.createDispatchTriggerConditionStop() ;
         setLocationReference(DisTriggCond, identifier) ;
       }
     |
       ( identifier=TIMEOUT
         { DisTriggCond = _fact.createTimeoutCatch() ;
           setLocationReference(DisTriggCond, identifier) ;
         }     
         (
           BehTime=behavior_time
           { 
             CompletionRelativeTimeoutConditionAndCatch crtcac =
               _fact.createCompletionRelativeTimeoutConditionAndCatch();
             crtcac.setIntegerValueOwned(BehTime.getIntegerValueOwned()) ;
             crtcac.setUnitIdentifier(BehTime.getUnitIdentifier());
             DisTriggCond = crtcac ;
             setLocationReference(DisTriggCond, identifier) ;
           }
         )?
       )
     | // Ambiguous case.
       DisTriggLogicalExpr=dispatch_trigger_logical_expression
       {
         DisTriggCond = DisTriggLogicalExpr ;
       }
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// dispatch_trigger_logical_expression ::=
// dispatch_conjunction { or dispatch_conjunction }*
dispatch_trigger_logical_expression returns [DispatchTriggerLogicalExpression
                                             DisTriggLogicalExpr]
 @init{
   DisTriggLogicalExpr = _fact.createDispatchTriggerLogicalExpression ();
 }
   : 
     DisConjunct=dispatch_conjunction
     {
       DisTriggLogicalExpr.getDispatchConjunctions().add(DisConjunct) ;
       DisTriggLogicalExpr.setLocationReference(
         DisConjunct.getLocationReference());
     }
     (
       OR DisConjunct=dispatch_conjunction
       {
         DisTriggLogicalExpr.getDispatchConjunctions().add(DisConjunct) ;
       }
     )*
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// dispatch_conjunction ::=
// dispatch_trigger { and dispatch_trigger }*

// dispatch_trigger ::=
// in_event_port_identifier
// | in_event_data_port_identifier
dispatch_conjunction returns [DispatchConjunction DisConjunct]
 @init{
   DisConjunct = _fact.createDispatchConjunction ();
 }
   :
     identifier=IDENT
     {
       Identifier Id = _fact.createIdentifier();
       Id.setId(identifier.getText());
       setLocationReference(Id, identifier);
       DisConjunct.getDispatchTriggers().add(Id) ;
       DisConjunct.setLocationReference(Id.getLocationReference());
     }
     (
       AND identifier=IDENT
       {
         Identifier Id = _fact.createIdentifier();
         Id.setId(identifier.getText());
         setLocationReference(Id, identifier);
         DisConjunct.getDispatchTriggers().add(Id) ;
       }
     )*
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

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
behavior_actions returns [BehaviorActions BehActs]
 @init{
   BehActs = null ;
   EList<BehaviorAction> tmpList = new BasicEList() ;
   BehaviorActionCollection col = null ;
 }
  :
   BehAction=behavior_action
   {
     BehActs = BehAction ;
   }

   (   
        ( SEMICOLON BehAction2=behavior_action
            {
              tmpList.add(BehAction2) ;
            }
        )*
        { col = _fact.createBehaviorActionSequence() ; } 
      |
        ( CONCAT BehAction2=behavior_action
            {
              tmpList.add(BehAction2) ;
            }
        )*
        { col = _fact.createBehaviorActionSet() ; } 
   )
   {
      if (tmpList.size() != 0)
      { 
        col.getBehaviorActions().add(BehAction);
        col.getBehaviorActions().addAll(tmpList);
        col.setLocationReference(BehActs.getLocationReference());
        BehActs = col ;
      }
   } 
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

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
behavior_action returns [BehaviorAction BehAction]
 @init{
   BehAction = null;
   IfStatement IfStat = null ;
   ForOrForAllStatement ForStat = null ;
 }
  :
   ( 
     ( BaAct=basic_action
       { BehAction = BaAct ;}
     )
   | 
     ( BehActionBlock=behavior_action_block
       { 
          BehAction = BehActionBlock ;
       }
     )
   |
     // If statement.
     ( identifier1=IF identifier2=LPAREN ValExpr=value_expression RPAREN BehActions=behavior_actions 
       { 
         IfStat = _fact.createIfStatement();
         setLocationReference(IfStat, identifier1); 
         setLocationReference(ValExpr, identifier2); 
         IfStat.getLogicalValueExpressions().add(ValExpr) ;
         IfStat.getBehaviorActionsOwned().add(BehActions);
       }
       ( 
         identifier1=ELSIF identifier2=LPAREN ValExpr=value_expression RPAREN BehActions=behavior_actions
         {
           setLocationReference(ValExpr, identifier2) ; 
           IfStat.getLogicalValueExpressions().add(ValExpr) ;
           IfStat.getBehaviorActionsOwned().add(BehActions);
         }
       )*
       (
         identifier=ELSE BehActions=behavior_actions
         {
           IfStat.setHasElse(true);
           IfStat.getBehaviorActionsOwned().add(BehActions);
         }
       )?
       END IF
       { 
         BehAction = IfStat ;
       }
     )
   |
     //For statement.
     ( identifier=FOR LPAREN { ForStat = _fact.createForOrForAllStatement(); 
                               setLocationReference(ForStat, identifier); 
                             } 
       identifier=IDENT {  
                           Identifier Id = _fact.createIdentifier();
                           Id.setId(identifier.getText());
                           setLocationReference(Id, identifier);
                           ForStat.setElementIdentifier(Id);
                        }
       COLON dt=unique_component_classifier_reference
       {
         ForStat.setDataUniqueComponentClassifierReference(dt);
       }
       
       IN EltVal=element_values RPAREN { ForStat.setElementValuesOwned(EltVal); }
       identifier=LCURLY BehActions=behavior_actions RCURLY 
       { ForStat.setBehaviorActionsOwned(BehActions);
         BehAction = ForStat ;
       }
     )
   |
     //Forall statement
     ( identifier=FORALL LPAREN 
       { 
        ForStat = _fact.createForOrForAllStatement();
        ForStat.setForAll(true);
        setLocationReference(ForStat, identifier); 
       }
       identifier=IDENT {  
                           Identifier Id = _fact.createIdentifier();
                           Id.setId(identifier.getText());
                           setLocationReference(Id, identifier);
                           ForStat.setElementIdentifier(Id);
                        }
       COLON dt=unique_component_classifier_reference 
       {
         ForStat.setDataUniqueComponentClassifierReference(dt);
       }
       
       IN EltVal=element_values RPAREN { ForStat.setElementValuesOwned(EltVal); }
       identifier=LCURLY BehActions=behavior_actions RCURLY
       { ForStat.setBehaviorActionsOwned(BehActions) ;
         BehAction = ForStat ;
       }
     )
   |
     //While statement.
     ( identifier1=WHILE identifier2=LPAREN ValExpr=value_expression RPAREN 
       LCURLY BehActions=behavior_actions RCURLY 
       {
         WhileOrDoUntilStatement WhileStat = _fact.createWhileOrDoUntilStatement();
         setLocationReference(WhileStat, identifier1); 
         setLocationReference(ValExpr, identifier2) ;
         WhileStat.setDoUntil(false);
         WhileStat.setLogicalValueExpression(ValExpr);
         WhileStat.setBehaviorActionsOwned(BehActions);
         BehAction = WhileStat ; 
       }
     )
   |
     //Do until statement.
     ( identifier1=DO BehActions=behavior_actions UNTIL  
       identifier2=LPAREN ValExpr=value_expression RPAREN 
       {
         WhileOrDoUntilStatement doUntilStat = _fact.createWhileOrDoUntilStatement();
         setLocationReference(doUntilStat, identifier1); 
         setLocationReference(ValExpr, identifier2) ;
         doUntilStat.setDoUntil(true);
         doUntilStat.setLogicalValueExpression(ValExpr);
         doUntilStat.setBehaviorActionsOwned(BehActions);
         BehAction = doUntilStat ;
       }
     )
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// element_values ::=
//   integer_range
// | event_data_port_name
// | array_data_component_reference
element_values returns [ElementValues EltVal]
 @init{
 }
  : // Ambiguity between event data port name and unqualified data component 
    // reference. See uDCR.
     ( IntRange=integer_range { EltVal = IntRange; } )
   |
     ( AdcRef=uDCR { EltVal = (ElementValues) AdcRef; } )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// basic_action ::=
//   assignment_action
// | communication_action
// | timed_action
basic_action returns [BasicAction BaAction]
 @init{
}
  :
     ( AssAct=assignment_action { BaAction = AssAct; } )
   |
     ( CommAct=communication_action { BaAction = CommAct; } )
   |
     ( TimedAct=timed_action { BaAction = TimedAct; } )
     
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// assignment_action ::= 
//   target := ( value_expression | any )
assignment_action returns [AssignmentAction AssAct]
 @init{
   AssAct = _fact.createAssignmentAction();
 }
  :
   Tar=target ASSIGN ( ValExpr=value_expression | ANY )
   {
     AssAct.setLocationReference(Tar.getLocationReference());
     AssAct.setTargetOwned(Tar);
     

       
     if (ValExpr != null)
     {
       AssAct.setValueExpressionOwned(ValExpr);
     }
     else
     {
       AssAct.setAny(true);
     }
   }
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// target ::= 
//   local_variable_name 
// | outgoing_port_name 
// | outgoing_parameter_name 
// | data_component_reference
target returns [Target Tar]
 @init{
   Tar = null ;
 }
  : // Ambiguity between a name and a unqualified data component reference.
    // See uDCR.
    dt=uDCR {Tar= (Target) dt ;} 
                                         
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// communication_action ::= 
//   subprogram_prototype_name ! [ ( subprogram_parameter_list ) ]
// | required_subprogram_access_name ! [ ( subprogram_parameter_list ) ]
// | subprogram_classifier_name ! [ ( subprogram_parameter_list ) ]
// | required_data_access_name.provided_subprogram_access_name ! [ ( subprogram_parameter_list ) ]
// | output_port_name ! [ ( value_expression ) ]
// | input_port_name >>
// | input_port_name ? [ ( target ) ]
// | required_data_access_name !<
// | required_data_access_name !>
// | *!<
// | *!>
communication_action returns [CommunicationAction ca]
 @init{
   ca = null ;
   SubprogramCallAction sca = null ;
   PortDequeueAction pda = null ;
   Name SubName = null ;
 }
  : // Ambiguity between name without array indexes and unqualified
    // subprogram unique component classifier reference without component
    // implementation.
    // unqualified subprogram unique component classifier reference 
    // without component are parsed as name.
        
    // Ambiguity between value expression and a subprogram parameter list
    // with only one parameter label which is a value expression or a target.
    // value expressions are parsed as subprogram parameter list
    // with only one parameter label.
    
    // Ambiguity between name.name without array index and unqualified
    // unique component classifier reference with component implementation.
    // these uccr are parsed as name.name
  (  
      (
        EltName=name
        (   
            ( 
              ( DOT tmp=name
                {
                  SubName = tmp ;
                }
              )?
              EXCLAM
              { 
                sca = _fact.createSubprogramCallAction();
                sca.getSubprogramNames().add(EltName);
                if(SubName != null ) sca.getSubprogramNames().add(SubName);
                ca = sca ;
              }
              ( 
                LPAREN SubpgmParamList=subprogram_parameter_list RPAREN
                {
                  sca.getParameterLabels().addAll(SubpgmParamList);
                }
              )?
            )
          |
            (
              INTERROG
              {
                pda = _fact.createPortDequeueAction();
                pda.setPortName(EltName);
                ca = pda;
              }
              (
                LPAREN Tar=target RPAREN
                {
                  pda.setTargetOwned(Tar);
                }
              )?
            )
          |
            (
              GGREATER
              { 
                PortFreezeAction pfa = _fact.createPortFreezeAction() ;
                pfa.setIdentifierOwned(EltName.getIdentifierOwned());
                pfa.getArrayIndexes().addAll(EltName.getArrayIndexes());
                pfa.setLocationReference(EltName.getLocationReference());
                ca = pfa ;
              }
            )
          |
            (
              EXCLLESS
              {
                LockAction la = _fact.createLockAction();
                la.setDataAccessName(EltName);
                ca = la ;
              }
            )
          |
            (
              EXCLGREATER
              {
                UnlockAction ula = _fact.createUnlockAction();
                ula.setDataAccessName(EltName);
                ca = ula ;
              }
            )
        )
        { 
          ca.setLocationReference(EltName.getLocationReference());
        }
      )
    |
      (
        SubprogramClassRef=unique_component_classifier_reference EXCLAM
        {
          sca = _fact.createSubprogramCallAction();
          sca.setSubprogramReference(SubprogramClassRef);
          sca.setLocationReference(SubprogramClassRef.getLocationReference());
          ca = sca ;
        }
        ( 
          LPAREN SubpgmParamList=subprogram_parameter_list RPAREN
          {
            sca.getParameterLabels().addAll(SubpgmParamList);
          }
        )?
      )
    |
      (
        identifier=STAR
        ( 
            EXCLLESS
            {
              LockAction la = _fact.createLockAction();
              ca = la ;
            }
          | 
            EXCLGREATER
            {
              UnlockAction ula = _fact.createUnlockAction();
              ca = ula ;
            }
        )
        {
          setLocationReference(ca, identifier);
        }
      )
  )  
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// timed_action ::= 
//   computation ( behavior_time [ .. behavior_time ] )
timed_action returns [TimedAction TimedAct]
 @init{
   TimedAct = _fact.createTimedAction();
 }
  :
   ( identifier=COMPUTATION {setLocationReference(TimedAct, identifier) ; }  
   )  
   LPAREN
     BehTime=behavior_time {TimedAct.setLowerBehaviorTime(BehTime); }
     (DOTDOT BehTime=behavior_time {TimedAct.setUpperBehaviorTime(BehTime);}
     ) ?
   RPAREN
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// subprogram_parameter_list ::=
//   parameter_label { , parameter_label }*
subprogram_parameter_list returns [EList<ParameterLabel> SpgParamList]
 @init{
   SpgParamList = new BasicEList<ParameterLabel>();
 }
  : 
   ParamLabel=parameter_label { SpgParamList.add(ParamLabel);} 
   (identifier=COMMA ParamLabel=parameter_label { SpgParamList.add(ParamLabel);
                                                  if( ParamLabel.getLocationReference() == null) // SG case of an ValueExpr else Target is already set
                                                  {
                                                     setLocationReference(ParamLabel, identifier) ; 
                                                  }
                                                } )*
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// parameter_label ::=
//   in_parameter_value_expression | out_parameter_target
parameter_label returns [ParameterLabel ParamLabel]
 @init{
 }
  : // Ambiguity between a value expression with a single value and target.
    // The ambiguity is based on name and data component name on both side.
    // Targets are parsed as value expression.
    
   ( 
       ValExpr=value_expression { ParamLabel = ValExpr; }
   )   
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// uDCR ::=
//   name | data component reference
uDCR returns [BehaviorElement uDCR]
 @init{
   uDCR = null ;
   DataComponentReference DataCmpRef = null ;
 }
  : // Ambiguity. Unqualified data component references are parsed as name.
   EltName=name 
   ( 
     DOT SubName=name
     { 
       DataCmpRef = _fact.createDataComponentReference() ;
       DataCmpRef.setLocationReference(EltName.getLocationReference());
       DataCmpRef.getNames().add(EltName);
       DataCmpRef.getNames().add(SubName);
       uDCR = DataCmpRef ;
     }
     (
       DOT SubName=name {DataCmpRef.getNames().add(SubName);}
     )*
   )?
   {
     if(uDCR == null)
     {
       uDCR = EltName ;
     }
   }
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// name ::= identifier { array_index }*
// array_index :: [ integer_value_variable ]
name returns [Name EltName]
 @init{
   EltName = _fact.createName();
 }
  :
   identifier=IDENT { Identifier Id = _fact.createIdentifier() ;
                      Id.setId(identifier.getText());    
                      EltName.setIdentifierOwned(Id) ;
                      setLocationReference(Id, identifier); 
                      setLocationReference(EltName, identifier) ;
                    } 
   ( identifier=LBRACK Val=value_variable RBRACK
     {
       EltName.getArrayIndexes().add(Val);
     }
   )*
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

//---------------------------------------------------------
// END : ANNEX D.6 Behavior Action Language
//---------------------------------------------------------
//---------------------------------------------------------

//---------------------------------------------------------
//---------------------------------------------------------
// BEGIN : ANNEX D.7 Behavior Expression Language
//---------------------------------------------------------

fact_value returns [Value Val]
@init
 {
   Val = null ;
 }
  : // Ambiguity between value variable (name without array index) and
    // unqualified propertyset constant or unqualified propertyset value.
    // unqualified propertyset are parsed as name without array index.
   (
       // Case of property constant or value.
       (  
          id1=IDENT DOUBLECOLON id2=IDENT
          {
            BehaviorPropertyConstant PropertyCst = _fact.
                                               createBehaviorPropertyConstant();
                        
            PropertyCst.setNamespace(id1.getText());
            setLocationReference(PropertyCst, id1) ;
            PropertyCst.setNamespaceSeparator("::");
            
            PropertyCst.setName(id2.getText());
            
            String qName = PropertyCst.getNamespace() + 
              PropertyCst.getNamespaceSeparator() + PropertyCst.getName() ;
            PropertyCst.setQualifiedName(qName) ;

            Val = PropertyCst ;
          }
       )
     | 
       ValueVar=value_variable { Val = ValueVar ;}

     | // Cases from value constant category. 
       bl=boolean_literal { Val = bl;}
     |
       nl=numeric_literal { Val = nl;}
     |
       st=string_literal  { Val = st;}
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}  

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
value returns [Value Val]
 @init{
 }
  :
   (
       ( ValTmp=fact_value ) {Val = ValTmp;}
     |
       ( identifier=LPAREN ValExpr=value_expression RPAREN
          { setLocationReference(ValExpr, identifier) ; Val = ValExpr; }
       )
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// value_variable ::=
//   incoming_port_name
// | incoming_port_name ?
// | subprogram_parameter_name
// | local_variable_name
// | data_component_reference
// | port_name' count
// | port_name' fresh
value_variable returns [ValueVariable ValueVar]

 @init{
   ValueVar = null ;
   DataComponentReference DataCmpRef = null ;
 }
  : // Ambiguity between an unqualified data component reference and a single name
    // value variables. unqualified data component references are parsed as name. 
    
   EltName=name
   (
       INTERROG
       {
         PortDequeueValue pdv = _fact.createPortDequeueValue();
         nameCopy(EltName, pdv);
         ValueVar = pdv ;
       }
     |
       TICK (
                COUNT 
                { 
                  PortCountValue pcv = _fact.createPortCountValue();
                  nameCopy(EltName, pcv);
                  ValueVar = pcv ;
                } 
              | 
                FRESH
                {
                  PortFreshValue pfv = _fact.createPortFreshValue();
                  nameCopy(EltName, pfv);
                  ValueVar = pfv ;
                }
            )
     |  
       ( 
         DOT SubName=name
         {
           DataCmpRef = _fact.createDataComponentReference();
           DataCmpRef.getNames().add(EltName);
           DataCmpRef.getNames().add(SubName);
           DataCmpRef.setLocationReference(EltName.getLocationReference());
           ValueVar = DataCmpRef ;
         }
         (
           DOT SubName=name
           {
             DataCmpRef.getNames().add(SubName);
           }
         )*
       )
   )?
   {
     if(ValueVar == null)
     {
       ValueVar = EltName;
     }
   }
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// value_constant ::= 
//   boolean_literal
// | numeric_literal 
// | string_literal 
// | property_constant
// | property_value
value_constant returns [ValueConstant ValueCons]
 @init{
 }
  : // Ambiguity between propertyset constant and propertyset value.
    // propertyset values are parsed as propertyset constants.
   ( 
       bl=boolean_literal { ValueCons = bl; }
     |
       nl=numeric_literal { ValueCons = nl; }
     |
       st=string_literal { ValueCons = st; }
     |
       // Ambiguous case.
       ProperCst=property_constant {ValueCons = ProperCst;}
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

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
value_expression returns [ValueExpression ValueExpr]
 @init{
   ValueExpr = _fact.createValueExpression();
 }
  :
   ( 
     Rel=relation
     { ValueExpr.getRelations().add(Rel);
       ValueExpr.setLocationReference(Rel.getLocationReference());
     }
     (
       LogicalOp=logical_operator Rel=relation
       {
        ValueExpr.getLogicalOperators().add(LogicalOp);
        ValueExpr.getRelations().add(Rel);
       }
     )* 
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// relation ::=
//   simple_expression [ relational_operator simple_expression ]
relation returns [Relation Rel]
 @init{
   Rel = _fact.createRelation();
 }
  :
   SimpleExpr=simple_expression
   { Rel.setSimpleExpressionOwned(SimpleExpr);
     Rel.setLocationReference(SimpleExpr.getLocationReference());  
   }
   (
     RelationalOp=relational_operator SimpleExpr=simple_expression 
     {
      Rel.setRelationalOperatorOwned(RelationalOp);
      Rel.setSimpleExpressionSdOwned(SimpleExpr);
     }
   )?
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// simple_expression ::= 
//   [ unary_adding_operator ] term { binary_adding_operator term }*
simple_expression returns [SimpleExpression SimpleExpr]
 @init{
   SimpleExpr = _fact.createSimpleExpression();
 }
  :
   (
     UnaryAddOp=unary_adding_operator 
     {
      SimpleExpr.setUnaryAddingOperatorOwned(UnaryAddOp);
     }
   )?
   
   tm=term
   { 
     SimpleExpr.getTerms().add(tm);
     SimpleExpr.setLocationReference(tm.getLocationReference());
   }
   
   (
     BinaryAddOp=binary_adding_operator tm=term
     {
      SimpleExpr.getBinaryAddingOperators().add(BinaryAddOp);
      SimpleExpr.getTerms().add(tm);
     } 
   )*
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// term ::= 
//   factor { multiplying_operator factor }*
term returns [Term tm]
 @init{
   tm = _fact.createTerm();
 }
  :
   fact=factor
   { tm.getFactors().add(fact);
     tm.setLocationReference(fact.getLocationReference());
   }
   (
     MultiplyingOp=multiplying_operator fact=factor
     {
      tm.getMultiplyingOperators().add(MultiplyingOp);
      tm.getFactors().add(fact);
     } 
   )*
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// factor ::= 
//   value [ binary_numeric_operator value ] 
// | unary_numeric_operator value 
// | unary_boolean_operator value
factor returns [Factor Fact]
 @init{
   Fact = _fact.createFactor();
 }
  :
   (
    ( val=value {
                  Fact.setLocationReference(val.getLocationReference()) ;
                  Fact.setValueOwned(val);
                } 
      (
        BinaryNumOp=binary_numeric_operator val2=value
        {
          Fact.setBinaryNumericOperatorOwned(BinaryNumOp);
          Fact.setValueSdOwned(val2);
        }
      )?
    )
   |
    ( UnaryNumOp=unary_numeric_operator val=value
      {
         Fact.setUnaryNumericOperatorOwned(UnaryNumOp);
         Fact.setValueOwned(val);
         Fact.setLocationReference(val.getLocationReference()) ;
      }
    )
   |
    ( UnaryBoolOp=unary_boolean_operator val=value
      {
         Fact.setUnaryBooleanOperatorOwned(UnaryBoolOp);
         Fact.setValueOwned(val);
         Fact.setLocationReference(val.getLocationReference()) ;
      }
    )
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// logical_operator ::= and | or | xor
logical_operator returns [LogicalOperator LogicalOp]
 @init{
 // TODO location reference
   LogicalOp = null;
 }
  :
   (
     AND { LogicalOp=LogicalOperator.AND; }
   |
     OR { LogicalOp=LogicalOperator.OR; }
   |
     XOR { LogicalOp=LogicalOperator.XOR; }
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// relational_operator ::= = | != | < | <= | > | >=
relational_operator returns [RelationalOperator RelationalOp]
 @init{
 // TODO location reference
   RelationalOp = null;
 }
  :
   (
     EQUAL { RelationalOp = RelationalOperator.EQUAL; }
   |
     NOTEQUAL { RelationalOp = RelationalOperator.NOT_EQUAL; }
   |
     LESSTHAN { RelationalOp = RelationalOperator.LESS_THAN; }
   |
     LESSOREQUAL { RelationalOp = RelationalOperator.LESS_OR_EQUAL_THAN; }
   |
     GREATERTHAN { RelationalOp = RelationalOperator.GREATER_THAN; }
   |
     GREATEROREQUAL { RelationalOp = RelationalOperator.GREATER_OR_EQUAL_THAN; }  
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// binary_adding_operator ::= + | - 
binary_adding_operator returns [BinaryAddingOperator BinaryAddOp]
 @init{
 // TODO location reference
   //BinaryAddOp = _fact.createBinaryAddingOperator();
 }
  :
   (
     PLUS { BinaryAddOp = BinaryAddingOperator.PLUS; }
   |
     MINUS { BinaryAddOp = BinaryAddingOperator.MINUS; }
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// unary_adding_operator ::=  + | -
unary_adding_operator returns [UnaryAddingOperator UnaryAddOp]
 @init{
 // TODO location reference
 }
  :
   (
     PLUS { UnaryAddOp = UnaryAddingOperator.PLUS; }
   |
     MINUS { UnaryAddOp = UnaryAddingOperator.MINUS; }
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// multiplying_operator ::=  * | / | mod | rem
multiplying_operator returns [MultiplyingOperator MultiplyingOp]
 @init{
 // TODO location reference
  // MultiplyingOperator MultiplyingOp = null;
 }
  :
   (
     STAR { MultiplyingOp = MultiplyingOperator.MULTIPLY; }
   |
     DIVIDE { MultiplyingOp = MultiplyingOperator.DIVIDE; }
   |
     MOD { MultiplyingOp = MultiplyingOperator.MOD; }
   |
     REM { MultiplyingOp = MultiplyingOperator.REM; }
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// binary_numeric_operator ::= **
binary_numeric_operator returns [BinaryNumericOperator BinaryNumOp]
 @init{
 // TODO location reference
   //BinaryNumericOperator BinaryNumOp = null;
 }
  :
   STARSTAR { BinaryNumOp = BinaryNumericOperator.MULTIPLY_MULTIPLY; }
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// unary_numeric_operator ::= abs
unary_numeric_operator returns [UnaryNumericOperator UnaryNumOp]
 @init{
 // TODO location reference
   //UnaryNumericOperator UnaryNumOp = null;
 }
  :
   ABS { UnaryNumOp = UnaryNumericOperator.ABS; }
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// unary_boolean_operator ::= not
unary_boolean_operator returns [UnaryBooleanOperator UnaryBoolOp]
 @init{
 // TODO location reference
   //UnaryBooleanOperator UnaryBoolOp = null;
 }
  :
   NOT { UnaryBoolOp = UnaryBooleanOperator.NOT; }
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// boolean_literal ::= true | false
boolean_literal returns [BooleanLiteral BoolLit]
 @init{
   BoolLit = _fact.createBooleanLiteral();
 }
  :
   (
     identifier=TRUE { BoolLit.setValue(true);}
   |
     identifier=FALSE { BoolLit.setValue(false);}
   )
   {setLocationReference(BoolLit, identifier) ;} 
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// integer_range ::= integer_value .. integer_value
integer_range returns [IntegerRange IntRange]
 @init{
   IntRange = _fact.createIntegerRange();
 }
  :
   (
     IntValue=integer_value DOTDOT IntValue2=integer_value
     {
       IntRange.setLowerIntegerValue(IntValue);
       IntRange.setUpperIntegerValue(IntValue2);
       IntRange.setLocationReference(IntValue.getLocationReference());
     }
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// integer_value ::= 
//   integer_value_variable 
// | integer_value_constant
integer_value returns [IntegerValue IntVal]
 @init{
 }
  : // Ambiguity between integer value variable with one name and unqualified
    // propertyset constant or value from value constant. See value. 
   (
     ValTmp=fact_value { IntVal = (IntegerValue) ValTmp ;}              
   )
   
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// behavior_time ::= integer_value unit_identifier
behavior_time returns [BehaviorTime BehTime]
 @init{
   BehTime = _fact.createBehaviorTime();
 }
  :
   (
     IntValue=integer_value UnitIdent=IDENT
     {
       BehTime.setIntegerValueOwned(IntValue);
       Identifier Id = _fact.createIdentifier() ;
       Id.setId(UnitIdent.getText());
       setLocationReference(Id, UnitIdent) ;
       BehTime.setUnitIdentifier(Id);
       BehTime.setLocationReference(IntValue.getLocationReference()); 
     }
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// property_constant ::=
//   [ property_set_identifier :: ] property_constant_identifier
property_constant returns [BehaviorPropertyConstant PropertyCst]
 @init{
   PropertyCst = _fact.createBehaviorPropertyConstant();
 }
  :
   (
     ( PropertySetId=IDENT DOUBLECOLON
       {
         PropertyCst.setNamespace(PropertySetId.getText());
         setLocationReference(PropertyCst, PropertySetId) ;
         PropertyCst.setNamespaceSeparator("::");
       }
     )?
       
     PropertyCstId=IDENT
     { PropertyCst.setName(PropertyCstId.getText());
       if(PropertyCst.getNamespace() == null)
       {
         PropertyCst.setQualifiedName(PropertyCst.getName());
       }
       else
       {
         String qName = PropertyCst.getNamespace() + 
           PropertyCst.getNamespaceSeparator() + PropertyCst.getName() ;
         PropertyCst.setQualifiedName(qName) ;
       }
       
       if (PropertyCst.getLocationReference() == null )  
       {
         setLocationReference(PropertyCst, PropertyCstId) ; 
       }
     }
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// numeric_literal ::= <refer to [AS5506A 15.4]>
// numeric literal without optional sign and unit
numeric_literal returns [NumericLiteral nl]
  @init { 
    nl=null;
    char sign = ' '; 
  }
  :
  (
    (realval=REAL_LIT
      {
        String str = realval.getText();
        RealLiteral tmp = _fact.createRealLiteral();
        tmp.setValueString(str);
        str = str.replaceAll("_", "") ;
        tmp.setValue(Double.parseDouble(str));
        setLocationReference(tmp, realval);
        nl = tmp ;
      }
    )
    |
    (integerval=INTEGER_LIT
      {
        try{
        String str = integerval.getText();
        IntegerLiteral tmp = _fact.createIntegerLiteral();
        tmp.setValueString(str);
        //str = str.replaceAll("_", "") ;
        long[] parsedInt = edu.cmu.sei.aadl.parser.AadlParseUtil.parseAadlInteger(str);
        tmp.setValue(parsedInt[1]);
        tmp.setBase((int) parsedInt[0]);
        setLocationReference(tmp, integerval);
        nl = tmp ;
        
        }
        catch (IllegalArgumentException e) {
        
          int line = integerval.getLine() ;
          int col = integerval.getCharPositionInLine() ; 
          String fileName = this.getFilename() ;
          RecognitionException ex = new RecognitionException() ;
          ex.line = line ;
          ex.charPositionInLine = col ;
          ex.input = input ;
          throw ex ;
        }
      }
    )
  ) 
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// string_literal ::= <refer to [AS5506A 15.5]>
string_literal returns [StringLiteral StringLit]
 @init{
   StringLit = _fact.createStringLiteral();
 }
  :
   (
     sl=STRING_LITERAL
      {
        String str = sl.getText();
        // stripout the quotes
        str = str.substring(1,str.length()-1);
        StringLit.setValue(str);
        setLocationReference(StringLit, sl); 
      }
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// numeral ::= <refer to [AS5506A 15.4.1]>
numeral returns [Numeral Num]
 @init{
   Num = _fact.createNumeral();
 }
  :
   ( 
     NumVal=INTEGER_LIT 
     { 
      
       String tmp = NumVal.getText().replaceAll("_", "");
       Num.setValue(Integer.parseInt(tmp));
       setLocationReference(Num, NumVal) ;
     } 
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


//---------------------------------------------------------
// END : ANNEX D.7 Behavior Expression Language
//---------------------------------------------------------
//---------------------------------------------------------


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
     {$channel=HIDDEN;}
;   
    
// Single-line comments
SL_COMMENT
  : '--'
(~('\n'|'\r' ))* {$channel=COMMENT_CHANNEL;}
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
