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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Subcomponent", "Classifier", "Connection", "Subprogram", "Component", "Processor", "Subclause", "Abstract", "Element", "Feature", "Library", "Process", "Virtual", "Device", "Memory", "Record", "String", "KW_System", "Thread", "Delta", "Endif", "False", "Group", "Tuple", "Union", "Bool", "Data", "Else", "Flow", "List", "Mode", "Real", "Root", "Then", "This", "True", "Type", "QuestionMarkQuestionMarkQuestionMark", "And", "Bag", "Bus", "Def", "Div", "Int", "Map", "Mod", "Not", "Set", "Val", "Var", "ExclamationMarkEqualsSign", "AmpersandAmpersand", "HyphenMinusGreaterThanSign", "FullStopFullStop", "ColonColon", "LessThanSignEqualsSign", "EqualsSignEqualsSign", "GreaterThanSignLessThanSign", "GreaterThanSignEqualsSign", "If", "In", "Of", "Or", "VerticalLineVerticalLine", "NumberSign", "PercentSign", "LeftParenthesis", "RightParenthesis", "Asterisk", "PlusSign", "Comma", "HyphenMinus", "FullStop", "Solidus", "Colon", "Semicolon", "LessThanSign", "EqualsSign", "GreaterThanSign", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_SL_COMMENT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_REAL_LIT", "RULE_BASED_INTEGER", "RULE_INTEGER_LIT", "RULE_EXTENDED_DIGIT", "RULE_STRING", "RULE_ID", "RULE_WS"
    };
    public static final int Val=52;
    public static final int Or=66;
    public static final int Memory=18;
    public static final int KW_System=21;
    public static final int Var=53;
    public static final int String=20;
    public static final int False=25;
    public static final int Feature=13;
    public static final int LessThanSign=80;
    public static final int LeftParenthesis=70;
    public static final int Bool=29;
    public static final int Subcomponent=4;
    public static final int Then=37;
    public static final int GreaterThanSign=82;
    public static final int Root=36;
    public static final int RULE_ID=96;
    public static final int RULE_DIGIT=88;
    public static final int GreaterThanSignEqualsSign=62;
    public static final int ColonColon=58;
    public static final int EqualsSignEqualsSign=60;
    public static final int PlusSign=73;
    public static final int LeftSquareBracket=83;
    public static final int Map=48;
    public static final int If=63;
    public static final int Group=26;
    public static final int Processor=9;
    public static final int Set=51;
    public static final int In=64;
    public static final int VerticalLineVerticalLine=67;
    public static final int RULE_REAL_LIT=91;
    public static final int Classifier=5;
    public static final int GreaterThanSignLessThanSign=61;
    public static final int Union=28;
    public static final int Comma=74;
    public static final int HyphenMinus=75;
    public static final int LessThanSignEqualsSign=59;
    public static final int Solidus=77;
    public static final int RightCurlyBracket=86;
    public static final int Bus=44;
    public static final int FullStop=76;
    public static final int Abstract=11;
    public static final int Connection=6;
    public static final int Thread=22;
    public static final int Flow=32;
    public static final int Div=46;
    public static final int Semicolon=79;
    public static final int Type=40;
    public static final int RULE_EXPONENT=89;
    public static final int Delta=23;
    public static final int Else=31;
    public static final int RULE_EXTENDED_DIGIT=94;
    public static final int ExclamationMarkEqualsSign=54;
    public static final int HyphenMinusGreaterThanSign=56;
    public static final int Tuple=27;
    public static final int True=39;
    public static final int Process=15;
    public static final int RULE_INT_EXPONENT=90;
    public static final int PercentSign=69;
    public static final int FullStopFullStop=57;
    public static final int Real=35;
    public static final int QuestionMarkQuestionMarkQuestionMark=41;
    public static final int This=38;
    public static final int List=33;
    public static final int RULE_BASED_INTEGER=92;
    public static final int RightSquareBracket=84;
    public static final int Device=17;
    public static final int RightParenthesis=71;
    public static final int Not=50;
    public static final int And=42;
    public static final int NumberSign=68;
    public static final int Library=14;
    public static final int Subprogram=7;
    public static final int RULE_INTEGER_LIT=93;
    public static final int Subclause=10;
    public static final int Element=12;
    public static final int RULE_STRING=95;
    public static final int Int=47;
    public static final int RULE_SL_COMMENT=87;
    public static final int EqualsSign=81;
    public static final int AmpersandAmpersand=55;
    public static final int Record=19;
    public static final int Colon=78;
    public static final int Component=8;
    public static final int EOF=-1;
    public static final int Asterisk=72;
    public static final int Mod=49;
    public static final int Def=45;
    public static final int RULE_WS=97;
    public static final int Endif=24;
    public static final int Mode=34;
    public static final int LeftCurlyBracket=85;
    public static final int Bag=43;
    public static final int Virtual=16;
    public static final int Data=30;
    public static final int Of=65;

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


    // $ANTLR start "ruleDeclarations"
    // InternalExprParser.g:131:1: ruleDeclarations[EObject in_current] returns [EObject current=in_current] : ( ( (lv_decls_0_0= ruleDeclaration ) ) (otherlv_1= Semicolon ( (lv_decls_2_0= ruleDeclaration ) ) )* (otherlv_3= Semicolon )? ) ;
    public final EObject ruleDeclarations(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decls_0_0 = null;

        EObject lv_decls_2_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:134:28: ( ( ( (lv_decls_0_0= ruleDeclaration ) ) (otherlv_1= Semicolon ( (lv_decls_2_0= ruleDeclaration ) ) )* (otherlv_3= Semicolon )? ) )
            // InternalExprParser.g:135:1: ( ( (lv_decls_0_0= ruleDeclaration ) ) (otherlv_1= Semicolon ( (lv_decls_2_0= ruleDeclaration ) ) )* (otherlv_3= Semicolon )? )
            {
            // InternalExprParser.g:135:1: ( ( (lv_decls_0_0= ruleDeclaration ) ) (otherlv_1= Semicolon ( (lv_decls_2_0= ruleDeclaration ) ) )* (otherlv_3= Semicolon )? )
            // InternalExprParser.g:135:2: ( (lv_decls_0_0= ruleDeclaration ) ) (otherlv_1= Semicolon ( (lv_decls_2_0= ruleDeclaration ) ) )* (otherlv_3= Semicolon )?
            {
            // InternalExprParser.g:135:2: ( (lv_decls_0_0= ruleDeclaration ) )
            // InternalExprParser.g:136:1: (lv_decls_0_0= ruleDeclaration )
            {
            // InternalExprParser.g:136:1: (lv_decls_0_0= ruleDeclaration )
            // InternalExprParser.g:137:3: lv_decls_0_0= ruleDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationsAccess().getDeclsDeclarationParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_4);
            lv_decls_0_0=ruleDeclaration();

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
                      		"org.osate.expr.Expr.Declaration");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalExprParser.g:153:2: (otherlv_1= Semicolon ( (lv_decls_2_0= ruleDeclaration ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Semicolon) ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1==Type||LA2_1==Def||(LA2_1>=Val && LA2_1<=Var)) ) {
                        alt2=1;
                    }


                }


                switch (alt2) {
            	case 1 :
            	    // InternalExprParser.g:154:2: otherlv_1= Semicolon ( (lv_decls_2_0= ruleDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,Semicolon,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getDeclarationsAccess().getSemicolonKeyword_1_0());
            	          
            	    }
            	    // InternalExprParser.g:158:1: ( (lv_decls_2_0= ruleDeclaration ) )
            	    // InternalExprParser.g:159:1: (lv_decls_2_0= ruleDeclaration )
            	    {
            	    // InternalExprParser.g:159:1: (lv_decls_2_0= ruleDeclaration )
            	    // InternalExprParser.g:160:3: lv_decls_2_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclarationsAccess().getDeclsDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_decls_2_0=ruleDeclaration();

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
            	              		"org.osate.expr.Expr.Declaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalExprParser.g:176:4: (otherlv_3= Semicolon )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Semicolon) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalExprParser.g:177:2: otherlv_3= Semicolon
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


    // $ANTLR start "entryRuleExprLibrary"
    // InternalExprParser.g:189:1: entryRuleExprLibrary returns [EObject current=null] : iv_ruleExprLibrary= ruleExprLibrary EOF ;
    public final EObject entryRuleExprLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExprLibrary = null;


        try {
            // InternalExprParser.g:190:2: (iv_ruleExprLibrary= ruleExprLibrary EOF )
            // InternalExprParser.g:191:2: iv_ruleExprLibrary= ruleExprLibrary EOF
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
    // InternalExprParser.g:198:1: ruleExprLibrary returns [EObject current=null] : ( () (this_Declarations_1= ruleDeclarations[$current] )? ) ;
    public final EObject ruleExprLibrary() throws RecognitionException {
        EObject current = null;

        EObject this_Declarations_1 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:201:28: ( ( () (this_Declarations_1= ruleDeclarations[$current] )? ) )
            // InternalExprParser.g:202:1: ( () (this_Declarations_1= ruleDeclarations[$current] )? )
            {
            // InternalExprParser.g:202:1: ( () (this_Declarations_1= ruleDeclarations[$current] )? )
            // InternalExprParser.g:202:2: () (this_Declarations_1= ruleDeclarations[$current] )?
            {
            // InternalExprParser.g:202:2: ()
            // InternalExprParser.g:203:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getExprLibraryAccess().getExprLibraryAction_0(),
                          current);
                  
            }

            }

            // InternalExprParser.g:208:2: (this_Declarations_1= ruleDeclarations[$current] )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==Type||LA4_0==Def||(LA4_0>=Val && LA4_0<=Var)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalExprParser.g:209:5: this_Declarations_1= ruleDeclarations[$current]
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
    // InternalExprParser.g:228:1: entryRuleExprSubclause returns [EObject current=null] : iv_ruleExprSubclause= ruleExprSubclause EOF ;
    public final EObject entryRuleExprSubclause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExprSubclause = null;


        try {
            // InternalExprParser.g:229:2: (iv_ruleExprSubclause= ruleExprSubclause EOF )
            // InternalExprParser.g:230:2: iv_ruleExprSubclause= ruleExprSubclause EOF
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
    // InternalExprParser.g:237:1: ruleExprSubclause returns [EObject current=null] : ( () (this_Declarations_1= ruleDeclarations[$current] )? ) ;
    public final EObject ruleExprSubclause() throws RecognitionException {
        EObject current = null;

        EObject this_Declarations_1 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:240:28: ( ( () (this_Declarations_1= ruleDeclarations[$current] )? ) )
            // InternalExprParser.g:241:1: ( () (this_Declarations_1= ruleDeclarations[$current] )? )
            {
            // InternalExprParser.g:241:1: ( () (this_Declarations_1= ruleDeclarations[$current] )? )
            // InternalExprParser.g:241:2: () (this_Declarations_1= ruleDeclarations[$current] )?
            {
            // InternalExprParser.g:241:2: ()
            // InternalExprParser.g:242:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getExprSubclauseAccess().getExprSubclauseAction_0(),
                          current);
                  
            }

            }

            // InternalExprParser.g:247:2: (this_Declarations_1= ruleDeclarations[$current] )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Type||LA5_0==Def||(LA5_0>=Val && LA5_0<=Var)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalExprParser.g:248:5: this_Declarations_1= ruleDeclarations[$current]
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


    // $ANTLR start "entryRuleDeclaration"
    // InternalExprParser.g:269:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // InternalExprParser.g:270:2: (iv_ruleDeclaration= ruleDeclaration EOF )
            // InternalExprParser.g:271:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclaration; 
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
    // $ANTLR end "entryRuleDeclaration"


    // $ANTLR start "ruleDeclaration"
    // InternalExprParser.g:278:1: ruleDeclaration returns [EObject current=null] : (this_TypeDecl_0= ruleTypeDecl | this_VarDecl_1= ruleVarDecl | this_FunDecl_2= ruleFunDecl ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_TypeDecl_0 = null;

        EObject this_VarDecl_1 = null;

        EObject this_FunDecl_2 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:281:28: ( (this_TypeDecl_0= ruleTypeDecl | this_VarDecl_1= ruleVarDecl | this_FunDecl_2= ruleFunDecl ) )
            // InternalExprParser.g:282:1: (this_TypeDecl_0= ruleTypeDecl | this_VarDecl_1= ruleVarDecl | this_FunDecl_2= ruleFunDecl )
            {
            // InternalExprParser.g:282:1: (this_TypeDecl_0= ruleTypeDecl | this_VarDecl_1= ruleVarDecl | this_FunDecl_2= ruleFunDecl )
            int alt6=3;
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
                       
                              newCompositeNode(grammarAccess.getDeclarationAccess().getTypeDeclParserRuleCall_0()); 
                          
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
                       
                              newCompositeNode(grammarAccess.getDeclarationAccess().getVarDeclParserRuleCall_1()); 
                          
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
                       
                              newCompositeNode(grammarAccess.getDeclarationAccess().getFunDeclParserRuleCall_2()); 
                          
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
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "entryRuleTypeDecl"
    // InternalExprParser.g:319:1: entryRuleTypeDecl returns [EObject current=null] : iv_ruleTypeDecl= ruleTypeDecl EOF ;
    public final EObject entryRuleTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDecl = null;


        try {
            // InternalExprParser.g:320:2: (iv_ruleTypeDecl= ruleTypeDecl EOF )
            // InternalExprParser.g:321:2: iv_ruleTypeDecl= ruleTypeDecl EOF
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
    // InternalExprParser.g:328:1: ruleTypeDecl returns [EObject current=null] : ( () otherlv_1= Type ( (lv_name_2_0= RULE_ID ) ) otherlv_3= Colon ( (lv_type_4_0= ruleType ) ) ) ;
    public final EObject ruleTypeDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        EObject lv_type_4_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:331:28: ( ( () otherlv_1= Type ( (lv_name_2_0= RULE_ID ) ) otherlv_3= Colon ( (lv_type_4_0= ruleType ) ) ) )
            // InternalExprParser.g:332:1: ( () otherlv_1= Type ( (lv_name_2_0= RULE_ID ) ) otherlv_3= Colon ( (lv_type_4_0= ruleType ) ) )
            {
            // InternalExprParser.g:332:1: ( () otherlv_1= Type ( (lv_name_2_0= RULE_ID ) ) otherlv_3= Colon ( (lv_type_4_0= ruleType ) ) )
            // InternalExprParser.g:332:2: () otherlv_1= Type ( (lv_name_2_0= RULE_ID ) ) otherlv_3= Colon ( (lv_type_4_0= ruleType ) )
            {
            // InternalExprParser.g:332:2: ()
            // InternalExprParser.g:333:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getTypeDeclAccess().getTypeDeclAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,Type,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTypeDeclAccess().getTypeKeyword_1());
                  
            }
            // InternalExprParser.g:343:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalExprParser.g:344:1: (lv_name_2_0= RULE_ID )
            {
            // InternalExprParser.g:344:1: (lv_name_2_0= RULE_ID )
            // InternalExprParser.g:345:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getTypeDeclAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getTypeDeclRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"org.osate.expr.Expr.ID");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,Colon,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTypeDeclAccess().getColonKeyword_3());
                  
            }
            // InternalExprParser.g:366:1: ( (lv_type_4_0= ruleType ) )
            // InternalExprParser.g:367:1: (lv_type_4_0= ruleType )
            {
            // InternalExprParser.g:367:1: (lv_type_4_0= ruleType )
            // InternalExprParser.g:368:3: lv_type_4_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeDeclAccess().getTypeTypeParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_type_4_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypeDeclRule());
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
    // InternalExprParser.g:392:1: entryRuleVarDecl returns [EObject current=null] : iv_ruleVarDecl= ruleVarDecl EOF ;
    public final EObject entryRuleVarDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarDecl = null;


        try {
            // InternalExprParser.g:393:2: (iv_ruleVarDecl= ruleVarDecl EOF )
            // InternalExprParser.g:394:2: iv_ruleVarDecl= ruleVarDecl EOF
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
    // InternalExprParser.g:401:1: ruleVarDecl returns [EObject current=null] : ( () ( ( (lv_const_1_0= Val ) ) | otherlv_2= Var ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= Colon ( (lv_type_5_0= ruleType ) ) )? (otherlv_6= EqualsSign ( (lv_value_7_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVarDecl() throws RecognitionException {
        EObject current = null;

        Token lv_const_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_type_5_0 = null;

        EObject lv_value_7_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:404:28: ( ( () ( ( (lv_const_1_0= Val ) ) | otherlv_2= Var ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= Colon ( (lv_type_5_0= ruleType ) ) )? (otherlv_6= EqualsSign ( (lv_value_7_0= ruleExpression ) ) )? ) )
            // InternalExprParser.g:405:1: ( () ( ( (lv_const_1_0= Val ) ) | otherlv_2= Var ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= Colon ( (lv_type_5_0= ruleType ) ) )? (otherlv_6= EqualsSign ( (lv_value_7_0= ruleExpression ) ) )? )
            {
            // InternalExprParser.g:405:1: ( () ( ( (lv_const_1_0= Val ) ) | otherlv_2= Var ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= Colon ( (lv_type_5_0= ruleType ) ) )? (otherlv_6= EqualsSign ( (lv_value_7_0= ruleExpression ) ) )? )
            // InternalExprParser.g:405:2: () ( ( (lv_const_1_0= Val ) ) | otherlv_2= Var ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= Colon ( (lv_type_5_0= ruleType ) ) )? (otherlv_6= EqualsSign ( (lv_value_7_0= ruleExpression ) ) )?
            {
            // InternalExprParser.g:405:2: ()
            // InternalExprParser.g:406:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getVarDeclAccess().getVarDeclAction_0(),
                          current);
                  
            }

            }

            // InternalExprParser.g:411:2: ( ( (lv_const_1_0= Val ) ) | otherlv_2= Var )
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
                    // InternalExprParser.g:411:3: ( (lv_const_1_0= Val ) )
                    {
                    // InternalExprParser.g:411:3: ( (lv_const_1_0= Val ) )
                    // InternalExprParser.g:412:1: (lv_const_1_0= Val )
                    {
                    // InternalExprParser.g:412:1: (lv_const_1_0= Val )
                    // InternalExprParser.g:413:3: lv_const_1_0= Val
                    {
                    lv_const_1_0=(Token)match(input,Val,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_const_1_0, grammarAccess.getVarDeclAccess().getConstValKeyword_1_0_0());
                          
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
                    // InternalExprParser.g:429:2: otherlv_2= Var
                    {
                    otherlv_2=(Token)match(input,Var,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getVarDeclAccess().getVarKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // InternalExprParser.g:433:2: ( (lv_name_3_0= RULE_ID ) )
            // InternalExprParser.g:434:1: (lv_name_3_0= RULE_ID )
            {
            // InternalExprParser.g:434:1: (lv_name_3_0= RULE_ID )
            // InternalExprParser.g:435:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_3_0, grammarAccess.getVarDeclAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getVarDeclRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_3_0, 
                      		"org.osate.expr.Expr.ID");
              	    
            }

            }


            }

            // InternalExprParser.g:451:2: (otherlv_4= Colon ( (lv_type_5_0= ruleType ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==Colon) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalExprParser.g:452:2: otherlv_4= Colon ( (lv_type_5_0= ruleType ) )
                    {
                    otherlv_4=(Token)match(input,Colon,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getVarDeclAccess().getColonKeyword_3_0());
                          
                    }
                    // InternalExprParser.g:456:1: ( (lv_type_5_0= ruleType ) )
                    // InternalExprParser.g:457:1: (lv_type_5_0= ruleType )
                    {
                    // InternalExprParser.g:457:1: (lv_type_5_0= ruleType )
                    // InternalExprParser.g:458:3: lv_type_5_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVarDeclAccess().getTypeTypeParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_9);
                    lv_type_5_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVarDeclRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_5_0, 
                              		"org.osate.expr.Expr.Type");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalExprParser.g:474:4: (otherlv_6= EqualsSign ( (lv_value_7_0= ruleExpression ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==EqualsSign) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalExprParser.g:475:2: otherlv_6= EqualsSign ( (lv_value_7_0= ruleExpression ) )
                    {
                    otherlv_6=(Token)match(input,EqualsSign,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getVarDeclAccess().getEqualsSignKeyword_4_0());
                          
                    }
                    // InternalExprParser.g:479:1: ( (lv_value_7_0= ruleExpression ) )
                    // InternalExprParser.g:480:1: (lv_value_7_0= ruleExpression )
                    {
                    // InternalExprParser.g:480:1: (lv_value_7_0= ruleExpression )
                    // InternalExprParser.g:481:3: lv_value_7_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVarDeclAccess().getValueExpressionParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_7_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVarDeclRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_7_0, 
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
    // InternalExprParser.g:505:1: entryRuleFunDecl returns [EObject current=null] : iv_ruleFunDecl= ruleFunDecl EOF ;
    public final EObject entryRuleFunDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunDecl = null;


        try {
            // InternalExprParser.g:506:2: (iv_ruleFunDecl= ruleFunDecl EOF )
            // InternalExprParser.g:507:2: iv_ruleFunDecl= ruleFunDecl EOF
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
    // InternalExprParser.g:514:1: ruleFunDecl returns [EObject current=null] : ( () otherlv_1= Def ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftParenthesis otherlv_4= RightParenthesis ) ;
    public final EObject ruleFunDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:517:28: ( ( () otherlv_1= Def ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftParenthesis otherlv_4= RightParenthesis ) )
            // InternalExprParser.g:518:1: ( () otherlv_1= Def ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftParenthesis otherlv_4= RightParenthesis )
            {
            // InternalExprParser.g:518:1: ( () otherlv_1= Def ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftParenthesis otherlv_4= RightParenthesis )
            // InternalExprParser.g:518:2: () otherlv_1= Def ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftParenthesis otherlv_4= RightParenthesis
            {
            // InternalExprParser.g:518:2: ()
            // InternalExprParser.g:519:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getFunDeclAccess().getFunDeclAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,Def,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFunDeclAccess().getDefKeyword_1());
                  
            }
            // InternalExprParser.g:529:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalExprParser.g:530:1: (lv_name_2_0= RULE_ID )
            {
            // InternalExprParser.g:530:1: (lv_name_2_0= RULE_ID )
            // InternalExprParser.g:531:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getFunDeclAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFunDeclRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"org.osate.expr.Expr.ID");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,LeftParenthesis,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFunDeclAccess().getLeftParenthesisKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getFunDeclAccess().getRightParenthesisKeyword_4());
                  
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


    // $ANTLR start "entryRuleType"
    // InternalExprParser.g:565:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalExprParser.g:566:2: (iv_ruleType= ruleType EOF )
            // InternalExprParser.g:567:2: iv_ruleType= ruleType EOF
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
    // InternalExprParser.g:574:1: ruleType returns [EObject current=null] : (this_PrimitiveType_0= rulePrimitiveType | this_Category_1= ruleCategory | this_MetaClass_2= ruleMetaClass | this_ClassifierType_3= ruleClassifierType | this_RecordType_4= ruleRecordType | this_UnionType_5= ruleUnionType | this_TupleType_6= ruleTupleType | this_ListType_7= ruleListType | this_SetType_8= ruleSetType | this_BagType_9= ruleBagType | this_MapType_10= ruleMapType | this_TypeRef_11= ruleTypeRef ) ;
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
            // InternalExprParser.g:577:28: ( (this_PrimitiveType_0= rulePrimitiveType | this_Category_1= ruleCategory | this_MetaClass_2= ruleMetaClass | this_ClassifierType_3= ruleClassifierType | this_RecordType_4= ruleRecordType | this_UnionType_5= ruleUnionType | this_TupleType_6= ruleTupleType | this_ListType_7= ruleListType | this_SetType_8= ruleSetType | this_BagType_9= ruleBagType | this_MapType_10= ruleMapType | this_TypeRef_11= ruleTypeRef ) )
            // InternalExprParser.g:578:1: (this_PrimitiveType_0= rulePrimitiveType | this_Category_1= ruleCategory | this_MetaClass_2= ruleMetaClass | this_ClassifierType_3= ruleClassifierType | this_RecordType_4= ruleRecordType | this_UnionType_5= ruleUnionType | this_TupleType_6= ruleTupleType | this_ListType_7= ruleListType | this_SetType_8= ruleSetType | this_BagType_9= ruleBagType | this_MapType_10= ruleMapType | this_TypeRef_11= ruleTypeRef )
            {
            // InternalExprParser.g:578:1: (this_PrimitiveType_0= rulePrimitiveType | this_Category_1= ruleCategory | this_MetaClass_2= ruleMetaClass | this_ClassifierType_3= ruleClassifierType | this_RecordType_4= ruleRecordType | this_UnionType_5= ruleUnionType | this_TupleType_6= ruleTupleType | this_ListType_7= ruleListType | this_SetType_8= ruleSetType | this_BagType_9= ruleBagType | this_MapType_10= ruleMapType | this_TypeRef_11= ruleTypeRef )
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
                    // InternalExprParser.g:579:5: this_PrimitiveType_0= rulePrimitiveType
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
                    // InternalExprParser.g:589:5: this_Category_1= ruleCategory
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
                    // InternalExprParser.g:599:5: this_MetaClass_2= ruleMetaClass
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
                    // InternalExprParser.g:609:5: this_ClassifierType_3= ruleClassifierType
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
                    // InternalExprParser.g:619:5: this_RecordType_4= ruleRecordType
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
                    // InternalExprParser.g:629:5: this_UnionType_5= ruleUnionType
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
                    // InternalExprParser.g:639:5: this_TupleType_6= ruleTupleType
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
                    // InternalExprParser.g:649:5: this_ListType_7= ruleListType
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
                    // InternalExprParser.g:659:5: this_SetType_8= ruleSetType
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
                    // InternalExprParser.g:669:5: this_BagType_9= ruleBagType
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
                    // InternalExprParser.g:679:5: this_MapType_10= ruleMapType
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
                    // InternalExprParser.g:689:5: this_TypeRef_11= ruleTypeRef
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
    // InternalExprParser.g:705:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalExprParser.g:706:2: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalExprParser.g:707:2: iv_rulePrimitiveType= rulePrimitiveType EOF
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
    // InternalExprParser.g:714:1: rulePrimitiveType returns [EObject current=null] : ( ( () otherlv_1= Bool ) | ( () otherlv_3= Int ) | ( () otherlv_5= Real ) | ( () otherlv_7= String ) ) ;
    public final EObject rulePrimitiveType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:717:28: ( ( ( () otherlv_1= Bool ) | ( () otherlv_3= Int ) | ( () otherlv_5= Real ) | ( () otherlv_7= String ) ) )
            // InternalExprParser.g:718:1: ( ( () otherlv_1= Bool ) | ( () otherlv_3= Int ) | ( () otherlv_5= Real ) | ( () otherlv_7= String ) )
            {
            // InternalExprParser.g:718:1: ( ( () otherlv_1= Bool ) | ( () otherlv_3= Int ) | ( () otherlv_5= Real ) | ( () otherlv_7= String ) )
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
                    // InternalExprParser.g:718:2: ( () otherlv_1= Bool )
                    {
                    // InternalExprParser.g:718:2: ( () otherlv_1= Bool )
                    // InternalExprParser.g:718:3: () otherlv_1= Bool
                    {
                    // InternalExprParser.g:718:3: ()
                    // InternalExprParser.g:719:5: 
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
                    // InternalExprParser.g:730:6: ( () otherlv_3= Int )
                    {
                    // InternalExprParser.g:730:6: ( () otherlv_3= Int )
                    // InternalExprParser.g:730:7: () otherlv_3= Int
                    {
                    // InternalExprParser.g:730:7: ()
                    // InternalExprParser.g:731:5: 
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
                    // InternalExprParser.g:742:6: ( () otherlv_5= Real )
                    {
                    // InternalExprParser.g:742:6: ( () otherlv_5= Real )
                    // InternalExprParser.g:742:7: () otherlv_5= Real
                    {
                    // InternalExprParser.g:742:7: ()
                    // InternalExprParser.g:743:5: 
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
                    // InternalExprParser.g:754:6: ( () otherlv_7= String )
                    {
                    // InternalExprParser.g:754:6: ( () otherlv_7= String )
                    // InternalExprParser.g:754:7: () otherlv_7= String
                    {
                    // InternalExprParser.g:754:7: ()
                    // InternalExprParser.g:755:5: 
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
    // InternalExprParser.g:773:1: entryRuleCategory returns [EObject current=null] : iv_ruleCategory= ruleCategory EOF ;
    public final EObject entryRuleCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategory = null;


        try {
            // InternalExprParser.g:774:2: (iv_ruleCategory= ruleCategory EOF )
            // InternalExprParser.g:775:2: iv_ruleCategory= ruleCategory EOF
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
    // InternalExprParser.g:782:1: ruleCategory returns [EObject current=null] : ( (lv_category_0_0= ruleComponentCategory ) ) ;
    public final EObject ruleCategory() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_category_0_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:785:28: ( ( (lv_category_0_0= ruleComponentCategory ) ) )
            // InternalExprParser.g:786:1: ( (lv_category_0_0= ruleComponentCategory ) )
            {
            // InternalExprParser.g:786:1: ( (lv_category_0_0= ruleComponentCategory ) )
            // InternalExprParser.g:787:1: (lv_category_0_0= ruleComponentCategory )
            {
            // InternalExprParser.g:787:1: (lv_category_0_0= ruleComponentCategory )
            // InternalExprParser.g:788:3: lv_category_0_0= ruleComponentCategory
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
    // InternalExprParser.g:812:1: entryRuleComponentCategory returns [String current=null] : iv_ruleComponentCategory= ruleComponentCategory EOF ;
    public final String entryRuleComponentCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComponentCategory = null;


        try {
            // InternalExprParser.g:813:1: (iv_ruleComponentCategory= ruleComponentCategory EOF )
            // InternalExprParser.g:814:2: iv_ruleComponentCategory= ruleComponentCategory EOF
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
    // InternalExprParser.g:821:1: ruleComponentCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Abstract | kw= Bus | kw= Data | kw= Device | kw= Memory | kw= Process | kw= Processor | kw= Subprogram | (kw= Subprogram kw= Group ) | kw= KW_System | (kw= Thread kw= Group ) | kw= Thread | (kw= Virtual kw= Bus ) | (kw= Virtual kw= Processor ) ) ;
    public final AntlrDatatypeRuleToken ruleComponentCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:825:6: ( (kw= Abstract | kw= Bus | kw= Data | kw= Device | kw= Memory | kw= Process | kw= Processor | kw= Subprogram | (kw= Subprogram kw= Group ) | kw= KW_System | (kw= Thread kw= Group ) | kw= Thread | (kw= Virtual kw= Bus ) | (kw= Virtual kw= Processor ) ) )
            // InternalExprParser.g:826:1: (kw= Abstract | kw= Bus | kw= Data | kw= Device | kw= Memory | kw= Process | kw= Processor | kw= Subprogram | (kw= Subprogram kw= Group ) | kw= KW_System | (kw= Thread kw= Group ) | kw= Thread | (kw= Virtual kw= Bus ) | (kw= Virtual kw= Processor ) )
            {
            // InternalExprParser.g:826:1: (kw= Abstract | kw= Bus | kw= Data | kw= Device | kw= Memory | kw= Process | kw= Processor | kw= Subprogram | (kw= Subprogram kw= Group ) | kw= KW_System | (kw= Thread kw= Group ) | kw= Thread | (kw= Virtual kw= Bus ) | (kw= Virtual kw= Processor ) )
            int alt12=14;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // InternalExprParser.g:827:2: kw= Abstract
                    {
                    kw=(Token)match(input,Abstract,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:834:2: kw= Bus
                    {
                    kw=(Token)match(input,Bus,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:841:2: kw= Data
                    {
                    kw=(Token)match(input,Data,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:848:2: kw= Device
                    {
                    kw=(Token)match(input,Device,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalExprParser.g:855:2: kw= Memory
                    {
                    kw=(Token)match(input,Memory,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalExprParser.g:862:2: kw= Process
                    {
                    kw=(Token)match(input,Process,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalExprParser.g:869:2: kw= Processor
                    {
                    kw=(Token)match(input,Processor,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalExprParser.g:876:2: kw= Subprogram
                    {
                    kw=(Token)match(input,Subprogram,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // InternalExprParser.g:882:6: (kw= Subprogram kw= Group )
                    {
                    // InternalExprParser.g:882:6: (kw= Subprogram kw= Group )
                    // InternalExprParser.g:883:2: kw= Subprogram kw= Group
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
                    // InternalExprParser.g:896:2: kw= KW_System
                    {
                    kw=(Token)match(input,KW_System,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // InternalExprParser.g:902:6: (kw= Thread kw= Group )
                    {
                    // InternalExprParser.g:902:6: (kw= Thread kw= Group )
                    // InternalExprParser.g:903:2: kw= Thread kw= Group
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
                    // InternalExprParser.g:916:2: kw= Thread
                    {
                    kw=(Token)match(input,Thread,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
                          
                    }

                    }
                    break;
                case 13 :
                    // InternalExprParser.g:922:6: (kw= Virtual kw= Bus )
                    {
                    // InternalExprParser.g:922:6: (kw= Virtual kw= Bus )
                    // InternalExprParser.g:923:2: kw= Virtual kw= Bus
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
                    // InternalExprParser.g:935:6: (kw= Virtual kw= Processor )
                    {
                    // InternalExprParser.g:935:6: (kw= Virtual kw= Processor )
                    // InternalExprParser.g:936:2: kw= Virtual kw= Processor
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
    // InternalExprParser.g:955:1: entryRuleMetaClass returns [EObject current=null] : iv_ruleMetaClass= ruleMetaClass EOF ;
    public final EObject entryRuleMetaClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMetaClass = null;


        try {
            // InternalExprParser.g:956:2: (iv_ruleMetaClass= ruleMetaClass EOF )
            // InternalExprParser.g:957:2: iv_ruleMetaClass= ruleMetaClass EOF
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
    // InternalExprParser.g:964:1: ruleMetaClass returns [EObject current=null] : ( (lv_class_0_0= ruleMetaClassEnum ) ) ;
    public final EObject ruleMetaClass() throws RecognitionException {
        EObject current = null;

        Enumerator lv_class_0_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:967:28: ( ( (lv_class_0_0= ruleMetaClassEnum ) ) )
            // InternalExprParser.g:968:1: ( (lv_class_0_0= ruleMetaClassEnum ) )
            {
            // InternalExprParser.g:968:1: ( (lv_class_0_0= ruleMetaClassEnum ) )
            // InternalExprParser.g:969:1: (lv_class_0_0= ruleMetaClassEnum )
            {
            // InternalExprParser.g:969:1: (lv_class_0_0= ruleMetaClassEnum )
            // InternalExprParser.g:970:3: lv_class_0_0= ruleMetaClassEnum
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
    // InternalExprParser.g:994:1: entryRuleClassifierType returns [EObject current=null] : iv_ruleClassifierType= ruleClassifierType EOF ;
    public final EObject entryRuleClassifierType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassifierType = null;


        try {
            // InternalExprParser.g:995:2: (iv_ruleClassifierType= ruleClassifierType EOF )
            // InternalExprParser.g:996:2: iv_ruleClassifierType= ruleClassifierType EOF
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
    // InternalExprParser.g:1003:1: ruleClassifierType returns [EObject current=null] : ( () otherlv_1= Classifier (otherlv_2= LeftParenthesis ( ( ruleQCREF ) ) otherlv_4= RightParenthesis )? ) ;
    public final EObject ruleClassifierType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:1006:28: ( ( () otherlv_1= Classifier (otherlv_2= LeftParenthesis ( ( ruleQCREF ) ) otherlv_4= RightParenthesis )? ) )
            // InternalExprParser.g:1007:1: ( () otherlv_1= Classifier (otherlv_2= LeftParenthesis ( ( ruleQCREF ) ) otherlv_4= RightParenthesis )? )
            {
            // InternalExprParser.g:1007:1: ( () otherlv_1= Classifier (otherlv_2= LeftParenthesis ( ( ruleQCREF ) ) otherlv_4= RightParenthesis )? )
            // InternalExprParser.g:1007:2: () otherlv_1= Classifier (otherlv_2= LeftParenthesis ( ( ruleQCREF ) ) otherlv_4= RightParenthesis )?
            {
            // InternalExprParser.g:1007:2: ()
            // InternalExprParser.g:1008:5: 
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
            // InternalExprParser.g:1018:1: (otherlv_2= LeftParenthesis ( ( ruleQCREF ) ) otherlv_4= RightParenthesis )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==LeftParenthesis) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalExprParser.g:1019:2: otherlv_2= LeftParenthesis ( ( ruleQCREF ) ) otherlv_4= RightParenthesis
                    {
                    otherlv_2=(Token)match(input,LeftParenthesis,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getClassifierTypeAccess().getLeftParenthesisKeyword_2_0());
                          
                    }
                    // InternalExprParser.g:1023:1: ( ( ruleQCREF ) )
                    // InternalExprParser.g:1024:1: ( ruleQCREF )
                    {
                    // InternalExprParser.g:1024:1: ( ruleQCREF )
                    // InternalExprParser.g:1025:3: ruleQCREF
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
    // InternalExprParser.g:1052:1: entryRuleRecordType returns [EObject current=null] : iv_ruleRecordType= ruleRecordType EOF ;
    public final EObject entryRuleRecordType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordType = null;


        try {
            // InternalExprParser.g:1053:2: (iv_ruleRecordType= ruleRecordType EOF )
            // InternalExprParser.g:1054:2: iv_ruleRecordType= ruleRecordType EOF
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
    // InternalExprParser.g:1061:1: ruleRecordType returns [EObject current=null] : ( () otherlv_1= Record otherlv_2= LeftCurlyBracket ( (lv_field_3_0= ruleField ) )* otherlv_4= RightCurlyBracket ) ;
    public final EObject ruleRecordType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_field_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1064:28: ( ( () otherlv_1= Record otherlv_2= LeftCurlyBracket ( (lv_field_3_0= ruleField ) )* otherlv_4= RightCurlyBracket ) )
            // InternalExprParser.g:1065:1: ( () otherlv_1= Record otherlv_2= LeftCurlyBracket ( (lv_field_3_0= ruleField ) )* otherlv_4= RightCurlyBracket )
            {
            // InternalExprParser.g:1065:1: ( () otherlv_1= Record otherlv_2= LeftCurlyBracket ( (lv_field_3_0= ruleField ) )* otherlv_4= RightCurlyBracket )
            // InternalExprParser.g:1065:2: () otherlv_1= Record otherlv_2= LeftCurlyBracket ( (lv_field_3_0= ruleField ) )* otherlv_4= RightCurlyBracket
            {
            // InternalExprParser.g:1065:2: ()
            // InternalExprParser.g:1066:5: 
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
            // InternalExprParser.g:1081:1: ( (lv_field_3_0= ruleField ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalExprParser.g:1082:1: (lv_field_3_0= ruleField )
            	    {
            	    // InternalExprParser.g:1082:1: (lv_field_3_0= ruleField )
            	    // InternalExprParser.g:1083:3: lv_field_3_0= ruleField
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
    // InternalExprParser.g:1112:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // InternalExprParser.g:1113:2: (iv_ruleField= ruleField EOF )
            // InternalExprParser.g:1114:2: iv_ruleField= ruleField EOF
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
    // InternalExprParser.g:1121:1: ruleField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= Semicolon ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1124:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= Semicolon ) )
            // InternalExprParser.g:1125:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= Semicolon )
            {
            // InternalExprParser.g:1125:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= Semicolon )
            // InternalExprParser.g:1125:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= Semicolon
            {
            // InternalExprParser.g:1125:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalExprParser.g:1126:1: (lv_name_0_0= RULE_ID )
            {
            // InternalExprParser.g:1126:1: (lv_name_0_0= RULE_ID )
            // InternalExprParser.g:1127:3: lv_name_0_0= RULE_ID
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
                      		"org.osate.expr.Expr.ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,Colon,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFieldAccess().getColonKeyword_1());
                  
            }
            // InternalExprParser.g:1148:1: ( (lv_type_2_0= ruleType ) )
            // InternalExprParser.g:1149:1: (lv_type_2_0= ruleType )
            {
            // InternalExprParser.g:1149:1: (lv_type_2_0= ruleType )
            // InternalExprParser.g:1150:3: lv_type_2_0= ruleType
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
    // InternalExprParser.g:1179:1: entryRuleUnionType returns [EObject current=null] : iv_ruleUnionType= ruleUnionType EOF ;
    public final EObject entryRuleUnionType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnionType = null;


        try {
            // InternalExprParser.g:1180:2: (iv_ruleUnionType= ruleUnionType EOF )
            // InternalExprParser.g:1181:2: iv_ruleUnionType= ruleUnionType EOF
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
    // InternalExprParser.g:1188:1: ruleUnionType returns [EObject current=null] : ( () otherlv_1= Union otherlv_2= LeftCurlyBracket otherlv_3= QuestionMarkQuestionMarkQuestionMark otherlv_4= RightCurlyBracket ) ;
    public final EObject ruleUnionType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:1191:28: ( ( () otherlv_1= Union otherlv_2= LeftCurlyBracket otherlv_3= QuestionMarkQuestionMarkQuestionMark otherlv_4= RightCurlyBracket ) )
            // InternalExprParser.g:1192:1: ( () otherlv_1= Union otherlv_2= LeftCurlyBracket otherlv_3= QuestionMarkQuestionMarkQuestionMark otherlv_4= RightCurlyBracket )
            {
            // InternalExprParser.g:1192:1: ( () otherlv_1= Union otherlv_2= LeftCurlyBracket otherlv_3= QuestionMarkQuestionMarkQuestionMark otherlv_4= RightCurlyBracket )
            // InternalExprParser.g:1192:2: () otherlv_1= Union otherlv_2= LeftCurlyBracket otherlv_3= QuestionMarkQuestionMarkQuestionMark otherlv_4= RightCurlyBracket
            {
            // InternalExprParser.g:1192:2: ()
            // InternalExprParser.g:1193:5: 
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
    // InternalExprParser.g:1226:1: entryRuleTupleType returns [EObject current=null] : iv_ruleTupleType= ruleTupleType EOF ;
    public final EObject entryRuleTupleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleType = null;


        try {
            // InternalExprParser.g:1227:2: (iv_ruleTupleType= ruleTupleType EOF )
            // InternalExprParser.g:1228:2: iv_ruleTupleType= ruleTupleType EOF
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
    // InternalExprParser.g:1235:1: ruleTupleType returns [EObject current=null] : ( () otherlv_1= Tuple otherlv_2= LeftCurlyBracket ( (lv_field_3_0= ruleTupleField ) )* otherlv_4= RightCurlyBracket ) ;
    public final EObject ruleTupleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_field_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1238:28: ( ( () otherlv_1= Tuple otherlv_2= LeftCurlyBracket ( (lv_field_3_0= ruleTupleField ) )* otherlv_4= RightCurlyBracket ) )
            // InternalExprParser.g:1239:1: ( () otherlv_1= Tuple otherlv_2= LeftCurlyBracket ( (lv_field_3_0= ruleTupleField ) )* otherlv_4= RightCurlyBracket )
            {
            // InternalExprParser.g:1239:1: ( () otherlv_1= Tuple otherlv_2= LeftCurlyBracket ( (lv_field_3_0= ruleTupleField ) )* otherlv_4= RightCurlyBracket )
            // InternalExprParser.g:1239:2: () otherlv_1= Tuple otherlv_2= LeftCurlyBracket ( (lv_field_3_0= ruleTupleField ) )* otherlv_4= RightCurlyBracket
            {
            // InternalExprParser.g:1239:2: ()
            // InternalExprParser.g:1240:5: 
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
            // InternalExprParser.g:1255:1: ( (lv_field_3_0= ruleTupleField ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=Subcomponent && LA15_0<=Processor)||LA15_0==Abstract||LA15_0==Feature||(LA15_0>=Process && LA15_0<=Thread)||(LA15_0>=Tuple && LA15_0<=Data)||(LA15_0>=Flow && LA15_0<=Real)||(LA15_0>=Bag && LA15_0<=Bus)||(LA15_0>=Int && LA15_0<=Map)||LA15_0==Set||LA15_0==RULE_ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalExprParser.g:1256:1: (lv_field_3_0= ruleTupleField )
            	    {
            	    // InternalExprParser.g:1256:1: (lv_field_3_0= ruleTupleField )
            	    // InternalExprParser.g:1257:3: lv_field_3_0= ruleTupleField
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
    // InternalExprParser.g:1286:1: entryRuleTupleField returns [EObject current=null] : iv_ruleTupleField= ruleTupleField EOF ;
    public final EObject entryRuleTupleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleField = null;


        try {
            // InternalExprParser.g:1287:2: (iv_ruleTupleField= ruleTupleField EOF )
            // InternalExprParser.g:1288:2: iv_ruleTupleField= ruleTupleField EOF
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
    // InternalExprParser.g:1295:1: ruleTupleField returns [EObject current=null] : ( () ( (lv_type_1_0= ruleType ) ) ) ;
    public final EObject ruleTupleField() throws RecognitionException {
        EObject current = null;

        EObject lv_type_1_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1298:28: ( ( () ( (lv_type_1_0= ruleType ) ) ) )
            // InternalExprParser.g:1299:1: ( () ( (lv_type_1_0= ruleType ) ) )
            {
            // InternalExprParser.g:1299:1: ( () ( (lv_type_1_0= ruleType ) ) )
            // InternalExprParser.g:1299:2: () ( (lv_type_1_0= ruleType ) )
            {
            // InternalExprParser.g:1299:2: ()
            // InternalExprParser.g:1300:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getTupleFieldAccess().getFieldAction_0(),
                          current);
                  
            }

            }

            // InternalExprParser.g:1305:2: ( (lv_type_1_0= ruleType ) )
            // InternalExprParser.g:1306:1: (lv_type_1_0= ruleType )
            {
            // InternalExprParser.g:1306:1: (lv_type_1_0= ruleType )
            // InternalExprParser.g:1307:3: lv_type_1_0= ruleType
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
    // InternalExprParser.g:1331:1: entryRuleListType returns [EObject current=null] : iv_ruleListType= ruleListType EOF ;
    public final EObject entryRuleListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListType = null;


        try {
            // InternalExprParser.g:1332:2: (iv_ruleListType= ruleListType EOF )
            // InternalExprParser.g:1333:2: iv_ruleListType= ruleListType EOF
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
    // InternalExprParser.g:1340:1: ruleListType returns [EObject current=null] : ( () otherlv_1= List otherlv_2= Of ( (lv_type_3_0= ruleType ) ) ) ;
    public final EObject ruleListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1343:28: ( ( () otherlv_1= List otherlv_2= Of ( (lv_type_3_0= ruleType ) ) ) )
            // InternalExprParser.g:1344:1: ( () otherlv_1= List otherlv_2= Of ( (lv_type_3_0= ruleType ) ) )
            {
            // InternalExprParser.g:1344:1: ( () otherlv_1= List otherlv_2= Of ( (lv_type_3_0= ruleType ) ) )
            // InternalExprParser.g:1344:2: () otherlv_1= List otherlv_2= Of ( (lv_type_3_0= ruleType ) )
            {
            // InternalExprParser.g:1344:2: ()
            // InternalExprParser.g:1345:5: 
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
            // InternalExprParser.g:1360:1: ( (lv_type_3_0= ruleType ) )
            // InternalExprParser.g:1361:1: (lv_type_3_0= ruleType )
            {
            // InternalExprParser.g:1361:1: (lv_type_3_0= ruleType )
            // InternalExprParser.g:1362:3: lv_type_3_0= ruleType
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
    // InternalExprParser.g:1386:1: entryRuleSetType returns [EObject current=null] : iv_ruleSetType= ruleSetType EOF ;
    public final EObject entryRuleSetType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetType = null;


        try {
            // InternalExprParser.g:1387:2: (iv_ruleSetType= ruleSetType EOF )
            // InternalExprParser.g:1388:2: iv_ruleSetType= ruleSetType EOF
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
    // InternalExprParser.g:1395:1: ruleSetType returns [EObject current=null] : (otherlv_0= Set otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) ;
    public final EObject ruleSetType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1398:28: ( (otherlv_0= Set otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) )
            // InternalExprParser.g:1399:1: (otherlv_0= Set otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            {
            // InternalExprParser.g:1399:1: (otherlv_0= Set otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            // InternalExprParser.g:1400:2: otherlv_0= Set otherlv_1= Of ( (lv_type_2_0= ruleType ) )
            {
            otherlv_0=(Token)match(input,Set,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSetTypeAccess().getSetKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,Of,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSetTypeAccess().getOfKeyword_1());
                  
            }
            // InternalExprParser.g:1409:1: ( (lv_type_2_0= ruleType ) )
            // InternalExprParser.g:1410:1: (lv_type_2_0= ruleType )
            {
            // InternalExprParser.g:1410:1: (lv_type_2_0= ruleType )
            // InternalExprParser.g:1411:3: lv_type_2_0= ruleType
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
    // InternalExprParser.g:1435:1: entryRuleBagType returns [EObject current=null] : iv_ruleBagType= ruleBagType EOF ;
    public final EObject entryRuleBagType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBagType = null;


        try {
            // InternalExprParser.g:1436:2: (iv_ruleBagType= ruleBagType EOF )
            // InternalExprParser.g:1437:2: iv_ruleBagType= ruleBagType EOF
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
    // InternalExprParser.g:1444:1: ruleBagType returns [EObject current=null] : (otherlv_0= Bag otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) ;
    public final EObject ruleBagType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1447:28: ( (otherlv_0= Bag otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) )
            // InternalExprParser.g:1448:1: (otherlv_0= Bag otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            {
            // InternalExprParser.g:1448:1: (otherlv_0= Bag otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            // InternalExprParser.g:1449:2: otherlv_0= Bag otherlv_1= Of ( (lv_type_2_0= ruleType ) )
            {
            otherlv_0=(Token)match(input,Bag,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getBagTypeAccess().getBagKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,Of,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getBagTypeAccess().getOfKeyword_1());
                  
            }
            // InternalExprParser.g:1458:1: ( (lv_type_2_0= ruleType ) )
            // InternalExprParser.g:1459:1: (lv_type_2_0= ruleType )
            {
            // InternalExprParser.g:1459:1: (lv_type_2_0= ruleType )
            // InternalExprParser.g:1460:3: lv_type_2_0= ruleType
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
    // InternalExprParser.g:1484:1: entryRuleMapType returns [EObject current=null] : iv_ruleMapType= ruleMapType EOF ;
    public final EObject entryRuleMapType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapType = null;


        try {
            // InternalExprParser.g:1485:2: (iv_ruleMapType= ruleMapType EOF )
            // InternalExprParser.g:1486:2: iv_ruleMapType= ruleMapType EOF
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
    // InternalExprParser.g:1493:1: ruleMapType returns [EObject current=null] : (otherlv_0= Map ( (lv_dom_1_0= ruleType ) ) otherlv_2= HyphenMinusGreaterThanSign ( (lv_img_3_0= ruleType ) ) ) ;
    public final EObject ruleMapType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_dom_1_0 = null;

        EObject lv_img_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1496:28: ( (otherlv_0= Map ( (lv_dom_1_0= ruleType ) ) otherlv_2= HyphenMinusGreaterThanSign ( (lv_img_3_0= ruleType ) ) ) )
            // InternalExprParser.g:1497:1: (otherlv_0= Map ( (lv_dom_1_0= ruleType ) ) otherlv_2= HyphenMinusGreaterThanSign ( (lv_img_3_0= ruleType ) ) )
            {
            // InternalExprParser.g:1497:1: (otherlv_0= Map ( (lv_dom_1_0= ruleType ) ) otherlv_2= HyphenMinusGreaterThanSign ( (lv_img_3_0= ruleType ) ) )
            // InternalExprParser.g:1498:2: otherlv_0= Map ( (lv_dom_1_0= ruleType ) ) otherlv_2= HyphenMinusGreaterThanSign ( (lv_img_3_0= ruleType ) )
            {
            otherlv_0=(Token)match(input,Map,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMapTypeAccess().getMapKeyword_0());
                  
            }
            // InternalExprParser.g:1502:1: ( (lv_dom_1_0= ruleType ) )
            // InternalExprParser.g:1503:1: (lv_dom_1_0= ruleType )
            {
            // InternalExprParser.g:1503:1: (lv_dom_1_0= ruleType )
            // InternalExprParser.g:1504:3: lv_dom_1_0= ruleType
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
            // InternalExprParser.g:1525:1: ( (lv_img_3_0= ruleType ) )
            // InternalExprParser.g:1526:1: (lv_img_3_0= ruleType )
            {
            // InternalExprParser.g:1526:1: (lv_img_3_0= ruleType )
            // InternalExprParser.g:1527:3: lv_img_3_0= ruleType
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
    // InternalExprParser.g:1551:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // InternalExprParser.g:1552:2: (iv_ruleTypeRef= ruleTypeRef EOF )
            // InternalExprParser.g:1553:2: iv_ruleTypeRef= ruleTypeRef EOF
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
    // InternalExprParser.g:1560:1: ruleTypeRef returns [EObject current=null] : ( ( ruleQCREF ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:1563:28: ( ( ( ruleQCREF ) ) )
            // InternalExprParser.g:1564:1: ( ( ruleQCREF ) )
            {
            // InternalExprParser.g:1564:1: ( ( ruleQCREF ) )
            // InternalExprParser.g:1565:1: ( ruleQCREF )
            {
            // InternalExprParser.g:1565:1: ( ruleQCREF )
            // InternalExprParser.g:1566:3: ruleQCREF
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
    // InternalExprParser.g:1588:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalExprParser.g:1589:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalExprParser.g:1590:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalExprParser.g:1597:1: ruleExpression returns [EObject current=null] : this_OrExpression_0= ruleOrExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpression_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1600:28: (this_OrExpression_0= ruleOrExpression )
            // InternalExprParser.g:1602:5: this_OrExpression_0= ruleOrExpression
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
    // InternalExprParser.g:1618:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // InternalExprParser.g:1619:2: (iv_ruleOrExpression= ruleOrExpression EOF )
            // InternalExprParser.g:1620:2: iv_ruleOrExpression= ruleOrExpression EOF
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
    // InternalExprParser.g:1627:1: ruleOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AndExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1630:28: ( (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // InternalExprParser.g:1631:1: (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // InternalExprParser.g:1631:1: (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // InternalExprParser.g:1632:5: this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )*
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
            // InternalExprParser.g:1640:1: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )*
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
            	    // InternalExprParser.g:1640:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // InternalExprParser.g:1640:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) )
            	    // InternalExprParser.g:1640:3: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) )
            	    {
            	    // InternalExprParser.g:1645:6: ( () ( (lv_operator_2_0= ruleOpOr ) ) )
            	    // InternalExprParser.g:1645:7: () ( (lv_operator_2_0= ruleOpOr ) )
            	    {
            	    // InternalExprParser.g:1645:7: ()
            	    // InternalExprParser.g:1646:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getOrExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalExprParser.g:1651:2: ( (lv_operator_2_0= ruleOpOr ) )
            	    // InternalExprParser.g:1652:1: (lv_operator_2_0= ruleOpOr )
            	    {
            	    // InternalExprParser.g:1652:1: (lv_operator_2_0= ruleOpOr )
            	    // InternalExprParser.g:1653:3: lv_operator_2_0= ruleOpOr
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

            	    // InternalExprParser.g:1669:4: ( (lv_right_3_0= ruleAndExpression ) )
            	    // InternalExprParser.g:1670:1: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // InternalExprParser.g:1670:1: (lv_right_3_0= ruleAndExpression )
            	    // InternalExprParser.g:1671:3: lv_right_3_0= ruleAndExpression
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
    // InternalExprParser.g:1695:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // InternalExprParser.g:1696:1: (iv_ruleOpOr= ruleOpOr EOF )
            // InternalExprParser.g:1697:2: iv_ruleOpOr= ruleOpOr EOF
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
    // InternalExprParser.g:1704:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Or | kw= VerticalLineVerticalLine ) ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:1708:6: ( (kw= Or | kw= VerticalLineVerticalLine ) )
            // InternalExprParser.g:1709:1: (kw= Or | kw= VerticalLineVerticalLine )
            {
            // InternalExprParser.g:1709:1: (kw= Or | kw= VerticalLineVerticalLine )
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
                    // InternalExprParser.g:1710:2: kw= Or
                    {
                    kw=(Token)match(input,Or,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOrAccess().getOrKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:1717:2: kw= VerticalLineVerticalLine
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
    // InternalExprParser.g:1730:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalExprParser.g:1731:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalExprParser.g:1732:2: iv_ruleAndExpression= ruleAndExpression EOF
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
    // InternalExprParser.g:1739:1: ruleAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EqualityExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1742:28: ( (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) )
            // InternalExprParser.g:1743:1: (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            {
            // InternalExprParser.g:1743:1: (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            // InternalExprParser.g:1744:5: this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
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
            // InternalExprParser.g:1752:1: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
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
            	    // InternalExprParser.g:1752:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) )
            	    {
            	    // InternalExprParser.g:1752:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) )
            	    // InternalExprParser.g:1752:3: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) )
            	    {
            	    // InternalExprParser.g:1757:6: ( () ( (lv_operator_2_0= ruleOpAnd ) ) )
            	    // InternalExprParser.g:1757:7: () ( (lv_operator_2_0= ruleOpAnd ) )
            	    {
            	    // InternalExprParser.g:1757:7: ()
            	    // InternalExprParser.g:1758:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAndExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalExprParser.g:1763:2: ( (lv_operator_2_0= ruleOpAnd ) )
            	    // InternalExprParser.g:1764:1: (lv_operator_2_0= ruleOpAnd )
            	    {
            	    // InternalExprParser.g:1764:1: (lv_operator_2_0= ruleOpAnd )
            	    // InternalExprParser.g:1765:3: lv_operator_2_0= ruleOpAnd
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

            	    // InternalExprParser.g:1781:4: ( (lv_right_3_0= ruleEqualityExpression ) )
            	    // InternalExprParser.g:1782:1: (lv_right_3_0= ruleEqualityExpression )
            	    {
            	    // InternalExprParser.g:1782:1: (lv_right_3_0= ruleEqualityExpression )
            	    // InternalExprParser.g:1783:3: lv_right_3_0= ruleEqualityExpression
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
    // InternalExprParser.g:1807:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // InternalExprParser.g:1808:1: (iv_ruleOpAnd= ruleOpAnd EOF )
            // InternalExprParser.g:1809:2: iv_ruleOpAnd= ruleOpAnd EOF
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
    // InternalExprParser.g:1816:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= And | kw= AmpersandAmpersand ) ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:1820:6: ( (kw= And | kw= AmpersandAmpersand ) )
            // InternalExprParser.g:1821:1: (kw= And | kw= AmpersandAmpersand )
            {
            // InternalExprParser.g:1821:1: (kw= And | kw= AmpersandAmpersand )
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
                    // InternalExprParser.g:1822:2: kw= And
                    {
                    kw=(Token)match(input,And,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAndAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:1829:2: kw= AmpersandAmpersand
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
    // InternalExprParser.g:1842:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalExprParser.g:1843:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalExprParser.g:1844:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalExprParser.g:1851:1: ruleEqualityExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RelationalExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1854:28: ( (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) )
            // InternalExprParser.g:1855:1: (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            {
            // InternalExprParser.g:1855:1: (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            // InternalExprParser.g:1856:5: this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
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
            // InternalExprParser.g:1864:1: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
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
            	    // InternalExprParser.g:1864:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) )
            	    {
            	    // InternalExprParser.g:1864:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) )
            	    // InternalExprParser.g:1864:3: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) )
            	    {
            	    // InternalExprParser.g:1869:6: ( () ( (lv_operator_2_0= ruleOpEquality ) ) )
            	    // InternalExprParser.g:1869:7: () ( (lv_operator_2_0= ruleOpEquality ) )
            	    {
            	    // InternalExprParser.g:1869:7: ()
            	    // InternalExprParser.g:1870:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getEqualityExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalExprParser.g:1875:2: ( (lv_operator_2_0= ruleOpEquality ) )
            	    // InternalExprParser.g:1876:1: (lv_operator_2_0= ruleOpEquality )
            	    {
            	    // InternalExprParser.g:1876:1: (lv_operator_2_0= ruleOpEquality )
            	    // InternalExprParser.g:1877:3: lv_operator_2_0= ruleOpEquality
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

            	    // InternalExprParser.g:1893:4: ( (lv_right_3_0= ruleRelationalExpression ) )
            	    // InternalExprParser.g:1894:1: (lv_right_3_0= ruleRelationalExpression )
            	    {
            	    // InternalExprParser.g:1894:1: (lv_right_3_0= ruleRelationalExpression )
            	    // InternalExprParser.g:1895:3: lv_right_3_0= ruleRelationalExpression
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
    // InternalExprParser.g:1919:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // InternalExprParser.g:1920:1: (iv_ruleOpEquality= ruleOpEquality EOF )
            // InternalExprParser.g:1921:2: iv_ruleOpEquality= ruleOpEquality EOF
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
    // InternalExprParser.g:1928:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= EqualsSignEqualsSign | kw= ExclamationMarkEqualsSign ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:1932:6: ( (kw= EqualsSignEqualsSign | kw= ExclamationMarkEqualsSign ) )
            // InternalExprParser.g:1933:1: (kw= EqualsSignEqualsSign | kw= ExclamationMarkEqualsSign )
            {
            // InternalExprParser.g:1933:1: (kw= EqualsSignEqualsSign | kw= ExclamationMarkEqualsSign )
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
                    // InternalExprParser.g:1934:2: kw= EqualsSignEqualsSign
                    {
                    kw=(Token)match(input,EqualsSignEqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:1941:2: kw= ExclamationMarkEqualsSign
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
    // InternalExprParser.g:1954:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalExprParser.g:1955:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalExprParser.g:1956:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalExprParser.g:1963:1: ruleRelationalExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AdditiveExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:1966:28: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) )
            // InternalExprParser.g:1967:1: (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalExprParser.g:1967:1: (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            // InternalExprParser.g:1968:5: this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
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
            // InternalExprParser.g:1976:1: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
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
            	    // InternalExprParser.g:1976:2: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalExprParser.g:1976:2: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) )
            	    // InternalExprParser.g:1976:3: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) )
            	    {
            	    // InternalExprParser.g:1981:6: ( () ( (lv_operator_2_0= ruleOpCompare ) ) )
            	    // InternalExprParser.g:1981:7: () ( (lv_operator_2_0= ruleOpCompare ) )
            	    {
            	    // InternalExprParser.g:1981:7: ()
            	    // InternalExprParser.g:1982:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getRelationalExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalExprParser.g:1987:2: ( (lv_operator_2_0= ruleOpCompare ) )
            	    // InternalExprParser.g:1988:1: (lv_operator_2_0= ruleOpCompare )
            	    {
            	    // InternalExprParser.g:1988:1: (lv_operator_2_0= ruleOpCompare )
            	    // InternalExprParser.g:1989:3: lv_operator_2_0= ruleOpCompare
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

            	    // InternalExprParser.g:2005:4: ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    // InternalExprParser.g:2006:1: (lv_right_3_0= ruleAdditiveExpression )
            	    {
            	    // InternalExprParser.g:2006:1: (lv_right_3_0= ruleAdditiveExpression )
            	    // InternalExprParser.g:2007:3: lv_right_3_0= ruleAdditiveExpression
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
    // InternalExprParser.g:2031:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // InternalExprParser.g:2032:1: (iv_ruleOpCompare= ruleOpCompare EOF )
            // InternalExprParser.g:2033:2: iv_ruleOpCompare= ruleOpCompare EOF
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
    // InternalExprParser.g:2040:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= GreaterThanSignEqualsSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= LessThanSign | kw= GreaterThanSignLessThanSign ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2044:6: ( (kw= GreaterThanSignEqualsSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= LessThanSign | kw= GreaterThanSignLessThanSign ) )
            // InternalExprParser.g:2045:1: (kw= GreaterThanSignEqualsSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= LessThanSign | kw= GreaterThanSignLessThanSign )
            {
            // InternalExprParser.g:2045:1: (kw= GreaterThanSignEqualsSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= LessThanSign | kw= GreaterThanSignLessThanSign )
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
                    // InternalExprParser.g:2046:2: kw= GreaterThanSignEqualsSign
                    {
                    kw=(Token)match(input,GreaterThanSignEqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2053:2: kw= LessThanSignEqualsSign
                    {
                    kw=(Token)match(input,LessThanSignEqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:2060:2: kw= GreaterThanSign
                    {
                    kw=(Token)match(input,GreaterThanSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:2067:2: kw= LessThanSign
                    {
                    kw=(Token)match(input,LessThanSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalExprParser.g:2074:2: kw= GreaterThanSignLessThanSign
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
    // InternalExprParser.g:2087:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalExprParser.g:2088:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalExprParser.g:2089:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalExprParser.g:2096:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplicativeExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:2099:28: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) )
            // InternalExprParser.g:2100:1: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            {
            // InternalExprParser.g:2100:1: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            // InternalExprParser.g:2101:5: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
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
            // InternalExprParser.g:2109:1: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
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
            	    // InternalExprParser.g:2109:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) )
            	    {
            	    // InternalExprParser.g:2109:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) )
            	    // InternalExprParser.g:2109:3: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) )
            	    {
            	    // InternalExprParser.g:2114:6: ( () ( (lv_operator_2_0= ruleOpAdd ) ) )
            	    // InternalExprParser.g:2114:7: () ( (lv_operator_2_0= ruleOpAdd ) )
            	    {
            	    // InternalExprParser.g:2114:7: ()
            	    // InternalExprParser.g:2115:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAdditiveExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalExprParser.g:2120:2: ( (lv_operator_2_0= ruleOpAdd ) )
            	    // InternalExprParser.g:2121:1: (lv_operator_2_0= ruleOpAdd )
            	    {
            	    // InternalExprParser.g:2121:1: (lv_operator_2_0= ruleOpAdd )
            	    // InternalExprParser.g:2122:3: lv_operator_2_0= ruleOpAdd
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

            	    // InternalExprParser.g:2138:4: ( (lv_right_3_0= ruleMultiplicativeExpression ) )
            	    // InternalExprParser.g:2139:1: (lv_right_3_0= ruleMultiplicativeExpression )
            	    {
            	    // InternalExprParser.g:2139:1: (lv_right_3_0= ruleMultiplicativeExpression )
            	    // InternalExprParser.g:2140:3: lv_right_3_0= ruleMultiplicativeExpression
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
    // InternalExprParser.g:2164:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // InternalExprParser.g:2165:1: (iv_ruleOpAdd= ruleOpAdd EOF )
            // InternalExprParser.g:2166:2: iv_ruleOpAdd= ruleOpAdd EOF
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
    // InternalExprParser.g:2173:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= PlusSign | kw= HyphenMinus ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2177:6: ( (kw= PlusSign | kw= HyphenMinus ) )
            // InternalExprParser.g:2178:1: (kw= PlusSign | kw= HyphenMinus )
            {
            // InternalExprParser.g:2178:1: (kw= PlusSign | kw= HyphenMinus )
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
                    // InternalExprParser.g:2179:2: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2186:2: kw= HyphenMinus
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
    // InternalExprParser.g:2199:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalExprParser.g:2200:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalExprParser.g:2201:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalExprParser.g:2208:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_UnaryOperation_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:2211:28: ( (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* ) )
            // InternalExprParser.g:2212:1: (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* )
            {
            // InternalExprParser.g:2212:1: (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* )
            // InternalExprParser.g:2213:5: this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )*
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
            // InternalExprParser.g:2221:1: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )*
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
            	    // InternalExprParser.g:2221:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) )
            	    {
            	    // InternalExprParser.g:2221:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) )
            	    // InternalExprParser.g:2221:3: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) )
            	    {
            	    // InternalExprParser.g:2226:6: ( () ( (lv_operator_2_0= ruleOpMulti ) ) )
            	    // InternalExprParser.g:2226:7: () ( (lv_operator_2_0= ruleOpMulti ) )
            	    {
            	    // InternalExprParser.g:2226:7: ()
            	    // InternalExprParser.g:2227:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getMultiplicativeExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalExprParser.g:2232:2: ( (lv_operator_2_0= ruleOpMulti ) )
            	    // InternalExprParser.g:2233:1: (lv_operator_2_0= ruleOpMulti )
            	    {
            	    // InternalExprParser.g:2233:1: (lv_operator_2_0= ruleOpMulti )
            	    // InternalExprParser.g:2234:3: lv_operator_2_0= ruleOpMulti
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

            	    // InternalExprParser.g:2250:4: ( (lv_right_3_0= ruleUnaryOperation ) )
            	    // InternalExprParser.g:2251:1: (lv_right_3_0= ruleUnaryOperation )
            	    {
            	    // InternalExprParser.g:2251:1: (lv_right_3_0= ruleUnaryOperation )
            	    // InternalExprParser.g:2252:3: lv_right_3_0= ruleUnaryOperation
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
    // InternalExprParser.g:2276:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // InternalExprParser.g:2277:1: (iv_ruleOpMulti= ruleOpMulti EOF )
            // InternalExprParser.g:2278:2: iv_ruleOpMulti= ruleOpMulti EOF
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
    // InternalExprParser.g:2285:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Asterisk | kw= Solidus | kw= Div | kw= Mod ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2289:6: ( (kw= Asterisk | kw= Solidus | kw= Div | kw= Mod ) )
            // InternalExprParser.g:2290:1: (kw= Asterisk | kw= Solidus | kw= Div | kw= Mod )
            {
            // InternalExprParser.g:2290:1: (kw= Asterisk | kw= Solidus | kw= Div | kw= Mod )
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
                    // InternalExprParser.g:2291:2: kw= Asterisk
                    {
                    kw=(Token)match(input,Asterisk,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2298:2: kw= Solidus
                    {
                    kw=(Token)match(input,Solidus,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:2305:2: kw= Div
                    {
                    kw=(Token)match(input,Div,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getDivKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:2312:2: kw= Mod
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
    // InternalExprParser.g:2325:1: entryRuleUnaryOperation returns [EObject current=null] : iv_ruleUnaryOperation= ruleUnaryOperation EOF ;
    public final EObject entryRuleUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperation = null;


        try {
            // InternalExprParser.g:2326:2: (iv_ruleUnaryOperation= ruleUnaryOperation EOF )
            // InternalExprParser.g:2327:2: iv_ruleUnaryOperation= ruleUnaryOperation EOF
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
    // InternalExprParser.g:2334:1: ruleUnaryOperation returns [EObject current=null] : ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) ) | this_UnitExpression_3= ruleUnitExpression ) ;
    public final EObject ruleUnaryOperation() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_operator_1_0 = null;

        EObject lv_operand_2_0 = null;

        EObject this_UnitExpression_3 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:2337:28: ( ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) ) | this_UnitExpression_3= ruleUnitExpression ) )
            // InternalExprParser.g:2338:1: ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) ) | this_UnitExpression_3= ruleUnitExpression )
            {
            // InternalExprParser.g:2338:1: ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) ) | this_UnitExpression_3= ruleUnitExpression )
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
                    // InternalExprParser.g:2338:2: ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) )
                    {
                    // InternalExprParser.g:2338:2: ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) )
                    // InternalExprParser.g:2338:3: () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) )
                    {
                    // InternalExprParser.g:2338:3: ()
                    // InternalExprParser.g:2339:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getUnaryOperationAccess().getUnaryOperationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalExprParser.g:2344:2: ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) )
                    // InternalExprParser.g:2344:3: ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary )
                    {
                    // InternalExprParser.g:2349:1: (lv_operator_1_0= ruleOpUnary )
                    // InternalExprParser.g:2350:3: lv_operator_1_0= ruleOpUnary
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

                    // InternalExprParser.g:2366:2: ( (lv_operand_2_0= ruleUnitExpression ) )
                    // InternalExprParser.g:2367:1: (lv_operand_2_0= ruleUnitExpression )
                    {
                    // InternalExprParser.g:2367:1: (lv_operand_2_0= ruleUnitExpression )
                    // InternalExprParser.g:2368:3: lv_operand_2_0= ruleUnitExpression
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
                    // InternalExprParser.g:2386:5: this_UnitExpression_3= ruleUnitExpression
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
    // InternalExprParser.g:2402:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // InternalExprParser.g:2403:1: (iv_ruleOpUnary= ruleOpUnary EOF )
            // InternalExprParser.g:2404:2: iv_ruleOpUnary= ruleOpUnary EOF
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
    // InternalExprParser.g:2411:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Not | kw= HyphenMinus | kw= PlusSign ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2415:6: ( (kw= Not | kw= HyphenMinus | kw= PlusSign ) )
            // InternalExprParser.g:2416:1: (kw= Not | kw= HyphenMinus | kw= PlusSign )
            {
            // InternalExprParser.g:2416:1: (kw= Not | kw= HyphenMinus | kw= PlusSign )
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
                    // InternalExprParser.g:2417:2: kw= Not
                    {
                    kw=(Token)match(input,Not,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2424:2: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:2431:2: kw= PlusSign
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
    // InternalExprParser.g:2444:1: entryRuleUnitExpression returns [EObject current=null] : iv_ruleUnitExpression= ruleUnitExpression EOF ;
    public final EObject entryRuleUnitExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpression = null;


        try {
            // InternalExprParser.g:2445:2: (iv_ruleUnitExpression= ruleUnitExpression EOF )
            // InternalExprParser.g:2446:2: iv_ruleUnitExpression= ruleUnitExpression EOF
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
    // InternalExprParser.g:2453:1: ruleUnitExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleUnitExpression() throws RecognitionException {
        EObject current = null;

        Token lv_convert_2_0=null;
        Token lv_drop_3_0=null;
        Token otherlv_4=null;
        EObject this_PrimaryExpression_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:2456:28: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalExprParser.g:2457:1: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalExprParser.g:2457:1: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )? )
            // InternalExprParser.g:2458:5: this_PrimaryExpression_0= rulePrimaryExpression ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )?
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
            // InternalExprParser.g:2466:1: ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==In||LA31_0==PercentSign||LA31_0==RULE_ID) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalExprParser.g:2466:2: () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) )
                    {
                    // InternalExprParser.g:2466:2: ()
                    // InternalExprParser.g:2467:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getUnitExpressionAccess().getUnitExpressionExpressionAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalExprParser.g:2472:2: ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )?
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
                            // InternalExprParser.g:2472:3: ( (lv_convert_2_0= PercentSign ) )
                            {
                            // InternalExprParser.g:2472:3: ( (lv_convert_2_0= PercentSign ) )
                            // InternalExprParser.g:2473:1: (lv_convert_2_0= PercentSign )
                            {
                            // InternalExprParser.g:2473:1: (lv_convert_2_0= PercentSign )
                            // InternalExprParser.g:2474:3: lv_convert_2_0= PercentSign
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
                            // InternalExprParser.g:2489:6: ( (lv_drop_3_0= In ) )
                            {
                            // InternalExprParser.g:2489:6: ( (lv_drop_3_0= In ) )
                            // InternalExprParser.g:2490:1: (lv_drop_3_0= In )
                            {
                            // InternalExprParser.g:2490:1: (lv_drop_3_0= In )
                            // InternalExprParser.g:2491:3: lv_drop_3_0= In
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

                    // InternalExprParser.g:2505:4: ( (otherlv_4= RULE_ID ) )
                    // InternalExprParser.g:2506:1: (otherlv_4= RULE_ID )
                    {
                    // InternalExprParser.g:2506:1: (otherlv_4= RULE_ID )
                    // InternalExprParser.g:2507:3: otherlv_4= RULE_ID
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
    // InternalExprParser.g:2526:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalExprParser.g:2527:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalExprParser.g:2528:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalExprParser.g:2535:1: rulePrimaryExpression returns [EObject current=null] : (this_VarRef_0= ruleVarRef | this_ModelOrPropertyReference_1= ruleModelOrPropertyReference | this_FunctionCall_2= ruleFunctionCall | this_RangeExpression_3= ruleRangeExpression | this_IfExpression_4= ruleIfExpression | this_Literal_5= ruleLiteral | (otherlv_6= LeftParenthesis this_Expression_7= ruleExpression otherlv_8= RightParenthesis ) ) ;
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
            // InternalExprParser.g:2538:28: ( (this_VarRef_0= ruleVarRef | this_ModelOrPropertyReference_1= ruleModelOrPropertyReference | this_FunctionCall_2= ruleFunctionCall | this_RangeExpression_3= ruleRangeExpression | this_IfExpression_4= ruleIfExpression | this_Literal_5= ruleLiteral | (otherlv_6= LeftParenthesis this_Expression_7= ruleExpression otherlv_8= RightParenthesis ) ) )
            // InternalExprParser.g:2539:1: (this_VarRef_0= ruleVarRef | this_ModelOrPropertyReference_1= ruleModelOrPropertyReference | this_FunctionCall_2= ruleFunctionCall | this_RangeExpression_3= ruleRangeExpression | this_IfExpression_4= ruleIfExpression | this_Literal_5= ruleLiteral | (otherlv_6= LeftParenthesis this_Expression_7= ruleExpression otherlv_8= RightParenthesis ) )
            {
            // InternalExprParser.g:2539:1: (this_VarRef_0= ruleVarRef | this_ModelOrPropertyReference_1= ruleModelOrPropertyReference | this_FunctionCall_2= ruleFunctionCall | this_RangeExpression_3= ruleRangeExpression | this_IfExpression_4= ruleIfExpression | this_Literal_5= ruleLiteral | (otherlv_6= LeftParenthesis this_Expression_7= ruleExpression otherlv_8= RightParenthesis ) )
            int alt32=7;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // InternalExprParser.g:2540:5: this_VarRef_0= ruleVarRef
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
                    // InternalExprParser.g:2550:5: this_ModelOrPropertyReference_1= ruleModelOrPropertyReference
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
                    // InternalExprParser.g:2560:5: this_FunctionCall_2= ruleFunctionCall
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
                    // InternalExprParser.g:2570:5: this_RangeExpression_3= ruleRangeExpression
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
                    // InternalExprParser.g:2580:5: this_IfExpression_4= ruleIfExpression
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
                    // InternalExprParser.g:2590:5: this_Literal_5= ruleLiteral
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
                    // InternalExprParser.g:2599:6: (otherlv_6= LeftParenthesis this_Expression_7= ruleExpression otherlv_8= RightParenthesis )
                    {
                    // InternalExprParser.g:2599:6: (otherlv_6= LeftParenthesis this_Expression_7= ruleExpression otherlv_8= RightParenthesis )
                    // InternalExprParser.g:2600:2: otherlv_6= LeftParenthesis this_Expression_7= ruleExpression otherlv_8= RightParenthesis
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
    // InternalExprParser.g:2626:1: entryRuleVarRef returns [EObject current=null] : iv_ruleVarRef= ruleVarRef EOF ;
    public final EObject entryRuleVarRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarRef = null;


        try {
            // InternalExprParser.g:2627:2: (iv_ruleVarRef= ruleVarRef EOF )
            // InternalExprParser.g:2628:2: iv_ruleVarRef= ruleVarRef EOF
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
    // InternalExprParser.g:2635:1: ruleVarRef returns [EObject current=null] : ( ( ruleQCREF ) ) ;
    public final EObject ruleVarRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2638:28: ( ( ( ruleQCREF ) ) )
            // InternalExprParser.g:2639:1: ( ( ruleQCREF ) )
            {
            // InternalExprParser.g:2639:1: ( ( ruleQCREF ) )
            // InternalExprParser.g:2640:1: ( ruleQCREF )
            {
            // InternalExprParser.g:2640:1: ( ruleQCREF )
            // InternalExprParser.g:2641:3: ruleQCREF
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
    // InternalExprParser.g:2663:1: entryRuleModelOrPropertyReference returns [EObject current=null] : iv_ruleModelOrPropertyReference= ruleModelOrPropertyReference EOF ;
    public final EObject entryRuleModelOrPropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelOrPropertyReference = null;


        try {
            // InternalExprParser.g:2664:2: (iv_ruleModelOrPropertyReference= ruleModelOrPropertyReference EOF )
            // InternalExprParser.g:2665:2: iv_ruleModelOrPropertyReference= ruleModelOrPropertyReference EOF
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
    // InternalExprParser.g:2672:1: ruleModelOrPropertyReference returns [EObject current=null] : ( (this_ModelReference_0= ruleModelReference ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )? ) | this_PropertyReference_4= rulePropertyReference ) ;
    public final EObject ruleModelOrPropertyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_ModelReference_0 = null;

        EObject this_PropertyReference_4 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:2675:28: ( ( (this_ModelReference_0= ruleModelReference ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )? ) | this_PropertyReference_4= rulePropertyReference ) )
            // InternalExprParser.g:2676:1: ( (this_ModelReference_0= ruleModelReference ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )? ) | this_PropertyReference_4= rulePropertyReference )
            {
            // InternalExprParser.g:2676:1: ( (this_ModelReference_0= ruleModelReference ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )? ) | this_PropertyReference_4= rulePropertyReference )
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
                    // InternalExprParser.g:2676:2: (this_ModelReference_0= ruleModelReference ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )? )
                    {
                    // InternalExprParser.g:2676:2: (this_ModelReference_0= ruleModelReference ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )? )
                    // InternalExprParser.g:2677:5: this_ModelReference_0= ruleModelReference ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )?
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
                    // InternalExprParser.g:2685:1: ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==NumberSign) && (synpred8_InternalExprParser())) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // InternalExprParser.g:2685:2: ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) )
                            {
                            // InternalExprParser.g:2685:2: ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) )
                            // InternalExprParser.g:2685:3: ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign )
                            {
                            // InternalExprParser.g:2688:5: ( () otherlv_2= NumberSign )
                            // InternalExprParser.g:2688:6: () otherlv_2= NumberSign
                            {
                            // InternalExprParser.g:2688:6: ()
                            // InternalExprParser.g:2689:5: 
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

                            // InternalExprParser.g:2699:3: ( ( ruleQPREF ) )
                            // InternalExprParser.g:2700:1: ( ruleQPREF )
                            {
                            // InternalExprParser.g:2700:1: ( ruleQPREF )
                            // InternalExprParser.g:2701:3: ruleQPREF
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
                    // InternalExprParser.g:2717:5: this_PropertyReference_4= rulePropertyReference
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
    // InternalExprParser.g:2733:1: entryRuleModelReference returns [EObject current=null] : iv_ruleModelReference= ruleModelReference EOF ;
    public final EObject entryRuleModelReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelReference = null;


        try {
            // InternalExprParser.g:2734:2: (iv_ruleModelReference= ruleModelReference EOF )
            // InternalExprParser.g:2735:2: iv_ruleModelReference= ruleModelReference EOF
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
    // InternalExprParser.g:2742:1: ruleModelReference returns [EObject current=null] : ( ( ( ruleThis ) ) ( () otherlv_2= FullStop ( (otherlv_3= RULE_ID ) ) )* ) ;
    public final EObject ruleModelReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2745:28: ( ( ( ( ruleThis ) ) ( () otherlv_2= FullStop ( (otherlv_3= RULE_ID ) ) )* ) )
            // InternalExprParser.g:2746:1: ( ( ( ruleThis ) ) ( () otherlv_2= FullStop ( (otherlv_3= RULE_ID ) ) )* )
            {
            // InternalExprParser.g:2746:1: ( ( ( ruleThis ) ) ( () otherlv_2= FullStop ( (otherlv_3= RULE_ID ) ) )* )
            // InternalExprParser.g:2746:2: ( ( ruleThis ) ) ( () otherlv_2= FullStop ( (otherlv_3= RULE_ID ) ) )*
            {
            // InternalExprParser.g:2746:2: ( ( ruleThis ) )
            // InternalExprParser.g:2747:1: ( ruleThis )
            {
            // InternalExprParser.g:2747:1: ( ruleThis )
            // InternalExprParser.g:2748:3: ruleThis
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

            // InternalExprParser.g:2762:2: ( () otherlv_2= FullStop ( (otherlv_3= RULE_ID ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==FullStop) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalExprParser.g:2762:3: () otherlv_2= FullStop ( (otherlv_3= RULE_ID ) )
            	    {
            	    // InternalExprParser.g:2762:3: ()
            	    // InternalExprParser.g:2763:5: 
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
            	    // InternalExprParser.g:2773:1: ( (otherlv_3= RULE_ID ) )
            	    // InternalExprParser.g:2774:1: (otherlv_3= RULE_ID )
            	    {
            	    // InternalExprParser.g:2774:1: (otherlv_3= RULE_ID )
            	    // InternalExprParser.g:2775:3: otherlv_3= RULE_ID
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
    // InternalExprParser.g:2794:1: entryRuleThis returns [String current=null] : iv_ruleThis= ruleThis EOF ;
    public final String entryRuleThis() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleThis = null;


        try {
            // InternalExprParser.g:2795:1: (iv_ruleThis= ruleThis EOF )
            // InternalExprParser.g:2796:2: iv_ruleThis= ruleThis EOF
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
    // InternalExprParser.g:2803:1: ruleThis returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= This ;
    public final AntlrDatatypeRuleToken ruleThis() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2807:6: (kw= This )
            // InternalExprParser.g:2809:2: kw= This
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
    // InternalExprParser.g:2822:1: entryRulePropertyReference returns [EObject current=null] : iv_rulePropertyReference= rulePropertyReference EOF ;
    public final EObject entryRulePropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyReference = null;


        try {
            // InternalExprParser.g:2823:2: (iv_rulePropertyReference= rulePropertyReference EOF )
            // InternalExprParser.g:2824:2: iv_rulePropertyReference= rulePropertyReference EOF
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
    // InternalExprParser.g:2831:1: rulePropertyReference returns [EObject current=null] : ( () otherlv_1= NumberSign ( ( ruleQPREF ) ) ) ;
    public final EObject rulePropertyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:2834:28: ( ( () otherlv_1= NumberSign ( ( ruleQPREF ) ) ) )
            // InternalExprParser.g:2835:1: ( () otherlv_1= NumberSign ( ( ruleQPREF ) ) )
            {
            // InternalExprParser.g:2835:1: ( () otherlv_1= NumberSign ( ( ruleQPREF ) ) )
            // InternalExprParser.g:2835:2: () otherlv_1= NumberSign ( ( ruleQPREF ) )
            {
            // InternalExprParser.g:2835:2: ()
            // InternalExprParser.g:2836:5: 
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
            // InternalExprParser.g:2846:1: ( ( ruleQPREF ) )
            // InternalExprParser.g:2847:1: ( ruleQPREF )
            {
            // InternalExprParser.g:2847:1: ( ruleQPREF )
            // InternalExprParser.g:2848:3: ruleQPREF
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
    // InternalExprParser.g:2870:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // InternalExprParser.g:2871:2: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // InternalExprParser.g:2872:2: iv_ruleFunctionCall= ruleFunctionCall EOF
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
    // InternalExprParser.g:2879:1: ruleFunctionCall returns [EObject current=null] : ( () ( (lv_function_1_0= ruleQCREF ) ) otherlv_2= LeftParenthesis ( ( (lv_arguments_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_arguments_5_0= ruleExpression ) ) )* )? otherlv_6= RightParenthesis ) ;
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
            // InternalExprParser.g:2882:28: ( ( () ( (lv_function_1_0= ruleQCREF ) ) otherlv_2= LeftParenthesis ( ( (lv_arguments_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_arguments_5_0= ruleExpression ) ) )* )? otherlv_6= RightParenthesis ) )
            // InternalExprParser.g:2883:1: ( () ( (lv_function_1_0= ruleQCREF ) ) otherlv_2= LeftParenthesis ( ( (lv_arguments_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_arguments_5_0= ruleExpression ) ) )* )? otherlv_6= RightParenthesis )
            {
            // InternalExprParser.g:2883:1: ( () ( (lv_function_1_0= ruleQCREF ) ) otherlv_2= LeftParenthesis ( ( (lv_arguments_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_arguments_5_0= ruleExpression ) ) )* )? otherlv_6= RightParenthesis )
            // InternalExprParser.g:2883:2: () ( (lv_function_1_0= ruleQCREF ) ) otherlv_2= LeftParenthesis ( ( (lv_arguments_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_arguments_5_0= ruleExpression ) ) )* )? otherlv_6= RightParenthesis
            {
            // InternalExprParser.g:2883:2: ()
            // InternalExprParser.g:2884:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getFunctionCallAccess().getFunctionCallAction_0(),
                          current);
                  
            }

            }

            // InternalExprParser.g:2889:2: ( (lv_function_1_0= ruleQCREF ) )
            // InternalExprParser.g:2890:1: (lv_function_1_0= ruleQCREF )
            {
            // InternalExprParser.g:2890:1: (lv_function_1_0= ruleQCREF )
            // InternalExprParser.g:2891:3: lv_function_1_0= ruleQCREF
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
                      		"org.osate.expr.Expr.QCREF");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,LeftParenthesis,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_2());
                  
            }
            // InternalExprParser.g:2912:1: ( ( (lv_arguments_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_arguments_5_0= ruleExpression ) ) )* )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==Record||LA37_0==False||(LA37_0>=Tuple && LA37_0<=Union)||LA37_0==List||(LA37_0>=This && LA37_0<=True)||LA37_0==Bag||LA37_0==Map||(LA37_0>=Not && LA37_0<=Set)||LA37_0==If||LA37_0==NumberSign||LA37_0==LeftParenthesis||LA37_0==PlusSign||LA37_0==HyphenMinus||LA37_0==LeftSquareBracket||LA37_0==RULE_REAL_LIT||LA37_0==RULE_INTEGER_LIT||(LA37_0>=RULE_STRING && LA37_0<=RULE_ID)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalExprParser.g:2912:2: ( (lv_arguments_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_arguments_5_0= ruleExpression ) ) )*
                    {
                    // InternalExprParser.g:2912:2: ( (lv_arguments_3_0= ruleExpression ) )
                    // InternalExprParser.g:2913:1: (lv_arguments_3_0= ruleExpression )
                    {
                    // InternalExprParser.g:2913:1: (lv_arguments_3_0= ruleExpression )
                    // InternalExprParser.g:2914:3: lv_arguments_3_0= ruleExpression
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

                    // InternalExprParser.g:2930:2: (otherlv_4= Comma ( (lv_arguments_5_0= ruleExpression ) ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==Comma) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // InternalExprParser.g:2931:2: otherlv_4= Comma ( (lv_arguments_5_0= ruleExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_10); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getFunctionCallAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // InternalExprParser.g:2935:1: ( (lv_arguments_5_0= ruleExpression ) )
                    	    // InternalExprParser.g:2936:1: (lv_arguments_5_0= ruleExpression )
                    	    {
                    	    // InternalExprParser.g:2936:1: (lv_arguments_5_0= ruleExpression )
                    	    // InternalExprParser.g:2937:3: lv_arguments_5_0= ruleExpression
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
    // InternalExprParser.g:2966:1: entryRuleRangeExpression returns [EObject current=null] : iv_ruleRangeExpression= ruleRangeExpression EOF ;
    public final EObject entryRuleRangeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeExpression = null;


        try {
            // InternalExprParser.g:2967:2: (iv_ruleRangeExpression= ruleRangeExpression EOF )
            // InternalExprParser.g:2968:2: iv_ruleRangeExpression= ruleRangeExpression EOF
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
    // InternalExprParser.g:2975:1: ruleRangeExpression returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_minimum_2_0= ruleExpression ) ) otherlv_3= FullStopFullStop ( (lv_maximum_4_0= ruleExpression ) ) ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )? otherlv_7= RightSquareBracket ) ;
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
            // InternalExprParser.g:2978:28: ( ( () otherlv_1= LeftSquareBracket ( (lv_minimum_2_0= ruleExpression ) ) otherlv_3= FullStopFullStop ( (lv_maximum_4_0= ruleExpression ) ) ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )? otherlv_7= RightSquareBracket ) )
            // InternalExprParser.g:2979:1: ( () otherlv_1= LeftSquareBracket ( (lv_minimum_2_0= ruleExpression ) ) otherlv_3= FullStopFullStop ( (lv_maximum_4_0= ruleExpression ) ) ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )? otherlv_7= RightSquareBracket )
            {
            // InternalExprParser.g:2979:1: ( () otherlv_1= LeftSquareBracket ( (lv_minimum_2_0= ruleExpression ) ) otherlv_3= FullStopFullStop ( (lv_maximum_4_0= ruleExpression ) ) ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )? otherlv_7= RightSquareBracket )
            // InternalExprParser.g:2979:2: () otherlv_1= LeftSquareBracket ( (lv_minimum_2_0= ruleExpression ) ) otherlv_3= FullStopFullStop ( (lv_maximum_4_0= ruleExpression ) ) ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )? otherlv_7= RightSquareBracket
            {
            // InternalExprParser.g:2979:2: ()
            // InternalExprParser.g:2980:5: 
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
            // InternalExprParser.g:2990:1: ( (lv_minimum_2_0= ruleExpression ) )
            // InternalExprParser.g:2991:1: (lv_minimum_2_0= ruleExpression )
            {
            // InternalExprParser.g:2991:1: (lv_minimum_2_0= ruleExpression )
            // InternalExprParser.g:2992:3: lv_minimum_2_0= ruleExpression
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
            // InternalExprParser.g:3013:1: ( (lv_maximum_4_0= ruleExpression ) )
            // InternalExprParser.g:3014:1: (lv_maximum_4_0= ruleExpression )
            {
            // InternalExprParser.g:3014:1: (lv_maximum_4_0= ruleExpression )
            // InternalExprParser.g:3015:3: lv_maximum_4_0= ruleExpression
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

            // InternalExprParser.g:3031:2: ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==Delta) && (synpred9_InternalExprParser())) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalExprParser.g:3031:3: ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) )
                    {
                    // InternalExprParser.g:3031:3: ( ( Delta )=>otherlv_5= Delta )
                    // InternalExprParser.g:3031:4: ( Delta )=>otherlv_5= Delta
                    {
                    otherlv_5=(Token)match(input,Delta,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getRangeExpressionAccess().getDeltaKeyword_5_0());
                          
                    }

                    }

                    // InternalExprParser.g:3038:2: ( (lv_delta_6_0= ruleExpression ) )
                    // InternalExprParser.g:3039:1: (lv_delta_6_0= ruleExpression )
                    {
                    // InternalExprParser.g:3039:1: (lv_delta_6_0= ruleExpression )
                    // InternalExprParser.g:3040:3: lv_delta_6_0= ruleExpression
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
    // InternalExprParser.g:3069:1: entryRuleIfExpression returns [EObject current=null] : iv_ruleIfExpression= ruleIfExpression EOF ;
    public final EObject entryRuleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpression = null;


        try {
            // InternalExprParser.g:3070:2: (iv_ruleIfExpression= ruleIfExpression EOF )
            // InternalExprParser.g:3071:2: iv_ruleIfExpression= ruleIfExpression EOF
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
    // InternalExprParser.g:3078:1: ruleIfExpression returns [EObject current=null] : ( () otherlv_1= If ( (lv_if_2_0= ruleExpression ) ) otherlv_3= Then ( (lv_then_4_0= ruleExpression ) ) (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )? otherlv_7= Endif ) ;
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
            // InternalExprParser.g:3081:28: ( ( () otherlv_1= If ( (lv_if_2_0= ruleExpression ) ) otherlv_3= Then ( (lv_then_4_0= ruleExpression ) ) (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )? otherlv_7= Endif ) )
            // InternalExprParser.g:3082:1: ( () otherlv_1= If ( (lv_if_2_0= ruleExpression ) ) otherlv_3= Then ( (lv_then_4_0= ruleExpression ) ) (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )? otherlv_7= Endif )
            {
            // InternalExprParser.g:3082:1: ( () otherlv_1= If ( (lv_if_2_0= ruleExpression ) ) otherlv_3= Then ( (lv_then_4_0= ruleExpression ) ) (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )? otherlv_7= Endif )
            // InternalExprParser.g:3082:2: () otherlv_1= If ( (lv_if_2_0= ruleExpression ) ) otherlv_3= Then ( (lv_then_4_0= ruleExpression ) ) (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )? otherlv_7= Endif
            {
            // InternalExprParser.g:3082:2: ()
            // InternalExprParser.g:3083:5: 
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
            // InternalExprParser.g:3093:1: ( (lv_if_2_0= ruleExpression ) )
            // InternalExprParser.g:3094:1: (lv_if_2_0= ruleExpression )
            {
            // InternalExprParser.g:3094:1: (lv_if_2_0= ruleExpression )
            // InternalExprParser.g:3095:3: lv_if_2_0= ruleExpression
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
            // InternalExprParser.g:3116:1: ( (lv_then_4_0= ruleExpression ) )
            // InternalExprParser.g:3117:1: (lv_then_4_0= ruleExpression )
            {
            // InternalExprParser.g:3117:1: (lv_then_4_0= ruleExpression )
            // InternalExprParser.g:3118:3: lv_then_4_0= ruleExpression
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

            // InternalExprParser.g:3134:2: (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==Else) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalExprParser.g:3135:2: otherlv_5= Else ( (lv_else_6_0= ruleExpression ) )
                    {
                    otherlv_5=(Token)match(input,Else,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getIfExpressionAccess().getElseKeyword_5_0());
                          
                    }
                    // InternalExprParser.g:3139:1: ( (lv_else_6_0= ruleExpression ) )
                    // InternalExprParser.g:3140:1: (lv_else_6_0= ruleExpression )
                    {
                    // InternalExprParser.g:3140:1: (lv_else_6_0= ruleExpression )
                    // InternalExprParser.g:3141:3: lv_else_6_0= ruleExpression
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
    // InternalExprParser.g:3170:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalExprParser.g:3171:2: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalExprParser.g:3172:2: iv_ruleLiteral= ruleLiteral EOF
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
    // InternalExprParser.g:3179:1: ruleLiteral returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_IntegerLiteral_1= ruleIntegerLiteral | this_RealLiteral_2= ruleRealLiteral | this_StringLiteral_3= ruleStringLiteral | this_ListLiteral_4= ruleListLiteral | this_SetLiteral_5= ruleSetLiteral | this_RecordLiteral_6= ruleRecordLiteral | this_UnionLiteral_7= ruleUnionLiteral | this_TupleLiteral_8= ruleTupleLiteral | this_BagLiteral_9= ruleBagLiteral | this_MapLiteral_10= ruleMapLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_IntegerLiteral_1 = null;

        EObject this_RealLiteral_2 = null;

        EObject this_StringLiteral_3 = null;

        EObject this_ListLiteral_4 = null;

        EObject this_SetLiteral_5 = null;

        EObject this_RecordLiteral_6 = null;

        EObject this_UnionLiteral_7 = null;

        EObject this_TupleLiteral_8 = null;

        EObject this_BagLiteral_9 = null;

        EObject this_MapLiteral_10 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3182:28: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_IntegerLiteral_1= ruleIntegerLiteral | this_RealLiteral_2= ruleRealLiteral | this_StringLiteral_3= ruleStringLiteral | this_ListLiteral_4= ruleListLiteral | this_SetLiteral_5= ruleSetLiteral | this_RecordLiteral_6= ruleRecordLiteral | this_UnionLiteral_7= ruleUnionLiteral | this_TupleLiteral_8= ruleTupleLiteral | this_BagLiteral_9= ruleBagLiteral | this_MapLiteral_10= ruleMapLiteral ) )
            // InternalExprParser.g:3183:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_IntegerLiteral_1= ruleIntegerLiteral | this_RealLiteral_2= ruleRealLiteral | this_StringLiteral_3= ruleStringLiteral | this_ListLiteral_4= ruleListLiteral | this_SetLiteral_5= ruleSetLiteral | this_RecordLiteral_6= ruleRecordLiteral | this_UnionLiteral_7= ruleUnionLiteral | this_TupleLiteral_8= ruleTupleLiteral | this_BagLiteral_9= ruleBagLiteral | this_MapLiteral_10= ruleMapLiteral )
            {
            // InternalExprParser.g:3183:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_IntegerLiteral_1= ruleIntegerLiteral | this_RealLiteral_2= ruleRealLiteral | this_StringLiteral_3= ruleStringLiteral | this_ListLiteral_4= ruleListLiteral | this_SetLiteral_5= ruleSetLiteral | this_RecordLiteral_6= ruleRecordLiteral | this_UnionLiteral_7= ruleUnionLiteral | this_TupleLiteral_8= ruleTupleLiteral | this_BagLiteral_9= ruleBagLiteral | this_MapLiteral_10= ruleMapLiteral )
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
                    // InternalExprParser.g:3184:5: this_BooleanLiteral_0= ruleBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_BooleanLiteral_0=ruleBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_BooleanLiteral_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:3194:5: this_IntegerLiteral_1= ruleIntegerLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getIntegerLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_IntegerLiteral_1=ruleIntegerLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_IntegerLiteral_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:3204:5: this_RealLiteral_2= ruleRealLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getRealLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_RealLiteral_2=ruleRealLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_RealLiteral_2;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:3214:5: this_StringLiteral_3= ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_StringLiteral_3=ruleStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_StringLiteral_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalExprParser.g:3224:5: this_ListLiteral_4= ruleListLiteral
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
                    // InternalExprParser.g:3234:5: this_SetLiteral_5= ruleSetLiteral
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
                    // InternalExprParser.g:3244:5: this_RecordLiteral_6= ruleRecordLiteral
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
                    // InternalExprParser.g:3254:5: this_UnionLiteral_7= ruleUnionLiteral
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
                    // InternalExprParser.g:3264:5: this_TupleLiteral_8= ruleTupleLiteral
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
                    // InternalExprParser.g:3274:5: this_BagLiteral_9= ruleBagLiteral
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
                    // InternalExprParser.g:3284:5: this_MapLiteral_10= ruleMapLiteral
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


    // $ANTLR start "entryRuleBooleanLiteral"
    // InternalExprParser.g:3300:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalExprParser.g:3301:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalExprParser.g:3302:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
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
    // InternalExprParser.g:3309:1: ruleBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:3312:28: ( ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) )
            // InternalExprParser.g:3313:1: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            {
            // InternalExprParser.g:3313:1: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            // InternalExprParser.g:3313:2: () ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            {
            // InternalExprParser.g:3313:2: ()
            // InternalExprParser.g:3314:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // InternalExprParser.g:3319:2: ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
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
                    // InternalExprParser.g:3319:3: ( (lv_value_1_0= True ) )
                    {
                    // InternalExprParser.g:3319:3: ( (lv_value_1_0= True ) )
                    // InternalExprParser.g:3320:1: (lv_value_1_0= True )
                    {
                    // InternalExprParser.g:3320:1: (lv_value_1_0= True )
                    // InternalExprParser.g:3321:3: lv_value_1_0= True
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
                    // InternalExprParser.g:3337:2: otherlv_2= False
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


    // $ANTLR start "entryRuleIntegerLiteral"
    // InternalExprParser.g:3349:1: entryRuleIntegerLiteral returns [EObject current=null] : iv_ruleIntegerLiteral= ruleIntegerLiteral EOF ;
    public final EObject entryRuleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteral = null;


        try {
            // InternalExprParser.g:3350:2: (iv_ruleIntegerLiteral= ruleIntegerLiteral EOF )
            // InternalExprParser.g:3351:2: iv_ruleIntegerLiteral= ruleIntegerLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegerLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIntegerLiteral=ruleIntegerLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntegerLiteral; 
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
    // $ANTLR end "entryRuleIntegerLiteral"


    // $ANTLR start "ruleIntegerLiteral"
    // InternalExprParser.g:3358:1: ruleIntegerLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INTEGER_LIT ) ) ) ;
    public final EObject ruleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:3361:28: ( ( () ( (lv_value_1_0= RULE_INTEGER_LIT ) ) ) )
            // InternalExprParser.g:3362:1: ( () ( (lv_value_1_0= RULE_INTEGER_LIT ) ) )
            {
            // InternalExprParser.g:3362:1: ( () ( (lv_value_1_0= RULE_INTEGER_LIT ) ) )
            // InternalExprParser.g:3362:2: () ( (lv_value_1_0= RULE_INTEGER_LIT ) )
            {
            // InternalExprParser.g:3362:2: ()
            // InternalExprParser.g:3363:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getIntegerLiteralAccess().getIntegerLiteralAction_0(),
                          current);
                  
            }

            }

            // InternalExprParser.g:3368:2: ( (lv_value_1_0= RULE_INTEGER_LIT ) )
            // InternalExprParser.g:3369:1: (lv_value_1_0= RULE_INTEGER_LIT )
            {
            // InternalExprParser.g:3369:1: (lv_value_1_0= RULE_INTEGER_LIT )
            // InternalExprParser.g:3370:3: lv_value_1_0= RULE_INTEGER_LIT
            {
            lv_value_1_0=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getIntegerLiteralAccess().getValueINTEGER_LITTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getIntegerLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"org.osate.expr.Expr.INTEGER_LIT");
              	    
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
    // $ANTLR end "ruleIntegerLiteral"


    // $ANTLR start "entryRuleRealLiteral"
    // InternalExprParser.g:3394:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // InternalExprParser.g:3395:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // InternalExprParser.g:3396:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRealLiteral=ruleRealLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealLiteral; 
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
    // $ANTLR end "entryRuleRealLiteral"


    // $ANTLR start "ruleRealLiteral"
    // InternalExprParser.g:3403:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_REAL_LIT ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:3406:28: ( ( () ( (lv_value_1_0= RULE_REAL_LIT ) ) ) )
            // InternalExprParser.g:3407:1: ( () ( (lv_value_1_0= RULE_REAL_LIT ) ) )
            {
            // InternalExprParser.g:3407:1: ( () ( (lv_value_1_0= RULE_REAL_LIT ) ) )
            // InternalExprParser.g:3407:2: () ( (lv_value_1_0= RULE_REAL_LIT ) )
            {
            // InternalExprParser.g:3407:2: ()
            // InternalExprParser.g:3408:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
                          current);
                  
            }

            }

            // InternalExprParser.g:3413:2: ( (lv_value_1_0= RULE_REAL_LIT ) )
            // InternalExprParser.g:3414:1: (lv_value_1_0= RULE_REAL_LIT )
            {
            // InternalExprParser.g:3414:1: (lv_value_1_0= RULE_REAL_LIT )
            // InternalExprParser.g:3415:3: lv_value_1_0= RULE_REAL_LIT
            {
            lv_value_1_0=(Token)match(input,RULE_REAL_LIT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getRealLiteralAccess().getValueREAL_LITTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRealLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"org.osate.expr.Expr.REAL_LIT");
              	    
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
    // $ANTLR end "ruleRealLiteral"


    // $ANTLR start "entryRuleStringLiteral"
    // InternalExprParser.g:3439:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalExprParser.g:3440:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalExprParser.g:3441:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral; 
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
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // InternalExprParser.g:3448:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleNoQuoteString ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3451:28: ( ( () ( (lv_value_1_0= ruleNoQuoteString ) ) ) )
            // InternalExprParser.g:3452:1: ( () ( (lv_value_1_0= ruleNoQuoteString ) ) )
            {
            // InternalExprParser.g:3452:1: ( () ( (lv_value_1_0= ruleNoQuoteString ) ) )
            // InternalExprParser.g:3452:2: () ( (lv_value_1_0= ruleNoQuoteString ) )
            {
            // InternalExprParser.g:3452:2: ()
            // InternalExprParser.g:3453:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
                          current);
                  
            }

            }

            // InternalExprParser.g:3458:2: ( (lv_value_1_0= ruleNoQuoteString ) )
            // InternalExprParser.g:3459:1: (lv_value_1_0= ruleNoQuoteString )
            {
            // InternalExprParser.g:3459:1: (lv_value_1_0= ruleNoQuoteString )
            // InternalExprParser.g:3460:3: lv_value_1_0= ruleNoQuoteString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStringLiteralAccess().getValueNoQuoteStringParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getStringLiteralRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"org.osate.expr.Expr.NoQuoteString");
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
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "ruleCommaSeparatedExpressions"
    // InternalExprParser.g:3485:1: ruleCommaSeparatedExpressions[EObject in_current] returns [EObject current=in_current] : ( ( (lv_elements_0_0= ruleExpression ) ) (otherlv_1= Comma ( (lv_elements_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleCommaSeparatedExpressions(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_elements_0_0 = null;

        EObject lv_elements_2_0 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3488:28: ( ( ( (lv_elements_0_0= ruleExpression ) ) (otherlv_1= Comma ( (lv_elements_2_0= ruleExpression ) ) )* ) )
            // InternalExprParser.g:3489:1: ( ( (lv_elements_0_0= ruleExpression ) ) (otherlv_1= Comma ( (lv_elements_2_0= ruleExpression ) ) )* )
            {
            // InternalExprParser.g:3489:1: ( ( (lv_elements_0_0= ruleExpression ) ) (otherlv_1= Comma ( (lv_elements_2_0= ruleExpression ) ) )* )
            // InternalExprParser.g:3489:2: ( (lv_elements_0_0= ruleExpression ) ) (otherlv_1= Comma ( (lv_elements_2_0= ruleExpression ) ) )*
            {
            // InternalExprParser.g:3489:2: ( (lv_elements_0_0= ruleExpression ) )
            // InternalExprParser.g:3490:1: (lv_elements_0_0= ruleExpression )
            {
            // InternalExprParser.g:3490:1: (lv_elements_0_0= ruleExpression )
            // InternalExprParser.g:3491:3: lv_elements_0_0= ruleExpression
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

            // InternalExprParser.g:3507:2: (otherlv_1= Comma ( (lv_elements_2_0= ruleExpression ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==Comma) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalExprParser.g:3508:2: otherlv_1= Comma ( (lv_elements_2_0= ruleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,Comma,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getCommaSeparatedExpressionsAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // InternalExprParser.g:3512:1: ( (lv_elements_2_0= ruleExpression ) )
            	    // InternalExprParser.g:3513:1: (lv_elements_2_0= ruleExpression )
            	    {
            	    // InternalExprParser.g:3513:1: (lv_elements_2_0= ruleExpression )
            	    // InternalExprParser.g:3514:3: lv_elements_2_0= ruleExpression
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
    // InternalExprParser.g:3538:1: entryRuleListLiteral returns [EObject current=null] : iv_ruleListLiteral= ruleListLiteral EOF ;
    public final EObject entryRuleListLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListLiteral = null;


        try {
            // InternalExprParser.g:3539:2: (iv_ruleListLiteral= ruleListLiteral EOF )
            // InternalExprParser.g:3540:2: iv_ruleListLiteral= ruleListLiteral EOF
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
    // InternalExprParser.g:3547:1: ruleListLiteral returns [EObject current=null] : ( () otherlv_1= List otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis ) ;
    public final EObject ruleListLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_CommaSeparatedExpressions_3 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3550:28: ( ( () otherlv_1= List otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis ) )
            // InternalExprParser.g:3551:1: ( () otherlv_1= List otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis )
            {
            // InternalExprParser.g:3551:1: ( () otherlv_1= List otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis )
            // InternalExprParser.g:3551:2: () otherlv_1= List otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis
            {
            // InternalExprParser.g:3551:2: ()
            // InternalExprParser.g:3552:5: 
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
            // InternalExprParser.g:3567:1: (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==Record||LA43_0==False||(LA43_0>=Tuple && LA43_0<=Union)||LA43_0==List||(LA43_0>=This && LA43_0<=True)||LA43_0==Bag||LA43_0==Map||(LA43_0>=Not && LA43_0<=Set)||LA43_0==If||LA43_0==NumberSign||LA43_0==LeftParenthesis||LA43_0==PlusSign||LA43_0==HyphenMinus||LA43_0==LeftSquareBracket||LA43_0==RULE_REAL_LIT||LA43_0==RULE_INTEGER_LIT||(LA43_0>=RULE_STRING && LA43_0<=RULE_ID)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalExprParser.g:3568:5: this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current]
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
    // InternalExprParser.g:3592:1: entryRuleSetLiteral returns [EObject current=null] : iv_ruleSetLiteral= ruleSetLiteral EOF ;
    public final EObject entryRuleSetLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetLiteral = null;


        try {
            // InternalExprParser.g:3593:2: (iv_ruleSetLiteral= ruleSetLiteral EOF )
            // InternalExprParser.g:3594:2: iv_ruleSetLiteral= ruleSetLiteral EOF
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
    // InternalExprParser.g:3601:1: ruleSetLiteral returns [EObject current=null] : ( () otherlv_1= Set otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis ) ;
    public final EObject ruleSetLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_CommaSeparatedExpressions_3 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3604:28: ( ( () otherlv_1= Set otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis ) )
            // InternalExprParser.g:3605:1: ( () otherlv_1= Set otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis )
            {
            // InternalExprParser.g:3605:1: ( () otherlv_1= Set otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis )
            // InternalExprParser.g:3605:2: () otherlv_1= Set otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis
            {
            // InternalExprParser.g:3605:2: ()
            // InternalExprParser.g:3606:5: 
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
            // InternalExprParser.g:3621:1: (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==Record||LA44_0==False||(LA44_0>=Tuple && LA44_0<=Union)||LA44_0==List||(LA44_0>=This && LA44_0<=True)||LA44_0==Bag||LA44_0==Map||(LA44_0>=Not && LA44_0<=Set)||LA44_0==If||LA44_0==NumberSign||LA44_0==LeftParenthesis||LA44_0==PlusSign||LA44_0==HyphenMinus||LA44_0==LeftSquareBracket||LA44_0==RULE_REAL_LIT||LA44_0==RULE_INTEGER_LIT||(LA44_0>=RULE_STRING && LA44_0<=RULE_ID)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalExprParser.g:3622:5: this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current]
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
    // InternalExprParser.g:3646:1: entryRuleRecordLiteral returns [EObject current=null] : iv_ruleRecordLiteral= ruleRecordLiteral EOF ;
    public final EObject entryRuleRecordLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordLiteral = null;


        try {
            // InternalExprParser.g:3647:2: (iv_ruleRecordLiteral= ruleRecordLiteral EOF )
            // InternalExprParser.g:3648:2: iv_ruleRecordLiteral= ruleRecordLiteral EOF
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
    // InternalExprParser.g:3655:1: ruleRecordLiteral returns [EObject current=null] : ( () otherlv_1= Record ) ;
    public final EObject ruleRecordLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:3658:28: ( ( () otherlv_1= Record ) )
            // InternalExprParser.g:3659:1: ( () otherlv_1= Record )
            {
            // InternalExprParser.g:3659:1: ( () otherlv_1= Record )
            // InternalExprParser.g:3659:2: () otherlv_1= Record
            {
            // InternalExprParser.g:3659:2: ()
            // InternalExprParser.g:3660:5: 
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
    // InternalExprParser.g:3678:1: entryRuleUnionLiteral returns [EObject current=null] : iv_ruleUnionLiteral= ruleUnionLiteral EOF ;
    public final EObject entryRuleUnionLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnionLiteral = null;


        try {
            // InternalExprParser.g:3679:2: (iv_ruleUnionLiteral= ruleUnionLiteral EOF )
            // InternalExprParser.g:3680:2: iv_ruleUnionLiteral= ruleUnionLiteral EOF
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
    // InternalExprParser.g:3687:1: ruleUnionLiteral returns [EObject current=null] : ( () otherlv_1= Union ) ;
    public final EObject ruleUnionLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:3690:28: ( ( () otherlv_1= Union ) )
            // InternalExprParser.g:3691:1: ( () otherlv_1= Union )
            {
            // InternalExprParser.g:3691:1: ( () otherlv_1= Union )
            // InternalExprParser.g:3691:2: () otherlv_1= Union
            {
            // InternalExprParser.g:3691:2: ()
            // InternalExprParser.g:3692:5: 
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
    // InternalExprParser.g:3710:1: entryRuleTupleLiteral returns [EObject current=null] : iv_ruleTupleLiteral= ruleTupleLiteral EOF ;
    public final EObject entryRuleTupleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteral = null;


        try {
            // InternalExprParser.g:3711:2: (iv_ruleTupleLiteral= ruleTupleLiteral EOF )
            // InternalExprParser.g:3712:2: iv_ruleTupleLiteral= ruleTupleLiteral EOF
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
    // InternalExprParser.g:3719:1: ruleTupleLiteral returns [EObject current=null] : ( () otherlv_1= Tuple otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis ) ;
    public final EObject ruleTupleLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_CommaSeparatedExpressions_3 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3722:28: ( ( () otherlv_1= Tuple otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis ) )
            // InternalExprParser.g:3723:1: ( () otherlv_1= Tuple otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis )
            {
            // InternalExprParser.g:3723:1: ( () otherlv_1= Tuple otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis )
            // InternalExprParser.g:3723:2: () otherlv_1= Tuple otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis
            {
            // InternalExprParser.g:3723:2: ()
            // InternalExprParser.g:3724:5: 
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
            // InternalExprParser.g:3739:1: (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==Record||LA45_0==False||(LA45_0>=Tuple && LA45_0<=Union)||LA45_0==List||(LA45_0>=This && LA45_0<=True)||LA45_0==Bag||LA45_0==Map||(LA45_0>=Not && LA45_0<=Set)||LA45_0==If||LA45_0==NumberSign||LA45_0==LeftParenthesis||LA45_0==PlusSign||LA45_0==HyphenMinus||LA45_0==LeftSquareBracket||LA45_0==RULE_REAL_LIT||LA45_0==RULE_INTEGER_LIT||(LA45_0>=RULE_STRING && LA45_0<=RULE_ID)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalExprParser.g:3740:5: this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current]
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
    // InternalExprParser.g:3764:1: entryRuleBagLiteral returns [EObject current=null] : iv_ruleBagLiteral= ruleBagLiteral EOF ;
    public final EObject entryRuleBagLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBagLiteral = null;


        try {
            // InternalExprParser.g:3765:2: (iv_ruleBagLiteral= ruleBagLiteral EOF )
            // InternalExprParser.g:3766:2: iv_ruleBagLiteral= ruleBagLiteral EOF
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
    // InternalExprParser.g:3773:1: ruleBagLiteral returns [EObject current=null] : ( () otherlv_1= Bag otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis ) ;
    public final EObject ruleBagLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_CommaSeparatedExpressions_3 = null;


         enterRule(); 
            
        try {
            // InternalExprParser.g:3776:28: ( ( () otherlv_1= Bag otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis ) )
            // InternalExprParser.g:3777:1: ( () otherlv_1= Bag otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis )
            {
            // InternalExprParser.g:3777:1: ( () otherlv_1= Bag otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis )
            // InternalExprParser.g:3777:2: () otherlv_1= Bag otherlv_2= LeftParenthesis (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )? otherlv_4= RightParenthesis
            {
            // InternalExprParser.g:3777:2: ()
            // InternalExprParser.g:3778:5: 
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
            // InternalExprParser.g:3793:1: (this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current] )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==Record||LA46_0==False||(LA46_0>=Tuple && LA46_0<=Union)||LA46_0==List||(LA46_0>=This && LA46_0<=True)||LA46_0==Bag||LA46_0==Map||(LA46_0>=Not && LA46_0<=Set)||LA46_0==If||LA46_0==NumberSign||LA46_0==LeftParenthesis||LA46_0==PlusSign||LA46_0==HyphenMinus||LA46_0==LeftSquareBracket||LA46_0==RULE_REAL_LIT||LA46_0==RULE_INTEGER_LIT||(LA46_0>=RULE_STRING && LA46_0<=RULE_ID)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalExprParser.g:3794:5: this_CommaSeparatedExpressions_3= ruleCommaSeparatedExpressions[$current]
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
    // InternalExprParser.g:3818:1: entryRuleMapLiteral returns [EObject current=null] : iv_ruleMapLiteral= ruleMapLiteral EOF ;
    public final EObject entryRuleMapLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapLiteral = null;


        try {
            // InternalExprParser.g:3819:2: (iv_ruleMapLiteral= ruleMapLiteral EOF )
            // InternalExprParser.g:3820:2: iv_ruleMapLiteral= ruleMapLiteral EOF
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
    // InternalExprParser.g:3827:1: ruleMapLiteral returns [EObject current=null] : ( () otherlv_1= Map ) ;
    public final EObject ruleMapLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:3830:28: ( ( () otherlv_1= Map ) )
            // InternalExprParser.g:3831:1: ( () otherlv_1= Map )
            {
            // InternalExprParser.g:3831:1: ( () otherlv_1= Map )
            // InternalExprParser.g:3831:2: () otherlv_1= Map
            {
            // InternalExprParser.g:3831:2: ()
            // InternalExprParser.g:3832:5: 
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


    // $ANTLR start "entryRuleNoQuoteString"
    // InternalExprParser.g:3850:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // InternalExprParser.g:3851:1: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // InternalExprParser.g:3852:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
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
    // InternalExprParser.g:3859:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:3863:6: (this_STRING_0= RULE_STRING )
            // InternalExprParser.g:3864:5: this_STRING_0= RULE_STRING
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


    // $ANTLR start "entryRuleQPREF"
    // InternalExprParser.g:3881:1: entryRuleQPREF returns [String current=null] : iv_ruleQPREF= ruleQPREF EOF ;
    public final String entryRuleQPREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQPREF = null;


        try {
            // InternalExprParser.g:3882:1: (iv_ruleQPREF= ruleQPREF EOF )
            // InternalExprParser.g:3883:2: iv_ruleQPREF= ruleQPREF EOF
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
    // InternalExprParser.g:3890:1: ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQPREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:3894:6: ( (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? ) )
            // InternalExprParser.g:3895:1: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? )
            {
            // InternalExprParser.g:3895:1: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? )
            // InternalExprParser.g:3895:6: this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // InternalExprParser.g:3902:1: (kw= ColonColon this_ID_2= RULE_ID )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==ColonColon) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalExprParser.g:3903:2: kw= ColonColon this_ID_2= RULE_ID
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
    // InternalExprParser.g:3923:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // InternalExprParser.g:3924:1: (iv_ruleQCREF= ruleQCREF EOF )
            // InternalExprParser.g:3925:2: iv_ruleQCREF= ruleQCREF EOF
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
    // InternalExprParser.g:3932:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // InternalExprParser.g:3936:6: ( ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) )
            // InternalExprParser.g:3937:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            {
            // InternalExprParser.g:3937:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            // InternalExprParser.g:3937:2: (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )?
            {
            // InternalExprParser.g:3937:2: (this_ID_0= RULE_ID kw= ColonColon )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_ID) ) {
                    int LA48_1 = input.LA(2);

                    if ( (LA48_1==ColonColon) ) {
                        alt48=1;
                    }


                }


                switch (alt48) {
            	case 1 :
            	    // InternalExprParser.g:3937:7: this_ID_0= RULE_ID kw= ColonColon
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_44); if (state.failed) return current;
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
            	    break loop48;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); 
                  
            }
            // InternalExprParser.g:3957:1: (kw= FullStop this_ID_4= RULE_ID )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==FullStop) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalExprParser.g:3958:2: kw= FullStop this_ID_4= RULE_ID
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


    // $ANTLR start "ruleMetaClassEnum"
    // InternalExprParser.g:3980:1: ruleMetaClassEnum returns [Enumerator current=null] : ( (enumLiteral_0= Component ) | (enumLiteral_1= Subcomponent ) | (enumLiteral_2= Feature ) | (enumLiteral_3= Connection ) | (enumLiteral_4= Flow ) | (enumLiteral_5= Mode ) ) ;
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
            // InternalExprParser.g:3982:28: ( ( (enumLiteral_0= Component ) | (enumLiteral_1= Subcomponent ) | (enumLiteral_2= Feature ) | (enumLiteral_3= Connection ) | (enumLiteral_4= Flow ) | (enumLiteral_5= Mode ) ) )
            // InternalExprParser.g:3983:1: ( (enumLiteral_0= Component ) | (enumLiteral_1= Subcomponent ) | (enumLiteral_2= Feature ) | (enumLiteral_3= Connection ) | (enumLiteral_4= Flow ) | (enumLiteral_5= Mode ) )
            {
            // InternalExprParser.g:3983:1: ( (enumLiteral_0= Component ) | (enumLiteral_1= Subcomponent ) | (enumLiteral_2= Feature ) | (enumLiteral_3= Connection ) | (enumLiteral_4= Flow ) | (enumLiteral_5= Mode ) )
            int alt50=6;
            switch ( input.LA(1) ) {
            case Component:
                {
                alt50=1;
                }
                break;
            case Subcomponent:
                {
                alt50=2;
                }
                break;
            case Feature:
                {
                alt50=3;
                }
                break;
            case Connection:
                {
                alt50=4;
                }
                break;
            case Flow:
                {
                alt50=5;
                }
                break;
            case Mode:
                {
                alt50=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // InternalExprParser.g:3983:2: (enumLiteral_0= Component )
                    {
                    // InternalExprParser.g:3983:2: (enumLiteral_0= Component )
                    // InternalExprParser.g:3983:7: enumLiteral_0= Component
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
                    // InternalExprParser.g:3989:6: (enumLiteral_1= Subcomponent )
                    {
                    // InternalExprParser.g:3989:6: (enumLiteral_1= Subcomponent )
                    // InternalExprParser.g:3989:11: enumLiteral_1= Subcomponent
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
                    // InternalExprParser.g:3995:6: (enumLiteral_2= Feature )
                    {
                    // InternalExprParser.g:3995:6: (enumLiteral_2= Feature )
                    // InternalExprParser.g:3995:11: enumLiteral_2= Feature
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
                    // InternalExprParser.g:4001:6: (enumLiteral_3= Connection )
                    {
                    // InternalExprParser.g:4001:6: (enumLiteral_3= Connection )
                    // InternalExprParser.g:4001:11: enumLiteral_3= Connection
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
                    // InternalExprParser.g:4007:6: (enumLiteral_4= Flow )
                    {
                    // InternalExprParser.g:4007:6: (enumLiteral_4= Flow )
                    // InternalExprParser.g:4007:11: enumLiteral_4= Flow
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
                    // InternalExprParser.g:4013:6: (enumLiteral_5= Mode )
                    {
                    // InternalExprParser.g:4013:6: (enumLiteral_5= Mode )
                    // InternalExprParser.g:4013:11: enumLiteral_5= Mode
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
        // InternalExprParser.g:1640:3: ( ( () ( ( ruleOpOr ) ) ) )
        // InternalExprParser.g:1640:4: ( () ( ( ruleOpOr ) ) )
        {
        // InternalExprParser.g:1640:4: ( () ( ( ruleOpOr ) ) )
        // InternalExprParser.g:1640:5: () ( ( ruleOpOr ) )
        {
        // InternalExprParser.g:1640:5: ()
        // InternalExprParser.g:1641:1: 
        {
        }

        // InternalExprParser.g:1641:2: ( ( ruleOpOr ) )
        // InternalExprParser.g:1642:1: ( ruleOpOr )
        {
        // InternalExprParser.g:1642:1: ( ruleOpOr )
        // InternalExprParser.g:1643:1: ruleOpOr
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
        // InternalExprParser.g:1752:3: ( ( () ( ( ruleOpAnd ) ) ) )
        // InternalExprParser.g:1752:4: ( () ( ( ruleOpAnd ) ) )
        {
        // InternalExprParser.g:1752:4: ( () ( ( ruleOpAnd ) ) )
        // InternalExprParser.g:1752:5: () ( ( ruleOpAnd ) )
        {
        // InternalExprParser.g:1752:5: ()
        // InternalExprParser.g:1753:1: 
        {
        }

        // InternalExprParser.g:1753:2: ( ( ruleOpAnd ) )
        // InternalExprParser.g:1754:1: ( ruleOpAnd )
        {
        // InternalExprParser.g:1754:1: ( ruleOpAnd )
        // InternalExprParser.g:1755:1: ruleOpAnd
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
        // InternalExprParser.g:1864:3: ( ( () ( ( ruleOpEquality ) ) ) )
        // InternalExprParser.g:1864:4: ( () ( ( ruleOpEquality ) ) )
        {
        // InternalExprParser.g:1864:4: ( () ( ( ruleOpEquality ) ) )
        // InternalExprParser.g:1864:5: () ( ( ruleOpEquality ) )
        {
        // InternalExprParser.g:1864:5: ()
        // InternalExprParser.g:1865:1: 
        {
        }

        // InternalExprParser.g:1865:2: ( ( ruleOpEquality ) )
        // InternalExprParser.g:1866:1: ( ruleOpEquality )
        {
        // InternalExprParser.g:1866:1: ( ruleOpEquality )
        // InternalExprParser.g:1867:1: ruleOpEquality
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
        // InternalExprParser.g:1976:3: ( ( () ( ( ruleOpCompare ) ) ) )
        // InternalExprParser.g:1976:4: ( () ( ( ruleOpCompare ) ) )
        {
        // InternalExprParser.g:1976:4: ( () ( ( ruleOpCompare ) ) )
        // InternalExprParser.g:1976:5: () ( ( ruleOpCompare ) )
        {
        // InternalExprParser.g:1976:5: ()
        // InternalExprParser.g:1977:1: 
        {
        }

        // InternalExprParser.g:1977:2: ( ( ruleOpCompare ) )
        // InternalExprParser.g:1978:1: ( ruleOpCompare )
        {
        // InternalExprParser.g:1978:1: ( ruleOpCompare )
        // InternalExprParser.g:1979:1: ruleOpCompare
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
        // InternalExprParser.g:2109:3: ( ( () ( ( ruleOpAdd ) ) ) )
        // InternalExprParser.g:2109:4: ( () ( ( ruleOpAdd ) ) )
        {
        // InternalExprParser.g:2109:4: ( () ( ( ruleOpAdd ) ) )
        // InternalExprParser.g:2109:5: () ( ( ruleOpAdd ) )
        {
        // InternalExprParser.g:2109:5: ()
        // InternalExprParser.g:2110:1: 
        {
        }

        // InternalExprParser.g:2110:2: ( ( ruleOpAdd ) )
        // InternalExprParser.g:2111:1: ( ruleOpAdd )
        {
        // InternalExprParser.g:2111:1: ( ruleOpAdd )
        // InternalExprParser.g:2112:1: ruleOpAdd
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
        // InternalExprParser.g:2221:3: ( ( () ( ( ruleOpMulti ) ) ) )
        // InternalExprParser.g:2221:4: ( () ( ( ruleOpMulti ) ) )
        {
        // InternalExprParser.g:2221:4: ( () ( ( ruleOpMulti ) ) )
        // InternalExprParser.g:2221:5: () ( ( ruleOpMulti ) )
        {
        // InternalExprParser.g:2221:5: ()
        // InternalExprParser.g:2222:1: 
        {
        }

        // InternalExprParser.g:2222:2: ( ( ruleOpMulti ) )
        // InternalExprParser.g:2223:1: ( ruleOpMulti )
        {
        // InternalExprParser.g:2223:1: ( ruleOpMulti )
        // InternalExprParser.g:2224:1: ruleOpMulti
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
        // InternalExprParser.g:2685:3: ( ( () NumberSign ) )
        // InternalExprParser.g:2685:4: ( () NumberSign )
        {
        // InternalExprParser.g:2685:4: ( () NumberSign )
        // InternalExprParser.g:2685:5: () NumberSign
        {
        // InternalExprParser.g:2685:5: ()
        // InternalExprParser.g:2686:1: 
        {
        }

        match(input,NumberSign,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_InternalExprParser

    // $ANTLR start synpred9_InternalExprParser
    public final void synpred9_InternalExprParser_fragment() throws RecognitionException {   
        // InternalExprParser.g:3031:4: ( Delta )
        // InternalExprParser.g:3032:1: Delta
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
    static final String dfa_1s = "\22\uffff";
    static final String dfa_2s = "\10\uffff\1\14\1\uffff\1\17\7\uffff";
    static final String dfa_3s = "\1\7\7\uffff\1\4\1\uffff\1\4\1\11\6\uffff";
    static final String dfa_4s = "\1\54\7\uffff\1\140\1\uffff\1\140\1\54\6\uffff";
    static final String dfa_5s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\2\uffff\1\10\1\11\1\13\1\14\1\15\1\16";
    static final String dfa_6s = "\22\uffff}>";
    static final String[] dfa_7s = {
            "\1\10\1\uffff\1\7\1\uffff\1\1\3\uffff\1\6\1\13\1\4\1\5\2\uffff\1\11\1\12\7\uffff\1\3\15\uffff\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\6\14\1\uffff\1\14\1\uffff\1\14\1\uffff\10\14\3\uffff\1\15\4\14\1\uffff\4\14\7\uffff\2\14\2\uffff\2\14\2\uffff\1\14\4\uffff\1\14\26\uffff\1\14\1\uffff\1\14\4\uffff\1\14\11\uffff\1\14",
            "",
            "\6\17\1\uffff\1\17\1\uffff\1\17\1\uffff\10\17\3\uffff\1\16\4\17\1\uffff\4\17\7\uffff\2\17\2\uffff\2\17\2\uffff\1\17\4\uffff\1\17\26\uffff\1\17\1\uffff\1\17\4\uffff\1\17\11\uffff\1\17",
            "\1\21\42\uffff\1\20",
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
            return "826:1: (kw= Abstract | kw= Bus | kw= Data | kw= Device | kw= Memory | kw= Process | kw= Processor | kw= Subprogram | (kw= Subprogram kw= Group ) | kw= KW_System | (kw= Thread kw= Group ) | kw= Thread | (kw= Virtual kw= Bus ) | (kw= Virtual kw= Processor ) )";
        }
    }
    static final String dfa_8s = "\14\uffff";
    static final String dfa_9s = "\1\uffff\1\10\11\uffff\1\10";
    static final String dfa_10s = "\1\23\1\27\5\uffff\1\140\1\uffff\1\140\1\uffff\1\27";
    static final String dfa_11s = "\2\140\5\uffff\1\140\1\uffff\1\140\1\uffff\1\140";
    static final String dfa_12s = "\2\uffff\1\2\1\4\1\5\1\6\1\7\1\uffff\1\1\1\uffff\1\3\1\uffff";
    static final String dfa_13s = "\14\uffff}>";
    static final String[] dfa_14s = {
            "\1\5\5\uffff\1\5\1\uffff\2\5\4\uffff\1\5\4\uffff\1\2\1\5\3\uffff\1\5\4\uffff\1\5\2\uffff\1\5\13\uffff\1\4\4\uffff\1\2\1\uffff\1\6\14\uffff\1\3\7\uffff\1\5\1\uffff\1\5\1\uffff\1\5\1\1",
            "\2\10\6\uffff\1\10\5\uffff\1\10\4\uffff\1\10\3\uffff\1\10\2\uffff\1\10\4\uffff\2\10\1\uffff\1\10\1\11\4\10\1\uffff\1\10\1\uffff\2\10\1\uffff\1\10\1\12\5\10\1\7\1\10\1\uffff\2\10\1\uffff\1\10\1\uffff\1\10\13\uffff\1\10",
            "",
            "",
            "",
            "",
            "",
            "\1\13",
            "",
            "\1\1",
            "",
            "\2\10\6\uffff\1\10\5\uffff\1\10\4\uffff\1\10\3\uffff\1\10\2\uffff\1\10\4\uffff\2\10\1\uffff\1\10\1\uffff\4\10\1\uffff\1\10\1\uffff\2\10\1\uffff\1\10\1\12\5\10\1\uffff\1\10\1\uffff\2\10\1\uffff\1\10\1\uffff\1\10\13\uffff\1\10"
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
            return "2539:1: (this_VarRef_0= ruleVarRef | this_ModelOrPropertyReference_1= ruleModelOrPropertyReference | this_FunctionCall_2= ruleFunctionCall | this_RangeExpression_3= ruleRangeExpression | this_IfExpression_4= ruleIfExpression | this_Literal_5= ruleLiteral | (otherlv_6= LeftParenthesis this_Expression_7= ruleExpression otherlv_8= RightParenthesis ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0030210000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0009980F787FABF0L,0x0000000100000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000002L,0x0000000000024000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x800D98CF7A7FABF0L,0x00000001A8080A50L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000000100400000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0009980F787FABF0L,0x0000000100400000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0080040000000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x1040000000000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x6800000000000002L,0x0000000000050000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000A00L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0002400000000002L,0x0000000000002100L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000021L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x800D98CF7A7FABF0L,0x00000001A8080AD0L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000480L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000800000L,0x0000000000100000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000081000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0400000000000000L});

}