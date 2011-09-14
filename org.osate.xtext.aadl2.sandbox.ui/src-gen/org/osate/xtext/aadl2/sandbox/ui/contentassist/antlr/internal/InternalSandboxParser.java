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
    		tokenNameToValue.put("KEYWORD_2", "';'");
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:69:1: entryRuleSandbox : ruleSandbox EOF ;
    public final void entryRuleSandbox() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:70:1: ( ruleSandbox EOF )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:71:1: ruleSandbox EOF
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:78:1: ruleSandbox : ( ( rule__Sandbox__Group__0 ) ) ;
    public final void ruleSandbox() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:82:5: ( ( ( rule__Sandbox__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:83:1: ( ( rule__Sandbox__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:83:1: ( ( rule__Sandbox__Group__0 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:84:1: ( rule__Sandbox__Group__0 )
            {
             before(grammarAccess.getSandboxAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:85:1: ( rule__Sandbox__Group__0 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:85:2: rule__Sandbox__Group__0
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:97:1: entryRuleSystemConfiguration : ruleSystemConfiguration EOF ;
    public final void entryRuleSystemConfiguration() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:98:1: ( ruleSystemConfiguration EOF )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:99:1: ruleSystemConfiguration EOF
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:106:1: ruleSystemConfiguration : ( ( rule__SystemConfiguration__Group__0 ) ) ;
    public final void ruleSystemConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:110:5: ( ( ( rule__SystemConfiguration__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:111:1: ( ( rule__SystemConfiguration__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:111:1: ( ( rule__SystemConfiguration__Group__0 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:112:1: ( rule__SystemConfiguration__Group__0 )
            {
             before(grammarAccess.getSystemConfigurationAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:113:1: ( rule__SystemConfiguration__Group__0 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:113:2: rule__SystemConfiguration__Group__0
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:125:1: entryRuleSystemInstanceProxy : ruleSystemInstanceProxy EOF ;
    public final void entryRuleSystemInstanceProxy() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:126:1: ( ruleSystemInstanceProxy EOF )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:127:1: ruleSystemInstanceProxy EOF
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:134:1: ruleSystemInstanceProxy : ( ( rule__SystemInstanceProxy__Group__0 ) ) ;
    public final void ruleSystemInstanceProxy() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:138:5: ( ( ( rule__SystemInstanceProxy__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:139:1: ( ( rule__SystemInstanceProxy__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:139:1: ( ( rule__SystemInstanceProxy__Group__0 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:140:1: ( rule__SystemInstanceProxy__Group__0 )
            {
             before(grammarAccess.getSystemInstanceProxyAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:141:1: ( rule__SystemInstanceProxy__Group__0 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:141:2: rule__SystemInstanceProxy__Group__0
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


    // $ANTLR start "rule__Sandbox__Group__0"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:159:1: rule__Sandbox__Group__0 : rule__Sandbox__Group__0__Impl rule__Sandbox__Group__1 ;
    public final void rule__Sandbox__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:163:1: ( rule__Sandbox__Group__0__Impl rule__Sandbox__Group__1 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:164:2: rule__Sandbox__Group__0__Impl rule__Sandbox__Group__1
            {
            pushFollow(FOLLOW_rule__Sandbox__Group__0__Impl_in_rule__Sandbox__Group__0257);
            rule__Sandbox__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sandbox__Group__1_in_rule__Sandbox__Group__0260);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:171:1: rule__Sandbox__Group__0__Impl : ( KEYWORD_7 ) ;
    public final void rule__Sandbox__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:175:1: ( ( KEYWORD_7 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:176:1: ( KEYWORD_7 )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:176:1: ( KEYWORD_7 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:177:1: KEYWORD_7
            {
             before(grammarAccess.getSandboxAccess().getSandboxKeyword_0()); 
            match(input,KEYWORD_7,FOLLOW_KEYWORD_7_in_rule__Sandbox__Group__0__Impl288); 
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:190:1: rule__Sandbox__Group__1 : rule__Sandbox__Group__1__Impl rule__Sandbox__Group__2 ;
    public final void rule__Sandbox__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:194:1: ( rule__Sandbox__Group__1__Impl rule__Sandbox__Group__2 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:195:2: rule__Sandbox__Group__1__Impl rule__Sandbox__Group__2
            {
            pushFollow(FOLLOW_rule__Sandbox__Group__1__Impl_in_rule__Sandbox__Group__1319);
            rule__Sandbox__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sandbox__Group__2_in_rule__Sandbox__Group__1322);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:202:1: rule__Sandbox__Group__1__Impl : ( ( rule__Sandbox__NameAssignment_1 ) ) ;
    public final void rule__Sandbox__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:206:1: ( ( ( rule__Sandbox__NameAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:207:1: ( ( rule__Sandbox__NameAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:207:1: ( ( rule__Sandbox__NameAssignment_1 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:208:1: ( rule__Sandbox__NameAssignment_1 )
            {
             before(grammarAccess.getSandboxAccess().getNameAssignment_1()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:209:1: ( rule__Sandbox__NameAssignment_1 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:209:2: rule__Sandbox__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Sandbox__NameAssignment_1_in_rule__Sandbox__Group__1__Impl349);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:219:1: rule__Sandbox__Group__2 : rule__Sandbox__Group__2__Impl ;
    public final void rule__Sandbox__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:223:1: ( rule__Sandbox__Group__2__Impl )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:224:2: rule__Sandbox__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Sandbox__Group__2__Impl_in_rule__Sandbox__Group__2379);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:230:1: rule__Sandbox__Group__2__Impl : ( ( rule__Sandbox__SystemInstanceAssignment_2 ) ) ;
    public final void rule__Sandbox__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:234:1: ( ( ( rule__Sandbox__SystemInstanceAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:235:1: ( ( rule__Sandbox__SystemInstanceAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:235:1: ( ( rule__Sandbox__SystemInstanceAssignment_2 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:236:1: ( rule__Sandbox__SystemInstanceAssignment_2 )
            {
             before(grammarAccess.getSandboxAccess().getSystemInstanceAssignment_2()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:237:1: ( rule__Sandbox__SystemInstanceAssignment_2 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:237:2: rule__Sandbox__SystemInstanceAssignment_2
            {
            pushFollow(FOLLOW_rule__Sandbox__SystemInstanceAssignment_2_in_rule__Sandbox__Group__2__Impl406);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:253:1: rule__SystemConfiguration__Group__0 : rule__SystemConfiguration__Group__0__Impl rule__SystemConfiguration__Group__1 ;
    public final void rule__SystemConfiguration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:257:1: ( rule__SystemConfiguration__Group__0__Impl rule__SystemConfiguration__Group__1 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:258:2: rule__SystemConfiguration__Group__0__Impl rule__SystemConfiguration__Group__1
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__Group__0__Impl_in_rule__SystemConfiguration__Group__0442);
            rule__SystemConfiguration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemConfiguration__Group__1_in_rule__SystemConfiguration__Group__0445);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:265:1: rule__SystemConfiguration__Group__0__Impl : ( KEYWORD_6 ) ;
    public final void rule__SystemConfiguration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:269:1: ( ( KEYWORD_6 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:270:1: ( KEYWORD_6 )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:270:1: ( KEYWORD_6 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:271:1: KEYWORD_6
            {
             before(grammarAccess.getSystemConfigurationAccess().getSystemKeyword_0()); 
            match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_rule__SystemConfiguration__Group__0__Impl473); 
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:284:1: rule__SystemConfiguration__Group__1 : rule__SystemConfiguration__Group__1__Impl rule__SystemConfiguration__Group__2 ;
    public final void rule__SystemConfiguration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:288:1: ( rule__SystemConfiguration__Group__1__Impl rule__SystemConfiguration__Group__2 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:289:2: rule__SystemConfiguration__Group__1__Impl rule__SystemConfiguration__Group__2
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__Group__1__Impl_in_rule__SystemConfiguration__Group__1504);
            rule__SystemConfiguration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemConfiguration__Group__2_in_rule__SystemConfiguration__Group__1507);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:296:1: rule__SystemConfiguration__Group__1__Impl : ( KEYWORD_8 ) ;
    public final void rule__SystemConfiguration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:300:1: ( ( KEYWORD_8 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:301:1: ( KEYWORD_8 )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:301:1: ( KEYWORD_8 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:302:1: KEYWORD_8
            {
             before(grammarAccess.getSystemConfigurationAccess().getInstanceKeyword_1()); 
            match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_rule__SystemConfiguration__Group__1__Impl535); 
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:315:1: rule__SystemConfiguration__Group__2 : rule__SystemConfiguration__Group__2__Impl rule__SystemConfiguration__Group__3 ;
    public final void rule__SystemConfiguration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:319:1: ( rule__SystemConfiguration__Group__2__Impl rule__SystemConfiguration__Group__3 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:320:2: rule__SystemConfiguration__Group__2__Impl rule__SystemConfiguration__Group__3
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__Group__2__Impl_in_rule__SystemConfiguration__Group__2566);
            rule__SystemConfiguration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemConfiguration__Group__3_in_rule__SystemConfiguration__Group__2569);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:327:1: rule__SystemConfiguration__Group__2__Impl : ( ( rule__SystemConfiguration__NameAssignment_2 ) ) ;
    public final void rule__SystemConfiguration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:331:1: ( ( ( rule__SystemConfiguration__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:332:1: ( ( rule__SystemConfiguration__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:332:1: ( ( rule__SystemConfiguration__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:333:1: ( rule__SystemConfiguration__NameAssignment_2 )
            {
             before(grammarAccess.getSystemConfigurationAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:334:1: ( rule__SystemConfiguration__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:334:2: rule__SystemConfiguration__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__NameAssignment_2_in_rule__SystemConfiguration__Group__2__Impl596);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:344:1: rule__SystemConfiguration__Group__3 : rule__SystemConfiguration__Group__3__Impl rule__SystemConfiguration__Group__4 ;
    public final void rule__SystemConfiguration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:348:1: ( rule__SystemConfiguration__Group__3__Impl rule__SystemConfiguration__Group__4 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:349:2: rule__SystemConfiguration__Group__3__Impl rule__SystemConfiguration__Group__4
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__Group__3__Impl_in_rule__SystemConfiguration__Group__3626);
            rule__SystemConfiguration__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemConfiguration__Group__4_in_rule__SystemConfiguration__Group__3629);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:356:1: rule__SystemConfiguration__Group__3__Impl : ( KEYWORD_5 ) ;
    public final void rule__SystemConfiguration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:360:1: ( ( KEYWORD_5 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:361:1: ( KEYWORD_5 )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:361:1: ( KEYWORD_5 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:362:1: KEYWORD_5
            {
             before(grammarAccess.getSystemConfigurationAccess().getFromKeyword_3()); 
            match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_rule__SystemConfiguration__Group__3__Impl657); 
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:375:1: rule__SystemConfiguration__Group__4 : rule__SystemConfiguration__Group__4__Impl rule__SystemConfiguration__Group__5 ;
    public final void rule__SystemConfiguration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:379:1: ( rule__SystemConfiguration__Group__4__Impl rule__SystemConfiguration__Group__5 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:380:2: rule__SystemConfiguration__Group__4__Impl rule__SystemConfiguration__Group__5
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__Group__4__Impl_in_rule__SystemConfiguration__Group__4688);
            rule__SystemConfiguration__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemConfiguration__Group__5_in_rule__SystemConfiguration__Group__4691);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:387:1: rule__SystemConfiguration__Group__4__Impl : ( ( rule__SystemConfiguration__SystemImplementationAssignment_4 ) ) ;
    public final void rule__SystemConfiguration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:391:1: ( ( ( rule__SystemConfiguration__SystemImplementationAssignment_4 ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:392:1: ( ( rule__SystemConfiguration__SystemImplementationAssignment_4 ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:392:1: ( ( rule__SystemConfiguration__SystemImplementationAssignment_4 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:393:1: ( rule__SystemConfiguration__SystemImplementationAssignment_4 )
            {
             before(grammarAccess.getSystemConfigurationAccess().getSystemImplementationAssignment_4()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:394:1: ( rule__SystemConfiguration__SystemImplementationAssignment_4 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:394:2: rule__SystemConfiguration__SystemImplementationAssignment_4
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__SystemImplementationAssignment_4_in_rule__SystemConfiguration__Group__4__Impl718);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:404:1: rule__SystemConfiguration__Group__5 : rule__SystemConfiguration__Group__5__Impl rule__SystemConfiguration__Group__6 ;
    public final void rule__SystemConfiguration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:408:1: ( rule__SystemConfiguration__Group__5__Impl rule__SystemConfiguration__Group__6 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:409:2: rule__SystemConfiguration__Group__5__Impl rule__SystemConfiguration__Group__6
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__Group__5__Impl_in_rule__SystemConfiguration__Group__5748);
            rule__SystemConfiguration__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemConfiguration__Group__6_in_rule__SystemConfiguration__Group__5751);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:416:1: rule__SystemConfiguration__Group__5__Impl : ( ( rule__SystemConfiguration__SystemInstanceProxyAssignment_5 )? ) ;
    public final void rule__SystemConfiguration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:420:1: ( ( ( rule__SystemConfiguration__SystemInstanceProxyAssignment_5 )? ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:421:1: ( ( rule__SystemConfiguration__SystemInstanceProxyAssignment_5 )? )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:421:1: ( ( rule__SystemConfiguration__SystemInstanceProxyAssignment_5 )? )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:422:1: ( rule__SystemConfiguration__SystemInstanceProxyAssignment_5 )?
            {
             before(grammarAccess.getSystemConfigurationAccess().getSystemInstanceProxyAssignment_5()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:423:1: ( rule__SystemConfiguration__SystemInstanceProxyAssignment_5 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==KEYWORD_4) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:423:2: rule__SystemConfiguration__SystemInstanceProxyAssignment_5
                    {
                    pushFollow(FOLLOW_rule__SystemConfiguration__SystemInstanceProxyAssignment_5_in_rule__SystemConfiguration__Group__5__Impl778);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:433:1: rule__SystemConfiguration__Group__6 : rule__SystemConfiguration__Group__6__Impl ;
    public final void rule__SystemConfiguration__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:437:1: ( rule__SystemConfiguration__Group__6__Impl )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:438:2: rule__SystemConfiguration__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__Group__6__Impl_in_rule__SystemConfiguration__Group__6809);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:444:1: rule__SystemConfiguration__Group__6__Impl : ( KEYWORD_2 ) ;
    public final void rule__SystemConfiguration__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:448:1: ( ( KEYWORD_2 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:449:1: ( KEYWORD_2 )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:449:1: ( KEYWORD_2 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:450:1: KEYWORD_2
            {
             before(grammarAccess.getSystemConfigurationAccess().getSemicolonKeyword_6()); 
            match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_rule__SystemConfiguration__Group__6__Impl837); 
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:477:1: rule__SystemInstanceProxy__Group__0 : rule__SystemInstanceProxy__Group__0__Impl rule__SystemInstanceProxy__Group__1 ;
    public final void rule__SystemInstanceProxy__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:481:1: ( rule__SystemInstanceProxy__Group__0__Impl rule__SystemInstanceProxy__Group__1 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:482:2: rule__SystemInstanceProxy__Group__0__Impl rule__SystemInstanceProxy__Group__1
            {
            pushFollow(FOLLOW_rule__SystemInstanceProxy__Group__0__Impl_in_rule__SystemInstanceProxy__Group__0882);
            rule__SystemInstanceProxy__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstanceProxy__Group__1_in_rule__SystemInstanceProxy__Group__0885);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:489:1: rule__SystemInstanceProxy__Group__0__Impl : ( KEYWORD_4 ) ;
    public final void rule__SystemInstanceProxy__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:493:1: ( ( KEYWORD_4 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:494:1: ( KEYWORD_4 )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:494:1: ( KEYWORD_4 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:495:1: KEYWORD_4
            {
             before(grammarAccess.getSystemInstanceProxyAccess().getToKeyword_0()); 
            match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_rule__SystemInstanceProxy__Group__0__Impl913); 
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:508:1: rule__SystemInstanceProxy__Group__1 : rule__SystemInstanceProxy__Group__1__Impl ;
    public final void rule__SystemInstanceProxy__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:512:1: ( rule__SystemInstanceProxy__Group__1__Impl )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:513:2: rule__SystemInstanceProxy__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SystemInstanceProxy__Group__1__Impl_in_rule__SystemInstanceProxy__Group__1944);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:519:1: rule__SystemInstanceProxy__Group__1__Impl : ( ( rule__SystemInstanceProxy__InstanceRefAssignment_1 ) ) ;
    public final void rule__SystemInstanceProxy__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:523:1: ( ( ( rule__SystemInstanceProxy__InstanceRefAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:524:1: ( ( rule__SystemInstanceProxy__InstanceRefAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:524:1: ( ( rule__SystemInstanceProxy__InstanceRefAssignment_1 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:525:1: ( rule__SystemInstanceProxy__InstanceRefAssignment_1 )
            {
             before(grammarAccess.getSystemInstanceProxyAccess().getInstanceRefAssignment_1()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:526:1: ( rule__SystemInstanceProxy__InstanceRefAssignment_1 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:526:2: rule__SystemInstanceProxy__InstanceRefAssignment_1
            {
            pushFollow(FOLLOW_rule__SystemInstanceProxy__InstanceRefAssignment_1_in_rule__SystemInstanceProxy__Group__1__Impl971);
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


    // $ANTLR start "rule__Sandbox__NameAssignment_1"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:545:1: rule__Sandbox__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Sandbox__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:549:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:550:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:550:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:551:1: RULE_ID
            {
             before(grammarAccess.getSandboxAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Sandbox__NameAssignment_11014); 
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:560:1: rule__Sandbox__SystemInstanceAssignment_2 : ( ruleSystemConfiguration ) ;
    public final void rule__Sandbox__SystemInstanceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:564:1: ( ( ruleSystemConfiguration ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:565:1: ( ruleSystemConfiguration )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:565:1: ( ruleSystemConfiguration )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:566:1: ruleSystemConfiguration
            {
             before(grammarAccess.getSandboxAccess().getSystemInstanceSystemConfigurationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleSystemConfiguration_in_rule__Sandbox__SystemInstanceAssignment_21045);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:575:1: rule__SystemConfiguration__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SystemConfiguration__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:579:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:580:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:580:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:581:1: RULE_ID
            {
             before(grammarAccess.getSystemConfigurationAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SystemConfiguration__NameAssignment_21076); 
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:590:1: rule__SystemConfiguration__SystemImplementationAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__SystemConfiguration__SystemImplementationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:594:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:595:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:595:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:596:1: ( RULE_ID )
            {
             before(grammarAccess.getSystemConfigurationAccess().getSystemImplementationSystemImplementationCrossReference_4_0()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:597:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:598:1: RULE_ID
            {
             before(grammarAccess.getSystemConfigurationAccess().getSystemImplementationSystemImplementationIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SystemConfiguration__SystemImplementationAssignment_41111); 
             after(grammarAccess.getSystemConfigurationAccess().getSystemImplementationSystemImplementationIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getSystemConfigurationAccess().getSystemImplementationSystemImplementationCrossReference_4_0()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:609:1: rule__SystemConfiguration__SystemInstanceProxyAssignment_5 : ( ruleSystemInstanceProxy ) ;
    public final void rule__SystemConfiguration__SystemInstanceProxyAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:613:1: ( ( ruleSystemInstanceProxy ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:614:1: ( ruleSystemInstanceProxy )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:614:1: ( ruleSystemInstanceProxy )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:615:1: ruleSystemInstanceProxy
            {
             before(grammarAccess.getSystemConfigurationAccess().getSystemInstanceProxySystemInstanceProxyParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleSystemInstanceProxy_in_rule__SystemConfiguration__SystemInstanceProxyAssignment_51146);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:624:1: rule__SystemInstanceProxy__InstanceRefAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__SystemInstanceProxy__InstanceRefAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:628:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:629:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:629:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:630:1: ( RULE_ID )
            {
             before(grammarAccess.getSystemInstanceProxyAccess().getInstanceRefEObjectCrossReference_1_0()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:631:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:632:1: RULE_ID
            {
             before(grammarAccess.getSystemInstanceProxyAccess().getInstanceRefEObjectIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SystemInstanceProxy__InstanceRefAssignment_11181); 
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
    public static final BitSet FOLLOW_rule__Sandbox__Group__0__Impl_in_rule__Sandbox__Group__0257 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Sandbox__Group__1_in_rule__Sandbox__Group__0260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_7_in_rule__Sandbox__Group__0__Impl288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sandbox__Group__1__Impl_in_rule__Sandbox__Group__1319 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Sandbox__Group__2_in_rule__Sandbox__Group__1322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sandbox__NameAssignment_1_in_rule__Sandbox__Group__1__Impl349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sandbox__Group__2__Impl_in_rule__Sandbox__Group__2379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sandbox__SystemInstanceAssignment_2_in_rule__Sandbox__Group__2__Impl406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__0__Impl_in_rule__SystemConfiguration__Group__0442 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__1_in_rule__SystemConfiguration__Group__0445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_6_in_rule__SystemConfiguration__Group__0__Impl473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__1__Impl_in_rule__SystemConfiguration__Group__1504 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__2_in_rule__SystemConfiguration__Group__1507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_8_in_rule__SystemConfiguration__Group__1__Impl535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__2__Impl_in_rule__SystemConfiguration__Group__2566 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__3_in_rule__SystemConfiguration__Group__2569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__NameAssignment_2_in_rule__SystemConfiguration__Group__2__Impl596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__3__Impl_in_rule__SystemConfiguration__Group__3626 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__4_in_rule__SystemConfiguration__Group__3629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_5_in_rule__SystemConfiguration__Group__3__Impl657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__4__Impl_in_rule__SystemConfiguration__Group__4688 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__5_in_rule__SystemConfiguration__Group__4691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__SystemImplementationAssignment_4_in_rule__SystemConfiguration__Group__4__Impl718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__5__Impl_in_rule__SystemConfiguration__Group__5748 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__6_in_rule__SystemConfiguration__Group__5751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__SystemInstanceProxyAssignment_5_in_rule__SystemConfiguration__Group__5__Impl778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__6__Impl_in_rule__SystemConfiguration__Group__6809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_2_in_rule__SystemConfiguration__Group__6__Impl837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstanceProxy__Group__0__Impl_in_rule__SystemInstanceProxy__Group__0882 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__SystemInstanceProxy__Group__1_in_rule__SystemInstanceProxy__Group__0885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_4_in_rule__SystemInstanceProxy__Group__0__Impl913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstanceProxy__Group__1__Impl_in_rule__SystemInstanceProxy__Group__1944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstanceProxy__InstanceRefAssignment_1_in_rule__SystemInstanceProxy__Group__1__Impl971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Sandbox__NameAssignment_11014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemConfiguration_in_rule__Sandbox__SystemInstanceAssignment_21045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SystemConfiguration__NameAssignment_21076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SystemConfiguration__SystemImplementationAssignment_41111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemInstanceProxy_in_rule__SystemConfiguration__SystemInstanceProxyAssignment_51146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SystemInstanceProxy__InstanceRefAssignment_11181 = new BitSet(new long[]{0x0000000000000002L});

}