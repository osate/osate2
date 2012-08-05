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
//  k=*;
// language = Java;
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

  import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;  
  
  import org.osate.aadl2.parsesupport.AObject;
  import org.osate.aadl2.parsesupport.LocationReference;
  
  import org.osate.annexsupport.AnnexHighlighterPositionAcceptor ;
  
  import fr.tpt.aadl.annex.behavior.aadlba.*;
  import fr.tpt.aadl.annex.behavior.declarative.* ;
  import fr.tpt.aadl.annex.behavior.analyzers.DeclarativeUtils ;
  
  import fr.tpt.aadl.annex.behavior.texteditor.AadlBaHighlighter ;
  import fr.tpt.aadl.annex.behavior.texteditor.DefaultAadlBaHighlighter ;
  import fr.tpt.aadl.annex.behavior.utils.AadlBaLocationReference ;
  
  import org.osate.aadl2.Element ;
  import org.osate.aadl2.Aadl2Package ;
}
  
@lexer::header{
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
  
  package fr.tpt.aadl.annex.behavior.parser;
  
  import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;
}

@members {
  /**
  * Aadl Ba metamodel factory.
  */
  protected AadlBaFactory _fact = AadlBaFactory.eINSTANCE ;
  
  protected DeclarativeFactory _decl = DeclarativeFactory.eINSTANCE ;
  

  /**
   * The error reporter to use.
   */
  protected ParseErrorReporter errReporter = null;
  
  /**
   * The aadl filename to be parsed.
   */
  private String filename;
  
  private final static String behaviorElementId = "" ;
  
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
/*  
  public void nameCopy(Name src, Name dest)
  {
    dest.setLocationReference(src.getLocationReference());
    dest.setIdentifierOwned(src.getIdentifierOwned());
    dest.getArrayIndexes().addAll(src.getArrayIndexes());
  }
*/  
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
  private void setLocationReference(AObject obj, Token token){
    
    // String description = "file " + this.getFilename() + " col " + src.getCharPositionInLine() ;
    
    int offset = ((CommonToken)token).getStartIndex() ;
    int length = token.getText().length() ;
    int column = token.getCharPositionInLine() + 1 ; // Zero index based.
    int line = token.getLine() ;
    
    AadlBaLocationReference location = new AadlBaLocationReference(
                                         filename, line, offset, length, column,
                                         behaviorElementId);
    
    obj.setLocationReference(location);
  
  }
  
  private BehaviorAnnex _ba = null ;
  
  // Default highlighter does nothing.
  private AadlBaHighlighter _ht = new DefaultAadlBaHighlighter() ;
  
  public void setHighlighter(AadlBaHighlighter ht)
  {
    _ht = ht ;
  }
  
  private void highlight(Token token, String id)
  {
    _ht.addToHighlighting(_ba, token, id);  
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

ENUMERATOR     : 'enumerators' ;



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
   _ba = BehAnnex ;
   
   int line = input.get(0).getLine() ;

   AadlBaLocationReference location = new AadlBaLocationReference(
                                         filename, line);
   BehAnnex.setLocationReference(location) ; 
 }
  : 
   ( keyword=VARIABLES {highlight(keyword, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}
       ( lbv=behavior_variable_list[BehAnnex] { BehAnnex.getVariables().addAll(lbv);} )+
   )?
   
   ( keyword=STATES {highlight(keyword, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}
       ( lbs=behavior_state_list { BehAnnex.getStates().addAll(lbs); } )+
   )?
   
   ( keyword=TRANSITIONS {highlight(keyword, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}
       ( BehTrans=behavior_transition {BehAnnex.getTransitions().add(BehTrans); } )+ 
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
behavior_variable_list[BehaviorAnnex ba] returns [List<BehaviorVariable> lbv]
 @init{
   lbv = new ArrayList<BehaviorVariable>() ;
 }
  :
       
   bv=behavior_variable
   {
     lbv.add(bv) ;
   } 
   
   ( COMMA bv=behavior_variable
     {
       lbv.add(bv) ;
     }
   )* 
   
   COLON 
   
   DataClassRef=unique_component_classifier_reference
   {
      DeclarativeUtils.setEcontainer(_ba, DataClassRef);
      
      for(BehaviorVariable tmp : lbv)
      {
        tmp.setDataClassifier(DataClassRef);
      }
   }
   SEMICOLON
;
catch [RecognitionException ex] {
  reportError(ex);
  
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// declarator ::= identifier { array_size }*
// array_size :: [ integer_value_constant ]
behavior_variable returns [BehaviorVariable bv]
 @init
 {
   bv = _fact.createBehaviorVariable();
 }
  :
    identifier=IDENT { 
                       setLocationReference(bv, identifier);
                       bv.setName(identifier.getText()) ;
                     }
    ( LBRACK IntValue=integer_value_constant RBRACK
      { 
        DeclarativeArrayDimension dad = _decl.createDeclarativeArrayDimension();
        dad.setLocationReference(IntValue.getLocationReference()) ;
        dad.setDimension(IntValue) ;
        bv.getArrayDimensions().add(dad); 
      }
    )*
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// qualified_named_element ::= 
//   { package_identifier :: }* component_type_identifier
//   [ . component_implementation_identifier ]
qualifiable_named_element [QualifiedNamedElement qne]
 @init{
        String id1 = "";
        String id2 = "";
      }
  :
   (
    ( identifier1=IDENT DOUBLECOLON
      { 
        id1=id1+(id1.length() == 0 ? "":"::")+identifier1.getText();
      }
    )*
    
    identifier2=IDENT { id2=identifier2.getText(); }
    
    ( DOT identifier3=IDENT { id2=id2+"."+identifier3.getText(); } )?
   )
   {
     Identifier nameId = _decl.createIdentifier();
     nameId.setId(id2);
     setLocationReference(nameId, identifier2); 
     qne.setBaName(nameId);
    
     if (! id1.equals(""))
     {
       Identifier nameSpaceId = _decl.createIdentifier();
       nameSpaceId.setId(id1);
       setLocationReference(nameSpaceId, identifier1); 
       qne.setBaNamespace(nameSpaceId);
       setLocationReference(qne, identifier1);
     }
     else
     {
       setLocationReference(qne, identifier2);
     }
   }
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}
  
// unique_component_classifier_reference ::= 
//   { package_identifier :: }* component_type_identifier
//   [ . component_implementation_identifier ]
unique_component_classifier_reference returns [QualifiedNamedElement DataClassRef]
 @init{
   DataClassRef = _decl.createQualifiedNamedElement();
 }
  :
   (
     qualifiable_named_element[DataClassRef]
   )
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
behavior_state_list returns [List<BehaviorState> lbs]
 @init{
   lbs = new ArrayList<BehaviorState>() ;
 }
  :
    identifier=IDENT 
     {
        BehaviorState bs = _fact.createBehaviorState() ;
        bs.setName(identifier.getText());
        setLocationReference(bs, identifier); 
        lbs.add(bs) ; 
      } 
   ( COMMA identifier=IDENT 
     {
        BehaviorState bs = _fact.createBehaviorState() ;
        bs.setName(identifier.getText());
        setLocationReference(bs, identifier); 
        lbs.add(bs) ; 
     } 
   )*
   COLON 
   (
     (keyword_init=INITIAL  {
                 for (BehaviorState bs : lbs)
                 {
                   bs.setInitial(true)  ;
                 } 
               } )? 
     (keyword_complete=COMPLETE { 
                 for (BehaviorState bs : lbs)
                 {
                   bs.setComplete(true)  ;
                 } 
               } )? 
     (keyword_final=FINAL    { 
                 for (BehaviorState bs : lbs)
                 {
                   bs.setFinal(true)  ;
                 } 
               } )?
     keyword=STATE SEMICOLON
   )
   {
     if(keyword_init!=null)
     highlight(keyword_init, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
     if(keyword_complete!=null)
     highlight(keyword_complete, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
   if(keyword_final!=null)
     highlight(keyword_final, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
   if (identifier!=null)
     highlight(identifier, AnnexHighlighterPositionAcceptor.DEFAULT_ID);
   highlight(keyword, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
   }
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
behavior_transition returns [DeclarativeBehaviorTransition BehTrans]
 @init
 {
   BehTrans = _decl.createDeclarativeBehaviorTransition();
 }
  :
   ( identifier=IDENT 
     {
       BehTrans.setName(identifier.getText()) ;
       setLocationReference(BehTrans, identifier); 
     } 
     ( LBRACK Num=numeral RBRACK { BehTrans.setPriority(Num);} )? 
     COLON
   )?  
   
   identifier=IDENT 
   { 
     Identifier Id = _decl.createIdentifier();
     Id.setId(identifier.getText());
     setLocationReference(Id, identifier); 
     BehTrans.getSrcStates().add(Id);
    
     if(BehTrans.getLocationReference() == null)
     {
       BehTrans.setLocationReference(Id.getLocationReference()) ;
     } 
   }
   
   ( COMMA identifier=IDENT 
     { 
      Identifier Id = _decl.createIdentifier();
      Id.setId(identifier.getText());
      setLocationReference(Id, identifier); 
      BehTrans.getSrcStates().add(Id);
     } 
   )*
   
   ( identifier=LTRANS BehCond=behavior_condition
     { 
       // behavior condition can be null.
       if (BehCond != null)
       {
         DeclarativeUtils.setEcontainer(_ba, BehCond);
         BehTrans.setCondition(BehCond);
       }
     } 
     RTRANS
   )
    
   identifier=IDENT 
   {
     Identifier Id = _decl.createIdentifier();
     Id.setId(identifier.getText());
     setLocationReference(Id, identifier); 
     BehTrans.setDestState(Id);
   }
    
   ( BehActionBlock=behavior_action_block 
        { 
          DeclarativeUtils.setEcontainer(_ba, BehActionBlock);
          BehTrans.setActionBlock(BehActionBlock);
        }
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
       BehActionBlock.setContent(BehActions) ;
       setLocationReference(BehActionBlock, identifier);
    }
      
    ( TIMEOUT BehTime=behavior_time
      {
        BehActionBlock.setTimeout(BehTime) ;
        highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
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
       pos=ON DisCond=dispatch_condition
       {
         setLocationReference(DisCond, pos);
         highlight(pos, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
       }
     |
       (ExecCond=execute_condition)?
   )
   {
     if (DisCond != null)
     {
       BehCond = DisCond;
     } 
     else
     {
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
  : 
   ( 
       identifier=TIMEOUT
       {
         ExecCond = _fact.createExecutionTimeoutCatch();
         setLocationReference(ExecCond, identifier);
         highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
       }
     |
       identifier=OTHERWISE
       {
         ExecCond = _fact.createOtherwise() ;
         setLocationReference(ExecCond, identifier);
         highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
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

integer_value_constant returns [IntegerValueConstant ivc]

 :
     il = integer_literal {ivc = il ;}
   |
     // Ambiguous case.
     prop=property {ivc = prop;}  
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

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

dispatch_condition returns [DispatchCondition DisCond]
 @init{
   // Location reference is set in behavior_transition
   DisCond = _fact.createDispatchCondition ();
 }
  :
   keyword=DISPATCH 
   ( DisTriggCond=dispatch_trigger_condition
     {
       DisCond.setDispatchTriggerCondition (DisTriggCond);
       highlight(keyword, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
     }
   )? 
  
   ( keyword=FROZEN port=reference
     {
       DisCond.getFrozenPorts().add(port);
       highlight(keyword, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
     }
     ( COMMA port=reference
       {
         DisCond.getFrozenPorts().add(port);
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
// | provides_subprogram_access_name
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
   : // Ambiguity between subprogram access name and a dispatch trigger !
     // A dispatch trigger logical expression with only one
     // dispatch conjunction which is only one dispatch trigger (single name)
     // can't be distinguish from a subprogram access name.
     // subprogram access name are parsed as dispatch trigger logical
     // expression.
       identifier=STOP
       { DisTriggCond = _fact.createDispatchTriggerConditionStop() ;
         setLocationReference(DisTriggCond, identifier) ;
         highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
       }
     |
       ( identifier=TIMEOUT
         { DisTriggCond = _fact.createDispatchRelativeTimeout() ;
           setLocationReference(DisTriggCond, identifier) ;
           highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
         }     
         (
           BehTime=behavior_time
           { 
             DisTriggCond = BehTime ;
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
       identifier=OR DisConjunct=dispatch_conjunction
       {
         DisTriggLogicalExpr.getDispatchConjunctions().add(DisConjunct) ;
         highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
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
// in_event_port_name
// | in_event_data_port_name
dispatch_conjunction returns [DispatchConjunction DisConjunct]
 @init
 {
   DisConjunct = _fact.createDispatchConjunction ();
 }
   :
     ref=reference
     {
       DisConjunct.getDispatchTriggers().add(ref) ;
       DisConjunct.setLocationReference(ref.getLocationReference());
     }
     (
       keyword=AND ref=reference
       {
         DisConjunct.getDispatchTriggers().add(ref) ;
         highlight(keyword, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
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
   EList<BehaviorAction> tmpList = new BasicEList<BehaviorAction>() ;
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
        col.getActions().add(BehAction);
        col.getActions().addAll(tmpList);
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
   IfStatement tmpIfStat = null ;
   ForOrForAllStatement ForStat = null ;
   IterativeVariable itVar = null ;
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
         IfStat.setLogicalValueExpression(ValExpr) ;
         IfStat.setBehaviorActions(BehActions);
         tmpIfStat = IfStat ;
         highlight(identifier1, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
       }
       ( 
         identifier1=ELSIF identifier2=LPAREN ValExpr=value_expression RPAREN BehActions=behavior_actions
         {
           IfStatement ElifStat = _fact.createIfStatement() ;
           ElifStat.setElif(true);
           
           setLocationReference(ElifStat, identifier1);
           setLocationReference(ValExpr, identifier2) ; 
           ElifStat.setLogicalValueExpression(ValExpr) ;
           ElifStat.setBehaviorActions(BehActions);
           
           tmpIfStat.setElseStatement(ElifStat) ;
           tmpIfStat = ElifStat ;
           highlight(identifier1, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
         }
       )*
       (
         identifier=ELSE BehActions=behavior_actions
         {
           ElseStatement elseStat = _fact.createElseStatement();
           setLocationReference(elseStat, identifier);
           elseStat.setBehaviorActions(BehActions);
           tmpIfStat.setElseStatement(elseStat);
           highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
         }
       )?
       keyword1=END keyword2=IF
       {
         highlight(keyword1, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
         highlight(keyword2, AnnexHighlighterPositionAcceptor.KEYWORD_ID); 
         BehAction = IfStat ;
       }
     )
   |
     //For statement.
     ( identifier=FOR LPAREN { ForStat = _fact.createForOrForAllStatement(); 
                               setLocationReference(ForStat, identifier);
                               highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID); 
                             } 
       identifier=IDENT {  
                          itVar = _fact.createIterativeVariable(); 
                          itVar.setName(identifier.getText());
                          setLocationReference(itVar, identifier); 
                          ForStat.setIterativeVariable(itVar); 
                        }
       COLON dt=unique_component_classifier_reference
       {
         DeclarativeUtils.setEcontainer(_ba, dt);
         itVar.setDataClassifier(dt);
       }
       
       keyword=IN EltVal=element_values RPAREN { ForStat.setIteratedValues(EltVal); highlight(keyword, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}
       identifier=LCURLY BehActions=behavior_actions RCURLY 
       { ForStat.setBehaviorActions(BehActions);
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
        highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID); 
       }
       identifier=IDENT {  
                          itVar = _fact.createIterativeVariable(); 
                          itVar.setName(identifier.getText());
                          setLocationReference(itVar, identifier); 
                          ForStat.setIterativeVariable(itVar);
                        }
       COLON dt=unique_component_classifier_reference 
       {
         itVar.setDataClassifier(dt);
       }
       
       IN EltVal=element_values RPAREN { ForStat.setIteratedValues(EltVal); }
       identifier=LCURLY BehActions=behavior_actions RCURLY
       { ForStat.setBehaviorActions(BehActions) ;
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
         WhileStat.setBehaviorActions(BehActions);
         BehAction = WhileStat ;
         highlight(identifier1, AnnexHighlighterPositionAcceptor.KEYWORD_ID); 
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
         doUntilStat.setBehaviorActions(BehActions);
         BehAction = doUntilStat ;
         highlight(identifier1, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
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
  : 
     ( IntRange=integer_range { EltVal = IntRange; } )
   |
     ( AdcRef=reference { EltVal = (ElementValues) AdcRef; } )
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
     ( CommAct=communication_action { BaAction = CommAct;} )
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
   Tar=target ASSIGN ( ValExpr=value_expression | identifier=ANY )
   {
     AssAct.setLocationReference(Tar.getLocationReference());
     AssAct.setTarget(Tar);
       
     if (ValExpr != null)
     {
       AssAct.setValueExpression(ValExpr);
     }
     else
     {
       Any any = _fact.createAny() ;
       setLocationReference(any, identifier);
       highlight(identifier, AnnexHighlighterPositionAcceptor.DEFAULT_ID);
       AssAct.setValueExpression(any);
     }
   }
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// target ::= 
// | outgoing_port_name 
// | outgoing_data_component_reference
// | outgoing_port_prototype_name
target returns [Target Tar]
 @init{
   Tar = null ;
 }
  : dt=reference {Tar= (Target) dt ;} 
                                         
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

qualified_named_element returns [QualifiedNamedElement qne]
@init
{
  String id1 = "";
  String id2 = "";
}
  :
   (
    ( identifier1=IDENT DOUBLECOLON
      { 
        id1=id1+(id1.length() == 0 ? "":"::")+identifier1.getText();
      }
    )+
    
    identifier2=IDENT
    { 
      id2=identifier2.getText();
    }
    ( DOT identifier3=IDENT
      {
        id2=id2+"."+identifier3.getText();
      }
    )?
   )
   {
     qne = _decl.createQualifiedNamedElement();
     Identifier nameId = _decl.createIdentifier();
     nameId.setId(id2);
     setLocationReference(nameId, identifier2); 
     qne.setBaName(nameId);
    
     if (! id1.equals(""))
     {
       Identifier nameSpaceId = _decl.createIdentifier();
       nameSpaceId.setId(id1);
       setLocationReference(nameSpaceId, identifier1); 
       qne.setBaNamespace(nameSpaceId);
       setLocationReference(qne, identifier1);
     }
   }
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
communication_action returns [CommAction ca]
@init
{
  ca = _decl.createCommAction() ;
}
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
      (
        qne=qualified_named_element EXCLAM
        {
          ca.setLocationReference(qne.getLocationReference());
          ca.setQualifiedName(qne);
        }
        ( 
          LPAREN SubpgmParamList=subprogram_parameter_list RPAREN
          {
            ca.getParameters().addAll(SubpgmParamList);
          }
        )?
      )   
    |
      (
        ref=reference
        {
          ca.setReference(ref);
          ca.setLocationReference(ref.getLocationReference()) ;
        }
        (
            (
              INTERROG
              {
                ca.setPortDequeue(true);
              }
              (
                LPAREN Tar=target RPAREN
                {
                  ca.setTarget(Tar);
                }
              )?
            )
          |
            (
              GGREATER
              { 
                ca.setPortFreeze(true);
              }
            )
          |
            (
              EXCLLESS
              {
                ca.setLock(true);
              }
            )
          |
            (
              EXCLGREATER
              {
                ca.setUnlock(true);
              }
            )
          |
            (
              EXCLAM
              ( 
                LPAREN SubpgmParamList=subprogram_parameter_list RPAREN
                {
                  ca.getParameters().addAll(SubpgmParamList);
                }
              )?
            )
        )
      )
    |
      (
        identifier=STAR
        ( 
            EXCLLESS
            {
              ca.setLock(true);
            }
          | 
            EXCLGREATER
            {
              ca.setUnlock(true);
            }
        )
        {
          setLocationReference(ca, identifier);
        }
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
   ( identifier=COMPUTATION {setLocationReference(TimedAct, identifier) ; highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}  
   )  
   LPAREN
     BehTime=behavior_time {TimedAct.setLowerTime(BehTime); }
     (DOTDOT BehTime=behavior_time {TimedAct.setUpperTime(BehTime);}
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
  : // Ambiguity between a value expression with a single value and a target.
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
//   data_subcomponent_name { . data_subcomponent_name }*
// | data_access_feature_name { . data_subcomponent_name }*
// | local_variable_name { . data_subcomponent_name }*
// | data_access_feature_prototype_name { . data_subcomponent_name }*
// | subprogram_parameter_name { . data_subcomponent_name }*

reference returns [Reference ref]
 @init{
    ref = _decl.createReference() ;
   
 }
  :
    id=array_identifier
    {
      ref.getIds().add(id);
      ref.setLocationReference(id.getLocationReference());
    }
    (
      DOT id=array_identifier
      {
        ref.getIds().add(id);
      }
    )*
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// array_identifier ::=
//   identifier { integer_value }*
array_identifier returns [ArrayableIdentifier id]
@init
{
  id = _decl.createArrayableIdentifier() ;
}
  :
    identifier=IDENT
    {
      id.setId(identifier.getText());    
      setLocationReference(id, identifier); 
    }
    (
      LBRACK Val=integer_value RBRACK
      {
        id.getArrayIndexes().add(Val);
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

// fact_value ::=
//   value_constant
// | value_variable

// value_constant ::= 
//   boolean_literal
// | numeric_literal 
// | string_literal
// | enumeration_literal 
// | property_constant
// | property_value

// value_variable ::=
//   incoming_port_name
// | incoming_port_name ?
// | incoming_port_data_component_reference
// | port_name' count
// | port_name' fresh

fact_value returns [Value Val]
@init
 {
   Val = null ;
 }
  : // Ambiguity between value variable (name without array index) and
    // unqualified propertyset constant or unqualified propertyset value.
    // unqualified propertyset constants and unqualified propertyset values are
    // parsed as reference (see value variable). 
   (
       // Case of qualified property constant or value.
       (  
          id1=IDENT DOUBLECOLON id2=IDENT
          {
            QualifiedNamedElement property = _decl.
                                               createQualifiedNamedElement();
                        
            Identifier nameSpaceId = _decl.createIdentifier();
            nameSpaceId.setId(id1.getText());
            setLocationReference(nameSpaceId, id1);
            property.setBaNamespace(nameSpaceId);
            
            setLocationReference(property, id1) ;
            
            Identifier nameId = _decl.createIdentifier();
            nameId.setId(id2.getText());
            setLocationReference(nameId, id2);
            property.setBaName(nameId);
            
            Val = property ;
          }
       )
     | // Value variables and unqualified propertyset constants and unqualified
       // propertyset values cases.
       ValueVar=value_variable { Val = ValueVar ;}

     | // Cases from value constant category. 
       bl=boolean_literal { Val = bl;}
     |
       nl=numeric_literal { Val = nl;}
     |
       st=string_literal  { Val = st;}
     |
       lit=behavior_enumeration_literal { Val = lit ;}    
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
// | incoming_port_data_component_reference
// | port_name' count
// | port_name' fresh
value_variable returns [ValueVariable ValueVar]

 @init{
   ValueVar = null ;
 }
  : 
     (
       ref=reference
       
       (
           INTERROG
           {
             NamedValue nv = _decl.createNamedValue();
             nv.setReference(ref) ;
             nv.setDequeue(true);
             nv.setLocationReference(ref.getLocationReference());
             ValueVar = nv ;
           }
         |
           TICK (
                    keyword=COUNT 
                    { 
                      NamedValue nv = _decl.createNamedValue();
                      nv.setReference(ref) ;
                      nv.setCount(true);
                       nv.setLocationReference(ref.getLocationReference());
                      ValueVar = nv ;
                      highlight(keyword, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
                    } 
                  | 
                    keyword=FRESH
                    {
                      NamedValue nv = _decl.createNamedValue();
                      nv.setReference(ref) ;
                      nv.setFresh(true);
                       nv.setLocationReference(ref.getLocationReference());
                      ValueVar = nv ;
                      highlight(keyword, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
                    }
                )
       )?
       {
         if (ValueVar == null)
         {
           ValueVar = ref ;
         }
       }
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
   { Rel.setFirstExpression(SimpleExpr);
     Rel.setLocationReference(SimpleExpr.getLocationReference());  
   }
   (
     RelationalOp=relational_operator SimpleExpr=simple_expression 
     {
      Rel.setRelationalOperator(RelationalOp);
      Rel.setSecondExpression(SimpleExpr);
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
      SimpleExpr.setUnaryAddingOperator(UnaryAddOp);
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
 @init
 {
   Fact = _fact.createFactor();
 }
  :
   (
    ( val=value {
                  Fact.setLocationReference(val.getLocationReference()) ;
                  Fact.setFirstValue(val);
                } 
      (
        BinaryNumOp=binary_numeric_operator val2=value
        {
          Fact.setBinaryNumericOperator(BinaryNumOp);
          Fact.setSecondValue(val2);
        }
      )?
    )
   |
    ( UnaryNumOp=unary_numeric_operator val=value
      {
         Fact.setUnaryNumericOperator(UnaryNumOp);
         Fact.setFirstValue(val);
         Fact.setLocationReference(val.getLocationReference()) ;
      }
    )
   |
    ( UnaryBoolOp=unary_boolean_operator val=value
      {
         Fact.setUnaryBooleanOperator(UnaryBoolOp);
         Fact.setFirstValue(val);
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
     identifier=AND { LogicalOp=LogicalOperator.AND; highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}
   |
     identifier=OR { LogicalOp=LogicalOperator.OR; highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}
   |
     identifier=XOR { LogicalOp=LogicalOperator.XOR; highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}
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
     identifier=MOD { MultiplyingOp = MultiplyingOperator.MOD; highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}
   |
     identifier=REM { MultiplyingOp = MultiplyingOperator.REM; highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}
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
   keyword=ABS { UnaryNumOp = UnaryNumericOperator.ABS; highlight(keyword, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}
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
   identifier=NOT { UnaryBoolOp = UnaryBooleanOperator.NOT; highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// boolean_literal ::= true | false
boolean_literal returns [BehaviorBooleanLiteral BoolLit]
 @init{
   BoolLit = _fact.createBehaviorBooleanLiteral();
 }
  :
   (
       identifier=TRUE { BoolLit.setValue(true); highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}
     |
       identifier=FALSE { BoolLit.setValue(false); highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}
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
    // propertyset constant or value from value constant. See fact_value. 
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
behavior_time returns [DeclarativeTime BehTime]
 @init{
   BehTime = _decl.createDeclarativeTime() ;
 }
  :
   (
     IntValue=integer_value UnitIdent=IDENT
     {
       BehTime.setIntegerValue(IntValue);
       BehTime.setLocationReference(IntValue.getLocationReference());
       
       Identifier Id = _decl.createIdentifier() ;
       Id.setId(UnitIdent.getText());
       setLocationReference(Id, UnitIdent) ;
       BehTime.setUnitId(Id);
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

// property_value ::=
//   [ property_set_identifier :: ] property_value_identifier

// property constants and property values ambiguity : they are parsed as 
// a generic property.

// property ::=
//   property_constant
// | property_value

property returns [QualifiedNamedElement property]
 @init{
   property = _decl.createQualifiedNamedElement();
 }
  :
   (
     ( PropertySetId=IDENT DOUBLECOLON
       {
         Identifier nameSpaceId = _decl.createIdentifier();
         nameSpaceId.setId(PropertySetId.getText());
         setLocationReference(nameSpaceId, PropertySetId); 
         property.setBaNamespace(nameSpaceId);
         setLocationReference(property, PropertySetId) ;
       }
     )?
       
     PropertyId=IDENT
     { 
       Identifier nameId = _decl.createIdentifier();
       nameId.setId(PropertyId.getText());
       setLocationReference(nameId, PropertyId); 
       property.setBaName(nameId);
       
       if (property.getLocationReference() == null )  
       {
         setLocationReference(property, PropertyId) ; 
       }
     }
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// enumeration_literal ::= 
//   { package_identifier :: }* component_type_identifier
//   [ . component_implementation_identifier ]
//   . enumerator_property_identifier
//   # enumeration_literal_identifier
behavior_enumeration_literal returns [Enumeration enumeration]
  @init {
          enumeration = _decl.createEnumeration() ;
        }
  :
  (
     qualifiable_named_element[enumeration]
     
     DOT id1=ENUMERATOR HASH id2=IDENT
     {
       Identifier lit = _decl.createIdentifier() ;
       lit.setId(id2.getText());
       setLocationReference(lit, id2) ;
       Identifier prop = _decl.createIdentifier() ;
       prop.setId(id1.getText()) ;
       setLocationReference(prop, id1) ;
       
       enumeration.setProperty(prop);
       enumeration.setLiteral(lit);
       // enumeration's location reference is already set, see
       // qualifiable_named_element.       
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
      realval=REAL_LIT
      {
        String str = realval.getText();
        BehaviorRealLiteral tmp = _fact.createBehaviorRealLiteral();
        str = str.replaceAll("_", "") ;
        tmp.setValue(str);
        setLocationReference(tmp, realval);
        nl = tmp ;
        highlight(realval, AnnexHighlighterPositionAcceptor.NUMBER_ID);
      }
    |
      intLit = integer_literal
      {
        nl = intLit ;
      }
  ) 
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

integer_literal returns [BehaviorIntegerLiteral bil]

 :
    integerval=INTEGER_LIT
    {
      try
      {
        String str = integerval.getText();
        BehaviorIntegerLiteral tmp = _fact.createBehaviorIntegerLiteral();
        tmp.setValue(str);
        setLocationReference(tmp, integerval);
        bil = tmp ;
        highlight(integerval, AnnexHighlighterPositionAcceptor.NUMBER_ID);
      }
      catch (IllegalArgumentException e)
      {
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
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// string_literal ::= <refer to [AS5506A 15.5]>
string_literal returns [BehaviorStringLiteral StringLit]
 @init{
   StringLit = _fact.createBehaviorStringLiteral();
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
        highlight(sl, AnnexHighlighterPositionAcceptor.STRING_ID);
      }
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// numeral ::= <refer to [AS5506A 15.4.1]>
numeral returns [Integer Num]

  :
   ( 
     NumVal=INTEGER_LIT 
     { 
       String tmp = NumVal.getText().replaceAll("_", "");
       Num = Integer.parseInt(tmp) ;
       highlight(NumVal, AnnexHighlighterPositionAcceptor.NUMBER_ID);
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
  : comment='--'
(~('\n'|'\r' ))* {//highlight(comment, AnnexHighlighterPositionAcceptor.COMMENT_ID);
          $channel=COMMENT_CHANNEL;}
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
