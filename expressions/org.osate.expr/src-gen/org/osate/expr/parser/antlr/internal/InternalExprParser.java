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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Classifier", "Connection", "Subprogram", "Component", "Processor", "Reference", "Subclause", "Abstract", "Constant", "Property", "Applies", "Binding", "Compute", "Element", "Feature", "Library", "Process", "Virtual", "Assert", "Device", "Memory", "Record", "String", "KW_System", "Thread", "Delta", "Endif", "False", "Group", "Modes", "Range", "Tuple", "Union", "Bool", "Data", "Else", "Enum", "Flow", "List", "Mode", "Real", "Root", "Then", "True", "Type", "PlusSignEqualsSignGreaterThanSign", "QuestionMarkQuestionMarkQuestionMark", "And", "Bag", "Bus", "Def", "Div", "Int", "Map", "Mod", "Not", "Set", "Val", "Var", "ExclamationMarkEqualsSign", "AmpersandAmpersand", "HyphenMinusGreaterThanSign", "FullStopFullStop", "ColonColon", "LessThanSignEqualsSign", "EqualsSignEqualsSign", "EqualsSignGreaterThanSign", "GreaterThanSignLessThanSign", "GreaterThanSignEqualsSign", "If", "In", "Of", "Or", "To", "VerticalLineVerticalLine", "NumberSign", "PercentSign", "LeftParenthesis", "RightParenthesis", "Asterisk", "PlusSign", "Comma", "HyphenMinus", "FullStop", "Solidus", "Colon", "Semicolon", "LessThanSign", "EqualsSign", "GreaterThanSign", "LeftSquareBracket", "RightSquareBracket", "CircumflexAccent", "LeftCurlyBracket", "RightCurlyBracket", "RULE_SL_COMMENT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_REAL_LIT", "RULE_BASED_INTEGER", "RULE_INTEGER_LIT", "RULE_EXTENDED_DIGIT", "RULE_STRING", "RULE_ID", "RULE_WS"
    };
    public static final int Enum=40;
    public static final int Val=61;
    public static final int Or=76;
    public static final int EqualsSignGreaterThanSign=70;
    public static final int Memory=24;
    public static final int KW_System=27;
    public static final int Var=62;
    public static final int String=26;
    public static final int False=31;
    public static final int Feature=18;
    public static final int LessThanSign=91;
    public static final int Assert=22;
    public static final int PlusSignEqualsSignGreaterThanSign=49;
    public static final int LeftParenthesis=81;
    public static final int Bool=37;
    public static final int Then=46;
    public static final int GreaterThanSign=93;
    public static final int Root=45;
    public static final int RULE_ID=108;
    public static final int RULE_DIGIT=100;
    public static final int GreaterThanSignEqualsSign=72;
    public static final int ColonColon=67;
    public static final int EqualsSignEqualsSign=69;
    public static final int PlusSign=84;
    public static final int LeftSquareBracket=94;
    public static final int Map=57;
    public static final int If=73;
    public static final int Group=32;
    public static final int Processor=8;
    public static final int Set=60;
    public static final int In=74;
    public static final int VerticalLineVerticalLine=78;
    public static final int RULE_REAL_LIT=103;
    public static final int Classifier=4;
    public static final int GreaterThanSignLessThanSign=71;
    public static final int Union=36;
    public static final int Comma=85;
    public static final int HyphenMinus=86;
    public static final int LessThanSignEqualsSign=68;
    public static final int Solidus=88;
    public static final int RightCurlyBracket=98;
    public static final int Property=13;
    public static final int Modes=33;
    public static final int Bus=53;
    public static final int FullStop=87;
    public static final int Reference=9;
    public static final int Abstract=11;
    public static final int Connection=5;
    public static final int Thread=28;
    public static final int Flow=41;
    public static final int Div=55;
    public static final int Semicolon=90;
    public static final int Type=48;
    public static final int RULE_EXPONENT=101;
    public static final int Delta=29;
    public static final int Else=39;
    public static final int RULE_EXTENDED_DIGIT=106;
    public static final int ExclamationMarkEqualsSign=63;
    public static final int HyphenMinusGreaterThanSign=65;
    public static final int Tuple=35;
    public static final int True=47;
    public static final int Process=20;
    public static final int RULE_INT_EXPONENT=102;
    public static final int PercentSign=80;
    public static final int FullStopFullStop=66;
    public static final int Real=44;
    public static final int QuestionMarkQuestionMarkQuestionMark=50;
    public static final int List=42;
    public static final int To=77;
    public static final int Applies=14;
    public static final int RULE_BASED_INTEGER=104;
    public static final int RightSquareBracket=95;
    public static final int Binding=15;
    public static final int Device=23;
    public static final int RightParenthesis=82;
    public static final int Range=34;
    public static final int Not=59;
    public static final int And=51;
    public static final int NumberSign=79;
    public static final int Library=19;
    public static final int Subprogram=6;
    public static final int RULE_INTEGER_LIT=105;
    public static final int Subclause=10;
    public static final int Constant=12;
    public static final int Element=17;
    public static final int RULE_STRING=107;
    public static final int Int=56;
    public static final int RULE_SL_COMMENT=99;
    public static final int EqualsSign=92;
    public static final int AmpersandAmpersand=64;
    public static final int Record=25;
    public static final int Colon=89;
    public static final int Component=7;
    public static final int EOF=-1;
    public static final int Asterisk=83;
    public static final int Mod=58;
    public static final int Def=54;
    public static final int RULE_WS=109;
    public static final int Endif=30;
    public static final int Mode=43;
    public static final int LeftCurlyBracket=97;
    public static final int Bag=52;
    public static final int Virtual=21;
    public static final int Data=38;
    public static final int CircumflexAccent=96;
    public static final int Compute=16;
    public static final int Of=75;

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
    // InternalExprParser.g:405:1: ruleVarDecl returns [EObject current=null] : ( ( ( (lv_const_0_0= Val ) ) | otherlv_1= Var ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_declType_4_0= ruleType ) ) )? (otherlv_5= EqualsSign ( (lv_value_6_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVarDecl() throws RecognitionException {
        EObject current = null;

        Token lv_const_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_declType_4_0 = null;

        EObject lv_value_6_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:408:28: ( ( ( ( (lv_const_0_0= Val ) ) | otherlv_1= Var ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_declType_4_0= ruleType ) ) )? (otherlv_5= EqualsSign ( (lv_value_6_0= ruleExpression ) ) )? ) )
            // InternalExprParser.g:409:1: ( ( ( (lv_const_0_0= Val ) ) | otherlv_1= Var ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_declType_4_0= ruleType ) ) )? (otherlv_5= EqualsSign ( (lv_value_6_0= ruleExpression ) ) )? )
            {
            // InternalExprParser.g:409:1: ( ( ( (lv_const_0_0= Val ) ) | otherlv_1= Var ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_declType_4_0= ruleType ) ) )? (otherlv_5= EqualsSign ( (lv_value_6_0= ruleExpression ) ) )? )
            // InternalExprParser.g:409:2: ( ( (lv_const_0_0= Val ) ) | otherlv_1= Var ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_declType_4_0= ruleType ) ) )? (otherlv_5= EqualsSign ( (lv_value_6_0= ruleExpression ) ) )?
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

            // InternalExprParser.g:449:2: (otherlv_3= Colon ( (lv_declType_4_0= ruleType ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==Colon) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalExprParser.g:450:2: otherlv_3= Colon ( (lv_declType_4_0= ruleType ) )
                    {
                    otherlv_3=(Token)match(input,Colon,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getVarDeclAccess().getColonKeyword_2_0());
                          
                    }
                    // InternalExprParser.g:454:1: ( (lv_declType_4_0= ruleType ) )
                    // InternalExprParser.g:455:1: (lv_declType_4_0= ruleType )
                    {
                    // InternalExprParser.g:455:1: (lv_declType_4_0= ruleType )
                    // InternalExprParser.g:456:3: lv_declType_4_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVarDeclAccess().getDeclTypeTypeParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_9);
                    lv_declType_4_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVarDeclRule());
                      	        }
                             		set(
                             			current, 
                             			"declType",
                              		lv_declType_4_0, 
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
    // InternalExprParser.g:633:1: ruleType returns [EObject current=null] : (this_PrimitiveType_0= rulePrimitiveType | this_RangeType_1= ruleRangeType | this_Category_2= ruleCategory | this_MetaClass_3= ruleMetaClass | this_RecordType_4= ruleRecordType | this_UnionType_5= ruleUnionType | this_TupleType_6= ruleTupleType | this_ListType_7= ruleListType | this_SetType_8= ruleSetType | this_BagType_9= ruleBagType | this_MapType_10= ruleMapType | this_EnumType_11= ruleEnumType | this_TypeRef_12= ruleTypeRef ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveType_0 = null;

        EObject this_RangeType_1 = null;

        EObject this_Category_2 = null;

        EObject this_MetaClass_3 = null;

        EObject this_RecordType_4 = null;

        EObject this_UnionType_5 = null;

        EObject this_TupleType_6 = null;

        EObject this_ListType_7 = null;

        EObject this_SetType_8 = null;

        EObject this_BagType_9 = null;

        EObject this_MapType_10 = null;

        EObject this_EnumType_11 = null;

        EObject this_TypeRef_12 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:636:28: ( (this_PrimitiveType_0= rulePrimitiveType | this_RangeType_1= ruleRangeType | this_Category_2= ruleCategory | this_MetaClass_3= ruleMetaClass | this_RecordType_4= ruleRecordType | this_UnionType_5= ruleUnionType | this_TupleType_6= ruleTupleType | this_ListType_7= ruleListType | this_SetType_8= ruleSetType | this_BagType_9= ruleBagType | this_MapType_10= ruleMapType | this_EnumType_11= ruleEnumType | this_TypeRef_12= ruleTypeRef ) )
            // InternalExprParser.g:637:1: (this_PrimitiveType_0= rulePrimitiveType | this_RangeType_1= ruleRangeType | this_Category_2= ruleCategory | this_MetaClass_3= ruleMetaClass | this_RecordType_4= ruleRecordType | this_UnionType_5= ruleUnionType | this_TupleType_6= ruleTupleType | this_ListType_7= ruleListType | this_SetType_8= ruleSetType | this_BagType_9= ruleBagType | this_MapType_10= ruleMapType | this_EnumType_11= ruleEnumType | this_TypeRef_12= ruleTypeRef )
            {
            // InternalExprParser.g:637:1: (this_PrimitiveType_0= rulePrimitiveType | this_RangeType_1= ruleRangeType | this_Category_2= ruleCategory | this_MetaClass_3= ruleMetaClass | this_RecordType_4= ruleRecordType | this_UnionType_5= ruleUnionType | this_TupleType_6= ruleTupleType | this_ListType_7= ruleListType | this_SetType_8= ruleSetType | this_BagType_9= ruleBagType | this_MapType_10= ruleMapType | this_EnumType_11= ruleEnumType | this_TypeRef_12= ruleTypeRef )
            int alt10=13;
            switch ( input.LA(1) ) {
            case String:
            case Bool:
            case Real:
            case Int:
                {
                alt10=1;
                }
                break;
            case Range:
                {
                alt10=2;
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
                alt10=3;
                }
                break;
            case Connection:
            case Component:
            case Property:
            case Feature:
            case Flow:
            case Mode:
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
            case Enum:
                {
                alt10=12;
                }
                break;
            case RULE_ID:
                {
                alt10=13;
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
                    // InternalExprParser.g:648:5: this_RangeType_1= ruleRangeType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAccess().getRangeTypeParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_RangeType_1=ruleRangeType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_RangeType_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:658:5: this_Category_2= ruleCategory
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAccess().getCategoryParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Category_2=ruleCategory();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_Category_2;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:668:5: this_MetaClass_3= ruleMetaClass
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAccess().getMetaClassParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_MetaClass_3=ruleMetaClass();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_MetaClass_3;
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
                    // InternalExprParser.g:748:5: this_EnumType_11= ruleEnumType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAccess().getEnumTypeParserRuleCall_11()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_EnumType_11=ruleEnumType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_EnumType_11;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 13 :
                    // InternalExprParser.g:758:5: this_TypeRef_12= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAccess().getTypeRefParserRuleCall_12()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_TypeRef_12=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_TypeRef_12;
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
    // InternalExprParser.g:774:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalExprParser.g:775:2: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalExprParser.g:776:2: iv_rulePrimitiveType= rulePrimitiveType EOF
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
    // InternalExprParser.g:783:1: rulePrimitiveType returns [EObject current=null] : ( ( () otherlv_1= Bool ) | ( () otherlv_3= Int ) | ( () otherlv_5= Real ) | ( () otherlv_7= String ) ) ;
    public final EObject rulePrimitiveType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:786:28: ( ( ( () otherlv_1= Bool ) | ( () otherlv_3= Int ) | ( () otherlv_5= Real ) | ( () otherlv_7= String ) ) )
            // InternalExprParser.g:787:1: ( ( () otherlv_1= Bool ) | ( () otherlv_3= Int ) | ( () otherlv_5= Real ) | ( () otherlv_7= String ) )
            {
            // InternalExprParser.g:787:1: ( ( () otherlv_1= Bool ) | ( () otherlv_3= Int ) | ( () otherlv_5= Real ) | ( () otherlv_7= String ) )
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
                    // InternalExprParser.g:787:2: ( () otherlv_1= Bool )
                    {
                    // InternalExprParser.g:787:2: ( () otherlv_1= Bool )
                    // InternalExprParser.g:787:3: () otherlv_1= Bool
                    {
                    // InternalExprParser.g:787:3: ()
                    // InternalExprParser.g:788:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimitiveTypeAccess().getEBooleanAction_0_0(),
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
                    // InternalExprParser.g:799:6: ( () otherlv_3= Int )
                    {
                    // InternalExprParser.g:799:6: ( () otherlv_3= Int )
                    // InternalExprParser.g:799:7: () otherlv_3= Int
                    {
                    // InternalExprParser.g:799:7: ()
                    // InternalExprParser.g:800:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimitiveTypeAccess().getEIntegerAction_1_0(),
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
                    // InternalExprParser.g:811:6: ( () otherlv_5= Real )
                    {
                    // InternalExprParser.g:811:6: ( () otherlv_5= Real )
                    // InternalExprParser.g:811:7: () otherlv_5= Real
                    {
                    // InternalExprParser.g:811:7: ()
                    // InternalExprParser.g:812:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimitiveTypeAccess().getERealAction_2_0(),
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
                    // InternalExprParser.g:823:6: ( () otherlv_7= String )
                    {
                    // InternalExprParser.g:823:6: ( () otherlv_7= String )
                    // InternalExprParser.g:823:7: () otherlv_7= String
                    {
                    // InternalExprParser.g:823:7: ()
                    // InternalExprParser.g:824:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimitiveTypeAccess().getEStringAction_3_0(),
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


    // $ANTLR start "entryRuleRangeType"
    // InternalExprParser.g:842:1: entryRuleRangeType returns [EObject current=null] : iv_ruleRangeType= ruleRangeType EOF ;
    public final EObject entryRuleRangeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeType = null;


        try {
            // InternalExprParser.g:843:2: (iv_ruleRangeType= ruleRangeType EOF )
            // InternalExprParser.g:844:2: iv_ruleRangeType= ruleRangeType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRangeType=ruleRangeType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRangeType; 
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
    // $ANTLR end "entryRuleRangeType"


    // $ANTLR start "ruleRangeType"
    // InternalExprParser.g:851:1: ruleRangeType returns [EObject current=null] : (otherlv_0= Range otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) ;
    public final EObject ruleRangeType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:854:28: ( (otherlv_0= Range otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) )
            // InternalExprParser.g:855:1: (otherlv_0= Range otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            {
            // InternalExprParser.g:855:1: (otherlv_0= Range otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            // InternalExprParser.g:856:2: otherlv_0= Range otherlv_1= Of ( (lv_type_2_0= ruleType ) )
            {
            otherlv_0=(Token)match(input,Range,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRangeTypeAccess().getRangeKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,Of,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRangeTypeAccess().getOfKeyword_1());
                  
            }
            // InternalExprParser.g:865:1: ( (lv_type_2_0= ruleType ) )
            // InternalExprParser.g:866:1: (lv_type_2_0= ruleType )
            {
            // InternalExprParser.g:866:1: (lv_type_2_0= ruleType )
            // InternalExprParser.g:867:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRangeTypeAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_type_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRangeTypeRule());
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
    // $ANTLR end "ruleRangeType"


    // $ANTLR start "entryRuleCategory"
    // InternalExprParser.g:891:1: entryRuleCategory returns [EObject current=null] : iv_ruleCategory= ruleCategory EOF ;
    public final EObject entryRuleCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategory = null;


        try {
            // InternalExprParser.g:892:2: (iv_ruleCategory= ruleCategory EOF )
            // InternalExprParser.g:893:2: iv_ruleCategory= ruleCategory EOF
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
    // InternalExprParser.g:900:1: ruleCategory returns [EObject current=null] : ( (lv_category_0_0= ruleComponentCategory ) ) ;
    public final EObject ruleCategory() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_category_0_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:903:28: ( ( (lv_category_0_0= ruleComponentCategory ) ) )
            // InternalExprParser.g:904:1: ( (lv_category_0_0= ruleComponentCategory ) )
            {
            // InternalExprParser.g:904:1: ( (lv_category_0_0= ruleComponentCategory ) )
            // InternalExprParser.g:905:1: (lv_category_0_0= ruleComponentCategory )
            {
            // InternalExprParser.g:905:1: (lv_category_0_0= ruleComponentCategory )
            // InternalExprParser.g:906:3: lv_category_0_0= ruleComponentCategory
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
    // InternalExprParser.g:930:1: entryRuleComponentCategory returns [String current=null] : iv_ruleComponentCategory= ruleComponentCategory EOF ;
    public final String entryRuleComponentCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComponentCategory = null;


        try {
            // InternalExprParser.g:931:1: (iv_ruleComponentCategory= ruleComponentCategory EOF )
            // InternalExprParser.g:932:2: iv_ruleComponentCategory= ruleComponentCategory EOF
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
    // InternalExprParser.g:939:1: ruleComponentCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Abstract | kw= Bus | kw= Data | kw= Device | kw= Memory | kw= Process | kw= Processor | kw= Subprogram | (kw= Subprogram kw= Group ) | kw= KW_System | (kw= Thread kw= Group ) | kw= Thread | (kw= Virtual kw= Bus ) | (kw= Virtual kw= Processor ) ) ;
    public final AntlrDatatypeRuleToken ruleComponentCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:943:6: ( (kw= Abstract | kw= Bus | kw= Data | kw= Device | kw= Memory | kw= Process | kw= Processor | kw= Subprogram | (kw= Subprogram kw= Group ) | kw= KW_System | (kw= Thread kw= Group ) | kw= Thread | (kw= Virtual kw= Bus ) | (kw= Virtual kw= Processor ) ) )
            // InternalExprParser.g:944:1: (kw= Abstract | kw= Bus | kw= Data | kw= Device | kw= Memory | kw= Process | kw= Processor | kw= Subprogram | (kw= Subprogram kw= Group ) | kw= KW_System | (kw= Thread kw= Group ) | kw= Thread | (kw= Virtual kw= Bus ) | (kw= Virtual kw= Processor ) )
            {
            // InternalExprParser.g:944:1: (kw= Abstract | kw= Bus | kw= Data | kw= Device | kw= Memory | kw= Process | kw= Processor | kw= Subprogram | (kw= Subprogram kw= Group ) | kw= KW_System | (kw= Thread kw= Group ) | kw= Thread | (kw= Virtual kw= Bus ) | (kw= Virtual kw= Processor ) )
            int alt12=14;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // InternalExprParser.g:945:2: kw= Abstract
                    {
                    kw=(Token)match(input,Abstract,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:952:2: kw= Bus
                    {
                    kw=(Token)match(input,Bus,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:959:2: kw= Data
                    {
                    kw=(Token)match(input,Data,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:966:2: kw= Device
                    {
                    kw=(Token)match(input,Device,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalExprParser.g:973:2: kw= Memory
                    {
                    kw=(Token)match(input,Memory,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalExprParser.g:980:2: kw= Process
                    {
                    kw=(Token)match(input,Process,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalExprParser.g:987:2: kw= Processor
                    {
                    kw=(Token)match(input,Processor,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalExprParser.g:994:2: kw= Subprogram
                    {
                    kw=(Token)match(input,Subprogram,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // InternalExprParser.g:1000:6: (kw= Subprogram kw= Group )
                    {
                    // InternalExprParser.g:1000:6: (kw= Subprogram kw= Group )
                    // InternalExprParser.g:1001:2: kw= Subprogram kw= Group
                    {
                    kw=(Token)match(input,Subprogram,FOLLOW_14); if (state.failed) return current;
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
                    // InternalExprParser.g:1014:2: kw= KW_System
                    {
                    kw=(Token)match(input,KW_System,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // InternalExprParser.g:1020:6: (kw= Thread kw= Group )
                    {
                    // InternalExprParser.g:1020:6: (kw= Thread kw= Group )
                    // InternalExprParser.g:1021:2: kw= Thread kw= Group
                    {
                    kw=(Token)match(input,Thread,FOLLOW_14); if (state.failed) return current;
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
                    // InternalExprParser.g:1034:2: kw= Thread
                    {
                    kw=(Token)match(input,Thread,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
                          
                    }

                    }
                    break;
                case 13 :
                    // InternalExprParser.g:1040:6: (kw= Virtual kw= Bus )
                    {
                    // InternalExprParser.g:1040:6: (kw= Virtual kw= Bus )
                    // InternalExprParser.g:1041:2: kw= Virtual kw= Bus
                    {
                    kw=(Token)match(input,Virtual,FOLLOW_15); if (state.failed) return current;
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
                    // InternalExprParser.g:1053:6: (kw= Virtual kw= Processor )
                    {
                    // InternalExprParser.g:1053:6: (kw= Virtual kw= Processor )
                    // InternalExprParser.g:1054:2: kw= Virtual kw= Processor
                    {
                    kw=(Token)match(input,Virtual,FOLLOW_16); if (state.failed) return current;
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
    // InternalExprParser.g:1073:1: entryRuleMetaClass returns [EObject current=null] : iv_ruleMetaClass= ruleMetaClass EOF ;
    public final EObject entryRuleMetaClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMetaClass = null;


        try {
            // InternalExprParser.g:1074:2: (iv_ruleMetaClass= ruleMetaClass EOF )
            // InternalExprParser.g:1075:2: iv_ruleMetaClass= ruleMetaClass EOF
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
    // InternalExprParser.g:1082:1: ruleMetaClass returns [EObject current=null] : ( (lv_class_0_0= ruleMetaClassEnum ) ) ;
    public final EObject ruleMetaClass() throws RecognitionException {
        EObject current = null;

        Enumerator lv_class_0_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1085:28: ( ( (lv_class_0_0= ruleMetaClassEnum ) ) )
            // InternalExprParser.g:1086:1: ( (lv_class_0_0= ruleMetaClassEnum ) )
            {
            // InternalExprParser.g:1086:1: ( (lv_class_0_0= ruleMetaClassEnum ) )
            // InternalExprParser.g:1087:1: (lv_class_0_0= ruleMetaClassEnum )
            {
            // InternalExprParser.g:1087:1: (lv_class_0_0= ruleMetaClassEnum )
            // InternalExprParser.g:1088:3: lv_class_0_0= ruleMetaClassEnum
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


    // $ANTLR start "entryRuleRecordType"
    // InternalExprParser.g:1112:1: entryRuleRecordType returns [EObject current=null] : iv_ruleRecordType= ruleRecordType EOF ;
    public final EObject entryRuleRecordType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordType = null;


        try {
            // InternalExprParser.g:1113:2: (iv_ruleRecordType= ruleRecordType EOF )
            // InternalExprParser.g:1114:2: iv_ruleRecordType= ruleRecordType EOF
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
    // InternalExprParser.g:1121:1: ruleRecordType returns [EObject current=null] : ( () otherlv_1= Record otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )* )? otherlv_6= RightCurlyBracket ) ;
    public final EObject ruleRecordType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_fields_3_0 = null;

        EObject lv_fields_5_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1124:28: ( ( () otherlv_1= Record otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )* )? otherlv_6= RightCurlyBracket ) )
            // InternalExprParser.g:1125:1: ( () otherlv_1= Record otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )* )? otherlv_6= RightCurlyBracket )
            {
            // InternalExprParser.g:1125:1: ( () otherlv_1= Record otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )* )? otherlv_6= RightCurlyBracket )
            // InternalExprParser.g:1125:2: () otherlv_1= Record otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )* )? otherlv_6= RightCurlyBracket
            {
            // InternalExprParser.g:1125:2: ()
            // InternalExprParser.g:1126:5: 
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
            // InternalExprParser.g:1141:1: ( ( (lv_fields_3_0= ruleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalExprParser.g:1141:2: ( (lv_fields_3_0= ruleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )*
                    {
                    // InternalExprParser.g:1141:2: ( (lv_fields_3_0= ruleField ) )
                    // InternalExprParser.g:1142:1: (lv_fields_3_0= ruleField )
                    {
                    // InternalExprParser.g:1142:1: (lv_fields_3_0= ruleField )
                    // InternalExprParser.g:1143:3: lv_fields_3_0= ruleField
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRecordTypeAccess().getFieldsFieldParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_19);
                    lv_fields_3_0=ruleField();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRecordTypeRule());
                      	        }
                             		add(
                             			current, 
                             			"fields",
                              		lv_fields_3_0, 
                              		"org.osate.expr.Expr.Field");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalExprParser.g:1159:2: (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==Comma) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalExprParser.g:1160:2: otherlv_4= Comma ( (lv_fields_5_0= ruleField ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getRecordTypeAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // InternalExprParser.g:1164:1: ( (lv_fields_5_0= ruleField ) )
                    	    // InternalExprParser.g:1165:1: (lv_fields_5_0= ruleField )
                    	    {
                    	    // InternalExprParser.g:1165:1: (lv_fields_5_0= ruleField )
                    	    // InternalExprParser.g:1166:3: lv_fields_5_0= ruleField
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRecordTypeAccess().getFieldsFieldParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_19);
                    	    lv_fields_5_0=ruleField();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getRecordTypeRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"fields",
                    	              		lv_fields_5_0, 
                    	              		"org.osate.expr.Expr.Field");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getRecordTypeAccess().getRightCurlyBracketKeyword_4());
                  
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
    // InternalExprParser.g:1195:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // InternalExprParser.g:1196:2: (iv_ruleField= ruleField EOF )
            // InternalExprParser.g:1197:2: iv_ruleField= ruleField EOF
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
    // InternalExprParser.g:1204:1: ruleField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1207:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) )
            // InternalExprParser.g:1208:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) )
            {
            // InternalExprParser.g:1208:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) )
            // InternalExprParser.g:1208:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) )
            {
            // InternalExprParser.g:1208:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalExprParser.g:1209:1: (lv_name_0_0= RULE_ID )
            {
            // InternalExprParser.g:1209:1: (lv_name_0_0= RULE_ID )
            // InternalExprParser.g:1210:3: lv_name_0_0= RULE_ID
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
            // InternalExprParser.g:1231:1: ( (lv_type_2_0= ruleType ) )
            // InternalExprParser.g:1232:1: (lv_type_2_0= ruleType )
            {
            // InternalExprParser.g:1232:1: (lv_type_2_0= ruleType )
            // InternalExprParser.g:1233:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFieldAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
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
    // InternalExprParser.g:1257:1: entryRuleUnionType returns [EObject current=null] : iv_ruleUnionType= ruleUnionType EOF ;
    public final EObject entryRuleUnionType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnionType = null;


        try {
            // InternalExprParser.g:1258:2: (iv_ruleUnionType= ruleUnionType EOF )
            // InternalExprParser.g:1259:2: iv_ruleUnionType= ruleUnionType EOF
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
    // InternalExprParser.g:1266:1: ruleUnionType returns [EObject current=null] : ( () otherlv_1= Union otherlv_2= LeftCurlyBracket otherlv_3= QuestionMarkQuestionMarkQuestionMark otherlv_4= RightCurlyBracket ) ;
    public final EObject ruleUnionType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:1269:28: ( ( () otherlv_1= Union otherlv_2= LeftCurlyBracket otherlv_3= QuestionMarkQuestionMarkQuestionMark otherlv_4= RightCurlyBracket ) )
            // InternalExprParser.g:1270:1: ( () otherlv_1= Union otherlv_2= LeftCurlyBracket otherlv_3= QuestionMarkQuestionMarkQuestionMark otherlv_4= RightCurlyBracket )
            {
            // InternalExprParser.g:1270:1: ( () otherlv_1= Union otherlv_2= LeftCurlyBracket otherlv_3= QuestionMarkQuestionMarkQuestionMark otherlv_4= RightCurlyBracket )
            // InternalExprParser.g:1270:2: () otherlv_1= Union otherlv_2= LeftCurlyBracket otherlv_3= QuestionMarkQuestionMarkQuestionMark otherlv_4= RightCurlyBracket
            {
            // InternalExprParser.g:1270:2: ()
            // InternalExprParser.g:1271:5: 
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
    // InternalExprParser.g:1304:1: entryRuleTupleType returns [EObject current=null] : iv_ruleTupleType= ruleTupleType EOF ;
    public final EObject entryRuleTupleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleType = null;


        try {
            // InternalExprParser.g:1305:2: (iv_ruleTupleType= ruleTupleType EOF )
            // InternalExprParser.g:1306:2: iv_ruleTupleType= ruleTupleType EOF
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
    // InternalExprParser.g:1313:1: ruleTupleType returns [EObject current=null] : ( () otherlv_1= Tuple otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleTupleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleTupleField ) ) )* )? otherlv_6= RightCurlyBracket ) ;
    public final EObject ruleTupleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_fields_3_0 = null;

        EObject lv_fields_5_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1316:28: ( ( () otherlv_1= Tuple otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleTupleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleTupleField ) ) )* )? otherlv_6= RightCurlyBracket ) )
            // InternalExprParser.g:1317:1: ( () otherlv_1= Tuple otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleTupleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleTupleField ) ) )* )? otherlv_6= RightCurlyBracket )
            {
            // InternalExprParser.g:1317:1: ( () otherlv_1= Tuple otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleTupleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleTupleField ) ) )* )? otherlv_6= RightCurlyBracket )
            // InternalExprParser.g:1317:2: () otherlv_1= Tuple otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleTupleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleTupleField ) ) )* )? otherlv_6= RightCurlyBracket
            {
            // InternalExprParser.g:1317:2: ()
            // InternalExprParser.g:1318:5: 
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
            // InternalExprParser.g:1333:1: ( ( (lv_fields_3_0= ruleTupleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleTupleField ) ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=Connection && LA16_0<=Processor)||LA16_0==Abstract||LA16_0==Property||LA16_0==Feature||(LA16_0>=Process && LA16_0<=Virtual)||(LA16_0>=Device && LA16_0<=Thread)||(LA16_0>=Range && LA16_0<=Data)||(LA16_0>=Enum && LA16_0<=Real)||(LA16_0>=Bag && LA16_0<=Bus)||(LA16_0>=Int && LA16_0<=Map)||LA16_0==Set||LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalExprParser.g:1333:2: ( (lv_fields_3_0= ruleTupleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleTupleField ) ) )*
                    {
                    // InternalExprParser.g:1333:2: ( (lv_fields_3_0= ruleTupleField ) )
                    // InternalExprParser.g:1334:1: (lv_fields_3_0= ruleTupleField )
                    {
                    // InternalExprParser.g:1334:1: (lv_fields_3_0= ruleTupleField )
                    // InternalExprParser.g:1335:3: lv_fields_3_0= ruleTupleField
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTupleTypeAccess().getFieldsTupleFieldParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_19);
                    lv_fields_3_0=ruleTupleField();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTupleTypeRule());
                      	        }
                             		add(
                             			current, 
                             			"fields",
                              		lv_fields_3_0, 
                              		"org.osate.expr.Expr.TupleField");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalExprParser.g:1351:2: (otherlv_4= Comma ( (lv_fields_5_0= ruleTupleField ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==Comma) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalExprParser.g:1352:2: otherlv_4= Comma ( (lv_fields_5_0= ruleTupleField ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_7); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getTupleTypeAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // InternalExprParser.g:1356:1: ( (lv_fields_5_0= ruleTupleField ) )
                    	    // InternalExprParser.g:1357:1: (lv_fields_5_0= ruleTupleField )
                    	    {
                    	    // InternalExprParser.g:1357:1: (lv_fields_5_0= ruleTupleField )
                    	    // InternalExprParser.g:1358:3: lv_fields_5_0= ruleTupleField
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTupleTypeAccess().getFieldsTupleFieldParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_19);
                    	    lv_fields_5_0=ruleTupleField();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getTupleTypeRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"fields",
                    	              		lv_fields_5_0, 
                    	              		"org.osate.expr.Expr.TupleField");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getTupleTypeAccess().getRightCurlyBracketKeyword_4());
                  
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
    // InternalExprParser.g:1387:1: entryRuleTupleField returns [EObject current=null] : iv_ruleTupleField= ruleTupleField EOF ;
    public final EObject entryRuleTupleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleField = null;


        try {
            // InternalExprParser.g:1388:2: (iv_ruleTupleField= ruleTupleField EOF )
            // InternalExprParser.g:1389:2: iv_ruleTupleField= ruleTupleField EOF
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
    // InternalExprParser.g:1396:1: ruleTupleField returns [EObject current=null] : ( (lv_type_0_0= ruleType ) ) ;
    public final EObject ruleTupleField() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1399:28: ( ( (lv_type_0_0= ruleType ) ) )
            // InternalExprParser.g:1400:1: ( (lv_type_0_0= ruleType ) )
            {
            // InternalExprParser.g:1400:1: ( (lv_type_0_0= ruleType ) )
            // InternalExprParser.g:1401:1: (lv_type_0_0= ruleType )
            {
            // InternalExprParser.g:1401:1: (lv_type_0_0= ruleType )
            // InternalExprParser.g:1402:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleFieldAccess().getTypeTypeParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_type_0_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTupleFieldRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_0_0, 
                      		"org.osate.expr.Expr.Type");
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
    // $ANTLR end "ruleTupleField"


    // $ANTLR start "entryRuleListType"
    // InternalExprParser.g:1426:1: entryRuleListType returns [EObject current=null] : iv_ruleListType= ruleListType EOF ;
    public final EObject entryRuleListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListType = null;


        try {
            // InternalExprParser.g:1427:2: (iv_ruleListType= ruleListType EOF )
            // InternalExprParser.g:1428:2: iv_ruleListType= ruleListType EOF
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
    // InternalExprParser.g:1435:1: ruleListType returns [EObject current=null] : (otherlv_0= List otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) ;
    public final EObject ruleListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1438:28: ( (otherlv_0= List otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) )
            // InternalExprParser.g:1439:1: (otherlv_0= List otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            {
            // InternalExprParser.g:1439:1: (otherlv_0= List otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            // InternalExprParser.g:1440:2: otherlv_0= List otherlv_1= Of ( (lv_type_2_0= ruleType ) )
            {
            otherlv_0=(Token)match(input,List,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getListTypeAccess().getListKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,Of,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getListTypeAccess().getOfKeyword_1());
                  
            }
            // InternalExprParser.g:1449:1: ( (lv_type_2_0= ruleType ) )
            // InternalExprParser.g:1450:1: (lv_type_2_0= ruleType )
            {
            // InternalExprParser.g:1450:1: (lv_type_2_0= ruleType )
            // InternalExprParser.g:1451:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getListTypeAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_type_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getListTypeRule());
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
    // $ANTLR end "ruleListType"


    // $ANTLR start "entryRuleSetType"
    // InternalExprParser.g:1475:1: entryRuleSetType returns [EObject current=null] : iv_ruleSetType= ruleSetType EOF ;
    public final EObject entryRuleSetType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetType = null;


        try {
            // InternalExprParser.g:1476:2: (iv_ruleSetType= ruleSetType EOF )
            // InternalExprParser.g:1477:2: iv_ruleSetType= ruleSetType EOF
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
    // InternalExprParser.g:1484:1: ruleSetType returns [EObject current=null] : (otherlv_0= Set otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) ;
    public final EObject ruleSetType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1487:28: ( (otherlv_0= Set otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) )
            // InternalExprParser.g:1488:1: (otherlv_0= Set otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            {
            // InternalExprParser.g:1488:1: (otherlv_0= Set otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            // InternalExprParser.g:1489:2: otherlv_0= Set otherlv_1= Of ( (lv_type_2_0= ruleType ) )
            {
            otherlv_0=(Token)match(input,Set,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSetTypeAccess().getSetKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,Of,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSetTypeAccess().getOfKeyword_1());
                  
            }
            // InternalExprParser.g:1498:1: ( (lv_type_2_0= ruleType ) )
            // InternalExprParser.g:1499:1: (lv_type_2_0= ruleType )
            {
            // InternalExprParser.g:1499:1: (lv_type_2_0= ruleType )
            // InternalExprParser.g:1500:3: lv_type_2_0= ruleType
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
    // InternalExprParser.g:1524:1: entryRuleBagType returns [EObject current=null] : iv_ruleBagType= ruleBagType EOF ;
    public final EObject entryRuleBagType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBagType = null;


        try {
            // InternalExprParser.g:1525:2: (iv_ruleBagType= ruleBagType EOF )
            // InternalExprParser.g:1526:2: iv_ruleBagType= ruleBagType EOF
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
    // InternalExprParser.g:1533:1: ruleBagType returns [EObject current=null] : (otherlv_0= Bag otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) ;
    public final EObject ruleBagType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1536:28: ( (otherlv_0= Bag otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) )
            // InternalExprParser.g:1537:1: (otherlv_0= Bag otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            {
            // InternalExprParser.g:1537:1: (otherlv_0= Bag otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            // InternalExprParser.g:1538:2: otherlv_0= Bag otherlv_1= Of ( (lv_type_2_0= ruleType ) )
            {
            otherlv_0=(Token)match(input,Bag,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getBagTypeAccess().getBagKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,Of,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getBagTypeAccess().getOfKeyword_1());
                  
            }
            // InternalExprParser.g:1547:1: ( (lv_type_2_0= ruleType ) )
            // InternalExprParser.g:1548:1: (lv_type_2_0= ruleType )
            {
            // InternalExprParser.g:1548:1: (lv_type_2_0= ruleType )
            // InternalExprParser.g:1549:3: lv_type_2_0= ruleType
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
    // InternalExprParser.g:1573:1: entryRuleMapType returns [EObject current=null] : iv_ruleMapType= ruleMapType EOF ;
    public final EObject entryRuleMapType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapType = null;


        try {
            // InternalExprParser.g:1574:2: (iv_ruleMapType= ruleMapType EOF )
            // InternalExprParser.g:1575:2: iv_ruleMapType= ruleMapType EOF
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
    // InternalExprParser.g:1582:1: ruleMapType returns [EObject current=null] : (otherlv_0= Map ( (lv_domain_1_0= ruleType ) ) otherlv_2= HyphenMinusGreaterThanSign ( (lv_image_3_0= ruleType ) ) ) ;
    public final EObject ruleMapType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_domain_1_0 = null;

        EObject lv_image_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1585:28: ( (otherlv_0= Map ( (lv_domain_1_0= ruleType ) ) otherlv_2= HyphenMinusGreaterThanSign ( (lv_image_3_0= ruleType ) ) ) )
            // InternalExprParser.g:1586:1: (otherlv_0= Map ( (lv_domain_1_0= ruleType ) ) otherlv_2= HyphenMinusGreaterThanSign ( (lv_image_3_0= ruleType ) ) )
            {
            // InternalExprParser.g:1586:1: (otherlv_0= Map ( (lv_domain_1_0= ruleType ) ) otherlv_2= HyphenMinusGreaterThanSign ( (lv_image_3_0= ruleType ) ) )
            // InternalExprParser.g:1587:2: otherlv_0= Map ( (lv_domain_1_0= ruleType ) ) otherlv_2= HyphenMinusGreaterThanSign ( (lv_image_3_0= ruleType ) )
            {
            otherlv_0=(Token)match(input,Map,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMapTypeAccess().getMapKeyword_0());
                  
            }
            // InternalExprParser.g:1591:1: ( (lv_domain_1_0= ruleType ) )
            // InternalExprParser.g:1592:1: (lv_domain_1_0= ruleType )
            {
            // InternalExprParser.g:1592:1: (lv_domain_1_0= ruleType )
            // InternalExprParser.g:1593:3: lv_domain_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapTypeAccess().getDomainTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_23);
            lv_domain_1_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMapTypeRule());
              	        }
                     		set(
                     			current, 
                     			"domain",
                      		lv_domain_1_0, 
                      		"org.osate.expr.Expr.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,HyphenMinusGreaterThanSign,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMapTypeAccess().getHyphenMinusGreaterThanSignKeyword_2());
                  
            }
            // InternalExprParser.g:1614:1: ( (lv_image_3_0= ruleType ) )
            // InternalExprParser.g:1615:1: (lv_image_3_0= ruleType )
            {
            // InternalExprParser.g:1615:1: (lv_image_3_0= ruleType )
            // InternalExprParser.g:1616:3: lv_image_3_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapTypeAccess().getImageTypeParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_image_3_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMapTypeRule());
              	        }
                     		set(
                     			current, 
                     			"image",
                      		lv_image_3_0, 
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


    // $ANTLR start "entryRuleEnumType"
    // InternalExprParser.g:1640:1: entryRuleEnumType returns [EObject current=null] : iv_ruleEnumType= ruleEnumType EOF ;
    public final EObject entryRuleEnumType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumType = null;


        try {
            // InternalExprParser.g:1641:2: (iv_ruleEnumType= ruleEnumType EOF )
            // InternalExprParser.g:1642:2: iv_ruleEnumType= ruleEnumType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumType=ruleEnumType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumType; 
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
    // $ANTLR end "entryRuleEnumType"


    // $ANTLR start "ruleEnumType"
    // InternalExprParser.g:1649:1: ruleEnumType returns [EObject current=null] : ( () otherlv_1= Enum otherlv_2= LeftCurlyBracket ( ( (lv_literals_3_0= ruleEnumLiteral ) ) (otherlv_4= Comma ( (lv_literals_5_0= ruleEnumLiteral ) ) )* )? otherlv_6= RightCurlyBracket ) ;
    public final EObject ruleEnumType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_literals_3_0 = null;

        EObject lv_literals_5_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1652:28: ( ( () otherlv_1= Enum otherlv_2= LeftCurlyBracket ( ( (lv_literals_3_0= ruleEnumLiteral ) ) (otherlv_4= Comma ( (lv_literals_5_0= ruleEnumLiteral ) ) )* )? otherlv_6= RightCurlyBracket ) )
            // InternalExprParser.g:1653:1: ( () otherlv_1= Enum otherlv_2= LeftCurlyBracket ( ( (lv_literals_3_0= ruleEnumLiteral ) ) (otherlv_4= Comma ( (lv_literals_5_0= ruleEnumLiteral ) ) )* )? otherlv_6= RightCurlyBracket )
            {
            // InternalExprParser.g:1653:1: ( () otherlv_1= Enum otherlv_2= LeftCurlyBracket ( ( (lv_literals_3_0= ruleEnumLiteral ) ) (otherlv_4= Comma ( (lv_literals_5_0= ruleEnumLiteral ) ) )* )? otherlv_6= RightCurlyBracket )
            // InternalExprParser.g:1653:2: () otherlv_1= Enum otherlv_2= LeftCurlyBracket ( ( (lv_literals_3_0= ruleEnumLiteral ) ) (otherlv_4= Comma ( (lv_literals_5_0= ruleEnumLiteral ) ) )* )? otherlv_6= RightCurlyBracket
            {
            // InternalExprParser.g:1653:2: ()
            // InternalExprParser.g:1654:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEnumTypeAccess().getEnumTypeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,Enum,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEnumTypeAccess().getEnumKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,LeftCurlyBracket,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getEnumTypeAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // InternalExprParser.g:1669:1: ( ( (lv_literals_3_0= ruleEnumLiteral ) ) (otherlv_4= Comma ( (lv_literals_5_0= ruleEnumLiteral ) ) )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalExprParser.g:1669:2: ( (lv_literals_3_0= ruleEnumLiteral ) ) (otherlv_4= Comma ( (lv_literals_5_0= ruleEnumLiteral ) ) )*
                    {
                    // InternalExprParser.g:1669:2: ( (lv_literals_3_0= ruleEnumLiteral ) )
                    // InternalExprParser.g:1670:1: (lv_literals_3_0= ruleEnumLiteral )
                    {
                    // InternalExprParser.g:1670:1: (lv_literals_3_0= ruleEnumLiteral )
                    // InternalExprParser.g:1671:3: lv_literals_3_0= ruleEnumLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEnumTypeAccess().getLiteralsEnumLiteralParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_19);
                    lv_literals_3_0=ruleEnumLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEnumTypeRule());
                      	        }
                             		add(
                             			current, 
                             			"literals",
                              		lv_literals_3_0, 
                              		"org.osate.expr.Expr.EnumLiteral");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalExprParser.g:1687:2: (otherlv_4= Comma ( (lv_literals_5_0= ruleEnumLiteral ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==Comma) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalExprParser.g:1688:2: otherlv_4= Comma ( (lv_literals_5_0= ruleEnumLiteral ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getEnumTypeAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // InternalExprParser.g:1692:1: ( (lv_literals_5_0= ruleEnumLiteral ) )
                    	    // InternalExprParser.g:1693:1: (lv_literals_5_0= ruleEnumLiteral )
                    	    {
                    	    // InternalExprParser.g:1693:1: (lv_literals_5_0= ruleEnumLiteral )
                    	    // InternalExprParser.g:1694:3: lv_literals_5_0= ruleEnumLiteral
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getEnumTypeAccess().getLiteralsEnumLiteralParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_19);
                    	    lv_literals_5_0=ruleEnumLiteral();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getEnumTypeRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"literals",
                    	              		lv_literals_5_0, 
                    	              		"org.osate.expr.Expr.EnumLiteral");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getEnumTypeAccess().getRightCurlyBracketKeyword_4());
                  
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
    // $ANTLR end "ruleEnumType"


    // $ANTLR start "entryRuleEnumLiteral"
    // InternalExprParser.g:1723:1: entryRuleEnumLiteral returns [EObject current=null] : iv_ruleEnumLiteral= ruleEnumLiteral EOF ;
    public final EObject entryRuleEnumLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteral = null;


        try {
            // InternalExprParser.g:1724:2: (iv_ruleEnumLiteral= ruleEnumLiteral EOF )
            // InternalExprParser.g:1725:2: iv_ruleEnumLiteral= ruleEnumLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumLiteral=ruleEnumLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumLiteral; 
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
    // $ANTLR end "entryRuleEnumLiteral"


    // $ANTLR start "ruleEnumLiteral"
    // InternalExprParser.g:1732:1: ruleEnumLiteral returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleEnumLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:1735:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalExprParser.g:1736:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalExprParser.g:1736:1: ( (lv_name_0_0= RULE_ID ) )
            // InternalExprParser.g:1737:1: (lv_name_0_0= RULE_ID )
            {
            // InternalExprParser.g:1737:1: (lv_name_0_0= RULE_ID )
            // InternalExprParser.g:1738:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getEnumLiteralAccess().getNameIDTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getEnumLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ID");
              	    
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
    // $ANTLR end "ruleEnumLiteral"


    // $ANTLR start "entryRuleTypeRef"
    // InternalExprParser.g:1762:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // InternalExprParser.g:1763:2: (iv_ruleTypeRef= ruleTypeRef EOF )
            // InternalExprParser.g:1764:2: iv_ruleTypeRef= ruleTypeRef EOF
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
    // InternalExprParser.g:1771:1: ruleTypeRef returns [EObject current=null] : ( ( ruleQCREF ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:1774:28: ( ( ( ruleQCREF ) ) )
            // InternalExprParser.g:1775:1: ( ( ruleQCREF ) )
            {
            // InternalExprParser.g:1775:1: ( ( ruleQCREF ) )
            // InternalExprParser.g:1776:1: ( ruleQCREF )
            {
            // InternalExprParser.g:1776:1: ( ruleQCREF )
            // InternalExprParser.g:1777:3: ruleQCREF
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getTypeRefRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeRefAccess().getRefNamedElementCrossReference_0()); 
              	    
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
    // InternalExprParser.g:1799:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalExprParser.g:1800:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalExprParser.g:1801:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalExprParser.g:1808:1: ruleExpression returns [EObject current=null] : this_OrExpression_0= ruleOrExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpression_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1811:28: (this_OrExpression_0= ruleOrExpression )
            // InternalExprParser.g:1813:5: this_OrExpression_0= ruleOrExpression
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
    // InternalExprParser.g:1829:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // InternalExprParser.g:1830:2: (iv_ruleOrExpression= ruleOrExpression EOF )
            // InternalExprParser.g:1831:2: iv_ruleOrExpression= ruleOrExpression EOF
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
    // InternalExprParser.g:1838:1: ruleOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AndExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1841:28: ( (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // InternalExprParser.g:1842:1: (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // InternalExprParser.g:1842:1: (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // InternalExprParser.g:1843:5: this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_24);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_AndExpression_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalExprParser.g:1851:1: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==Or) && (synpred1_InternalExprParser())) {
                    alt19=1;
                }
                else if ( (LA19_0==VerticalLineVerticalLine) && (synpred1_InternalExprParser())) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalExprParser.g:1851:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // InternalExprParser.g:1851:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) )
            	    // InternalExprParser.g:1851:3: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) )
            	    {
            	    // InternalExprParser.g:1856:6: ( () ( (lv_operator_2_0= ruleOpOr ) ) )
            	    // InternalExprParser.g:1856:7: () ( (lv_operator_2_0= ruleOpOr ) )
            	    {
            	    // InternalExprParser.g:1856:7: ()
            	    // InternalExprParser.g:1857:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getOrExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalExprParser.g:1862:2: ( (lv_operator_2_0= ruleOpOr ) )
            	    // InternalExprParser.g:1863:1: (lv_operator_2_0= ruleOpOr )
            	    {
            	    // InternalExprParser.g:1863:1: (lv_operator_2_0= ruleOpOr )
            	    // InternalExprParser.g:1864:3: lv_operator_2_0= ruleOpOr
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

            	    // InternalExprParser.g:1880:4: ( (lv_right_3_0= ruleAndExpression ) )
            	    // InternalExprParser.g:1881:1: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // InternalExprParser.g:1881:1: (lv_right_3_0= ruleAndExpression )
            	    // InternalExprParser.g:1882:3: lv_right_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_24);
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
            	    break loop19;
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
    // InternalExprParser.g:1906:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // InternalExprParser.g:1907:1: (iv_ruleOpOr= ruleOpOr EOF )
            // InternalExprParser.g:1908:2: iv_ruleOpOr= ruleOpOr EOF
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
    // InternalExprParser.g:1915:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Or | kw= VerticalLineVerticalLine ) ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:1919:6: ( (kw= Or | kw= VerticalLineVerticalLine ) )
            // InternalExprParser.g:1920:1: (kw= Or | kw= VerticalLineVerticalLine )
            {
            // InternalExprParser.g:1920:1: (kw= Or | kw= VerticalLineVerticalLine )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==Or) ) {
                alt20=1;
            }
            else if ( (LA20_0==VerticalLineVerticalLine) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalExprParser.g:1921:2: kw= Or
                    {
                    kw=(Token)match(input,Or,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOrAccess().getOrKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:1928:2: kw= VerticalLineVerticalLine
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
    // InternalExprParser.g:1941:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalExprParser.g:1942:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalExprParser.g:1943:2: iv_ruleAndExpression= ruleAndExpression EOF
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
    // InternalExprParser.g:1950:1: ruleAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EqualityExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1953:28: ( (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) )
            // InternalExprParser.g:1954:1: (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            {
            // InternalExprParser.g:1954:1: (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            // InternalExprParser.g:1955:5: this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndExpressionAccess().getEqualityExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_25);
            this_EqualityExpression_0=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_EqualityExpression_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalExprParser.g:1963:1: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==And) && (synpred2_InternalExprParser())) {
                    alt21=1;
                }
                else if ( (LA21_0==AmpersandAmpersand) && (synpred2_InternalExprParser())) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalExprParser.g:1963:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) )
            	    {
            	    // InternalExprParser.g:1963:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) )
            	    // InternalExprParser.g:1963:3: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) )
            	    {
            	    // InternalExprParser.g:1968:6: ( () ( (lv_operator_2_0= ruleOpAnd ) ) )
            	    // InternalExprParser.g:1968:7: () ( (lv_operator_2_0= ruleOpAnd ) )
            	    {
            	    // InternalExprParser.g:1968:7: ()
            	    // InternalExprParser.g:1969:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAndExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalExprParser.g:1974:2: ( (lv_operator_2_0= ruleOpAnd ) )
            	    // InternalExprParser.g:1975:1: (lv_operator_2_0= ruleOpAnd )
            	    {
            	    // InternalExprParser.g:1975:1: (lv_operator_2_0= ruleOpAnd )
            	    // InternalExprParser.g:1976:3: lv_operator_2_0= ruleOpAnd
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

            	    // InternalExprParser.g:1992:4: ( (lv_right_3_0= ruleEqualityExpression ) )
            	    // InternalExprParser.g:1993:1: (lv_right_3_0= ruleEqualityExpression )
            	    {
            	    // InternalExprParser.g:1993:1: (lv_right_3_0= ruleEqualityExpression )
            	    // InternalExprParser.g:1994:3: lv_right_3_0= ruleEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndExpressionAccess().getRightEqualityExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_25);
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
            	    break loop21;
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
    // InternalExprParser.g:2018:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // InternalExprParser.g:2019:1: (iv_ruleOpAnd= ruleOpAnd EOF )
            // InternalExprParser.g:2020:2: iv_ruleOpAnd= ruleOpAnd EOF
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
    // InternalExprParser.g:2027:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= And | kw= AmpersandAmpersand ) ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2031:6: ( (kw= And | kw= AmpersandAmpersand ) )
            // InternalExprParser.g:2032:1: (kw= And | kw= AmpersandAmpersand )
            {
            // InternalExprParser.g:2032:1: (kw= And | kw= AmpersandAmpersand )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==And) ) {
                alt22=1;
            }
            else if ( (LA22_0==AmpersandAmpersand) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalExprParser.g:2033:2: kw= And
                    {
                    kw=(Token)match(input,And,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAndAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2040:2: kw= AmpersandAmpersand
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
    // InternalExprParser.g:2053:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalExprParser.g:2054:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalExprParser.g:2055:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalExprParser.g:2062:1: ruleEqualityExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RelationalExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:2065:28: ( (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) )
            // InternalExprParser.g:2066:1: (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            {
            // InternalExprParser.g:2066:1: (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            // InternalExprParser.g:2067:5: this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_26);
            this_RelationalExpression_0=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_RelationalExpression_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalExprParser.g:2075:1: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==EqualsSignEqualsSign) && (synpred3_InternalExprParser())) {
                    alt23=1;
                }
                else if ( (LA23_0==ExclamationMarkEqualsSign) && (synpred3_InternalExprParser())) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalExprParser.g:2075:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) )
            	    {
            	    // InternalExprParser.g:2075:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) )
            	    // InternalExprParser.g:2075:3: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) )
            	    {
            	    // InternalExprParser.g:2080:6: ( () ( (lv_operator_2_0= ruleOpEquality ) ) )
            	    // InternalExprParser.g:2080:7: () ( (lv_operator_2_0= ruleOpEquality ) )
            	    {
            	    // InternalExprParser.g:2080:7: ()
            	    // InternalExprParser.g:2081:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getEqualityExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalExprParser.g:2086:2: ( (lv_operator_2_0= ruleOpEquality ) )
            	    // InternalExprParser.g:2087:1: (lv_operator_2_0= ruleOpEquality )
            	    {
            	    // InternalExprParser.g:2087:1: (lv_operator_2_0= ruleOpEquality )
            	    // InternalExprParser.g:2088:3: lv_operator_2_0= ruleOpEquality
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

            	    // InternalExprParser.g:2104:4: ( (lv_right_3_0= ruleRelationalExpression ) )
            	    // InternalExprParser.g:2105:1: (lv_right_3_0= ruleRelationalExpression )
            	    {
            	    // InternalExprParser.g:2105:1: (lv_right_3_0= ruleRelationalExpression )
            	    // InternalExprParser.g:2106:3: lv_right_3_0= ruleRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightRelationalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_26);
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
            	    break loop23;
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
    // InternalExprParser.g:2130:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // InternalExprParser.g:2131:1: (iv_ruleOpEquality= ruleOpEquality EOF )
            // InternalExprParser.g:2132:2: iv_ruleOpEquality= ruleOpEquality EOF
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
    // InternalExprParser.g:2139:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= EqualsSignEqualsSign | kw= ExclamationMarkEqualsSign ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2143:6: ( (kw= EqualsSignEqualsSign | kw= ExclamationMarkEqualsSign ) )
            // InternalExprParser.g:2144:1: (kw= EqualsSignEqualsSign | kw= ExclamationMarkEqualsSign )
            {
            // InternalExprParser.g:2144:1: (kw= EqualsSignEqualsSign | kw= ExclamationMarkEqualsSign )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==EqualsSignEqualsSign) ) {
                alt24=1;
            }
            else if ( (LA24_0==ExclamationMarkEqualsSign) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalExprParser.g:2145:2: kw= EqualsSignEqualsSign
                    {
                    kw=(Token)match(input,EqualsSignEqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2152:2: kw= ExclamationMarkEqualsSign
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
    // InternalExprParser.g:2165:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalExprParser.g:2166:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalExprParser.g:2167:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalExprParser.g:2174:1: ruleRelationalExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AdditiveExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:2177:28: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) )
            // InternalExprParser.g:2178:1: (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalExprParser.g:2178:1: (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            // InternalExprParser.g:2179:5: this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_27);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_AdditiveExpression_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalExprParser.g:2187:1: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==GreaterThanSignEqualsSign) && (synpred4_InternalExprParser())) {
                    alt25=1;
                }
                else if ( (LA25_0==LessThanSignEqualsSign) && (synpred4_InternalExprParser())) {
                    alt25=1;
                }
                else if ( (LA25_0==GreaterThanSign) && (synpred4_InternalExprParser())) {
                    alt25=1;
                }
                else if ( (LA25_0==LessThanSign) && (synpred4_InternalExprParser())) {
                    alt25=1;
                }
                else if ( (LA25_0==GreaterThanSignLessThanSign) && (synpred4_InternalExprParser())) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalExprParser.g:2187:2: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalExprParser.g:2187:2: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) )
            	    // InternalExprParser.g:2187:3: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) )
            	    {
            	    // InternalExprParser.g:2192:6: ( () ( (lv_operator_2_0= ruleOpCompare ) ) )
            	    // InternalExprParser.g:2192:7: () ( (lv_operator_2_0= ruleOpCompare ) )
            	    {
            	    // InternalExprParser.g:2192:7: ()
            	    // InternalExprParser.g:2193:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getRelationalExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalExprParser.g:2198:2: ( (lv_operator_2_0= ruleOpCompare ) )
            	    // InternalExprParser.g:2199:1: (lv_operator_2_0= ruleOpCompare )
            	    {
            	    // InternalExprParser.g:2199:1: (lv_operator_2_0= ruleOpCompare )
            	    // InternalExprParser.g:2200:3: lv_operator_2_0= ruleOpCompare
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

            	    // InternalExprParser.g:2216:4: ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    // InternalExprParser.g:2217:1: (lv_right_3_0= ruleAdditiveExpression )
            	    {
            	    // InternalExprParser.g:2217:1: (lv_right_3_0= ruleAdditiveExpression )
            	    // InternalExprParser.g:2218:3: lv_right_3_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_27);
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
            	    break loop25;
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
    // InternalExprParser.g:2242:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // InternalExprParser.g:2243:1: (iv_ruleOpCompare= ruleOpCompare EOF )
            // InternalExprParser.g:2244:2: iv_ruleOpCompare= ruleOpCompare EOF
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
    // InternalExprParser.g:2251:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= GreaterThanSignEqualsSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= LessThanSign | kw= GreaterThanSignLessThanSign ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2255:6: ( (kw= GreaterThanSignEqualsSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= LessThanSign | kw= GreaterThanSignLessThanSign ) )
            // InternalExprParser.g:2256:1: (kw= GreaterThanSignEqualsSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= LessThanSign | kw= GreaterThanSignLessThanSign )
            {
            // InternalExprParser.g:2256:1: (kw= GreaterThanSignEqualsSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= LessThanSign | kw= GreaterThanSignLessThanSign )
            int alt26=5;
            switch ( input.LA(1) ) {
            case GreaterThanSignEqualsSign:
                {
                alt26=1;
                }
                break;
            case LessThanSignEqualsSign:
                {
                alt26=2;
                }
                break;
            case GreaterThanSign:
                {
                alt26=3;
                }
                break;
            case LessThanSign:
                {
                alt26=4;
                }
                break;
            case GreaterThanSignLessThanSign:
                {
                alt26=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalExprParser.g:2257:2: kw= GreaterThanSignEqualsSign
                    {
                    kw=(Token)match(input,GreaterThanSignEqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2264:2: kw= LessThanSignEqualsSign
                    {
                    kw=(Token)match(input,LessThanSignEqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:2271:2: kw= GreaterThanSign
                    {
                    kw=(Token)match(input,GreaterThanSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:2278:2: kw= LessThanSign
                    {
                    kw=(Token)match(input,LessThanSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalExprParser.g:2285:2: kw= GreaterThanSignLessThanSign
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
    // InternalExprParser.g:2298:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalExprParser.g:2299:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalExprParser.g:2300:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalExprParser.g:2307:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplicativeExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:2310:28: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) )
            // InternalExprParser.g:2311:1: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            {
            // InternalExprParser.g:2311:1: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            // InternalExprParser.g:2312:5: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_28);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_MultiplicativeExpression_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalExprParser.g:2320:1: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==PlusSign) && (synpred5_InternalExprParser())) {
                    alt27=1;
                }
                else if ( (LA27_0==HyphenMinus) && (synpred5_InternalExprParser())) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalExprParser.g:2320:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) )
            	    {
            	    // InternalExprParser.g:2320:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) )
            	    // InternalExprParser.g:2320:3: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) )
            	    {
            	    // InternalExprParser.g:2325:6: ( () ( (lv_operator_2_0= ruleOpAdd ) ) )
            	    // InternalExprParser.g:2325:7: () ( (lv_operator_2_0= ruleOpAdd ) )
            	    {
            	    // InternalExprParser.g:2325:7: ()
            	    // InternalExprParser.g:2326:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAdditiveExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalExprParser.g:2331:2: ( (lv_operator_2_0= ruleOpAdd ) )
            	    // InternalExprParser.g:2332:1: (lv_operator_2_0= ruleOpAdd )
            	    {
            	    // InternalExprParser.g:2332:1: (lv_operator_2_0= ruleOpAdd )
            	    // InternalExprParser.g:2333:3: lv_operator_2_0= ruleOpAdd
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

            	    // InternalExprParser.g:2349:4: ( (lv_right_3_0= ruleMultiplicativeExpression ) )
            	    // InternalExprParser.g:2350:1: (lv_right_3_0= ruleMultiplicativeExpression )
            	    {
            	    // InternalExprParser.g:2350:1: (lv_right_3_0= ruleMultiplicativeExpression )
            	    // InternalExprParser.g:2351:3: lv_right_3_0= ruleMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_28);
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
            	    break loop27;
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
    // InternalExprParser.g:2375:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // InternalExprParser.g:2376:1: (iv_ruleOpAdd= ruleOpAdd EOF )
            // InternalExprParser.g:2377:2: iv_ruleOpAdd= ruleOpAdd EOF
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
    // InternalExprParser.g:2384:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= PlusSign | kw= HyphenMinus ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2388:6: ( (kw= PlusSign | kw= HyphenMinus ) )
            // InternalExprParser.g:2389:1: (kw= PlusSign | kw= HyphenMinus )
            {
            // InternalExprParser.g:2389:1: (kw= PlusSign | kw= HyphenMinus )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==PlusSign) ) {
                alt28=1;
            }
            else if ( (LA28_0==HyphenMinus) ) {
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
                    // InternalExprParser.g:2390:2: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2397:2: kw= HyphenMinus
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
    // InternalExprParser.g:2410:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalExprParser.g:2411:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalExprParser.g:2412:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalExprParser.g:2419:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_UnaryOperation_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:2422:28: ( (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* ) )
            // InternalExprParser.g:2423:1: (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* )
            {
            // InternalExprParser.g:2423:1: (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* )
            // InternalExprParser.g:2424:5: this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getUnaryOperationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_29);
            this_UnaryOperation_0=ruleUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_UnaryOperation_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalExprParser.g:2432:1: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==Asterisk) && (synpred6_InternalExprParser())) {
                    alt29=1;
                }
                else if ( (LA29_0==Solidus) && (synpred6_InternalExprParser())) {
                    alt29=1;
                }
                else if ( (LA29_0==Div) && (synpred6_InternalExprParser())) {
                    alt29=1;
                }
                else if ( (LA29_0==Mod) && (synpred6_InternalExprParser())) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalExprParser.g:2432:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) )
            	    {
            	    // InternalExprParser.g:2432:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) )
            	    // InternalExprParser.g:2432:3: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) )
            	    {
            	    // InternalExprParser.g:2437:6: ( () ( (lv_operator_2_0= ruleOpMulti ) ) )
            	    // InternalExprParser.g:2437:7: () ( (lv_operator_2_0= ruleOpMulti ) )
            	    {
            	    // InternalExprParser.g:2437:7: ()
            	    // InternalExprParser.g:2438:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getMultiplicativeExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalExprParser.g:2443:2: ( (lv_operator_2_0= ruleOpMulti ) )
            	    // InternalExprParser.g:2444:1: (lv_operator_2_0= ruleOpMulti )
            	    {
            	    // InternalExprParser.g:2444:1: (lv_operator_2_0= ruleOpMulti )
            	    // InternalExprParser.g:2445:3: lv_operator_2_0= ruleOpMulti
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

            	    // InternalExprParser.g:2461:4: ( (lv_right_3_0= ruleUnaryOperation ) )
            	    // InternalExprParser.g:2462:1: (lv_right_3_0= ruleUnaryOperation )
            	    {
            	    // InternalExprParser.g:2462:1: (lv_right_3_0= ruleUnaryOperation )
            	    // InternalExprParser.g:2463:3: lv_right_3_0= ruleUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightUnaryOperationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_29);
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
            	    break loop29;
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
    // InternalExprParser.g:2487:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // InternalExprParser.g:2488:1: (iv_ruleOpMulti= ruleOpMulti EOF )
            // InternalExprParser.g:2489:2: iv_ruleOpMulti= ruleOpMulti EOF
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
    // InternalExprParser.g:2496:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Asterisk | kw= Solidus | kw= Div | kw= Mod ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2500:6: ( (kw= Asterisk | kw= Solidus | kw= Div | kw= Mod ) )
            // InternalExprParser.g:2501:1: (kw= Asterisk | kw= Solidus | kw= Div | kw= Mod )
            {
            // InternalExprParser.g:2501:1: (kw= Asterisk | kw= Solidus | kw= Div | kw= Mod )
            int alt30=4;
            switch ( input.LA(1) ) {
            case Asterisk:
                {
                alt30=1;
                }
                break;
            case Solidus:
                {
                alt30=2;
                }
                break;
            case Div:
                {
                alt30=3;
                }
                break;
            case Mod:
                {
                alt30=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalExprParser.g:2502:2: kw= Asterisk
                    {
                    kw=(Token)match(input,Asterisk,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2509:2: kw= Solidus
                    {
                    kw=(Token)match(input,Solidus,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:2516:2: kw= Div
                    {
                    kw=(Token)match(input,Div,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getDivKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:2523:2: kw= Mod
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
    // InternalExprParser.g:2536:1: entryRuleUnaryOperation returns [EObject current=null] : iv_ruleUnaryOperation= ruleUnaryOperation EOF ;
    public final EObject entryRuleUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperation = null;


        try {
            // InternalExprParser.g:2537:2: (iv_ruleUnaryOperation= ruleUnaryOperation EOF )
            // InternalExprParser.g:2538:2: iv_ruleUnaryOperation= ruleUnaryOperation EOF
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
    // InternalExprParser.g:2545:1: ruleUnaryOperation returns [EObject current=null] : ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) ) | this_UnitExpression_3= ruleUnitExpression ) ;
    public final EObject ruleUnaryOperation() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_operator_1_0 = null;

        EObject lv_operand_2_0 = null;

        EObject this_UnitExpression_3 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:2548:28: ( ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) ) | this_UnitExpression_3= ruleUnitExpression ) )
            // InternalExprParser.g:2549:1: ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) ) | this_UnitExpression_3= ruleUnitExpression )
            {
            // InternalExprParser.g:2549:1: ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) ) | this_UnitExpression_3= ruleUnitExpression )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==Not||LA31_0==PlusSign||LA31_0==HyphenMinus) ) {
                alt31=1;
            }
            else if ( (LA31_0==Record||LA31_0==False||(LA31_0>=Tuple && LA31_0<=Union)||LA31_0==List||LA31_0==True||LA31_0==Bag||LA31_0==Map||LA31_0==Set||LA31_0==If||LA31_0==LeftParenthesis||LA31_0==LeftSquareBracket||LA31_0==CircumflexAccent||LA31_0==RULE_REAL_LIT||LA31_0==RULE_INTEGER_LIT||(LA31_0>=RULE_STRING && LA31_0<=RULE_ID)) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalExprParser.g:2549:2: ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) )
                    {
                    // InternalExprParser.g:2549:2: ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) )
                    // InternalExprParser.g:2549:3: () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) )
                    {
                    // InternalExprParser.g:2549:3: ()
                    // InternalExprParser.g:2550:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getUnaryOperationAccess().getUnaryOperationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalExprParser.g:2555:2: ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) )
                    // InternalExprParser.g:2555:3: ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary )
                    {
                    // InternalExprParser.g:2560:1: (lv_operator_1_0= ruleOpUnary )
                    // InternalExprParser.g:2561:3: lv_operator_1_0= ruleOpUnary
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

                    // InternalExprParser.g:2577:2: ( (lv_operand_2_0= ruleUnitExpression ) )
                    // InternalExprParser.g:2578:1: (lv_operand_2_0= ruleUnitExpression )
                    {
                    // InternalExprParser.g:2578:1: (lv_operand_2_0= ruleUnitExpression )
                    // InternalExprParser.g:2579:3: lv_operand_2_0= ruleUnitExpression
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
                    // InternalExprParser.g:2597:5: this_UnitExpression_3= ruleUnitExpression
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
    // InternalExprParser.g:2613:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // InternalExprParser.g:2614:1: (iv_ruleOpUnary= ruleOpUnary EOF )
            // InternalExprParser.g:2615:2: iv_ruleOpUnary= ruleOpUnary EOF
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
    // InternalExprParser.g:2622:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Not | kw= HyphenMinus | kw= PlusSign ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2626:6: ( (kw= Not | kw= HyphenMinus | kw= PlusSign ) )
            // InternalExprParser.g:2627:1: (kw= Not | kw= HyphenMinus | kw= PlusSign )
            {
            // InternalExprParser.g:2627:1: (kw= Not | kw= HyphenMinus | kw= PlusSign )
            int alt32=3;
            switch ( input.LA(1) ) {
            case Not:
                {
                alt32=1;
                }
                break;
            case HyphenMinus:
                {
                alt32=2;
                }
                break;
            case PlusSign:
                {
                alt32=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // InternalExprParser.g:2628:2: kw= Not
                    {
                    kw=(Token)match(input,Not,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2635:2: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:2642:2: kw= PlusSign
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
    // InternalExprParser.g:2655:1: entryRuleUnitExpression returns [EObject current=null] : iv_ruleUnitExpression= ruleUnitExpression EOF ;
    public final EObject entryRuleUnitExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpression = null;


        try {
            // InternalExprParser.g:2656:2: (iv_ruleUnitExpression= ruleUnitExpression EOF )
            // InternalExprParser.g:2657:2: iv_ruleUnitExpression= ruleUnitExpression EOF
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
    // InternalExprParser.g:2664:1: ruleUnitExpression returns [EObject current=null] : (this_PropertyExpression_0= rulePropertyExpression ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleUnitExpression() throws RecognitionException {
        EObject current = null;

        Token lv_convert_2_0=null;
        Token lv_drop_3_0=null;
        Token otherlv_4=null;
        EObject this_PropertyExpression_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:2667:28: ( (this_PropertyExpression_0= rulePropertyExpression ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalExprParser.g:2668:1: (this_PropertyExpression_0= rulePropertyExpression ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalExprParser.g:2668:1: (this_PropertyExpression_0= rulePropertyExpression ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )? )
            // InternalExprParser.g:2669:5: this_PropertyExpression_0= rulePropertyExpression ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnitExpressionAccess().getPropertyExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_30);
            this_PropertyExpression_0=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_PropertyExpression_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalExprParser.g:2677:1: ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==In||LA34_0==PercentSign||LA34_0==RULE_ID) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalExprParser.g:2677:2: () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) )
                    {
                    // InternalExprParser.g:2677:2: ()
                    // InternalExprParser.g:2678:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getUnitExpressionAccess().getUnitExpressionExpressionAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalExprParser.g:2683:2: ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )?
                    int alt33=3;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==PercentSign) ) {
                        alt33=1;
                    }
                    else if ( (LA33_0==In) ) {
                        alt33=2;
                    }
                    switch (alt33) {
                        case 1 :
                            // InternalExprParser.g:2683:3: ( (lv_convert_2_0= PercentSign ) )
                            {
                            // InternalExprParser.g:2683:3: ( (lv_convert_2_0= PercentSign ) )
                            // InternalExprParser.g:2684:1: (lv_convert_2_0= PercentSign )
                            {
                            // InternalExprParser.g:2684:1: (lv_convert_2_0= PercentSign )
                            // InternalExprParser.g:2685:3: lv_convert_2_0= PercentSign
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
                            // InternalExprParser.g:2700:6: ( (lv_drop_3_0= In ) )
                            {
                            // InternalExprParser.g:2700:6: ( (lv_drop_3_0= In ) )
                            // InternalExprParser.g:2701:1: (lv_drop_3_0= In )
                            {
                            // InternalExprParser.g:2701:1: (lv_drop_3_0= In )
                            // InternalExprParser.g:2702:3: lv_drop_3_0= In
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

                    // InternalExprParser.g:2716:4: ( (otherlv_4= RULE_ID ) )
                    // InternalExprParser.g:2717:1: (otherlv_4= RULE_ID )
                    {
                    // InternalExprParser.g:2717:1: (otherlv_4= RULE_ID )
                    // InternalExprParser.g:2718:3: otherlv_4= RULE_ID
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


    // $ANTLR start "entryRulePropertyExpression"
    // InternalExprParser.g:2737:1: entryRulePropertyExpression returns [EObject current=null] : iv_rulePropertyExpression= rulePropertyExpression EOF ;
    public final EObject entryRulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyExpression = null;


        try {
            // InternalExprParser.g:2738:2: (iv_rulePropertyExpression= rulePropertyExpression EOF )
            // InternalExprParser.g:2739:2: iv_rulePropertyExpression= rulePropertyExpression EOF
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
    // InternalExprParser.g:2746:1: rulePropertyExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )? ) ;
    public final EObject rulePropertyExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_PrimaryExpression_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:2749:28: ( (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )? ) )
            // InternalExprParser.g:2750:1: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )? )
            {
            // InternalExprParser.g:2750:1: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )? )
            // InternalExprParser.g:2751:5: this_PrimaryExpression_0= rulePrimaryExpression ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getPropertyExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_31);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_PrimaryExpression_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalExprParser.g:2759:1: ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==NumberSign) && (synpred8_InternalExprParser())) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalExprParser.g:2759:2: ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) )
                    {
                    // InternalExprParser.g:2759:2: ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) )
                    // InternalExprParser.g:2759:3: ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign )
                    {
                    // InternalExprParser.g:2762:5: ( () otherlv_2= NumberSign )
                    // InternalExprParser.g:2762:6: () otherlv_2= NumberSign
                    {
                    // InternalExprParser.g:2762:6: ()
                    // InternalExprParser.g:2763:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getPropertyExpressionAccess().getPropertyExpressionModelElementAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,NumberSign,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getPropertyExpressionAccess().getNumberSignKeyword_1_0_0_1());
                          
                    }

                    }


                    }

                    // InternalExprParser.g:2773:3: ( ( ruleQPREF ) )
                    // InternalExprParser.g:2774:1: ( ruleQPREF )
                    {
                    // InternalExprParser.g:2774:1: ( ruleQPREF )
                    // InternalExprParser.g:2775:3: ruleQPREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getPropertyExpressionRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPropertyExpressionAccess().getPropertyAbstractNamedValueCrossReference_1_1_0()); 
                      	    
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


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalExprParser.g:2797:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalExprParser.g:2798:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalExprParser.g:2799:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalExprParser.g:2806:1: rulePrimaryExpression returns [EObject current=null] : (this_NamedElementRef_0= ruleNamedElementRef | this_RangeExpression_1= ruleRangeExpression | this_IfExpression_2= ruleIfExpression | this_Literal_3= ruleLiteral | (otherlv_4= LeftParenthesis this_Expression_5= ruleExpression otherlv_6= RightParenthesis ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject this_NamedElementRef_0 = null;

        EObject this_RangeExpression_1 = null;

        EObject this_IfExpression_2 = null;

        EObject this_Literal_3 = null;

        EObject this_Expression_5 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:2809:28: ( (this_NamedElementRef_0= ruleNamedElementRef | this_RangeExpression_1= ruleRangeExpression | this_IfExpression_2= ruleIfExpression | this_Literal_3= ruleLiteral | (otherlv_4= LeftParenthesis this_Expression_5= ruleExpression otherlv_6= RightParenthesis ) ) )
            // InternalExprParser.g:2810:1: (this_NamedElementRef_0= ruleNamedElementRef | this_RangeExpression_1= ruleRangeExpression | this_IfExpression_2= ruleIfExpression | this_Literal_3= ruleLiteral | (otherlv_4= LeftParenthesis this_Expression_5= ruleExpression otherlv_6= RightParenthesis ) )
            {
            // InternalExprParser.g:2810:1: (this_NamedElementRef_0= ruleNamedElementRef | this_RangeExpression_1= ruleRangeExpression | this_IfExpression_2= ruleIfExpression | this_Literal_3= ruleLiteral | (otherlv_4= LeftParenthesis this_Expression_5= ruleExpression otherlv_6= RightParenthesis ) )
            int alt36=5;
            switch ( input.LA(1) ) {
            case CircumflexAccent:
            case RULE_ID:
                {
                alt36=1;
                }
                break;
            case LeftSquareBracket:
                {
                alt36=2;
                }
                break;
            case If:
                {
                alt36=3;
                }
                break;
            case Record:
            case False:
            case Tuple:
            case Union:
            case List:
            case True:
            case Bag:
            case Map:
            case Set:
            case RULE_REAL_LIT:
            case RULE_INTEGER_LIT:
            case RULE_STRING:
                {
                alt36=4;
                }
                break;
            case LeftParenthesis:
                {
                alt36=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalExprParser.g:2811:5: this_NamedElementRef_0= ruleNamedElementRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNamedElementRefParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_NamedElementRef_0=ruleNamedElementRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_NamedElementRef_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2821:5: this_RangeExpression_1= ruleRangeExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getRangeExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_RangeExpression_1=ruleRangeExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_RangeExpression_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:2831:5: this_IfExpression_2= ruleIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIfExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_IfExpression_2=ruleIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_IfExpression_2;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:2841:5: this_Literal_3= ruleLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Literal_3=ruleLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_Literal_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalExprParser.g:2850:6: (otherlv_4= LeftParenthesis this_Expression_5= ruleExpression otherlv_6= RightParenthesis )
                    {
                    // InternalExprParser.g:2850:6: (otherlv_4= LeftParenthesis this_Expression_5= ruleExpression otherlv_6= RightParenthesis )
                    // InternalExprParser.g:2851:2: otherlv_4= LeftParenthesis this_Expression_5= ruleExpression otherlv_6= RightParenthesis
                    {
                    otherlv_4=(Token)match(input,LeftParenthesis,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_4_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_4_1()); 
                          
                    }
                    pushFollow(FOLLOW_12);
                    this_Expression_5=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_Expression_5;
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_6=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_4_2());
                          
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


    // $ANTLR start "entryRuleNamedElementRef"
    // InternalExprParser.g:2877:1: entryRuleNamedElementRef returns [EObject current=null] : iv_ruleNamedElementRef= ruleNamedElementRef EOF ;
    public final EObject entryRuleNamedElementRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedElementRef = null;


        try {
            // InternalExprParser.g:2878:2: (iv_ruleNamedElementRef= ruleNamedElementRef EOF )
            // InternalExprParser.g:2879:2: iv_ruleNamedElementRef= ruleNamedElementRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedElementRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNamedElementRef=ruleNamedElementRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedElementRef; 
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
    // $ANTLR end "entryRuleNamedElementRef"


    // $ANTLR start "ruleNamedElementRef"
    // InternalExprParser.g:2886:1: ruleNamedElementRef returns [EObject current=null] : ( ( (lv_core_0_0= CircumflexAccent ) )? ( ( ruleQCREF ) ) ( ( ( ( () FullStop ) )=> ( () otherlv_3= FullStop ) ) ( (otherlv_4= RULE_ID ) ) )* ) ;
    public final EObject ruleNamedElementRef() throws RecognitionException {
        EObject current = null;

        Token lv_core_0_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2889:28: ( ( ( (lv_core_0_0= CircumflexAccent ) )? ( ( ruleQCREF ) ) ( ( ( ( () FullStop ) )=> ( () otherlv_3= FullStop ) ) ( (otherlv_4= RULE_ID ) ) )* ) )
            // InternalExprParser.g:2890:1: ( ( (lv_core_0_0= CircumflexAccent ) )? ( ( ruleQCREF ) ) ( ( ( ( () FullStop ) )=> ( () otherlv_3= FullStop ) ) ( (otherlv_4= RULE_ID ) ) )* )
            {
            // InternalExprParser.g:2890:1: ( ( (lv_core_0_0= CircumflexAccent ) )? ( ( ruleQCREF ) ) ( ( ( ( () FullStop ) )=> ( () otherlv_3= FullStop ) ) ( (otherlv_4= RULE_ID ) ) )* )
            // InternalExprParser.g:2890:2: ( (lv_core_0_0= CircumflexAccent ) )? ( ( ruleQCREF ) ) ( ( ( ( () FullStop ) )=> ( () otherlv_3= FullStop ) ) ( (otherlv_4= RULE_ID ) ) )*
            {
            // InternalExprParser.g:2890:2: ( (lv_core_0_0= CircumflexAccent ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==CircumflexAccent) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalExprParser.g:2891:1: (lv_core_0_0= CircumflexAccent )
                    {
                    // InternalExprParser.g:2891:1: (lv_core_0_0= CircumflexAccent )
                    // InternalExprParser.g:2892:3: lv_core_0_0= CircumflexAccent
                    {
                    lv_core_0_0=(Token)match(input,CircumflexAccent,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_core_0_0, grammarAccess.getNamedElementRefAccess().getCoreCircumflexAccentKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getNamedElementRefRule());
                      	        }
                             		setWithLastConsumed(current, "core", true, "^");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalExprParser.g:2906:3: ( ( ruleQCREF ) )
            // InternalExprParser.g:2907:1: ( ruleQCREF )
            {
            // InternalExprParser.g:2907:1: ( ruleQCREF )
            // InternalExprParser.g:2908:3: ruleQCREF
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getNamedElementRefRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedElementRefAccess().getRefNamedElementCrossReference_1_0()); 
              	    
            }
            pushFollow(FOLLOW_32);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalExprParser.g:2922:2: ( ( ( ( () FullStop ) )=> ( () otherlv_3= FullStop ) ) ( (otherlv_4= RULE_ID ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==FullStop) && (synpred9_InternalExprParser())) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalExprParser.g:2922:3: ( ( ( () FullStop ) )=> ( () otherlv_3= FullStop ) ) ( (otherlv_4= RULE_ID ) )
            	    {
            	    // InternalExprParser.g:2922:3: ( ( ( () FullStop ) )=> ( () otherlv_3= FullStop ) )
            	    // InternalExprParser.g:2922:4: ( ( () FullStop ) )=> ( () otherlv_3= FullStop )
            	    {
            	    // InternalExprParser.g:2925:5: ( () otherlv_3= FullStop )
            	    // InternalExprParser.g:2925:6: () otherlv_3= FullStop
            	    {
            	    // InternalExprParser.g:2925:6: ()
            	    // InternalExprParser.g:2926:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getNamedElementRefAccess().getNamedElementRefPrevAction_2_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_3=(Token)match(input,FullStop,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getNamedElementRefAccess().getFullStopKeyword_2_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // InternalExprParser.g:2936:3: ( (otherlv_4= RULE_ID ) )
            	    // InternalExprParser.g:2937:1: (otherlv_4= RULE_ID )
            	    {
            	    // InternalExprParser.g:2937:1: (otherlv_4= RULE_ID )
            	    // InternalExprParser.g:2938:3: otherlv_4= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getNamedElementRefRule());
            	      	        }
            	              
            	    }
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_32); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_4, grammarAccess.getNamedElementRefAccess().getRefNamedElementCrossReference_2_1_0()); 
            	      	
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
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
    // $ANTLR end "ruleNamedElementRef"


    // $ANTLR start "entryRuleRangeExpression"
    // InternalExprParser.g:2957:1: entryRuleRangeExpression returns [EObject current=null] : iv_ruleRangeExpression= ruleRangeExpression EOF ;
    public final EObject entryRuleRangeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeExpression = null;


        try {
            // InternalExprParser.g:2958:2: (iv_ruleRangeExpression= ruleRangeExpression EOF )
            // InternalExprParser.g:2959:2: iv_ruleRangeExpression= ruleRangeExpression EOF
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
    // InternalExprParser.g:2966:1: ruleRangeExpression returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_minimum_2_0= ruleExpression ) ) otherlv_3= FullStopFullStop ( (lv_maximum_4_0= ruleExpression ) ) ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )? otherlv_7= RightSquareBracket ) ;
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
            // InternalExprParser.g:2969:28: ( ( () otherlv_1= LeftSquareBracket ( (lv_minimum_2_0= ruleExpression ) ) otherlv_3= FullStopFullStop ( (lv_maximum_4_0= ruleExpression ) ) ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )? otherlv_7= RightSquareBracket ) )
            // InternalExprParser.g:2970:1: ( () otherlv_1= LeftSquareBracket ( (lv_minimum_2_0= ruleExpression ) ) otherlv_3= FullStopFullStop ( (lv_maximum_4_0= ruleExpression ) ) ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )? otherlv_7= RightSquareBracket )
            {
            // InternalExprParser.g:2970:1: ( () otherlv_1= LeftSquareBracket ( (lv_minimum_2_0= ruleExpression ) ) otherlv_3= FullStopFullStop ( (lv_maximum_4_0= ruleExpression ) ) ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )? otherlv_7= RightSquareBracket )
            // InternalExprParser.g:2970:2: () otherlv_1= LeftSquareBracket ( (lv_minimum_2_0= ruleExpression ) ) otherlv_3= FullStopFullStop ( (lv_maximum_4_0= ruleExpression ) ) ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )? otherlv_7= RightSquareBracket
            {
            // InternalExprParser.g:2970:2: ()
            // InternalExprParser.g:2971:5: 
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
            // InternalExprParser.g:2981:1: ( (lv_minimum_2_0= ruleExpression ) )
            // InternalExprParser.g:2982:1: (lv_minimum_2_0= ruleExpression )
            {
            // InternalExprParser.g:2982:1: (lv_minimum_2_0= ruleExpression )
            // InternalExprParser.g:2983:3: lv_minimum_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRangeExpressionAccess().getMinimumExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_33);
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
            // InternalExprParser.g:3004:1: ( (lv_maximum_4_0= ruleExpression ) )
            // InternalExprParser.g:3005:1: (lv_maximum_4_0= ruleExpression )
            {
            // InternalExprParser.g:3005:1: (lv_maximum_4_0= ruleExpression )
            // InternalExprParser.g:3006:3: lv_maximum_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRangeExpressionAccess().getMaximumExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_34);
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

            // InternalExprParser.g:3022:2: ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==Delta) && (synpred10_InternalExprParser())) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalExprParser.g:3022:3: ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) )
                    {
                    // InternalExprParser.g:3022:3: ( ( Delta )=>otherlv_5= Delta )
                    // InternalExprParser.g:3022:4: ( Delta )=>otherlv_5= Delta
                    {
                    otherlv_5=(Token)match(input,Delta,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getRangeExpressionAccess().getDeltaKeyword_5_0());
                          
                    }

                    }

                    // InternalExprParser.g:3029:2: ( (lv_delta_6_0= ruleExpression ) )
                    // InternalExprParser.g:3030:1: (lv_delta_6_0= ruleExpression )
                    {
                    // InternalExprParser.g:3030:1: (lv_delta_6_0= ruleExpression )
                    // InternalExprParser.g:3031:3: lv_delta_6_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRangeExpressionAccess().getDeltaExpressionParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_35);
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
    // InternalExprParser.g:3060:1: entryRuleIfExpression returns [EObject current=null] : iv_ruleIfExpression= ruleIfExpression EOF ;
    public final EObject entryRuleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpression = null;


        try {
            // InternalExprParser.g:3061:2: (iv_ruleIfExpression= ruleIfExpression EOF )
            // InternalExprParser.g:3062:2: iv_ruleIfExpression= ruleIfExpression EOF
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
    // InternalExprParser.g:3069:1: ruleIfExpression returns [EObject current=null] : ( () otherlv_1= If ( (lv_if_2_0= ruleExpression ) ) otherlv_3= Then ( (lv_then_4_0= ruleExpression ) ) (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )? otherlv_7= Endif ) ;
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
            // InternalExprParser.g:3072:28: ( ( () otherlv_1= If ( (lv_if_2_0= ruleExpression ) ) otherlv_3= Then ( (lv_then_4_0= ruleExpression ) ) (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )? otherlv_7= Endif ) )
            // InternalExprParser.g:3073:1: ( () otherlv_1= If ( (lv_if_2_0= ruleExpression ) ) otherlv_3= Then ( (lv_then_4_0= ruleExpression ) ) (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )? otherlv_7= Endif )
            {
            // InternalExprParser.g:3073:1: ( () otherlv_1= If ( (lv_if_2_0= ruleExpression ) ) otherlv_3= Then ( (lv_then_4_0= ruleExpression ) ) (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )? otherlv_7= Endif )
            // InternalExprParser.g:3073:2: () otherlv_1= If ( (lv_if_2_0= ruleExpression ) ) otherlv_3= Then ( (lv_then_4_0= ruleExpression ) ) (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )? otherlv_7= Endif
            {
            // InternalExprParser.g:3073:2: ()
            // InternalExprParser.g:3074:5: 
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
            // InternalExprParser.g:3084:1: ( (lv_if_2_0= ruleExpression ) )
            // InternalExprParser.g:3085:1: (lv_if_2_0= ruleExpression )
            {
            // InternalExprParser.g:3085:1: (lv_if_2_0= ruleExpression )
            // InternalExprParser.g:3086:3: lv_if_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpressionAccess().getIfExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_36);
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
            // InternalExprParser.g:3107:1: ( (lv_then_4_0= ruleExpression ) )
            // InternalExprParser.g:3108:1: (lv_then_4_0= ruleExpression )
            {
            // InternalExprParser.g:3108:1: (lv_then_4_0= ruleExpression )
            // InternalExprParser.g:3109:3: lv_then_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpressionAccess().getThenExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_37);
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

            // InternalExprParser.g:3125:2: (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==Else) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalExprParser.g:3126:2: otherlv_5= Else ( (lv_else_6_0= ruleExpression ) )
                    {
                    otherlv_5=(Token)match(input,Else,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getIfExpressionAccess().getElseKeyword_5_0());
                          
                    }
                    // InternalExprParser.g:3130:1: ( (lv_else_6_0= ruleExpression ) )
                    // InternalExprParser.g:3131:1: (lv_else_6_0= ruleExpression )
                    {
                    // InternalExprParser.g:3131:1: (lv_else_6_0= ruleExpression )
                    // InternalExprParser.g:3132:3: lv_else_6_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIfExpressionAccess().getElseExpressionParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_38);
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
    // InternalExprParser.g:3161:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalExprParser.g:3162:2: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalExprParser.g:3163:2: iv_ruleLiteral= ruleLiteral EOF
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
    // InternalExprParser.g:3170:1: ruleLiteral returns [EObject current=null] : (this_EBooleanLiteral_0= ruleEBooleanLiteral | this_EIntegerLiteral_1= ruleEIntegerLiteral | this_ERealLiteral_2= ruleERealLiteral | this_EStringLiteral_3= ruleEStringLiteral | this_ListLiteral_4= ruleListLiteral | this_SetLiteral_5= ruleSetLiteral | this_RecordLiteral_6= ruleRecordLiteral | this_UnionLiteral_7= ruleUnionLiteral | this_TupleLiteral_8= ruleTupleLiteral | this_BagLiteral_9= ruleBagLiteral | this_MapLiteral_10= ruleMapLiteral ) ;
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
            // InternalExprParser.g:3173:28: ( (this_EBooleanLiteral_0= ruleEBooleanLiteral | this_EIntegerLiteral_1= ruleEIntegerLiteral | this_ERealLiteral_2= ruleERealLiteral | this_EStringLiteral_3= ruleEStringLiteral | this_ListLiteral_4= ruleListLiteral | this_SetLiteral_5= ruleSetLiteral | this_RecordLiteral_6= ruleRecordLiteral | this_UnionLiteral_7= ruleUnionLiteral | this_TupleLiteral_8= ruleTupleLiteral | this_BagLiteral_9= ruleBagLiteral | this_MapLiteral_10= ruleMapLiteral ) )
            // InternalExprParser.g:3174:1: (this_EBooleanLiteral_0= ruleEBooleanLiteral | this_EIntegerLiteral_1= ruleEIntegerLiteral | this_ERealLiteral_2= ruleERealLiteral | this_EStringLiteral_3= ruleEStringLiteral | this_ListLiteral_4= ruleListLiteral | this_SetLiteral_5= ruleSetLiteral | this_RecordLiteral_6= ruleRecordLiteral | this_UnionLiteral_7= ruleUnionLiteral | this_TupleLiteral_8= ruleTupleLiteral | this_BagLiteral_9= ruleBagLiteral | this_MapLiteral_10= ruleMapLiteral )
            {
            // InternalExprParser.g:3174:1: (this_EBooleanLiteral_0= ruleEBooleanLiteral | this_EIntegerLiteral_1= ruleEIntegerLiteral | this_ERealLiteral_2= ruleERealLiteral | this_EStringLiteral_3= ruleEStringLiteral | this_ListLiteral_4= ruleListLiteral | this_SetLiteral_5= ruleSetLiteral | this_RecordLiteral_6= ruleRecordLiteral | this_UnionLiteral_7= ruleUnionLiteral | this_TupleLiteral_8= ruleTupleLiteral | this_BagLiteral_9= ruleBagLiteral | this_MapLiteral_10= ruleMapLiteral )
            int alt41=11;
            switch ( input.LA(1) ) {
            case False:
            case True:
                {
                alt41=1;
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt41=2;
                }
                break;
            case RULE_REAL_LIT:
                {
                alt41=3;
                }
                break;
            case RULE_STRING:
                {
                alt41=4;
                }
                break;
            case List:
                {
                alt41=5;
                }
                break;
            case Set:
                {
                alt41=6;
                }
                break;
            case Record:
                {
                alt41=7;
                }
                break;
            case Union:
                {
                alt41=8;
                }
                break;
            case Tuple:
                {
                alt41=9;
                }
                break;
            case Bag:
                {
                alt41=10;
                }
                break;
            case Map:
                {
                alt41=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalExprParser.g:3175:5: this_EBooleanLiteral_0= ruleEBooleanLiteral
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
                    // InternalExprParser.g:3185:5: this_EIntegerLiteral_1= ruleEIntegerLiteral
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
                    // InternalExprParser.g:3195:5: this_ERealLiteral_2= ruleERealLiteral
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
                    // InternalExprParser.g:3205:5: this_EStringLiteral_3= ruleEStringLiteral
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
                    // InternalExprParser.g:3215:5: this_ListLiteral_4= ruleListLiteral
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
                    // InternalExprParser.g:3225:5: this_SetLiteral_5= ruleSetLiteral
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
                    // InternalExprParser.g:3235:5: this_RecordLiteral_6= ruleRecordLiteral
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
                    // InternalExprParser.g:3245:5: this_UnionLiteral_7= ruleUnionLiteral
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
                    // InternalExprParser.g:3255:5: this_TupleLiteral_8= ruleTupleLiteral
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
                    // InternalExprParser.g:3265:5: this_BagLiteral_9= ruleBagLiteral
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
                    // InternalExprParser.g:3275:5: this_MapLiteral_10= ruleMapLiteral
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
    // InternalExprParser.g:3291:1: entryRuleEBooleanLiteral returns [EObject current=null] : iv_ruleEBooleanLiteral= ruleEBooleanLiteral EOF ;
    public final EObject entryRuleEBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEBooleanLiteral = null;


        try {
            // InternalExprParser.g:3292:2: (iv_ruleEBooleanLiteral= ruleEBooleanLiteral EOF )
            // InternalExprParser.g:3293:2: iv_ruleEBooleanLiteral= ruleEBooleanLiteral EOF
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
    // InternalExprParser.g:3300:1: ruleEBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) ;
    public final EObject ruleEBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:3303:28: ( ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) )
            // InternalExprParser.g:3304:1: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            {
            // InternalExprParser.g:3304:1: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            // InternalExprParser.g:3304:2: () ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            {
            // InternalExprParser.g:3304:2: ()
            // InternalExprParser.g:3305:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEBooleanLiteralAccess().getEBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // InternalExprParser.g:3310:2: ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==True) ) {
                alt42=1;
            }
            else if ( (LA42_0==False) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalExprParser.g:3310:3: ( (lv_value_1_0= True ) )
                    {
                    // InternalExprParser.g:3310:3: ( (lv_value_1_0= True ) )
                    // InternalExprParser.g:3311:1: (lv_value_1_0= True )
                    {
                    // InternalExprParser.g:3311:1: (lv_value_1_0= True )
                    // InternalExprParser.g:3312:3: lv_value_1_0= True
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
                    // InternalExprParser.g:3328:2: otherlv_2= False
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
    // InternalExprParser.g:3340:1: entryRuleEIntegerLiteral returns [EObject current=null] : iv_ruleEIntegerLiteral= ruleEIntegerLiteral EOF ;
    public final EObject entryRuleEIntegerLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEIntegerLiteral = null;


        try {
            // InternalExprParser.g:3341:2: (iv_ruleEIntegerLiteral= ruleEIntegerLiteral EOF )
            // InternalExprParser.g:3342:2: iv_ruleEIntegerLiteral= ruleEIntegerLiteral EOF
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
    // InternalExprParser.g:3349:1: ruleEIntegerLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INTEGER_LIT ) ) ) ;
    public final EObject ruleEIntegerLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:3352:28: ( ( () ( (lv_value_1_0= RULE_INTEGER_LIT ) ) ) )
            // InternalExprParser.g:3353:1: ( () ( (lv_value_1_0= RULE_INTEGER_LIT ) ) )
            {
            // InternalExprParser.g:3353:1: ( () ( (lv_value_1_0= RULE_INTEGER_LIT ) ) )
            // InternalExprParser.g:3353:2: () ( (lv_value_1_0= RULE_INTEGER_LIT ) )
            {
            // InternalExprParser.g:3353:2: ()
            // InternalExprParser.g:3354:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEIntegerLiteralAccess().getEIntegerLiteralAction_0(),
                          current);
                  
            }

            }

            // InternalExprParser.g:3359:2: ( (lv_value_1_0= RULE_INTEGER_LIT ) )
            // InternalExprParser.g:3360:1: (lv_value_1_0= RULE_INTEGER_LIT )
            {
            // InternalExprParser.g:3360:1: (lv_value_1_0= RULE_INTEGER_LIT )
            // InternalExprParser.g:3361:3: lv_value_1_0= RULE_INTEGER_LIT
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
    // InternalExprParser.g:3385:1: entryRuleERealLiteral returns [EObject current=null] : iv_ruleERealLiteral= ruleERealLiteral EOF ;
    public final EObject entryRuleERealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleERealLiteral = null;


        try {
            // InternalExprParser.g:3386:2: (iv_ruleERealLiteral= ruleERealLiteral EOF )
            // InternalExprParser.g:3387:2: iv_ruleERealLiteral= ruleERealLiteral EOF
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
    // InternalExprParser.g:3394:1: ruleERealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_REAL_LIT ) ) ) ;
    public final EObject ruleERealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:3397:28: ( ( () ( (lv_value_1_0= RULE_REAL_LIT ) ) ) )
            // InternalExprParser.g:3398:1: ( () ( (lv_value_1_0= RULE_REAL_LIT ) ) )
            {
            // InternalExprParser.g:3398:1: ( () ( (lv_value_1_0= RULE_REAL_LIT ) ) )
            // InternalExprParser.g:3398:2: () ( (lv_value_1_0= RULE_REAL_LIT ) )
            {
            // InternalExprParser.g:3398:2: ()
            // InternalExprParser.g:3399:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getERealLiteralAccess().getERealLiteralAction_0(),
                          current);
                  
            }

            }

            // InternalExprParser.g:3404:2: ( (lv_value_1_0= RULE_REAL_LIT ) )
            // InternalExprParser.g:3405:1: (lv_value_1_0= RULE_REAL_LIT )
            {
            // InternalExprParser.g:3405:1: (lv_value_1_0= RULE_REAL_LIT )
            // InternalExprParser.g:3406:3: lv_value_1_0= RULE_REAL_LIT
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
    // InternalExprParser.g:3430:1: entryRuleEStringLiteral returns [EObject current=null] : iv_ruleEStringLiteral= ruleEStringLiteral EOF ;
    public final EObject entryRuleEStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEStringLiteral = null;


        try {
            // InternalExprParser.g:3431:2: (iv_ruleEStringLiteral= ruleEStringLiteral EOF )
            // InternalExprParser.g:3432:2: iv_ruleEStringLiteral= ruleEStringLiteral EOF
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
    // InternalExprParser.g:3439:1: ruleEStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleNoQuoteString ) ) ) ;
    public final EObject ruleEStringLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3442:28: ( ( () ( (lv_value_1_0= ruleNoQuoteString ) ) ) )
            // InternalExprParser.g:3443:1: ( () ( (lv_value_1_0= ruleNoQuoteString ) ) )
            {
            // InternalExprParser.g:3443:1: ( () ( (lv_value_1_0= ruleNoQuoteString ) ) )
            // InternalExprParser.g:3443:2: () ( (lv_value_1_0= ruleNoQuoteString ) )
            {
            // InternalExprParser.g:3443:2: ()
            // InternalExprParser.g:3444:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEStringLiteralAccess().getEStringLiteralAction_0(),
                          current);
                  
            }

            }

            // InternalExprParser.g:3449:2: ( (lv_value_1_0= ruleNoQuoteString ) )
            // InternalExprParser.g:3450:1: (lv_value_1_0= ruleNoQuoteString )
            {
            // InternalExprParser.g:3450:1: (lv_value_1_0= ruleNoQuoteString )
            // InternalExprParser.g:3451:3: lv_value_1_0= ruleNoQuoteString
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


    // $ANTLR start "ruleExpressionList"
    // InternalExprParser.g:3476:1: ruleExpressionList[EObject in_current] returns [EObject current=in_current] : (otherlv_0= LeftParenthesis ( ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= Comma ( (lv_elements_3_0= ruleExpression ) ) )* )? otherlv_4= RightParenthesis ) ;
    public final EObject ruleExpressionList(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_1_0 = null;

        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3479:28: ( (otherlv_0= LeftParenthesis ( ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= Comma ( (lv_elements_3_0= ruleExpression ) ) )* )? otherlv_4= RightParenthesis ) )
            // InternalExprParser.g:3480:1: (otherlv_0= LeftParenthesis ( ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= Comma ( (lv_elements_3_0= ruleExpression ) ) )* )? otherlv_4= RightParenthesis )
            {
            // InternalExprParser.g:3480:1: (otherlv_0= LeftParenthesis ( ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= Comma ( (lv_elements_3_0= ruleExpression ) ) )* )? otherlv_4= RightParenthesis )
            // InternalExprParser.g:3481:2: otherlv_0= LeftParenthesis ( ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= Comma ( (lv_elements_3_0= ruleExpression ) ) )* )? otherlv_4= RightParenthesis
            {
            otherlv_0=(Token)match(input,LeftParenthesis,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getExpressionListAccess().getLeftParenthesisKeyword_0());
                  
            }
            // InternalExprParser.g:3485:1: ( ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= Comma ( (lv_elements_3_0= ruleExpression ) ) )* )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==Record||LA44_0==False||(LA44_0>=Tuple && LA44_0<=Union)||LA44_0==List||LA44_0==True||LA44_0==Bag||LA44_0==Map||(LA44_0>=Not && LA44_0<=Set)||LA44_0==If||LA44_0==LeftParenthesis||LA44_0==PlusSign||LA44_0==HyphenMinus||LA44_0==LeftSquareBracket||LA44_0==CircumflexAccent||LA44_0==RULE_REAL_LIT||LA44_0==RULE_INTEGER_LIT||(LA44_0>=RULE_STRING && LA44_0<=RULE_ID)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalExprParser.g:3485:2: ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= Comma ( (lv_elements_3_0= ruleExpression ) ) )*
                    {
                    // InternalExprParser.g:3485:2: ( (lv_elements_1_0= ruleExpression ) )
                    // InternalExprParser.g:3486:1: (lv_elements_1_0= ruleExpression )
                    {
                    // InternalExprParser.g:3486:1: (lv_elements_1_0= ruleExpression )
                    // InternalExprParser.g:3487:3: lv_elements_1_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionListAccess().getElementsExpressionParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_40);
                    lv_elements_1_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionListRule());
                      	        }
                             		add(
                             			current, 
                             			"elements",
                              		lv_elements_1_0, 
                              		"org.osate.expr.Expr.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalExprParser.g:3503:2: (otherlv_2= Comma ( (lv_elements_3_0= ruleExpression ) ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==Comma) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // InternalExprParser.g:3504:2: otherlv_2= Comma ( (lv_elements_3_0= ruleExpression ) )
                    	    {
                    	    otherlv_2=(Token)match(input,Comma,FOLLOW_10); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getExpressionListAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // InternalExprParser.g:3508:1: ( (lv_elements_3_0= ruleExpression ) )
                    	    // InternalExprParser.g:3509:1: (lv_elements_3_0= ruleExpression )
                    	    {
                    	    // InternalExprParser.g:3509:1: (lv_elements_3_0= ruleExpression )
                    	    // InternalExprParser.g:3510:3: lv_elements_3_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getExpressionListAccess().getElementsExpressionParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_40);
                    	    lv_elements_3_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getExpressionListRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"elements",
                    	              		lv_elements_3_0, 
                    	              		"org.osate.expr.Expr.Expression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getExpressionListAccess().getRightParenthesisKeyword_2());
                  
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
    // $ANTLR end "ruleExpressionList"


    // $ANTLR start "entryRuleListLiteral"
    // InternalExprParser.g:3539:1: entryRuleListLiteral returns [EObject current=null] : iv_ruleListLiteral= ruleListLiteral EOF ;
    public final EObject entryRuleListLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListLiteral = null;


        try {
            // InternalExprParser.g:3540:2: (iv_ruleListLiteral= ruleListLiteral EOF )
            // InternalExprParser.g:3541:2: iv_ruleListLiteral= ruleListLiteral EOF
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
    // InternalExprParser.g:3548:1: ruleListLiteral returns [EObject current=null] : ( () otherlv_1= List this_ExpressionList_2= ruleExpressionList[$current] ) ;
    public final EObject ruleListLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_ExpressionList_2 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3551:28: ( ( () otherlv_1= List this_ExpressionList_2= ruleExpressionList[$current] ) )
            // InternalExprParser.g:3552:1: ( () otherlv_1= List this_ExpressionList_2= ruleExpressionList[$current] )
            {
            // InternalExprParser.g:3552:1: ( () otherlv_1= List this_ExpressionList_2= ruleExpressionList[$current] )
            // InternalExprParser.g:3552:2: () otherlv_1= List this_ExpressionList_2= ruleExpressionList[$current]
            {
            // InternalExprParser.g:3552:2: ()
            // InternalExprParser.g:3553:5: 
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
            if ( state.backtracking==0 ) {
               
              		if (current==null) {
              			current = createModelElement(grammarAccess.getListLiteralRule());
              		}
                      newCompositeNode(grammarAccess.getListLiteralAccess().getExpressionListParserRuleCall_2()); 
                  
            }
            pushFollow(FOLLOW_2);
            this_ExpressionList_2=ruleExpressionList(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_ExpressionList_2;
                      afterParserOrEnumRuleCall();
                  
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
    // InternalExprParser.g:3583:1: entryRuleSetLiteral returns [EObject current=null] : iv_ruleSetLiteral= ruleSetLiteral EOF ;
    public final EObject entryRuleSetLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetLiteral = null;


        try {
            // InternalExprParser.g:3584:2: (iv_ruleSetLiteral= ruleSetLiteral EOF )
            // InternalExprParser.g:3585:2: iv_ruleSetLiteral= ruleSetLiteral EOF
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
    // InternalExprParser.g:3592:1: ruleSetLiteral returns [EObject current=null] : ( () otherlv_1= Set this_ExpressionList_2= ruleExpressionList[$current] ) ;
    public final EObject ruleSetLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_ExpressionList_2 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3595:28: ( ( () otherlv_1= Set this_ExpressionList_2= ruleExpressionList[$current] ) )
            // InternalExprParser.g:3596:1: ( () otherlv_1= Set this_ExpressionList_2= ruleExpressionList[$current] )
            {
            // InternalExprParser.g:3596:1: ( () otherlv_1= Set this_ExpressionList_2= ruleExpressionList[$current] )
            // InternalExprParser.g:3596:2: () otherlv_1= Set this_ExpressionList_2= ruleExpressionList[$current]
            {
            // InternalExprParser.g:3596:2: ()
            // InternalExprParser.g:3597:5: 
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
            if ( state.backtracking==0 ) {
               
              		if (current==null) {
              			current = createModelElement(grammarAccess.getSetLiteralRule());
              		}
                      newCompositeNode(grammarAccess.getSetLiteralAccess().getExpressionListParserRuleCall_2()); 
                  
            }
            pushFollow(FOLLOW_2);
            this_ExpressionList_2=ruleExpressionList(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_ExpressionList_2;
                      afterParserOrEnumRuleCall();
                  
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
    // InternalExprParser.g:3627:1: entryRuleRecordLiteral returns [EObject current=null] : iv_ruleRecordLiteral= ruleRecordLiteral EOF ;
    public final EObject entryRuleRecordLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordLiteral = null;


        try {
            // InternalExprParser.g:3628:2: (iv_ruleRecordLiteral= ruleRecordLiteral EOF )
            // InternalExprParser.g:3629:2: iv_ruleRecordLiteral= ruleRecordLiteral EOF
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
    // InternalExprParser.g:3636:1: ruleRecordLiteral returns [EObject current=null] : ( () otherlv_1= Record ) ;
    public final EObject ruleRecordLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:3639:28: ( ( () otherlv_1= Record ) )
            // InternalExprParser.g:3640:1: ( () otherlv_1= Record )
            {
            // InternalExprParser.g:3640:1: ( () otherlv_1= Record )
            // InternalExprParser.g:3640:2: () otherlv_1= Record
            {
            // InternalExprParser.g:3640:2: ()
            // InternalExprParser.g:3641:5: 
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
    // InternalExprParser.g:3659:1: entryRuleUnionLiteral returns [EObject current=null] : iv_ruleUnionLiteral= ruleUnionLiteral EOF ;
    public final EObject entryRuleUnionLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnionLiteral = null;


        try {
            // InternalExprParser.g:3660:2: (iv_ruleUnionLiteral= ruleUnionLiteral EOF )
            // InternalExprParser.g:3661:2: iv_ruleUnionLiteral= ruleUnionLiteral EOF
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
    // InternalExprParser.g:3668:1: ruleUnionLiteral returns [EObject current=null] : ( () otherlv_1= Union ) ;
    public final EObject ruleUnionLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:3671:28: ( ( () otherlv_1= Union ) )
            // InternalExprParser.g:3672:1: ( () otherlv_1= Union )
            {
            // InternalExprParser.g:3672:1: ( () otherlv_1= Union )
            // InternalExprParser.g:3672:2: () otherlv_1= Union
            {
            // InternalExprParser.g:3672:2: ()
            // InternalExprParser.g:3673:5: 
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
    // InternalExprParser.g:3691:1: entryRuleTupleLiteral returns [EObject current=null] : iv_ruleTupleLiteral= ruleTupleLiteral EOF ;
    public final EObject entryRuleTupleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteral = null;


        try {
            // InternalExprParser.g:3692:2: (iv_ruleTupleLiteral= ruleTupleLiteral EOF )
            // InternalExprParser.g:3693:2: iv_ruleTupleLiteral= ruleTupleLiteral EOF
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
    // InternalExprParser.g:3700:1: ruleTupleLiteral returns [EObject current=null] : ( () otherlv_1= Tuple this_ExpressionList_2= ruleExpressionList[$current] ) ;
    public final EObject ruleTupleLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_ExpressionList_2 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3703:28: ( ( () otherlv_1= Tuple this_ExpressionList_2= ruleExpressionList[$current] ) )
            // InternalExprParser.g:3704:1: ( () otherlv_1= Tuple this_ExpressionList_2= ruleExpressionList[$current] )
            {
            // InternalExprParser.g:3704:1: ( () otherlv_1= Tuple this_ExpressionList_2= ruleExpressionList[$current] )
            // InternalExprParser.g:3704:2: () otherlv_1= Tuple this_ExpressionList_2= ruleExpressionList[$current]
            {
            // InternalExprParser.g:3704:2: ()
            // InternalExprParser.g:3705:5: 
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
            if ( state.backtracking==0 ) {
               
              		if (current==null) {
              			current = createModelElement(grammarAccess.getTupleLiteralRule());
              		}
                      newCompositeNode(grammarAccess.getTupleLiteralAccess().getExpressionListParserRuleCall_2()); 
                  
            }
            pushFollow(FOLLOW_2);
            this_ExpressionList_2=ruleExpressionList(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_ExpressionList_2;
                      afterParserOrEnumRuleCall();
                  
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
    // InternalExprParser.g:3735:1: entryRuleBagLiteral returns [EObject current=null] : iv_ruleBagLiteral= ruleBagLiteral EOF ;
    public final EObject entryRuleBagLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBagLiteral = null;


        try {
            // InternalExprParser.g:3736:2: (iv_ruleBagLiteral= ruleBagLiteral EOF )
            // InternalExprParser.g:3737:2: iv_ruleBagLiteral= ruleBagLiteral EOF
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
    // InternalExprParser.g:3744:1: ruleBagLiteral returns [EObject current=null] : ( () otherlv_1= Bag this_ExpressionList_2= ruleExpressionList[$current] ) ;
    public final EObject ruleBagLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_ExpressionList_2 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3747:28: ( ( () otherlv_1= Bag this_ExpressionList_2= ruleExpressionList[$current] ) )
            // InternalExprParser.g:3748:1: ( () otherlv_1= Bag this_ExpressionList_2= ruleExpressionList[$current] )
            {
            // InternalExprParser.g:3748:1: ( () otherlv_1= Bag this_ExpressionList_2= ruleExpressionList[$current] )
            // InternalExprParser.g:3748:2: () otherlv_1= Bag this_ExpressionList_2= ruleExpressionList[$current]
            {
            // InternalExprParser.g:3748:2: ()
            // InternalExprParser.g:3749:5: 
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
            if ( state.backtracking==0 ) {
               
              		if (current==null) {
              			current = createModelElement(grammarAccess.getBagLiteralRule());
              		}
                      newCompositeNode(grammarAccess.getBagLiteralAccess().getExpressionListParserRuleCall_2()); 
                  
            }
            pushFollow(FOLLOW_2);
            this_ExpressionList_2=ruleExpressionList(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_ExpressionList_2;
                      afterParserOrEnumRuleCall();
                  
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
    // InternalExprParser.g:3779:1: entryRuleMapLiteral returns [EObject current=null] : iv_ruleMapLiteral= ruleMapLiteral EOF ;
    public final EObject entryRuleMapLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapLiteral = null;


        try {
            // InternalExprParser.g:3780:2: (iv_ruleMapLiteral= ruleMapLiteral EOF )
            // InternalExprParser.g:3781:2: iv_ruleMapLiteral= ruleMapLiteral EOF
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
    // InternalExprParser.g:3788:1: ruleMapLiteral returns [EObject current=null] : ( () otherlv_1= Map ) ;
    public final EObject ruleMapLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:3791:28: ( ( () otherlv_1= Map ) )
            // InternalExprParser.g:3792:1: ( () otherlv_1= Map )
            {
            // InternalExprParser.g:3792:1: ( () otherlv_1= Map )
            // InternalExprParser.g:3792:2: () otherlv_1= Map
            {
            // InternalExprParser.g:3792:2: ()
            // InternalExprParser.g:3793:5: 
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


    // $ANTLR start "entryRuleQCREF"
    // InternalExprParser.g:3813:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // InternalExprParser.g:3814:1: (iv_ruleQCREF= ruleQCREF EOF )
            // InternalExprParser.g:3815:2: iv_ruleQCREF= ruleQCREF EOF
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
    // InternalExprParser.g:3822:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID ( ( ( FullStop )=>kw= FullStop ) this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:3826:6: ( ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID ( ( ( FullStop )=>kw= FullStop ) this_ID_4= RULE_ID )? ) )
            // InternalExprParser.g:3827:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID ( ( ( FullStop )=>kw= FullStop ) this_ID_4= RULE_ID )? )
            {
            // InternalExprParser.g:3827:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID ( ( ( FullStop )=>kw= FullStop ) this_ID_4= RULE_ID )? )
            // InternalExprParser.g:3827:2: (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID ( ( ( FullStop )=>kw= FullStop ) this_ID_4= RULE_ID )?
            {
            // InternalExprParser.g:3827:2: (this_ID_0= RULE_ID kw= ColonColon )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==RULE_ID) ) {
                    int LA45_1 = input.LA(2);

                    if ( (LA45_1==ColonColon) ) {
                        alt45=1;
                    }


                }


                switch (alt45) {
            	case 1 :
            	    // InternalExprParser.g:3827:7: this_ID_0= RULE_ID kw= ColonColon
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_41); if (state.failed) return current;
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
            	    break loop45;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); 
                  
            }
            // InternalExprParser.g:3847:1: ( ( ( FullStop )=>kw= FullStop ) this_ID_4= RULE_ID )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==FullStop) ) {
                int LA46_1 = input.LA(2);

                if ( (LA46_1==RULE_ID) ) {
                    int LA46_3 = input.LA(3);

                    if ( (synpred11_InternalExprParser()) ) {
                        alt46=1;
                    }
                }
            }
            switch (alt46) {
                case 1 :
                    // InternalExprParser.g:3847:2: ( ( FullStop )=>kw= FullStop ) this_ID_4= RULE_ID
                    {
                    // InternalExprParser.g:3847:2: ( ( FullStop )=>kw= FullStop )
                    // InternalExprParser.g:3847:3: ( FullStop )=>kw= FullStop
                    {
                    kw=(Token)match(input,FullStop,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQCREFAccess().getFullStopKeyword_2_0()); 
                          
                    }

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


    // $ANTLR start "entryRuleContainedPropertyAssociation"
    // InternalExprParser.g:3872:1: entryRuleContainedPropertyAssociation returns [EObject current=null] : iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF ;
    public final EObject entryRuleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainedPropertyAssociation = null;


        try {
            // InternalExprParser.g:3873:2: (iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF )
            // InternalExprParser.g:3874:2: iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF
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
    // InternalExprParser.g:3881:1: ruleContainedPropertyAssociation returns [EObject current=null] : ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon ) ;
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
            // InternalExprParser.g:3884:28: ( ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon ) )
            // InternalExprParser.g:3885:1: ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon )
            {
            // InternalExprParser.g:3885:1: ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon )
            // InternalExprParser.g:3885:2: ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon
            {
            // InternalExprParser.g:3885:2: ( ( ruleQPREF ) )
            // InternalExprParser.g:3886:1: ( ruleQPREF )
            {
            // InternalExprParser.g:3886:1: ( ruleQPREF )
            // InternalExprParser.g:3887:3: ruleQPREF
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_42);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalExprParser.g:3901:2: (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) )
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
                    // InternalExprParser.g:3902:2: otherlv_1= EqualsSignGreaterThanSign
                    {
                    otherlv_1=(Token)match(input,EqualsSignGreaterThanSign,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:3907:6: ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) )
                    {
                    // InternalExprParser.g:3907:6: ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) )
                    // InternalExprParser.g:3908:1: (lv_append_2_0= PlusSignEqualsSignGreaterThanSign )
                    {
                    // InternalExprParser.g:3908:1: (lv_append_2_0= PlusSignEqualsSignGreaterThanSign )
                    // InternalExprParser.g:3909:3: lv_append_2_0= PlusSignEqualsSignGreaterThanSign
                    {
                    lv_append_2_0=(Token)match(input,PlusSignEqualsSignGreaterThanSign,FOLLOW_43); if (state.failed) return current;
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

            // InternalExprParser.g:3923:3: ( (lv_constant_3_0= Constant ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==Constant) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalExprParser.g:3924:1: (lv_constant_3_0= Constant )
                    {
                    // InternalExprParser.g:3924:1: (lv_constant_3_0= Constant )
                    // InternalExprParser.g:3925:3: lv_constant_3_0= Constant
                    {
                    lv_constant_3_0=(Token)match(input,Constant,FOLLOW_43); if (state.failed) return current;
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

            // InternalExprParser.g:3939:3: ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* )
            // InternalExprParser.g:3939:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            {
            // InternalExprParser.g:3939:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            // InternalExprParser.g:3940:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            {
            // InternalExprParser.g:3940:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            // InternalExprParser.g:3941:3: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0()); 
              	    
            }
            pushFollow(FOLLOW_44);
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

            // InternalExprParser.g:3957:2: (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==Comma) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalExprParser.g:3958:2: otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    {
            	    otherlv_5=(Token)match(input,Comma,FOLLOW_43); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0());
            	          
            	    }
            	    // InternalExprParser.g:3962:1: ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    // InternalExprParser.g:3963:1: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    {
            	    // InternalExprParser.g:3963:1: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    // InternalExprParser.g:3964:3: lv_ownedValue_6_0= ruleOptionalModalPropertyValue
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_44);
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

            // InternalExprParser.g:3980:5: ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==Applies) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalExprParser.g:3981:5: ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )*
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
                    // InternalExprParser.g:3988:1: ( (lv_appliesTo_8_0= ruleContainmentPath ) )
                    // InternalExprParser.g:3989:1: (lv_appliesTo_8_0= ruleContainmentPath )
                    {
                    // InternalExprParser.g:3989:1: (lv_appliesTo_8_0= ruleContainmentPath )
                    // InternalExprParser.g:3990:3: lv_appliesTo_8_0= ruleContainmentPath
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_45);
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

                    // InternalExprParser.g:4006:2: (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==Comma) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // InternalExprParser.g:4007:2: otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) )
                    	    {
                    	    otherlv_9=(Token)match(input,Comma,FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_2_0());
                    	          
                    	    }
                    	    // InternalExprParser.g:4011:1: ( (lv_appliesTo_10_0= ruleContainmentPath ) )
                    	    // InternalExprParser.g:4012:1: (lv_appliesTo_10_0= ruleContainmentPath )
                    	    {
                    	    // InternalExprParser.g:4012:1: (lv_appliesTo_10_0= ruleContainmentPath )
                    	    // InternalExprParser.g:4013:3: lv_appliesTo_10_0= ruleContainmentPath
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_45);
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

            // InternalExprParser.g:4029:6: ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==In) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalExprParser.g:4030:5: ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis
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
                    // InternalExprParser.g:4042:1: ( ( ruleQCREF ) )
                    // InternalExprParser.g:4043:1: ( ruleQCREF )
                    {
                    // InternalExprParser.g:4043:1: ( ruleQCREF )
                    // InternalExprParser.g:4044:3: ruleQCREF
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

                    otherlv_14=(Token)match(input,RightParenthesis,FOLLOW_46); if (state.failed) return current;
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
    // InternalExprParser.g:4080:1: entryRuleContainmentPath returns [EObject current=null] : iv_ruleContainmentPath= ruleContainmentPath EOF ;
    public final EObject entryRuleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPath = null;


        try {
            // InternalExprParser.g:4081:2: (iv_ruleContainmentPath= ruleContainmentPath EOF )
            // InternalExprParser.g:4082:2: iv_ruleContainmentPath= ruleContainmentPath EOF
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
    // InternalExprParser.g:4089:1: ruleContainmentPath returns [EObject current=null] : ( (lv_path_0_0= ruleContainmentPathElement ) ) ;
    public final EObject ruleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:4092:28: ( ( (lv_path_0_0= ruleContainmentPathElement ) ) )
            // InternalExprParser.g:4093:1: ( (lv_path_0_0= ruleContainmentPathElement ) )
            {
            // InternalExprParser.g:4093:1: ( (lv_path_0_0= ruleContainmentPathElement ) )
            // InternalExprParser.g:4094:1: (lv_path_0_0= ruleContainmentPathElement )
            {
            // InternalExprParser.g:4094:1: (lv_path_0_0= ruleContainmentPathElement )
            // InternalExprParser.g:4095:3: lv_path_0_0= ruleContainmentPathElement
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
    // InternalExprParser.g:4121:1: entryRuleOptionalModalPropertyValue returns [EObject current=null] : iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF ;
    public final EObject entryRuleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalModalPropertyValue = null;


        try {
            // InternalExprParser.g:4122:2: (iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF )
            // InternalExprParser.g:4123:2: iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF
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
    // InternalExprParser.g:4130:1: ruleOptionalModalPropertyValue returns [EObject current=null] : ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? ) ;
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
            // InternalExprParser.g:4133:28: ( ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? ) )
            // InternalExprParser.g:4134:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? )
            {
            // InternalExprParser.g:4134:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? )
            // InternalExprParser.g:4134:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )?
            {
            // InternalExprParser.g:4134:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalExprParser.g:4135:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalExprParser.g:4135:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalExprParser.g:4136:3: lv_ownedValue_0_0= rulePropertyExpression
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
                      		"org.osate.expr.Expr.PropertyExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalExprParser.g:4152:2: ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )?
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
                    // InternalExprParser.g:4153:5: ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis
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
                    // InternalExprParser.g:4165:1: ( (otherlv_3= RULE_ID ) )
                    // InternalExprParser.g:4166:1: (otherlv_3= RULE_ID )
                    {
                    // InternalExprParser.g:4166:1: (otherlv_3= RULE_ID )
                    // InternalExprParser.g:4167:3: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                      	        }
                              
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_3, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_2_0()); 
                      	
                    }

                    }


                    }

                    // InternalExprParser.g:4178:2: (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==Comma) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalExprParser.g:4179:2: otherlv_4= Comma ( (otherlv_5= RULE_ID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_3_0());
                    	          
                    	    }
                    	    // InternalExprParser.g:4183:1: ( (otherlv_5= RULE_ID ) )
                    	    // InternalExprParser.g:4184:1: (otherlv_5= RULE_ID )
                    	    {
                    	    // InternalExprParser.g:4184:1: (otherlv_5= RULE_ID )
                    	    // InternalExprParser.g:4185:3: otherlv_5= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_40); if (state.failed) return current;
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
    // InternalExprParser.g:4209:1: entryRulePropertyValue returns [EObject current=null] : iv_rulePropertyValue= rulePropertyValue EOF ;
    public final EObject entryRulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValue = null;


        try {
            // InternalExprParser.g:4210:2: (iv_rulePropertyValue= rulePropertyValue EOF )
            // InternalExprParser.g:4211:2: iv_rulePropertyValue= rulePropertyValue EOF
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
    // InternalExprParser.g:4218:1: rulePropertyValue returns [EObject current=null] : ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ;
    public final EObject rulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedValue_0_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:4221:28: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) )
            // InternalExprParser.g:4222:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            {
            // InternalExprParser.g:4222:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalExprParser.g:4223:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalExprParser.g:4223:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalExprParser.g:4224:3: lv_ownedValue_0_0= rulePropertyExpression
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
                      		"org.osate.expr.Expr.PropertyExpression");
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


    // $ANTLR start "entryRuleConstantValue"
    // InternalExprParser.g:4252:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // InternalExprParser.g:4253:2: (iv_ruleConstantValue= ruleConstantValue EOF )
            // InternalExprParser.g:4254:2: iv_ruleConstantValue= ruleConstantValue EOF
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
    // InternalExprParser.g:4261:1: ruleConstantValue returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:4264:28: ( ( ( ruleQPREF ) ) )
            // InternalExprParser.g:4265:1: ( ( ruleQPREF ) )
            {
            // InternalExprParser.g:4265:1: ( ( ruleQPREF ) )
            // InternalExprParser.g:4266:1: ( ruleQPREF )
            {
            // InternalExprParser.g:4266:1: ( ruleQPREF )
            // InternalExprParser.g:4267:3: ruleQPREF
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


    // $ANTLR start "entryRuleFieldPropertyAssociation"
    // InternalExprParser.g:4301:1: entryRuleFieldPropertyAssociation returns [EObject current=null] : iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF ;
    public final EObject entryRuleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldPropertyAssociation = null;


        try {
            // InternalExprParser.g:4302:2: (iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF )
            // InternalExprParser.g:4303:2: iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF
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
    // InternalExprParser.g:4310:1: ruleFieldPropertyAssociation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon ) ;
    public final EObject ruleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedValue_2_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:4313:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon ) )
            // InternalExprParser.g:4314:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon )
            {
            // InternalExprParser.g:4314:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon )
            // InternalExprParser.g:4314:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon
            {
            // InternalExprParser.g:4314:2: ( (otherlv_0= RULE_ID ) )
            // InternalExprParser.g:4315:1: (otherlv_0= RULE_ID )
            {
            // InternalExprParser.g:4315:1: (otherlv_0= RULE_ID )
            // InternalExprParser.g:4316:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFieldPropertyAssociationRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0()); 
              	
            }

            }


            }

            otherlv_1=(Token)match(input,EqualsSignGreaterThanSign,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // InternalExprParser.g:4332:1: ( (lv_ownedValue_2_0= rulePropertyExpression ) )
            // InternalExprParser.g:4333:1: (lv_ownedValue_2_0= rulePropertyExpression )
            {
            // InternalExprParser.g:4333:1: (lv_ownedValue_2_0= rulePropertyExpression )
            // InternalExprParser.g:4334:3: lv_ownedValue_2_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_46);
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
                      		"org.osate.expr.Expr.PropertyExpression");
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
    // InternalExprParser.g:4363:1: entryRuleContainmentPathElement returns [EObject current=null] : iv_ruleContainmentPathElement= ruleContainmentPathElement EOF ;
    public final EObject entryRuleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPathElement = null;


        try {
            // InternalExprParser.g:4364:2: (iv_ruleContainmentPathElement= ruleContainmentPathElement EOF )
            // InternalExprParser.g:4365:2: iv_ruleContainmentPathElement= ruleContainmentPathElement EOF
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
    // InternalExprParser.g:4372:1: ruleContainmentPathElement returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) ;
    public final EObject ruleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_arrayRange_1_0 = null;

        EObject lv_path_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:4375:28: ( ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) )
            // InternalExprParser.g:4376:1: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            {
            // InternalExprParser.g:4376:1: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            // InternalExprParser.g:4376:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            {
            // InternalExprParser.g:4376:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* )
            // InternalExprParser.g:4376:3: ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )*
            {
            // InternalExprParser.g:4376:3: ( (otherlv_0= RULE_ID ) )
            // InternalExprParser.g:4377:1: (otherlv_0= RULE_ID )
            {
            // InternalExprParser.g:4377:1: (otherlv_0= RULE_ID )
            // InternalExprParser.g:4378:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getContainmentPathElementRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0_0()); 
              	
            }

            }


            }

            // InternalExprParser.g:4389:2: ( (lv_arrayRange_1_0= ruleArrayRange ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==LeftSquareBracket) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalExprParser.g:4390:1: (lv_arrayRange_1_0= ruleArrayRange )
            	    {
            	    // InternalExprParser.g:4390:1: (lv_arrayRange_1_0= ruleArrayRange )
            	    // InternalExprParser.g:4391:3: lv_arrayRange_1_0= ruleArrayRange
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_49);
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
            	    break loop55;
                }
            } while (true);


            }

            // InternalExprParser.g:4407:4: (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==FullStop) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalExprParser.g:4408:2: otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) )
                    {
                    otherlv_2=(Token)match(input,FullStop,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getFullStopKeyword_1_0());
                          
                    }
                    // InternalExprParser.g:4412:1: ( (lv_path_3_0= ruleContainmentPathElement ) )
                    // InternalExprParser.g:4413:1: (lv_path_3_0= ruleContainmentPathElement )
                    {
                    // InternalExprParser.g:4413:1: (lv_path_3_0= ruleContainmentPathElement )
                    // InternalExprParser.g:4414:3: lv_path_3_0= ruleContainmentPathElement
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
    // InternalExprParser.g:4440:1: entryRulePlusMinus returns [String current=null] : iv_rulePlusMinus= rulePlusMinus EOF ;
    public final String entryRulePlusMinus() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePlusMinus = null;


        try {
            // InternalExprParser.g:4441:1: (iv_rulePlusMinus= rulePlusMinus EOF )
            // InternalExprParser.g:4442:2: iv_rulePlusMinus= rulePlusMinus EOF
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
    // InternalExprParser.g:4449:1: rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= PlusSign | kw= HyphenMinus ) ;
    public final AntlrDatatypeRuleToken rulePlusMinus() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:4453:6: ( (kw= PlusSign | kw= HyphenMinus ) )
            // InternalExprParser.g:4454:1: (kw= PlusSign | kw= HyphenMinus )
            {
            // InternalExprParser.g:4454:1: (kw= PlusSign | kw= HyphenMinus )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==PlusSign) ) {
                alt57=1;
            }
            else if ( (LA57_0==HyphenMinus) ) {
                alt57=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // InternalExprParser.g:4455:2: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:4462:2: kw= HyphenMinus
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


    // $ANTLR start "entryRuleNoQuoteString"
    // InternalExprParser.g:4477:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // InternalExprParser.g:4478:1: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // InternalExprParser.g:4479:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
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
    // InternalExprParser.g:4486:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:4490:6: (this_STRING_0= RULE_STRING )
            // InternalExprParser.g:4491:5: this_STRING_0= RULE_STRING
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
    // InternalExprParser.g:4506:1: entryRuleArrayRange returns [EObject current=null] : iv_ruleArrayRange= ruleArrayRange EOF ;
    public final EObject entryRuleArrayRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRange = null;


        try {
            // InternalExprParser.g:4507:2: (iv_ruleArrayRange= ruleArrayRange EOF )
            // InternalExprParser.g:4508:2: iv_ruleArrayRange= ruleArrayRange EOF
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
    // InternalExprParser.g:4515:1: ruleArrayRange returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket ) ;
    public final EObject ruleArrayRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_lowerBound_2_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_4_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:4518:28: ( ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket ) )
            // InternalExprParser.g:4519:1: ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket )
            {
            // InternalExprParser.g:4519:1: ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket )
            // InternalExprParser.g:4519:2: () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket
            {
            // InternalExprParser.g:4519:2: ()
            // InternalExprParser.g:4520:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getArrayRangeAccess().getArrayRangeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // InternalExprParser.g:4530:1: ( (lv_lowerBound_2_0= ruleINTVALUE ) )
            // InternalExprParser.g:4531:1: (lv_lowerBound_2_0= ruleINTVALUE )
            {
            // InternalExprParser.g:4531:1: (lv_lowerBound_2_0= ruleINTVALUE )
            // InternalExprParser.g:4532:3: lv_lowerBound_2_0= ruleINTVALUE
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_51);
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

            // InternalExprParser.g:4548:2: (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==FullStopFullStop) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalExprParser.g:4549:2: otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    {
                    otherlv_3=(Token)match(input,FullStopFullStop,FOLLOW_50); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
                          
                    }
                    // InternalExprParser.g:4553:1: ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    // InternalExprParser.g:4554:1: (lv_upperBound_4_0= ruleINTVALUE )
                    {
                    // InternalExprParser.g:4554:1: (lv_upperBound_4_0= ruleINTVALUE )
                    // InternalExprParser.g:4555:3: lv_upperBound_4_0= ruleINTVALUE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getArrayRangeAccess().getUpperBoundINTVALUEParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_35);
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
    // InternalExprParser.g:4584:1: entryRuleSignedConstant returns [EObject current=null] : iv_ruleSignedConstant= ruleSignedConstant EOF ;
    public final EObject entryRuleSignedConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedConstant = null;


        try {
            // InternalExprParser.g:4585:2: (iv_ruleSignedConstant= ruleSignedConstant EOF )
            // InternalExprParser.g:4586:2: iv_ruleSignedConstant= ruleSignedConstant EOF
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
    // InternalExprParser.g:4593:1: ruleSignedConstant returns [EObject current=null] : ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) ;
    public final EObject ruleSignedConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:4596:28: ( ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) )
            // InternalExprParser.g:4597:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            {
            // InternalExprParser.g:4597:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            // InternalExprParser.g:4597:2: ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            {
            // InternalExprParser.g:4597:2: ( (lv_op_0_0= rulePlusMinus ) )
            // InternalExprParser.g:4598:1: (lv_op_0_0= rulePlusMinus )
            {
            // InternalExprParser.g:4598:1: (lv_op_0_0= rulePlusMinus )
            // InternalExprParser.g:4599:3: lv_op_0_0= rulePlusMinus
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_5);
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

            // InternalExprParser.g:4615:2: ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            // InternalExprParser.g:4616:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            {
            // InternalExprParser.g:4616:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            // InternalExprParser.g:4617:3: lv_ownedPropertyExpression_1_0= ruleConstantValue
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
    // InternalExprParser.g:4641:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // InternalExprParser.g:4642:2: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // InternalExprParser.g:4643:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
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
    // InternalExprParser.g:4650:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:4653:28: ( ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalExprParser.g:4654:1: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalExprParser.g:4654:1: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalExprParser.g:4654:2: ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalExprParser.g:4654:2: ( (lv_value_0_0= ruleSignedInt ) )
            // InternalExprParser.g:4655:1: (lv_value_0_0= ruleSignedInt )
            {
            // InternalExprParser.g:4655:1: (lv_value_0_0= ruleSignedInt )
            // InternalExprParser.g:4656:3: lv_value_0_0= ruleSignedInt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_52);
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

            // InternalExprParser.g:4672:2: ( (otherlv_1= RULE_ID ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_ID) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalExprParser.g:4673:1: (otherlv_1= RULE_ID )
                    {
                    // InternalExprParser.g:4673:1: (otherlv_1= RULE_ID )
                    // InternalExprParser.g:4674:3: otherlv_1= RULE_ID
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
    // InternalExprParser.g:4693:1: entryRuleSignedInt returns [String current=null] : iv_ruleSignedInt= ruleSignedInt EOF ;
    public final String entryRuleSignedInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInt = null;


        try {
            // InternalExprParser.g:4694:1: (iv_ruleSignedInt= ruleSignedInt EOF )
            // InternalExprParser.g:4695:2: iv_ruleSignedInt= ruleSignedInt EOF
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
    // InternalExprParser.g:4702:1: ruleSignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INTEGER_LIT_2=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:4706:6: ( ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) )
            // InternalExprParser.g:4707:1: ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            {
            // InternalExprParser.g:4707:1: ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            // InternalExprParser.g:4707:2: (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT
            {
            // InternalExprParser.g:4707:2: (kw= PlusSign | kw= HyphenMinus )?
            int alt60=3;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==PlusSign) ) {
                alt60=1;
            }
            else if ( (LA60_0==HyphenMinus) ) {
                alt60=2;
            }
            switch (alt60) {
                case 1 :
                    // InternalExprParser.g:4708:2: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FOLLOW_50); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:4715:2: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FOLLOW_50); if (state.failed) return current;
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
    // InternalExprParser.g:4735:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // InternalExprParser.g:4736:2: (iv_ruleRealTerm= ruleRealTerm EOF )
            // InternalExprParser.g:4737:2: iv_ruleRealTerm= ruleRealTerm EOF
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
    // InternalExprParser.g:4744:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:4747:28: ( ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalExprParser.g:4748:1: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalExprParser.g:4748:1: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalExprParser.g:4748:2: ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalExprParser.g:4748:2: ( (lv_value_0_0= ruleSignedReal ) )
            // InternalExprParser.g:4749:1: (lv_value_0_0= ruleSignedReal )
            {
            // InternalExprParser.g:4749:1: (lv_value_0_0= ruleSignedReal )
            // InternalExprParser.g:4750:3: lv_value_0_0= ruleSignedReal
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_52);
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

            // InternalExprParser.g:4766:2: ( (otherlv_1= RULE_ID ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==RULE_ID) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalExprParser.g:4767:1: (otherlv_1= RULE_ID )
                    {
                    // InternalExprParser.g:4767:1: (otherlv_1= RULE_ID )
                    // InternalExprParser.g:4768:3: otherlv_1= RULE_ID
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
    // InternalExprParser.g:4787:1: entryRuleSignedReal returns [String current=null] : iv_ruleSignedReal= ruleSignedReal EOF ;
    public final String entryRuleSignedReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedReal = null;


        try {
            // InternalExprParser.g:4788:1: (iv_ruleSignedReal= ruleSignedReal EOF )
            // InternalExprParser.g:4789:2: iv_ruleSignedReal= ruleSignedReal EOF
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
    // InternalExprParser.g:4796:1: ruleSignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_REAL_LIT_2=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:4800:6: ( ( (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT ) )
            // InternalExprParser.g:4801:1: ( (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT )
            {
            // InternalExprParser.g:4801:1: ( (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT )
            // InternalExprParser.g:4801:2: (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT
            {
            // InternalExprParser.g:4801:2: (kw= PlusSign | kw= HyphenMinus )?
            int alt62=3;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==PlusSign) ) {
                alt62=1;
            }
            else if ( (LA62_0==HyphenMinus) ) {
                alt62=2;
            }
            switch (alt62) {
                case 1 :
                    // InternalExprParser.g:4802:2: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FOLLOW_53); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:4809:2: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FOLLOW_53); if (state.failed) return current;
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


    // $ANTLR start "entryRuleNumAlt"
    // InternalExprParser.g:4831:1: entryRuleNumAlt returns [EObject current=null] : iv_ruleNumAlt= ruleNumAlt EOF ;
    public final EObject entryRuleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumAlt = null;


        try {
            // InternalExprParser.g:4832:2: (iv_ruleNumAlt= ruleNumAlt EOF )
            // InternalExprParser.g:4833:2: iv_ruleNumAlt= ruleNumAlt EOF
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
    // InternalExprParser.g:4840:1: ruleNumAlt returns [EObject current=null] : (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) ;
    public final EObject ruleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject this_RealTerm_0 = null;

        EObject this_IntegerTerm_1 = null;

        EObject this_SignedConstant_2 = null;

        EObject this_ConstantValue_3 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:4843:28: ( (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) )
            // InternalExprParser.g:4844:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            {
            // InternalExprParser.g:4844:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            int alt63=4;
            switch ( input.LA(1) ) {
            case PlusSign:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    alt63=3;
                    }
                    break;
                case RULE_REAL_LIT:
                    {
                    alt63=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt63=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 1, input);

                    throw nvae;
                }

                }
                break;
            case HyphenMinus:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    alt63=3;
                    }
                    break;
                case RULE_REAL_LIT:
                    {
                    alt63=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt63=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 2, input);

                    throw nvae;
                }

                }
                break;
            case RULE_REAL_LIT:
                {
                alt63=1;
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt63=2;
                }
                break;
            case RULE_ID:
                {
                alt63=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // InternalExprParser.g:4845:5: this_RealTerm_0= ruleRealTerm
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
                    // InternalExprParser.g:4855:5: this_IntegerTerm_1= ruleIntegerTerm
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
                    // InternalExprParser.g:4865:5: this_SignedConstant_2= ruleSignedConstant
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
                    // InternalExprParser.g:4875:5: this_ConstantValue_3= ruleConstantValue
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
    // InternalExprParser.g:4891:1: entryRuleAppliesToKeywords returns [String current=null] : iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF ;
    public final String entryRuleAppliesToKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAppliesToKeywords = null;


        try {
            // InternalExprParser.g:4892:1: (iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF )
            // InternalExprParser.g:4893:2: iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF
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
    // InternalExprParser.g:4900:1: ruleAppliesToKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Applies kw= To ) ;
    public final AntlrDatatypeRuleToken ruleAppliesToKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:4904:6: ( (kw= Applies kw= To ) )
            // InternalExprParser.g:4905:1: (kw= Applies kw= To )
            {
            // InternalExprParser.g:4905:1: (kw= Applies kw= To )
            // InternalExprParser.g:4906:2: kw= Applies kw= To
            {
            kw=(Token)match(input,Applies,FOLLOW_54); if (state.failed) return current;
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
    // InternalExprParser.g:4925:1: entryRuleInBindingKeywords returns [String current=null] : iv_ruleInBindingKeywords= ruleInBindingKeywords EOF ;
    public final String entryRuleInBindingKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInBindingKeywords = null;


        try {
            // InternalExprParser.g:4926:1: (iv_ruleInBindingKeywords= ruleInBindingKeywords EOF )
            // InternalExprParser.g:4927:2: iv_ruleInBindingKeywords= ruleInBindingKeywords EOF
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
    // InternalExprParser.g:4934:1: ruleInBindingKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= In kw= Binding ) ;
    public final AntlrDatatypeRuleToken ruleInBindingKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:4938:6: ( (kw= In kw= Binding ) )
            // InternalExprParser.g:4939:1: (kw= In kw= Binding )
            {
            // InternalExprParser.g:4939:1: (kw= In kw= Binding )
            // InternalExprParser.g:4940:2: kw= In kw= Binding
            {
            kw=(Token)match(input,In,FOLLOW_55); if (state.failed) return current;
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
    // InternalExprParser.g:4959:1: entryRuleInModesKeywords returns [String current=null] : iv_ruleInModesKeywords= ruleInModesKeywords EOF ;
    public final String entryRuleInModesKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInModesKeywords = null;


        try {
            // InternalExprParser.g:4960:1: (iv_ruleInModesKeywords= ruleInModesKeywords EOF )
            // InternalExprParser.g:4961:2: iv_ruleInModesKeywords= ruleInModesKeywords EOF
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
    // InternalExprParser.g:4968:1: ruleInModesKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= In kw= Modes ) ;
    public final AntlrDatatypeRuleToken ruleInModesKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:4972:6: ( (kw= In kw= Modes ) )
            // InternalExprParser.g:4973:1: (kw= In kw= Modes )
            {
            // InternalExprParser.g:4973:1: (kw= In kw= Modes )
            // InternalExprParser.g:4974:2: kw= In kw= Modes
            {
            kw=(Token)match(input,In,FOLLOW_56); if (state.failed) return current;
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
    // InternalExprParser.g:4993:1: entryRuleINTVALUE returns [String current=null] : iv_ruleINTVALUE= ruleINTVALUE EOF ;
    public final String entryRuleINTVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTVALUE = null;


        try {
            // InternalExprParser.g:4994:1: (iv_ruleINTVALUE= ruleINTVALUE EOF )
            // InternalExprParser.g:4995:2: iv_ruleINTVALUE= ruleINTVALUE EOF
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
    // InternalExprParser.g:5002:1: ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleINTVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:5006:6: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // InternalExprParser.g:5007:5: this_INTEGER_LIT_0= RULE_INTEGER_LIT
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
    // InternalExprParser.g:5024:1: entryRuleQPREF returns [String current=null] : iv_ruleQPREF= ruleQPREF EOF ;
    public final String entryRuleQPREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQPREF = null;


        try {
            // InternalExprParser.g:5025:1: (iv_ruleQPREF= ruleQPREF EOF )
            // InternalExprParser.g:5026:2: iv_ruleQPREF= ruleQPREF EOF
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
    // InternalExprParser.g:5033:1: ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQPREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:5037:6: ( (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? ) )
            // InternalExprParser.g:5038:1: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? )
            {
            // InternalExprParser.g:5038:1: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? )
            // InternalExprParser.g:5038:6: this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_57); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // InternalExprParser.g:5045:1: (kw= ColonColon this_ID_2= RULE_ID )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==ColonColon) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalExprParser.g:5046:2: kw= ColonColon this_ID_2= RULE_ID
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


    // $ANTLR start "entryRuleSTAR"
    // InternalExprParser.g:5066:1: entryRuleSTAR returns [String current=null] : iv_ruleSTAR= ruleSTAR EOF ;
    public final String entryRuleSTAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTAR = null;


        try {
            // InternalExprParser.g:5067:1: (iv_ruleSTAR= ruleSTAR EOF )
            // InternalExprParser.g:5068:2: iv_ruleSTAR= ruleSTAR EOF
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
    // InternalExprParser.g:5075:1: ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= Asterisk ;
    public final AntlrDatatypeRuleToken ruleSTAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:5079:6: (kw= Asterisk )
            // InternalExprParser.g:5081:2: kw= Asterisk
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
    // InternalExprParser.g:5094:1: ruleMetaClassEnum returns [Enumerator current=null] : ( (enumLiteral_0= Component ) | (enumLiteral_1= Feature ) | (enumLiteral_2= Connection ) | (enumLiteral_3= Flow ) | (enumLiteral_4= Mode ) | (enumLiteral_5= Property ) ) ;
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
            // InternalExprParser.g:5096:28: ( ( (enumLiteral_0= Component ) | (enumLiteral_1= Feature ) | (enumLiteral_2= Connection ) | (enumLiteral_3= Flow ) | (enumLiteral_4= Mode ) | (enumLiteral_5= Property ) ) )
            // InternalExprParser.g:5097:1: ( (enumLiteral_0= Component ) | (enumLiteral_1= Feature ) | (enumLiteral_2= Connection ) | (enumLiteral_3= Flow ) | (enumLiteral_4= Mode ) | (enumLiteral_5= Property ) )
            {
            // InternalExprParser.g:5097:1: ( (enumLiteral_0= Component ) | (enumLiteral_1= Feature ) | (enumLiteral_2= Connection ) | (enumLiteral_3= Flow ) | (enumLiteral_4= Mode ) | (enumLiteral_5= Property ) )
            int alt65=6;
            switch ( input.LA(1) ) {
            case Component:
                {
                alt65=1;
                }
                break;
            case Feature:
                {
                alt65=2;
                }
                break;
            case Connection:
                {
                alt65=3;
                }
                break;
            case Flow:
                {
                alt65=4;
                }
                break;
            case Mode:
                {
                alt65=5;
                }
                break;
            case Property:
                {
                alt65=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }

            switch (alt65) {
                case 1 :
                    // InternalExprParser.g:5097:2: (enumLiteral_0= Component )
                    {
                    // InternalExprParser.g:5097:2: (enumLiteral_0= Component )
                    // InternalExprParser.g:5097:7: enumLiteral_0= Component
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
                    // InternalExprParser.g:5103:6: (enumLiteral_1= Feature )
                    {
                    // InternalExprParser.g:5103:6: (enumLiteral_1= Feature )
                    // InternalExprParser.g:5103:11: enumLiteral_1= Feature
                    {
                    enumLiteral_1=(Token)match(input,Feature,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMetaClassEnumAccess().getFEATUREEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getMetaClassEnumAccess().getFEATUREEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalExprParser.g:5109:6: (enumLiteral_2= Connection )
                    {
                    // InternalExprParser.g:5109:6: (enumLiteral_2= Connection )
                    // InternalExprParser.g:5109:11: enumLiteral_2= Connection
                    {
                    enumLiteral_2=(Token)match(input,Connection,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMetaClassEnumAccess().getCONNECTIONEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getMetaClassEnumAccess().getCONNECTIONEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalExprParser.g:5115:6: (enumLiteral_3= Flow )
                    {
                    // InternalExprParser.g:5115:6: (enumLiteral_3= Flow )
                    // InternalExprParser.g:5115:11: enumLiteral_3= Flow
                    {
                    enumLiteral_3=(Token)match(input,Flow,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMetaClassEnumAccess().getFLOWEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getMetaClassEnumAccess().getFLOWEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalExprParser.g:5121:6: (enumLiteral_4= Mode )
                    {
                    // InternalExprParser.g:5121:6: (enumLiteral_4= Mode )
                    // InternalExprParser.g:5121:11: enumLiteral_4= Mode
                    {
                    enumLiteral_4=(Token)match(input,Mode,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMetaClassEnumAccess().getMODEEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getMetaClassEnumAccess().getMODEEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalExprParser.g:5127:6: (enumLiteral_5= Property )
                    {
                    // InternalExprParser.g:5127:6: (enumLiteral_5= Property )
                    // InternalExprParser.g:5127:11: enumLiteral_5= Property
                    {
                    enumLiteral_5=(Token)match(input,Property,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMetaClassEnumAccess().getPROPERTYEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getMetaClassEnumAccess().getPROPERTYEnumLiteralDeclaration_5()); 
                          
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
        // InternalExprParser.g:1851:3: ( ( () ( ( ruleOpOr ) ) ) )
        // InternalExprParser.g:1851:4: ( () ( ( ruleOpOr ) ) )
        {
        // InternalExprParser.g:1851:4: ( () ( ( ruleOpOr ) ) )
        // InternalExprParser.g:1851:5: () ( ( ruleOpOr ) )
        {
        // InternalExprParser.g:1851:5: ()
        // InternalExprParser.g:1852:1: 
        {
        }

        // InternalExprParser.g:1852:2: ( ( ruleOpOr ) )
        // InternalExprParser.g:1853:1: ( ruleOpOr )
        {
        // InternalExprParser.g:1853:1: ( ruleOpOr )
        // InternalExprParser.g:1854:1: ruleOpOr
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
        // InternalExprParser.g:1963:3: ( ( () ( ( ruleOpAnd ) ) ) )
        // InternalExprParser.g:1963:4: ( () ( ( ruleOpAnd ) ) )
        {
        // InternalExprParser.g:1963:4: ( () ( ( ruleOpAnd ) ) )
        // InternalExprParser.g:1963:5: () ( ( ruleOpAnd ) )
        {
        // InternalExprParser.g:1963:5: ()
        // InternalExprParser.g:1964:1: 
        {
        }

        // InternalExprParser.g:1964:2: ( ( ruleOpAnd ) )
        // InternalExprParser.g:1965:1: ( ruleOpAnd )
        {
        // InternalExprParser.g:1965:1: ( ruleOpAnd )
        // InternalExprParser.g:1966:1: ruleOpAnd
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
        // InternalExprParser.g:2075:3: ( ( () ( ( ruleOpEquality ) ) ) )
        // InternalExprParser.g:2075:4: ( () ( ( ruleOpEquality ) ) )
        {
        // InternalExprParser.g:2075:4: ( () ( ( ruleOpEquality ) ) )
        // InternalExprParser.g:2075:5: () ( ( ruleOpEquality ) )
        {
        // InternalExprParser.g:2075:5: ()
        // InternalExprParser.g:2076:1: 
        {
        }

        // InternalExprParser.g:2076:2: ( ( ruleOpEquality ) )
        // InternalExprParser.g:2077:1: ( ruleOpEquality )
        {
        // InternalExprParser.g:2077:1: ( ruleOpEquality )
        // InternalExprParser.g:2078:1: ruleOpEquality
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
        // InternalExprParser.g:2187:3: ( ( () ( ( ruleOpCompare ) ) ) )
        // InternalExprParser.g:2187:4: ( () ( ( ruleOpCompare ) ) )
        {
        // InternalExprParser.g:2187:4: ( () ( ( ruleOpCompare ) ) )
        // InternalExprParser.g:2187:5: () ( ( ruleOpCompare ) )
        {
        // InternalExprParser.g:2187:5: ()
        // InternalExprParser.g:2188:1: 
        {
        }

        // InternalExprParser.g:2188:2: ( ( ruleOpCompare ) )
        // InternalExprParser.g:2189:1: ( ruleOpCompare )
        {
        // InternalExprParser.g:2189:1: ( ruleOpCompare )
        // InternalExprParser.g:2190:1: ruleOpCompare
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
        // InternalExprParser.g:2320:3: ( ( () ( ( ruleOpAdd ) ) ) )
        // InternalExprParser.g:2320:4: ( () ( ( ruleOpAdd ) ) )
        {
        // InternalExprParser.g:2320:4: ( () ( ( ruleOpAdd ) ) )
        // InternalExprParser.g:2320:5: () ( ( ruleOpAdd ) )
        {
        // InternalExprParser.g:2320:5: ()
        // InternalExprParser.g:2321:1: 
        {
        }

        // InternalExprParser.g:2321:2: ( ( ruleOpAdd ) )
        // InternalExprParser.g:2322:1: ( ruleOpAdd )
        {
        // InternalExprParser.g:2322:1: ( ruleOpAdd )
        // InternalExprParser.g:2323:1: ruleOpAdd
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
        // InternalExprParser.g:2432:3: ( ( () ( ( ruleOpMulti ) ) ) )
        // InternalExprParser.g:2432:4: ( () ( ( ruleOpMulti ) ) )
        {
        // InternalExprParser.g:2432:4: ( () ( ( ruleOpMulti ) ) )
        // InternalExprParser.g:2432:5: () ( ( ruleOpMulti ) )
        {
        // InternalExprParser.g:2432:5: ()
        // InternalExprParser.g:2433:1: 
        {
        }

        // InternalExprParser.g:2433:2: ( ( ruleOpMulti ) )
        // InternalExprParser.g:2434:1: ( ruleOpMulti )
        {
        // InternalExprParser.g:2434:1: ( ruleOpMulti )
        // InternalExprParser.g:2435:1: ruleOpMulti
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
        // InternalExprParser.g:2759:3: ( ( () NumberSign ) )
        // InternalExprParser.g:2759:4: ( () NumberSign )
        {
        // InternalExprParser.g:2759:4: ( () NumberSign )
        // InternalExprParser.g:2759:5: () NumberSign
        {
        // InternalExprParser.g:2759:5: ()
        // InternalExprParser.g:2760:1: 
        {
        }

        match(input,NumberSign,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_InternalExprParser

    // $ANTLR start synpred9_InternalExprParser
    public final void synpred9_InternalExprParser_fragment() throws RecognitionException {   
        // InternalExprParser.g:2922:4: ( ( () FullStop ) )
        // InternalExprParser.g:2922:5: ( () FullStop )
        {
        // InternalExprParser.g:2922:5: ( () FullStop )
        // InternalExprParser.g:2922:6: () FullStop
        {
        // InternalExprParser.g:2922:6: ()
        // InternalExprParser.g:2923:1: 
        {
        }

        match(input,FullStop,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred9_InternalExprParser

    // $ANTLR start synpred10_InternalExprParser
    public final void synpred10_InternalExprParser_fragment() throws RecognitionException {   
        // InternalExprParser.g:3022:4: ( Delta )
        // InternalExprParser.g:3023:1: Delta
        {
        match(input,Delta,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_InternalExprParser

    // $ANTLR start synpred11_InternalExprParser
    public final void synpred11_InternalExprParser_fragment() throws RecognitionException {   
        // InternalExprParser.g:3847:3: ( FullStop )
        // InternalExprParser.g:3848:2: FullStop
        {
        match(input,FullStop,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_InternalExprParser

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
    public final boolean synpred10_InternalExprParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalExprParser_fragment(); // can never throw exception
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
    public final boolean synpred11_InternalExprParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalExprParser_fragment(); // can never throw exception
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
    static final String dfa_1s = "\22\uffff";
    static final String dfa_2s = "\10\uffff\1\14\1\uffff\1\16\7\uffff";
    static final String dfa_3s = "\1\6\7\uffff\1\40\1\uffff\1\40\1\10\6\uffff";
    static final String dfa_4s = "\1\65\7\uffff\1\142\1\uffff\1\142\1\65\6\uffff";
    static final String dfa_5s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\2\uffff\1\10\1\11\1\14\1\13\1\16\1\15";
    static final String dfa_6s = "\22\uffff}>";
    static final String[] dfa_7s = {
            "\1\10\1\uffff\1\7\2\uffff\1\1\10\uffff\1\6\1\13\1\uffff\1\4\1\5\2\uffff\1\11\1\12\11\uffff\1\3\16\uffff\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\15\40\uffff\1\14\23\uffff\1\14\4\uffff\1\14\1\uffff\1\14\5\uffff\1\14",
            "",
            "\1\17\40\uffff\1\16\23\uffff\1\16\4\uffff\1\16\1\uffff\1\16\5\uffff\1\16",
            "\1\20\54\uffff\1\21",
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
            return "944:1: (kw= Abstract | kw= Bus | kw= Data | kw= Device | kw= Memory | kw= Process | kw= Processor | kw= Subprogram | (kw= Subprogram kw= Group ) | kw= KW_System | (kw= Thread kw= Group ) | kw= Thread | (kw= Virtual kw= Bus ) | (kw= Virtual kw= Processor ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x6041000000400000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x13301F7C1FB429E0L,0x0000100000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000002L,0x0000000012000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x1B309F7C9FB429E0L,0x00001A8140520200L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000100400000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000400200000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x13301F7C1FB429E0L,0x0000100400000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000002L,0x0000000000005000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000002L,0x0000000028000190L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000002L,0x0000000000500000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0480000000000002L,0x0000000001080000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000002L,0x0000100000010400L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000020000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000008040000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x1B309F7C9FB429E0L,0x00001A8140560200L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000000240000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0002000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x1B309F7C9FB439E0L,0x00001A8140520200L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000004000L,0x0000000004200400L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000004200400L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000002L,0x0000000040800000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000004L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x0000100000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});

}