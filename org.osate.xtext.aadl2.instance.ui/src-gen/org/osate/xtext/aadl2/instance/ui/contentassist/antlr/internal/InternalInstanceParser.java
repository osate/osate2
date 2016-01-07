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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INTEGER_LIT", "RULE_ID", "RULE_SL_COMMENT", "RULE_WS", "'abstract'", "'bus'", "'data'", "'device'", "'memory'", "'process'", "'processor'", "'subprogram'", "'system'", "'threadgroup'", "'thread'", "'virtualprocessor'", "'eventport'", "'dataport'", "'eventdataport'", "'parameter'", "'busaccess'", "'dataaccess'", "'subprogramaccess'", "'subprogramgroupaccess'", "'featuregroup'", "'abstractfeature'", "'in'", "'out'", "'inout'", "'feature'", "'access'", "'port'", "'modetransition'", "'rootinstance'", "'of'", "'end'", "'instance'", "'['", "']'", "'mode'", "'transition'", "'src'", "'dst'", "'flowspec'", "'etef'", "'som'", "'connection'", "'context'", "'group'", "'virtual'", "'::'", "'.'", "'#'", "'initial'", "'complete'", "'bidirectional'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__10=10;
    public static final int T__54=54;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int RULE_INTEGER_LIT=4;
    public static final int T__21=21;
    public static final int RULE_SL_COMMENT=6;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=7;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

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


    // $ANTLR start "entryRuleFeatureInstance"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:116:1: entryRuleFeatureInstance : ruleFeatureInstance EOF ;
    public final void entryRuleFeatureInstance() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:117:1: ( ruleFeatureInstance EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:118:1: ruleFeatureInstance EOF
            {
             before(grammarAccess.getFeatureInstanceRule()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_entryRuleFeatureInstance181);
            ruleFeatureInstance();

            state._fsp--;

             after(grammarAccess.getFeatureInstanceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureInstance188); 

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
    // $ANTLR end "entryRuleFeatureInstance"


    // $ANTLR start "ruleFeatureInstance"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:125:1: ruleFeatureInstance : ( ( rule__FeatureInstance__Group__0 ) ) ;
    public final void ruleFeatureInstance() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:129:2: ( ( ( rule__FeatureInstance__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:130:1: ( ( rule__FeatureInstance__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:130:1: ( ( rule__FeatureInstance__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:131:1: ( rule__FeatureInstance__Group__0 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:132:1: ( rule__FeatureInstance__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:132:2: rule__FeatureInstance__Group__0
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__0_in_ruleFeatureInstance214);
            rule__FeatureInstance__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFeatureInstanceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFeatureInstance"


    // $ANTLR start "entryRuleModeInstance"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:144:1: entryRuleModeInstance : ruleModeInstance EOF ;
    public final void entryRuleModeInstance() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:145:1: ( ruleModeInstance EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:146:1: ruleModeInstance EOF
            {
             before(grammarAccess.getModeInstanceRule()); 
            pushFollow(FOLLOW_ruleModeInstance_in_entryRuleModeInstance241);
            ruleModeInstance();

            state._fsp--;

             after(grammarAccess.getModeInstanceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModeInstance248); 

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
    // $ANTLR end "entryRuleModeInstance"


    // $ANTLR start "ruleModeInstance"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:153:1: ruleModeInstance : ( ( rule__ModeInstance__Group__0 ) ) ;
    public final void ruleModeInstance() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:157:2: ( ( ( rule__ModeInstance__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:158:1: ( ( rule__ModeInstance__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:158:1: ( ( rule__ModeInstance__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:159:1: ( rule__ModeInstance__Group__0 )
            {
             before(grammarAccess.getModeInstanceAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:160:1: ( rule__ModeInstance__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:160:2: rule__ModeInstance__Group__0
            {
            pushFollow(FOLLOW_rule__ModeInstance__Group__0_in_ruleModeInstance274);
            rule__ModeInstance__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModeInstanceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModeInstance"


    // $ANTLR start "entryRuleModeTransitionInstance"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:172:1: entryRuleModeTransitionInstance : ruleModeTransitionInstance EOF ;
    public final void entryRuleModeTransitionInstance() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:173:1: ( ruleModeTransitionInstance EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:174:1: ruleModeTransitionInstance EOF
            {
             before(grammarAccess.getModeTransitionInstanceRule()); 
            pushFollow(FOLLOW_ruleModeTransitionInstance_in_entryRuleModeTransitionInstance301);
            ruleModeTransitionInstance();

            state._fsp--;

             after(grammarAccess.getModeTransitionInstanceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModeTransitionInstance308); 

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
    // $ANTLR end "entryRuleModeTransitionInstance"


    // $ANTLR start "ruleModeTransitionInstance"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:181:1: ruleModeTransitionInstance : ( ( rule__ModeTransitionInstance__Group__0 ) ) ;
    public final void ruleModeTransitionInstance() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:185:2: ( ( ( rule__ModeTransitionInstance__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:186:1: ( ( rule__ModeTransitionInstance__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:186:1: ( ( rule__ModeTransitionInstance__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:187:1: ( rule__ModeTransitionInstance__Group__0 )
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:188:1: ( rule__ModeTransitionInstance__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:188:2: rule__ModeTransitionInstance__Group__0
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__0_in_ruleModeTransitionInstance334);
            rule__ModeTransitionInstance__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModeTransitionInstanceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModeTransitionInstance"


    // $ANTLR start "entryRuleFlowSpecInstance"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:200:1: entryRuleFlowSpecInstance : ruleFlowSpecInstance EOF ;
    public final void entryRuleFlowSpecInstance() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:201:1: ( ruleFlowSpecInstance EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:202:1: ruleFlowSpecInstance EOF
            {
             before(grammarAccess.getFlowSpecInstanceRule()); 
            pushFollow(FOLLOW_ruleFlowSpecInstance_in_entryRuleFlowSpecInstance361);
            ruleFlowSpecInstance();

            state._fsp--;

             after(grammarAccess.getFlowSpecInstanceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSpecInstance368); 

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
    // $ANTLR end "entryRuleFlowSpecInstance"


    // $ANTLR start "ruleFlowSpecInstance"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:209:1: ruleFlowSpecInstance : ( ( rule__FlowSpecInstance__Group__0 ) ) ;
    public final void ruleFlowSpecInstance() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:213:2: ( ( ( rule__FlowSpecInstance__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:214:1: ( ( rule__FlowSpecInstance__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:214:1: ( ( rule__FlowSpecInstance__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:215:1: ( rule__FlowSpecInstance__Group__0 )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:216:1: ( rule__FlowSpecInstance__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:216:2: rule__FlowSpecInstance__Group__0
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__0_in_ruleFlowSpecInstance394);
            rule__FlowSpecInstance__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFlowSpecInstanceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFlowSpecInstance"


    // $ANTLR start "entryRuleEndToEndFlowInstance"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:228:1: entryRuleEndToEndFlowInstance : ruleEndToEndFlowInstance EOF ;
    public final void entryRuleEndToEndFlowInstance() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:229:1: ( ruleEndToEndFlowInstance EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:230:1: ruleEndToEndFlowInstance EOF
            {
             before(grammarAccess.getEndToEndFlowInstanceRule()); 
            pushFollow(FOLLOW_ruleEndToEndFlowInstance_in_entryRuleEndToEndFlowInstance421);
            ruleEndToEndFlowInstance();

            state._fsp--;

             after(grammarAccess.getEndToEndFlowInstanceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEndToEndFlowInstance428); 

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
    // $ANTLR end "entryRuleEndToEndFlowInstance"


    // $ANTLR start "ruleEndToEndFlowInstance"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:237:1: ruleEndToEndFlowInstance : ( ( rule__EndToEndFlowInstance__Group__0 ) ) ;
    public final void ruleEndToEndFlowInstance() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:241:2: ( ( ( rule__EndToEndFlowInstance__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:242:1: ( ( rule__EndToEndFlowInstance__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:242:1: ( ( rule__EndToEndFlowInstance__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:243:1: ( rule__EndToEndFlowInstance__Group__0 )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:244:1: ( rule__EndToEndFlowInstance__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:244:2: rule__EndToEndFlowInstance__Group__0
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__0_in_ruleEndToEndFlowInstance454);
            rule__EndToEndFlowInstance__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEndToEndFlowInstanceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEndToEndFlowInstance"


    // $ANTLR start "entryRuleSystemOperationMode"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:256:1: entryRuleSystemOperationMode : ruleSystemOperationMode EOF ;
    public final void entryRuleSystemOperationMode() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:257:1: ( ruleSystemOperationMode EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:258:1: ruleSystemOperationMode EOF
            {
             before(grammarAccess.getSystemOperationModeRule()); 
            pushFollow(FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode481);
            ruleSystemOperationMode();

            state._fsp--;

             after(grammarAccess.getSystemOperationModeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemOperationMode488); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:265:1: ruleSystemOperationMode : ( ( rule__SystemOperationMode__Group__0 ) ) ;
    public final void ruleSystemOperationMode() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:269:2: ( ( ( rule__SystemOperationMode__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:270:1: ( ( rule__SystemOperationMode__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:270:1: ( ( rule__SystemOperationMode__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:271:1: ( rule__SystemOperationMode__Group__0 )
            {
             before(grammarAccess.getSystemOperationModeAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:272:1: ( rule__SystemOperationMode__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:272:2: rule__SystemOperationMode__Group__0
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__Group__0_in_ruleSystemOperationMode514);
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


    // $ANTLR start "entryRuleConnectionInstance"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:284:1: entryRuleConnectionInstance : ruleConnectionInstance EOF ;
    public final void entryRuleConnectionInstance() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:285:1: ( ruleConnectionInstance EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:286:1: ruleConnectionInstance EOF
            {
             before(grammarAccess.getConnectionInstanceRule()); 
            pushFollow(FOLLOW_ruleConnectionInstance_in_entryRuleConnectionInstance541);
            ruleConnectionInstance();

            state._fsp--;

             after(grammarAccess.getConnectionInstanceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionInstance548); 

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
    // $ANTLR end "entryRuleConnectionInstance"


    // $ANTLR start "ruleConnectionInstance"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:293:1: ruleConnectionInstance : ( ( rule__ConnectionInstance__Group__0 ) ) ;
    public final void ruleConnectionInstance() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:297:2: ( ( ( rule__ConnectionInstance__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:298:1: ( ( rule__ConnectionInstance__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:298:1: ( ( rule__ConnectionInstance__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:299:1: ( rule__ConnectionInstance__Group__0 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:300:1: ( rule__ConnectionInstance__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:300:2: rule__ConnectionInstance__Group__0
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__0_in_ruleConnectionInstance574);
            rule__ConnectionInstance__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConnectionInstanceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConnectionInstance"


    // $ANTLR start "entryRuleConnectionReference"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:312:1: entryRuleConnectionReference : ruleConnectionReference EOF ;
    public final void entryRuleConnectionReference() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:313:1: ( ruleConnectionReference EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:314:1: ruleConnectionReference EOF
            {
             before(grammarAccess.getConnectionReferenceRule()); 
            pushFollow(FOLLOW_ruleConnectionReference_in_entryRuleConnectionReference601);
            ruleConnectionReference();

            state._fsp--;

             after(grammarAccess.getConnectionReferenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionReference608); 

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
    // $ANTLR end "entryRuleConnectionReference"


    // $ANTLR start "ruleConnectionReference"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:321:1: ruleConnectionReference : ( ( rule__ConnectionReference__Group__0 ) ) ;
    public final void ruleConnectionReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:325:2: ( ( ( rule__ConnectionReference__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:326:1: ( ( rule__ConnectionReference__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:326:1: ( ( rule__ConnectionReference__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:327:1: ( rule__ConnectionReference__Group__0 )
            {
             before(grammarAccess.getConnectionReferenceAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:328:1: ( rule__ConnectionReference__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:328:2: rule__ConnectionReference__Group__0
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__0_in_ruleConnectionReference634);
            rule__ConnectionReference__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConnectionReferenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConnectionReference"


    // $ANTLR start "entryRuleComponentCategory"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:340:1: entryRuleComponentCategory : ruleComponentCategory EOF ;
    public final void entryRuleComponentCategory() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:341:1: ( ruleComponentCategory EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:342:1: ruleComponentCategory EOF
            {
             before(grammarAccess.getComponentCategoryRule()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory661);
            ruleComponentCategory();

            state._fsp--;

             after(grammarAccess.getComponentCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentCategory668); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:349:1: ruleComponentCategory : ( ( rule__ComponentCategory__Alternatives ) ) ;
    public final void ruleComponentCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:353:2: ( ( ( rule__ComponentCategory__Alternatives ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:354:1: ( ( rule__ComponentCategory__Alternatives ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:354:1: ( ( rule__ComponentCategory__Alternatives ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:355:1: ( rule__ComponentCategory__Alternatives )
            {
             before(grammarAccess.getComponentCategoryAccess().getAlternatives()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:356:1: ( rule__ComponentCategory__Alternatives )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:356:2: rule__ComponentCategory__Alternatives
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Alternatives_in_ruleComponentCategory694);
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


    // $ANTLR start "entryRuleFeatureCategory"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:368:1: entryRuleFeatureCategory : ruleFeatureCategory EOF ;
    public final void entryRuleFeatureCategory() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:369:1: ( ruleFeatureCategory EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:370:1: ruleFeatureCategory EOF
            {
             before(grammarAccess.getFeatureCategoryRule()); 
            pushFollow(FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory721);
            ruleFeatureCategory();

            state._fsp--;

             after(grammarAccess.getFeatureCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCategory728); 

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
    // $ANTLR end "entryRuleFeatureCategory"


    // $ANTLR start "ruleFeatureCategory"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:377:1: ruleFeatureCategory : ( ( rule__FeatureCategory__Alternatives ) ) ;
    public final void ruleFeatureCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:381:2: ( ( ( rule__FeatureCategory__Alternatives ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:382:1: ( ( rule__FeatureCategory__Alternatives ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:382:1: ( ( rule__FeatureCategory__Alternatives ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:383:1: ( rule__FeatureCategory__Alternatives )
            {
             before(grammarAccess.getFeatureCategoryAccess().getAlternatives()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:384:1: ( rule__FeatureCategory__Alternatives )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:384:2: rule__FeatureCategory__Alternatives
            {
            pushFollow(FOLLOW_rule__FeatureCategory__Alternatives_in_ruleFeatureCategory754);
            rule__FeatureCategory__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFeatureCategoryAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFeatureCategory"


    // $ANTLR start "entryRuleDirectionType"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:396:1: entryRuleDirectionType : ruleDirectionType EOF ;
    public final void entryRuleDirectionType() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:397:1: ( ruleDirectionType EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:398:1: ruleDirectionType EOF
            {
             before(grammarAccess.getDirectionTypeRule()); 
            pushFollow(FOLLOW_ruleDirectionType_in_entryRuleDirectionType781);
            ruleDirectionType();

            state._fsp--;

             after(grammarAccess.getDirectionTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDirectionType788); 

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
    // $ANTLR end "entryRuleDirectionType"


    // $ANTLR start "ruleDirectionType"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:405:1: ruleDirectionType : ( ( rule__DirectionType__Alternatives ) ) ;
    public final void ruleDirectionType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:409:2: ( ( ( rule__DirectionType__Alternatives ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:410:1: ( ( rule__DirectionType__Alternatives ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:410:1: ( ( rule__DirectionType__Alternatives ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:411:1: ( rule__DirectionType__Alternatives )
            {
             before(grammarAccess.getDirectionTypeAccess().getAlternatives()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:412:1: ( rule__DirectionType__Alternatives )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:412:2: rule__DirectionType__Alternatives
            {
            pushFollow(FOLLOW_rule__DirectionType__Alternatives_in_ruleDirectionType814);
            rule__DirectionType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDirectionTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDirectionType"


    // $ANTLR start "entryRuleConnectionKind"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:424:1: entryRuleConnectionKind : ruleConnectionKind EOF ;
    public final void entryRuleConnectionKind() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:425:1: ( ruleConnectionKind EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:426:1: ruleConnectionKind EOF
            {
             before(grammarAccess.getConnectionKindRule()); 
            pushFollow(FOLLOW_ruleConnectionKind_in_entryRuleConnectionKind841);
            ruleConnectionKind();

            state._fsp--;

             after(grammarAccess.getConnectionKindRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionKind848); 

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
    // $ANTLR end "entryRuleConnectionKind"


    // $ANTLR start "ruleConnectionKind"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:433:1: ruleConnectionKind : ( ( rule__ConnectionKind__Alternatives ) ) ;
    public final void ruleConnectionKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:437:2: ( ( ( rule__ConnectionKind__Alternatives ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:438:1: ( ( rule__ConnectionKind__Alternatives ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:438:1: ( ( rule__ConnectionKind__Alternatives ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:439:1: ( rule__ConnectionKind__Alternatives )
            {
             before(grammarAccess.getConnectionKindAccess().getAlternatives()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:440:1: ( rule__ConnectionKind__Alternatives )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:440:2: rule__ConnectionKind__Alternatives
            {
            pushFollow(FOLLOW_rule__ConnectionKind__Alternatives_in_ruleConnectionKind874);
            rule__ConnectionKind__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConnectionKindAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConnectionKind"


    // $ANTLR start "entryRuleFQCREF"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:452:1: entryRuleFQCREF : ruleFQCREF EOF ;
    public final void entryRuleFQCREF() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:453:1: ( ruleFQCREF EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:454:1: ruleFQCREF EOF
            {
             before(grammarAccess.getFQCREFRule()); 
            pushFollow(FOLLOW_ruleFQCREF_in_entryRuleFQCREF901);
            ruleFQCREF();

            state._fsp--;

             after(grammarAccess.getFQCREFRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQCREF908); 

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
    // $ANTLR end "entryRuleFQCREF"


    // $ANTLR start "ruleFQCREF"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:461:1: ruleFQCREF : ( ( rule__FQCREF__Group__0 ) ) ;
    public final void ruleFQCREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:465:2: ( ( ( rule__FQCREF__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:466:1: ( ( rule__FQCREF__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:466:1: ( ( rule__FQCREF__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:467:1: ( rule__FQCREF__Group__0 )
            {
             before(grammarAccess.getFQCREFAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:468:1: ( rule__FQCREF__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:468:2: rule__FQCREF__Group__0
            {
            pushFollow(FOLLOW_rule__FQCREF__Group__0_in_ruleFQCREF934);
            rule__FQCREF__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFQCREFAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFQCREF"


    // $ANTLR start "entryRuleINSTANCEREF"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:480:1: entryRuleINSTANCEREF : ruleINSTANCEREF EOF ;
    public final void entryRuleINSTANCEREF() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:481:1: ( ruleINSTANCEREF EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:482:1: ruleINSTANCEREF EOF
            {
             before(grammarAccess.getINSTANCEREFRule()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_entryRuleINSTANCEREF961);
            ruleINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getINSTANCEREFRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleINSTANCEREF968); 

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
    // $ANTLR end "entryRuleINSTANCEREF"


    // $ANTLR start "ruleINSTANCEREF"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:489:1: ruleINSTANCEREF : ( ( rule__INSTANCEREF__Group__0 ) ) ;
    public final void ruleINSTANCEREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:493:2: ( ( ( rule__INSTANCEREF__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:494:1: ( ( rule__INSTANCEREF__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:494:1: ( ( rule__INSTANCEREF__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:495:1: ( rule__INSTANCEREF__Group__0 )
            {
             before(grammarAccess.getINSTANCEREFAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:496:1: ( rule__INSTANCEREF__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:496:2: rule__INSTANCEREF__Group__0
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group__0_in_ruleINSTANCEREF994);
            rule__INSTANCEREF__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getINSTANCEREFAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleINSTANCEREF"


    // $ANTLR start "entryRuleSOMID"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:508:1: entryRuleSOMID : ruleSOMID EOF ;
    public final void entryRuleSOMID() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:509:1: ( ruleSOMID EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:510:1: ruleSOMID EOF
            {
             before(grammarAccess.getSOMIDRule()); 
            pushFollow(FOLLOW_ruleSOMID_in_entryRuleSOMID1021);
            ruleSOMID();

            state._fsp--;

             after(grammarAccess.getSOMIDRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSOMID1028); 

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
    // $ANTLR end "entryRuleSOMID"


    // $ANTLR start "ruleSOMID"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:517:1: ruleSOMID : ( ( rule__SOMID__Group__0 ) ) ;
    public final void ruleSOMID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:521:2: ( ( ( rule__SOMID__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:522:1: ( ( rule__SOMID__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:522:1: ( ( rule__SOMID__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:523:1: ( rule__SOMID__Group__0 )
            {
             before(grammarAccess.getSOMIDAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:524:1: ( rule__SOMID__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:524:2: rule__SOMID__Group__0
            {
            pushFollow(FOLLOW_rule__SOMID__Group__0_in_ruleSOMID1054);
            rule__SOMID__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSOMIDAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSOMID"


    // $ANTLR start "entryRuleINTVALUE"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:536:1: entryRuleINTVALUE : ruleINTVALUE EOF ;
    public final void entryRuleINTVALUE() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:537:1: ( ruleINTVALUE EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:538:1: ruleINTVALUE EOF
            {
             before(grammarAccess.getINTVALUERule()); 
            pushFollow(FOLLOW_ruleINTVALUE_in_entryRuleINTVALUE1081);
            ruleINTVALUE();

            state._fsp--;

             after(grammarAccess.getINTVALUERule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleINTVALUE1088); 

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
    // $ANTLR end "entryRuleINTVALUE"


    // $ANTLR start "ruleINTVALUE"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:545:1: ruleINTVALUE : ( RULE_INTEGER_LIT ) ;
    public final void ruleINTVALUE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:549:2: ( ( RULE_INTEGER_LIT ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:550:1: ( RULE_INTEGER_LIT )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:550:1: ( RULE_INTEGER_LIT )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:551:1: RULE_INTEGER_LIT
            {
             before(grammarAccess.getINTVALUEAccess().getINTEGER_LITTerminalRuleCall()); 
            match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_ruleINTVALUE1114); 
             after(grammarAccess.getINTVALUEAccess().getINTEGER_LITTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleINTVALUE"


    // $ANTLR start "rule__ComponentCategory__Alternatives"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:564:1: rule__ComponentCategory__Alternatives : ( ( 'abstract' ) | ( 'bus' ) | ( 'data' ) | ( 'device' ) | ( 'memory' ) | ( 'process' ) | ( 'processor' ) | ( 'subprogram' ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( 'system' ) | ( 'threadgroup' ) | ( 'thread' ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( 'virtualprocessor' ) );
    public final void rule__ComponentCategory__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:568:1: ( ( 'abstract' ) | ( 'bus' ) | ( 'data' ) | ( 'device' ) | ( 'memory' ) | ( 'process' ) | ( 'processor' ) | ( 'subprogram' ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( 'system' ) | ( 'threadgroup' ) | ( 'thread' ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( 'virtualprocessor' ) )
            int alt1=14;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:569:1: ( 'abstract' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:569:1: ( 'abstract' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:570:1: 'abstract'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
                    match(input,8,FOLLOW_8_in_rule__ComponentCategory__Alternatives1150); 
                     after(grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:577:6: ( 'bus' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:577:6: ( 'bus' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:578:1: 'bus'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
                    match(input,9,FOLLOW_9_in_rule__ComponentCategory__Alternatives1170); 
                     after(grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:585:6: ( 'data' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:585:6: ( 'data' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:586:1: 'data'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
                    match(input,10,FOLLOW_10_in_rule__ComponentCategory__Alternatives1190); 
                     after(grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:593:6: ( 'device' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:593:6: ( 'device' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:594:1: 'device'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
                    match(input,11,FOLLOW_11_in_rule__ComponentCategory__Alternatives1210); 
                     after(grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:601:6: ( 'memory' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:601:6: ( 'memory' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:602:1: 'memory'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
                    match(input,12,FOLLOW_12_in_rule__ComponentCategory__Alternatives1230); 
                     after(grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:609:6: ( 'process' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:609:6: ( 'process' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:610:1: 'process'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
                    match(input,13,FOLLOW_13_in_rule__ComponentCategory__Alternatives1250); 
                     after(grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:617:6: ( 'processor' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:617:6: ( 'processor' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:618:1: 'processor'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
                    match(input,14,FOLLOW_14_in_rule__ComponentCategory__Alternatives1270); 
                     after(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:625:6: ( 'subprogram' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:625:6: ( 'subprogram' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:626:1: 'subprogram'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
                    match(input,15,FOLLOW_15_in_rule__ComponentCategory__Alternatives1290); 
                     after(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:633:6: ( ( rule__ComponentCategory__Group_8__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:633:6: ( ( rule__ComponentCategory__Group_8__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:634:1: ( rule__ComponentCategory__Group_8__0 )
                    {
                     before(grammarAccess.getComponentCategoryAccess().getGroup_8()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:635:1: ( rule__ComponentCategory__Group_8__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:635:2: rule__ComponentCategory__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__ComponentCategory__Group_8__0_in_rule__ComponentCategory__Alternatives1309);
                    rule__ComponentCategory__Group_8__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentCategoryAccess().getGroup_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:639:6: ( 'system' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:639:6: ( 'system' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:640:1: 'system'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
                    match(input,16,FOLLOW_16_in_rule__ComponentCategory__Alternatives1328); 
                     after(grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:647:6: ( 'threadgroup' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:647:6: ( 'threadgroup' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:648:1: 'threadgroup'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getThreadgroupKeyword_10()); 
                    match(input,17,FOLLOW_17_in_rule__ComponentCategory__Alternatives1348); 
                     after(grammarAccess.getComponentCategoryAccess().getThreadgroupKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:655:6: ( 'thread' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:655:6: ( 'thread' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:656:1: 'thread'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
                    match(input,18,FOLLOW_18_in_rule__ComponentCategory__Alternatives1368); 
                     after(grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:663:6: ( ( rule__ComponentCategory__Group_12__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:663:6: ( ( rule__ComponentCategory__Group_12__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:664:1: ( rule__ComponentCategory__Group_12__0 )
                    {
                     before(grammarAccess.getComponentCategoryAccess().getGroup_12()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:665:1: ( rule__ComponentCategory__Group_12__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:665:2: rule__ComponentCategory__Group_12__0
                    {
                    pushFollow(FOLLOW_rule__ComponentCategory__Group_12__0_in_rule__ComponentCategory__Alternatives1387);
                    rule__ComponentCategory__Group_12__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentCategoryAccess().getGroup_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:669:6: ( 'virtualprocessor' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:669:6: ( 'virtualprocessor' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:670:1: 'virtualprocessor'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getVirtualprocessorKeyword_13()); 
                    match(input,19,FOLLOW_19_in_rule__ComponentCategory__Alternatives1406); 
                     after(grammarAccess.getComponentCategoryAccess().getVirtualprocessorKeyword_13()); 

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


    // $ANTLR start "rule__FeatureCategory__Alternatives"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:682:1: rule__FeatureCategory__Alternatives : ( ( 'eventport' ) | ( 'dataport' ) | ( 'eventdataport' ) | ( 'parameter' ) | ( 'busaccess' ) | ( 'dataaccess' ) | ( 'subprogramaccess' ) | ( 'subprogramgroupaccess' ) | ( 'featuregroup' ) | ( 'abstractfeature' ) );
    public final void rule__FeatureCategory__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:686:1: ( ( 'eventport' ) | ( 'dataport' ) | ( 'eventdataport' ) | ( 'parameter' ) | ( 'busaccess' ) | ( 'dataaccess' ) | ( 'subprogramaccess' ) | ( 'subprogramgroupaccess' ) | ( 'featuregroup' ) | ( 'abstractfeature' ) )
            int alt2=10;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt2=1;
                }
                break;
            case 21:
                {
                alt2=2;
                }
                break;
            case 22:
                {
                alt2=3;
                }
                break;
            case 23:
                {
                alt2=4;
                }
                break;
            case 24:
                {
                alt2=5;
                }
                break;
            case 25:
                {
                alt2=6;
                }
                break;
            case 26:
                {
                alt2=7;
                }
                break;
            case 27:
                {
                alt2=8;
                }
                break;
            case 28:
                {
                alt2=9;
                }
                break;
            case 29:
                {
                alt2=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:687:1: ( 'eventport' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:687:1: ( 'eventport' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:688:1: 'eventport'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getEventportKeyword_0()); 
                    match(input,20,FOLLOW_20_in_rule__FeatureCategory__Alternatives1441); 
                     after(grammarAccess.getFeatureCategoryAccess().getEventportKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:695:6: ( 'dataport' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:695:6: ( 'dataport' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:696:1: 'dataport'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getDataportKeyword_1()); 
                    match(input,21,FOLLOW_21_in_rule__FeatureCategory__Alternatives1461); 
                     after(grammarAccess.getFeatureCategoryAccess().getDataportKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:703:6: ( 'eventdataport' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:703:6: ( 'eventdataport' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:704:1: 'eventdataport'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getEventdataportKeyword_2()); 
                    match(input,22,FOLLOW_22_in_rule__FeatureCategory__Alternatives1481); 
                     after(grammarAccess.getFeatureCategoryAccess().getEventdataportKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:711:6: ( 'parameter' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:711:6: ( 'parameter' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:712:1: 'parameter'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); 
                    match(input,23,FOLLOW_23_in_rule__FeatureCategory__Alternatives1501); 
                     after(grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:719:6: ( 'busaccess' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:719:6: ( 'busaccess' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:720:1: 'busaccess'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getBusaccessKeyword_4()); 
                    match(input,24,FOLLOW_24_in_rule__FeatureCategory__Alternatives1521); 
                     after(grammarAccess.getFeatureCategoryAccess().getBusaccessKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:727:6: ( 'dataaccess' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:727:6: ( 'dataaccess' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:728:1: 'dataaccess'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getDataaccessKeyword_5()); 
                    match(input,25,FOLLOW_25_in_rule__FeatureCategory__Alternatives1541); 
                     after(grammarAccess.getFeatureCategoryAccess().getDataaccessKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:735:6: ( 'subprogramaccess' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:735:6: ( 'subprogramaccess' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:736:1: 'subprogramaccess'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getSubprogramaccessKeyword_6()); 
                    match(input,26,FOLLOW_26_in_rule__FeatureCategory__Alternatives1561); 
                     after(grammarAccess.getFeatureCategoryAccess().getSubprogramaccessKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:743:6: ( 'subprogramgroupaccess' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:743:6: ( 'subprogramgroupaccess' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:744:1: 'subprogramgroupaccess'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getSubprogramgroupaccessKeyword_7()); 
                    match(input,27,FOLLOW_27_in_rule__FeatureCategory__Alternatives1581); 
                     after(grammarAccess.getFeatureCategoryAccess().getSubprogramgroupaccessKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:751:6: ( 'featuregroup' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:751:6: ( 'featuregroup' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:752:1: 'featuregroup'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getFeaturegroupKeyword_8()); 
                    match(input,28,FOLLOW_28_in_rule__FeatureCategory__Alternatives1601); 
                     after(grammarAccess.getFeatureCategoryAccess().getFeaturegroupKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:759:6: ( 'abstractfeature' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:759:6: ( 'abstractfeature' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:760:1: 'abstractfeature'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getAbstractfeatureKeyword_9()); 
                    match(input,29,FOLLOW_29_in_rule__FeatureCategory__Alternatives1621); 
                     after(grammarAccess.getFeatureCategoryAccess().getAbstractfeatureKeyword_9()); 

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
    // $ANTLR end "rule__FeatureCategory__Alternatives"


    // $ANTLR start "rule__DirectionType__Alternatives"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:772:1: rule__DirectionType__Alternatives : ( ( 'in' ) | ( 'out' ) | ( 'inout' ) );
    public final void rule__DirectionType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:776:1: ( ( 'in' ) | ( 'out' ) | ( 'inout' ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt3=1;
                }
                break;
            case 31:
                {
                alt3=2;
                }
                break;
            case 32:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:777:1: ( 'in' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:777:1: ( 'in' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:778:1: 'in'
                    {
                     before(grammarAccess.getDirectionTypeAccess().getInKeyword_0()); 
                    match(input,30,FOLLOW_30_in_rule__DirectionType__Alternatives1656); 
                     after(grammarAccess.getDirectionTypeAccess().getInKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:785:6: ( 'out' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:785:6: ( 'out' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:786:1: 'out'
                    {
                     before(grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); 
                    match(input,31,FOLLOW_31_in_rule__DirectionType__Alternatives1676); 
                     after(grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:793:6: ( 'inout' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:793:6: ( 'inout' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:794:1: 'inout'
                    {
                     before(grammarAccess.getDirectionTypeAccess().getInoutKeyword_2()); 
                    match(input,32,FOLLOW_32_in_rule__DirectionType__Alternatives1696); 
                     after(grammarAccess.getDirectionTypeAccess().getInoutKeyword_2()); 

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
    // $ANTLR end "rule__DirectionType__Alternatives"


    // $ANTLR start "rule__ConnectionKind__Alternatives"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:806:1: rule__ConnectionKind__Alternatives : ( ( 'feature' ) | ( 'access' ) | ( 'parameter' ) | ( 'port' ) | ( 'modetransition' ) | ( 'featuregroup' ) );
    public final void rule__ConnectionKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:810:1: ( ( 'feature' ) | ( 'access' ) | ( 'parameter' ) | ( 'port' ) | ( 'modetransition' ) | ( 'featuregroup' ) )
            int alt4=6;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt4=1;
                }
                break;
            case 34:
                {
                alt4=2;
                }
                break;
            case 23:
                {
                alt4=3;
                }
                break;
            case 35:
                {
                alt4=4;
                }
                break;
            case 36:
                {
                alt4=5;
                }
                break;
            case 28:
                {
                alt4=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:811:1: ( 'feature' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:811:1: ( 'feature' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:812:1: 'feature'
                    {
                     before(grammarAccess.getConnectionKindAccess().getFeatureKeyword_0()); 
                    match(input,33,FOLLOW_33_in_rule__ConnectionKind__Alternatives1731); 
                     after(grammarAccess.getConnectionKindAccess().getFeatureKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:819:6: ( 'access' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:819:6: ( 'access' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:820:1: 'access'
                    {
                     before(grammarAccess.getConnectionKindAccess().getAccessKeyword_1()); 
                    match(input,34,FOLLOW_34_in_rule__ConnectionKind__Alternatives1751); 
                     after(grammarAccess.getConnectionKindAccess().getAccessKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:827:6: ( 'parameter' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:827:6: ( 'parameter' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:828:1: 'parameter'
                    {
                     before(grammarAccess.getConnectionKindAccess().getParameterKeyword_2()); 
                    match(input,23,FOLLOW_23_in_rule__ConnectionKind__Alternatives1771); 
                     after(grammarAccess.getConnectionKindAccess().getParameterKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:835:6: ( 'port' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:835:6: ( 'port' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:836:1: 'port'
                    {
                     before(grammarAccess.getConnectionKindAccess().getPortKeyword_3()); 
                    match(input,35,FOLLOW_35_in_rule__ConnectionKind__Alternatives1791); 
                     after(grammarAccess.getConnectionKindAccess().getPortKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:843:6: ( 'modetransition' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:843:6: ( 'modetransition' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:844:1: 'modetransition'
                    {
                     before(grammarAccess.getConnectionKindAccess().getModetransitionKeyword_4()); 
                    match(input,36,FOLLOW_36_in_rule__ConnectionKind__Alternatives1811); 
                     after(grammarAccess.getConnectionKindAccess().getModetransitionKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:851:6: ( 'featuregroup' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:851:6: ( 'featuregroup' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:852:1: 'featuregroup'
                    {
                     before(grammarAccess.getConnectionKindAccess().getFeaturegroupKeyword_5()); 
                    match(input,28,FOLLOW_28_in_rule__ConnectionKind__Alternatives1831); 
                     after(grammarAccess.getConnectionKindAccess().getFeaturegroupKeyword_5()); 

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
    // $ANTLR end "rule__ConnectionKind__Alternatives"


    // $ANTLR start "rule__SystemInstance__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:866:1: rule__SystemInstance__Group__0 : rule__SystemInstance__Group__0__Impl rule__SystemInstance__Group__1 ;
    public final void rule__SystemInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:870:1: ( rule__SystemInstance__Group__0__Impl rule__SystemInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:871:2: rule__SystemInstance__Group__0__Impl rule__SystemInstance__Group__1
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__0__Impl_in_rule__SystemInstance__Group__01863);
            rule__SystemInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__1_in_rule__SystemInstance__Group__01866);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:878:1: rule__SystemInstance__Group__0__Impl : ( 'rootinstance' ) ;
    public final void rule__SystemInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:882:1: ( ( 'rootinstance' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:883:1: ( 'rootinstance' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:883:1: ( 'rootinstance' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:884:1: 'rootinstance'
            {
             before(grammarAccess.getSystemInstanceAccess().getRootinstanceKeyword_0()); 
            match(input,37,FOLLOW_37_in_rule__SystemInstance__Group__0__Impl1894); 
             after(grammarAccess.getSystemInstanceAccess().getRootinstanceKeyword_0()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:897:1: rule__SystemInstance__Group__1 : rule__SystemInstance__Group__1__Impl rule__SystemInstance__Group__2 ;
    public final void rule__SystemInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:901:1: ( rule__SystemInstance__Group__1__Impl rule__SystemInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:902:2: rule__SystemInstance__Group__1__Impl rule__SystemInstance__Group__2
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__1__Impl_in_rule__SystemInstance__Group__11925);
            rule__SystemInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__2_in_rule__SystemInstance__Group__11928);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:909:1: rule__SystemInstance__Group__1__Impl : ( ( rule__SystemInstance__NameAssignment_1 ) ) ;
    public final void rule__SystemInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:913:1: ( ( ( rule__SystemInstance__NameAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:914:1: ( ( rule__SystemInstance__NameAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:914:1: ( ( rule__SystemInstance__NameAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:915:1: ( rule__SystemInstance__NameAssignment_1 )
            {
             before(grammarAccess.getSystemInstanceAccess().getNameAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:916:1: ( rule__SystemInstance__NameAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:916:2: rule__SystemInstance__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SystemInstance__NameAssignment_1_in_rule__SystemInstance__Group__1__Impl1955);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:926:1: rule__SystemInstance__Group__2 : rule__SystemInstance__Group__2__Impl rule__SystemInstance__Group__3 ;
    public final void rule__SystemInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:930:1: ( rule__SystemInstance__Group__2__Impl rule__SystemInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:931:2: rule__SystemInstance__Group__2__Impl rule__SystemInstance__Group__3
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__2__Impl_in_rule__SystemInstance__Group__21985);
            rule__SystemInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__3_in_rule__SystemInstance__Group__21988);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:938:1: rule__SystemInstance__Group__2__Impl : ( ( rule__SystemInstance__CategoryAssignment_2 ) ) ;
    public final void rule__SystemInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:942:1: ( ( ( rule__SystemInstance__CategoryAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:943:1: ( ( rule__SystemInstance__CategoryAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:943:1: ( ( rule__SystemInstance__CategoryAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:944:1: ( rule__SystemInstance__CategoryAssignment_2 )
            {
             before(grammarAccess.getSystemInstanceAccess().getCategoryAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:945:1: ( rule__SystemInstance__CategoryAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:945:2: rule__SystemInstance__CategoryAssignment_2
            {
            pushFollow(FOLLOW_rule__SystemInstance__CategoryAssignment_2_in_rule__SystemInstance__Group__2__Impl2015);
            rule__SystemInstance__CategoryAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSystemInstanceAccess().getCategoryAssignment_2()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:955:1: rule__SystemInstance__Group__3 : rule__SystemInstance__Group__3__Impl rule__SystemInstance__Group__4 ;
    public final void rule__SystemInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:959:1: ( rule__SystemInstance__Group__3__Impl rule__SystemInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:960:2: rule__SystemInstance__Group__3__Impl rule__SystemInstance__Group__4
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__3__Impl_in_rule__SystemInstance__Group__32045);
            rule__SystemInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__4_in_rule__SystemInstance__Group__32048);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:967:1: rule__SystemInstance__Group__3__Impl : ( 'of' ) ;
    public final void rule__SystemInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:971:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:972:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:972:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:973:1: 'of'
            {
             before(grammarAccess.getSystemInstanceAccess().getOfKeyword_3()); 
            match(input,38,FOLLOW_38_in_rule__SystemInstance__Group__3__Impl2076); 
             after(grammarAccess.getSystemInstanceAccess().getOfKeyword_3()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:986:1: rule__SystemInstance__Group__4 : rule__SystemInstance__Group__4__Impl rule__SystemInstance__Group__5 ;
    public final void rule__SystemInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:990:1: ( rule__SystemInstance__Group__4__Impl rule__SystemInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:991:2: rule__SystemInstance__Group__4__Impl rule__SystemInstance__Group__5
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__4__Impl_in_rule__SystemInstance__Group__42107);
            rule__SystemInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__5_in_rule__SystemInstance__Group__42110);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:998:1: rule__SystemInstance__Group__4__Impl : ( ( rule__SystemInstance__ComponentImplementationAssignment_4 ) ) ;
    public final void rule__SystemInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1002:1: ( ( ( rule__SystemInstance__ComponentImplementationAssignment_4 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1003:1: ( ( rule__SystemInstance__ComponentImplementationAssignment_4 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1003:1: ( ( rule__SystemInstance__ComponentImplementationAssignment_4 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1004:1: ( rule__SystemInstance__ComponentImplementationAssignment_4 )
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentImplementationAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1005:1: ( rule__SystemInstance__ComponentImplementationAssignment_4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1005:2: rule__SystemInstance__ComponentImplementationAssignment_4
            {
            pushFollow(FOLLOW_rule__SystemInstance__ComponentImplementationAssignment_4_in_rule__SystemInstance__Group__4__Impl2137);
            rule__SystemInstance__ComponentImplementationAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getSystemInstanceAccess().getComponentImplementationAssignment_4()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1015:1: rule__SystemInstance__Group__5 : rule__SystemInstance__Group__5__Impl rule__SystemInstance__Group__6 ;
    public final void rule__SystemInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1019:1: ( rule__SystemInstance__Group__5__Impl rule__SystemInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1020:2: rule__SystemInstance__Group__5__Impl rule__SystemInstance__Group__6
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__5__Impl_in_rule__SystemInstance__Group__52167);
            rule__SystemInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__6_in_rule__SystemInstance__Group__52170);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1027:1: rule__SystemInstance__Group__5__Impl : ( ( rule__SystemInstance__FeatureInstanceAssignment_5 )* ) ;
    public final void rule__SystemInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1031:1: ( ( ( rule__SystemInstance__FeatureInstanceAssignment_5 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1032:1: ( ( rule__SystemInstance__FeatureInstanceAssignment_5 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1032:1: ( ( rule__SystemInstance__FeatureInstanceAssignment_5 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1033:1: ( rule__SystemInstance__FeatureInstanceAssignment_5 )*
            {
             before(grammarAccess.getSystemInstanceAccess().getFeatureInstanceAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1034:1: ( rule__SystemInstance__FeatureInstanceAssignment_5 )*
            loop5:
            do {
                int alt5=2;
                switch ( input.LA(1) ) {
                case 23:
                    {
                    int LA5_2 = input.LA(2);

                    if ( (LA5_2==40) ) {
                        alt5=1;
                    }


                    }
                    break;
                case 28:
                    {
                    int LA5_3 = input.LA(2);

                    if ( (LA5_3==40) ) {
                        alt5=1;
                    }


                    }
                    break;
                case 20:
                case 21:
                case 22:
                case 24:
                case 25:
                case 26:
                case 27:
                case 29:
                    {
                    alt5=1;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1034:2: rule__SystemInstance__FeatureInstanceAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__SystemInstance__FeatureInstanceAssignment_5_in_rule__SystemInstance__Group__5__Impl2197);
            	    rule__SystemInstance__FeatureInstanceAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getSystemInstanceAccess().getFeatureInstanceAssignment_5()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1044:1: rule__SystemInstance__Group__6 : rule__SystemInstance__Group__6__Impl rule__SystemInstance__Group__7 ;
    public final void rule__SystemInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1048:1: ( rule__SystemInstance__Group__6__Impl rule__SystemInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1049:2: rule__SystemInstance__Group__6__Impl rule__SystemInstance__Group__7
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__6__Impl_in_rule__SystemInstance__Group__62228);
            rule__SystemInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__7_in_rule__SystemInstance__Group__62231);
            rule__SystemInstance__Group__7();

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1056:1: rule__SystemInstance__Group__6__Impl : ( ( rule__SystemInstance__ComponentInstanceAssignment_6 )* ) ;
    public final void rule__SystemInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1060:1: ( ( ( rule__SystemInstance__ComponentInstanceAssignment_6 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1061:1: ( ( rule__SystemInstance__ComponentInstanceAssignment_6 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1061:1: ( ( rule__SystemInstance__ComponentInstanceAssignment_6 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1062:1: ( rule__SystemInstance__ComponentInstanceAssignment_6 )*
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentInstanceAssignment_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1063:1: ( rule__SystemInstance__ComponentInstanceAssignment_6 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=8 && LA6_0<=19)||LA6_0==53) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1063:2: rule__SystemInstance__ComponentInstanceAssignment_6
            	    {
            	    pushFollow(FOLLOW_rule__SystemInstance__ComponentInstanceAssignment_6_in_rule__SystemInstance__Group__6__Impl2258);
            	    rule__SystemInstance__ComponentInstanceAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getSystemInstanceAccess().getComponentInstanceAssignment_6()); 

            }


            }

        }
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


    // $ANTLR start "rule__SystemInstance__Group__7"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1073:1: rule__SystemInstance__Group__7 : rule__SystemInstance__Group__7__Impl rule__SystemInstance__Group__8 ;
    public final void rule__SystemInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1077:1: ( rule__SystemInstance__Group__7__Impl rule__SystemInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1078:2: rule__SystemInstance__Group__7__Impl rule__SystemInstance__Group__8
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__7__Impl_in_rule__SystemInstance__Group__72289);
            rule__SystemInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__8_in_rule__SystemInstance__Group__72292);
            rule__SystemInstance__Group__8();

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
    // $ANTLR end "rule__SystemInstance__Group__7"


    // $ANTLR start "rule__SystemInstance__Group__7__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1085:1: rule__SystemInstance__Group__7__Impl : ( ( rule__SystemInstance__ModeInstanceAssignment_7 )* ) ;
    public final void rule__SystemInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1089:1: ( ( ( rule__SystemInstance__ModeInstanceAssignment_7 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1090:1: ( ( rule__SystemInstance__ModeInstanceAssignment_7 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1090:1: ( ( rule__SystemInstance__ModeInstanceAssignment_7 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1091:1: ( rule__SystemInstance__ModeInstanceAssignment_7 )*
            {
             before(grammarAccess.getSystemInstanceAccess().getModeInstanceAssignment_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1092:1: ( rule__SystemInstance__ModeInstanceAssignment_7 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==43) ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1==40) ) {
                        alt7=1;
                    }


                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1092:2: rule__SystemInstance__ModeInstanceAssignment_7
            	    {
            	    pushFollow(FOLLOW_rule__SystemInstance__ModeInstanceAssignment_7_in_rule__SystemInstance__Group__7__Impl2319);
            	    rule__SystemInstance__ModeInstanceAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getSystemInstanceAccess().getModeInstanceAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__Group__7__Impl"


    // $ANTLR start "rule__SystemInstance__Group__8"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1102:1: rule__SystemInstance__Group__8 : rule__SystemInstance__Group__8__Impl rule__SystemInstance__Group__9 ;
    public final void rule__SystemInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1106:1: ( rule__SystemInstance__Group__8__Impl rule__SystemInstance__Group__9 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1107:2: rule__SystemInstance__Group__8__Impl rule__SystemInstance__Group__9
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__8__Impl_in_rule__SystemInstance__Group__82350);
            rule__SystemInstance__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__9_in_rule__SystemInstance__Group__82353);
            rule__SystemInstance__Group__9();

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
    // $ANTLR end "rule__SystemInstance__Group__8"


    // $ANTLR start "rule__SystemInstance__Group__8__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1114:1: rule__SystemInstance__Group__8__Impl : ( ( rule__SystemInstance__ModeTransitionInstanceAssignment_8 )* ) ;
    public final void rule__SystemInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1118:1: ( ( ( rule__SystemInstance__ModeTransitionInstanceAssignment_8 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1119:1: ( ( rule__SystemInstance__ModeTransitionInstanceAssignment_8 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1119:1: ( ( rule__SystemInstance__ModeTransitionInstanceAssignment_8 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1120:1: ( rule__SystemInstance__ModeTransitionInstanceAssignment_8 )*
            {
             before(grammarAccess.getSystemInstanceAccess().getModeTransitionInstanceAssignment_8()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1121:1: ( rule__SystemInstance__ModeTransitionInstanceAssignment_8 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==43) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1121:2: rule__SystemInstance__ModeTransitionInstanceAssignment_8
            	    {
            	    pushFollow(FOLLOW_rule__SystemInstance__ModeTransitionInstanceAssignment_8_in_rule__SystemInstance__Group__8__Impl2380);
            	    rule__SystemInstance__ModeTransitionInstanceAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getSystemInstanceAccess().getModeTransitionInstanceAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__Group__8__Impl"


    // $ANTLR start "rule__SystemInstance__Group__9"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1131:1: rule__SystemInstance__Group__9 : rule__SystemInstance__Group__9__Impl rule__SystemInstance__Group__10 ;
    public final void rule__SystemInstance__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1135:1: ( rule__SystemInstance__Group__9__Impl rule__SystemInstance__Group__10 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1136:2: rule__SystemInstance__Group__9__Impl rule__SystemInstance__Group__10
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__9__Impl_in_rule__SystemInstance__Group__92411);
            rule__SystemInstance__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__10_in_rule__SystemInstance__Group__92414);
            rule__SystemInstance__Group__10();

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
    // $ANTLR end "rule__SystemInstance__Group__9"


    // $ANTLR start "rule__SystemInstance__Group__9__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1143:1: rule__SystemInstance__Group__9__Impl : ( ( rule__SystemInstance__FlowSpecificationAssignment_9 )* ) ;
    public final void rule__SystemInstance__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1147:1: ( ( ( rule__SystemInstance__FlowSpecificationAssignment_9 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1148:1: ( ( rule__SystemInstance__FlowSpecificationAssignment_9 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1148:1: ( ( rule__SystemInstance__FlowSpecificationAssignment_9 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1149:1: ( rule__SystemInstance__FlowSpecificationAssignment_9 )*
            {
             before(grammarAccess.getSystemInstanceAccess().getFlowSpecificationAssignment_9()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1150:1: ( rule__SystemInstance__FlowSpecificationAssignment_9 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==47) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1150:2: rule__SystemInstance__FlowSpecificationAssignment_9
            	    {
            	    pushFollow(FOLLOW_rule__SystemInstance__FlowSpecificationAssignment_9_in_rule__SystemInstance__Group__9__Impl2441);
            	    rule__SystemInstance__FlowSpecificationAssignment_9();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getSystemInstanceAccess().getFlowSpecificationAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__Group__9__Impl"


    // $ANTLR start "rule__SystemInstance__Group__10"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1160:1: rule__SystemInstance__Group__10 : rule__SystemInstance__Group__10__Impl rule__SystemInstance__Group__11 ;
    public final void rule__SystemInstance__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1164:1: ( rule__SystemInstance__Group__10__Impl rule__SystemInstance__Group__11 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1165:2: rule__SystemInstance__Group__10__Impl rule__SystemInstance__Group__11
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__10__Impl_in_rule__SystemInstance__Group__102472);
            rule__SystemInstance__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__11_in_rule__SystemInstance__Group__102475);
            rule__SystemInstance__Group__11();

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
    // $ANTLR end "rule__SystemInstance__Group__10"


    // $ANTLR start "rule__SystemInstance__Group__10__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1172:1: rule__SystemInstance__Group__10__Impl : ( ( rule__SystemInstance__EndToEndFlowAssignment_10 )* ) ;
    public final void rule__SystemInstance__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1176:1: ( ( ( rule__SystemInstance__EndToEndFlowAssignment_10 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1177:1: ( ( rule__SystemInstance__EndToEndFlowAssignment_10 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1177:1: ( ( rule__SystemInstance__EndToEndFlowAssignment_10 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1178:1: ( rule__SystemInstance__EndToEndFlowAssignment_10 )*
            {
             before(grammarAccess.getSystemInstanceAccess().getEndToEndFlowAssignment_10()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1179:1: ( rule__SystemInstance__EndToEndFlowAssignment_10 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==48) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1179:2: rule__SystemInstance__EndToEndFlowAssignment_10
            	    {
            	    pushFollow(FOLLOW_rule__SystemInstance__EndToEndFlowAssignment_10_in_rule__SystemInstance__Group__10__Impl2502);
            	    rule__SystemInstance__EndToEndFlowAssignment_10();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getSystemInstanceAccess().getEndToEndFlowAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__Group__10__Impl"


    // $ANTLR start "rule__SystemInstance__Group__11"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1189:1: rule__SystemInstance__Group__11 : rule__SystemInstance__Group__11__Impl rule__SystemInstance__Group__12 ;
    public final void rule__SystemInstance__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1193:1: ( rule__SystemInstance__Group__11__Impl rule__SystemInstance__Group__12 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1194:2: rule__SystemInstance__Group__11__Impl rule__SystemInstance__Group__12
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__11__Impl_in_rule__SystemInstance__Group__112533);
            rule__SystemInstance__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__12_in_rule__SystemInstance__Group__112536);
            rule__SystemInstance__Group__12();

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
    // $ANTLR end "rule__SystemInstance__Group__11"


    // $ANTLR start "rule__SystemInstance__Group__11__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1201:1: rule__SystemInstance__Group__11__Impl : ( ( rule__SystemInstance__ConnectionInstanceAssignment_11 )* ) ;
    public final void rule__SystemInstance__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1205:1: ( ( ( rule__SystemInstance__ConnectionInstanceAssignment_11 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1206:1: ( ( rule__SystemInstance__ConnectionInstanceAssignment_11 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1206:1: ( ( rule__SystemInstance__ConnectionInstanceAssignment_11 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1207:1: ( rule__SystemInstance__ConnectionInstanceAssignment_11 )*
            {
             before(grammarAccess.getSystemInstanceAccess().getConnectionInstanceAssignment_11()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1208:1: ( rule__SystemInstance__ConnectionInstanceAssignment_11 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==23||LA11_0==28||(LA11_0>=33 && LA11_0<=36)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1208:2: rule__SystemInstance__ConnectionInstanceAssignment_11
            	    {
            	    pushFollow(FOLLOW_rule__SystemInstance__ConnectionInstanceAssignment_11_in_rule__SystemInstance__Group__11__Impl2563);
            	    rule__SystemInstance__ConnectionInstanceAssignment_11();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getSystemInstanceAccess().getConnectionInstanceAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__Group__11__Impl"


    // $ANTLR start "rule__SystemInstance__Group__12"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1218:1: rule__SystemInstance__Group__12 : rule__SystemInstance__Group__12__Impl rule__SystemInstance__Group__13 ;
    public final void rule__SystemInstance__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1222:1: ( rule__SystemInstance__Group__12__Impl rule__SystemInstance__Group__13 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1223:2: rule__SystemInstance__Group__12__Impl rule__SystemInstance__Group__13
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__12__Impl_in_rule__SystemInstance__Group__122594);
            rule__SystemInstance__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__13_in_rule__SystemInstance__Group__122597);
            rule__SystemInstance__Group__13();

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
    // $ANTLR end "rule__SystemInstance__Group__12"


    // $ANTLR start "rule__SystemInstance__Group__12__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1230:1: rule__SystemInstance__Group__12__Impl : ( ( rule__SystemInstance__SystemOperationModeAssignment_12 )* ) ;
    public final void rule__SystemInstance__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1234:1: ( ( ( rule__SystemInstance__SystemOperationModeAssignment_12 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1235:1: ( ( rule__SystemInstance__SystemOperationModeAssignment_12 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1235:1: ( ( rule__SystemInstance__SystemOperationModeAssignment_12 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1236:1: ( rule__SystemInstance__SystemOperationModeAssignment_12 )*
            {
             before(grammarAccess.getSystemInstanceAccess().getSystemOperationModeAssignment_12()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1237:1: ( rule__SystemInstance__SystemOperationModeAssignment_12 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==49) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1237:2: rule__SystemInstance__SystemOperationModeAssignment_12
            	    {
            	    pushFollow(FOLLOW_rule__SystemInstance__SystemOperationModeAssignment_12_in_rule__SystemInstance__Group__12__Impl2624);
            	    rule__SystemInstance__SystemOperationModeAssignment_12();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getSystemInstanceAccess().getSystemOperationModeAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__Group__12__Impl"


    // $ANTLR start "rule__SystemInstance__Group__13"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1247:1: rule__SystemInstance__Group__13 : rule__SystemInstance__Group__13__Impl ;
    public final void rule__SystemInstance__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1251:1: ( rule__SystemInstance__Group__13__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1252:2: rule__SystemInstance__Group__13__Impl
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__13__Impl_in_rule__SystemInstance__Group__132655);
            rule__SystemInstance__Group__13__Impl();

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
    // $ANTLR end "rule__SystemInstance__Group__13"


    // $ANTLR start "rule__SystemInstance__Group__13__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1258:1: rule__SystemInstance__Group__13__Impl : ( 'end' ) ;
    public final void rule__SystemInstance__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1262:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1263:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1263:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1264:1: 'end'
            {
             before(grammarAccess.getSystemInstanceAccess().getEndKeyword_13()); 
            match(input,39,FOLLOW_39_in_rule__SystemInstance__Group__13__Impl2683); 
             after(grammarAccess.getSystemInstanceAccess().getEndKeyword_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__Group__13__Impl"


    // $ANTLR start "rule__ComponentInstance__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1305:1: rule__ComponentInstance__Group__0 : rule__ComponentInstance__Group__0__Impl rule__ComponentInstance__Group__1 ;
    public final void rule__ComponentInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1309:1: ( rule__ComponentInstance__Group__0__Impl rule__ComponentInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1310:2: rule__ComponentInstance__Group__0__Impl rule__ComponentInstance__Group__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__0__Impl_in_rule__ComponentInstance__Group__02742);
            rule__ComponentInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__1_in_rule__ComponentInstance__Group__02745);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1317:1: rule__ComponentInstance__Group__0__Impl : ( ( rule__ComponentInstance__CategoryAssignment_0 ) ) ;
    public final void rule__ComponentInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1321:1: ( ( ( rule__ComponentInstance__CategoryAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1322:1: ( ( rule__ComponentInstance__CategoryAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1322:1: ( ( rule__ComponentInstance__CategoryAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1323:1: ( rule__ComponentInstance__CategoryAssignment_0 )
            {
             before(grammarAccess.getComponentInstanceAccess().getCategoryAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1324:1: ( rule__ComponentInstance__CategoryAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1324:2: rule__ComponentInstance__CategoryAssignment_0
            {
            pushFollow(FOLLOW_rule__ComponentInstance__CategoryAssignment_0_in_rule__ComponentInstance__Group__0__Impl2772);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1334:1: rule__ComponentInstance__Group__1 : rule__ComponentInstance__Group__1__Impl rule__ComponentInstance__Group__2 ;
    public final void rule__ComponentInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1338:1: ( rule__ComponentInstance__Group__1__Impl rule__ComponentInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1339:2: rule__ComponentInstance__Group__1__Impl rule__ComponentInstance__Group__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__1__Impl_in_rule__ComponentInstance__Group__12802);
            rule__ComponentInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__2_in_rule__ComponentInstance__Group__12805);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1346:1: rule__ComponentInstance__Group__1__Impl : ( 'instance' ) ;
    public final void rule__ComponentInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1350:1: ( ( 'instance' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1351:1: ( 'instance' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1351:1: ( 'instance' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1352:1: 'instance'
            {
             before(grammarAccess.getComponentInstanceAccess().getInstanceKeyword_1()); 
            match(input,40,FOLLOW_40_in_rule__ComponentInstance__Group__1__Impl2833); 
             after(grammarAccess.getComponentInstanceAccess().getInstanceKeyword_1()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1365:1: rule__ComponentInstance__Group__2 : rule__ComponentInstance__Group__2__Impl rule__ComponentInstance__Group__3 ;
    public final void rule__ComponentInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1369:1: ( rule__ComponentInstance__Group__2__Impl rule__ComponentInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1370:2: rule__ComponentInstance__Group__2__Impl rule__ComponentInstance__Group__3
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__2__Impl_in_rule__ComponentInstance__Group__22864);
            rule__ComponentInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__3_in_rule__ComponentInstance__Group__22867);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1377:1: rule__ComponentInstance__Group__2__Impl : ( ( rule__ComponentInstance__NameAssignment_2 ) ) ;
    public final void rule__ComponentInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1381:1: ( ( ( rule__ComponentInstance__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1382:1: ( ( rule__ComponentInstance__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1382:1: ( ( rule__ComponentInstance__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1383:1: ( rule__ComponentInstance__NameAssignment_2 )
            {
             before(grammarAccess.getComponentInstanceAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1384:1: ( rule__ComponentInstance__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1384:2: rule__ComponentInstance__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__NameAssignment_2_in_rule__ComponentInstance__Group__2__Impl2894);
            rule__ComponentInstance__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getComponentInstanceAccess().getNameAssignment_2()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1394:1: rule__ComponentInstance__Group__3 : rule__ComponentInstance__Group__3__Impl rule__ComponentInstance__Group__4 ;
    public final void rule__ComponentInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1398:1: ( rule__ComponentInstance__Group__3__Impl rule__ComponentInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1399:2: rule__ComponentInstance__Group__3__Impl rule__ComponentInstance__Group__4
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__3__Impl_in_rule__ComponentInstance__Group__32924);
            rule__ComponentInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__4_in_rule__ComponentInstance__Group__32927);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1406:1: rule__ComponentInstance__Group__3__Impl : ( ( rule__ComponentInstance__Group_3__0 )? ) ;
    public final void rule__ComponentInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1410:1: ( ( ( rule__ComponentInstance__Group_3__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1411:1: ( ( rule__ComponentInstance__Group_3__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1411:1: ( ( rule__ComponentInstance__Group_3__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1412:1: ( rule__ComponentInstance__Group_3__0 )?
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1413:1: ( rule__ComponentInstance__Group_3__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==41) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1413:2: rule__ComponentInstance__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__Group_3__0_in_rule__ComponentInstance__Group__3__Impl2954);
                    rule__ComponentInstance__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getComponentInstanceAccess().getGroup_3()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1423:1: rule__ComponentInstance__Group__4 : rule__ComponentInstance__Group__4__Impl rule__ComponentInstance__Group__5 ;
    public final void rule__ComponentInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1427:1: ( rule__ComponentInstance__Group__4__Impl rule__ComponentInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1428:2: rule__ComponentInstance__Group__4__Impl rule__ComponentInstance__Group__5
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__4__Impl_in_rule__ComponentInstance__Group__42985);
            rule__ComponentInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__5_in_rule__ComponentInstance__Group__42988);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1435:1: rule__ComponentInstance__Group__4__Impl : ( 'of' ) ;
    public final void rule__ComponentInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1439:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1440:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1440:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1441:1: 'of'
            {
             before(grammarAccess.getComponentInstanceAccess().getOfKeyword_4()); 
            match(input,38,FOLLOW_38_in_rule__ComponentInstance__Group__4__Impl3016); 
             after(grammarAccess.getComponentInstanceAccess().getOfKeyword_4()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1454:1: rule__ComponentInstance__Group__5 : rule__ComponentInstance__Group__5__Impl rule__ComponentInstance__Group__6 ;
    public final void rule__ComponentInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1458:1: ( rule__ComponentInstance__Group__5__Impl rule__ComponentInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1459:2: rule__ComponentInstance__Group__5__Impl rule__ComponentInstance__Group__6
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__5__Impl_in_rule__ComponentInstance__Group__53047);
            rule__ComponentInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__6_in_rule__ComponentInstance__Group__53050);
            rule__ComponentInstance__Group__6();

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1466:1: rule__ComponentInstance__Group__5__Impl : ( ( rule__ComponentInstance__SubcomponentAssignment_5 ) ) ;
    public final void rule__ComponentInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1470:1: ( ( ( rule__ComponentInstance__SubcomponentAssignment_5 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1471:1: ( ( rule__ComponentInstance__SubcomponentAssignment_5 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1471:1: ( ( rule__ComponentInstance__SubcomponentAssignment_5 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1472:1: ( rule__ComponentInstance__SubcomponentAssignment_5 )
            {
             before(grammarAccess.getComponentInstanceAccess().getSubcomponentAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1473:1: ( rule__ComponentInstance__SubcomponentAssignment_5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1473:2: rule__ComponentInstance__SubcomponentAssignment_5
            {
            pushFollow(FOLLOW_rule__ComponentInstance__SubcomponentAssignment_5_in_rule__ComponentInstance__Group__5__Impl3077);
            rule__ComponentInstance__SubcomponentAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getComponentInstanceAccess().getSubcomponentAssignment_5()); 

            }


            }

        }
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


    // $ANTLR start "rule__ComponentInstance__Group__6"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1483:1: rule__ComponentInstance__Group__6 : rule__ComponentInstance__Group__6__Impl rule__ComponentInstance__Group__7 ;
    public final void rule__ComponentInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1487:1: ( rule__ComponentInstance__Group__6__Impl rule__ComponentInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1488:2: rule__ComponentInstance__Group__6__Impl rule__ComponentInstance__Group__7
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__6__Impl_in_rule__ComponentInstance__Group__63107);
            rule__ComponentInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__7_in_rule__ComponentInstance__Group__63110);
            rule__ComponentInstance__Group__7();

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
    // $ANTLR end "rule__ComponentInstance__Group__6"


    // $ANTLR start "rule__ComponentInstance__Group__6__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1495:1: rule__ComponentInstance__Group__6__Impl : ( ( rule__ComponentInstance__FeatureInstanceAssignment_6 )* ) ;
    public final void rule__ComponentInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1499:1: ( ( ( rule__ComponentInstance__FeatureInstanceAssignment_6 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1500:1: ( ( rule__ComponentInstance__FeatureInstanceAssignment_6 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1500:1: ( ( rule__ComponentInstance__FeatureInstanceAssignment_6 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1501:1: ( rule__ComponentInstance__FeatureInstanceAssignment_6 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getFeatureInstanceAssignment_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1502:1: ( rule__ComponentInstance__FeatureInstanceAssignment_6 )*
            loop14:
            do {
                int alt14=2;
                switch ( input.LA(1) ) {
                case 23:
                    {
                    int LA14_2 = input.LA(2);

                    if ( (LA14_2==40) ) {
                        alt14=1;
                    }


                    }
                    break;
                case 28:
                    {
                    int LA14_3 = input.LA(2);

                    if ( (LA14_3==40) ) {
                        alt14=1;
                    }


                    }
                    break;
                case 20:
                case 21:
                case 22:
                case 24:
                case 25:
                case 26:
                case 27:
                case 29:
                    {
                    alt14=1;
                    }
                    break;

                }

                switch (alt14) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1502:2: rule__ComponentInstance__FeatureInstanceAssignment_6
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__FeatureInstanceAssignment_6_in_rule__ComponentInstance__Group__6__Impl3137);
            	    rule__ComponentInstance__FeatureInstanceAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getComponentInstanceAccess().getFeatureInstanceAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group__6__Impl"


    // $ANTLR start "rule__ComponentInstance__Group__7"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1512:1: rule__ComponentInstance__Group__7 : rule__ComponentInstance__Group__7__Impl rule__ComponentInstance__Group__8 ;
    public final void rule__ComponentInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1516:1: ( rule__ComponentInstance__Group__7__Impl rule__ComponentInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1517:2: rule__ComponentInstance__Group__7__Impl rule__ComponentInstance__Group__8
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__7__Impl_in_rule__ComponentInstance__Group__73168);
            rule__ComponentInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__8_in_rule__ComponentInstance__Group__73171);
            rule__ComponentInstance__Group__8();

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
    // $ANTLR end "rule__ComponentInstance__Group__7"


    // $ANTLR start "rule__ComponentInstance__Group__7__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1524:1: rule__ComponentInstance__Group__7__Impl : ( ( rule__ComponentInstance__ComponentInstanceAssignment_7 )* ) ;
    public final void rule__ComponentInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1528:1: ( ( ( rule__ComponentInstance__ComponentInstanceAssignment_7 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1529:1: ( ( rule__ComponentInstance__ComponentInstanceAssignment_7 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1529:1: ( ( rule__ComponentInstance__ComponentInstanceAssignment_7 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1530:1: ( rule__ComponentInstance__ComponentInstanceAssignment_7 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getComponentInstanceAssignment_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1531:1: ( rule__ComponentInstance__ComponentInstanceAssignment_7 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=8 && LA15_0<=19)||LA15_0==53) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1531:2: rule__ComponentInstance__ComponentInstanceAssignment_7
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__ComponentInstanceAssignment_7_in_rule__ComponentInstance__Group__7__Impl3198);
            	    rule__ComponentInstance__ComponentInstanceAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getComponentInstanceAccess().getComponentInstanceAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group__7__Impl"


    // $ANTLR start "rule__ComponentInstance__Group__8"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1541:1: rule__ComponentInstance__Group__8 : rule__ComponentInstance__Group__8__Impl rule__ComponentInstance__Group__9 ;
    public final void rule__ComponentInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1545:1: ( rule__ComponentInstance__Group__8__Impl rule__ComponentInstance__Group__9 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1546:2: rule__ComponentInstance__Group__8__Impl rule__ComponentInstance__Group__9
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__8__Impl_in_rule__ComponentInstance__Group__83229);
            rule__ComponentInstance__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__9_in_rule__ComponentInstance__Group__83232);
            rule__ComponentInstance__Group__9();

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
    // $ANTLR end "rule__ComponentInstance__Group__8"


    // $ANTLR start "rule__ComponentInstance__Group__8__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1553:1: rule__ComponentInstance__Group__8__Impl : ( ( rule__ComponentInstance__ModeInstanceAssignment_8 )* ) ;
    public final void rule__ComponentInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1557:1: ( ( ( rule__ComponentInstance__ModeInstanceAssignment_8 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1558:1: ( ( rule__ComponentInstance__ModeInstanceAssignment_8 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1558:1: ( ( rule__ComponentInstance__ModeInstanceAssignment_8 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1559:1: ( rule__ComponentInstance__ModeInstanceAssignment_8 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getModeInstanceAssignment_8()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1560:1: ( rule__ComponentInstance__ModeInstanceAssignment_8 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==43) ) {
                    int LA16_1 = input.LA(2);

                    if ( (LA16_1==40) ) {
                        alt16=1;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1560:2: rule__ComponentInstance__ModeInstanceAssignment_8
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__ModeInstanceAssignment_8_in_rule__ComponentInstance__Group__8__Impl3259);
            	    rule__ComponentInstance__ModeInstanceAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getComponentInstanceAccess().getModeInstanceAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group__8__Impl"


    // $ANTLR start "rule__ComponentInstance__Group__9"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1570:1: rule__ComponentInstance__Group__9 : rule__ComponentInstance__Group__9__Impl rule__ComponentInstance__Group__10 ;
    public final void rule__ComponentInstance__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1574:1: ( rule__ComponentInstance__Group__9__Impl rule__ComponentInstance__Group__10 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1575:2: rule__ComponentInstance__Group__9__Impl rule__ComponentInstance__Group__10
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__9__Impl_in_rule__ComponentInstance__Group__93290);
            rule__ComponentInstance__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__10_in_rule__ComponentInstance__Group__93293);
            rule__ComponentInstance__Group__10();

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
    // $ANTLR end "rule__ComponentInstance__Group__9"


    // $ANTLR start "rule__ComponentInstance__Group__9__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1582:1: rule__ComponentInstance__Group__9__Impl : ( ( rule__ComponentInstance__ModeTransitionInstanceAssignment_9 )* ) ;
    public final void rule__ComponentInstance__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1586:1: ( ( ( rule__ComponentInstance__ModeTransitionInstanceAssignment_9 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1587:1: ( ( rule__ComponentInstance__ModeTransitionInstanceAssignment_9 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1587:1: ( ( rule__ComponentInstance__ModeTransitionInstanceAssignment_9 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1588:1: ( rule__ComponentInstance__ModeTransitionInstanceAssignment_9 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getModeTransitionInstanceAssignment_9()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1589:1: ( rule__ComponentInstance__ModeTransitionInstanceAssignment_9 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==43) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1589:2: rule__ComponentInstance__ModeTransitionInstanceAssignment_9
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__ModeTransitionInstanceAssignment_9_in_rule__ComponentInstance__Group__9__Impl3320);
            	    rule__ComponentInstance__ModeTransitionInstanceAssignment_9();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getComponentInstanceAccess().getModeTransitionInstanceAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group__9__Impl"


    // $ANTLR start "rule__ComponentInstance__Group__10"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1599:1: rule__ComponentInstance__Group__10 : rule__ComponentInstance__Group__10__Impl rule__ComponentInstance__Group__11 ;
    public final void rule__ComponentInstance__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1603:1: ( rule__ComponentInstance__Group__10__Impl rule__ComponentInstance__Group__11 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1604:2: rule__ComponentInstance__Group__10__Impl rule__ComponentInstance__Group__11
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__10__Impl_in_rule__ComponentInstance__Group__103351);
            rule__ComponentInstance__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__11_in_rule__ComponentInstance__Group__103354);
            rule__ComponentInstance__Group__11();

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
    // $ANTLR end "rule__ComponentInstance__Group__10"


    // $ANTLR start "rule__ComponentInstance__Group__10__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1611:1: rule__ComponentInstance__Group__10__Impl : ( ( rule__ComponentInstance__FlowSpecificationAssignment_10 )* ) ;
    public final void rule__ComponentInstance__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1615:1: ( ( ( rule__ComponentInstance__FlowSpecificationAssignment_10 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1616:1: ( ( rule__ComponentInstance__FlowSpecificationAssignment_10 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1616:1: ( ( rule__ComponentInstance__FlowSpecificationAssignment_10 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1617:1: ( rule__ComponentInstance__FlowSpecificationAssignment_10 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getFlowSpecificationAssignment_10()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1618:1: ( rule__ComponentInstance__FlowSpecificationAssignment_10 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==47) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1618:2: rule__ComponentInstance__FlowSpecificationAssignment_10
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__FlowSpecificationAssignment_10_in_rule__ComponentInstance__Group__10__Impl3381);
            	    rule__ComponentInstance__FlowSpecificationAssignment_10();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getComponentInstanceAccess().getFlowSpecificationAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group__10__Impl"


    // $ANTLR start "rule__ComponentInstance__Group__11"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1628:1: rule__ComponentInstance__Group__11 : rule__ComponentInstance__Group__11__Impl rule__ComponentInstance__Group__12 ;
    public final void rule__ComponentInstance__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1632:1: ( rule__ComponentInstance__Group__11__Impl rule__ComponentInstance__Group__12 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1633:2: rule__ComponentInstance__Group__11__Impl rule__ComponentInstance__Group__12
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__11__Impl_in_rule__ComponentInstance__Group__113412);
            rule__ComponentInstance__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__12_in_rule__ComponentInstance__Group__113415);
            rule__ComponentInstance__Group__12();

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
    // $ANTLR end "rule__ComponentInstance__Group__11"


    // $ANTLR start "rule__ComponentInstance__Group__11__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1640:1: rule__ComponentInstance__Group__11__Impl : ( ( rule__ComponentInstance__EndToEndFlowAssignment_11 )* ) ;
    public final void rule__ComponentInstance__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1644:1: ( ( ( rule__ComponentInstance__EndToEndFlowAssignment_11 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1645:1: ( ( rule__ComponentInstance__EndToEndFlowAssignment_11 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1645:1: ( ( rule__ComponentInstance__EndToEndFlowAssignment_11 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1646:1: ( rule__ComponentInstance__EndToEndFlowAssignment_11 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getEndToEndFlowAssignment_11()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1647:1: ( rule__ComponentInstance__EndToEndFlowAssignment_11 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==48) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1647:2: rule__ComponentInstance__EndToEndFlowAssignment_11
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__EndToEndFlowAssignment_11_in_rule__ComponentInstance__Group__11__Impl3442);
            	    rule__ComponentInstance__EndToEndFlowAssignment_11();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getComponentInstanceAccess().getEndToEndFlowAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group__11__Impl"


    // $ANTLR start "rule__ComponentInstance__Group__12"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1657:1: rule__ComponentInstance__Group__12 : rule__ComponentInstance__Group__12__Impl rule__ComponentInstance__Group__13 ;
    public final void rule__ComponentInstance__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1661:1: ( rule__ComponentInstance__Group__12__Impl rule__ComponentInstance__Group__13 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1662:2: rule__ComponentInstance__Group__12__Impl rule__ComponentInstance__Group__13
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__12__Impl_in_rule__ComponentInstance__Group__123473);
            rule__ComponentInstance__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__13_in_rule__ComponentInstance__Group__123476);
            rule__ComponentInstance__Group__13();

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
    // $ANTLR end "rule__ComponentInstance__Group__12"


    // $ANTLR start "rule__ComponentInstance__Group__12__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1669:1: rule__ComponentInstance__Group__12__Impl : ( ( rule__ComponentInstance__ConnectionInstanceAssignment_12 )* ) ;
    public final void rule__ComponentInstance__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1673:1: ( ( ( rule__ComponentInstance__ConnectionInstanceAssignment_12 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1674:1: ( ( rule__ComponentInstance__ConnectionInstanceAssignment_12 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1674:1: ( ( rule__ComponentInstance__ConnectionInstanceAssignment_12 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1675:1: ( rule__ComponentInstance__ConnectionInstanceAssignment_12 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getConnectionInstanceAssignment_12()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1676:1: ( rule__ComponentInstance__ConnectionInstanceAssignment_12 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==23||LA20_0==28||(LA20_0>=33 && LA20_0<=36)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1676:2: rule__ComponentInstance__ConnectionInstanceAssignment_12
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__ConnectionInstanceAssignment_12_in_rule__ComponentInstance__Group__12__Impl3503);
            	    rule__ComponentInstance__ConnectionInstanceAssignment_12();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getComponentInstanceAccess().getConnectionInstanceAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group__12__Impl"


    // $ANTLR start "rule__ComponentInstance__Group__13"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1686:1: rule__ComponentInstance__Group__13 : rule__ComponentInstance__Group__13__Impl rule__ComponentInstance__Group__14 ;
    public final void rule__ComponentInstance__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1690:1: ( rule__ComponentInstance__Group__13__Impl rule__ComponentInstance__Group__14 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1691:2: rule__ComponentInstance__Group__13__Impl rule__ComponentInstance__Group__14
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__13__Impl_in_rule__ComponentInstance__Group__133534);
            rule__ComponentInstance__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__14_in_rule__ComponentInstance__Group__133537);
            rule__ComponentInstance__Group__14();

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
    // $ANTLR end "rule__ComponentInstance__Group__13"


    // $ANTLR start "rule__ComponentInstance__Group__13__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1698:1: rule__ComponentInstance__Group__13__Impl : ( ( rule__ComponentInstance__Group_13__0 )? ) ;
    public final void rule__ComponentInstance__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1702:1: ( ( ( rule__ComponentInstance__Group_13__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1703:1: ( ( rule__ComponentInstance__Group_13__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1703:1: ( ( rule__ComponentInstance__Group_13__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1704:1: ( rule__ComponentInstance__Group_13__0 )?
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup_13()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1705:1: ( rule__ComponentInstance__Group_13__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==30) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1705:2: rule__ComponentInstance__Group_13__0
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__Group_13__0_in_rule__ComponentInstance__Group__13__Impl3564);
                    rule__ComponentInstance__Group_13__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getComponentInstanceAccess().getGroup_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group__13__Impl"


    // $ANTLR start "rule__ComponentInstance__Group__14"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1715:1: rule__ComponentInstance__Group__14 : rule__ComponentInstance__Group__14__Impl ;
    public final void rule__ComponentInstance__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1719:1: ( rule__ComponentInstance__Group__14__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1720:2: rule__ComponentInstance__Group__14__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__14__Impl_in_rule__ComponentInstance__Group__143595);
            rule__ComponentInstance__Group__14__Impl();

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
    // $ANTLR end "rule__ComponentInstance__Group__14"


    // $ANTLR start "rule__ComponentInstance__Group__14__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1726:1: rule__ComponentInstance__Group__14__Impl : ( 'end' ) ;
    public final void rule__ComponentInstance__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1730:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1731:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1731:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1732:1: 'end'
            {
             before(grammarAccess.getComponentInstanceAccess().getEndKeyword_14()); 
            match(input,39,FOLLOW_39_in_rule__ComponentInstance__Group__14__Impl3623); 
             after(grammarAccess.getComponentInstanceAccess().getEndKeyword_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group__14__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_3__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1775:1: rule__ComponentInstance__Group_3__0 : rule__ComponentInstance__Group_3__0__Impl rule__ComponentInstance__Group_3__1 ;
    public final void rule__ComponentInstance__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1779:1: ( rule__ComponentInstance__Group_3__0__Impl rule__ComponentInstance__Group_3__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1780:2: rule__ComponentInstance__Group_3__0__Impl rule__ComponentInstance__Group_3__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_3__0__Impl_in_rule__ComponentInstance__Group_3__03684);
            rule__ComponentInstance__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_3__1_in_rule__ComponentInstance__Group_3__03687);
            rule__ComponentInstance__Group_3__1();

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
    // $ANTLR end "rule__ComponentInstance__Group_3__0"


    // $ANTLR start "rule__ComponentInstance__Group_3__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1787:1: rule__ComponentInstance__Group_3__0__Impl : ( '[' ) ;
    public final void rule__ComponentInstance__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1791:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1792:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1792:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1793:1: '['
            {
             before(grammarAccess.getComponentInstanceAccess().getLeftSquareBracketKeyword_3_0()); 
            match(input,41,FOLLOW_41_in_rule__ComponentInstance__Group_3__0__Impl3715); 
             after(grammarAccess.getComponentInstanceAccess().getLeftSquareBracketKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_3__0__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_3__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1806:1: rule__ComponentInstance__Group_3__1 : rule__ComponentInstance__Group_3__1__Impl rule__ComponentInstance__Group_3__2 ;
    public final void rule__ComponentInstance__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1810:1: ( rule__ComponentInstance__Group_3__1__Impl rule__ComponentInstance__Group_3__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1811:2: rule__ComponentInstance__Group_3__1__Impl rule__ComponentInstance__Group_3__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_3__1__Impl_in_rule__ComponentInstance__Group_3__13746);
            rule__ComponentInstance__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_3__2_in_rule__ComponentInstance__Group_3__13749);
            rule__ComponentInstance__Group_3__2();

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
    // $ANTLR end "rule__ComponentInstance__Group_3__1"


    // $ANTLR start "rule__ComponentInstance__Group_3__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1818:1: rule__ComponentInstance__Group_3__1__Impl : ( ( ( rule__ComponentInstance__IndexAssignment_3_1 ) ) ( ( rule__ComponentInstance__IndexAssignment_3_1 )* ) ) ;
    public final void rule__ComponentInstance__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1822:1: ( ( ( ( rule__ComponentInstance__IndexAssignment_3_1 ) ) ( ( rule__ComponentInstance__IndexAssignment_3_1 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1823:1: ( ( ( rule__ComponentInstance__IndexAssignment_3_1 ) ) ( ( rule__ComponentInstance__IndexAssignment_3_1 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1823:1: ( ( ( rule__ComponentInstance__IndexAssignment_3_1 ) ) ( ( rule__ComponentInstance__IndexAssignment_3_1 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1824:1: ( ( rule__ComponentInstance__IndexAssignment_3_1 ) ) ( ( rule__ComponentInstance__IndexAssignment_3_1 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1824:1: ( ( rule__ComponentInstance__IndexAssignment_3_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1825:1: ( rule__ComponentInstance__IndexAssignment_3_1 )
            {
             before(grammarAccess.getComponentInstanceAccess().getIndexAssignment_3_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1826:1: ( rule__ComponentInstance__IndexAssignment_3_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1826:2: rule__ComponentInstance__IndexAssignment_3_1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__IndexAssignment_3_1_in_rule__ComponentInstance__Group_3__1__Impl3778);
            rule__ComponentInstance__IndexAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getComponentInstanceAccess().getIndexAssignment_3_1()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1829:1: ( ( rule__ComponentInstance__IndexAssignment_3_1 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1830:1: ( rule__ComponentInstance__IndexAssignment_3_1 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getIndexAssignment_3_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1831:1: ( rule__ComponentInstance__IndexAssignment_3_1 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_INTEGER_LIT) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1831:2: rule__ComponentInstance__IndexAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__IndexAssignment_3_1_in_rule__ComponentInstance__Group_3__1__Impl3790);
            	    rule__ComponentInstance__IndexAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getComponentInstanceAccess().getIndexAssignment_3_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_3__1__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_3__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1842:1: rule__ComponentInstance__Group_3__2 : rule__ComponentInstance__Group_3__2__Impl ;
    public final void rule__ComponentInstance__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1846:1: ( rule__ComponentInstance__Group_3__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1847:2: rule__ComponentInstance__Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_3__2__Impl_in_rule__ComponentInstance__Group_3__23823);
            rule__ComponentInstance__Group_3__2__Impl();

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
    // $ANTLR end "rule__ComponentInstance__Group_3__2"


    // $ANTLR start "rule__ComponentInstance__Group_3__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1853:1: rule__ComponentInstance__Group_3__2__Impl : ( ']' ) ;
    public final void rule__ComponentInstance__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1857:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1858:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1858:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1859:1: ']'
            {
             before(grammarAccess.getComponentInstanceAccess().getRightSquareBracketKeyword_3_2()); 
            match(input,42,FOLLOW_42_in_rule__ComponentInstance__Group_3__2__Impl3851); 
             after(grammarAccess.getComponentInstanceAccess().getRightSquareBracketKeyword_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_3__2__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_13__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1878:1: rule__ComponentInstance__Group_13__0 : rule__ComponentInstance__Group_13__0__Impl rule__ComponentInstance__Group_13__1 ;
    public final void rule__ComponentInstance__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1882:1: ( rule__ComponentInstance__Group_13__0__Impl rule__ComponentInstance__Group_13__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1883:2: rule__ComponentInstance__Group_13__0__Impl rule__ComponentInstance__Group_13__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_13__0__Impl_in_rule__ComponentInstance__Group_13__03888);
            rule__ComponentInstance__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_13__1_in_rule__ComponentInstance__Group_13__03891);
            rule__ComponentInstance__Group_13__1();

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
    // $ANTLR end "rule__ComponentInstance__Group_13__0"


    // $ANTLR start "rule__ComponentInstance__Group_13__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1890:1: rule__ComponentInstance__Group_13__0__Impl : ( 'in' ) ;
    public final void rule__ComponentInstance__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1894:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1895:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1895:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1896:1: 'in'
            {
             before(grammarAccess.getComponentInstanceAccess().getInKeyword_13_0()); 
            match(input,30,FOLLOW_30_in_rule__ComponentInstance__Group_13__0__Impl3919); 
             after(grammarAccess.getComponentInstanceAccess().getInKeyword_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_13__0__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_13__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1909:1: rule__ComponentInstance__Group_13__1 : rule__ComponentInstance__Group_13__1__Impl rule__ComponentInstance__Group_13__2 ;
    public final void rule__ComponentInstance__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1913:1: ( rule__ComponentInstance__Group_13__1__Impl rule__ComponentInstance__Group_13__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1914:2: rule__ComponentInstance__Group_13__1__Impl rule__ComponentInstance__Group_13__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_13__1__Impl_in_rule__ComponentInstance__Group_13__13950);
            rule__ComponentInstance__Group_13__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_13__2_in_rule__ComponentInstance__Group_13__13953);
            rule__ComponentInstance__Group_13__2();

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
    // $ANTLR end "rule__ComponentInstance__Group_13__1"


    // $ANTLR start "rule__ComponentInstance__Group_13__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1921:1: rule__ComponentInstance__Group_13__1__Impl : ( 'mode' ) ;
    public final void rule__ComponentInstance__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1925:1: ( ( 'mode' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1926:1: ( 'mode' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1926:1: ( 'mode' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1927:1: 'mode'
            {
             before(grammarAccess.getComponentInstanceAccess().getModeKeyword_13_1()); 
            match(input,43,FOLLOW_43_in_rule__ComponentInstance__Group_13__1__Impl3981); 
             after(grammarAccess.getComponentInstanceAccess().getModeKeyword_13_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_13__1__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_13__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1940:1: rule__ComponentInstance__Group_13__2 : rule__ComponentInstance__Group_13__2__Impl ;
    public final void rule__ComponentInstance__Group_13__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1944:1: ( rule__ComponentInstance__Group_13__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1945:2: rule__ComponentInstance__Group_13__2__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_13__2__Impl_in_rule__ComponentInstance__Group_13__24012);
            rule__ComponentInstance__Group_13__2__Impl();

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
    // $ANTLR end "rule__ComponentInstance__Group_13__2"


    // $ANTLR start "rule__ComponentInstance__Group_13__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1951:1: rule__ComponentInstance__Group_13__2__Impl : ( ( rule__ComponentInstance__InModeAssignment_13_2 ) ) ;
    public final void rule__ComponentInstance__Group_13__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1955:1: ( ( ( rule__ComponentInstance__InModeAssignment_13_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1956:1: ( ( rule__ComponentInstance__InModeAssignment_13_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1956:1: ( ( rule__ComponentInstance__InModeAssignment_13_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1957:1: ( rule__ComponentInstance__InModeAssignment_13_2 )
            {
             before(grammarAccess.getComponentInstanceAccess().getInModeAssignment_13_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1958:1: ( rule__ComponentInstance__InModeAssignment_13_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1958:2: rule__ComponentInstance__InModeAssignment_13_2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__InModeAssignment_13_2_in_rule__ComponentInstance__Group_13__2__Impl4039);
            rule__ComponentInstance__InModeAssignment_13_2();

            state._fsp--;


            }

             after(grammarAccess.getComponentInstanceAccess().getInModeAssignment_13_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_13__2__Impl"


    // $ANTLR start "rule__FeatureInstance__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1974:1: rule__FeatureInstance__Group__0 : rule__FeatureInstance__Group__0__Impl rule__FeatureInstance__Group__1 ;
    public final void rule__FeatureInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1978:1: ( rule__FeatureInstance__Group__0__Impl rule__FeatureInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1979:2: rule__FeatureInstance__Group__0__Impl rule__FeatureInstance__Group__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__0__Impl_in_rule__FeatureInstance__Group__04075);
            rule__FeatureInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__1_in_rule__FeatureInstance__Group__04078);
            rule__FeatureInstance__Group__1();

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
    // $ANTLR end "rule__FeatureInstance__Group__0"


    // $ANTLR start "rule__FeatureInstance__Group__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1986:1: rule__FeatureInstance__Group__0__Impl : ( ( rule__FeatureInstance__CategoryAssignment_0 ) ) ;
    public final void rule__FeatureInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1990:1: ( ( ( rule__FeatureInstance__CategoryAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1991:1: ( ( rule__FeatureInstance__CategoryAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1991:1: ( ( rule__FeatureInstance__CategoryAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1992:1: ( rule__FeatureInstance__CategoryAssignment_0 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getCategoryAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1993:1: ( rule__FeatureInstance__CategoryAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1993:2: rule__FeatureInstance__CategoryAssignment_0
            {
            pushFollow(FOLLOW_rule__FeatureInstance__CategoryAssignment_0_in_rule__FeatureInstance__Group__0__Impl4105);
            rule__FeatureInstance__CategoryAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getFeatureInstanceAccess().getCategoryAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group__0__Impl"


    // $ANTLR start "rule__FeatureInstance__Group__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2003:1: rule__FeatureInstance__Group__1 : rule__FeatureInstance__Group__1__Impl rule__FeatureInstance__Group__2 ;
    public final void rule__FeatureInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2007:1: ( rule__FeatureInstance__Group__1__Impl rule__FeatureInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2008:2: rule__FeatureInstance__Group__1__Impl rule__FeatureInstance__Group__2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__1__Impl_in_rule__FeatureInstance__Group__14135);
            rule__FeatureInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__2_in_rule__FeatureInstance__Group__14138);
            rule__FeatureInstance__Group__2();

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
    // $ANTLR end "rule__FeatureInstance__Group__1"


    // $ANTLR start "rule__FeatureInstance__Group__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2015:1: rule__FeatureInstance__Group__1__Impl : ( 'instance' ) ;
    public final void rule__FeatureInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2019:1: ( ( 'instance' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2020:1: ( 'instance' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2020:1: ( 'instance' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2021:1: 'instance'
            {
             before(grammarAccess.getFeatureInstanceAccess().getInstanceKeyword_1()); 
            match(input,40,FOLLOW_40_in_rule__FeatureInstance__Group__1__Impl4166); 
             after(grammarAccess.getFeatureInstanceAccess().getInstanceKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group__1__Impl"


    // $ANTLR start "rule__FeatureInstance__Group__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2034:1: rule__FeatureInstance__Group__2 : rule__FeatureInstance__Group__2__Impl rule__FeatureInstance__Group__3 ;
    public final void rule__FeatureInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2038:1: ( rule__FeatureInstance__Group__2__Impl rule__FeatureInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2039:2: rule__FeatureInstance__Group__2__Impl rule__FeatureInstance__Group__3
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__2__Impl_in_rule__FeatureInstance__Group__24197);
            rule__FeatureInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__3_in_rule__FeatureInstance__Group__24200);
            rule__FeatureInstance__Group__3();

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
    // $ANTLR end "rule__FeatureInstance__Group__2"


    // $ANTLR start "rule__FeatureInstance__Group__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2046:1: rule__FeatureInstance__Group__2__Impl : ( ( rule__FeatureInstance__NameAssignment_2 ) ) ;
    public final void rule__FeatureInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2050:1: ( ( ( rule__FeatureInstance__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2051:1: ( ( rule__FeatureInstance__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2051:1: ( ( rule__FeatureInstance__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2052:1: ( rule__FeatureInstance__NameAssignment_2 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2053:1: ( rule__FeatureInstance__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2053:2: rule__FeatureInstance__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__NameAssignment_2_in_rule__FeatureInstance__Group__2__Impl4227);
            rule__FeatureInstance__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFeatureInstanceAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group__2__Impl"


    // $ANTLR start "rule__FeatureInstance__Group__3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2063:1: rule__FeatureInstance__Group__3 : rule__FeatureInstance__Group__3__Impl rule__FeatureInstance__Group__4 ;
    public final void rule__FeatureInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2067:1: ( rule__FeatureInstance__Group__3__Impl rule__FeatureInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2068:2: rule__FeatureInstance__Group__3__Impl rule__FeatureInstance__Group__4
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__3__Impl_in_rule__FeatureInstance__Group__34257);
            rule__FeatureInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__4_in_rule__FeatureInstance__Group__34260);
            rule__FeatureInstance__Group__4();

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
    // $ANTLR end "rule__FeatureInstance__Group__3"


    // $ANTLR start "rule__FeatureInstance__Group__3__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2075:1: rule__FeatureInstance__Group__3__Impl : ( ( rule__FeatureInstance__Group_3__0 )? ) ;
    public final void rule__FeatureInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2079:1: ( ( ( rule__FeatureInstance__Group_3__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2080:1: ( ( rule__FeatureInstance__Group_3__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2080:1: ( ( rule__FeatureInstance__Group_3__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2081:1: ( rule__FeatureInstance__Group_3__0 )?
            {
             before(grammarAccess.getFeatureInstanceAccess().getGroup_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2082:1: ( rule__FeatureInstance__Group_3__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==41) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2082:2: rule__FeatureInstance__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__FeatureInstance__Group_3__0_in_rule__FeatureInstance__Group__3__Impl4287);
                    rule__FeatureInstance__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFeatureInstanceAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group__3__Impl"


    // $ANTLR start "rule__FeatureInstance__Group__4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2092:1: rule__FeatureInstance__Group__4 : rule__FeatureInstance__Group__4__Impl rule__FeatureInstance__Group__5 ;
    public final void rule__FeatureInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2096:1: ( rule__FeatureInstance__Group__4__Impl rule__FeatureInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2097:2: rule__FeatureInstance__Group__4__Impl rule__FeatureInstance__Group__5
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__4__Impl_in_rule__FeatureInstance__Group__44318);
            rule__FeatureInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__5_in_rule__FeatureInstance__Group__44321);
            rule__FeatureInstance__Group__5();

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
    // $ANTLR end "rule__FeatureInstance__Group__4"


    // $ANTLR start "rule__FeatureInstance__Group__4__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2104:1: rule__FeatureInstance__Group__4__Impl : ( 'of' ) ;
    public final void rule__FeatureInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2108:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2109:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2109:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2110:1: 'of'
            {
             before(grammarAccess.getFeatureInstanceAccess().getOfKeyword_4()); 
            match(input,38,FOLLOW_38_in_rule__FeatureInstance__Group__4__Impl4349); 
             after(grammarAccess.getFeatureInstanceAccess().getOfKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group__4__Impl"


    // $ANTLR start "rule__FeatureInstance__Group__5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2123:1: rule__FeatureInstance__Group__5 : rule__FeatureInstance__Group__5__Impl rule__FeatureInstance__Group__6 ;
    public final void rule__FeatureInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2127:1: ( rule__FeatureInstance__Group__5__Impl rule__FeatureInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2128:2: rule__FeatureInstance__Group__5__Impl rule__FeatureInstance__Group__6
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__5__Impl_in_rule__FeatureInstance__Group__54380);
            rule__FeatureInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__6_in_rule__FeatureInstance__Group__54383);
            rule__FeatureInstance__Group__6();

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
    // $ANTLR end "rule__FeatureInstance__Group__5"


    // $ANTLR start "rule__FeatureInstance__Group__5__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2135:1: rule__FeatureInstance__Group__5__Impl : ( ( rule__FeatureInstance__FeatureAssignment_5 ) ) ;
    public final void rule__FeatureInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2139:1: ( ( ( rule__FeatureInstance__FeatureAssignment_5 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2140:1: ( ( rule__FeatureInstance__FeatureAssignment_5 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2140:1: ( ( rule__FeatureInstance__FeatureAssignment_5 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2141:1: ( rule__FeatureInstance__FeatureAssignment_5 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2142:1: ( rule__FeatureInstance__FeatureAssignment_5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2142:2: rule__FeatureInstance__FeatureAssignment_5
            {
            pushFollow(FOLLOW_rule__FeatureInstance__FeatureAssignment_5_in_rule__FeatureInstance__Group__5__Impl4410);
            rule__FeatureInstance__FeatureAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getFeatureInstanceAccess().getFeatureAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group__5__Impl"


    // $ANTLR start "rule__FeatureInstance__Group__6"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2152:1: rule__FeatureInstance__Group__6 : rule__FeatureInstance__Group__6__Impl rule__FeatureInstance__Group__7 ;
    public final void rule__FeatureInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2156:1: ( rule__FeatureInstance__Group__6__Impl rule__FeatureInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2157:2: rule__FeatureInstance__Group__6__Impl rule__FeatureInstance__Group__7
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__6__Impl_in_rule__FeatureInstance__Group__64440);
            rule__FeatureInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__7_in_rule__FeatureInstance__Group__64443);
            rule__FeatureInstance__Group__7();

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
    // $ANTLR end "rule__FeatureInstance__Group__6"


    // $ANTLR start "rule__FeatureInstance__Group__6__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2164:1: rule__FeatureInstance__Group__6__Impl : ( ( rule__FeatureInstance__DirectionAssignment_6 ) ) ;
    public final void rule__FeatureInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2168:1: ( ( ( rule__FeatureInstance__DirectionAssignment_6 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2169:1: ( ( rule__FeatureInstance__DirectionAssignment_6 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2169:1: ( ( rule__FeatureInstance__DirectionAssignment_6 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2170:1: ( rule__FeatureInstance__DirectionAssignment_6 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getDirectionAssignment_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2171:1: ( rule__FeatureInstance__DirectionAssignment_6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2171:2: rule__FeatureInstance__DirectionAssignment_6
            {
            pushFollow(FOLLOW_rule__FeatureInstance__DirectionAssignment_6_in_rule__FeatureInstance__Group__6__Impl4470);
            rule__FeatureInstance__DirectionAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getFeatureInstanceAccess().getDirectionAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group__6__Impl"


    // $ANTLR start "rule__FeatureInstance__Group__7"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2181:1: rule__FeatureInstance__Group__7 : rule__FeatureInstance__Group__7__Impl rule__FeatureInstance__Group__8 ;
    public final void rule__FeatureInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2185:1: ( rule__FeatureInstance__Group__7__Impl rule__FeatureInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2186:2: rule__FeatureInstance__Group__7__Impl rule__FeatureInstance__Group__8
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__7__Impl_in_rule__FeatureInstance__Group__74500);
            rule__FeatureInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__8_in_rule__FeatureInstance__Group__74503);
            rule__FeatureInstance__Group__8();

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
    // $ANTLR end "rule__FeatureInstance__Group__7"


    // $ANTLR start "rule__FeatureInstance__Group__7__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2193:1: rule__FeatureInstance__Group__7__Impl : ( ( rule__FeatureInstance__FeatureInstanceAssignment_7 ) ) ;
    public final void rule__FeatureInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2197:1: ( ( ( rule__FeatureInstance__FeatureInstanceAssignment_7 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2198:1: ( ( rule__FeatureInstance__FeatureInstanceAssignment_7 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2198:1: ( ( rule__FeatureInstance__FeatureInstanceAssignment_7 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2199:1: ( rule__FeatureInstance__FeatureInstanceAssignment_7 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceAssignment_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2200:1: ( rule__FeatureInstance__FeatureInstanceAssignment_7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2200:2: rule__FeatureInstance__FeatureInstanceAssignment_7
            {
            pushFollow(FOLLOW_rule__FeatureInstance__FeatureInstanceAssignment_7_in_rule__FeatureInstance__Group__7__Impl4530);
            rule__FeatureInstance__FeatureInstanceAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group__7__Impl"


    // $ANTLR start "rule__FeatureInstance__Group__8"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2210:1: rule__FeatureInstance__Group__8 : rule__FeatureInstance__Group__8__Impl ;
    public final void rule__FeatureInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2214:1: ( rule__FeatureInstance__Group__8__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2215:2: rule__FeatureInstance__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__8__Impl_in_rule__FeatureInstance__Group__84560);
            rule__FeatureInstance__Group__8__Impl();

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
    // $ANTLR end "rule__FeatureInstance__Group__8"


    // $ANTLR start "rule__FeatureInstance__Group__8__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2221:1: rule__FeatureInstance__Group__8__Impl : ( 'end' ) ;
    public final void rule__FeatureInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2225:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2226:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2226:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2227:1: 'end'
            {
             before(grammarAccess.getFeatureInstanceAccess().getEndKeyword_8()); 
            match(input,39,FOLLOW_39_in_rule__FeatureInstance__Group__8__Impl4588); 
             after(grammarAccess.getFeatureInstanceAccess().getEndKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group__8__Impl"


    // $ANTLR start "rule__FeatureInstance__Group_3__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2258:1: rule__FeatureInstance__Group_3__0 : rule__FeatureInstance__Group_3__0__Impl rule__FeatureInstance__Group_3__1 ;
    public final void rule__FeatureInstance__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2262:1: ( rule__FeatureInstance__Group_3__0__Impl rule__FeatureInstance__Group_3__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2263:2: rule__FeatureInstance__Group_3__0__Impl rule__FeatureInstance__Group_3__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__0__Impl_in_rule__FeatureInstance__Group_3__04637);
            rule__FeatureInstance__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__1_in_rule__FeatureInstance__Group_3__04640);
            rule__FeatureInstance__Group_3__1();

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
    // $ANTLR end "rule__FeatureInstance__Group_3__0"


    // $ANTLR start "rule__FeatureInstance__Group_3__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2270:1: rule__FeatureInstance__Group_3__0__Impl : ( '[' ) ;
    public final void rule__FeatureInstance__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2274:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2275:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2275:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2276:1: '['
            {
             before(grammarAccess.getFeatureInstanceAccess().getLeftSquareBracketKeyword_3_0()); 
            match(input,41,FOLLOW_41_in_rule__FeatureInstance__Group_3__0__Impl4668); 
             after(grammarAccess.getFeatureInstanceAccess().getLeftSquareBracketKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_3__0__Impl"


    // $ANTLR start "rule__FeatureInstance__Group_3__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2289:1: rule__FeatureInstance__Group_3__1 : rule__FeatureInstance__Group_3__1__Impl rule__FeatureInstance__Group_3__2 ;
    public final void rule__FeatureInstance__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2293:1: ( rule__FeatureInstance__Group_3__1__Impl rule__FeatureInstance__Group_3__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2294:2: rule__FeatureInstance__Group_3__1__Impl rule__FeatureInstance__Group_3__2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__1__Impl_in_rule__FeatureInstance__Group_3__14699);
            rule__FeatureInstance__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__2_in_rule__FeatureInstance__Group_3__14702);
            rule__FeatureInstance__Group_3__2();

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
    // $ANTLR end "rule__FeatureInstance__Group_3__1"


    // $ANTLR start "rule__FeatureInstance__Group_3__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2301:1: rule__FeatureInstance__Group_3__1__Impl : ( ( rule__FeatureInstance__IndexAssignment_3_1 ) ) ;
    public final void rule__FeatureInstance__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2305:1: ( ( ( rule__FeatureInstance__IndexAssignment_3_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2306:1: ( ( rule__FeatureInstance__IndexAssignment_3_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2306:1: ( ( rule__FeatureInstance__IndexAssignment_3_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2307:1: ( rule__FeatureInstance__IndexAssignment_3_1 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getIndexAssignment_3_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2308:1: ( rule__FeatureInstance__IndexAssignment_3_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2308:2: rule__FeatureInstance__IndexAssignment_3_1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__IndexAssignment_3_1_in_rule__FeatureInstance__Group_3__1__Impl4729);
            rule__FeatureInstance__IndexAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getFeatureInstanceAccess().getIndexAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_3__1__Impl"


    // $ANTLR start "rule__FeatureInstance__Group_3__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2318:1: rule__FeatureInstance__Group_3__2 : rule__FeatureInstance__Group_3__2__Impl ;
    public final void rule__FeatureInstance__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2322:1: ( rule__FeatureInstance__Group_3__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2323:2: rule__FeatureInstance__Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__2__Impl_in_rule__FeatureInstance__Group_3__24759);
            rule__FeatureInstance__Group_3__2__Impl();

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
    // $ANTLR end "rule__FeatureInstance__Group_3__2"


    // $ANTLR start "rule__FeatureInstance__Group_3__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2329:1: rule__FeatureInstance__Group_3__2__Impl : ( ']' ) ;
    public final void rule__FeatureInstance__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2333:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2334:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2334:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2335:1: ']'
            {
             before(grammarAccess.getFeatureInstanceAccess().getRightSquareBracketKeyword_3_2()); 
            match(input,42,FOLLOW_42_in_rule__FeatureInstance__Group_3__2__Impl4787); 
             after(grammarAccess.getFeatureInstanceAccess().getRightSquareBracketKeyword_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_3__2__Impl"


    // $ANTLR start "rule__ModeInstance__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2354:1: rule__ModeInstance__Group__0 : rule__ModeInstance__Group__0__Impl rule__ModeInstance__Group__1 ;
    public final void rule__ModeInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2358:1: ( rule__ModeInstance__Group__0__Impl rule__ModeInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2359:2: rule__ModeInstance__Group__0__Impl rule__ModeInstance__Group__1
            {
            pushFollow(FOLLOW_rule__ModeInstance__Group__0__Impl_in_rule__ModeInstance__Group__04824);
            rule__ModeInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeInstance__Group__1_in_rule__ModeInstance__Group__04827);
            rule__ModeInstance__Group__1();

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
    // $ANTLR end "rule__ModeInstance__Group__0"


    // $ANTLR start "rule__ModeInstance__Group__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2366:1: rule__ModeInstance__Group__0__Impl : ( 'mode' ) ;
    public final void rule__ModeInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2370:1: ( ( 'mode' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2371:1: ( 'mode' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2371:1: ( 'mode' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2372:1: 'mode'
            {
             before(grammarAccess.getModeInstanceAccess().getModeKeyword_0()); 
            match(input,43,FOLLOW_43_in_rule__ModeInstance__Group__0__Impl4855); 
             after(grammarAccess.getModeInstanceAccess().getModeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeInstance__Group__0__Impl"


    // $ANTLR start "rule__ModeInstance__Group__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2385:1: rule__ModeInstance__Group__1 : rule__ModeInstance__Group__1__Impl rule__ModeInstance__Group__2 ;
    public final void rule__ModeInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2389:1: ( rule__ModeInstance__Group__1__Impl rule__ModeInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2390:2: rule__ModeInstance__Group__1__Impl rule__ModeInstance__Group__2
            {
            pushFollow(FOLLOW_rule__ModeInstance__Group__1__Impl_in_rule__ModeInstance__Group__14886);
            rule__ModeInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeInstance__Group__2_in_rule__ModeInstance__Group__14889);
            rule__ModeInstance__Group__2();

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
    // $ANTLR end "rule__ModeInstance__Group__1"


    // $ANTLR start "rule__ModeInstance__Group__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2397:1: rule__ModeInstance__Group__1__Impl : ( 'instance' ) ;
    public final void rule__ModeInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2401:1: ( ( 'instance' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2402:1: ( 'instance' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2402:1: ( 'instance' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2403:1: 'instance'
            {
             before(grammarAccess.getModeInstanceAccess().getInstanceKeyword_1()); 
            match(input,40,FOLLOW_40_in_rule__ModeInstance__Group__1__Impl4917); 
             after(grammarAccess.getModeInstanceAccess().getInstanceKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeInstance__Group__1__Impl"


    // $ANTLR start "rule__ModeInstance__Group__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2416:1: rule__ModeInstance__Group__2 : rule__ModeInstance__Group__2__Impl rule__ModeInstance__Group__3 ;
    public final void rule__ModeInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2420:1: ( rule__ModeInstance__Group__2__Impl rule__ModeInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2421:2: rule__ModeInstance__Group__2__Impl rule__ModeInstance__Group__3
            {
            pushFollow(FOLLOW_rule__ModeInstance__Group__2__Impl_in_rule__ModeInstance__Group__24948);
            rule__ModeInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeInstance__Group__3_in_rule__ModeInstance__Group__24951);
            rule__ModeInstance__Group__3();

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
    // $ANTLR end "rule__ModeInstance__Group__2"


    // $ANTLR start "rule__ModeInstance__Group__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2428:1: rule__ModeInstance__Group__2__Impl : ( ( rule__ModeInstance__NameAssignment_2 ) ) ;
    public final void rule__ModeInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2432:1: ( ( ( rule__ModeInstance__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2433:1: ( ( rule__ModeInstance__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2433:1: ( ( rule__ModeInstance__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2434:1: ( rule__ModeInstance__NameAssignment_2 )
            {
             before(grammarAccess.getModeInstanceAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2435:1: ( rule__ModeInstance__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2435:2: rule__ModeInstance__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__ModeInstance__NameAssignment_2_in_rule__ModeInstance__Group__2__Impl4978);
            rule__ModeInstance__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getModeInstanceAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeInstance__Group__2__Impl"


    // $ANTLR start "rule__ModeInstance__Group__3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2445:1: rule__ModeInstance__Group__3 : rule__ModeInstance__Group__3__Impl rule__ModeInstance__Group__4 ;
    public final void rule__ModeInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2449:1: ( rule__ModeInstance__Group__3__Impl rule__ModeInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2450:2: rule__ModeInstance__Group__3__Impl rule__ModeInstance__Group__4
            {
            pushFollow(FOLLOW_rule__ModeInstance__Group__3__Impl_in_rule__ModeInstance__Group__35008);
            rule__ModeInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeInstance__Group__4_in_rule__ModeInstance__Group__35011);
            rule__ModeInstance__Group__4();

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
    // $ANTLR end "rule__ModeInstance__Group__3"


    // $ANTLR start "rule__ModeInstance__Group__3__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2457:1: rule__ModeInstance__Group__3__Impl : ( 'of' ) ;
    public final void rule__ModeInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2461:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2462:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2462:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2463:1: 'of'
            {
             before(grammarAccess.getModeInstanceAccess().getOfKeyword_3()); 
            match(input,38,FOLLOW_38_in_rule__ModeInstance__Group__3__Impl5039); 
             after(grammarAccess.getModeInstanceAccess().getOfKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeInstance__Group__3__Impl"


    // $ANTLR start "rule__ModeInstance__Group__4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2476:1: rule__ModeInstance__Group__4 : rule__ModeInstance__Group__4__Impl rule__ModeInstance__Group__5 ;
    public final void rule__ModeInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2480:1: ( rule__ModeInstance__Group__4__Impl rule__ModeInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2481:2: rule__ModeInstance__Group__4__Impl rule__ModeInstance__Group__5
            {
            pushFollow(FOLLOW_rule__ModeInstance__Group__4__Impl_in_rule__ModeInstance__Group__45070);
            rule__ModeInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeInstance__Group__5_in_rule__ModeInstance__Group__45073);
            rule__ModeInstance__Group__5();

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
    // $ANTLR end "rule__ModeInstance__Group__4"


    // $ANTLR start "rule__ModeInstance__Group__4__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2488:1: rule__ModeInstance__Group__4__Impl : ( ( rule__ModeInstance__ModeAssignment_4 ) ) ;
    public final void rule__ModeInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2492:1: ( ( ( rule__ModeInstance__ModeAssignment_4 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2493:1: ( ( rule__ModeInstance__ModeAssignment_4 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2493:1: ( ( rule__ModeInstance__ModeAssignment_4 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2494:1: ( rule__ModeInstance__ModeAssignment_4 )
            {
             before(grammarAccess.getModeInstanceAccess().getModeAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2495:1: ( rule__ModeInstance__ModeAssignment_4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2495:2: rule__ModeInstance__ModeAssignment_4
            {
            pushFollow(FOLLOW_rule__ModeInstance__ModeAssignment_4_in_rule__ModeInstance__Group__4__Impl5100);
            rule__ModeInstance__ModeAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getModeInstanceAccess().getModeAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeInstance__Group__4__Impl"


    // $ANTLR start "rule__ModeInstance__Group__5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2505:1: rule__ModeInstance__Group__5 : rule__ModeInstance__Group__5__Impl rule__ModeInstance__Group__6 ;
    public final void rule__ModeInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2509:1: ( rule__ModeInstance__Group__5__Impl rule__ModeInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2510:2: rule__ModeInstance__Group__5__Impl rule__ModeInstance__Group__6
            {
            pushFollow(FOLLOW_rule__ModeInstance__Group__5__Impl_in_rule__ModeInstance__Group__55130);
            rule__ModeInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeInstance__Group__6_in_rule__ModeInstance__Group__55133);
            rule__ModeInstance__Group__6();

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
    // $ANTLR end "rule__ModeInstance__Group__5"


    // $ANTLR start "rule__ModeInstance__Group__5__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2517:1: rule__ModeInstance__Group__5__Impl : ( ( rule__ModeInstance__InitialAssignment_5 )? ) ;
    public final void rule__ModeInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2521:1: ( ( ( rule__ModeInstance__InitialAssignment_5 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2522:1: ( ( rule__ModeInstance__InitialAssignment_5 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2522:1: ( ( rule__ModeInstance__InitialAssignment_5 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2523:1: ( rule__ModeInstance__InitialAssignment_5 )?
            {
             before(grammarAccess.getModeInstanceAccess().getInitialAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2524:1: ( rule__ModeInstance__InitialAssignment_5 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==57) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2524:2: rule__ModeInstance__InitialAssignment_5
                    {
                    pushFollow(FOLLOW_rule__ModeInstance__InitialAssignment_5_in_rule__ModeInstance__Group__5__Impl5160);
                    rule__ModeInstance__InitialAssignment_5();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModeInstanceAccess().getInitialAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeInstance__Group__5__Impl"


    // $ANTLR start "rule__ModeInstance__Group__6"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2534:1: rule__ModeInstance__Group__6 : rule__ModeInstance__Group__6__Impl ;
    public final void rule__ModeInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2538:1: ( rule__ModeInstance__Group__6__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2539:2: rule__ModeInstance__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ModeInstance__Group__6__Impl_in_rule__ModeInstance__Group__65191);
            rule__ModeInstance__Group__6__Impl();

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
    // $ANTLR end "rule__ModeInstance__Group__6"


    // $ANTLR start "rule__ModeInstance__Group__6__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2545:1: rule__ModeInstance__Group__6__Impl : ( 'end' ) ;
    public final void rule__ModeInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2549:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2550:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2550:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2551:1: 'end'
            {
             before(grammarAccess.getModeInstanceAccess().getEndKeyword_6()); 
            match(input,39,FOLLOW_39_in_rule__ModeInstance__Group__6__Impl5219); 
             after(grammarAccess.getModeInstanceAccess().getEndKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeInstance__Group__6__Impl"


    // $ANTLR start "rule__ModeTransitionInstance__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2578:1: rule__ModeTransitionInstance__Group__0 : rule__ModeTransitionInstance__Group__0__Impl rule__ModeTransitionInstance__Group__1 ;
    public final void rule__ModeTransitionInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2582:1: ( rule__ModeTransitionInstance__Group__0__Impl rule__ModeTransitionInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2583:2: rule__ModeTransitionInstance__Group__0__Impl rule__ModeTransitionInstance__Group__1
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__0__Impl_in_rule__ModeTransitionInstance__Group__05264);
            rule__ModeTransitionInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__1_in_rule__ModeTransitionInstance__Group__05267);
            rule__ModeTransitionInstance__Group__1();

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
    // $ANTLR end "rule__ModeTransitionInstance__Group__0"


    // $ANTLR start "rule__ModeTransitionInstance__Group__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2590:1: rule__ModeTransitionInstance__Group__0__Impl : ( 'mode' ) ;
    public final void rule__ModeTransitionInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2594:1: ( ( 'mode' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2595:1: ( 'mode' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2595:1: ( 'mode' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2596:1: 'mode'
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getModeKeyword_0()); 
            match(input,43,FOLLOW_43_in_rule__ModeTransitionInstance__Group__0__Impl5295); 
             after(grammarAccess.getModeTransitionInstanceAccess().getModeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeTransitionInstance__Group__0__Impl"


    // $ANTLR start "rule__ModeTransitionInstance__Group__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2609:1: rule__ModeTransitionInstance__Group__1 : rule__ModeTransitionInstance__Group__1__Impl rule__ModeTransitionInstance__Group__2 ;
    public final void rule__ModeTransitionInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2613:1: ( rule__ModeTransitionInstance__Group__1__Impl rule__ModeTransitionInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2614:2: rule__ModeTransitionInstance__Group__1__Impl rule__ModeTransitionInstance__Group__2
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__1__Impl_in_rule__ModeTransitionInstance__Group__15326);
            rule__ModeTransitionInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__2_in_rule__ModeTransitionInstance__Group__15329);
            rule__ModeTransitionInstance__Group__2();

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
    // $ANTLR end "rule__ModeTransitionInstance__Group__1"


    // $ANTLR start "rule__ModeTransitionInstance__Group__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2621:1: rule__ModeTransitionInstance__Group__1__Impl : ( 'transition' ) ;
    public final void rule__ModeTransitionInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2625:1: ( ( 'transition' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2626:1: ( 'transition' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2626:1: ( 'transition' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2627:1: 'transition'
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getTransitionKeyword_1()); 
            match(input,44,FOLLOW_44_in_rule__ModeTransitionInstance__Group__1__Impl5357); 
             after(grammarAccess.getModeTransitionInstanceAccess().getTransitionKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeTransitionInstance__Group__1__Impl"


    // $ANTLR start "rule__ModeTransitionInstance__Group__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2640:1: rule__ModeTransitionInstance__Group__2 : rule__ModeTransitionInstance__Group__2__Impl rule__ModeTransitionInstance__Group__3 ;
    public final void rule__ModeTransitionInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2644:1: ( rule__ModeTransitionInstance__Group__2__Impl rule__ModeTransitionInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2645:2: rule__ModeTransitionInstance__Group__2__Impl rule__ModeTransitionInstance__Group__3
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__2__Impl_in_rule__ModeTransitionInstance__Group__25388);
            rule__ModeTransitionInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__3_in_rule__ModeTransitionInstance__Group__25391);
            rule__ModeTransitionInstance__Group__3();

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
    // $ANTLR end "rule__ModeTransitionInstance__Group__2"


    // $ANTLR start "rule__ModeTransitionInstance__Group__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2652:1: rule__ModeTransitionInstance__Group__2__Impl : ( 'instance' ) ;
    public final void rule__ModeTransitionInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2656:1: ( ( 'instance' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2657:1: ( 'instance' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2657:1: ( 'instance' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2658:1: 'instance'
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getInstanceKeyword_2()); 
            match(input,40,FOLLOW_40_in_rule__ModeTransitionInstance__Group__2__Impl5419); 
             after(grammarAccess.getModeTransitionInstanceAccess().getInstanceKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeTransitionInstance__Group__2__Impl"


    // $ANTLR start "rule__ModeTransitionInstance__Group__3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2671:1: rule__ModeTransitionInstance__Group__3 : rule__ModeTransitionInstance__Group__3__Impl rule__ModeTransitionInstance__Group__4 ;
    public final void rule__ModeTransitionInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2675:1: ( rule__ModeTransitionInstance__Group__3__Impl rule__ModeTransitionInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2676:2: rule__ModeTransitionInstance__Group__3__Impl rule__ModeTransitionInstance__Group__4
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__3__Impl_in_rule__ModeTransitionInstance__Group__35450);
            rule__ModeTransitionInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__4_in_rule__ModeTransitionInstance__Group__35453);
            rule__ModeTransitionInstance__Group__4();

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
    // $ANTLR end "rule__ModeTransitionInstance__Group__3"


    // $ANTLR start "rule__ModeTransitionInstance__Group__3__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2683:1: rule__ModeTransitionInstance__Group__3__Impl : ( ( rule__ModeTransitionInstance__NameAssignment_3 ) ) ;
    public final void rule__ModeTransitionInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2687:1: ( ( ( rule__ModeTransitionInstance__NameAssignment_3 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2688:1: ( ( rule__ModeTransitionInstance__NameAssignment_3 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2688:1: ( ( rule__ModeTransitionInstance__NameAssignment_3 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2689:1: ( rule__ModeTransitionInstance__NameAssignment_3 )
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getNameAssignment_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2690:1: ( rule__ModeTransitionInstance__NameAssignment_3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2690:2: rule__ModeTransitionInstance__NameAssignment_3
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__NameAssignment_3_in_rule__ModeTransitionInstance__Group__3__Impl5480);
            rule__ModeTransitionInstance__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getModeTransitionInstanceAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeTransitionInstance__Group__3__Impl"


    // $ANTLR start "rule__ModeTransitionInstance__Group__4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2700:1: rule__ModeTransitionInstance__Group__4 : rule__ModeTransitionInstance__Group__4__Impl rule__ModeTransitionInstance__Group__5 ;
    public final void rule__ModeTransitionInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2704:1: ( rule__ModeTransitionInstance__Group__4__Impl rule__ModeTransitionInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2705:2: rule__ModeTransitionInstance__Group__4__Impl rule__ModeTransitionInstance__Group__5
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__4__Impl_in_rule__ModeTransitionInstance__Group__45510);
            rule__ModeTransitionInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__5_in_rule__ModeTransitionInstance__Group__45513);
            rule__ModeTransitionInstance__Group__5();

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
    // $ANTLR end "rule__ModeTransitionInstance__Group__4"


    // $ANTLR start "rule__ModeTransitionInstance__Group__4__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2712:1: rule__ModeTransitionInstance__Group__4__Impl : ( 'of' ) ;
    public final void rule__ModeTransitionInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2716:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2717:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2717:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2718:1: 'of'
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getOfKeyword_4()); 
            match(input,38,FOLLOW_38_in_rule__ModeTransitionInstance__Group__4__Impl5541); 
             after(grammarAccess.getModeTransitionInstanceAccess().getOfKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeTransitionInstance__Group__4__Impl"


    // $ANTLR start "rule__ModeTransitionInstance__Group__5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2731:1: rule__ModeTransitionInstance__Group__5 : rule__ModeTransitionInstance__Group__5__Impl rule__ModeTransitionInstance__Group__6 ;
    public final void rule__ModeTransitionInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2735:1: ( rule__ModeTransitionInstance__Group__5__Impl rule__ModeTransitionInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2736:2: rule__ModeTransitionInstance__Group__5__Impl rule__ModeTransitionInstance__Group__6
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__5__Impl_in_rule__ModeTransitionInstance__Group__55572);
            rule__ModeTransitionInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__6_in_rule__ModeTransitionInstance__Group__55575);
            rule__ModeTransitionInstance__Group__6();

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
    // $ANTLR end "rule__ModeTransitionInstance__Group__5"


    // $ANTLR start "rule__ModeTransitionInstance__Group__5__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2743:1: rule__ModeTransitionInstance__Group__5__Impl : ( ( rule__ModeTransitionInstance__ModeTransitionAssignment_5 ) ) ;
    public final void rule__ModeTransitionInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2747:1: ( ( ( rule__ModeTransitionInstance__ModeTransitionAssignment_5 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2748:1: ( ( rule__ModeTransitionInstance__ModeTransitionAssignment_5 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2748:1: ( ( rule__ModeTransitionInstance__ModeTransitionAssignment_5 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2749:1: ( rule__ModeTransitionInstance__ModeTransitionAssignment_5 )
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2750:1: ( rule__ModeTransitionInstance__ModeTransitionAssignment_5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2750:2: rule__ModeTransitionInstance__ModeTransitionAssignment_5
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__ModeTransitionAssignment_5_in_rule__ModeTransitionInstance__Group__5__Impl5602);
            rule__ModeTransitionInstance__ModeTransitionAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeTransitionInstance__Group__5__Impl"


    // $ANTLR start "rule__ModeTransitionInstance__Group__6"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2760:1: rule__ModeTransitionInstance__Group__6 : rule__ModeTransitionInstance__Group__6__Impl rule__ModeTransitionInstance__Group__7 ;
    public final void rule__ModeTransitionInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2764:1: ( rule__ModeTransitionInstance__Group__6__Impl rule__ModeTransitionInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2765:2: rule__ModeTransitionInstance__Group__6__Impl rule__ModeTransitionInstance__Group__7
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__6__Impl_in_rule__ModeTransitionInstance__Group__65632);
            rule__ModeTransitionInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__7_in_rule__ModeTransitionInstance__Group__65635);
            rule__ModeTransitionInstance__Group__7();

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
    // $ANTLR end "rule__ModeTransitionInstance__Group__6"


    // $ANTLR start "rule__ModeTransitionInstance__Group__6__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2772:1: rule__ModeTransitionInstance__Group__6__Impl : ( 'src' ) ;
    public final void rule__ModeTransitionInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2776:1: ( ( 'src' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2777:1: ( 'src' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2777:1: ( 'src' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2778:1: 'src'
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getSrcKeyword_6()); 
            match(input,45,FOLLOW_45_in_rule__ModeTransitionInstance__Group__6__Impl5663); 
             after(grammarAccess.getModeTransitionInstanceAccess().getSrcKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeTransitionInstance__Group__6__Impl"


    // $ANTLR start "rule__ModeTransitionInstance__Group__7"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2791:1: rule__ModeTransitionInstance__Group__7 : rule__ModeTransitionInstance__Group__7__Impl rule__ModeTransitionInstance__Group__8 ;
    public final void rule__ModeTransitionInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2795:1: ( rule__ModeTransitionInstance__Group__7__Impl rule__ModeTransitionInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2796:2: rule__ModeTransitionInstance__Group__7__Impl rule__ModeTransitionInstance__Group__8
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__7__Impl_in_rule__ModeTransitionInstance__Group__75694);
            rule__ModeTransitionInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__8_in_rule__ModeTransitionInstance__Group__75697);
            rule__ModeTransitionInstance__Group__8();

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
    // $ANTLR end "rule__ModeTransitionInstance__Group__7"


    // $ANTLR start "rule__ModeTransitionInstance__Group__7__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2803:1: rule__ModeTransitionInstance__Group__7__Impl : ( ( rule__ModeTransitionInstance__SourceAssignment_7 ) ) ;
    public final void rule__ModeTransitionInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2807:1: ( ( ( rule__ModeTransitionInstance__SourceAssignment_7 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2808:1: ( ( rule__ModeTransitionInstance__SourceAssignment_7 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2808:1: ( ( rule__ModeTransitionInstance__SourceAssignment_7 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2809:1: ( rule__ModeTransitionInstance__SourceAssignment_7 )
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getSourceAssignment_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2810:1: ( rule__ModeTransitionInstance__SourceAssignment_7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2810:2: rule__ModeTransitionInstance__SourceAssignment_7
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__SourceAssignment_7_in_rule__ModeTransitionInstance__Group__7__Impl5724);
            rule__ModeTransitionInstance__SourceAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getModeTransitionInstanceAccess().getSourceAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeTransitionInstance__Group__7__Impl"


    // $ANTLR start "rule__ModeTransitionInstance__Group__8"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2820:1: rule__ModeTransitionInstance__Group__8 : rule__ModeTransitionInstance__Group__8__Impl rule__ModeTransitionInstance__Group__9 ;
    public final void rule__ModeTransitionInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2824:1: ( rule__ModeTransitionInstance__Group__8__Impl rule__ModeTransitionInstance__Group__9 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2825:2: rule__ModeTransitionInstance__Group__8__Impl rule__ModeTransitionInstance__Group__9
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__8__Impl_in_rule__ModeTransitionInstance__Group__85754);
            rule__ModeTransitionInstance__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__9_in_rule__ModeTransitionInstance__Group__85757);
            rule__ModeTransitionInstance__Group__9();

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
    // $ANTLR end "rule__ModeTransitionInstance__Group__8"


    // $ANTLR start "rule__ModeTransitionInstance__Group__8__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2832:1: rule__ModeTransitionInstance__Group__8__Impl : ( 'dst' ) ;
    public final void rule__ModeTransitionInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2836:1: ( ( 'dst' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2837:1: ( 'dst' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2837:1: ( 'dst' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2838:1: 'dst'
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getDstKeyword_8()); 
            match(input,46,FOLLOW_46_in_rule__ModeTransitionInstance__Group__8__Impl5785); 
             after(grammarAccess.getModeTransitionInstanceAccess().getDstKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeTransitionInstance__Group__8__Impl"


    // $ANTLR start "rule__ModeTransitionInstance__Group__9"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2851:1: rule__ModeTransitionInstance__Group__9 : rule__ModeTransitionInstance__Group__9__Impl rule__ModeTransitionInstance__Group__10 ;
    public final void rule__ModeTransitionInstance__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2855:1: ( rule__ModeTransitionInstance__Group__9__Impl rule__ModeTransitionInstance__Group__10 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2856:2: rule__ModeTransitionInstance__Group__9__Impl rule__ModeTransitionInstance__Group__10
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__9__Impl_in_rule__ModeTransitionInstance__Group__95816);
            rule__ModeTransitionInstance__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__10_in_rule__ModeTransitionInstance__Group__95819);
            rule__ModeTransitionInstance__Group__10();

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
    // $ANTLR end "rule__ModeTransitionInstance__Group__9"


    // $ANTLR start "rule__ModeTransitionInstance__Group__9__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2863:1: rule__ModeTransitionInstance__Group__9__Impl : ( ( rule__ModeTransitionInstance__DestinationAssignment_9 ) ) ;
    public final void rule__ModeTransitionInstance__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2867:1: ( ( ( rule__ModeTransitionInstance__DestinationAssignment_9 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2868:1: ( ( rule__ModeTransitionInstance__DestinationAssignment_9 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2868:1: ( ( rule__ModeTransitionInstance__DestinationAssignment_9 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2869:1: ( rule__ModeTransitionInstance__DestinationAssignment_9 )
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getDestinationAssignment_9()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2870:1: ( rule__ModeTransitionInstance__DestinationAssignment_9 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2870:2: rule__ModeTransitionInstance__DestinationAssignment_9
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__DestinationAssignment_9_in_rule__ModeTransitionInstance__Group__9__Impl5846);
            rule__ModeTransitionInstance__DestinationAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getModeTransitionInstanceAccess().getDestinationAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeTransitionInstance__Group__9__Impl"


    // $ANTLR start "rule__ModeTransitionInstance__Group__10"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2880:1: rule__ModeTransitionInstance__Group__10 : rule__ModeTransitionInstance__Group__10__Impl ;
    public final void rule__ModeTransitionInstance__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2884:1: ( rule__ModeTransitionInstance__Group__10__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2885:2: rule__ModeTransitionInstance__Group__10__Impl
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__10__Impl_in_rule__ModeTransitionInstance__Group__105876);
            rule__ModeTransitionInstance__Group__10__Impl();

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
    // $ANTLR end "rule__ModeTransitionInstance__Group__10"


    // $ANTLR start "rule__ModeTransitionInstance__Group__10__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2891:1: rule__ModeTransitionInstance__Group__10__Impl : ( 'end' ) ;
    public final void rule__ModeTransitionInstance__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2895:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2896:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2896:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2897:1: 'end'
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getEndKeyword_10()); 
            match(input,39,FOLLOW_39_in_rule__ModeTransitionInstance__Group__10__Impl5904); 
             after(grammarAccess.getModeTransitionInstanceAccess().getEndKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeTransitionInstance__Group__10__Impl"


    // $ANTLR start "rule__FlowSpecInstance__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2932:1: rule__FlowSpecInstance__Group__0 : rule__FlowSpecInstance__Group__0__Impl rule__FlowSpecInstance__Group__1 ;
    public final void rule__FlowSpecInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2936:1: ( rule__FlowSpecInstance__Group__0__Impl rule__FlowSpecInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2937:2: rule__FlowSpecInstance__Group__0__Impl rule__FlowSpecInstance__Group__1
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__0__Impl_in_rule__FlowSpecInstance__Group__05957);
            rule__FlowSpecInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__1_in_rule__FlowSpecInstance__Group__05960);
            rule__FlowSpecInstance__Group__1();

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
    // $ANTLR end "rule__FlowSpecInstance__Group__0"


    // $ANTLR start "rule__FlowSpecInstance__Group__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2944:1: rule__FlowSpecInstance__Group__0__Impl : ( 'flowspec' ) ;
    public final void rule__FlowSpecInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2948:1: ( ( 'flowspec' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2949:1: ( 'flowspec' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2949:1: ( 'flowspec' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2950:1: 'flowspec'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getFlowspecKeyword_0()); 
            match(input,47,FOLLOW_47_in_rule__FlowSpecInstance__Group__0__Impl5988); 
             after(grammarAccess.getFlowSpecInstanceAccess().getFlowspecKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__Group__0__Impl"


    // $ANTLR start "rule__FlowSpecInstance__Group__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2963:1: rule__FlowSpecInstance__Group__1 : rule__FlowSpecInstance__Group__1__Impl rule__FlowSpecInstance__Group__2 ;
    public final void rule__FlowSpecInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2967:1: ( rule__FlowSpecInstance__Group__1__Impl rule__FlowSpecInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2968:2: rule__FlowSpecInstance__Group__1__Impl rule__FlowSpecInstance__Group__2
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__1__Impl_in_rule__FlowSpecInstance__Group__16019);
            rule__FlowSpecInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__2_in_rule__FlowSpecInstance__Group__16022);
            rule__FlowSpecInstance__Group__2();

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
    // $ANTLR end "rule__FlowSpecInstance__Group__1"


    // $ANTLR start "rule__FlowSpecInstance__Group__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2975:1: rule__FlowSpecInstance__Group__1__Impl : ( 'instance' ) ;
    public final void rule__FlowSpecInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2979:1: ( ( 'instance' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2980:1: ( 'instance' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2980:1: ( 'instance' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2981:1: 'instance'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInstanceKeyword_1()); 
            match(input,40,FOLLOW_40_in_rule__FlowSpecInstance__Group__1__Impl6050); 
             after(grammarAccess.getFlowSpecInstanceAccess().getInstanceKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__Group__1__Impl"


    // $ANTLR start "rule__FlowSpecInstance__Group__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2994:1: rule__FlowSpecInstance__Group__2 : rule__FlowSpecInstance__Group__2__Impl rule__FlowSpecInstance__Group__3 ;
    public final void rule__FlowSpecInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2998:1: ( rule__FlowSpecInstance__Group__2__Impl rule__FlowSpecInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2999:2: rule__FlowSpecInstance__Group__2__Impl rule__FlowSpecInstance__Group__3
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__2__Impl_in_rule__FlowSpecInstance__Group__26081);
            rule__FlowSpecInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__3_in_rule__FlowSpecInstance__Group__26084);
            rule__FlowSpecInstance__Group__3();

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
    // $ANTLR end "rule__FlowSpecInstance__Group__2"


    // $ANTLR start "rule__FlowSpecInstance__Group__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3006:1: rule__FlowSpecInstance__Group__2__Impl : ( ( rule__FlowSpecInstance__NameAssignment_2 ) ) ;
    public final void rule__FlowSpecInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3010:1: ( ( ( rule__FlowSpecInstance__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3011:1: ( ( rule__FlowSpecInstance__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3011:1: ( ( rule__FlowSpecInstance__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3012:1: ( rule__FlowSpecInstance__NameAssignment_2 )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3013:1: ( rule__FlowSpecInstance__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3013:2: rule__FlowSpecInstance__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__NameAssignment_2_in_rule__FlowSpecInstance__Group__2__Impl6111);
            rule__FlowSpecInstance__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFlowSpecInstanceAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__Group__2__Impl"


    // $ANTLR start "rule__FlowSpecInstance__Group__3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3023:1: rule__FlowSpecInstance__Group__3 : rule__FlowSpecInstance__Group__3__Impl rule__FlowSpecInstance__Group__4 ;
    public final void rule__FlowSpecInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3027:1: ( rule__FlowSpecInstance__Group__3__Impl rule__FlowSpecInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3028:2: rule__FlowSpecInstance__Group__3__Impl rule__FlowSpecInstance__Group__4
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__3__Impl_in_rule__FlowSpecInstance__Group__36141);
            rule__FlowSpecInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__4_in_rule__FlowSpecInstance__Group__36144);
            rule__FlowSpecInstance__Group__4();

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
    // $ANTLR end "rule__FlowSpecInstance__Group__3"


    // $ANTLR start "rule__FlowSpecInstance__Group__3__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3035:1: rule__FlowSpecInstance__Group__3__Impl : ( 'of' ) ;
    public final void rule__FlowSpecInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3039:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3040:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3040:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3041:1: 'of'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getOfKeyword_3()); 
            match(input,38,FOLLOW_38_in_rule__FlowSpecInstance__Group__3__Impl6172); 
             after(grammarAccess.getFlowSpecInstanceAccess().getOfKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__Group__3__Impl"


    // $ANTLR start "rule__FlowSpecInstance__Group__4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3054:1: rule__FlowSpecInstance__Group__4 : rule__FlowSpecInstance__Group__4__Impl rule__FlowSpecInstance__Group__5 ;
    public final void rule__FlowSpecInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3058:1: ( rule__FlowSpecInstance__Group__4__Impl rule__FlowSpecInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3059:2: rule__FlowSpecInstance__Group__4__Impl rule__FlowSpecInstance__Group__5
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__4__Impl_in_rule__FlowSpecInstance__Group__46203);
            rule__FlowSpecInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__5_in_rule__FlowSpecInstance__Group__46206);
            rule__FlowSpecInstance__Group__5();

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
    // $ANTLR end "rule__FlowSpecInstance__Group__4"


    // $ANTLR start "rule__FlowSpecInstance__Group__4__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3066:1: rule__FlowSpecInstance__Group__4__Impl : ( ( rule__FlowSpecInstance__FlowSpecificationAssignment_4 ) ) ;
    public final void rule__FlowSpecInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3070:1: ( ( ( rule__FlowSpecInstance__FlowSpecificationAssignment_4 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3071:1: ( ( rule__FlowSpecInstance__FlowSpecificationAssignment_4 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3071:1: ( ( rule__FlowSpecInstance__FlowSpecificationAssignment_4 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3072:1: ( rule__FlowSpecInstance__FlowSpecificationAssignment_4 )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getFlowSpecificationAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3073:1: ( rule__FlowSpecInstance__FlowSpecificationAssignment_4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3073:2: rule__FlowSpecInstance__FlowSpecificationAssignment_4
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__FlowSpecificationAssignment_4_in_rule__FlowSpecInstance__Group__4__Impl6233);
            rule__FlowSpecInstance__FlowSpecificationAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getFlowSpecInstanceAccess().getFlowSpecificationAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__Group__4__Impl"


    // $ANTLR start "rule__FlowSpecInstance__Group__5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3083:1: rule__FlowSpecInstance__Group__5 : rule__FlowSpecInstance__Group__5__Impl rule__FlowSpecInstance__Group__6 ;
    public final void rule__FlowSpecInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3087:1: ( rule__FlowSpecInstance__Group__5__Impl rule__FlowSpecInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3088:2: rule__FlowSpecInstance__Group__5__Impl rule__FlowSpecInstance__Group__6
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__5__Impl_in_rule__FlowSpecInstance__Group__56263);
            rule__FlowSpecInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__6_in_rule__FlowSpecInstance__Group__56266);
            rule__FlowSpecInstance__Group__6();

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
    // $ANTLR end "rule__FlowSpecInstance__Group__5"


    // $ANTLR start "rule__FlowSpecInstance__Group__5__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3095:1: rule__FlowSpecInstance__Group__5__Impl : ( ( rule__FlowSpecInstance__Group_5__0 )? ) ;
    public final void rule__FlowSpecInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3099:1: ( ( ( rule__FlowSpecInstance__Group_5__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3100:1: ( ( rule__FlowSpecInstance__Group_5__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3100:1: ( ( rule__FlowSpecInstance__Group_5__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3101:1: ( rule__FlowSpecInstance__Group_5__0 )?
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getGroup_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3102:1: ( rule__FlowSpecInstance__Group_5__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==45) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3102:2: rule__FlowSpecInstance__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__FlowSpecInstance__Group_5__0_in_rule__FlowSpecInstance__Group__5__Impl6293);
                    rule__FlowSpecInstance__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFlowSpecInstanceAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__Group__5__Impl"


    // $ANTLR start "rule__FlowSpecInstance__Group__6"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3112:1: rule__FlowSpecInstance__Group__6 : rule__FlowSpecInstance__Group__6__Impl rule__FlowSpecInstance__Group__7 ;
    public final void rule__FlowSpecInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3116:1: ( rule__FlowSpecInstance__Group__6__Impl rule__FlowSpecInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3117:2: rule__FlowSpecInstance__Group__6__Impl rule__FlowSpecInstance__Group__7
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__6__Impl_in_rule__FlowSpecInstance__Group__66324);
            rule__FlowSpecInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__7_in_rule__FlowSpecInstance__Group__66327);
            rule__FlowSpecInstance__Group__7();

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
    // $ANTLR end "rule__FlowSpecInstance__Group__6"


    // $ANTLR start "rule__FlowSpecInstance__Group__6__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3124:1: rule__FlowSpecInstance__Group__6__Impl : ( ( rule__FlowSpecInstance__Group_6__0 )? ) ;
    public final void rule__FlowSpecInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3128:1: ( ( ( rule__FlowSpecInstance__Group_6__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3129:1: ( ( rule__FlowSpecInstance__Group_6__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3129:1: ( ( rule__FlowSpecInstance__Group_6__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3130:1: ( rule__FlowSpecInstance__Group_6__0 )?
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getGroup_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3131:1: ( rule__FlowSpecInstance__Group_6__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==46) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3131:2: rule__FlowSpecInstance__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__FlowSpecInstance__Group_6__0_in_rule__FlowSpecInstance__Group__6__Impl6354);
                    rule__FlowSpecInstance__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFlowSpecInstanceAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__Group__6__Impl"


    // $ANTLR start "rule__FlowSpecInstance__Group__7"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3141:1: rule__FlowSpecInstance__Group__7 : rule__FlowSpecInstance__Group__7__Impl rule__FlowSpecInstance__Group__8 ;
    public final void rule__FlowSpecInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3145:1: ( rule__FlowSpecInstance__Group__7__Impl rule__FlowSpecInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3146:2: rule__FlowSpecInstance__Group__7__Impl rule__FlowSpecInstance__Group__8
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__7__Impl_in_rule__FlowSpecInstance__Group__76385);
            rule__FlowSpecInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__8_in_rule__FlowSpecInstance__Group__76388);
            rule__FlowSpecInstance__Group__8();

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
    // $ANTLR end "rule__FlowSpecInstance__Group__7"


    // $ANTLR start "rule__FlowSpecInstance__Group__7__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3153:1: rule__FlowSpecInstance__Group__7__Impl : ( ( rule__FlowSpecInstance__Group_7__0 )? ) ;
    public final void rule__FlowSpecInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3157:1: ( ( ( rule__FlowSpecInstance__Group_7__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3158:1: ( ( rule__FlowSpecInstance__Group_7__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3158:1: ( ( rule__FlowSpecInstance__Group_7__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3159:1: ( rule__FlowSpecInstance__Group_7__0 )?
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getGroup_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3160:1: ( rule__FlowSpecInstance__Group_7__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==30) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==43) ) {
                    alt27=1;
                }
            }
            switch (alt27) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3160:2: rule__FlowSpecInstance__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__FlowSpecInstance__Group_7__0_in_rule__FlowSpecInstance__Group__7__Impl6415);
                    rule__FlowSpecInstance__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFlowSpecInstanceAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__Group__7__Impl"


    // $ANTLR start "rule__FlowSpecInstance__Group__8"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3170:1: rule__FlowSpecInstance__Group__8 : rule__FlowSpecInstance__Group__8__Impl rule__FlowSpecInstance__Group__9 ;
    public final void rule__FlowSpecInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3174:1: ( rule__FlowSpecInstance__Group__8__Impl rule__FlowSpecInstance__Group__9 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3175:2: rule__FlowSpecInstance__Group__8__Impl rule__FlowSpecInstance__Group__9
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__8__Impl_in_rule__FlowSpecInstance__Group__86446);
            rule__FlowSpecInstance__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__9_in_rule__FlowSpecInstance__Group__86449);
            rule__FlowSpecInstance__Group__9();

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
    // $ANTLR end "rule__FlowSpecInstance__Group__8"


    // $ANTLR start "rule__FlowSpecInstance__Group__8__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3182:1: rule__FlowSpecInstance__Group__8__Impl : ( ( rule__FlowSpecInstance__Group_8__0 )? ) ;
    public final void rule__FlowSpecInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3186:1: ( ( ( rule__FlowSpecInstance__Group_8__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3187:1: ( ( rule__FlowSpecInstance__Group_8__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3187:1: ( ( rule__FlowSpecInstance__Group_8__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3188:1: ( rule__FlowSpecInstance__Group_8__0 )?
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getGroup_8()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3189:1: ( rule__FlowSpecInstance__Group_8__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==30) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3189:2: rule__FlowSpecInstance__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__FlowSpecInstance__Group_8__0_in_rule__FlowSpecInstance__Group__8__Impl6476);
                    rule__FlowSpecInstance__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFlowSpecInstanceAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__Group__8__Impl"


    // $ANTLR start "rule__FlowSpecInstance__Group__9"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3199:1: rule__FlowSpecInstance__Group__9 : rule__FlowSpecInstance__Group__9__Impl ;
    public final void rule__FlowSpecInstance__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3203:1: ( rule__FlowSpecInstance__Group__9__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3204:2: rule__FlowSpecInstance__Group__9__Impl
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__9__Impl_in_rule__FlowSpecInstance__Group__96507);
            rule__FlowSpecInstance__Group__9__Impl();

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
    // $ANTLR end "rule__FlowSpecInstance__Group__9"


    // $ANTLR start "rule__FlowSpecInstance__Group__9__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3210:1: rule__FlowSpecInstance__Group__9__Impl : ( 'end' ) ;
    public final void rule__FlowSpecInstance__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3214:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3215:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3215:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3216:1: 'end'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getEndKeyword_9()); 
            match(input,39,FOLLOW_39_in_rule__FlowSpecInstance__Group__9__Impl6535); 
             after(grammarAccess.getFlowSpecInstanceAccess().getEndKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__Group__9__Impl"


    // $ANTLR start "rule__FlowSpecInstance__Group_5__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3249:1: rule__FlowSpecInstance__Group_5__0 : rule__FlowSpecInstance__Group_5__0__Impl rule__FlowSpecInstance__Group_5__1 ;
    public final void rule__FlowSpecInstance__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3253:1: ( rule__FlowSpecInstance__Group_5__0__Impl rule__FlowSpecInstance__Group_5__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3254:2: rule__FlowSpecInstance__Group_5__0__Impl rule__FlowSpecInstance__Group_5__1
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_5__0__Impl_in_rule__FlowSpecInstance__Group_5__06586);
            rule__FlowSpecInstance__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_5__1_in_rule__FlowSpecInstance__Group_5__06589);
            rule__FlowSpecInstance__Group_5__1();

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
    // $ANTLR end "rule__FlowSpecInstance__Group_5__0"


    // $ANTLR start "rule__FlowSpecInstance__Group_5__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3261:1: rule__FlowSpecInstance__Group_5__0__Impl : ( 'src' ) ;
    public final void rule__FlowSpecInstance__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3265:1: ( ( 'src' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3266:1: ( 'src' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3266:1: ( 'src' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3267:1: 'src'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getSrcKeyword_5_0()); 
            match(input,45,FOLLOW_45_in_rule__FlowSpecInstance__Group_5__0__Impl6617); 
             after(grammarAccess.getFlowSpecInstanceAccess().getSrcKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__Group_5__0__Impl"


    // $ANTLR start "rule__FlowSpecInstance__Group_5__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3280:1: rule__FlowSpecInstance__Group_5__1 : rule__FlowSpecInstance__Group_5__1__Impl ;
    public final void rule__FlowSpecInstance__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3284:1: ( rule__FlowSpecInstance__Group_5__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3285:2: rule__FlowSpecInstance__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_5__1__Impl_in_rule__FlowSpecInstance__Group_5__16648);
            rule__FlowSpecInstance__Group_5__1__Impl();

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
    // $ANTLR end "rule__FlowSpecInstance__Group_5__1"


    // $ANTLR start "rule__FlowSpecInstance__Group_5__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3291:1: rule__FlowSpecInstance__Group_5__1__Impl : ( ( rule__FlowSpecInstance__SourceAssignment_5_1 ) ) ;
    public final void rule__FlowSpecInstance__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3295:1: ( ( ( rule__FlowSpecInstance__SourceAssignment_5_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3296:1: ( ( rule__FlowSpecInstance__SourceAssignment_5_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3296:1: ( ( rule__FlowSpecInstance__SourceAssignment_5_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3297:1: ( rule__FlowSpecInstance__SourceAssignment_5_1 )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getSourceAssignment_5_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3298:1: ( rule__FlowSpecInstance__SourceAssignment_5_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3298:2: rule__FlowSpecInstance__SourceAssignment_5_1
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__SourceAssignment_5_1_in_rule__FlowSpecInstance__Group_5__1__Impl6675);
            rule__FlowSpecInstance__SourceAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getFlowSpecInstanceAccess().getSourceAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__Group_5__1__Impl"


    // $ANTLR start "rule__FlowSpecInstance__Group_6__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3312:1: rule__FlowSpecInstance__Group_6__0 : rule__FlowSpecInstance__Group_6__0__Impl rule__FlowSpecInstance__Group_6__1 ;
    public final void rule__FlowSpecInstance__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3316:1: ( rule__FlowSpecInstance__Group_6__0__Impl rule__FlowSpecInstance__Group_6__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3317:2: rule__FlowSpecInstance__Group_6__0__Impl rule__FlowSpecInstance__Group_6__1
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_6__0__Impl_in_rule__FlowSpecInstance__Group_6__06709);
            rule__FlowSpecInstance__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_6__1_in_rule__FlowSpecInstance__Group_6__06712);
            rule__FlowSpecInstance__Group_6__1();

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
    // $ANTLR end "rule__FlowSpecInstance__Group_6__0"


    // $ANTLR start "rule__FlowSpecInstance__Group_6__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3324:1: rule__FlowSpecInstance__Group_6__0__Impl : ( 'dst' ) ;
    public final void rule__FlowSpecInstance__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3328:1: ( ( 'dst' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3329:1: ( 'dst' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3329:1: ( 'dst' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3330:1: 'dst'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getDstKeyword_6_0()); 
            match(input,46,FOLLOW_46_in_rule__FlowSpecInstance__Group_6__0__Impl6740); 
             after(grammarAccess.getFlowSpecInstanceAccess().getDstKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__Group_6__0__Impl"


    // $ANTLR start "rule__FlowSpecInstance__Group_6__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3343:1: rule__FlowSpecInstance__Group_6__1 : rule__FlowSpecInstance__Group_6__1__Impl ;
    public final void rule__FlowSpecInstance__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3347:1: ( rule__FlowSpecInstance__Group_6__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3348:2: rule__FlowSpecInstance__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_6__1__Impl_in_rule__FlowSpecInstance__Group_6__16771);
            rule__FlowSpecInstance__Group_6__1__Impl();

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
    // $ANTLR end "rule__FlowSpecInstance__Group_6__1"


    // $ANTLR start "rule__FlowSpecInstance__Group_6__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3354:1: rule__FlowSpecInstance__Group_6__1__Impl : ( ( rule__FlowSpecInstance__DestinationAssignment_6_1 ) ) ;
    public final void rule__FlowSpecInstance__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3358:1: ( ( ( rule__FlowSpecInstance__DestinationAssignment_6_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3359:1: ( ( rule__FlowSpecInstance__DestinationAssignment_6_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3359:1: ( ( rule__FlowSpecInstance__DestinationAssignment_6_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3360:1: ( rule__FlowSpecInstance__DestinationAssignment_6_1 )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getDestinationAssignment_6_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3361:1: ( rule__FlowSpecInstance__DestinationAssignment_6_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3361:2: rule__FlowSpecInstance__DestinationAssignment_6_1
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__DestinationAssignment_6_1_in_rule__FlowSpecInstance__Group_6__1__Impl6798);
            rule__FlowSpecInstance__DestinationAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getFlowSpecInstanceAccess().getDestinationAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__Group_6__1__Impl"


    // $ANTLR start "rule__FlowSpecInstance__Group_7__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3375:1: rule__FlowSpecInstance__Group_7__0 : rule__FlowSpecInstance__Group_7__0__Impl rule__FlowSpecInstance__Group_7__1 ;
    public final void rule__FlowSpecInstance__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3379:1: ( rule__FlowSpecInstance__Group_7__0__Impl rule__FlowSpecInstance__Group_7__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3380:2: rule__FlowSpecInstance__Group_7__0__Impl rule__FlowSpecInstance__Group_7__1
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_7__0__Impl_in_rule__FlowSpecInstance__Group_7__06832);
            rule__FlowSpecInstance__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_7__1_in_rule__FlowSpecInstance__Group_7__06835);
            rule__FlowSpecInstance__Group_7__1();

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
    // $ANTLR end "rule__FlowSpecInstance__Group_7__0"


    // $ANTLR start "rule__FlowSpecInstance__Group_7__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3387:1: rule__FlowSpecInstance__Group_7__0__Impl : ( 'in' ) ;
    public final void rule__FlowSpecInstance__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3391:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3392:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3392:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3393:1: 'in'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInKeyword_7_0()); 
            match(input,30,FOLLOW_30_in_rule__FlowSpecInstance__Group_7__0__Impl6863); 
             after(grammarAccess.getFlowSpecInstanceAccess().getInKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__Group_7__0__Impl"


    // $ANTLR start "rule__FlowSpecInstance__Group_7__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3406:1: rule__FlowSpecInstance__Group_7__1 : rule__FlowSpecInstance__Group_7__1__Impl rule__FlowSpecInstance__Group_7__2 ;
    public final void rule__FlowSpecInstance__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3410:1: ( rule__FlowSpecInstance__Group_7__1__Impl rule__FlowSpecInstance__Group_7__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3411:2: rule__FlowSpecInstance__Group_7__1__Impl rule__FlowSpecInstance__Group_7__2
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_7__1__Impl_in_rule__FlowSpecInstance__Group_7__16894);
            rule__FlowSpecInstance__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_7__2_in_rule__FlowSpecInstance__Group_7__16897);
            rule__FlowSpecInstance__Group_7__2();

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
    // $ANTLR end "rule__FlowSpecInstance__Group_7__1"


    // $ANTLR start "rule__FlowSpecInstance__Group_7__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3418:1: rule__FlowSpecInstance__Group_7__1__Impl : ( 'mode' ) ;
    public final void rule__FlowSpecInstance__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3422:1: ( ( 'mode' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3423:1: ( 'mode' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3423:1: ( 'mode' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3424:1: 'mode'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getModeKeyword_7_1()); 
            match(input,43,FOLLOW_43_in_rule__FlowSpecInstance__Group_7__1__Impl6925); 
             after(grammarAccess.getFlowSpecInstanceAccess().getModeKeyword_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__Group_7__1__Impl"


    // $ANTLR start "rule__FlowSpecInstance__Group_7__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3437:1: rule__FlowSpecInstance__Group_7__2 : rule__FlowSpecInstance__Group_7__2__Impl ;
    public final void rule__FlowSpecInstance__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3441:1: ( rule__FlowSpecInstance__Group_7__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3442:2: rule__FlowSpecInstance__Group_7__2__Impl
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_7__2__Impl_in_rule__FlowSpecInstance__Group_7__26956);
            rule__FlowSpecInstance__Group_7__2__Impl();

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
    // $ANTLR end "rule__FlowSpecInstance__Group_7__2"


    // $ANTLR start "rule__FlowSpecInstance__Group_7__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3448:1: rule__FlowSpecInstance__Group_7__2__Impl : ( ( rule__FlowSpecInstance__InModeAssignment_7_2 ) ) ;
    public final void rule__FlowSpecInstance__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3452:1: ( ( ( rule__FlowSpecInstance__InModeAssignment_7_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3453:1: ( ( rule__FlowSpecInstance__InModeAssignment_7_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3453:1: ( ( rule__FlowSpecInstance__InModeAssignment_7_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3454:1: ( rule__FlowSpecInstance__InModeAssignment_7_2 )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInModeAssignment_7_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3455:1: ( rule__FlowSpecInstance__InModeAssignment_7_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3455:2: rule__FlowSpecInstance__InModeAssignment_7_2
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__InModeAssignment_7_2_in_rule__FlowSpecInstance__Group_7__2__Impl6983);
            rule__FlowSpecInstance__InModeAssignment_7_2();

            state._fsp--;


            }

             after(grammarAccess.getFlowSpecInstanceAccess().getInModeAssignment_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__Group_7__2__Impl"


    // $ANTLR start "rule__FlowSpecInstance__Group_8__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3471:1: rule__FlowSpecInstance__Group_8__0 : rule__FlowSpecInstance__Group_8__0__Impl rule__FlowSpecInstance__Group_8__1 ;
    public final void rule__FlowSpecInstance__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3475:1: ( rule__FlowSpecInstance__Group_8__0__Impl rule__FlowSpecInstance__Group_8__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3476:2: rule__FlowSpecInstance__Group_8__0__Impl rule__FlowSpecInstance__Group_8__1
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_8__0__Impl_in_rule__FlowSpecInstance__Group_8__07019);
            rule__FlowSpecInstance__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_8__1_in_rule__FlowSpecInstance__Group_8__07022);
            rule__FlowSpecInstance__Group_8__1();

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
    // $ANTLR end "rule__FlowSpecInstance__Group_8__0"


    // $ANTLR start "rule__FlowSpecInstance__Group_8__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3483:1: rule__FlowSpecInstance__Group_8__0__Impl : ( 'in' ) ;
    public final void rule__FlowSpecInstance__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3487:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3488:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3488:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3489:1: 'in'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInKeyword_8_0()); 
            match(input,30,FOLLOW_30_in_rule__FlowSpecInstance__Group_8__0__Impl7050); 
             after(grammarAccess.getFlowSpecInstanceAccess().getInKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__Group_8__0__Impl"


    // $ANTLR start "rule__FlowSpecInstance__Group_8__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3502:1: rule__FlowSpecInstance__Group_8__1 : rule__FlowSpecInstance__Group_8__1__Impl rule__FlowSpecInstance__Group_8__2 ;
    public final void rule__FlowSpecInstance__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3506:1: ( rule__FlowSpecInstance__Group_8__1__Impl rule__FlowSpecInstance__Group_8__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3507:2: rule__FlowSpecInstance__Group_8__1__Impl rule__FlowSpecInstance__Group_8__2
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_8__1__Impl_in_rule__FlowSpecInstance__Group_8__17081);
            rule__FlowSpecInstance__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_8__2_in_rule__FlowSpecInstance__Group_8__17084);
            rule__FlowSpecInstance__Group_8__2();

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
    // $ANTLR end "rule__FlowSpecInstance__Group_8__1"


    // $ANTLR start "rule__FlowSpecInstance__Group_8__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3514:1: rule__FlowSpecInstance__Group_8__1__Impl : ( 'transition' ) ;
    public final void rule__FlowSpecInstance__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3518:1: ( ( 'transition' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3519:1: ( 'transition' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3519:1: ( 'transition' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3520:1: 'transition'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getTransitionKeyword_8_1()); 
            match(input,44,FOLLOW_44_in_rule__FlowSpecInstance__Group_8__1__Impl7112); 
             after(grammarAccess.getFlowSpecInstanceAccess().getTransitionKeyword_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__Group_8__1__Impl"


    // $ANTLR start "rule__FlowSpecInstance__Group_8__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3533:1: rule__FlowSpecInstance__Group_8__2 : rule__FlowSpecInstance__Group_8__2__Impl ;
    public final void rule__FlowSpecInstance__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3537:1: ( rule__FlowSpecInstance__Group_8__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3538:2: rule__FlowSpecInstance__Group_8__2__Impl
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_8__2__Impl_in_rule__FlowSpecInstance__Group_8__27143);
            rule__FlowSpecInstance__Group_8__2__Impl();

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
    // $ANTLR end "rule__FlowSpecInstance__Group_8__2"


    // $ANTLR start "rule__FlowSpecInstance__Group_8__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3544:1: rule__FlowSpecInstance__Group_8__2__Impl : ( ( rule__FlowSpecInstance__InModeTransitionAssignment_8_2 ) ) ;
    public final void rule__FlowSpecInstance__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3548:1: ( ( ( rule__FlowSpecInstance__InModeTransitionAssignment_8_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3549:1: ( ( rule__FlowSpecInstance__InModeTransitionAssignment_8_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3549:1: ( ( rule__FlowSpecInstance__InModeTransitionAssignment_8_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3550:1: ( rule__FlowSpecInstance__InModeTransitionAssignment_8_2 )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInModeTransitionAssignment_8_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3551:1: ( rule__FlowSpecInstance__InModeTransitionAssignment_8_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3551:2: rule__FlowSpecInstance__InModeTransitionAssignment_8_2
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__InModeTransitionAssignment_8_2_in_rule__FlowSpecInstance__Group_8__2__Impl7170);
            rule__FlowSpecInstance__InModeTransitionAssignment_8_2();

            state._fsp--;


            }

             after(grammarAccess.getFlowSpecInstanceAccess().getInModeTransitionAssignment_8_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__Group_8__2__Impl"


    // $ANTLR start "rule__EndToEndFlowInstance__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3567:1: rule__EndToEndFlowInstance__Group__0 : rule__EndToEndFlowInstance__Group__0__Impl rule__EndToEndFlowInstance__Group__1 ;
    public final void rule__EndToEndFlowInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3571:1: ( rule__EndToEndFlowInstance__Group__0__Impl rule__EndToEndFlowInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3572:2: rule__EndToEndFlowInstance__Group__0__Impl rule__EndToEndFlowInstance__Group__1
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__0__Impl_in_rule__EndToEndFlowInstance__Group__07206);
            rule__EndToEndFlowInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__1_in_rule__EndToEndFlowInstance__Group__07209);
            rule__EndToEndFlowInstance__Group__1();

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
    // $ANTLR end "rule__EndToEndFlowInstance__Group__0"


    // $ANTLR start "rule__EndToEndFlowInstance__Group__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3579:1: rule__EndToEndFlowInstance__Group__0__Impl : ( 'etef' ) ;
    public final void rule__EndToEndFlowInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3583:1: ( ( 'etef' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3584:1: ( 'etef' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3584:1: ( 'etef' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3585:1: 'etef'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getEtefKeyword_0()); 
            match(input,48,FOLLOW_48_in_rule__EndToEndFlowInstance__Group__0__Impl7237); 
             after(grammarAccess.getEndToEndFlowInstanceAccess().getEtefKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndToEndFlowInstance__Group__0__Impl"


    // $ANTLR start "rule__EndToEndFlowInstance__Group__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3598:1: rule__EndToEndFlowInstance__Group__1 : rule__EndToEndFlowInstance__Group__1__Impl rule__EndToEndFlowInstance__Group__2 ;
    public final void rule__EndToEndFlowInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3602:1: ( rule__EndToEndFlowInstance__Group__1__Impl rule__EndToEndFlowInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3603:2: rule__EndToEndFlowInstance__Group__1__Impl rule__EndToEndFlowInstance__Group__2
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__1__Impl_in_rule__EndToEndFlowInstance__Group__17268);
            rule__EndToEndFlowInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__2_in_rule__EndToEndFlowInstance__Group__17271);
            rule__EndToEndFlowInstance__Group__2();

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
    // $ANTLR end "rule__EndToEndFlowInstance__Group__1"


    // $ANTLR start "rule__EndToEndFlowInstance__Group__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3610:1: rule__EndToEndFlowInstance__Group__1__Impl : ( 'instance' ) ;
    public final void rule__EndToEndFlowInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3614:1: ( ( 'instance' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3615:1: ( 'instance' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3615:1: ( 'instance' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3616:1: 'instance'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInstanceKeyword_1()); 
            match(input,40,FOLLOW_40_in_rule__EndToEndFlowInstance__Group__1__Impl7299); 
             after(grammarAccess.getEndToEndFlowInstanceAccess().getInstanceKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndToEndFlowInstance__Group__1__Impl"


    // $ANTLR start "rule__EndToEndFlowInstance__Group__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3629:1: rule__EndToEndFlowInstance__Group__2 : rule__EndToEndFlowInstance__Group__2__Impl rule__EndToEndFlowInstance__Group__3 ;
    public final void rule__EndToEndFlowInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3633:1: ( rule__EndToEndFlowInstance__Group__2__Impl rule__EndToEndFlowInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3634:2: rule__EndToEndFlowInstance__Group__2__Impl rule__EndToEndFlowInstance__Group__3
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__2__Impl_in_rule__EndToEndFlowInstance__Group__27330);
            rule__EndToEndFlowInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__3_in_rule__EndToEndFlowInstance__Group__27333);
            rule__EndToEndFlowInstance__Group__3();

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
    // $ANTLR end "rule__EndToEndFlowInstance__Group__2"


    // $ANTLR start "rule__EndToEndFlowInstance__Group__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3641:1: rule__EndToEndFlowInstance__Group__2__Impl : ( ( rule__EndToEndFlowInstance__NameAssignment_2 ) ) ;
    public final void rule__EndToEndFlowInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3645:1: ( ( ( rule__EndToEndFlowInstance__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3646:1: ( ( rule__EndToEndFlowInstance__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3646:1: ( ( rule__EndToEndFlowInstance__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3647:1: ( rule__EndToEndFlowInstance__NameAssignment_2 )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3648:1: ( rule__EndToEndFlowInstance__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3648:2: rule__EndToEndFlowInstance__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__NameAssignment_2_in_rule__EndToEndFlowInstance__Group__2__Impl7360);
            rule__EndToEndFlowInstance__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEndToEndFlowInstanceAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndToEndFlowInstance__Group__2__Impl"


    // $ANTLR start "rule__EndToEndFlowInstance__Group__3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3658:1: rule__EndToEndFlowInstance__Group__3 : rule__EndToEndFlowInstance__Group__3__Impl rule__EndToEndFlowInstance__Group__4 ;
    public final void rule__EndToEndFlowInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3662:1: ( rule__EndToEndFlowInstance__Group__3__Impl rule__EndToEndFlowInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3663:2: rule__EndToEndFlowInstance__Group__3__Impl rule__EndToEndFlowInstance__Group__4
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__3__Impl_in_rule__EndToEndFlowInstance__Group__37390);
            rule__EndToEndFlowInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__4_in_rule__EndToEndFlowInstance__Group__37393);
            rule__EndToEndFlowInstance__Group__4();

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
    // $ANTLR end "rule__EndToEndFlowInstance__Group__3"


    // $ANTLR start "rule__EndToEndFlowInstance__Group__3__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3670:1: rule__EndToEndFlowInstance__Group__3__Impl : ( 'of' ) ;
    public final void rule__EndToEndFlowInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3674:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3675:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3675:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3676:1: 'of'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getOfKeyword_3()); 
            match(input,38,FOLLOW_38_in_rule__EndToEndFlowInstance__Group__3__Impl7421); 
             after(grammarAccess.getEndToEndFlowInstanceAccess().getOfKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndToEndFlowInstance__Group__3__Impl"


    // $ANTLR start "rule__EndToEndFlowInstance__Group__4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3689:1: rule__EndToEndFlowInstance__Group__4 : rule__EndToEndFlowInstance__Group__4__Impl rule__EndToEndFlowInstance__Group__5 ;
    public final void rule__EndToEndFlowInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3693:1: ( rule__EndToEndFlowInstance__Group__4__Impl rule__EndToEndFlowInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3694:2: rule__EndToEndFlowInstance__Group__4__Impl rule__EndToEndFlowInstance__Group__5
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__4__Impl_in_rule__EndToEndFlowInstance__Group__47452);
            rule__EndToEndFlowInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__5_in_rule__EndToEndFlowInstance__Group__47455);
            rule__EndToEndFlowInstance__Group__5();

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
    // $ANTLR end "rule__EndToEndFlowInstance__Group__4"


    // $ANTLR start "rule__EndToEndFlowInstance__Group__4__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3701:1: rule__EndToEndFlowInstance__Group__4__Impl : ( ( rule__EndToEndFlowInstance__EndToEndFlowAssignment_4 ) ) ;
    public final void rule__EndToEndFlowInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3705:1: ( ( ( rule__EndToEndFlowInstance__EndToEndFlowAssignment_4 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3706:1: ( ( rule__EndToEndFlowInstance__EndToEndFlowAssignment_4 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3706:1: ( ( rule__EndToEndFlowInstance__EndToEndFlowAssignment_4 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3707:1: ( rule__EndToEndFlowInstance__EndToEndFlowAssignment_4 )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3708:1: ( rule__EndToEndFlowInstance__EndToEndFlowAssignment_4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3708:2: rule__EndToEndFlowInstance__EndToEndFlowAssignment_4
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__EndToEndFlowAssignment_4_in_rule__EndToEndFlowInstance__Group__4__Impl7482);
            rule__EndToEndFlowInstance__EndToEndFlowAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndToEndFlowInstance__Group__4__Impl"


    // $ANTLR start "rule__EndToEndFlowInstance__Group__5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3718:1: rule__EndToEndFlowInstance__Group__5 : rule__EndToEndFlowInstance__Group__5__Impl rule__EndToEndFlowInstance__Group__6 ;
    public final void rule__EndToEndFlowInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3722:1: ( rule__EndToEndFlowInstance__Group__5__Impl rule__EndToEndFlowInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3723:2: rule__EndToEndFlowInstance__Group__5__Impl rule__EndToEndFlowInstance__Group__6
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__5__Impl_in_rule__EndToEndFlowInstance__Group__57512);
            rule__EndToEndFlowInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__6_in_rule__EndToEndFlowInstance__Group__57515);
            rule__EndToEndFlowInstance__Group__6();

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
    // $ANTLR end "rule__EndToEndFlowInstance__Group__5"


    // $ANTLR start "rule__EndToEndFlowInstance__Group__5__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3730:1: rule__EndToEndFlowInstance__Group__5__Impl : ( ( rule__EndToEndFlowInstance__FlowElementAssignment_5 )* ) ;
    public final void rule__EndToEndFlowInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3734:1: ( ( ( rule__EndToEndFlowInstance__FlowElementAssignment_5 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3735:1: ( ( rule__EndToEndFlowInstance__FlowElementAssignment_5 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3735:1: ( ( rule__EndToEndFlowInstance__FlowElementAssignment_5 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3736:1: ( rule__EndToEndFlowInstance__FlowElementAssignment_5 )*
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3737:1: ( rule__EndToEndFlowInstance__FlowElementAssignment_5 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_ID) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3737:2: rule__EndToEndFlowInstance__FlowElementAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__EndToEndFlowInstance__FlowElementAssignment_5_in_rule__EndToEndFlowInstance__Group__5__Impl7542);
            	    rule__EndToEndFlowInstance__FlowElementAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndToEndFlowInstance__Group__5__Impl"


    // $ANTLR start "rule__EndToEndFlowInstance__Group__6"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3747:1: rule__EndToEndFlowInstance__Group__6 : rule__EndToEndFlowInstance__Group__6__Impl rule__EndToEndFlowInstance__Group__7 ;
    public final void rule__EndToEndFlowInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3751:1: ( rule__EndToEndFlowInstance__Group__6__Impl rule__EndToEndFlowInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3752:2: rule__EndToEndFlowInstance__Group__6__Impl rule__EndToEndFlowInstance__Group__7
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__6__Impl_in_rule__EndToEndFlowInstance__Group__67573);
            rule__EndToEndFlowInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__7_in_rule__EndToEndFlowInstance__Group__67576);
            rule__EndToEndFlowInstance__Group__7();

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
    // $ANTLR end "rule__EndToEndFlowInstance__Group__6"


    // $ANTLR start "rule__EndToEndFlowInstance__Group__6__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3759:1: rule__EndToEndFlowInstance__Group__6__Impl : ( ( rule__EndToEndFlowInstance__Group_6__0 )? ) ;
    public final void rule__EndToEndFlowInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3763:1: ( ( ( rule__EndToEndFlowInstance__Group_6__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3764:1: ( ( rule__EndToEndFlowInstance__Group_6__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3764:1: ( ( rule__EndToEndFlowInstance__Group_6__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3765:1: ( rule__EndToEndFlowInstance__Group_6__0 )?
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3766:1: ( rule__EndToEndFlowInstance__Group_6__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==30) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==43) ) {
                    alt30=1;
                }
            }
            switch (alt30) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3766:2: rule__EndToEndFlowInstance__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_6__0_in_rule__EndToEndFlowInstance__Group__6__Impl7603);
                    rule__EndToEndFlowInstance__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndToEndFlowInstance__Group__6__Impl"


    // $ANTLR start "rule__EndToEndFlowInstance__Group__7"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3776:1: rule__EndToEndFlowInstance__Group__7 : rule__EndToEndFlowInstance__Group__7__Impl rule__EndToEndFlowInstance__Group__8 ;
    public final void rule__EndToEndFlowInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3780:1: ( rule__EndToEndFlowInstance__Group__7__Impl rule__EndToEndFlowInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3781:2: rule__EndToEndFlowInstance__Group__7__Impl rule__EndToEndFlowInstance__Group__8
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__7__Impl_in_rule__EndToEndFlowInstance__Group__77634);
            rule__EndToEndFlowInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__8_in_rule__EndToEndFlowInstance__Group__77637);
            rule__EndToEndFlowInstance__Group__8();

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
    // $ANTLR end "rule__EndToEndFlowInstance__Group__7"


    // $ANTLR start "rule__EndToEndFlowInstance__Group__7__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3788:1: rule__EndToEndFlowInstance__Group__7__Impl : ( ( rule__EndToEndFlowInstance__Group_7__0 )? ) ;
    public final void rule__EndToEndFlowInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3792:1: ( ( ( rule__EndToEndFlowInstance__Group_7__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3793:1: ( ( rule__EndToEndFlowInstance__Group_7__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3793:1: ( ( rule__EndToEndFlowInstance__Group_7__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3794:1: ( rule__EndToEndFlowInstance__Group_7__0 )?
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3795:1: ( rule__EndToEndFlowInstance__Group_7__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==30) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3795:2: rule__EndToEndFlowInstance__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_7__0_in_rule__EndToEndFlowInstance__Group__7__Impl7664);
                    rule__EndToEndFlowInstance__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndToEndFlowInstance__Group__7__Impl"


    // $ANTLR start "rule__EndToEndFlowInstance__Group__8"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3805:1: rule__EndToEndFlowInstance__Group__8 : rule__EndToEndFlowInstance__Group__8__Impl ;
    public final void rule__EndToEndFlowInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3809:1: ( rule__EndToEndFlowInstance__Group__8__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3810:2: rule__EndToEndFlowInstance__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__8__Impl_in_rule__EndToEndFlowInstance__Group__87695);
            rule__EndToEndFlowInstance__Group__8__Impl();

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
    // $ANTLR end "rule__EndToEndFlowInstance__Group__8"


    // $ANTLR start "rule__EndToEndFlowInstance__Group__8__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3816:1: rule__EndToEndFlowInstance__Group__8__Impl : ( 'end' ) ;
    public final void rule__EndToEndFlowInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3820:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3821:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3821:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3822:1: 'end'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_8()); 
            match(input,39,FOLLOW_39_in_rule__EndToEndFlowInstance__Group__8__Impl7723); 
             after(grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndToEndFlowInstance__Group__8__Impl"


    // $ANTLR start "rule__EndToEndFlowInstance__Group_6__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3853:1: rule__EndToEndFlowInstance__Group_6__0 : rule__EndToEndFlowInstance__Group_6__0__Impl rule__EndToEndFlowInstance__Group_6__1 ;
    public final void rule__EndToEndFlowInstance__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3857:1: ( rule__EndToEndFlowInstance__Group_6__0__Impl rule__EndToEndFlowInstance__Group_6__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3858:2: rule__EndToEndFlowInstance__Group_6__0__Impl rule__EndToEndFlowInstance__Group_6__1
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_6__0__Impl_in_rule__EndToEndFlowInstance__Group_6__07772);
            rule__EndToEndFlowInstance__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_6__1_in_rule__EndToEndFlowInstance__Group_6__07775);
            rule__EndToEndFlowInstance__Group_6__1();

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
    // $ANTLR end "rule__EndToEndFlowInstance__Group_6__0"


    // $ANTLR start "rule__EndToEndFlowInstance__Group_6__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3865:1: rule__EndToEndFlowInstance__Group_6__0__Impl : ( 'in' ) ;
    public final void rule__EndToEndFlowInstance__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3869:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3870:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3870:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3871:1: 'in'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInKeyword_6_0()); 
            match(input,30,FOLLOW_30_in_rule__EndToEndFlowInstance__Group_6__0__Impl7803); 
             after(grammarAccess.getEndToEndFlowInstanceAccess().getInKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndToEndFlowInstance__Group_6__0__Impl"


    // $ANTLR start "rule__EndToEndFlowInstance__Group_6__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3884:1: rule__EndToEndFlowInstance__Group_6__1 : rule__EndToEndFlowInstance__Group_6__1__Impl rule__EndToEndFlowInstance__Group_6__2 ;
    public final void rule__EndToEndFlowInstance__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3888:1: ( rule__EndToEndFlowInstance__Group_6__1__Impl rule__EndToEndFlowInstance__Group_6__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3889:2: rule__EndToEndFlowInstance__Group_6__1__Impl rule__EndToEndFlowInstance__Group_6__2
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_6__1__Impl_in_rule__EndToEndFlowInstance__Group_6__17834);
            rule__EndToEndFlowInstance__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_6__2_in_rule__EndToEndFlowInstance__Group_6__17837);
            rule__EndToEndFlowInstance__Group_6__2();

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
    // $ANTLR end "rule__EndToEndFlowInstance__Group_6__1"


    // $ANTLR start "rule__EndToEndFlowInstance__Group_6__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3896:1: rule__EndToEndFlowInstance__Group_6__1__Impl : ( 'mode' ) ;
    public final void rule__EndToEndFlowInstance__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3900:1: ( ( 'mode' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3901:1: ( 'mode' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3901:1: ( 'mode' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3902:1: 'mode'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getModeKeyword_6_1()); 
            match(input,43,FOLLOW_43_in_rule__EndToEndFlowInstance__Group_6__1__Impl7865); 
             after(grammarAccess.getEndToEndFlowInstanceAccess().getModeKeyword_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndToEndFlowInstance__Group_6__1__Impl"


    // $ANTLR start "rule__EndToEndFlowInstance__Group_6__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3915:1: rule__EndToEndFlowInstance__Group_6__2 : rule__EndToEndFlowInstance__Group_6__2__Impl ;
    public final void rule__EndToEndFlowInstance__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3919:1: ( rule__EndToEndFlowInstance__Group_6__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3920:2: rule__EndToEndFlowInstance__Group_6__2__Impl
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_6__2__Impl_in_rule__EndToEndFlowInstance__Group_6__27896);
            rule__EndToEndFlowInstance__Group_6__2__Impl();

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
    // $ANTLR end "rule__EndToEndFlowInstance__Group_6__2"


    // $ANTLR start "rule__EndToEndFlowInstance__Group_6__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3926:1: rule__EndToEndFlowInstance__Group_6__2__Impl : ( ( rule__EndToEndFlowInstance__InModeAssignment_6_2 ) ) ;
    public final void rule__EndToEndFlowInstance__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3930:1: ( ( ( rule__EndToEndFlowInstance__InModeAssignment_6_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3931:1: ( ( rule__EndToEndFlowInstance__InModeAssignment_6_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3931:1: ( ( rule__EndToEndFlowInstance__InModeAssignment_6_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3932:1: ( rule__EndToEndFlowInstance__InModeAssignment_6_2 )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInModeAssignment_6_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3933:1: ( rule__EndToEndFlowInstance__InModeAssignment_6_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3933:2: rule__EndToEndFlowInstance__InModeAssignment_6_2
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__InModeAssignment_6_2_in_rule__EndToEndFlowInstance__Group_6__2__Impl7923);
            rule__EndToEndFlowInstance__InModeAssignment_6_2();

            state._fsp--;


            }

             after(grammarAccess.getEndToEndFlowInstanceAccess().getInModeAssignment_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndToEndFlowInstance__Group_6__2__Impl"


    // $ANTLR start "rule__EndToEndFlowInstance__Group_7__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3949:1: rule__EndToEndFlowInstance__Group_7__0 : rule__EndToEndFlowInstance__Group_7__0__Impl rule__EndToEndFlowInstance__Group_7__1 ;
    public final void rule__EndToEndFlowInstance__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3953:1: ( rule__EndToEndFlowInstance__Group_7__0__Impl rule__EndToEndFlowInstance__Group_7__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3954:2: rule__EndToEndFlowInstance__Group_7__0__Impl rule__EndToEndFlowInstance__Group_7__1
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_7__0__Impl_in_rule__EndToEndFlowInstance__Group_7__07959);
            rule__EndToEndFlowInstance__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_7__1_in_rule__EndToEndFlowInstance__Group_7__07962);
            rule__EndToEndFlowInstance__Group_7__1();

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
    // $ANTLR end "rule__EndToEndFlowInstance__Group_7__0"


    // $ANTLR start "rule__EndToEndFlowInstance__Group_7__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3961:1: rule__EndToEndFlowInstance__Group_7__0__Impl : ( 'in' ) ;
    public final void rule__EndToEndFlowInstance__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3965:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3966:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3966:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3967:1: 'in'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInKeyword_7_0()); 
            match(input,30,FOLLOW_30_in_rule__EndToEndFlowInstance__Group_7__0__Impl7990); 
             after(grammarAccess.getEndToEndFlowInstanceAccess().getInKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndToEndFlowInstance__Group_7__0__Impl"


    // $ANTLR start "rule__EndToEndFlowInstance__Group_7__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3980:1: rule__EndToEndFlowInstance__Group_7__1 : rule__EndToEndFlowInstance__Group_7__1__Impl rule__EndToEndFlowInstance__Group_7__2 ;
    public final void rule__EndToEndFlowInstance__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3984:1: ( rule__EndToEndFlowInstance__Group_7__1__Impl rule__EndToEndFlowInstance__Group_7__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3985:2: rule__EndToEndFlowInstance__Group_7__1__Impl rule__EndToEndFlowInstance__Group_7__2
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_7__1__Impl_in_rule__EndToEndFlowInstance__Group_7__18021);
            rule__EndToEndFlowInstance__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_7__2_in_rule__EndToEndFlowInstance__Group_7__18024);
            rule__EndToEndFlowInstance__Group_7__2();

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
    // $ANTLR end "rule__EndToEndFlowInstance__Group_7__1"


    // $ANTLR start "rule__EndToEndFlowInstance__Group_7__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3992:1: rule__EndToEndFlowInstance__Group_7__1__Impl : ( 'som' ) ;
    public final void rule__EndToEndFlowInstance__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3996:1: ( ( 'som' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3997:1: ( 'som' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3997:1: ( 'som' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3998:1: 'som'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getSomKeyword_7_1()); 
            match(input,49,FOLLOW_49_in_rule__EndToEndFlowInstance__Group_7__1__Impl8052); 
             after(grammarAccess.getEndToEndFlowInstanceAccess().getSomKeyword_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndToEndFlowInstance__Group_7__1__Impl"


    // $ANTLR start "rule__EndToEndFlowInstance__Group_7__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4011:1: rule__EndToEndFlowInstance__Group_7__2 : rule__EndToEndFlowInstance__Group_7__2__Impl ;
    public final void rule__EndToEndFlowInstance__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4015:1: ( rule__EndToEndFlowInstance__Group_7__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4016:2: rule__EndToEndFlowInstance__Group_7__2__Impl
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_7__2__Impl_in_rule__EndToEndFlowInstance__Group_7__28083);
            rule__EndToEndFlowInstance__Group_7__2__Impl();

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
    // $ANTLR end "rule__EndToEndFlowInstance__Group_7__2"


    // $ANTLR start "rule__EndToEndFlowInstance__Group_7__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4022:1: rule__EndToEndFlowInstance__Group_7__2__Impl : ( ( rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2 ) ) ;
    public final void rule__EndToEndFlowInstance__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4026:1: ( ( ( rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4027:1: ( ( rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4027:1: ( ( rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4028:1: ( rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2 )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeAssignment_7_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4029:1: ( rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4029:2: rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2_in_rule__EndToEndFlowInstance__Group_7__2__Impl8110);
            rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2();

            state._fsp--;


            }

             after(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeAssignment_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndToEndFlowInstance__Group_7__2__Impl"


    // $ANTLR start "rule__SystemOperationMode__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4045:1: rule__SystemOperationMode__Group__0 : rule__SystemOperationMode__Group__0__Impl rule__SystemOperationMode__Group__1 ;
    public final void rule__SystemOperationMode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4049:1: ( rule__SystemOperationMode__Group__0__Impl rule__SystemOperationMode__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4050:2: rule__SystemOperationMode__Group__0__Impl rule__SystemOperationMode__Group__1
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__Group__0__Impl_in_rule__SystemOperationMode__Group__08146);
            rule__SystemOperationMode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemOperationMode__Group__1_in_rule__SystemOperationMode__Group__08149);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4057:1: rule__SystemOperationMode__Group__0__Impl : ( 'som' ) ;
    public final void rule__SystemOperationMode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4061:1: ( ( 'som' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4062:1: ( 'som' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4062:1: ( 'som' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4063:1: 'som'
            {
             before(grammarAccess.getSystemOperationModeAccess().getSomKeyword_0()); 
            match(input,49,FOLLOW_49_in_rule__SystemOperationMode__Group__0__Impl8177); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4076:1: rule__SystemOperationMode__Group__1 : rule__SystemOperationMode__Group__1__Impl rule__SystemOperationMode__Group__2 ;
    public final void rule__SystemOperationMode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4080:1: ( rule__SystemOperationMode__Group__1__Impl rule__SystemOperationMode__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4081:2: rule__SystemOperationMode__Group__1__Impl rule__SystemOperationMode__Group__2
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__Group__1__Impl_in_rule__SystemOperationMode__Group__18208);
            rule__SystemOperationMode__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemOperationMode__Group__2_in_rule__SystemOperationMode__Group__18211);
            rule__SystemOperationMode__Group__2();

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4088:1: rule__SystemOperationMode__Group__1__Impl : ( ( rule__SystemOperationMode__NameAssignment_1 ) ) ;
    public final void rule__SystemOperationMode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4092:1: ( ( ( rule__SystemOperationMode__NameAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4093:1: ( ( rule__SystemOperationMode__NameAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4093:1: ( ( rule__SystemOperationMode__NameAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4094:1: ( rule__SystemOperationMode__NameAssignment_1 )
            {
             before(grammarAccess.getSystemOperationModeAccess().getNameAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4095:1: ( rule__SystemOperationMode__NameAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4095:2: rule__SystemOperationMode__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__NameAssignment_1_in_rule__SystemOperationMode__Group__1__Impl8238);
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


    // $ANTLR start "rule__SystemOperationMode__Group__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4105:1: rule__SystemOperationMode__Group__2 : rule__SystemOperationMode__Group__2__Impl rule__SystemOperationMode__Group__3 ;
    public final void rule__SystemOperationMode__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4109:1: ( rule__SystemOperationMode__Group__2__Impl rule__SystemOperationMode__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4110:2: rule__SystemOperationMode__Group__2__Impl rule__SystemOperationMode__Group__3
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__Group__2__Impl_in_rule__SystemOperationMode__Group__28268);
            rule__SystemOperationMode__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemOperationMode__Group__3_in_rule__SystemOperationMode__Group__28271);
            rule__SystemOperationMode__Group__3();

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
    // $ANTLR end "rule__SystemOperationMode__Group__2"


    // $ANTLR start "rule__SystemOperationMode__Group__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4117:1: rule__SystemOperationMode__Group__2__Impl : ( ( rule__SystemOperationMode__CurrentModeAssignment_2 ) ) ;
    public final void rule__SystemOperationMode__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4121:1: ( ( ( rule__SystemOperationMode__CurrentModeAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4122:1: ( ( rule__SystemOperationMode__CurrentModeAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4122:1: ( ( rule__SystemOperationMode__CurrentModeAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4123:1: ( rule__SystemOperationMode__CurrentModeAssignment_2 )
            {
             before(grammarAccess.getSystemOperationModeAccess().getCurrentModeAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4124:1: ( rule__SystemOperationMode__CurrentModeAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4124:2: rule__SystemOperationMode__CurrentModeAssignment_2
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__CurrentModeAssignment_2_in_rule__SystemOperationMode__Group__2__Impl8298);
            rule__SystemOperationMode__CurrentModeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSystemOperationModeAccess().getCurrentModeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemOperationMode__Group__2__Impl"


    // $ANTLR start "rule__SystemOperationMode__Group__3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4134:1: rule__SystemOperationMode__Group__3 : rule__SystemOperationMode__Group__3__Impl ;
    public final void rule__SystemOperationMode__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4138:1: ( rule__SystemOperationMode__Group__3__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4139:2: rule__SystemOperationMode__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__Group__3__Impl_in_rule__SystemOperationMode__Group__38328);
            rule__SystemOperationMode__Group__3__Impl();

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
    // $ANTLR end "rule__SystemOperationMode__Group__3"


    // $ANTLR start "rule__SystemOperationMode__Group__3__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4145:1: rule__SystemOperationMode__Group__3__Impl : ( 'end' ) ;
    public final void rule__SystemOperationMode__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4149:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4150:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4150:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4151:1: 'end'
            {
             before(grammarAccess.getSystemOperationModeAccess().getEndKeyword_3()); 
            match(input,39,FOLLOW_39_in_rule__SystemOperationMode__Group__3__Impl8356); 
             after(grammarAccess.getSystemOperationModeAccess().getEndKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemOperationMode__Group__3__Impl"


    // $ANTLR start "rule__ConnectionInstance__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4172:1: rule__ConnectionInstance__Group__0 : rule__ConnectionInstance__Group__0__Impl rule__ConnectionInstance__Group__1 ;
    public final void rule__ConnectionInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4176:1: ( rule__ConnectionInstance__Group__0__Impl rule__ConnectionInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4177:2: rule__ConnectionInstance__Group__0__Impl rule__ConnectionInstance__Group__1
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__0__Impl_in_rule__ConnectionInstance__Group__08395);
            rule__ConnectionInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__1_in_rule__ConnectionInstance__Group__08398);
            rule__ConnectionInstance__Group__1();

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
    // $ANTLR end "rule__ConnectionInstance__Group__0"


    // $ANTLR start "rule__ConnectionInstance__Group__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4184:1: rule__ConnectionInstance__Group__0__Impl : ( ( rule__ConnectionInstance__KindAssignment_0 ) ) ;
    public final void rule__ConnectionInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4188:1: ( ( ( rule__ConnectionInstance__KindAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4189:1: ( ( rule__ConnectionInstance__KindAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4189:1: ( ( rule__ConnectionInstance__KindAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4190:1: ( rule__ConnectionInstance__KindAssignment_0 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getKindAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4191:1: ( rule__ConnectionInstance__KindAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4191:2: rule__ConnectionInstance__KindAssignment_0
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__KindAssignment_0_in_rule__ConnectionInstance__Group__0__Impl8425);
            rule__ConnectionInstance__KindAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getConnectionInstanceAccess().getKindAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__Group__0__Impl"


    // $ANTLR start "rule__ConnectionInstance__Group__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4201:1: rule__ConnectionInstance__Group__1 : rule__ConnectionInstance__Group__1__Impl rule__ConnectionInstance__Group__2 ;
    public final void rule__ConnectionInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4205:1: ( rule__ConnectionInstance__Group__1__Impl rule__ConnectionInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4206:2: rule__ConnectionInstance__Group__1__Impl rule__ConnectionInstance__Group__2
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__1__Impl_in_rule__ConnectionInstance__Group__18455);
            rule__ConnectionInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__2_in_rule__ConnectionInstance__Group__18458);
            rule__ConnectionInstance__Group__2();

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
    // $ANTLR end "rule__ConnectionInstance__Group__1"


    // $ANTLR start "rule__ConnectionInstance__Group__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4213:1: rule__ConnectionInstance__Group__1__Impl : ( 'connection' ) ;
    public final void rule__ConnectionInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4217:1: ( ( 'connection' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4218:1: ( 'connection' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4218:1: ( 'connection' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4219:1: 'connection'
            {
             before(grammarAccess.getConnectionInstanceAccess().getConnectionKeyword_1()); 
            match(input,50,FOLLOW_50_in_rule__ConnectionInstance__Group__1__Impl8486); 
             after(grammarAccess.getConnectionInstanceAccess().getConnectionKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__Group__1__Impl"


    // $ANTLR start "rule__ConnectionInstance__Group__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4232:1: rule__ConnectionInstance__Group__2 : rule__ConnectionInstance__Group__2__Impl rule__ConnectionInstance__Group__3 ;
    public final void rule__ConnectionInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4236:1: ( rule__ConnectionInstance__Group__2__Impl rule__ConnectionInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4237:2: rule__ConnectionInstance__Group__2__Impl rule__ConnectionInstance__Group__3
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__2__Impl_in_rule__ConnectionInstance__Group__28517);
            rule__ConnectionInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__3_in_rule__ConnectionInstance__Group__28520);
            rule__ConnectionInstance__Group__3();

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
    // $ANTLR end "rule__ConnectionInstance__Group__2"


    // $ANTLR start "rule__ConnectionInstance__Group__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4244:1: rule__ConnectionInstance__Group__2__Impl : ( 'instance' ) ;
    public final void rule__ConnectionInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4248:1: ( ( 'instance' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4249:1: ( 'instance' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4249:1: ( 'instance' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4250:1: 'instance'
            {
             before(grammarAccess.getConnectionInstanceAccess().getInstanceKeyword_2()); 
            match(input,40,FOLLOW_40_in_rule__ConnectionInstance__Group__2__Impl8548); 
             after(grammarAccess.getConnectionInstanceAccess().getInstanceKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__Group__2__Impl"


    // $ANTLR start "rule__ConnectionInstance__Group__3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4263:1: rule__ConnectionInstance__Group__3 : rule__ConnectionInstance__Group__3__Impl rule__ConnectionInstance__Group__4 ;
    public final void rule__ConnectionInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4267:1: ( rule__ConnectionInstance__Group__3__Impl rule__ConnectionInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4268:2: rule__ConnectionInstance__Group__3__Impl rule__ConnectionInstance__Group__4
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__3__Impl_in_rule__ConnectionInstance__Group__38579);
            rule__ConnectionInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__4_in_rule__ConnectionInstance__Group__38582);
            rule__ConnectionInstance__Group__4();

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
    // $ANTLR end "rule__ConnectionInstance__Group__3"


    // $ANTLR start "rule__ConnectionInstance__Group__3__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4275:1: rule__ConnectionInstance__Group__3__Impl : ( 'of' ) ;
    public final void rule__ConnectionInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4279:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4280:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4280:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4281:1: 'of'
            {
             before(grammarAccess.getConnectionInstanceAccess().getOfKeyword_3()); 
            match(input,38,FOLLOW_38_in_rule__ConnectionInstance__Group__3__Impl8610); 
             after(grammarAccess.getConnectionInstanceAccess().getOfKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__Group__3__Impl"


    // $ANTLR start "rule__ConnectionInstance__Group__4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4294:1: rule__ConnectionInstance__Group__4 : rule__ConnectionInstance__Group__4__Impl rule__ConnectionInstance__Group__5 ;
    public final void rule__ConnectionInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4298:1: ( rule__ConnectionInstance__Group__4__Impl rule__ConnectionInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4299:2: rule__ConnectionInstance__Group__4__Impl rule__ConnectionInstance__Group__5
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__4__Impl_in_rule__ConnectionInstance__Group__48641);
            rule__ConnectionInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__5_in_rule__ConnectionInstance__Group__48644);
            rule__ConnectionInstance__Group__5();

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
    // $ANTLR end "rule__ConnectionInstance__Group__4"


    // $ANTLR start "rule__ConnectionInstance__Group__4__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4306:1: rule__ConnectionInstance__Group__4__Impl : ( ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )* ) ) ;
    public final void rule__ConnectionInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4310:1: ( ( ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4311:1: ( ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4311:1: ( ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4312:1: ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4312:1: ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4313:1: ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4314:1: ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4314:2: rule__ConnectionInstance__ConnectionReferenceAssignment_4
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__ConnectionReferenceAssignment_4_in_rule__ConnectionInstance__Group__4__Impl8673);
            rule__ConnectionInstance__ConnectionReferenceAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceAssignment_4()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4317:1: ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4318:1: ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )*
            {
             before(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4319:1: ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==38) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4319:2: rule__ConnectionInstance__ConnectionReferenceAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__ConnectionInstance__ConnectionReferenceAssignment_4_in_rule__ConnectionInstance__Group__4__Impl8685);
            	    rule__ConnectionInstance__ConnectionReferenceAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceAssignment_4()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__Group__4__Impl"


    // $ANTLR start "rule__ConnectionInstance__Group__5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4330:1: rule__ConnectionInstance__Group__5 : rule__ConnectionInstance__Group__5__Impl rule__ConnectionInstance__Group__6 ;
    public final void rule__ConnectionInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4334:1: ( rule__ConnectionInstance__Group__5__Impl rule__ConnectionInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4335:2: rule__ConnectionInstance__Group__5__Impl rule__ConnectionInstance__Group__6
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__5__Impl_in_rule__ConnectionInstance__Group__58718);
            rule__ConnectionInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__6_in_rule__ConnectionInstance__Group__58721);
            rule__ConnectionInstance__Group__6();

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
    // $ANTLR end "rule__ConnectionInstance__Group__5"


    // $ANTLR start "rule__ConnectionInstance__Group__5__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4342:1: rule__ConnectionInstance__Group__5__Impl : ( 'src' ) ;
    public final void rule__ConnectionInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4346:1: ( ( 'src' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4347:1: ( 'src' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4347:1: ( 'src' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4348:1: 'src'
            {
             before(grammarAccess.getConnectionInstanceAccess().getSrcKeyword_5()); 
            match(input,45,FOLLOW_45_in_rule__ConnectionInstance__Group__5__Impl8749); 
             after(grammarAccess.getConnectionInstanceAccess().getSrcKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__Group__5__Impl"


    // $ANTLR start "rule__ConnectionInstance__Group__6"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4361:1: rule__ConnectionInstance__Group__6 : rule__ConnectionInstance__Group__6__Impl rule__ConnectionInstance__Group__7 ;
    public final void rule__ConnectionInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4365:1: ( rule__ConnectionInstance__Group__6__Impl rule__ConnectionInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4366:2: rule__ConnectionInstance__Group__6__Impl rule__ConnectionInstance__Group__7
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__6__Impl_in_rule__ConnectionInstance__Group__68780);
            rule__ConnectionInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__7_in_rule__ConnectionInstance__Group__68783);
            rule__ConnectionInstance__Group__7();

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
    // $ANTLR end "rule__ConnectionInstance__Group__6"


    // $ANTLR start "rule__ConnectionInstance__Group__6__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4373:1: rule__ConnectionInstance__Group__6__Impl : ( ( rule__ConnectionInstance__SourceAssignment_6 ) ) ;
    public final void rule__ConnectionInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4377:1: ( ( ( rule__ConnectionInstance__SourceAssignment_6 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4378:1: ( ( rule__ConnectionInstance__SourceAssignment_6 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4378:1: ( ( rule__ConnectionInstance__SourceAssignment_6 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4379:1: ( rule__ConnectionInstance__SourceAssignment_6 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getSourceAssignment_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4380:1: ( rule__ConnectionInstance__SourceAssignment_6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4380:2: rule__ConnectionInstance__SourceAssignment_6
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__SourceAssignment_6_in_rule__ConnectionInstance__Group__6__Impl8810);
            rule__ConnectionInstance__SourceAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getConnectionInstanceAccess().getSourceAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__Group__6__Impl"


    // $ANTLR start "rule__ConnectionInstance__Group__7"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4390:1: rule__ConnectionInstance__Group__7 : rule__ConnectionInstance__Group__7__Impl rule__ConnectionInstance__Group__8 ;
    public final void rule__ConnectionInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4394:1: ( rule__ConnectionInstance__Group__7__Impl rule__ConnectionInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4395:2: rule__ConnectionInstance__Group__7__Impl rule__ConnectionInstance__Group__8
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__7__Impl_in_rule__ConnectionInstance__Group__78840);
            rule__ConnectionInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__8_in_rule__ConnectionInstance__Group__78843);
            rule__ConnectionInstance__Group__8();

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
    // $ANTLR end "rule__ConnectionInstance__Group__7"


    // $ANTLR start "rule__ConnectionInstance__Group__7__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4402:1: rule__ConnectionInstance__Group__7__Impl : ( 'dst' ) ;
    public final void rule__ConnectionInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4406:1: ( ( 'dst' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4407:1: ( 'dst' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4407:1: ( 'dst' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4408:1: 'dst'
            {
             before(grammarAccess.getConnectionInstanceAccess().getDstKeyword_7()); 
            match(input,46,FOLLOW_46_in_rule__ConnectionInstance__Group__7__Impl8871); 
             after(grammarAccess.getConnectionInstanceAccess().getDstKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__Group__7__Impl"


    // $ANTLR start "rule__ConnectionInstance__Group__8"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4421:1: rule__ConnectionInstance__Group__8 : rule__ConnectionInstance__Group__8__Impl rule__ConnectionInstance__Group__9 ;
    public final void rule__ConnectionInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4425:1: ( rule__ConnectionInstance__Group__8__Impl rule__ConnectionInstance__Group__9 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4426:2: rule__ConnectionInstance__Group__8__Impl rule__ConnectionInstance__Group__9
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__8__Impl_in_rule__ConnectionInstance__Group__88902);
            rule__ConnectionInstance__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__9_in_rule__ConnectionInstance__Group__88905);
            rule__ConnectionInstance__Group__9();

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
    // $ANTLR end "rule__ConnectionInstance__Group__8"


    // $ANTLR start "rule__ConnectionInstance__Group__8__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4433:1: rule__ConnectionInstance__Group__8__Impl : ( ( rule__ConnectionInstance__DestinationAssignment_8 ) ) ;
    public final void rule__ConnectionInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4437:1: ( ( ( rule__ConnectionInstance__DestinationAssignment_8 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4438:1: ( ( rule__ConnectionInstance__DestinationAssignment_8 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4438:1: ( ( rule__ConnectionInstance__DestinationAssignment_8 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4439:1: ( rule__ConnectionInstance__DestinationAssignment_8 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getDestinationAssignment_8()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4440:1: ( rule__ConnectionInstance__DestinationAssignment_8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4440:2: rule__ConnectionInstance__DestinationAssignment_8
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__DestinationAssignment_8_in_rule__ConnectionInstance__Group__8__Impl8932);
            rule__ConnectionInstance__DestinationAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getConnectionInstanceAccess().getDestinationAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__Group__8__Impl"


    // $ANTLR start "rule__ConnectionInstance__Group__9"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4450:1: rule__ConnectionInstance__Group__9 : rule__ConnectionInstance__Group__9__Impl rule__ConnectionInstance__Group__10 ;
    public final void rule__ConnectionInstance__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4454:1: ( rule__ConnectionInstance__Group__9__Impl rule__ConnectionInstance__Group__10 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4455:2: rule__ConnectionInstance__Group__9__Impl rule__ConnectionInstance__Group__10
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__9__Impl_in_rule__ConnectionInstance__Group__98962);
            rule__ConnectionInstance__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__10_in_rule__ConnectionInstance__Group__98965);
            rule__ConnectionInstance__Group__10();

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
    // $ANTLR end "rule__ConnectionInstance__Group__9"


    // $ANTLR start "rule__ConnectionInstance__Group__9__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4462:1: rule__ConnectionInstance__Group__9__Impl : ( ( rule__ConnectionInstance__Group_9__0 )? ) ;
    public final void rule__ConnectionInstance__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4466:1: ( ( ( rule__ConnectionInstance__Group_9__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4467:1: ( ( rule__ConnectionInstance__Group_9__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4467:1: ( ( rule__ConnectionInstance__Group_9__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4468:1: ( rule__ConnectionInstance__Group_9__0 )?
            {
             before(grammarAccess.getConnectionInstanceAccess().getGroup_9()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4469:1: ( rule__ConnectionInstance__Group_9__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==30) ) {
                int LA33_1 = input.LA(2);

                if ( (LA33_1==49) ) {
                    alt33=1;
                }
            }
            switch (alt33) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4469:2: rule__ConnectionInstance__Group_9__0
                    {
                    pushFollow(FOLLOW_rule__ConnectionInstance__Group_9__0_in_rule__ConnectionInstance__Group__9__Impl8992);
                    rule__ConnectionInstance__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConnectionInstanceAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__Group__9__Impl"


    // $ANTLR start "rule__ConnectionInstance__Group__10"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4479:1: rule__ConnectionInstance__Group__10 : rule__ConnectionInstance__Group__10__Impl rule__ConnectionInstance__Group__11 ;
    public final void rule__ConnectionInstance__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4483:1: ( rule__ConnectionInstance__Group__10__Impl rule__ConnectionInstance__Group__11 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4484:2: rule__ConnectionInstance__Group__10__Impl rule__ConnectionInstance__Group__11
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__10__Impl_in_rule__ConnectionInstance__Group__109023);
            rule__ConnectionInstance__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__11_in_rule__ConnectionInstance__Group__109026);
            rule__ConnectionInstance__Group__11();

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
    // $ANTLR end "rule__ConnectionInstance__Group__10"


    // $ANTLR start "rule__ConnectionInstance__Group__10__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4491:1: rule__ConnectionInstance__Group__10__Impl : ( ( rule__ConnectionInstance__Group_10__0 )? ) ;
    public final void rule__ConnectionInstance__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4495:1: ( ( ( rule__ConnectionInstance__Group_10__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4496:1: ( ( rule__ConnectionInstance__Group_10__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4496:1: ( ( rule__ConnectionInstance__Group_10__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4497:1: ( rule__ConnectionInstance__Group_10__0 )?
            {
             before(grammarAccess.getConnectionInstanceAccess().getGroup_10()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4498:1: ( rule__ConnectionInstance__Group_10__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==30) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4498:2: rule__ConnectionInstance__Group_10__0
                    {
                    pushFollow(FOLLOW_rule__ConnectionInstance__Group_10__0_in_rule__ConnectionInstance__Group__10__Impl9053);
                    rule__ConnectionInstance__Group_10__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConnectionInstanceAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__Group__10__Impl"


    // $ANTLR start "rule__ConnectionInstance__Group__11"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4508:1: rule__ConnectionInstance__Group__11 : rule__ConnectionInstance__Group__11__Impl rule__ConnectionInstance__Group__12 ;
    public final void rule__ConnectionInstance__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4512:1: ( rule__ConnectionInstance__Group__11__Impl rule__ConnectionInstance__Group__12 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4513:2: rule__ConnectionInstance__Group__11__Impl rule__ConnectionInstance__Group__12
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__11__Impl_in_rule__ConnectionInstance__Group__119084);
            rule__ConnectionInstance__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__12_in_rule__ConnectionInstance__Group__119087);
            rule__ConnectionInstance__Group__12();

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
    // $ANTLR end "rule__ConnectionInstance__Group__11"


    // $ANTLR start "rule__ConnectionInstance__Group__11__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4520:1: rule__ConnectionInstance__Group__11__Impl : ( ( rule__ConnectionInstance__CompleteAssignment_11 )? ) ;
    public final void rule__ConnectionInstance__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4524:1: ( ( ( rule__ConnectionInstance__CompleteAssignment_11 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4525:1: ( ( rule__ConnectionInstance__CompleteAssignment_11 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4525:1: ( ( rule__ConnectionInstance__CompleteAssignment_11 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4526:1: ( rule__ConnectionInstance__CompleteAssignment_11 )?
            {
             before(grammarAccess.getConnectionInstanceAccess().getCompleteAssignment_11()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4527:1: ( rule__ConnectionInstance__CompleteAssignment_11 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==58) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4527:2: rule__ConnectionInstance__CompleteAssignment_11
                    {
                    pushFollow(FOLLOW_rule__ConnectionInstance__CompleteAssignment_11_in_rule__ConnectionInstance__Group__11__Impl9114);
                    rule__ConnectionInstance__CompleteAssignment_11();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConnectionInstanceAccess().getCompleteAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__Group__11__Impl"


    // $ANTLR start "rule__ConnectionInstance__Group__12"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4537:1: rule__ConnectionInstance__Group__12 : rule__ConnectionInstance__Group__12__Impl rule__ConnectionInstance__Group__13 ;
    public final void rule__ConnectionInstance__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4541:1: ( rule__ConnectionInstance__Group__12__Impl rule__ConnectionInstance__Group__13 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4542:2: rule__ConnectionInstance__Group__12__Impl rule__ConnectionInstance__Group__13
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__12__Impl_in_rule__ConnectionInstance__Group__129145);
            rule__ConnectionInstance__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__13_in_rule__ConnectionInstance__Group__129148);
            rule__ConnectionInstance__Group__13();

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
    // $ANTLR end "rule__ConnectionInstance__Group__12"


    // $ANTLR start "rule__ConnectionInstance__Group__12__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4549:1: rule__ConnectionInstance__Group__12__Impl : ( ( rule__ConnectionInstance__BidirectionalAssignment_12 )? ) ;
    public final void rule__ConnectionInstance__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4553:1: ( ( ( rule__ConnectionInstance__BidirectionalAssignment_12 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4554:1: ( ( rule__ConnectionInstance__BidirectionalAssignment_12 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4554:1: ( ( rule__ConnectionInstance__BidirectionalAssignment_12 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4555:1: ( rule__ConnectionInstance__BidirectionalAssignment_12 )?
            {
             before(grammarAccess.getConnectionInstanceAccess().getBidirectionalAssignment_12()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4556:1: ( rule__ConnectionInstance__BidirectionalAssignment_12 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==59) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4556:2: rule__ConnectionInstance__BidirectionalAssignment_12
                    {
                    pushFollow(FOLLOW_rule__ConnectionInstance__BidirectionalAssignment_12_in_rule__ConnectionInstance__Group__12__Impl9175);
                    rule__ConnectionInstance__BidirectionalAssignment_12();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConnectionInstanceAccess().getBidirectionalAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__Group__12__Impl"


    // $ANTLR start "rule__ConnectionInstance__Group__13"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4566:1: rule__ConnectionInstance__Group__13 : rule__ConnectionInstance__Group__13__Impl ;
    public final void rule__ConnectionInstance__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4570:1: ( rule__ConnectionInstance__Group__13__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4571:2: rule__ConnectionInstance__Group__13__Impl
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__13__Impl_in_rule__ConnectionInstance__Group__139206);
            rule__ConnectionInstance__Group__13__Impl();

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
    // $ANTLR end "rule__ConnectionInstance__Group__13"


    // $ANTLR start "rule__ConnectionInstance__Group__13__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4577:1: rule__ConnectionInstance__Group__13__Impl : ( 'end' ) ;
    public final void rule__ConnectionInstance__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4581:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4582:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4582:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4583:1: 'end'
            {
             before(grammarAccess.getConnectionInstanceAccess().getEndKeyword_13()); 
            match(input,39,FOLLOW_39_in_rule__ConnectionInstance__Group__13__Impl9234); 
             after(grammarAccess.getConnectionInstanceAccess().getEndKeyword_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__Group__13__Impl"


    // $ANTLR start "rule__ConnectionInstance__Group_9__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4624:1: rule__ConnectionInstance__Group_9__0 : rule__ConnectionInstance__Group_9__0__Impl rule__ConnectionInstance__Group_9__1 ;
    public final void rule__ConnectionInstance__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4628:1: ( rule__ConnectionInstance__Group_9__0__Impl rule__ConnectionInstance__Group_9__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4629:2: rule__ConnectionInstance__Group_9__0__Impl rule__ConnectionInstance__Group_9__1
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group_9__0__Impl_in_rule__ConnectionInstance__Group_9__09293);
            rule__ConnectionInstance__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group_9__1_in_rule__ConnectionInstance__Group_9__09296);
            rule__ConnectionInstance__Group_9__1();

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
    // $ANTLR end "rule__ConnectionInstance__Group_9__0"


    // $ANTLR start "rule__ConnectionInstance__Group_9__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4636:1: rule__ConnectionInstance__Group_9__0__Impl : ( 'in' ) ;
    public final void rule__ConnectionInstance__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4640:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4641:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4641:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4642:1: 'in'
            {
             before(grammarAccess.getConnectionInstanceAccess().getInKeyword_9_0()); 
            match(input,30,FOLLOW_30_in_rule__ConnectionInstance__Group_9__0__Impl9324); 
             after(grammarAccess.getConnectionInstanceAccess().getInKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__Group_9__0__Impl"


    // $ANTLR start "rule__ConnectionInstance__Group_9__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4655:1: rule__ConnectionInstance__Group_9__1 : rule__ConnectionInstance__Group_9__1__Impl rule__ConnectionInstance__Group_9__2 ;
    public final void rule__ConnectionInstance__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4659:1: ( rule__ConnectionInstance__Group_9__1__Impl rule__ConnectionInstance__Group_9__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4660:2: rule__ConnectionInstance__Group_9__1__Impl rule__ConnectionInstance__Group_9__2
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group_9__1__Impl_in_rule__ConnectionInstance__Group_9__19355);
            rule__ConnectionInstance__Group_9__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group_9__2_in_rule__ConnectionInstance__Group_9__19358);
            rule__ConnectionInstance__Group_9__2();

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
    // $ANTLR end "rule__ConnectionInstance__Group_9__1"


    // $ANTLR start "rule__ConnectionInstance__Group_9__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4667:1: rule__ConnectionInstance__Group_9__1__Impl : ( 'som' ) ;
    public final void rule__ConnectionInstance__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4671:1: ( ( 'som' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4672:1: ( 'som' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4672:1: ( 'som' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4673:1: 'som'
            {
             before(grammarAccess.getConnectionInstanceAccess().getSomKeyword_9_1()); 
            match(input,49,FOLLOW_49_in_rule__ConnectionInstance__Group_9__1__Impl9386); 
             after(grammarAccess.getConnectionInstanceAccess().getSomKeyword_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__Group_9__1__Impl"


    // $ANTLR start "rule__ConnectionInstance__Group_9__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4686:1: rule__ConnectionInstance__Group_9__2 : rule__ConnectionInstance__Group_9__2__Impl ;
    public final void rule__ConnectionInstance__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4690:1: ( rule__ConnectionInstance__Group_9__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4691:2: rule__ConnectionInstance__Group_9__2__Impl
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group_9__2__Impl_in_rule__ConnectionInstance__Group_9__29417);
            rule__ConnectionInstance__Group_9__2__Impl();

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
    // $ANTLR end "rule__ConnectionInstance__Group_9__2"


    // $ANTLR start "rule__ConnectionInstance__Group_9__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4697:1: rule__ConnectionInstance__Group_9__2__Impl : ( ( rule__ConnectionInstance__InSystemOperationModeAssignment_9_2 ) ) ;
    public final void rule__ConnectionInstance__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4701:1: ( ( ( rule__ConnectionInstance__InSystemOperationModeAssignment_9_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4702:1: ( ( rule__ConnectionInstance__InSystemOperationModeAssignment_9_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4702:1: ( ( rule__ConnectionInstance__InSystemOperationModeAssignment_9_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4703:1: ( rule__ConnectionInstance__InSystemOperationModeAssignment_9_2 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeAssignment_9_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4704:1: ( rule__ConnectionInstance__InSystemOperationModeAssignment_9_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4704:2: rule__ConnectionInstance__InSystemOperationModeAssignment_9_2
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__InSystemOperationModeAssignment_9_2_in_rule__ConnectionInstance__Group_9__2__Impl9444);
            rule__ConnectionInstance__InSystemOperationModeAssignment_9_2();

            state._fsp--;


            }

             after(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeAssignment_9_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__Group_9__2__Impl"


    // $ANTLR start "rule__ConnectionInstance__Group_10__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4720:1: rule__ConnectionInstance__Group_10__0 : rule__ConnectionInstance__Group_10__0__Impl rule__ConnectionInstance__Group_10__1 ;
    public final void rule__ConnectionInstance__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4724:1: ( rule__ConnectionInstance__Group_10__0__Impl rule__ConnectionInstance__Group_10__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4725:2: rule__ConnectionInstance__Group_10__0__Impl rule__ConnectionInstance__Group_10__1
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group_10__0__Impl_in_rule__ConnectionInstance__Group_10__09480);
            rule__ConnectionInstance__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group_10__1_in_rule__ConnectionInstance__Group_10__09483);
            rule__ConnectionInstance__Group_10__1();

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
    // $ANTLR end "rule__ConnectionInstance__Group_10__0"


    // $ANTLR start "rule__ConnectionInstance__Group_10__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4732:1: rule__ConnectionInstance__Group_10__0__Impl : ( 'in' ) ;
    public final void rule__ConnectionInstance__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4736:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4737:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4737:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4738:1: 'in'
            {
             before(grammarAccess.getConnectionInstanceAccess().getInKeyword_10_0()); 
            match(input,30,FOLLOW_30_in_rule__ConnectionInstance__Group_10__0__Impl9511); 
             after(grammarAccess.getConnectionInstanceAccess().getInKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__Group_10__0__Impl"


    // $ANTLR start "rule__ConnectionInstance__Group_10__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4751:1: rule__ConnectionInstance__Group_10__1 : rule__ConnectionInstance__Group_10__1__Impl rule__ConnectionInstance__Group_10__2 ;
    public final void rule__ConnectionInstance__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4755:1: ( rule__ConnectionInstance__Group_10__1__Impl rule__ConnectionInstance__Group_10__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4756:2: rule__ConnectionInstance__Group_10__1__Impl rule__ConnectionInstance__Group_10__2
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group_10__1__Impl_in_rule__ConnectionInstance__Group_10__19542);
            rule__ConnectionInstance__Group_10__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group_10__2_in_rule__ConnectionInstance__Group_10__19545);
            rule__ConnectionInstance__Group_10__2();

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
    // $ANTLR end "rule__ConnectionInstance__Group_10__1"


    // $ANTLR start "rule__ConnectionInstance__Group_10__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4763:1: rule__ConnectionInstance__Group_10__1__Impl : ( 'transition' ) ;
    public final void rule__ConnectionInstance__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4767:1: ( ( 'transition' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4768:1: ( 'transition' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4768:1: ( 'transition' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4769:1: 'transition'
            {
             before(grammarAccess.getConnectionInstanceAccess().getTransitionKeyword_10_1()); 
            match(input,44,FOLLOW_44_in_rule__ConnectionInstance__Group_10__1__Impl9573); 
             after(grammarAccess.getConnectionInstanceAccess().getTransitionKeyword_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__Group_10__1__Impl"


    // $ANTLR start "rule__ConnectionInstance__Group_10__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4782:1: rule__ConnectionInstance__Group_10__2 : rule__ConnectionInstance__Group_10__2__Impl ;
    public final void rule__ConnectionInstance__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4786:1: ( rule__ConnectionInstance__Group_10__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4787:2: rule__ConnectionInstance__Group_10__2__Impl
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group_10__2__Impl_in_rule__ConnectionInstance__Group_10__29604);
            rule__ConnectionInstance__Group_10__2__Impl();

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
    // $ANTLR end "rule__ConnectionInstance__Group_10__2"


    // $ANTLR start "rule__ConnectionInstance__Group_10__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4793:1: rule__ConnectionInstance__Group_10__2__Impl : ( ( rule__ConnectionInstance__InModeTransitionAssignment_10_2 ) ) ;
    public final void rule__ConnectionInstance__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4797:1: ( ( ( rule__ConnectionInstance__InModeTransitionAssignment_10_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4798:1: ( ( rule__ConnectionInstance__InModeTransitionAssignment_10_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4798:1: ( ( rule__ConnectionInstance__InModeTransitionAssignment_10_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4799:1: ( rule__ConnectionInstance__InModeTransitionAssignment_10_2 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getInModeTransitionAssignment_10_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4800:1: ( rule__ConnectionInstance__InModeTransitionAssignment_10_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4800:2: rule__ConnectionInstance__InModeTransitionAssignment_10_2
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__InModeTransitionAssignment_10_2_in_rule__ConnectionInstance__Group_10__2__Impl9631);
            rule__ConnectionInstance__InModeTransitionAssignment_10_2();

            state._fsp--;


            }

             after(grammarAccess.getConnectionInstanceAccess().getInModeTransitionAssignment_10_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__Group_10__2__Impl"


    // $ANTLR start "rule__ConnectionReference__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4816:1: rule__ConnectionReference__Group__0 : rule__ConnectionReference__Group__0__Impl rule__ConnectionReference__Group__1 ;
    public final void rule__ConnectionReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4820:1: ( rule__ConnectionReference__Group__0__Impl rule__ConnectionReference__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4821:2: rule__ConnectionReference__Group__0__Impl rule__ConnectionReference__Group__1
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__0__Impl_in_rule__ConnectionReference__Group__09667);
            rule__ConnectionReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__1_in_rule__ConnectionReference__Group__09670);
            rule__ConnectionReference__Group__1();

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
    // $ANTLR end "rule__ConnectionReference__Group__0"


    // $ANTLR start "rule__ConnectionReference__Group__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4828:1: rule__ConnectionReference__Group__0__Impl : ( 'of' ) ;
    public final void rule__ConnectionReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4832:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4833:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4833:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4834:1: 'of'
            {
             before(grammarAccess.getConnectionReferenceAccess().getOfKeyword_0()); 
            match(input,38,FOLLOW_38_in_rule__ConnectionReference__Group__0__Impl9698); 
             after(grammarAccess.getConnectionReferenceAccess().getOfKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionReference__Group__0__Impl"


    // $ANTLR start "rule__ConnectionReference__Group__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4847:1: rule__ConnectionReference__Group__1 : rule__ConnectionReference__Group__1__Impl rule__ConnectionReference__Group__2 ;
    public final void rule__ConnectionReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4851:1: ( rule__ConnectionReference__Group__1__Impl rule__ConnectionReference__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4852:2: rule__ConnectionReference__Group__1__Impl rule__ConnectionReference__Group__2
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__1__Impl_in_rule__ConnectionReference__Group__19729);
            rule__ConnectionReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__2_in_rule__ConnectionReference__Group__19732);
            rule__ConnectionReference__Group__2();

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
    // $ANTLR end "rule__ConnectionReference__Group__1"


    // $ANTLR start "rule__ConnectionReference__Group__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4859:1: rule__ConnectionReference__Group__1__Impl : ( ( rule__ConnectionReference__ConnectionAssignment_1 ) ) ;
    public final void rule__ConnectionReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4863:1: ( ( ( rule__ConnectionReference__ConnectionAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4864:1: ( ( rule__ConnectionReference__ConnectionAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4864:1: ( ( rule__ConnectionReference__ConnectionAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4865:1: ( rule__ConnectionReference__ConnectionAssignment_1 )
            {
             before(grammarAccess.getConnectionReferenceAccess().getConnectionAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4866:1: ( rule__ConnectionReference__ConnectionAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4866:2: rule__ConnectionReference__ConnectionAssignment_1
            {
            pushFollow(FOLLOW_rule__ConnectionReference__ConnectionAssignment_1_in_rule__ConnectionReference__Group__1__Impl9759);
            rule__ConnectionReference__ConnectionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConnectionReferenceAccess().getConnectionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionReference__Group__1__Impl"


    // $ANTLR start "rule__ConnectionReference__Group__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4876:1: rule__ConnectionReference__Group__2 : rule__ConnectionReference__Group__2__Impl rule__ConnectionReference__Group__3 ;
    public final void rule__ConnectionReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4880:1: ( rule__ConnectionReference__Group__2__Impl rule__ConnectionReference__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4881:2: rule__ConnectionReference__Group__2__Impl rule__ConnectionReference__Group__3
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__2__Impl_in_rule__ConnectionReference__Group__29789);
            rule__ConnectionReference__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__3_in_rule__ConnectionReference__Group__29792);
            rule__ConnectionReference__Group__3();

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
    // $ANTLR end "rule__ConnectionReference__Group__2"


    // $ANTLR start "rule__ConnectionReference__Group__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4888:1: rule__ConnectionReference__Group__2__Impl : ( 'src' ) ;
    public final void rule__ConnectionReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4892:1: ( ( 'src' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4893:1: ( 'src' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4893:1: ( 'src' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4894:1: 'src'
            {
             before(grammarAccess.getConnectionReferenceAccess().getSrcKeyword_2()); 
            match(input,45,FOLLOW_45_in_rule__ConnectionReference__Group__2__Impl9820); 
             after(grammarAccess.getConnectionReferenceAccess().getSrcKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionReference__Group__2__Impl"


    // $ANTLR start "rule__ConnectionReference__Group__3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4907:1: rule__ConnectionReference__Group__3 : rule__ConnectionReference__Group__3__Impl rule__ConnectionReference__Group__4 ;
    public final void rule__ConnectionReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4911:1: ( rule__ConnectionReference__Group__3__Impl rule__ConnectionReference__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4912:2: rule__ConnectionReference__Group__3__Impl rule__ConnectionReference__Group__4
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__3__Impl_in_rule__ConnectionReference__Group__39851);
            rule__ConnectionReference__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__4_in_rule__ConnectionReference__Group__39854);
            rule__ConnectionReference__Group__4();

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
    // $ANTLR end "rule__ConnectionReference__Group__3"


    // $ANTLR start "rule__ConnectionReference__Group__3__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4919:1: rule__ConnectionReference__Group__3__Impl : ( ( rule__ConnectionReference__SourceAssignment_3 ) ) ;
    public final void rule__ConnectionReference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4923:1: ( ( ( rule__ConnectionReference__SourceAssignment_3 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4924:1: ( ( rule__ConnectionReference__SourceAssignment_3 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4924:1: ( ( rule__ConnectionReference__SourceAssignment_3 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4925:1: ( rule__ConnectionReference__SourceAssignment_3 )
            {
             before(grammarAccess.getConnectionReferenceAccess().getSourceAssignment_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4926:1: ( rule__ConnectionReference__SourceAssignment_3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4926:2: rule__ConnectionReference__SourceAssignment_3
            {
            pushFollow(FOLLOW_rule__ConnectionReference__SourceAssignment_3_in_rule__ConnectionReference__Group__3__Impl9881);
            rule__ConnectionReference__SourceAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getConnectionReferenceAccess().getSourceAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionReference__Group__3__Impl"


    // $ANTLR start "rule__ConnectionReference__Group__4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4936:1: rule__ConnectionReference__Group__4 : rule__ConnectionReference__Group__4__Impl rule__ConnectionReference__Group__5 ;
    public final void rule__ConnectionReference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4940:1: ( rule__ConnectionReference__Group__4__Impl rule__ConnectionReference__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4941:2: rule__ConnectionReference__Group__4__Impl rule__ConnectionReference__Group__5
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__4__Impl_in_rule__ConnectionReference__Group__49911);
            rule__ConnectionReference__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__5_in_rule__ConnectionReference__Group__49914);
            rule__ConnectionReference__Group__5();

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
    // $ANTLR end "rule__ConnectionReference__Group__4"


    // $ANTLR start "rule__ConnectionReference__Group__4__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4948:1: rule__ConnectionReference__Group__4__Impl : ( 'dst' ) ;
    public final void rule__ConnectionReference__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4952:1: ( ( 'dst' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4953:1: ( 'dst' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4953:1: ( 'dst' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4954:1: 'dst'
            {
             before(grammarAccess.getConnectionReferenceAccess().getDstKeyword_4()); 
            match(input,46,FOLLOW_46_in_rule__ConnectionReference__Group__4__Impl9942); 
             after(grammarAccess.getConnectionReferenceAccess().getDstKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionReference__Group__4__Impl"


    // $ANTLR start "rule__ConnectionReference__Group__5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4967:1: rule__ConnectionReference__Group__5 : rule__ConnectionReference__Group__5__Impl rule__ConnectionReference__Group__6 ;
    public final void rule__ConnectionReference__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4971:1: ( rule__ConnectionReference__Group__5__Impl rule__ConnectionReference__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4972:2: rule__ConnectionReference__Group__5__Impl rule__ConnectionReference__Group__6
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__5__Impl_in_rule__ConnectionReference__Group__59973);
            rule__ConnectionReference__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__6_in_rule__ConnectionReference__Group__59976);
            rule__ConnectionReference__Group__6();

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
    // $ANTLR end "rule__ConnectionReference__Group__5"


    // $ANTLR start "rule__ConnectionReference__Group__5__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4979:1: rule__ConnectionReference__Group__5__Impl : ( ( rule__ConnectionReference__DestinationAssignment_5 ) ) ;
    public final void rule__ConnectionReference__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4983:1: ( ( ( rule__ConnectionReference__DestinationAssignment_5 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4984:1: ( ( rule__ConnectionReference__DestinationAssignment_5 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4984:1: ( ( rule__ConnectionReference__DestinationAssignment_5 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4985:1: ( rule__ConnectionReference__DestinationAssignment_5 )
            {
             before(grammarAccess.getConnectionReferenceAccess().getDestinationAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4986:1: ( rule__ConnectionReference__DestinationAssignment_5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4986:2: rule__ConnectionReference__DestinationAssignment_5
            {
            pushFollow(FOLLOW_rule__ConnectionReference__DestinationAssignment_5_in_rule__ConnectionReference__Group__5__Impl10003);
            rule__ConnectionReference__DestinationAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getConnectionReferenceAccess().getDestinationAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionReference__Group__5__Impl"


    // $ANTLR start "rule__ConnectionReference__Group__6"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4996:1: rule__ConnectionReference__Group__6 : rule__ConnectionReference__Group__6__Impl rule__ConnectionReference__Group__7 ;
    public final void rule__ConnectionReference__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5000:1: ( rule__ConnectionReference__Group__6__Impl rule__ConnectionReference__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5001:2: rule__ConnectionReference__Group__6__Impl rule__ConnectionReference__Group__7
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__6__Impl_in_rule__ConnectionReference__Group__610033);
            rule__ConnectionReference__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__7_in_rule__ConnectionReference__Group__610036);
            rule__ConnectionReference__Group__7();

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
    // $ANTLR end "rule__ConnectionReference__Group__6"


    // $ANTLR start "rule__ConnectionReference__Group__6__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5008:1: rule__ConnectionReference__Group__6__Impl : ( 'context' ) ;
    public final void rule__ConnectionReference__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5012:1: ( ( 'context' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5013:1: ( 'context' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5013:1: ( 'context' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5014:1: 'context'
            {
             before(grammarAccess.getConnectionReferenceAccess().getContextKeyword_6()); 
            match(input,51,FOLLOW_51_in_rule__ConnectionReference__Group__6__Impl10064); 
             after(grammarAccess.getConnectionReferenceAccess().getContextKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionReference__Group__6__Impl"


    // $ANTLR start "rule__ConnectionReference__Group__7"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5027:1: rule__ConnectionReference__Group__7 : rule__ConnectionReference__Group__7__Impl ;
    public final void rule__ConnectionReference__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5031:1: ( rule__ConnectionReference__Group__7__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5032:2: rule__ConnectionReference__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__7__Impl_in_rule__ConnectionReference__Group__710095);
            rule__ConnectionReference__Group__7__Impl();

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
    // $ANTLR end "rule__ConnectionReference__Group__7"


    // $ANTLR start "rule__ConnectionReference__Group__7__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5038:1: rule__ConnectionReference__Group__7__Impl : ( ( rule__ConnectionReference__ContextAssignment_7 ) ) ;
    public final void rule__ConnectionReference__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5042:1: ( ( ( rule__ConnectionReference__ContextAssignment_7 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5043:1: ( ( rule__ConnectionReference__ContextAssignment_7 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5043:1: ( ( rule__ConnectionReference__ContextAssignment_7 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5044:1: ( rule__ConnectionReference__ContextAssignment_7 )
            {
             before(grammarAccess.getConnectionReferenceAccess().getContextAssignment_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5045:1: ( rule__ConnectionReference__ContextAssignment_7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5045:2: rule__ConnectionReference__ContextAssignment_7
            {
            pushFollow(FOLLOW_rule__ConnectionReference__ContextAssignment_7_in_rule__ConnectionReference__Group__7__Impl10122);
            rule__ConnectionReference__ContextAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getConnectionReferenceAccess().getContextAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionReference__Group__7__Impl"


    // $ANTLR start "rule__ComponentCategory__Group_8__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5071:1: rule__ComponentCategory__Group_8__0 : rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1 ;
    public final void rule__ComponentCategory__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5075:1: ( rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5076:2: rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_8__0__Impl_in_rule__ComponentCategory__Group_8__010168);
            rule__ComponentCategory__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_8__1_in_rule__ComponentCategory__Group_8__010171);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5083:1: rule__ComponentCategory__Group_8__0__Impl : ( 'subprogram' ) ;
    public final void rule__ComponentCategory__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5087:1: ( ( 'subprogram' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5088:1: ( 'subprogram' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5088:1: ( 'subprogram' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5089:1: 'subprogram'
            {
             before(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
            match(input,15,FOLLOW_15_in_rule__ComponentCategory__Group_8__0__Impl10199); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5102:1: rule__ComponentCategory__Group_8__1 : rule__ComponentCategory__Group_8__1__Impl ;
    public final void rule__ComponentCategory__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5106:1: ( rule__ComponentCategory__Group_8__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5107:2: rule__ComponentCategory__Group_8__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_8__1__Impl_in_rule__ComponentCategory__Group_8__110230);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5113:1: rule__ComponentCategory__Group_8__1__Impl : ( 'group' ) ;
    public final void rule__ComponentCategory__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5117:1: ( ( 'group' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5118:1: ( 'group' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5118:1: ( 'group' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5119:1: 'group'
            {
             before(grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
            match(input,52,FOLLOW_52_in_rule__ComponentCategory__Group_8__1__Impl10258); 
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


    // $ANTLR start "rule__ComponentCategory__Group_12__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5136:1: rule__ComponentCategory__Group_12__0 : rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1 ;
    public final void rule__ComponentCategory__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5140:1: ( rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5141:2: rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_12__0__Impl_in_rule__ComponentCategory__Group_12__010293);
            rule__ComponentCategory__Group_12__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_12__1_in_rule__ComponentCategory__Group_12__010296);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5148:1: rule__ComponentCategory__Group_12__0__Impl : ( 'virtual' ) ;
    public final void rule__ComponentCategory__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5152:1: ( ( 'virtual' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5153:1: ( 'virtual' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5153:1: ( 'virtual' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5154:1: 'virtual'
            {
             before(grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
            match(input,53,FOLLOW_53_in_rule__ComponentCategory__Group_12__0__Impl10324); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5167:1: rule__ComponentCategory__Group_12__1 : rule__ComponentCategory__Group_12__1__Impl ;
    public final void rule__ComponentCategory__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5171:1: ( rule__ComponentCategory__Group_12__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5172:2: rule__ComponentCategory__Group_12__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_12__1__Impl_in_rule__ComponentCategory__Group_12__110355);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5178:1: rule__ComponentCategory__Group_12__1__Impl : ( 'bus' ) ;
    public final void rule__ComponentCategory__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5182:1: ( ( 'bus' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5183:1: ( 'bus' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5183:1: ( 'bus' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5184:1: 'bus'
            {
             before(grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
            match(input,9,FOLLOW_9_in_rule__ComponentCategory__Group_12__1__Impl10383); 
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


    // $ANTLR start "rule__FQCREF__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5201:1: rule__FQCREF__Group__0 : rule__FQCREF__Group__0__Impl rule__FQCREF__Group__1 ;
    public final void rule__FQCREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5205:1: ( rule__FQCREF__Group__0__Impl rule__FQCREF__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5206:2: rule__FQCREF__Group__0__Impl rule__FQCREF__Group__1
            {
            pushFollow(FOLLOW_rule__FQCREF__Group__0__Impl_in_rule__FQCREF__Group__010418);
            rule__FQCREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQCREF__Group__1_in_rule__FQCREF__Group__010421);
            rule__FQCREF__Group__1();

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
    // $ANTLR end "rule__FQCREF__Group__0"


    // $ANTLR start "rule__FQCREF__Group__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5213:1: rule__FQCREF__Group__0__Impl : ( ( ( rule__FQCREF__Group_0__0 ) ) ( ( rule__FQCREF__Group_0__0 )* ) ) ;
    public final void rule__FQCREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5217:1: ( ( ( ( rule__FQCREF__Group_0__0 ) ) ( ( rule__FQCREF__Group_0__0 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5218:1: ( ( ( rule__FQCREF__Group_0__0 ) ) ( ( rule__FQCREF__Group_0__0 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5218:1: ( ( ( rule__FQCREF__Group_0__0 ) ) ( ( rule__FQCREF__Group_0__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5219:1: ( ( rule__FQCREF__Group_0__0 ) ) ( ( rule__FQCREF__Group_0__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5219:1: ( ( rule__FQCREF__Group_0__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5220:1: ( rule__FQCREF__Group_0__0 )
            {
             before(grammarAccess.getFQCREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5221:1: ( rule__FQCREF__Group_0__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5221:2: rule__FQCREF__Group_0__0
            {
            pushFollow(FOLLOW_rule__FQCREF__Group_0__0_in_rule__FQCREF__Group__0__Impl10450);
            rule__FQCREF__Group_0__0();

            state._fsp--;


            }

             after(grammarAccess.getFQCREFAccess().getGroup_0()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5224:1: ( ( rule__FQCREF__Group_0__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5225:1: ( rule__FQCREF__Group_0__0 )*
            {
             before(grammarAccess.getFQCREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5226:1: ( rule__FQCREF__Group_0__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_ID) ) {
                    int LA37_1 = input.LA(2);

                    if ( (LA37_1==54) ) {
                        alt37=1;
                    }


                }


                switch (alt37) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5226:2: rule__FQCREF__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__FQCREF__Group_0__0_in_rule__FQCREF__Group__0__Impl10462);
            	    rule__FQCREF__Group_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

             after(grammarAccess.getFQCREFAccess().getGroup_0()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQCREF__Group__0__Impl"


    // $ANTLR start "rule__FQCREF__Group__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5237:1: rule__FQCREF__Group__1 : rule__FQCREF__Group__1__Impl rule__FQCREF__Group__2 ;
    public final void rule__FQCREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5241:1: ( rule__FQCREF__Group__1__Impl rule__FQCREF__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5242:2: rule__FQCREF__Group__1__Impl rule__FQCREF__Group__2
            {
            pushFollow(FOLLOW_rule__FQCREF__Group__1__Impl_in_rule__FQCREF__Group__110495);
            rule__FQCREF__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQCREF__Group__2_in_rule__FQCREF__Group__110498);
            rule__FQCREF__Group__2();

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
    // $ANTLR end "rule__FQCREF__Group__1"


    // $ANTLR start "rule__FQCREF__Group__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5249:1: rule__FQCREF__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__FQCREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5253:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5254:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5254:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5255:1: RULE_ID
            {
             before(grammarAccess.getFQCREFAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQCREF__Group__1__Impl10525); 
             after(grammarAccess.getFQCREFAccess().getIDTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQCREF__Group__1__Impl"


    // $ANTLR start "rule__FQCREF__Group__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5266:1: rule__FQCREF__Group__2 : rule__FQCREF__Group__2__Impl ;
    public final void rule__FQCREF__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5270:1: ( rule__FQCREF__Group__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5271:2: rule__FQCREF__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__FQCREF__Group__2__Impl_in_rule__FQCREF__Group__210554);
            rule__FQCREF__Group__2__Impl();

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
    // $ANTLR end "rule__FQCREF__Group__2"


    // $ANTLR start "rule__FQCREF__Group__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5277:1: rule__FQCREF__Group__2__Impl : ( ( rule__FQCREF__Group_2__0 )? ) ;
    public final void rule__FQCREF__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5281:1: ( ( ( rule__FQCREF__Group_2__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5282:1: ( ( rule__FQCREF__Group_2__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5282:1: ( ( rule__FQCREF__Group_2__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5283:1: ( rule__FQCREF__Group_2__0 )?
            {
             before(grammarAccess.getFQCREFAccess().getGroup_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5284:1: ( rule__FQCREF__Group_2__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==55) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5284:2: rule__FQCREF__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__FQCREF__Group_2__0_in_rule__FQCREF__Group__2__Impl10581);
                    rule__FQCREF__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFQCREFAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQCREF__Group__2__Impl"


    // $ANTLR start "rule__FQCREF__Group_0__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5300:1: rule__FQCREF__Group_0__0 : rule__FQCREF__Group_0__0__Impl rule__FQCREF__Group_0__1 ;
    public final void rule__FQCREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5304:1: ( rule__FQCREF__Group_0__0__Impl rule__FQCREF__Group_0__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5305:2: rule__FQCREF__Group_0__0__Impl rule__FQCREF__Group_0__1
            {
            pushFollow(FOLLOW_rule__FQCREF__Group_0__0__Impl_in_rule__FQCREF__Group_0__010618);
            rule__FQCREF__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQCREF__Group_0__1_in_rule__FQCREF__Group_0__010621);
            rule__FQCREF__Group_0__1();

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
    // $ANTLR end "rule__FQCREF__Group_0__0"


    // $ANTLR start "rule__FQCREF__Group_0__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5312:1: rule__FQCREF__Group_0__0__Impl : ( RULE_ID ) ;
    public final void rule__FQCREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5316:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5317:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5317:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5318:1: RULE_ID
            {
             before(grammarAccess.getFQCREFAccess().getIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQCREF__Group_0__0__Impl10648); 
             after(grammarAccess.getFQCREFAccess().getIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQCREF__Group_0__0__Impl"


    // $ANTLR start "rule__FQCREF__Group_0__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5329:1: rule__FQCREF__Group_0__1 : rule__FQCREF__Group_0__1__Impl ;
    public final void rule__FQCREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5333:1: ( rule__FQCREF__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5334:2: rule__FQCREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__FQCREF__Group_0__1__Impl_in_rule__FQCREF__Group_0__110677);
            rule__FQCREF__Group_0__1__Impl();

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
    // $ANTLR end "rule__FQCREF__Group_0__1"


    // $ANTLR start "rule__FQCREF__Group_0__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5340:1: rule__FQCREF__Group_0__1__Impl : ( '::' ) ;
    public final void rule__FQCREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5344:1: ( ( '::' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5345:1: ( '::' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5345:1: ( '::' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5346:1: '::'
            {
             before(grammarAccess.getFQCREFAccess().getColonColonKeyword_0_1()); 
            match(input,54,FOLLOW_54_in_rule__FQCREF__Group_0__1__Impl10705); 
             after(grammarAccess.getFQCREFAccess().getColonColonKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQCREF__Group_0__1__Impl"


    // $ANTLR start "rule__FQCREF__Group_2__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5363:1: rule__FQCREF__Group_2__0 : rule__FQCREF__Group_2__0__Impl rule__FQCREF__Group_2__1 ;
    public final void rule__FQCREF__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5367:1: ( rule__FQCREF__Group_2__0__Impl rule__FQCREF__Group_2__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5368:2: rule__FQCREF__Group_2__0__Impl rule__FQCREF__Group_2__1
            {
            pushFollow(FOLLOW_rule__FQCREF__Group_2__0__Impl_in_rule__FQCREF__Group_2__010740);
            rule__FQCREF__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQCREF__Group_2__1_in_rule__FQCREF__Group_2__010743);
            rule__FQCREF__Group_2__1();

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
    // $ANTLR end "rule__FQCREF__Group_2__0"


    // $ANTLR start "rule__FQCREF__Group_2__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5375:1: rule__FQCREF__Group_2__0__Impl : ( '.' ) ;
    public final void rule__FQCREF__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5379:1: ( ( '.' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5380:1: ( '.' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5380:1: ( '.' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5381:1: '.'
            {
             before(grammarAccess.getFQCREFAccess().getFullStopKeyword_2_0()); 
            match(input,55,FOLLOW_55_in_rule__FQCREF__Group_2__0__Impl10771); 
             after(grammarAccess.getFQCREFAccess().getFullStopKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQCREF__Group_2__0__Impl"


    // $ANTLR start "rule__FQCREF__Group_2__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5394:1: rule__FQCREF__Group_2__1 : rule__FQCREF__Group_2__1__Impl ;
    public final void rule__FQCREF__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5398:1: ( rule__FQCREF__Group_2__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5399:2: rule__FQCREF__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__FQCREF__Group_2__1__Impl_in_rule__FQCREF__Group_2__110802);
            rule__FQCREF__Group_2__1__Impl();

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
    // $ANTLR end "rule__FQCREF__Group_2__1"


    // $ANTLR start "rule__FQCREF__Group_2__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5405:1: rule__FQCREF__Group_2__1__Impl : ( RULE_ID ) ;
    public final void rule__FQCREF__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5409:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5410:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5410:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5411:1: RULE_ID
            {
             before(grammarAccess.getFQCREFAccess().getIDTerminalRuleCall_2_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQCREF__Group_2__1__Impl10829); 
             after(grammarAccess.getFQCREFAccess().getIDTerminalRuleCall_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQCREF__Group_2__1__Impl"


    // $ANTLR start "rule__INSTANCEREF__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5426:1: rule__INSTANCEREF__Group__0 : rule__INSTANCEREF__Group__0__Impl rule__INSTANCEREF__Group__1 ;
    public final void rule__INSTANCEREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5430:1: ( rule__INSTANCEREF__Group__0__Impl rule__INSTANCEREF__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5431:2: rule__INSTANCEREF__Group__0__Impl rule__INSTANCEREF__Group__1
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group__0__Impl_in_rule__INSTANCEREF__Group__010862);
            rule__INSTANCEREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREF__Group__1_in_rule__INSTANCEREF__Group__010865);
            rule__INSTANCEREF__Group__1();

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
    // $ANTLR end "rule__INSTANCEREF__Group__0"


    // $ANTLR start "rule__INSTANCEREF__Group__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5438:1: rule__INSTANCEREF__Group__0__Impl : ( ( rule__INSTANCEREF__Group_0__0 )* ) ;
    public final void rule__INSTANCEREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5442:1: ( ( ( rule__INSTANCEREF__Group_0__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5443:1: ( ( rule__INSTANCEREF__Group_0__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5443:1: ( ( rule__INSTANCEREF__Group_0__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5444:1: ( rule__INSTANCEREF__Group_0__0 )*
            {
             before(grammarAccess.getINSTANCEREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5445:1: ( rule__INSTANCEREF__Group_0__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==RULE_ID) ) {
                    int LA39_1 = input.LA(2);

                    if ( (LA39_1==55) ) {
                        alt39=1;
                    }


                }


                switch (alt39) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5445:2: rule__INSTANCEREF__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__INSTANCEREF__Group_0__0_in_rule__INSTANCEREF__Group__0__Impl10892);
            	    rule__INSTANCEREF__Group_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

             after(grammarAccess.getINSTANCEREFAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group__0__Impl"


    // $ANTLR start "rule__INSTANCEREF__Group__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5455:1: rule__INSTANCEREF__Group__1 : rule__INSTANCEREF__Group__1__Impl ;
    public final void rule__INSTANCEREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5459:1: ( rule__INSTANCEREF__Group__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5460:2: rule__INSTANCEREF__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group__1__Impl_in_rule__INSTANCEREF__Group__110923);
            rule__INSTANCEREF__Group__1__Impl();

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
    // $ANTLR end "rule__INSTANCEREF__Group__1"


    // $ANTLR start "rule__INSTANCEREF__Group__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5466:1: rule__INSTANCEREF__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__INSTANCEREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5470:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5471:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5471:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5472:1: RULE_ID
            {
             before(grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__INSTANCEREF__Group__1__Impl10950); 
             after(grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group__1__Impl"


    // $ANTLR start "rule__INSTANCEREF__Group_0__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5487:1: rule__INSTANCEREF__Group_0__0 : rule__INSTANCEREF__Group_0__0__Impl rule__INSTANCEREF__Group_0__1 ;
    public final void rule__INSTANCEREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5491:1: ( rule__INSTANCEREF__Group_0__0__Impl rule__INSTANCEREF__Group_0__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5492:2: rule__INSTANCEREF__Group_0__0__Impl rule__INSTANCEREF__Group_0__1
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_0__0__Impl_in_rule__INSTANCEREF__Group_0__010983);
            rule__INSTANCEREF__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREF__Group_0__1_in_rule__INSTANCEREF__Group_0__010986);
            rule__INSTANCEREF__Group_0__1();

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
    // $ANTLR end "rule__INSTANCEREF__Group_0__0"


    // $ANTLR start "rule__INSTANCEREF__Group_0__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5499:1: rule__INSTANCEREF__Group_0__0__Impl : ( RULE_ID ) ;
    public final void rule__INSTANCEREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5503:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5504:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5504:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5505:1: RULE_ID
            {
             before(grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__INSTANCEREF__Group_0__0__Impl11013); 
             after(grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group_0__0__Impl"


    // $ANTLR start "rule__INSTANCEREF__Group_0__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5516:1: rule__INSTANCEREF__Group_0__1 : rule__INSTANCEREF__Group_0__1__Impl ;
    public final void rule__INSTANCEREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5520:1: ( rule__INSTANCEREF__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5521:2: rule__INSTANCEREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_0__1__Impl_in_rule__INSTANCEREF__Group_0__111042);
            rule__INSTANCEREF__Group_0__1__Impl();

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
    // $ANTLR end "rule__INSTANCEREF__Group_0__1"


    // $ANTLR start "rule__INSTANCEREF__Group_0__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5527:1: rule__INSTANCEREF__Group_0__1__Impl : ( '.' ) ;
    public final void rule__INSTANCEREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5531:1: ( ( '.' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5532:1: ( '.' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5532:1: ( '.' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5533:1: '.'
            {
             before(grammarAccess.getINSTANCEREFAccess().getFullStopKeyword_0_1()); 
            match(input,55,FOLLOW_55_in_rule__INSTANCEREF__Group_0__1__Impl11070); 
             after(grammarAccess.getINSTANCEREFAccess().getFullStopKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group_0__1__Impl"


    // $ANTLR start "rule__SOMID__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5550:1: rule__SOMID__Group__0 : rule__SOMID__Group__0__Impl rule__SOMID__Group__1 ;
    public final void rule__SOMID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5554:1: ( rule__SOMID__Group__0__Impl rule__SOMID__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5555:2: rule__SOMID__Group__0__Impl rule__SOMID__Group__1
            {
            pushFollow(FOLLOW_rule__SOMID__Group__0__Impl_in_rule__SOMID__Group__011105);
            rule__SOMID__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SOMID__Group__1_in_rule__SOMID__Group__011108);
            rule__SOMID__Group__1();

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
    // $ANTLR end "rule__SOMID__Group__0"


    // $ANTLR start "rule__SOMID__Group__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5562:1: rule__SOMID__Group__0__Impl : ( ( rule__SOMID__Group_0__0 )* ) ;
    public final void rule__SOMID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5566:1: ( ( ( rule__SOMID__Group_0__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5567:1: ( ( rule__SOMID__Group_0__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5567:1: ( ( rule__SOMID__Group_0__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5568:1: ( rule__SOMID__Group_0__0 )*
            {
             before(grammarAccess.getSOMIDAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5569:1: ( rule__SOMID__Group_0__0 )*
            loop40:
            do {
                int alt40=2;
                alt40 = dfa40.predict(input);
                switch (alt40) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5569:2: rule__SOMID__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__SOMID__Group_0__0_in_rule__SOMID__Group__0__Impl11135);
            	    rule__SOMID__Group_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

             after(grammarAccess.getSOMIDAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SOMID__Group__0__Impl"


    // $ANTLR start "rule__SOMID__Group__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5579:1: rule__SOMID__Group__1 : rule__SOMID__Group__1__Impl ;
    public final void rule__SOMID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5583:1: ( rule__SOMID__Group__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5584:2: rule__SOMID__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SOMID__Group__1__Impl_in_rule__SOMID__Group__111166);
            rule__SOMID__Group__1__Impl();

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
    // $ANTLR end "rule__SOMID__Group__1"


    // $ANTLR start "rule__SOMID__Group__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5590:1: rule__SOMID__Group__1__Impl : ( ruleINSTANCEREF ) ;
    public final void rule__SOMID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5594:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5595:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5595:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5596:1: ruleINSTANCEREF
            {
             before(grammarAccess.getSOMIDAccess().getINSTANCEREFParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__SOMID__Group__1__Impl11193);
            ruleINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getSOMIDAccess().getINSTANCEREFParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SOMID__Group__1__Impl"


    // $ANTLR start "rule__SOMID__Group_0__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5611:1: rule__SOMID__Group_0__0 : rule__SOMID__Group_0__0__Impl rule__SOMID__Group_0__1 ;
    public final void rule__SOMID__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5615:1: ( rule__SOMID__Group_0__0__Impl rule__SOMID__Group_0__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5616:2: rule__SOMID__Group_0__0__Impl rule__SOMID__Group_0__1
            {
            pushFollow(FOLLOW_rule__SOMID__Group_0__0__Impl_in_rule__SOMID__Group_0__011226);
            rule__SOMID__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SOMID__Group_0__1_in_rule__SOMID__Group_0__011229);
            rule__SOMID__Group_0__1();

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
    // $ANTLR end "rule__SOMID__Group_0__0"


    // $ANTLR start "rule__SOMID__Group_0__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5623:1: rule__SOMID__Group_0__0__Impl : ( ruleINSTANCEREF ) ;
    public final void rule__SOMID__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5627:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5628:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5628:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5629:1: ruleINSTANCEREF
            {
             before(grammarAccess.getSOMIDAccess().getINSTANCEREFParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__SOMID__Group_0__0__Impl11256);
            ruleINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getSOMIDAccess().getINSTANCEREFParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SOMID__Group_0__0__Impl"


    // $ANTLR start "rule__SOMID__Group_0__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5640:1: rule__SOMID__Group_0__1 : rule__SOMID__Group_0__1__Impl ;
    public final void rule__SOMID__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5644:1: ( rule__SOMID__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5645:2: rule__SOMID__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__SOMID__Group_0__1__Impl_in_rule__SOMID__Group_0__111285);
            rule__SOMID__Group_0__1__Impl();

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
    // $ANTLR end "rule__SOMID__Group_0__1"


    // $ANTLR start "rule__SOMID__Group_0__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5651:1: rule__SOMID__Group_0__1__Impl : ( '#' ) ;
    public final void rule__SOMID__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5655:1: ( ( '#' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5656:1: ( '#' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5656:1: ( '#' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5657:1: '#'
            {
             before(grammarAccess.getSOMIDAccess().getNumberSignKeyword_0_1()); 
            match(input,56,FOLLOW_56_in_rule__SOMID__Group_0__1__Impl11313); 
             after(grammarAccess.getSOMIDAccess().getNumberSignKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SOMID__Group_0__1__Impl"


    // $ANTLR start "rule__SystemInstance__NameAssignment_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5675:1: rule__SystemInstance__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SystemInstance__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5679:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5680:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5680:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5681:1: RULE_ID
            {
             before(grammarAccess.getSystemInstanceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SystemInstance__NameAssignment_111353); 
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


    // $ANTLR start "rule__SystemInstance__CategoryAssignment_2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5690:1: rule__SystemInstance__CategoryAssignment_2 : ( ruleComponentCategory ) ;
    public final void rule__SystemInstance__CategoryAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5694:1: ( ( ruleComponentCategory ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5695:1: ( ruleComponentCategory )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5695:1: ( ruleComponentCategory )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5696:1: ruleComponentCategory
            {
             before(grammarAccess.getSystemInstanceAccess().getCategoryComponentCategoryParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_rule__SystemInstance__CategoryAssignment_211384);
            ruleComponentCategory();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getCategoryComponentCategoryParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__CategoryAssignment_2"


    // $ANTLR start "rule__SystemInstance__ComponentImplementationAssignment_4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5705:1: rule__SystemInstance__ComponentImplementationAssignment_4 : ( ( ruleFQCREF ) ) ;
    public final void rule__SystemInstance__ComponentImplementationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5709:1: ( ( ( ruleFQCREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5710:1: ( ( ruleFQCREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5710:1: ( ( ruleFQCREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5711:1: ( ruleFQCREF )
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationCrossReference_4_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5712:1: ( ruleFQCREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5713:1: ruleFQCREF
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationFQCREFParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_ruleFQCREF_in_rule__SystemInstance__ComponentImplementationAssignment_411419);
            ruleFQCREF();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationFQCREFParserRuleCall_4_0_1()); 

            }

             after(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__ComponentImplementationAssignment_4"


    // $ANTLR start "rule__SystemInstance__FeatureInstanceAssignment_5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5724:1: rule__SystemInstance__FeatureInstanceAssignment_5 : ( ruleFeatureInstance ) ;
    public final void rule__SystemInstance__FeatureInstanceAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5728:1: ( ( ruleFeatureInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5729:1: ( ruleFeatureInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5729:1: ( ruleFeatureInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5730:1: ruleFeatureInstance
            {
             before(grammarAccess.getSystemInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_rule__SystemInstance__FeatureInstanceAssignment_511454);
            ruleFeatureInstance();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__FeatureInstanceAssignment_5"


    // $ANTLR start "rule__SystemInstance__ComponentInstanceAssignment_6"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5739:1: rule__SystemInstance__ComponentInstanceAssignment_6 : ( ruleComponentInstance ) ;
    public final void rule__SystemInstance__ComponentInstanceAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5743:1: ( ( ruleComponentInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5744:1: ( ruleComponentInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5744:1: ( ruleComponentInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5745:1: ruleComponentInstance
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleComponentInstance_in_rule__SystemInstance__ComponentInstanceAssignment_611485);
            ruleComponentInstance();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__ComponentInstanceAssignment_6"


    // $ANTLR start "rule__SystemInstance__ModeInstanceAssignment_7"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5754:1: rule__SystemInstance__ModeInstanceAssignment_7 : ( ruleModeInstance ) ;
    public final void rule__SystemInstance__ModeInstanceAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5758:1: ( ( ruleModeInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5759:1: ( ruleModeInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5759:1: ( ruleModeInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5760:1: ruleModeInstance
            {
             before(grammarAccess.getSystemInstanceAccess().getModeInstanceModeInstanceParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleModeInstance_in_rule__SystemInstance__ModeInstanceAssignment_711516);
            ruleModeInstance();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getModeInstanceModeInstanceParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__ModeInstanceAssignment_7"


    // $ANTLR start "rule__SystemInstance__ModeTransitionInstanceAssignment_8"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5769:1: rule__SystemInstance__ModeTransitionInstanceAssignment_8 : ( ruleModeTransitionInstance ) ;
    public final void rule__SystemInstance__ModeTransitionInstanceAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5773:1: ( ( ruleModeTransitionInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5774:1: ( ruleModeTransitionInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5774:1: ( ruleModeTransitionInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5775:1: ruleModeTransitionInstance
            {
             before(grammarAccess.getSystemInstanceAccess().getModeTransitionInstanceModeTransitionInstanceParserRuleCall_8_0()); 
            pushFollow(FOLLOW_ruleModeTransitionInstance_in_rule__SystemInstance__ModeTransitionInstanceAssignment_811547);
            ruleModeTransitionInstance();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getModeTransitionInstanceModeTransitionInstanceParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__ModeTransitionInstanceAssignment_8"


    // $ANTLR start "rule__SystemInstance__FlowSpecificationAssignment_9"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5784:1: rule__SystemInstance__FlowSpecificationAssignment_9 : ( ruleFlowSpecInstance ) ;
    public final void rule__SystemInstance__FlowSpecificationAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5788:1: ( ( ruleFlowSpecInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5789:1: ( ruleFlowSpecInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5789:1: ( ruleFlowSpecInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5790:1: ruleFlowSpecInstance
            {
             before(grammarAccess.getSystemInstanceAccess().getFlowSpecificationFlowSpecInstanceParserRuleCall_9_0()); 
            pushFollow(FOLLOW_ruleFlowSpecInstance_in_rule__SystemInstance__FlowSpecificationAssignment_911578);
            ruleFlowSpecInstance();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getFlowSpecificationFlowSpecInstanceParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__FlowSpecificationAssignment_9"


    // $ANTLR start "rule__SystemInstance__EndToEndFlowAssignment_10"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5799:1: rule__SystemInstance__EndToEndFlowAssignment_10 : ( ruleEndToEndFlowInstance ) ;
    public final void rule__SystemInstance__EndToEndFlowAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5803:1: ( ( ruleEndToEndFlowInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5804:1: ( ruleEndToEndFlowInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5804:1: ( ruleEndToEndFlowInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5805:1: ruleEndToEndFlowInstance
            {
             before(grammarAccess.getSystemInstanceAccess().getEndToEndFlowEndToEndFlowInstanceParserRuleCall_10_0()); 
            pushFollow(FOLLOW_ruleEndToEndFlowInstance_in_rule__SystemInstance__EndToEndFlowAssignment_1011609);
            ruleEndToEndFlowInstance();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getEndToEndFlowEndToEndFlowInstanceParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__EndToEndFlowAssignment_10"


    // $ANTLR start "rule__SystemInstance__ConnectionInstanceAssignment_11"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5814:1: rule__SystemInstance__ConnectionInstanceAssignment_11 : ( ruleConnectionInstance ) ;
    public final void rule__SystemInstance__ConnectionInstanceAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5818:1: ( ( ruleConnectionInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5819:1: ( ruleConnectionInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5819:1: ( ruleConnectionInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5820:1: ruleConnectionInstance
            {
             before(grammarAccess.getSystemInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_11_0()); 
            pushFollow(FOLLOW_ruleConnectionInstance_in_rule__SystemInstance__ConnectionInstanceAssignment_1111640);
            ruleConnectionInstance();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__ConnectionInstanceAssignment_11"


    // $ANTLR start "rule__SystemInstance__SystemOperationModeAssignment_12"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5829:1: rule__SystemInstance__SystemOperationModeAssignment_12 : ( ruleSystemOperationMode ) ;
    public final void rule__SystemInstance__SystemOperationModeAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5833:1: ( ( ruleSystemOperationMode ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5834:1: ( ruleSystemOperationMode )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5834:1: ( ruleSystemOperationMode )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5835:1: ruleSystemOperationMode
            {
             before(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_12_0()); 
            pushFollow(FOLLOW_ruleSystemOperationMode_in_rule__SystemInstance__SystemOperationModeAssignment_1211671);
            ruleSystemOperationMode();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__SystemOperationModeAssignment_12"


    // $ANTLR start "rule__ComponentInstance__CategoryAssignment_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5844:1: rule__ComponentInstance__CategoryAssignment_0 : ( ruleComponentCategory ) ;
    public final void rule__ComponentInstance__CategoryAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5848:1: ( ( ruleComponentCategory ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5849:1: ( ruleComponentCategory )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5849:1: ( ruleComponentCategory )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5850:1: ruleComponentCategory
            {
             before(grammarAccess.getComponentInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_rule__ComponentInstance__CategoryAssignment_011702);
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


    // $ANTLR start "rule__ComponentInstance__NameAssignment_2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5859:1: rule__ComponentInstance__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ComponentInstance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5863:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5864:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5864:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5865:1: RULE_ID
            {
             before(grammarAccess.getComponentInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ComponentInstance__NameAssignment_211733); 
             after(grammarAccess.getComponentInstanceAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__NameAssignment_2"


    // $ANTLR start "rule__ComponentInstance__IndexAssignment_3_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5874:1: rule__ComponentInstance__IndexAssignment_3_1 : ( ruleINTVALUE ) ;
    public final void rule__ComponentInstance__IndexAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5878:1: ( ( ruleINTVALUE ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5879:1: ( ruleINTVALUE )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5879:1: ( ruleINTVALUE )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5880:1: ruleINTVALUE
            {
             before(grammarAccess.getComponentInstanceAccess().getIndexINTVALUEParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleINTVALUE_in_rule__ComponentInstance__IndexAssignment_3_111764);
            ruleINTVALUE();

            state._fsp--;

             after(grammarAccess.getComponentInstanceAccess().getIndexINTVALUEParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__IndexAssignment_3_1"


    // $ANTLR start "rule__ComponentInstance__SubcomponentAssignment_5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5889:1: rule__ComponentInstance__SubcomponentAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__ComponentInstance__SubcomponentAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5893:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5894:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5894:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5895:1: ( RULE_ID )
            {
             before(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentCrossReference_5_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5896:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5897:1: RULE_ID
            {
             before(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ComponentInstance__SubcomponentAssignment_511799); 
             after(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentIDTerminalRuleCall_5_0_1()); 

            }

             after(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__SubcomponentAssignment_5"


    // $ANTLR start "rule__ComponentInstance__FeatureInstanceAssignment_6"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5908:1: rule__ComponentInstance__FeatureInstanceAssignment_6 : ( ruleFeatureInstance ) ;
    public final void rule__ComponentInstance__FeatureInstanceAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5912:1: ( ( ruleFeatureInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5913:1: ( ruleFeatureInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5913:1: ( ruleFeatureInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5914:1: ruleFeatureInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_rule__ComponentInstance__FeatureInstanceAssignment_611834);
            ruleFeatureInstance();

            state._fsp--;

             after(grammarAccess.getComponentInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__FeatureInstanceAssignment_6"


    // $ANTLR start "rule__ComponentInstance__ComponentInstanceAssignment_7"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5923:1: rule__ComponentInstance__ComponentInstanceAssignment_7 : ( ruleComponentInstance ) ;
    public final void rule__ComponentInstance__ComponentInstanceAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5927:1: ( ( ruleComponentInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5928:1: ( ruleComponentInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5928:1: ( ruleComponentInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5929:1: ruleComponentInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleComponentInstance_in_rule__ComponentInstance__ComponentInstanceAssignment_711865);
            ruleComponentInstance();

            state._fsp--;

             after(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__ComponentInstanceAssignment_7"


    // $ANTLR start "rule__ComponentInstance__ModeInstanceAssignment_8"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5938:1: rule__ComponentInstance__ModeInstanceAssignment_8 : ( ruleModeInstance ) ;
    public final void rule__ComponentInstance__ModeInstanceAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5942:1: ( ( ruleModeInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5943:1: ( ruleModeInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5943:1: ( ruleModeInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5944:1: ruleModeInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getModeInstanceModeInstanceParserRuleCall_8_0()); 
            pushFollow(FOLLOW_ruleModeInstance_in_rule__ComponentInstance__ModeInstanceAssignment_811896);
            ruleModeInstance();

            state._fsp--;

             after(grammarAccess.getComponentInstanceAccess().getModeInstanceModeInstanceParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__ModeInstanceAssignment_8"


    // $ANTLR start "rule__ComponentInstance__ModeTransitionInstanceAssignment_9"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5953:1: rule__ComponentInstance__ModeTransitionInstanceAssignment_9 : ( ruleModeTransitionInstance ) ;
    public final void rule__ComponentInstance__ModeTransitionInstanceAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5957:1: ( ( ruleModeTransitionInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5958:1: ( ruleModeTransitionInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5958:1: ( ruleModeTransitionInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5959:1: ruleModeTransitionInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getModeTransitionInstanceModeTransitionInstanceParserRuleCall_9_0()); 
            pushFollow(FOLLOW_ruleModeTransitionInstance_in_rule__ComponentInstance__ModeTransitionInstanceAssignment_911927);
            ruleModeTransitionInstance();

            state._fsp--;

             after(grammarAccess.getComponentInstanceAccess().getModeTransitionInstanceModeTransitionInstanceParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__ModeTransitionInstanceAssignment_9"


    // $ANTLR start "rule__ComponentInstance__FlowSpecificationAssignment_10"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5968:1: rule__ComponentInstance__FlowSpecificationAssignment_10 : ( ruleFlowSpecInstance ) ;
    public final void rule__ComponentInstance__FlowSpecificationAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5972:1: ( ( ruleFlowSpecInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5973:1: ( ruleFlowSpecInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5973:1: ( ruleFlowSpecInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5974:1: ruleFlowSpecInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getFlowSpecificationFlowSpecInstanceParserRuleCall_10_0()); 
            pushFollow(FOLLOW_ruleFlowSpecInstance_in_rule__ComponentInstance__FlowSpecificationAssignment_1011958);
            ruleFlowSpecInstance();

            state._fsp--;

             after(grammarAccess.getComponentInstanceAccess().getFlowSpecificationFlowSpecInstanceParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__FlowSpecificationAssignment_10"


    // $ANTLR start "rule__ComponentInstance__EndToEndFlowAssignment_11"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5983:1: rule__ComponentInstance__EndToEndFlowAssignment_11 : ( ruleEndToEndFlowInstance ) ;
    public final void rule__ComponentInstance__EndToEndFlowAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5987:1: ( ( ruleEndToEndFlowInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5988:1: ( ruleEndToEndFlowInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5988:1: ( ruleEndToEndFlowInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5989:1: ruleEndToEndFlowInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getEndToEndFlowEndToEndFlowInstanceParserRuleCall_11_0()); 
            pushFollow(FOLLOW_ruleEndToEndFlowInstance_in_rule__ComponentInstance__EndToEndFlowAssignment_1111989);
            ruleEndToEndFlowInstance();

            state._fsp--;

             after(grammarAccess.getComponentInstanceAccess().getEndToEndFlowEndToEndFlowInstanceParserRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__EndToEndFlowAssignment_11"


    // $ANTLR start "rule__ComponentInstance__ConnectionInstanceAssignment_12"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5998:1: rule__ComponentInstance__ConnectionInstanceAssignment_12 : ( ruleConnectionInstance ) ;
    public final void rule__ComponentInstance__ConnectionInstanceAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6002:1: ( ( ruleConnectionInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6003:1: ( ruleConnectionInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6003:1: ( ruleConnectionInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6004:1: ruleConnectionInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_12_0()); 
            pushFollow(FOLLOW_ruleConnectionInstance_in_rule__ComponentInstance__ConnectionInstanceAssignment_1212020);
            ruleConnectionInstance();

            state._fsp--;

             after(grammarAccess.getComponentInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__ConnectionInstanceAssignment_12"


    // $ANTLR start "rule__ComponentInstance__InModeAssignment_13_2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6013:1: rule__ComponentInstance__InModeAssignment_13_2 : ( ( RULE_ID ) ) ;
    public final void rule__ComponentInstance__InModeAssignment_13_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6017:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6018:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6018:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6019:1: ( RULE_ID )
            {
             before(grammarAccess.getComponentInstanceAccess().getInModeModeInstanceCrossReference_13_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6020:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6021:1: RULE_ID
            {
             before(grammarAccess.getComponentInstanceAccess().getInModeModeInstanceIDTerminalRuleCall_13_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ComponentInstance__InModeAssignment_13_212055); 
             after(grammarAccess.getComponentInstanceAccess().getInModeModeInstanceIDTerminalRuleCall_13_2_0_1()); 

            }

             after(grammarAccess.getComponentInstanceAccess().getInModeModeInstanceCrossReference_13_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__InModeAssignment_13_2"


    // $ANTLR start "rule__FeatureInstance__CategoryAssignment_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6032:1: rule__FeatureInstance__CategoryAssignment_0 : ( ruleFeatureCategory ) ;
    public final void rule__FeatureInstance__CategoryAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6036:1: ( ( ruleFeatureCategory ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6037:1: ( ruleFeatureCategory )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6037:1: ( ruleFeatureCategory )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6038:1: ruleFeatureCategory
            {
             before(grammarAccess.getFeatureInstanceAccess().getCategoryFeatureCategoryParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleFeatureCategory_in_rule__FeatureInstance__CategoryAssignment_012090);
            ruleFeatureCategory();

            state._fsp--;

             after(grammarAccess.getFeatureInstanceAccess().getCategoryFeatureCategoryParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__CategoryAssignment_0"


    // $ANTLR start "rule__FeatureInstance__NameAssignment_2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6047:1: rule__FeatureInstance__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__FeatureInstance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6051:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6052:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6052:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6053:1: RULE_ID
            {
             before(grammarAccess.getFeatureInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FeatureInstance__NameAssignment_212121); 
             after(grammarAccess.getFeatureInstanceAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__NameAssignment_2"


    // $ANTLR start "rule__FeatureInstance__IndexAssignment_3_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6062:1: rule__FeatureInstance__IndexAssignment_3_1 : ( ruleINTVALUE ) ;
    public final void rule__FeatureInstance__IndexAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6066:1: ( ( ruleINTVALUE ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6067:1: ( ruleINTVALUE )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6067:1: ( ruleINTVALUE )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6068:1: ruleINTVALUE
            {
             before(grammarAccess.getFeatureInstanceAccess().getIndexINTVALUEParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleINTVALUE_in_rule__FeatureInstance__IndexAssignment_3_112152);
            ruleINTVALUE();

            state._fsp--;

             after(grammarAccess.getFeatureInstanceAccess().getIndexINTVALUEParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__IndexAssignment_3_1"


    // $ANTLR start "rule__FeatureInstance__FeatureAssignment_5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6077:1: rule__FeatureInstance__FeatureAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__FeatureInstance__FeatureAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6081:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6082:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6082:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6083:1: ( RULE_ID )
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureCrossReference_5_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6084:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6085:1: RULE_ID
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FeatureInstance__FeatureAssignment_512187); 
             after(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureIDTerminalRuleCall_5_0_1()); 

            }

             after(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__FeatureAssignment_5"


    // $ANTLR start "rule__FeatureInstance__DirectionAssignment_6"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6096:1: rule__FeatureInstance__DirectionAssignment_6 : ( ruleDirectionType ) ;
    public final void rule__FeatureInstance__DirectionAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6100:1: ( ( ruleDirectionType ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6101:1: ( ruleDirectionType )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6101:1: ( ruleDirectionType )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6102:1: ruleDirectionType
            {
             before(grammarAccess.getFeatureInstanceAccess().getDirectionDirectionTypeParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleDirectionType_in_rule__FeatureInstance__DirectionAssignment_612222);
            ruleDirectionType();

            state._fsp--;

             after(grammarAccess.getFeatureInstanceAccess().getDirectionDirectionTypeParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__DirectionAssignment_6"


    // $ANTLR start "rule__FeatureInstance__FeatureInstanceAssignment_7"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6111:1: rule__FeatureInstance__FeatureInstanceAssignment_7 : ( ruleFeatureInstance ) ;
    public final void rule__FeatureInstance__FeatureInstanceAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6115:1: ( ( ruleFeatureInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6116:1: ( ruleFeatureInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6116:1: ( ruleFeatureInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6117:1: ruleFeatureInstance
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_rule__FeatureInstance__FeatureInstanceAssignment_712253);
            ruleFeatureInstance();

            state._fsp--;

             after(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__FeatureInstanceAssignment_7"


    // $ANTLR start "rule__ModeInstance__NameAssignment_2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6126:1: rule__ModeInstance__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ModeInstance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6130:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6131:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6131:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6132:1: RULE_ID
            {
             before(grammarAccess.getModeInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ModeInstance__NameAssignment_212284); 
             after(grammarAccess.getModeInstanceAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeInstance__NameAssignment_2"


    // $ANTLR start "rule__ModeInstance__ModeAssignment_4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6141:1: rule__ModeInstance__ModeAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__ModeInstance__ModeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6145:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6146:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6146:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6147:1: ( RULE_ID )
            {
             before(grammarAccess.getModeInstanceAccess().getModeModeCrossReference_4_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6148:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6149:1: RULE_ID
            {
             before(grammarAccess.getModeInstanceAccess().getModeModeIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ModeInstance__ModeAssignment_412319); 
             after(grammarAccess.getModeInstanceAccess().getModeModeIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getModeInstanceAccess().getModeModeCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeInstance__ModeAssignment_4"


    // $ANTLR start "rule__ModeInstance__InitialAssignment_5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6160:1: rule__ModeInstance__InitialAssignment_5 : ( ( 'initial' ) ) ;
    public final void rule__ModeInstance__InitialAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6164:1: ( ( ( 'initial' ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6165:1: ( ( 'initial' ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6165:1: ( ( 'initial' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6166:1: ( 'initial' )
            {
             before(grammarAccess.getModeInstanceAccess().getInitialInitialKeyword_5_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6167:1: ( 'initial' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6168:1: 'initial'
            {
             before(grammarAccess.getModeInstanceAccess().getInitialInitialKeyword_5_0()); 
            match(input,57,FOLLOW_57_in_rule__ModeInstance__InitialAssignment_512359); 
             after(grammarAccess.getModeInstanceAccess().getInitialInitialKeyword_5_0()); 

            }

             after(grammarAccess.getModeInstanceAccess().getInitialInitialKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeInstance__InitialAssignment_5"


    // $ANTLR start "rule__ModeTransitionInstance__NameAssignment_3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6183:1: rule__ModeTransitionInstance__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__ModeTransitionInstance__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6187:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6188:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6188:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6189:1: RULE_ID
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__NameAssignment_312398); 
             after(grammarAccess.getModeTransitionInstanceAccess().getNameIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeTransitionInstance__NameAssignment_3"


    // $ANTLR start "rule__ModeTransitionInstance__ModeTransitionAssignment_5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6198:1: rule__ModeTransitionInstance__ModeTransitionAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__ModeTransitionInstance__ModeTransitionAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6202:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6203:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6203:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6204:1: ( RULE_ID )
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionModeTransitionCrossReference_5_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6205:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6206:1: RULE_ID
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionModeTransitionIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__ModeTransitionAssignment_512433); 
             after(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionModeTransitionIDTerminalRuleCall_5_0_1()); 

            }

             after(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionModeTransitionCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeTransitionInstance__ModeTransitionAssignment_5"


    // $ANTLR start "rule__ModeTransitionInstance__SourceAssignment_7"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6217:1: rule__ModeTransitionInstance__SourceAssignment_7 : ( ( RULE_ID ) ) ;
    public final void rule__ModeTransitionInstance__SourceAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6221:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6222:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6222:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6223:1: ( RULE_ID )
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getSourceModeInstanceCrossReference_7_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6224:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6225:1: RULE_ID
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getSourceModeInstanceIDTerminalRuleCall_7_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__SourceAssignment_712472); 
             after(grammarAccess.getModeTransitionInstanceAccess().getSourceModeInstanceIDTerminalRuleCall_7_0_1()); 

            }

             after(grammarAccess.getModeTransitionInstanceAccess().getSourceModeInstanceCrossReference_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeTransitionInstance__SourceAssignment_7"


    // $ANTLR start "rule__ModeTransitionInstance__DestinationAssignment_9"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6236:1: rule__ModeTransitionInstance__DestinationAssignment_9 : ( ( RULE_ID ) ) ;
    public final void rule__ModeTransitionInstance__DestinationAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6240:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6241:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6241:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6242:1: ( RULE_ID )
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getDestinationModeInstanceCrossReference_9_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6243:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6244:1: RULE_ID
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getDestinationModeInstanceIDTerminalRuleCall_9_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__DestinationAssignment_912511); 
             after(grammarAccess.getModeTransitionInstanceAccess().getDestinationModeInstanceIDTerminalRuleCall_9_0_1()); 

            }

             after(grammarAccess.getModeTransitionInstanceAccess().getDestinationModeInstanceCrossReference_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModeTransitionInstance__DestinationAssignment_9"


    // $ANTLR start "rule__FlowSpecInstance__NameAssignment_2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6255:1: rule__FlowSpecInstance__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__FlowSpecInstance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6259:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6260:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6260:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6261:1: RULE_ID
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FlowSpecInstance__NameAssignment_212546); 
             after(grammarAccess.getFlowSpecInstanceAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__NameAssignment_2"


    // $ANTLR start "rule__FlowSpecInstance__FlowSpecificationAssignment_4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6270:1: rule__FlowSpecInstance__FlowSpecificationAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__FlowSpecInstance__FlowSpecificationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6274:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6275:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6275:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6276:1: ( RULE_ID )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getFlowSpecificationFlowSpecificationCrossReference_4_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6277:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6278:1: RULE_ID
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getFlowSpecificationFlowSpecificationIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FlowSpecInstance__FlowSpecificationAssignment_412581); 
             after(grammarAccess.getFlowSpecInstanceAccess().getFlowSpecificationFlowSpecificationIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getFlowSpecInstanceAccess().getFlowSpecificationFlowSpecificationCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__FlowSpecificationAssignment_4"


    // $ANTLR start "rule__FlowSpecInstance__SourceAssignment_5_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6289:1: rule__FlowSpecInstance__SourceAssignment_5_1 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__FlowSpecInstance__SourceAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6293:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6294:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6294:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6295:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getSourceFeatureInstanceCrossReference_5_1_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6296:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6297:1: ruleINSTANCEREF
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getSourceFeatureInstanceINSTANCEREFParserRuleCall_5_1_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__FlowSpecInstance__SourceAssignment_5_112620);
            ruleINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getFlowSpecInstanceAccess().getSourceFeatureInstanceINSTANCEREFParserRuleCall_5_1_0_1()); 

            }

             after(grammarAccess.getFlowSpecInstanceAccess().getSourceFeatureInstanceCrossReference_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__SourceAssignment_5_1"


    // $ANTLR start "rule__FlowSpecInstance__DestinationAssignment_6_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6308:1: rule__FlowSpecInstance__DestinationAssignment_6_1 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__FlowSpecInstance__DestinationAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6312:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6313:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6313:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6314:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getDestinationFeatureInstanceCrossReference_6_1_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6315:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6316:1: ruleINSTANCEREF
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getDestinationFeatureInstanceINSTANCEREFParserRuleCall_6_1_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__FlowSpecInstance__DestinationAssignment_6_112659);
            ruleINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getFlowSpecInstanceAccess().getDestinationFeatureInstanceINSTANCEREFParserRuleCall_6_1_0_1()); 

            }

             after(grammarAccess.getFlowSpecInstanceAccess().getDestinationFeatureInstanceCrossReference_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__DestinationAssignment_6_1"


    // $ANTLR start "rule__FlowSpecInstance__InModeAssignment_7_2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6327:1: rule__FlowSpecInstance__InModeAssignment_7_2 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__FlowSpecInstance__InModeAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6331:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6332:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6332:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6333:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInModeModeInstanceCrossReference_7_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6334:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6335:1: ruleINSTANCEREF
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInModeModeInstanceINSTANCEREFParserRuleCall_7_2_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__FlowSpecInstance__InModeAssignment_7_212698);
            ruleINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getFlowSpecInstanceAccess().getInModeModeInstanceINSTANCEREFParserRuleCall_7_2_0_1()); 

            }

             after(grammarAccess.getFlowSpecInstanceAccess().getInModeModeInstanceCrossReference_7_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__InModeAssignment_7_2"


    // $ANTLR start "rule__FlowSpecInstance__InModeTransitionAssignment_8_2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6346:1: rule__FlowSpecInstance__InModeTransitionAssignment_8_2 : ( ( RULE_ID ) ) ;
    public final void rule__FlowSpecInstance__InModeTransitionAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6350:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6351:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6351:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6352:1: ( RULE_ID )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6353:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6354:1: RULE_ID
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInModeTransitionModeTransitionInstanceIDTerminalRuleCall_8_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FlowSpecInstance__InModeTransitionAssignment_8_212737); 
             after(grammarAccess.getFlowSpecInstanceAccess().getInModeTransitionModeTransitionInstanceIDTerminalRuleCall_8_2_0_1()); 

            }

             after(grammarAccess.getFlowSpecInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecInstance__InModeTransitionAssignment_8_2"


    // $ANTLR start "rule__EndToEndFlowInstance__NameAssignment_2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6365:1: rule__EndToEndFlowInstance__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EndToEndFlowInstance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6369:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6370:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6370:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6371:1: RULE_ID
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EndToEndFlowInstance__NameAssignment_212772); 
             after(grammarAccess.getEndToEndFlowInstanceAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndToEndFlowInstance__NameAssignment_2"


    // $ANTLR start "rule__EndToEndFlowInstance__EndToEndFlowAssignment_4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6380:1: rule__EndToEndFlowInstance__EndToEndFlowAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__EndToEndFlowInstance__EndToEndFlowAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6384:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6385:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6385:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6386:1: ( RULE_ID )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowEndToEndFlowCrossReference_4_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6387:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6388:1: RULE_ID
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowEndToEndFlowIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EndToEndFlowInstance__EndToEndFlowAssignment_412807); 
             after(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowEndToEndFlowIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowEndToEndFlowCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndToEndFlowInstance__EndToEndFlowAssignment_4"


    // $ANTLR start "rule__EndToEndFlowInstance__FlowElementAssignment_5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6399:1: rule__EndToEndFlowInstance__FlowElementAssignment_5 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__EndToEndFlowInstance__FlowElementAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6403:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6404:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6404:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6405:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceCrossReference_5_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6406:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6407:1: ruleINSTANCEREF
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceINSTANCEREFParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__EndToEndFlowInstance__FlowElementAssignment_512846);
            ruleINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceINSTANCEREFParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndToEndFlowInstance__FlowElementAssignment_5"


    // $ANTLR start "rule__EndToEndFlowInstance__InModeAssignment_6_2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6418:1: rule__EndToEndFlowInstance__InModeAssignment_6_2 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__EndToEndFlowInstance__InModeAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6422:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6423:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6423:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6424:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInModeModeInstanceCrossReference_6_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6425:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6426:1: ruleINSTANCEREF
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInModeModeInstanceINSTANCEREFParserRuleCall_6_2_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__EndToEndFlowInstance__InModeAssignment_6_212885);
            ruleINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getEndToEndFlowInstanceAccess().getInModeModeInstanceINSTANCEREFParserRuleCall_6_2_0_1()); 

            }

             after(grammarAccess.getEndToEndFlowInstanceAccess().getInModeModeInstanceCrossReference_6_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndToEndFlowInstance__InModeAssignment_6_2"


    // $ANTLR start "rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6437:1: rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2 : ( ( ruleSOMID ) ) ;
    public final void rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6441:1: ( ( ( ruleSOMID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6442:1: ( ( ruleSOMID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6442:1: ( ( ruleSOMID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6443:1: ( ruleSOMID )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_7_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6444:1: ( ruleSOMID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6445:1: ruleSOMID
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeSOMIDParserRuleCall_7_2_0_1()); 
            pushFollow(FOLLOW_ruleSOMID_in_rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_212924);
            ruleSOMID();

            state._fsp--;

             after(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeSOMIDParserRuleCall_7_2_0_1()); 

            }

             after(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_7_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2"


    // $ANTLR start "rule__SystemOperationMode__NameAssignment_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6456:1: rule__SystemOperationMode__NameAssignment_1 : ( ruleSOMID ) ;
    public final void rule__SystemOperationMode__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6460:1: ( ( ruleSOMID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6461:1: ( ruleSOMID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6461:1: ( ruleSOMID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6462:1: ruleSOMID
            {
             before(grammarAccess.getSystemOperationModeAccess().getNameSOMIDParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleSOMID_in_rule__SystemOperationMode__NameAssignment_112959);
            ruleSOMID();

            state._fsp--;

             after(grammarAccess.getSystemOperationModeAccess().getNameSOMIDParserRuleCall_1_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__SystemOperationMode__CurrentModeAssignment_2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6471:1: rule__SystemOperationMode__CurrentModeAssignment_2 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__SystemOperationMode__CurrentModeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6475:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6476:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6476:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6477:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceCrossReference_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6478:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6479:1: ruleINSTANCEREF
            {
             before(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceINSTANCEREFParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__SystemOperationMode__CurrentModeAssignment_212994);
            ruleINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceINSTANCEREFParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemOperationMode__CurrentModeAssignment_2"


    // $ANTLR start "rule__ConnectionInstance__KindAssignment_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6490:1: rule__ConnectionInstance__KindAssignment_0 : ( ruleConnectionKind ) ;
    public final void rule__ConnectionInstance__KindAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6494:1: ( ( ruleConnectionKind ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6495:1: ( ruleConnectionKind )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6495:1: ( ruleConnectionKind )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6496:1: ruleConnectionKind
            {
             before(grammarAccess.getConnectionInstanceAccess().getKindConnectionKindParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleConnectionKind_in_rule__ConnectionInstance__KindAssignment_013029);
            ruleConnectionKind();

            state._fsp--;

             after(grammarAccess.getConnectionInstanceAccess().getKindConnectionKindParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__KindAssignment_0"


    // $ANTLR start "rule__ConnectionInstance__ConnectionReferenceAssignment_4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6505:1: rule__ConnectionInstance__ConnectionReferenceAssignment_4 : ( ruleConnectionReference ) ;
    public final void rule__ConnectionInstance__ConnectionReferenceAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6509:1: ( ( ruleConnectionReference ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6510:1: ( ruleConnectionReference )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6510:1: ( ruleConnectionReference )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6511:1: ruleConnectionReference
            {
             before(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceConnectionReferenceParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleConnectionReference_in_rule__ConnectionInstance__ConnectionReferenceAssignment_413060);
            ruleConnectionReference();

            state._fsp--;

             after(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceConnectionReferenceParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__ConnectionReferenceAssignment_4"


    // $ANTLR start "rule__ConnectionInstance__SourceAssignment_6"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6520:1: rule__ConnectionInstance__SourceAssignment_6 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionInstance__SourceAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6524:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6525:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6525:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6526:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndCrossReference_6_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6527:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6528:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndINSTANCEREFParserRuleCall_6_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__SourceAssignment_613095);
            ruleINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndINSTANCEREFParserRuleCall_6_0_1()); 

            }

             after(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndCrossReference_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__SourceAssignment_6"


    // $ANTLR start "rule__ConnectionInstance__DestinationAssignment_8"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6539:1: rule__ConnectionInstance__DestinationAssignment_8 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionInstance__DestinationAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6543:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6544:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6544:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6545:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndCrossReference_8_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6546:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6547:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndINSTANCEREFParserRuleCall_8_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__DestinationAssignment_813134);
            ruleINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndINSTANCEREFParserRuleCall_8_0_1()); 

            }

             after(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndCrossReference_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__DestinationAssignment_8"


    // $ANTLR start "rule__ConnectionInstance__InSystemOperationModeAssignment_9_2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6558:1: rule__ConnectionInstance__InSystemOperationModeAssignment_9_2 : ( ( ruleSOMID ) ) ;
    public final void rule__ConnectionInstance__InSystemOperationModeAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6562:1: ( ( ( ruleSOMID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6563:1: ( ( ruleSOMID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6563:1: ( ( ruleSOMID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6564:1: ( ruleSOMID )
            {
             before(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_9_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6565:1: ( ruleSOMID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6566:1: ruleSOMID
            {
             before(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeSOMIDParserRuleCall_9_2_0_1()); 
            pushFollow(FOLLOW_ruleSOMID_in_rule__ConnectionInstance__InSystemOperationModeAssignment_9_213173);
            ruleSOMID();

            state._fsp--;

             after(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeSOMIDParserRuleCall_9_2_0_1()); 

            }

             after(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_9_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__InSystemOperationModeAssignment_9_2"


    // $ANTLR start "rule__ConnectionInstance__InModeTransitionAssignment_10_2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6577:1: rule__ConnectionInstance__InModeTransitionAssignment_10_2 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionInstance__InModeTransitionAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6581:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6582:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6582:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6583:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_10_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6584:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6585:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceINSTANCEREFParserRuleCall_10_2_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__InModeTransitionAssignment_10_213212);
            ruleINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceINSTANCEREFParserRuleCall_10_2_0_1()); 

            }

             after(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_10_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__InModeTransitionAssignment_10_2"


    // $ANTLR start "rule__ConnectionInstance__CompleteAssignment_11"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6596:1: rule__ConnectionInstance__CompleteAssignment_11 : ( ( 'complete' ) ) ;
    public final void rule__ConnectionInstance__CompleteAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6600:1: ( ( ( 'complete' ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6601:1: ( ( 'complete' ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6601:1: ( ( 'complete' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6602:1: ( 'complete' )
            {
             before(grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_11_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6603:1: ( 'complete' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6604:1: 'complete'
            {
             before(grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_11_0()); 
            match(input,58,FOLLOW_58_in_rule__ConnectionInstance__CompleteAssignment_1113252); 
             after(grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_11_0()); 

            }

             after(grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__CompleteAssignment_11"


    // $ANTLR start "rule__ConnectionInstance__BidirectionalAssignment_12"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6619:1: rule__ConnectionInstance__BidirectionalAssignment_12 : ( ( 'bidirectional' ) ) ;
    public final void rule__ConnectionInstance__BidirectionalAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6623:1: ( ( ( 'bidirectional' ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6624:1: ( ( 'bidirectional' ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6624:1: ( ( 'bidirectional' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6625:1: ( 'bidirectional' )
            {
             before(grammarAccess.getConnectionInstanceAccess().getBidirectionalBidirectionalKeyword_12_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6626:1: ( 'bidirectional' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6627:1: 'bidirectional'
            {
             before(grammarAccess.getConnectionInstanceAccess().getBidirectionalBidirectionalKeyword_12_0()); 
            match(input,59,FOLLOW_59_in_rule__ConnectionInstance__BidirectionalAssignment_1213296); 
             after(grammarAccess.getConnectionInstanceAccess().getBidirectionalBidirectionalKeyword_12_0()); 

            }

             after(grammarAccess.getConnectionInstanceAccess().getBidirectionalBidirectionalKeyword_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__BidirectionalAssignment_12"


    // $ANTLR start "rule__ConnectionReference__ConnectionAssignment_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6642:1: rule__ConnectionReference__ConnectionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ConnectionReference__ConnectionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6646:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6647:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6647:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6648:1: ( RULE_ID )
            {
             before(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionCrossReference_1_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6649:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6650:1: RULE_ID
            {
             before(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ConnectionReference__ConnectionAssignment_113339); 
             after(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionReference__ConnectionAssignment_1"


    // $ANTLR start "rule__ConnectionReference__SourceAssignment_3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6661:1: rule__ConnectionReference__SourceAssignment_3 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionReference__SourceAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6665:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6666:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6666:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6667:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndCrossReference_3_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6668:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6669:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndINSTANCEREFParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__SourceAssignment_313378);
            ruleINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndINSTANCEREFParserRuleCall_3_0_1()); 

            }

             after(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionReference__SourceAssignment_3"


    // $ANTLR start "rule__ConnectionReference__DestinationAssignment_5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6680:1: rule__ConnectionReference__DestinationAssignment_5 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionReference__DestinationAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6684:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6685:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6685:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6686:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndCrossReference_5_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6687:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6688:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndINSTANCEREFParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__DestinationAssignment_513417);
            ruleINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndINSTANCEREFParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionReference__DestinationAssignment_5"


    // $ANTLR start "rule__ConnectionReference__ContextAssignment_7"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6699:1: rule__ConnectionReference__ContextAssignment_7 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionReference__ContextAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6703:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6704:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6704:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6705:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceCrossReference_7_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6706:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6707:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceINSTANCEREFParserRuleCall_7_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__ContextAssignment_713456);
            ruleINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceINSTANCEREFParserRuleCall_7_0_1()); 

            }

             after(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceCrossReference_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionReference__ContextAssignment_7"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA40 dfa40 = new DFA40(this);
    static final String DFA1_eotS =
        "\20\uffff";
    static final String DFA1_eofS =
        "\10\uffff\1\17\7\uffff";
    static final String DFA1_minS =
        "\1\10\7\uffff\1\46\7\uffff";
    static final String DFA1_maxS =
        "\1\65\7\uffff\1\64\7\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\1\13\1\14\1\15"+
        "\1\16\1\11\1\10";
    static final String DFA1_specialS =
        "\20\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\15\41\uffff"+
            "\1\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\17\1\uffff\1\17\13\uffff\1\16",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "564:1: rule__ComponentCategory__Alternatives : ( ( 'abstract' ) | ( 'bus' ) | ( 'data' ) | ( 'device' ) | ( 'memory' ) | ( 'process' ) | ( 'processor' ) | ( 'subprogram' ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( 'system' ) | ( 'threadgroup' ) | ( 'thread' ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( 'virtualprocessor' ) );";
        }
    }
    static final String DFA40_eotS =
        "\5\uffff";
    static final String DFA40_eofS =
        "\1\uffff\1\3\3\uffff";
    static final String DFA40_minS =
        "\2\5\2\uffff\1\5";
    static final String DFA40_maxS =
        "\1\5\1\73\2\uffff\1\5";
    static final String DFA40_acceptS =
        "\2\uffff\1\1\1\2\1\uffff";
    static final String DFA40_specialS =
        "\5\uffff}>";
    static final String[] DFA40_transitionS = {
            "\1\1",
            "\1\3\30\uffff\1\3\10\uffff\1\3\17\uffff\1\4\1\2\1\uffff\2"+
            "\3",
            "",
            "",
            "\1\1"
    };

    static final short[] DFA40_eot = DFA.unpackEncodedString(DFA40_eotS);
    static final short[] DFA40_eof = DFA.unpackEncodedString(DFA40_eofS);
    static final char[] DFA40_min = DFA.unpackEncodedStringToUnsignedChars(DFA40_minS);
    static final char[] DFA40_max = DFA.unpackEncodedStringToUnsignedChars(DFA40_maxS);
    static final short[] DFA40_accept = DFA.unpackEncodedString(DFA40_acceptS);
    static final short[] DFA40_special = DFA.unpackEncodedString(DFA40_specialS);
    static final short[][] DFA40_transition;

    static {
        int numStates = DFA40_transitionS.length;
        DFA40_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA40_transition[i] = DFA.unpackEncodedString(DFA40_transitionS[i]);
        }
    }

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = DFA40_eot;
            this.eof = DFA40_eof;
            this.min = DFA40_min;
            this.max = DFA40_max;
            this.accept = DFA40_accept;
            this.special = DFA40_special;
            this.transition = DFA40_transition;
        }
        public String getDescription() {
            return "()* loopback of 5569:1: ( rule__SOMID__Group_0__0 )*";
        }
    }
 

    public static final BitSet FOLLOW_ruleSystemInstance_in_entryRuleSystemInstance61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemInstance68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__0_in_ruleSystemInstance94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_entryRuleComponentInstance121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentInstance128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__0_in_ruleComponentInstance154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_entryRuleFeatureInstance181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureInstance188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__0_in_ruleFeatureInstance214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeInstance_in_entryRuleModeInstance241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModeInstance248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__0_in_ruleModeInstance274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeTransitionInstance_in_entryRuleModeTransitionInstance301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModeTransitionInstance308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__0_in_ruleModeTransitionInstance334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSpecInstance_in_entryRuleFlowSpecInstance361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSpecInstance368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__0_in_ruleFlowSpecInstance394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndToEndFlowInstance_in_entryRuleEndToEndFlowInstance421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEndToEndFlowInstance428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__0_in_ruleEndToEndFlowInstance454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemOperationMode488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__0_in_ruleSystemOperationMode514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_entryRuleConnectionInstance541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionInstance548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__0_in_ruleConnectionInstance574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionReference_in_entryRuleConnectionReference601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionReference608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__0_in_ruleConnectionReference634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentCategory668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Alternatives_in_ruleComponentCategory694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCategory728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCategory__Alternatives_in_ruleFeatureCategory754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_entryRuleDirectionType781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDirectionType788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DirectionType__Alternatives_in_ruleDirectionType814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionKind_in_entryRuleConnectionKind841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionKind848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionKind__Alternatives_in_ruleConnectionKind874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQCREF_in_entryRuleFQCREF901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQCREF908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group__0_in_ruleFQCREF934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_entryRuleINSTANCEREF961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINSTANCEREF968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group__0_in_ruleINSTANCEREF994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSOMID_in_entryRuleSOMID1021 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSOMID1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SOMID__Group__0_in_ruleSOMID1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTVALUE_in_entryRuleINTVALUE1081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINTVALUE1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleINTVALUE1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_8_in_rule__ComponentCategory__Alternatives1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_rule__ComponentCategory__Alternatives1170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__ComponentCategory__Alternatives1190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__ComponentCategory__Alternatives1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ComponentCategory__Alternatives1230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ComponentCategory__Alternatives1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__ComponentCategory__Alternatives1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ComponentCategory__Alternatives1290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__0_in_rule__ComponentCategory__Alternatives1309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ComponentCategory__Alternatives1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__ComponentCategory__Alternatives1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ComponentCategory__Alternatives1368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__0_in_rule__ComponentCategory__Alternatives1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ComponentCategory__Alternatives1406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__FeatureCategory__Alternatives1441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__FeatureCategory__Alternatives1461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__FeatureCategory__Alternatives1481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__FeatureCategory__Alternatives1501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__FeatureCategory__Alternatives1521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__FeatureCategory__Alternatives1541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__FeatureCategory__Alternatives1561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__FeatureCategory__Alternatives1581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__FeatureCategory__Alternatives1601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__FeatureCategory__Alternatives1621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__DirectionType__Alternatives1656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__DirectionType__Alternatives1676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__DirectionType__Alternatives1696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ConnectionKind__Alternatives1731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__ConnectionKind__Alternatives1751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ConnectionKind__Alternatives1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ConnectionKind__Alternatives1791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ConnectionKind__Alternatives1811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ConnectionKind__Alternatives1831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__0__Impl_in_rule__SystemInstance__Group__01863 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__1_in_rule__SystemInstance__Group__01866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__SystemInstance__Group__0__Impl1894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__1__Impl_in_rule__SystemInstance__Group__11925 = new BitSet(new long[]{0x00200000000FFF00L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__2_in_rule__SystemInstance__Group__11928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__NameAssignment_1_in_rule__SystemInstance__Group__1__Impl1955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__2__Impl_in_rule__SystemInstance__Group__21985 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__3_in_rule__SystemInstance__Group__21988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__CategoryAssignment_2_in_rule__SystemInstance__Group__2__Impl2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__3__Impl_in_rule__SystemInstance__Group__32045 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__4_in_rule__SystemInstance__Group__32048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__SystemInstance__Group__3__Impl2076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__4__Impl_in_rule__SystemInstance__Group__42107 = new BitSet(new long[]{0x0023889E3FFFFF00L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__5_in_rule__SystemInstance__Group__42110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__ComponentImplementationAssignment_4_in_rule__SystemInstance__Group__4__Impl2137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__5__Impl_in_rule__SystemInstance__Group__52167 = new BitSet(new long[]{0x0023889E3FFFFF00L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__6_in_rule__SystemInstance__Group__52170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__FeatureInstanceAssignment_5_in_rule__SystemInstance__Group__5__Impl2197 = new BitSet(new long[]{0x000000003FF00002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__6__Impl_in_rule__SystemInstance__Group__62228 = new BitSet(new long[]{0x0023889E3FFFFF00L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__7_in_rule__SystemInstance__Group__62231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__ComponentInstanceAssignment_6_in_rule__SystemInstance__Group__6__Impl2258 = new BitSet(new long[]{0x00200000000FFF02L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__7__Impl_in_rule__SystemInstance__Group__72289 = new BitSet(new long[]{0x0023889E3FFFFF00L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__8_in_rule__SystemInstance__Group__72292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__ModeInstanceAssignment_7_in_rule__SystemInstance__Group__7__Impl2319 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__8__Impl_in_rule__SystemInstance__Group__82350 = new BitSet(new long[]{0x0023889E3FFFFF00L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__9_in_rule__SystemInstance__Group__82353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__ModeTransitionInstanceAssignment_8_in_rule__SystemInstance__Group__8__Impl2380 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__9__Impl_in_rule__SystemInstance__Group__92411 = new BitSet(new long[]{0x0023889E3FFFFF00L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__10_in_rule__SystemInstance__Group__92414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__FlowSpecificationAssignment_9_in_rule__SystemInstance__Group__9__Impl2441 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__10__Impl_in_rule__SystemInstance__Group__102472 = new BitSet(new long[]{0x0023889E3FFFFF00L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__11_in_rule__SystemInstance__Group__102475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__EndToEndFlowAssignment_10_in_rule__SystemInstance__Group__10__Impl2502 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__11__Impl_in_rule__SystemInstance__Group__112533 = new BitSet(new long[]{0x0023889E3FFFFF00L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__12_in_rule__SystemInstance__Group__112536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__ConnectionInstanceAssignment_11_in_rule__SystemInstance__Group__11__Impl2563 = new BitSet(new long[]{0x0000001E10800002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__12__Impl_in_rule__SystemInstance__Group__122594 = new BitSet(new long[]{0x0023889E3FFFFF00L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__13_in_rule__SystemInstance__Group__122597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__SystemOperationModeAssignment_12_in_rule__SystemInstance__Group__12__Impl2624 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__13__Impl_in_rule__SystemInstance__Group__132655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__SystemInstance__Group__13__Impl2683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__0__Impl_in_rule__ComponentInstance__Group__02742 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__1_in_rule__ComponentInstance__Group__02745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__CategoryAssignment_0_in_rule__ComponentInstance__Group__0__Impl2772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__1__Impl_in_rule__ComponentInstance__Group__12802 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__2_in_rule__ComponentInstance__Group__12805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ComponentInstance__Group__1__Impl2833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__2__Impl_in_rule__ComponentInstance__Group__22864 = new BitSet(new long[]{0x0000024000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__3_in_rule__ComponentInstance__Group__22867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__NameAssignment_2_in_rule__ComponentInstance__Group__2__Impl2894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__3__Impl_in_rule__ComponentInstance__Group__32924 = new BitSet(new long[]{0x0000024000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__4_in_rule__ComponentInstance__Group__32927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_3__0_in_rule__ComponentInstance__Group__3__Impl2954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__4__Impl_in_rule__ComponentInstance__Group__42985 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__5_in_rule__ComponentInstance__Group__42988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ComponentInstance__Group__4__Impl3016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__5__Impl_in_rule__ComponentInstance__Group__53047 = new BitSet(new long[]{0x0021889E7FFFFF00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__6_in_rule__ComponentInstance__Group__53050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__SubcomponentAssignment_5_in_rule__ComponentInstance__Group__5__Impl3077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__6__Impl_in_rule__ComponentInstance__Group__63107 = new BitSet(new long[]{0x0021889E7FFFFF00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__7_in_rule__ComponentInstance__Group__63110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__FeatureInstanceAssignment_6_in_rule__ComponentInstance__Group__6__Impl3137 = new BitSet(new long[]{0x000000003FF00002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__7__Impl_in_rule__ComponentInstance__Group__73168 = new BitSet(new long[]{0x0021889E7FFFFF00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__8_in_rule__ComponentInstance__Group__73171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__ComponentInstanceAssignment_7_in_rule__ComponentInstance__Group__7__Impl3198 = new BitSet(new long[]{0x00200000000FFF02L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__8__Impl_in_rule__ComponentInstance__Group__83229 = new BitSet(new long[]{0x0021889E7FFFFF00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__9_in_rule__ComponentInstance__Group__83232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__ModeInstanceAssignment_8_in_rule__ComponentInstance__Group__8__Impl3259 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__9__Impl_in_rule__ComponentInstance__Group__93290 = new BitSet(new long[]{0x0021889E7FFFFF00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__10_in_rule__ComponentInstance__Group__93293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__ModeTransitionInstanceAssignment_9_in_rule__ComponentInstance__Group__9__Impl3320 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__10__Impl_in_rule__ComponentInstance__Group__103351 = new BitSet(new long[]{0x0021889E7FFFFF00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__11_in_rule__ComponentInstance__Group__103354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__FlowSpecificationAssignment_10_in_rule__ComponentInstance__Group__10__Impl3381 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__11__Impl_in_rule__ComponentInstance__Group__113412 = new BitSet(new long[]{0x0021889E7FFFFF00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__12_in_rule__ComponentInstance__Group__113415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__EndToEndFlowAssignment_11_in_rule__ComponentInstance__Group__11__Impl3442 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__12__Impl_in_rule__ComponentInstance__Group__123473 = new BitSet(new long[]{0x0021889E7FFFFF00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__13_in_rule__ComponentInstance__Group__123476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__ConnectionInstanceAssignment_12_in_rule__ComponentInstance__Group__12__Impl3503 = new BitSet(new long[]{0x0000001E10800002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__13__Impl_in_rule__ComponentInstance__Group__133534 = new BitSet(new long[]{0x0021889E7FFFFF00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__14_in_rule__ComponentInstance__Group__133537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_13__0_in_rule__ComponentInstance__Group__13__Impl3564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__14__Impl_in_rule__ComponentInstance__Group__143595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ComponentInstance__Group__14__Impl3623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_3__0__Impl_in_rule__ComponentInstance__Group_3__03684 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_3__1_in_rule__ComponentInstance__Group_3__03687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ComponentInstance__Group_3__0__Impl3715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_3__1__Impl_in_rule__ComponentInstance__Group_3__13746 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_3__2_in_rule__ComponentInstance__Group_3__13749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__IndexAssignment_3_1_in_rule__ComponentInstance__Group_3__1__Impl3778 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ComponentInstance__IndexAssignment_3_1_in_rule__ComponentInstance__Group_3__1__Impl3790 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_3__2__Impl_in_rule__ComponentInstance__Group_3__23823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__ComponentInstance__Group_3__2__Impl3851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_13__0__Impl_in_rule__ComponentInstance__Group_13__03888 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_13__1_in_rule__ComponentInstance__Group_13__03891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ComponentInstance__Group_13__0__Impl3919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_13__1__Impl_in_rule__ComponentInstance__Group_13__13950 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_13__2_in_rule__ComponentInstance__Group_13__13953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__ComponentInstance__Group_13__1__Impl3981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_13__2__Impl_in_rule__ComponentInstance__Group_13__24012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__InModeAssignment_13_2_in_rule__ComponentInstance__Group_13__2__Impl4039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__0__Impl_in_rule__FeatureInstance__Group__04075 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__1_in_rule__FeatureInstance__Group__04078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__CategoryAssignment_0_in_rule__FeatureInstance__Group__0__Impl4105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__1__Impl_in_rule__FeatureInstance__Group__14135 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__2_in_rule__FeatureInstance__Group__14138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__FeatureInstance__Group__1__Impl4166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__2__Impl_in_rule__FeatureInstance__Group__24197 = new BitSet(new long[]{0x0000024000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__3_in_rule__FeatureInstance__Group__24200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__NameAssignment_2_in_rule__FeatureInstance__Group__2__Impl4227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__3__Impl_in_rule__FeatureInstance__Group__34257 = new BitSet(new long[]{0x0000024000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__4_in_rule__FeatureInstance__Group__34260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__0_in_rule__FeatureInstance__Group__3__Impl4287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__4__Impl_in_rule__FeatureInstance__Group__44318 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__5_in_rule__FeatureInstance__Group__44321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__FeatureInstance__Group__4__Impl4349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__5__Impl_in_rule__FeatureInstance__Group__54380 = new BitSet(new long[]{0x00000001C0000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__6_in_rule__FeatureInstance__Group__54383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__FeatureAssignment_5_in_rule__FeatureInstance__Group__5__Impl4410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__6__Impl_in_rule__FeatureInstance__Group__64440 = new BitSet(new long[]{0x000000003FF00000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__7_in_rule__FeatureInstance__Group__64443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__DirectionAssignment_6_in_rule__FeatureInstance__Group__6__Impl4470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__7__Impl_in_rule__FeatureInstance__Group__74500 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__8_in_rule__FeatureInstance__Group__74503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__FeatureInstanceAssignment_7_in_rule__FeatureInstance__Group__7__Impl4530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__8__Impl_in_rule__FeatureInstance__Group__84560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__FeatureInstance__Group__8__Impl4588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__0__Impl_in_rule__FeatureInstance__Group_3__04637 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__1_in_rule__FeatureInstance__Group_3__04640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__FeatureInstance__Group_3__0__Impl4668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__1__Impl_in_rule__FeatureInstance__Group_3__14699 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__2_in_rule__FeatureInstance__Group_3__14702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__IndexAssignment_3_1_in_rule__FeatureInstance__Group_3__1__Impl4729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__2__Impl_in_rule__FeatureInstance__Group_3__24759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__FeatureInstance__Group_3__2__Impl4787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__0__Impl_in_rule__ModeInstance__Group__04824 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__1_in_rule__ModeInstance__Group__04827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__ModeInstance__Group__0__Impl4855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__1__Impl_in_rule__ModeInstance__Group__14886 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__2_in_rule__ModeInstance__Group__14889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ModeInstance__Group__1__Impl4917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__2__Impl_in_rule__ModeInstance__Group__24948 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__3_in_rule__ModeInstance__Group__24951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__NameAssignment_2_in_rule__ModeInstance__Group__2__Impl4978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__3__Impl_in_rule__ModeInstance__Group__35008 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__4_in_rule__ModeInstance__Group__35011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ModeInstance__Group__3__Impl5039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__4__Impl_in_rule__ModeInstance__Group__45070 = new BitSet(new long[]{0x0200008000000000L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__5_in_rule__ModeInstance__Group__45073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__ModeAssignment_4_in_rule__ModeInstance__Group__4__Impl5100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__5__Impl_in_rule__ModeInstance__Group__55130 = new BitSet(new long[]{0x0200008000000000L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__6_in_rule__ModeInstance__Group__55133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__InitialAssignment_5_in_rule__ModeInstance__Group__5__Impl5160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__6__Impl_in_rule__ModeInstance__Group__65191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ModeInstance__Group__6__Impl5219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__0__Impl_in_rule__ModeTransitionInstance__Group__05264 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__1_in_rule__ModeTransitionInstance__Group__05267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__ModeTransitionInstance__Group__0__Impl5295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__1__Impl_in_rule__ModeTransitionInstance__Group__15326 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__2_in_rule__ModeTransitionInstance__Group__15329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__ModeTransitionInstance__Group__1__Impl5357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__2__Impl_in_rule__ModeTransitionInstance__Group__25388 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__3_in_rule__ModeTransitionInstance__Group__25391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ModeTransitionInstance__Group__2__Impl5419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__3__Impl_in_rule__ModeTransitionInstance__Group__35450 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__4_in_rule__ModeTransitionInstance__Group__35453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__NameAssignment_3_in_rule__ModeTransitionInstance__Group__3__Impl5480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__4__Impl_in_rule__ModeTransitionInstance__Group__45510 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__5_in_rule__ModeTransitionInstance__Group__45513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ModeTransitionInstance__Group__4__Impl5541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__5__Impl_in_rule__ModeTransitionInstance__Group__55572 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__6_in_rule__ModeTransitionInstance__Group__55575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__ModeTransitionAssignment_5_in_rule__ModeTransitionInstance__Group__5__Impl5602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__6__Impl_in_rule__ModeTransitionInstance__Group__65632 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__7_in_rule__ModeTransitionInstance__Group__65635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__ModeTransitionInstance__Group__6__Impl5663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__7__Impl_in_rule__ModeTransitionInstance__Group__75694 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__8_in_rule__ModeTransitionInstance__Group__75697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__SourceAssignment_7_in_rule__ModeTransitionInstance__Group__7__Impl5724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__8__Impl_in_rule__ModeTransitionInstance__Group__85754 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__9_in_rule__ModeTransitionInstance__Group__85757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ModeTransitionInstance__Group__8__Impl5785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__9__Impl_in_rule__ModeTransitionInstance__Group__95816 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__10_in_rule__ModeTransitionInstance__Group__95819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__DestinationAssignment_9_in_rule__ModeTransitionInstance__Group__9__Impl5846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__10__Impl_in_rule__ModeTransitionInstance__Group__105876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ModeTransitionInstance__Group__10__Impl5904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__0__Impl_in_rule__FlowSpecInstance__Group__05957 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__1_in_rule__FlowSpecInstance__Group__05960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__FlowSpecInstance__Group__0__Impl5988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__1__Impl_in_rule__FlowSpecInstance__Group__16019 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__2_in_rule__FlowSpecInstance__Group__16022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__FlowSpecInstance__Group__1__Impl6050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__2__Impl_in_rule__FlowSpecInstance__Group__26081 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__3_in_rule__FlowSpecInstance__Group__26084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__NameAssignment_2_in_rule__FlowSpecInstance__Group__2__Impl6111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__3__Impl_in_rule__FlowSpecInstance__Group__36141 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__4_in_rule__FlowSpecInstance__Group__36144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__FlowSpecInstance__Group__3__Impl6172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__4__Impl_in_rule__FlowSpecInstance__Group__46203 = new BitSet(new long[]{0x0000608040000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__5_in_rule__FlowSpecInstance__Group__46206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__FlowSpecificationAssignment_4_in_rule__FlowSpecInstance__Group__4__Impl6233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__5__Impl_in_rule__FlowSpecInstance__Group__56263 = new BitSet(new long[]{0x0000608040000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__6_in_rule__FlowSpecInstance__Group__56266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_5__0_in_rule__FlowSpecInstance__Group__5__Impl6293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__6__Impl_in_rule__FlowSpecInstance__Group__66324 = new BitSet(new long[]{0x0000608040000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__7_in_rule__FlowSpecInstance__Group__66327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_6__0_in_rule__FlowSpecInstance__Group__6__Impl6354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__7__Impl_in_rule__FlowSpecInstance__Group__76385 = new BitSet(new long[]{0x0000608040000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__8_in_rule__FlowSpecInstance__Group__76388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_7__0_in_rule__FlowSpecInstance__Group__7__Impl6415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__8__Impl_in_rule__FlowSpecInstance__Group__86446 = new BitSet(new long[]{0x0000608040000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__9_in_rule__FlowSpecInstance__Group__86449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_8__0_in_rule__FlowSpecInstance__Group__8__Impl6476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__9__Impl_in_rule__FlowSpecInstance__Group__96507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__FlowSpecInstance__Group__9__Impl6535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_5__0__Impl_in_rule__FlowSpecInstance__Group_5__06586 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_5__1_in_rule__FlowSpecInstance__Group_5__06589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__FlowSpecInstance__Group_5__0__Impl6617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_5__1__Impl_in_rule__FlowSpecInstance__Group_5__16648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__SourceAssignment_5_1_in_rule__FlowSpecInstance__Group_5__1__Impl6675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_6__0__Impl_in_rule__FlowSpecInstance__Group_6__06709 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_6__1_in_rule__FlowSpecInstance__Group_6__06712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__FlowSpecInstance__Group_6__0__Impl6740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_6__1__Impl_in_rule__FlowSpecInstance__Group_6__16771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__DestinationAssignment_6_1_in_rule__FlowSpecInstance__Group_6__1__Impl6798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_7__0__Impl_in_rule__FlowSpecInstance__Group_7__06832 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_7__1_in_rule__FlowSpecInstance__Group_7__06835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__FlowSpecInstance__Group_7__0__Impl6863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_7__1__Impl_in_rule__FlowSpecInstance__Group_7__16894 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_7__2_in_rule__FlowSpecInstance__Group_7__16897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__FlowSpecInstance__Group_7__1__Impl6925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_7__2__Impl_in_rule__FlowSpecInstance__Group_7__26956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__InModeAssignment_7_2_in_rule__FlowSpecInstance__Group_7__2__Impl6983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_8__0__Impl_in_rule__FlowSpecInstance__Group_8__07019 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_8__1_in_rule__FlowSpecInstance__Group_8__07022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__FlowSpecInstance__Group_8__0__Impl7050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_8__1__Impl_in_rule__FlowSpecInstance__Group_8__17081 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_8__2_in_rule__FlowSpecInstance__Group_8__17084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__FlowSpecInstance__Group_8__1__Impl7112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_8__2__Impl_in_rule__FlowSpecInstance__Group_8__27143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__InModeTransitionAssignment_8_2_in_rule__FlowSpecInstance__Group_8__2__Impl7170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__0__Impl_in_rule__EndToEndFlowInstance__Group__07206 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__1_in_rule__EndToEndFlowInstance__Group__07209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__EndToEndFlowInstance__Group__0__Impl7237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__1__Impl_in_rule__EndToEndFlowInstance__Group__17268 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__2_in_rule__EndToEndFlowInstance__Group__17271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__EndToEndFlowInstance__Group__1__Impl7299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__2__Impl_in_rule__EndToEndFlowInstance__Group__27330 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__3_in_rule__EndToEndFlowInstance__Group__27333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__NameAssignment_2_in_rule__EndToEndFlowInstance__Group__2__Impl7360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__3__Impl_in_rule__EndToEndFlowInstance__Group__37390 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__4_in_rule__EndToEndFlowInstance__Group__37393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__EndToEndFlowInstance__Group__3__Impl7421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__4__Impl_in_rule__EndToEndFlowInstance__Group__47452 = new BitSet(new long[]{0x0000008040000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__5_in_rule__EndToEndFlowInstance__Group__47455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__EndToEndFlowAssignment_4_in_rule__EndToEndFlowInstance__Group__4__Impl7482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__5__Impl_in_rule__EndToEndFlowInstance__Group__57512 = new BitSet(new long[]{0x0000008040000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__6_in_rule__EndToEndFlowInstance__Group__57515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__FlowElementAssignment_5_in_rule__EndToEndFlowInstance__Group__5__Impl7542 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__6__Impl_in_rule__EndToEndFlowInstance__Group__67573 = new BitSet(new long[]{0x0000008040000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__7_in_rule__EndToEndFlowInstance__Group__67576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_6__0_in_rule__EndToEndFlowInstance__Group__6__Impl7603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__7__Impl_in_rule__EndToEndFlowInstance__Group__77634 = new BitSet(new long[]{0x0000008040000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__8_in_rule__EndToEndFlowInstance__Group__77637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_7__0_in_rule__EndToEndFlowInstance__Group__7__Impl7664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__8__Impl_in_rule__EndToEndFlowInstance__Group__87695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__EndToEndFlowInstance__Group__8__Impl7723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_6__0__Impl_in_rule__EndToEndFlowInstance__Group_6__07772 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_6__1_in_rule__EndToEndFlowInstance__Group_6__07775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__EndToEndFlowInstance__Group_6__0__Impl7803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_6__1__Impl_in_rule__EndToEndFlowInstance__Group_6__17834 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_6__2_in_rule__EndToEndFlowInstance__Group_6__17837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__EndToEndFlowInstance__Group_6__1__Impl7865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_6__2__Impl_in_rule__EndToEndFlowInstance__Group_6__27896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__InModeAssignment_6_2_in_rule__EndToEndFlowInstance__Group_6__2__Impl7923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_7__0__Impl_in_rule__EndToEndFlowInstance__Group_7__07959 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_7__1_in_rule__EndToEndFlowInstance__Group_7__07962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__EndToEndFlowInstance__Group_7__0__Impl7990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_7__1__Impl_in_rule__EndToEndFlowInstance__Group_7__18021 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_7__2_in_rule__EndToEndFlowInstance__Group_7__18024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__EndToEndFlowInstance__Group_7__1__Impl8052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_7__2__Impl_in_rule__EndToEndFlowInstance__Group_7__28083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2_in_rule__EndToEndFlowInstance__Group_7__2__Impl8110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__0__Impl_in_rule__SystemOperationMode__Group__08146 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__1_in_rule__SystemOperationMode__Group__08149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__SystemOperationMode__Group__0__Impl8177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__1__Impl_in_rule__SystemOperationMode__Group__18208 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__2_in_rule__SystemOperationMode__Group__18211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__NameAssignment_1_in_rule__SystemOperationMode__Group__1__Impl8238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__2__Impl_in_rule__SystemOperationMode__Group__28268 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__3_in_rule__SystemOperationMode__Group__28271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__CurrentModeAssignment_2_in_rule__SystemOperationMode__Group__2__Impl8298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__3__Impl_in_rule__SystemOperationMode__Group__38328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__SystemOperationMode__Group__3__Impl8356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__0__Impl_in_rule__ConnectionInstance__Group__08395 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__1_in_rule__ConnectionInstance__Group__08398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__KindAssignment_0_in_rule__ConnectionInstance__Group__0__Impl8425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__1__Impl_in_rule__ConnectionInstance__Group__18455 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__2_in_rule__ConnectionInstance__Group__18458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__ConnectionInstance__Group__1__Impl8486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__2__Impl_in_rule__ConnectionInstance__Group__28517 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__3_in_rule__ConnectionInstance__Group__28520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ConnectionInstance__Group__2__Impl8548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__3__Impl_in_rule__ConnectionInstance__Group__38579 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__4_in_rule__ConnectionInstance__Group__38582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ConnectionInstance__Group__3__Impl8610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__4__Impl_in_rule__ConnectionInstance__Group__48641 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__5_in_rule__ConnectionInstance__Group__48644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__ConnectionReferenceAssignment_4_in_rule__ConnectionInstance__Group__4__Impl8673 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__ConnectionReferenceAssignment_4_in_rule__ConnectionInstance__Group__4__Impl8685 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__5__Impl_in_rule__ConnectionInstance__Group__58718 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__6_in_rule__ConnectionInstance__Group__58721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__ConnectionInstance__Group__5__Impl8749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__6__Impl_in_rule__ConnectionInstance__Group__68780 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__7_in_rule__ConnectionInstance__Group__68783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__SourceAssignment_6_in_rule__ConnectionInstance__Group__6__Impl8810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__7__Impl_in_rule__ConnectionInstance__Group__78840 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__8_in_rule__ConnectionInstance__Group__78843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ConnectionInstance__Group__7__Impl8871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__8__Impl_in_rule__ConnectionInstance__Group__88902 = new BitSet(new long[]{0x0C00008040000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__9_in_rule__ConnectionInstance__Group__88905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__DestinationAssignment_8_in_rule__ConnectionInstance__Group__8__Impl8932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__9__Impl_in_rule__ConnectionInstance__Group__98962 = new BitSet(new long[]{0x0C00008040000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__10_in_rule__ConnectionInstance__Group__98965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_9__0_in_rule__ConnectionInstance__Group__9__Impl8992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__10__Impl_in_rule__ConnectionInstance__Group__109023 = new BitSet(new long[]{0x0C00008040000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__11_in_rule__ConnectionInstance__Group__109026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_10__0_in_rule__ConnectionInstance__Group__10__Impl9053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__11__Impl_in_rule__ConnectionInstance__Group__119084 = new BitSet(new long[]{0x0C00008040000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__12_in_rule__ConnectionInstance__Group__119087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__CompleteAssignment_11_in_rule__ConnectionInstance__Group__11__Impl9114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__12__Impl_in_rule__ConnectionInstance__Group__129145 = new BitSet(new long[]{0x0C00008040000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__13_in_rule__ConnectionInstance__Group__129148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__BidirectionalAssignment_12_in_rule__ConnectionInstance__Group__12__Impl9175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__13__Impl_in_rule__ConnectionInstance__Group__139206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ConnectionInstance__Group__13__Impl9234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_9__0__Impl_in_rule__ConnectionInstance__Group_9__09293 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_9__1_in_rule__ConnectionInstance__Group_9__09296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ConnectionInstance__Group_9__0__Impl9324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_9__1__Impl_in_rule__ConnectionInstance__Group_9__19355 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_9__2_in_rule__ConnectionInstance__Group_9__19358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__ConnectionInstance__Group_9__1__Impl9386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_9__2__Impl_in_rule__ConnectionInstance__Group_9__29417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__InSystemOperationModeAssignment_9_2_in_rule__ConnectionInstance__Group_9__2__Impl9444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_10__0__Impl_in_rule__ConnectionInstance__Group_10__09480 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_10__1_in_rule__ConnectionInstance__Group_10__09483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ConnectionInstance__Group_10__0__Impl9511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_10__1__Impl_in_rule__ConnectionInstance__Group_10__19542 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_10__2_in_rule__ConnectionInstance__Group_10__19545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__ConnectionInstance__Group_10__1__Impl9573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_10__2__Impl_in_rule__ConnectionInstance__Group_10__29604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__InModeTransitionAssignment_10_2_in_rule__ConnectionInstance__Group_10__2__Impl9631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__0__Impl_in_rule__ConnectionReference__Group__09667 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__1_in_rule__ConnectionReference__Group__09670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ConnectionReference__Group__0__Impl9698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__1__Impl_in_rule__ConnectionReference__Group__19729 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__2_in_rule__ConnectionReference__Group__19732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__ConnectionAssignment_1_in_rule__ConnectionReference__Group__1__Impl9759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__2__Impl_in_rule__ConnectionReference__Group__29789 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__3_in_rule__ConnectionReference__Group__29792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__ConnectionReference__Group__2__Impl9820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__3__Impl_in_rule__ConnectionReference__Group__39851 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__4_in_rule__ConnectionReference__Group__39854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__SourceAssignment_3_in_rule__ConnectionReference__Group__3__Impl9881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__4__Impl_in_rule__ConnectionReference__Group__49911 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__5_in_rule__ConnectionReference__Group__49914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ConnectionReference__Group__4__Impl9942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__5__Impl_in_rule__ConnectionReference__Group__59973 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__6_in_rule__ConnectionReference__Group__59976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__DestinationAssignment_5_in_rule__ConnectionReference__Group__5__Impl10003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__6__Impl_in_rule__ConnectionReference__Group__610033 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__7_in_rule__ConnectionReference__Group__610036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__ConnectionReference__Group__6__Impl10064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__7__Impl_in_rule__ConnectionReference__Group__710095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__ContextAssignment_7_in_rule__ConnectionReference__Group__7__Impl10122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__0__Impl_in_rule__ComponentCategory__Group_8__010168 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__1_in_rule__ComponentCategory__Group_8__010171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ComponentCategory__Group_8__0__Impl10199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__1__Impl_in_rule__ComponentCategory__Group_8__110230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__ComponentCategory__Group_8__1__Impl10258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__0__Impl_in_rule__ComponentCategory__Group_12__010293 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__1_in_rule__ComponentCategory__Group_12__010296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__ComponentCategory__Group_12__0__Impl10324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__1__Impl_in_rule__ComponentCategory__Group_12__110355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_rule__ComponentCategory__Group_12__1__Impl10383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group__0__Impl_in_rule__FQCREF__Group__010418 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FQCREF__Group__1_in_rule__FQCREF__Group__010421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_0__0_in_rule__FQCREF__Group__0__Impl10450 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_0__0_in_rule__FQCREF__Group__0__Impl10462 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__FQCREF__Group__1__Impl_in_rule__FQCREF__Group__110495 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_rule__FQCREF__Group__2_in_rule__FQCREF__Group__110498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQCREF__Group__1__Impl10525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group__2__Impl_in_rule__FQCREF__Group__210554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_2__0_in_rule__FQCREF__Group__2__Impl10581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_0__0__Impl_in_rule__FQCREF__Group_0__010618 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_0__1_in_rule__FQCREF__Group_0__010621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQCREF__Group_0__0__Impl10648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_0__1__Impl_in_rule__FQCREF__Group_0__110677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__FQCREF__Group_0__1__Impl10705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_2__0__Impl_in_rule__FQCREF__Group_2__010740 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_2__1_in_rule__FQCREF__Group_2__010743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_rule__FQCREF__Group_2__0__Impl10771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_2__1__Impl_in_rule__FQCREF__Group_2__110802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQCREF__Group_2__1__Impl10829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group__0__Impl_in_rule__INSTANCEREF__Group__010862 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group__1_in_rule__INSTANCEREF__Group__010865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_0__0_in_rule__INSTANCEREF__Group__0__Impl10892 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group__1__Impl_in_rule__INSTANCEREF__Group__110923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__INSTANCEREF__Group__1__Impl10950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_0__0__Impl_in_rule__INSTANCEREF__Group_0__010983 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_0__1_in_rule__INSTANCEREF__Group_0__010986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__INSTANCEREF__Group_0__0__Impl11013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_0__1__Impl_in_rule__INSTANCEREF__Group_0__111042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_rule__INSTANCEREF__Group_0__1__Impl11070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SOMID__Group__0__Impl_in_rule__SOMID__Group__011105 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SOMID__Group__1_in_rule__SOMID__Group__011108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SOMID__Group_0__0_in_rule__SOMID__Group__0__Impl11135 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__SOMID__Group__1__Impl_in_rule__SOMID__Group__111166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__SOMID__Group__1__Impl11193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SOMID__Group_0__0__Impl_in_rule__SOMID__Group_0__011226 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_rule__SOMID__Group_0__1_in_rule__SOMID__Group_0__011229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__SOMID__Group_0__0__Impl11256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SOMID__Group_0__1__Impl_in_rule__SOMID__Group_0__111285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_rule__SOMID__Group_0__1__Impl11313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SystemInstance__NameAssignment_111353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_rule__SystemInstance__CategoryAssignment_211384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQCREF_in_rule__SystemInstance__ComponentImplementationAssignment_411419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_rule__SystemInstance__FeatureInstanceAssignment_511454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_rule__SystemInstance__ComponentInstanceAssignment_611485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeInstance_in_rule__SystemInstance__ModeInstanceAssignment_711516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeTransitionInstance_in_rule__SystemInstance__ModeTransitionInstanceAssignment_811547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSpecInstance_in_rule__SystemInstance__FlowSpecificationAssignment_911578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndToEndFlowInstance_in_rule__SystemInstance__EndToEndFlowAssignment_1011609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_rule__SystemInstance__ConnectionInstanceAssignment_1111640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_rule__SystemInstance__SystemOperationModeAssignment_1211671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_rule__ComponentInstance__CategoryAssignment_011702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ComponentInstance__NameAssignment_211733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTVALUE_in_rule__ComponentInstance__IndexAssignment_3_111764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ComponentInstance__SubcomponentAssignment_511799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_rule__ComponentInstance__FeatureInstanceAssignment_611834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_rule__ComponentInstance__ComponentInstanceAssignment_711865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeInstance_in_rule__ComponentInstance__ModeInstanceAssignment_811896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeTransitionInstance_in_rule__ComponentInstance__ModeTransitionInstanceAssignment_911927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSpecInstance_in_rule__ComponentInstance__FlowSpecificationAssignment_1011958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndToEndFlowInstance_in_rule__ComponentInstance__EndToEndFlowAssignment_1111989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_rule__ComponentInstance__ConnectionInstanceAssignment_1212020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ComponentInstance__InModeAssignment_13_212055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_rule__FeatureInstance__CategoryAssignment_012090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FeatureInstance__NameAssignment_212121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTVALUE_in_rule__FeatureInstance__IndexAssignment_3_112152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FeatureInstance__FeatureAssignment_512187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_rule__FeatureInstance__DirectionAssignment_612222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_rule__FeatureInstance__FeatureInstanceAssignment_712253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ModeInstance__NameAssignment_212284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ModeInstance__ModeAssignment_412319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_rule__ModeInstance__InitialAssignment_512359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__NameAssignment_312398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__ModeTransitionAssignment_512433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__SourceAssignment_712472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__DestinationAssignment_912511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FlowSpecInstance__NameAssignment_212546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FlowSpecInstance__FlowSpecificationAssignment_412581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__FlowSpecInstance__SourceAssignment_5_112620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__FlowSpecInstance__DestinationAssignment_6_112659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__FlowSpecInstance__InModeAssignment_7_212698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FlowSpecInstance__InModeTransitionAssignment_8_212737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EndToEndFlowInstance__NameAssignment_212772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EndToEndFlowInstance__EndToEndFlowAssignment_412807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__EndToEndFlowInstance__FlowElementAssignment_512846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__EndToEndFlowInstance__InModeAssignment_6_212885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSOMID_in_rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_212924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSOMID_in_rule__SystemOperationMode__NameAssignment_112959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__SystemOperationMode__CurrentModeAssignment_212994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionKind_in_rule__ConnectionInstance__KindAssignment_013029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionReference_in_rule__ConnectionInstance__ConnectionReferenceAssignment_413060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__SourceAssignment_613095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__DestinationAssignment_813134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSOMID_in_rule__ConnectionInstance__InSystemOperationModeAssignment_9_213173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__InModeTransitionAssignment_10_213212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_rule__ConnectionInstance__CompleteAssignment_1113252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_rule__ConnectionInstance__BidirectionalAssignment_1213296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ConnectionReference__ConnectionAssignment_113339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__SourceAssignment_313378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__DestinationAssignment_513417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__ContextAssignment_713456 = new BitSet(new long[]{0x0000000000000002L});

}