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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_6", "KEYWORD_5", "KEYWORD_4", "KEYWORD_3", "KEYWORD_2", "KEYWORD_1", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=10;
    public static final int RULE_STRING=12;
    public static final int RULE_ANY_OTHER=16;
    public static final int KEYWORD_6=4;
    public static final int KEYWORD_1=9;
    public static final int RULE_INT=11;
    public static final int KEYWORD_5=5;
    public static final int KEYWORD_4=6;
    public static final int KEYWORD_3=7;
    public static final int KEYWORD_2=8;
    public static final int RULE_WS=15;
    public static final int RULE_SL_COMMENT=14;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=13;

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
    		tokenNameToValue.put("KEYWORD_2", "'::'");
    		tokenNameToValue.put("KEYWORD_3", "'from'");
    		tokenNameToValue.put("KEYWORD_4", "'system'");
    		tokenNameToValue.put("KEYWORD_5", "'sandbox'");
    		tokenNameToValue.put("KEYWORD_6", "'instance'");
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


    // $ANTLR start "entryRuleQIREF"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:125:1: entryRuleQIREF : ruleQIREF EOF ;
    public final void entryRuleQIREF() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:126:1: ( ruleQIREF EOF )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:127:1: ruleQIREF EOF
            {
             before(grammarAccess.getQIREFRule()); 
            pushFollow(FOLLOW_ruleQIREF_in_entryRuleQIREF182);
            ruleQIREF();

            state._fsp--;

             after(grammarAccess.getQIREFRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQIREF189); 

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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:134:1: ruleQIREF : ( ( rule__QIREF__Group__0 ) ) ;
    public final void ruleQIREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:138:5: ( ( ( rule__QIREF__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:139:1: ( ( rule__QIREF__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:139:1: ( ( rule__QIREF__Group__0 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:140:1: ( rule__QIREF__Group__0 )
            {
             before(grammarAccess.getQIREFAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:141:1: ( rule__QIREF__Group__0 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:141:2: rule__QIREF__Group__0
            {
            pushFollow(FOLLOW_rule__QIREF__Group__0_in_ruleQIREF219);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:157:1: rule__Sandbox__Group__0 : rule__Sandbox__Group__0__Impl rule__Sandbox__Group__1 ;
    public final void rule__Sandbox__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:161:1: ( rule__Sandbox__Group__0__Impl rule__Sandbox__Group__1 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:162:2: rule__Sandbox__Group__0__Impl rule__Sandbox__Group__1
            {
            pushFollow(FOLLOW_rule__Sandbox__Group__0__Impl_in_rule__Sandbox__Group__0255);
            rule__Sandbox__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sandbox__Group__1_in_rule__Sandbox__Group__0258);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:169:1: rule__Sandbox__Group__0__Impl : ( KEYWORD_5 ) ;
    public final void rule__Sandbox__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:173:1: ( ( KEYWORD_5 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:174:1: ( KEYWORD_5 )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:174:1: ( KEYWORD_5 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:175:1: KEYWORD_5
            {
             before(grammarAccess.getSandboxAccess().getSandboxKeyword_0()); 
            match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_rule__Sandbox__Group__0__Impl286); 
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:188:1: rule__Sandbox__Group__1 : rule__Sandbox__Group__1__Impl rule__Sandbox__Group__2 ;
    public final void rule__Sandbox__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:192:1: ( rule__Sandbox__Group__1__Impl rule__Sandbox__Group__2 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:193:2: rule__Sandbox__Group__1__Impl rule__Sandbox__Group__2
            {
            pushFollow(FOLLOW_rule__Sandbox__Group__1__Impl_in_rule__Sandbox__Group__1317);
            rule__Sandbox__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sandbox__Group__2_in_rule__Sandbox__Group__1320);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:200:1: rule__Sandbox__Group__1__Impl : ( ( rule__Sandbox__NameAssignment_1 ) ) ;
    public final void rule__Sandbox__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:204:1: ( ( ( rule__Sandbox__NameAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:205:1: ( ( rule__Sandbox__NameAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:205:1: ( ( rule__Sandbox__NameAssignment_1 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:206:1: ( rule__Sandbox__NameAssignment_1 )
            {
             before(grammarAccess.getSandboxAccess().getNameAssignment_1()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:207:1: ( rule__Sandbox__NameAssignment_1 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:207:2: rule__Sandbox__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Sandbox__NameAssignment_1_in_rule__Sandbox__Group__1__Impl347);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:217:1: rule__Sandbox__Group__2 : rule__Sandbox__Group__2__Impl ;
    public final void rule__Sandbox__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:221:1: ( rule__Sandbox__Group__2__Impl )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:222:2: rule__Sandbox__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Sandbox__Group__2__Impl_in_rule__Sandbox__Group__2377);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:228:1: rule__Sandbox__Group__2__Impl : ( ( rule__Sandbox__SystemInstanceAssignment_2 ) ) ;
    public final void rule__Sandbox__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:232:1: ( ( ( rule__Sandbox__SystemInstanceAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:233:1: ( ( rule__Sandbox__SystemInstanceAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:233:1: ( ( rule__Sandbox__SystemInstanceAssignment_2 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:234:1: ( rule__Sandbox__SystemInstanceAssignment_2 )
            {
             before(grammarAccess.getSandboxAccess().getSystemInstanceAssignment_2()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:235:1: ( rule__Sandbox__SystemInstanceAssignment_2 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:235:2: rule__Sandbox__SystemInstanceAssignment_2
            {
            pushFollow(FOLLOW_rule__Sandbox__SystemInstanceAssignment_2_in_rule__Sandbox__Group__2__Impl404);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:251:1: rule__SystemConfiguration__Group__0 : rule__SystemConfiguration__Group__0__Impl rule__SystemConfiguration__Group__1 ;
    public final void rule__SystemConfiguration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:255:1: ( rule__SystemConfiguration__Group__0__Impl rule__SystemConfiguration__Group__1 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:256:2: rule__SystemConfiguration__Group__0__Impl rule__SystemConfiguration__Group__1
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__Group__0__Impl_in_rule__SystemConfiguration__Group__0440);
            rule__SystemConfiguration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemConfiguration__Group__1_in_rule__SystemConfiguration__Group__0443);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:263:1: rule__SystemConfiguration__Group__0__Impl : ( KEYWORD_4 ) ;
    public final void rule__SystemConfiguration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:267:1: ( ( KEYWORD_4 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:268:1: ( KEYWORD_4 )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:268:1: ( KEYWORD_4 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:269:1: KEYWORD_4
            {
             before(grammarAccess.getSystemConfigurationAccess().getSystemKeyword_0()); 
            match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_rule__SystemConfiguration__Group__0__Impl471); 
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:282:1: rule__SystemConfiguration__Group__1 : rule__SystemConfiguration__Group__1__Impl rule__SystemConfiguration__Group__2 ;
    public final void rule__SystemConfiguration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:286:1: ( rule__SystemConfiguration__Group__1__Impl rule__SystemConfiguration__Group__2 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:287:2: rule__SystemConfiguration__Group__1__Impl rule__SystemConfiguration__Group__2
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__Group__1__Impl_in_rule__SystemConfiguration__Group__1502);
            rule__SystemConfiguration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemConfiguration__Group__2_in_rule__SystemConfiguration__Group__1505);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:294:1: rule__SystemConfiguration__Group__1__Impl : ( KEYWORD_6 ) ;
    public final void rule__SystemConfiguration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:298:1: ( ( KEYWORD_6 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:299:1: ( KEYWORD_6 )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:299:1: ( KEYWORD_6 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:300:1: KEYWORD_6
            {
             before(grammarAccess.getSystemConfigurationAccess().getInstanceKeyword_1()); 
            match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_rule__SystemConfiguration__Group__1__Impl533); 
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:313:1: rule__SystemConfiguration__Group__2 : rule__SystemConfiguration__Group__2__Impl rule__SystemConfiguration__Group__3 ;
    public final void rule__SystemConfiguration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:317:1: ( rule__SystemConfiguration__Group__2__Impl rule__SystemConfiguration__Group__3 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:318:2: rule__SystemConfiguration__Group__2__Impl rule__SystemConfiguration__Group__3
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__Group__2__Impl_in_rule__SystemConfiguration__Group__2564);
            rule__SystemConfiguration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemConfiguration__Group__3_in_rule__SystemConfiguration__Group__2567);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:325:1: rule__SystemConfiguration__Group__2__Impl : ( ( rule__SystemConfiguration__NameAssignment_2 ) ) ;
    public final void rule__SystemConfiguration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:329:1: ( ( ( rule__SystemConfiguration__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:330:1: ( ( rule__SystemConfiguration__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:330:1: ( ( rule__SystemConfiguration__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:331:1: ( rule__SystemConfiguration__NameAssignment_2 )
            {
             before(grammarAccess.getSystemConfigurationAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:332:1: ( rule__SystemConfiguration__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:332:2: rule__SystemConfiguration__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__NameAssignment_2_in_rule__SystemConfiguration__Group__2__Impl594);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:342:1: rule__SystemConfiguration__Group__3 : rule__SystemConfiguration__Group__3__Impl rule__SystemConfiguration__Group__4 ;
    public final void rule__SystemConfiguration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:346:1: ( rule__SystemConfiguration__Group__3__Impl rule__SystemConfiguration__Group__4 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:347:2: rule__SystemConfiguration__Group__3__Impl rule__SystemConfiguration__Group__4
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__Group__3__Impl_in_rule__SystemConfiguration__Group__3624);
            rule__SystemConfiguration__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemConfiguration__Group__4_in_rule__SystemConfiguration__Group__3627);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:354:1: rule__SystemConfiguration__Group__3__Impl : ( KEYWORD_3 ) ;
    public final void rule__SystemConfiguration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:358:1: ( ( KEYWORD_3 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:359:1: ( KEYWORD_3 )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:359:1: ( KEYWORD_3 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:360:1: KEYWORD_3
            {
             before(grammarAccess.getSystemConfigurationAccess().getFromKeyword_3()); 
            match(input,KEYWORD_3,FOLLOW_KEYWORD_3_in_rule__SystemConfiguration__Group__3__Impl655); 
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:373:1: rule__SystemConfiguration__Group__4 : rule__SystemConfiguration__Group__4__Impl ;
    public final void rule__SystemConfiguration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:377:1: ( rule__SystemConfiguration__Group__4__Impl )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:378:2: rule__SystemConfiguration__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__Group__4__Impl_in_rule__SystemConfiguration__Group__4686);
            rule__SystemConfiguration__Group__4__Impl();

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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:384:1: rule__SystemConfiguration__Group__4__Impl : ( ( rule__SystemConfiguration__SystemImplementationAssignment_4 ) ) ;
    public final void rule__SystemConfiguration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:388:1: ( ( ( rule__SystemConfiguration__SystemImplementationAssignment_4 ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:389:1: ( ( rule__SystemConfiguration__SystemImplementationAssignment_4 ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:389:1: ( ( rule__SystemConfiguration__SystemImplementationAssignment_4 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:390:1: ( rule__SystemConfiguration__SystemImplementationAssignment_4 )
            {
             before(grammarAccess.getSystemConfigurationAccess().getSystemImplementationAssignment_4()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:391:1: ( rule__SystemConfiguration__SystemImplementationAssignment_4 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:391:2: rule__SystemConfiguration__SystemImplementationAssignment_4
            {
            pushFollow(FOLLOW_rule__SystemConfiguration__SystemImplementationAssignment_4_in_rule__SystemConfiguration__Group__4__Impl713);
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


    // $ANTLR start "rule__QIREF__Group__0"
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:411:1: rule__QIREF__Group__0 : rule__QIREF__Group__0__Impl rule__QIREF__Group__1 ;
    public final void rule__QIREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:415:1: ( rule__QIREF__Group__0__Impl rule__QIREF__Group__1 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:416:2: rule__QIREF__Group__0__Impl rule__QIREF__Group__1
            {
            pushFollow(FOLLOW_rule__QIREF__Group__0__Impl_in_rule__QIREF__Group__0753);
            rule__QIREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QIREF__Group__1_in_rule__QIREF__Group__0756);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:423:1: rule__QIREF__Group__0__Impl : ( ( rule__QIREF__Group_0__0 )* ) ;
    public final void rule__QIREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:427:1: ( ( ( rule__QIREF__Group_0__0 )* ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:428:1: ( ( rule__QIREF__Group_0__0 )* )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:428:1: ( ( rule__QIREF__Group_0__0 )* )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:429:1: ( rule__QIREF__Group_0__0 )*
            {
             before(grammarAccess.getQIREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:430:1: ( rule__QIREF__Group_0__0 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1==KEYWORD_2) ) {
                        alt1=1;
                    }


                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:430:2: rule__QIREF__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__QIREF__Group_0__0_in_rule__QIREF__Group__0__Impl783);
            	    rule__QIREF__Group_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:440:1: rule__QIREF__Group__1 : rule__QIREF__Group__1__Impl rule__QIREF__Group__2 ;
    public final void rule__QIREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:444:1: ( rule__QIREF__Group__1__Impl rule__QIREF__Group__2 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:445:2: rule__QIREF__Group__1__Impl rule__QIREF__Group__2
            {
            pushFollow(FOLLOW_rule__QIREF__Group__1__Impl_in_rule__QIREF__Group__1814);
            rule__QIREF__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QIREF__Group__2_in_rule__QIREF__Group__1817);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:452:1: rule__QIREF__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__QIREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:456:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:457:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:457:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:458:1: RULE_ID
            {
             before(grammarAccess.getQIREFAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QIREF__Group__1__Impl844); 
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:469:1: rule__QIREF__Group__2 : rule__QIREF__Group__2__Impl rule__QIREF__Group__3 ;
    public final void rule__QIREF__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:473:1: ( rule__QIREF__Group__2__Impl rule__QIREF__Group__3 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:474:2: rule__QIREF__Group__2__Impl rule__QIREF__Group__3
            {
            pushFollow(FOLLOW_rule__QIREF__Group__2__Impl_in_rule__QIREF__Group__2873);
            rule__QIREF__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QIREF__Group__3_in_rule__QIREF__Group__2876);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:481:1: rule__QIREF__Group__2__Impl : ( KEYWORD_1 ) ;
    public final void rule__QIREF__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:485:1: ( ( KEYWORD_1 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:486:1: ( KEYWORD_1 )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:486:1: ( KEYWORD_1 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:487:1: KEYWORD_1
            {
             before(grammarAccess.getQIREFAccess().getFullStopKeyword_2()); 
            match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_rule__QIREF__Group__2__Impl904); 
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:500:1: rule__QIREF__Group__3 : rule__QIREF__Group__3__Impl ;
    public final void rule__QIREF__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:504:1: ( rule__QIREF__Group__3__Impl )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:505:2: rule__QIREF__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__QIREF__Group__3__Impl_in_rule__QIREF__Group__3935);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:511:1: rule__QIREF__Group__3__Impl : ( RULE_ID ) ;
    public final void rule__QIREF__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:515:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:516:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:516:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:517:1: RULE_ID
            {
             before(grammarAccess.getQIREFAccess().getIDTerminalRuleCall_3()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QIREF__Group__3__Impl962); 
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:536:1: rule__QIREF__Group_0__0 : rule__QIREF__Group_0__0__Impl rule__QIREF__Group_0__1 ;
    public final void rule__QIREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:540:1: ( rule__QIREF__Group_0__0__Impl rule__QIREF__Group_0__1 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:541:2: rule__QIREF__Group_0__0__Impl rule__QIREF__Group_0__1
            {
            pushFollow(FOLLOW_rule__QIREF__Group_0__0__Impl_in_rule__QIREF__Group_0__0999);
            rule__QIREF__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QIREF__Group_0__1_in_rule__QIREF__Group_0__01002);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:548:1: rule__QIREF__Group_0__0__Impl : ( RULE_ID ) ;
    public final void rule__QIREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:552:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:553:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:553:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:554:1: RULE_ID
            {
             before(grammarAccess.getQIREFAccess().getIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QIREF__Group_0__0__Impl1029); 
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:565:1: rule__QIREF__Group_0__1 : rule__QIREF__Group_0__1__Impl ;
    public final void rule__QIREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:569:1: ( rule__QIREF__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:570:2: rule__QIREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__QIREF__Group_0__1__Impl_in_rule__QIREF__Group_0__11058);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:576:1: rule__QIREF__Group_0__1__Impl : ( KEYWORD_2 ) ;
    public final void rule__QIREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:580:1: ( ( KEYWORD_2 ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:581:1: ( KEYWORD_2 )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:581:1: ( KEYWORD_2 )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:582:1: KEYWORD_2
            {
             before(grammarAccess.getQIREFAccess().getColonColonKeyword_0_1()); 
            match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_rule__QIREF__Group_0__1__Impl1086); 
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:602:1: rule__Sandbox__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Sandbox__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:606:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:607:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:607:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:608:1: RULE_ID
            {
             before(grammarAccess.getSandboxAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Sandbox__NameAssignment_11128); 
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:617:1: rule__Sandbox__SystemInstanceAssignment_2 : ( ruleSystemConfiguration ) ;
    public final void rule__Sandbox__SystemInstanceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:621:1: ( ( ruleSystemConfiguration ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:622:1: ( ruleSystemConfiguration )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:622:1: ( ruleSystemConfiguration )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:623:1: ruleSystemConfiguration
            {
             before(grammarAccess.getSandboxAccess().getSystemInstanceSystemConfigurationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleSystemConfiguration_in_rule__Sandbox__SystemInstanceAssignment_21159);
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:632:1: rule__SystemConfiguration__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SystemConfiguration__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:636:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:637:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:637:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:638:1: RULE_ID
            {
             before(grammarAccess.getSystemConfigurationAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SystemConfiguration__NameAssignment_21190); 
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
    // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:647:1: rule__SystemConfiguration__SystemImplementationAssignment_4 : ( ( ruleQIREF ) ) ;
    public final void rule__SystemConfiguration__SystemImplementationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:651:1: ( ( ( ruleQIREF ) ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:652:1: ( ( ruleQIREF ) )
            {
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:652:1: ( ( ruleQIREF ) )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:653:1: ( ruleQIREF )
            {
             before(grammarAccess.getSystemConfigurationAccess().getSystemImplementationSystemImplementationCrossReference_4_0()); 
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:654:1: ( ruleQIREF )
            // ../org.osate.xtext.aadl2.sandbox.ui/src-gen/org/osate/xtext/aadl2/sandbox/ui/contentassist/antlr/internal/InternalSandboxParser.g:655:1: ruleQIREF
            {
             before(grammarAccess.getSystemConfigurationAccess().getSystemImplementationSystemImplementationQIREFParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_ruleQIREF_in_rule__SystemConfiguration__SystemImplementationAssignment_41225);
            ruleQIREF();

            state._fsp--;

             after(grammarAccess.getSystemConfigurationAccess().getSystemImplementationSystemImplementationQIREFParserRuleCall_4_0_1()); 

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

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleSandbox_in_entryRuleSandbox54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSandbox61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sandbox__Group__0_in_ruleSandbox91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemConfiguration_in_entryRuleSystemConfiguration118 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemConfiguration125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__0_in_ruleSystemConfiguration155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQIREF_in_entryRuleQIREF182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQIREF189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QIREF__Group__0_in_ruleQIREF219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sandbox__Group__0__Impl_in_rule__Sandbox__Group__0255 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__Sandbox__Group__1_in_rule__Sandbox__Group__0258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_5_in_rule__Sandbox__Group__0__Impl286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sandbox__Group__1__Impl_in_rule__Sandbox__Group__1317 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Sandbox__Group__2_in_rule__Sandbox__Group__1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sandbox__NameAssignment_1_in_rule__Sandbox__Group__1__Impl347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sandbox__Group__2__Impl_in_rule__Sandbox__Group__2377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sandbox__SystemInstanceAssignment_2_in_rule__Sandbox__Group__2__Impl404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__0__Impl_in_rule__SystemConfiguration__Group__0440 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__1_in_rule__SystemConfiguration__Group__0443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_4_in_rule__SystemConfiguration__Group__0__Impl471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__1__Impl_in_rule__SystemConfiguration__Group__1502 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__2_in_rule__SystemConfiguration__Group__1505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_6_in_rule__SystemConfiguration__Group__1__Impl533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__2__Impl_in_rule__SystemConfiguration__Group__2564 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__3_in_rule__SystemConfiguration__Group__2567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__NameAssignment_2_in_rule__SystemConfiguration__Group__2__Impl594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__3__Impl_in_rule__SystemConfiguration__Group__3624 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__4_in_rule__SystemConfiguration__Group__3627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_3_in_rule__SystemConfiguration__Group__3__Impl655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__Group__4__Impl_in_rule__SystemConfiguration__Group__4686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemConfiguration__SystemImplementationAssignment_4_in_rule__SystemConfiguration__Group__4__Impl713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QIREF__Group__0__Impl_in_rule__QIREF__Group__0753 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__QIREF__Group__1_in_rule__QIREF__Group__0756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QIREF__Group_0__0_in_rule__QIREF__Group__0__Impl783 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_rule__QIREF__Group__1__Impl_in_rule__QIREF__Group__1814 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__QIREF__Group__2_in_rule__QIREF__Group__1817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QIREF__Group__1__Impl844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QIREF__Group__2__Impl_in_rule__QIREF__Group__2873 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__QIREF__Group__3_in_rule__QIREF__Group__2876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_1_in_rule__QIREF__Group__2__Impl904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QIREF__Group__3__Impl_in_rule__QIREF__Group__3935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QIREF__Group__3__Impl962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QIREF__Group_0__0__Impl_in_rule__QIREF__Group_0__0999 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__QIREF__Group_0__1_in_rule__QIREF__Group_0__01002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QIREF__Group_0__0__Impl1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QIREF__Group_0__1__Impl_in_rule__QIREF__Group_0__11058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_2_in_rule__QIREF__Group_0__1__Impl1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Sandbox__NameAssignment_11128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemConfiguration_in_rule__Sandbox__SystemInstanceAssignment_21159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SystemConfiguration__NameAssignment_21190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQIREF_in_rule__SystemConfiguration__SystemImplementationAssignment_41225 = new BitSet(new long[]{0x0000000000000002L});

}