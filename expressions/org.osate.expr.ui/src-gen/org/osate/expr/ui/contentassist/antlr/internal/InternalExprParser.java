package org.osate.expr.ui.contentassist.antlr.internal; 

import java.util.Map;
import java.util.HashMap;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.osate.expr.services.ExprGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalExprParser extends AbstractInternalContentAssistParser {
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
     	
     	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
     	
     	{
    		tokenNameToValue.put("NumberSign", "'#'");
    		tokenNameToValue.put("PercentSign", "'%'");
    		tokenNameToValue.put("LeftParenthesis", "'('");
    		tokenNameToValue.put("RightParenthesis", "')'");
    		tokenNameToValue.put("Asterisk", "'*'");
    		tokenNameToValue.put("PlusSign", "'+'");
    		tokenNameToValue.put("Comma", "','");
    		tokenNameToValue.put("HyphenMinus", "'-'");
    		tokenNameToValue.put("FullStop", "'.'");
    		tokenNameToValue.put("Solidus", "'/'");
    		tokenNameToValue.put("Colon", "':'");
    		tokenNameToValue.put("Semicolon", "';'");
    		tokenNameToValue.put("LessThanSign", "'<'");
    		tokenNameToValue.put("EqualsSign", "'='");
    		tokenNameToValue.put("GreaterThanSign", "'>'");
    		tokenNameToValue.put("LeftSquareBracket", "'['");
    		tokenNameToValue.put("RightSquareBracket", "']'");
    		tokenNameToValue.put("LeftCurlyBracket", "'{'");
    		tokenNameToValue.put("RightCurlyBracket", "'}'");
    		tokenNameToValue.put("ExclamationMarkEqualsSign", "'!='");
    		tokenNameToValue.put("AmpersandAmpersand", "'&&'");
    		tokenNameToValue.put("HyphenMinusGreaterThanSign", "'->'");
    		tokenNameToValue.put("FullStopFullStop", "'..'");
    		tokenNameToValue.put("ColonColon", "'::'");
    		tokenNameToValue.put("LessThanSignEqualsSign", "'<='");
    		tokenNameToValue.put("EqualsSignEqualsSign", "'=='");
    		tokenNameToValue.put("GreaterThanSignLessThanSign", "'><'");
    		tokenNameToValue.put("GreaterThanSignEqualsSign", "'>='");
    		tokenNameToValue.put("If", "'if'");
    		tokenNameToValue.put("In", "'in'");
    		tokenNameToValue.put("Of", "'of'");
    		tokenNameToValue.put("Or", "'or'");
    		tokenNameToValue.put("VerticalLineVerticalLine", "'||'");
    		tokenNameToValue.put("QuestionMarkQuestionMarkQuestionMark", "'???'");
    		tokenNameToValue.put("And", "'and'");
    		tokenNameToValue.put("Bag", "'bag'");
    		tokenNameToValue.put("Bus", "'bus'");
    		tokenNameToValue.put("Def", "'def'");
    		tokenNameToValue.put("Div", "'div'");
    		tokenNameToValue.put("Int", "'int'");
    		tokenNameToValue.put("Map", "'map'");
    		tokenNameToValue.put("Mod", "'mod'");
    		tokenNameToValue.put("Not", "'not'");
    		tokenNameToValue.put("Set", "'set'");
    		tokenNameToValue.put("Val", "'val'");
    		tokenNameToValue.put("Var", "'var'");
    		tokenNameToValue.put("Bool", "'bool'");
    		tokenNameToValue.put("Data", "'data'");
    		tokenNameToValue.put("Else", "'else'");
    		tokenNameToValue.put("Flow", "'flow'");
    		tokenNameToValue.put("List", "'list'");
    		tokenNameToValue.put("Mode", "'mode'");
    		tokenNameToValue.put("Real", "'real'");
    		tokenNameToValue.put("Then", "'then'");
    		tokenNameToValue.put("This", "'this'");
    		tokenNameToValue.put("True", "'true'");
    		tokenNameToValue.put("Type", "'type'");
    		tokenNameToValue.put("Delta", "'delta'");
    		tokenNameToValue.put("Endif", "'endif'");
    		tokenNameToValue.put("False", "'false'");
    		tokenNameToValue.put("Group", "'group'");
    		tokenNameToValue.put("Tuple", "'tuple'");
    		tokenNameToValue.put("Union", "'union'");
    		tokenNameToValue.put("Device", "'device'");
    		tokenNameToValue.put("Memory", "'memory'");
    		tokenNameToValue.put("Record", "'record'");
    		tokenNameToValue.put("String", "'string'");
    		tokenNameToValue.put("KW_System", "'system'");
    		tokenNameToValue.put("Thread", "'thread'");
    		tokenNameToValue.put("Feature", "'feature'");
    		tokenNameToValue.put("Library", "'library'");
    		tokenNameToValue.put("Process", "'process'");
    		tokenNameToValue.put("Virtual", "'virtual'");
    		tokenNameToValue.put("Abstract", "'abstract'");
    		tokenNameToValue.put("Component", "'component'");
    		tokenNameToValue.put("Processor", "'processor'");
    		tokenNameToValue.put("Subclause", "'subclause'");
    		tokenNameToValue.put("Classifier", "'classifier'");
    		tokenNameToValue.put("Connection", "'connection'");
    		tokenNameToValue.put("Subprogram", "'subprogram'");
    		tokenNameToValue.put("Subcomponent", "'subcomponent'");
     	}
     	
        public void setGrammarAccess(ExprGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }

    	@Override
        protected String getValueForTokenName(String tokenName) {
        	String result = tokenNameToValue.get(tokenName);
        	if (result == null)
        		result = tokenName;
        	return result;
        }



    // $ANTLR start "entryRuleExprModel"
    // InternalExprParser.g:145:1: entryRuleExprModel : ruleExprModel EOF ;
    public final void entryRuleExprModel() throws RecognitionException {
        try {
            // InternalExprParser.g:146:1: ( ruleExprModel EOF )
            // InternalExprParser.g:147:1: ruleExprModel EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprModelRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleExprModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprModelRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExprModel"


    // $ANTLR start "ruleExprModel"
    // InternalExprParser.g:154:1: ruleExprModel : ( ( rule__ExprModel__Alternatives ) ) ;
    public final void ruleExprModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:158:5: ( ( ( rule__ExprModel__Alternatives ) ) )
            // InternalExprParser.g:159:1: ( ( rule__ExprModel__Alternatives ) )
            {
            // InternalExprParser.g:159:1: ( ( rule__ExprModel__Alternatives ) )
            // InternalExprParser.g:160:1: ( rule__ExprModel__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprModelAccess().getAlternatives()); 
            }
            // InternalExprParser.g:161:1: ( rule__ExprModel__Alternatives )
            // InternalExprParser.g:161:2: rule__ExprModel__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ExprModel__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprModelAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExprModel"


    // $ANTLR start "ruleDeclarations"
    // InternalExprParser.g:174:1: ruleDeclarations : ( ( rule__Declarations__Group__0 ) ) ;
    public final void ruleDeclarations() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:178:5: ( ( ( rule__Declarations__Group__0 ) ) )
            // InternalExprParser.g:179:1: ( ( rule__Declarations__Group__0 ) )
            {
            // InternalExprParser.g:179:1: ( ( rule__Declarations__Group__0 ) )
            // InternalExprParser.g:180:1: ( rule__Declarations__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclarationsAccess().getGroup()); 
            }
            // InternalExprParser.g:181:1: ( rule__Declarations__Group__0 )
            // InternalExprParser.g:181:2: rule__Declarations__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Declarations__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclarationsAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDeclarations"


    // $ANTLR start "entryRuleExprLibrary"
    // InternalExprParser.g:193:1: entryRuleExprLibrary : ruleExprLibrary EOF ;
    public final void entryRuleExprLibrary() throws RecognitionException {
        try {
            // InternalExprParser.g:194:1: ( ruleExprLibrary EOF )
            // InternalExprParser.g:195:1: ruleExprLibrary EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprLibraryRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleExprLibrary();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprLibraryRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExprLibrary"


    // $ANTLR start "ruleExprLibrary"
    // InternalExprParser.g:202:1: ruleExprLibrary : ( ( rule__ExprLibrary__Group__0 ) ) ;
    public final void ruleExprLibrary() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:206:5: ( ( ( rule__ExprLibrary__Group__0 ) ) )
            // InternalExprParser.g:207:1: ( ( rule__ExprLibrary__Group__0 ) )
            {
            // InternalExprParser.g:207:1: ( ( rule__ExprLibrary__Group__0 ) )
            // InternalExprParser.g:208:1: ( rule__ExprLibrary__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprLibraryAccess().getGroup()); 
            }
            // InternalExprParser.g:209:1: ( rule__ExprLibrary__Group__0 )
            // InternalExprParser.g:209:2: rule__ExprLibrary__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ExprLibrary__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprLibraryAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExprLibrary"


    // $ANTLR start "entryRuleExprSubclause"
    // InternalExprParser.g:221:1: entryRuleExprSubclause : ruleExprSubclause EOF ;
    public final void entryRuleExprSubclause() throws RecognitionException {
        try {
            // InternalExprParser.g:222:1: ( ruleExprSubclause EOF )
            // InternalExprParser.g:223:1: ruleExprSubclause EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprSubclauseRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleExprSubclause();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprSubclauseRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExprSubclause"


    // $ANTLR start "ruleExprSubclause"
    // InternalExprParser.g:230:1: ruleExprSubclause : ( ( rule__ExprSubclause__Group__0 ) ) ;
    public final void ruleExprSubclause() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:234:5: ( ( ( rule__ExprSubclause__Group__0 ) ) )
            // InternalExprParser.g:235:1: ( ( rule__ExprSubclause__Group__0 ) )
            {
            // InternalExprParser.g:235:1: ( ( rule__ExprSubclause__Group__0 ) )
            // InternalExprParser.g:236:1: ( rule__ExprSubclause__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprSubclauseAccess().getGroup()); 
            }
            // InternalExprParser.g:237:1: ( rule__ExprSubclause__Group__0 )
            // InternalExprParser.g:237:2: rule__ExprSubclause__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ExprSubclause__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprSubclauseAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExprSubclause"


    // $ANTLR start "entryRuleDeclaration"
    // InternalExprParser.g:251:1: entryRuleDeclaration : ruleDeclaration EOF ;
    public final void entryRuleDeclaration() throws RecognitionException {
        try {
            // InternalExprParser.g:252:1: ( ruleDeclaration EOF )
            // InternalExprParser.g:253:1: ruleDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleDeclaration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclarationRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDeclaration"


    // $ANTLR start "ruleDeclaration"
    // InternalExprParser.g:260:1: ruleDeclaration : ( ( rule__Declaration__Alternatives ) ) ;
    public final void ruleDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:264:5: ( ( ( rule__Declaration__Alternatives ) ) )
            // InternalExprParser.g:265:1: ( ( rule__Declaration__Alternatives ) )
            {
            // InternalExprParser.g:265:1: ( ( rule__Declaration__Alternatives ) )
            // InternalExprParser.g:266:1: ( rule__Declaration__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclarationAccess().getAlternatives()); 
            }
            // InternalExprParser.g:267:1: ( rule__Declaration__Alternatives )
            // InternalExprParser.g:267:2: rule__Declaration__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Declaration__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclarationAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "entryRuleTypeDecl"
    // InternalExprParser.g:279:1: entryRuleTypeDecl : ruleTypeDecl EOF ;
    public final void entryRuleTypeDecl() throws RecognitionException {
        try {
            // InternalExprParser.g:280:1: ( ruleTypeDecl EOF )
            // InternalExprParser.g:281:1: ruleTypeDecl EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDeclRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTypeDecl();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDeclRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTypeDecl"


    // $ANTLR start "ruleTypeDecl"
    // InternalExprParser.g:288:1: ruleTypeDecl : ( ( rule__TypeDecl__Group__0 ) ) ;
    public final void ruleTypeDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:292:5: ( ( ( rule__TypeDecl__Group__0 ) ) )
            // InternalExprParser.g:293:1: ( ( rule__TypeDecl__Group__0 ) )
            {
            // InternalExprParser.g:293:1: ( ( rule__TypeDecl__Group__0 ) )
            // InternalExprParser.g:294:1: ( rule__TypeDecl__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDeclAccess().getGroup()); 
            }
            // InternalExprParser.g:295:1: ( rule__TypeDecl__Group__0 )
            // InternalExprParser.g:295:2: rule__TypeDecl__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TypeDecl__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDeclAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypeDecl"


    // $ANTLR start "entryRuleVarDecl"
    // InternalExprParser.g:307:1: entryRuleVarDecl : ruleVarDecl EOF ;
    public final void entryRuleVarDecl() throws RecognitionException {
        try {
            // InternalExprParser.g:308:1: ( ruleVarDecl EOF )
            // InternalExprParser.g:309:1: ruleVarDecl EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleVarDecl();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVarDecl"


    // $ANTLR start "ruleVarDecl"
    // InternalExprParser.g:316:1: ruleVarDecl : ( ( rule__VarDecl__Group__0 ) ) ;
    public final void ruleVarDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:320:5: ( ( ( rule__VarDecl__Group__0 ) ) )
            // InternalExprParser.g:321:1: ( ( rule__VarDecl__Group__0 ) )
            {
            // InternalExprParser.g:321:1: ( ( rule__VarDecl__Group__0 ) )
            // InternalExprParser.g:322:1: ( rule__VarDecl__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getGroup()); 
            }
            // InternalExprParser.g:323:1: ( rule__VarDecl__Group__0 )
            // InternalExprParser.g:323:2: rule__VarDecl__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__VarDecl__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVarDecl"


    // $ANTLR start "entryRuleFunDecl"
    // InternalExprParser.g:335:1: entryRuleFunDecl : ruleFunDecl EOF ;
    public final void entryRuleFunDecl() throws RecognitionException {
        try {
            // InternalExprParser.g:336:1: ( ruleFunDecl EOF )
            // InternalExprParser.g:337:1: ruleFunDecl EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunDeclRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleFunDecl();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunDeclRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFunDecl"


    // $ANTLR start "ruleFunDecl"
    // InternalExprParser.g:344:1: ruleFunDecl : ( ( rule__FunDecl__Group__0 ) ) ;
    public final void ruleFunDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:348:5: ( ( ( rule__FunDecl__Group__0 ) ) )
            // InternalExprParser.g:349:1: ( ( rule__FunDecl__Group__0 ) )
            {
            // InternalExprParser.g:349:1: ( ( rule__FunDecl__Group__0 ) )
            // InternalExprParser.g:350:1: ( rule__FunDecl__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunDeclAccess().getGroup()); 
            }
            // InternalExprParser.g:351:1: ( rule__FunDecl__Group__0 )
            // InternalExprParser.g:351:2: rule__FunDecl__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FunDecl__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunDeclAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFunDecl"


    // $ANTLR start "entryRuleType"
    // InternalExprParser.g:363:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // InternalExprParser.g:364:1: ( ruleType EOF )
            // InternalExprParser.g:365:1: ruleType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalExprParser.g:372:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:376:5: ( ( ( rule__Type__Alternatives ) ) )
            // InternalExprParser.g:377:1: ( ( rule__Type__Alternatives ) )
            {
            // InternalExprParser.g:377:1: ( ( rule__Type__Alternatives ) )
            // InternalExprParser.g:378:1: ( rule__Type__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAccess().getAlternatives()); 
            }
            // InternalExprParser.g:379:1: ( rule__Type__Alternatives )
            // InternalExprParser.g:379:2: rule__Type__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Type__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRulePrimitiveType"
    // InternalExprParser.g:391:1: entryRulePrimitiveType : rulePrimitiveType EOF ;
    public final void entryRulePrimitiveType() throws RecognitionException {
        try {
            // InternalExprParser.g:392:1: ( rulePrimitiveType EOF )
            // InternalExprParser.g:393:1: rulePrimitiveType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePrimitiveType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimitiveTypeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimitiveType"


    // $ANTLR start "rulePrimitiveType"
    // InternalExprParser.g:400:1: rulePrimitiveType : ( ( rule__PrimitiveType__Alternatives ) ) ;
    public final void rulePrimitiveType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:404:5: ( ( ( rule__PrimitiveType__Alternatives ) ) )
            // InternalExprParser.g:405:1: ( ( rule__PrimitiveType__Alternatives ) )
            {
            // InternalExprParser.g:405:1: ( ( rule__PrimitiveType__Alternatives ) )
            // InternalExprParser.g:406:1: ( rule__PrimitiveType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveTypeAccess().getAlternatives()); 
            }
            // InternalExprParser.g:407:1: ( rule__PrimitiveType__Alternatives )
            // InternalExprParser.g:407:2: rule__PrimitiveType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimitiveTypeAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimitiveType"


    // $ANTLR start "entryRuleCategory"
    // InternalExprParser.g:419:1: entryRuleCategory : ruleCategory EOF ;
    public final void entryRuleCategory() throws RecognitionException {
        try {
            // InternalExprParser.g:420:1: ( ruleCategory EOF )
            // InternalExprParser.g:421:1: ruleCategory EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCategoryRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleCategory();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCategoryRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCategory"


    // $ANTLR start "ruleCategory"
    // InternalExprParser.g:428:1: ruleCategory : ( ( rule__Category__CategoryAssignment ) ) ;
    public final void ruleCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:432:5: ( ( ( rule__Category__CategoryAssignment ) ) )
            // InternalExprParser.g:433:1: ( ( rule__Category__CategoryAssignment ) )
            {
            // InternalExprParser.g:433:1: ( ( rule__Category__CategoryAssignment ) )
            // InternalExprParser.g:434:1: ( rule__Category__CategoryAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCategoryAccess().getCategoryAssignment()); 
            }
            // InternalExprParser.g:435:1: ( rule__Category__CategoryAssignment )
            // InternalExprParser.g:435:2: rule__Category__CategoryAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Category__CategoryAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCategoryAccess().getCategoryAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCategory"


    // $ANTLR start "entryRuleComponentCategory"
    // InternalExprParser.g:447:1: entryRuleComponentCategory : ruleComponentCategory EOF ;
    public final void entryRuleComponentCategory() throws RecognitionException {
        try {
            // InternalExprParser.g:448:1: ( ruleComponentCategory EOF )
            // InternalExprParser.g:449:1: ruleComponentCategory EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComponentCategoryRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleComponentCategory();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComponentCategoryRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleComponentCategory"


    // $ANTLR start "ruleComponentCategory"
    // InternalExprParser.g:456:1: ruleComponentCategory : ( ( rule__ComponentCategory__Alternatives ) ) ;
    public final void ruleComponentCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:460:5: ( ( ( rule__ComponentCategory__Alternatives ) ) )
            // InternalExprParser.g:461:1: ( ( rule__ComponentCategory__Alternatives ) )
            {
            // InternalExprParser.g:461:1: ( ( rule__ComponentCategory__Alternatives ) )
            // InternalExprParser.g:462:1: ( rule__ComponentCategory__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComponentCategoryAccess().getAlternatives()); 
            }
            // InternalExprParser.g:463:1: ( rule__ComponentCategory__Alternatives )
            // InternalExprParser.g:463:2: rule__ComponentCategory__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ComponentCategory__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComponentCategoryAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComponentCategory"


    // $ANTLR start "entryRuleMetaClass"
    // InternalExprParser.g:475:1: entryRuleMetaClass : ruleMetaClass EOF ;
    public final void entryRuleMetaClass() throws RecognitionException {
        try {
            // InternalExprParser.g:476:1: ( ruleMetaClass EOF )
            // InternalExprParser.g:477:1: ruleMetaClass EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetaClassRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleMetaClass();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetaClassRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMetaClass"


    // $ANTLR start "ruleMetaClass"
    // InternalExprParser.g:484:1: ruleMetaClass : ( ( rule__MetaClass__ClassAssignment ) ) ;
    public final void ruleMetaClass() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:488:5: ( ( ( rule__MetaClass__ClassAssignment ) ) )
            // InternalExprParser.g:489:1: ( ( rule__MetaClass__ClassAssignment ) )
            {
            // InternalExprParser.g:489:1: ( ( rule__MetaClass__ClassAssignment ) )
            // InternalExprParser.g:490:1: ( rule__MetaClass__ClassAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetaClassAccess().getClassAssignment()); 
            }
            // InternalExprParser.g:491:1: ( rule__MetaClass__ClassAssignment )
            // InternalExprParser.g:491:2: rule__MetaClass__ClassAssignment
            {
            pushFollow(FOLLOW_2);
            rule__MetaClass__ClassAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetaClassAccess().getClassAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMetaClass"


    // $ANTLR start "entryRuleClassifierType"
    // InternalExprParser.g:503:1: entryRuleClassifierType : ruleClassifierType EOF ;
    public final void entryRuleClassifierType() throws RecognitionException {
        try {
            // InternalExprParser.g:504:1: ( ruleClassifierType EOF )
            // InternalExprParser.g:505:1: ruleClassifierType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleClassifierType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassifierTypeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleClassifierType"


    // $ANTLR start "ruleClassifierType"
    // InternalExprParser.g:512:1: ruleClassifierType : ( ( rule__ClassifierType__Group__0 ) ) ;
    public final void ruleClassifierType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:516:5: ( ( ( rule__ClassifierType__Group__0 ) ) )
            // InternalExprParser.g:517:1: ( ( rule__ClassifierType__Group__0 ) )
            {
            // InternalExprParser.g:517:1: ( ( rule__ClassifierType__Group__0 ) )
            // InternalExprParser.g:518:1: ( rule__ClassifierType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeAccess().getGroup()); 
            }
            // InternalExprParser.g:519:1: ( rule__ClassifierType__Group__0 )
            // InternalExprParser.g:519:2: rule__ClassifierType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ClassifierType__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassifierTypeAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClassifierType"


    // $ANTLR start "entryRuleRecordType"
    // InternalExprParser.g:531:1: entryRuleRecordType : ruleRecordType EOF ;
    public final void entryRuleRecordType() throws RecognitionException {
        try {
            // InternalExprParser.g:532:1: ( ruleRecordType EOF )
            // InternalExprParser.g:533:1: ruleRecordType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecordTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRecordType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecordTypeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRecordType"


    // $ANTLR start "ruleRecordType"
    // InternalExprParser.g:540:1: ruleRecordType : ( ( rule__RecordType__Group__0 ) ) ;
    public final void ruleRecordType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:544:5: ( ( ( rule__RecordType__Group__0 ) ) )
            // InternalExprParser.g:545:1: ( ( rule__RecordType__Group__0 ) )
            {
            // InternalExprParser.g:545:1: ( ( rule__RecordType__Group__0 ) )
            // InternalExprParser.g:546:1: ( rule__RecordType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecordTypeAccess().getGroup()); 
            }
            // InternalExprParser.g:547:1: ( rule__RecordType__Group__0 )
            // InternalExprParser.g:547:2: rule__RecordType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RecordType__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecordTypeAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRecordType"


    // $ANTLR start "entryRuleField"
    // InternalExprParser.g:559:1: entryRuleField : ruleField EOF ;
    public final void entryRuleField() throws RecognitionException {
        try {
            // InternalExprParser.g:560:1: ( ruleField EOF )
            // InternalExprParser.g:561:1: ruleField EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleField();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleField"


    // $ANTLR start "ruleField"
    // InternalExprParser.g:568:1: ruleField : ( ( rule__Field__Group__0 ) ) ;
    public final void ruleField() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:572:5: ( ( ( rule__Field__Group__0 ) ) )
            // InternalExprParser.g:573:1: ( ( rule__Field__Group__0 ) )
            {
            // InternalExprParser.g:573:1: ( ( rule__Field__Group__0 ) )
            // InternalExprParser.g:574:1: ( rule__Field__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getGroup()); 
            }
            // InternalExprParser.g:575:1: ( rule__Field__Group__0 )
            // InternalExprParser.g:575:2: rule__Field__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Field__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleField"


    // $ANTLR start "entryRuleUnionType"
    // InternalExprParser.g:587:1: entryRuleUnionType : ruleUnionType EOF ;
    public final void entryRuleUnionType() throws RecognitionException {
        try {
            // InternalExprParser.g:588:1: ( ruleUnionType EOF )
            // InternalExprParser.g:589:1: ruleUnionType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnionTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleUnionType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnionTypeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnionType"


    // $ANTLR start "ruleUnionType"
    // InternalExprParser.g:596:1: ruleUnionType : ( ( rule__UnionType__Group__0 ) ) ;
    public final void ruleUnionType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:600:5: ( ( ( rule__UnionType__Group__0 ) ) )
            // InternalExprParser.g:601:1: ( ( rule__UnionType__Group__0 ) )
            {
            // InternalExprParser.g:601:1: ( ( rule__UnionType__Group__0 ) )
            // InternalExprParser.g:602:1: ( rule__UnionType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnionTypeAccess().getGroup()); 
            }
            // InternalExprParser.g:603:1: ( rule__UnionType__Group__0 )
            // InternalExprParser.g:603:2: rule__UnionType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__UnionType__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnionTypeAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnionType"


    // $ANTLR start "entryRuleTupleType"
    // InternalExprParser.g:615:1: entryRuleTupleType : ruleTupleType EOF ;
    public final void entryRuleTupleType() throws RecognitionException {
        try {
            // InternalExprParser.g:616:1: ( ruleTupleType EOF )
            // InternalExprParser.g:617:1: ruleTupleType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTupleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTupleTypeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTupleType"


    // $ANTLR start "ruleTupleType"
    // InternalExprParser.g:624:1: ruleTupleType : ( ( rule__TupleType__Group__0 ) ) ;
    public final void ruleTupleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:628:5: ( ( ( rule__TupleType__Group__0 ) ) )
            // InternalExprParser.g:629:1: ( ( rule__TupleType__Group__0 ) )
            {
            // InternalExprParser.g:629:1: ( ( rule__TupleType__Group__0 ) )
            // InternalExprParser.g:630:1: ( rule__TupleType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleTypeAccess().getGroup()); 
            }
            // InternalExprParser.g:631:1: ( rule__TupleType__Group__0 )
            // InternalExprParser.g:631:2: rule__TupleType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TupleType__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTupleTypeAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTupleType"


    // $ANTLR start "entryRuleTupleField"
    // InternalExprParser.g:643:1: entryRuleTupleField : ruleTupleField EOF ;
    public final void entryRuleTupleField() throws RecognitionException {
        try {
            // InternalExprParser.g:644:1: ( ruleTupleField EOF )
            // InternalExprParser.g:645:1: ruleTupleField EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleFieldRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTupleField();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTupleFieldRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTupleField"


    // $ANTLR start "ruleTupleField"
    // InternalExprParser.g:652:1: ruleTupleField : ( ( rule__TupleField__Group__0 ) ) ;
    public final void ruleTupleField() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:656:5: ( ( ( rule__TupleField__Group__0 ) ) )
            // InternalExprParser.g:657:1: ( ( rule__TupleField__Group__0 ) )
            {
            // InternalExprParser.g:657:1: ( ( rule__TupleField__Group__0 ) )
            // InternalExprParser.g:658:1: ( rule__TupleField__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleFieldAccess().getGroup()); 
            }
            // InternalExprParser.g:659:1: ( rule__TupleField__Group__0 )
            // InternalExprParser.g:659:2: rule__TupleField__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TupleField__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTupleFieldAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTupleField"


    // $ANTLR start "entryRuleListType"
    // InternalExprParser.g:671:1: entryRuleListType : ruleListType EOF ;
    public final void entryRuleListType() throws RecognitionException {
        try {
            // InternalExprParser.g:672:1: ( ruleListType EOF )
            // InternalExprParser.g:673:1: ruleListType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleListType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getListTypeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleListType"


    // $ANTLR start "ruleListType"
    // InternalExprParser.g:680:1: ruleListType : ( ( rule__ListType__Group__0 ) ) ;
    public final void ruleListType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:684:5: ( ( ( rule__ListType__Group__0 ) ) )
            // InternalExprParser.g:685:1: ( ( rule__ListType__Group__0 ) )
            {
            // InternalExprParser.g:685:1: ( ( rule__ListType__Group__0 ) )
            // InternalExprParser.g:686:1: ( rule__ListType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListTypeAccess().getGroup()); 
            }
            // InternalExprParser.g:687:1: ( rule__ListType__Group__0 )
            // InternalExprParser.g:687:2: rule__ListType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ListType__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getListTypeAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleListType"


    // $ANTLR start "entryRuleSetType"
    // InternalExprParser.g:699:1: entryRuleSetType : ruleSetType EOF ;
    public final void entryRuleSetType() throws RecognitionException {
        try {
            // InternalExprParser.g:700:1: ( ruleSetType EOF )
            // InternalExprParser.g:701:1: ruleSetType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSetTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleSetType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSetTypeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSetType"


    // $ANTLR start "ruleSetType"
    // InternalExprParser.g:708:1: ruleSetType : ( ( rule__SetType__Group__0 ) ) ;
    public final void ruleSetType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:712:5: ( ( ( rule__SetType__Group__0 ) ) )
            // InternalExprParser.g:713:1: ( ( rule__SetType__Group__0 ) )
            {
            // InternalExprParser.g:713:1: ( ( rule__SetType__Group__0 ) )
            // InternalExprParser.g:714:1: ( rule__SetType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSetTypeAccess().getGroup()); 
            }
            // InternalExprParser.g:715:1: ( rule__SetType__Group__0 )
            // InternalExprParser.g:715:2: rule__SetType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SetType__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSetTypeAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSetType"


    // $ANTLR start "entryRuleBagType"
    // InternalExprParser.g:727:1: entryRuleBagType : ruleBagType EOF ;
    public final void entryRuleBagType() throws RecognitionException {
        try {
            // InternalExprParser.g:728:1: ( ruleBagType EOF )
            // InternalExprParser.g:729:1: ruleBagType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBagTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleBagType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBagTypeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBagType"


    // $ANTLR start "ruleBagType"
    // InternalExprParser.g:736:1: ruleBagType : ( ( rule__BagType__Group__0 ) ) ;
    public final void ruleBagType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:740:5: ( ( ( rule__BagType__Group__0 ) ) )
            // InternalExprParser.g:741:1: ( ( rule__BagType__Group__0 ) )
            {
            // InternalExprParser.g:741:1: ( ( rule__BagType__Group__0 ) )
            // InternalExprParser.g:742:1: ( rule__BagType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBagTypeAccess().getGroup()); 
            }
            // InternalExprParser.g:743:1: ( rule__BagType__Group__0 )
            // InternalExprParser.g:743:2: rule__BagType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BagType__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBagTypeAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBagType"


    // $ANTLR start "entryRuleMapType"
    // InternalExprParser.g:755:1: entryRuleMapType : ruleMapType EOF ;
    public final void entryRuleMapType() throws RecognitionException {
        try {
            // InternalExprParser.g:756:1: ( ruleMapType EOF )
            // InternalExprParser.g:757:1: ruleMapType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMapTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleMapType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMapTypeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMapType"


    // $ANTLR start "ruleMapType"
    // InternalExprParser.g:764:1: ruleMapType : ( ( rule__MapType__Group__0 ) ) ;
    public final void ruleMapType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:768:5: ( ( ( rule__MapType__Group__0 ) ) )
            // InternalExprParser.g:769:1: ( ( rule__MapType__Group__0 ) )
            {
            // InternalExprParser.g:769:1: ( ( rule__MapType__Group__0 ) )
            // InternalExprParser.g:770:1: ( rule__MapType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMapTypeAccess().getGroup()); 
            }
            // InternalExprParser.g:771:1: ( rule__MapType__Group__0 )
            // InternalExprParser.g:771:2: rule__MapType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MapType__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMapTypeAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMapType"


    // $ANTLR start "entryRuleTypeRef"
    // InternalExprParser.g:783:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // InternalExprParser.g:784:1: ( ruleTypeRef EOF )
            // InternalExprParser.g:785:1: ruleTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRefRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTypeRef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRefRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // InternalExprParser.g:792:1: ruleTypeRef : ( ( rule__TypeRef__RefAssignment ) ) ;
    public final void ruleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:796:5: ( ( ( rule__TypeRef__RefAssignment ) ) )
            // InternalExprParser.g:797:1: ( ( rule__TypeRef__RefAssignment ) )
            {
            // InternalExprParser.g:797:1: ( ( rule__TypeRef__RefAssignment ) )
            // InternalExprParser.g:798:1: ( rule__TypeRef__RefAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRefAccess().getRefAssignment()); 
            }
            // InternalExprParser.g:799:1: ( rule__TypeRef__RefAssignment )
            // InternalExprParser.g:799:2: rule__TypeRef__RefAssignment
            {
            pushFollow(FOLLOW_2);
            rule__TypeRef__RefAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRefAccess().getRefAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleExpression"
    // InternalExprParser.g:811:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:812:1: ( ruleExpression EOF )
            // InternalExprParser.g:813:1: ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalExprParser.g:820:1: ruleExpression : ( ruleOrExpression ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:824:5: ( ( ruleOrExpression ) )
            // InternalExprParser.g:825:1: ( ruleOrExpression )
            {
            // InternalExprParser.g:825:1: ( ruleOrExpression )
            // InternalExprParser.g:826:1: ruleOrExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getOrExpressionParserRuleCall()); 
            }
            pushFollow(FOLLOW_2);
            ruleOrExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getOrExpressionParserRuleCall()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleOrExpression"
    // InternalExprParser.g:839:1: entryRuleOrExpression : ruleOrExpression EOF ;
    public final void entryRuleOrExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:840:1: ( ruleOrExpression EOF )
            // InternalExprParser.g:841:1: ruleOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOrExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // InternalExprParser.g:848:1: ruleOrExpression : ( ( rule__OrExpression__Group__0 ) ) ;
    public final void ruleOrExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:852:5: ( ( ( rule__OrExpression__Group__0 ) ) )
            // InternalExprParser.g:853:1: ( ( rule__OrExpression__Group__0 ) )
            {
            // InternalExprParser.g:853:1: ( ( rule__OrExpression__Group__0 ) )
            // InternalExprParser.g:854:1: ( rule__OrExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionAccess().getGroup()); 
            }
            // InternalExprParser.g:855:1: ( rule__OrExpression__Group__0 )
            // InternalExprParser.g:855:2: rule__OrExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OrExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // InternalExprParser.g:867:1: entryRuleOpOr : ruleOpOr EOF ;
    public final void entryRuleOpOr() throws RecognitionException {
        try {
            // InternalExprParser.g:868:1: ( ruleOpOr EOF )
            // InternalExprParser.g:869:1: ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpOr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOrRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOpOr"


    // $ANTLR start "ruleOpOr"
    // InternalExprParser.g:876:1: ruleOpOr : ( ( rule__OpOr__Alternatives ) ) ;
    public final void ruleOpOr() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:880:5: ( ( ( rule__OpOr__Alternatives ) ) )
            // InternalExprParser.g:881:1: ( ( rule__OpOr__Alternatives ) )
            {
            // InternalExprParser.g:881:1: ( ( rule__OpOr__Alternatives ) )
            // InternalExprParser.g:882:1: ( rule__OpOr__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOrAccess().getAlternatives()); 
            }
            // InternalExprParser.g:883:1: ( rule__OpOr__Alternatives )
            // InternalExprParser.g:883:2: rule__OpOr__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OpOr__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOrAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRuleAndExpression"
    // InternalExprParser.g:895:1: entryRuleAndExpression : ruleAndExpression EOF ;
    public final void entryRuleAndExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:896:1: ( ruleAndExpression EOF )
            // InternalExprParser.g:897:1: ruleAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAndExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalExprParser.g:904:1: ruleAndExpression : ( ( rule__AndExpression__Group__0 ) ) ;
    public final void ruleAndExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:908:5: ( ( ( rule__AndExpression__Group__0 ) ) )
            // InternalExprParser.g:909:1: ( ( rule__AndExpression__Group__0 ) )
            {
            // InternalExprParser.g:909:1: ( ( rule__AndExpression__Group__0 ) )
            // InternalExprParser.g:910:1: ( rule__AndExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionAccess().getGroup()); 
            }
            // InternalExprParser.g:911:1: ( rule__AndExpression__Group__0 )
            // InternalExprParser.g:911:2: rule__AndExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AndExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // InternalExprParser.g:923:1: entryRuleOpAnd : ruleOpAnd EOF ;
    public final void entryRuleOpAnd() throws RecognitionException {
        try {
            // InternalExprParser.g:924:1: ( ruleOpAnd EOF )
            // InternalExprParser.g:925:1: ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpAnd();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpAndRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOpAnd"


    // $ANTLR start "ruleOpAnd"
    // InternalExprParser.g:932:1: ruleOpAnd : ( ( rule__OpAnd__Alternatives ) ) ;
    public final void ruleOpAnd() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:936:5: ( ( ( rule__OpAnd__Alternatives ) ) )
            // InternalExprParser.g:937:1: ( ( rule__OpAnd__Alternatives ) )
            {
            // InternalExprParser.g:937:1: ( ( rule__OpAnd__Alternatives ) )
            // InternalExprParser.g:938:1: ( rule__OpAnd__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpAndAccess().getAlternatives()); 
            }
            // InternalExprParser.g:939:1: ( rule__OpAnd__Alternatives )
            // InternalExprParser.g:939:2: rule__OpAnd__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OpAnd__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpAndAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRuleEqualityExpression"
    // InternalExprParser.g:951:1: entryRuleEqualityExpression : ruleEqualityExpression EOF ;
    public final void entryRuleEqualityExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:952:1: ( ruleEqualityExpression EOF )
            // InternalExprParser.g:953:1: ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEqualityExpression"


    // $ANTLR start "ruleEqualityExpression"
    // InternalExprParser.g:960:1: ruleEqualityExpression : ( ( rule__EqualityExpression__Group__0 ) ) ;
    public final void ruleEqualityExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:964:5: ( ( ( rule__EqualityExpression__Group__0 ) ) )
            // InternalExprParser.g:965:1: ( ( rule__EqualityExpression__Group__0 ) )
            {
            // InternalExprParser.g:965:1: ( ( rule__EqualityExpression__Group__0 ) )
            // InternalExprParser.g:966:1: ( rule__EqualityExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpressionAccess().getGroup()); 
            }
            // InternalExprParser.g:967:1: ( rule__EqualityExpression__Group__0 )
            // InternalExprParser.g:967:2: rule__EqualityExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EqualityExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // InternalExprParser.g:979:1: entryRuleOpEquality : ruleOpEquality EOF ;
    public final void entryRuleOpEquality() throws RecognitionException {
        try {
            // InternalExprParser.g:980:1: ( ruleOpEquality EOF )
            // InternalExprParser.g:981:1: ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpEquality();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpEqualityRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOpEquality"


    // $ANTLR start "ruleOpEquality"
    // InternalExprParser.g:988:1: ruleOpEquality : ( ( rule__OpEquality__Alternatives ) ) ;
    public final void ruleOpEquality() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:992:5: ( ( ( rule__OpEquality__Alternatives ) ) )
            // InternalExprParser.g:993:1: ( ( rule__OpEquality__Alternatives ) )
            {
            // InternalExprParser.g:993:1: ( ( rule__OpEquality__Alternatives ) )
            // InternalExprParser.g:994:1: ( rule__OpEquality__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpEqualityAccess().getAlternatives()); 
            }
            // InternalExprParser.g:995:1: ( rule__OpEquality__Alternatives )
            // InternalExprParser.g:995:2: rule__OpEquality__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OpEquality__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpEqualityAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRuleRelationalExpression"
    // InternalExprParser.g:1007:1: entryRuleRelationalExpression : ruleRelationalExpression EOF ;
    public final void entryRuleRelationalExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:1008:1: ( ruleRelationalExpression EOF )
            // InternalExprParser.g:1009:1: ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRelationalExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // InternalExprParser.g:1016:1: ruleRelationalExpression : ( ( rule__RelationalExpression__Group__0 ) ) ;
    public final void ruleRelationalExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1020:5: ( ( ( rule__RelationalExpression__Group__0 ) ) )
            // InternalExprParser.g:1021:1: ( ( rule__RelationalExpression__Group__0 ) )
            {
            // InternalExprParser.g:1021:1: ( ( rule__RelationalExpression__Group__0 ) )
            // InternalExprParser.g:1022:1: ( rule__RelationalExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRelationalExpressionAccess().getGroup()); 
            }
            // InternalExprParser.g:1023:1: ( rule__RelationalExpression__Group__0 )
            // InternalExprParser.g:1023:2: rule__RelationalExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RelationalExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRelationalExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // InternalExprParser.g:1035:1: entryRuleOpCompare : ruleOpCompare EOF ;
    public final void entryRuleOpCompare() throws RecognitionException {
        try {
            // InternalExprParser.g:1036:1: ( ruleOpCompare EOF )
            // InternalExprParser.g:1037:1: ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpCompare();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpCompareRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOpCompare"


    // $ANTLR start "ruleOpCompare"
    // InternalExprParser.g:1044:1: ruleOpCompare : ( ( rule__OpCompare__Alternatives ) ) ;
    public final void ruleOpCompare() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1048:5: ( ( ( rule__OpCompare__Alternatives ) ) )
            // InternalExprParser.g:1049:1: ( ( rule__OpCompare__Alternatives ) )
            {
            // InternalExprParser.g:1049:1: ( ( rule__OpCompare__Alternatives ) )
            // InternalExprParser.g:1050:1: ( rule__OpCompare__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpCompareAccess().getAlternatives()); 
            }
            // InternalExprParser.g:1051:1: ( rule__OpCompare__Alternatives )
            // InternalExprParser.g:1051:2: rule__OpCompare__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OpCompare__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpCompareAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpCompare"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalExprParser.g:1063:1: entryRuleAdditiveExpression : ruleAdditiveExpression EOF ;
    public final void entryRuleAdditiveExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:1064:1: ( ruleAdditiveExpression EOF )
            // InternalExprParser.g:1065:1: ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // InternalExprParser.g:1072:1: ruleAdditiveExpression : ( ( rule__AdditiveExpression__Group__0 ) ) ;
    public final void ruleAdditiveExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1076:5: ( ( ( rule__AdditiveExpression__Group__0 ) ) )
            // InternalExprParser.g:1077:1: ( ( rule__AdditiveExpression__Group__0 ) )
            {
            // InternalExprParser.g:1077:1: ( ( rule__AdditiveExpression__Group__0 ) )
            // InternalExprParser.g:1078:1: ( rule__AdditiveExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExpressionAccess().getGroup()); 
            }
            // InternalExprParser.g:1079:1: ( rule__AdditiveExpression__Group__0 )
            // InternalExprParser.g:1079:2: rule__AdditiveExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AdditiveExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // InternalExprParser.g:1091:1: entryRuleOpAdd : ruleOpAdd EOF ;
    public final void entryRuleOpAdd() throws RecognitionException {
        try {
            // InternalExprParser.g:1092:1: ( ruleOpAdd EOF )
            // InternalExprParser.g:1093:1: ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpAdd();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpAddRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOpAdd"


    // $ANTLR start "ruleOpAdd"
    // InternalExprParser.g:1100:1: ruleOpAdd : ( ( rule__OpAdd__Alternatives ) ) ;
    public final void ruleOpAdd() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1104:5: ( ( ( rule__OpAdd__Alternatives ) ) )
            // InternalExprParser.g:1105:1: ( ( rule__OpAdd__Alternatives ) )
            {
            // InternalExprParser.g:1105:1: ( ( rule__OpAdd__Alternatives ) )
            // InternalExprParser.g:1106:1: ( rule__OpAdd__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpAddAccess().getAlternatives()); 
            }
            // InternalExprParser.g:1107:1: ( rule__OpAdd__Alternatives )
            // InternalExprParser.g:1107:2: rule__OpAdd__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OpAdd__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpAddAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpAdd"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // InternalExprParser.g:1119:1: entryRuleMultiplicativeExpression : ruleMultiplicativeExpression EOF ;
    public final void entryRuleMultiplicativeExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:1120:1: ( ruleMultiplicativeExpression EOF )
            // InternalExprParser.g:1121:1: ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // InternalExprParser.g:1128:1: ruleMultiplicativeExpression : ( ( rule__MultiplicativeExpression__Group__0 ) ) ;
    public final void ruleMultiplicativeExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1132:5: ( ( ( rule__MultiplicativeExpression__Group__0 ) ) )
            // InternalExprParser.g:1133:1: ( ( rule__MultiplicativeExpression__Group__0 ) )
            {
            // InternalExprParser.g:1133:1: ( ( rule__MultiplicativeExpression__Group__0 ) )
            // InternalExprParser.g:1134:1: ( rule__MultiplicativeExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExpressionAccess().getGroup()); 
            }
            // InternalExprParser.g:1135:1: ( rule__MultiplicativeExpression__Group__0 )
            // InternalExprParser.g:1135:2: rule__MultiplicativeExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicativeExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // InternalExprParser.g:1147:1: entryRuleOpMulti : ruleOpMulti EOF ;
    public final void entryRuleOpMulti() throws RecognitionException {
        try {
            // InternalExprParser.g:1148:1: ( ruleOpMulti EOF )
            // InternalExprParser.g:1149:1: ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpMulti();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpMultiRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOpMulti"


    // $ANTLR start "ruleOpMulti"
    // InternalExprParser.g:1156:1: ruleOpMulti : ( ( rule__OpMulti__Alternatives ) ) ;
    public final void ruleOpMulti() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1160:5: ( ( ( rule__OpMulti__Alternatives ) ) )
            // InternalExprParser.g:1161:1: ( ( rule__OpMulti__Alternatives ) )
            {
            // InternalExprParser.g:1161:1: ( ( rule__OpMulti__Alternatives ) )
            // InternalExprParser.g:1162:1: ( rule__OpMulti__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpMultiAccess().getAlternatives()); 
            }
            // InternalExprParser.g:1163:1: ( rule__OpMulti__Alternatives )
            // InternalExprParser.g:1163:2: rule__OpMulti__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OpMulti__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpMultiAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpMulti"


    // $ANTLR start "entryRuleUnaryOperation"
    // InternalExprParser.g:1175:1: entryRuleUnaryOperation : ruleUnaryOperation EOF ;
    public final void entryRuleUnaryOperation() throws RecognitionException {
        try {
            // InternalExprParser.g:1176:1: ( ruleUnaryOperation EOF )
            // InternalExprParser.g:1177:1: ruleUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleUnaryOperation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnaryOperationRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnaryOperation"


    // $ANTLR start "ruleUnaryOperation"
    // InternalExprParser.g:1184:1: ruleUnaryOperation : ( ( rule__UnaryOperation__Alternatives ) ) ;
    public final void ruleUnaryOperation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1188:5: ( ( ( rule__UnaryOperation__Alternatives ) ) )
            // InternalExprParser.g:1189:1: ( ( rule__UnaryOperation__Alternatives ) )
            {
            // InternalExprParser.g:1189:1: ( ( rule__UnaryOperation__Alternatives ) )
            // InternalExprParser.g:1190:1: ( rule__UnaryOperation__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryOperationAccess().getAlternatives()); 
            }
            // InternalExprParser.g:1191:1: ( rule__UnaryOperation__Alternatives )
            // InternalExprParser.g:1191:2: rule__UnaryOperation__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__UnaryOperation__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnaryOperationAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // InternalExprParser.g:1203:1: entryRuleOpUnary : ruleOpUnary EOF ;
    public final void entryRuleOpUnary() throws RecognitionException {
        try {
            // InternalExprParser.g:1204:1: ( ruleOpUnary EOF )
            // InternalExprParser.g:1205:1: ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpUnary();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpUnaryRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOpUnary"


    // $ANTLR start "ruleOpUnary"
    // InternalExprParser.g:1212:1: ruleOpUnary : ( ( rule__OpUnary__Alternatives ) ) ;
    public final void ruleOpUnary() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1216:5: ( ( ( rule__OpUnary__Alternatives ) ) )
            // InternalExprParser.g:1217:1: ( ( rule__OpUnary__Alternatives ) )
            {
            // InternalExprParser.g:1217:1: ( ( rule__OpUnary__Alternatives ) )
            // InternalExprParser.g:1218:1: ( rule__OpUnary__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpUnaryAccess().getAlternatives()); 
            }
            // InternalExprParser.g:1219:1: ( rule__OpUnary__Alternatives )
            // InternalExprParser.g:1219:2: rule__OpUnary__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OpUnary__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpUnaryAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpUnary"


    // $ANTLR start "entryRuleUnitExpression"
    // InternalExprParser.g:1231:1: entryRuleUnitExpression : ruleUnitExpression EOF ;
    public final void entryRuleUnitExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:1232:1: ( ruleUnitExpression EOF )
            // InternalExprParser.g:1233:1: ruleUnitExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnitExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleUnitExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnitExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnitExpression"


    // $ANTLR start "ruleUnitExpression"
    // InternalExprParser.g:1240:1: ruleUnitExpression : ( ( rule__UnitExpression__Group__0 ) ) ;
    public final void ruleUnitExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1244:5: ( ( ( rule__UnitExpression__Group__0 ) ) )
            // InternalExprParser.g:1245:1: ( ( rule__UnitExpression__Group__0 ) )
            {
            // InternalExprParser.g:1245:1: ( ( rule__UnitExpression__Group__0 ) )
            // InternalExprParser.g:1246:1: ( rule__UnitExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnitExpressionAccess().getGroup()); 
            }
            // InternalExprParser.g:1247:1: ( rule__UnitExpression__Group__0 )
            // InternalExprParser.g:1247:2: rule__UnitExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__UnitExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnitExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnitExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalExprParser.g:1259:1: entryRulePrimaryExpression : rulePrimaryExpression EOF ;
    public final void entryRulePrimaryExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:1260:1: ( rulePrimaryExpression EOF )
            // InternalExprParser.g:1261:1: rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalExprParser.g:1268:1: rulePrimaryExpression : ( ( rule__PrimaryExpression__Alternatives ) ) ;
    public final void rulePrimaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1272:5: ( ( ( rule__PrimaryExpression__Alternatives ) ) )
            // InternalExprParser.g:1273:1: ( ( rule__PrimaryExpression__Alternatives ) )
            {
            // InternalExprParser.g:1273:1: ( ( rule__PrimaryExpression__Alternatives ) )
            // InternalExprParser.g:1274:1: ( rule__PrimaryExpression__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 
            }
            // InternalExprParser.g:1275:1: ( rule__PrimaryExpression__Alternatives )
            // InternalExprParser.g:1275:2: rule__PrimaryExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleVarRef"
    // InternalExprParser.g:1287:1: entryRuleVarRef : ruleVarRef EOF ;
    public final void entryRuleVarRef() throws RecognitionException {
        try {
            // InternalExprParser.g:1288:1: ( ruleVarRef EOF )
            // InternalExprParser.g:1289:1: ruleVarRef EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarRefRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleVarRef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarRefRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVarRef"


    // $ANTLR start "ruleVarRef"
    // InternalExprParser.g:1296:1: ruleVarRef : ( ( rule__VarRef__RefAssignment ) ) ;
    public final void ruleVarRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1300:5: ( ( ( rule__VarRef__RefAssignment ) ) )
            // InternalExprParser.g:1301:1: ( ( rule__VarRef__RefAssignment ) )
            {
            // InternalExprParser.g:1301:1: ( ( rule__VarRef__RefAssignment ) )
            // InternalExprParser.g:1302:1: ( rule__VarRef__RefAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarRefAccess().getRefAssignment()); 
            }
            // InternalExprParser.g:1303:1: ( rule__VarRef__RefAssignment )
            // InternalExprParser.g:1303:2: rule__VarRef__RefAssignment
            {
            pushFollow(FOLLOW_2);
            rule__VarRef__RefAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarRefAccess().getRefAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVarRef"


    // $ANTLR start "entryRuleModelOrPropertyReference"
    // InternalExprParser.g:1315:1: entryRuleModelOrPropertyReference : ruleModelOrPropertyReference EOF ;
    public final void entryRuleModelOrPropertyReference() throws RecognitionException {
        try {
            // InternalExprParser.g:1316:1: ( ruleModelOrPropertyReference EOF )
            // InternalExprParser.g:1317:1: ruleModelOrPropertyReference EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelOrPropertyReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleModelOrPropertyReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelOrPropertyReferenceRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModelOrPropertyReference"


    // $ANTLR start "ruleModelOrPropertyReference"
    // InternalExprParser.g:1324:1: ruleModelOrPropertyReference : ( ( rule__ModelOrPropertyReference__Alternatives ) ) ;
    public final void ruleModelOrPropertyReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1328:5: ( ( ( rule__ModelOrPropertyReference__Alternatives ) ) )
            // InternalExprParser.g:1329:1: ( ( rule__ModelOrPropertyReference__Alternatives ) )
            {
            // InternalExprParser.g:1329:1: ( ( rule__ModelOrPropertyReference__Alternatives ) )
            // InternalExprParser.g:1330:1: ( rule__ModelOrPropertyReference__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelOrPropertyReferenceAccess().getAlternatives()); 
            }
            // InternalExprParser.g:1331:1: ( rule__ModelOrPropertyReference__Alternatives )
            // InternalExprParser.g:1331:2: rule__ModelOrPropertyReference__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ModelOrPropertyReference__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelOrPropertyReferenceAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModelOrPropertyReference"


    // $ANTLR start "entryRuleModelReference"
    // InternalExprParser.g:1343:1: entryRuleModelReference : ruleModelReference EOF ;
    public final void entryRuleModelReference() throws RecognitionException {
        try {
            // InternalExprParser.g:1344:1: ( ruleModelReference EOF )
            // InternalExprParser.g:1345:1: ruleModelReference EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleModelReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelReferenceRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModelReference"


    // $ANTLR start "ruleModelReference"
    // InternalExprParser.g:1352:1: ruleModelReference : ( ( rule__ModelReference__Group__0 ) ) ;
    public final void ruleModelReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1356:5: ( ( ( rule__ModelReference__Group__0 ) ) )
            // InternalExprParser.g:1357:1: ( ( rule__ModelReference__Group__0 ) )
            {
            // InternalExprParser.g:1357:1: ( ( rule__ModelReference__Group__0 ) )
            // InternalExprParser.g:1358:1: ( rule__ModelReference__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelReferenceAccess().getGroup()); 
            }
            // InternalExprParser.g:1359:1: ( rule__ModelReference__Group__0 )
            // InternalExprParser.g:1359:2: rule__ModelReference__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ModelReference__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelReferenceAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModelReference"


    // $ANTLR start "entryRuleThis"
    // InternalExprParser.g:1371:1: entryRuleThis : ruleThis EOF ;
    public final void entryRuleThis() throws RecognitionException {
        try {
            // InternalExprParser.g:1372:1: ( ruleThis EOF )
            // InternalExprParser.g:1373:1: ruleThis EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getThisRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleThis();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getThisRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleThis"


    // $ANTLR start "ruleThis"
    // InternalExprParser.g:1380:1: ruleThis : ( This ) ;
    public final void ruleThis() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1384:5: ( ( This ) )
            // InternalExprParser.g:1385:1: ( This )
            {
            // InternalExprParser.g:1385:1: ( This )
            // InternalExprParser.g:1386:1: This
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getThisAccess().getThisKeyword()); 
            }
            match(input,This,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getThisAccess().getThisKeyword()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleThis"


    // $ANTLR start "entryRulePropertyReference"
    // InternalExprParser.g:1401:1: entryRulePropertyReference : rulePropertyReference EOF ;
    public final void entryRulePropertyReference() throws RecognitionException {
        try {
            // InternalExprParser.g:1402:1: ( rulePropertyReference EOF )
            // InternalExprParser.g:1403:1: rulePropertyReference EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePropertyReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPropertyReferenceRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePropertyReference"


    // $ANTLR start "rulePropertyReference"
    // InternalExprParser.g:1410:1: rulePropertyReference : ( ( rule__PropertyReference__Group__0 ) ) ;
    public final void rulePropertyReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1414:5: ( ( ( rule__PropertyReference__Group__0 ) ) )
            // InternalExprParser.g:1415:1: ( ( rule__PropertyReference__Group__0 ) )
            {
            // InternalExprParser.g:1415:1: ( ( rule__PropertyReference__Group__0 ) )
            // InternalExprParser.g:1416:1: ( rule__PropertyReference__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyReferenceAccess().getGroup()); 
            }
            // InternalExprParser.g:1417:1: ( rule__PropertyReference__Group__0 )
            // InternalExprParser.g:1417:2: rule__PropertyReference__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PropertyReference__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPropertyReferenceAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePropertyReference"


    // $ANTLR start "entryRuleFunctionCall"
    // InternalExprParser.g:1429:1: entryRuleFunctionCall : ruleFunctionCall EOF ;
    public final void entryRuleFunctionCall() throws RecognitionException {
        try {
            // InternalExprParser.g:1430:1: ( ruleFunctionCall EOF )
            // InternalExprParser.g:1431:1: ruleFunctionCall EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionCallRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleFunctionCall();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionCallRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFunctionCall"


    // $ANTLR start "ruleFunctionCall"
    // InternalExprParser.g:1438:1: ruleFunctionCall : ( ( rule__FunctionCall__Group__0 ) ) ;
    public final void ruleFunctionCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1442:5: ( ( ( rule__FunctionCall__Group__0 ) ) )
            // InternalExprParser.g:1443:1: ( ( rule__FunctionCall__Group__0 ) )
            {
            // InternalExprParser.g:1443:1: ( ( rule__FunctionCall__Group__0 ) )
            // InternalExprParser.g:1444:1: ( rule__FunctionCall__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionCallAccess().getGroup()); 
            }
            // InternalExprParser.g:1445:1: ( rule__FunctionCall__Group__0 )
            // InternalExprParser.g:1445:2: rule__FunctionCall__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FunctionCall__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionCallAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFunctionCall"


    // $ANTLR start "entryRuleRangeExpression"
    // InternalExprParser.g:1457:1: entryRuleRangeExpression : ruleRangeExpression EOF ;
    public final void entryRuleRangeExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:1458:1: ( ruleRangeExpression EOF )
            // InternalExprParser.g:1459:1: ruleRangeExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRangeExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRangeExpression"


    // $ANTLR start "ruleRangeExpression"
    // InternalExprParser.g:1466:1: ruleRangeExpression : ( ( rule__RangeExpression__Group__0 ) ) ;
    public final void ruleRangeExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1470:5: ( ( ( rule__RangeExpression__Group__0 ) ) )
            // InternalExprParser.g:1471:1: ( ( rule__RangeExpression__Group__0 ) )
            {
            // InternalExprParser.g:1471:1: ( ( rule__RangeExpression__Group__0 ) )
            // InternalExprParser.g:1472:1: ( rule__RangeExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeExpressionAccess().getGroup()); 
            }
            // InternalExprParser.g:1473:1: ( rule__RangeExpression__Group__0 )
            // InternalExprParser.g:1473:2: rule__RangeExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RangeExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRangeExpression"


    // $ANTLR start "entryRuleIfExpression"
    // InternalExprParser.g:1485:1: entryRuleIfExpression : ruleIfExpression EOF ;
    public final void entryRuleIfExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:1486:1: ( ruleIfExpression EOF )
            // InternalExprParser.g:1487:1: ruleIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleIfExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIfExpression"


    // $ANTLR start "ruleIfExpression"
    // InternalExprParser.g:1494:1: ruleIfExpression : ( ( rule__IfExpression__Group__0 ) ) ;
    public final void ruleIfExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1498:5: ( ( ( rule__IfExpression__Group__0 ) ) )
            // InternalExprParser.g:1499:1: ( ( rule__IfExpression__Group__0 ) )
            {
            // InternalExprParser.g:1499:1: ( ( rule__IfExpression__Group__0 ) )
            // InternalExprParser.g:1500:1: ( rule__IfExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfExpressionAccess().getGroup()); 
            }
            // InternalExprParser.g:1501:1: ( rule__IfExpression__Group__0 )
            // InternalExprParser.g:1501:2: rule__IfExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IfExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIfExpression"


    // $ANTLR start "entryRuleLiteral"
    // InternalExprParser.g:1513:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1514:1: ( ruleLiteral EOF )
            // InternalExprParser.g:1515:1: ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalExprParser.g:1522:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1526:5: ( ( ( rule__Literal__Alternatives ) ) )
            // InternalExprParser.g:1527:1: ( ( rule__Literal__Alternatives ) )
            {
            // InternalExprParser.g:1527:1: ( ( rule__Literal__Alternatives ) )
            // InternalExprParser.g:1528:1: ( rule__Literal__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getAlternatives()); 
            }
            // InternalExprParser.g:1529:1: ( rule__Literal__Alternatives )
            // InternalExprParser.g:1529:2: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Literal__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleBooleanLiteral"
    // InternalExprParser.g:1541:1: entryRuleBooleanLiteral : ruleBooleanLiteral EOF ;
    public final void entryRuleBooleanLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1542:1: ( ruleBooleanLiteral EOF )
            // InternalExprParser.g:1543:1: ruleBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleBooleanLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBooleanLiteral"


    // $ANTLR start "ruleBooleanLiteral"
    // InternalExprParser.g:1550:1: ruleBooleanLiteral : ( ( rule__BooleanLiteral__Group__0 ) ) ;
    public final void ruleBooleanLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1554:5: ( ( ( rule__BooleanLiteral__Group__0 ) ) )
            // InternalExprParser.g:1555:1: ( ( rule__BooleanLiteral__Group__0 ) )
            {
            // InternalExprParser.g:1555:1: ( ( rule__BooleanLiteral__Group__0 ) )
            // InternalExprParser.g:1556:1: ( rule__BooleanLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getGroup()); 
            }
            // InternalExprParser.g:1557:1: ( rule__BooleanLiteral__Group__0 )
            // InternalExprParser.g:1557:2: rule__BooleanLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BooleanLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBooleanLiteral"


    // $ANTLR start "entryRuleIntegerLiteral"
    // InternalExprParser.g:1569:1: entryRuleIntegerLiteral : ruleIntegerLiteral EOF ;
    public final void entryRuleIntegerLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1570:1: ( ruleIntegerLiteral EOF )
            // InternalExprParser.g:1571:1: ruleIntegerLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleIntegerLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegerLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntegerLiteral"


    // $ANTLR start "ruleIntegerLiteral"
    // InternalExprParser.g:1578:1: ruleIntegerLiteral : ( ( rule__IntegerLiteral__Group__0 ) ) ;
    public final void ruleIntegerLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1582:5: ( ( ( rule__IntegerLiteral__Group__0 ) ) )
            // InternalExprParser.g:1583:1: ( ( rule__IntegerLiteral__Group__0 ) )
            {
            // InternalExprParser.g:1583:1: ( ( rule__IntegerLiteral__Group__0 ) )
            // InternalExprParser.g:1584:1: ( rule__IntegerLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralAccess().getGroup()); 
            }
            // InternalExprParser.g:1585:1: ( rule__IntegerLiteral__Group__0 )
            // InternalExprParser.g:1585:2: rule__IntegerLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IntegerLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegerLiteralAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntegerLiteral"


    // $ANTLR start "entryRuleRealLiteral"
    // InternalExprParser.g:1597:1: entryRuleRealLiteral : ruleRealLiteral EOF ;
    public final void entryRuleRealLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1598:1: ( ruleRealLiteral EOF )
            // InternalExprParser.g:1599:1: ruleRealLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRealLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRealLiteral"


    // $ANTLR start "ruleRealLiteral"
    // InternalExprParser.g:1606:1: ruleRealLiteral : ( ( rule__RealLiteral__Group__0 ) ) ;
    public final void ruleRealLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1610:5: ( ( ( rule__RealLiteral__Group__0 ) ) )
            // InternalExprParser.g:1611:1: ( ( rule__RealLiteral__Group__0 ) )
            {
            // InternalExprParser.g:1611:1: ( ( rule__RealLiteral__Group__0 ) )
            // InternalExprParser.g:1612:1: ( rule__RealLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getGroup()); 
            }
            // InternalExprParser.g:1613:1: ( rule__RealLiteral__Group__0 )
            // InternalExprParser.g:1613:2: rule__RealLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RealLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRealLiteral"


    // $ANTLR start "entryRuleStringLiteral"
    // InternalExprParser.g:1625:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1626:1: ( ruleStringLiteral EOF )
            // InternalExprParser.g:1627:1: ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleStringLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // InternalExprParser.g:1634:1: ruleStringLiteral : ( ( rule__StringLiteral__Group__0 ) ) ;
    public final void ruleStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1638:5: ( ( ( rule__StringLiteral__Group__0 ) ) )
            // InternalExprParser.g:1639:1: ( ( rule__StringLiteral__Group__0 ) )
            {
            // InternalExprParser.g:1639:1: ( ( rule__StringLiteral__Group__0 ) )
            // InternalExprParser.g:1640:1: ( rule__StringLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getGroup()); 
            }
            // InternalExprParser.g:1641:1: ( rule__StringLiteral__Group__0 )
            // InternalExprParser.g:1641:2: rule__StringLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__StringLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "ruleCommaSeparatedExpressions"
    // InternalExprParser.g:1654:1: ruleCommaSeparatedExpressions : ( ( rule__CommaSeparatedExpressions__Group__0 ) ) ;
    public final void ruleCommaSeparatedExpressions() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1658:5: ( ( ( rule__CommaSeparatedExpressions__Group__0 ) ) )
            // InternalExprParser.g:1659:1: ( ( rule__CommaSeparatedExpressions__Group__0 ) )
            {
            // InternalExprParser.g:1659:1: ( ( rule__CommaSeparatedExpressions__Group__0 ) )
            // InternalExprParser.g:1660:1: ( rule__CommaSeparatedExpressions__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCommaSeparatedExpressionsAccess().getGroup()); 
            }
            // InternalExprParser.g:1661:1: ( rule__CommaSeparatedExpressions__Group__0 )
            // InternalExprParser.g:1661:2: rule__CommaSeparatedExpressions__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CommaSeparatedExpressions__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCommaSeparatedExpressionsAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCommaSeparatedExpressions"


    // $ANTLR start "entryRuleListLiteral"
    // InternalExprParser.g:1673:1: entryRuleListLiteral : ruleListLiteral EOF ;
    public final void entryRuleListLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1674:1: ( ruleListLiteral EOF )
            // InternalExprParser.g:1675:1: ruleListLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleListLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getListLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleListLiteral"


    // $ANTLR start "ruleListLiteral"
    // InternalExprParser.g:1682:1: ruleListLiteral : ( ( rule__ListLiteral__Group__0 ) ) ;
    public final void ruleListLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1686:5: ( ( ( rule__ListLiteral__Group__0 ) ) )
            // InternalExprParser.g:1687:1: ( ( rule__ListLiteral__Group__0 ) )
            {
            // InternalExprParser.g:1687:1: ( ( rule__ListLiteral__Group__0 ) )
            // InternalExprParser.g:1688:1: ( rule__ListLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListLiteralAccess().getGroup()); 
            }
            // InternalExprParser.g:1689:1: ( rule__ListLiteral__Group__0 )
            // InternalExprParser.g:1689:2: rule__ListLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ListLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getListLiteralAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleListLiteral"


    // $ANTLR start "entryRuleSetLiteral"
    // InternalExprParser.g:1701:1: entryRuleSetLiteral : ruleSetLiteral EOF ;
    public final void entryRuleSetLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1702:1: ( ruleSetLiteral EOF )
            // InternalExprParser.g:1703:1: ruleSetLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSetLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleSetLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSetLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSetLiteral"


    // $ANTLR start "ruleSetLiteral"
    // InternalExprParser.g:1710:1: ruleSetLiteral : ( ( rule__SetLiteral__Group__0 ) ) ;
    public final void ruleSetLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1714:5: ( ( ( rule__SetLiteral__Group__0 ) ) )
            // InternalExprParser.g:1715:1: ( ( rule__SetLiteral__Group__0 ) )
            {
            // InternalExprParser.g:1715:1: ( ( rule__SetLiteral__Group__0 ) )
            // InternalExprParser.g:1716:1: ( rule__SetLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSetLiteralAccess().getGroup()); 
            }
            // InternalExprParser.g:1717:1: ( rule__SetLiteral__Group__0 )
            // InternalExprParser.g:1717:2: rule__SetLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SetLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSetLiteralAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSetLiteral"


    // $ANTLR start "entryRuleRecordLiteral"
    // InternalExprParser.g:1729:1: entryRuleRecordLiteral : ruleRecordLiteral EOF ;
    public final void entryRuleRecordLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1730:1: ( ruleRecordLiteral EOF )
            // InternalExprParser.g:1731:1: ruleRecordLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecordLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRecordLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecordLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRecordLiteral"


    // $ANTLR start "ruleRecordLiteral"
    // InternalExprParser.g:1738:1: ruleRecordLiteral : ( ( rule__RecordLiteral__Group__0 ) ) ;
    public final void ruleRecordLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1742:5: ( ( ( rule__RecordLiteral__Group__0 ) ) )
            // InternalExprParser.g:1743:1: ( ( rule__RecordLiteral__Group__0 ) )
            {
            // InternalExprParser.g:1743:1: ( ( rule__RecordLiteral__Group__0 ) )
            // InternalExprParser.g:1744:1: ( rule__RecordLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecordLiteralAccess().getGroup()); 
            }
            // InternalExprParser.g:1745:1: ( rule__RecordLiteral__Group__0 )
            // InternalExprParser.g:1745:2: rule__RecordLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RecordLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecordLiteralAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRecordLiteral"


    // $ANTLR start "entryRuleUnionLiteral"
    // InternalExprParser.g:1757:1: entryRuleUnionLiteral : ruleUnionLiteral EOF ;
    public final void entryRuleUnionLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1758:1: ( ruleUnionLiteral EOF )
            // InternalExprParser.g:1759:1: ruleUnionLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnionLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleUnionLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnionLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnionLiteral"


    // $ANTLR start "ruleUnionLiteral"
    // InternalExprParser.g:1766:1: ruleUnionLiteral : ( ( rule__UnionLiteral__Group__0 ) ) ;
    public final void ruleUnionLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1770:5: ( ( ( rule__UnionLiteral__Group__0 ) ) )
            // InternalExprParser.g:1771:1: ( ( rule__UnionLiteral__Group__0 ) )
            {
            // InternalExprParser.g:1771:1: ( ( rule__UnionLiteral__Group__0 ) )
            // InternalExprParser.g:1772:1: ( rule__UnionLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnionLiteralAccess().getGroup()); 
            }
            // InternalExprParser.g:1773:1: ( rule__UnionLiteral__Group__0 )
            // InternalExprParser.g:1773:2: rule__UnionLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__UnionLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnionLiteralAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnionLiteral"


    // $ANTLR start "entryRuleTupleLiteral"
    // InternalExprParser.g:1785:1: entryRuleTupleLiteral : ruleTupleLiteral EOF ;
    public final void entryRuleTupleLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1786:1: ( ruleTupleLiteral EOF )
            // InternalExprParser.g:1787:1: ruleTupleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTupleLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTupleLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTupleLiteral"


    // $ANTLR start "ruleTupleLiteral"
    // InternalExprParser.g:1794:1: ruleTupleLiteral : ( ( rule__TupleLiteral__Group__0 ) ) ;
    public final void ruleTupleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1798:5: ( ( ( rule__TupleLiteral__Group__0 ) ) )
            // InternalExprParser.g:1799:1: ( ( rule__TupleLiteral__Group__0 ) )
            {
            // InternalExprParser.g:1799:1: ( ( rule__TupleLiteral__Group__0 ) )
            // InternalExprParser.g:1800:1: ( rule__TupleLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleLiteralAccess().getGroup()); 
            }
            // InternalExprParser.g:1801:1: ( rule__TupleLiteral__Group__0 )
            // InternalExprParser.g:1801:2: rule__TupleLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TupleLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTupleLiteralAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTupleLiteral"


    // $ANTLR start "entryRuleBagLiteral"
    // InternalExprParser.g:1813:1: entryRuleBagLiteral : ruleBagLiteral EOF ;
    public final void entryRuleBagLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1814:1: ( ruleBagLiteral EOF )
            // InternalExprParser.g:1815:1: ruleBagLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBagLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleBagLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBagLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBagLiteral"


    // $ANTLR start "ruleBagLiteral"
    // InternalExprParser.g:1822:1: ruleBagLiteral : ( ( rule__BagLiteral__Group__0 ) ) ;
    public final void ruleBagLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1826:5: ( ( ( rule__BagLiteral__Group__0 ) ) )
            // InternalExprParser.g:1827:1: ( ( rule__BagLiteral__Group__0 ) )
            {
            // InternalExprParser.g:1827:1: ( ( rule__BagLiteral__Group__0 ) )
            // InternalExprParser.g:1828:1: ( rule__BagLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBagLiteralAccess().getGroup()); 
            }
            // InternalExprParser.g:1829:1: ( rule__BagLiteral__Group__0 )
            // InternalExprParser.g:1829:2: rule__BagLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BagLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBagLiteralAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBagLiteral"


    // $ANTLR start "entryRuleMapLiteral"
    // InternalExprParser.g:1841:1: entryRuleMapLiteral : ruleMapLiteral EOF ;
    public final void entryRuleMapLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1842:1: ( ruleMapLiteral EOF )
            // InternalExprParser.g:1843:1: ruleMapLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMapLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleMapLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMapLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMapLiteral"


    // $ANTLR start "ruleMapLiteral"
    // InternalExprParser.g:1850:1: ruleMapLiteral : ( ( rule__MapLiteral__Group__0 ) ) ;
    public final void ruleMapLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1854:5: ( ( ( rule__MapLiteral__Group__0 ) ) )
            // InternalExprParser.g:1855:1: ( ( rule__MapLiteral__Group__0 ) )
            {
            // InternalExprParser.g:1855:1: ( ( rule__MapLiteral__Group__0 ) )
            // InternalExprParser.g:1856:1: ( rule__MapLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMapLiteralAccess().getGroup()); 
            }
            // InternalExprParser.g:1857:1: ( rule__MapLiteral__Group__0 )
            // InternalExprParser.g:1857:2: rule__MapLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MapLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMapLiteralAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMapLiteral"


    // $ANTLR start "entryRuleNoQuoteString"
    // InternalExprParser.g:1869:1: entryRuleNoQuoteString : ruleNoQuoteString EOF ;
    public final void entryRuleNoQuoteString() throws RecognitionException {
        try {
            // InternalExprParser.g:1870:1: ( ruleNoQuoteString EOF )
            // InternalExprParser.g:1871:1: ruleNoQuoteString EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNoQuoteStringRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNoQuoteStringRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNoQuoteString"


    // $ANTLR start "ruleNoQuoteString"
    // InternalExprParser.g:1878:1: ruleNoQuoteString : ( RULE_STRING ) ;
    public final void ruleNoQuoteString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1882:5: ( ( RULE_STRING ) )
            // InternalExprParser.g:1883:1: ( RULE_STRING )
            {
            // InternalExprParser.g:1883:1: ( RULE_STRING )
            // InternalExprParser.g:1884:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNoQuoteString"


    // $ANTLR start "entryRuleQPREF"
    // InternalExprParser.g:1899:1: entryRuleQPREF : ruleQPREF EOF ;
    public final void entryRuleQPREF() throws RecognitionException {
        try {
            // InternalExprParser.g:1900:1: ( ruleQPREF EOF )
            // InternalExprParser.g:1901:1: ruleQPREF EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQPREFRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQPREFRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQPREF"


    // $ANTLR start "ruleQPREF"
    // InternalExprParser.g:1908:1: ruleQPREF : ( ( rule__QPREF__Group__0 ) ) ;
    public final void ruleQPREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1912:5: ( ( ( rule__QPREF__Group__0 ) ) )
            // InternalExprParser.g:1913:1: ( ( rule__QPREF__Group__0 ) )
            {
            // InternalExprParser.g:1913:1: ( ( rule__QPREF__Group__0 ) )
            // InternalExprParser.g:1914:1: ( rule__QPREF__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQPREFAccess().getGroup()); 
            }
            // InternalExprParser.g:1915:1: ( rule__QPREF__Group__0 )
            // InternalExprParser.g:1915:2: rule__QPREF__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QPREF__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQPREFAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQPREF"


    // $ANTLR start "entryRuleQCREF"
    // InternalExprParser.g:1927:1: entryRuleQCREF : ruleQCREF EOF ;
    public final void entryRuleQCREF() throws RecognitionException {
        try {
            // InternalExprParser.g:1928:1: ( ruleQCREF EOF )
            // InternalExprParser.g:1929:1: ruleQCREF EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQCREFRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQCREFRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQCREF"


    // $ANTLR start "ruleQCREF"
    // InternalExprParser.g:1936:1: ruleQCREF : ( ( rule__QCREF__Group__0 ) ) ;
    public final void ruleQCREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1940:5: ( ( ( rule__QCREF__Group__0 ) ) )
            // InternalExprParser.g:1941:1: ( ( rule__QCREF__Group__0 ) )
            {
            // InternalExprParser.g:1941:1: ( ( rule__QCREF__Group__0 ) )
            // InternalExprParser.g:1942:1: ( rule__QCREF__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQCREFAccess().getGroup()); 
            }
            // InternalExprParser.g:1943:1: ( rule__QCREF__Group__0 )
            // InternalExprParser.g:1943:2: rule__QCREF__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QCREF__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQCREFAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQCREF"


    // $ANTLR start "ruleMetaClassEnum"
    // InternalExprParser.g:1958:1: ruleMetaClassEnum : ( ( rule__MetaClassEnum__Alternatives ) ) ;
    public final void ruleMetaClassEnum() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1962:1: ( ( ( rule__MetaClassEnum__Alternatives ) ) )
            // InternalExprParser.g:1963:1: ( ( rule__MetaClassEnum__Alternatives ) )
            {
            // InternalExprParser.g:1963:1: ( ( rule__MetaClassEnum__Alternatives ) )
            // InternalExprParser.g:1964:1: ( rule__MetaClassEnum__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetaClassEnumAccess().getAlternatives()); 
            }
            // InternalExprParser.g:1965:1: ( rule__MetaClassEnum__Alternatives )
            // InternalExprParser.g:1965:2: rule__MetaClassEnum__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__MetaClassEnum__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetaClassEnumAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMetaClassEnum"


    // $ANTLR start "rule__ExprModel__Alternatives"
    // InternalExprParser.g:1980:1: rule__ExprModel__Alternatives : ( ( ( rule__ExprModel__Group_0__0 ) ) | ( ( rule__ExprModel__Group_1__0 ) ) );
    public final void rule__ExprModel__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1984:1: ( ( ( rule__ExprModel__Group_0__0 ) ) | ( ( rule__ExprModel__Group_1__0 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==Library) ) {
                alt1=1;
            }
            else if ( (LA1_0==Subclause) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalExprParser.g:1985:1: ( ( rule__ExprModel__Group_0__0 ) )
                    {
                    // InternalExprParser.g:1985:1: ( ( rule__ExprModel__Group_0__0 ) )
                    // InternalExprParser.g:1986:1: ( rule__ExprModel__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getExprModelAccess().getGroup_0()); 
                    }
                    // InternalExprParser.g:1987:1: ( rule__ExprModel__Group_0__0 )
                    // InternalExprParser.g:1987:2: rule__ExprModel__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExprModel__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getExprModelAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:1991:6: ( ( rule__ExprModel__Group_1__0 ) )
                    {
                    // InternalExprParser.g:1991:6: ( ( rule__ExprModel__Group_1__0 ) )
                    // InternalExprParser.g:1992:1: ( rule__ExprModel__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getExprModelAccess().getGroup_1()); 
                    }
                    // InternalExprParser.g:1993:1: ( rule__ExprModel__Group_1__0 )
                    // InternalExprParser.g:1993:2: rule__ExprModel__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExprModel__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getExprModelAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExprModel__Alternatives"


    // $ANTLR start "rule__Declaration__Alternatives"
    // InternalExprParser.g:2002:1: rule__Declaration__Alternatives : ( ( ruleTypeDecl ) | ( ruleVarDecl ) | ( ruleFunDecl ) );
    public final void rule__Declaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2006:1: ( ( ruleTypeDecl ) | ( ruleVarDecl ) | ( ruleFunDecl ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case Type:
                {
                alt2=1;
                }
                break;
            case Val:
            case Var:
                {
                alt2=2;
                }
                break;
            case Def:
                {
                alt2=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalExprParser.g:2007:1: ( ruleTypeDecl )
                    {
                    // InternalExprParser.g:2007:1: ( ruleTypeDecl )
                    // InternalExprParser.g:2008:1: ruleTypeDecl
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclarationAccess().getTypeDeclParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleTypeDecl();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDeclarationAccess().getTypeDeclParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2013:6: ( ruleVarDecl )
                    {
                    // InternalExprParser.g:2013:6: ( ruleVarDecl )
                    // InternalExprParser.g:2014:1: ruleVarDecl
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclarationAccess().getVarDeclParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleVarDecl();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDeclarationAccess().getVarDeclParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalExprParser.g:2019:6: ( ruleFunDecl )
                    {
                    // InternalExprParser.g:2019:6: ( ruleFunDecl )
                    // InternalExprParser.g:2020:1: ruleFunDecl
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclarationAccess().getFunDeclParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleFunDecl();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDeclarationAccess().getFunDeclParserRuleCall_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declaration__Alternatives"


    // $ANTLR start "rule__VarDecl__Alternatives_1"
    // InternalExprParser.g:2030:1: rule__VarDecl__Alternatives_1 : ( ( ( rule__VarDecl__ConstAssignment_1_0 ) ) | ( Var ) );
    public final void rule__VarDecl__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2034:1: ( ( ( rule__VarDecl__ConstAssignment_1_0 ) ) | ( Var ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Val) ) {
                alt3=1;
            }
            else if ( (LA3_0==Var) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalExprParser.g:2035:1: ( ( rule__VarDecl__ConstAssignment_1_0 ) )
                    {
                    // InternalExprParser.g:2035:1: ( ( rule__VarDecl__ConstAssignment_1_0 ) )
                    // InternalExprParser.g:2036:1: ( rule__VarDecl__ConstAssignment_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVarDeclAccess().getConstAssignment_1_0()); 
                    }
                    // InternalExprParser.g:2037:1: ( rule__VarDecl__ConstAssignment_1_0 )
                    // InternalExprParser.g:2037:2: rule__VarDecl__ConstAssignment_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VarDecl__ConstAssignment_1_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVarDeclAccess().getConstAssignment_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2041:6: ( Var )
                    {
                    // InternalExprParser.g:2041:6: ( Var )
                    // InternalExprParser.g:2042:1: Var
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVarDeclAccess().getVarKeyword_1_1()); 
                    }
                    match(input,Var,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVarDeclAccess().getVarKeyword_1_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__Alternatives_1"


    // $ANTLR start "rule__Type__Alternatives"
    // InternalExprParser.g:2054:1: rule__Type__Alternatives : ( ( rulePrimitiveType ) | ( ruleCategory ) | ( ruleMetaClass ) | ( ruleClassifierType ) | ( ruleRecordType ) | ( ruleUnionType ) | ( ruleTupleType ) | ( ruleListType ) | ( ruleSetType ) | ( ruleBagType ) | ( ruleMapType ) | ( ruleTypeRef ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2058:1: ( ( rulePrimitiveType ) | ( ruleCategory ) | ( ruleMetaClass ) | ( ruleClassifierType ) | ( ruleRecordType ) | ( ruleUnionType ) | ( ruleTupleType ) | ( ruleListType ) | ( ruleSetType ) | ( ruleBagType ) | ( ruleMapType ) | ( ruleTypeRef ) )
            int alt4=12;
            switch ( input.LA(1) ) {
            case String:
            case Bool:
            case Real:
            case Int:
                {
                alt4=1;
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
                alt4=2;
                }
                break;
            case Subcomponent:
            case Connection:
            case Component:
            case Feature:
            case Flow:
            case Mode:
                {
                alt4=3;
                }
                break;
            case Classifier:
                {
                alt4=4;
                }
                break;
            case Record:
                {
                alt4=5;
                }
                break;
            case Union:
                {
                alt4=6;
                }
                break;
            case Tuple:
                {
                alt4=7;
                }
                break;
            case List:
                {
                alt4=8;
                }
                break;
            case Set:
                {
                alt4=9;
                }
                break;
            case Bag:
                {
                alt4=10;
                }
                break;
            case Map:
                {
                alt4=11;
                }
                break;
            case RULE_ID:
                {
                alt4=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalExprParser.g:2059:1: ( rulePrimitiveType )
                    {
                    // InternalExprParser.g:2059:1: ( rulePrimitiveType )
                    // InternalExprParser.g:2060:1: rulePrimitiveType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAccess().getPrimitiveTypeParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulePrimitiveType();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeAccess().getPrimitiveTypeParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2065:6: ( ruleCategory )
                    {
                    // InternalExprParser.g:2065:6: ( ruleCategory )
                    // InternalExprParser.g:2066:1: ruleCategory
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAccess().getCategoryParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleCategory();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeAccess().getCategoryParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalExprParser.g:2071:6: ( ruleMetaClass )
                    {
                    // InternalExprParser.g:2071:6: ( ruleMetaClass )
                    // InternalExprParser.g:2072:1: ruleMetaClass
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAccess().getMetaClassParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleMetaClass();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeAccess().getMetaClassParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalExprParser.g:2077:6: ( ruleClassifierType )
                    {
                    // InternalExprParser.g:2077:6: ( ruleClassifierType )
                    // InternalExprParser.g:2078:1: ruleClassifierType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAccess().getClassifierTypeParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleClassifierType();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeAccess().getClassifierTypeParserRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalExprParser.g:2083:6: ( ruleRecordType )
                    {
                    // InternalExprParser.g:2083:6: ( ruleRecordType )
                    // InternalExprParser.g:2084:1: ruleRecordType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAccess().getRecordTypeParserRuleCall_4()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleRecordType();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeAccess().getRecordTypeParserRuleCall_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalExprParser.g:2089:6: ( ruleUnionType )
                    {
                    // InternalExprParser.g:2089:6: ( ruleUnionType )
                    // InternalExprParser.g:2090:1: ruleUnionType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAccess().getUnionTypeParserRuleCall_5()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleUnionType();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeAccess().getUnionTypeParserRuleCall_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalExprParser.g:2095:6: ( ruleTupleType )
                    {
                    // InternalExprParser.g:2095:6: ( ruleTupleType )
                    // InternalExprParser.g:2096:1: ruleTupleType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAccess().getTupleTypeParserRuleCall_6()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleTupleType();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeAccess().getTupleTypeParserRuleCall_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalExprParser.g:2101:6: ( ruleListType )
                    {
                    // InternalExprParser.g:2101:6: ( ruleListType )
                    // InternalExprParser.g:2102:1: ruleListType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAccess().getListTypeParserRuleCall_7()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleListType();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeAccess().getListTypeParserRuleCall_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalExprParser.g:2107:6: ( ruleSetType )
                    {
                    // InternalExprParser.g:2107:6: ( ruleSetType )
                    // InternalExprParser.g:2108:1: ruleSetType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAccess().getSetTypeParserRuleCall_8()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleSetType();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeAccess().getSetTypeParserRuleCall_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalExprParser.g:2113:6: ( ruleBagType )
                    {
                    // InternalExprParser.g:2113:6: ( ruleBagType )
                    // InternalExprParser.g:2114:1: ruleBagType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAccess().getBagTypeParserRuleCall_9()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleBagType();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeAccess().getBagTypeParserRuleCall_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalExprParser.g:2119:6: ( ruleMapType )
                    {
                    // InternalExprParser.g:2119:6: ( ruleMapType )
                    // InternalExprParser.g:2120:1: ruleMapType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAccess().getMapTypeParserRuleCall_10()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleMapType();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeAccess().getMapTypeParserRuleCall_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalExprParser.g:2125:6: ( ruleTypeRef )
                    {
                    // InternalExprParser.g:2125:6: ( ruleTypeRef )
                    // InternalExprParser.g:2126:1: ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAccess().getTypeRefParserRuleCall_11()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeAccess().getTypeRefParserRuleCall_11()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Alternatives"


    // $ANTLR start "rule__PrimitiveType__Alternatives"
    // InternalExprParser.g:2136:1: rule__PrimitiveType__Alternatives : ( ( ( rule__PrimitiveType__Group_0__0 ) ) | ( ( rule__PrimitiveType__Group_1__0 ) ) | ( ( rule__PrimitiveType__Group_2__0 ) ) | ( ( rule__PrimitiveType__Group_3__0 ) ) );
    public final void rule__PrimitiveType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2140:1: ( ( ( rule__PrimitiveType__Group_0__0 ) ) | ( ( rule__PrimitiveType__Group_1__0 ) ) | ( ( rule__PrimitiveType__Group_2__0 ) ) | ( ( rule__PrimitiveType__Group_3__0 ) ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case Bool:
                {
                alt5=1;
                }
                break;
            case Int:
                {
                alt5=2;
                }
                break;
            case Real:
                {
                alt5=3;
                }
                break;
            case String:
                {
                alt5=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalExprParser.g:2141:1: ( ( rule__PrimitiveType__Group_0__0 ) )
                    {
                    // InternalExprParser.g:2141:1: ( ( rule__PrimitiveType__Group_0__0 ) )
                    // InternalExprParser.g:2142:1: ( rule__PrimitiveType__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimitiveTypeAccess().getGroup_0()); 
                    }
                    // InternalExprParser.g:2143:1: ( rule__PrimitiveType__Group_0__0 )
                    // InternalExprParser.g:2143:2: rule__PrimitiveType__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveType__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimitiveTypeAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2147:6: ( ( rule__PrimitiveType__Group_1__0 ) )
                    {
                    // InternalExprParser.g:2147:6: ( ( rule__PrimitiveType__Group_1__0 ) )
                    // InternalExprParser.g:2148:1: ( rule__PrimitiveType__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimitiveTypeAccess().getGroup_1()); 
                    }
                    // InternalExprParser.g:2149:1: ( rule__PrimitiveType__Group_1__0 )
                    // InternalExprParser.g:2149:2: rule__PrimitiveType__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveType__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimitiveTypeAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalExprParser.g:2153:6: ( ( rule__PrimitiveType__Group_2__0 ) )
                    {
                    // InternalExprParser.g:2153:6: ( ( rule__PrimitiveType__Group_2__0 ) )
                    // InternalExprParser.g:2154:1: ( rule__PrimitiveType__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimitiveTypeAccess().getGroup_2()); 
                    }
                    // InternalExprParser.g:2155:1: ( rule__PrimitiveType__Group_2__0 )
                    // InternalExprParser.g:2155:2: rule__PrimitiveType__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveType__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimitiveTypeAccess().getGroup_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalExprParser.g:2159:6: ( ( rule__PrimitiveType__Group_3__0 ) )
                    {
                    // InternalExprParser.g:2159:6: ( ( rule__PrimitiveType__Group_3__0 ) )
                    // InternalExprParser.g:2160:1: ( rule__PrimitiveType__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimitiveTypeAccess().getGroup_3()); 
                    }
                    // InternalExprParser.g:2161:1: ( rule__PrimitiveType__Group_3__0 )
                    // InternalExprParser.g:2161:2: rule__PrimitiveType__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveType__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimitiveTypeAccess().getGroup_3()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Alternatives"


    // $ANTLR start "rule__ComponentCategory__Alternatives"
    // InternalExprParser.g:2170:1: rule__ComponentCategory__Alternatives : ( ( Abstract ) | ( Bus ) | ( Data ) | ( Device ) | ( Memory ) | ( Process ) | ( Processor ) | ( Subprogram ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( KW_System ) | ( ( rule__ComponentCategory__Group_10__0 ) ) | ( Thread ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( ( rule__ComponentCategory__Group_13__0 ) ) );
    public final void rule__ComponentCategory__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2174:1: ( ( Abstract ) | ( Bus ) | ( Data ) | ( Device ) | ( Memory ) | ( Process ) | ( Processor ) | ( Subprogram ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( KW_System ) | ( ( rule__ComponentCategory__Group_10__0 ) ) | ( Thread ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( ( rule__ComponentCategory__Group_13__0 ) ) )
            int alt6=14;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalExprParser.g:2175:1: ( Abstract )
                    {
                    // InternalExprParser.g:2175:1: ( Abstract )
                    // InternalExprParser.g:2176:1: Abstract
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
                    }
                    match(input,Abstract,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2183:6: ( Bus )
                    {
                    // InternalExprParser.g:2183:6: ( Bus )
                    // InternalExprParser.g:2184:1: Bus
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
                    }
                    match(input,Bus,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalExprParser.g:2191:6: ( Data )
                    {
                    // InternalExprParser.g:2191:6: ( Data )
                    // InternalExprParser.g:2192:1: Data
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
                    }
                    match(input,Data,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalExprParser.g:2199:6: ( Device )
                    {
                    // InternalExprParser.g:2199:6: ( Device )
                    // InternalExprParser.g:2200:1: Device
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
                    }
                    match(input,Device,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalExprParser.g:2207:6: ( Memory )
                    {
                    // InternalExprParser.g:2207:6: ( Memory )
                    // InternalExprParser.g:2208:1: Memory
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
                    }
                    match(input,Memory,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalExprParser.g:2215:6: ( Process )
                    {
                    // InternalExprParser.g:2215:6: ( Process )
                    // InternalExprParser.g:2216:1: Process
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
                    }
                    match(input,Process,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalExprParser.g:2223:6: ( Processor )
                    {
                    // InternalExprParser.g:2223:6: ( Processor )
                    // InternalExprParser.g:2224:1: Processor
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
                    }
                    match(input,Processor,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalExprParser.g:2231:6: ( Subprogram )
                    {
                    // InternalExprParser.g:2231:6: ( Subprogram )
                    // InternalExprParser.g:2232:1: Subprogram
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
                    }
                    match(input,Subprogram,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalExprParser.g:2239:6: ( ( rule__ComponentCategory__Group_8__0 ) )
                    {
                    // InternalExprParser.g:2239:6: ( ( rule__ComponentCategory__Group_8__0 ) )
                    // InternalExprParser.g:2240:1: ( rule__ComponentCategory__Group_8__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComponentCategoryAccess().getGroup_8()); 
                    }
                    // InternalExprParser.g:2241:1: ( rule__ComponentCategory__Group_8__0 )
                    // InternalExprParser.g:2241:2: rule__ComponentCategory__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ComponentCategory__Group_8__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComponentCategoryAccess().getGroup_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalExprParser.g:2245:6: ( KW_System )
                    {
                    // InternalExprParser.g:2245:6: ( KW_System )
                    // InternalExprParser.g:2246:1: KW_System
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
                    }
                    match(input,KW_System,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalExprParser.g:2253:6: ( ( rule__ComponentCategory__Group_10__0 ) )
                    {
                    // InternalExprParser.g:2253:6: ( ( rule__ComponentCategory__Group_10__0 ) )
                    // InternalExprParser.g:2254:1: ( rule__ComponentCategory__Group_10__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComponentCategoryAccess().getGroup_10()); 
                    }
                    // InternalExprParser.g:2255:1: ( rule__ComponentCategory__Group_10__0 )
                    // InternalExprParser.g:2255:2: rule__ComponentCategory__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ComponentCategory__Group_10__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComponentCategoryAccess().getGroup_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalExprParser.g:2259:6: ( Thread )
                    {
                    // InternalExprParser.g:2259:6: ( Thread )
                    // InternalExprParser.g:2260:1: Thread
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
                    }
                    match(input,Thread,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalExprParser.g:2267:6: ( ( rule__ComponentCategory__Group_12__0 ) )
                    {
                    // InternalExprParser.g:2267:6: ( ( rule__ComponentCategory__Group_12__0 ) )
                    // InternalExprParser.g:2268:1: ( rule__ComponentCategory__Group_12__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComponentCategoryAccess().getGroup_12()); 
                    }
                    // InternalExprParser.g:2269:1: ( rule__ComponentCategory__Group_12__0 )
                    // InternalExprParser.g:2269:2: rule__ComponentCategory__Group_12__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ComponentCategory__Group_12__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComponentCategoryAccess().getGroup_12()); 
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalExprParser.g:2273:6: ( ( rule__ComponentCategory__Group_13__0 ) )
                    {
                    // InternalExprParser.g:2273:6: ( ( rule__ComponentCategory__Group_13__0 ) )
                    // InternalExprParser.g:2274:1: ( rule__ComponentCategory__Group_13__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComponentCategoryAccess().getGroup_13()); 
                    }
                    // InternalExprParser.g:2275:1: ( rule__ComponentCategory__Group_13__0 )
                    // InternalExprParser.g:2275:2: rule__ComponentCategory__Group_13__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ComponentCategory__Group_13__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComponentCategoryAccess().getGroup_13()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategory__Alternatives"


    // $ANTLR start "rule__OpOr__Alternatives"
    // InternalExprParser.g:2284:1: rule__OpOr__Alternatives : ( ( Or ) | ( VerticalLineVerticalLine ) );
    public final void rule__OpOr__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2288:1: ( ( Or ) | ( VerticalLineVerticalLine ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Or) ) {
                alt7=1;
            }
            else if ( (LA7_0==VerticalLineVerticalLine) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalExprParser.g:2289:1: ( Or )
                    {
                    // InternalExprParser.g:2289:1: ( Or )
                    // InternalExprParser.g:2290:1: Or
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOrAccess().getOrKeyword_0()); 
                    }
                    match(input,Or,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOrAccess().getOrKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2297:6: ( VerticalLineVerticalLine )
                    {
                    // InternalExprParser.g:2297:6: ( VerticalLineVerticalLine )
                    // InternalExprParser.g:2298:1: VerticalLineVerticalLine
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword_1()); 
                    }
                    match(input,VerticalLineVerticalLine,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpOr__Alternatives"


    // $ANTLR start "rule__OpAnd__Alternatives"
    // InternalExprParser.g:2310:1: rule__OpAnd__Alternatives : ( ( And ) | ( AmpersandAmpersand ) );
    public final void rule__OpAnd__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2314:1: ( ( And ) | ( AmpersandAmpersand ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==And) ) {
                alt8=1;
            }
            else if ( (LA8_0==AmpersandAmpersand) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalExprParser.g:2315:1: ( And )
                    {
                    // InternalExprParser.g:2315:1: ( And )
                    // InternalExprParser.g:2316:1: And
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpAndAccess().getAndKeyword_0()); 
                    }
                    match(input,And,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpAndAccess().getAndKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2323:6: ( AmpersandAmpersand )
                    {
                    // InternalExprParser.g:2323:6: ( AmpersandAmpersand )
                    // InternalExprParser.g:2324:1: AmpersandAmpersand
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword_1()); 
                    }
                    match(input,AmpersandAmpersand,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpAnd__Alternatives"


    // $ANTLR start "rule__OpEquality__Alternatives"
    // InternalExprParser.g:2336:1: rule__OpEquality__Alternatives : ( ( EqualsSignEqualsSign ) | ( ExclamationMarkEqualsSign ) );
    public final void rule__OpEquality__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2340:1: ( ( EqualsSignEqualsSign ) | ( ExclamationMarkEqualsSign ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==EqualsSignEqualsSign) ) {
                alt9=1;
            }
            else if ( (LA9_0==ExclamationMarkEqualsSign) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalExprParser.g:2341:1: ( EqualsSignEqualsSign )
                    {
                    // InternalExprParser.g:2341:1: ( EqualsSignEqualsSign )
                    // InternalExprParser.g:2342:1: EqualsSignEqualsSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                    }
                    match(input,EqualsSignEqualsSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2349:6: ( ExclamationMarkEqualsSign )
                    {
                    // InternalExprParser.g:2349:6: ( ExclamationMarkEqualsSign )
                    // InternalExprParser.g:2350:1: ExclamationMarkEqualsSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); 
                    }
                    match(input,ExclamationMarkEqualsSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpEquality__Alternatives"


    // $ANTLR start "rule__OpCompare__Alternatives"
    // InternalExprParser.g:2362:1: rule__OpCompare__Alternatives : ( ( GreaterThanSignEqualsSign ) | ( LessThanSignEqualsSign ) | ( GreaterThanSign ) | ( LessThanSign ) | ( GreaterThanSignLessThanSign ) );
    public final void rule__OpCompare__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2366:1: ( ( GreaterThanSignEqualsSign ) | ( LessThanSignEqualsSign ) | ( GreaterThanSign ) | ( LessThanSign ) | ( GreaterThanSignLessThanSign ) )
            int alt10=5;
            switch ( input.LA(1) ) {
            case GreaterThanSignEqualsSign:
                {
                alt10=1;
                }
                break;
            case LessThanSignEqualsSign:
                {
                alt10=2;
                }
                break;
            case GreaterThanSign:
                {
                alt10=3;
                }
                break;
            case LessThanSign:
                {
                alt10=4;
                }
                break;
            case GreaterThanSignLessThanSign:
                {
                alt10=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalExprParser.g:2367:1: ( GreaterThanSignEqualsSign )
                    {
                    // InternalExprParser.g:2367:1: ( GreaterThanSignEqualsSign )
                    // InternalExprParser.g:2368:1: GreaterThanSignEqualsSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                    }
                    match(input,GreaterThanSignEqualsSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2375:6: ( LessThanSignEqualsSign )
                    {
                    // InternalExprParser.g:2375:6: ( LessThanSignEqualsSign )
                    // InternalExprParser.g:2376:1: LessThanSignEqualsSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); 
                    }
                    match(input,LessThanSignEqualsSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalExprParser.g:2383:6: ( GreaterThanSign )
                    {
                    // InternalExprParser.g:2383:6: ( GreaterThanSign )
                    // InternalExprParser.g:2384:1: GreaterThanSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                    }
                    match(input,GreaterThanSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalExprParser.g:2391:6: ( LessThanSign )
                    {
                    // InternalExprParser.g:2391:6: ( LessThanSign )
                    // InternalExprParser.g:2392:1: LessThanSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); 
                    }
                    match(input,LessThanSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalExprParser.g:2399:6: ( GreaterThanSignLessThanSign )
                    {
                    // InternalExprParser.g:2399:6: ( GreaterThanSignLessThanSign )
                    // InternalExprParser.g:2400:1: GreaterThanSignLessThanSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpCompareAccess().getGreaterThanSignLessThanSignKeyword_4()); 
                    }
                    match(input,GreaterThanSignLessThanSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpCompareAccess().getGreaterThanSignLessThanSignKeyword_4()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpCompare__Alternatives"


    // $ANTLR start "rule__OpAdd__Alternatives"
    // InternalExprParser.g:2412:1: rule__OpAdd__Alternatives : ( ( PlusSign ) | ( HyphenMinus ) );
    public final void rule__OpAdd__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2416:1: ( ( PlusSign ) | ( HyphenMinus ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==PlusSign) ) {
                alt11=1;
            }
            else if ( (LA11_0==HyphenMinus) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalExprParser.g:2417:1: ( PlusSign )
                    {
                    // InternalExprParser.g:2417:1: ( PlusSign )
                    // InternalExprParser.g:2418:1: PlusSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                    }
                    match(input,PlusSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2425:6: ( HyphenMinus )
                    {
                    // InternalExprParser.g:2425:6: ( HyphenMinus )
                    // InternalExprParser.g:2426:1: HyphenMinus
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1()); 
                    }
                    match(input,HyphenMinus,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpAdd__Alternatives"


    // $ANTLR start "rule__OpMulti__Alternatives"
    // InternalExprParser.g:2438:1: rule__OpMulti__Alternatives : ( ( Asterisk ) | ( Solidus ) | ( Div ) | ( Mod ) );
    public final void rule__OpMulti__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2442:1: ( ( Asterisk ) | ( Solidus ) | ( Div ) | ( Mod ) )
            int alt12=4;
            switch ( input.LA(1) ) {
            case Asterisk:
                {
                alt12=1;
                }
                break;
            case Solidus:
                {
                alt12=2;
                }
                break;
            case Div:
                {
                alt12=3;
                }
                break;
            case Mod:
                {
                alt12=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalExprParser.g:2443:1: ( Asterisk )
                    {
                    // InternalExprParser.g:2443:1: ( Asterisk )
                    // InternalExprParser.g:2444:1: Asterisk
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                    }
                    match(input,Asterisk,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2451:6: ( Solidus )
                    {
                    // InternalExprParser.g:2451:6: ( Solidus )
                    // InternalExprParser.g:2452:1: Solidus
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAccess().getSolidusKeyword_1()); 
                    }
                    match(input,Solidus,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAccess().getSolidusKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalExprParser.g:2459:6: ( Div )
                    {
                    // InternalExprParser.g:2459:6: ( Div )
                    // InternalExprParser.g:2460:1: Div
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAccess().getDivKeyword_2()); 
                    }
                    match(input,Div,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAccess().getDivKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalExprParser.g:2467:6: ( Mod )
                    {
                    // InternalExprParser.g:2467:6: ( Mod )
                    // InternalExprParser.g:2468:1: Mod
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAccess().getModKeyword_3()); 
                    }
                    match(input,Mod,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAccess().getModKeyword_3()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpMulti__Alternatives"


    // $ANTLR start "rule__UnaryOperation__Alternatives"
    // InternalExprParser.g:2480:1: rule__UnaryOperation__Alternatives : ( ( ( rule__UnaryOperation__Group_0__0 ) ) | ( ruleUnitExpression ) );
    public final void rule__UnaryOperation__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2484:1: ( ( ( rule__UnaryOperation__Group_0__0 ) ) | ( ruleUnitExpression ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==Not||LA13_0==PlusSign||LA13_0==HyphenMinus) ) {
                alt13=1;
            }
            else if ( (LA13_0==Record||LA13_0==False||(LA13_0>=Tuple && LA13_0<=Union)||LA13_0==List||(LA13_0>=This && LA13_0<=True)||LA13_0==Bag||LA13_0==Map||LA13_0==Set||LA13_0==If||LA13_0==NumberSign||LA13_0==LeftParenthesis||LA13_0==LeftSquareBracket||LA13_0==RULE_REAL_LIT||LA13_0==RULE_INTEGER_LIT||(LA13_0>=RULE_STRING && LA13_0<=RULE_ID)) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalExprParser.g:2485:1: ( ( rule__UnaryOperation__Group_0__0 ) )
                    {
                    // InternalExprParser.g:2485:1: ( ( rule__UnaryOperation__Group_0__0 ) )
                    // InternalExprParser.g:2486:1: ( rule__UnaryOperation__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUnaryOperationAccess().getGroup_0()); 
                    }
                    // InternalExprParser.g:2487:1: ( rule__UnaryOperation__Group_0__0 )
                    // InternalExprParser.g:2487:2: rule__UnaryOperation__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__UnaryOperation__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUnaryOperationAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2491:6: ( ruleUnitExpression )
                    {
                    // InternalExprParser.g:2491:6: ( ruleUnitExpression )
                    // InternalExprParser.g:2492:1: ruleUnitExpression
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUnaryOperationAccess().getUnitExpressionParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleUnitExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUnaryOperationAccess().getUnitExpressionParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryOperation__Alternatives"


    // $ANTLR start "rule__OpUnary__Alternatives"
    // InternalExprParser.g:2502:1: rule__OpUnary__Alternatives : ( ( Not ) | ( HyphenMinus ) | ( PlusSign ) );
    public final void rule__OpUnary__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2506:1: ( ( Not ) | ( HyphenMinus ) | ( PlusSign ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case Not:
                {
                alt14=1;
                }
                break;
            case HyphenMinus:
                {
                alt14=2;
                }
                break;
            case PlusSign:
                {
                alt14=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalExprParser.g:2507:1: ( Not )
                    {
                    // InternalExprParser.g:2507:1: ( Not )
                    // InternalExprParser.g:2508:1: Not
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpUnaryAccess().getNotKeyword_0()); 
                    }
                    match(input,Not,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpUnaryAccess().getNotKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2515:6: ( HyphenMinus )
                    {
                    // InternalExprParser.g:2515:6: ( HyphenMinus )
                    // InternalExprParser.g:2516:1: HyphenMinus
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                    }
                    match(input,HyphenMinus,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalExprParser.g:2523:6: ( PlusSign )
                    {
                    // InternalExprParser.g:2523:6: ( PlusSign )
                    // InternalExprParser.g:2524:1: PlusSign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2()); 
                    }
                    match(input,PlusSign,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpUnary__Alternatives"


    // $ANTLR start "rule__UnitExpression__Alternatives_1_1"
    // InternalExprParser.g:2536:1: rule__UnitExpression__Alternatives_1_1 : ( ( ( rule__UnitExpression__ConvertAssignment_1_1_0 ) ) | ( ( rule__UnitExpression__DropAssignment_1_1_1 ) ) );
    public final void rule__UnitExpression__Alternatives_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2540:1: ( ( ( rule__UnitExpression__ConvertAssignment_1_1_0 ) ) | ( ( rule__UnitExpression__DropAssignment_1_1_1 ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==PercentSign) ) {
                alt15=1;
            }
            else if ( (LA15_0==In) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalExprParser.g:2541:1: ( ( rule__UnitExpression__ConvertAssignment_1_1_0 ) )
                    {
                    // InternalExprParser.g:2541:1: ( ( rule__UnitExpression__ConvertAssignment_1_1_0 ) )
                    // InternalExprParser.g:2542:1: ( rule__UnitExpression__ConvertAssignment_1_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUnitExpressionAccess().getConvertAssignment_1_1_0()); 
                    }
                    // InternalExprParser.g:2543:1: ( rule__UnitExpression__ConvertAssignment_1_1_0 )
                    // InternalExprParser.g:2543:2: rule__UnitExpression__ConvertAssignment_1_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__UnitExpression__ConvertAssignment_1_1_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUnitExpressionAccess().getConvertAssignment_1_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2547:6: ( ( rule__UnitExpression__DropAssignment_1_1_1 ) )
                    {
                    // InternalExprParser.g:2547:6: ( ( rule__UnitExpression__DropAssignment_1_1_1 ) )
                    // InternalExprParser.g:2548:1: ( rule__UnitExpression__DropAssignment_1_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUnitExpressionAccess().getDropAssignment_1_1_1()); 
                    }
                    // InternalExprParser.g:2549:1: ( rule__UnitExpression__DropAssignment_1_1_1 )
                    // InternalExprParser.g:2549:2: rule__UnitExpression__DropAssignment_1_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__UnitExpression__DropAssignment_1_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUnitExpressionAccess().getDropAssignment_1_1_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnitExpression__Alternatives_1_1"


    // $ANTLR start "rule__PrimaryExpression__Alternatives"
    // InternalExprParser.g:2558:1: rule__PrimaryExpression__Alternatives : ( ( ruleVarRef ) | ( ruleModelOrPropertyReference ) | ( ruleFunctionCall ) | ( ruleRangeExpression ) | ( ruleIfExpression ) | ( ruleLiteral ) | ( ( rule__PrimaryExpression__Group_6__0 ) ) );
    public final void rule__PrimaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2562:1: ( ( ruleVarRef ) | ( ruleModelOrPropertyReference ) | ( ruleFunctionCall ) | ( ruleRangeExpression ) | ( ruleIfExpression ) | ( ruleLiteral ) | ( ( rule__PrimaryExpression__Group_6__0 ) ) )
            int alt16=7;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // InternalExprParser.g:2563:1: ( ruleVarRef )
                    {
                    // InternalExprParser.g:2563:1: ( ruleVarRef )
                    // InternalExprParser.g:2564:1: ruleVarRef
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpressionAccess().getVarRefParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleVarRef();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryExpressionAccess().getVarRefParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2569:6: ( ruleModelOrPropertyReference )
                    {
                    // InternalExprParser.g:2569:6: ( ruleModelOrPropertyReference )
                    // InternalExprParser.g:2570:1: ruleModelOrPropertyReference
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpressionAccess().getModelOrPropertyReferenceParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleModelOrPropertyReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryExpressionAccess().getModelOrPropertyReferenceParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalExprParser.g:2575:6: ( ruleFunctionCall )
                    {
                    // InternalExprParser.g:2575:6: ( ruleFunctionCall )
                    // InternalExprParser.g:2576:1: ruleFunctionCall
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpressionAccess().getFunctionCallParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleFunctionCall();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryExpressionAccess().getFunctionCallParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalExprParser.g:2581:6: ( ruleRangeExpression )
                    {
                    // InternalExprParser.g:2581:6: ( ruleRangeExpression )
                    // InternalExprParser.g:2582:1: ruleRangeExpression
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpressionAccess().getRangeExpressionParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleRangeExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryExpressionAccess().getRangeExpressionParserRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalExprParser.g:2587:6: ( ruleIfExpression )
                    {
                    // InternalExprParser.g:2587:6: ( ruleIfExpression )
                    // InternalExprParser.g:2588:1: ruleIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpressionAccess().getIfExpressionParserRuleCall_4()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleIfExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryExpressionAccess().getIfExpressionParserRuleCall_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalExprParser.g:2593:6: ( ruleLiteral )
                    {
                    // InternalExprParser.g:2593:6: ( ruleLiteral )
                    // InternalExprParser.g:2594:1: ruleLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_5()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalExprParser.g:2599:6: ( ( rule__PrimaryExpression__Group_6__0 ) )
                    {
                    // InternalExprParser.g:2599:6: ( ( rule__PrimaryExpression__Group_6__0 ) )
                    // InternalExprParser.g:2600:1: ( rule__PrimaryExpression__Group_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpressionAccess().getGroup_6()); 
                    }
                    // InternalExprParser.g:2601:1: ( rule__PrimaryExpression__Group_6__0 )
                    // InternalExprParser.g:2601:2: rule__PrimaryExpression__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimaryExpression__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryExpressionAccess().getGroup_6()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Alternatives"


    // $ANTLR start "rule__ModelOrPropertyReference__Alternatives"
    // InternalExprParser.g:2610:1: rule__ModelOrPropertyReference__Alternatives : ( ( ( rule__ModelOrPropertyReference__Group_0__0 ) ) | ( rulePropertyReference ) );
    public final void rule__ModelOrPropertyReference__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2614:1: ( ( ( rule__ModelOrPropertyReference__Group_0__0 ) ) | ( rulePropertyReference ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==This) ) {
                alt17=1;
            }
            else if ( (LA17_0==NumberSign) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalExprParser.g:2615:1: ( ( rule__ModelOrPropertyReference__Group_0__0 ) )
                    {
                    // InternalExprParser.g:2615:1: ( ( rule__ModelOrPropertyReference__Group_0__0 ) )
                    // InternalExprParser.g:2616:1: ( rule__ModelOrPropertyReference__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModelOrPropertyReferenceAccess().getGroup_0()); 
                    }
                    // InternalExprParser.g:2617:1: ( rule__ModelOrPropertyReference__Group_0__0 )
                    // InternalExprParser.g:2617:2: rule__ModelOrPropertyReference__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ModelOrPropertyReference__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getModelOrPropertyReferenceAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2621:6: ( rulePropertyReference )
                    {
                    // InternalExprParser.g:2621:6: ( rulePropertyReference )
                    // InternalExprParser.g:2622:1: rulePropertyReference
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModelOrPropertyReferenceAccess().getPropertyReferenceParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulePropertyReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getModelOrPropertyReferenceAccess().getPropertyReferenceParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelOrPropertyReference__Alternatives"


    // $ANTLR start "rule__Literal__Alternatives"
    // InternalExprParser.g:2632:1: rule__Literal__Alternatives : ( ( ruleBooleanLiteral ) | ( ruleIntegerLiteral ) | ( ruleRealLiteral ) | ( ruleStringLiteral ) | ( ruleListLiteral ) | ( ruleSetLiteral ) | ( ruleRecordLiteral ) | ( ruleUnionLiteral ) | ( ruleTupleLiteral ) | ( ruleBagLiteral ) | ( ruleMapLiteral ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2636:1: ( ( ruleBooleanLiteral ) | ( ruleIntegerLiteral ) | ( ruleRealLiteral ) | ( ruleStringLiteral ) | ( ruleListLiteral ) | ( ruleSetLiteral ) | ( ruleRecordLiteral ) | ( ruleUnionLiteral ) | ( ruleTupleLiteral ) | ( ruleBagLiteral ) | ( ruleMapLiteral ) )
            int alt18=11;
            switch ( input.LA(1) ) {
            case False:
            case True:
                {
                alt18=1;
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt18=2;
                }
                break;
            case RULE_REAL_LIT:
                {
                alt18=3;
                }
                break;
            case RULE_STRING:
                {
                alt18=4;
                }
                break;
            case List:
                {
                alt18=5;
                }
                break;
            case Set:
                {
                alt18=6;
                }
                break;
            case Record:
                {
                alt18=7;
                }
                break;
            case Union:
                {
                alt18=8;
                }
                break;
            case Tuple:
                {
                alt18=9;
                }
                break;
            case Bag:
                {
                alt18=10;
                }
                break;
            case Map:
                {
                alt18=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalExprParser.g:2637:1: ( ruleBooleanLiteral )
                    {
                    // InternalExprParser.g:2637:1: ( ruleBooleanLiteral )
                    // InternalExprParser.g:2638:1: ruleBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2643:6: ( ruleIntegerLiteral )
                    {
                    // InternalExprParser.g:2643:6: ( ruleIntegerLiteral )
                    // InternalExprParser.g:2644:1: ruleIntegerLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getIntegerLiteralParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleIntegerLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getIntegerLiteralParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalExprParser.g:2649:6: ( ruleRealLiteral )
                    {
                    // InternalExprParser.g:2649:6: ( ruleRealLiteral )
                    // InternalExprParser.g:2650:1: ruleRealLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getRealLiteralParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleRealLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getRealLiteralParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalExprParser.g:2655:6: ( ruleStringLiteral )
                    {
                    // InternalExprParser.g:2655:6: ( ruleStringLiteral )
                    // InternalExprParser.g:2656:1: ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleStringLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalExprParser.g:2661:6: ( ruleListLiteral )
                    {
                    // InternalExprParser.g:2661:6: ( ruleListLiteral )
                    // InternalExprParser.g:2662:1: ruleListLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getListLiteralParserRuleCall_4()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleListLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getListLiteralParserRuleCall_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalExprParser.g:2667:6: ( ruleSetLiteral )
                    {
                    // InternalExprParser.g:2667:6: ( ruleSetLiteral )
                    // InternalExprParser.g:2668:1: ruleSetLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getSetLiteralParserRuleCall_5()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleSetLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getSetLiteralParserRuleCall_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalExprParser.g:2673:6: ( ruleRecordLiteral )
                    {
                    // InternalExprParser.g:2673:6: ( ruleRecordLiteral )
                    // InternalExprParser.g:2674:1: ruleRecordLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getRecordLiteralParserRuleCall_6()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleRecordLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getRecordLiteralParserRuleCall_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalExprParser.g:2679:6: ( ruleUnionLiteral )
                    {
                    // InternalExprParser.g:2679:6: ( ruleUnionLiteral )
                    // InternalExprParser.g:2680:1: ruleUnionLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getUnionLiteralParserRuleCall_7()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleUnionLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getUnionLiteralParserRuleCall_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalExprParser.g:2685:6: ( ruleTupleLiteral )
                    {
                    // InternalExprParser.g:2685:6: ( ruleTupleLiteral )
                    // InternalExprParser.g:2686:1: ruleTupleLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getTupleLiteralParserRuleCall_8()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleTupleLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getTupleLiteralParserRuleCall_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalExprParser.g:2691:6: ( ruleBagLiteral )
                    {
                    // InternalExprParser.g:2691:6: ( ruleBagLiteral )
                    // InternalExprParser.g:2692:1: ruleBagLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getBagLiteralParserRuleCall_9()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleBagLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getBagLiteralParserRuleCall_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalExprParser.g:2697:6: ( ruleMapLiteral )
                    {
                    // InternalExprParser.g:2697:6: ( ruleMapLiteral )
                    // InternalExprParser.g:2698:1: ruleMapLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getMapLiteralParserRuleCall_10()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleMapLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getMapLiteralParserRuleCall_10()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Alternatives"


    // $ANTLR start "rule__BooleanLiteral__Alternatives_1"
    // InternalExprParser.g:2708:1: rule__BooleanLiteral__Alternatives_1 : ( ( ( rule__BooleanLiteral__ValueAssignment_1_0 ) ) | ( False ) );
    public final void rule__BooleanLiteral__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2712:1: ( ( ( rule__BooleanLiteral__ValueAssignment_1_0 ) ) | ( False ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==True) ) {
                alt19=1;
            }
            else if ( (LA19_0==False) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalExprParser.g:2713:1: ( ( rule__BooleanLiteral__ValueAssignment_1_0 ) )
                    {
                    // InternalExprParser.g:2713:1: ( ( rule__BooleanLiteral__ValueAssignment_1_0 ) )
                    // InternalExprParser.g:2714:1: ( rule__BooleanLiteral__ValueAssignment_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralAccess().getValueAssignment_1_0()); 
                    }
                    // InternalExprParser.g:2715:1: ( rule__BooleanLiteral__ValueAssignment_1_0 )
                    // InternalExprParser.g:2715:2: rule__BooleanLiteral__ValueAssignment_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BooleanLiteral__ValueAssignment_1_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBooleanLiteralAccess().getValueAssignment_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2719:6: ( False )
                    {
                    // InternalExprParser.g:2719:6: ( False )
                    // InternalExprParser.g:2720:1: False
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_1()); 
                    }
                    match(input,False,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteral__Alternatives_1"


    // $ANTLR start "rule__MetaClassEnum__Alternatives"
    // InternalExprParser.g:2732:1: rule__MetaClassEnum__Alternatives : ( ( ( Component ) ) | ( ( Subcomponent ) ) | ( ( Feature ) ) | ( ( Connection ) ) | ( ( Flow ) ) | ( ( Mode ) ) );
    public final void rule__MetaClassEnum__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2736:1: ( ( ( Component ) ) | ( ( Subcomponent ) ) | ( ( Feature ) ) | ( ( Connection ) ) | ( ( Flow ) ) | ( ( Mode ) ) )
            int alt20=6;
            switch ( input.LA(1) ) {
            case Component:
                {
                alt20=1;
                }
                break;
            case Subcomponent:
                {
                alt20=2;
                }
                break;
            case Feature:
                {
                alt20=3;
                }
                break;
            case Connection:
                {
                alt20=4;
                }
                break;
            case Flow:
                {
                alt20=5;
                }
                break;
            case Mode:
                {
                alt20=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalExprParser.g:2737:1: ( ( Component ) )
                    {
                    // InternalExprParser.g:2737:1: ( ( Component ) )
                    // InternalExprParser.g:2738:1: ( Component )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMetaClassEnumAccess().getCOMPONENTEnumLiteralDeclaration_0()); 
                    }
                    // InternalExprParser.g:2739:1: ( Component )
                    // InternalExprParser.g:2739:3: Component
                    {
                    match(input,Component,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMetaClassEnumAccess().getCOMPONENTEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2744:6: ( ( Subcomponent ) )
                    {
                    // InternalExprParser.g:2744:6: ( ( Subcomponent ) )
                    // InternalExprParser.g:2745:1: ( Subcomponent )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMetaClassEnumAccess().getSUBCOMPONENTEnumLiteralDeclaration_1()); 
                    }
                    // InternalExprParser.g:2746:1: ( Subcomponent )
                    // InternalExprParser.g:2746:3: Subcomponent
                    {
                    match(input,Subcomponent,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMetaClassEnumAccess().getSUBCOMPONENTEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalExprParser.g:2751:6: ( ( Feature ) )
                    {
                    // InternalExprParser.g:2751:6: ( ( Feature ) )
                    // InternalExprParser.g:2752:1: ( Feature )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMetaClassEnumAccess().getFEATUREEnumLiteralDeclaration_2()); 
                    }
                    // InternalExprParser.g:2753:1: ( Feature )
                    // InternalExprParser.g:2753:3: Feature
                    {
                    match(input,Feature,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMetaClassEnumAccess().getFEATUREEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalExprParser.g:2758:6: ( ( Connection ) )
                    {
                    // InternalExprParser.g:2758:6: ( ( Connection ) )
                    // InternalExprParser.g:2759:1: ( Connection )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMetaClassEnumAccess().getCONNECTIONEnumLiteralDeclaration_3()); 
                    }
                    // InternalExprParser.g:2760:1: ( Connection )
                    // InternalExprParser.g:2760:3: Connection
                    {
                    match(input,Connection,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMetaClassEnumAccess().getCONNECTIONEnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalExprParser.g:2765:6: ( ( Flow ) )
                    {
                    // InternalExprParser.g:2765:6: ( ( Flow ) )
                    // InternalExprParser.g:2766:1: ( Flow )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMetaClassEnumAccess().getFLOWEnumLiteralDeclaration_4()); 
                    }
                    // InternalExprParser.g:2767:1: ( Flow )
                    // InternalExprParser.g:2767:3: Flow
                    {
                    match(input,Flow,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMetaClassEnumAccess().getFLOWEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalExprParser.g:2772:6: ( ( Mode ) )
                    {
                    // InternalExprParser.g:2772:6: ( ( Mode ) )
                    // InternalExprParser.g:2773:1: ( Mode )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMetaClassEnumAccess().getMODEEnumLiteralDeclaration_5()); 
                    }
                    // InternalExprParser.g:2774:1: ( Mode )
                    // InternalExprParser.g:2774:3: Mode
                    {
                    match(input,Mode,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMetaClassEnumAccess().getMODEEnumLiteralDeclaration_5()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetaClassEnum__Alternatives"


    // $ANTLR start "rule__ExprModel__Group_0__0"
    // InternalExprParser.g:2788:1: rule__ExprModel__Group_0__0 : rule__ExprModel__Group_0__0__Impl rule__ExprModel__Group_0__1 ;
    public final void rule__ExprModel__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2792:1: ( rule__ExprModel__Group_0__0__Impl rule__ExprModel__Group_0__1 )
            // InternalExprParser.g:2793:2: rule__ExprModel__Group_0__0__Impl rule__ExprModel__Group_0__1
            {
            pushFollow(FOLLOW_3);
            rule__ExprModel__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ExprModel__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExprModel__Group_0__0"


    // $ANTLR start "rule__ExprModel__Group_0__0__Impl"
    // InternalExprParser.g:2800:1: rule__ExprModel__Group_0__0__Impl : ( Library ) ;
    public final void rule__ExprModel__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2804:1: ( ( Library ) )
            // InternalExprParser.g:2805:1: ( Library )
            {
            // InternalExprParser.g:2805:1: ( Library )
            // InternalExprParser.g:2806:1: Library
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprModelAccess().getLibraryKeyword_0_0()); 
            }
            match(input,Library,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprModelAccess().getLibraryKeyword_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExprModel__Group_0__0__Impl"


    // $ANTLR start "rule__ExprModel__Group_0__1"
    // InternalExprParser.g:2819:1: rule__ExprModel__Group_0__1 : rule__ExprModel__Group_0__1__Impl ;
    public final void rule__ExprModel__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2823:1: ( rule__ExprModel__Group_0__1__Impl )
            // InternalExprParser.g:2824:2: rule__ExprModel__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExprModel__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExprModel__Group_0__1"


    // $ANTLR start "rule__ExprModel__Group_0__1__Impl"
    // InternalExprParser.g:2830:1: rule__ExprModel__Group_0__1__Impl : ( ( rule__ExprModel__AnnexAssignment_0_1 ) ) ;
    public final void rule__ExprModel__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2834:1: ( ( ( rule__ExprModel__AnnexAssignment_0_1 ) ) )
            // InternalExprParser.g:2835:1: ( ( rule__ExprModel__AnnexAssignment_0_1 ) )
            {
            // InternalExprParser.g:2835:1: ( ( rule__ExprModel__AnnexAssignment_0_1 ) )
            // InternalExprParser.g:2836:1: ( rule__ExprModel__AnnexAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprModelAccess().getAnnexAssignment_0_1()); 
            }
            // InternalExprParser.g:2837:1: ( rule__ExprModel__AnnexAssignment_0_1 )
            // InternalExprParser.g:2837:2: rule__ExprModel__AnnexAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__ExprModel__AnnexAssignment_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprModelAccess().getAnnexAssignment_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExprModel__Group_0__1__Impl"


    // $ANTLR start "rule__ExprModel__Group_1__0"
    // InternalExprParser.g:2851:1: rule__ExprModel__Group_1__0 : rule__ExprModel__Group_1__0__Impl rule__ExprModel__Group_1__1 ;
    public final void rule__ExprModel__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2855:1: ( rule__ExprModel__Group_1__0__Impl rule__ExprModel__Group_1__1 )
            // InternalExprParser.g:2856:2: rule__ExprModel__Group_1__0__Impl rule__ExprModel__Group_1__1
            {
            pushFollow(FOLLOW_3);
            rule__ExprModel__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ExprModel__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExprModel__Group_1__0"


    // $ANTLR start "rule__ExprModel__Group_1__0__Impl"
    // InternalExprParser.g:2863:1: rule__ExprModel__Group_1__0__Impl : ( Subclause ) ;
    public final void rule__ExprModel__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2867:1: ( ( Subclause ) )
            // InternalExprParser.g:2868:1: ( Subclause )
            {
            // InternalExprParser.g:2868:1: ( Subclause )
            // InternalExprParser.g:2869:1: Subclause
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprModelAccess().getSubclauseKeyword_1_0()); 
            }
            match(input,Subclause,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprModelAccess().getSubclauseKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExprModel__Group_1__0__Impl"


    // $ANTLR start "rule__ExprModel__Group_1__1"
    // InternalExprParser.g:2882:1: rule__ExprModel__Group_1__1 : rule__ExprModel__Group_1__1__Impl ;
    public final void rule__ExprModel__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2886:1: ( rule__ExprModel__Group_1__1__Impl )
            // InternalExprParser.g:2887:2: rule__ExprModel__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExprModel__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExprModel__Group_1__1"


    // $ANTLR start "rule__ExprModel__Group_1__1__Impl"
    // InternalExprParser.g:2893:1: rule__ExprModel__Group_1__1__Impl : ( ( rule__ExprModel__AnnexAssignment_1_1 ) ) ;
    public final void rule__ExprModel__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2897:1: ( ( ( rule__ExprModel__AnnexAssignment_1_1 ) ) )
            // InternalExprParser.g:2898:1: ( ( rule__ExprModel__AnnexAssignment_1_1 ) )
            {
            // InternalExprParser.g:2898:1: ( ( rule__ExprModel__AnnexAssignment_1_1 ) )
            // InternalExprParser.g:2899:1: ( rule__ExprModel__AnnexAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprModelAccess().getAnnexAssignment_1_1()); 
            }
            // InternalExprParser.g:2900:1: ( rule__ExprModel__AnnexAssignment_1_1 )
            // InternalExprParser.g:2900:2: rule__ExprModel__AnnexAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ExprModel__AnnexAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprModelAccess().getAnnexAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExprModel__Group_1__1__Impl"


    // $ANTLR start "rule__Declarations__Group__0"
    // InternalExprParser.g:2914:1: rule__Declarations__Group__0 : rule__Declarations__Group__0__Impl rule__Declarations__Group__1 ;
    public final void rule__Declarations__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2918:1: ( rule__Declarations__Group__0__Impl rule__Declarations__Group__1 )
            // InternalExprParser.g:2919:2: rule__Declarations__Group__0__Impl rule__Declarations__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Declarations__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Declarations__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarations__Group__0"


    // $ANTLR start "rule__Declarations__Group__0__Impl"
    // InternalExprParser.g:2926:1: rule__Declarations__Group__0__Impl : ( ( rule__Declarations__DeclsAssignment_0 ) ) ;
    public final void rule__Declarations__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2930:1: ( ( ( rule__Declarations__DeclsAssignment_0 ) ) )
            // InternalExprParser.g:2931:1: ( ( rule__Declarations__DeclsAssignment_0 ) )
            {
            // InternalExprParser.g:2931:1: ( ( rule__Declarations__DeclsAssignment_0 ) )
            // InternalExprParser.g:2932:1: ( rule__Declarations__DeclsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclarationsAccess().getDeclsAssignment_0()); 
            }
            // InternalExprParser.g:2933:1: ( rule__Declarations__DeclsAssignment_0 )
            // InternalExprParser.g:2933:2: rule__Declarations__DeclsAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Declarations__DeclsAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclarationsAccess().getDeclsAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarations__Group__0__Impl"


    // $ANTLR start "rule__Declarations__Group__1"
    // InternalExprParser.g:2943:1: rule__Declarations__Group__1 : rule__Declarations__Group__1__Impl rule__Declarations__Group__2 ;
    public final void rule__Declarations__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2947:1: ( rule__Declarations__Group__1__Impl rule__Declarations__Group__2 )
            // InternalExprParser.g:2948:2: rule__Declarations__Group__1__Impl rule__Declarations__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Declarations__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Declarations__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarations__Group__1"


    // $ANTLR start "rule__Declarations__Group__1__Impl"
    // InternalExprParser.g:2955:1: rule__Declarations__Group__1__Impl : ( ( rule__Declarations__Group_1__0 )* ) ;
    public final void rule__Declarations__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2959:1: ( ( ( rule__Declarations__Group_1__0 )* ) )
            // InternalExprParser.g:2960:1: ( ( rule__Declarations__Group_1__0 )* )
            {
            // InternalExprParser.g:2960:1: ( ( rule__Declarations__Group_1__0 )* )
            // InternalExprParser.g:2961:1: ( rule__Declarations__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclarationsAccess().getGroup_1()); 
            }
            // InternalExprParser.g:2962:1: ( rule__Declarations__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==Semicolon) ) {
                    int LA21_1 = input.LA(2);

                    if ( (LA21_1==Type||LA21_1==Def||(LA21_1>=Val && LA21_1<=Var)) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // InternalExprParser.g:2962:2: rule__Declarations__Group_1__0
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Declarations__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclarationsAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarations__Group__1__Impl"


    // $ANTLR start "rule__Declarations__Group__2"
    // InternalExprParser.g:2972:1: rule__Declarations__Group__2 : rule__Declarations__Group__2__Impl ;
    public final void rule__Declarations__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2976:1: ( rule__Declarations__Group__2__Impl )
            // InternalExprParser.g:2977:2: rule__Declarations__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Declarations__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarations__Group__2"


    // $ANTLR start "rule__Declarations__Group__2__Impl"
    // InternalExprParser.g:2983:1: rule__Declarations__Group__2__Impl : ( ( Semicolon )? ) ;
    public final void rule__Declarations__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2987:1: ( ( ( Semicolon )? ) )
            // InternalExprParser.g:2988:1: ( ( Semicolon )? )
            {
            // InternalExprParser.g:2988:1: ( ( Semicolon )? )
            // InternalExprParser.g:2989:1: ( Semicolon )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclarationsAccess().getSemicolonKeyword_2()); 
            }
            // InternalExprParser.g:2990:1: ( Semicolon )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==Semicolon) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalExprParser.g:2991:2: Semicolon
                    {
                    match(input,Semicolon,FOLLOW_2); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclarationsAccess().getSemicolonKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarations__Group__2__Impl"


    // $ANTLR start "rule__Declarations__Group_1__0"
    // InternalExprParser.g:3008:1: rule__Declarations__Group_1__0 : rule__Declarations__Group_1__0__Impl rule__Declarations__Group_1__1 ;
    public final void rule__Declarations__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3012:1: ( rule__Declarations__Group_1__0__Impl rule__Declarations__Group_1__1 )
            // InternalExprParser.g:3013:2: rule__Declarations__Group_1__0__Impl rule__Declarations__Group_1__1
            {
            pushFollow(FOLLOW_3);
            rule__Declarations__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Declarations__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarations__Group_1__0"


    // $ANTLR start "rule__Declarations__Group_1__0__Impl"
    // InternalExprParser.g:3020:1: rule__Declarations__Group_1__0__Impl : ( Semicolon ) ;
    public final void rule__Declarations__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3024:1: ( ( Semicolon ) )
            // InternalExprParser.g:3025:1: ( Semicolon )
            {
            // InternalExprParser.g:3025:1: ( Semicolon )
            // InternalExprParser.g:3026:1: Semicolon
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclarationsAccess().getSemicolonKeyword_1_0()); 
            }
            match(input,Semicolon,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclarationsAccess().getSemicolonKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarations__Group_1__0__Impl"


    // $ANTLR start "rule__Declarations__Group_1__1"
    // InternalExprParser.g:3039:1: rule__Declarations__Group_1__1 : rule__Declarations__Group_1__1__Impl ;
    public final void rule__Declarations__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3043:1: ( rule__Declarations__Group_1__1__Impl )
            // InternalExprParser.g:3044:2: rule__Declarations__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Declarations__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarations__Group_1__1"


    // $ANTLR start "rule__Declarations__Group_1__1__Impl"
    // InternalExprParser.g:3050:1: rule__Declarations__Group_1__1__Impl : ( ( rule__Declarations__DeclsAssignment_1_1 ) ) ;
    public final void rule__Declarations__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3054:1: ( ( ( rule__Declarations__DeclsAssignment_1_1 ) ) )
            // InternalExprParser.g:3055:1: ( ( rule__Declarations__DeclsAssignment_1_1 ) )
            {
            // InternalExprParser.g:3055:1: ( ( rule__Declarations__DeclsAssignment_1_1 ) )
            // InternalExprParser.g:3056:1: ( rule__Declarations__DeclsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclarationsAccess().getDeclsAssignment_1_1()); 
            }
            // InternalExprParser.g:3057:1: ( rule__Declarations__DeclsAssignment_1_1 )
            // InternalExprParser.g:3057:2: rule__Declarations__DeclsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Declarations__DeclsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclarationsAccess().getDeclsAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarations__Group_1__1__Impl"


    // $ANTLR start "rule__ExprLibrary__Group__0"
    // InternalExprParser.g:3071:1: rule__ExprLibrary__Group__0 : rule__ExprLibrary__Group__0__Impl rule__ExprLibrary__Group__1 ;
    public final void rule__ExprLibrary__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3075:1: ( rule__ExprLibrary__Group__0__Impl rule__ExprLibrary__Group__1 )
            // InternalExprParser.g:3076:2: rule__ExprLibrary__Group__0__Impl rule__ExprLibrary__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__ExprLibrary__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ExprLibrary__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExprLibrary__Group__0"


    // $ANTLR start "rule__ExprLibrary__Group__0__Impl"
    // InternalExprParser.g:3083:1: rule__ExprLibrary__Group__0__Impl : ( () ) ;
    public final void rule__ExprLibrary__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3087:1: ( ( () ) )
            // InternalExprParser.g:3088:1: ( () )
            {
            // InternalExprParser.g:3088:1: ( () )
            // InternalExprParser.g:3089:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprLibraryAccess().getExprLibraryAction_0()); 
            }
            // InternalExprParser.g:3090:1: ()
            // InternalExprParser.g:3092:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprLibraryAccess().getExprLibraryAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExprLibrary__Group__0__Impl"


    // $ANTLR start "rule__ExprLibrary__Group__1"
    // InternalExprParser.g:3102:1: rule__ExprLibrary__Group__1 : rule__ExprLibrary__Group__1__Impl ;
    public final void rule__ExprLibrary__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3106:1: ( rule__ExprLibrary__Group__1__Impl )
            // InternalExprParser.g:3107:2: rule__ExprLibrary__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExprLibrary__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExprLibrary__Group__1"


    // $ANTLR start "rule__ExprLibrary__Group__1__Impl"
    // InternalExprParser.g:3113:1: rule__ExprLibrary__Group__1__Impl : ( ( ruleDeclarations )? ) ;
    public final void rule__ExprLibrary__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3117:1: ( ( ( ruleDeclarations )? ) )
            // InternalExprParser.g:3118:1: ( ( ruleDeclarations )? )
            {
            // InternalExprParser.g:3118:1: ( ( ruleDeclarations )? )
            // InternalExprParser.g:3119:1: ( ruleDeclarations )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprLibraryAccess().getDeclarationsParserRuleCall_1()); 
            }
            // InternalExprParser.g:3120:1: ( ruleDeclarations )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==Type||LA23_0==Def||(LA23_0>=Val && LA23_0<=Var)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalExprParser.g:3120:3: ruleDeclarations
                    {
                    pushFollow(FOLLOW_2);
                    ruleDeclarations();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprLibraryAccess().getDeclarationsParserRuleCall_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExprLibrary__Group__1__Impl"


    // $ANTLR start "rule__ExprSubclause__Group__0"
    // InternalExprParser.g:3134:1: rule__ExprSubclause__Group__0 : rule__ExprSubclause__Group__0__Impl rule__ExprSubclause__Group__1 ;
    public final void rule__ExprSubclause__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3138:1: ( rule__ExprSubclause__Group__0__Impl rule__ExprSubclause__Group__1 )
            // InternalExprParser.g:3139:2: rule__ExprSubclause__Group__0__Impl rule__ExprSubclause__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__ExprSubclause__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ExprSubclause__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExprSubclause__Group__0"


    // $ANTLR start "rule__ExprSubclause__Group__0__Impl"
    // InternalExprParser.g:3146:1: rule__ExprSubclause__Group__0__Impl : ( () ) ;
    public final void rule__ExprSubclause__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3150:1: ( ( () ) )
            // InternalExprParser.g:3151:1: ( () )
            {
            // InternalExprParser.g:3151:1: ( () )
            // InternalExprParser.g:3152:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprSubclauseAccess().getExprSubclauseAction_0()); 
            }
            // InternalExprParser.g:3153:1: ()
            // InternalExprParser.g:3155:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprSubclauseAccess().getExprSubclauseAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExprSubclause__Group__0__Impl"


    // $ANTLR start "rule__ExprSubclause__Group__1"
    // InternalExprParser.g:3165:1: rule__ExprSubclause__Group__1 : rule__ExprSubclause__Group__1__Impl ;
    public final void rule__ExprSubclause__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3169:1: ( rule__ExprSubclause__Group__1__Impl )
            // InternalExprParser.g:3170:2: rule__ExprSubclause__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExprSubclause__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExprSubclause__Group__1"


    // $ANTLR start "rule__ExprSubclause__Group__1__Impl"
    // InternalExprParser.g:3176:1: rule__ExprSubclause__Group__1__Impl : ( ( ruleDeclarations )? ) ;
    public final void rule__ExprSubclause__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3180:1: ( ( ( ruleDeclarations )? ) )
            // InternalExprParser.g:3181:1: ( ( ruleDeclarations )? )
            {
            // InternalExprParser.g:3181:1: ( ( ruleDeclarations )? )
            // InternalExprParser.g:3182:1: ( ruleDeclarations )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprSubclauseAccess().getDeclarationsParserRuleCall_1()); 
            }
            // InternalExprParser.g:3183:1: ( ruleDeclarations )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==Type||LA24_0==Def||(LA24_0>=Val && LA24_0<=Var)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalExprParser.g:3183:3: ruleDeclarations
                    {
                    pushFollow(FOLLOW_2);
                    ruleDeclarations();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprSubclauseAccess().getDeclarationsParserRuleCall_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExprSubclause__Group__1__Impl"


    // $ANTLR start "rule__TypeDecl__Group__0"
    // InternalExprParser.g:3197:1: rule__TypeDecl__Group__0 : rule__TypeDecl__Group__0__Impl rule__TypeDecl__Group__1 ;
    public final void rule__TypeDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3201:1: ( rule__TypeDecl__Group__0__Impl rule__TypeDecl__Group__1 )
            // InternalExprParser.g:3202:2: rule__TypeDecl__Group__0__Impl rule__TypeDecl__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__TypeDecl__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeDecl__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDecl__Group__0"


    // $ANTLR start "rule__TypeDecl__Group__0__Impl"
    // InternalExprParser.g:3209:1: rule__TypeDecl__Group__0__Impl : ( () ) ;
    public final void rule__TypeDecl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3213:1: ( ( () ) )
            // InternalExprParser.g:3214:1: ( () )
            {
            // InternalExprParser.g:3214:1: ( () )
            // InternalExprParser.g:3215:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDeclAccess().getTypeDeclAction_0()); 
            }
            // InternalExprParser.g:3216:1: ()
            // InternalExprParser.g:3218:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDeclAccess().getTypeDeclAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDecl__Group__0__Impl"


    // $ANTLR start "rule__TypeDecl__Group__1"
    // InternalExprParser.g:3228:1: rule__TypeDecl__Group__1 : rule__TypeDecl__Group__1__Impl rule__TypeDecl__Group__2 ;
    public final void rule__TypeDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3232:1: ( rule__TypeDecl__Group__1__Impl rule__TypeDecl__Group__2 )
            // InternalExprParser.g:3233:2: rule__TypeDecl__Group__1__Impl rule__TypeDecl__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__TypeDecl__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeDecl__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDecl__Group__1"


    // $ANTLR start "rule__TypeDecl__Group__1__Impl"
    // InternalExprParser.g:3240:1: rule__TypeDecl__Group__1__Impl : ( Type ) ;
    public final void rule__TypeDecl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3244:1: ( ( Type ) )
            // InternalExprParser.g:3245:1: ( Type )
            {
            // InternalExprParser.g:3245:1: ( Type )
            // InternalExprParser.g:3246:1: Type
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDeclAccess().getTypeKeyword_1()); 
            }
            match(input,Type,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDeclAccess().getTypeKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDecl__Group__1__Impl"


    // $ANTLR start "rule__TypeDecl__Group__2"
    // InternalExprParser.g:3259:1: rule__TypeDecl__Group__2 : rule__TypeDecl__Group__2__Impl rule__TypeDecl__Group__3 ;
    public final void rule__TypeDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3263:1: ( rule__TypeDecl__Group__2__Impl rule__TypeDecl__Group__3 )
            // InternalExprParser.g:3264:2: rule__TypeDecl__Group__2__Impl rule__TypeDecl__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__TypeDecl__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeDecl__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDecl__Group__2"


    // $ANTLR start "rule__TypeDecl__Group__2__Impl"
    // InternalExprParser.g:3271:1: rule__TypeDecl__Group__2__Impl : ( ( rule__TypeDecl__NameAssignment_2 ) ) ;
    public final void rule__TypeDecl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3275:1: ( ( ( rule__TypeDecl__NameAssignment_2 ) ) )
            // InternalExprParser.g:3276:1: ( ( rule__TypeDecl__NameAssignment_2 ) )
            {
            // InternalExprParser.g:3276:1: ( ( rule__TypeDecl__NameAssignment_2 ) )
            // InternalExprParser.g:3277:1: ( rule__TypeDecl__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDeclAccess().getNameAssignment_2()); 
            }
            // InternalExprParser.g:3278:1: ( rule__TypeDecl__NameAssignment_2 )
            // InternalExprParser.g:3278:2: rule__TypeDecl__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__TypeDecl__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDeclAccess().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDecl__Group__2__Impl"


    // $ANTLR start "rule__TypeDecl__Group__3"
    // InternalExprParser.g:3288:1: rule__TypeDecl__Group__3 : rule__TypeDecl__Group__3__Impl rule__TypeDecl__Group__4 ;
    public final void rule__TypeDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3292:1: ( rule__TypeDecl__Group__3__Impl rule__TypeDecl__Group__4 )
            // InternalExprParser.g:3293:2: rule__TypeDecl__Group__3__Impl rule__TypeDecl__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__TypeDecl__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeDecl__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDecl__Group__3"


    // $ANTLR start "rule__TypeDecl__Group__3__Impl"
    // InternalExprParser.g:3300:1: rule__TypeDecl__Group__3__Impl : ( Colon ) ;
    public final void rule__TypeDecl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3304:1: ( ( Colon ) )
            // InternalExprParser.g:3305:1: ( Colon )
            {
            // InternalExprParser.g:3305:1: ( Colon )
            // InternalExprParser.g:3306:1: Colon
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDeclAccess().getColonKeyword_3()); 
            }
            match(input,Colon,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDeclAccess().getColonKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDecl__Group__3__Impl"


    // $ANTLR start "rule__TypeDecl__Group__4"
    // InternalExprParser.g:3319:1: rule__TypeDecl__Group__4 : rule__TypeDecl__Group__4__Impl ;
    public final void rule__TypeDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3323:1: ( rule__TypeDecl__Group__4__Impl )
            // InternalExprParser.g:3324:2: rule__TypeDecl__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeDecl__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDecl__Group__4"


    // $ANTLR start "rule__TypeDecl__Group__4__Impl"
    // InternalExprParser.g:3330:1: rule__TypeDecl__Group__4__Impl : ( ( rule__TypeDecl__TypeAssignment_4 ) ) ;
    public final void rule__TypeDecl__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3334:1: ( ( ( rule__TypeDecl__TypeAssignment_4 ) ) )
            // InternalExprParser.g:3335:1: ( ( rule__TypeDecl__TypeAssignment_4 ) )
            {
            // InternalExprParser.g:3335:1: ( ( rule__TypeDecl__TypeAssignment_4 ) )
            // InternalExprParser.g:3336:1: ( rule__TypeDecl__TypeAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDeclAccess().getTypeAssignment_4()); 
            }
            // InternalExprParser.g:3337:1: ( rule__TypeDecl__TypeAssignment_4 )
            // InternalExprParser.g:3337:2: rule__TypeDecl__TypeAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__TypeDecl__TypeAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDeclAccess().getTypeAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDecl__Group__4__Impl"


    // $ANTLR start "rule__VarDecl__Group__0"
    // InternalExprParser.g:3357:1: rule__VarDecl__Group__0 : rule__VarDecl__Group__0__Impl rule__VarDecl__Group__1 ;
    public final void rule__VarDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3361:1: ( rule__VarDecl__Group__0__Impl rule__VarDecl__Group__1 )
            // InternalExprParser.g:3362:2: rule__VarDecl__Group__0__Impl rule__VarDecl__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__VarDecl__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__VarDecl__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__Group__0"


    // $ANTLR start "rule__VarDecl__Group__0__Impl"
    // InternalExprParser.g:3369:1: rule__VarDecl__Group__0__Impl : ( () ) ;
    public final void rule__VarDecl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3373:1: ( ( () ) )
            // InternalExprParser.g:3374:1: ( () )
            {
            // InternalExprParser.g:3374:1: ( () )
            // InternalExprParser.g:3375:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getVarDeclAction_0()); 
            }
            // InternalExprParser.g:3376:1: ()
            // InternalExprParser.g:3378:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getVarDeclAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__Group__0__Impl"


    // $ANTLR start "rule__VarDecl__Group__1"
    // InternalExprParser.g:3388:1: rule__VarDecl__Group__1 : rule__VarDecl__Group__1__Impl rule__VarDecl__Group__2 ;
    public final void rule__VarDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3392:1: ( rule__VarDecl__Group__1__Impl rule__VarDecl__Group__2 )
            // InternalExprParser.g:3393:2: rule__VarDecl__Group__1__Impl rule__VarDecl__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__VarDecl__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__VarDecl__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__Group__1"


    // $ANTLR start "rule__VarDecl__Group__1__Impl"
    // InternalExprParser.g:3400:1: rule__VarDecl__Group__1__Impl : ( ( rule__VarDecl__Alternatives_1 ) ) ;
    public final void rule__VarDecl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3404:1: ( ( ( rule__VarDecl__Alternatives_1 ) ) )
            // InternalExprParser.g:3405:1: ( ( rule__VarDecl__Alternatives_1 ) )
            {
            // InternalExprParser.g:3405:1: ( ( rule__VarDecl__Alternatives_1 ) )
            // InternalExprParser.g:3406:1: ( rule__VarDecl__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getAlternatives_1()); 
            }
            // InternalExprParser.g:3407:1: ( rule__VarDecl__Alternatives_1 )
            // InternalExprParser.g:3407:2: rule__VarDecl__Alternatives_1
            {
            pushFollow(FOLLOW_2);
            rule__VarDecl__Alternatives_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getAlternatives_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__Group__1__Impl"


    // $ANTLR start "rule__VarDecl__Group__2"
    // InternalExprParser.g:3417:1: rule__VarDecl__Group__2 : rule__VarDecl__Group__2__Impl rule__VarDecl__Group__3 ;
    public final void rule__VarDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3421:1: ( rule__VarDecl__Group__2__Impl rule__VarDecl__Group__3 )
            // InternalExprParser.g:3422:2: rule__VarDecl__Group__2__Impl rule__VarDecl__Group__3
            {
            pushFollow(FOLLOW_11);
            rule__VarDecl__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__VarDecl__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__Group__2"


    // $ANTLR start "rule__VarDecl__Group__2__Impl"
    // InternalExprParser.g:3429:1: rule__VarDecl__Group__2__Impl : ( ( rule__VarDecl__NameAssignment_2 ) ) ;
    public final void rule__VarDecl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3433:1: ( ( ( rule__VarDecl__NameAssignment_2 ) ) )
            // InternalExprParser.g:3434:1: ( ( rule__VarDecl__NameAssignment_2 ) )
            {
            // InternalExprParser.g:3434:1: ( ( rule__VarDecl__NameAssignment_2 ) )
            // InternalExprParser.g:3435:1: ( rule__VarDecl__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getNameAssignment_2()); 
            }
            // InternalExprParser.g:3436:1: ( rule__VarDecl__NameAssignment_2 )
            // InternalExprParser.g:3436:2: rule__VarDecl__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__VarDecl__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__Group__2__Impl"


    // $ANTLR start "rule__VarDecl__Group__3"
    // InternalExprParser.g:3446:1: rule__VarDecl__Group__3 : rule__VarDecl__Group__3__Impl rule__VarDecl__Group__4 ;
    public final void rule__VarDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3450:1: ( rule__VarDecl__Group__3__Impl rule__VarDecl__Group__4 )
            // InternalExprParser.g:3451:2: rule__VarDecl__Group__3__Impl rule__VarDecl__Group__4
            {
            pushFollow(FOLLOW_11);
            rule__VarDecl__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__VarDecl__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__Group__3"


    // $ANTLR start "rule__VarDecl__Group__3__Impl"
    // InternalExprParser.g:3458:1: rule__VarDecl__Group__3__Impl : ( ( rule__VarDecl__Group_3__0 )? ) ;
    public final void rule__VarDecl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3462:1: ( ( ( rule__VarDecl__Group_3__0 )? ) )
            // InternalExprParser.g:3463:1: ( ( rule__VarDecl__Group_3__0 )? )
            {
            // InternalExprParser.g:3463:1: ( ( rule__VarDecl__Group_3__0 )? )
            // InternalExprParser.g:3464:1: ( rule__VarDecl__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getGroup_3()); 
            }
            // InternalExprParser.g:3465:1: ( rule__VarDecl__Group_3__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==Colon) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalExprParser.g:3465:2: rule__VarDecl__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VarDecl__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getGroup_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__Group__3__Impl"


    // $ANTLR start "rule__VarDecl__Group__4"
    // InternalExprParser.g:3475:1: rule__VarDecl__Group__4 : rule__VarDecl__Group__4__Impl ;
    public final void rule__VarDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3479:1: ( rule__VarDecl__Group__4__Impl )
            // InternalExprParser.g:3480:2: rule__VarDecl__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VarDecl__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__Group__4"


    // $ANTLR start "rule__VarDecl__Group__4__Impl"
    // InternalExprParser.g:3486:1: rule__VarDecl__Group__4__Impl : ( ( rule__VarDecl__Group_4__0 )? ) ;
    public final void rule__VarDecl__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3490:1: ( ( ( rule__VarDecl__Group_4__0 )? ) )
            // InternalExprParser.g:3491:1: ( ( rule__VarDecl__Group_4__0 )? )
            {
            // InternalExprParser.g:3491:1: ( ( rule__VarDecl__Group_4__0 )? )
            // InternalExprParser.g:3492:1: ( rule__VarDecl__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getGroup_4()); 
            }
            // InternalExprParser.g:3493:1: ( rule__VarDecl__Group_4__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==EqualsSign) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalExprParser.g:3493:2: rule__VarDecl__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VarDecl__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getGroup_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__Group__4__Impl"


    // $ANTLR start "rule__VarDecl__Group_3__0"
    // InternalExprParser.g:3513:1: rule__VarDecl__Group_3__0 : rule__VarDecl__Group_3__0__Impl rule__VarDecl__Group_3__1 ;
    public final void rule__VarDecl__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3517:1: ( rule__VarDecl__Group_3__0__Impl rule__VarDecl__Group_3__1 )
            // InternalExprParser.g:3518:2: rule__VarDecl__Group_3__0__Impl rule__VarDecl__Group_3__1
            {
            pushFollow(FOLLOW_9);
            rule__VarDecl__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__VarDecl__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__Group_3__0"


    // $ANTLR start "rule__VarDecl__Group_3__0__Impl"
    // InternalExprParser.g:3525:1: rule__VarDecl__Group_3__0__Impl : ( Colon ) ;
    public final void rule__VarDecl__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3529:1: ( ( Colon ) )
            // InternalExprParser.g:3530:1: ( Colon )
            {
            // InternalExprParser.g:3530:1: ( Colon )
            // InternalExprParser.g:3531:1: Colon
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getColonKeyword_3_0()); 
            }
            match(input,Colon,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getColonKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__Group_3__0__Impl"


    // $ANTLR start "rule__VarDecl__Group_3__1"
    // InternalExprParser.g:3544:1: rule__VarDecl__Group_3__1 : rule__VarDecl__Group_3__1__Impl ;
    public final void rule__VarDecl__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3548:1: ( rule__VarDecl__Group_3__1__Impl )
            // InternalExprParser.g:3549:2: rule__VarDecl__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VarDecl__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__Group_3__1"


    // $ANTLR start "rule__VarDecl__Group_3__1__Impl"
    // InternalExprParser.g:3555:1: rule__VarDecl__Group_3__1__Impl : ( ( rule__VarDecl__TypeAssignment_3_1 ) ) ;
    public final void rule__VarDecl__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3559:1: ( ( ( rule__VarDecl__TypeAssignment_3_1 ) ) )
            // InternalExprParser.g:3560:1: ( ( rule__VarDecl__TypeAssignment_3_1 ) )
            {
            // InternalExprParser.g:3560:1: ( ( rule__VarDecl__TypeAssignment_3_1 ) )
            // InternalExprParser.g:3561:1: ( rule__VarDecl__TypeAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getTypeAssignment_3_1()); 
            }
            // InternalExprParser.g:3562:1: ( rule__VarDecl__TypeAssignment_3_1 )
            // InternalExprParser.g:3562:2: rule__VarDecl__TypeAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__VarDecl__TypeAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getTypeAssignment_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__Group_3__1__Impl"


    // $ANTLR start "rule__VarDecl__Group_4__0"
    // InternalExprParser.g:3576:1: rule__VarDecl__Group_4__0 : rule__VarDecl__Group_4__0__Impl rule__VarDecl__Group_4__1 ;
    public final void rule__VarDecl__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3580:1: ( rule__VarDecl__Group_4__0__Impl rule__VarDecl__Group_4__1 )
            // InternalExprParser.g:3581:2: rule__VarDecl__Group_4__0__Impl rule__VarDecl__Group_4__1
            {
            pushFollow(FOLLOW_12);
            rule__VarDecl__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__VarDecl__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__Group_4__0"


    // $ANTLR start "rule__VarDecl__Group_4__0__Impl"
    // InternalExprParser.g:3588:1: rule__VarDecl__Group_4__0__Impl : ( EqualsSign ) ;
    public final void rule__VarDecl__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3592:1: ( ( EqualsSign ) )
            // InternalExprParser.g:3593:1: ( EqualsSign )
            {
            // InternalExprParser.g:3593:1: ( EqualsSign )
            // InternalExprParser.g:3594:1: EqualsSign
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getEqualsSignKeyword_4_0()); 
            }
            match(input,EqualsSign,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getEqualsSignKeyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__Group_4__0__Impl"


    // $ANTLR start "rule__VarDecl__Group_4__1"
    // InternalExprParser.g:3607:1: rule__VarDecl__Group_4__1 : rule__VarDecl__Group_4__1__Impl ;
    public final void rule__VarDecl__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3611:1: ( rule__VarDecl__Group_4__1__Impl )
            // InternalExprParser.g:3612:2: rule__VarDecl__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VarDecl__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__Group_4__1"


    // $ANTLR start "rule__VarDecl__Group_4__1__Impl"
    // InternalExprParser.g:3618:1: rule__VarDecl__Group_4__1__Impl : ( ( rule__VarDecl__ValueAssignment_4_1 ) ) ;
    public final void rule__VarDecl__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3622:1: ( ( ( rule__VarDecl__ValueAssignment_4_1 ) ) )
            // InternalExprParser.g:3623:1: ( ( rule__VarDecl__ValueAssignment_4_1 ) )
            {
            // InternalExprParser.g:3623:1: ( ( rule__VarDecl__ValueAssignment_4_1 ) )
            // InternalExprParser.g:3624:1: ( rule__VarDecl__ValueAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getValueAssignment_4_1()); 
            }
            // InternalExprParser.g:3625:1: ( rule__VarDecl__ValueAssignment_4_1 )
            // InternalExprParser.g:3625:2: rule__VarDecl__ValueAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__VarDecl__ValueAssignment_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getValueAssignment_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__Group_4__1__Impl"


    // $ANTLR start "rule__FunDecl__Group__0"
    // InternalExprParser.g:3639:1: rule__FunDecl__Group__0 : rule__FunDecl__Group__0__Impl rule__FunDecl__Group__1 ;
    public final void rule__FunDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3643:1: ( rule__FunDecl__Group__0__Impl rule__FunDecl__Group__1 )
            // InternalExprParser.g:3644:2: rule__FunDecl__Group__0__Impl rule__FunDecl__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__FunDecl__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FunDecl__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunDecl__Group__0"


    // $ANTLR start "rule__FunDecl__Group__0__Impl"
    // InternalExprParser.g:3651:1: rule__FunDecl__Group__0__Impl : ( () ) ;
    public final void rule__FunDecl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3655:1: ( ( () ) )
            // InternalExprParser.g:3656:1: ( () )
            {
            // InternalExprParser.g:3656:1: ( () )
            // InternalExprParser.g:3657:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunDeclAccess().getFunDeclAction_0()); 
            }
            // InternalExprParser.g:3658:1: ()
            // InternalExprParser.g:3660:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunDeclAccess().getFunDeclAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunDecl__Group__0__Impl"


    // $ANTLR start "rule__FunDecl__Group__1"
    // InternalExprParser.g:3670:1: rule__FunDecl__Group__1 : rule__FunDecl__Group__1__Impl rule__FunDecl__Group__2 ;
    public final void rule__FunDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3674:1: ( rule__FunDecl__Group__1__Impl rule__FunDecl__Group__2 )
            // InternalExprParser.g:3675:2: rule__FunDecl__Group__1__Impl rule__FunDecl__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__FunDecl__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FunDecl__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunDecl__Group__1"


    // $ANTLR start "rule__FunDecl__Group__1__Impl"
    // InternalExprParser.g:3682:1: rule__FunDecl__Group__1__Impl : ( Def ) ;
    public final void rule__FunDecl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3686:1: ( ( Def ) )
            // InternalExprParser.g:3687:1: ( Def )
            {
            // InternalExprParser.g:3687:1: ( Def )
            // InternalExprParser.g:3688:1: Def
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunDeclAccess().getDefKeyword_1()); 
            }
            match(input,Def,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunDeclAccess().getDefKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunDecl__Group__1__Impl"


    // $ANTLR start "rule__FunDecl__Group__2"
    // InternalExprParser.g:3701:1: rule__FunDecl__Group__2 : rule__FunDecl__Group__2__Impl rule__FunDecl__Group__3 ;
    public final void rule__FunDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3705:1: ( rule__FunDecl__Group__2__Impl rule__FunDecl__Group__3 )
            // InternalExprParser.g:3706:2: rule__FunDecl__Group__2__Impl rule__FunDecl__Group__3
            {
            pushFollow(FOLLOW_13);
            rule__FunDecl__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FunDecl__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunDecl__Group__2"


    // $ANTLR start "rule__FunDecl__Group__2__Impl"
    // InternalExprParser.g:3713:1: rule__FunDecl__Group__2__Impl : ( ( rule__FunDecl__NameAssignment_2 ) ) ;
    public final void rule__FunDecl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3717:1: ( ( ( rule__FunDecl__NameAssignment_2 ) ) )
            // InternalExprParser.g:3718:1: ( ( rule__FunDecl__NameAssignment_2 ) )
            {
            // InternalExprParser.g:3718:1: ( ( rule__FunDecl__NameAssignment_2 ) )
            // InternalExprParser.g:3719:1: ( rule__FunDecl__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunDeclAccess().getNameAssignment_2()); 
            }
            // InternalExprParser.g:3720:1: ( rule__FunDecl__NameAssignment_2 )
            // InternalExprParser.g:3720:2: rule__FunDecl__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__FunDecl__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunDeclAccess().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunDecl__Group__2__Impl"


    // $ANTLR start "rule__FunDecl__Group__3"
    // InternalExprParser.g:3730:1: rule__FunDecl__Group__3 : rule__FunDecl__Group__3__Impl rule__FunDecl__Group__4 ;
    public final void rule__FunDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3734:1: ( rule__FunDecl__Group__3__Impl rule__FunDecl__Group__4 )
            // InternalExprParser.g:3735:2: rule__FunDecl__Group__3__Impl rule__FunDecl__Group__4
            {
            pushFollow(FOLLOW_14);
            rule__FunDecl__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FunDecl__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunDecl__Group__3"


    // $ANTLR start "rule__FunDecl__Group__3__Impl"
    // InternalExprParser.g:3742:1: rule__FunDecl__Group__3__Impl : ( LeftParenthesis ) ;
    public final void rule__FunDecl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3746:1: ( ( LeftParenthesis ) )
            // InternalExprParser.g:3747:1: ( LeftParenthesis )
            {
            // InternalExprParser.g:3747:1: ( LeftParenthesis )
            // InternalExprParser.g:3748:1: LeftParenthesis
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunDeclAccess().getLeftParenthesisKeyword_3()); 
            }
            match(input,LeftParenthesis,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunDeclAccess().getLeftParenthesisKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunDecl__Group__3__Impl"


    // $ANTLR start "rule__FunDecl__Group__4"
    // InternalExprParser.g:3761:1: rule__FunDecl__Group__4 : rule__FunDecl__Group__4__Impl ;
    public final void rule__FunDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3765:1: ( rule__FunDecl__Group__4__Impl )
            // InternalExprParser.g:3766:2: rule__FunDecl__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FunDecl__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunDecl__Group__4"


    // $ANTLR start "rule__FunDecl__Group__4__Impl"
    // InternalExprParser.g:3772:1: rule__FunDecl__Group__4__Impl : ( RightParenthesis ) ;
    public final void rule__FunDecl__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3776:1: ( ( RightParenthesis ) )
            // InternalExprParser.g:3777:1: ( RightParenthesis )
            {
            // InternalExprParser.g:3777:1: ( RightParenthesis )
            // InternalExprParser.g:3778:1: RightParenthesis
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunDeclAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,RightParenthesis,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunDeclAccess().getRightParenthesisKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunDecl__Group__4__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_0__0"
    // InternalExprParser.g:3801:1: rule__PrimitiveType__Group_0__0 : rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1 ;
    public final void rule__PrimitiveType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3805:1: ( rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1 )
            // InternalExprParser.g:3806:2: rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1
            {
            pushFollow(FOLLOW_15);
            rule__PrimitiveType__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_0__0"


    // $ANTLR start "rule__PrimitiveType__Group_0__0__Impl"
    // InternalExprParser.g:3813:1: rule__PrimitiveType__Group_0__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3817:1: ( ( () ) )
            // InternalExprParser.g:3818:1: ( () )
            {
            // InternalExprParser.g:3818:1: ( () )
            // InternalExprParser.g:3819:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveTypeAccess().getBooleanAction_0_0()); 
            }
            // InternalExprParser.g:3820:1: ()
            // InternalExprParser.g:3822:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimitiveTypeAccess().getBooleanAction_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_0__0__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_0__1"
    // InternalExprParser.g:3832:1: rule__PrimitiveType__Group_0__1 : rule__PrimitiveType__Group_0__1__Impl ;
    public final void rule__PrimitiveType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3836:1: ( rule__PrimitiveType__Group_0__1__Impl )
            // InternalExprParser.g:3837:2: rule__PrimitiveType__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_0__1"


    // $ANTLR start "rule__PrimitiveType__Group_0__1__Impl"
    // InternalExprParser.g:3843:1: rule__PrimitiveType__Group_0__1__Impl : ( Bool ) ;
    public final void rule__PrimitiveType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3847:1: ( ( Bool ) )
            // InternalExprParser.g:3848:1: ( Bool )
            {
            // InternalExprParser.g:3848:1: ( Bool )
            // InternalExprParser.g:3849:1: Bool
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveTypeAccess().getBoolKeyword_0_1()); 
            }
            match(input,Bool,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimitiveTypeAccess().getBoolKeyword_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_0__1__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_1__0"
    // InternalExprParser.g:3866:1: rule__PrimitiveType__Group_1__0 : rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1 ;
    public final void rule__PrimitiveType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3870:1: ( rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1 )
            // InternalExprParser.g:3871:2: rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1
            {
            pushFollow(FOLLOW_16);
            rule__PrimitiveType__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_1__0"


    // $ANTLR start "rule__PrimitiveType__Group_1__0__Impl"
    // InternalExprParser.g:3878:1: rule__PrimitiveType__Group_1__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3882:1: ( ( () ) )
            // InternalExprParser.g:3883:1: ( () )
            {
            // InternalExprParser.g:3883:1: ( () )
            // InternalExprParser.g:3884:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveTypeAccess().getIntegerAction_1_0()); 
            }
            // InternalExprParser.g:3885:1: ()
            // InternalExprParser.g:3887:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimitiveTypeAccess().getIntegerAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_1__0__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_1__1"
    // InternalExprParser.g:3897:1: rule__PrimitiveType__Group_1__1 : rule__PrimitiveType__Group_1__1__Impl ;
    public final void rule__PrimitiveType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3901:1: ( rule__PrimitiveType__Group_1__1__Impl )
            // InternalExprParser.g:3902:2: rule__PrimitiveType__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_1__1"


    // $ANTLR start "rule__PrimitiveType__Group_1__1__Impl"
    // InternalExprParser.g:3908:1: rule__PrimitiveType__Group_1__1__Impl : ( Int ) ;
    public final void rule__PrimitiveType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3912:1: ( ( Int ) )
            // InternalExprParser.g:3913:1: ( Int )
            {
            // InternalExprParser.g:3913:1: ( Int )
            // InternalExprParser.g:3914:1: Int
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveTypeAccess().getIntKeyword_1_1()); 
            }
            match(input,Int,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimitiveTypeAccess().getIntKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_1__1__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_2__0"
    // InternalExprParser.g:3931:1: rule__PrimitiveType__Group_2__0 : rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1 ;
    public final void rule__PrimitiveType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3935:1: ( rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1 )
            // InternalExprParser.g:3936:2: rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1
            {
            pushFollow(FOLLOW_17);
            rule__PrimitiveType__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_2__0"


    // $ANTLR start "rule__PrimitiveType__Group_2__0__Impl"
    // InternalExprParser.g:3943:1: rule__PrimitiveType__Group_2__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3947:1: ( ( () ) )
            // InternalExprParser.g:3948:1: ( () )
            {
            // InternalExprParser.g:3948:1: ( () )
            // InternalExprParser.g:3949:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveTypeAccess().getRealAction_2_0()); 
            }
            // InternalExprParser.g:3950:1: ()
            // InternalExprParser.g:3952:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimitiveTypeAccess().getRealAction_2_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_2__0__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_2__1"
    // InternalExprParser.g:3962:1: rule__PrimitiveType__Group_2__1 : rule__PrimitiveType__Group_2__1__Impl ;
    public final void rule__PrimitiveType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3966:1: ( rule__PrimitiveType__Group_2__1__Impl )
            // InternalExprParser.g:3967:2: rule__PrimitiveType__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_2__1"


    // $ANTLR start "rule__PrimitiveType__Group_2__1__Impl"
    // InternalExprParser.g:3973:1: rule__PrimitiveType__Group_2__1__Impl : ( Real ) ;
    public final void rule__PrimitiveType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3977:1: ( ( Real ) )
            // InternalExprParser.g:3978:1: ( Real )
            {
            // InternalExprParser.g:3978:1: ( Real )
            // InternalExprParser.g:3979:1: Real
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveTypeAccess().getRealKeyword_2_1()); 
            }
            match(input,Real,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimitiveTypeAccess().getRealKeyword_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_2__1__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_3__0"
    // InternalExprParser.g:3996:1: rule__PrimitiveType__Group_3__0 : rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1 ;
    public final void rule__PrimitiveType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4000:1: ( rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1 )
            // InternalExprParser.g:4001:2: rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1
            {
            pushFollow(FOLLOW_18);
            rule__PrimitiveType__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_3__0"


    // $ANTLR start "rule__PrimitiveType__Group_3__0__Impl"
    // InternalExprParser.g:4008:1: rule__PrimitiveType__Group_3__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4012:1: ( ( () ) )
            // InternalExprParser.g:4013:1: ( () )
            {
            // InternalExprParser.g:4013:1: ( () )
            // InternalExprParser.g:4014:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveTypeAccess().getStringAction_3_0()); 
            }
            // InternalExprParser.g:4015:1: ()
            // InternalExprParser.g:4017:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimitiveTypeAccess().getStringAction_3_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_3__0__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_3__1"
    // InternalExprParser.g:4027:1: rule__PrimitiveType__Group_3__1 : rule__PrimitiveType__Group_3__1__Impl ;
    public final void rule__PrimitiveType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4031:1: ( rule__PrimitiveType__Group_3__1__Impl )
            // InternalExprParser.g:4032:2: rule__PrimitiveType__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_3__1"


    // $ANTLR start "rule__PrimitiveType__Group_3__1__Impl"
    // InternalExprParser.g:4038:1: rule__PrimitiveType__Group_3__1__Impl : ( String ) ;
    public final void rule__PrimitiveType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4042:1: ( ( String ) )
            // InternalExprParser.g:4043:1: ( String )
            {
            // InternalExprParser.g:4043:1: ( String )
            // InternalExprParser.g:4044:1: String
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveTypeAccess().getStringKeyword_3_1()); 
            }
            match(input,String,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimitiveTypeAccess().getStringKeyword_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_3__1__Impl"


    // $ANTLR start "rule__ComponentCategory__Group_8__0"
    // InternalExprParser.g:4061:1: rule__ComponentCategory__Group_8__0 : rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1 ;
    public final void rule__ComponentCategory__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4065:1: ( rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1 )
            // InternalExprParser.g:4066:2: rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1
            {
            pushFollow(FOLLOW_19);
            rule__ComponentCategory__Group_8__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ComponentCategory__Group_8__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategory__Group_8__0"


    // $ANTLR start "rule__ComponentCategory__Group_8__0__Impl"
    // InternalExprParser.g:4073:1: rule__ComponentCategory__Group_8__0__Impl : ( Subprogram ) ;
    public final void rule__ComponentCategory__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4077:1: ( ( Subprogram ) )
            // InternalExprParser.g:4078:1: ( Subprogram )
            {
            // InternalExprParser.g:4078:1: ( Subprogram )
            // InternalExprParser.g:4079:1: Subprogram
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
            }
            match(input,Subprogram,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategory__Group_8__0__Impl"


    // $ANTLR start "rule__ComponentCategory__Group_8__1"
    // InternalExprParser.g:4092:1: rule__ComponentCategory__Group_8__1 : rule__ComponentCategory__Group_8__1__Impl ;
    public final void rule__ComponentCategory__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4096:1: ( rule__ComponentCategory__Group_8__1__Impl )
            // InternalExprParser.g:4097:2: rule__ComponentCategory__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ComponentCategory__Group_8__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategory__Group_8__1"


    // $ANTLR start "rule__ComponentCategory__Group_8__1__Impl"
    // InternalExprParser.g:4103:1: rule__ComponentCategory__Group_8__1__Impl : ( Group ) ;
    public final void rule__ComponentCategory__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4107:1: ( ( Group ) )
            // InternalExprParser.g:4108:1: ( Group )
            {
            // InternalExprParser.g:4108:1: ( Group )
            // InternalExprParser.g:4109:1: Group
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
            }
            match(input,Group,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategory__Group_8__1__Impl"


    // $ANTLR start "rule__ComponentCategory__Group_10__0"
    // InternalExprParser.g:4126:1: rule__ComponentCategory__Group_10__0 : rule__ComponentCategory__Group_10__0__Impl rule__ComponentCategory__Group_10__1 ;
    public final void rule__ComponentCategory__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4130:1: ( rule__ComponentCategory__Group_10__0__Impl rule__ComponentCategory__Group_10__1 )
            // InternalExprParser.g:4131:2: rule__ComponentCategory__Group_10__0__Impl rule__ComponentCategory__Group_10__1
            {
            pushFollow(FOLLOW_19);
            rule__ComponentCategory__Group_10__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ComponentCategory__Group_10__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategory__Group_10__0"


    // $ANTLR start "rule__ComponentCategory__Group_10__0__Impl"
    // InternalExprParser.g:4138:1: rule__ComponentCategory__Group_10__0__Impl : ( Thread ) ;
    public final void rule__ComponentCategory__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4142:1: ( ( Thread ) )
            // InternalExprParser.g:4143:1: ( Thread )
            {
            // InternalExprParser.g:4143:1: ( Thread )
            // InternalExprParser.g:4144:1: Thread
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); 
            }
            match(input,Thread,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategory__Group_10__0__Impl"


    // $ANTLR start "rule__ComponentCategory__Group_10__1"
    // InternalExprParser.g:4157:1: rule__ComponentCategory__Group_10__1 : rule__ComponentCategory__Group_10__1__Impl ;
    public final void rule__ComponentCategory__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4161:1: ( rule__ComponentCategory__Group_10__1__Impl )
            // InternalExprParser.g:4162:2: rule__ComponentCategory__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ComponentCategory__Group_10__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategory__Group_10__1"


    // $ANTLR start "rule__ComponentCategory__Group_10__1__Impl"
    // InternalExprParser.g:4168:1: rule__ComponentCategory__Group_10__1__Impl : ( Group ) ;
    public final void rule__ComponentCategory__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4172:1: ( ( Group ) )
            // InternalExprParser.g:4173:1: ( Group )
            {
            // InternalExprParser.g:4173:1: ( Group )
            // InternalExprParser.g:4174:1: Group
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); 
            }
            match(input,Group,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategory__Group_10__1__Impl"


    // $ANTLR start "rule__ComponentCategory__Group_12__0"
    // InternalExprParser.g:4191:1: rule__ComponentCategory__Group_12__0 : rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1 ;
    public final void rule__ComponentCategory__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4195:1: ( rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1 )
            // InternalExprParser.g:4196:2: rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1
            {
            pushFollow(FOLLOW_20);
            rule__ComponentCategory__Group_12__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ComponentCategory__Group_12__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategory__Group_12__0"


    // $ANTLR start "rule__ComponentCategory__Group_12__0__Impl"
    // InternalExprParser.g:4203:1: rule__ComponentCategory__Group_12__0__Impl : ( Virtual ) ;
    public final void rule__ComponentCategory__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4207:1: ( ( Virtual ) )
            // InternalExprParser.g:4208:1: ( Virtual )
            {
            // InternalExprParser.g:4208:1: ( Virtual )
            // InternalExprParser.g:4209:1: Virtual
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
            }
            match(input,Virtual,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategory__Group_12__0__Impl"


    // $ANTLR start "rule__ComponentCategory__Group_12__1"
    // InternalExprParser.g:4222:1: rule__ComponentCategory__Group_12__1 : rule__ComponentCategory__Group_12__1__Impl ;
    public final void rule__ComponentCategory__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4226:1: ( rule__ComponentCategory__Group_12__1__Impl )
            // InternalExprParser.g:4227:2: rule__ComponentCategory__Group_12__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ComponentCategory__Group_12__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategory__Group_12__1"


    // $ANTLR start "rule__ComponentCategory__Group_12__1__Impl"
    // InternalExprParser.g:4233:1: rule__ComponentCategory__Group_12__1__Impl : ( Bus ) ;
    public final void rule__ComponentCategory__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4237:1: ( ( Bus ) )
            // InternalExprParser.g:4238:1: ( Bus )
            {
            // InternalExprParser.g:4238:1: ( Bus )
            // InternalExprParser.g:4239:1: Bus
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
            }
            match(input,Bus,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategory__Group_12__1__Impl"


    // $ANTLR start "rule__ComponentCategory__Group_13__0"
    // InternalExprParser.g:4256:1: rule__ComponentCategory__Group_13__0 : rule__ComponentCategory__Group_13__0__Impl rule__ComponentCategory__Group_13__1 ;
    public final void rule__ComponentCategory__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4260:1: ( rule__ComponentCategory__Group_13__0__Impl rule__ComponentCategory__Group_13__1 )
            // InternalExprParser.g:4261:2: rule__ComponentCategory__Group_13__0__Impl rule__ComponentCategory__Group_13__1
            {
            pushFollow(FOLLOW_21);
            rule__ComponentCategory__Group_13__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ComponentCategory__Group_13__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategory__Group_13__0"


    // $ANTLR start "rule__ComponentCategory__Group_13__0__Impl"
    // InternalExprParser.g:4268:1: rule__ComponentCategory__Group_13__0__Impl : ( Virtual ) ;
    public final void rule__ComponentCategory__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4272:1: ( ( Virtual ) )
            // InternalExprParser.g:4273:1: ( Virtual )
            {
            // InternalExprParser.g:4273:1: ( Virtual )
            // InternalExprParser.g:4274:1: Virtual
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); 
            }
            match(input,Virtual,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategory__Group_13__0__Impl"


    // $ANTLR start "rule__ComponentCategory__Group_13__1"
    // InternalExprParser.g:4287:1: rule__ComponentCategory__Group_13__1 : rule__ComponentCategory__Group_13__1__Impl ;
    public final void rule__ComponentCategory__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4291:1: ( rule__ComponentCategory__Group_13__1__Impl )
            // InternalExprParser.g:4292:2: rule__ComponentCategory__Group_13__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ComponentCategory__Group_13__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategory__Group_13__1"


    // $ANTLR start "rule__ComponentCategory__Group_13__1__Impl"
    // InternalExprParser.g:4298:1: rule__ComponentCategory__Group_13__1__Impl : ( Processor ) ;
    public final void rule__ComponentCategory__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4302:1: ( ( Processor ) )
            // InternalExprParser.g:4303:1: ( Processor )
            {
            // InternalExprParser.g:4303:1: ( Processor )
            // InternalExprParser.g:4304:1: Processor
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_13_1()); 
            }
            match(input,Processor,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_13_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategory__Group_13__1__Impl"


    // $ANTLR start "rule__ClassifierType__Group__0"
    // InternalExprParser.g:4321:1: rule__ClassifierType__Group__0 : rule__ClassifierType__Group__0__Impl rule__ClassifierType__Group__1 ;
    public final void rule__ClassifierType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4325:1: ( rule__ClassifierType__Group__0__Impl rule__ClassifierType__Group__1 )
            // InternalExprParser.g:4326:2: rule__ClassifierType__Group__0__Impl rule__ClassifierType__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__ClassifierType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassifierType__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierType__Group__0"


    // $ANTLR start "rule__ClassifierType__Group__0__Impl"
    // InternalExprParser.g:4333:1: rule__ClassifierType__Group__0__Impl : ( () ) ;
    public final void rule__ClassifierType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4337:1: ( ( () ) )
            // InternalExprParser.g:4338:1: ( () )
            {
            // InternalExprParser.g:4338:1: ( () )
            // InternalExprParser.g:4339:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeAccess().getClassifierTypeAction_0()); 
            }
            // InternalExprParser.g:4340:1: ()
            // InternalExprParser.g:4342:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassifierTypeAccess().getClassifierTypeAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierType__Group__0__Impl"


    // $ANTLR start "rule__ClassifierType__Group__1"
    // InternalExprParser.g:4352:1: rule__ClassifierType__Group__1 : rule__ClassifierType__Group__1__Impl rule__ClassifierType__Group__2 ;
    public final void rule__ClassifierType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4356:1: ( rule__ClassifierType__Group__1__Impl rule__ClassifierType__Group__2 )
            // InternalExprParser.g:4357:2: rule__ClassifierType__Group__1__Impl rule__ClassifierType__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__ClassifierType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassifierType__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierType__Group__1"


    // $ANTLR start "rule__ClassifierType__Group__1__Impl"
    // InternalExprParser.g:4364:1: rule__ClassifierType__Group__1__Impl : ( Classifier ) ;
    public final void rule__ClassifierType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4368:1: ( ( Classifier ) )
            // InternalExprParser.g:4369:1: ( Classifier )
            {
            // InternalExprParser.g:4369:1: ( Classifier )
            // InternalExprParser.g:4370:1: Classifier
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeAccess().getClassifierKeyword_1()); 
            }
            match(input,Classifier,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassifierTypeAccess().getClassifierKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierType__Group__1__Impl"


    // $ANTLR start "rule__ClassifierType__Group__2"
    // InternalExprParser.g:4383:1: rule__ClassifierType__Group__2 : rule__ClassifierType__Group__2__Impl ;
    public final void rule__ClassifierType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4387:1: ( rule__ClassifierType__Group__2__Impl )
            // InternalExprParser.g:4388:2: rule__ClassifierType__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassifierType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierType__Group__2"


    // $ANTLR start "rule__ClassifierType__Group__2__Impl"
    // InternalExprParser.g:4394:1: rule__ClassifierType__Group__2__Impl : ( ( rule__ClassifierType__Group_2__0 )? ) ;
    public final void rule__ClassifierType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4398:1: ( ( ( rule__ClassifierType__Group_2__0 )? ) )
            // InternalExprParser.g:4399:1: ( ( rule__ClassifierType__Group_2__0 )? )
            {
            // InternalExprParser.g:4399:1: ( ( rule__ClassifierType__Group_2__0 )? )
            // InternalExprParser.g:4400:1: ( rule__ClassifierType__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeAccess().getGroup_2()); 
            }
            // InternalExprParser.g:4401:1: ( rule__ClassifierType__Group_2__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==LeftParenthesis) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalExprParser.g:4401:2: rule__ClassifierType__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassifierType__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassifierTypeAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierType__Group__2__Impl"


    // $ANTLR start "rule__ClassifierType__Group_2__0"
    // InternalExprParser.g:4417:1: rule__ClassifierType__Group_2__0 : rule__ClassifierType__Group_2__0__Impl rule__ClassifierType__Group_2__1 ;
    public final void rule__ClassifierType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4421:1: ( rule__ClassifierType__Group_2__0__Impl rule__ClassifierType__Group_2__1 )
            // InternalExprParser.g:4422:2: rule__ClassifierType__Group_2__0__Impl rule__ClassifierType__Group_2__1
            {
            pushFollow(FOLLOW_9);
            rule__ClassifierType__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassifierType__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierType__Group_2__0"


    // $ANTLR start "rule__ClassifierType__Group_2__0__Impl"
    // InternalExprParser.g:4429:1: rule__ClassifierType__Group_2__0__Impl : ( LeftParenthesis ) ;
    public final void rule__ClassifierType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4433:1: ( ( LeftParenthesis ) )
            // InternalExprParser.g:4434:1: ( LeftParenthesis )
            {
            // InternalExprParser.g:4434:1: ( LeftParenthesis )
            // InternalExprParser.g:4435:1: LeftParenthesis
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeAccess().getLeftParenthesisKeyword_2_0()); 
            }
            match(input,LeftParenthesis,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassifierTypeAccess().getLeftParenthesisKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierType__Group_2__0__Impl"


    // $ANTLR start "rule__ClassifierType__Group_2__1"
    // InternalExprParser.g:4448:1: rule__ClassifierType__Group_2__1 : rule__ClassifierType__Group_2__1__Impl rule__ClassifierType__Group_2__2 ;
    public final void rule__ClassifierType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4452:1: ( rule__ClassifierType__Group_2__1__Impl rule__ClassifierType__Group_2__2 )
            // InternalExprParser.g:4453:2: rule__ClassifierType__Group_2__1__Impl rule__ClassifierType__Group_2__2
            {
            pushFollow(FOLLOW_14);
            rule__ClassifierType__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassifierType__Group_2__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierType__Group_2__1"


    // $ANTLR start "rule__ClassifierType__Group_2__1__Impl"
    // InternalExprParser.g:4460:1: rule__ClassifierType__Group_2__1__Impl : ( ( rule__ClassifierType__BaseAssignment_2_1 ) ) ;
    public final void rule__ClassifierType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4464:1: ( ( ( rule__ClassifierType__BaseAssignment_2_1 ) ) )
            // InternalExprParser.g:4465:1: ( ( rule__ClassifierType__BaseAssignment_2_1 ) )
            {
            // InternalExprParser.g:4465:1: ( ( rule__ClassifierType__BaseAssignment_2_1 ) )
            // InternalExprParser.g:4466:1: ( rule__ClassifierType__BaseAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeAccess().getBaseAssignment_2_1()); 
            }
            // InternalExprParser.g:4467:1: ( rule__ClassifierType__BaseAssignment_2_1 )
            // InternalExprParser.g:4467:2: rule__ClassifierType__BaseAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__ClassifierType__BaseAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassifierTypeAccess().getBaseAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierType__Group_2__1__Impl"


    // $ANTLR start "rule__ClassifierType__Group_2__2"
    // InternalExprParser.g:4477:1: rule__ClassifierType__Group_2__2 : rule__ClassifierType__Group_2__2__Impl ;
    public final void rule__ClassifierType__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4481:1: ( rule__ClassifierType__Group_2__2__Impl )
            // InternalExprParser.g:4482:2: rule__ClassifierType__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassifierType__Group_2__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierType__Group_2__2"


    // $ANTLR start "rule__ClassifierType__Group_2__2__Impl"
    // InternalExprParser.g:4488:1: rule__ClassifierType__Group_2__2__Impl : ( RightParenthesis ) ;
    public final void rule__ClassifierType__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4492:1: ( ( RightParenthesis ) )
            // InternalExprParser.g:4493:1: ( RightParenthesis )
            {
            // InternalExprParser.g:4493:1: ( RightParenthesis )
            // InternalExprParser.g:4494:1: RightParenthesis
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeAccess().getRightParenthesisKeyword_2_2()); 
            }
            match(input,RightParenthesis,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassifierTypeAccess().getRightParenthesisKeyword_2_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierType__Group_2__2__Impl"


    // $ANTLR start "rule__RecordType__Group__0"
    // InternalExprParser.g:4513:1: rule__RecordType__Group__0 : rule__RecordType__Group__0__Impl rule__RecordType__Group__1 ;
    public final void rule__RecordType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4517:1: ( rule__RecordType__Group__0__Impl rule__RecordType__Group__1 )
            // InternalExprParser.g:4518:2: rule__RecordType__Group__0__Impl rule__RecordType__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__RecordType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RecordType__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecordType__Group__0"


    // $ANTLR start "rule__RecordType__Group__0__Impl"
    // InternalExprParser.g:4525:1: rule__RecordType__Group__0__Impl : ( () ) ;
    public final void rule__RecordType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4529:1: ( ( () ) )
            // InternalExprParser.g:4530:1: ( () )
            {
            // InternalExprParser.g:4530:1: ( () )
            // InternalExprParser.g:4531:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecordTypeAccess().getRecordTypeAction_0()); 
            }
            // InternalExprParser.g:4532:1: ()
            // InternalExprParser.g:4534:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecordTypeAccess().getRecordTypeAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecordType__Group__0__Impl"


    // $ANTLR start "rule__RecordType__Group__1"
    // InternalExprParser.g:4544:1: rule__RecordType__Group__1 : rule__RecordType__Group__1__Impl rule__RecordType__Group__2 ;
    public final void rule__RecordType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4548:1: ( rule__RecordType__Group__1__Impl rule__RecordType__Group__2 )
            // InternalExprParser.g:4549:2: rule__RecordType__Group__1__Impl rule__RecordType__Group__2
            {
            pushFollow(FOLLOW_24);
            rule__RecordType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RecordType__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecordType__Group__1"


    // $ANTLR start "rule__RecordType__Group__1__Impl"
    // InternalExprParser.g:4556:1: rule__RecordType__Group__1__Impl : ( Record ) ;
    public final void rule__RecordType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4560:1: ( ( Record ) )
            // InternalExprParser.g:4561:1: ( Record )
            {
            // InternalExprParser.g:4561:1: ( Record )
            // InternalExprParser.g:4562:1: Record
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecordTypeAccess().getRecordKeyword_1()); 
            }
            match(input,Record,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecordTypeAccess().getRecordKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecordType__Group__1__Impl"


    // $ANTLR start "rule__RecordType__Group__2"
    // InternalExprParser.g:4575:1: rule__RecordType__Group__2 : rule__RecordType__Group__2__Impl rule__RecordType__Group__3 ;
    public final void rule__RecordType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4579:1: ( rule__RecordType__Group__2__Impl rule__RecordType__Group__3 )
            // InternalExprParser.g:4580:2: rule__RecordType__Group__2__Impl rule__RecordType__Group__3
            {
            pushFollow(FOLLOW_25);
            rule__RecordType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RecordType__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecordType__Group__2"


    // $ANTLR start "rule__RecordType__Group__2__Impl"
    // InternalExprParser.g:4587:1: rule__RecordType__Group__2__Impl : ( LeftCurlyBracket ) ;
    public final void rule__RecordType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4591:1: ( ( LeftCurlyBracket ) )
            // InternalExprParser.g:4592:1: ( LeftCurlyBracket )
            {
            // InternalExprParser.g:4592:1: ( LeftCurlyBracket )
            // InternalExprParser.g:4593:1: LeftCurlyBracket
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecordTypeAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,LeftCurlyBracket,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecordTypeAccess().getLeftCurlyBracketKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecordType__Group__2__Impl"


    // $ANTLR start "rule__RecordType__Group__3"
    // InternalExprParser.g:4606:1: rule__RecordType__Group__3 : rule__RecordType__Group__3__Impl rule__RecordType__Group__4 ;
    public final void rule__RecordType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4610:1: ( rule__RecordType__Group__3__Impl rule__RecordType__Group__4 )
            // InternalExprParser.g:4611:2: rule__RecordType__Group__3__Impl rule__RecordType__Group__4
            {
            pushFollow(FOLLOW_25);
            rule__RecordType__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RecordType__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecordType__Group__3"


    // $ANTLR start "rule__RecordType__Group__3__Impl"
    // InternalExprParser.g:4618:1: rule__RecordType__Group__3__Impl : ( ( rule__RecordType__FieldAssignment_3 )* ) ;
    public final void rule__RecordType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4622:1: ( ( ( rule__RecordType__FieldAssignment_3 )* ) )
            // InternalExprParser.g:4623:1: ( ( rule__RecordType__FieldAssignment_3 )* )
            {
            // InternalExprParser.g:4623:1: ( ( rule__RecordType__FieldAssignment_3 )* )
            // InternalExprParser.g:4624:1: ( rule__RecordType__FieldAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecordTypeAccess().getFieldAssignment_3()); 
            }
            // InternalExprParser.g:4625:1: ( rule__RecordType__FieldAssignment_3 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalExprParser.g:4625:2: rule__RecordType__FieldAssignment_3
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__RecordType__FieldAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecordTypeAccess().getFieldAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecordType__Group__3__Impl"


    // $ANTLR start "rule__RecordType__Group__4"
    // InternalExprParser.g:4635:1: rule__RecordType__Group__4 : rule__RecordType__Group__4__Impl ;
    public final void rule__RecordType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4639:1: ( rule__RecordType__Group__4__Impl )
            // InternalExprParser.g:4640:2: rule__RecordType__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RecordType__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecordType__Group__4"


    // $ANTLR start "rule__RecordType__Group__4__Impl"
    // InternalExprParser.g:4646:1: rule__RecordType__Group__4__Impl : ( RightCurlyBracket ) ;
    public final void rule__RecordType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4650:1: ( ( RightCurlyBracket ) )
            // InternalExprParser.g:4651:1: ( RightCurlyBracket )
            {
            // InternalExprParser.g:4651:1: ( RightCurlyBracket )
            // InternalExprParser.g:4652:1: RightCurlyBracket
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecordTypeAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecordTypeAccess().getRightCurlyBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecordType__Group__4__Impl"


    // $ANTLR start "rule__Field__Group__0"
    // InternalExprParser.g:4675:1: rule__Field__Group__0 : rule__Field__Group__0__Impl rule__Field__Group__1 ;
    public final void rule__Field__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4679:1: ( rule__Field__Group__0__Impl rule__Field__Group__1 )
            // InternalExprParser.g:4680:2: rule__Field__Group__0__Impl rule__Field__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__Field__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Field__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__0"


    // $ANTLR start "rule__Field__Group__0__Impl"
    // InternalExprParser.g:4687:1: rule__Field__Group__0__Impl : ( ( rule__Field__NameAssignment_0 ) ) ;
    public final void rule__Field__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4691:1: ( ( ( rule__Field__NameAssignment_0 ) ) )
            // InternalExprParser.g:4692:1: ( ( rule__Field__NameAssignment_0 ) )
            {
            // InternalExprParser.g:4692:1: ( ( rule__Field__NameAssignment_0 ) )
            // InternalExprParser.g:4693:1: ( rule__Field__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getNameAssignment_0()); 
            }
            // InternalExprParser.g:4694:1: ( rule__Field__NameAssignment_0 )
            // InternalExprParser.g:4694:2: rule__Field__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Field__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getNameAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__0__Impl"


    // $ANTLR start "rule__Field__Group__1"
    // InternalExprParser.g:4704:1: rule__Field__Group__1 : rule__Field__Group__1__Impl rule__Field__Group__2 ;
    public final void rule__Field__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4708:1: ( rule__Field__Group__1__Impl rule__Field__Group__2 )
            // InternalExprParser.g:4709:2: rule__Field__Group__1__Impl rule__Field__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__Field__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Field__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__1"


    // $ANTLR start "rule__Field__Group__1__Impl"
    // InternalExprParser.g:4716:1: rule__Field__Group__1__Impl : ( Colon ) ;
    public final void rule__Field__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4720:1: ( ( Colon ) )
            // InternalExprParser.g:4721:1: ( Colon )
            {
            // InternalExprParser.g:4721:1: ( Colon )
            // InternalExprParser.g:4722:1: Colon
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getColonKeyword_1()); 
            }
            match(input,Colon,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getColonKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__1__Impl"


    // $ANTLR start "rule__Field__Group__2"
    // InternalExprParser.g:4735:1: rule__Field__Group__2 : rule__Field__Group__2__Impl rule__Field__Group__3 ;
    public final void rule__Field__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4739:1: ( rule__Field__Group__2__Impl rule__Field__Group__3 )
            // InternalExprParser.g:4740:2: rule__Field__Group__2__Impl rule__Field__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__Field__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Field__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__2"


    // $ANTLR start "rule__Field__Group__2__Impl"
    // InternalExprParser.g:4747:1: rule__Field__Group__2__Impl : ( ( rule__Field__TypeAssignment_2 ) ) ;
    public final void rule__Field__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4751:1: ( ( ( rule__Field__TypeAssignment_2 ) ) )
            // InternalExprParser.g:4752:1: ( ( rule__Field__TypeAssignment_2 ) )
            {
            // InternalExprParser.g:4752:1: ( ( rule__Field__TypeAssignment_2 ) )
            // InternalExprParser.g:4753:1: ( rule__Field__TypeAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getTypeAssignment_2()); 
            }
            // InternalExprParser.g:4754:1: ( rule__Field__TypeAssignment_2 )
            // InternalExprParser.g:4754:2: rule__Field__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Field__TypeAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getTypeAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__2__Impl"


    // $ANTLR start "rule__Field__Group__3"
    // InternalExprParser.g:4764:1: rule__Field__Group__3 : rule__Field__Group__3__Impl ;
    public final void rule__Field__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4768:1: ( rule__Field__Group__3__Impl )
            // InternalExprParser.g:4769:2: rule__Field__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Field__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__3"


    // $ANTLR start "rule__Field__Group__3__Impl"
    // InternalExprParser.g:4775:1: rule__Field__Group__3__Impl : ( Semicolon ) ;
    public final void rule__Field__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4779:1: ( ( Semicolon ) )
            // InternalExprParser.g:4780:1: ( Semicolon )
            {
            // InternalExprParser.g:4780:1: ( Semicolon )
            // InternalExprParser.g:4781:1: Semicolon
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getSemicolonKeyword_3()); 
            }
            match(input,Semicolon,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getSemicolonKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__3__Impl"


    // $ANTLR start "rule__UnionType__Group__0"
    // InternalExprParser.g:4802:1: rule__UnionType__Group__0 : rule__UnionType__Group__0__Impl rule__UnionType__Group__1 ;
    public final void rule__UnionType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4806:1: ( rule__UnionType__Group__0__Impl rule__UnionType__Group__1 )
            // InternalExprParser.g:4807:2: rule__UnionType__Group__0__Impl rule__UnionType__Group__1
            {
            pushFollow(FOLLOW_27);
            rule__UnionType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UnionType__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnionType__Group__0"


    // $ANTLR start "rule__UnionType__Group__0__Impl"
    // InternalExprParser.g:4814:1: rule__UnionType__Group__0__Impl : ( () ) ;
    public final void rule__UnionType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4818:1: ( ( () ) )
            // InternalExprParser.g:4819:1: ( () )
            {
            // InternalExprParser.g:4819:1: ( () )
            // InternalExprParser.g:4820:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnionTypeAccess().getUnionTypeAction_0()); 
            }
            // InternalExprParser.g:4821:1: ()
            // InternalExprParser.g:4823:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnionTypeAccess().getUnionTypeAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnionType__Group__0__Impl"


    // $ANTLR start "rule__UnionType__Group__1"
    // InternalExprParser.g:4833:1: rule__UnionType__Group__1 : rule__UnionType__Group__1__Impl rule__UnionType__Group__2 ;
    public final void rule__UnionType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4837:1: ( rule__UnionType__Group__1__Impl rule__UnionType__Group__2 )
            // InternalExprParser.g:4838:2: rule__UnionType__Group__1__Impl rule__UnionType__Group__2
            {
            pushFollow(FOLLOW_24);
            rule__UnionType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UnionType__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnionType__Group__1"


    // $ANTLR start "rule__UnionType__Group__1__Impl"
    // InternalExprParser.g:4845:1: rule__UnionType__Group__1__Impl : ( Union ) ;
    public final void rule__UnionType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4849:1: ( ( Union ) )
            // InternalExprParser.g:4850:1: ( Union )
            {
            // InternalExprParser.g:4850:1: ( Union )
            // InternalExprParser.g:4851:1: Union
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnionTypeAccess().getUnionKeyword_1()); 
            }
            match(input,Union,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnionTypeAccess().getUnionKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnionType__Group__1__Impl"


    // $ANTLR start "rule__UnionType__Group__2"
    // InternalExprParser.g:4864:1: rule__UnionType__Group__2 : rule__UnionType__Group__2__Impl rule__UnionType__Group__3 ;
    public final void rule__UnionType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4868:1: ( rule__UnionType__Group__2__Impl rule__UnionType__Group__3 )
            // InternalExprParser.g:4869:2: rule__UnionType__Group__2__Impl rule__UnionType__Group__3
            {
            pushFollow(FOLLOW_28);
            rule__UnionType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UnionType__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnionType__Group__2"


    // $ANTLR start "rule__UnionType__Group__2__Impl"
    // InternalExprParser.g:4876:1: rule__UnionType__Group__2__Impl : ( LeftCurlyBracket ) ;
    public final void rule__UnionType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4880:1: ( ( LeftCurlyBracket ) )
            // InternalExprParser.g:4881:1: ( LeftCurlyBracket )
            {
            // InternalExprParser.g:4881:1: ( LeftCurlyBracket )
            // InternalExprParser.g:4882:1: LeftCurlyBracket
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnionTypeAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,LeftCurlyBracket,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnionTypeAccess().getLeftCurlyBracketKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnionType__Group__2__Impl"


    // $ANTLR start "rule__UnionType__Group__3"
    // InternalExprParser.g:4895:1: rule__UnionType__Group__3 : rule__UnionType__Group__3__Impl rule__UnionType__Group__4 ;
    public final void rule__UnionType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4899:1: ( rule__UnionType__Group__3__Impl rule__UnionType__Group__4 )
            // InternalExprParser.g:4900:2: rule__UnionType__Group__3__Impl rule__UnionType__Group__4
            {
            pushFollow(FOLLOW_29);
            rule__UnionType__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UnionType__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnionType__Group__3"


    // $ANTLR start "rule__UnionType__Group__3__Impl"
    // InternalExprParser.g:4907:1: rule__UnionType__Group__3__Impl : ( QuestionMarkQuestionMarkQuestionMark ) ;
    public final void rule__UnionType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4911:1: ( ( QuestionMarkQuestionMarkQuestionMark ) )
            // InternalExprParser.g:4912:1: ( QuestionMarkQuestionMarkQuestionMark )
            {
            // InternalExprParser.g:4912:1: ( QuestionMarkQuestionMarkQuestionMark )
            // InternalExprParser.g:4913:1: QuestionMarkQuestionMarkQuestionMark
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnionTypeAccess().getQuestionMarkQuestionMarkQuestionMarkKeyword_3()); 
            }
            match(input,QuestionMarkQuestionMarkQuestionMark,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnionTypeAccess().getQuestionMarkQuestionMarkQuestionMarkKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnionType__Group__3__Impl"


    // $ANTLR start "rule__UnionType__Group__4"
    // InternalExprParser.g:4926:1: rule__UnionType__Group__4 : rule__UnionType__Group__4__Impl ;
    public final void rule__UnionType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4930:1: ( rule__UnionType__Group__4__Impl )
            // InternalExprParser.g:4931:2: rule__UnionType__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UnionType__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnionType__Group__4"


    // $ANTLR start "rule__UnionType__Group__4__Impl"
    // InternalExprParser.g:4937:1: rule__UnionType__Group__4__Impl : ( RightCurlyBracket ) ;
    public final void rule__UnionType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4941:1: ( ( RightCurlyBracket ) )
            // InternalExprParser.g:4942:1: ( RightCurlyBracket )
            {
            // InternalExprParser.g:4942:1: ( RightCurlyBracket )
            // InternalExprParser.g:4943:1: RightCurlyBracket
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnionTypeAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnionTypeAccess().getRightCurlyBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnionType__Group__4__Impl"


    // $ANTLR start "rule__TupleType__Group__0"
    // InternalExprParser.g:4966:1: rule__TupleType__Group__0 : rule__TupleType__Group__0__Impl rule__TupleType__Group__1 ;
    public final void rule__TupleType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4970:1: ( rule__TupleType__Group__0__Impl rule__TupleType__Group__1 )
            // InternalExprParser.g:4971:2: rule__TupleType__Group__0__Impl rule__TupleType__Group__1
            {
            pushFollow(FOLLOW_30);
            rule__TupleType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TupleType__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleType__Group__0"


    // $ANTLR start "rule__TupleType__Group__0__Impl"
    // InternalExprParser.g:4978:1: rule__TupleType__Group__0__Impl : ( () ) ;
    public final void rule__TupleType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4982:1: ( ( () ) )
            // InternalExprParser.g:4983:1: ( () )
            {
            // InternalExprParser.g:4983:1: ( () )
            // InternalExprParser.g:4984:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleTypeAccess().getTupleTypeAction_0()); 
            }
            // InternalExprParser.g:4985:1: ()
            // InternalExprParser.g:4987:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTupleTypeAccess().getTupleTypeAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleType__Group__0__Impl"


    // $ANTLR start "rule__TupleType__Group__1"
    // InternalExprParser.g:4997:1: rule__TupleType__Group__1 : rule__TupleType__Group__1__Impl rule__TupleType__Group__2 ;
    public final void rule__TupleType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5001:1: ( rule__TupleType__Group__1__Impl rule__TupleType__Group__2 )
            // InternalExprParser.g:5002:2: rule__TupleType__Group__1__Impl rule__TupleType__Group__2
            {
            pushFollow(FOLLOW_24);
            rule__TupleType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TupleType__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleType__Group__1"


    // $ANTLR start "rule__TupleType__Group__1__Impl"
    // InternalExprParser.g:5009:1: rule__TupleType__Group__1__Impl : ( Tuple ) ;
    public final void rule__TupleType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5013:1: ( ( Tuple ) )
            // InternalExprParser.g:5014:1: ( Tuple )
            {
            // InternalExprParser.g:5014:1: ( Tuple )
            // InternalExprParser.g:5015:1: Tuple
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleTypeAccess().getTupleKeyword_1()); 
            }
            match(input,Tuple,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTupleTypeAccess().getTupleKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleType__Group__1__Impl"


    // $ANTLR start "rule__TupleType__Group__2"
    // InternalExprParser.g:5028:1: rule__TupleType__Group__2 : rule__TupleType__Group__2__Impl rule__TupleType__Group__3 ;
    public final void rule__TupleType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5032:1: ( rule__TupleType__Group__2__Impl rule__TupleType__Group__3 )
            // InternalExprParser.g:5033:2: rule__TupleType__Group__2__Impl rule__TupleType__Group__3
            {
            pushFollow(FOLLOW_31);
            rule__TupleType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TupleType__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleType__Group__2"


    // $ANTLR start "rule__TupleType__Group__2__Impl"
    // InternalExprParser.g:5040:1: rule__TupleType__Group__2__Impl : ( LeftCurlyBracket ) ;
    public final void rule__TupleType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5044:1: ( ( LeftCurlyBracket ) )
            // InternalExprParser.g:5045:1: ( LeftCurlyBracket )
            {
            // InternalExprParser.g:5045:1: ( LeftCurlyBracket )
            // InternalExprParser.g:5046:1: LeftCurlyBracket
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleTypeAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,LeftCurlyBracket,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTupleTypeAccess().getLeftCurlyBracketKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleType__Group__2__Impl"


    // $ANTLR start "rule__TupleType__Group__3"
    // InternalExprParser.g:5059:1: rule__TupleType__Group__3 : rule__TupleType__Group__3__Impl rule__TupleType__Group__4 ;
    public final void rule__TupleType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5063:1: ( rule__TupleType__Group__3__Impl rule__TupleType__Group__4 )
            // InternalExprParser.g:5064:2: rule__TupleType__Group__3__Impl rule__TupleType__Group__4
            {
            pushFollow(FOLLOW_31);
            rule__TupleType__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TupleType__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleType__Group__3"


    // $ANTLR start "rule__TupleType__Group__3__Impl"
    // InternalExprParser.g:5071:1: rule__TupleType__Group__3__Impl : ( ( rule__TupleType__FieldAssignment_3 )* ) ;
    public final void rule__TupleType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5075:1: ( ( ( rule__TupleType__FieldAssignment_3 )* ) )
            // InternalExprParser.g:5076:1: ( ( rule__TupleType__FieldAssignment_3 )* )
            {
            // InternalExprParser.g:5076:1: ( ( rule__TupleType__FieldAssignment_3 )* )
            // InternalExprParser.g:5077:1: ( rule__TupleType__FieldAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleTypeAccess().getFieldAssignment_3()); 
            }
            // InternalExprParser.g:5078:1: ( rule__TupleType__FieldAssignment_3 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=Subcomponent && LA29_0<=Processor)||LA29_0==Abstract||LA29_0==Feature||(LA29_0>=Process && LA29_0<=Thread)||(LA29_0>=Tuple && LA29_0<=Data)||(LA29_0>=Flow && LA29_0<=Real)||(LA29_0>=Bag && LA29_0<=Bus)||(LA29_0>=Int && LA29_0<=Map)||LA29_0==Set||LA29_0==RULE_ID) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalExprParser.g:5078:2: rule__TupleType__FieldAssignment_3
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__TupleType__FieldAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTupleTypeAccess().getFieldAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleType__Group__3__Impl"


    // $ANTLR start "rule__TupleType__Group__4"
    // InternalExprParser.g:5088:1: rule__TupleType__Group__4 : rule__TupleType__Group__4__Impl ;
    public final void rule__TupleType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5092:1: ( rule__TupleType__Group__4__Impl )
            // InternalExprParser.g:5093:2: rule__TupleType__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TupleType__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleType__Group__4"


    // $ANTLR start "rule__TupleType__Group__4__Impl"
    // InternalExprParser.g:5099:1: rule__TupleType__Group__4__Impl : ( RightCurlyBracket ) ;
    public final void rule__TupleType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5103:1: ( ( RightCurlyBracket ) )
            // InternalExprParser.g:5104:1: ( RightCurlyBracket )
            {
            // InternalExprParser.g:5104:1: ( RightCurlyBracket )
            // InternalExprParser.g:5105:1: RightCurlyBracket
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleTypeAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTupleTypeAccess().getRightCurlyBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleType__Group__4__Impl"


    // $ANTLR start "rule__TupleField__Group__0"
    // InternalExprParser.g:5128:1: rule__TupleField__Group__0 : rule__TupleField__Group__0__Impl rule__TupleField__Group__1 ;
    public final void rule__TupleField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5132:1: ( rule__TupleField__Group__0__Impl rule__TupleField__Group__1 )
            // InternalExprParser.g:5133:2: rule__TupleField__Group__0__Impl rule__TupleField__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__TupleField__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TupleField__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleField__Group__0"


    // $ANTLR start "rule__TupleField__Group__0__Impl"
    // InternalExprParser.g:5140:1: rule__TupleField__Group__0__Impl : ( () ) ;
    public final void rule__TupleField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5144:1: ( ( () ) )
            // InternalExprParser.g:5145:1: ( () )
            {
            // InternalExprParser.g:5145:1: ( () )
            // InternalExprParser.g:5146:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleFieldAccess().getFieldAction_0()); 
            }
            // InternalExprParser.g:5147:1: ()
            // InternalExprParser.g:5149:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTupleFieldAccess().getFieldAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleField__Group__0__Impl"


    // $ANTLR start "rule__TupleField__Group__1"
    // InternalExprParser.g:5159:1: rule__TupleField__Group__1 : rule__TupleField__Group__1__Impl ;
    public final void rule__TupleField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5163:1: ( rule__TupleField__Group__1__Impl )
            // InternalExprParser.g:5164:2: rule__TupleField__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TupleField__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleField__Group__1"


    // $ANTLR start "rule__TupleField__Group__1__Impl"
    // InternalExprParser.g:5170:1: rule__TupleField__Group__1__Impl : ( ( rule__TupleField__TypeAssignment_1 ) ) ;
    public final void rule__TupleField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5174:1: ( ( ( rule__TupleField__TypeAssignment_1 ) ) )
            // InternalExprParser.g:5175:1: ( ( rule__TupleField__TypeAssignment_1 ) )
            {
            // InternalExprParser.g:5175:1: ( ( rule__TupleField__TypeAssignment_1 ) )
            // InternalExprParser.g:5176:1: ( rule__TupleField__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleFieldAccess().getTypeAssignment_1()); 
            }
            // InternalExprParser.g:5177:1: ( rule__TupleField__TypeAssignment_1 )
            // InternalExprParser.g:5177:2: rule__TupleField__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TupleField__TypeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTupleFieldAccess().getTypeAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleField__Group__1__Impl"


    // $ANTLR start "rule__ListType__Group__0"
    // InternalExprParser.g:5191:1: rule__ListType__Group__0 : rule__ListType__Group__0__Impl rule__ListType__Group__1 ;
    public final void rule__ListType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5195:1: ( rule__ListType__Group__0__Impl rule__ListType__Group__1 )
            // InternalExprParser.g:5196:2: rule__ListType__Group__0__Impl rule__ListType__Group__1
            {
            pushFollow(FOLLOW_33);
            rule__ListType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ListType__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group__0"


    // $ANTLR start "rule__ListType__Group__0__Impl"
    // InternalExprParser.g:5203:1: rule__ListType__Group__0__Impl : ( () ) ;
    public final void rule__ListType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5207:1: ( ( () ) )
            // InternalExprParser.g:5208:1: ( () )
            {
            // InternalExprParser.g:5208:1: ( () )
            // InternalExprParser.g:5209:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListTypeAccess().getListTypeAction_0()); 
            }
            // InternalExprParser.g:5210:1: ()
            // InternalExprParser.g:5212:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getListTypeAccess().getListTypeAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group__0__Impl"


    // $ANTLR start "rule__ListType__Group__1"
    // InternalExprParser.g:5222:1: rule__ListType__Group__1 : rule__ListType__Group__1__Impl rule__ListType__Group__2 ;
    public final void rule__ListType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5226:1: ( rule__ListType__Group__1__Impl rule__ListType__Group__2 )
            // InternalExprParser.g:5227:2: rule__ListType__Group__1__Impl rule__ListType__Group__2
            {
            pushFollow(FOLLOW_34);
            rule__ListType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ListType__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group__1"


    // $ANTLR start "rule__ListType__Group__1__Impl"
    // InternalExprParser.g:5234:1: rule__ListType__Group__1__Impl : ( List ) ;
    public final void rule__ListType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5238:1: ( ( List ) )
            // InternalExprParser.g:5239:1: ( List )
            {
            // InternalExprParser.g:5239:1: ( List )
            // InternalExprParser.g:5240:1: List
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListTypeAccess().getListKeyword_1()); 
            }
            match(input,List,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getListTypeAccess().getListKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group__1__Impl"


    // $ANTLR start "rule__ListType__Group__2"
    // InternalExprParser.g:5253:1: rule__ListType__Group__2 : rule__ListType__Group__2__Impl rule__ListType__Group__3 ;
    public final void rule__ListType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5257:1: ( rule__ListType__Group__2__Impl rule__ListType__Group__3 )
            // InternalExprParser.g:5258:2: rule__ListType__Group__2__Impl rule__ListType__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__ListType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ListType__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group__2"


    // $ANTLR start "rule__ListType__Group__2__Impl"
    // InternalExprParser.g:5265:1: rule__ListType__Group__2__Impl : ( Of ) ;
    public final void rule__ListType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5269:1: ( ( Of ) )
            // InternalExprParser.g:5270:1: ( Of )
            {
            // InternalExprParser.g:5270:1: ( Of )
            // InternalExprParser.g:5271:1: Of
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListTypeAccess().getOfKeyword_2()); 
            }
            match(input,Of,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getListTypeAccess().getOfKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group__2__Impl"


    // $ANTLR start "rule__ListType__Group__3"
    // InternalExprParser.g:5284:1: rule__ListType__Group__3 : rule__ListType__Group__3__Impl ;
    public final void rule__ListType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5288:1: ( rule__ListType__Group__3__Impl )
            // InternalExprParser.g:5289:2: rule__ListType__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ListType__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group__3"


    // $ANTLR start "rule__ListType__Group__3__Impl"
    // InternalExprParser.g:5295:1: rule__ListType__Group__3__Impl : ( ( rule__ListType__TypeAssignment_3 ) ) ;
    public final void rule__ListType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5299:1: ( ( ( rule__ListType__TypeAssignment_3 ) ) )
            // InternalExprParser.g:5300:1: ( ( rule__ListType__TypeAssignment_3 ) )
            {
            // InternalExprParser.g:5300:1: ( ( rule__ListType__TypeAssignment_3 ) )
            // InternalExprParser.g:5301:1: ( rule__ListType__TypeAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListTypeAccess().getTypeAssignment_3()); 
            }
            // InternalExprParser.g:5302:1: ( rule__ListType__TypeAssignment_3 )
            // InternalExprParser.g:5302:2: rule__ListType__TypeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__ListType__TypeAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getListTypeAccess().getTypeAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group__3__Impl"


    // $ANTLR start "rule__SetType__Group__0"
    // InternalExprParser.g:5320:1: rule__SetType__Group__0 : rule__SetType__Group__0__Impl rule__SetType__Group__1 ;
    public final void rule__SetType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5324:1: ( rule__SetType__Group__0__Impl rule__SetType__Group__1 )
            // InternalExprParser.g:5325:2: rule__SetType__Group__0__Impl rule__SetType__Group__1
            {
            pushFollow(FOLLOW_34);
            rule__SetType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SetType__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetType__Group__0"


    // $ANTLR start "rule__SetType__Group__0__Impl"
    // InternalExprParser.g:5332:1: rule__SetType__Group__0__Impl : ( Set ) ;
    public final void rule__SetType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5336:1: ( ( Set ) )
            // InternalExprParser.g:5337:1: ( Set )
            {
            // InternalExprParser.g:5337:1: ( Set )
            // InternalExprParser.g:5338:1: Set
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSetTypeAccess().getSetKeyword_0()); 
            }
            match(input,Set,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSetTypeAccess().getSetKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetType__Group__0__Impl"


    // $ANTLR start "rule__SetType__Group__1"
    // InternalExprParser.g:5351:1: rule__SetType__Group__1 : rule__SetType__Group__1__Impl rule__SetType__Group__2 ;
    public final void rule__SetType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5355:1: ( rule__SetType__Group__1__Impl rule__SetType__Group__2 )
            // InternalExprParser.g:5356:2: rule__SetType__Group__1__Impl rule__SetType__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__SetType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SetType__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetType__Group__1"


    // $ANTLR start "rule__SetType__Group__1__Impl"
    // InternalExprParser.g:5363:1: rule__SetType__Group__1__Impl : ( Of ) ;
    public final void rule__SetType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5367:1: ( ( Of ) )
            // InternalExprParser.g:5368:1: ( Of )
            {
            // InternalExprParser.g:5368:1: ( Of )
            // InternalExprParser.g:5369:1: Of
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSetTypeAccess().getOfKeyword_1()); 
            }
            match(input,Of,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSetTypeAccess().getOfKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetType__Group__1__Impl"


    // $ANTLR start "rule__SetType__Group__2"
    // InternalExprParser.g:5382:1: rule__SetType__Group__2 : rule__SetType__Group__2__Impl ;
    public final void rule__SetType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5386:1: ( rule__SetType__Group__2__Impl )
            // InternalExprParser.g:5387:2: rule__SetType__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SetType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetType__Group__2"


    // $ANTLR start "rule__SetType__Group__2__Impl"
    // InternalExprParser.g:5393:1: rule__SetType__Group__2__Impl : ( ( rule__SetType__TypeAssignment_2 ) ) ;
    public final void rule__SetType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5397:1: ( ( ( rule__SetType__TypeAssignment_2 ) ) )
            // InternalExprParser.g:5398:1: ( ( rule__SetType__TypeAssignment_2 ) )
            {
            // InternalExprParser.g:5398:1: ( ( rule__SetType__TypeAssignment_2 ) )
            // InternalExprParser.g:5399:1: ( rule__SetType__TypeAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSetTypeAccess().getTypeAssignment_2()); 
            }
            // InternalExprParser.g:5400:1: ( rule__SetType__TypeAssignment_2 )
            // InternalExprParser.g:5400:2: rule__SetType__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__SetType__TypeAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSetTypeAccess().getTypeAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetType__Group__2__Impl"


    // $ANTLR start "rule__BagType__Group__0"
    // InternalExprParser.g:5416:1: rule__BagType__Group__0 : rule__BagType__Group__0__Impl rule__BagType__Group__1 ;
    public final void rule__BagType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5420:1: ( rule__BagType__Group__0__Impl rule__BagType__Group__1 )
            // InternalExprParser.g:5421:2: rule__BagType__Group__0__Impl rule__BagType__Group__1
            {
            pushFollow(FOLLOW_34);
            rule__BagType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BagType__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagType__Group__0"


    // $ANTLR start "rule__BagType__Group__0__Impl"
    // InternalExprParser.g:5428:1: rule__BagType__Group__0__Impl : ( Bag ) ;
    public final void rule__BagType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5432:1: ( ( Bag ) )
            // InternalExprParser.g:5433:1: ( Bag )
            {
            // InternalExprParser.g:5433:1: ( Bag )
            // InternalExprParser.g:5434:1: Bag
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBagTypeAccess().getBagKeyword_0()); 
            }
            match(input,Bag,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBagTypeAccess().getBagKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagType__Group__0__Impl"


    // $ANTLR start "rule__BagType__Group__1"
    // InternalExprParser.g:5447:1: rule__BagType__Group__1 : rule__BagType__Group__1__Impl rule__BagType__Group__2 ;
    public final void rule__BagType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5451:1: ( rule__BagType__Group__1__Impl rule__BagType__Group__2 )
            // InternalExprParser.g:5452:2: rule__BagType__Group__1__Impl rule__BagType__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__BagType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BagType__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagType__Group__1"


    // $ANTLR start "rule__BagType__Group__1__Impl"
    // InternalExprParser.g:5459:1: rule__BagType__Group__1__Impl : ( Of ) ;
    public final void rule__BagType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5463:1: ( ( Of ) )
            // InternalExprParser.g:5464:1: ( Of )
            {
            // InternalExprParser.g:5464:1: ( Of )
            // InternalExprParser.g:5465:1: Of
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBagTypeAccess().getOfKeyword_1()); 
            }
            match(input,Of,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBagTypeAccess().getOfKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagType__Group__1__Impl"


    // $ANTLR start "rule__BagType__Group__2"
    // InternalExprParser.g:5478:1: rule__BagType__Group__2 : rule__BagType__Group__2__Impl ;
    public final void rule__BagType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5482:1: ( rule__BagType__Group__2__Impl )
            // InternalExprParser.g:5483:2: rule__BagType__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BagType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagType__Group__2"


    // $ANTLR start "rule__BagType__Group__2__Impl"
    // InternalExprParser.g:5489:1: rule__BagType__Group__2__Impl : ( ( rule__BagType__TypeAssignment_2 ) ) ;
    public final void rule__BagType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5493:1: ( ( ( rule__BagType__TypeAssignment_2 ) ) )
            // InternalExprParser.g:5494:1: ( ( rule__BagType__TypeAssignment_2 ) )
            {
            // InternalExprParser.g:5494:1: ( ( rule__BagType__TypeAssignment_2 ) )
            // InternalExprParser.g:5495:1: ( rule__BagType__TypeAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBagTypeAccess().getTypeAssignment_2()); 
            }
            // InternalExprParser.g:5496:1: ( rule__BagType__TypeAssignment_2 )
            // InternalExprParser.g:5496:2: rule__BagType__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__BagType__TypeAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBagTypeAccess().getTypeAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagType__Group__2__Impl"


    // $ANTLR start "rule__MapType__Group__0"
    // InternalExprParser.g:5512:1: rule__MapType__Group__0 : rule__MapType__Group__0__Impl rule__MapType__Group__1 ;
    public final void rule__MapType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5516:1: ( rule__MapType__Group__0__Impl rule__MapType__Group__1 )
            // InternalExprParser.g:5517:2: rule__MapType__Group__0__Impl rule__MapType__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__MapType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MapType__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__0"


    // $ANTLR start "rule__MapType__Group__0__Impl"
    // InternalExprParser.g:5524:1: rule__MapType__Group__0__Impl : ( Map ) ;
    public final void rule__MapType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5528:1: ( ( Map ) )
            // InternalExprParser.g:5529:1: ( Map )
            {
            // InternalExprParser.g:5529:1: ( Map )
            // InternalExprParser.g:5530:1: Map
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMapTypeAccess().getMapKeyword_0()); 
            }
            match(input,Map,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMapTypeAccess().getMapKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__0__Impl"


    // $ANTLR start "rule__MapType__Group__1"
    // InternalExprParser.g:5543:1: rule__MapType__Group__1 : rule__MapType__Group__1__Impl rule__MapType__Group__2 ;
    public final void rule__MapType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5547:1: ( rule__MapType__Group__1__Impl rule__MapType__Group__2 )
            // InternalExprParser.g:5548:2: rule__MapType__Group__1__Impl rule__MapType__Group__2
            {
            pushFollow(FOLLOW_35);
            rule__MapType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MapType__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__1"


    // $ANTLR start "rule__MapType__Group__1__Impl"
    // InternalExprParser.g:5555:1: rule__MapType__Group__1__Impl : ( ( rule__MapType__DomAssignment_1 ) ) ;
    public final void rule__MapType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5559:1: ( ( ( rule__MapType__DomAssignment_1 ) ) )
            // InternalExprParser.g:5560:1: ( ( rule__MapType__DomAssignment_1 ) )
            {
            // InternalExprParser.g:5560:1: ( ( rule__MapType__DomAssignment_1 ) )
            // InternalExprParser.g:5561:1: ( rule__MapType__DomAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMapTypeAccess().getDomAssignment_1()); 
            }
            // InternalExprParser.g:5562:1: ( rule__MapType__DomAssignment_1 )
            // InternalExprParser.g:5562:2: rule__MapType__DomAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__MapType__DomAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMapTypeAccess().getDomAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__1__Impl"


    // $ANTLR start "rule__MapType__Group__2"
    // InternalExprParser.g:5572:1: rule__MapType__Group__2 : rule__MapType__Group__2__Impl rule__MapType__Group__3 ;
    public final void rule__MapType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5576:1: ( rule__MapType__Group__2__Impl rule__MapType__Group__3 )
            // InternalExprParser.g:5577:2: rule__MapType__Group__2__Impl rule__MapType__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__MapType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MapType__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__2"


    // $ANTLR start "rule__MapType__Group__2__Impl"
    // InternalExprParser.g:5584:1: rule__MapType__Group__2__Impl : ( HyphenMinusGreaterThanSign ) ;
    public final void rule__MapType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5588:1: ( ( HyphenMinusGreaterThanSign ) )
            // InternalExprParser.g:5589:1: ( HyphenMinusGreaterThanSign )
            {
            // InternalExprParser.g:5589:1: ( HyphenMinusGreaterThanSign )
            // InternalExprParser.g:5590:1: HyphenMinusGreaterThanSign
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMapTypeAccess().getHyphenMinusGreaterThanSignKeyword_2()); 
            }
            match(input,HyphenMinusGreaterThanSign,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMapTypeAccess().getHyphenMinusGreaterThanSignKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__2__Impl"


    // $ANTLR start "rule__MapType__Group__3"
    // InternalExprParser.g:5603:1: rule__MapType__Group__3 : rule__MapType__Group__3__Impl ;
    public final void rule__MapType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5607:1: ( rule__MapType__Group__3__Impl )
            // InternalExprParser.g:5608:2: rule__MapType__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MapType__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__3"


    // $ANTLR start "rule__MapType__Group__3__Impl"
    // InternalExprParser.g:5614:1: rule__MapType__Group__3__Impl : ( ( rule__MapType__ImgAssignment_3 ) ) ;
    public final void rule__MapType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5618:1: ( ( ( rule__MapType__ImgAssignment_3 ) ) )
            // InternalExprParser.g:5619:1: ( ( rule__MapType__ImgAssignment_3 ) )
            {
            // InternalExprParser.g:5619:1: ( ( rule__MapType__ImgAssignment_3 ) )
            // InternalExprParser.g:5620:1: ( rule__MapType__ImgAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMapTypeAccess().getImgAssignment_3()); 
            }
            // InternalExprParser.g:5621:1: ( rule__MapType__ImgAssignment_3 )
            // InternalExprParser.g:5621:2: rule__MapType__ImgAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__MapType__ImgAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMapTypeAccess().getImgAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__3__Impl"


    // $ANTLR start "rule__OrExpression__Group__0"
    // InternalExprParser.g:5639:1: rule__OrExpression__Group__0 : rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1 ;
    public final void rule__OrExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5643:1: ( rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1 )
            // InternalExprParser.g:5644:2: rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__OrExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OrExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group__0"


    // $ANTLR start "rule__OrExpression__Group__0__Impl"
    // InternalExprParser.g:5651:1: rule__OrExpression__Group__0__Impl : ( ruleAndExpression ) ;
    public final void rule__OrExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5655:1: ( ( ruleAndExpression ) )
            // InternalExprParser.g:5656:1: ( ruleAndExpression )
            {
            // InternalExprParser.g:5656:1: ( ruleAndExpression )
            // InternalExprParser.g:5657:1: ruleAndExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAndExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group__0__Impl"


    // $ANTLR start "rule__OrExpression__Group__1"
    // InternalExprParser.g:5668:1: rule__OrExpression__Group__1 : rule__OrExpression__Group__1__Impl ;
    public final void rule__OrExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5672:1: ( rule__OrExpression__Group__1__Impl )
            // InternalExprParser.g:5673:2: rule__OrExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group__1"


    // $ANTLR start "rule__OrExpression__Group__1__Impl"
    // InternalExprParser.g:5679:1: rule__OrExpression__Group__1__Impl : ( ( rule__OrExpression__Group_1__0 )* ) ;
    public final void rule__OrExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5683:1: ( ( ( rule__OrExpression__Group_1__0 )* ) )
            // InternalExprParser.g:5684:1: ( ( rule__OrExpression__Group_1__0 )* )
            {
            // InternalExprParser.g:5684:1: ( ( rule__OrExpression__Group_1__0 )* )
            // InternalExprParser.g:5685:1: ( rule__OrExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionAccess().getGroup_1()); 
            }
            // InternalExprParser.g:5686:1: ( rule__OrExpression__Group_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=Or && LA30_0<=VerticalLineVerticalLine)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalExprParser.g:5686:2: rule__OrExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_37);
            	    rule__OrExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group__1__Impl"


    // $ANTLR start "rule__OrExpression__Group_1__0"
    // InternalExprParser.g:5700:1: rule__OrExpression__Group_1__0 : rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1 ;
    public final void rule__OrExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5704:1: ( rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1 )
            // InternalExprParser.g:5705:2: rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__OrExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OrExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__0"


    // $ANTLR start "rule__OrExpression__Group_1__0__Impl"
    // InternalExprParser.g:5712:1: rule__OrExpression__Group_1__0__Impl : ( ( rule__OrExpression__Group_1_0__0 ) ) ;
    public final void rule__OrExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5716:1: ( ( ( rule__OrExpression__Group_1_0__0 ) ) )
            // InternalExprParser.g:5717:1: ( ( rule__OrExpression__Group_1_0__0 ) )
            {
            // InternalExprParser.g:5717:1: ( ( rule__OrExpression__Group_1_0__0 ) )
            // InternalExprParser.g:5718:1: ( rule__OrExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionAccess().getGroup_1_0()); 
            }
            // InternalExprParser.g:5719:1: ( rule__OrExpression__Group_1_0__0 )
            // InternalExprParser.g:5719:2: rule__OrExpression__Group_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__OrExpression__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrExpressionAccess().getGroup_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__0__Impl"


    // $ANTLR start "rule__OrExpression__Group_1__1"
    // InternalExprParser.g:5729:1: rule__OrExpression__Group_1__1 : rule__OrExpression__Group_1__1__Impl ;
    public final void rule__OrExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5733:1: ( rule__OrExpression__Group_1__1__Impl )
            // InternalExprParser.g:5734:2: rule__OrExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__1"


    // $ANTLR start "rule__OrExpression__Group_1__1__Impl"
    // InternalExprParser.g:5740:1: rule__OrExpression__Group_1__1__Impl : ( ( rule__OrExpression__RightAssignment_1_1 ) ) ;
    public final void rule__OrExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5744:1: ( ( ( rule__OrExpression__RightAssignment_1_1 ) ) )
            // InternalExprParser.g:5745:1: ( ( rule__OrExpression__RightAssignment_1_1 ) )
            {
            // InternalExprParser.g:5745:1: ( ( rule__OrExpression__RightAssignment_1_1 ) )
            // InternalExprParser.g:5746:1: ( rule__OrExpression__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionAccess().getRightAssignment_1_1()); 
            }
            // InternalExprParser.g:5747:1: ( rule__OrExpression__RightAssignment_1_1 )
            // InternalExprParser.g:5747:2: rule__OrExpression__RightAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__OrExpression__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrExpressionAccess().getRightAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__1__Impl"


    // $ANTLR start "rule__OrExpression__Group_1_0__0"
    // InternalExprParser.g:5761:1: rule__OrExpression__Group_1_0__0 : rule__OrExpression__Group_1_0__0__Impl ;
    public final void rule__OrExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5765:1: ( rule__OrExpression__Group_1_0__0__Impl )
            // InternalExprParser.g:5766:2: rule__OrExpression__Group_1_0__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrExpression__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1_0__0"


    // $ANTLR start "rule__OrExpression__Group_1_0__0__Impl"
    // InternalExprParser.g:5772:1: rule__OrExpression__Group_1_0__0__Impl : ( ( rule__OrExpression__Group_1_0_0__0 ) ) ;
    public final void rule__OrExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5776:1: ( ( ( rule__OrExpression__Group_1_0_0__0 ) ) )
            // InternalExprParser.g:5777:1: ( ( rule__OrExpression__Group_1_0_0__0 ) )
            {
            // InternalExprParser.g:5777:1: ( ( rule__OrExpression__Group_1_0_0__0 ) )
            // InternalExprParser.g:5778:1: ( rule__OrExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalExprParser.g:5779:1: ( rule__OrExpression__Group_1_0_0__0 )
            // InternalExprParser.g:5779:2: rule__OrExpression__Group_1_0_0__0
            {
            pushFollow(FOLLOW_2);
            rule__OrExpression__Group_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrExpressionAccess().getGroup_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1_0__0__Impl"


    // $ANTLR start "rule__OrExpression__Group_1_0_0__0"
    // InternalExprParser.g:5791:1: rule__OrExpression__Group_1_0_0__0 : rule__OrExpression__Group_1_0_0__0__Impl rule__OrExpression__Group_1_0_0__1 ;
    public final void rule__OrExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5795:1: ( rule__OrExpression__Group_1_0_0__0__Impl rule__OrExpression__Group_1_0_0__1 )
            // InternalExprParser.g:5796:2: rule__OrExpression__Group_1_0_0__0__Impl rule__OrExpression__Group_1_0_0__1
            {
            pushFollow(FOLLOW_36);
            rule__OrExpression__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OrExpression__Group_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1_0_0__0"


    // $ANTLR start "rule__OrExpression__Group_1_0_0__0__Impl"
    // InternalExprParser.g:5803:1: rule__OrExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__OrExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5807:1: ( ( () ) )
            // InternalExprParser.g:5808:1: ( () )
            {
            // InternalExprParser.g:5808:1: ( () )
            // InternalExprParser.g:5809:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionAccess().getBinaryOperationLeftAction_1_0_0_0()); 
            }
            // InternalExprParser.g:5810:1: ()
            // InternalExprParser.g:5812:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrExpressionAccess().getBinaryOperationLeftAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__OrExpression__Group_1_0_0__1"
    // InternalExprParser.g:5822:1: rule__OrExpression__Group_1_0_0__1 : rule__OrExpression__Group_1_0_0__1__Impl ;
    public final void rule__OrExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5826:1: ( rule__OrExpression__Group_1_0_0__1__Impl )
            // InternalExprParser.g:5827:2: rule__OrExpression__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrExpression__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1_0_0__1"


    // $ANTLR start "rule__OrExpression__Group_1_0_0__1__Impl"
    // InternalExprParser.g:5833:1: rule__OrExpression__Group_1_0_0__1__Impl : ( ( rule__OrExpression__OperatorAssignment_1_0_0_1 ) ) ;
    public final void rule__OrExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5837:1: ( ( ( rule__OrExpression__OperatorAssignment_1_0_0_1 ) ) )
            // InternalExprParser.g:5838:1: ( ( rule__OrExpression__OperatorAssignment_1_0_0_1 ) )
            {
            // InternalExprParser.g:5838:1: ( ( rule__OrExpression__OperatorAssignment_1_0_0_1 ) )
            // InternalExprParser.g:5839:1: ( rule__OrExpression__OperatorAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionAccess().getOperatorAssignment_1_0_0_1()); 
            }
            // InternalExprParser.g:5840:1: ( rule__OrExpression__OperatorAssignment_1_0_0_1 )
            // InternalExprParser.g:5840:2: rule__OrExpression__OperatorAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_2);
            rule__OrExpression__OperatorAssignment_1_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrExpressionAccess().getOperatorAssignment_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__AndExpression__Group__0"
    // InternalExprParser.g:5854:1: rule__AndExpression__Group__0 : rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1 ;
    public final void rule__AndExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5858:1: ( rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1 )
            // InternalExprParser.g:5859:2: rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1
            {
            pushFollow(FOLLOW_38);
            rule__AndExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AndExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__0"


    // $ANTLR start "rule__AndExpression__Group__0__Impl"
    // InternalExprParser.g:5866:1: rule__AndExpression__Group__0__Impl : ( ruleEqualityExpression ) ;
    public final void rule__AndExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5870:1: ( ( ruleEqualityExpression ) )
            // InternalExprParser.g:5871:1: ( ruleEqualityExpression )
            {
            // InternalExprParser.g:5871:1: ( ruleEqualityExpression )
            // InternalExprParser.g:5872:1: ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionAccess().getEqualityExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndExpressionAccess().getEqualityExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__0__Impl"


    // $ANTLR start "rule__AndExpression__Group__1"
    // InternalExprParser.g:5883:1: rule__AndExpression__Group__1 : rule__AndExpression__Group__1__Impl ;
    public final void rule__AndExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5887:1: ( rule__AndExpression__Group__1__Impl )
            // InternalExprParser.g:5888:2: rule__AndExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AndExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__1"


    // $ANTLR start "rule__AndExpression__Group__1__Impl"
    // InternalExprParser.g:5894:1: rule__AndExpression__Group__1__Impl : ( ( rule__AndExpression__Group_1__0 )* ) ;
    public final void rule__AndExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5898:1: ( ( ( rule__AndExpression__Group_1__0 )* ) )
            // InternalExprParser.g:5899:1: ( ( rule__AndExpression__Group_1__0 )* )
            {
            // InternalExprParser.g:5899:1: ( ( rule__AndExpression__Group_1__0 )* )
            // InternalExprParser.g:5900:1: ( rule__AndExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionAccess().getGroup_1()); 
            }
            // InternalExprParser.g:5901:1: ( rule__AndExpression__Group_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==And||LA31_0==AmpersandAmpersand) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalExprParser.g:5901:2: rule__AndExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_39);
            	    rule__AndExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__1__Impl"


    // $ANTLR start "rule__AndExpression__Group_1__0"
    // InternalExprParser.g:5915:1: rule__AndExpression__Group_1__0 : rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1 ;
    public final void rule__AndExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5919:1: ( rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1 )
            // InternalExprParser.g:5920:2: rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__AndExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AndExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__0"


    // $ANTLR start "rule__AndExpression__Group_1__0__Impl"
    // InternalExprParser.g:5927:1: rule__AndExpression__Group_1__0__Impl : ( ( rule__AndExpression__Group_1_0__0 ) ) ;
    public final void rule__AndExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5931:1: ( ( ( rule__AndExpression__Group_1_0__0 ) ) )
            // InternalExprParser.g:5932:1: ( ( rule__AndExpression__Group_1_0__0 ) )
            {
            // InternalExprParser.g:5932:1: ( ( rule__AndExpression__Group_1_0__0 ) )
            // InternalExprParser.g:5933:1: ( rule__AndExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionAccess().getGroup_1_0()); 
            }
            // InternalExprParser.g:5934:1: ( rule__AndExpression__Group_1_0__0 )
            // InternalExprParser.g:5934:2: rule__AndExpression__Group_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__AndExpression__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndExpressionAccess().getGroup_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__0__Impl"


    // $ANTLR start "rule__AndExpression__Group_1__1"
    // InternalExprParser.g:5944:1: rule__AndExpression__Group_1__1 : rule__AndExpression__Group_1__1__Impl ;
    public final void rule__AndExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5948:1: ( rule__AndExpression__Group_1__1__Impl )
            // InternalExprParser.g:5949:2: rule__AndExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AndExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__1"


    // $ANTLR start "rule__AndExpression__Group_1__1__Impl"
    // InternalExprParser.g:5955:1: rule__AndExpression__Group_1__1__Impl : ( ( rule__AndExpression__RightAssignment_1_1 ) ) ;
    public final void rule__AndExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5959:1: ( ( ( rule__AndExpression__RightAssignment_1_1 ) ) )
            // InternalExprParser.g:5960:1: ( ( rule__AndExpression__RightAssignment_1_1 ) )
            {
            // InternalExprParser.g:5960:1: ( ( rule__AndExpression__RightAssignment_1_1 ) )
            // InternalExprParser.g:5961:1: ( rule__AndExpression__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionAccess().getRightAssignment_1_1()); 
            }
            // InternalExprParser.g:5962:1: ( rule__AndExpression__RightAssignment_1_1 )
            // InternalExprParser.g:5962:2: rule__AndExpression__RightAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__AndExpression__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndExpressionAccess().getRightAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__1__Impl"


    // $ANTLR start "rule__AndExpression__Group_1_0__0"
    // InternalExprParser.g:5976:1: rule__AndExpression__Group_1_0__0 : rule__AndExpression__Group_1_0__0__Impl ;
    public final void rule__AndExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5980:1: ( rule__AndExpression__Group_1_0__0__Impl )
            // InternalExprParser.g:5981:2: rule__AndExpression__Group_1_0__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AndExpression__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1_0__0"


    // $ANTLR start "rule__AndExpression__Group_1_0__0__Impl"
    // InternalExprParser.g:5987:1: rule__AndExpression__Group_1_0__0__Impl : ( ( rule__AndExpression__Group_1_0_0__0 ) ) ;
    public final void rule__AndExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5991:1: ( ( ( rule__AndExpression__Group_1_0_0__0 ) ) )
            // InternalExprParser.g:5992:1: ( ( rule__AndExpression__Group_1_0_0__0 ) )
            {
            // InternalExprParser.g:5992:1: ( ( rule__AndExpression__Group_1_0_0__0 ) )
            // InternalExprParser.g:5993:1: ( rule__AndExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalExprParser.g:5994:1: ( rule__AndExpression__Group_1_0_0__0 )
            // InternalExprParser.g:5994:2: rule__AndExpression__Group_1_0_0__0
            {
            pushFollow(FOLLOW_2);
            rule__AndExpression__Group_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndExpressionAccess().getGroup_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1_0__0__Impl"


    // $ANTLR start "rule__AndExpression__Group_1_0_0__0"
    // InternalExprParser.g:6006:1: rule__AndExpression__Group_1_0_0__0 : rule__AndExpression__Group_1_0_0__0__Impl rule__AndExpression__Group_1_0_0__1 ;
    public final void rule__AndExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6010:1: ( rule__AndExpression__Group_1_0_0__0__Impl rule__AndExpression__Group_1_0_0__1 )
            // InternalExprParser.g:6011:2: rule__AndExpression__Group_1_0_0__0__Impl rule__AndExpression__Group_1_0_0__1
            {
            pushFollow(FOLLOW_38);
            rule__AndExpression__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AndExpression__Group_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1_0_0__0"


    // $ANTLR start "rule__AndExpression__Group_1_0_0__0__Impl"
    // InternalExprParser.g:6018:1: rule__AndExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__AndExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6022:1: ( ( () ) )
            // InternalExprParser.g:6023:1: ( () )
            {
            // InternalExprParser.g:6023:1: ( () )
            // InternalExprParser.g:6024:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionAccess().getBinaryOperationLeftAction_1_0_0_0()); 
            }
            // InternalExprParser.g:6025:1: ()
            // InternalExprParser.g:6027:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndExpressionAccess().getBinaryOperationLeftAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__AndExpression__Group_1_0_0__1"
    // InternalExprParser.g:6037:1: rule__AndExpression__Group_1_0_0__1 : rule__AndExpression__Group_1_0_0__1__Impl ;
    public final void rule__AndExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6041:1: ( rule__AndExpression__Group_1_0_0__1__Impl )
            // InternalExprParser.g:6042:2: rule__AndExpression__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AndExpression__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1_0_0__1"


    // $ANTLR start "rule__AndExpression__Group_1_0_0__1__Impl"
    // InternalExprParser.g:6048:1: rule__AndExpression__Group_1_0_0__1__Impl : ( ( rule__AndExpression__OperatorAssignment_1_0_0_1 ) ) ;
    public final void rule__AndExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6052:1: ( ( ( rule__AndExpression__OperatorAssignment_1_0_0_1 ) ) )
            // InternalExprParser.g:6053:1: ( ( rule__AndExpression__OperatorAssignment_1_0_0_1 ) )
            {
            // InternalExprParser.g:6053:1: ( ( rule__AndExpression__OperatorAssignment_1_0_0_1 ) )
            // InternalExprParser.g:6054:1: ( rule__AndExpression__OperatorAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionAccess().getOperatorAssignment_1_0_0_1()); 
            }
            // InternalExprParser.g:6055:1: ( rule__AndExpression__OperatorAssignment_1_0_0_1 )
            // InternalExprParser.g:6055:2: rule__AndExpression__OperatorAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_2);
            rule__AndExpression__OperatorAssignment_1_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndExpressionAccess().getOperatorAssignment_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__EqualityExpression__Group__0"
    // InternalExprParser.g:6069:1: rule__EqualityExpression__Group__0 : rule__EqualityExpression__Group__0__Impl rule__EqualityExpression__Group__1 ;
    public final void rule__EqualityExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6073:1: ( rule__EqualityExpression__Group__0__Impl rule__EqualityExpression__Group__1 )
            // InternalExprParser.g:6074:2: rule__EqualityExpression__Group__0__Impl rule__EqualityExpression__Group__1
            {
            pushFollow(FOLLOW_40);
            rule__EqualityExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EqualityExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__Group__0"


    // $ANTLR start "rule__EqualityExpression__Group__0__Impl"
    // InternalExprParser.g:6081:1: rule__EqualityExpression__Group__0__Impl : ( ruleRelationalExpression ) ;
    public final void rule__EqualityExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6085:1: ( ( ruleRelationalExpression ) )
            // InternalExprParser.g:6086:1: ( ruleRelationalExpression )
            {
            // InternalExprParser.g:6086:1: ( ruleRelationalExpression )
            // InternalExprParser.g:6087:1: ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__Group__0__Impl"


    // $ANTLR start "rule__EqualityExpression__Group__1"
    // InternalExprParser.g:6098:1: rule__EqualityExpression__Group__1 : rule__EqualityExpression__Group__1__Impl ;
    public final void rule__EqualityExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6102:1: ( rule__EqualityExpression__Group__1__Impl )
            // InternalExprParser.g:6103:2: rule__EqualityExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EqualityExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__Group__1"


    // $ANTLR start "rule__EqualityExpression__Group__1__Impl"
    // InternalExprParser.g:6109:1: rule__EqualityExpression__Group__1__Impl : ( ( rule__EqualityExpression__Group_1__0 )* ) ;
    public final void rule__EqualityExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6113:1: ( ( ( rule__EqualityExpression__Group_1__0 )* ) )
            // InternalExprParser.g:6114:1: ( ( rule__EqualityExpression__Group_1__0 )* )
            {
            // InternalExprParser.g:6114:1: ( ( rule__EqualityExpression__Group_1__0 )* )
            // InternalExprParser.g:6115:1: ( rule__EqualityExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpressionAccess().getGroup_1()); 
            }
            // InternalExprParser.g:6116:1: ( rule__EqualityExpression__Group_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==ExclamationMarkEqualsSign||LA32_0==EqualsSignEqualsSign) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalExprParser.g:6116:2: rule__EqualityExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_41);
            	    rule__EqualityExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__Group__1__Impl"


    // $ANTLR start "rule__EqualityExpression__Group_1__0"
    // InternalExprParser.g:6130:1: rule__EqualityExpression__Group_1__0 : rule__EqualityExpression__Group_1__0__Impl rule__EqualityExpression__Group_1__1 ;
    public final void rule__EqualityExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6134:1: ( rule__EqualityExpression__Group_1__0__Impl rule__EqualityExpression__Group_1__1 )
            // InternalExprParser.g:6135:2: rule__EqualityExpression__Group_1__0__Impl rule__EqualityExpression__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__EqualityExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EqualityExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__Group_1__0"


    // $ANTLR start "rule__EqualityExpression__Group_1__0__Impl"
    // InternalExprParser.g:6142:1: rule__EqualityExpression__Group_1__0__Impl : ( ( rule__EqualityExpression__Group_1_0__0 ) ) ;
    public final void rule__EqualityExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6146:1: ( ( ( rule__EqualityExpression__Group_1_0__0 ) ) )
            // InternalExprParser.g:6147:1: ( ( rule__EqualityExpression__Group_1_0__0 ) )
            {
            // InternalExprParser.g:6147:1: ( ( rule__EqualityExpression__Group_1_0__0 ) )
            // InternalExprParser.g:6148:1: ( rule__EqualityExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpressionAccess().getGroup_1_0()); 
            }
            // InternalExprParser.g:6149:1: ( rule__EqualityExpression__Group_1_0__0 )
            // InternalExprParser.g:6149:2: rule__EqualityExpression__Group_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__EqualityExpression__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExpressionAccess().getGroup_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__Group_1__0__Impl"


    // $ANTLR start "rule__EqualityExpression__Group_1__1"
    // InternalExprParser.g:6159:1: rule__EqualityExpression__Group_1__1 : rule__EqualityExpression__Group_1__1__Impl ;
    public final void rule__EqualityExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6163:1: ( rule__EqualityExpression__Group_1__1__Impl )
            // InternalExprParser.g:6164:2: rule__EqualityExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EqualityExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__Group_1__1"


    // $ANTLR start "rule__EqualityExpression__Group_1__1__Impl"
    // InternalExprParser.g:6170:1: rule__EqualityExpression__Group_1__1__Impl : ( ( rule__EqualityExpression__RightAssignment_1_1 ) ) ;
    public final void rule__EqualityExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6174:1: ( ( ( rule__EqualityExpression__RightAssignment_1_1 ) ) )
            // InternalExprParser.g:6175:1: ( ( rule__EqualityExpression__RightAssignment_1_1 ) )
            {
            // InternalExprParser.g:6175:1: ( ( rule__EqualityExpression__RightAssignment_1_1 ) )
            // InternalExprParser.g:6176:1: ( rule__EqualityExpression__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpressionAccess().getRightAssignment_1_1()); 
            }
            // InternalExprParser.g:6177:1: ( rule__EqualityExpression__RightAssignment_1_1 )
            // InternalExprParser.g:6177:2: rule__EqualityExpression__RightAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__EqualityExpression__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExpressionAccess().getRightAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__Group_1__1__Impl"


    // $ANTLR start "rule__EqualityExpression__Group_1_0__0"
    // InternalExprParser.g:6191:1: rule__EqualityExpression__Group_1_0__0 : rule__EqualityExpression__Group_1_0__0__Impl ;
    public final void rule__EqualityExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6195:1: ( rule__EqualityExpression__Group_1_0__0__Impl )
            // InternalExprParser.g:6196:2: rule__EqualityExpression__Group_1_0__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EqualityExpression__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__Group_1_0__0"


    // $ANTLR start "rule__EqualityExpression__Group_1_0__0__Impl"
    // InternalExprParser.g:6202:1: rule__EqualityExpression__Group_1_0__0__Impl : ( ( rule__EqualityExpression__Group_1_0_0__0 ) ) ;
    public final void rule__EqualityExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6206:1: ( ( ( rule__EqualityExpression__Group_1_0_0__0 ) ) )
            // InternalExprParser.g:6207:1: ( ( rule__EqualityExpression__Group_1_0_0__0 ) )
            {
            // InternalExprParser.g:6207:1: ( ( rule__EqualityExpression__Group_1_0_0__0 ) )
            // InternalExprParser.g:6208:1: ( rule__EqualityExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalExprParser.g:6209:1: ( rule__EqualityExpression__Group_1_0_0__0 )
            // InternalExprParser.g:6209:2: rule__EqualityExpression__Group_1_0_0__0
            {
            pushFollow(FOLLOW_2);
            rule__EqualityExpression__Group_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExpressionAccess().getGroup_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__Group_1_0__0__Impl"


    // $ANTLR start "rule__EqualityExpression__Group_1_0_0__0"
    // InternalExprParser.g:6221:1: rule__EqualityExpression__Group_1_0_0__0 : rule__EqualityExpression__Group_1_0_0__0__Impl rule__EqualityExpression__Group_1_0_0__1 ;
    public final void rule__EqualityExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6225:1: ( rule__EqualityExpression__Group_1_0_0__0__Impl rule__EqualityExpression__Group_1_0_0__1 )
            // InternalExprParser.g:6226:2: rule__EqualityExpression__Group_1_0_0__0__Impl rule__EqualityExpression__Group_1_0_0__1
            {
            pushFollow(FOLLOW_40);
            rule__EqualityExpression__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EqualityExpression__Group_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__Group_1_0_0__0"


    // $ANTLR start "rule__EqualityExpression__Group_1_0_0__0__Impl"
    // InternalExprParser.g:6233:1: rule__EqualityExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__EqualityExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6237:1: ( ( () ) )
            // InternalExprParser.g:6238:1: ( () )
            {
            // InternalExprParser.g:6238:1: ( () )
            // InternalExprParser.g:6239:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpressionAccess().getBinaryOperationLeftAction_1_0_0_0()); 
            }
            // InternalExprParser.g:6240:1: ()
            // InternalExprParser.g:6242:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExpressionAccess().getBinaryOperationLeftAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__EqualityExpression__Group_1_0_0__1"
    // InternalExprParser.g:6252:1: rule__EqualityExpression__Group_1_0_0__1 : rule__EqualityExpression__Group_1_0_0__1__Impl ;
    public final void rule__EqualityExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6256:1: ( rule__EqualityExpression__Group_1_0_0__1__Impl )
            // InternalExprParser.g:6257:2: rule__EqualityExpression__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EqualityExpression__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__Group_1_0_0__1"


    // $ANTLR start "rule__EqualityExpression__Group_1_0_0__1__Impl"
    // InternalExprParser.g:6263:1: rule__EqualityExpression__Group_1_0_0__1__Impl : ( ( rule__EqualityExpression__OperatorAssignment_1_0_0_1 ) ) ;
    public final void rule__EqualityExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6267:1: ( ( ( rule__EqualityExpression__OperatorAssignment_1_0_0_1 ) ) )
            // InternalExprParser.g:6268:1: ( ( rule__EqualityExpression__OperatorAssignment_1_0_0_1 ) )
            {
            // InternalExprParser.g:6268:1: ( ( rule__EqualityExpression__OperatorAssignment_1_0_0_1 ) )
            // InternalExprParser.g:6269:1: ( rule__EqualityExpression__OperatorAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpressionAccess().getOperatorAssignment_1_0_0_1()); 
            }
            // InternalExprParser.g:6270:1: ( rule__EqualityExpression__OperatorAssignment_1_0_0_1 )
            // InternalExprParser.g:6270:2: rule__EqualityExpression__OperatorAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_2);
            rule__EqualityExpression__OperatorAssignment_1_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExpressionAccess().getOperatorAssignment_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__RelationalExpression__Group__0"
    // InternalExprParser.g:6284:1: rule__RelationalExpression__Group__0 : rule__RelationalExpression__Group__0__Impl rule__RelationalExpression__Group__1 ;
    public final void rule__RelationalExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6288:1: ( rule__RelationalExpression__Group__0__Impl rule__RelationalExpression__Group__1 )
            // InternalExprParser.g:6289:2: rule__RelationalExpression__Group__0__Impl rule__RelationalExpression__Group__1
            {
            pushFollow(FOLLOW_42);
            rule__RelationalExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RelationalExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group__0"


    // $ANTLR start "rule__RelationalExpression__Group__0__Impl"
    // InternalExprParser.g:6296:1: rule__RelationalExpression__Group__0__Impl : ( ruleAdditiveExpression ) ;
    public final void rule__RelationalExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6300:1: ( ( ruleAdditiveExpression ) )
            // InternalExprParser.g:6301:1: ( ruleAdditiveExpression )
            {
            // InternalExprParser.g:6301:1: ( ruleAdditiveExpression )
            // InternalExprParser.g:6302:1: ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group__0__Impl"


    // $ANTLR start "rule__RelationalExpression__Group__1"
    // InternalExprParser.g:6313:1: rule__RelationalExpression__Group__1 : rule__RelationalExpression__Group__1__Impl ;
    public final void rule__RelationalExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6317:1: ( rule__RelationalExpression__Group__1__Impl )
            // InternalExprParser.g:6318:2: rule__RelationalExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RelationalExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group__1"


    // $ANTLR start "rule__RelationalExpression__Group__1__Impl"
    // InternalExprParser.g:6324:1: rule__RelationalExpression__Group__1__Impl : ( ( rule__RelationalExpression__Group_1__0 )* ) ;
    public final void rule__RelationalExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6328:1: ( ( ( rule__RelationalExpression__Group_1__0 )* ) )
            // InternalExprParser.g:6329:1: ( ( rule__RelationalExpression__Group_1__0 )* )
            {
            // InternalExprParser.g:6329:1: ( ( rule__RelationalExpression__Group_1__0 )* )
            // InternalExprParser.g:6330:1: ( rule__RelationalExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRelationalExpressionAccess().getGroup_1()); 
            }
            // InternalExprParser.g:6331:1: ( rule__RelationalExpression__Group_1__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==LessThanSignEqualsSign||(LA33_0>=GreaterThanSignLessThanSign && LA33_0<=GreaterThanSignEqualsSign)||LA33_0==LessThanSign||LA33_0==GreaterThanSign) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalExprParser.g:6331:2: rule__RelationalExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_43);
            	    rule__RelationalExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRelationalExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group__1__Impl"


    // $ANTLR start "rule__RelationalExpression__Group_1__0"
    // InternalExprParser.g:6345:1: rule__RelationalExpression__Group_1__0 : rule__RelationalExpression__Group_1__0__Impl rule__RelationalExpression__Group_1__1 ;
    public final void rule__RelationalExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6349:1: ( rule__RelationalExpression__Group_1__0__Impl rule__RelationalExpression__Group_1__1 )
            // InternalExprParser.g:6350:2: rule__RelationalExpression__Group_1__0__Impl rule__RelationalExpression__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__RelationalExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RelationalExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group_1__0"


    // $ANTLR start "rule__RelationalExpression__Group_1__0__Impl"
    // InternalExprParser.g:6357:1: rule__RelationalExpression__Group_1__0__Impl : ( ( rule__RelationalExpression__Group_1_0__0 ) ) ;
    public final void rule__RelationalExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6361:1: ( ( ( rule__RelationalExpression__Group_1_0__0 ) ) )
            // InternalExprParser.g:6362:1: ( ( rule__RelationalExpression__Group_1_0__0 ) )
            {
            // InternalExprParser.g:6362:1: ( ( rule__RelationalExpression__Group_1_0__0 ) )
            // InternalExprParser.g:6363:1: ( rule__RelationalExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRelationalExpressionAccess().getGroup_1_0()); 
            }
            // InternalExprParser.g:6364:1: ( rule__RelationalExpression__Group_1_0__0 )
            // InternalExprParser.g:6364:2: rule__RelationalExpression__Group_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__RelationalExpression__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRelationalExpressionAccess().getGroup_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group_1__0__Impl"


    // $ANTLR start "rule__RelationalExpression__Group_1__1"
    // InternalExprParser.g:6374:1: rule__RelationalExpression__Group_1__1 : rule__RelationalExpression__Group_1__1__Impl ;
    public final void rule__RelationalExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6378:1: ( rule__RelationalExpression__Group_1__1__Impl )
            // InternalExprParser.g:6379:2: rule__RelationalExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RelationalExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group_1__1"


    // $ANTLR start "rule__RelationalExpression__Group_1__1__Impl"
    // InternalExprParser.g:6385:1: rule__RelationalExpression__Group_1__1__Impl : ( ( rule__RelationalExpression__RightAssignment_1_1 ) ) ;
    public final void rule__RelationalExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6389:1: ( ( ( rule__RelationalExpression__RightAssignment_1_1 ) ) )
            // InternalExprParser.g:6390:1: ( ( rule__RelationalExpression__RightAssignment_1_1 ) )
            {
            // InternalExprParser.g:6390:1: ( ( rule__RelationalExpression__RightAssignment_1_1 ) )
            // InternalExprParser.g:6391:1: ( rule__RelationalExpression__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRelationalExpressionAccess().getRightAssignment_1_1()); 
            }
            // InternalExprParser.g:6392:1: ( rule__RelationalExpression__RightAssignment_1_1 )
            // InternalExprParser.g:6392:2: rule__RelationalExpression__RightAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__RelationalExpression__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRelationalExpressionAccess().getRightAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group_1__1__Impl"


    // $ANTLR start "rule__RelationalExpression__Group_1_0__0"
    // InternalExprParser.g:6406:1: rule__RelationalExpression__Group_1_0__0 : rule__RelationalExpression__Group_1_0__0__Impl ;
    public final void rule__RelationalExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6410:1: ( rule__RelationalExpression__Group_1_0__0__Impl )
            // InternalExprParser.g:6411:2: rule__RelationalExpression__Group_1_0__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RelationalExpression__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group_1_0__0"


    // $ANTLR start "rule__RelationalExpression__Group_1_0__0__Impl"
    // InternalExprParser.g:6417:1: rule__RelationalExpression__Group_1_0__0__Impl : ( ( rule__RelationalExpression__Group_1_0_0__0 ) ) ;
    public final void rule__RelationalExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6421:1: ( ( ( rule__RelationalExpression__Group_1_0_0__0 ) ) )
            // InternalExprParser.g:6422:1: ( ( rule__RelationalExpression__Group_1_0_0__0 ) )
            {
            // InternalExprParser.g:6422:1: ( ( rule__RelationalExpression__Group_1_0_0__0 ) )
            // InternalExprParser.g:6423:1: ( rule__RelationalExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRelationalExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalExprParser.g:6424:1: ( rule__RelationalExpression__Group_1_0_0__0 )
            // InternalExprParser.g:6424:2: rule__RelationalExpression__Group_1_0_0__0
            {
            pushFollow(FOLLOW_2);
            rule__RelationalExpression__Group_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRelationalExpressionAccess().getGroup_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group_1_0__0__Impl"


    // $ANTLR start "rule__RelationalExpression__Group_1_0_0__0"
    // InternalExprParser.g:6436:1: rule__RelationalExpression__Group_1_0_0__0 : rule__RelationalExpression__Group_1_0_0__0__Impl rule__RelationalExpression__Group_1_0_0__1 ;
    public final void rule__RelationalExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6440:1: ( rule__RelationalExpression__Group_1_0_0__0__Impl rule__RelationalExpression__Group_1_0_0__1 )
            // InternalExprParser.g:6441:2: rule__RelationalExpression__Group_1_0_0__0__Impl rule__RelationalExpression__Group_1_0_0__1
            {
            pushFollow(FOLLOW_42);
            rule__RelationalExpression__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RelationalExpression__Group_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group_1_0_0__0"


    // $ANTLR start "rule__RelationalExpression__Group_1_0_0__0__Impl"
    // InternalExprParser.g:6448:1: rule__RelationalExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__RelationalExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6452:1: ( ( () ) )
            // InternalExprParser.g:6453:1: ( () )
            {
            // InternalExprParser.g:6453:1: ( () )
            // InternalExprParser.g:6454:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRelationalExpressionAccess().getBinaryOperationLeftAction_1_0_0_0()); 
            }
            // InternalExprParser.g:6455:1: ()
            // InternalExprParser.g:6457:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRelationalExpressionAccess().getBinaryOperationLeftAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__RelationalExpression__Group_1_0_0__1"
    // InternalExprParser.g:6467:1: rule__RelationalExpression__Group_1_0_0__1 : rule__RelationalExpression__Group_1_0_0__1__Impl ;
    public final void rule__RelationalExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6471:1: ( rule__RelationalExpression__Group_1_0_0__1__Impl )
            // InternalExprParser.g:6472:2: rule__RelationalExpression__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RelationalExpression__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group_1_0_0__1"


    // $ANTLR start "rule__RelationalExpression__Group_1_0_0__1__Impl"
    // InternalExprParser.g:6478:1: rule__RelationalExpression__Group_1_0_0__1__Impl : ( ( rule__RelationalExpression__OperatorAssignment_1_0_0_1 ) ) ;
    public final void rule__RelationalExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6482:1: ( ( ( rule__RelationalExpression__OperatorAssignment_1_0_0_1 ) ) )
            // InternalExprParser.g:6483:1: ( ( rule__RelationalExpression__OperatorAssignment_1_0_0_1 ) )
            {
            // InternalExprParser.g:6483:1: ( ( rule__RelationalExpression__OperatorAssignment_1_0_0_1 ) )
            // InternalExprParser.g:6484:1: ( rule__RelationalExpression__OperatorAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRelationalExpressionAccess().getOperatorAssignment_1_0_0_1()); 
            }
            // InternalExprParser.g:6485:1: ( rule__RelationalExpression__OperatorAssignment_1_0_0_1 )
            // InternalExprParser.g:6485:2: rule__RelationalExpression__OperatorAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_2);
            rule__RelationalExpression__OperatorAssignment_1_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRelationalExpressionAccess().getOperatorAssignment_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__AdditiveExpression__Group__0"
    // InternalExprParser.g:6499:1: rule__AdditiveExpression__Group__0 : rule__AdditiveExpression__Group__0__Impl rule__AdditiveExpression__Group__1 ;
    public final void rule__AdditiveExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6503:1: ( rule__AdditiveExpression__Group__0__Impl rule__AdditiveExpression__Group__1 )
            // InternalExprParser.g:6504:2: rule__AdditiveExpression__Group__0__Impl rule__AdditiveExpression__Group__1
            {
            pushFollow(FOLLOW_44);
            rule__AdditiveExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AdditiveExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group__0"


    // $ANTLR start "rule__AdditiveExpression__Group__0__Impl"
    // InternalExprParser.g:6511:1: rule__AdditiveExpression__Group__0__Impl : ( ruleMultiplicativeExpression ) ;
    public final void rule__AdditiveExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6515:1: ( ( ruleMultiplicativeExpression ) )
            // InternalExprParser.g:6516:1: ( ruleMultiplicativeExpression )
            {
            // InternalExprParser.g:6516:1: ( ruleMultiplicativeExpression )
            // InternalExprParser.g:6517:1: ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group__0__Impl"


    // $ANTLR start "rule__AdditiveExpression__Group__1"
    // InternalExprParser.g:6528:1: rule__AdditiveExpression__Group__1 : rule__AdditiveExpression__Group__1__Impl ;
    public final void rule__AdditiveExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6532:1: ( rule__AdditiveExpression__Group__1__Impl )
            // InternalExprParser.g:6533:2: rule__AdditiveExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AdditiveExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group__1"


    // $ANTLR start "rule__AdditiveExpression__Group__1__Impl"
    // InternalExprParser.g:6539:1: rule__AdditiveExpression__Group__1__Impl : ( ( rule__AdditiveExpression__Group_1__0 )* ) ;
    public final void rule__AdditiveExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6543:1: ( ( ( rule__AdditiveExpression__Group_1__0 )* ) )
            // InternalExprParser.g:6544:1: ( ( rule__AdditiveExpression__Group_1__0 )* )
            {
            // InternalExprParser.g:6544:1: ( ( rule__AdditiveExpression__Group_1__0 )* )
            // InternalExprParser.g:6545:1: ( rule__AdditiveExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExpressionAccess().getGroup_1()); 
            }
            // InternalExprParser.g:6546:1: ( rule__AdditiveExpression__Group_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==PlusSign||LA34_0==HyphenMinus) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalExprParser.g:6546:2: rule__AdditiveExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_45);
            	    rule__AdditiveExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group__1__Impl"


    // $ANTLR start "rule__AdditiveExpression__Group_1__0"
    // InternalExprParser.g:6560:1: rule__AdditiveExpression__Group_1__0 : rule__AdditiveExpression__Group_1__0__Impl rule__AdditiveExpression__Group_1__1 ;
    public final void rule__AdditiveExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6564:1: ( rule__AdditiveExpression__Group_1__0__Impl rule__AdditiveExpression__Group_1__1 )
            // InternalExprParser.g:6565:2: rule__AdditiveExpression__Group_1__0__Impl rule__AdditiveExpression__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__AdditiveExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AdditiveExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group_1__0"


    // $ANTLR start "rule__AdditiveExpression__Group_1__0__Impl"
    // InternalExprParser.g:6572:1: rule__AdditiveExpression__Group_1__0__Impl : ( ( rule__AdditiveExpression__Group_1_0__0 ) ) ;
    public final void rule__AdditiveExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6576:1: ( ( ( rule__AdditiveExpression__Group_1_0__0 ) ) )
            // InternalExprParser.g:6577:1: ( ( rule__AdditiveExpression__Group_1_0__0 ) )
            {
            // InternalExprParser.g:6577:1: ( ( rule__AdditiveExpression__Group_1_0__0 ) )
            // InternalExprParser.g:6578:1: ( rule__AdditiveExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExpressionAccess().getGroup_1_0()); 
            }
            // InternalExprParser.g:6579:1: ( rule__AdditiveExpression__Group_1_0__0 )
            // InternalExprParser.g:6579:2: rule__AdditiveExpression__Group_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__AdditiveExpression__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExpressionAccess().getGroup_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group_1__0__Impl"


    // $ANTLR start "rule__AdditiveExpression__Group_1__1"
    // InternalExprParser.g:6589:1: rule__AdditiveExpression__Group_1__1 : rule__AdditiveExpression__Group_1__1__Impl ;
    public final void rule__AdditiveExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6593:1: ( rule__AdditiveExpression__Group_1__1__Impl )
            // InternalExprParser.g:6594:2: rule__AdditiveExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AdditiveExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group_1__1"


    // $ANTLR start "rule__AdditiveExpression__Group_1__1__Impl"
    // InternalExprParser.g:6600:1: rule__AdditiveExpression__Group_1__1__Impl : ( ( rule__AdditiveExpression__RightAssignment_1_1 ) ) ;
    public final void rule__AdditiveExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6604:1: ( ( ( rule__AdditiveExpression__RightAssignment_1_1 ) ) )
            // InternalExprParser.g:6605:1: ( ( rule__AdditiveExpression__RightAssignment_1_1 ) )
            {
            // InternalExprParser.g:6605:1: ( ( rule__AdditiveExpression__RightAssignment_1_1 ) )
            // InternalExprParser.g:6606:1: ( rule__AdditiveExpression__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExpressionAccess().getRightAssignment_1_1()); 
            }
            // InternalExprParser.g:6607:1: ( rule__AdditiveExpression__RightAssignment_1_1 )
            // InternalExprParser.g:6607:2: rule__AdditiveExpression__RightAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__AdditiveExpression__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExpressionAccess().getRightAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group_1__1__Impl"


    // $ANTLR start "rule__AdditiveExpression__Group_1_0__0"
    // InternalExprParser.g:6621:1: rule__AdditiveExpression__Group_1_0__0 : rule__AdditiveExpression__Group_1_0__0__Impl ;
    public final void rule__AdditiveExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6625:1: ( rule__AdditiveExpression__Group_1_0__0__Impl )
            // InternalExprParser.g:6626:2: rule__AdditiveExpression__Group_1_0__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AdditiveExpression__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group_1_0__0"


    // $ANTLR start "rule__AdditiveExpression__Group_1_0__0__Impl"
    // InternalExprParser.g:6632:1: rule__AdditiveExpression__Group_1_0__0__Impl : ( ( rule__AdditiveExpression__Group_1_0_0__0 ) ) ;
    public final void rule__AdditiveExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6636:1: ( ( ( rule__AdditiveExpression__Group_1_0_0__0 ) ) )
            // InternalExprParser.g:6637:1: ( ( rule__AdditiveExpression__Group_1_0_0__0 ) )
            {
            // InternalExprParser.g:6637:1: ( ( rule__AdditiveExpression__Group_1_0_0__0 ) )
            // InternalExprParser.g:6638:1: ( rule__AdditiveExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalExprParser.g:6639:1: ( rule__AdditiveExpression__Group_1_0_0__0 )
            // InternalExprParser.g:6639:2: rule__AdditiveExpression__Group_1_0_0__0
            {
            pushFollow(FOLLOW_2);
            rule__AdditiveExpression__Group_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExpressionAccess().getGroup_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group_1_0__0__Impl"


    // $ANTLR start "rule__AdditiveExpression__Group_1_0_0__0"
    // InternalExprParser.g:6651:1: rule__AdditiveExpression__Group_1_0_0__0 : rule__AdditiveExpression__Group_1_0_0__0__Impl rule__AdditiveExpression__Group_1_0_0__1 ;
    public final void rule__AdditiveExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6655:1: ( rule__AdditiveExpression__Group_1_0_0__0__Impl rule__AdditiveExpression__Group_1_0_0__1 )
            // InternalExprParser.g:6656:2: rule__AdditiveExpression__Group_1_0_0__0__Impl rule__AdditiveExpression__Group_1_0_0__1
            {
            pushFollow(FOLLOW_44);
            rule__AdditiveExpression__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AdditiveExpression__Group_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group_1_0_0__0"


    // $ANTLR start "rule__AdditiveExpression__Group_1_0_0__0__Impl"
    // InternalExprParser.g:6663:1: rule__AdditiveExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__AdditiveExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6667:1: ( ( () ) )
            // InternalExprParser.g:6668:1: ( () )
            {
            // InternalExprParser.g:6668:1: ( () )
            // InternalExprParser.g:6669:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExpressionAccess().getBinaryOperationLeftAction_1_0_0_0()); 
            }
            // InternalExprParser.g:6670:1: ()
            // InternalExprParser.g:6672:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExpressionAccess().getBinaryOperationLeftAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__AdditiveExpression__Group_1_0_0__1"
    // InternalExprParser.g:6682:1: rule__AdditiveExpression__Group_1_0_0__1 : rule__AdditiveExpression__Group_1_0_0__1__Impl ;
    public final void rule__AdditiveExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6686:1: ( rule__AdditiveExpression__Group_1_0_0__1__Impl )
            // InternalExprParser.g:6687:2: rule__AdditiveExpression__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AdditiveExpression__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group_1_0_0__1"


    // $ANTLR start "rule__AdditiveExpression__Group_1_0_0__1__Impl"
    // InternalExprParser.g:6693:1: rule__AdditiveExpression__Group_1_0_0__1__Impl : ( ( rule__AdditiveExpression__OperatorAssignment_1_0_0_1 ) ) ;
    public final void rule__AdditiveExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6697:1: ( ( ( rule__AdditiveExpression__OperatorAssignment_1_0_0_1 ) ) )
            // InternalExprParser.g:6698:1: ( ( rule__AdditiveExpression__OperatorAssignment_1_0_0_1 ) )
            {
            // InternalExprParser.g:6698:1: ( ( rule__AdditiveExpression__OperatorAssignment_1_0_0_1 ) )
            // InternalExprParser.g:6699:1: ( rule__AdditiveExpression__OperatorAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExpressionAccess().getOperatorAssignment_1_0_0_1()); 
            }
            // InternalExprParser.g:6700:1: ( rule__AdditiveExpression__OperatorAssignment_1_0_0_1 )
            // InternalExprParser.g:6700:2: rule__AdditiveExpression__OperatorAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_2);
            rule__AdditiveExpression__OperatorAssignment_1_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExpressionAccess().getOperatorAssignment_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__MultiplicativeExpression__Group__0"
    // InternalExprParser.g:6714:1: rule__MultiplicativeExpression__Group__0 : rule__MultiplicativeExpression__Group__0__Impl rule__MultiplicativeExpression__Group__1 ;
    public final void rule__MultiplicativeExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6718:1: ( rule__MultiplicativeExpression__Group__0__Impl rule__MultiplicativeExpression__Group__1 )
            // InternalExprParser.g:6719:2: rule__MultiplicativeExpression__Group__0__Impl rule__MultiplicativeExpression__Group__1
            {
            pushFollow(FOLLOW_46);
            rule__MultiplicativeExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MultiplicativeExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group__0"


    // $ANTLR start "rule__MultiplicativeExpression__Group__0__Impl"
    // InternalExprParser.g:6726:1: rule__MultiplicativeExpression__Group__0__Impl : ( ruleUnaryOperation ) ;
    public final void rule__MultiplicativeExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6730:1: ( ( ruleUnaryOperation ) )
            // InternalExprParser.g:6731:1: ( ruleUnaryOperation )
            {
            // InternalExprParser.g:6731:1: ( ruleUnaryOperation )
            // InternalExprParser.g:6732:1: ruleUnaryOperation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExpressionAccess().getUnaryOperationParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleUnaryOperation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExpressionAccess().getUnaryOperationParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group__0__Impl"


    // $ANTLR start "rule__MultiplicativeExpression__Group__1"
    // InternalExprParser.g:6743:1: rule__MultiplicativeExpression__Group__1 : rule__MultiplicativeExpression__Group__1__Impl ;
    public final void rule__MultiplicativeExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6747:1: ( rule__MultiplicativeExpression__Group__1__Impl )
            // InternalExprParser.g:6748:2: rule__MultiplicativeExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicativeExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group__1"


    // $ANTLR start "rule__MultiplicativeExpression__Group__1__Impl"
    // InternalExprParser.g:6754:1: rule__MultiplicativeExpression__Group__1__Impl : ( ( rule__MultiplicativeExpression__Group_1__0 )* ) ;
    public final void rule__MultiplicativeExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6758:1: ( ( ( rule__MultiplicativeExpression__Group_1__0 )* ) )
            // InternalExprParser.g:6759:1: ( ( rule__MultiplicativeExpression__Group_1__0 )* )
            {
            // InternalExprParser.g:6759:1: ( ( rule__MultiplicativeExpression__Group_1__0 )* )
            // InternalExprParser.g:6760:1: ( rule__MultiplicativeExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1()); 
            }
            // InternalExprParser.g:6761:1: ( rule__MultiplicativeExpression__Group_1__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==Div||LA35_0==Mod||LA35_0==Asterisk||LA35_0==Solidus) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalExprParser.g:6761:2: rule__MultiplicativeExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_47);
            	    rule__MultiplicativeExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group__1__Impl"


    // $ANTLR start "rule__MultiplicativeExpression__Group_1__0"
    // InternalExprParser.g:6775:1: rule__MultiplicativeExpression__Group_1__0 : rule__MultiplicativeExpression__Group_1__0__Impl rule__MultiplicativeExpression__Group_1__1 ;
    public final void rule__MultiplicativeExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6779:1: ( rule__MultiplicativeExpression__Group_1__0__Impl rule__MultiplicativeExpression__Group_1__1 )
            // InternalExprParser.g:6780:2: rule__MultiplicativeExpression__Group_1__0__Impl rule__MultiplicativeExpression__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__MultiplicativeExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MultiplicativeExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group_1__0"


    // $ANTLR start "rule__MultiplicativeExpression__Group_1__0__Impl"
    // InternalExprParser.g:6787:1: rule__MultiplicativeExpression__Group_1__0__Impl : ( ( rule__MultiplicativeExpression__Group_1_0__0 ) ) ;
    public final void rule__MultiplicativeExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6791:1: ( ( ( rule__MultiplicativeExpression__Group_1_0__0 ) ) )
            // InternalExprParser.g:6792:1: ( ( rule__MultiplicativeExpression__Group_1_0__0 ) )
            {
            // InternalExprParser.g:6792:1: ( ( rule__MultiplicativeExpression__Group_1_0__0 ) )
            // InternalExprParser.g:6793:1: ( rule__MultiplicativeExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_0()); 
            }
            // InternalExprParser.g:6794:1: ( rule__MultiplicativeExpression__Group_1_0__0 )
            // InternalExprParser.g:6794:2: rule__MultiplicativeExpression__Group_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicativeExpression__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group_1__0__Impl"


    // $ANTLR start "rule__MultiplicativeExpression__Group_1__1"
    // InternalExprParser.g:6804:1: rule__MultiplicativeExpression__Group_1__1 : rule__MultiplicativeExpression__Group_1__1__Impl ;
    public final void rule__MultiplicativeExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6808:1: ( rule__MultiplicativeExpression__Group_1__1__Impl )
            // InternalExprParser.g:6809:2: rule__MultiplicativeExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicativeExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group_1__1"


    // $ANTLR start "rule__MultiplicativeExpression__Group_1__1__Impl"
    // InternalExprParser.g:6815:1: rule__MultiplicativeExpression__Group_1__1__Impl : ( ( rule__MultiplicativeExpression__RightAssignment_1_1 ) ) ;
    public final void rule__MultiplicativeExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6819:1: ( ( ( rule__MultiplicativeExpression__RightAssignment_1_1 ) ) )
            // InternalExprParser.g:6820:1: ( ( rule__MultiplicativeExpression__RightAssignment_1_1 ) )
            {
            // InternalExprParser.g:6820:1: ( ( rule__MultiplicativeExpression__RightAssignment_1_1 ) )
            // InternalExprParser.g:6821:1: ( rule__MultiplicativeExpression__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExpressionAccess().getRightAssignment_1_1()); 
            }
            // InternalExprParser.g:6822:1: ( rule__MultiplicativeExpression__RightAssignment_1_1 )
            // InternalExprParser.g:6822:2: rule__MultiplicativeExpression__RightAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicativeExpression__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExpressionAccess().getRightAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group_1__1__Impl"


    // $ANTLR start "rule__MultiplicativeExpression__Group_1_0__0"
    // InternalExprParser.g:6836:1: rule__MultiplicativeExpression__Group_1_0__0 : rule__MultiplicativeExpression__Group_1_0__0__Impl ;
    public final void rule__MultiplicativeExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6840:1: ( rule__MultiplicativeExpression__Group_1_0__0__Impl )
            // InternalExprParser.g:6841:2: rule__MultiplicativeExpression__Group_1_0__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicativeExpression__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group_1_0__0"


    // $ANTLR start "rule__MultiplicativeExpression__Group_1_0__0__Impl"
    // InternalExprParser.g:6847:1: rule__MultiplicativeExpression__Group_1_0__0__Impl : ( ( rule__MultiplicativeExpression__Group_1_0_0__0 ) ) ;
    public final void rule__MultiplicativeExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6851:1: ( ( ( rule__MultiplicativeExpression__Group_1_0_0__0 ) ) )
            // InternalExprParser.g:6852:1: ( ( rule__MultiplicativeExpression__Group_1_0_0__0 ) )
            {
            // InternalExprParser.g:6852:1: ( ( rule__MultiplicativeExpression__Group_1_0_0__0 ) )
            // InternalExprParser.g:6853:1: ( rule__MultiplicativeExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalExprParser.g:6854:1: ( rule__MultiplicativeExpression__Group_1_0_0__0 )
            // InternalExprParser.g:6854:2: rule__MultiplicativeExpression__Group_1_0_0__0
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicativeExpression__Group_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group_1_0__0__Impl"


    // $ANTLR start "rule__MultiplicativeExpression__Group_1_0_0__0"
    // InternalExprParser.g:6866:1: rule__MultiplicativeExpression__Group_1_0_0__0 : rule__MultiplicativeExpression__Group_1_0_0__0__Impl rule__MultiplicativeExpression__Group_1_0_0__1 ;
    public final void rule__MultiplicativeExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6870:1: ( rule__MultiplicativeExpression__Group_1_0_0__0__Impl rule__MultiplicativeExpression__Group_1_0_0__1 )
            // InternalExprParser.g:6871:2: rule__MultiplicativeExpression__Group_1_0_0__0__Impl rule__MultiplicativeExpression__Group_1_0_0__1
            {
            pushFollow(FOLLOW_46);
            rule__MultiplicativeExpression__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MultiplicativeExpression__Group_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group_1_0_0__0"


    // $ANTLR start "rule__MultiplicativeExpression__Group_1_0_0__0__Impl"
    // InternalExprParser.g:6878:1: rule__MultiplicativeExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__MultiplicativeExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6882:1: ( ( () ) )
            // InternalExprParser.g:6883:1: ( () )
            {
            // InternalExprParser.g:6883:1: ( () )
            // InternalExprParser.g:6884:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExpressionAccess().getBinaryOperationLeftAction_1_0_0_0()); 
            }
            // InternalExprParser.g:6885:1: ()
            // InternalExprParser.g:6887:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExpressionAccess().getBinaryOperationLeftAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__MultiplicativeExpression__Group_1_0_0__1"
    // InternalExprParser.g:6897:1: rule__MultiplicativeExpression__Group_1_0_0__1 : rule__MultiplicativeExpression__Group_1_0_0__1__Impl ;
    public final void rule__MultiplicativeExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6901:1: ( rule__MultiplicativeExpression__Group_1_0_0__1__Impl )
            // InternalExprParser.g:6902:2: rule__MultiplicativeExpression__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicativeExpression__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group_1_0_0__1"


    // $ANTLR start "rule__MultiplicativeExpression__Group_1_0_0__1__Impl"
    // InternalExprParser.g:6908:1: rule__MultiplicativeExpression__Group_1_0_0__1__Impl : ( ( rule__MultiplicativeExpression__OperatorAssignment_1_0_0_1 ) ) ;
    public final void rule__MultiplicativeExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6912:1: ( ( ( rule__MultiplicativeExpression__OperatorAssignment_1_0_0_1 ) ) )
            // InternalExprParser.g:6913:1: ( ( rule__MultiplicativeExpression__OperatorAssignment_1_0_0_1 ) )
            {
            // InternalExprParser.g:6913:1: ( ( rule__MultiplicativeExpression__OperatorAssignment_1_0_0_1 ) )
            // InternalExprParser.g:6914:1: ( rule__MultiplicativeExpression__OperatorAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAssignment_1_0_0_1()); 
            }
            // InternalExprParser.g:6915:1: ( rule__MultiplicativeExpression__OperatorAssignment_1_0_0_1 )
            // InternalExprParser.g:6915:2: rule__MultiplicativeExpression__OperatorAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicativeExpression__OperatorAssignment_1_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAssignment_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__UnaryOperation__Group_0__0"
    // InternalExprParser.g:6929:1: rule__UnaryOperation__Group_0__0 : rule__UnaryOperation__Group_0__0__Impl rule__UnaryOperation__Group_0__1 ;
    public final void rule__UnaryOperation__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6933:1: ( rule__UnaryOperation__Group_0__0__Impl rule__UnaryOperation__Group_0__1 )
            // InternalExprParser.g:6934:2: rule__UnaryOperation__Group_0__0__Impl rule__UnaryOperation__Group_0__1
            {
            pushFollow(FOLLOW_48);
            rule__UnaryOperation__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UnaryOperation__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryOperation__Group_0__0"


    // $ANTLR start "rule__UnaryOperation__Group_0__0__Impl"
    // InternalExprParser.g:6941:1: rule__UnaryOperation__Group_0__0__Impl : ( () ) ;
    public final void rule__UnaryOperation__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6945:1: ( ( () ) )
            // InternalExprParser.g:6946:1: ( () )
            {
            // InternalExprParser.g:6946:1: ( () )
            // InternalExprParser.g:6947:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryOperationAccess().getUnaryOperationAction_0_0()); 
            }
            // InternalExprParser.g:6948:1: ()
            // InternalExprParser.g:6950:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnaryOperationAccess().getUnaryOperationAction_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryOperation__Group_0__0__Impl"


    // $ANTLR start "rule__UnaryOperation__Group_0__1"
    // InternalExprParser.g:6960:1: rule__UnaryOperation__Group_0__1 : rule__UnaryOperation__Group_0__1__Impl rule__UnaryOperation__Group_0__2 ;
    public final void rule__UnaryOperation__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6964:1: ( rule__UnaryOperation__Group_0__1__Impl rule__UnaryOperation__Group_0__2 )
            // InternalExprParser.g:6965:2: rule__UnaryOperation__Group_0__1__Impl rule__UnaryOperation__Group_0__2
            {
            pushFollow(FOLLOW_12);
            rule__UnaryOperation__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UnaryOperation__Group_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryOperation__Group_0__1"


    // $ANTLR start "rule__UnaryOperation__Group_0__1__Impl"
    // InternalExprParser.g:6972:1: rule__UnaryOperation__Group_0__1__Impl : ( ( rule__UnaryOperation__OperatorAssignment_0_1 ) ) ;
    public final void rule__UnaryOperation__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6976:1: ( ( ( rule__UnaryOperation__OperatorAssignment_0_1 ) ) )
            // InternalExprParser.g:6977:1: ( ( rule__UnaryOperation__OperatorAssignment_0_1 ) )
            {
            // InternalExprParser.g:6977:1: ( ( rule__UnaryOperation__OperatorAssignment_0_1 ) )
            // InternalExprParser.g:6978:1: ( rule__UnaryOperation__OperatorAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryOperationAccess().getOperatorAssignment_0_1()); 
            }
            // InternalExprParser.g:6979:1: ( rule__UnaryOperation__OperatorAssignment_0_1 )
            // InternalExprParser.g:6979:2: rule__UnaryOperation__OperatorAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__UnaryOperation__OperatorAssignment_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnaryOperationAccess().getOperatorAssignment_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryOperation__Group_0__1__Impl"


    // $ANTLR start "rule__UnaryOperation__Group_0__2"
    // InternalExprParser.g:6989:1: rule__UnaryOperation__Group_0__2 : rule__UnaryOperation__Group_0__2__Impl ;
    public final void rule__UnaryOperation__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6993:1: ( rule__UnaryOperation__Group_0__2__Impl )
            // InternalExprParser.g:6994:2: rule__UnaryOperation__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UnaryOperation__Group_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryOperation__Group_0__2"


    // $ANTLR start "rule__UnaryOperation__Group_0__2__Impl"
    // InternalExprParser.g:7000:1: rule__UnaryOperation__Group_0__2__Impl : ( ( rule__UnaryOperation__OperandAssignment_0_2 ) ) ;
    public final void rule__UnaryOperation__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7004:1: ( ( ( rule__UnaryOperation__OperandAssignment_0_2 ) ) )
            // InternalExprParser.g:7005:1: ( ( rule__UnaryOperation__OperandAssignment_0_2 ) )
            {
            // InternalExprParser.g:7005:1: ( ( rule__UnaryOperation__OperandAssignment_0_2 ) )
            // InternalExprParser.g:7006:1: ( rule__UnaryOperation__OperandAssignment_0_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryOperationAccess().getOperandAssignment_0_2()); 
            }
            // InternalExprParser.g:7007:1: ( rule__UnaryOperation__OperandAssignment_0_2 )
            // InternalExprParser.g:7007:2: rule__UnaryOperation__OperandAssignment_0_2
            {
            pushFollow(FOLLOW_2);
            rule__UnaryOperation__OperandAssignment_0_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnaryOperationAccess().getOperandAssignment_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryOperation__Group_0__2__Impl"


    // $ANTLR start "rule__UnitExpression__Group__0"
    // InternalExprParser.g:7023:1: rule__UnitExpression__Group__0 : rule__UnitExpression__Group__0__Impl rule__UnitExpression__Group__1 ;
    public final void rule__UnitExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7027:1: ( rule__UnitExpression__Group__0__Impl rule__UnitExpression__Group__1 )
            // InternalExprParser.g:7028:2: rule__UnitExpression__Group__0__Impl rule__UnitExpression__Group__1
            {
            pushFollow(FOLLOW_49);
            rule__UnitExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UnitExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnitExpression__Group__0"


    // $ANTLR start "rule__UnitExpression__Group__0__Impl"
    // InternalExprParser.g:7035:1: rule__UnitExpression__Group__0__Impl : ( rulePrimaryExpression ) ;
    public final void rule__UnitExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7039:1: ( ( rulePrimaryExpression ) )
            // InternalExprParser.g:7040:1: ( rulePrimaryExpression )
            {
            // InternalExprParser.g:7040:1: ( rulePrimaryExpression )
            // InternalExprParser.g:7041:1: rulePrimaryExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnitExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnitExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnitExpression__Group__0__Impl"


    // $ANTLR start "rule__UnitExpression__Group__1"
    // InternalExprParser.g:7052:1: rule__UnitExpression__Group__1 : rule__UnitExpression__Group__1__Impl ;
    public final void rule__UnitExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7056:1: ( rule__UnitExpression__Group__1__Impl )
            // InternalExprParser.g:7057:2: rule__UnitExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UnitExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnitExpression__Group__1"


    // $ANTLR start "rule__UnitExpression__Group__1__Impl"
    // InternalExprParser.g:7063:1: rule__UnitExpression__Group__1__Impl : ( ( rule__UnitExpression__Group_1__0 )? ) ;
    public final void rule__UnitExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7067:1: ( ( ( rule__UnitExpression__Group_1__0 )? ) )
            // InternalExprParser.g:7068:1: ( ( rule__UnitExpression__Group_1__0 )? )
            {
            // InternalExprParser.g:7068:1: ( ( rule__UnitExpression__Group_1__0 )? )
            // InternalExprParser.g:7069:1: ( rule__UnitExpression__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnitExpressionAccess().getGroup_1()); 
            }
            // InternalExprParser.g:7070:1: ( rule__UnitExpression__Group_1__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==In||LA36_0==PercentSign||LA36_0==RULE_ID) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalExprParser.g:7070:2: rule__UnitExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__UnitExpression__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnitExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnitExpression__Group__1__Impl"


    // $ANTLR start "rule__UnitExpression__Group_1__0"
    // InternalExprParser.g:7084:1: rule__UnitExpression__Group_1__0 : rule__UnitExpression__Group_1__0__Impl rule__UnitExpression__Group_1__1 ;
    public final void rule__UnitExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7088:1: ( rule__UnitExpression__Group_1__0__Impl rule__UnitExpression__Group_1__1 )
            // InternalExprParser.g:7089:2: rule__UnitExpression__Group_1__0__Impl rule__UnitExpression__Group_1__1
            {
            pushFollow(FOLLOW_49);
            rule__UnitExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UnitExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnitExpression__Group_1__0"


    // $ANTLR start "rule__UnitExpression__Group_1__0__Impl"
    // InternalExprParser.g:7096:1: rule__UnitExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__UnitExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7100:1: ( ( () ) )
            // InternalExprParser.g:7101:1: ( () )
            {
            // InternalExprParser.g:7101:1: ( () )
            // InternalExprParser.g:7102:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnitExpressionAccess().getUnitExpressionExpressionAction_1_0()); 
            }
            // InternalExprParser.g:7103:1: ()
            // InternalExprParser.g:7105:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnitExpressionAccess().getUnitExpressionExpressionAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnitExpression__Group_1__0__Impl"


    // $ANTLR start "rule__UnitExpression__Group_1__1"
    // InternalExprParser.g:7115:1: rule__UnitExpression__Group_1__1 : rule__UnitExpression__Group_1__1__Impl rule__UnitExpression__Group_1__2 ;
    public final void rule__UnitExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7119:1: ( rule__UnitExpression__Group_1__1__Impl rule__UnitExpression__Group_1__2 )
            // InternalExprParser.g:7120:2: rule__UnitExpression__Group_1__1__Impl rule__UnitExpression__Group_1__2
            {
            pushFollow(FOLLOW_49);
            rule__UnitExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UnitExpression__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnitExpression__Group_1__1"


    // $ANTLR start "rule__UnitExpression__Group_1__1__Impl"
    // InternalExprParser.g:7127:1: rule__UnitExpression__Group_1__1__Impl : ( ( rule__UnitExpression__Alternatives_1_1 )? ) ;
    public final void rule__UnitExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7131:1: ( ( ( rule__UnitExpression__Alternatives_1_1 )? ) )
            // InternalExprParser.g:7132:1: ( ( rule__UnitExpression__Alternatives_1_1 )? )
            {
            // InternalExprParser.g:7132:1: ( ( rule__UnitExpression__Alternatives_1_1 )? )
            // InternalExprParser.g:7133:1: ( rule__UnitExpression__Alternatives_1_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnitExpressionAccess().getAlternatives_1_1()); 
            }
            // InternalExprParser.g:7134:1: ( rule__UnitExpression__Alternatives_1_1 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==In||LA37_0==PercentSign) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalExprParser.g:7134:2: rule__UnitExpression__Alternatives_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__UnitExpression__Alternatives_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnitExpressionAccess().getAlternatives_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnitExpression__Group_1__1__Impl"


    // $ANTLR start "rule__UnitExpression__Group_1__2"
    // InternalExprParser.g:7144:1: rule__UnitExpression__Group_1__2 : rule__UnitExpression__Group_1__2__Impl ;
    public final void rule__UnitExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7148:1: ( rule__UnitExpression__Group_1__2__Impl )
            // InternalExprParser.g:7149:2: rule__UnitExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UnitExpression__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnitExpression__Group_1__2"


    // $ANTLR start "rule__UnitExpression__Group_1__2__Impl"
    // InternalExprParser.g:7155:1: rule__UnitExpression__Group_1__2__Impl : ( ( rule__UnitExpression__UnitAssignment_1_2 ) ) ;
    public final void rule__UnitExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7159:1: ( ( ( rule__UnitExpression__UnitAssignment_1_2 ) ) )
            // InternalExprParser.g:7160:1: ( ( rule__UnitExpression__UnitAssignment_1_2 ) )
            {
            // InternalExprParser.g:7160:1: ( ( rule__UnitExpression__UnitAssignment_1_2 ) )
            // InternalExprParser.g:7161:1: ( rule__UnitExpression__UnitAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnitExpressionAccess().getUnitAssignment_1_2()); 
            }
            // InternalExprParser.g:7162:1: ( rule__UnitExpression__UnitAssignment_1_2 )
            // InternalExprParser.g:7162:2: rule__UnitExpression__UnitAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__UnitExpression__UnitAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnitExpressionAccess().getUnitAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnitExpression__Group_1__2__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_6__0"
    // InternalExprParser.g:7178:1: rule__PrimaryExpression__Group_6__0 : rule__PrimaryExpression__Group_6__0__Impl rule__PrimaryExpression__Group_6__1 ;
    public final void rule__PrimaryExpression__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7182:1: ( rule__PrimaryExpression__Group_6__0__Impl rule__PrimaryExpression__Group_6__1 )
            // InternalExprParser.g:7183:2: rule__PrimaryExpression__Group_6__0__Impl rule__PrimaryExpression__Group_6__1
            {
            pushFollow(FOLLOW_12);
            rule__PrimaryExpression__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_6__0"


    // $ANTLR start "rule__PrimaryExpression__Group_6__0__Impl"
    // InternalExprParser.g:7190:1: rule__PrimaryExpression__Group_6__0__Impl : ( LeftParenthesis ) ;
    public final void rule__PrimaryExpression__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7194:1: ( ( LeftParenthesis ) )
            // InternalExprParser.g:7195:1: ( LeftParenthesis )
            {
            // InternalExprParser.g:7195:1: ( LeftParenthesis )
            // InternalExprParser.g:7196:1: LeftParenthesis
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_6_0()); 
            }
            match(input,LeftParenthesis,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_6__0__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_6__1"
    // InternalExprParser.g:7209:1: rule__PrimaryExpression__Group_6__1 : rule__PrimaryExpression__Group_6__1__Impl rule__PrimaryExpression__Group_6__2 ;
    public final void rule__PrimaryExpression__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7213:1: ( rule__PrimaryExpression__Group_6__1__Impl rule__PrimaryExpression__Group_6__2 )
            // InternalExprParser.g:7214:2: rule__PrimaryExpression__Group_6__1__Impl rule__PrimaryExpression__Group_6__2
            {
            pushFollow(FOLLOW_14);
            rule__PrimaryExpression__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_6__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_6__1"


    // $ANTLR start "rule__PrimaryExpression__Group_6__1__Impl"
    // InternalExprParser.g:7221:1: rule__PrimaryExpression__Group_6__1__Impl : ( ruleExpression ) ;
    public final void rule__PrimaryExpression__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7225:1: ( ( ruleExpression ) )
            // InternalExprParser.g:7226:1: ( ruleExpression )
            {
            // InternalExprParser.g:7226:1: ( ruleExpression )
            // InternalExprParser.g:7227:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_6_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_6_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_6__1__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_6__2"
    // InternalExprParser.g:7238:1: rule__PrimaryExpression__Group_6__2 : rule__PrimaryExpression__Group_6__2__Impl ;
    public final void rule__PrimaryExpression__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7242:1: ( rule__PrimaryExpression__Group_6__2__Impl )
            // InternalExprParser.g:7243:2: rule__PrimaryExpression__Group_6__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_6__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_6__2"


    // $ANTLR start "rule__PrimaryExpression__Group_6__2__Impl"
    // InternalExprParser.g:7249:1: rule__PrimaryExpression__Group_6__2__Impl : ( RightParenthesis ) ;
    public final void rule__PrimaryExpression__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7253:1: ( ( RightParenthesis ) )
            // InternalExprParser.g:7254:1: ( RightParenthesis )
            {
            // InternalExprParser.g:7254:1: ( RightParenthesis )
            // InternalExprParser.g:7255:1: RightParenthesis
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_6_2()); 
            }
            match(input,RightParenthesis,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_6_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_6__2__Impl"


    // $ANTLR start "rule__ModelOrPropertyReference__Group_0__0"
    // InternalExprParser.g:7274:1: rule__ModelOrPropertyReference__Group_0__0 : rule__ModelOrPropertyReference__Group_0__0__Impl rule__ModelOrPropertyReference__Group_0__1 ;
    public final void rule__ModelOrPropertyReference__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7278:1: ( rule__ModelOrPropertyReference__Group_0__0__Impl rule__ModelOrPropertyReference__Group_0__1 )
            // InternalExprParser.g:7279:2: rule__ModelOrPropertyReference__Group_0__0__Impl rule__ModelOrPropertyReference__Group_0__1
            {
            pushFollow(FOLLOW_50);
            rule__ModelOrPropertyReference__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ModelOrPropertyReference__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelOrPropertyReference__Group_0__0"


    // $ANTLR start "rule__ModelOrPropertyReference__Group_0__0__Impl"
    // InternalExprParser.g:7286:1: rule__ModelOrPropertyReference__Group_0__0__Impl : ( ruleModelReference ) ;
    public final void rule__ModelOrPropertyReference__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7290:1: ( ( ruleModelReference ) )
            // InternalExprParser.g:7291:1: ( ruleModelReference )
            {
            // InternalExprParser.g:7291:1: ( ruleModelReference )
            // InternalExprParser.g:7292:1: ruleModelReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelOrPropertyReferenceAccess().getModelReferenceParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleModelReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelOrPropertyReferenceAccess().getModelReferenceParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelOrPropertyReference__Group_0__0__Impl"


    // $ANTLR start "rule__ModelOrPropertyReference__Group_0__1"
    // InternalExprParser.g:7303:1: rule__ModelOrPropertyReference__Group_0__1 : rule__ModelOrPropertyReference__Group_0__1__Impl ;
    public final void rule__ModelOrPropertyReference__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7307:1: ( rule__ModelOrPropertyReference__Group_0__1__Impl )
            // InternalExprParser.g:7308:2: rule__ModelOrPropertyReference__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ModelOrPropertyReference__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelOrPropertyReference__Group_0__1"


    // $ANTLR start "rule__ModelOrPropertyReference__Group_0__1__Impl"
    // InternalExprParser.g:7314:1: rule__ModelOrPropertyReference__Group_0__1__Impl : ( ( rule__ModelOrPropertyReference__Group_0_1__0 )? ) ;
    public final void rule__ModelOrPropertyReference__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7318:1: ( ( ( rule__ModelOrPropertyReference__Group_0_1__0 )? ) )
            // InternalExprParser.g:7319:1: ( ( rule__ModelOrPropertyReference__Group_0_1__0 )? )
            {
            // InternalExprParser.g:7319:1: ( ( rule__ModelOrPropertyReference__Group_0_1__0 )? )
            // InternalExprParser.g:7320:1: ( rule__ModelOrPropertyReference__Group_0_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelOrPropertyReferenceAccess().getGroup_0_1()); 
            }
            // InternalExprParser.g:7321:1: ( rule__ModelOrPropertyReference__Group_0_1__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==NumberSign) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalExprParser.g:7321:2: rule__ModelOrPropertyReference__Group_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ModelOrPropertyReference__Group_0_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelOrPropertyReferenceAccess().getGroup_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelOrPropertyReference__Group_0__1__Impl"


    // $ANTLR start "rule__ModelOrPropertyReference__Group_0_1__0"
    // InternalExprParser.g:7335:1: rule__ModelOrPropertyReference__Group_0_1__0 : rule__ModelOrPropertyReference__Group_0_1__0__Impl rule__ModelOrPropertyReference__Group_0_1__1 ;
    public final void rule__ModelOrPropertyReference__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7339:1: ( rule__ModelOrPropertyReference__Group_0_1__0__Impl rule__ModelOrPropertyReference__Group_0_1__1 )
            // InternalExprParser.g:7340:2: rule__ModelOrPropertyReference__Group_0_1__0__Impl rule__ModelOrPropertyReference__Group_0_1__1
            {
            pushFollow(FOLLOW_7);
            rule__ModelOrPropertyReference__Group_0_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ModelOrPropertyReference__Group_0_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelOrPropertyReference__Group_0_1__0"


    // $ANTLR start "rule__ModelOrPropertyReference__Group_0_1__0__Impl"
    // InternalExprParser.g:7347:1: rule__ModelOrPropertyReference__Group_0_1__0__Impl : ( ( rule__ModelOrPropertyReference__Group_0_1_0__0 ) ) ;
    public final void rule__ModelOrPropertyReference__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7351:1: ( ( ( rule__ModelOrPropertyReference__Group_0_1_0__0 ) ) )
            // InternalExprParser.g:7352:1: ( ( rule__ModelOrPropertyReference__Group_0_1_0__0 ) )
            {
            // InternalExprParser.g:7352:1: ( ( rule__ModelOrPropertyReference__Group_0_1_0__0 ) )
            // InternalExprParser.g:7353:1: ( rule__ModelOrPropertyReference__Group_0_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelOrPropertyReferenceAccess().getGroup_0_1_0()); 
            }
            // InternalExprParser.g:7354:1: ( rule__ModelOrPropertyReference__Group_0_1_0__0 )
            // InternalExprParser.g:7354:2: rule__ModelOrPropertyReference__Group_0_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__ModelOrPropertyReference__Group_0_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelOrPropertyReferenceAccess().getGroup_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelOrPropertyReference__Group_0_1__0__Impl"


    // $ANTLR start "rule__ModelOrPropertyReference__Group_0_1__1"
    // InternalExprParser.g:7364:1: rule__ModelOrPropertyReference__Group_0_1__1 : rule__ModelOrPropertyReference__Group_0_1__1__Impl ;
    public final void rule__ModelOrPropertyReference__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7368:1: ( rule__ModelOrPropertyReference__Group_0_1__1__Impl )
            // InternalExprParser.g:7369:2: rule__ModelOrPropertyReference__Group_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ModelOrPropertyReference__Group_0_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelOrPropertyReference__Group_0_1__1"


    // $ANTLR start "rule__ModelOrPropertyReference__Group_0_1__1__Impl"
    // InternalExprParser.g:7375:1: rule__ModelOrPropertyReference__Group_0_1__1__Impl : ( ( rule__ModelOrPropertyReference__PropertyAssignment_0_1_1 ) ) ;
    public final void rule__ModelOrPropertyReference__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7379:1: ( ( ( rule__ModelOrPropertyReference__PropertyAssignment_0_1_1 ) ) )
            // InternalExprParser.g:7380:1: ( ( rule__ModelOrPropertyReference__PropertyAssignment_0_1_1 ) )
            {
            // InternalExprParser.g:7380:1: ( ( rule__ModelOrPropertyReference__PropertyAssignment_0_1_1 ) )
            // InternalExprParser.g:7381:1: ( rule__ModelOrPropertyReference__PropertyAssignment_0_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelOrPropertyReferenceAccess().getPropertyAssignment_0_1_1()); 
            }
            // InternalExprParser.g:7382:1: ( rule__ModelOrPropertyReference__PropertyAssignment_0_1_1 )
            // InternalExprParser.g:7382:2: rule__ModelOrPropertyReference__PropertyAssignment_0_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ModelOrPropertyReference__PropertyAssignment_0_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelOrPropertyReferenceAccess().getPropertyAssignment_0_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelOrPropertyReference__Group_0_1__1__Impl"


    // $ANTLR start "rule__ModelOrPropertyReference__Group_0_1_0__0"
    // InternalExprParser.g:7396:1: rule__ModelOrPropertyReference__Group_0_1_0__0 : rule__ModelOrPropertyReference__Group_0_1_0__0__Impl ;
    public final void rule__ModelOrPropertyReference__Group_0_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7400:1: ( rule__ModelOrPropertyReference__Group_0_1_0__0__Impl )
            // InternalExprParser.g:7401:2: rule__ModelOrPropertyReference__Group_0_1_0__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ModelOrPropertyReference__Group_0_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelOrPropertyReference__Group_0_1_0__0"


    // $ANTLR start "rule__ModelOrPropertyReference__Group_0_1_0__0__Impl"
    // InternalExprParser.g:7407:1: rule__ModelOrPropertyReference__Group_0_1_0__0__Impl : ( ( rule__ModelOrPropertyReference__Group_0_1_0_0__0 ) ) ;
    public final void rule__ModelOrPropertyReference__Group_0_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7411:1: ( ( ( rule__ModelOrPropertyReference__Group_0_1_0_0__0 ) ) )
            // InternalExprParser.g:7412:1: ( ( rule__ModelOrPropertyReference__Group_0_1_0_0__0 ) )
            {
            // InternalExprParser.g:7412:1: ( ( rule__ModelOrPropertyReference__Group_0_1_0_0__0 ) )
            // InternalExprParser.g:7413:1: ( rule__ModelOrPropertyReference__Group_0_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelOrPropertyReferenceAccess().getGroup_0_1_0_0()); 
            }
            // InternalExprParser.g:7414:1: ( rule__ModelOrPropertyReference__Group_0_1_0_0__0 )
            // InternalExprParser.g:7414:2: rule__ModelOrPropertyReference__Group_0_1_0_0__0
            {
            pushFollow(FOLLOW_2);
            rule__ModelOrPropertyReference__Group_0_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelOrPropertyReferenceAccess().getGroup_0_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelOrPropertyReference__Group_0_1_0__0__Impl"


    // $ANTLR start "rule__ModelOrPropertyReference__Group_0_1_0_0__0"
    // InternalExprParser.g:7426:1: rule__ModelOrPropertyReference__Group_0_1_0_0__0 : rule__ModelOrPropertyReference__Group_0_1_0_0__0__Impl rule__ModelOrPropertyReference__Group_0_1_0_0__1 ;
    public final void rule__ModelOrPropertyReference__Group_0_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7430:1: ( rule__ModelOrPropertyReference__Group_0_1_0_0__0__Impl rule__ModelOrPropertyReference__Group_0_1_0_0__1 )
            // InternalExprParser.g:7431:2: rule__ModelOrPropertyReference__Group_0_1_0_0__0__Impl rule__ModelOrPropertyReference__Group_0_1_0_0__1
            {
            pushFollow(FOLLOW_50);
            rule__ModelOrPropertyReference__Group_0_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ModelOrPropertyReference__Group_0_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelOrPropertyReference__Group_0_1_0_0__0"


    // $ANTLR start "rule__ModelOrPropertyReference__Group_0_1_0_0__0__Impl"
    // InternalExprParser.g:7438:1: rule__ModelOrPropertyReference__Group_0_1_0_0__0__Impl : ( () ) ;
    public final void rule__ModelOrPropertyReference__Group_0_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7442:1: ( ( () ) )
            // InternalExprParser.g:7443:1: ( () )
            {
            // InternalExprParser.g:7443:1: ( () )
            // InternalExprParser.g:7444:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelOrPropertyReferenceAccess().getPropertyReferenceModelElementReferenceAction_0_1_0_0_0()); 
            }
            // InternalExprParser.g:7445:1: ()
            // InternalExprParser.g:7447:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelOrPropertyReferenceAccess().getPropertyReferenceModelElementReferenceAction_0_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelOrPropertyReference__Group_0_1_0_0__0__Impl"


    // $ANTLR start "rule__ModelOrPropertyReference__Group_0_1_0_0__1"
    // InternalExprParser.g:7457:1: rule__ModelOrPropertyReference__Group_0_1_0_0__1 : rule__ModelOrPropertyReference__Group_0_1_0_0__1__Impl ;
    public final void rule__ModelOrPropertyReference__Group_0_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7461:1: ( rule__ModelOrPropertyReference__Group_0_1_0_0__1__Impl )
            // InternalExprParser.g:7462:2: rule__ModelOrPropertyReference__Group_0_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ModelOrPropertyReference__Group_0_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelOrPropertyReference__Group_0_1_0_0__1"


    // $ANTLR start "rule__ModelOrPropertyReference__Group_0_1_0_0__1__Impl"
    // InternalExprParser.g:7468:1: rule__ModelOrPropertyReference__Group_0_1_0_0__1__Impl : ( NumberSign ) ;
    public final void rule__ModelOrPropertyReference__Group_0_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7472:1: ( ( NumberSign ) )
            // InternalExprParser.g:7473:1: ( NumberSign )
            {
            // InternalExprParser.g:7473:1: ( NumberSign )
            // InternalExprParser.g:7474:1: NumberSign
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelOrPropertyReferenceAccess().getNumberSignKeyword_0_1_0_0_1()); 
            }
            match(input,NumberSign,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelOrPropertyReferenceAccess().getNumberSignKeyword_0_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelOrPropertyReference__Group_0_1_0_0__1__Impl"


    // $ANTLR start "rule__ModelReference__Group__0"
    // InternalExprParser.g:7491:1: rule__ModelReference__Group__0 : rule__ModelReference__Group__0__Impl rule__ModelReference__Group__1 ;
    public final void rule__ModelReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7495:1: ( rule__ModelReference__Group__0__Impl rule__ModelReference__Group__1 )
            // InternalExprParser.g:7496:2: rule__ModelReference__Group__0__Impl rule__ModelReference__Group__1
            {
            pushFollow(FOLLOW_51);
            rule__ModelReference__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ModelReference__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelReference__Group__0"


    // $ANTLR start "rule__ModelReference__Group__0__Impl"
    // InternalExprParser.g:7503:1: rule__ModelReference__Group__0__Impl : ( ( rule__ModelReference__ModelElementAssignment_0 ) ) ;
    public final void rule__ModelReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7507:1: ( ( ( rule__ModelReference__ModelElementAssignment_0 ) ) )
            // InternalExprParser.g:7508:1: ( ( rule__ModelReference__ModelElementAssignment_0 ) )
            {
            // InternalExprParser.g:7508:1: ( ( rule__ModelReference__ModelElementAssignment_0 ) )
            // InternalExprParser.g:7509:1: ( rule__ModelReference__ModelElementAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelReferenceAccess().getModelElementAssignment_0()); 
            }
            // InternalExprParser.g:7510:1: ( rule__ModelReference__ModelElementAssignment_0 )
            // InternalExprParser.g:7510:2: rule__ModelReference__ModelElementAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ModelReference__ModelElementAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelReferenceAccess().getModelElementAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelReference__Group__0__Impl"


    // $ANTLR start "rule__ModelReference__Group__1"
    // InternalExprParser.g:7520:1: rule__ModelReference__Group__1 : rule__ModelReference__Group__1__Impl ;
    public final void rule__ModelReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7524:1: ( rule__ModelReference__Group__1__Impl )
            // InternalExprParser.g:7525:2: rule__ModelReference__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ModelReference__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelReference__Group__1"


    // $ANTLR start "rule__ModelReference__Group__1__Impl"
    // InternalExprParser.g:7531:1: rule__ModelReference__Group__1__Impl : ( ( rule__ModelReference__Group_1__0 )* ) ;
    public final void rule__ModelReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7535:1: ( ( ( rule__ModelReference__Group_1__0 )* ) )
            // InternalExprParser.g:7536:1: ( ( rule__ModelReference__Group_1__0 )* )
            {
            // InternalExprParser.g:7536:1: ( ( rule__ModelReference__Group_1__0 )* )
            // InternalExprParser.g:7537:1: ( rule__ModelReference__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelReferenceAccess().getGroup_1()); 
            }
            // InternalExprParser.g:7538:1: ( rule__ModelReference__Group_1__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==FullStop) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalExprParser.g:7538:2: rule__ModelReference__Group_1__0
            	    {
            	    pushFollow(FOLLOW_52);
            	    rule__ModelReference__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelReferenceAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelReference__Group__1__Impl"


    // $ANTLR start "rule__ModelReference__Group_1__0"
    // InternalExprParser.g:7552:1: rule__ModelReference__Group_1__0 : rule__ModelReference__Group_1__0__Impl rule__ModelReference__Group_1__1 ;
    public final void rule__ModelReference__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7556:1: ( rule__ModelReference__Group_1__0__Impl rule__ModelReference__Group_1__1 )
            // InternalExprParser.g:7557:2: rule__ModelReference__Group_1__0__Impl rule__ModelReference__Group_1__1
            {
            pushFollow(FOLLOW_51);
            rule__ModelReference__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ModelReference__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelReference__Group_1__0"


    // $ANTLR start "rule__ModelReference__Group_1__0__Impl"
    // InternalExprParser.g:7564:1: rule__ModelReference__Group_1__0__Impl : ( () ) ;
    public final void rule__ModelReference__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7568:1: ( ( () ) )
            // InternalExprParser.g:7569:1: ( () )
            {
            // InternalExprParser.g:7569:1: ( () )
            // InternalExprParser.g:7570:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelReferenceAccess().getModelReferencePrevAction_1_0()); 
            }
            // InternalExprParser.g:7571:1: ()
            // InternalExprParser.g:7573:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelReferenceAccess().getModelReferencePrevAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelReference__Group_1__0__Impl"


    // $ANTLR start "rule__ModelReference__Group_1__1"
    // InternalExprParser.g:7583:1: rule__ModelReference__Group_1__1 : rule__ModelReference__Group_1__1__Impl rule__ModelReference__Group_1__2 ;
    public final void rule__ModelReference__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7587:1: ( rule__ModelReference__Group_1__1__Impl rule__ModelReference__Group_1__2 )
            // InternalExprParser.g:7588:2: rule__ModelReference__Group_1__1__Impl rule__ModelReference__Group_1__2
            {
            pushFollow(FOLLOW_7);
            rule__ModelReference__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ModelReference__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelReference__Group_1__1"


    // $ANTLR start "rule__ModelReference__Group_1__1__Impl"
    // InternalExprParser.g:7595:1: rule__ModelReference__Group_1__1__Impl : ( FullStop ) ;
    public final void rule__ModelReference__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7599:1: ( ( FullStop ) )
            // InternalExprParser.g:7600:1: ( FullStop )
            {
            // InternalExprParser.g:7600:1: ( FullStop )
            // InternalExprParser.g:7601:1: FullStop
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelReferenceAccess().getFullStopKeyword_1_1()); 
            }
            match(input,FullStop,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelReferenceAccess().getFullStopKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelReference__Group_1__1__Impl"


    // $ANTLR start "rule__ModelReference__Group_1__2"
    // InternalExprParser.g:7614:1: rule__ModelReference__Group_1__2 : rule__ModelReference__Group_1__2__Impl ;
    public final void rule__ModelReference__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7618:1: ( rule__ModelReference__Group_1__2__Impl )
            // InternalExprParser.g:7619:2: rule__ModelReference__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ModelReference__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelReference__Group_1__2"


    // $ANTLR start "rule__ModelReference__Group_1__2__Impl"
    // InternalExprParser.g:7625:1: rule__ModelReference__Group_1__2__Impl : ( ( rule__ModelReference__ModelElementAssignment_1_2 ) ) ;
    public final void rule__ModelReference__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7629:1: ( ( ( rule__ModelReference__ModelElementAssignment_1_2 ) ) )
            // InternalExprParser.g:7630:1: ( ( rule__ModelReference__ModelElementAssignment_1_2 ) )
            {
            // InternalExprParser.g:7630:1: ( ( rule__ModelReference__ModelElementAssignment_1_2 ) )
            // InternalExprParser.g:7631:1: ( rule__ModelReference__ModelElementAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelReferenceAccess().getModelElementAssignment_1_2()); 
            }
            // InternalExprParser.g:7632:1: ( rule__ModelReference__ModelElementAssignment_1_2 )
            // InternalExprParser.g:7632:2: rule__ModelReference__ModelElementAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__ModelReference__ModelElementAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelReferenceAccess().getModelElementAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelReference__Group_1__2__Impl"


    // $ANTLR start "rule__PropertyReference__Group__0"
    // InternalExprParser.g:7648:1: rule__PropertyReference__Group__0 : rule__PropertyReference__Group__0__Impl rule__PropertyReference__Group__1 ;
    public final void rule__PropertyReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7652:1: ( rule__PropertyReference__Group__0__Impl rule__PropertyReference__Group__1 )
            // InternalExprParser.g:7653:2: rule__PropertyReference__Group__0__Impl rule__PropertyReference__Group__1
            {
            pushFollow(FOLLOW_53);
            rule__PropertyReference__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PropertyReference__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyReference__Group__0"


    // $ANTLR start "rule__PropertyReference__Group__0__Impl"
    // InternalExprParser.g:7660:1: rule__PropertyReference__Group__0__Impl : ( () ) ;
    public final void rule__PropertyReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7664:1: ( ( () ) )
            // InternalExprParser.g:7665:1: ( () )
            {
            // InternalExprParser.g:7665:1: ( () )
            // InternalExprParser.g:7666:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyReferenceAccess().getPropertyReferenceAction_0()); 
            }
            // InternalExprParser.g:7667:1: ()
            // InternalExprParser.g:7669:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPropertyReferenceAccess().getPropertyReferenceAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyReference__Group__0__Impl"


    // $ANTLR start "rule__PropertyReference__Group__1"
    // InternalExprParser.g:7679:1: rule__PropertyReference__Group__1 : rule__PropertyReference__Group__1__Impl rule__PropertyReference__Group__2 ;
    public final void rule__PropertyReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7683:1: ( rule__PropertyReference__Group__1__Impl rule__PropertyReference__Group__2 )
            // InternalExprParser.g:7684:2: rule__PropertyReference__Group__1__Impl rule__PropertyReference__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__PropertyReference__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PropertyReference__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyReference__Group__1"


    // $ANTLR start "rule__PropertyReference__Group__1__Impl"
    // InternalExprParser.g:7691:1: rule__PropertyReference__Group__1__Impl : ( NumberSign ) ;
    public final void rule__PropertyReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7695:1: ( ( NumberSign ) )
            // InternalExprParser.g:7696:1: ( NumberSign )
            {
            // InternalExprParser.g:7696:1: ( NumberSign )
            // InternalExprParser.g:7697:1: NumberSign
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyReferenceAccess().getNumberSignKeyword_1()); 
            }
            match(input,NumberSign,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPropertyReferenceAccess().getNumberSignKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyReference__Group__1__Impl"


    // $ANTLR start "rule__PropertyReference__Group__2"
    // InternalExprParser.g:7710:1: rule__PropertyReference__Group__2 : rule__PropertyReference__Group__2__Impl ;
    public final void rule__PropertyReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7714:1: ( rule__PropertyReference__Group__2__Impl )
            // InternalExprParser.g:7715:2: rule__PropertyReference__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PropertyReference__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyReference__Group__2"


    // $ANTLR start "rule__PropertyReference__Group__2__Impl"
    // InternalExprParser.g:7721:1: rule__PropertyReference__Group__2__Impl : ( ( rule__PropertyReference__PropertyAssignment_2 ) ) ;
    public final void rule__PropertyReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7725:1: ( ( ( rule__PropertyReference__PropertyAssignment_2 ) ) )
            // InternalExprParser.g:7726:1: ( ( rule__PropertyReference__PropertyAssignment_2 ) )
            {
            // InternalExprParser.g:7726:1: ( ( rule__PropertyReference__PropertyAssignment_2 ) )
            // InternalExprParser.g:7727:1: ( rule__PropertyReference__PropertyAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyReferenceAccess().getPropertyAssignment_2()); 
            }
            // InternalExprParser.g:7728:1: ( rule__PropertyReference__PropertyAssignment_2 )
            // InternalExprParser.g:7728:2: rule__PropertyReference__PropertyAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__PropertyReference__PropertyAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPropertyReferenceAccess().getPropertyAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyReference__Group__2__Impl"


    // $ANTLR start "rule__FunctionCall__Group__0"
    // InternalExprParser.g:7744:1: rule__FunctionCall__Group__0 : rule__FunctionCall__Group__0__Impl rule__FunctionCall__Group__1 ;
    public final void rule__FunctionCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7748:1: ( rule__FunctionCall__Group__0__Impl rule__FunctionCall__Group__1 )
            // InternalExprParser.g:7749:2: rule__FunctionCall__Group__0__Impl rule__FunctionCall__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__FunctionCall__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FunctionCall__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group__0"


    // $ANTLR start "rule__FunctionCall__Group__0__Impl"
    // InternalExprParser.g:7756:1: rule__FunctionCall__Group__0__Impl : ( () ) ;
    public final void rule__FunctionCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7760:1: ( ( () ) )
            // InternalExprParser.g:7761:1: ( () )
            {
            // InternalExprParser.g:7761:1: ( () )
            // InternalExprParser.g:7762:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionCallAccess().getFunctionCallAction_0()); 
            }
            // InternalExprParser.g:7763:1: ()
            // InternalExprParser.g:7765:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionCallAccess().getFunctionCallAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group__0__Impl"


    // $ANTLR start "rule__FunctionCall__Group__1"
    // InternalExprParser.g:7775:1: rule__FunctionCall__Group__1 : rule__FunctionCall__Group__1__Impl rule__FunctionCall__Group__2 ;
    public final void rule__FunctionCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7779:1: ( rule__FunctionCall__Group__1__Impl rule__FunctionCall__Group__2 )
            // InternalExprParser.g:7780:2: rule__FunctionCall__Group__1__Impl rule__FunctionCall__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__FunctionCall__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FunctionCall__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group__1"


    // $ANTLR start "rule__FunctionCall__Group__1__Impl"
    // InternalExprParser.g:7787:1: rule__FunctionCall__Group__1__Impl : ( ( rule__FunctionCall__FunctionAssignment_1 ) ) ;
    public final void rule__FunctionCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7791:1: ( ( ( rule__FunctionCall__FunctionAssignment_1 ) ) )
            // InternalExprParser.g:7792:1: ( ( rule__FunctionCall__FunctionAssignment_1 ) )
            {
            // InternalExprParser.g:7792:1: ( ( rule__FunctionCall__FunctionAssignment_1 ) )
            // InternalExprParser.g:7793:1: ( rule__FunctionCall__FunctionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionCallAccess().getFunctionAssignment_1()); 
            }
            // InternalExprParser.g:7794:1: ( rule__FunctionCall__FunctionAssignment_1 )
            // InternalExprParser.g:7794:2: rule__FunctionCall__FunctionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__FunctionCall__FunctionAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionCallAccess().getFunctionAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group__1__Impl"


    // $ANTLR start "rule__FunctionCall__Group__2"
    // InternalExprParser.g:7804:1: rule__FunctionCall__Group__2 : rule__FunctionCall__Group__2__Impl rule__FunctionCall__Group__3 ;
    public final void rule__FunctionCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7808:1: ( rule__FunctionCall__Group__2__Impl rule__FunctionCall__Group__3 )
            // InternalExprParser.g:7809:2: rule__FunctionCall__Group__2__Impl rule__FunctionCall__Group__3
            {
            pushFollow(FOLLOW_54);
            rule__FunctionCall__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FunctionCall__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group__2"


    // $ANTLR start "rule__FunctionCall__Group__2__Impl"
    // InternalExprParser.g:7816:1: rule__FunctionCall__Group__2__Impl : ( LeftParenthesis ) ;
    public final void rule__FunctionCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7820:1: ( ( LeftParenthesis ) )
            // InternalExprParser.g:7821:1: ( LeftParenthesis )
            {
            // InternalExprParser.g:7821:1: ( LeftParenthesis )
            // InternalExprParser.g:7822:1: LeftParenthesis
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,LeftParenthesis,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group__2__Impl"


    // $ANTLR start "rule__FunctionCall__Group__3"
    // InternalExprParser.g:7835:1: rule__FunctionCall__Group__3 : rule__FunctionCall__Group__3__Impl rule__FunctionCall__Group__4 ;
    public final void rule__FunctionCall__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7839:1: ( rule__FunctionCall__Group__3__Impl rule__FunctionCall__Group__4 )
            // InternalExprParser.g:7840:2: rule__FunctionCall__Group__3__Impl rule__FunctionCall__Group__4
            {
            pushFollow(FOLLOW_54);
            rule__FunctionCall__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FunctionCall__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group__3"


    // $ANTLR start "rule__FunctionCall__Group__3__Impl"
    // InternalExprParser.g:7847:1: rule__FunctionCall__Group__3__Impl : ( ( rule__FunctionCall__Group_3__0 )? ) ;
    public final void rule__FunctionCall__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7851:1: ( ( ( rule__FunctionCall__Group_3__0 )? ) )
            // InternalExprParser.g:7852:1: ( ( rule__FunctionCall__Group_3__0 )? )
            {
            // InternalExprParser.g:7852:1: ( ( rule__FunctionCall__Group_3__0 )? )
            // InternalExprParser.g:7853:1: ( rule__FunctionCall__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionCallAccess().getGroup_3()); 
            }
            // InternalExprParser.g:7854:1: ( rule__FunctionCall__Group_3__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==Record||LA40_0==False||(LA40_0>=Tuple && LA40_0<=Union)||LA40_0==List||(LA40_0>=This && LA40_0<=True)||LA40_0==Bag||LA40_0==Map||(LA40_0>=Not && LA40_0<=Set)||LA40_0==If||LA40_0==NumberSign||LA40_0==LeftParenthesis||LA40_0==PlusSign||LA40_0==HyphenMinus||LA40_0==LeftSquareBracket||LA40_0==RULE_REAL_LIT||LA40_0==RULE_INTEGER_LIT||(LA40_0>=RULE_STRING && LA40_0<=RULE_ID)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalExprParser.g:7854:2: rule__FunctionCall__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__FunctionCall__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionCallAccess().getGroup_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group__3__Impl"


    // $ANTLR start "rule__FunctionCall__Group__4"
    // InternalExprParser.g:7864:1: rule__FunctionCall__Group__4 : rule__FunctionCall__Group__4__Impl ;
    public final void rule__FunctionCall__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7868:1: ( rule__FunctionCall__Group__4__Impl )
            // InternalExprParser.g:7869:2: rule__FunctionCall__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FunctionCall__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group__4"


    // $ANTLR start "rule__FunctionCall__Group__4__Impl"
    // InternalExprParser.g:7875:1: rule__FunctionCall__Group__4__Impl : ( RightParenthesis ) ;
    public final void rule__FunctionCall__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7879:1: ( ( RightParenthesis ) )
            // InternalExprParser.g:7880:1: ( RightParenthesis )
            {
            // InternalExprParser.g:7880:1: ( RightParenthesis )
            // InternalExprParser.g:7881:1: RightParenthesis
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionCallAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,RightParenthesis,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionCallAccess().getRightParenthesisKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group__4__Impl"


    // $ANTLR start "rule__FunctionCall__Group_3__0"
    // InternalExprParser.g:7904:1: rule__FunctionCall__Group_3__0 : rule__FunctionCall__Group_3__0__Impl rule__FunctionCall__Group_3__1 ;
    public final void rule__FunctionCall__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7908:1: ( rule__FunctionCall__Group_3__0__Impl rule__FunctionCall__Group_3__1 )
            // InternalExprParser.g:7909:2: rule__FunctionCall__Group_3__0__Impl rule__FunctionCall__Group_3__1
            {
            pushFollow(FOLLOW_55);
            rule__FunctionCall__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FunctionCall__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group_3__0"


    // $ANTLR start "rule__FunctionCall__Group_3__0__Impl"
    // InternalExprParser.g:7916:1: rule__FunctionCall__Group_3__0__Impl : ( ( rule__FunctionCall__ArgumentsAssignment_3_0 ) ) ;
    public final void rule__FunctionCall__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7920:1: ( ( ( rule__FunctionCall__ArgumentsAssignment_3_0 ) ) )
            // InternalExprParser.g:7921:1: ( ( rule__FunctionCall__ArgumentsAssignment_3_0 ) )
            {
            // InternalExprParser.g:7921:1: ( ( rule__FunctionCall__ArgumentsAssignment_3_0 ) )
            // InternalExprParser.g:7922:1: ( rule__FunctionCall__ArgumentsAssignment_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionCallAccess().getArgumentsAssignment_3_0()); 
            }
            // InternalExprParser.g:7923:1: ( rule__FunctionCall__ArgumentsAssignment_3_0 )
            // InternalExprParser.g:7923:2: rule__FunctionCall__ArgumentsAssignment_3_0
            {
            pushFollow(FOLLOW_2);
            rule__FunctionCall__ArgumentsAssignment_3_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionCallAccess().getArgumentsAssignment_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group_3__0__Impl"


    // $ANTLR start "rule__FunctionCall__Group_3__1"
    // InternalExprParser.g:7933:1: rule__FunctionCall__Group_3__1 : rule__FunctionCall__Group_3__1__Impl ;
    public final void rule__FunctionCall__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7937:1: ( rule__FunctionCall__Group_3__1__Impl )
            // InternalExprParser.g:7938:2: rule__FunctionCall__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FunctionCall__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group_3__1"


    // $ANTLR start "rule__FunctionCall__Group_3__1__Impl"
    // InternalExprParser.g:7944:1: rule__FunctionCall__Group_3__1__Impl : ( ( rule__FunctionCall__Group_3_1__0 )* ) ;
    public final void rule__FunctionCall__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7948:1: ( ( ( rule__FunctionCall__Group_3_1__0 )* ) )
            // InternalExprParser.g:7949:1: ( ( rule__FunctionCall__Group_3_1__0 )* )
            {
            // InternalExprParser.g:7949:1: ( ( rule__FunctionCall__Group_3_1__0 )* )
            // InternalExprParser.g:7950:1: ( rule__FunctionCall__Group_3_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionCallAccess().getGroup_3_1()); 
            }
            // InternalExprParser.g:7951:1: ( rule__FunctionCall__Group_3_1__0 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==Comma) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalExprParser.g:7951:2: rule__FunctionCall__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_56);
            	    rule__FunctionCall__Group_3_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionCallAccess().getGroup_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group_3__1__Impl"


    // $ANTLR start "rule__FunctionCall__Group_3_1__0"
    // InternalExprParser.g:7965:1: rule__FunctionCall__Group_3_1__0 : rule__FunctionCall__Group_3_1__0__Impl rule__FunctionCall__Group_3_1__1 ;
    public final void rule__FunctionCall__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7969:1: ( rule__FunctionCall__Group_3_1__0__Impl rule__FunctionCall__Group_3_1__1 )
            // InternalExprParser.g:7970:2: rule__FunctionCall__Group_3_1__0__Impl rule__FunctionCall__Group_3_1__1
            {
            pushFollow(FOLLOW_12);
            rule__FunctionCall__Group_3_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FunctionCall__Group_3_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group_3_1__0"


    // $ANTLR start "rule__FunctionCall__Group_3_1__0__Impl"
    // InternalExprParser.g:7977:1: rule__FunctionCall__Group_3_1__0__Impl : ( Comma ) ;
    public final void rule__FunctionCall__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7981:1: ( ( Comma ) )
            // InternalExprParser.g:7982:1: ( Comma )
            {
            // InternalExprParser.g:7982:1: ( Comma )
            // InternalExprParser.g:7983:1: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionCallAccess().getCommaKeyword_3_1_0()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionCallAccess().getCommaKeyword_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group_3_1__0__Impl"


    // $ANTLR start "rule__FunctionCall__Group_3_1__1"
    // InternalExprParser.g:7996:1: rule__FunctionCall__Group_3_1__1 : rule__FunctionCall__Group_3_1__1__Impl ;
    public final void rule__FunctionCall__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8000:1: ( rule__FunctionCall__Group_3_1__1__Impl )
            // InternalExprParser.g:8001:2: rule__FunctionCall__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FunctionCall__Group_3_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group_3_1__1"


    // $ANTLR start "rule__FunctionCall__Group_3_1__1__Impl"
    // InternalExprParser.g:8007:1: rule__FunctionCall__Group_3_1__1__Impl : ( ( rule__FunctionCall__ArgumentsAssignment_3_1_1 ) ) ;
    public final void rule__FunctionCall__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8011:1: ( ( ( rule__FunctionCall__ArgumentsAssignment_3_1_1 ) ) )
            // InternalExprParser.g:8012:1: ( ( rule__FunctionCall__ArgumentsAssignment_3_1_1 ) )
            {
            // InternalExprParser.g:8012:1: ( ( rule__FunctionCall__ArgumentsAssignment_3_1_1 ) )
            // InternalExprParser.g:8013:1: ( rule__FunctionCall__ArgumentsAssignment_3_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionCallAccess().getArgumentsAssignment_3_1_1()); 
            }
            // InternalExprParser.g:8014:1: ( rule__FunctionCall__ArgumentsAssignment_3_1_1 )
            // InternalExprParser.g:8014:2: rule__FunctionCall__ArgumentsAssignment_3_1_1
            {
            pushFollow(FOLLOW_2);
            rule__FunctionCall__ArgumentsAssignment_3_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionCallAccess().getArgumentsAssignment_3_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group_3_1__1__Impl"


    // $ANTLR start "rule__RangeExpression__Group__0"
    // InternalExprParser.g:8028:1: rule__RangeExpression__Group__0 : rule__RangeExpression__Group__0__Impl rule__RangeExpression__Group__1 ;
    public final void rule__RangeExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8032:1: ( rule__RangeExpression__Group__0__Impl rule__RangeExpression__Group__1 )
            // InternalExprParser.g:8033:2: rule__RangeExpression__Group__0__Impl rule__RangeExpression__Group__1
            {
            pushFollow(FOLLOW_57);
            rule__RangeExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RangeExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeExpression__Group__0"


    // $ANTLR start "rule__RangeExpression__Group__0__Impl"
    // InternalExprParser.g:8040:1: rule__RangeExpression__Group__0__Impl : ( () ) ;
    public final void rule__RangeExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8044:1: ( ( () ) )
            // InternalExprParser.g:8045:1: ( () )
            {
            // InternalExprParser.g:8045:1: ( () )
            // InternalExprParser.g:8046:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeExpressionAccess().getRangeAction_0()); 
            }
            // InternalExprParser.g:8047:1: ()
            // InternalExprParser.g:8049:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeExpressionAccess().getRangeAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeExpression__Group__0__Impl"


    // $ANTLR start "rule__RangeExpression__Group__1"
    // InternalExprParser.g:8059:1: rule__RangeExpression__Group__1 : rule__RangeExpression__Group__1__Impl rule__RangeExpression__Group__2 ;
    public final void rule__RangeExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8063:1: ( rule__RangeExpression__Group__1__Impl rule__RangeExpression__Group__2 )
            // InternalExprParser.g:8064:2: rule__RangeExpression__Group__1__Impl rule__RangeExpression__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__RangeExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RangeExpression__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeExpression__Group__1"


    // $ANTLR start "rule__RangeExpression__Group__1__Impl"
    // InternalExprParser.g:8071:1: rule__RangeExpression__Group__1__Impl : ( LeftSquareBracket ) ;
    public final void rule__RangeExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8075:1: ( ( LeftSquareBracket ) )
            // InternalExprParser.g:8076:1: ( LeftSquareBracket )
            {
            // InternalExprParser.g:8076:1: ( LeftSquareBracket )
            // InternalExprParser.g:8077:1: LeftSquareBracket
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeExpressionAccess().getLeftSquareBracketKeyword_1()); 
            }
            match(input,LeftSquareBracket,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeExpressionAccess().getLeftSquareBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeExpression__Group__1__Impl"


    // $ANTLR start "rule__RangeExpression__Group__2"
    // InternalExprParser.g:8090:1: rule__RangeExpression__Group__2 : rule__RangeExpression__Group__2__Impl rule__RangeExpression__Group__3 ;
    public final void rule__RangeExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8094:1: ( rule__RangeExpression__Group__2__Impl rule__RangeExpression__Group__3 )
            // InternalExprParser.g:8095:2: rule__RangeExpression__Group__2__Impl rule__RangeExpression__Group__3
            {
            pushFollow(FOLLOW_58);
            rule__RangeExpression__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RangeExpression__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeExpression__Group__2"


    // $ANTLR start "rule__RangeExpression__Group__2__Impl"
    // InternalExprParser.g:8102:1: rule__RangeExpression__Group__2__Impl : ( ( rule__RangeExpression__MinimumAssignment_2 ) ) ;
    public final void rule__RangeExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8106:1: ( ( ( rule__RangeExpression__MinimumAssignment_2 ) ) )
            // InternalExprParser.g:8107:1: ( ( rule__RangeExpression__MinimumAssignment_2 ) )
            {
            // InternalExprParser.g:8107:1: ( ( rule__RangeExpression__MinimumAssignment_2 ) )
            // InternalExprParser.g:8108:1: ( rule__RangeExpression__MinimumAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeExpressionAccess().getMinimumAssignment_2()); 
            }
            // InternalExprParser.g:8109:1: ( rule__RangeExpression__MinimumAssignment_2 )
            // InternalExprParser.g:8109:2: rule__RangeExpression__MinimumAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__RangeExpression__MinimumAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeExpressionAccess().getMinimumAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeExpression__Group__2__Impl"


    // $ANTLR start "rule__RangeExpression__Group__3"
    // InternalExprParser.g:8119:1: rule__RangeExpression__Group__3 : rule__RangeExpression__Group__3__Impl rule__RangeExpression__Group__4 ;
    public final void rule__RangeExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8123:1: ( rule__RangeExpression__Group__3__Impl rule__RangeExpression__Group__4 )
            // InternalExprParser.g:8124:2: rule__RangeExpression__Group__3__Impl rule__RangeExpression__Group__4
            {
            pushFollow(FOLLOW_12);
            rule__RangeExpression__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RangeExpression__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeExpression__Group__3"


    // $ANTLR start "rule__RangeExpression__Group__3__Impl"
    // InternalExprParser.g:8131:1: rule__RangeExpression__Group__3__Impl : ( FullStopFullStop ) ;
    public final void rule__RangeExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8135:1: ( ( FullStopFullStop ) )
            // InternalExprParser.g:8136:1: ( FullStopFullStop )
            {
            // InternalExprParser.g:8136:1: ( FullStopFullStop )
            // InternalExprParser.g:8137:1: FullStopFullStop
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeExpressionAccess().getFullStopFullStopKeyword_3()); 
            }
            match(input,FullStopFullStop,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeExpressionAccess().getFullStopFullStopKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeExpression__Group__3__Impl"


    // $ANTLR start "rule__RangeExpression__Group__4"
    // InternalExprParser.g:8150:1: rule__RangeExpression__Group__4 : rule__RangeExpression__Group__4__Impl rule__RangeExpression__Group__5 ;
    public final void rule__RangeExpression__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8154:1: ( rule__RangeExpression__Group__4__Impl rule__RangeExpression__Group__5 )
            // InternalExprParser.g:8155:2: rule__RangeExpression__Group__4__Impl rule__RangeExpression__Group__5
            {
            pushFollow(FOLLOW_59);
            rule__RangeExpression__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RangeExpression__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeExpression__Group__4"


    // $ANTLR start "rule__RangeExpression__Group__4__Impl"
    // InternalExprParser.g:8162:1: rule__RangeExpression__Group__4__Impl : ( ( rule__RangeExpression__MaximumAssignment_4 ) ) ;
    public final void rule__RangeExpression__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8166:1: ( ( ( rule__RangeExpression__MaximumAssignment_4 ) ) )
            // InternalExprParser.g:8167:1: ( ( rule__RangeExpression__MaximumAssignment_4 ) )
            {
            // InternalExprParser.g:8167:1: ( ( rule__RangeExpression__MaximumAssignment_4 ) )
            // InternalExprParser.g:8168:1: ( rule__RangeExpression__MaximumAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeExpressionAccess().getMaximumAssignment_4()); 
            }
            // InternalExprParser.g:8169:1: ( rule__RangeExpression__MaximumAssignment_4 )
            // InternalExprParser.g:8169:2: rule__RangeExpression__MaximumAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__RangeExpression__MaximumAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeExpressionAccess().getMaximumAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeExpression__Group__4__Impl"


    // $ANTLR start "rule__RangeExpression__Group__5"
    // InternalExprParser.g:8179:1: rule__RangeExpression__Group__5 : rule__RangeExpression__Group__5__Impl rule__RangeExpression__Group__6 ;
    public final void rule__RangeExpression__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8183:1: ( rule__RangeExpression__Group__5__Impl rule__RangeExpression__Group__6 )
            // InternalExprParser.g:8184:2: rule__RangeExpression__Group__5__Impl rule__RangeExpression__Group__6
            {
            pushFollow(FOLLOW_59);
            rule__RangeExpression__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RangeExpression__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeExpression__Group__5"


    // $ANTLR start "rule__RangeExpression__Group__5__Impl"
    // InternalExprParser.g:8191:1: rule__RangeExpression__Group__5__Impl : ( ( rule__RangeExpression__Group_5__0 )? ) ;
    public final void rule__RangeExpression__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8195:1: ( ( ( rule__RangeExpression__Group_5__0 )? ) )
            // InternalExprParser.g:8196:1: ( ( rule__RangeExpression__Group_5__0 )? )
            {
            // InternalExprParser.g:8196:1: ( ( rule__RangeExpression__Group_5__0 )? )
            // InternalExprParser.g:8197:1: ( rule__RangeExpression__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeExpressionAccess().getGroup_5()); 
            }
            // InternalExprParser.g:8198:1: ( rule__RangeExpression__Group_5__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==Delta) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalExprParser.g:8198:2: rule__RangeExpression__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RangeExpression__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeExpressionAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeExpression__Group__5__Impl"


    // $ANTLR start "rule__RangeExpression__Group__6"
    // InternalExprParser.g:8208:1: rule__RangeExpression__Group__6 : rule__RangeExpression__Group__6__Impl ;
    public final void rule__RangeExpression__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8212:1: ( rule__RangeExpression__Group__6__Impl )
            // InternalExprParser.g:8213:2: rule__RangeExpression__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RangeExpression__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeExpression__Group__6"


    // $ANTLR start "rule__RangeExpression__Group__6__Impl"
    // InternalExprParser.g:8219:1: rule__RangeExpression__Group__6__Impl : ( RightSquareBracket ) ;
    public final void rule__RangeExpression__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8223:1: ( ( RightSquareBracket ) )
            // InternalExprParser.g:8224:1: ( RightSquareBracket )
            {
            // InternalExprParser.g:8224:1: ( RightSquareBracket )
            // InternalExprParser.g:8225:1: RightSquareBracket
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeExpressionAccess().getRightSquareBracketKeyword_6()); 
            }
            match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeExpressionAccess().getRightSquareBracketKeyword_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeExpression__Group__6__Impl"


    // $ANTLR start "rule__RangeExpression__Group_5__0"
    // InternalExprParser.g:8252:1: rule__RangeExpression__Group_5__0 : rule__RangeExpression__Group_5__0__Impl rule__RangeExpression__Group_5__1 ;
    public final void rule__RangeExpression__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8256:1: ( rule__RangeExpression__Group_5__0__Impl rule__RangeExpression__Group_5__1 )
            // InternalExprParser.g:8257:2: rule__RangeExpression__Group_5__0__Impl rule__RangeExpression__Group_5__1
            {
            pushFollow(FOLLOW_12);
            rule__RangeExpression__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RangeExpression__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeExpression__Group_5__0"


    // $ANTLR start "rule__RangeExpression__Group_5__0__Impl"
    // InternalExprParser.g:8264:1: rule__RangeExpression__Group_5__0__Impl : ( ( Delta ) ) ;
    public final void rule__RangeExpression__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8268:1: ( ( ( Delta ) ) )
            // InternalExprParser.g:8269:1: ( ( Delta ) )
            {
            // InternalExprParser.g:8269:1: ( ( Delta ) )
            // InternalExprParser.g:8270:1: ( Delta )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeExpressionAccess().getDeltaKeyword_5_0()); 
            }
            // InternalExprParser.g:8271:1: ( Delta )
            // InternalExprParser.g:8272:2: Delta
            {
            match(input,Delta,FOLLOW_2); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeExpressionAccess().getDeltaKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeExpression__Group_5__0__Impl"


    // $ANTLR start "rule__RangeExpression__Group_5__1"
    // InternalExprParser.g:8283:1: rule__RangeExpression__Group_5__1 : rule__RangeExpression__Group_5__1__Impl ;
    public final void rule__RangeExpression__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8287:1: ( rule__RangeExpression__Group_5__1__Impl )
            // InternalExprParser.g:8288:2: rule__RangeExpression__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RangeExpression__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeExpression__Group_5__1"


    // $ANTLR start "rule__RangeExpression__Group_5__1__Impl"
    // InternalExprParser.g:8294:1: rule__RangeExpression__Group_5__1__Impl : ( ( rule__RangeExpression__DeltaAssignment_5_1 ) ) ;
    public final void rule__RangeExpression__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8298:1: ( ( ( rule__RangeExpression__DeltaAssignment_5_1 ) ) )
            // InternalExprParser.g:8299:1: ( ( rule__RangeExpression__DeltaAssignment_5_1 ) )
            {
            // InternalExprParser.g:8299:1: ( ( rule__RangeExpression__DeltaAssignment_5_1 ) )
            // InternalExprParser.g:8300:1: ( rule__RangeExpression__DeltaAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeExpressionAccess().getDeltaAssignment_5_1()); 
            }
            // InternalExprParser.g:8301:1: ( rule__RangeExpression__DeltaAssignment_5_1 )
            // InternalExprParser.g:8301:2: rule__RangeExpression__DeltaAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__RangeExpression__DeltaAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeExpressionAccess().getDeltaAssignment_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeExpression__Group_5__1__Impl"


    // $ANTLR start "rule__IfExpression__Group__0"
    // InternalExprParser.g:8315:1: rule__IfExpression__Group__0 : rule__IfExpression__Group__0__Impl rule__IfExpression__Group__1 ;
    public final void rule__IfExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8319:1: ( rule__IfExpression__Group__0__Impl rule__IfExpression__Group__1 )
            // InternalExprParser.g:8320:2: rule__IfExpression__Group__0__Impl rule__IfExpression__Group__1
            {
            pushFollow(FOLLOW_60);
            rule__IfExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IfExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group__0"


    // $ANTLR start "rule__IfExpression__Group__0__Impl"
    // InternalExprParser.g:8327:1: rule__IfExpression__Group__0__Impl : ( () ) ;
    public final void rule__IfExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8331:1: ( ( () ) )
            // InternalExprParser.g:8332:1: ( () )
            {
            // InternalExprParser.g:8332:1: ( () )
            // InternalExprParser.g:8333:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfExpressionAccess().getConditionalAction_0()); 
            }
            // InternalExprParser.g:8334:1: ()
            // InternalExprParser.g:8336:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfExpressionAccess().getConditionalAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group__0__Impl"


    // $ANTLR start "rule__IfExpression__Group__1"
    // InternalExprParser.g:8346:1: rule__IfExpression__Group__1 : rule__IfExpression__Group__1__Impl rule__IfExpression__Group__2 ;
    public final void rule__IfExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8350:1: ( rule__IfExpression__Group__1__Impl rule__IfExpression__Group__2 )
            // InternalExprParser.g:8351:2: rule__IfExpression__Group__1__Impl rule__IfExpression__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__IfExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IfExpression__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group__1"


    // $ANTLR start "rule__IfExpression__Group__1__Impl"
    // InternalExprParser.g:8358:1: rule__IfExpression__Group__1__Impl : ( If ) ;
    public final void rule__IfExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8362:1: ( ( If ) )
            // InternalExprParser.g:8363:1: ( If )
            {
            // InternalExprParser.g:8363:1: ( If )
            // InternalExprParser.g:8364:1: If
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfExpressionAccess().getIfKeyword_1()); 
            }
            match(input,If,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfExpressionAccess().getIfKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group__1__Impl"


    // $ANTLR start "rule__IfExpression__Group__2"
    // InternalExprParser.g:8377:1: rule__IfExpression__Group__2 : rule__IfExpression__Group__2__Impl rule__IfExpression__Group__3 ;
    public final void rule__IfExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8381:1: ( rule__IfExpression__Group__2__Impl rule__IfExpression__Group__3 )
            // InternalExprParser.g:8382:2: rule__IfExpression__Group__2__Impl rule__IfExpression__Group__3
            {
            pushFollow(FOLLOW_61);
            rule__IfExpression__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IfExpression__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group__2"


    // $ANTLR start "rule__IfExpression__Group__2__Impl"
    // InternalExprParser.g:8389:1: rule__IfExpression__Group__2__Impl : ( ( rule__IfExpression__IfAssignment_2 ) ) ;
    public final void rule__IfExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8393:1: ( ( ( rule__IfExpression__IfAssignment_2 ) ) )
            // InternalExprParser.g:8394:1: ( ( rule__IfExpression__IfAssignment_2 ) )
            {
            // InternalExprParser.g:8394:1: ( ( rule__IfExpression__IfAssignment_2 ) )
            // InternalExprParser.g:8395:1: ( rule__IfExpression__IfAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfExpressionAccess().getIfAssignment_2()); 
            }
            // InternalExprParser.g:8396:1: ( rule__IfExpression__IfAssignment_2 )
            // InternalExprParser.g:8396:2: rule__IfExpression__IfAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__IfExpression__IfAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfExpressionAccess().getIfAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group__2__Impl"


    // $ANTLR start "rule__IfExpression__Group__3"
    // InternalExprParser.g:8406:1: rule__IfExpression__Group__3 : rule__IfExpression__Group__3__Impl rule__IfExpression__Group__4 ;
    public final void rule__IfExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8410:1: ( rule__IfExpression__Group__3__Impl rule__IfExpression__Group__4 )
            // InternalExprParser.g:8411:2: rule__IfExpression__Group__3__Impl rule__IfExpression__Group__4
            {
            pushFollow(FOLLOW_12);
            rule__IfExpression__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IfExpression__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group__3"


    // $ANTLR start "rule__IfExpression__Group__3__Impl"
    // InternalExprParser.g:8418:1: rule__IfExpression__Group__3__Impl : ( Then ) ;
    public final void rule__IfExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8422:1: ( ( Then ) )
            // InternalExprParser.g:8423:1: ( Then )
            {
            // InternalExprParser.g:8423:1: ( Then )
            // InternalExprParser.g:8424:1: Then
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfExpressionAccess().getThenKeyword_3()); 
            }
            match(input,Then,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfExpressionAccess().getThenKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group__3__Impl"


    // $ANTLR start "rule__IfExpression__Group__4"
    // InternalExprParser.g:8437:1: rule__IfExpression__Group__4 : rule__IfExpression__Group__4__Impl rule__IfExpression__Group__5 ;
    public final void rule__IfExpression__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8441:1: ( rule__IfExpression__Group__4__Impl rule__IfExpression__Group__5 )
            // InternalExprParser.g:8442:2: rule__IfExpression__Group__4__Impl rule__IfExpression__Group__5
            {
            pushFollow(FOLLOW_62);
            rule__IfExpression__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IfExpression__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group__4"


    // $ANTLR start "rule__IfExpression__Group__4__Impl"
    // InternalExprParser.g:8449:1: rule__IfExpression__Group__4__Impl : ( ( rule__IfExpression__ThenAssignment_4 ) ) ;
    public final void rule__IfExpression__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8453:1: ( ( ( rule__IfExpression__ThenAssignment_4 ) ) )
            // InternalExprParser.g:8454:1: ( ( rule__IfExpression__ThenAssignment_4 ) )
            {
            // InternalExprParser.g:8454:1: ( ( rule__IfExpression__ThenAssignment_4 ) )
            // InternalExprParser.g:8455:1: ( rule__IfExpression__ThenAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfExpressionAccess().getThenAssignment_4()); 
            }
            // InternalExprParser.g:8456:1: ( rule__IfExpression__ThenAssignment_4 )
            // InternalExprParser.g:8456:2: rule__IfExpression__ThenAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__IfExpression__ThenAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfExpressionAccess().getThenAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group__4__Impl"


    // $ANTLR start "rule__IfExpression__Group__5"
    // InternalExprParser.g:8466:1: rule__IfExpression__Group__5 : rule__IfExpression__Group__5__Impl rule__IfExpression__Group__6 ;
    public final void rule__IfExpression__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8470:1: ( rule__IfExpression__Group__5__Impl rule__IfExpression__Group__6 )
            // InternalExprParser.g:8471:2: rule__IfExpression__Group__5__Impl rule__IfExpression__Group__6
            {
            pushFollow(FOLLOW_62);
            rule__IfExpression__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IfExpression__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group__5"


    // $ANTLR start "rule__IfExpression__Group__5__Impl"
    // InternalExprParser.g:8478:1: rule__IfExpression__Group__5__Impl : ( ( rule__IfExpression__Group_5__0 )? ) ;
    public final void rule__IfExpression__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8482:1: ( ( ( rule__IfExpression__Group_5__0 )? ) )
            // InternalExprParser.g:8483:1: ( ( rule__IfExpression__Group_5__0 )? )
            {
            // InternalExprParser.g:8483:1: ( ( rule__IfExpression__Group_5__0 )? )
            // InternalExprParser.g:8484:1: ( rule__IfExpression__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfExpressionAccess().getGroup_5()); 
            }
            // InternalExprParser.g:8485:1: ( rule__IfExpression__Group_5__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==Else) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalExprParser.g:8485:2: rule__IfExpression__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__IfExpression__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfExpressionAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group__5__Impl"


    // $ANTLR start "rule__IfExpression__Group__6"
    // InternalExprParser.g:8495:1: rule__IfExpression__Group__6 : rule__IfExpression__Group__6__Impl ;
    public final void rule__IfExpression__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8499:1: ( rule__IfExpression__Group__6__Impl )
            // InternalExprParser.g:8500:2: rule__IfExpression__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IfExpression__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group__6"


    // $ANTLR start "rule__IfExpression__Group__6__Impl"
    // InternalExprParser.g:8506:1: rule__IfExpression__Group__6__Impl : ( Endif ) ;
    public final void rule__IfExpression__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8510:1: ( ( Endif ) )
            // InternalExprParser.g:8511:1: ( Endif )
            {
            // InternalExprParser.g:8511:1: ( Endif )
            // InternalExprParser.g:8512:1: Endif
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfExpressionAccess().getEndifKeyword_6()); 
            }
            match(input,Endif,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfExpressionAccess().getEndifKeyword_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group__6__Impl"


    // $ANTLR start "rule__IfExpression__Group_5__0"
    // InternalExprParser.g:8539:1: rule__IfExpression__Group_5__0 : rule__IfExpression__Group_5__0__Impl rule__IfExpression__Group_5__1 ;
    public final void rule__IfExpression__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8543:1: ( rule__IfExpression__Group_5__0__Impl rule__IfExpression__Group_5__1 )
            // InternalExprParser.g:8544:2: rule__IfExpression__Group_5__0__Impl rule__IfExpression__Group_5__1
            {
            pushFollow(FOLLOW_12);
            rule__IfExpression__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IfExpression__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group_5__0"


    // $ANTLR start "rule__IfExpression__Group_5__0__Impl"
    // InternalExprParser.g:8551:1: rule__IfExpression__Group_5__0__Impl : ( Else ) ;
    public final void rule__IfExpression__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8555:1: ( ( Else ) )
            // InternalExprParser.g:8556:1: ( Else )
            {
            // InternalExprParser.g:8556:1: ( Else )
            // InternalExprParser.g:8557:1: Else
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfExpressionAccess().getElseKeyword_5_0()); 
            }
            match(input,Else,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfExpressionAccess().getElseKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group_5__0__Impl"


    // $ANTLR start "rule__IfExpression__Group_5__1"
    // InternalExprParser.g:8570:1: rule__IfExpression__Group_5__1 : rule__IfExpression__Group_5__1__Impl ;
    public final void rule__IfExpression__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8574:1: ( rule__IfExpression__Group_5__1__Impl )
            // InternalExprParser.g:8575:2: rule__IfExpression__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IfExpression__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group_5__1"


    // $ANTLR start "rule__IfExpression__Group_5__1__Impl"
    // InternalExprParser.g:8581:1: rule__IfExpression__Group_5__1__Impl : ( ( rule__IfExpression__ElseAssignment_5_1 ) ) ;
    public final void rule__IfExpression__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8585:1: ( ( ( rule__IfExpression__ElseAssignment_5_1 ) ) )
            // InternalExprParser.g:8586:1: ( ( rule__IfExpression__ElseAssignment_5_1 ) )
            {
            // InternalExprParser.g:8586:1: ( ( rule__IfExpression__ElseAssignment_5_1 ) )
            // InternalExprParser.g:8587:1: ( rule__IfExpression__ElseAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfExpressionAccess().getElseAssignment_5_1()); 
            }
            // InternalExprParser.g:8588:1: ( rule__IfExpression__ElseAssignment_5_1 )
            // InternalExprParser.g:8588:2: rule__IfExpression__ElseAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__IfExpression__ElseAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfExpressionAccess().getElseAssignment_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group_5__1__Impl"


    // $ANTLR start "rule__BooleanLiteral__Group__0"
    // InternalExprParser.g:8602:1: rule__BooleanLiteral__Group__0 : rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 ;
    public final void rule__BooleanLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8606:1: ( rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 )
            // InternalExprParser.g:8607:2: rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1
            {
            pushFollow(FOLLOW_63);
            rule__BooleanLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BooleanLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteral__Group__0"


    // $ANTLR start "rule__BooleanLiteral__Group__0__Impl"
    // InternalExprParser.g:8614:1: rule__BooleanLiteral__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8618:1: ( ( () ) )
            // InternalExprParser.g:8619:1: ( () )
            {
            // InternalExprParser.g:8619:1: ( () )
            // InternalExprParser.g:8620:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); 
            }
            // InternalExprParser.g:8621:1: ()
            // InternalExprParser.g:8623:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteral__Group__0__Impl"


    // $ANTLR start "rule__BooleanLiteral__Group__1"
    // InternalExprParser.g:8633:1: rule__BooleanLiteral__Group__1 : rule__BooleanLiteral__Group__1__Impl ;
    public final void rule__BooleanLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8637:1: ( rule__BooleanLiteral__Group__1__Impl )
            // InternalExprParser.g:8638:2: rule__BooleanLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BooleanLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteral__Group__1"


    // $ANTLR start "rule__BooleanLiteral__Group__1__Impl"
    // InternalExprParser.g:8644:1: rule__BooleanLiteral__Group__1__Impl : ( ( rule__BooleanLiteral__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8648:1: ( ( ( rule__BooleanLiteral__Alternatives_1 ) ) )
            // InternalExprParser.g:8649:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            {
            // InternalExprParser.g:8649:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            // InternalExprParser.g:8650:1: ( rule__BooleanLiteral__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); 
            }
            // InternalExprParser.g:8651:1: ( rule__BooleanLiteral__Alternatives_1 )
            // InternalExprParser.g:8651:2: rule__BooleanLiteral__Alternatives_1
            {
            pushFollow(FOLLOW_2);
            rule__BooleanLiteral__Alternatives_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteral__Group__1__Impl"


    // $ANTLR start "rule__IntegerLiteral__Group__0"
    // InternalExprParser.g:8665:1: rule__IntegerLiteral__Group__0 : rule__IntegerLiteral__Group__0__Impl rule__IntegerLiteral__Group__1 ;
    public final void rule__IntegerLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8669:1: ( rule__IntegerLiteral__Group__0__Impl rule__IntegerLiteral__Group__1 )
            // InternalExprParser.g:8670:2: rule__IntegerLiteral__Group__0__Impl rule__IntegerLiteral__Group__1
            {
            pushFollow(FOLLOW_64);
            rule__IntegerLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IntegerLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegerLiteral__Group__0"


    // $ANTLR start "rule__IntegerLiteral__Group__0__Impl"
    // InternalExprParser.g:8677:1: rule__IntegerLiteral__Group__0__Impl : ( () ) ;
    public final void rule__IntegerLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8681:1: ( ( () ) )
            // InternalExprParser.g:8682:1: ( () )
            {
            // InternalExprParser.g:8682:1: ( () )
            // InternalExprParser.g:8683:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralAccess().getIntegerLiteralAction_0()); 
            }
            // InternalExprParser.g:8684:1: ()
            // InternalExprParser.g:8686:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegerLiteralAccess().getIntegerLiteralAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegerLiteral__Group__0__Impl"


    // $ANTLR start "rule__IntegerLiteral__Group__1"
    // InternalExprParser.g:8696:1: rule__IntegerLiteral__Group__1 : rule__IntegerLiteral__Group__1__Impl ;
    public final void rule__IntegerLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8700:1: ( rule__IntegerLiteral__Group__1__Impl )
            // InternalExprParser.g:8701:2: rule__IntegerLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IntegerLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegerLiteral__Group__1"


    // $ANTLR start "rule__IntegerLiteral__Group__1__Impl"
    // InternalExprParser.g:8707:1: rule__IntegerLiteral__Group__1__Impl : ( ( rule__IntegerLiteral__ValueAssignment_1 ) ) ;
    public final void rule__IntegerLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8711:1: ( ( ( rule__IntegerLiteral__ValueAssignment_1 ) ) )
            // InternalExprParser.g:8712:1: ( ( rule__IntegerLiteral__ValueAssignment_1 ) )
            {
            // InternalExprParser.g:8712:1: ( ( rule__IntegerLiteral__ValueAssignment_1 ) )
            // InternalExprParser.g:8713:1: ( rule__IntegerLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralAccess().getValueAssignment_1()); 
            }
            // InternalExprParser.g:8714:1: ( rule__IntegerLiteral__ValueAssignment_1 )
            // InternalExprParser.g:8714:2: rule__IntegerLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__IntegerLiteral__ValueAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegerLiteralAccess().getValueAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegerLiteral__Group__1__Impl"


    // $ANTLR start "rule__RealLiteral__Group__0"
    // InternalExprParser.g:8728:1: rule__RealLiteral__Group__0 : rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 ;
    public final void rule__RealLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8732:1: ( rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 )
            // InternalExprParser.g:8733:2: rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1
            {
            pushFollow(FOLLOW_65);
            rule__RealLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RealLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteral__Group__0"


    // $ANTLR start "rule__RealLiteral__Group__0__Impl"
    // InternalExprParser.g:8740:1: rule__RealLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RealLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8744:1: ( ( () ) )
            // InternalExprParser.g:8745:1: ( () )
            {
            // InternalExprParser.g:8745:1: ( () )
            // InternalExprParser.g:8746:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 
            }
            // InternalExprParser.g:8747:1: ()
            // InternalExprParser.g:8749:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteral__Group__0__Impl"


    // $ANTLR start "rule__RealLiteral__Group__1"
    // InternalExprParser.g:8759:1: rule__RealLiteral__Group__1 : rule__RealLiteral__Group__1__Impl ;
    public final void rule__RealLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8763:1: ( rule__RealLiteral__Group__1__Impl )
            // InternalExprParser.g:8764:2: rule__RealLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RealLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteral__Group__1"


    // $ANTLR start "rule__RealLiteral__Group__1__Impl"
    // InternalExprParser.g:8770:1: rule__RealLiteral__Group__1__Impl : ( ( rule__RealLiteral__ValueAssignment_1 ) ) ;
    public final void rule__RealLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8774:1: ( ( ( rule__RealLiteral__ValueAssignment_1 ) ) )
            // InternalExprParser.g:8775:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            {
            // InternalExprParser.g:8775:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            // InternalExprParser.g:8776:1: ( rule__RealLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 
            }
            // InternalExprParser.g:8777:1: ( rule__RealLiteral__ValueAssignment_1 )
            // InternalExprParser.g:8777:2: rule__RealLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__RealLiteral__ValueAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteral__Group__1__Impl"


    // $ANTLR start "rule__StringLiteral__Group__0"
    // InternalExprParser.g:8791:1: rule__StringLiteral__Group__0 : rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 ;
    public final void rule__StringLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8795:1: ( rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 )
            // InternalExprParser.g:8796:2: rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1
            {
            pushFollow(FOLLOW_66);
            rule__StringLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__StringLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__Group__0"


    // $ANTLR start "rule__StringLiteral__Group__0__Impl"
    // InternalExprParser.g:8803:1: rule__StringLiteral__Group__0__Impl : ( () ) ;
    public final void rule__StringLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8807:1: ( ( () ) )
            // InternalExprParser.g:8808:1: ( () )
            {
            // InternalExprParser.g:8808:1: ( () )
            // InternalExprParser.g:8809:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            }
            // InternalExprParser.g:8810:1: ()
            // InternalExprParser.g:8812:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__Group__0__Impl"


    // $ANTLR start "rule__StringLiteral__Group__1"
    // InternalExprParser.g:8822:1: rule__StringLiteral__Group__1 : rule__StringLiteral__Group__1__Impl ;
    public final void rule__StringLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8826:1: ( rule__StringLiteral__Group__1__Impl )
            // InternalExprParser.g:8827:2: rule__StringLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__StringLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__Group__1"


    // $ANTLR start "rule__StringLiteral__Group__1__Impl"
    // InternalExprParser.g:8833:1: rule__StringLiteral__Group__1__Impl : ( ( rule__StringLiteral__ValueAssignment_1 ) ) ;
    public final void rule__StringLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8837:1: ( ( ( rule__StringLiteral__ValueAssignment_1 ) ) )
            // InternalExprParser.g:8838:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            {
            // InternalExprParser.g:8838:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            // InternalExprParser.g:8839:1: ( rule__StringLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            }
            // InternalExprParser.g:8840:1: ( rule__StringLiteral__ValueAssignment_1 )
            // InternalExprParser.g:8840:2: rule__StringLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__StringLiteral__ValueAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__Group__1__Impl"


    // $ANTLR start "rule__CommaSeparatedExpressions__Group__0"
    // InternalExprParser.g:8854:1: rule__CommaSeparatedExpressions__Group__0 : rule__CommaSeparatedExpressions__Group__0__Impl rule__CommaSeparatedExpressions__Group__1 ;
    public final void rule__CommaSeparatedExpressions__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8858:1: ( rule__CommaSeparatedExpressions__Group__0__Impl rule__CommaSeparatedExpressions__Group__1 )
            // InternalExprParser.g:8859:2: rule__CommaSeparatedExpressions__Group__0__Impl rule__CommaSeparatedExpressions__Group__1
            {
            pushFollow(FOLLOW_55);
            rule__CommaSeparatedExpressions__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CommaSeparatedExpressions__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CommaSeparatedExpressions__Group__0"


    // $ANTLR start "rule__CommaSeparatedExpressions__Group__0__Impl"
    // InternalExprParser.g:8866:1: rule__CommaSeparatedExpressions__Group__0__Impl : ( ( rule__CommaSeparatedExpressions__ElementsAssignment_0 ) ) ;
    public final void rule__CommaSeparatedExpressions__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8870:1: ( ( ( rule__CommaSeparatedExpressions__ElementsAssignment_0 ) ) )
            // InternalExprParser.g:8871:1: ( ( rule__CommaSeparatedExpressions__ElementsAssignment_0 ) )
            {
            // InternalExprParser.g:8871:1: ( ( rule__CommaSeparatedExpressions__ElementsAssignment_0 ) )
            // InternalExprParser.g:8872:1: ( rule__CommaSeparatedExpressions__ElementsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCommaSeparatedExpressionsAccess().getElementsAssignment_0()); 
            }
            // InternalExprParser.g:8873:1: ( rule__CommaSeparatedExpressions__ElementsAssignment_0 )
            // InternalExprParser.g:8873:2: rule__CommaSeparatedExpressions__ElementsAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__CommaSeparatedExpressions__ElementsAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCommaSeparatedExpressionsAccess().getElementsAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CommaSeparatedExpressions__Group__0__Impl"


    // $ANTLR start "rule__CommaSeparatedExpressions__Group__1"
    // InternalExprParser.g:8883:1: rule__CommaSeparatedExpressions__Group__1 : rule__CommaSeparatedExpressions__Group__1__Impl ;
    public final void rule__CommaSeparatedExpressions__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8887:1: ( rule__CommaSeparatedExpressions__Group__1__Impl )
            // InternalExprParser.g:8888:2: rule__CommaSeparatedExpressions__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CommaSeparatedExpressions__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CommaSeparatedExpressions__Group__1"


    // $ANTLR start "rule__CommaSeparatedExpressions__Group__1__Impl"
    // InternalExprParser.g:8894:1: rule__CommaSeparatedExpressions__Group__1__Impl : ( ( rule__CommaSeparatedExpressions__Group_1__0 )* ) ;
    public final void rule__CommaSeparatedExpressions__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8898:1: ( ( ( rule__CommaSeparatedExpressions__Group_1__0 )* ) )
            // InternalExprParser.g:8899:1: ( ( rule__CommaSeparatedExpressions__Group_1__0 )* )
            {
            // InternalExprParser.g:8899:1: ( ( rule__CommaSeparatedExpressions__Group_1__0 )* )
            // InternalExprParser.g:8900:1: ( rule__CommaSeparatedExpressions__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCommaSeparatedExpressionsAccess().getGroup_1()); 
            }
            // InternalExprParser.g:8901:1: ( rule__CommaSeparatedExpressions__Group_1__0 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==Comma) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalExprParser.g:8901:2: rule__CommaSeparatedExpressions__Group_1__0
            	    {
            	    pushFollow(FOLLOW_56);
            	    rule__CommaSeparatedExpressions__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCommaSeparatedExpressionsAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CommaSeparatedExpressions__Group__1__Impl"


    // $ANTLR start "rule__CommaSeparatedExpressions__Group_1__0"
    // InternalExprParser.g:8915:1: rule__CommaSeparatedExpressions__Group_1__0 : rule__CommaSeparatedExpressions__Group_1__0__Impl rule__CommaSeparatedExpressions__Group_1__1 ;
    public final void rule__CommaSeparatedExpressions__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8919:1: ( rule__CommaSeparatedExpressions__Group_1__0__Impl rule__CommaSeparatedExpressions__Group_1__1 )
            // InternalExprParser.g:8920:2: rule__CommaSeparatedExpressions__Group_1__0__Impl rule__CommaSeparatedExpressions__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__CommaSeparatedExpressions__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CommaSeparatedExpressions__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CommaSeparatedExpressions__Group_1__0"


    // $ANTLR start "rule__CommaSeparatedExpressions__Group_1__0__Impl"
    // InternalExprParser.g:8927:1: rule__CommaSeparatedExpressions__Group_1__0__Impl : ( Comma ) ;
    public final void rule__CommaSeparatedExpressions__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8931:1: ( ( Comma ) )
            // InternalExprParser.g:8932:1: ( Comma )
            {
            // InternalExprParser.g:8932:1: ( Comma )
            // InternalExprParser.g:8933:1: Comma
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCommaSeparatedExpressionsAccess().getCommaKeyword_1_0()); 
            }
            match(input,Comma,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCommaSeparatedExpressionsAccess().getCommaKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CommaSeparatedExpressions__Group_1__0__Impl"


    // $ANTLR start "rule__CommaSeparatedExpressions__Group_1__1"
    // InternalExprParser.g:8946:1: rule__CommaSeparatedExpressions__Group_1__1 : rule__CommaSeparatedExpressions__Group_1__1__Impl ;
    public final void rule__CommaSeparatedExpressions__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8950:1: ( rule__CommaSeparatedExpressions__Group_1__1__Impl )
            // InternalExprParser.g:8951:2: rule__CommaSeparatedExpressions__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CommaSeparatedExpressions__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CommaSeparatedExpressions__Group_1__1"


    // $ANTLR start "rule__CommaSeparatedExpressions__Group_1__1__Impl"
    // InternalExprParser.g:8957:1: rule__CommaSeparatedExpressions__Group_1__1__Impl : ( ( rule__CommaSeparatedExpressions__ElementsAssignment_1_1 ) ) ;
    public final void rule__CommaSeparatedExpressions__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8961:1: ( ( ( rule__CommaSeparatedExpressions__ElementsAssignment_1_1 ) ) )
            // InternalExprParser.g:8962:1: ( ( rule__CommaSeparatedExpressions__ElementsAssignment_1_1 ) )
            {
            // InternalExprParser.g:8962:1: ( ( rule__CommaSeparatedExpressions__ElementsAssignment_1_1 ) )
            // InternalExprParser.g:8963:1: ( rule__CommaSeparatedExpressions__ElementsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCommaSeparatedExpressionsAccess().getElementsAssignment_1_1()); 
            }
            // InternalExprParser.g:8964:1: ( rule__CommaSeparatedExpressions__ElementsAssignment_1_1 )
            // InternalExprParser.g:8964:2: rule__CommaSeparatedExpressions__ElementsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__CommaSeparatedExpressions__ElementsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCommaSeparatedExpressionsAccess().getElementsAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CommaSeparatedExpressions__Group_1__1__Impl"


    // $ANTLR start "rule__ListLiteral__Group__0"
    // InternalExprParser.g:8978:1: rule__ListLiteral__Group__0 : rule__ListLiteral__Group__0__Impl rule__ListLiteral__Group__1 ;
    public final void rule__ListLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8982:1: ( rule__ListLiteral__Group__0__Impl rule__ListLiteral__Group__1 )
            // InternalExprParser.g:8983:2: rule__ListLiteral__Group__0__Impl rule__ListLiteral__Group__1
            {
            pushFollow(FOLLOW_33);
            rule__ListLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ListLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListLiteral__Group__0"


    // $ANTLR start "rule__ListLiteral__Group__0__Impl"
    // InternalExprParser.g:8990:1: rule__ListLiteral__Group__0__Impl : ( () ) ;
    public final void rule__ListLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8994:1: ( ( () ) )
            // InternalExprParser.g:8995:1: ( () )
            {
            // InternalExprParser.g:8995:1: ( () )
            // InternalExprParser.g:8996:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListLiteralAccess().getListLiteralAction_0()); 
            }
            // InternalExprParser.g:8997:1: ()
            // InternalExprParser.g:8999:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getListLiteralAccess().getListLiteralAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListLiteral__Group__0__Impl"


    // $ANTLR start "rule__ListLiteral__Group__1"
    // InternalExprParser.g:9009:1: rule__ListLiteral__Group__1 : rule__ListLiteral__Group__1__Impl rule__ListLiteral__Group__2 ;
    public final void rule__ListLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9013:1: ( rule__ListLiteral__Group__1__Impl rule__ListLiteral__Group__2 )
            // InternalExprParser.g:9014:2: rule__ListLiteral__Group__1__Impl rule__ListLiteral__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__ListLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ListLiteral__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListLiteral__Group__1"


    // $ANTLR start "rule__ListLiteral__Group__1__Impl"
    // InternalExprParser.g:9021:1: rule__ListLiteral__Group__1__Impl : ( List ) ;
    public final void rule__ListLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9025:1: ( ( List ) )
            // InternalExprParser.g:9026:1: ( List )
            {
            // InternalExprParser.g:9026:1: ( List )
            // InternalExprParser.g:9027:1: List
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListLiteralAccess().getListKeyword_1()); 
            }
            match(input,List,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getListLiteralAccess().getListKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListLiteral__Group__1__Impl"


    // $ANTLR start "rule__ListLiteral__Group__2"
    // InternalExprParser.g:9040:1: rule__ListLiteral__Group__2 : rule__ListLiteral__Group__2__Impl rule__ListLiteral__Group__3 ;
    public final void rule__ListLiteral__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9044:1: ( rule__ListLiteral__Group__2__Impl rule__ListLiteral__Group__3 )
            // InternalExprParser.g:9045:2: rule__ListLiteral__Group__2__Impl rule__ListLiteral__Group__3
            {
            pushFollow(FOLLOW_54);
            rule__ListLiteral__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ListLiteral__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListLiteral__Group__2"


    // $ANTLR start "rule__ListLiteral__Group__2__Impl"
    // InternalExprParser.g:9052:1: rule__ListLiteral__Group__2__Impl : ( LeftParenthesis ) ;
    public final void rule__ListLiteral__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9056:1: ( ( LeftParenthesis ) )
            // InternalExprParser.g:9057:1: ( LeftParenthesis )
            {
            // InternalExprParser.g:9057:1: ( LeftParenthesis )
            // InternalExprParser.g:9058:1: LeftParenthesis
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListLiteralAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,LeftParenthesis,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getListLiteralAccess().getLeftParenthesisKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListLiteral__Group__2__Impl"


    // $ANTLR start "rule__ListLiteral__Group__3"
    // InternalExprParser.g:9071:1: rule__ListLiteral__Group__3 : rule__ListLiteral__Group__3__Impl rule__ListLiteral__Group__4 ;
    public final void rule__ListLiteral__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9075:1: ( rule__ListLiteral__Group__3__Impl rule__ListLiteral__Group__4 )
            // InternalExprParser.g:9076:2: rule__ListLiteral__Group__3__Impl rule__ListLiteral__Group__4
            {
            pushFollow(FOLLOW_54);
            rule__ListLiteral__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ListLiteral__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListLiteral__Group__3"


    // $ANTLR start "rule__ListLiteral__Group__3__Impl"
    // InternalExprParser.g:9083:1: rule__ListLiteral__Group__3__Impl : ( ( ruleCommaSeparatedExpressions )? ) ;
    public final void rule__ListLiteral__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9087:1: ( ( ( ruleCommaSeparatedExpressions )? ) )
            // InternalExprParser.g:9088:1: ( ( ruleCommaSeparatedExpressions )? )
            {
            // InternalExprParser.g:9088:1: ( ( ruleCommaSeparatedExpressions )? )
            // InternalExprParser.g:9089:1: ( ruleCommaSeparatedExpressions )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListLiteralAccess().getCommaSeparatedExpressionsParserRuleCall_3()); 
            }
            // InternalExprParser.g:9090:1: ( ruleCommaSeparatedExpressions )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==Record||LA45_0==False||(LA45_0>=Tuple && LA45_0<=Union)||LA45_0==List||(LA45_0>=This && LA45_0<=True)||LA45_0==Bag||LA45_0==Map||(LA45_0>=Not && LA45_0<=Set)||LA45_0==If||LA45_0==NumberSign||LA45_0==LeftParenthesis||LA45_0==PlusSign||LA45_0==HyphenMinus||LA45_0==LeftSquareBracket||LA45_0==RULE_REAL_LIT||LA45_0==RULE_INTEGER_LIT||(LA45_0>=RULE_STRING && LA45_0<=RULE_ID)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalExprParser.g:9090:3: ruleCommaSeparatedExpressions
                    {
                    pushFollow(FOLLOW_2);
                    ruleCommaSeparatedExpressions();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getListLiteralAccess().getCommaSeparatedExpressionsParserRuleCall_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListLiteral__Group__3__Impl"


    // $ANTLR start "rule__ListLiteral__Group__4"
    // InternalExprParser.g:9100:1: rule__ListLiteral__Group__4 : rule__ListLiteral__Group__4__Impl ;
    public final void rule__ListLiteral__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9104:1: ( rule__ListLiteral__Group__4__Impl )
            // InternalExprParser.g:9105:2: rule__ListLiteral__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ListLiteral__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListLiteral__Group__4"


    // $ANTLR start "rule__ListLiteral__Group__4__Impl"
    // InternalExprParser.g:9111:1: rule__ListLiteral__Group__4__Impl : ( RightParenthesis ) ;
    public final void rule__ListLiteral__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9115:1: ( ( RightParenthesis ) )
            // InternalExprParser.g:9116:1: ( RightParenthesis )
            {
            // InternalExprParser.g:9116:1: ( RightParenthesis )
            // InternalExprParser.g:9117:1: RightParenthesis
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListLiteralAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,RightParenthesis,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getListLiteralAccess().getRightParenthesisKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListLiteral__Group__4__Impl"


    // $ANTLR start "rule__SetLiteral__Group__0"
    // InternalExprParser.g:9140:1: rule__SetLiteral__Group__0 : rule__SetLiteral__Group__0__Impl rule__SetLiteral__Group__1 ;
    public final void rule__SetLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9144:1: ( rule__SetLiteral__Group__0__Impl rule__SetLiteral__Group__1 )
            // InternalExprParser.g:9145:2: rule__SetLiteral__Group__0__Impl rule__SetLiteral__Group__1
            {
            pushFollow(FOLLOW_67);
            rule__SetLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SetLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetLiteral__Group__0"


    // $ANTLR start "rule__SetLiteral__Group__0__Impl"
    // InternalExprParser.g:9152:1: rule__SetLiteral__Group__0__Impl : ( () ) ;
    public final void rule__SetLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9156:1: ( ( () ) )
            // InternalExprParser.g:9157:1: ( () )
            {
            // InternalExprParser.g:9157:1: ( () )
            // InternalExprParser.g:9158:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSetLiteralAccess().getSetLiteralAction_0()); 
            }
            // InternalExprParser.g:9159:1: ()
            // InternalExprParser.g:9161:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSetLiteralAccess().getSetLiteralAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetLiteral__Group__0__Impl"


    // $ANTLR start "rule__SetLiteral__Group__1"
    // InternalExprParser.g:9171:1: rule__SetLiteral__Group__1 : rule__SetLiteral__Group__1__Impl rule__SetLiteral__Group__2 ;
    public final void rule__SetLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9175:1: ( rule__SetLiteral__Group__1__Impl rule__SetLiteral__Group__2 )
            // InternalExprParser.g:9176:2: rule__SetLiteral__Group__1__Impl rule__SetLiteral__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__SetLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SetLiteral__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetLiteral__Group__1"


    // $ANTLR start "rule__SetLiteral__Group__1__Impl"
    // InternalExprParser.g:9183:1: rule__SetLiteral__Group__1__Impl : ( Set ) ;
    public final void rule__SetLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9187:1: ( ( Set ) )
            // InternalExprParser.g:9188:1: ( Set )
            {
            // InternalExprParser.g:9188:1: ( Set )
            // InternalExprParser.g:9189:1: Set
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSetLiteralAccess().getSetKeyword_1()); 
            }
            match(input,Set,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSetLiteralAccess().getSetKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetLiteral__Group__1__Impl"


    // $ANTLR start "rule__SetLiteral__Group__2"
    // InternalExprParser.g:9202:1: rule__SetLiteral__Group__2 : rule__SetLiteral__Group__2__Impl rule__SetLiteral__Group__3 ;
    public final void rule__SetLiteral__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9206:1: ( rule__SetLiteral__Group__2__Impl rule__SetLiteral__Group__3 )
            // InternalExprParser.g:9207:2: rule__SetLiteral__Group__2__Impl rule__SetLiteral__Group__3
            {
            pushFollow(FOLLOW_54);
            rule__SetLiteral__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SetLiteral__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetLiteral__Group__2"


    // $ANTLR start "rule__SetLiteral__Group__2__Impl"
    // InternalExprParser.g:9214:1: rule__SetLiteral__Group__2__Impl : ( LeftParenthesis ) ;
    public final void rule__SetLiteral__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9218:1: ( ( LeftParenthesis ) )
            // InternalExprParser.g:9219:1: ( LeftParenthesis )
            {
            // InternalExprParser.g:9219:1: ( LeftParenthesis )
            // InternalExprParser.g:9220:1: LeftParenthesis
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSetLiteralAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,LeftParenthesis,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSetLiteralAccess().getLeftParenthesisKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetLiteral__Group__2__Impl"


    // $ANTLR start "rule__SetLiteral__Group__3"
    // InternalExprParser.g:9233:1: rule__SetLiteral__Group__3 : rule__SetLiteral__Group__3__Impl rule__SetLiteral__Group__4 ;
    public final void rule__SetLiteral__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9237:1: ( rule__SetLiteral__Group__3__Impl rule__SetLiteral__Group__4 )
            // InternalExprParser.g:9238:2: rule__SetLiteral__Group__3__Impl rule__SetLiteral__Group__4
            {
            pushFollow(FOLLOW_54);
            rule__SetLiteral__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SetLiteral__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetLiteral__Group__3"


    // $ANTLR start "rule__SetLiteral__Group__3__Impl"
    // InternalExprParser.g:9245:1: rule__SetLiteral__Group__3__Impl : ( ( ruleCommaSeparatedExpressions )? ) ;
    public final void rule__SetLiteral__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9249:1: ( ( ( ruleCommaSeparatedExpressions )? ) )
            // InternalExprParser.g:9250:1: ( ( ruleCommaSeparatedExpressions )? )
            {
            // InternalExprParser.g:9250:1: ( ( ruleCommaSeparatedExpressions )? )
            // InternalExprParser.g:9251:1: ( ruleCommaSeparatedExpressions )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSetLiteralAccess().getCommaSeparatedExpressionsParserRuleCall_3()); 
            }
            // InternalExprParser.g:9252:1: ( ruleCommaSeparatedExpressions )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==Record||LA46_0==False||(LA46_0>=Tuple && LA46_0<=Union)||LA46_0==List||(LA46_0>=This && LA46_0<=True)||LA46_0==Bag||LA46_0==Map||(LA46_0>=Not && LA46_0<=Set)||LA46_0==If||LA46_0==NumberSign||LA46_0==LeftParenthesis||LA46_0==PlusSign||LA46_0==HyphenMinus||LA46_0==LeftSquareBracket||LA46_0==RULE_REAL_LIT||LA46_0==RULE_INTEGER_LIT||(LA46_0>=RULE_STRING && LA46_0<=RULE_ID)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalExprParser.g:9252:3: ruleCommaSeparatedExpressions
                    {
                    pushFollow(FOLLOW_2);
                    ruleCommaSeparatedExpressions();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSetLiteralAccess().getCommaSeparatedExpressionsParserRuleCall_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetLiteral__Group__3__Impl"


    // $ANTLR start "rule__SetLiteral__Group__4"
    // InternalExprParser.g:9262:1: rule__SetLiteral__Group__4 : rule__SetLiteral__Group__4__Impl ;
    public final void rule__SetLiteral__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9266:1: ( rule__SetLiteral__Group__4__Impl )
            // InternalExprParser.g:9267:2: rule__SetLiteral__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SetLiteral__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetLiteral__Group__4"


    // $ANTLR start "rule__SetLiteral__Group__4__Impl"
    // InternalExprParser.g:9273:1: rule__SetLiteral__Group__4__Impl : ( RightParenthesis ) ;
    public final void rule__SetLiteral__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9277:1: ( ( RightParenthesis ) )
            // InternalExprParser.g:9278:1: ( RightParenthesis )
            {
            // InternalExprParser.g:9278:1: ( RightParenthesis )
            // InternalExprParser.g:9279:1: RightParenthesis
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSetLiteralAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,RightParenthesis,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSetLiteralAccess().getRightParenthesisKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetLiteral__Group__4__Impl"


    // $ANTLR start "rule__RecordLiteral__Group__0"
    // InternalExprParser.g:9302:1: rule__RecordLiteral__Group__0 : rule__RecordLiteral__Group__0__Impl rule__RecordLiteral__Group__1 ;
    public final void rule__RecordLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9306:1: ( rule__RecordLiteral__Group__0__Impl rule__RecordLiteral__Group__1 )
            // InternalExprParser.g:9307:2: rule__RecordLiteral__Group__0__Impl rule__RecordLiteral__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__RecordLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RecordLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecordLiteral__Group__0"


    // $ANTLR start "rule__RecordLiteral__Group__0__Impl"
    // InternalExprParser.g:9314:1: rule__RecordLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RecordLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9318:1: ( ( () ) )
            // InternalExprParser.g:9319:1: ( () )
            {
            // InternalExprParser.g:9319:1: ( () )
            // InternalExprParser.g:9320:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecordLiteralAccess().getRecordLiteralAction_0()); 
            }
            // InternalExprParser.g:9321:1: ()
            // InternalExprParser.g:9323:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecordLiteralAccess().getRecordLiteralAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecordLiteral__Group__0__Impl"


    // $ANTLR start "rule__RecordLiteral__Group__1"
    // InternalExprParser.g:9333:1: rule__RecordLiteral__Group__1 : rule__RecordLiteral__Group__1__Impl ;
    public final void rule__RecordLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9337:1: ( rule__RecordLiteral__Group__1__Impl )
            // InternalExprParser.g:9338:2: rule__RecordLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RecordLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecordLiteral__Group__1"


    // $ANTLR start "rule__RecordLiteral__Group__1__Impl"
    // InternalExprParser.g:9344:1: rule__RecordLiteral__Group__1__Impl : ( Record ) ;
    public final void rule__RecordLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9348:1: ( ( Record ) )
            // InternalExprParser.g:9349:1: ( Record )
            {
            // InternalExprParser.g:9349:1: ( Record )
            // InternalExprParser.g:9350:1: Record
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecordLiteralAccess().getRecordKeyword_1()); 
            }
            match(input,Record,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecordLiteralAccess().getRecordKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecordLiteral__Group__1__Impl"


    // $ANTLR start "rule__UnionLiteral__Group__0"
    // InternalExprParser.g:9367:1: rule__UnionLiteral__Group__0 : rule__UnionLiteral__Group__0__Impl rule__UnionLiteral__Group__1 ;
    public final void rule__UnionLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9371:1: ( rule__UnionLiteral__Group__0__Impl rule__UnionLiteral__Group__1 )
            // InternalExprParser.g:9372:2: rule__UnionLiteral__Group__0__Impl rule__UnionLiteral__Group__1
            {
            pushFollow(FOLLOW_27);
            rule__UnionLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UnionLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnionLiteral__Group__0"


    // $ANTLR start "rule__UnionLiteral__Group__0__Impl"
    // InternalExprParser.g:9379:1: rule__UnionLiteral__Group__0__Impl : ( () ) ;
    public final void rule__UnionLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9383:1: ( ( () ) )
            // InternalExprParser.g:9384:1: ( () )
            {
            // InternalExprParser.g:9384:1: ( () )
            // InternalExprParser.g:9385:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnionLiteralAccess().getUnionLiteralAction_0()); 
            }
            // InternalExprParser.g:9386:1: ()
            // InternalExprParser.g:9388:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnionLiteralAccess().getUnionLiteralAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnionLiteral__Group__0__Impl"


    // $ANTLR start "rule__UnionLiteral__Group__1"
    // InternalExprParser.g:9398:1: rule__UnionLiteral__Group__1 : rule__UnionLiteral__Group__1__Impl ;
    public final void rule__UnionLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9402:1: ( rule__UnionLiteral__Group__1__Impl )
            // InternalExprParser.g:9403:2: rule__UnionLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UnionLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnionLiteral__Group__1"


    // $ANTLR start "rule__UnionLiteral__Group__1__Impl"
    // InternalExprParser.g:9409:1: rule__UnionLiteral__Group__1__Impl : ( Union ) ;
    public final void rule__UnionLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9413:1: ( ( Union ) )
            // InternalExprParser.g:9414:1: ( Union )
            {
            // InternalExprParser.g:9414:1: ( Union )
            // InternalExprParser.g:9415:1: Union
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnionLiteralAccess().getUnionKeyword_1()); 
            }
            match(input,Union,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnionLiteralAccess().getUnionKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnionLiteral__Group__1__Impl"


    // $ANTLR start "rule__TupleLiteral__Group__0"
    // InternalExprParser.g:9432:1: rule__TupleLiteral__Group__0 : rule__TupleLiteral__Group__0__Impl rule__TupleLiteral__Group__1 ;
    public final void rule__TupleLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9436:1: ( rule__TupleLiteral__Group__0__Impl rule__TupleLiteral__Group__1 )
            // InternalExprParser.g:9437:2: rule__TupleLiteral__Group__0__Impl rule__TupleLiteral__Group__1
            {
            pushFollow(FOLLOW_30);
            rule__TupleLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TupleLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleLiteral__Group__0"


    // $ANTLR start "rule__TupleLiteral__Group__0__Impl"
    // InternalExprParser.g:9444:1: rule__TupleLiteral__Group__0__Impl : ( () ) ;
    public final void rule__TupleLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9448:1: ( ( () ) )
            // InternalExprParser.g:9449:1: ( () )
            {
            // InternalExprParser.g:9449:1: ( () )
            // InternalExprParser.g:9450:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleLiteralAccess().getTupleLiteralAction_0()); 
            }
            // InternalExprParser.g:9451:1: ()
            // InternalExprParser.g:9453:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTupleLiteralAccess().getTupleLiteralAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleLiteral__Group__0__Impl"


    // $ANTLR start "rule__TupleLiteral__Group__1"
    // InternalExprParser.g:9463:1: rule__TupleLiteral__Group__1 : rule__TupleLiteral__Group__1__Impl rule__TupleLiteral__Group__2 ;
    public final void rule__TupleLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9467:1: ( rule__TupleLiteral__Group__1__Impl rule__TupleLiteral__Group__2 )
            // InternalExprParser.g:9468:2: rule__TupleLiteral__Group__1__Impl rule__TupleLiteral__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__TupleLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TupleLiteral__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleLiteral__Group__1"


    // $ANTLR start "rule__TupleLiteral__Group__1__Impl"
    // InternalExprParser.g:9475:1: rule__TupleLiteral__Group__1__Impl : ( Tuple ) ;
    public final void rule__TupleLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9479:1: ( ( Tuple ) )
            // InternalExprParser.g:9480:1: ( Tuple )
            {
            // InternalExprParser.g:9480:1: ( Tuple )
            // InternalExprParser.g:9481:1: Tuple
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleLiteralAccess().getTupleKeyword_1()); 
            }
            match(input,Tuple,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTupleLiteralAccess().getTupleKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleLiteral__Group__1__Impl"


    // $ANTLR start "rule__TupleLiteral__Group__2"
    // InternalExprParser.g:9494:1: rule__TupleLiteral__Group__2 : rule__TupleLiteral__Group__2__Impl rule__TupleLiteral__Group__3 ;
    public final void rule__TupleLiteral__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9498:1: ( rule__TupleLiteral__Group__2__Impl rule__TupleLiteral__Group__3 )
            // InternalExprParser.g:9499:2: rule__TupleLiteral__Group__2__Impl rule__TupleLiteral__Group__3
            {
            pushFollow(FOLLOW_54);
            rule__TupleLiteral__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TupleLiteral__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleLiteral__Group__2"


    // $ANTLR start "rule__TupleLiteral__Group__2__Impl"
    // InternalExprParser.g:9506:1: rule__TupleLiteral__Group__2__Impl : ( LeftParenthesis ) ;
    public final void rule__TupleLiteral__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9510:1: ( ( LeftParenthesis ) )
            // InternalExprParser.g:9511:1: ( LeftParenthesis )
            {
            // InternalExprParser.g:9511:1: ( LeftParenthesis )
            // InternalExprParser.g:9512:1: LeftParenthesis
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleLiteralAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,LeftParenthesis,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTupleLiteralAccess().getLeftParenthesisKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleLiteral__Group__2__Impl"


    // $ANTLR start "rule__TupleLiteral__Group__3"
    // InternalExprParser.g:9525:1: rule__TupleLiteral__Group__3 : rule__TupleLiteral__Group__3__Impl rule__TupleLiteral__Group__4 ;
    public final void rule__TupleLiteral__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9529:1: ( rule__TupleLiteral__Group__3__Impl rule__TupleLiteral__Group__4 )
            // InternalExprParser.g:9530:2: rule__TupleLiteral__Group__3__Impl rule__TupleLiteral__Group__4
            {
            pushFollow(FOLLOW_54);
            rule__TupleLiteral__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TupleLiteral__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleLiteral__Group__3"


    // $ANTLR start "rule__TupleLiteral__Group__3__Impl"
    // InternalExprParser.g:9537:1: rule__TupleLiteral__Group__3__Impl : ( ( ruleCommaSeparatedExpressions )? ) ;
    public final void rule__TupleLiteral__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9541:1: ( ( ( ruleCommaSeparatedExpressions )? ) )
            // InternalExprParser.g:9542:1: ( ( ruleCommaSeparatedExpressions )? )
            {
            // InternalExprParser.g:9542:1: ( ( ruleCommaSeparatedExpressions )? )
            // InternalExprParser.g:9543:1: ( ruleCommaSeparatedExpressions )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleLiteralAccess().getCommaSeparatedExpressionsParserRuleCall_3()); 
            }
            // InternalExprParser.g:9544:1: ( ruleCommaSeparatedExpressions )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==Record||LA47_0==False||(LA47_0>=Tuple && LA47_0<=Union)||LA47_0==List||(LA47_0>=This && LA47_0<=True)||LA47_0==Bag||LA47_0==Map||(LA47_0>=Not && LA47_0<=Set)||LA47_0==If||LA47_0==NumberSign||LA47_0==LeftParenthesis||LA47_0==PlusSign||LA47_0==HyphenMinus||LA47_0==LeftSquareBracket||LA47_0==RULE_REAL_LIT||LA47_0==RULE_INTEGER_LIT||(LA47_0>=RULE_STRING && LA47_0<=RULE_ID)) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalExprParser.g:9544:3: ruleCommaSeparatedExpressions
                    {
                    pushFollow(FOLLOW_2);
                    ruleCommaSeparatedExpressions();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTupleLiteralAccess().getCommaSeparatedExpressionsParserRuleCall_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleLiteral__Group__3__Impl"


    // $ANTLR start "rule__TupleLiteral__Group__4"
    // InternalExprParser.g:9554:1: rule__TupleLiteral__Group__4 : rule__TupleLiteral__Group__4__Impl ;
    public final void rule__TupleLiteral__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9558:1: ( rule__TupleLiteral__Group__4__Impl )
            // InternalExprParser.g:9559:2: rule__TupleLiteral__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TupleLiteral__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleLiteral__Group__4"


    // $ANTLR start "rule__TupleLiteral__Group__4__Impl"
    // InternalExprParser.g:9565:1: rule__TupleLiteral__Group__4__Impl : ( RightParenthesis ) ;
    public final void rule__TupleLiteral__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9569:1: ( ( RightParenthesis ) )
            // InternalExprParser.g:9570:1: ( RightParenthesis )
            {
            // InternalExprParser.g:9570:1: ( RightParenthesis )
            // InternalExprParser.g:9571:1: RightParenthesis
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleLiteralAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,RightParenthesis,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTupleLiteralAccess().getRightParenthesisKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleLiteral__Group__4__Impl"


    // $ANTLR start "rule__BagLiteral__Group__0"
    // InternalExprParser.g:9594:1: rule__BagLiteral__Group__0 : rule__BagLiteral__Group__0__Impl rule__BagLiteral__Group__1 ;
    public final void rule__BagLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9598:1: ( rule__BagLiteral__Group__0__Impl rule__BagLiteral__Group__1 )
            // InternalExprParser.g:9599:2: rule__BagLiteral__Group__0__Impl rule__BagLiteral__Group__1
            {
            pushFollow(FOLLOW_68);
            rule__BagLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BagLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagLiteral__Group__0"


    // $ANTLR start "rule__BagLiteral__Group__0__Impl"
    // InternalExprParser.g:9606:1: rule__BagLiteral__Group__0__Impl : ( () ) ;
    public final void rule__BagLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9610:1: ( ( () ) )
            // InternalExprParser.g:9611:1: ( () )
            {
            // InternalExprParser.g:9611:1: ( () )
            // InternalExprParser.g:9612:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBagLiteralAccess().getBagLiteralAction_0()); 
            }
            // InternalExprParser.g:9613:1: ()
            // InternalExprParser.g:9615:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBagLiteralAccess().getBagLiteralAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagLiteral__Group__0__Impl"


    // $ANTLR start "rule__BagLiteral__Group__1"
    // InternalExprParser.g:9625:1: rule__BagLiteral__Group__1 : rule__BagLiteral__Group__1__Impl rule__BagLiteral__Group__2 ;
    public final void rule__BagLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9629:1: ( rule__BagLiteral__Group__1__Impl rule__BagLiteral__Group__2 )
            // InternalExprParser.g:9630:2: rule__BagLiteral__Group__1__Impl rule__BagLiteral__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__BagLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BagLiteral__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagLiteral__Group__1"


    // $ANTLR start "rule__BagLiteral__Group__1__Impl"
    // InternalExprParser.g:9637:1: rule__BagLiteral__Group__1__Impl : ( Bag ) ;
    public final void rule__BagLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9641:1: ( ( Bag ) )
            // InternalExprParser.g:9642:1: ( Bag )
            {
            // InternalExprParser.g:9642:1: ( Bag )
            // InternalExprParser.g:9643:1: Bag
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBagLiteralAccess().getBagKeyword_1()); 
            }
            match(input,Bag,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBagLiteralAccess().getBagKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagLiteral__Group__1__Impl"


    // $ANTLR start "rule__BagLiteral__Group__2"
    // InternalExprParser.g:9656:1: rule__BagLiteral__Group__2 : rule__BagLiteral__Group__2__Impl rule__BagLiteral__Group__3 ;
    public final void rule__BagLiteral__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9660:1: ( rule__BagLiteral__Group__2__Impl rule__BagLiteral__Group__3 )
            // InternalExprParser.g:9661:2: rule__BagLiteral__Group__2__Impl rule__BagLiteral__Group__3
            {
            pushFollow(FOLLOW_54);
            rule__BagLiteral__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BagLiteral__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagLiteral__Group__2"


    // $ANTLR start "rule__BagLiteral__Group__2__Impl"
    // InternalExprParser.g:9668:1: rule__BagLiteral__Group__2__Impl : ( LeftParenthesis ) ;
    public final void rule__BagLiteral__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9672:1: ( ( LeftParenthesis ) )
            // InternalExprParser.g:9673:1: ( LeftParenthesis )
            {
            // InternalExprParser.g:9673:1: ( LeftParenthesis )
            // InternalExprParser.g:9674:1: LeftParenthesis
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBagLiteralAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,LeftParenthesis,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBagLiteralAccess().getLeftParenthesisKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagLiteral__Group__2__Impl"


    // $ANTLR start "rule__BagLiteral__Group__3"
    // InternalExprParser.g:9687:1: rule__BagLiteral__Group__3 : rule__BagLiteral__Group__3__Impl rule__BagLiteral__Group__4 ;
    public final void rule__BagLiteral__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9691:1: ( rule__BagLiteral__Group__3__Impl rule__BagLiteral__Group__4 )
            // InternalExprParser.g:9692:2: rule__BagLiteral__Group__3__Impl rule__BagLiteral__Group__4
            {
            pushFollow(FOLLOW_54);
            rule__BagLiteral__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BagLiteral__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagLiteral__Group__3"


    // $ANTLR start "rule__BagLiteral__Group__3__Impl"
    // InternalExprParser.g:9699:1: rule__BagLiteral__Group__3__Impl : ( ( ruleCommaSeparatedExpressions )? ) ;
    public final void rule__BagLiteral__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9703:1: ( ( ( ruleCommaSeparatedExpressions )? ) )
            // InternalExprParser.g:9704:1: ( ( ruleCommaSeparatedExpressions )? )
            {
            // InternalExprParser.g:9704:1: ( ( ruleCommaSeparatedExpressions )? )
            // InternalExprParser.g:9705:1: ( ruleCommaSeparatedExpressions )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBagLiteralAccess().getCommaSeparatedExpressionsParserRuleCall_3()); 
            }
            // InternalExprParser.g:9706:1: ( ruleCommaSeparatedExpressions )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==Record||LA48_0==False||(LA48_0>=Tuple && LA48_0<=Union)||LA48_0==List||(LA48_0>=This && LA48_0<=True)||LA48_0==Bag||LA48_0==Map||(LA48_0>=Not && LA48_0<=Set)||LA48_0==If||LA48_0==NumberSign||LA48_0==LeftParenthesis||LA48_0==PlusSign||LA48_0==HyphenMinus||LA48_0==LeftSquareBracket||LA48_0==RULE_REAL_LIT||LA48_0==RULE_INTEGER_LIT||(LA48_0>=RULE_STRING && LA48_0<=RULE_ID)) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalExprParser.g:9706:3: ruleCommaSeparatedExpressions
                    {
                    pushFollow(FOLLOW_2);
                    ruleCommaSeparatedExpressions();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBagLiteralAccess().getCommaSeparatedExpressionsParserRuleCall_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagLiteral__Group__3__Impl"


    // $ANTLR start "rule__BagLiteral__Group__4"
    // InternalExprParser.g:9716:1: rule__BagLiteral__Group__4 : rule__BagLiteral__Group__4__Impl ;
    public final void rule__BagLiteral__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9720:1: ( rule__BagLiteral__Group__4__Impl )
            // InternalExprParser.g:9721:2: rule__BagLiteral__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BagLiteral__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagLiteral__Group__4"


    // $ANTLR start "rule__BagLiteral__Group__4__Impl"
    // InternalExprParser.g:9727:1: rule__BagLiteral__Group__4__Impl : ( RightParenthesis ) ;
    public final void rule__BagLiteral__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9731:1: ( ( RightParenthesis ) )
            // InternalExprParser.g:9732:1: ( RightParenthesis )
            {
            // InternalExprParser.g:9732:1: ( RightParenthesis )
            // InternalExprParser.g:9733:1: RightParenthesis
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBagLiteralAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,RightParenthesis,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBagLiteralAccess().getRightParenthesisKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagLiteral__Group__4__Impl"


    // $ANTLR start "rule__MapLiteral__Group__0"
    // InternalExprParser.g:9756:1: rule__MapLiteral__Group__0 : rule__MapLiteral__Group__0__Impl rule__MapLiteral__Group__1 ;
    public final void rule__MapLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9760:1: ( rule__MapLiteral__Group__0__Impl rule__MapLiteral__Group__1 )
            // InternalExprParser.g:9761:2: rule__MapLiteral__Group__0__Impl rule__MapLiteral__Group__1
            {
            pushFollow(FOLLOW_69);
            rule__MapLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MapLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapLiteral__Group__0"


    // $ANTLR start "rule__MapLiteral__Group__0__Impl"
    // InternalExprParser.g:9768:1: rule__MapLiteral__Group__0__Impl : ( () ) ;
    public final void rule__MapLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9772:1: ( ( () ) )
            // InternalExprParser.g:9773:1: ( () )
            {
            // InternalExprParser.g:9773:1: ( () )
            // InternalExprParser.g:9774:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMapLiteralAccess().getMapLiteralAction_0()); 
            }
            // InternalExprParser.g:9775:1: ()
            // InternalExprParser.g:9777:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMapLiteralAccess().getMapLiteralAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapLiteral__Group__0__Impl"


    // $ANTLR start "rule__MapLiteral__Group__1"
    // InternalExprParser.g:9787:1: rule__MapLiteral__Group__1 : rule__MapLiteral__Group__1__Impl ;
    public final void rule__MapLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9791:1: ( rule__MapLiteral__Group__1__Impl )
            // InternalExprParser.g:9792:2: rule__MapLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MapLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapLiteral__Group__1"


    // $ANTLR start "rule__MapLiteral__Group__1__Impl"
    // InternalExprParser.g:9798:1: rule__MapLiteral__Group__1__Impl : ( Map ) ;
    public final void rule__MapLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9802:1: ( ( Map ) )
            // InternalExprParser.g:9803:1: ( Map )
            {
            // InternalExprParser.g:9803:1: ( Map )
            // InternalExprParser.g:9804:1: Map
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMapLiteralAccess().getMapKeyword_1()); 
            }
            match(input,Map,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMapLiteralAccess().getMapKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapLiteral__Group__1__Impl"


    // $ANTLR start "rule__QPREF__Group__0"
    // InternalExprParser.g:9822:1: rule__QPREF__Group__0 : rule__QPREF__Group__0__Impl rule__QPREF__Group__1 ;
    public final void rule__QPREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9826:1: ( rule__QPREF__Group__0__Impl rule__QPREF__Group__1 )
            // InternalExprParser.g:9827:2: rule__QPREF__Group__0__Impl rule__QPREF__Group__1
            {
            pushFollow(FOLLOW_70);
            rule__QPREF__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QPREF__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QPREF__Group__0"


    // $ANTLR start "rule__QPREF__Group__0__Impl"
    // InternalExprParser.g:9834:1: rule__QPREF__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QPREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9838:1: ( ( RULE_ID ) )
            // InternalExprParser.g:9839:1: ( RULE_ID )
            {
            // InternalExprParser.g:9839:1: ( RULE_ID )
            // InternalExprParser.g:9840:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QPREF__Group__0__Impl"


    // $ANTLR start "rule__QPREF__Group__1"
    // InternalExprParser.g:9851:1: rule__QPREF__Group__1 : rule__QPREF__Group__1__Impl ;
    public final void rule__QPREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9855:1: ( rule__QPREF__Group__1__Impl )
            // InternalExprParser.g:9856:2: rule__QPREF__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QPREF__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QPREF__Group__1"


    // $ANTLR start "rule__QPREF__Group__1__Impl"
    // InternalExprParser.g:9862:1: rule__QPREF__Group__1__Impl : ( ( rule__QPREF__Group_1__0 )? ) ;
    public final void rule__QPREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9866:1: ( ( ( rule__QPREF__Group_1__0 )? ) )
            // InternalExprParser.g:9867:1: ( ( rule__QPREF__Group_1__0 )? )
            {
            // InternalExprParser.g:9867:1: ( ( rule__QPREF__Group_1__0 )? )
            // InternalExprParser.g:9868:1: ( rule__QPREF__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQPREFAccess().getGroup_1()); 
            }
            // InternalExprParser.g:9869:1: ( rule__QPREF__Group_1__0 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==ColonColon) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalExprParser.g:9869:2: rule__QPREF__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__QPREF__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQPREFAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QPREF__Group__1__Impl"


    // $ANTLR start "rule__QPREF__Group_1__0"
    // InternalExprParser.g:9883:1: rule__QPREF__Group_1__0 : rule__QPREF__Group_1__0__Impl rule__QPREF__Group_1__1 ;
    public final void rule__QPREF__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9887:1: ( rule__QPREF__Group_1__0__Impl rule__QPREF__Group_1__1 )
            // InternalExprParser.g:9888:2: rule__QPREF__Group_1__0__Impl rule__QPREF__Group_1__1
            {
            pushFollow(FOLLOW_7);
            rule__QPREF__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QPREF__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QPREF__Group_1__0"


    // $ANTLR start "rule__QPREF__Group_1__0__Impl"
    // InternalExprParser.g:9895:1: rule__QPREF__Group_1__0__Impl : ( ColonColon ) ;
    public final void rule__QPREF__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9899:1: ( ( ColonColon ) )
            // InternalExprParser.g:9900:1: ( ColonColon )
            {
            // InternalExprParser.g:9900:1: ( ColonColon )
            // InternalExprParser.g:9901:1: ColonColon
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQPREFAccess().getColonColonKeyword_1_0()); 
            }
            match(input,ColonColon,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQPREFAccess().getColonColonKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QPREF__Group_1__0__Impl"


    // $ANTLR start "rule__QPREF__Group_1__1"
    // InternalExprParser.g:9914:1: rule__QPREF__Group_1__1 : rule__QPREF__Group_1__1__Impl ;
    public final void rule__QPREF__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9918:1: ( rule__QPREF__Group_1__1__Impl )
            // InternalExprParser.g:9919:2: rule__QPREF__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QPREF__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QPREF__Group_1__1"


    // $ANTLR start "rule__QPREF__Group_1__1__Impl"
    // InternalExprParser.g:9925:1: rule__QPREF__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QPREF__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9929:1: ( ( RULE_ID ) )
            // InternalExprParser.g:9930:1: ( RULE_ID )
            {
            // InternalExprParser.g:9930:1: ( RULE_ID )
            // InternalExprParser.g:9931:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQPREFAccess().getIDTerminalRuleCall_1_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQPREFAccess().getIDTerminalRuleCall_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QPREF__Group_1__1__Impl"


    // $ANTLR start "rule__QCREF__Group__0"
    // InternalExprParser.g:9946:1: rule__QCREF__Group__0 : rule__QCREF__Group__0__Impl rule__QCREF__Group__1 ;
    public final void rule__QCREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9950:1: ( rule__QCREF__Group__0__Impl rule__QCREF__Group__1 )
            // InternalExprParser.g:9951:2: rule__QCREF__Group__0__Impl rule__QCREF__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__QCREF__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QCREF__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QCREF__Group__0"


    // $ANTLR start "rule__QCREF__Group__0__Impl"
    // InternalExprParser.g:9958:1: rule__QCREF__Group__0__Impl : ( ( rule__QCREF__Group_0__0 )* ) ;
    public final void rule__QCREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9962:1: ( ( ( rule__QCREF__Group_0__0 )* ) )
            // InternalExprParser.g:9963:1: ( ( rule__QCREF__Group_0__0 )* )
            {
            // InternalExprParser.g:9963:1: ( ( rule__QCREF__Group_0__0 )* )
            // InternalExprParser.g:9964:1: ( rule__QCREF__Group_0__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQCREFAccess().getGroup_0()); 
            }
            // InternalExprParser.g:9965:1: ( rule__QCREF__Group_0__0 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_ID) ) {
                    int LA50_1 = input.LA(2);

                    if ( (LA50_1==ColonColon) ) {
                        alt50=1;
                    }


                }


                switch (alt50) {
            	case 1 :
            	    // InternalExprParser.g:9965:2: rule__QCREF__Group_0__0
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__QCREF__Group_0__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQCREFAccess().getGroup_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QCREF__Group__0__Impl"


    // $ANTLR start "rule__QCREF__Group__1"
    // InternalExprParser.g:9975:1: rule__QCREF__Group__1 : rule__QCREF__Group__1__Impl rule__QCREF__Group__2 ;
    public final void rule__QCREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9979:1: ( rule__QCREF__Group__1__Impl rule__QCREF__Group__2 )
            // InternalExprParser.g:9980:2: rule__QCREF__Group__1__Impl rule__QCREF__Group__2
            {
            pushFollow(FOLLOW_51);
            rule__QCREF__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QCREF__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QCREF__Group__1"


    // $ANTLR start "rule__QCREF__Group__1__Impl"
    // InternalExprParser.g:9987:1: rule__QCREF__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__QCREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9991:1: ( ( RULE_ID ) )
            // InternalExprParser.g:9992:1: ( RULE_ID )
            {
            // InternalExprParser.g:9992:1: ( RULE_ID )
            // InternalExprParser.g:9993:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QCREF__Group__1__Impl"


    // $ANTLR start "rule__QCREF__Group__2"
    // InternalExprParser.g:10004:1: rule__QCREF__Group__2 : rule__QCREF__Group__2__Impl ;
    public final void rule__QCREF__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10008:1: ( rule__QCREF__Group__2__Impl )
            // InternalExprParser.g:10009:2: rule__QCREF__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QCREF__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QCREF__Group__2"


    // $ANTLR start "rule__QCREF__Group__2__Impl"
    // InternalExprParser.g:10015:1: rule__QCREF__Group__2__Impl : ( ( rule__QCREF__Group_2__0 )? ) ;
    public final void rule__QCREF__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10019:1: ( ( ( rule__QCREF__Group_2__0 )? ) )
            // InternalExprParser.g:10020:1: ( ( rule__QCREF__Group_2__0 )? )
            {
            // InternalExprParser.g:10020:1: ( ( rule__QCREF__Group_2__0 )? )
            // InternalExprParser.g:10021:1: ( rule__QCREF__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQCREFAccess().getGroup_2()); 
            }
            // InternalExprParser.g:10022:1: ( rule__QCREF__Group_2__0 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==FullStop) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalExprParser.g:10022:2: rule__QCREF__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__QCREF__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQCREFAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QCREF__Group__2__Impl"


    // $ANTLR start "rule__QCREF__Group_0__0"
    // InternalExprParser.g:10038:1: rule__QCREF__Group_0__0 : rule__QCREF__Group_0__0__Impl rule__QCREF__Group_0__1 ;
    public final void rule__QCREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10042:1: ( rule__QCREF__Group_0__0__Impl rule__QCREF__Group_0__1 )
            // InternalExprParser.g:10043:2: rule__QCREF__Group_0__0__Impl rule__QCREF__Group_0__1
            {
            pushFollow(FOLLOW_70);
            rule__QCREF__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QCREF__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QCREF__Group_0__0"


    // $ANTLR start "rule__QCREF__Group_0__0__Impl"
    // InternalExprParser.g:10050:1: rule__QCREF__Group_0__0__Impl : ( RULE_ID ) ;
    public final void rule__QCREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10054:1: ( ( RULE_ID ) )
            // InternalExprParser.g:10055:1: ( RULE_ID )
            {
            // InternalExprParser.g:10055:1: ( RULE_ID )
            // InternalExprParser.g:10056:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QCREF__Group_0__0__Impl"


    // $ANTLR start "rule__QCREF__Group_0__1"
    // InternalExprParser.g:10067:1: rule__QCREF__Group_0__1 : rule__QCREF__Group_0__1__Impl ;
    public final void rule__QCREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10071:1: ( rule__QCREF__Group_0__1__Impl )
            // InternalExprParser.g:10072:2: rule__QCREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QCREF__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QCREF__Group_0__1"


    // $ANTLR start "rule__QCREF__Group_0__1__Impl"
    // InternalExprParser.g:10078:1: rule__QCREF__Group_0__1__Impl : ( ColonColon ) ;
    public final void rule__QCREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10082:1: ( ( ColonColon ) )
            // InternalExprParser.g:10083:1: ( ColonColon )
            {
            // InternalExprParser.g:10083:1: ( ColonColon )
            // InternalExprParser.g:10084:1: ColonColon
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); 
            }
            match(input,ColonColon,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QCREF__Group_0__1__Impl"


    // $ANTLR start "rule__QCREF__Group_2__0"
    // InternalExprParser.g:10101:1: rule__QCREF__Group_2__0 : rule__QCREF__Group_2__0__Impl rule__QCREF__Group_2__1 ;
    public final void rule__QCREF__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10105:1: ( rule__QCREF__Group_2__0__Impl rule__QCREF__Group_2__1 )
            // InternalExprParser.g:10106:2: rule__QCREF__Group_2__0__Impl rule__QCREF__Group_2__1
            {
            pushFollow(FOLLOW_7);
            rule__QCREF__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QCREF__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QCREF__Group_2__0"


    // $ANTLR start "rule__QCREF__Group_2__0__Impl"
    // InternalExprParser.g:10113:1: rule__QCREF__Group_2__0__Impl : ( FullStop ) ;
    public final void rule__QCREF__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10117:1: ( ( FullStop ) )
            // InternalExprParser.g:10118:1: ( FullStop )
            {
            // InternalExprParser.g:10118:1: ( FullStop )
            // InternalExprParser.g:10119:1: FullStop
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQCREFAccess().getFullStopKeyword_2_0()); 
            }
            match(input,FullStop,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQCREFAccess().getFullStopKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QCREF__Group_2__0__Impl"


    // $ANTLR start "rule__QCREF__Group_2__1"
    // InternalExprParser.g:10132:1: rule__QCREF__Group_2__1 : rule__QCREF__Group_2__1__Impl ;
    public final void rule__QCREF__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10136:1: ( rule__QCREF__Group_2__1__Impl )
            // InternalExprParser.g:10137:2: rule__QCREF__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QCREF__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QCREF__Group_2__1"


    // $ANTLR start "rule__QCREF__Group_2__1__Impl"
    // InternalExprParser.g:10143:1: rule__QCREF__Group_2__1__Impl : ( RULE_ID ) ;
    public final void rule__QCREF__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10147:1: ( ( RULE_ID ) )
            // InternalExprParser.g:10148:1: ( RULE_ID )
            {
            // InternalExprParser.g:10148:1: ( RULE_ID )
            // InternalExprParser.g:10149:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_2_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QCREF__Group_2__1__Impl"


    // $ANTLR start "rule__ExprModel__AnnexAssignment_0_1"
    // InternalExprParser.g:10165:1: rule__ExprModel__AnnexAssignment_0_1 : ( ruleExprLibrary ) ;
    public final void rule__ExprModel__AnnexAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10169:1: ( ( ruleExprLibrary ) )
            // InternalExprParser.g:10170:1: ( ruleExprLibrary )
            {
            // InternalExprParser.g:10170:1: ( ruleExprLibrary )
            // InternalExprParser.g:10171:1: ruleExprLibrary
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprModelAccess().getAnnexExprLibraryParserRuleCall_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExprLibrary();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprModelAccess().getAnnexExprLibraryParserRuleCall_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExprModel__AnnexAssignment_0_1"


    // $ANTLR start "rule__ExprModel__AnnexAssignment_1_1"
    // InternalExprParser.g:10180:1: rule__ExprModel__AnnexAssignment_1_1 : ( ruleExprSubclause ) ;
    public final void rule__ExprModel__AnnexAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10184:1: ( ( ruleExprSubclause ) )
            // InternalExprParser.g:10185:1: ( ruleExprSubclause )
            {
            // InternalExprParser.g:10185:1: ( ruleExprSubclause )
            // InternalExprParser.g:10186:1: ruleExprSubclause
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprModelAccess().getAnnexExprSubclauseParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExprSubclause();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprModelAccess().getAnnexExprSubclauseParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExprModel__AnnexAssignment_1_1"


    // $ANTLR start "rule__Declarations__DeclsAssignment_0"
    // InternalExprParser.g:10195:1: rule__Declarations__DeclsAssignment_0 : ( ruleDeclaration ) ;
    public final void rule__Declarations__DeclsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10199:1: ( ( ruleDeclaration ) )
            // InternalExprParser.g:10200:1: ( ruleDeclaration )
            {
            // InternalExprParser.g:10200:1: ( ruleDeclaration )
            // InternalExprParser.g:10201:1: ruleDeclaration
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclarationsAccess().getDeclsDeclarationParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleDeclaration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclarationsAccess().getDeclsDeclarationParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarations__DeclsAssignment_0"


    // $ANTLR start "rule__Declarations__DeclsAssignment_1_1"
    // InternalExprParser.g:10210:1: rule__Declarations__DeclsAssignment_1_1 : ( ruleDeclaration ) ;
    public final void rule__Declarations__DeclsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10214:1: ( ( ruleDeclaration ) )
            // InternalExprParser.g:10215:1: ( ruleDeclaration )
            {
            // InternalExprParser.g:10215:1: ( ruleDeclaration )
            // InternalExprParser.g:10216:1: ruleDeclaration
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclarationsAccess().getDeclsDeclarationParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleDeclaration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclarationsAccess().getDeclsDeclarationParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarations__DeclsAssignment_1_1"


    // $ANTLR start "rule__TypeDecl__NameAssignment_2"
    // InternalExprParser.g:10225:1: rule__TypeDecl__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__TypeDecl__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10229:1: ( ( RULE_ID ) )
            // InternalExprParser.g:10230:1: ( RULE_ID )
            {
            // InternalExprParser.g:10230:1: ( RULE_ID )
            // InternalExprParser.g:10231:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDeclAccess().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDeclAccess().getNameIDTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDecl__NameAssignment_2"


    // $ANTLR start "rule__TypeDecl__TypeAssignment_4"
    // InternalExprParser.g:10240:1: rule__TypeDecl__TypeAssignment_4 : ( ruleType ) ;
    public final void rule__TypeDecl__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10244:1: ( ( ruleType ) )
            // InternalExprParser.g:10245:1: ( ruleType )
            {
            // InternalExprParser.g:10245:1: ( ruleType )
            // InternalExprParser.g:10246:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDeclAccess().getTypeTypeParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDeclAccess().getTypeTypeParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDecl__TypeAssignment_4"


    // $ANTLR start "rule__VarDecl__ConstAssignment_1_0"
    // InternalExprParser.g:10255:1: rule__VarDecl__ConstAssignment_1_0 : ( ( Val ) ) ;
    public final void rule__VarDecl__ConstAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10259:1: ( ( ( Val ) ) )
            // InternalExprParser.g:10260:1: ( ( Val ) )
            {
            // InternalExprParser.g:10260:1: ( ( Val ) )
            // InternalExprParser.g:10261:1: ( Val )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getConstValKeyword_1_0_0()); 
            }
            // InternalExprParser.g:10262:1: ( Val )
            // InternalExprParser.g:10263:1: Val
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getConstValKeyword_1_0_0()); 
            }
            match(input,Val,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getConstValKeyword_1_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getConstValKeyword_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__ConstAssignment_1_0"


    // $ANTLR start "rule__VarDecl__NameAssignment_2"
    // InternalExprParser.g:10278:1: rule__VarDecl__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__VarDecl__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10282:1: ( ( RULE_ID ) )
            // InternalExprParser.g:10283:1: ( RULE_ID )
            {
            // InternalExprParser.g:10283:1: ( RULE_ID )
            // InternalExprParser.g:10284:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getNameIDTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__NameAssignment_2"


    // $ANTLR start "rule__VarDecl__TypeAssignment_3_1"
    // InternalExprParser.g:10293:1: rule__VarDecl__TypeAssignment_3_1 : ( ruleType ) ;
    public final void rule__VarDecl__TypeAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10297:1: ( ( ruleType ) )
            // InternalExprParser.g:10298:1: ( ruleType )
            {
            // InternalExprParser.g:10298:1: ( ruleType )
            // InternalExprParser.g:10299:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getTypeTypeParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getTypeTypeParserRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__TypeAssignment_3_1"


    // $ANTLR start "rule__VarDecl__ValueAssignment_4_1"
    // InternalExprParser.g:10308:1: rule__VarDecl__ValueAssignment_4_1 : ( ruleExpression ) ;
    public final void rule__VarDecl__ValueAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10312:1: ( ( ruleExpression ) )
            // InternalExprParser.g:10313:1: ( ruleExpression )
            {
            // InternalExprParser.g:10313:1: ( ruleExpression )
            // InternalExprParser.g:10314:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getValueExpressionParserRuleCall_4_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getValueExpressionParserRuleCall_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__ValueAssignment_4_1"


    // $ANTLR start "rule__FunDecl__NameAssignment_2"
    // InternalExprParser.g:10323:1: rule__FunDecl__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__FunDecl__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10327:1: ( ( RULE_ID ) )
            // InternalExprParser.g:10328:1: ( RULE_ID )
            {
            // InternalExprParser.g:10328:1: ( RULE_ID )
            // InternalExprParser.g:10329:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunDeclAccess().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunDeclAccess().getNameIDTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunDecl__NameAssignment_2"


    // $ANTLR start "rule__Category__CategoryAssignment"
    // InternalExprParser.g:10338:1: rule__Category__CategoryAssignment : ( ruleComponentCategory ) ;
    public final void rule__Category__CategoryAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10342:1: ( ( ruleComponentCategory ) )
            // InternalExprParser.g:10343:1: ( ruleComponentCategory )
            {
            // InternalExprParser.g:10343:1: ( ruleComponentCategory )
            // InternalExprParser.g:10344:1: ruleComponentCategory
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCategoryAccess().getCategoryComponentCategoryParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleComponentCategory();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCategoryAccess().getCategoryComponentCategoryParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Category__CategoryAssignment"


    // $ANTLR start "rule__MetaClass__ClassAssignment"
    // InternalExprParser.g:10353:1: rule__MetaClass__ClassAssignment : ( ruleMetaClassEnum ) ;
    public final void rule__MetaClass__ClassAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10357:1: ( ( ruleMetaClassEnum ) )
            // InternalExprParser.g:10358:1: ( ruleMetaClassEnum )
            {
            // InternalExprParser.g:10358:1: ( ruleMetaClassEnum )
            // InternalExprParser.g:10359:1: ruleMetaClassEnum
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetaClassAccess().getClassMetaClassEnumEnumRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleMetaClassEnum();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMetaClassAccess().getClassMetaClassEnumEnumRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetaClass__ClassAssignment"


    // $ANTLR start "rule__ClassifierType__BaseAssignment_2_1"
    // InternalExprParser.g:10368:1: rule__ClassifierType__BaseAssignment_2_1 : ( ( ruleQCREF ) ) ;
    public final void rule__ClassifierType__BaseAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10372:1: ( ( ( ruleQCREF ) ) )
            // InternalExprParser.g:10373:1: ( ( ruleQCREF ) )
            {
            // InternalExprParser.g:10373:1: ( ( ruleQCREF ) )
            // InternalExprParser.g:10374:1: ( ruleQCREF )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeAccess().getBaseClassifierCrossReference_2_1_0()); 
            }
            // InternalExprParser.g:10375:1: ( ruleQCREF )
            // InternalExprParser.g:10376:1: ruleQCREF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeAccess().getBaseClassifierQCREFParserRuleCall_2_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassifierTypeAccess().getBaseClassifierQCREFParserRuleCall_2_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassifierTypeAccess().getBaseClassifierCrossReference_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierType__BaseAssignment_2_1"


    // $ANTLR start "rule__RecordType__FieldAssignment_3"
    // InternalExprParser.g:10387:1: rule__RecordType__FieldAssignment_3 : ( ruleField ) ;
    public final void rule__RecordType__FieldAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10391:1: ( ( ruleField ) )
            // InternalExprParser.g:10392:1: ( ruleField )
            {
            // InternalExprParser.g:10392:1: ( ruleField )
            // InternalExprParser.g:10393:1: ruleField
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecordTypeAccess().getFieldFieldParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleField();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecordTypeAccess().getFieldFieldParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecordType__FieldAssignment_3"


    // $ANTLR start "rule__Field__NameAssignment_0"
    // InternalExprParser.g:10402:1: rule__Field__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Field__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10406:1: ( ( RULE_ID ) )
            // InternalExprParser.g:10407:1: ( RULE_ID )
            {
            // InternalExprParser.g:10407:1: ( RULE_ID )
            // InternalExprParser.g:10408:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__NameAssignment_0"


    // $ANTLR start "rule__Field__TypeAssignment_2"
    // InternalExprParser.g:10417:1: rule__Field__TypeAssignment_2 : ( ruleType ) ;
    public final void rule__Field__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10421:1: ( ( ruleType ) )
            // InternalExprParser.g:10422:1: ( ruleType )
            {
            // InternalExprParser.g:10422:1: ( ruleType )
            // InternalExprParser.g:10423:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getTypeTypeParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getTypeTypeParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__TypeAssignment_2"


    // $ANTLR start "rule__TupleType__FieldAssignment_3"
    // InternalExprParser.g:10432:1: rule__TupleType__FieldAssignment_3 : ( ruleTupleField ) ;
    public final void rule__TupleType__FieldAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10436:1: ( ( ruleTupleField ) )
            // InternalExprParser.g:10437:1: ( ruleTupleField )
            {
            // InternalExprParser.g:10437:1: ( ruleTupleField )
            // InternalExprParser.g:10438:1: ruleTupleField
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleTypeAccess().getFieldTupleFieldParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTupleField();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTupleTypeAccess().getFieldTupleFieldParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleType__FieldAssignment_3"


    // $ANTLR start "rule__TupleField__TypeAssignment_1"
    // InternalExprParser.g:10447:1: rule__TupleField__TypeAssignment_1 : ( ruleType ) ;
    public final void rule__TupleField__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10451:1: ( ( ruleType ) )
            // InternalExprParser.g:10452:1: ( ruleType )
            {
            // InternalExprParser.g:10452:1: ( ruleType )
            // InternalExprParser.g:10453:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleFieldAccess().getTypeTypeParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTupleFieldAccess().getTypeTypeParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleField__TypeAssignment_1"


    // $ANTLR start "rule__ListType__TypeAssignment_3"
    // InternalExprParser.g:10462:1: rule__ListType__TypeAssignment_3 : ( ruleType ) ;
    public final void rule__ListType__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10466:1: ( ( ruleType ) )
            // InternalExprParser.g:10467:1: ( ruleType )
            {
            // InternalExprParser.g:10467:1: ( ruleType )
            // InternalExprParser.g:10468:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListTypeAccess().getTypeTypeParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getListTypeAccess().getTypeTypeParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__TypeAssignment_3"


    // $ANTLR start "rule__SetType__TypeAssignment_2"
    // InternalExprParser.g:10477:1: rule__SetType__TypeAssignment_2 : ( ruleType ) ;
    public final void rule__SetType__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10481:1: ( ( ruleType ) )
            // InternalExprParser.g:10482:1: ( ruleType )
            {
            // InternalExprParser.g:10482:1: ( ruleType )
            // InternalExprParser.g:10483:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSetTypeAccess().getTypeTypeParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSetTypeAccess().getTypeTypeParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetType__TypeAssignment_2"


    // $ANTLR start "rule__BagType__TypeAssignment_2"
    // InternalExprParser.g:10492:1: rule__BagType__TypeAssignment_2 : ( ruleType ) ;
    public final void rule__BagType__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10496:1: ( ( ruleType ) )
            // InternalExprParser.g:10497:1: ( ruleType )
            {
            // InternalExprParser.g:10497:1: ( ruleType )
            // InternalExprParser.g:10498:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBagTypeAccess().getTypeTypeParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBagTypeAccess().getTypeTypeParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagType__TypeAssignment_2"


    // $ANTLR start "rule__MapType__DomAssignment_1"
    // InternalExprParser.g:10507:1: rule__MapType__DomAssignment_1 : ( ruleType ) ;
    public final void rule__MapType__DomAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10511:1: ( ( ruleType ) )
            // InternalExprParser.g:10512:1: ( ruleType )
            {
            // InternalExprParser.g:10512:1: ( ruleType )
            // InternalExprParser.g:10513:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMapTypeAccess().getDomTypeParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMapTypeAccess().getDomTypeParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__DomAssignment_1"


    // $ANTLR start "rule__MapType__ImgAssignment_3"
    // InternalExprParser.g:10522:1: rule__MapType__ImgAssignment_3 : ( ruleType ) ;
    public final void rule__MapType__ImgAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10526:1: ( ( ruleType ) )
            // InternalExprParser.g:10527:1: ( ruleType )
            {
            // InternalExprParser.g:10527:1: ( ruleType )
            // InternalExprParser.g:10528:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMapTypeAccess().getImgTypeParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMapTypeAccess().getImgTypeParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__ImgAssignment_3"


    // $ANTLR start "rule__TypeRef__RefAssignment"
    // InternalExprParser.g:10537:1: rule__TypeRef__RefAssignment : ( ( ruleQCREF ) ) ;
    public final void rule__TypeRef__RefAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10541:1: ( ( ( ruleQCREF ) ) )
            // InternalExprParser.g:10542:1: ( ( ruleQCREF ) )
            {
            // InternalExprParser.g:10542:1: ( ( ruleQCREF ) )
            // InternalExprParser.g:10543:1: ( ruleQCREF )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRefAccess().getRefTypeDeclCrossReference_0()); 
            }
            // InternalExprParser.g:10544:1: ( ruleQCREF )
            // InternalExprParser.g:10545:1: ruleQCREF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRefAccess().getRefTypeDeclQCREFParserRuleCall_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRefAccess().getRefTypeDeclQCREFParserRuleCall_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRefAccess().getRefTypeDeclCrossReference_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__RefAssignment"


    // $ANTLR start "rule__OrExpression__OperatorAssignment_1_0_0_1"
    // InternalExprParser.g:10556:1: rule__OrExpression__OperatorAssignment_1_0_0_1 : ( ruleOpOr ) ;
    public final void rule__OrExpression__OperatorAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10560:1: ( ( ruleOpOr ) )
            // InternalExprParser.g:10561:1: ( ruleOpOr )
            {
            // InternalExprParser.g:10561:1: ( ruleOpOr )
            // InternalExprParser.g:10562:1: ruleOpOr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionAccess().getOperatorOpOrParserRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOpOr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrExpressionAccess().getOperatorOpOrParserRuleCall_1_0_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__OperatorAssignment_1_0_0_1"


    // $ANTLR start "rule__OrExpression__RightAssignment_1_1"
    // InternalExprParser.g:10571:1: rule__OrExpression__RightAssignment_1_1 : ( ruleAndExpression ) ;
    public final void rule__OrExpression__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10575:1: ( ( ruleAndExpression ) )
            // InternalExprParser.g:10576:1: ( ruleAndExpression )
            {
            // InternalExprParser.g:10576:1: ( ruleAndExpression )
            // InternalExprParser.g:10577:1: ruleAndExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAndExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__RightAssignment_1_1"


    // $ANTLR start "rule__AndExpression__OperatorAssignment_1_0_0_1"
    // InternalExprParser.g:10586:1: rule__AndExpression__OperatorAssignment_1_0_0_1 : ( ruleOpAnd ) ;
    public final void rule__AndExpression__OperatorAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10590:1: ( ( ruleOpAnd ) )
            // InternalExprParser.g:10591:1: ( ruleOpAnd )
            {
            // InternalExprParser.g:10591:1: ( ruleOpAnd )
            // InternalExprParser.g:10592:1: ruleOpAnd
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionAccess().getOperatorOpAndParserRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOpAnd();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndExpressionAccess().getOperatorOpAndParserRuleCall_1_0_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__OperatorAssignment_1_0_0_1"


    // $ANTLR start "rule__AndExpression__RightAssignment_1_1"
    // InternalExprParser.g:10601:1: rule__AndExpression__RightAssignment_1_1 : ( ruleEqualityExpression ) ;
    public final void rule__AndExpression__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10605:1: ( ( ruleEqualityExpression ) )
            // InternalExprParser.g:10606:1: ( ruleEqualityExpression )
            {
            // InternalExprParser.g:10606:1: ( ruleEqualityExpression )
            // InternalExprParser.g:10607:1: ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionAccess().getRightEqualityExpressionParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndExpressionAccess().getRightEqualityExpressionParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__RightAssignment_1_1"


    // $ANTLR start "rule__EqualityExpression__OperatorAssignment_1_0_0_1"
    // InternalExprParser.g:10616:1: rule__EqualityExpression__OperatorAssignment_1_0_0_1 : ( ruleOpEquality ) ;
    public final void rule__EqualityExpression__OperatorAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10620:1: ( ( ruleOpEquality ) )
            // InternalExprParser.g:10621:1: ( ruleOpEquality )
            {
            // InternalExprParser.g:10621:1: ( ruleOpEquality )
            // InternalExprParser.g:10622:1: ruleOpEquality
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpressionAccess().getOperatorOpEqualityParserRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOpEquality();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExpressionAccess().getOperatorOpEqualityParserRuleCall_1_0_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__OperatorAssignment_1_0_0_1"


    // $ANTLR start "rule__EqualityExpression__RightAssignment_1_1"
    // InternalExprParser.g:10631:1: rule__EqualityExpression__RightAssignment_1_1 : ( ruleRelationalExpression ) ;
    public final void rule__EqualityExpression__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10635:1: ( ( ruleRelationalExpression ) )
            // InternalExprParser.g:10636:1: ( ruleRelationalExpression )
            {
            // InternalExprParser.g:10636:1: ( ruleRelationalExpression )
            // InternalExprParser.g:10637:1: ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpressionAccess().getRightRelationalExpressionParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExpressionAccess().getRightRelationalExpressionParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__RightAssignment_1_1"


    // $ANTLR start "rule__RelationalExpression__OperatorAssignment_1_0_0_1"
    // InternalExprParser.g:10646:1: rule__RelationalExpression__OperatorAssignment_1_0_0_1 : ( ruleOpCompare ) ;
    public final void rule__RelationalExpression__OperatorAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10650:1: ( ( ruleOpCompare ) )
            // InternalExprParser.g:10651:1: ( ruleOpCompare )
            {
            // InternalExprParser.g:10651:1: ( ruleOpCompare )
            // InternalExprParser.g:10652:1: ruleOpCompare
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRelationalExpressionAccess().getOperatorOpCompareParserRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOpCompare();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRelationalExpressionAccess().getOperatorOpCompareParserRuleCall_1_0_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__OperatorAssignment_1_0_0_1"


    // $ANTLR start "rule__RelationalExpression__RightAssignment_1_1"
    // InternalExprParser.g:10661:1: rule__RelationalExpression__RightAssignment_1_1 : ( ruleAdditiveExpression ) ;
    public final void rule__RelationalExpression__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10665:1: ( ( ruleAdditiveExpression ) )
            // InternalExprParser.g:10666:1: ( ruleAdditiveExpression )
            {
            // InternalExprParser.g:10666:1: ( ruleAdditiveExpression )
            // InternalExprParser.g:10667:1: ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRelationalExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRelationalExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__RightAssignment_1_1"


    // $ANTLR start "rule__AdditiveExpression__OperatorAssignment_1_0_0_1"
    // InternalExprParser.g:10676:1: rule__AdditiveExpression__OperatorAssignment_1_0_0_1 : ( ruleOpAdd ) ;
    public final void rule__AdditiveExpression__OperatorAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10680:1: ( ( ruleOpAdd ) )
            // InternalExprParser.g:10681:1: ( ruleOpAdd )
            {
            // InternalExprParser.g:10681:1: ( ruleOpAdd )
            // InternalExprParser.g:10682:1: ruleOpAdd
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExpressionAccess().getOperatorOpAddParserRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOpAdd();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExpressionAccess().getOperatorOpAddParserRuleCall_1_0_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__OperatorAssignment_1_0_0_1"


    // $ANTLR start "rule__AdditiveExpression__RightAssignment_1_1"
    // InternalExprParser.g:10691:1: rule__AdditiveExpression__RightAssignment_1_1 : ( ruleMultiplicativeExpression ) ;
    public final void rule__AdditiveExpression__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10695:1: ( ( ruleMultiplicativeExpression ) )
            // InternalExprParser.g:10696:1: ( ruleMultiplicativeExpression )
            {
            // InternalExprParser.g:10696:1: ( ruleMultiplicativeExpression )
            // InternalExprParser.g:10697:1: ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExpressionAccess().getRightMultiplicativeExpressionParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExpressionAccess().getRightMultiplicativeExpressionParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__RightAssignment_1_1"


    // $ANTLR start "rule__MultiplicativeExpression__OperatorAssignment_1_0_0_1"
    // InternalExprParser.g:10706:1: rule__MultiplicativeExpression__OperatorAssignment_1_0_0_1 : ( ruleOpMulti ) ;
    public final void rule__MultiplicativeExpression__OperatorAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10710:1: ( ( ruleOpMulti ) )
            // InternalExprParser.g:10711:1: ( ruleOpMulti )
            {
            // InternalExprParser.g:10711:1: ( ruleOpMulti )
            // InternalExprParser.g:10712:1: ruleOpMulti
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExpressionAccess().getOperatorOpMultiParserRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOpMulti();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExpressionAccess().getOperatorOpMultiParserRuleCall_1_0_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__OperatorAssignment_1_0_0_1"


    // $ANTLR start "rule__MultiplicativeExpression__RightAssignment_1_1"
    // InternalExprParser.g:10721:1: rule__MultiplicativeExpression__RightAssignment_1_1 : ( ruleUnaryOperation ) ;
    public final void rule__MultiplicativeExpression__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10725:1: ( ( ruleUnaryOperation ) )
            // InternalExprParser.g:10726:1: ( ruleUnaryOperation )
            {
            // InternalExprParser.g:10726:1: ( ruleUnaryOperation )
            // InternalExprParser.g:10727:1: ruleUnaryOperation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExpressionAccess().getRightUnaryOperationParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleUnaryOperation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExpressionAccess().getRightUnaryOperationParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__RightAssignment_1_1"


    // $ANTLR start "rule__UnaryOperation__OperatorAssignment_0_1"
    // InternalExprParser.g:10736:1: rule__UnaryOperation__OperatorAssignment_0_1 : ( ruleOpUnary ) ;
    public final void rule__UnaryOperation__OperatorAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10740:1: ( ( ruleOpUnary ) )
            // InternalExprParser.g:10741:1: ( ruleOpUnary )
            {
            // InternalExprParser.g:10741:1: ( ruleOpUnary )
            // InternalExprParser.g:10742:1: ruleOpUnary
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryOperationAccess().getOperatorOpUnaryParserRuleCall_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOpUnary();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnaryOperationAccess().getOperatorOpUnaryParserRuleCall_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryOperation__OperatorAssignment_0_1"


    // $ANTLR start "rule__UnaryOperation__OperandAssignment_0_2"
    // InternalExprParser.g:10751:1: rule__UnaryOperation__OperandAssignment_0_2 : ( ruleUnitExpression ) ;
    public final void rule__UnaryOperation__OperandAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10755:1: ( ( ruleUnitExpression ) )
            // InternalExprParser.g:10756:1: ( ruleUnitExpression )
            {
            // InternalExprParser.g:10756:1: ( ruleUnitExpression )
            // InternalExprParser.g:10757:1: ruleUnitExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryOperationAccess().getOperandUnitExpressionParserRuleCall_0_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleUnitExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnaryOperationAccess().getOperandUnitExpressionParserRuleCall_0_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryOperation__OperandAssignment_0_2"


    // $ANTLR start "rule__UnitExpression__ConvertAssignment_1_1_0"
    // InternalExprParser.g:10766:1: rule__UnitExpression__ConvertAssignment_1_1_0 : ( ( PercentSign ) ) ;
    public final void rule__UnitExpression__ConvertAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10770:1: ( ( ( PercentSign ) ) )
            // InternalExprParser.g:10771:1: ( ( PercentSign ) )
            {
            // InternalExprParser.g:10771:1: ( ( PercentSign ) )
            // InternalExprParser.g:10772:1: ( PercentSign )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnitExpressionAccess().getConvertPercentSignKeyword_1_1_0_0()); 
            }
            // InternalExprParser.g:10773:1: ( PercentSign )
            // InternalExprParser.g:10774:1: PercentSign
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnitExpressionAccess().getConvertPercentSignKeyword_1_1_0_0()); 
            }
            match(input,PercentSign,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnitExpressionAccess().getConvertPercentSignKeyword_1_1_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnitExpressionAccess().getConvertPercentSignKeyword_1_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnitExpression__ConvertAssignment_1_1_0"


    // $ANTLR start "rule__UnitExpression__DropAssignment_1_1_1"
    // InternalExprParser.g:10789:1: rule__UnitExpression__DropAssignment_1_1_1 : ( ( In ) ) ;
    public final void rule__UnitExpression__DropAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10793:1: ( ( ( In ) ) )
            // InternalExprParser.g:10794:1: ( ( In ) )
            {
            // InternalExprParser.g:10794:1: ( ( In ) )
            // InternalExprParser.g:10795:1: ( In )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnitExpressionAccess().getDropInKeyword_1_1_1_0()); 
            }
            // InternalExprParser.g:10796:1: ( In )
            // InternalExprParser.g:10797:1: In
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnitExpressionAccess().getDropInKeyword_1_1_1_0()); 
            }
            match(input,In,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnitExpressionAccess().getDropInKeyword_1_1_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnitExpressionAccess().getDropInKeyword_1_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnitExpression__DropAssignment_1_1_1"


    // $ANTLR start "rule__UnitExpression__UnitAssignment_1_2"
    // InternalExprParser.g:10812:1: rule__UnitExpression__UnitAssignment_1_2 : ( ( RULE_ID ) ) ;
    public final void rule__UnitExpression__UnitAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10816:1: ( ( ( RULE_ID ) ) )
            // InternalExprParser.g:10817:1: ( ( RULE_ID ) )
            {
            // InternalExprParser.g:10817:1: ( ( RULE_ID ) )
            // InternalExprParser.g:10818:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnitExpressionAccess().getUnitUnitLiteralCrossReference_1_2_0()); 
            }
            // InternalExprParser.g:10819:1: ( RULE_ID )
            // InternalExprParser.g:10820:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnitExpressionAccess().getUnitUnitLiteralIDTerminalRuleCall_1_2_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnitExpressionAccess().getUnitUnitLiteralIDTerminalRuleCall_1_2_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnitExpressionAccess().getUnitUnitLiteralCrossReference_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnitExpression__UnitAssignment_1_2"


    // $ANTLR start "rule__VarRef__RefAssignment"
    // InternalExprParser.g:10831:1: rule__VarRef__RefAssignment : ( ( ruleQCREF ) ) ;
    public final void rule__VarRef__RefAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10835:1: ( ( ( ruleQCREF ) ) )
            // InternalExprParser.g:10836:1: ( ( ruleQCREF ) )
            {
            // InternalExprParser.g:10836:1: ( ( ruleQCREF ) )
            // InternalExprParser.g:10837:1: ( ruleQCREF )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarRefAccess().getRefVarDeclCrossReference_0()); 
            }
            // InternalExprParser.g:10838:1: ( ruleQCREF )
            // InternalExprParser.g:10839:1: ruleQCREF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarRefAccess().getRefVarDeclQCREFParserRuleCall_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarRefAccess().getRefVarDeclQCREFParserRuleCall_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarRefAccess().getRefVarDeclCrossReference_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarRef__RefAssignment"


    // $ANTLR start "rule__ModelOrPropertyReference__PropertyAssignment_0_1_1"
    // InternalExprParser.g:10850:1: rule__ModelOrPropertyReference__PropertyAssignment_0_1_1 : ( ( ruleQPREF ) ) ;
    public final void rule__ModelOrPropertyReference__PropertyAssignment_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10854:1: ( ( ( ruleQPREF ) ) )
            // InternalExprParser.g:10855:1: ( ( ruleQPREF ) )
            {
            // InternalExprParser.g:10855:1: ( ( ruleQPREF ) )
            // InternalExprParser.g:10856:1: ( ruleQPREF )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelOrPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_0_1_1_0()); 
            }
            // InternalExprParser.g:10857:1: ( ruleQPREF )
            // InternalExprParser.g:10858:1: ruleQPREF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelOrPropertyReferenceAccess().getPropertyAbstractNamedValueQPREFParserRuleCall_0_1_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelOrPropertyReferenceAccess().getPropertyAbstractNamedValueQPREFParserRuleCall_0_1_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelOrPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_0_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelOrPropertyReference__PropertyAssignment_0_1_1"


    // $ANTLR start "rule__ModelReference__ModelElementAssignment_0"
    // InternalExprParser.g:10869:1: rule__ModelReference__ModelElementAssignment_0 : ( ( ruleThis ) ) ;
    public final void rule__ModelReference__ModelElementAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10873:1: ( ( ( ruleThis ) ) )
            // InternalExprParser.g:10874:1: ( ( ruleThis ) )
            {
            // InternalExprParser.g:10874:1: ( ( ruleThis ) )
            // InternalExprParser.g:10875:1: ( ruleThis )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelReferenceAccess().getModelElementNamedElementCrossReference_0_0()); 
            }
            // InternalExprParser.g:10876:1: ( ruleThis )
            // InternalExprParser.g:10877:1: ruleThis
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelReferenceAccess().getModelElementNamedElementThisParserRuleCall_0_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleThis();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelReferenceAccess().getModelElementNamedElementThisParserRuleCall_0_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelReferenceAccess().getModelElementNamedElementCrossReference_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelReference__ModelElementAssignment_0"


    // $ANTLR start "rule__ModelReference__ModelElementAssignment_1_2"
    // InternalExprParser.g:10888:1: rule__ModelReference__ModelElementAssignment_1_2 : ( ( RULE_ID ) ) ;
    public final void rule__ModelReference__ModelElementAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10892:1: ( ( ( RULE_ID ) ) )
            // InternalExprParser.g:10893:1: ( ( RULE_ID ) )
            {
            // InternalExprParser.g:10893:1: ( ( RULE_ID ) )
            // InternalExprParser.g:10894:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelReferenceAccess().getModelElementNamedElementCrossReference_1_2_0()); 
            }
            // InternalExprParser.g:10895:1: ( RULE_ID )
            // InternalExprParser.g:10896:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelReferenceAccess().getModelElementNamedElementIDTerminalRuleCall_1_2_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelReferenceAccess().getModelElementNamedElementIDTerminalRuleCall_1_2_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelReferenceAccess().getModelElementNamedElementCrossReference_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelReference__ModelElementAssignment_1_2"


    // $ANTLR start "rule__PropertyReference__PropertyAssignment_2"
    // InternalExprParser.g:10907:1: rule__PropertyReference__PropertyAssignment_2 : ( ( ruleQPREF ) ) ;
    public final void rule__PropertyReference__PropertyAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10911:1: ( ( ( ruleQPREF ) ) )
            // InternalExprParser.g:10912:1: ( ( ruleQPREF ) )
            {
            // InternalExprParser.g:10912:1: ( ( ruleQPREF ) )
            // InternalExprParser.g:10913:1: ( ruleQPREF )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_2_0()); 
            }
            // InternalExprParser.g:10914:1: ( ruleQPREF )
            // InternalExprParser.g:10915:1: ruleQPREF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyReferenceAccess().getPropertyAbstractNamedValueQPREFParserRuleCall_2_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPropertyReferenceAccess().getPropertyAbstractNamedValueQPREFParserRuleCall_2_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyReference__PropertyAssignment_2"


    // $ANTLR start "rule__FunctionCall__FunctionAssignment_1"
    // InternalExprParser.g:10926:1: rule__FunctionCall__FunctionAssignment_1 : ( ruleQCREF ) ;
    public final void rule__FunctionCall__FunctionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10930:1: ( ( ruleQCREF ) )
            // InternalExprParser.g:10931:1: ( ruleQCREF )
            {
            // InternalExprParser.g:10931:1: ( ruleQCREF )
            // InternalExprParser.g:10932:1: ruleQCREF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionCallAccess().getFunctionQCREFParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionCallAccess().getFunctionQCREFParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__FunctionAssignment_1"


    // $ANTLR start "rule__FunctionCall__ArgumentsAssignment_3_0"
    // InternalExprParser.g:10941:1: rule__FunctionCall__ArgumentsAssignment_3_0 : ( ruleExpression ) ;
    public final void rule__FunctionCall__ArgumentsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10945:1: ( ( ruleExpression ) )
            // InternalExprParser.g:10946:1: ( ruleExpression )
            {
            // InternalExprParser.g:10946:1: ( ruleExpression )
            // InternalExprParser.g:10947:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionCallAccess().getArgumentsExpressionParserRuleCall_3_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionCallAccess().getArgumentsExpressionParserRuleCall_3_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__ArgumentsAssignment_3_0"


    // $ANTLR start "rule__FunctionCall__ArgumentsAssignment_3_1_1"
    // InternalExprParser.g:10956:1: rule__FunctionCall__ArgumentsAssignment_3_1_1 : ( ruleExpression ) ;
    public final void rule__FunctionCall__ArgumentsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10960:1: ( ( ruleExpression ) )
            // InternalExprParser.g:10961:1: ( ruleExpression )
            {
            // InternalExprParser.g:10961:1: ( ruleExpression )
            // InternalExprParser.g:10962:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionCallAccess().getArgumentsExpressionParserRuleCall_3_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunctionCallAccess().getArgumentsExpressionParserRuleCall_3_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__ArgumentsAssignment_3_1_1"


    // $ANTLR start "rule__RangeExpression__MinimumAssignment_2"
    // InternalExprParser.g:10971:1: rule__RangeExpression__MinimumAssignment_2 : ( ruleExpression ) ;
    public final void rule__RangeExpression__MinimumAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10975:1: ( ( ruleExpression ) )
            // InternalExprParser.g:10976:1: ( ruleExpression )
            {
            // InternalExprParser.g:10976:1: ( ruleExpression )
            // InternalExprParser.g:10977:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeExpressionAccess().getMinimumExpressionParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeExpressionAccess().getMinimumExpressionParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeExpression__MinimumAssignment_2"


    // $ANTLR start "rule__RangeExpression__MaximumAssignment_4"
    // InternalExprParser.g:10986:1: rule__RangeExpression__MaximumAssignment_4 : ( ruleExpression ) ;
    public final void rule__RangeExpression__MaximumAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10990:1: ( ( ruleExpression ) )
            // InternalExprParser.g:10991:1: ( ruleExpression )
            {
            // InternalExprParser.g:10991:1: ( ruleExpression )
            // InternalExprParser.g:10992:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeExpressionAccess().getMaximumExpressionParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeExpressionAccess().getMaximumExpressionParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeExpression__MaximumAssignment_4"


    // $ANTLR start "rule__RangeExpression__DeltaAssignment_5_1"
    // InternalExprParser.g:11001:1: rule__RangeExpression__DeltaAssignment_5_1 : ( ruleExpression ) ;
    public final void rule__RangeExpression__DeltaAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:11005:1: ( ( ruleExpression ) )
            // InternalExprParser.g:11006:1: ( ruleExpression )
            {
            // InternalExprParser.g:11006:1: ( ruleExpression )
            // InternalExprParser.g:11007:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeExpressionAccess().getDeltaExpressionParserRuleCall_5_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeExpressionAccess().getDeltaExpressionParserRuleCall_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeExpression__DeltaAssignment_5_1"


    // $ANTLR start "rule__IfExpression__IfAssignment_2"
    // InternalExprParser.g:11016:1: rule__IfExpression__IfAssignment_2 : ( ruleExpression ) ;
    public final void rule__IfExpression__IfAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:11020:1: ( ( ruleExpression ) )
            // InternalExprParser.g:11021:1: ( ruleExpression )
            {
            // InternalExprParser.g:11021:1: ( ruleExpression )
            // InternalExprParser.g:11022:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfExpressionAccess().getIfExpressionParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfExpressionAccess().getIfExpressionParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__IfAssignment_2"


    // $ANTLR start "rule__IfExpression__ThenAssignment_4"
    // InternalExprParser.g:11031:1: rule__IfExpression__ThenAssignment_4 : ( ruleExpression ) ;
    public final void rule__IfExpression__ThenAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:11035:1: ( ( ruleExpression ) )
            // InternalExprParser.g:11036:1: ( ruleExpression )
            {
            // InternalExprParser.g:11036:1: ( ruleExpression )
            // InternalExprParser.g:11037:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfExpressionAccess().getThenExpressionParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfExpressionAccess().getThenExpressionParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__ThenAssignment_4"


    // $ANTLR start "rule__IfExpression__ElseAssignment_5_1"
    // InternalExprParser.g:11046:1: rule__IfExpression__ElseAssignment_5_1 : ( ruleExpression ) ;
    public final void rule__IfExpression__ElseAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:11050:1: ( ( ruleExpression ) )
            // InternalExprParser.g:11051:1: ( ruleExpression )
            {
            // InternalExprParser.g:11051:1: ( ruleExpression )
            // InternalExprParser.g:11052:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfExpressionAccess().getElseExpressionParserRuleCall_5_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIfExpressionAccess().getElseExpressionParserRuleCall_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__ElseAssignment_5_1"


    // $ANTLR start "rule__BooleanLiteral__ValueAssignment_1_0"
    // InternalExprParser.g:11061:1: rule__BooleanLiteral__ValueAssignment_1_0 : ( ( True ) ) ;
    public final void rule__BooleanLiteral__ValueAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:11065:1: ( ( ( True ) ) )
            // InternalExprParser.g:11066:1: ( ( True ) )
            {
            // InternalExprParser.g:11066:1: ( ( True ) )
            // InternalExprParser.g:11067:1: ( True )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0()); 
            }
            // InternalExprParser.g:11068:1: ( True )
            // InternalExprParser.g:11069:1: True
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0()); 
            }
            match(input,True,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteral__ValueAssignment_1_0"


    // $ANTLR start "rule__IntegerLiteral__ValueAssignment_1"
    // InternalExprParser.g:11084:1: rule__IntegerLiteral__ValueAssignment_1 : ( RULE_INTEGER_LIT ) ;
    public final void rule__IntegerLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:11088:1: ( ( RULE_INTEGER_LIT ) )
            // InternalExprParser.g:11089:1: ( RULE_INTEGER_LIT )
            {
            // InternalExprParser.g:11089:1: ( RULE_INTEGER_LIT )
            // InternalExprParser.g:11090:1: RULE_INTEGER_LIT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralAccess().getValueINTEGER_LITTerminalRuleCall_1_0()); 
            }
            match(input,RULE_INTEGER_LIT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntegerLiteralAccess().getValueINTEGER_LITTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegerLiteral__ValueAssignment_1"


    // $ANTLR start "rule__RealLiteral__ValueAssignment_1"
    // InternalExprParser.g:11099:1: rule__RealLiteral__ValueAssignment_1 : ( RULE_REAL_LIT ) ;
    public final void rule__RealLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:11103:1: ( ( RULE_REAL_LIT ) )
            // InternalExprParser.g:11104:1: ( RULE_REAL_LIT )
            {
            // InternalExprParser.g:11104:1: ( RULE_REAL_LIT )
            // InternalExprParser.g:11105:1: RULE_REAL_LIT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getValueREAL_LITTerminalRuleCall_1_0()); 
            }
            match(input,RULE_REAL_LIT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRealLiteralAccess().getValueREAL_LITTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteral__ValueAssignment_1"


    // $ANTLR start "rule__StringLiteral__ValueAssignment_1"
    // InternalExprParser.g:11114:1: rule__StringLiteral__ValueAssignment_1 : ( ruleNoQuoteString ) ;
    public final void rule__StringLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:11118:1: ( ( ruleNoQuoteString ) )
            // InternalExprParser.g:11119:1: ( ruleNoQuoteString )
            {
            // InternalExprParser.g:11119:1: ( ruleNoQuoteString )
            // InternalExprParser.g:11120:1: ruleNoQuoteString
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getValueNoQuoteStringParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralAccess().getValueNoQuoteStringParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__ValueAssignment_1"


    // $ANTLR start "rule__CommaSeparatedExpressions__ElementsAssignment_0"
    // InternalExprParser.g:11129:1: rule__CommaSeparatedExpressions__ElementsAssignment_0 : ( ruleExpression ) ;
    public final void rule__CommaSeparatedExpressions__ElementsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:11133:1: ( ( ruleExpression ) )
            // InternalExprParser.g:11134:1: ( ruleExpression )
            {
            // InternalExprParser.g:11134:1: ( ruleExpression )
            // InternalExprParser.g:11135:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCommaSeparatedExpressionsAccess().getElementsExpressionParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCommaSeparatedExpressionsAccess().getElementsExpressionParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CommaSeparatedExpressions__ElementsAssignment_0"


    // $ANTLR start "rule__CommaSeparatedExpressions__ElementsAssignment_1_1"
    // InternalExprParser.g:11144:1: rule__CommaSeparatedExpressions__ElementsAssignment_1_1 : ( ruleExpression ) ;
    public final void rule__CommaSeparatedExpressions__ElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:11148:1: ( ( ruleExpression ) )
            // InternalExprParser.g:11149:1: ( ruleExpression )
            {
            // InternalExprParser.g:11149:1: ( ruleExpression )
            // InternalExprParser.g:11150:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCommaSeparatedExpressionsAccess().getElementsExpressionParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCommaSeparatedExpressionsAccess().getElementsExpressionParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CommaSeparatedExpressions__ElementsAssignment_1_1"

    // Delegated rules


    protected DFA6 dfa6 = new DFA6(this);
    protected DFA16 dfa16 = new DFA16(this);
    static final String dfa_1s = "\22\uffff";
    static final String dfa_2s = "\10\uffff\1\15\1\uffff\1\16\7\uffff";
    static final String dfa_3s = "\1\7\7\uffff\1\4\1\uffff\1\4\1\11\6\uffff";
    static final String dfa_4s = "\1\54\7\uffff\1\140\1\uffff\1\140\1\54\6\uffff";
    static final String dfa_5s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\2\uffff\1\11\1\10\1\14\1\13\1\15\1\16";
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
            "\6\15\1\uffff\1\15\1\uffff\1\15\1\uffff\10\15\3\uffff\1\14\4\15\1\uffff\4\15\7\uffff\2\15\2\uffff\2\15\2\uffff\1\15\4\uffff\1\15\26\uffff\1\15\1\uffff\1\15\4\uffff\1\15\11\uffff\1\15",
            "",
            "\6\16\1\uffff\1\16\1\uffff\1\16\1\uffff\10\16\3\uffff\1\17\4\16\1\uffff\4\16\7\uffff\2\16\2\uffff\2\16\2\uffff\1\16\4\uffff\1\16\26\uffff\1\16\1\uffff\1\16\4\uffff\1\16\11\uffff\1\16",
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

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "2170:1: rule__ComponentCategory__Alternatives : ( ( Abstract ) | ( Bus ) | ( Data ) | ( Device ) | ( Memory ) | ( Process ) | ( Processor ) | ( Subprogram ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( KW_System ) | ( ( rule__ComponentCategory__Group_10__0 ) ) | ( Thread ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( ( rule__ComponentCategory__Group_13__0 ) ) );";
        }
    }
    static final String dfa_8s = "\14\uffff";
    static final String dfa_9s = "\1\uffff\1\12\11\uffff\1\12";
    static final String dfa_10s = "\1\23\1\27\5\uffff\1\140\1\uffff\1\140\1\uffff\1\27";
    static final String dfa_11s = "\2\140\5\uffff\1\140\1\uffff\1\140\1\uffff\1\140";
    static final String dfa_12s = "\2\uffff\1\2\1\4\1\5\1\6\1\7\1\uffff\1\3\1\uffff\1\1\1\uffff";
    static final String dfa_13s = "\14\uffff}>";
    static final String[] dfa_14s = {
            "\1\5\5\uffff\1\5\1\uffff\2\5\4\uffff\1\5\4\uffff\1\2\1\5\3\uffff\1\5\4\uffff\1\5\2\uffff\1\5\13\uffff\1\4\4\uffff\1\2\1\uffff\1\6\14\uffff\1\3\7\uffff\1\5\1\uffff\1\5\1\uffff\1\5\1\1",
            "\2\12\6\uffff\1\12\5\uffff\1\12\4\uffff\1\12\3\uffff\1\12\2\uffff\1\12\4\uffff\2\12\1\uffff\1\12\1\11\4\12\1\uffff\1\12\1\uffff\2\12\1\uffff\1\12\1\10\5\12\1\7\1\12\1\uffff\2\12\1\uffff\1\12\1\uffff\1\12\13\uffff\1\12",
            "",
            "",
            "",
            "",
            "",
            "\1\13",
            "",
            "\1\1",
            "",
            "\2\12\6\uffff\1\12\5\uffff\1\12\4\uffff\1\12\3\uffff\1\12\2\uffff\1\12\4\uffff\2\12\1\uffff\1\12\1\uffff\4\12\1\uffff\1\12\1\uffff\2\12\1\uffff\1\12\1\10\5\12\1\uffff\1\12\1\uffff\2\12\1\uffff\1\12\1\uffff\1\12\13\uffff\1\12"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "2558:1: rule__PrimaryExpression__Alternatives : ( ( ruleVarRef ) | ( ruleModelOrPropertyReference ) | ( ruleFunctionCall ) | ( ruleRangeExpression ) | ( ruleIfExpression ) | ( ruleLiteral ) | ( ( rule__PrimaryExpression__Group_6__0 ) ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0030210000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0009980F787FABF0L,0x0000000100000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0030000000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000000000024000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x800D98CF7A7FABF0L,0x00000001A8080A50L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000800820100000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000000100400000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0009980F787FABF0L,0x0000000100400000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0009980F787FABF2L,0x0000000100000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0080040000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0080040000000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x1040000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x1040000000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x6800000000000000L,0x0000000000050000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x6800000000000002L,0x0000000000050000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000A00L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000A00L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0002400000000000L,0x0000000000002100L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0002400000000002L,0x0000000000002100L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0004000000000000L,0x0000000000000A00L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000021L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x800D98CF7A7FABF0L,0x00000001A8080AD0L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000800000L,0x0000000000100000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000081000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000008002000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x000908821A080000L,0x00000000A8000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0400000000000000L});

}