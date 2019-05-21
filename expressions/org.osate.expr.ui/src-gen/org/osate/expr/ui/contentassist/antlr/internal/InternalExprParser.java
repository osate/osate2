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

@SuppressWarnings("all")
public class InternalExprParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "VIRTUAL_PROCESSOR", "SUBPROGRAMGROUP", "SUBCOMPONENT", "THREAD_GROUP", "VIRTUAL_BUS", "CLASSIFIER", "CONNECTION", "SUBPROGRAM", "PROCESSOR", "Subclause", "ABSTRACT", "FEATURE", "MEMEORY", "PROCESS", "Library", "DEVICE", "SYSTEM", "THREAD", "Record", "String", "Tuple", "Union", "DATA", "FLOW", "MODE", "Bool", "List", "Real", "Type", "QuestionMarkQuestionMarkQuestionMark", "BUS", "Bag", "Def", "Int", "Map", "Set", "Val", "Var", "HyphenMinusGreaterThanSign", "ColonColon", "LeftParenthesis", "RightParenthesis", "Asterisk", "FullStop", "Colon", "Semicolon", "EqualsSign", "LeftCurlyBracket", "RightCurlyBracket", "RULE_SL_COMMENT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_REAL_LIT", "RULE_BASED_INTEGER", "RULE_INTEGER_LIT", "RULE_EXTENDED_DIGIT", "RULE_STRING", "RULE_ID", "RULE_WS"
    };
    public static final int SYSTEM=20;
    public static final int Val=40;
    public static final int CLASSIFIER=9;
    public static final int Var=41;
    public static final int MODE=28;
    public static final int String=23;
    public static final int FLOW=27;
    public static final int RULE_INT_EXPONENT=56;
    public static final int LeftParenthesis=44;
    public static final int Bool=29;
    public static final int PROCESS=17;
    public static final int Real=31;
    public static final int QuestionMarkQuestionMarkQuestionMark=33;
    public static final int SUBPROGRAMGROUP=5;
    public static final int List=30;
    public static final int RULE_BASED_INTEGER=58;
    public static final int SUBCOMPONENT=6;
    public static final int RULE_ID=62;
    public static final int PROCESSOR=12;
    public static final int DEVICE=19;
    public static final int RightParenthesis=45;
    public static final int RULE_DIGIT=54;
    public static final int ColonColon=43;
    public static final int SUBPROGRAM=11;
    public static final int DATA=26;
    public static final int FEATURE=15;
    public static final int Library=18;
    public static final int Map=38;
    public static final int RULE_INTEGER_LIT=59;
    public static final int Set=39;
    public static final int Subclause=13;
    public static final int VIRTUAL_BUS=8;
    public static final int RULE_REAL_LIT=57;
    public static final int RULE_STRING=61;
    public static final int ABSTRACT=14;
    public static final int VIRTUAL_PROCESSOR=4;
    public static final int Union=25;
    public static final int Int=37;
    public static final int RULE_SL_COMMENT=53;
    public static final int EqualsSign=50;
    public static final int Record=22;
    public static final int Colon=48;
    public static final int RightCurlyBracket=52;
    public static final int EOF=-1;
    public static final int Asterisk=46;
    public static final int BUS=34;
    public static final int FullStop=47;
    public static final int Def=36;
    public static final int RULE_WS=63;
    public static final int LeftCurlyBracket=51;
    public static final int Bag=35;
    public static final int CONNECTION=10;
    public static final int Semicolon=49;
    public static final int Type=32;
    public static final int RULE_EXPONENT=55;
    public static final int RULE_EXTENDED_DIGIT=60;
    public static final int HyphenMinusGreaterThanSign=42;
    public static final int MEMEORY=16;
    public static final int THREAD_GROUP=7;
    public static final int THREAD=21;
    public static final int Tuple=24;

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
    		tokenNameToValue.put("LeftParenthesis", "'('");
    		tokenNameToValue.put("RightParenthesis", "')'");
    		tokenNameToValue.put("FullStop", "'.'");
    		tokenNameToValue.put("Colon", "':'");
    		tokenNameToValue.put("Semicolon", "';'");
    		tokenNameToValue.put("EqualsSign", "'='");
    		tokenNameToValue.put("LeftCurlyBracket", "'{'");
    		tokenNameToValue.put("RightCurlyBracket", "'}'");
    		tokenNameToValue.put("HyphenMinusGreaterThanSign", "'->'");
    		tokenNameToValue.put("ColonColon", "'::'");
    		tokenNameToValue.put("QuestionMarkQuestionMarkQuestionMark", "'???'");
    		tokenNameToValue.put("BUS", "'BUS'");
    		tokenNameToValue.put("Bag", "'bag'");
    		tokenNameToValue.put("Def", "'def'");
    		tokenNameToValue.put("Int", "'int'");
    		tokenNameToValue.put("Map", "'map'");
    		tokenNameToValue.put("Set", "'set'");
    		tokenNameToValue.put("Val", "'val'");
    		tokenNameToValue.put("Var", "'var'");
    		tokenNameToValue.put("DATA", "'DATA'");
    		tokenNameToValue.put("FLOW", "'FLOW'");
    		tokenNameToValue.put("MODE", "'MODE'");
    		tokenNameToValue.put("Bool", "'bool'");
    		tokenNameToValue.put("List", "'list'");
    		tokenNameToValue.put("Real", "'real'");
    		tokenNameToValue.put("Type", "'type'");
    		tokenNameToValue.put("Tuple", "'tuple'");
    		tokenNameToValue.put("Union", "'union'");
    		tokenNameToValue.put("DEVICE", "'DEVICE'");
    		tokenNameToValue.put("SYSTEM", "'SYSTEM'");
    		tokenNameToValue.put("THREAD", "'THREAD'");
    		tokenNameToValue.put("Record", "'record'");
    		tokenNameToValue.put("String", "'string'");
    		tokenNameToValue.put("FEATURE", "'FEATURE'");
    		tokenNameToValue.put("MEMEORY", "'MEMEORY'");
    		tokenNameToValue.put("PROCESS", "'PROCESS'");
    		tokenNameToValue.put("Library", "'library'");
    		tokenNameToValue.put("ABSTRACT", "'ABSTRACT'");
    		tokenNameToValue.put("PROCESSOR", "'PROCESSOR'");
    		tokenNameToValue.put("Subclause", "'subclause'");
    		tokenNameToValue.put("CLASSIFIER", "'CLASSIFIER'");
    		tokenNameToValue.put("CONNECTION", "'CONNECTION'");
    		tokenNameToValue.put("SUBPROGRAM", "'SUBPROGRAM'");
    		tokenNameToValue.put("VIRTUAL_BUS", "'VIRTUAL_BUS'");
    		tokenNameToValue.put("SUBCOMPONENT", "'SUBCOMPONENT'");
    		tokenNameToValue.put("THREAD_GROUP", "'THREAD_GROUP'");
    		tokenNameToValue.put("SUBPROGRAMGROUP", "'SUBPROGRAMGROUP'");
    		tokenNameToValue.put("VIRTUAL_PROCESSOR", "'VIRTUAL_PROCESSOR'");
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
    // InternalExprParser.g:111:1: entryRuleExprModel : ruleExprModel EOF ;
    public final void entryRuleExprModel() throws RecognitionException {
        try {
            // InternalExprParser.g:112:1: ( ruleExprModel EOF )
            // InternalExprParser.g:113:1: ruleExprModel EOF
            {
             before(grammarAccess.getExprModelRule()); 
            pushFollow(FOLLOW_1);
            ruleExprModel();

            state._fsp--;

             after(grammarAccess.getExprModelRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:120:1: ruleExprModel : ( ( rule__ExprModel__Alternatives ) ) ;
    public final void ruleExprModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:124:5: ( ( ( rule__ExprModel__Alternatives ) ) )
            // InternalExprParser.g:125:1: ( ( rule__ExprModel__Alternatives ) )
            {
            // InternalExprParser.g:125:1: ( ( rule__ExprModel__Alternatives ) )
            // InternalExprParser.g:126:1: ( rule__ExprModel__Alternatives )
            {
             before(grammarAccess.getExprModelAccess().getAlternatives()); 
            // InternalExprParser.g:127:1: ( rule__ExprModel__Alternatives )
            // InternalExprParser.g:127:2: rule__ExprModel__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ExprModel__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getExprModelAccess().getAlternatives()); 

            }


            }

        }
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
    // InternalExprParser.g:139:1: entryRuleExprLibrary : ruleExprLibrary EOF ;
    public final void entryRuleExprLibrary() throws RecognitionException {
        try {
            // InternalExprParser.g:140:1: ( ruleExprLibrary EOF )
            // InternalExprParser.g:141:1: ruleExprLibrary EOF
            {
             before(grammarAccess.getExprLibraryRule()); 
            pushFollow(FOLLOW_1);
            ruleExprLibrary();

            state._fsp--;

             after(grammarAccess.getExprLibraryRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:148:1: ruleExprLibrary : ( ( rule__ExprLibrary__Group__0 ) ) ;
    public final void ruleExprLibrary() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:152:5: ( ( ( rule__ExprLibrary__Group__0 ) ) )
            // InternalExprParser.g:153:1: ( ( rule__ExprLibrary__Group__0 ) )
            {
            // InternalExprParser.g:153:1: ( ( rule__ExprLibrary__Group__0 ) )
            // InternalExprParser.g:154:1: ( rule__ExprLibrary__Group__0 )
            {
             before(grammarAccess.getExprLibraryAccess().getGroup()); 
            // InternalExprParser.g:155:1: ( rule__ExprLibrary__Group__0 )
            // InternalExprParser.g:155:2: rule__ExprLibrary__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ExprLibrary__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExprLibraryAccess().getGroup()); 

            }


            }

        }
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
    // InternalExprParser.g:167:1: entryRuleExprSubclause : ruleExprSubclause EOF ;
    public final void entryRuleExprSubclause() throws RecognitionException {
        try {
            // InternalExprParser.g:168:1: ( ruleExprSubclause EOF )
            // InternalExprParser.g:169:1: ruleExprSubclause EOF
            {
             before(grammarAccess.getExprSubclauseRule()); 
            pushFollow(FOLLOW_1);
            ruleExprSubclause();

            state._fsp--;

             after(grammarAccess.getExprSubclauseRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:176:1: ruleExprSubclause : ( ( rule__ExprSubclause__Group__0 ) ) ;
    public final void ruleExprSubclause() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:180:5: ( ( ( rule__ExprSubclause__Group__0 ) ) )
            // InternalExprParser.g:181:1: ( ( rule__ExprSubclause__Group__0 ) )
            {
            // InternalExprParser.g:181:1: ( ( rule__ExprSubclause__Group__0 ) )
            // InternalExprParser.g:182:1: ( rule__ExprSubclause__Group__0 )
            {
             before(grammarAccess.getExprSubclauseAccess().getGroup()); 
            // InternalExprParser.g:183:1: ( rule__ExprSubclause__Group__0 )
            // InternalExprParser.g:183:2: rule__ExprSubclause__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ExprSubclause__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExprSubclauseAccess().getGroup()); 

            }


            }

        }
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
    // InternalExprParser.g:197:1: entryRuleDeclaration : ruleDeclaration EOF ;
    public final void entryRuleDeclaration() throws RecognitionException {
        try {
            // InternalExprParser.g:198:1: ( ruleDeclaration EOF )
            // InternalExprParser.g:199:1: ruleDeclaration EOF
            {
             before(grammarAccess.getDeclarationRule()); 
            pushFollow(FOLLOW_1);
            ruleDeclaration();

            state._fsp--;

             after(grammarAccess.getDeclarationRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:206:1: ruleDeclaration : ( ( rule__Declaration__Alternatives ) ) ;
    public final void ruleDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:210:5: ( ( ( rule__Declaration__Alternatives ) ) )
            // InternalExprParser.g:211:1: ( ( rule__Declaration__Alternatives ) )
            {
            // InternalExprParser.g:211:1: ( ( rule__Declaration__Alternatives ) )
            // InternalExprParser.g:212:1: ( rule__Declaration__Alternatives )
            {
             before(grammarAccess.getDeclarationAccess().getAlternatives()); 
            // InternalExprParser.g:213:1: ( rule__Declaration__Alternatives )
            // InternalExprParser.g:213:2: rule__Declaration__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Declaration__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDeclarationAccess().getAlternatives()); 

            }


            }

        }
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
    // InternalExprParser.g:225:1: entryRuleTypeDecl : ruleTypeDecl EOF ;
    public final void entryRuleTypeDecl() throws RecognitionException {
        try {
            // InternalExprParser.g:226:1: ( ruleTypeDecl EOF )
            // InternalExprParser.g:227:1: ruleTypeDecl EOF
            {
             before(grammarAccess.getTypeDeclRule()); 
            pushFollow(FOLLOW_1);
            ruleTypeDecl();

            state._fsp--;

             after(grammarAccess.getTypeDeclRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:234:1: ruleTypeDecl : ( ( rule__TypeDecl__Group__0 ) ) ;
    public final void ruleTypeDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:238:5: ( ( ( rule__TypeDecl__Group__0 ) ) )
            // InternalExprParser.g:239:1: ( ( rule__TypeDecl__Group__0 ) )
            {
            // InternalExprParser.g:239:1: ( ( rule__TypeDecl__Group__0 ) )
            // InternalExprParser.g:240:1: ( rule__TypeDecl__Group__0 )
            {
             before(grammarAccess.getTypeDeclAccess().getGroup()); 
            // InternalExprParser.g:241:1: ( rule__TypeDecl__Group__0 )
            // InternalExprParser.g:241:2: rule__TypeDecl__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TypeDecl__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTypeDeclAccess().getGroup()); 

            }


            }

        }
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
    // InternalExprParser.g:253:1: entryRuleVarDecl : ruleVarDecl EOF ;
    public final void entryRuleVarDecl() throws RecognitionException {
        try {
            // InternalExprParser.g:254:1: ( ruleVarDecl EOF )
            // InternalExprParser.g:255:1: ruleVarDecl EOF
            {
             before(grammarAccess.getVarDeclRule()); 
            pushFollow(FOLLOW_1);
            ruleVarDecl();

            state._fsp--;

             after(grammarAccess.getVarDeclRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:262:1: ruleVarDecl : ( ( rule__VarDecl__Group__0 ) ) ;
    public final void ruleVarDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:266:5: ( ( ( rule__VarDecl__Group__0 ) ) )
            // InternalExprParser.g:267:1: ( ( rule__VarDecl__Group__0 ) )
            {
            // InternalExprParser.g:267:1: ( ( rule__VarDecl__Group__0 ) )
            // InternalExprParser.g:268:1: ( rule__VarDecl__Group__0 )
            {
             before(grammarAccess.getVarDeclAccess().getGroup()); 
            // InternalExprParser.g:269:1: ( rule__VarDecl__Group__0 )
            // InternalExprParser.g:269:2: rule__VarDecl__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__VarDecl__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVarDeclAccess().getGroup()); 

            }


            }

        }
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
    // InternalExprParser.g:281:1: entryRuleFunDecl : ruleFunDecl EOF ;
    public final void entryRuleFunDecl() throws RecognitionException {
        try {
            // InternalExprParser.g:282:1: ( ruleFunDecl EOF )
            // InternalExprParser.g:283:1: ruleFunDecl EOF
            {
             before(grammarAccess.getFunDeclRule()); 
            pushFollow(FOLLOW_1);
            ruleFunDecl();

            state._fsp--;

             after(grammarAccess.getFunDeclRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:290:1: ruleFunDecl : ( ( rule__FunDecl__Group__0 ) ) ;
    public final void ruleFunDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:294:5: ( ( ( rule__FunDecl__Group__0 ) ) )
            // InternalExprParser.g:295:1: ( ( rule__FunDecl__Group__0 ) )
            {
            // InternalExprParser.g:295:1: ( ( rule__FunDecl__Group__0 ) )
            // InternalExprParser.g:296:1: ( rule__FunDecl__Group__0 )
            {
             before(grammarAccess.getFunDeclAccess().getGroup()); 
            // InternalExprParser.g:297:1: ( rule__FunDecl__Group__0 )
            // InternalExprParser.g:297:2: rule__FunDecl__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FunDecl__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFunDeclAccess().getGroup()); 

            }


            }

        }
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
    // InternalExprParser.g:309:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // InternalExprParser.g:310:1: ( ruleType EOF )
            // InternalExprParser.g:311:1: ruleType EOF
            {
             before(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleType();

            state._fsp--;

             after(grammarAccess.getTypeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:318:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:322:5: ( ( ( rule__Type__Alternatives ) ) )
            // InternalExprParser.g:323:1: ( ( rule__Type__Alternatives ) )
            {
            // InternalExprParser.g:323:1: ( ( rule__Type__Alternatives ) )
            // InternalExprParser.g:324:1: ( rule__Type__Alternatives )
            {
             before(grammarAccess.getTypeAccess().getAlternatives()); 
            // InternalExprParser.g:325:1: ( rule__Type__Alternatives )
            // InternalExprParser.g:325:2: rule__Type__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Type__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getAlternatives()); 

            }


            }

        }
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
    // InternalExprParser.g:337:1: entryRulePrimitiveType : rulePrimitiveType EOF ;
    public final void entryRulePrimitiveType() throws RecognitionException {
        try {
            // InternalExprParser.g:338:1: ( rulePrimitiveType EOF )
            // InternalExprParser.g:339:1: rulePrimitiveType EOF
            {
             before(grammarAccess.getPrimitiveTypeRule()); 
            pushFollow(FOLLOW_1);
            rulePrimitiveType();

            state._fsp--;

             after(grammarAccess.getPrimitiveTypeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:346:1: rulePrimitiveType : ( ( rule__PrimitiveType__Alternatives ) ) ;
    public final void rulePrimitiveType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:350:5: ( ( ( rule__PrimitiveType__Alternatives ) ) )
            // InternalExprParser.g:351:1: ( ( rule__PrimitiveType__Alternatives ) )
            {
            // InternalExprParser.g:351:1: ( ( rule__PrimitiveType__Alternatives ) )
            // InternalExprParser.g:352:1: ( rule__PrimitiveType__Alternatives )
            {
             before(grammarAccess.getPrimitiveTypeAccess().getAlternatives()); 
            // InternalExprParser.g:353:1: ( rule__PrimitiveType__Alternatives )
            // InternalExprParser.g:353:2: rule__PrimitiveType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimitiveTypeAccess().getAlternatives()); 

            }


            }

        }
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
    // InternalExprParser.g:365:1: entryRuleCategory : ruleCategory EOF ;
    public final void entryRuleCategory() throws RecognitionException {
        try {
            // InternalExprParser.g:366:1: ( ruleCategory EOF )
            // InternalExprParser.g:367:1: ruleCategory EOF
            {
             before(grammarAccess.getCategoryRule()); 
            pushFollow(FOLLOW_1);
            ruleCategory();

            state._fsp--;

             after(grammarAccess.getCategoryRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:374:1: ruleCategory : ( ( rule__Category__CategoryAssignment ) ) ;
    public final void ruleCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:378:5: ( ( ( rule__Category__CategoryAssignment ) ) )
            // InternalExprParser.g:379:1: ( ( rule__Category__CategoryAssignment ) )
            {
            // InternalExprParser.g:379:1: ( ( rule__Category__CategoryAssignment ) )
            // InternalExprParser.g:380:1: ( rule__Category__CategoryAssignment )
            {
             before(grammarAccess.getCategoryAccess().getCategoryAssignment()); 
            // InternalExprParser.g:381:1: ( rule__Category__CategoryAssignment )
            // InternalExprParser.g:381:2: rule__Category__CategoryAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Category__CategoryAssignment();

            state._fsp--;


            }

             after(grammarAccess.getCategoryAccess().getCategoryAssignment()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleMetaClass"
    // InternalExprParser.g:393:1: entryRuleMetaClass : ruleMetaClass EOF ;
    public final void entryRuleMetaClass() throws RecognitionException {
        try {
            // InternalExprParser.g:394:1: ( ruleMetaClass EOF )
            // InternalExprParser.g:395:1: ruleMetaClass EOF
            {
             before(grammarAccess.getMetaClassRule()); 
            pushFollow(FOLLOW_1);
            ruleMetaClass();

            state._fsp--;

             after(grammarAccess.getMetaClassRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:402:1: ruleMetaClass : ( ( rule__MetaClass__ClassAssignment ) ) ;
    public final void ruleMetaClass() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:406:5: ( ( ( rule__MetaClass__ClassAssignment ) ) )
            // InternalExprParser.g:407:1: ( ( rule__MetaClass__ClassAssignment ) )
            {
            // InternalExprParser.g:407:1: ( ( rule__MetaClass__ClassAssignment ) )
            // InternalExprParser.g:408:1: ( rule__MetaClass__ClassAssignment )
            {
             before(grammarAccess.getMetaClassAccess().getClassAssignment()); 
            // InternalExprParser.g:409:1: ( rule__MetaClass__ClassAssignment )
            // InternalExprParser.g:409:2: rule__MetaClass__ClassAssignment
            {
            pushFollow(FOLLOW_2);
            rule__MetaClass__ClassAssignment();

            state._fsp--;


            }

             after(grammarAccess.getMetaClassAccess().getClassAssignment()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleRecordType"
    // InternalExprParser.g:421:1: entryRuleRecordType : ruleRecordType EOF ;
    public final void entryRuleRecordType() throws RecognitionException {
        try {
            // InternalExprParser.g:422:1: ( ruleRecordType EOF )
            // InternalExprParser.g:423:1: ruleRecordType EOF
            {
             before(grammarAccess.getRecordTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleRecordType();

            state._fsp--;

             after(grammarAccess.getRecordTypeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:430:1: ruleRecordType : ( ( rule__RecordType__Group__0 ) ) ;
    public final void ruleRecordType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:434:5: ( ( ( rule__RecordType__Group__0 ) ) )
            // InternalExprParser.g:435:1: ( ( rule__RecordType__Group__0 ) )
            {
            // InternalExprParser.g:435:1: ( ( rule__RecordType__Group__0 ) )
            // InternalExprParser.g:436:1: ( rule__RecordType__Group__0 )
            {
             before(grammarAccess.getRecordTypeAccess().getGroup()); 
            // InternalExprParser.g:437:1: ( rule__RecordType__Group__0 )
            // InternalExprParser.g:437:2: rule__RecordType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RecordType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRecordTypeAccess().getGroup()); 

            }


            }

        }
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
    // InternalExprParser.g:449:1: entryRuleField : ruleField EOF ;
    public final void entryRuleField() throws RecognitionException {
        try {
            // InternalExprParser.g:450:1: ( ruleField EOF )
            // InternalExprParser.g:451:1: ruleField EOF
            {
             before(grammarAccess.getFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleField();

            state._fsp--;

             after(grammarAccess.getFieldRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:458:1: ruleField : ( ( rule__Field__Group__0 ) ) ;
    public final void ruleField() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:462:5: ( ( ( rule__Field__Group__0 ) ) )
            // InternalExprParser.g:463:1: ( ( rule__Field__Group__0 ) )
            {
            // InternalExprParser.g:463:1: ( ( rule__Field__Group__0 ) )
            // InternalExprParser.g:464:1: ( rule__Field__Group__0 )
            {
             before(grammarAccess.getFieldAccess().getGroup()); 
            // InternalExprParser.g:465:1: ( rule__Field__Group__0 )
            // InternalExprParser.g:465:2: rule__Field__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Field__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFieldAccess().getGroup()); 

            }


            }

        }
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
    // InternalExprParser.g:477:1: entryRuleUnionType : ruleUnionType EOF ;
    public final void entryRuleUnionType() throws RecognitionException {
        try {
            // InternalExprParser.g:478:1: ( ruleUnionType EOF )
            // InternalExprParser.g:479:1: ruleUnionType EOF
            {
             before(grammarAccess.getUnionTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleUnionType();

            state._fsp--;

             after(grammarAccess.getUnionTypeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:486:1: ruleUnionType : ( ( rule__UnionType__Group__0 ) ) ;
    public final void ruleUnionType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:490:5: ( ( ( rule__UnionType__Group__0 ) ) )
            // InternalExprParser.g:491:1: ( ( rule__UnionType__Group__0 ) )
            {
            // InternalExprParser.g:491:1: ( ( rule__UnionType__Group__0 ) )
            // InternalExprParser.g:492:1: ( rule__UnionType__Group__0 )
            {
             before(grammarAccess.getUnionTypeAccess().getGroup()); 
            // InternalExprParser.g:493:1: ( rule__UnionType__Group__0 )
            // InternalExprParser.g:493:2: rule__UnionType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__UnionType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUnionTypeAccess().getGroup()); 

            }


            }

        }
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
    // InternalExprParser.g:505:1: entryRuleTupleType : ruleTupleType EOF ;
    public final void entryRuleTupleType() throws RecognitionException {
        try {
            // InternalExprParser.g:506:1: ( ruleTupleType EOF )
            // InternalExprParser.g:507:1: ruleTupleType EOF
            {
             before(grammarAccess.getTupleTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleTupleType();

            state._fsp--;

             after(grammarAccess.getTupleTypeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:514:1: ruleTupleType : ( ( rule__TupleType__Group__0 ) ) ;
    public final void ruleTupleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:518:5: ( ( ( rule__TupleType__Group__0 ) ) )
            // InternalExprParser.g:519:1: ( ( rule__TupleType__Group__0 ) )
            {
            // InternalExprParser.g:519:1: ( ( rule__TupleType__Group__0 ) )
            // InternalExprParser.g:520:1: ( rule__TupleType__Group__0 )
            {
             before(grammarAccess.getTupleTypeAccess().getGroup()); 
            // InternalExprParser.g:521:1: ( rule__TupleType__Group__0 )
            // InternalExprParser.g:521:2: rule__TupleType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TupleType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTupleTypeAccess().getGroup()); 

            }


            }

        }
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
    // InternalExprParser.g:533:1: entryRuleTupleField : ruleTupleField EOF ;
    public final void entryRuleTupleField() throws RecognitionException {
        try {
            // InternalExprParser.g:534:1: ( ruleTupleField EOF )
            // InternalExprParser.g:535:1: ruleTupleField EOF
            {
             before(grammarAccess.getTupleFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleTupleField();

            state._fsp--;

             after(grammarAccess.getTupleFieldRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:542:1: ruleTupleField : ( ( rule__TupleField__Group__0 ) ) ;
    public final void ruleTupleField() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:546:5: ( ( ( rule__TupleField__Group__0 ) ) )
            // InternalExprParser.g:547:1: ( ( rule__TupleField__Group__0 ) )
            {
            // InternalExprParser.g:547:1: ( ( rule__TupleField__Group__0 ) )
            // InternalExprParser.g:548:1: ( rule__TupleField__Group__0 )
            {
             before(grammarAccess.getTupleFieldAccess().getGroup()); 
            // InternalExprParser.g:549:1: ( rule__TupleField__Group__0 )
            // InternalExprParser.g:549:2: rule__TupleField__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TupleField__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTupleFieldAccess().getGroup()); 

            }


            }

        }
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
    // InternalExprParser.g:561:1: entryRuleListType : ruleListType EOF ;
    public final void entryRuleListType() throws RecognitionException {
        try {
            // InternalExprParser.g:562:1: ( ruleListType EOF )
            // InternalExprParser.g:563:1: ruleListType EOF
            {
             before(grammarAccess.getListTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleListType();

            state._fsp--;

             after(grammarAccess.getListTypeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:570:1: ruleListType : ( ( rule__ListType__Group__0 ) ) ;
    public final void ruleListType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:574:5: ( ( ( rule__ListType__Group__0 ) ) )
            // InternalExprParser.g:575:1: ( ( rule__ListType__Group__0 ) )
            {
            // InternalExprParser.g:575:1: ( ( rule__ListType__Group__0 ) )
            // InternalExprParser.g:576:1: ( rule__ListType__Group__0 )
            {
             before(grammarAccess.getListTypeAccess().getGroup()); 
            // InternalExprParser.g:577:1: ( rule__ListType__Group__0 )
            // InternalExprParser.g:577:2: rule__ListType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ListType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getListTypeAccess().getGroup()); 

            }


            }

        }
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
    // InternalExprParser.g:589:1: entryRuleSetType : ruleSetType EOF ;
    public final void entryRuleSetType() throws RecognitionException {
        try {
            // InternalExprParser.g:590:1: ( ruleSetType EOF )
            // InternalExprParser.g:591:1: ruleSetType EOF
            {
             before(grammarAccess.getSetTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleSetType();

            state._fsp--;

             after(grammarAccess.getSetTypeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:598:1: ruleSetType : ( ( rule__SetType__Group__0 ) ) ;
    public final void ruleSetType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:602:5: ( ( ( rule__SetType__Group__0 ) ) )
            // InternalExprParser.g:603:1: ( ( rule__SetType__Group__0 ) )
            {
            // InternalExprParser.g:603:1: ( ( rule__SetType__Group__0 ) )
            // InternalExprParser.g:604:1: ( rule__SetType__Group__0 )
            {
             before(grammarAccess.getSetTypeAccess().getGroup()); 
            // InternalExprParser.g:605:1: ( rule__SetType__Group__0 )
            // InternalExprParser.g:605:2: rule__SetType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SetType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSetTypeAccess().getGroup()); 

            }


            }

        }
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
    // InternalExprParser.g:617:1: entryRuleBagType : ruleBagType EOF ;
    public final void entryRuleBagType() throws RecognitionException {
        try {
            // InternalExprParser.g:618:1: ( ruleBagType EOF )
            // InternalExprParser.g:619:1: ruleBagType EOF
            {
             before(grammarAccess.getBagTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleBagType();

            state._fsp--;

             after(grammarAccess.getBagTypeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:626:1: ruleBagType : ( ( rule__BagType__Group__0 ) ) ;
    public final void ruleBagType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:630:5: ( ( ( rule__BagType__Group__0 ) ) )
            // InternalExprParser.g:631:1: ( ( rule__BagType__Group__0 ) )
            {
            // InternalExprParser.g:631:1: ( ( rule__BagType__Group__0 ) )
            // InternalExprParser.g:632:1: ( rule__BagType__Group__0 )
            {
             before(grammarAccess.getBagTypeAccess().getGroup()); 
            // InternalExprParser.g:633:1: ( rule__BagType__Group__0 )
            // InternalExprParser.g:633:2: rule__BagType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BagType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBagTypeAccess().getGroup()); 

            }


            }

        }
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
    // InternalExprParser.g:645:1: entryRuleMapType : ruleMapType EOF ;
    public final void entryRuleMapType() throws RecognitionException {
        try {
            // InternalExprParser.g:646:1: ( ruleMapType EOF )
            // InternalExprParser.g:647:1: ruleMapType EOF
            {
             before(grammarAccess.getMapTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleMapType();

            state._fsp--;

             after(grammarAccess.getMapTypeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:654:1: ruleMapType : ( ( rule__MapType__Group__0 ) ) ;
    public final void ruleMapType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:658:5: ( ( ( rule__MapType__Group__0 ) ) )
            // InternalExprParser.g:659:1: ( ( rule__MapType__Group__0 ) )
            {
            // InternalExprParser.g:659:1: ( ( rule__MapType__Group__0 ) )
            // InternalExprParser.g:660:1: ( rule__MapType__Group__0 )
            {
             before(grammarAccess.getMapTypeAccess().getGroup()); 
            // InternalExprParser.g:661:1: ( rule__MapType__Group__0 )
            // InternalExprParser.g:661:2: rule__MapType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MapType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMapTypeAccess().getGroup()); 

            }


            }

        }
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
    // InternalExprParser.g:673:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // InternalExprParser.g:674:1: ( ruleTypeRef EOF )
            // InternalExprParser.g:675:1: ruleTypeRef EOF
            {
             before(grammarAccess.getTypeRefRule()); 
            pushFollow(FOLLOW_1);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getTypeRefRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:682:1: ruleTypeRef : ( ( rule__TypeRef__RefAssignment ) ) ;
    public final void ruleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:686:5: ( ( ( rule__TypeRef__RefAssignment ) ) )
            // InternalExprParser.g:687:1: ( ( rule__TypeRef__RefAssignment ) )
            {
            // InternalExprParser.g:687:1: ( ( rule__TypeRef__RefAssignment ) )
            // InternalExprParser.g:688:1: ( rule__TypeRef__RefAssignment )
            {
             before(grammarAccess.getTypeRefAccess().getRefAssignment()); 
            // InternalExprParser.g:689:1: ( rule__TypeRef__RefAssignment )
            // InternalExprParser.g:689:2: rule__TypeRef__RefAssignment
            {
            pushFollow(FOLLOW_2);
            rule__TypeRef__RefAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTypeRefAccess().getRefAssignment()); 

            }


            }

        }
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
    // InternalExprParser.g:701:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // InternalExprParser.g:702:1: ( ruleExpression EOF )
            // InternalExprParser.g:703:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:710:1: ruleExpression : ( QuestionMarkQuestionMarkQuestionMark ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:714:5: ( ( QuestionMarkQuestionMarkQuestionMark ) )
            // InternalExprParser.g:715:1: ( QuestionMarkQuestionMarkQuestionMark )
            {
            // InternalExprParser.g:715:1: ( QuestionMarkQuestionMarkQuestionMark )
            // InternalExprParser.g:716:1: QuestionMarkQuestionMarkQuestionMark
            {
             before(grammarAccess.getExpressionAccess().getQuestionMarkQuestionMarkQuestionMarkKeyword()); 
            match(input,QuestionMarkQuestionMarkQuestionMark,FOLLOW_2); 
             after(grammarAccess.getExpressionAccess().getQuestionMarkQuestionMarkQuestionMarkKeyword()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleQCREF"
    // InternalExprParser.g:737:1: entryRuleQCREF : ruleQCREF EOF ;
    public final void entryRuleQCREF() throws RecognitionException {
        try {
            // InternalExprParser.g:738:1: ( ruleQCREF EOF )
            // InternalExprParser.g:739:1: ruleQCREF EOF
            {
             before(grammarAccess.getQCREFRule()); 
            pushFollow(FOLLOW_1);
            ruleQCREF();

            state._fsp--;

             after(grammarAccess.getQCREFRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExprParser.g:746:1: ruleQCREF : ( ( rule__QCREF__Group__0 ) ) ;
    public final void ruleQCREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:750:5: ( ( ( rule__QCREF__Group__0 ) ) )
            // InternalExprParser.g:751:1: ( ( rule__QCREF__Group__0 ) )
            {
            // InternalExprParser.g:751:1: ( ( rule__QCREF__Group__0 ) )
            // InternalExprParser.g:752:1: ( rule__QCREF__Group__0 )
            {
             before(grammarAccess.getQCREFAccess().getGroup()); 
            // InternalExprParser.g:753:1: ( rule__QCREF__Group__0 )
            // InternalExprParser.g:753:2: rule__QCREF__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QCREF__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQCREFAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start "ruleCategoryEnum"
    // InternalExprParser.g:768:1: ruleCategoryEnum : ( ( rule__CategoryEnum__Alternatives ) ) ;
    public final void ruleCategoryEnum() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:772:1: ( ( ( rule__CategoryEnum__Alternatives ) ) )
            // InternalExprParser.g:773:1: ( ( rule__CategoryEnum__Alternatives ) )
            {
            // InternalExprParser.g:773:1: ( ( rule__CategoryEnum__Alternatives ) )
            // InternalExprParser.g:774:1: ( rule__CategoryEnum__Alternatives )
            {
             before(grammarAccess.getCategoryEnumAccess().getAlternatives()); 
            // InternalExprParser.g:775:1: ( rule__CategoryEnum__Alternatives )
            // InternalExprParser.g:775:2: rule__CategoryEnum__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__CategoryEnum__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getCategoryEnumAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCategoryEnum"


    // $ANTLR start "ruleMetaClassEnum"
    // InternalExprParser.g:787:1: ruleMetaClassEnum : ( ( rule__MetaClassEnum__Alternatives ) ) ;
    public final void ruleMetaClassEnum() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:791:1: ( ( ( rule__MetaClassEnum__Alternatives ) ) )
            // InternalExprParser.g:792:1: ( ( rule__MetaClassEnum__Alternatives ) )
            {
            // InternalExprParser.g:792:1: ( ( rule__MetaClassEnum__Alternatives ) )
            // InternalExprParser.g:793:1: ( rule__MetaClassEnum__Alternatives )
            {
             before(grammarAccess.getMetaClassEnumAccess().getAlternatives()); 
            // InternalExprParser.g:794:1: ( rule__MetaClassEnum__Alternatives )
            // InternalExprParser.g:794:2: rule__MetaClassEnum__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__MetaClassEnum__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMetaClassEnumAccess().getAlternatives()); 

            }


            }

        }
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
    // InternalExprParser.g:805:1: rule__ExprModel__Alternatives : ( ( ( rule__ExprModel__Group_0__0 ) ) | ( ( rule__ExprModel__Group_1__0 ) ) );
    public final void rule__ExprModel__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:809:1: ( ( ( rule__ExprModel__Group_0__0 ) ) | ( ( rule__ExprModel__Group_1__0 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==Library) ) {
                alt1=1;
            }
            else if ( (LA1_0==Subclause) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalExprParser.g:810:1: ( ( rule__ExprModel__Group_0__0 ) )
                    {
                    // InternalExprParser.g:810:1: ( ( rule__ExprModel__Group_0__0 ) )
                    // InternalExprParser.g:811:1: ( rule__ExprModel__Group_0__0 )
                    {
                     before(grammarAccess.getExprModelAccess().getGroup_0()); 
                    // InternalExprParser.g:812:1: ( rule__ExprModel__Group_0__0 )
                    // InternalExprParser.g:812:2: rule__ExprModel__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExprModel__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getExprModelAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:816:6: ( ( rule__ExprModel__Group_1__0 ) )
                    {
                    // InternalExprParser.g:816:6: ( ( rule__ExprModel__Group_1__0 ) )
                    // InternalExprParser.g:817:1: ( rule__ExprModel__Group_1__0 )
                    {
                     before(grammarAccess.getExprModelAccess().getGroup_1()); 
                    // InternalExprParser.g:818:1: ( rule__ExprModel__Group_1__0 )
                    // InternalExprParser.g:818:2: rule__ExprModel__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExprModel__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getExprModelAccess().getGroup_1()); 

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
    // InternalExprParser.g:827:1: rule__Declaration__Alternatives : ( ( ruleTypeDecl ) | ( ruleVarDecl ) | ( ruleFunDecl ) );
    public final void rule__Declaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:831:1: ( ( ruleTypeDecl ) | ( ruleVarDecl ) | ( ruleFunDecl ) )
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
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalExprParser.g:832:1: ( ruleTypeDecl )
                    {
                    // InternalExprParser.g:832:1: ( ruleTypeDecl )
                    // InternalExprParser.g:833:1: ruleTypeDecl
                    {
                     before(grammarAccess.getDeclarationAccess().getTypeDeclParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleTypeDecl();

                    state._fsp--;

                     after(grammarAccess.getDeclarationAccess().getTypeDeclParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:838:6: ( ruleVarDecl )
                    {
                    // InternalExprParser.g:838:6: ( ruleVarDecl )
                    // InternalExprParser.g:839:1: ruleVarDecl
                    {
                     before(grammarAccess.getDeclarationAccess().getVarDeclParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleVarDecl();

                    state._fsp--;

                     after(grammarAccess.getDeclarationAccess().getVarDeclParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalExprParser.g:844:6: ( ruleFunDecl )
                    {
                    // InternalExprParser.g:844:6: ( ruleFunDecl )
                    // InternalExprParser.g:845:1: ruleFunDecl
                    {
                     before(grammarAccess.getDeclarationAccess().getFunDeclParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleFunDecl();

                    state._fsp--;

                     after(grammarAccess.getDeclarationAccess().getFunDeclParserRuleCall_2()); 

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
    // InternalExprParser.g:855:1: rule__VarDecl__Alternatives_0 : ( ( ( rule__VarDecl__ConstAssignment_0_0 ) ) | ( Var ) );
    public final void rule__VarDecl__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:859:1: ( ( ( rule__VarDecl__ConstAssignment_0_0 ) ) | ( Var ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Val) ) {
                alt3=1;
            }
            else if ( (LA3_0==Var) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalExprParser.g:860:1: ( ( rule__VarDecl__ConstAssignment_0_0 ) )
                    {
                    // InternalExprParser.g:860:1: ( ( rule__VarDecl__ConstAssignment_0_0 ) )
                    // InternalExprParser.g:861:1: ( rule__VarDecl__ConstAssignment_0_0 )
                    {
                     before(grammarAccess.getVarDeclAccess().getConstAssignment_0_0()); 
                    // InternalExprParser.g:862:1: ( rule__VarDecl__ConstAssignment_0_0 )
                    // InternalExprParser.g:862:2: rule__VarDecl__ConstAssignment_0_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VarDecl__ConstAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVarDeclAccess().getConstAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:866:6: ( Var )
                    {
                    // InternalExprParser.g:866:6: ( Var )
                    // InternalExprParser.g:867:1: Var
                    {
                     before(grammarAccess.getVarDeclAccess().getVarKeyword_0_1()); 
                    match(input,Var,FOLLOW_2); 
                     after(grammarAccess.getVarDeclAccess().getVarKeyword_0_1()); 

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
    // InternalExprParser.g:879:1: rule__Type__Alternatives : ( ( rulePrimitiveType ) | ( ruleCategory ) | ( ruleMetaClass ) | ( ruleRecordType ) | ( ruleUnionType ) | ( ruleTupleType ) | ( ruleListType ) | ( ruleSetType ) | ( ruleBagType ) | ( ruleMapType ) | ( ruleTypeRef ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:883:1: ( ( rulePrimitiveType ) | ( ruleCategory ) | ( ruleMetaClass ) | ( ruleRecordType ) | ( ruleUnionType ) | ( ruleTupleType ) | ( ruleListType ) | ( ruleSetType ) | ( ruleBagType ) | ( ruleMapType ) | ( ruleTypeRef ) )
            int alt4=11;
            switch ( input.LA(1) ) {
            case String:
            case Bool:
            case Real:
            case Int:
                {
                alt4=1;
                }
                break;
            case VIRTUAL_PROCESSOR:
            case SUBPROGRAMGROUP:
            case THREAD_GROUP:
            case VIRTUAL_BUS:
            case SUBPROGRAM:
            case PROCESSOR:
            case ABSTRACT:
            case MEMEORY:
            case PROCESS:
            case DEVICE:
            case SYSTEM:
            case THREAD:
            case DATA:
            case BUS:
                {
                alt4=2;
                }
                break;
            case SUBCOMPONENT:
            case CLASSIFIER:
            case CONNECTION:
            case FEATURE:
            case FLOW:
            case MODE:
                {
                alt4=3;
                }
                break;
            case Record:
                {
                alt4=4;
                }
                break;
            case Union:
                {
                alt4=5;
                }
                break;
            case Tuple:
                {
                alt4=6;
                }
                break;
            case List:
                {
                alt4=7;
                }
                break;
            case Set:
                {
                alt4=8;
                }
                break;
            case Bag:
                {
                alt4=9;
                }
                break;
            case Map:
                {
                alt4=10;
                }
                break;
            case RULE_ID:
                {
                alt4=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalExprParser.g:884:1: ( rulePrimitiveType )
                    {
                    // InternalExprParser.g:884:1: ( rulePrimitiveType )
                    // InternalExprParser.g:885:1: rulePrimitiveType
                    {
                     before(grammarAccess.getTypeAccess().getPrimitiveTypeParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    rulePrimitiveType();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getPrimitiveTypeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:890:6: ( ruleCategory )
                    {
                    // InternalExprParser.g:890:6: ( ruleCategory )
                    // InternalExprParser.g:891:1: ruleCategory
                    {
                     before(grammarAccess.getTypeAccess().getCategoryParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleCategory();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getCategoryParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalExprParser.g:896:6: ( ruleMetaClass )
                    {
                    // InternalExprParser.g:896:6: ( ruleMetaClass )
                    // InternalExprParser.g:897:1: ruleMetaClass
                    {
                     before(grammarAccess.getTypeAccess().getMetaClassParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleMetaClass();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getMetaClassParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalExprParser.g:902:6: ( ruleRecordType )
                    {
                    // InternalExprParser.g:902:6: ( ruleRecordType )
                    // InternalExprParser.g:903:1: ruleRecordType
                    {
                     before(grammarAccess.getTypeAccess().getRecordTypeParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleRecordType();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getRecordTypeParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalExprParser.g:908:6: ( ruleUnionType )
                    {
                    // InternalExprParser.g:908:6: ( ruleUnionType )
                    // InternalExprParser.g:909:1: ruleUnionType
                    {
                     before(grammarAccess.getTypeAccess().getUnionTypeParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleUnionType();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getUnionTypeParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalExprParser.g:914:6: ( ruleTupleType )
                    {
                    // InternalExprParser.g:914:6: ( ruleTupleType )
                    // InternalExprParser.g:915:1: ruleTupleType
                    {
                     before(grammarAccess.getTypeAccess().getTupleTypeParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleTupleType();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getTupleTypeParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalExprParser.g:920:6: ( ruleListType )
                    {
                    // InternalExprParser.g:920:6: ( ruleListType )
                    // InternalExprParser.g:921:1: ruleListType
                    {
                     before(grammarAccess.getTypeAccess().getListTypeParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    ruleListType();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getListTypeParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalExprParser.g:926:6: ( ruleSetType )
                    {
                    // InternalExprParser.g:926:6: ( ruleSetType )
                    // InternalExprParser.g:927:1: ruleSetType
                    {
                     before(grammarAccess.getTypeAccess().getSetTypeParserRuleCall_7()); 
                    pushFollow(FOLLOW_2);
                    ruleSetType();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getSetTypeParserRuleCall_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalExprParser.g:932:6: ( ruleBagType )
                    {
                    // InternalExprParser.g:932:6: ( ruleBagType )
                    // InternalExprParser.g:933:1: ruleBagType
                    {
                     before(grammarAccess.getTypeAccess().getBagTypeParserRuleCall_8()); 
                    pushFollow(FOLLOW_2);
                    ruleBagType();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getBagTypeParserRuleCall_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalExprParser.g:938:6: ( ruleMapType )
                    {
                    // InternalExprParser.g:938:6: ( ruleMapType )
                    // InternalExprParser.g:939:1: ruleMapType
                    {
                     before(grammarAccess.getTypeAccess().getMapTypeParserRuleCall_9()); 
                    pushFollow(FOLLOW_2);
                    ruleMapType();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getMapTypeParserRuleCall_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalExprParser.g:944:6: ( ruleTypeRef )
                    {
                    // InternalExprParser.g:944:6: ( ruleTypeRef )
                    // InternalExprParser.g:945:1: ruleTypeRef
                    {
                     before(grammarAccess.getTypeAccess().getTypeRefParserRuleCall_10()); 
                    pushFollow(FOLLOW_2);
                    ruleTypeRef();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getTypeRefParserRuleCall_10()); 

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
    // InternalExprParser.g:955:1: rule__PrimitiveType__Alternatives : ( ( ( rule__PrimitiveType__Group_0__0 ) ) | ( ( rule__PrimitiveType__Group_1__0 ) ) | ( ( rule__PrimitiveType__Group_2__0 ) ) | ( ( rule__PrimitiveType__Group_3__0 ) ) );
    public final void rule__PrimitiveType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:959:1: ( ( ( rule__PrimitiveType__Group_0__0 ) ) | ( ( rule__PrimitiveType__Group_1__0 ) ) | ( ( rule__PrimitiveType__Group_2__0 ) ) | ( ( rule__PrimitiveType__Group_3__0 ) ) )
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
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalExprParser.g:960:1: ( ( rule__PrimitiveType__Group_0__0 ) )
                    {
                    // InternalExprParser.g:960:1: ( ( rule__PrimitiveType__Group_0__0 ) )
                    // InternalExprParser.g:961:1: ( rule__PrimitiveType__Group_0__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_0()); 
                    // InternalExprParser.g:962:1: ( rule__PrimitiveType__Group_0__0 )
                    // InternalExprParser.g:962:2: rule__PrimitiveType__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveType__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimitiveTypeAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:966:6: ( ( rule__PrimitiveType__Group_1__0 ) )
                    {
                    // InternalExprParser.g:966:6: ( ( rule__PrimitiveType__Group_1__0 ) )
                    // InternalExprParser.g:967:1: ( rule__PrimitiveType__Group_1__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_1()); 
                    // InternalExprParser.g:968:1: ( rule__PrimitiveType__Group_1__0 )
                    // InternalExprParser.g:968:2: rule__PrimitiveType__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveType__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimitiveTypeAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalExprParser.g:972:6: ( ( rule__PrimitiveType__Group_2__0 ) )
                    {
                    // InternalExprParser.g:972:6: ( ( rule__PrimitiveType__Group_2__0 ) )
                    // InternalExprParser.g:973:1: ( rule__PrimitiveType__Group_2__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_2()); 
                    // InternalExprParser.g:974:1: ( rule__PrimitiveType__Group_2__0 )
                    // InternalExprParser.g:974:2: rule__PrimitiveType__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveType__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimitiveTypeAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalExprParser.g:978:6: ( ( rule__PrimitiveType__Group_3__0 ) )
                    {
                    // InternalExprParser.g:978:6: ( ( rule__PrimitiveType__Group_3__0 ) )
                    // InternalExprParser.g:979:1: ( rule__PrimitiveType__Group_3__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_3()); 
                    // InternalExprParser.g:980:1: ( rule__PrimitiveType__Group_3__0 )
                    // InternalExprParser.g:980:2: rule__PrimitiveType__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveType__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimitiveTypeAccess().getGroup_3()); 

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


    // $ANTLR start "rule__CategoryEnum__Alternatives"
    // InternalExprParser.g:989:1: rule__CategoryEnum__Alternatives : ( ( ( ABSTRACT ) ) | ( ( BUS ) ) | ( ( DATA ) ) | ( ( DEVICE ) ) | ( ( MEMEORY ) ) | ( ( PROCESS ) ) | ( ( PROCESSOR ) ) | ( ( SUBPROGRAM ) ) | ( ( SUBPROGRAMGROUP ) ) | ( ( SYSTEM ) ) | ( ( THREAD_GROUP ) ) | ( ( THREAD ) ) | ( ( VIRTUAL_BUS ) ) | ( ( VIRTUAL_PROCESSOR ) ) );
    public final void rule__CategoryEnum__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:993:1: ( ( ( ABSTRACT ) ) | ( ( BUS ) ) | ( ( DATA ) ) | ( ( DEVICE ) ) | ( ( MEMEORY ) ) | ( ( PROCESS ) ) | ( ( PROCESSOR ) ) | ( ( SUBPROGRAM ) ) | ( ( SUBPROGRAMGROUP ) ) | ( ( SYSTEM ) ) | ( ( THREAD_GROUP ) ) | ( ( THREAD ) ) | ( ( VIRTUAL_BUS ) ) | ( ( VIRTUAL_PROCESSOR ) ) )
            int alt6=14;
            switch ( input.LA(1) ) {
            case ABSTRACT:
                {
                alt6=1;
                }
                break;
            case BUS:
                {
                alt6=2;
                }
                break;
            case DATA:
                {
                alt6=3;
                }
                break;
            case DEVICE:
                {
                alt6=4;
                }
                break;
            case MEMEORY:
                {
                alt6=5;
                }
                break;
            case PROCESS:
                {
                alt6=6;
                }
                break;
            case PROCESSOR:
                {
                alt6=7;
                }
                break;
            case SUBPROGRAM:
                {
                alt6=8;
                }
                break;
            case SUBPROGRAMGROUP:
                {
                alt6=9;
                }
                break;
            case SYSTEM:
                {
                alt6=10;
                }
                break;
            case THREAD_GROUP:
                {
                alt6=11;
                }
                break;
            case THREAD:
                {
                alt6=12;
                }
                break;
            case VIRTUAL_BUS:
                {
                alt6=13;
                }
                break;
            case VIRTUAL_PROCESSOR:
                {
                alt6=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalExprParser.g:994:1: ( ( ABSTRACT ) )
                    {
                    // InternalExprParser.g:994:1: ( ( ABSTRACT ) )
                    // InternalExprParser.g:995:1: ( ABSTRACT )
                    {
                     before(grammarAccess.getCategoryEnumAccess().getABSTRACTEnumLiteralDeclaration_0()); 
                    // InternalExprParser.g:996:1: ( ABSTRACT )
                    // InternalExprParser.g:996:3: ABSTRACT
                    {
                    match(input,ABSTRACT,FOLLOW_2); 

                    }

                     after(grammarAccess.getCategoryEnumAccess().getABSTRACTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:1001:6: ( ( BUS ) )
                    {
                    // InternalExprParser.g:1001:6: ( ( BUS ) )
                    // InternalExprParser.g:1002:1: ( BUS )
                    {
                     before(grammarAccess.getCategoryEnumAccess().getBUSEnumLiteralDeclaration_1()); 
                    // InternalExprParser.g:1003:1: ( BUS )
                    // InternalExprParser.g:1003:3: BUS
                    {
                    match(input,BUS,FOLLOW_2); 

                    }

                     after(grammarAccess.getCategoryEnumAccess().getBUSEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalExprParser.g:1008:6: ( ( DATA ) )
                    {
                    // InternalExprParser.g:1008:6: ( ( DATA ) )
                    // InternalExprParser.g:1009:1: ( DATA )
                    {
                     before(grammarAccess.getCategoryEnumAccess().getDATAEnumLiteralDeclaration_2()); 
                    // InternalExprParser.g:1010:1: ( DATA )
                    // InternalExprParser.g:1010:3: DATA
                    {
                    match(input,DATA,FOLLOW_2); 

                    }

                     after(grammarAccess.getCategoryEnumAccess().getDATAEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalExprParser.g:1015:6: ( ( DEVICE ) )
                    {
                    // InternalExprParser.g:1015:6: ( ( DEVICE ) )
                    // InternalExprParser.g:1016:1: ( DEVICE )
                    {
                     before(grammarAccess.getCategoryEnumAccess().getDEVICEEnumLiteralDeclaration_3()); 
                    // InternalExprParser.g:1017:1: ( DEVICE )
                    // InternalExprParser.g:1017:3: DEVICE
                    {
                    match(input,DEVICE,FOLLOW_2); 

                    }

                     after(grammarAccess.getCategoryEnumAccess().getDEVICEEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalExprParser.g:1022:6: ( ( MEMEORY ) )
                    {
                    // InternalExprParser.g:1022:6: ( ( MEMEORY ) )
                    // InternalExprParser.g:1023:1: ( MEMEORY )
                    {
                     before(grammarAccess.getCategoryEnumAccess().getMEMEORYEnumLiteralDeclaration_4()); 
                    // InternalExprParser.g:1024:1: ( MEMEORY )
                    // InternalExprParser.g:1024:3: MEMEORY
                    {
                    match(input,MEMEORY,FOLLOW_2); 

                    }

                     after(grammarAccess.getCategoryEnumAccess().getMEMEORYEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalExprParser.g:1029:6: ( ( PROCESS ) )
                    {
                    // InternalExprParser.g:1029:6: ( ( PROCESS ) )
                    // InternalExprParser.g:1030:1: ( PROCESS )
                    {
                     before(grammarAccess.getCategoryEnumAccess().getPROCESSEnumLiteralDeclaration_5()); 
                    // InternalExprParser.g:1031:1: ( PROCESS )
                    // InternalExprParser.g:1031:3: PROCESS
                    {
                    match(input,PROCESS,FOLLOW_2); 

                    }

                     after(grammarAccess.getCategoryEnumAccess().getPROCESSEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalExprParser.g:1036:6: ( ( PROCESSOR ) )
                    {
                    // InternalExprParser.g:1036:6: ( ( PROCESSOR ) )
                    // InternalExprParser.g:1037:1: ( PROCESSOR )
                    {
                     before(grammarAccess.getCategoryEnumAccess().getPROCESSOREnumLiteralDeclaration_6()); 
                    // InternalExprParser.g:1038:1: ( PROCESSOR )
                    // InternalExprParser.g:1038:3: PROCESSOR
                    {
                    match(input,PROCESSOR,FOLLOW_2); 

                    }

                     after(grammarAccess.getCategoryEnumAccess().getPROCESSOREnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalExprParser.g:1043:6: ( ( SUBPROGRAM ) )
                    {
                    // InternalExprParser.g:1043:6: ( ( SUBPROGRAM ) )
                    // InternalExprParser.g:1044:1: ( SUBPROGRAM )
                    {
                     before(grammarAccess.getCategoryEnumAccess().getSUBPROGRAMEnumLiteralDeclaration_7()); 
                    // InternalExprParser.g:1045:1: ( SUBPROGRAM )
                    // InternalExprParser.g:1045:3: SUBPROGRAM
                    {
                    match(input,SUBPROGRAM,FOLLOW_2); 

                    }

                     after(grammarAccess.getCategoryEnumAccess().getSUBPROGRAMEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalExprParser.g:1050:6: ( ( SUBPROGRAMGROUP ) )
                    {
                    // InternalExprParser.g:1050:6: ( ( SUBPROGRAMGROUP ) )
                    // InternalExprParser.g:1051:1: ( SUBPROGRAMGROUP )
                    {
                     before(grammarAccess.getCategoryEnumAccess().getSUBPROGRAMGROUPEnumLiteralDeclaration_8()); 
                    // InternalExprParser.g:1052:1: ( SUBPROGRAMGROUP )
                    // InternalExprParser.g:1052:3: SUBPROGRAMGROUP
                    {
                    match(input,SUBPROGRAMGROUP,FOLLOW_2); 

                    }

                     after(grammarAccess.getCategoryEnumAccess().getSUBPROGRAMGROUPEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalExprParser.g:1057:6: ( ( SYSTEM ) )
                    {
                    // InternalExprParser.g:1057:6: ( ( SYSTEM ) )
                    // InternalExprParser.g:1058:1: ( SYSTEM )
                    {
                     before(grammarAccess.getCategoryEnumAccess().getSYSTEMEnumLiteralDeclaration_9()); 
                    // InternalExprParser.g:1059:1: ( SYSTEM )
                    // InternalExprParser.g:1059:3: SYSTEM
                    {
                    match(input,SYSTEM,FOLLOW_2); 

                    }

                     after(grammarAccess.getCategoryEnumAccess().getSYSTEMEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalExprParser.g:1064:6: ( ( THREAD_GROUP ) )
                    {
                    // InternalExprParser.g:1064:6: ( ( THREAD_GROUP ) )
                    // InternalExprParser.g:1065:1: ( THREAD_GROUP )
                    {
                     before(grammarAccess.getCategoryEnumAccess().getTHREAD_GROUPEnumLiteralDeclaration_10()); 
                    // InternalExprParser.g:1066:1: ( THREAD_GROUP )
                    // InternalExprParser.g:1066:3: THREAD_GROUP
                    {
                    match(input,THREAD_GROUP,FOLLOW_2); 

                    }

                     after(grammarAccess.getCategoryEnumAccess().getTHREAD_GROUPEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalExprParser.g:1071:6: ( ( THREAD ) )
                    {
                    // InternalExprParser.g:1071:6: ( ( THREAD ) )
                    // InternalExprParser.g:1072:1: ( THREAD )
                    {
                     before(grammarAccess.getCategoryEnumAccess().getTHREADEnumLiteralDeclaration_11()); 
                    // InternalExprParser.g:1073:1: ( THREAD )
                    // InternalExprParser.g:1073:3: THREAD
                    {
                    match(input,THREAD,FOLLOW_2); 

                    }

                     after(grammarAccess.getCategoryEnumAccess().getTHREADEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalExprParser.g:1078:6: ( ( VIRTUAL_BUS ) )
                    {
                    // InternalExprParser.g:1078:6: ( ( VIRTUAL_BUS ) )
                    // InternalExprParser.g:1079:1: ( VIRTUAL_BUS )
                    {
                     before(grammarAccess.getCategoryEnumAccess().getVIRTUAL_BUSEnumLiteralDeclaration_12()); 
                    // InternalExprParser.g:1080:1: ( VIRTUAL_BUS )
                    // InternalExprParser.g:1080:3: VIRTUAL_BUS
                    {
                    match(input,VIRTUAL_BUS,FOLLOW_2); 

                    }

                     after(grammarAccess.getCategoryEnumAccess().getVIRTUAL_BUSEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalExprParser.g:1085:6: ( ( VIRTUAL_PROCESSOR ) )
                    {
                    // InternalExprParser.g:1085:6: ( ( VIRTUAL_PROCESSOR ) )
                    // InternalExprParser.g:1086:1: ( VIRTUAL_PROCESSOR )
                    {
                     before(grammarAccess.getCategoryEnumAccess().getVIRTUAL_PROCESSOREnumLiteralDeclaration_13()); 
                    // InternalExprParser.g:1087:1: ( VIRTUAL_PROCESSOR )
                    // InternalExprParser.g:1087:3: VIRTUAL_PROCESSOR
                    {
                    match(input,VIRTUAL_PROCESSOR,FOLLOW_2); 

                    }

                     after(grammarAccess.getCategoryEnumAccess().getVIRTUAL_PROCESSOREnumLiteralDeclaration_13()); 

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
    // $ANTLR end "rule__CategoryEnum__Alternatives"


    // $ANTLR start "rule__MetaClassEnum__Alternatives"
    // InternalExprParser.g:1097:1: rule__MetaClassEnum__Alternatives : ( ( ( CLASSIFIER ) ) | ( ( SUBCOMPONENT ) ) | ( ( FEATURE ) ) | ( ( CONNECTION ) ) | ( ( FLOW ) ) | ( ( MODE ) ) );
    public final void rule__MetaClassEnum__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1101:1: ( ( ( CLASSIFIER ) ) | ( ( SUBCOMPONENT ) ) | ( ( FEATURE ) ) | ( ( CONNECTION ) ) | ( ( FLOW ) ) | ( ( MODE ) ) )
            int alt7=6;
            switch ( input.LA(1) ) {
            case CLASSIFIER:
                {
                alt7=1;
                }
                break;
            case SUBCOMPONENT:
                {
                alt7=2;
                }
                break;
            case FEATURE:
                {
                alt7=3;
                }
                break;
            case CONNECTION:
                {
                alt7=4;
                }
                break;
            case FLOW:
                {
                alt7=5;
                }
                break;
            case MODE:
                {
                alt7=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalExprParser.g:1102:1: ( ( CLASSIFIER ) )
                    {
                    // InternalExprParser.g:1102:1: ( ( CLASSIFIER ) )
                    // InternalExprParser.g:1103:1: ( CLASSIFIER )
                    {
                     before(grammarAccess.getMetaClassEnumAccess().getCLASSIFIEREnumLiteralDeclaration_0()); 
                    // InternalExprParser.g:1104:1: ( CLASSIFIER )
                    // InternalExprParser.g:1104:3: CLASSIFIER
                    {
                    match(input,CLASSIFIER,FOLLOW_2); 

                    }

                     after(grammarAccess.getMetaClassEnumAccess().getCLASSIFIEREnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:1109:6: ( ( SUBCOMPONENT ) )
                    {
                    // InternalExprParser.g:1109:6: ( ( SUBCOMPONENT ) )
                    // InternalExprParser.g:1110:1: ( SUBCOMPONENT )
                    {
                     before(grammarAccess.getMetaClassEnumAccess().getSUBCOMPONENTEnumLiteralDeclaration_1()); 
                    // InternalExprParser.g:1111:1: ( SUBCOMPONENT )
                    // InternalExprParser.g:1111:3: SUBCOMPONENT
                    {
                    match(input,SUBCOMPONENT,FOLLOW_2); 

                    }

                     after(grammarAccess.getMetaClassEnumAccess().getSUBCOMPONENTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalExprParser.g:1116:6: ( ( FEATURE ) )
                    {
                    // InternalExprParser.g:1116:6: ( ( FEATURE ) )
                    // InternalExprParser.g:1117:1: ( FEATURE )
                    {
                     before(grammarAccess.getMetaClassEnumAccess().getFEATUREEnumLiteralDeclaration_2()); 
                    // InternalExprParser.g:1118:1: ( FEATURE )
                    // InternalExprParser.g:1118:3: FEATURE
                    {
                    match(input,FEATURE,FOLLOW_2); 

                    }

                     after(grammarAccess.getMetaClassEnumAccess().getFEATUREEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalExprParser.g:1123:6: ( ( CONNECTION ) )
                    {
                    // InternalExprParser.g:1123:6: ( ( CONNECTION ) )
                    // InternalExprParser.g:1124:1: ( CONNECTION )
                    {
                     before(grammarAccess.getMetaClassEnumAccess().getCONNECTIONEnumLiteralDeclaration_3()); 
                    // InternalExprParser.g:1125:1: ( CONNECTION )
                    // InternalExprParser.g:1125:3: CONNECTION
                    {
                    match(input,CONNECTION,FOLLOW_2); 

                    }

                     after(grammarAccess.getMetaClassEnumAccess().getCONNECTIONEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalExprParser.g:1130:6: ( ( FLOW ) )
                    {
                    // InternalExprParser.g:1130:6: ( ( FLOW ) )
                    // InternalExprParser.g:1131:1: ( FLOW )
                    {
                     before(grammarAccess.getMetaClassEnumAccess().getFLOWEnumLiteralDeclaration_4()); 
                    // InternalExprParser.g:1132:1: ( FLOW )
                    // InternalExprParser.g:1132:3: FLOW
                    {
                    match(input,FLOW,FOLLOW_2); 

                    }

                     after(grammarAccess.getMetaClassEnumAccess().getFLOWEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalExprParser.g:1137:6: ( ( MODE ) )
                    {
                    // InternalExprParser.g:1137:6: ( ( MODE ) )
                    // InternalExprParser.g:1138:1: ( MODE )
                    {
                     before(grammarAccess.getMetaClassEnumAccess().getMODEEnumLiteralDeclaration_5()); 
                    // InternalExprParser.g:1139:1: ( MODE )
                    // InternalExprParser.g:1139:3: MODE
                    {
                    match(input,MODE,FOLLOW_2); 

                    }

                     after(grammarAccess.getMetaClassEnumAccess().getMODEEnumLiteralDeclaration_5()); 

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
    // InternalExprParser.g:1151:1: rule__ExprModel__Group_0__0 : rule__ExprModel__Group_0__0__Impl rule__ExprModel__Group_0__1 ;
    public final void rule__ExprModel__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1155:1: ( rule__ExprModel__Group_0__0__Impl rule__ExprModel__Group_0__1 )
            // InternalExprParser.g:1156:2: rule__ExprModel__Group_0__0__Impl rule__ExprModel__Group_0__1
            {
            pushFollow(FOLLOW_3);
            rule__ExprModel__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExprModel__Group_0__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1163:1: rule__ExprModel__Group_0__0__Impl : ( Library ) ;
    public final void rule__ExprModel__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1167:1: ( ( Library ) )
            // InternalExprParser.g:1168:1: ( Library )
            {
            // InternalExprParser.g:1168:1: ( Library )
            // InternalExprParser.g:1169:1: Library
            {
             before(grammarAccess.getExprModelAccess().getLibraryKeyword_0_0()); 
            match(input,Library,FOLLOW_2); 
             after(grammarAccess.getExprModelAccess().getLibraryKeyword_0_0()); 

            }


            }

        }
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
    // InternalExprParser.g:1182:1: rule__ExprModel__Group_0__1 : rule__ExprModel__Group_0__1__Impl ;
    public final void rule__ExprModel__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1186:1: ( rule__ExprModel__Group_0__1__Impl )
            // InternalExprParser.g:1187:2: rule__ExprModel__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExprModel__Group_0__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1193:1: rule__ExprModel__Group_0__1__Impl : ( ( rule__ExprModel__AnnexAssignment_0_1 ) ) ;
    public final void rule__ExprModel__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1197:1: ( ( ( rule__ExprModel__AnnexAssignment_0_1 ) ) )
            // InternalExprParser.g:1198:1: ( ( rule__ExprModel__AnnexAssignment_0_1 ) )
            {
            // InternalExprParser.g:1198:1: ( ( rule__ExprModel__AnnexAssignment_0_1 ) )
            // InternalExprParser.g:1199:1: ( rule__ExprModel__AnnexAssignment_0_1 )
            {
             before(grammarAccess.getExprModelAccess().getAnnexAssignment_0_1()); 
            // InternalExprParser.g:1200:1: ( rule__ExprModel__AnnexAssignment_0_1 )
            // InternalExprParser.g:1200:2: rule__ExprModel__AnnexAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__ExprModel__AnnexAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getExprModelAccess().getAnnexAssignment_0_1()); 

            }


            }

        }
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
    // InternalExprParser.g:1214:1: rule__ExprModel__Group_1__0 : rule__ExprModel__Group_1__0__Impl rule__ExprModel__Group_1__1 ;
    public final void rule__ExprModel__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1218:1: ( rule__ExprModel__Group_1__0__Impl rule__ExprModel__Group_1__1 )
            // InternalExprParser.g:1219:2: rule__ExprModel__Group_1__0__Impl rule__ExprModel__Group_1__1
            {
            pushFollow(FOLLOW_3);
            rule__ExprModel__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExprModel__Group_1__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1226:1: rule__ExprModel__Group_1__0__Impl : ( Subclause ) ;
    public final void rule__ExprModel__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1230:1: ( ( Subclause ) )
            // InternalExprParser.g:1231:1: ( Subclause )
            {
            // InternalExprParser.g:1231:1: ( Subclause )
            // InternalExprParser.g:1232:1: Subclause
            {
             before(grammarAccess.getExprModelAccess().getSubclauseKeyword_1_0()); 
            match(input,Subclause,FOLLOW_2); 
             after(grammarAccess.getExprModelAccess().getSubclauseKeyword_1_0()); 

            }


            }

        }
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
    // InternalExprParser.g:1245:1: rule__ExprModel__Group_1__1 : rule__ExprModel__Group_1__1__Impl ;
    public final void rule__ExprModel__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1249:1: ( rule__ExprModel__Group_1__1__Impl )
            // InternalExprParser.g:1250:2: rule__ExprModel__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExprModel__Group_1__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1256:1: rule__ExprModel__Group_1__1__Impl : ( ( rule__ExprModel__AnnexAssignment_1_1 ) ) ;
    public final void rule__ExprModel__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1260:1: ( ( ( rule__ExprModel__AnnexAssignment_1_1 ) ) )
            // InternalExprParser.g:1261:1: ( ( rule__ExprModel__AnnexAssignment_1_1 ) )
            {
            // InternalExprParser.g:1261:1: ( ( rule__ExprModel__AnnexAssignment_1_1 ) )
            // InternalExprParser.g:1262:1: ( rule__ExprModel__AnnexAssignment_1_1 )
            {
             before(grammarAccess.getExprModelAccess().getAnnexAssignment_1_1()); 
            // InternalExprParser.g:1263:1: ( rule__ExprModel__AnnexAssignment_1_1 )
            // InternalExprParser.g:1263:2: rule__ExprModel__AnnexAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ExprModel__AnnexAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getExprModelAccess().getAnnexAssignment_1_1()); 

            }


            }

        }
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
    // InternalExprParser.g:1277:1: rule__ExprLibrary__Group__0 : rule__ExprLibrary__Group__0__Impl rule__ExprLibrary__Group__1 ;
    public final void rule__ExprLibrary__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1281:1: ( rule__ExprLibrary__Group__0__Impl rule__ExprLibrary__Group__1 )
            // InternalExprParser.g:1282:2: rule__ExprLibrary__Group__0__Impl rule__ExprLibrary__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__ExprLibrary__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExprLibrary__Group__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1289:1: rule__ExprLibrary__Group__0__Impl : ( () ) ;
    public final void rule__ExprLibrary__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1293:1: ( ( () ) )
            // InternalExprParser.g:1294:1: ( () )
            {
            // InternalExprParser.g:1294:1: ( () )
            // InternalExprParser.g:1295:1: ()
            {
             before(grammarAccess.getExprLibraryAccess().getExprLibraryAction_0()); 
            // InternalExprParser.g:1296:1: ()
            // InternalExprParser.g:1298:1: 
            {
            }

             after(grammarAccess.getExprLibraryAccess().getExprLibraryAction_0()); 

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
    // InternalExprParser.g:1308:1: rule__ExprLibrary__Group__1 : rule__ExprLibrary__Group__1__Impl ;
    public final void rule__ExprLibrary__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1312:1: ( rule__ExprLibrary__Group__1__Impl )
            // InternalExprParser.g:1313:2: rule__ExprLibrary__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExprLibrary__Group__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1319:1: rule__ExprLibrary__Group__1__Impl : ( ( rule__ExprLibrary__DeclsAssignment_1 )* ) ;
    public final void rule__ExprLibrary__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1323:1: ( ( ( rule__ExprLibrary__DeclsAssignment_1 )* ) )
            // InternalExprParser.g:1324:1: ( ( rule__ExprLibrary__DeclsAssignment_1 )* )
            {
            // InternalExprParser.g:1324:1: ( ( rule__ExprLibrary__DeclsAssignment_1 )* )
            // InternalExprParser.g:1325:1: ( rule__ExprLibrary__DeclsAssignment_1 )*
            {
             before(grammarAccess.getExprLibraryAccess().getDeclsAssignment_1()); 
            // InternalExprParser.g:1326:1: ( rule__ExprLibrary__DeclsAssignment_1 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==Type||LA8_0==Def||(LA8_0>=Val && LA8_0<=Var)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalExprParser.g:1326:2: rule__ExprLibrary__DeclsAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__ExprLibrary__DeclsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getExprLibraryAccess().getDeclsAssignment_1()); 

            }


            }

        }
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
    // InternalExprParser.g:1340:1: rule__ExprSubclause__Group__0 : rule__ExprSubclause__Group__0__Impl rule__ExprSubclause__Group__1 ;
    public final void rule__ExprSubclause__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1344:1: ( rule__ExprSubclause__Group__0__Impl rule__ExprSubclause__Group__1 )
            // InternalExprParser.g:1345:2: rule__ExprSubclause__Group__0__Impl rule__ExprSubclause__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__ExprSubclause__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExprSubclause__Group__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1352:1: rule__ExprSubclause__Group__0__Impl : ( () ) ;
    public final void rule__ExprSubclause__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1356:1: ( ( () ) )
            // InternalExprParser.g:1357:1: ( () )
            {
            // InternalExprParser.g:1357:1: ( () )
            // InternalExprParser.g:1358:1: ()
            {
             before(grammarAccess.getExprSubclauseAccess().getExprSubclauseAction_0()); 
            // InternalExprParser.g:1359:1: ()
            // InternalExprParser.g:1361:1: 
            {
            }

             after(grammarAccess.getExprSubclauseAccess().getExprSubclauseAction_0()); 

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
    // InternalExprParser.g:1371:1: rule__ExprSubclause__Group__1 : rule__ExprSubclause__Group__1__Impl ;
    public final void rule__ExprSubclause__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1375:1: ( rule__ExprSubclause__Group__1__Impl )
            // InternalExprParser.g:1376:2: rule__ExprSubclause__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExprSubclause__Group__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1382:1: rule__ExprSubclause__Group__1__Impl : ( ( rule__ExprSubclause__DeclsAssignment_1 )* ) ;
    public final void rule__ExprSubclause__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1386:1: ( ( ( rule__ExprSubclause__DeclsAssignment_1 )* ) )
            // InternalExprParser.g:1387:1: ( ( rule__ExprSubclause__DeclsAssignment_1 )* )
            {
            // InternalExprParser.g:1387:1: ( ( rule__ExprSubclause__DeclsAssignment_1 )* )
            // InternalExprParser.g:1388:1: ( rule__ExprSubclause__DeclsAssignment_1 )*
            {
             before(grammarAccess.getExprSubclauseAccess().getDeclsAssignment_1()); 
            // InternalExprParser.g:1389:1: ( rule__ExprSubclause__DeclsAssignment_1 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==Type||LA9_0==Def||(LA9_0>=Val && LA9_0<=Var)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalExprParser.g:1389:2: rule__ExprSubclause__DeclsAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__ExprSubclause__DeclsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getExprSubclauseAccess().getDeclsAssignment_1()); 

            }


            }

        }
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
    // InternalExprParser.g:1403:1: rule__TypeDecl__Group__0 : rule__TypeDecl__Group__0__Impl rule__TypeDecl__Group__1 ;
    public final void rule__TypeDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1407:1: ( rule__TypeDecl__Group__0__Impl rule__TypeDecl__Group__1 )
            // InternalExprParser.g:1408:2: rule__TypeDecl__Group__0__Impl rule__TypeDecl__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__TypeDecl__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDecl__Group__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1415:1: rule__TypeDecl__Group__0__Impl : ( Type ) ;
    public final void rule__TypeDecl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1419:1: ( ( Type ) )
            // InternalExprParser.g:1420:1: ( Type )
            {
            // InternalExprParser.g:1420:1: ( Type )
            // InternalExprParser.g:1421:1: Type
            {
             before(grammarAccess.getTypeDeclAccess().getTypeKeyword_0()); 
            match(input,Type,FOLLOW_2); 
             after(grammarAccess.getTypeDeclAccess().getTypeKeyword_0()); 

            }


            }

        }
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
    // InternalExprParser.g:1434:1: rule__TypeDecl__Group__1 : rule__TypeDecl__Group__1__Impl rule__TypeDecl__Group__2 ;
    public final void rule__TypeDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1438:1: ( rule__TypeDecl__Group__1__Impl rule__TypeDecl__Group__2 )
            // InternalExprParser.g:1439:2: rule__TypeDecl__Group__1__Impl rule__TypeDecl__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__TypeDecl__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDecl__Group__2();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1446:1: rule__TypeDecl__Group__1__Impl : ( ( rule__TypeDecl__NameAssignment_1 ) ) ;
    public final void rule__TypeDecl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1450:1: ( ( ( rule__TypeDecl__NameAssignment_1 ) ) )
            // InternalExprParser.g:1451:1: ( ( rule__TypeDecl__NameAssignment_1 ) )
            {
            // InternalExprParser.g:1451:1: ( ( rule__TypeDecl__NameAssignment_1 ) )
            // InternalExprParser.g:1452:1: ( rule__TypeDecl__NameAssignment_1 )
            {
             before(grammarAccess.getTypeDeclAccess().getNameAssignment_1()); 
            // InternalExprParser.g:1453:1: ( rule__TypeDecl__NameAssignment_1 )
            // InternalExprParser.g:1453:2: rule__TypeDecl__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TypeDecl__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeDeclAccess().getNameAssignment_1()); 

            }


            }

        }
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
    // InternalExprParser.g:1463:1: rule__TypeDecl__Group__2 : rule__TypeDecl__Group__2__Impl rule__TypeDecl__Group__3 ;
    public final void rule__TypeDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1467:1: ( rule__TypeDecl__Group__2__Impl rule__TypeDecl__Group__3 )
            // InternalExprParser.g:1468:2: rule__TypeDecl__Group__2__Impl rule__TypeDecl__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__TypeDecl__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDecl__Group__3();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1475:1: rule__TypeDecl__Group__2__Impl : ( Colon ) ;
    public final void rule__TypeDecl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1479:1: ( ( Colon ) )
            // InternalExprParser.g:1480:1: ( Colon )
            {
            // InternalExprParser.g:1480:1: ( Colon )
            // InternalExprParser.g:1481:1: Colon
            {
             before(grammarAccess.getTypeDeclAccess().getColonKeyword_2()); 
            match(input,Colon,FOLLOW_2); 
             after(grammarAccess.getTypeDeclAccess().getColonKeyword_2()); 

            }


            }

        }
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
    // InternalExprParser.g:1494:1: rule__TypeDecl__Group__3 : rule__TypeDecl__Group__3__Impl rule__TypeDecl__Group__4 ;
    public final void rule__TypeDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1498:1: ( rule__TypeDecl__Group__3__Impl rule__TypeDecl__Group__4 )
            // InternalExprParser.g:1499:2: rule__TypeDecl__Group__3__Impl rule__TypeDecl__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__TypeDecl__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDecl__Group__4();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1506:1: rule__TypeDecl__Group__3__Impl : ( ( rule__TypeDecl__TypeAssignment_3 ) ) ;
    public final void rule__TypeDecl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1510:1: ( ( ( rule__TypeDecl__TypeAssignment_3 ) ) )
            // InternalExprParser.g:1511:1: ( ( rule__TypeDecl__TypeAssignment_3 ) )
            {
            // InternalExprParser.g:1511:1: ( ( rule__TypeDecl__TypeAssignment_3 ) )
            // InternalExprParser.g:1512:1: ( rule__TypeDecl__TypeAssignment_3 )
            {
             before(grammarAccess.getTypeDeclAccess().getTypeAssignment_3()); 
            // InternalExprParser.g:1513:1: ( rule__TypeDecl__TypeAssignment_3 )
            // InternalExprParser.g:1513:2: rule__TypeDecl__TypeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__TypeDecl__TypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTypeDeclAccess().getTypeAssignment_3()); 

            }


            }

        }
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
    // InternalExprParser.g:1523:1: rule__TypeDecl__Group__4 : rule__TypeDecl__Group__4__Impl ;
    public final void rule__TypeDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1527:1: ( rule__TypeDecl__Group__4__Impl )
            // InternalExprParser.g:1528:2: rule__TypeDecl__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeDecl__Group__4__Impl();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1534:1: rule__TypeDecl__Group__4__Impl : ( Semicolon ) ;
    public final void rule__TypeDecl__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1538:1: ( ( Semicolon ) )
            // InternalExprParser.g:1539:1: ( Semicolon )
            {
            // InternalExprParser.g:1539:1: ( Semicolon )
            // InternalExprParser.g:1540:1: Semicolon
            {
             before(grammarAccess.getTypeDeclAccess().getSemicolonKeyword_4()); 
            match(input,Semicolon,FOLLOW_2); 
             after(grammarAccess.getTypeDeclAccess().getSemicolonKeyword_4()); 

            }


            }

        }
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
    // InternalExprParser.g:1563:1: rule__VarDecl__Group__0 : rule__VarDecl__Group__0__Impl rule__VarDecl__Group__1 ;
    public final void rule__VarDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1567:1: ( rule__VarDecl__Group__0__Impl rule__VarDecl__Group__1 )
            // InternalExprParser.g:1568:2: rule__VarDecl__Group__0__Impl rule__VarDecl__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__VarDecl__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VarDecl__Group__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1575:1: rule__VarDecl__Group__0__Impl : ( ( rule__VarDecl__Alternatives_0 ) ) ;
    public final void rule__VarDecl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1579:1: ( ( ( rule__VarDecl__Alternatives_0 ) ) )
            // InternalExprParser.g:1580:1: ( ( rule__VarDecl__Alternatives_0 ) )
            {
            // InternalExprParser.g:1580:1: ( ( rule__VarDecl__Alternatives_0 ) )
            // InternalExprParser.g:1581:1: ( rule__VarDecl__Alternatives_0 )
            {
             before(grammarAccess.getVarDeclAccess().getAlternatives_0()); 
            // InternalExprParser.g:1582:1: ( rule__VarDecl__Alternatives_0 )
            // InternalExprParser.g:1582:2: rule__VarDecl__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__VarDecl__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getVarDeclAccess().getAlternatives_0()); 

            }


            }

        }
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
    // InternalExprParser.g:1592:1: rule__VarDecl__Group__1 : rule__VarDecl__Group__1__Impl rule__VarDecl__Group__2 ;
    public final void rule__VarDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1596:1: ( rule__VarDecl__Group__1__Impl rule__VarDecl__Group__2 )
            // InternalExprParser.g:1597:2: rule__VarDecl__Group__1__Impl rule__VarDecl__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__VarDecl__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VarDecl__Group__2();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1604:1: rule__VarDecl__Group__1__Impl : ( ( rule__VarDecl__NameAssignment_1 ) ) ;
    public final void rule__VarDecl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1608:1: ( ( ( rule__VarDecl__NameAssignment_1 ) ) )
            // InternalExprParser.g:1609:1: ( ( rule__VarDecl__NameAssignment_1 ) )
            {
            // InternalExprParser.g:1609:1: ( ( rule__VarDecl__NameAssignment_1 ) )
            // InternalExprParser.g:1610:1: ( rule__VarDecl__NameAssignment_1 )
            {
             before(grammarAccess.getVarDeclAccess().getNameAssignment_1()); 
            // InternalExprParser.g:1611:1: ( rule__VarDecl__NameAssignment_1 )
            // InternalExprParser.g:1611:2: rule__VarDecl__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__VarDecl__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getVarDeclAccess().getNameAssignment_1()); 

            }


            }

        }
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
    // InternalExprParser.g:1621:1: rule__VarDecl__Group__2 : rule__VarDecl__Group__2__Impl rule__VarDecl__Group__3 ;
    public final void rule__VarDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1625:1: ( rule__VarDecl__Group__2__Impl rule__VarDecl__Group__3 )
            // InternalExprParser.g:1626:2: rule__VarDecl__Group__2__Impl rule__VarDecl__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__VarDecl__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VarDecl__Group__3();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1633:1: rule__VarDecl__Group__2__Impl : ( ( rule__VarDecl__Group_2__0 )? ) ;
    public final void rule__VarDecl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1637:1: ( ( ( rule__VarDecl__Group_2__0 )? ) )
            // InternalExprParser.g:1638:1: ( ( rule__VarDecl__Group_2__0 )? )
            {
            // InternalExprParser.g:1638:1: ( ( rule__VarDecl__Group_2__0 )? )
            // InternalExprParser.g:1639:1: ( rule__VarDecl__Group_2__0 )?
            {
             before(grammarAccess.getVarDeclAccess().getGroup_2()); 
            // InternalExprParser.g:1640:1: ( rule__VarDecl__Group_2__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Colon) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalExprParser.g:1640:2: rule__VarDecl__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VarDecl__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVarDeclAccess().getGroup_2()); 

            }


            }

        }
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
    // InternalExprParser.g:1650:1: rule__VarDecl__Group__3 : rule__VarDecl__Group__3__Impl rule__VarDecl__Group__4 ;
    public final void rule__VarDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1654:1: ( rule__VarDecl__Group__3__Impl rule__VarDecl__Group__4 )
            // InternalExprParser.g:1655:2: rule__VarDecl__Group__3__Impl rule__VarDecl__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__VarDecl__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VarDecl__Group__4();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1662:1: rule__VarDecl__Group__3__Impl : ( ( rule__VarDecl__Group_3__0 )? ) ;
    public final void rule__VarDecl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1666:1: ( ( ( rule__VarDecl__Group_3__0 )? ) )
            // InternalExprParser.g:1667:1: ( ( rule__VarDecl__Group_3__0 )? )
            {
            // InternalExprParser.g:1667:1: ( ( rule__VarDecl__Group_3__0 )? )
            // InternalExprParser.g:1668:1: ( rule__VarDecl__Group_3__0 )?
            {
             before(grammarAccess.getVarDeclAccess().getGroup_3()); 
            // InternalExprParser.g:1669:1: ( rule__VarDecl__Group_3__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==EqualsSign) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalExprParser.g:1669:2: rule__VarDecl__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VarDecl__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVarDeclAccess().getGroup_3()); 

            }


            }

        }
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
    // InternalExprParser.g:1679:1: rule__VarDecl__Group__4 : rule__VarDecl__Group__4__Impl ;
    public final void rule__VarDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1683:1: ( rule__VarDecl__Group__4__Impl )
            // InternalExprParser.g:1684:2: rule__VarDecl__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VarDecl__Group__4__Impl();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1690:1: rule__VarDecl__Group__4__Impl : ( Semicolon ) ;
    public final void rule__VarDecl__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1694:1: ( ( Semicolon ) )
            // InternalExprParser.g:1695:1: ( Semicolon )
            {
            // InternalExprParser.g:1695:1: ( Semicolon )
            // InternalExprParser.g:1696:1: Semicolon
            {
             before(grammarAccess.getVarDeclAccess().getSemicolonKeyword_4()); 
            match(input,Semicolon,FOLLOW_2); 
             after(grammarAccess.getVarDeclAccess().getSemicolonKeyword_4()); 

            }


            }

        }
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
    // InternalExprParser.g:1719:1: rule__VarDecl__Group_2__0 : rule__VarDecl__Group_2__0__Impl rule__VarDecl__Group_2__1 ;
    public final void rule__VarDecl__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1723:1: ( rule__VarDecl__Group_2__0__Impl rule__VarDecl__Group_2__1 )
            // InternalExprParser.g:1724:2: rule__VarDecl__Group_2__0__Impl rule__VarDecl__Group_2__1
            {
            pushFollow(FOLLOW_7);
            rule__VarDecl__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VarDecl__Group_2__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1731:1: rule__VarDecl__Group_2__0__Impl : ( Colon ) ;
    public final void rule__VarDecl__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1735:1: ( ( Colon ) )
            // InternalExprParser.g:1736:1: ( Colon )
            {
            // InternalExprParser.g:1736:1: ( Colon )
            // InternalExprParser.g:1737:1: Colon
            {
             before(grammarAccess.getVarDeclAccess().getColonKeyword_2_0()); 
            match(input,Colon,FOLLOW_2); 
             after(grammarAccess.getVarDeclAccess().getColonKeyword_2_0()); 

            }


            }

        }
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
    // InternalExprParser.g:1750:1: rule__VarDecl__Group_2__1 : rule__VarDecl__Group_2__1__Impl ;
    public final void rule__VarDecl__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1754:1: ( rule__VarDecl__Group_2__1__Impl )
            // InternalExprParser.g:1755:2: rule__VarDecl__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VarDecl__Group_2__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1761:1: rule__VarDecl__Group_2__1__Impl : ( ( rule__VarDecl__TypeAssignment_2_1 ) ) ;
    public final void rule__VarDecl__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1765:1: ( ( ( rule__VarDecl__TypeAssignment_2_1 ) ) )
            // InternalExprParser.g:1766:1: ( ( rule__VarDecl__TypeAssignment_2_1 ) )
            {
            // InternalExprParser.g:1766:1: ( ( rule__VarDecl__TypeAssignment_2_1 ) )
            // InternalExprParser.g:1767:1: ( rule__VarDecl__TypeAssignment_2_1 )
            {
             before(grammarAccess.getVarDeclAccess().getTypeAssignment_2_1()); 
            // InternalExprParser.g:1768:1: ( rule__VarDecl__TypeAssignment_2_1 )
            // InternalExprParser.g:1768:2: rule__VarDecl__TypeAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__VarDecl__TypeAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getVarDeclAccess().getTypeAssignment_2_1()); 

            }


            }

        }
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
    // InternalExprParser.g:1782:1: rule__VarDecl__Group_3__0 : rule__VarDecl__Group_3__0__Impl rule__VarDecl__Group_3__1 ;
    public final void rule__VarDecl__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1786:1: ( rule__VarDecl__Group_3__0__Impl rule__VarDecl__Group_3__1 )
            // InternalExprParser.g:1787:2: rule__VarDecl__Group_3__0__Impl rule__VarDecl__Group_3__1
            {
            pushFollow(FOLLOW_10);
            rule__VarDecl__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VarDecl__Group_3__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1794:1: rule__VarDecl__Group_3__0__Impl : ( EqualsSign ) ;
    public final void rule__VarDecl__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1798:1: ( ( EqualsSign ) )
            // InternalExprParser.g:1799:1: ( EqualsSign )
            {
            // InternalExprParser.g:1799:1: ( EqualsSign )
            // InternalExprParser.g:1800:1: EqualsSign
            {
             before(grammarAccess.getVarDeclAccess().getEqualsSignKeyword_3_0()); 
            match(input,EqualsSign,FOLLOW_2); 
             after(grammarAccess.getVarDeclAccess().getEqualsSignKeyword_3_0()); 

            }


            }

        }
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
    // InternalExprParser.g:1813:1: rule__VarDecl__Group_3__1 : rule__VarDecl__Group_3__1__Impl ;
    public final void rule__VarDecl__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1817:1: ( rule__VarDecl__Group_3__1__Impl )
            // InternalExprParser.g:1818:2: rule__VarDecl__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VarDecl__Group_3__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1824:1: rule__VarDecl__Group_3__1__Impl : ( ruleExpression ) ;
    public final void rule__VarDecl__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1828:1: ( ( ruleExpression ) )
            // InternalExprParser.g:1829:1: ( ruleExpression )
            {
            // InternalExprParser.g:1829:1: ( ruleExpression )
            // InternalExprParser.g:1830:1: ruleExpression
            {
             before(grammarAccess.getVarDeclAccess().getExpressionParserRuleCall_3_1()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getVarDeclAccess().getExpressionParserRuleCall_3_1()); 

            }


            }

        }
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
    // InternalExprParser.g:1845:1: rule__FunDecl__Group__0 : rule__FunDecl__Group__0__Impl rule__FunDecl__Group__1 ;
    public final void rule__FunDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1849:1: ( rule__FunDecl__Group__0__Impl rule__FunDecl__Group__1 )
            // InternalExprParser.g:1850:2: rule__FunDecl__Group__0__Impl rule__FunDecl__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__FunDecl__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FunDecl__Group__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1857:1: rule__FunDecl__Group__0__Impl : ( Def ) ;
    public final void rule__FunDecl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1861:1: ( ( Def ) )
            // InternalExprParser.g:1862:1: ( Def )
            {
            // InternalExprParser.g:1862:1: ( Def )
            // InternalExprParser.g:1863:1: Def
            {
             before(grammarAccess.getFunDeclAccess().getDefKeyword_0()); 
            match(input,Def,FOLLOW_2); 
             after(grammarAccess.getFunDeclAccess().getDefKeyword_0()); 

            }


            }

        }
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
    // InternalExprParser.g:1876:1: rule__FunDecl__Group__1 : rule__FunDecl__Group__1__Impl rule__FunDecl__Group__2 ;
    public final void rule__FunDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1880:1: ( rule__FunDecl__Group__1__Impl rule__FunDecl__Group__2 )
            // InternalExprParser.g:1881:2: rule__FunDecl__Group__1__Impl rule__FunDecl__Group__2
            {
            pushFollow(FOLLOW_11);
            rule__FunDecl__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FunDecl__Group__2();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1888:1: rule__FunDecl__Group__1__Impl : ( ( rule__FunDecl__NameAssignment_1 ) ) ;
    public final void rule__FunDecl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1892:1: ( ( ( rule__FunDecl__NameAssignment_1 ) ) )
            // InternalExprParser.g:1893:1: ( ( rule__FunDecl__NameAssignment_1 ) )
            {
            // InternalExprParser.g:1893:1: ( ( rule__FunDecl__NameAssignment_1 ) )
            // InternalExprParser.g:1894:1: ( rule__FunDecl__NameAssignment_1 )
            {
             before(grammarAccess.getFunDeclAccess().getNameAssignment_1()); 
            // InternalExprParser.g:1895:1: ( rule__FunDecl__NameAssignment_1 )
            // InternalExprParser.g:1895:2: rule__FunDecl__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__FunDecl__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFunDeclAccess().getNameAssignment_1()); 

            }


            }

        }
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
    // InternalExprParser.g:1905:1: rule__FunDecl__Group__2 : rule__FunDecl__Group__2__Impl rule__FunDecl__Group__3 ;
    public final void rule__FunDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1909:1: ( rule__FunDecl__Group__2__Impl rule__FunDecl__Group__3 )
            // InternalExprParser.g:1910:2: rule__FunDecl__Group__2__Impl rule__FunDecl__Group__3
            {
            pushFollow(FOLLOW_12);
            rule__FunDecl__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FunDecl__Group__3();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1917:1: rule__FunDecl__Group__2__Impl : ( LeftParenthesis ) ;
    public final void rule__FunDecl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1921:1: ( ( LeftParenthesis ) )
            // InternalExprParser.g:1922:1: ( LeftParenthesis )
            {
            // InternalExprParser.g:1922:1: ( LeftParenthesis )
            // InternalExprParser.g:1923:1: LeftParenthesis
            {
             before(grammarAccess.getFunDeclAccess().getLeftParenthesisKeyword_2()); 
            match(input,LeftParenthesis,FOLLOW_2); 
             after(grammarAccess.getFunDeclAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
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
    // InternalExprParser.g:1936:1: rule__FunDecl__Group__3 : rule__FunDecl__Group__3__Impl rule__FunDecl__Group__4 ;
    public final void rule__FunDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1940:1: ( rule__FunDecl__Group__3__Impl rule__FunDecl__Group__4 )
            // InternalExprParser.g:1941:2: rule__FunDecl__Group__3__Impl rule__FunDecl__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__FunDecl__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FunDecl__Group__4();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1948:1: rule__FunDecl__Group__3__Impl : ( RightParenthesis ) ;
    public final void rule__FunDecl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1952:1: ( ( RightParenthesis ) )
            // InternalExprParser.g:1953:1: ( RightParenthesis )
            {
            // InternalExprParser.g:1953:1: ( RightParenthesis )
            // InternalExprParser.g:1954:1: RightParenthesis
            {
             before(grammarAccess.getFunDeclAccess().getRightParenthesisKeyword_3()); 
            match(input,RightParenthesis,FOLLOW_2); 
             after(grammarAccess.getFunDeclAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
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
    // InternalExprParser.g:1967:1: rule__FunDecl__Group__4 : rule__FunDecl__Group__4__Impl ;
    public final void rule__FunDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1971:1: ( rule__FunDecl__Group__4__Impl )
            // InternalExprParser.g:1972:2: rule__FunDecl__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FunDecl__Group__4__Impl();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:1978:1: rule__FunDecl__Group__4__Impl : ( Semicolon ) ;
    public final void rule__FunDecl__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:1982:1: ( ( Semicolon ) )
            // InternalExprParser.g:1983:1: ( Semicolon )
            {
            // InternalExprParser.g:1983:1: ( Semicolon )
            // InternalExprParser.g:1984:1: Semicolon
            {
             before(grammarAccess.getFunDeclAccess().getSemicolonKeyword_4()); 
            match(input,Semicolon,FOLLOW_2); 
             after(grammarAccess.getFunDeclAccess().getSemicolonKeyword_4()); 

            }


            }

        }
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
    // InternalExprParser.g:2007:1: rule__PrimitiveType__Group_0__0 : rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1 ;
    public final void rule__PrimitiveType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2011:1: ( rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1 )
            // InternalExprParser.g:2012:2: rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1
            {
            pushFollow(FOLLOW_13);
            rule__PrimitiveType__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_0__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2019:1: rule__PrimitiveType__Group_0__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2023:1: ( ( () ) )
            // InternalExprParser.g:2024:1: ( () )
            {
            // InternalExprParser.g:2024:1: ( () )
            // InternalExprParser.g:2025:1: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getBooleanAction_0_0()); 
            // InternalExprParser.g:2026:1: ()
            // InternalExprParser.g:2028:1: 
            {
            }

             after(grammarAccess.getPrimitiveTypeAccess().getBooleanAction_0_0()); 

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
    // InternalExprParser.g:2038:1: rule__PrimitiveType__Group_0__1 : rule__PrimitiveType__Group_0__1__Impl ;
    public final void rule__PrimitiveType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2042:1: ( rule__PrimitiveType__Group_0__1__Impl )
            // InternalExprParser.g:2043:2: rule__PrimitiveType__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_0__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2049:1: rule__PrimitiveType__Group_0__1__Impl : ( Bool ) ;
    public final void rule__PrimitiveType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2053:1: ( ( Bool ) )
            // InternalExprParser.g:2054:1: ( Bool )
            {
            // InternalExprParser.g:2054:1: ( Bool )
            // InternalExprParser.g:2055:1: Bool
            {
             before(grammarAccess.getPrimitiveTypeAccess().getBoolKeyword_0_1()); 
            match(input,Bool,FOLLOW_2); 
             after(grammarAccess.getPrimitiveTypeAccess().getBoolKeyword_0_1()); 

            }


            }

        }
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
    // InternalExprParser.g:2072:1: rule__PrimitiveType__Group_1__0 : rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1 ;
    public final void rule__PrimitiveType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2076:1: ( rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1 )
            // InternalExprParser.g:2077:2: rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1
            {
            pushFollow(FOLLOW_14);
            rule__PrimitiveType__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_1__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2084:1: rule__PrimitiveType__Group_1__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2088:1: ( ( () ) )
            // InternalExprParser.g:2089:1: ( () )
            {
            // InternalExprParser.g:2089:1: ( () )
            // InternalExprParser.g:2090:1: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getIntegerAction_1_0()); 
            // InternalExprParser.g:2091:1: ()
            // InternalExprParser.g:2093:1: 
            {
            }

             after(grammarAccess.getPrimitiveTypeAccess().getIntegerAction_1_0()); 

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
    // InternalExprParser.g:2103:1: rule__PrimitiveType__Group_1__1 : rule__PrimitiveType__Group_1__1__Impl ;
    public final void rule__PrimitiveType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2107:1: ( rule__PrimitiveType__Group_1__1__Impl )
            // InternalExprParser.g:2108:2: rule__PrimitiveType__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_1__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2114:1: rule__PrimitiveType__Group_1__1__Impl : ( Int ) ;
    public final void rule__PrimitiveType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2118:1: ( ( Int ) )
            // InternalExprParser.g:2119:1: ( Int )
            {
            // InternalExprParser.g:2119:1: ( Int )
            // InternalExprParser.g:2120:1: Int
            {
             before(grammarAccess.getPrimitiveTypeAccess().getIntKeyword_1_1()); 
            match(input,Int,FOLLOW_2); 
             after(grammarAccess.getPrimitiveTypeAccess().getIntKeyword_1_1()); 

            }


            }

        }
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
    // InternalExprParser.g:2137:1: rule__PrimitiveType__Group_2__0 : rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1 ;
    public final void rule__PrimitiveType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2141:1: ( rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1 )
            // InternalExprParser.g:2142:2: rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1
            {
            pushFollow(FOLLOW_15);
            rule__PrimitiveType__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_2__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2149:1: rule__PrimitiveType__Group_2__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2153:1: ( ( () ) )
            // InternalExprParser.g:2154:1: ( () )
            {
            // InternalExprParser.g:2154:1: ( () )
            // InternalExprParser.g:2155:1: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getRealAction_2_0()); 
            // InternalExprParser.g:2156:1: ()
            // InternalExprParser.g:2158:1: 
            {
            }

             after(grammarAccess.getPrimitiveTypeAccess().getRealAction_2_0()); 

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
    // InternalExprParser.g:2168:1: rule__PrimitiveType__Group_2__1 : rule__PrimitiveType__Group_2__1__Impl ;
    public final void rule__PrimitiveType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2172:1: ( rule__PrimitiveType__Group_2__1__Impl )
            // InternalExprParser.g:2173:2: rule__PrimitiveType__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_2__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2179:1: rule__PrimitiveType__Group_2__1__Impl : ( Real ) ;
    public final void rule__PrimitiveType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2183:1: ( ( Real ) )
            // InternalExprParser.g:2184:1: ( Real )
            {
            // InternalExprParser.g:2184:1: ( Real )
            // InternalExprParser.g:2185:1: Real
            {
             before(grammarAccess.getPrimitiveTypeAccess().getRealKeyword_2_1()); 
            match(input,Real,FOLLOW_2); 
             after(grammarAccess.getPrimitiveTypeAccess().getRealKeyword_2_1()); 

            }


            }

        }
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
    // InternalExprParser.g:2202:1: rule__PrimitiveType__Group_3__0 : rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1 ;
    public final void rule__PrimitiveType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2206:1: ( rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1 )
            // InternalExprParser.g:2207:2: rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1
            {
            pushFollow(FOLLOW_16);
            rule__PrimitiveType__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_3__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2214:1: rule__PrimitiveType__Group_3__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2218:1: ( ( () ) )
            // InternalExprParser.g:2219:1: ( () )
            {
            // InternalExprParser.g:2219:1: ( () )
            // InternalExprParser.g:2220:1: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getStringAction_3_0()); 
            // InternalExprParser.g:2221:1: ()
            // InternalExprParser.g:2223:1: 
            {
            }

             after(grammarAccess.getPrimitiveTypeAccess().getStringAction_3_0()); 

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
    // InternalExprParser.g:2233:1: rule__PrimitiveType__Group_3__1 : rule__PrimitiveType__Group_3__1__Impl ;
    public final void rule__PrimitiveType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2237:1: ( rule__PrimitiveType__Group_3__1__Impl )
            // InternalExprParser.g:2238:2: rule__PrimitiveType__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_3__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2244:1: rule__PrimitiveType__Group_3__1__Impl : ( String ) ;
    public final void rule__PrimitiveType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2248:1: ( ( String ) )
            // InternalExprParser.g:2249:1: ( String )
            {
            // InternalExprParser.g:2249:1: ( String )
            // InternalExprParser.g:2250:1: String
            {
             before(grammarAccess.getPrimitiveTypeAccess().getStringKeyword_3_1()); 
            match(input,String,FOLLOW_2); 
             after(grammarAccess.getPrimitiveTypeAccess().getStringKeyword_3_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__RecordType__Group__0"
    // InternalExprParser.g:2267:1: rule__RecordType__Group__0 : rule__RecordType__Group__0__Impl rule__RecordType__Group__1 ;
    public final void rule__RecordType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2271:1: ( rule__RecordType__Group__0__Impl rule__RecordType__Group__1 )
            // InternalExprParser.g:2272:2: rule__RecordType__Group__0__Impl rule__RecordType__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__RecordType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RecordType__Group__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2279:1: rule__RecordType__Group__0__Impl : ( () ) ;
    public final void rule__RecordType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2283:1: ( ( () ) )
            // InternalExprParser.g:2284:1: ( () )
            {
            // InternalExprParser.g:2284:1: ( () )
            // InternalExprParser.g:2285:1: ()
            {
             before(grammarAccess.getRecordTypeAccess().getRecordTypeAction_0()); 
            // InternalExprParser.g:2286:1: ()
            // InternalExprParser.g:2288:1: 
            {
            }

             after(grammarAccess.getRecordTypeAccess().getRecordTypeAction_0()); 

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
    // InternalExprParser.g:2298:1: rule__RecordType__Group__1 : rule__RecordType__Group__1__Impl rule__RecordType__Group__2 ;
    public final void rule__RecordType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2302:1: ( rule__RecordType__Group__1__Impl rule__RecordType__Group__2 )
            // InternalExprParser.g:2303:2: rule__RecordType__Group__1__Impl rule__RecordType__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__RecordType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RecordType__Group__2();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2310:1: rule__RecordType__Group__1__Impl : ( Record ) ;
    public final void rule__RecordType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2314:1: ( ( Record ) )
            // InternalExprParser.g:2315:1: ( Record )
            {
            // InternalExprParser.g:2315:1: ( Record )
            // InternalExprParser.g:2316:1: Record
            {
             before(grammarAccess.getRecordTypeAccess().getRecordKeyword_1()); 
            match(input,Record,FOLLOW_2); 
             after(grammarAccess.getRecordTypeAccess().getRecordKeyword_1()); 

            }


            }

        }
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
    // InternalExprParser.g:2329:1: rule__RecordType__Group__2 : rule__RecordType__Group__2__Impl rule__RecordType__Group__3 ;
    public final void rule__RecordType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2333:1: ( rule__RecordType__Group__2__Impl rule__RecordType__Group__3 )
            // InternalExprParser.g:2334:2: rule__RecordType__Group__2__Impl rule__RecordType__Group__3
            {
            pushFollow(FOLLOW_19);
            rule__RecordType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RecordType__Group__3();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2341:1: rule__RecordType__Group__2__Impl : ( LeftCurlyBracket ) ;
    public final void rule__RecordType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2345:1: ( ( LeftCurlyBracket ) )
            // InternalExprParser.g:2346:1: ( LeftCurlyBracket )
            {
            // InternalExprParser.g:2346:1: ( LeftCurlyBracket )
            // InternalExprParser.g:2347:1: LeftCurlyBracket
            {
             before(grammarAccess.getRecordTypeAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,LeftCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getRecordTypeAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
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
    // InternalExprParser.g:2360:1: rule__RecordType__Group__3 : rule__RecordType__Group__3__Impl rule__RecordType__Group__4 ;
    public final void rule__RecordType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2364:1: ( rule__RecordType__Group__3__Impl rule__RecordType__Group__4 )
            // InternalExprParser.g:2365:2: rule__RecordType__Group__3__Impl rule__RecordType__Group__4
            {
            pushFollow(FOLLOW_19);
            rule__RecordType__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RecordType__Group__4();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2372:1: rule__RecordType__Group__3__Impl : ( ( rule__RecordType__FieldAssignment_3 )* ) ;
    public final void rule__RecordType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2376:1: ( ( ( rule__RecordType__FieldAssignment_3 )* ) )
            // InternalExprParser.g:2377:1: ( ( rule__RecordType__FieldAssignment_3 )* )
            {
            // InternalExprParser.g:2377:1: ( ( rule__RecordType__FieldAssignment_3 )* )
            // InternalExprParser.g:2378:1: ( rule__RecordType__FieldAssignment_3 )*
            {
             before(grammarAccess.getRecordTypeAccess().getFieldAssignment_3()); 
            // InternalExprParser.g:2379:1: ( rule__RecordType__FieldAssignment_3 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_ID) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalExprParser.g:2379:2: rule__RecordType__FieldAssignment_3
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__RecordType__FieldAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getRecordTypeAccess().getFieldAssignment_3()); 

            }


            }

        }
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
    // InternalExprParser.g:2389:1: rule__RecordType__Group__4 : rule__RecordType__Group__4__Impl ;
    public final void rule__RecordType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2393:1: ( rule__RecordType__Group__4__Impl )
            // InternalExprParser.g:2394:2: rule__RecordType__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RecordType__Group__4__Impl();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2400:1: rule__RecordType__Group__4__Impl : ( RightCurlyBracket ) ;
    public final void rule__RecordType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2404:1: ( ( RightCurlyBracket ) )
            // InternalExprParser.g:2405:1: ( RightCurlyBracket )
            {
            // InternalExprParser.g:2405:1: ( RightCurlyBracket )
            // InternalExprParser.g:2406:1: RightCurlyBracket
            {
             before(grammarAccess.getRecordTypeAccess().getRightCurlyBracketKeyword_4()); 
            match(input,RightCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getRecordTypeAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
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
    // InternalExprParser.g:2429:1: rule__Field__Group__0 : rule__Field__Group__0__Impl rule__Field__Group__1 ;
    public final void rule__Field__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2433:1: ( rule__Field__Group__0__Impl rule__Field__Group__1 )
            // InternalExprParser.g:2434:2: rule__Field__Group__0__Impl rule__Field__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Field__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Field__Group__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2441:1: rule__Field__Group__0__Impl : ( ( rule__Field__NameAssignment_0 ) ) ;
    public final void rule__Field__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2445:1: ( ( ( rule__Field__NameAssignment_0 ) ) )
            // InternalExprParser.g:2446:1: ( ( rule__Field__NameAssignment_0 ) )
            {
            // InternalExprParser.g:2446:1: ( ( rule__Field__NameAssignment_0 ) )
            // InternalExprParser.g:2447:1: ( rule__Field__NameAssignment_0 )
            {
             before(grammarAccess.getFieldAccess().getNameAssignment_0()); 
            // InternalExprParser.g:2448:1: ( rule__Field__NameAssignment_0 )
            // InternalExprParser.g:2448:2: rule__Field__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Field__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getFieldAccess().getNameAssignment_0()); 

            }


            }

        }
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
    // InternalExprParser.g:2458:1: rule__Field__Group__1 : rule__Field__Group__1__Impl rule__Field__Group__2 ;
    public final void rule__Field__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2462:1: ( rule__Field__Group__1__Impl rule__Field__Group__2 )
            // InternalExprParser.g:2463:2: rule__Field__Group__1__Impl rule__Field__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__Field__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Field__Group__2();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2470:1: rule__Field__Group__1__Impl : ( Colon ) ;
    public final void rule__Field__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2474:1: ( ( Colon ) )
            // InternalExprParser.g:2475:1: ( Colon )
            {
            // InternalExprParser.g:2475:1: ( Colon )
            // InternalExprParser.g:2476:1: Colon
            {
             before(grammarAccess.getFieldAccess().getColonKeyword_1()); 
            match(input,Colon,FOLLOW_2); 
             after(grammarAccess.getFieldAccess().getColonKeyword_1()); 

            }


            }

        }
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
    // InternalExprParser.g:2489:1: rule__Field__Group__2 : rule__Field__Group__2__Impl rule__Field__Group__3 ;
    public final void rule__Field__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2493:1: ( rule__Field__Group__2__Impl rule__Field__Group__3 )
            // InternalExprParser.g:2494:2: rule__Field__Group__2__Impl rule__Field__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__Field__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Field__Group__3();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2501:1: rule__Field__Group__2__Impl : ( ( rule__Field__TypeAssignment_2 ) ) ;
    public final void rule__Field__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2505:1: ( ( ( rule__Field__TypeAssignment_2 ) ) )
            // InternalExprParser.g:2506:1: ( ( rule__Field__TypeAssignment_2 ) )
            {
            // InternalExprParser.g:2506:1: ( ( rule__Field__TypeAssignment_2 ) )
            // InternalExprParser.g:2507:1: ( rule__Field__TypeAssignment_2 )
            {
             before(grammarAccess.getFieldAccess().getTypeAssignment_2()); 
            // InternalExprParser.g:2508:1: ( rule__Field__TypeAssignment_2 )
            // InternalExprParser.g:2508:2: rule__Field__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Field__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFieldAccess().getTypeAssignment_2()); 

            }


            }

        }
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
    // InternalExprParser.g:2518:1: rule__Field__Group__3 : rule__Field__Group__3__Impl ;
    public final void rule__Field__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2522:1: ( rule__Field__Group__3__Impl )
            // InternalExprParser.g:2523:2: rule__Field__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Field__Group__3__Impl();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2529:1: rule__Field__Group__3__Impl : ( Semicolon ) ;
    public final void rule__Field__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2533:1: ( ( Semicolon ) )
            // InternalExprParser.g:2534:1: ( Semicolon )
            {
            // InternalExprParser.g:2534:1: ( Semicolon )
            // InternalExprParser.g:2535:1: Semicolon
            {
             before(grammarAccess.getFieldAccess().getSemicolonKeyword_3()); 
            match(input,Semicolon,FOLLOW_2); 
             after(grammarAccess.getFieldAccess().getSemicolonKeyword_3()); 

            }


            }

        }
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
    // InternalExprParser.g:2556:1: rule__UnionType__Group__0 : rule__UnionType__Group__0__Impl rule__UnionType__Group__1 ;
    public final void rule__UnionType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2560:1: ( rule__UnionType__Group__0__Impl rule__UnionType__Group__1 )
            // InternalExprParser.g:2561:2: rule__UnionType__Group__0__Impl rule__UnionType__Group__1
            {
            pushFollow(FOLLOW_21);
            rule__UnionType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UnionType__Group__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2568:1: rule__UnionType__Group__0__Impl : ( () ) ;
    public final void rule__UnionType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2572:1: ( ( () ) )
            // InternalExprParser.g:2573:1: ( () )
            {
            // InternalExprParser.g:2573:1: ( () )
            // InternalExprParser.g:2574:1: ()
            {
             before(grammarAccess.getUnionTypeAccess().getUnionTypeAction_0()); 
            // InternalExprParser.g:2575:1: ()
            // InternalExprParser.g:2577:1: 
            {
            }

             after(grammarAccess.getUnionTypeAccess().getUnionTypeAction_0()); 

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
    // InternalExprParser.g:2587:1: rule__UnionType__Group__1 : rule__UnionType__Group__1__Impl rule__UnionType__Group__2 ;
    public final void rule__UnionType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2591:1: ( rule__UnionType__Group__1__Impl rule__UnionType__Group__2 )
            // InternalExprParser.g:2592:2: rule__UnionType__Group__1__Impl rule__UnionType__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__UnionType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UnionType__Group__2();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2599:1: rule__UnionType__Group__1__Impl : ( Union ) ;
    public final void rule__UnionType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2603:1: ( ( Union ) )
            // InternalExprParser.g:2604:1: ( Union )
            {
            // InternalExprParser.g:2604:1: ( Union )
            // InternalExprParser.g:2605:1: Union
            {
             before(grammarAccess.getUnionTypeAccess().getUnionKeyword_1()); 
            match(input,Union,FOLLOW_2); 
             after(grammarAccess.getUnionTypeAccess().getUnionKeyword_1()); 

            }


            }

        }
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
    // InternalExprParser.g:2618:1: rule__UnionType__Group__2 : rule__UnionType__Group__2__Impl rule__UnionType__Group__3 ;
    public final void rule__UnionType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2622:1: ( rule__UnionType__Group__2__Impl rule__UnionType__Group__3 )
            // InternalExprParser.g:2623:2: rule__UnionType__Group__2__Impl rule__UnionType__Group__3
            {
            pushFollow(FOLLOW_10);
            rule__UnionType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UnionType__Group__3();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2630:1: rule__UnionType__Group__2__Impl : ( LeftCurlyBracket ) ;
    public final void rule__UnionType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2634:1: ( ( LeftCurlyBracket ) )
            // InternalExprParser.g:2635:1: ( LeftCurlyBracket )
            {
            // InternalExprParser.g:2635:1: ( LeftCurlyBracket )
            // InternalExprParser.g:2636:1: LeftCurlyBracket
            {
             before(grammarAccess.getUnionTypeAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,LeftCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getUnionTypeAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
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
    // InternalExprParser.g:2649:1: rule__UnionType__Group__3 : rule__UnionType__Group__3__Impl rule__UnionType__Group__4 ;
    public final void rule__UnionType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2653:1: ( rule__UnionType__Group__3__Impl rule__UnionType__Group__4 )
            // InternalExprParser.g:2654:2: rule__UnionType__Group__3__Impl rule__UnionType__Group__4
            {
            pushFollow(FOLLOW_22);
            rule__UnionType__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UnionType__Group__4();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2661:1: rule__UnionType__Group__3__Impl : ( QuestionMarkQuestionMarkQuestionMark ) ;
    public final void rule__UnionType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2665:1: ( ( QuestionMarkQuestionMarkQuestionMark ) )
            // InternalExprParser.g:2666:1: ( QuestionMarkQuestionMarkQuestionMark )
            {
            // InternalExprParser.g:2666:1: ( QuestionMarkQuestionMarkQuestionMark )
            // InternalExprParser.g:2667:1: QuestionMarkQuestionMarkQuestionMark
            {
             before(grammarAccess.getUnionTypeAccess().getQuestionMarkQuestionMarkQuestionMarkKeyword_3()); 
            match(input,QuestionMarkQuestionMarkQuestionMark,FOLLOW_2); 
             after(grammarAccess.getUnionTypeAccess().getQuestionMarkQuestionMarkQuestionMarkKeyword_3()); 

            }


            }

        }
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
    // InternalExprParser.g:2680:1: rule__UnionType__Group__4 : rule__UnionType__Group__4__Impl ;
    public final void rule__UnionType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2684:1: ( rule__UnionType__Group__4__Impl )
            // InternalExprParser.g:2685:2: rule__UnionType__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UnionType__Group__4__Impl();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2691:1: rule__UnionType__Group__4__Impl : ( RightCurlyBracket ) ;
    public final void rule__UnionType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2695:1: ( ( RightCurlyBracket ) )
            // InternalExprParser.g:2696:1: ( RightCurlyBracket )
            {
            // InternalExprParser.g:2696:1: ( RightCurlyBracket )
            // InternalExprParser.g:2697:1: RightCurlyBracket
            {
             before(grammarAccess.getUnionTypeAccess().getRightCurlyBracketKeyword_4()); 
            match(input,RightCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getUnionTypeAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
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
    // InternalExprParser.g:2720:1: rule__TupleType__Group__0 : rule__TupleType__Group__0__Impl rule__TupleType__Group__1 ;
    public final void rule__TupleType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2724:1: ( rule__TupleType__Group__0__Impl rule__TupleType__Group__1 )
            // InternalExprParser.g:2725:2: rule__TupleType__Group__0__Impl rule__TupleType__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__TupleType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TupleType__Group__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2732:1: rule__TupleType__Group__0__Impl : ( () ) ;
    public final void rule__TupleType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2736:1: ( ( () ) )
            // InternalExprParser.g:2737:1: ( () )
            {
            // InternalExprParser.g:2737:1: ( () )
            // InternalExprParser.g:2738:1: ()
            {
             before(grammarAccess.getTupleTypeAccess().getTupleTypeAction_0()); 
            // InternalExprParser.g:2739:1: ()
            // InternalExprParser.g:2741:1: 
            {
            }

             after(grammarAccess.getTupleTypeAccess().getTupleTypeAction_0()); 

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
    // InternalExprParser.g:2751:1: rule__TupleType__Group__1 : rule__TupleType__Group__1__Impl rule__TupleType__Group__2 ;
    public final void rule__TupleType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2755:1: ( rule__TupleType__Group__1__Impl rule__TupleType__Group__2 )
            // InternalExprParser.g:2756:2: rule__TupleType__Group__1__Impl rule__TupleType__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__TupleType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TupleType__Group__2();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2763:1: rule__TupleType__Group__1__Impl : ( Tuple ) ;
    public final void rule__TupleType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2767:1: ( ( Tuple ) )
            // InternalExprParser.g:2768:1: ( Tuple )
            {
            // InternalExprParser.g:2768:1: ( Tuple )
            // InternalExprParser.g:2769:1: Tuple
            {
             before(grammarAccess.getTupleTypeAccess().getTupleKeyword_1()); 
            match(input,Tuple,FOLLOW_2); 
             after(grammarAccess.getTupleTypeAccess().getTupleKeyword_1()); 

            }


            }

        }
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
    // InternalExprParser.g:2782:1: rule__TupleType__Group__2 : rule__TupleType__Group__2__Impl rule__TupleType__Group__3 ;
    public final void rule__TupleType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2786:1: ( rule__TupleType__Group__2__Impl rule__TupleType__Group__3 )
            // InternalExprParser.g:2787:2: rule__TupleType__Group__2__Impl rule__TupleType__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__TupleType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TupleType__Group__3();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2794:1: rule__TupleType__Group__2__Impl : ( LeftCurlyBracket ) ;
    public final void rule__TupleType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2798:1: ( ( LeftCurlyBracket ) )
            // InternalExprParser.g:2799:1: ( LeftCurlyBracket )
            {
            // InternalExprParser.g:2799:1: ( LeftCurlyBracket )
            // InternalExprParser.g:2800:1: LeftCurlyBracket
            {
             before(grammarAccess.getTupleTypeAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,LeftCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getTupleTypeAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
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
    // InternalExprParser.g:2813:1: rule__TupleType__Group__3 : rule__TupleType__Group__3__Impl rule__TupleType__Group__4 ;
    public final void rule__TupleType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2817:1: ( rule__TupleType__Group__3__Impl rule__TupleType__Group__4 )
            // InternalExprParser.g:2818:2: rule__TupleType__Group__3__Impl rule__TupleType__Group__4
            {
            pushFollow(FOLLOW_24);
            rule__TupleType__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TupleType__Group__4();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2825:1: rule__TupleType__Group__3__Impl : ( ( rule__TupleType__FieldAssignment_3 )* ) ;
    public final void rule__TupleType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2829:1: ( ( ( rule__TupleType__FieldAssignment_3 )* ) )
            // InternalExprParser.g:2830:1: ( ( rule__TupleType__FieldAssignment_3 )* )
            {
            // InternalExprParser.g:2830:1: ( ( rule__TupleType__FieldAssignment_3 )* )
            // InternalExprParser.g:2831:1: ( rule__TupleType__FieldAssignment_3 )*
            {
             before(grammarAccess.getTupleTypeAccess().getFieldAssignment_3()); 
            // InternalExprParser.g:2832:1: ( rule__TupleType__FieldAssignment_3 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=VIRTUAL_PROCESSOR && LA13_0<=PROCESSOR)||(LA13_0>=ABSTRACT && LA13_0<=PROCESS)||(LA13_0>=DEVICE && LA13_0<=Real)||(LA13_0>=BUS && LA13_0<=Bag)||(LA13_0>=Int && LA13_0<=Set)||LA13_0==RULE_ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalExprParser.g:2832:2: rule__TupleType__FieldAssignment_3
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__TupleType__FieldAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getTupleTypeAccess().getFieldAssignment_3()); 

            }


            }

        }
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
    // InternalExprParser.g:2842:1: rule__TupleType__Group__4 : rule__TupleType__Group__4__Impl ;
    public final void rule__TupleType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2846:1: ( rule__TupleType__Group__4__Impl )
            // InternalExprParser.g:2847:2: rule__TupleType__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TupleType__Group__4__Impl();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2853:1: rule__TupleType__Group__4__Impl : ( RightCurlyBracket ) ;
    public final void rule__TupleType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2857:1: ( ( RightCurlyBracket ) )
            // InternalExprParser.g:2858:1: ( RightCurlyBracket )
            {
            // InternalExprParser.g:2858:1: ( RightCurlyBracket )
            // InternalExprParser.g:2859:1: RightCurlyBracket
            {
             before(grammarAccess.getTupleTypeAccess().getRightCurlyBracketKeyword_4()); 
            match(input,RightCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getTupleTypeAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
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
    // InternalExprParser.g:2882:1: rule__TupleField__Group__0 : rule__TupleField__Group__0__Impl rule__TupleField__Group__1 ;
    public final void rule__TupleField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2886:1: ( rule__TupleField__Group__0__Impl rule__TupleField__Group__1 )
            // InternalExprParser.g:2887:2: rule__TupleField__Group__0__Impl rule__TupleField__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__TupleField__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TupleField__Group__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2894:1: rule__TupleField__Group__0__Impl : ( () ) ;
    public final void rule__TupleField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2898:1: ( ( () ) )
            // InternalExprParser.g:2899:1: ( () )
            {
            // InternalExprParser.g:2899:1: ( () )
            // InternalExprParser.g:2900:1: ()
            {
             before(grammarAccess.getTupleFieldAccess().getFieldAction_0()); 
            // InternalExprParser.g:2901:1: ()
            // InternalExprParser.g:2903:1: 
            {
            }

             after(grammarAccess.getTupleFieldAccess().getFieldAction_0()); 

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
    // InternalExprParser.g:2913:1: rule__TupleField__Group__1 : rule__TupleField__Group__1__Impl rule__TupleField__Group__2 ;
    public final void rule__TupleField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2917:1: ( rule__TupleField__Group__1__Impl rule__TupleField__Group__2 )
            // InternalExprParser.g:2918:2: rule__TupleField__Group__1__Impl rule__TupleField__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__TupleField__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TupleField__Group__2();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2925:1: rule__TupleField__Group__1__Impl : ( ( rule__TupleField__TypeAssignment_1 ) ) ;
    public final void rule__TupleField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2929:1: ( ( ( rule__TupleField__TypeAssignment_1 ) ) )
            // InternalExprParser.g:2930:1: ( ( rule__TupleField__TypeAssignment_1 ) )
            {
            // InternalExprParser.g:2930:1: ( ( rule__TupleField__TypeAssignment_1 ) )
            // InternalExprParser.g:2931:1: ( rule__TupleField__TypeAssignment_1 )
            {
             before(grammarAccess.getTupleFieldAccess().getTypeAssignment_1()); 
            // InternalExprParser.g:2932:1: ( rule__TupleField__TypeAssignment_1 )
            // InternalExprParser.g:2932:2: rule__TupleField__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TupleField__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTupleFieldAccess().getTypeAssignment_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__TupleField__Group__2"
    // InternalExprParser.g:2942:1: rule__TupleField__Group__2 : rule__TupleField__Group__2__Impl ;
    public final void rule__TupleField__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2946:1: ( rule__TupleField__Group__2__Impl )
            // InternalExprParser.g:2947:2: rule__TupleField__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TupleField__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleField__Group__2"


    // $ANTLR start "rule__TupleField__Group__2__Impl"
    // InternalExprParser.g:2953:1: rule__TupleField__Group__2__Impl : ( Semicolon ) ;
    public final void rule__TupleField__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2957:1: ( ( Semicolon ) )
            // InternalExprParser.g:2958:1: ( Semicolon )
            {
            // InternalExprParser.g:2958:1: ( Semicolon )
            // InternalExprParser.g:2959:1: Semicolon
            {
             before(grammarAccess.getTupleFieldAccess().getSemicolonKeyword_2()); 
            match(input,Semicolon,FOLLOW_2); 
             after(grammarAccess.getTupleFieldAccess().getSemicolonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleField__Group__2__Impl"


    // $ANTLR start "rule__ListType__Group__0"
    // InternalExprParser.g:2978:1: rule__ListType__Group__0 : rule__ListType__Group__0__Impl rule__ListType__Group__1 ;
    public final void rule__ListType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2982:1: ( rule__ListType__Group__0__Impl rule__ListType__Group__1 )
            // InternalExprParser.g:2983:2: rule__ListType__Group__0__Impl rule__ListType__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__ListType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ListType__Group__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:2990:1: rule__ListType__Group__0__Impl : ( () ) ;
    public final void rule__ListType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:2994:1: ( ( () ) )
            // InternalExprParser.g:2995:1: ( () )
            {
            // InternalExprParser.g:2995:1: ( () )
            // InternalExprParser.g:2996:1: ()
            {
             before(grammarAccess.getListTypeAccess().getListTypeAction_0()); 
            // InternalExprParser.g:2997:1: ()
            // InternalExprParser.g:2999:1: 
            {
            }

             after(grammarAccess.getListTypeAccess().getListTypeAction_0()); 

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
    // InternalExprParser.g:3009:1: rule__ListType__Group__1 : rule__ListType__Group__1__Impl rule__ListType__Group__2 ;
    public final void rule__ListType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3013:1: ( rule__ListType__Group__1__Impl rule__ListType__Group__2 )
            // InternalExprParser.g:3014:2: rule__ListType__Group__1__Impl rule__ListType__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__ListType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ListType__Group__2();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:3021:1: rule__ListType__Group__1__Impl : ( List ) ;
    public final void rule__ListType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3025:1: ( ( List ) )
            // InternalExprParser.g:3026:1: ( List )
            {
            // InternalExprParser.g:3026:1: ( List )
            // InternalExprParser.g:3027:1: List
            {
             before(grammarAccess.getListTypeAccess().getListKeyword_1()); 
            match(input,List,FOLLOW_2); 
             after(grammarAccess.getListTypeAccess().getListKeyword_1()); 

            }


            }

        }
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
    // InternalExprParser.g:3040:1: rule__ListType__Group__2 : rule__ListType__Group__2__Impl rule__ListType__Group__3 ;
    public final void rule__ListType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3044:1: ( rule__ListType__Group__2__Impl rule__ListType__Group__3 )
            // InternalExprParser.g:3045:2: rule__ListType__Group__2__Impl rule__ListType__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__ListType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ListType__Group__3();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:3052:1: rule__ListType__Group__2__Impl : ( LeftCurlyBracket ) ;
    public final void rule__ListType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3056:1: ( ( LeftCurlyBracket ) )
            // InternalExprParser.g:3057:1: ( LeftCurlyBracket )
            {
            // InternalExprParser.g:3057:1: ( LeftCurlyBracket )
            // InternalExprParser.g:3058:1: LeftCurlyBracket
            {
             before(grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,LeftCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
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
    // InternalExprParser.g:3071:1: rule__ListType__Group__3 : rule__ListType__Group__3__Impl rule__ListType__Group__4 ;
    public final void rule__ListType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3075:1: ( rule__ListType__Group__3__Impl rule__ListType__Group__4 )
            // InternalExprParser.g:3076:2: rule__ListType__Group__3__Impl rule__ListType__Group__4
            {
            pushFollow(FOLLOW_22);
            rule__ListType__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ListType__Group__4();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:3083:1: rule__ListType__Group__3__Impl : ( ( rule__ListType__TypeAssignment_3 ) ) ;
    public final void rule__ListType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3087:1: ( ( ( rule__ListType__TypeAssignment_3 ) ) )
            // InternalExprParser.g:3088:1: ( ( rule__ListType__TypeAssignment_3 ) )
            {
            // InternalExprParser.g:3088:1: ( ( rule__ListType__TypeAssignment_3 ) )
            // InternalExprParser.g:3089:1: ( rule__ListType__TypeAssignment_3 )
            {
             before(grammarAccess.getListTypeAccess().getTypeAssignment_3()); 
            // InternalExprParser.g:3090:1: ( rule__ListType__TypeAssignment_3 )
            // InternalExprParser.g:3090:2: rule__ListType__TypeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__ListType__TypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getListTypeAccess().getTypeAssignment_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__ListType__Group__4"
    // InternalExprParser.g:3100:1: rule__ListType__Group__4 : rule__ListType__Group__4__Impl ;
    public final void rule__ListType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3104:1: ( rule__ListType__Group__4__Impl )
            // InternalExprParser.g:3105:2: rule__ListType__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ListType__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group__4"


    // $ANTLR start "rule__ListType__Group__4__Impl"
    // InternalExprParser.g:3111:1: rule__ListType__Group__4__Impl : ( RightCurlyBracket ) ;
    public final void rule__ListType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3115:1: ( ( RightCurlyBracket ) )
            // InternalExprParser.g:3116:1: ( RightCurlyBracket )
            {
            // InternalExprParser.g:3116:1: ( RightCurlyBracket )
            // InternalExprParser.g:3117:1: RightCurlyBracket
            {
             before(grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_4()); 
            match(input,RightCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group__4__Impl"


    // $ANTLR start "rule__SetType__Group__0"
    // InternalExprParser.g:3140:1: rule__SetType__Group__0 : rule__SetType__Group__0__Impl rule__SetType__Group__1 ;
    public final void rule__SetType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3144:1: ( rule__SetType__Group__0__Impl rule__SetType__Group__1 )
            // InternalExprParser.g:3145:2: rule__SetType__Group__0__Impl rule__SetType__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__SetType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SetType__Group__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:3152:1: rule__SetType__Group__0__Impl : ( Set ) ;
    public final void rule__SetType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3156:1: ( ( Set ) )
            // InternalExprParser.g:3157:1: ( Set )
            {
            // InternalExprParser.g:3157:1: ( Set )
            // InternalExprParser.g:3158:1: Set
            {
             before(grammarAccess.getSetTypeAccess().getSetKeyword_0()); 
            match(input,Set,FOLLOW_2); 
             after(grammarAccess.getSetTypeAccess().getSetKeyword_0()); 

            }


            }

        }
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
    // InternalExprParser.g:3171:1: rule__SetType__Group__1 : rule__SetType__Group__1__Impl rule__SetType__Group__2 ;
    public final void rule__SetType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3175:1: ( rule__SetType__Group__1__Impl rule__SetType__Group__2 )
            // InternalExprParser.g:3176:2: rule__SetType__Group__1__Impl rule__SetType__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__SetType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SetType__Group__2();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:3183:1: rule__SetType__Group__1__Impl : ( LeftCurlyBracket ) ;
    public final void rule__SetType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3187:1: ( ( LeftCurlyBracket ) )
            // InternalExprParser.g:3188:1: ( LeftCurlyBracket )
            {
            // InternalExprParser.g:3188:1: ( LeftCurlyBracket )
            // InternalExprParser.g:3189:1: LeftCurlyBracket
            {
             before(grammarAccess.getSetTypeAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,LeftCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getSetTypeAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
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
    // InternalExprParser.g:3202:1: rule__SetType__Group__2 : rule__SetType__Group__2__Impl rule__SetType__Group__3 ;
    public final void rule__SetType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3206:1: ( rule__SetType__Group__2__Impl rule__SetType__Group__3 )
            // InternalExprParser.g:3207:2: rule__SetType__Group__2__Impl rule__SetType__Group__3
            {
            pushFollow(FOLLOW_22);
            rule__SetType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SetType__Group__3();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:3214:1: rule__SetType__Group__2__Impl : ( ( rule__SetType__TypeAssignment_2 ) ) ;
    public final void rule__SetType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3218:1: ( ( ( rule__SetType__TypeAssignment_2 ) ) )
            // InternalExprParser.g:3219:1: ( ( rule__SetType__TypeAssignment_2 ) )
            {
            // InternalExprParser.g:3219:1: ( ( rule__SetType__TypeAssignment_2 ) )
            // InternalExprParser.g:3220:1: ( rule__SetType__TypeAssignment_2 )
            {
             before(grammarAccess.getSetTypeAccess().getTypeAssignment_2()); 
            // InternalExprParser.g:3221:1: ( rule__SetType__TypeAssignment_2 )
            // InternalExprParser.g:3221:2: rule__SetType__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__SetType__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSetTypeAccess().getTypeAssignment_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__SetType__Group__3"
    // InternalExprParser.g:3231:1: rule__SetType__Group__3 : rule__SetType__Group__3__Impl ;
    public final void rule__SetType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3235:1: ( rule__SetType__Group__3__Impl )
            // InternalExprParser.g:3236:2: rule__SetType__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SetType__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetType__Group__3"


    // $ANTLR start "rule__SetType__Group__3__Impl"
    // InternalExprParser.g:3242:1: rule__SetType__Group__3__Impl : ( RightCurlyBracket ) ;
    public final void rule__SetType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3246:1: ( ( RightCurlyBracket ) )
            // InternalExprParser.g:3247:1: ( RightCurlyBracket )
            {
            // InternalExprParser.g:3247:1: ( RightCurlyBracket )
            // InternalExprParser.g:3248:1: RightCurlyBracket
            {
             before(grammarAccess.getSetTypeAccess().getRightCurlyBracketKeyword_3()); 
            match(input,RightCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getSetTypeAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetType__Group__3__Impl"


    // $ANTLR start "rule__BagType__Group__0"
    // InternalExprParser.g:3269:1: rule__BagType__Group__0 : rule__BagType__Group__0__Impl rule__BagType__Group__1 ;
    public final void rule__BagType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3273:1: ( rule__BagType__Group__0__Impl rule__BagType__Group__1 )
            // InternalExprParser.g:3274:2: rule__BagType__Group__0__Impl rule__BagType__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__BagType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BagType__Group__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:3281:1: rule__BagType__Group__0__Impl : ( Bag ) ;
    public final void rule__BagType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3285:1: ( ( Bag ) )
            // InternalExprParser.g:3286:1: ( Bag )
            {
            // InternalExprParser.g:3286:1: ( Bag )
            // InternalExprParser.g:3287:1: Bag
            {
             before(grammarAccess.getBagTypeAccess().getBagKeyword_0()); 
            match(input,Bag,FOLLOW_2); 
             after(grammarAccess.getBagTypeAccess().getBagKeyword_0()); 

            }


            }

        }
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
    // InternalExprParser.g:3300:1: rule__BagType__Group__1 : rule__BagType__Group__1__Impl rule__BagType__Group__2 ;
    public final void rule__BagType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3304:1: ( rule__BagType__Group__1__Impl rule__BagType__Group__2 )
            // InternalExprParser.g:3305:2: rule__BagType__Group__1__Impl rule__BagType__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__BagType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BagType__Group__2();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:3312:1: rule__BagType__Group__1__Impl : ( LeftCurlyBracket ) ;
    public final void rule__BagType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3316:1: ( ( LeftCurlyBracket ) )
            // InternalExprParser.g:3317:1: ( LeftCurlyBracket )
            {
            // InternalExprParser.g:3317:1: ( LeftCurlyBracket )
            // InternalExprParser.g:3318:1: LeftCurlyBracket
            {
             before(grammarAccess.getBagTypeAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,LeftCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getBagTypeAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
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
    // InternalExprParser.g:3331:1: rule__BagType__Group__2 : rule__BagType__Group__2__Impl rule__BagType__Group__3 ;
    public final void rule__BagType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3335:1: ( rule__BagType__Group__2__Impl rule__BagType__Group__3 )
            // InternalExprParser.g:3336:2: rule__BagType__Group__2__Impl rule__BagType__Group__3
            {
            pushFollow(FOLLOW_22);
            rule__BagType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BagType__Group__3();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:3343:1: rule__BagType__Group__2__Impl : ( ( rule__BagType__TypeAssignment_2 ) ) ;
    public final void rule__BagType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3347:1: ( ( ( rule__BagType__TypeAssignment_2 ) ) )
            // InternalExprParser.g:3348:1: ( ( rule__BagType__TypeAssignment_2 ) )
            {
            // InternalExprParser.g:3348:1: ( ( rule__BagType__TypeAssignment_2 ) )
            // InternalExprParser.g:3349:1: ( rule__BagType__TypeAssignment_2 )
            {
             before(grammarAccess.getBagTypeAccess().getTypeAssignment_2()); 
            // InternalExprParser.g:3350:1: ( rule__BagType__TypeAssignment_2 )
            // InternalExprParser.g:3350:2: rule__BagType__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__BagType__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getBagTypeAccess().getTypeAssignment_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__BagType__Group__3"
    // InternalExprParser.g:3360:1: rule__BagType__Group__3 : rule__BagType__Group__3__Impl ;
    public final void rule__BagType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3364:1: ( rule__BagType__Group__3__Impl )
            // InternalExprParser.g:3365:2: rule__BagType__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BagType__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagType__Group__3"


    // $ANTLR start "rule__BagType__Group__3__Impl"
    // InternalExprParser.g:3371:1: rule__BagType__Group__3__Impl : ( RightCurlyBracket ) ;
    public final void rule__BagType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3375:1: ( ( RightCurlyBracket ) )
            // InternalExprParser.g:3376:1: ( RightCurlyBracket )
            {
            // InternalExprParser.g:3376:1: ( RightCurlyBracket )
            // InternalExprParser.g:3377:1: RightCurlyBracket
            {
             before(grammarAccess.getBagTypeAccess().getRightCurlyBracketKeyword_3()); 
            match(input,RightCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getBagTypeAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagType__Group__3__Impl"


    // $ANTLR start "rule__MapType__Group__0"
    // InternalExprParser.g:3398:1: rule__MapType__Group__0 : rule__MapType__Group__0__Impl rule__MapType__Group__1 ;
    public final void rule__MapType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3402:1: ( rule__MapType__Group__0__Impl rule__MapType__Group__1 )
            // InternalExprParser.g:3403:2: rule__MapType__Group__0__Impl rule__MapType__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__MapType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MapType__Group__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:3410:1: rule__MapType__Group__0__Impl : ( Map ) ;
    public final void rule__MapType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3414:1: ( ( Map ) )
            // InternalExprParser.g:3415:1: ( Map )
            {
            // InternalExprParser.g:3415:1: ( Map )
            // InternalExprParser.g:3416:1: Map
            {
             before(grammarAccess.getMapTypeAccess().getMapKeyword_0()); 
            match(input,Map,FOLLOW_2); 
             after(grammarAccess.getMapTypeAccess().getMapKeyword_0()); 

            }


            }

        }
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
    // InternalExprParser.g:3429:1: rule__MapType__Group__1 : rule__MapType__Group__1__Impl rule__MapType__Group__2 ;
    public final void rule__MapType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3433:1: ( rule__MapType__Group__1__Impl rule__MapType__Group__2 )
            // InternalExprParser.g:3434:2: rule__MapType__Group__1__Impl rule__MapType__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__MapType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MapType__Group__2();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:3441:1: rule__MapType__Group__1__Impl : ( LeftCurlyBracket ) ;
    public final void rule__MapType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3445:1: ( ( LeftCurlyBracket ) )
            // InternalExprParser.g:3446:1: ( LeftCurlyBracket )
            {
            // InternalExprParser.g:3446:1: ( LeftCurlyBracket )
            // InternalExprParser.g:3447:1: LeftCurlyBracket
            {
             before(grammarAccess.getMapTypeAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,LeftCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getMapTypeAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
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
    // InternalExprParser.g:3460:1: rule__MapType__Group__2 : rule__MapType__Group__2__Impl rule__MapType__Group__3 ;
    public final void rule__MapType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3464:1: ( rule__MapType__Group__2__Impl rule__MapType__Group__3 )
            // InternalExprParser.g:3465:2: rule__MapType__Group__2__Impl rule__MapType__Group__3
            {
            pushFollow(FOLLOW_27);
            rule__MapType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MapType__Group__3();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:3472:1: rule__MapType__Group__2__Impl : ( ( rule__MapType__DomAssignment_2 ) ) ;
    public final void rule__MapType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3476:1: ( ( ( rule__MapType__DomAssignment_2 ) ) )
            // InternalExprParser.g:3477:1: ( ( rule__MapType__DomAssignment_2 ) )
            {
            // InternalExprParser.g:3477:1: ( ( rule__MapType__DomAssignment_2 ) )
            // InternalExprParser.g:3478:1: ( rule__MapType__DomAssignment_2 )
            {
             before(grammarAccess.getMapTypeAccess().getDomAssignment_2()); 
            // InternalExprParser.g:3479:1: ( rule__MapType__DomAssignment_2 )
            // InternalExprParser.g:3479:2: rule__MapType__DomAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__MapType__DomAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMapTypeAccess().getDomAssignment_2()); 

            }


            }

        }
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
    // InternalExprParser.g:3489:1: rule__MapType__Group__3 : rule__MapType__Group__3__Impl rule__MapType__Group__4 ;
    public final void rule__MapType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3493:1: ( rule__MapType__Group__3__Impl rule__MapType__Group__4 )
            // InternalExprParser.g:3494:2: rule__MapType__Group__3__Impl rule__MapType__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__MapType__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MapType__Group__4();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:3501:1: rule__MapType__Group__3__Impl : ( HyphenMinusGreaterThanSign ) ;
    public final void rule__MapType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3505:1: ( ( HyphenMinusGreaterThanSign ) )
            // InternalExprParser.g:3506:1: ( HyphenMinusGreaterThanSign )
            {
            // InternalExprParser.g:3506:1: ( HyphenMinusGreaterThanSign )
            // InternalExprParser.g:3507:1: HyphenMinusGreaterThanSign
            {
             before(grammarAccess.getMapTypeAccess().getHyphenMinusGreaterThanSignKeyword_3()); 
            match(input,HyphenMinusGreaterThanSign,FOLLOW_2); 
             after(grammarAccess.getMapTypeAccess().getHyphenMinusGreaterThanSignKeyword_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__MapType__Group__4"
    // InternalExprParser.g:3520:1: rule__MapType__Group__4 : rule__MapType__Group__4__Impl rule__MapType__Group__5 ;
    public final void rule__MapType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3524:1: ( rule__MapType__Group__4__Impl rule__MapType__Group__5 )
            // InternalExprParser.g:3525:2: rule__MapType__Group__4__Impl rule__MapType__Group__5
            {
            pushFollow(FOLLOW_22);
            rule__MapType__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MapType__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__4"


    // $ANTLR start "rule__MapType__Group__4__Impl"
    // InternalExprParser.g:3532:1: rule__MapType__Group__4__Impl : ( ( rule__MapType__ImgAssignment_4 ) ) ;
    public final void rule__MapType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3536:1: ( ( ( rule__MapType__ImgAssignment_4 ) ) )
            // InternalExprParser.g:3537:1: ( ( rule__MapType__ImgAssignment_4 ) )
            {
            // InternalExprParser.g:3537:1: ( ( rule__MapType__ImgAssignment_4 ) )
            // InternalExprParser.g:3538:1: ( rule__MapType__ImgAssignment_4 )
            {
             before(grammarAccess.getMapTypeAccess().getImgAssignment_4()); 
            // InternalExprParser.g:3539:1: ( rule__MapType__ImgAssignment_4 )
            // InternalExprParser.g:3539:2: rule__MapType__ImgAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__MapType__ImgAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getMapTypeAccess().getImgAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__4__Impl"


    // $ANTLR start "rule__MapType__Group__5"
    // InternalExprParser.g:3549:1: rule__MapType__Group__5 : rule__MapType__Group__5__Impl ;
    public final void rule__MapType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3553:1: ( rule__MapType__Group__5__Impl )
            // InternalExprParser.g:3554:2: rule__MapType__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MapType__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__5"


    // $ANTLR start "rule__MapType__Group__5__Impl"
    // InternalExprParser.g:3560:1: rule__MapType__Group__5__Impl : ( RightCurlyBracket ) ;
    public final void rule__MapType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3564:1: ( ( RightCurlyBracket ) )
            // InternalExprParser.g:3565:1: ( RightCurlyBracket )
            {
            // InternalExprParser.g:3565:1: ( RightCurlyBracket )
            // InternalExprParser.g:3566:1: RightCurlyBracket
            {
             before(grammarAccess.getMapTypeAccess().getRightCurlyBracketKeyword_5()); 
            match(input,RightCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getMapTypeAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__5__Impl"


    // $ANTLR start "rule__QCREF__Group__0"
    // InternalExprParser.g:3594:1: rule__QCREF__Group__0 : rule__QCREF__Group__0__Impl rule__QCREF__Group__1 ;
    public final void rule__QCREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3598:1: ( rule__QCREF__Group__0__Impl rule__QCREF__Group__1 )
            // InternalExprParser.g:3599:2: rule__QCREF__Group__0__Impl rule__QCREF__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__QCREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QCREF__Group__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:3606:1: rule__QCREF__Group__0__Impl : ( ( rule__QCREF__Group_0__0 )* ) ;
    public final void rule__QCREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3610:1: ( ( ( rule__QCREF__Group_0__0 )* ) )
            // InternalExprParser.g:3611:1: ( ( rule__QCREF__Group_0__0 )* )
            {
            // InternalExprParser.g:3611:1: ( ( rule__QCREF__Group_0__0 )* )
            // InternalExprParser.g:3612:1: ( rule__QCREF__Group_0__0 )*
            {
             before(grammarAccess.getQCREFAccess().getGroup_0()); 
            // InternalExprParser.g:3613:1: ( rule__QCREF__Group_0__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    int LA14_1 = input.LA(2);

                    if ( (LA14_1==ColonColon) ) {
                        alt14=1;
                    }


                }


                switch (alt14) {
            	case 1 :
            	    // InternalExprParser.g:3613:2: rule__QCREF__Group_0__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__QCREF__Group_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getQCREFAccess().getGroup_0()); 

            }


            }

        }
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
    // InternalExprParser.g:3623:1: rule__QCREF__Group__1 : rule__QCREF__Group__1__Impl rule__QCREF__Group__2 ;
    public final void rule__QCREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3627:1: ( rule__QCREF__Group__1__Impl rule__QCREF__Group__2 )
            // InternalExprParser.g:3628:2: rule__QCREF__Group__1__Impl rule__QCREF__Group__2
            {
            pushFollow(FOLLOW_28);
            rule__QCREF__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QCREF__Group__2();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:3635:1: rule__QCREF__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__QCREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3639:1: ( ( RULE_ID ) )
            // InternalExprParser.g:3640:1: ( RULE_ID )
            {
            // InternalExprParser.g:3640:1: ( RULE_ID )
            // InternalExprParser.g:3641:1: RULE_ID
            {
             before(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); 

            }


            }

        }
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
    // InternalExprParser.g:3652:1: rule__QCREF__Group__2 : rule__QCREF__Group__2__Impl ;
    public final void rule__QCREF__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3656:1: ( rule__QCREF__Group__2__Impl )
            // InternalExprParser.g:3657:2: rule__QCREF__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QCREF__Group__2__Impl();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:3663:1: rule__QCREF__Group__2__Impl : ( ( rule__QCREF__Group_2__0 )? ) ;
    public final void rule__QCREF__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3667:1: ( ( ( rule__QCREF__Group_2__0 )? ) )
            // InternalExprParser.g:3668:1: ( ( rule__QCREF__Group_2__0 )? )
            {
            // InternalExprParser.g:3668:1: ( ( rule__QCREF__Group_2__0 )? )
            // InternalExprParser.g:3669:1: ( rule__QCREF__Group_2__0 )?
            {
             before(grammarAccess.getQCREFAccess().getGroup_2()); 
            // InternalExprParser.g:3670:1: ( rule__QCREF__Group_2__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==FullStop) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalExprParser.g:3670:2: rule__QCREF__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__QCREF__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getQCREFAccess().getGroup_2()); 

            }


            }

        }
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
    // InternalExprParser.g:3686:1: rule__QCREF__Group_0__0 : rule__QCREF__Group_0__0__Impl rule__QCREF__Group_0__1 ;
    public final void rule__QCREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3690:1: ( rule__QCREF__Group_0__0__Impl rule__QCREF__Group_0__1 )
            // InternalExprParser.g:3691:2: rule__QCREF__Group_0__0__Impl rule__QCREF__Group_0__1
            {
            pushFollow(FOLLOW_29);
            rule__QCREF__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QCREF__Group_0__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:3698:1: rule__QCREF__Group_0__0__Impl : ( RULE_ID ) ;
    public final void rule__QCREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3702:1: ( ( RULE_ID ) )
            // InternalExprParser.g:3703:1: ( RULE_ID )
            {
            // InternalExprParser.g:3703:1: ( RULE_ID )
            // InternalExprParser.g:3704:1: RULE_ID
            {
             before(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); 

            }


            }

        }
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
    // InternalExprParser.g:3715:1: rule__QCREF__Group_0__1 : rule__QCREF__Group_0__1__Impl ;
    public final void rule__QCREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3719:1: ( rule__QCREF__Group_0__1__Impl )
            // InternalExprParser.g:3720:2: rule__QCREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QCREF__Group_0__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:3726:1: rule__QCREF__Group_0__1__Impl : ( ColonColon ) ;
    public final void rule__QCREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3730:1: ( ( ColonColon ) )
            // InternalExprParser.g:3731:1: ( ColonColon )
            {
            // InternalExprParser.g:3731:1: ( ColonColon )
            // InternalExprParser.g:3732:1: ColonColon
            {
             before(grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); 
            match(input,ColonColon,FOLLOW_2); 
             after(grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); 

            }


            }

        }
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
    // InternalExprParser.g:3749:1: rule__QCREF__Group_2__0 : rule__QCREF__Group_2__0__Impl rule__QCREF__Group_2__1 ;
    public final void rule__QCREF__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3753:1: ( rule__QCREF__Group_2__0__Impl rule__QCREF__Group_2__1 )
            // InternalExprParser.g:3754:2: rule__QCREF__Group_2__0__Impl rule__QCREF__Group_2__1
            {
            pushFollow(FOLLOW_5);
            rule__QCREF__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QCREF__Group_2__1();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:3761:1: rule__QCREF__Group_2__0__Impl : ( FullStop ) ;
    public final void rule__QCREF__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3765:1: ( ( FullStop ) )
            // InternalExprParser.g:3766:1: ( FullStop )
            {
            // InternalExprParser.g:3766:1: ( FullStop )
            // InternalExprParser.g:3767:1: FullStop
            {
             before(grammarAccess.getQCREFAccess().getFullStopKeyword_2_0()); 
            match(input,FullStop,FOLLOW_2); 
             after(grammarAccess.getQCREFAccess().getFullStopKeyword_2_0()); 

            }


            }

        }
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
    // InternalExprParser.g:3780:1: rule__QCREF__Group_2__1 : rule__QCREF__Group_2__1__Impl ;
    public final void rule__QCREF__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3784:1: ( rule__QCREF__Group_2__1__Impl )
            // InternalExprParser.g:3785:2: rule__QCREF__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QCREF__Group_2__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalExprParser.g:3791:1: rule__QCREF__Group_2__1__Impl : ( RULE_ID ) ;
    public final void rule__QCREF__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3795:1: ( ( RULE_ID ) )
            // InternalExprParser.g:3796:1: ( RULE_ID )
            {
            // InternalExprParser.g:3796:1: ( RULE_ID )
            // InternalExprParser.g:3797:1: RULE_ID
            {
             before(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_2_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_2_1()); 

            }


            }

        }
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
    // InternalExprParser.g:3813:1: rule__ExprModel__AnnexAssignment_0_1 : ( ruleExprLibrary ) ;
    public final void rule__ExprModel__AnnexAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3817:1: ( ( ruleExprLibrary ) )
            // InternalExprParser.g:3818:1: ( ruleExprLibrary )
            {
            // InternalExprParser.g:3818:1: ( ruleExprLibrary )
            // InternalExprParser.g:3819:1: ruleExprLibrary
            {
             before(grammarAccess.getExprModelAccess().getAnnexExprLibraryParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExprLibrary();

            state._fsp--;

             after(grammarAccess.getExprModelAccess().getAnnexExprLibraryParserRuleCall_0_1_0()); 

            }


            }

        }
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
    // InternalExprParser.g:3828:1: rule__ExprModel__AnnexAssignment_1_1 : ( ruleExprSubclause ) ;
    public final void rule__ExprModel__AnnexAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3832:1: ( ( ruleExprSubclause ) )
            // InternalExprParser.g:3833:1: ( ruleExprSubclause )
            {
            // InternalExprParser.g:3833:1: ( ruleExprSubclause )
            // InternalExprParser.g:3834:1: ruleExprSubclause
            {
             before(grammarAccess.getExprModelAccess().getAnnexExprSubclauseParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExprSubclause();

            state._fsp--;

             after(grammarAccess.getExprModelAccess().getAnnexExprSubclauseParserRuleCall_1_1_0()); 

            }


            }

        }
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
    // InternalExprParser.g:3843:1: rule__ExprLibrary__DeclsAssignment_1 : ( ruleDeclaration ) ;
    public final void rule__ExprLibrary__DeclsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3847:1: ( ( ruleDeclaration ) )
            // InternalExprParser.g:3848:1: ( ruleDeclaration )
            {
            // InternalExprParser.g:3848:1: ( ruleDeclaration )
            // InternalExprParser.g:3849:1: ruleDeclaration
            {
             before(grammarAccess.getExprLibraryAccess().getDeclsDeclarationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDeclaration();

            state._fsp--;

             after(grammarAccess.getExprLibraryAccess().getDeclsDeclarationParserRuleCall_1_0()); 

            }


            }

        }
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
    // InternalExprParser.g:3858:1: rule__ExprSubclause__DeclsAssignment_1 : ( ruleDeclaration ) ;
    public final void rule__ExprSubclause__DeclsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3862:1: ( ( ruleDeclaration ) )
            // InternalExprParser.g:3863:1: ( ruleDeclaration )
            {
            // InternalExprParser.g:3863:1: ( ruleDeclaration )
            // InternalExprParser.g:3864:1: ruleDeclaration
            {
             before(grammarAccess.getExprSubclauseAccess().getDeclsDeclarationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDeclaration();

            state._fsp--;

             after(grammarAccess.getExprSubclauseAccess().getDeclsDeclarationParserRuleCall_1_0()); 

            }


            }

        }
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
    // InternalExprParser.g:3873:1: rule__TypeDecl__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__TypeDecl__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3877:1: ( ( RULE_ID ) )
            // InternalExprParser.g:3878:1: ( RULE_ID )
            {
            // InternalExprParser.g:3878:1: ( RULE_ID )
            // InternalExprParser.g:3879:1: RULE_ID
            {
             before(grammarAccess.getTypeDeclAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTypeDeclAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
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
    // InternalExprParser.g:3888:1: rule__TypeDecl__TypeAssignment_3 : ( ruleType ) ;
    public final void rule__TypeDecl__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3892:1: ( ( ruleType ) )
            // InternalExprParser.g:3893:1: ( ruleType )
            {
            // InternalExprParser.g:3893:1: ( ruleType )
            // InternalExprParser.g:3894:1: ruleType
            {
             before(grammarAccess.getTypeDeclAccess().getTypeTypeParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;

             after(grammarAccess.getTypeDeclAccess().getTypeTypeParserRuleCall_3_0()); 

            }


            }

        }
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
    // InternalExprParser.g:3903:1: rule__VarDecl__ConstAssignment_0_0 : ( ( Val ) ) ;
    public final void rule__VarDecl__ConstAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3907:1: ( ( ( Val ) ) )
            // InternalExprParser.g:3908:1: ( ( Val ) )
            {
            // InternalExprParser.g:3908:1: ( ( Val ) )
            // InternalExprParser.g:3909:1: ( Val )
            {
             before(grammarAccess.getVarDeclAccess().getConstValKeyword_0_0_0()); 
            // InternalExprParser.g:3910:1: ( Val )
            // InternalExprParser.g:3911:1: Val
            {
             before(grammarAccess.getVarDeclAccess().getConstValKeyword_0_0_0()); 
            match(input,Val,FOLLOW_2); 
             after(grammarAccess.getVarDeclAccess().getConstValKeyword_0_0_0()); 

            }

             after(grammarAccess.getVarDeclAccess().getConstValKeyword_0_0_0()); 

            }


            }

        }
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
    // InternalExprParser.g:3926:1: rule__VarDecl__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__VarDecl__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3930:1: ( ( RULE_ID ) )
            // InternalExprParser.g:3931:1: ( RULE_ID )
            {
            // InternalExprParser.g:3931:1: ( RULE_ID )
            // InternalExprParser.g:3932:1: RULE_ID
            {
             before(grammarAccess.getVarDeclAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getVarDeclAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
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
    // InternalExprParser.g:3941:1: rule__VarDecl__TypeAssignment_2_1 : ( ruleType ) ;
    public final void rule__VarDecl__TypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3945:1: ( ( ruleType ) )
            // InternalExprParser.g:3946:1: ( ruleType )
            {
            // InternalExprParser.g:3946:1: ( ruleType )
            // InternalExprParser.g:3947:1: ruleType
            {
             before(grammarAccess.getVarDeclAccess().getTypeTypeParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;

             after(grammarAccess.getVarDeclAccess().getTypeTypeParserRuleCall_2_1_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__FunDecl__NameAssignment_1"
    // InternalExprParser.g:3956:1: rule__FunDecl__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__FunDecl__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3960:1: ( ( RULE_ID ) )
            // InternalExprParser.g:3961:1: ( RULE_ID )
            {
            // InternalExprParser.g:3961:1: ( RULE_ID )
            // InternalExprParser.g:3962:1: RULE_ID
            {
             before(grammarAccess.getFunDeclAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFunDeclAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
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
    // InternalExprParser.g:3971:1: rule__Category__CategoryAssignment : ( ruleCategoryEnum ) ;
    public final void rule__Category__CategoryAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3975:1: ( ( ruleCategoryEnum ) )
            // InternalExprParser.g:3976:1: ( ruleCategoryEnum )
            {
            // InternalExprParser.g:3976:1: ( ruleCategoryEnum )
            // InternalExprParser.g:3977:1: ruleCategoryEnum
            {
             before(grammarAccess.getCategoryAccess().getCategoryCategoryEnumEnumRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleCategoryEnum();

            state._fsp--;

             after(grammarAccess.getCategoryAccess().getCategoryCategoryEnumEnumRuleCall_0()); 

            }


            }

        }
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
    // InternalExprParser.g:3986:1: rule__MetaClass__ClassAssignment : ( ruleMetaClassEnum ) ;
    public final void rule__MetaClass__ClassAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:3990:1: ( ( ruleMetaClassEnum ) )
            // InternalExprParser.g:3991:1: ( ruleMetaClassEnum )
            {
            // InternalExprParser.g:3991:1: ( ruleMetaClassEnum )
            // InternalExprParser.g:3992:1: ruleMetaClassEnum
            {
             before(grammarAccess.getMetaClassAccess().getClassMetaClassEnumEnumRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleMetaClassEnum();

            state._fsp--;

             after(grammarAccess.getMetaClassAccess().getClassMetaClassEnumEnumRuleCall_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__RecordType__FieldAssignment_3"
    // InternalExprParser.g:4001:1: rule__RecordType__FieldAssignment_3 : ( ruleField ) ;
    public final void rule__RecordType__FieldAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4005:1: ( ( ruleField ) )
            // InternalExprParser.g:4006:1: ( ruleField )
            {
            // InternalExprParser.g:4006:1: ( ruleField )
            // InternalExprParser.g:4007:1: ruleField
            {
             before(grammarAccess.getRecordTypeAccess().getFieldFieldParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleField();

            state._fsp--;

             after(grammarAccess.getRecordTypeAccess().getFieldFieldParserRuleCall_3_0()); 

            }


            }

        }
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
    // InternalExprParser.g:4016:1: rule__Field__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Field__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4020:1: ( ( RULE_ID ) )
            // InternalExprParser.g:4021:1: ( RULE_ID )
            {
            // InternalExprParser.g:4021:1: ( RULE_ID )
            // InternalExprParser.g:4022:1: RULE_ID
            {
             before(grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
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
    // InternalExprParser.g:4031:1: rule__Field__TypeAssignment_2 : ( ruleType ) ;
    public final void rule__Field__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4035:1: ( ( ruleType ) )
            // InternalExprParser.g:4036:1: ( ruleType )
            {
            // InternalExprParser.g:4036:1: ( ruleType )
            // InternalExprParser.g:4037:1: ruleType
            {
             before(grammarAccess.getFieldAccess().getTypeTypeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;

             after(grammarAccess.getFieldAccess().getTypeTypeParserRuleCall_2_0()); 

            }


            }

        }
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
    // InternalExprParser.g:4046:1: rule__TupleType__FieldAssignment_3 : ( ruleTupleField ) ;
    public final void rule__TupleType__FieldAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4050:1: ( ( ruleTupleField ) )
            // InternalExprParser.g:4051:1: ( ruleTupleField )
            {
            // InternalExprParser.g:4051:1: ( ruleTupleField )
            // InternalExprParser.g:4052:1: ruleTupleField
            {
             before(grammarAccess.getTupleTypeAccess().getFieldTupleFieldParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTupleField();

            state._fsp--;

             after(grammarAccess.getTupleTypeAccess().getFieldTupleFieldParserRuleCall_3_0()); 

            }


            }

        }
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
    // InternalExprParser.g:4061:1: rule__TupleField__TypeAssignment_1 : ( ruleType ) ;
    public final void rule__TupleField__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4065:1: ( ( ruleType ) )
            // InternalExprParser.g:4066:1: ( ruleType )
            {
            // InternalExprParser.g:4066:1: ( ruleType )
            // InternalExprParser.g:4067:1: ruleType
            {
             before(grammarAccess.getTupleFieldAccess().getTypeTypeParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;

             after(grammarAccess.getTupleFieldAccess().getTypeTypeParserRuleCall_1_0()); 

            }


            }

        }
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
    // InternalExprParser.g:4076:1: rule__ListType__TypeAssignment_3 : ( ruleType ) ;
    public final void rule__ListType__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4080:1: ( ( ruleType ) )
            // InternalExprParser.g:4081:1: ( ruleType )
            {
            // InternalExprParser.g:4081:1: ( ruleType )
            // InternalExprParser.g:4082:1: ruleType
            {
             before(grammarAccess.getListTypeAccess().getTypeTypeParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;

             after(grammarAccess.getListTypeAccess().getTypeTypeParserRuleCall_3_0()); 

            }


            }

        }
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
    // InternalExprParser.g:4091:1: rule__SetType__TypeAssignment_2 : ( ruleType ) ;
    public final void rule__SetType__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4095:1: ( ( ruleType ) )
            // InternalExprParser.g:4096:1: ( ruleType )
            {
            // InternalExprParser.g:4096:1: ( ruleType )
            // InternalExprParser.g:4097:1: ruleType
            {
             before(grammarAccess.getSetTypeAccess().getTypeTypeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;

             after(grammarAccess.getSetTypeAccess().getTypeTypeParserRuleCall_2_0()); 

            }


            }

        }
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
    // InternalExprParser.g:4106:1: rule__BagType__TypeAssignment_2 : ( ruleType ) ;
    public final void rule__BagType__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4110:1: ( ( ruleType ) )
            // InternalExprParser.g:4111:1: ( ruleType )
            {
            // InternalExprParser.g:4111:1: ( ruleType )
            // InternalExprParser.g:4112:1: ruleType
            {
             before(grammarAccess.getBagTypeAccess().getTypeTypeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;

             after(grammarAccess.getBagTypeAccess().getTypeTypeParserRuleCall_2_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__MapType__DomAssignment_2"
    // InternalExprParser.g:4121:1: rule__MapType__DomAssignment_2 : ( ruleType ) ;
    public final void rule__MapType__DomAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4125:1: ( ( ruleType ) )
            // InternalExprParser.g:4126:1: ( ruleType )
            {
            // InternalExprParser.g:4126:1: ( ruleType )
            // InternalExprParser.g:4127:1: ruleType
            {
             before(grammarAccess.getMapTypeAccess().getDomTypeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;

             after(grammarAccess.getMapTypeAccess().getDomTypeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__DomAssignment_2"


    // $ANTLR start "rule__MapType__ImgAssignment_4"
    // InternalExprParser.g:4136:1: rule__MapType__ImgAssignment_4 : ( ruleType ) ;
    public final void rule__MapType__ImgAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4140:1: ( ( ruleType ) )
            // InternalExprParser.g:4141:1: ( ruleType )
            {
            // InternalExprParser.g:4141:1: ( ruleType )
            // InternalExprParser.g:4142:1: ruleType
            {
             before(grammarAccess.getMapTypeAccess().getImgTypeParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;

             after(grammarAccess.getMapTypeAccess().getImgTypeParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__ImgAssignment_4"


    // $ANTLR start "rule__TypeRef__RefAssignment"
    // InternalExprParser.g:4151:1: rule__TypeRef__RefAssignment : ( ( ruleQCREF ) ) ;
    public final void rule__TypeRef__RefAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalExprParser.g:4155:1: ( ( ( ruleQCREF ) ) )
            // InternalExprParser.g:4156:1: ( ( ruleQCREF ) )
            {
            // InternalExprParser.g:4156:1: ( ( ruleQCREF ) )
            // InternalExprParser.g:4157:1: ( ruleQCREF )
            {
             before(grammarAccess.getTypeRefAccess().getRefTypeDeclCrossReference_0()); 
            // InternalExprParser.g:4158:1: ( ruleQCREF )
            // InternalExprParser.g:4159:1: ruleQCREF
            {
             before(grammarAccess.getTypeRefAccess().getRefTypeDeclQCREFParserRuleCall_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQCREF();

            state._fsp--;

             after(grammarAccess.getTypeRefAccess().getRefTypeDeclQCREFParserRuleCall_0_1()); 

            }

             after(grammarAccess.getTypeRefAccess().getRefTypeDeclCrossReference_0()); 

            }


            }

        }
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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000031100000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000031100000002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x400000ECFFFBDFF0L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0007000000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000020A0800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x4010000000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x401000ECFFFBDFF0L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x400000ECFFFBDFF2L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000080000000000L});

}