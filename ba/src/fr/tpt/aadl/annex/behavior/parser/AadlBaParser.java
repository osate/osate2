// $ANTLR 3.4 AadlBa.g 2013-04-30 11:28:23
 
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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

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
@SuppressWarnings({"all", "warnings", "unchecked"})
public class AadlBaParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ABS", "AND", "ANY", "ASSIGN", "BASE", "BASED_INTEGER", "COLON", "COMMA", "COMPLETE", "COMPUTATION", "CONCAT", "COUNT", "DIGIT", "DISPATCH", "DIVIDE", "DO", "DOT", "DOTDOT", "DOUBLECOLON", "ELSE", "ELSIF", "END", "EQUAL", "ESC", "EXCLAM", "EXCLGREATER", "EXCLLESS", "EXPONENT", "EXTENDED_DIGIT", "FALSE", "FINAL", "FOR", "FORALL", "FRESH", "FROZEN", "GGREATER", "GREATEROREQUAL", "GREATERTHAN", "HASH", "HEX_DIGIT", "IDENT", "IF", "IN", "INITIAL", "INTEGER_LIT", "INTERROG", "INT_EXPONENT", "LBRACK", "LCURLY", "LESSOREQUAL", "LESSTHAN", "LETTER", "LPAREN", "LTRANS", "MINUS", "MOD", "NOT", "NOTEQUAL", "ON", "OR", "OTHERWISE", "PLUS", "RBRACK", "RCURLY", "REAL_LIT", "REM", "RPAREN", "RTRANS", "SEMICOLON", "SL_COMMENT", "STAR", "STARSTAR", "STATE", "STATES", "STOP", "STRING_LITERAL", "TICK", "TIMEOUT", "TRANSITIONS", "TRUE", "UNTIL", "VARIABLES", "WHILE", "WS", "XOR"
    };

    public static final int EOF=-1;
    public static final int ABS=4;
    public static final int AND=5;
    public static final int ANY=6;
    public static final int ASSIGN=7;
    public static final int BASE=8;
    public static final int BASED_INTEGER=9;
    public static final int COLON=10;
    public static final int COMMA=11;
    public static final int COMPLETE=12;
    public static final int COMPUTATION=13;
    public static final int CONCAT=14;
    public static final int COUNT=15;
    public static final int DIGIT=16;
    public static final int DISPATCH=17;
    public static final int DIVIDE=18;
    public static final int DO=19;
    public static final int DOT=20;
    public static final int DOTDOT=21;
    public static final int DOUBLECOLON=22;
    public static final int ELSE=23;
    public static final int ELSIF=24;
    public static final int END=25;
    public static final int EQUAL=26;
    public static final int ESC=27;
    public static final int EXCLAM=28;
    public static final int EXCLGREATER=29;
    public static final int EXCLLESS=30;
    public static final int EXPONENT=31;
    public static final int EXTENDED_DIGIT=32;
    public static final int FALSE=33;
    public static final int FINAL=34;
    public static final int FOR=35;
    public static final int FORALL=36;
    public static final int FRESH=37;
    public static final int FROZEN=38;
    public static final int GGREATER=39;
    public static final int GREATEROREQUAL=40;
    public static final int GREATERTHAN=41;
    public static final int HASH=42;
    public static final int HEX_DIGIT=43;
    public static final int IDENT=44;
    public static final int IF=45;
    public static final int IN=46;
    public static final int INITIAL=47;
    public static final int INTEGER_LIT=48;
    public static final int INTERROG=49;
    public static final int INT_EXPONENT=50;
    public static final int LBRACK=51;
    public static final int LCURLY=52;
    public static final int LESSOREQUAL=53;
    public static final int LESSTHAN=54;
    public static final int LETTER=55;
    public static final int LPAREN=56;
    public static final int LTRANS=57;
    public static final int MINUS=58;
    public static final int MOD=59;
    public static final int NOT=60;
    public static final int NOTEQUAL=61;
    public static final int ON=62;
    public static final int OR=63;
    public static final int OTHERWISE=64;
    public static final int PLUS=65;
    public static final int RBRACK=66;
    public static final int RCURLY=67;
    public static final int REAL_LIT=68;
    public static final int REM=69;
    public static final int RPAREN=70;
    public static final int RTRANS=71;
    public static final int SEMICOLON=72;
    public static final int SL_COMMENT=73;
    public static final int STAR=74;
    public static final int STARSTAR=75;
    public static final int STATE=76;
    public static final int STATES=77;
    public static final int STOP=78;
    public static final int STRING_LITERAL=79;
    public static final int TICK=80;
    public static final int TIMEOUT=81;
    public static final int TRANSITIONS=82;
    public static final int TRUE=83;
    public static final int UNTIL=84;
    public static final int VARIABLES=85;
    public static final int WHILE=86;
    public static final int WS=87;
    public static final int XOR=88;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public AadlBaParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public AadlBaParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return AadlBaParser.tokenNames; }
    public String getGrammarFileName() { return "AadlBa.g"; }


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

      private void reportError(String msg, Token locationRef)
      {
         int line, col ;
         
         if (locationRef == null)
         {
           int index = input.index() ;
           if (index >= input.size())
           {
             index-- ;
           }
           
           locationRef = input.get(index) ;
         }
         
         line = locationRef.getLine() ;
         col = locationRef.getCharPositionInLine() + 1 ; // Zero index based.
         
         msg += " at line " + line + ", col " + col ; 
         errReporter.error(this.getFilename(), line, msg);
         consumeUntil(input,SEMICOLON);
         input.consume();
         state.failed = true ;
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
        int line = token.getLine() - _lineOffset ;
        
        AadlBaLocationReference location = new AadlBaLocationReference(_annexOffset,
                                                 filename, line, offset, length, column,
                                                 behaviorElementId);
        
        obj.setLocationReference(location);
      
      }
      
      private BehaviorAnnex _ba = null ;
      private int _annexOffset=0;
      private int _lineOffset=0 ;
      
      public void setAnnexOffset(int offset)
      {
      	_annexOffset = offset;
      }
      
      // Default highlighter does nothing.
      private AadlBaHighlighter _ht = new DefaultAadlBaHighlighter() ;
      
      public void setHighlighter(AadlBaHighlighter ht)
      {
        _ht = ht ;
      }
      
      private void highlight(Token token, String id)
      {
        _ht.addToHighlighting(_annexOffset, token, id);  
      }



    // $ANTLR start "behavior_annex"
    // AadlBa.g:433:1: behavior_annex returns [BehaviorAnnex BehAnnex] : (keyword_var= VARIABLES (lbv= behavior_variable_list[BehAnnex] )+ )? (keyword= STATES (lbs= behavior_state_list )+ )? (keyword= TRANSITIONS (BehTrans= behavior_transition )+ )? ;
    public final BehaviorAnnex behavior_annex() throws RecognitionException {
        BehaviorAnnex BehAnnex = null;


        Token keyword_var=null;
        Token keyword=null;
        List<BehaviorVariable> lbv =null;

        List<BehaviorState> lbs =null;

        DeclarativeBehaviorTransition BehTrans =null;



           BehAnnex = _fact.createBehaviorAnnex();
           _ba = BehAnnex ;
           
           int line = input.get(0).getLine() ;
           
           // compute lineOffset here.
           _lineOffset = 0 ;
           AadlBaLocationReference location = new AadlBaLocationReference(
                                                 _annexOffset, filename, line);
           BehAnnex.setLocationReference(location) ; 
         
        try {
            // AadlBa.g:446:3: ( (keyword_var= VARIABLES (lbv= behavior_variable_list[BehAnnex] )+ )? (keyword= STATES (lbs= behavior_state_list )+ )? (keyword= TRANSITIONS (BehTrans= behavior_transition )+ )? )
            // AadlBa.g:447:4: (keyword_var= VARIABLES (lbv= behavior_variable_list[BehAnnex] )+ )? (keyword= STATES (lbs= behavior_state_list )+ )? (keyword= TRANSITIONS (BehTrans= behavior_transition )+ )?
            {
            // AadlBa.g:447:4: (keyword_var= VARIABLES (lbv= behavior_variable_list[BehAnnex] )+ )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==VARIABLES) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // AadlBa.g:447:6: keyword_var= VARIABLES (lbv= behavior_variable_list[BehAnnex] )+
                    {
                    keyword_var=(Token)match(input,VARIABLES,FOLLOW_VARIABLES_in_behavior_annex1177); if (state.failed) return BehAnnex;

                    if ( state.backtracking==0 ) {highlight(keyword_var, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}

                    // AadlBa.g:448:8: (lbv= behavior_variable_list[BehAnnex] )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==IDENT) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // AadlBa.g:448:10: lbv= behavior_variable_list[BehAnnex]
                    	    {
                    	    pushFollow(FOLLOW_behavior_variable_list_in_behavior_annex1192);
                    	    lbv=behavior_variable_list(BehAnnex);

                    	    state._fsp--;
                    	    if (state.failed) return BehAnnex;

                    	    if ( state.backtracking==0 ) { BehAnnex.getVariables().addAll(lbv);}

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt1 >= 1 ) break loop1;
                    	    if (state.backtracking>0) {state.failed=true; return BehAnnex;}
                                EarlyExitException eee =
                                    new EarlyExitException(1, input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);


                    }
                    break;

            }


            // AadlBa.g:451:4: (keyword= STATES (lbs= behavior_state_list )+ )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==STATES) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // AadlBa.g:451:6: keyword= STATES (lbs= behavior_state_list )+
                    {
                    keyword=(Token)match(input,STATES,FOLLOW_STATES_in_behavior_annex1217); if (state.failed) return BehAnnex;

                    if ( state.backtracking==0 ) {highlight(keyword, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}

                    // AadlBa.g:452:8: (lbs= behavior_state_list )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==IDENT) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // AadlBa.g:452:10: lbs= behavior_state_list
                    	    {
                    	    pushFollow(FOLLOW_behavior_state_list_in_behavior_annex1232);
                    	    lbs=behavior_state_list();

                    	    state._fsp--;
                    	    if (state.failed) return BehAnnex;

                    	    if ( state.backtracking==0 ) { BehAnnex.getStates().addAll(lbs); }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                    	    if (state.backtracking>0) {state.failed=true; return BehAnnex;}
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);


                    }
                    break;

            }


            // AadlBa.g:455:4: (keyword= TRANSITIONS (BehTrans= behavior_transition )+ )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==TRANSITIONS) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // AadlBa.g:455:6: keyword= TRANSITIONS (BehTrans= behavior_transition )+
                    {
                    keyword=(Token)match(input,TRANSITIONS,FOLLOW_TRANSITIONS_in_behavior_annex1256); if (state.failed) return BehAnnex;

                    if ( state.backtracking==0 ) {highlight(keyword, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}

                    // AadlBa.g:456:8: (BehTrans= behavior_transition )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==IDENT) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // AadlBa.g:456:10: BehTrans= behavior_transition
                    	    {
                    	    pushFollow(FOLLOW_behavior_transition_in_behavior_annex1271);
                    	    BehTrans=behavior_transition();

                    	    state._fsp--;
                    	    if (state.failed) return BehAnnex;

                    	    if ( state.backtracking==0 ) {BehAnnex.getTransitions().add(BehTrans); }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                    	    if (state.backtracking>0) {state.failed=true; return BehAnnex;}
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    }
                    break;

            }


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return BehAnnex;
    }
    // $ANTLR end "behavior_annex"



    // $ANTLR start "behavior_variable_list"
    // AadlBa.g:468:1: behavior_variable_list[BehaviorAnnex ba] returns [List<BehaviorVariable> lbv] : bv= behavior_variable ( COMMA bv= behavior_variable )* COLON DataClassRef= unique_component_classifier_reference SEMICOLON ;
    public final List<BehaviorVariable> behavior_variable_list(BehaviorAnnex ba) throws RecognitionException {
        List<BehaviorVariable> lbv = null;


        BehaviorVariable bv =null;

        QualifiedNamedElement DataClassRef =null;



           lbv = new ArrayList<BehaviorVariable>() ;
         
        try {
            // AadlBa.g:472:3: (bv= behavior_variable ( COMMA bv= behavior_variable )* COLON DataClassRef= unique_component_classifier_reference SEMICOLON )
            // AadlBa.g:474:4: bv= behavior_variable ( COMMA bv= behavior_variable )* COLON DataClassRef= unique_component_classifier_reference SEMICOLON
            {
            pushFollow(FOLLOW_behavior_variable_in_behavior_variable_list1326);
            bv=behavior_variable();

            state._fsp--;
            if (state.failed) return lbv;

            if ( state.backtracking==0 ) {
                 lbv.add(bv) ;
               }

            // AadlBa.g:479:4: ( COMMA bv= behavior_variable )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==COMMA) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // AadlBa.g:479:6: COMMA bv= behavior_variable
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_behavior_variable_list1343); if (state.failed) return lbv;

            	    pushFollow(FOLLOW_behavior_variable_in_behavior_variable_list1347);
            	    bv=behavior_variable();

            	    state._fsp--;
            	    if (state.failed) return lbv;

            	    if ( state.backtracking==0 ) {
            	           lbv.add(bv) ;
            	         }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            match(input,COLON,FOLLOW_COLON_in_behavior_variable_list1370); if (state.failed) return lbv;

            pushFollow(FOLLOW_unique_component_classifier_reference_in_behavior_variable_list1382);
            DataClassRef=unique_component_classifier_reference();

            state._fsp--;
            if (state.failed) return lbv;

            if ( state.backtracking==0 ) {
                  DeclarativeUtils.setEcontainer(_ba, DataClassRef);
                  
                  for(BehaviorVariable tmp : lbv)
                  {
                    tmp.setDataClassifier(DataClassRef);
                  }
               }

            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_behavior_variable_list1392); if (state.failed) return lbv;

            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return lbv;
    }
    // $ANTLR end "behavior_variable_list"



    // $ANTLR start "behavior_variable"
    // AadlBa.g:507:1: behavior_variable returns [BehaviorVariable bv] : identifier_ident= IDENT ( LBRACK IntValue= integer_value_constant RBRACK )* ;
    public final BehaviorVariable behavior_variable() throws RecognitionException {
        BehaviorVariable bv = null;


        Token identifier_ident=null;
        IntegerValueConstant IntValue =null;



           bv = _fact.createBehaviorVariable();
         
        try {
            // AadlBa.g:512:3: (identifier_ident= IDENT ( LBRACK IntValue= integer_value_constant RBRACK )* )
            // AadlBa.g:513:5: identifier_ident= IDENT ( LBRACK IntValue= integer_value_constant RBRACK )*
            {
            identifier_ident=(Token)match(input,IDENT,FOLLOW_IDENT_in_behavior_variable1428); if (state.failed) return bv;

            if ( state.backtracking==0 ) { 
                                   setLocationReference(bv, identifier_ident);
                                   bv.setName(identifier_ident.getText()) ;
                                 }

            // AadlBa.g:517:5: ( LBRACK IntValue= integer_value_constant RBRACK )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==LBRACK) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // AadlBa.g:517:7: LBRACK IntValue= integer_value_constant RBRACK
            	    {
            	    match(input,LBRACK,FOLLOW_LBRACK_in_behavior_variable1438); if (state.failed) return bv;

            	    pushFollow(FOLLOW_integer_value_constant_in_behavior_variable1442);
            	    IntValue=integer_value_constant();

            	    state._fsp--;
            	    if (state.failed) return bv;

            	    match(input,RBRACK,FOLLOW_RBRACK_in_behavior_variable1444); if (state.failed) return bv;

            	    if ( state.backtracking==0 ) { 
            	            DeclarativeArrayDimension dad = _decl.createDeclarativeArrayDimension();
            	            dad.setLocationReference(IntValue.getLocationReference()) ;
            	            dad.setDimension(IntValue) ;
            	            bv.getArrayDimensions().add(dad); 
            	          }

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return bv;
    }
    // $ANTLR end "behavior_variable"



    // $ANTLR start "qualifiable_named_element"
    // AadlBa.g:535:1: qualifiable_named_element[QualifiedNamedElement qne] : ( (identifier1= IDENT DOUBLECOLON )* identifier2= IDENT ( DOT identifier3= IDENT )? ) ;
    public final void qualifiable_named_element(QualifiedNamedElement qne) throws RecognitionException {
        Token identifier1=null;
        Token identifier2=null;
        Token identifier3=null;


                String id1 = "";
                String id2 = "";
              
        try {
            // AadlBa.g:540:3: ( ( (identifier1= IDENT DOUBLECOLON )* identifier2= IDENT ( DOT identifier3= IDENT )? ) )
            // AadlBa.g:541:4: ( (identifier1= IDENT DOUBLECOLON )* identifier2= IDENT ( DOT identifier3= IDENT )? )
            {
            // AadlBa.g:541:4: ( (identifier1= IDENT DOUBLECOLON )* identifier2= IDENT ( DOT identifier3= IDENT )? )
            // AadlBa.g:542:5: (identifier1= IDENT DOUBLECOLON )* identifier2= IDENT ( DOT identifier3= IDENT )?
            {
            // AadlBa.g:542:5: (identifier1= IDENT DOUBLECOLON )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==IDENT) ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1==DOUBLECOLON) ) {
                        alt9=1;
                    }


                }


                switch (alt9) {
            	case 1 :
            	    // AadlBa.g:542:7: identifier1= IDENT DOUBLECOLON
            	    {
            	    identifier1=(Token)match(input,IDENT,FOLLOW_IDENT_in_qualifiable_named_element1499); if (state.failed) return ;

            	    match(input,DOUBLECOLON,FOLLOW_DOUBLECOLON_in_qualifiable_named_element1501); if (state.failed) return ;

            	    if ( state.backtracking==0 ) { 
            	            id1=id1+(id1.length() == 0 ? "":"::")+identifier1.getText();
            	          }

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            identifier2=(Token)match(input,IDENT,FOLLOW_IDENT_in_qualifiable_named_element1529); if (state.failed) return ;

            if ( state.backtracking==0 ) { id2=identifier2.getText(); }

            // AadlBa.g:550:5: ( DOT identifier3= IDENT )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==DOT) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // AadlBa.g:550:7: DOT identifier3= IDENT
                    {
                    match(input,DOT,FOLLOW_DOT_in_qualifiable_named_element1544); if (state.failed) return ;

                    identifier3=(Token)match(input,IDENT,FOLLOW_IDENT_in_qualifiable_named_element1548); if (state.failed) return ;

                    if ( state.backtracking==0 ) { id2=id2+"."+identifier3.getText(); }

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
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
                   setLocationReference(qne, identifier2);
                 }
                 else
                 {
                   setLocationReference(qne, identifier2);
                 }
               }

            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "qualifiable_named_element"



    // $ANTLR start "unique_component_classifier_reference"
    // AadlBa.g:581:1: unique_component_classifier_reference returns [QualifiedNamedElement DataClassRef] : ( qualifiable_named_element[DataClassRef] ) ;
    public final QualifiedNamedElement unique_component_classifier_reference() throws RecognitionException {
        QualifiedNamedElement DataClassRef = null;



           DataClassRef = _decl.createQualifiedNamedElement();
         
        try {
            // AadlBa.g:585:3: ( ( qualifiable_named_element[DataClassRef] ) )
            // AadlBa.g:586:4: ( qualifiable_named_element[DataClassRef] )
            {
            // AadlBa.g:586:4: ( qualifiable_named_element[DataClassRef] )
            // AadlBa.g:587:6: qualifiable_named_element[DataClassRef]
            {
            pushFollow(FOLLOW_qualifiable_named_element_in_unique_component_classifier_reference1604);
            qualifiable_named_element(DataClassRef);

            state._fsp--;
            if (state.failed) return DataClassRef;

            }


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return DataClassRef;
    }
    // $ANTLR end "unique_component_classifier_reference"



    // $ANTLR start "behavior_state_list"
    // AadlBa.g:603:1: behavior_state_list returns [List<BehaviorState> lbs] : identifier4= IDENT ( COMMA identifier5= IDENT )* COLON ( (keyword_init= INITIAL )? (keyword_complete= COMPLETE )? (keyword_final= FINAL )? keyword= STATE SEMICOLON ) ;
    public final List<BehaviorState> behavior_state_list() throws RecognitionException {
        List<BehaviorState> lbs = null;


        Token identifier4=null;
        Token identifier5=null;
        Token keyword_init=null;
        Token keyword_complete=null;
        Token keyword_final=null;
        Token keyword=null;


           lbs = new ArrayList<BehaviorState>() ;
         
        try {
            // AadlBa.g:607:3: (identifier4= IDENT ( COMMA identifier5= IDENT )* COLON ( (keyword_init= INITIAL )? (keyword_complete= COMPLETE )? (keyword_final= FINAL )? keyword= STATE SEMICOLON ) )
            // AadlBa.g:608:5: identifier4= IDENT ( COMMA identifier5= IDENT )* COLON ( (keyword_init= INITIAL )? (keyword_complete= COMPLETE )? (keyword_final= FINAL )? keyword= STATE SEMICOLON )
            {
            identifier4=(Token)match(input,IDENT,FOLLOW_IDENT_in_behavior_state_list1649); if (state.failed) return lbs;

            if ( state.backtracking==0 ) {
                    BehaviorState bs = _fact.createBehaviorState() ;
                    bs.setName(identifier4.getText());
                    setLocationReference(bs, identifier4); 
                    lbs.add(bs) ; 
                  }

            // AadlBa.g:615:4: ( COMMA identifier5= IDENT )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==COMMA) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // AadlBa.g:615:6: COMMA identifier5= IDENT
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_behavior_state_list1665); if (state.failed) return lbs;

            	    identifier5=(Token)match(input,IDENT,FOLLOW_IDENT_in_behavior_state_list1669); if (state.failed) return lbs;

            	    if ( state.backtracking==0 ) {
            	            BehaviorState bs = _fact.createBehaviorState() ;
            	            bs.setName(identifier5.getText());
            	            setLocationReference(bs, identifier5); 
            	            lbs.add(bs) ; 
            	         }

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            match(input,COLON,FOLLOW_COLON_in_behavior_state_list1689); if (state.failed) return lbs;

            // AadlBa.g:624:4: ( (keyword_init= INITIAL )? (keyword_complete= COMPLETE )? (keyword_final= FINAL )? keyword= STATE SEMICOLON )
            // AadlBa.g:625:6: (keyword_init= INITIAL )? (keyword_complete= COMPLETE )? (keyword_final= FINAL )? keyword= STATE SEMICOLON
            {
            // AadlBa.g:625:6: (keyword_init= INITIAL )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==INITIAL) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // AadlBa.g:625:7: keyword_init= INITIAL
                    {
                    keyword_init=(Token)match(input,INITIAL,FOLLOW_INITIAL_in_behavior_state_list1705); if (state.failed) return lbs;

                    if ( state.backtracking==0 ) {
                                     for (BehaviorState bs : lbs)
                                     {
                                       bs.setInitial(true)  ;
                                     } 
                                   }

                    }
                    break;

            }


            // AadlBa.g:631:6: (keyword_complete= COMPLETE )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==COMPLETE) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // AadlBa.g:631:7: keyword_complete= COMPLETE
                    {
                    keyword_complete=(Token)match(input,COMPLETE,FOLLOW_COMPLETE_in_behavior_state_list1722); if (state.failed) return lbs;

                    if ( state.backtracking==0 ) { 
                                     for (BehaviorState bs : lbs)
                                     {
                                       bs.setComplete(true)  ;
                                     } 
                                   }

                    }
                    break;

            }


            // AadlBa.g:637:6: (keyword_final= FINAL )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==FINAL) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // AadlBa.g:637:7: keyword_final= FINAL
                    {
                    keyword_final=(Token)match(input,FINAL,FOLLOW_FINAL_in_behavior_state_list1738); if (state.failed) return lbs;

                    if ( state.backtracking==0 ) { 
                                     for (BehaviorState bs : lbs)
                                     {
                                       bs.setFinal(true)  ;
                                     } 
                                   }

                    }
                    break;

            }


            keyword=(Token)match(input,STATE,FOLLOW_STATE_in_behavior_state_list1755); if (state.failed) return lbs;

            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_behavior_state_list1757); if (state.failed) return lbs;

            }


            if ( state.backtracking==0 ) {
                 if(keyword_init!=null)
                 highlight(keyword_init, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
                 if(keyword_complete!=null)
                 highlight(keyword_complete, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
               if(keyword_final!=null)
                 highlight(keyword_final, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
               highlight(keyword, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
               }

            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return lbs;
    }
    // $ANTLR end "behavior_state_list"



    // $ANTLR start "behavior_transition"
    // AadlBa.g:668:1: behavior_transition returns [DeclarativeBehaviorTransition BehTrans] : (identifier= IDENT ( LBRACK Num= numeral RBRACK )? COLON )? identifier= IDENT ( COMMA identifier= IDENT )* (identifier= LTRANS BehCond= behavior_condition RTRANS ) identifier= IDENT (BehActionBlock= behavior_action_block )? SEMICOLON ;
    public final DeclarativeBehaviorTransition behavior_transition() throws RecognitionException {
        DeclarativeBehaviorTransition BehTrans = null;


        Token identifier=null;
        Integer Num =null;

        BehaviorCondition BehCond =null;

        BehaviorActionBlock BehActionBlock =null;



           BehTrans = _decl.createDeclarativeBehaviorTransition();
         
        try {
            // AadlBa.g:673:3: ( (identifier= IDENT ( LBRACK Num= numeral RBRACK )? COLON )? identifier= IDENT ( COMMA identifier= IDENT )* (identifier= LTRANS BehCond= behavior_condition RTRANS ) identifier= IDENT (BehActionBlock= behavior_action_block )? SEMICOLON )
            // AadlBa.g:674:4: (identifier= IDENT ( LBRACK Num= numeral RBRACK )? COLON )? identifier= IDENT ( COMMA identifier= IDENT )* (identifier= LTRANS BehCond= behavior_condition RTRANS ) identifier= IDENT (BehActionBlock= behavior_action_block )? SEMICOLON
            {
            // AadlBa.g:674:4: (identifier= IDENT ( LBRACK Num= numeral RBRACK )? COLON )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==IDENT) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==COLON||LA16_1==LBRACK) ) {
                    alt16=1;
                }
            }
            switch (alt16) {
                case 1 :
                    // AadlBa.g:674:6: identifier= IDENT ( LBRACK Num= numeral RBRACK )? COLON
                    {
                    identifier=(Token)match(input,IDENT,FOLLOW_IDENT_in_behavior_transition1809); if (state.failed) return BehTrans;

                    if ( state.backtracking==0 ) {
                           BehTrans.setName(identifier.getText()) ;
                           setLocationReference(BehTrans, identifier); 
                         }

                    // AadlBa.g:679:6: ( LBRACK Num= numeral RBRACK )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==LBRACK) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // AadlBa.g:679:8: LBRACK Num= numeral RBRACK
                            {
                            match(input,LBRACK,FOLLOW_LBRACK_in_behavior_transition1827); if (state.failed) return BehTrans;

                            pushFollow(FOLLOW_numeral_in_behavior_transition1831);
                            Num=numeral();

                            state._fsp--;
                            if (state.failed) return BehTrans;

                            match(input,RBRACK,FOLLOW_RBRACK_in_behavior_transition1833); if (state.failed) return BehTrans;

                            if ( state.backtracking==0 ) { BehTrans.setPriority(Num);}

                            }
                            break;

                    }


                    match(input,COLON,FOLLOW_COLON_in_behavior_transition1846); if (state.failed) return BehTrans;

                    }
                    break;

            }


            identifier=(Token)match(input,IDENT,FOLLOW_IDENT_in_behavior_transition1865); if (state.failed) return BehTrans;

            if ( state.backtracking==0 ) { 
                 Identifier Id = _decl.createIdentifier();
                 Id.setId(identifier.getText());
                 setLocationReference(Id, identifier); 
                 BehTrans.getSrcStates().add(Id);
                
                 if(BehTrans.getLocationReference() == null)
                 {
                   BehTrans.setLocationReference(Id.getLocationReference()) ;
                 } 
               }

            // AadlBa.g:696:4: ( COMMA identifier= IDENT )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==COMMA) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // AadlBa.g:696:6: COMMA identifier= IDENT
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_behavior_transition1882); if (state.failed) return BehTrans;

            	    identifier=(Token)match(input,IDENT,FOLLOW_IDENT_in_behavior_transition1886); if (state.failed) return BehTrans;

            	    if ( state.backtracking==0 ) { 
            	          Identifier Id = _decl.createIdentifier();
            	          Id.setId(identifier.getText());
            	          setLocationReference(Id, identifier); 
            	          BehTrans.getSrcStates().add(Id);
            	         }

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            // AadlBa.g:705:4: (identifier= LTRANS BehCond= behavior_condition RTRANS )
            // AadlBa.g:705:6: identifier= LTRANS BehCond= behavior_condition RTRANS
            {
            identifier=(Token)match(input,LTRANS,FOLLOW_LTRANS_in_behavior_transition1914); if (state.failed) return BehTrans;

            pushFollow(FOLLOW_behavior_condition_in_behavior_transition1918);
            BehCond=behavior_condition();

            state._fsp--;
            if (state.failed) return BehTrans;

            if ( state.backtracking==0 ) { 
                   // behavior condition can be null.
                   if (BehCond != null)
                   {
                     _ba.getConditions().add(BehCond);
                     BehTrans.setCondition(BehCond);
                   }
                 }

            match(input,RTRANS,FOLLOW_RTRANS_in_behavior_transition1933); if (state.failed) return BehTrans;

            }


            identifier=(Token)match(input,IDENT,FOLLOW_IDENT_in_behavior_transition1950); if (state.failed) return BehTrans;

            if ( state.backtracking==0 ) {
                 Identifier Id = _decl.createIdentifier();
                 Id.setId(identifier.getText());
                 setLocationReference(Id, identifier); 
                 BehTrans.setDestState(Id);
               }

            // AadlBa.g:725:4: (BehActionBlock= behavior_action_block )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==LCURLY) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // AadlBa.g:725:6: BehActionBlock= behavior_action_block
                    {
                    pushFollow(FOLLOW_behavior_action_block_in_behavior_transition1970);
                    BehActionBlock=behavior_action_block();

                    state._fsp--;
                    if (state.failed) return BehTrans;

                    if ( state.backtracking==0 ) { 
                              _ba.getActions().add(BehActionBlock);
                              BehTrans.setActionBlock(BehActionBlock);
                            }

                    }
                    break;

            }


            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_behavior_transition2001); if (state.failed) return BehTrans;

            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return BehTrans;
    }
    // $ANTLR end "behavior_transition"



    // $ANTLR start "behavior_action_block"
    // AadlBa.g:742:1: behavior_action_block returns [BehaviorActionBlock BehActionBlock] : identifier= LCURLY BehActions= behavior_actions RCURLY (keyword_timeout= TIMEOUT BehTime= behavior_time )? ;
    public final BehaviorActionBlock behavior_action_block() throws RecognitionException {
        BehaviorActionBlock BehActionBlock = null;


        Token identifier=null;
        Token keyword_timeout=null;
        BehaviorActions BehActions =null;

        DeclarativeTime BehTime =null;



                 BehActionBlock = _fact.createBehaviorActionBlock() ;
         
        try {
            // AadlBa.g:746:3: (identifier= LCURLY BehActions= behavior_actions RCURLY (keyword_timeout= TIMEOUT BehTime= behavior_time )? )
            // AadlBa.g:746:5: identifier= LCURLY BehActions= behavior_actions RCURLY (keyword_timeout= TIMEOUT BehTime= behavior_time )?
            {
            identifier=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_behavior_action_block2031); if (state.failed) return BehActionBlock;

            pushFollow(FOLLOW_behavior_actions_in_behavior_action_block2035);
            BehActions=behavior_actions();

            state._fsp--;
            if (state.failed) return BehActionBlock;

            match(input,RCURLY,FOLLOW_RCURLY_in_behavior_action_block2037); if (state.failed) return BehActionBlock;

            if ( state.backtracking==0 ) {
                   BehActionBlock.setContent(BehActions) ;
                   setLocationReference(BehActionBlock, identifier);
                }

            // AadlBa.g:752:5: (keyword_timeout= TIMEOUT BehTime= behavior_time )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==TIMEOUT) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // AadlBa.g:752:7: keyword_timeout= TIMEOUT BehTime= behavior_time
                    {
                    keyword_timeout=(Token)match(input,TIMEOUT,FOLLOW_TIMEOUT_in_behavior_action_block2061); if (state.failed) return BehActionBlock;

                    pushFollow(FOLLOW_behavior_time_in_behavior_action_block2065);
                    BehTime=behavior_time();

                    state._fsp--;
                    if (state.failed) return BehActionBlock;

                    if ( state.backtracking==0 ) {
                            BehActionBlock.setTimeout(BehTime) ;
                            highlight(keyword_timeout, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
                          }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return BehActionBlock;
    }
    // $ANTLR end "behavior_action_block"



    // $ANTLR start "behavior_condition"
    // AadlBa.g:768:1: behavior_condition returns [BehaviorCondition BehCond] : (pos= ON DisCond= dispatch_condition | (ExecCond= execute_condition )? ) ;
    public final BehaviorCondition behavior_condition() throws RecognitionException {
        BehaviorCondition BehCond = null;


        Token pos=null;
        DispatchCondition DisCond =null;

        ExecuteCondition ExecCond =null;



         
        try {
            // AadlBa.g:771:3: ( (pos= ON DisCond= dispatch_condition | (ExecCond= execute_condition )? ) )
            // AadlBa.g:772:4: (pos= ON DisCond= dispatch_condition | (ExecCond= execute_condition )? )
            {
            // AadlBa.g:772:4: (pos= ON DisCond= dispatch_condition | (ExecCond= execute_condition )? )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==ON) ) {
                alt21=1;
            }
            else if ( (LA21_0==ABS||LA21_0==FALSE||LA21_0==IDENT||LA21_0==INTEGER_LIT||LA21_0==LPAREN||LA21_0==MINUS||LA21_0==NOT||(LA21_0 >= OTHERWISE && LA21_0 <= PLUS)||LA21_0==REAL_LIT||LA21_0==RTRANS||LA21_0==STRING_LITERAL||LA21_0==TIMEOUT||LA21_0==TRUE) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return BehCond;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }
            switch (alt21) {
                case 1 :
                    // AadlBa.g:773:8: pos= ON DisCond= dispatch_condition
                    {
                    pos=(Token)match(input,ON,FOLLOW_ON_in_behavior_condition2123); if (state.failed) return BehCond;

                    pushFollow(FOLLOW_dispatch_condition_in_behavior_condition2127);
                    DisCond=dispatch_condition();

                    state._fsp--;
                    if (state.failed) return BehCond;

                    if ( state.backtracking==0 ) {
                             setLocationReference(DisCond, pos);
                             highlight(pos, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
                           }

                    }
                    break;
                case 2 :
                    // AadlBa.g:779:8: (ExecCond= execute_condition )?
                    {
                    // AadlBa.g:779:8: (ExecCond= execute_condition )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==ABS||LA20_0==FALSE||LA20_0==IDENT||LA20_0==INTEGER_LIT||LA20_0==LPAREN||LA20_0==MINUS||LA20_0==NOT||(LA20_0 >= OTHERWISE && LA20_0 <= PLUS)||LA20_0==REAL_LIT||LA20_0==STRING_LITERAL||LA20_0==TIMEOUT||LA20_0==TRUE) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // AadlBa.g:779:9: ExecCond= execute_condition
                            {
                            pushFollow(FOLLOW_execute_condition_in_behavior_condition2155);
                            ExecCond=execute_condition();

                            state._fsp--;
                            if (state.failed) return BehCond;

                            }
                            break;

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                 if (DisCond != null)
                 {
                   BehCond = DisCond;
                 } 
                 else
                 {
                   BehCond = ExecCond;
                 }
               }

            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return BehCond;
    }
    // $ANTLR end "behavior_condition"



    // $ANTLR start "execute_condition"
    // AadlBa.g:808:1: execute_condition returns [ExecuteCondition ExecCond] : (identifier= TIMEOUT |identifier= OTHERWISE |ValExpr= value_expression ) ;
    public final ExecuteCondition execute_condition() throws RecognitionException {
        ExecuteCondition ExecCond = null;


        Token identifier=null;
        ValueExpression ValExpr =null;



            ExecCond= null ;
         
        try {
            // AadlBa.g:813:3: ( (identifier= TIMEOUT |identifier= OTHERWISE |ValExpr= value_expression ) )
            // AadlBa.g:814:4: (identifier= TIMEOUT |identifier= OTHERWISE |ValExpr= value_expression )
            {
            // AadlBa.g:814:4: (identifier= TIMEOUT |identifier= OTHERWISE |ValExpr= value_expression )
            int alt22=3;
            switch ( input.LA(1) ) {
            case TIMEOUT:
                {
                alt22=1;
                }
                break;
            case OTHERWISE:
                {
                alt22=2;
                }
                break;
            case ABS:
            case FALSE:
            case IDENT:
            case INTEGER_LIT:
            case LPAREN:
            case MINUS:
            case NOT:
            case PLUS:
            case REAL_LIT:
            case STRING_LITERAL:
            case TRUE:
                {
                alt22=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ExecCond;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }

            switch (alt22) {
                case 1 :
                    // AadlBa.g:815:8: identifier= TIMEOUT
                    {
                    identifier=(Token)match(input,TIMEOUT,FOLLOW_TIMEOUT_in_execute_condition2215); if (state.failed) return ExecCond;

                    if ( state.backtracking==0 ) {
                             ExecCond = _fact.createExecutionTimeoutCatch();
                             setLocationReference(ExecCond, identifier);
                             highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
                           }

                    }
                    break;
                case 2 :
                    // AadlBa.g:822:8: identifier= OTHERWISE
                    {
                    identifier=(Token)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_execute_condition2242); if (state.failed) return ExecCond;

                    if ( state.backtracking==0 ) {
                             ExecCond = _fact.createOtherwise() ;
                             setLocationReference(ExecCond, identifier);
                             highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
                           }

                    }
                    break;
                case 3 :
                    // AadlBa.g:829:8: ValExpr= value_expression
                    {
                    pushFollow(FOLLOW_value_expression_in_execute_condition2276);
                    ValExpr=value_expression();

                    state._fsp--;
                    if (state.failed) return ExecCond;

                    if ( state.backtracking==0 ) { 
                             ExecCond = ValExpr ;
                           }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return ExecCond;
    }
    // $ANTLR end "execute_condition"



    // $ANTLR start "integer_value_constant"
    // AadlBa.g:841:1: integer_value_constant returns [IntegerValueConstant ivc] : (il= integer_literal |prop= property );
    public final IntegerValueConstant integer_value_constant() throws RecognitionException {
        IntegerValueConstant ivc = null;


        BehaviorIntegerLiteral il =null;

        QualifiedNamedElement prop =null;


        try {
            // AadlBa.g:843:2: (il= integer_literal |prop= property )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==INTEGER_LIT) ) {
                alt23=1;
            }
            else if ( (LA23_0==IDENT) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ivc;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }
            switch (alt23) {
                case 1 :
                    // AadlBa.g:844:6: il= integer_literal
                    {
                    pushFollow(FOLLOW_integer_literal_in_integer_value_constant2320);
                    il=integer_literal();

                    state._fsp--;
                    if (state.failed) return ivc;

                    if ( state.backtracking==0 ) {ivc = il ;}

                    }
                    break;
                case 2 :
                    // AadlBa.g:847:6: prop= property
                    {
                    pushFollow(FOLLOW_property_in_integer_value_constant2342);
                    prop=property();

                    state._fsp--;
                    if (state.failed) return ivc;

                    if ( state.backtracking==0 ) {ivc = prop;}

                    }
                    break;

            }
        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return ivc;
    }
    // $ANTLR end "integer_value_constant"



    // $ANTLR start "dispatch_condition"
    // AadlBa.g:873:1: dispatch_condition returns [DispatchCondition DisCond] : keyword= DISPATCH (DisTriggCond= dispatch_trigger_condition )? (keyword= FROZEN port= reference ( COMMA port= reference )* )? ;
    public final DispatchCondition dispatch_condition() throws RecognitionException {
        DispatchCondition DisCond = null;


        Token keyword=null;
        DispatchTriggerCondition DisTriggCond =null;

        Reference port =null;



           // Location reference is set in behavior_transition
           DisCond = _fact.createDispatchCondition ();
         
        try {
            // AadlBa.g:878:3: (keyword= DISPATCH (DisTriggCond= dispatch_trigger_condition )? (keyword= FROZEN port= reference ( COMMA port= reference )* )? )
            // AadlBa.g:879:4: keyword= DISPATCH (DisTriggCond= dispatch_trigger_condition )? (keyword= FROZEN port= reference ( COMMA port= reference )* )?
            {
            keyword=(Token)match(input,DISPATCH,FOLLOW_DISPATCH_in_dispatch_condition2395); if (state.failed) return DisCond;

            // AadlBa.g:880:4: (DisTriggCond= dispatch_trigger_condition )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==IDENT||LA24_0==STOP||LA24_0==TIMEOUT) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // AadlBa.g:880:6: DisTriggCond= dispatch_trigger_condition
                    {
                    pushFollow(FOLLOW_dispatch_trigger_condition_in_dispatch_condition2405);
                    DisTriggCond=dispatch_trigger_condition();

                    state._fsp--;
                    if (state.failed) return DisCond;

                    if ( state.backtracking==0 ) {
                           DisCond.setDispatchTriggerCondition (DisTriggCond);
                           highlight(keyword, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
                         }

                    }
                    break;

            }


            // AadlBa.g:887:4: (keyword= FROZEN port= reference ( COMMA port= reference )* )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==FROZEN) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // AadlBa.g:887:6: keyword= FROZEN port= reference ( COMMA port= reference )*
                    {
                    keyword=(Token)match(input,FROZEN,FOLLOW_FROZEN_in_dispatch_condition2431); if (state.failed) return DisCond;

                    pushFollow(FOLLOW_reference_in_dispatch_condition2435);
                    port=reference();

                    state._fsp--;
                    if (state.failed) return DisCond;

                    if ( state.backtracking==0 ) {
                           DisCond.getFrozenPorts().add(port);
                           highlight(keyword, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
                         }

                    // AadlBa.g:892:6: ( COMMA port= reference )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==COMMA) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // AadlBa.g:892:8: COMMA port= reference
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_dispatch_condition2451); if (state.failed) return DisCond;

                    	    pushFollow(FOLLOW_reference_in_dispatch_condition2455);
                    	    port=reference();

                    	    state._fsp--;
                    	    if (state.failed) return DisCond;

                    	    if ( state.backtracking==0 ) {
                    	             DisCond.getFrozenPorts().add(port);
                    	           }

                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);


                    }
                    break;

            }


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return DisCond;
    }
    // $ANTLR end "dispatch_condition"



    // $ANTLR start "dispatch_trigger_condition"
    // AadlBa.g:917:1: dispatch_trigger_condition returns [DispatchTriggerCondition DisTriggCond] : (identifier= STOP | (identifier= TIMEOUT (BehTime= behavior_time )? ) |DisTriggLogicalExpr= dispatch_trigger_logical_expression );
    public final DispatchTriggerCondition dispatch_trigger_condition() throws RecognitionException {
        DispatchTriggerCondition DisTriggCond = null;


        Token identifier=null;
        DeclarativeTime BehTime =null;

        DispatchTriggerLogicalExpression DisTriggLogicalExpr =null;



           DisTriggCond = null ;
         
        try {
            // AadlBa.g:921:4: (identifier= STOP | (identifier= TIMEOUT (BehTime= behavior_time )? ) |DisTriggLogicalExpr= dispatch_trigger_logical_expression )
            int alt28=3;
            switch ( input.LA(1) ) {
            case STOP:
                {
                alt28=1;
                }
                break;
            case TIMEOUT:
                {
                alt28=2;
                }
                break;
            case IDENT:
                {
                alt28=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return DisTriggCond;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;

            }

            switch (alt28) {
                case 1 :
                    // AadlBa.g:927:8: identifier= STOP
                    {
                    identifier=(Token)match(input,STOP,FOLLOW_STOP_in_dispatch_trigger_condition2557); if (state.failed) return DisTriggCond;

                    if ( state.backtracking==0 ) { DisTriggCond = _fact.createDispatchTriggerConditionStop() ;
                             setLocationReference(DisTriggCond, identifier) ;
                             highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
                           }

                    }
                    break;
                case 2 :
                    // AadlBa.g:933:8: (identifier= TIMEOUT (BehTime= behavior_time )? )
                    {
                    // AadlBa.g:933:8: (identifier= TIMEOUT (BehTime= behavior_time )? )
                    // AadlBa.g:933:10: identifier= TIMEOUT (BehTime= behavior_time )?
                    {
                    identifier=(Token)match(input,TIMEOUT,FOLLOW_TIMEOUT_in_dispatch_trigger_condition2586); if (state.failed) return DisTriggCond;

                    if ( state.backtracking==0 ) { DisTriggCond = _fact.createDispatchRelativeTimeout() ;
                               setLocationReference(DisTriggCond, identifier) ;
                               highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
                             }

                    // AadlBa.g:938:10: (BehTime= behavior_time )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==FALSE||LA27_0==IDENT||LA27_0==INTEGER_LIT||LA27_0==REAL_LIT||LA27_0==STRING_LITERAL||LA27_0==TRUE) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // AadlBa.g:939:12: BehTime= behavior_time
                            {
                            pushFollow(FOLLOW_behavior_time_in_dispatch_trigger_condition2628);
                            BehTime=behavior_time();

                            state._fsp--;
                            if (state.failed) return DisTriggCond;

                            if ( state.backtracking==0 ) { 
                                         DisTriggCond = BehTime ;
                                       }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // AadlBa.g:946:8: DisTriggLogicalExpr= dispatch_trigger_logical_expression
                    {
                    pushFollow(FOLLOW_dispatch_trigger_logical_expression_in_dispatch_trigger_condition2681);
                    DisTriggLogicalExpr=dispatch_trigger_logical_expression();

                    state._fsp--;
                    if (state.failed) return DisTriggCond;

                    if ( state.backtracking==0 ) {
                             DisTriggCond = DisTriggLogicalExpr ;
                           }

                    }
                    break;

            }
        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return DisTriggCond;
    }
    // $ANTLR end "dispatch_trigger_condition"



    // $ANTLR start "dispatch_trigger_logical_expression"
    // AadlBa.g:959:1: dispatch_trigger_logical_expression returns [DispatchTriggerLogicalExpression\n DisTriggLogicalExpr] : DisConjunct= dispatch_conjunction (identifier= OR DisConjunct= dispatch_conjunction )* ;
    public final DispatchTriggerLogicalExpression dispatch_trigger_logical_expression() throws RecognitionException {
        DispatchTriggerLogicalExpression DisTriggLogicalExpr = null;


        Token identifier=null;
        DispatchConjunction DisConjunct =null;



           DisTriggLogicalExpr = _fact.createDispatchTriggerLogicalExpression ();
         
        try {
            // AadlBa.g:964:4: (DisConjunct= dispatch_conjunction (identifier= OR DisConjunct= dispatch_conjunction )* )
            // AadlBa.g:965:6: DisConjunct= dispatch_conjunction (identifier= OR DisConjunct= dispatch_conjunction )*
            {
            pushFollow(FOLLOW_dispatch_conjunction_in_dispatch_trigger_logical_expression2727);
            DisConjunct=dispatch_conjunction();

            state._fsp--;
            if (state.failed) return DisTriggLogicalExpr;

            if ( state.backtracking==0 ) {
                   DisTriggLogicalExpr.getDispatchConjunctions().add(DisConjunct) ;
                   DisTriggLogicalExpr.setLocationReference(
                     DisConjunct.getLocationReference());
                 }

            // AadlBa.g:971:6: (identifier= OR DisConjunct= dispatch_conjunction )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==OR) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // AadlBa.g:972:8: identifier= OR DisConjunct= dispatch_conjunction
            	    {
            	    identifier=(Token)match(input,OR,FOLLOW_OR_in_dispatch_trigger_logical_expression2752); if (state.failed) return DisTriggLogicalExpr;

            	    pushFollow(FOLLOW_dispatch_conjunction_in_dispatch_trigger_logical_expression2756);
            	    DisConjunct=dispatch_conjunction();

            	    state._fsp--;
            	    if (state.failed) return DisTriggLogicalExpr;

            	    if ( state.backtracking==0 ) {
            	             DisTriggLogicalExpr.getDispatchConjunctions().add(DisConjunct) ;
            	             highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
            	           }

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return DisTriggLogicalExpr;
    }
    // $ANTLR end "dispatch_trigger_logical_expression"



    // $ANTLR start "dispatch_conjunction"
    // AadlBa.g:991:1: dispatch_conjunction returns [DispatchConjunction DisConjunct] : ref= reference (keyword= AND ref= reference )* ;
    public final DispatchConjunction dispatch_conjunction() throws RecognitionException {
        DispatchConjunction DisConjunct = null;


        Token keyword=null;
        Reference ref =null;



           DisConjunct = _fact.createDispatchConjunction ();
         
        try {
            // AadlBa.g:996:4: (ref= reference (keyword= AND ref= reference )* )
            // AadlBa.g:997:6: ref= reference (keyword= AND ref= reference )*
            {
            pushFollow(FOLLOW_reference_in_dispatch_conjunction2815);
            ref=reference();

            state._fsp--;
            if (state.failed) return DisConjunct;

            if ( state.backtracking==0 ) {
                   DisConjunct.getDispatchTriggers().add(ref) ;
                   DisConjunct.setLocationReference(ref.getLocationReference());
                 }

            // AadlBa.g:1002:6: (keyword= AND ref= reference )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==AND) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // AadlBa.g:1003:8: keyword= AND ref= reference
            	    {
            	    keyword=(Token)match(input,AND,FOLLOW_AND_in_dispatch_conjunction2840); if (state.failed) return DisConjunct;

            	    pushFollow(FOLLOW_reference_in_dispatch_conjunction2844);
            	    ref=reference();

            	    state._fsp--;
            	    if (state.failed) return DisConjunct;

            	    if ( state.backtracking==0 ) {
            	             DisConjunct.getDispatchTriggers().add(ref) ;
            	             highlight(keyword, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
            	           }

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return DisConjunct;
    }
    // $ANTLR end "dispatch_conjunction"



    // $ANTLR start "behavior_actions"
    // AadlBa.g:1036:1: behavior_actions returns [BehaviorActions BehActs] : BehAction= behavior_action ( (id= SEMICOLON BehAction2= behavior_action )* | (id= CONCAT BehAction2= behavior_action )* ) ;
    public final BehaviorActions behavior_actions() throws RecognitionException {
        BehaviorActions BehActs = null;


        Token id=null;
        BehaviorAction BehAction =null;

        BehaviorAction BehAction2 =null;



           BehActs = null ;
           EList<BehaviorAction> tmpList = new BasicEList<BehaviorAction>() ;
           BehaviorActionCollection col = null ;
         
        try {
            // AadlBa.g:1042:3: (BehAction= behavior_action ( (id= SEMICOLON BehAction2= behavior_action )* | (id= CONCAT BehAction2= behavior_action )* ) )
            // AadlBa.g:1043:4: BehAction= behavior_action ( (id= SEMICOLON BehAction2= behavior_action )* | (id= CONCAT BehAction2= behavior_action )* )
            {
            pushFollow(FOLLOW_behavior_action_in_behavior_actions2912);
            BehAction=behavior_action();

            state._fsp--;
            if (state.failed) return BehActs;

            if ( state.backtracking==0 ) {
                 BehActs = BehAction ;
               }

            // AadlBa.g:1048:4: ( (id= SEMICOLON BehAction2= behavior_action )* | (id= CONCAT BehAction2= behavior_action )* )
            int alt33=2;
            switch ( input.LA(1) ) {
            case SEMICOLON:
                {
                alt33=1;
                }
                break;
            case RCURLY:
                {
                int LA33_2 = input.LA(2);

                if ( (synpred34_AadlBa()) ) {
                    alt33=1;
                }
                else if ( (true) ) {
                    alt33=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return BehActs;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 2, input);

                    throw nvae;

                }
                }
                break;
            case ELSIF:
                {
                int LA33_3 = input.LA(2);

                if ( (synpred34_AadlBa()) ) {
                    alt33=1;
                }
                else if ( (true) ) {
                    alt33=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return BehActs;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 3, input);

                    throw nvae;

                }
                }
                break;
            case ELSE:
                {
                int LA33_4 = input.LA(2);

                if ( (synpred34_AadlBa()) ) {
                    alt33=1;
                }
                else if ( (true) ) {
                    alt33=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return BehActs;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 4, input);

                    throw nvae;

                }
                }
                break;
            case END:
                {
                int LA33_5 = input.LA(2);

                if ( (synpred34_AadlBa()) ) {
                    alt33=1;
                }
                else if ( (true) ) {
                    alt33=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return BehActs;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 5, input);

                    throw nvae;

                }
                }
                break;
            case UNTIL:
                {
                int LA33_6 = input.LA(2);

                if ( (synpred34_AadlBa()) ) {
                    alt33=1;
                }
                else if ( (true) ) {
                    alt33=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return BehActs;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 6, input);

                    throw nvae;

                }
                }
                break;
            case EOF:
                {
                int LA33_7 = input.LA(2);

                if ( (synpred34_AadlBa()) ) {
                    alt33=1;
                }
                else if ( (true) ) {
                    alt33=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return BehActs;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 7, input);

                    throw nvae;

                }
                }
                break;
            case CONCAT:
                {
                alt33=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return BehActs;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;

            }

            switch (alt33) {
                case 1 :
                    // AadlBa.g:1049:9: (id= SEMICOLON BehAction2= behavior_action )*
                    {
                    // AadlBa.g:1049:9: (id= SEMICOLON BehAction2= behavior_action )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==SEMICOLON) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // AadlBa.g:1049:11: id= SEMICOLON BehAction2= behavior_action
                    	    {
                    	    id=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_behavior_actions2940); if (state.failed) return BehActs;

                    	    pushFollow(FOLLOW_behavior_action_in_behavior_actions2944);
                    	    BehAction2=behavior_action();

                    	    state._fsp--;
                    	    if (state.failed) return BehActs;

                    	    if ( state.backtracking==0 ) {
                    	                  tmpList.add(BehAction2) ;
                    	                }

                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) { col = _fact.createBehaviorActionSequence() ; }

                    }
                    break;
                case 2 :
                    // AadlBa.g:1056:9: (id= CONCAT BehAction2= behavior_action )*
                    {
                    // AadlBa.g:1056:9: (id= CONCAT BehAction2= behavior_action )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==CONCAT) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // AadlBa.g:1056:11: id= CONCAT BehAction2= behavior_action
                    	    {
                    	    id=(Token)match(input,CONCAT,FOLLOW_CONCAT_in_behavior_actions3002); if (state.failed) return BehActs;

                    	    pushFollow(FOLLOW_behavior_action_in_behavior_actions3006);
                    	    BehAction2=behavior_action();

                    	    state._fsp--;
                    	    if (state.failed) return BehActs;

                    	    if ( state.backtracking==0 ) {
                    	                  tmpList.add(BehAction2) ;
                    	                }

                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) { col = _fact.createBehaviorActionSet() ; }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                  if (tmpList.size() != 0)
                  { 
                    col.getActions().add(BehAction);
                    col.getActions().addAll(tmpList);
                    col.setLocationReference(BehActs.getLocationReference());
                    BehActs = col ;
                  }
               }

            }

        }
        catch (NoViableAltException ex) {

               
               if(ex.grammarDecisionDescription.isEmpty())
               {
                  reportError("too many semicolon/ampersand given or missing behavior action", id) ;
               }
               else
               {
                 reportError(ex);
                 consumeUntil(input,SEMICOLON);
                 input.consume();
               }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return BehActs;
    }
    // $ANTLR end "behavior_actions"



    // $ANTLR start "behavior_action"
    // AadlBa.g:1108:1: behavior_action returns [BehaviorAction BehAction] : ( (BaAct= basic_action ) | (BehActionBlock= behavior_action_block ) | (identifier1= IF identifier2= LPAREN ValExpr= value_expression RPAREN BehActions= behavior_actions (identifier1= ELSIF identifier2= LPAREN ValExpr= value_expression RPAREN BehActions= behavior_actions )* (identifier= ELSE BehActions= behavior_actions )? keyword1= END keyword2= IF ) | (identifier_for= FOR LPAREN identifier_ident= IDENT COLON dt= unique_component_classifier_reference keyword= IN EltVal= element_values RPAREN identifier= LCURLY BehActions= behavior_actions RCURLY ) | (identifier= FORALL LPAREN identifier= IDENT COLON dt= unique_component_classifier_reference IN EltVal= element_values RPAREN identifier= LCURLY BehActions= behavior_actions RCURLY ) | (identifier1= WHILE identifier2= LPAREN ValExpr= value_expression RPAREN LCURLY BehActions= behavior_actions RCURLY ) | (identifier1= DO BehActions= behavior_actions UNTIL identifier2= LPAREN ValExpr= value_expression RPAREN ) ) ;
    public final BehaviorAction behavior_action() throws RecognitionException {
        BehaviorAction BehAction = null;


        Token identifier1=null;
        Token identifier2=null;
        Token identifier=null;
        Token keyword1=null;
        Token keyword2=null;
        Token identifier_for=null;
        Token identifier_ident=null;
        Token keyword=null;
        BasicAction BaAct =null;

        BehaviorActionBlock BehActionBlock =null;

        ValueExpression ValExpr =null;

        BehaviorActions BehActions =null;

        QualifiedNamedElement dt =null;

        ElementValues EltVal =null;



           BehAction = null;
           IfStatement IfStat = null ;
           IfStatement tmpIfStat = null ;
           ForOrForAllStatement ForStat = null ;
           IterativeVariable itVar = null ;
         
        try {
            // AadlBa.g:1116:3: ( ( (BaAct= basic_action ) | (BehActionBlock= behavior_action_block ) | (identifier1= IF identifier2= LPAREN ValExpr= value_expression RPAREN BehActions= behavior_actions (identifier1= ELSIF identifier2= LPAREN ValExpr= value_expression RPAREN BehActions= behavior_actions )* (identifier= ELSE BehActions= behavior_actions )? keyword1= END keyword2= IF ) | (identifier_for= FOR LPAREN identifier_ident= IDENT COLON dt= unique_component_classifier_reference keyword= IN EltVal= element_values RPAREN identifier= LCURLY BehActions= behavior_actions RCURLY ) | (identifier= FORALL LPAREN identifier= IDENT COLON dt= unique_component_classifier_reference IN EltVal= element_values RPAREN identifier= LCURLY BehActions= behavior_actions RCURLY ) | (identifier1= WHILE identifier2= LPAREN ValExpr= value_expression RPAREN LCURLY BehActions= behavior_actions RCURLY ) | (identifier1= DO BehActions= behavior_actions UNTIL identifier2= LPAREN ValExpr= value_expression RPAREN ) ) )
            // AadlBa.g:1117:4: ( (BaAct= basic_action ) | (BehActionBlock= behavior_action_block ) | (identifier1= IF identifier2= LPAREN ValExpr= value_expression RPAREN BehActions= behavior_actions (identifier1= ELSIF identifier2= LPAREN ValExpr= value_expression RPAREN BehActions= behavior_actions )* (identifier= ELSE BehActions= behavior_actions )? keyword1= END keyword2= IF ) | (identifier_for= FOR LPAREN identifier_ident= IDENT COLON dt= unique_component_classifier_reference keyword= IN EltVal= element_values RPAREN identifier= LCURLY BehActions= behavior_actions RCURLY ) | (identifier= FORALL LPAREN identifier= IDENT COLON dt= unique_component_classifier_reference IN EltVal= element_values RPAREN identifier= LCURLY BehActions= behavior_actions RCURLY ) | (identifier1= WHILE identifier2= LPAREN ValExpr= value_expression RPAREN LCURLY BehActions= behavior_actions RCURLY ) | (identifier1= DO BehActions= behavior_actions UNTIL identifier2= LPAREN ValExpr= value_expression RPAREN ) )
            {
            // AadlBa.g:1117:4: ( (BaAct= basic_action ) | (BehActionBlock= behavior_action_block ) | (identifier1= IF identifier2= LPAREN ValExpr= value_expression RPAREN BehActions= behavior_actions (identifier1= ELSIF identifier2= LPAREN ValExpr= value_expression RPAREN BehActions= behavior_actions )* (identifier= ELSE BehActions= behavior_actions )? keyword1= END keyword2= IF ) | (identifier_for= FOR LPAREN identifier_ident= IDENT COLON dt= unique_component_classifier_reference keyword= IN EltVal= element_values RPAREN identifier= LCURLY BehActions= behavior_actions RCURLY ) | (identifier= FORALL LPAREN identifier= IDENT COLON dt= unique_component_classifier_reference IN EltVal= element_values RPAREN identifier= LCURLY BehActions= behavior_actions RCURLY ) | (identifier1= WHILE identifier2= LPAREN ValExpr= value_expression RPAREN LCURLY BehActions= behavior_actions RCURLY ) | (identifier1= DO BehActions= behavior_actions UNTIL identifier2= LPAREN ValExpr= value_expression RPAREN ) )
            int alt36=7;
            switch ( input.LA(1) ) {
            case COMPUTATION:
            case IDENT:
            case STAR:
                {
                alt36=1;
                }
                break;
            case LCURLY:
                {
                alt36=2;
                }
                break;
            case IF:
                {
                alt36=3;
                }
                break;
            case FOR:
                {
                alt36=4;
                }
                break;
            case FORALL:
                {
                alt36=5;
                }
                break;
            case WHILE:
                {
                alt36=6;
                }
                break;
            case DO:
                {
                alt36=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return BehAction;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }

            switch (alt36) {
                case 1 :
                    // AadlBa.g:1118:6: (BaAct= basic_action )
                    {
                    // AadlBa.g:1118:6: (BaAct= basic_action )
                    // AadlBa.g:1118:8: BaAct= basic_action
                    {
                    pushFollow(FOLLOW_basic_action_in_behavior_action3116);
                    BaAct=basic_action();

                    state._fsp--;
                    if (state.failed) return BehAction;

                    if ( state.backtracking==0 ) { BehAction = BaAct ;}

                    }


                    }
                    break;
                case 2 :
                    // AadlBa.g:1122:6: (BehActionBlock= behavior_action_block )
                    {
                    // AadlBa.g:1122:6: (BehActionBlock= behavior_action_block )
                    // AadlBa.g:1122:8: BehActionBlock= behavior_action_block
                    {
                    pushFollow(FOLLOW_behavior_action_block_in_behavior_action3149);
                    BehActionBlock=behavior_action_block();

                    state._fsp--;
                    if (state.failed) return BehAction;

                    if ( state.backtracking==0 ) { 
                              BehAction = BehActionBlock ;
                           }

                    }


                    }
                    break;
                case 3 :
                    // AadlBa.g:1129:6: (identifier1= IF identifier2= LPAREN ValExpr= value_expression RPAREN BehActions= behavior_actions (identifier1= ELSIF identifier2= LPAREN ValExpr= value_expression RPAREN BehActions= behavior_actions )* (identifier= ELSE BehActions= behavior_actions )? keyword1= END keyword2= IF )
                    {
                    // AadlBa.g:1129:6: (identifier1= IF identifier2= LPAREN ValExpr= value_expression RPAREN BehActions= behavior_actions (identifier1= ELSIF identifier2= LPAREN ValExpr= value_expression RPAREN BehActions= behavior_actions )* (identifier= ELSE BehActions= behavior_actions )? keyword1= END keyword2= IF )
                    // AadlBa.g:1129:8: identifier1= IF identifier2= LPAREN ValExpr= value_expression RPAREN BehActions= behavior_actions (identifier1= ELSIF identifier2= LPAREN ValExpr= value_expression RPAREN BehActions= behavior_actions )* (identifier= ELSE BehActions= behavior_actions )? keyword1= END keyword2= IF
                    {
                    identifier1=(Token)match(input,IF,FOLLOW_IF_in_behavior_action3187); if (state.failed) return BehAction;

                    identifier2=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_behavior_action3191); if (state.failed) return BehAction;

                    pushFollow(FOLLOW_value_expression_in_behavior_action3195);
                    ValExpr=value_expression();

                    state._fsp--;
                    if (state.failed) return BehAction;

                    match(input,RPAREN,FOLLOW_RPAREN_in_behavior_action3197); if (state.failed) return BehAction;

                    pushFollow(FOLLOW_behavior_actions_in_behavior_action3201);
                    BehActions=behavior_actions();

                    state._fsp--;
                    if (state.failed) return BehAction;

                    if ( state.backtracking==0 ) { 
                             IfStat = _fact.createIfStatement();
                             setLocationReference(IfStat, identifier1); 
                             setLocationReference(ValExpr, identifier2); 
                             IfStat.setLogicalValueExpression(ValExpr) ;
                             IfStat.setBehaviorActions(BehActions);
                             tmpIfStat = IfStat ;
                             highlight(identifier1, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
                           }

                    // AadlBa.g:1139:8: (identifier1= ELSIF identifier2= LPAREN ValExpr= value_expression RPAREN BehActions= behavior_actions )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==ELSIF) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // AadlBa.g:1140:10: identifier1= ELSIF identifier2= LPAREN ValExpr= value_expression RPAREN BehActions= behavior_actions
                    	    {
                    	    identifier1=(Token)match(input,ELSIF,FOLLOW_ELSIF_in_behavior_action3234); if (state.failed) return BehAction;

                    	    identifier2=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_behavior_action3238); if (state.failed) return BehAction;

                    	    pushFollow(FOLLOW_value_expression_in_behavior_action3242);
                    	    ValExpr=value_expression();

                    	    state._fsp--;
                    	    if (state.failed) return BehAction;

                    	    match(input,RPAREN,FOLLOW_RPAREN_in_behavior_action3244); if (state.failed) return BehAction;

                    	    pushFollow(FOLLOW_behavior_actions_in_behavior_action3248);
                    	    BehActions=behavior_actions();

                    	    state._fsp--;
                    	    if (state.failed) return BehAction;

                    	    if ( state.backtracking==0 ) {
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

                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);


                    // AadlBa.g:1155:8: (identifier= ELSE BehActions= behavior_actions )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==ELSE) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // AadlBa.g:1156:10: identifier= ELSE BehActions= behavior_actions
                            {
                            identifier=(Token)match(input,ELSE,FOLLOW_ELSE_in_behavior_action3291); if (state.failed) return BehAction;

                            pushFollow(FOLLOW_behavior_actions_in_behavior_action3295);
                            BehActions=behavior_actions();

                            state._fsp--;
                            if (state.failed) return BehAction;

                            if ( state.backtracking==0 ) {
                                       ElseStatement elseStat = _fact.createElseStatement();
                                       setLocationReference(elseStat, identifier);
                                       elseStat.setBehaviorActions(BehActions);
                                       tmpIfStat.setElseStatement(elseStat);
                                       highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
                                     }

                            }
                            break;

                    }


                    keyword1=(Token)match(input,END,FOLLOW_END_in_behavior_action3327); if (state.failed) return BehAction;

                    keyword2=(Token)match(input,IF,FOLLOW_IF_in_behavior_action3331); if (state.failed) return BehAction;

                    if ( state.backtracking==0 ) {
                             highlight(keyword1, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
                             highlight(keyword2, AnnexHighlighterPositionAcceptor.KEYWORD_ID); 
                             BehAction = IfStat ;
                           }

                    }


                    }
                    break;
                case 4 :
                    // AadlBa.g:1174:6: (identifier_for= FOR LPAREN identifier_ident= IDENT COLON dt= unique_component_classifier_reference keyword= IN EltVal= element_values RPAREN identifier= LCURLY BehActions= behavior_actions RCURLY )
                    {
                    // AadlBa.g:1174:6: (identifier_for= FOR LPAREN identifier_ident= IDENT COLON dt= unique_component_classifier_reference keyword= IN EltVal= element_values RPAREN identifier= LCURLY BehActions= behavior_actions RCURLY )
                    // AadlBa.g:1174:8: identifier_for= FOR LPAREN identifier_ident= IDENT COLON dt= unique_component_classifier_reference keyword= IN EltVal= element_values RPAREN identifier= LCURLY BehActions= behavior_actions RCURLY
                    {
                    identifier_for=(Token)match(input,FOR,FOLLOW_FOR_in_behavior_action3369); if (state.failed) return BehAction;

                    match(input,LPAREN,FOLLOW_LPAREN_in_behavior_action3371); if (state.failed) return BehAction;

                    if ( state.backtracking==0 ) { ForStat = _fact.createForOrForAllStatement(); 
                                                   setLocationReference(ForStat, identifier_for);
                                                   highlight(identifier_for, AnnexHighlighterPositionAcceptor.KEYWORD_ID); 
                                                 }

                    identifier_ident=(Token)match(input,IDENT,FOLLOW_IDENT_in_behavior_action3385); if (state.failed) return BehAction;

                    if ( state.backtracking==0 ) {  
                                              itVar = _fact.createIterativeVariable(); 
                                              itVar.setName(identifier_ident.getText());
                                              setLocationReference(itVar, identifier_ident); 
                                              ForStat.setIterativeVariable(itVar); 
                                            }

                    match(input,COLON,FOLLOW_COLON_in_behavior_action3396); if (state.failed) return BehAction;

                    pushFollow(FOLLOW_unique_component_classifier_reference_in_behavior_action3400);
                    dt=unique_component_classifier_reference();

                    state._fsp--;
                    if (state.failed) return BehAction;

                    if ( state.backtracking==0 ) {
                             DeclarativeUtils.setEcontainer(_ba, dt);
                             itVar.setDataClassifier(dt);
                           }

                    keyword=(Token)match(input,IN,FOLLOW_IN_in_behavior_action3428); if (state.failed) return BehAction;

                    pushFollow(FOLLOW_element_values_in_behavior_action3432);
                    EltVal=element_values();

                    state._fsp--;
                    if (state.failed) return BehAction;

                    match(input,RPAREN,FOLLOW_RPAREN_in_behavior_action3434); if (state.failed) return BehAction;

                    if ( state.backtracking==0 ) { ForStat.setIteratedValues(EltVal); highlight(keyword, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}

                    identifier=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_behavior_action3447); if (state.failed) return BehAction;

                    pushFollow(FOLLOW_behavior_actions_in_behavior_action3451);
                    BehActions=behavior_actions();

                    state._fsp--;
                    if (state.failed) return BehAction;

                    match(input,RCURLY,FOLLOW_RCURLY_in_behavior_action3453); if (state.failed) return BehAction;

                    if ( state.backtracking==0 ) { ForStat.setBehaviorActions(BehActions);
                             BehAction = ForStat ;
                           }

                    }


                    }
                    break;
                case 5 :
                    // AadlBa.g:1198:6: (identifier= FORALL LPAREN identifier= IDENT COLON dt= unique_component_classifier_reference IN EltVal= element_values RPAREN identifier= LCURLY BehActions= behavior_actions RCURLY )
                    {
                    // AadlBa.g:1198:6: (identifier= FORALL LPAREN identifier= IDENT COLON dt= unique_component_classifier_reference IN EltVal= element_values RPAREN identifier= LCURLY BehActions= behavior_actions RCURLY )
                    // AadlBa.g:1198:8: identifier= FORALL LPAREN identifier= IDENT COLON dt= unique_component_classifier_reference IN EltVal= element_values RPAREN identifier= LCURLY BehActions= behavior_actions RCURLY
                    {
                    identifier=(Token)match(input,FORALL,FOLLOW_FORALL_in_behavior_action3492); if (state.failed) return BehAction;

                    match(input,LPAREN,FOLLOW_LPAREN_in_behavior_action3494); if (state.failed) return BehAction;

                    if ( state.backtracking==0 ) { 
                            ForStat = _fact.createForOrForAllStatement();
                            ForStat.setForAll(true);
                            setLocationReference(ForStat, identifier);
                            highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID); 
                           }

                    identifier=(Token)match(input,IDENT,FOLLOW_IDENT_in_behavior_action3515); if (state.failed) return BehAction;

                    if ( state.backtracking==0 ) {  
                                              itVar = _fact.createIterativeVariable(); 
                                              itVar.setName(identifier.getText());
                                              setLocationReference(itVar, identifier); 
                                              ForStat.setIterativeVariable(itVar);
                                            }

                    match(input,COLON,FOLLOW_COLON_in_behavior_action3526); if (state.failed) return BehAction;

                    pushFollow(FOLLOW_unique_component_classifier_reference_in_behavior_action3530);
                    dt=unique_component_classifier_reference();

                    state._fsp--;
                    if (state.failed) return BehAction;

                    if ( state.backtracking==0 ) {
                             DeclarativeUtils.setEcontainer(_ba, dt);
                             itVar.setDataClassifier(dt);
                           }

                    match(input,IN,FOLLOW_IN_in_behavior_action3557); if (state.failed) return BehAction;

                    pushFollow(FOLLOW_element_values_in_behavior_action3561);
                    EltVal=element_values();

                    state._fsp--;
                    if (state.failed) return BehAction;

                    match(input,RPAREN,FOLLOW_RPAREN_in_behavior_action3563); if (state.failed) return BehAction;

                    if ( state.backtracking==0 ) { ForStat.setIteratedValues(EltVal); }

                    identifier=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_behavior_action3576); if (state.failed) return BehAction;

                    pushFollow(FOLLOW_behavior_actions_in_behavior_action3580);
                    BehActions=behavior_actions();

                    state._fsp--;
                    if (state.failed) return BehAction;

                    match(input,RCURLY,FOLLOW_RCURLY_in_behavior_action3582); if (state.failed) return BehAction;

                    if ( state.backtracking==0 ) { ForStat.setBehaviorActions(BehActions) ;
                             BehAction = ForStat ;
                           }

                    }


                    }
                    break;
                case 6 :
                    // AadlBa.g:1225:6: (identifier1= WHILE identifier2= LPAREN ValExpr= value_expression RPAREN LCURLY BehActions= behavior_actions RCURLY )
                    {
                    // AadlBa.g:1225:6: (identifier1= WHILE identifier2= LPAREN ValExpr= value_expression RPAREN LCURLY BehActions= behavior_actions RCURLY )
                    // AadlBa.g:1225:8: identifier1= WHILE identifier2= LPAREN ValExpr= value_expression RPAREN LCURLY BehActions= behavior_actions RCURLY
                    {
                    identifier1=(Token)match(input,WHILE,FOLLOW_WHILE_in_behavior_action3620); if (state.failed) return BehAction;

                    identifier2=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_behavior_action3624); if (state.failed) return BehAction;

                    pushFollow(FOLLOW_value_expression_in_behavior_action3628);
                    ValExpr=value_expression();

                    state._fsp--;
                    if (state.failed) return BehAction;

                    match(input,RPAREN,FOLLOW_RPAREN_in_behavior_action3630); if (state.failed) return BehAction;

                    match(input,LCURLY,FOLLOW_LCURLY_in_behavior_action3640); if (state.failed) return BehAction;

                    pushFollow(FOLLOW_behavior_actions_in_behavior_action3644);
                    BehActions=behavior_actions();

                    state._fsp--;
                    if (state.failed) return BehAction;

                    match(input,RCURLY,FOLLOW_RCURLY_in_behavior_action3646); if (state.failed) return BehAction;

                    if ( state.backtracking==0 ) {
                             WhileOrDoUntilStatement WhileStat = _fact.createWhileOrDoUntilStatement();
                             setLocationReference(WhileStat, identifier1); 
                             setLocationReference(ValExpr, identifier2) ;
                             WhileStat.setDoUntil(false);
                             WhileStat.setLogicalValueExpression(ValExpr);
                             WhileStat.setBehaviorActions(BehActions);
                             BehAction = WhileStat ;
                             highlight(identifier1, AnnexHighlighterPositionAcceptor.KEYWORD_ID); 
                           }

                    }


                    }
                    break;
                case 7 :
                    // AadlBa.g:1240:6: (identifier1= DO BehActions= behavior_actions UNTIL identifier2= LPAREN ValExpr= value_expression RPAREN )
                    {
                    // AadlBa.g:1240:6: (identifier1= DO BehActions= behavior_actions UNTIL identifier2= LPAREN ValExpr= value_expression RPAREN )
                    // AadlBa.g:1240:8: identifier1= DO BehActions= behavior_actions UNTIL identifier2= LPAREN ValExpr= value_expression RPAREN
                    {
                    identifier1=(Token)match(input,DO,FOLLOW_DO_in_behavior_action3685); if (state.failed) return BehAction;

                    pushFollow(FOLLOW_behavior_actions_in_behavior_action3689);
                    BehActions=behavior_actions();

                    state._fsp--;
                    if (state.failed) return BehAction;

                    match(input,UNTIL,FOLLOW_UNTIL_in_behavior_action3691); if (state.failed) return BehAction;

                    identifier2=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_behavior_action3704); if (state.failed) return BehAction;

                    pushFollow(FOLLOW_value_expression_in_behavior_action3708);
                    ValExpr=value_expression();

                    state._fsp--;
                    if (state.failed) return BehAction;

                    match(input,RPAREN,FOLLOW_RPAREN_in_behavior_action3710); if (state.failed) return BehAction;

                    if ( state.backtracking==0 ) {
                             WhileOrDoUntilStatement doUntilStat = _fact.createWhileOrDoUntilStatement();
                             setLocationReference(doUntilStat, identifier1); 
                             setLocationReference(ValExpr, identifier2) ;
                             doUntilStat.setDoUntil(true);
                             doUntilStat.setLogicalValueExpression(ValExpr);
                             doUntilStat.setBehaviorActions(BehActions);
                             BehAction = doUntilStat ;
                             highlight(identifier1, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
                           }

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException ex) {

              // May be an extra ampersand or a semicolon given. Let the caller handles the exception.
              if(ex instanceof NoViableAltException && 
                    ((NoViableAltException)ex).grammarDecisionDescription.isEmpty())
              {
                 throw ex ;
              }
              else
              {
                reportError(ex);
                consumeUntil(input,SEMICOLON);
                input.consume();
              }

        }

        finally {
        	// do for sure before leaving
        }
        return BehAction;
    }
    // $ANTLR end "behavior_action"



    // $ANTLR start "element_values"
    // AadlBa.g:1274:1: element_values returns [ElementValues EltVal] : ( (IntRange= integer_range ) | (AdcRef= reference ) );
    public final ElementValues element_values() throws RecognitionException {
        ElementValues EltVal = null;


        IntegerRange IntRange =null;

        Reference AdcRef =null;



         
        try {
            // AadlBa.g:1277:3: ( (IntRange= integer_range ) | (AdcRef= reference ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==IDENT) ) {
                int LA37_1 = input.LA(2);

                if ( (synpred44_AadlBa()) ) {
                    alt37=1;
                }
                else if ( (true) ) {
                    alt37=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return EltVal;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA37_0==FALSE||LA37_0==INTEGER_LIT||LA37_0==REAL_LIT||LA37_0==STRING_LITERAL||LA37_0==TRUE) ) {
                alt37=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return EltVal;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }
            switch (alt37) {
                case 1 :
                    // AadlBa.g:1278:6: (IntRange= integer_range )
                    {
                    // AadlBa.g:1278:6: (IntRange= integer_range )
                    // AadlBa.g:1278:8: IntRange= integer_range
                    {
                    pushFollow(FOLLOW_integer_range_in_element_values3772);
                    IntRange=integer_range();

                    state._fsp--;
                    if (state.failed) return EltVal;

                    if ( state.backtracking==0 ) { EltVal = IntRange; }

                    }


                    }
                    break;
                case 2 :
                    // AadlBa.g:1280:6: (AdcRef= reference )
                    {
                    // AadlBa.g:1280:6: (AdcRef= reference )
                    // AadlBa.g:1280:8: AdcRef= reference
                    {
                    pushFollow(FOLLOW_reference_in_element_values3792);
                    AdcRef=reference();

                    state._fsp--;
                    if (state.failed) return EltVal;

                    if ( state.backtracking==0 ) { EltVal = (ElementValues) AdcRef; }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return EltVal;
    }
    // $ANTLR end "element_values"



    // $ANTLR start "basic_action"
    // AadlBa.g:1293:1: basic_action returns [BasicAction BaAction] : ( (AssAct= assignment_action ) | (CommAct= communication_action ) | (TimedAct= timed_action ) );
    public final BasicAction basic_action() throws RecognitionException {
        BasicAction BaAction = null;


        AssignmentAction AssAct =null;

        CommAction CommAct =null;

        TimedAction TimedAct =null;




        try {
            // AadlBa.g:1296:3: ( (AssAct= assignment_action ) | (CommAct= communication_action ) | (TimedAct= timed_action ) )
            int alt38=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                int LA38_1 = input.LA(2);

                if ( (synpred45_AadlBa()) ) {
                    alt38=1;
                }
                else if ( (synpred46_AadlBa()) ) {
                    alt38=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return BaAction;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 1, input);

                    throw nvae;

                }
                }
                break;
            case STAR:
                {
                alt38=2;
                }
                break;
            case COMPUTATION:
                {
                alt38=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return BaAction;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;

            }

            switch (alt38) {
                case 1 :
                    // AadlBa.g:1297:6: (AssAct= assignment_action )
                    {
                    // AadlBa.g:1297:6: (AssAct= assignment_action )
                    // AadlBa.g:1297:8: AssAct= assignment_action
                    {
                    pushFollow(FOLLOW_assignment_action_in_basic_action3836);
                    AssAct=assignment_action();

                    state._fsp--;
                    if (state.failed) return BaAction;

                    if ( state.backtracking==0 ) { BaAction = AssAct; }

                    }


                    }
                    break;
                case 2 :
                    // AadlBa.g:1299:6: (CommAct= communication_action )
                    {
                    // AadlBa.g:1299:6: (CommAct= communication_action )
                    // AadlBa.g:1299:8: CommAct= communication_action
                    {
                    pushFollow(FOLLOW_communication_action_in_basic_action3856);
                    CommAct=communication_action();

                    state._fsp--;
                    if (state.failed) return BaAction;

                    if ( state.backtracking==0 ) { BaAction = CommAct;}

                    }


                    }
                    break;
                case 3 :
                    // AadlBa.g:1301:6: (TimedAct= timed_action )
                    {
                    // AadlBa.g:1301:6: (TimedAct= timed_action )
                    // AadlBa.g:1301:8: TimedAct= timed_action
                    {
                    pushFollow(FOLLOW_timed_action_in_basic_action3876);
                    TimedAct=timed_action();

                    state._fsp--;
                    if (state.failed) return BaAction;

                    if ( state.backtracking==0 ) { BaAction = TimedAct; }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return BaAction;
    }
    // $ANTLR end "basic_action"



    // $ANTLR start "assignment_action"
    // AadlBa.g:1313:1: assignment_action returns [AssignmentAction AssAct] : Tar= target ASSIGN (ValExpr= value_expression |identifier= ANY ) ;
    public final AssignmentAction assignment_action() throws RecognitionException {
        AssignmentAction AssAct = null;


        Token identifier=null;
        Target Tar =null;

        ValueExpression ValExpr =null;



           AssAct = _fact.createAssignmentAction();
         
        try {
            // AadlBa.g:1317:3: (Tar= target ASSIGN (ValExpr= value_expression |identifier= ANY ) )
            // AadlBa.g:1318:4: Tar= target ASSIGN (ValExpr= value_expression |identifier= ANY )
            {
            pushFollow(FOLLOW_target_in_assignment_action3920);
            Tar=target();

            state._fsp--;
            if (state.failed) return AssAct;

            match(input,ASSIGN,FOLLOW_ASSIGN_in_assignment_action3922); if (state.failed) return AssAct;

            // AadlBa.g:1318:22: (ValExpr= value_expression |identifier= ANY )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==ABS||LA39_0==FALSE||LA39_0==IDENT||LA39_0==INTEGER_LIT||LA39_0==LPAREN||LA39_0==MINUS||LA39_0==NOT||LA39_0==PLUS||LA39_0==REAL_LIT||LA39_0==STRING_LITERAL||LA39_0==TRUE) ) {
                alt39=1;
            }
            else if ( (LA39_0==ANY) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return AssAct;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;

            }
            switch (alt39) {
                case 1 :
                    // AadlBa.g:1318:24: ValExpr= value_expression
                    {
                    pushFollow(FOLLOW_value_expression_in_assignment_action3928);
                    ValExpr=value_expression();

                    state._fsp--;
                    if (state.failed) return AssAct;

                    }
                    break;
                case 2 :
                    // AadlBa.g:1318:51: identifier= ANY
                    {
                    identifier=(Token)match(input,ANY,FOLLOW_ANY_in_assignment_action3934); if (state.failed) return AssAct;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
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

            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return AssAct;
    }
    // $ANTLR end "assignment_action"



    // $ANTLR start "target"
    // AadlBa.g:1347:1: target returns [Target Tar] : dt= reference ;
    public final Target target() throws RecognitionException {
        Target Tar = null;


        Reference dt =null;



           Tar = null ;
         
        try {
            // AadlBa.g:1351:3: (dt= reference )
            // AadlBa.g:1351:5: dt= reference
            {
            pushFollow(FOLLOW_reference_in_target3974);
            dt=reference();

            state._fsp--;
            if (state.failed) return Tar;

            if ( state.backtracking==0 ) {Tar= (Target) dt ;}

            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return Tar;
    }
    // $ANTLR end "target"



    // $ANTLR start "qualified_named_element"
    // AadlBa.g:1360:1: qualified_named_element returns [QualifiedNamedElement qne] : ( (identifier1= IDENT DOUBLECOLON )+ identifier2= IDENT ( DOT identifier3= IDENT )? ) ;
    public final QualifiedNamedElement qualified_named_element() throws RecognitionException {
        QualifiedNamedElement qne = null;


        Token identifier1=null;
        Token identifier2=null;
        Token identifier3=null;


          String id1 = "";
          String id2 = "";

        try {
            // AadlBa.g:1366:3: ( ( (identifier1= IDENT DOUBLECOLON )+ identifier2= IDENT ( DOT identifier3= IDENT )? ) )
            // AadlBa.g:1367:4: ( (identifier1= IDENT DOUBLECOLON )+ identifier2= IDENT ( DOT identifier3= IDENT )? )
            {
            // AadlBa.g:1367:4: ( (identifier1= IDENT DOUBLECOLON )+ identifier2= IDENT ( DOT identifier3= IDENT )? )
            // AadlBa.g:1368:5: (identifier1= IDENT DOUBLECOLON )+ identifier2= IDENT ( DOT identifier3= IDENT )?
            {
            // AadlBa.g:1368:5: (identifier1= IDENT DOUBLECOLON )+
            int cnt40=0;
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==IDENT) ) {
                    int LA40_1 = input.LA(2);

                    if ( (LA40_1==DOUBLECOLON) ) {
                        alt40=1;
                    }


                }


                switch (alt40) {
            	case 1 :
            	    // AadlBa.g:1368:7: identifier1= IDENT DOUBLECOLON
            	    {
            	    identifier1=(Token)match(input,IDENT,FOLLOW_IDENT_in_qualified_named_element4058); if (state.failed) return qne;

            	    match(input,DOUBLECOLON,FOLLOW_DOUBLECOLON_in_qualified_named_element4060); if (state.failed) return qne;

            	    if ( state.backtracking==0 ) { 
            	            id1=id1+(id1.length() == 0 ? "":"::")+identifier1.getText();
            	          }

            	    }
            	    break;

            	default :
            	    if ( cnt40 >= 1 ) break loop40;
            	    if (state.backtracking>0) {state.failed=true; return qne;}
                        EarlyExitException eee =
                            new EarlyExitException(40, input);
                        throw eee;
                }
                cnt40++;
            } while (true);


            identifier2=(Token)match(input,IDENT,FOLLOW_IDENT_in_qualified_named_element4088); if (state.failed) return qne;

            if ( state.backtracking==0 ) { 
                  id2=identifier2.getText();
                }

            // AadlBa.g:1378:5: ( DOT identifier3= IDENT )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==DOT) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // AadlBa.g:1378:7: DOT identifier3= IDENT
                    {
                    match(input,DOT,FOLLOW_DOT_in_qualified_named_element4102); if (state.failed) return qne;

                    identifier3=(Token)match(input,IDENT,FOLLOW_IDENT_in_qualified_named_element4106); if (state.failed) return qne;

                    if ( state.backtracking==0 ) {
                            id2=id2+"."+identifier3.getText();
                          }

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
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

            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return qne;
    }
    // $ANTLR end "qualified_named_element"



    // $ANTLR start "communication_action"
    // AadlBa.g:1419:1: communication_action returns [CommAction ca] : ( (qne= qualified_named_element EXCLAM ( LPAREN SubpgmParamList= subprogram_parameter_list RPAREN )? ) | (ref= reference ( ( INTERROG ( LPAREN Tar= target RPAREN )? ) | ( GGREATER ) | ( EXCLLESS ) | ( EXCLGREATER ) | ( EXCLAM ( LPAREN SubpgmParamList= subprogram_parameter_list RPAREN )? ) ) ) | (identifier= STAR ( EXCLLESS | EXCLGREATER ) ) );
    public final CommAction communication_action() throws RecognitionException {
        CommAction ca = null;


        Token identifier=null;
        QualifiedNamedElement qne =null;

        EList<ParameterLabel> SubpgmParamList =null;

        Reference ref =null;

        Target Tar =null;



          ca = _decl.createCommAction() ;

        try {
            // AadlBa.g:1424:3: ( (qne= qualified_named_element EXCLAM ( LPAREN SubpgmParamList= subprogram_parameter_list RPAREN )? ) | (ref= reference ( ( INTERROG ( LPAREN Tar= target RPAREN )? ) | ( GGREATER ) | ( EXCLLESS ) | ( EXCLGREATER ) | ( EXCLAM ( LPAREN SubpgmParamList= subprogram_parameter_list RPAREN )? ) ) ) | (identifier= STAR ( EXCLLESS | EXCLGREATER ) ) )
            int alt47=3;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==IDENT) ) {
                int LA47_1 = input.LA(2);

                if ( (LA47_1==DOUBLECOLON) ) {
                    alt47=1;
                }
                else if ( (LA47_1==DOT||(LA47_1 >= EXCLAM && LA47_1 <= EXCLLESS)||LA47_1==GGREATER||LA47_1==INTERROG||LA47_1==LBRACK) ) {
                    alt47=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ca;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA47_0==STAR) ) {
                alt47=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ca;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;

            }
            switch (alt47) {
                case 1 :
                    // AadlBa.g:1438:7: (qne= qualified_named_element EXCLAM ( LPAREN SubpgmParamList= subprogram_parameter_list RPAREN )? )
                    {
                    // AadlBa.g:1438:7: (qne= qualified_named_element EXCLAM ( LPAREN SubpgmParamList= subprogram_parameter_list RPAREN )? )
                    // AadlBa.g:1439:9: qne= qualified_named_element EXCLAM ( LPAREN SubpgmParamList= subprogram_parameter_list RPAREN )?
                    {
                    pushFollow(FOLLOW_qualified_named_element_in_communication_action4258);
                    qne=qualified_named_element();

                    state._fsp--;
                    if (state.failed) return ca;

                    match(input,EXCLAM,FOLLOW_EXCLAM_in_communication_action4260); if (state.failed) return ca;

                    if ( state.backtracking==0 ) {
                              ca.setLocationReference(qne.getLocationReference());
                              ca.setQualifiedName(qne);
                            }

                    // AadlBa.g:1444:9: ( LPAREN SubpgmParamList= subprogram_parameter_list RPAREN )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==LPAREN) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // AadlBa.g:1445:11: LPAREN SubpgmParamList= subprogram_parameter_list RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_communication_action4293); if (state.failed) return ca;

                            pushFollow(FOLLOW_subprogram_parameter_list_in_communication_action4297);
                            SubpgmParamList=subprogram_parameter_list();

                            state._fsp--;
                            if (state.failed) return ca;

                            match(input,RPAREN,FOLLOW_RPAREN_in_communication_action4299); if (state.failed) return ca;

                            if ( state.backtracking==0 ) {
                                        ca.getParameters().addAll(SubpgmParamList);
                                      }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // AadlBa.g:1452:7: (ref= reference ( ( INTERROG ( LPAREN Tar= target RPAREN )? ) | ( GGREATER ) | ( EXCLLESS ) | ( EXCLGREATER ) | ( EXCLAM ( LPAREN SubpgmParamList= subprogram_parameter_list RPAREN )? ) ) )
                    {
                    // AadlBa.g:1452:7: (ref= reference ( ( INTERROG ( LPAREN Tar= target RPAREN )? ) | ( GGREATER ) | ( EXCLLESS ) | ( EXCLGREATER ) | ( EXCLAM ( LPAREN SubpgmParamList= subprogram_parameter_list RPAREN )? ) ) )
                    // AadlBa.g:1453:9: ref= reference ( ( INTERROG ( LPAREN Tar= target RPAREN )? ) | ( GGREATER ) | ( EXCLLESS ) | ( EXCLGREATER ) | ( EXCLAM ( LPAREN SubpgmParamList= subprogram_parameter_list RPAREN )? ) )
                    {
                    pushFollow(FOLLOW_reference_in_communication_action4359);
                    ref=reference();

                    state._fsp--;
                    if (state.failed) return ca;

                    if ( state.backtracking==0 ) {
                              ca.setReference(ref);
                              ca.setLocationReference(ref.getLocationReference()) ;
                            }

                    // AadlBa.g:1458:9: ( ( INTERROG ( LPAREN Tar= target RPAREN )? ) | ( GGREATER ) | ( EXCLLESS ) | ( EXCLGREATER ) | ( EXCLAM ( LPAREN SubpgmParamList= subprogram_parameter_list RPAREN )? ) )
                    int alt45=5;
                    switch ( input.LA(1) ) {
                    case INTERROG:
                        {
                        alt45=1;
                        }
                        break;
                    case GGREATER:
                        {
                        alt45=2;
                        }
                        break;
                    case EXCLLESS:
                        {
                        alt45=3;
                        }
                        break;
                    case EXCLGREATER:
                        {
                        alt45=4;
                        }
                        break;
                    case EXCLAM:
                        {
                        alt45=5;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return ca;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 0, input);

                        throw nvae;

                    }

                    switch (alt45) {
                        case 1 :
                            // AadlBa.g:1459:13: ( INTERROG ( LPAREN Tar= target RPAREN )? )
                            {
                            // AadlBa.g:1459:13: ( INTERROG ( LPAREN Tar= target RPAREN )? )
                            // AadlBa.g:1460:15: INTERROG ( LPAREN Tar= target RPAREN )?
                            {
                            match(input,INTERROG,FOLLOW_INTERROG_in_communication_action4409); if (state.failed) return ca;

                            if ( state.backtracking==0 ) {
                                            ca.setPortDequeue(true);
                                          }

                            // AadlBa.g:1464:15: ( LPAREN Tar= target RPAREN )?
                            int alt43=2;
                            int LA43_0 = input.LA(1);

                            if ( (LA43_0==LPAREN) ) {
                                alt43=1;
                            }
                            switch (alt43) {
                                case 1 :
                                    // AadlBa.g:1465:17: LPAREN Tar= target RPAREN
                                    {
                                    match(input,LPAREN,FOLLOW_LPAREN_in_communication_action4459); if (state.failed) return ca;

                                    pushFollow(FOLLOW_target_in_communication_action4463);
                                    Tar=target();

                                    state._fsp--;
                                    if (state.failed) return ca;

                                    match(input,RPAREN,FOLLOW_RPAREN_in_communication_action4465); if (state.failed) return ca;

                                    if ( state.backtracking==0 ) {
                                                      ca.setTarget(Tar);
                                                    }

                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // AadlBa.g:1472:13: ( GGREATER )
                            {
                            // AadlBa.g:1472:13: ( GGREATER )
                            // AadlBa.g:1473:15: GGREATER
                            {
                            match(input,GGREATER,FOLLOW_GGREATER_in_communication_action4556); if (state.failed) return ca;

                            if ( state.backtracking==0 ) { 
                                            ca.setPortFreeze(true);
                                          }

                            }


                            }
                            break;
                        case 3 :
                            // AadlBa.g:1479:13: ( EXCLLESS )
                            {
                            // AadlBa.g:1479:13: ( EXCLLESS )
                            // AadlBa.g:1480:15: EXCLLESS
                            {
                            match(input,EXCLLESS,FOLLOW_EXCLLESS_in_communication_action4628); if (state.failed) return ca;

                            if ( state.backtracking==0 ) {
                                            ca.setLock(true);
                                          }

                            }


                            }
                            break;
                        case 4 :
                            // AadlBa.g:1486:13: ( EXCLGREATER )
                            {
                            // AadlBa.g:1486:13: ( EXCLGREATER )
                            // AadlBa.g:1487:15: EXCLGREATER
                            {
                            match(input,EXCLGREATER,FOLLOW_EXCLGREATER_in_communication_action4700); if (state.failed) return ca;

                            if ( state.backtracking==0 ) {
                                            ca.setUnlock(true);
                                          }

                            }


                            }
                            break;
                        case 5 :
                            // AadlBa.g:1493:13: ( EXCLAM ( LPAREN SubpgmParamList= subprogram_parameter_list RPAREN )? )
                            {
                            // AadlBa.g:1493:13: ( EXCLAM ( LPAREN SubpgmParamList= subprogram_parameter_list RPAREN )? )
                            // AadlBa.g:1494:15: EXCLAM ( LPAREN SubpgmParamList= subprogram_parameter_list RPAREN )?
                            {
                            match(input,EXCLAM,FOLLOW_EXCLAM_in_communication_action4772); if (state.failed) return ca;

                            // AadlBa.g:1495:15: ( LPAREN SubpgmParamList= subprogram_parameter_list RPAREN )?
                            int alt44=2;
                            int LA44_0 = input.LA(1);

                            if ( (LA44_0==LPAREN) ) {
                                alt44=1;
                            }
                            switch (alt44) {
                                case 1 :
                                    // AadlBa.g:1496:17: LPAREN SubpgmParamList= subprogram_parameter_list RPAREN
                                    {
                                    match(input,LPAREN,FOLLOW_LPAREN_in_communication_action4807); if (state.failed) return ca;

                                    pushFollow(FOLLOW_subprogram_parameter_list_in_communication_action4811);
                                    SubpgmParamList=subprogram_parameter_list();

                                    state._fsp--;
                                    if (state.failed) return ca;

                                    match(input,RPAREN,FOLLOW_RPAREN_in_communication_action4813); if (state.failed) return ca;

                                    if ( state.backtracking==0 ) {
                                                      ca.getParameters().addAll(SubpgmParamList);
                                                    }

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // AadlBa.g:1505:7: (identifier= STAR ( EXCLLESS | EXCLGREATER ) )
                    {
                    // AadlBa.g:1505:7: (identifier= STAR ( EXCLLESS | EXCLGREATER ) )
                    // AadlBa.g:1506:9: identifier= STAR ( EXCLLESS | EXCLGREATER )
                    {
                    identifier=(Token)match(input,STAR,FOLLOW_STAR_in_communication_action4906); if (state.failed) return ca;

                    // AadlBa.g:1507:9: ( EXCLLESS | EXCLGREATER )
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==EXCLLESS) ) {
                        alt46=1;
                    }
                    else if ( (LA46_0==EXCLGREATER) ) {
                        alt46=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ca;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 0, input);

                        throw nvae;

                    }
                    switch (alt46) {
                        case 1 :
                            // AadlBa.g:1508:13: EXCLLESS
                            {
                            match(input,EXCLLESS,FOLLOW_EXCLLESS_in_communication_action4931); if (state.failed) return ca;

                            if ( state.backtracking==0 ) {
                                          ca.setLock(true);
                                        }

                            }
                            break;
                        case 2 :
                            // AadlBa.g:1513:13: EXCLGREATER
                            {
                            match(input,EXCLGREATER,FOLLOW_EXCLGREATER_in_communication_action4972); if (state.failed) return ca;

                            if ( state.backtracking==0 ) {
                                          ca.setUnlock(true);
                                        }

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                              setLocationReference(ca, identifier);
                            }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return ca;
    }
    // $ANTLR end "communication_action"



    // $ANTLR start "timed_action"
    // AadlBa.g:1531:1: timed_action returns [TimedAction TimedAct] : (identifier= COMPUTATION ) LPAREN BehTime= behavior_time ( DOTDOT BehTime= behavior_time )? RPAREN ;
    public final TimedAction timed_action() throws RecognitionException {
        TimedAction TimedAct = null;


        Token identifier=null;
        DeclarativeTime BehTime =null;



           TimedAct = _fact.createTimedAction();
         
        try {
            // AadlBa.g:1535:3: ( (identifier= COMPUTATION ) LPAREN BehTime= behavior_time ( DOTDOT BehTime= behavior_time )? RPAREN )
            // AadlBa.g:1536:4: (identifier= COMPUTATION ) LPAREN BehTime= behavior_time ( DOTDOT BehTime= behavior_time )? RPAREN
            {
            // AadlBa.g:1536:4: (identifier= COMPUTATION )
            // AadlBa.g:1536:6: identifier= COMPUTATION
            {
            identifier=(Token)match(input,COMPUTATION,FOLLOW_COMPUTATION_in_timed_action5049); if (state.failed) return TimedAct;

            if ( state.backtracking==0 ) {setLocationReference(TimedAct, identifier) ; highlight(identifier, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}

            }


            match(input,LPAREN,FOLLOW_LPAREN_in_timed_action5065); if (state.failed) return TimedAct;

            pushFollow(FOLLOW_behavior_time_in_timed_action5074);
            BehTime=behavior_time();

            state._fsp--;
            if (state.failed) return TimedAct;

            if ( state.backtracking==0 ) {TimedAct.setLowerTime(BehTime); }

            // AadlBa.g:1540:6: ( DOTDOT BehTime= behavior_time )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==DOTDOT) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // AadlBa.g:1540:7: DOTDOT BehTime= behavior_time
                    {
                    match(input,DOTDOT,FOLLOW_DOTDOT_in_timed_action5084); if (state.failed) return TimedAct;

                    pushFollow(FOLLOW_behavior_time_in_timed_action5088);
                    BehTime=behavior_time();

                    state._fsp--;
                    if (state.failed) return TimedAct;

                    if ( state.backtracking==0 ) {TimedAct.setUpperTime(BehTime);}

                    }
                    break;

            }


            match(input,RPAREN,FOLLOW_RPAREN_in_timed_action5104); if (state.failed) return TimedAct;

            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return TimedAct;
    }
    // $ANTLR end "timed_action"



    // $ANTLR start "subprogram_parameter_list"
    // AadlBa.g:1553:1: subprogram_parameter_list returns [EList<ParameterLabel> SpgParamList] : ParamLabel= parameter_label (identifier= COMMA ParamLabel= parameter_label )* ;
    public final EList<ParameterLabel> subprogram_parameter_list() throws RecognitionException {
        EList<ParameterLabel> SpgParamList = null;


        Token identifier=null;
        ParameterLabel ParamLabel =null;



           SpgParamList = new BasicEList<ParameterLabel>();
         
        try {
            // AadlBa.g:1557:3: (ParamLabel= parameter_label (identifier= COMMA ParamLabel= parameter_label )* )
            // AadlBa.g:1558:4: ParamLabel= parameter_label (identifier= COMMA ParamLabel= parameter_label )*
            {
            pushFollow(FOLLOW_parameter_label_in_subprogram_parameter_list5139);
            ParamLabel=parameter_label();

            state._fsp--;
            if (state.failed) return SpgParamList;

            if ( state.backtracking==0 ) { SpgParamList.add(ParamLabel);}

            // AadlBa.g:1559:4: (identifier= COMMA ParamLabel= parameter_label )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==COMMA) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // AadlBa.g:1559:5: identifier= COMMA ParamLabel= parameter_label
            	    {
            	    identifier=(Token)match(input,COMMA,FOLLOW_COMMA_in_subprogram_parameter_list5150); if (state.failed) return SpgParamList;

            	    pushFollow(FOLLOW_parameter_label_in_subprogram_parameter_list5154);
            	    ParamLabel=parameter_label();

            	    state._fsp--;
            	    if (state.failed) return SpgParamList;

            	    if ( state.backtracking==0 ) { SpgParamList.add(ParamLabel);
            	                                                      if( ParamLabel.getLocationReference() == null) // SG case of an ValueExpr else Target is already set
            	                                                      {
            	                                                         setLocationReference(ParamLabel, identifier) ; 
            	                                                      }
            	                                                    }

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return SpgParamList;
    }
    // $ANTLR end "subprogram_parameter_list"



    // $ANTLR start "parameter_label"
    // AadlBa.g:1574:1: parameter_label returns [ParameterLabel ParamLabel] : (ValExpr= value_expression ) ;
    public final ParameterLabel parameter_label() throws RecognitionException {
        ParameterLabel ParamLabel = null;


        ValueExpression ValExpr =null;



         
        try {
            // AadlBa.g:1577:3: ( (ValExpr= value_expression ) )
            // AadlBa.g:1579:4: (ValExpr= value_expression )
            {
            // AadlBa.g:1579:4: (ValExpr= value_expression )
            // AadlBa.g:1580:8: ValExpr= value_expression
            {
            pushFollow(FOLLOW_value_expression_in_parameter_label5208);
            ValExpr=value_expression();

            state._fsp--;
            if (state.failed) return ParamLabel;

            if ( state.backtracking==0 ) { ParamLabel = ValExpr; }

            }


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return ParamLabel;
    }
    // $ANTLR end "parameter_label"



    // $ANTLR start "reference"
    // AadlBa.g:1611:1: reference returns [Reference ref] : id= array_identifier ( DOT id= array_identifier )* ;
    public final Reference reference() throws RecognitionException {
        Reference ref = null;


        ArrayableIdentifier id =null;



            ref = _decl.createReference() ;
           
         
        try {
            // AadlBa.g:1616:3: (id= array_identifier ( DOT id= array_identifier )* )
            // AadlBa.g:1617:5: id= array_identifier ( DOT id= array_identifier )*
            {
            pushFollow(FOLLOW_array_identifier_in_reference5272);
            id=array_identifier();

            state._fsp--;
            if (state.failed) return ref;

            if ( state.backtracking==0 ) {
                  ref.getIds().add(id);
                  ref.setLocationReference(id.getLocationReference());
                }

            // AadlBa.g:1622:5: ( DOT id= array_identifier )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==DOT) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // AadlBa.g:1623:7: DOT id= array_identifier
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_reference5292); if (state.failed) return ref;

            	    pushFollow(FOLLOW_array_identifier_in_reference5296);
            	    id=array_identifier();

            	    state._fsp--;
            	    if (state.failed) return ref;

            	    if ( state.backtracking==0 ) {
            	            ref.getIds().add(id);
            	          }

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return ref;
    }
    // $ANTLR end "reference"



    // $ANTLR start "array_identifier"
    // AadlBa.g:1637:1: array_identifier returns [ArrayableIdentifier id] : identifier= IDENT ( LBRACK Val= integer_value RBRACK )* ;
    public final ArrayableIdentifier array_identifier() throws RecognitionException {
        ArrayableIdentifier id = null;


        Token identifier=null;
        IntegerValue Val =null;



          id = _decl.createArrayableIdentifier() ;

        try {
            // AadlBa.g:1642:3: (identifier= IDENT ( LBRACK Val= integer_value RBRACK )* )
            // AadlBa.g:1643:5: identifier= IDENT ( LBRACK Val= integer_value RBRACK )*
            {
            identifier=(Token)match(input,IDENT,FOLLOW_IDENT_in_array_identifier5345); if (state.failed) return id;

            if ( state.backtracking==0 ) {
                  id.setId(identifier.getText());    
                  setLocationReference(id, identifier); 
                }

            // AadlBa.g:1648:5: ( LBRACK Val= integer_value RBRACK )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==LBRACK) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // AadlBa.g:1649:7: LBRACK Val= integer_value RBRACK
            	    {
            	    match(input,LBRACK,FOLLOW_LBRACK_in_array_identifier5365); if (state.failed) return id;

            	    pushFollow(FOLLOW_integer_value_in_array_identifier5369);
            	    Val=integer_value();

            	    state._fsp--;
            	    if (state.failed) return id;

            	    match(input,RBRACK,FOLLOW_RBRACK_in_array_identifier5371); if (state.failed) return id;

            	    if ( state.backtracking==0 ) {
            	            id.getArrayIndexes().add(Val);
            	          }

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return id;
    }
    // $ANTLR end "array_identifier"



    // $ANTLR start "fact_value"
    // AadlBa.g:1690:1: fact_value returns [Value Val] : ( (id1= IDENT DOUBLECOLON id2= IDENT ) |ValueVar= value_variable |bl= boolean_literal |nl= numeric_literal |st= string_literal |lit= behavior_enumeration_literal ) ;
    public final Value fact_value() throws RecognitionException {
        Value Val = null;


        Token id1=null;
        Token id2=null;
        ValueVariable ValueVar =null;

        BehaviorBooleanLiteral bl =null;

        NumericLiteral nl =null;

        BehaviorStringLiteral st =null;

        Enumeration lit =null;



           Val = null ;
         
        try {
            // AadlBa.g:1695:3: ( ( (id1= IDENT DOUBLECOLON id2= IDENT ) |ValueVar= value_variable |bl= boolean_literal |nl= numeric_literal |st= string_literal |lit= behavior_enumeration_literal ) )
            // AadlBa.g:1699:4: ( (id1= IDENT DOUBLECOLON id2= IDENT ) |ValueVar= value_variable |bl= boolean_literal |nl= numeric_literal |st= string_literal |lit= behavior_enumeration_literal )
            {
            // AadlBa.g:1699:4: ( (id1= IDENT DOUBLECOLON id2= IDENT ) |ValueVar= value_variable |bl= boolean_literal |nl= numeric_literal |st= string_literal |lit= behavior_enumeration_literal )
            int alt52=6;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                switch ( input.LA(2) ) {
                case DOUBLECOLON:
                    {
                    int LA52_5 = input.LA(3);

                    if ( (LA52_5==IDENT) ) {
                        int LA52_9 = input.LA(4);

                        if ( (LA52_9==DOT||LA52_9==DOUBLECOLON||LA52_9==HASH) ) {
                            alt52=6;
                        }
                        else if ( (LA52_9==EOF||LA52_9==AND||LA52_9==COMMA||LA52_9==CONCAT||LA52_9==DIVIDE||LA52_9==DOTDOT||(LA52_9 >= ELSE && LA52_9 <= EQUAL)||(LA52_9 >= GREATEROREQUAL && LA52_9 <= GREATERTHAN)||LA52_9==IDENT||(LA52_9 >= LESSOREQUAL && LA52_9 <= LESSTHAN)||(LA52_9 >= MINUS && LA52_9 <= MOD)||LA52_9==NOTEQUAL||LA52_9==OR||(LA52_9 >= PLUS && LA52_9 <= RCURLY)||(LA52_9 >= REM && LA52_9 <= SEMICOLON)||(LA52_9 >= STAR && LA52_9 <= STARSTAR)||LA52_9==UNTIL||LA52_9==XOR) ) {
                            alt52=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return Val;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 52, 9, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return Val;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 52, 5, input);

                        throw nvae;

                    }
                    }
                    break;
                case EOF:
                case AND:
                case COMMA:
                case CONCAT:
                case DIVIDE:
                case DOTDOT:
                case ELSE:
                case ELSIF:
                case END:
                case EQUAL:
                case GREATEROREQUAL:
                case GREATERTHAN:
                case IDENT:
                case INTERROG:
                case LBRACK:
                case LESSOREQUAL:
                case LESSTHAN:
                case MINUS:
                case MOD:
                case NOTEQUAL:
                case OR:
                case PLUS:
                case RBRACK:
                case RCURLY:
                case REM:
                case RPAREN:
                case RTRANS:
                case SEMICOLON:
                case STAR:
                case STARSTAR:
                case TICK:
                case UNTIL:
                case XOR:
                    {
                    alt52=2;
                    }
                    break;
                case DOT:
                    {
                    int LA52_7 = input.LA(3);

                    if ( (LA52_7==IDENT) ) {
                        int LA52_10 = input.LA(4);

                        if ( (LA52_10==HASH) ) {
                            alt52=6;
                        }
                        else if ( (LA52_10==EOF||LA52_10==AND||LA52_10==COMMA||LA52_10==CONCAT||LA52_10==DIVIDE||(LA52_10 >= DOT && LA52_10 <= DOTDOT)||(LA52_10 >= ELSE && LA52_10 <= EQUAL)||(LA52_10 >= GREATEROREQUAL && LA52_10 <= GREATERTHAN)||LA52_10==IDENT||LA52_10==INTERROG||LA52_10==LBRACK||(LA52_10 >= LESSOREQUAL && LA52_10 <= LESSTHAN)||(LA52_10 >= MINUS && LA52_10 <= MOD)||LA52_10==NOTEQUAL||LA52_10==OR||(LA52_10 >= PLUS && LA52_10 <= RCURLY)||(LA52_10 >= REM && LA52_10 <= SEMICOLON)||(LA52_10 >= STAR && LA52_10 <= STARSTAR)||LA52_10==TICK||LA52_10==UNTIL||LA52_10==XOR) ) {
                            alt52=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return Val;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 52, 10, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return Val;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 52, 7, input);

                        throw nvae;

                    }
                    }
                    break;
                case HASH:
                    {
                    alt52=6;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return Val;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 1, input);

                    throw nvae;

                }

                }
                break;
            case FALSE:
            case TRUE:
                {
                alt52=3;
                }
                break;
            case INTEGER_LIT:
            case REAL_LIT:
                {
                alt52=4;
                }
                break;
            case STRING_LITERAL:
                {
                alt52=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return Val;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;

            }

            switch (alt52) {
                case 1 :
                    // AadlBa.g:1701:8: (id1= IDENT DOUBLECOLON id2= IDENT )
                    {
                    // AadlBa.g:1701:8: (id1= IDENT DOUBLECOLON id2= IDENT )
                    // AadlBa.g:1702:11: id1= IDENT DOUBLECOLON id2= IDENT
                    {
                    id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_fact_value5494); if (state.failed) return Val;

                    match(input,DOUBLECOLON,FOLLOW_DOUBLECOLON_in_fact_value5496); if (state.failed) return Val;

                    id2=(Token)match(input,IDENT,FOLLOW_IDENT_in_fact_value5500); if (state.failed) return Val;

                    if ( state.backtracking==0 ) {
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

                    }


                    }
                    break;
                case 2 :
                    // AadlBa.g:1724:8: ValueVar= value_variable
                    {
                    pushFollow(FOLLOW_value_variable_in_fact_value5548);
                    ValueVar=value_variable();

                    state._fsp--;
                    if (state.failed) return Val;

                    if ( state.backtracking==0 ) { Val = ValueVar ;}

                    }
                    break;
                case 3 :
                    // AadlBa.g:1727:8: bl= boolean_literal
                    {
                    pushFollow(FOLLOW_boolean_literal_in_fact_value5570);
                    bl=boolean_literal();

                    state._fsp--;
                    if (state.failed) return Val;

                    if ( state.backtracking==0 ) { Val = bl;}

                    }
                    break;
                case 4 :
                    // AadlBa.g:1729:8: nl= numeric_literal
                    {
                    pushFollow(FOLLOW_numeric_literal_in_fact_value5590);
                    nl=numeric_literal();

                    state._fsp--;
                    if (state.failed) return Val;

                    if ( state.backtracking==0 ) { Val = nl;}

                    }
                    break;
                case 5 :
                    // AadlBa.g:1731:8: st= string_literal
                    {
                    pushFollow(FOLLOW_string_literal_in_fact_value5610);
                    st=string_literal();

                    state._fsp--;
                    if (state.failed) return Val;

                    if ( state.backtracking==0 ) { Val = st;}

                    }
                    break;
                case 6 :
                    // AadlBa.g:1733:8: lit= behavior_enumeration_literal
                    {
                    pushFollow(FOLLOW_behavior_enumeration_literal_in_fact_value5631);
                    lit=behavior_enumeration_literal();

                    state._fsp--;
                    if (state.failed) return Val;

                    if ( state.backtracking==0 ) { Val = lit ;}

                    }
                    break;

            }


            }

        }
        catch (RecognitionException ex) {

              
              throw ex ;

        }

        finally {
        	// do for sure before leaving
        }
        return Val;
    }
    // $ANTLR end "fact_value"



    // $ANTLR start "value"
    // AadlBa.g:1753:1: value returns [Value Val] : ( (ValTmp= fact_value ) | (identifier= LPAREN ValExpr= value_expression RPAREN ) ) ;
    public final Value value() throws RecognitionException {
        Value Val = null;


        Token identifier=null;
        Value ValTmp =null;

        ValueExpression ValExpr =null;



         
        try {
            // AadlBa.g:1756:3: ( ( (ValTmp= fact_value ) | (identifier= LPAREN ValExpr= value_expression RPAREN ) ) )
            // AadlBa.g:1757:4: ( (ValTmp= fact_value ) | (identifier= LPAREN ValExpr= value_expression RPAREN ) )
            {
            // AadlBa.g:1757:4: ( (ValTmp= fact_value ) | (identifier= LPAREN ValExpr= value_expression RPAREN ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==FALSE||LA53_0==IDENT||LA53_0==INTEGER_LIT||LA53_0==REAL_LIT||LA53_0==STRING_LITERAL||LA53_0==TRUE) ) {
                alt53=1;
            }
            else if ( (LA53_0==LPAREN) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return Val;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;

            }
            switch (alt53) {
                case 1 :
                    // AadlBa.g:1758:8: (ValTmp= fact_value )
                    {
                    // AadlBa.g:1758:8: (ValTmp= fact_value )
                    // AadlBa.g:1758:10: ValTmp= fact_value
                    {
                    pushFollow(FOLLOW_fact_value_in_value5692);
                    ValTmp=fact_value();

                    state._fsp--;
                    if (state.failed) return Val;

                    }


                    if ( state.backtracking==0 ) {Val = ValTmp;}

                    }
                    break;
                case 2 :
                    // AadlBa.g:1760:8: (identifier= LPAREN ValExpr= value_expression RPAREN )
                    {
                    // AadlBa.g:1760:8: (identifier= LPAREN ValExpr= value_expression RPAREN )
                    // AadlBa.g:1760:10: identifier= LPAREN ValExpr= value_expression RPAREN
                    {
                    identifier=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_value5716); if (state.failed) return Val;

                    pushFollow(FOLLOW_value_expression_in_value5720);
                    ValExpr=value_expression();

                    state._fsp--;
                    if (state.failed) return Val;

                    match(input,RPAREN,FOLLOW_RPAREN_in_value5722); if (state.failed) return Val;

                    if ( state.backtracking==0 ) { setLocationReference(ValExpr, identifier) ; Val = ValExpr; }

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException ex) {

              throw ex ;

        }

        finally {
        	// do for sure before leaving
        }
        return Val;
    }
    // $ANTLR end "value"



    // $ANTLR start "value_variable"
    // AadlBa.g:1776:1: value_variable returns [ValueVariable ValueVar] : (ref= reference ( INTERROG | TICK (keyword= COUNT |keyword= FRESH ) )? ) ;
    public final ValueVariable value_variable() throws RecognitionException {
        ValueVariable ValueVar = null;


        Token keyword=null;
        Reference ref =null;



           ValueVar = null ;
         
        try {
            // AadlBa.g:1781:3: ( (ref= reference ( INTERROG | TICK (keyword= COUNT |keyword= FRESH ) )? ) )
            // AadlBa.g:1782:6: (ref= reference ( INTERROG | TICK (keyword= COUNT |keyword= FRESH ) )? )
            {
            // AadlBa.g:1782:6: (ref= reference ( INTERROG | TICK (keyword= COUNT |keyword= FRESH ) )? )
            // AadlBa.g:1783:8: ref= reference ( INTERROG | TICK (keyword= COUNT |keyword= FRESH ) )?
            {
            pushFollow(FOLLOW_reference_in_value_variable5799);
            ref=reference();

            state._fsp--;
            if (state.failed) return ValueVar;

            // AadlBa.g:1785:8: ( INTERROG | TICK (keyword= COUNT |keyword= FRESH ) )?
            int alt55=3;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==INTERROG) ) {
                alt55=1;
            }
            else if ( (LA55_0==TICK) ) {
                alt55=2;
            }
            switch (alt55) {
                case 1 :
                    // AadlBa.g:1786:12: INTERROG
                    {
                    match(input,INTERROG,FOLLOW_INTERROG_in_value_variable5829); if (state.failed) return ValueVar;

                    if ( state.backtracking==0 ) {
                                 NamedValue nv = _decl.createNamedValue();
                                 nv.setReference(ref) ;
                                 nv.setDequeue(true);
                                 nv.setLocationReference(ref.getLocationReference());
                                 ValueVar = nv ;
                               }

                    }
                    break;
                case 2 :
                    // AadlBa.g:1795:12: TICK (keyword= COUNT |keyword= FRESH )
                    {
                    match(input,TICK,FOLLOW_TICK_in_value_variable5866); if (state.failed) return ValueVar;

                    // AadlBa.g:1795:17: (keyword= COUNT |keyword= FRESH )
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( (LA54_0==COUNT) ) {
                        alt54=1;
                    }
                    else if ( (LA54_0==FRESH) ) {
                        alt54=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ValueVar;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 54, 0, input);

                        throw nvae;

                    }
                    switch (alt54) {
                        case 1 :
                            // AadlBa.g:1796:21: keyword= COUNT
                            {
                            keyword=(Token)match(input,COUNT,FOLLOW_COUNT_in_value_variable5892); if (state.failed) return ValueVar;

                            if ( state.backtracking==0 ) { 
                                                  NamedValue nv = _decl.createNamedValue();
                                                  nv.setReference(ref) ;
                                                  nv.setCount(true);
                                                   nv.setLocationReference(ref.getLocationReference());
                                                  ValueVar = nv ;
                                                  highlight(keyword, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
                                                }

                            }
                            break;
                        case 2 :
                            // AadlBa.g:1806:21: keyword= FRESH
                            {
                            keyword=(Token)match(input,FRESH,FOLLOW_FRESH_in_value_variable5961); if (state.failed) return ValueVar;

                            if ( state.backtracking==0 ) {
                                                  NamedValue nv = _decl.createNamedValue();
                                                  nv.setReference(ref) ;
                                                  nv.setFresh(true);
                                                   nv.setLocationReference(ref.getLocationReference());
                                                  ValueVar = nv ;
                                                  highlight(keyword, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
                                                }

                            }
                            break;

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                     if (ValueVar == null)
                     {
                       ValueVar = ref ;
                     }
                   }

            }


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return ValueVar;
    }
    // $ANTLR end "value_variable"



    // $ANTLR start "value_expression"
    // AadlBa.g:1841:1: value_expression returns [ValueExpression ValueExpr] : (Rel= relation (LogicalOp= logical_operator Rel= relation )* ) ;
    public final ValueExpression value_expression() throws RecognitionException {
        ValueExpression ValueExpr = null;


        Relation Rel =null;

        LogicalOperator LogicalOp =null;



           ValueExpr = _fact.createValueExpression();
         
        try {
            // AadlBa.g:1845:3: ( (Rel= relation (LogicalOp= logical_operator Rel= relation )* ) )
            // AadlBa.g:1846:4: (Rel= relation (LogicalOp= logical_operator Rel= relation )* )
            {
            // AadlBa.g:1846:4: (Rel= relation (LogicalOp= logical_operator Rel= relation )* )
            // AadlBa.g:1847:6: Rel= relation (LogicalOp= logical_operator Rel= relation )*
            {
            pushFollow(FOLLOW_relation_in_value_expression6071);
            Rel=relation();

            state._fsp--;
            if (state.failed) return ValueExpr;

            if ( state.backtracking==0 ) { ValueExpr.getRelations().add(Rel);
                   ValueExpr.setLocationReference(Rel.getLocationReference());
                 }

            // AadlBa.g:1851:6: (LogicalOp= logical_operator Rel= relation )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==AND||LA56_0==OR||LA56_0==XOR) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // AadlBa.g:1852:8: LogicalOp= logical_operator Rel= relation
            	    {
            	    pushFollow(FOLLOW_logical_operator_in_value_expression6096);
            	    LogicalOp=logical_operator();

            	    state._fsp--;
            	    if (state.failed) return ValueExpr;

            	    pushFollow(FOLLOW_relation_in_value_expression6100);
            	    Rel=relation();

            	    state._fsp--;
            	    if (state.failed) return ValueExpr;

            	    if ( state.backtracking==0 ) {
            	            ValueExpr.getLogicalOperators().add(LogicalOp);
            	            ValueExpr.getRelations().add(Rel);
            	           }

            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            }


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return ValueExpr;
    }
    // $ANTLR end "value_expression"



    // $ANTLR start "relation"
    // AadlBa.g:1869:1: relation returns [Relation Rel] : SimpleExpr= simple_expression (RelationalOp= relational_operator SimpleExpr= simple_expression )? ;
    public final Relation relation() throws RecognitionException {
        Relation Rel = null;


        SimpleExpression SimpleExpr =null;

        RelationalOperator RelationalOp =null;



           Rel = _fact.createRelation();
         
        try {
            // AadlBa.g:1873:3: (SimpleExpr= simple_expression (RelationalOp= relational_operator SimpleExpr= simple_expression )? )
            // AadlBa.g:1874:4: SimpleExpr= simple_expression (RelationalOp= relational_operator SimpleExpr= simple_expression )?
            {
            pushFollow(FOLLOW_simple_expression_in_relation6157);
            SimpleExpr=simple_expression();

            state._fsp--;
            if (state.failed) return Rel;

            if ( state.backtracking==0 ) { Rel.setFirstExpression(SimpleExpr);
                 Rel.setLocationReference(SimpleExpr.getLocationReference());  
               }

            // AadlBa.g:1878:4: (RelationalOp= relational_operator SimpleExpr= simple_expression )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==EQUAL||(LA57_0 >= GREATEROREQUAL && LA57_0 <= GREATERTHAN)||(LA57_0 >= LESSOREQUAL && LA57_0 <= LESSTHAN)||LA57_0==NOTEQUAL) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // AadlBa.g:1879:6: RelationalOp= relational_operator SimpleExpr= simple_expression
                    {
                    pushFollow(FOLLOW_relational_operator_in_relation6176);
                    RelationalOp=relational_operator();

                    state._fsp--;
                    if (state.failed) return Rel;

                    pushFollow(FOLLOW_simple_expression_in_relation6180);
                    SimpleExpr=simple_expression();

                    state._fsp--;
                    if (state.failed) return Rel;

                    if ( state.backtracking==0 ) {
                          Rel.setRelationalOperator(RelationalOp);
                          Rel.setSecondExpression(SimpleExpr);
                         }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return Rel;
    }
    // $ANTLR end "relation"



    // $ANTLR start "simple_expression"
    // AadlBa.g:1895:1: simple_expression returns [SimpleExpression SimpleExpr] : (UnaryAddOp= unary_adding_operator )? tm= term (BinaryAddOp= binary_adding_operator tm= term )* ;
    public final SimpleExpression simple_expression() throws RecognitionException {
        SimpleExpression SimpleExpr = null;


        UnaryAddingOperator UnaryAddOp =null;

        Term tm =null;

        BinaryAddingOperator BinaryAddOp =null;



           SimpleExpr = _fact.createSimpleExpression();
         
        try {
            // AadlBa.g:1899:3: ( (UnaryAddOp= unary_adding_operator )? tm= term (BinaryAddOp= binary_adding_operator tm= term )* )
            // AadlBa.g:1900:4: (UnaryAddOp= unary_adding_operator )? tm= term (BinaryAddOp= binary_adding_operator tm= term )*
            {
            // AadlBa.g:1900:4: (UnaryAddOp= unary_adding_operator )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==MINUS||LA58_0==PLUS) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // AadlBa.g:1901:6: UnaryAddOp= unary_adding_operator
                    {
                    pushFollow(FOLLOW_unary_adding_operator_in_simple_expression6235);
                    UnaryAddOp=unary_adding_operator();

                    state._fsp--;
                    if (state.failed) return SimpleExpr;

                    if ( state.backtracking==0 ) {
                          SimpleExpr.setUnaryAddingOperator(UnaryAddOp);
                         }

                    }
                    break;

            }


            pushFollow(FOLLOW_term_in_simple_expression6260);
            tm=term();

            state._fsp--;
            if (state.failed) return SimpleExpr;

            if ( state.backtracking==0 ) { 
                 SimpleExpr.getTerms().add(tm);
                 SimpleExpr.setLocationReference(tm.getLocationReference());
               }

            // AadlBa.g:1913:4: (BinaryAddOp= binary_adding_operator tm= term )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==MINUS||LA59_0==PLUS) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // AadlBa.g:1914:6: BinaryAddOp= binary_adding_operator tm= term
            	    {
            	    pushFollow(FOLLOW_binary_adding_operator_in_simple_expression6283);
            	    BinaryAddOp=binary_adding_operator();

            	    state._fsp--;
            	    if (state.failed) return SimpleExpr;

            	    pushFollow(FOLLOW_term_in_simple_expression6287);
            	    tm=term();

            	    state._fsp--;
            	    if (state.failed) return SimpleExpr;

            	    if ( state.backtracking==0 ) {
            	          SimpleExpr.getBinaryAddingOperators().add(BinaryAddOp);
            	          SimpleExpr.getTerms().add(tm);
            	         }

            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return SimpleExpr;
    }
    // $ANTLR end "simple_expression"



    // $ANTLR start "term"
    // AadlBa.g:1929:1: term returns [Term tm] : fact= factor (MultiplyingOp= multiplying_operator fact= factor )* ;
    public final Term term() throws RecognitionException {
        Term tm = null;


        Factor fact =null;

        MultiplyingOperator MultiplyingOp =null;



           tm = _fact.createTerm();
         
        try {
            // AadlBa.g:1933:3: (fact= factor (MultiplyingOp= multiplying_operator fact= factor )* )
            // AadlBa.g:1934:4: fact= factor (MultiplyingOp= multiplying_operator fact= factor )*
            {
            pushFollow(FOLLOW_factor_in_term6334);
            fact=factor();

            state._fsp--;
            if (state.failed) return tm;

            if ( state.backtracking==0 ) { tm.getFactors().add(fact);
                 tm.setLocationReference(fact.getLocationReference());
               }

            // AadlBa.g:1938:4: (MultiplyingOp= multiplying_operator fact= factor )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==DIVIDE||LA60_0==MOD||LA60_0==REM||LA60_0==STAR) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // AadlBa.g:1939:6: MultiplyingOp= multiplying_operator fact= factor
            	    {
            	    pushFollow(FOLLOW_multiplying_operator_in_term6353);
            	    MultiplyingOp=multiplying_operator();

            	    state._fsp--;
            	    if (state.failed) return tm;

            	    pushFollow(FOLLOW_factor_in_term6357);
            	    fact=factor();

            	    state._fsp--;
            	    if (state.failed) return tm;

            	    if ( state.backtracking==0 ) {
            	          tm.getMultiplyingOperators().add(MultiplyingOp);
            	          tm.getFactors().add(fact);
            	         }

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return tm;
    }
    // $ANTLR end "term"



    // $ANTLR start "factor"
    // AadlBa.g:1957:1: factor returns [Factor Fact] : ( (val= value (BinaryNumOp= binary_numeric_operator val2= value )? ) | (UnaryNumOp= unary_numeric_operator val= value ) | (UnaryBoolOp= unary_boolean_operator val= value ) ) ;
    public final Factor factor() throws RecognitionException {
        Factor Fact = null;


        Value val =null;

        BinaryNumericOperator BinaryNumOp =null;

        Value val2 =null;

        UnaryNumericOperator UnaryNumOp =null;

        UnaryBooleanOperator UnaryBoolOp =null;



           Fact = _fact.createFactor();
         
        try {
            // AadlBa.g:1962:3: ( ( (val= value (BinaryNumOp= binary_numeric_operator val2= value )? ) | (UnaryNumOp= unary_numeric_operator val= value ) | (UnaryBoolOp= unary_boolean_operator val= value ) ) )
            // AadlBa.g:1963:4: ( (val= value (BinaryNumOp= binary_numeric_operator val2= value )? ) | (UnaryNumOp= unary_numeric_operator val= value ) | (UnaryBoolOp= unary_boolean_operator val= value ) )
            {
            // AadlBa.g:1963:4: ( (val= value (BinaryNumOp= binary_numeric_operator val2= value )? ) | (UnaryNumOp= unary_numeric_operator val= value ) | (UnaryBoolOp= unary_boolean_operator val= value ) )
            int alt62=3;
            switch ( input.LA(1) ) {
            case FALSE:
            case IDENT:
            case INTEGER_LIT:
            case LPAREN:
            case REAL_LIT:
            case STRING_LITERAL:
            case TRUE:
                {
                alt62=1;
                }
                break;
            case ABS:
                {
                alt62=2;
                }
                break;
            case NOT:
                {
                alt62=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return Fact;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;

            }

            switch (alt62) {
                case 1 :
                    // AadlBa.g:1964:5: (val= value (BinaryNumOp= binary_numeric_operator val2= value )? )
                    {
                    // AadlBa.g:1964:5: (val= value (BinaryNumOp= binary_numeric_operator val2= value )? )
                    // AadlBa.g:1964:7: val= value (BinaryNumOp= binary_numeric_operator val2= value )?
                    {
                    pushFollow(FOLLOW_value_in_factor6417);
                    val=value();

                    state._fsp--;
                    if (state.failed) return Fact;

                    if ( state.backtracking==0 ) {
                                      Fact.setLocationReference(val.getLocationReference()) ;
                                      Fact.setFirstValue(val);
                                    }

                    // AadlBa.g:1968:7: (BinaryNumOp= binary_numeric_operator val2= value )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==STARSTAR) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            // AadlBa.g:1969:9: BinaryNumOp= binary_numeric_operator val2= value
                            {
                            pushFollow(FOLLOW_binary_numeric_operator_in_factor6440);
                            BinaryNumOp=binary_numeric_operator();

                            state._fsp--;
                            if (state.failed) return Fact;

                            pushFollow(FOLLOW_value_in_factor6444);
                            val2=value();

                            state._fsp--;
                            if (state.failed) return Fact;

                            if ( state.backtracking==0 ) {
                                      Fact.setBinaryNumericOperator(BinaryNumOp);
                                      Fact.setSecondValue(val2);
                                    }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // AadlBa.g:1977:5: (UnaryNumOp= unary_numeric_operator val= value )
                    {
                    // AadlBa.g:1977:5: (UnaryNumOp= unary_numeric_operator val= value )
                    // AadlBa.g:1977:7: UnaryNumOp= unary_numeric_operator val= value
                    {
                    pushFollow(FOLLOW_unary_numeric_operator_in_factor6484);
                    UnaryNumOp=unary_numeric_operator();

                    state._fsp--;
                    if (state.failed) return Fact;

                    pushFollow(FOLLOW_value_in_factor6488);
                    val=value();

                    state._fsp--;
                    if (state.failed) return Fact;

                    if ( state.backtracking==0 ) {
                            Fact.setUnaryNumericOperator(UnaryNumOp);
                            Fact.setFirstValue(val);
                            Fact.setLocationReference(val.getLocationReference()) ;
                          }

                    }


                    }
                    break;
                case 3 :
                    // AadlBa.g:1985:5: (UnaryBoolOp= unary_boolean_operator val= value )
                    {
                    // AadlBa.g:1985:5: (UnaryBoolOp= unary_boolean_operator val= value )
                    // AadlBa.g:1985:7: UnaryBoolOp= unary_boolean_operator val= value
                    {
                    pushFollow(FOLLOW_unary_boolean_operator_in_factor6517);
                    UnaryBoolOp=unary_boolean_operator();

                    state._fsp--;
                    if (state.failed) return Fact;

                    pushFollow(FOLLOW_value_in_factor6521);
                    val=value();

                    state._fsp--;
                    if (state.failed) return Fact;

                    if ( state.backtracking==0 ) {
                            Fact.setUnaryBooleanOperator(UnaryBoolOp);
                            Fact.setFirstValue(val);
                            Fact.setLocationReference(val.getLocationReference()) ;
                          }

                    }


                    }
                    break;

            }


            }

        }
        catch (NoViableAltException ex) {

               reportError("unexpected value", null) ;

        }
        catch (NullPointerException ex) {

               reportError("unexpected value", null) ;

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return Fact;
    }
    // $ANTLR end "factor"



    // $ANTLR start "logical_operator"
    // AadlBa.g:2012:1: logical_operator returns [LogicalOperator LogicalOp] : (identifier_and= AND |identifier_or= OR |identifier_xor= XOR ) ;
    public final LogicalOperator logical_operator() throws RecognitionException {
        LogicalOperator LogicalOp = null;


        Token identifier_and=null;
        Token identifier_or=null;
        Token identifier_xor=null;


         // TODO location reference
           LogicalOp = null;
         
        try {
            // AadlBa.g:2017:3: ( (identifier_and= AND |identifier_or= OR |identifier_xor= XOR ) )
            // AadlBa.g:2018:4: (identifier_and= AND |identifier_or= OR |identifier_xor= XOR )
            {
            // AadlBa.g:2018:4: (identifier_and= AND |identifier_or= OR |identifier_xor= XOR )
            int alt63=3;
            switch ( input.LA(1) ) {
            case AND:
                {
                alt63=1;
                }
                break;
            case OR:
                {
                alt63=2;
                }
                break;
            case XOR:
                {
                alt63=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return LogicalOp;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;

            }

            switch (alt63) {
                case 1 :
                    // AadlBa.g:2019:6: identifier_and= AND
                    {
                    identifier_and=(Token)match(input,AND,FOLLOW_AND_in_logical_operator6595); if (state.failed) return LogicalOp;

                    if ( state.backtracking==0 ) { LogicalOp=LogicalOperator.AND; highlight(identifier_and, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}

                    }
                    break;
                case 2 :
                    // AadlBa.g:2021:6: identifier_or= OR
                    {
                    identifier_or=(Token)match(input,OR,FOLLOW_OR_in_logical_operator6611); if (state.failed) return LogicalOp;

                    if ( state.backtracking==0 ) { LogicalOp=LogicalOperator.OR; highlight(identifier_or, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}

                    }
                    break;
                case 3 :
                    // AadlBa.g:2023:6: identifier_xor= XOR
                    {
                    identifier_xor=(Token)match(input,XOR,FOLLOW_XOR_in_logical_operator6627); if (state.failed) return LogicalOp;

                    if ( state.backtracking==0 ) { LogicalOp=LogicalOperator.XOR; highlight(identifier_xor, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}

                    }
                    break;

            }


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return LogicalOp;
    }
    // $ANTLR end "logical_operator"



    // $ANTLR start "relational_operator"
    // AadlBa.g:2034:1: relational_operator returns [RelationalOperator RelationalOp] : ( EQUAL | NOTEQUAL | LESSTHAN | LESSOREQUAL | GREATERTHAN | GREATEROREQUAL ) ;
    public final RelationalOperator relational_operator() throws RecognitionException {
        RelationalOperator RelationalOp = null;



         // TODO location reference
           RelationalOp = null;
         
        try {
            // AadlBa.g:2039:3: ( ( EQUAL | NOTEQUAL | LESSTHAN | LESSOREQUAL | GREATERTHAN | GREATEROREQUAL ) )
            // AadlBa.g:2040:4: ( EQUAL | NOTEQUAL | LESSTHAN | LESSOREQUAL | GREATERTHAN | GREATEROREQUAL )
            {
            // AadlBa.g:2040:4: ( EQUAL | NOTEQUAL | LESSTHAN | LESSOREQUAL | GREATERTHAN | GREATEROREQUAL )
            int alt64=6;
            switch ( input.LA(1) ) {
            case EQUAL:
                {
                alt64=1;
                }
                break;
            case NOTEQUAL:
                {
                alt64=2;
                }
                break;
            case LESSTHAN:
                {
                alt64=3;
                }
                break;
            case LESSOREQUAL:
                {
                alt64=4;
                }
                break;
            case GREATERTHAN:
                {
                alt64=5;
                }
                break;
            case GREATEROREQUAL:
                {
                alt64=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return RelationalOp;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;

            }

            switch (alt64) {
                case 1 :
                    // AadlBa.g:2041:6: EQUAL
                    {
                    match(input,EQUAL,FOLLOW_EQUAL_in_relational_operator6672); if (state.failed) return RelationalOp;

                    if ( state.backtracking==0 ) { RelationalOp = RelationalOperator.EQUAL; }

                    }
                    break;
                case 2 :
                    // AadlBa.g:2043:6: NOTEQUAL
                    {
                    match(input,NOTEQUAL,FOLLOW_NOTEQUAL_in_relational_operator6686); if (state.failed) return RelationalOp;

                    if ( state.backtracking==0 ) { RelationalOp = RelationalOperator.NOT_EQUAL; }

                    }
                    break;
                case 3 :
                    // AadlBa.g:2045:6: LESSTHAN
                    {
                    match(input,LESSTHAN,FOLLOW_LESSTHAN_in_relational_operator6700); if (state.failed) return RelationalOp;

                    if ( state.backtracking==0 ) { RelationalOp = RelationalOperator.LESS_THAN; }

                    }
                    break;
                case 4 :
                    // AadlBa.g:2047:6: LESSOREQUAL
                    {
                    match(input,LESSOREQUAL,FOLLOW_LESSOREQUAL_in_relational_operator6714); if (state.failed) return RelationalOp;

                    if ( state.backtracking==0 ) { RelationalOp = RelationalOperator.LESS_OR_EQUAL_THAN; }

                    }
                    break;
                case 5 :
                    // AadlBa.g:2049:6: GREATERTHAN
                    {
                    match(input,GREATERTHAN,FOLLOW_GREATERTHAN_in_relational_operator6728); if (state.failed) return RelationalOp;

                    if ( state.backtracking==0 ) { RelationalOp = RelationalOperator.GREATER_THAN; }

                    }
                    break;
                case 6 :
                    // AadlBa.g:2051:6: GREATEROREQUAL
                    {
                    match(input,GREATEROREQUAL,FOLLOW_GREATEROREQUAL_in_relational_operator6742); if (state.failed) return RelationalOp;

                    if ( state.backtracking==0 ) { RelationalOp = RelationalOperator.GREATER_OR_EQUAL_THAN; }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return RelationalOp;
    }
    // $ANTLR end "relational_operator"



    // $ANTLR start "binary_adding_operator"
    // AadlBa.g:2062:1: binary_adding_operator returns [BinaryAddingOperator BinaryAddOp] : ( PLUS | MINUS ) ;
    public final BinaryAddingOperator binary_adding_operator() throws RecognitionException {
        BinaryAddingOperator BinaryAddOp = null;



         // TODO location reference
           //BinaryAddOp = _fact.createBinaryAddingOperator();
         
        try {
            // AadlBa.g:2067:3: ( ( PLUS | MINUS ) )
            // AadlBa.g:2068:4: ( PLUS | MINUS )
            {
            // AadlBa.g:2068:4: ( PLUS | MINUS )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==PLUS) ) {
                alt65=1;
            }
            else if ( (LA65_0==MINUS) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return BinaryAddOp;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;

            }
            switch (alt65) {
                case 1 :
                    // AadlBa.g:2069:6: PLUS
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_binary_adding_operator6789); if (state.failed) return BinaryAddOp;

                    if ( state.backtracking==0 ) { BinaryAddOp = BinaryAddingOperator.PLUS; }

                    }
                    break;
                case 2 :
                    // AadlBa.g:2071:6: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_binary_adding_operator6803); if (state.failed) return BinaryAddOp;

                    if ( state.backtracking==0 ) { BinaryAddOp = BinaryAddingOperator.MINUS; }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return BinaryAddOp;
    }
    // $ANTLR end "binary_adding_operator"



    // $ANTLR start "unary_adding_operator"
    // AadlBa.g:2082:1: unary_adding_operator returns [UnaryAddingOperator UnaryAddOp] : ( PLUS | MINUS ) ;
    public final UnaryAddingOperator unary_adding_operator() throws RecognitionException {
        UnaryAddingOperator UnaryAddOp = null;



         // TODO location reference
         
        try {
            // AadlBa.g:2086:3: ( ( PLUS | MINUS ) )
            // AadlBa.g:2087:4: ( PLUS | MINUS )
            {
            // AadlBa.g:2087:4: ( PLUS | MINUS )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==PLUS) ) {
                alt66=1;
            }
            else if ( (LA66_0==MINUS) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return UnaryAddOp;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;

            }
            switch (alt66) {
                case 1 :
                    // AadlBa.g:2088:6: PLUS
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_unary_adding_operator6848); if (state.failed) return UnaryAddOp;

                    if ( state.backtracking==0 ) { UnaryAddOp = UnaryAddingOperator.PLUS; }

                    }
                    break;
                case 2 :
                    // AadlBa.g:2090:6: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_unary_adding_operator6862); if (state.failed) return UnaryAddOp;

                    if ( state.backtracking==0 ) { UnaryAddOp = UnaryAddingOperator.MINUS; }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return UnaryAddOp;
    }
    // $ANTLR end "unary_adding_operator"



    // $ANTLR start "multiplying_operator"
    // AadlBa.g:2101:1: multiplying_operator returns [MultiplyingOperator MultiplyingOp] : ( STAR | DIVIDE |identifier_mod= MOD |identifier_rem= REM ) ;
    public final MultiplyingOperator multiplying_operator() throws RecognitionException {
        MultiplyingOperator MultiplyingOp = null;


        Token identifier_mod=null;
        Token identifier_rem=null;


         // TODO location reference
          // MultiplyingOperator MultiplyingOp = null;
         
        try {
            // AadlBa.g:2106:3: ( ( STAR | DIVIDE |identifier_mod= MOD |identifier_rem= REM ) )
            // AadlBa.g:2107:4: ( STAR | DIVIDE |identifier_mod= MOD |identifier_rem= REM )
            {
            // AadlBa.g:2107:4: ( STAR | DIVIDE |identifier_mod= MOD |identifier_rem= REM )
            int alt67=4;
            switch ( input.LA(1) ) {
            case STAR:
                {
                alt67=1;
                }
                break;
            case DIVIDE:
                {
                alt67=2;
                }
                break;
            case MOD:
                {
                alt67=3;
                }
                break;
            case REM:
                {
                alt67=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return MultiplyingOp;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;

            }

            switch (alt67) {
                case 1 :
                    // AadlBa.g:2108:6: STAR
                    {
                    match(input,STAR,FOLLOW_STAR_in_multiplying_operator6907); if (state.failed) return MultiplyingOp;

                    if ( state.backtracking==0 ) { MultiplyingOp = MultiplyingOperator.MULTIPLY; }

                    }
                    break;
                case 2 :
                    // AadlBa.g:2110:6: DIVIDE
                    {
                    match(input,DIVIDE,FOLLOW_DIVIDE_in_multiplying_operator6921); if (state.failed) return MultiplyingOp;

                    if ( state.backtracking==0 ) { MultiplyingOp = MultiplyingOperator.DIVIDE; }

                    }
                    break;
                case 3 :
                    // AadlBa.g:2112:6: identifier_mod= MOD
                    {
                    identifier_mod=(Token)match(input,MOD,FOLLOW_MOD_in_multiplying_operator6937); if (state.failed) return MultiplyingOp;

                    if ( state.backtracking==0 ) { MultiplyingOp = MultiplyingOperator.MOD; highlight(identifier_mod, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}

                    }
                    break;
                case 4 :
                    // AadlBa.g:2114:6: identifier_rem= REM
                    {
                    identifier_rem=(Token)match(input,REM,FOLLOW_REM_in_multiplying_operator6953); if (state.failed) return MultiplyingOp;

                    if ( state.backtracking==0 ) { MultiplyingOp = MultiplyingOperator.REM; highlight(identifier_rem, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}

                    }
                    break;

            }


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return MultiplyingOp;
    }
    // $ANTLR end "multiplying_operator"



    // $ANTLR start "binary_numeric_operator"
    // AadlBa.g:2125:1: binary_numeric_operator returns [BinaryNumericOperator BinaryNumOp] : STARSTAR ;
    public final BinaryNumericOperator binary_numeric_operator() throws RecognitionException {
        BinaryNumericOperator BinaryNumOp = null;



         // TODO location reference
           //BinaryNumericOperator BinaryNumOp = null;
         
        try {
            // AadlBa.g:2130:3: ( STARSTAR )
            // AadlBa.g:2131:4: STARSTAR
            {
            match(input,STARSTAR,FOLLOW_STARSTAR_in_binary_numeric_operator6991); if (state.failed) return BinaryNumOp;

            if ( state.backtracking==0 ) { BinaryNumOp = BinaryNumericOperator.MULTIPLY_MULTIPLY; }

            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return BinaryNumOp;
    }
    // $ANTLR end "binary_numeric_operator"



    // $ANTLR start "unary_numeric_operator"
    // AadlBa.g:2141:1: unary_numeric_operator returns [UnaryNumericOperator UnaryNumOp] : keyword_abs= ABS ;
    public final UnaryNumericOperator unary_numeric_operator() throws RecognitionException {
        UnaryNumericOperator UnaryNumOp = null;


        Token keyword_abs=null;


         // TODO location reference
           //UnaryNumericOperator UnaryNumOp = null;
         
        try {
            // AadlBa.g:2146:3: (keyword_abs= ABS )
            // AadlBa.g:2147:4: keyword_abs= ABS
            {
            keyword_abs=(Token)match(input,ABS,FOLLOW_ABS_in_unary_numeric_operator7026); if (state.failed) return UnaryNumOp;

            if ( state.backtracking==0 ) { UnaryNumOp = UnaryNumericOperator.ABS; highlight(keyword_abs, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}

            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return UnaryNumOp;
    }
    // $ANTLR end "unary_numeric_operator"



    // $ANTLR start "unary_boolean_operator"
    // AadlBa.g:2157:1: unary_boolean_operator returns [UnaryBooleanOperator UnaryBoolOp] : identifier_not= NOT ;
    public final UnaryBooleanOperator unary_boolean_operator() throws RecognitionException {
        UnaryBooleanOperator UnaryBoolOp = null;


        Token identifier_not=null;


         // TODO location reference
           //UnaryBooleanOperator UnaryBoolOp = null;
         
        try {
            // AadlBa.g:2162:3: (identifier_not= NOT )
            // AadlBa.g:2163:4: identifier_not= NOT
            {
            identifier_not=(Token)match(input,NOT,FOLLOW_NOT_in_unary_boolean_operator7061); if (state.failed) return UnaryBoolOp;

            if ( state.backtracking==0 ) { UnaryBoolOp = UnaryBooleanOperator.NOT; highlight(identifier_not, AnnexHighlighterPositionAcceptor.KEYWORD_ID);}

            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return UnaryBoolOp;
    }
    // $ANTLR end "unary_boolean_operator"



    // $ANTLR start "boolean_literal"
    // AadlBa.g:2172:1: boolean_literal returns [BehaviorBooleanLiteral BoolLit] : (identifier_true= TRUE |identifier_false= FALSE ) ;
    public final BehaviorBooleanLiteral boolean_literal() throws RecognitionException {
        BehaviorBooleanLiteral BoolLit = null;


        Token identifier_true=null;
        Token identifier_false=null;


           BoolLit = _fact.createBehaviorBooleanLiteral();
         
        try {
            // AadlBa.g:2176:3: ( (identifier_true= TRUE |identifier_false= FALSE ) )
            // AadlBa.g:2177:4: (identifier_true= TRUE |identifier_false= FALSE )
            {
            // AadlBa.g:2177:4: (identifier_true= TRUE |identifier_false= FALSE )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==TRUE) ) {
                alt68=1;
            }
            else if ( (LA68_0==FALSE) ) {
                alt68=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return BoolLit;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;

            }
            switch (alt68) {
                case 1 :
                    // AadlBa.g:2178:8: identifier_true= TRUE
                    {
                    identifier_true=(Token)match(input,TRUE,FOLLOW_TRUE_in_boolean_literal7104); if (state.failed) return BoolLit;

                    if ( state.backtracking==0 ) { BoolLit.setValue(true); highlight(identifier_true, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
                           setLocationReference(BoolLit, identifier_true) ;}

                    }
                    break;
                case 2 :
                    // AadlBa.g:2181:8: identifier_false= FALSE
                    {
                    identifier_false=(Token)match(input,FALSE,FOLLOW_FALSE_in_boolean_literal7124); if (state.failed) return BoolLit;

                    if ( state.backtracking==0 ) { BoolLit.setValue(false); highlight(identifier_false, AnnexHighlighterPositionAcceptor.KEYWORD_ID);
                           setLocationReference(BoolLit, identifier_false) ;}

                    }
                    break;

            }


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return BoolLit;
    }
    // $ANTLR end "boolean_literal"



    // $ANTLR start "integer_range"
    // AadlBa.g:2192:1: integer_range returns [IntegerRange IntRange] : (IntValue= integer_value DOTDOT IntValue2= integer_value ) ;
    public final IntegerRange integer_range() throws RecognitionException {
        IntegerRange IntRange = null;


        IntegerValue IntValue =null;

        IntegerValue IntValue2 =null;



           IntRange = _fact.createIntegerRange();
         
        try {
            // AadlBa.g:2196:3: ( (IntValue= integer_value DOTDOT IntValue2= integer_value ) )
            // AadlBa.g:2197:4: (IntValue= integer_value DOTDOT IntValue2= integer_value )
            {
            // AadlBa.g:2197:4: (IntValue= integer_value DOTDOT IntValue2= integer_value )
            // AadlBa.g:2198:6: IntValue= integer_value DOTDOT IntValue2= integer_value
            {
            pushFollow(FOLLOW_integer_value_in_integer_range7171);
            IntValue=integer_value();

            state._fsp--;
            if (state.failed) return IntRange;

            match(input,DOTDOT,FOLLOW_DOTDOT_in_integer_range7173); if (state.failed) return IntRange;

            pushFollow(FOLLOW_integer_value_in_integer_range7177);
            IntValue2=integer_value();

            state._fsp--;
            if (state.failed) return IntRange;

            if ( state.backtracking==0 ) {
                   IntRange.setLowerIntegerValue(IntValue);
                   IntRange.setUpperIntegerValue(IntValue2);
                   IntRange.setLocationReference(IntValue.getLocationReference());
                 }

            }


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return IntRange;
    }
    // $ANTLR end "integer_range"



    // $ANTLR start "integer_value"
    // AadlBa.g:2215:1: integer_value returns [IntegerValue IntVal] : (ValTmp= fact_value ) ;
    public final IntegerValue integer_value() throws RecognitionException {
        IntegerValue IntVal = null;


        Value ValTmp =null;



         
        try {
            // AadlBa.g:2218:3: ( (ValTmp= fact_value ) )
            // AadlBa.g:2220:4: (ValTmp= fact_value )
            {
            // AadlBa.g:2220:4: (ValTmp= fact_value )
            // AadlBa.g:2221:6: ValTmp= fact_value
            {
            pushFollow(FOLLOW_fact_value_in_integer_value7236);
            ValTmp=fact_value();

            state._fsp--;
            if (state.failed) return IntVal;

            if ( state.backtracking==0 ) { IntVal = (IntegerValue) ValTmp ;}

            }


            }

        }
        catch (RecognitionException ex) {

              throw ex ;

        }

        finally {
        	// do for sure before leaving
        }
        return IntVal;
    }
    // $ANTLR end "integer_value"



    // $ANTLR start "behavior_time"
    // AadlBa.g:2230:1: behavior_time returns [DeclarativeTime BehTime] : (IntValue= integer_value UnitIdent= IDENT ) ;
    public final DeclarativeTime behavior_time() throws RecognitionException {
        DeclarativeTime BehTime = null;


        Token UnitIdent=null;
        IntegerValue IntValue =null;



           BehTime = _decl.createDeclarativeTime() ;
         
        try {
            // AadlBa.g:2234:3: ( (IntValue= integer_value UnitIdent= IDENT ) )
            // AadlBa.g:2235:4: (IntValue= integer_value UnitIdent= IDENT )
            {
            // AadlBa.g:2235:4: (IntValue= integer_value UnitIdent= IDENT )
            // AadlBa.g:2236:6: IntValue= integer_value UnitIdent= IDENT
            {
            pushFollow(FOLLOW_integer_value_in_behavior_time7300);
            IntValue=integer_value();

            state._fsp--;
            if (state.failed) return BehTime;

            UnitIdent=(Token)match(input,IDENT,FOLLOW_IDENT_in_behavior_time7304); if (state.failed) return BehTime;

            if ( state.backtracking==0 ) {
                   BehTime.setIntegerValue(IntValue);
                   BehTime.setLocationReference(IntValue.getLocationReference());
                   
                   Identifier Id = _decl.createIdentifier() ;
                   Id.setId(UnitIdent.getText());
                   setLocationReference(Id, UnitIdent) ;
                   BehTime.setUnitId(Id);
                 }

            }


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return BehTime;
    }
    // $ANTLR end "behavior_time"



    // $ANTLR start "property"
    // AadlBa.g:2267:1: property returns [QualifiedNamedElement property] : ( (PropertySetId= IDENT DOUBLECOLON )? PropertyId= IDENT ) ;
    public final QualifiedNamedElement property() throws RecognitionException {
        QualifiedNamedElement property = null;


        Token PropertySetId=null;
        Token PropertyId=null;


           property = _decl.createQualifiedNamedElement();
         
        try {
            // AadlBa.g:2271:3: ( ( (PropertySetId= IDENT DOUBLECOLON )? PropertyId= IDENT ) )
            // AadlBa.g:2272:4: ( (PropertySetId= IDENT DOUBLECOLON )? PropertyId= IDENT )
            {
            // AadlBa.g:2272:4: ( (PropertySetId= IDENT DOUBLECOLON )? PropertyId= IDENT )
            // AadlBa.g:2273:6: (PropertySetId= IDENT DOUBLECOLON )? PropertyId= IDENT
            {
            // AadlBa.g:2273:6: (PropertySetId= IDENT DOUBLECOLON )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==IDENT) ) {
                int LA69_1 = input.LA(2);

                if ( (LA69_1==DOUBLECOLON) ) {
                    alt69=1;
                }
            }
            switch (alt69) {
                case 1 :
                    // AadlBa.g:2273:8: PropertySetId= IDENT DOUBLECOLON
                    {
                    PropertySetId=(Token)match(input,IDENT,FOLLOW_IDENT_in_property7369); if (state.failed) return property;

                    match(input,DOUBLECOLON,FOLLOW_DOUBLECOLON_in_property7371); if (state.failed) return property;

                    if ( state.backtracking==0 ) {
                             Identifier nameSpaceId = _decl.createIdentifier();
                             nameSpaceId.setId(PropertySetId.getText());
                             setLocationReference(nameSpaceId, PropertySetId); 
                             property.setBaNamespace(nameSpaceId);
                             setLocationReference(property, PropertySetId) ;
                           }

                    }
                    break;

            }


            PropertyId=(Token)match(input,IDENT,FOLLOW_IDENT_in_property7405); if (state.failed) return property;

            if ( state.backtracking==0 ) { 
                   Identifier nameId = _decl.createIdentifier();
                   nameId.setId(PropertyId.getText());
                   setLocationReference(nameId, PropertyId); 
                   property.setBaName(nameId);
                   
                   if (property.getLocationReference() == null )  
                   {
                     setLocationReference(property, PropertyId) ; 
                   }
                 }

            }


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return property;
    }
    // $ANTLR end "property"



    // $ANTLR start "behavior_enumeration_literal"
    // AadlBa.g:2307:1: behavior_enumeration_literal returns [Enumeration enumeration] : ( qualifiable_named_element[enumeration] HASH id2= IDENT ) ;
    public final Enumeration behavior_enumeration_literal() throws RecognitionException {
        Enumeration enumeration = null;


        Token id2=null;


                  enumeration = _decl.createEnumeration() ;
                
        try {
            // AadlBa.g:2311:3: ( ( qualifiable_named_element[enumeration] HASH id2= IDENT ) )
            // AadlBa.g:2312:3: ( qualifiable_named_element[enumeration] HASH id2= IDENT )
            {
            // AadlBa.g:2312:3: ( qualifiable_named_element[enumeration] HASH id2= IDENT )
            // AadlBa.g:2313:6: qualifiable_named_element[enumeration] HASH id2= IDENT
            {
            pushFollow(FOLLOW_qualifiable_named_element_in_behavior_enumeration_literal7458);
            qualifiable_named_element(enumeration);

            state._fsp--;
            if (state.failed) return enumeration;

            match(input,HASH,FOLLOW_HASH_in_behavior_enumeration_literal7472); if (state.failed) return enumeration;

            id2=(Token)match(input,IDENT,FOLLOW_IDENT_in_behavior_enumeration_literal7476); if (state.failed) return enumeration;

            if ( state.backtracking==0 ) {
                   Identifier lit = _decl.createIdentifier() ;
                   lit.setId(id2.getText());
                   setLocationReference(lit, id2) ;
                          
                   enumeration.setLiteral(lit);
                   // enumeration's location reference is already set, see
                   // qualifiable_named_element.       
                 }

            }


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return enumeration;
    }
    // $ANTLR end "behavior_enumeration_literal"



    // $ANTLR start "numeric_literal"
    // AadlBa.g:2335:1: numeric_literal returns [NumericLiteral nl] : (realval= REAL_LIT |intLit= integer_literal ) ;
    public final NumericLiteral numeric_literal() throws RecognitionException {
        NumericLiteral nl = null;


        Token realval=null;
        BehaviorIntegerLiteral intLit =null;


         
            nl=null;
            char sign = ' '; 
          
        try {
            // AadlBa.g:2340:3: ( (realval= REAL_LIT |intLit= integer_literal ) )
            // AadlBa.g:2341:3: (realval= REAL_LIT |intLit= integer_literal )
            {
            // AadlBa.g:2341:3: (realval= REAL_LIT |intLit= integer_literal )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==REAL_LIT) ) {
                alt70=1;
            }
            else if ( (LA70_0==INTEGER_LIT) ) {
                alt70=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return nl;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;

            }
            switch (alt70) {
                case 1 :
                    // AadlBa.g:2342:7: realval= REAL_LIT
                    {
                    realval=(Token)match(input,REAL_LIT,FOLLOW_REAL_LIT_in_numeric_literal7536); if (state.failed) return nl;

                    if ( state.backtracking==0 ) {
                            String str = realval.getText();
                            BehaviorRealLiteral tmp = _fact.createBehaviorRealLiteral();
                            str = str.replaceAll("_", "") ;
                            tmp.setValue(str);
                            setLocationReference(tmp, realval);
                            nl = tmp ;
                            highlight(realval, AnnexHighlighterPositionAcceptor.NUMBER_ID);
                          }

                    }
                    break;
                case 2 :
                    // AadlBa.g:2353:7: intLit= integer_literal
                    {
                    pushFollow(FOLLOW_integer_literal_in_numeric_literal7562);
                    intLit=integer_literal();

                    state._fsp--;
                    if (state.failed) return nl;

                    if ( state.backtracking==0 ) {
                            nl = intLit ;
                          }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return nl;
    }
    // $ANTLR end "numeric_literal"



    // $ANTLR start "integer_literal"
    // AadlBa.g:2365:1: integer_literal returns [BehaviorIntegerLiteral bil] : integerval= INTEGER_LIT ;
    public final BehaviorIntegerLiteral integer_literal() throws RecognitionException {
        BehaviorIntegerLiteral bil = null;


        Token integerval=null;

        try {
            // AadlBa.g:2367:2: (integerval= INTEGER_LIT )
            // AadlBa.g:2368:5: integerval= INTEGER_LIT
            {
            integerval=(Token)match(input,INTEGER_LIT,FOLLOW_INTEGER_LIT_in_integer_literal7602); if (state.failed) return bil;

            if ( state.backtracking==0 ) {
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
                      /*
                      int line = integerval.getLine() ;
                      int col = integerval.getCharPositionInLine() ; 
                      String fileName = this.getFilename() ;
                      RecognitionException ex = new RecognitionException() ;
                      ex.line = line ;
                      ex.charPositionInLine = col ;
                      ex.input = input ;
                      throw ex ;
                      */
                      reportError("integer literal bad format", integerval) ;
                      return null ;
                  }
                }

            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return bil;
    }
    // $ANTLR end "integer_literal"



    // $ANTLR start "string_literal"
    // AadlBa.g:2404:1: string_literal returns [BehaviorStringLiteral StringLit] : (sl= STRING_LITERAL ) ;
    public final BehaviorStringLiteral string_literal() throws RecognitionException {
        BehaviorStringLiteral StringLit = null;


        Token sl=null;


           StringLit = _fact.createBehaviorStringLiteral();
         
        try {
            // AadlBa.g:2408:3: ( (sl= STRING_LITERAL ) )
            // AadlBa.g:2409:4: (sl= STRING_LITERAL )
            {
            // AadlBa.g:2409:4: (sl= STRING_LITERAL )
            // AadlBa.g:2410:6: sl= STRING_LITERAL
            {
            sl=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_string_literal7648); if (state.failed) return StringLit;

            if ( state.backtracking==0 ) {
                    String str = sl.getText();
                    // stripout the quotes
                    str = str.substring(1,str.length()-1);
                    StringLit.setValue(str);
                    setLocationReference(StringLit, sl);
                    highlight(sl, AnnexHighlighterPositionAcceptor.STRING_ID);
                  }

            }


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return StringLit;
    }
    // $ANTLR end "string_literal"



    // $ANTLR start "numeral"
    // AadlBa.g:2429:1: numeral returns [Integer Num] : (NumVal= INTEGER_LIT ) ;
    public final Integer numeral() throws RecognitionException {
        Integer Num = null;


        Token NumVal=null;

        try {
            // AadlBa.g:2431:3: ( (NumVal= INTEGER_LIT ) )
            // AadlBa.g:2432:4: (NumVal= INTEGER_LIT )
            {
            // AadlBa.g:2432:4: (NumVal= INTEGER_LIT )
            // AadlBa.g:2433:6: NumVal= INTEGER_LIT
            {
            NumVal=(Token)match(input,INTEGER_LIT,FOLLOW_INTEGER_LIT_in_numeral7698); if (state.failed) return Num;

            if ( state.backtracking==0 ) { 
                   String tmp = NumVal.getText().replaceAll("_", "");
                   Num = Integer.parseInt(tmp) ;
                   highlight(NumVal, AnnexHighlighterPositionAcceptor.NUMBER_ID);
                 }

            }


            }

        }
        catch (RecognitionException ex) {

              reportError(ex);
              consumeUntil(input,SEMICOLON);
              input.consume();

        }

        finally {
        	// do for sure before leaving
        }
        return Num;
    }
    // $ANTLR end "numeral"

    // $ANTLR start synpred34_AadlBa
    public final void synpred34_AadlBa_fragment() throws RecognitionException {
        Token id=null;
        BehaviorAction BehAction2 =null;


        // AadlBa.g:1049:9: ( (id= SEMICOLON BehAction2= behavior_action )* )
        // AadlBa.g:1049:9: (id= SEMICOLON BehAction2= behavior_action )*
        {
        // AadlBa.g:1049:9: (id= SEMICOLON BehAction2= behavior_action )*
        loop77:
        do {
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==SEMICOLON) ) {
                alt77=1;
            }


            switch (alt77) {
        	case 1 :
        	    // AadlBa.g:1049:11: id= SEMICOLON BehAction2= behavior_action
        	    {
        	    id=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred34_AadlBa2940); if (state.failed) return ;

        	    pushFollow(FOLLOW_behavior_action_in_synpred34_AadlBa2944);
        	    BehAction2=behavior_action();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop77;
            }
        } while (true);


        }

    }
    // $ANTLR end synpred34_AadlBa

    // $ANTLR start synpred44_AadlBa
    public final void synpred44_AadlBa_fragment() throws RecognitionException {
        IntegerRange IntRange =null;


        // AadlBa.g:1278:6: ( (IntRange= integer_range ) )
        // AadlBa.g:1278:6: (IntRange= integer_range )
        {
        // AadlBa.g:1278:6: (IntRange= integer_range )
        // AadlBa.g:1278:8: IntRange= integer_range
        {
        pushFollow(FOLLOW_integer_range_in_synpred44_AadlBa3772);
        IntRange=integer_range();

        state._fsp--;
        if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred44_AadlBa

    // $ANTLR start synpred45_AadlBa
    public final void synpred45_AadlBa_fragment() throws RecognitionException {
        AssignmentAction AssAct =null;


        // AadlBa.g:1297:6: ( (AssAct= assignment_action ) )
        // AadlBa.g:1297:6: (AssAct= assignment_action )
        {
        // AadlBa.g:1297:6: (AssAct= assignment_action )
        // AadlBa.g:1297:8: AssAct= assignment_action
        {
        pushFollow(FOLLOW_assignment_action_in_synpred45_AadlBa3836);
        AssAct=assignment_action();

        state._fsp--;
        if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred45_AadlBa

    // $ANTLR start synpred46_AadlBa
    public final void synpred46_AadlBa_fragment() throws RecognitionException {
        CommAction CommAct =null;


        // AadlBa.g:1299:6: ( (CommAct= communication_action ) )
        // AadlBa.g:1299:6: (CommAct= communication_action )
        {
        // AadlBa.g:1299:6: (CommAct= communication_action )
        // AadlBa.g:1299:8: CommAct= communication_action
        {
        pushFollow(FOLLOW_communication_action_in_synpred46_AadlBa3856);
        CommAct=communication_action();

        state._fsp--;
        if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred46_AadlBa

    // Delegated rules

    public final boolean synpred44_AadlBa() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_AadlBa_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_AadlBa() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_AadlBa_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_AadlBa() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_AadlBa_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_AadlBa() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_AadlBa_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_VARIABLES_in_behavior_annex1177 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_behavior_variable_list_in_behavior_annex1192 = new BitSet(new long[]{0x0000100000000002L,0x0000000000042000L});
    public static final BitSet FOLLOW_STATES_in_behavior_annex1217 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_behavior_state_list_in_behavior_annex1232 = new BitSet(new long[]{0x0000100000000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_TRANSITIONS_in_behavior_annex1256 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_behavior_transition_in_behavior_annex1271 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_behavior_variable_in_behavior_variable_list1326 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_COMMA_in_behavior_variable_list1343 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_behavior_variable_in_behavior_variable_list1347 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_COLON_in_behavior_variable_list1370 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_unique_component_classifier_reference_in_behavior_variable_list1382 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_SEMICOLON_in_behavior_variable_list1392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_behavior_variable1428 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_behavior_variable1438 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_integer_value_constant_in_behavior_variable1442 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RBRACK_in_behavior_variable1444 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_IDENT_in_qualifiable_named_element1499 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_DOUBLECOLON_in_qualifiable_named_element1501 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENT_in_qualifiable_named_element1529 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_DOT_in_qualifiable_named_element1544 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENT_in_qualifiable_named_element1548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiable_named_element_in_unique_component_classifier_reference1604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_behavior_state_list1649 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_COMMA_in_behavior_state_list1665 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENT_in_behavior_state_list1669 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_COLON_in_behavior_state_list1689 = new BitSet(new long[]{0x0000800400001000L,0x0000000000001000L});
    public static final BitSet FOLLOW_INITIAL_in_behavior_state_list1705 = new BitSet(new long[]{0x0000000400001000L,0x0000000000001000L});
    public static final BitSet FOLLOW_COMPLETE_in_behavior_state_list1722 = new BitSet(new long[]{0x0000000400000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_FINAL_in_behavior_state_list1738 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_STATE_in_behavior_state_list1755 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_SEMICOLON_in_behavior_state_list1757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_behavior_transition1809 = new BitSet(new long[]{0x0008000000000400L});
    public static final BitSet FOLLOW_LBRACK_in_behavior_transition1827 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_numeral_in_behavior_transition1831 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RBRACK_in_behavior_transition1833 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_behavior_transition1846 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENT_in_behavior_transition1865 = new BitSet(new long[]{0x0200000000000800L});
    public static final BitSet FOLLOW_COMMA_in_behavior_transition1882 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENT_in_behavior_transition1886 = new BitSet(new long[]{0x0200000000000800L});
    public static final BitSet FOLLOW_LTRANS_in_behavior_transition1914 = new BitSet(new long[]{0x5501100200000010L,0x00000000000A8093L});
    public static final BitSet FOLLOW_behavior_condition_in_behavior_transition1918 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_RTRANS_in_behavior_transition1933 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENT_in_behavior_transition1950 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_behavior_action_block_in_behavior_transition1970 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_SEMICOLON_in_behavior_transition2001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURLY_in_behavior_action_block2031 = new BitSet(new long[]{0x0010301800082000L,0x0000000000400400L});
    public static final BitSet FOLLOW_behavior_actions_in_behavior_action_block2035 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RCURLY_in_behavior_action_block2037 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_TIMEOUT_in_behavior_action_block2061 = new BitSet(new long[]{0x0001100200000000L,0x0000000000088010L});
    public static final BitSet FOLLOW_behavior_time_in_behavior_action_block2065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ON_in_behavior_condition2123 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_dispatch_condition_in_behavior_condition2127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_execute_condition_in_behavior_condition2155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TIMEOUT_in_execute_condition2215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OTHERWISE_in_execute_condition2242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_value_expression_in_execute_condition2276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integer_literal_in_integer_value_constant2320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_property_in_integer_value_constant2342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISPATCH_in_dispatch_condition2395 = new BitSet(new long[]{0x0000104000000002L,0x0000000000024000L});
    public static final BitSet FOLLOW_dispatch_trigger_condition_in_dispatch_condition2405 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_FROZEN_in_dispatch_condition2431 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_reference_in_dispatch_condition2435 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_dispatch_condition2451 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_reference_in_dispatch_condition2455 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_STOP_in_dispatch_trigger_condition2557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TIMEOUT_in_dispatch_trigger_condition2586 = new BitSet(new long[]{0x0001100200000002L,0x0000000000088010L});
    public static final BitSet FOLLOW_behavior_time_in_dispatch_trigger_condition2628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dispatch_trigger_logical_expression_in_dispatch_trigger_condition2681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dispatch_conjunction_in_dispatch_trigger_logical_expression2727 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_OR_in_dispatch_trigger_logical_expression2752 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_dispatch_conjunction_in_dispatch_trigger_logical_expression2756 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_reference_in_dispatch_conjunction2815 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_AND_in_dispatch_conjunction2840 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_reference_in_dispatch_conjunction2844 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_behavior_action_in_behavior_actions2912 = new BitSet(new long[]{0x0000000000004002L,0x0000000000000100L});
    public static final BitSet FOLLOW_SEMICOLON_in_behavior_actions2940 = new BitSet(new long[]{0x0010301800082000L,0x0000000000400400L});
    public static final BitSet FOLLOW_behavior_action_in_behavior_actions2944 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_CONCAT_in_behavior_actions3002 = new BitSet(new long[]{0x0010301800082000L,0x0000000000400400L});
    public static final BitSet FOLLOW_behavior_action_in_behavior_actions3006 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_basic_action_in_behavior_action3116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_action_block_in_behavior_action3149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_behavior_action3187 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_action3191 = new BitSet(new long[]{0x1501100200000010L,0x0000000000088012L});
    public static final BitSet FOLLOW_value_expression_in_behavior_action3195 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_action3197 = new BitSet(new long[]{0x0010301800082000L,0x0000000000400400L});
    public static final BitSet FOLLOW_behavior_actions_in_behavior_action3201 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_ELSIF_in_behavior_action3234 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_action3238 = new BitSet(new long[]{0x1501100200000010L,0x0000000000088012L});
    public static final BitSet FOLLOW_value_expression_in_behavior_action3242 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_action3244 = new BitSet(new long[]{0x0010301800082000L,0x0000000000400400L});
    public static final BitSet FOLLOW_behavior_actions_in_behavior_action3248 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_ELSE_in_behavior_action3291 = new BitSet(new long[]{0x0010301800082000L,0x0000000000400400L});
    public static final BitSet FOLLOW_behavior_actions_in_behavior_action3295 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_END_in_behavior_action3327 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_IF_in_behavior_action3331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_behavior_action3369 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_action3371 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENT_in_behavior_action3385 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_behavior_action3396 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_unique_component_classifier_reference_in_behavior_action3400 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_IN_in_behavior_action3428 = new BitSet(new long[]{0x0001100200000000L,0x0000000000088010L});
    public static final BitSet FOLLOW_element_values_in_behavior_action3432 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_action3434 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_LCURLY_in_behavior_action3447 = new BitSet(new long[]{0x0010301800082000L,0x0000000000400400L});
    public static final BitSet FOLLOW_behavior_actions_in_behavior_action3451 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RCURLY_in_behavior_action3453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORALL_in_behavior_action3492 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_action3494 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENT_in_behavior_action3515 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_behavior_action3526 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_unique_component_classifier_reference_in_behavior_action3530 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_IN_in_behavior_action3557 = new BitSet(new long[]{0x0001100200000000L,0x0000000000088010L});
    public static final BitSet FOLLOW_element_values_in_behavior_action3561 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_action3563 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_LCURLY_in_behavior_action3576 = new BitSet(new long[]{0x0010301800082000L,0x0000000000400400L});
    public static final BitSet FOLLOW_behavior_actions_in_behavior_action3580 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RCURLY_in_behavior_action3582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_behavior_action3620 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_action3624 = new BitSet(new long[]{0x1501100200000010L,0x0000000000088012L});
    public static final BitSet FOLLOW_value_expression_in_behavior_action3628 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_action3630 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_LCURLY_in_behavior_action3640 = new BitSet(new long[]{0x0010301800082000L,0x0000000000400400L});
    public static final BitSet FOLLOW_behavior_actions_in_behavior_action3644 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RCURLY_in_behavior_action3646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DO_in_behavior_action3685 = new BitSet(new long[]{0x0010301800082000L,0x0000000000400400L});
    public static final BitSet FOLLOW_behavior_actions_in_behavior_action3689 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_UNTIL_in_behavior_action3691 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_action3704 = new BitSet(new long[]{0x1501100200000010L,0x0000000000088012L});
    public static final BitSet FOLLOW_value_expression_in_behavior_action3708 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_action3710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integer_range_in_element_values3772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_reference_in_element_values3792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_action_in_basic_action3836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_communication_action_in_basic_action3856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timed_action_in_basic_action3876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_target_in_assignment_action3920 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ASSIGN_in_assignment_action3922 = new BitSet(new long[]{0x1501100200000050L,0x0000000000088012L});
    public static final BitSet FOLLOW_value_expression_in_assignment_action3928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANY_in_assignment_action3934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_reference_in_target3974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_qualified_named_element4058 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_DOUBLECOLON_in_qualified_named_element4060 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENT_in_qualified_named_element4088 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_DOT_in_qualified_named_element4102 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENT_in_qualified_named_element4106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualified_named_element_in_communication_action4258 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_EXCLAM_in_communication_action4260 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_communication_action4293 = new BitSet(new long[]{0x1501100200000010L,0x0000000000088012L});
    public static final BitSet FOLLOW_subprogram_parameter_list_in_communication_action4297 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RPAREN_in_communication_action4299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_reference_in_communication_action4359 = new BitSet(new long[]{0x0002008070000000L});
    public static final BitSet FOLLOW_INTERROG_in_communication_action4409 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_communication_action4459 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_target_in_communication_action4463 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RPAREN_in_communication_action4465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GGREATER_in_communication_action4556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXCLLESS_in_communication_action4628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXCLGREATER_in_communication_action4700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXCLAM_in_communication_action4772 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_communication_action4807 = new BitSet(new long[]{0x1501100200000010L,0x0000000000088012L});
    public static final BitSet FOLLOW_subprogram_parameter_list_in_communication_action4811 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RPAREN_in_communication_action4813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_communication_action4906 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_EXCLLESS_in_communication_action4931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXCLGREATER_in_communication_action4972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMPUTATION_in_timed_action5049 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_timed_action5065 = new BitSet(new long[]{0x0001100200000000L,0x0000000000088010L});
    public static final BitSet FOLLOW_behavior_time_in_timed_action5074 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000040L});
    public static final BitSet FOLLOW_DOTDOT_in_timed_action5084 = new BitSet(new long[]{0x0001100200000000L,0x0000000000088010L});
    public static final BitSet FOLLOW_behavior_time_in_timed_action5088 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RPAREN_in_timed_action5104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_label_in_subprogram_parameter_list5139 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_subprogram_parameter_list5150 = new BitSet(new long[]{0x1501100200000010L,0x0000000000088012L});
    public static final BitSet FOLLOW_parameter_label_in_subprogram_parameter_list5154 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_value_expression_in_parameter_label5208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_identifier_in_reference5272 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_DOT_in_reference5292 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_array_identifier_in_reference5296 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_IDENT_in_array_identifier5345 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_array_identifier5365 = new BitSet(new long[]{0x0001100200000000L,0x0000000000088010L});
    public static final BitSet FOLLOW_integer_value_in_array_identifier5369 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RBRACK_in_array_identifier5371 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_IDENT_in_fact_value5494 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_DOUBLECOLON_in_fact_value5496 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENT_in_fact_value5500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_value_variable_in_fact_value5548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_literal_in_fact_value5570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numeric_literal_in_fact_value5590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_literal_in_fact_value5610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_enumeration_literal_in_fact_value5631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fact_value_in_value5692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_value5716 = new BitSet(new long[]{0x1501100200000010L,0x0000000000088012L});
    public static final BitSet FOLLOW_value_expression_in_value5720 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RPAREN_in_value5722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_reference_in_value_variable5799 = new BitSet(new long[]{0x0002000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_INTERROG_in_value_variable5829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TICK_in_value_variable5866 = new BitSet(new long[]{0x0000002000008000L});
    public static final BitSet FOLLOW_COUNT_in_value_variable5892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FRESH_in_value_variable5961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_in_value_expression6071 = new BitSet(new long[]{0x8000000000000022L,0x0000000001000000L});
    public static final BitSet FOLLOW_logical_operator_in_value_expression6096 = new BitSet(new long[]{0x1501100200000010L,0x0000000000088012L});
    public static final BitSet FOLLOW_relation_in_value_expression6100 = new BitSet(new long[]{0x8000000000000022L,0x0000000001000000L});
    public static final BitSet FOLLOW_simple_expression_in_relation6157 = new BitSet(new long[]{0x2060030004000002L});
    public static final BitSet FOLLOW_relational_operator_in_relation6176 = new BitSet(new long[]{0x1501100200000010L,0x0000000000088012L});
    public static final BitSet FOLLOW_simple_expression_in_relation6180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_adding_operator_in_simple_expression6235 = new BitSet(new long[]{0x1101100200000010L,0x0000000000088010L});
    public static final BitSet FOLLOW_term_in_simple_expression6260 = new BitSet(new long[]{0x0400000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_binary_adding_operator_in_simple_expression6283 = new BitSet(new long[]{0x1101100200000010L,0x0000000000088010L});
    public static final BitSet FOLLOW_term_in_simple_expression6287 = new BitSet(new long[]{0x0400000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_factor_in_term6334 = new BitSet(new long[]{0x0800000000040002L,0x0000000000000420L});
    public static final BitSet FOLLOW_multiplying_operator_in_term6353 = new BitSet(new long[]{0x1101100200000010L,0x0000000000088010L});
    public static final BitSet FOLLOW_factor_in_term6357 = new BitSet(new long[]{0x0800000000040002L,0x0000000000000420L});
    public static final BitSet FOLLOW_value_in_factor6417 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_binary_numeric_operator_in_factor6440 = new BitSet(new long[]{0x0101100200000000L,0x0000000000088010L});
    public static final BitSet FOLLOW_value_in_factor6444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_numeric_operator_in_factor6484 = new BitSet(new long[]{0x0101100200000000L,0x0000000000088010L});
    public static final BitSet FOLLOW_value_in_factor6488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_boolean_operator_in_factor6517 = new BitSet(new long[]{0x0101100200000000L,0x0000000000088010L});
    public static final BitSet FOLLOW_value_in_factor6521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_logical_operator6595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_logical_operator6611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_XOR_in_logical_operator6627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUAL_in_relational_operator6672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOTEQUAL_in_relational_operator6686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESSTHAN_in_relational_operator6700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESSOREQUAL_in_relational_operator6714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GREATERTHAN_in_relational_operator6728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GREATEROREQUAL_in_relational_operator6742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_binary_adding_operator6789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_binary_adding_operator6803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_unary_adding_operator6848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unary_adding_operator6862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_multiplying_operator6907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIVIDE_in_multiplying_operator6921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MOD_in_multiplying_operator6937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REM_in_multiplying_operator6953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STARSTAR_in_binary_numeric_operator6991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ABS_in_unary_numeric_operator7026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unary_boolean_operator7061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_boolean_literal7104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_boolean_literal7124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integer_value_in_integer_range7171 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_DOTDOT_in_integer_range7173 = new BitSet(new long[]{0x0001100200000000L,0x0000000000088010L});
    public static final BitSet FOLLOW_integer_value_in_integer_range7177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fact_value_in_integer_value7236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integer_value_in_behavior_time7300 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENT_in_behavior_time7304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_property7369 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_DOUBLECOLON_in_property7371 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENT_in_property7405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiable_named_element_in_behavior_enumeration_literal7458 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_HASH_in_behavior_enumeration_literal7472 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_IDENT_in_behavior_enumeration_literal7476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_LIT_in_numeric_literal7536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integer_literal_in_numeric_literal7562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_LIT_in_integer_literal7602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_string_literal7648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_LIT_in_numeral7698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred34_AadlBa2940 = new BitSet(new long[]{0x0010301800082000L,0x0000000000400400L});
    public static final BitSet FOLLOW_behavior_action_in_synpred34_AadlBa2944 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_integer_range_in_synpred44_AadlBa3772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_action_in_synpred45_AadlBa3836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_communication_action_in_synpred46_AadlBa3856 = new BitSet(new long[]{0x0000000000000002L});

}