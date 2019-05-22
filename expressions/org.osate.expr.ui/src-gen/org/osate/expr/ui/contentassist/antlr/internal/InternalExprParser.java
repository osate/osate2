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


    // $ANTLR start "entryRuleExprLibrary"
    // InternalExprParser.g:173:1: entryRuleExprLibrary : ruleExprLibrary EOF ;
    public final void entryRuleExprLibrary() throws RecognitionException {
        try {
            // InternalExprParser.g:174:1: ( ruleExprLibrary EOF )
            // InternalExprParser.g:175:1: ruleExprLibrary EOF
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
    // InternalExprParser.g:182:1: ruleExprLibrary : ( ( rule__ExprLibrary__Group__0 ) ) ;
    public final void ruleExprLibrary() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:186:5: ( ( ( rule__ExprLibrary__Group__0 ) ) )
            // InternalExprParser.g:187:1: ( ( rule__ExprLibrary__Group__0 ) )
            {
            // InternalExprParser.g:187:1: ( ( rule__ExprLibrary__Group__0 ) )
            // InternalExprParser.g:188:1: ( rule__ExprLibrary__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprLibraryAccess().getGroup()); 
            }
            // InternalExprParser.g:189:1: ( rule__ExprLibrary__Group__0 )
            // InternalExprParser.g:189:2: rule__ExprLibrary__Group__0
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
    // InternalExprParser.g:201:1: entryRuleExprSubclause : ruleExprSubclause EOF ;
    public final void entryRuleExprSubclause() throws RecognitionException {
        try {
            // InternalExprParser.g:202:1: ( ruleExprSubclause EOF )
            // InternalExprParser.g:203:1: ruleExprSubclause EOF
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
    // InternalExprParser.g:210:1: ruleExprSubclause : ( ( rule__ExprSubclause__Group__0 ) ) ;
    public final void ruleExprSubclause() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:214:5: ( ( ( rule__ExprSubclause__Group__0 ) ) )
            // InternalExprParser.g:215:1: ( ( rule__ExprSubclause__Group__0 ) )
            {
            // InternalExprParser.g:215:1: ( ( rule__ExprSubclause__Group__0 ) )
            // InternalExprParser.g:216:1: ( rule__ExprSubclause__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprSubclauseAccess().getGroup()); 
            }
            // InternalExprParser.g:217:1: ( rule__ExprSubclause__Group__0 )
            // InternalExprParser.g:217:2: rule__ExprSubclause__Group__0
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
    // InternalExprParser.g:231:1: entryRuleDeclaration : ruleDeclaration EOF ;
    public final void entryRuleDeclaration() throws RecognitionException {
        try {
            // InternalExprParser.g:232:1: ( ruleDeclaration EOF )
            // InternalExprParser.g:233:1: ruleDeclaration EOF
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
    // InternalExprParser.g:240:1: ruleDeclaration : ( ( rule__Declaration__Alternatives ) ) ;
    public final void ruleDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:244:5: ( ( ( rule__Declaration__Alternatives ) ) )
            // InternalExprParser.g:245:1: ( ( rule__Declaration__Alternatives ) )
            {
            // InternalExprParser.g:245:1: ( ( rule__Declaration__Alternatives ) )
            // InternalExprParser.g:246:1: ( rule__Declaration__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclarationAccess().getAlternatives()); 
            }
            // InternalExprParser.g:247:1: ( rule__Declaration__Alternatives )
            // InternalExprParser.g:247:2: rule__Declaration__Alternatives
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
    // InternalExprParser.g:259:1: entryRuleTypeDecl : ruleTypeDecl EOF ;
    public final void entryRuleTypeDecl() throws RecognitionException {
        try {
            // InternalExprParser.g:260:1: ( ruleTypeDecl EOF )
            // InternalExprParser.g:261:1: ruleTypeDecl EOF
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
    // InternalExprParser.g:268:1: ruleTypeDecl : ( ( rule__TypeDecl__Group__0 ) ) ;
    public final void ruleTypeDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:272:5: ( ( ( rule__TypeDecl__Group__0 ) ) )
            // InternalExprParser.g:273:1: ( ( rule__TypeDecl__Group__0 ) )
            {
            // InternalExprParser.g:273:1: ( ( rule__TypeDecl__Group__0 ) )
            // InternalExprParser.g:274:1: ( rule__TypeDecl__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDeclAccess().getGroup()); 
            }
            // InternalExprParser.g:275:1: ( rule__TypeDecl__Group__0 )
            // InternalExprParser.g:275:2: rule__TypeDecl__Group__0
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
    // InternalExprParser.g:287:1: entryRuleVarDecl : ruleVarDecl EOF ;
    public final void entryRuleVarDecl() throws RecognitionException {
        try {
            // InternalExprParser.g:288:1: ( ruleVarDecl EOF )
            // InternalExprParser.g:289:1: ruleVarDecl EOF
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
    // InternalExprParser.g:296:1: ruleVarDecl : ( ( rule__VarDecl__Group__0 ) ) ;
    public final void ruleVarDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:300:5: ( ( ( rule__VarDecl__Group__0 ) ) )
            // InternalExprParser.g:301:1: ( ( rule__VarDecl__Group__0 ) )
            {
            // InternalExprParser.g:301:1: ( ( rule__VarDecl__Group__0 ) )
            // InternalExprParser.g:302:1: ( rule__VarDecl__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getGroup()); 
            }
            // InternalExprParser.g:303:1: ( rule__VarDecl__Group__0 )
            // InternalExprParser.g:303:2: rule__VarDecl__Group__0
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
    // InternalExprParser.g:315:1: entryRuleFunDecl : ruleFunDecl EOF ;
    public final void entryRuleFunDecl() throws RecognitionException {
        try {
            // InternalExprParser.g:316:1: ( ruleFunDecl EOF )
            // InternalExprParser.g:317:1: ruleFunDecl EOF
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
    // InternalExprParser.g:324:1: ruleFunDecl : ( ( rule__FunDecl__Group__0 ) ) ;
    public final void ruleFunDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:328:5: ( ( ( rule__FunDecl__Group__0 ) ) )
            // InternalExprParser.g:329:1: ( ( rule__FunDecl__Group__0 ) )
            {
            // InternalExprParser.g:329:1: ( ( rule__FunDecl__Group__0 ) )
            // InternalExprParser.g:330:1: ( rule__FunDecl__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunDeclAccess().getGroup()); 
            }
            // InternalExprParser.g:331:1: ( rule__FunDecl__Group__0 )
            // InternalExprParser.g:331:2: rule__FunDecl__Group__0
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
    // InternalExprParser.g:343:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // InternalExprParser.g:344:1: ( ruleType EOF )
            // InternalExprParser.g:345:1: ruleType EOF
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
    // InternalExprParser.g:352:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:356:5: ( ( ( rule__Type__Alternatives ) ) )
            // InternalExprParser.g:357:1: ( ( rule__Type__Alternatives ) )
            {
            // InternalExprParser.g:357:1: ( ( rule__Type__Alternatives ) )
            // InternalExprParser.g:358:1: ( rule__Type__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAccess().getAlternatives()); 
            }
            // InternalExprParser.g:359:1: ( rule__Type__Alternatives )
            // InternalExprParser.g:359:2: rule__Type__Alternatives
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
    // InternalExprParser.g:371:1: entryRulePrimitiveType : rulePrimitiveType EOF ;
    public final void entryRulePrimitiveType() throws RecognitionException {
        try {
            // InternalExprParser.g:372:1: ( rulePrimitiveType EOF )
            // InternalExprParser.g:373:1: rulePrimitiveType EOF
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
    // InternalExprParser.g:380:1: rulePrimitiveType : ( ( rule__PrimitiveType__Alternatives ) ) ;
    public final void rulePrimitiveType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:384:5: ( ( ( rule__PrimitiveType__Alternatives ) ) )
            // InternalExprParser.g:385:1: ( ( rule__PrimitiveType__Alternatives ) )
            {
            // InternalExprParser.g:385:1: ( ( rule__PrimitiveType__Alternatives ) )
            // InternalExprParser.g:386:1: ( rule__PrimitiveType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveTypeAccess().getAlternatives()); 
            }
            // InternalExprParser.g:387:1: ( rule__PrimitiveType__Alternatives )
            // InternalExprParser.g:387:2: rule__PrimitiveType__Alternatives
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
    // InternalExprParser.g:399:1: entryRuleCategory : ruleCategory EOF ;
    public final void entryRuleCategory() throws RecognitionException {
        try {
            // InternalExprParser.g:400:1: ( ruleCategory EOF )
            // InternalExprParser.g:401:1: ruleCategory EOF
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
    // InternalExprParser.g:408:1: ruleCategory : ( ( rule__Category__CategoryAssignment ) ) ;
    public final void ruleCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:412:5: ( ( ( rule__Category__CategoryAssignment ) ) )
            // InternalExprParser.g:413:1: ( ( rule__Category__CategoryAssignment ) )
            {
            // InternalExprParser.g:413:1: ( ( rule__Category__CategoryAssignment ) )
            // InternalExprParser.g:414:1: ( rule__Category__CategoryAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCategoryAccess().getCategoryAssignment()); 
            }
            // InternalExprParser.g:415:1: ( rule__Category__CategoryAssignment )
            // InternalExprParser.g:415:2: rule__Category__CategoryAssignment
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
    // InternalExprParser.g:427:1: entryRuleComponentCategory : ruleComponentCategory EOF ;
    public final void entryRuleComponentCategory() throws RecognitionException {
        try {
            // InternalExprParser.g:428:1: ( ruleComponentCategory EOF )
            // InternalExprParser.g:429:1: ruleComponentCategory EOF
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
    // InternalExprParser.g:436:1: ruleComponentCategory : ( ( rule__ComponentCategory__Alternatives ) ) ;
    public final void ruleComponentCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:440:5: ( ( ( rule__ComponentCategory__Alternatives ) ) )
            // InternalExprParser.g:441:1: ( ( rule__ComponentCategory__Alternatives ) )
            {
            // InternalExprParser.g:441:1: ( ( rule__ComponentCategory__Alternatives ) )
            // InternalExprParser.g:442:1: ( rule__ComponentCategory__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComponentCategoryAccess().getAlternatives()); 
            }
            // InternalExprParser.g:443:1: ( rule__ComponentCategory__Alternatives )
            // InternalExprParser.g:443:2: rule__ComponentCategory__Alternatives
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
    // InternalExprParser.g:455:1: entryRuleMetaClass : ruleMetaClass EOF ;
    public final void entryRuleMetaClass() throws RecognitionException {
        try {
            // InternalExprParser.g:456:1: ( ruleMetaClass EOF )
            // InternalExprParser.g:457:1: ruleMetaClass EOF
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
    // InternalExprParser.g:464:1: ruleMetaClass : ( ( rule__MetaClass__ClassAssignment ) ) ;
    public final void ruleMetaClass() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:468:5: ( ( ( rule__MetaClass__ClassAssignment ) ) )
            // InternalExprParser.g:469:1: ( ( rule__MetaClass__ClassAssignment ) )
            {
            // InternalExprParser.g:469:1: ( ( rule__MetaClass__ClassAssignment ) )
            // InternalExprParser.g:470:1: ( rule__MetaClass__ClassAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetaClassAccess().getClassAssignment()); 
            }
            // InternalExprParser.g:471:1: ( rule__MetaClass__ClassAssignment )
            // InternalExprParser.g:471:2: rule__MetaClass__ClassAssignment
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
    // InternalExprParser.g:483:1: entryRuleClassifierType : ruleClassifierType EOF ;
    public final void entryRuleClassifierType() throws RecognitionException {
        try {
            // InternalExprParser.g:484:1: ( ruleClassifierType EOF )
            // InternalExprParser.g:485:1: ruleClassifierType EOF
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
    // InternalExprParser.g:492:1: ruleClassifierType : ( ( rule__ClassifierType__Group__0 ) ) ;
    public final void ruleClassifierType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:496:5: ( ( ( rule__ClassifierType__Group__0 ) ) )
            // InternalExprParser.g:497:1: ( ( rule__ClassifierType__Group__0 ) )
            {
            // InternalExprParser.g:497:1: ( ( rule__ClassifierType__Group__0 ) )
            // InternalExprParser.g:498:1: ( rule__ClassifierType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeAccess().getGroup()); 
            }
            // InternalExprParser.g:499:1: ( rule__ClassifierType__Group__0 )
            // InternalExprParser.g:499:2: rule__ClassifierType__Group__0
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
    // InternalExprParser.g:511:1: entryRuleRecordType : ruleRecordType EOF ;
    public final void entryRuleRecordType() throws RecognitionException {
        try {
            // InternalExprParser.g:512:1: ( ruleRecordType EOF )
            // InternalExprParser.g:513:1: ruleRecordType EOF
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
    // InternalExprParser.g:520:1: ruleRecordType : ( ( rule__RecordType__Group__0 ) ) ;
    public final void ruleRecordType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:524:5: ( ( ( rule__RecordType__Group__0 ) ) )
            // InternalExprParser.g:525:1: ( ( rule__RecordType__Group__0 ) )
            {
            // InternalExprParser.g:525:1: ( ( rule__RecordType__Group__0 ) )
            // InternalExprParser.g:526:1: ( rule__RecordType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecordTypeAccess().getGroup()); 
            }
            // InternalExprParser.g:527:1: ( rule__RecordType__Group__0 )
            // InternalExprParser.g:527:2: rule__RecordType__Group__0
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
    // InternalExprParser.g:539:1: entryRuleField : ruleField EOF ;
    public final void entryRuleField() throws RecognitionException {
        try {
            // InternalExprParser.g:540:1: ( ruleField EOF )
            // InternalExprParser.g:541:1: ruleField EOF
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
    // InternalExprParser.g:548:1: ruleField : ( ( rule__Field__Group__0 ) ) ;
    public final void ruleField() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:552:5: ( ( ( rule__Field__Group__0 ) ) )
            // InternalExprParser.g:553:1: ( ( rule__Field__Group__0 ) )
            {
            // InternalExprParser.g:553:1: ( ( rule__Field__Group__0 ) )
            // InternalExprParser.g:554:1: ( rule__Field__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getGroup()); 
            }
            // InternalExprParser.g:555:1: ( rule__Field__Group__0 )
            // InternalExprParser.g:555:2: rule__Field__Group__0
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
    // InternalExprParser.g:567:1: entryRuleUnionType : ruleUnionType EOF ;
    public final void entryRuleUnionType() throws RecognitionException {
        try {
            // InternalExprParser.g:568:1: ( ruleUnionType EOF )
            // InternalExprParser.g:569:1: ruleUnionType EOF
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
    // InternalExprParser.g:576:1: ruleUnionType : ( ( rule__UnionType__Group__0 ) ) ;
    public final void ruleUnionType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:580:5: ( ( ( rule__UnionType__Group__0 ) ) )
            // InternalExprParser.g:581:1: ( ( rule__UnionType__Group__0 ) )
            {
            // InternalExprParser.g:581:1: ( ( rule__UnionType__Group__0 ) )
            // InternalExprParser.g:582:1: ( rule__UnionType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnionTypeAccess().getGroup()); 
            }
            // InternalExprParser.g:583:1: ( rule__UnionType__Group__0 )
            // InternalExprParser.g:583:2: rule__UnionType__Group__0
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
    // InternalExprParser.g:595:1: entryRuleTupleType : ruleTupleType EOF ;
    public final void entryRuleTupleType() throws RecognitionException {
        try {
            // InternalExprParser.g:596:1: ( ruleTupleType EOF )
            // InternalExprParser.g:597:1: ruleTupleType EOF
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
    // InternalExprParser.g:604:1: ruleTupleType : ( ( rule__TupleType__Group__0 ) ) ;
    public final void ruleTupleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:608:5: ( ( ( rule__TupleType__Group__0 ) ) )
            // InternalExprParser.g:609:1: ( ( rule__TupleType__Group__0 ) )
            {
            // InternalExprParser.g:609:1: ( ( rule__TupleType__Group__0 ) )
            // InternalExprParser.g:610:1: ( rule__TupleType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleTypeAccess().getGroup()); 
            }
            // InternalExprParser.g:611:1: ( rule__TupleType__Group__0 )
            // InternalExprParser.g:611:2: rule__TupleType__Group__0
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
    // InternalExprParser.g:623:1: entryRuleTupleField : ruleTupleField EOF ;
    public final void entryRuleTupleField() throws RecognitionException {
        try {
            // InternalExprParser.g:624:1: ( ruleTupleField EOF )
            // InternalExprParser.g:625:1: ruleTupleField EOF
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
    // InternalExprParser.g:632:1: ruleTupleField : ( ( rule__TupleField__Group__0 ) ) ;
    public final void ruleTupleField() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:636:5: ( ( ( rule__TupleField__Group__0 ) ) )
            // InternalExprParser.g:637:1: ( ( rule__TupleField__Group__0 ) )
            {
            // InternalExprParser.g:637:1: ( ( rule__TupleField__Group__0 ) )
            // InternalExprParser.g:638:1: ( rule__TupleField__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleFieldAccess().getGroup()); 
            }
            // InternalExprParser.g:639:1: ( rule__TupleField__Group__0 )
            // InternalExprParser.g:639:2: rule__TupleField__Group__0
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
    // InternalExprParser.g:651:1: entryRuleListType : ruleListType EOF ;
    public final void entryRuleListType() throws RecognitionException {
        try {
            // InternalExprParser.g:652:1: ( ruleListType EOF )
            // InternalExprParser.g:653:1: ruleListType EOF
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
    // InternalExprParser.g:660:1: ruleListType : ( ( rule__ListType__Group__0 ) ) ;
    public final void ruleListType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:664:5: ( ( ( rule__ListType__Group__0 ) ) )
            // InternalExprParser.g:665:1: ( ( rule__ListType__Group__0 ) )
            {
            // InternalExprParser.g:665:1: ( ( rule__ListType__Group__0 ) )
            // InternalExprParser.g:666:1: ( rule__ListType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListTypeAccess().getGroup()); 
            }
            // InternalExprParser.g:667:1: ( rule__ListType__Group__0 )
            // InternalExprParser.g:667:2: rule__ListType__Group__0
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
    // InternalExprParser.g:679:1: entryRuleSetType : ruleSetType EOF ;
    public final void entryRuleSetType() throws RecognitionException {
        try {
            // InternalExprParser.g:680:1: ( ruleSetType EOF )
            // InternalExprParser.g:681:1: ruleSetType EOF
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
    // InternalExprParser.g:688:1: ruleSetType : ( ( rule__SetType__Group__0 ) ) ;
    public final void ruleSetType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:692:5: ( ( ( rule__SetType__Group__0 ) ) )
            // InternalExprParser.g:693:1: ( ( rule__SetType__Group__0 ) )
            {
            // InternalExprParser.g:693:1: ( ( rule__SetType__Group__0 ) )
            // InternalExprParser.g:694:1: ( rule__SetType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSetTypeAccess().getGroup()); 
            }
            // InternalExprParser.g:695:1: ( rule__SetType__Group__0 )
            // InternalExprParser.g:695:2: rule__SetType__Group__0
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
    // InternalExprParser.g:707:1: entryRuleBagType : ruleBagType EOF ;
    public final void entryRuleBagType() throws RecognitionException {
        try {
            // InternalExprParser.g:708:1: ( ruleBagType EOF )
            // InternalExprParser.g:709:1: ruleBagType EOF
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
    // InternalExprParser.g:716:1: ruleBagType : ( ( rule__BagType__Group__0 ) ) ;
    public final void ruleBagType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:720:5: ( ( ( rule__BagType__Group__0 ) ) )
            // InternalExprParser.g:721:1: ( ( rule__BagType__Group__0 ) )
            {
            // InternalExprParser.g:721:1: ( ( rule__BagType__Group__0 ) )
            // InternalExprParser.g:722:1: ( rule__BagType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBagTypeAccess().getGroup()); 
            }
            // InternalExprParser.g:723:1: ( rule__BagType__Group__0 )
            // InternalExprParser.g:723:2: rule__BagType__Group__0
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
    // InternalExprParser.g:735:1: entryRuleMapType : ruleMapType EOF ;
    public final void entryRuleMapType() throws RecognitionException {
        try {
            // InternalExprParser.g:736:1: ( ruleMapType EOF )
            // InternalExprParser.g:737:1: ruleMapType EOF
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
    // InternalExprParser.g:744:1: ruleMapType : ( ( rule__MapType__Group__0 ) ) ;
    public final void ruleMapType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:748:5: ( ( ( rule__MapType__Group__0 ) ) )
            // InternalExprParser.g:749:1: ( ( rule__MapType__Group__0 ) )
            {
            // InternalExprParser.g:749:1: ( ( rule__MapType__Group__0 ) )
            // InternalExprParser.g:750:1: ( rule__MapType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMapTypeAccess().getGroup()); 
            }
            // InternalExprParser.g:751:1: ( rule__MapType__Group__0 )
            // InternalExprParser.g:751:2: rule__MapType__Group__0
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
    // InternalExprParser.g:763:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // InternalExprParser.g:764:1: ( ruleTypeRef EOF )
            // InternalExprParser.g:765:1: ruleTypeRef EOF
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
    // InternalExprParser.g:772:1: ruleTypeRef : ( ( rule__TypeRef__RefAssignment ) ) ;
    public final void ruleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:776:5: ( ( ( rule__TypeRef__RefAssignment ) ) )
            // InternalExprParser.g:777:1: ( ( rule__TypeRef__RefAssignment ) )
            {
            // InternalExprParser.g:777:1: ( ( rule__TypeRef__RefAssignment ) )
            // InternalExprParser.g:778:1: ( rule__TypeRef__RefAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRefAccess().getRefAssignment()); 
            }
            // InternalExprParser.g:779:1: ( rule__TypeRef__RefAssignment )
            // InternalExprParser.g:779:2: rule__TypeRef__RefAssignment
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
    // InternalExprParser.g:791:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:792:1: ( ruleExpression EOF )
            // InternalExprParser.g:793:1: ruleExpression EOF
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
    // InternalExprParser.g:800:1: ruleExpression : ( ruleOrExpression ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:804:5: ( ( ruleOrExpression ) )
            // InternalExprParser.g:805:1: ( ruleOrExpression )
            {
            // InternalExprParser.g:805:1: ( ruleOrExpression )
            // InternalExprParser.g:806:1: ruleOrExpression
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
    // InternalExprParser.g:819:1: entryRuleOrExpression : ruleOrExpression EOF ;
    public final void entryRuleOrExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:820:1: ( ruleOrExpression EOF )
            // InternalExprParser.g:821:1: ruleOrExpression EOF
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
    // InternalExprParser.g:828:1: ruleOrExpression : ( ( rule__OrExpression__Group__0 ) ) ;
    public final void ruleOrExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:832:5: ( ( ( rule__OrExpression__Group__0 ) ) )
            // InternalExprParser.g:833:1: ( ( rule__OrExpression__Group__0 ) )
            {
            // InternalExprParser.g:833:1: ( ( rule__OrExpression__Group__0 ) )
            // InternalExprParser.g:834:1: ( rule__OrExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionAccess().getGroup()); 
            }
            // InternalExprParser.g:835:1: ( rule__OrExpression__Group__0 )
            // InternalExprParser.g:835:2: rule__OrExpression__Group__0
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
    // InternalExprParser.g:847:1: entryRuleOpOr : ruleOpOr EOF ;
    public final void entryRuleOpOr() throws RecognitionException {
        try {
            // InternalExprParser.g:848:1: ( ruleOpOr EOF )
            // InternalExprParser.g:849:1: ruleOpOr EOF
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
    // InternalExprParser.g:856:1: ruleOpOr : ( ( rule__OpOr__Alternatives ) ) ;
    public final void ruleOpOr() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:860:5: ( ( ( rule__OpOr__Alternatives ) ) )
            // InternalExprParser.g:861:1: ( ( rule__OpOr__Alternatives ) )
            {
            // InternalExprParser.g:861:1: ( ( rule__OpOr__Alternatives ) )
            // InternalExprParser.g:862:1: ( rule__OpOr__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOrAccess().getAlternatives()); 
            }
            // InternalExprParser.g:863:1: ( rule__OpOr__Alternatives )
            // InternalExprParser.g:863:2: rule__OpOr__Alternatives
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
    // InternalExprParser.g:875:1: entryRuleAndExpression : ruleAndExpression EOF ;
    public final void entryRuleAndExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:876:1: ( ruleAndExpression EOF )
            // InternalExprParser.g:877:1: ruleAndExpression EOF
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
    // InternalExprParser.g:884:1: ruleAndExpression : ( ( rule__AndExpression__Group__0 ) ) ;
    public final void ruleAndExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:888:5: ( ( ( rule__AndExpression__Group__0 ) ) )
            // InternalExprParser.g:889:1: ( ( rule__AndExpression__Group__0 ) )
            {
            // InternalExprParser.g:889:1: ( ( rule__AndExpression__Group__0 ) )
            // InternalExprParser.g:890:1: ( rule__AndExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionAccess().getGroup()); 
            }
            // InternalExprParser.g:891:1: ( rule__AndExpression__Group__0 )
            // InternalExprParser.g:891:2: rule__AndExpression__Group__0
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
    // InternalExprParser.g:903:1: entryRuleOpAnd : ruleOpAnd EOF ;
    public final void entryRuleOpAnd() throws RecognitionException {
        try {
            // InternalExprParser.g:904:1: ( ruleOpAnd EOF )
            // InternalExprParser.g:905:1: ruleOpAnd EOF
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
    // InternalExprParser.g:912:1: ruleOpAnd : ( ( rule__OpAnd__Alternatives ) ) ;
    public final void ruleOpAnd() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:916:5: ( ( ( rule__OpAnd__Alternatives ) ) )
            // InternalExprParser.g:917:1: ( ( rule__OpAnd__Alternatives ) )
            {
            // InternalExprParser.g:917:1: ( ( rule__OpAnd__Alternatives ) )
            // InternalExprParser.g:918:1: ( rule__OpAnd__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpAndAccess().getAlternatives()); 
            }
            // InternalExprParser.g:919:1: ( rule__OpAnd__Alternatives )
            // InternalExprParser.g:919:2: rule__OpAnd__Alternatives
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
    // InternalExprParser.g:931:1: entryRuleEqualityExpression : ruleEqualityExpression EOF ;
    public final void entryRuleEqualityExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:932:1: ( ruleEqualityExpression EOF )
            // InternalExprParser.g:933:1: ruleEqualityExpression EOF
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
    // InternalExprParser.g:940:1: ruleEqualityExpression : ( ( rule__EqualityExpression__Group__0 ) ) ;
    public final void ruleEqualityExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:944:5: ( ( ( rule__EqualityExpression__Group__0 ) ) )
            // InternalExprParser.g:945:1: ( ( rule__EqualityExpression__Group__0 ) )
            {
            // InternalExprParser.g:945:1: ( ( rule__EqualityExpression__Group__0 ) )
            // InternalExprParser.g:946:1: ( rule__EqualityExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpressionAccess().getGroup()); 
            }
            // InternalExprParser.g:947:1: ( rule__EqualityExpression__Group__0 )
            // InternalExprParser.g:947:2: rule__EqualityExpression__Group__0
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
    // InternalExprParser.g:959:1: entryRuleOpEquality : ruleOpEquality EOF ;
    public final void entryRuleOpEquality() throws RecognitionException {
        try {
            // InternalExprParser.g:960:1: ( ruleOpEquality EOF )
            // InternalExprParser.g:961:1: ruleOpEquality EOF
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
    // InternalExprParser.g:968:1: ruleOpEquality : ( ( rule__OpEquality__Alternatives ) ) ;
    public final void ruleOpEquality() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:972:5: ( ( ( rule__OpEquality__Alternatives ) ) )
            // InternalExprParser.g:973:1: ( ( rule__OpEquality__Alternatives ) )
            {
            // InternalExprParser.g:973:1: ( ( rule__OpEquality__Alternatives ) )
            // InternalExprParser.g:974:1: ( rule__OpEquality__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpEqualityAccess().getAlternatives()); 
            }
            // InternalExprParser.g:975:1: ( rule__OpEquality__Alternatives )
            // InternalExprParser.g:975:2: rule__OpEquality__Alternatives
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
    // InternalExprParser.g:987:1: entryRuleRelationalExpression : ruleRelationalExpression EOF ;
    public final void entryRuleRelationalExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:988:1: ( ruleRelationalExpression EOF )
            // InternalExprParser.g:989:1: ruleRelationalExpression EOF
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
    // InternalExprParser.g:996:1: ruleRelationalExpression : ( ( rule__RelationalExpression__Group__0 ) ) ;
    public final void ruleRelationalExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1000:5: ( ( ( rule__RelationalExpression__Group__0 ) ) )
            // InternalExprParser.g:1001:1: ( ( rule__RelationalExpression__Group__0 ) )
            {
            // InternalExprParser.g:1001:1: ( ( rule__RelationalExpression__Group__0 ) )
            // InternalExprParser.g:1002:1: ( rule__RelationalExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRelationalExpressionAccess().getGroup()); 
            }
            // InternalExprParser.g:1003:1: ( rule__RelationalExpression__Group__0 )
            // InternalExprParser.g:1003:2: rule__RelationalExpression__Group__0
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
    // InternalExprParser.g:1015:1: entryRuleOpCompare : ruleOpCompare EOF ;
    public final void entryRuleOpCompare() throws RecognitionException {
        try {
            // InternalExprParser.g:1016:1: ( ruleOpCompare EOF )
            // InternalExprParser.g:1017:1: ruleOpCompare EOF
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
    // InternalExprParser.g:1024:1: ruleOpCompare : ( ( rule__OpCompare__Alternatives ) ) ;
    public final void ruleOpCompare() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1028:5: ( ( ( rule__OpCompare__Alternatives ) ) )
            // InternalExprParser.g:1029:1: ( ( rule__OpCompare__Alternatives ) )
            {
            // InternalExprParser.g:1029:1: ( ( rule__OpCompare__Alternatives ) )
            // InternalExprParser.g:1030:1: ( rule__OpCompare__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpCompareAccess().getAlternatives()); 
            }
            // InternalExprParser.g:1031:1: ( rule__OpCompare__Alternatives )
            // InternalExprParser.g:1031:2: rule__OpCompare__Alternatives
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
    // InternalExprParser.g:1043:1: entryRuleAdditiveExpression : ruleAdditiveExpression EOF ;
    public final void entryRuleAdditiveExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:1044:1: ( ruleAdditiveExpression EOF )
            // InternalExprParser.g:1045:1: ruleAdditiveExpression EOF
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
    // InternalExprParser.g:1052:1: ruleAdditiveExpression : ( ( rule__AdditiveExpression__Group__0 ) ) ;
    public final void ruleAdditiveExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1056:5: ( ( ( rule__AdditiveExpression__Group__0 ) ) )
            // InternalExprParser.g:1057:1: ( ( rule__AdditiveExpression__Group__0 ) )
            {
            // InternalExprParser.g:1057:1: ( ( rule__AdditiveExpression__Group__0 ) )
            // InternalExprParser.g:1058:1: ( rule__AdditiveExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExpressionAccess().getGroup()); 
            }
            // InternalExprParser.g:1059:1: ( rule__AdditiveExpression__Group__0 )
            // InternalExprParser.g:1059:2: rule__AdditiveExpression__Group__0
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
    // InternalExprParser.g:1071:1: entryRuleOpAdd : ruleOpAdd EOF ;
    public final void entryRuleOpAdd() throws RecognitionException {
        try {
            // InternalExprParser.g:1072:1: ( ruleOpAdd EOF )
            // InternalExprParser.g:1073:1: ruleOpAdd EOF
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
    // InternalExprParser.g:1080:1: ruleOpAdd : ( ( rule__OpAdd__Alternatives ) ) ;
    public final void ruleOpAdd() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1084:5: ( ( ( rule__OpAdd__Alternatives ) ) )
            // InternalExprParser.g:1085:1: ( ( rule__OpAdd__Alternatives ) )
            {
            // InternalExprParser.g:1085:1: ( ( rule__OpAdd__Alternatives ) )
            // InternalExprParser.g:1086:1: ( rule__OpAdd__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpAddAccess().getAlternatives()); 
            }
            // InternalExprParser.g:1087:1: ( rule__OpAdd__Alternatives )
            // InternalExprParser.g:1087:2: rule__OpAdd__Alternatives
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
    // InternalExprParser.g:1099:1: entryRuleMultiplicativeExpression : ruleMultiplicativeExpression EOF ;
    public final void entryRuleMultiplicativeExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:1100:1: ( ruleMultiplicativeExpression EOF )
            // InternalExprParser.g:1101:1: ruleMultiplicativeExpression EOF
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
    // InternalExprParser.g:1108:1: ruleMultiplicativeExpression : ( ( rule__MultiplicativeExpression__Group__0 ) ) ;
    public final void ruleMultiplicativeExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1112:5: ( ( ( rule__MultiplicativeExpression__Group__0 ) ) )
            // InternalExprParser.g:1113:1: ( ( rule__MultiplicativeExpression__Group__0 ) )
            {
            // InternalExprParser.g:1113:1: ( ( rule__MultiplicativeExpression__Group__0 ) )
            // InternalExprParser.g:1114:1: ( rule__MultiplicativeExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExpressionAccess().getGroup()); 
            }
            // InternalExprParser.g:1115:1: ( rule__MultiplicativeExpression__Group__0 )
            // InternalExprParser.g:1115:2: rule__MultiplicativeExpression__Group__0
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
    // InternalExprParser.g:1127:1: entryRuleOpMulti : ruleOpMulti EOF ;
    public final void entryRuleOpMulti() throws RecognitionException {
        try {
            // InternalExprParser.g:1128:1: ( ruleOpMulti EOF )
            // InternalExprParser.g:1129:1: ruleOpMulti EOF
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
    // InternalExprParser.g:1136:1: ruleOpMulti : ( ( rule__OpMulti__Alternatives ) ) ;
    public final void ruleOpMulti() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1140:5: ( ( ( rule__OpMulti__Alternatives ) ) )
            // InternalExprParser.g:1141:1: ( ( rule__OpMulti__Alternatives ) )
            {
            // InternalExprParser.g:1141:1: ( ( rule__OpMulti__Alternatives ) )
            // InternalExprParser.g:1142:1: ( rule__OpMulti__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpMultiAccess().getAlternatives()); 
            }
            // InternalExprParser.g:1143:1: ( rule__OpMulti__Alternatives )
            // InternalExprParser.g:1143:2: rule__OpMulti__Alternatives
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
    // InternalExprParser.g:1155:1: entryRuleUnaryOperation : ruleUnaryOperation EOF ;
    public final void entryRuleUnaryOperation() throws RecognitionException {
        try {
            // InternalExprParser.g:1156:1: ( ruleUnaryOperation EOF )
            // InternalExprParser.g:1157:1: ruleUnaryOperation EOF
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
    // InternalExprParser.g:1164:1: ruleUnaryOperation : ( ( rule__UnaryOperation__Alternatives ) ) ;
    public final void ruleUnaryOperation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1168:5: ( ( ( rule__UnaryOperation__Alternatives ) ) )
            // InternalExprParser.g:1169:1: ( ( rule__UnaryOperation__Alternatives ) )
            {
            // InternalExprParser.g:1169:1: ( ( rule__UnaryOperation__Alternatives ) )
            // InternalExprParser.g:1170:1: ( rule__UnaryOperation__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryOperationAccess().getAlternatives()); 
            }
            // InternalExprParser.g:1171:1: ( rule__UnaryOperation__Alternatives )
            // InternalExprParser.g:1171:2: rule__UnaryOperation__Alternatives
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
    // InternalExprParser.g:1183:1: entryRuleOpUnary : ruleOpUnary EOF ;
    public final void entryRuleOpUnary() throws RecognitionException {
        try {
            // InternalExprParser.g:1184:1: ( ruleOpUnary EOF )
            // InternalExprParser.g:1185:1: ruleOpUnary EOF
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
    // InternalExprParser.g:1192:1: ruleOpUnary : ( ( rule__OpUnary__Alternatives ) ) ;
    public final void ruleOpUnary() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1196:5: ( ( ( rule__OpUnary__Alternatives ) ) )
            // InternalExprParser.g:1197:1: ( ( rule__OpUnary__Alternatives ) )
            {
            // InternalExprParser.g:1197:1: ( ( rule__OpUnary__Alternatives ) )
            // InternalExprParser.g:1198:1: ( rule__OpUnary__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpUnaryAccess().getAlternatives()); 
            }
            // InternalExprParser.g:1199:1: ( rule__OpUnary__Alternatives )
            // InternalExprParser.g:1199:2: rule__OpUnary__Alternatives
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
    // InternalExprParser.g:1211:1: entryRuleUnitExpression : ruleUnitExpression EOF ;
    public final void entryRuleUnitExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:1212:1: ( ruleUnitExpression EOF )
            // InternalExprParser.g:1213:1: ruleUnitExpression EOF
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
    // InternalExprParser.g:1220:1: ruleUnitExpression : ( ( rule__UnitExpression__Group__0 ) ) ;
    public final void ruleUnitExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1224:5: ( ( ( rule__UnitExpression__Group__0 ) ) )
            // InternalExprParser.g:1225:1: ( ( rule__UnitExpression__Group__0 ) )
            {
            // InternalExprParser.g:1225:1: ( ( rule__UnitExpression__Group__0 ) )
            // InternalExprParser.g:1226:1: ( rule__UnitExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnitExpressionAccess().getGroup()); 
            }
            // InternalExprParser.g:1227:1: ( rule__UnitExpression__Group__0 )
            // InternalExprParser.g:1227:2: rule__UnitExpression__Group__0
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
    // InternalExprParser.g:1239:1: entryRulePrimaryExpression : rulePrimaryExpression EOF ;
    public final void entryRulePrimaryExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:1240:1: ( rulePrimaryExpression EOF )
            // InternalExprParser.g:1241:1: rulePrimaryExpression EOF
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
    // InternalExprParser.g:1248:1: rulePrimaryExpression : ( ( rule__PrimaryExpression__Alternatives ) ) ;
    public final void rulePrimaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1252:5: ( ( ( rule__PrimaryExpression__Alternatives ) ) )
            // InternalExprParser.g:1253:1: ( ( rule__PrimaryExpression__Alternatives ) )
            {
            // InternalExprParser.g:1253:1: ( ( rule__PrimaryExpression__Alternatives ) )
            // InternalExprParser.g:1254:1: ( rule__PrimaryExpression__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 
            }
            // InternalExprParser.g:1255:1: ( rule__PrimaryExpression__Alternatives )
            // InternalExprParser.g:1255:2: rule__PrimaryExpression__Alternatives
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
    // InternalExprParser.g:1267:1: entryRuleVarRef : ruleVarRef EOF ;
    public final void entryRuleVarRef() throws RecognitionException {
        try {
            // InternalExprParser.g:1268:1: ( ruleVarRef EOF )
            // InternalExprParser.g:1269:1: ruleVarRef EOF
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
    // InternalExprParser.g:1276:1: ruleVarRef : ( ( rule__VarRef__RefAssignment ) ) ;
    public final void ruleVarRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1280:5: ( ( ( rule__VarRef__RefAssignment ) ) )
            // InternalExprParser.g:1281:1: ( ( rule__VarRef__RefAssignment ) )
            {
            // InternalExprParser.g:1281:1: ( ( rule__VarRef__RefAssignment ) )
            // InternalExprParser.g:1282:1: ( rule__VarRef__RefAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarRefAccess().getRefAssignment()); 
            }
            // InternalExprParser.g:1283:1: ( rule__VarRef__RefAssignment )
            // InternalExprParser.g:1283:2: rule__VarRef__RefAssignment
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
    // InternalExprParser.g:1295:1: entryRuleModelOrPropertyReference : ruleModelOrPropertyReference EOF ;
    public final void entryRuleModelOrPropertyReference() throws RecognitionException {
        try {
            // InternalExprParser.g:1296:1: ( ruleModelOrPropertyReference EOF )
            // InternalExprParser.g:1297:1: ruleModelOrPropertyReference EOF
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
    // InternalExprParser.g:1304:1: ruleModelOrPropertyReference : ( ( rule__ModelOrPropertyReference__Alternatives ) ) ;
    public final void ruleModelOrPropertyReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1308:5: ( ( ( rule__ModelOrPropertyReference__Alternatives ) ) )
            // InternalExprParser.g:1309:1: ( ( rule__ModelOrPropertyReference__Alternatives ) )
            {
            // InternalExprParser.g:1309:1: ( ( rule__ModelOrPropertyReference__Alternatives ) )
            // InternalExprParser.g:1310:1: ( rule__ModelOrPropertyReference__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelOrPropertyReferenceAccess().getAlternatives()); 
            }
            // InternalExprParser.g:1311:1: ( rule__ModelOrPropertyReference__Alternatives )
            // InternalExprParser.g:1311:2: rule__ModelOrPropertyReference__Alternatives
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
    // InternalExprParser.g:1323:1: entryRuleModelReference : ruleModelReference EOF ;
    public final void entryRuleModelReference() throws RecognitionException {
        try {
            // InternalExprParser.g:1324:1: ( ruleModelReference EOF )
            // InternalExprParser.g:1325:1: ruleModelReference EOF
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
    // InternalExprParser.g:1332:1: ruleModelReference : ( ( rule__ModelReference__Group__0 ) ) ;
    public final void ruleModelReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1336:5: ( ( ( rule__ModelReference__Group__0 ) ) )
            // InternalExprParser.g:1337:1: ( ( rule__ModelReference__Group__0 ) )
            {
            // InternalExprParser.g:1337:1: ( ( rule__ModelReference__Group__0 ) )
            // InternalExprParser.g:1338:1: ( rule__ModelReference__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelReferenceAccess().getGroup()); 
            }
            // InternalExprParser.g:1339:1: ( rule__ModelReference__Group__0 )
            // InternalExprParser.g:1339:2: rule__ModelReference__Group__0
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
    // InternalExprParser.g:1351:1: entryRuleThis : ruleThis EOF ;
    public final void entryRuleThis() throws RecognitionException {
        try {
            // InternalExprParser.g:1352:1: ( ruleThis EOF )
            // InternalExprParser.g:1353:1: ruleThis EOF
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
    // InternalExprParser.g:1360:1: ruleThis : ( This ) ;
    public final void ruleThis() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1364:5: ( ( This ) )
            // InternalExprParser.g:1365:1: ( This )
            {
            // InternalExprParser.g:1365:1: ( This )
            // InternalExprParser.g:1366:1: This
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
    // InternalExprParser.g:1381:1: entryRulePropertyReference : rulePropertyReference EOF ;
    public final void entryRulePropertyReference() throws RecognitionException {
        try {
            // InternalExprParser.g:1382:1: ( rulePropertyReference EOF )
            // InternalExprParser.g:1383:1: rulePropertyReference EOF
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
    // InternalExprParser.g:1390:1: rulePropertyReference : ( ( rule__PropertyReference__Group__0 ) ) ;
    public final void rulePropertyReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1394:5: ( ( ( rule__PropertyReference__Group__0 ) ) )
            // InternalExprParser.g:1395:1: ( ( rule__PropertyReference__Group__0 ) )
            {
            // InternalExprParser.g:1395:1: ( ( rule__PropertyReference__Group__0 ) )
            // InternalExprParser.g:1396:1: ( rule__PropertyReference__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyReferenceAccess().getGroup()); 
            }
            // InternalExprParser.g:1397:1: ( rule__PropertyReference__Group__0 )
            // InternalExprParser.g:1397:2: rule__PropertyReference__Group__0
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
    // InternalExprParser.g:1409:1: entryRuleFunctionCall : ruleFunctionCall EOF ;
    public final void entryRuleFunctionCall() throws RecognitionException {
        try {
            // InternalExprParser.g:1410:1: ( ruleFunctionCall EOF )
            // InternalExprParser.g:1411:1: ruleFunctionCall EOF
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
    // InternalExprParser.g:1418:1: ruleFunctionCall : ( ( rule__FunctionCall__Group__0 ) ) ;
    public final void ruleFunctionCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1422:5: ( ( ( rule__FunctionCall__Group__0 ) ) )
            // InternalExprParser.g:1423:1: ( ( rule__FunctionCall__Group__0 ) )
            {
            // InternalExprParser.g:1423:1: ( ( rule__FunctionCall__Group__0 ) )
            // InternalExprParser.g:1424:1: ( rule__FunctionCall__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionCallAccess().getGroup()); 
            }
            // InternalExprParser.g:1425:1: ( rule__FunctionCall__Group__0 )
            // InternalExprParser.g:1425:2: rule__FunctionCall__Group__0
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
    // InternalExprParser.g:1437:1: entryRuleRangeExpression : ruleRangeExpression EOF ;
    public final void entryRuleRangeExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:1438:1: ( ruleRangeExpression EOF )
            // InternalExprParser.g:1439:1: ruleRangeExpression EOF
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
    // InternalExprParser.g:1446:1: ruleRangeExpression : ( ( rule__RangeExpression__Group__0 ) ) ;
    public final void ruleRangeExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1450:5: ( ( ( rule__RangeExpression__Group__0 ) ) )
            // InternalExprParser.g:1451:1: ( ( rule__RangeExpression__Group__0 ) )
            {
            // InternalExprParser.g:1451:1: ( ( rule__RangeExpression__Group__0 ) )
            // InternalExprParser.g:1452:1: ( rule__RangeExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeExpressionAccess().getGroup()); 
            }
            // InternalExprParser.g:1453:1: ( rule__RangeExpression__Group__0 )
            // InternalExprParser.g:1453:2: rule__RangeExpression__Group__0
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
    // InternalExprParser.g:1465:1: entryRuleIfExpression : ruleIfExpression EOF ;
    public final void entryRuleIfExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:1466:1: ( ruleIfExpression EOF )
            // InternalExprParser.g:1467:1: ruleIfExpression EOF
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
    // InternalExprParser.g:1474:1: ruleIfExpression : ( ( rule__IfExpression__Group__0 ) ) ;
    public final void ruleIfExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1478:5: ( ( ( rule__IfExpression__Group__0 ) ) )
            // InternalExprParser.g:1479:1: ( ( rule__IfExpression__Group__0 ) )
            {
            // InternalExprParser.g:1479:1: ( ( rule__IfExpression__Group__0 ) )
            // InternalExprParser.g:1480:1: ( rule__IfExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfExpressionAccess().getGroup()); 
            }
            // InternalExprParser.g:1481:1: ( rule__IfExpression__Group__0 )
            // InternalExprParser.g:1481:2: rule__IfExpression__Group__0
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
    // InternalExprParser.g:1493:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1494:1: ( ruleLiteral EOF )
            // InternalExprParser.g:1495:1: ruleLiteral EOF
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
    // InternalExprParser.g:1502:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1506:5: ( ( ( rule__Literal__Alternatives ) ) )
            // InternalExprParser.g:1507:1: ( ( rule__Literal__Alternatives ) )
            {
            // InternalExprParser.g:1507:1: ( ( rule__Literal__Alternatives ) )
            // InternalExprParser.g:1508:1: ( rule__Literal__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getAlternatives()); 
            }
            // InternalExprParser.g:1509:1: ( rule__Literal__Alternatives )
            // InternalExprParser.g:1509:2: rule__Literal__Alternatives
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
    // InternalExprParser.g:1521:1: entryRuleBooleanLiteral : ruleBooleanLiteral EOF ;
    public final void entryRuleBooleanLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1522:1: ( ruleBooleanLiteral EOF )
            // InternalExprParser.g:1523:1: ruleBooleanLiteral EOF
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
    // InternalExprParser.g:1530:1: ruleBooleanLiteral : ( ( rule__BooleanLiteral__Group__0 ) ) ;
    public final void ruleBooleanLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1534:5: ( ( ( rule__BooleanLiteral__Group__0 ) ) )
            // InternalExprParser.g:1535:1: ( ( rule__BooleanLiteral__Group__0 ) )
            {
            // InternalExprParser.g:1535:1: ( ( rule__BooleanLiteral__Group__0 ) )
            // InternalExprParser.g:1536:1: ( rule__BooleanLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getGroup()); 
            }
            // InternalExprParser.g:1537:1: ( rule__BooleanLiteral__Group__0 )
            // InternalExprParser.g:1537:2: rule__BooleanLiteral__Group__0
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
    // InternalExprParser.g:1549:1: entryRuleIntegerLiteral : ruleIntegerLiteral EOF ;
    public final void entryRuleIntegerLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1550:1: ( ruleIntegerLiteral EOF )
            // InternalExprParser.g:1551:1: ruleIntegerLiteral EOF
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
    // InternalExprParser.g:1558:1: ruleIntegerLiteral : ( ( rule__IntegerLiteral__Group__0 ) ) ;
    public final void ruleIntegerLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1562:5: ( ( ( rule__IntegerLiteral__Group__0 ) ) )
            // InternalExprParser.g:1563:1: ( ( rule__IntegerLiteral__Group__0 ) )
            {
            // InternalExprParser.g:1563:1: ( ( rule__IntegerLiteral__Group__0 ) )
            // InternalExprParser.g:1564:1: ( rule__IntegerLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralAccess().getGroup()); 
            }
            // InternalExprParser.g:1565:1: ( rule__IntegerLiteral__Group__0 )
            // InternalExprParser.g:1565:2: rule__IntegerLiteral__Group__0
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
    // InternalExprParser.g:1577:1: entryRuleRealLiteral : ruleRealLiteral EOF ;
    public final void entryRuleRealLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1578:1: ( ruleRealLiteral EOF )
            // InternalExprParser.g:1579:1: ruleRealLiteral EOF
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
    // InternalExprParser.g:1586:1: ruleRealLiteral : ( ( rule__RealLiteral__Group__0 ) ) ;
    public final void ruleRealLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1590:5: ( ( ( rule__RealLiteral__Group__0 ) ) )
            // InternalExprParser.g:1591:1: ( ( rule__RealLiteral__Group__0 ) )
            {
            // InternalExprParser.g:1591:1: ( ( rule__RealLiteral__Group__0 ) )
            // InternalExprParser.g:1592:1: ( rule__RealLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getGroup()); 
            }
            // InternalExprParser.g:1593:1: ( rule__RealLiteral__Group__0 )
            // InternalExprParser.g:1593:2: rule__RealLiteral__Group__0
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
    // InternalExprParser.g:1605:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1606:1: ( ruleStringLiteral EOF )
            // InternalExprParser.g:1607:1: ruleStringLiteral EOF
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
    // InternalExprParser.g:1614:1: ruleStringLiteral : ( ( rule__StringLiteral__Group__0 ) ) ;
    public final void ruleStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1618:5: ( ( ( rule__StringLiteral__Group__0 ) ) )
            // InternalExprParser.g:1619:1: ( ( rule__StringLiteral__Group__0 ) )
            {
            // InternalExprParser.g:1619:1: ( ( rule__StringLiteral__Group__0 ) )
            // InternalExprParser.g:1620:1: ( rule__StringLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getGroup()); 
            }
            // InternalExprParser.g:1621:1: ( rule__StringLiteral__Group__0 )
            // InternalExprParser.g:1621:2: rule__StringLiteral__Group__0
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
    // InternalExprParser.g:1634:1: ruleCommaSeparatedExpressions : ( ( rule__CommaSeparatedExpressions__Group__0 ) ) ;
    public final void ruleCommaSeparatedExpressions() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1638:5: ( ( ( rule__CommaSeparatedExpressions__Group__0 ) ) )
            // InternalExprParser.g:1639:1: ( ( rule__CommaSeparatedExpressions__Group__0 ) )
            {
            // InternalExprParser.g:1639:1: ( ( rule__CommaSeparatedExpressions__Group__0 ) )
            // InternalExprParser.g:1640:1: ( rule__CommaSeparatedExpressions__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCommaSeparatedExpressionsAccess().getGroup()); 
            }
            // InternalExprParser.g:1641:1: ( rule__CommaSeparatedExpressions__Group__0 )
            // InternalExprParser.g:1641:2: rule__CommaSeparatedExpressions__Group__0
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
    // InternalExprParser.g:1653:1: entryRuleListLiteral : ruleListLiteral EOF ;
    public final void entryRuleListLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1654:1: ( ruleListLiteral EOF )
            // InternalExprParser.g:1655:1: ruleListLiteral EOF
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
    // InternalExprParser.g:1662:1: ruleListLiteral : ( ( rule__ListLiteral__Group__0 ) ) ;
    public final void ruleListLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1666:5: ( ( ( rule__ListLiteral__Group__0 ) ) )
            // InternalExprParser.g:1667:1: ( ( rule__ListLiteral__Group__0 ) )
            {
            // InternalExprParser.g:1667:1: ( ( rule__ListLiteral__Group__0 ) )
            // InternalExprParser.g:1668:1: ( rule__ListLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListLiteralAccess().getGroup()); 
            }
            // InternalExprParser.g:1669:1: ( rule__ListLiteral__Group__0 )
            // InternalExprParser.g:1669:2: rule__ListLiteral__Group__0
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
    // InternalExprParser.g:1681:1: entryRuleSetLiteral : ruleSetLiteral EOF ;
    public final void entryRuleSetLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1682:1: ( ruleSetLiteral EOF )
            // InternalExprParser.g:1683:1: ruleSetLiteral EOF
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
    // InternalExprParser.g:1690:1: ruleSetLiteral : ( ( rule__SetLiteral__Group__0 ) ) ;
    public final void ruleSetLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1694:5: ( ( ( rule__SetLiteral__Group__0 ) ) )
            // InternalExprParser.g:1695:1: ( ( rule__SetLiteral__Group__0 ) )
            {
            // InternalExprParser.g:1695:1: ( ( rule__SetLiteral__Group__0 ) )
            // InternalExprParser.g:1696:1: ( rule__SetLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSetLiteralAccess().getGroup()); 
            }
            // InternalExprParser.g:1697:1: ( rule__SetLiteral__Group__0 )
            // InternalExprParser.g:1697:2: rule__SetLiteral__Group__0
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
    // InternalExprParser.g:1709:1: entryRuleRecordLiteral : ruleRecordLiteral EOF ;
    public final void entryRuleRecordLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1710:1: ( ruleRecordLiteral EOF )
            // InternalExprParser.g:1711:1: ruleRecordLiteral EOF
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
    // InternalExprParser.g:1718:1: ruleRecordLiteral : ( ( rule__RecordLiteral__Group__0 ) ) ;
    public final void ruleRecordLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1722:5: ( ( ( rule__RecordLiteral__Group__0 ) ) )
            // InternalExprParser.g:1723:1: ( ( rule__RecordLiteral__Group__0 ) )
            {
            // InternalExprParser.g:1723:1: ( ( rule__RecordLiteral__Group__0 ) )
            // InternalExprParser.g:1724:1: ( rule__RecordLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecordLiteralAccess().getGroup()); 
            }
            // InternalExprParser.g:1725:1: ( rule__RecordLiteral__Group__0 )
            // InternalExprParser.g:1725:2: rule__RecordLiteral__Group__0
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
    // InternalExprParser.g:1737:1: entryRuleUnionLiteral : ruleUnionLiteral EOF ;
    public final void entryRuleUnionLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1738:1: ( ruleUnionLiteral EOF )
            // InternalExprParser.g:1739:1: ruleUnionLiteral EOF
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
    // InternalExprParser.g:1746:1: ruleUnionLiteral : ( ( rule__UnionLiteral__Group__0 ) ) ;
    public final void ruleUnionLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1750:5: ( ( ( rule__UnionLiteral__Group__0 ) ) )
            // InternalExprParser.g:1751:1: ( ( rule__UnionLiteral__Group__0 ) )
            {
            // InternalExprParser.g:1751:1: ( ( rule__UnionLiteral__Group__0 ) )
            // InternalExprParser.g:1752:1: ( rule__UnionLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnionLiteralAccess().getGroup()); 
            }
            // InternalExprParser.g:1753:1: ( rule__UnionLiteral__Group__0 )
            // InternalExprParser.g:1753:2: rule__UnionLiteral__Group__0
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
    // InternalExprParser.g:1765:1: entryRuleTupleLiteral : ruleTupleLiteral EOF ;
    public final void entryRuleTupleLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1766:1: ( ruleTupleLiteral EOF )
            // InternalExprParser.g:1767:1: ruleTupleLiteral EOF
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
    // InternalExprParser.g:1774:1: ruleTupleLiteral : ( ( rule__TupleLiteral__Group__0 ) ) ;
    public final void ruleTupleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1778:5: ( ( ( rule__TupleLiteral__Group__0 ) ) )
            // InternalExprParser.g:1779:1: ( ( rule__TupleLiteral__Group__0 ) )
            {
            // InternalExprParser.g:1779:1: ( ( rule__TupleLiteral__Group__0 ) )
            // InternalExprParser.g:1780:1: ( rule__TupleLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleLiteralAccess().getGroup()); 
            }
            // InternalExprParser.g:1781:1: ( rule__TupleLiteral__Group__0 )
            // InternalExprParser.g:1781:2: rule__TupleLiteral__Group__0
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
    // InternalExprParser.g:1793:1: entryRuleBagLiteral : ruleBagLiteral EOF ;
    public final void entryRuleBagLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1794:1: ( ruleBagLiteral EOF )
            // InternalExprParser.g:1795:1: ruleBagLiteral EOF
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
    // InternalExprParser.g:1802:1: ruleBagLiteral : ( ( rule__BagLiteral__Group__0 ) ) ;
    public final void ruleBagLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1806:5: ( ( ( rule__BagLiteral__Group__0 ) ) )
            // InternalExprParser.g:1807:1: ( ( rule__BagLiteral__Group__0 ) )
            {
            // InternalExprParser.g:1807:1: ( ( rule__BagLiteral__Group__0 ) )
            // InternalExprParser.g:1808:1: ( rule__BagLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBagLiteralAccess().getGroup()); 
            }
            // InternalExprParser.g:1809:1: ( rule__BagLiteral__Group__0 )
            // InternalExprParser.g:1809:2: rule__BagLiteral__Group__0
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
    // InternalExprParser.g:1821:1: entryRuleMapLiteral : ruleMapLiteral EOF ;
    public final void entryRuleMapLiteral() throws RecognitionException {
        try {
            // InternalExprParser.g:1822:1: ( ruleMapLiteral EOF )
            // InternalExprParser.g:1823:1: ruleMapLiteral EOF
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
    // InternalExprParser.g:1830:1: ruleMapLiteral : ( ( rule__MapLiteral__Group__0 ) ) ;
    public final void ruleMapLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1834:5: ( ( ( rule__MapLiteral__Group__0 ) ) )
            // InternalExprParser.g:1835:1: ( ( rule__MapLiteral__Group__0 ) )
            {
            // InternalExprParser.g:1835:1: ( ( rule__MapLiteral__Group__0 ) )
            // InternalExprParser.g:1836:1: ( rule__MapLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMapLiteralAccess().getGroup()); 
            }
            // InternalExprParser.g:1837:1: ( rule__MapLiteral__Group__0 )
            // InternalExprParser.g:1837:2: rule__MapLiteral__Group__0
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
    // InternalExprParser.g:1849:1: entryRuleNoQuoteString : ruleNoQuoteString EOF ;
    public final void entryRuleNoQuoteString() throws RecognitionException {
        try {
            // InternalExprParser.g:1850:1: ( ruleNoQuoteString EOF )
            // InternalExprParser.g:1851:1: ruleNoQuoteString EOF
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
    // InternalExprParser.g:1858:1: ruleNoQuoteString : ( RULE_STRING ) ;
    public final void ruleNoQuoteString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1862:5: ( ( RULE_STRING ) )
            // InternalExprParser.g:1863:1: ( RULE_STRING )
            {
            // InternalExprParser.g:1863:1: ( RULE_STRING )
            // InternalExprParser.g:1864:1: RULE_STRING
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
    // InternalExprParser.g:1879:1: entryRuleQPREF : ruleQPREF EOF ;
    public final void entryRuleQPREF() throws RecognitionException {
        try {
            // InternalExprParser.g:1880:1: ( ruleQPREF EOF )
            // InternalExprParser.g:1881:1: ruleQPREF EOF
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
    // InternalExprParser.g:1888:1: ruleQPREF : ( ( rule__QPREF__Group__0 ) ) ;
    public final void ruleQPREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1892:5: ( ( ( rule__QPREF__Group__0 ) ) )
            // InternalExprParser.g:1893:1: ( ( rule__QPREF__Group__0 ) )
            {
            // InternalExprParser.g:1893:1: ( ( rule__QPREF__Group__0 ) )
            // InternalExprParser.g:1894:1: ( rule__QPREF__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQPREFAccess().getGroup()); 
            }
            // InternalExprParser.g:1895:1: ( rule__QPREF__Group__0 )
            // InternalExprParser.g:1895:2: rule__QPREF__Group__0
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
    // InternalExprParser.g:1907:1: entryRuleQCREF : ruleQCREF EOF ;
    public final void entryRuleQCREF() throws RecognitionException {
        try {
            // InternalExprParser.g:1908:1: ( ruleQCREF EOF )
            // InternalExprParser.g:1909:1: ruleQCREF EOF
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
    // InternalExprParser.g:1916:1: ruleQCREF : ( ( rule__QCREF__Group__0 ) ) ;
    public final void ruleQCREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1920:5: ( ( ( rule__QCREF__Group__0 ) ) )
            // InternalExprParser.g:1921:1: ( ( rule__QCREF__Group__0 ) )
            {
            // InternalExprParser.g:1921:1: ( ( rule__QCREF__Group__0 ) )
            // InternalExprParser.g:1922:1: ( rule__QCREF__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQCREFAccess().getGroup()); 
            }
            // InternalExprParser.g:1923:1: ( rule__QCREF__Group__0 )
            // InternalExprParser.g:1923:2: rule__QCREF__Group__0
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
    // InternalExprParser.g:1938:1: ruleMetaClassEnum : ( ( rule__MetaClassEnum__Alternatives ) ) ;
    public final void ruleMetaClassEnum() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1942:1: ( ( ( rule__MetaClassEnum__Alternatives ) ) )
            // InternalExprParser.g:1943:1: ( ( rule__MetaClassEnum__Alternatives ) )
            {
            // InternalExprParser.g:1943:1: ( ( rule__MetaClassEnum__Alternatives ) )
            // InternalExprParser.g:1944:1: ( rule__MetaClassEnum__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMetaClassEnumAccess().getAlternatives()); 
            }
            // InternalExprParser.g:1945:1: ( rule__MetaClassEnum__Alternatives )
            // InternalExprParser.g:1945:2: rule__MetaClassEnum__Alternatives
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
    // InternalExprParser.g:1960:1: rule__ExprModel__Alternatives : ( ( ( rule__ExprModel__Group_0__0 ) ) | ( ( rule__ExprModel__Group_1__0 ) ) );
    public final void rule__ExprModel__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1964:1: ( ( ( rule__ExprModel__Group_0__0 ) ) | ( ( rule__ExprModel__Group_1__0 ) ) )
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
                    // InternalExprParser.g:1965:1: ( ( rule__ExprModel__Group_0__0 ) )
                    {
                    // InternalExprParser.g:1965:1: ( ( rule__ExprModel__Group_0__0 ) )
                    // InternalExprParser.g:1966:1: ( rule__ExprModel__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getExprModelAccess().getGroup_0()); 
                    }
                    // InternalExprParser.g:1967:1: ( rule__ExprModel__Group_0__0 )
                    // InternalExprParser.g:1967:2: rule__ExprModel__Group_0__0
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
                    // InternalExprParser.g:1971:6: ( ( rule__ExprModel__Group_1__0 ) )
                    {
                    // InternalExprParser.g:1971:6: ( ( rule__ExprModel__Group_1__0 ) )
                    // InternalExprParser.g:1972:1: ( rule__ExprModel__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getExprModelAccess().getGroup_1()); 
                    }
                    // InternalExprParser.g:1973:1: ( rule__ExprModel__Group_1__0 )
                    // InternalExprParser.g:1973:2: rule__ExprModel__Group_1__0
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
    // InternalExprParser.g:1982:1: rule__Declaration__Alternatives : ( ( ruleTypeDecl ) | ( ruleVarDecl ) | ( ruleFunDecl ) );
    public final void rule__Declaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1986:1: ( ( ruleTypeDecl ) | ( ruleVarDecl ) | ( ruleFunDecl ) )
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
                    // InternalExprParser.g:1987:1: ( ruleTypeDecl )
                    {
                    // InternalExprParser.g:1987:1: ( ruleTypeDecl )
                    // InternalExprParser.g:1988:1: ruleTypeDecl
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
                    // InternalExprParser.g:1993:6: ( ruleVarDecl )
                    {
                    // InternalExprParser.g:1993:6: ( ruleVarDecl )
                    // InternalExprParser.g:1994:1: ruleVarDecl
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
                    // InternalExprParser.g:1999:6: ( ruleFunDecl )
                    {
                    // InternalExprParser.g:1999:6: ( ruleFunDecl )
                    // InternalExprParser.g:2000:1: ruleFunDecl
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


    // $ANTLR start "rule__VarDecl__Alternatives_0"
    // InternalExprParser.g:2010:1: rule__VarDecl__Alternatives_0 : ( ( ( rule__VarDecl__ConstAssignment_0_0 ) ) | ( Var ) );
    public final void rule__VarDecl__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2014:1: ( ( ( rule__VarDecl__ConstAssignment_0_0 ) ) | ( Var ) )
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
                    // InternalExprParser.g:2015:1: ( ( rule__VarDecl__ConstAssignment_0_0 ) )
                    {
                    // InternalExprParser.g:2015:1: ( ( rule__VarDecl__ConstAssignment_0_0 ) )
                    // InternalExprParser.g:2016:1: ( rule__VarDecl__ConstAssignment_0_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVarDeclAccess().getConstAssignment_0_0()); 
                    }
                    // InternalExprParser.g:2017:1: ( rule__VarDecl__ConstAssignment_0_0 )
                    // InternalExprParser.g:2017:2: rule__VarDecl__ConstAssignment_0_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VarDecl__ConstAssignment_0_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVarDeclAccess().getConstAssignment_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2021:6: ( Var )
                    {
                    // InternalExprParser.g:2021:6: ( Var )
                    // InternalExprParser.g:2022:1: Var
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVarDeclAccess().getVarKeyword_0_1()); 
                    }
                    match(input,Var,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVarDeclAccess().getVarKeyword_0_1()); 
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
    // $ANTLR end "rule__VarDecl__Alternatives_0"


    // $ANTLR start "rule__Type__Alternatives"
    // InternalExprParser.g:2034:1: rule__Type__Alternatives : ( ( rulePrimitiveType ) | ( ruleCategory ) | ( ruleMetaClass ) | ( ruleClassifierType ) | ( ruleRecordType ) | ( ruleUnionType ) | ( ruleTupleType ) | ( ruleListType ) | ( ruleSetType ) | ( ruleBagType ) | ( ruleMapType ) | ( ruleTypeRef ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2038:1: ( ( rulePrimitiveType ) | ( ruleCategory ) | ( ruleMetaClass ) | ( ruleClassifierType ) | ( ruleRecordType ) | ( ruleUnionType ) | ( ruleTupleType ) | ( ruleListType ) | ( ruleSetType ) | ( ruleBagType ) | ( ruleMapType ) | ( ruleTypeRef ) )
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
                    // InternalExprParser.g:2039:1: ( rulePrimitiveType )
                    {
                    // InternalExprParser.g:2039:1: ( rulePrimitiveType )
                    // InternalExprParser.g:2040:1: rulePrimitiveType
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
                    // InternalExprParser.g:2045:6: ( ruleCategory )
                    {
                    // InternalExprParser.g:2045:6: ( ruleCategory )
                    // InternalExprParser.g:2046:1: ruleCategory
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
                    // InternalExprParser.g:2051:6: ( ruleMetaClass )
                    {
                    // InternalExprParser.g:2051:6: ( ruleMetaClass )
                    // InternalExprParser.g:2052:1: ruleMetaClass
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
                    // InternalExprParser.g:2057:6: ( ruleClassifierType )
                    {
                    // InternalExprParser.g:2057:6: ( ruleClassifierType )
                    // InternalExprParser.g:2058:1: ruleClassifierType
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
                    // InternalExprParser.g:2063:6: ( ruleRecordType )
                    {
                    // InternalExprParser.g:2063:6: ( ruleRecordType )
                    // InternalExprParser.g:2064:1: ruleRecordType
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
                    // InternalExprParser.g:2069:6: ( ruleUnionType )
                    {
                    // InternalExprParser.g:2069:6: ( ruleUnionType )
                    // InternalExprParser.g:2070:1: ruleUnionType
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
                    // InternalExprParser.g:2075:6: ( ruleTupleType )
                    {
                    // InternalExprParser.g:2075:6: ( ruleTupleType )
                    // InternalExprParser.g:2076:1: ruleTupleType
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
                    // InternalExprParser.g:2081:6: ( ruleListType )
                    {
                    // InternalExprParser.g:2081:6: ( ruleListType )
                    // InternalExprParser.g:2082:1: ruleListType
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
                    // InternalExprParser.g:2087:6: ( ruleSetType )
                    {
                    // InternalExprParser.g:2087:6: ( ruleSetType )
                    // InternalExprParser.g:2088:1: ruleSetType
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
                    // InternalExprParser.g:2093:6: ( ruleBagType )
                    {
                    // InternalExprParser.g:2093:6: ( ruleBagType )
                    // InternalExprParser.g:2094:1: ruleBagType
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
                    // InternalExprParser.g:2099:6: ( ruleMapType )
                    {
                    // InternalExprParser.g:2099:6: ( ruleMapType )
                    // InternalExprParser.g:2100:1: ruleMapType
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
                    // InternalExprParser.g:2105:6: ( ruleTypeRef )
                    {
                    // InternalExprParser.g:2105:6: ( ruleTypeRef )
                    // InternalExprParser.g:2106:1: ruleTypeRef
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
    // InternalExprParser.g:2116:1: rule__PrimitiveType__Alternatives : ( ( ( rule__PrimitiveType__Group_0__0 ) ) | ( ( rule__PrimitiveType__Group_1__0 ) ) | ( ( rule__PrimitiveType__Group_2__0 ) ) | ( ( rule__PrimitiveType__Group_3__0 ) ) );
    public final void rule__PrimitiveType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2120:1: ( ( ( rule__PrimitiveType__Group_0__0 ) ) | ( ( rule__PrimitiveType__Group_1__0 ) ) | ( ( rule__PrimitiveType__Group_2__0 ) ) | ( ( rule__PrimitiveType__Group_3__0 ) ) )
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
                    // InternalExprParser.g:2121:1: ( ( rule__PrimitiveType__Group_0__0 ) )
                    {
                    // InternalExprParser.g:2121:1: ( ( rule__PrimitiveType__Group_0__0 ) )
                    // InternalExprParser.g:2122:1: ( rule__PrimitiveType__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimitiveTypeAccess().getGroup_0()); 
                    }
                    // InternalExprParser.g:2123:1: ( rule__PrimitiveType__Group_0__0 )
                    // InternalExprParser.g:2123:2: rule__PrimitiveType__Group_0__0
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
                    // InternalExprParser.g:2127:6: ( ( rule__PrimitiveType__Group_1__0 ) )
                    {
                    // InternalExprParser.g:2127:6: ( ( rule__PrimitiveType__Group_1__0 ) )
                    // InternalExprParser.g:2128:1: ( rule__PrimitiveType__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimitiveTypeAccess().getGroup_1()); 
                    }
                    // InternalExprParser.g:2129:1: ( rule__PrimitiveType__Group_1__0 )
                    // InternalExprParser.g:2129:2: rule__PrimitiveType__Group_1__0
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
                    // InternalExprParser.g:2133:6: ( ( rule__PrimitiveType__Group_2__0 ) )
                    {
                    // InternalExprParser.g:2133:6: ( ( rule__PrimitiveType__Group_2__0 ) )
                    // InternalExprParser.g:2134:1: ( rule__PrimitiveType__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimitiveTypeAccess().getGroup_2()); 
                    }
                    // InternalExprParser.g:2135:1: ( rule__PrimitiveType__Group_2__0 )
                    // InternalExprParser.g:2135:2: rule__PrimitiveType__Group_2__0
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
                    // InternalExprParser.g:2139:6: ( ( rule__PrimitiveType__Group_3__0 ) )
                    {
                    // InternalExprParser.g:2139:6: ( ( rule__PrimitiveType__Group_3__0 ) )
                    // InternalExprParser.g:2140:1: ( rule__PrimitiveType__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimitiveTypeAccess().getGroup_3()); 
                    }
                    // InternalExprParser.g:2141:1: ( rule__PrimitiveType__Group_3__0 )
                    // InternalExprParser.g:2141:2: rule__PrimitiveType__Group_3__0
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
    // InternalExprParser.g:2150:1: rule__ComponentCategory__Alternatives : ( ( Abstract ) | ( Bus ) | ( Data ) | ( Device ) | ( Memory ) | ( Process ) | ( Processor ) | ( Subprogram ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( KW_System ) | ( ( rule__ComponentCategory__Group_10__0 ) ) | ( Thread ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( ( rule__ComponentCategory__Group_13__0 ) ) );
    public final void rule__ComponentCategory__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2154:1: ( ( Abstract ) | ( Bus ) | ( Data ) | ( Device ) | ( Memory ) | ( Process ) | ( Processor ) | ( Subprogram ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( KW_System ) | ( ( rule__ComponentCategory__Group_10__0 ) ) | ( Thread ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( ( rule__ComponentCategory__Group_13__0 ) ) )
            int alt6=14;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalExprParser.g:2155:1: ( Abstract )
                    {
                    // InternalExprParser.g:2155:1: ( Abstract )
                    // InternalExprParser.g:2156:1: Abstract
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
                    // InternalExprParser.g:2163:6: ( Bus )
                    {
                    // InternalExprParser.g:2163:6: ( Bus )
                    // InternalExprParser.g:2164:1: Bus
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
                    // InternalExprParser.g:2171:6: ( Data )
                    {
                    // InternalExprParser.g:2171:6: ( Data )
                    // InternalExprParser.g:2172:1: Data
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
                    // InternalExprParser.g:2179:6: ( Device )
                    {
                    // InternalExprParser.g:2179:6: ( Device )
                    // InternalExprParser.g:2180:1: Device
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
                    // InternalExprParser.g:2187:6: ( Memory )
                    {
                    // InternalExprParser.g:2187:6: ( Memory )
                    // InternalExprParser.g:2188:1: Memory
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
                    // InternalExprParser.g:2195:6: ( Process )
                    {
                    // InternalExprParser.g:2195:6: ( Process )
                    // InternalExprParser.g:2196:1: Process
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
                    // InternalExprParser.g:2203:6: ( Processor )
                    {
                    // InternalExprParser.g:2203:6: ( Processor )
                    // InternalExprParser.g:2204:1: Processor
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
                    // InternalExprParser.g:2211:6: ( Subprogram )
                    {
                    // InternalExprParser.g:2211:6: ( Subprogram )
                    // InternalExprParser.g:2212:1: Subprogram
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
                    // InternalExprParser.g:2219:6: ( ( rule__ComponentCategory__Group_8__0 ) )
                    {
                    // InternalExprParser.g:2219:6: ( ( rule__ComponentCategory__Group_8__0 ) )
                    // InternalExprParser.g:2220:1: ( rule__ComponentCategory__Group_8__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComponentCategoryAccess().getGroup_8()); 
                    }
                    // InternalExprParser.g:2221:1: ( rule__ComponentCategory__Group_8__0 )
                    // InternalExprParser.g:2221:2: rule__ComponentCategory__Group_8__0
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
                    // InternalExprParser.g:2225:6: ( KW_System )
                    {
                    // InternalExprParser.g:2225:6: ( KW_System )
                    // InternalExprParser.g:2226:1: KW_System
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
                    // InternalExprParser.g:2233:6: ( ( rule__ComponentCategory__Group_10__0 ) )
                    {
                    // InternalExprParser.g:2233:6: ( ( rule__ComponentCategory__Group_10__0 ) )
                    // InternalExprParser.g:2234:1: ( rule__ComponentCategory__Group_10__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComponentCategoryAccess().getGroup_10()); 
                    }
                    // InternalExprParser.g:2235:1: ( rule__ComponentCategory__Group_10__0 )
                    // InternalExprParser.g:2235:2: rule__ComponentCategory__Group_10__0
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
                    // InternalExprParser.g:2239:6: ( Thread )
                    {
                    // InternalExprParser.g:2239:6: ( Thread )
                    // InternalExprParser.g:2240:1: Thread
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
                    // InternalExprParser.g:2247:6: ( ( rule__ComponentCategory__Group_12__0 ) )
                    {
                    // InternalExprParser.g:2247:6: ( ( rule__ComponentCategory__Group_12__0 ) )
                    // InternalExprParser.g:2248:1: ( rule__ComponentCategory__Group_12__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComponentCategoryAccess().getGroup_12()); 
                    }
                    // InternalExprParser.g:2249:1: ( rule__ComponentCategory__Group_12__0 )
                    // InternalExprParser.g:2249:2: rule__ComponentCategory__Group_12__0
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
                    // InternalExprParser.g:2253:6: ( ( rule__ComponentCategory__Group_13__0 ) )
                    {
                    // InternalExprParser.g:2253:6: ( ( rule__ComponentCategory__Group_13__0 ) )
                    // InternalExprParser.g:2254:1: ( rule__ComponentCategory__Group_13__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComponentCategoryAccess().getGroup_13()); 
                    }
                    // InternalExprParser.g:2255:1: ( rule__ComponentCategory__Group_13__0 )
                    // InternalExprParser.g:2255:2: rule__ComponentCategory__Group_13__0
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
    // InternalExprParser.g:2264:1: rule__OpOr__Alternatives : ( ( Or ) | ( VerticalLineVerticalLine ) );
    public final void rule__OpOr__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2268:1: ( ( Or ) | ( VerticalLineVerticalLine ) )
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
                    // InternalExprParser.g:2269:1: ( Or )
                    {
                    // InternalExprParser.g:2269:1: ( Or )
                    // InternalExprParser.g:2270:1: Or
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
                    // InternalExprParser.g:2277:6: ( VerticalLineVerticalLine )
                    {
                    // InternalExprParser.g:2277:6: ( VerticalLineVerticalLine )
                    // InternalExprParser.g:2278:1: VerticalLineVerticalLine
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
    // InternalExprParser.g:2290:1: rule__OpAnd__Alternatives : ( ( And ) | ( AmpersandAmpersand ) );
    public final void rule__OpAnd__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2294:1: ( ( And ) | ( AmpersandAmpersand ) )
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
                    // InternalExprParser.g:2295:1: ( And )
                    {
                    // InternalExprParser.g:2295:1: ( And )
                    // InternalExprParser.g:2296:1: And
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
                    // InternalExprParser.g:2303:6: ( AmpersandAmpersand )
                    {
                    // InternalExprParser.g:2303:6: ( AmpersandAmpersand )
                    // InternalExprParser.g:2304:1: AmpersandAmpersand
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
    // InternalExprParser.g:2316:1: rule__OpEquality__Alternatives : ( ( EqualsSignEqualsSign ) | ( ExclamationMarkEqualsSign ) );
    public final void rule__OpEquality__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2320:1: ( ( EqualsSignEqualsSign ) | ( ExclamationMarkEqualsSign ) )
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
                    // InternalExprParser.g:2321:1: ( EqualsSignEqualsSign )
                    {
                    // InternalExprParser.g:2321:1: ( EqualsSignEqualsSign )
                    // InternalExprParser.g:2322:1: EqualsSignEqualsSign
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
                    // InternalExprParser.g:2329:6: ( ExclamationMarkEqualsSign )
                    {
                    // InternalExprParser.g:2329:6: ( ExclamationMarkEqualsSign )
                    // InternalExprParser.g:2330:1: ExclamationMarkEqualsSign
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
    // InternalExprParser.g:2342:1: rule__OpCompare__Alternatives : ( ( GreaterThanSignEqualsSign ) | ( LessThanSignEqualsSign ) | ( GreaterThanSign ) | ( LessThanSign ) | ( GreaterThanSignLessThanSign ) );
    public final void rule__OpCompare__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2346:1: ( ( GreaterThanSignEqualsSign ) | ( LessThanSignEqualsSign ) | ( GreaterThanSign ) | ( LessThanSign ) | ( GreaterThanSignLessThanSign ) )
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
                    // InternalExprParser.g:2347:1: ( GreaterThanSignEqualsSign )
                    {
                    // InternalExprParser.g:2347:1: ( GreaterThanSignEqualsSign )
                    // InternalExprParser.g:2348:1: GreaterThanSignEqualsSign
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
                    // InternalExprParser.g:2355:6: ( LessThanSignEqualsSign )
                    {
                    // InternalExprParser.g:2355:6: ( LessThanSignEqualsSign )
                    // InternalExprParser.g:2356:1: LessThanSignEqualsSign
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
                    // InternalExprParser.g:2363:6: ( GreaterThanSign )
                    {
                    // InternalExprParser.g:2363:6: ( GreaterThanSign )
                    // InternalExprParser.g:2364:1: GreaterThanSign
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
                    // InternalExprParser.g:2371:6: ( LessThanSign )
                    {
                    // InternalExprParser.g:2371:6: ( LessThanSign )
                    // InternalExprParser.g:2372:1: LessThanSign
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
                    // InternalExprParser.g:2379:6: ( GreaterThanSignLessThanSign )
                    {
                    // InternalExprParser.g:2379:6: ( GreaterThanSignLessThanSign )
                    // InternalExprParser.g:2380:1: GreaterThanSignLessThanSign
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
    // InternalExprParser.g:2392:1: rule__OpAdd__Alternatives : ( ( PlusSign ) | ( HyphenMinus ) );
    public final void rule__OpAdd__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2396:1: ( ( PlusSign ) | ( HyphenMinus ) )
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
                    // InternalExprParser.g:2397:1: ( PlusSign )
                    {
                    // InternalExprParser.g:2397:1: ( PlusSign )
                    // InternalExprParser.g:2398:1: PlusSign
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
                    // InternalExprParser.g:2405:6: ( HyphenMinus )
                    {
                    // InternalExprParser.g:2405:6: ( HyphenMinus )
                    // InternalExprParser.g:2406:1: HyphenMinus
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
    // InternalExprParser.g:2418:1: rule__OpMulti__Alternatives : ( ( Asterisk ) | ( Solidus ) | ( Div ) | ( Mod ) );
    public final void rule__OpMulti__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2422:1: ( ( Asterisk ) | ( Solidus ) | ( Div ) | ( Mod ) )
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
                    // InternalExprParser.g:2423:1: ( Asterisk )
                    {
                    // InternalExprParser.g:2423:1: ( Asterisk )
                    // InternalExprParser.g:2424:1: Asterisk
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
                    // InternalExprParser.g:2431:6: ( Solidus )
                    {
                    // InternalExprParser.g:2431:6: ( Solidus )
                    // InternalExprParser.g:2432:1: Solidus
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
                    // InternalExprParser.g:2439:6: ( Div )
                    {
                    // InternalExprParser.g:2439:6: ( Div )
                    // InternalExprParser.g:2440:1: Div
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
                    // InternalExprParser.g:2447:6: ( Mod )
                    {
                    // InternalExprParser.g:2447:6: ( Mod )
                    // InternalExprParser.g:2448:1: Mod
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
    // InternalExprParser.g:2460:1: rule__UnaryOperation__Alternatives : ( ( ( rule__UnaryOperation__Group_0__0 ) ) | ( ruleUnitExpression ) );
    public final void rule__UnaryOperation__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2464:1: ( ( ( rule__UnaryOperation__Group_0__0 ) ) | ( ruleUnitExpression ) )
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
                    // InternalExprParser.g:2465:1: ( ( rule__UnaryOperation__Group_0__0 ) )
                    {
                    // InternalExprParser.g:2465:1: ( ( rule__UnaryOperation__Group_0__0 ) )
                    // InternalExprParser.g:2466:1: ( rule__UnaryOperation__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUnaryOperationAccess().getGroup_0()); 
                    }
                    // InternalExprParser.g:2467:1: ( rule__UnaryOperation__Group_0__0 )
                    // InternalExprParser.g:2467:2: rule__UnaryOperation__Group_0__0
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
                    // InternalExprParser.g:2471:6: ( ruleUnitExpression )
                    {
                    // InternalExprParser.g:2471:6: ( ruleUnitExpression )
                    // InternalExprParser.g:2472:1: ruleUnitExpression
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
    // InternalExprParser.g:2482:1: rule__OpUnary__Alternatives : ( ( Not ) | ( HyphenMinus ) | ( PlusSign ) );
    public final void rule__OpUnary__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2486:1: ( ( Not ) | ( HyphenMinus ) | ( PlusSign ) )
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
                    // InternalExprParser.g:2487:1: ( Not )
                    {
                    // InternalExprParser.g:2487:1: ( Not )
                    // InternalExprParser.g:2488:1: Not
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
                    // InternalExprParser.g:2495:6: ( HyphenMinus )
                    {
                    // InternalExprParser.g:2495:6: ( HyphenMinus )
                    // InternalExprParser.g:2496:1: HyphenMinus
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
                    // InternalExprParser.g:2503:6: ( PlusSign )
                    {
                    // InternalExprParser.g:2503:6: ( PlusSign )
                    // InternalExprParser.g:2504:1: PlusSign
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
    // InternalExprParser.g:2516:1: rule__UnitExpression__Alternatives_1_1 : ( ( ( rule__UnitExpression__ConvertAssignment_1_1_0 ) ) | ( ( rule__UnitExpression__DropAssignment_1_1_1 ) ) );
    public final void rule__UnitExpression__Alternatives_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2520:1: ( ( ( rule__UnitExpression__ConvertAssignment_1_1_0 ) ) | ( ( rule__UnitExpression__DropAssignment_1_1_1 ) ) )
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
                    // InternalExprParser.g:2521:1: ( ( rule__UnitExpression__ConvertAssignment_1_1_0 ) )
                    {
                    // InternalExprParser.g:2521:1: ( ( rule__UnitExpression__ConvertAssignment_1_1_0 ) )
                    // InternalExprParser.g:2522:1: ( rule__UnitExpression__ConvertAssignment_1_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUnitExpressionAccess().getConvertAssignment_1_1_0()); 
                    }
                    // InternalExprParser.g:2523:1: ( rule__UnitExpression__ConvertAssignment_1_1_0 )
                    // InternalExprParser.g:2523:2: rule__UnitExpression__ConvertAssignment_1_1_0
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
                    // InternalExprParser.g:2527:6: ( ( rule__UnitExpression__DropAssignment_1_1_1 ) )
                    {
                    // InternalExprParser.g:2527:6: ( ( rule__UnitExpression__DropAssignment_1_1_1 ) )
                    // InternalExprParser.g:2528:1: ( rule__UnitExpression__DropAssignment_1_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUnitExpressionAccess().getDropAssignment_1_1_1()); 
                    }
                    // InternalExprParser.g:2529:1: ( rule__UnitExpression__DropAssignment_1_1_1 )
                    // InternalExprParser.g:2529:2: rule__UnitExpression__DropAssignment_1_1_1
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
    // InternalExprParser.g:2538:1: rule__PrimaryExpression__Alternatives : ( ( ruleVarRef ) | ( ruleModelOrPropertyReference ) | ( ruleFunctionCall ) | ( ruleRangeExpression ) | ( ruleIfExpression ) | ( ruleLiteral ) | ( ( rule__PrimaryExpression__Group_6__0 ) ) );
    public final void rule__PrimaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2542:1: ( ( ruleVarRef ) | ( ruleModelOrPropertyReference ) | ( ruleFunctionCall ) | ( ruleRangeExpression ) | ( ruleIfExpression ) | ( ruleLiteral ) | ( ( rule__PrimaryExpression__Group_6__0 ) ) )
            int alt16=7;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // InternalExprParser.g:2543:1: ( ruleVarRef )
                    {
                    // InternalExprParser.g:2543:1: ( ruleVarRef )
                    // InternalExprParser.g:2544:1: ruleVarRef
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
                    // InternalExprParser.g:2549:6: ( ruleModelOrPropertyReference )
                    {
                    // InternalExprParser.g:2549:6: ( ruleModelOrPropertyReference )
                    // InternalExprParser.g:2550:1: ruleModelOrPropertyReference
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
                    // InternalExprParser.g:2555:6: ( ruleFunctionCall )
                    {
                    // InternalExprParser.g:2555:6: ( ruleFunctionCall )
                    // InternalExprParser.g:2556:1: ruleFunctionCall
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
                    // InternalExprParser.g:2561:6: ( ruleRangeExpression )
                    {
                    // InternalExprParser.g:2561:6: ( ruleRangeExpression )
                    // InternalExprParser.g:2562:1: ruleRangeExpression
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
                    // InternalExprParser.g:2567:6: ( ruleIfExpression )
                    {
                    // InternalExprParser.g:2567:6: ( ruleIfExpression )
                    // InternalExprParser.g:2568:1: ruleIfExpression
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
                    // InternalExprParser.g:2573:6: ( ruleLiteral )
                    {
                    // InternalExprParser.g:2573:6: ( ruleLiteral )
                    // InternalExprParser.g:2574:1: ruleLiteral
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
                    // InternalExprParser.g:2579:6: ( ( rule__PrimaryExpression__Group_6__0 ) )
                    {
                    // InternalExprParser.g:2579:6: ( ( rule__PrimaryExpression__Group_6__0 ) )
                    // InternalExprParser.g:2580:1: ( rule__PrimaryExpression__Group_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpressionAccess().getGroup_6()); 
                    }
                    // InternalExprParser.g:2581:1: ( rule__PrimaryExpression__Group_6__0 )
                    // InternalExprParser.g:2581:2: rule__PrimaryExpression__Group_6__0
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
    // InternalExprParser.g:2590:1: rule__ModelOrPropertyReference__Alternatives : ( ( ( rule__ModelOrPropertyReference__Group_0__0 ) ) | ( rulePropertyReference ) );
    public final void rule__ModelOrPropertyReference__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2594:1: ( ( ( rule__ModelOrPropertyReference__Group_0__0 ) ) | ( rulePropertyReference ) )
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
                    // InternalExprParser.g:2595:1: ( ( rule__ModelOrPropertyReference__Group_0__0 ) )
                    {
                    // InternalExprParser.g:2595:1: ( ( rule__ModelOrPropertyReference__Group_0__0 ) )
                    // InternalExprParser.g:2596:1: ( rule__ModelOrPropertyReference__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModelOrPropertyReferenceAccess().getGroup_0()); 
                    }
                    // InternalExprParser.g:2597:1: ( rule__ModelOrPropertyReference__Group_0__0 )
                    // InternalExprParser.g:2597:2: rule__ModelOrPropertyReference__Group_0__0
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
                    // InternalExprParser.g:2601:6: ( rulePropertyReference )
                    {
                    // InternalExprParser.g:2601:6: ( rulePropertyReference )
                    // InternalExprParser.g:2602:1: rulePropertyReference
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
    // InternalExprParser.g:2612:1: rule__Literal__Alternatives : ( ( ruleBooleanLiteral ) | ( ruleIntegerLiteral ) | ( ruleRealLiteral ) | ( ruleStringLiteral ) | ( ruleListLiteral ) | ( ruleSetLiteral ) | ( ruleRecordLiteral ) | ( ruleUnionLiteral ) | ( ruleTupleLiteral ) | ( ruleBagLiteral ) | ( ruleMapLiteral ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2616:1: ( ( ruleBooleanLiteral ) | ( ruleIntegerLiteral ) | ( ruleRealLiteral ) | ( ruleStringLiteral ) | ( ruleListLiteral ) | ( ruleSetLiteral ) | ( ruleRecordLiteral ) | ( ruleUnionLiteral ) | ( ruleTupleLiteral ) | ( ruleBagLiteral ) | ( ruleMapLiteral ) )
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
                    // InternalExprParser.g:2617:1: ( ruleBooleanLiteral )
                    {
                    // InternalExprParser.g:2617:1: ( ruleBooleanLiteral )
                    // InternalExprParser.g:2618:1: ruleBooleanLiteral
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
                    // InternalExprParser.g:2623:6: ( ruleIntegerLiteral )
                    {
                    // InternalExprParser.g:2623:6: ( ruleIntegerLiteral )
                    // InternalExprParser.g:2624:1: ruleIntegerLiteral
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
                    // InternalExprParser.g:2629:6: ( ruleRealLiteral )
                    {
                    // InternalExprParser.g:2629:6: ( ruleRealLiteral )
                    // InternalExprParser.g:2630:1: ruleRealLiteral
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
                    // InternalExprParser.g:2635:6: ( ruleStringLiteral )
                    {
                    // InternalExprParser.g:2635:6: ( ruleStringLiteral )
                    // InternalExprParser.g:2636:1: ruleStringLiteral
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
                    // InternalExprParser.g:2641:6: ( ruleListLiteral )
                    {
                    // InternalExprParser.g:2641:6: ( ruleListLiteral )
                    // InternalExprParser.g:2642:1: ruleListLiteral
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
                    // InternalExprParser.g:2647:6: ( ruleSetLiteral )
                    {
                    // InternalExprParser.g:2647:6: ( ruleSetLiteral )
                    // InternalExprParser.g:2648:1: ruleSetLiteral
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
                    // InternalExprParser.g:2653:6: ( ruleRecordLiteral )
                    {
                    // InternalExprParser.g:2653:6: ( ruleRecordLiteral )
                    // InternalExprParser.g:2654:1: ruleRecordLiteral
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
                    // InternalExprParser.g:2659:6: ( ruleUnionLiteral )
                    {
                    // InternalExprParser.g:2659:6: ( ruleUnionLiteral )
                    // InternalExprParser.g:2660:1: ruleUnionLiteral
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
                    // InternalExprParser.g:2665:6: ( ruleTupleLiteral )
                    {
                    // InternalExprParser.g:2665:6: ( ruleTupleLiteral )
                    // InternalExprParser.g:2666:1: ruleTupleLiteral
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
                    // InternalExprParser.g:2671:6: ( ruleBagLiteral )
                    {
                    // InternalExprParser.g:2671:6: ( ruleBagLiteral )
                    // InternalExprParser.g:2672:1: ruleBagLiteral
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
                    // InternalExprParser.g:2677:6: ( ruleMapLiteral )
                    {
                    // InternalExprParser.g:2677:6: ( ruleMapLiteral )
                    // InternalExprParser.g:2678:1: ruleMapLiteral
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
    // InternalExprParser.g:2688:1: rule__BooleanLiteral__Alternatives_1 : ( ( ( rule__BooleanLiteral__ValueAssignment_1_0 ) ) | ( False ) );
    public final void rule__BooleanLiteral__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2692:1: ( ( ( rule__BooleanLiteral__ValueAssignment_1_0 ) ) | ( False ) )
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
                    // InternalExprParser.g:2693:1: ( ( rule__BooleanLiteral__ValueAssignment_1_0 ) )
                    {
                    // InternalExprParser.g:2693:1: ( ( rule__BooleanLiteral__ValueAssignment_1_0 ) )
                    // InternalExprParser.g:2694:1: ( rule__BooleanLiteral__ValueAssignment_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralAccess().getValueAssignment_1_0()); 
                    }
                    // InternalExprParser.g:2695:1: ( rule__BooleanLiteral__ValueAssignment_1_0 )
                    // InternalExprParser.g:2695:2: rule__BooleanLiteral__ValueAssignment_1_0
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
                    // InternalExprParser.g:2699:6: ( False )
                    {
                    // InternalExprParser.g:2699:6: ( False )
                    // InternalExprParser.g:2700:1: False
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
    // InternalExprParser.g:2712:1: rule__MetaClassEnum__Alternatives : ( ( ( Component ) ) | ( ( Subcomponent ) ) | ( ( Feature ) ) | ( ( Connection ) ) | ( ( Flow ) ) | ( ( Mode ) ) );
    public final void rule__MetaClassEnum__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2716:1: ( ( ( Component ) ) | ( ( Subcomponent ) ) | ( ( Feature ) ) | ( ( Connection ) ) | ( ( Flow ) ) | ( ( Mode ) ) )
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
                    // InternalExprParser.g:2717:1: ( ( Component ) )
                    {
                    // InternalExprParser.g:2717:1: ( ( Component ) )
                    // InternalExprParser.g:2718:1: ( Component )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMetaClassEnumAccess().getCOMPONENTEnumLiteralDeclaration_0()); 
                    }
                    // InternalExprParser.g:2719:1: ( Component )
                    // InternalExprParser.g:2719:3: Component
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
                    // InternalExprParser.g:2724:6: ( ( Subcomponent ) )
                    {
                    // InternalExprParser.g:2724:6: ( ( Subcomponent ) )
                    // InternalExprParser.g:2725:1: ( Subcomponent )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMetaClassEnumAccess().getSUBCOMPONENTEnumLiteralDeclaration_1()); 
                    }
                    // InternalExprParser.g:2726:1: ( Subcomponent )
                    // InternalExprParser.g:2726:3: Subcomponent
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
                    // InternalExprParser.g:2731:6: ( ( Feature ) )
                    {
                    // InternalExprParser.g:2731:6: ( ( Feature ) )
                    // InternalExprParser.g:2732:1: ( Feature )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMetaClassEnumAccess().getFEATUREEnumLiteralDeclaration_2()); 
                    }
                    // InternalExprParser.g:2733:1: ( Feature )
                    // InternalExprParser.g:2733:3: Feature
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
                    // InternalExprParser.g:2738:6: ( ( Connection ) )
                    {
                    // InternalExprParser.g:2738:6: ( ( Connection ) )
                    // InternalExprParser.g:2739:1: ( Connection )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMetaClassEnumAccess().getCONNECTIONEnumLiteralDeclaration_3()); 
                    }
                    // InternalExprParser.g:2740:1: ( Connection )
                    // InternalExprParser.g:2740:3: Connection
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
                    // InternalExprParser.g:2745:6: ( ( Flow ) )
                    {
                    // InternalExprParser.g:2745:6: ( ( Flow ) )
                    // InternalExprParser.g:2746:1: ( Flow )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMetaClassEnumAccess().getFLOWEnumLiteralDeclaration_4()); 
                    }
                    // InternalExprParser.g:2747:1: ( Flow )
                    // InternalExprParser.g:2747:3: Flow
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
                    // InternalExprParser.g:2752:6: ( ( Mode ) )
                    {
                    // InternalExprParser.g:2752:6: ( ( Mode ) )
                    // InternalExprParser.g:2753:1: ( Mode )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMetaClassEnumAccess().getMODEEnumLiteralDeclaration_5()); 
                    }
                    // InternalExprParser.g:2754:1: ( Mode )
                    // InternalExprParser.g:2754:3: Mode
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
    // InternalExprParser.g:2768:1: rule__ExprModel__Group_0__0 : rule__ExprModel__Group_0__0__Impl rule__ExprModel__Group_0__1 ;
    public final void rule__ExprModel__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2772:1: ( rule__ExprModel__Group_0__0__Impl rule__ExprModel__Group_0__1 )
            // InternalExprParser.g:2773:2: rule__ExprModel__Group_0__0__Impl rule__ExprModel__Group_0__1
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
    // InternalExprParser.g:2780:1: rule__ExprModel__Group_0__0__Impl : ( Library ) ;
    public final void rule__ExprModel__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2784:1: ( ( Library ) )
            // InternalExprParser.g:2785:1: ( Library )
            {
            // InternalExprParser.g:2785:1: ( Library )
            // InternalExprParser.g:2786:1: Library
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
    // InternalExprParser.g:2799:1: rule__ExprModel__Group_0__1 : rule__ExprModel__Group_0__1__Impl ;
    public final void rule__ExprModel__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2803:1: ( rule__ExprModel__Group_0__1__Impl )
            // InternalExprParser.g:2804:2: rule__ExprModel__Group_0__1__Impl
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
    // InternalExprParser.g:2810:1: rule__ExprModel__Group_0__1__Impl : ( ( rule__ExprModel__AnnexAssignment_0_1 ) ) ;
    public final void rule__ExprModel__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2814:1: ( ( ( rule__ExprModel__AnnexAssignment_0_1 ) ) )
            // InternalExprParser.g:2815:1: ( ( rule__ExprModel__AnnexAssignment_0_1 ) )
            {
            // InternalExprParser.g:2815:1: ( ( rule__ExprModel__AnnexAssignment_0_1 ) )
            // InternalExprParser.g:2816:1: ( rule__ExprModel__AnnexAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprModelAccess().getAnnexAssignment_0_1()); 
            }
            // InternalExprParser.g:2817:1: ( rule__ExprModel__AnnexAssignment_0_1 )
            // InternalExprParser.g:2817:2: rule__ExprModel__AnnexAssignment_0_1
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
    // InternalExprParser.g:2831:1: rule__ExprModel__Group_1__0 : rule__ExprModel__Group_1__0__Impl rule__ExprModel__Group_1__1 ;
    public final void rule__ExprModel__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2835:1: ( rule__ExprModel__Group_1__0__Impl rule__ExprModel__Group_1__1 )
            // InternalExprParser.g:2836:2: rule__ExprModel__Group_1__0__Impl rule__ExprModel__Group_1__1
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
    // InternalExprParser.g:2843:1: rule__ExprModel__Group_1__0__Impl : ( Subclause ) ;
    public final void rule__ExprModel__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2847:1: ( ( Subclause ) )
            // InternalExprParser.g:2848:1: ( Subclause )
            {
            // InternalExprParser.g:2848:1: ( Subclause )
            // InternalExprParser.g:2849:1: Subclause
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
    // InternalExprParser.g:2862:1: rule__ExprModel__Group_1__1 : rule__ExprModel__Group_1__1__Impl ;
    public final void rule__ExprModel__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2866:1: ( rule__ExprModel__Group_1__1__Impl )
            // InternalExprParser.g:2867:2: rule__ExprModel__Group_1__1__Impl
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
    // InternalExprParser.g:2873:1: rule__ExprModel__Group_1__1__Impl : ( ( rule__ExprModel__AnnexAssignment_1_1 ) ) ;
    public final void rule__ExprModel__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2877:1: ( ( ( rule__ExprModel__AnnexAssignment_1_1 ) ) )
            // InternalExprParser.g:2878:1: ( ( rule__ExprModel__AnnexAssignment_1_1 ) )
            {
            // InternalExprParser.g:2878:1: ( ( rule__ExprModel__AnnexAssignment_1_1 ) )
            // InternalExprParser.g:2879:1: ( rule__ExprModel__AnnexAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprModelAccess().getAnnexAssignment_1_1()); 
            }
            // InternalExprParser.g:2880:1: ( rule__ExprModel__AnnexAssignment_1_1 )
            // InternalExprParser.g:2880:2: rule__ExprModel__AnnexAssignment_1_1
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


    // $ANTLR start "rule__ExprLibrary__Group__0"
    // InternalExprParser.g:2894:1: rule__ExprLibrary__Group__0 : rule__ExprLibrary__Group__0__Impl rule__ExprLibrary__Group__1 ;
    public final void rule__ExprLibrary__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2898:1: ( rule__ExprLibrary__Group__0__Impl rule__ExprLibrary__Group__1 )
            // InternalExprParser.g:2899:2: rule__ExprLibrary__Group__0__Impl rule__ExprLibrary__Group__1
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
    // InternalExprParser.g:2906:1: rule__ExprLibrary__Group__0__Impl : ( () ) ;
    public final void rule__ExprLibrary__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2910:1: ( ( () ) )
            // InternalExprParser.g:2911:1: ( () )
            {
            // InternalExprParser.g:2911:1: ( () )
            // InternalExprParser.g:2912:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprLibraryAccess().getExprLibraryAction_0()); 
            }
            // InternalExprParser.g:2913:1: ()
            // InternalExprParser.g:2915:1: 
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
    // InternalExprParser.g:2925:1: rule__ExprLibrary__Group__1 : rule__ExprLibrary__Group__1__Impl ;
    public final void rule__ExprLibrary__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2929:1: ( rule__ExprLibrary__Group__1__Impl )
            // InternalExprParser.g:2930:2: rule__ExprLibrary__Group__1__Impl
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
    // InternalExprParser.g:2936:1: rule__ExprLibrary__Group__1__Impl : ( ( rule__ExprLibrary__DeclsAssignment_1 )* ) ;
    public final void rule__ExprLibrary__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2940:1: ( ( ( rule__ExprLibrary__DeclsAssignment_1 )* ) )
            // InternalExprParser.g:2941:1: ( ( rule__ExprLibrary__DeclsAssignment_1 )* )
            {
            // InternalExprParser.g:2941:1: ( ( rule__ExprLibrary__DeclsAssignment_1 )* )
            // InternalExprParser.g:2942:1: ( rule__ExprLibrary__DeclsAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprLibraryAccess().getDeclsAssignment_1()); 
            }
            // InternalExprParser.g:2943:1: ( rule__ExprLibrary__DeclsAssignment_1 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==Type||LA21_0==Def||(LA21_0>=Val && LA21_0<=Var)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalExprParser.g:2943:2: rule__ExprLibrary__DeclsAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__ExprLibrary__DeclsAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprLibraryAccess().getDeclsAssignment_1()); 
            }

            }


            }

        }
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
    // InternalExprParser.g:2957:1: rule__ExprSubclause__Group__0 : rule__ExprSubclause__Group__0__Impl rule__ExprSubclause__Group__1 ;
    public final void rule__ExprSubclause__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2961:1: ( rule__ExprSubclause__Group__0__Impl rule__ExprSubclause__Group__1 )
            // InternalExprParser.g:2962:2: rule__ExprSubclause__Group__0__Impl rule__ExprSubclause__Group__1
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
    // InternalExprParser.g:2969:1: rule__ExprSubclause__Group__0__Impl : ( () ) ;
    public final void rule__ExprSubclause__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2973:1: ( ( () ) )
            // InternalExprParser.g:2974:1: ( () )
            {
            // InternalExprParser.g:2974:1: ( () )
            // InternalExprParser.g:2975:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprSubclauseAccess().getExprSubclauseAction_0()); 
            }
            // InternalExprParser.g:2976:1: ()
            // InternalExprParser.g:2978:1: 
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
    // InternalExprParser.g:2988:1: rule__ExprSubclause__Group__1 : rule__ExprSubclause__Group__1__Impl ;
    public final void rule__ExprSubclause__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2992:1: ( rule__ExprSubclause__Group__1__Impl )
            // InternalExprParser.g:2993:2: rule__ExprSubclause__Group__1__Impl
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
    // InternalExprParser.g:2999:1: rule__ExprSubclause__Group__1__Impl : ( ( rule__ExprSubclause__DeclsAssignment_1 )* ) ;
    public final void rule__ExprSubclause__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3003:1: ( ( ( rule__ExprSubclause__DeclsAssignment_1 )* ) )
            // InternalExprParser.g:3004:1: ( ( rule__ExprSubclause__DeclsAssignment_1 )* )
            {
            // InternalExprParser.g:3004:1: ( ( rule__ExprSubclause__DeclsAssignment_1 )* )
            // InternalExprParser.g:3005:1: ( rule__ExprSubclause__DeclsAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprSubclauseAccess().getDeclsAssignment_1()); 
            }
            // InternalExprParser.g:3006:1: ( rule__ExprSubclause__DeclsAssignment_1 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==Type||LA22_0==Def||(LA22_0>=Val && LA22_0<=Var)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalExprParser.g:3006:2: rule__ExprSubclause__DeclsAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__ExprSubclause__DeclsAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprSubclauseAccess().getDeclsAssignment_1()); 
            }

            }


            }

        }
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
    // InternalExprParser.g:3020:1: rule__TypeDecl__Group__0 : rule__TypeDecl__Group__0__Impl rule__TypeDecl__Group__1 ;
    public final void rule__TypeDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3024:1: ( rule__TypeDecl__Group__0__Impl rule__TypeDecl__Group__1 )
            // InternalExprParser.g:3025:2: rule__TypeDecl__Group__0__Impl rule__TypeDecl__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalExprParser.g:3032:1: rule__TypeDecl__Group__0__Impl : ( Type ) ;
    public final void rule__TypeDecl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3036:1: ( ( Type ) )
            // InternalExprParser.g:3037:1: ( Type )
            {
            // InternalExprParser.g:3037:1: ( Type )
            // InternalExprParser.g:3038:1: Type
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDeclAccess().getTypeKeyword_0()); 
            }
            match(input,Type,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDeclAccess().getTypeKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDecl__Group__0__Impl"


    // $ANTLR start "rule__TypeDecl__Group__1"
    // InternalExprParser.g:3051:1: rule__TypeDecl__Group__1 : rule__TypeDecl__Group__1__Impl rule__TypeDecl__Group__2 ;
    public final void rule__TypeDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3055:1: ( rule__TypeDecl__Group__1__Impl rule__TypeDecl__Group__2 )
            // InternalExprParser.g:3056:2: rule__TypeDecl__Group__1__Impl rule__TypeDecl__Group__2
            {
            pushFollow(FOLLOW_6);
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
    // InternalExprParser.g:3063:1: rule__TypeDecl__Group__1__Impl : ( ( rule__TypeDecl__NameAssignment_1 ) ) ;
    public final void rule__TypeDecl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3067:1: ( ( ( rule__TypeDecl__NameAssignment_1 ) ) )
            // InternalExprParser.g:3068:1: ( ( rule__TypeDecl__NameAssignment_1 ) )
            {
            // InternalExprParser.g:3068:1: ( ( rule__TypeDecl__NameAssignment_1 ) )
            // InternalExprParser.g:3069:1: ( rule__TypeDecl__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDeclAccess().getNameAssignment_1()); 
            }
            // InternalExprParser.g:3070:1: ( rule__TypeDecl__NameAssignment_1 )
            // InternalExprParser.g:3070:2: rule__TypeDecl__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TypeDecl__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDeclAccess().getNameAssignment_1()); 
            }

            }


            }

        }
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
    // InternalExprParser.g:3080:1: rule__TypeDecl__Group__2 : rule__TypeDecl__Group__2__Impl rule__TypeDecl__Group__3 ;
    public final void rule__TypeDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3084:1: ( rule__TypeDecl__Group__2__Impl rule__TypeDecl__Group__3 )
            // InternalExprParser.g:3085:2: rule__TypeDecl__Group__2__Impl rule__TypeDecl__Group__3
            {
            pushFollow(FOLLOW_7);
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
    // InternalExprParser.g:3092:1: rule__TypeDecl__Group__2__Impl : ( Colon ) ;
    public final void rule__TypeDecl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3096:1: ( ( Colon ) )
            // InternalExprParser.g:3097:1: ( Colon )
            {
            // InternalExprParser.g:3097:1: ( Colon )
            // InternalExprParser.g:3098:1: Colon
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDeclAccess().getColonKeyword_2()); 
            }
            match(input,Colon,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDeclAccess().getColonKeyword_2()); 
            }

            }


            }

        }
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
    // InternalExprParser.g:3111:1: rule__TypeDecl__Group__3 : rule__TypeDecl__Group__3__Impl rule__TypeDecl__Group__4 ;
    public final void rule__TypeDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3115:1: ( rule__TypeDecl__Group__3__Impl rule__TypeDecl__Group__4 )
            // InternalExprParser.g:3116:2: rule__TypeDecl__Group__3__Impl rule__TypeDecl__Group__4
            {
            pushFollow(FOLLOW_8);
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
    // InternalExprParser.g:3123:1: rule__TypeDecl__Group__3__Impl : ( ( rule__TypeDecl__TypeAssignment_3 ) ) ;
    public final void rule__TypeDecl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3127:1: ( ( ( rule__TypeDecl__TypeAssignment_3 ) ) )
            // InternalExprParser.g:3128:1: ( ( rule__TypeDecl__TypeAssignment_3 ) )
            {
            // InternalExprParser.g:3128:1: ( ( rule__TypeDecl__TypeAssignment_3 ) )
            // InternalExprParser.g:3129:1: ( rule__TypeDecl__TypeAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDeclAccess().getTypeAssignment_3()); 
            }
            // InternalExprParser.g:3130:1: ( rule__TypeDecl__TypeAssignment_3 )
            // InternalExprParser.g:3130:2: rule__TypeDecl__TypeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__TypeDecl__TypeAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDeclAccess().getTypeAssignment_3()); 
            }

            }


            }

        }
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
    // InternalExprParser.g:3140:1: rule__TypeDecl__Group__4 : rule__TypeDecl__Group__4__Impl ;
    public final void rule__TypeDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3144:1: ( rule__TypeDecl__Group__4__Impl )
            // InternalExprParser.g:3145:2: rule__TypeDecl__Group__4__Impl
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
    // InternalExprParser.g:3151:1: rule__TypeDecl__Group__4__Impl : ( Semicolon ) ;
    public final void rule__TypeDecl__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3155:1: ( ( Semicolon ) )
            // InternalExprParser.g:3156:1: ( Semicolon )
            {
            // InternalExprParser.g:3156:1: ( Semicolon )
            // InternalExprParser.g:3157:1: Semicolon
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDeclAccess().getSemicolonKeyword_4()); 
            }
            match(input,Semicolon,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDeclAccess().getSemicolonKeyword_4()); 
            }

            }


            }

        }
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
    // InternalExprParser.g:3180:1: rule__VarDecl__Group__0 : rule__VarDecl__Group__0__Impl rule__VarDecl__Group__1 ;
    public final void rule__VarDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3184:1: ( rule__VarDecl__Group__0__Impl rule__VarDecl__Group__1 )
            // InternalExprParser.g:3185:2: rule__VarDecl__Group__0__Impl rule__VarDecl__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalExprParser.g:3192:1: rule__VarDecl__Group__0__Impl : ( ( rule__VarDecl__Alternatives_0 ) ) ;
    public final void rule__VarDecl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3196:1: ( ( ( rule__VarDecl__Alternatives_0 ) ) )
            // InternalExprParser.g:3197:1: ( ( rule__VarDecl__Alternatives_0 ) )
            {
            // InternalExprParser.g:3197:1: ( ( rule__VarDecl__Alternatives_0 ) )
            // InternalExprParser.g:3198:1: ( rule__VarDecl__Alternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getAlternatives_0()); 
            }
            // InternalExprParser.g:3199:1: ( rule__VarDecl__Alternatives_0 )
            // InternalExprParser.g:3199:2: rule__VarDecl__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__VarDecl__Alternatives_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getAlternatives_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__Group__0__Impl"


    // $ANTLR start "rule__VarDecl__Group__1"
    // InternalExprParser.g:3209:1: rule__VarDecl__Group__1 : rule__VarDecl__Group__1__Impl rule__VarDecl__Group__2 ;
    public final void rule__VarDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3213:1: ( rule__VarDecl__Group__1__Impl rule__VarDecl__Group__2 )
            // InternalExprParser.g:3214:2: rule__VarDecl__Group__1__Impl rule__VarDecl__Group__2
            {
            pushFollow(FOLLOW_9);
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
    // InternalExprParser.g:3221:1: rule__VarDecl__Group__1__Impl : ( ( rule__VarDecl__NameAssignment_1 ) ) ;
    public final void rule__VarDecl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3225:1: ( ( ( rule__VarDecl__NameAssignment_1 ) ) )
            // InternalExprParser.g:3226:1: ( ( rule__VarDecl__NameAssignment_1 ) )
            {
            // InternalExprParser.g:3226:1: ( ( rule__VarDecl__NameAssignment_1 ) )
            // InternalExprParser.g:3227:1: ( rule__VarDecl__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getNameAssignment_1()); 
            }
            // InternalExprParser.g:3228:1: ( rule__VarDecl__NameAssignment_1 )
            // InternalExprParser.g:3228:2: rule__VarDecl__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__VarDecl__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getNameAssignment_1()); 
            }

            }


            }

        }
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
    // InternalExprParser.g:3238:1: rule__VarDecl__Group__2 : rule__VarDecl__Group__2__Impl rule__VarDecl__Group__3 ;
    public final void rule__VarDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3242:1: ( rule__VarDecl__Group__2__Impl rule__VarDecl__Group__3 )
            // InternalExprParser.g:3243:2: rule__VarDecl__Group__2__Impl rule__VarDecl__Group__3
            {
            pushFollow(FOLLOW_9);
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
    // InternalExprParser.g:3250:1: rule__VarDecl__Group__2__Impl : ( ( rule__VarDecl__Group_2__0 )? ) ;
    public final void rule__VarDecl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3254:1: ( ( ( rule__VarDecl__Group_2__0 )? ) )
            // InternalExprParser.g:3255:1: ( ( rule__VarDecl__Group_2__0 )? )
            {
            // InternalExprParser.g:3255:1: ( ( rule__VarDecl__Group_2__0 )? )
            // InternalExprParser.g:3256:1: ( rule__VarDecl__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getGroup_2()); 
            }
            // InternalExprParser.g:3257:1: ( rule__VarDecl__Group_2__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==Colon) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalExprParser.g:3257:2: rule__VarDecl__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VarDecl__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getGroup_2()); 
            }

            }


            }

        }
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
    // InternalExprParser.g:3267:1: rule__VarDecl__Group__3 : rule__VarDecl__Group__3__Impl rule__VarDecl__Group__4 ;
    public final void rule__VarDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3271:1: ( rule__VarDecl__Group__3__Impl rule__VarDecl__Group__4 )
            // InternalExprParser.g:3272:2: rule__VarDecl__Group__3__Impl rule__VarDecl__Group__4
            {
            pushFollow(FOLLOW_9);
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
    // InternalExprParser.g:3279:1: rule__VarDecl__Group__3__Impl : ( ( rule__VarDecl__Group_3__0 )? ) ;
    public final void rule__VarDecl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3283:1: ( ( ( rule__VarDecl__Group_3__0 )? ) )
            // InternalExprParser.g:3284:1: ( ( rule__VarDecl__Group_3__0 )? )
            {
            // InternalExprParser.g:3284:1: ( ( rule__VarDecl__Group_3__0 )? )
            // InternalExprParser.g:3285:1: ( rule__VarDecl__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getGroup_3()); 
            }
            // InternalExprParser.g:3286:1: ( rule__VarDecl__Group_3__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==EqualsSign) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalExprParser.g:3286:2: rule__VarDecl__Group_3__0
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
    // InternalExprParser.g:3296:1: rule__VarDecl__Group__4 : rule__VarDecl__Group__4__Impl ;
    public final void rule__VarDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3300:1: ( rule__VarDecl__Group__4__Impl )
            // InternalExprParser.g:3301:2: rule__VarDecl__Group__4__Impl
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
    // InternalExprParser.g:3307:1: rule__VarDecl__Group__4__Impl : ( Semicolon ) ;
    public final void rule__VarDecl__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3311:1: ( ( Semicolon ) )
            // InternalExprParser.g:3312:1: ( Semicolon )
            {
            // InternalExprParser.g:3312:1: ( Semicolon )
            // InternalExprParser.g:3313:1: Semicolon
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getSemicolonKeyword_4()); 
            }
            match(input,Semicolon,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getSemicolonKeyword_4()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__VarDecl__Group_2__0"
    // InternalExprParser.g:3336:1: rule__VarDecl__Group_2__0 : rule__VarDecl__Group_2__0__Impl rule__VarDecl__Group_2__1 ;
    public final void rule__VarDecl__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3340:1: ( rule__VarDecl__Group_2__0__Impl rule__VarDecl__Group_2__1 )
            // InternalExprParser.g:3341:2: rule__VarDecl__Group_2__0__Impl rule__VarDecl__Group_2__1
            {
            pushFollow(FOLLOW_7);
            rule__VarDecl__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__VarDecl__Group_2__1();

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
    // $ANTLR end "rule__VarDecl__Group_2__0"


    // $ANTLR start "rule__VarDecl__Group_2__0__Impl"
    // InternalExprParser.g:3348:1: rule__VarDecl__Group_2__0__Impl : ( Colon ) ;
    public final void rule__VarDecl__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3352:1: ( ( Colon ) )
            // InternalExprParser.g:3353:1: ( Colon )
            {
            // InternalExprParser.g:3353:1: ( Colon )
            // InternalExprParser.g:3354:1: Colon
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getColonKeyword_2_0()); 
            }
            match(input,Colon,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getColonKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__Group_2__0__Impl"


    // $ANTLR start "rule__VarDecl__Group_2__1"
    // InternalExprParser.g:3367:1: rule__VarDecl__Group_2__1 : rule__VarDecl__Group_2__1__Impl ;
    public final void rule__VarDecl__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3371:1: ( rule__VarDecl__Group_2__1__Impl )
            // InternalExprParser.g:3372:2: rule__VarDecl__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VarDecl__Group_2__1__Impl();

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
    // $ANTLR end "rule__VarDecl__Group_2__1"


    // $ANTLR start "rule__VarDecl__Group_2__1__Impl"
    // InternalExprParser.g:3378:1: rule__VarDecl__Group_2__1__Impl : ( ( rule__VarDecl__TypeAssignment_2_1 ) ) ;
    public final void rule__VarDecl__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3382:1: ( ( ( rule__VarDecl__TypeAssignment_2_1 ) ) )
            // InternalExprParser.g:3383:1: ( ( rule__VarDecl__TypeAssignment_2_1 ) )
            {
            // InternalExprParser.g:3383:1: ( ( rule__VarDecl__TypeAssignment_2_1 ) )
            // InternalExprParser.g:3384:1: ( rule__VarDecl__TypeAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getTypeAssignment_2_1()); 
            }
            // InternalExprParser.g:3385:1: ( rule__VarDecl__TypeAssignment_2_1 )
            // InternalExprParser.g:3385:2: rule__VarDecl__TypeAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__VarDecl__TypeAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getTypeAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__Group_2__1__Impl"


    // $ANTLR start "rule__VarDecl__Group_3__0"
    // InternalExprParser.g:3399:1: rule__VarDecl__Group_3__0 : rule__VarDecl__Group_3__0__Impl rule__VarDecl__Group_3__1 ;
    public final void rule__VarDecl__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3403:1: ( rule__VarDecl__Group_3__0__Impl rule__VarDecl__Group_3__1 )
            // InternalExprParser.g:3404:2: rule__VarDecl__Group_3__0__Impl rule__VarDecl__Group_3__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalExprParser.g:3411:1: rule__VarDecl__Group_3__0__Impl : ( EqualsSign ) ;
    public final void rule__VarDecl__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3415:1: ( ( EqualsSign ) )
            // InternalExprParser.g:3416:1: ( EqualsSign )
            {
            // InternalExprParser.g:3416:1: ( EqualsSign )
            // InternalExprParser.g:3417:1: EqualsSign
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getEqualsSignKeyword_3_0()); 
            }
            match(input,EqualsSign,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getEqualsSignKeyword_3_0()); 
            }

            }


            }

        }
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
    // InternalExprParser.g:3430:1: rule__VarDecl__Group_3__1 : rule__VarDecl__Group_3__1__Impl ;
    public final void rule__VarDecl__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3434:1: ( rule__VarDecl__Group_3__1__Impl )
            // InternalExprParser.g:3435:2: rule__VarDecl__Group_3__1__Impl
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
    // InternalExprParser.g:3441:1: rule__VarDecl__Group_3__1__Impl : ( ( rule__VarDecl__ValueAssignment_3_1 ) ) ;
    public final void rule__VarDecl__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3445:1: ( ( ( rule__VarDecl__ValueAssignment_3_1 ) ) )
            // InternalExprParser.g:3446:1: ( ( rule__VarDecl__ValueAssignment_3_1 ) )
            {
            // InternalExprParser.g:3446:1: ( ( rule__VarDecl__ValueAssignment_3_1 ) )
            // InternalExprParser.g:3447:1: ( rule__VarDecl__ValueAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getValueAssignment_3_1()); 
            }
            // InternalExprParser.g:3448:1: ( rule__VarDecl__ValueAssignment_3_1 )
            // InternalExprParser.g:3448:2: rule__VarDecl__ValueAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__VarDecl__ValueAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getValueAssignment_3_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__FunDecl__Group__0"
    // InternalExprParser.g:3462:1: rule__FunDecl__Group__0 : rule__FunDecl__Group__0__Impl rule__FunDecl__Group__1 ;
    public final void rule__FunDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3466:1: ( rule__FunDecl__Group__0__Impl rule__FunDecl__Group__1 )
            // InternalExprParser.g:3467:2: rule__FunDecl__Group__0__Impl rule__FunDecl__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalExprParser.g:3474:1: rule__FunDecl__Group__0__Impl : ( Def ) ;
    public final void rule__FunDecl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3478:1: ( ( Def ) )
            // InternalExprParser.g:3479:1: ( Def )
            {
            // InternalExprParser.g:3479:1: ( Def )
            // InternalExprParser.g:3480:1: Def
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunDeclAccess().getDefKeyword_0()); 
            }
            match(input,Def,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunDeclAccess().getDefKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunDecl__Group__0__Impl"


    // $ANTLR start "rule__FunDecl__Group__1"
    // InternalExprParser.g:3493:1: rule__FunDecl__Group__1 : rule__FunDecl__Group__1__Impl rule__FunDecl__Group__2 ;
    public final void rule__FunDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3497:1: ( rule__FunDecl__Group__1__Impl rule__FunDecl__Group__2 )
            // InternalExprParser.g:3498:2: rule__FunDecl__Group__1__Impl rule__FunDecl__Group__2
            {
            pushFollow(FOLLOW_11);
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
    // InternalExprParser.g:3505:1: rule__FunDecl__Group__1__Impl : ( ( rule__FunDecl__NameAssignment_1 ) ) ;
    public final void rule__FunDecl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3509:1: ( ( ( rule__FunDecl__NameAssignment_1 ) ) )
            // InternalExprParser.g:3510:1: ( ( rule__FunDecl__NameAssignment_1 ) )
            {
            // InternalExprParser.g:3510:1: ( ( rule__FunDecl__NameAssignment_1 ) )
            // InternalExprParser.g:3511:1: ( rule__FunDecl__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunDeclAccess().getNameAssignment_1()); 
            }
            // InternalExprParser.g:3512:1: ( rule__FunDecl__NameAssignment_1 )
            // InternalExprParser.g:3512:2: rule__FunDecl__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__FunDecl__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunDeclAccess().getNameAssignment_1()); 
            }

            }


            }

        }
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
    // InternalExprParser.g:3522:1: rule__FunDecl__Group__2 : rule__FunDecl__Group__2__Impl rule__FunDecl__Group__3 ;
    public final void rule__FunDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3526:1: ( rule__FunDecl__Group__2__Impl rule__FunDecl__Group__3 )
            // InternalExprParser.g:3527:2: rule__FunDecl__Group__2__Impl rule__FunDecl__Group__3
            {
            pushFollow(FOLLOW_12);
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
    // InternalExprParser.g:3534:1: rule__FunDecl__Group__2__Impl : ( LeftParenthesis ) ;
    public final void rule__FunDecl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3538:1: ( ( LeftParenthesis ) )
            // InternalExprParser.g:3539:1: ( LeftParenthesis )
            {
            // InternalExprParser.g:3539:1: ( LeftParenthesis )
            // InternalExprParser.g:3540:1: LeftParenthesis
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunDeclAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,LeftParenthesis,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunDeclAccess().getLeftParenthesisKeyword_2()); 
            }

            }


            }

        }
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
    // InternalExprParser.g:3553:1: rule__FunDecl__Group__3 : rule__FunDecl__Group__3__Impl rule__FunDecl__Group__4 ;
    public final void rule__FunDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3557:1: ( rule__FunDecl__Group__3__Impl rule__FunDecl__Group__4 )
            // InternalExprParser.g:3558:2: rule__FunDecl__Group__3__Impl rule__FunDecl__Group__4
            {
            pushFollow(FOLLOW_8);
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
    // InternalExprParser.g:3565:1: rule__FunDecl__Group__3__Impl : ( RightParenthesis ) ;
    public final void rule__FunDecl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3569:1: ( ( RightParenthesis ) )
            // InternalExprParser.g:3570:1: ( RightParenthesis )
            {
            // InternalExprParser.g:3570:1: ( RightParenthesis )
            // InternalExprParser.g:3571:1: RightParenthesis
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunDeclAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,RightParenthesis,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunDeclAccess().getRightParenthesisKeyword_3()); 
            }

            }


            }

        }
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
    // InternalExprParser.g:3584:1: rule__FunDecl__Group__4 : rule__FunDecl__Group__4__Impl ;
    public final void rule__FunDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3588:1: ( rule__FunDecl__Group__4__Impl )
            // InternalExprParser.g:3589:2: rule__FunDecl__Group__4__Impl
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
    // InternalExprParser.g:3595:1: rule__FunDecl__Group__4__Impl : ( Semicolon ) ;
    public final void rule__FunDecl__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3599:1: ( ( Semicolon ) )
            // InternalExprParser.g:3600:1: ( Semicolon )
            {
            // InternalExprParser.g:3600:1: ( Semicolon )
            // InternalExprParser.g:3601:1: Semicolon
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunDeclAccess().getSemicolonKeyword_4()); 
            }
            match(input,Semicolon,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunDeclAccess().getSemicolonKeyword_4()); 
            }

            }


            }

        }
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
    // InternalExprParser.g:3624:1: rule__PrimitiveType__Group_0__0 : rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1 ;
    public final void rule__PrimitiveType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3628:1: ( rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1 )
            // InternalExprParser.g:3629:2: rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalExprParser.g:3636:1: rule__PrimitiveType__Group_0__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3640:1: ( ( () ) )
            // InternalExprParser.g:3641:1: ( () )
            {
            // InternalExprParser.g:3641:1: ( () )
            // InternalExprParser.g:3642:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveTypeAccess().getBooleanAction_0_0()); 
            }
            // InternalExprParser.g:3643:1: ()
            // InternalExprParser.g:3645:1: 
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
    // InternalExprParser.g:3655:1: rule__PrimitiveType__Group_0__1 : rule__PrimitiveType__Group_0__1__Impl ;
    public final void rule__PrimitiveType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3659:1: ( rule__PrimitiveType__Group_0__1__Impl )
            // InternalExprParser.g:3660:2: rule__PrimitiveType__Group_0__1__Impl
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
    // InternalExprParser.g:3666:1: rule__PrimitiveType__Group_0__1__Impl : ( Bool ) ;
    public final void rule__PrimitiveType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3670:1: ( ( Bool ) )
            // InternalExprParser.g:3671:1: ( Bool )
            {
            // InternalExprParser.g:3671:1: ( Bool )
            // InternalExprParser.g:3672:1: Bool
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
    // InternalExprParser.g:3689:1: rule__PrimitiveType__Group_1__0 : rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1 ;
    public final void rule__PrimitiveType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3693:1: ( rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1 )
            // InternalExprParser.g:3694:2: rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalExprParser.g:3701:1: rule__PrimitiveType__Group_1__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3705:1: ( ( () ) )
            // InternalExprParser.g:3706:1: ( () )
            {
            // InternalExprParser.g:3706:1: ( () )
            // InternalExprParser.g:3707:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveTypeAccess().getIntegerAction_1_0()); 
            }
            // InternalExprParser.g:3708:1: ()
            // InternalExprParser.g:3710:1: 
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
    // InternalExprParser.g:3720:1: rule__PrimitiveType__Group_1__1 : rule__PrimitiveType__Group_1__1__Impl ;
    public final void rule__PrimitiveType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3724:1: ( rule__PrimitiveType__Group_1__1__Impl )
            // InternalExprParser.g:3725:2: rule__PrimitiveType__Group_1__1__Impl
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
    // InternalExprParser.g:3731:1: rule__PrimitiveType__Group_1__1__Impl : ( Int ) ;
    public final void rule__PrimitiveType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3735:1: ( ( Int ) )
            // InternalExprParser.g:3736:1: ( Int )
            {
            // InternalExprParser.g:3736:1: ( Int )
            // InternalExprParser.g:3737:1: Int
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
    // InternalExprParser.g:3754:1: rule__PrimitiveType__Group_2__0 : rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1 ;
    public final void rule__PrimitiveType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3758:1: ( rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1 )
            // InternalExprParser.g:3759:2: rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1
            {
            pushFollow(FOLLOW_15);
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
    // InternalExprParser.g:3766:1: rule__PrimitiveType__Group_2__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3770:1: ( ( () ) )
            // InternalExprParser.g:3771:1: ( () )
            {
            // InternalExprParser.g:3771:1: ( () )
            // InternalExprParser.g:3772:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveTypeAccess().getRealAction_2_0()); 
            }
            // InternalExprParser.g:3773:1: ()
            // InternalExprParser.g:3775:1: 
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
    // InternalExprParser.g:3785:1: rule__PrimitiveType__Group_2__1 : rule__PrimitiveType__Group_2__1__Impl ;
    public final void rule__PrimitiveType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3789:1: ( rule__PrimitiveType__Group_2__1__Impl )
            // InternalExprParser.g:3790:2: rule__PrimitiveType__Group_2__1__Impl
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
    // InternalExprParser.g:3796:1: rule__PrimitiveType__Group_2__1__Impl : ( Real ) ;
    public final void rule__PrimitiveType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3800:1: ( ( Real ) )
            // InternalExprParser.g:3801:1: ( Real )
            {
            // InternalExprParser.g:3801:1: ( Real )
            // InternalExprParser.g:3802:1: Real
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
    // InternalExprParser.g:3819:1: rule__PrimitiveType__Group_3__0 : rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1 ;
    public final void rule__PrimitiveType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3823:1: ( rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1 )
            // InternalExprParser.g:3824:2: rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalExprParser.g:3831:1: rule__PrimitiveType__Group_3__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3835:1: ( ( () ) )
            // InternalExprParser.g:3836:1: ( () )
            {
            // InternalExprParser.g:3836:1: ( () )
            // InternalExprParser.g:3837:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveTypeAccess().getStringAction_3_0()); 
            }
            // InternalExprParser.g:3838:1: ()
            // InternalExprParser.g:3840:1: 
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
    // InternalExprParser.g:3850:1: rule__PrimitiveType__Group_3__1 : rule__PrimitiveType__Group_3__1__Impl ;
    public final void rule__PrimitiveType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3854:1: ( rule__PrimitiveType__Group_3__1__Impl )
            // InternalExprParser.g:3855:2: rule__PrimitiveType__Group_3__1__Impl
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
    // InternalExprParser.g:3861:1: rule__PrimitiveType__Group_3__1__Impl : ( String ) ;
    public final void rule__PrimitiveType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3865:1: ( ( String ) )
            // InternalExprParser.g:3866:1: ( String )
            {
            // InternalExprParser.g:3866:1: ( String )
            // InternalExprParser.g:3867:1: String
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
    // InternalExprParser.g:3884:1: rule__ComponentCategory__Group_8__0 : rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1 ;
    public final void rule__ComponentCategory__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3888:1: ( rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1 )
            // InternalExprParser.g:3889:2: rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalExprParser.g:3896:1: rule__ComponentCategory__Group_8__0__Impl : ( Subprogram ) ;
    public final void rule__ComponentCategory__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3900:1: ( ( Subprogram ) )
            // InternalExprParser.g:3901:1: ( Subprogram )
            {
            // InternalExprParser.g:3901:1: ( Subprogram )
            // InternalExprParser.g:3902:1: Subprogram
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
    // InternalExprParser.g:3915:1: rule__ComponentCategory__Group_8__1 : rule__ComponentCategory__Group_8__1__Impl ;
    public final void rule__ComponentCategory__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3919:1: ( rule__ComponentCategory__Group_8__1__Impl )
            // InternalExprParser.g:3920:2: rule__ComponentCategory__Group_8__1__Impl
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
    // InternalExprParser.g:3926:1: rule__ComponentCategory__Group_8__1__Impl : ( Group ) ;
    public final void rule__ComponentCategory__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3930:1: ( ( Group ) )
            // InternalExprParser.g:3931:1: ( Group )
            {
            // InternalExprParser.g:3931:1: ( Group )
            // InternalExprParser.g:3932:1: Group
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
    // InternalExprParser.g:3949:1: rule__ComponentCategory__Group_10__0 : rule__ComponentCategory__Group_10__0__Impl rule__ComponentCategory__Group_10__1 ;
    public final void rule__ComponentCategory__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3953:1: ( rule__ComponentCategory__Group_10__0__Impl rule__ComponentCategory__Group_10__1 )
            // InternalExprParser.g:3954:2: rule__ComponentCategory__Group_10__0__Impl rule__ComponentCategory__Group_10__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalExprParser.g:3961:1: rule__ComponentCategory__Group_10__0__Impl : ( Thread ) ;
    public final void rule__ComponentCategory__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3965:1: ( ( Thread ) )
            // InternalExprParser.g:3966:1: ( Thread )
            {
            // InternalExprParser.g:3966:1: ( Thread )
            // InternalExprParser.g:3967:1: Thread
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
    // InternalExprParser.g:3980:1: rule__ComponentCategory__Group_10__1 : rule__ComponentCategory__Group_10__1__Impl ;
    public final void rule__ComponentCategory__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3984:1: ( rule__ComponentCategory__Group_10__1__Impl )
            // InternalExprParser.g:3985:2: rule__ComponentCategory__Group_10__1__Impl
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
    // InternalExprParser.g:3991:1: rule__ComponentCategory__Group_10__1__Impl : ( Group ) ;
    public final void rule__ComponentCategory__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3995:1: ( ( Group ) )
            // InternalExprParser.g:3996:1: ( Group )
            {
            // InternalExprParser.g:3996:1: ( Group )
            // InternalExprParser.g:3997:1: Group
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
    // InternalExprParser.g:4014:1: rule__ComponentCategory__Group_12__0 : rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1 ;
    public final void rule__ComponentCategory__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4018:1: ( rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1 )
            // InternalExprParser.g:4019:2: rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalExprParser.g:4026:1: rule__ComponentCategory__Group_12__0__Impl : ( Virtual ) ;
    public final void rule__ComponentCategory__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4030:1: ( ( Virtual ) )
            // InternalExprParser.g:4031:1: ( Virtual )
            {
            // InternalExprParser.g:4031:1: ( Virtual )
            // InternalExprParser.g:4032:1: Virtual
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
    // InternalExprParser.g:4045:1: rule__ComponentCategory__Group_12__1 : rule__ComponentCategory__Group_12__1__Impl ;
    public final void rule__ComponentCategory__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4049:1: ( rule__ComponentCategory__Group_12__1__Impl )
            // InternalExprParser.g:4050:2: rule__ComponentCategory__Group_12__1__Impl
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
    // InternalExprParser.g:4056:1: rule__ComponentCategory__Group_12__1__Impl : ( Bus ) ;
    public final void rule__ComponentCategory__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4060:1: ( ( Bus ) )
            // InternalExprParser.g:4061:1: ( Bus )
            {
            // InternalExprParser.g:4061:1: ( Bus )
            // InternalExprParser.g:4062:1: Bus
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
    // InternalExprParser.g:4079:1: rule__ComponentCategory__Group_13__0 : rule__ComponentCategory__Group_13__0__Impl rule__ComponentCategory__Group_13__1 ;
    public final void rule__ComponentCategory__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4083:1: ( rule__ComponentCategory__Group_13__0__Impl rule__ComponentCategory__Group_13__1 )
            // InternalExprParser.g:4084:2: rule__ComponentCategory__Group_13__0__Impl rule__ComponentCategory__Group_13__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalExprParser.g:4091:1: rule__ComponentCategory__Group_13__0__Impl : ( Virtual ) ;
    public final void rule__ComponentCategory__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4095:1: ( ( Virtual ) )
            // InternalExprParser.g:4096:1: ( Virtual )
            {
            // InternalExprParser.g:4096:1: ( Virtual )
            // InternalExprParser.g:4097:1: Virtual
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
    // InternalExprParser.g:4110:1: rule__ComponentCategory__Group_13__1 : rule__ComponentCategory__Group_13__1__Impl ;
    public final void rule__ComponentCategory__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4114:1: ( rule__ComponentCategory__Group_13__1__Impl )
            // InternalExprParser.g:4115:2: rule__ComponentCategory__Group_13__1__Impl
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
    // InternalExprParser.g:4121:1: rule__ComponentCategory__Group_13__1__Impl : ( Processor ) ;
    public final void rule__ComponentCategory__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4125:1: ( ( Processor ) )
            // InternalExprParser.g:4126:1: ( Processor )
            {
            // InternalExprParser.g:4126:1: ( Processor )
            // InternalExprParser.g:4127:1: Processor
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
    // InternalExprParser.g:4144:1: rule__ClassifierType__Group__0 : rule__ClassifierType__Group__0__Impl rule__ClassifierType__Group__1 ;
    public final void rule__ClassifierType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4148:1: ( rule__ClassifierType__Group__0__Impl rule__ClassifierType__Group__1 )
            // InternalExprParser.g:4149:2: rule__ClassifierType__Group__0__Impl rule__ClassifierType__Group__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalExprParser.g:4156:1: rule__ClassifierType__Group__0__Impl : ( () ) ;
    public final void rule__ClassifierType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4160:1: ( ( () ) )
            // InternalExprParser.g:4161:1: ( () )
            {
            // InternalExprParser.g:4161:1: ( () )
            // InternalExprParser.g:4162:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeAccess().getClassifierTypeAction_0()); 
            }
            // InternalExprParser.g:4163:1: ()
            // InternalExprParser.g:4165:1: 
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
    // InternalExprParser.g:4175:1: rule__ClassifierType__Group__1 : rule__ClassifierType__Group__1__Impl rule__ClassifierType__Group__2 ;
    public final void rule__ClassifierType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4179:1: ( rule__ClassifierType__Group__1__Impl rule__ClassifierType__Group__2 )
            // InternalExprParser.g:4180:2: rule__ClassifierType__Group__1__Impl rule__ClassifierType__Group__2
            {
            pushFollow(FOLLOW_11);
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
    // InternalExprParser.g:4187:1: rule__ClassifierType__Group__1__Impl : ( Classifier ) ;
    public final void rule__ClassifierType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4191:1: ( ( Classifier ) )
            // InternalExprParser.g:4192:1: ( Classifier )
            {
            // InternalExprParser.g:4192:1: ( Classifier )
            // InternalExprParser.g:4193:1: Classifier
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
    // InternalExprParser.g:4206:1: rule__ClassifierType__Group__2 : rule__ClassifierType__Group__2__Impl ;
    public final void rule__ClassifierType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4210:1: ( rule__ClassifierType__Group__2__Impl )
            // InternalExprParser.g:4211:2: rule__ClassifierType__Group__2__Impl
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
    // InternalExprParser.g:4217:1: rule__ClassifierType__Group__2__Impl : ( ( rule__ClassifierType__Group_2__0 )? ) ;
    public final void rule__ClassifierType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4221:1: ( ( ( rule__ClassifierType__Group_2__0 )? ) )
            // InternalExprParser.g:4222:1: ( ( rule__ClassifierType__Group_2__0 )? )
            {
            // InternalExprParser.g:4222:1: ( ( rule__ClassifierType__Group_2__0 )? )
            // InternalExprParser.g:4223:1: ( rule__ClassifierType__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeAccess().getGroup_2()); 
            }
            // InternalExprParser.g:4224:1: ( rule__ClassifierType__Group_2__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==LeftParenthesis) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalExprParser.g:4224:2: rule__ClassifierType__Group_2__0
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
    // InternalExprParser.g:4240:1: rule__ClassifierType__Group_2__0 : rule__ClassifierType__Group_2__0__Impl rule__ClassifierType__Group_2__1 ;
    public final void rule__ClassifierType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4244:1: ( rule__ClassifierType__Group_2__0__Impl rule__ClassifierType__Group_2__1 )
            // InternalExprParser.g:4245:2: rule__ClassifierType__Group_2__0__Impl rule__ClassifierType__Group_2__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalExprParser.g:4252:1: rule__ClassifierType__Group_2__0__Impl : ( LeftParenthesis ) ;
    public final void rule__ClassifierType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4256:1: ( ( LeftParenthesis ) )
            // InternalExprParser.g:4257:1: ( LeftParenthesis )
            {
            // InternalExprParser.g:4257:1: ( LeftParenthesis )
            // InternalExprParser.g:4258:1: LeftParenthesis
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
    // InternalExprParser.g:4271:1: rule__ClassifierType__Group_2__1 : rule__ClassifierType__Group_2__1__Impl rule__ClassifierType__Group_2__2 ;
    public final void rule__ClassifierType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4275:1: ( rule__ClassifierType__Group_2__1__Impl rule__ClassifierType__Group_2__2 )
            // InternalExprParser.g:4276:2: rule__ClassifierType__Group_2__1__Impl rule__ClassifierType__Group_2__2
            {
            pushFollow(FOLLOW_12);
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
    // InternalExprParser.g:4283:1: rule__ClassifierType__Group_2__1__Impl : ( ( rule__ClassifierType__BaseAssignment_2_1 ) ) ;
    public final void rule__ClassifierType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4287:1: ( ( ( rule__ClassifierType__BaseAssignment_2_1 ) ) )
            // InternalExprParser.g:4288:1: ( ( rule__ClassifierType__BaseAssignment_2_1 ) )
            {
            // InternalExprParser.g:4288:1: ( ( rule__ClassifierType__BaseAssignment_2_1 ) )
            // InternalExprParser.g:4289:1: ( rule__ClassifierType__BaseAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeAccess().getBaseAssignment_2_1()); 
            }
            // InternalExprParser.g:4290:1: ( rule__ClassifierType__BaseAssignment_2_1 )
            // InternalExprParser.g:4290:2: rule__ClassifierType__BaseAssignment_2_1
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
    // InternalExprParser.g:4300:1: rule__ClassifierType__Group_2__2 : rule__ClassifierType__Group_2__2__Impl ;
    public final void rule__ClassifierType__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4304:1: ( rule__ClassifierType__Group_2__2__Impl )
            // InternalExprParser.g:4305:2: rule__ClassifierType__Group_2__2__Impl
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
    // InternalExprParser.g:4311:1: rule__ClassifierType__Group_2__2__Impl : ( RightParenthesis ) ;
    public final void rule__ClassifierType__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4315:1: ( ( RightParenthesis ) )
            // InternalExprParser.g:4316:1: ( RightParenthesis )
            {
            // InternalExprParser.g:4316:1: ( RightParenthesis )
            // InternalExprParser.g:4317:1: RightParenthesis
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
    // InternalExprParser.g:4336:1: rule__RecordType__Group__0 : rule__RecordType__Group__0__Impl rule__RecordType__Group__1 ;
    public final void rule__RecordType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4340:1: ( rule__RecordType__Group__0__Impl rule__RecordType__Group__1 )
            // InternalExprParser.g:4341:2: rule__RecordType__Group__0__Impl rule__RecordType__Group__1
            {
            pushFollow(FOLLOW_21);
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
    // InternalExprParser.g:4348:1: rule__RecordType__Group__0__Impl : ( () ) ;
    public final void rule__RecordType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4352:1: ( ( () ) )
            // InternalExprParser.g:4353:1: ( () )
            {
            // InternalExprParser.g:4353:1: ( () )
            // InternalExprParser.g:4354:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecordTypeAccess().getRecordTypeAction_0()); 
            }
            // InternalExprParser.g:4355:1: ()
            // InternalExprParser.g:4357:1: 
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
    // InternalExprParser.g:4367:1: rule__RecordType__Group__1 : rule__RecordType__Group__1__Impl rule__RecordType__Group__2 ;
    public final void rule__RecordType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4371:1: ( rule__RecordType__Group__1__Impl rule__RecordType__Group__2 )
            // InternalExprParser.g:4372:2: rule__RecordType__Group__1__Impl rule__RecordType__Group__2
            {
            pushFollow(FOLLOW_22);
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
    // InternalExprParser.g:4379:1: rule__RecordType__Group__1__Impl : ( Record ) ;
    public final void rule__RecordType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4383:1: ( ( Record ) )
            // InternalExprParser.g:4384:1: ( Record )
            {
            // InternalExprParser.g:4384:1: ( Record )
            // InternalExprParser.g:4385:1: Record
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
    // InternalExprParser.g:4398:1: rule__RecordType__Group__2 : rule__RecordType__Group__2__Impl rule__RecordType__Group__3 ;
    public final void rule__RecordType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4402:1: ( rule__RecordType__Group__2__Impl rule__RecordType__Group__3 )
            // InternalExprParser.g:4403:2: rule__RecordType__Group__2__Impl rule__RecordType__Group__3
            {
            pushFollow(FOLLOW_23);
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
    // InternalExprParser.g:4410:1: rule__RecordType__Group__2__Impl : ( LeftCurlyBracket ) ;
    public final void rule__RecordType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4414:1: ( ( LeftCurlyBracket ) )
            // InternalExprParser.g:4415:1: ( LeftCurlyBracket )
            {
            // InternalExprParser.g:4415:1: ( LeftCurlyBracket )
            // InternalExprParser.g:4416:1: LeftCurlyBracket
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
    // InternalExprParser.g:4429:1: rule__RecordType__Group__3 : rule__RecordType__Group__3__Impl rule__RecordType__Group__4 ;
    public final void rule__RecordType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4433:1: ( rule__RecordType__Group__3__Impl rule__RecordType__Group__4 )
            // InternalExprParser.g:4434:2: rule__RecordType__Group__3__Impl rule__RecordType__Group__4
            {
            pushFollow(FOLLOW_23);
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
    // InternalExprParser.g:4441:1: rule__RecordType__Group__3__Impl : ( ( rule__RecordType__FieldAssignment_3 )* ) ;
    public final void rule__RecordType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4445:1: ( ( ( rule__RecordType__FieldAssignment_3 )* ) )
            // InternalExprParser.g:4446:1: ( ( rule__RecordType__FieldAssignment_3 )* )
            {
            // InternalExprParser.g:4446:1: ( ( rule__RecordType__FieldAssignment_3 )* )
            // InternalExprParser.g:4447:1: ( rule__RecordType__FieldAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecordTypeAccess().getFieldAssignment_3()); 
            }
            // InternalExprParser.g:4448:1: ( rule__RecordType__FieldAssignment_3 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_ID) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalExprParser.g:4448:2: rule__RecordType__FieldAssignment_3
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__RecordType__FieldAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
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
    // InternalExprParser.g:4458:1: rule__RecordType__Group__4 : rule__RecordType__Group__4__Impl ;
    public final void rule__RecordType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4462:1: ( rule__RecordType__Group__4__Impl )
            // InternalExprParser.g:4463:2: rule__RecordType__Group__4__Impl
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
    // InternalExprParser.g:4469:1: rule__RecordType__Group__4__Impl : ( RightCurlyBracket ) ;
    public final void rule__RecordType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4473:1: ( ( RightCurlyBracket ) )
            // InternalExprParser.g:4474:1: ( RightCurlyBracket )
            {
            // InternalExprParser.g:4474:1: ( RightCurlyBracket )
            // InternalExprParser.g:4475:1: RightCurlyBracket
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
    // InternalExprParser.g:4498:1: rule__Field__Group__0 : rule__Field__Group__0__Impl rule__Field__Group__1 ;
    public final void rule__Field__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4502:1: ( rule__Field__Group__0__Impl rule__Field__Group__1 )
            // InternalExprParser.g:4503:2: rule__Field__Group__0__Impl rule__Field__Group__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalExprParser.g:4510:1: rule__Field__Group__0__Impl : ( ( rule__Field__NameAssignment_0 ) ) ;
    public final void rule__Field__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4514:1: ( ( ( rule__Field__NameAssignment_0 ) ) )
            // InternalExprParser.g:4515:1: ( ( rule__Field__NameAssignment_0 ) )
            {
            // InternalExprParser.g:4515:1: ( ( rule__Field__NameAssignment_0 ) )
            // InternalExprParser.g:4516:1: ( rule__Field__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getNameAssignment_0()); 
            }
            // InternalExprParser.g:4517:1: ( rule__Field__NameAssignment_0 )
            // InternalExprParser.g:4517:2: rule__Field__NameAssignment_0
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
    // InternalExprParser.g:4527:1: rule__Field__Group__1 : rule__Field__Group__1__Impl rule__Field__Group__2 ;
    public final void rule__Field__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4531:1: ( rule__Field__Group__1__Impl rule__Field__Group__2 )
            // InternalExprParser.g:4532:2: rule__Field__Group__1__Impl rule__Field__Group__2
            {
            pushFollow(FOLLOW_7);
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
    // InternalExprParser.g:4539:1: rule__Field__Group__1__Impl : ( Colon ) ;
    public final void rule__Field__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4543:1: ( ( Colon ) )
            // InternalExprParser.g:4544:1: ( Colon )
            {
            // InternalExprParser.g:4544:1: ( Colon )
            // InternalExprParser.g:4545:1: Colon
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
    // InternalExprParser.g:4558:1: rule__Field__Group__2 : rule__Field__Group__2__Impl rule__Field__Group__3 ;
    public final void rule__Field__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4562:1: ( rule__Field__Group__2__Impl rule__Field__Group__3 )
            // InternalExprParser.g:4563:2: rule__Field__Group__2__Impl rule__Field__Group__3
            {
            pushFollow(FOLLOW_8);
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
    // InternalExprParser.g:4570:1: rule__Field__Group__2__Impl : ( ( rule__Field__TypeAssignment_2 ) ) ;
    public final void rule__Field__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4574:1: ( ( ( rule__Field__TypeAssignment_2 ) ) )
            // InternalExprParser.g:4575:1: ( ( rule__Field__TypeAssignment_2 ) )
            {
            // InternalExprParser.g:4575:1: ( ( rule__Field__TypeAssignment_2 ) )
            // InternalExprParser.g:4576:1: ( rule__Field__TypeAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getTypeAssignment_2()); 
            }
            // InternalExprParser.g:4577:1: ( rule__Field__TypeAssignment_2 )
            // InternalExprParser.g:4577:2: rule__Field__TypeAssignment_2
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
    // InternalExprParser.g:4587:1: rule__Field__Group__3 : rule__Field__Group__3__Impl ;
    public final void rule__Field__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4591:1: ( rule__Field__Group__3__Impl )
            // InternalExprParser.g:4592:2: rule__Field__Group__3__Impl
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
    // InternalExprParser.g:4598:1: rule__Field__Group__3__Impl : ( Semicolon ) ;
    public final void rule__Field__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4602:1: ( ( Semicolon ) )
            // InternalExprParser.g:4603:1: ( Semicolon )
            {
            // InternalExprParser.g:4603:1: ( Semicolon )
            // InternalExprParser.g:4604:1: Semicolon
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
    // InternalExprParser.g:4625:1: rule__UnionType__Group__0 : rule__UnionType__Group__0__Impl rule__UnionType__Group__1 ;
    public final void rule__UnionType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4629:1: ( rule__UnionType__Group__0__Impl rule__UnionType__Group__1 )
            // InternalExprParser.g:4630:2: rule__UnionType__Group__0__Impl rule__UnionType__Group__1
            {
            pushFollow(FOLLOW_25);
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
    // InternalExprParser.g:4637:1: rule__UnionType__Group__0__Impl : ( () ) ;
    public final void rule__UnionType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4641:1: ( ( () ) )
            // InternalExprParser.g:4642:1: ( () )
            {
            // InternalExprParser.g:4642:1: ( () )
            // InternalExprParser.g:4643:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnionTypeAccess().getUnionTypeAction_0()); 
            }
            // InternalExprParser.g:4644:1: ()
            // InternalExprParser.g:4646:1: 
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
    // InternalExprParser.g:4656:1: rule__UnionType__Group__1 : rule__UnionType__Group__1__Impl rule__UnionType__Group__2 ;
    public final void rule__UnionType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4660:1: ( rule__UnionType__Group__1__Impl rule__UnionType__Group__2 )
            // InternalExprParser.g:4661:2: rule__UnionType__Group__1__Impl rule__UnionType__Group__2
            {
            pushFollow(FOLLOW_22);
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
    // InternalExprParser.g:4668:1: rule__UnionType__Group__1__Impl : ( Union ) ;
    public final void rule__UnionType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4672:1: ( ( Union ) )
            // InternalExprParser.g:4673:1: ( Union )
            {
            // InternalExprParser.g:4673:1: ( Union )
            // InternalExprParser.g:4674:1: Union
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
    // InternalExprParser.g:4687:1: rule__UnionType__Group__2 : rule__UnionType__Group__2__Impl rule__UnionType__Group__3 ;
    public final void rule__UnionType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4691:1: ( rule__UnionType__Group__2__Impl rule__UnionType__Group__3 )
            // InternalExprParser.g:4692:2: rule__UnionType__Group__2__Impl rule__UnionType__Group__3
            {
            pushFollow(FOLLOW_26);
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
    // InternalExprParser.g:4699:1: rule__UnionType__Group__2__Impl : ( LeftCurlyBracket ) ;
    public final void rule__UnionType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4703:1: ( ( LeftCurlyBracket ) )
            // InternalExprParser.g:4704:1: ( LeftCurlyBracket )
            {
            // InternalExprParser.g:4704:1: ( LeftCurlyBracket )
            // InternalExprParser.g:4705:1: LeftCurlyBracket
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
    // InternalExprParser.g:4718:1: rule__UnionType__Group__3 : rule__UnionType__Group__3__Impl rule__UnionType__Group__4 ;
    public final void rule__UnionType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4722:1: ( rule__UnionType__Group__3__Impl rule__UnionType__Group__4 )
            // InternalExprParser.g:4723:2: rule__UnionType__Group__3__Impl rule__UnionType__Group__4
            {
            pushFollow(FOLLOW_27);
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
    // InternalExprParser.g:4730:1: rule__UnionType__Group__3__Impl : ( QuestionMarkQuestionMarkQuestionMark ) ;
    public final void rule__UnionType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4734:1: ( ( QuestionMarkQuestionMarkQuestionMark ) )
            // InternalExprParser.g:4735:1: ( QuestionMarkQuestionMarkQuestionMark )
            {
            // InternalExprParser.g:4735:1: ( QuestionMarkQuestionMarkQuestionMark )
            // InternalExprParser.g:4736:1: QuestionMarkQuestionMarkQuestionMark
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
    // InternalExprParser.g:4749:1: rule__UnionType__Group__4 : rule__UnionType__Group__4__Impl ;
    public final void rule__UnionType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4753:1: ( rule__UnionType__Group__4__Impl )
            // InternalExprParser.g:4754:2: rule__UnionType__Group__4__Impl
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
    // InternalExprParser.g:4760:1: rule__UnionType__Group__4__Impl : ( RightCurlyBracket ) ;
    public final void rule__UnionType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4764:1: ( ( RightCurlyBracket ) )
            // InternalExprParser.g:4765:1: ( RightCurlyBracket )
            {
            // InternalExprParser.g:4765:1: ( RightCurlyBracket )
            // InternalExprParser.g:4766:1: RightCurlyBracket
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
    // InternalExprParser.g:4789:1: rule__TupleType__Group__0 : rule__TupleType__Group__0__Impl rule__TupleType__Group__1 ;
    public final void rule__TupleType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4793:1: ( rule__TupleType__Group__0__Impl rule__TupleType__Group__1 )
            // InternalExprParser.g:4794:2: rule__TupleType__Group__0__Impl rule__TupleType__Group__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalExprParser.g:4801:1: rule__TupleType__Group__0__Impl : ( () ) ;
    public final void rule__TupleType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4805:1: ( ( () ) )
            // InternalExprParser.g:4806:1: ( () )
            {
            // InternalExprParser.g:4806:1: ( () )
            // InternalExprParser.g:4807:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleTypeAccess().getTupleTypeAction_0()); 
            }
            // InternalExprParser.g:4808:1: ()
            // InternalExprParser.g:4810:1: 
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
    // InternalExprParser.g:4820:1: rule__TupleType__Group__1 : rule__TupleType__Group__1__Impl rule__TupleType__Group__2 ;
    public final void rule__TupleType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4824:1: ( rule__TupleType__Group__1__Impl rule__TupleType__Group__2 )
            // InternalExprParser.g:4825:2: rule__TupleType__Group__1__Impl rule__TupleType__Group__2
            {
            pushFollow(FOLLOW_22);
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
    // InternalExprParser.g:4832:1: rule__TupleType__Group__1__Impl : ( Tuple ) ;
    public final void rule__TupleType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4836:1: ( ( Tuple ) )
            // InternalExprParser.g:4837:1: ( Tuple )
            {
            // InternalExprParser.g:4837:1: ( Tuple )
            // InternalExprParser.g:4838:1: Tuple
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
    // InternalExprParser.g:4851:1: rule__TupleType__Group__2 : rule__TupleType__Group__2__Impl rule__TupleType__Group__3 ;
    public final void rule__TupleType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4855:1: ( rule__TupleType__Group__2__Impl rule__TupleType__Group__3 )
            // InternalExprParser.g:4856:2: rule__TupleType__Group__2__Impl rule__TupleType__Group__3
            {
            pushFollow(FOLLOW_29);
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
    // InternalExprParser.g:4863:1: rule__TupleType__Group__2__Impl : ( LeftCurlyBracket ) ;
    public final void rule__TupleType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4867:1: ( ( LeftCurlyBracket ) )
            // InternalExprParser.g:4868:1: ( LeftCurlyBracket )
            {
            // InternalExprParser.g:4868:1: ( LeftCurlyBracket )
            // InternalExprParser.g:4869:1: LeftCurlyBracket
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
    // InternalExprParser.g:4882:1: rule__TupleType__Group__3 : rule__TupleType__Group__3__Impl rule__TupleType__Group__4 ;
    public final void rule__TupleType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4886:1: ( rule__TupleType__Group__3__Impl rule__TupleType__Group__4 )
            // InternalExprParser.g:4887:2: rule__TupleType__Group__3__Impl rule__TupleType__Group__4
            {
            pushFollow(FOLLOW_29);
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
    // InternalExprParser.g:4894:1: rule__TupleType__Group__3__Impl : ( ( rule__TupleType__FieldAssignment_3 )* ) ;
    public final void rule__TupleType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4898:1: ( ( ( rule__TupleType__FieldAssignment_3 )* ) )
            // InternalExprParser.g:4899:1: ( ( rule__TupleType__FieldAssignment_3 )* )
            {
            // InternalExprParser.g:4899:1: ( ( rule__TupleType__FieldAssignment_3 )* )
            // InternalExprParser.g:4900:1: ( rule__TupleType__FieldAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleTypeAccess().getFieldAssignment_3()); 
            }
            // InternalExprParser.g:4901:1: ( rule__TupleType__FieldAssignment_3 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=Subcomponent && LA27_0<=Processor)||LA27_0==Abstract||LA27_0==Feature||(LA27_0>=Process && LA27_0<=Thread)||(LA27_0>=Tuple && LA27_0<=Data)||(LA27_0>=Flow && LA27_0<=Real)||(LA27_0>=Bag && LA27_0<=Bus)||(LA27_0>=Int && LA27_0<=Map)||LA27_0==Set||LA27_0==RULE_ID) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalExprParser.g:4901:2: rule__TupleType__FieldAssignment_3
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__TupleType__FieldAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop27;
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
    // InternalExprParser.g:4911:1: rule__TupleType__Group__4 : rule__TupleType__Group__4__Impl ;
    public final void rule__TupleType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4915:1: ( rule__TupleType__Group__4__Impl )
            // InternalExprParser.g:4916:2: rule__TupleType__Group__4__Impl
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
    // InternalExprParser.g:4922:1: rule__TupleType__Group__4__Impl : ( RightCurlyBracket ) ;
    public final void rule__TupleType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4926:1: ( ( RightCurlyBracket ) )
            // InternalExprParser.g:4927:1: ( RightCurlyBracket )
            {
            // InternalExprParser.g:4927:1: ( RightCurlyBracket )
            // InternalExprParser.g:4928:1: RightCurlyBracket
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
    // InternalExprParser.g:4951:1: rule__TupleField__Group__0 : rule__TupleField__Group__0__Impl rule__TupleField__Group__1 ;
    public final void rule__TupleField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4955:1: ( rule__TupleField__Group__0__Impl rule__TupleField__Group__1 )
            // InternalExprParser.g:4956:2: rule__TupleField__Group__0__Impl rule__TupleField__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalExprParser.g:4963:1: rule__TupleField__Group__0__Impl : ( () ) ;
    public final void rule__TupleField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4967:1: ( ( () ) )
            // InternalExprParser.g:4968:1: ( () )
            {
            // InternalExprParser.g:4968:1: ( () )
            // InternalExprParser.g:4969:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleFieldAccess().getFieldAction_0()); 
            }
            // InternalExprParser.g:4970:1: ()
            // InternalExprParser.g:4972:1: 
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
    // InternalExprParser.g:4982:1: rule__TupleField__Group__1 : rule__TupleField__Group__1__Impl ;
    public final void rule__TupleField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4986:1: ( rule__TupleField__Group__1__Impl )
            // InternalExprParser.g:4987:2: rule__TupleField__Group__1__Impl
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
    // InternalExprParser.g:4993:1: rule__TupleField__Group__1__Impl : ( ( rule__TupleField__TypeAssignment_1 ) ) ;
    public final void rule__TupleField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4997:1: ( ( ( rule__TupleField__TypeAssignment_1 ) ) )
            // InternalExprParser.g:4998:1: ( ( rule__TupleField__TypeAssignment_1 ) )
            {
            // InternalExprParser.g:4998:1: ( ( rule__TupleField__TypeAssignment_1 ) )
            // InternalExprParser.g:4999:1: ( rule__TupleField__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleFieldAccess().getTypeAssignment_1()); 
            }
            // InternalExprParser.g:5000:1: ( rule__TupleField__TypeAssignment_1 )
            // InternalExprParser.g:5000:2: rule__TupleField__TypeAssignment_1
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
    // InternalExprParser.g:5014:1: rule__ListType__Group__0 : rule__ListType__Group__0__Impl rule__ListType__Group__1 ;
    public final void rule__ListType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5018:1: ( rule__ListType__Group__0__Impl rule__ListType__Group__1 )
            // InternalExprParser.g:5019:2: rule__ListType__Group__0__Impl rule__ListType__Group__1
            {
            pushFollow(FOLLOW_31);
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
    // InternalExprParser.g:5026:1: rule__ListType__Group__0__Impl : ( () ) ;
    public final void rule__ListType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5030:1: ( ( () ) )
            // InternalExprParser.g:5031:1: ( () )
            {
            // InternalExprParser.g:5031:1: ( () )
            // InternalExprParser.g:5032:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListTypeAccess().getListTypeAction_0()); 
            }
            // InternalExprParser.g:5033:1: ()
            // InternalExprParser.g:5035:1: 
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
    // InternalExprParser.g:5045:1: rule__ListType__Group__1 : rule__ListType__Group__1__Impl rule__ListType__Group__2 ;
    public final void rule__ListType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5049:1: ( rule__ListType__Group__1__Impl rule__ListType__Group__2 )
            // InternalExprParser.g:5050:2: rule__ListType__Group__1__Impl rule__ListType__Group__2
            {
            pushFollow(FOLLOW_32);
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
    // InternalExprParser.g:5057:1: rule__ListType__Group__1__Impl : ( List ) ;
    public final void rule__ListType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5061:1: ( ( List ) )
            // InternalExprParser.g:5062:1: ( List )
            {
            // InternalExprParser.g:5062:1: ( List )
            // InternalExprParser.g:5063:1: List
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
    // InternalExprParser.g:5076:1: rule__ListType__Group__2 : rule__ListType__Group__2__Impl rule__ListType__Group__3 ;
    public final void rule__ListType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5080:1: ( rule__ListType__Group__2__Impl rule__ListType__Group__3 )
            // InternalExprParser.g:5081:2: rule__ListType__Group__2__Impl rule__ListType__Group__3
            {
            pushFollow(FOLLOW_7);
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
    // InternalExprParser.g:5088:1: rule__ListType__Group__2__Impl : ( Of ) ;
    public final void rule__ListType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5092:1: ( ( Of ) )
            // InternalExprParser.g:5093:1: ( Of )
            {
            // InternalExprParser.g:5093:1: ( Of )
            // InternalExprParser.g:5094:1: Of
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
    // InternalExprParser.g:5107:1: rule__ListType__Group__3 : rule__ListType__Group__3__Impl ;
    public final void rule__ListType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5111:1: ( rule__ListType__Group__3__Impl )
            // InternalExprParser.g:5112:2: rule__ListType__Group__3__Impl
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
    // InternalExprParser.g:5118:1: rule__ListType__Group__3__Impl : ( ( rule__ListType__TypeAssignment_3 ) ) ;
    public final void rule__ListType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5122:1: ( ( ( rule__ListType__TypeAssignment_3 ) ) )
            // InternalExprParser.g:5123:1: ( ( rule__ListType__TypeAssignment_3 ) )
            {
            // InternalExprParser.g:5123:1: ( ( rule__ListType__TypeAssignment_3 ) )
            // InternalExprParser.g:5124:1: ( rule__ListType__TypeAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListTypeAccess().getTypeAssignment_3()); 
            }
            // InternalExprParser.g:5125:1: ( rule__ListType__TypeAssignment_3 )
            // InternalExprParser.g:5125:2: rule__ListType__TypeAssignment_3
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
    // InternalExprParser.g:5143:1: rule__SetType__Group__0 : rule__SetType__Group__0__Impl rule__SetType__Group__1 ;
    public final void rule__SetType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5147:1: ( rule__SetType__Group__0__Impl rule__SetType__Group__1 )
            // InternalExprParser.g:5148:2: rule__SetType__Group__0__Impl rule__SetType__Group__1
            {
            pushFollow(FOLLOW_32);
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
    // InternalExprParser.g:5155:1: rule__SetType__Group__0__Impl : ( Set ) ;
    public final void rule__SetType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5159:1: ( ( Set ) )
            // InternalExprParser.g:5160:1: ( Set )
            {
            // InternalExprParser.g:5160:1: ( Set )
            // InternalExprParser.g:5161:1: Set
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
    // InternalExprParser.g:5174:1: rule__SetType__Group__1 : rule__SetType__Group__1__Impl rule__SetType__Group__2 ;
    public final void rule__SetType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5178:1: ( rule__SetType__Group__1__Impl rule__SetType__Group__2 )
            // InternalExprParser.g:5179:2: rule__SetType__Group__1__Impl rule__SetType__Group__2
            {
            pushFollow(FOLLOW_7);
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
    // InternalExprParser.g:5186:1: rule__SetType__Group__1__Impl : ( Of ) ;
    public final void rule__SetType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5190:1: ( ( Of ) )
            // InternalExprParser.g:5191:1: ( Of )
            {
            // InternalExprParser.g:5191:1: ( Of )
            // InternalExprParser.g:5192:1: Of
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
    // InternalExprParser.g:5205:1: rule__SetType__Group__2 : rule__SetType__Group__2__Impl ;
    public final void rule__SetType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5209:1: ( rule__SetType__Group__2__Impl )
            // InternalExprParser.g:5210:2: rule__SetType__Group__2__Impl
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
    // InternalExprParser.g:5216:1: rule__SetType__Group__2__Impl : ( ( rule__SetType__TypeAssignment_2 ) ) ;
    public final void rule__SetType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5220:1: ( ( ( rule__SetType__TypeAssignment_2 ) ) )
            // InternalExprParser.g:5221:1: ( ( rule__SetType__TypeAssignment_2 ) )
            {
            // InternalExprParser.g:5221:1: ( ( rule__SetType__TypeAssignment_2 ) )
            // InternalExprParser.g:5222:1: ( rule__SetType__TypeAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSetTypeAccess().getTypeAssignment_2()); 
            }
            // InternalExprParser.g:5223:1: ( rule__SetType__TypeAssignment_2 )
            // InternalExprParser.g:5223:2: rule__SetType__TypeAssignment_2
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
    // InternalExprParser.g:5239:1: rule__BagType__Group__0 : rule__BagType__Group__0__Impl rule__BagType__Group__1 ;
    public final void rule__BagType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5243:1: ( rule__BagType__Group__0__Impl rule__BagType__Group__1 )
            // InternalExprParser.g:5244:2: rule__BagType__Group__0__Impl rule__BagType__Group__1
            {
            pushFollow(FOLLOW_32);
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
    // InternalExprParser.g:5251:1: rule__BagType__Group__0__Impl : ( Bag ) ;
    public final void rule__BagType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5255:1: ( ( Bag ) )
            // InternalExprParser.g:5256:1: ( Bag )
            {
            // InternalExprParser.g:5256:1: ( Bag )
            // InternalExprParser.g:5257:1: Bag
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
    // InternalExprParser.g:5270:1: rule__BagType__Group__1 : rule__BagType__Group__1__Impl rule__BagType__Group__2 ;
    public final void rule__BagType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5274:1: ( rule__BagType__Group__1__Impl rule__BagType__Group__2 )
            // InternalExprParser.g:5275:2: rule__BagType__Group__1__Impl rule__BagType__Group__2
            {
            pushFollow(FOLLOW_7);
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
    // InternalExprParser.g:5282:1: rule__BagType__Group__1__Impl : ( Of ) ;
    public final void rule__BagType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5286:1: ( ( Of ) )
            // InternalExprParser.g:5287:1: ( Of )
            {
            // InternalExprParser.g:5287:1: ( Of )
            // InternalExprParser.g:5288:1: Of
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
    // InternalExprParser.g:5301:1: rule__BagType__Group__2 : rule__BagType__Group__2__Impl ;
    public final void rule__BagType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5305:1: ( rule__BagType__Group__2__Impl )
            // InternalExprParser.g:5306:2: rule__BagType__Group__2__Impl
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
    // InternalExprParser.g:5312:1: rule__BagType__Group__2__Impl : ( ( rule__BagType__TypeAssignment_2 ) ) ;
    public final void rule__BagType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5316:1: ( ( ( rule__BagType__TypeAssignment_2 ) ) )
            // InternalExprParser.g:5317:1: ( ( rule__BagType__TypeAssignment_2 ) )
            {
            // InternalExprParser.g:5317:1: ( ( rule__BagType__TypeAssignment_2 ) )
            // InternalExprParser.g:5318:1: ( rule__BagType__TypeAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBagTypeAccess().getTypeAssignment_2()); 
            }
            // InternalExprParser.g:5319:1: ( rule__BagType__TypeAssignment_2 )
            // InternalExprParser.g:5319:2: rule__BagType__TypeAssignment_2
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
    // InternalExprParser.g:5335:1: rule__MapType__Group__0 : rule__MapType__Group__0__Impl rule__MapType__Group__1 ;
    public final void rule__MapType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5339:1: ( rule__MapType__Group__0__Impl rule__MapType__Group__1 )
            // InternalExprParser.g:5340:2: rule__MapType__Group__0__Impl rule__MapType__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalExprParser.g:5347:1: rule__MapType__Group__0__Impl : ( Map ) ;
    public final void rule__MapType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5351:1: ( ( Map ) )
            // InternalExprParser.g:5352:1: ( Map )
            {
            // InternalExprParser.g:5352:1: ( Map )
            // InternalExprParser.g:5353:1: Map
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
    // InternalExprParser.g:5366:1: rule__MapType__Group__1 : rule__MapType__Group__1__Impl rule__MapType__Group__2 ;
    public final void rule__MapType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5370:1: ( rule__MapType__Group__1__Impl rule__MapType__Group__2 )
            // InternalExprParser.g:5371:2: rule__MapType__Group__1__Impl rule__MapType__Group__2
            {
            pushFollow(FOLLOW_33);
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
    // InternalExprParser.g:5378:1: rule__MapType__Group__1__Impl : ( ( rule__MapType__DomAssignment_1 ) ) ;
    public final void rule__MapType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5382:1: ( ( ( rule__MapType__DomAssignment_1 ) ) )
            // InternalExprParser.g:5383:1: ( ( rule__MapType__DomAssignment_1 ) )
            {
            // InternalExprParser.g:5383:1: ( ( rule__MapType__DomAssignment_1 ) )
            // InternalExprParser.g:5384:1: ( rule__MapType__DomAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMapTypeAccess().getDomAssignment_1()); 
            }
            // InternalExprParser.g:5385:1: ( rule__MapType__DomAssignment_1 )
            // InternalExprParser.g:5385:2: rule__MapType__DomAssignment_1
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
    // InternalExprParser.g:5395:1: rule__MapType__Group__2 : rule__MapType__Group__2__Impl rule__MapType__Group__3 ;
    public final void rule__MapType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5399:1: ( rule__MapType__Group__2__Impl rule__MapType__Group__3 )
            // InternalExprParser.g:5400:2: rule__MapType__Group__2__Impl rule__MapType__Group__3
            {
            pushFollow(FOLLOW_7);
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
    // InternalExprParser.g:5407:1: rule__MapType__Group__2__Impl : ( HyphenMinusGreaterThanSign ) ;
    public final void rule__MapType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5411:1: ( ( HyphenMinusGreaterThanSign ) )
            // InternalExprParser.g:5412:1: ( HyphenMinusGreaterThanSign )
            {
            // InternalExprParser.g:5412:1: ( HyphenMinusGreaterThanSign )
            // InternalExprParser.g:5413:1: HyphenMinusGreaterThanSign
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
    // InternalExprParser.g:5426:1: rule__MapType__Group__3 : rule__MapType__Group__3__Impl ;
    public final void rule__MapType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5430:1: ( rule__MapType__Group__3__Impl )
            // InternalExprParser.g:5431:2: rule__MapType__Group__3__Impl
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
    // InternalExprParser.g:5437:1: rule__MapType__Group__3__Impl : ( ( rule__MapType__ImgAssignment_3 ) ) ;
    public final void rule__MapType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5441:1: ( ( ( rule__MapType__ImgAssignment_3 ) ) )
            // InternalExprParser.g:5442:1: ( ( rule__MapType__ImgAssignment_3 ) )
            {
            // InternalExprParser.g:5442:1: ( ( rule__MapType__ImgAssignment_3 ) )
            // InternalExprParser.g:5443:1: ( rule__MapType__ImgAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMapTypeAccess().getImgAssignment_3()); 
            }
            // InternalExprParser.g:5444:1: ( rule__MapType__ImgAssignment_3 )
            // InternalExprParser.g:5444:2: rule__MapType__ImgAssignment_3
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
    // InternalExprParser.g:5462:1: rule__OrExpression__Group__0 : rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1 ;
    public final void rule__OrExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5466:1: ( rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1 )
            // InternalExprParser.g:5467:2: rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1
            {
            pushFollow(FOLLOW_34);
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
    // InternalExprParser.g:5474:1: rule__OrExpression__Group__0__Impl : ( ruleAndExpression ) ;
    public final void rule__OrExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5478:1: ( ( ruleAndExpression ) )
            // InternalExprParser.g:5479:1: ( ruleAndExpression )
            {
            // InternalExprParser.g:5479:1: ( ruleAndExpression )
            // InternalExprParser.g:5480:1: ruleAndExpression
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
    // InternalExprParser.g:5491:1: rule__OrExpression__Group__1 : rule__OrExpression__Group__1__Impl ;
    public final void rule__OrExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5495:1: ( rule__OrExpression__Group__1__Impl )
            // InternalExprParser.g:5496:2: rule__OrExpression__Group__1__Impl
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
    // InternalExprParser.g:5502:1: rule__OrExpression__Group__1__Impl : ( ( rule__OrExpression__Group_1__0 )* ) ;
    public final void rule__OrExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5506:1: ( ( ( rule__OrExpression__Group_1__0 )* ) )
            // InternalExprParser.g:5507:1: ( ( rule__OrExpression__Group_1__0 )* )
            {
            // InternalExprParser.g:5507:1: ( ( rule__OrExpression__Group_1__0 )* )
            // InternalExprParser.g:5508:1: ( rule__OrExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionAccess().getGroup_1()); 
            }
            // InternalExprParser.g:5509:1: ( rule__OrExpression__Group_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=Or && LA28_0<=VerticalLineVerticalLine)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalExprParser.g:5509:2: rule__OrExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_35);
            	    rule__OrExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
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
    // InternalExprParser.g:5523:1: rule__OrExpression__Group_1__0 : rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1 ;
    public final void rule__OrExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5527:1: ( rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1 )
            // InternalExprParser.g:5528:2: rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalExprParser.g:5535:1: rule__OrExpression__Group_1__0__Impl : ( ( rule__OrExpression__Group_1_0__0 ) ) ;
    public final void rule__OrExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5539:1: ( ( ( rule__OrExpression__Group_1_0__0 ) ) )
            // InternalExprParser.g:5540:1: ( ( rule__OrExpression__Group_1_0__0 ) )
            {
            // InternalExprParser.g:5540:1: ( ( rule__OrExpression__Group_1_0__0 ) )
            // InternalExprParser.g:5541:1: ( rule__OrExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionAccess().getGroup_1_0()); 
            }
            // InternalExprParser.g:5542:1: ( rule__OrExpression__Group_1_0__0 )
            // InternalExprParser.g:5542:2: rule__OrExpression__Group_1_0__0
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
    // InternalExprParser.g:5552:1: rule__OrExpression__Group_1__1 : rule__OrExpression__Group_1__1__Impl ;
    public final void rule__OrExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5556:1: ( rule__OrExpression__Group_1__1__Impl )
            // InternalExprParser.g:5557:2: rule__OrExpression__Group_1__1__Impl
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
    // InternalExprParser.g:5563:1: rule__OrExpression__Group_1__1__Impl : ( ( rule__OrExpression__RightAssignment_1_1 ) ) ;
    public final void rule__OrExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5567:1: ( ( ( rule__OrExpression__RightAssignment_1_1 ) ) )
            // InternalExprParser.g:5568:1: ( ( rule__OrExpression__RightAssignment_1_1 ) )
            {
            // InternalExprParser.g:5568:1: ( ( rule__OrExpression__RightAssignment_1_1 ) )
            // InternalExprParser.g:5569:1: ( rule__OrExpression__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionAccess().getRightAssignment_1_1()); 
            }
            // InternalExprParser.g:5570:1: ( rule__OrExpression__RightAssignment_1_1 )
            // InternalExprParser.g:5570:2: rule__OrExpression__RightAssignment_1_1
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
    // InternalExprParser.g:5584:1: rule__OrExpression__Group_1_0__0 : rule__OrExpression__Group_1_0__0__Impl ;
    public final void rule__OrExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5588:1: ( rule__OrExpression__Group_1_0__0__Impl )
            // InternalExprParser.g:5589:2: rule__OrExpression__Group_1_0__0__Impl
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
    // InternalExprParser.g:5595:1: rule__OrExpression__Group_1_0__0__Impl : ( ( rule__OrExpression__Group_1_0_0__0 ) ) ;
    public final void rule__OrExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5599:1: ( ( ( rule__OrExpression__Group_1_0_0__0 ) ) )
            // InternalExprParser.g:5600:1: ( ( rule__OrExpression__Group_1_0_0__0 ) )
            {
            // InternalExprParser.g:5600:1: ( ( rule__OrExpression__Group_1_0_0__0 ) )
            // InternalExprParser.g:5601:1: ( rule__OrExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalExprParser.g:5602:1: ( rule__OrExpression__Group_1_0_0__0 )
            // InternalExprParser.g:5602:2: rule__OrExpression__Group_1_0_0__0
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
    // InternalExprParser.g:5614:1: rule__OrExpression__Group_1_0_0__0 : rule__OrExpression__Group_1_0_0__0__Impl rule__OrExpression__Group_1_0_0__1 ;
    public final void rule__OrExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5618:1: ( rule__OrExpression__Group_1_0_0__0__Impl rule__OrExpression__Group_1_0_0__1 )
            // InternalExprParser.g:5619:2: rule__OrExpression__Group_1_0_0__0__Impl rule__OrExpression__Group_1_0_0__1
            {
            pushFollow(FOLLOW_34);
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
    // InternalExprParser.g:5626:1: rule__OrExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__OrExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5630:1: ( ( () ) )
            // InternalExprParser.g:5631:1: ( () )
            {
            // InternalExprParser.g:5631:1: ( () )
            // InternalExprParser.g:5632:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionAccess().getBinaryOperationLeftAction_1_0_0_0()); 
            }
            // InternalExprParser.g:5633:1: ()
            // InternalExprParser.g:5635:1: 
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
    // InternalExprParser.g:5645:1: rule__OrExpression__Group_1_0_0__1 : rule__OrExpression__Group_1_0_0__1__Impl ;
    public final void rule__OrExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5649:1: ( rule__OrExpression__Group_1_0_0__1__Impl )
            // InternalExprParser.g:5650:2: rule__OrExpression__Group_1_0_0__1__Impl
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
    // InternalExprParser.g:5656:1: rule__OrExpression__Group_1_0_0__1__Impl : ( ( rule__OrExpression__OperatorAssignment_1_0_0_1 ) ) ;
    public final void rule__OrExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5660:1: ( ( ( rule__OrExpression__OperatorAssignment_1_0_0_1 ) ) )
            // InternalExprParser.g:5661:1: ( ( rule__OrExpression__OperatorAssignment_1_0_0_1 ) )
            {
            // InternalExprParser.g:5661:1: ( ( rule__OrExpression__OperatorAssignment_1_0_0_1 ) )
            // InternalExprParser.g:5662:1: ( rule__OrExpression__OperatorAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrExpressionAccess().getOperatorAssignment_1_0_0_1()); 
            }
            // InternalExprParser.g:5663:1: ( rule__OrExpression__OperatorAssignment_1_0_0_1 )
            // InternalExprParser.g:5663:2: rule__OrExpression__OperatorAssignment_1_0_0_1
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
    // InternalExprParser.g:5677:1: rule__AndExpression__Group__0 : rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1 ;
    public final void rule__AndExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5681:1: ( rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1 )
            // InternalExprParser.g:5682:2: rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1
            {
            pushFollow(FOLLOW_36);
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
    // InternalExprParser.g:5689:1: rule__AndExpression__Group__0__Impl : ( ruleEqualityExpression ) ;
    public final void rule__AndExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5693:1: ( ( ruleEqualityExpression ) )
            // InternalExprParser.g:5694:1: ( ruleEqualityExpression )
            {
            // InternalExprParser.g:5694:1: ( ruleEqualityExpression )
            // InternalExprParser.g:5695:1: ruleEqualityExpression
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
    // InternalExprParser.g:5706:1: rule__AndExpression__Group__1 : rule__AndExpression__Group__1__Impl ;
    public final void rule__AndExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5710:1: ( rule__AndExpression__Group__1__Impl )
            // InternalExprParser.g:5711:2: rule__AndExpression__Group__1__Impl
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
    // InternalExprParser.g:5717:1: rule__AndExpression__Group__1__Impl : ( ( rule__AndExpression__Group_1__0 )* ) ;
    public final void rule__AndExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5721:1: ( ( ( rule__AndExpression__Group_1__0 )* ) )
            // InternalExprParser.g:5722:1: ( ( rule__AndExpression__Group_1__0 )* )
            {
            // InternalExprParser.g:5722:1: ( ( rule__AndExpression__Group_1__0 )* )
            // InternalExprParser.g:5723:1: ( rule__AndExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionAccess().getGroup_1()); 
            }
            // InternalExprParser.g:5724:1: ( rule__AndExpression__Group_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==And||LA29_0==AmpersandAmpersand) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalExprParser.g:5724:2: rule__AndExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_37);
            	    rule__AndExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop29;
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
    // InternalExprParser.g:5738:1: rule__AndExpression__Group_1__0 : rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1 ;
    public final void rule__AndExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5742:1: ( rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1 )
            // InternalExprParser.g:5743:2: rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalExprParser.g:5750:1: rule__AndExpression__Group_1__0__Impl : ( ( rule__AndExpression__Group_1_0__0 ) ) ;
    public final void rule__AndExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5754:1: ( ( ( rule__AndExpression__Group_1_0__0 ) ) )
            // InternalExprParser.g:5755:1: ( ( rule__AndExpression__Group_1_0__0 ) )
            {
            // InternalExprParser.g:5755:1: ( ( rule__AndExpression__Group_1_0__0 ) )
            // InternalExprParser.g:5756:1: ( rule__AndExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionAccess().getGroup_1_0()); 
            }
            // InternalExprParser.g:5757:1: ( rule__AndExpression__Group_1_0__0 )
            // InternalExprParser.g:5757:2: rule__AndExpression__Group_1_0__0
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
    // InternalExprParser.g:5767:1: rule__AndExpression__Group_1__1 : rule__AndExpression__Group_1__1__Impl ;
    public final void rule__AndExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5771:1: ( rule__AndExpression__Group_1__1__Impl )
            // InternalExprParser.g:5772:2: rule__AndExpression__Group_1__1__Impl
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
    // InternalExprParser.g:5778:1: rule__AndExpression__Group_1__1__Impl : ( ( rule__AndExpression__RightAssignment_1_1 ) ) ;
    public final void rule__AndExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5782:1: ( ( ( rule__AndExpression__RightAssignment_1_1 ) ) )
            // InternalExprParser.g:5783:1: ( ( rule__AndExpression__RightAssignment_1_1 ) )
            {
            // InternalExprParser.g:5783:1: ( ( rule__AndExpression__RightAssignment_1_1 ) )
            // InternalExprParser.g:5784:1: ( rule__AndExpression__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionAccess().getRightAssignment_1_1()); 
            }
            // InternalExprParser.g:5785:1: ( rule__AndExpression__RightAssignment_1_1 )
            // InternalExprParser.g:5785:2: rule__AndExpression__RightAssignment_1_1
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
    // InternalExprParser.g:5799:1: rule__AndExpression__Group_1_0__0 : rule__AndExpression__Group_1_0__0__Impl ;
    public final void rule__AndExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5803:1: ( rule__AndExpression__Group_1_0__0__Impl )
            // InternalExprParser.g:5804:2: rule__AndExpression__Group_1_0__0__Impl
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
    // InternalExprParser.g:5810:1: rule__AndExpression__Group_1_0__0__Impl : ( ( rule__AndExpression__Group_1_0_0__0 ) ) ;
    public final void rule__AndExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5814:1: ( ( ( rule__AndExpression__Group_1_0_0__0 ) ) )
            // InternalExprParser.g:5815:1: ( ( rule__AndExpression__Group_1_0_0__0 ) )
            {
            // InternalExprParser.g:5815:1: ( ( rule__AndExpression__Group_1_0_0__0 ) )
            // InternalExprParser.g:5816:1: ( rule__AndExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalExprParser.g:5817:1: ( rule__AndExpression__Group_1_0_0__0 )
            // InternalExprParser.g:5817:2: rule__AndExpression__Group_1_0_0__0
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
    // InternalExprParser.g:5829:1: rule__AndExpression__Group_1_0_0__0 : rule__AndExpression__Group_1_0_0__0__Impl rule__AndExpression__Group_1_0_0__1 ;
    public final void rule__AndExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5833:1: ( rule__AndExpression__Group_1_0_0__0__Impl rule__AndExpression__Group_1_0_0__1 )
            // InternalExprParser.g:5834:2: rule__AndExpression__Group_1_0_0__0__Impl rule__AndExpression__Group_1_0_0__1
            {
            pushFollow(FOLLOW_36);
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
    // InternalExprParser.g:5841:1: rule__AndExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__AndExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5845:1: ( ( () ) )
            // InternalExprParser.g:5846:1: ( () )
            {
            // InternalExprParser.g:5846:1: ( () )
            // InternalExprParser.g:5847:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionAccess().getBinaryOperationLeftAction_1_0_0_0()); 
            }
            // InternalExprParser.g:5848:1: ()
            // InternalExprParser.g:5850:1: 
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
    // InternalExprParser.g:5860:1: rule__AndExpression__Group_1_0_0__1 : rule__AndExpression__Group_1_0_0__1__Impl ;
    public final void rule__AndExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5864:1: ( rule__AndExpression__Group_1_0_0__1__Impl )
            // InternalExprParser.g:5865:2: rule__AndExpression__Group_1_0_0__1__Impl
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
    // InternalExprParser.g:5871:1: rule__AndExpression__Group_1_0_0__1__Impl : ( ( rule__AndExpression__OperatorAssignment_1_0_0_1 ) ) ;
    public final void rule__AndExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5875:1: ( ( ( rule__AndExpression__OperatorAssignment_1_0_0_1 ) ) )
            // InternalExprParser.g:5876:1: ( ( rule__AndExpression__OperatorAssignment_1_0_0_1 ) )
            {
            // InternalExprParser.g:5876:1: ( ( rule__AndExpression__OperatorAssignment_1_0_0_1 ) )
            // InternalExprParser.g:5877:1: ( rule__AndExpression__OperatorAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndExpressionAccess().getOperatorAssignment_1_0_0_1()); 
            }
            // InternalExprParser.g:5878:1: ( rule__AndExpression__OperatorAssignment_1_0_0_1 )
            // InternalExprParser.g:5878:2: rule__AndExpression__OperatorAssignment_1_0_0_1
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
    // InternalExprParser.g:5892:1: rule__EqualityExpression__Group__0 : rule__EqualityExpression__Group__0__Impl rule__EqualityExpression__Group__1 ;
    public final void rule__EqualityExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5896:1: ( rule__EqualityExpression__Group__0__Impl rule__EqualityExpression__Group__1 )
            // InternalExprParser.g:5897:2: rule__EqualityExpression__Group__0__Impl rule__EqualityExpression__Group__1
            {
            pushFollow(FOLLOW_38);
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
    // InternalExprParser.g:5904:1: rule__EqualityExpression__Group__0__Impl : ( ruleRelationalExpression ) ;
    public final void rule__EqualityExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5908:1: ( ( ruleRelationalExpression ) )
            // InternalExprParser.g:5909:1: ( ruleRelationalExpression )
            {
            // InternalExprParser.g:5909:1: ( ruleRelationalExpression )
            // InternalExprParser.g:5910:1: ruleRelationalExpression
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
    // InternalExprParser.g:5921:1: rule__EqualityExpression__Group__1 : rule__EqualityExpression__Group__1__Impl ;
    public final void rule__EqualityExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5925:1: ( rule__EqualityExpression__Group__1__Impl )
            // InternalExprParser.g:5926:2: rule__EqualityExpression__Group__1__Impl
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
    // InternalExprParser.g:5932:1: rule__EqualityExpression__Group__1__Impl : ( ( rule__EqualityExpression__Group_1__0 )* ) ;
    public final void rule__EqualityExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5936:1: ( ( ( rule__EqualityExpression__Group_1__0 )* ) )
            // InternalExprParser.g:5937:1: ( ( rule__EqualityExpression__Group_1__0 )* )
            {
            // InternalExprParser.g:5937:1: ( ( rule__EqualityExpression__Group_1__0 )* )
            // InternalExprParser.g:5938:1: ( rule__EqualityExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpressionAccess().getGroup_1()); 
            }
            // InternalExprParser.g:5939:1: ( rule__EqualityExpression__Group_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==ExclamationMarkEqualsSign||LA30_0==EqualsSignEqualsSign) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalExprParser.g:5939:2: rule__EqualityExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_39);
            	    rule__EqualityExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop30;
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
    // InternalExprParser.g:5953:1: rule__EqualityExpression__Group_1__0 : rule__EqualityExpression__Group_1__0__Impl rule__EqualityExpression__Group_1__1 ;
    public final void rule__EqualityExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5957:1: ( rule__EqualityExpression__Group_1__0__Impl rule__EqualityExpression__Group_1__1 )
            // InternalExprParser.g:5958:2: rule__EqualityExpression__Group_1__0__Impl rule__EqualityExpression__Group_1__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalExprParser.g:5965:1: rule__EqualityExpression__Group_1__0__Impl : ( ( rule__EqualityExpression__Group_1_0__0 ) ) ;
    public final void rule__EqualityExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5969:1: ( ( ( rule__EqualityExpression__Group_1_0__0 ) ) )
            // InternalExprParser.g:5970:1: ( ( rule__EqualityExpression__Group_1_0__0 ) )
            {
            // InternalExprParser.g:5970:1: ( ( rule__EqualityExpression__Group_1_0__0 ) )
            // InternalExprParser.g:5971:1: ( rule__EqualityExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpressionAccess().getGroup_1_0()); 
            }
            // InternalExprParser.g:5972:1: ( rule__EqualityExpression__Group_1_0__0 )
            // InternalExprParser.g:5972:2: rule__EqualityExpression__Group_1_0__0
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
    // InternalExprParser.g:5982:1: rule__EqualityExpression__Group_1__1 : rule__EqualityExpression__Group_1__1__Impl ;
    public final void rule__EqualityExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5986:1: ( rule__EqualityExpression__Group_1__1__Impl )
            // InternalExprParser.g:5987:2: rule__EqualityExpression__Group_1__1__Impl
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
    // InternalExprParser.g:5993:1: rule__EqualityExpression__Group_1__1__Impl : ( ( rule__EqualityExpression__RightAssignment_1_1 ) ) ;
    public final void rule__EqualityExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:5997:1: ( ( ( rule__EqualityExpression__RightAssignment_1_1 ) ) )
            // InternalExprParser.g:5998:1: ( ( rule__EqualityExpression__RightAssignment_1_1 ) )
            {
            // InternalExprParser.g:5998:1: ( ( rule__EqualityExpression__RightAssignment_1_1 ) )
            // InternalExprParser.g:5999:1: ( rule__EqualityExpression__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpressionAccess().getRightAssignment_1_1()); 
            }
            // InternalExprParser.g:6000:1: ( rule__EqualityExpression__RightAssignment_1_1 )
            // InternalExprParser.g:6000:2: rule__EqualityExpression__RightAssignment_1_1
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
    // InternalExprParser.g:6014:1: rule__EqualityExpression__Group_1_0__0 : rule__EqualityExpression__Group_1_0__0__Impl ;
    public final void rule__EqualityExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6018:1: ( rule__EqualityExpression__Group_1_0__0__Impl )
            // InternalExprParser.g:6019:2: rule__EqualityExpression__Group_1_0__0__Impl
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
    // InternalExprParser.g:6025:1: rule__EqualityExpression__Group_1_0__0__Impl : ( ( rule__EqualityExpression__Group_1_0_0__0 ) ) ;
    public final void rule__EqualityExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6029:1: ( ( ( rule__EqualityExpression__Group_1_0_0__0 ) ) )
            // InternalExprParser.g:6030:1: ( ( rule__EqualityExpression__Group_1_0_0__0 ) )
            {
            // InternalExprParser.g:6030:1: ( ( rule__EqualityExpression__Group_1_0_0__0 ) )
            // InternalExprParser.g:6031:1: ( rule__EqualityExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalExprParser.g:6032:1: ( rule__EqualityExpression__Group_1_0_0__0 )
            // InternalExprParser.g:6032:2: rule__EqualityExpression__Group_1_0_0__0
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
    // InternalExprParser.g:6044:1: rule__EqualityExpression__Group_1_0_0__0 : rule__EqualityExpression__Group_1_0_0__0__Impl rule__EqualityExpression__Group_1_0_0__1 ;
    public final void rule__EqualityExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6048:1: ( rule__EqualityExpression__Group_1_0_0__0__Impl rule__EqualityExpression__Group_1_0_0__1 )
            // InternalExprParser.g:6049:2: rule__EqualityExpression__Group_1_0_0__0__Impl rule__EqualityExpression__Group_1_0_0__1
            {
            pushFollow(FOLLOW_38);
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
    // InternalExprParser.g:6056:1: rule__EqualityExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__EqualityExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6060:1: ( ( () ) )
            // InternalExprParser.g:6061:1: ( () )
            {
            // InternalExprParser.g:6061:1: ( () )
            // InternalExprParser.g:6062:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpressionAccess().getBinaryOperationLeftAction_1_0_0_0()); 
            }
            // InternalExprParser.g:6063:1: ()
            // InternalExprParser.g:6065:1: 
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
    // InternalExprParser.g:6075:1: rule__EqualityExpression__Group_1_0_0__1 : rule__EqualityExpression__Group_1_0_0__1__Impl ;
    public final void rule__EqualityExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6079:1: ( rule__EqualityExpression__Group_1_0_0__1__Impl )
            // InternalExprParser.g:6080:2: rule__EqualityExpression__Group_1_0_0__1__Impl
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
    // InternalExprParser.g:6086:1: rule__EqualityExpression__Group_1_0_0__1__Impl : ( ( rule__EqualityExpression__OperatorAssignment_1_0_0_1 ) ) ;
    public final void rule__EqualityExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6090:1: ( ( ( rule__EqualityExpression__OperatorAssignment_1_0_0_1 ) ) )
            // InternalExprParser.g:6091:1: ( ( rule__EqualityExpression__OperatorAssignment_1_0_0_1 ) )
            {
            // InternalExprParser.g:6091:1: ( ( rule__EqualityExpression__OperatorAssignment_1_0_0_1 ) )
            // InternalExprParser.g:6092:1: ( rule__EqualityExpression__OperatorAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpressionAccess().getOperatorAssignment_1_0_0_1()); 
            }
            // InternalExprParser.g:6093:1: ( rule__EqualityExpression__OperatorAssignment_1_0_0_1 )
            // InternalExprParser.g:6093:2: rule__EqualityExpression__OperatorAssignment_1_0_0_1
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
    // InternalExprParser.g:6107:1: rule__RelationalExpression__Group__0 : rule__RelationalExpression__Group__0__Impl rule__RelationalExpression__Group__1 ;
    public final void rule__RelationalExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6111:1: ( rule__RelationalExpression__Group__0__Impl rule__RelationalExpression__Group__1 )
            // InternalExprParser.g:6112:2: rule__RelationalExpression__Group__0__Impl rule__RelationalExpression__Group__1
            {
            pushFollow(FOLLOW_40);
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
    // InternalExprParser.g:6119:1: rule__RelationalExpression__Group__0__Impl : ( ruleAdditiveExpression ) ;
    public final void rule__RelationalExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6123:1: ( ( ruleAdditiveExpression ) )
            // InternalExprParser.g:6124:1: ( ruleAdditiveExpression )
            {
            // InternalExprParser.g:6124:1: ( ruleAdditiveExpression )
            // InternalExprParser.g:6125:1: ruleAdditiveExpression
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
    // InternalExprParser.g:6136:1: rule__RelationalExpression__Group__1 : rule__RelationalExpression__Group__1__Impl ;
    public final void rule__RelationalExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6140:1: ( rule__RelationalExpression__Group__1__Impl )
            // InternalExprParser.g:6141:2: rule__RelationalExpression__Group__1__Impl
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
    // InternalExprParser.g:6147:1: rule__RelationalExpression__Group__1__Impl : ( ( rule__RelationalExpression__Group_1__0 )* ) ;
    public final void rule__RelationalExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6151:1: ( ( ( rule__RelationalExpression__Group_1__0 )* ) )
            // InternalExprParser.g:6152:1: ( ( rule__RelationalExpression__Group_1__0 )* )
            {
            // InternalExprParser.g:6152:1: ( ( rule__RelationalExpression__Group_1__0 )* )
            // InternalExprParser.g:6153:1: ( rule__RelationalExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRelationalExpressionAccess().getGroup_1()); 
            }
            // InternalExprParser.g:6154:1: ( rule__RelationalExpression__Group_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==LessThanSignEqualsSign||(LA31_0>=GreaterThanSignLessThanSign && LA31_0<=GreaterThanSignEqualsSign)||LA31_0==LessThanSign||LA31_0==GreaterThanSign) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalExprParser.g:6154:2: rule__RelationalExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_41);
            	    rule__RelationalExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
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
    // InternalExprParser.g:6168:1: rule__RelationalExpression__Group_1__0 : rule__RelationalExpression__Group_1__0__Impl rule__RelationalExpression__Group_1__1 ;
    public final void rule__RelationalExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6172:1: ( rule__RelationalExpression__Group_1__0__Impl rule__RelationalExpression__Group_1__1 )
            // InternalExprParser.g:6173:2: rule__RelationalExpression__Group_1__0__Impl rule__RelationalExpression__Group_1__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalExprParser.g:6180:1: rule__RelationalExpression__Group_1__0__Impl : ( ( rule__RelationalExpression__Group_1_0__0 ) ) ;
    public final void rule__RelationalExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6184:1: ( ( ( rule__RelationalExpression__Group_1_0__0 ) ) )
            // InternalExprParser.g:6185:1: ( ( rule__RelationalExpression__Group_1_0__0 ) )
            {
            // InternalExprParser.g:6185:1: ( ( rule__RelationalExpression__Group_1_0__0 ) )
            // InternalExprParser.g:6186:1: ( rule__RelationalExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRelationalExpressionAccess().getGroup_1_0()); 
            }
            // InternalExprParser.g:6187:1: ( rule__RelationalExpression__Group_1_0__0 )
            // InternalExprParser.g:6187:2: rule__RelationalExpression__Group_1_0__0
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
    // InternalExprParser.g:6197:1: rule__RelationalExpression__Group_1__1 : rule__RelationalExpression__Group_1__1__Impl ;
    public final void rule__RelationalExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6201:1: ( rule__RelationalExpression__Group_1__1__Impl )
            // InternalExprParser.g:6202:2: rule__RelationalExpression__Group_1__1__Impl
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
    // InternalExprParser.g:6208:1: rule__RelationalExpression__Group_1__1__Impl : ( ( rule__RelationalExpression__RightAssignment_1_1 ) ) ;
    public final void rule__RelationalExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6212:1: ( ( ( rule__RelationalExpression__RightAssignment_1_1 ) ) )
            // InternalExprParser.g:6213:1: ( ( rule__RelationalExpression__RightAssignment_1_1 ) )
            {
            // InternalExprParser.g:6213:1: ( ( rule__RelationalExpression__RightAssignment_1_1 ) )
            // InternalExprParser.g:6214:1: ( rule__RelationalExpression__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRelationalExpressionAccess().getRightAssignment_1_1()); 
            }
            // InternalExprParser.g:6215:1: ( rule__RelationalExpression__RightAssignment_1_1 )
            // InternalExprParser.g:6215:2: rule__RelationalExpression__RightAssignment_1_1
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
    // InternalExprParser.g:6229:1: rule__RelationalExpression__Group_1_0__0 : rule__RelationalExpression__Group_1_0__0__Impl ;
    public final void rule__RelationalExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6233:1: ( rule__RelationalExpression__Group_1_0__0__Impl )
            // InternalExprParser.g:6234:2: rule__RelationalExpression__Group_1_0__0__Impl
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
    // InternalExprParser.g:6240:1: rule__RelationalExpression__Group_1_0__0__Impl : ( ( rule__RelationalExpression__Group_1_0_0__0 ) ) ;
    public final void rule__RelationalExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6244:1: ( ( ( rule__RelationalExpression__Group_1_0_0__0 ) ) )
            // InternalExprParser.g:6245:1: ( ( rule__RelationalExpression__Group_1_0_0__0 ) )
            {
            // InternalExprParser.g:6245:1: ( ( rule__RelationalExpression__Group_1_0_0__0 ) )
            // InternalExprParser.g:6246:1: ( rule__RelationalExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRelationalExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalExprParser.g:6247:1: ( rule__RelationalExpression__Group_1_0_0__0 )
            // InternalExprParser.g:6247:2: rule__RelationalExpression__Group_1_0_0__0
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
    // InternalExprParser.g:6259:1: rule__RelationalExpression__Group_1_0_0__0 : rule__RelationalExpression__Group_1_0_0__0__Impl rule__RelationalExpression__Group_1_0_0__1 ;
    public final void rule__RelationalExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6263:1: ( rule__RelationalExpression__Group_1_0_0__0__Impl rule__RelationalExpression__Group_1_0_0__1 )
            // InternalExprParser.g:6264:2: rule__RelationalExpression__Group_1_0_0__0__Impl rule__RelationalExpression__Group_1_0_0__1
            {
            pushFollow(FOLLOW_40);
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
    // InternalExprParser.g:6271:1: rule__RelationalExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__RelationalExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6275:1: ( ( () ) )
            // InternalExprParser.g:6276:1: ( () )
            {
            // InternalExprParser.g:6276:1: ( () )
            // InternalExprParser.g:6277:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRelationalExpressionAccess().getBinaryOperationLeftAction_1_0_0_0()); 
            }
            // InternalExprParser.g:6278:1: ()
            // InternalExprParser.g:6280:1: 
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
    // InternalExprParser.g:6290:1: rule__RelationalExpression__Group_1_0_0__1 : rule__RelationalExpression__Group_1_0_0__1__Impl ;
    public final void rule__RelationalExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6294:1: ( rule__RelationalExpression__Group_1_0_0__1__Impl )
            // InternalExprParser.g:6295:2: rule__RelationalExpression__Group_1_0_0__1__Impl
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
    // InternalExprParser.g:6301:1: rule__RelationalExpression__Group_1_0_0__1__Impl : ( ( rule__RelationalExpression__OperatorAssignment_1_0_0_1 ) ) ;
    public final void rule__RelationalExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6305:1: ( ( ( rule__RelationalExpression__OperatorAssignment_1_0_0_1 ) ) )
            // InternalExprParser.g:6306:1: ( ( rule__RelationalExpression__OperatorAssignment_1_0_0_1 ) )
            {
            // InternalExprParser.g:6306:1: ( ( rule__RelationalExpression__OperatorAssignment_1_0_0_1 ) )
            // InternalExprParser.g:6307:1: ( rule__RelationalExpression__OperatorAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRelationalExpressionAccess().getOperatorAssignment_1_0_0_1()); 
            }
            // InternalExprParser.g:6308:1: ( rule__RelationalExpression__OperatorAssignment_1_0_0_1 )
            // InternalExprParser.g:6308:2: rule__RelationalExpression__OperatorAssignment_1_0_0_1
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
    // InternalExprParser.g:6322:1: rule__AdditiveExpression__Group__0 : rule__AdditiveExpression__Group__0__Impl rule__AdditiveExpression__Group__1 ;
    public final void rule__AdditiveExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6326:1: ( rule__AdditiveExpression__Group__0__Impl rule__AdditiveExpression__Group__1 )
            // InternalExprParser.g:6327:2: rule__AdditiveExpression__Group__0__Impl rule__AdditiveExpression__Group__1
            {
            pushFollow(FOLLOW_42);
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
    // InternalExprParser.g:6334:1: rule__AdditiveExpression__Group__0__Impl : ( ruleMultiplicativeExpression ) ;
    public final void rule__AdditiveExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6338:1: ( ( ruleMultiplicativeExpression ) )
            // InternalExprParser.g:6339:1: ( ruleMultiplicativeExpression )
            {
            // InternalExprParser.g:6339:1: ( ruleMultiplicativeExpression )
            // InternalExprParser.g:6340:1: ruleMultiplicativeExpression
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
    // InternalExprParser.g:6351:1: rule__AdditiveExpression__Group__1 : rule__AdditiveExpression__Group__1__Impl ;
    public final void rule__AdditiveExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6355:1: ( rule__AdditiveExpression__Group__1__Impl )
            // InternalExprParser.g:6356:2: rule__AdditiveExpression__Group__1__Impl
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
    // InternalExprParser.g:6362:1: rule__AdditiveExpression__Group__1__Impl : ( ( rule__AdditiveExpression__Group_1__0 )* ) ;
    public final void rule__AdditiveExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6366:1: ( ( ( rule__AdditiveExpression__Group_1__0 )* ) )
            // InternalExprParser.g:6367:1: ( ( rule__AdditiveExpression__Group_1__0 )* )
            {
            // InternalExprParser.g:6367:1: ( ( rule__AdditiveExpression__Group_1__0 )* )
            // InternalExprParser.g:6368:1: ( rule__AdditiveExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExpressionAccess().getGroup_1()); 
            }
            // InternalExprParser.g:6369:1: ( rule__AdditiveExpression__Group_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==PlusSign||LA32_0==HyphenMinus) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalExprParser.g:6369:2: rule__AdditiveExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_43);
            	    rule__AdditiveExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop32;
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
    // InternalExprParser.g:6383:1: rule__AdditiveExpression__Group_1__0 : rule__AdditiveExpression__Group_1__0__Impl rule__AdditiveExpression__Group_1__1 ;
    public final void rule__AdditiveExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6387:1: ( rule__AdditiveExpression__Group_1__0__Impl rule__AdditiveExpression__Group_1__1 )
            // InternalExprParser.g:6388:2: rule__AdditiveExpression__Group_1__0__Impl rule__AdditiveExpression__Group_1__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalExprParser.g:6395:1: rule__AdditiveExpression__Group_1__0__Impl : ( ( rule__AdditiveExpression__Group_1_0__0 ) ) ;
    public final void rule__AdditiveExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6399:1: ( ( ( rule__AdditiveExpression__Group_1_0__0 ) ) )
            // InternalExprParser.g:6400:1: ( ( rule__AdditiveExpression__Group_1_0__0 ) )
            {
            // InternalExprParser.g:6400:1: ( ( rule__AdditiveExpression__Group_1_0__0 ) )
            // InternalExprParser.g:6401:1: ( rule__AdditiveExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExpressionAccess().getGroup_1_0()); 
            }
            // InternalExprParser.g:6402:1: ( rule__AdditiveExpression__Group_1_0__0 )
            // InternalExprParser.g:6402:2: rule__AdditiveExpression__Group_1_0__0
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
    // InternalExprParser.g:6412:1: rule__AdditiveExpression__Group_1__1 : rule__AdditiveExpression__Group_1__1__Impl ;
    public final void rule__AdditiveExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6416:1: ( rule__AdditiveExpression__Group_1__1__Impl )
            // InternalExprParser.g:6417:2: rule__AdditiveExpression__Group_1__1__Impl
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
    // InternalExprParser.g:6423:1: rule__AdditiveExpression__Group_1__1__Impl : ( ( rule__AdditiveExpression__RightAssignment_1_1 ) ) ;
    public final void rule__AdditiveExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6427:1: ( ( ( rule__AdditiveExpression__RightAssignment_1_1 ) ) )
            // InternalExprParser.g:6428:1: ( ( rule__AdditiveExpression__RightAssignment_1_1 ) )
            {
            // InternalExprParser.g:6428:1: ( ( rule__AdditiveExpression__RightAssignment_1_1 ) )
            // InternalExprParser.g:6429:1: ( rule__AdditiveExpression__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExpressionAccess().getRightAssignment_1_1()); 
            }
            // InternalExprParser.g:6430:1: ( rule__AdditiveExpression__RightAssignment_1_1 )
            // InternalExprParser.g:6430:2: rule__AdditiveExpression__RightAssignment_1_1
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
    // InternalExprParser.g:6444:1: rule__AdditiveExpression__Group_1_0__0 : rule__AdditiveExpression__Group_1_0__0__Impl ;
    public final void rule__AdditiveExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6448:1: ( rule__AdditiveExpression__Group_1_0__0__Impl )
            // InternalExprParser.g:6449:2: rule__AdditiveExpression__Group_1_0__0__Impl
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
    // InternalExprParser.g:6455:1: rule__AdditiveExpression__Group_1_0__0__Impl : ( ( rule__AdditiveExpression__Group_1_0_0__0 ) ) ;
    public final void rule__AdditiveExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6459:1: ( ( ( rule__AdditiveExpression__Group_1_0_0__0 ) ) )
            // InternalExprParser.g:6460:1: ( ( rule__AdditiveExpression__Group_1_0_0__0 ) )
            {
            // InternalExprParser.g:6460:1: ( ( rule__AdditiveExpression__Group_1_0_0__0 ) )
            // InternalExprParser.g:6461:1: ( rule__AdditiveExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalExprParser.g:6462:1: ( rule__AdditiveExpression__Group_1_0_0__0 )
            // InternalExprParser.g:6462:2: rule__AdditiveExpression__Group_1_0_0__0
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
    // InternalExprParser.g:6474:1: rule__AdditiveExpression__Group_1_0_0__0 : rule__AdditiveExpression__Group_1_0_0__0__Impl rule__AdditiveExpression__Group_1_0_0__1 ;
    public final void rule__AdditiveExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6478:1: ( rule__AdditiveExpression__Group_1_0_0__0__Impl rule__AdditiveExpression__Group_1_0_0__1 )
            // InternalExprParser.g:6479:2: rule__AdditiveExpression__Group_1_0_0__0__Impl rule__AdditiveExpression__Group_1_0_0__1
            {
            pushFollow(FOLLOW_42);
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
    // InternalExprParser.g:6486:1: rule__AdditiveExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__AdditiveExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6490:1: ( ( () ) )
            // InternalExprParser.g:6491:1: ( () )
            {
            // InternalExprParser.g:6491:1: ( () )
            // InternalExprParser.g:6492:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExpressionAccess().getBinaryOperationLeftAction_1_0_0_0()); 
            }
            // InternalExprParser.g:6493:1: ()
            // InternalExprParser.g:6495:1: 
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
    // InternalExprParser.g:6505:1: rule__AdditiveExpression__Group_1_0_0__1 : rule__AdditiveExpression__Group_1_0_0__1__Impl ;
    public final void rule__AdditiveExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6509:1: ( rule__AdditiveExpression__Group_1_0_0__1__Impl )
            // InternalExprParser.g:6510:2: rule__AdditiveExpression__Group_1_0_0__1__Impl
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
    // InternalExprParser.g:6516:1: rule__AdditiveExpression__Group_1_0_0__1__Impl : ( ( rule__AdditiveExpression__OperatorAssignment_1_0_0_1 ) ) ;
    public final void rule__AdditiveExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6520:1: ( ( ( rule__AdditiveExpression__OperatorAssignment_1_0_0_1 ) ) )
            // InternalExprParser.g:6521:1: ( ( rule__AdditiveExpression__OperatorAssignment_1_0_0_1 ) )
            {
            // InternalExprParser.g:6521:1: ( ( rule__AdditiveExpression__OperatorAssignment_1_0_0_1 ) )
            // InternalExprParser.g:6522:1: ( rule__AdditiveExpression__OperatorAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExpressionAccess().getOperatorAssignment_1_0_0_1()); 
            }
            // InternalExprParser.g:6523:1: ( rule__AdditiveExpression__OperatorAssignment_1_0_0_1 )
            // InternalExprParser.g:6523:2: rule__AdditiveExpression__OperatorAssignment_1_0_0_1
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
    // InternalExprParser.g:6537:1: rule__MultiplicativeExpression__Group__0 : rule__MultiplicativeExpression__Group__0__Impl rule__MultiplicativeExpression__Group__1 ;
    public final void rule__MultiplicativeExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6541:1: ( rule__MultiplicativeExpression__Group__0__Impl rule__MultiplicativeExpression__Group__1 )
            // InternalExprParser.g:6542:2: rule__MultiplicativeExpression__Group__0__Impl rule__MultiplicativeExpression__Group__1
            {
            pushFollow(FOLLOW_44);
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
    // InternalExprParser.g:6549:1: rule__MultiplicativeExpression__Group__0__Impl : ( ruleUnaryOperation ) ;
    public final void rule__MultiplicativeExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6553:1: ( ( ruleUnaryOperation ) )
            // InternalExprParser.g:6554:1: ( ruleUnaryOperation )
            {
            // InternalExprParser.g:6554:1: ( ruleUnaryOperation )
            // InternalExprParser.g:6555:1: ruleUnaryOperation
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
    // InternalExprParser.g:6566:1: rule__MultiplicativeExpression__Group__1 : rule__MultiplicativeExpression__Group__1__Impl ;
    public final void rule__MultiplicativeExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6570:1: ( rule__MultiplicativeExpression__Group__1__Impl )
            // InternalExprParser.g:6571:2: rule__MultiplicativeExpression__Group__1__Impl
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
    // InternalExprParser.g:6577:1: rule__MultiplicativeExpression__Group__1__Impl : ( ( rule__MultiplicativeExpression__Group_1__0 )* ) ;
    public final void rule__MultiplicativeExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6581:1: ( ( ( rule__MultiplicativeExpression__Group_1__0 )* ) )
            // InternalExprParser.g:6582:1: ( ( rule__MultiplicativeExpression__Group_1__0 )* )
            {
            // InternalExprParser.g:6582:1: ( ( rule__MultiplicativeExpression__Group_1__0 )* )
            // InternalExprParser.g:6583:1: ( rule__MultiplicativeExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1()); 
            }
            // InternalExprParser.g:6584:1: ( rule__MultiplicativeExpression__Group_1__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==Div||LA33_0==Mod||LA33_0==Asterisk||LA33_0==Solidus) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalExprParser.g:6584:2: rule__MultiplicativeExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_45);
            	    rule__MultiplicativeExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
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
    // InternalExprParser.g:6598:1: rule__MultiplicativeExpression__Group_1__0 : rule__MultiplicativeExpression__Group_1__0__Impl rule__MultiplicativeExpression__Group_1__1 ;
    public final void rule__MultiplicativeExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6602:1: ( rule__MultiplicativeExpression__Group_1__0__Impl rule__MultiplicativeExpression__Group_1__1 )
            // InternalExprParser.g:6603:2: rule__MultiplicativeExpression__Group_1__0__Impl rule__MultiplicativeExpression__Group_1__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalExprParser.g:6610:1: rule__MultiplicativeExpression__Group_1__0__Impl : ( ( rule__MultiplicativeExpression__Group_1_0__0 ) ) ;
    public final void rule__MultiplicativeExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6614:1: ( ( ( rule__MultiplicativeExpression__Group_1_0__0 ) ) )
            // InternalExprParser.g:6615:1: ( ( rule__MultiplicativeExpression__Group_1_0__0 ) )
            {
            // InternalExprParser.g:6615:1: ( ( rule__MultiplicativeExpression__Group_1_0__0 ) )
            // InternalExprParser.g:6616:1: ( rule__MultiplicativeExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_0()); 
            }
            // InternalExprParser.g:6617:1: ( rule__MultiplicativeExpression__Group_1_0__0 )
            // InternalExprParser.g:6617:2: rule__MultiplicativeExpression__Group_1_0__0
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
    // InternalExprParser.g:6627:1: rule__MultiplicativeExpression__Group_1__1 : rule__MultiplicativeExpression__Group_1__1__Impl ;
    public final void rule__MultiplicativeExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6631:1: ( rule__MultiplicativeExpression__Group_1__1__Impl )
            // InternalExprParser.g:6632:2: rule__MultiplicativeExpression__Group_1__1__Impl
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
    // InternalExprParser.g:6638:1: rule__MultiplicativeExpression__Group_1__1__Impl : ( ( rule__MultiplicativeExpression__RightAssignment_1_1 ) ) ;
    public final void rule__MultiplicativeExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6642:1: ( ( ( rule__MultiplicativeExpression__RightAssignment_1_1 ) ) )
            // InternalExprParser.g:6643:1: ( ( rule__MultiplicativeExpression__RightAssignment_1_1 ) )
            {
            // InternalExprParser.g:6643:1: ( ( rule__MultiplicativeExpression__RightAssignment_1_1 ) )
            // InternalExprParser.g:6644:1: ( rule__MultiplicativeExpression__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExpressionAccess().getRightAssignment_1_1()); 
            }
            // InternalExprParser.g:6645:1: ( rule__MultiplicativeExpression__RightAssignment_1_1 )
            // InternalExprParser.g:6645:2: rule__MultiplicativeExpression__RightAssignment_1_1
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
    // InternalExprParser.g:6659:1: rule__MultiplicativeExpression__Group_1_0__0 : rule__MultiplicativeExpression__Group_1_0__0__Impl ;
    public final void rule__MultiplicativeExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6663:1: ( rule__MultiplicativeExpression__Group_1_0__0__Impl )
            // InternalExprParser.g:6664:2: rule__MultiplicativeExpression__Group_1_0__0__Impl
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
    // InternalExprParser.g:6670:1: rule__MultiplicativeExpression__Group_1_0__0__Impl : ( ( rule__MultiplicativeExpression__Group_1_0_0__0 ) ) ;
    public final void rule__MultiplicativeExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6674:1: ( ( ( rule__MultiplicativeExpression__Group_1_0_0__0 ) ) )
            // InternalExprParser.g:6675:1: ( ( rule__MultiplicativeExpression__Group_1_0_0__0 ) )
            {
            // InternalExprParser.g:6675:1: ( ( rule__MultiplicativeExpression__Group_1_0_0__0 ) )
            // InternalExprParser.g:6676:1: ( rule__MultiplicativeExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalExprParser.g:6677:1: ( rule__MultiplicativeExpression__Group_1_0_0__0 )
            // InternalExprParser.g:6677:2: rule__MultiplicativeExpression__Group_1_0_0__0
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
    // InternalExprParser.g:6689:1: rule__MultiplicativeExpression__Group_1_0_0__0 : rule__MultiplicativeExpression__Group_1_0_0__0__Impl rule__MultiplicativeExpression__Group_1_0_0__1 ;
    public final void rule__MultiplicativeExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6693:1: ( rule__MultiplicativeExpression__Group_1_0_0__0__Impl rule__MultiplicativeExpression__Group_1_0_0__1 )
            // InternalExprParser.g:6694:2: rule__MultiplicativeExpression__Group_1_0_0__0__Impl rule__MultiplicativeExpression__Group_1_0_0__1
            {
            pushFollow(FOLLOW_44);
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
    // InternalExprParser.g:6701:1: rule__MultiplicativeExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__MultiplicativeExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6705:1: ( ( () ) )
            // InternalExprParser.g:6706:1: ( () )
            {
            // InternalExprParser.g:6706:1: ( () )
            // InternalExprParser.g:6707:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExpressionAccess().getBinaryOperationLeftAction_1_0_0_0()); 
            }
            // InternalExprParser.g:6708:1: ()
            // InternalExprParser.g:6710:1: 
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
    // InternalExprParser.g:6720:1: rule__MultiplicativeExpression__Group_1_0_0__1 : rule__MultiplicativeExpression__Group_1_0_0__1__Impl ;
    public final void rule__MultiplicativeExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6724:1: ( rule__MultiplicativeExpression__Group_1_0_0__1__Impl )
            // InternalExprParser.g:6725:2: rule__MultiplicativeExpression__Group_1_0_0__1__Impl
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
    // InternalExprParser.g:6731:1: rule__MultiplicativeExpression__Group_1_0_0__1__Impl : ( ( rule__MultiplicativeExpression__OperatorAssignment_1_0_0_1 ) ) ;
    public final void rule__MultiplicativeExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6735:1: ( ( ( rule__MultiplicativeExpression__OperatorAssignment_1_0_0_1 ) ) )
            // InternalExprParser.g:6736:1: ( ( rule__MultiplicativeExpression__OperatorAssignment_1_0_0_1 ) )
            {
            // InternalExprParser.g:6736:1: ( ( rule__MultiplicativeExpression__OperatorAssignment_1_0_0_1 ) )
            // InternalExprParser.g:6737:1: ( rule__MultiplicativeExpression__OperatorAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAssignment_1_0_0_1()); 
            }
            // InternalExprParser.g:6738:1: ( rule__MultiplicativeExpression__OperatorAssignment_1_0_0_1 )
            // InternalExprParser.g:6738:2: rule__MultiplicativeExpression__OperatorAssignment_1_0_0_1
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
    // InternalExprParser.g:6752:1: rule__UnaryOperation__Group_0__0 : rule__UnaryOperation__Group_0__0__Impl rule__UnaryOperation__Group_0__1 ;
    public final void rule__UnaryOperation__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6756:1: ( rule__UnaryOperation__Group_0__0__Impl rule__UnaryOperation__Group_0__1 )
            // InternalExprParser.g:6757:2: rule__UnaryOperation__Group_0__0__Impl rule__UnaryOperation__Group_0__1
            {
            pushFollow(FOLLOW_46);
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
    // InternalExprParser.g:6764:1: rule__UnaryOperation__Group_0__0__Impl : ( () ) ;
    public final void rule__UnaryOperation__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6768:1: ( ( () ) )
            // InternalExprParser.g:6769:1: ( () )
            {
            // InternalExprParser.g:6769:1: ( () )
            // InternalExprParser.g:6770:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryOperationAccess().getUnaryOperationAction_0_0()); 
            }
            // InternalExprParser.g:6771:1: ()
            // InternalExprParser.g:6773:1: 
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
    // InternalExprParser.g:6783:1: rule__UnaryOperation__Group_0__1 : rule__UnaryOperation__Group_0__1__Impl rule__UnaryOperation__Group_0__2 ;
    public final void rule__UnaryOperation__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6787:1: ( rule__UnaryOperation__Group_0__1__Impl rule__UnaryOperation__Group_0__2 )
            // InternalExprParser.g:6788:2: rule__UnaryOperation__Group_0__1__Impl rule__UnaryOperation__Group_0__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalExprParser.g:6795:1: rule__UnaryOperation__Group_0__1__Impl : ( ( rule__UnaryOperation__OperatorAssignment_0_1 ) ) ;
    public final void rule__UnaryOperation__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6799:1: ( ( ( rule__UnaryOperation__OperatorAssignment_0_1 ) ) )
            // InternalExprParser.g:6800:1: ( ( rule__UnaryOperation__OperatorAssignment_0_1 ) )
            {
            // InternalExprParser.g:6800:1: ( ( rule__UnaryOperation__OperatorAssignment_0_1 ) )
            // InternalExprParser.g:6801:1: ( rule__UnaryOperation__OperatorAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryOperationAccess().getOperatorAssignment_0_1()); 
            }
            // InternalExprParser.g:6802:1: ( rule__UnaryOperation__OperatorAssignment_0_1 )
            // InternalExprParser.g:6802:2: rule__UnaryOperation__OperatorAssignment_0_1
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
    // InternalExprParser.g:6812:1: rule__UnaryOperation__Group_0__2 : rule__UnaryOperation__Group_0__2__Impl ;
    public final void rule__UnaryOperation__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6816:1: ( rule__UnaryOperation__Group_0__2__Impl )
            // InternalExprParser.g:6817:2: rule__UnaryOperation__Group_0__2__Impl
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
    // InternalExprParser.g:6823:1: rule__UnaryOperation__Group_0__2__Impl : ( ( rule__UnaryOperation__OperandAssignment_0_2 ) ) ;
    public final void rule__UnaryOperation__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6827:1: ( ( ( rule__UnaryOperation__OperandAssignment_0_2 ) ) )
            // InternalExprParser.g:6828:1: ( ( rule__UnaryOperation__OperandAssignment_0_2 ) )
            {
            // InternalExprParser.g:6828:1: ( ( rule__UnaryOperation__OperandAssignment_0_2 ) )
            // InternalExprParser.g:6829:1: ( rule__UnaryOperation__OperandAssignment_0_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryOperationAccess().getOperandAssignment_0_2()); 
            }
            // InternalExprParser.g:6830:1: ( rule__UnaryOperation__OperandAssignment_0_2 )
            // InternalExprParser.g:6830:2: rule__UnaryOperation__OperandAssignment_0_2
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
    // InternalExprParser.g:6846:1: rule__UnitExpression__Group__0 : rule__UnitExpression__Group__0__Impl rule__UnitExpression__Group__1 ;
    public final void rule__UnitExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6850:1: ( rule__UnitExpression__Group__0__Impl rule__UnitExpression__Group__1 )
            // InternalExprParser.g:6851:2: rule__UnitExpression__Group__0__Impl rule__UnitExpression__Group__1
            {
            pushFollow(FOLLOW_47);
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
    // InternalExprParser.g:6858:1: rule__UnitExpression__Group__0__Impl : ( rulePrimaryExpression ) ;
    public final void rule__UnitExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6862:1: ( ( rulePrimaryExpression ) )
            // InternalExprParser.g:6863:1: ( rulePrimaryExpression )
            {
            // InternalExprParser.g:6863:1: ( rulePrimaryExpression )
            // InternalExprParser.g:6864:1: rulePrimaryExpression
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
    // InternalExprParser.g:6875:1: rule__UnitExpression__Group__1 : rule__UnitExpression__Group__1__Impl ;
    public final void rule__UnitExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6879:1: ( rule__UnitExpression__Group__1__Impl )
            // InternalExprParser.g:6880:2: rule__UnitExpression__Group__1__Impl
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
    // InternalExprParser.g:6886:1: rule__UnitExpression__Group__1__Impl : ( ( rule__UnitExpression__Group_1__0 )? ) ;
    public final void rule__UnitExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6890:1: ( ( ( rule__UnitExpression__Group_1__0 )? ) )
            // InternalExprParser.g:6891:1: ( ( rule__UnitExpression__Group_1__0 )? )
            {
            // InternalExprParser.g:6891:1: ( ( rule__UnitExpression__Group_1__0 )? )
            // InternalExprParser.g:6892:1: ( rule__UnitExpression__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnitExpressionAccess().getGroup_1()); 
            }
            // InternalExprParser.g:6893:1: ( rule__UnitExpression__Group_1__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==In||LA34_0==PercentSign||LA34_0==RULE_ID) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalExprParser.g:6893:2: rule__UnitExpression__Group_1__0
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
    // InternalExprParser.g:6907:1: rule__UnitExpression__Group_1__0 : rule__UnitExpression__Group_1__0__Impl rule__UnitExpression__Group_1__1 ;
    public final void rule__UnitExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6911:1: ( rule__UnitExpression__Group_1__0__Impl rule__UnitExpression__Group_1__1 )
            // InternalExprParser.g:6912:2: rule__UnitExpression__Group_1__0__Impl rule__UnitExpression__Group_1__1
            {
            pushFollow(FOLLOW_47);
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
    // InternalExprParser.g:6919:1: rule__UnitExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__UnitExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6923:1: ( ( () ) )
            // InternalExprParser.g:6924:1: ( () )
            {
            // InternalExprParser.g:6924:1: ( () )
            // InternalExprParser.g:6925:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnitExpressionAccess().getUnitExpressionExpressionAction_1_0()); 
            }
            // InternalExprParser.g:6926:1: ()
            // InternalExprParser.g:6928:1: 
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
    // InternalExprParser.g:6938:1: rule__UnitExpression__Group_1__1 : rule__UnitExpression__Group_1__1__Impl rule__UnitExpression__Group_1__2 ;
    public final void rule__UnitExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6942:1: ( rule__UnitExpression__Group_1__1__Impl rule__UnitExpression__Group_1__2 )
            // InternalExprParser.g:6943:2: rule__UnitExpression__Group_1__1__Impl rule__UnitExpression__Group_1__2
            {
            pushFollow(FOLLOW_47);
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
    // InternalExprParser.g:6950:1: rule__UnitExpression__Group_1__1__Impl : ( ( rule__UnitExpression__Alternatives_1_1 )? ) ;
    public final void rule__UnitExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6954:1: ( ( ( rule__UnitExpression__Alternatives_1_1 )? ) )
            // InternalExprParser.g:6955:1: ( ( rule__UnitExpression__Alternatives_1_1 )? )
            {
            // InternalExprParser.g:6955:1: ( ( rule__UnitExpression__Alternatives_1_1 )? )
            // InternalExprParser.g:6956:1: ( rule__UnitExpression__Alternatives_1_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnitExpressionAccess().getAlternatives_1_1()); 
            }
            // InternalExprParser.g:6957:1: ( rule__UnitExpression__Alternatives_1_1 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==In||LA35_0==PercentSign) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalExprParser.g:6957:2: rule__UnitExpression__Alternatives_1_1
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
    // InternalExprParser.g:6967:1: rule__UnitExpression__Group_1__2 : rule__UnitExpression__Group_1__2__Impl ;
    public final void rule__UnitExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6971:1: ( rule__UnitExpression__Group_1__2__Impl )
            // InternalExprParser.g:6972:2: rule__UnitExpression__Group_1__2__Impl
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
    // InternalExprParser.g:6978:1: rule__UnitExpression__Group_1__2__Impl : ( ( rule__UnitExpression__UnitAssignment_1_2 ) ) ;
    public final void rule__UnitExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:6982:1: ( ( ( rule__UnitExpression__UnitAssignment_1_2 ) ) )
            // InternalExprParser.g:6983:1: ( ( rule__UnitExpression__UnitAssignment_1_2 ) )
            {
            // InternalExprParser.g:6983:1: ( ( rule__UnitExpression__UnitAssignment_1_2 ) )
            // InternalExprParser.g:6984:1: ( rule__UnitExpression__UnitAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnitExpressionAccess().getUnitAssignment_1_2()); 
            }
            // InternalExprParser.g:6985:1: ( rule__UnitExpression__UnitAssignment_1_2 )
            // InternalExprParser.g:6985:2: rule__UnitExpression__UnitAssignment_1_2
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
    // InternalExprParser.g:7001:1: rule__PrimaryExpression__Group_6__0 : rule__PrimaryExpression__Group_6__0__Impl rule__PrimaryExpression__Group_6__1 ;
    public final void rule__PrimaryExpression__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7005:1: ( rule__PrimaryExpression__Group_6__0__Impl rule__PrimaryExpression__Group_6__1 )
            // InternalExprParser.g:7006:2: rule__PrimaryExpression__Group_6__0__Impl rule__PrimaryExpression__Group_6__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalExprParser.g:7013:1: rule__PrimaryExpression__Group_6__0__Impl : ( LeftParenthesis ) ;
    public final void rule__PrimaryExpression__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7017:1: ( ( LeftParenthesis ) )
            // InternalExprParser.g:7018:1: ( LeftParenthesis )
            {
            // InternalExprParser.g:7018:1: ( LeftParenthesis )
            // InternalExprParser.g:7019:1: LeftParenthesis
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
    // InternalExprParser.g:7032:1: rule__PrimaryExpression__Group_6__1 : rule__PrimaryExpression__Group_6__1__Impl rule__PrimaryExpression__Group_6__2 ;
    public final void rule__PrimaryExpression__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7036:1: ( rule__PrimaryExpression__Group_6__1__Impl rule__PrimaryExpression__Group_6__2 )
            // InternalExprParser.g:7037:2: rule__PrimaryExpression__Group_6__1__Impl rule__PrimaryExpression__Group_6__2
            {
            pushFollow(FOLLOW_12);
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
    // InternalExprParser.g:7044:1: rule__PrimaryExpression__Group_6__1__Impl : ( ruleExpression ) ;
    public final void rule__PrimaryExpression__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7048:1: ( ( ruleExpression ) )
            // InternalExprParser.g:7049:1: ( ruleExpression )
            {
            // InternalExprParser.g:7049:1: ( ruleExpression )
            // InternalExprParser.g:7050:1: ruleExpression
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
    // InternalExprParser.g:7061:1: rule__PrimaryExpression__Group_6__2 : rule__PrimaryExpression__Group_6__2__Impl ;
    public final void rule__PrimaryExpression__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7065:1: ( rule__PrimaryExpression__Group_6__2__Impl )
            // InternalExprParser.g:7066:2: rule__PrimaryExpression__Group_6__2__Impl
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
    // InternalExprParser.g:7072:1: rule__PrimaryExpression__Group_6__2__Impl : ( RightParenthesis ) ;
    public final void rule__PrimaryExpression__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7076:1: ( ( RightParenthesis ) )
            // InternalExprParser.g:7077:1: ( RightParenthesis )
            {
            // InternalExprParser.g:7077:1: ( RightParenthesis )
            // InternalExprParser.g:7078:1: RightParenthesis
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
    // InternalExprParser.g:7097:1: rule__ModelOrPropertyReference__Group_0__0 : rule__ModelOrPropertyReference__Group_0__0__Impl rule__ModelOrPropertyReference__Group_0__1 ;
    public final void rule__ModelOrPropertyReference__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7101:1: ( rule__ModelOrPropertyReference__Group_0__0__Impl rule__ModelOrPropertyReference__Group_0__1 )
            // InternalExprParser.g:7102:2: rule__ModelOrPropertyReference__Group_0__0__Impl rule__ModelOrPropertyReference__Group_0__1
            {
            pushFollow(FOLLOW_48);
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
    // InternalExprParser.g:7109:1: rule__ModelOrPropertyReference__Group_0__0__Impl : ( ruleModelReference ) ;
    public final void rule__ModelOrPropertyReference__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7113:1: ( ( ruleModelReference ) )
            // InternalExprParser.g:7114:1: ( ruleModelReference )
            {
            // InternalExprParser.g:7114:1: ( ruleModelReference )
            // InternalExprParser.g:7115:1: ruleModelReference
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
    // InternalExprParser.g:7126:1: rule__ModelOrPropertyReference__Group_0__1 : rule__ModelOrPropertyReference__Group_0__1__Impl ;
    public final void rule__ModelOrPropertyReference__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7130:1: ( rule__ModelOrPropertyReference__Group_0__1__Impl )
            // InternalExprParser.g:7131:2: rule__ModelOrPropertyReference__Group_0__1__Impl
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
    // InternalExprParser.g:7137:1: rule__ModelOrPropertyReference__Group_0__1__Impl : ( ( rule__ModelOrPropertyReference__Group_0_1__0 )? ) ;
    public final void rule__ModelOrPropertyReference__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7141:1: ( ( ( rule__ModelOrPropertyReference__Group_0_1__0 )? ) )
            // InternalExprParser.g:7142:1: ( ( rule__ModelOrPropertyReference__Group_0_1__0 )? )
            {
            // InternalExprParser.g:7142:1: ( ( rule__ModelOrPropertyReference__Group_0_1__0 )? )
            // InternalExprParser.g:7143:1: ( rule__ModelOrPropertyReference__Group_0_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelOrPropertyReferenceAccess().getGroup_0_1()); 
            }
            // InternalExprParser.g:7144:1: ( rule__ModelOrPropertyReference__Group_0_1__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==NumberSign) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalExprParser.g:7144:2: rule__ModelOrPropertyReference__Group_0_1__0
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
    // InternalExprParser.g:7158:1: rule__ModelOrPropertyReference__Group_0_1__0 : rule__ModelOrPropertyReference__Group_0_1__0__Impl rule__ModelOrPropertyReference__Group_0_1__1 ;
    public final void rule__ModelOrPropertyReference__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7162:1: ( rule__ModelOrPropertyReference__Group_0_1__0__Impl rule__ModelOrPropertyReference__Group_0_1__1 )
            // InternalExprParser.g:7163:2: rule__ModelOrPropertyReference__Group_0_1__0__Impl rule__ModelOrPropertyReference__Group_0_1__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalExprParser.g:7170:1: rule__ModelOrPropertyReference__Group_0_1__0__Impl : ( ( rule__ModelOrPropertyReference__Group_0_1_0__0 ) ) ;
    public final void rule__ModelOrPropertyReference__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7174:1: ( ( ( rule__ModelOrPropertyReference__Group_0_1_0__0 ) ) )
            // InternalExprParser.g:7175:1: ( ( rule__ModelOrPropertyReference__Group_0_1_0__0 ) )
            {
            // InternalExprParser.g:7175:1: ( ( rule__ModelOrPropertyReference__Group_0_1_0__0 ) )
            // InternalExprParser.g:7176:1: ( rule__ModelOrPropertyReference__Group_0_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelOrPropertyReferenceAccess().getGroup_0_1_0()); 
            }
            // InternalExprParser.g:7177:1: ( rule__ModelOrPropertyReference__Group_0_1_0__0 )
            // InternalExprParser.g:7177:2: rule__ModelOrPropertyReference__Group_0_1_0__0
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
    // InternalExprParser.g:7187:1: rule__ModelOrPropertyReference__Group_0_1__1 : rule__ModelOrPropertyReference__Group_0_1__1__Impl ;
    public final void rule__ModelOrPropertyReference__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7191:1: ( rule__ModelOrPropertyReference__Group_0_1__1__Impl )
            // InternalExprParser.g:7192:2: rule__ModelOrPropertyReference__Group_0_1__1__Impl
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
    // InternalExprParser.g:7198:1: rule__ModelOrPropertyReference__Group_0_1__1__Impl : ( ( rule__ModelOrPropertyReference__PropertyAssignment_0_1_1 ) ) ;
    public final void rule__ModelOrPropertyReference__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7202:1: ( ( ( rule__ModelOrPropertyReference__PropertyAssignment_0_1_1 ) ) )
            // InternalExprParser.g:7203:1: ( ( rule__ModelOrPropertyReference__PropertyAssignment_0_1_1 ) )
            {
            // InternalExprParser.g:7203:1: ( ( rule__ModelOrPropertyReference__PropertyAssignment_0_1_1 ) )
            // InternalExprParser.g:7204:1: ( rule__ModelOrPropertyReference__PropertyAssignment_0_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelOrPropertyReferenceAccess().getPropertyAssignment_0_1_1()); 
            }
            // InternalExprParser.g:7205:1: ( rule__ModelOrPropertyReference__PropertyAssignment_0_1_1 )
            // InternalExprParser.g:7205:2: rule__ModelOrPropertyReference__PropertyAssignment_0_1_1
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
    // InternalExprParser.g:7219:1: rule__ModelOrPropertyReference__Group_0_1_0__0 : rule__ModelOrPropertyReference__Group_0_1_0__0__Impl ;
    public final void rule__ModelOrPropertyReference__Group_0_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7223:1: ( rule__ModelOrPropertyReference__Group_0_1_0__0__Impl )
            // InternalExprParser.g:7224:2: rule__ModelOrPropertyReference__Group_0_1_0__0__Impl
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
    // InternalExprParser.g:7230:1: rule__ModelOrPropertyReference__Group_0_1_0__0__Impl : ( ( rule__ModelOrPropertyReference__Group_0_1_0_0__0 ) ) ;
    public final void rule__ModelOrPropertyReference__Group_0_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7234:1: ( ( ( rule__ModelOrPropertyReference__Group_0_1_0_0__0 ) ) )
            // InternalExprParser.g:7235:1: ( ( rule__ModelOrPropertyReference__Group_0_1_0_0__0 ) )
            {
            // InternalExprParser.g:7235:1: ( ( rule__ModelOrPropertyReference__Group_0_1_0_0__0 ) )
            // InternalExprParser.g:7236:1: ( rule__ModelOrPropertyReference__Group_0_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelOrPropertyReferenceAccess().getGroup_0_1_0_0()); 
            }
            // InternalExprParser.g:7237:1: ( rule__ModelOrPropertyReference__Group_0_1_0_0__0 )
            // InternalExprParser.g:7237:2: rule__ModelOrPropertyReference__Group_0_1_0_0__0
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
    // InternalExprParser.g:7249:1: rule__ModelOrPropertyReference__Group_0_1_0_0__0 : rule__ModelOrPropertyReference__Group_0_1_0_0__0__Impl rule__ModelOrPropertyReference__Group_0_1_0_0__1 ;
    public final void rule__ModelOrPropertyReference__Group_0_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7253:1: ( rule__ModelOrPropertyReference__Group_0_1_0_0__0__Impl rule__ModelOrPropertyReference__Group_0_1_0_0__1 )
            // InternalExprParser.g:7254:2: rule__ModelOrPropertyReference__Group_0_1_0_0__0__Impl rule__ModelOrPropertyReference__Group_0_1_0_0__1
            {
            pushFollow(FOLLOW_48);
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
    // InternalExprParser.g:7261:1: rule__ModelOrPropertyReference__Group_0_1_0_0__0__Impl : ( () ) ;
    public final void rule__ModelOrPropertyReference__Group_0_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7265:1: ( ( () ) )
            // InternalExprParser.g:7266:1: ( () )
            {
            // InternalExprParser.g:7266:1: ( () )
            // InternalExprParser.g:7267:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelOrPropertyReferenceAccess().getPropertyReferenceModelElementReferenceAction_0_1_0_0_0()); 
            }
            // InternalExprParser.g:7268:1: ()
            // InternalExprParser.g:7270:1: 
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
    // InternalExprParser.g:7280:1: rule__ModelOrPropertyReference__Group_0_1_0_0__1 : rule__ModelOrPropertyReference__Group_0_1_0_0__1__Impl ;
    public final void rule__ModelOrPropertyReference__Group_0_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7284:1: ( rule__ModelOrPropertyReference__Group_0_1_0_0__1__Impl )
            // InternalExprParser.g:7285:2: rule__ModelOrPropertyReference__Group_0_1_0_0__1__Impl
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
    // InternalExprParser.g:7291:1: rule__ModelOrPropertyReference__Group_0_1_0_0__1__Impl : ( NumberSign ) ;
    public final void rule__ModelOrPropertyReference__Group_0_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7295:1: ( ( NumberSign ) )
            // InternalExprParser.g:7296:1: ( NumberSign )
            {
            // InternalExprParser.g:7296:1: ( NumberSign )
            // InternalExprParser.g:7297:1: NumberSign
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
    // InternalExprParser.g:7314:1: rule__ModelReference__Group__0 : rule__ModelReference__Group__0__Impl rule__ModelReference__Group__1 ;
    public final void rule__ModelReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7318:1: ( rule__ModelReference__Group__0__Impl rule__ModelReference__Group__1 )
            // InternalExprParser.g:7319:2: rule__ModelReference__Group__0__Impl rule__ModelReference__Group__1
            {
            pushFollow(FOLLOW_49);
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
    // InternalExprParser.g:7326:1: rule__ModelReference__Group__0__Impl : ( ( rule__ModelReference__ModelElementAssignment_0 ) ) ;
    public final void rule__ModelReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7330:1: ( ( ( rule__ModelReference__ModelElementAssignment_0 ) ) )
            // InternalExprParser.g:7331:1: ( ( rule__ModelReference__ModelElementAssignment_0 ) )
            {
            // InternalExprParser.g:7331:1: ( ( rule__ModelReference__ModelElementAssignment_0 ) )
            // InternalExprParser.g:7332:1: ( rule__ModelReference__ModelElementAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelReferenceAccess().getModelElementAssignment_0()); 
            }
            // InternalExprParser.g:7333:1: ( rule__ModelReference__ModelElementAssignment_0 )
            // InternalExprParser.g:7333:2: rule__ModelReference__ModelElementAssignment_0
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
    // InternalExprParser.g:7343:1: rule__ModelReference__Group__1 : rule__ModelReference__Group__1__Impl ;
    public final void rule__ModelReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7347:1: ( rule__ModelReference__Group__1__Impl )
            // InternalExprParser.g:7348:2: rule__ModelReference__Group__1__Impl
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
    // InternalExprParser.g:7354:1: rule__ModelReference__Group__1__Impl : ( ( rule__ModelReference__Group_1__0 )* ) ;
    public final void rule__ModelReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7358:1: ( ( ( rule__ModelReference__Group_1__0 )* ) )
            // InternalExprParser.g:7359:1: ( ( rule__ModelReference__Group_1__0 )* )
            {
            // InternalExprParser.g:7359:1: ( ( rule__ModelReference__Group_1__0 )* )
            // InternalExprParser.g:7360:1: ( rule__ModelReference__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelReferenceAccess().getGroup_1()); 
            }
            // InternalExprParser.g:7361:1: ( rule__ModelReference__Group_1__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==FullStop) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalExprParser.g:7361:2: rule__ModelReference__Group_1__0
            	    {
            	    pushFollow(FOLLOW_50);
            	    rule__ModelReference__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop37;
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
    // InternalExprParser.g:7375:1: rule__ModelReference__Group_1__0 : rule__ModelReference__Group_1__0__Impl rule__ModelReference__Group_1__1 ;
    public final void rule__ModelReference__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7379:1: ( rule__ModelReference__Group_1__0__Impl rule__ModelReference__Group_1__1 )
            // InternalExprParser.g:7380:2: rule__ModelReference__Group_1__0__Impl rule__ModelReference__Group_1__1
            {
            pushFollow(FOLLOW_49);
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
    // InternalExprParser.g:7387:1: rule__ModelReference__Group_1__0__Impl : ( () ) ;
    public final void rule__ModelReference__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7391:1: ( ( () ) )
            // InternalExprParser.g:7392:1: ( () )
            {
            // InternalExprParser.g:7392:1: ( () )
            // InternalExprParser.g:7393:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelReferenceAccess().getModelReferencePrevAction_1_0()); 
            }
            // InternalExprParser.g:7394:1: ()
            // InternalExprParser.g:7396:1: 
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
    // InternalExprParser.g:7406:1: rule__ModelReference__Group_1__1 : rule__ModelReference__Group_1__1__Impl rule__ModelReference__Group_1__2 ;
    public final void rule__ModelReference__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7410:1: ( rule__ModelReference__Group_1__1__Impl rule__ModelReference__Group_1__2 )
            // InternalExprParser.g:7411:2: rule__ModelReference__Group_1__1__Impl rule__ModelReference__Group_1__2
            {
            pushFollow(FOLLOW_5);
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
    // InternalExprParser.g:7418:1: rule__ModelReference__Group_1__1__Impl : ( FullStop ) ;
    public final void rule__ModelReference__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7422:1: ( ( FullStop ) )
            // InternalExprParser.g:7423:1: ( FullStop )
            {
            // InternalExprParser.g:7423:1: ( FullStop )
            // InternalExprParser.g:7424:1: FullStop
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
    // InternalExprParser.g:7437:1: rule__ModelReference__Group_1__2 : rule__ModelReference__Group_1__2__Impl ;
    public final void rule__ModelReference__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7441:1: ( rule__ModelReference__Group_1__2__Impl )
            // InternalExprParser.g:7442:2: rule__ModelReference__Group_1__2__Impl
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
    // InternalExprParser.g:7448:1: rule__ModelReference__Group_1__2__Impl : ( ( rule__ModelReference__ModelElementAssignment_1_2 ) ) ;
    public final void rule__ModelReference__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7452:1: ( ( ( rule__ModelReference__ModelElementAssignment_1_2 ) ) )
            // InternalExprParser.g:7453:1: ( ( rule__ModelReference__ModelElementAssignment_1_2 ) )
            {
            // InternalExprParser.g:7453:1: ( ( rule__ModelReference__ModelElementAssignment_1_2 ) )
            // InternalExprParser.g:7454:1: ( rule__ModelReference__ModelElementAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelReferenceAccess().getModelElementAssignment_1_2()); 
            }
            // InternalExprParser.g:7455:1: ( rule__ModelReference__ModelElementAssignment_1_2 )
            // InternalExprParser.g:7455:2: rule__ModelReference__ModelElementAssignment_1_2
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
    // InternalExprParser.g:7471:1: rule__PropertyReference__Group__0 : rule__PropertyReference__Group__0__Impl rule__PropertyReference__Group__1 ;
    public final void rule__PropertyReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7475:1: ( rule__PropertyReference__Group__0__Impl rule__PropertyReference__Group__1 )
            // InternalExprParser.g:7476:2: rule__PropertyReference__Group__0__Impl rule__PropertyReference__Group__1
            {
            pushFollow(FOLLOW_51);
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
    // InternalExprParser.g:7483:1: rule__PropertyReference__Group__0__Impl : ( () ) ;
    public final void rule__PropertyReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7487:1: ( ( () ) )
            // InternalExprParser.g:7488:1: ( () )
            {
            // InternalExprParser.g:7488:1: ( () )
            // InternalExprParser.g:7489:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyReferenceAccess().getPropertyReferenceAction_0()); 
            }
            // InternalExprParser.g:7490:1: ()
            // InternalExprParser.g:7492:1: 
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
    // InternalExprParser.g:7502:1: rule__PropertyReference__Group__1 : rule__PropertyReference__Group__1__Impl rule__PropertyReference__Group__2 ;
    public final void rule__PropertyReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7506:1: ( rule__PropertyReference__Group__1__Impl rule__PropertyReference__Group__2 )
            // InternalExprParser.g:7507:2: rule__PropertyReference__Group__1__Impl rule__PropertyReference__Group__2
            {
            pushFollow(FOLLOW_5);
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
    // InternalExprParser.g:7514:1: rule__PropertyReference__Group__1__Impl : ( NumberSign ) ;
    public final void rule__PropertyReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7518:1: ( ( NumberSign ) )
            // InternalExprParser.g:7519:1: ( NumberSign )
            {
            // InternalExprParser.g:7519:1: ( NumberSign )
            // InternalExprParser.g:7520:1: NumberSign
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
    // InternalExprParser.g:7533:1: rule__PropertyReference__Group__2 : rule__PropertyReference__Group__2__Impl ;
    public final void rule__PropertyReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7537:1: ( rule__PropertyReference__Group__2__Impl )
            // InternalExprParser.g:7538:2: rule__PropertyReference__Group__2__Impl
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
    // InternalExprParser.g:7544:1: rule__PropertyReference__Group__2__Impl : ( ( rule__PropertyReference__PropertyAssignment_2 ) ) ;
    public final void rule__PropertyReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7548:1: ( ( ( rule__PropertyReference__PropertyAssignment_2 ) ) )
            // InternalExprParser.g:7549:1: ( ( rule__PropertyReference__PropertyAssignment_2 ) )
            {
            // InternalExprParser.g:7549:1: ( ( rule__PropertyReference__PropertyAssignment_2 ) )
            // InternalExprParser.g:7550:1: ( rule__PropertyReference__PropertyAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyReferenceAccess().getPropertyAssignment_2()); 
            }
            // InternalExprParser.g:7551:1: ( rule__PropertyReference__PropertyAssignment_2 )
            // InternalExprParser.g:7551:2: rule__PropertyReference__PropertyAssignment_2
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
    // InternalExprParser.g:7567:1: rule__FunctionCall__Group__0 : rule__FunctionCall__Group__0__Impl rule__FunctionCall__Group__1 ;
    public final void rule__FunctionCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7571:1: ( rule__FunctionCall__Group__0__Impl rule__FunctionCall__Group__1 )
            // InternalExprParser.g:7572:2: rule__FunctionCall__Group__0__Impl rule__FunctionCall__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalExprParser.g:7579:1: rule__FunctionCall__Group__0__Impl : ( () ) ;
    public final void rule__FunctionCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7583:1: ( ( () ) )
            // InternalExprParser.g:7584:1: ( () )
            {
            // InternalExprParser.g:7584:1: ( () )
            // InternalExprParser.g:7585:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionCallAccess().getFunctionCallAction_0()); 
            }
            // InternalExprParser.g:7586:1: ()
            // InternalExprParser.g:7588:1: 
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
    // InternalExprParser.g:7598:1: rule__FunctionCall__Group__1 : rule__FunctionCall__Group__1__Impl rule__FunctionCall__Group__2 ;
    public final void rule__FunctionCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7602:1: ( rule__FunctionCall__Group__1__Impl rule__FunctionCall__Group__2 )
            // InternalExprParser.g:7603:2: rule__FunctionCall__Group__1__Impl rule__FunctionCall__Group__2
            {
            pushFollow(FOLLOW_11);
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
    // InternalExprParser.g:7610:1: rule__FunctionCall__Group__1__Impl : ( ( rule__FunctionCall__FunctionAssignment_1 ) ) ;
    public final void rule__FunctionCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7614:1: ( ( ( rule__FunctionCall__FunctionAssignment_1 ) ) )
            // InternalExprParser.g:7615:1: ( ( rule__FunctionCall__FunctionAssignment_1 ) )
            {
            // InternalExprParser.g:7615:1: ( ( rule__FunctionCall__FunctionAssignment_1 ) )
            // InternalExprParser.g:7616:1: ( rule__FunctionCall__FunctionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionCallAccess().getFunctionAssignment_1()); 
            }
            // InternalExprParser.g:7617:1: ( rule__FunctionCall__FunctionAssignment_1 )
            // InternalExprParser.g:7617:2: rule__FunctionCall__FunctionAssignment_1
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
    // InternalExprParser.g:7627:1: rule__FunctionCall__Group__2 : rule__FunctionCall__Group__2__Impl rule__FunctionCall__Group__3 ;
    public final void rule__FunctionCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7631:1: ( rule__FunctionCall__Group__2__Impl rule__FunctionCall__Group__3 )
            // InternalExprParser.g:7632:2: rule__FunctionCall__Group__2__Impl rule__FunctionCall__Group__3
            {
            pushFollow(FOLLOW_52);
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
    // InternalExprParser.g:7639:1: rule__FunctionCall__Group__2__Impl : ( LeftParenthesis ) ;
    public final void rule__FunctionCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7643:1: ( ( LeftParenthesis ) )
            // InternalExprParser.g:7644:1: ( LeftParenthesis )
            {
            // InternalExprParser.g:7644:1: ( LeftParenthesis )
            // InternalExprParser.g:7645:1: LeftParenthesis
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
    // InternalExprParser.g:7658:1: rule__FunctionCall__Group__3 : rule__FunctionCall__Group__3__Impl rule__FunctionCall__Group__4 ;
    public final void rule__FunctionCall__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7662:1: ( rule__FunctionCall__Group__3__Impl rule__FunctionCall__Group__4 )
            // InternalExprParser.g:7663:2: rule__FunctionCall__Group__3__Impl rule__FunctionCall__Group__4
            {
            pushFollow(FOLLOW_52);
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
    // InternalExprParser.g:7670:1: rule__FunctionCall__Group__3__Impl : ( ( rule__FunctionCall__Group_3__0 )? ) ;
    public final void rule__FunctionCall__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7674:1: ( ( ( rule__FunctionCall__Group_3__0 )? ) )
            // InternalExprParser.g:7675:1: ( ( rule__FunctionCall__Group_3__0 )? )
            {
            // InternalExprParser.g:7675:1: ( ( rule__FunctionCall__Group_3__0 )? )
            // InternalExprParser.g:7676:1: ( rule__FunctionCall__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionCallAccess().getGroup_3()); 
            }
            // InternalExprParser.g:7677:1: ( rule__FunctionCall__Group_3__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==Record||LA38_0==False||(LA38_0>=Tuple && LA38_0<=Union)||LA38_0==List||(LA38_0>=This && LA38_0<=True)||LA38_0==Bag||LA38_0==Map||(LA38_0>=Not && LA38_0<=Set)||LA38_0==If||LA38_0==NumberSign||LA38_0==LeftParenthesis||LA38_0==PlusSign||LA38_0==HyphenMinus||LA38_0==LeftSquareBracket||LA38_0==RULE_REAL_LIT||LA38_0==RULE_INTEGER_LIT||(LA38_0>=RULE_STRING && LA38_0<=RULE_ID)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalExprParser.g:7677:2: rule__FunctionCall__Group_3__0
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
    // InternalExprParser.g:7687:1: rule__FunctionCall__Group__4 : rule__FunctionCall__Group__4__Impl ;
    public final void rule__FunctionCall__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7691:1: ( rule__FunctionCall__Group__4__Impl )
            // InternalExprParser.g:7692:2: rule__FunctionCall__Group__4__Impl
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
    // InternalExprParser.g:7698:1: rule__FunctionCall__Group__4__Impl : ( RightParenthesis ) ;
    public final void rule__FunctionCall__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7702:1: ( ( RightParenthesis ) )
            // InternalExprParser.g:7703:1: ( RightParenthesis )
            {
            // InternalExprParser.g:7703:1: ( RightParenthesis )
            // InternalExprParser.g:7704:1: RightParenthesis
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
    // InternalExprParser.g:7727:1: rule__FunctionCall__Group_3__0 : rule__FunctionCall__Group_3__0__Impl rule__FunctionCall__Group_3__1 ;
    public final void rule__FunctionCall__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7731:1: ( rule__FunctionCall__Group_3__0__Impl rule__FunctionCall__Group_3__1 )
            // InternalExprParser.g:7732:2: rule__FunctionCall__Group_3__0__Impl rule__FunctionCall__Group_3__1
            {
            pushFollow(FOLLOW_53);
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
    // InternalExprParser.g:7739:1: rule__FunctionCall__Group_3__0__Impl : ( ( rule__FunctionCall__ArgumentsAssignment_3_0 ) ) ;
    public final void rule__FunctionCall__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7743:1: ( ( ( rule__FunctionCall__ArgumentsAssignment_3_0 ) ) )
            // InternalExprParser.g:7744:1: ( ( rule__FunctionCall__ArgumentsAssignment_3_0 ) )
            {
            // InternalExprParser.g:7744:1: ( ( rule__FunctionCall__ArgumentsAssignment_3_0 ) )
            // InternalExprParser.g:7745:1: ( rule__FunctionCall__ArgumentsAssignment_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionCallAccess().getArgumentsAssignment_3_0()); 
            }
            // InternalExprParser.g:7746:1: ( rule__FunctionCall__ArgumentsAssignment_3_0 )
            // InternalExprParser.g:7746:2: rule__FunctionCall__ArgumentsAssignment_3_0
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
    // InternalExprParser.g:7756:1: rule__FunctionCall__Group_3__1 : rule__FunctionCall__Group_3__1__Impl ;
    public final void rule__FunctionCall__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7760:1: ( rule__FunctionCall__Group_3__1__Impl )
            // InternalExprParser.g:7761:2: rule__FunctionCall__Group_3__1__Impl
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
    // InternalExprParser.g:7767:1: rule__FunctionCall__Group_3__1__Impl : ( ( rule__FunctionCall__Group_3_1__0 )* ) ;
    public final void rule__FunctionCall__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7771:1: ( ( ( rule__FunctionCall__Group_3_1__0 )* ) )
            // InternalExprParser.g:7772:1: ( ( rule__FunctionCall__Group_3_1__0 )* )
            {
            // InternalExprParser.g:7772:1: ( ( rule__FunctionCall__Group_3_1__0 )* )
            // InternalExprParser.g:7773:1: ( rule__FunctionCall__Group_3_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionCallAccess().getGroup_3_1()); 
            }
            // InternalExprParser.g:7774:1: ( rule__FunctionCall__Group_3_1__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==Comma) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalExprParser.g:7774:2: rule__FunctionCall__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_54);
            	    rule__FunctionCall__Group_3_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop39;
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
    // InternalExprParser.g:7788:1: rule__FunctionCall__Group_3_1__0 : rule__FunctionCall__Group_3_1__0__Impl rule__FunctionCall__Group_3_1__1 ;
    public final void rule__FunctionCall__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7792:1: ( rule__FunctionCall__Group_3_1__0__Impl rule__FunctionCall__Group_3_1__1 )
            // InternalExprParser.g:7793:2: rule__FunctionCall__Group_3_1__0__Impl rule__FunctionCall__Group_3_1__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalExprParser.g:7800:1: rule__FunctionCall__Group_3_1__0__Impl : ( Comma ) ;
    public final void rule__FunctionCall__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7804:1: ( ( Comma ) )
            // InternalExprParser.g:7805:1: ( Comma )
            {
            // InternalExprParser.g:7805:1: ( Comma )
            // InternalExprParser.g:7806:1: Comma
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
    // InternalExprParser.g:7819:1: rule__FunctionCall__Group_3_1__1 : rule__FunctionCall__Group_3_1__1__Impl ;
    public final void rule__FunctionCall__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7823:1: ( rule__FunctionCall__Group_3_1__1__Impl )
            // InternalExprParser.g:7824:2: rule__FunctionCall__Group_3_1__1__Impl
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
    // InternalExprParser.g:7830:1: rule__FunctionCall__Group_3_1__1__Impl : ( ( rule__FunctionCall__ArgumentsAssignment_3_1_1 ) ) ;
    public final void rule__FunctionCall__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7834:1: ( ( ( rule__FunctionCall__ArgumentsAssignment_3_1_1 ) ) )
            // InternalExprParser.g:7835:1: ( ( rule__FunctionCall__ArgumentsAssignment_3_1_1 ) )
            {
            // InternalExprParser.g:7835:1: ( ( rule__FunctionCall__ArgumentsAssignment_3_1_1 ) )
            // InternalExprParser.g:7836:1: ( rule__FunctionCall__ArgumentsAssignment_3_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunctionCallAccess().getArgumentsAssignment_3_1_1()); 
            }
            // InternalExprParser.g:7837:1: ( rule__FunctionCall__ArgumentsAssignment_3_1_1 )
            // InternalExprParser.g:7837:2: rule__FunctionCall__ArgumentsAssignment_3_1_1
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
    // InternalExprParser.g:7851:1: rule__RangeExpression__Group__0 : rule__RangeExpression__Group__0__Impl rule__RangeExpression__Group__1 ;
    public final void rule__RangeExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7855:1: ( rule__RangeExpression__Group__0__Impl rule__RangeExpression__Group__1 )
            // InternalExprParser.g:7856:2: rule__RangeExpression__Group__0__Impl rule__RangeExpression__Group__1
            {
            pushFollow(FOLLOW_55);
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
    // InternalExprParser.g:7863:1: rule__RangeExpression__Group__0__Impl : ( () ) ;
    public final void rule__RangeExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7867:1: ( ( () ) )
            // InternalExprParser.g:7868:1: ( () )
            {
            // InternalExprParser.g:7868:1: ( () )
            // InternalExprParser.g:7869:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeExpressionAccess().getRangeAction_0()); 
            }
            // InternalExprParser.g:7870:1: ()
            // InternalExprParser.g:7872:1: 
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
    // InternalExprParser.g:7882:1: rule__RangeExpression__Group__1 : rule__RangeExpression__Group__1__Impl rule__RangeExpression__Group__2 ;
    public final void rule__RangeExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7886:1: ( rule__RangeExpression__Group__1__Impl rule__RangeExpression__Group__2 )
            // InternalExprParser.g:7887:2: rule__RangeExpression__Group__1__Impl rule__RangeExpression__Group__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalExprParser.g:7894:1: rule__RangeExpression__Group__1__Impl : ( LeftSquareBracket ) ;
    public final void rule__RangeExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7898:1: ( ( LeftSquareBracket ) )
            // InternalExprParser.g:7899:1: ( LeftSquareBracket )
            {
            // InternalExprParser.g:7899:1: ( LeftSquareBracket )
            // InternalExprParser.g:7900:1: LeftSquareBracket
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
    // InternalExprParser.g:7913:1: rule__RangeExpression__Group__2 : rule__RangeExpression__Group__2__Impl rule__RangeExpression__Group__3 ;
    public final void rule__RangeExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7917:1: ( rule__RangeExpression__Group__2__Impl rule__RangeExpression__Group__3 )
            // InternalExprParser.g:7918:2: rule__RangeExpression__Group__2__Impl rule__RangeExpression__Group__3
            {
            pushFollow(FOLLOW_56);
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
    // InternalExprParser.g:7925:1: rule__RangeExpression__Group__2__Impl : ( ( rule__RangeExpression__MinimumAssignment_2 ) ) ;
    public final void rule__RangeExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7929:1: ( ( ( rule__RangeExpression__MinimumAssignment_2 ) ) )
            // InternalExprParser.g:7930:1: ( ( rule__RangeExpression__MinimumAssignment_2 ) )
            {
            // InternalExprParser.g:7930:1: ( ( rule__RangeExpression__MinimumAssignment_2 ) )
            // InternalExprParser.g:7931:1: ( rule__RangeExpression__MinimumAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeExpressionAccess().getMinimumAssignment_2()); 
            }
            // InternalExprParser.g:7932:1: ( rule__RangeExpression__MinimumAssignment_2 )
            // InternalExprParser.g:7932:2: rule__RangeExpression__MinimumAssignment_2
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
    // InternalExprParser.g:7942:1: rule__RangeExpression__Group__3 : rule__RangeExpression__Group__3__Impl rule__RangeExpression__Group__4 ;
    public final void rule__RangeExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7946:1: ( rule__RangeExpression__Group__3__Impl rule__RangeExpression__Group__4 )
            // InternalExprParser.g:7947:2: rule__RangeExpression__Group__3__Impl rule__RangeExpression__Group__4
            {
            pushFollow(FOLLOW_10);
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
    // InternalExprParser.g:7954:1: rule__RangeExpression__Group__3__Impl : ( FullStopFullStop ) ;
    public final void rule__RangeExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7958:1: ( ( FullStopFullStop ) )
            // InternalExprParser.g:7959:1: ( FullStopFullStop )
            {
            // InternalExprParser.g:7959:1: ( FullStopFullStop )
            // InternalExprParser.g:7960:1: FullStopFullStop
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
    // InternalExprParser.g:7973:1: rule__RangeExpression__Group__4 : rule__RangeExpression__Group__4__Impl rule__RangeExpression__Group__5 ;
    public final void rule__RangeExpression__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7977:1: ( rule__RangeExpression__Group__4__Impl rule__RangeExpression__Group__5 )
            // InternalExprParser.g:7978:2: rule__RangeExpression__Group__4__Impl rule__RangeExpression__Group__5
            {
            pushFollow(FOLLOW_57);
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
    // InternalExprParser.g:7985:1: rule__RangeExpression__Group__4__Impl : ( ( rule__RangeExpression__MaximumAssignment_4 ) ) ;
    public final void rule__RangeExpression__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:7989:1: ( ( ( rule__RangeExpression__MaximumAssignment_4 ) ) )
            // InternalExprParser.g:7990:1: ( ( rule__RangeExpression__MaximumAssignment_4 ) )
            {
            // InternalExprParser.g:7990:1: ( ( rule__RangeExpression__MaximumAssignment_4 ) )
            // InternalExprParser.g:7991:1: ( rule__RangeExpression__MaximumAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeExpressionAccess().getMaximumAssignment_4()); 
            }
            // InternalExprParser.g:7992:1: ( rule__RangeExpression__MaximumAssignment_4 )
            // InternalExprParser.g:7992:2: rule__RangeExpression__MaximumAssignment_4
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
    // InternalExprParser.g:8002:1: rule__RangeExpression__Group__5 : rule__RangeExpression__Group__5__Impl rule__RangeExpression__Group__6 ;
    public final void rule__RangeExpression__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8006:1: ( rule__RangeExpression__Group__5__Impl rule__RangeExpression__Group__6 )
            // InternalExprParser.g:8007:2: rule__RangeExpression__Group__5__Impl rule__RangeExpression__Group__6
            {
            pushFollow(FOLLOW_57);
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
    // InternalExprParser.g:8014:1: rule__RangeExpression__Group__5__Impl : ( ( rule__RangeExpression__Group_5__0 )? ) ;
    public final void rule__RangeExpression__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8018:1: ( ( ( rule__RangeExpression__Group_5__0 )? ) )
            // InternalExprParser.g:8019:1: ( ( rule__RangeExpression__Group_5__0 )? )
            {
            // InternalExprParser.g:8019:1: ( ( rule__RangeExpression__Group_5__0 )? )
            // InternalExprParser.g:8020:1: ( rule__RangeExpression__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeExpressionAccess().getGroup_5()); 
            }
            // InternalExprParser.g:8021:1: ( rule__RangeExpression__Group_5__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==Delta) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalExprParser.g:8021:2: rule__RangeExpression__Group_5__0
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
    // InternalExprParser.g:8031:1: rule__RangeExpression__Group__6 : rule__RangeExpression__Group__6__Impl ;
    public final void rule__RangeExpression__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8035:1: ( rule__RangeExpression__Group__6__Impl )
            // InternalExprParser.g:8036:2: rule__RangeExpression__Group__6__Impl
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
    // InternalExprParser.g:8042:1: rule__RangeExpression__Group__6__Impl : ( RightSquareBracket ) ;
    public final void rule__RangeExpression__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8046:1: ( ( RightSquareBracket ) )
            // InternalExprParser.g:8047:1: ( RightSquareBracket )
            {
            // InternalExprParser.g:8047:1: ( RightSquareBracket )
            // InternalExprParser.g:8048:1: RightSquareBracket
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
    // InternalExprParser.g:8075:1: rule__RangeExpression__Group_5__0 : rule__RangeExpression__Group_5__0__Impl rule__RangeExpression__Group_5__1 ;
    public final void rule__RangeExpression__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8079:1: ( rule__RangeExpression__Group_5__0__Impl rule__RangeExpression__Group_5__1 )
            // InternalExprParser.g:8080:2: rule__RangeExpression__Group_5__0__Impl rule__RangeExpression__Group_5__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalExprParser.g:8087:1: rule__RangeExpression__Group_5__0__Impl : ( ( Delta ) ) ;
    public final void rule__RangeExpression__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8091:1: ( ( ( Delta ) ) )
            // InternalExprParser.g:8092:1: ( ( Delta ) )
            {
            // InternalExprParser.g:8092:1: ( ( Delta ) )
            // InternalExprParser.g:8093:1: ( Delta )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeExpressionAccess().getDeltaKeyword_5_0()); 
            }
            // InternalExprParser.g:8094:1: ( Delta )
            // InternalExprParser.g:8095:2: Delta
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
    // InternalExprParser.g:8106:1: rule__RangeExpression__Group_5__1 : rule__RangeExpression__Group_5__1__Impl ;
    public final void rule__RangeExpression__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8110:1: ( rule__RangeExpression__Group_5__1__Impl )
            // InternalExprParser.g:8111:2: rule__RangeExpression__Group_5__1__Impl
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
    // InternalExprParser.g:8117:1: rule__RangeExpression__Group_5__1__Impl : ( ( rule__RangeExpression__DeltaAssignment_5_1 ) ) ;
    public final void rule__RangeExpression__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8121:1: ( ( ( rule__RangeExpression__DeltaAssignment_5_1 ) ) )
            // InternalExprParser.g:8122:1: ( ( rule__RangeExpression__DeltaAssignment_5_1 ) )
            {
            // InternalExprParser.g:8122:1: ( ( rule__RangeExpression__DeltaAssignment_5_1 ) )
            // InternalExprParser.g:8123:1: ( rule__RangeExpression__DeltaAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeExpressionAccess().getDeltaAssignment_5_1()); 
            }
            // InternalExprParser.g:8124:1: ( rule__RangeExpression__DeltaAssignment_5_1 )
            // InternalExprParser.g:8124:2: rule__RangeExpression__DeltaAssignment_5_1
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
    // InternalExprParser.g:8138:1: rule__IfExpression__Group__0 : rule__IfExpression__Group__0__Impl rule__IfExpression__Group__1 ;
    public final void rule__IfExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8142:1: ( rule__IfExpression__Group__0__Impl rule__IfExpression__Group__1 )
            // InternalExprParser.g:8143:2: rule__IfExpression__Group__0__Impl rule__IfExpression__Group__1
            {
            pushFollow(FOLLOW_58);
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
    // InternalExprParser.g:8150:1: rule__IfExpression__Group__0__Impl : ( () ) ;
    public final void rule__IfExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8154:1: ( ( () ) )
            // InternalExprParser.g:8155:1: ( () )
            {
            // InternalExprParser.g:8155:1: ( () )
            // InternalExprParser.g:8156:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfExpressionAccess().getConditionalAction_0()); 
            }
            // InternalExprParser.g:8157:1: ()
            // InternalExprParser.g:8159:1: 
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
    // InternalExprParser.g:8169:1: rule__IfExpression__Group__1 : rule__IfExpression__Group__1__Impl rule__IfExpression__Group__2 ;
    public final void rule__IfExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8173:1: ( rule__IfExpression__Group__1__Impl rule__IfExpression__Group__2 )
            // InternalExprParser.g:8174:2: rule__IfExpression__Group__1__Impl rule__IfExpression__Group__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalExprParser.g:8181:1: rule__IfExpression__Group__1__Impl : ( If ) ;
    public final void rule__IfExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8185:1: ( ( If ) )
            // InternalExprParser.g:8186:1: ( If )
            {
            // InternalExprParser.g:8186:1: ( If )
            // InternalExprParser.g:8187:1: If
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
    // InternalExprParser.g:8200:1: rule__IfExpression__Group__2 : rule__IfExpression__Group__2__Impl rule__IfExpression__Group__3 ;
    public final void rule__IfExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8204:1: ( rule__IfExpression__Group__2__Impl rule__IfExpression__Group__3 )
            // InternalExprParser.g:8205:2: rule__IfExpression__Group__2__Impl rule__IfExpression__Group__3
            {
            pushFollow(FOLLOW_59);
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
    // InternalExprParser.g:8212:1: rule__IfExpression__Group__2__Impl : ( ( rule__IfExpression__IfAssignment_2 ) ) ;
    public final void rule__IfExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8216:1: ( ( ( rule__IfExpression__IfAssignment_2 ) ) )
            // InternalExprParser.g:8217:1: ( ( rule__IfExpression__IfAssignment_2 ) )
            {
            // InternalExprParser.g:8217:1: ( ( rule__IfExpression__IfAssignment_2 ) )
            // InternalExprParser.g:8218:1: ( rule__IfExpression__IfAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfExpressionAccess().getIfAssignment_2()); 
            }
            // InternalExprParser.g:8219:1: ( rule__IfExpression__IfAssignment_2 )
            // InternalExprParser.g:8219:2: rule__IfExpression__IfAssignment_2
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
    // InternalExprParser.g:8229:1: rule__IfExpression__Group__3 : rule__IfExpression__Group__3__Impl rule__IfExpression__Group__4 ;
    public final void rule__IfExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8233:1: ( rule__IfExpression__Group__3__Impl rule__IfExpression__Group__4 )
            // InternalExprParser.g:8234:2: rule__IfExpression__Group__3__Impl rule__IfExpression__Group__4
            {
            pushFollow(FOLLOW_10);
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
    // InternalExprParser.g:8241:1: rule__IfExpression__Group__3__Impl : ( Then ) ;
    public final void rule__IfExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8245:1: ( ( Then ) )
            // InternalExprParser.g:8246:1: ( Then )
            {
            // InternalExprParser.g:8246:1: ( Then )
            // InternalExprParser.g:8247:1: Then
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
    // InternalExprParser.g:8260:1: rule__IfExpression__Group__4 : rule__IfExpression__Group__4__Impl rule__IfExpression__Group__5 ;
    public final void rule__IfExpression__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8264:1: ( rule__IfExpression__Group__4__Impl rule__IfExpression__Group__5 )
            // InternalExprParser.g:8265:2: rule__IfExpression__Group__4__Impl rule__IfExpression__Group__5
            {
            pushFollow(FOLLOW_60);
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
    // InternalExprParser.g:8272:1: rule__IfExpression__Group__4__Impl : ( ( rule__IfExpression__ThenAssignment_4 ) ) ;
    public final void rule__IfExpression__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8276:1: ( ( ( rule__IfExpression__ThenAssignment_4 ) ) )
            // InternalExprParser.g:8277:1: ( ( rule__IfExpression__ThenAssignment_4 ) )
            {
            // InternalExprParser.g:8277:1: ( ( rule__IfExpression__ThenAssignment_4 ) )
            // InternalExprParser.g:8278:1: ( rule__IfExpression__ThenAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfExpressionAccess().getThenAssignment_4()); 
            }
            // InternalExprParser.g:8279:1: ( rule__IfExpression__ThenAssignment_4 )
            // InternalExprParser.g:8279:2: rule__IfExpression__ThenAssignment_4
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
    // InternalExprParser.g:8289:1: rule__IfExpression__Group__5 : rule__IfExpression__Group__5__Impl rule__IfExpression__Group__6 ;
    public final void rule__IfExpression__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8293:1: ( rule__IfExpression__Group__5__Impl rule__IfExpression__Group__6 )
            // InternalExprParser.g:8294:2: rule__IfExpression__Group__5__Impl rule__IfExpression__Group__6
            {
            pushFollow(FOLLOW_60);
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
    // InternalExprParser.g:8301:1: rule__IfExpression__Group__5__Impl : ( ( rule__IfExpression__Group_5__0 )? ) ;
    public final void rule__IfExpression__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8305:1: ( ( ( rule__IfExpression__Group_5__0 )? ) )
            // InternalExprParser.g:8306:1: ( ( rule__IfExpression__Group_5__0 )? )
            {
            // InternalExprParser.g:8306:1: ( ( rule__IfExpression__Group_5__0 )? )
            // InternalExprParser.g:8307:1: ( rule__IfExpression__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfExpressionAccess().getGroup_5()); 
            }
            // InternalExprParser.g:8308:1: ( rule__IfExpression__Group_5__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==Else) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalExprParser.g:8308:2: rule__IfExpression__Group_5__0
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
    // InternalExprParser.g:8318:1: rule__IfExpression__Group__6 : rule__IfExpression__Group__6__Impl ;
    public final void rule__IfExpression__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8322:1: ( rule__IfExpression__Group__6__Impl )
            // InternalExprParser.g:8323:2: rule__IfExpression__Group__6__Impl
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
    // InternalExprParser.g:8329:1: rule__IfExpression__Group__6__Impl : ( Endif ) ;
    public final void rule__IfExpression__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8333:1: ( ( Endif ) )
            // InternalExprParser.g:8334:1: ( Endif )
            {
            // InternalExprParser.g:8334:1: ( Endif )
            // InternalExprParser.g:8335:1: Endif
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
    // InternalExprParser.g:8362:1: rule__IfExpression__Group_5__0 : rule__IfExpression__Group_5__0__Impl rule__IfExpression__Group_5__1 ;
    public final void rule__IfExpression__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8366:1: ( rule__IfExpression__Group_5__0__Impl rule__IfExpression__Group_5__1 )
            // InternalExprParser.g:8367:2: rule__IfExpression__Group_5__0__Impl rule__IfExpression__Group_5__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalExprParser.g:8374:1: rule__IfExpression__Group_5__0__Impl : ( Else ) ;
    public final void rule__IfExpression__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8378:1: ( ( Else ) )
            // InternalExprParser.g:8379:1: ( Else )
            {
            // InternalExprParser.g:8379:1: ( Else )
            // InternalExprParser.g:8380:1: Else
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
    // InternalExprParser.g:8393:1: rule__IfExpression__Group_5__1 : rule__IfExpression__Group_5__1__Impl ;
    public final void rule__IfExpression__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8397:1: ( rule__IfExpression__Group_5__1__Impl )
            // InternalExprParser.g:8398:2: rule__IfExpression__Group_5__1__Impl
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
    // InternalExprParser.g:8404:1: rule__IfExpression__Group_5__1__Impl : ( ( rule__IfExpression__ElseAssignment_5_1 ) ) ;
    public final void rule__IfExpression__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8408:1: ( ( ( rule__IfExpression__ElseAssignment_5_1 ) ) )
            // InternalExprParser.g:8409:1: ( ( rule__IfExpression__ElseAssignment_5_1 ) )
            {
            // InternalExprParser.g:8409:1: ( ( rule__IfExpression__ElseAssignment_5_1 ) )
            // InternalExprParser.g:8410:1: ( rule__IfExpression__ElseAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIfExpressionAccess().getElseAssignment_5_1()); 
            }
            // InternalExprParser.g:8411:1: ( rule__IfExpression__ElseAssignment_5_1 )
            // InternalExprParser.g:8411:2: rule__IfExpression__ElseAssignment_5_1
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
    // InternalExprParser.g:8425:1: rule__BooleanLiteral__Group__0 : rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 ;
    public final void rule__BooleanLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8429:1: ( rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 )
            // InternalExprParser.g:8430:2: rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1
            {
            pushFollow(FOLLOW_61);
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
    // InternalExprParser.g:8437:1: rule__BooleanLiteral__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8441:1: ( ( () ) )
            // InternalExprParser.g:8442:1: ( () )
            {
            // InternalExprParser.g:8442:1: ( () )
            // InternalExprParser.g:8443:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); 
            }
            // InternalExprParser.g:8444:1: ()
            // InternalExprParser.g:8446:1: 
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
    // InternalExprParser.g:8456:1: rule__BooleanLiteral__Group__1 : rule__BooleanLiteral__Group__1__Impl ;
    public final void rule__BooleanLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8460:1: ( rule__BooleanLiteral__Group__1__Impl )
            // InternalExprParser.g:8461:2: rule__BooleanLiteral__Group__1__Impl
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
    // InternalExprParser.g:8467:1: rule__BooleanLiteral__Group__1__Impl : ( ( rule__BooleanLiteral__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8471:1: ( ( ( rule__BooleanLiteral__Alternatives_1 ) ) )
            // InternalExprParser.g:8472:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            {
            // InternalExprParser.g:8472:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            // InternalExprParser.g:8473:1: ( rule__BooleanLiteral__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); 
            }
            // InternalExprParser.g:8474:1: ( rule__BooleanLiteral__Alternatives_1 )
            // InternalExprParser.g:8474:2: rule__BooleanLiteral__Alternatives_1
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
    // InternalExprParser.g:8488:1: rule__IntegerLiteral__Group__0 : rule__IntegerLiteral__Group__0__Impl rule__IntegerLiteral__Group__1 ;
    public final void rule__IntegerLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8492:1: ( rule__IntegerLiteral__Group__0__Impl rule__IntegerLiteral__Group__1 )
            // InternalExprParser.g:8493:2: rule__IntegerLiteral__Group__0__Impl rule__IntegerLiteral__Group__1
            {
            pushFollow(FOLLOW_62);
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
    // InternalExprParser.g:8500:1: rule__IntegerLiteral__Group__0__Impl : ( () ) ;
    public final void rule__IntegerLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8504:1: ( ( () ) )
            // InternalExprParser.g:8505:1: ( () )
            {
            // InternalExprParser.g:8505:1: ( () )
            // InternalExprParser.g:8506:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralAccess().getIntegerLiteralAction_0()); 
            }
            // InternalExprParser.g:8507:1: ()
            // InternalExprParser.g:8509:1: 
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
    // InternalExprParser.g:8519:1: rule__IntegerLiteral__Group__1 : rule__IntegerLiteral__Group__1__Impl ;
    public final void rule__IntegerLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8523:1: ( rule__IntegerLiteral__Group__1__Impl )
            // InternalExprParser.g:8524:2: rule__IntegerLiteral__Group__1__Impl
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
    // InternalExprParser.g:8530:1: rule__IntegerLiteral__Group__1__Impl : ( ( rule__IntegerLiteral__ValueAssignment_1 ) ) ;
    public final void rule__IntegerLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8534:1: ( ( ( rule__IntegerLiteral__ValueAssignment_1 ) ) )
            // InternalExprParser.g:8535:1: ( ( rule__IntegerLiteral__ValueAssignment_1 ) )
            {
            // InternalExprParser.g:8535:1: ( ( rule__IntegerLiteral__ValueAssignment_1 ) )
            // InternalExprParser.g:8536:1: ( rule__IntegerLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntegerLiteralAccess().getValueAssignment_1()); 
            }
            // InternalExprParser.g:8537:1: ( rule__IntegerLiteral__ValueAssignment_1 )
            // InternalExprParser.g:8537:2: rule__IntegerLiteral__ValueAssignment_1
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
    // InternalExprParser.g:8551:1: rule__RealLiteral__Group__0 : rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 ;
    public final void rule__RealLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8555:1: ( rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 )
            // InternalExprParser.g:8556:2: rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1
            {
            pushFollow(FOLLOW_63);
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
    // InternalExprParser.g:8563:1: rule__RealLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RealLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8567:1: ( ( () ) )
            // InternalExprParser.g:8568:1: ( () )
            {
            // InternalExprParser.g:8568:1: ( () )
            // InternalExprParser.g:8569:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 
            }
            // InternalExprParser.g:8570:1: ()
            // InternalExprParser.g:8572:1: 
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
    // InternalExprParser.g:8582:1: rule__RealLiteral__Group__1 : rule__RealLiteral__Group__1__Impl ;
    public final void rule__RealLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8586:1: ( rule__RealLiteral__Group__1__Impl )
            // InternalExprParser.g:8587:2: rule__RealLiteral__Group__1__Impl
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
    // InternalExprParser.g:8593:1: rule__RealLiteral__Group__1__Impl : ( ( rule__RealLiteral__ValueAssignment_1 ) ) ;
    public final void rule__RealLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8597:1: ( ( ( rule__RealLiteral__ValueAssignment_1 ) ) )
            // InternalExprParser.g:8598:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            {
            // InternalExprParser.g:8598:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            // InternalExprParser.g:8599:1: ( rule__RealLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 
            }
            // InternalExprParser.g:8600:1: ( rule__RealLiteral__ValueAssignment_1 )
            // InternalExprParser.g:8600:2: rule__RealLiteral__ValueAssignment_1
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
    // InternalExprParser.g:8614:1: rule__StringLiteral__Group__0 : rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 ;
    public final void rule__StringLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8618:1: ( rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 )
            // InternalExprParser.g:8619:2: rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1
            {
            pushFollow(FOLLOW_64);
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
    // InternalExprParser.g:8626:1: rule__StringLiteral__Group__0__Impl : ( () ) ;
    public final void rule__StringLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8630:1: ( ( () ) )
            // InternalExprParser.g:8631:1: ( () )
            {
            // InternalExprParser.g:8631:1: ( () )
            // InternalExprParser.g:8632:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            }
            // InternalExprParser.g:8633:1: ()
            // InternalExprParser.g:8635:1: 
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
    // InternalExprParser.g:8645:1: rule__StringLiteral__Group__1 : rule__StringLiteral__Group__1__Impl ;
    public final void rule__StringLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8649:1: ( rule__StringLiteral__Group__1__Impl )
            // InternalExprParser.g:8650:2: rule__StringLiteral__Group__1__Impl
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
    // InternalExprParser.g:8656:1: rule__StringLiteral__Group__1__Impl : ( ( rule__StringLiteral__ValueAssignment_1 ) ) ;
    public final void rule__StringLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8660:1: ( ( ( rule__StringLiteral__ValueAssignment_1 ) ) )
            // InternalExprParser.g:8661:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            {
            // InternalExprParser.g:8661:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            // InternalExprParser.g:8662:1: ( rule__StringLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            }
            // InternalExprParser.g:8663:1: ( rule__StringLiteral__ValueAssignment_1 )
            // InternalExprParser.g:8663:2: rule__StringLiteral__ValueAssignment_1
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
    // InternalExprParser.g:8677:1: rule__CommaSeparatedExpressions__Group__0 : rule__CommaSeparatedExpressions__Group__0__Impl rule__CommaSeparatedExpressions__Group__1 ;
    public final void rule__CommaSeparatedExpressions__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8681:1: ( rule__CommaSeparatedExpressions__Group__0__Impl rule__CommaSeparatedExpressions__Group__1 )
            // InternalExprParser.g:8682:2: rule__CommaSeparatedExpressions__Group__0__Impl rule__CommaSeparatedExpressions__Group__1
            {
            pushFollow(FOLLOW_53);
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
    // InternalExprParser.g:8689:1: rule__CommaSeparatedExpressions__Group__0__Impl : ( ( rule__CommaSeparatedExpressions__ElementsAssignment_0 ) ) ;
    public final void rule__CommaSeparatedExpressions__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8693:1: ( ( ( rule__CommaSeparatedExpressions__ElementsAssignment_0 ) ) )
            // InternalExprParser.g:8694:1: ( ( rule__CommaSeparatedExpressions__ElementsAssignment_0 ) )
            {
            // InternalExprParser.g:8694:1: ( ( rule__CommaSeparatedExpressions__ElementsAssignment_0 ) )
            // InternalExprParser.g:8695:1: ( rule__CommaSeparatedExpressions__ElementsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCommaSeparatedExpressionsAccess().getElementsAssignment_0()); 
            }
            // InternalExprParser.g:8696:1: ( rule__CommaSeparatedExpressions__ElementsAssignment_0 )
            // InternalExprParser.g:8696:2: rule__CommaSeparatedExpressions__ElementsAssignment_0
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
    // InternalExprParser.g:8706:1: rule__CommaSeparatedExpressions__Group__1 : rule__CommaSeparatedExpressions__Group__1__Impl ;
    public final void rule__CommaSeparatedExpressions__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8710:1: ( rule__CommaSeparatedExpressions__Group__1__Impl )
            // InternalExprParser.g:8711:2: rule__CommaSeparatedExpressions__Group__1__Impl
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
    // InternalExprParser.g:8717:1: rule__CommaSeparatedExpressions__Group__1__Impl : ( ( rule__CommaSeparatedExpressions__Group_1__0 )* ) ;
    public final void rule__CommaSeparatedExpressions__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8721:1: ( ( ( rule__CommaSeparatedExpressions__Group_1__0 )* ) )
            // InternalExprParser.g:8722:1: ( ( rule__CommaSeparatedExpressions__Group_1__0 )* )
            {
            // InternalExprParser.g:8722:1: ( ( rule__CommaSeparatedExpressions__Group_1__0 )* )
            // InternalExprParser.g:8723:1: ( rule__CommaSeparatedExpressions__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCommaSeparatedExpressionsAccess().getGroup_1()); 
            }
            // InternalExprParser.g:8724:1: ( rule__CommaSeparatedExpressions__Group_1__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==Comma) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalExprParser.g:8724:2: rule__CommaSeparatedExpressions__Group_1__0
            	    {
            	    pushFollow(FOLLOW_54);
            	    rule__CommaSeparatedExpressions__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop42;
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
    // InternalExprParser.g:8738:1: rule__CommaSeparatedExpressions__Group_1__0 : rule__CommaSeparatedExpressions__Group_1__0__Impl rule__CommaSeparatedExpressions__Group_1__1 ;
    public final void rule__CommaSeparatedExpressions__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8742:1: ( rule__CommaSeparatedExpressions__Group_1__0__Impl rule__CommaSeparatedExpressions__Group_1__1 )
            // InternalExprParser.g:8743:2: rule__CommaSeparatedExpressions__Group_1__0__Impl rule__CommaSeparatedExpressions__Group_1__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalExprParser.g:8750:1: rule__CommaSeparatedExpressions__Group_1__0__Impl : ( Comma ) ;
    public final void rule__CommaSeparatedExpressions__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8754:1: ( ( Comma ) )
            // InternalExprParser.g:8755:1: ( Comma )
            {
            // InternalExprParser.g:8755:1: ( Comma )
            // InternalExprParser.g:8756:1: Comma
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
    // InternalExprParser.g:8769:1: rule__CommaSeparatedExpressions__Group_1__1 : rule__CommaSeparatedExpressions__Group_1__1__Impl ;
    public final void rule__CommaSeparatedExpressions__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8773:1: ( rule__CommaSeparatedExpressions__Group_1__1__Impl )
            // InternalExprParser.g:8774:2: rule__CommaSeparatedExpressions__Group_1__1__Impl
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
    // InternalExprParser.g:8780:1: rule__CommaSeparatedExpressions__Group_1__1__Impl : ( ( rule__CommaSeparatedExpressions__ElementsAssignment_1_1 ) ) ;
    public final void rule__CommaSeparatedExpressions__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8784:1: ( ( ( rule__CommaSeparatedExpressions__ElementsAssignment_1_1 ) ) )
            // InternalExprParser.g:8785:1: ( ( rule__CommaSeparatedExpressions__ElementsAssignment_1_1 ) )
            {
            // InternalExprParser.g:8785:1: ( ( rule__CommaSeparatedExpressions__ElementsAssignment_1_1 ) )
            // InternalExprParser.g:8786:1: ( rule__CommaSeparatedExpressions__ElementsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCommaSeparatedExpressionsAccess().getElementsAssignment_1_1()); 
            }
            // InternalExprParser.g:8787:1: ( rule__CommaSeparatedExpressions__ElementsAssignment_1_1 )
            // InternalExprParser.g:8787:2: rule__CommaSeparatedExpressions__ElementsAssignment_1_1
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
    // InternalExprParser.g:8801:1: rule__ListLiteral__Group__0 : rule__ListLiteral__Group__0__Impl rule__ListLiteral__Group__1 ;
    public final void rule__ListLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8805:1: ( rule__ListLiteral__Group__0__Impl rule__ListLiteral__Group__1 )
            // InternalExprParser.g:8806:2: rule__ListLiteral__Group__0__Impl rule__ListLiteral__Group__1
            {
            pushFollow(FOLLOW_31);
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
    // InternalExprParser.g:8813:1: rule__ListLiteral__Group__0__Impl : ( () ) ;
    public final void rule__ListLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8817:1: ( ( () ) )
            // InternalExprParser.g:8818:1: ( () )
            {
            // InternalExprParser.g:8818:1: ( () )
            // InternalExprParser.g:8819:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListLiteralAccess().getListLiteralAction_0()); 
            }
            // InternalExprParser.g:8820:1: ()
            // InternalExprParser.g:8822:1: 
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
    // InternalExprParser.g:8832:1: rule__ListLiteral__Group__1 : rule__ListLiteral__Group__1__Impl rule__ListLiteral__Group__2 ;
    public final void rule__ListLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8836:1: ( rule__ListLiteral__Group__1__Impl rule__ListLiteral__Group__2 )
            // InternalExprParser.g:8837:2: rule__ListLiteral__Group__1__Impl rule__ListLiteral__Group__2
            {
            pushFollow(FOLLOW_11);
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
    // InternalExprParser.g:8844:1: rule__ListLiteral__Group__1__Impl : ( List ) ;
    public final void rule__ListLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8848:1: ( ( List ) )
            // InternalExprParser.g:8849:1: ( List )
            {
            // InternalExprParser.g:8849:1: ( List )
            // InternalExprParser.g:8850:1: List
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
    // InternalExprParser.g:8863:1: rule__ListLiteral__Group__2 : rule__ListLiteral__Group__2__Impl rule__ListLiteral__Group__3 ;
    public final void rule__ListLiteral__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8867:1: ( rule__ListLiteral__Group__2__Impl rule__ListLiteral__Group__3 )
            // InternalExprParser.g:8868:2: rule__ListLiteral__Group__2__Impl rule__ListLiteral__Group__3
            {
            pushFollow(FOLLOW_52);
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
    // InternalExprParser.g:8875:1: rule__ListLiteral__Group__2__Impl : ( LeftParenthesis ) ;
    public final void rule__ListLiteral__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8879:1: ( ( LeftParenthesis ) )
            // InternalExprParser.g:8880:1: ( LeftParenthesis )
            {
            // InternalExprParser.g:8880:1: ( LeftParenthesis )
            // InternalExprParser.g:8881:1: LeftParenthesis
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
    // InternalExprParser.g:8894:1: rule__ListLiteral__Group__3 : rule__ListLiteral__Group__3__Impl rule__ListLiteral__Group__4 ;
    public final void rule__ListLiteral__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8898:1: ( rule__ListLiteral__Group__3__Impl rule__ListLiteral__Group__4 )
            // InternalExprParser.g:8899:2: rule__ListLiteral__Group__3__Impl rule__ListLiteral__Group__4
            {
            pushFollow(FOLLOW_52);
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
    // InternalExprParser.g:8906:1: rule__ListLiteral__Group__3__Impl : ( ( ruleCommaSeparatedExpressions )? ) ;
    public final void rule__ListLiteral__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8910:1: ( ( ( ruleCommaSeparatedExpressions )? ) )
            // InternalExprParser.g:8911:1: ( ( ruleCommaSeparatedExpressions )? )
            {
            // InternalExprParser.g:8911:1: ( ( ruleCommaSeparatedExpressions )? )
            // InternalExprParser.g:8912:1: ( ruleCommaSeparatedExpressions )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getListLiteralAccess().getCommaSeparatedExpressionsParserRuleCall_3()); 
            }
            // InternalExprParser.g:8913:1: ( ruleCommaSeparatedExpressions )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==Record||LA43_0==False||(LA43_0>=Tuple && LA43_0<=Union)||LA43_0==List||(LA43_0>=This && LA43_0<=True)||LA43_0==Bag||LA43_0==Map||(LA43_0>=Not && LA43_0<=Set)||LA43_0==If||LA43_0==NumberSign||LA43_0==LeftParenthesis||LA43_0==PlusSign||LA43_0==HyphenMinus||LA43_0==LeftSquareBracket||LA43_0==RULE_REAL_LIT||LA43_0==RULE_INTEGER_LIT||(LA43_0>=RULE_STRING && LA43_0<=RULE_ID)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalExprParser.g:8913:3: ruleCommaSeparatedExpressions
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
    // InternalExprParser.g:8923:1: rule__ListLiteral__Group__4 : rule__ListLiteral__Group__4__Impl ;
    public final void rule__ListLiteral__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8927:1: ( rule__ListLiteral__Group__4__Impl )
            // InternalExprParser.g:8928:2: rule__ListLiteral__Group__4__Impl
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
    // InternalExprParser.g:8934:1: rule__ListLiteral__Group__4__Impl : ( RightParenthesis ) ;
    public final void rule__ListLiteral__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8938:1: ( ( RightParenthesis ) )
            // InternalExprParser.g:8939:1: ( RightParenthesis )
            {
            // InternalExprParser.g:8939:1: ( RightParenthesis )
            // InternalExprParser.g:8940:1: RightParenthesis
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
    // InternalExprParser.g:8963:1: rule__SetLiteral__Group__0 : rule__SetLiteral__Group__0__Impl rule__SetLiteral__Group__1 ;
    public final void rule__SetLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8967:1: ( rule__SetLiteral__Group__0__Impl rule__SetLiteral__Group__1 )
            // InternalExprParser.g:8968:2: rule__SetLiteral__Group__0__Impl rule__SetLiteral__Group__1
            {
            pushFollow(FOLLOW_65);
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
    // InternalExprParser.g:8975:1: rule__SetLiteral__Group__0__Impl : ( () ) ;
    public final void rule__SetLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8979:1: ( ( () ) )
            // InternalExprParser.g:8980:1: ( () )
            {
            // InternalExprParser.g:8980:1: ( () )
            // InternalExprParser.g:8981:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSetLiteralAccess().getSetLiteralAction_0()); 
            }
            // InternalExprParser.g:8982:1: ()
            // InternalExprParser.g:8984:1: 
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
    // InternalExprParser.g:8994:1: rule__SetLiteral__Group__1 : rule__SetLiteral__Group__1__Impl rule__SetLiteral__Group__2 ;
    public final void rule__SetLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:8998:1: ( rule__SetLiteral__Group__1__Impl rule__SetLiteral__Group__2 )
            // InternalExprParser.g:8999:2: rule__SetLiteral__Group__1__Impl rule__SetLiteral__Group__2
            {
            pushFollow(FOLLOW_11);
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
    // InternalExprParser.g:9006:1: rule__SetLiteral__Group__1__Impl : ( Set ) ;
    public final void rule__SetLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9010:1: ( ( Set ) )
            // InternalExprParser.g:9011:1: ( Set )
            {
            // InternalExprParser.g:9011:1: ( Set )
            // InternalExprParser.g:9012:1: Set
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
    // InternalExprParser.g:9025:1: rule__SetLiteral__Group__2 : rule__SetLiteral__Group__2__Impl rule__SetLiteral__Group__3 ;
    public final void rule__SetLiteral__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9029:1: ( rule__SetLiteral__Group__2__Impl rule__SetLiteral__Group__3 )
            // InternalExprParser.g:9030:2: rule__SetLiteral__Group__2__Impl rule__SetLiteral__Group__3
            {
            pushFollow(FOLLOW_52);
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
    // InternalExprParser.g:9037:1: rule__SetLiteral__Group__2__Impl : ( LeftParenthesis ) ;
    public final void rule__SetLiteral__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9041:1: ( ( LeftParenthesis ) )
            // InternalExprParser.g:9042:1: ( LeftParenthesis )
            {
            // InternalExprParser.g:9042:1: ( LeftParenthesis )
            // InternalExprParser.g:9043:1: LeftParenthesis
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
    // InternalExprParser.g:9056:1: rule__SetLiteral__Group__3 : rule__SetLiteral__Group__3__Impl rule__SetLiteral__Group__4 ;
    public final void rule__SetLiteral__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9060:1: ( rule__SetLiteral__Group__3__Impl rule__SetLiteral__Group__4 )
            // InternalExprParser.g:9061:2: rule__SetLiteral__Group__3__Impl rule__SetLiteral__Group__4
            {
            pushFollow(FOLLOW_52);
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
    // InternalExprParser.g:9068:1: rule__SetLiteral__Group__3__Impl : ( ( ruleCommaSeparatedExpressions )? ) ;
    public final void rule__SetLiteral__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9072:1: ( ( ( ruleCommaSeparatedExpressions )? ) )
            // InternalExprParser.g:9073:1: ( ( ruleCommaSeparatedExpressions )? )
            {
            // InternalExprParser.g:9073:1: ( ( ruleCommaSeparatedExpressions )? )
            // InternalExprParser.g:9074:1: ( ruleCommaSeparatedExpressions )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSetLiteralAccess().getCommaSeparatedExpressionsParserRuleCall_3()); 
            }
            // InternalExprParser.g:9075:1: ( ruleCommaSeparatedExpressions )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==Record||LA44_0==False||(LA44_0>=Tuple && LA44_0<=Union)||LA44_0==List||(LA44_0>=This && LA44_0<=True)||LA44_0==Bag||LA44_0==Map||(LA44_0>=Not && LA44_0<=Set)||LA44_0==If||LA44_0==NumberSign||LA44_0==LeftParenthesis||LA44_0==PlusSign||LA44_0==HyphenMinus||LA44_0==LeftSquareBracket||LA44_0==RULE_REAL_LIT||LA44_0==RULE_INTEGER_LIT||(LA44_0>=RULE_STRING && LA44_0<=RULE_ID)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalExprParser.g:9075:3: ruleCommaSeparatedExpressions
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
    // InternalExprParser.g:9085:1: rule__SetLiteral__Group__4 : rule__SetLiteral__Group__4__Impl ;
    public final void rule__SetLiteral__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9089:1: ( rule__SetLiteral__Group__4__Impl )
            // InternalExprParser.g:9090:2: rule__SetLiteral__Group__4__Impl
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
    // InternalExprParser.g:9096:1: rule__SetLiteral__Group__4__Impl : ( RightParenthesis ) ;
    public final void rule__SetLiteral__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9100:1: ( ( RightParenthesis ) )
            // InternalExprParser.g:9101:1: ( RightParenthesis )
            {
            // InternalExprParser.g:9101:1: ( RightParenthesis )
            // InternalExprParser.g:9102:1: RightParenthesis
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
    // InternalExprParser.g:9125:1: rule__RecordLiteral__Group__0 : rule__RecordLiteral__Group__0__Impl rule__RecordLiteral__Group__1 ;
    public final void rule__RecordLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9129:1: ( rule__RecordLiteral__Group__0__Impl rule__RecordLiteral__Group__1 )
            // InternalExprParser.g:9130:2: rule__RecordLiteral__Group__0__Impl rule__RecordLiteral__Group__1
            {
            pushFollow(FOLLOW_21);
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
    // InternalExprParser.g:9137:1: rule__RecordLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RecordLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9141:1: ( ( () ) )
            // InternalExprParser.g:9142:1: ( () )
            {
            // InternalExprParser.g:9142:1: ( () )
            // InternalExprParser.g:9143:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecordLiteralAccess().getRecordLiteralAction_0()); 
            }
            // InternalExprParser.g:9144:1: ()
            // InternalExprParser.g:9146:1: 
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
    // InternalExprParser.g:9156:1: rule__RecordLiteral__Group__1 : rule__RecordLiteral__Group__1__Impl ;
    public final void rule__RecordLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9160:1: ( rule__RecordLiteral__Group__1__Impl )
            // InternalExprParser.g:9161:2: rule__RecordLiteral__Group__1__Impl
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
    // InternalExprParser.g:9167:1: rule__RecordLiteral__Group__1__Impl : ( Record ) ;
    public final void rule__RecordLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9171:1: ( ( Record ) )
            // InternalExprParser.g:9172:1: ( Record )
            {
            // InternalExprParser.g:9172:1: ( Record )
            // InternalExprParser.g:9173:1: Record
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
    // InternalExprParser.g:9190:1: rule__UnionLiteral__Group__0 : rule__UnionLiteral__Group__0__Impl rule__UnionLiteral__Group__1 ;
    public final void rule__UnionLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9194:1: ( rule__UnionLiteral__Group__0__Impl rule__UnionLiteral__Group__1 )
            // InternalExprParser.g:9195:2: rule__UnionLiteral__Group__0__Impl rule__UnionLiteral__Group__1
            {
            pushFollow(FOLLOW_25);
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
    // InternalExprParser.g:9202:1: rule__UnionLiteral__Group__0__Impl : ( () ) ;
    public final void rule__UnionLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9206:1: ( ( () ) )
            // InternalExprParser.g:9207:1: ( () )
            {
            // InternalExprParser.g:9207:1: ( () )
            // InternalExprParser.g:9208:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnionLiteralAccess().getUnionLiteralAction_0()); 
            }
            // InternalExprParser.g:9209:1: ()
            // InternalExprParser.g:9211:1: 
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
    // InternalExprParser.g:9221:1: rule__UnionLiteral__Group__1 : rule__UnionLiteral__Group__1__Impl ;
    public final void rule__UnionLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9225:1: ( rule__UnionLiteral__Group__1__Impl )
            // InternalExprParser.g:9226:2: rule__UnionLiteral__Group__1__Impl
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
    // InternalExprParser.g:9232:1: rule__UnionLiteral__Group__1__Impl : ( Union ) ;
    public final void rule__UnionLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9236:1: ( ( Union ) )
            // InternalExprParser.g:9237:1: ( Union )
            {
            // InternalExprParser.g:9237:1: ( Union )
            // InternalExprParser.g:9238:1: Union
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
    // InternalExprParser.g:9255:1: rule__TupleLiteral__Group__0 : rule__TupleLiteral__Group__0__Impl rule__TupleLiteral__Group__1 ;
    public final void rule__TupleLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9259:1: ( rule__TupleLiteral__Group__0__Impl rule__TupleLiteral__Group__1 )
            // InternalExprParser.g:9260:2: rule__TupleLiteral__Group__0__Impl rule__TupleLiteral__Group__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalExprParser.g:9267:1: rule__TupleLiteral__Group__0__Impl : ( () ) ;
    public final void rule__TupleLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9271:1: ( ( () ) )
            // InternalExprParser.g:9272:1: ( () )
            {
            // InternalExprParser.g:9272:1: ( () )
            // InternalExprParser.g:9273:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleLiteralAccess().getTupleLiteralAction_0()); 
            }
            // InternalExprParser.g:9274:1: ()
            // InternalExprParser.g:9276:1: 
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
    // InternalExprParser.g:9286:1: rule__TupleLiteral__Group__1 : rule__TupleLiteral__Group__1__Impl rule__TupleLiteral__Group__2 ;
    public final void rule__TupleLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9290:1: ( rule__TupleLiteral__Group__1__Impl rule__TupleLiteral__Group__2 )
            // InternalExprParser.g:9291:2: rule__TupleLiteral__Group__1__Impl rule__TupleLiteral__Group__2
            {
            pushFollow(FOLLOW_11);
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
    // InternalExprParser.g:9298:1: rule__TupleLiteral__Group__1__Impl : ( Tuple ) ;
    public final void rule__TupleLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9302:1: ( ( Tuple ) )
            // InternalExprParser.g:9303:1: ( Tuple )
            {
            // InternalExprParser.g:9303:1: ( Tuple )
            // InternalExprParser.g:9304:1: Tuple
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
    // InternalExprParser.g:9317:1: rule__TupleLiteral__Group__2 : rule__TupleLiteral__Group__2__Impl rule__TupleLiteral__Group__3 ;
    public final void rule__TupleLiteral__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9321:1: ( rule__TupleLiteral__Group__2__Impl rule__TupleLiteral__Group__3 )
            // InternalExprParser.g:9322:2: rule__TupleLiteral__Group__2__Impl rule__TupleLiteral__Group__3
            {
            pushFollow(FOLLOW_52);
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
    // InternalExprParser.g:9329:1: rule__TupleLiteral__Group__2__Impl : ( LeftParenthesis ) ;
    public final void rule__TupleLiteral__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9333:1: ( ( LeftParenthesis ) )
            // InternalExprParser.g:9334:1: ( LeftParenthesis )
            {
            // InternalExprParser.g:9334:1: ( LeftParenthesis )
            // InternalExprParser.g:9335:1: LeftParenthesis
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
    // InternalExprParser.g:9348:1: rule__TupleLiteral__Group__3 : rule__TupleLiteral__Group__3__Impl rule__TupleLiteral__Group__4 ;
    public final void rule__TupleLiteral__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9352:1: ( rule__TupleLiteral__Group__3__Impl rule__TupleLiteral__Group__4 )
            // InternalExprParser.g:9353:2: rule__TupleLiteral__Group__3__Impl rule__TupleLiteral__Group__4
            {
            pushFollow(FOLLOW_52);
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
    // InternalExprParser.g:9360:1: rule__TupleLiteral__Group__3__Impl : ( ( ruleCommaSeparatedExpressions )? ) ;
    public final void rule__TupleLiteral__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9364:1: ( ( ( ruleCommaSeparatedExpressions )? ) )
            // InternalExprParser.g:9365:1: ( ( ruleCommaSeparatedExpressions )? )
            {
            // InternalExprParser.g:9365:1: ( ( ruleCommaSeparatedExpressions )? )
            // InternalExprParser.g:9366:1: ( ruleCommaSeparatedExpressions )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTupleLiteralAccess().getCommaSeparatedExpressionsParserRuleCall_3()); 
            }
            // InternalExprParser.g:9367:1: ( ruleCommaSeparatedExpressions )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==Record||LA45_0==False||(LA45_0>=Tuple && LA45_0<=Union)||LA45_0==List||(LA45_0>=This && LA45_0<=True)||LA45_0==Bag||LA45_0==Map||(LA45_0>=Not && LA45_0<=Set)||LA45_0==If||LA45_0==NumberSign||LA45_0==LeftParenthesis||LA45_0==PlusSign||LA45_0==HyphenMinus||LA45_0==LeftSquareBracket||LA45_0==RULE_REAL_LIT||LA45_0==RULE_INTEGER_LIT||(LA45_0>=RULE_STRING && LA45_0<=RULE_ID)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalExprParser.g:9367:3: ruleCommaSeparatedExpressions
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
    // InternalExprParser.g:9377:1: rule__TupleLiteral__Group__4 : rule__TupleLiteral__Group__4__Impl ;
    public final void rule__TupleLiteral__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9381:1: ( rule__TupleLiteral__Group__4__Impl )
            // InternalExprParser.g:9382:2: rule__TupleLiteral__Group__4__Impl
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
    // InternalExprParser.g:9388:1: rule__TupleLiteral__Group__4__Impl : ( RightParenthesis ) ;
    public final void rule__TupleLiteral__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9392:1: ( ( RightParenthesis ) )
            // InternalExprParser.g:9393:1: ( RightParenthesis )
            {
            // InternalExprParser.g:9393:1: ( RightParenthesis )
            // InternalExprParser.g:9394:1: RightParenthesis
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
    // InternalExprParser.g:9417:1: rule__BagLiteral__Group__0 : rule__BagLiteral__Group__0__Impl rule__BagLiteral__Group__1 ;
    public final void rule__BagLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9421:1: ( rule__BagLiteral__Group__0__Impl rule__BagLiteral__Group__1 )
            // InternalExprParser.g:9422:2: rule__BagLiteral__Group__0__Impl rule__BagLiteral__Group__1
            {
            pushFollow(FOLLOW_66);
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
    // InternalExprParser.g:9429:1: rule__BagLiteral__Group__0__Impl : ( () ) ;
    public final void rule__BagLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9433:1: ( ( () ) )
            // InternalExprParser.g:9434:1: ( () )
            {
            // InternalExprParser.g:9434:1: ( () )
            // InternalExprParser.g:9435:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBagLiteralAccess().getBagLiteralAction_0()); 
            }
            // InternalExprParser.g:9436:1: ()
            // InternalExprParser.g:9438:1: 
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
    // InternalExprParser.g:9448:1: rule__BagLiteral__Group__1 : rule__BagLiteral__Group__1__Impl rule__BagLiteral__Group__2 ;
    public final void rule__BagLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9452:1: ( rule__BagLiteral__Group__1__Impl rule__BagLiteral__Group__2 )
            // InternalExprParser.g:9453:2: rule__BagLiteral__Group__1__Impl rule__BagLiteral__Group__2
            {
            pushFollow(FOLLOW_11);
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
    // InternalExprParser.g:9460:1: rule__BagLiteral__Group__1__Impl : ( Bag ) ;
    public final void rule__BagLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9464:1: ( ( Bag ) )
            // InternalExprParser.g:9465:1: ( Bag )
            {
            // InternalExprParser.g:9465:1: ( Bag )
            // InternalExprParser.g:9466:1: Bag
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
    // InternalExprParser.g:9479:1: rule__BagLiteral__Group__2 : rule__BagLiteral__Group__2__Impl rule__BagLiteral__Group__3 ;
    public final void rule__BagLiteral__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9483:1: ( rule__BagLiteral__Group__2__Impl rule__BagLiteral__Group__3 )
            // InternalExprParser.g:9484:2: rule__BagLiteral__Group__2__Impl rule__BagLiteral__Group__3
            {
            pushFollow(FOLLOW_52);
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
    // InternalExprParser.g:9491:1: rule__BagLiteral__Group__2__Impl : ( LeftParenthesis ) ;
    public final void rule__BagLiteral__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9495:1: ( ( LeftParenthesis ) )
            // InternalExprParser.g:9496:1: ( LeftParenthesis )
            {
            // InternalExprParser.g:9496:1: ( LeftParenthesis )
            // InternalExprParser.g:9497:1: LeftParenthesis
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
    // InternalExprParser.g:9510:1: rule__BagLiteral__Group__3 : rule__BagLiteral__Group__3__Impl rule__BagLiteral__Group__4 ;
    public final void rule__BagLiteral__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9514:1: ( rule__BagLiteral__Group__3__Impl rule__BagLiteral__Group__4 )
            // InternalExprParser.g:9515:2: rule__BagLiteral__Group__3__Impl rule__BagLiteral__Group__4
            {
            pushFollow(FOLLOW_52);
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
    // InternalExprParser.g:9522:1: rule__BagLiteral__Group__3__Impl : ( ( ruleCommaSeparatedExpressions )? ) ;
    public final void rule__BagLiteral__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9526:1: ( ( ( ruleCommaSeparatedExpressions )? ) )
            // InternalExprParser.g:9527:1: ( ( ruleCommaSeparatedExpressions )? )
            {
            // InternalExprParser.g:9527:1: ( ( ruleCommaSeparatedExpressions )? )
            // InternalExprParser.g:9528:1: ( ruleCommaSeparatedExpressions )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBagLiteralAccess().getCommaSeparatedExpressionsParserRuleCall_3()); 
            }
            // InternalExprParser.g:9529:1: ( ruleCommaSeparatedExpressions )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==Record||LA46_0==False||(LA46_0>=Tuple && LA46_0<=Union)||LA46_0==List||(LA46_0>=This && LA46_0<=True)||LA46_0==Bag||LA46_0==Map||(LA46_0>=Not && LA46_0<=Set)||LA46_0==If||LA46_0==NumberSign||LA46_0==LeftParenthesis||LA46_0==PlusSign||LA46_0==HyphenMinus||LA46_0==LeftSquareBracket||LA46_0==RULE_REAL_LIT||LA46_0==RULE_INTEGER_LIT||(LA46_0>=RULE_STRING && LA46_0<=RULE_ID)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalExprParser.g:9529:3: ruleCommaSeparatedExpressions
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
    // InternalExprParser.g:9539:1: rule__BagLiteral__Group__4 : rule__BagLiteral__Group__4__Impl ;
    public final void rule__BagLiteral__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9543:1: ( rule__BagLiteral__Group__4__Impl )
            // InternalExprParser.g:9544:2: rule__BagLiteral__Group__4__Impl
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
    // InternalExprParser.g:9550:1: rule__BagLiteral__Group__4__Impl : ( RightParenthesis ) ;
    public final void rule__BagLiteral__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9554:1: ( ( RightParenthesis ) )
            // InternalExprParser.g:9555:1: ( RightParenthesis )
            {
            // InternalExprParser.g:9555:1: ( RightParenthesis )
            // InternalExprParser.g:9556:1: RightParenthesis
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
    // InternalExprParser.g:9579:1: rule__MapLiteral__Group__0 : rule__MapLiteral__Group__0__Impl rule__MapLiteral__Group__1 ;
    public final void rule__MapLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9583:1: ( rule__MapLiteral__Group__0__Impl rule__MapLiteral__Group__1 )
            // InternalExprParser.g:9584:2: rule__MapLiteral__Group__0__Impl rule__MapLiteral__Group__1
            {
            pushFollow(FOLLOW_67);
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
    // InternalExprParser.g:9591:1: rule__MapLiteral__Group__0__Impl : ( () ) ;
    public final void rule__MapLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9595:1: ( ( () ) )
            // InternalExprParser.g:9596:1: ( () )
            {
            // InternalExprParser.g:9596:1: ( () )
            // InternalExprParser.g:9597:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMapLiteralAccess().getMapLiteralAction_0()); 
            }
            // InternalExprParser.g:9598:1: ()
            // InternalExprParser.g:9600:1: 
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
    // InternalExprParser.g:9610:1: rule__MapLiteral__Group__1 : rule__MapLiteral__Group__1__Impl ;
    public final void rule__MapLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9614:1: ( rule__MapLiteral__Group__1__Impl )
            // InternalExprParser.g:9615:2: rule__MapLiteral__Group__1__Impl
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
    // InternalExprParser.g:9621:1: rule__MapLiteral__Group__1__Impl : ( Map ) ;
    public final void rule__MapLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9625:1: ( ( Map ) )
            // InternalExprParser.g:9626:1: ( Map )
            {
            // InternalExprParser.g:9626:1: ( Map )
            // InternalExprParser.g:9627:1: Map
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
    // InternalExprParser.g:9645:1: rule__QPREF__Group__0 : rule__QPREF__Group__0__Impl rule__QPREF__Group__1 ;
    public final void rule__QPREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9649:1: ( rule__QPREF__Group__0__Impl rule__QPREF__Group__1 )
            // InternalExprParser.g:9650:2: rule__QPREF__Group__0__Impl rule__QPREF__Group__1
            {
            pushFollow(FOLLOW_68);
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
    // InternalExprParser.g:9657:1: rule__QPREF__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QPREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9661:1: ( ( RULE_ID ) )
            // InternalExprParser.g:9662:1: ( RULE_ID )
            {
            // InternalExprParser.g:9662:1: ( RULE_ID )
            // InternalExprParser.g:9663:1: RULE_ID
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
    // InternalExprParser.g:9674:1: rule__QPREF__Group__1 : rule__QPREF__Group__1__Impl ;
    public final void rule__QPREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9678:1: ( rule__QPREF__Group__1__Impl )
            // InternalExprParser.g:9679:2: rule__QPREF__Group__1__Impl
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
    // InternalExprParser.g:9685:1: rule__QPREF__Group__1__Impl : ( ( rule__QPREF__Group_1__0 )? ) ;
    public final void rule__QPREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9689:1: ( ( ( rule__QPREF__Group_1__0 )? ) )
            // InternalExprParser.g:9690:1: ( ( rule__QPREF__Group_1__0 )? )
            {
            // InternalExprParser.g:9690:1: ( ( rule__QPREF__Group_1__0 )? )
            // InternalExprParser.g:9691:1: ( rule__QPREF__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQPREFAccess().getGroup_1()); 
            }
            // InternalExprParser.g:9692:1: ( rule__QPREF__Group_1__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==ColonColon) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalExprParser.g:9692:2: rule__QPREF__Group_1__0
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
    // InternalExprParser.g:9706:1: rule__QPREF__Group_1__0 : rule__QPREF__Group_1__0__Impl rule__QPREF__Group_1__1 ;
    public final void rule__QPREF__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9710:1: ( rule__QPREF__Group_1__0__Impl rule__QPREF__Group_1__1 )
            // InternalExprParser.g:9711:2: rule__QPREF__Group_1__0__Impl rule__QPREF__Group_1__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalExprParser.g:9718:1: rule__QPREF__Group_1__0__Impl : ( ColonColon ) ;
    public final void rule__QPREF__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9722:1: ( ( ColonColon ) )
            // InternalExprParser.g:9723:1: ( ColonColon )
            {
            // InternalExprParser.g:9723:1: ( ColonColon )
            // InternalExprParser.g:9724:1: ColonColon
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
    // InternalExprParser.g:9737:1: rule__QPREF__Group_1__1 : rule__QPREF__Group_1__1__Impl ;
    public final void rule__QPREF__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9741:1: ( rule__QPREF__Group_1__1__Impl )
            // InternalExprParser.g:9742:2: rule__QPREF__Group_1__1__Impl
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
    // InternalExprParser.g:9748:1: rule__QPREF__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QPREF__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9752:1: ( ( RULE_ID ) )
            // InternalExprParser.g:9753:1: ( RULE_ID )
            {
            // InternalExprParser.g:9753:1: ( RULE_ID )
            // InternalExprParser.g:9754:1: RULE_ID
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
    // InternalExprParser.g:9769:1: rule__QCREF__Group__0 : rule__QCREF__Group__0__Impl rule__QCREF__Group__1 ;
    public final void rule__QCREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9773:1: ( rule__QCREF__Group__0__Impl rule__QCREF__Group__1 )
            // InternalExprParser.g:9774:2: rule__QCREF__Group__0__Impl rule__QCREF__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalExprParser.g:9781:1: rule__QCREF__Group__0__Impl : ( ( rule__QCREF__Group_0__0 )* ) ;
    public final void rule__QCREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9785:1: ( ( ( rule__QCREF__Group_0__0 )* ) )
            // InternalExprParser.g:9786:1: ( ( rule__QCREF__Group_0__0 )* )
            {
            // InternalExprParser.g:9786:1: ( ( rule__QCREF__Group_0__0 )* )
            // InternalExprParser.g:9787:1: ( rule__QCREF__Group_0__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQCREFAccess().getGroup_0()); 
            }
            // InternalExprParser.g:9788:1: ( rule__QCREF__Group_0__0 )*
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
            	    // InternalExprParser.g:9788:2: rule__QCREF__Group_0__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__QCREF__Group_0__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop48;
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
    // InternalExprParser.g:9798:1: rule__QCREF__Group__1 : rule__QCREF__Group__1__Impl rule__QCREF__Group__2 ;
    public final void rule__QCREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9802:1: ( rule__QCREF__Group__1__Impl rule__QCREF__Group__2 )
            // InternalExprParser.g:9803:2: rule__QCREF__Group__1__Impl rule__QCREF__Group__2
            {
            pushFollow(FOLLOW_49);
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
    // InternalExprParser.g:9810:1: rule__QCREF__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__QCREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9814:1: ( ( RULE_ID ) )
            // InternalExprParser.g:9815:1: ( RULE_ID )
            {
            // InternalExprParser.g:9815:1: ( RULE_ID )
            // InternalExprParser.g:9816:1: RULE_ID
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
    // InternalExprParser.g:9827:1: rule__QCREF__Group__2 : rule__QCREF__Group__2__Impl ;
    public final void rule__QCREF__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9831:1: ( rule__QCREF__Group__2__Impl )
            // InternalExprParser.g:9832:2: rule__QCREF__Group__2__Impl
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
    // InternalExprParser.g:9838:1: rule__QCREF__Group__2__Impl : ( ( rule__QCREF__Group_2__0 )? ) ;
    public final void rule__QCREF__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9842:1: ( ( ( rule__QCREF__Group_2__0 )? ) )
            // InternalExprParser.g:9843:1: ( ( rule__QCREF__Group_2__0 )? )
            {
            // InternalExprParser.g:9843:1: ( ( rule__QCREF__Group_2__0 )? )
            // InternalExprParser.g:9844:1: ( rule__QCREF__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQCREFAccess().getGroup_2()); 
            }
            // InternalExprParser.g:9845:1: ( rule__QCREF__Group_2__0 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==FullStop) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalExprParser.g:9845:2: rule__QCREF__Group_2__0
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
    // InternalExprParser.g:9861:1: rule__QCREF__Group_0__0 : rule__QCREF__Group_0__0__Impl rule__QCREF__Group_0__1 ;
    public final void rule__QCREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9865:1: ( rule__QCREF__Group_0__0__Impl rule__QCREF__Group_0__1 )
            // InternalExprParser.g:9866:2: rule__QCREF__Group_0__0__Impl rule__QCREF__Group_0__1
            {
            pushFollow(FOLLOW_68);
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
    // InternalExprParser.g:9873:1: rule__QCREF__Group_0__0__Impl : ( RULE_ID ) ;
    public final void rule__QCREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9877:1: ( ( RULE_ID ) )
            // InternalExprParser.g:9878:1: ( RULE_ID )
            {
            // InternalExprParser.g:9878:1: ( RULE_ID )
            // InternalExprParser.g:9879:1: RULE_ID
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
    // InternalExprParser.g:9890:1: rule__QCREF__Group_0__1 : rule__QCREF__Group_0__1__Impl ;
    public final void rule__QCREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9894:1: ( rule__QCREF__Group_0__1__Impl )
            // InternalExprParser.g:9895:2: rule__QCREF__Group_0__1__Impl
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
    // InternalExprParser.g:9901:1: rule__QCREF__Group_0__1__Impl : ( ColonColon ) ;
    public final void rule__QCREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9905:1: ( ( ColonColon ) )
            // InternalExprParser.g:9906:1: ( ColonColon )
            {
            // InternalExprParser.g:9906:1: ( ColonColon )
            // InternalExprParser.g:9907:1: ColonColon
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
    // InternalExprParser.g:9924:1: rule__QCREF__Group_2__0 : rule__QCREF__Group_2__0__Impl rule__QCREF__Group_2__1 ;
    public final void rule__QCREF__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9928:1: ( rule__QCREF__Group_2__0__Impl rule__QCREF__Group_2__1 )
            // InternalExprParser.g:9929:2: rule__QCREF__Group_2__0__Impl rule__QCREF__Group_2__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalExprParser.g:9936:1: rule__QCREF__Group_2__0__Impl : ( FullStop ) ;
    public final void rule__QCREF__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9940:1: ( ( FullStop ) )
            // InternalExprParser.g:9941:1: ( FullStop )
            {
            // InternalExprParser.g:9941:1: ( FullStop )
            // InternalExprParser.g:9942:1: FullStop
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
    // InternalExprParser.g:9955:1: rule__QCREF__Group_2__1 : rule__QCREF__Group_2__1__Impl ;
    public final void rule__QCREF__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9959:1: ( rule__QCREF__Group_2__1__Impl )
            // InternalExprParser.g:9960:2: rule__QCREF__Group_2__1__Impl
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
    // InternalExprParser.g:9966:1: rule__QCREF__Group_2__1__Impl : ( RULE_ID ) ;
    public final void rule__QCREF__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9970:1: ( ( RULE_ID ) )
            // InternalExprParser.g:9971:1: ( RULE_ID )
            {
            // InternalExprParser.g:9971:1: ( RULE_ID )
            // InternalExprParser.g:9972:1: RULE_ID
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
    // InternalExprParser.g:9988:1: rule__ExprModel__AnnexAssignment_0_1 : ( ruleExprLibrary ) ;
    public final void rule__ExprModel__AnnexAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:9992:1: ( ( ruleExprLibrary ) )
            // InternalExprParser.g:9993:1: ( ruleExprLibrary )
            {
            // InternalExprParser.g:9993:1: ( ruleExprLibrary )
            // InternalExprParser.g:9994:1: ruleExprLibrary
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
    // InternalExprParser.g:10003:1: rule__ExprModel__AnnexAssignment_1_1 : ( ruleExprSubclause ) ;
    public final void rule__ExprModel__AnnexAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10007:1: ( ( ruleExprSubclause ) )
            // InternalExprParser.g:10008:1: ( ruleExprSubclause )
            {
            // InternalExprParser.g:10008:1: ( ruleExprSubclause )
            // InternalExprParser.g:10009:1: ruleExprSubclause
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


    // $ANTLR start "rule__ExprLibrary__DeclsAssignment_1"
    // InternalExprParser.g:10018:1: rule__ExprLibrary__DeclsAssignment_1 : ( ruleDeclaration ) ;
    public final void rule__ExprLibrary__DeclsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10022:1: ( ( ruleDeclaration ) )
            // InternalExprParser.g:10023:1: ( ruleDeclaration )
            {
            // InternalExprParser.g:10023:1: ( ruleDeclaration )
            // InternalExprParser.g:10024:1: ruleDeclaration
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprLibraryAccess().getDeclsDeclarationParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleDeclaration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprLibraryAccess().getDeclsDeclarationParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExprLibrary__DeclsAssignment_1"


    // $ANTLR start "rule__ExprSubclause__DeclsAssignment_1"
    // InternalExprParser.g:10033:1: rule__ExprSubclause__DeclsAssignment_1 : ( ruleDeclaration ) ;
    public final void rule__ExprSubclause__DeclsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10037:1: ( ( ruleDeclaration ) )
            // InternalExprParser.g:10038:1: ( ruleDeclaration )
            {
            // InternalExprParser.g:10038:1: ( ruleDeclaration )
            // InternalExprParser.g:10039:1: ruleDeclaration
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprSubclauseAccess().getDeclsDeclarationParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleDeclaration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprSubclauseAccess().getDeclsDeclarationParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExprSubclause__DeclsAssignment_1"


    // $ANTLR start "rule__TypeDecl__NameAssignment_1"
    // InternalExprParser.g:10048:1: rule__TypeDecl__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__TypeDecl__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10052:1: ( ( RULE_ID ) )
            // InternalExprParser.g:10053:1: ( RULE_ID )
            {
            // InternalExprParser.g:10053:1: ( RULE_ID )
            // InternalExprParser.g:10054:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDeclAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDeclAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDecl__NameAssignment_1"


    // $ANTLR start "rule__TypeDecl__TypeAssignment_3"
    // InternalExprParser.g:10063:1: rule__TypeDecl__TypeAssignment_3 : ( ruleType ) ;
    public final void rule__TypeDecl__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10067:1: ( ( ruleType ) )
            // InternalExprParser.g:10068:1: ( ruleType )
            {
            // InternalExprParser.g:10068:1: ( ruleType )
            // InternalExprParser.g:10069:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDeclAccess().getTypeTypeParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDeclAccess().getTypeTypeParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDecl__TypeAssignment_3"


    // $ANTLR start "rule__VarDecl__ConstAssignment_0_0"
    // InternalExprParser.g:10078:1: rule__VarDecl__ConstAssignment_0_0 : ( ( Val ) ) ;
    public final void rule__VarDecl__ConstAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10082:1: ( ( ( Val ) ) )
            // InternalExprParser.g:10083:1: ( ( Val ) )
            {
            // InternalExprParser.g:10083:1: ( ( Val ) )
            // InternalExprParser.g:10084:1: ( Val )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getConstValKeyword_0_0_0()); 
            }
            // InternalExprParser.g:10085:1: ( Val )
            // InternalExprParser.g:10086:1: Val
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getConstValKeyword_0_0_0()); 
            }
            match(input,Val,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getConstValKeyword_0_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getConstValKeyword_0_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__ConstAssignment_0_0"


    // $ANTLR start "rule__VarDecl__NameAssignment_1"
    // InternalExprParser.g:10101:1: rule__VarDecl__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__VarDecl__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10105:1: ( ( RULE_ID ) )
            // InternalExprParser.g:10106:1: ( RULE_ID )
            {
            // InternalExprParser.g:10106:1: ( RULE_ID )
            // InternalExprParser.g:10107:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__NameAssignment_1"


    // $ANTLR start "rule__VarDecl__TypeAssignment_2_1"
    // InternalExprParser.g:10116:1: rule__VarDecl__TypeAssignment_2_1 : ( ruleType ) ;
    public final void rule__VarDecl__TypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10120:1: ( ( ruleType ) )
            // InternalExprParser.g:10121:1: ( ruleType )
            {
            // InternalExprParser.g:10121:1: ( ruleType )
            // InternalExprParser.g:10122:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getTypeTypeParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getTypeTypeParserRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__TypeAssignment_2_1"


    // $ANTLR start "rule__VarDecl__ValueAssignment_3_1"
    // InternalExprParser.g:10131:1: rule__VarDecl__ValueAssignment_3_1 : ( ruleExpression ) ;
    public final void rule__VarDecl__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10135:1: ( ( ruleExpression ) )
            // InternalExprParser.g:10136:1: ( ruleExpression )
            {
            // InternalExprParser.g:10136:1: ( ruleExpression )
            // InternalExprParser.g:10137:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarDeclAccess().getValueExpressionParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarDeclAccess().getValueExpressionParserRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDecl__ValueAssignment_3_1"


    // $ANTLR start "rule__FunDecl__NameAssignment_1"
    // InternalExprParser.g:10146:1: rule__FunDecl__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__FunDecl__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10150:1: ( ( RULE_ID ) )
            // InternalExprParser.g:10151:1: ( RULE_ID )
            {
            // InternalExprParser.g:10151:1: ( RULE_ID )
            // InternalExprParser.g:10152:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFunDeclAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFunDeclAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunDecl__NameAssignment_1"


    // $ANTLR start "rule__Category__CategoryAssignment"
    // InternalExprParser.g:10161:1: rule__Category__CategoryAssignment : ( ruleComponentCategory ) ;
    public final void rule__Category__CategoryAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10165:1: ( ( ruleComponentCategory ) )
            // InternalExprParser.g:10166:1: ( ruleComponentCategory )
            {
            // InternalExprParser.g:10166:1: ( ruleComponentCategory )
            // InternalExprParser.g:10167:1: ruleComponentCategory
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
    // InternalExprParser.g:10176:1: rule__MetaClass__ClassAssignment : ( ruleMetaClassEnum ) ;
    public final void rule__MetaClass__ClassAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10180:1: ( ( ruleMetaClassEnum ) )
            // InternalExprParser.g:10181:1: ( ruleMetaClassEnum )
            {
            // InternalExprParser.g:10181:1: ( ruleMetaClassEnum )
            // InternalExprParser.g:10182:1: ruleMetaClassEnum
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
    // InternalExprParser.g:10191:1: rule__ClassifierType__BaseAssignment_2_1 : ( ( ruleQCREF ) ) ;
    public final void rule__ClassifierType__BaseAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10195:1: ( ( ( ruleQCREF ) ) )
            // InternalExprParser.g:10196:1: ( ( ruleQCREF ) )
            {
            // InternalExprParser.g:10196:1: ( ( ruleQCREF ) )
            // InternalExprParser.g:10197:1: ( ruleQCREF )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeAccess().getBaseClassifierCrossReference_2_1_0()); 
            }
            // InternalExprParser.g:10198:1: ( ruleQCREF )
            // InternalExprParser.g:10199:1: ruleQCREF
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
    // InternalExprParser.g:10210:1: rule__RecordType__FieldAssignment_3 : ( ruleField ) ;
    public final void rule__RecordType__FieldAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10214:1: ( ( ruleField ) )
            // InternalExprParser.g:10215:1: ( ruleField )
            {
            // InternalExprParser.g:10215:1: ( ruleField )
            // InternalExprParser.g:10216:1: ruleField
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
    // InternalExprParser.g:10225:1: rule__Field__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Field__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10229:1: ( ( RULE_ID ) )
            // InternalExprParser.g:10230:1: ( RULE_ID )
            {
            // InternalExprParser.g:10230:1: ( RULE_ID )
            // InternalExprParser.g:10231:1: RULE_ID
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
    // InternalExprParser.g:10240:1: rule__Field__TypeAssignment_2 : ( ruleType ) ;
    public final void rule__Field__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10244:1: ( ( ruleType ) )
            // InternalExprParser.g:10245:1: ( ruleType )
            {
            // InternalExprParser.g:10245:1: ( ruleType )
            // InternalExprParser.g:10246:1: ruleType
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
    // InternalExprParser.g:10255:1: rule__TupleType__FieldAssignment_3 : ( ruleTupleField ) ;
    public final void rule__TupleType__FieldAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10259:1: ( ( ruleTupleField ) )
            // InternalExprParser.g:10260:1: ( ruleTupleField )
            {
            // InternalExprParser.g:10260:1: ( ruleTupleField )
            // InternalExprParser.g:10261:1: ruleTupleField
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
    // InternalExprParser.g:10270:1: rule__TupleField__TypeAssignment_1 : ( ruleType ) ;
    public final void rule__TupleField__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10274:1: ( ( ruleType ) )
            // InternalExprParser.g:10275:1: ( ruleType )
            {
            // InternalExprParser.g:10275:1: ( ruleType )
            // InternalExprParser.g:10276:1: ruleType
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
    // InternalExprParser.g:10285:1: rule__ListType__TypeAssignment_3 : ( ruleType ) ;
    public final void rule__ListType__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10289:1: ( ( ruleType ) )
            // InternalExprParser.g:10290:1: ( ruleType )
            {
            // InternalExprParser.g:10290:1: ( ruleType )
            // InternalExprParser.g:10291:1: ruleType
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
    // InternalExprParser.g:10300:1: rule__SetType__TypeAssignment_2 : ( ruleType ) ;
    public final void rule__SetType__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10304:1: ( ( ruleType ) )
            // InternalExprParser.g:10305:1: ( ruleType )
            {
            // InternalExprParser.g:10305:1: ( ruleType )
            // InternalExprParser.g:10306:1: ruleType
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
    // InternalExprParser.g:10315:1: rule__BagType__TypeAssignment_2 : ( ruleType ) ;
    public final void rule__BagType__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10319:1: ( ( ruleType ) )
            // InternalExprParser.g:10320:1: ( ruleType )
            {
            // InternalExprParser.g:10320:1: ( ruleType )
            // InternalExprParser.g:10321:1: ruleType
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
    // InternalExprParser.g:10330:1: rule__MapType__DomAssignment_1 : ( ruleType ) ;
    public final void rule__MapType__DomAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10334:1: ( ( ruleType ) )
            // InternalExprParser.g:10335:1: ( ruleType )
            {
            // InternalExprParser.g:10335:1: ( ruleType )
            // InternalExprParser.g:10336:1: ruleType
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
    // InternalExprParser.g:10345:1: rule__MapType__ImgAssignment_3 : ( ruleType ) ;
    public final void rule__MapType__ImgAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10349:1: ( ( ruleType ) )
            // InternalExprParser.g:10350:1: ( ruleType )
            {
            // InternalExprParser.g:10350:1: ( ruleType )
            // InternalExprParser.g:10351:1: ruleType
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
    // InternalExprParser.g:10360:1: rule__TypeRef__RefAssignment : ( ( ruleQCREF ) ) ;
    public final void rule__TypeRef__RefAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10364:1: ( ( ( ruleQCREF ) ) )
            // InternalExprParser.g:10365:1: ( ( ruleQCREF ) )
            {
            // InternalExprParser.g:10365:1: ( ( ruleQCREF ) )
            // InternalExprParser.g:10366:1: ( ruleQCREF )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRefAccess().getRefTypeDeclCrossReference_0()); 
            }
            // InternalExprParser.g:10367:1: ( ruleQCREF )
            // InternalExprParser.g:10368:1: ruleQCREF
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
    // InternalExprParser.g:10379:1: rule__OrExpression__OperatorAssignment_1_0_0_1 : ( ruleOpOr ) ;
    public final void rule__OrExpression__OperatorAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10383:1: ( ( ruleOpOr ) )
            // InternalExprParser.g:10384:1: ( ruleOpOr )
            {
            // InternalExprParser.g:10384:1: ( ruleOpOr )
            // InternalExprParser.g:10385:1: ruleOpOr
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
    // InternalExprParser.g:10394:1: rule__OrExpression__RightAssignment_1_1 : ( ruleAndExpression ) ;
    public final void rule__OrExpression__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10398:1: ( ( ruleAndExpression ) )
            // InternalExprParser.g:10399:1: ( ruleAndExpression )
            {
            // InternalExprParser.g:10399:1: ( ruleAndExpression )
            // InternalExprParser.g:10400:1: ruleAndExpression
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
    // InternalExprParser.g:10409:1: rule__AndExpression__OperatorAssignment_1_0_0_1 : ( ruleOpAnd ) ;
    public final void rule__AndExpression__OperatorAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10413:1: ( ( ruleOpAnd ) )
            // InternalExprParser.g:10414:1: ( ruleOpAnd )
            {
            // InternalExprParser.g:10414:1: ( ruleOpAnd )
            // InternalExprParser.g:10415:1: ruleOpAnd
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
    // InternalExprParser.g:10424:1: rule__AndExpression__RightAssignment_1_1 : ( ruleEqualityExpression ) ;
    public final void rule__AndExpression__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10428:1: ( ( ruleEqualityExpression ) )
            // InternalExprParser.g:10429:1: ( ruleEqualityExpression )
            {
            // InternalExprParser.g:10429:1: ( ruleEqualityExpression )
            // InternalExprParser.g:10430:1: ruleEqualityExpression
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
    // InternalExprParser.g:10439:1: rule__EqualityExpression__OperatorAssignment_1_0_0_1 : ( ruleOpEquality ) ;
    public final void rule__EqualityExpression__OperatorAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10443:1: ( ( ruleOpEquality ) )
            // InternalExprParser.g:10444:1: ( ruleOpEquality )
            {
            // InternalExprParser.g:10444:1: ( ruleOpEquality )
            // InternalExprParser.g:10445:1: ruleOpEquality
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
    // InternalExprParser.g:10454:1: rule__EqualityExpression__RightAssignment_1_1 : ( ruleRelationalExpression ) ;
    public final void rule__EqualityExpression__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10458:1: ( ( ruleRelationalExpression ) )
            // InternalExprParser.g:10459:1: ( ruleRelationalExpression )
            {
            // InternalExprParser.g:10459:1: ( ruleRelationalExpression )
            // InternalExprParser.g:10460:1: ruleRelationalExpression
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
    // InternalExprParser.g:10469:1: rule__RelationalExpression__OperatorAssignment_1_0_0_1 : ( ruleOpCompare ) ;
    public final void rule__RelationalExpression__OperatorAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10473:1: ( ( ruleOpCompare ) )
            // InternalExprParser.g:10474:1: ( ruleOpCompare )
            {
            // InternalExprParser.g:10474:1: ( ruleOpCompare )
            // InternalExprParser.g:10475:1: ruleOpCompare
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
    // InternalExprParser.g:10484:1: rule__RelationalExpression__RightAssignment_1_1 : ( ruleAdditiveExpression ) ;
    public final void rule__RelationalExpression__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10488:1: ( ( ruleAdditiveExpression ) )
            // InternalExprParser.g:10489:1: ( ruleAdditiveExpression )
            {
            // InternalExprParser.g:10489:1: ( ruleAdditiveExpression )
            // InternalExprParser.g:10490:1: ruleAdditiveExpression
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
    // InternalExprParser.g:10499:1: rule__AdditiveExpression__OperatorAssignment_1_0_0_1 : ( ruleOpAdd ) ;
    public final void rule__AdditiveExpression__OperatorAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10503:1: ( ( ruleOpAdd ) )
            // InternalExprParser.g:10504:1: ( ruleOpAdd )
            {
            // InternalExprParser.g:10504:1: ( ruleOpAdd )
            // InternalExprParser.g:10505:1: ruleOpAdd
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
    // InternalExprParser.g:10514:1: rule__AdditiveExpression__RightAssignment_1_1 : ( ruleMultiplicativeExpression ) ;
    public final void rule__AdditiveExpression__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10518:1: ( ( ruleMultiplicativeExpression ) )
            // InternalExprParser.g:10519:1: ( ruleMultiplicativeExpression )
            {
            // InternalExprParser.g:10519:1: ( ruleMultiplicativeExpression )
            // InternalExprParser.g:10520:1: ruleMultiplicativeExpression
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
    // InternalExprParser.g:10529:1: rule__MultiplicativeExpression__OperatorAssignment_1_0_0_1 : ( ruleOpMulti ) ;
    public final void rule__MultiplicativeExpression__OperatorAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10533:1: ( ( ruleOpMulti ) )
            // InternalExprParser.g:10534:1: ( ruleOpMulti )
            {
            // InternalExprParser.g:10534:1: ( ruleOpMulti )
            // InternalExprParser.g:10535:1: ruleOpMulti
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
    // InternalExprParser.g:10544:1: rule__MultiplicativeExpression__RightAssignment_1_1 : ( ruleUnaryOperation ) ;
    public final void rule__MultiplicativeExpression__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10548:1: ( ( ruleUnaryOperation ) )
            // InternalExprParser.g:10549:1: ( ruleUnaryOperation )
            {
            // InternalExprParser.g:10549:1: ( ruleUnaryOperation )
            // InternalExprParser.g:10550:1: ruleUnaryOperation
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
    // InternalExprParser.g:10559:1: rule__UnaryOperation__OperatorAssignment_0_1 : ( ruleOpUnary ) ;
    public final void rule__UnaryOperation__OperatorAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10563:1: ( ( ruleOpUnary ) )
            // InternalExprParser.g:10564:1: ( ruleOpUnary )
            {
            // InternalExprParser.g:10564:1: ( ruleOpUnary )
            // InternalExprParser.g:10565:1: ruleOpUnary
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
    // InternalExprParser.g:10574:1: rule__UnaryOperation__OperandAssignment_0_2 : ( ruleUnitExpression ) ;
    public final void rule__UnaryOperation__OperandAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10578:1: ( ( ruleUnitExpression ) )
            // InternalExprParser.g:10579:1: ( ruleUnitExpression )
            {
            // InternalExprParser.g:10579:1: ( ruleUnitExpression )
            // InternalExprParser.g:10580:1: ruleUnitExpression
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
    // InternalExprParser.g:10589:1: rule__UnitExpression__ConvertAssignment_1_1_0 : ( ( PercentSign ) ) ;
    public final void rule__UnitExpression__ConvertAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10593:1: ( ( ( PercentSign ) ) )
            // InternalExprParser.g:10594:1: ( ( PercentSign ) )
            {
            // InternalExprParser.g:10594:1: ( ( PercentSign ) )
            // InternalExprParser.g:10595:1: ( PercentSign )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnitExpressionAccess().getConvertPercentSignKeyword_1_1_0_0()); 
            }
            // InternalExprParser.g:10596:1: ( PercentSign )
            // InternalExprParser.g:10597:1: PercentSign
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
    // InternalExprParser.g:10612:1: rule__UnitExpression__DropAssignment_1_1_1 : ( ( In ) ) ;
    public final void rule__UnitExpression__DropAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10616:1: ( ( ( In ) ) )
            // InternalExprParser.g:10617:1: ( ( In ) )
            {
            // InternalExprParser.g:10617:1: ( ( In ) )
            // InternalExprParser.g:10618:1: ( In )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnitExpressionAccess().getDropInKeyword_1_1_1_0()); 
            }
            // InternalExprParser.g:10619:1: ( In )
            // InternalExprParser.g:10620:1: In
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
    // InternalExprParser.g:10635:1: rule__UnitExpression__UnitAssignment_1_2 : ( ( RULE_ID ) ) ;
    public final void rule__UnitExpression__UnitAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10639:1: ( ( ( RULE_ID ) ) )
            // InternalExprParser.g:10640:1: ( ( RULE_ID ) )
            {
            // InternalExprParser.g:10640:1: ( ( RULE_ID ) )
            // InternalExprParser.g:10641:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnitExpressionAccess().getUnitUnitLiteralCrossReference_1_2_0()); 
            }
            // InternalExprParser.g:10642:1: ( RULE_ID )
            // InternalExprParser.g:10643:1: RULE_ID
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
    // InternalExprParser.g:10654:1: rule__VarRef__RefAssignment : ( ( ruleQCREF ) ) ;
    public final void rule__VarRef__RefAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10658:1: ( ( ( ruleQCREF ) ) )
            // InternalExprParser.g:10659:1: ( ( ruleQCREF ) )
            {
            // InternalExprParser.g:10659:1: ( ( ruleQCREF ) )
            // InternalExprParser.g:10660:1: ( ruleQCREF )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarRefAccess().getRefVarDeclCrossReference_0()); 
            }
            // InternalExprParser.g:10661:1: ( ruleQCREF )
            // InternalExprParser.g:10662:1: ruleQCREF
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
    // InternalExprParser.g:10673:1: rule__ModelOrPropertyReference__PropertyAssignment_0_1_1 : ( ( ruleQPREF ) ) ;
    public final void rule__ModelOrPropertyReference__PropertyAssignment_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10677:1: ( ( ( ruleQPREF ) ) )
            // InternalExprParser.g:10678:1: ( ( ruleQPREF ) )
            {
            // InternalExprParser.g:10678:1: ( ( ruleQPREF ) )
            // InternalExprParser.g:10679:1: ( ruleQPREF )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelOrPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_0_1_1_0()); 
            }
            // InternalExprParser.g:10680:1: ( ruleQPREF )
            // InternalExprParser.g:10681:1: ruleQPREF
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
    // InternalExprParser.g:10692:1: rule__ModelReference__ModelElementAssignment_0 : ( ( ruleThis ) ) ;
    public final void rule__ModelReference__ModelElementAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10696:1: ( ( ( ruleThis ) ) )
            // InternalExprParser.g:10697:1: ( ( ruleThis ) )
            {
            // InternalExprParser.g:10697:1: ( ( ruleThis ) )
            // InternalExprParser.g:10698:1: ( ruleThis )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelReferenceAccess().getModelElementNamedElementCrossReference_0_0()); 
            }
            // InternalExprParser.g:10699:1: ( ruleThis )
            // InternalExprParser.g:10700:1: ruleThis
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
    // InternalExprParser.g:10711:1: rule__ModelReference__ModelElementAssignment_1_2 : ( ( RULE_ID ) ) ;
    public final void rule__ModelReference__ModelElementAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10715:1: ( ( ( RULE_ID ) ) )
            // InternalExprParser.g:10716:1: ( ( RULE_ID ) )
            {
            // InternalExprParser.g:10716:1: ( ( RULE_ID ) )
            // InternalExprParser.g:10717:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelReferenceAccess().getModelElementNamedElementCrossReference_1_2_0()); 
            }
            // InternalExprParser.g:10718:1: ( RULE_ID )
            // InternalExprParser.g:10719:1: RULE_ID
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
    // InternalExprParser.g:10730:1: rule__PropertyReference__PropertyAssignment_2 : ( ( ruleQPREF ) ) ;
    public final void rule__PropertyReference__PropertyAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10734:1: ( ( ( ruleQPREF ) ) )
            // InternalExprParser.g:10735:1: ( ( ruleQPREF ) )
            {
            // InternalExprParser.g:10735:1: ( ( ruleQPREF ) )
            // InternalExprParser.g:10736:1: ( ruleQPREF )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_2_0()); 
            }
            // InternalExprParser.g:10737:1: ( ruleQPREF )
            // InternalExprParser.g:10738:1: ruleQPREF
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
    // InternalExprParser.g:10749:1: rule__FunctionCall__FunctionAssignment_1 : ( ruleQCREF ) ;
    public final void rule__FunctionCall__FunctionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10753:1: ( ( ruleQCREF ) )
            // InternalExprParser.g:10754:1: ( ruleQCREF )
            {
            // InternalExprParser.g:10754:1: ( ruleQCREF )
            // InternalExprParser.g:10755:1: ruleQCREF
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
    // InternalExprParser.g:10764:1: rule__FunctionCall__ArgumentsAssignment_3_0 : ( ruleExpression ) ;
    public final void rule__FunctionCall__ArgumentsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10768:1: ( ( ruleExpression ) )
            // InternalExprParser.g:10769:1: ( ruleExpression )
            {
            // InternalExprParser.g:10769:1: ( ruleExpression )
            // InternalExprParser.g:10770:1: ruleExpression
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
    // InternalExprParser.g:10779:1: rule__FunctionCall__ArgumentsAssignment_3_1_1 : ( ruleExpression ) ;
    public final void rule__FunctionCall__ArgumentsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10783:1: ( ( ruleExpression ) )
            // InternalExprParser.g:10784:1: ( ruleExpression )
            {
            // InternalExprParser.g:10784:1: ( ruleExpression )
            // InternalExprParser.g:10785:1: ruleExpression
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
    // InternalExprParser.g:10794:1: rule__RangeExpression__MinimumAssignment_2 : ( ruleExpression ) ;
    public final void rule__RangeExpression__MinimumAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10798:1: ( ( ruleExpression ) )
            // InternalExprParser.g:10799:1: ( ruleExpression )
            {
            // InternalExprParser.g:10799:1: ( ruleExpression )
            // InternalExprParser.g:10800:1: ruleExpression
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
    // InternalExprParser.g:10809:1: rule__RangeExpression__MaximumAssignment_4 : ( ruleExpression ) ;
    public final void rule__RangeExpression__MaximumAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10813:1: ( ( ruleExpression ) )
            // InternalExprParser.g:10814:1: ( ruleExpression )
            {
            // InternalExprParser.g:10814:1: ( ruleExpression )
            // InternalExprParser.g:10815:1: ruleExpression
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
    // InternalExprParser.g:10824:1: rule__RangeExpression__DeltaAssignment_5_1 : ( ruleExpression ) ;
    public final void rule__RangeExpression__DeltaAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10828:1: ( ( ruleExpression ) )
            // InternalExprParser.g:10829:1: ( ruleExpression )
            {
            // InternalExprParser.g:10829:1: ( ruleExpression )
            // InternalExprParser.g:10830:1: ruleExpression
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
    // InternalExprParser.g:10839:1: rule__IfExpression__IfAssignment_2 : ( ruleExpression ) ;
    public final void rule__IfExpression__IfAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10843:1: ( ( ruleExpression ) )
            // InternalExprParser.g:10844:1: ( ruleExpression )
            {
            // InternalExprParser.g:10844:1: ( ruleExpression )
            // InternalExprParser.g:10845:1: ruleExpression
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
    // InternalExprParser.g:10854:1: rule__IfExpression__ThenAssignment_4 : ( ruleExpression ) ;
    public final void rule__IfExpression__ThenAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10858:1: ( ( ruleExpression ) )
            // InternalExprParser.g:10859:1: ( ruleExpression )
            {
            // InternalExprParser.g:10859:1: ( ruleExpression )
            // InternalExprParser.g:10860:1: ruleExpression
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
    // InternalExprParser.g:10869:1: rule__IfExpression__ElseAssignment_5_1 : ( ruleExpression ) ;
    public final void rule__IfExpression__ElseAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10873:1: ( ( ruleExpression ) )
            // InternalExprParser.g:10874:1: ( ruleExpression )
            {
            // InternalExprParser.g:10874:1: ( ruleExpression )
            // InternalExprParser.g:10875:1: ruleExpression
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
    // InternalExprParser.g:10884:1: rule__BooleanLiteral__ValueAssignment_1_0 : ( ( True ) ) ;
    public final void rule__BooleanLiteral__ValueAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10888:1: ( ( ( True ) ) )
            // InternalExprParser.g:10889:1: ( ( True ) )
            {
            // InternalExprParser.g:10889:1: ( ( True ) )
            // InternalExprParser.g:10890:1: ( True )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0()); 
            }
            // InternalExprParser.g:10891:1: ( True )
            // InternalExprParser.g:10892:1: True
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
    // InternalExprParser.g:10907:1: rule__IntegerLiteral__ValueAssignment_1 : ( RULE_INTEGER_LIT ) ;
    public final void rule__IntegerLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10911:1: ( ( RULE_INTEGER_LIT ) )
            // InternalExprParser.g:10912:1: ( RULE_INTEGER_LIT )
            {
            // InternalExprParser.g:10912:1: ( RULE_INTEGER_LIT )
            // InternalExprParser.g:10913:1: RULE_INTEGER_LIT
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
    // InternalExprParser.g:10922:1: rule__RealLiteral__ValueAssignment_1 : ( RULE_REAL_LIT ) ;
    public final void rule__RealLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10926:1: ( ( RULE_REAL_LIT ) )
            // InternalExprParser.g:10927:1: ( RULE_REAL_LIT )
            {
            // InternalExprParser.g:10927:1: ( RULE_REAL_LIT )
            // InternalExprParser.g:10928:1: RULE_REAL_LIT
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
    // InternalExprParser.g:10937:1: rule__StringLiteral__ValueAssignment_1 : ( ruleNoQuoteString ) ;
    public final void rule__StringLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10941:1: ( ( ruleNoQuoteString ) )
            // InternalExprParser.g:10942:1: ( ruleNoQuoteString )
            {
            // InternalExprParser.g:10942:1: ( ruleNoQuoteString )
            // InternalExprParser.g:10943:1: ruleNoQuoteString
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
    // InternalExprParser.g:10952:1: rule__CommaSeparatedExpressions__ElementsAssignment_0 : ( ruleExpression ) ;
    public final void rule__CommaSeparatedExpressions__ElementsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10956:1: ( ( ruleExpression ) )
            // InternalExprParser.g:10957:1: ( ruleExpression )
            {
            // InternalExprParser.g:10957:1: ( ruleExpression )
            // InternalExprParser.g:10958:1: ruleExpression
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
    // InternalExprParser.g:10967:1: rule__CommaSeparatedExpressions__ElementsAssignment_1_1 : ( ruleExpression ) ;
    public final void rule__CommaSeparatedExpressions__ElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:10971:1: ( ( ruleExpression ) )
            // InternalExprParser.g:10972:1: ( ruleExpression )
            {
            // InternalExprParser.g:10972:1: ( ruleExpression )
            // InternalExprParser.g:10973:1: ruleExpression
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
            return "2150:1: rule__ComponentCategory__Alternatives : ( ( Abstract ) | ( Bus ) | ( Data ) | ( Device ) | ( Memory ) | ( Process ) | ( Processor ) | ( Subprogram ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( KW_System ) | ( ( rule__ComponentCategory__Group_10__0 ) ) | ( Thread ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( ( rule__ComponentCategory__Group_13__0 ) ) );";
        }
    }
    static final String dfa_8s = "\14\uffff";
    static final String dfa_9s = "\1\uffff\1\11\11\uffff\1\11";
    static final String dfa_10s = "\1\23\1\27\5\uffff\2\140\2\uffff\1\27";
    static final String dfa_11s = "\2\140\5\uffff\2\140\2\uffff\1\140";
    static final String dfa_12s = "\2\uffff\1\2\1\4\1\5\1\6\1\7\2\uffff\1\1\1\3\1\uffff";
    static final String dfa_13s = "\14\uffff}>";
    static final String[] dfa_14s = {
            "\1\5\5\uffff\1\5\1\uffff\2\5\4\uffff\1\5\4\uffff\1\2\1\5\3\uffff\1\5\4\uffff\1\5\2\uffff\1\5\13\uffff\1\4\4\uffff\1\2\1\uffff\1\6\14\uffff\1\3\7\uffff\1\5\1\uffff\1\5\1\uffff\1\5\1\1",
            "\2\11\6\uffff\1\11\5\uffff\1\11\4\uffff\1\11\3\uffff\1\11\2\uffff\1\11\4\uffff\2\11\1\uffff\1\11\1\7\4\11\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11\1\12\5\11\1\10\1\11\1\uffff\2\11\1\uffff\1\11\1\uffff\1\11\13\uffff\1\11",
            "",
            "",
            "",
            "",
            "",
            "\1\1",
            "\1\13",
            "",
            "",
            "\2\11\6\uffff\1\11\5\uffff\1\11\4\uffff\1\11\3\uffff\1\11\2\uffff\1\11\4\uffff\2\11\1\uffff\1\11\1\uffff\4\11\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11\1\12\5\11\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11\1\uffff\1\11\13\uffff\1\11"
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
            return "2538:1: rule__PrimaryExpression__Alternatives : ( ( ruleVarRef ) | ( ruleModelOrPropertyReference ) | ( ruleFunctionCall ) | ( ruleRangeExpression ) | ( ruleIfExpression ) | ( ruleLiteral ) | ( ( rule__PrimaryExpression__Group_6__0 ) ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0030210000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0030210000000002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0009980F787FABF0L,0x0000000100000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x000000000002C000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x800D98CF7A7FABF0L,0x00000001A8080A50L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000800820100000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000100400000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0009980F787FABF0L,0x0000000100400000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0009980F787FABF2L,0x0000000100000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0080040000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0080040000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x1040000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x1040000000000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x6800000000000000L,0x0000000000050000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x6800000000000002L,0x0000000000050000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000A00L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000A00L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0002400000000000L,0x0000000000002100L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0002400000000002L,0x0000000000002100L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0004000000000000L,0x0000000000000A00L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000021L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x800D98CF7A7FABF0L,0x00000001A8080AD0L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000800000L,0x0000000000100000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000081000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000008002000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x000908821A080000L,0x00000000A8000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0400000000000000L});

}