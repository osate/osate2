package org.osate.expr.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.expr.services.ExprGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalExprParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Subcomponent", "Classifier", "Connection", "Subprogram", "Component", "Processor", "Reference", "Subclause", "Abstract", "Constant", "Applies", "Binding", "Compute", "Element", "Feature", "Library", "Process", "Virtual", "Assert", "Device", "Memory", "Record", "String", "KW_System", "Thread", "Delta", "Endif", "False", "Group", "Modes", "Tuple", "Union", "Bool", "Data", "Else", "Flow", "List", "Mode", "Real", "Root", "Then", "This", "True", "Type", "PlusSignEqualsSignGreaterThanSign", "QuestionMarkQuestionMarkQuestionMark", "And", "Bag", "Bus", "Def", "Div", "Int", "Map", "Mod", "Not", "Set", "Val", "Var", "ExclamationMarkEqualsSign", "AmpersandAmpersand", "HyphenMinusGreaterThanSign", "FullStopFullStop", "ColonColon", "LessThanSignEqualsSign", "EqualsSignEqualsSign", "EqualsSignGreaterThanSign", "GreaterThanSignLessThanSign", "GreaterThanSignEqualsSign", "If", "In", "Of", "Or", "To", "VerticalLineVerticalLine", "NumberSign", "PercentSign", "LeftParenthesis", "RightParenthesis", "Asterisk", "PlusSign", "Comma", "HyphenMinus", "FullStop", "Solidus", "Colon", "Semicolon", "LessThanSign", "EqualsSign", "GreaterThanSign", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_SL_COMMENT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_REAL_LIT", "RULE_BASED_INTEGER", "RULE_INTEGER_LIT", "RULE_EXTENDED_DIGIT", "RULE_STRING", "RULE_ID", "RULE_WS"
    };
    public static final int Val=60;
    public static final int Or=75;
    public static final int EqualsSignGreaterThanSign=69;
    public static final int Memory=24;
    public static final int KW_System=27;
    public static final int Var=61;
    public static final int String=26;
    public static final int False=31;
    public static final int Feature=18;
    public static final int LessThanSign=90;
    public static final int Assert=22;
    public static final int PlusSignEqualsSignGreaterThanSign=48;
    public static final int LeftParenthesis=80;
    public static final int Bool=36;
    public static final int Subcomponent=4;
    public static final int Then=44;
    public static final int GreaterThanSign=92;
    public static final int Root=43;
    public static final int RULE_ID=106;
    public static final int RULE_DIGIT=98;
    public static final int GreaterThanSignEqualsSign=71;
    public static final int ColonColon=66;
    public static final int EqualsSignEqualsSign=68;
    public static final int PlusSign=83;
    public static final int LeftSquareBracket=93;
    public static final int Map=56;
    public static final int If=72;
    public static final int Group=32;
    public static final int Processor=9;
    public static final int Set=59;
    public static final int In=73;
    public static final int VerticalLineVerticalLine=77;
    public static final int RULE_REAL_LIT=101;
    public static final int Classifier=5;
    public static final int GreaterThanSignLessThanSign=70;
    public static final int Union=35;
    public static final int Comma=84;
    public static final int HyphenMinus=85;
    public static final int LessThanSignEqualsSign=67;
    public static final int Solidus=87;
    public static final int RightCurlyBracket=96;
    public static final int Modes=33;
    public static final int Bus=52;
    public static final int FullStop=86;
    public static final int Reference=10;
    public static final int Abstract=12;
    public static final int Connection=6;
    public static final int Thread=28;
    public static final int Flow=39;
    public static final int Div=54;
    public static final int Semicolon=89;
    public static final int Type=47;
    public static final int RULE_EXPONENT=99;
    public static final int Delta=29;
    public static final int Else=38;
    public static final int RULE_EXTENDED_DIGIT=104;
    public static final int ExclamationMarkEqualsSign=62;
    public static final int HyphenMinusGreaterThanSign=64;
    public static final int Tuple=34;
    public static final int True=46;
    public static final int Process=20;
    public static final int RULE_INT_EXPONENT=100;
    public static final int PercentSign=79;
    public static final int FullStopFullStop=65;
    public static final int Real=42;
    public static final int QuestionMarkQuestionMarkQuestionMark=49;
    public static final int This=45;
    public static final int List=40;
    public static final int To=76;
    public static final int Applies=14;
    public static final int RULE_BASED_INTEGER=102;
    public static final int RightSquareBracket=94;
    public static final int Binding=15;
    public static final int Device=23;
    public static final int RightParenthesis=81;
    public static final int Not=58;
    public static final int And=50;
    public static final int NumberSign=78;
    public static final int Library=19;
    public static final int Subprogram=7;
    public static final int RULE_INTEGER_LIT=103;
    public static final int Subclause=11;
    public static final int Constant=13;
    public static final int Element=17;
    public static final int RULE_STRING=105;
    public static final int Int=55;
    public static final int RULE_SL_COMMENT=97;
    public static final int EqualsSign=91;
    public static final int AmpersandAmpersand=63;
    public static final int Record=25;
    public static final int Colon=88;
    public static final int Component=8;
    public static final int EOF=-1;
    public static final int Asterisk=82;
    public static final int Mod=57;
    public static final int Def=53;
    public static final int RULE_WS=107;
    public static final int Endif=30;
    public static final int Mode=41;
    public static final int LeftCurlyBracket=95;
    public static final int Bag=51;
    public static final int Virtual=21;
    public static final int Data=37;
    public static final int Compute=16;
    public static final int Of=74;

    // delegates
    // delegators


        public InternalExprParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalExprParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalExprParser.tokenNames; }
    public String getGrammarFileName() { return "InternalExprParser.g"; }




    	private ExprGrammarAccess grammarAccess;
    	 	
    	public InternalExprParser(TokenStream input, ExprGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "ExprModel";	
    	} 
    	   	   	
    	@Override
    	protected ExprGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRuleExprModel"
    // InternalExprParser.g:62:1: entryRuleExprModel returns [EObject current=null] : iv_ruleExprModel= ruleExprModel EOF ;
    public final EObject entryRuleExprModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExprModel = null;


        try {
            // InternalExprParser.g:63:2: (iv_ruleExprModel= ruleExprModel EOF )
            // InternalExprParser.g:64:2: iv_ruleExprModel= ruleExprModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExprModelRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExprModel=ruleExprModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExprModel; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExprModel"


    // $ANTLR start "ruleExprModel"
    // InternalExprParser.g:71:1: ruleExprModel returns [EObject current=null] : ( (otherlv_0= Library ( (lv_annex_1_0= ruleExprLibrary ) ) ) | (otherlv_2= Subclause ( (lv_annex_3_0= ruleExprSubclause ) ) ) ) ;
    public final EObject ruleExprModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_annex_1_0 = null;

        EObject lv_annex_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:74:28: ( ( (otherlv_0= Library ( (lv_annex_1_0= ruleExprLibrary ) ) ) | (otherlv_2= Subclause ( (lv_annex_3_0= ruleExprSubclause ) ) ) ) )
            // InternalExprParser.g:75:1: ( (otherlv_0= Library ( (lv_annex_1_0= ruleExprLibrary ) ) ) | (otherlv_2= Subclause ( (lv_annex_3_0= ruleExprSubclause ) ) ) )
            {
            // InternalExprParser.g:75:1: ( (otherlv_0= Library ( (lv_annex_1_0= ruleExprLibrary ) ) ) | (otherlv_2= Subclause ( (lv_annex_3_0= ruleExprSubclause ) ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==Library) ) {
                alt1=1;
            }
            else if ( (LA1_0==Subclause) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalExprParser.g:75:2: (otherlv_0= Library ( (lv_annex_1_0= ruleExprLibrary ) ) )
                    {
                    // InternalExprParser.g:75:2: (otherlv_0= Library ( (lv_annex_1_0= ruleExprLibrary ) ) )
                    // InternalExprParser.g:76:2: otherlv_0= Library ( (lv_annex_1_0= ruleExprLibrary ) )
                    {
                    otherlv_0=(Token)match(input,Library,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getExprModelAccess().getLibraryKeyword_0_0());
                          
                    }
                    // InternalExprParser.g:80:1: ( (lv_annex_1_0= ruleExprLibrary ) )
                    // InternalExprParser.g:81:1: (lv_annex_1_0= ruleExprLibrary )
                    {
                    // InternalExprParser.g:81:1: (lv_annex_1_0= ruleExprLibrary )
                    // InternalExprParser.g:82:3: lv_annex_1_0= ruleExprLibrary
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExprModelAccess().getAnnexExprLibraryParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_annex_1_0=ruleExprLibrary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExprModelRule());
                      	        }
                             		set(
                             			current, 
                             			"annex",
                              		lv_annex_1_0, 
                              		"org.osate.expr.Expr.ExprLibrary");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:99:6: (otherlv_2= Subclause ( (lv_annex_3_0= ruleExprSubclause ) ) )
                    {
                    // InternalExprParser.g:99:6: (otherlv_2= Subclause ( (lv_annex_3_0= ruleExprSubclause ) ) )
                    // InternalExprParser.g:100:2: otherlv_2= Subclause ( (lv_annex_3_0= ruleExprSubclause ) )
                    {
                    otherlv_2=(Token)match(input,Subclause,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getExprModelAccess().getSubclauseKeyword_1_0());
                          
                    }
                    // InternalExprParser.g:104:1: ( (lv_annex_3_0= ruleExprSubclause ) )
                    // InternalExprParser.g:105:1: (lv_annex_3_0= ruleExprSubclause )
                    {
                    // InternalExprParser.g:105:1: (lv_annex_3_0= ruleExprSubclause )
                    // InternalExprParser.g:106:3: lv_annex_3_0= ruleExprSubclause
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExprModelAccess().getAnnexExprSubclauseParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_annex_3_0=ruleExprSubclause();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExprModelRule());
                      	        }
                             		set(
                             			current, 
                             			"annex",
                              		lv_annex_3_0, 
                              		"org.osate.expr.Expr.ExprSubclause");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExprModel"


    // $ANTLR start "entryRuleExprLibrary"
    // InternalExprParser.g:130:1: entryRuleExprLibrary returns [EObject current=null] : iv_ruleExprLibrary= ruleExprLibrary EOF ;
    public final EObject entryRuleExprLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExprLibrary = null;


        try {
            // InternalExprParser.g:131:2: (iv_ruleExprLibrary= ruleExprLibrary EOF )
            // InternalExprParser.g:132:2: iv_ruleExprLibrary= ruleExprLibrary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExprLibraryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExprLibrary=ruleExprLibrary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExprLibrary; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExprLibrary"


    // $ANTLR start "ruleExprLibrary"
    // InternalExprParser.g:139:1: ruleExprLibrary returns [EObject current=null] : ( () (this_Declarations_1= ruleDeclarations[$current] )? ) ;
    public final EObject ruleExprLibrary() throws RecognitionException {
        EObject current = null;

        EObject this_Declarations_1 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:142:28: ( ( () (this_Declarations_1= ruleDeclarations[$current] )? ) )
            // InternalExprParser.g:143:1: ( () (this_Declarations_1= ruleDeclarations[$current] )? )
            {
            // InternalExprParser.g:143:1: ( () (this_Declarations_1= ruleDeclarations[$current] )? )
            // InternalExprParser.g:143:2: () (this_Declarations_1= ruleDeclarations[$current] )?
            {
            // InternalExprParser.g:143:2: ()
            // InternalExprParser.g:144:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getExprLibraryAccess().getExprLibraryAction_0(),
                          current);
                  
            }

            }

            // InternalExprParser.g:149:2: (this_Declarations_1= ruleDeclarations[$current] )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Assert||LA2_0==Type||LA2_0==Def||(LA2_0>=Val && LA2_0<=Var)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalExprParser.g:150:5: this_Declarations_1= ruleDeclarations[$current]
                    {
                    if ( state.backtracking==0 ) {
                       
                      		if (current==null) {
                      			current = createModelElement(grammarAccess.getExprLibraryRule());
                      		}
                              newCompositeNode(grammarAccess.getExprLibraryAccess().getDeclarationsParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Declarations_1=ruleDeclarations(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_Declarations_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExprLibrary"


    // $ANTLR start "entryRuleExprSubclause"
    // InternalExprParser.g:169:1: entryRuleExprSubclause returns [EObject current=null] : iv_ruleExprSubclause= ruleExprSubclause EOF ;
    public final EObject entryRuleExprSubclause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExprSubclause = null;


        try {
            // InternalExprParser.g:170:2: (iv_ruleExprSubclause= ruleExprSubclause EOF )
            // InternalExprParser.g:171:2: iv_ruleExprSubclause= ruleExprSubclause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExprSubclauseRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExprSubclause=ruleExprSubclause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExprSubclause; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExprSubclause"


    // $ANTLR start "ruleExprSubclause"
    // InternalExprParser.g:178:1: ruleExprSubclause returns [EObject current=null] : ( () (this_Declarations_1= ruleDeclarations[$current] )? ) ;
    public final EObject ruleExprSubclause() throws RecognitionException {
        EObject current = null;

        EObject this_Declarations_1 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:181:28: ( ( () (this_Declarations_1= ruleDeclarations[$current] )? ) )
            // InternalExprParser.g:182:1: ( () (this_Declarations_1= ruleDeclarations[$current] )? )
            {
            // InternalExprParser.g:182:1: ( () (this_Declarations_1= ruleDeclarations[$current] )? )
            // InternalExprParser.g:182:2: () (this_Declarations_1= ruleDeclarations[$current] )?
            {
            // InternalExprParser.g:182:2: ()
            // InternalExprParser.g:183:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getExprSubclauseAccess().getExprSubclauseAction_0(),
                          current);
                  
            }

            }

            // InternalExprParser.g:188:2: (this_Declarations_1= ruleDeclarations[$current] )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Assert||LA3_0==Type||LA3_0==Def||(LA3_0>=Val && LA3_0<=Var)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalExprParser.g:189:5: this_Declarations_1= ruleDeclarations[$current]
                    {
                    if ( state.backtracking==0 ) {
                       
                      		if (current==null) {
                      			current = createModelElement(grammarAccess.getExprSubclauseRule());
                      		}
                              newCompositeNode(grammarAccess.getExprSubclauseAccess().getDeclarationsParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Declarations_1=ruleDeclarations(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_Declarations_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExprSubclause"


    // $ANTLR start "ruleDeclarations"
    // InternalExprParser.g:211:1: ruleDeclarations[EObject in_current] returns [EObject current=in_current] : ( ( (lv_decls_0_0= ruleEDeclaration ) ) (otherlv_1= Semicolon ( (lv_decls_2_0= ruleEDeclaration ) ) )* (otherlv_3= Semicolon )? ) ;
    public final EObject ruleDeclarations(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decls_0_0 = null;

        EObject lv_decls_2_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:214:28: ( ( ( (lv_decls_0_0= ruleEDeclaration ) ) (otherlv_1= Semicolon ( (lv_decls_2_0= ruleEDeclaration ) ) )* (otherlv_3= Semicolon )? ) )
            // InternalExprParser.g:215:1: ( ( (lv_decls_0_0= ruleEDeclaration ) ) (otherlv_1= Semicolon ( (lv_decls_2_0= ruleEDeclaration ) ) )* (otherlv_3= Semicolon )? )
            {
            // InternalExprParser.g:215:1: ( ( (lv_decls_0_0= ruleEDeclaration ) ) (otherlv_1= Semicolon ( (lv_decls_2_0= ruleEDeclaration ) ) )* (otherlv_3= Semicolon )? )
            // InternalExprParser.g:215:2: ( (lv_decls_0_0= ruleEDeclaration ) ) (otherlv_1= Semicolon ( (lv_decls_2_0= ruleEDeclaration ) ) )* (otherlv_3= Semicolon )?
            {
            // InternalExprParser.g:215:2: ( (lv_decls_0_0= ruleEDeclaration ) )
            // InternalExprParser.g:216:1: (lv_decls_0_0= ruleEDeclaration )
            {
            // InternalExprParser.g:216:1: (lv_decls_0_0= ruleEDeclaration )
            // InternalExprParser.g:217:3: lv_decls_0_0= ruleEDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationsAccess().getDeclsEDeclarationParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_4);
            lv_decls_0_0=ruleEDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDeclarationsRule());
              	        }
                     		add(
                     			current, 
                     			"decls",
                      		lv_decls_0_0, 
                      		"org.osate.expr.Expr.EDeclaration");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalExprParser.g:233:2: (otherlv_1= Semicolon ( (lv_decls_2_0= ruleEDeclaration ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==Semicolon) ) {
                    int LA4_1 = input.LA(2);

                    if ( (LA4_1==Assert||LA4_1==Type||LA4_1==Def||(LA4_1>=Val && LA4_1<=Var)) ) {
                        alt4=1;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // InternalExprParser.g:234:2: otherlv_1= Semicolon ( (lv_decls_2_0= ruleEDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,Semicolon,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getDeclarationsAccess().getSemicolonKeyword_1_0());
            	          
            	    }
            	    // InternalExprParser.g:238:1: ( (lv_decls_2_0= ruleEDeclaration ) )
            	    // InternalExprParser.g:239:1: (lv_decls_2_0= ruleEDeclaration )
            	    {
            	    // InternalExprParser.g:239:1: (lv_decls_2_0= ruleEDeclaration )
            	    // InternalExprParser.g:240:3: lv_decls_2_0= ruleEDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclarationsAccess().getDeclsEDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_decls_2_0=ruleEDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getDeclarationsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"decls",
            	              		lv_decls_2_0, 
            	              		"org.osate.expr.Expr.EDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalExprParser.g:256:4: (otherlv_3= Semicolon )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Semicolon) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalExprParser.g:257:2: otherlv_3= Semicolon
                    {
                    otherlv_3=(Token)match(input,Semicolon,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getDeclarationsAccess().getSemicolonKeyword_2());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclarations"


    // $ANTLR start "entryRuleEDeclaration"
    // InternalExprParser.g:269:1: entryRuleEDeclaration returns [EObject current=null] : iv_ruleEDeclaration= ruleEDeclaration EOF ;
    public final EObject entryRuleEDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEDeclaration = null;


        try {
            // InternalExprParser.g:270:2: (iv_ruleEDeclaration= ruleEDeclaration EOF )
            // InternalExprParser.g:271:2: iv_ruleEDeclaration= ruleEDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEDeclaration=ruleEDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEDeclaration"


    // $ANTLR start "ruleEDeclaration"
    // InternalExprParser.g:278:1: ruleEDeclaration returns [EObject current=null] : (this_TypeDecl_0= ruleTypeDecl | this_VarDecl_1= ruleVarDecl | this_FunDecl_2= ruleFunDecl | this_Assertion_3= ruleAssertion ) ;
    public final EObject ruleEDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_TypeDecl_0 = null;

        EObject this_VarDecl_1 = null;

        EObject this_FunDecl_2 = null;

        EObject this_Assertion_3 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:281:28: ( (this_TypeDecl_0= ruleTypeDecl | this_VarDecl_1= ruleVarDecl | this_FunDecl_2= ruleFunDecl | this_Assertion_3= ruleAssertion ) )
            // InternalExprParser.g:282:1: (this_TypeDecl_0= ruleTypeDecl | this_VarDecl_1= ruleVarDecl | this_FunDecl_2= ruleFunDecl | this_Assertion_3= ruleAssertion )
            {
            // InternalExprParser.g:282:1: (this_TypeDecl_0= ruleTypeDecl | this_VarDecl_1= ruleVarDecl | this_FunDecl_2= ruleFunDecl | this_Assertion_3= ruleAssertion )
            int alt6=4;
            switch ( input.LA(1) ) {
            case Type:
                {
                alt6=1;
                }
                break;
            case Val:
            case Var:
                {
                alt6=2;
                }
                break;
            case Def:
                {
                alt6=3;
                }
                break;
            case Assert:
                {
                alt6=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalExprParser.g:283:5: this_TypeDecl_0= ruleTypeDecl
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEDeclarationAccess().getTypeDeclParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_TypeDecl_0=ruleTypeDecl();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_TypeDecl_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:293:5: this_VarDecl_1= ruleVarDecl
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEDeclarationAccess().getVarDeclParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_VarDecl_1=ruleVarDecl();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_VarDecl_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:303:5: this_FunDecl_2= ruleFunDecl
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEDeclarationAccess().getFunDeclParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_FunDecl_2=ruleFunDecl();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_FunDecl_2;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:313:5: this_Assertion_3= ruleAssertion
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEDeclarationAccess().getAssertionParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Assertion_3=ruleAssertion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_Assertion_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEDeclaration"


    // $ANTLR start "entryRuleTypeDecl"
    // InternalExprParser.g:329:1: entryRuleTypeDecl returns [EObject current=null] : iv_ruleTypeDecl= ruleTypeDecl EOF ;
    public final EObject entryRuleTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDecl = null;


        try {
            // InternalExprParser.g:330:2: (iv_ruleTypeDecl= ruleTypeDecl EOF )
            // InternalExprParser.g:331:2: iv_ruleTypeDecl= ruleTypeDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeDeclRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeDecl=ruleTypeDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeDecl; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeDecl"


    // $ANTLR start "ruleTypeDecl"
    // InternalExprParser.g:338:1: ruleTypeDecl returns [EObject current=null] : (otherlv_0= Type ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleType ) ) ) ;
    public final EObject ruleTypeDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:341:28: ( (otherlv_0= Type ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleType ) ) ) )
            // InternalExprParser.g:342:1: (otherlv_0= Type ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleType ) ) )
            {
            // InternalExprParser.g:342:1: (otherlv_0= Type ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleType ) ) )
            // InternalExprParser.g:343:2: otherlv_0= Type ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleType ) )
            {
            otherlv_0=(Token)match(input,Type,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypeDeclAccess().getTypeKeyword_0());
                  
            }
            // InternalExprParser.g:347:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalExprParser.g:348:1: (lv_name_1_0= RULE_ID )
            {
            // InternalExprParser.g:348:1: (lv_name_1_0= RULE_ID )
            // InternalExprParser.g:349:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getTypeDeclAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getTypeDeclRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getTypeDeclAccess().getColonKeyword_2());
                  
            }
            // InternalExprParser.g:370:1: ( (lv_type_3_0= ruleType ) )
            // InternalExprParser.g:371:1: (lv_type_3_0= ruleType )
            {
            // InternalExprParser.g:371:1: (lv_type_3_0= ruleType )
            // InternalExprParser.g:372:3: lv_type_3_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeDeclAccess().getTypeTypeParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_type_3_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypeDeclRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_3_0, 
                      		"org.osate.expr.Expr.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeDecl"


    // $ANTLR start "entryRuleVarDecl"
    // InternalExprParser.g:396:1: entryRuleVarDecl returns [EObject current=null] : iv_ruleVarDecl= ruleVarDecl EOF ;
    public final EObject entryRuleVarDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarDecl = null;


        try {
            // InternalExprParser.g:397:2: (iv_ruleVarDecl= ruleVarDecl EOF )
            // InternalExprParser.g:398:2: iv_ruleVarDecl= ruleVarDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarDeclRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVarDecl=ruleVarDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarDecl; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarDecl"


    // $ANTLR start "ruleVarDecl"
    // InternalExprParser.g:405:1: ruleVarDecl returns [EObject current=null] : ( ( ( (lv_const_0_0= Val ) ) | otherlv_1= Var ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_type_4_0= ruleType ) ) )? (otherlv_5= EqualsSign ( (lv_value_6_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVarDecl() throws RecognitionException {
        EObject current = null;

        Token lv_const_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_type_4_0 = null;

        EObject lv_value_6_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:408:28: ( ( ( ( (lv_const_0_0= Val ) ) | otherlv_1= Var ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_type_4_0= ruleType ) ) )? (otherlv_5= EqualsSign ( (lv_value_6_0= ruleExpression ) ) )? ) )
            // InternalExprParser.g:409:1: ( ( ( (lv_const_0_0= Val ) ) | otherlv_1= Var ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_type_4_0= ruleType ) ) )? (otherlv_5= EqualsSign ( (lv_value_6_0= ruleExpression ) ) )? )
            {
            // InternalExprParser.g:409:1: ( ( ( (lv_const_0_0= Val ) ) | otherlv_1= Var ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_type_4_0= ruleType ) ) )? (otherlv_5= EqualsSign ( (lv_value_6_0= ruleExpression ) ) )? )
            // InternalExprParser.g:409:2: ( ( (lv_const_0_0= Val ) ) | otherlv_1= Var ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_type_4_0= ruleType ) ) )? (otherlv_5= EqualsSign ( (lv_value_6_0= ruleExpression ) ) )?
            {
            // InternalExprParser.g:409:2: ( ( (lv_const_0_0= Val ) ) | otherlv_1= Var )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Val) ) {
                alt7=1;
            }
            else if ( (LA7_0==Var) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalExprParser.g:409:3: ( (lv_const_0_0= Val ) )
                    {
                    // InternalExprParser.g:409:3: ( (lv_const_0_0= Val ) )
                    // InternalExprParser.g:410:1: (lv_const_0_0= Val )
                    {
                    // InternalExprParser.g:410:1: (lv_const_0_0= Val )
                    // InternalExprParser.g:411:3: lv_const_0_0= Val
                    {
                    lv_const_0_0=(Token)match(input,Val,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_const_0_0, grammarAccess.getVarDeclAccess().getConstValKeyword_0_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getVarDeclRule());
                      	        }
                             		setWithLastConsumed(current, "const", true, "val");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:427:2: otherlv_1= Var
                    {
                    otherlv_1=(Token)match(input,Var,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getVarDeclAccess().getVarKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // InternalExprParser.g:431:2: ( (lv_name_2_0= RULE_ID ) )
            // InternalExprParser.g:432:1: (lv_name_2_0= RULE_ID )
            {
            // InternalExprParser.g:432:1: (lv_name_2_0= RULE_ID )
            // InternalExprParser.g:433:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getVarDeclAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getVarDeclRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ID");
              	    
            }

            }


            }

            // InternalExprParser.g:449:2: (otherlv_3= Colon ( (lv_type_4_0= ruleType ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==Colon) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalExprParser.g:450:2: otherlv_3= Colon ( (lv_type_4_0= ruleType ) )
                    {
                    otherlv_3=(Token)match(input,Colon,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getVarDeclAccess().getColonKeyword_2_0());
                          
                    }
                    // InternalExprParser.g:454:1: ( (lv_type_4_0= ruleType ) )
                    // InternalExprParser.g:455:1: (lv_type_4_0= ruleType )
                    {
                    // InternalExprParser.g:455:1: (lv_type_4_0= ruleType )
                    // InternalExprParser.g:456:3: lv_type_4_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVarDeclAccess().getTypeTypeParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_9);
                    lv_type_4_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVarDeclRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_4_0, 
                              		"org.osate.expr.Expr.Type");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalExprParser.g:472:4: (otherlv_5= EqualsSign ( (lv_value_6_0= ruleExpression ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==EqualsSign) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalExprParser.g:473:2: otherlv_5= EqualsSign ( (lv_value_6_0= ruleExpression ) )
                    {
                    otherlv_5=(Token)match(input,EqualsSign,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getVarDeclAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // InternalExprParser.g:477:1: ( (lv_value_6_0= ruleExpression ) )
                    // InternalExprParser.g:478:1: (lv_value_6_0= ruleExpression )
                    {
                    // InternalExprParser.g:478:1: (lv_value_6_0= ruleExpression )
                    // InternalExprParser.g:479:3: lv_value_6_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVarDeclAccess().getValueExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_6_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVarDeclRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_6_0, 
                              		"org.osate.expr.Expr.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarDecl"


    // $ANTLR start "entryRuleFunDecl"
    // InternalExprParser.g:503:1: entryRuleFunDecl returns [EObject current=null] : iv_ruleFunDecl= ruleFunDecl EOF ;
    public final EObject entryRuleFunDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunDecl = null;


        try {
            // InternalExprParser.g:504:2: (iv_ruleFunDecl= ruleFunDecl EOF )
            // InternalExprParser.g:505:2: iv_ruleFunDecl= ruleFunDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunDeclRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunDecl=ruleFunDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunDecl; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunDecl"


    // $ANTLR start "ruleFunDecl"
    // InternalExprParser.g:512:1: ruleFunDecl returns [EObject current=null] : (otherlv_0= Def ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesis otherlv_3= RightParenthesis ) ;
    public final EObject ruleFunDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:515:28: ( (otherlv_0= Def ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesis otherlv_3= RightParenthesis ) )
            // InternalExprParser.g:516:1: (otherlv_0= Def ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesis otherlv_3= RightParenthesis )
            {
            // InternalExprParser.g:516:1: (otherlv_0= Def ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesis otherlv_3= RightParenthesis )
            // InternalExprParser.g:517:2: otherlv_0= Def ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesis otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Def,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFunDeclAccess().getDefKeyword_0());
                  
            }
            // InternalExprParser.g:521:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalExprParser.g:522:1: (lv_name_1_0= RULE_ID )
            {
            // InternalExprParser.g:522:1: (lv_name_1_0= RULE_ID )
            // InternalExprParser.g:523:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getFunDeclAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFunDeclRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,LeftParenthesis,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFunDeclAccess().getLeftParenthesisKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFunDeclAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunDecl"


    // $ANTLR start "entryRuleAssertion"
    // InternalExprParser.g:557:1: entryRuleAssertion returns [EObject current=null] : iv_ruleAssertion= ruleAssertion EOF ;
    public final EObject entryRuleAssertion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssertion = null;


        try {
            // InternalExprParser.g:558:2: (iv_ruleAssertion= ruleAssertion EOF )
            // InternalExprParser.g:559:2: iv_ruleAssertion= ruleAssertion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssertionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssertion=ruleAssertion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssertion; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssertion"


    // $ANTLR start "ruleAssertion"
    // InternalExprParser.g:566:1: ruleAssertion returns [EObject current=null] : (otherlv_0= Assert ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_assert_3_0= ruleExpression ) ) ) ;
    public final EObject ruleAssertion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_assert_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:569:28: ( (otherlv_0= Assert ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_assert_3_0= ruleExpression ) ) ) )
            // InternalExprParser.g:570:1: (otherlv_0= Assert ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_assert_3_0= ruleExpression ) ) )
            {
            // InternalExprParser.g:570:1: (otherlv_0= Assert ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_assert_3_0= ruleExpression ) ) )
            // InternalExprParser.g:571:2: otherlv_0= Assert ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_assert_3_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,Assert,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAssertionAccess().getAssertKeyword_0());
                  
            }
            // InternalExprParser.g:575:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalExprParser.g:576:1: (lv_name_1_0= RULE_ID )
            {
            // InternalExprParser.g:576:1: (lv_name_1_0= RULE_ID )
            // InternalExprParser.g:577:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getAssertionAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAssertionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getAssertionAccess().getColonKeyword_2());
                  
            }
            // InternalExprParser.g:598:1: ( (lv_assert_3_0= ruleExpression ) )
            // InternalExprParser.g:599:1: (lv_assert_3_0= ruleExpression )
            {
            // InternalExprParser.g:599:1: (lv_assert_3_0= ruleExpression )
            // InternalExprParser.g:600:3: lv_assert_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssertionAccess().getAssertExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_assert_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAssertionRule());
              	        }
                     		set(
                     			current, 
                     			"assert",
                      		lv_assert_3_0, 
                      		"org.osate.expr.Expr.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssertion"


    // $ANTLR start "entryRuleType"
    // InternalExprParser.g:624:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalExprParser.g:625:2: (iv_ruleType= ruleType EOF )
            // InternalExprParser.g:626:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalExprParser.g:633:1: ruleType returns [EObject current=null] : (this_PrimitiveType_0= rulePrimitiveType | this_Category_1= ruleCategory | this_MetaClass_2= ruleMetaClass | this_ClassifierType_3= ruleClassifierType | this_RecordType_4= ruleRecordType | this_UnionType_5= ruleUnionType | this_TupleType_6= ruleTupleType | this_ListType_7= ruleListType | this_SetType_8= ruleSetType | this_BagType_9= ruleBagType | this_MapType_10= ruleMapType | this_TypeRef_11= ruleTypeRef ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveType_0 = null;

        EObject this_Category_1 = null;

        EObject this_MetaClass_2 = null;

        EObject this_ClassifierType_3 = null;

        EObject this_RecordType_4 = null;

        EObject this_UnionType_5 = null;

        EObject this_TupleType_6 = null;

        EObject this_ListType_7 = null;

        EObject this_SetType_8 = null;

        EObject this_BagType_9 = null;

        EObject this_MapType_10 = null;

        EObject this_TypeRef_11 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:636:28: ( (this_PrimitiveType_0= rulePrimitiveType | this_Category_1= ruleCategory | this_MetaClass_2= ruleMetaClass | this_ClassifierType_3= ruleClassifierType | this_RecordType_4= ruleRecordType | this_UnionType_5= ruleUnionType | this_TupleType_6= ruleTupleType | this_ListType_7= ruleListType | this_SetType_8= ruleSetType | this_BagType_9= ruleBagType | this_MapType_10= ruleMapType | this_TypeRef_11= ruleTypeRef ) )
            // InternalExprParser.g:637:1: (this_PrimitiveType_0= rulePrimitiveType | this_Category_1= ruleCategory | this_MetaClass_2= ruleMetaClass | this_ClassifierType_3= ruleClassifierType | this_RecordType_4= ruleRecordType | this_UnionType_5= ruleUnionType | this_TupleType_6= ruleTupleType | this_ListType_7= ruleListType | this_SetType_8= ruleSetType | this_BagType_9= ruleBagType | this_MapType_10= ruleMapType | this_TypeRef_11= ruleTypeRef )
            {
            // InternalExprParser.g:637:1: (this_PrimitiveType_0= rulePrimitiveType | this_Category_1= ruleCategory | this_MetaClass_2= ruleMetaClass | this_ClassifierType_3= ruleClassifierType | this_RecordType_4= ruleRecordType | this_UnionType_5= ruleUnionType | this_TupleType_6= ruleTupleType | this_ListType_7= ruleListType | this_SetType_8= ruleSetType | this_BagType_9= ruleBagType | this_MapType_10= ruleMapType | this_TypeRef_11= ruleTypeRef )
            int alt10=12;
            switch ( input.LA(1) ) {
            case String:
            case Bool:
            case Real:
            case Int:
                {
                alt10=1;
                }
                break;
            case Subprogram:
            case Processor:
            case Abstract:
            case Process:
            case Virtual:
            case Device:
            case Memory:
            case KW_System:
            case Thread:
            case Data:
            case Bus:
                {
                alt10=2;
                }
                break;
            case Subcomponent:
            case Connection:
            case Component:
            case Feature:
            case Flow:
            case Mode:
                {
                alt10=3;
                }
                break;
            case Classifier:
                {
                alt10=4;
                }
                break;
            case Record:
                {
                alt10=5;
                }
                break;
            case Union:
                {
                alt10=6;
                }
                break;
            case Tuple:
                {
                alt10=7;
                }
                break;
            case List:
                {
                alt10=8;
                }
                break;
            case Set:
                {
                alt10=9;
                }
                break;
            case Bag:
                {
                alt10=10;
                }
                break;
            case Map:
                {
                alt10=11;
                }
                break;
            case RULE_ID:
                {
                alt10=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalExprParser.g:638:5: this_PrimitiveType_0= rulePrimitiveType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAccess().getPrimitiveTypeParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_PrimitiveType_0=rulePrimitiveType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_PrimitiveType_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:648:5: this_Category_1= ruleCategory
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAccess().getCategoryParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Category_1=ruleCategory();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_Category_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:658:5: this_MetaClass_2= ruleMetaClass
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAccess().getMetaClassParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_MetaClass_2=ruleMetaClass();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_MetaClass_2;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:668:5: this_ClassifierType_3= ruleClassifierType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAccess().getClassifierTypeParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_ClassifierType_3=ruleClassifierType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ClassifierType_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalExprParser.g:678:5: this_RecordType_4= ruleRecordType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAccess().getRecordTypeParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_RecordType_4=ruleRecordType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_RecordType_4;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalExprParser.g:688:5: this_UnionType_5= ruleUnionType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAccess().getUnionTypeParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_UnionType_5=ruleUnionType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_UnionType_5;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalExprParser.g:698:5: this_TupleType_6= ruleTupleType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAccess().getTupleTypeParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_TupleType_6=ruleTupleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_TupleType_6;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalExprParser.g:708:5: this_ListType_7= ruleListType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAccess().getListTypeParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_ListType_7=ruleListType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ListType_7;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // InternalExprParser.g:718:5: this_SetType_8= ruleSetType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAccess().getSetTypeParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_SetType_8=ruleSetType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_SetType_8;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // InternalExprParser.g:728:5: this_BagType_9= ruleBagType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAccess().getBagTypeParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_BagType_9=ruleBagType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_BagType_9;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 11 :
                    // InternalExprParser.g:738:5: this_MapType_10= ruleMapType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAccess().getMapTypeParserRuleCall_10()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_MapType_10=ruleMapType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_MapType_10;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 12 :
                    // InternalExprParser.g:748:5: this_TypeRef_11= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAccess().getTypeRefParserRuleCall_11()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_TypeRef_11=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_TypeRef_11;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRulePrimitiveType"
    // InternalExprParser.g:764:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalExprParser.g:765:2: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalExprParser.g:766:2: iv_rulePrimitiveType= rulePrimitiveType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimitiveType=rulePrimitiveType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitiveType"


    // $ANTLR start "rulePrimitiveType"
    // InternalExprParser.g:773:1: rulePrimitiveType returns [EObject current=null] : ( ( () otherlv_1= Bool ) | ( () otherlv_3= Int ) | ( () otherlv_5= Real ) | ( () otherlv_7= String ) ) ;
    public final EObject rulePrimitiveType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:776:28: ( ( ( () otherlv_1= Bool ) | ( () otherlv_3= Int ) | ( () otherlv_5= Real ) | ( () otherlv_7= String ) ) )
            // InternalExprParser.g:777:1: ( ( () otherlv_1= Bool ) | ( () otherlv_3= Int ) | ( () otherlv_5= Real ) | ( () otherlv_7= String ) )
            {
            // InternalExprParser.g:777:1: ( ( () otherlv_1= Bool ) | ( () otherlv_3= Int ) | ( () otherlv_5= Real ) | ( () otherlv_7= String ) )
            int alt11=4;
            switch ( input.LA(1) ) {
            case Bool:
                {
                alt11=1;
                }
                break;
            case Int:
                {
                alt11=2;
                }
                break;
            case Real:
                {
                alt11=3;
                }
                break;
            case String:
                {
                alt11=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalExprParser.g:777:2: ( () otherlv_1= Bool )
                    {
                    // InternalExprParser.g:777:2: ( () otherlv_1= Bool )
                    // InternalExprParser.g:777:3: () otherlv_1= Bool
                    {
                    // InternalExprParser.g:777:3: ()
                    // InternalExprParser.g:778:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimitiveTypeAccess().getBooleanAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,Bool,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPrimitiveTypeAccess().getBoolKeyword_0_1());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:789:6: ( () otherlv_3= Int )
                    {
                    // InternalExprParser.g:789:6: ( () otherlv_3= Int )
                    // InternalExprParser.g:789:7: () otherlv_3= Int
                    {
                    // InternalExprParser.g:789:7: ()
                    // InternalExprParser.g:790:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimitiveTypeAccess().getIntegerAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_3=(Token)match(input,Int,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPrimitiveTypeAccess().getIntKeyword_1_1());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalExprParser.g:801:6: ( () otherlv_5= Real )
                    {
                    // InternalExprParser.g:801:6: ( () otherlv_5= Real )
                    // InternalExprParser.g:801:7: () otherlv_5= Real
                    {
                    // InternalExprParser.g:801:7: ()
                    // InternalExprParser.g:802:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimitiveTypeAccess().getRealAction_2_0(),
                                  current);
                          
                    }

                    }

                    otherlv_5=(Token)match(input,Real,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getPrimitiveTypeAccess().getRealKeyword_2_1());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalExprParser.g:813:6: ( () otherlv_7= String )
                    {
                    // InternalExprParser.g:813:6: ( () otherlv_7= String )
                    // InternalExprParser.g:813:7: () otherlv_7= String
                    {
                    // InternalExprParser.g:813:7: ()
                    // InternalExprParser.g:814:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimitiveTypeAccess().getStringAction_3_0(),
                                  current);
                          
                    }

                    }

                    otherlv_7=(Token)match(input,String,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getPrimitiveTypeAccess().getStringKeyword_3_1());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveType"


    // $ANTLR start "entryRuleCategory"
    // InternalExprParser.g:832:1: entryRuleCategory returns [EObject current=null] : iv_ruleCategory= ruleCategory EOF ;
    public final EObject entryRuleCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategory = null;


        try {
            // InternalExprParser.g:833:2: (iv_ruleCategory= ruleCategory EOF )
            // InternalExprParser.g:834:2: iv_ruleCategory= ruleCategory EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCategoryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCategory=ruleCategory();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCategory; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCategory"


    // $ANTLR start "ruleCategory"
    // InternalExprParser.g:841:1: ruleCategory returns [EObject current=null] : ( (lv_category_0_0= ruleComponentCategory ) ) ;
    public final EObject ruleCategory() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_category_0_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:844:28: ( ( (lv_category_0_0= ruleComponentCategory ) ) )
            // InternalExprParser.g:845:1: ( (lv_category_0_0= ruleComponentCategory ) )
            {
            // InternalExprParser.g:845:1: ( (lv_category_0_0= ruleComponentCategory ) )
            // InternalExprParser.g:846:1: (lv_category_0_0= ruleComponentCategory )
            {
            // InternalExprParser.g:846:1: (lv_category_0_0= ruleComponentCategory )
            // InternalExprParser.g:847:3: lv_category_0_0= ruleComponentCategory
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCategoryAccess().getCategoryComponentCategoryParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_category_0_0=ruleComponentCategory();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCategoryRule());
              	        }
                     		set(
                     			current, 
                     			"category",
                      		lv_category_0_0, 
                      		"org.osate.expr.Expr.ComponentCategory");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCategory"


    // $ANTLR start "entryRuleComponentCategory"
    // InternalExprParser.g:871:1: entryRuleComponentCategory returns [String current=null] : iv_ruleComponentCategory= ruleComponentCategory EOF ;
    public final String entryRuleComponentCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComponentCategory = null;


        try {
            // InternalExprParser.g:872:1: (iv_ruleComponentCategory= ruleComponentCategory EOF )
            // InternalExprParser.g:873:2: iv_ruleComponentCategory= ruleComponentCategory EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComponentCategoryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleComponentCategory=ruleComponentCategory();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComponentCategory.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponentCategory"


    // $ANTLR start "ruleComponentCategory"
    // InternalExprParser.g:880:1: ruleComponentCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Abstract | kw= Bus | kw= Data | kw= Device | kw= Memory | kw= Process | kw= Processor | kw= Subprogram | (kw= Subprogram kw= Group ) | kw= KW_System | (kw= Thread kw= Group ) | kw= Thread | (kw= Virtual kw= Bus ) | (kw= Virtual kw= Processor ) ) ;
    public final AntlrDatatypeRuleToken ruleComponentCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:884:6: ( (kw= Abstract | kw= Bus | kw= Data | kw= Device | kw= Memory | kw= Process | kw= Processor | kw= Subprogram | (kw= Subprogram kw= Group ) | kw= KW_System | (kw= Thread kw= Group ) | kw= Thread | (kw= Virtual kw= Bus ) | (kw= Virtual kw= Processor ) ) )
            // InternalExprParser.g:885:1: (kw= Abstract | kw= Bus | kw= Data | kw= Device | kw= Memory | kw= Process | kw= Processor | kw= Subprogram | (kw= Subprogram kw= Group ) | kw= KW_System | (kw= Thread kw= Group ) | kw= Thread | (kw= Virtual kw= Bus ) | (kw= Virtual kw= Processor ) )
            {
            // InternalExprParser.g:885:1: (kw= Abstract | kw= Bus | kw= Data | kw= Device | kw= Memory | kw= Process | kw= Processor | kw= Subprogram | (kw= Subprogram kw= Group ) | kw= KW_System | (kw= Thread kw= Group ) | kw= Thread | (kw= Virtual kw= Bus ) | (kw= Virtual kw= Processor ) )
            int alt12=14;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // InternalExprParser.g:886:2: kw= Abstract
                    {
                    kw=(Token)match(input,Abstract,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:893:2: kw= Bus
                    {
                    kw=(Token)match(input,Bus,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:900:2: kw= Data
                    {
                    kw=(Token)match(input,Data,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:907:2: kw= Device
                    {
                    kw=(Token)match(input,Device,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalExprParser.g:914:2: kw= Memory
                    {
                    kw=(Token)match(input,Memory,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalExprParser.g:921:2: kw= Process
                    {
                    kw=(Token)match(input,Process,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalExprParser.g:928:2: kw= Processor
                    {
                    kw=(Token)match(input,Processor,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalExprParser.g:935:2: kw= Subprogram
                    {
                    kw=(Token)match(input,Subprogram,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // InternalExprParser.g:941:6: (kw= Subprogram kw= Group )
                    {
                    // InternalExprParser.g:941:6: (kw= Subprogram kw= Group )
                    // InternalExprParser.g:942:2: kw= Subprogram kw= Group
                    {
                    kw=(Token)match(input,Subprogram,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
                          
                    }
                    kw=(Token)match(input,Group,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
                          
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalExprParser.g:955:2: kw= KW_System
                    {
                    kw=(Token)match(input,KW_System,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // InternalExprParser.g:961:6: (kw= Thread kw= Group )
                    {
                    // InternalExprParser.g:961:6: (kw= Thread kw= Group )
                    // InternalExprParser.g:962:2: kw= Thread kw= Group
                    {
                    kw=(Token)match(input,Thread,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); 
                          
                    }
                    kw=(Token)match(input,Group,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); 
                          
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalExprParser.g:975:2: kw= Thread
                    {
                    kw=(Token)match(input,Thread,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
                          
                    }

                    }
                    break;
                case 13 :
                    // InternalExprParser.g:981:6: (kw= Virtual kw= Bus )
                    {
                    // InternalExprParser.g:981:6: (kw= Virtual kw= Bus )
                    // InternalExprParser.g:982:2: kw= Virtual kw= Bus
                    {
                    kw=(Token)match(input,Virtual,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
                          
                    }
                    kw=(Token)match(input,Bus,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
                          
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalExprParser.g:994:6: (kw= Virtual kw= Processor )
                    {
                    // InternalExprParser.g:994:6: (kw= Virtual kw= Processor )
                    // InternalExprParser.g:995:2: kw= Virtual kw= Processor
                    {
                    kw=(Token)match(input,Virtual,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); 
                          
                    }
                    kw=(Token)match(input,Processor,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_13_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponentCategory"


    // $ANTLR start "entryRuleMetaClass"
    // InternalExprParser.g:1014:1: entryRuleMetaClass returns [EObject current=null] : iv_ruleMetaClass= ruleMetaClass EOF ;
    public final EObject entryRuleMetaClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMetaClass = null;


        try {
            // InternalExprParser.g:1015:2: (iv_ruleMetaClass= ruleMetaClass EOF )
            // InternalExprParser.g:1016:2: iv_ruleMetaClass= ruleMetaClass EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMetaClassRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMetaClass=ruleMetaClass();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMetaClass; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMetaClass"


    // $ANTLR start "ruleMetaClass"
    // InternalExprParser.g:1023:1: ruleMetaClass returns [EObject current=null] : ( (lv_class_0_0= ruleMetaClassEnum ) ) ;
    public final EObject ruleMetaClass() throws RecognitionException {
        EObject current = null;

        Enumerator lv_class_0_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1026:28: ( ( (lv_class_0_0= ruleMetaClassEnum ) ) )
            // InternalExprParser.g:1027:1: ( (lv_class_0_0= ruleMetaClassEnum ) )
            {
            // InternalExprParser.g:1027:1: ( (lv_class_0_0= ruleMetaClassEnum ) )
            // InternalExprParser.g:1028:1: (lv_class_0_0= ruleMetaClassEnum )
            {
            // InternalExprParser.g:1028:1: (lv_class_0_0= ruleMetaClassEnum )
            // InternalExprParser.g:1029:3: lv_class_0_0= ruleMetaClassEnum
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMetaClassAccess().getClassMetaClassEnumEnumRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_class_0_0=ruleMetaClassEnum();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMetaClassRule());
              	        }
                     		set(
                     			current, 
                     			"class",
                      		lv_class_0_0, 
                      		"org.osate.expr.Expr.MetaClassEnum");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMetaClass"


    // $ANTLR start "entryRuleClassifierType"
    // InternalExprParser.g:1053:1: entryRuleClassifierType returns [EObject current=null] : iv_ruleClassifierType= ruleClassifierType EOF ;
    public final EObject entryRuleClassifierType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassifierType = null;


        try {
            // InternalExprParser.g:1054:2: (iv_ruleClassifierType= ruleClassifierType EOF )
            // InternalExprParser.g:1055:2: iv_ruleClassifierType= ruleClassifierType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClassifierTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleClassifierType=ruleClassifierType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClassifierType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassifierType"


    // $ANTLR start "ruleClassifierType"
    // InternalExprParser.g:1062:1: ruleClassifierType returns [EObject current=null] : ( () otherlv_1= Classifier (otherlv_2= LeftParenthesis ( ( ruleQCREF ) ) otherlv_4= RightParenthesis )? ) ;
    public final EObject ruleClassifierType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:1065:28: ( ( () otherlv_1= Classifier (otherlv_2= LeftParenthesis ( ( ruleQCREF ) ) otherlv_4= RightParenthesis )? ) )
            // InternalExprParser.g:1066:1: ( () otherlv_1= Classifier (otherlv_2= LeftParenthesis ( ( ruleQCREF ) ) otherlv_4= RightParenthesis )? )
            {
            // InternalExprParser.g:1066:1: ( () otherlv_1= Classifier (otherlv_2= LeftParenthesis ( ( ruleQCREF ) ) otherlv_4= RightParenthesis )? )
            // InternalExprParser.g:1066:2: () otherlv_1= Classifier (otherlv_2= LeftParenthesis ( ( ruleQCREF ) ) otherlv_4= RightParenthesis )?
            {
            // InternalExprParser.g:1066:2: ()
            // InternalExprParser.g:1067:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getClassifierTypeAccess().getClassifierTypeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,Classifier,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getClassifierTypeAccess().getClassifierKeyword_1());
                  
            }
            // InternalExprParser.g:1077:1: (otherlv_2= LeftParenthesis ( ( ruleQCREF ) ) otherlv_4= RightParenthesis )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==LeftParenthesis) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalExprParser.g:1078:2: otherlv_2= LeftParenthesis ( ( ruleQCREF ) ) otherlv_4= RightParenthesis
                    {
                    otherlv_2=(Token)match(input,LeftParenthesis,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getClassifierTypeAccess().getLeftParenthesisKeyword_2_0());
                          
                    }
                    // InternalExprParser.g:1082:1: ( ( ruleQCREF ) )
                    // InternalExprParser.g:1083:1: ( ruleQCREF )
                    {
                    // InternalExprParser.g:1083:1: ( ruleQCREF )
                    // InternalExprParser.g:1084:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getClassifierTypeRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClassifierTypeAccess().getBaseClassifierCrossReference_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_12);
                    ruleQCREF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getClassifierTypeAccess().getRightParenthesisKeyword_2_2());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassifierType"


    // $ANTLR start "entryRuleRecordType"
    // InternalExprParser.g:1111:1: entryRuleRecordType returns [EObject current=null] : iv_ruleRecordType= ruleRecordType EOF ;
    public final EObject entryRuleRecordType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordType = null;


        try {
            // InternalExprParser.g:1112:2: (iv_ruleRecordType= ruleRecordType EOF )
            // InternalExprParser.g:1113:2: iv_ruleRecordType= ruleRecordType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRecordTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRecordType=ruleRecordType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRecordType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRecordType"


    // $ANTLR start "ruleRecordType"
    // InternalExprParser.g:1120:1: ruleRecordType returns [EObject current=null] : ( () otherlv_1= Record otherlv_2= LeftCurlyBracket ( (lv_field_3_0= ruleField ) )* otherlv_4= RightCurlyBracket ) ;
    public final EObject ruleRecordType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_field_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1123:28: ( ( () otherlv_1= Record otherlv_2= LeftCurlyBracket ( (lv_field_3_0= ruleField ) )* otherlv_4= RightCurlyBracket ) )
            // InternalExprParser.g:1124:1: ( () otherlv_1= Record otherlv_2= LeftCurlyBracket ( (lv_field_3_0= ruleField ) )* otherlv_4= RightCurlyBracket )
            {
            // InternalExprParser.g:1124:1: ( () otherlv_1= Record otherlv_2= LeftCurlyBracket ( (lv_field_3_0= ruleField ) )* otherlv_4= RightCurlyBracket )
            // InternalExprParser.g:1124:2: () otherlv_1= Record otherlv_2= LeftCurlyBracket ( (lv_field_3_0= ruleField ) )* otherlv_4= RightCurlyBracket
            {
            // InternalExprParser.g:1124:2: ()
            // InternalExprParser.g:1125:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRecordTypeAccess().getRecordTypeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,Record,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRecordTypeAccess().getRecordKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,LeftCurlyBracket,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRecordTypeAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // InternalExprParser.g:1140:1: ( (lv_field_3_0= ruleField ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalExprParser.g:1141:1: (lv_field_3_0= ruleField )
            	    {
            	    // InternalExprParser.g:1141:1: (lv_field_3_0= ruleField )
            	    // InternalExprParser.g:1142:3: lv_field_3_0= ruleField
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRecordTypeAccess().getFieldFieldParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_18);
            	    lv_field_3_0=ruleField();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRecordTypeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"field",
            	              		lv_field_3_0, 
            	              		"org.osate.expr.Expr.Field");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_4=(Token)match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getRecordTypeAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRecordType"


    // $ANTLR start "entryRuleField"
    // InternalExprParser.g:1171:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // InternalExprParser.g:1172:2: (iv_ruleField= ruleField EOF )
            // InternalExprParser.g:1173:2: iv_ruleField= ruleField EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFieldRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleField=ruleField();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleField; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleField"


    // $ANTLR start "ruleField"
    // InternalExprParser.g:1180:1: ruleField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= Semicolon ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1183:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= Semicolon ) )
            // InternalExprParser.g:1184:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= Semicolon )
            {
            // InternalExprParser.g:1184:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= Semicolon )
            // InternalExprParser.g:1184:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= Semicolon
            {
            // InternalExprParser.g:1184:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalExprParser.g:1185:1: (lv_name_0_0= RULE_ID )
            {
            // InternalExprParser.g:1185:1: (lv_name_0_0= RULE_ID )
            // InternalExprParser.g:1186:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFieldRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,Colon,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFieldAccess().getColonKeyword_1());
                  
            }
            // InternalExprParser.g:1207:1: ( (lv_type_2_0= ruleType ) )
            // InternalExprParser.g:1208:1: (lv_type_2_0= ruleType )
            {
            // InternalExprParser.g:1208:1: (lv_type_2_0= ruleType )
            // InternalExprParser.g:1209:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFieldAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_19);
            lv_type_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFieldRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_2_0, 
                      		"org.osate.expr.Expr.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,Semicolon,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFieldAccess().getSemicolonKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleField"


    // $ANTLR start "entryRuleUnionType"
    // InternalExprParser.g:1238:1: entryRuleUnionType returns [EObject current=null] : iv_ruleUnionType= ruleUnionType EOF ;
    public final EObject entryRuleUnionType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnionType = null;


        try {
            // InternalExprParser.g:1239:2: (iv_ruleUnionType= ruleUnionType EOF )
            // InternalExprParser.g:1240:2: iv_ruleUnionType= ruleUnionType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnionTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnionType=ruleUnionType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnionType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnionType"


    // $ANTLR start "ruleUnionType"
    // InternalExprParser.g:1247:1: ruleUnionType returns [EObject current=null] : ( () otherlv_1= Union otherlv_2= LeftCurlyBracket otherlv_3= QuestionMarkQuestionMarkQuestionMark otherlv_4= RightCurlyBracket ) ;
    public final EObject ruleUnionType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:1250:28: ( ( () otherlv_1= Union otherlv_2= LeftCurlyBracket otherlv_3= QuestionMarkQuestionMarkQuestionMark otherlv_4= RightCurlyBracket ) )
            // InternalExprParser.g:1251:1: ( () otherlv_1= Union otherlv_2= LeftCurlyBracket otherlv_3= QuestionMarkQuestionMarkQuestionMark otherlv_4= RightCurlyBracket )
            {
            // InternalExprParser.g:1251:1: ( () otherlv_1= Union otherlv_2= LeftCurlyBracket otherlv_3= QuestionMarkQuestionMarkQuestionMark otherlv_4= RightCurlyBracket )
            // InternalExprParser.g:1251:2: () otherlv_1= Union otherlv_2= LeftCurlyBracket otherlv_3= QuestionMarkQuestionMarkQuestionMark otherlv_4= RightCurlyBracket
            {
            // InternalExprParser.g:1251:2: ()
            // InternalExprParser.g:1252:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getUnionTypeAccess().getUnionTypeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,Union,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnionTypeAccess().getUnionKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,LeftCurlyBracket,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getUnionTypeAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,QuestionMarkQuestionMarkQuestionMark,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getUnionTypeAccess().getQuestionMarkQuestionMarkQuestionMarkKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getUnionTypeAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnionType"


    // $ANTLR start "entryRuleTupleType"
    // InternalExprParser.g:1285:1: entryRuleTupleType returns [EObject current=null] : iv_ruleTupleType= ruleTupleType EOF ;
    public final EObject entryRuleTupleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleType = null;


        try {
            // InternalExprParser.g:1286:2: (iv_ruleTupleType= ruleTupleType EOF )
            // InternalExprParser.g:1287:2: iv_ruleTupleType= ruleTupleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTupleType=ruleTupleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTupleType"


    // $ANTLR start "ruleTupleType"
    // InternalExprParser.g:1294:1: ruleTupleType returns [EObject current=null] : ( () otherlv_1= Tuple otherlv_2= LeftCurlyBracket ( (lv_field_3_0= ruleTupleField ) )* otherlv_4= RightCurlyBracket ) ;
    public final EObject ruleTupleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_field_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1297:28: ( ( () otherlv_1= Tuple otherlv_2= LeftCurlyBracket ( (lv_field_3_0= ruleTupleField ) )* otherlv_4= RightCurlyBracket ) )
            // InternalExprParser.g:1298:1: ( () otherlv_1= Tuple otherlv_2= LeftCurlyBracket ( (lv_field_3_0= ruleTupleField ) )* otherlv_4= RightCurlyBracket )
            {
            // InternalExprParser.g:1298:1: ( () otherlv_1= Tuple otherlv_2= LeftCurlyBracket ( (lv_field_3_0= ruleTupleField ) )* otherlv_4= RightCurlyBracket )
            // InternalExprParser.g:1298:2: () otherlv_1= Tuple otherlv_2= LeftCurlyBracket ( (lv_field_3_0= ruleTupleField ) )* otherlv_4= RightCurlyBracket
            {
            // InternalExprParser.g:1298:2: ()
            // InternalExprParser.g:1299:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getTupleTypeAccess().getTupleTypeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,Tuple,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTupleTypeAccess().getTupleKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,LeftCurlyBracket,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getTupleTypeAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // InternalExprParser.g:1314:1: ( (lv_field_3_0= ruleTupleField ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=Subcomponent && LA15_0<=Processor)||LA15_0==Abstract||LA15_0==Feature||(LA15_0>=Process && LA15_0<=Virtual)||(LA15_0>=Device && LA15_0<=Thread)||(LA15_0>=Tuple && LA15_0<=Data)||(LA15_0>=Flow && LA15_0<=Real)||(LA15_0>=Bag && LA15_0<=Bus)||(LA15_0>=Int && LA15_0<=Map)||LA15_0==Set||LA15_0==RULE_ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalExprParser.g:1315:1: (lv_field_3_0= ruleTupleField )
            	    {
            	    // InternalExprParser.g:1315:1: (lv_field_3_0= ruleTupleField )
            	    // InternalExprParser.g:1316:3: lv_field_3_0= ruleTupleField
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTupleTypeAccess().getFieldTupleFieldParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_22);
            	    lv_field_3_0=ruleTupleField();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTupleTypeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"field",
            	              		lv_field_3_0, 
            	              		"org.osate.expr.Expr.TupleField");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_4=(Token)match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getTupleTypeAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTupleType"


    // $ANTLR start "entryRuleTupleField"
    // InternalExprParser.g:1345:1: entryRuleTupleField returns [EObject current=null] : iv_ruleTupleField= ruleTupleField EOF ;
    public final EObject entryRuleTupleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleField = null;


        try {
            // InternalExprParser.g:1346:2: (iv_ruleTupleField= ruleTupleField EOF )
            // InternalExprParser.g:1347:2: iv_ruleTupleField= ruleTupleField EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleFieldRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTupleField=ruleTupleField();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleField; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTupleField"


    // $ANTLR start "ruleTupleField"
    // InternalExprParser.g:1354:1: ruleTupleField returns [EObject current=null] : ( () ( (lv_type_1_0= ruleType ) ) ) ;
    public final EObject ruleTupleField() throws RecognitionException {
        EObject current = null;

        EObject lv_type_1_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1357:28: ( ( () ( (lv_type_1_0= ruleType ) ) ) )
            // InternalExprParser.g:1358:1: ( () ( (lv_type_1_0= ruleType ) ) )
            {
            // InternalExprParser.g:1358:1: ( () ( (lv_type_1_0= ruleType ) ) )
            // InternalExprParser.g:1358:2: () ( (lv_type_1_0= ruleType ) )
            {
            // InternalExprParser.g:1358:2: ()
            // InternalExprParser.g:1359:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getTupleFieldAccess().getFieldAction_0(),
                          current);
                  
            }

            }

            // InternalExprParser.g:1364:2: ( (lv_type_1_0= ruleType ) )
            // InternalExprParser.g:1365:1: (lv_type_1_0= ruleType )
            {
            // InternalExprParser.g:1365:1: (lv_type_1_0= ruleType )
            // InternalExprParser.g:1366:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleFieldAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_type_1_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTupleFieldRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_1_0, 
                      		"org.osate.expr.Expr.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTupleField"


    // $ANTLR start "entryRuleListType"
    // InternalExprParser.g:1390:1: entryRuleListType returns [EObject current=null] : iv_ruleListType= ruleListType EOF ;
    public final EObject entryRuleListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListType = null;


        try {
            // InternalExprParser.g:1391:2: (iv_ruleListType= ruleListType EOF )
            // InternalExprParser.g:1392:2: iv_ruleListType= ruleListType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleListType=ruleListType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleListType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListType"


    // $ANTLR start "ruleListType"
    // InternalExprParser.g:1399:1: ruleListType returns [EObject current=null] : ( () otherlv_1= List otherlv_2= Of ( (lv_type_3_0= ruleType ) ) ) ;
    public final EObject ruleListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1402:28: ( ( () otherlv_1= List otherlv_2= Of ( (lv_type_3_0= ruleType ) ) ) )
            // InternalExprParser.g:1403:1: ( () otherlv_1= List otherlv_2= Of ( (lv_type_3_0= ruleType ) ) )
            {
            // InternalExprParser.g:1403:1: ( () otherlv_1= List otherlv_2= Of ( (lv_type_3_0= ruleType ) ) )
            // InternalExprParser.g:1403:2: () otherlv_1= List otherlv_2= Of ( (lv_type_3_0= ruleType ) )
            {
            // InternalExprParser.g:1403:2: ()
            // InternalExprParser.g:1404:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getListTypeAccess().getListTypeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,List,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getListTypeAccess().getListKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,Of,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getListTypeAccess().getOfKeyword_2());
                  
            }
            // InternalExprParser.g:1419:1: ( (lv_type_3_0= ruleType ) )
            // InternalExprParser.g:1420:1: (lv_type_3_0= ruleType )
            {
            // InternalExprParser.g:1420:1: (lv_type_3_0= ruleType )
            // InternalExprParser.g:1421:3: lv_type_3_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getListTypeAccess().getTypeTypeParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_type_3_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getListTypeRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_3_0, 
                      		"org.osate.expr.Expr.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleListType"


    // $ANTLR start "entryRuleSetType"
    // InternalExprParser.g:1445:1: entryRuleSetType returns [EObject current=null] : iv_ruleSetType= ruleSetType EOF ;
    public final EObject entryRuleSetType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetType = null;


        try {
            // InternalExprParser.g:1446:2: (iv_ruleSetType= ruleSetType EOF )
            // InternalExprParser.g:1447:2: iv_ruleSetType= ruleSetType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSetTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSetType=ruleSetType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetType"


    // $ANTLR start "ruleSetType"
    // InternalExprParser.g:1454:1: ruleSetType returns [EObject current=null] : (otherlv_0= Set otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) ;
    public final EObject ruleSetType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1457:28: ( (otherlv_0= Set otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) )
            // InternalExprParser.g:1458:1: (otherlv_0= Set otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            {
            // InternalExprParser.g:1458:1: (otherlv_0= Set otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            // InternalExprParser.g:1459:2: otherlv_0= Set otherlv_1= Of ( (lv_type_2_0= ruleType ) )
            {
            otherlv_0=(Token)match(input,Set,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSetTypeAccess().getSetKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,Of,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSetTypeAccess().getOfKeyword_1());
                  
            }
            // InternalExprParser.g:1468:1: ( (lv_type_2_0= ruleType ) )
            // InternalExprParser.g:1469:1: (lv_type_2_0= ruleType )
            {
            // InternalExprParser.g:1469:1: (lv_type_2_0= ruleType )
            // InternalExprParser.g:1470:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSetTypeAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_type_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSetTypeRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_2_0, 
                      		"org.osate.expr.Expr.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetType"


    // $ANTLR start "entryRuleBagType"
    // InternalExprParser.g:1494:1: entryRuleBagType returns [EObject current=null] : iv_ruleBagType= ruleBagType EOF ;
    public final EObject entryRuleBagType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBagType = null;


        try {
            // InternalExprParser.g:1495:2: (iv_ruleBagType= ruleBagType EOF )
            // InternalExprParser.g:1496:2: iv_ruleBagType= ruleBagType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBagTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBagType=ruleBagType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBagType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBagType"


    // $ANTLR start "ruleBagType"
    // InternalExprParser.g:1503:1: ruleBagType returns [EObject current=null] : (otherlv_0= Bag otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) ;
    public final EObject ruleBagType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1506:28: ( (otherlv_0= Bag otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) )
            // InternalExprParser.g:1507:1: (otherlv_0= Bag otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            {
            // InternalExprParser.g:1507:1: (otherlv_0= Bag otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            // InternalExprParser.g:1508:2: otherlv_0= Bag otherlv_1= Of ( (lv_type_2_0= ruleType ) )
            {
            otherlv_0=(Token)match(input,Bag,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getBagTypeAccess().getBagKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,Of,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getBagTypeAccess().getOfKeyword_1());
                  
            }
            // InternalExprParser.g:1517:1: ( (lv_type_2_0= ruleType ) )
            // InternalExprParser.g:1518:1: (lv_type_2_0= ruleType )
            {
            // InternalExprParser.g:1518:1: (lv_type_2_0= ruleType )
            // InternalExprParser.g:1519:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getBagTypeAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_type_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getBagTypeRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_2_0, 
                      		"org.osate.expr.Expr.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBagType"


    // $ANTLR start "entryRuleMapType"
    // InternalExprParser.g:1543:1: entryRuleMapType returns [EObject current=null] : iv_ruleMapType= ruleMapType EOF ;
    public final EObject entryRuleMapType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapType = null;


        try {
            // InternalExprParser.g:1544:2: (iv_ruleMapType= ruleMapType EOF )
            // InternalExprParser.g:1545:2: iv_ruleMapType= ruleMapType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMapType=ruleMapType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapType"


    // $ANTLR start "ruleMapType"
    // InternalExprParser.g:1552:1: ruleMapType returns [EObject current=null] : (otherlv_0= Map ( (lv_dom_1_0= ruleType ) ) otherlv_2= HyphenMinusGreaterThanSign ( (lv_img_3_0= ruleType ) ) ) ;
    public final EObject ruleMapType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_dom_1_0 = null;

        EObject lv_img_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1555:28: ( (otherlv_0= Map ( (lv_dom_1_0= ruleType ) ) otherlv_2= HyphenMinusGreaterThanSign ( (lv_img_3_0= ruleType ) ) ) )
            // InternalExprParser.g:1556:1: (otherlv_0= Map ( (lv_dom_1_0= ruleType ) ) otherlv_2= HyphenMinusGreaterThanSign ( (lv_img_3_0= ruleType ) ) )
            {
            // InternalExprParser.g:1556:1: (otherlv_0= Map ( (lv_dom_1_0= ruleType ) ) otherlv_2= HyphenMinusGreaterThanSign ( (lv_img_3_0= ruleType ) ) )
            // InternalExprParser.g:1557:2: otherlv_0= Map ( (lv_dom_1_0= ruleType ) ) otherlv_2= HyphenMinusGreaterThanSign ( (lv_img_3_0= ruleType ) )
            {
            otherlv_0=(Token)match(input,Map,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMapTypeAccess().getMapKeyword_0());
                  
            }
            // InternalExprParser.g:1561:1: ( (lv_dom_1_0= ruleType ) )
            // InternalExprParser.g:1562:1: (lv_dom_1_0= ruleType )
            {
            // InternalExprParser.g:1562:1: (lv_dom_1_0= ruleType )
            // InternalExprParser.g:1563:3: lv_dom_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapTypeAccess().getDomTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_24);
            lv_dom_1_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMapTypeRule());
              	        }
                     		set(
                     			current, 
                     			"dom",
                      		lv_dom_1_0, 
                      		"org.osate.expr.Expr.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,HyphenMinusGreaterThanSign,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMapTypeAccess().getHyphenMinusGreaterThanSignKeyword_2());
                  
            }
            // InternalExprParser.g:1584:1: ( (lv_img_3_0= ruleType ) )
            // InternalExprParser.g:1585:1: (lv_img_3_0= ruleType )
            {
            // InternalExprParser.g:1585:1: (lv_img_3_0= ruleType )
            // InternalExprParser.g:1586:3: lv_img_3_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapTypeAccess().getImgTypeParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_img_3_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMapTypeRule());
              	        }
                     		set(
                     			current, 
                     			"img",
                      		lv_img_3_0, 
                      		"org.osate.expr.Expr.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapType"


    // $ANTLR start "entryRuleTypeRef"
    // InternalExprParser.g:1610:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // InternalExprParser.g:1611:2: (iv_ruleTypeRef= ruleTypeRef EOF )
            // InternalExprParser.g:1612:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeRef=ruleTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // InternalExprParser.g:1619:1: ruleTypeRef returns [EObject current=null] : ( ( ruleQCREF ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:1622:28: ( ( ( ruleQCREF ) ) )
            // InternalExprParser.g:1623:1: ( ( ruleQCREF ) )
            {
            // InternalExprParser.g:1623:1: ( ( ruleQCREF ) )
            // InternalExprParser.g:1624:1: ( ruleQCREF )
            {
            // InternalExprParser.g:1624:1: ( ruleQCREF )
            // InternalExprParser.g:1625:3: ruleQCREF
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getTypeRefRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeRefAccess().getRefTypeDeclCrossReference_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleExpression"
    // InternalExprParser.g:1647:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalExprParser.g:1648:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalExprParser.g:1649:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalExprParser.g:1656:1: ruleExpression returns [EObject current=null] : this_OrExpression_0= ruleOrExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpression_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1659:28: (this_OrExpression_0= ruleOrExpression )
            // InternalExprParser.g:1661:5: this_OrExpression_0= ruleOrExpression
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExpressionAccess().getOrExpressionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_2);
            this_OrExpression_0=ruleOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_OrExpression_0;
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleOrExpression"
    // InternalExprParser.g:1677:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // InternalExprParser.g:1678:2: (iv_ruleOrExpression= ruleOrExpression EOF )
            // InternalExprParser.g:1679:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOrExpression=ruleOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // InternalExprParser.g:1686:1: ruleOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AndExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1689:28: ( (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // InternalExprParser.g:1690:1: (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // InternalExprParser.g:1690:1: (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // InternalExprParser.g:1691:5: this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_25);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_AndExpression_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalExprParser.g:1699:1: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==Or) && (synpred1_InternalExprParser())) {
                    alt16=1;
                }
                else if ( (LA16_0==VerticalLineVerticalLine) && (synpred1_InternalExprParser())) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalExprParser.g:1699:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // InternalExprParser.g:1699:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) )
            	    // InternalExprParser.g:1699:3: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) )
            	    {
            	    // InternalExprParser.g:1704:6: ( () ( (lv_operator_2_0= ruleOpOr ) ) )
            	    // InternalExprParser.g:1704:7: () ( (lv_operator_2_0= ruleOpOr ) )
            	    {
            	    // InternalExprParser.g:1704:7: ()
            	    // InternalExprParser.g:1705:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getOrExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalExprParser.g:1710:2: ( (lv_operator_2_0= ruleOpOr ) )
            	    // InternalExprParser.g:1711:1: (lv_operator_2_0= ruleOpOr )
            	    {
            	    // InternalExprParser.g:1711:1: (lv_operator_2_0= ruleOpOr )
            	    // InternalExprParser.g:1712:3: lv_operator_2_0= ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrExpressionAccess().getOperatorOpOrParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_operator_2_0=ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"org.osate.expr.Expr.OpOr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalExprParser.g:1728:4: ( (lv_right_3_0= ruleAndExpression ) )
            	    // InternalExprParser.g:1729:1: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // InternalExprParser.g:1729:1: (lv_right_3_0= ruleAndExpression )
            	    // InternalExprParser.g:1730:3: lv_right_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_25);
            	    lv_right_3_0=ruleAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"org.osate.expr.Expr.AndExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // InternalExprParser.g:1754:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // InternalExprParser.g:1755:1: (iv_ruleOpOr= ruleOpOr EOF )
            // InternalExprParser.g:1756:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpOr"


    // $ANTLR start "ruleOpOr"
    // InternalExprParser.g:1763:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Or | kw= VerticalLineVerticalLine ) ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:1767:6: ( (kw= Or | kw= VerticalLineVerticalLine ) )
            // InternalExprParser.g:1768:1: (kw= Or | kw= VerticalLineVerticalLine )
            {
            // InternalExprParser.g:1768:1: (kw= Or | kw= VerticalLineVerticalLine )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==Or) ) {
                alt17=1;
            }
            else if ( (LA17_0==VerticalLineVerticalLine) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalExprParser.g:1769:2: kw= Or
                    {
                    kw=(Token)match(input,Or,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOrAccess().getOrKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:1776:2: kw= VerticalLineVerticalLine
                    {
                    kw=(Token)match(input,VerticalLineVerticalLine,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRuleAndExpression"
    // InternalExprParser.g:1789:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalExprParser.g:1790:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalExprParser.g:1791:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalExprParser.g:1798:1: ruleAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EqualityExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1801:28: ( (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) )
            // InternalExprParser.g:1802:1: (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            {
            // InternalExprParser.g:1802:1: (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            // InternalExprParser.g:1803:5: this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndExpressionAccess().getEqualityExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_26);
            this_EqualityExpression_0=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_EqualityExpression_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalExprParser.g:1811:1: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==And) && (synpred2_InternalExprParser())) {
                    alt18=1;
                }
                else if ( (LA18_0==AmpersandAmpersand) && (synpred2_InternalExprParser())) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalExprParser.g:1811:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) )
            	    {
            	    // InternalExprParser.g:1811:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) )
            	    // InternalExprParser.g:1811:3: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) )
            	    {
            	    // InternalExprParser.g:1816:6: ( () ( (lv_operator_2_0= ruleOpAnd ) ) )
            	    // InternalExprParser.g:1816:7: () ( (lv_operator_2_0= ruleOpAnd ) )
            	    {
            	    // InternalExprParser.g:1816:7: ()
            	    // InternalExprParser.g:1817:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAndExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalExprParser.g:1822:2: ( (lv_operator_2_0= ruleOpAnd ) )
            	    // InternalExprParser.g:1823:1: (lv_operator_2_0= ruleOpAnd )
            	    {
            	    // InternalExprParser.g:1823:1: (lv_operator_2_0= ruleOpAnd )
            	    // InternalExprParser.g:1824:3: lv_operator_2_0= ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndExpressionAccess().getOperatorOpAndParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_operator_2_0=ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"org.osate.expr.Expr.OpAnd");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalExprParser.g:1840:4: ( (lv_right_3_0= ruleEqualityExpression ) )
            	    // InternalExprParser.g:1841:1: (lv_right_3_0= ruleEqualityExpression )
            	    {
            	    // InternalExprParser.g:1841:1: (lv_right_3_0= ruleEqualityExpression )
            	    // InternalExprParser.g:1842:3: lv_right_3_0= ruleEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndExpressionAccess().getRightEqualityExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_26);
            	    lv_right_3_0=ruleEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"org.osate.expr.Expr.EqualityExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // InternalExprParser.g:1866:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // InternalExprParser.g:1867:1: (iv_ruleOpAnd= ruleOpAnd EOF )
            // InternalExprParser.g:1868:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAnd"


    // $ANTLR start "ruleOpAnd"
    // InternalExprParser.g:1875:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= And | kw= AmpersandAmpersand ) ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:1879:6: ( (kw= And | kw= AmpersandAmpersand ) )
            // InternalExprParser.g:1880:1: (kw= And | kw= AmpersandAmpersand )
            {
            // InternalExprParser.g:1880:1: (kw= And | kw= AmpersandAmpersand )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==And) ) {
                alt19=1;
            }
            else if ( (LA19_0==AmpersandAmpersand) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalExprParser.g:1881:2: kw= And
                    {
                    kw=(Token)match(input,And,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAndAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:1888:2: kw= AmpersandAmpersand
                    {
                    kw=(Token)match(input,AmpersandAmpersand,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRuleEqualityExpression"
    // InternalExprParser.g:1901:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalExprParser.g:1902:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalExprParser.g:1903:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEqualityExpression"


    // $ANTLR start "ruleEqualityExpression"
    // InternalExprParser.g:1910:1: ruleEqualityExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RelationalExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1913:28: ( (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) )
            // InternalExprParser.g:1914:1: (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            {
            // InternalExprParser.g:1914:1: (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            // InternalExprParser.g:1915:5: this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_27);
            this_RelationalExpression_0=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_RelationalExpression_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalExprParser.g:1923:1: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==EqualsSignEqualsSign) && (synpred3_InternalExprParser())) {
                    alt20=1;
                }
                else if ( (LA20_0==ExclamationMarkEqualsSign) && (synpred3_InternalExprParser())) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalExprParser.g:1923:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) )
            	    {
            	    // InternalExprParser.g:1923:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) )
            	    // InternalExprParser.g:1923:3: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) )
            	    {
            	    // InternalExprParser.g:1928:6: ( () ( (lv_operator_2_0= ruleOpEquality ) ) )
            	    // InternalExprParser.g:1928:7: () ( (lv_operator_2_0= ruleOpEquality ) )
            	    {
            	    // InternalExprParser.g:1928:7: ()
            	    // InternalExprParser.g:1929:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getEqualityExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalExprParser.g:1934:2: ( (lv_operator_2_0= ruleOpEquality ) )
            	    // InternalExprParser.g:1935:1: (lv_operator_2_0= ruleOpEquality )
            	    {
            	    // InternalExprParser.g:1935:1: (lv_operator_2_0= ruleOpEquality )
            	    // InternalExprParser.g:1936:3: lv_operator_2_0= ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getOperatorOpEqualityParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_operator_2_0=ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"org.osate.expr.Expr.OpEquality");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalExprParser.g:1952:4: ( (lv_right_3_0= ruleRelationalExpression ) )
            	    // InternalExprParser.g:1953:1: (lv_right_3_0= ruleRelationalExpression )
            	    {
            	    // InternalExprParser.g:1953:1: (lv_right_3_0= ruleRelationalExpression )
            	    // InternalExprParser.g:1954:3: lv_right_3_0= ruleRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightRelationalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_27);
            	    lv_right_3_0=ruleRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"org.osate.expr.Expr.RelationalExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // InternalExprParser.g:1978:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // InternalExprParser.g:1979:1: (iv_ruleOpEquality= ruleOpEquality EOF )
            // InternalExprParser.g:1980:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpEquality"


    // $ANTLR start "ruleOpEquality"
    // InternalExprParser.g:1987:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= EqualsSignEqualsSign | kw= ExclamationMarkEqualsSign ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:1991:6: ( (kw= EqualsSignEqualsSign | kw= ExclamationMarkEqualsSign ) )
            // InternalExprParser.g:1992:1: (kw= EqualsSignEqualsSign | kw= ExclamationMarkEqualsSign )
            {
            // InternalExprParser.g:1992:1: (kw= EqualsSignEqualsSign | kw= ExclamationMarkEqualsSign )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==EqualsSignEqualsSign) ) {
                alt21=1;
            }
            else if ( (LA21_0==ExclamationMarkEqualsSign) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalExprParser.g:1993:2: kw= EqualsSignEqualsSign
                    {
                    kw=(Token)match(input,EqualsSignEqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2000:2: kw= ExclamationMarkEqualsSign
                    {
                    kw=(Token)match(input,ExclamationMarkEqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRuleRelationalExpression"
    // InternalExprParser.g:2013:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalExprParser.g:2014:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalExprParser.g:2015:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // InternalExprParser.g:2022:1: ruleRelationalExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AdditiveExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:2025:28: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) )
            // InternalExprParser.g:2026:1: (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalExprParser.g:2026:1: (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            // InternalExprParser.g:2027:5: this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_28);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_AdditiveExpression_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalExprParser.g:2035:1: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==GreaterThanSignEqualsSign) && (synpred4_InternalExprParser())) {
                    alt22=1;
                }
                else if ( (LA22_0==LessThanSignEqualsSign) && (synpred4_InternalExprParser())) {
                    alt22=1;
                }
                else if ( (LA22_0==GreaterThanSign) && (synpred4_InternalExprParser())) {
                    alt22=1;
                }
                else if ( (LA22_0==LessThanSign) && (synpred4_InternalExprParser())) {
                    alt22=1;
                }
                else if ( (LA22_0==GreaterThanSignLessThanSign) && (synpred4_InternalExprParser())) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalExprParser.g:2035:2: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalExprParser.g:2035:2: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) )
            	    // InternalExprParser.g:2035:3: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) )
            	    {
            	    // InternalExprParser.g:2040:6: ( () ( (lv_operator_2_0= ruleOpCompare ) ) )
            	    // InternalExprParser.g:2040:7: () ( (lv_operator_2_0= ruleOpCompare ) )
            	    {
            	    // InternalExprParser.g:2040:7: ()
            	    // InternalExprParser.g:2041:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getRelationalExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalExprParser.g:2046:2: ( (lv_operator_2_0= ruleOpCompare ) )
            	    // InternalExprParser.g:2047:1: (lv_operator_2_0= ruleOpCompare )
            	    {
            	    // InternalExprParser.g:2047:1: (lv_operator_2_0= ruleOpCompare )
            	    // InternalExprParser.g:2048:3: lv_operator_2_0= ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperatorOpCompareParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_operator_2_0=ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"org.osate.expr.Expr.OpCompare");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalExprParser.g:2064:4: ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    // InternalExprParser.g:2065:1: (lv_right_3_0= ruleAdditiveExpression )
            	    {
            	    // InternalExprParser.g:2065:1: (lv_right_3_0= ruleAdditiveExpression )
            	    // InternalExprParser.g:2066:3: lv_right_3_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_right_3_0=ruleAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"org.osate.expr.Expr.AdditiveExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // InternalExprParser.g:2090:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // InternalExprParser.g:2091:1: (iv_ruleOpCompare= ruleOpCompare EOF )
            // InternalExprParser.g:2092:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpCompare"


    // $ANTLR start "ruleOpCompare"
    // InternalExprParser.g:2099:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= GreaterThanSignEqualsSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= LessThanSign | kw= GreaterThanSignLessThanSign ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2103:6: ( (kw= GreaterThanSignEqualsSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= LessThanSign | kw= GreaterThanSignLessThanSign ) )
            // InternalExprParser.g:2104:1: (kw= GreaterThanSignEqualsSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= LessThanSign | kw= GreaterThanSignLessThanSign )
            {
            // InternalExprParser.g:2104:1: (kw= GreaterThanSignEqualsSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= LessThanSign | kw= GreaterThanSignLessThanSign )
            int alt23=5;
            switch ( input.LA(1) ) {
            case GreaterThanSignEqualsSign:
                {
                alt23=1;
                }
                break;
            case LessThanSignEqualsSign:
                {
                alt23=2;
                }
                break;
            case GreaterThanSign:
                {
                alt23=3;
                }
                break;
            case LessThanSign:
                {
                alt23=4;
                }
                break;
            case GreaterThanSignLessThanSign:
                {
                alt23=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalExprParser.g:2105:2: kw= GreaterThanSignEqualsSign
                    {
                    kw=(Token)match(input,GreaterThanSignEqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2112:2: kw= LessThanSignEqualsSign
                    {
                    kw=(Token)match(input,LessThanSignEqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:2119:2: kw= GreaterThanSign
                    {
                    kw=(Token)match(input,GreaterThanSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:2126:2: kw= LessThanSign
                    {
                    kw=(Token)match(input,LessThanSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalExprParser.g:2133:2: kw= GreaterThanSignLessThanSign
                    {
                    kw=(Token)match(input,GreaterThanSignLessThanSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignLessThanSignKeyword_4()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpCompare"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalExprParser.g:2146:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalExprParser.g:2147:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalExprParser.g:2148:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // InternalExprParser.g:2155:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplicativeExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:2158:28: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) )
            // InternalExprParser.g:2159:1: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            {
            // InternalExprParser.g:2159:1: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            // InternalExprParser.g:2160:5: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_29);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_MultiplicativeExpression_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalExprParser.g:2168:1: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==PlusSign) && (synpred5_InternalExprParser())) {
                    alt24=1;
                }
                else if ( (LA24_0==HyphenMinus) && (synpred5_InternalExprParser())) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalExprParser.g:2168:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) )
            	    {
            	    // InternalExprParser.g:2168:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) )
            	    // InternalExprParser.g:2168:3: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) )
            	    {
            	    // InternalExprParser.g:2173:6: ( () ( (lv_operator_2_0= ruleOpAdd ) ) )
            	    // InternalExprParser.g:2173:7: () ( (lv_operator_2_0= ruleOpAdd ) )
            	    {
            	    // InternalExprParser.g:2173:7: ()
            	    // InternalExprParser.g:2174:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAdditiveExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalExprParser.g:2179:2: ( (lv_operator_2_0= ruleOpAdd ) )
            	    // InternalExprParser.g:2180:1: (lv_operator_2_0= ruleOpAdd )
            	    {
            	    // InternalExprParser.g:2180:1: (lv_operator_2_0= ruleOpAdd )
            	    // InternalExprParser.g:2181:3: lv_operator_2_0= ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperatorOpAddParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_operator_2_0=ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"org.osate.expr.Expr.OpAdd");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalExprParser.g:2197:4: ( (lv_right_3_0= ruleMultiplicativeExpression ) )
            	    // InternalExprParser.g:2198:1: (lv_right_3_0= ruleMultiplicativeExpression )
            	    {
            	    // InternalExprParser.g:2198:1: (lv_right_3_0= ruleMultiplicativeExpression )
            	    // InternalExprParser.g:2199:3: lv_right_3_0= ruleMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_29);
            	    lv_right_3_0=ruleMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"org.osate.expr.Expr.MultiplicativeExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // InternalExprParser.g:2223:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // InternalExprParser.g:2224:1: (iv_ruleOpAdd= ruleOpAdd EOF )
            // InternalExprParser.g:2225:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAdd"


    // $ANTLR start "ruleOpAdd"
    // InternalExprParser.g:2232:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= PlusSign | kw= HyphenMinus ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2236:6: ( (kw= PlusSign | kw= HyphenMinus ) )
            // InternalExprParser.g:2237:1: (kw= PlusSign | kw= HyphenMinus )
            {
            // InternalExprParser.g:2237:1: (kw= PlusSign | kw= HyphenMinus )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==PlusSign) ) {
                alt25=1;
            }
            else if ( (LA25_0==HyphenMinus) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalExprParser.g:2238:2: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2245:2: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpAdd"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // InternalExprParser.g:2258:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalExprParser.g:2259:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalExprParser.g:2260:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // InternalExprParser.g:2267:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_UnaryOperation_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:2270:28: ( (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* ) )
            // InternalExprParser.g:2271:1: (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* )
            {
            // InternalExprParser.g:2271:1: (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* )
            // InternalExprParser.g:2272:5: this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getUnaryOperationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_30);
            this_UnaryOperation_0=ruleUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_UnaryOperation_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalExprParser.g:2280:1: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==Asterisk) && (synpred6_InternalExprParser())) {
                    alt26=1;
                }
                else if ( (LA26_0==Solidus) && (synpred6_InternalExprParser())) {
                    alt26=1;
                }
                else if ( (LA26_0==Div) && (synpred6_InternalExprParser())) {
                    alt26=1;
                }
                else if ( (LA26_0==Mod) && (synpred6_InternalExprParser())) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalExprParser.g:2280:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) )
            	    {
            	    // InternalExprParser.g:2280:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) )
            	    // InternalExprParser.g:2280:3: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) )
            	    {
            	    // InternalExprParser.g:2285:6: ( () ( (lv_operator_2_0= ruleOpMulti ) ) )
            	    // InternalExprParser.g:2285:7: () ( (lv_operator_2_0= ruleOpMulti ) )
            	    {
            	    // InternalExprParser.g:2285:7: ()
            	    // InternalExprParser.g:2286:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getMultiplicativeExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalExprParser.g:2291:2: ( (lv_operator_2_0= ruleOpMulti ) )
            	    // InternalExprParser.g:2292:1: (lv_operator_2_0= ruleOpMulti )
            	    {
            	    // InternalExprParser.g:2292:1: (lv_operator_2_0= ruleOpMulti )
            	    // InternalExprParser.g:2293:3: lv_operator_2_0= ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperatorOpMultiParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_operator_2_0=ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"org.osate.expr.Expr.OpMulti");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalExprParser.g:2309:4: ( (lv_right_3_0= ruleUnaryOperation ) )
            	    // InternalExprParser.g:2310:1: (lv_right_3_0= ruleUnaryOperation )
            	    {
            	    // InternalExprParser.g:2310:1: (lv_right_3_0= ruleUnaryOperation )
            	    // InternalExprParser.g:2311:3: lv_right_3_0= ruleUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightUnaryOperationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_30);
            	    lv_right_3_0=ruleUnaryOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"org.osate.expr.Expr.UnaryOperation");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // InternalExprParser.g:2335:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // InternalExprParser.g:2336:1: (iv_ruleOpMulti= ruleOpMulti EOF )
            // InternalExprParser.g:2337:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpMulti"


    // $ANTLR start "ruleOpMulti"
    // InternalExprParser.g:2344:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Asterisk | kw= Solidus | kw= Div | kw= Mod ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2348:6: ( (kw= Asterisk | kw= Solidus | kw= Div | kw= Mod ) )
            // InternalExprParser.g:2349:1: (kw= Asterisk | kw= Solidus | kw= Div | kw= Mod )
            {
            // InternalExprParser.g:2349:1: (kw= Asterisk | kw= Solidus | kw= Div | kw= Mod )
            int alt27=4;
            switch ( input.LA(1) ) {
            case Asterisk:
                {
                alt27=1;
                }
                break;
            case Solidus:
                {
                alt27=2;
                }
                break;
            case Div:
                {
                alt27=3;
                }
                break;
            case Mod:
                {
                alt27=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalExprParser.g:2350:2: kw= Asterisk
                    {
                    kw=(Token)match(input,Asterisk,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2357:2: kw= Solidus
                    {
                    kw=(Token)match(input,Solidus,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:2364:2: kw= Div
                    {
                    kw=(Token)match(input,Div,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getDivKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:2371:2: kw= Mod
                    {
                    kw=(Token)match(input,Mod,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getModKeyword_3()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpMulti"


    // $ANTLR start "entryRuleUnaryOperation"
    // InternalExprParser.g:2384:1: entryRuleUnaryOperation returns [EObject current=null] : iv_ruleUnaryOperation= ruleUnaryOperation EOF ;
    public final EObject entryRuleUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperation = null;


        try {
            // InternalExprParser.g:2385:2: (iv_ruleUnaryOperation= ruleUnaryOperation EOF )
            // InternalExprParser.g:2386:2: iv_ruleUnaryOperation= ruleUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnaryOperation=ruleUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryOperation"


    // $ANTLR start "ruleUnaryOperation"
    // InternalExprParser.g:2393:1: ruleUnaryOperation returns [EObject current=null] : ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) ) | this_UnitExpression_3= ruleUnitExpression ) ;
    public final EObject ruleUnaryOperation() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_operator_1_0 = null;

        EObject lv_operand_2_0 = null;

        EObject this_UnitExpression_3 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:2396:28: ( ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) ) | this_UnitExpression_3= ruleUnitExpression ) )
            // InternalExprParser.g:2397:1: ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) ) | this_UnitExpression_3= ruleUnitExpression )
            {
            // InternalExprParser.g:2397:1: ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) ) | this_UnitExpression_3= ruleUnitExpression )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==Not||LA28_0==PlusSign||LA28_0==HyphenMinus) ) {
                alt28=1;
            }
            else if ( (LA28_0==Record||LA28_0==False||(LA28_0>=Tuple && LA28_0<=Union)||LA28_0==List||(LA28_0>=This && LA28_0<=True)||LA28_0==Bag||LA28_0==Map||LA28_0==Set||LA28_0==If||LA28_0==NumberSign||LA28_0==LeftParenthesis||LA28_0==LeftSquareBracket||LA28_0==RULE_REAL_LIT||LA28_0==RULE_INTEGER_LIT||(LA28_0>=RULE_STRING && LA28_0<=RULE_ID)) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalExprParser.g:2397:2: ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) )
                    {
                    // InternalExprParser.g:2397:2: ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) )
                    // InternalExprParser.g:2397:3: () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) )
                    {
                    // InternalExprParser.g:2397:3: ()
                    // InternalExprParser.g:2398:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getUnaryOperationAccess().getUnaryOperationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalExprParser.g:2403:2: ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) )
                    // InternalExprParser.g:2403:3: ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary )
                    {
                    // InternalExprParser.g:2408:1: (lv_operator_1_0= ruleOpUnary )
                    // InternalExprParser.g:2409:3: lv_operator_1_0= ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryOperationAccess().getOperatorOpUnaryParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_10);
                    lv_operator_1_0=ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnaryOperationRule());
                      	        }
                             		set(
                             			current, 
                             			"operator",
                              		lv_operator_1_0, 
                              		"org.osate.expr.Expr.OpUnary");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalExprParser.g:2425:2: ( (lv_operand_2_0= ruleUnitExpression ) )
                    // InternalExprParser.g:2426:1: (lv_operand_2_0= ruleUnitExpression )
                    {
                    // InternalExprParser.g:2426:1: (lv_operand_2_0= ruleUnitExpression )
                    // InternalExprParser.g:2427:3: lv_operand_2_0= ruleUnitExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryOperationAccess().getOperandUnitExpressionParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_0=ruleUnitExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnaryOperationRule());
                      	        }
                             		set(
                             			current, 
                             			"operand",
                              		lv_operand_2_0, 
                              		"org.osate.expr.Expr.UnitExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2445:5: this_UnitExpression_3= ruleUnitExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnaryOperationAccess().getUnitExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_UnitExpression_3=ruleUnitExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_UnitExpression_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // InternalExprParser.g:2461:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // InternalExprParser.g:2462:1: (iv_ruleOpUnary= ruleOpUnary EOF )
            // InternalExprParser.g:2463:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpUnary"


    // $ANTLR start "ruleOpUnary"
    // InternalExprParser.g:2470:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Not | kw= HyphenMinus | kw= PlusSign ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2474:6: ( (kw= Not | kw= HyphenMinus | kw= PlusSign ) )
            // InternalExprParser.g:2475:1: (kw= Not | kw= HyphenMinus | kw= PlusSign )
            {
            // InternalExprParser.g:2475:1: (kw= Not | kw= HyphenMinus | kw= PlusSign )
            int alt29=3;
            switch ( input.LA(1) ) {
            case Not:
                {
                alt29=1;
                }
                break;
            case HyphenMinus:
                {
                alt29=2;
                }
                break;
            case PlusSign:
                {
                alt29=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // InternalExprParser.g:2476:2: kw= Not
                    {
                    kw=(Token)match(input,Not,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2483:2: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:2490:2: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpUnary"


    // $ANTLR start "entryRuleUnitExpression"
    // InternalExprParser.g:2503:1: entryRuleUnitExpression returns [EObject current=null] : iv_ruleUnitExpression= ruleUnitExpression EOF ;
    public final EObject entryRuleUnitExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpression = null;


        try {
            // InternalExprParser.g:2504:2: (iv_ruleUnitExpression= ruleUnitExpression EOF )
            // InternalExprParser.g:2505:2: iv_ruleUnitExpression= ruleUnitExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnitExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnitExpression=ruleUnitExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnitExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnitExpression"


    // $ANTLR start "ruleUnitExpression"
    // InternalExprParser.g:2512:1: ruleUnitExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleUnitExpression() throws RecognitionException {
        EObject current = null;

        Token lv_convert_2_0=null;
        Token lv_drop_3_0=null;
        Token otherlv_4=null;
        EObject this_PrimaryExpression_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:2515:28: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalExprParser.g:2516:1: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalExprParser.g:2516:1: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )? )
            // InternalExprParser.g:2517:5: this_PrimaryExpression_0= rulePrimaryExpression ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnitExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_31);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_PrimaryExpression_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalExprParser.g:2525:1: ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==In||LA31_0==PercentSign||LA31_0==RULE_ID) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalExprParser.g:2525:2: () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) )
                    {
                    // InternalExprParser.g:2525:2: ()
                    // InternalExprParser.g:2526:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getUnitExpressionAccess().getUnitExpressionExpressionAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalExprParser.g:2531:2: ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )?
                    int alt30=3;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==PercentSign) ) {
                        alt30=1;
                    }
                    else if ( (LA30_0==In) ) {
                        alt30=2;
                    }
                    switch (alt30) {
                        case 1 :
                            // InternalExprParser.g:2531:3: ( (lv_convert_2_0= PercentSign ) )
                            {
                            // InternalExprParser.g:2531:3: ( (lv_convert_2_0= PercentSign ) )
                            // InternalExprParser.g:2532:1: (lv_convert_2_0= PercentSign )
                            {
                            // InternalExprParser.g:2532:1: (lv_convert_2_0= PercentSign )
                            // InternalExprParser.g:2533:3: lv_convert_2_0= PercentSign
                            {
                            lv_convert_2_0=(Token)match(input,PercentSign,FOLLOW_5); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_convert_2_0, grammarAccess.getUnitExpressionAccess().getConvertPercentSignKeyword_1_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getUnitExpressionRule());
                              	        }
                                     		setWithLastConsumed(current, "convert", true, "%");
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalExprParser.g:2548:6: ( (lv_drop_3_0= In ) )
                            {
                            // InternalExprParser.g:2548:6: ( (lv_drop_3_0= In ) )
                            // InternalExprParser.g:2549:1: (lv_drop_3_0= In )
                            {
                            // InternalExprParser.g:2549:1: (lv_drop_3_0= In )
                            // InternalExprParser.g:2550:3: lv_drop_3_0= In
                            {
                            lv_drop_3_0=(Token)match(input,In,FOLLOW_5); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_drop_3_0, grammarAccess.getUnitExpressionAccess().getDropInKeyword_1_1_1_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getUnitExpressionRule());
                              	        }
                                     		setWithLastConsumed(current, "drop", true, "in");
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    // InternalExprParser.g:2564:4: ( (otherlv_4= RULE_ID ) )
                    // InternalExprParser.g:2565:1: (otherlv_4= RULE_ID )
                    {
                    // InternalExprParser.g:2565:1: (otherlv_4= RULE_ID )
                    // InternalExprParser.g:2566:3: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getUnitExpressionRule());
                      	        }
                              
                    }
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_4, grammarAccess.getUnitExpressionAccess().getUnitUnitLiteralCrossReference_1_2_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnitExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalExprParser.g:2585:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalExprParser.g:2586:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalExprParser.g:2587:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalExprParser.g:2594:1: rulePrimaryExpression returns [EObject current=null] : (this_VarRef_0= ruleVarRef | this_ModelOrPropertyReference_1= ruleModelOrPropertyReference | this_FunctionCall_2= ruleFunctionCall | this_RangeExpression_3= ruleRangeExpression | this_IfExpression_4= ruleIfExpression | this_Literal_5= ruleLiteral | (otherlv_6= LeftParenthesis this_Expression_7= ruleExpression otherlv_8= RightParenthesis ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject this_VarRef_0 = null;

        EObject this_ModelOrPropertyReference_1 = null;

        EObject this_FunctionCall_2 = null;

        EObject this_RangeExpression_3 = null;

        EObject this_IfExpression_4 = null;

        EObject this_Literal_5 = null;

        EObject this_Expression_7 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:2597:28: ( (this_VarRef_0= ruleVarRef | this_ModelOrPropertyReference_1= ruleModelOrPropertyReference | this_FunctionCall_2= ruleFunctionCall | this_RangeExpression_3= ruleRangeExpression | this_IfExpression_4= ruleIfExpression | this_Literal_5= ruleLiteral | (otherlv_6= LeftParenthesis this_Expression_7= ruleExpression otherlv_8= RightParenthesis ) ) )
            // InternalExprParser.g:2598:1: (this_VarRef_0= ruleVarRef | this_ModelOrPropertyReference_1= ruleModelOrPropertyReference | this_FunctionCall_2= ruleFunctionCall | this_RangeExpression_3= ruleRangeExpression | this_IfExpression_4= ruleIfExpression | this_Literal_5= ruleLiteral | (otherlv_6= LeftParenthesis this_Expression_7= ruleExpression otherlv_8= RightParenthesis ) )
            {
            // InternalExprParser.g:2598:1: (this_VarRef_0= ruleVarRef | this_ModelOrPropertyReference_1= ruleModelOrPropertyReference | this_FunctionCall_2= ruleFunctionCall | this_RangeExpression_3= ruleRangeExpression | this_IfExpression_4= ruleIfExpression | this_Literal_5= ruleLiteral | (otherlv_6= LeftParenthesis this_Expression_7= ruleExpression otherlv_8= RightParenthesis ) )
            int alt32=7;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // InternalExprParser.g:2599:5: this_VarRef_0= ruleVarRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getVarRefParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_VarRef_0=ruleVarRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_VarRef_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2609:5: this_ModelOrPropertyReference_1= ruleModelOrPropertyReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getModelOrPropertyReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_ModelOrPropertyReference_1=ruleModelOrPropertyReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ModelOrPropertyReference_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:2619:5: this_FunctionCall_2= ruleFunctionCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFunctionCallParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_FunctionCall_2=ruleFunctionCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_FunctionCall_2;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:2629:5: this_RangeExpression_3= ruleRangeExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getRangeExpressionParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_RangeExpression_3=ruleRangeExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_RangeExpression_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalExprParser.g:2639:5: this_IfExpression_4= ruleIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIfExpressionParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_IfExpression_4=ruleIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_IfExpression_4;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalExprParser.g:2649:5: this_Literal_5= ruleLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Literal_5=ruleLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_Literal_5;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalExprParser.g:2658:6: (otherlv_6= LeftParenthesis this_Expression_7= ruleExpression otherlv_8= RightParenthesis )
                    {
                    // InternalExprParser.g:2658:6: (otherlv_6= LeftParenthesis this_Expression_7= ruleExpression otherlv_8= RightParenthesis )
                    // InternalExprParser.g:2659:2: otherlv_6= LeftParenthesis this_Expression_7= ruleExpression otherlv_8= RightParenthesis
                    {
                    otherlv_6=(Token)match(input,LeftParenthesis,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_6_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_6_1()); 
                          
                    }
                    pushFollow(FOLLOW_12);
                    this_Expression_7=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_Expression_7;
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_8=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_6_2());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleVarRef"
    // InternalExprParser.g:2685:1: entryRuleVarRef returns [EObject current=null] : iv_ruleVarRef= ruleVarRef EOF ;
    public final EObject entryRuleVarRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarRef = null;


        try {
            // InternalExprParser.g:2686:2: (iv_ruleVarRef= ruleVarRef EOF )
            // InternalExprParser.g:2687:2: iv_ruleVarRef= ruleVarRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVarRef=ruleVarRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarRef"


    // $ANTLR start "ruleVarRef"
    // InternalExprParser.g:2694:1: ruleVarRef returns [EObject current=null] : ( ( ruleQCREF ) ) ;
    public final EObject ruleVarRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2697:28: ( ( ( ruleQCREF ) ) )
            // InternalExprParser.g:2698:1: ( ( ruleQCREF ) )
            {
            // InternalExprParser.g:2698:1: ( ( ruleQCREF ) )
            // InternalExprParser.g:2699:1: ( ruleQCREF )
            {
            // InternalExprParser.g:2699:1: ( ruleQCREF )
            // InternalExprParser.g:2700:3: ruleQCREF
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getVarRefRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVarRefAccess().getRefVarDeclCrossReference_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarRef"


    // $ANTLR start "entryRuleModelOrPropertyReference"
    // InternalExprParser.g:2722:1: entryRuleModelOrPropertyReference returns [EObject current=null] : iv_ruleModelOrPropertyReference= ruleModelOrPropertyReference EOF ;
    public final EObject entryRuleModelOrPropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelOrPropertyReference = null;


        try {
            // InternalExprParser.g:2723:2: (iv_ruleModelOrPropertyReference= ruleModelOrPropertyReference EOF )
            // InternalExprParser.g:2724:2: iv_ruleModelOrPropertyReference= ruleModelOrPropertyReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelOrPropertyReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModelOrPropertyReference=ruleModelOrPropertyReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModelOrPropertyReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModelOrPropertyReference"


    // $ANTLR start "ruleModelOrPropertyReference"
    // InternalExprParser.g:2731:1: ruleModelOrPropertyReference returns [EObject current=null] : ( (this_ModelReference_0= ruleModelReference ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )? ) | this_PropertyReference_4= rulePropertyReference ) ;
    public final EObject ruleModelOrPropertyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_ModelReference_0 = null;

        EObject this_PropertyReference_4 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:2734:28: ( ( (this_ModelReference_0= ruleModelReference ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )? ) | this_PropertyReference_4= rulePropertyReference ) )
            // InternalExprParser.g:2735:1: ( (this_ModelReference_0= ruleModelReference ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )? ) | this_PropertyReference_4= rulePropertyReference )
            {
            // InternalExprParser.g:2735:1: ( (this_ModelReference_0= ruleModelReference ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )? ) | this_PropertyReference_4= rulePropertyReference )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==This) ) {
                alt34=1;
            }
            else if ( (LA34_0==NumberSign) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalExprParser.g:2735:2: (this_ModelReference_0= ruleModelReference ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )? )
                    {
                    // InternalExprParser.g:2735:2: (this_ModelReference_0= ruleModelReference ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )? )
                    // InternalExprParser.g:2736:5: this_ModelReference_0= ruleModelReference ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getModelOrPropertyReferenceAccess().getModelReferenceParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FOLLOW_32);
                    this_ModelReference_0=ruleModelReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ModelReference_0;
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalExprParser.g:2744:1: ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==NumberSign) && (synpred8_InternalExprParser())) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // InternalExprParser.g:2744:2: ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) )
                            {
                            // InternalExprParser.g:2744:2: ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) )
                            // InternalExprParser.g:2744:3: ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign )
                            {
                            // InternalExprParser.g:2747:5: ( () otherlv_2= NumberSign )
                            // InternalExprParser.g:2747:6: () otherlv_2= NumberSign
                            {
                            // InternalExprParser.g:2747:6: ()
                            // InternalExprParser.g:2748:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getModelOrPropertyReferenceAccess().getPropertyReferenceModelElementReferenceAction_0_1_0_0_0(),
                                          current);
                                  
                            }

                            }

                            otherlv_2=(Token)match(input,NumberSign,FOLLOW_5); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_2, grammarAccess.getModelOrPropertyReferenceAccess().getNumberSignKeyword_0_1_0_0_1());
                                  
                            }

                            }


                            }

                            // InternalExprParser.g:2758:3: ( ( ruleQPREF ) )
                            // InternalExprParser.g:2759:1: ( ruleQPREF )
                            {
                            // InternalExprParser.g:2759:1: ( ruleQPREF )
                            // InternalExprParser.g:2760:3: ruleQPREF
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getModelOrPropertyReferenceRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getModelOrPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_2);
                            ruleQPREF();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2776:5: this_PropertyReference_4= rulePropertyReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getModelOrPropertyReferenceAccess().getPropertyReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_PropertyReference_4=rulePropertyReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_PropertyReference_4;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModelOrPropertyReference"


    // $ANTLR start "entryRuleModelReference"
    // InternalExprParser.g:2792:1: entryRuleModelReference returns [EObject current=null] : iv_ruleModelReference= ruleModelReference EOF ;
    public final EObject entryRuleModelReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelReference = null;


        try {
            // InternalExprParser.g:2793:2: (iv_ruleModelReference= ruleModelReference EOF )
            // InternalExprParser.g:2794:2: iv_ruleModelReference= ruleModelReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModelReference=ruleModelReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModelReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModelReference"


    // $ANTLR start "ruleModelReference"
    // InternalExprParser.g:2801:1: ruleModelReference returns [EObject current=null] : ( ( ( ruleThis ) ) ( () otherlv_2= FullStop ( (otherlv_3= RULE_ID ) ) )* ) ;
    public final EObject ruleModelReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2804:28: ( ( ( ( ruleThis ) ) ( () otherlv_2= FullStop ( (otherlv_3= RULE_ID ) ) )* ) )
            // InternalExprParser.g:2805:1: ( ( ( ruleThis ) ) ( () otherlv_2= FullStop ( (otherlv_3= RULE_ID ) ) )* )
            {
            // InternalExprParser.g:2805:1: ( ( ( ruleThis ) ) ( () otherlv_2= FullStop ( (otherlv_3= RULE_ID ) ) )* )
            // InternalExprParser.g:2805:2: ( ( ruleThis ) ) ( () otherlv_2= FullStop ( (otherlv_3= RULE_ID ) ) )*
            {
            // InternalExprParser.g:2805:2: ( ( ruleThis ) )
            // InternalExprParser.g:2806:1: ( ruleThis )
            {
            // InternalExprParser.g:2806:1: ( ruleThis )
            // InternalExprParser.g:2807:3: ruleThis
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getModelReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModelReferenceAccess().getModelElementNamedElementCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_33);
            ruleThis();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalExprParser.g:2821:2: ( () otherlv_2= FullStop ( (otherlv_3= RULE_ID ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==FullStop) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalExprParser.g:2821:3: () otherlv_2= FullStop ( (otherlv_3= RULE_ID ) )
            	    {
            	    // InternalExprParser.g:2821:3: ()
            	    // InternalExprParser.g:2822:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getModelReferenceAccess().getModelReferencePrevAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,FullStop,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getModelReferenceAccess().getFullStopKeyword_1_1());
            	          
            	    }
            	    // InternalExprParser.g:2832:1: ( (otherlv_3= RULE_ID ) )
            	    // InternalExprParser.g:2833:1: (otherlv_3= RULE_ID )
            	    {
            	    // InternalExprParser.g:2833:1: (otherlv_3= RULE_ID )
            	    // InternalExprParser.g:2834:3: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getModelReferenceRule());
            	      	        }
            	              
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_3, grammarAccess.getModelReferenceAccess().getModelElementNamedElementCrossReference_1_2_0()); 
            	      	
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModelReference"


    // $ANTLR start "entryRuleThis"
    // InternalExprParser.g:2853:1: entryRuleThis returns [String current=null] : iv_ruleThis= ruleThis EOF ;
    public final String entryRuleThis() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleThis = null;


        try {
            // InternalExprParser.g:2854:1: (iv_ruleThis= ruleThis EOF )
            // InternalExprParser.g:2855:2: iv_ruleThis= ruleThis EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getThisRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleThis=ruleThis();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleThis.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleThis"


    // $ANTLR start "ruleThis"
    // InternalExprParser.g:2862:1: ruleThis returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= This ;
    public final AntlrDatatypeRuleToken ruleThis() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2866:6: (kw= This )
            // InternalExprParser.g:2868:2: kw= This
            {
            kw=(Token)match(input,This,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getThisAccess().getThisKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleThis"


    // $ANTLR start "entryRulePropertyReference"
    // InternalExprParser.g:2881:1: entryRulePropertyReference returns [EObject current=null] : iv_rulePropertyReference= rulePropertyReference EOF ;
    public final EObject entryRulePropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyReference = null;


        try {
            // InternalExprParser.g:2882:2: (iv_rulePropertyReference= rulePropertyReference EOF )
            // InternalExprParser.g:2883:2: iv_rulePropertyReference= rulePropertyReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePropertyReference=rulePropertyReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyReference"


    // $ANTLR start "rulePropertyReference"
    // InternalExprParser.g:2890:1: rulePropertyReference returns [EObject current=null] : ( () otherlv_1= NumberSign ( ( ruleQPREF ) ) ) ;
    public final EObject rulePropertyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2893:28: ( ( () otherlv_1= NumberSign ( ( ruleQPREF ) ) ) )
            // InternalExprParser.g:2894:1: ( () otherlv_1= NumberSign ( ( ruleQPREF ) ) )
            {
            // InternalExprParser.g:2894:1: ( () otherlv_1= NumberSign ( ( ruleQPREF ) ) )
            // InternalExprParser.g:2894:2: () otherlv_1= NumberSign ( ( ruleQPREF ) )
            {
            // InternalExprParser.g:2894:2: ()
            // InternalExprParser.g:2895:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPropertyReferenceAccess().getPropertyReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,NumberSign,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPropertyReferenceAccess().getNumberSignKeyword_1());
                  
            }
            // InternalExprParser.g:2905:1: ( ( ruleQPREF ) )
            // InternalExprParser.g:2906:1: ( ruleQPREF )
            {
            // InternalExprParser.g:2906:1: ( ruleQPREF )
            // InternalExprParser.g:2907:3: ruleQPREF
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPropertyReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyReference"


    // $ANTLR start "entryRuleFunctionCall"
    // InternalExprParser.g:2929:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // InternalExprParser.g:2930:2: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // InternalExprParser.g:2931:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionCall=ruleFunctionCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionCall"


    // $ANTLR start "ruleFunctionCall"
    // InternalExprParser.g:2938:1: ruleFunctionCall returns [EObject current=null] : ( () ( (lv_function_1_0= ruleQCREF ) ) otherlv_2= LeftParenthesis ( ( (lv_arguments_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_arguments_5_0= ruleExpression ) ) )* )? otherlv_6= RightParenthesis ) ;
    public final EObject ruleFunctionCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_function_1_0 = null;

        EObject lv_arguments_3_0 = null;

        EObject lv_arguments_5_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:2941:28: ( ( () ( (lv_function_1_0= ruleQCREF ) ) otherlv_2= LeftParenthesis ( ( (lv_arguments_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_arguments_5_0= ruleExpression ) ) )* )? otherlv_6= RightParenthesis ) )
            // InternalExprParser.g:2942:1: ( () ( (lv_function_1_0= ruleQCREF ) ) otherlv_2= LeftParenthesis ( ( (lv_arguments_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_arguments_5_0= ruleExpression ) ) )* )? otherlv_6= RightParenthesis )
            {
            // InternalExprParser.g:2942:1: ( () ( (lv_function_1_0= ruleQCREF ) ) otherlv_2= LeftParenthesis ( ( (lv_arguments_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_arguments_5_0= ruleExpression ) ) )* )? otherlv_6= RightParenthesis )
            // InternalExprParser.g:2942:2: () ( (lv_function_1_0= ruleQCREF ) ) otherlv_2= LeftParenthesis ( ( (lv_arguments_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_arguments_5_0= ruleExpression ) ) )* )? otherlv_6= RightParenthesis
            {
            // InternalExprParser.g:2942:2: ()
            // InternalExprParser.g:2943:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getFunctionCallAccess().getFunctionCallAction_0(),
                          current);
                  
            }

            }

            // InternalExprParser.g:2948:2: ( (lv_function_1_0= ruleQCREF ) )
            // InternalExprParser.g:2949:1: (lv_function_1_0= ruleQCREF )
            {
            // InternalExprParser.g:2949:1: (lv_function_1_0= ruleQCREF )
            // InternalExprParser.g:2950:3: lv_function_1_0= ruleQCREF
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFunctionCallAccess().getFunctionQCREFParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_11);
            lv_function_1_0=ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFunctionCallRule());
              	        }
                     		set(
                     			current, 
                     			"function",
                      		lv_function_1_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.QCREF");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,LeftParenthesis,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_2());
                  
            }
            // InternalExprParser.g:2971:1: ( ( (lv_arguments_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_arguments_5_0= ruleExpression ) ) )* )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==Record||LA37_0==False||(LA37_0>=Tuple && LA37_0<=Union)||LA37_0==List||(LA37_0>=This && LA37_0<=True)||LA37_0==Bag||LA37_0==Map||(LA37_0>=Not && LA37_0<=Set)||LA37_0==If||LA37_0==NumberSign||LA37_0==LeftParenthesis||LA37_0==PlusSign||LA37_0==HyphenMinus||LA37_0==LeftSquareBracket||LA37_0==RULE_REAL_LIT||LA37_0==RULE_INTEGER_LIT||(LA37_0>=RULE_STRING && LA37_0<=RULE_ID)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalExprParser.g:2971:2: ( (lv_arguments_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_arguments_5_0= ruleExpression ) ) )*
                    {
                    // InternalExprParser.g:2971:2: ( (lv_arguments_3_0= ruleExpression ) )
                    // InternalExprParser.g:2972:1: (lv_arguments_3_0= ruleExpression )
                    {
                    // InternalExprParser.g:2972:1: (lv_arguments_3_0= ruleExpression )
                    // InternalExprParser.g:2973:3: lv_arguments_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFunctionCallAccess().getArgumentsExpressionParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_35);
                    lv_arguments_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFunctionCallRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_3_0, 
                              		"org.osate.expr.Expr.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalExprParser.g:2989:2: (otherlv_4= Comma ( (lv_arguments_5_0= ruleExpression ) ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==Comma) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // InternalExprParser.g:2990:2: otherlv_4= Comma ( (lv_arguments_5_0= ruleExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_10); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getFunctionCallAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // InternalExprParser.g:2994:1: ( (lv_arguments_5_0= ruleExpression ) )
                    	    // InternalExprParser.g:2995:1: (lv_arguments_5_0= ruleExpression )
                    	    {
                    	    // InternalExprParser.g:2995:1: (lv_arguments_5_0= ruleExpression )
                    	    // InternalExprParser.g:2996:3: lv_arguments_5_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFunctionCallAccess().getArgumentsExpressionParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_35);
                    	    lv_arguments_5_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getFunctionCallRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"arguments",
                    	              		lv_arguments_5_0, 
                    	              		"org.osate.expr.Expr.Expression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getFunctionCallAccess().getRightParenthesisKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionCall"


    // $ANTLR start "entryRuleRangeExpression"
    // InternalExprParser.g:3025:1: entryRuleRangeExpression returns [EObject current=null] : iv_ruleRangeExpression= ruleRangeExpression EOF ;
    public final EObject entryRuleRangeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeExpression = null;


        try {
            // InternalExprParser.g:3026:2: (iv_ruleRangeExpression= ruleRangeExpression EOF )
            // InternalExprParser.g:3027:2: iv_ruleRangeExpression= ruleRangeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRangeExpression=ruleRangeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRangeExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRangeExpression"


    // $ANTLR start "ruleRangeExpression"
    // InternalExprParser.g:3034:1: ruleRangeExpression returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_minimum_2_0= ruleExpression ) ) otherlv_3= FullStopFullStop ( (lv_maximum_4_0= ruleExpression ) ) ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )? otherlv_7= RightSquareBracket ) ;
    public final EObject ruleRangeExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_minimum_2_0 = null;

        EObject lv_maximum_4_0 = null;

        EObject lv_delta_6_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3037:28: ( ( () otherlv_1= LeftSquareBracket ( (lv_minimum_2_0= ruleExpression ) ) otherlv_3= FullStopFullStop ( (lv_maximum_4_0= ruleExpression ) ) ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )? otherlv_7= RightSquareBracket ) )
            // InternalExprParser.g:3038:1: ( () otherlv_1= LeftSquareBracket ( (lv_minimum_2_0= ruleExpression ) ) otherlv_3= FullStopFullStop ( (lv_maximum_4_0= ruleExpression ) ) ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )? otherlv_7= RightSquareBracket )
            {
            // InternalExprParser.g:3038:1: ( () otherlv_1= LeftSquareBracket ( (lv_minimum_2_0= ruleExpression ) ) otherlv_3= FullStopFullStop ( (lv_maximum_4_0= ruleExpression ) ) ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )? otherlv_7= RightSquareBracket )
            // InternalExprParser.g:3038:2: () otherlv_1= LeftSquareBracket ( (lv_minimum_2_0= ruleExpression ) ) otherlv_3= FullStopFullStop ( (lv_maximum_4_0= ruleExpression ) ) ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )? otherlv_7= RightSquareBracket
            {
            // InternalExprParser.g:3038:2: ()
            // InternalExprParser.g:3039:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRangeExpressionAccess().getRangeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRangeExpressionAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // InternalExprParser.g:3049:1: ( (lv_minimum_2_0= ruleExpression ) )
            // InternalExprParser.g:3050:1: (lv_minimum_2_0= ruleExpression )
            {
            // InternalExprParser.g:3050:1: (lv_minimum_2_0= ruleExpression )
            // InternalExprParser.g:3051:3: lv_minimum_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRangeExpressionAccess().getMinimumExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_36);
            lv_minimum_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRangeExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"minimum",
                      		lv_minimum_2_0, 
                      		"org.osate.expr.Expr.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,FullStopFullStop,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getRangeExpressionAccess().getFullStopFullStopKeyword_3());
                  
            }
            // InternalExprParser.g:3072:1: ( (lv_maximum_4_0= ruleExpression ) )
            // InternalExprParser.g:3073:1: (lv_maximum_4_0= ruleExpression )
            {
            // InternalExprParser.g:3073:1: (lv_maximum_4_0= ruleExpression )
            // InternalExprParser.g:3074:3: lv_maximum_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRangeExpressionAccess().getMaximumExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_37);
            lv_maximum_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRangeExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"maximum",
                      		lv_maximum_4_0, 
                      		"org.osate.expr.Expr.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalExprParser.g:3090:2: ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==Delta) && (synpred9_InternalExprParser())) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalExprParser.g:3090:3: ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) )
                    {
                    // InternalExprParser.g:3090:3: ( ( Delta )=>otherlv_5= Delta )
                    // InternalExprParser.g:3090:4: ( Delta )=>otherlv_5= Delta
                    {
                    otherlv_5=(Token)match(input,Delta,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getRangeExpressionAccess().getDeltaKeyword_5_0());
                          
                    }

                    }

                    // InternalExprParser.g:3097:2: ( (lv_delta_6_0= ruleExpression ) )
                    // InternalExprParser.g:3098:1: (lv_delta_6_0= ruleExpression )
                    {
                    // InternalExprParser.g:3098:1: (lv_delta_6_0= ruleExpression )
                    // InternalExprParser.g:3099:3: lv_delta_6_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRangeExpressionAccess().getDeltaExpressionParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_38);
                    lv_delta_6_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRangeExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"delta",
                              		lv_delta_6_0, 
                              		"org.osate.expr.Expr.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getRangeExpressionAccess().getRightSquareBracketKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRangeExpression"


    // $ANTLR start "entryRuleIfExpression"
    // InternalExprParser.g:3128:1: entryRuleIfExpression returns [EObject current=null] : iv_ruleIfExpression= ruleIfExpression EOF ;
    public final EObject entryRuleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpression = null;


        try {
            // InternalExprParser.g:3129:2: (iv_ruleIfExpression= ruleIfExpression EOF )
            // InternalExprParser.g:3130:2: iv_ruleIfExpression= ruleIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfExpression=ruleIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfExpression"


    // $ANTLR start "ruleIfExpression"
    // InternalExprParser.g:3137:1: ruleIfExpression returns [EObject current=null] : ( () otherlv_1= If ( (lv_if_2_0= ruleExpression ) ) otherlv_3= Then ( (lv_then_4_0= ruleExpression ) ) (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )? otherlv_7= Endif ) ;
    public final EObject ruleIfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_if_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject lv_else_6_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3140:28: ( ( () otherlv_1= If ( (lv_if_2_0= ruleExpression ) ) otherlv_3= Then ( (lv_then_4_0= ruleExpression ) ) (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )? otherlv_7= Endif ) )
            // InternalExprParser.g:3141:1: ( () otherlv_1= If ( (lv_if_2_0= ruleExpression ) ) otherlv_3= Then ( (lv_then_4_0= ruleExpression ) ) (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )? otherlv_7= Endif )
            {
            // InternalExprParser.g:3141:1: ( () otherlv_1= If ( (lv_if_2_0= ruleExpression ) ) otherlv_3= Then ( (lv_then_4_0= ruleExpression ) ) (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )? otherlv_7= Endif )
            // InternalExprParser.g:3141:2: () otherlv_1= If ( (lv_if_2_0= ruleExpression ) ) otherlv_3= Then ( (lv_then_4_0= ruleExpression ) ) (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )? otherlv_7= Endif
            {
            // InternalExprParser.g:3141:2: ()
            // InternalExprParser.g:3142:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getIfExpressionAccess().getConditionalAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,If,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getIfExpressionAccess().getIfKeyword_1());
                  
            }
            // InternalExprParser.g:3152:1: ( (lv_if_2_0= ruleExpression ) )
            // InternalExprParser.g:3153:1: (lv_if_2_0= ruleExpression )
            {
            // InternalExprParser.g:3153:1: (lv_if_2_0= ruleExpression )
            // InternalExprParser.g:3154:3: lv_if_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpressionAccess().getIfExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_39);
            lv_if_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"if",
                      		lv_if_2_0, 
                      		"org.osate.expr.Expr.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,Then,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getIfExpressionAccess().getThenKeyword_3());
                  
            }
            // InternalExprParser.g:3175:1: ( (lv_then_4_0= ruleExpression ) )
            // InternalExprParser.g:3176:1: (lv_then_4_0= ruleExpression )
            {
            // InternalExprParser.g:3176:1: (lv_then_4_0= ruleExpression )
            // InternalExprParser.g:3177:3: lv_then_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpressionAccess().getThenExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_40);
            lv_then_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"then",
                      		lv_then_4_0, 
                      		"org.osate.expr.Expr.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalExprParser.g:3193:2: (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==Else) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalExprParser.g:3194:2: otherlv_5= Else ( (lv_else_6_0= ruleExpression ) )
                    {
                    otherlv_5=(Token)match(input,Else,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getIfExpressionAccess().getElseKeyword_5_0());
                          
                    }
                    // InternalExprParser.g:3198:1: ( (lv_else_6_0= ruleExpression ) )
                    // InternalExprParser.g:3199:1: (lv_else_6_0= ruleExpression )
                    {
                    // InternalExprParser.g:3199:1: (lv_else_6_0= ruleExpression )
                    // InternalExprParser.g:3200:3: lv_else_6_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIfExpressionAccess().getElseExpressionParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_41);
                    lv_else_6_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIfExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"else",
                              		lv_else_6_0, 
                              		"org.osate.expr.Expr.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,Endif,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getIfExpressionAccess().getEndifKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfExpression"


    // $ANTLR start "entryRuleLiteral"
    // InternalExprParser.g:3229:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalExprParser.g:3230:2: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalExprParser.g:3231:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalExprParser.g:3238:1: ruleLiteral returns [EObject current=null] : (this_EBooleanLiteral_0= ruleEBooleanLiteral | this_EIntegerLiteral_1= ruleEIntegerLiteral | this_ERealLiteral_2= ruleERealLiteral | this_EStringLiteral_3= ruleEStringLiteral | this_ListLiteral_4= ruleListLiteral | this_SetLiteral_5= ruleSetLiteral | this_RecordLiteral_6= ruleRecordLiteral | this_UnionLiteral_7= ruleUnionLiteral | this_TupleLiteral_8= ruleTupleLiteral | this_BagLiteral_9= ruleBagLiteral | this_MapLiteral_10= ruleMapLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_EBooleanLiteral_0 = null;

        EObject this_EIntegerLiteral_1 = null;

        EObject this_ERealLiteral_2 = null;

        EObject this_EStringLiteral_3 = null;

        EObject this_ListLiteral_4 = null;

        EObject this_SetLiteral_5 = null;

        EObject this_RecordLiteral_6 = null;

        EObject this_UnionLiteral_7 = null;

        EObject this_TupleLiteral_8 = null;

        EObject this_BagLiteral_9 = null;

        EObject this_MapLiteral_10 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3241:28: ( (this_EBooleanLiteral_0= ruleEBooleanLiteral | this_EIntegerLiteral_1= ruleEIntegerLiteral | this_ERealLiteral_2= ruleERealLiteral | this_EStringLiteral_3= ruleEStringLiteral | this_ListLiteral_4= ruleListLiteral | this_SetLiteral_5= ruleSetLiteral | this_RecordLiteral_6= ruleRecordLiteral | this_UnionLiteral_7= ruleUnionLiteral | this_TupleLiteral_8= ruleTupleLiteral | this_BagLiteral_9= ruleBagLiteral | this_MapLiteral_10= ruleMapLiteral ) )
            // InternalExprParser.g:3242:1: (this_EBooleanLiteral_0= ruleEBooleanLiteral | this_EIntegerLiteral_1= ruleEIntegerLiteral | this_ERealLiteral_2= ruleERealLiteral | this_EStringLiteral_3= ruleEStringLiteral | this_ListLiteral_4= ruleListLiteral | this_SetLiteral_5= ruleSetLiteral | this_RecordLiteral_6= ruleRecordLiteral | this_UnionLiteral_7= ruleUnionLiteral | this_TupleLiteral_8= ruleTupleLiteral | this_BagLiteral_9= ruleBagLiteral | this_MapLiteral_10= ruleMapLiteral )
            {
            // InternalExprParser.g:3242:1: (this_EBooleanLiteral_0= ruleEBooleanLiteral | this_EIntegerLiteral_1= ruleEIntegerLiteral | this_ERealLiteral_2= ruleERealLiteral | this_EStringLiteral_3= ruleEStringLiteral | this_ListLiteral_4= ruleListLiteral | this_SetLiteral_5= ruleSetLiteral | this_RecordLiteral_6= ruleRecordLiteral | this_UnionLiteral_7= ruleUnionLiteral | this_TupleLiteral_8= ruleTupleLiteral | this_BagLiteral_9= ruleBagLiteral | this_MapLiteral_10= ruleMapLiteral )
            int alt40=11;
            switch ( input.LA(1) ) {
            case False:
            case True:
                {
                alt40=1;
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt40=2;
                }
                break;
            case RULE_REAL_LIT:
                {
                alt40=3;
                }
                break;
            case RULE_STRING:
                {
                alt40=4;
                }
                break;
            case List:
                {
                alt40=5;
                }
                break;
            case Set:
                {
                alt40=6;
                }
                break;
            case Record:
                {
                alt40=7;
                }
                break;
            case Union:
                {
                alt40=8;
                }
                break;
            case Tuple:
                {
                alt40=9;
                }
                break;
            case Bag:
                {
                alt40=10;
                }
                break;
            case Map:
                {
                alt40=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // InternalExprParser.g:3243:5: this_EBooleanLiteral_0= ruleEBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getEBooleanLiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_EBooleanLiteral_0=ruleEBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_EBooleanLiteral_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:3253:5: this_EIntegerLiteral_1= ruleEIntegerLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getEIntegerLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_EIntegerLiteral_1=ruleEIntegerLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_EIntegerLiteral_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:3263:5: this_ERealLiteral_2= ruleERealLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getERealLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_ERealLiteral_2=ruleERealLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ERealLiteral_2;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:3273:5: this_EStringLiteral_3= ruleEStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getEStringLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_EStringLiteral_3=ruleEStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_EStringLiteral_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalExprParser.g:3283:5: this_ListLiteral_4= ruleListLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getListLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_ListLiteral_4=ruleListLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ListLiteral_4;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalExprParser.g:3293:5: this_SetLiteral_5= ruleSetLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getSetLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_SetLiteral_5=ruleSetLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_SetLiteral_5;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalExprParser.g:3303:5: this_RecordLiteral_6= ruleRecordLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getRecordLiteralParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_RecordLiteral_6=ruleRecordLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_RecordLiteral_6;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalExprParser.g:3313:5: this_UnionLiteral_7= ruleUnionLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getUnionLiteralParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_UnionLiteral_7=ruleUnionLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_UnionLiteral_7;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // InternalExprParser.g:3323:5: this_TupleLiteral_8= ruleTupleLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getTupleLiteralParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_TupleLiteral_8=ruleTupleLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_TupleLiteral_8;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // InternalExprParser.g:3333:5: this_BagLiteral_9= ruleBagLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getBagLiteralParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_BagLiteral_9=ruleBagLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_BagLiteral_9;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 11 :
                    // InternalExprParser.g:3343:5: this_MapLiteral_10= ruleMapLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getMapLiteralParserRuleCall_10()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_MapLiteral_10=ruleMapLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_MapLiteral_10;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleEBooleanLiteral"
    // InternalExprParser.g:3359:1: entryRuleEBooleanLiteral returns [EObject current=null] : iv_ruleEBooleanLiteral= ruleEBooleanLiteral EOF ;
    public final EObject entryRuleEBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEBooleanLiteral = null;


        try {
            // InternalExprParser.g:3360:2: (iv_ruleEBooleanLiteral= ruleEBooleanLiteral EOF )
            // InternalExprParser.g:3361:2: iv_ruleEBooleanLiteral= ruleEBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEBooleanLiteral=ruleEBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEBooleanLiteral"


    // $ANTLR start "ruleEBooleanLiteral"
    // InternalExprParser.g:3368:1: ruleEBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) ;
    public final EObject ruleEBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:3371:28: ( ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) )
            // InternalExprParser.g:3372:1: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            {
            // InternalExprParser.g:3372:1: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            // InternalExprParser.g:3372:2: () ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            {
            // InternalExprParser.g:3372:2: ()
            // InternalExprParser.g:3373:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEBooleanLiteralAccess().getEBoolAction_0(),
                          current);
                  
            }

            }

            // InternalExprParser.g:3378:2: ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==True) ) {
                alt41=1;
            }
            else if ( (LA41_0==False) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalExprParser.g:3378:3: ( (lv_value_1_0= True ) )
                    {
                    // InternalExprParser.g:3378:3: ( (lv_value_1_0= True ) )
                    // InternalExprParser.g:3379:1: (lv_value_1_0= True )
                    {
                    // InternalExprParser.g:3379:1: (lv_value_1_0= True )
                    // InternalExprParser.g:3380:3: lv_value_1_0= True
                    {
                    lv_value_1_0=(Token)match(input,True,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_value_1_0, grammarAccess.getEBooleanLiteralAccess().getValueTrueKeyword_1_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEBooleanLiteralRule());
                      	        }
                             		setWithLastConsumed(current, "value", true, "true");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:3396:2: otherlv_2= False
                    {
                    otherlv_2=(Token)match(input,False,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getEBooleanLiteralAccess().getFalseKeyword_1_1());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEBooleanLiteral"


    // $ANTLR start "entryRuleEIntegerLiteral"
    // InternalExprParser.g:3408:1: entryRuleEIntegerLiteral returns [EObject current=null] : iv_ruleEIntegerLiteral= ruleEIntegerLiteral EOF ;
    public final EObject entryRuleEIntegerLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEIntegerLiteral = null;


        try {
            // InternalExprParser.g:3409:2: (iv_ruleEIntegerLiteral= ruleEIntegerLiteral EOF )
            // InternalExprParser.g:3410:2: iv_ruleEIntegerLiteral= ruleEIntegerLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEIntegerLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEIntegerLiteral=ruleEIntegerLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEIntegerLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEIntegerLiteral"


    // $ANTLR start "ruleEIntegerLiteral"
    // InternalExprParser.g:3417:1: ruleEIntegerLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INTEGER_LIT ) ) ) ;
    public final EObject ruleEIntegerLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:3420:28: ( ( () ( (lv_value_1_0= RULE_INTEGER_LIT ) ) ) )
            // InternalExprParser.g:3421:1: ( () ( (lv_value_1_0= RULE_INTEGER_LIT ) ) )
            {
            // InternalExprParser.g:3421:1: ( () ( (lv_value_1_0= RULE_INTEGER_LIT ) ) )
            // InternalExprParser.g:3421:2: () ( (lv_value_1_0= RULE_INTEGER_LIT ) )
            {
            // InternalExprParser.g:3421:2: ()
            // InternalExprParser.g:3422:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEIntegerLiteralAccess().getEIntAction_0(),
                          current);
                  
            }

            }

            // InternalExprParser.g:3427:2: ( (lv_value_1_0= RULE_INTEGER_LIT ) )
            // InternalExprParser.g:3428:1: (lv_value_1_0= RULE_INTEGER_LIT )
            {
            // InternalExprParser.g:3428:1: (lv_value_1_0= RULE_INTEGER_LIT )
            // InternalExprParser.g:3429:3: lv_value_1_0= RULE_INTEGER_LIT
            {
            lv_value_1_0=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getEIntegerLiteralAccess().getValueINTEGER_LITTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getEIntegerLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.INTEGER_LIT");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEIntegerLiteral"


    // $ANTLR start "entryRuleERealLiteral"
    // InternalExprParser.g:3453:1: entryRuleERealLiteral returns [EObject current=null] : iv_ruleERealLiteral= ruleERealLiteral EOF ;
    public final EObject entryRuleERealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleERealLiteral = null;


        try {
            // InternalExprParser.g:3454:2: (iv_ruleERealLiteral= ruleERealLiteral EOF )
            // InternalExprParser.g:3455:2: iv_ruleERealLiteral= ruleERealLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getERealLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleERealLiteral=ruleERealLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleERealLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleERealLiteral"


    // $ANTLR start "ruleERealLiteral"
    // InternalExprParser.g:3462:1: ruleERealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_REAL_LIT ) ) ) ;
    public final EObject ruleERealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:3465:28: ( ( () ( (lv_value_1_0= RULE_REAL_LIT ) ) ) )
            // InternalExprParser.g:3466:1: ( () ( (lv_value_1_0= RULE_REAL_LIT ) ) )
            {
            // InternalExprParser.g:3466:1: ( () ( (lv_value_1_0= RULE_REAL_LIT ) ) )
            // InternalExprParser.g:3466:2: () ( (lv_value_1_0= RULE_REAL_LIT ) )
            {
            // InternalExprParser.g:3466:2: ()
            // InternalExprParser.g:3467:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getERealLiteralAccess().getERealAction_0(),
                          current);
                  
            }

            }

            // InternalExprParser.g:3472:2: ( (lv_value_1_0= RULE_REAL_LIT ) )
            // InternalExprParser.g:3473:1: (lv_value_1_0= RULE_REAL_LIT )
            {
            // InternalExprParser.g:3473:1: (lv_value_1_0= RULE_REAL_LIT )
            // InternalExprParser.g:3474:3: lv_value_1_0= RULE_REAL_LIT
            {
            lv_value_1_0=(Token)match(input,RULE_REAL_LIT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getERealLiteralAccess().getValueREAL_LITTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getERealLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.REAL_LIT");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleERealLiteral"


    // $ANTLR start "entryRuleEStringLiteral"
    // InternalExprParser.g:3498:1: entryRuleEStringLiteral returns [EObject current=null] : iv_ruleEStringLiteral= ruleEStringLiteral EOF ;
    public final EObject entryRuleEStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEStringLiteral = null;


        try {
            // InternalExprParser.g:3499:2: (iv_ruleEStringLiteral= ruleEStringLiteral EOF )
            // InternalExprParser.g:3500:2: iv_ruleEStringLiteral= ruleEStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEStringLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEStringLiteral=ruleEStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEStringLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEStringLiteral"


    // $ANTLR start "ruleEStringLiteral"
    // InternalExprParser.g:3507:1: ruleEStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleNoQuoteString ) ) ) ;
    public final EObject ruleEStringLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3510:28: ( ( () ( (lv_value_1_0= ruleNoQuoteString ) ) ) )
            // InternalExprParser.g:3511:1: ( () ( (lv_value_1_0= ruleNoQuoteString ) ) )
            {
            // InternalExprParser.g:3511:1: ( () ( (lv_value_1_0= ruleNoQuoteString ) ) )
            // InternalExprParser.g:3511:2: () ( (lv_value_1_0= ruleNoQuoteString ) )
            {
            // InternalExprParser.g:3511:2: ()
            // InternalExprParser.g:3512:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEStringLiteralAccess().getEStringAction_0(),
                          current);
                  
            }

            }

            // InternalExprParser.g:3517:2: ( (lv_value_1_0= ruleNoQuoteString ) )
            // InternalExprParser.g:3518:1: (lv_value_1_0= ruleNoQuoteString )
            {
            // InternalExprParser.g:3518:1: (lv_value_1_0= ruleNoQuoteString )
            // InternalExprParser.g:3519:3: lv_value_1_0= ruleNoQuoteString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEStringLiteralAccess().getValueNoQuoteStringParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getEStringLiteralRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.NoQuoteString");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEStringLiteral"


    // $ANTLR start "ruleCommaSeparatedExpressions"
    // InternalExprParser.g:3544:1: ruleCommaSeparatedExpressions[EObject in_current] returns [EObject current=in_current] : ( ( (lv_elements_0_0= ruleExpression ) ) (otherlv_1= Comma ( (lv_elements_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleCommaSeparatedExpressions(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_elements_0_0 = null;

        EObject lv_elements_2_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3547:28: ( ( ( (lv_elements_0_0= ruleExpression ) ) (otherlv_1= Comma ( (lv_elements_2_0= ruleExpression ) ) )* ) )
            // InternalExprParser.g:3548:1: ( ( (lv_elements_0_0= ruleExpression ) ) (otherlv_1= Comma ( (lv_elements_2_0= ruleExpression ) ) )* )
            {
            // InternalExprParser.g:3548:1: ( ( (lv_elements_0_0= ruleExpression ) ) (otherlv_1= Comma ( (lv_elements_2_0= ruleExpression ) ) )* )
            // InternalExprParser.g:3548:2: ( (lv_elements_0_0= ruleExpression ) ) (otherlv_1= Comma ( (lv_elements_2_0= ruleExpression ) ) )*
            {
            // InternalExprParser.g:3548:2: ( (lv_elements_0_0= ruleExpression ) )
            // InternalExprParser.g:3549:1: (lv_elements_0_0= ruleExpression )
            {
            // InternalExprParser.g:3549:1: (lv_elements_0_0= ruleExpression )
            // InternalExprParser.g:3550:3: lv_elements_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCommaSeparatedExpressionsAccess().getElementsExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_42);
            lv_elements_0_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCommaSeparatedExpressionsRule());
              	        }
                     		add(
                     			current, 
                     			"elements",
                      		lv_elements_0_0, 
                      		"org.osate.expr.Expr.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalExprParser.g:3566:2: (otherlv_1= Comma ( (lv_elements_2_0= ruleExpression ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==Comma) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalExprParser.g:3567:2: otherlv_1= Comma ( (lv_elements_2_0= ruleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,Comma,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getCommaSeparatedExpressionsAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // InternalExprParser.g:3571:1: ( (lv_elements_2_0= ruleExpression ) )
            	    // InternalExprParser.g:3572:1: (lv_elements_2_0= ruleExpression )
            	    {
            	    // InternalExprParser.g:3572:1: (lv_elements_2_0= ruleExpression )
            	    // InternalExprParser.g:3573:3: lv_elements_2_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCommaSeparatedExpressionsAccess().getElementsExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_42);
            	    lv_elements_2_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getCommaSeparatedExpressionsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_2_0, 
            	              		"org.osate.expr.Expr.Expression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommaSeparatedExpressions"


    // $ANTLR start "entryRuleListLiteral"
    // InternalExprParser.g:3597:1: entryRuleListLiteral returns [EObject current=null] : iv_ruleListLiteral= ruleListLiteral EOF ;
    public final EObject entryRuleListLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListLiteral = null;


        try {
            // InternalExprParser.g:3598:2: (iv_ruleListLiteral= ruleListLiteral EOF )
            // InternalExprParser.g:3599:2: iv_ruleListLiteral= ruleListLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleListLiteral=ruleListLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleListLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListLiteral"


    // $ANTLR start "ruleListLiteral"
    // InternalExprParser.g:3606:1: ruleListLiteral returns [EObject current=null] : ( () otherlv_1= List otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis ) ;
    public final EObject ruleListLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_CommaSeparatedExpressions_3 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3609:28: ( ( () otherlv_1= List otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis ) )
            // InternalExprParser.g:3610:1: ( () otherlv_1= List otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis )
            {
            // InternalExprParser.g:3610:1: ( () otherlv_1= List otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis )
            // InternalExprParser.g:3610:2: () otherlv_1= List otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis
            {
            // InternalExprParser.g:3610:2: ()
            // InternalExprParser.g:3611:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getListLiteralAccess().getListLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,List,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getListLiteralAccess().getListKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,LeftParenthesis,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getListLiteralAccess().getLeftParenthesisKeyword_2());
                  
            }
            // InternalExprParser.g:3626:1: (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==Record||LA43_0==False||(LA43_0>=Tuple && LA43_0<=Union)||LA43_0==List||(LA43_0>=This && LA43_0<=True)||LA43_0==Bag||LA43_0==Map||(LA43_0>=Not && LA43_0<=Set)||LA43_0==If||LA43_0==NumberSign||LA43_0==LeftParenthesis||LA43_0==PlusSign||LA43_0==HyphenMinus||LA43_0==LeftSquareBracket||LA43_0==RULE_REAL_LIT||LA43_0==RULE_INTEGER_LIT||(LA43_0>=RULE_STRING && LA43_0<=RULE_ID)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalExprParser.g:3627:5: this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current]
                    {
                    if ( state.backtracking==0 ) {
                       
                      		if (current==null) {
                      			current = createModelElement(grammarAccess.getListLiteralRule());
                      		}
                              newCompositeNode(grammarAccess.getListLiteralAccess().getCommaSeparatedExpressionsParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_12);
                    this_CommaSeparatedExpressions_3=ruleCommaSeparatedExpressions(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_CommaSeparatedExpressions_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }

            otherlv_4=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getListLiteralAccess().getRightParenthesisKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleListLiteral"


    // $ANTLR start "entryRuleSetLiteral"
    // InternalExprParser.g:3651:1: entryRuleSetLiteral returns [EObject current=null] : iv_ruleSetLiteral= ruleSetLiteral EOF ;
    public final EObject entryRuleSetLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetLiteral = null;


        try {
            // InternalExprParser.g:3652:2: (iv_ruleSetLiteral= ruleSetLiteral EOF )
            // InternalExprParser.g:3653:2: iv_ruleSetLiteral= ruleSetLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSetLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSetLiteral=ruleSetLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetLiteral"


    // $ANTLR start "ruleSetLiteral"
    // InternalExprParser.g:3660:1: ruleSetLiteral returns [EObject current=null] : ( () otherlv_1= Set otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis ) ;
    public final EObject ruleSetLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_CommaSeparatedExpressions_3 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3663:28: ( ( () otherlv_1= Set otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis ) )
            // InternalExprParser.g:3664:1: ( () otherlv_1= Set otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis )
            {
            // InternalExprParser.g:3664:1: ( () otherlv_1= Set otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis )
            // InternalExprParser.g:3664:2: () otherlv_1= Set otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis
            {
            // InternalExprParser.g:3664:2: ()
            // InternalExprParser.g:3665:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getSetLiteralAccess().getSetLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,Set,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSetLiteralAccess().getSetKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,LeftParenthesis,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getSetLiteralAccess().getLeftParenthesisKeyword_2());
                  
            }
            // InternalExprParser.g:3680:1: (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==Record||LA44_0==False||(LA44_0>=Tuple && LA44_0<=Union)||LA44_0==List||(LA44_0>=This && LA44_0<=True)||LA44_0==Bag||LA44_0==Map||(LA44_0>=Not && LA44_0<=Set)||LA44_0==If||LA44_0==NumberSign||LA44_0==LeftParenthesis||LA44_0==PlusSign||LA44_0==HyphenMinus||LA44_0==LeftSquareBracket||LA44_0==RULE_REAL_LIT||LA44_0==RULE_INTEGER_LIT||(LA44_0>=RULE_STRING && LA44_0<=RULE_ID)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalExprParser.g:3681:5: this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current]
                    {
                    if ( state.backtracking==0 ) {
                       
                      		if (current==null) {
                      			current = createModelElement(grammarAccess.getSetLiteralRule());
                      		}
                              newCompositeNode(grammarAccess.getSetLiteralAccess().getCommaSeparatedExpressionsParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_12);
                    this_CommaSeparatedExpressions_3=ruleCommaSeparatedExpressions(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_CommaSeparatedExpressions_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }

            otherlv_4=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getSetLiteralAccess().getRightParenthesisKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetLiteral"


    // $ANTLR start "entryRuleRecordLiteral"
    // InternalExprParser.g:3705:1: entryRuleRecordLiteral returns [EObject current=null] : iv_ruleRecordLiteral= ruleRecordLiteral EOF ;
    public final EObject entryRuleRecordLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordLiteral = null;


        try {
            // InternalExprParser.g:3706:2: (iv_ruleRecordLiteral= ruleRecordLiteral EOF )
            // InternalExprParser.g:3707:2: iv_ruleRecordLiteral= ruleRecordLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRecordLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRecordLiteral=ruleRecordLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRecordLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRecordLiteral"


    // $ANTLR start "ruleRecordLiteral"
    // InternalExprParser.g:3714:1: ruleRecordLiteral returns [EObject current=null] : ( () otherlv_1= Record ) ;
    public final EObject ruleRecordLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:3717:28: ( ( () otherlv_1= Record ) )
            // InternalExprParser.g:3718:1: ( () otherlv_1= Record )
            {
            // InternalExprParser.g:3718:1: ( () otherlv_1= Record )
            // InternalExprParser.g:3718:2: () otherlv_1= Record
            {
            // InternalExprParser.g:3718:2: ()
            // InternalExprParser.g:3719:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRecordLiteralAccess().getRecordLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,Record,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRecordLiteralAccess().getRecordKeyword_1());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRecordLiteral"


    // $ANTLR start "entryRuleUnionLiteral"
    // InternalExprParser.g:3737:1: entryRuleUnionLiteral returns [EObject current=null] : iv_ruleUnionLiteral= ruleUnionLiteral EOF ;
    public final EObject entryRuleUnionLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnionLiteral = null;


        try {
            // InternalExprParser.g:3738:2: (iv_ruleUnionLiteral= ruleUnionLiteral EOF )
            // InternalExprParser.g:3739:2: iv_ruleUnionLiteral= ruleUnionLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnionLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnionLiteral=ruleUnionLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnionLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnionLiteral"


    // $ANTLR start "ruleUnionLiteral"
    // InternalExprParser.g:3746:1: ruleUnionLiteral returns [EObject current=null] : ( () otherlv_1= Union ) ;
    public final EObject ruleUnionLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:3749:28: ( ( () otherlv_1= Union ) )
            // InternalExprParser.g:3750:1: ( () otherlv_1= Union )
            {
            // InternalExprParser.g:3750:1: ( () otherlv_1= Union )
            // InternalExprParser.g:3750:2: () otherlv_1= Union
            {
            // InternalExprParser.g:3750:2: ()
            // InternalExprParser.g:3751:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getUnionLiteralAccess().getUnionLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,Union,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnionLiteralAccess().getUnionKeyword_1());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnionLiteral"


    // $ANTLR start "entryRuleTupleLiteral"
    // InternalExprParser.g:3769:1: entryRuleTupleLiteral returns [EObject current=null] : iv_ruleTupleLiteral= ruleTupleLiteral EOF ;
    public final EObject entryRuleTupleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteral = null;


        try {
            // InternalExprParser.g:3770:2: (iv_ruleTupleLiteral= ruleTupleLiteral EOF )
            // InternalExprParser.g:3771:2: iv_ruleTupleLiteral= ruleTupleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTupleLiteral=ruleTupleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTupleLiteral"


    // $ANTLR start "ruleTupleLiteral"
    // InternalExprParser.g:3778:1: ruleTupleLiteral returns [EObject current=null] : ( () otherlv_1= Tuple otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis ) ;
    public final EObject ruleTupleLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_CommaSeparatedExpressions_3 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3781:28: ( ( () otherlv_1= Tuple otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis ) )
            // InternalExprParser.g:3782:1: ( () otherlv_1= Tuple otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis )
            {
            // InternalExprParser.g:3782:1: ( () otherlv_1= Tuple otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis )
            // InternalExprParser.g:3782:2: () otherlv_1= Tuple otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis
            {
            // InternalExprParser.g:3782:2: ()
            // InternalExprParser.g:3783:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getTupleLiteralAccess().getTupleLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,Tuple,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralAccess().getTupleKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,LeftParenthesis,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getTupleLiteralAccess().getLeftParenthesisKeyword_2());
                  
            }
            // InternalExprParser.g:3798:1: (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==Record||LA45_0==False||(LA45_0>=Tuple && LA45_0<=Union)||LA45_0==List||(LA45_0>=This && LA45_0<=True)||LA45_0==Bag||LA45_0==Map||(LA45_0>=Not && LA45_0<=Set)||LA45_0==If||LA45_0==NumberSign||LA45_0==LeftParenthesis||LA45_0==PlusSign||LA45_0==HyphenMinus||LA45_0==LeftSquareBracket||LA45_0==RULE_REAL_LIT||LA45_0==RULE_INTEGER_LIT||(LA45_0>=RULE_STRING && LA45_0<=RULE_ID)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalExprParser.g:3799:5: this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current]
                    {
                    if ( state.backtracking==0 ) {
                       
                      		if (current==null) {
                      			current = createModelElement(grammarAccess.getTupleLiteralRule());
                      		}
                              newCompositeNode(grammarAccess.getTupleLiteralAccess().getCommaSeparatedExpressionsParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_12);
                    this_CommaSeparatedExpressions_3=ruleCommaSeparatedExpressions(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_CommaSeparatedExpressions_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }

            otherlv_4=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getTupleLiteralAccess().getRightParenthesisKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTupleLiteral"


    // $ANTLR start "entryRuleBagLiteral"
    // InternalExprParser.g:3823:1: entryRuleBagLiteral returns [EObject current=null] : iv_ruleBagLiteral= ruleBagLiteral EOF ;
    public final EObject entryRuleBagLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBagLiteral = null;


        try {
            // InternalExprParser.g:3824:2: (iv_ruleBagLiteral= ruleBagLiteral EOF )
            // InternalExprParser.g:3825:2: iv_ruleBagLiteral= ruleBagLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBagLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBagLiteral=ruleBagLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBagLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBagLiteral"


    // $ANTLR start "ruleBagLiteral"
    // InternalExprParser.g:3832:1: ruleBagLiteral returns [EObject current=null] : ( () otherlv_1= Bag otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis ) ;
    public final EObject ruleBagLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_CommaSeparatedExpressions_3 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3835:28: ( ( () otherlv_1= Bag otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis ) )
            // InternalExprParser.g:3836:1: ( () otherlv_1= Bag otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis )
            {
            // InternalExprParser.g:3836:1: ( () otherlv_1= Bag otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis )
            // InternalExprParser.g:3836:2: () otherlv_1= Bag otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis
            {
            // InternalExprParser.g:3836:2: ()
            // InternalExprParser.g:3837:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getBagLiteralAccess().getBagLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,Bag,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getBagLiteralAccess().getBagKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,LeftParenthesis,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getBagLiteralAccess().getLeftParenthesisKeyword_2());
                  
            }
            // InternalExprParser.g:3852:1: (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==Record||LA46_0==False||(LA46_0>=Tuple && LA46_0<=Union)||LA46_0==List||(LA46_0>=This && LA46_0<=True)||LA46_0==Bag||LA46_0==Map||(LA46_0>=Not && LA46_0<=Set)||LA46_0==If||LA46_0==NumberSign||LA46_0==LeftParenthesis||LA46_0==PlusSign||LA46_0==HyphenMinus||LA46_0==LeftSquareBracket||LA46_0==RULE_REAL_LIT||LA46_0==RULE_INTEGER_LIT||(LA46_0>=RULE_STRING && LA46_0<=RULE_ID)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalExprParser.g:3853:5: this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current]
                    {
                    if ( state.backtracking==0 ) {
                       
                      		if (current==null) {
                      			current = createModelElement(grammarAccess.getBagLiteralRule());
                      		}
                              newCompositeNode(grammarAccess.getBagLiteralAccess().getCommaSeparatedExpressionsParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_12);
                    this_CommaSeparatedExpressions_3=ruleCommaSeparatedExpressions(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_CommaSeparatedExpressions_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }

            otherlv_4=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getBagLiteralAccess().getRightParenthesisKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBagLiteral"


    // $ANTLR start "entryRuleMapLiteral"
    // InternalExprParser.g:3877:1: entryRuleMapLiteral returns [EObject current=null] : iv_ruleMapLiteral= ruleMapLiteral EOF ;
    public final EObject entryRuleMapLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapLiteral = null;


        try {
            // InternalExprParser.g:3878:2: (iv_ruleMapLiteral= ruleMapLiteral EOF )
            // InternalExprParser.g:3879:2: iv_ruleMapLiteral= ruleMapLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMapLiteral=ruleMapLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapLiteral"


    // $ANTLR start "ruleMapLiteral"
    // InternalExprParser.g:3886:1: ruleMapLiteral returns [EObject current=null] : ( () otherlv_1= Map ) ;
    public final EObject ruleMapLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:3889:28: ( ( () otherlv_1= Map ) )
            // InternalExprParser.g:3890:1: ( () otherlv_1= Map )
            {
            // InternalExprParser.g:3890:1: ( () otherlv_1= Map )
            // InternalExprParser.g:3890:2: () otherlv_1= Map
            {
            // InternalExprParser.g:3890:2: ()
            // InternalExprParser.g:3891:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getMapLiteralAccess().getMapLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,Map,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapLiteralAccess().getMapKeyword_1());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapLiteral"


    // $ANTLR start "entryRuleContainedPropertyAssociation"
    // InternalExprParser.g:3911:1: entryRuleContainedPropertyAssociation returns [EObject current=null] : iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF ;
    public final EObject entryRuleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainedPropertyAssociation = null;


        try {
            // InternalExprParser.g:3912:2: (iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF )
            // InternalExprParser.g:3913:2: iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainedPropertyAssociationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleContainedPropertyAssociation=ruleContainedPropertyAssociation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainedPropertyAssociation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainedPropertyAssociation"


    // $ANTLR start "ruleContainedPropertyAssociation"
    // InternalExprParser.g:3920:1: ruleContainedPropertyAssociation returns [EObject current=null] : ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon ) ;
    public final EObject ruleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_append_2_0=null;
        Token lv_constant_3_0=null;
        Token otherlv_5=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        EObject lv_ownedValue_4_0 = null;

        EObject lv_ownedValue_6_0 = null;

        EObject lv_appliesTo_8_0 = null;

        EObject lv_appliesTo_10_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3923:28: ( ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon ) )
            // InternalExprParser.g:3924:1: ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon )
            {
            // InternalExprParser.g:3924:1: ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon )
            // InternalExprParser.g:3924:2: ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon
            {
            // InternalExprParser.g:3924:2: ( ( ruleQPREF ) )
            // InternalExprParser.g:3925:1: ( ruleQPREF )
            {
            // InternalExprParser.g:3925:1: ( ruleQPREF )
            // InternalExprParser.g:3926:3: ruleQPREF
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_43);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalExprParser.g:3940:2: (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==EqualsSignGreaterThanSign) ) {
                alt47=1;
            }
            else if ( (LA47_0==PlusSignEqualsSignGreaterThanSign) ) {
                alt47=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // InternalExprParser.g:3941:2: otherlv_1= EqualsSignGreaterThanSign
                    {
                    otherlv_1=(Token)match(input,EqualsSignGreaterThanSign,FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:3946:6: ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) )
                    {
                    // InternalExprParser.g:3946:6: ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) )
                    // InternalExprParser.g:3947:1: (lv_append_2_0= PlusSignEqualsSignGreaterThanSign )
                    {
                    // InternalExprParser.g:3947:1: (lv_append_2_0= PlusSignEqualsSignGreaterThanSign )
                    // InternalExprParser.g:3948:3: lv_append_2_0= PlusSignEqualsSignGreaterThanSign
                    {
                    lv_append_2_0=(Token)match(input,PlusSignEqualsSignGreaterThanSign,FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_append_2_0, grammarAccess.getContainedPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                      	        }
                             		setWithLastConsumed(current, "append", true, "+=>");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalExprParser.g:3962:3: ( (lv_constant_3_0= Constant ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==Constant) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalExprParser.g:3963:1: (lv_constant_3_0= Constant )
                    {
                    // InternalExprParser.g:3963:1: (lv_constant_3_0= Constant )
                    // InternalExprParser.g:3964:3: lv_constant_3_0= Constant
                    {
                    lv_constant_3_0=(Token)match(input,Constant,FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_constant_3_0, grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                      	        }
                             		setWithLastConsumed(current, "constant", true, "constant");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalExprParser.g:3978:3: ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* )
            // InternalExprParser.g:3978:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            {
            // InternalExprParser.g:3978:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            // InternalExprParser.g:3979:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            {
            // InternalExprParser.g:3979:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            // InternalExprParser.g:3980:3: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0()); 
              	    
            }
            pushFollow(FOLLOW_45);
            lv_ownedValue_4_0=ruleOptionalModalPropertyValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
              	        }
                     		add(
                     			current, 
                     			"ownedValue",
                      		lv_ownedValue_4_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalExprParser.g:3996:2: (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==Comma) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalExprParser.g:3997:2: otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    {
            	    otherlv_5=(Token)match(input,Comma,FOLLOW_44); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0());
            	          
            	    }
            	    // InternalExprParser.g:4001:1: ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    // InternalExprParser.g:4002:1: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    {
            	    // InternalExprParser.g:4002:1: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    // InternalExprParser.g:4003:3: lv_ownedValue_6_0= ruleOptionalModalPropertyValue
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_45);
            	    lv_ownedValue_6_0=ruleOptionalModalPropertyValue();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedValue",
            	              		lv_ownedValue_6_0, 
            	              		"org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);


            }

            // InternalExprParser.g:4019:5: ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==Applies) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalExprParser.g:4020:5: ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )*
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToKeywordsParserRuleCall_4_0()); 
                          
                    }
                    pushFollow(FOLLOW_5);
                    ruleAppliesToKeywords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalExprParser.g:4027:1: ( (lv_appliesTo_8_0= ruleContainmentPath ) )
                    // InternalExprParser.g:4028:1: (lv_appliesTo_8_0= ruleContainmentPath )
                    {
                    // InternalExprParser.g:4028:1: (lv_appliesTo_8_0= ruleContainmentPath )
                    // InternalExprParser.g:4029:3: lv_appliesTo_8_0= ruleContainmentPath
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_46);
                    lv_appliesTo_8_0=ruleContainmentPath();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                      	        }
                             		add(
                             			current, 
                             			"appliesTo",
                              		lv_appliesTo_8_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalExprParser.g:4045:2: (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==Comma) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // InternalExprParser.g:4046:2: otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) )
                    	    {
                    	    otherlv_9=(Token)match(input,Comma,FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_2_0());
                    	          
                    	    }
                    	    // InternalExprParser.g:4050:1: ( (lv_appliesTo_10_0= ruleContainmentPath ) )
                    	    // InternalExprParser.g:4051:1: (lv_appliesTo_10_0= ruleContainmentPath )
                    	    {
                    	    // InternalExprParser.g:4051:1: (lv_appliesTo_10_0= ruleContainmentPath )
                    	    // InternalExprParser.g:4052:3: lv_appliesTo_10_0= ruleContainmentPath
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_46);
                    	    lv_appliesTo_10_0=ruleContainmentPath();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"appliesTo",
                    	              		lv_appliesTo_10_0, 
                    	              		"org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop50;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalExprParser.g:4068:6: ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==In) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalExprParser.g:4069:5: ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingKeywordsParserRuleCall_5_0()); 
                          
                    }
                    pushFollow(FOLLOW_11);
                    ruleInBindingKeywords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_12=(Token)match(input,LeftParenthesis,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getContainedPropertyAssociationAccess().getLeftParenthesisKeyword_5_1());
                          
                    }
                    // InternalExprParser.g:4081:1: ( ( ruleQCREF ) )
                    // InternalExprParser.g:4082:1: ( ruleQCREF )
                    {
                    // InternalExprParser.g:4082:1: ( ruleQCREF )
                    // InternalExprParser.g:4083:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierCrossReference_5_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_12);
                    ruleQCREF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_14=(Token)match(input,RightParenthesis,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getContainedPropertyAssociationAccess().getRightParenthesisKeyword_5_3());
                          
                    }

                    }
                    break;

            }

            otherlv_15=(Token)match(input,Semicolon,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getContainedPropertyAssociationAccess().getSemicolonKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainedPropertyAssociation"


    // $ANTLR start "entryRuleContainmentPath"
    // InternalExprParser.g:4119:1: entryRuleContainmentPath returns [EObject current=null] : iv_ruleContainmentPath= ruleContainmentPath EOF ;
    public final EObject entryRuleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPath = null;


        try {
            // InternalExprParser.g:4120:2: (iv_ruleContainmentPath= ruleContainmentPath EOF )
            // InternalExprParser.g:4121:2: iv_ruleContainmentPath= ruleContainmentPath EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainmentPathRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleContainmentPath=ruleContainmentPath();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainmentPath; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainmentPath"


    // $ANTLR start "ruleContainmentPath"
    // InternalExprParser.g:4128:1: ruleContainmentPath returns [EObject current=null] : ( (lv_path_0_0= ruleContainmentPathElement ) ) ;
    public final EObject ruleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:4131:28: ( ( (lv_path_0_0= ruleContainmentPathElement ) ) )
            // InternalExprParser.g:4132:1: ( (lv_path_0_0= ruleContainmentPathElement ) )
            {
            // InternalExprParser.g:4132:1: ( (lv_path_0_0= ruleContainmentPathElement ) )
            // InternalExprParser.g:4133:1: (lv_path_0_0= ruleContainmentPathElement )
            {
            // InternalExprParser.g:4133:1: (lv_path_0_0= ruleContainmentPathElement )
            // InternalExprParser.g:4134:3: lv_path_0_0= ruleContainmentPathElement
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getContainmentPathAccess().getPathContainmentPathElementParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_path_0_0=ruleContainmentPathElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getContainmentPathRule());
              	        }
                     		set(
                     			current, 
                     			"path",
                      		lv_path_0_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainmentPath"


    // $ANTLR start "entryRuleOptionalModalPropertyValue"
    // InternalExprParser.g:4160:1: entryRuleOptionalModalPropertyValue returns [EObject current=null] : iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF ;
    public final EObject entryRuleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalModalPropertyValue = null;


        try {
            // InternalExprParser.g:4161:2: (iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF )
            // InternalExprParser.g:4162:2: iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOptionalModalPropertyValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOptionalModalPropertyValue=ruleOptionalModalPropertyValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOptionalModalPropertyValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOptionalModalPropertyValue"


    // $ANTLR start "ruleOptionalModalPropertyValue"
    // InternalExprParser.g:4169:1: ruleOptionalModalPropertyValue returns [EObject current=null] : ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? ) ;
    public final EObject ruleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_ownedValue_0_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:4172:28: ( ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? ) )
            // InternalExprParser.g:4173:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? )
            {
            // InternalExprParser.g:4173:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? )
            // InternalExprParser.g:4173:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )?
            {
            // InternalExprParser.g:4173:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalExprParser.g:4174:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalExprParser.g:4174:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalExprParser.g:4175:3: lv_ownedValue_0_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_47);
            lv_ownedValue_0_0=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOptionalModalPropertyValueRule());
              	        }
                     		set(
                     			current, 
                     			"ownedValue",
                      		lv_ownedValue_0_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalExprParser.g:4191:2: ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==In) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==Modes) ) {
                    alt54=1;
                }
            }
            switch (alt54) {
                case 1 :
                    // InternalExprParser.g:4192:5: ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getInModesKeywordsParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_11);
                    ruleInModesKeywords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_2=(Token)match(input,LeftParenthesis,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_1());
                          
                    }
                    // InternalExprParser.g:4204:1: ( (otherlv_3= RULE_ID ) )
                    // InternalExprParser.g:4205:1: (otherlv_3= RULE_ID )
                    {
                    // InternalExprParser.g:4205:1: (otherlv_3= RULE_ID )
                    // InternalExprParser.g:4206:3: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                      	        }
                              
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_3, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_2_0()); 
                      	
                    }

                    }


                    }

                    // InternalExprParser.g:4217:2: (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==Comma) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalExprParser.g:4218:2: otherlv_4= Comma ( (otherlv_5= RULE_ID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_3_0());
                    	          
                    	    }
                    	    // InternalExprParser.g:4222:1: ( (otherlv_5= RULE_ID ) )
                    	    // InternalExprParser.g:4223:1: (otherlv_5= RULE_ID )
                    	    {
                    	    // InternalExprParser.g:4223:1: (otherlv_5= RULE_ID )
                    	    // InternalExprParser.g:4224:3: otherlv_5= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_35); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		newLeafNode(otherlv_5, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_1_0()); 
                    	      	
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getOptionalModalPropertyValueAccess().getRightParenthesisKeyword_1_4());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOptionalModalPropertyValue"


    // $ANTLR start "entryRulePropertyValue"
    // InternalExprParser.g:4248:1: entryRulePropertyValue returns [EObject current=null] : iv_rulePropertyValue= rulePropertyValue EOF ;
    public final EObject entryRulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValue = null;


        try {
            // InternalExprParser.g:4249:2: (iv_rulePropertyValue= rulePropertyValue EOF )
            // InternalExprParser.g:4250:2: iv_rulePropertyValue= rulePropertyValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePropertyValue=rulePropertyValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyValue"


    // $ANTLR start "rulePropertyValue"
    // InternalExprParser.g:4257:1: rulePropertyValue returns [EObject current=null] : ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ;
    public final EObject rulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedValue_0_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:4260:28: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) )
            // InternalExprParser.g:4261:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            {
            // InternalExprParser.g:4261:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalExprParser.g:4262:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalExprParser.g:4262:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalExprParser.g:4263:3: lv_ownedValue_0_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_ownedValue_0_0=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPropertyValueRule());
              	        }
                     		set(
                     			current, 
                     			"ownedValue",
                      		lv_ownedValue_0_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyValue"


    // $ANTLR start "entryRulePropertyExpression"
    // InternalExprParser.g:4287:1: entryRulePropertyExpression returns [EObject current=null] : iv_rulePropertyExpression= rulePropertyExpression EOF ;
    public final EObject entryRulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyExpression = null;


        try {
            // InternalExprParser.g:4288:2: (iv_rulePropertyExpression= rulePropertyExpression EOF )
            // InternalExprParser.g:4289:2: iv_rulePropertyExpression= rulePropertyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePropertyExpression=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyExpression"


    // $ANTLR start "rulePropertyExpression"
    // InternalExprParser.g:4296:1: rulePropertyExpression returns [EObject current=null] : (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm ) ;
    public final EObject rulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RecordTerm_0 = null;

        EObject this_ReferenceTerm_1 = null;

        EObject this_ComponentClassifierTerm_2 = null;

        EObject this_ComputedTerm_3 = null;

        EObject this_StringTerm_4 = null;

        EObject this_NumericRangeTerm_5 = null;

        EObject this_RealTerm_6 = null;

        EObject this_IntegerTerm_7 = null;

        EObject this_ListTerm_8 = null;

        EObject this_BooleanLiteral_9 = null;

        EObject this_LiteralorReferenceTerm_10 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:4299:28: ( (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm ) )
            // InternalExprParser.g:4300:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )
            {
            // InternalExprParser.g:4300:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )
            int alt55=11;
            alt55 = dfa55.predict(input);
            switch (alt55) {
                case 1 :
                    // InternalExprParser.g:4301:5: this_RecordTerm_0= ruleRecordTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRecordTermParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_RecordTerm_0=ruleRecordTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_RecordTerm_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:4311:5: this_ReferenceTerm_1= ruleReferenceTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getReferenceTermParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_ReferenceTerm_1=ruleReferenceTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ReferenceTerm_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:4321:5: this_ComponentClassifierTerm_2= ruleComponentClassifierTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_ComponentClassifierTerm_2=ruleComponentClassifierTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ComponentClassifierTerm_2;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:4331:5: this_ComputedTerm_3= ruleComputedTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComputedTermParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_ComputedTerm_3=ruleComputedTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ComputedTerm_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalExprParser.g:4341:5: this_StringTerm_4= ruleStringTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getStringTermParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_StringTerm_4=ruleStringTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_StringTerm_4;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalExprParser.g:4351:5: this_NumericRangeTerm_5= ruleNumericRangeTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getNumericRangeTermParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_NumericRangeTerm_5=ruleNumericRangeTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_NumericRangeTerm_5;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalExprParser.g:4361:5: this_RealTerm_6= ruleRealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRealTermParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_RealTerm_6=ruleRealTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_RealTerm_6;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalExprParser.g:4371:5: this_IntegerTerm_7= ruleIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getIntegerTermParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_IntegerTerm_7=ruleIntegerTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_IntegerTerm_7;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // InternalExprParser.g:4381:5: this_ListTerm_8= ruleListTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getListTermParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_ListTerm_8=ruleListTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ListTerm_8;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // InternalExprParser.g:4391:5: this_BooleanLiteral_9= ruleBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getBooleanLiteralParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_BooleanLiteral_9=ruleBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_BooleanLiteral_9;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 11 :
                    // InternalExprParser.g:4401:5: this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getLiteralorReferenceTermParserRuleCall_10()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralorReferenceTerm_10=ruleLiteralorReferenceTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_LiteralorReferenceTerm_10;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyExpression"


    // $ANTLR start "entryRuleLiteralorReferenceTerm"
    // InternalExprParser.g:4417:1: entryRuleLiteralorReferenceTerm returns [EObject current=null] : iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF ;
    public final EObject entryRuleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralorReferenceTerm = null;


        try {
            // InternalExprParser.g:4418:2: (iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF )
            // InternalExprParser.g:4419:2: iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralorReferenceTermRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteralorReferenceTerm=ruleLiteralorReferenceTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralorReferenceTerm; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralorReferenceTerm"


    // $ANTLR start "ruleLiteralorReferenceTerm"
    // InternalExprParser.g:4426:1: ruleLiteralorReferenceTerm returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:4429:28: ( ( ( ruleQPREF ) ) )
            // InternalExprParser.g:4430:1: ( ( ruleQPREF ) )
            {
            // InternalExprParser.g:4430:1: ( ( ruleQPREF ) )
            // InternalExprParser.g:4431:1: ( ruleQPREF )
            {
            // InternalExprParser.g:4431:1: ( ruleQPREF )
            // InternalExprParser.g:4432:3: ruleQPREF
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getLiteralorReferenceTermRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAbstractNamedValueCrossReference_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralorReferenceTerm"


    // $ANTLR start "entryRuleBooleanLiteral"
    // InternalExprParser.g:4454:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalExprParser.g:4455:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalExprParser.g:4456:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanLiteral"


    // $ANTLR start "ruleBooleanLiteral"
    // InternalExprParser.g:4463:1: ruleBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:4466:28: ( ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) )
            // InternalExprParser.g:4467:1: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            {
            // InternalExprParser.g:4467:1: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            // InternalExprParser.g:4467:2: () ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            {
            // InternalExprParser.g:4467:2: ()
            // InternalExprParser.g:4468:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // InternalExprParser.g:4473:2: ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==True) ) {
                alt56=1;
            }
            else if ( (LA56_0==False) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // InternalExprParser.g:4473:3: ( (lv_value_1_0= True ) )
                    {
                    // InternalExprParser.g:4473:3: ( (lv_value_1_0= True ) )
                    // InternalExprParser.g:4474:1: (lv_value_1_0= True )
                    {
                    // InternalExprParser.g:4474:1: (lv_value_1_0= True )
                    // InternalExprParser.g:4475:3: lv_value_1_0= True
                    {
                    lv_value_1_0=(Token)match(input,True,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_value_1_0, grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBooleanLiteralRule());
                      	        }
                             		setWithLastConsumed(current, "value", true, "true");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:4491:2: otherlv_2= False
                    {
                    otherlv_2=(Token)match(input,False,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_1());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanLiteral"


    // $ANTLR start "entryRuleConstantValue"
    // InternalExprParser.g:4503:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // InternalExprParser.g:4504:2: (iv_ruleConstantValue= ruleConstantValue EOF )
            // InternalExprParser.g:4505:2: iv_ruleConstantValue= ruleConstantValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstantValue=ruleConstantValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstantValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstantValue"


    // $ANTLR start "ruleConstantValue"
    // InternalExprParser.g:4512:1: ruleConstantValue returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:4515:28: ( ( ( ruleQPREF ) ) )
            // InternalExprParser.g:4516:1: ( ( ruleQPREF ) )
            {
            // InternalExprParser.g:4516:1: ( ( ruleQPREF ) )
            // InternalExprParser.g:4517:1: ( ruleQPREF )
            {
            // InternalExprParser.g:4517:1: ( ruleQPREF )
            // InternalExprParser.g:4518:3: ruleQPREF
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getConstantValueRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstantValueAccess().getNamedValuePropertyConstantCrossReference_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstantValue"


    // $ANTLR start "entryRuleReferenceTerm"
    // InternalExprParser.g:4540:1: entryRuleReferenceTerm returns [EObject current=null] : iv_ruleReferenceTerm= ruleReferenceTerm EOF ;
    public final EObject entryRuleReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceTerm = null;


        try {
            // InternalExprParser.g:4541:2: (iv_ruleReferenceTerm= ruleReferenceTerm EOF )
            // InternalExprParser.g:4542:2: iv_ruleReferenceTerm= ruleReferenceTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceTermRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleReferenceTerm=ruleReferenceTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceTerm; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceTerm"


    // $ANTLR start "ruleReferenceTerm"
    // InternalExprParser.g:4549:1: ruleReferenceTerm returns [EObject current=null] : (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleReferenceTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:4552:28: ( (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis ) )
            // InternalExprParser.g:4553:1: (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis )
            {
            // InternalExprParser.g:4553:1: (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis )
            // InternalExprParser.g:4554:2: otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Reference,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getReferenceTermAccess().getReferenceKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,LeftParenthesis,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalExprParser.g:4563:1: ( (lv_path_2_0= ruleContainmentPathElement ) )
            // InternalExprParser.g:4564:1: (lv_path_2_0= ruleContainmentPathElement )
            {
            // InternalExprParser.g:4564:1: (lv_path_2_0= ruleContainmentPathElement )
            // InternalExprParser.g:4565:3: lv_path_2_0= ruleContainmentPathElement
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReferenceTermAccess().getPathContainmentPathElementParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_12);
            lv_path_2_0=ruleContainmentPathElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getReferenceTermRule());
              	        }
                     		set(
                     			current, 
                     			"path",
                      		lv_path_2_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getReferenceTermAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferenceTerm"


    // $ANTLR start "entryRuleRecordTerm"
    // InternalExprParser.g:4594:1: entryRuleRecordTerm returns [EObject current=null] : iv_ruleRecordTerm= ruleRecordTerm EOF ;
    public final EObject entryRuleRecordTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordTerm = null;


        try {
            // InternalExprParser.g:4595:2: (iv_ruleRecordTerm= ruleRecordTerm EOF )
            // InternalExprParser.g:4596:2: iv_ruleRecordTerm= ruleRecordTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRecordTermRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRecordTerm=ruleRecordTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRecordTerm; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRecordTerm"


    // $ANTLR start "ruleRecordTerm"
    // InternalExprParser.g:4603:1: ruleRecordTerm returns [EObject current=null] : (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket ) ;
    public final EObject ruleRecordTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedFieldValue_1_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:4606:28: ( (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket ) )
            // InternalExprParser.g:4607:1: (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket )
            {
            // InternalExprParser.g:4607:1: (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket )
            // InternalExprParser.g:4608:2: otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket
            {
            otherlv_0=(Token)match(input,LeftSquareBracket,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // InternalExprParser.g:4612:1: ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+
            int cnt57=0;
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==RULE_ID) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalExprParser.g:4613:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    {
            	    // InternalExprParser.g:4613:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    // InternalExprParser.g:4614:3: lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_48);
            	    lv_ownedFieldValue_1_0=ruleFieldPropertyAssociation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRecordTermRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedFieldValue",
            	              		lv_ownedFieldValue_1_0, 
            	              		"org.osate.xtext.aadl2.properties.Properties.FieldPropertyAssociation");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt57 >= 1 ) break loop57;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(57, input);
                        throw eee;
                }
                cnt57++;
            } while (true);

            otherlv_2=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRecordTermAccess().getRightSquareBracketKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRecordTerm"


    // $ANTLR start "entryRuleComputedTerm"
    // InternalExprParser.g:4645:1: entryRuleComputedTerm returns [EObject current=null] : iv_ruleComputedTerm= ruleComputedTerm EOF ;
    public final EObject entryRuleComputedTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComputedTerm = null;


        try {
            // InternalExprParser.g:4646:2: (iv_ruleComputedTerm= ruleComputedTerm EOF )
            // InternalExprParser.g:4647:2: iv_ruleComputedTerm= ruleComputedTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComputedTermRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleComputedTerm=ruleComputedTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComputedTerm; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComputedTerm"


    // $ANTLR start "ruleComputedTerm"
    // InternalExprParser.g:4654:1: ruleComputedTerm returns [EObject current=null] : (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleComputedTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_function_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:4657:28: ( (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis ) )
            // InternalExprParser.g:4658:1: (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis )
            {
            // InternalExprParser.g:4658:1: (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis )
            // InternalExprParser.g:4659:2: otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Compute,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getComputedTermAccess().getComputeKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,LeftParenthesis,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalExprParser.g:4668:1: ( (lv_function_2_0= RULE_ID ) )
            // InternalExprParser.g:4669:1: (lv_function_2_0= RULE_ID )
            {
            // InternalExprParser.g:4669:1: (lv_function_2_0= RULE_ID )
            // InternalExprParser.g:4670:3: lv_function_2_0= RULE_ID
            {
            lv_function_2_0=(Token)match(input,RULE_ID,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_function_2_0, grammarAccess.getComputedTermAccess().getFunctionIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getComputedTermRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"function",
                      		lv_function_2_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ID");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getComputedTermAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComputedTerm"


    // $ANTLR start "entryRuleComponentClassifierTerm"
    // InternalExprParser.g:4699:1: entryRuleComponentClassifierTerm returns [EObject current=null] : iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF ;
    public final EObject entryRuleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentClassifierTerm = null;


        try {
            // InternalExprParser.g:4700:2: (iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF )
            // InternalExprParser.g:4701:2: iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComponentClassifierTermRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleComponentClassifierTerm=ruleComponentClassifierTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComponentClassifierTerm; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponentClassifierTerm"


    // $ANTLR start "ruleComponentClassifierTerm"
    // InternalExprParser.g:4708:1: ruleComponentClassifierTerm returns [EObject current=null] : (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:4711:28: ( (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis ) )
            // InternalExprParser.g:4712:1: (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis )
            {
            // InternalExprParser.g:4712:1: (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis )
            // InternalExprParser.g:4713:2: otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Classifier,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,LeftParenthesis,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalExprParser.g:4722:1: ( ( ruleQCREF ) )
            // InternalExprParser.g:4723:1: ( ruleQCREF )
            {
            // InternalExprParser.g:4723:1: ( ruleQCREF )
            // InternalExprParser.g:4724:3: ruleQCREF
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getComponentClassifierTermRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_12);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getComponentClassifierTermAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponentClassifierTerm"


    // $ANTLR start "entryRuleListTerm"
    // InternalExprParser.g:4751:1: entryRuleListTerm returns [EObject current=null] : iv_ruleListTerm= ruleListTerm EOF ;
    public final EObject entryRuleListTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListTerm = null;


        try {
            // InternalExprParser.g:4752:2: (iv_ruleListTerm= ruleListTerm EOF )
            // InternalExprParser.g:4753:2: iv_ruleListTerm= ruleListTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListTermRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleListTerm=ruleListTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleListTerm; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListTerm"


    // $ANTLR start "ruleListTerm"
    // InternalExprParser.g:4760:1: ruleListTerm returns [EObject current=null] : ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis ) ;
    public final EObject ruleListTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedListElement_2_0 = null;

        EObject lv_ownedListElement_4_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:4763:28: ( ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis ) )
            // InternalExprParser.g:4764:1: ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis )
            {
            // InternalExprParser.g:4764:1: ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis )
            // InternalExprParser.g:4764:2: () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis
            {
            // InternalExprParser.g:4764:2: ()
            // InternalExprParser.g:4765:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getListTermAccess().getListValueAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,LeftParenthesis,FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getListTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalExprParser.g:4775:1: ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==Classifier||LA59_0==Reference||LA59_0==Compute||LA59_0==False||LA59_0==True||LA59_0==LeftParenthesis||LA59_0==PlusSign||LA59_0==HyphenMinus||LA59_0==LeftSquareBracket||LA59_0==RULE_REAL_LIT||LA59_0==RULE_INTEGER_LIT||(LA59_0>=RULE_STRING && LA59_0<=RULE_ID)) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalExprParser.g:4775:2: ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    {
                    // InternalExprParser.g:4775:2: ( (lv_ownedListElement_2_0= rulePropertyExpression ) )
                    // InternalExprParser.g:4776:1: (lv_ownedListElement_2_0= rulePropertyExpression )
                    {
                    // InternalExprParser.g:4776:1: (lv_ownedListElement_2_0= rulePropertyExpression )
                    // InternalExprParser.g:4777:3: lv_ownedListElement_2_0= rulePropertyExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_35);
                    lv_ownedListElement_2_0=rulePropertyExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getListTermRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedListElement",
                              		lv_ownedListElement_2_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalExprParser.g:4793:2: (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==Comma) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // InternalExprParser.g:4794:2: otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,Comma,FOLLOW_44); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getListTermAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // InternalExprParser.g:4798:1: ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    // InternalExprParser.g:4799:1: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    {
                    	    // InternalExprParser.g:4799:1: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    // InternalExprParser.g:4800:3: lv_ownedListElement_4_0= rulePropertyExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_35);
                    	    lv_ownedListElement_4_0=rulePropertyExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getListTermRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedListElement",
                    	              		lv_ownedListElement_4_0, 
                    	              		"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getListTermAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleListTerm"


    // $ANTLR start "entryRuleFieldPropertyAssociation"
    // InternalExprParser.g:4829:1: entryRuleFieldPropertyAssociation returns [EObject current=null] : iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF ;
    public final EObject entryRuleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldPropertyAssociation = null;


        try {
            // InternalExprParser.g:4830:2: (iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF )
            // InternalExprParser.g:4831:2: iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFieldPropertyAssociationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFieldPropertyAssociation=ruleFieldPropertyAssociation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFieldPropertyAssociation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFieldPropertyAssociation"


    // $ANTLR start "ruleFieldPropertyAssociation"
    // InternalExprParser.g:4838:1: ruleFieldPropertyAssociation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon ) ;
    public final EObject ruleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedValue_2_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:4841:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon ) )
            // InternalExprParser.g:4842:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon )
            {
            // InternalExprParser.g:4842:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon )
            // InternalExprParser.g:4842:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon
            {
            // InternalExprParser.g:4842:2: ( (otherlv_0= RULE_ID ) )
            // InternalExprParser.g:4843:1: (otherlv_0= RULE_ID )
            {
            // InternalExprParser.g:4843:1: (otherlv_0= RULE_ID )
            // InternalExprParser.g:4844:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFieldPropertyAssociationRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0()); 
              	
            }

            }


            }

            otherlv_1=(Token)match(input,EqualsSignGreaterThanSign,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // InternalExprParser.g:4860:1: ( (lv_ownedValue_2_0= rulePropertyExpression ) )
            // InternalExprParser.g:4861:1: (lv_ownedValue_2_0= rulePropertyExpression )
            {
            // InternalExprParser.g:4861:1: (lv_ownedValue_2_0= rulePropertyExpression )
            // InternalExprParser.g:4862:3: lv_ownedValue_2_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_19);
            lv_ownedValue_2_0=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFieldPropertyAssociationRule());
              	        }
                     		set(
                     			current, 
                     			"ownedValue",
                      		lv_ownedValue_2_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,Semicolon,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFieldPropertyAssociationAccess().getSemicolonKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFieldPropertyAssociation"


    // $ANTLR start "entryRuleContainmentPathElement"
    // InternalExprParser.g:4891:1: entryRuleContainmentPathElement returns [EObject current=null] : iv_ruleContainmentPathElement= ruleContainmentPathElement EOF ;
    public final EObject entryRuleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPathElement = null;


        try {
            // InternalExprParser.g:4892:2: (iv_ruleContainmentPathElement= ruleContainmentPathElement EOF )
            // InternalExprParser.g:4893:2: iv_ruleContainmentPathElement= ruleContainmentPathElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainmentPathElementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleContainmentPathElement=ruleContainmentPathElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainmentPathElement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainmentPathElement"


    // $ANTLR start "ruleContainmentPathElement"
    // InternalExprParser.g:4900:1: ruleContainmentPathElement returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) ;
    public final EObject ruleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_arrayRange_1_0 = null;

        EObject lv_path_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:4903:28: ( ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) )
            // InternalExprParser.g:4904:1: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            {
            // InternalExprParser.g:4904:1: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            // InternalExprParser.g:4904:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            {
            // InternalExprParser.g:4904:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* )
            // InternalExprParser.g:4904:3: ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )*
            {
            // InternalExprParser.g:4904:3: ( (otherlv_0= RULE_ID ) )
            // InternalExprParser.g:4905:1: (otherlv_0= RULE_ID )
            {
            // InternalExprParser.g:4905:1: (otherlv_0= RULE_ID )
            // InternalExprParser.g:4906:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getContainmentPathElementRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0_0()); 
              	
            }

            }


            }

            // InternalExprParser.g:4917:2: ( (lv_arrayRange_1_0= ruleArrayRange ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==LeftSquareBracket) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalExprParser.g:4918:1: (lv_arrayRange_1_0= ruleArrayRange )
            	    {
            	    // InternalExprParser.g:4918:1: (lv_arrayRange_1_0= ruleArrayRange )
            	    // InternalExprParser.g:4919:3: lv_arrayRange_1_0= ruleArrayRange
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_51);
            	    lv_arrayRange_1_0=ruleArrayRange();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getContainmentPathElementRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"arrayRange",
            	              		lv_arrayRange_1_0, 
            	              		"org.osate.xtext.aadl2.properties.Properties.ArrayRange");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);


            }

            // InternalExprParser.g:4935:4: (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==FullStop) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalExprParser.g:4936:2: otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) )
                    {
                    otherlv_2=(Token)match(input,FullStop,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getFullStopKeyword_1_0());
                          
                    }
                    // InternalExprParser.g:4940:1: ( (lv_path_3_0= ruleContainmentPathElement ) )
                    // InternalExprParser.g:4941:1: (lv_path_3_0= ruleContainmentPathElement )
                    {
                    // InternalExprParser.g:4941:1: (lv_path_3_0= ruleContainmentPathElement )
                    // InternalExprParser.g:4942:3: lv_path_3_0= ruleContainmentPathElement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getPathContainmentPathElementParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_path_3_0=ruleContainmentPathElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getContainmentPathElementRule());
                      	        }
                             		set(
                             			current, 
                             			"path",
                              		lv_path_3_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainmentPathElement"


    // $ANTLR start "entryRulePlusMinus"
    // InternalExprParser.g:4968:1: entryRulePlusMinus returns [String current=null] : iv_rulePlusMinus= rulePlusMinus EOF ;
    public final String entryRulePlusMinus() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePlusMinus = null;


        try {
            // InternalExprParser.g:4969:1: (iv_rulePlusMinus= rulePlusMinus EOF )
            // InternalExprParser.g:4970:2: iv_rulePlusMinus= rulePlusMinus EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPlusMinusRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePlusMinus=rulePlusMinus();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePlusMinus.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlusMinus"


    // $ANTLR start "rulePlusMinus"
    // InternalExprParser.g:4977:1: rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= PlusSign | kw= HyphenMinus ) ;
    public final AntlrDatatypeRuleToken rulePlusMinus() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:4981:6: ( (kw= PlusSign | kw= HyphenMinus ) )
            // InternalExprParser.g:4982:1: (kw= PlusSign | kw= HyphenMinus )
            {
            // InternalExprParser.g:4982:1: (kw= PlusSign | kw= HyphenMinus )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==PlusSign) ) {
                alt62=1;
            }
            else if ( (LA62_0==HyphenMinus) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // InternalExprParser.g:4983:2: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:4990:2: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPlusMinusAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlusMinus"


    // $ANTLR start "entryRuleStringTerm"
    // InternalExprParser.g:5003:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // InternalExprParser.g:5004:2: (iv_ruleStringTerm= ruleStringTerm EOF )
            // InternalExprParser.g:5005:2: iv_ruleStringTerm= ruleStringTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringTermRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStringTerm=ruleStringTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringTerm; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringTerm"


    // $ANTLR start "ruleStringTerm"
    // InternalExprParser.g:5012:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:5015:28: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // InternalExprParser.g:5016:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // InternalExprParser.g:5016:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            // InternalExprParser.g:5017:1: (lv_value_0_0= ruleNoQuoteString )
            {
            // InternalExprParser.g:5017:1: (lv_value_0_0= ruleNoQuoteString )
            // InternalExprParser.g:5018:3: lv_value_0_0= ruleNoQuoteString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getStringTermRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.NoQuoteString");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringTerm"


    // $ANTLR start "entryRuleNoQuoteString"
    // InternalExprParser.g:5042:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // InternalExprParser.g:5043:1: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // InternalExprParser.g:5044:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNoQuoteStringRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNoQuoteString=ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNoQuoteString.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNoQuoteString"


    // $ANTLR start "ruleNoQuoteString"
    // InternalExprParser.g:5051:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:5055:6: (this_STRING_0= RULE_STRING )
            // InternalExprParser.g:5056:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_STRING_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_STRING_0, grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNoQuoteString"


    // $ANTLR start "entryRuleArrayRange"
    // InternalExprParser.g:5071:1: entryRuleArrayRange returns [EObject current=null] : iv_ruleArrayRange= ruleArrayRange EOF ;
    public final EObject entryRuleArrayRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRange = null;


        try {
            // InternalExprParser.g:5072:2: (iv_ruleArrayRange= ruleArrayRange EOF )
            // InternalExprParser.g:5073:2: iv_ruleArrayRange= ruleArrayRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayRangeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArrayRange=ruleArrayRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayRange; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrayRange"


    // $ANTLR start "ruleArrayRange"
    // InternalExprParser.g:5080:1: ruleArrayRange returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket ) ;
    public final EObject ruleArrayRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_lowerBound_2_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_4_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:5083:28: ( ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket ) )
            // InternalExprParser.g:5084:1: ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket )
            {
            // InternalExprParser.g:5084:1: ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket )
            // InternalExprParser.g:5084:2: () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket
            {
            // InternalExprParser.g:5084:2: ()
            // InternalExprParser.g:5085:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getArrayRangeAccess().getArrayRangeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_52); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // InternalExprParser.g:5095:1: ( (lv_lowerBound_2_0= ruleINTVALUE ) )
            // InternalExprParser.g:5096:1: (lv_lowerBound_2_0= ruleINTVALUE )
            {
            // InternalExprParser.g:5096:1: (lv_lowerBound_2_0= ruleINTVALUE )
            // InternalExprParser.g:5097:3: lv_lowerBound_2_0= ruleINTVALUE
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_53);
            lv_lowerBound_2_0=ruleINTVALUE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getArrayRangeRule());
              	        }
                     		set(
                     			current, 
                     			"lowerBound",
                      		lv_lowerBound_2_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalExprParser.g:5113:2: (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==FullStopFullStop) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalExprParser.g:5114:2: otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    {
                    otherlv_3=(Token)match(input,FullStopFullStop,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
                          
                    }
                    // InternalExprParser.g:5118:1: ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    // InternalExprParser.g:5119:1: (lv_upperBound_4_0= ruleINTVALUE )
                    {
                    // InternalExprParser.g:5119:1: (lv_upperBound_4_0= ruleINTVALUE )
                    // InternalExprParser.g:5120:3: lv_upperBound_4_0= ruleINTVALUE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getArrayRangeAccess().getUpperBoundINTVALUEParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_38);
                    lv_upperBound_4_0=ruleINTVALUE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getArrayRangeRule());
                      	        }
                             		set(
                             			current, 
                             			"upperBound",
                              		lv_upperBound_4_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getArrayRangeAccess().getRightSquareBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrayRange"


    // $ANTLR start "entryRuleSignedConstant"
    // InternalExprParser.g:5149:1: entryRuleSignedConstant returns [EObject current=null] : iv_ruleSignedConstant= ruleSignedConstant EOF ;
    public final EObject entryRuleSignedConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedConstant = null;


        try {
            // InternalExprParser.g:5150:2: (iv_ruleSignedConstant= ruleSignedConstant EOF )
            // InternalExprParser.g:5151:2: iv_ruleSignedConstant= ruleSignedConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSignedConstantRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSignedConstant=ruleSignedConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSignedConstant; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSignedConstant"


    // $ANTLR start "ruleSignedConstant"
    // InternalExprParser.g:5158:1: ruleSignedConstant returns [EObject current=null] : ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) ;
    public final EObject ruleSignedConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:5161:28: ( ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) )
            // InternalExprParser.g:5162:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            {
            // InternalExprParser.g:5162:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            // InternalExprParser.g:5162:2: ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            {
            // InternalExprParser.g:5162:2: ( (lv_op_0_0= rulePlusMinus ) )
            // InternalExprParser.g:5163:1: (lv_op_0_0= rulePlusMinus )
            {
            // InternalExprParser.g:5163:1: (lv_op_0_0= rulePlusMinus )
            // InternalExprParser.g:5164:3: lv_op_0_0= rulePlusMinus
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_54);
            lv_op_0_0=rulePlusMinus();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSignedConstantRule());
              	        }
                     		set(
                     			current, 
                     			"op",
                      		lv_op_0_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.PlusMinus");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalExprParser.g:5180:2: ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            // InternalExprParser.g:5181:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            {
            // InternalExprParser.g:5181:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            // InternalExprParser.g:5182:3: lv_ownedPropertyExpression_1_0= ruleConstantValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionConstantValueParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_ownedPropertyExpression_1_0=ruleConstantValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSignedConstantRule());
              	        }
                     		add(
                     			current, 
                     			"ownedPropertyExpression",
                      		lv_ownedPropertyExpression_1_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ConstantValue");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSignedConstant"


    // $ANTLR start "entryRuleIntegerTerm"
    // InternalExprParser.g:5206:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // InternalExprParser.g:5207:2: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // InternalExprParser.g:5208:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegerTermRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIntegerTerm=ruleIntegerTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntegerTerm; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerTerm"


    // $ANTLR start "ruleIntegerTerm"
    // InternalExprParser.g:5215:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:5218:28: ( ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalExprParser.g:5219:1: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalExprParser.g:5219:1: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalExprParser.g:5219:2: ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalExprParser.g:5219:2: ( (lv_value_0_0= ruleSignedInt ) )
            // InternalExprParser.g:5220:1: (lv_value_0_0= ruleSignedInt )
            {
            // InternalExprParser.g:5220:1: (lv_value_0_0= ruleSignedInt )
            // InternalExprParser.g:5221:3: lv_value_0_0= ruleSignedInt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_55);
            lv_value_0_0=ruleSignedInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIntegerTermRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.SignedInt");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalExprParser.g:5237:2: ( (otherlv_1= RULE_ID ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==RULE_ID) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalExprParser.g:5238:1: (otherlv_1= RULE_ID )
                    {
                    // InternalExprParser.g:5238:1: (otherlv_1= RULE_ID )
                    // InternalExprParser.g:5239:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getIntegerTermRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_1, grammarAccess.getIntegerTermAccess().getUnitUnitLiteralCrossReference_1_0()); 
                      	
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerTerm"


    // $ANTLR start "entryRuleSignedInt"
    // InternalExprParser.g:5258:1: entryRuleSignedInt returns [String current=null] : iv_ruleSignedInt= ruleSignedInt EOF ;
    public final String entryRuleSignedInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInt = null;


        try {
            // InternalExprParser.g:5259:1: (iv_ruleSignedInt= ruleSignedInt EOF )
            // InternalExprParser.g:5260:2: iv_ruleSignedInt= ruleSignedInt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSignedIntRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSignedInt=ruleSignedInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSignedInt.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSignedInt"


    // $ANTLR start "ruleSignedInt"
    // InternalExprParser.g:5267:1: ruleSignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INTEGER_LIT_2=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:5271:6: ( ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) )
            // InternalExprParser.g:5272:1: ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            {
            // InternalExprParser.g:5272:1: ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            // InternalExprParser.g:5272:2: (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT
            {
            // InternalExprParser.g:5272:2: (kw= PlusSign | kw= HyphenMinus )?
            int alt65=3;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==PlusSign) ) {
                alt65=1;
            }
            else if ( (LA65_0==HyphenMinus) ) {
                alt65=2;
            }
            switch (alt65) {
                case 1 :
                    // InternalExprParser.g:5273:2: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:5280:2: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignedIntAccess().getHyphenMinusKeyword_0_1()); 
                          
                    }

                    }
                    break;

            }

            this_INTEGER_LIT_2=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INTEGER_LIT_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INTEGER_LIT_2, grammarAccess.getSignedIntAccess().getINTEGER_LITTerminalRuleCall_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSignedInt"


    // $ANTLR start "entryRuleRealTerm"
    // InternalExprParser.g:5300:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // InternalExprParser.g:5301:2: (iv_ruleRealTerm= ruleRealTerm EOF )
            // InternalExprParser.g:5302:2: iv_ruleRealTerm= ruleRealTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealTermRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRealTerm=ruleRealTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealTerm; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRealTerm"


    // $ANTLR start "ruleRealTerm"
    // InternalExprParser.g:5309:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:5312:28: ( ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalExprParser.g:5313:1: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalExprParser.g:5313:1: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalExprParser.g:5313:2: ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalExprParser.g:5313:2: ( (lv_value_0_0= ruleSignedReal ) )
            // InternalExprParser.g:5314:1: (lv_value_0_0= ruleSignedReal )
            {
            // InternalExprParser.g:5314:1: (lv_value_0_0= ruleSignedReal )
            // InternalExprParser.g:5315:3: lv_value_0_0= ruleSignedReal
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_55);
            lv_value_0_0=ruleSignedReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRealTermRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.SignedReal");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalExprParser.g:5331:2: ( (otherlv_1= RULE_ID ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_ID) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalExprParser.g:5332:1: (otherlv_1= RULE_ID )
                    {
                    // InternalExprParser.g:5332:1: (otherlv_1= RULE_ID )
                    // InternalExprParser.g:5333:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getRealTermRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_1, grammarAccess.getRealTermAccess().getUnitUnitLiteralCrossReference_1_0()); 
                      	
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRealTerm"


    // $ANTLR start "entryRuleSignedReal"
    // InternalExprParser.g:5352:1: entryRuleSignedReal returns [String current=null] : iv_ruleSignedReal= ruleSignedReal EOF ;
    public final String entryRuleSignedReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedReal = null;


        try {
            // InternalExprParser.g:5353:1: (iv_ruleSignedReal= ruleSignedReal EOF )
            // InternalExprParser.g:5354:2: iv_ruleSignedReal= ruleSignedReal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSignedRealRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSignedReal=ruleSignedReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSignedReal.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSignedReal"


    // $ANTLR start "ruleSignedReal"
    // InternalExprParser.g:5361:1: ruleSignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_REAL_LIT_2=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:5365:6: ( ( (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT ) )
            // InternalExprParser.g:5366:1: ( (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT )
            {
            // InternalExprParser.g:5366:1: ( (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT )
            // InternalExprParser.g:5366:2: (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT
            {
            // InternalExprParser.g:5366:2: (kw= PlusSign | kw= HyphenMinus )?
            int alt67=3;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==PlusSign) ) {
                alt67=1;
            }
            else if ( (LA67_0==HyphenMinus) ) {
                alt67=2;
            }
            switch (alt67) {
                case 1 :
                    // InternalExprParser.g:5367:2: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FOLLOW_56); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:5374:2: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FOLLOW_56); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignedRealAccess().getHyphenMinusKeyword_0_1()); 
                          
                    }

                    }
                    break;

            }

            this_REAL_LIT_2=(Token)match(input,RULE_REAL_LIT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_REAL_LIT_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_REAL_LIT_2, grammarAccess.getSignedRealAccess().getREAL_LITTerminalRuleCall_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSignedReal"


    // $ANTLR start "entryRuleNumericRangeTerm"
    // InternalExprParser.g:5394:1: entryRuleNumericRangeTerm returns [EObject current=null] : iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF ;
    public final EObject entryRuleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericRangeTerm = null;


        try {
            // InternalExprParser.g:5395:2: (iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF )
            // InternalExprParser.g:5396:2: iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericRangeTermRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNumericRangeTerm=ruleNumericRangeTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericRangeTerm; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericRangeTerm"


    // $ANTLR start "ruleNumericRangeTerm"
    // InternalExprParser.g:5403:1: ruleNumericRangeTerm returns [EObject current=null] : ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? ) ;
    public final EObject ruleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_minimum_0_0 = null;

        EObject lv_maximum_2_0 = null;

        EObject lv_delta_4_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:5406:28: ( ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? ) )
            // InternalExprParser.g:5407:1: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            {
            // InternalExprParser.g:5407:1: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            // InternalExprParser.g:5407:2: ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )?
            {
            // InternalExprParser.g:5407:2: ( (lv_minimum_0_0= ruleNumAlt ) )
            // InternalExprParser.g:5408:1: (lv_minimum_0_0= ruleNumAlt )
            {
            // InternalExprParser.g:5408:1: (lv_minimum_0_0= ruleNumAlt )
            // InternalExprParser.g:5409:3: lv_minimum_0_0= ruleNumAlt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_36);
            lv_minimum_0_0=ruleNumAlt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
              	        }
                     		set(
                     			current, 
                     			"minimum",
                      		lv_minimum_0_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.NumAlt");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,FullStopFullStop,FOLLOW_54); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1());
                  
            }
            // InternalExprParser.g:5430:1: ( (lv_maximum_2_0= ruleNumAlt ) )
            // InternalExprParser.g:5431:1: (lv_maximum_2_0= ruleNumAlt )
            {
            // InternalExprParser.g:5431:1: (lv_maximum_2_0= ruleNumAlt )
            // InternalExprParser.g:5432:3: lv_maximum_2_0= ruleNumAlt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_57);
            lv_maximum_2_0=ruleNumAlt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
              	        }
                     		set(
                     			current, 
                     			"maximum",
                      		lv_maximum_2_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.NumAlt");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalExprParser.g:5448:2: (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==Delta) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalExprParser.g:5449:2: otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) )
                    {
                    otherlv_3=(Token)match(input,Delta,FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0());
                          
                    }
                    // InternalExprParser.g:5453:1: ( (lv_delta_4_0= ruleNumAlt ) )
                    // InternalExprParser.g:5454:1: (lv_delta_4_0= ruleNumAlt )
                    {
                    // InternalExprParser.g:5454:1: (lv_delta_4_0= ruleNumAlt )
                    // InternalExprParser.g:5455:3: lv_delta_4_0= ruleNumAlt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getDeltaNumAltParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_delta_4_0=ruleNumAlt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
                      	        }
                             		set(
                             			current, 
                             			"delta",
                              		lv_delta_4_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.NumAlt");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericRangeTerm"


    // $ANTLR start "entryRuleNumAlt"
    // InternalExprParser.g:5479:1: entryRuleNumAlt returns [EObject current=null] : iv_ruleNumAlt= ruleNumAlt EOF ;
    public final EObject entryRuleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumAlt = null;


        try {
            // InternalExprParser.g:5480:2: (iv_ruleNumAlt= ruleNumAlt EOF )
            // InternalExprParser.g:5481:2: iv_ruleNumAlt= ruleNumAlt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumAltRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNumAlt=ruleNumAlt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumAlt; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumAlt"


    // $ANTLR start "ruleNumAlt"
    // InternalExprParser.g:5488:1: ruleNumAlt returns [EObject current=null] : (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) ;
    public final EObject ruleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject this_RealTerm_0 = null;

        EObject this_IntegerTerm_1 = null;

        EObject this_SignedConstant_2 = null;

        EObject this_ConstantValue_3 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:5491:28: ( (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) )
            // InternalExprParser.g:5492:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            {
            // InternalExprParser.g:5492:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            int alt69=4;
            switch ( input.LA(1) ) {
            case PlusSign:
                {
                switch ( input.LA(2) ) {
                case RULE_REAL_LIT:
                    {
                    alt69=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt69=2;
                    }
                    break;
                case RULE_ID:
                    {
                    alt69=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 1, input);

                    throw nvae;
                }

                }
                break;
            case HyphenMinus:
                {
                switch ( input.LA(2) ) {
                case RULE_REAL_LIT:
                    {
                    alt69=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt69=2;
                    }
                    break;
                case RULE_ID:
                    {
                    alt69=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 2, input);

                    throw nvae;
                }

                }
                break;
            case RULE_REAL_LIT:
                {
                alt69=1;
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt69=2;
                }
                break;
            case RULE_ID:
                {
                alt69=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // InternalExprParser.g:5493:5: this_RealTerm_0= ruleRealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumAltAccess().getRealTermParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_RealTerm_0=ruleRealTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_RealTerm_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:5503:5: this_IntegerTerm_1= ruleIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumAltAccess().getIntegerTermParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_IntegerTerm_1=ruleIntegerTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_IntegerTerm_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:5513:5: this_SignedConstant_2= ruleSignedConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumAltAccess().getSignedConstantParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_SignedConstant_2=ruleSignedConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_SignedConstant_2;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:5523:5: this_ConstantValue_3= ruleConstantValue
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumAltAccess().getConstantValueParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_ConstantValue_3=ruleConstantValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ConstantValue_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumAlt"


    // $ANTLR start "entryRuleAppliesToKeywords"
    // InternalExprParser.g:5539:1: entryRuleAppliesToKeywords returns [String current=null] : iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF ;
    public final String entryRuleAppliesToKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAppliesToKeywords = null;


        try {
            // InternalExprParser.g:5540:1: (iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF )
            // InternalExprParser.g:5541:2: iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAppliesToKeywordsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAppliesToKeywords=ruleAppliesToKeywords();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAppliesToKeywords.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAppliesToKeywords"


    // $ANTLR start "ruleAppliesToKeywords"
    // InternalExprParser.g:5548:1: ruleAppliesToKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Applies kw= To ) ;
    public final AntlrDatatypeRuleToken ruleAppliesToKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:5552:6: ( (kw= Applies kw= To ) )
            // InternalExprParser.g:5553:1: (kw= Applies kw= To )
            {
            // InternalExprParser.g:5553:1: (kw= Applies kw= To )
            // InternalExprParser.g:5554:2: kw= Applies kw= To
            {
            kw=(Token)match(input,Applies,FOLLOW_58); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getAppliesToKeywordsAccess().getAppliesKeyword_0()); 
                  
            }
            kw=(Token)match(input,To,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getAppliesToKeywordsAccess().getToKeyword_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAppliesToKeywords"


    // $ANTLR start "entryRuleInBindingKeywords"
    // InternalExprParser.g:5573:1: entryRuleInBindingKeywords returns [String current=null] : iv_ruleInBindingKeywords= ruleInBindingKeywords EOF ;
    public final String entryRuleInBindingKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInBindingKeywords = null;


        try {
            // InternalExprParser.g:5574:1: (iv_ruleInBindingKeywords= ruleInBindingKeywords EOF )
            // InternalExprParser.g:5575:2: iv_ruleInBindingKeywords= ruleInBindingKeywords EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInBindingKeywordsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInBindingKeywords=ruleInBindingKeywords();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInBindingKeywords.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInBindingKeywords"


    // $ANTLR start "ruleInBindingKeywords"
    // InternalExprParser.g:5582:1: ruleInBindingKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= In kw= Binding ) ;
    public final AntlrDatatypeRuleToken ruleInBindingKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:5586:6: ( (kw= In kw= Binding ) )
            // InternalExprParser.g:5587:1: (kw= In kw= Binding )
            {
            // InternalExprParser.g:5587:1: (kw= In kw= Binding )
            // InternalExprParser.g:5588:2: kw= In kw= Binding
            {
            kw=(Token)match(input,In,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getInBindingKeywordsAccess().getInKeyword_0()); 
                  
            }
            kw=(Token)match(input,Binding,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getInBindingKeywordsAccess().getBindingKeyword_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInBindingKeywords"


    // $ANTLR start "entryRuleInModesKeywords"
    // InternalExprParser.g:5607:1: entryRuleInModesKeywords returns [String current=null] : iv_ruleInModesKeywords= ruleInModesKeywords EOF ;
    public final String entryRuleInModesKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInModesKeywords = null;


        try {
            // InternalExprParser.g:5608:1: (iv_ruleInModesKeywords= ruleInModesKeywords EOF )
            // InternalExprParser.g:5609:2: iv_ruleInModesKeywords= ruleInModesKeywords EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInModesKeywordsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInModesKeywords=ruleInModesKeywords();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInModesKeywords.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInModesKeywords"


    // $ANTLR start "ruleInModesKeywords"
    // InternalExprParser.g:5616:1: ruleInModesKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= In kw= Modes ) ;
    public final AntlrDatatypeRuleToken ruleInModesKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:5620:6: ( (kw= In kw= Modes ) )
            // InternalExprParser.g:5621:1: (kw= In kw= Modes )
            {
            // InternalExprParser.g:5621:1: (kw= In kw= Modes )
            // InternalExprParser.g:5622:2: kw= In kw= Modes
            {
            kw=(Token)match(input,In,FOLLOW_60); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getInModesKeywordsAccess().getInKeyword_0()); 
                  
            }
            kw=(Token)match(input,Modes,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getInModesKeywordsAccess().getModesKeyword_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInModesKeywords"


    // $ANTLR start "entryRuleINTVALUE"
    // InternalExprParser.g:5641:1: entryRuleINTVALUE returns [String current=null] : iv_ruleINTVALUE= ruleINTVALUE EOF ;
    public final String entryRuleINTVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTVALUE = null;


        try {
            // InternalExprParser.g:5642:1: (iv_ruleINTVALUE= ruleINTVALUE EOF )
            // InternalExprParser.g:5643:2: iv_ruleINTVALUE= ruleINTVALUE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getINTVALUERule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleINTVALUE=ruleINTVALUE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleINTVALUE.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleINTVALUE"


    // $ANTLR start "ruleINTVALUE"
    // InternalExprParser.g:5650:1: ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleINTVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:5654:6: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // InternalExprParser.g:5655:5: this_INTEGER_LIT_0= RULE_INTEGER_LIT
            {
            this_INTEGER_LIT_0=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INTEGER_LIT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INTEGER_LIT_0, grammarAccess.getINTVALUEAccess().getINTEGER_LITTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleINTVALUE"


    // $ANTLR start "entryRuleQPREF"
    // InternalExprParser.g:5672:1: entryRuleQPREF returns [String current=null] : iv_ruleQPREF= ruleQPREF EOF ;
    public final String entryRuleQPREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQPREF = null;


        try {
            // InternalExprParser.g:5673:1: (iv_ruleQPREF= ruleQPREF EOF )
            // InternalExprParser.g:5674:2: iv_ruleQPREF= ruleQPREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQPREFRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQPREF=ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQPREF.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQPREF"


    // $ANTLR start "ruleQPREF"
    // InternalExprParser.g:5681:1: ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQPREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:5685:6: ( (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? ) )
            // InternalExprParser.g:5686:1: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? )
            {
            // InternalExprParser.g:5686:1: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? )
            // InternalExprParser.g:5686:6: this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_61); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // InternalExprParser.g:5693:1: (kw= ColonColon this_ID_2= RULE_ID )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==ColonColon) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalExprParser.g:5694:2: kw= ColonColon this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,ColonColon,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQPREFAccess().getColonColonKeyword_1_0()); 
                          
                    }
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_2, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_1_1()); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQPREF"


    // $ANTLR start "entryRuleQCREF"
    // InternalExprParser.g:5714:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // InternalExprParser.g:5715:1: (iv_ruleQCREF= ruleQCREF EOF )
            // InternalExprParser.g:5716:2: iv_ruleQCREF= ruleQCREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQCREFRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQCREF=ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQCREF.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQCREF"


    // $ANTLR start "ruleQCREF"
    // InternalExprParser.g:5723:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:5727:6: ( ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) )
            // InternalExprParser.g:5728:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            {
            // InternalExprParser.g:5728:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            // InternalExprParser.g:5728:2: (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )?
            {
            // InternalExprParser.g:5728:2: (this_ID_0= RULE_ID kw= ColonColon )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==RULE_ID) ) {
                    int LA71_1 = input.LA(2);

                    if ( (LA71_1==ColonColon) ) {
                        alt71=1;
                    }


                }


                switch (alt71) {
            	case 1 :
            	    // InternalExprParser.g:5728:7: this_ID_0= RULE_ID kw= ColonColon
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_62); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); 
            	          
            	    }
            	    kw=(Token)match(input,ColonColon,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); 
                  
            }
            // InternalExprParser.g:5748:1: (kw= FullStop this_ID_4= RULE_ID )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==FullStop) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalExprParser.g:5749:2: kw= FullStop this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,FullStop,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQCREFAccess().getFullStopKeyword_2_0()); 
                          
                    }
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_4);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_4, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_2_1()); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQCREF"


    // $ANTLR start "entryRuleSTAR"
    // InternalExprParser.g:5769:1: entryRuleSTAR returns [String current=null] : iv_ruleSTAR= ruleSTAR EOF ;
    public final String entryRuleSTAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTAR = null;


        try {
            // InternalExprParser.g:5770:1: (iv_ruleSTAR= ruleSTAR EOF )
            // InternalExprParser.g:5771:2: iv_ruleSTAR= ruleSTAR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSTARRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSTAR=ruleSTAR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSTAR.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSTAR"


    // $ANTLR start "ruleSTAR"
    // InternalExprParser.g:5778:1: ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= Asterisk ;
    public final AntlrDatatypeRuleToken ruleSTAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:5782:6: (kw= Asterisk )
            // InternalExprParser.g:5784:2: kw= Asterisk
            {
            kw=(Token)match(input,Asterisk,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getSTARAccess().getAsteriskKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSTAR"


    // $ANTLR start "ruleMetaClassEnum"
    // InternalExprParser.g:5797:1: ruleMetaClassEnum returns [Enumerator current=null] : ( (enumLiteral_0= Component ) | (enumLiteral_1= Subcomponent ) | (enumLiteral_2= Feature ) | (enumLiteral_3= Connection ) | (enumLiteral_4= Flow ) | (enumLiteral_5= Mode ) ) ;
    public final Enumerator ruleMetaClassEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;

         enterRule(); 
        try {
            // InternalExprParser.g:5799:28: ( ( (enumLiteral_0= Component ) | (enumLiteral_1= Subcomponent ) | (enumLiteral_2= Feature ) | (enumLiteral_3= Connection ) | (enumLiteral_4= Flow ) | (enumLiteral_5= Mode ) ) )
            // InternalExprParser.g:5800:1: ( (enumLiteral_0= Component ) | (enumLiteral_1= Subcomponent ) | (enumLiteral_2= Feature ) | (enumLiteral_3= Connection ) | (enumLiteral_4= Flow ) | (enumLiteral_5= Mode ) )
            {
            // InternalExprParser.g:5800:1: ( (enumLiteral_0= Component ) | (enumLiteral_1= Subcomponent ) | (enumLiteral_2= Feature ) | (enumLiteral_3= Connection ) | (enumLiteral_4= Flow ) | (enumLiteral_5= Mode ) )
            int alt73=6;
            switch ( input.LA(1) ) {
            case Component:
                {
                alt73=1;
                }
                break;
            case Subcomponent:
                {
                alt73=2;
                }
                break;
            case Feature:
                {
                alt73=3;
                }
                break;
            case Connection:
                {
                alt73=4;
                }
                break;
            case Flow:
                {
                alt73=5;
                }
                break;
            case Mode:
                {
                alt73=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // InternalExprParser.g:5800:2: (enumLiteral_0= Component )
                    {
                    // InternalExprParser.g:5800:2: (enumLiteral_0= Component )
                    // InternalExprParser.g:5800:7: enumLiteral_0= Component
                    {
                    enumLiteral_0=(Token)match(input,Component,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMetaClassEnumAccess().getCOMPONENTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getMetaClassEnumAccess().getCOMPONENTEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:5806:6: (enumLiteral_1= Subcomponent )
                    {
                    // InternalExprParser.g:5806:6: (enumLiteral_1= Subcomponent )
                    // InternalExprParser.g:5806:11: enumLiteral_1= Subcomponent
                    {
                    enumLiteral_1=(Token)match(input,Subcomponent,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMetaClassEnumAccess().getSUBCOMPONENTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getMetaClassEnumAccess().getSUBCOMPONENTEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalExprParser.g:5812:6: (enumLiteral_2= Feature )
                    {
                    // InternalExprParser.g:5812:6: (enumLiteral_2= Feature )
                    // InternalExprParser.g:5812:11: enumLiteral_2= Feature
                    {
                    enumLiteral_2=(Token)match(input,Feature,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMetaClassEnumAccess().getFEATUREEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getMetaClassEnumAccess().getFEATUREEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalExprParser.g:5818:6: (enumLiteral_3= Connection )
                    {
                    // InternalExprParser.g:5818:6: (enumLiteral_3= Connection )
                    // InternalExprParser.g:5818:11: enumLiteral_3= Connection
                    {
                    enumLiteral_3=(Token)match(input,Connection,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMetaClassEnumAccess().getCONNECTIONEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getMetaClassEnumAccess().getCONNECTIONEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalExprParser.g:5824:6: (enumLiteral_4= Flow )
                    {
                    // InternalExprParser.g:5824:6: (enumLiteral_4= Flow )
                    // InternalExprParser.g:5824:11: enumLiteral_4= Flow
                    {
                    enumLiteral_4=(Token)match(input,Flow,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMetaClassEnumAccess().getFLOWEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getMetaClassEnumAccess().getFLOWEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalExprParser.g:5830:6: (enumLiteral_5= Mode )
                    {
                    // InternalExprParser.g:5830:6: (enumLiteral_5= Mode )
                    // InternalExprParser.g:5830:11: enumLiteral_5= Mode
                    {
                    enumLiteral_5=(Token)match(input,Mode,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMetaClassEnumAccess().getMODEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getMetaClassEnumAccess().getMODEEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMetaClassEnum"

    // $ANTLR start synpred1_InternalExprParser
    public final void synpred1_InternalExprParser_fragment() throws RecognitionException {   
        // InternalExprParser.g:1699:3: ( ( () ( ( ruleOpOr ) ) ) )
        // InternalExprParser.g:1699:4: ( () ( ( ruleOpOr ) ) )
        {
        // InternalExprParser.g:1699:4: ( () ( ( ruleOpOr ) ) )
        // InternalExprParser.g:1699:5: () ( ( ruleOpOr ) )
        {
        // InternalExprParser.g:1699:5: ()
        // InternalExprParser.g:1700:1: 
        {
        }

        // InternalExprParser.g:1700:2: ( ( ruleOpOr ) )
        // InternalExprParser.g:1701:1: ( ruleOpOr )
        {
        // InternalExprParser.g:1701:1: ( ruleOpOr )
        // InternalExprParser.g:1702:1: ruleOpOr
        {
        pushFollow(FOLLOW_2);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalExprParser

    // $ANTLR start synpred2_InternalExprParser
    public final void synpred2_InternalExprParser_fragment() throws RecognitionException {   
        // InternalExprParser.g:1811:3: ( ( () ( ( ruleOpAnd ) ) ) )
        // InternalExprParser.g:1811:4: ( () ( ( ruleOpAnd ) ) )
        {
        // InternalExprParser.g:1811:4: ( () ( ( ruleOpAnd ) ) )
        // InternalExprParser.g:1811:5: () ( ( ruleOpAnd ) )
        {
        // InternalExprParser.g:1811:5: ()
        // InternalExprParser.g:1812:1: 
        {
        }

        // InternalExprParser.g:1812:2: ( ( ruleOpAnd ) )
        // InternalExprParser.g:1813:1: ( ruleOpAnd )
        {
        // InternalExprParser.g:1813:1: ( ruleOpAnd )
        // InternalExprParser.g:1814:1: ruleOpAnd
        {
        pushFollow(FOLLOW_2);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalExprParser

    // $ANTLR start synpred3_InternalExprParser
    public final void synpred3_InternalExprParser_fragment() throws RecognitionException {   
        // InternalExprParser.g:1923:3: ( ( () ( ( ruleOpEquality ) ) ) )
        // InternalExprParser.g:1923:4: ( () ( ( ruleOpEquality ) ) )
        {
        // InternalExprParser.g:1923:4: ( () ( ( ruleOpEquality ) ) )
        // InternalExprParser.g:1923:5: () ( ( ruleOpEquality ) )
        {
        // InternalExprParser.g:1923:5: ()
        // InternalExprParser.g:1924:1: 
        {
        }

        // InternalExprParser.g:1924:2: ( ( ruleOpEquality ) )
        // InternalExprParser.g:1925:1: ( ruleOpEquality )
        {
        // InternalExprParser.g:1925:1: ( ruleOpEquality )
        // InternalExprParser.g:1926:1: ruleOpEquality
        {
        pushFollow(FOLLOW_2);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalExprParser

    // $ANTLR start synpred4_InternalExprParser
    public final void synpred4_InternalExprParser_fragment() throws RecognitionException {   
        // InternalExprParser.g:2035:3: ( ( () ( ( ruleOpCompare ) ) ) )
        // InternalExprParser.g:2035:4: ( () ( ( ruleOpCompare ) ) )
        {
        // InternalExprParser.g:2035:4: ( () ( ( ruleOpCompare ) ) )
        // InternalExprParser.g:2035:5: () ( ( ruleOpCompare ) )
        {
        // InternalExprParser.g:2035:5: ()
        // InternalExprParser.g:2036:1: 
        {
        }

        // InternalExprParser.g:2036:2: ( ( ruleOpCompare ) )
        // InternalExprParser.g:2037:1: ( ruleOpCompare )
        {
        // InternalExprParser.g:2037:1: ( ruleOpCompare )
        // InternalExprParser.g:2038:1: ruleOpCompare
        {
        pushFollow(FOLLOW_2);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalExprParser

    // $ANTLR start synpred5_InternalExprParser
    public final void synpred5_InternalExprParser_fragment() throws RecognitionException {   
        // InternalExprParser.g:2168:3: ( ( () ( ( ruleOpAdd ) ) ) )
        // InternalExprParser.g:2168:4: ( () ( ( ruleOpAdd ) ) )
        {
        // InternalExprParser.g:2168:4: ( () ( ( ruleOpAdd ) ) )
        // InternalExprParser.g:2168:5: () ( ( ruleOpAdd ) )
        {
        // InternalExprParser.g:2168:5: ()
        // InternalExprParser.g:2169:1: 
        {
        }

        // InternalExprParser.g:2169:2: ( ( ruleOpAdd ) )
        // InternalExprParser.g:2170:1: ( ruleOpAdd )
        {
        // InternalExprParser.g:2170:1: ( ruleOpAdd )
        // InternalExprParser.g:2171:1: ruleOpAdd
        {
        pushFollow(FOLLOW_2);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred5_InternalExprParser

    // $ANTLR start synpred6_InternalExprParser
    public final void synpred6_InternalExprParser_fragment() throws RecognitionException {   
        // InternalExprParser.g:2280:3: ( ( () ( ( ruleOpMulti ) ) ) )
        // InternalExprParser.g:2280:4: ( () ( ( ruleOpMulti ) ) )
        {
        // InternalExprParser.g:2280:4: ( () ( ( ruleOpMulti ) ) )
        // InternalExprParser.g:2280:5: () ( ( ruleOpMulti ) )
        {
        // InternalExprParser.g:2280:5: ()
        // InternalExprParser.g:2281:1: 
        {
        }

        // InternalExprParser.g:2281:2: ( ( ruleOpMulti ) )
        // InternalExprParser.g:2282:1: ( ruleOpMulti )
        {
        // InternalExprParser.g:2282:1: ( ruleOpMulti )
        // InternalExprParser.g:2283:1: ruleOpMulti
        {
        pushFollow(FOLLOW_2);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred6_InternalExprParser

    // $ANTLR start synpred8_InternalExprParser
    public final void synpred8_InternalExprParser_fragment() throws RecognitionException {   
        // InternalExprParser.g:2744:3: ( ( () NumberSign ) )
        // InternalExprParser.g:2744:4: ( () NumberSign )
        {
        // InternalExprParser.g:2744:4: ( () NumberSign )
        // InternalExprParser.g:2744:5: () NumberSign
        {
        // InternalExprParser.g:2744:5: ()
        // InternalExprParser.g:2745:1: 
        {
        }

        match(input,NumberSign,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_InternalExprParser

    // $ANTLR start synpred9_InternalExprParser
    public final void synpred9_InternalExprParser_fragment() throws RecognitionException {   
        // InternalExprParser.g:3090:4: ( Delta )
        // InternalExprParser.g:3091:1: Delta
        {
        match(input,Delta,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_InternalExprParser

    // Delegated rules

    public final boolean synpred2_InternalExprParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalExprParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalExprParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalExprParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalExprParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalExprParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalExprParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalExprParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalExprParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalExprParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalExprParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalExprParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalExprParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalExprParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalExprParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalExprParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA12 dfa12 = new DFA12(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA55 dfa55 = new DFA55(this);
    static final String dfa_1s = "\22\uffff";
    static final String dfa_2s = "\10\uffff\1\15\1\uffff\1\17\7\uffff";
    static final String dfa_3s = "\1\7\7\uffff\1\4\1\uffff\1\4\1\11\6\uffff";
    static final String dfa_4s = "\1\64\7\uffff\1\152\1\uffff\1\152\1\64\6\uffff";
    static final String dfa_5s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\2\uffff\1\11\1\10\1\13\1\14\1\15\1\16";
    static final String dfa_6s = "\22\uffff}>";
    static final String[] dfa_7s = {
            "\1\10\1\uffff\1\7\2\uffff\1\1\7\uffff\1\6\1\13\1\uffff\1\4\1\5\2\uffff\1\11\1\12\10\uffff\1\3\16\uffff\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\6\15\2\uffff\1\15\5\uffff\1\15\1\uffff\2\15\1\uffff\6\15\3\uffff\1\14\1\uffff\4\15\1\uffff\4\15\10\uffff\2\15\2\uffff\2\15\2\uffff\1\15\4\uffff\1\15\30\uffff\1\15\1\uffff\1\15\4\uffff\1\15\11\uffff\1\15",
            "",
            "\6\17\2\uffff\1\17\5\uffff\1\17\1\uffff\2\17\1\uffff\6\17\3\uffff\1\16\1\uffff\4\17\1\uffff\4\17\10\uffff\2\17\2\uffff\2\17\2\uffff\1\17\4\uffff\1\17\30\uffff\1\17\1\uffff\1\17\4\uffff\1\17\11\uffff\1\17",
            "\1\21\52\uffff\1\20",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "885:1: (kw= Abstract | kw= Bus | kw= Data | kw= Device | kw= Memory | kw= Process | kw= Processor | kw= Subprogram | (kw= Subprogram kw= Group ) | kw= KW_System | (kw= Thread kw= Group ) | kw= Thread | (kw= Virtual kw= Bus ) | (kw= Virtual kw= Processor ) )";
        }
    }
    static final String dfa_8s = "\14\uffff";
    static final String dfa_9s = "\1\uffff\1\10\11\uffff\1\10";
    static final String dfa_10s = "\1\31\1\35\5\uffff\1\152\1\uffff\1\152\1\uffff\1\35";
    static final String dfa_11s = "\2\152\5\uffff\1\152\1\uffff\1\152\1\uffff\1\152";
    static final String dfa_12s = "\2\uffff\1\2\1\4\1\5\1\6\1\7\1\uffff\1\1\1\uffff\1\3\1\uffff";
    static final String dfa_13s = "\14\uffff}>";
    static final String[] dfa_14s = {
            "\1\5\5\uffff\1\5\2\uffff\2\5\4\uffff\1\5\4\uffff\1\2\1\5\4\uffff\1\5\4\uffff\1\5\2\uffff\1\5\14\uffff\1\4\5\uffff\1\2\1\uffff\1\6\14\uffff\1\3\7\uffff\1\5\1\uffff\1\5\1\uffff\1\5\1\1",
            "\2\10\7\uffff\1\10\5\uffff\1\10\5\uffff\1\10\3\uffff\1\10\2\uffff\1\10\4\uffff\2\10\1\uffff\1\10\1\11\2\10\1\uffff\2\10\1\uffff\1\10\1\uffff\1\10\1\uffff\1\10\1\uffff\1\10\1\12\5\10\1\7\1\10\1\uffff\2\10\1\uffff\1\10\1\uffff\1\10\13\uffff\1\10",
            "",
            "",
            "",
            "",
            "",
            "\1\13",
            "",
            "\1\1",
            "",
            "\2\10\7\uffff\1\10\5\uffff\1\10\5\uffff\1\10\3\uffff\1\10\2\uffff\1\10\4\uffff\2\10\1\uffff\1\10\1\uffff\2\10\1\uffff\2\10\1\uffff\1\10\1\uffff\1\10\1\uffff\1\10\1\uffff\1\10\1\12\5\10\1\uffff\1\10\1\uffff\2\10\1\uffff\1\10\1\uffff\1\10\13\uffff\1\10"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "2598:1: (this_VarRef_0= ruleVarRef | this_ModelOrPropertyReference_1= ruleModelOrPropertyReference | this_FunctionCall_2= ruleFunctionCall | this_RangeExpression_3= ruleRangeExpression | this_IfExpression_4= ruleIfExpression | this_Literal_5= ruleLiteral | (otherlv_6= LeftParenthesis this_Expression_7= ruleExpression otherlv_8= RightParenthesis ) )";
        }
    }
    static final String dfa_15s = "\25\uffff";
    static final String dfa_16s = "\10\uffff\1\17\1\21\1\23\3\uffff\1\17\1\uffff\1\21\3\uffff\1\23";
    static final String dfa_17s = "\1\5\5\uffff\2\145\3\16\3\uffff\1\16\1\uffff\1\16\1\uffff\1\152\1\uffff\1\16";
    static final String dfa_18s = "\1\152\5\uffff\4\152\1\131\3\uffff\1\131\1\uffff\1\131\1\uffff\1\152\1\uffff\1\131";
    static final String dfa_19s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\5\uffff\1\11\1\12\1\6\1\uffff\1\7\1\uffff\1\10\1\uffff\1\13\1\uffff";
    static final String dfa_20s = "\25\uffff}>";
    static final String[] dfa_21s = {
            "\1\3\4\uffff\1\2\5\uffff\1\4\16\uffff\1\14\16\uffff\1\14\41\uffff\1\13\2\uffff\1\6\1\uffff\1\7\7\uffff\1\1\7\uffff\1\10\1\uffff\1\11\1\uffff\1\5\1\12",
            "",
            "",
            "",
            "",
            "",
            "\1\10\1\uffff\1\11\2\uffff\1\15",
            "\1\10\1\uffff\1\11\2\uffff\1\15",
            "\1\17\62\uffff\1\15\7\uffff\1\17\7\uffff\1\17\2\uffff\1\17\4\uffff\1\17\20\uffff\1\16",
            "\1\21\62\uffff\1\15\7\uffff\1\21\7\uffff\1\21\2\uffff\1\21\4\uffff\1\21\20\uffff\1\20",
            "\1\23\62\uffff\1\15\1\22\6\uffff\1\23\7\uffff\1\23\2\uffff\1\23\4\uffff\1\23",
            "",
            "",
            "",
            "\1\17\62\uffff\1\15\7\uffff\1\17\7\uffff\1\17\2\uffff\1\17\4\uffff\1\17",
            "",
            "\1\21\62\uffff\1\15\7\uffff\1\21\7\uffff\1\21\2\uffff\1\21\4\uffff\1\21",
            "",
            "\1\24",
            "",
            "\1\23\62\uffff\1\15\7\uffff\1\23\7\uffff\1\23\2\uffff\1\23\4\uffff\1\23"
    };

    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final char[] dfa_18 = DFA.unpackEncodedStringToUnsignedChars(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[][] dfa_21 = unpackEncodedStringArray(dfa_21s);

    class DFA55 extends DFA {

        public DFA55(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 55;
            this.eot = dfa_15;
            this.eof = dfa_16;
            this.min = dfa_17;
            this.max = dfa_18;
            this.accept = dfa_19;
            this.special = dfa_20;
            this.transition = dfa_21;
        }
        public String getDescription() {
            return "4300:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x3020800000400000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x099807BC1FB413F0L,0x0000040000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000002L,0x0000000009000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0D9867BC9FB413F0L,0x000006A020294100L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000040100000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x099807BC1FB413F0L,0x0000040100000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002800L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x8004000000000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x4000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000002L,0x00000000140000C8L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000002L,0x0000000000280000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0240000000000002L,0x0000000000840000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000002L,0x0000040000008200L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0D9867BC9FB413F0L,0x000006A0202B4100L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000000000120000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000020000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000004040000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0001000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000400080012420L,0x000006A020290000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000004000L,0x0000000002100200L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000002100200L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000040040000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000400080012420L,0x000006A0202B0000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000002L,0x0000000020400000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x000004A000280000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000002L,0x0000040000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});

}