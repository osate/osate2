package org.osate.xtext.aadl2.instance.ui.contentassist.antlr.internal; 

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
import org.osate.xtext.aadl2.instance.services.InstanceGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalInstanceParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_LONG", "RULE_STRING", "RULE_SL_COMMENT", "RULE_WS", "'abstract'", "'bus'", "'data'", "'device'", "'memory'", "'process'", "'processor'", "'subprogram'", "'system'", "'thread'", "':'", "'{'", "'}'", "'['", "']'", "'som'", "'group'", "'virtual'", "'.'", "'::'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=7;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__10=10;
    public static final int T__9=9;
    public static final int RULE_ID=4;
    public static final int RULE_WS=8;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int RULE_LONG=5;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalInstanceParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalInstanceParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalInstanceParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g"; }


     
     	private InstanceGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(InstanceGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleSystemInstance"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:60:1: entryRuleSystemInstance : ruleSystemInstance EOF ;
    public final void entryRuleSystemInstance() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:61:1: ( ruleSystemInstance EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:62:1: ruleSystemInstance EOF
            {
             before(grammarAccess.getSystemInstanceRule()); 
            pushFollow(FOLLOW_ruleSystemInstance_in_entryRuleSystemInstance61);
            ruleSystemInstance();

            state._fsp--;

             after(grammarAccess.getSystemInstanceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemInstance68); 

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
    // $ANTLR end "entryRuleSystemInstance"


    // $ANTLR start "ruleSystemInstance"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:69:1: ruleSystemInstance : ( ( rule__SystemInstance__Group__0 ) ) ;
    public final void ruleSystemInstance() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:73:2: ( ( ( rule__SystemInstance__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:74:1: ( ( rule__SystemInstance__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:74:1: ( ( rule__SystemInstance__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:75:1: ( rule__SystemInstance__Group__0 )
            {
             before(grammarAccess.getSystemInstanceAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:76:1: ( rule__SystemInstance__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:76:2: rule__SystemInstance__Group__0
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__0_in_ruleSystemInstance94);
            rule__SystemInstance__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSystemInstanceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSystemInstance"


    // $ANTLR start "entryRuleComponentInstance"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:88:1: entryRuleComponentInstance : ruleComponentInstance EOF ;
    public final void entryRuleComponentInstance() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:89:1: ( ruleComponentInstance EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:90:1: ruleComponentInstance EOF
            {
             before(grammarAccess.getComponentInstanceRule()); 
            pushFollow(FOLLOW_ruleComponentInstance_in_entryRuleComponentInstance121);
            ruleComponentInstance();

            state._fsp--;

             after(grammarAccess.getComponentInstanceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentInstance128); 

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
    // $ANTLR end "entryRuleComponentInstance"


    // $ANTLR start "ruleComponentInstance"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:97:1: ruleComponentInstance : ( ( rule__ComponentInstance__Group__0 ) ) ;
    public final void ruleComponentInstance() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:101:2: ( ( ( rule__ComponentInstance__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:102:1: ( ( rule__ComponentInstance__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:102:1: ( ( rule__ComponentInstance__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:103:1: ( rule__ComponentInstance__Group__0 )
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:104:1: ( rule__ComponentInstance__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:104:2: rule__ComponentInstance__Group__0
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__0_in_ruleComponentInstance154);
            rule__ComponentInstance__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getComponentInstanceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComponentInstance"


    // $ANTLR start "entryRuleSystemOperationMode"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:116:1: entryRuleSystemOperationMode : ruleSystemOperationMode EOF ;
    public final void entryRuleSystemOperationMode() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:117:1: ( ruleSystemOperationMode EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:118:1: ruleSystemOperationMode EOF
            {
             before(grammarAccess.getSystemOperationModeRule()); 
            pushFollow(FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode181);
            ruleSystemOperationMode();

            state._fsp--;

             after(grammarAccess.getSystemOperationModeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemOperationMode188); 

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
    // $ANTLR end "entryRuleSystemOperationMode"


    // $ANTLR start "ruleSystemOperationMode"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:125:1: ruleSystemOperationMode : ( ( rule__SystemOperationMode__Group__0 ) ) ;
    public final void ruleSystemOperationMode() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:129:2: ( ( ( rule__SystemOperationMode__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:130:1: ( ( rule__SystemOperationMode__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:130:1: ( ( rule__SystemOperationMode__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:131:1: ( rule__SystemOperationMode__Group__0 )
            {
             before(grammarAccess.getSystemOperationModeAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:132:1: ( rule__SystemOperationMode__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:132:2: rule__SystemOperationMode__Group__0
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__Group__0_in_ruleSystemOperationMode214);
            rule__SystemOperationMode__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSystemOperationModeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSystemOperationMode"


    // $ANTLR start "entryRuleComponentCategory"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:144:1: entryRuleComponentCategory : ruleComponentCategory EOF ;
    public final void entryRuleComponentCategory() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:145:1: ( ruleComponentCategory EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:146:1: ruleComponentCategory EOF
            {
             before(grammarAccess.getComponentCategoryRule()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory241);
            ruleComponentCategory();

            state._fsp--;

             after(grammarAccess.getComponentCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentCategory248); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:153:1: ruleComponentCategory : ( ( rule__ComponentCategory__Alternatives ) ) ;
    public final void ruleComponentCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:157:2: ( ( ( rule__ComponentCategory__Alternatives ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:158:1: ( ( rule__ComponentCategory__Alternatives ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:158:1: ( ( rule__ComponentCategory__Alternatives ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:159:1: ( rule__ComponentCategory__Alternatives )
            {
             before(grammarAccess.getComponentCategoryAccess().getAlternatives()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:160:1: ( rule__ComponentCategory__Alternatives )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:160:2: rule__ComponentCategory__Alternatives
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Alternatives_in_ruleComponentCategory274);
            rule__ComponentCategory__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getComponentCategoryAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleIMPLREF"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:172:1: entryRuleIMPLREF : ruleIMPLREF EOF ;
    public final void entryRuleIMPLREF() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:173:1: ( ruleIMPLREF EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:174:1: ruleIMPLREF EOF
            {
             before(grammarAccess.getIMPLREFRule()); 
            pushFollow(FOLLOW_ruleIMPLREF_in_entryRuleIMPLREF301);
            ruleIMPLREF();

            state._fsp--;

             after(grammarAccess.getIMPLREFRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIMPLREF308); 

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
    // $ANTLR end "entryRuleIMPLREF"


    // $ANTLR start "ruleIMPLREF"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:181:1: ruleIMPLREF : ( ( rule__IMPLREF__Group__0 ) ) ;
    public final void ruleIMPLREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:185:2: ( ( ( rule__IMPLREF__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:186:1: ( ( rule__IMPLREF__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:186:1: ( ( rule__IMPLREF__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:187:1: ( rule__IMPLREF__Group__0 )
            {
             before(grammarAccess.getIMPLREFAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:188:1: ( rule__IMPLREF__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:188:2: rule__IMPLREF__Group__0
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group__0_in_ruleIMPLREF334);
            rule__IMPLREF__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIMPLREFAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIMPLREF"


    // $ANTLR start "entryRuleSUBREF"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:200:1: entryRuleSUBREF : ruleSUBREF EOF ;
    public final void entryRuleSUBREF() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:201:1: ( ruleSUBREF EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:202:1: ruleSUBREF EOF
            {
             before(grammarAccess.getSUBREFRule()); 
            pushFollow(FOLLOW_ruleSUBREF_in_entryRuleSUBREF361);
            ruleSUBREF();

            state._fsp--;

             after(grammarAccess.getSUBREFRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSUBREF368); 

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
    // $ANTLR end "entryRuleSUBREF"


    // $ANTLR start "ruleSUBREF"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:209:1: ruleSUBREF : ( ( rule__SUBREF__Group__0 ) ) ;
    public final void ruleSUBREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:213:2: ( ( ( rule__SUBREF__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:214:1: ( ( rule__SUBREF__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:214:1: ( ( rule__SUBREF__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:215:1: ( rule__SUBREF__Group__0 )
            {
             before(grammarAccess.getSUBREFAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:216:1: ( rule__SUBREF__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:216:2: rule__SUBREF__Group__0
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__0_in_ruleSUBREF394);
            rule__SUBREF__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSUBREFAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSUBREF"


    // $ANTLR start "rule__SystemInstance__Alternatives_5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:228:1: rule__SystemInstance__Alternatives_5 : ( ( ( rule__SystemInstance__ComponentInstanceAssignment_5_0 ) ) | ( ( rule__SystemInstance__SystemOperationModeAssignment_5_1 ) ) );
    public final void rule__SystemInstance__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:232:1: ( ( ( rule__SystemInstance__ComponentInstanceAssignment_5_0 ) ) | ( ( rule__SystemInstance__SystemOperationModeAssignment_5_1 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=9 && LA1_0<=18)||LA1_0==26) ) {
                alt1=1;
            }
            else if ( (LA1_0==24) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:233:1: ( ( rule__SystemInstance__ComponentInstanceAssignment_5_0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:233:1: ( ( rule__SystemInstance__ComponentInstanceAssignment_5_0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:234:1: ( rule__SystemInstance__ComponentInstanceAssignment_5_0 )
                    {
                     before(grammarAccess.getSystemInstanceAccess().getComponentInstanceAssignment_5_0()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:235:1: ( rule__SystemInstance__ComponentInstanceAssignment_5_0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:235:2: rule__SystemInstance__ComponentInstanceAssignment_5_0
                    {
                    pushFollow(FOLLOW_rule__SystemInstance__ComponentInstanceAssignment_5_0_in_rule__SystemInstance__Alternatives_5430);
                    rule__SystemInstance__ComponentInstanceAssignment_5_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSystemInstanceAccess().getComponentInstanceAssignment_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:239:6: ( ( rule__SystemInstance__SystemOperationModeAssignment_5_1 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:239:6: ( ( rule__SystemInstance__SystemOperationModeAssignment_5_1 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:240:1: ( rule__SystemInstance__SystemOperationModeAssignment_5_1 )
                    {
                     before(grammarAccess.getSystemInstanceAccess().getSystemOperationModeAssignment_5_1()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:241:1: ( rule__SystemInstance__SystemOperationModeAssignment_5_1 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:241:2: rule__SystemInstance__SystemOperationModeAssignment_5_1
                    {
                    pushFollow(FOLLOW_rule__SystemInstance__SystemOperationModeAssignment_5_1_in_rule__SystemInstance__Alternatives_5448);
                    rule__SystemInstance__SystemOperationModeAssignment_5_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getSystemInstanceAccess().getSystemOperationModeAssignment_5_1()); 

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
    // $ANTLR end "rule__SystemInstance__Alternatives_5"


    // $ANTLR start "rule__ComponentCategory__Alternatives"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:250:1: rule__ComponentCategory__Alternatives : ( ( 'abstract' ) | ( 'bus' ) | ( 'data' ) | ( 'device' ) | ( 'memory' ) | ( 'process' ) | ( 'processor' ) | ( 'subprogram' ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( 'system' ) | ( ( rule__ComponentCategory__Group_10__0 ) ) | ( 'thread' ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( ( rule__ComponentCategory__Group_13__0 ) ) );
    public final void rule__ComponentCategory__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:254:1: ( ( 'abstract' ) | ( 'bus' ) | ( 'data' ) | ( 'device' ) | ( 'memory' ) | ( 'process' ) | ( 'processor' ) | ( 'subprogram' ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( 'system' ) | ( ( rule__ComponentCategory__Group_10__0 ) ) | ( 'thread' ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( ( rule__ComponentCategory__Group_13__0 ) ) )
            int alt2=14;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:255:1: ( 'abstract' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:255:1: ( 'abstract' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:256:1: 'abstract'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
                    match(input,9,FOLLOW_9_in_rule__ComponentCategory__Alternatives482); 
                     after(grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:263:6: ( 'bus' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:263:6: ( 'bus' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:264:1: 'bus'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
                    match(input,10,FOLLOW_10_in_rule__ComponentCategory__Alternatives502); 
                     after(grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:271:6: ( 'data' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:271:6: ( 'data' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:272:1: 'data'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
                    match(input,11,FOLLOW_11_in_rule__ComponentCategory__Alternatives522); 
                     after(grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:279:6: ( 'device' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:279:6: ( 'device' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:280:1: 'device'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
                    match(input,12,FOLLOW_12_in_rule__ComponentCategory__Alternatives542); 
                     after(grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:287:6: ( 'memory' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:287:6: ( 'memory' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:288:1: 'memory'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
                    match(input,13,FOLLOW_13_in_rule__ComponentCategory__Alternatives562); 
                     after(grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:295:6: ( 'process' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:295:6: ( 'process' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:296:1: 'process'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
                    match(input,14,FOLLOW_14_in_rule__ComponentCategory__Alternatives582); 
                     after(grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:303:6: ( 'processor' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:303:6: ( 'processor' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:304:1: 'processor'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
                    match(input,15,FOLLOW_15_in_rule__ComponentCategory__Alternatives602); 
                     after(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:311:6: ( 'subprogram' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:311:6: ( 'subprogram' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:312:1: 'subprogram'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
                    match(input,16,FOLLOW_16_in_rule__ComponentCategory__Alternatives622); 
                     after(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:319:6: ( ( rule__ComponentCategory__Group_8__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:319:6: ( ( rule__ComponentCategory__Group_8__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:320:1: ( rule__ComponentCategory__Group_8__0 )
                    {
                     before(grammarAccess.getComponentCategoryAccess().getGroup_8()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:321:1: ( rule__ComponentCategory__Group_8__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:321:2: rule__ComponentCategory__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__ComponentCategory__Group_8__0_in_rule__ComponentCategory__Alternatives641);
                    rule__ComponentCategory__Group_8__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentCategoryAccess().getGroup_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:325:6: ( 'system' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:325:6: ( 'system' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:326:1: 'system'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
                    match(input,17,FOLLOW_17_in_rule__ComponentCategory__Alternatives660); 
                     after(grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:333:6: ( ( rule__ComponentCategory__Group_10__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:333:6: ( ( rule__ComponentCategory__Group_10__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:334:1: ( rule__ComponentCategory__Group_10__0 )
                    {
                     before(grammarAccess.getComponentCategoryAccess().getGroup_10()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:335:1: ( rule__ComponentCategory__Group_10__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:335:2: rule__ComponentCategory__Group_10__0
                    {
                    pushFollow(FOLLOW_rule__ComponentCategory__Group_10__0_in_rule__ComponentCategory__Alternatives679);
                    rule__ComponentCategory__Group_10__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentCategoryAccess().getGroup_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:339:6: ( 'thread' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:339:6: ( 'thread' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:340:1: 'thread'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
                    match(input,18,FOLLOW_18_in_rule__ComponentCategory__Alternatives698); 
                     after(grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:347:6: ( ( rule__ComponentCategory__Group_12__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:347:6: ( ( rule__ComponentCategory__Group_12__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:348:1: ( rule__ComponentCategory__Group_12__0 )
                    {
                     before(grammarAccess.getComponentCategoryAccess().getGroup_12()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:349:1: ( rule__ComponentCategory__Group_12__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:349:2: rule__ComponentCategory__Group_12__0
                    {
                    pushFollow(FOLLOW_rule__ComponentCategory__Group_12__0_in_rule__ComponentCategory__Alternatives717);
                    rule__ComponentCategory__Group_12__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentCategoryAccess().getGroup_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:353:6: ( ( rule__ComponentCategory__Group_13__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:353:6: ( ( rule__ComponentCategory__Group_13__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:354:1: ( rule__ComponentCategory__Group_13__0 )
                    {
                     before(grammarAccess.getComponentCategoryAccess().getGroup_13()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:355:1: ( rule__ComponentCategory__Group_13__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:355:2: rule__ComponentCategory__Group_13__0
                    {
                    pushFollow(FOLLOW_rule__ComponentCategory__Group_13__0_in_rule__ComponentCategory__Alternatives735);
                    rule__ComponentCategory__Group_13__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentCategoryAccess().getGroup_13()); 

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


    // $ANTLR start "rule__SystemInstance__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:366:1: rule__SystemInstance__Group__0 : rule__SystemInstance__Group__0__Impl rule__SystemInstance__Group__1 ;
    public final void rule__SystemInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:370:1: ( rule__SystemInstance__Group__0__Impl rule__SystemInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:371:2: rule__SystemInstance__Group__0__Impl rule__SystemInstance__Group__1
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__0__Impl_in_rule__SystemInstance__Group__0766);
            rule__SystemInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__1_in_rule__SystemInstance__Group__0769);
            rule__SystemInstance__Group__1();

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
    // $ANTLR end "rule__SystemInstance__Group__0"


    // $ANTLR start "rule__SystemInstance__Group__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:378:1: rule__SystemInstance__Group__0__Impl : ( ( rule__SystemInstance__CategoryAssignment_0 ) ) ;
    public final void rule__SystemInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:382:1: ( ( ( rule__SystemInstance__CategoryAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:383:1: ( ( rule__SystemInstance__CategoryAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:383:1: ( ( rule__SystemInstance__CategoryAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:384:1: ( rule__SystemInstance__CategoryAssignment_0 )
            {
             before(grammarAccess.getSystemInstanceAccess().getCategoryAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:385:1: ( rule__SystemInstance__CategoryAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:385:2: rule__SystemInstance__CategoryAssignment_0
            {
            pushFollow(FOLLOW_rule__SystemInstance__CategoryAssignment_0_in_rule__SystemInstance__Group__0__Impl796);
            rule__SystemInstance__CategoryAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSystemInstanceAccess().getCategoryAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__Group__0__Impl"


    // $ANTLR start "rule__SystemInstance__Group__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:395:1: rule__SystemInstance__Group__1 : rule__SystemInstance__Group__1__Impl rule__SystemInstance__Group__2 ;
    public final void rule__SystemInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:399:1: ( rule__SystemInstance__Group__1__Impl rule__SystemInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:400:2: rule__SystemInstance__Group__1__Impl rule__SystemInstance__Group__2
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__1__Impl_in_rule__SystemInstance__Group__1826);
            rule__SystemInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__2_in_rule__SystemInstance__Group__1829);
            rule__SystemInstance__Group__2();

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
    // $ANTLR end "rule__SystemInstance__Group__1"


    // $ANTLR start "rule__SystemInstance__Group__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:407:1: rule__SystemInstance__Group__1__Impl : ( ( rule__SystemInstance__NameAssignment_1 ) ) ;
    public final void rule__SystemInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:411:1: ( ( ( rule__SystemInstance__NameAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:412:1: ( ( rule__SystemInstance__NameAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:412:1: ( ( rule__SystemInstance__NameAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:413:1: ( rule__SystemInstance__NameAssignment_1 )
            {
             before(grammarAccess.getSystemInstanceAccess().getNameAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:414:1: ( rule__SystemInstance__NameAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:414:2: rule__SystemInstance__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SystemInstance__NameAssignment_1_in_rule__SystemInstance__Group__1__Impl856);
            rule__SystemInstance__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSystemInstanceAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__Group__1__Impl"


    // $ANTLR start "rule__SystemInstance__Group__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:424:1: rule__SystemInstance__Group__2 : rule__SystemInstance__Group__2__Impl rule__SystemInstance__Group__3 ;
    public final void rule__SystemInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:428:1: ( rule__SystemInstance__Group__2__Impl rule__SystemInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:429:2: rule__SystemInstance__Group__2__Impl rule__SystemInstance__Group__3
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__2__Impl_in_rule__SystemInstance__Group__2886);
            rule__SystemInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__3_in_rule__SystemInstance__Group__2889);
            rule__SystemInstance__Group__3();

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
    // $ANTLR end "rule__SystemInstance__Group__2"


    // $ANTLR start "rule__SystemInstance__Group__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:436:1: rule__SystemInstance__Group__2__Impl : ( ':' ) ;
    public final void rule__SystemInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:440:1: ( ( ':' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:441:1: ( ':' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:441:1: ( ':' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:442:1: ':'
            {
             before(grammarAccess.getSystemInstanceAccess().getColonKeyword_2()); 
            match(input,19,FOLLOW_19_in_rule__SystemInstance__Group__2__Impl917); 
             after(grammarAccess.getSystemInstanceAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__Group__2__Impl"


    // $ANTLR start "rule__SystemInstance__Group__3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:455:1: rule__SystemInstance__Group__3 : rule__SystemInstance__Group__3__Impl rule__SystemInstance__Group__4 ;
    public final void rule__SystemInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:459:1: ( rule__SystemInstance__Group__3__Impl rule__SystemInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:460:2: rule__SystemInstance__Group__3__Impl rule__SystemInstance__Group__4
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__3__Impl_in_rule__SystemInstance__Group__3948);
            rule__SystemInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__4_in_rule__SystemInstance__Group__3951);
            rule__SystemInstance__Group__4();

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
    // $ANTLR end "rule__SystemInstance__Group__3"


    // $ANTLR start "rule__SystemInstance__Group__3__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:467:1: rule__SystemInstance__Group__3__Impl : ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) ) ;
    public final void rule__SystemInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:471:1: ( ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:472:1: ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:472:1: ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:473:1: ( rule__SystemInstance__ComponentImplementationAssignment_3 )
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentImplementationAssignment_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:474:1: ( rule__SystemInstance__ComponentImplementationAssignment_3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:474:2: rule__SystemInstance__ComponentImplementationAssignment_3
            {
            pushFollow(FOLLOW_rule__SystemInstance__ComponentImplementationAssignment_3_in_rule__SystemInstance__Group__3__Impl978);
            rule__SystemInstance__ComponentImplementationAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSystemInstanceAccess().getComponentImplementationAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__Group__3__Impl"


    // $ANTLR start "rule__SystemInstance__Group__4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:484:1: rule__SystemInstance__Group__4 : rule__SystemInstance__Group__4__Impl rule__SystemInstance__Group__5 ;
    public final void rule__SystemInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:488:1: ( rule__SystemInstance__Group__4__Impl rule__SystemInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:489:2: rule__SystemInstance__Group__4__Impl rule__SystemInstance__Group__5
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__4__Impl_in_rule__SystemInstance__Group__41008);
            rule__SystemInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__5_in_rule__SystemInstance__Group__41011);
            rule__SystemInstance__Group__5();

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
    // $ANTLR end "rule__SystemInstance__Group__4"


    // $ANTLR start "rule__SystemInstance__Group__4__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:496:1: rule__SystemInstance__Group__4__Impl : ( '{' ) ;
    public final void rule__SystemInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:500:1: ( ( '{' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:501:1: ( '{' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:501:1: ( '{' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:502:1: '{'
            {
             before(grammarAccess.getSystemInstanceAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,20,FOLLOW_20_in_rule__SystemInstance__Group__4__Impl1039); 
             after(grammarAccess.getSystemInstanceAccess().getLeftCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__Group__4__Impl"


    // $ANTLR start "rule__SystemInstance__Group__5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:515:1: rule__SystemInstance__Group__5 : rule__SystemInstance__Group__5__Impl rule__SystemInstance__Group__6 ;
    public final void rule__SystemInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:519:1: ( rule__SystemInstance__Group__5__Impl rule__SystemInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:520:2: rule__SystemInstance__Group__5__Impl rule__SystemInstance__Group__6
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__5__Impl_in_rule__SystemInstance__Group__51070);
            rule__SystemInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__6_in_rule__SystemInstance__Group__51073);
            rule__SystemInstance__Group__6();

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
    // $ANTLR end "rule__SystemInstance__Group__5"


    // $ANTLR start "rule__SystemInstance__Group__5__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:527:1: rule__SystemInstance__Group__5__Impl : ( ( rule__SystemInstance__Alternatives_5 )* ) ;
    public final void rule__SystemInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:531:1: ( ( ( rule__SystemInstance__Alternatives_5 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:532:1: ( ( rule__SystemInstance__Alternatives_5 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:532:1: ( ( rule__SystemInstance__Alternatives_5 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:533:1: ( rule__SystemInstance__Alternatives_5 )*
            {
             before(grammarAccess.getSystemInstanceAccess().getAlternatives_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:534:1: ( rule__SystemInstance__Alternatives_5 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=9 && LA3_0<=18)||LA3_0==24||LA3_0==26) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:534:2: rule__SystemInstance__Alternatives_5
            	    {
            	    pushFollow(FOLLOW_rule__SystemInstance__Alternatives_5_in_rule__SystemInstance__Group__5__Impl1100);
            	    rule__SystemInstance__Alternatives_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getSystemInstanceAccess().getAlternatives_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__Group__5__Impl"


    // $ANTLR start "rule__SystemInstance__Group__6"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:544:1: rule__SystemInstance__Group__6 : rule__SystemInstance__Group__6__Impl ;
    public final void rule__SystemInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:548:1: ( rule__SystemInstance__Group__6__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:549:2: rule__SystemInstance__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__6__Impl_in_rule__SystemInstance__Group__61131);
            rule__SystemInstance__Group__6__Impl();

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
    // $ANTLR end "rule__SystemInstance__Group__6"


    // $ANTLR start "rule__SystemInstance__Group__6__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:555:1: rule__SystemInstance__Group__6__Impl : ( '}' ) ;
    public final void rule__SystemInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:559:1: ( ( '}' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:560:1: ( '}' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:560:1: ( '}' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:561:1: '}'
            {
             before(grammarAccess.getSystemInstanceAccess().getRightCurlyBracketKeyword_6()); 
            match(input,21,FOLLOW_21_in_rule__SystemInstance__Group__6__Impl1159); 
             after(grammarAccess.getSystemInstanceAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__Group__6__Impl"


    // $ANTLR start "rule__ComponentInstance__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:588:1: rule__ComponentInstance__Group__0 : rule__ComponentInstance__Group__0__Impl rule__ComponentInstance__Group__1 ;
    public final void rule__ComponentInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:592:1: ( rule__ComponentInstance__Group__0__Impl rule__ComponentInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:593:2: rule__ComponentInstance__Group__0__Impl rule__ComponentInstance__Group__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__0__Impl_in_rule__ComponentInstance__Group__01204);
            rule__ComponentInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__1_in_rule__ComponentInstance__Group__01207);
            rule__ComponentInstance__Group__1();

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
    // $ANTLR end "rule__ComponentInstance__Group__0"


    // $ANTLR start "rule__ComponentInstance__Group__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:600:1: rule__ComponentInstance__Group__0__Impl : ( ( rule__ComponentInstance__CategoryAssignment_0 ) ) ;
    public final void rule__ComponentInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:604:1: ( ( ( rule__ComponentInstance__CategoryAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:605:1: ( ( rule__ComponentInstance__CategoryAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:605:1: ( ( rule__ComponentInstance__CategoryAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:606:1: ( rule__ComponentInstance__CategoryAssignment_0 )
            {
             before(grammarAccess.getComponentInstanceAccess().getCategoryAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:607:1: ( rule__ComponentInstance__CategoryAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:607:2: rule__ComponentInstance__CategoryAssignment_0
            {
            pushFollow(FOLLOW_rule__ComponentInstance__CategoryAssignment_0_in_rule__ComponentInstance__Group__0__Impl1234);
            rule__ComponentInstance__CategoryAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getComponentInstanceAccess().getCategoryAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group__0__Impl"


    // $ANTLR start "rule__ComponentInstance__Group__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:617:1: rule__ComponentInstance__Group__1 : rule__ComponentInstance__Group__1__Impl rule__ComponentInstance__Group__2 ;
    public final void rule__ComponentInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:621:1: ( rule__ComponentInstance__Group__1__Impl rule__ComponentInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:622:2: rule__ComponentInstance__Group__1__Impl rule__ComponentInstance__Group__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__1__Impl_in_rule__ComponentInstance__Group__11264);
            rule__ComponentInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__2_in_rule__ComponentInstance__Group__11267);
            rule__ComponentInstance__Group__2();

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
    // $ANTLR end "rule__ComponentInstance__Group__1"


    // $ANTLR start "rule__ComponentInstance__Group__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:629:1: rule__ComponentInstance__Group__1__Impl : ( ( rule__ComponentInstance__NameAssignment_1 ) ) ;
    public final void rule__ComponentInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:633:1: ( ( ( rule__ComponentInstance__NameAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:634:1: ( ( rule__ComponentInstance__NameAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:634:1: ( ( rule__ComponentInstance__NameAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:635:1: ( rule__ComponentInstance__NameAssignment_1 )
            {
             before(grammarAccess.getComponentInstanceAccess().getNameAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:636:1: ( rule__ComponentInstance__NameAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:636:2: rule__ComponentInstance__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__NameAssignment_1_in_rule__ComponentInstance__Group__1__Impl1294);
            rule__ComponentInstance__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getComponentInstanceAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group__1__Impl"


    // $ANTLR start "rule__ComponentInstance__Group__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:646:1: rule__ComponentInstance__Group__2 : rule__ComponentInstance__Group__2__Impl rule__ComponentInstance__Group__3 ;
    public final void rule__ComponentInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:650:1: ( rule__ComponentInstance__Group__2__Impl rule__ComponentInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:651:2: rule__ComponentInstance__Group__2__Impl rule__ComponentInstance__Group__3
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__2__Impl_in_rule__ComponentInstance__Group__21324);
            rule__ComponentInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__3_in_rule__ComponentInstance__Group__21327);
            rule__ComponentInstance__Group__3();

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
    // $ANTLR end "rule__ComponentInstance__Group__2"


    // $ANTLR start "rule__ComponentInstance__Group__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:658:1: rule__ComponentInstance__Group__2__Impl : ( ( rule__ComponentInstance__Group_2__0 )* ) ;
    public final void rule__ComponentInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:662:1: ( ( ( rule__ComponentInstance__Group_2__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:663:1: ( ( rule__ComponentInstance__Group_2__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:663:1: ( ( rule__ComponentInstance__Group_2__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:664:1: ( rule__ComponentInstance__Group_2__0 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:665:1: ( rule__ComponentInstance__Group_2__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==22) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:665:2: rule__ComponentInstance__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__Group_2__0_in_rule__ComponentInstance__Group__2__Impl1354);
            	    rule__ComponentInstance__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getComponentInstanceAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group__2__Impl"


    // $ANTLR start "rule__ComponentInstance__Group__3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:675:1: rule__ComponentInstance__Group__3 : rule__ComponentInstance__Group__3__Impl rule__ComponentInstance__Group__4 ;
    public final void rule__ComponentInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:679:1: ( rule__ComponentInstance__Group__3__Impl rule__ComponentInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:680:2: rule__ComponentInstance__Group__3__Impl rule__ComponentInstance__Group__4
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__3__Impl_in_rule__ComponentInstance__Group__31385);
            rule__ComponentInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__4_in_rule__ComponentInstance__Group__31388);
            rule__ComponentInstance__Group__4();

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
    // $ANTLR end "rule__ComponentInstance__Group__3"


    // $ANTLR start "rule__ComponentInstance__Group__3__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:687:1: rule__ComponentInstance__Group__3__Impl : ( ':' ) ;
    public final void rule__ComponentInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:691:1: ( ( ':' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:692:1: ( ':' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:692:1: ( ':' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:693:1: ':'
            {
             before(grammarAccess.getComponentInstanceAccess().getColonKeyword_3()); 
            match(input,19,FOLLOW_19_in_rule__ComponentInstance__Group__3__Impl1416); 
             after(grammarAccess.getComponentInstanceAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group__3__Impl"


    // $ANTLR start "rule__ComponentInstance__Group__4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:706:1: rule__ComponentInstance__Group__4 : rule__ComponentInstance__Group__4__Impl rule__ComponentInstance__Group__5 ;
    public final void rule__ComponentInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:710:1: ( rule__ComponentInstance__Group__4__Impl rule__ComponentInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:711:2: rule__ComponentInstance__Group__4__Impl rule__ComponentInstance__Group__5
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__4__Impl_in_rule__ComponentInstance__Group__41447);
            rule__ComponentInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__5_in_rule__ComponentInstance__Group__41450);
            rule__ComponentInstance__Group__5();

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
    // $ANTLR end "rule__ComponentInstance__Group__4"


    // $ANTLR start "rule__ComponentInstance__Group__4__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:718:1: rule__ComponentInstance__Group__4__Impl : ( ( rule__ComponentInstance__SubcomponentAssignment_4 ) ) ;
    public final void rule__ComponentInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:722:1: ( ( ( rule__ComponentInstance__SubcomponentAssignment_4 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:723:1: ( ( rule__ComponentInstance__SubcomponentAssignment_4 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:723:1: ( ( rule__ComponentInstance__SubcomponentAssignment_4 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:724:1: ( rule__ComponentInstance__SubcomponentAssignment_4 )
            {
             before(grammarAccess.getComponentInstanceAccess().getSubcomponentAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:725:1: ( rule__ComponentInstance__SubcomponentAssignment_4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:725:2: rule__ComponentInstance__SubcomponentAssignment_4
            {
            pushFollow(FOLLOW_rule__ComponentInstance__SubcomponentAssignment_4_in_rule__ComponentInstance__Group__4__Impl1477);
            rule__ComponentInstance__SubcomponentAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getComponentInstanceAccess().getSubcomponentAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group__4__Impl"


    // $ANTLR start "rule__ComponentInstance__Group__5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:735:1: rule__ComponentInstance__Group__5 : rule__ComponentInstance__Group__5__Impl ;
    public final void rule__ComponentInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:739:1: ( rule__ComponentInstance__Group__5__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:740:2: rule__ComponentInstance__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__5__Impl_in_rule__ComponentInstance__Group__51507);
            rule__ComponentInstance__Group__5__Impl();

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
    // $ANTLR end "rule__ComponentInstance__Group__5"


    // $ANTLR start "rule__ComponentInstance__Group__5__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:746:1: rule__ComponentInstance__Group__5__Impl : ( ( rule__ComponentInstance__Group_5__0 )? ) ;
    public final void rule__ComponentInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:750:1: ( ( ( rule__ComponentInstance__Group_5__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:751:1: ( ( rule__ComponentInstance__Group_5__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:751:1: ( ( rule__ComponentInstance__Group_5__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:752:1: ( rule__ComponentInstance__Group_5__0 )?
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:753:1: ( rule__ComponentInstance__Group_5__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==20) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:753:2: rule__ComponentInstance__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__Group_5__0_in_rule__ComponentInstance__Group__5__Impl1534);
                    rule__ComponentInstance__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getComponentInstanceAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group__5__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_2__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:775:1: rule__ComponentInstance__Group_2__0 : rule__ComponentInstance__Group_2__0__Impl rule__ComponentInstance__Group_2__1 ;
    public final void rule__ComponentInstance__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:779:1: ( rule__ComponentInstance__Group_2__0__Impl rule__ComponentInstance__Group_2__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:780:2: rule__ComponentInstance__Group_2__0__Impl rule__ComponentInstance__Group_2__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_2__0__Impl_in_rule__ComponentInstance__Group_2__01577);
            rule__ComponentInstance__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_2__1_in_rule__ComponentInstance__Group_2__01580);
            rule__ComponentInstance__Group_2__1();

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
    // $ANTLR end "rule__ComponentInstance__Group_2__0"


    // $ANTLR start "rule__ComponentInstance__Group_2__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:787:1: rule__ComponentInstance__Group_2__0__Impl : ( '[' ) ;
    public final void rule__ComponentInstance__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:791:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:792:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:792:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:793:1: '['
            {
             before(grammarAccess.getComponentInstanceAccess().getLeftSquareBracketKeyword_2_0()); 
            match(input,22,FOLLOW_22_in_rule__ComponentInstance__Group_2__0__Impl1608); 
             after(grammarAccess.getComponentInstanceAccess().getLeftSquareBracketKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_2__0__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_2__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:806:1: rule__ComponentInstance__Group_2__1 : rule__ComponentInstance__Group_2__1__Impl rule__ComponentInstance__Group_2__2 ;
    public final void rule__ComponentInstance__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:810:1: ( rule__ComponentInstance__Group_2__1__Impl rule__ComponentInstance__Group_2__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:811:2: rule__ComponentInstance__Group_2__1__Impl rule__ComponentInstance__Group_2__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_2__1__Impl_in_rule__ComponentInstance__Group_2__11639);
            rule__ComponentInstance__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_2__2_in_rule__ComponentInstance__Group_2__11642);
            rule__ComponentInstance__Group_2__2();

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
    // $ANTLR end "rule__ComponentInstance__Group_2__1"


    // $ANTLR start "rule__ComponentInstance__Group_2__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:818:1: rule__ComponentInstance__Group_2__1__Impl : ( ( rule__ComponentInstance__IndexAssignment_2_1 ) ) ;
    public final void rule__ComponentInstance__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:822:1: ( ( ( rule__ComponentInstance__IndexAssignment_2_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:823:1: ( ( rule__ComponentInstance__IndexAssignment_2_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:823:1: ( ( rule__ComponentInstance__IndexAssignment_2_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:824:1: ( rule__ComponentInstance__IndexAssignment_2_1 )
            {
             before(grammarAccess.getComponentInstanceAccess().getIndexAssignment_2_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:825:1: ( rule__ComponentInstance__IndexAssignment_2_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:825:2: rule__ComponentInstance__IndexAssignment_2_1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__IndexAssignment_2_1_in_rule__ComponentInstance__Group_2__1__Impl1669);
            rule__ComponentInstance__IndexAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getComponentInstanceAccess().getIndexAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_2__1__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_2__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:835:1: rule__ComponentInstance__Group_2__2 : rule__ComponentInstance__Group_2__2__Impl ;
    public final void rule__ComponentInstance__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:839:1: ( rule__ComponentInstance__Group_2__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:840:2: rule__ComponentInstance__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_2__2__Impl_in_rule__ComponentInstance__Group_2__21699);
            rule__ComponentInstance__Group_2__2__Impl();

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
    // $ANTLR end "rule__ComponentInstance__Group_2__2"


    // $ANTLR start "rule__ComponentInstance__Group_2__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:846:1: rule__ComponentInstance__Group_2__2__Impl : ( ']' ) ;
    public final void rule__ComponentInstance__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:850:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:851:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:851:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:852:1: ']'
            {
             before(grammarAccess.getComponentInstanceAccess().getRightSquareBracketKeyword_2_2()); 
            match(input,23,FOLLOW_23_in_rule__ComponentInstance__Group_2__2__Impl1727); 
             after(grammarAccess.getComponentInstanceAccess().getRightSquareBracketKeyword_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_2__2__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_5__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:871:1: rule__ComponentInstance__Group_5__0 : rule__ComponentInstance__Group_5__0__Impl rule__ComponentInstance__Group_5__1 ;
    public final void rule__ComponentInstance__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:875:1: ( rule__ComponentInstance__Group_5__0__Impl rule__ComponentInstance__Group_5__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:876:2: rule__ComponentInstance__Group_5__0__Impl rule__ComponentInstance__Group_5__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__0__Impl_in_rule__ComponentInstance__Group_5__01764);
            rule__ComponentInstance__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__1_in_rule__ComponentInstance__Group_5__01767);
            rule__ComponentInstance__Group_5__1();

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
    // $ANTLR end "rule__ComponentInstance__Group_5__0"


    // $ANTLR start "rule__ComponentInstance__Group_5__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:883:1: rule__ComponentInstance__Group_5__0__Impl : ( '{' ) ;
    public final void rule__ComponentInstance__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:887:1: ( ( '{' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:888:1: ( '{' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:888:1: ( '{' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:889:1: '{'
            {
             before(grammarAccess.getComponentInstanceAccess().getLeftCurlyBracketKeyword_5_0()); 
            match(input,20,FOLLOW_20_in_rule__ComponentInstance__Group_5__0__Impl1795); 
             after(grammarAccess.getComponentInstanceAccess().getLeftCurlyBracketKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_5__0__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_5__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:902:1: rule__ComponentInstance__Group_5__1 : rule__ComponentInstance__Group_5__1__Impl rule__ComponentInstance__Group_5__2 ;
    public final void rule__ComponentInstance__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:906:1: ( rule__ComponentInstance__Group_5__1__Impl rule__ComponentInstance__Group_5__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:907:2: rule__ComponentInstance__Group_5__1__Impl rule__ComponentInstance__Group_5__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__1__Impl_in_rule__ComponentInstance__Group_5__11826);
            rule__ComponentInstance__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__2_in_rule__ComponentInstance__Group_5__11829);
            rule__ComponentInstance__Group_5__2();

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
    // $ANTLR end "rule__ComponentInstance__Group_5__1"


    // $ANTLR start "rule__ComponentInstance__Group_5__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:914:1: rule__ComponentInstance__Group_5__1__Impl : ( ( rule__ComponentInstance__ComponentInstanceAssignment_5_1 )* ) ;
    public final void rule__ComponentInstance__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:918:1: ( ( ( rule__ComponentInstance__ComponentInstanceAssignment_5_1 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:919:1: ( ( rule__ComponentInstance__ComponentInstanceAssignment_5_1 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:919:1: ( ( rule__ComponentInstance__ComponentInstanceAssignment_5_1 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:920:1: ( rule__ComponentInstance__ComponentInstanceAssignment_5_1 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getComponentInstanceAssignment_5_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:921:1: ( rule__ComponentInstance__ComponentInstanceAssignment_5_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=9 && LA6_0<=18)||LA6_0==26) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:921:2: rule__ComponentInstance__ComponentInstanceAssignment_5_1
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__ComponentInstanceAssignment_5_1_in_rule__ComponentInstance__Group_5__1__Impl1856);
            	    rule__ComponentInstance__ComponentInstanceAssignment_5_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getComponentInstanceAccess().getComponentInstanceAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_5__1__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_5__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:931:1: rule__ComponentInstance__Group_5__2 : rule__ComponentInstance__Group_5__2__Impl ;
    public final void rule__ComponentInstance__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:935:1: ( rule__ComponentInstance__Group_5__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:936:2: rule__ComponentInstance__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__2__Impl_in_rule__ComponentInstance__Group_5__21887);
            rule__ComponentInstance__Group_5__2__Impl();

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
    // $ANTLR end "rule__ComponentInstance__Group_5__2"


    // $ANTLR start "rule__ComponentInstance__Group_5__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:942:1: rule__ComponentInstance__Group_5__2__Impl : ( '}' ) ;
    public final void rule__ComponentInstance__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:946:1: ( ( '}' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:947:1: ( '}' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:947:1: ( '}' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:948:1: '}'
            {
             before(grammarAccess.getComponentInstanceAccess().getRightCurlyBracketKeyword_5_2()); 
            match(input,21,FOLLOW_21_in_rule__ComponentInstance__Group_5__2__Impl1915); 
             after(grammarAccess.getComponentInstanceAccess().getRightCurlyBracketKeyword_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_5__2__Impl"


    // $ANTLR start "rule__SystemOperationMode__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:967:1: rule__SystemOperationMode__Group__0 : rule__SystemOperationMode__Group__0__Impl rule__SystemOperationMode__Group__1 ;
    public final void rule__SystemOperationMode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:971:1: ( rule__SystemOperationMode__Group__0__Impl rule__SystemOperationMode__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:972:2: rule__SystemOperationMode__Group__0__Impl rule__SystemOperationMode__Group__1
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__Group__0__Impl_in_rule__SystemOperationMode__Group__01952);
            rule__SystemOperationMode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemOperationMode__Group__1_in_rule__SystemOperationMode__Group__01955);
            rule__SystemOperationMode__Group__1();

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
    // $ANTLR end "rule__SystemOperationMode__Group__0"


    // $ANTLR start "rule__SystemOperationMode__Group__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:979:1: rule__SystemOperationMode__Group__0__Impl : ( 'som' ) ;
    public final void rule__SystemOperationMode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:983:1: ( ( 'som' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:984:1: ( 'som' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:984:1: ( 'som' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:985:1: 'som'
            {
             before(grammarAccess.getSystemOperationModeAccess().getSomKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__SystemOperationMode__Group__0__Impl1983); 
             after(grammarAccess.getSystemOperationModeAccess().getSomKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemOperationMode__Group__0__Impl"


    // $ANTLR start "rule__SystemOperationMode__Group__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:998:1: rule__SystemOperationMode__Group__1 : rule__SystemOperationMode__Group__1__Impl ;
    public final void rule__SystemOperationMode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1002:1: ( rule__SystemOperationMode__Group__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1003:2: rule__SystemOperationMode__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__Group__1__Impl_in_rule__SystemOperationMode__Group__12014);
            rule__SystemOperationMode__Group__1__Impl();

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
    // $ANTLR end "rule__SystemOperationMode__Group__1"


    // $ANTLR start "rule__SystemOperationMode__Group__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1009:1: rule__SystemOperationMode__Group__1__Impl : ( ( rule__SystemOperationMode__NameAssignment_1 ) ) ;
    public final void rule__SystemOperationMode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1013:1: ( ( ( rule__SystemOperationMode__NameAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1014:1: ( ( rule__SystemOperationMode__NameAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1014:1: ( ( rule__SystemOperationMode__NameAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1015:1: ( rule__SystemOperationMode__NameAssignment_1 )
            {
             before(grammarAccess.getSystemOperationModeAccess().getNameAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1016:1: ( rule__SystemOperationMode__NameAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1016:2: rule__SystemOperationMode__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__NameAssignment_1_in_rule__SystemOperationMode__Group__1__Impl2041);
            rule__SystemOperationMode__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSystemOperationModeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemOperationMode__Group__1__Impl"


    // $ANTLR start "rule__ComponentCategory__Group_8__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1030:1: rule__ComponentCategory__Group_8__0 : rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1 ;
    public final void rule__ComponentCategory__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1034:1: ( rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1035:2: rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_8__0__Impl_in_rule__ComponentCategory__Group_8__02075);
            rule__ComponentCategory__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_8__1_in_rule__ComponentCategory__Group_8__02078);
            rule__ComponentCategory__Group_8__1();

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
    // $ANTLR end "rule__ComponentCategory__Group_8__0"


    // $ANTLR start "rule__ComponentCategory__Group_8__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1042:1: rule__ComponentCategory__Group_8__0__Impl : ( 'subprogram' ) ;
    public final void rule__ComponentCategory__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1046:1: ( ( 'subprogram' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1047:1: ( 'subprogram' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1047:1: ( 'subprogram' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1048:1: 'subprogram'
            {
             before(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
            match(input,16,FOLLOW_16_in_rule__ComponentCategory__Group_8__0__Impl2106); 
             after(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1061:1: rule__ComponentCategory__Group_8__1 : rule__ComponentCategory__Group_8__1__Impl ;
    public final void rule__ComponentCategory__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1065:1: ( rule__ComponentCategory__Group_8__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1066:2: rule__ComponentCategory__Group_8__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_8__1__Impl_in_rule__ComponentCategory__Group_8__12137);
            rule__ComponentCategory__Group_8__1__Impl();

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
    // $ANTLR end "rule__ComponentCategory__Group_8__1"


    // $ANTLR start "rule__ComponentCategory__Group_8__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1072:1: rule__ComponentCategory__Group_8__1__Impl : ( 'group' ) ;
    public final void rule__ComponentCategory__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1076:1: ( ( 'group' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1077:1: ( 'group' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1077:1: ( 'group' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1078:1: 'group'
            {
             before(grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
            match(input,25,FOLLOW_25_in_rule__ComponentCategory__Group_8__1__Impl2165); 
             after(grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1095:1: rule__ComponentCategory__Group_10__0 : rule__ComponentCategory__Group_10__0__Impl rule__ComponentCategory__Group_10__1 ;
    public final void rule__ComponentCategory__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1099:1: ( rule__ComponentCategory__Group_10__0__Impl rule__ComponentCategory__Group_10__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1100:2: rule__ComponentCategory__Group_10__0__Impl rule__ComponentCategory__Group_10__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_10__0__Impl_in_rule__ComponentCategory__Group_10__02200);
            rule__ComponentCategory__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_10__1_in_rule__ComponentCategory__Group_10__02203);
            rule__ComponentCategory__Group_10__1();

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
    // $ANTLR end "rule__ComponentCategory__Group_10__0"


    // $ANTLR start "rule__ComponentCategory__Group_10__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1107:1: rule__ComponentCategory__Group_10__0__Impl : ( 'thread' ) ;
    public final void rule__ComponentCategory__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1111:1: ( ( 'thread' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1112:1: ( 'thread' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1112:1: ( 'thread' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1113:1: 'thread'
            {
             before(grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); 
            match(input,18,FOLLOW_18_in_rule__ComponentCategory__Group_10__0__Impl2231); 
             after(grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1126:1: rule__ComponentCategory__Group_10__1 : rule__ComponentCategory__Group_10__1__Impl ;
    public final void rule__ComponentCategory__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1130:1: ( rule__ComponentCategory__Group_10__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1131:2: rule__ComponentCategory__Group_10__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_10__1__Impl_in_rule__ComponentCategory__Group_10__12262);
            rule__ComponentCategory__Group_10__1__Impl();

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
    // $ANTLR end "rule__ComponentCategory__Group_10__1"


    // $ANTLR start "rule__ComponentCategory__Group_10__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1137:1: rule__ComponentCategory__Group_10__1__Impl : ( 'group' ) ;
    public final void rule__ComponentCategory__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1141:1: ( ( 'group' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1142:1: ( 'group' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1142:1: ( 'group' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1143:1: 'group'
            {
             before(grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); 
            match(input,25,FOLLOW_25_in_rule__ComponentCategory__Group_10__1__Impl2290); 
             after(grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1160:1: rule__ComponentCategory__Group_12__0 : rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1 ;
    public final void rule__ComponentCategory__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1164:1: ( rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1165:2: rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_12__0__Impl_in_rule__ComponentCategory__Group_12__02325);
            rule__ComponentCategory__Group_12__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_12__1_in_rule__ComponentCategory__Group_12__02328);
            rule__ComponentCategory__Group_12__1();

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
    // $ANTLR end "rule__ComponentCategory__Group_12__0"


    // $ANTLR start "rule__ComponentCategory__Group_12__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1172:1: rule__ComponentCategory__Group_12__0__Impl : ( 'virtual' ) ;
    public final void rule__ComponentCategory__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1176:1: ( ( 'virtual' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1177:1: ( 'virtual' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1177:1: ( 'virtual' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1178:1: 'virtual'
            {
             before(grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
            match(input,26,FOLLOW_26_in_rule__ComponentCategory__Group_12__0__Impl2356); 
             after(grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1191:1: rule__ComponentCategory__Group_12__1 : rule__ComponentCategory__Group_12__1__Impl ;
    public final void rule__ComponentCategory__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1195:1: ( rule__ComponentCategory__Group_12__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1196:2: rule__ComponentCategory__Group_12__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_12__1__Impl_in_rule__ComponentCategory__Group_12__12387);
            rule__ComponentCategory__Group_12__1__Impl();

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
    // $ANTLR end "rule__ComponentCategory__Group_12__1"


    // $ANTLR start "rule__ComponentCategory__Group_12__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1202:1: rule__ComponentCategory__Group_12__1__Impl : ( 'bus' ) ;
    public final void rule__ComponentCategory__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1206:1: ( ( 'bus' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1207:1: ( 'bus' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1207:1: ( 'bus' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1208:1: 'bus'
            {
             before(grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
            match(input,10,FOLLOW_10_in_rule__ComponentCategory__Group_12__1__Impl2415); 
             after(grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1225:1: rule__ComponentCategory__Group_13__0 : rule__ComponentCategory__Group_13__0__Impl rule__ComponentCategory__Group_13__1 ;
    public final void rule__ComponentCategory__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1229:1: ( rule__ComponentCategory__Group_13__0__Impl rule__ComponentCategory__Group_13__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1230:2: rule__ComponentCategory__Group_13__0__Impl rule__ComponentCategory__Group_13__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_13__0__Impl_in_rule__ComponentCategory__Group_13__02450);
            rule__ComponentCategory__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_13__1_in_rule__ComponentCategory__Group_13__02453);
            rule__ComponentCategory__Group_13__1();

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
    // $ANTLR end "rule__ComponentCategory__Group_13__0"


    // $ANTLR start "rule__ComponentCategory__Group_13__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1237:1: rule__ComponentCategory__Group_13__0__Impl : ( 'virtual' ) ;
    public final void rule__ComponentCategory__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1241:1: ( ( 'virtual' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1242:1: ( 'virtual' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1242:1: ( 'virtual' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1243:1: 'virtual'
            {
             before(grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); 
            match(input,26,FOLLOW_26_in_rule__ComponentCategory__Group_13__0__Impl2481); 
             after(grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1256:1: rule__ComponentCategory__Group_13__1 : rule__ComponentCategory__Group_13__1__Impl ;
    public final void rule__ComponentCategory__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1260:1: ( rule__ComponentCategory__Group_13__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1261:2: rule__ComponentCategory__Group_13__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_13__1__Impl_in_rule__ComponentCategory__Group_13__12512);
            rule__ComponentCategory__Group_13__1__Impl();

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
    // $ANTLR end "rule__ComponentCategory__Group_13__1"


    // $ANTLR start "rule__ComponentCategory__Group_13__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1267:1: rule__ComponentCategory__Group_13__1__Impl : ( 'processor' ) ;
    public final void rule__ComponentCategory__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1271:1: ( ( 'processor' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1272:1: ( 'processor' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1272:1: ( 'processor' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1273:1: 'processor'
            {
             before(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_13_1()); 
            match(input,15,FOLLOW_15_in_rule__ComponentCategory__Group_13__1__Impl2540); 
             after(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_13_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__IMPLREF__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1290:1: rule__IMPLREF__Group__0 : rule__IMPLREF__Group__0__Impl rule__IMPLREF__Group__1 ;
    public final void rule__IMPLREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1294:1: ( rule__IMPLREF__Group__0__Impl rule__IMPLREF__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1295:2: rule__IMPLREF__Group__0__Impl rule__IMPLREF__Group__1
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group__0__Impl_in_rule__IMPLREF__Group__02575);
            rule__IMPLREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IMPLREF__Group__1_in_rule__IMPLREF__Group__02578);
            rule__IMPLREF__Group__1();

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
    // $ANTLR end "rule__IMPLREF__Group__0"


    // $ANTLR start "rule__IMPLREF__Group__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1302:1: rule__IMPLREF__Group__0__Impl : ( ( ( rule__IMPLREF__Group_0__0 ) ) ( ( rule__IMPLREF__Group_0__0 )* ) ) ;
    public final void rule__IMPLREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1306:1: ( ( ( ( rule__IMPLREF__Group_0__0 ) ) ( ( rule__IMPLREF__Group_0__0 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1307:1: ( ( ( rule__IMPLREF__Group_0__0 ) ) ( ( rule__IMPLREF__Group_0__0 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1307:1: ( ( ( rule__IMPLREF__Group_0__0 ) ) ( ( rule__IMPLREF__Group_0__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1308:1: ( ( rule__IMPLREF__Group_0__0 ) ) ( ( rule__IMPLREF__Group_0__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1308:1: ( ( rule__IMPLREF__Group_0__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1309:1: ( rule__IMPLREF__Group_0__0 )
            {
             before(grammarAccess.getIMPLREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1310:1: ( rule__IMPLREF__Group_0__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1310:2: rule__IMPLREF__Group_0__0
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group_0__0_in_rule__IMPLREF__Group__0__Impl2607);
            rule__IMPLREF__Group_0__0();

            state._fsp--;


            }

             after(grammarAccess.getIMPLREFAccess().getGroup_0()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1313:1: ( ( rule__IMPLREF__Group_0__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1314:1: ( rule__IMPLREF__Group_0__0 )*
            {
             before(grammarAccess.getIMPLREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1315:1: ( rule__IMPLREF__Group_0__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1==28) ) {
                        alt7=1;
                    }


                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1315:2: rule__IMPLREF__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__IMPLREF__Group_0__0_in_rule__IMPLREF__Group__0__Impl2619);
            	    rule__IMPLREF__Group_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getIMPLREFAccess().getGroup_0()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IMPLREF__Group__0__Impl"


    // $ANTLR start "rule__IMPLREF__Group__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1326:1: rule__IMPLREF__Group__1 : rule__IMPLREF__Group__1__Impl rule__IMPLREF__Group__2 ;
    public final void rule__IMPLREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1330:1: ( rule__IMPLREF__Group__1__Impl rule__IMPLREF__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1331:2: rule__IMPLREF__Group__1__Impl rule__IMPLREF__Group__2
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group__1__Impl_in_rule__IMPLREF__Group__12652);
            rule__IMPLREF__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IMPLREF__Group__2_in_rule__IMPLREF__Group__12655);
            rule__IMPLREF__Group__2();

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
    // $ANTLR end "rule__IMPLREF__Group__1"


    // $ANTLR start "rule__IMPLREF__Group__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1338:1: rule__IMPLREF__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__IMPLREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1342:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1343:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1343:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1344:1: RULE_ID
            {
             before(grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IMPLREF__Group__1__Impl2682); 
             after(grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IMPLREF__Group__1__Impl"


    // $ANTLR start "rule__IMPLREF__Group__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1355:1: rule__IMPLREF__Group__2 : rule__IMPLREF__Group__2__Impl rule__IMPLREF__Group__3 ;
    public final void rule__IMPLREF__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1359:1: ( rule__IMPLREF__Group__2__Impl rule__IMPLREF__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1360:2: rule__IMPLREF__Group__2__Impl rule__IMPLREF__Group__3
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group__2__Impl_in_rule__IMPLREF__Group__22711);
            rule__IMPLREF__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IMPLREF__Group__3_in_rule__IMPLREF__Group__22714);
            rule__IMPLREF__Group__3();

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
    // $ANTLR end "rule__IMPLREF__Group__2"


    // $ANTLR start "rule__IMPLREF__Group__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1367:1: rule__IMPLREF__Group__2__Impl : ( '.' ) ;
    public final void rule__IMPLREF__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1371:1: ( ( '.' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1372:1: ( '.' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1372:1: ( '.' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1373:1: '.'
            {
             before(grammarAccess.getIMPLREFAccess().getFullStopKeyword_2()); 
            match(input,27,FOLLOW_27_in_rule__IMPLREF__Group__2__Impl2742); 
             after(grammarAccess.getIMPLREFAccess().getFullStopKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IMPLREF__Group__2__Impl"


    // $ANTLR start "rule__IMPLREF__Group__3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1386:1: rule__IMPLREF__Group__3 : rule__IMPLREF__Group__3__Impl ;
    public final void rule__IMPLREF__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1390:1: ( rule__IMPLREF__Group__3__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1391:2: rule__IMPLREF__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group__3__Impl_in_rule__IMPLREF__Group__32773);
            rule__IMPLREF__Group__3__Impl();

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
    // $ANTLR end "rule__IMPLREF__Group__3"


    // $ANTLR start "rule__IMPLREF__Group__3__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1397:1: rule__IMPLREF__Group__3__Impl : ( RULE_ID ) ;
    public final void rule__IMPLREF__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1401:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1402:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1402:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1403:1: RULE_ID
            {
             before(grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_3()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IMPLREF__Group__3__Impl2800); 
             after(grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IMPLREF__Group__3__Impl"


    // $ANTLR start "rule__IMPLREF__Group_0__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1422:1: rule__IMPLREF__Group_0__0 : rule__IMPLREF__Group_0__0__Impl rule__IMPLREF__Group_0__1 ;
    public final void rule__IMPLREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1426:1: ( rule__IMPLREF__Group_0__0__Impl rule__IMPLREF__Group_0__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1427:2: rule__IMPLREF__Group_0__0__Impl rule__IMPLREF__Group_0__1
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group_0__0__Impl_in_rule__IMPLREF__Group_0__02837);
            rule__IMPLREF__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IMPLREF__Group_0__1_in_rule__IMPLREF__Group_0__02840);
            rule__IMPLREF__Group_0__1();

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
    // $ANTLR end "rule__IMPLREF__Group_0__0"


    // $ANTLR start "rule__IMPLREF__Group_0__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1434:1: rule__IMPLREF__Group_0__0__Impl : ( RULE_ID ) ;
    public final void rule__IMPLREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1438:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1439:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1439:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1440:1: RULE_ID
            {
             before(grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IMPLREF__Group_0__0__Impl2867); 
             after(grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IMPLREF__Group_0__0__Impl"


    // $ANTLR start "rule__IMPLREF__Group_0__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1451:1: rule__IMPLREF__Group_0__1 : rule__IMPLREF__Group_0__1__Impl ;
    public final void rule__IMPLREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1455:1: ( rule__IMPLREF__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1456:2: rule__IMPLREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group_0__1__Impl_in_rule__IMPLREF__Group_0__12896);
            rule__IMPLREF__Group_0__1__Impl();

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
    // $ANTLR end "rule__IMPLREF__Group_0__1"


    // $ANTLR start "rule__IMPLREF__Group_0__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1462:1: rule__IMPLREF__Group_0__1__Impl : ( '::' ) ;
    public final void rule__IMPLREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1466:1: ( ( '::' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1467:1: ( '::' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1467:1: ( '::' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1468:1: '::'
            {
             before(grammarAccess.getIMPLREFAccess().getColonColonKeyword_0_1()); 
            match(input,28,FOLLOW_28_in_rule__IMPLREF__Group_0__1__Impl2924); 
             after(grammarAccess.getIMPLREFAccess().getColonColonKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IMPLREF__Group_0__1__Impl"


    // $ANTLR start "rule__SUBREF__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1485:1: rule__SUBREF__Group__0 : rule__SUBREF__Group__0__Impl rule__SUBREF__Group__1 ;
    public final void rule__SUBREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1489:1: ( rule__SUBREF__Group__0__Impl rule__SUBREF__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1490:2: rule__SUBREF__Group__0__Impl rule__SUBREF__Group__1
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__0__Impl_in_rule__SUBREF__Group__02959);
            rule__SUBREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group__1_in_rule__SUBREF__Group__02962);
            rule__SUBREF__Group__1();

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
    // $ANTLR end "rule__SUBREF__Group__0"


    // $ANTLR start "rule__SUBREF__Group__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1497:1: rule__SUBREF__Group__0__Impl : ( ( ( rule__SUBREF__Group_0__0 ) ) ( ( rule__SUBREF__Group_0__0 )* ) ) ;
    public final void rule__SUBREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1501:1: ( ( ( ( rule__SUBREF__Group_0__0 ) ) ( ( rule__SUBREF__Group_0__0 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1502:1: ( ( ( rule__SUBREF__Group_0__0 ) ) ( ( rule__SUBREF__Group_0__0 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1502:1: ( ( ( rule__SUBREF__Group_0__0 ) ) ( ( rule__SUBREF__Group_0__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1503:1: ( ( rule__SUBREF__Group_0__0 ) ) ( ( rule__SUBREF__Group_0__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1503:1: ( ( rule__SUBREF__Group_0__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1504:1: ( rule__SUBREF__Group_0__0 )
            {
             before(grammarAccess.getSUBREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1505:1: ( rule__SUBREF__Group_0__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1505:2: rule__SUBREF__Group_0__0
            {
            pushFollow(FOLLOW_rule__SUBREF__Group_0__0_in_rule__SUBREF__Group__0__Impl2991);
            rule__SUBREF__Group_0__0();

            state._fsp--;


            }

             after(grammarAccess.getSUBREFAccess().getGroup_0()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1508:1: ( ( rule__SUBREF__Group_0__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1509:1: ( rule__SUBREF__Group_0__0 )*
            {
             before(grammarAccess.getSUBREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1510:1: ( rule__SUBREF__Group_0__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1==28) ) {
                        alt8=1;
                    }


                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1510:2: rule__SUBREF__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__SUBREF__Group_0__0_in_rule__SUBREF__Group__0__Impl3003);
            	    rule__SUBREF__Group_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getSUBREFAccess().getGroup_0()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SUBREF__Group__0__Impl"


    // $ANTLR start "rule__SUBREF__Group__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1521:1: rule__SUBREF__Group__1 : rule__SUBREF__Group__1__Impl rule__SUBREF__Group__2 ;
    public final void rule__SUBREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1525:1: ( rule__SUBREF__Group__1__Impl rule__SUBREF__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1526:2: rule__SUBREF__Group__1__Impl rule__SUBREF__Group__2
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__1__Impl_in_rule__SUBREF__Group__13036);
            rule__SUBREF__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group__2_in_rule__SUBREF__Group__13039);
            rule__SUBREF__Group__2();

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
    // $ANTLR end "rule__SUBREF__Group__1"


    // $ANTLR start "rule__SUBREF__Group__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1533:1: rule__SUBREF__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__SUBREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1537:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1538:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1538:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1539:1: RULE_ID
            {
             before(grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SUBREF__Group__1__Impl3066); 
             after(grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SUBREF__Group__1__Impl"


    // $ANTLR start "rule__SUBREF__Group__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1550:1: rule__SUBREF__Group__2 : rule__SUBREF__Group__2__Impl rule__SUBREF__Group__3 ;
    public final void rule__SUBREF__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1554:1: ( rule__SUBREF__Group__2__Impl rule__SUBREF__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1555:2: rule__SUBREF__Group__2__Impl rule__SUBREF__Group__3
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__2__Impl_in_rule__SUBREF__Group__23095);
            rule__SUBREF__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group__3_in_rule__SUBREF__Group__23098);
            rule__SUBREF__Group__3();

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
    // $ANTLR end "rule__SUBREF__Group__2"


    // $ANTLR start "rule__SUBREF__Group__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1562:1: rule__SUBREF__Group__2__Impl : ( '.' ) ;
    public final void rule__SUBREF__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1566:1: ( ( '.' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1567:1: ( '.' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1567:1: ( '.' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1568:1: '.'
            {
             before(grammarAccess.getSUBREFAccess().getFullStopKeyword_2()); 
            match(input,27,FOLLOW_27_in_rule__SUBREF__Group__2__Impl3126); 
             after(grammarAccess.getSUBREFAccess().getFullStopKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SUBREF__Group__2__Impl"


    // $ANTLR start "rule__SUBREF__Group__3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1581:1: rule__SUBREF__Group__3 : rule__SUBREF__Group__3__Impl rule__SUBREF__Group__4 ;
    public final void rule__SUBREF__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1585:1: ( rule__SUBREF__Group__3__Impl rule__SUBREF__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1586:2: rule__SUBREF__Group__3__Impl rule__SUBREF__Group__4
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__3__Impl_in_rule__SUBREF__Group__33157);
            rule__SUBREF__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group__4_in_rule__SUBREF__Group__33160);
            rule__SUBREF__Group__4();

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
    // $ANTLR end "rule__SUBREF__Group__3"


    // $ANTLR start "rule__SUBREF__Group__3__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1593:1: rule__SUBREF__Group__3__Impl : ( RULE_ID ) ;
    public final void rule__SUBREF__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1597:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1598:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1598:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1599:1: RULE_ID
            {
             before(grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_3()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SUBREF__Group__3__Impl3187); 
             after(grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SUBREF__Group__3__Impl"


    // $ANTLR start "rule__SUBREF__Group__4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1610:1: rule__SUBREF__Group__4 : rule__SUBREF__Group__4__Impl rule__SUBREF__Group__5 ;
    public final void rule__SUBREF__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1614:1: ( rule__SUBREF__Group__4__Impl rule__SUBREF__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1615:2: rule__SUBREF__Group__4__Impl rule__SUBREF__Group__5
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__4__Impl_in_rule__SUBREF__Group__43216);
            rule__SUBREF__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group__5_in_rule__SUBREF__Group__43219);
            rule__SUBREF__Group__5();

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
    // $ANTLR end "rule__SUBREF__Group__4"


    // $ANTLR start "rule__SUBREF__Group__4__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1622:1: rule__SUBREF__Group__4__Impl : ( '::' ) ;
    public final void rule__SUBREF__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1626:1: ( ( '::' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1627:1: ( '::' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1627:1: ( '::' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1628:1: '::'
            {
             before(grammarAccess.getSUBREFAccess().getColonColonKeyword_4()); 
            match(input,28,FOLLOW_28_in_rule__SUBREF__Group__4__Impl3247); 
             after(grammarAccess.getSUBREFAccess().getColonColonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SUBREF__Group__4__Impl"


    // $ANTLR start "rule__SUBREF__Group__5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1641:1: rule__SUBREF__Group__5 : rule__SUBREF__Group__5__Impl ;
    public final void rule__SUBREF__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1645:1: ( rule__SUBREF__Group__5__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1646:2: rule__SUBREF__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__5__Impl_in_rule__SUBREF__Group__53278);
            rule__SUBREF__Group__5__Impl();

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
    // $ANTLR end "rule__SUBREF__Group__5"


    // $ANTLR start "rule__SUBREF__Group__5__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1652:1: rule__SUBREF__Group__5__Impl : ( RULE_ID ) ;
    public final void rule__SUBREF__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1656:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1657:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1657:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1658:1: RULE_ID
            {
             before(grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_5()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SUBREF__Group__5__Impl3305); 
             after(grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SUBREF__Group__5__Impl"


    // $ANTLR start "rule__SUBREF__Group_0__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1681:1: rule__SUBREF__Group_0__0 : rule__SUBREF__Group_0__0__Impl rule__SUBREF__Group_0__1 ;
    public final void rule__SUBREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1685:1: ( rule__SUBREF__Group_0__0__Impl rule__SUBREF__Group_0__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1686:2: rule__SUBREF__Group_0__0__Impl rule__SUBREF__Group_0__1
            {
            pushFollow(FOLLOW_rule__SUBREF__Group_0__0__Impl_in_rule__SUBREF__Group_0__03346);
            rule__SUBREF__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group_0__1_in_rule__SUBREF__Group_0__03349);
            rule__SUBREF__Group_0__1();

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
    // $ANTLR end "rule__SUBREF__Group_0__0"


    // $ANTLR start "rule__SUBREF__Group_0__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1693:1: rule__SUBREF__Group_0__0__Impl : ( RULE_ID ) ;
    public final void rule__SUBREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1697:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1698:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1698:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1699:1: RULE_ID
            {
             before(grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SUBREF__Group_0__0__Impl3376); 
             after(grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SUBREF__Group_0__0__Impl"


    // $ANTLR start "rule__SUBREF__Group_0__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1710:1: rule__SUBREF__Group_0__1 : rule__SUBREF__Group_0__1__Impl ;
    public final void rule__SUBREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1714:1: ( rule__SUBREF__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1715:2: rule__SUBREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__SUBREF__Group_0__1__Impl_in_rule__SUBREF__Group_0__13405);
            rule__SUBREF__Group_0__1__Impl();

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
    // $ANTLR end "rule__SUBREF__Group_0__1"


    // $ANTLR start "rule__SUBREF__Group_0__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1721:1: rule__SUBREF__Group_0__1__Impl : ( '::' ) ;
    public final void rule__SUBREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1725:1: ( ( '::' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1726:1: ( '::' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1726:1: ( '::' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1727:1: '::'
            {
             before(grammarAccess.getSUBREFAccess().getColonColonKeyword_0_1()); 
            match(input,28,FOLLOW_28_in_rule__SUBREF__Group_0__1__Impl3433); 
             after(grammarAccess.getSUBREFAccess().getColonColonKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SUBREF__Group_0__1__Impl"


    // $ANTLR start "rule__SystemInstance__CategoryAssignment_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1745:1: rule__SystemInstance__CategoryAssignment_0 : ( ruleComponentCategory ) ;
    public final void rule__SystemInstance__CategoryAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1749:1: ( ( ruleComponentCategory ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1750:1: ( ruleComponentCategory )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1750:1: ( ruleComponentCategory )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1751:1: ruleComponentCategory
            {
             before(grammarAccess.getSystemInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_rule__SystemInstance__CategoryAssignment_03473);
            ruleComponentCategory();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__CategoryAssignment_0"


    // $ANTLR start "rule__SystemInstance__NameAssignment_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1760:1: rule__SystemInstance__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SystemInstance__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1764:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1765:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1765:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1766:1: RULE_ID
            {
             before(grammarAccess.getSystemInstanceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SystemInstance__NameAssignment_13504); 
             after(grammarAccess.getSystemInstanceAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__NameAssignment_1"


    // $ANTLR start "rule__SystemInstance__ComponentImplementationAssignment_3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1775:1: rule__SystemInstance__ComponentImplementationAssignment_3 : ( ( ruleIMPLREF ) ) ;
    public final void rule__SystemInstance__ComponentImplementationAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1779:1: ( ( ( ruleIMPLREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1780:1: ( ( ruleIMPLREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1780:1: ( ( ruleIMPLREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1781:1: ( ruleIMPLREF )
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationCrossReference_3_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1782:1: ( ruleIMPLREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1783:1: ruleIMPLREF
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationIMPLREFParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_ruleIMPLREF_in_rule__SystemInstance__ComponentImplementationAssignment_33539);
            ruleIMPLREF();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationIMPLREFParserRuleCall_3_0_1()); 

            }

             after(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__ComponentImplementationAssignment_3"


    // $ANTLR start "rule__SystemInstance__ComponentInstanceAssignment_5_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1794:1: rule__SystemInstance__ComponentInstanceAssignment_5_0 : ( ruleComponentInstance ) ;
    public final void rule__SystemInstance__ComponentInstanceAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1798:1: ( ( ruleComponentInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1799:1: ( ruleComponentInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1799:1: ( ruleComponentInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1800:1: ruleComponentInstance
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_5_0_0()); 
            pushFollow(FOLLOW_ruleComponentInstance_in_rule__SystemInstance__ComponentInstanceAssignment_5_03574);
            ruleComponentInstance();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_5_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__ComponentInstanceAssignment_5_0"


    // $ANTLR start "rule__SystemInstance__SystemOperationModeAssignment_5_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1809:1: rule__SystemInstance__SystemOperationModeAssignment_5_1 : ( ruleSystemOperationMode ) ;
    public final void rule__SystemInstance__SystemOperationModeAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1813:1: ( ( ruleSystemOperationMode ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1814:1: ( ruleSystemOperationMode )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1814:1: ( ruleSystemOperationMode )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1815:1: ruleSystemOperationMode
            {
             before(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_ruleSystemOperationMode_in_rule__SystemInstance__SystemOperationModeAssignment_5_13605);
            ruleSystemOperationMode();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__SystemOperationModeAssignment_5_1"


    // $ANTLR start "rule__ComponentInstance__CategoryAssignment_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1824:1: rule__ComponentInstance__CategoryAssignment_0 : ( ruleComponentCategory ) ;
    public final void rule__ComponentInstance__CategoryAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1828:1: ( ( ruleComponentCategory ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1829:1: ( ruleComponentCategory )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1829:1: ( ruleComponentCategory )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1830:1: ruleComponentCategory
            {
             before(grammarAccess.getComponentInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_rule__ComponentInstance__CategoryAssignment_03636);
            ruleComponentCategory();

            state._fsp--;

             after(grammarAccess.getComponentInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__CategoryAssignment_0"


    // $ANTLR start "rule__ComponentInstance__NameAssignment_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1839:1: rule__ComponentInstance__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ComponentInstance__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1843:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1844:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1844:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1845:1: RULE_ID
            {
             before(grammarAccess.getComponentInstanceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ComponentInstance__NameAssignment_13667); 
             after(grammarAccess.getComponentInstanceAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__NameAssignment_1"


    // $ANTLR start "rule__ComponentInstance__IndexAssignment_2_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1854:1: rule__ComponentInstance__IndexAssignment_2_1 : ( RULE_LONG ) ;
    public final void rule__ComponentInstance__IndexAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1858:1: ( ( RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1859:1: ( RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1859:1: ( RULE_LONG )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1860:1: RULE_LONG
            {
             before(grammarAccess.getComponentInstanceAccess().getIndexLONGTerminalRuleCall_2_1_0()); 
            match(input,RULE_LONG,FOLLOW_RULE_LONG_in_rule__ComponentInstance__IndexAssignment_2_13698); 
             after(grammarAccess.getComponentInstanceAccess().getIndexLONGTerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__IndexAssignment_2_1"


    // $ANTLR start "rule__ComponentInstance__SubcomponentAssignment_4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1869:1: rule__ComponentInstance__SubcomponentAssignment_4 : ( ( ruleSUBREF ) ) ;
    public final void rule__ComponentInstance__SubcomponentAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1873:1: ( ( ( ruleSUBREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1874:1: ( ( ruleSUBREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1874:1: ( ( ruleSUBREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1875:1: ( ruleSUBREF )
            {
             before(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentCrossReference_4_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1876:1: ( ruleSUBREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1877:1: ruleSUBREF
            {
             before(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentSUBREFParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_ruleSUBREF_in_rule__ComponentInstance__SubcomponentAssignment_43733);
            ruleSUBREF();

            state._fsp--;

             after(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentSUBREFParserRuleCall_4_0_1()); 

            }

             after(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__SubcomponentAssignment_4"


    // $ANTLR start "rule__ComponentInstance__ComponentInstanceAssignment_5_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1888:1: rule__ComponentInstance__ComponentInstanceAssignment_5_1 : ( ruleComponentInstance ) ;
    public final void rule__ComponentInstance__ComponentInstanceAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1892:1: ( ( ruleComponentInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1893:1: ( ruleComponentInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1893:1: ( ruleComponentInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1894:1: ruleComponentInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_ruleComponentInstance_in_rule__ComponentInstance__ComponentInstanceAssignment_5_13768);
            ruleComponentInstance();

            state._fsp--;

             after(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__ComponentInstanceAssignment_5_1"


    // $ANTLR start "rule__SystemOperationMode__NameAssignment_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1903:1: rule__SystemOperationMode__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__SystemOperationMode__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1907:1: ( ( RULE_STRING ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1908:1: ( RULE_STRING )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1908:1: ( RULE_STRING )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1909:1: RULE_STRING
            {
             before(grammarAccess.getSystemOperationModeAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__SystemOperationMode__NameAssignment_13799); 
             after(grammarAccess.getSystemOperationModeAccess().getNameSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemOperationMode__NameAssignment_1"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    static final String DFA2_eotS =
        "\22\uffff";
    static final String DFA2_eofS =
        "\10\uffff\1\15\1\uffff\1\17\7\uffff";
    static final String DFA2_minS =
        "\1\11\7\uffff\1\4\1\uffff\1\4\1\12\6\uffff";
    static final String DFA2_maxS =
        "\1\32\7\uffff\1\31\1\uffff\1\31\1\17\6\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\2\uffff\1\11\1\10\1\13\1\14\1\16\1\15";
    static final String DFA2_specialS =
        "\22\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\7\uffff\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\15\24\uffff\1\14",
            "",
            "\1\17\24\uffff\1\16",
            "\1\21\4\uffff\1\20",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "250:1: rule__ComponentCategory__Alternatives : ( ( 'abstract' ) | ( 'bus' ) | ( 'data' ) | ( 'device' ) | ( 'memory' ) | ( 'process' ) | ( 'processor' ) | ( 'subprogram' ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( 'system' ) | ( ( rule__ComponentCategory__Group_10__0 ) ) | ( 'thread' ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( ( rule__ComponentCategory__Group_13__0 ) ) );";
        }
    }
 

    public static final BitSet FOLLOW_ruleSystemInstance_in_entryRuleSystemInstance61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemInstance68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__0_in_ruleSystemInstance94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_entryRuleComponentInstance121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentInstance128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__0_in_ruleComponentInstance154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemOperationMode188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__0_in_ruleSystemOperationMode214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentCategory248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Alternatives_in_ruleComponentCategory274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIMPLREF_in_entryRuleIMPLREF301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIMPLREF308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__0_in_ruleIMPLREF334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSUBREF_in_entryRuleSUBREF361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSUBREF368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__0_in_ruleSUBREF394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__ComponentInstanceAssignment_5_0_in_rule__SystemInstance__Alternatives_5430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__SystemOperationModeAssignment_5_1_in_rule__SystemInstance__Alternatives_5448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_rule__ComponentCategory__Alternatives482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__ComponentCategory__Alternatives502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__ComponentCategory__Alternatives522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ComponentCategory__Alternatives542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ComponentCategory__Alternatives562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__ComponentCategory__Alternatives582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ComponentCategory__Alternatives602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ComponentCategory__Alternatives622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__0_in_rule__ComponentCategory__Alternatives641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__ComponentCategory__Alternatives660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_10__0_in_rule__ComponentCategory__Alternatives679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ComponentCategory__Alternatives698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__0_in_rule__ComponentCategory__Alternatives717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_13__0_in_rule__ComponentCategory__Alternatives735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__0__Impl_in_rule__SystemInstance__Group__0766 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__1_in_rule__SystemInstance__Group__0769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__CategoryAssignment_0_in_rule__SystemInstance__Group__0__Impl796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__1__Impl_in_rule__SystemInstance__Group__1826 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__2_in_rule__SystemInstance__Group__1829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__NameAssignment_1_in_rule__SystemInstance__Group__1__Impl856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__2__Impl_in_rule__SystemInstance__Group__2886 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__3_in_rule__SystemInstance__Group__2889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__SystemInstance__Group__2__Impl917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__3__Impl_in_rule__SystemInstance__Group__3948 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__4_in_rule__SystemInstance__Group__3951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__ComponentImplementationAssignment_3_in_rule__SystemInstance__Group__3__Impl978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__4__Impl_in_rule__SystemInstance__Group__41008 = new BitSet(new long[]{0x000000000527FE00L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__5_in_rule__SystemInstance__Group__41011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__SystemInstance__Group__4__Impl1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__5__Impl_in_rule__SystemInstance__Group__51070 = new BitSet(new long[]{0x000000000527FE00L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__6_in_rule__SystemInstance__Group__51073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Alternatives_5_in_rule__SystemInstance__Group__5__Impl1100 = new BitSet(new long[]{0x000000000507FE02L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__6__Impl_in_rule__SystemInstance__Group__61131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__SystemInstance__Group__6__Impl1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__0__Impl_in_rule__ComponentInstance__Group__01204 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__1_in_rule__ComponentInstance__Group__01207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__CategoryAssignment_0_in_rule__ComponentInstance__Group__0__Impl1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__1__Impl_in_rule__ComponentInstance__Group__11264 = new BitSet(new long[]{0x0000000000480000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__2_in_rule__ComponentInstance__Group__11267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__NameAssignment_1_in_rule__ComponentInstance__Group__1__Impl1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__2__Impl_in_rule__ComponentInstance__Group__21324 = new BitSet(new long[]{0x0000000000480000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__3_in_rule__ComponentInstance__Group__21327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__0_in_rule__ComponentInstance__Group__2__Impl1354 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__3__Impl_in_rule__ComponentInstance__Group__31385 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__4_in_rule__ComponentInstance__Group__31388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ComponentInstance__Group__3__Impl1416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__4__Impl_in_rule__ComponentInstance__Group__41447 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__5_in_rule__ComponentInstance__Group__41450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__SubcomponentAssignment_4_in_rule__ComponentInstance__Group__4__Impl1477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__5__Impl_in_rule__ComponentInstance__Group__51507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__0_in_rule__ComponentInstance__Group__5__Impl1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__0__Impl_in_rule__ComponentInstance__Group_2__01577 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__1_in_rule__ComponentInstance__Group_2__01580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ComponentInstance__Group_2__0__Impl1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__1__Impl_in_rule__ComponentInstance__Group_2__11639 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__2_in_rule__ComponentInstance__Group_2__11642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__IndexAssignment_2_1_in_rule__ComponentInstance__Group_2__1__Impl1669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__2__Impl_in_rule__ComponentInstance__Group_2__21699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ComponentInstance__Group_2__2__Impl1727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__0__Impl_in_rule__ComponentInstance__Group_5__01764 = new BitSet(new long[]{0x000000000427FE00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__1_in_rule__ComponentInstance__Group_5__01767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ComponentInstance__Group_5__0__Impl1795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__1__Impl_in_rule__ComponentInstance__Group_5__11826 = new BitSet(new long[]{0x000000000427FE00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__2_in_rule__ComponentInstance__Group_5__11829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__ComponentInstanceAssignment_5_1_in_rule__ComponentInstance__Group_5__1__Impl1856 = new BitSet(new long[]{0x000000000407FE02L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__2__Impl_in_rule__ComponentInstance__Group_5__21887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ComponentInstance__Group_5__2__Impl1915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__0__Impl_in_rule__SystemOperationMode__Group__01952 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__1_in_rule__SystemOperationMode__Group__01955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__SystemOperationMode__Group__0__Impl1983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__1__Impl_in_rule__SystemOperationMode__Group__12014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__NameAssignment_1_in_rule__SystemOperationMode__Group__1__Impl2041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__0__Impl_in_rule__ComponentCategory__Group_8__02075 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__1_in_rule__ComponentCategory__Group_8__02078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ComponentCategory__Group_8__0__Impl2106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__1__Impl_in_rule__ComponentCategory__Group_8__12137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ComponentCategory__Group_8__1__Impl2165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_10__0__Impl_in_rule__ComponentCategory__Group_10__02200 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_10__1_in_rule__ComponentCategory__Group_10__02203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ComponentCategory__Group_10__0__Impl2231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_10__1__Impl_in_rule__ComponentCategory__Group_10__12262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ComponentCategory__Group_10__1__Impl2290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__0__Impl_in_rule__ComponentCategory__Group_12__02325 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__1_in_rule__ComponentCategory__Group_12__02328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ComponentCategory__Group_12__0__Impl2356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__1__Impl_in_rule__ComponentCategory__Group_12__12387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__ComponentCategory__Group_12__1__Impl2415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_13__0__Impl_in_rule__ComponentCategory__Group_13__02450 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_13__1_in_rule__ComponentCategory__Group_13__02453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ComponentCategory__Group_13__0__Impl2481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_13__1__Impl_in_rule__ComponentCategory__Group_13__12512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ComponentCategory__Group_13__1__Impl2540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__0__Impl_in_rule__IMPLREF__Group__02575 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__1_in_rule__IMPLREF__Group__02578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group_0__0_in_rule__IMPLREF__Group__0__Impl2607 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group_0__0_in_rule__IMPLREF__Group__0__Impl2619 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__1__Impl_in_rule__IMPLREF__Group__12652 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__2_in_rule__IMPLREF__Group__12655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IMPLREF__Group__1__Impl2682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__2__Impl_in_rule__IMPLREF__Group__22711 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__3_in_rule__IMPLREF__Group__22714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__IMPLREF__Group__2__Impl2742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__3__Impl_in_rule__IMPLREF__Group__32773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IMPLREF__Group__3__Impl2800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group_0__0__Impl_in_rule__IMPLREF__Group_0__02837 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group_0__1_in_rule__IMPLREF__Group_0__02840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IMPLREF__Group_0__0__Impl2867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group_0__1__Impl_in_rule__IMPLREF__Group_0__12896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__IMPLREF__Group_0__1__Impl2924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__0__Impl_in_rule__SUBREF__Group__02959 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__1_in_rule__SUBREF__Group__02962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group_0__0_in_rule__SUBREF__Group__0__Impl2991 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SUBREF__Group_0__0_in_rule__SUBREF__Group__0__Impl3003 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__1__Impl_in_rule__SUBREF__Group__13036 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__2_in_rule__SUBREF__Group__13039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SUBREF__Group__1__Impl3066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__2__Impl_in_rule__SUBREF__Group__23095 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__3_in_rule__SUBREF__Group__23098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__SUBREF__Group__2__Impl3126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__3__Impl_in_rule__SUBREF__Group__33157 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__4_in_rule__SUBREF__Group__33160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SUBREF__Group__3__Impl3187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__4__Impl_in_rule__SUBREF__Group__43216 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__5_in_rule__SUBREF__Group__43219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__SUBREF__Group__4__Impl3247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__5__Impl_in_rule__SUBREF__Group__53278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SUBREF__Group__5__Impl3305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group_0__0__Impl_in_rule__SUBREF__Group_0__03346 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__SUBREF__Group_0__1_in_rule__SUBREF__Group_0__03349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SUBREF__Group_0__0__Impl3376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group_0__1__Impl_in_rule__SUBREF__Group_0__13405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__SUBREF__Group_0__1__Impl3433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_rule__SystemInstance__CategoryAssignment_03473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SystemInstance__NameAssignment_13504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIMPLREF_in_rule__SystemInstance__ComponentImplementationAssignment_33539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_rule__SystemInstance__ComponentInstanceAssignment_5_03574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_rule__SystemInstance__SystemOperationModeAssignment_5_13605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_rule__ComponentInstance__CategoryAssignment_03636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ComponentInstance__NameAssignment_13667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_rule__ComponentInstance__IndexAssignment_2_13698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSUBREF_in_rule__ComponentInstance__SubcomponentAssignment_43733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_rule__ComponentInstance__ComponentInstanceAssignment_5_13768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__SystemOperationMode__NameAssignment_13799 = new BitSet(new long[]{0x0000000000000002L});

}