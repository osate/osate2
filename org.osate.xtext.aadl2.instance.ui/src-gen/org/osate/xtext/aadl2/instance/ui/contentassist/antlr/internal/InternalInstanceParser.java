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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INTEGER_LIT", "RULE_ID", "RULE_STRING", "RULE_SL_COMMENT", "RULE_WS", "'abstract'", "'bus'", "'data'", "'device'", "'memory'", "'process'", "'processor'", "'subprogram'", "'system'", "'thread'", "'eventport'", "'dataport'", "'eventdataport'", "'parameter'", "'busaccess'", "'dataaccess'", "'subprogramaccess'", "'subprogramgroupaccess'", "'featuregroup'", "'abstractfeature'", "'in'", "'out'", "'inout'", "'feature'", "'access'", "'port'", "'modetransition'", "':'", "'{'", "'}'", "'instance'", "'of'", "'end'", "'['", "']'", "'mode'", "'transition'", "'src'", "'dst'", "'flowspec'", "'etef'", "'som'", "'connection'", "'context'", "'group'", "'virtual'", "'::'", "'.'", "'#'", "'initial'", "'complete'", "'bidirectional'"
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
    public static final int T__60=60;
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
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=7;
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
    public static final int RULE_WS=8;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:564:1: rule__ComponentCategory__Alternatives : ( ( 'abstract' ) | ( 'bus' ) | ( 'data' ) | ( 'device' ) | ( 'memory' ) | ( 'process' ) | ( 'processor' ) | ( 'subprogram' ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( 'system' ) | ( ( rule__ComponentCategory__Group_10__0 ) ) | ( 'thread' ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( ( rule__ComponentCategory__Group_13__0 ) ) );
    public final void rule__ComponentCategory__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:568:1: ( ( 'abstract' ) | ( 'bus' ) | ( 'data' ) | ( 'device' ) | ( 'memory' ) | ( 'process' ) | ( 'processor' ) | ( 'subprogram' ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( 'system' ) | ( ( rule__ComponentCategory__Group_10__0 ) ) | ( 'thread' ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( ( rule__ComponentCategory__Group_13__0 ) ) )
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
                    match(input,9,FOLLOW_9_in_rule__ComponentCategory__Alternatives1150); 
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
                    match(input,10,FOLLOW_10_in_rule__ComponentCategory__Alternatives1170); 
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
                    match(input,11,FOLLOW_11_in_rule__ComponentCategory__Alternatives1190); 
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
                    match(input,12,FOLLOW_12_in_rule__ComponentCategory__Alternatives1210); 
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
                    match(input,13,FOLLOW_13_in_rule__ComponentCategory__Alternatives1230); 
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
                    match(input,14,FOLLOW_14_in_rule__ComponentCategory__Alternatives1250); 
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
                    match(input,15,FOLLOW_15_in_rule__ComponentCategory__Alternatives1270); 
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
                    match(input,16,FOLLOW_16_in_rule__ComponentCategory__Alternatives1290); 
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
                    match(input,17,FOLLOW_17_in_rule__ComponentCategory__Alternatives1328); 
                     after(grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:647:6: ( ( rule__ComponentCategory__Group_10__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:647:6: ( ( rule__ComponentCategory__Group_10__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:648:1: ( rule__ComponentCategory__Group_10__0 )
                    {
                     before(grammarAccess.getComponentCategoryAccess().getGroup_10()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:649:1: ( rule__ComponentCategory__Group_10__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:649:2: rule__ComponentCategory__Group_10__0
                    {
                    pushFollow(FOLLOW_rule__ComponentCategory__Group_10__0_in_rule__ComponentCategory__Alternatives1347);
                    rule__ComponentCategory__Group_10__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentCategoryAccess().getGroup_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:653:6: ( 'thread' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:653:6: ( 'thread' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:654:1: 'thread'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
                    match(input,18,FOLLOW_18_in_rule__ComponentCategory__Alternatives1366); 
                     after(grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:661:6: ( ( rule__ComponentCategory__Group_12__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:661:6: ( ( rule__ComponentCategory__Group_12__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:662:1: ( rule__ComponentCategory__Group_12__0 )
                    {
                     before(grammarAccess.getComponentCategoryAccess().getGroup_12()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:663:1: ( rule__ComponentCategory__Group_12__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:663:2: rule__ComponentCategory__Group_12__0
                    {
                    pushFollow(FOLLOW_rule__ComponentCategory__Group_12__0_in_rule__ComponentCategory__Alternatives1385);
                    rule__ComponentCategory__Group_12__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentCategoryAccess().getGroup_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:667:6: ( ( rule__ComponentCategory__Group_13__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:667:6: ( ( rule__ComponentCategory__Group_13__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:668:1: ( rule__ComponentCategory__Group_13__0 )
                    {
                     before(grammarAccess.getComponentCategoryAccess().getGroup_13()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:669:1: ( rule__ComponentCategory__Group_13__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:669:2: rule__ComponentCategory__Group_13__0
                    {
                    pushFollow(FOLLOW_rule__ComponentCategory__Group_13__0_in_rule__ComponentCategory__Alternatives1403);
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


    // $ANTLR start "rule__FeatureCategory__Alternatives"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:678:1: rule__FeatureCategory__Alternatives : ( ( 'eventport' ) | ( 'dataport' ) | ( 'eventdataport' ) | ( 'parameter' ) | ( 'busaccess' ) | ( 'dataaccess' ) | ( 'subprogramaccess' ) | ( 'subprogramgroupaccess' ) | ( 'featuregroup' ) | ( 'abstractfeature' ) );
    public final void rule__FeatureCategory__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:682:1: ( ( 'eventport' ) | ( 'dataport' ) | ( 'eventdataport' ) | ( 'parameter' ) | ( 'busaccess' ) | ( 'dataaccess' ) | ( 'subprogramaccess' ) | ( 'subprogramgroupaccess' ) | ( 'featuregroup' ) | ( 'abstractfeature' ) )
            int alt2=10;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt2=1;
                }
                break;
            case 20:
                {
                alt2=2;
                }
                break;
            case 21:
                {
                alt2=3;
                }
                break;
            case 22:
                {
                alt2=4;
                }
                break;
            case 23:
                {
                alt2=5;
                }
                break;
            case 24:
                {
                alt2=6;
                }
                break;
            case 25:
                {
                alt2=7;
                }
                break;
            case 26:
                {
                alt2=8;
                }
                break;
            case 27:
                {
                alt2=9;
                }
                break;
            case 28:
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
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:683:1: ( 'eventport' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:683:1: ( 'eventport' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:684:1: 'eventport'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getEventportKeyword_0()); 
                    match(input,19,FOLLOW_19_in_rule__FeatureCategory__Alternatives1437); 
                     after(grammarAccess.getFeatureCategoryAccess().getEventportKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:691:6: ( 'dataport' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:691:6: ( 'dataport' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:692:1: 'dataport'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getDataportKeyword_1()); 
                    match(input,20,FOLLOW_20_in_rule__FeatureCategory__Alternatives1457); 
                     after(grammarAccess.getFeatureCategoryAccess().getDataportKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:699:6: ( 'eventdataport' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:699:6: ( 'eventdataport' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:700:1: 'eventdataport'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getEventdataportKeyword_2()); 
                    match(input,21,FOLLOW_21_in_rule__FeatureCategory__Alternatives1477); 
                     after(grammarAccess.getFeatureCategoryAccess().getEventdataportKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:707:6: ( 'parameter' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:707:6: ( 'parameter' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:708:1: 'parameter'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); 
                    match(input,22,FOLLOW_22_in_rule__FeatureCategory__Alternatives1497); 
                     after(grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:715:6: ( 'busaccess' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:715:6: ( 'busaccess' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:716:1: 'busaccess'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getBusaccessKeyword_4()); 
                    match(input,23,FOLLOW_23_in_rule__FeatureCategory__Alternatives1517); 
                     after(grammarAccess.getFeatureCategoryAccess().getBusaccessKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:723:6: ( 'dataaccess' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:723:6: ( 'dataaccess' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:724:1: 'dataaccess'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getDataaccessKeyword_5()); 
                    match(input,24,FOLLOW_24_in_rule__FeatureCategory__Alternatives1537); 
                     after(grammarAccess.getFeatureCategoryAccess().getDataaccessKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:731:6: ( 'subprogramaccess' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:731:6: ( 'subprogramaccess' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:732:1: 'subprogramaccess'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getSubprogramaccessKeyword_6()); 
                    match(input,25,FOLLOW_25_in_rule__FeatureCategory__Alternatives1557); 
                     after(grammarAccess.getFeatureCategoryAccess().getSubprogramaccessKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:739:6: ( 'subprogramgroupaccess' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:739:6: ( 'subprogramgroupaccess' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:740:1: 'subprogramgroupaccess'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getSubprogramgroupaccessKeyword_7()); 
                    match(input,26,FOLLOW_26_in_rule__FeatureCategory__Alternatives1577); 
                     after(grammarAccess.getFeatureCategoryAccess().getSubprogramgroupaccessKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:747:6: ( 'featuregroup' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:747:6: ( 'featuregroup' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:748:1: 'featuregroup'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getFeaturegroupKeyword_8()); 
                    match(input,27,FOLLOW_27_in_rule__FeatureCategory__Alternatives1597); 
                     after(grammarAccess.getFeatureCategoryAccess().getFeaturegroupKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:755:6: ( 'abstractfeature' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:755:6: ( 'abstractfeature' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:756:1: 'abstractfeature'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getAbstractfeatureKeyword_9()); 
                    match(input,28,FOLLOW_28_in_rule__FeatureCategory__Alternatives1617); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:768:1: rule__DirectionType__Alternatives : ( ( 'in' ) | ( 'out' ) | ( 'inout' ) );
    public final void rule__DirectionType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:772:1: ( ( 'in' ) | ( 'out' ) | ( 'inout' ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt3=1;
                }
                break;
            case 30:
                {
                alt3=2;
                }
                break;
            case 31:
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
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:773:1: ( 'in' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:773:1: ( 'in' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:774:1: 'in'
                    {
                     before(grammarAccess.getDirectionTypeAccess().getInKeyword_0()); 
                    match(input,29,FOLLOW_29_in_rule__DirectionType__Alternatives1652); 
                     after(grammarAccess.getDirectionTypeAccess().getInKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:781:6: ( 'out' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:781:6: ( 'out' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:782:1: 'out'
                    {
                     before(grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); 
                    match(input,30,FOLLOW_30_in_rule__DirectionType__Alternatives1672); 
                     after(grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:789:6: ( 'inout' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:789:6: ( 'inout' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:790:1: 'inout'
                    {
                     before(grammarAccess.getDirectionTypeAccess().getInoutKeyword_2()); 
                    match(input,31,FOLLOW_31_in_rule__DirectionType__Alternatives1692); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:802:1: rule__ConnectionKind__Alternatives : ( ( 'feature' ) | ( 'access' ) | ( 'parameter' ) | ( 'port' ) | ( 'modetransition' ) | ( 'featuregroup' ) );
    public final void rule__ConnectionKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:806:1: ( ( 'feature' ) | ( 'access' ) | ( 'parameter' ) | ( 'port' ) | ( 'modetransition' ) | ( 'featuregroup' ) )
            int alt4=6;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt4=1;
                }
                break;
            case 33:
                {
                alt4=2;
                }
                break;
            case 22:
                {
                alt4=3;
                }
                break;
            case 34:
                {
                alt4=4;
                }
                break;
            case 35:
                {
                alt4=5;
                }
                break;
            case 27:
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
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:807:1: ( 'feature' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:807:1: ( 'feature' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:808:1: 'feature'
                    {
                     before(grammarAccess.getConnectionKindAccess().getFeatureKeyword_0()); 
                    match(input,32,FOLLOW_32_in_rule__ConnectionKind__Alternatives1727); 
                     after(grammarAccess.getConnectionKindAccess().getFeatureKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:815:6: ( 'access' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:815:6: ( 'access' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:816:1: 'access'
                    {
                     before(grammarAccess.getConnectionKindAccess().getAccessKeyword_1()); 
                    match(input,33,FOLLOW_33_in_rule__ConnectionKind__Alternatives1747); 
                     after(grammarAccess.getConnectionKindAccess().getAccessKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:823:6: ( 'parameter' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:823:6: ( 'parameter' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:824:1: 'parameter'
                    {
                     before(grammarAccess.getConnectionKindAccess().getParameterKeyword_2()); 
                    match(input,22,FOLLOW_22_in_rule__ConnectionKind__Alternatives1767); 
                     after(grammarAccess.getConnectionKindAccess().getParameterKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:831:6: ( 'port' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:831:6: ( 'port' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:832:1: 'port'
                    {
                     before(grammarAccess.getConnectionKindAccess().getPortKeyword_3()); 
                    match(input,34,FOLLOW_34_in_rule__ConnectionKind__Alternatives1787); 
                     after(grammarAccess.getConnectionKindAccess().getPortKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:839:6: ( 'modetransition' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:839:6: ( 'modetransition' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:840:1: 'modetransition'
                    {
                     before(grammarAccess.getConnectionKindAccess().getModetransitionKeyword_4()); 
                    match(input,35,FOLLOW_35_in_rule__ConnectionKind__Alternatives1807); 
                     after(grammarAccess.getConnectionKindAccess().getModetransitionKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:847:6: ( 'featuregroup' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:847:6: ( 'featuregroup' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:848:1: 'featuregroup'
                    {
                     before(grammarAccess.getConnectionKindAccess().getFeaturegroupKeyword_5()); 
                    match(input,27,FOLLOW_27_in_rule__ConnectionKind__Alternatives1827); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:862:1: rule__SystemInstance__Group__0 : rule__SystemInstance__Group__0__Impl rule__SystemInstance__Group__1 ;
    public final void rule__SystemInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:866:1: ( rule__SystemInstance__Group__0__Impl rule__SystemInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:867:2: rule__SystemInstance__Group__0__Impl rule__SystemInstance__Group__1
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__0__Impl_in_rule__SystemInstance__Group__01859);
            rule__SystemInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__1_in_rule__SystemInstance__Group__01862);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:874:1: rule__SystemInstance__Group__0__Impl : ( ( rule__SystemInstance__CategoryAssignment_0 ) ) ;
    public final void rule__SystemInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:878:1: ( ( ( rule__SystemInstance__CategoryAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:879:1: ( ( rule__SystemInstance__CategoryAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:879:1: ( ( rule__SystemInstance__CategoryAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:880:1: ( rule__SystemInstance__CategoryAssignment_0 )
            {
             before(grammarAccess.getSystemInstanceAccess().getCategoryAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:881:1: ( rule__SystemInstance__CategoryAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:881:2: rule__SystemInstance__CategoryAssignment_0
            {
            pushFollow(FOLLOW_rule__SystemInstance__CategoryAssignment_0_in_rule__SystemInstance__Group__0__Impl1889);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:891:1: rule__SystemInstance__Group__1 : rule__SystemInstance__Group__1__Impl rule__SystemInstance__Group__2 ;
    public final void rule__SystemInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:895:1: ( rule__SystemInstance__Group__1__Impl rule__SystemInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:896:2: rule__SystemInstance__Group__1__Impl rule__SystemInstance__Group__2
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__1__Impl_in_rule__SystemInstance__Group__11919);
            rule__SystemInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__2_in_rule__SystemInstance__Group__11922);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:903:1: rule__SystemInstance__Group__1__Impl : ( ( rule__SystemInstance__NameAssignment_1 ) ) ;
    public final void rule__SystemInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:907:1: ( ( ( rule__SystemInstance__NameAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:908:1: ( ( rule__SystemInstance__NameAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:908:1: ( ( rule__SystemInstance__NameAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:909:1: ( rule__SystemInstance__NameAssignment_1 )
            {
             before(grammarAccess.getSystemInstanceAccess().getNameAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:910:1: ( rule__SystemInstance__NameAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:910:2: rule__SystemInstance__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SystemInstance__NameAssignment_1_in_rule__SystemInstance__Group__1__Impl1949);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:920:1: rule__SystemInstance__Group__2 : rule__SystemInstance__Group__2__Impl rule__SystemInstance__Group__3 ;
    public final void rule__SystemInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:924:1: ( rule__SystemInstance__Group__2__Impl rule__SystemInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:925:2: rule__SystemInstance__Group__2__Impl rule__SystemInstance__Group__3
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__2__Impl_in_rule__SystemInstance__Group__21979);
            rule__SystemInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__3_in_rule__SystemInstance__Group__21982);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:932:1: rule__SystemInstance__Group__2__Impl : ( ':' ) ;
    public final void rule__SystemInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:936:1: ( ( ':' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:937:1: ( ':' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:937:1: ( ':' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:938:1: ':'
            {
             before(grammarAccess.getSystemInstanceAccess().getColonKeyword_2()); 
            match(input,36,FOLLOW_36_in_rule__SystemInstance__Group__2__Impl2010); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:951:1: rule__SystemInstance__Group__3 : rule__SystemInstance__Group__3__Impl rule__SystemInstance__Group__4 ;
    public final void rule__SystemInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:955:1: ( rule__SystemInstance__Group__3__Impl rule__SystemInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:956:2: rule__SystemInstance__Group__3__Impl rule__SystemInstance__Group__4
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__3__Impl_in_rule__SystemInstance__Group__32041);
            rule__SystemInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__4_in_rule__SystemInstance__Group__32044);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:963:1: rule__SystemInstance__Group__3__Impl : ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) ) ;
    public final void rule__SystemInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:967:1: ( ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:968:1: ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:968:1: ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:969:1: ( rule__SystemInstance__ComponentImplementationAssignment_3 )
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentImplementationAssignment_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:970:1: ( rule__SystemInstance__ComponentImplementationAssignment_3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:970:2: rule__SystemInstance__ComponentImplementationAssignment_3
            {
            pushFollow(FOLLOW_rule__SystemInstance__ComponentImplementationAssignment_3_in_rule__SystemInstance__Group__3__Impl2071);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:980:1: rule__SystemInstance__Group__4 : rule__SystemInstance__Group__4__Impl rule__SystemInstance__Group__5 ;
    public final void rule__SystemInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:984:1: ( rule__SystemInstance__Group__4__Impl rule__SystemInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:985:2: rule__SystemInstance__Group__4__Impl rule__SystemInstance__Group__5
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__4__Impl_in_rule__SystemInstance__Group__42101);
            rule__SystemInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__5_in_rule__SystemInstance__Group__42104);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:992:1: rule__SystemInstance__Group__4__Impl : ( '{' ) ;
    public final void rule__SystemInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:996:1: ( ( '{' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:997:1: ( '{' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:997:1: ( '{' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:998:1: '{'
            {
             before(grammarAccess.getSystemInstanceAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,37,FOLLOW_37_in_rule__SystemInstance__Group__4__Impl2132); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1011:1: rule__SystemInstance__Group__5 : rule__SystemInstance__Group__5__Impl rule__SystemInstance__Group__6 ;
    public final void rule__SystemInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1015:1: ( rule__SystemInstance__Group__5__Impl rule__SystemInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1016:2: rule__SystemInstance__Group__5__Impl rule__SystemInstance__Group__6
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__5__Impl_in_rule__SystemInstance__Group__52163);
            rule__SystemInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__6_in_rule__SystemInstance__Group__52166);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1023:1: rule__SystemInstance__Group__5__Impl : ( ( rule__SystemInstance__SystemOperationModeAssignment_5 )* ) ;
    public final void rule__SystemInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1027:1: ( ( ( rule__SystemInstance__SystemOperationModeAssignment_5 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1028:1: ( ( rule__SystemInstance__SystemOperationModeAssignment_5 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1028:1: ( ( rule__SystemInstance__SystemOperationModeAssignment_5 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1029:1: ( rule__SystemInstance__SystemOperationModeAssignment_5 )*
            {
             before(grammarAccess.getSystemInstanceAccess().getSystemOperationModeAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1030:1: ( rule__SystemInstance__SystemOperationModeAssignment_5 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==50) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1030:2: rule__SystemInstance__SystemOperationModeAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__SystemInstance__SystemOperationModeAssignment_5_in_rule__SystemInstance__Group__5__Impl2193);
            	    rule__SystemInstance__SystemOperationModeAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getSystemInstanceAccess().getSystemOperationModeAssignment_5()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1040:1: rule__SystemInstance__Group__6 : rule__SystemInstance__Group__6__Impl ;
    public final void rule__SystemInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1044:1: ( rule__SystemInstance__Group__6__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1045:2: rule__SystemInstance__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__6__Impl_in_rule__SystemInstance__Group__62224);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1051:1: rule__SystemInstance__Group__6__Impl : ( '}' ) ;
    public final void rule__SystemInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1055:1: ( ( '}' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1056:1: ( '}' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1056:1: ( '}' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1057:1: '}'
            {
             before(grammarAccess.getSystemInstanceAccess().getRightCurlyBracketKeyword_6()); 
            match(input,38,FOLLOW_38_in_rule__SystemInstance__Group__6__Impl2252); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1084:1: rule__ComponentInstance__Group__0 : rule__ComponentInstance__Group__0__Impl rule__ComponentInstance__Group__1 ;
    public final void rule__ComponentInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1088:1: ( rule__ComponentInstance__Group__0__Impl rule__ComponentInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1089:2: rule__ComponentInstance__Group__0__Impl rule__ComponentInstance__Group__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__0__Impl_in_rule__ComponentInstance__Group__02297);
            rule__ComponentInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__1_in_rule__ComponentInstance__Group__02300);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1096:1: rule__ComponentInstance__Group__0__Impl : ( ( rule__ComponentInstance__CategoryAssignment_0 ) ) ;
    public final void rule__ComponentInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1100:1: ( ( ( rule__ComponentInstance__CategoryAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1101:1: ( ( rule__ComponentInstance__CategoryAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1101:1: ( ( rule__ComponentInstance__CategoryAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1102:1: ( rule__ComponentInstance__CategoryAssignment_0 )
            {
             before(grammarAccess.getComponentInstanceAccess().getCategoryAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1103:1: ( rule__ComponentInstance__CategoryAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1103:2: rule__ComponentInstance__CategoryAssignment_0
            {
            pushFollow(FOLLOW_rule__ComponentInstance__CategoryAssignment_0_in_rule__ComponentInstance__Group__0__Impl2327);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1113:1: rule__ComponentInstance__Group__1 : rule__ComponentInstance__Group__1__Impl rule__ComponentInstance__Group__2 ;
    public final void rule__ComponentInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1117:1: ( rule__ComponentInstance__Group__1__Impl rule__ComponentInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1118:2: rule__ComponentInstance__Group__1__Impl rule__ComponentInstance__Group__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__1__Impl_in_rule__ComponentInstance__Group__12357);
            rule__ComponentInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__2_in_rule__ComponentInstance__Group__12360);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1125:1: rule__ComponentInstance__Group__1__Impl : ( 'instance' ) ;
    public final void rule__ComponentInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1129:1: ( ( 'instance' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1130:1: ( 'instance' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1130:1: ( 'instance' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1131:1: 'instance'
            {
             before(grammarAccess.getComponentInstanceAccess().getInstanceKeyword_1()); 
            match(input,39,FOLLOW_39_in_rule__ComponentInstance__Group__1__Impl2388); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1144:1: rule__ComponentInstance__Group__2 : rule__ComponentInstance__Group__2__Impl rule__ComponentInstance__Group__3 ;
    public final void rule__ComponentInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1148:1: ( rule__ComponentInstance__Group__2__Impl rule__ComponentInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1149:2: rule__ComponentInstance__Group__2__Impl rule__ComponentInstance__Group__3
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__2__Impl_in_rule__ComponentInstance__Group__22419);
            rule__ComponentInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__3_in_rule__ComponentInstance__Group__22422);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1156:1: rule__ComponentInstance__Group__2__Impl : ( ( rule__ComponentInstance__NameAssignment_2 ) ) ;
    public final void rule__ComponentInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1160:1: ( ( ( rule__ComponentInstance__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1161:1: ( ( rule__ComponentInstance__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1161:1: ( ( rule__ComponentInstance__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1162:1: ( rule__ComponentInstance__NameAssignment_2 )
            {
             before(grammarAccess.getComponentInstanceAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1163:1: ( rule__ComponentInstance__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1163:2: rule__ComponentInstance__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__NameAssignment_2_in_rule__ComponentInstance__Group__2__Impl2449);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1173:1: rule__ComponentInstance__Group__3 : rule__ComponentInstance__Group__3__Impl rule__ComponentInstance__Group__4 ;
    public final void rule__ComponentInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1177:1: ( rule__ComponentInstance__Group__3__Impl rule__ComponentInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1178:2: rule__ComponentInstance__Group__3__Impl rule__ComponentInstance__Group__4
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__3__Impl_in_rule__ComponentInstance__Group__32479);
            rule__ComponentInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__4_in_rule__ComponentInstance__Group__32482);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1185:1: rule__ComponentInstance__Group__3__Impl : ( ( rule__ComponentInstance__Group_3__0 )? ) ;
    public final void rule__ComponentInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1189:1: ( ( ( rule__ComponentInstance__Group_3__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1190:1: ( ( rule__ComponentInstance__Group_3__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1190:1: ( ( rule__ComponentInstance__Group_3__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1191:1: ( rule__ComponentInstance__Group_3__0 )?
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1192:1: ( rule__ComponentInstance__Group_3__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==42) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1192:2: rule__ComponentInstance__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__Group_3__0_in_rule__ComponentInstance__Group__3__Impl2509);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1202:1: rule__ComponentInstance__Group__4 : rule__ComponentInstance__Group__4__Impl rule__ComponentInstance__Group__5 ;
    public final void rule__ComponentInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1206:1: ( rule__ComponentInstance__Group__4__Impl rule__ComponentInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1207:2: rule__ComponentInstance__Group__4__Impl rule__ComponentInstance__Group__5
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__4__Impl_in_rule__ComponentInstance__Group__42540);
            rule__ComponentInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__5_in_rule__ComponentInstance__Group__42543);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1214:1: rule__ComponentInstance__Group__4__Impl : ( 'of' ) ;
    public final void rule__ComponentInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1218:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1219:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1219:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1220:1: 'of'
            {
             before(grammarAccess.getComponentInstanceAccess().getOfKeyword_4()); 
            match(input,40,FOLLOW_40_in_rule__ComponentInstance__Group__4__Impl2571); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1233:1: rule__ComponentInstance__Group__5 : rule__ComponentInstance__Group__5__Impl rule__ComponentInstance__Group__6 ;
    public final void rule__ComponentInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1237:1: ( rule__ComponentInstance__Group__5__Impl rule__ComponentInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1238:2: rule__ComponentInstance__Group__5__Impl rule__ComponentInstance__Group__6
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__5__Impl_in_rule__ComponentInstance__Group__52602);
            rule__ComponentInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__6_in_rule__ComponentInstance__Group__52605);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1245:1: rule__ComponentInstance__Group__5__Impl : ( ( rule__ComponentInstance__SubcomponentAssignment_5 ) ) ;
    public final void rule__ComponentInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1249:1: ( ( ( rule__ComponentInstance__SubcomponentAssignment_5 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1250:1: ( ( rule__ComponentInstance__SubcomponentAssignment_5 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1250:1: ( ( rule__ComponentInstance__SubcomponentAssignment_5 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1251:1: ( rule__ComponentInstance__SubcomponentAssignment_5 )
            {
             before(grammarAccess.getComponentInstanceAccess().getSubcomponentAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1252:1: ( rule__ComponentInstance__SubcomponentAssignment_5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1252:2: rule__ComponentInstance__SubcomponentAssignment_5
            {
            pushFollow(FOLLOW_rule__ComponentInstance__SubcomponentAssignment_5_in_rule__ComponentInstance__Group__5__Impl2632);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1262:1: rule__ComponentInstance__Group__6 : rule__ComponentInstance__Group__6__Impl rule__ComponentInstance__Group__7 ;
    public final void rule__ComponentInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1266:1: ( rule__ComponentInstance__Group__6__Impl rule__ComponentInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1267:2: rule__ComponentInstance__Group__6__Impl rule__ComponentInstance__Group__7
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__6__Impl_in_rule__ComponentInstance__Group__62662);
            rule__ComponentInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__7_in_rule__ComponentInstance__Group__62665);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1274:1: rule__ComponentInstance__Group__6__Impl : ( ( rule__ComponentInstance__FeatureInstanceAssignment_6 )* ) ;
    public final void rule__ComponentInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1278:1: ( ( ( rule__ComponentInstance__FeatureInstanceAssignment_6 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1279:1: ( ( rule__ComponentInstance__FeatureInstanceAssignment_6 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1279:1: ( ( rule__ComponentInstance__FeatureInstanceAssignment_6 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1280:1: ( rule__ComponentInstance__FeatureInstanceAssignment_6 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getFeatureInstanceAssignment_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1281:1: ( rule__ComponentInstance__FeatureInstanceAssignment_6 )*
            loop7:
            do {
                int alt7=2;
                switch ( input.LA(1) ) {
                case 22:
                    {
                    int LA7_2 = input.LA(2);

                    if ( (LA7_2==39) ) {
                        alt7=1;
                    }


                    }
                    break;
                case 27:
                    {
                    int LA7_3 = input.LA(2);

                    if ( (LA7_3==39) ) {
                        alt7=1;
                    }


                    }
                    break;
                case 19:
                case 20:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 28:
                    {
                    alt7=1;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1281:2: rule__ComponentInstance__FeatureInstanceAssignment_6
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__FeatureInstanceAssignment_6_in_rule__ComponentInstance__Group__6__Impl2692);
            	    rule__ComponentInstance__FeatureInstanceAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1291:1: rule__ComponentInstance__Group__7 : rule__ComponentInstance__Group__7__Impl rule__ComponentInstance__Group__8 ;
    public final void rule__ComponentInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1295:1: ( rule__ComponentInstance__Group__7__Impl rule__ComponentInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1296:2: rule__ComponentInstance__Group__7__Impl rule__ComponentInstance__Group__8
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__7__Impl_in_rule__ComponentInstance__Group__72723);
            rule__ComponentInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__8_in_rule__ComponentInstance__Group__72726);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1303:1: rule__ComponentInstance__Group__7__Impl : ( ( rule__ComponentInstance__ComponentInstanceAssignment_7 )* ) ;
    public final void rule__ComponentInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1307:1: ( ( ( rule__ComponentInstance__ComponentInstanceAssignment_7 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1308:1: ( ( rule__ComponentInstance__ComponentInstanceAssignment_7 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1308:1: ( ( rule__ComponentInstance__ComponentInstanceAssignment_7 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1309:1: ( rule__ComponentInstance__ComponentInstanceAssignment_7 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getComponentInstanceAssignment_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1310:1: ( rule__ComponentInstance__ComponentInstanceAssignment_7 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=9 && LA8_0<=18)||LA8_0==54) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1310:2: rule__ComponentInstance__ComponentInstanceAssignment_7
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__ComponentInstanceAssignment_7_in_rule__ComponentInstance__Group__7__Impl2753);
            	    rule__ComponentInstance__ComponentInstanceAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1320:1: rule__ComponentInstance__Group__8 : rule__ComponentInstance__Group__8__Impl rule__ComponentInstance__Group__9 ;
    public final void rule__ComponentInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1324:1: ( rule__ComponentInstance__Group__8__Impl rule__ComponentInstance__Group__9 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1325:2: rule__ComponentInstance__Group__8__Impl rule__ComponentInstance__Group__9
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__8__Impl_in_rule__ComponentInstance__Group__82784);
            rule__ComponentInstance__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__9_in_rule__ComponentInstance__Group__82787);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1332:1: rule__ComponentInstance__Group__8__Impl : ( ( rule__ComponentInstance__ModeInstanceAssignment_8 )* ) ;
    public final void rule__ComponentInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1336:1: ( ( ( rule__ComponentInstance__ModeInstanceAssignment_8 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1337:1: ( ( rule__ComponentInstance__ModeInstanceAssignment_8 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1337:1: ( ( rule__ComponentInstance__ModeInstanceAssignment_8 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1338:1: ( rule__ComponentInstance__ModeInstanceAssignment_8 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getModeInstanceAssignment_8()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1339:1: ( rule__ComponentInstance__ModeInstanceAssignment_8 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==44) ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1==39) ) {
                        alt9=1;
                    }


                }


                switch (alt9) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1339:2: rule__ComponentInstance__ModeInstanceAssignment_8
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__ModeInstanceAssignment_8_in_rule__ComponentInstance__Group__8__Impl2814);
            	    rule__ComponentInstance__ModeInstanceAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1349:1: rule__ComponentInstance__Group__9 : rule__ComponentInstance__Group__9__Impl rule__ComponentInstance__Group__10 ;
    public final void rule__ComponentInstance__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1353:1: ( rule__ComponentInstance__Group__9__Impl rule__ComponentInstance__Group__10 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1354:2: rule__ComponentInstance__Group__9__Impl rule__ComponentInstance__Group__10
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__9__Impl_in_rule__ComponentInstance__Group__92845);
            rule__ComponentInstance__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__10_in_rule__ComponentInstance__Group__92848);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1361:1: rule__ComponentInstance__Group__9__Impl : ( ( rule__ComponentInstance__ModeTransitionInstanceAssignment_9 )* ) ;
    public final void rule__ComponentInstance__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1365:1: ( ( ( rule__ComponentInstance__ModeTransitionInstanceAssignment_9 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1366:1: ( ( rule__ComponentInstance__ModeTransitionInstanceAssignment_9 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1366:1: ( ( rule__ComponentInstance__ModeTransitionInstanceAssignment_9 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1367:1: ( rule__ComponentInstance__ModeTransitionInstanceAssignment_9 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getModeTransitionInstanceAssignment_9()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1368:1: ( rule__ComponentInstance__ModeTransitionInstanceAssignment_9 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==44) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1368:2: rule__ComponentInstance__ModeTransitionInstanceAssignment_9
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__ModeTransitionInstanceAssignment_9_in_rule__ComponentInstance__Group__9__Impl2875);
            	    rule__ComponentInstance__ModeTransitionInstanceAssignment_9();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1378:1: rule__ComponentInstance__Group__10 : rule__ComponentInstance__Group__10__Impl rule__ComponentInstance__Group__11 ;
    public final void rule__ComponentInstance__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1382:1: ( rule__ComponentInstance__Group__10__Impl rule__ComponentInstance__Group__11 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1383:2: rule__ComponentInstance__Group__10__Impl rule__ComponentInstance__Group__11
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__10__Impl_in_rule__ComponentInstance__Group__102906);
            rule__ComponentInstance__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__11_in_rule__ComponentInstance__Group__102909);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1390:1: rule__ComponentInstance__Group__10__Impl : ( ( rule__ComponentInstance__FlowSpecificationAssignment_10 )* ) ;
    public final void rule__ComponentInstance__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1394:1: ( ( ( rule__ComponentInstance__FlowSpecificationAssignment_10 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1395:1: ( ( rule__ComponentInstance__FlowSpecificationAssignment_10 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1395:1: ( ( rule__ComponentInstance__FlowSpecificationAssignment_10 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1396:1: ( rule__ComponentInstance__FlowSpecificationAssignment_10 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getFlowSpecificationAssignment_10()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1397:1: ( rule__ComponentInstance__FlowSpecificationAssignment_10 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==48) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1397:2: rule__ComponentInstance__FlowSpecificationAssignment_10
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__FlowSpecificationAssignment_10_in_rule__ComponentInstance__Group__10__Impl2936);
            	    rule__ComponentInstance__FlowSpecificationAssignment_10();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1407:1: rule__ComponentInstance__Group__11 : rule__ComponentInstance__Group__11__Impl rule__ComponentInstance__Group__12 ;
    public final void rule__ComponentInstance__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1411:1: ( rule__ComponentInstance__Group__11__Impl rule__ComponentInstance__Group__12 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1412:2: rule__ComponentInstance__Group__11__Impl rule__ComponentInstance__Group__12
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__11__Impl_in_rule__ComponentInstance__Group__112967);
            rule__ComponentInstance__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__12_in_rule__ComponentInstance__Group__112970);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1419:1: rule__ComponentInstance__Group__11__Impl : ( ( rule__ComponentInstance__EndToEndFlowAssignment_11 )* ) ;
    public final void rule__ComponentInstance__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1423:1: ( ( ( rule__ComponentInstance__EndToEndFlowAssignment_11 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1424:1: ( ( rule__ComponentInstance__EndToEndFlowAssignment_11 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1424:1: ( ( rule__ComponentInstance__EndToEndFlowAssignment_11 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1425:1: ( rule__ComponentInstance__EndToEndFlowAssignment_11 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getEndToEndFlowAssignment_11()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1426:1: ( rule__ComponentInstance__EndToEndFlowAssignment_11 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==49) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1426:2: rule__ComponentInstance__EndToEndFlowAssignment_11
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__EndToEndFlowAssignment_11_in_rule__ComponentInstance__Group__11__Impl2997);
            	    rule__ComponentInstance__EndToEndFlowAssignment_11();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1436:1: rule__ComponentInstance__Group__12 : rule__ComponentInstance__Group__12__Impl rule__ComponentInstance__Group__13 ;
    public final void rule__ComponentInstance__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1440:1: ( rule__ComponentInstance__Group__12__Impl rule__ComponentInstance__Group__13 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1441:2: rule__ComponentInstance__Group__12__Impl rule__ComponentInstance__Group__13
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__12__Impl_in_rule__ComponentInstance__Group__123028);
            rule__ComponentInstance__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__13_in_rule__ComponentInstance__Group__123031);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1448:1: rule__ComponentInstance__Group__12__Impl : ( ( rule__ComponentInstance__ConnectionInstanceAssignment_12 )* ) ;
    public final void rule__ComponentInstance__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1452:1: ( ( ( rule__ComponentInstance__ConnectionInstanceAssignment_12 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1453:1: ( ( rule__ComponentInstance__ConnectionInstanceAssignment_12 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1453:1: ( ( rule__ComponentInstance__ConnectionInstanceAssignment_12 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1454:1: ( rule__ComponentInstance__ConnectionInstanceAssignment_12 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getConnectionInstanceAssignment_12()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1455:1: ( rule__ComponentInstance__ConnectionInstanceAssignment_12 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==22||LA13_0==27||(LA13_0>=32 && LA13_0<=35)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1455:2: rule__ComponentInstance__ConnectionInstanceAssignment_12
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__ConnectionInstanceAssignment_12_in_rule__ComponentInstance__Group__12__Impl3058);
            	    rule__ComponentInstance__ConnectionInstanceAssignment_12();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1465:1: rule__ComponentInstance__Group__13 : rule__ComponentInstance__Group__13__Impl rule__ComponentInstance__Group__14 ;
    public final void rule__ComponentInstance__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1469:1: ( rule__ComponentInstance__Group__13__Impl rule__ComponentInstance__Group__14 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1470:2: rule__ComponentInstance__Group__13__Impl rule__ComponentInstance__Group__14
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__13__Impl_in_rule__ComponentInstance__Group__133089);
            rule__ComponentInstance__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__14_in_rule__ComponentInstance__Group__133092);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1477:1: rule__ComponentInstance__Group__13__Impl : ( ( rule__ComponentInstance__Group_13__0 )? ) ;
    public final void rule__ComponentInstance__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1481:1: ( ( ( rule__ComponentInstance__Group_13__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1482:1: ( ( rule__ComponentInstance__Group_13__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1482:1: ( ( rule__ComponentInstance__Group_13__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1483:1: ( rule__ComponentInstance__Group_13__0 )?
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup_13()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1484:1: ( rule__ComponentInstance__Group_13__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==29) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1484:2: rule__ComponentInstance__Group_13__0
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__Group_13__0_in_rule__ComponentInstance__Group__13__Impl3119);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1494:1: rule__ComponentInstance__Group__14 : rule__ComponentInstance__Group__14__Impl ;
    public final void rule__ComponentInstance__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1498:1: ( rule__ComponentInstance__Group__14__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1499:2: rule__ComponentInstance__Group__14__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__14__Impl_in_rule__ComponentInstance__Group__143150);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1505:1: rule__ComponentInstance__Group__14__Impl : ( 'end' ) ;
    public final void rule__ComponentInstance__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1509:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1510:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1510:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1511:1: 'end'
            {
             before(grammarAccess.getComponentInstanceAccess().getEndKeyword_14()); 
            match(input,41,FOLLOW_41_in_rule__ComponentInstance__Group__14__Impl3178); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1554:1: rule__ComponentInstance__Group_3__0 : rule__ComponentInstance__Group_3__0__Impl rule__ComponentInstance__Group_3__1 ;
    public final void rule__ComponentInstance__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1558:1: ( rule__ComponentInstance__Group_3__0__Impl rule__ComponentInstance__Group_3__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1559:2: rule__ComponentInstance__Group_3__0__Impl rule__ComponentInstance__Group_3__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_3__0__Impl_in_rule__ComponentInstance__Group_3__03239);
            rule__ComponentInstance__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_3__1_in_rule__ComponentInstance__Group_3__03242);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1566:1: rule__ComponentInstance__Group_3__0__Impl : ( '[' ) ;
    public final void rule__ComponentInstance__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1570:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1571:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1571:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1572:1: '['
            {
             before(grammarAccess.getComponentInstanceAccess().getLeftSquareBracketKeyword_3_0()); 
            match(input,42,FOLLOW_42_in_rule__ComponentInstance__Group_3__0__Impl3270); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1585:1: rule__ComponentInstance__Group_3__1 : rule__ComponentInstance__Group_3__1__Impl rule__ComponentInstance__Group_3__2 ;
    public final void rule__ComponentInstance__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1589:1: ( rule__ComponentInstance__Group_3__1__Impl rule__ComponentInstance__Group_3__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1590:2: rule__ComponentInstance__Group_3__1__Impl rule__ComponentInstance__Group_3__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_3__1__Impl_in_rule__ComponentInstance__Group_3__13301);
            rule__ComponentInstance__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_3__2_in_rule__ComponentInstance__Group_3__13304);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1597:1: rule__ComponentInstance__Group_3__1__Impl : ( ( ( rule__ComponentInstance__IndexAssignment_3_1 ) ) ( ( rule__ComponentInstance__IndexAssignment_3_1 )* ) ) ;
    public final void rule__ComponentInstance__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1601:1: ( ( ( ( rule__ComponentInstance__IndexAssignment_3_1 ) ) ( ( rule__ComponentInstance__IndexAssignment_3_1 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1602:1: ( ( ( rule__ComponentInstance__IndexAssignment_3_1 ) ) ( ( rule__ComponentInstance__IndexAssignment_3_1 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1602:1: ( ( ( rule__ComponentInstance__IndexAssignment_3_1 ) ) ( ( rule__ComponentInstance__IndexAssignment_3_1 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1603:1: ( ( rule__ComponentInstance__IndexAssignment_3_1 ) ) ( ( rule__ComponentInstance__IndexAssignment_3_1 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1603:1: ( ( rule__ComponentInstance__IndexAssignment_3_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1604:1: ( rule__ComponentInstance__IndexAssignment_3_1 )
            {
             before(grammarAccess.getComponentInstanceAccess().getIndexAssignment_3_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1605:1: ( rule__ComponentInstance__IndexAssignment_3_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1605:2: rule__ComponentInstance__IndexAssignment_3_1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__IndexAssignment_3_1_in_rule__ComponentInstance__Group_3__1__Impl3333);
            rule__ComponentInstance__IndexAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getComponentInstanceAccess().getIndexAssignment_3_1()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1608:1: ( ( rule__ComponentInstance__IndexAssignment_3_1 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1609:1: ( rule__ComponentInstance__IndexAssignment_3_1 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getIndexAssignment_3_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1610:1: ( rule__ComponentInstance__IndexAssignment_3_1 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_INTEGER_LIT) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1610:2: rule__ComponentInstance__IndexAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__IndexAssignment_3_1_in_rule__ComponentInstance__Group_3__1__Impl3345);
            	    rule__ComponentInstance__IndexAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1621:1: rule__ComponentInstance__Group_3__2 : rule__ComponentInstance__Group_3__2__Impl ;
    public final void rule__ComponentInstance__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1625:1: ( rule__ComponentInstance__Group_3__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1626:2: rule__ComponentInstance__Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_3__2__Impl_in_rule__ComponentInstance__Group_3__23378);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1632:1: rule__ComponentInstance__Group_3__2__Impl : ( ']' ) ;
    public final void rule__ComponentInstance__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1636:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1637:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1637:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1638:1: ']'
            {
             before(grammarAccess.getComponentInstanceAccess().getRightSquareBracketKeyword_3_2()); 
            match(input,43,FOLLOW_43_in_rule__ComponentInstance__Group_3__2__Impl3406); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1657:1: rule__ComponentInstance__Group_13__0 : rule__ComponentInstance__Group_13__0__Impl rule__ComponentInstance__Group_13__1 ;
    public final void rule__ComponentInstance__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1661:1: ( rule__ComponentInstance__Group_13__0__Impl rule__ComponentInstance__Group_13__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1662:2: rule__ComponentInstance__Group_13__0__Impl rule__ComponentInstance__Group_13__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_13__0__Impl_in_rule__ComponentInstance__Group_13__03443);
            rule__ComponentInstance__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_13__1_in_rule__ComponentInstance__Group_13__03446);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1669:1: rule__ComponentInstance__Group_13__0__Impl : ( 'in' ) ;
    public final void rule__ComponentInstance__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1673:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1674:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1674:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1675:1: 'in'
            {
             before(grammarAccess.getComponentInstanceAccess().getInKeyword_13_0()); 
            match(input,29,FOLLOW_29_in_rule__ComponentInstance__Group_13__0__Impl3474); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1688:1: rule__ComponentInstance__Group_13__1 : rule__ComponentInstance__Group_13__1__Impl rule__ComponentInstance__Group_13__2 ;
    public final void rule__ComponentInstance__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1692:1: ( rule__ComponentInstance__Group_13__1__Impl rule__ComponentInstance__Group_13__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1693:2: rule__ComponentInstance__Group_13__1__Impl rule__ComponentInstance__Group_13__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_13__1__Impl_in_rule__ComponentInstance__Group_13__13505);
            rule__ComponentInstance__Group_13__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_13__2_in_rule__ComponentInstance__Group_13__13508);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1700:1: rule__ComponentInstance__Group_13__1__Impl : ( 'mode' ) ;
    public final void rule__ComponentInstance__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1704:1: ( ( 'mode' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1705:1: ( 'mode' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1705:1: ( 'mode' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1706:1: 'mode'
            {
             before(grammarAccess.getComponentInstanceAccess().getModeKeyword_13_1()); 
            match(input,44,FOLLOW_44_in_rule__ComponentInstance__Group_13__1__Impl3536); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1719:1: rule__ComponentInstance__Group_13__2 : rule__ComponentInstance__Group_13__2__Impl ;
    public final void rule__ComponentInstance__Group_13__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1723:1: ( rule__ComponentInstance__Group_13__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1724:2: rule__ComponentInstance__Group_13__2__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_13__2__Impl_in_rule__ComponentInstance__Group_13__23567);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1730:1: rule__ComponentInstance__Group_13__2__Impl : ( ( rule__ComponentInstance__InModeAssignment_13_2 ) ) ;
    public final void rule__ComponentInstance__Group_13__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1734:1: ( ( ( rule__ComponentInstance__InModeAssignment_13_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1735:1: ( ( rule__ComponentInstance__InModeAssignment_13_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1735:1: ( ( rule__ComponentInstance__InModeAssignment_13_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1736:1: ( rule__ComponentInstance__InModeAssignment_13_2 )
            {
             before(grammarAccess.getComponentInstanceAccess().getInModeAssignment_13_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1737:1: ( rule__ComponentInstance__InModeAssignment_13_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1737:2: rule__ComponentInstance__InModeAssignment_13_2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__InModeAssignment_13_2_in_rule__ComponentInstance__Group_13__2__Impl3594);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1753:1: rule__FeatureInstance__Group__0 : rule__FeatureInstance__Group__0__Impl rule__FeatureInstance__Group__1 ;
    public final void rule__FeatureInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1757:1: ( rule__FeatureInstance__Group__0__Impl rule__FeatureInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1758:2: rule__FeatureInstance__Group__0__Impl rule__FeatureInstance__Group__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__0__Impl_in_rule__FeatureInstance__Group__03630);
            rule__FeatureInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__1_in_rule__FeatureInstance__Group__03633);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1765:1: rule__FeatureInstance__Group__0__Impl : ( ( rule__FeatureInstance__CategoryAssignment_0 ) ) ;
    public final void rule__FeatureInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1769:1: ( ( ( rule__FeatureInstance__CategoryAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1770:1: ( ( rule__FeatureInstance__CategoryAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1770:1: ( ( rule__FeatureInstance__CategoryAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1771:1: ( rule__FeatureInstance__CategoryAssignment_0 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getCategoryAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1772:1: ( rule__FeatureInstance__CategoryAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1772:2: rule__FeatureInstance__CategoryAssignment_0
            {
            pushFollow(FOLLOW_rule__FeatureInstance__CategoryAssignment_0_in_rule__FeatureInstance__Group__0__Impl3660);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1782:1: rule__FeatureInstance__Group__1 : rule__FeatureInstance__Group__1__Impl rule__FeatureInstance__Group__2 ;
    public final void rule__FeatureInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1786:1: ( rule__FeatureInstance__Group__1__Impl rule__FeatureInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1787:2: rule__FeatureInstance__Group__1__Impl rule__FeatureInstance__Group__2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__1__Impl_in_rule__FeatureInstance__Group__13690);
            rule__FeatureInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__2_in_rule__FeatureInstance__Group__13693);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1794:1: rule__FeatureInstance__Group__1__Impl : ( 'instance' ) ;
    public final void rule__FeatureInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1798:1: ( ( 'instance' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1799:1: ( 'instance' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1799:1: ( 'instance' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1800:1: 'instance'
            {
             before(grammarAccess.getFeatureInstanceAccess().getInstanceKeyword_1()); 
            match(input,39,FOLLOW_39_in_rule__FeatureInstance__Group__1__Impl3721); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1813:1: rule__FeatureInstance__Group__2 : rule__FeatureInstance__Group__2__Impl rule__FeatureInstance__Group__3 ;
    public final void rule__FeatureInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1817:1: ( rule__FeatureInstance__Group__2__Impl rule__FeatureInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1818:2: rule__FeatureInstance__Group__2__Impl rule__FeatureInstance__Group__3
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__2__Impl_in_rule__FeatureInstance__Group__23752);
            rule__FeatureInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__3_in_rule__FeatureInstance__Group__23755);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1825:1: rule__FeatureInstance__Group__2__Impl : ( ( rule__FeatureInstance__NameAssignment_2 ) ) ;
    public final void rule__FeatureInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1829:1: ( ( ( rule__FeatureInstance__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1830:1: ( ( rule__FeatureInstance__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1830:1: ( ( rule__FeatureInstance__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1831:1: ( rule__FeatureInstance__NameAssignment_2 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1832:1: ( rule__FeatureInstance__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1832:2: rule__FeatureInstance__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__NameAssignment_2_in_rule__FeatureInstance__Group__2__Impl3782);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1842:1: rule__FeatureInstance__Group__3 : rule__FeatureInstance__Group__3__Impl rule__FeatureInstance__Group__4 ;
    public final void rule__FeatureInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1846:1: ( rule__FeatureInstance__Group__3__Impl rule__FeatureInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1847:2: rule__FeatureInstance__Group__3__Impl rule__FeatureInstance__Group__4
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__3__Impl_in_rule__FeatureInstance__Group__33812);
            rule__FeatureInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__4_in_rule__FeatureInstance__Group__33815);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1854:1: rule__FeatureInstance__Group__3__Impl : ( ( rule__FeatureInstance__Group_3__0 )? ) ;
    public final void rule__FeatureInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1858:1: ( ( ( rule__FeatureInstance__Group_3__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1859:1: ( ( rule__FeatureInstance__Group_3__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1859:1: ( ( rule__FeatureInstance__Group_3__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1860:1: ( rule__FeatureInstance__Group_3__0 )?
            {
             before(grammarAccess.getFeatureInstanceAccess().getGroup_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1861:1: ( rule__FeatureInstance__Group_3__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==42) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1861:2: rule__FeatureInstance__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__FeatureInstance__Group_3__0_in_rule__FeatureInstance__Group__3__Impl3842);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1871:1: rule__FeatureInstance__Group__4 : rule__FeatureInstance__Group__4__Impl rule__FeatureInstance__Group__5 ;
    public final void rule__FeatureInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1875:1: ( rule__FeatureInstance__Group__4__Impl rule__FeatureInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1876:2: rule__FeatureInstance__Group__4__Impl rule__FeatureInstance__Group__5
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__4__Impl_in_rule__FeatureInstance__Group__43873);
            rule__FeatureInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__5_in_rule__FeatureInstance__Group__43876);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1883:1: rule__FeatureInstance__Group__4__Impl : ( 'of' ) ;
    public final void rule__FeatureInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1887:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1888:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1888:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1889:1: 'of'
            {
             before(grammarAccess.getFeatureInstanceAccess().getOfKeyword_4()); 
            match(input,40,FOLLOW_40_in_rule__FeatureInstance__Group__4__Impl3904); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1902:1: rule__FeatureInstance__Group__5 : rule__FeatureInstance__Group__5__Impl rule__FeatureInstance__Group__6 ;
    public final void rule__FeatureInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1906:1: ( rule__FeatureInstance__Group__5__Impl rule__FeatureInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1907:2: rule__FeatureInstance__Group__5__Impl rule__FeatureInstance__Group__6
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__5__Impl_in_rule__FeatureInstance__Group__53935);
            rule__FeatureInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__6_in_rule__FeatureInstance__Group__53938);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1914:1: rule__FeatureInstance__Group__5__Impl : ( ( rule__FeatureInstance__FeatureAssignment_5 ) ) ;
    public final void rule__FeatureInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1918:1: ( ( ( rule__FeatureInstance__FeatureAssignment_5 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1919:1: ( ( rule__FeatureInstance__FeatureAssignment_5 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1919:1: ( ( rule__FeatureInstance__FeatureAssignment_5 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1920:1: ( rule__FeatureInstance__FeatureAssignment_5 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1921:1: ( rule__FeatureInstance__FeatureAssignment_5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1921:2: rule__FeatureInstance__FeatureAssignment_5
            {
            pushFollow(FOLLOW_rule__FeatureInstance__FeatureAssignment_5_in_rule__FeatureInstance__Group__5__Impl3965);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1931:1: rule__FeatureInstance__Group__6 : rule__FeatureInstance__Group__6__Impl rule__FeatureInstance__Group__7 ;
    public final void rule__FeatureInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1935:1: ( rule__FeatureInstance__Group__6__Impl rule__FeatureInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1936:2: rule__FeatureInstance__Group__6__Impl rule__FeatureInstance__Group__7
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__6__Impl_in_rule__FeatureInstance__Group__63995);
            rule__FeatureInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__7_in_rule__FeatureInstance__Group__63998);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1943:1: rule__FeatureInstance__Group__6__Impl : ( ( rule__FeatureInstance__DirectionAssignment_6 ) ) ;
    public final void rule__FeatureInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1947:1: ( ( ( rule__FeatureInstance__DirectionAssignment_6 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1948:1: ( ( rule__FeatureInstance__DirectionAssignment_6 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1948:1: ( ( rule__FeatureInstance__DirectionAssignment_6 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1949:1: ( rule__FeatureInstance__DirectionAssignment_6 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getDirectionAssignment_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1950:1: ( rule__FeatureInstance__DirectionAssignment_6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1950:2: rule__FeatureInstance__DirectionAssignment_6
            {
            pushFollow(FOLLOW_rule__FeatureInstance__DirectionAssignment_6_in_rule__FeatureInstance__Group__6__Impl4025);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1960:1: rule__FeatureInstance__Group__7 : rule__FeatureInstance__Group__7__Impl rule__FeatureInstance__Group__8 ;
    public final void rule__FeatureInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1964:1: ( rule__FeatureInstance__Group__7__Impl rule__FeatureInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1965:2: rule__FeatureInstance__Group__7__Impl rule__FeatureInstance__Group__8
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__7__Impl_in_rule__FeatureInstance__Group__74055);
            rule__FeatureInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__8_in_rule__FeatureInstance__Group__74058);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1972:1: rule__FeatureInstance__Group__7__Impl : ( ( rule__FeatureInstance__FeatureInstanceAssignment_7 ) ) ;
    public final void rule__FeatureInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1976:1: ( ( ( rule__FeatureInstance__FeatureInstanceAssignment_7 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1977:1: ( ( rule__FeatureInstance__FeatureInstanceAssignment_7 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1977:1: ( ( rule__FeatureInstance__FeatureInstanceAssignment_7 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1978:1: ( rule__FeatureInstance__FeatureInstanceAssignment_7 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceAssignment_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1979:1: ( rule__FeatureInstance__FeatureInstanceAssignment_7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1979:2: rule__FeatureInstance__FeatureInstanceAssignment_7
            {
            pushFollow(FOLLOW_rule__FeatureInstance__FeatureInstanceAssignment_7_in_rule__FeatureInstance__Group__7__Impl4085);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1989:1: rule__FeatureInstance__Group__8 : rule__FeatureInstance__Group__8__Impl ;
    public final void rule__FeatureInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1993:1: ( rule__FeatureInstance__Group__8__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1994:2: rule__FeatureInstance__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__8__Impl_in_rule__FeatureInstance__Group__84115);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2000:1: rule__FeatureInstance__Group__8__Impl : ( 'end' ) ;
    public final void rule__FeatureInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2004:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2005:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2005:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2006:1: 'end'
            {
             before(grammarAccess.getFeatureInstanceAccess().getEndKeyword_8()); 
            match(input,41,FOLLOW_41_in_rule__FeatureInstance__Group__8__Impl4143); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2037:1: rule__FeatureInstance__Group_3__0 : rule__FeatureInstance__Group_3__0__Impl rule__FeatureInstance__Group_3__1 ;
    public final void rule__FeatureInstance__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2041:1: ( rule__FeatureInstance__Group_3__0__Impl rule__FeatureInstance__Group_3__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2042:2: rule__FeatureInstance__Group_3__0__Impl rule__FeatureInstance__Group_3__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__0__Impl_in_rule__FeatureInstance__Group_3__04192);
            rule__FeatureInstance__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__1_in_rule__FeatureInstance__Group_3__04195);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2049:1: rule__FeatureInstance__Group_3__0__Impl : ( '[' ) ;
    public final void rule__FeatureInstance__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2053:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2054:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2054:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2055:1: '['
            {
             before(grammarAccess.getFeatureInstanceAccess().getLeftSquareBracketKeyword_3_0()); 
            match(input,42,FOLLOW_42_in_rule__FeatureInstance__Group_3__0__Impl4223); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2068:1: rule__FeatureInstance__Group_3__1 : rule__FeatureInstance__Group_3__1__Impl rule__FeatureInstance__Group_3__2 ;
    public final void rule__FeatureInstance__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2072:1: ( rule__FeatureInstance__Group_3__1__Impl rule__FeatureInstance__Group_3__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2073:2: rule__FeatureInstance__Group_3__1__Impl rule__FeatureInstance__Group_3__2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__1__Impl_in_rule__FeatureInstance__Group_3__14254);
            rule__FeatureInstance__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__2_in_rule__FeatureInstance__Group_3__14257);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2080:1: rule__FeatureInstance__Group_3__1__Impl : ( ( rule__FeatureInstance__IndexAssignment_3_1 ) ) ;
    public final void rule__FeatureInstance__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2084:1: ( ( ( rule__FeatureInstance__IndexAssignment_3_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2085:1: ( ( rule__FeatureInstance__IndexAssignment_3_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2085:1: ( ( rule__FeatureInstance__IndexAssignment_3_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2086:1: ( rule__FeatureInstance__IndexAssignment_3_1 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getIndexAssignment_3_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2087:1: ( rule__FeatureInstance__IndexAssignment_3_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2087:2: rule__FeatureInstance__IndexAssignment_3_1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__IndexAssignment_3_1_in_rule__FeatureInstance__Group_3__1__Impl4284);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2097:1: rule__FeatureInstance__Group_3__2 : rule__FeatureInstance__Group_3__2__Impl ;
    public final void rule__FeatureInstance__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2101:1: ( rule__FeatureInstance__Group_3__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2102:2: rule__FeatureInstance__Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__2__Impl_in_rule__FeatureInstance__Group_3__24314);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2108:1: rule__FeatureInstance__Group_3__2__Impl : ( ']' ) ;
    public final void rule__FeatureInstance__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2112:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2113:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2113:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2114:1: ']'
            {
             before(grammarAccess.getFeatureInstanceAccess().getRightSquareBracketKeyword_3_2()); 
            match(input,43,FOLLOW_43_in_rule__FeatureInstance__Group_3__2__Impl4342); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2133:1: rule__ModeInstance__Group__0 : rule__ModeInstance__Group__0__Impl rule__ModeInstance__Group__1 ;
    public final void rule__ModeInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2137:1: ( rule__ModeInstance__Group__0__Impl rule__ModeInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2138:2: rule__ModeInstance__Group__0__Impl rule__ModeInstance__Group__1
            {
            pushFollow(FOLLOW_rule__ModeInstance__Group__0__Impl_in_rule__ModeInstance__Group__04379);
            rule__ModeInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeInstance__Group__1_in_rule__ModeInstance__Group__04382);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2145:1: rule__ModeInstance__Group__0__Impl : ( 'mode' ) ;
    public final void rule__ModeInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2149:1: ( ( 'mode' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2150:1: ( 'mode' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2150:1: ( 'mode' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2151:1: 'mode'
            {
             before(grammarAccess.getModeInstanceAccess().getModeKeyword_0()); 
            match(input,44,FOLLOW_44_in_rule__ModeInstance__Group__0__Impl4410); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2164:1: rule__ModeInstance__Group__1 : rule__ModeInstance__Group__1__Impl rule__ModeInstance__Group__2 ;
    public final void rule__ModeInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2168:1: ( rule__ModeInstance__Group__1__Impl rule__ModeInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2169:2: rule__ModeInstance__Group__1__Impl rule__ModeInstance__Group__2
            {
            pushFollow(FOLLOW_rule__ModeInstance__Group__1__Impl_in_rule__ModeInstance__Group__14441);
            rule__ModeInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeInstance__Group__2_in_rule__ModeInstance__Group__14444);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2176:1: rule__ModeInstance__Group__1__Impl : ( 'instance' ) ;
    public final void rule__ModeInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2180:1: ( ( 'instance' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2181:1: ( 'instance' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2181:1: ( 'instance' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2182:1: 'instance'
            {
             before(grammarAccess.getModeInstanceAccess().getInstanceKeyword_1()); 
            match(input,39,FOLLOW_39_in_rule__ModeInstance__Group__1__Impl4472); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2195:1: rule__ModeInstance__Group__2 : rule__ModeInstance__Group__2__Impl rule__ModeInstance__Group__3 ;
    public final void rule__ModeInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2199:1: ( rule__ModeInstance__Group__2__Impl rule__ModeInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2200:2: rule__ModeInstance__Group__2__Impl rule__ModeInstance__Group__3
            {
            pushFollow(FOLLOW_rule__ModeInstance__Group__2__Impl_in_rule__ModeInstance__Group__24503);
            rule__ModeInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeInstance__Group__3_in_rule__ModeInstance__Group__24506);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2207:1: rule__ModeInstance__Group__2__Impl : ( ( rule__ModeInstance__NameAssignment_2 ) ) ;
    public final void rule__ModeInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2211:1: ( ( ( rule__ModeInstance__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2212:1: ( ( rule__ModeInstance__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2212:1: ( ( rule__ModeInstance__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2213:1: ( rule__ModeInstance__NameAssignment_2 )
            {
             before(grammarAccess.getModeInstanceAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2214:1: ( rule__ModeInstance__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2214:2: rule__ModeInstance__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__ModeInstance__NameAssignment_2_in_rule__ModeInstance__Group__2__Impl4533);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2224:1: rule__ModeInstance__Group__3 : rule__ModeInstance__Group__3__Impl rule__ModeInstance__Group__4 ;
    public final void rule__ModeInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2228:1: ( rule__ModeInstance__Group__3__Impl rule__ModeInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2229:2: rule__ModeInstance__Group__3__Impl rule__ModeInstance__Group__4
            {
            pushFollow(FOLLOW_rule__ModeInstance__Group__3__Impl_in_rule__ModeInstance__Group__34563);
            rule__ModeInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeInstance__Group__4_in_rule__ModeInstance__Group__34566);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2236:1: rule__ModeInstance__Group__3__Impl : ( 'of' ) ;
    public final void rule__ModeInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2240:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2241:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2241:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2242:1: 'of'
            {
             before(grammarAccess.getModeInstanceAccess().getOfKeyword_3()); 
            match(input,40,FOLLOW_40_in_rule__ModeInstance__Group__3__Impl4594); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2255:1: rule__ModeInstance__Group__4 : rule__ModeInstance__Group__4__Impl rule__ModeInstance__Group__5 ;
    public final void rule__ModeInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2259:1: ( rule__ModeInstance__Group__4__Impl rule__ModeInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2260:2: rule__ModeInstance__Group__4__Impl rule__ModeInstance__Group__5
            {
            pushFollow(FOLLOW_rule__ModeInstance__Group__4__Impl_in_rule__ModeInstance__Group__44625);
            rule__ModeInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeInstance__Group__5_in_rule__ModeInstance__Group__44628);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2267:1: rule__ModeInstance__Group__4__Impl : ( ( rule__ModeInstance__ModeAssignment_4 ) ) ;
    public final void rule__ModeInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2271:1: ( ( ( rule__ModeInstance__ModeAssignment_4 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2272:1: ( ( rule__ModeInstance__ModeAssignment_4 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2272:1: ( ( rule__ModeInstance__ModeAssignment_4 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2273:1: ( rule__ModeInstance__ModeAssignment_4 )
            {
             before(grammarAccess.getModeInstanceAccess().getModeAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2274:1: ( rule__ModeInstance__ModeAssignment_4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2274:2: rule__ModeInstance__ModeAssignment_4
            {
            pushFollow(FOLLOW_rule__ModeInstance__ModeAssignment_4_in_rule__ModeInstance__Group__4__Impl4655);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2284:1: rule__ModeInstance__Group__5 : rule__ModeInstance__Group__5__Impl rule__ModeInstance__Group__6 ;
    public final void rule__ModeInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2288:1: ( rule__ModeInstance__Group__5__Impl rule__ModeInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2289:2: rule__ModeInstance__Group__5__Impl rule__ModeInstance__Group__6
            {
            pushFollow(FOLLOW_rule__ModeInstance__Group__5__Impl_in_rule__ModeInstance__Group__54685);
            rule__ModeInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeInstance__Group__6_in_rule__ModeInstance__Group__54688);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2296:1: rule__ModeInstance__Group__5__Impl : ( ( rule__ModeInstance__InitialAssignment_5 )? ) ;
    public final void rule__ModeInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2300:1: ( ( ( rule__ModeInstance__InitialAssignment_5 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2301:1: ( ( rule__ModeInstance__InitialAssignment_5 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2301:1: ( ( rule__ModeInstance__InitialAssignment_5 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2302:1: ( rule__ModeInstance__InitialAssignment_5 )?
            {
             before(grammarAccess.getModeInstanceAccess().getInitialAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2303:1: ( rule__ModeInstance__InitialAssignment_5 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==58) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2303:2: rule__ModeInstance__InitialAssignment_5
                    {
                    pushFollow(FOLLOW_rule__ModeInstance__InitialAssignment_5_in_rule__ModeInstance__Group__5__Impl4715);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2313:1: rule__ModeInstance__Group__6 : rule__ModeInstance__Group__6__Impl ;
    public final void rule__ModeInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2317:1: ( rule__ModeInstance__Group__6__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2318:2: rule__ModeInstance__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ModeInstance__Group__6__Impl_in_rule__ModeInstance__Group__64746);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2324:1: rule__ModeInstance__Group__6__Impl : ( 'end' ) ;
    public final void rule__ModeInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2328:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2329:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2329:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2330:1: 'end'
            {
             before(grammarAccess.getModeInstanceAccess().getEndKeyword_6()); 
            match(input,41,FOLLOW_41_in_rule__ModeInstance__Group__6__Impl4774); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2357:1: rule__ModeTransitionInstance__Group__0 : rule__ModeTransitionInstance__Group__0__Impl rule__ModeTransitionInstance__Group__1 ;
    public final void rule__ModeTransitionInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2361:1: ( rule__ModeTransitionInstance__Group__0__Impl rule__ModeTransitionInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2362:2: rule__ModeTransitionInstance__Group__0__Impl rule__ModeTransitionInstance__Group__1
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__0__Impl_in_rule__ModeTransitionInstance__Group__04819);
            rule__ModeTransitionInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__1_in_rule__ModeTransitionInstance__Group__04822);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2369:1: rule__ModeTransitionInstance__Group__0__Impl : ( 'mode' ) ;
    public final void rule__ModeTransitionInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2373:1: ( ( 'mode' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2374:1: ( 'mode' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2374:1: ( 'mode' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2375:1: 'mode'
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getModeKeyword_0()); 
            match(input,44,FOLLOW_44_in_rule__ModeTransitionInstance__Group__0__Impl4850); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2388:1: rule__ModeTransitionInstance__Group__1 : rule__ModeTransitionInstance__Group__1__Impl rule__ModeTransitionInstance__Group__2 ;
    public final void rule__ModeTransitionInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2392:1: ( rule__ModeTransitionInstance__Group__1__Impl rule__ModeTransitionInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2393:2: rule__ModeTransitionInstance__Group__1__Impl rule__ModeTransitionInstance__Group__2
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__1__Impl_in_rule__ModeTransitionInstance__Group__14881);
            rule__ModeTransitionInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__2_in_rule__ModeTransitionInstance__Group__14884);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2400:1: rule__ModeTransitionInstance__Group__1__Impl : ( 'transition' ) ;
    public final void rule__ModeTransitionInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2404:1: ( ( 'transition' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2405:1: ( 'transition' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2405:1: ( 'transition' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2406:1: 'transition'
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getTransitionKeyword_1()); 
            match(input,45,FOLLOW_45_in_rule__ModeTransitionInstance__Group__1__Impl4912); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2419:1: rule__ModeTransitionInstance__Group__2 : rule__ModeTransitionInstance__Group__2__Impl rule__ModeTransitionInstance__Group__3 ;
    public final void rule__ModeTransitionInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2423:1: ( rule__ModeTransitionInstance__Group__2__Impl rule__ModeTransitionInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2424:2: rule__ModeTransitionInstance__Group__2__Impl rule__ModeTransitionInstance__Group__3
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__2__Impl_in_rule__ModeTransitionInstance__Group__24943);
            rule__ModeTransitionInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__3_in_rule__ModeTransitionInstance__Group__24946);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2431:1: rule__ModeTransitionInstance__Group__2__Impl : ( 'instance' ) ;
    public final void rule__ModeTransitionInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2435:1: ( ( 'instance' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2436:1: ( 'instance' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2436:1: ( 'instance' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2437:1: 'instance'
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getInstanceKeyword_2()); 
            match(input,39,FOLLOW_39_in_rule__ModeTransitionInstance__Group__2__Impl4974); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2450:1: rule__ModeTransitionInstance__Group__3 : rule__ModeTransitionInstance__Group__3__Impl rule__ModeTransitionInstance__Group__4 ;
    public final void rule__ModeTransitionInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2454:1: ( rule__ModeTransitionInstance__Group__3__Impl rule__ModeTransitionInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2455:2: rule__ModeTransitionInstance__Group__3__Impl rule__ModeTransitionInstance__Group__4
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__3__Impl_in_rule__ModeTransitionInstance__Group__35005);
            rule__ModeTransitionInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__4_in_rule__ModeTransitionInstance__Group__35008);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2462:1: rule__ModeTransitionInstance__Group__3__Impl : ( ( rule__ModeTransitionInstance__NameAssignment_3 ) ) ;
    public final void rule__ModeTransitionInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2466:1: ( ( ( rule__ModeTransitionInstance__NameAssignment_3 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2467:1: ( ( rule__ModeTransitionInstance__NameAssignment_3 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2467:1: ( ( rule__ModeTransitionInstance__NameAssignment_3 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2468:1: ( rule__ModeTransitionInstance__NameAssignment_3 )
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getNameAssignment_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2469:1: ( rule__ModeTransitionInstance__NameAssignment_3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2469:2: rule__ModeTransitionInstance__NameAssignment_3
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__NameAssignment_3_in_rule__ModeTransitionInstance__Group__3__Impl5035);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2479:1: rule__ModeTransitionInstance__Group__4 : rule__ModeTransitionInstance__Group__4__Impl rule__ModeTransitionInstance__Group__5 ;
    public final void rule__ModeTransitionInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2483:1: ( rule__ModeTransitionInstance__Group__4__Impl rule__ModeTransitionInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2484:2: rule__ModeTransitionInstance__Group__4__Impl rule__ModeTransitionInstance__Group__5
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__4__Impl_in_rule__ModeTransitionInstance__Group__45065);
            rule__ModeTransitionInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__5_in_rule__ModeTransitionInstance__Group__45068);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2491:1: rule__ModeTransitionInstance__Group__4__Impl : ( 'of' ) ;
    public final void rule__ModeTransitionInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2495:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2496:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2496:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2497:1: 'of'
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getOfKeyword_4()); 
            match(input,40,FOLLOW_40_in_rule__ModeTransitionInstance__Group__4__Impl5096); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2510:1: rule__ModeTransitionInstance__Group__5 : rule__ModeTransitionInstance__Group__5__Impl rule__ModeTransitionInstance__Group__6 ;
    public final void rule__ModeTransitionInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2514:1: ( rule__ModeTransitionInstance__Group__5__Impl rule__ModeTransitionInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2515:2: rule__ModeTransitionInstance__Group__5__Impl rule__ModeTransitionInstance__Group__6
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__5__Impl_in_rule__ModeTransitionInstance__Group__55127);
            rule__ModeTransitionInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__6_in_rule__ModeTransitionInstance__Group__55130);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2522:1: rule__ModeTransitionInstance__Group__5__Impl : ( ( rule__ModeTransitionInstance__ModeTransitionAssignment_5 ) ) ;
    public final void rule__ModeTransitionInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2526:1: ( ( ( rule__ModeTransitionInstance__ModeTransitionAssignment_5 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2527:1: ( ( rule__ModeTransitionInstance__ModeTransitionAssignment_5 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2527:1: ( ( rule__ModeTransitionInstance__ModeTransitionAssignment_5 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2528:1: ( rule__ModeTransitionInstance__ModeTransitionAssignment_5 )
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2529:1: ( rule__ModeTransitionInstance__ModeTransitionAssignment_5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2529:2: rule__ModeTransitionInstance__ModeTransitionAssignment_5
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__ModeTransitionAssignment_5_in_rule__ModeTransitionInstance__Group__5__Impl5157);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2539:1: rule__ModeTransitionInstance__Group__6 : rule__ModeTransitionInstance__Group__6__Impl rule__ModeTransitionInstance__Group__7 ;
    public final void rule__ModeTransitionInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2543:1: ( rule__ModeTransitionInstance__Group__6__Impl rule__ModeTransitionInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2544:2: rule__ModeTransitionInstance__Group__6__Impl rule__ModeTransitionInstance__Group__7
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__6__Impl_in_rule__ModeTransitionInstance__Group__65187);
            rule__ModeTransitionInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__7_in_rule__ModeTransitionInstance__Group__65190);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2551:1: rule__ModeTransitionInstance__Group__6__Impl : ( 'src' ) ;
    public final void rule__ModeTransitionInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2555:1: ( ( 'src' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2556:1: ( 'src' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2556:1: ( 'src' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2557:1: 'src'
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getSrcKeyword_6()); 
            match(input,46,FOLLOW_46_in_rule__ModeTransitionInstance__Group__6__Impl5218); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2570:1: rule__ModeTransitionInstance__Group__7 : rule__ModeTransitionInstance__Group__7__Impl rule__ModeTransitionInstance__Group__8 ;
    public final void rule__ModeTransitionInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2574:1: ( rule__ModeTransitionInstance__Group__7__Impl rule__ModeTransitionInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2575:2: rule__ModeTransitionInstance__Group__7__Impl rule__ModeTransitionInstance__Group__8
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__7__Impl_in_rule__ModeTransitionInstance__Group__75249);
            rule__ModeTransitionInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__8_in_rule__ModeTransitionInstance__Group__75252);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2582:1: rule__ModeTransitionInstance__Group__7__Impl : ( ( rule__ModeTransitionInstance__SourceAssignment_7 ) ) ;
    public final void rule__ModeTransitionInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2586:1: ( ( ( rule__ModeTransitionInstance__SourceAssignment_7 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2587:1: ( ( rule__ModeTransitionInstance__SourceAssignment_7 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2587:1: ( ( rule__ModeTransitionInstance__SourceAssignment_7 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2588:1: ( rule__ModeTransitionInstance__SourceAssignment_7 )
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getSourceAssignment_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2589:1: ( rule__ModeTransitionInstance__SourceAssignment_7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2589:2: rule__ModeTransitionInstance__SourceAssignment_7
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__SourceAssignment_7_in_rule__ModeTransitionInstance__Group__7__Impl5279);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2599:1: rule__ModeTransitionInstance__Group__8 : rule__ModeTransitionInstance__Group__8__Impl rule__ModeTransitionInstance__Group__9 ;
    public final void rule__ModeTransitionInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2603:1: ( rule__ModeTransitionInstance__Group__8__Impl rule__ModeTransitionInstance__Group__9 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2604:2: rule__ModeTransitionInstance__Group__8__Impl rule__ModeTransitionInstance__Group__9
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__8__Impl_in_rule__ModeTransitionInstance__Group__85309);
            rule__ModeTransitionInstance__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__9_in_rule__ModeTransitionInstance__Group__85312);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2611:1: rule__ModeTransitionInstance__Group__8__Impl : ( 'dst' ) ;
    public final void rule__ModeTransitionInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2615:1: ( ( 'dst' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2616:1: ( 'dst' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2616:1: ( 'dst' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2617:1: 'dst'
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getDstKeyword_8()); 
            match(input,47,FOLLOW_47_in_rule__ModeTransitionInstance__Group__8__Impl5340); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2630:1: rule__ModeTransitionInstance__Group__9 : rule__ModeTransitionInstance__Group__9__Impl rule__ModeTransitionInstance__Group__10 ;
    public final void rule__ModeTransitionInstance__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2634:1: ( rule__ModeTransitionInstance__Group__9__Impl rule__ModeTransitionInstance__Group__10 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2635:2: rule__ModeTransitionInstance__Group__9__Impl rule__ModeTransitionInstance__Group__10
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__9__Impl_in_rule__ModeTransitionInstance__Group__95371);
            rule__ModeTransitionInstance__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__10_in_rule__ModeTransitionInstance__Group__95374);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2642:1: rule__ModeTransitionInstance__Group__9__Impl : ( ( rule__ModeTransitionInstance__DestinationAssignment_9 ) ) ;
    public final void rule__ModeTransitionInstance__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2646:1: ( ( ( rule__ModeTransitionInstance__DestinationAssignment_9 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2647:1: ( ( rule__ModeTransitionInstance__DestinationAssignment_9 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2647:1: ( ( rule__ModeTransitionInstance__DestinationAssignment_9 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2648:1: ( rule__ModeTransitionInstance__DestinationAssignment_9 )
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getDestinationAssignment_9()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2649:1: ( rule__ModeTransitionInstance__DestinationAssignment_9 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2649:2: rule__ModeTransitionInstance__DestinationAssignment_9
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__DestinationAssignment_9_in_rule__ModeTransitionInstance__Group__9__Impl5401);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2659:1: rule__ModeTransitionInstance__Group__10 : rule__ModeTransitionInstance__Group__10__Impl ;
    public final void rule__ModeTransitionInstance__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2663:1: ( rule__ModeTransitionInstance__Group__10__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2664:2: rule__ModeTransitionInstance__Group__10__Impl
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__10__Impl_in_rule__ModeTransitionInstance__Group__105431);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2670:1: rule__ModeTransitionInstance__Group__10__Impl : ( 'end' ) ;
    public final void rule__ModeTransitionInstance__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2674:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2675:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2675:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2676:1: 'end'
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getEndKeyword_10()); 
            match(input,41,FOLLOW_41_in_rule__ModeTransitionInstance__Group__10__Impl5459); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2711:1: rule__FlowSpecInstance__Group__0 : rule__FlowSpecInstance__Group__0__Impl rule__FlowSpecInstance__Group__1 ;
    public final void rule__FlowSpecInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2715:1: ( rule__FlowSpecInstance__Group__0__Impl rule__FlowSpecInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2716:2: rule__FlowSpecInstance__Group__0__Impl rule__FlowSpecInstance__Group__1
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__0__Impl_in_rule__FlowSpecInstance__Group__05512);
            rule__FlowSpecInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__1_in_rule__FlowSpecInstance__Group__05515);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2723:1: rule__FlowSpecInstance__Group__0__Impl : ( 'flowspec' ) ;
    public final void rule__FlowSpecInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2727:1: ( ( 'flowspec' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2728:1: ( 'flowspec' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2728:1: ( 'flowspec' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2729:1: 'flowspec'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getFlowspecKeyword_0()); 
            match(input,48,FOLLOW_48_in_rule__FlowSpecInstance__Group__0__Impl5543); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2742:1: rule__FlowSpecInstance__Group__1 : rule__FlowSpecInstance__Group__1__Impl rule__FlowSpecInstance__Group__2 ;
    public final void rule__FlowSpecInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2746:1: ( rule__FlowSpecInstance__Group__1__Impl rule__FlowSpecInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2747:2: rule__FlowSpecInstance__Group__1__Impl rule__FlowSpecInstance__Group__2
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__1__Impl_in_rule__FlowSpecInstance__Group__15574);
            rule__FlowSpecInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__2_in_rule__FlowSpecInstance__Group__15577);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2754:1: rule__FlowSpecInstance__Group__1__Impl : ( 'instance' ) ;
    public final void rule__FlowSpecInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2758:1: ( ( 'instance' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2759:1: ( 'instance' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2759:1: ( 'instance' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2760:1: 'instance'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInstanceKeyword_1()); 
            match(input,39,FOLLOW_39_in_rule__FlowSpecInstance__Group__1__Impl5605); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2773:1: rule__FlowSpecInstance__Group__2 : rule__FlowSpecInstance__Group__2__Impl rule__FlowSpecInstance__Group__3 ;
    public final void rule__FlowSpecInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2777:1: ( rule__FlowSpecInstance__Group__2__Impl rule__FlowSpecInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2778:2: rule__FlowSpecInstance__Group__2__Impl rule__FlowSpecInstance__Group__3
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__2__Impl_in_rule__FlowSpecInstance__Group__25636);
            rule__FlowSpecInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__3_in_rule__FlowSpecInstance__Group__25639);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2785:1: rule__FlowSpecInstance__Group__2__Impl : ( ( rule__FlowSpecInstance__NameAssignment_2 ) ) ;
    public final void rule__FlowSpecInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2789:1: ( ( ( rule__FlowSpecInstance__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2790:1: ( ( rule__FlowSpecInstance__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2790:1: ( ( rule__FlowSpecInstance__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2791:1: ( rule__FlowSpecInstance__NameAssignment_2 )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2792:1: ( rule__FlowSpecInstance__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2792:2: rule__FlowSpecInstance__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__NameAssignment_2_in_rule__FlowSpecInstance__Group__2__Impl5666);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2802:1: rule__FlowSpecInstance__Group__3 : rule__FlowSpecInstance__Group__3__Impl rule__FlowSpecInstance__Group__4 ;
    public final void rule__FlowSpecInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2806:1: ( rule__FlowSpecInstance__Group__3__Impl rule__FlowSpecInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2807:2: rule__FlowSpecInstance__Group__3__Impl rule__FlowSpecInstance__Group__4
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__3__Impl_in_rule__FlowSpecInstance__Group__35696);
            rule__FlowSpecInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__4_in_rule__FlowSpecInstance__Group__35699);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2814:1: rule__FlowSpecInstance__Group__3__Impl : ( 'of' ) ;
    public final void rule__FlowSpecInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2818:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2819:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2819:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2820:1: 'of'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getOfKeyword_3()); 
            match(input,40,FOLLOW_40_in_rule__FlowSpecInstance__Group__3__Impl5727); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2833:1: rule__FlowSpecInstance__Group__4 : rule__FlowSpecInstance__Group__4__Impl rule__FlowSpecInstance__Group__5 ;
    public final void rule__FlowSpecInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2837:1: ( rule__FlowSpecInstance__Group__4__Impl rule__FlowSpecInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2838:2: rule__FlowSpecInstance__Group__4__Impl rule__FlowSpecInstance__Group__5
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__4__Impl_in_rule__FlowSpecInstance__Group__45758);
            rule__FlowSpecInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__5_in_rule__FlowSpecInstance__Group__45761);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2845:1: rule__FlowSpecInstance__Group__4__Impl : ( ( rule__FlowSpecInstance__FlowSpecificationAssignment_4 ) ) ;
    public final void rule__FlowSpecInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2849:1: ( ( ( rule__FlowSpecInstance__FlowSpecificationAssignment_4 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2850:1: ( ( rule__FlowSpecInstance__FlowSpecificationAssignment_4 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2850:1: ( ( rule__FlowSpecInstance__FlowSpecificationAssignment_4 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2851:1: ( rule__FlowSpecInstance__FlowSpecificationAssignment_4 )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getFlowSpecificationAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2852:1: ( rule__FlowSpecInstance__FlowSpecificationAssignment_4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2852:2: rule__FlowSpecInstance__FlowSpecificationAssignment_4
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__FlowSpecificationAssignment_4_in_rule__FlowSpecInstance__Group__4__Impl5788);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2862:1: rule__FlowSpecInstance__Group__5 : rule__FlowSpecInstance__Group__5__Impl rule__FlowSpecInstance__Group__6 ;
    public final void rule__FlowSpecInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2866:1: ( rule__FlowSpecInstance__Group__5__Impl rule__FlowSpecInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2867:2: rule__FlowSpecInstance__Group__5__Impl rule__FlowSpecInstance__Group__6
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__5__Impl_in_rule__FlowSpecInstance__Group__55818);
            rule__FlowSpecInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__6_in_rule__FlowSpecInstance__Group__55821);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2874:1: rule__FlowSpecInstance__Group__5__Impl : ( ( rule__FlowSpecInstance__Group_5__0 )? ) ;
    public final void rule__FlowSpecInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2878:1: ( ( ( rule__FlowSpecInstance__Group_5__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2879:1: ( ( rule__FlowSpecInstance__Group_5__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2879:1: ( ( rule__FlowSpecInstance__Group_5__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2880:1: ( rule__FlowSpecInstance__Group_5__0 )?
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getGroup_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2881:1: ( rule__FlowSpecInstance__Group_5__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==46) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2881:2: rule__FlowSpecInstance__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__FlowSpecInstance__Group_5__0_in_rule__FlowSpecInstance__Group__5__Impl5848);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2891:1: rule__FlowSpecInstance__Group__6 : rule__FlowSpecInstance__Group__6__Impl rule__FlowSpecInstance__Group__7 ;
    public final void rule__FlowSpecInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2895:1: ( rule__FlowSpecInstance__Group__6__Impl rule__FlowSpecInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2896:2: rule__FlowSpecInstance__Group__6__Impl rule__FlowSpecInstance__Group__7
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__6__Impl_in_rule__FlowSpecInstance__Group__65879);
            rule__FlowSpecInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__7_in_rule__FlowSpecInstance__Group__65882);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2903:1: rule__FlowSpecInstance__Group__6__Impl : ( ( rule__FlowSpecInstance__Group_6__0 )? ) ;
    public final void rule__FlowSpecInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2907:1: ( ( ( rule__FlowSpecInstance__Group_6__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2908:1: ( ( rule__FlowSpecInstance__Group_6__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2908:1: ( ( rule__FlowSpecInstance__Group_6__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2909:1: ( rule__FlowSpecInstance__Group_6__0 )?
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getGroup_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2910:1: ( rule__FlowSpecInstance__Group_6__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==47) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2910:2: rule__FlowSpecInstance__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__FlowSpecInstance__Group_6__0_in_rule__FlowSpecInstance__Group__6__Impl5909);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2920:1: rule__FlowSpecInstance__Group__7 : rule__FlowSpecInstance__Group__7__Impl rule__FlowSpecInstance__Group__8 ;
    public final void rule__FlowSpecInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2924:1: ( rule__FlowSpecInstance__Group__7__Impl rule__FlowSpecInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2925:2: rule__FlowSpecInstance__Group__7__Impl rule__FlowSpecInstance__Group__8
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__7__Impl_in_rule__FlowSpecInstance__Group__75940);
            rule__FlowSpecInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__8_in_rule__FlowSpecInstance__Group__75943);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2932:1: rule__FlowSpecInstance__Group__7__Impl : ( ( rule__FlowSpecInstance__Group_7__0 )? ) ;
    public final void rule__FlowSpecInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2936:1: ( ( ( rule__FlowSpecInstance__Group_7__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2937:1: ( ( rule__FlowSpecInstance__Group_7__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2937:1: ( ( rule__FlowSpecInstance__Group_7__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2938:1: ( rule__FlowSpecInstance__Group_7__0 )?
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getGroup_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2939:1: ( rule__FlowSpecInstance__Group_7__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==29) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==44) ) {
                    alt20=1;
                }
            }
            switch (alt20) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2939:2: rule__FlowSpecInstance__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__FlowSpecInstance__Group_7__0_in_rule__FlowSpecInstance__Group__7__Impl5970);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2949:1: rule__FlowSpecInstance__Group__8 : rule__FlowSpecInstance__Group__8__Impl rule__FlowSpecInstance__Group__9 ;
    public final void rule__FlowSpecInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2953:1: ( rule__FlowSpecInstance__Group__8__Impl rule__FlowSpecInstance__Group__9 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2954:2: rule__FlowSpecInstance__Group__8__Impl rule__FlowSpecInstance__Group__9
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__8__Impl_in_rule__FlowSpecInstance__Group__86001);
            rule__FlowSpecInstance__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__9_in_rule__FlowSpecInstance__Group__86004);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2961:1: rule__FlowSpecInstance__Group__8__Impl : ( ( rule__FlowSpecInstance__Group_8__0 )? ) ;
    public final void rule__FlowSpecInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2965:1: ( ( ( rule__FlowSpecInstance__Group_8__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2966:1: ( ( rule__FlowSpecInstance__Group_8__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2966:1: ( ( rule__FlowSpecInstance__Group_8__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2967:1: ( rule__FlowSpecInstance__Group_8__0 )?
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getGroup_8()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2968:1: ( rule__FlowSpecInstance__Group_8__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==29) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2968:2: rule__FlowSpecInstance__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__FlowSpecInstance__Group_8__0_in_rule__FlowSpecInstance__Group__8__Impl6031);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2978:1: rule__FlowSpecInstance__Group__9 : rule__FlowSpecInstance__Group__9__Impl ;
    public final void rule__FlowSpecInstance__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2982:1: ( rule__FlowSpecInstance__Group__9__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2983:2: rule__FlowSpecInstance__Group__9__Impl
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__9__Impl_in_rule__FlowSpecInstance__Group__96062);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2989:1: rule__FlowSpecInstance__Group__9__Impl : ( 'end' ) ;
    public final void rule__FlowSpecInstance__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2993:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2994:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2994:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2995:1: 'end'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getEndKeyword_9()); 
            match(input,41,FOLLOW_41_in_rule__FlowSpecInstance__Group__9__Impl6090); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3028:1: rule__FlowSpecInstance__Group_5__0 : rule__FlowSpecInstance__Group_5__0__Impl rule__FlowSpecInstance__Group_5__1 ;
    public final void rule__FlowSpecInstance__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3032:1: ( rule__FlowSpecInstance__Group_5__0__Impl rule__FlowSpecInstance__Group_5__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3033:2: rule__FlowSpecInstance__Group_5__0__Impl rule__FlowSpecInstance__Group_5__1
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_5__0__Impl_in_rule__FlowSpecInstance__Group_5__06141);
            rule__FlowSpecInstance__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_5__1_in_rule__FlowSpecInstance__Group_5__06144);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3040:1: rule__FlowSpecInstance__Group_5__0__Impl : ( 'src' ) ;
    public final void rule__FlowSpecInstance__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3044:1: ( ( 'src' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3045:1: ( 'src' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3045:1: ( 'src' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3046:1: 'src'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getSrcKeyword_5_0()); 
            match(input,46,FOLLOW_46_in_rule__FlowSpecInstance__Group_5__0__Impl6172); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3059:1: rule__FlowSpecInstance__Group_5__1 : rule__FlowSpecInstance__Group_5__1__Impl ;
    public final void rule__FlowSpecInstance__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3063:1: ( rule__FlowSpecInstance__Group_5__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3064:2: rule__FlowSpecInstance__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_5__1__Impl_in_rule__FlowSpecInstance__Group_5__16203);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3070:1: rule__FlowSpecInstance__Group_5__1__Impl : ( ( rule__FlowSpecInstance__SourceAssignment_5_1 ) ) ;
    public final void rule__FlowSpecInstance__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3074:1: ( ( ( rule__FlowSpecInstance__SourceAssignment_5_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3075:1: ( ( rule__FlowSpecInstance__SourceAssignment_5_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3075:1: ( ( rule__FlowSpecInstance__SourceAssignment_5_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3076:1: ( rule__FlowSpecInstance__SourceAssignment_5_1 )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getSourceAssignment_5_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3077:1: ( rule__FlowSpecInstance__SourceAssignment_5_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3077:2: rule__FlowSpecInstance__SourceAssignment_5_1
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__SourceAssignment_5_1_in_rule__FlowSpecInstance__Group_5__1__Impl6230);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3091:1: rule__FlowSpecInstance__Group_6__0 : rule__FlowSpecInstance__Group_6__0__Impl rule__FlowSpecInstance__Group_6__1 ;
    public final void rule__FlowSpecInstance__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3095:1: ( rule__FlowSpecInstance__Group_6__0__Impl rule__FlowSpecInstance__Group_6__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3096:2: rule__FlowSpecInstance__Group_6__0__Impl rule__FlowSpecInstance__Group_6__1
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_6__0__Impl_in_rule__FlowSpecInstance__Group_6__06264);
            rule__FlowSpecInstance__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_6__1_in_rule__FlowSpecInstance__Group_6__06267);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3103:1: rule__FlowSpecInstance__Group_6__0__Impl : ( 'dst' ) ;
    public final void rule__FlowSpecInstance__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3107:1: ( ( 'dst' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3108:1: ( 'dst' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3108:1: ( 'dst' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3109:1: 'dst'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getDstKeyword_6_0()); 
            match(input,47,FOLLOW_47_in_rule__FlowSpecInstance__Group_6__0__Impl6295); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3122:1: rule__FlowSpecInstance__Group_6__1 : rule__FlowSpecInstance__Group_6__1__Impl ;
    public final void rule__FlowSpecInstance__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3126:1: ( rule__FlowSpecInstance__Group_6__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3127:2: rule__FlowSpecInstance__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_6__1__Impl_in_rule__FlowSpecInstance__Group_6__16326);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3133:1: rule__FlowSpecInstance__Group_6__1__Impl : ( ( rule__FlowSpecInstance__DestinationAssignment_6_1 ) ) ;
    public final void rule__FlowSpecInstance__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3137:1: ( ( ( rule__FlowSpecInstance__DestinationAssignment_6_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3138:1: ( ( rule__FlowSpecInstance__DestinationAssignment_6_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3138:1: ( ( rule__FlowSpecInstance__DestinationAssignment_6_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3139:1: ( rule__FlowSpecInstance__DestinationAssignment_6_1 )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getDestinationAssignment_6_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3140:1: ( rule__FlowSpecInstance__DestinationAssignment_6_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3140:2: rule__FlowSpecInstance__DestinationAssignment_6_1
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__DestinationAssignment_6_1_in_rule__FlowSpecInstance__Group_6__1__Impl6353);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3154:1: rule__FlowSpecInstance__Group_7__0 : rule__FlowSpecInstance__Group_7__0__Impl rule__FlowSpecInstance__Group_7__1 ;
    public final void rule__FlowSpecInstance__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3158:1: ( rule__FlowSpecInstance__Group_7__0__Impl rule__FlowSpecInstance__Group_7__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3159:2: rule__FlowSpecInstance__Group_7__0__Impl rule__FlowSpecInstance__Group_7__1
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_7__0__Impl_in_rule__FlowSpecInstance__Group_7__06387);
            rule__FlowSpecInstance__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_7__1_in_rule__FlowSpecInstance__Group_7__06390);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3166:1: rule__FlowSpecInstance__Group_7__0__Impl : ( 'in' ) ;
    public final void rule__FlowSpecInstance__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3170:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3171:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3171:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3172:1: 'in'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInKeyword_7_0()); 
            match(input,29,FOLLOW_29_in_rule__FlowSpecInstance__Group_7__0__Impl6418); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3185:1: rule__FlowSpecInstance__Group_7__1 : rule__FlowSpecInstance__Group_7__1__Impl rule__FlowSpecInstance__Group_7__2 ;
    public final void rule__FlowSpecInstance__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3189:1: ( rule__FlowSpecInstance__Group_7__1__Impl rule__FlowSpecInstance__Group_7__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3190:2: rule__FlowSpecInstance__Group_7__1__Impl rule__FlowSpecInstance__Group_7__2
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_7__1__Impl_in_rule__FlowSpecInstance__Group_7__16449);
            rule__FlowSpecInstance__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_7__2_in_rule__FlowSpecInstance__Group_7__16452);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3197:1: rule__FlowSpecInstance__Group_7__1__Impl : ( 'mode' ) ;
    public final void rule__FlowSpecInstance__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3201:1: ( ( 'mode' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3202:1: ( 'mode' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3202:1: ( 'mode' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3203:1: 'mode'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getModeKeyword_7_1()); 
            match(input,44,FOLLOW_44_in_rule__FlowSpecInstance__Group_7__1__Impl6480); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3216:1: rule__FlowSpecInstance__Group_7__2 : rule__FlowSpecInstance__Group_7__2__Impl ;
    public final void rule__FlowSpecInstance__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3220:1: ( rule__FlowSpecInstance__Group_7__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3221:2: rule__FlowSpecInstance__Group_7__2__Impl
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_7__2__Impl_in_rule__FlowSpecInstance__Group_7__26511);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3227:1: rule__FlowSpecInstance__Group_7__2__Impl : ( ( rule__FlowSpecInstance__InModeAssignment_7_2 ) ) ;
    public final void rule__FlowSpecInstance__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3231:1: ( ( ( rule__FlowSpecInstance__InModeAssignment_7_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3232:1: ( ( rule__FlowSpecInstance__InModeAssignment_7_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3232:1: ( ( rule__FlowSpecInstance__InModeAssignment_7_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3233:1: ( rule__FlowSpecInstance__InModeAssignment_7_2 )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInModeAssignment_7_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3234:1: ( rule__FlowSpecInstance__InModeAssignment_7_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3234:2: rule__FlowSpecInstance__InModeAssignment_7_2
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__InModeAssignment_7_2_in_rule__FlowSpecInstance__Group_7__2__Impl6538);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3250:1: rule__FlowSpecInstance__Group_8__0 : rule__FlowSpecInstance__Group_8__0__Impl rule__FlowSpecInstance__Group_8__1 ;
    public final void rule__FlowSpecInstance__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3254:1: ( rule__FlowSpecInstance__Group_8__0__Impl rule__FlowSpecInstance__Group_8__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3255:2: rule__FlowSpecInstance__Group_8__0__Impl rule__FlowSpecInstance__Group_8__1
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_8__0__Impl_in_rule__FlowSpecInstance__Group_8__06574);
            rule__FlowSpecInstance__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_8__1_in_rule__FlowSpecInstance__Group_8__06577);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3262:1: rule__FlowSpecInstance__Group_8__0__Impl : ( 'in' ) ;
    public final void rule__FlowSpecInstance__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3266:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3267:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3267:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3268:1: 'in'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInKeyword_8_0()); 
            match(input,29,FOLLOW_29_in_rule__FlowSpecInstance__Group_8__0__Impl6605); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3281:1: rule__FlowSpecInstance__Group_8__1 : rule__FlowSpecInstance__Group_8__1__Impl rule__FlowSpecInstance__Group_8__2 ;
    public final void rule__FlowSpecInstance__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3285:1: ( rule__FlowSpecInstance__Group_8__1__Impl rule__FlowSpecInstance__Group_8__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3286:2: rule__FlowSpecInstance__Group_8__1__Impl rule__FlowSpecInstance__Group_8__2
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_8__1__Impl_in_rule__FlowSpecInstance__Group_8__16636);
            rule__FlowSpecInstance__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_8__2_in_rule__FlowSpecInstance__Group_8__16639);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3293:1: rule__FlowSpecInstance__Group_8__1__Impl : ( 'transition' ) ;
    public final void rule__FlowSpecInstance__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3297:1: ( ( 'transition' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3298:1: ( 'transition' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3298:1: ( 'transition' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3299:1: 'transition'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getTransitionKeyword_8_1()); 
            match(input,45,FOLLOW_45_in_rule__FlowSpecInstance__Group_8__1__Impl6667); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3312:1: rule__FlowSpecInstance__Group_8__2 : rule__FlowSpecInstance__Group_8__2__Impl ;
    public final void rule__FlowSpecInstance__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3316:1: ( rule__FlowSpecInstance__Group_8__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3317:2: rule__FlowSpecInstance__Group_8__2__Impl
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_8__2__Impl_in_rule__FlowSpecInstance__Group_8__26698);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3323:1: rule__FlowSpecInstance__Group_8__2__Impl : ( ( rule__FlowSpecInstance__InModeTransitionAssignment_8_2 ) ) ;
    public final void rule__FlowSpecInstance__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3327:1: ( ( ( rule__FlowSpecInstance__InModeTransitionAssignment_8_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3328:1: ( ( rule__FlowSpecInstance__InModeTransitionAssignment_8_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3328:1: ( ( rule__FlowSpecInstance__InModeTransitionAssignment_8_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3329:1: ( rule__FlowSpecInstance__InModeTransitionAssignment_8_2 )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInModeTransitionAssignment_8_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3330:1: ( rule__FlowSpecInstance__InModeTransitionAssignment_8_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3330:2: rule__FlowSpecInstance__InModeTransitionAssignment_8_2
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__InModeTransitionAssignment_8_2_in_rule__FlowSpecInstance__Group_8__2__Impl6725);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3346:1: rule__EndToEndFlowInstance__Group__0 : rule__EndToEndFlowInstance__Group__0__Impl rule__EndToEndFlowInstance__Group__1 ;
    public final void rule__EndToEndFlowInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3350:1: ( rule__EndToEndFlowInstance__Group__0__Impl rule__EndToEndFlowInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3351:2: rule__EndToEndFlowInstance__Group__0__Impl rule__EndToEndFlowInstance__Group__1
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__0__Impl_in_rule__EndToEndFlowInstance__Group__06761);
            rule__EndToEndFlowInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__1_in_rule__EndToEndFlowInstance__Group__06764);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3358:1: rule__EndToEndFlowInstance__Group__0__Impl : ( 'etef' ) ;
    public final void rule__EndToEndFlowInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3362:1: ( ( 'etef' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3363:1: ( 'etef' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3363:1: ( 'etef' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3364:1: 'etef'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getEtefKeyword_0()); 
            match(input,49,FOLLOW_49_in_rule__EndToEndFlowInstance__Group__0__Impl6792); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3377:1: rule__EndToEndFlowInstance__Group__1 : rule__EndToEndFlowInstance__Group__1__Impl rule__EndToEndFlowInstance__Group__2 ;
    public final void rule__EndToEndFlowInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3381:1: ( rule__EndToEndFlowInstance__Group__1__Impl rule__EndToEndFlowInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3382:2: rule__EndToEndFlowInstance__Group__1__Impl rule__EndToEndFlowInstance__Group__2
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__1__Impl_in_rule__EndToEndFlowInstance__Group__16823);
            rule__EndToEndFlowInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__2_in_rule__EndToEndFlowInstance__Group__16826);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3389:1: rule__EndToEndFlowInstance__Group__1__Impl : ( 'instance' ) ;
    public final void rule__EndToEndFlowInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3393:1: ( ( 'instance' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3394:1: ( 'instance' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3394:1: ( 'instance' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3395:1: 'instance'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInstanceKeyword_1()); 
            match(input,39,FOLLOW_39_in_rule__EndToEndFlowInstance__Group__1__Impl6854); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3408:1: rule__EndToEndFlowInstance__Group__2 : rule__EndToEndFlowInstance__Group__2__Impl rule__EndToEndFlowInstance__Group__3 ;
    public final void rule__EndToEndFlowInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3412:1: ( rule__EndToEndFlowInstance__Group__2__Impl rule__EndToEndFlowInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3413:2: rule__EndToEndFlowInstance__Group__2__Impl rule__EndToEndFlowInstance__Group__3
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__2__Impl_in_rule__EndToEndFlowInstance__Group__26885);
            rule__EndToEndFlowInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__3_in_rule__EndToEndFlowInstance__Group__26888);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3420:1: rule__EndToEndFlowInstance__Group__2__Impl : ( ( rule__EndToEndFlowInstance__NameAssignment_2 ) ) ;
    public final void rule__EndToEndFlowInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3424:1: ( ( ( rule__EndToEndFlowInstance__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3425:1: ( ( rule__EndToEndFlowInstance__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3425:1: ( ( rule__EndToEndFlowInstance__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3426:1: ( rule__EndToEndFlowInstance__NameAssignment_2 )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3427:1: ( rule__EndToEndFlowInstance__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3427:2: rule__EndToEndFlowInstance__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__NameAssignment_2_in_rule__EndToEndFlowInstance__Group__2__Impl6915);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3437:1: rule__EndToEndFlowInstance__Group__3 : rule__EndToEndFlowInstance__Group__3__Impl rule__EndToEndFlowInstance__Group__4 ;
    public final void rule__EndToEndFlowInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3441:1: ( rule__EndToEndFlowInstance__Group__3__Impl rule__EndToEndFlowInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3442:2: rule__EndToEndFlowInstance__Group__3__Impl rule__EndToEndFlowInstance__Group__4
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__3__Impl_in_rule__EndToEndFlowInstance__Group__36945);
            rule__EndToEndFlowInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__4_in_rule__EndToEndFlowInstance__Group__36948);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3449:1: rule__EndToEndFlowInstance__Group__3__Impl : ( 'of' ) ;
    public final void rule__EndToEndFlowInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3453:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3454:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3454:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3455:1: 'of'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getOfKeyword_3()); 
            match(input,40,FOLLOW_40_in_rule__EndToEndFlowInstance__Group__3__Impl6976); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3468:1: rule__EndToEndFlowInstance__Group__4 : rule__EndToEndFlowInstance__Group__4__Impl rule__EndToEndFlowInstance__Group__5 ;
    public final void rule__EndToEndFlowInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3472:1: ( rule__EndToEndFlowInstance__Group__4__Impl rule__EndToEndFlowInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3473:2: rule__EndToEndFlowInstance__Group__4__Impl rule__EndToEndFlowInstance__Group__5
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__4__Impl_in_rule__EndToEndFlowInstance__Group__47007);
            rule__EndToEndFlowInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__5_in_rule__EndToEndFlowInstance__Group__47010);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3480:1: rule__EndToEndFlowInstance__Group__4__Impl : ( ( rule__EndToEndFlowInstance__EndToEndFlowAssignment_4 ) ) ;
    public final void rule__EndToEndFlowInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3484:1: ( ( ( rule__EndToEndFlowInstance__EndToEndFlowAssignment_4 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3485:1: ( ( rule__EndToEndFlowInstance__EndToEndFlowAssignment_4 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3485:1: ( ( rule__EndToEndFlowInstance__EndToEndFlowAssignment_4 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3486:1: ( rule__EndToEndFlowInstance__EndToEndFlowAssignment_4 )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3487:1: ( rule__EndToEndFlowInstance__EndToEndFlowAssignment_4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3487:2: rule__EndToEndFlowInstance__EndToEndFlowAssignment_4
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__EndToEndFlowAssignment_4_in_rule__EndToEndFlowInstance__Group__4__Impl7037);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3497:1: rule__EndToEndFlowInstance__Group__5 : rule__EndToEndFlowInstance__Group__5__Impl rule__EndToEndFlowInstance__Group__6 ;
    public final void rule__EndToEndFlowInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3501:1: ( rule__EndToEndFlowInstance__Group__5__Impl rule__EndToEndFlowInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3502:2: rule__EndToEndFlowInstance__Group__5__Impl rule__EndToEndFlowInstance__Group__6
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__5__Impl_in_rule__EndToEndFlowInstance__Group__57067);
            rule__EndToEndFlowInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__6_in_rule__EndToEndFlowInstance__Group__57070);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3509:1: rule__EndToEndFlowInstance__Group__5__Impl : ( ( rule__EndToEndFlowInstance__FlowElementAssignment_5 )* ) ;
    public final void rule__EndToEndFlowInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3513:1: ( ( ( rule__EndToEndFlowInstance__FlowElementAssignment_5 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3514:1: ( ( rule__EndToEndFlowInstance__FlowElementAssignment_5 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3514:1: ( ( rule__EndToEndFlowInstance__FlowElementAssignment_5 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3515:1: ( rule__EndToEndFlowInstance__FlowElementAssignment_5 )*
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3516:1: ( rule__EndToEndFlowInstance__FlowElementAssignment_5 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3516:2: rule__EndToEndFlowInstance__FlowElementAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__EndToEndFlowInstance__FlowElementAssignment_5_in_rule__EndToEndFlowInstance__Group__5__Impl7097);
            	    rule__EndToEndFlowInstance__FlowElementAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3526:1: rule__EndToEndFlowInstance__Group__6 : rule__EndToEndFlowInstance__Group__6__Impl rule__EndToEndFlowInstance__Group__7 ;
    public final void rule__EndToEndFlowInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3530:1: ( rule__EndToEndFlowInstance__Group__6__Impl rule__EndToEndFlowInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3531:2: rule__EndToEndFlowInstance__Group__6__Impl rule__EndToEndFlowInstance__Group__7
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__6__Impl_in_rule__EndToEndFlowInstance__Group__67128);
            rule__EndToEndFlowInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__7_in_rule__EndToEndFlowInstance__Group__67131);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3538:1: rule__EndToEndFlowInstance__Group__6__Impl : ( ( rule__EndToEndFlowInstance__Group_6__0 )? ) ;
    public final void rule__EndToEndFlowInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3542:1: ( ( ( rule__EndToEndFlowInstance__Group_6__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3543:1: ( ( rule__EndToEndFlowInstance__Group_6__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3543:1: ( ( rule__EndToEndFlowInstance__Group_6__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3544:1: ( rule__EndToEndFlowInstance__Group_6__0 )?
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3545:1: ( rule__EndToEndFlowInstance__Group_6__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==29) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==44) ) {
                    alt23=1;
                }
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3545:2: rule__EndToEndFlowInstance__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_6__0_in_rule__EndToEndFlowInstance__Group__6__Impl7158);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3555:1: rule__EndToEndFlowInstance__Group__7 : rule__EndToEndFlowInstance__Group__7__Impl rule__EndToEndFlowInstance__Group__8 ;
    public final void rule__EndToEndFlowInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3559:1: ( rule__EndToEndFlowInstance__Group__7__Impl rule__EndToEndFlowInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3560:2: rule__EndToEndFlowInstance__Group__7__Impl rule__EndToEndFlowInstance__Group__8
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__7__Impl_in_rule__EndToEndFlowInstance__Group__77189);
            rule__EndToEndFlowInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__8_in_rule__EndToEndFlowInstance__Group__77192);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3567:1: rule__EndToEndFlowInstance__Group__7__Impl : ( ( rule__EndToEndFlowInstance__Group_7__0 )? ) ;
    public final void rule__EndToEndFlowInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3571:1: ( ( ( rule__EndToEndFlowInstance__Group_7__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3572:1: ( ( rule__EndToEndFlowInstance__Group_7__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3572:1: ( ( rule__EndToEndFlowInstance__Group_7__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3573:1: ( rule__EndToEndFlowInstance__Group_7__0 )?
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3574:1: ( rule__EndToEndFlowInstance__Group_7__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==29) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3574:2: rule__EndToEndFlowInstance__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_7__0_in_rule__EndToEndFlowInstance__Group__7__Impl7219);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3584:1: rule__EndToEndFlowInstance__Group__8 : rule__EndToEndFlowInstance__Group__8__Impl ;
    public final void rule__EndToEndFlowInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3588:1: ( rule__EndToEndFlowInstance__Group__8__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3589:2: rule__EndToEndFlowInstance__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__8__Impl_in_rule__EndToEndFlowInstance__Group__87250);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3595:1: rule__EndToEndFlowInstance__Group__8__Impl : ( 'end' ) ;
    public final void rule__EndToEndFlowInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3599:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3600:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3600:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3601:1: 'end'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_8()); 
            match(input,41,FOLLOW_41_in_rule__EndToEndFlowInstance__Group__8__Impl7278); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3632:1: rule__EndToEndFlowInstance__Group_6__0 : rule__EndToEndFlowInstance__Group_6__0__Impl rule__EndToEndFlowInstance__Group_6__1 ;
    public final void rule__EndToEndFlowInstance__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3636:1: ( rule__EndToEndFlowInstance__Group_6__0__Impl rule__EndToEndFlowInstance__Group_6__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3637:2: rule__EndToEndFlowInstance__Group_6__0__Impl rule__EndToEndFlowInstance__Group_6__1
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_6__0__Impl_in_rule__EndToEndFlowInstance__Group_6__07327);
            rule__EndToEndFlowInstance__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_6__1_in_rule__EndToEndFlowInstance__Group_6__07330);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3644:1: rule__EndToEndFlowInstance__Group_6__0__Impl : ( 'in' ) ;
    public final void rule__EndToEndFlowInstance__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3648:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3649:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3649:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3650:1: 'in'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInKeyword_6_0()); 
            match(input,29,FOLLOW_29_in_rule__EndToEndFlowInstance__Group_6__0__Impl7358); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3663:1: rule__EndToEndFlowInstance__Group_6__1 : rule__EndToEndFlowInstance__Group_6__1__Impl rule__EndToEndFlowInstance__Group_6__2 ;
    public final void rule__EndToEndFlowInstance__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3667:1: ( rule__EndToEndFlowInstance__Group_6__1__Impl rule__EndToEndFlowInstance__Group_6__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3668:2: rule__EndToEndFlowInstance__Group_6__1__Impl rule__EndToEndFlowInstance__Group_6__2
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_6__1__Impl_in_rule__EndToEndFlowInstance__Group_6__17389);
            rule__EndToEndFlowInstance__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_6__2_in_rule__EndToEndFlowInstance__Group_6__17392);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3675:1: rule__EndToEndFlowInstance__Group_6__1__Impl : ( 'mode' ) ;
    public final void rule__EndToEndFlowInstance__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3679:1: ( ( 'mode' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3680:1: ( 'mode' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3680:1: ( 'mode' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3681:1: 'mode'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getModeKeyword_6_1()); 
            match(input,44,FOLLOW_44_in_rule__EndToEndFlowInstance__Group_6__1__Impl7420); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3694:1: rule__EndToEndFlowInstance__Group_6__2 : rule__EndToEndFlowInstance__Group_6__2__Impl ;
    public final void rule__EndToEndFlowInstance__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3698:1: ( rule__EndToEndFlowInstance__Group_6__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3699:2: rule__EndToEndFlowInstance__Group_6__2__Impl
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_6__2__Impl_in_rule__EndToEndFlowInstance__Group_6__27451);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3705:1: rule__EndToEndFlowInstance__Group_6__2__Impl : ( ( rule__EndToEndFlowInstance__InModeAssignment_6_2 ) ) ;
    public final void rule__EndToEndFlowInstance__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3709:1: ( ( ( rule__EndToEndFlowInstance__InModeAssignment_6_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3710:1: ( ( rule__EndToEndFlowInstance__InModeAssignment_6_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3710:1: ( ( rule__EndToEndFlowInstance__InModeAssignment_6_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3711:1: ( rule__EndToEndFlowInstance__InModeAssignment_6_2 )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInModeAssignment_6_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3712:1: ( rule__EndToEndFlowInstance__InModeAssignment_6_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3712:2: rule__EndToEndFlowInstance__InModeAssignment_6_2
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__InModeAssignment_6_2_in_rule__EndToEndFlowInstance__Group_6__2__Impl7478);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3728:1: rule__EndToEndFlowInstance__Group_7__0 : rule__EndToEndFlowInstance__Group_7__0__Impl rule__EndToEndFlowInstance__Group_7__1 ;
    public final void rule__EndToEndFlowInstance__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3732:1: ( rule__EndToEndFlowInstance__Group_7__0__Impl rule__EndToEndFlowInstance__Group_7__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3733:2: rule__EndToEndFlowInstance__Group_7__0__Impl rule__EndToEndFlowInstance__Group_7__1
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_7__0__Impl_in_rule__EndToEndFlowInstance__Group_7__07514);
            rule__EndToEndFlowInstance__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_7__1_in_rule__EndToEndFlowInstance__Group_7__07517);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3740:1: rule__EndToEndFlowInstance__Group_7__0__Impl : ( 'in' ) ;
    public final void rule__EndToEndFlowInstance__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3744:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3745:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3745:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3746:1: 'in'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInKeyword_7_0()); 
            match(input,29,FOLLOW_29_in_rule__EndToEndFlowInstance__Group_7__0__Impl7545); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3759:1: rule__EndToEndFlowInstance__Group_7__1 : rule__EndToEndFlowInstance__Group_7__1__Impl rule__EndToEndFlowInstance__Group_7__2 ;
    public final void rule__EndToEndFlowInstance__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3763:1: ( rule__EndToEndFlowInstance__Group_7__1__Impl rule__EndToEndFlowInstance__Group_7__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3764:2: rule__EndToEndFlowInstance__Group_7__1__Impl rule__EndToEndFlowInstance__Group_7__2
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_7__1__Impl_in_rule__EndToEndFlowInstance__Group_7__17576);
            rule__EndToEndFlowInstance__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_7__2_in_rule__EndToEndFlowInstance__Group_7__17579);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3771:1: rule__EndToEndFlowInstance__Group_7__1__Impl : ( 'som' ) ;
    public final void rule__EndToEndFlowInstance__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3775:1: ( ( 'som' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3776:1: ( 'som' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3776:1: ( 'som' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3777:1: 'som'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getSomKeyword_7_1()); 
            match(input,50,FOLLOW_50_in_rule__EndToEndFlowInstance__Group_7__1__Impl7607); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3790:1: rule__EndToEndFlowInstance__Group_7__2 : rule__EndToEndFlowInstance__Group_7__2__Impl ;
    public final void rule__EndToEndFlowInstance__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3794:1: ( rule__EndToEndFlowInstance__Group_7__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3795:2: rule__EndToEndFlowInstance__Group_7__2__Impl
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_7__2__Impl_in_rule__EndToEndFlowInstance__Group_7__27638);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3801:1: rule__EndToEndFlowInstance__Group_7__2__Impl : ( ( rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2 ) ) ;
    public final void rule__EndToEndFlowInstance__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3805:1: ( ( ( rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3806:1: ( ( rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3806:1: ( ( rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3807:1: ( rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2 )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeAssignment_7_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3808:1: ( rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3808:2: rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2_in_rule__EndToEndFlowInstance__Group_7__2__Impl7665);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3824:1: rule__SystemOperationMode__Group__0 : rule__SystemOperationMode__Group__0__Impl rule__SystemOperationMode__Group__1 ;
    public final void rule__SystemOperationMode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3828:1: ( rule__SystemOperationMode__Group__0__Impl rule__SystemOperationMode__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3829:2: rule__SystemOperationMode__Group__0__Impl rule__SystemOperationMode__Group__1
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__Group__0__Impl_in_rule__SystemOperationMode__Group__07701);
            rule__SystemOperationMode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemOperationMode__Group__1_in_rule__SystemOperationMode__Group__07704);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3836:1: rule__SystemOperationMode__Group__0__Impl : ( 'som' ) ;
    public final void rule__SystemOperationMode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3840:1: ( ( 'som' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3841:1: ( 'som' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3841:1: ( 'som' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3842:1: 'som'
            {
             before(grammarAccess.getSystemOperationModeAccess().getSomKeyword_0()); 
            match(input,50,FOLLOW_50_in_rule__SystemOperationMode__Group__0__Impl7732); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3855:1: rule__SystemOperationMode__Group__1 : rule__SystemOperationMode__Group__1__Impl ;
    public final void rule__SystemOperationMode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3859:1: ( rule__SystemOperationMode__Group__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3860:2: rule__SystemOperationMode__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__Group__1__Impl_in_rule__SystemOperationMode__Group__17763);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3866:1: rule__SystemOperationMode__Group__1__Impl : ( ( rule__SystemOperationMode__NameAssignment_1 ) ) ;
    public final void rule__SystemOperationMode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3870:1: ( ( ( rule__SystemOperationMode__NameAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3871:1: ( ( rule__SystemOperationMode__NameAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3871:1: ( ( rule__SystemOperationMode__NameAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3872:1: ( rule__SystemOperationMode__NameAssignment_1 )
            {
             before(grammarAccess.getSystemOperationModeAccess().getNameAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3873:1: ( rule__SystemOperationMode__NameAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3873:2: rule__SystemOperationMode__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__NameAssignment_1_in_rule__SystemOperationMode__Group__1__Impl7790);
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


    // $ANTLR start "rule__ConnectionInstance__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3887:1: rule__ConnectionInstance__Group__0 : rule__ConnectionInstance__Group__0__Impl rule__ConnectionInstance__Group__1 ;
    public final void rule__ConnectionInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3891:1: ( rule__ConnectionInstance__Group__0__Impl rule__ConnectionInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3892:2: rule__ConnectionInstance__Group__0__Impl rule__ConnectionInstance__Group__1
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__0__Impl_in_rule__ConnectionInstance__Group__07824);
            rule__ConnectionInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__1_in_rule__ConnectionInstance__Group__07827);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3899:1: rule__ConnectionInstance__Group__0__Impl : ( ( rule__ConnectionInstance__KindAssignment_0 ) ) ;
    public final void rule__ConnectionInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3903:1: ( ( ( rule__ConnectionInstance__KindAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3904:1: ( ( rule__ConnectionInstance__KindAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3904:1: ( ( rule__ConnectionInstance__KindAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3905:1: ( rule__ConnectionInstance__KindAssignment_0 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getKindAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3906:1: ( rule__ConnectionInstance__KindAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3906:2: rule__ConnectionInstance__KindAssignment_0
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__KindAssignment_0_in_rule__ConnectionInstance__Group__0__Impl7854);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3916:1: rule__ConnectionInstance__Group__1 : rule__ConnectionInstance__Group__1__Impl rule__ConnectionInstance__Group__2 ;
    public final void rule__ConnectionInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3920:1: ( rule__ConnectionInstance__Group__1__Impl rule__ConnectionInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3921:2: rule__ConnectionInstance__Group__1__Impl rule__ConnectionInstance__Group__2
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__1__Impl_in_rule__ConnectionInstance__Group__17884);
            rule__ConnectionInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__2_in_rule__ConnectionInstance__Group__17887);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3928:1: rule__ConnectionInstance__Group__1__Impl : ( 'connection' ) ;
    public final void rule__ConnectionInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3932:1: ( ( 'connection' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3933:1: ( 'connection' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3933:1: ( 'connection' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3934:1: 'connection'
            {
             before(grammarAccess.getConnectionInstanceAccess().getConnectionKeyword_1()); 
            match(input,51,FOLLOW_51_in_rule__ConnectionInstance__Group__1__Impl7915); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3947:1: rule__ConnectionInstance__Group__2 : rule__ConnectionInstance__Group__2__Impl rule__ConnectionInstance__Group__3 ;
    public final void rule__ConnectionInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3951:1: ( rule__ConnectionInstance__Group__2__Impl rule__ConnectionInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3952:2: rule__ConnectionInstance__Group__2__Impl rule__ConnectionInstance__Group__3
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__2__Impl_in_rule__ConnectionInstance__Group__27946);
            rule__ConnectionInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__3_in_rule__ConnectionInstance__Group__27949);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3959:1: rule__ConnectionInstance__Group__2__Impl : ( 'instance' ) ;
    public final void rule__ConnectionInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3963:1: ( ( 'instance' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3964:1: ( 'instance' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3964:1: ( 'instance' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3965:1: 'instance'
            {
             before(grammarAccess.getConnectionInstanceAccess().getInstanceKeyword_2()); 
            match(input,39,FOLLOW_39_in_rule__ConnectionInstance__Group__2__Impl7977); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3978:1: rule__ConnectionInstance__Group__3 : rule__ConnectionInstance__Group__3__Impl rule__ConnectionInstance__Group__4 ;
    public final void rule__ConnectionInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3982:1: ( rule__ConnectionInstance__Group__3__Impl rule__ConnectionInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3983:2: rule__ConnectionInstance__Group__3__Impl rule__ConnectionInstance__Group__4
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__3__Impl_in_rule__ConnectionInstance__Group__38008);
            rule__ConnectionInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__4_in_rule__ConnectionInstance__Group__38011);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3990:1: rule__ConnectionInstance__Group__3__Impl : ( 'of' ) ;
    public final void rule__ConnectionInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3994:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3995:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3995:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3996:1: 'of'
            {
             before(grammarAccess.getConnectionInstanceAccess().getOfKeyword_3()); 
            match(input,40,FOLLOW_40_in_rule__ConnectionInstance__Group__3__Impl8039); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4009:1: rule__ConnectionInstance__Group__4 : rule__ConnectionInstance__Group__4__Impl rule__ConnectionInstance__Group__5 ;
    public final void rule__ConnectionInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4013:1: ( rule__ConnectionInstance__Group__4__Impl rule__ConnectionInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4014:2: rule__ConnectionInstance__Group__4__Impl rule__ConnectionInstance__Group__5
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__4__Impl_in_rule__ConnectionInstance__Group__48070);
            rule__ConnectionInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__5_in_rule__ConnectionInstance__Group__48073);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4021:1: rule__ConnectionInstance__Group__4__Impl : ( ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )* ) ) ;
    public final void rule__ConnectionInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4025:1: ( ( ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4026:1: ( ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4026:1: ( ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4027:1: ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4027:1: ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4028:1: ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4029:1: ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4029:2: rule__ConnectionInstance__ConnectionReferenceAssignment_4
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__ConnectionReferenceAssignment_4_in_rule__ConnectionInstance__Group__4__Impl8102);
            rule__ConnectionInstance__ConnectionReferenceAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceAssignment_4()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4032:1: ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4033:1: ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )*
            {
             before(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4034:1: ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==40) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4034:2: rule__ConnectionInstance__ConnectionReferenceAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__ConnectionInstance__ConnectionReferenceAssignment_4_in_rule__ConnectionInstance__Group__4__Impl8114);
            	    rule__ConnectionInstance__ConnectionReferenceAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4045:1: rule__ConnectionInstance__Group__5 : rule__ConnectionInstance__Group__5__Impl rule__ConnectionInstance__Group__6 ;
    public final void rule__ConnectionInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4049:1: ( rule__ConnectionInstance__Group__5__Impl rule__ConnectionInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4050:2: rule__ConnectionInstance__Group__5__Impl rule__ConnectionInstance__Group__6
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__5__Impl_in_rule__ConnectionInstance__Group__58147);
            rule__ConnectionInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__6_in_rule__ConnectionInstance__Group__58150);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4057:1: rule__ConnectionInstance__Group__5__Impl : ( 'src' ) ;
    public final void rule__ConnectionInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4061:1: ( ( 'src' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4062:1: ( 'src' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4062:1: ( 'src' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4063:1: 'src'
            {
             before(grammarAccess.getConnectionInstanceAccess().getSrcKeyword_5()); 
            match(input,46,FOLLOW_46_in_rule__ConnectionInstance__Group__5__Impl8178); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4076:1: rule__ConnectionInstance__Group__6 : rule__ConnectionInstance__Group__6__Impl rule__ConnectionInstance__Group__7 ;
    public final void rule__ConnectionInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4080:1: ( rule__ConnectionInstance__Group__6__Impl rule__ConnectionInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4081:2: rule__ConnectionInstance__Group__6__Impl rule__ConnectionInstance__Group__7
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__6__Impl_in_rule__ConnectionInstance__Group__68209);
            rule__ConnectionInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__7_in_rule__ConnectionInstance__Group__68212);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4088:1: rule__ConnectionInstance__Group__6__Impl : ( ( rule__ConnectionInstance__SourceAssignment_6 ) ) ;
    public final void rule__ConnectionInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4092:1: ( ( ( rule__ConnectionInstance__SourceAssignment_6 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4093:1: ( ( rule__ConnectionInstance__SourceAssignment_6 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4093:1: ( ( rule__ConnectionInstance__SourceAssignment_6 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4094:1: ( rule__ConnectionInstance__SourceAssignment_6 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getSourceAssignment_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4095:1: ( rule__ConnectionInstance__SourceAssignment_6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4095:2: rule__ConnectionInstance__SourceAssignment_6
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__SourceAssignment_6_in_rule__ConnectionInstance__Group__6__Impl8239);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4105:1: rule__ConnectionInstance__Group__7 : rule__ConnectionInstance__Group__7__Impl rule__ConnectionInstance__Group__8 ;
    public final void rule__ConnectionInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4109:1: ( rule__ConnectionInstance__Group__7__Impl rule__ConnectionInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4110:2: rule__ConnectionInstance__Group__7__Impl rule__ConnectionInstance__Group__8
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__7__Impl_in_rule__ConnectionInstance__Group__78269);
            rule__ConnectionInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__8_in_rule__ConnectionInstance__Group__78272);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4117:1: rule__ConnectionInstance__Group__7__Impl : ( 'dst' ) ;
    public final void rule__ConnectionInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4121:1: ( ( 'dst' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4122:1: ( 'dst' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4122:1: ( 'dst' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4123:1: 'dst'
            {
             before(grammarAccess.getConnectionInstanceAccess().getDstKeyword_7()); 
            match(input,47,FOLLOW_47_in_rule__ConnectionInstance__Group__7__Impl8300); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4136:1: rule__ConnectionInstance__Group__8 : rule__ConnectionInstance__Group__8__Impl rule__ConnectionInstance__Group__9 ;
    public final void rule__ConnectionInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4140:1: ( rule__ConnectionInstance__Group__8__Impl rule__ConnectionInstance__Group__9 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4141:2: rule__ConnectionInstance__Group__8__Impl rule__ConnectionInstance__Group__9
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__8__Impl_in_rule__ConnectionInstance__Group__88331);
            rule__ConnectionInstance__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__9_in_rule__ConnectionInstance__Group__88334);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4148:1: rule__ConnectionInstance__Group__8__Impl : ( ( rule__ConnectionInstance__DestinationAssignment_8 ) ) ;
    public final void rule__ConnectionInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4152:1: ( ( ( rule__ConnectionInstance__DestinationAssignment_8 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4153:1: ( ( rule__ConnectionInstance__DestinationAssignment_8 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4153:1: ( ( rule__ConnectionInstance__DestinationAssignment_8 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4154:1: ( rule__ConnectionInstance__DestinationAssignment_8 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getDestinationAssignment_8()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4155:1: ( rule__ConnectionInstance__DestinationAssignment_8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4155:2: rule__ConnectionInstance__DestinationAssignment_8
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__DestinationAssignment_8_in_rule__ConnectionInstance__Group__8__Impl8361);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4165:1: rule__ConnectionInstance__Group__9 : rule__ConnectionInstance__Group__9__Impl rule__ConnectionInstance__Group__10 ;
    public final void rule__ConnectionInstance__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4169:1: ( rule__ConnectionInstance__Group__9__Impl rule__ConnectionInstance__Group__10 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4170:2: rule__ConnectionInstance__Group__9__Impl rule__ConnectionInstance__Group__10
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__9__Impl_in_rule__ConnectionInstance__Group__98391);
            rule__ConnectionInstance__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__10_in_rule__ConnectionInstance__Group__98394);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4177:1: rule__ConnectionInstance__Group__9__Impl : ( ( rule__ConnectionInstance__Group_9__0 )? ) ;
    public final void rule__ConnectionInstance__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4181:1: ( ( ( rule__ConnectionInstance__Group_9__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4182:1: ( ( rule__ConnectionInstance__Group_9__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4182:1: ( ( rule__ConnectionInstance__Group_9__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4183:1: ( rule__ConnectionInstance__Group_9__0 )?
            {
             before(grammarAccess.getConnectionInstanceAccess().getGroup_9()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4184:1: ( rule__ConnectionInstance__Group_9__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==29) ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==50) ) {
                    alt26=1;
                }
            }
            switch (alt26) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4184:2: rule__ConnectionInstance__Group_9__0
                    {
                    pushFollow(FOLLOW_rule__ConnectionInstance__Group_9__0_in_rule__ConnectionInstance__Group__9__Impl8421);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4194:1: rule__ConnectionInstance__Group__10 : rule__ConnectionInstance__Group__10__Impl rule__ConnectionInstance__Group__11 ;
    public final void rule__ConnectionInstance__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4198:1: ( rule__ConnectionInstance__Group__10__Impl rule__ConnectionInstance__Group__11 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4199:2: rule__ConnectionInstance__Group__10__Impl rule__ConnectionInstance__Group__11
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__10__Impl_in_rule__ConnectionInstance__Group__108452);
            rule__ConnectionInstance__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__11_in_rule__ConnectionInstance__Group__108455);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4206:1: rule__ConnectionInstance__Group__10__Impl : ( ( rule__ConnectionInstance__Group_10__0 )? ) ;
    public final void rule__ConnectionInstance__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4210:1: ( ( ( rule__ConnectionInstance__Group_10__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4211:1: ( ( rule__ConnectionInstance__Group_10__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4211:1: ( ( rule__ConnectionInstance__Group_10__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4212:1: ( rule__ConnectionInstance__Group_10__0 )?
            {
             before(grammarAccess.getConnectionInstanceAccess().getGroup_10()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4213:1: ( rule__ConnectionInstance__Group_10__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==29) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4213:2: rule__ConnectionInstance__Group_10__0
                    {
                    pushFollow(FOLLOW_rule__ConnectionInstance__Group_10__0_in_rule__ConnectionInstance__Group__10__Impl8482);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4223:1: rule__ConnectionInstance__Group__11 : rule__ConnectionInstance__Group__11__Impl rule__ConnectionInstance__Group__12 ;
    public final void rule__ConnectionInstance__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4227:1: ( rule__ConnectionInstance__Group__11__Impl rule__ConnectionInstance__Group__12 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4228:2: rule__ConnectionInstance__Group__11__Impl rule__ConnectionInstance__Group__12
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__11__Impl_in_rule__ConnectionInstance__Group__118513);
            rule__ConnectionInstance__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__12_in_rule__ConnectionInstance__Group__118516);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4235:1: rule__ConnectionInstance__Group__11__Impl : ( ( rule__ConnectionInstance__CompleteAssignment_11 )? ) ;
    public final void rule__ConnectionInstance__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4239:1: ( ( ( rule__ConnectionInstance__CompleteAssignment_11 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4240:1: ( ( rule__ConnectionInstance__CompleteAssignment_11 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4240:1: ( ( rule__ConnectionInstance__CompleteAssignment_11 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4241:1: ( rule__ConnectionInstance__CompleteAssignment_11 )?
            {
             before(grammarAccess.getConnectionInstanceAccess().getCompleteAssignment_11()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4242:1: ( rule__ConnectionInstance__CompleteAssignment_11 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==59) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4242:2: rule__ConnectionInstance__CompleteAssignment_11
                    {
                    pushFollow(FOLLOW_rule__ConnectionInstance__CompleteAssignment_11_in_rule__ConnectionInstance__Group__11__Impl8543);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4252:1: rule__ConnectionInstance__Group__12 : rule__ConnectionInstance__Group__12__Impl rule__ConnectionInstance__Group__13 ;
    public final void rule__ConnectionInstance__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4256:1: ( rule__ConnectionInstance__Group__12__Impl rule__ConnectionInstance__Group__13 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4257:2: rule__ConnectionInstance__Group__12__Impl rule__ConnectionInstance__Group__13
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__12__Impl_in_rule__ConnectionInstance__Group__128574);
            rule__ConnectionInstance__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__13_in_rule__ConnectionInstance__Group__128577);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4264:1: rule__ConnectionInstance__Group__12__Impl : ( ( rule__ConnectionInstance__BidirectionalAssignment_12 )? ) ;
    public final void rule__ConnectionInstance__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4268:1: ( ( ( rule__ConnectionInstance__BidirectionalAssignment_12 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4269:1: ( ( rule__ConnectionInstance__BidirectionalAssignment_12 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4269:1: ( ( rule__ConnectionInstance__BidirectionalAssignment_12 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4270:1: ( rule__ConnectionInstance__BidirectionalAssignment_12 )?
            {
             before(grammarAccess.getConnectionInstanceAccess().getBidirectionalAssignment_12()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4271:1: ( rule__ConnectionInstance__BidirectionalAssignment_12 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==60) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4271:2: rule__ConnectionInstance__BidirectionalAssignment_12
                    {
                    pushFollow(FOLLOW_rule__ConnectionInstance__BidirectionalAssignment_12_in_rule__ConnectionInstance__Group__12__Impl8604);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4281:1: rule__ConnectionInstance__Group__13 : rule__ConnectionInstance__Group__13__Impl ;
    public final void rule__ConnectionInstance__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4285:1: ( rule__ConnectionInstance__Group__13__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4286:2: rule__ConnectionInstance__Group__13__Impl
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__13__Impl_in_rule__ConnectionInstance__Group__138635);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4292:1: rule__ConnectionInstance__Group__13__Impl : ( 'end' ) ;
    public final void rule__ConnectionInstance__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4296:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4297:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4297:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4298:1: 'end'
            {
             before(grammarAccess.getConnectionInstanceAccess().getEndKeyword_13()); 
            match(input,41,FOLLOW_41_in_rule__ConnectionInstance__Group__13__Impl8663); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4339:1: rule__ConnectionInstance__Group_9__0 : rule__ConnectionInstance__Group_9__0__Impl rule__ConnectionInstance__Group_9__1 ;
    public final void rule__ConnectionInstance__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4343:1: ( rule__ConnectionInstance__Group_9__0__Impl rule__ConnectionInstance__Group_9__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4344:2: rule__ConnectionInstance__Group_9__0__Impl rule__ConnectionInstance__Group_9__1
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group_9__0__Impl_in_rule__ConnectionInstance__Group_9__08722);
            rule__ConnectionInstance__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group_9__1_in_rule__ConnectionInstance__Group_9__08725);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4351:1: rule__ConnectionInstance__Group_9__0__Impl : ( 'in' ) ;
    public final void rule__ConnectionInstance__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4355:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4356:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4356:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4357:1: 'in'
            {
             before(grammarAccess.getConnectionInstanceAccess().getInKeyword_9_0()); 
            match(input,29,FOLLOW_29_in_rule__ConnectionInstance__Group_9__0__Impl8753); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4370:1: rule__ConnectionInstance__Group_9__1 : rule__ConnectionInstance__Group_9__1__Impl rule__ConnectionInstance__Group_9__2 ;
    public final void rule__ConnectionInstance__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4374:1: ( rule__ConnectionInstance__Group_9__1__Impl rule__ConnectionInstance__Group_9__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4375:2: rule__ConnectionInstance__Group_9__1__Impl rule__ConnectionInstance__Group_9__2
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group_9__1__Impl_in_rule__ConnectionInstance__Group_9__18784);
            rule__ConnectionInstance__Group_9__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group_9__2_in_rule__ConnectionInstance__Group_9__18787);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4382:1: rule__ConnectionInstance__Group_9__1__Impl : ( 'som' ) ;
    public final void rule__ConnectionInstance__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4386:1: ( ( 'som' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4387:1: ( 'som' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4387:1: ( 'som' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4388:1: 'som'
            {
             before(grammarAccess.getConnectionInstanceAccess().getSomKeyword_9_1()); 
            match(input,50,FOLLOW_50_in_rule__ConnectionInstance__Group_9__1__Impl8815); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4401:1: rule__ConnectionInstance__Group_9__2 : rule__ConnectionInstance__Group_9__2__Impl ;
    public final void rule__ConnectionInstance__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4405:1: ( rule__ConnectionInstance__Group_9__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4406:2: rule__ConnectionInstance__Group_9__2__Impl
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group_9__2__Impl_in_rule__ConnectionInstance__Group_9__28846);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4412:1: rule__ConnectionInstance__Group_9__2__Impl : ( ( rule__ConnectionInstance__InSystemOperationModeAssignment_9_2 ) ) ;
    public final void rule__ConnectionInstance__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4416:1: ( ( ( rule__ConnectionInstance__InSystemOperationModeAssignment_9_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4417:1: ( ( rule__ConnectionInstance__InSystemOperationModeAssignment_9_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4417:1: ( ( rule__ConnectionInstance__InSystemOperationModeAssignment_9_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4418:1: ( rule__ConnectionInstance__InSystemOperationModeAssignment_9_2 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeAssignment_9_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4419:1: ( rule__ConnectionInstance__InSystemOperationModeAssignment_9_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4419:2: rule__ConnectionInstance__InSystemOperationModeAssignment_9_2
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__InSystemOperationModeAssignment_9_2_in_rule__ConnectionInstance__Group_9__2__Impl8873);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4435:1: rule__ConnectionInstance__Group_10__0 : rule__ConnectionInstance__Group_10__0__Impl rule__ConnectionInstance__Group_10__1 ;
    public final void rule__ConnectionInstance__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4439:1: ( rule__ConnectionInstance__Group_10__0__Impl rule__ConnectionInstance__Group_10__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4440:2: rule__ConnectionInstance__Group_10__0__Impl rule__ConnectionInstance__Group_10__1
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group_10__0__Impl_in_rule__ConnectionInstance__Group_10__08909);
            rule__ConnectionInstance__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group_10__1_in_rule__ConnectionInstance__Group_10__08912);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4447:1: rule__ConnectionInstance__Group_10__0__Impl : ( 'in' ) ;
    public final void rule__ConnectionInstance__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4451:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4452:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4452:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4453:1: 'in'
            {
             before(grammarAccess.getConnectionInstanceAccess().getInKeyword_10_0()); 
            match(input,29,FOLLOW_29_in_rule__ConnectionInstance__Group_10__0__Impl8940); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4466:1: rule__ConnectionInstance__Group_10__1 : rule__ConnectionInstance__Group_10__1__Impl rule__ConnectionInstance__Group_10__2 ;
    public final void rule__ConnectionInstance__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4470:1: ( rule__ConnectionInstance__Group_10__1__Impl rule__ConnectionInstance__Group_10__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4471:2: rule__ConnectionInstance__Group_10__1__Impl rule__ConnectionInstance__Group_10__2
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group_10__1__Impl_in_rule__ConnectionInstance__Group_10__18971);
            rule__ConnectionInstance__Group_10__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group_10__2_in_rule__ConnectionInstance__Group_10__18974);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4478:1: rule__ConnectionInstance__Group_10__1__Impl : ( 'transition' ) ;
    public final void rule__ConnectionInstance__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4482:1: ( ( 'transition' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4483:1: ( 'transition' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4483:1: ( 'transition' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4484:1: 'transition'
            {
             before(grammarAccess.getConnectionInstanceAccess().getTransitionKeyword_10_1()); 
            match(input,45,FOLLOW_45_in_rule__ConnectionInstance__Group_10__1__Impl9002); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4497:1: rule__ConnectionInstance__Group_10__2 : rule__ConnectionInstance__Group_10__2__Impl ;
    public final void rule__ConnectionInstance__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4501:1: ( rule__ConnectionInstance__Group_10__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4502:2: rule__ConnectionInstance__Group_10__2__Impl
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group_10__2__Impl_in_rule__ConnectionInstance__Group_10__29033);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4508:1: rule__ConnectionInstance__Group_10__2__Impl : ( ( rule__ConnectionInstance__InModeTransitionAssignment_10_2 ) ) ;
    public final void rule__ConnectionInstance__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4512:1: ( ( ( rule__ConnectionInstance__InModeTransitionAssignment_10_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4513:1: ( ( rule__ConnectionInstance__InModeTransitionAssignment_10_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4513:1: ( ( rule__ConnectionInstance__InModeTransitionAssignment_10_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4514:1: ( rule__ConnectionInstance__InModeTransitionAssignment_10_2 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getInModeTransitionAssignment_10_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4515:1: ( rule__ConnectionInstance__InModeTransitionAssignment_10_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4515:2: rule__ConnectionInstance__InModeTransitionAssignment_10_2
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__InModeTransitionAssignment_10_2_in_rule__ConnectionInstance__Group_10__2__Impl9060);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4531:1: rule__ConnectionReference__Group__0 : rule__ConnectionReference__Group__0__Impl rule__ConnectionReference__Group__1 ;
    public final void rule__ConnectionReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4535:1: ( rule__ConnectionReference__Group__0__Impl rule__ConnectionReference__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4536:2: rule__ConnectionReference__Group__0__Impl rule__ConnectionReference__Group__1
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__0__Impl_in_rule__ConnectionReference__Group__09096);
            rule__ConnectionReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__1_in_rule__ConnectionReference__Group__09099);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4543:1: rule__ConnectionReference__Group__0__Impl : ( 'of' ) ;
    public final void rule__ConnectionReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4547:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4548:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4548:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4549:1: 'of'
            {
             before(grammarAccess.getConnectionReferenceAccess().getOfKeyword_0()); 
            match(input,40,FOLLOW_40_in_rule__ConnectionReference__Group__0__Impl9127); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4562:1: rule__ConnectionReference__Group__1 : rule__ConnectionReference__Group__1__Impl rule__ConnectionReference__Group__2 ;
    public final void rule__ConnectionReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4566:1: ( rule__ConnectionReference__Group__1__Impl rule__ConnectionReference__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4567:2: rule__ConnectionReference__Group__1__Impl rule__ConnectionReference__Group__2
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__1__Impl_in_rule__ConnectionReference__Group__19158);
            rule__ConnectionReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__2_in_rule__ConnectionReference__Group__19161);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4574:1: rule__ConnectionReference__Group__1__Impl : ( ( rule__ConnectionReference__ConnectionAssignment_1 ) ) ;
    public final void rule__ConnectionReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4578:1: ( ( ( rule__ConnectionReference__ConnectionAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4579:1: ( ( rule__ConnectionReference__ConnectionAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4579:1: ( ( rule__ConnectionReference__ConnectionAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4580:1: ( rule__ConnectionReference__ConnectionAssignment_1 )
            {
             before(grammarAccess.getConnectionReferenceAccess().getConnectionAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4581:1: ( rule__ConnectionReference__ConnectionAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4581:2: rule__ConnectionReference__ConnectionAssignment_1
            {
            pushFollow(FOLLOW_rule__ConnectionReference__ConnectionAssignment_1_in_rule__ConnectionReference__Group__1__Impl9188);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4591:1: rule__ConnectionReference__Group__2 : rule__ConnectionReference__Group__2__Impl rule__ConnectionReference__Group__3 ;
    public final void rule__ConnectionReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4595:1: ( rule__ConnectionReference__Group__2__Impl rule__ConnectionReference__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4596:2: rule__ConnectionReference__Group__2__Impl rule__ConnectionReference__Group__3
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__2__Impl_in_rule__ConnectionReference__Group__29218);
            rule__ConnectionReference__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__3_in_rule__ConnectionReference__Group__29221);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4603:1: rule__ConnectionReference__Group__2__Impl : ( 'src' ) ;
    public final void rule__ConnectionReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4607:1: ( ( 'src' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4608:1: ( 'src' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4608:1: ( 'src' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4609:1: 'src'
            {
             before(grammarAccess.getConnectionReferenceAccess().getSrcKeyword_2()); 
            match(input,46,FOLLOW_46_in_rule__ConnectionReference__Group__2__Impl9249); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4622:1: rule__ConnectionReference__Group__3 : rule__ConnectionReference__Group__3__Impl rule__ConnectionReference__Group__4 ;
    public final void rule__ConnectionReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4626:1: ( rule__ConnectionReference__Group__3__Impl rule__ConnectionReference__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4627:2: rule__ConnectionReference__Group__3__Impl rule__ConnectionReference__Group__4
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__3__Impl_in_rule__ConnectionReference__Group__39280);
            rule__ConnectionReference__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__4_in_rule__ConnectionReference__Group__39283);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4634:1: rule__ConnectionReference__Group__3__Impl : ( ( rule__ConnectionReference__SourceAssignment_3 ) ) ;
    public final void rule__ConnectionReference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4638:1: ( ( ( rule__ConnectionReference__SourceAssignment_3 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4639:1: ( ( rule__ConnectionReference__SourceAssignment_3 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4639:1: ( ( rule__ConnectionReference__SourceAssignment_3 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4640:1: ( rule__ConnectionReference__SourceAssignment_3 )
            {
             before(grammarAccess.getConnectionReferenceAccess().getSourceAssignment_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4641:1: ( rule__ConnectionReference__SourceAssignment_3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4641:2: rule__ConnectionReference__SourceAssignment_3
            {
            pushFollow(FOLLOW_rule__ConnectionReference__SourceAssignment_3_in_rule__ConnectionReference__Group__3__Impl9310);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4651:1: rule__ConnectionReference__Group__4 : rule__ConnectionReference__Group__4__Impl rule__ConnectionReference__Group__5 ;
    public final void rule__ConnectionReference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4655:1: ( rule__ConnectionReference__Group__4__Impl rule__ConnectionReference__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4656:2: rule__ConnectionReference__Group__4__Impl rule__ConnectionReference__Group__5
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__4__Impl_in_rule__ConnectionReference__Group__49340);
            rule__ConnectionReference__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__5_in_rule__ConnectionReference__Group__49343);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4663:1: rule__ConnectionReference__Group__4__Impl : ( 'dst' ) ;
    public final void rule__ConnectionReference__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4667:1: ( ( 'dst' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4668:1: ( 'dst' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4668:1: ( 'dst' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4669:1: 'dst'
            {
             before(grammarAccess.getConnectionReferenceAccess().getDstKeyword_4()); 
            match(input,47,FOLLOW_47_in_rule__ConnectionReference__Group__4__Impl9371); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4682:1: rule__ConnectionReference__Group__5 : rule__ConnectionReference__Group__5__Impl rule__ConnectionReference__Group__6 ;
    public final void rule__ConnectionReference__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4686:1: ( rule__ConnectionReference__Group__5__Impl rule__ConnectionReference__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4687:2: rule__ConnectionReference__Group__5__Impl rule__ConnectionReference__Group__6
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__5__Impl_in_rule__ConnectionReference__Group__59402);
            rule__ConnectionReference__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__6_in_rule__ConnectionReference__Group__59405);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4694:1: rule__ConnectionReference__Group__5__Impl : ( ( rule__ConnectionReference__DestinationAssignment_5 ) ) ;
    public final void rule__ConnectionReference__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4698:1: ( ( ( rule__ConnectionReference__DestinationAssignment_5 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4699:1: ( ( rule__ConnectionReference__DestinationAssignment_5 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4699:1: ( ( rule__ConnectionReference__DestinationAssignment_5 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4700:1: ( rule__ConnectionReference__DestinationAssignment_5 )
            {
             before(grammarAccess.getConnectionReferenceAccess().getDestinationAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4701:1: ( rule__ConnectionReference__DestinationAssignment_5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4701:2: rule__ConnectionReference__DestinationAssignment_5
            {
            pushFollow(FOLLOW_rule__ConnectionReference__DestinationAssignment_5_in_rule__ConnectionReference__Group__5__Impl9432);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4711:1: rule__ConnectionReference__Group__6 : rule__ConnectionReference__Group__6__Impl rule__ConnectionReference__Group__7 ;
    public final void rule__ConnectionReference__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4715:1: ( rule__ConnectionReference__Group__6__Impl rule__ConnectionReference__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4716:2: rule__ConnectionReference__Group__6__Impl rule__ConnectionReference__Group__7
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__6__Impl_in_rule__ConnectionReference__Group__69462);
            rule__ConnectionReference__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__7_in_rule__ConnectionReference__Group__69465);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4723:1: rule__ConnectionReference__Group__6__Impl : ( 'context' ) ;
    public final void rule__ConnectionReference__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4727:1: ( ( 'context' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4728:1: ( 'context' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4728:1: ( 'context' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4729:1: 'context'
            {
             before(grammarAccess.getConnectionReferenceAccess().getContextKeyword_6()); 
            match(input,52,FOLLOW_52_in_rule__ConnectionReference__Group__6__Impl9493); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4742:1: rule__ConnectionReference__Group__7 : rule__ConnectionReference__Group__7__Impl ;
    public final void rule__ConnectionReference__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4746:1: ( rule__ConnectionReference__Group__7__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4747:2: rule__ConnectionReference__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__7__Impl_in_rule__ConnectionReference__Group__79524);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4753:1: rule__ConnectionReference__Group__7__Impl : ( ( rule__ConnectionReference__ContextAssignment_7 ) ) ;
    public final void rule__ConnectionReference__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4757:1: ( ( ( rule__ConnectionReference__ContextAssignment_7 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4758:1: ( ( rule__ConnectionReference__ContextAssignment_7 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4758:1: ( ( rule__ConnectionReference__ContextAssignment_7 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4759:1: ( rule__ConnectionReference__ContextAssignment_7 )
            {
             before(grammarAccess.getConnectionReferenceAccess().getContextAssignment_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4760:1: ( rule__ConnectionReference__ContextAssignment_7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4760:2: rule__ConnectionReference__ContextAssignment_7
            {
            pushFollow(FOLLOW_rule__ConnectionReference__ContextAssignment_7_in_rule__ConnectionReference__Group__7__Impl9551);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4786:1: rule__ComponentCategory__Group_8__0 : rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1 ;
    public final void rule__ComponentCategory__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4790:1: ( rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4791:2: rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_8__0__Impl_in_rule__ComponentCategory__Group_8__09597);
            rule__ComponentCategory__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_8__1_in_rule__ComponentCategory__Group_8__09600);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4798:1: rule__ComponentCategory__Group_8__0__Impl : ( 'subprogram' ) ;
    public final void rule__ComponentCategory__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4802:1: ( ( 'subprogram' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4803:1: ( 'subprogram' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4803:1: ( 'subprogram' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4804:1: 'subprogram'
            {
             before(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
            match(input,16,FOLLOW_16_in_rule__ComponentCategory__Group_8__0__Impl9628); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4817:1: rule__ComponentCategory__Group_8__1 : rule__ComponentCategory__Group_8__1__Impl ;
    public final void rule__ComponentCategory__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4821:1: ( rule__ComponentCategory__Group_8__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4822:2: rule__ComponentCategory__Group_8__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_8__1__Impl_in_rule__ComponentCategory__Group_8__19659);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4828:1: rule__ComponentCategory__Group_8__1__Impl : ( 'group' ) ;
    public final void rule__ComponentCategory__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4832:1: ( ( 'group' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4833:1: ( 'group' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4833:1: ( 'group' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4834:1: 'group'
            {
             before(grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
            match(input,53,FOLLOW_53_in_rule__ComponentCategory__Group_8__1__Impl9687); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4851:1: rule__ComponentCategory__Group_10__0 : rule__ComponentCategory__Group_10__0__Impl rule__ComponentCategory__Group_10__1 ;
    public final void rule__ComponentCategory__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4855:1: ( rule__ComponentCategory__Group_10__0__Impl rule__ComponentCategory__Group_10__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4856:2: rule__ComponentCategory__Group_10__0__Impl rule__ComponentCategory__Group_10__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_10__0__Impl_in_rule__ComponentCategory__Group_10__09722);
            rule__ComponentCategory__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_10__1_in_rule__ComponentCategory__Group_10__09725);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4863:1: rule__ComponentCategory__Group_10__0__Impl : ( 'thread' ) ;
    public final void rule__ComponentCategory__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4867:1: ( ( 'thread' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4868:1: ( 'thread' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4868:1: ( 'thread' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4869:1: 'thread'
            {
             before(grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); 
            match(input,18,FOLLOW_18_in_rule__ComponentCategory__Group_10__0__Impl9753); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4882:1: rule__ComponentCategory__Group_10__1 : rule__ComponentCategory__Group_10__1__Impl ;
    public final void rule__ComponentCategory__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4886:1: ( rule__ComponentCategory__Group_10__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4887:2: rule__ComponentCategory__Group_10__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_10__1__Impl_in_rule__ComponentCategory__Group_10__19784);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4893:1: rule__ComponentCategory__Group_10__1__Impl : ( 'group' ) ;
    public final void rule__ComponentCategory__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4897:1: ( ( 'group' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4898:1: ( 'group' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4898:1: ( 'group' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4899:1: 'group'
            {
             before(grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); 
            match(input,53,FOLLOW_53_in_rule__ComponentCategory__Group_10__1__Impl9812); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4916:1: rule__ComponentCategory__Group_12__0 : rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1 ;
    public final void rule__ComponentCategory__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4920:1: ( rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4921:2: rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_12__0__Impl_in_rule__ComponentCategory__Group_12__09847);
            rule__ComponentCategory__Group_12__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_12__1_in_rule__ComponentCategory__Group_12__09850);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4928:1: rule__ComponentCategory__Group_12__0__Impl : ( 'virtual' ) ;
    public final void rule__ComponentCategory__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4932:1: ( ( 'virtual' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4933:1: ( 'virtual' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4933:1: ( 'virtual' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4934:1: 'virtual'
            {
             before(grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
            match(input,54,FOLLOW_54_in_rule__ComponentCategory__Group_12__0__Impl9878); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4947:1: rule__ComponentCategory__Group_12__1 : rule__ComponentCategory__Group_12__1__Impl ;
    public final void rule__ComponentCategory__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4951:1: ( rule__ComponentCategory__Group_12__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4952:2: rule__ComponentCategory__Group_12__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_12__1__Impl_in_rule__ComponentCategory__Group_12__19909);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4958:1: rule__ComponentCategory__Group_12__1__Impl : ( 'bus' ) ;
    public final void rule__ComponentCategory__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4962:1: ( ( 'bus' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4963:1: ( 'bus' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4963:1: ( 'bus' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4964:1: 'bus'
            {
             before(grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
            match(input,10,FOLLOW_10_in_rule__ComponentCategory__Group_12__1__Impl9937); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4981:1: rule__ComponentCategory__Group_13__0 : rule__ComponentCategory__Group_13__0__Impl rule__ComponentCategory__Group_13__1 ;
    public final void rule__ComponentCategory__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4985:1: ( rule__ComponentCategory__Group_13__0__Impl rule__ComponentCategory__Group_13__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4986:2: rule__ComponentCategory__Group_13__0__Impl rule__ComponentCategory__Group_13__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_13__0__Impl_in_rule__ComponentCategory__Group_13__09972);
            rule__ComponentCategory__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_13__1_in_rule__ComponentCategory__Group_13__09975);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4993:1: rule__ComponentCategory__Group_13__0__Impl : ( 'virtual' ) ;
    public final void rule__ComponentCategory__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4997:1: ( ( 'virtual' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4998:1: ( 'virtual' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4998:1: ( 'virtual' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4999:1: 'virtual'
            {
             before(grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); 
            match(input,54,FOLLOW_54_in_rule__ComponentCategory__Group_13__0__Impl10003); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5012:1: rule__ComponentCategory__Group_13__1 : rule__ComponentCategory__Group_13__1__Impl ;
    public final void rule__ComponentCategory__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5016:1: ( rule__ComponentCategory__Group_13__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5017:2: rule__ComponentCategory__Group_13__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_13__1__Impl_in_rule__ComponentCategory__Group_13__110034);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5023:1: rule__ComponentCategory__Group_13__1__Impl : ( 'processor' ) ;
    public final void rule__ComponentCategory__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5027:1: ( ( 'processor' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5028:1: ( 'processor' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5028:1: ( 'processor' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5029:1: 'processor'
            {
             before(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_13_1()); 
            match(input,15,FOLLOW_15_in_rule__ComponentCategory__Group_13__1__Impl10062); 
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


    // $ANTLR start "rule__FQCREF__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5046:1: rule__FQCREF__Group__0 : rule__FQCREF__Group__0__Impl rule__FQCREF__Group__1 ;
    public final void rule__FQCREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5050:1: ( rule__FQCREF__Group__0__Impl rule__FQCREF__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5051:2: rule__FQCREF__Group__0__Impl rule__FQCREF__Group__1
            {
            pushFollow(FOLLOW_rule__FQCREF__Group__0__Impl_in_rule__FQCREF__Group__010097);
            rule__FQCREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQCREF__Group__1_in_rule__FQCREF__Group__010100);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5058:1: rule__FQCREF__Group__0__Impl : ( ( ( rule__FQCREF__Group_0__0 ) ) ( ( rule__FQCREF__Group_0__0 )* ) ) ;
    public final void rule__FQCREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5062:1: ( ( ( ( rule__FQCREF__Group_0__0 ) ) ( ( rule__FQCREF__Group_0__0 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5063:1: ( ( ( rule__FQCREF__Group_0__0 ) ) ( ( rule__FQCREF__Group_0__0 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5063:1: ( ( ( rule__FQCREF__Group_0__0 ) ) ( ( rule__FQCREF__Group_0__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5064:1: ( ( rule__FQCREF__Group_0__0 ) ) ( ( rule__FQCREF__Group_0__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5064:1: ( ( rule__FQCREF__Group_0__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5065:1: ( rule__FQCREF__Group_0__0 )
            {
             before(grammarAccess.getFQCREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5066:1: ( rule__FQCREF__Group_0__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5066:2: rule__FQCREF__Group_0__0
            {
            pushFollow(FOLLOW_rule__FQCREF__Group_0__0_in_rule__FQCREF__Group__0__Impl10129);
            rule__FQCREF__Group_0__0();

            state._fsp--;


            }

             after(grammarAccess.getFQCREFAccess().getGroup_0()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5069:1: ( ( rule__FQCREF__Group_0__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5070:1: ( rule__FQCREF__Group_0__0 )*
            {
             before(grammarAccess.getFQCREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5071:1: ( rule__FQCREF__Group_0__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID) ) {
                    int LA30_1 = input.LA(2);

                    if ( (LA30_1==55) ) {
                        alt30=1;
                    }


                }


                switch (alt30) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5071:2: rule__FQCREF__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__FQCREF__Group_0__0_in_rule__FQCREF__Group__0__Impl10141);
            	    rule__FQCREF__Group_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5082:1: rule__FQCREF__Group__1 : rule__FQCREF__Group__1__Impl rule__FQCREF__Group__2 ;
    public final void rule__FQCREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5086:1: ( rule__FQCREF__Group__1__Impl rule__FQCREF__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5087:2: rule__FQCREF__Group__1__Impl rule__FQCREF__Group__2
            {
            pushFollow(FOLLOW_rule__FQCREF__Group__1__Impl_in_rule__FQCREF__Group__110174);
            rule__FQCREF__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQCREF__Group__2_in_rule__FQCREF__Group__110177);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5094:1: rule__FQCREF__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__FQCREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5098:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5099:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5099:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5100:1: RULE_ID
            {
             before(grammarAccess.getFQCREFAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQCREF__Group__1__Impl10204); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5111:1: rule__FQCREF__Group__2 : rule__FQCREF__Group__2__Impl ;
    public final void rule__FQCREF__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5115:1: ( rule__FQCREF__Group__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5116:2: rule__FQCREF__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__FQCREF__Group__2__Impl_in_rule__FQCREF__Group__210233);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5122:1: rule__FQCREF__Group__2__Impl : ( ( rule__FQCREF__Group_2__0 )? ) ;
    public final void rule__FQCREF__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5126:1: ( ( ( rule__FQCREF__Group_2__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5127:1: ( ( rule__FQCREF__Group_2__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5127:1: ( ( rule__FQCREF__Group_2__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5128:1: ( rule__FQCREF__Group_2__0 )?
            {
             before(grammarAccess.getFQCREFAccess().getGroup_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5129:1: ( rule__FQCREF__Group_2__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==56) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5129:2: rule__FQCREF__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__FQCREF__Group_2__0_in_rule__FQCREF__Group__2__Impl10260);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5145:1: rule__FQCREF__Group_0__0 : rule__FQCREF__Group_0__0__Impl rule__FQCREF__Group_0__1 ;
    public final void rule__FQCREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5149:1: ( rule__FQCREF__Group_0__0__Impl rule__FQCREF__Group_0__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5150:2: rule__FQCREF__Group_0__0__Impl rule__FQCREF__Group_0__1
            {
            pushFollow(FOLLOW_rule__FQCREF__Group_0__0__Impl_in_rule__FQCREF__Group_0__010297);
            rule__FQCREF__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQCREF__Group_0__1_in_rule__FQCREF__Group_0__010300);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5157:1: rule__FQCREF__Group_0__0__Impl : ( RULE_ID ) ;
    public final void rule__FQCREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5161:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5162:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5162:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5163:1: RULE_ID
            {
             before(grammarAccess.getFQCREFAccess().getIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQCREF__Group_0__0__Impl10327); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5174:1: rule__FQCREF__Group_0__1 : rule__FQCREF__Group_0__1__Impl ;
    public final void rule__FQCREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5178:1: ( rule__FQCREF__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5179:2: rule__FQCREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__FQCREF__Group_0__1__Impl_in_rule__FQCREF__Group_0__110356);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5185:1: rule__FQCREF__Group_0__1__Impl : ( '::' ) ;
    public final void rule__FQCREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5189:1: ( ( '::' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5190:1: ( '::' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5190:1: ( '::' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5191:1: '::'
            {
             before(grammarAccess.getFQCREFAccess().getColonColonKeyword_0_1()); 
            match(input,55,FOLLOW_55_in_rule__FQCREF__Group_0__1__Impl10384); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5208:1: rule__FQCREF__Group_2__0 : rule__FQCREF__Group_2__0__Impl rule__FQCREF__Group_2__1 ;
    public final void rule__FQCREF__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5212:1: ( rule__FQCREF__Group_2__0__Impl rule__FQCREF__Group_2__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5213:2: rule__FQCREF__Group_2__0__Impl rule__FQCREF__Group_2__1
            {
            pushFollow(FOLLOW_rule__FQCREF__Group_2__0__Impl_in_rule__FQCREF__Group_2__010419);
            rule__FQCREF__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQCREF__Group_2__1_in_rule__FQCREF__Group_2__010422);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5220:1: rule__FQCREF__Group_2__0__Impl : ( '.' ) ;
    public final void rule__FQCREF__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5224:1: ( ( '.' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5225:1: ( '.' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5225:1: ( '.' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5226:1: '.'
            {
             before(grammarAccess.getFQCREFAccess().getFullStopKeyword_2_0()); 
            match(input,56,FOLLOW_56_in_rule__FQCREF__Group_2__0__Impl10450); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5239:1: rule__FQCREF__Group_2__1 : rule__FQCREF__Group_2__1__Impl ;
    public final void rule__FQCREF__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5243:1: ( rule__FQCREF__Group_2__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5244:2: rule__FQCREF__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__FQCREF__Group_2__1__Impl_in_rule__FQCREF__Group_2__110481);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5250:1: rule__FQCREF__Group_2__1__Impl : ( RULE_ID ) ;
    public final void rule__FQCREF__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5254:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5255:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5255:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5256:1: RULE_ID
            {
             before(grammarAccess.getFQCREFAccess().getIDTerminalRuleCall_2_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQCREF__Group_2__1__Impl10508); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5271:1: rule__INSTANCEREF__Group__0 : rule__INSTANCEREF__Group__0__Impl rule__INSTANCEREF__Group__1 ;
    public final void rule__INSTANCEREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5275:1: ( rule__INSTANCEREF__Group__0__Impl rule__INSTANCEREF__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5276:2: rule__INSTANCEREF__Group__0__Impl rule__INSTANCEREF__Group__1
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group__0__Impl_in_rule__INSTANCEREF__Group__010541);
            rule__INSTANCEREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREF__Group__1_in_rule__INSTANCEREF__Group__010544);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5283:1: rule__INSTANCEREF__Group__0__Impl : ( ( rule__INSTANCEREF__Group_0__0 )* ) ;
    public final void rule__INSTANCEREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5287:1: ( ( ( rule__INSTANCEREF__Group_0__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5288:1: ( ( rule__INSTANCEREF__Group_0__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5288:1: ( ( rule__INSTANCEREF__Group_0__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5289:1: ( rule__INSTANCEREF__Group_0__0 )*
            {
             before(grammarAccess.getINSTANCEREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5290:1: ( rule__INSTANCEREF__Group_0__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID) ) {
                    int LA32_1 = input.LA(2);

                    if ( (LA32_1==56) ) {
                        alt32=1;
                    }


                }


                switch (alt32) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5290:2: rule__INSTANCEREF__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__INSTANCEREF__Group_0__0_in_rule__INSTANCEREF__Group__0__Impl10571);
            	    rule__INSTANCEREF__Group_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5300:1: rule__INSTANCEREF__Group__1 : rule__INSTANCEREF__Group__1__Impl ;
    public final void rule__INSTANCEREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5304:1: ( rule__INSTANCEREF__Group__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5305:2: rule__INSTANCEREF__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group__1__Impl_in_rule__INSTANCEREF__Group__110602);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5311:1: rule__INSTANCEREF__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__INSTANCEREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5315:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5316:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5316:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5317:1: RULE_ID
            {
             before(grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__INSTANCEREF__Group__1__Impl10629); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5332:1: rule__INSTANCEREF__Group_0__0 : rule__INSTANCEREF__Group_0__0__Impl rule__INSTANCEREF__Group_0__1 ;
    public final void rule__INSTANCEREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5336:1: ( rule__INSTANCEREF__Group_0__0__Impl rule__INSTANCEREF__Group_0__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5337:2: rule__INSTANCEREF__Group_0__0__Impl rule__INSTANCEREF__Group_0__1
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_0__0__Impl_in_rule__INSTANCEREF__Group_0__010662);
            rule__INSTANCEREF__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREF__Group_0__1_in_rule__INSTANCEREF__Group_0__010665);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5344:1: rule__INSTANCEREF__Group_0__0__Impl : ( RULE_ID ) ;
    public final void rule__INSTANCEREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5348:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5349:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5349:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5350:1: RULE_ID
            {
             before(grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__INSTANCEREF__Group_0__0__Impl10692); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5361:1: rule__INSTANCEREF__Group_0__1 : rule__INSTANCEREF__Group_0__1__Impl ;
    public final void rule__INSTANCEREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5365:1: ( rule__INSTANCEREF__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5366:2: rule__INSTANCEREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_0__1__Impl_in_rule__INSTANCEREF__Group_0__110721);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5372:1: rule__INSTANCEREF__Group_0__1__Impl : ( '.' ) ;
    public final void rule__INSTANCEREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5376:1: ( ( '.' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5377:1: ( '.' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5377:1: ( '.' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5378:1: '.'
            {
             before(grammarAccess.getINSTANCEREFAccess().getFullStopKeyword_0_1()); 
            match(input,56,FOLLOW_56_in_rule__INSTANCEREF__Group_0__1__Impl10749); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5395:1: rule__SOMID__Group__0 : rule__SOMID__Group__0__Impl rule__SOMID__Group__1 ;
    public final void rule__SOMID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5399:1: ( rule__SOMID__Group__0__Impl rule__SOMID__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5400:2: rule__SOMID__Group__0__Impl rule__SOMID__Group__1
            {
            pushFollow(FOLLOW_rule__SOMID__Group__0__Impl_in_rule__SOMID__Group__010784);
            rule__SOMID__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SOMID__Group__1_in_rule__SOMID__Group__010787);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5407:1: rule__SOMID__Group__0__Impl : ( ( rule__SOMID__Group_0__0 )* ) ;
    public final void rule__SOMID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5411:1: ( ( ( rule__SOMID__Group_0__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5412:1: ( ( rule__SOMID__Group_0__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5412:1: ( ( rule__SOMID__Group_0__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5413:1: ( rule__SOMID__Group_0__0 )*
            {
             before(grammarAccess.getSOMIDAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5414:1: ( rule__SOMID__Group_0__0 )*
            loop33:
            do {
                int alt33=2;
                alt33 = dfa33.predict(input);
                switch (alt33) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5414:2: rule__SOMID__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__SOMID__Group_0__0_in_rule__SOMID__Group__0__Impl10814);
            	    rule__SOMID__Group_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5424:1: rule__SOMID__Group__1 : rule__SOMID__Group__1__Impl ;
    public final void rule__SOMID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5428:1: ( rule__SOMID__Group__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5429:2: rule__SOMID__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SOMID__Group__1__Impl_in_rule__SOMID__Group__110845);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5435:1: rule__SOMID__Group__1__Impl : ( ruleINSTANCEREF ) ;
    public final void rule__SOMID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5439:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5440:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5440:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5441:1: ruleINSTANCEREF
            {
             before(grammarAccess.getSOMIDAccess().getINSTANCEREFParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__SOMID__Group__1__Impl10872);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5456:1: rule__SOMID__Group_0__0 : rule__SOMID__Group_0__0__Impl rule__SOMID__Group_0__1 ;
    public final void rule__SOMID__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5460:1: ( rule__SOMID__Group_0__0__Impl rule__SOMID__Group_0__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5461:2: rule__SOMID__Group_0__0__Impl rule__SOMID__Group_0__1
            {
            pushFollow(FOLLOW_rule__SOMID__Group_0__0__Impl_in_rule__SOMID__Group_0__010905);
            rule__SOMID__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SOMID__Group_0__1_in_rule__SOMID__Group_0__010908);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5468:1: rule__SOMID__Group_0__0__Impl : ( ruleINSTANCEREF ) ;
    public final void rule__SOMID__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5472:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5473:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5473:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5474:1: ruleINSTANCEREF
            {
             before(grammarAccess.getSOMIDAccess().getINSTANCEREFParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__SOMID__Group_0__0__Impl10935);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5485:1: rule__SOMID__Group_0__1 : rule__SOMID__Group_0__1__Impl ;
    public final void rule__SOMID__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5489:1: ( rule__SOMID__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5490:2: rule__SOMID__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__SOMID__Group_0__1__Impl_in_rule__SOMID__Group_0__110964);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5496:1: rule__SOMID__Group_0__1__Impl : ( '#' ) ;
    public final void rule__SOMID__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5500:1: ( ( '#' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5501:1: ( '#' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5501:1: ( '#' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5502:1: '#'
            {
             before(grammarAccess.getSOMIDAccess().getNumberSignKeyword_0_1()); 
            match(input,57,FOLLOW_57_in_rule__SOMID__Group_0__1__Impl10992); 
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


    // $ANTLR start "rule__SystemInstance__CategoryAssignment_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5520:1: rule__SystemInstance__CategoryAssignment_0 : ( ruleComponentCategory ) ;
    public final void rule__SystemInstance__CategoryAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5524:1: ( ( ruleComponentCategory ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5525:1: ( ruleComponentCategory )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5525:1: ( ruleComponentCategory )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5526:1: ruleComponentCategory
            {
             before(grammarAccess.getSystemInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_rule__SystemInstance__CategoryAssignment_011032);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5535:1: rule__SystemInstance__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SystemInstance__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5539:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5540:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5540:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5541:1: RULE_ID
            {
             before(grammarAccess.getSystemInstanceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SystemInstance__NameAssignment_111063); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5550:1: rule__SystemInstance__ComponentImplementationAssignment_3 : ( ( ruleFQCREF ) ) ;
    public final void rule__SystemInstance__ComponentImplementationAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5554:1: ( ( ( ruleFQCREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5555:1: ( ( ruleFQCREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5555:1: ( ( ruleFQCREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5556:1: ( ruleFQCREF )
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationCrossReference_3_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5557:1: ( ruleFQCREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5558:1: ruleFQCREF
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationFQCREFParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_ruleFQCREF_in_rule__SystemInstance__ComponentImplementationAssignment_311098);
            ruleFQCREF();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationFQCREFParserRuleCall_3_0_1()); 

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


    // $ANTLR start "rule__SystemInstance__SystemOperationModeAssignment_5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5569:1: rule__SystemInstance__SystemOperationModeAssignment_5 : ( ruleSystemOperationMode ) ;
    public final void rule__SystemInstance__SystemOperationModeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5573:1: ( ( ruleSystemOperationMode ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5574:1: ( ruleSystemOperationMode )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5574:1: ( ruleSystemOperationMode )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5575:1: ruleSystemOperationMode
            {
             before(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleSystemOperationMode_in_rule__SystemInstance__SystemOperationModeAssignment_511133);
            ruleSystemOperationMode();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__SystemOperationModeAssignment_5"


    // $ANTLR start "rule__ComponentInstance__CategoryAssignment_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5584:1: rule__ComponentInstance__CategoryAssignment_0 : ( ruleComponentCategory ) ;
    public final void rule__ComponentInstance__CategoryAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5588:1: ( ( ruleComponentCategory ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5589:1: ( ruleComponentCategory )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5589:1: ( ruleComponentCategory )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5590:1: ruleComponentCategory
            {
             before(grammarAccess.getComponentInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_rule__ComponentInstance__CategoryAssignment_011164);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5599:1: rule__ComponentInstance__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ComponentInstance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5603:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5604:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5604:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5605:1: RULE_ID
            {
             before(grammarAccess.getComponentInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ComponentInstance__NameAssignment_211195); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5614:1: rule__ComponentInstance__IndexAssignment_3_1 : ( ruleINTVALUE ) ;
    public final void rule__ComponentInstance__IndexAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5618:1: ( ( ruleINTVALUE ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5619:1: ( ruleINTVALUE )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5619:1: ( ruleINTVALUE )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5620:1: ruleINTVALUE
            {
             before(grammarAccess.getComponentInstanceAccess().getIndexINTVALUEParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleINTVALUE_in_rule__ComponentInstance__IndexAssignment_3_111226);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5629:1: rule__ComponentInstance__SubcomponentAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__ComponentInstance__SubcomponentAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5633:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5634:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5634:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5635:1: ( RULE_ID )
            {
             before(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentCrossReference_5_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5636:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5637:1: RULE_ID
            {
             before(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ComponentInstance__SubcomponentAssignment_511261); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5648:1: rule__ComponentInstance__FeatureInstanceAssignment_6 : ( ruleFeatureInstance ) ;
    public final void rule__ComponentInstance__FeatureInstanceAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5652:1: ( ( ruleFeatureInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5653:1: ( ruleFeatureInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5653:1: ( ruleFeatureInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5654:1: ruleFeatureInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_rule__ComponentInstance__FeatureInstanceAssignment_611296);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5663:1: rule__ComponentInstance__ComponentInstanceAssignment_7 : ( ruleComponentInstance ) ;
    public final void rule__ComponentInstance__ComponentInstanceAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5667:1: ( ( ruleComponentInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5668:1: ( ruleComponentInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5668:1: ( ruleComponentInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5669:1: ruleComponentInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleComponentInstance_in_rule__ComponentInstance__ComponentInstanceAssignment_711327);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5678:1: rule__ComponentInstance__ModeInstanceAssignment_8 : ( ruleModeInstance ) ;
    public final void rule__ComponentInstance__ModeInstanceAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5682:1: ( ( ruleModeInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5683:1: ( ruleModeInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5683:1: ( ruleModeInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5684:1: ruleModeInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getModeInstanceModeInstanceParserRuleCall_8_0()); 
            pushFollow(FOLLOW_ruleModeInstance_in_rule__ComponentInstance__ModeInstanceAssignment_811358);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5693:1: rule__ComponentInstance__ModeTransitionInstanceAssignment_9 : ( ruleModeTransitionInstance ) ;
    public final void rule__ComponentInstance__ModeTransitionInstanceAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5697:1: ( ( ruleModeTransitionInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5698:1: ( ruleModeTransitionInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5698:1: ( ruleModeTransitionInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5699:1: ruleModeTransitionInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getModeTransitionInstanceModeTransitionInstanceParserRuleCall_9_0()); 
            pushFollow(FOLLOW_ruleModeTransitionInstance_in_rule__ComponentInstance__ModeTransitionInstanceAssignment_911389);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5708:1: rule__ComponentInstance__FlowSpecificationAssignment_10 : ( ruleFlowSpecInstance ) ;
    public final void rule__ComponentInstance__FlowSpecificationAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5712:1: ( ( ruleFlowSpecInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5713:1: ( ruleFlowSpecInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5713:1: ( ruleFlowSpecInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5714:1: ruleFlowSpecInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getFlowSpecificationFlowSpecInstanceParserRuleCall_10_0()); 
            pushFollow(FOLLOW_ruleFlowSpecInstance_in_rule__ComponentInstance__FlowSpecificationAssignment_1011420);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5723:1: rule__ComponentInstance__EndToEndFlowAssignment_11 : ( ruleEndToEndFlowInstance ) ;
    public final void rule__ComponentInstance__EndToEndFlowAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5727:1: ( ( ruleEndToEndFlowInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5728:1: ( ruleEndToEndFlowInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5728:1: ( ruleEndToEndFlowInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5729:1: ruleEndToEndFlowInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getEndToEndFlowEndToEndFlowInstanceParserRuleCall_11_0()); 
            pushFollow(FOLLOW_ruleEndToEndFlowInstance_in_rule__ComponentInstance__EndToEndFlowAssignment_1111451);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5738:1: rule__ComponentInstance__ConnectionInstanceAssignment_12 : ( ruleConnectionInstance ) ;
    public final void rule__ComponentInstance__ConnectionInstanceAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5742:1: ( ( ruleConnectionInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5743:1: ( ruleConnectionInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5743:1: ( ruleConnectionInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5744:1: ruleConnectionInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_12_0()); 
            pushFollow(FOLLOW_ruleConnectionInstance_in_rule__ComponentInstance__ConnectionInstanceAssignment_1211482);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5753:1: rule__ComponentInstance__InModeAssignment_13_2 : ( ( RULE_ID ) ) ;
    public final void rule__ComponentInstance__InModeAssignment_13_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5757:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5758:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5758:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5759:1: ( RULE_ID )
            {
             before(grammarAccess.getComponentInstanceAccess().getInModeModeInstanceCrossReference_13_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5760:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5761:1: RULE_ID
            {
             before(grammarAccess.getComponentInstanceAccess().getInModeModeInstanceIDTerminalRuleCall_13_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ComponentInstance__InModeAssignment_13_211517); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5772:1: rule__FeatureInstance__CategoryAssignment_0 : ( ruleFeatureCategory ) ;
    public final void rule__FeatureInstance__CategoryAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5776:1: ( ( ruleFeatureCategory ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5777:1: ( ruleFeatureCategory )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5777:1: ( ruleFeatureCategory )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5778:1: ruleFeatureCategory
            {
             before(grammarAccess.getFeatureInstanceAccess().getCategoryFeatureCategoryParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleFeatureCategory_in_rule__FeatureInstance__CategoryAssignment_011552);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5787:1: rule__FeatureInstance__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__FeatureInstance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5791:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5792:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5792:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5793:1: RULE_ID
            {
             before(grammarAccess.getFeatureInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FeatureInstance__NameAssignment_211583); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5802:1: rule__FeatureInstance__IndexAssignment_3_1 : ( ruleINTVALUE ) ;
    public final void rule__FeatureInstance__IndexAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5806:1: ( ( ruleINTVALUE ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5807:1: ( ruleINTVALUE )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5807:1: ( ruleINTVALUE )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5808:1: ruleINTVALUE
            {
             before(grammarAccess.getFeatureInstanceAccess().getIndexINTVALUEParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleINTVALUE_in_rule__FeatureInstance__IndexAssignment_3_111614);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5817:1: rule__FeatureInstance__FeatureAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__FeatureInstance__FeatureAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5821:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5822:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5822:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5823:1: ( RULE_ID )
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureCrossReference_5_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5824:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5825:1: RULE_ID
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FeatureInstance__FeatureAssignment_511649); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5836:1: rule__FeatureInstance__DirectionAssignment_6 : ( ruleDirectionType ) ;
    public final void rule__FeatureInstance__DirectionAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5840:1: ( ( ruleDirectionType ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5841:1: ( ruleDirectionType )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5841:1: ( ruleDirectionType )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5842:1: ruleDirectionType
            {
             before(grammarAccess.getFeatureInstanceAccess().getDirectionDirectionTypeParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleDirectionType_in_rule__FeatureInstance__DirectionAssignment_611684);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5851:1: rule__FeatureInstance__FeatureInstanceAssignment_7 : ( ruleFeatureInstance ) ;
    public final void rule__FeatureInstance__FeatureInstanceAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5855:1: ( ( ruleFeatureInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5856:1: ( ruleFeatureInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5856:1: ( ruleFeatureInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5857:1: ruleFeatureInstance
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_rule__FeatureInstance__FeatureInstanceAssignment_711715);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5866:1: rule__ModeInstance__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ModeInstance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5870:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5871:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5871:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5872:1: RULE_ID
            {
             before(grammarAccess.getModeInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ModeInstance__NameAssignment_211746); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5881:1: rule__ModeInstance__ModeAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__ModeInstance__ModeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5885:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5886:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5886:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5887:1: ( RULE_ID )
            {
             before(grammarAccess.getModeInstanceAccess().getModeModeCrossReference_4_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5888:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5889:1: RULE_ID
            {
             before(grammarAccess.getModeInstanceAccess().getModeModeIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ModeInstance__ModeAssignment_411781); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5900:1: rule__ModeInstance__InitialAssignment_5 : ( ( 'initial' ) ) ;
    public final void rule__ModeInstance__InitialAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5904:1: ( ( ( 'initial' ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5905:1: ( ( 'initial' ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5905:1: ( ( 'initial' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5906:1: ( 'initial' )
            {
             before(grammarAccess.getModeInstanceAccess().getInitialInitialKeyword_5_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5907:1: ( 'initial' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5908:1: 'initial'
            {
             before(grammarAccess.getModeInstanceAccess().getInitialInitialKeyword_5_0()); 
            match(input,58,FOLLOW_58_in_rule__ModeInstance__InitialAssignment_511821); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5923:1: rule__ModeTransitionInstance__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__ModeTransitionInstance__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5927:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5928:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5928:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5929:1: RULE_ID
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__NameAssignment_311860); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5938:1: rule__ModeTransitionInstance__ModeTransitionAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__ModeTransitionInstance__ModeTransitionAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5942:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5943:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5943:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5944:1: ( RULE_ID )
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionModeTransitionCrossReference_5_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5945:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5946:1: RULE_ID
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionModeTransitionIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__ModeTransitionAssignment_511895); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5957:1: rule__ModeTransitionInstance__SourceAssignment_7 : ( ( RULE_ID ) ) ;
    public final void rule__ModeTransitionInstance__SourceAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5961:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5962:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5962:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5963:1: ( RULE_ID )
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getSourceModeInstanceCrossReference_7_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5964:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5965:1: RULE_ID
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getSourceModeInstanceIDTerminalRuleCall_7_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__SourceAssignment_711934); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5976:1: rule__ModeTransitionInstance__DestinationAssignment_9 : ( ( RULE_ID ) ) ;
    public final void rule__ModeTransitionInstance__DestinationAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5980:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5981:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5981:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5982:1: ( RULE_ID )
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getDestinationModeInstanceCrossReference_9_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5983:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5984:1: RULE_ID
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getDestinationModeInstanceIDTerminalRuleCall_9_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__DestinationAssignment_911973); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5995:1: rule__FlowSpecInstance__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__FlowSpecInstance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5999:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6000:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6000:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6001:1: RULE_ID
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FlowSpecInstance__NameAssignment_212008); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6010:1: rule__FlowSpecInstance__FlowSpecificationAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__FlowSpecInstance__FlowSpecificationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6014:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6015:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6015:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6016:1: ( RULE_ID )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getFlowSpecificationFlowSpecificationCrossReference_4_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6017:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6018:1: RULE_ID
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getFlowSpecificationFlowSpecificationIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FlowSpecInstance__FlowSpecificationAssignment_412043); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6029:1: rule__FlowSpecInstance__SourceAssignment_5_1 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__FlowSpecInstance__SourceAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6033:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6034:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6034:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6035:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getSourceFeatureInstanceCrossReference_5_1_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6036:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6037:1: ruleINSTANCEREF
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getSourceFeatureInstanceINSTANCEREFParserRuleCall_5_1_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__FlowSpecInstance__SourceAssignment_5_112082);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6048:1: rule__FlowSpecInstance__DestinationAssignment_6_1 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__FlowSpecInstance__DestinationAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6052:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6053:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6053:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6054:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getDestinationFeatureInstanceCrossReference_6_1_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6055:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6056:1: ruleINSTANCEREF
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getDestinationFeatureInstanceINSTANCEREFParserRuleCall_6_1_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__FlowSpecInstance__DestinationAssignment_6_112121);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6067:1: rule__FlowSpecInstance__InModeAssignment_7_2 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__FlowSpecInstance__InModeAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6071:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6072:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6072:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6073:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInModeModeInstanceCrossReference_7_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6074:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6075:1: ruleINSTANCEREF
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInModeModeInstanceINSTANCEREFParserRuleCall_7_2_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__FlowSpecInstance__InModeAssignment_7_212160);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6086:1: rule__FlowSpecInstance__InModeTransitionAssignment_8_2 : ( ( RULE_ID ) ) ;
    public final void rule__FlowSpecInstance__InModeTransitionAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6090:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6091:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6091:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6092:1: ( RULE_ID )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6093:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6094:1: RULE_ID
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInModeTransitionModeTransitionInstanceIDTerminalRuleCall_8_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FlowSpecInstance__InModeTransitionAssignment_8_212199); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6105:1: rule__EndToEndFlowInstance__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EndToEndFlowInstance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6109:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6110:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6110:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6111:1: RULE_ID
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EndToEndFlowInstance__NameAssignment_212234); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6120:1: rule__EndToEndFlowInstance__EndToEndFlowAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__EndToEndFlowInstance__EndToEndFlowAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6124:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6125:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6125:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6126:1: ( RULE_ID )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowEndToEndFlowCrossReference_4_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6127:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6128:1: RULE_ID
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowEndToEndFlowIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EndToEndFlowInstance__EndToEndFlowAssignment_412269); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6139:1: rule__EndToEndFlowInstance__FlowElementAssignment_5 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__EndToEndFlowInstance__FlowElementAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6143:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6144:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6144:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6145:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceCrossReference_5_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6146:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6147:1: ruleINSTANCEREF
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceINSTANCEREFParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__EndToEndFlowInstance__FlowElementAssignment_512308);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6158:1: rule__EndToEndFlowInstance__InModeAssignment_6_2 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__EndToEndFlowInstance__InModeAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6162:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6163:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6163:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6164:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInModeModeInstanceCrossReference_6_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6165:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6166:1: ruleINSTANCEREF
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInModeModeInstanceINSTANCEREFParserRuleCall_6_2_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__EndToEndFlowInstance__InModeAssignment_6_212347);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6177:1: rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2 : ( ( ruleSOMID ) ) ;
    public final void rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6181:1: ( ( ( ruleSOMID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6182:1: ( ( ruleSOMID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6182:1: ( ( ruleSOMID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6183:1: ( ruleSOMID )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_7_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6184:1: ( ruleSOMID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6185:1: ruleSOMID
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeSOMIDParserRuleCall_7_2_0_1()); 
            pushFollow(FOLLOW_ruleSOMID_in_rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_212386);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6196:1: rule__SystemOperationMode__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__SystemOperationMode__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6200:1: ( ( RULE_STRING ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6201:1: ( RULE_STRING )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6201:1: ( RULE_STRING )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6202:1: RULE_STRING
            {
             before(grammarAccess.getSystemOperationModeAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__SystemOperationMode__NameAssignment_112421); 
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


    // $ANTLR start "rule__ConnectionInstance__KindAssignment_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6211:1: rule__ConnectionInstance__KindAssignment_0 : ( ruleConnectionKind ) ;
    public final void rule__ConnectionInstance__KindAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6215:1: ( ( ruleConnectionKind ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6216:1: ( ruleConnectionKind )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6216:1: ( ruleConnectionKind )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6217:1: ruleConnectionKind
            {
             before(grammarAccess.getConnectionInstanceAccess().getKindConnectionKindParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleConnectionKind_in_rule__ConnectionInstance__KindAssignment_012452);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6226:1: rule__ConnectionInstance__ConnectionReferenceAssignment_4 : ( ruleConnectionReference ) ;
    public final void rule__ConnectionInstance__ConnectionReferenceAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6230:1: ( ( ruleConnectionReference ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6231:1: ( ruleConnectionReference )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6231:1: ( ruleConnectionReference )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6232:1: ruleConnectionReference
            {
             before(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceConnectionReferenceParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleConnectionReference_in_rule__ConnectionInstance__ConnectionReferenceAssignment_412483);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6241:1: rule__ConnectionInstance__SourceAssignment_6 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionInstance__SourceAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6245:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6246:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6246:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6247:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndCrossReference_6_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6248:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6249:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndINSTANCEREFParserRuleCall_6_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__SourceAssignment_612518);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6260:1: rule__ConnectionInstance__DestinationAssignment_8 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionInstance__DestinationAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6264:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6265:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6265:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6266:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndCrossReference_8_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6267:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6268:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndINSTANCEREFParserRuleCall_8_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__DestinationAssignment_812557);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6279:1: rule__ConnectionInstance__InSystemOperationModeAssignment_9_2 : ( ( ruleSOMID ) ) ;
    public final void rule__ConnectionInstance__InSystemOperationModeAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6283:1: ( ( ( ruleSOMID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6284:1: ( ( ruleSOMID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6284:1: ( ( ruleSOMID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6285:1: ( ruleSOMID )
            {
             before(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_9_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6286:1: ( ruleSOMID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6287:1: ruleSOMID
            {
             before(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeSOMIDParserRuleCall_9_2_0_1()); 
            pushFollow(FOLLOW_ruleSOMID_in_rule__ConnectionInstance__InSystemOperationModeAssignment_9_212596);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6298:1: rule__ConnectionInstance__InModeTransitionAssignment_10_2 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionInstance__InModeTransitionAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6302:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6303:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6303:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6304:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_10_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6305:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6306:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceINSTANCEREFParserRuleCall_10_2_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__InModeTransitionAssignment_10_212635);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6317:1: rule__ConnectionInstance__CompleteAssignment_11 : ( ( 'complete' ) ) ;
    public final void rule__ConnectionInstance__CompleteAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6321:1: ( ( ( 'complete' ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6322:1: ( ( 'complete' ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6322:1: ( ( 'complete' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6323:1: ( 'complete' )
            {
             before(grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_11_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6324:1: ( 'complete' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6325:1: 'complete'
            {
             before(grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_11_0()); 
            match(input,59,FOLLOW_59_in_rule__ConnectionInstance__CompleteAssignment_1112675); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6340:1: rule__ConnectionInstance__BidirectionalAssignment_12 : ( ( 'bidirectional' ) ) ;
    public final void rule__ConnectionInstance__BidirectionalAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6344:1: ( ( ( 'bidirectional' ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6345:1: ( ( 'bidirectional' ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6345:1: ( ( 'bidirectional' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6346:1: ( 'bidirectional' )
            {
             before(grammarAccess.getConnectionInstanceAccess().getBidirectionalBidirectionalKeyword_12_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6347:1: ( 'bidirectional' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6348:1: 'bidirectional'
            {
             before(grammarAccess.getConnectionInstanceAccess().getBidirectionalBidirectionalKeyword_12_0()); 
            match(input,60,FOLLOW_60_in_rule__ConnectionInstance__BidirectionalAssignment_1212719); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6363:1: rule__ConnectionReference__ConnectionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ConnectionReference__ConnectionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6367:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6368:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6368:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6369:1: ( RULE_ID )
            {
             before(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionCrossReference_1_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6370:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6371:1: RULE_ID
            {
             before(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ConnectionReference__ConnectionAssignment_112762); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6382:1: rule__ConnectionReference__SourceAssignment_3 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionReference__SourceAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6386:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6387:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6387:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6388:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndCrossReference_3_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6389:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6390:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndINSTANCEREFParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__SourceAssignment_312801);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6401:1: rule__ConnectionReference__DestinationAssignment_5 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionReference__DestinationAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6405:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6406:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6406:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6407:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndCrossReference_5_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6408:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6409:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndINSTANCEREFParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__DestinationAssignment_512840);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6420:1: rule__ConnectionReference__ContextAssignment_7 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionReference__ContextAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6424:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6425:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6425:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6426:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceCrossReference_7_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6427:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6428:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceINSTANCEREFParserRuleCall_7_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__ContextAssignment_712879);
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
    protected DFA33 dfa33 = new DFA33(this);
    static final String DFA1_eotS =
        "\22\uffff";
    static final String DFA1_eofS =
        "\10\uffff\1\14\1\uffff\1\16\7\uffff";
    static final String DFA1_minS =
        "\1\11\7\uffff\1\5\1\uffff\1\5\1\12\6\uffff";
    static final String DFA1_maxS =
        "\1\66\7\uffff\1\65\1\uffff\1\65\1\17\6\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\2\uffff\1\10\1\11\1\14\1\13\1\16\1\15";
    static final String DFA1_specialS =
        "\22\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\43\uffff\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\14\41\uffff\1\14\15\uffff\1\15",
            "",
            "\1\16\41\uffff\1\16\15\uffff\1\17",
            "\1\21\4\uffff\1\20",
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
            return "564:1: rule__ComponentCategory__Alternatives : ( ( 'abstract' ) | ( 'bus' ) | ( 'data' ) | ( 'device' ) | ( 'memory' ) | ( 'process' ) | ( 'processor' ) | ( 'subprogram' ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( 'system' ) | ( ( rule__ComponentCategory__Group_10__0 ) ) | ( 'thread' ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( ( rule__ComponentCategory__Group_13__0 ) ) );";
        }
    }
    static final String DFA33_eotS =
        "\5\uffff";
    static final String DFA33_eofS =
        "\1\uffff\1\4\3\uffff";
    static final String DFA33_minS =
        "\1\5\1\35\1\5\2\uffff";
    static final String DFA33_maxS =
        "\1\5\1\74\1\5\2\uffff";
    static final String DFA33_acceptS =
        "\3\uffff\1\1\1\2";
    static final String DFA33_specialS =
        "\5\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\1",
            "\1\4\13\uffff\1\4\16\uffff\1\2\1\3\1\uffff\2\4",
            "\1\1",
            "",
            ""
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "()* loopback of 5414:1: ( rule__SOMID__Group_0__0 )*";
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
    public static final BitSet FOLLOW_9_in_rule__ComponentCategory__Alternatives1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__ComponentCategory__Alternatives1170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__ComponentCategory__Alternatives1190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ComponentCategory__Alternatives1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ComponentCategory__Alternatives1230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__ComponentCategory__Alternatives1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ComponentCategory__Alternatives1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ComponentCategory__Alternatives1290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__0_in_rule__ComponentCategory__Alternatives1309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__ComponentCategory__Alternatives1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_10__0_in_rule__ComponentCategory__Alternatives1347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ComponentCategory__Alternatives1366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__0_in_rule__ComponentCategory__Alternatives1385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_13__0_in_rule__ComponentCategory__Alternatives1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__FeatureCategory__Alternatives1437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__FeatureCategory__Alternatives1457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__FeatureCategory__Alternatives1477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__FeatureCategory__Alternatives1497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__FeatureCategory__Alternatives1517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__FeatureCategory__Alternatives1537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__FeatureCategory__Alternatives1557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__FeatureCategory__Alternatives1577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__FeatureCategory__Alternatives1597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__FeatureCategory__Alternatives1617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__DirectionType__Alternatives1652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__DirectionType__Alternatives1672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__DirectionType__Alternatives1692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ConnectionKind__Alternatives1727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ConnectionKind__Alternatives1747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ConnectionKind__Alternatives1767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__ConnectionKind__Alternatives1787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ConnectionKind__Alternatives1807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ConnectionKind__Alternatives1827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__0__Impl_in_rule__SystemInstance__Group__01859 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__1_in_rule__SystemInstance__Group__01862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__CategoryAssignment_0_in_rule__SystemInstance__Group__0__Impl1889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__1__Impl_in_rule__SystemInstance__Group__11919 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__2_in_rule__SystemInstance__Group__11922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__NameAssignment_1_in_rule__SystemInstance__Group__1__Impl1949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__2__Impl_in_rule__SystemInstance__Group__21979 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__3_in_rule__SystemInstance__Group__21982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__SystemInstance__Group__2__Impl2010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__3__Impl_in_rule__SystemInstance__Group__32041 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__4_in_rule__SystemInstance__Group__32044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__ComponentImplementationAssignment_3_in_rule__SystemInstance__Group__3__Impl2071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__4__Impl_in_rule__SystemInstance__Group__42101 = new BitSet(new long[]{0x0004004000000000L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__5_in_rule__SystemInstance__Group__42104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__SystemInstance__Group__4__Impl2132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__5__Impl_in_rule__SystemInstance__Group__52163 = new BitSet(new long[]{0x0004004000000000L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__6_in_rule__SystemInstance__Group__52166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__SystemOperationModeAssignment_5_in_rule__SystemInstance__Group__5__Impl2193 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__6__Impl_in_rule__SystemInstance__Group__62224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__SystemInstance__Group__6__Impl2252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__0__Impl_in_rule__ComponentInstance__Group__02297 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__1_in_rule__ComponentInstance__Group__02300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__CategoryAssignment_0_in_rule__ComponentInstance__Group__0__Impl2327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__1__Impl_in_rule__ComponentInstance__Group__12357 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__2_in_rule__ComponentInstance__Group__12360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ComponentInstance__Group__1__Impl2388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__2__Impl_in_rule__ComponentInstance__Group__22419 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__3_in_rule__ComponentInstance__Group__22422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__NameAssignment_2_in_rule__ComponentInstance__Group__2__Impl2449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__3__Impl_in_rule__ComponentInstance__Group__32479 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__4_in_rule__ComponentInstance__Group__32482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_3__0_in_rule__ComponentInstance__Group__3__Impl2509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__4__Impl_in_rule__ComponentInstance__Group__42540 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__5_in_rule__ComponentInstance__Group__42543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ComponentInstance__Group__4__Impl2571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__5__Impl_in_rule__ComponentInstance__Group__52602 = new BitSet(new long[]{0x0043120F3FFFFE00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__6_in_rule__ComponentInstance__Group__52605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__SubcomponentAssignment_5_in_rule__ComponentInstance__Group__5__Impl2632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__6__Impl_in_rule__ComponentInstance__Group__62662 = new BitSet(new long[]{0x0043120F3FFFFE00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__7_in_rule__ComponentInstance__Group__62665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__FeatureInstanceAssignment_6_in_rule__ComponentInstance__Group__6__Impl2692 = new BitSet(new long[]{0x000000001FF80002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__7__Impl_in_rule__ComponentInstance__Group__72723 = new BitSet(new long[]{0x0043120F3FFFFE00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__8_in_rule__ComponentInstance__Group__72726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__ComponentInstanceAssignment_7_in_rule__ComponentInstance__Group__7__Impl2753 = new BitSet(new long[]{0x004000000007FE02L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__8__Impl_in_rule__ComponentInstance__Group__82784 = new BitSet(new long[]{0x0043120F3FFFFE00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__9_in_rule__ComponentInstance__Group__82787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__ModeInstanceAssignment_8_in_rule__ComponentInstance__Group__8__Impl2814 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__9__Impl_in_rule__ComponentInstance__Group__92845 = new BitSet(new long[]{0x0043120F3FFFFE00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__10_in_rule__ComponentInstance__Group__92848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__ModeTransitionInstanceAssignment_9_in_rule__ComponentInstance__Group__9__Impl2875 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__10__Impl_in_rule__ComponentInstance__Group__102906 = new BitSet(new long[]{0x0043120F3FFFFE00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__11_in_rule__ComponentInstance__Group__102909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__FlowSpecificationAssignment_10_in_rule__ComponentInstance__Group__10__Impl2936 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__11__Impl_in_rule__ComponentInstance__Group__112967 = new BitSet(new long[]{0x0043120F3FFFFE00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__12_in_rule__ComponentInstance__Group__112970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__EndToEndFlowAssignment_11_in_rule__ComponentInstance__Group__11__Impl2997 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__12__Impl_in_rule__ComponentInstance__Group__123028 = new BitSet(new long[]{0x0043120F3FFFFE00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__13_in_rule__ComponentInstance__Group__123031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__ConnectionInstanceAssignment_12_in_rule__ComponentInstance__Group__12__Impl3058 = new BitSet(new long[]{0x0000000F08400002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__13__Impl_in_rule__ComponentInstance__Group__133089 = new BitSet(new long[]{0x0043120F3FFFFE00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__14_in_rule__ComponentInstance__Group__133092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_13__0_in_rule__ComponentInstance__Group__13__Impl3119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__14__Impl_in_rule__ComponentInstance__Group__143150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ComponentInstance__Group__14__Impl3178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_3__0__Impl_in_rule__ComponentInstance__Group_3__03239 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_3__1_in_rule__ComponentInstance__Group_3__03242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__ComponentInstance__Group_3__0__Impl3270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_3__1__Impl_in_rule__ComponentInstance__Group_3__13301 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_3__2_in_rule__ComponentInstance__Group_3__13304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__IndexAssignment_3_1_in_rule__ComponentInstance__Group_3__1__Impl3333 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ComponentInstance__IndexAssignment_3_1_in_rule__ComponentInstance__Group_3__1__Impl3345 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_3__2__Impl_in_rule__ComponentInstance__Group_3__23378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__ComponentInstance__Group_3__2__Impl3406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_13__0__Impl_in_rule__ComponentInstance__Group_13__03443 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_13__1_in_rule__ComponentInstance__Group_13__03446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ComponentInstance__Group_13__0__Impl3474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_13__1__Impl_in_rule__ComponentInstance__Group_13__13505 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_13__2_in_rule__ComponentInstance__Group_13__13508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__ComponentInstance__Group_13__1__Impl3536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_13__2__Impl_in_rule__ComponentInstance__Group_13__23567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__InModeAssignment_13_2_in_rule__ComponentInstance__Group_13__2__Impl3594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__0__Impl_in_rule__FeatureInstance__Group__03630 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__1_in_rule__FeatureInstance__Group__03633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__CategoryAssignment_0_in_rule__FeatureInstance__Group__0__Impl3660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__1__Impl_in_rule__FeatureInstance__Group__13690 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__2_in_rule__FeatureInstance__Group__13693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__FeatureInstance__Group__1__Impl3721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__2__Impl_in_rule__FeatureInstance__Group__23752 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__3_in_rule__FeatureInstance__Group__23755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__NameAssignment_2_in_rule__FeatureInstance__Group__2__Impl3782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__3__Impl_in_rule__FeatureInstance__Group__33812 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__4_in_rule__FeatureInstance__Group__33815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__0_in_rule__FeatureInstance__Group__3__Impl3842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__4__Impl_in_rule__FeatureInstance__Group__43873 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__5_in_rule__FeatureInstance__Group__43876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__FeatureInstance__Group__4__Impl3904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__5__Impl_in_rule__FeatureInstance__Group__53935 = new BitSet(new long[]{0x00000000E0000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__6_in_rule__FeatureInstance__Group__53938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__FeatureAssignment_5_in_rule__FeatureInstance__Group__5__Impl3965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__6__Impl_in_rule__FeatureInstance__Group__63995 = new BitSet(new long[]{0x000000001FF80000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__7_in_rule__FeatureInstance__Group__63998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__DirectionAssignment_6_in_rule__FeatureInstance__Group__6__Impl4025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__7__Impl_in_rule__FeatureInstance__Group__74055 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__8_in_rule__FeatureInstance__Group__74058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__FeatureInstanceAssignment_7_in_rule__FeatureInstance__Group__7__Impl4085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__8__Impl_in_rule__FeatureInstance__Group__84115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__FeatureInstance__Group__8__Impl4143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__0__Impl_in_rule__FeatureInstance__Group_3__04192 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__1_in_rule__FeatureInstance__Group_3__04195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__FeatureInstance__Group_3__0__Impl4223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__1__Impl_in_rule__FeatureInstance__Group_3__14254 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__2_in_rule__FeatureInstance__Group_3__14257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__IndexAssignment_3_1_in_rule__FeatureInstance__Group_3__1__Impl4284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__2__Impl_in_rule__FeatureInstance__Group_3__24314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__FeatureInstance__Group_3__2__Impl4342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__0__Impl_in_rule__ModeInstance__Group__04379 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__1_in_rule__ModeInstance__Group__04382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__ModeInstance__Group__0__Impl4410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__1__Impl_in_rule__ModeInstance__Group__14441 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__2_in_rule__ModeInstance__Group__14444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ModeInstance__Group__1__Impl4472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__2__Impl_in_rule__ModeInstance__Group__24503 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__3_in_rule__ModeInstance__Group__24506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__NameAssignment_2_in_rule__ModeInstance__Group__2__Impl4533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__3__Impl_in_rule__ModeInstance__Group__34563 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__4_in_rule__ModeInstance__Group__34566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ModeInstance__Group__3__Impl4594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__4__Impl_in_rule__ModeInstance__Group__44625 = new BitSet(new long[]{0x0400020000000000L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__5_in_rule__ModeInstance__Group__44628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__ModeAssignment_4_in_rule__ModeInstance__Group__4__Impl4655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__5__Impl_in_rule__ModeInstance__Group__54685 = new BitSet(new long[]{0x0400020000000000L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__6_in_rule__ModeInstance__Group__54688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__InitialAssignment_5_in_rule__ModeInstance__Group__5__Impl4715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__6__Impl_in_rule__ModeInstance__Group__64746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ModeInstance__Group__6__Impl4774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__0__Impl_in_rule__ModeTransitionInstance__Group__04819 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__1_in_rule__ModeTransitionInstance__Group__04822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__ModeTransitionInstance__Group__0__Impl4850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__1__Impl_in_rule__ModeTransitionInstance__Group__14881 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__2_in_rule__ModeTransitionInstance__Group__14884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__ModeTransitionInstance__Group__1__Impl4912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__2__Impl_in_rule__ModeTransitionInstance__Group__24943 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__3_in_rule__ModeTransitionInstance__Group__24946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ModeTransitionInstance__Group__2__Impl4974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__3__Impl_in_rule__ModeTransitionInstance__Group__35005 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__4_in_rule__ModeTransitionInstance__Group__35008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__NameAssignment_3_in_rule__ModeTransitionInstance__Group__3__Impl5035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__4__Impl_in_rule__ModeTransitionInstance__Group__45065 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__5_in_rule__ModeTransitionInstance__Group__45068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ModeTransitionInstance__Group__4__Impl5096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__5__Impl_in_rule__ModeTransitionInstance__Group__55127 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__6_in_rule__ModeTransitionInstance__Group__55130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__ModeTransitionAssignment_5_in_rule__ModeTransitionInstance__Group__5__Impl5157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__6__Impl_in_rule__ModeTransitionInstance__Group__65187 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__7_in_rule__ModeTransitionInstance__Group__65190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ModeTransitionInstance__Group__6__Impl5218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__7__Impl_in_rule__ModeTransitionInstance__Group__75249 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__8_in_rule__ModeTransitionInstance__Group__75252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__SourceAssignment_7_in_rule__ModeTransitionInstance__Group__7__Impl5279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__8__Impl_in_rule__ModeTransitionInstance__Group__85309 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__9_in_rule__ModeTransitionInstance__Group__85312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__ModeTransitionInstance__Group__8__Impl5340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__9__Impl_in_rule__ModeTransitionInstance__Group__95371 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__10_in_rule__ModeTransitionInstance__Group__95374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__DestinationAssignment_9_in_rule__ModeTransitionInstance__Group__9__Impl5401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__10__Impl_in_rule__ModeTransitionInstance__Group__105431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ModeTransitionInstance__Group__10__Impl5459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__0__Impl_in_rule__FlowSpecInstance__Group__05512 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__1_in_rule__FlowSpecInstance__Group__05515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__FlowSpecInstance__Group__0__Impl5543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__1__Impl_in_rule__FlowSpecInstance__Group__15574 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__2_in_rule__FlowSpecInstance__Group__15577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__FlowSpecInstance__Group__1__Impl5605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__2__Impl_in_rule__FlowSpecInstance__Group__25636 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__3_in_rule__FlowSpecInstance__Group__25639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__NameAssignment_2_in_rule__FlowSpecInstance__Group__2__Impl5666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__3__Impl_in_rule__FlowSpecInstance__Group__35696 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__4_in_rule__FlowSpecInstance__Group__35699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__FlowSpecInstance__Group__3__Impl5727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__4__Impl_in_rule__FlowSpecInstance__Group__45758 = new BitSet(new long[]{0x0000C20020000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__5_in_rule__FlowSpecInstance__Group__45761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__FlowSpecificationAssignment_4_in_rule__FlowSpecInstance__Group__4__Impl5788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__5__Impl_in_rule__FlowSpecInstance__Group__55818 = new BitSet(new long[]{0x0000C20020000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__6_in_rule__FlowSpecInstance__Group__55821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_5__0_in_rule__FlowSpecInstance__Group__5__Impl5848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__6__Impl_in_rule__FlowSpecInstance__Group__65879 = new BitSet(new long[]{0x0000C20020000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__7_in_rule__FlowSpecInstance__Group__65882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_6__0_in_rule__FlowSpecInstance__Group__6__Impl5909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__7__Impl_in_rule__FlowSpecInstance__Group__75940 = new BitSet(new long[]{0x0000C20020000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__8_in_rule__FlowSpecInstance__Group__75943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_7__0_in_rule__FlowSpecInstance__Group__7__Impl5970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__8__Impl_in_rule__FlowSpecInstance__Group__86001 = new BitSet(new long[]{0x0000C20020000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__9_in_rule__FlowSpecInstance__Group__86004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_8__0_in_rule__FlowSpecInstance__Group__8__Impl6031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__9__Impl_in_rule__FlowSpecInstance__Group__96062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__FlowSpecInstance__Group__9__Impl6090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_5__0__Impl_in_rule__FlowSpecInstance__Group_5__06141 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_5__1_in_rule__FlowSpecInstance__Group_5__06144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__FlowSpecInstance__Group_5__0__Impl6172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_5__1__Impl_in_rule__FlowSpecInstance__Group_5__16203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__SourceAssignment_5_1_in_rule__FlowSpecInstance__Group_5__1__Impl6230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_6__0__Impl_in_rule__FlowSpecInstance__Group_6__06264 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_6__1_in_rule__FlowSpecInstance__Group_6__06267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__FlowSpecInstance__Group_6__0__Impl6295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_6__1__Impl_in_rule__FlowSpecInstance__Group_6__16326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__DestinationAssignment_6_1_in_rule__FlowSpecInstance__Group_6__1__Impl6353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_7__0__Impl_in_rule__FlowSpecInstance__Group_7__06387 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_7__1_in_rule__FlowSpecInstance__Group_7__06390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__FlowSpecInstance__Group_7__0__Impl6418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_7__1__Impl_in_rule__FlowSpecInstance__Group_7__16449 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_7__2_in_rule__FlowSpecInstance__Group_7__16452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__FlowSpecInstance__Group_7__1__Impl6480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_7__2__Impl_in_rule__FlowSpecInstance__Group_7__26511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__InModeAssignment_7_2_in_rule__FlowSpecInstance__Group_7__2__Impl6538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_8__0__Impl_in_rule__FlowSpecInstance__Group_8__06574 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_8__1_in_rule__FlowSpecInstance__Group_8__06577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__FlowSpecInstance__Group_8__0__Impl6605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_8__1__Impl_in_rule__FlowSpecInstance__Group_8__16636 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_8__2_in_rule__FlowSpecInstance__Group_8__16639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__FlowSpecInstance__Group_8__1__Impl6667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_8__2__Impl_in_rule__FlowSpecInstance__Group_8__26698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__InModeTransitionAssignment_8_2_in_rule__FlowSpecInstance__Group_8__2__Impl6725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__0__Impl_in_rule__EndToEndFlowInstance__Group__06761 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__1_in_rule__EndToEndFlowInstance__Group__06764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__EndToEndFlowInstance__Group__0__Impl6792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__1__Impl_in_rule__EndToEndFlowInstance__Group__16823 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__2_in_rule__EndToEndFlowInstance__Group__16826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__EndToEndFlowInstance__Group__1__Impl6854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__2__Impl_in_rule__EndToEndFlowInstance__Group__26885 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__3_in_rule__EndToEndFlowInstance__Group__26888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__NameAssignment_2_in_rule__EndToEndFlowInstance__Group__2__Impl6915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__3__Impl_in_rule__EndToEndFlowInstance__Group__36945 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__4_in_rule__EndToEndFlowInstance__Group__36948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__EndToEndFlowInstance__Group__3__Impl6976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__4__Impl_in_rule__EndToEndFlowInstance__Group__47007 = new BitSet(new long[]{0x0000020020000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__5_in_rule__EndToEndFlowInstance__Group__47010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__EndToEndFlowAssignment_4_in_rule__EndToEndFlowInstance__Group__4__Impl7037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__5__Impl_in_rule__EndToEndFlowInstance__Group__57067 = new BitSet(new long[]{0x0000020020000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__6_in_rule__EndToEndFlowInstance__Group__57070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__FlowElementAssignment_5_in_rule__EndToEndFlowInstance__Group__5__Impl7097 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__6__Impl_in_rule__EndToEndFlowInstance__Group__67128 = new BitSet(new long[]{0x0000020020000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__7_in_rule__EndToEndFlowInstance__Group__67131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_6__0_in_rule__EndToEndFlowInstance__Group__6__Impl7158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__7__Impl_in_rule__EndToEndFlowInstance__Group__77189 = new BitSet(new long[]{0x0000020020000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__8_in_rule__EndToEndFlowInstance__Group__77192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_7__0_in_rule__EndToEndFlowInstance__Group__7__Impl7219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__8__Impl_in_rule__EndToEndFlowInstance__Group__87250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__EndToEndFlowInstance__Group__8__Impl7278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_6__0__Impl_in_rule__EndToEndFlowInstance__Group_6__07327 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_6__1_in_rule__EndToEndFlowInstance__Group_6__07330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__EndToEndFlowInstance__Group_6__0__Impl7358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_6__1__Impl_in_rule__EndToEndFlowInstance__Group_6__17389 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_6__2_in_rule__EndToEndFlowInstance__Group_6__17392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__EndToEndFlowInstance__Group_6__1__Impl7420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_6__2__Impl_in_rule__EndToEndFlowInstance__Group_6__27451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__InModeAssignment_6_2_in_rule__EndToEndFlowInstance__Group_6__2__Impl7478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_7__0__Impl_in_rule__EndToEndFlowInstance__Group_7__07514 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_7__1_in_rule__EndToEndFlowInstance__Group_7__07517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__EndToEndFlowInstance__Group_7__0__Impl7545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_7__1__Impl_in_rule__EndToEndFlowInstance__Group_7__17576 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_7__2_in_rule__EndToEndFlowInstance__Group_7__17579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__EndToEndFlowInstance__Group_7__1__Impl7607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_7__2__Impl_in_rule__EndToEndFlowInstance__Group_7__27638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2_in_rule__EndToEndFlowInstance__Group_7__2__Impl7665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__0__Impl_in_rule__SystemOperationMode__Group__07701 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__1_in_rule__SystemOperationMode__Group__07704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__SystemOperationMode__Group__0__Impl7732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__1__Impl_in_rule__SystemOperationMode__Group__17763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__NameAssignment_1_in_rule__SystemOperationMode__Group__1__Impl7790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__0__Impl_in_rule__ConnectionInstance__Group__07824 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__1_in_rule__ConnectionInstance__Group__07827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__KindAssignment_0_in_rule__ConnectionInstance__Group__0__Impl7854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__1__Impl_in_rule__ConnectionInstance__Group__17884 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__2_in_rule__ConnectionInstance__Group__17887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__ConnectionInstance__Group__1__Impl7915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__2__Impl_in_rule__ConnectionInstance__Group__27946 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__3_in_rule__ConnectionInstance__Group__27949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ConnectionInstance__Group__2__Impl7977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__3__Impl_in_rule__ConnectionInstance__Group__38008 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__4_in_rule__ConnectionInstance__Group__38011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ConnectionInstance__Group__3__Impl8039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__4__Impl_in_rule__ConnectionInstance__Group__48070 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__5_in_rule__ConnectionInstance__Group__48073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__ConnectionReferenceAssignment_4_in_rule__ConnectionInstance__Group__4__Impl8102 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__ConnectionReferenceAssignment_4_in_rule__ConnectionInstance__Group__4__Impl8114 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__5__Impl_in_rule__ConnectionInstance__Group__58147 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__6_in_rule__ConnectionInstance__Group__58150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ConnectionInstance__Group__5__Impl8178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__6__Impl_in_rule__ConnectionInstance__Group__68209 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__7_in_rule__ConnectionInstance__Group__68212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__SourceAssignment_6_in_rule__ConnectionInstance__Group__6__Impl8239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__7__Impl_in_rule__ConnectionInstance__Group__78269 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__8_in_rule__ConnectionInstance__Group__78272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__ConnectionInstance__Group__7__Impl8300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__8__Impl_in_rule__ConnectionInstance__Group__88331 = new BitSet(new long[]{0x1800020020000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__9_in_rule__ConnectionInstance__Group__88334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__DestinationAssignment_8_in_rule__ConnectionInstance__Group__8__Impl8361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__9__Impl_in_rule__ConnectionInstance__Group__98391 = new BitSet(new long[]{0x1800020020000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__10_in_rule__ConnectionInstance__Group__98394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_9__0_in_rule__ConnectionInstance__Group__9__Impl8421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__10__Impl_in_rule__ConnectionInstance__Group__108452 = new BitSet(new long[]{0x1800020020000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__11_in_rule__ConnectionInstance__Group__108455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_10__0_in_rule__ConnectionInstance__Group__10__Impl8482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__11__Impl_in_rule__ConnectionInstance__Group__118513 = new BitSet(new long[]{0x1800020020000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__12_in_rule__ConnectionInstance__Group__118516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__CompleteAssignment_11_in_rule__ConnectionInstance__Group__11__Impl8543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__12__Impl_in_rule__ConnectionInstance__Group__128574 = new BitSet(new long[]{0x1800020020000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__13_in_rule__ConnectionInstance__Group__128577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__BidirectionalAssignment_12_in_rule__ConnectionInstance__Group__12__Impl8604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__13__Impl_in_rule__ConnectionInstance__Group__138635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ConnectionInstance__Group__13__Impl8663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_9__0__Impl_in_rule__ConnectionInstance__Group_9__08722 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_9__1_in_rule__ConnectionInstance__Group_9__08725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ConnectionInstance__Group_9__0__Impl8753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_9__1__Impl_in_rule__ConnectionInstance__Group_9__18784 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_9__2_in_rule__ConnectionInstance__Group_9__18787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__ConnectionInstance__Group_9__1__Impl8815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_9__2__Impl_in_rule__ConnectionInstance__Group_9__28846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__InSystemOperationModeAssignment_9_2_in_rule__ConnectionInstance__Group_9__2__Impl8873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_10__0__Impl_in_rule__ConnectionInstance__Group_10__08909 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_10__1_in_rule__ConnectionInstance__Group_10__08912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ConnectionInstance__Group_10__0__Impl8940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_10__1__Impl_in_rule__ConnectionInstance__Group_10__18971 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_10__2_in_rule__ConnectionInstance__Group_10__18974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__ConnectionInstance__Group_10__1__Impl9002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_10__2__Impl_in_rule__ConnectionInstance__Group_10__29033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__InModeTransitionAssignment_10_2_in_rule__ConnectionInstance__Group_10__2__Impl9060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__0__Impl_in_rule__ConnectionReference__Group__09096 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__1_in_rule__ConnectionReference__Group__09099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ConnectionReference__Group__0__Impl9127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__1__Impl_in_rule__ConnectionReference__Group__19158 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__2_in_rule__ConnectionReference__Group__19161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__ConnectionAssignment_1_in_rule__ConnectionReference__Group__1__Impl9188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__2__Impl_in_rule__ConnectionReference__Group__29218 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__3_in_rule__ConnectionReference__Group__29221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ConnectionReference__Group__2__Impl9249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__3__Impl_in_rule__ConnectionReference__Group__39280 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__4_in_rule__ConnectionReference__Group__39283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__SourceAssignment_3_in_rule__ConnectionReference__Group__3__Impl9310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__4__Impl_in_rule__ConnectionReference__Group__49340 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__5_in_rule__ConnectionReference__Group__49343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__ConnectionReference__Group__4__Impl9371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__5__Impl_in_rule__ConnectionReference__Group__59402 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__6_in_rule__ConnectionReference__Group__59405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__DestinationAssignment_5_in_rule__ConnectionReference__Group__5__Impl9432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__6__Impl_in_rule__ConnectionReference__Group__69462 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__7_in_rule__ConnectionReference__Group__69465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__ConnectionReference__Group__6__Impl9493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__7__Impl_in_rule__ConnectionReference__Group__79524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__ContextAssignment_7_in_rule__ConnectionReference__Group__7__Impl9551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__0__Impl_in_rule__ComponentCategory__Group_8__09597 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__1_in_rule__ComponentCategory__Group_8__09600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ComponentCategory__Group_8__0__Impl9628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__1__Impl_in_rule__ComponentCategory__Group_8__19659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__ComponentCategory__Group_8__1__Impl9687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_10__0__Impl_in_rule__ComponentCategory__Group_10__09722 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_10__1_in_rule__ComponentCategory__Group_10__09725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ComponentCategory__Group_10__0__Impl9753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_10__1__Impl_in_rule__ComponentCategory__Group_10__19784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__ComponentCategory__Group_10__1__Impl9812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__0__Impl_in_rule__ComponentCategory__Group_12__09847 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__1_in_rule__ComponentCategory__Group_12__09850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__ComponentCategory__Group_12__0__Impl9878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__1__Impl_in_rule__ComponentCategory__Group_12__19909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__ComponentCategory__Group_12__1__Impl9937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_13__0__Impl_in_rule__ComponentCategory__Group_13__09972 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_13__1_in_rule__ComponentCategory__Group_13__09975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__ComponentCategory__Group_13__0__Impl10003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_13__1__Impl_in_rule__ComponentCategory__Group_13__110034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ComponentCategory__Group_13__1__Impl10062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group__0__Impl_in_rule__FQCREF__Group__010097 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FQCREF__Group__1_in_rule__FQCREF__Group__010100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_0__0_in_rule__FQCREF__Group__0__Impl10129 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_0__0_in_rule__FQCREF__Group__0__Impl10141 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__FQCREF__Group__1__Impl_in_rule__FQCREF__Group__110174 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_rule__FQCREF__Group__2_in_rule__FQCREF__Group__110177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQCREF__Group__1__Impl10204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group__2__Impl_in_rule__FQCREF__Group__210233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_2__0_in_rule__FQCREF__Group__2__Impl10260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_0__0__Impl_in_rule__FQCREF__Group_0__010297 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_0__1_in_rule__FQCREF__Group_0__010300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQCREF__Group_0__0__Impl10327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_0__1__Impl_in_rule__FQCREF__Group_0__110356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_rule__FQCREF__Group_0__1__Impl10384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_2__0__Impl_in_rule__FQCREF__Group_2__010419 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_2__1_in_rule__FQCREF__Group_2__010422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_rule__FQCREF__Group_2__0__Impl10450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_2__1__Impl_in_rule__FQCREF__Group_2__110481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQCREF__Group_2__1__Impl10508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group__0__Impl_in_rule__INSTANCEREF__Group__010541 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group__1_in_rule__INSTANCEREF__Group__010544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_0__0_in_rule__INSTANCEREF__Group__0__Impl10571 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group__1__Impl_in_rule__INSTANCEREF__Group__110602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__INSTANCEREF__Group__1__Impl10629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_0__0__Impl_in_rule__INSTANCEREF__Group_0__010662 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_0__1_in_rule__INSTANCEREF__Group_0__010665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__INSTANCEREF__Group_0__0__Impl10692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_0__1__Impl_in_rule__INSTANCEREF__Group_0__110721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_rule__INSTANCEREF__Group_0__1__Impl10749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SOMID__Group__0__Impl_in_rule__SOMID__Group__010784 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SOMID__Group__1_in_rule__SOMID__Group__010787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SOMID__Group_0__0_in_rule__SOMID__Group__0__Impl10814 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__SOMID__Group__1__Impl_in_rule__SOMID__Group__110845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__SOMID__Group__1__Impl10872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SOMID__Group_0__0__Impl_in_rule__SOMID__Group_0__010905 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_rule__SOMID__Group_0__1_in_rule__SOMID__Group_0__010908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__SOMID__Group_0__0__Impl10935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SOMID__Group_0__1__Impl_in_rule__SOMID__Group_0__110964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_rule__SOMID__Group_0__1__Impl10992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_rule__SystemInstance__CategoryAssignment_011032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SystemInstance__NameAssignment_111063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQCREF_in_rule__SystemInstance__ComponentImplementationAssignment_311098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_rule__SystemInstance__SystemOperationModeAssignment_511133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_rule__ComponentInstance__CategoryAssignment_011164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ComponentInstance__NameAssignment_211195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTVALUE_in_rule__ComponentInstance__IndexAssignment_3_111226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ComponentInstance__SubcomponentAssignment_511261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_rule__ComponentInstance__FeatureInstanceAssignment_611296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_rule__ComponentInstance__ComponentInstanceAssignment_711327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeInstance_in_rule__ComponentInstance__ModeInstanceAssignment_811358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeTransitionInstance_in_rule__ComponentInstance__ModeTransitionInstanceAssignment_911389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSpecInstance_in_rule__ComponentInstance__FlowSpecificationAssignment_1011420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndToEndFlowInstance_in_rule__ComponentInstance__EndToEndFlowAssignment_1111451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_rule__ComponentInstance__ConnectionInstanceAssignment_1211482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ComponentInstance__InModeAssignment_13_211517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_rule__FeatureInstance__CategoryAssignment_011552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FeatureInstance__NameAssignment_211583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTVALUE_in_rule__FeatureInstance__IndexAssignment_3_111614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FeatureInstance__FeatureAssignment_511649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_rule__FeatureInstance__DirectionAssignment_611684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_rule__FeatureInstance__FeatureInstanceAssignment_711715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ModeInstance__NameAssignment_211746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ModeInstance__ModeAssignment_411781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_rule__ModeInstance__InitialAssignment_511821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__NameAssignment_311860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__ModeTransitionAssignment_511895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__SourceAssignment_711934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__DestinationAssignment_911973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FlowSpecInstance__NameAssignment_212008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FlowSpecInstance__FlowSpecificationAssignment_412043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__FlowSpecInstance__SourceAssignment_5_112082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__FlowSpecInstance__DestinationAssignment_6_112121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__FlowSpecInstance__InModeAssignment_7_212160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FlowSpecInstance__InModeTransitionAssignment_8_212199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EndToEndFlowInstance__NameAssignment_212234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EndToEndFlowInstance__EndToEndFlowAssignment_412269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__EndToEndFlowInstance__FlowElementAssignment_512308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__EndToEndFlowInstance__InModeAssignment_6_212347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSOMID_in_rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_212386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__SystemOperationMode__NameAssignment_112421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionKind_in_rule__ConnectionInstance__KindAssignment_012452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionReference_in_rule__ConnectionInstance__ConnectionReferenceAssignment_412483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__SourceAssignment_612518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__DestinationAssignment_812557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSOMID_in_rule__ConnectionInstance__InSystemOperationModeAssignment_9_212596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__InModeTransitionAssignment_10_212635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_rule__ConnectionInstance__CompleteAssignment_1112675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_rule__ConnectionInstance__BidirectionalAssignment_1212719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ConnectionReference__ConnectionAssignment_112762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__SourceAssignment_312801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__DestinationAssignment_512840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__ContextAssignment_712879 = new BitSet(new long[]{0x0000000000000002L});

}