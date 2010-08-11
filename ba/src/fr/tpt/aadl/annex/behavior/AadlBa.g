
grammar AadlBa;

options {
  k=*;
  language = Java;
  backtrack = true;
}

@header { 
  package fr.tpt.aadl.annex.behavior;
  
  //import org.antlr.runtime;
  
  import java.util.ArrayList;
  import java.util.HashSet;
  import java.util.Iterator;
  import java.util.List;
  import java.util.Set;
  import java.util.Vector;
  import java.util.TreeSet;

  import org.antlr.runtime.BaseRecognizer;
  import org.antlr.runtime.BitSet;
  import org.antlr.runtime.CommonTokenStream;
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
  import org.eclipse.emf.ecore.EObject;
  import org.eclipse.emf.ecore.resource.Resource;
  import org.eclipse.core.resources.IResource;

  import edu.cmu.sei.aadl.modelsupport.errorreporting.ParseErrorReporter;  
  import edu.cmu.sei.aadl.aadl2.parsesupport.AObject;
  import edu.cmu.sei.aadl.aadl2.AnnexSubclause;
  import edu.cmu.sei.aadl.parser.MultiChannelTokenStream ;
  
  import edu.cmu.sei.aadl.aadl2.parsesupport.LocationReference;
  
  import fr.tpt.aadl.annex.behavior.aadlba.AadlBaFactory;
  import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
  import fr.tpt.aadl.annex.behavior.aadlba.ArrayIndex;
  import fr.tpt.aadl.annex.behavior.aadlba.ArraySize;
  import fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction;
  import fr.tpt.aadl.annex.behavior.aadlba.BasicAction;
  import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction;
  import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions;
  import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;
  import fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition;
  import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState;
  import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime;
  import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition;
  import fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable;
  import fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator;
  import fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator;
  import fr.tpt.aadl.annex.behavior.aadlba.BooleanLiteral;
  import fr.tpt.aadl.annex.behavior.aadlba.CommActionParameter;
  import fr.tpt.aadl.annex.behavior.aadlba.Comment;
  import fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction;
  import fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference;
  import fr.tpt.aadl.annex.behavior.aadlba.Declarator;
  import fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition;
  import fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression;
  import fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger;
  import fr.tpt.aadl.annex.behavior.aadlba.DoUntilStatement;
  import fr.tpt.aadl.annex.behavior.aadlba.Element;
  import fr.tpt.aadl.annex.behavior.aadlba.ElementValues;
  import fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition;
  import fr.tpt.aadl.annex.behavior.aadlba.Factor;
  import fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement;
  import fr.tpt.aadl.annex.behavior.aadlba.GlobalNamespace;
  import fr.tpt.aadl.annex.behavior.aadlba.Identifier;
  import fr.tpt.aadl.annex.behavior.aadlba.IfStatement;
  import fr.tpt.aadl.annex.behavior.aadlba.IntegerRange;
  import fr.tpt.aadl.annex.behavior.aadlba.IntegerValue;
  import fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator;
  import fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator;
  import fr.tpt.aadl.annex.behavior.aadlba.Name;
  import fr.tpt.aadl.annex.behavior.aadlba.NamedElement;
  import fr.tpt.aadl.annex.behavior.aadlba.Namespace;
  import fr.tpt.aadl.annex.behavior.aadlba.Numeral;
  import fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral;
  import fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel;
  import fr.tpt.aadl.annex.behavior.aadlba.PropertyConstant;
  import fr.tpt.aadl.annex.behavior.aadlba.PropertyValue;
  import fr.tpt.aadl.annex.behavior.aadlba.Relation;
  import fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator;
  import fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression;
  import fr.tpt.aadl.annex.behavior.aadlba.StringLiteral;
  import fr.tpt.aadl.annex.behavior.aadlba.SubprogramParameterList;
  import fr.tpt.aadl.annex.behavior.aadlba.Target;
  import fr.tpt.aadl.annex.behavior.aadlba.Term;
  import fr.tpt.aadl.annex.behavior.aadlba.TimedAction;
  import fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator;
  import fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator;
  import fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator;
  import fr.tpt.aadl.annex.behavior.aadlba.UniqueComponentClassifierReference;
  import fr.tpt.aadl.annex.behavior.aadlba.Value;
  import fr.tpt.aadl.annex.behavior.aadlba.ValueConstant;
  import fr.tpt.aadl.annex.behavior.aadlba.ValueExpression;
  import fr.tpt.aadl.annex.behavior.aadlba.ValueVariable;
  import fr.tpt.aadl.annex.behavior.aadlba.WhileStatement;
  
  import fr.tpt.aadl.annex.behavior.aadlba.impl.ValueImpl;

}
  
@lexer::header{
  package fr.tpt.aadl.annex.behavior;
  
  import edu.cmu.sei.aadl.modelsupport.errorreporting.ParseErrorReporter;
  import org.eclipse.core.resources.IResource;
}

@members {
  /**
  * Aadl Ba factory metamodel instance
  */
  protected AadlBaFactory AadlBaF = AadlBaFactory.eINSTANCE;
  
  /**
  * All unresolved references ordered by dependencies. To determine the order look at
  * the RecordReference main() to see an example of the ordering technique used here.
  */
  protected TreeSet<ReferenceRecord> unresolvedReferences;

  /**
   * The error reporter to use.
   */
  protected ParseErrorReporter errReporter = null;
  
  /**
   * global namespace to perform the resolution of names
   */
   
  private GlobalNamespace globalNamespace=null;
  
  /**
   * The aadl filename to be parsed.
   */
  private String filename;
  
  
  public void setGlobalNamespace(GlobalNamespace ns){
    globalNamespace = ns;
  }
  
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
  
  /**
   * Report parser error
   * @param msg  error message
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
   * Report parser error
   * @param msg  error message
   * @param e  any exception 
   */
  public  void reportError(Exception e) {
    //AadlParserPlugin.INSTANCE.log(e);
    errReporter.error(this.getFilename(), 0, e.toString());
  }

  /**
   * the current resource being parsed
   */
  protected SplitStreamFilter filter = null;
  
  /**
   * sets the filter for pulling comment tokens.
   * @param filter  filter with comment tokens
   */
  public void setFilter(SplitStreamFilter filter){
    this.filter = filter;
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
  
  /* Process comments attached to the beginning of a declaration */
/* TODO remove clean code. since aadl behaviour annex standard don't support comment, this function is disabled.
  public void processComments(AObject o){
    attachComments(o, getComments());
  }
*/
  /* Get comments at the start of a declaration */
  /*
  */
/* TODO remove clean code. since aadl behaviour annex standard don't support comment, this function is disabled.  
  public Vector getComments() {
    int i = input.index();
    i = ((MultiChannelTokenStream)input).indexOfPreviousInChannelToken(i);

    if (i>commentIndex){
      List commList = ((CommonTokenStream)input).getTokens(commentIndex,i,AadlBaLexer.SL_COMMENT);
      Vector v;
      if (commList != null)
        v=new Vector(commList);
      else
        v = new Vector();
      commentIndex = i;
      return v;
    }
    
    return new Vector();
  }
*/
  /* Attach comments to an object. */

/* TODO remove clean code. since aadl behaviour annex standard don't support comment, this function is disabled.  
  public void attachComments(AObject o, Vector cmt) {
    if (cmt == null) return;
    for ( Iterator i = cmt.iterator(); i.hasNext();)
    {
      Token t = (Token) i.next();
      String c = t.getText();
      if (c.startsWith("--")){
        c = c.substring(2);
      } else if (c.startsWith("/*")){
        c = c.substring(2, c.length()-2);
      }
      int idx = c.indexOf("\n");
      while (idx >= 0){
        if (idx == 0){
          c = c.substring(1);
        } else {
          String com = c.substring(0, idx-1);
          if (o instanceof Element)
              ((Element)o).createOwnedComment().setBody(com);
          c = c.substring(idx+1);
        }
        idx = c.indexOf("\n");
      }
      if (c.length()>0){
        if (o instanceof Element)
          ((Element)o).createOwnedComment().setBody(c);
      }
    }
  }
*/
  /**
   * Dummy method
   * see http://www.antlr.org:8080/pipermail/antlr-interest/2005-August/013323.html and replies
   */
  void recover (RecognitionException e, BitSet b) {
  }

  /* Process comments attached to the end of a declaration */
/* TODO remove clean code. since aadl behaviour annex standard don't support comment, this function is disabled.
  public void processPostComments(AObject o){
    processComments(o);
  }
*/
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
DELAY          : 'delay';
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
ORLESS         : 'orless';
ORMORE         : 'ormore';
OTHERS         : 'others';
PERSISTENT     : 'persistent';
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
// BEGIN : ANNEX X.3 Behavior Specification
//---------------------------------------------------------

// behavior_annex ::=
//   [ variables { behavior_variable }+ ]
//   [ states { behavior_state }+ ]
//   [ transitions { behavior_transition }+ ]
behavior_annex returns [BehaviorAnnex BehAnnex] 
 @init{
   BehAnnex = AadlBaF.createBehaviorAnnex();
   
   BehAnnex.setLocationReference(new LocationReference(this.getFilename(), input.get(0).getLine())) ; 
      
 }
  : 
   ( VARIABLES
       ( BehVar=behavior_variable { BehAnnex.getVariables().add(BehVar);} )+
   )? {System.err.println("Variables OK");}
   
   ( STATES
       ( BehStat=behavior_state { BehAnnex.getStates().add(BehStat); } )+
   )? {System.err.println("States OK");}
   
   ( TRANSITIONS 
       ( BehTrans=behavior_transition {BehAnnex.getTransitions().add(BehTrans); } )+ 
   )?  {System.err.println("Transitions OK");}
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// behavior_variable ::= 
//   local_variable_declarator { , local_variable_declarator }* 
//   : [ persistent ] data_unique_component_classifier_reference;
behavior_variable returns [BehaviorVariable BehVar]
 @init{
   BehVar = AadlBaF.createBehaviorVariable();
 }
  :
   Decl=declarator { BehVar.getLocalVariableDeclarators().add(Decl); BehVar.setLocationReference(Decl.getLocationReference());}  
   ( COMMA Decl=declarator { BehVar.getLocalVariableDeclarators().add(Decl); } )* 
   COLON 
   ( PERSISTENT { BehVar.setPersistent(true);} )?
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
   DataClassRef = AadlBaF.createUniqueComponentClassifierReference();
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
    if (! id1.equals("")) DataClassRef.setQualifiedName(id1);
    DataClassRef.setName(id2);
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
   BehStat = AadlBaF.createBehaviorState();
 }
  :
    identifier=IDENT 
     {
        Identifier Id = AadlBaF.createIdentifier();
        Id.setId(identifier.getText());
        setLocationReference(Id, identifier); 
        BehStat.getBehaviorStateIdentifiers().add(Id);
        BehStat.setLocationReference(Id.getLocationReference()) ; 
      } 
   ( COMMA identifier=IDENT 
     {
      Identifier Id = AadlBaF.createIdentifier();
      Id.setId(identifier.getText());
      setLocationReference(Id, identifier); 
      BehStat.getBehaviorStateIdentifiers().add(Id);
     } 
   )*
   COLON 
   ( INITIAL { BehStat.setInitial(true); } )? 
   (COMPLETE { BehStat.setComplete(true); } )?
   (FINAL { BehStat.setFinal(true); } )?
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
//   destination_state_identifier [ { behavior_actions } ] ;

// behavior_transition_priority ::= numeral
behavior_transition returns [BehaviorTransition BehTrans]
 @init{
   BehTrans = AadlBaF.createBehaviorTransition();
 }
  :
   ( identifier=IDENT 
     {
      Identifier Id = AadlBaF.createIdentifier();
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
    Identifier Id = AadlBaF.createIdentifier();
    Id.setId(identifier.getText());
    setLocationReference(Id, identifier); 
    BehTrans.getSourceStateIdentifiers().add(Id);
    BehTrans.setLocationReference(Id.getLocationReference()) ; 
   }
   
   ( COMMA identifier=IDENT 
     { 
      Identifier Id = AadlBaF.createIdentifier();
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
    RTRANS )
    
    identifier=IDENT 
    {
     Identifier Id = AadlBaF.createIdentifier();
     Id.setId(identifier.getText());
     setLocationReference(Id, identifier); 
     BehTrans.setDestinationStateIdentifier(Id);
    }
    ( identifier=LCURLY BehActions=behavior_actions RCURLY 
        { BehTrans.setBehaviorActionsOwned(BehActions);
          setLocationReference(BehActions, identifier);
        }
    
      (
        TIMEOUT BehTime=behavior_time
        {
          BehTrans.setTimeout(BehTime);
        }
      )?
    )? 
       
    SEMICOLON
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


// execute_condition ::=
//  [ logical_value_expression ]

execute_condition returns [ExecuteCondition ExecCond]
 @init
 {
    ExecCond= AadlBaF.createExecuteCondition();
 }
  : // Location reference is set in behavior_transition
   ( 
       ValExpr=value_expression
       { 
         ExecCond.setValueExpression(ValExpr);
       }
     |
       CATCH LPAREN TIMEOUT RPAREN
       {
           ExecCond.setCatchTimeout(true);
       }      
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// declarator ::= identifier { array_size }*
declarator returns [Declarator Decl]
 @init{
   Decl = AadlBaF.createDeclarator();
 }
  :
   identifier=IDENT { 
                     setLocationReference(Decl, identifier); 
                     Decl.setName(identifier.getText());
                    }
   ( ArrSize=array_size { Decl.getArraySizes().add(ArrSize); } )*
;


// array_size :: [ integer_value_constant ]
array_size returns [ArraySize ArrSize]
 @init{
   ArrSize = AadlBaF.createArraySize();
 } 
  :
   identifier=LBRACK IntValue=value_constant RBRACK 
   {
    if (IntValue != null){
        ArrSize.setIntegerValueConstant(IntValue);
        setLocationReference(ArrSize, identifier); 
    } else {
       throw new FailedPredicateException(input,"array_size", "constant value is expected");
    }
   }
;

//---------------------------------------------------------
// END : ANNEX X.3 Behavior Specification
//---------------------------------------------------------
//---------------------------------------------------------


//---------------------------------------------------------
//---------------------------------------------------------
// BEGIN : ANNEX X.4 Thread Dispatch Behavior Specification
//---------------------------------------------------------

// dispatch_condition ::= 
//   on dispatch [ dispatch_logical_expression ] 
//   [ frozen frozen_ports ]

// frozen_ports ::=
//   in_port_identifier { , in_port_identifier }*

dispatch_condition returns [DispatchCondition DisCond]
 @init{
   DisCond = AadlBaF.createDispatchCondition (); // Location reference is set in behavior_transition
 }
  :
   DISPATCH 
   ( DisLogExpr=dispatch_logical_expression
     {
      if (DisLogExpr != null){
       DisCond.setTheDispatchLogicalExpression (DisLogExpr);
      }
     }
   )? 
  
   ( FROZEN identifier=IDENT 
     {
      DisCond.setHasFrozenPorts(true);
      Identifier Id = AadlBaF.createIdentifier();
      Id.setId(identifier.getText());
      setLocationReference(Id, identifier); 
      DisCond.getFrozenPorts().add(Id); 
     }
    ( COMMA identifier=IDENT
      {
       Identifier Id = AadlBaF.createIdentifier();
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


// dispatch_logical_expression ::=
//   dispatch_trigger 
//   [ { or dispatch_trigger }* 
//     | { and dispatch_trigger }* 
//     | { xor dispatch_trigger }* ]
//   | stop
dispatch_logical_expression returns [DispatchLogicalExpression DisLogExpr]
 @init{
   DisLogExpr = AadlBaF.createDispatchLogicalExpression ();
 }
  :
   (
    DisTrigg=dispatch_trigger { DisLogExpr.getDispatchTriggers().add(DisTrigg);
                                DisLogExpr.setLocationReference(DisTrigg.getLocationReference()); } 
    (
     ( OR DisTrigg=dispatch_trigger
       {
        DisLogExpr.setOrExpression(true);
        DisLogExpr.getDispatchTriggers().add(DisTrigg); 
       } )*
     |
     ( AND DisTrigg=dispatch_trigger 
       {
        DisLogExpr.setAndExpression(true);
        DisLogExpr.getDispatchTriggers().add(DisTrigg); 
       } )*
     |
     ( XOR DisTrigg=dispatch_trigger 
       {
        DisLogExpr.setXorExpression(true);
        DisLogExpr.getDispatchTriggers().add(DisTrigg); 
       } )*
     )
    |
    ( identifier=STOP { DisLogExpr.setStop(true); setLocationReference(DisLogExpr, identifier); } ) 
   ) 
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// dispatch_trigger ::=
//   [ not ] 
//   ( 
//    ( dispatch_logical_expression ) 
//    | timeout [ behavior_time ] 
//    | in_event_port_identifier 
//    | in_event_data_port_identifier 
//    | in_event_data_port_identifier ( ( value_constant | others ) ) 
//    | provides_subprogram_access_identifier 
//    | numeral [ ormore | orless ] ( dispatch_trigger {, dispatch_trigger }* ) 
//   )

dispatch_trigger returns [DispatchTrigger DisTrigg]
 @init{
   DisTrigg = AadlBaF.createDispatchTrigger();
 }
  :
      ( identifier=NOT { 
          DisTrigg.setNot(true); // TODO : GIL : Fix  NOT syntax ?
          setLocationReference(DisTrigg, identifier); 
        }
      )?  
    
      ( 
          ( identifier=LPAREN DisLogExpr=dispatch_logical_expression {
              DisTrigg.setTheDispatchLogicalExpression(DisLogExpr); 
              // SG XXX conflict with location reference set in dispatch_logical_expression ???
              setLocationReference(DisLogExpr, identifier) ; 
            } 
            RPAREN
          )
        |
          ( identifier=TIMEOUT {DisTrigg.setTimeout(true);}
              ( BehTime=behavior_time
                                  { 
                                    DisTrigg.setTheBehaviorTime(BehTime);
                                    setLocationReference(DisTrigg, identifier) ;
                                  } 
              )? 
          ) 
        | 
          ( identifier=IDENT {  
              Identifier Id = AadlBaF.createIdentifier();
              Id.setId(identifier.getText());
              setLocationReference(Id, identifier); 
              DisTrigg.setIdentifierOwned(Id);
              DisTrigg.setLocationReference(Id.getLocationReference()); 
            }
            ( LPAREN
              ( 
                 ValCons=value_constant {
                   if (ValCons != null) {
                     DisTrigg.setValueConstantOwned(ValCons);
                   }
                 }
               |
                 OTHERS { DisTrigg.setOthers (true); }
              )
              RPAREN
            )?
          )
        |
          ( num=numeral {
              if (num != null) {
                DisTrigg.setNumeralOwned(num);
                DisTrigg.setLocationReference(num.getLocationReference()); 
              }
            }
            (   ORMORE { DisTrigg.setOrMore(true); }
              | 
                ORLESS { DisTrigg.setOrLess(true); }
            )? 
            ( LPAREN DisTrigg2=dispatch_trigger { 
                if (DisTrigg2 != null) {
                  DisTrigg.getDispatchTriggers().add(DisTrigg2);
                }
              }
              ( COMMA DisTrigg2=dispatch_trigger { 
                  if (DisTrigg2 != null) {
                    DisTrigg.getDispatchTriggers().add(DisTrigg2);
                  }
                } 
              )*
              RPAREN 
            )
          )
      )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


//---------------------------------------------------------
// END : ANNEX X.4 Thread Dispatch Behavior Specification
//---------------------------------------------------------
//---------------------------------------------------------

//---------------------------------------------------------
//---------------------------------------------------------
// BEGIN : ANNEX X.6 Behavior Action Language
//---------------------------------------------------------

// behavior_actions ::=
//   behavior_action
// | behavior_action_sequence
// | behavior_action_set

// behavior_action_sequence ::=
//   behavior_action { ; behavior_action }+

// behavior_action_set ::=
//   behavior_action { & behavior_action }+ 
// TODO FIX ERROR XXX SG
behavior_actions returns [BehaviorActions BehActs]
 @init{
   // Location reference is set by the caller (behaviour_transition and behaviour_action recursively)
   BehActs = AadlBaF.createBehaviorActions();
 }
  :
   BehAction=behavior_action
   {
     BehActs.getBehaviorAction().add(BehAction);
   }

   (   
        ( SEMICOLON BehAction2=behavior_action
            {
              BehActs.getBehaviorAction().add(BehAction2);
              BehActs.setSequence(true) ;
            }
        )* 
      |
        ( CONCAT BehAction2=behavior_action
            {
              BehActs.getBehaviorAction().add(BehAction2);
              BehActs.setSet(true); 
            }
        )*
   ) 
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

/*
behavior_actions returns [BehaviorActions BehActs]
 @init{
   // Location reference is set by the caller (behaviour_transition and behaviour_action recursively)
   BehActs = AadlBaF.createBehaviorActions();
   // TODO : Gil : Fix maybe just one list and three booleans
 }
  :
   BehAction=behavior_action
   {
     BehActs.setTheBehaviorAction(BehAction);
   }

   (   
        ( SEMICOLON BehAction2=behavior_action
            {
              BehActs.getBehaviorActionSequence().add(BehAction2); 
            }
        )* 
      |
        ( CONCAT BehAction2=behavior_action
            {
              BehActs.getBehaviorActionSequence().add(BehAction2); 
            }
        )*
   ) 
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}
*/



// behavior_action ::=
//   basic_action 
// | { behavior_actions }
// | if ( logical_value_expression ) behavior_actions
//  { elsif ( logical_value_expression ) behavior_actions }*
//  [ else behavior_actions ]   
//  end if 
// | for ( 
//  element_identifier [ : data_unique_component_classifier_reference ] 
//  in element_values ) { behavior_actions }
// | forall ( 
//  element_identifier [ : data_unique_component_classifier_reference ]
//  in element_values ) { behavior_actions }
// | while ( logical_value_expression ) { behavior_actions }
// | do behavior_actions until ( logical_value_expression )
behavior_action returns [BehaviorAction BehAction]
 @init{
   BehAction = AadlBaF.createBehaviorAction();
   IfStatement IfStat = null;
   ForOrForAllStatement ForStat = null;
   
 }
  :
   ( ( BaAct=basic_action
       { 
        BehAction.setBasicActionOwned(BaAct); 
        BehAction.setBasicAction(true);
        BehAction.setLocationReference(BaAct.getLocationReference()); 
       }
      )
   | 
     ( identifier=LCURLY BehActions=behavior_actions RCURLY
       { 
          BehAction.setBehaviorActionsOwned(BehActions);
          BehAction.setBehaviorActions(true);
          setLocationReference(BehAction, identifier) ; 
          BehActions.setLocationReference(BehAction.getLocationReference()) ;
       }
       
       ( TIMEOUT BehTime=behavior_time
         {
           BehAction.setTimeout(BehTime);
         }
       )?
     )
   |
     // if statement
     ( identifier1=IF identifier2=LPAREN ValExpr=value_expression RPAREN BehActions=behavior_actions 
       { 
        IfStat = AadlBaF.createIfStatement();
        setLocationReference(IfStat, identifier1); 
        BehAction.setLocationReference(IfStat.getLocationReference()) ; 
        BehActions.setLocationReference(IfStat.getLocationReference()) ;  
        setLocationReference(ValExpr, identifier2); 
        IfStat.getValueExpressionOwned().add(ValExpr) ;
        IfStat.getBehaviorActionsOwned().add(BehActions);
       }
       ( 
         identifier1=ELSIF identifier2=LPAREN ValExpr=value_expression RPAREN BehActions=behavior_actions
         {
          setLocationReference(BehActions, identifier1) ; 
          setLocationReference(ValExpr, identifier2) ; 
          IfStat.getValueExpressionOwned().add(ValExpr) ;
          IfStat.getBehaviorActionsOwned().add(BehActions);
         }
       )*
       (
         identifier=ELSE BehActions=behavior_actions
         {
          IfStat.setHasElse(true);
          setLocationReference(BehActions, identifier) ; 
          IfStat.getBehaviorActionsOwned().add(BehActions);
         }
       )?
       END IF
       { 
        BehAction.setCondStatementOwned(IfStat);
        BehAction.setIf(true);
       }
     )
   |
     //for statement
     ( identifier=FOR LPAREN { ForStat = AadlBaF.createForOrForAllStatement(); 
                               setLocationReference(ForStat, identifier); 
                               BehAction.setLocationReference(ForStat.getLocationReference()) ; } 
       identifier=IDENT {  
                           Identifier Id = AadlBaF.createIdentifier();
                           Id.setId(identifier.getText());
                           setLocationReference(Id, identifier);
                           ForStat.setElement(Id);
                        }
       ( COLON dt=unique_component_classifier_reference
         {
            ForStat.setDataUniqueCmtClassRef(dt);
         }
       )?
       IN EltVal=element_values RPAREN { ForStat.setElementValuesOwned(EltVal); }
       identifier=LCURLY BehActions=behavior_actions RCURLY { ForStat.setBehaviorActionsOwned(BehActions); }
       { 
        BehAction.setCondStatementOwned(ForStat);
        BehAction.setFor(true);
        BehAction.setLoop(true);
        setLocationReference(BehActions, identifier) ; 
       }
     )
   |
     //forall statement
     ( identifier=FORALL LPAREN 
       { 
        ForStat = AadlBaF.createForOrForAllStatement();
        ForStat.setForAll(true);
        setLocationReference(ForStat, identifier); 
        BehAction.setLocationReference(ForStat.getLocationReference()) ; 
       }
       identifier=IDENT {  
                           Identifier Id = AadlBaF.createIdentifier();
                           Id.setId(identifier.getText());
                           setLocationReference(Id, identifier);
                           ForStat.setElement(Id);
                        }
       ( COLON dt=unique_component_classifier_reference 
         {
          ForStat.setDataUniqueCmtClassRef(dt);
         }
       )?
       IN EltVal=element_values RPAREN { ForStat.setElementValuesOwned(EltVal); }
       identifier=LCURLY BehActions=behavior_actions RCURLY { ForStat.setBehaviorActionsOwned(BehActions); }
       { 
        BehAction.setCondStatementOwned(ForStat);
        BehAction.setFor(true);
        BehAction.setLoop(true);
        setLocationReference(BehActions, identifier) ; 
       }
     )
   |
     //while statement
     ( identifier1=WHILE identifier2=LPAREN ValExpr=value_expression RPAREN 
       identifier3=LCURLY BehActions=behavior_actions RCURLY 
       {
        WhileStatement WhileStat = AadlBaF.createWhileStatement();
        WhileStat.setValueExpressionOwned(ValExpr);
        WhileStat.setBehaviorActionsOwned(BehActions);
        BehAction.setCondStatementOwned(WhileStat);
        BehAction.setWhile(true);
        BehAction.setLoop(true);
        setLocationReference(WhileStat, identifier1); 
        BehAction.setLocationReference(WhileStat.getLocationReference()); 
        setLocationReference(ValExpr, identifier2) ; 
        setLocationReference(BehActions, identifier3) ; 
       }
     )
   |
     //do until statement
     ( identifier1=DO BehActions=behavior_actions UNTIL  
       identifier2=LPAREN ValExpr=value_expression RPAREN 
       {
        DoUntilStatement DoUnStat = AadlBaF.createDoUntilStatement();
        DoUnStat.setValueExpressionOwned(ValExpr);
        DoUnStat.setBehaviorActionsOwned(BehActions);
        BehAction.setCondStatementOwned(DoUnStat);
        BehAction.setDoUntil(true);
        BehAction.setLoop(true);
        setLocationReference(DoUnStat, identifier1); 
        setLocationReference(ValExpr, identifier2); 
        BehAction.setLocationReference(DoUnStat.getLocationReference()) ; 
        BehActions.setLocationReference(DoUnStat.getLocationReference()) ; 
       }
     )
   )   
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

/*
// if statement
     ( identifier1=IF identifier2=LPAREN ValExpr=value_expression RPAREN BehActions=behavior_actions 
       { 
        IfStat = AadlBaF.createIfStatement();
        IfStat.setValueExpressionOwned(ValExpr);
        IfStat.setBehaviorActionsOwned(BehActions);
        setLocationReference(IfStat, identifier1); 
        BehAction.setLocationReference(IfStat.getLocationReference()) ; 
        BehActions.setLocationReference(IfStat.getLocationReference()) ;  
        setLocationReference(ValExpr, identifier2); 
       }
       ( 
         identifier1=ELSIF identifier2=LPAREN ValExpr=value_expression RPAREN BehActions=behavior_actions
         {
          IfStat.setHasElsif(true);
          IfStat.setElsifValueExpressionOwned(ValExpr);
          IfStat.setElsifBehaviorActionsOwned(BehActions);
          setLocationReference(BehActions, identifier1) ; 
          setLocationReference(ValExpr, identifier2) ; 
         }
       )*
       (
         identifier=ELSE BehActions=behavior_actions
         {
          IfStat.setHasElse(true);
          IfStat.setElseBehaviorActionsOwned(BehActions);
          setLocationReference(BehActions, identifier) ; 
         }
       )?
       END IF
       { 
        BehAction.setCondStatementOwned(IfStat);
        BehAction.setIf(true);
       }
*/




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
     ( EdpName=name { EltVal = EdpName; } )
   |
     ( AdcRef=data_component_reference { EltVal = AdcRef; } )
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
   AssAct = AadlBaF.createAssignmentAction();
 }
  :
   Tar=target ASSIGN ( ValExpr=value_expression | ANY )
   {
    AssAct.setTargetOwned(Tar);
    AssAct.setLocationReference(Tar.getLocationReference());  
    if (ValExpr != null) {
     AssAct.setValueExpressionOwned(ValExpr);
     ValExpr.setLocationReference(Tar.getLocationReference()) ; 
    } else {
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
   Tar = AadlBaF.createTarget();
 }
  : 
    // Ambiguity between a name and a none qualified data component reference.
    // A DataComponentReference object is also used to store Name objects.
    // See data_component_reference method. 
    ( dt=data_component_reference
         {  Tar.setDataComponentReferenceOwned(dt);
            Tar.setLocationReference(dt.getLocationReference()); 
         }
    ) 
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}
// Old Target's algorithm
/*
target[EObject ParentContainer] returns [Target Tar]
 @init{
   Tar = AadlBaF.createTarget();
 }
  :
    ( nm=name { nm.setParentContainer(Tar) ;
                 Tar.setElementNameOwned(nm);
                 Tar.setLocationReference(nm.getLocationReference()); } )
   |
     ( dt=data_component_reference[Tar] {Tar.setDataComponentReferenceOwned(dt);
                                         Tar.setLocationReference(dt.getLocationReference()); } ) 
                                         
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}
*/

// communication_action ::= 
//   required_subprogram_access_name ! [ ( subprogram_parameter_list ) ]
// | subprogram_classifier_name ! [ ( subprogram_parameter_list ) ]
// | output_port_name ! [ ( value_expression ) ]
// | input_port_name >>
// | input_port_name ? [ ( target ) ]
// | required_data_access_name !<
// | required_data_access_name !>
communication_action returns [CommunicationAction CommAct]
 @init{
   CommAct = AadlBaF.createCommunicationAction();
   CommActionParameter CommActParam = null;
 }
  :
(
   (   ( 
         // The case of a subprogram unique component classifier reference
         // without qualified name and component implementation identifier
         // (an identifier alone) is parsed as a name.
         EltName=name { CommAct.setEltNameOwned(EltName);
                        CommAct.setLocationReference(
                                               EltName.getLocationReference()) ;
                      } 
         (
             EXCLAM { CommActParam=CommActionParameter.EXCLAMATION; }
           | 
             INTERROG { CommActParam=CommActionParameter.INTERROGATION; }
           |
             GGREATER { CommActParam=CommActionParameter.LEFT_LEFT; }
           |
             EXCLLESS { CommActParam=CommActionParameter.EXCLAMATION_LEFT; }
           | 
             EXCLGREATER { CommActParam=CommActionParameter.EXCLAMATION_RIGHT; }
         )  { CommAct.setActionType(CommActParam); }
       )
     | 
       (
         // The case of a subprogram unique component classifier reference
         // without qualified name and component implementation identifier
         // (an identifier alone) is parsed as a name.
         DataClassRef=unique_component_classifier_reference EXCLAM
         {
           CommAct.setDataUniqueComponentClassifierReference(DataClassRef);
           CommAct.setLocationReference(DataClassRef.getLocationReference());
         }
       )
   )
   ( identifier=LPAREN
       ( 
         SubpgmParamList=subprogram_parameter_list 
         { 
          CommAct.setSubpgmParamListOwned(SubpgmParamList);
          setLocationReference(SubpgmParamList, identifier) ; 
          EList<ParameterLabel> paramList = SubpgmParamList.getParameterList() ;
          if (paramList != null && paramList.size() > 0) 
          {
            paramList.get(0).setLocationReference(SubpgmParamList.getLocationReference()) ; 
          }
         }
       |
         ValExpr=value_expression
         {
          CommAct.setHasValueExpression(true);
          CommAct.setValueExprOwned(ValExpr);
          setLocationReference(ValExpr, identifier) ; 
         }
       |
         Tar=target
         {
          CommAct.setHasTarget(true);
          CommAct.setTarOwned(Tar);
         }
       )
       RPAREN
   )?
)

| 
   (
     identifier=CATCH LPAREN TIMEOUT RPAREN
     {
       CommAct.setCatchTimeout(true);
       setLocationReference(CommAct, identifier);
     }     
   )
|
   (
     identifier=STAR
          (
             EXCLLESS { CommActParam=CommActionParameter.EXCLAMATION_LEFT;}
           | 
             EXCLGREATER { CommActParam=CommActionParameter.EXCLAMATION_RIGHT;}
          )
          { CommAct.setActionType(CommActParam);
            CommAct.setAll(true);
            setLocationReference(CommAct, identifier);
          }
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}
/* //old algorithm
communication_action returns [CommunicationAction CommAct]
 @init{
   CommAct = AadlBaF.createCommunicationAction();
   CommActionParameter CommActParam = null;
 }
  :
   ( EltName=name { CommAct.setEltNameOwned(EltName);
                    CommAct.setLocationReference(EltName.getLocationReference()) ; } 
     (
       EXCLAM { CommActParam=CommActionParameter.EXCLAMATION; }
     | 
       INTERROG { CommActParam=CommActionParameter.INTERROGATION; }
     |
       GGREATER { CommActParam=CommActionParameter.LEFT_LEFT; }
     |
       EXCLLESS { CommActParam=CommActionParameter.EXCLAMATION_LEFT; }
     |
       EXCLGREATER { CommActParam=CommActionParameter.EXCLAMATION_RIGHT; }
     ) { CommAct.setActionType(CommActParam); }
     ( identifier=LPAREN
       ( 
         SubpgmParamList=subprogram_parameter_list 
         { 
          CommAct.setHasSpgParamList(true);
          CommAct.setSubpgmParamListOwned(SubpgmParamList);
          setLocationReference(SubpgmParamList, identifier) ; 
          EList<ParameterLabel> paramList = SubpgmParamList.getParameterList() ;
          if (paramList != null && paramList.size() > 0) 
          {
            paramList.get(0).setLocationReference(SubpgmParamList.getLocationReference()) ; 
          }
         }
       |
         ValExpr=value_expression
         {
          CommAct.setHasValueExpression(true);
          CommAct.setValueExprOwned(ValExpr);
          setLocationReference(ValExpr, identifier) ; 
         }
       |
         Tar=target
         {
          CommAct.setHasTarget(true);
          CommAct.setTarOwned(Tar);
         }
       )
     RPAREN )?   
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}
//*/

// timed_action ::= 
//   computation ( behavior_time [ , behavior_time ] )
// | delay ( behavior_time [ , behavior_time ] )
timed_action returns [TimedAction TimedAct]
 @init{
   TimedAct = AadlBaF.createTimedAction();
 }
  :
   ( identifier=COMPUTATION { TimedAct.setComputation(true); setLocationReference(TimedAct, identifier) ; }  
//    |
//     identifier=DELAY ) { setLocationReference(TimedAct, identifier) ; }  
   )  
   LPAREN
     BehTime=behavior_time {TimedAct.getBehaviorTimesOwned().add(BehTime); }
     (COMMA BehTime=behavior_time {TimedAct.getBehaviorTimesOwned().add(BehTime); } ) ?
   RPAREN
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// subprogram_parameter_list ::=
//   parameter_label { , parameter_label }*

subprogram_parameter_list returns [SubprogramParameterList SpgParamList]
 @init{
   // SG SpgParamList's location reference is set in communication_action
   SpgParamList = AadlBaF.createSubprogramParameterList();
 }
  : // SG XXX the first parameter_label's location reference is set in communication_action the other are set thanks to COMMA token 
   ParamLabel=parameter_label { SpgParamList.getParameterList().add(ParamLabel);
                                            } 
   (identifier=COMMA ParamLabel=parameter_label { SpgParamList.getParameterList().add(ParamLabel);
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
  :
   ( // SG XXX ValExpr's location reference is set in subprogram_parameter_list, Tar is not modified
     ValExpr=value_expression { ParamLabel = ValExpr; }
   |
     Tar=target { ParamLabel = Tar; }
   )   
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// data_component_reference ::=
//   data_subcomponent_name { . data_subcomponent_name }*
// | data_access_feature_name { . data_subcomponent_name }*
data_component_reference returns [DataComponentReference DataCptRef]
 @init{
   DataCptRef = AadlBaF.createDataComponentReference ();
 }
  :
   EltName=name { DataCptRef.getElementsNameOwned().add(EltName);
                  DataCptRef.setLocationReference(EltName.getLocationReference()) ; 
                } 
   (DOT EltName=name {DataCptRef.getElementsNameOwned().add(EltName);}
   )*
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// name ::= identifier { array_index }*
name returns [Name EltName]
 @init{
   EltName = AadlBaF.createName();
 }
  :
   identifier=IDENT { Identifier Id = AadlBaF.createIdentifier() ;
                      Id.setId(identifier.getText());    
                      EltName.setIdentifier(Id) ;
                      setLocationReference(Id, identifier); 
                      setLocationReference(EltName, identifier) ;
                    } 
   ( ArrInd=array_index { EltName.getArrayIndexListOwned().add(ArrInd);})*
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// array_index :: [ integer_value_variable ]
array_index returns [ArrayIndex ArrInd]
 @init{
   ArrInd = AadlBaF.createArrayIndex();
 }
  :
   identifier=LBRACK Val=value_variable { 
                                          ArrInd.setIntegerValueVariableOwned(Val);
                                          setLocationReference(ArrInd, identifier); 
                                        } RBRACK 
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

//---------------------------------------------------------
// END : ANNEX X.6 Behavior Action Language
//---------------------------------------------------------
//---------------------------------------------------------

//---------------------------------------------------------
//---------------------------------------------------------
// BEGIN : ANNEX X.7 Behavior Expression Language
//---------------------------------------------------------

fact_value returns [Value Val]
@init
 {
   PropertyConstant PropertyCst = null ;
 }
  :
   (
       (  id1=IDENT DOUBLECOLON id2=IDENT
            {
              PropertyCst = AadlBaF.createPropertyConstant();
              PropertyCst.setQualifiedName(id1.getText());
              PropertyCst.setName(id2.getText());
              setLocationReference(PropertyCst, id1);
              Val = PropertyCst ;
            }
         | // Cases of value variable and unresolved case between propertyset
           // constant without qualified name and one name value variable
           // (ex: port name, data component reference, subprogram parameter, 
           // local variable).
           ValueVar=value_variable {Val=ValueVar;}
       )
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

/* old algorithm
value returns [Value Val]
 @init{
 }
  :
   (
     ( ValVar=value_variable { Val = ValVar; } )
   |
     ( ValCst=value_constant { Val = ValCst; } )
   |
     ( identifier=LPAREN ValExpr=value_expression RPAREN { setLocationReference(ValExpr, identifier) ; Val = ValExpr; } ) 
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}
*/
// value_variable ::=
//   incoming_port_name
// | incoming_port_name ?
// | subprogram_parameter_name
// | local_variable_name
// | data_component_reference
// | port_name ' count
// | port_name ' fresh

value_variable returns [ValueVariable ValueVar]

 @init{
   ValueVar = AadlBaF.createValueVariable();
   DataComponentReference DataCptRef = null;
 }
  :
   EltName=name
      { ValueVar.setLocationReference(EltName.getLocationReference()) ; 
      } 
   (
         ( DOT SubName=name
             {
               DataCptRef = AadlBaF.createDataComponentReference ();
               DataCptRef.setLocationReference(EltName.getLocationReference()) ;
               DataCptRef.getElementsNameOwned().add(EltName);
               DataCptRef.getElementsNameOwned().add(SubName);
               
               ValueVar.setHasDataCptRef(true);
               ValueVar.setElementNameOwned(null);
               ValueVar.setDataComponentReferenceOwned(DataCptRef);
             }
             ( DOT SubName=name
                 {
                   DataCptRef.getElementsNameOwned().add(SubName);
                 }
             )*
         )
       |   
          INTERROG {ValueVar.setInterrogation(true);}
       |
          TICK (   COUNT { ValueVar.setCount(true);} 
                 | 
                   FRESH {ValueVar.setFresh(true);}
               )
   )?
   {
     if (DataCptRef == null) { ValueVar.setElementNameOwned(EltName); }
   }
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}

// Old value_variable algorithm
/*
value_variable returns [ValueVariable ValueVar]

 @init{
   ValueVar = AadlBaF.createValueVariable();
 }
  :
   ( ( EltName=name { EltName.setParentContainer(ValueVar) ;
                      ValueVar.setElementNameOwned(EltName);
                      ValueVar.setLocationReference(EltName.getLocationReference()) ; } 
       ( INTERROG { ValueVar.setInterrogation(true); } 
       |
         TICK ( COUNT { ValueVar.setCount(true); } | FRESH { ValueVar.setFresh(true); } )
       )? 
      )
   |
     ( DataCptRef=data_component_reference[ValueVar] 
       {
        ValueVar.setHasDataCptRef(true); 
        ValueVar.setDataComponentReferenceOwned(DataCptRef);
        ValueVar.setLocationReference(DataCptRef.getLocationReference()) ;  
       } 
     )
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
} */




// value_constant ::= 
//   boolean_literal
// | numeric_literal 
// | string_literal 
// | property_constant
// | property_value
value_constant returns [ValueConstant ValueCons]
 @init{
 }
  :
   ( 
     bl=boolean_literal { ValueCons = bl; }
   |
     nl=numeric_literal { ValueCons = nl; }
   |
     st=string_literal { ValueCons = st; }
   |
     pc=property_constant { ValueCons = pc; }
   |
     pv=property_value { ValueCons = pv; } 
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


// value_expression ::=
//   relation { logical_operator relation }* 
value_expression returns [ValueExpression ValueExpr]
 @init{
   // Location reference is set by the caller
   ValueExpr = AadlBaF.createValueExpression();
 }
  :
   ( 
     Rel=relation { ValueExpr.getRelationsOwned().add(Rel); }
     (
       LogicalOp=logical_operator Rel=relation
       {
        ValueExpr.setHasLogicalOperator(true);
        ValueExpr.getLogicalOperatorsOwned().add(LogicalOp);
        ValueExpr.getRelationsOwned().add(Rel);
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
   // TODO location reference
   Rel = AadlBaF.createRelation();
 }
  :
   SimpleExpr=simple_expression { Rel.setSimpleExpressionOwned(SimpleExpr);}
   (
     RelationalOp=relational_operator SimpleExpr=simple_expression 
     {
      Rel.setHasRelationalOperator(true);
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
 // TODO location reference
   SimpleExpr = AadlBaF.createSimpleExpression();
 }
  :
   (
     UnaryAddOp=unary_adding_operator 
     {
      SimpleExpr.setHasUnaryAddingOperator(true); 
      SimpleExpr.setUnaryAddingOperatorOwned(UnaryAddOp);
     }
   )?
   
   tm=term { SimpleExpr.getTermsOwned().add(tm); }
   
   (
     BinaryAddOp=binary_adding_operator tm=term
     {
      SimpleExpr.setHasBinaryAddingOperator(true);
      SimpleExpr.getBinaryAddingOperatorOwned().add(BinaryAddOp);
      SimpleExpr.getTermsOwned().add(tm);
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
 // TODO location reference
   tm = AadlBaF.createTerm();
 }
  :
   fact=factor { tm.getFactorsOwned().add(fact); }
   (
     MultiplyingOp=multiplying_operator fact=factor
     {
      tm.setHasMultiplyingOperator(true);
      tm.getMultiplyingOperatorsOwned().add(MultiplyingOp);
      tm.getFactorsOwned().add(fact);
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
 // TODO complete location reference
   Fact = AadlBaF.createFactor();
 }
  :
   (
    ( val=value { Fact.setValueOwned(val);
                        Fact.setLocationReference(val.getLocationReference()) ;} 
      (
        BinaryNumOp=binary_numeric_operator val2=value
        {
         Fact.setHasBinaryNumericOperator(true);
         Fact.setBinaryNumericOperatorOwned(BinaryNumOp);
         Fact.setValueSdOwned(val2);
        }
      )?
    )
   |
    ( UnaryNumOp=unary_numeric_operator val=value
      {
         Fact.setHasUnaryNumericOperator(true);
         Fact.setUnaryNumericOperatorOwned(UnaryNumOp);
         Fact.setValueOwned(val);
      }
    )
   |
    ( UnaryBoolOp=unary_boolean_operator val=value
      {
         Fact.setHasUnaryBooleanOperator(true);
         Fact.setUnaryBooleanOperatorOwned(UnaryBoolOp);
         Fact.setValueOwned(val);
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
   //BinaryAddOp = AadlBaF.createBinaryAddingOperator();
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
   BoolLit = AadlBaF.createBooleanLiteral();
 }
  :
   (
     identifier=TRUE { BoolLit.setBoolValue(true);}
   |
     identifier=FALSE { BoolLit.setBoolValue(false);}
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
   IntRange = AadlBaF.createIntegerRange();
 }
  :
   (
     IntValue=integer_value DOTDOT IntValue2=integer_value
     {
       IntRange.setLowerIntegerValue(IntValue);
       IntRange.setUpperIntegerValue(IntValue2);
       IntValue.setLocationReference(IntValue.getLocationReference()); 
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
  :
   (
     ValTmp=fact_value { IntVal = (IntegerValue) ValTmp ;}              
   )
   
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}
/* old algorithm
integer_value returns [IntegerValue IntVal]
 @init{
 }
  :
   (
     IntValueVar=value_variable { IntVal=IntValueVar; }
   |
     IntValueCst=value_constant { IntVal=IntValueCst; }
   )
   
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}
*/


// behavior_time ::= integer_value unit_identifier
behavior_time returns [BehaviorTime BehTime]
 @init{
   BehTime = AadlBaF.createBehaviorTime();
 }
  :
   (
     IntValue=integer_value UnitIdent=IDENT
     {
      BehTime.setIntegerValueOwned(IntValue);
      BehTime.setUnitIdentifier(UnitIdent.getText()); // SG XXX should we create an object for time unit ??? With an object, time unit could be located. 
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
property_constant returns [PropertyConstant PropertyCst]
 @init{
   PropertyCst = AadlBaF.createPropertyConstant();
 }
  :
   (
     ( PropertySetId=IDENT DOUBLECOLON { PropertyCst.setQualifiedName(PropertySetId.getText());
                                         setLocationReference(PropertyCst, PropertySetId) ; } )?  
     PropertyCstId=IDENT { PropertyCst.setName(PropertyCstId.getText());
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


// property_value ::=
//   [ property_set_identifier :: ] property_value_identifier
property_value returns [PropertyValue PropertyVal]
 @init{
   PropertyVal = AadlBaF.createPropertyValue();
 }
  :
   (
     ( PropertySetId=IDENT DOUBLECOLON { PropertyVal.setQualifiedName(PropertySetId.getText());
                                         setLocationReference(PropertyVal, PropertySetId) ; } )? 
     PropertyValId=IDENT { PropertyVal.setName(PropertyValId.getText());
                           if (PropertyVal.getLocationReference() == null) 
                           {
                              setLocationReference(PropertyVal, PropertyValId) ;
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
numeric_literal returns [NumericLiteral NumLit]
 @init{
   NumLit = AadlBaF.createNumericLiteral();
   char sign = ' ';
 }
  :
   (
     NumVal=INTEGER_LIT
     {
       String str = NumVal.getText();
       NumLit.setNumValue(sign == ' ' ? str:sign+str); // SG XXX ERROR : is sign ever modified ; numeric literal can't be a real ????
       setLocationReference(NumLit, NumVal) ; 
     }
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
   StringLit = AadlBaF.createStringLiteral();
 }
  :
   (
     sl=STRING_LITERAL
      {
        String str = sl.getText();
        // stripout the quotes
        str = str.substring(1,str.length()-1);
        StringLit.setStringValue(str);
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
   Num = AadlBaF.createNumeral();
 }
  :
   ( 
     NumVal=INTEGER_LIT 
     { 
      
      String tmp = NumVal.getText().replaceAll("_", "");
      Num.setNumeralValue(Integer.parseInt(tmp));
      setLocationReference(Num, NumVal) ; // SG
     } 
   )
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMICOLON);
  input.consume();
}


//---------------------------------------------------------
// END : ANNEX X.7 Behavior Expression Language
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
