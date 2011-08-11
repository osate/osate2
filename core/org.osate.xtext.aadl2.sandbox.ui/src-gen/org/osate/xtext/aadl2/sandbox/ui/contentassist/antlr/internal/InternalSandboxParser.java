package org.osate.xtext.aadl2.sandbox.ui.contentassist.antlr.internal; 

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
import org.osate.xtext.aadl2.sandbox.services.SandboxGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSandboxParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_8", "KEYWORD_7", "KEYWORD_6", "KEYWORD_5", "KEYWORD_3", "KEYWORD_4", "KEYWORD_1", "KEYWORD_2", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=12;
    public static final int RULE_STRING=14;
    public static final int RULE_ANY_OTHER=18;
    public static final int KEYWORD_6=6;
    public static final int KEYWORD_7=5;
    public static final int KEYWORD_8=4;
    public static final int KEYWORD_1=10;
    public static final int RULE_INT=13;
    public static final int KEYWORD_5=7;
    public static final int KEYWORD_4=9;
    public static final int KEYWORD_3=8;
    public static final int KEYWORD_2=11;
    public static final int RULE_WS=17;
    public static final int RULE_SL_COMMENT=16;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=15;

    // delegates
    // delegators


        public InternalSandboxParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSandboxParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSandboxParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g"; }


     
     	private SandboxGrammarAccess grammarAccess;
     	
     	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
     	
     	{
    		tokenNameToValue.put("KEYWORD_1", "'.'");
    		tokenNameToValue.put("KEYWORD_2", "';'");
    		tokenNameToValue.put("KEYWORD_3", "'::'");
    		tokenNameToValue.put("KEYWORD_4", "'to'");
    		tokenNameToValue.put("KEYWORD_5", "'from'");
    		tokenNameToValue.put("KEYWORD_6", "'system'");
    		tokenNameToValue.put("KEYWORD_7", "'sandbox'");
    		tokenNameToValue.put("KEYWORD_8", "'instance'");
     	}
     	
        public void setGrammarAccess(SandboxGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleSandbox"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:71:1: entryRuleSandbox : ruleSandbox EOF ;
    public final void entryRuleSandbox() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:72:1: ( ruleSandbox EOF )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:73:1: ruleSandbox EOF
            {
             before(grammarAccess.getSandboxRule()); 
            pushFollow(FOLLOW_ruleSandbox_in_entryRuleSandbox54);
            ruleSandbox();

            state._fsp--;

             after(grammarAccess.getSandboxRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSandbox61); 

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
    // $ANTLR end "entryRuleSandbox"


    // $ANTLR start "ruleSandbox"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:80:1: ruleSandbox : ( ( rule__Sandbox__Group__0 ) ) ;
    public final void ruleSandbox() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:84:5: ( ( ( rule__Sandbox__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:85:1: ( ( rule__Sandbox__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:85:1: ( ( rule__Sandbox__Group__0 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:86:1: ( rule__Sandbox__Group__0 )
            {
             before(grammarAccess.getSandboxAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:87:1: ( rule__Sandbox__Group__0 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:87:2: rule__Sandbox__Group__0
            {
            pushFollow(FOLLOW_rule__Sandbox__Group__0_in_ruleSandbox91);
            rule__Sandbox__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSandboxAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSandbox"


    // $ANTLR start "entryRuleSystemConfiguration"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:99:1: entryRuleSystemConfiguration : ruleSystemConfiguration EOF ;
    public final void entryRuleSystemConfiguration() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:100:1: ( ruleSystemConfiguration EOF )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:101:1: ruleSystemConfiguration EOF
            {
             before(grammarAccess.getSystemConfigurationRule()); 
            pushFollow(FOLLOW_ruleSystemConfiguration_in_entryRuleSystemConfiguration118);
            ruleSystemConfiguration();

            state._fsp--;

             after(grammarAccess.getSystemConfigurationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemConfiguration125); 

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
    // $ANTLR end "entryRuleSystemConfiguration"


    // $ANTLR start "ruleSystemConfiguration"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:108:1: ruleSystemConfiguration : ( ( rule__SystemConfiguration__Group__0 ) ) ;
    public final void ruleSystemConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:112:5: ( ( ( rule__SystemConfiguration__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:113:1: ( ( rule__SystemConfiguration__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:113:1: ( ( rule__SystemConfiguration__Group__0 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:114:1: ( rule__SystemConfiguration__Group__0 )
            {
             before(grammarAccess.getSystemConfigurationAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:115:1: ( rule__SystemConfiguration__Group__0 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:115:2: rule__SystemConfiguration__Group__0
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__Group__0_in_ruleSystemConfiguration155);
            rule__SystemConfiguration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSystemConfigurationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSystemConfiguration"


    // $ANTLR start "entryRuleSystemInstanceProxy"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:127:1: entryRuleSystemInstanceProxy : ruleSystemInstanceProxy EOF ;
    public final void entryRuleSystemInstanceProxy() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:128:1: ( ruleSystemInstanceProxy EOF )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:129:1: ruleSystemInstanceProxy EOF
            {
             before(grammarAccess.getSystemInstanceProxyRule()); 
            pushFollow(FOLLOW_ruleSystemInstanceProxy_in_entryRuleSystemInstanceProxy182);
            ruleSystemInstanceProxy();

            state._fsp--;

             after(grammarAccess.getSystemInstanceProxyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemInstanceProxy189); 

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
    // $ANTLR end "entryRuleSystemInstanceProxy"


    // $ANTLR start "ruleSystemInstanceProxy"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:136:1: ruleSystemInstanceProxy : ( ( rule__SystemInstanceProxy__Group__0 ) ) ;
    public final void ruleSystemInstanceProxy() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:140:5: ( ( ( rule__SystemInstanceProxy__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:141:1: ( ( rule__SystemInstanceProxy__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:141:1: ( ( rule__SystemInstanceProxy__Group__0 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:142:1: ( rule__SystemInstanceProxy__Group__0 )
            {
             before(grammarAccess.getSystemInstanceProxyAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:143:1: ( rule__SystemInstanceProxy__Group__0 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:143:2: rule__SystemInstanceProxy__Group__0
            {
            pushFollow(FOLLOW_rule__SystemInstanceProxy__Group__0_in_ruleSystemInstanceProxy219);
            rule__SystemInstanceProxy__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSystemInstanceProxyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSystemInstanceProxy"


    // $ANTLR start "entryRuleQIREF"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:155:1: entryRuleQIREF : ruleQIREF EOF ;
    public final void entryRuleQIREF() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:156:1: ( ruleQIREF EOF )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:157:1: ruleQIREF EOF
            {
             before(grammarAccess.getQIREFRule()); 
            pushFollow(FOLLOW_ruleQIREF_in_entryRuleQIREF246);
            ruleQIREF();

            state._fsp--;

             after(grammarAccess.getQIREFRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQIREF253); 

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
    // $ANTLR end "entryRuleQIREF"


    // $ANTLR start "ruleQIREF"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:164:1: ruleQIREF : ( ( rule__QIREF__Group__0 ) ) ;
    public final void ruleQIREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:168:5: ( ( ( rule__QIREF__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:169:1: ( ( rule__QIREF__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:169:1: ( ( rule__QIREF__Group__0 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:170:1: ( rule__QIREF__Group__0 )
            {
             before(grammarAccess.getQIREFAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:171:1: ( rule__QIREF__Group__0 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:171:2: rule__QIREF__Group__0
            {
            pushFollow(FOLLOW_rule__QIREF__Group__0_in_ruleQIREF283);
            rule__QIREF__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQIREFAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQIREF"


    // $ANTLR start "rule__Sandbox__Group__0"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:187:1: rule__Sandbox__Group__0 : rule__Sandbox__Group__0__Impl rule__Sandbox__Group__1 ;
    public final void rule__Sandbox__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:191:1: ( rule__Sandbox__Group__0__Impl rule__Sandbox__Group__1 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:192:2: rule__Sandbox__Group__0__Impl rule__Sandbox__Group__1
            {
            pushFollow(FOLLOW_rule__Sandbox__Group__0__Impl_in_rule__Sandbox__Group__0319);
            rule__Sandbox__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sandbox__Group__1_in_rule__Sandbox__Group__0322);
            rule__Sandbox__Group__1();

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
    // $ANTLR end "rule__Sandbox__Group__0"


    // $ANTLR start "rule__Sandbox__Group__0__Impl"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:199:1: rule__Sandbox__Group__0__Impl : ( KEYWORD_7 ) ;
    public final void rule__Sandbox__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:203:1: ( ( KEYWORD_7 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:204:1: ( KEYWORD_7 )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:204:1: ( KEYWORD_7 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:205:1: KEYWORD_7
            {
             before(grammarAccess.getSandboxAccess().getSandboxKeyword_0()); 
            match(input,KEYWORD_7,FOLLOW_KEYWORD_7_in_rule__Sandbox__Group__0__Impl350); 
             after(grammarAccess.getSandboxAccess().getSandboxKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sandbox__Group__0__Impl"


    // $ANTLR start "rule__Sandbox__Group__1"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:218:1: rule__Sandbox__Group__1 : rule__Sandbox__Group__1__Impl rule__Sandbox__Group__2 ;
    public final void rule__Sandbox__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:222:1: ( rule__Sandbox__Group__1__Impl rule__Sandbox__Group__2 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:223:2: rule__Sandbox__Group__1__Impl rule__Sandbox__Group__2
            {
            pushFollow(FOLLOW_rule__Sandbox__Group__1__Impl_in_rule__Sandbox__Group__1381);
            rule__Sandbox__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sandbox__Group__2_in_rule__Sandbox__Group__1384);
            rule__Sandbox__Group__2();

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
    // $ANTLR end "rule__Sandbox__Group__1"


    // $ANTLR start "rule__Sandbox__Group__1__Impl"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:230:1: rule__Sandbox__Group__1__Impl : ( ( rule__Sandbox__NameAssignment_1 ) ) ;
    public final void rule__Sandbox__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:234:1: ( ( ( rule__Sandbox__NameAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:235:1: ( ( rule__Sandbox__NameAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:235:1: ( ( rule__Sandbox__NameAssignment_1 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:236:1: ( rule__Sandbox__NameAssignment_1 )
            {
             before(grammarAccess.getSandboxAccess().getNameAssignment_1()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:237:1: ( rule__Sandbox__NameAssignment_1 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:237:2: rule__Sandbox__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Sandbox__NameAssignment_1_in_rule__Sandbox__Group__1__Impl411);
            rule__Sandbox__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSandboxAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sandbox__Group__1__Impl"


    // $ANTLR start "rule__Sandbox__Group__2"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:247:1: rule__Sandbox__Group__2 : rule__Sandbox__Group__2__Impl ;
    public final void rule__Sandbox__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:251:1: ( rule__Sandbox__Group__2__Impl )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:252:2: rule__Sandbox__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Sandbox__Group__2__Impl_in_rule__Sandbox__Group__2441);
            rule__Sandbox__Group__2__Impl();

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
    // $ANTLR end "rule__Sandbox__Group__2"


    // $ANTLR start "rule__Sandbox__Group__2__Impl"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:258:1: rule__Sandbox__Group__2__Impl : ( ( rule__Sandbox__SystemInstanceAssignment_2 ) ) ;
    public final void rule__Sandbox__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:262:1: ( ( ( rule__Sandbox__SystemInstanceAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:263:1: ( ( rule__Sandbox__SystemInstanceAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:263:1: ( ( rule__Sandbox__SystemInstanceAssignment_2 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:264:1: ( rule__Sandbox__SystemInstanceAssignment_2 )
            {
             before(grammarAccess.getSandboxAccess().getSystemInstanceAssignment_2()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:265:1: ( rule__Sandbox__SystemInstanceAssignment_2 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:265:2: rule__Sandbox__SystemInstanceAssignment_2
            {
            pushFollow(FOLLOW_rule__Sandbox__SystemInstanceAssignment_2_in_rule__Sandbox__Group__2__Impl468);
            rule__Sandbox__SystemInstanceAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSandboxAccess().getSystemInstanceAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sandbox__Group__2__Impl"


    // $ANTLR start "rule__SystemConfiguration__Group__0"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:281:1: rule__SystemConfiguration__Group__0 : rule__SystemConfiguration__Group__0__Impl rule__SystemConfiguration__Group__1 ;
    public final void rule__SystemConfiguration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:285:1: ( rule__SystemConfiguration__Group__0__Impl rule__SystemConfiguration__Group__1 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:286:2: rule__SystemConfiguration__Group__0__Impl rule__SystemConfiguration__Group__1
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__Group__0__Impl_in_rule__SystemConfiguration__Group__0504);
            rule__SystemConfiguration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemConfiguration__Group__1_in_rule__SystemConfiguration__Group__0507);
            rule__SystemConfiguration__Group__1();

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
    // $ANTLR end "rule__SystemConfiguration__Group__0"


    // $ANTLR start "rule__SystemConfiguration__Group__0__Impl"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:293:1: rule__SystemConfiguration__Group__0__Impl : ( KEYWORD_6 ) ;
    public final void rule__SystemConfiguration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:297:1: ( ( KEYWORD_6 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:298:1: ( KEYWORD_6 )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:298:1: ( KEYWORD_6 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:299:1: KEYWORD_6
            {
             before(grammarAccess.getSystemConfigurationAccess().getSystemKeyword_0()); 
            match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_rule__SystemConfiguration__Group__0__Impl535); 
             after(grammarAccess.getSystemConfigurationAccess().getSystemKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemConfiguration__Group__0__Impl"


    // $ANTLR start "rule__SystemConfiguration__Group__1"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:312:1: rule__SystemConfiguration__Group__1 : rule__SystemConfiguration__Group__1__Impl rule__SystemConfiguration__Group__2 ;
    public final void rule__SystemConfiguration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:316:1: ( rule__SystemConfiguration__Group__1__Impl rule__SystemConfiguration__Group__2 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:317:2: rule__SystemConfiguration__Group__1__Impl rule__SystemConfiguration__Group__2
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__Group__1__Impl_in_rule__SystemConfiguration__Group__1566);
            rule__SystemConfiguration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemConfiguration__Group__2_in_rule__SystemConfiguration__Group__1569);
            rule__SystemConfiguration__Group__2();

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
    // $ANTLR end "rule__SystemConfiguration__Group__1"


    // $ANTLR start "rule__SystemConfiguration__Group__1__Impl"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:324:1: rule__SystemConfiguration__Group__1__Impl : ( KEYWORD_8 ) ;
    public final void rule__SystemConfiguration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:328:1: ( ( KEYWORD_8 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:329:1: ( KEYWORD_8 )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:329:1: ( KEYWORD_8 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:330:1: KEYWORD_8
            {
             before(grammarAccess.getSystemConfigurationAccess().getInstanceKeyword_1()); 
            match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_rule__SystemConfiguration__Group__1__Impl597); 
             after(grammarAccess.getSystemConfigurationAccess().getInstanceKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemConfiguration__Group__1__Impl"


    // $ANTLR start "rule__SystemConfiguration__Group__2"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:343:1: rule__SystemConfiguration__Group__2 : rule__SystemConfiguration__Group__2__Impl rule__SystemConfiguration__Group__3 ;
    public final void rule__SystemConfiguration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:347:1: ( rule__SystemConfiguration__Group__2__Impl rule__SystemConfiguration__Group__3 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:348:2: rule__SystemConfiguration__Group__2__Impl rule__SystemConfiguration__Group__3
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__Group__2__Impl_in_rule__SystemConfiguration__Group__2628);
            rule__SystemConfiguration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemConfiguration__Group__3_in_rule__SystemConfiguration__Group__2631);
            rule__SystemConfiguration__Group__3();

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
    // $ANTLR end "rule__SystemConfiguration__Group__2"


    // $ANTLR start "rule__SystemConfiguration__Group__2__Impl"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:355:1: rule__SystemConfiguration__Group__2__Impl : ( ( rule__SystemConfiguration__NameAssignment_2 ) ) ;
    public final void rule__SystemConfiguration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:359:1: ( ( ( rule__SystemConfiguration__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:360:1: ( ( rule__SystemConfiguration__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:360:1: ( ( rule__SystemConfiguration__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:361:1: ( rule__SystemConfiguration__NameAssignment_2 )
            {
             before(grammarAccess.getSystemConfigurationAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:362:1: ( rule__SystemConfiguration__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:362:2: rule__SystemConfiguration__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__NameAssignment_2_in_rule__SystemConfiguration__Group__2__Impl658);
            rule__SystemConfiguration__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSystemConfigurationAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemConfiguration__Group__2__Impl"


    // $ANTLR start "rule__SystemConfiguration__Group__3"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:372:1: rule__SystemConfiguration__Group__3 : rule__SystemConfiguration__Group__3__Impl rule__SystemConfiguration__Group__4 ;
    public final void rule__SystemConfiguration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:376:1: ( rule__SystemConfiguration__Group__3__Impl rule__SystemConfiguration__Group__4 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:377:2: rule__SystemConfiguration__Group__3__Impl rule__SystemConfiguration__Group__4
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__Group__3__Impl_in_rule__SystemConfiguration__Group__3688);
            rule__SystemConfiguration__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemConfiguration__Group__4_in_rule__SystemConfiguration__Group__3691);
            rule__SystemConfiguration__Group__4();

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
    // $ANTLR end "rule__SystemConfiguration__Group__3"


    // $ANTLR start "rule__SystemConfiguration__Group__3__Impl"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:384:1: rule__SystemConfiguration__Group__3__Impl : ( KEYWORD_5 ) ;
    public final void rule__SystemConfiguration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:388:1: ( ( KEYWORD_5 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:389:1: ( KEYWORD_5 )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:389:1: ( KEYWORD_5 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:390:1: KEYWORD_5
            {
             before(grammarAccess.getSystemConfigurationAccess().getFromKeyword_3()); 
            match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_rule__SystemConfiguration__Group__3__Impl719); 
             after(grammarAccess.getSystemConfigurationAccess().getFromKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemConfiguration__Group__3__Impl"


    // $ANTLR start "rule__SystemConfiguration__Group__4"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:403:1: rule__SystemConfiguration__Group__4 : rule__SystemConfiguration__Group__4__Impl rule__SystemConfiguration__Group__5 ;
    public final void rule__SystemConfiguration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:407:1: ( rule__SystemConfiguration__Group__4__Impl rule__SystemConfiguration__Group__5 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:408:2: rule__SystemConfiguration__Group__4__Impl rule__SystemConfiguration__Group__5
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__Group__4__Impl_in_rule__SystemConfiguration__Group__4750);
            rule__SystemConfiguration__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemConfiguration__Group__5_in_rule__SystemConfiguration__Group__4753);
            rule__SystemConfiguration__Group__5();

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
    // $ANTLR end "rule__SystemConfiguration__Group__4"


    // $ANTLR start "rule__SystemConfiguration__Group__4__Impl"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:415:1: rule__SystemConfiguration__Group__4__Impl : ( ( rule__SystemConfiguration__SystemImplementationAssignment_4 ) ) ;
    public final void rule__SystemConfiguration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:419:1: ( ( ( rule__SystemConfiguration__SystemImplementationAssignment_4 ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:420:1: ( ( rule__SystemConfiguration__SystemImplementationAssignment_4 ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:420:1: ( ( rule__SystemConfiguration__SystemImplementationAssignment_4 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:421:1: ( rule__SystemConfiguration__SystemImplementationAssignment_4 )
            {
             before(grammarAccess.getSystemConfigurationAccess().getSystemImplementationAssignment_4()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:422:1: ( rule__SystemConfiguration__SystemImplementationAssignment_4 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:422:2: rule__SystemConfiguration__SystemImplementationAssignment_4
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__SystemImplementationAssignment_4_in_rule__SystemConfiguration__Group__4__Impl780);
            rule__SystemConfiguration__SystemImplementationAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getSystemConfigurationAccess().getSystemImplementationAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemConfiguration__Group__4__Impl"


    // $ANTLR start "rule__SystemConfiguration__Group__5"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:432:1: rule__SystemConfiguration__Group__5 : rule__SystemConfiguration__Group__5__Impl rule__SystemConfiguration__Group__6 ;
    public final void rule__SystemConfiguration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:436:1: ( rule__SystemConfiguration__Group__5__Impl rule__SystemConfiguration__Group__6 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:437:2: rule__SystemConfiguration__Group__5__Impl rule__SystemConfiguration__Group__6
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__Group__5__Impl_in_rule__SystemConfiguration__Group__5810);
            rule__SystemConfiguration__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemConfiguration__Group__6_in_rule__SystemConfiguration__Group__5813);
            rule__SystemConfiguration__Group__6();

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
    // $ANTLR end "rule__SystemConfiguration__Group__5"


    // $ANTLR start "rule__SystemConfiguration__Group__5__Impl"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:444:1: rule__SystemConfiguration__Group__5__Impl : ( ( rule__SystemConfiguration__SystemInstanceProxyAssignment_5 )? ) ;
    public final void rule__SystemConfiguration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:448:1: ( ( ( rule__SystemConfiguration__SystemInstanceProxyAssignment_5 )? ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:449:1: ( ( rule__SystemConfiguration__SystemInstanceProxyAssignment_5 )? )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:449:1: ( ( rule__SystemConfiguration__SystemInstanceProxyAssignment_5 )? )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:450:1: ( rule__SystemConfiguration__SystemInstanceProxyAssignment_5 )?
            {
             before(grammarAccess.getSystemConfigurationAccess().getSystemInstanceProxyAssignment_5()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:451:1: ( rule__SystemConfiguration__SystemInstanceProxyAssignment_5 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==KEYWORD_4) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:451:2: rule__SystemConfiguration__SystemInstanceProxyAssignment_5
                    {
                    pushFollow(FOLLOW_rule__SystemConfiguration__SystemInstanceProxyAssignment_5_in_rule__SystemConfiguration__Group__5__Impl840);
                    rule__SystemConfiguration__SystemInstanceProxyAssignment_5();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSystemConfigurationAccess().getSystemInstanceProxyAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemConfiguration__Group__5__Impl"


    // $ANTLR start "rule__SystemConfiguration__Group__6"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:461:1: rule__SystemConfiguration__Group__6 : rule__SystemConfiguration__Group__6__Impl ;
    public final void rule__SystemConfiguration__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:465:1: ( rule__SystemConfiguration__Group__6__Impl )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:466:2: rule__SystemConfiguration__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__Group__6__Impl_in_rule__SystemConfiguration__Group__6871);
            rule__SystemConfiguration__Group__6__Impl();

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
    // $ANTLR end "rule__SystemConfiguration__Group__6"


    // $ANTLR start "rule__SystemConfiguration__Group__6__Impl"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:472:1: rule__SystemConfiguration__Group__6__Impl : ( KEYWORD_2 ) ;
    public final void rule__SystemConfiguration__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:476:1: ( ( KEYWORD_2 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:477:1: ( KEYWORD_2 )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:477:1: ( KEYWORD_2 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:478:1: KEYWORD_2
            {
             before(grammarAccess.getSystemConfigurationAccess().getSemicolonKeyword_6()); 
            match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_rule__SystemConfiguration__Group__6__Impl899); 
             after(grammarAccess.getSystemConfigurationAccess().getSemicolonKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemConfiguration__Group__6__Impl"


    // $ANTLR start "rule__SystemInstanceProxy__Group__0"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:505:1: rule__SystemInstanceProxy__Group__0 : rule__SystemInstanceProxy__Group__0__Impl rule__SystemInstanceProxy__Group__1 ;
    public final void rule__SystemInstanceProxy__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:509:1: ( rule__SystemInstanceProxy__Group__0__Impl rule__SystemInstanceProxy__Group__1 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:510:2: rule__SystemInstanceProxy__Group__0__Impl rule__SystemInstanceProxy__Group__1
            {
            pushFollow(FOLLOW_rule__SystemInstanceProxy__Group__0__Impl_in_rule__SystemInstanceProxy__Group__0944);
            rule__SystemInstanceProxy__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstanceProxy__Group__1_in_rule__SystemInstanceProxy__Group__0947);
            rule__SystemInstanceProxy__Group__1();

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
    // $ANTLR end "rule__SystemInstanceProxy__Group__0"


    // $ANTLR start "rule__SystemInstanceProxy__Group__0__Impl"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:517:1: rule__SystemInstanceProxy__Group__0__Impl : ( KEYWORD_4 ) ;
    public final void rule__SystemInstanceProxy__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:521:1: ( ( KEYWORD_4 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:522:1: ( KEYWORD_4 )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:522:1: ( KEYWORD_4 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:523:1: KEYWORD_4
            {
             before(grammarAccess.getSystemInstanceProxyAccess().getToKeyword_0()); 
            match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_rule__SystemInstanceProxy__Group__0__Impl975); 
             after(grammarAccess.getSystemInstanceProxyAccess().getToKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstanceProxy__Group__0__Impl"


    // $ANTLR start "rule__SystemInstanceProxy__Group__1"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:536:1: rule__SystemInstanceProxy__Group__1 : rule__SystemInstanceProxy__Group__1__Impl ;
    public final void rule__SystemInstanceProxy__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:540:1: ( rule__SystemInstanceProxy__Group__1__Impl )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:541:2: rule__SystemInstanceProxy__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SystemInstanceProxy__Group__1__Impl_in_rule__SystemInstanceProxy__Group__11006);
            rule__SystemInstanceProxy__Group__1__Impl();

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
    // $ANTLR end "rule__SystemInstanceProxy__Group__1"


    // $ANTLR start "rule__SystemInstanceProxy__Group__1__Impl"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:547:1: rule__SystemInstanceProxy__Group__1__Impl : ( ( rule__SystemInstanceProxy__InstanceRefAssignment_1 ) ) ;
    public final void rule__SystemInstanceProxy__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:551:1: ( ( ( rule__SystemInstanceProxy__InstanceRefAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:552:1: ( ( rule__SystemInstanceProxy__InstanceRefAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:552:1: ( ( rule__SystemInstanceProxy__InstanceRefAssignment_1 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:553:1: ( rule__SystemInstanceProxy__InstanceRefAssignment_1 )
            {
             before(grammarAccess.getSystemInstanceProxyAccess().getInstanceRefAssignment_1()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:554:1: ( rule__SystemInstanceProxy__InstanceRefAssignment_1 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:554:2: rule__SystemInstanceProxy__InstanceRefAssignment_1
            {
            pushFollow(FOLLOW_rule__SystemInstanceProxy__InstanceRefAssignment_1_in_rule__SystemInstanceProxy__Group__1__Impl1033);
            rule__SystemInstanceProxy__InstanceRefAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSystemInstanceProxyAccess().getInstanceRefAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstanceProxy__Group__1__Impl"


    // $ANTLR start "rule__QIREF__Group__0"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:568:1: rule__QIREF__Group__0 : rule__QIREF__Group__0__Impl rule__QIREF__Group__1 ;
    public final void rule__QIREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:572:1: ( rule__QIREF__Group__0__Impl rule__QIREF__Group__1 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:573:2: rule__QIREF__Group__0__Impl rule__QIREF__Group__1
            {
            pushFollow(FOLLOW_rule__QIREF__Group__0__Impl_in_rule__QIREF__Group__01067);
            rule__QIREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QIREF__Group__1_in_rule__QIREF__Group__01070);
            rule__QIREF__Group__1();

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
    // $ANTLR end "rule__QIREF__Group__0"


    // $ANTLR start "rule__QIREF__Group__0__Impl"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:580:1: rule__QIREF__Group__0__Impl : ( ( rule__QIREF__Group_0__0 )* ) ;
    public final void rule__QIREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:584:1: ( ( ( rule__QIREF__Group_0__0 )* ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:585:1: ( ( rule__QIREF__Group_0__0 )* )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:585:1: ( ( rule__QIREF__Group_0__0 )* )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:586:1: ( rule__QIREF__Group_0__0 )*
            {
             before(grammarAccess.getQIREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:587:1: ( rule__QIREF__Group_0__0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1==KEYWORD_3) ) {
                        alt2=1;
                    }


                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:587:2: rule__QIREF__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__QIREF__Group_0__0_in_rule__QIREF__Group__0__Impl1097);
            	    rule__QIREF__Group_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getQIREFAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QIREF__Group__0__Impl"


    // $ANTLR start "rule__QIREF__Group__1"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:597:1: rule__QIREF__Group__1 : rule__QIREF__Group__1__Impl rule__QIREF__Group__2 ;
    public final void rule__QIREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:601:1: ( rule__QIREF__Group__1__Impl rule__QIREF__Group__2 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:602:2: rule__QIREF__Group__1__Impl rule__QIREF__Group__2
            {
            pushFollow(FOLLOW_rule__QIREF__Group__1__Impl_in_rule__QIREF__Group__11128);
            rule__QIREF__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QIREF__Group__2_in_rule__QIREF__Group__11131);
            rule__QIREF__Group__2();

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
    // $ANTLR end "rule__QIREF__Group__1"


    // $ANTLR start "rule__QIREF__Group__1__Impl"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:609:1: rule__QIREF__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__QIREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:613:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:614:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:614:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:615:1: RULE_ID
            {
             before(grammarAccess.getQIREFAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QIREF__Group__1__Impl1158); 
             after(grammarAccess.getQIREFAccess().getIDTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QIREF__Group__1__Impl"


    // $ANTLR start "rule__QIREF__Group__2"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:626:1: rule__QIREF__Group__2 : rule__QIREF__Group__2__Impl rule__QIREF__Group__3 ;
    public final void rule__QIREF__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:630:1: ( rule__QIREF__Group__2__Impl rule__QIREF__Group__3 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:631:2: rule__QIREF__Group__2__Impl rule__QIREF__Group__3
            {
            pushFollow(FOLLOW_rule__QIREF__Group__2__Impl_in_rule__QIREF__Group__21187);
            rule__QIREF__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QIREF__Group__3_in_rule__QIREF__Group__21190);
            rule__QIREF__Group__3();

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
    // $ANTLR end "rule__QIREF__Group__2"


    // $ANTLR start "rule__QIREF__Group__2__Impl"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:638:1: rule__QIREF__Group__2__Impl : ( KEYWORD_1 ) ;
    public final void rule__QIREF__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:642:1: ( ( KEYWORD_1 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:643:1: ( KEYWORD_1 )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:643:1: ( KEYWORD_1 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:644:1: KEYWORD_1
            {
             before(grammarAccess.getQIREFAccess().getFullStopKeyword_2()); 
            match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_rule__QIREF__Group__2__Impl1218); 
             after(grammarAccess.getQIREFAccess().getFullStopKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QIREF__Group__2__Impl"


    // $ANTLR start "rule__QIREF__Group__3"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:657:1: rule__QIREF__Group__3 : rule__QIREF__Group__3__Impl ;
    public final void rule__QIREF__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:661:1: ( rule__QIREF__Group__3__Impl )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:662:2: rule__QIREF__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__QIREF__Group__3__Impl_in_rule__QIREF__Group__31249);
            rule__QIREF__Group__3__Impl();

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
    // $ANTLR end "rule__QIREF__Group__3"


    // $ANTLR start "rule__QIREF__Group__3__Impl"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:668:1: rule__QIREF__Group__3__Impl : ( RULE_ID ) ;
    public final void rule__QIREF__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:672:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:673:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:673:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:674:1: RULE_ID
            {
             before(grammarAccess.getQIREFAccess().getIDTerminalRuleCall_3()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QIREF__Group__3__Impl1276); 
             after(grammarAccess.getQIREFAccess().getIDTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QIREF__Group__3__Impl"


    // $ANTLR start "rule__QIREF__Group_0__0"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:693:1: rule__QIREF__Group_0__0 : rule__QIREF__Group_0__0__Impl rule__QIREF__Group_0__1 ;
    public final void rule__QIREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:697:1: ( rule__QIREF__Group_0__0__Impl rule__QIREF__Group_0__1 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:698:2: rule__QIREF__Group_0__0__Impl rule__QIREF__Group_0__1
            {
            pushFollow(FOLLOW_rule__QIREF__Group_0__0__Impl_in_rule__QIREF__Group_0__01313);
            rule__QIREF__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QIREF__Group_0__1_in_rule__QIREF__Group_0__01316);
            rule__QIREF__Group_0__1();

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
    // $ANTLR end "rule__QIREF__Group_0__0"


    // $ANTLR start "rule__QIREF__Group_0__0__Impl"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:705:1: rule__QIREF__Group_0__0__Impl : ( RULE_ID ) ;
    public final void rule__QIREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:709:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:710:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:710:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:711:1: RULE_ID
            {
             before(grammarAccess.getQIREFAccess().getIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QIREF__Group_0__0__Impl1343); 
             after(grammarAccess.getQIREFAccess().getIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QIREF__Group_0__0__Impl"


    // $ANTLR start "rule__QIREF__Group_0__1"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:722:1: rule__QIREF__Group_0__1 : rule__QIREF__Group_0__1__Impl ;
    public final void rule__QIREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:726:1: ( rule__QIREF__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:727:2: rule__QIREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__QIREF__Group_0__1__Impl_in_rule__QIREF__Group_0__11372);
            rule__QIREF__Group_0__1__Impl();

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
    // $ANTLR end "rule__QIREF__Group_0__1"


    // $ANTLR start "rule__QIREF__Group_0__1__Impl"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:733:1: rule__QIREF__Group_0__1__Impl : ( KEYWORD_3 ) ;
    public final void rule__QIREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:737:1: ( ( KEYWORD_3 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:738:1: ( KEYWORD_3 )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:738:1: ( KEYWORD_3 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:739:1: KEYWORD_3
            {
             before(grammarAccess.getQIREFAccess().getColonColonKeyword_0_1()); 
            match(input,KEYWORD_3,FOLLOW_KEYWORD_3_in_rule__QIREF__Group_0__1__Impl1400); 
             after(grammarAccess.getQIREFAccess().getColonColonKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QIREF__Group_0__1__Impl"


    // $ANTLR start "rule__Sandbox__NameAssignment_1"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:759:1: rule__Sandbox__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Sandbox__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:763:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:764:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:764:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:765:1: RULE_ID
            {
             before(grammarAccess.getSandboxAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Sandbox__NameAssignment_11442); 
             after(grammarAccess.getSandboxAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sandbox__NameAssignment_1"


    // $ANTLR start "rule__Sandbox__SystemInstanceAssignment_2"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:774:1: rule__Sandbox__SystemInstanceAssignment_2 : ( ruleSystemConfiguration ) ;
    public final void rule__Sandbox__SystemInstanceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:778:1: ( ( ruleSystemConfiguration ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:779:1: ( ruleSystemConfiguration )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:779:1: ( ruleSystemConfiguration )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:780:1: ruleSystemConfiguration
            {
             before(grammarAccess.getSandboxAccess().getSystemInstanceSystemConfigurationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleSystemConfiguration_in_rule__Sandbox__SystemInstanceAssignment_21473);
            ruleSystemConfiguration();

            state._fsp--;

             after(grammarAccess.getSandboxAccess().getSystemInstanceSystemConfigurationParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sandbox__SystemInstanceAssignment_2"


    // $ANTLR start "rule__SystemConfiguration__NameAssignment_2"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:789:1: rule__SystemConfiguration__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SystemConfiguration__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:793:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:794:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:794:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:795:1: RULE_ID
            {
             before(grammarAccess.getSystemConfigurationAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SystemConfiguration__NameAssignment_21504); 
             after(grammarAccess.getSystemConfigurationAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemConfiguration__NameAssignment_2"


    // $ANTLR start "rule__SystemConfiguration__SystemImplementationAssignment_4"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:804:1: rule__SystemConfiguration__SystemImplementationAssignment_4 : ( ( ruleQIREF ) ) ;
    public final void rule__SystemConfiguration__SystemImplementationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:808:1: ( ( ( ruleQIREF ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:809:1: ( ( ruleQIREF ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:809:1: ( ( ruleQIREF ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:810:1: ( ruleQIREF )
            {
             before(grammarAccess.getSystemConfigurationAccess().getSystemImplementationEObjectCrossReference_4_0()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:811:1: ( ruleQIREF )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:812:1: ruleQIREF
            {
             before(grammarAccess.getSystemConfigurationAccess().getSystemImplementationEObjectQIREFParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_ruleQIREF_in_rule__SystemConfiguration__SystemImplementationAssignment_41539);
            ruleQIREF();

            state._fsp--;

             after(grammarAccess.getSystemConfigurationAccess().getSystemImplementationEObjectQIREFParserRuleCall_4_0_1()); 

            }

             after(grammarAccess.getSystemConfigurationAccess().getSystemImplementationEObjectCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemConfiguration__SystemImplementationAssignment_4"


    // $ANTLR start "rule__SystemConfiguration__SystemInstanceProxyAssignment_5"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:823:1: rule__SystemConfiguration__SystemInstanceProxyAssignment_5 : ( ruleSystemInstanceProxy ) ;
    public final void rule__SystemConfiguration__SystemInstanceProxyAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:827:1: ( ( ruleSystemInstanceProxy ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:828:1: ( ruleSystemInstanceProxy )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:828:1: ( ruleSystemInstanceProxy )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:829:1: ruleSystemInstanceProxy
            {
             before(grammarAccess.getSystemConfigurationAccess().getSystemInstanceProxySystemInstanceProxyParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleSystemInstanceProxy_in_rule__SystemConfiguration__SystemInstanceProxyAssignment_51574);
            ruleSystemInstanceProxy();

            state._fsp--;

             after(grammarAccess.getSystemConfigurationAccess().getSystemInstanceProxySystemInstanceProxyParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemConfiguration__SystemInstanceProxyAssignment_5"


    // $ANTLR start "rule__SystemInstanceProxy__InstanceRefAssignment_1"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:838:1: rule__SystemInstanceProxy__InstanceRefAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__SystemInstanceProxy__InstanceRefAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:842:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:843:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:843:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:844:1: ( RULE_ID )
            {
             before(grammarAccess.getSystemInstanceProxyAccess().getInstanceRefEObjectCrossReference_1_0()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:845:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:846:1: RULE_ID
            {
             before(grammarAccess.getSystemInstanceProxyAccess().getInstanceRefEObjectIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SystemInstanceProxy__InstanceRefAssignment_11609); 
             after(grammarAccess.getSystemInstanceProxyAccess().getInstanceRefEObjectIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getSystemInstanceProxyAccess().getInstanceRefEObjectCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstanceProxy__InstanceRefAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleSandbox_in_entryRuleSandbox54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSandbox61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sandbox__Group__0_in_ruleSandbox91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemConfiguration_in_entryRuleSystemConfiguration118 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemConfiguration125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__0_in_ruleSystemConfiguration155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemInstanceProxy_in_entryRuleSystemInstanceProxy182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemInstanceProxy189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstanceProxy__Group__0_in_ruleSystemInstanceProxy219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQIREF_in_entryRuleQIREF246 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQIREF253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QIREF__Group__0_in_ruleQIREF283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sandbox__Group__0__Impl_in_rule__Sandbox__Group__0319 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Sandbox__Group__1_in_rule__Sandbox__Group__0322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_7_in_rule__Sandbox__Group__0__Impl350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sandbox__Group__1__Impl_in_rule__Sandbox__Group__1381 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Sandbox__Group__2_in_rule__Sandbox__Group__1384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sandbox__NameAssignment_1_in_rule__Sandbox__Group__1__Impl411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sandbox__Group__2__Impl_in_rule__Sandbox__Group__2441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sandbox__SystemInstanceAssignment_2_in_rule__Sandbox__Group__2__Impl468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__0__Impl_in_rule__SystemConfiguration__Group__0504 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__1_in_rule__SystemConfiguration__Group__0507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_6_in_rule__SystemConfiguration__Group__0__Impl535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__1__Impl_in_rule__SystemConfiguration__Group__1566 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__2_in_rule__SystemConfiguration__Group__1569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_8_in_rule__SystemConfiguration__Group__1__Impl597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__2__Impl_in_rule__SystemConfiguration__Group__2628 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__3_in_rule__SystemConfiguration__Group__2631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__NameAssignment_2_in_rule__SystemConfiguration__Group__2__Impl658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__3__Impl_in_rule__SystemConfiguration__Group__3688 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__4_in_rule__SystemConfiguration__Group__3691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_5_in_rule__SystemConfiguration__Group__3__Impl719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__4__Impl_in_rule__SystemConfiguration__Group__4750 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__5_in_rule__SystemConfiguration__Group__4753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__SystemImplementationAssignment_4_in_rule__SystemConfiguration__Group__4__Impl780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__5__Impl_in_rule__SystemConfiguration__Group__5810 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__6_in_rule__SystemConfiguration__Group__5813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__SystemInstanceProxyAssignment_5_in_rule__SystemConfiguration__Group__5__Impl840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__6__Impl_in_rule__SystemConfiguration__Group__6871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_2_in_rule__SystemConfiguration__Group__6__Impl899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstanceProxy__Group__0__Impl_in_rule__SystemInstanceProxy__Group__0944 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__SystemInstanceProxy__Group__1_in_rule__SystemInstanceProxy__Group__0947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_4_in_rule__SystemInstanceProxy__Group__0__Impl975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstanceProxy__Group__1__Impl_in_rule__SystemInstanceProxy__Group__11006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstanceProxy__InstanceRefAssignment_1_in_rule__SystemInstanceProxy__Group__1__Impl1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QIREF__Group__0__Impl_in_rule__QIREF__Group__01067 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__QIREF__Group__1_in_rule__QIREF__Group__01070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QIREF__Group_0__0_in_rule__QIREF__Group__0__Impl1097 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__QIREF__Group__1__Impl_in_rule__QIREF__Group__11128 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__QIREF__Group__2_in_rule__QIREF__Group__11131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QIREF__Group__1__Impl1158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QIREF__Group__2__Impl_in_rule__QIREF__Group__21187 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__QIREF__Group__3_in_rule__QIREF__Group__21190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_1_in_rule__QIREF__Group__2__Impl1218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QIREF__Group__3__Impl_in_rule__QIREF__Group__31249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QIREF__Group__3__Impl1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QIREF__Group_0__0__Impl_in_rule__QIREF__Group_0__01313 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__QIREF__Group_0__1_in_rule__QIREF__Group_0__01316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QIREF__Group_0__0__Impl1343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QIREF__Group_0__1__Impl_in_rule__QIREF__Group_0__11372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_3_in_rule__QIREF__Group_0__1__Impl1400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Sandbox__NameAssignment_11442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemConfiguration_in_rule__Sandbox__SystemInstanceAssignment_21473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SystemConfiguration__NameAssignment_21504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQIREF_in_rule__SystemConfiguration__SystemImplementationAssignment_41539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemInstanceProxy_in_rule__SystemConfiguration__SystemInstanceProxyAssignment_51574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SystemInstanceProxy__InstanceRefAssignment_11609 = new BitSet(new long[]{0x0000000000000002L});

}