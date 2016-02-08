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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INTEGER_LIT", "RULE_ID", "RULE_STRING", "RULE_SL_COMMENT", "RULE_WS", "'abstract'", "'bus'", "'data'", "'device'", "'memory'", "'process'", "'processor'", "'subprogram'", "'system'", "'threadgroup'", "'thread'", "'virtualprocessor'", "'eventport'", "'dataport'", "'eventdataport'", "'parameter'", "'busaccess'", "'dataaccess'", "'subprogramaccess'", "'subprogramgroupaccess'", "'featuregroup'", "'abstractfeature'", "'in'", "'out'", "'inout'", "'feature'", "'access'", "'port'", "'modetransition'", "':'", "'{'", "'}'", "'instance'", "'of'", "'end'", "'['", "']'", "'mode'", "'transition'", "'src'", "'dst'", "'flowspec'", "'etef'", "'som'", "'connection'", "'context'", "'group'", "'virtual'", "'::'", "'.'", "'#'", "'initial'", "'complete'", "'bidirectional'"
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
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__62=62;
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
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:647:6: ( 'threadgroup' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:647:6: ( 'threadgroup' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:648:1: 'threadgroup'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getThreadgroupKeyword_10()); 
                    match(input,18,FOLLOW_18_in_rule__ComponentCategory__Alternatives1348); 
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
                    match(input,19,FOLLOW_19_in_rule__ComponentCategory__Alternatives1368); 
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
                    match(input,20,FOLLOW_20_in_rule__ComponentCategory__Alternatives1406); 
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
            case 21:
                {
                alt2=1;
                }
                break;
            case 22:
                {
                alt2=2;
                }
                break;
            case 23:
                {
                alt2=3;
                }
                break;
            case 24:
                {
                alt2=4;
                }
                break;
            case 25:
                {
                alt2=5;
                }
                break;
            case 26:
                {
                alt2=6;
                }
                break;
            case 27:
                {
                alt2=7;
                }
                break;
            case 28:
                {
                alt2=8;
                }
                break;
            case 29:
                {
                alt2=9;
                }
                break;
            case 30:
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
                    match(input,21,FOLLOW_21_in_rule__FeatureCategory__Alternatives1441); 
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
                    match(input,22,FOLLOW_22_in_rule__FeatureCategory__Alternatives1461); 
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
                    match(input,23,FOLLOW_23_in_rule__FeatureCategory__Alternatives1481); 
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
                    match(input,24,FOLLOW_24_in_rule__FeatureCategory__Alternatives1501); 
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
                    match(input,25,FOLLOW_25_in_rule__FeatureCategory__Alternatives1521); 
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
                    match(input,26,FOLLOW_26_in_rule__FeatureCategory__Alternatives1541); 
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
                    match(input,27,FOLLOW_27_in_rule__FeatureCategory__Alternatives1561); 
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
                    match(input,28,FOLLOW_28_in_rule__FeatureCategory__Alternatives1581); 
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
                    match(input,29,FOLLOW_29_in_rule__FeatureCategory__Alternatives1601); 
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
                    match(input,30,FOLLOW_30_in_rule__FeatureCategory__Alternatives1621); 
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
            case 31:
                {
                alt3=1;
                }
                break;
            case 32:
                {
                alt3=2;
                }
                break;
            case 33:
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
                    match(input,31,FOLLOW_31_in_rule__DirectionType__Alternatives1656); 
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
                    match(input,32,FOLLOW_32_in_rule__DirectionType__Alternatives1676); 
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
                    match(input,33,FOLLOW_33_in_rule__DirectionType__Alternatives1696); 
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
            case 34:
                {
                alt4=1;
                }
                break;
            case 35:
                {
                alt4=2;
                }
                break;
            case 24:
                {
                alt4=3;
                }
                break;
            case 36:
                {
                alt4=4;
                }
                break;
            case 37:
                {
                alt4=5;
                }
                break;
            case 29:
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
                    match(input,34,FOLLOW_34_in_rule__ConnectionKind__Alternatives1731); 
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
                    match(input,35,FOLLOW_35_in_rule__ConnectionKind__Alternatives1751); 
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
                    match(input,24,FOLLOW_24_in_rule__ConnectionKind__Alternatives1771); 
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
                    match(input,36,FOLLOW_36_in_rule__ConnectionKind__Alternatives1791); 
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
                    match(input,37,FOLLOW_37_in_rule__ConnectionKind__Alternatives1811); 
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
                    match(input,29,FOLLOW_29_in_rule__ConnectionKind__Alternatives1831); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:878:1: rule__SystemInstance__Group__0__Impl : ( ( rule__SystemInstance__CategoryAssignment_0 ) ) ;
    public final void rule__SystemInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:882:1: ( ( ( rule__SystemInstance__CategoryAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:883:1: ( ( rule__SystemInstance__CategoryAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:883:1: ( ( rule__SystemInstance__CategoryAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:884:1: ( rule__SystemInstance__CategoryAssignment_0 )
            {
             before(grammarAccess.getSystemInstanceAccess().getCategoryAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:885:1: ( rule__SystemInstance__CategoryAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:885:2: rule__SystemInstance__CategoryAssignment_0
            {
            pushFollow(FOLLOW_rule__SystemInstance__CategoryAssignment_0_in_rule__SystemInstance__Group__0__Impl1893);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:895:1: rule__SystemInstance__Group__1 : rule__SystemInstance__Group__1__Impl rule__SystemInstance__Group__2 ;
    public final void rule__SystemInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:899:1: ( rule__SystemInstance__Group__1__Impl rule__SystemInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:900:2: rule__SystemInstance__Group__1__Impl rule__SystemInstance__Group__2
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__1__Impl_in_rule__SystemInstance__Group__11923);
            rule__SystemInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__2_in_rule__SystemInstance__Group__11926);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:907:1: rule__SystemInstance__Group__1__Impl : ( ( rule__SystemInstance__NameAssignment_1 ) ) ;
    public final void rule__SystemInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:911:1: ( ( ( rule__SystemInstance__NameAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:912:1: ( ( rule__SystemInstance__NameAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:912:1: ( ( rule__SystemInstance__NameAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:913:1: ( rule__SystemInstance__NameAssignment_1 )
            {
             before(grammarAccess.getSystemInstanceAccess().getNameAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:914:1: ( rule__SystemInstance__NameAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:914:2: rule__SystemInstance__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SystemInstance__NameAssignment_1_in_rule__SystemInstance__Group__1__Impl1953);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:924:1: rule__SystemInstance__Group__2 : rule__SystemInstance__Group__2__Impl rule__SystemInstance__Group__3 ;
    public final void rule__SystemInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:928:1: ( rule__SystemInstance__Group__2__Impl rule__SystemInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:929:2: rule__SystemInstance__Group__2__Impl rule__SystemInstance__Group__3
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__2__Impl_in_rule__SystemInstance__Group__21983);
            rule__SystemInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__3_in_rule__SystemInstance__Group__21986);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:936:1: rule__SystemInstance__Group__2__Impl : ( ':' ) ;
    public final void rule__SystemInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:940:1: ( ( ':' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:941:1: ( ':' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:941:1: ( ':' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:942:1: ':'
            {
             before(grammarAccess.getSystemInstanceAccess().getColonKeyword_2()); 
            match(input,38,FOLLOW_38_in_rule__SystemInstance__Group__2__Impl2014); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:967:1: rule__SystemInstance__Group__3__Impl : ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) ) ;
    public final void rule__SystemInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:971:1: ( ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:972:1: ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:972:1: ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:973:1: ( rule__SystemInstance__ComponentImplementationAssignment_3 )
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentImplementationAssignment_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:974:1: ( rule__SystemInstance__ComponentImplementationAssignment_3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:974:2: rule__SystemInstance__ComponentImplementationAssignment_3
            {
            pushFollow(FOLLOW_rule__SystemInstance__ComponentImplementationAssignment_3_in_rule__SystemInstance__Group__3__Impl2075);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:984:1: rule__SystemInstance__Group__4 : rule__SystemInstance__Group__4__Impl rule__SystemInstance__Group__5 ;
    public final void rule__SystemInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:988:1: ( rule__SystemInstance__Group__4__Impl rule__SystemInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:989:2: rule__SystemInstance__Group__4__Impl rule__SystemInstance__Group__5
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__4__Impl_in_rule__SystemInstance__Group__42105);
            rule__SystemInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__5_in_rule__SystemInstance__Group__42108);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:996:1: rule__SystemInstance__Group__4__Impl : ( '{' ) ;
    public final void rule__SystemInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1000:1: ( ( '{' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1001:1: ( '{' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1001:1: ( '{' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1002:1: '{'
            {
             before(grammarAccess.getSystemInstanceAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,39,FOLLOW_39_in_rule__SystemInstance__Group__4__Impl2136); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1027:1: rule__SystemInstance__Group__5__Impl : ( ( rule__SystemInstance__SystemOperationModeAssignment_5 )* ) ;
    public final void rule__SystemInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1031:1: ( ( ( rule__SystemInstance__SystemOperationModeAssignment_5 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1032:1: ( ( rule__SystemInstance__SystemOperationModeAssignment_5 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1032:1: ( ( rule__SystemInstance__SystemOperationModeAssignment_5 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1033:1: ( rule__SystemInstance__SystemOperationModeAssignment_5 )*
            {
             before(grammarAccess.getSystemInstanceAccess().getSystemOperationModeAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1034:1: ( rule__SystemInstance__SystemOperationModeAssignment_5 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==52) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1034:2: rule__SystemInstance__SystemOperationModeAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__SystemInstance__SystemOperationModeAssignment_5_in_rule__SystemInstance__Group__5__Impl2197);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1044:1: rule__SystemInstance__Group__6 : rule__SystemInstance__Group__6__Impl ;
    public final void rule__SystemInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1048:1: ( rule__SystemInstance__Group__6__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1049:2: rule__SystemInstance__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__6__Impl_in_rule__SystemInstance__Group__62228);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1055:1: rule__SystemInstance__Group__6__Impl : ( '}' ) ;
    public final void rule__SystemInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1059:1: ( ( '}' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1060:1: ( '}' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1060:1: ( '}' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1061:1: '}'
            {
             before(grammarAccess.getSystemInstanceAccess().getRightCurlyBracketKeyword_6()); 
            match(input,40,FOLLOW_40_in_rule__SystemInstance__Group__6__Impl2256); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1088:1: rule__ComponentInstance__Group__0 : rule__ComponentInstance__Group__0__Impl rule__ComponentInstance__Group__1 ;
    public final void rule__ComponentInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1092:1: ( rule__ComponentInstance__Group__0__Impl rule__ComponentInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1093:2: rule__ComponentInstance__Group__0__Impl rule__ComponentInstance__Group__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__0__Impl_in_rule__ComponentInstance__Group__02301);
            rule__ComponentInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__1_in_rule__ComponentInstance__Group__02304);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1100:1: rule__ComponentInstance__Group__0__Impl : ( ( rule__ComponentInstance__CategoryAssignment_0 ) ) ;
    public final void rule__ComponentInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1104:1: ( ( ( rule__ComponentInstance__CategoryAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1105:1: ( ( rule__ComponentInstance__CategoryAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1105:1: ( ( rule__ComponentInstance__CategoryAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1106:1: ( rule__ComponentInstance__CategoryAssignment_0 )
            {
             before(grammarAccess.getComponentInstanceAccess().getCategoryAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1107:1: ( rule__ComponentInstance__CategoryAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1107:2: rule__ComponentInstance__CategoryAssignment_0
            {
            pushFollow(FOLLOW_rule__ComponentInstance__CategoryAssignment_0_in_rule__ComponentInstance__Group__0__Impl2331);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1117:1: rule__ComponentInstance__Group__1 : rule__ComponentInstance__Group__1__Impl rule__ComponentInstance__Group__2 ;
    public final void rule__ComponentInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1121:1: ( rule__ComponentInstance__Group__1__Impl rule__ComponentInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1122:2: rule__ComponentInstance__Group__1__Impl rule__ComponentInstance__Group__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__1__Impl_in_rule__ComponentInstance__Group__12361);
            rule__ComponentInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__2_in_rule__ComponentInstance__Group__12364);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1129:1: rule__ComponentInstance__Group__1__Impl : ( 'instance' ) ;
    public final void rule__ComponentInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1133:1: ( ( 'instance' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1134:1: ( 'instance' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1134:1: ( 'instance' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1135:1: 'instance'
            {
             before(grammarAccess.getComponentInstanceAccess().getInstanceKeyword_1()); 
            match(input,41,FOLLOW_41_in_rule__ComponentInstance__Group__1__Impl2392); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1148:1: rule__ComponentInstance__Group__2 : rule__ComponentInstance__Group__2__Impl rule__ComponentInstance__Group__3 ;
    public final void rule__ComponentInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1152:1: ( rule__ComponentInstance__Group__2__Impl rule__ComponentInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1153:2: rule__ComponentInstance__Group__2__Impl rule__ComponentInstance__Group__3
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__2__Impl_in_rule__ComponentInstance__Group__22423);
            rule__ComponentInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__3_in_rule__ComponentInstance__Group__22426);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1160:1: rule__ComponentInstance__Group__2__Impl : ( ( rule__ComponentInstance__NameAssignment_2 ) ) ;
    public final void rule__ComponentInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1164:1: ( ( ( rule__ComponentInstance__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1165:1: ( ( rule__ComponentInstance__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1165:1: ( ( rule__ComponentInstance__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1166:1: ( rule__ComponentInstance__NameAssignment_2 )
            {
             before(grammarAccess.getComponentInstanceAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1167:1: ( rule__ComponentInstance__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1167:2: rule__ComponentInstance__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__NameAssignment_2_in_rule__ComponentInstance__Group__2__Impl2453);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1177:1: rule__ComponentInstance__Group__3 : rule__ComponentInstance__Group__3__Impl rule__ComponentInstance__Group__4 ;
    public final void rule__ComponentInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1181:1: ( rule__ComponentInstance__Group__3__Impl rule__ComponentInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1182:2: rule__ComponentInstance__Group__3__Impl rule__ComponentInstance__Group__4
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__3__Impl_in_rule__ComponentInstance__Group__32483);
            rule__ComponentInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__4_in_rule__ComponentInstance__Group__32486);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1189:1: rule__ComponentInstance__Group__3__Impl : ( ( rule__ComponentInstance__Group_3__0 )? ) ;
    public final void rule__ComponentInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1193:1: ( ( ( rule__ComponentInstance__Group_3__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1194:1: ( ( rule__ComponentInstance__Group_3__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1194:1: ( ( rule__ComponentInstance__Group_3__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1195:1: ( rule__ComponentInstance__Group_3__0 )?
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1196:1: ( rule__ComponentInstance__Group_3__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==44) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1196:2: rule__ComponentInstance__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__Group_3__0_in_rule__ComponentInstance__Group__3__Impl2513);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1206:1: rule__ComponentInstance__Group__4 : rule__ComponentInstance__Group__4__Impl rule__ComponentInstance__Group__5 ;
    public final void rule__ComponentInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1210:1: ( rule__ComponentInstance__Group__4__Impl rule__ComponentInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1211:2: rule__ComponentInstance__Group__4__Impl rule__ComponentInstance__Group__5
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__4__Impl_in_rule__ComponentInstance__Group__42544);
            rule__ComponentInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__5_in_rule__ComponentInstance__Group__42547);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1218:1: rule__ComponentInstance__Group__4__Impl : ( 'of' ) ;
    public final void rule__ComponentInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1222:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1223:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1223:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1224:1: 'of'
            {
             before(grammarAccess.getComponentInstanceAccess().getOfKeyword_4()); 
            match(input,42,FOLLOW_42_in_rule__ComponentInstance__Group__4__Impl2575); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1237:1: rule__ComponentInstance__Group__5 : rule__ComponentInstance__Group__5__Impl rule__ComponentInstance__Group__6 ;
    public final void rule__ComponentInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1241:1: ( rule__ComponentInstance__Group__5__Impl rule__ComponentInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1242:2: rule__ComponentInstance__Group__5__Impl rule__ComponentInstance__Group__6
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__5__Impl_in_rule__ComponentInstance__Group__52606);
            rule__ComponentInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__6_in_rule__ComponentInstance__Group__52609);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1249:1: rule__ComponentInstance__Group__5__Impl : ( ( rule__ComponentInstance__SubcomponentAssignment_5 ) ) ;
    public final void rule__ComponentInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1253:1: ( ( ( rule__ComponentInstance__SubcomponentAssignment_5 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1254:1: ( ( rule__ComponentInstance__SubcomponentAssignment_5 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1254:1: ( ( rule__ComponentInstance__SubcomponentAssignment_5 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1255:1: ( rule__ComponentInstance__SubcomponentAssignment_5 )
            {
             before(grammarAccess.getComponentInstanceAccess().getSubcomponentAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1256:1: ( rule__ComponentInstance__SubcomponentAssignment_5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1256:2: rule__ComponentInstance__SubcomponentAssignment_5
            {
            pushFollow(FOLLOW_rule__ComponentInstance__SubcomponentAssignment_5_in_rule__ComponentInstance__Group__5__Impl2636);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1266:1: rule__ComponentInstance__Group__6 : rule__ComponentInstance__Group__6__Impl rule__ComponentInstance__Group__7 ;
    public final void rule__ComponentInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1270:1: ( rule__ComponentInstance__Group__6__Impl rule__ComponentInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1271:2: rule__ComponentInstance__Group__6__Impl rule__ComponentInstance__Group__7
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__6__Impl_in_rule__ComponentInstance__Group__62666);
            rule__ComponentInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__7_in_rule__ComponentInstance__Group__62669);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1278:1: rule__ComponentInstance__Group__6__Impl : ( ( rule__ComponentInstance__FeatureInstanceAssignment_6 )* ) ;
    public final void rule__ComponentInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1282:1: ( ( ( rule__ComponentInstance__FeatureInstanceAssignment_6 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1283:1: ( ( rule__ComponentInstance__FeatureInstanceAssignment_6 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1283:1: ( ( rule__ComponentInstance__FeatureInstanceAssignment_6 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1284:1: ( rule__ComponentInstance__FeatureInstanceAssignment_6 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getFeatureInstanceAssignment_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1285:1: ( rule__ComponentInstance__FeatureInstanceAssignment_6 )*
            loop7:
            do {
                int alt7=2;
                switch ( input.LA(1) ) {
                case 24:
                    {
                    int LA7_2 = input.LA(2);

                    if ( (LA7_2==41) ) {
                        alt7=1;
                    }


                    }
                    break;
                case 29:
                    {
                    int LA7_3 = input.LA(2);

                    if ( (LA7_3==41) ) {
                        alt7=1;
                    }


                    }
                    break;
                case 21:
                case 22:
                case 23:
                case 25:
                case 26:
                case 27:
                case 28:
                case 30:
                    {
                    alt7=1;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1285:2: rule__ComponentInstance__FeatureInstanceAssignment_6
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__FeatureInstanceAssignment_6_in_rule__ComponentInstance__Group__6__Impl2696);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1295:1: rule__ComponentInstance__Group__7 : rule__ComponentInstance__Group__7__Impl rule__ComponentInstance__Group__8 ;
    public final void rule__ComponentInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1299:1: ( rule__ComponentInstance__Group__7__Impl rule__ComponentInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1300:2: rule__ComponentInstance__Group__7__Impl rule__ComponentInstance__Group__8
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__7__Impl_in_rule__ComponentInstance__Group__72727);
            rule__ComponentInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__8_in_rule__ComponentInstance__Group__72730);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1307:1: rule__ComponentInstance__Group__7__Impl : ( ( rule__ComponentInstance__ComponentInstanceAssignment_7 )* ) ;
    public final void rule__ComponentInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1311:1: ( ( ( rule__ComponentInstance__ComponentInstanceAssignment_7 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1312:1: ( ( rule__ComponentInstance__ComponentInstanceAssignment_7 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1312:1: ( ( rule__ComponentInstance__ComponentInstanceAssignment_7 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1313:1: ( rule__ComponentInstance__ComponentInstanceAssignment_7 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getComponentInstanceAssignment_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1314:1: ( rule__ComponentInstance__ComponentInstanceAssignment_7 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=9 && LA8_0<=20)||LA8_0==56) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1314:2: rule__ComponentInstance__ComponentInstanceAssignment_7
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__ComponentInstanceAssignment_7_in_rule__ComponentInstance__Group__7__Impl2757);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1324:1: rule__ComponentInstance__Group__8 : rule__ComponentInstance__Group__8__Impl rule__ComponentInstance__Group__9 ;
    public final void rule__ComponentInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1328:1: ( rule__ComponentInstance__Group__8__Impl rule__ComponentInstance__Group__9 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1329:2: rule__ComponentInstance__Group__8__Impl rule__ComponentInstance__Group__9
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__8__Impl_in_rule__ComponentInstance__Group__82788);
            rule__ComponentInstance__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__9_in_rule__ComponentInstance__Group__82791);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1336:1: rule__ComponentInstance__Group__8__Impl : ( ( rule__ComponentInstance__ModeInstanceAssignment_8 )* ) ;
    public final void rule__ComponentInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1340:1: ( ( ( rule__ComponentInstance__ModeInstanceAssignment_8 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1341:1: ( ( rule__ComponentInstance__ModeInstanceAssignment_8 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1341:1: ( ( rule__ComponentInstance__ModeInstanceAssignment_8 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1342:1: ( rule__ComponentInstance__ModeInstanceAssignment_8 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getModeInstanceAssignment_8()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1343:1: ( rule__ComponentInstance__ModeInstanceAssignment_8 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==46) ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1==41) ) {
                        alt9=1;
                    }


                }


                switch (alt9) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1343:2: rule__ComponentInstance__ModeInstanceAssignment_8
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__ModeInstanceAssignment_8_in_rule__ComponentInstance__Group__8__Impl2818);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1353:1: rule__ComponentInstance__Group__9 : rule__ComponentInstance__Group__9__Impl rule__ComponentInstance__Group__10 ;
    public final void rule__ComponentInstance__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1357:1: ( rule__ComponentInstance__Group__9__Impl rule__ComponentInstance__Group__10 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1358:2: rule__ComponentInstance__Group__9__Impl rule__ComponentInstance__Group__10
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__9__Impl_in_rule__ComponentInstance__Group__92849);
            rule__ComponentInstance__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__10_in_rule__ComponentInstance__Group__92852);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1365:1: rule__ComponentInstance__Group__9__Impl : ( ( rule__ComponentInstance__ModeTransitionInstanceAssignment_9 )* ) ;
    public final void rule__ComponentInstance__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1369:1: ( ( ( rule__ComponentInstance__ModeTransitionInstanceAssignment_9 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1370:1: ( ( rule__ComponentInstance__ModeTransitionInstanceAssignment_9 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1370:1: ( ( rule__ComponentInstance__ModeTransitionInstanceAssignment_9 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1371:1: ( rule__ComponentInstance__ModeTransitionInstanceAssignment_9 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getModeTransitionInstanceAssignment_9()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1372:1: ( rule__ComponentInstance__ModeTransitionInstanceAssignment_9 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==46) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1372:2: rule__ComponentInstance__ModeTransitionInstanceAssignment_9
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__ModeTransitionInstanceAssignment_9_in_rule__ComponentInstance__Group__9__Impl2879);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1382:1: rule__ComponentInstance__Group__10 : rule__ComponentInstance__Group__10__Impl rule__ComponentInstance__Group__11 ;
    public final void rule__ComponentInstance__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1386:1: ( rule__ComponentInstance__Group__10__Impl rule__ComponentInstance__Group__11 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1387:2: rule__ComponentInstance__Group__10__Impl rule__ComponentInstance__Group__11
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__10__Impl_in_rule__ComponentInstance__Group__102910);
            rule__ComponentInstance__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__11_in_rule__ComponentInstance__Group__102913);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1394:1: rule__ComponentInstance__Group__10__Impl : ( ( rule__ComponentInstance__FlowSpecificationAssignment_10 )* ) ;
    public final void rule__ComponentInstance__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1398:1: ( ( ( rule__ComponentInstance__FlowSpecificationAssignment_10 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1399:1: ( ( rule__ComponentInstance__FlowSpecificationAssignment_10 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1399:1: ( ( rule__ComponentInstance__FlowSpecificationAssignment_10 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1400:1: ( rule__ComponentInstance__FlowSpecificationAssignment_10 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getFlowSpecificationAssignment_10()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1401:1: ( rule__ComponentInstance__FlowSpecificationAssignment_10 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==50) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1401:2: rule__ComponentInstance__FlowSpecificationAssignment_10
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__FlowSpecificationAssignment_10_in_rule__ComponentInstance__Group__10__Impl2940);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1411:1: rule__ComponentInstance__Group__11 : rule__ComponentInstance__Group__11__Impl rule__ComponentInstance__Group__12 ;
    public final void rule__ComponentInstance__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1415:1: ( rule__ComponentInstance__Group__11__Impl rule__ComponentInstance__Group__12 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1416:2: rule__ComponentInstance__Group__11__Impl rule__ComponentInstance__Group__12
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__11__Impl_in_rule__ComponentInstance__Group__112971);
            rule__ComponentInstance__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__12_in_rule__ComponentInstance__Group__112974);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1423:1: rule__ComponentInstance__Group__11__Impl : ( ( rule__ComponentInstance__EndToEndFlowAssignment_11 )* ) ;
    public final void rule__ComponentInstance__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1427:1: ( ( ( rule__ComponentInstance__EndToEndFlowAssignment_11 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1428:1: ( ( rule__ComponentInstance__EndToEndFlowAssignment_11 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1428:1: ( ( rule__ComponentInstance__EndToEndFlowAssignment_11 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1429:1: ( rule__ComponentInstance__EndToEndFlowAssignment_11 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getEndToEndFlowAssignment_11()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1430:1: ( rule__ComponentInstance__EndToEndFlowAssignment_11 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==51) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1430:2: rule__ComponentInstance__EndToEndFlowAssignment_11
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__EndToEndFlowAssignment_11_in_rule__ComponentInstance__Group__11__Impl3001);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1440:1: rule__ComponentInstance__Group__12 : rule__ComponentInstance__Group__12__Impl rule__ComponentInstance__Group__13 ;
    public final void rule__ComponentInstance__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1444:1: ( rule__ComponentInstance__Group__12__Impl rule__ComponentInstance__Group__13 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1445:2: rule__ComponentInstance__Group__12__Impl rule__ComponentInstance__Group__13
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__12__Impl_in_rule__ComponentInstance__Group__123032);
            rule__ComponentInstance__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__13_in_rule__ComponentInstance__Group__123035);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1452:1: rule__ComponentInstance__Group__12__Impl : ( ( rule__ComponentInstance__ConnectionInstanceAssignment_12 )* ) ;
    public final void rule__ComponentInstance__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1456:1: ( ( ( rule__ComponentInstance__ConnectionInstanceAssignment_12 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1457:1: ( ( rule__ComponentInstance__ConnectionInstanceAssignment_12 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1457:1: ( ( rule__ComponentInstance__ConnectionInstanceAssignment_12 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1458:1: ( rule__ComponentInstance__ConnectionInstanceAssignment_12 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getConnectionInstanceAssignment_12()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1459:1: ( rule__ComponentInstance__ConnectionInstanceAssignment_12 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==24||LA13_0==29||(LA13_0>=34 && LA13_0<=37)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1459:2: rule__ComponentInstance__ConnectionInstanceAssignment_12
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__ConnectionInstanceAssignment_12_in_rule__ComponentInstance__Group__12__Impl3062);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1469:1: rule__ComponentInstance__Group__13 : rule__ComponentInstance__Group__13__Impl rule__ComponentInstance__Group__14 ;
    public final void rule__ComponentInstance__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1473:1: ( rule__ComponentInstance__Group__13__Impl rule__ComponentInstance__Group__14 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1474:2: rule__ComponentInstance__Group__13__Impl rule__ComponentInstance__Group__14
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__13__Impl_in_rule__ComponentInstance__Group__133093);
            rule__ComponentInstance__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__14_in_rule__ComponentInstance__Group__133096);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1481:1: rule__ComponentInstance__Group__13__Impl : ( ( rule__ComponentInstance__Group_13__0 )? ) ;
    public final void rule__ComponentInstance__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1485:1: ( ( ( rule__ComponentInstance__Group_13__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1486:1: ( ( rule__ComponentInstance__Group_13__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1486:1: ( ( rule__ComponentInstance__Group_13__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1487:1: ( rule__ComponentInstance__Group_13__0 )?
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup_13()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1488:1: ( rule__ComponentInstance__Group_13__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==31) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1488:2: rule__ComponentInstance__Group_13__0
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__Group_13__0_in_rule__ComponentInstance__Group__13__Impl3123);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1498:1: rule__ComponentInstance__Group__14 : rule__ComponentInstance__Group__14__Impl ;
    public final void rule__ComponentInstance__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1502:1: ( rule__ComponentInstance__Group__14__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1503:2: rule__ComponentInstance__Group__14__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__14__Impl_in_rule__ComponentInstance__Group__143154);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1509:1: rule__ComponentInstance__Group__14__Impl : ( 'end' ) ;
    public final void rule__ComponentInstance__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1513:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1514:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1514:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1515:1: 'end'
            {
             before(grammarAccess.getComponentInstanceAccess().getEndKeyword_14()); 
            match(input,43,FOLLOW_43_in_rule__ComponentInstance__Group__14__Impl3182); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1558:1: rule__ComponentInstance__Group_3__0 : rule__ComponentInstance__Group_3__0__Impl rule__ComponentInstance__Group_3__1 ;
    public final void rule__ComponentInstance__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1562:1: ( rule__ComponentInstance__Group_3__0__Impl rule__ComponentInstance__Group_3__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1563:2: rule__ComponentInstance__Group_3__0__Impl rule__ComponentInstance__Group_3__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_3__0__Impl_in_rule__ComponentInstance__Group_3__03243);
            rule__ComponentInstance__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_3__1_in_rule__ComponentInstance__Group_3__03246);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1570:1: rule__ComponentInstance__Group_3__0__Impl : ( '[' ) ;
    public final void rule__ComponentInstance__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1574:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1575:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1575:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1576:1: '['
            {
             before(grammarAccess.getComponentInstanceAccess().getLeftSquareBracketKeyword_3_0()); 
            match(input,44,FOLLOW_44_in_rule__ComponentInstance__Group_3__0__Impl3274); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1589:1: rule__ComponentInstance__Group_3__1 : rule__ComponentInstance__Group_3__1__Impl rule__ComponentInstance__Group_3__2 ;
    public final void rule__ComponentInstance__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1593:1: ( rule__ComponentInstance__Group_3__1__Impl rule__ComponentInstance__Group_3__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1594:2: rule__ComponentInstance__Group_3__1__Impl rule__ComponentInstance__Group_3__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_3__1__Impl_in_rule__ComponentInstance__Group_3__13305);
            rule__ComponentInstance__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_3__2_in_rule__ComponentInstance__Group_3__13308);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1601:1: rule__ComponentInstance__Group_3__1__Impl : ( ( ( rule__ComponentInstance__IndexAssignment_3_1 ) ) ( ( rule__ComponentInstance__IndexAssignment_3_1 )* ) ) ;
    public final void rule__ComponentInstance__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1605:1: ( ( ( ( rule__ComponentInstance__IndexAssignment_3_1 ) ) ( ( rule__ComponentInstance__IndexAssignment_3_1 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1606:1: ( ( ( rule__ComponentInstance__IndexAssignment_3_1 ) ) ( ( rule__ComponentInstance__IndexAssignment_3_1 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1606:1: ( ( ( rule__ComponentInstance__IndexAssignment_3_1 ) ) ( ( rule__ComponentInstance__IndexAssignment_3_1 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1607:1: ( ( rule__ComponentInstance__IndexAssignment_3_1 ) ) ( ( rule__ComponentInstance__IndexAssignment_3_1 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1607:1: ( ( rule__ComponentInstance__IndexAssignment_3_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1608:1: ( rule__ComponentInstance__IndexAssignment_3_1 )
            {
             before(grammarAccess.getComponentInstanceAccess().getIndexAssignment_3_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1609:1: ( rule__ComponentInstance__IndexAssignment_3_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1609:2: rule__ComponentInstance__IndexAssignment_3_1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__IndexAssignment_3_1_in_rule__ComponentInstance__Group_3__1__Impl3337);
            rule__ComponentInstance__IndexAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getComponentInstanceAccess().getIndexAssignment_3_1()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1612:1: ( ( rule__ComponentInstance__IndexAssignment_3_1 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1613:1: ( rule__ComponentInstance__IndexAssignment_3_1 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getIndexAssignment_3_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1614:1: ( rule__ComponentInstance__IndexAssignment_3_1 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_INTEGER_LIT) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1614:2: rule__ComponentInstance__IndexAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__IndexAssignment_3_1_in_rule__ComponentInstance__Group_3__1__Impl3349);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1625:1: rule__ComponentInstance__Group_3__2 : rule__ComponentInstance__Group_3__2__Impl ;
    public final void rule__ComponentInstance__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1629:1: ( rule__ComponentInstance__Group_3__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1630:2: rule__ComponentInstance__Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_3__2__Impl_in_rule__ComponentInstance__Group_3__23382);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1636:1: rule__ComponentInstance__Group_3__2__Impl : ( ']' ) ;
    public final void rule__ComponentInstance__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1640:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1641:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1641:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1642:1: ']'
            {
             before(grammarAccess.getComponentInstanceAccess().getRightSquareBracketKeyword_3_2()); 
            match(input,45,FOLLOW_45_in_rule__ComponentInstance__Group_3__2__Impl3410); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1661:1: rule__ComponentInstance__Group_13__0 : rule__ComponentInstance__Group_13__0__Impl rule__ComponentInstance__Group_13__1 ;
    public final void rule__ComponentInstance__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1665:1: ( rule__ComponentInstance__Group_13__0__Impl rule__ComponentInstance__Group_13__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1666:2: rule__ComponentInstance__Group_13__0__Impl rule__ComponentInstance__Group_13__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_13__0__Impl_in_rule__ComponentInstance__Group_13__03447);
            rule__ComponentInstance__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_13__1_in_rule__ComponentInstance__Group_13__03450);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1673:1: rule__ComponentInstance__Group_13__0__Impl : ( 'in' ) ;
    public final void rule__ComponentInstance__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1677:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1678:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1678:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1679:1: 'in'
            {
             before(grammarAccess.getComponentInstanceAccess().getInKeyword_13_0()); 
            match(input,31,FOLLOW_31_in_rule__ComponentInstance__Group_13__0__Impl3478); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1692:1: rule__ComponentInstance__Group_13__1 : rule__ComponentInstance__Group_13__1__Impl rule__ComponentInstance__Group_13__2 ;
    public final void rule__ComponentInstance__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1696:1: ( rule__ComponentInstance__Group_13__1__Impl rule__ComponentInstance__Group_13__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1697:2: rule__ComponentInstance__Group_13__1__Impl rule__ComponentInstance__Group_13__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_13__1__Impl_in_rule__ComponentInstance__Group_13__13509);
            rule__ComponentInstance__Group_13__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_13__2_in_rule__ComponentInstance__Group_13__13512);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1704:1: rule__ComponentInstance__Group_13__1__Impl : ( 'mode' ) ;
    public final void rule__ComponentInstance__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1708:1: ( ( 'mode' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1709:1: ( 'mode' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1709:1: ( 'mode' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1710:1: 'mode'
            {
             before(grammarAccess.getComponentInstanceAccess().getModeKeyword_13_1()); 
            match(input,46,FOLLOW_46_in_rule__ComponentInstance__Group_13__1__Impl3540); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1723:1: rule__ComponentInstance__Group_13__2 : rule__ComponentInstance__Group_13__2__Impl ;
    public final void rule__ComponentInstance__Group_13__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1727:1: ( rule__ComponentInstance__Group_13__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1728:2: rule__ComponentInstance__Group_13__2__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_13__2__Impl_in_rule__ComponentInstance__Group_13__23571);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1734:1: rule__ComponentInstance__Group_13__2__Impl : ( ( rule__ComponentInstance__InModeAssignment_13_2 ) ) ;
    public final void rule__ComponentInstance__Group_13__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1738:1: ( ( ( rule__ComponentInstance__InModeAssignment_13_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1739:1: ( ( rule__ComponentInstance__InModeAssignment_13_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1739:1: ( ( rule__ComponentInstance__InModeAssignment_13_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1740:1: ( rule__ComponentInstance__InModeAssignment_13_2 )
            {
             before(grammarAccess.getComponentInstanceAccess().getInModeAssignment_13_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1741:1: ( rule__ComponentInstance__InModeAssignment_13_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1741:2: rule__ComponentInstance__InModeAssignment_13_2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__InModeAssignment_13_2_in_rule__ComponentInstance__Group_13__2__Impl3598);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1757:1: rule__FeatureInstance__Group__0 : rule__FeatureInstance__Group__0__Impl rule__FeatureInstance__Group__1 ;
    public final void rule__FeatureInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1761:1: ( rule__FeatureInstance__Group__0__Impl rule__FeatureInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1762:2: rule__FeatureInstance__Group__0__Impl rule__FeatureInstance__Group__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__0__Impl_in_rule__FeatureInstance__Group__03634);
            rule__FeatureInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__1_in_rule__FeatureInstance__Group__03637);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1769:1: rule__FeatureInstance__Group__0__Impl : ( ( rule__FeatureInstance__CategoryAssignment_0 ) ) ;
    public final void rule__FeatureInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1773:1: ( ( ( rule__FeatureInstance__CategoryAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1774:1: ( ( rule__FeatureInstance__CategoryAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1774:1: ( ( rule__FeatureInstance__CategoryAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1775:1: ( rule__FeatureInstance__CategoryAssignment_0 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getCategoryAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1776:1: ( rule__FeatureInstance__CategoryAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1776:2: rule__FeatureInstance__CategoryAssignment_0
            {
            pushFollow(FOLLOW_rule__FeatureInstance__CategoryAssignment_0_in_rule__FeatureInstance__Group__0__Impl3664);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1786:1: rule__FeatureInstance__Group__1 : rule__FeatureInstance__Group__1__Impl rule__FeatureInstance__Group__2 ;
    public final void rule__FeatureInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1790:1: ( rule__FeatureInstance__Group__1__Impl rule__FeatureInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1791:2: rule__FeatureInstance__Group__1__Impl rule__FeatureInstance__Group__2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__1__Impl_in_rule__FeatureInstance__Group__13694);
            rule__FeatureInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__2_in_rule__FeatureInstance__Group__13697);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1798:1: rule__FeatureInstance__Group__1__Impl : ( 'instance' ) ;
    public final void rule__FeatureInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1802:1: ( ( 'instance' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1803:1: ( 'instance' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1803:1: ( 'instance' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1804:1: 'instance'
            {
             before(grammarAccess.getFeatureInstanceAccess().getInstanceKeyword_1()); 
            match(input,41,FOLLOW_41_in_rule__FeatureInstance__Group__1__Impl3725); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1817:1: rule__FeatureInstance__Group__2 : rule__FeatureInstance__Group__2__Impl rule__FeatureInstance__Group__3 ;
    public final void rule__FeatureInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1821:1: ( rule__FeatureInstance__Group__2__Impl rule__FeatureInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1822:2: rule__FeatureInstance__Group__2__Impl rule__FeatureInstance__Group__3
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__2__Impl_in_rule__FeatureInstance__Group__23756);
            rule__FeatureInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__3_in_rule__FeatureInstance__Group__23759);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1829:1: rule__FeatureInstance__Group__2__Impl : ( ( rule__FeatureInstance__NameAssignment_2 ) ) ;
    public final void rule__FeatureInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1833:1: ( ( ( rule__FeatureInstance__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1834:1: ( ( rule__FeatureInstance__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1834:1: ( ( rule__FeatureInstance__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1835:1: ( rule__FeatureInstance__NameAssignment_2 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1836:1: ( rule__FeatureInstance__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1836:2: rule__FeatureInstance__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__NameAssignment_2_in_rule__FeatureInstance__Group__2__Impl3786);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1846:1: rule__FeatureInstance__Group__3 : rule__FeatureInstance__Group__3__Impl rule__FeatureInstance__Group__4 ;
    public final void rule__FeatureInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1850:1: ( rule__FeatureInstance__Group__3__Impl rule__FeatureInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1851:2: rule__FeatureInstance__Group__3__Impl rule__FeatureInstance__Group__4
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__3__Impl_in_rule__FeatureInstance__Group__33816);
            rule__FeatureInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__4_in_rule__FeatureInstance__Group__33819);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1858:1: rule__FeatureInstance__Group__3__Impl : ( ( rule__FeatureInstance__Group_3__0 )? ) ;
    public final void rule__FeatureInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1862:1: ( ( ( rule__FeatureInstance__Group_3__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1863:1: ( ( rule__FeatureInstance__Group_3__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1863:1: ( ( rule__FeatureInstance__Group_3__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1864:1: ( rule__FeatureInstance__Group_3__0 )?
            {
             before(grammarAccess.getFeatureInstanceAccess().getGroup_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1865:1: ( rule__FeatureInstance__Group_3__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==44) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1865:2: rule__FeatureInstance__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__FeatureInstance__Group_3__0_in_rule__FeatureInstance__Group__3__Impl3846);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1875:1: rule__FeatureInstance__Group__4 : rule__FeatureInstance__Group__4__Impl rule__FeatureInstance__Group__5 ;
    public final void rule__FeatureInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1879:1: ( rule__FeatureInstance__Group__4__Impl rule__FeatureInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1880:2: rule__FeatureInstance__Group__4__Impl rule__FeatureInstance__Group__5
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__4__Impl_in_rule__FeatureInstance__Group__43877);
            rule__FeatureInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__5_in_rule__FeatureInstance__Group__43880);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1887:1: rule__FeatureInstance__Group__4__Impl : ( 'of' ) ;
    public final void rule__FeatureInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1891:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1892:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1892:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1893:1: 'of'
            {
             before(grammarAccess.getFeatureInstanceAccess().getOfKeyword_4()); 
            match(input,42,FOLLOW_42_in_rule__FeatureInstance__Group__4__Impl3908); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1906:1: rule__FeatureInstance__Group__5 : rule__FeatureInstance__Group__5__Impl rule__FeatureInstance__Group__6 ;
    public final void rule__FeatureInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1910:1: ( rule__FeatureInstance__Group__5__Impl rule__FeatureInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1911:2: rule__FeatureInstance__Group__5__Impl rule__FeatureInstance__Group__6
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__5__Impl_in_rule__FeatureInstance__Group__53939);
            rule__FeatureInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__6_in_rule__FeatureInstance__Group__53942);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1918:1: rule__FeatureInstance__Group__5__Impl : ( ( rule__FeatureInstance__FeatureAssignment_5 ) ) ;
    public final void rule__FeatureInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1922:1: ( ( ( rule__FeatureInstance__FeatureAssignment_5 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1923:1: ( ( rule__FeatureInstance__FeatureAssignment_5 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1923:1: ( ( rule__FeatureInstance__FeatureAssignment_5 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1924:1: ( rule__FeatureInstance__FeatureAssignment_5 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1925:1: ( rule__FeatureInstance__FeatureAssignment_5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1925:2: rule__FeatureInstance__FeatureAssignment_5
            {
            pushFollow(FOLLOW_rule__FeatureInstance__FeatureAssignment_5_in_rule__FeatureInstance__Group__5__Impl3969);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1935:1: rule__FeatureInstance__Group__6 : rule__FeatureInstance__Group__6__Impl rule__FeatureInstance__Group__7 ;
    public final void rule__FeatureInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1939:1: ( rule__FeatureInstance__Group__6__Impl rule__FeatureInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1940:2: rule__FeatureInstance__Group__6__Impl rule__FeatureInstance__Group__7
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__6__Impl_in_rule__FeatureInstance__Group__63999);
            rule__FeatureInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__7_in_rule__FeatureInstance__Group__64002);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1947:1: rule__FeatureInstance__Group__6__Impl : ( ( rule__FeatureInstance__DirectionAssignment_6 ) ) ;
    public final void rule__FeatureInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1951:1: ( ( ( rule__FeatureInstance__DirectionAssignment_6 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1952:1: ( ( rule__FeatureInstance__DirectionAssignment_6 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1952:1: ( ( rule__FeatureInstance__DirectionAssignment_6 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1953:1: ( rule__FeatureInstance__DirectionAssignment_6 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getDirectionAssignment_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1954:1: ( rule__FeatureInstance__DirectionAssignment_6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1954:2: rule__FeatureInstance__DirectionAssignment_6
            {
            pushFollow(FOLLOW_rule__FeatureInstance__DirectionAssignment_6_in_rule__FeatureInstance__Group__6__Impl4029);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1964:1: rule__FeatureInstance__Group__7 : rule__FeatureInstance__Group__7__Impl rule__FeatureInstance__Group__8 ;
    public final void rule__FeatureInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1968:1: ( rule__FeatureInstance__Group__7__Impl rule__FeatureInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1969:2: rule__FeatureInstance__Group__7__Impl rule__FeatureInstance__Group__8
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__7__Impl_in_rule__FeatureInstance__Group__74059);
            rule__FeatureInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__8_in_rule__FeatureInstance__Group__74062);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1976:1: rule__FeatureInstance__Group__7__Impl : ( ( rule__FeatureInstance__FeatureInstanceAssignment_7 ) ) ;
    public final void rule__FeatureInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1980:1: ( ( ( rule__FeatureInstance__FeatureInstanceAssignment_7 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1981:1: ( ( rule__FeatureInstance__FeatureInstanceAssignment_7 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1981:1: ( ( rule__FeatureInstance__FeatureInstanceAssignment_7 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1982:1: ( rule__FeatureInstance__FeatureInstanceAssignment_7 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceAssignment_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1983:1: ( rule__FeatureInstance__FeatureInstanceAssignment_7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1983:2: rule__FeatureInstance__FeatureInstanceAssignment_7
            {
            pushFollow(FOLLOW_rule__FeatureInstance__FeatureInstanceAssignment_7_in_rule__FeatureInstance__Group__7__Impl4089);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1993:1: rule__FeatureInstance__Group__8 : rule__FeatureInstance__Group__8__Impl ;
    public final void rule__FeatureInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1997:1: ( rule__FeatureInstance__Group__8__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1998:2: rule__FeatureInstance__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__8__Impl_in_rule__FeatureInstance__Group__84119);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2004:1: rule__FeatureInstance__Group__8__Impl : ( 'end' ) ;
    public final void rule__FeatureInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2008:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2009:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2009:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2010:1: 'end'
            {
             before(grammarAccess.getFeatureInstanceAccess().getEndKeyword_8()); 
            match(input,43,FOLLOW_43_in_rule__FeatureInstance__Group__8__Impl4147); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2041:1: rule__FeatureInstance__Group_3__0 : rule__FeatureInstance__Group_3__0__Impl rule__FeatureInstance__Group_3__1 ;
    public final void rule__FeatureInstance__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2045:1: ( rule__FeatureInstance__Group_3__0__Impl rule__FeatureInstance__Group_3__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2046:2: rule__FeatureInstance__Group_3__0__Impl rule__FeatureInstance__Group_3__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__0__Impl_in_rule__FeatureInstance__Group_3__04196);
            rule__FeatureInstance__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__1_in_rule__FeatureInstance__Group_3__04199);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2053:1: rule__FeatureInstance__Group_3__0__Impl : ( '[' ) ;
    public final void rule__FeatureInstance__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2057:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2058:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2058:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2059:1: '['
            {
             before(grammarAccess.getFeatureInstanceAccess().getLeftSquareBracketKeyword_3_0()); 
            match(input,44,FOLLOW_44_in_rule__FeatureInstance__Group_3__0__Impl4227); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2072:1: rule__FeatureInstance__Group_3__1 : rule__FeatureInstance__Group_3__1__Impl rule__FeatureInstance__Group_3__2 ;
    public final void rule__FeatureInstance__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2076:1: ( rule__FeatureInstance__Group_3__1__Impl rule__FeatureInstance__Group_3__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2077:2: rule__FeatureInstance__Group_3__1__Impl rule__FeatureInstance__Group_3__2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__1__Impl_in_rule__FeatureInstance__Group_3__14258);
            rule__FeatureInstance__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__2_in_rule__FeatureInstance__Group_3__14261);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2084:1: rule__FeatureInstance__Group_3__1__Impl : ( ( rule__FeatureInstance__IndexAssignment_3_1 ) ) ;
    public final void rule__FeatureInstance__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2088:1: ( ( ( rule__FeatureInstance__IndexAssignment_3_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2089:1: ( ( rule__FeatureInstance__IndexAssignment_3_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2089:1: ( ( rule__FeatureInstance__IndexAssignment_3_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2090:1: ( rule__FeatureInstance__IndexAssignment_3_1 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getIndexAssignment_3_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2091:1: ( rule__FeatureInstance__IndexAssignment_3_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2091:2: rule__FeatureInstance__IndexAssignment_3_1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__IndexAssignment_3_1_in_rule__FeatureInstance__Group_3__1__Impl4288);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2101:1: rule__FeatureInstance__Group_3__2 : rule__FeatureInstance__Group_3__2__Impl ;
    public final void rule__FeatureInstance__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2105:1: ( rule__FeatureInstance__Group_3__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2106:2: rule__FeatureInstance__Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__2__Impl_in_rule__FeatureInstance__Group_3__24318);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2112:1: rule__FeatureInstance__Group_3__2__Impl : ( ']' ) ;
    public final void rule__FeatureInstance__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2116:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2117:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2117:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2118:1: ']'
            {
             before(grammarAccess.getFeatureInstanceAccess().getRightSquareBracketKeyword_3_2()); 
            match(input,45,FOLLOW_45_in_rule__FeatureInstance__Group_3__2__Impl4346); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2137:1: rule__ModeInstance__Group__0 : rule__ModeInstance__Group__0__Impl rule__ModeInstance__Group__1 ;
    public final void rule__ModeInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2141:1: ( rule__ModeInstance__Group__0__Impl rule__ModeInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2142:2: rule__ModeInstance__Group__0__Impl rule__ModeInstance__Group__1
            {
            pushFollow(FOLLOW_rule__ModeInstance__Group__0__Impl_in_rule__ModeInstance__Group__04383);
            rule__ModeInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeInstance__Group__1_in_rule__ModeInstance__Group__04386);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2149:1: rule__ModeInstance__Group__0__Impl : ( 'mode' ) ;
    public final void rule__ModeInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2153:1: ( ( 'mode' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2154:1: ( 'mode' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2154:1: ( 'mode' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2155:1: 'mode'
            {
             before(grammarAccess.getModeInstanceAccess().getModeKeyword_0()); 
            match(input,46,FOLLOW_46_in_rule__ModeInstance__Group__0__Impl4414); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2168:1: rule__ModeInstance__Group__1 : rule__ModeInstance__Group__1__Impl rule__ModeInstance__Group__2 ;
    public final void rule__ModeInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2172:1: ( rule__ModeInstance__Group__1__Impl rule__ModeInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2173:2: rule__ModeInstance__Group__1__Impl rule__ModeInstance__Group__2
            {
            pushFollow(FOLLOW_rule__ModeInstance__Group__1__Impl_in_rule__ModeInstance__Group__14445);
            rule__ModeInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeInstance__Group__2_in_rule__ModeInstance__Group__14448);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2180:1: rule__ModeInstance__Group__1__Impl : ( 'instance' ) ;
    public final void rule__ModeInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2184:1: ( ( 'instance' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2185:1: ( 'instance' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2185:1: ( 'instance' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2186:1: 'instance'
            {
             before(grammarAccess.getModeInstanceAccess().getInstanceKeyword_1()); 
            match(input,41,FOLLOW_41_in_rule__ModeInstance__Group__1__Impl4476); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2199:1: rule__ModeInstance__Group__2 : rule__ModeInstance__Group__2__Impl rule__ModeInstance__Group__3 ;
    public final void rule__ModeInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2203:1: ( rule__ModeInstance__Group__2__Impl rule__ModeInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2204:2: rule__ModeInstance__Group__2__Impl rule__ModeInstance__Group__3
            {
            pushFollow(FOLLOW_rule__ModeInstance__Group__2__Impl_in_rule__ModeInstance__Group__24507);
            rule__ModeInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeInstance__Group__3_in_rule__ModeInstance__Group__24510);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2211:1: rule__ModeInstance__Group__2__Impl : ( ( rule__ModeInstance__NameAssignment_2 ) ) ;
    public final void rule__ModeInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2215:1: ( ( ( rule__ModeInstance__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2216:1: ( ( rule__ModeInstance__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2216:1: ( ( rule__ModeInstance__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2217:1: ( rule__ModeInstance__NameAssignment_2 )
            {
             before(grammarAccess.getModeInstanceAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2218:1: ( rule__ModeInstance__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2218:2: rule__ModeInstance__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__ModeInstance__NameAssignment_2_in_rule__ModeInstance__Group__2__Impl4537);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2228:1: rule__ModeInstance__Group__3 : rule__ModeInstance__Group__3__Impl rule__ModeInstance__Group__4 ;
    public final void rule__ModeInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2232:1: ( rule__ModeInstance__Group__3__Impl rule__ModeInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2233:2: rule__ModeInstance__Group__3__Impl rule__ModeInstance__Group__4
            {
            pushFollow(FOLLOW_rule__ModeInstance__Group__3__Impl_in_rule__ModeInstance__Group__34567);
            rule__ModeInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeInstance__Group__4_in_rule__ModeInstance__Group__34570);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2240:1: rule__ModeInstance__Group__3__Impl : ( 'of' ) ;
    public final void rule__ModeInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2244:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2245:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2245:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2246:1: 'of'
            {
             before(grammarAccess.getModeInstanceAccess().getOfKeyword_3()); 
            match(input,42,FOLLOW_42_in_rule__ModeInstance__Group__3__Impl4598); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2259:1: rule__ModeInstance__Group__4 : rule__ModeInstance__Group__4__Impl rule__ModeInstance__Group__5 ;
    public final void rule__ModeInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2263:1: ( rule__ModeInstance__Group__4__Impl rule__ModeInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2264:2: rule__ModeInstance__Group__4__Impl rule__ModeInstance__Group__5
            {
            pushFollow(FOLLOW_rule__ModeInstance__Group__4__Impl_in_rule__ModeInstance__Group__44629);
            rule__ModeInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeInstance__Group__5_in_rule__ModeInstance__Group__44632);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2271:1: rule__ModeInstance__Group__4__Impl : ( ( rule__ModeInstance__ModeAssignment_4 ) ) ;
    public final void rule__ModeInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2275:1: ( ( ( rule__ModeInstance__ModeAssignment_4 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2276:1: ( ( rule__ModeInstance__ModeAssignment_4 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2276:1: ( ( rule__ModeInstance__ModeAssignment_4 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2277:1: ( rule__ModeInstance__ModeAssignment_4 )
            {
             before(grammarAccess.getModeInstanceAccess().getModeAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2278:1: ( rule__ModeInstance__ModeAssignment_4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2278:2: rule__ModeInstance__ModeAssignment_4
            {
            pushFollow(FOLLOW_rule__ModeInstance__ModeAssignment_4_in_rule__ModeInstance__Group__4__Impl4659);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2288:1: rule__ModeInstance__Group__5 : rule__ModeInstance__Group__5__Impl rule__ModeInstance__Group__6 ;
    public final void rule__ModeInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2292:1: ( rule__ModeInstance__Group__5__Impl rule__ModeInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2293:2: rule__ModeInstance__Group__5__Impl rule__ModeInstance__Group__6
            {
            pushFollow(FOLLOW_rule__ModeInstance__Group__5__Impl_in_rule__ModeInstance__Group__54689);
            rule__ModeInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeInstance__Group__6_in_rule__ModeInstance__Group__54692);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2300:1: rule__ModeInstance__Group__5__Impl : ( ( rule__ModeInstance__InitialAssignment_5 )? ) ;
    public final void rule__ModeInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2304:1: ( ( ( rule__ModeInstance__InitialAssignment_5 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2305:1: ( ( rule__ModeInstance__InitialAssignment_5 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2305:1: ( ( rule__ModeInstance__InitialAssignment_5 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2306:1: ( rule__ModeInstance__InitialAssignment_5 )?
            {
             before(grammarAccess.getModeInstanceAccess().getInitialAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2307:1: ( rule__ModeInstance__InitialAssignment_5 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==60) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2307:2: rule__ModeInstance__InitialAssignment_5
                    {
                    pushFollow(FOLLOW_rule__ModeInstance__InitialAssignment_5_in_rule__ModeInstance__Group__5__Impl4719);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2317:1: rule__ModeInstance__Group__6 : rule__ModeInstance__Group__6__Impl ;
    public final void rule__ModeInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2321:1: ( rule__ModeInstance__Group__6__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2322:2: rule__ModeInstance__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ModeInstance__Group__6__Impl_in_rule__ModeInstance__Group__64750);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2328:1: rule__ModeInstance__Group__6__Impl : ( 'end' ) ;
    public final void rule__ModeInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2332:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2333:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2333:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2334:1: 'end'
            {
             before(grammarAccess.getModeInstanceAccess().getEndKeyword_6()); 
            match(input,43,FOLLOW_43_in_rule__ModeInstance__Group__6__Impl4778); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2361:1: rule__ModeTransitionInstance__Group__0 : rule__ModeTransitionInstance__Group__0__Impl rule__ModeTransitionInstance__Group__1 ;
    public final void rule__ModeTransitionInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2365:1: ( rule__ModeTransitionInstance__Group__0__Impl rule__ModeTransitionInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2366:2: rule__ModeTransitionInstance__Group__0__Impl rule__ModeTransitionInstance__Group__1
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__0__Impl_in_rule__ModeTransitionInstance__Group__04823);
            rule__ModeTransitionInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__1_in_rule__ModeTransitionInstance__Group__04826);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2373:1: rule__ModeTransitionInstance__Group__0__Impl : ( 'mode' ) ;
    public final void rule__ModeTransitionInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2377:1: ( ( 'mode' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2378:1: ( 'mode' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2378:1: ( 'mode' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2379:1: 'mode'
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getModeKeyword_0()); 
            match(input,46,FOLLOW_46_in_rule__ModeTransitionInstance__Group__0__Impl4854); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2392:1: rule__ModeTransitionInstance__Group__1 : rule__ModeTransitionInstance__Group__1__Impl rule__ModeTransitionInstance__Group__2 ;
    public final void rule__ModeTransitionInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2396:1: ( rule__ModeTransitionInstance__Group__1__Impl rule__ModeTransitionInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2397:2: rule__ModeTransitionInstance__Group__1__Impl rule__ModeTransitionInstance__Group__2
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__1__Impl_in_rule__ModeTransitionInstance__Group__14885);
            rule__ModeTransitionInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__2_in_rule__ModeTransitionInstance__Group__14888);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2404:1: rule__ModeTransitionInstance__Group__1__Impl : ( 'transition' ) ;
    public final void rule__ModeTransitionInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2408:1: ( ( 'transition' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2409:1: ( 'transition' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2409:1: ( 'transition' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2410:1: 'transition'
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getTransitionKeyword_1()); 
            match(input,47,FOLLOW_47_in_rule__ModeTransitionInstance__Group__1__Impl4916); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2423:1: rule__ModeTransitionInstance__Group__2 : rule__ModeTransitionInstance__Group__2__Impl rule__ModeTransitionInstance__Group__3 ;
    public final void rule__ModeTransitionInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2427:1: ( rule__ModeTransitionInstance__Group__2__Impl rule__ModeTransitionInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2428:2: rule__ModeTransitionInstance__Group__2__Impl rule__ModeTransitionInstance__Group__3
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__2__Impl_in_rule__ModeTransitionInstance__Group__24947);
            rule__ModeTransitionInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__3_in_rule__ModeTransitionInstance__Group__24950);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2435:1: rule__ModeTransitionInstance__Group__2__Impl : ( 'instance' ) ;
    public final void rule__ModeTransitionInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2439:1: ( ( 'instance' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2440:1: ( 'instance' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2440:1: ( 'instance' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2441:1: 'instance'
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getInstanceKeyword_2()); 
            match(input,41,FOLLOW_41_in_rule__ModeTransitionInstance__Group__2__Impl4978); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2454:1: rule__ModeTransitionInstance__Group__3 : rule__ModeTransitionInstance__Group__3__Impl rule__ModeTransitionInstance__Group__4 ;
    public final void rule__ModeTransitionInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2458:1: ( rule__ModeTransitionInstance__Group__3__Impl rule__ModeTransitionInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2459:2: rule__ModeTransitionInstance__Group__3__Impl rule__ModeTransitionInstance__Group__4
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__3__Impl_in_rule__ModeTransitionInstance__Group__35009);
            rule__ModeTransitionInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__4_in_rule__ModeTransitionInstance__Group__35012);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2466:1: rule__ModeTransitionInstance__Group__3__Impl : ( ( rule__ModeTransitionInstance__NameAssignment_3 ) ) ;
    public final void rule__ModeTransitionInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2470:1: ( ( ( rule__ModeTransitionInstance__NameAssignment_3 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2471:1: ( ( rule__ModeTransitionInstance__NameAssignment_3 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2471:1: ( ( rule__ModeTransitionInstance__NameAssignment_3 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2472:1: ( rule__ModeTransitionInstance__NameAssignment_3 )
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getNameAssignment_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2473:1: ( rule__ModeTransitionInstance__NameAssignment_3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2473:2: rule__ModeTransitionInstance__NameAssignment_3
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__NameAssignment_3_in_rule__ModeTransitionInstance__Group__3__Impl5039);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2483:1: rule__ModeTransitionInstance__Group__4 : rule__ModeTransitionInstance__Group__4__Impl rule__ModeTransitionInstance__Group__5 ;
    public final void rule__ModeTransitionInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2487:1: ( rule__ModeTransitionInstance__Group__4__Impl rule__ModeTransitionInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2488:2: rule__ModeTransitionInstance__Group__4__Impl rule__ModeTransitionInstance__Group__5
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__4__Impl_in_rule__ModeTransitionInstance__Group__45069);
            rule__ModeTransitionInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__5_in_rule__ModeTransitionInstance__Group__45072);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2495:1: rule__ModeTransitionInstance__Group__4__Impl : ( 'of' ) ;
    public final void rule__ModeTransitionInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2499:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2500:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2500:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2501:1: 'of'
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getOfKeyword_4()); 
            match(input,42,FOLLOW_42_in_rule__ModeTransitionInstance__Group__4__Impl5100); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2514:1: rule__ModeTransitionInstance__Group__5 : rule__ModeTransitionInstance__Group__5__Impl rule__ModeTransitionInstance__Group__6 ;
    public final void rule__ModeTransitionInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2518:1: ( rule__ModeTransitionInstance__Group__5__Impl rule__ModeTransitionInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2519:2: rule__ModeTransitionInstance__Group__5__Impl rule__ModeTransitionInstance__Group__6
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__5__Impl_in_rule__ModeTransitionInstance__Group__55131);
            rule__ModeTransitionInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__6_in_rule__ModeTransitionInstance__Group__55134);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2526:1: rule__ModeTransitionInstance__Group__5__Impl : ( ( rule__ModeTransitionInstance__ModeTransitionAssignment_5 ) ) ;
    public final void rule__ModeTransitionInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2530:1: ( ( ( rule__ModeTransitionInstance__ModeTransitionAssignment_5 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2531:1: ( ( rule__ModeTransitionInstance__ModeTransitionAssignment_5 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2531:1: ( ( rule__ModeTransitionInstance__ModeTransitionAssignment_5 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2532:1: ( rule__ModeTransitionInstance__ModeTransitionAssignment_5 )
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2533:1: ( rule__ModeTransitionInstance__ModeTransitionAssignment_5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2533:2: rule__ModeTransitionInstance__ModeTransitionAssignment_5
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__ModeTransitionAssignment_5_in_rule__ModeTransitionInstance__Group__5__Impl5161);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2543:1: rule__ModeTransitionInstance__Group__6 : rule__ModeTransitionInstance__Group__6__Impl rule__ModeTransitionInstance__Group__7 ;
    public final void rule__ModeTransitionInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2547:1: ( rule__ModeTransitionInstance__Group__6__Impl rule__ModeTransitionInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2548:2: rule__ModeTransitionInstance__Group__6__Impl rule__ModeTransitionInstance__Group__7
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__6__Impl_in_rule__ModeTransitionInstance__Group__65191);
            rule__ModeTransitionInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__7_in_rule__ModeTransitionInstance__Group__65194);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2555:1: rule__ModeTransitionInstance__Group__6__Impl : ( 'src' ) ;
    public final void rule__ModeTransitionInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2559:1: ( ( 'src' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2560:1: ( 'src' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2560:1: ( 'src' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2561:1: 'src'
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getSrcKeyword_6()); 
            match(input,48,FOLLOW_48_in_rule__ModeTransitionInstance__Group__6__Impl5222); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2574:1: rule__ModeTransitionInstance__Group__7 : rule__ModeTransitionInstance__Group__7__Impl rule__ModeTransitionInstance__Group__8 ;
    public final void rule__ModeTransitionInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2578:1: ( rule__ModeTransitionInstance__Group__7__Impl rule__ModeTransitionInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2579:2: rule__ModeTransitionInstance__Group__7__Impl rule__ModeTransitionInstance__Group__8
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__7__Impl_in_rule__ModeTransitionInstance__Group__75253);
            rule__ModeTransitionInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__8_in_rule__ModeTransitionInstance__Group__75256);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2586:1: rule__ModeTransitionInstance__Group__7__Impl : ( ( rule__ModeTransitionInstance__SourceAssignment_7 ) ) ;
    public final void rule__ModeTransitionInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2590:1: ( ( ( rule__ModeTransitionInstance__SourceAssignment_7 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2591:1: ( ( rule__ModeTransitionInstance__SourceAssignment_7 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2591:1: ( ( rule__ModeTransitionInstance__SourceAssignment_7 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2592:1: ( rule__ModeTransitionInstance__SourceAssignment_7 )
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getSourceAssignment_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2593:1: ( rule__ModeTransitionInstance__SourceAssignment_7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2593:2: rule__ModeTransitionInstance__SourceAssignment_7
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__SourceAssignment_7_in_rule__ModeTransitionInstance__Group__7__Impl5283);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2603:1: rule__ModeTransitionInstance__Group__8 : rule__ModeTransitionInstance__Group__8__Impl rule__ModeTransitionInstance__Group__9 ;
    public final void rule__ModeTransitionInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2607:1: ( rule__ModeTransitionInstance__Group__8__Impl rule__ModeTransitionInstance__Group__9 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2608:2: rule__ModeTransitionInstance__Group__8__Impl rule__ModeTransitionInstance__Group__9
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__8__Impl_in_rule__ModeTransitionInstance__Group__85313);
            rule__ModeTransitionInstance__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__9_in_rule__ModeTransitionInstance__Group__85316);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2615:1: rule__ModeTransitionInstance__Group__8__Impl : ( 'dst' ) ;
    public final void rule__ModeTransitionInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2619:1: ( ( 'dst' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2620:1: ( 'dst' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2620:1: ( 'dst' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2621:1: 'dst'
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getDstKeyword_8()); 
            match(input,49,FOLLOW_49_in_rule__ModeTransitionInstance__Group__8__Impl5344); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2634:1: rule__ModeTransitionInstance__Group__9 : rule__ModeTransitionInstance__Group__9__Impl rule__ModeTransitionInstance__Group__10 ;
    public final void rule__ModeTransitionInstance__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2638:1: ( rule__ModeTransitionInstance__Group__9__Impl rule__ModeTransitionInstance__Group__10 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2639:2: rule__ModeTransitionInstance__Group__9__Impl rule__ModeTransitionInstance__Group__10
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__9__Impl_in_rule__ModeTransitionInstance__Group__95375);
            rule__ModeTransitionInstance__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__10_in_rule__ModeTransitionInstance__Group__95378);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2646:1: rule__ModeTransitionInstance__Group__9__Impl : ( ( rule__ModeTransitionInstance__DestinationAssignment_9 ) ) ;
    public final void rule__ModeTransitionInstance__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2650:1: ( ( ( rule__ModeTransitionInstance__DestinationAssignment_9 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2651:1: ( ( rule__ModeTransitionInstance__DestinationAssignment_9 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2651:1: ( ( rule__ModeTransitionInstance__DestinationAssignment_9 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2652:1: ( rule__ModeTransitionInstance__DestinationAssignment_9 )
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getDestinationAssignment_9()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2653:1: ( rule__ModeTransitionInstance__DestinationAssignment_9 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2653:2: rule__ModeTransitionInstance__DestinationAssignment_9
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__DestinationAssignment_9_in_rule__ModeTransitionInstance__Group__9__Impl5405);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2663:1: rule__ModeTransitionInstance__Group__10 : rule__ModeTransitionInstance__Group__10__Impl ;
    public final void rule__ModeTransitionInstance__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2667:1: ( rule__ModeTransitionInstance__Group__10__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2668:2: rule__ModeTransitionInstance__Group__10__Impl
            {
            pushFollow(FOLLOW_rule__ModeTransitionInstance__Group__10__Impl_in_rule__ModeTransitionInstance__Group__105435);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2674:1: rule__ModeTransitionInstance__Group__10__Impl : ( 'end' ) ;
    public final void rule__ModeTransitionInstance__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2678:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2679:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2679:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2680:1: 'end'
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getEndKeyword_10()); 
            match(input,43,FOLLOW_43_in_rule__ModeTransitionInstance__Group__10__Impl5463); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2715:1: rule__FlowSpecInstance__Group__0 : rule__FlowSpecInstance__Group__0__Impl rule__FlowSpecInstance__Group__1 ;
    public final void rule__FlowSpecInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2719:1: ( rule__FlowSpecInstance__Group__0__Impl rule__FlowSpecInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2720:2: rule__FlowSpecInstance__Group__0__Impl rule__FlowSpecInstance__Group__1
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__0__Impl_in_rule__FlowSpecInstance__Group__05516);
            rule__FlowSpecInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__1_in_rule__FlowSpecInstance__Group__05519);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2727:1: rule__FlowSpecInstance__Group__0__Impl : ( 'flowspec' ) ;
    public final void rule__FlowSpecInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2731:1: ( ( 'flowspec' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2732:1: ( 'flowspec' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2732:1: ( 'flowspec' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2733:1: 'flowspec'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getFlowspecKeyword_0()); 
            match(input,50,FOLLOW_50_in_rule__FlowSpecInstance__Group__0__Impl5547); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2746:1: rule__FlowSpecInstance__Group__1 : rule__FlowSpecInstance__Group__1__Impl rule__FlowSpecInstance__Group__2 ;
    public final void rule__FlowSpecInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2750:1: ( rule__FlowSpecInstance__Group__1__Impl rule__FlowSpecInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2751:2: rule__FlowSpecInstance__Group__1__Impl rule__FlowSpecInstance__Group__2
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__1__Impl_in_rule__FlowSpecInstance__Group__15578);
            rule__FlowSpecInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__2_in_rule__FlowSpecInstance__Group__15581);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2758:1: rule__FlowSpecInstance__Group__1__Impl : ( 'instance' ) ;
    public final void rule__FlowSpecInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2762:1: ( ( 'instance' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2763:1: ( 'instance' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2763:1: ( 'instance' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2764:1: 'instance'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInstanceKeyword_1()); 
            match(input,41,FOLLOW_41_in_rule__FlowSpecInstance__Group__1__Impl5609); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2777:1: rule__FlowSpecInstance__Group__2 : rule__FlowSpecInstance__Group__2__Impl rule__FlowSpecInstance__Group__3 ;
    public final void rule__FlowSpecInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2781:1: ( rule__FlowSpecInstance__Group__2__Impl rule__FlowSpecInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2782:2: rule__FlowSpecInstance__Group__2__Impl rule__FlowSpecInstance__Group__3
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__2__Impl_in_rule__FlowSpecInstance__Group__25640);
            rule__FlowSpecInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__3_in_rule__FlowSpecInstance__Group__25643);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2789:1: rule__FlowSpecInstance__Group__2__Impl : ( ( rule__FlowSpecInstance__NameAssignment_2 ) ) ;
    public final void rule__FlowSpecInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2793:1: ( ( ( rule__FlowSpecInstance__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2794:1: ( ( rule__FlowSpecInstance__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2794:1: ( ( rule__FlowSpecInstance__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2795:1: ( rule__FlowSpecInstance__NameAssignment_2 )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2796:1: ( rule__FlowSpecInstance__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2796:2: rule__FlowSpecInstance__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__NameAssignment_2_in_rule__FlowSpecInstance__Group__2__Impl5670);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2806:1: rule__FlowSpecInstance__Group__3 : rule__FlowSpecInstance__Group__3__Impl rule__FlowSpecInstance__Group__4 ;
    public final void rule__FlowSpecInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2810:1: ( rule__FlowSpecInstance__Group__3__Impl rule__FlowSpecInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2811:2: rule__FlowSpecInstance__Group__3__Impl rule__FlowSpecInstance__Group__4
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__3__Impl_in_rule__FlowSpecInstance__Group__35700);
            rule__FlowSpecInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__4_in_rule__FlowSpecInstance__Group__35703);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2818:1: rule__FlowSpecInstance__Group__3__Impl : ( 'of' ) ;
    public final void rule__FlowSpecInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2822:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2823:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2823:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2824:1: 'of'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getOfKeyword_3()); 
            match(input,42,FOLLOW_42_in_rule__FlowSpecInstance__Group__3__Impl5731); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2837:1: rule__FlowSpecInstance__Group__4 : rule__FlowSpecInstance__Group__4__Impl rule__FlowSpecInstance__Group__5 ;
    public final void rule__FlowSpecInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2841:1: ( rule__FlowSpecInstance__Group__4__Impl rule__FlowSpecInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2842:2: rule__FlowSpecInstance__Group__4__Impl rule__FlowSpecInstance__Group__5
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__4__Impl_in_rule__FlowSpecInstance__Group__45762);
            rule__FlowSpecInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__5_in_rule__FlowSpecInstance__Group__45765);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2849:1: rule__FlowSpecInstance__Group__4__Impl : ( ( rule__FlowSpecInstance__FlowSpecificationAssignment_4 ) ) ;
    public final void rule__FlowSpecInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2853:1: ( ( ( rule__FlowSpecInstance__FlowSpecificationAssignment_4 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2854:1: ( ( rule__FlowSpecInstance__FlowSpecificationAssignment_4 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2854:1: ( ( rule__FlowSpecInstance__FlowSpecificationAssignment_4 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2855:1: ( rule__FlowSpecInstance__FlowSpecificationAssignment_4 )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getFlowSpecificationAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2856:1: ( rule__FlowSpecInstance__FlowSpecificationAssignment_4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2856:2: rule__FlowSpecInstance__FlowSpecificationAssignment_4
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__FlowSpecificationAssignment_4_in_rule__FlowSpecInstance__Group__4__Impl5792);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2866:1: rule__FlowSpecInstance__Group__5 : rule__FlowSpecInstance__Group__5__Impl rule__FlowSpecInstance__Group__6 ;
    public final void rule__FlowSpecInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2870:1: ( rule__FlowSpecInstance__Group__5__Impl rule__FlowSpecInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2871:2: rule__FlowSpecInstance__Group__5__Impl rule__FlowSpecInstance__Group__6
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__5__Impl_in_rule__FlowSpecInstance__Group__55822);
            rule__FlowSpecInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__6_in_rule__FlowSpecInstance__Group__55825);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2878:1: rule__FlowSpecInstance__Group__5__Impl : ( ( rule__FlowSpecInstance__Group_5__0 )? ) ;
    public final void rule__FlowSpecInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2882:1: ( ( ( rule__FlowSpecInstance__Group_5__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2883:1: ( ( rule__FlowSpecInstance__Group_5__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2883:1: ( ( rule__FlowSpecInstance__Group_5__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2884:1: ( rule__FlowSpecInstance__Group_5__0 )?
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getGroup_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2885:1: ( rule__FlowSpecInstance__Group_5__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==48) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2885:2: rule__FlowSpecInstance__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__FlowSpecInstance__Group_5__0_in_rule__FlowSpecInstance__Group__5__Impl5852);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2895:1: rule__FlowSpecInstance__Group__6 : rule__FlowSpecInstance__Group__6__Impl rule__FlowSpecInstance__Group__7 ;
    public final void rule__FlowSpecInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2899:1: ( rule__FlowSpecInstance__Group__6__Impl rule__FlowSpecInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2900:2: rule__FlowSpecInstance__Group__6__Impl rule__FlowSpecInstance__Group__7
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__6__Impl_in_rule__FlowSpecInstance__Group__65883);
            rule__FlowSpecInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__7_in_rule__FlowSpecInstance__Group__65886);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2907:1: rule__FlowSpecInstance__Group__6__Impl : ( ( rule__FlowSpecInstance__Group_6__0 )? ) ;
    public final void rule__FlowSpecInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2911:1: ( ( ( rule__FlowSpecInstance__Group_6__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2912:1: ( ( rule__FlowSpecInstance__Group_6__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2912:1: ( ( rule__FlowSpecInstance__Group_6__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2913:1: ( rule__FlowSpecInstance__Group_6__0 )?
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getGroup_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2914:1: ( rule__FlowSpecInstance__Group_6__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==49) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2914:2: rule__FlowSpecInstance__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__FlowSpecInstance__Group_6__0_in_rule__FlowSpecInstance__Group__6__Impl5913);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2924:1: rule__FlowSpecInstance__Group__7 : rule__FlowSpecInstance__Group__7__Impl rule__FlowSpecInstance__Group__8 ;
    public final void rule__FlowSpecInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2928:1: ( rule__FlowSpecInstance__Group__7__Impl rule__FlowSpecInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2929:2: rule__FlowSpecInstance__Group__7__Impl rule__FlowSpecInstance__Group__8
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__7__Impl_in_rule__FlowSpecInstance__Group__75944);
            rule__FlowSpecInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__8_in_rule__FlowSpecInstance__Group__75947);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2936:1: rule__FlowSpecInstance__Group__7__Impl : ( ( rule__FlowSpecInstance__Group_7__0 )? ) ;
    public final void rule__FlowSpecInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2940:1: ( ( ( rule__FlowSpecInstance__Group_7__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2941:1: ( ( rule__FlowSpecInstance__Group_7__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2941:1: ( ( rule__FlowSpecInstance__Group_7__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2942:1: ( rule__FlowSpecInstance__Group_7__0 )?
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getGroup_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2943:1: ( rule__FlowSpecInstance__Group_7__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==31) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==46) ) {
                    alt20=1;
                }
            }
            switch (alt20) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2943:2: rule__FlowSpecInstance__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__FlowSpecInstance__Group_7__0_in_rule__FlowSpecInstance__Group__7__Impl5974);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2953:1: rule__FlowSpecInstance__Group__8 : rule__FlowSpecInstance__Group__8__Impl rule__FlowSpecInstance__Group__9 ;
    public final void rule__FlowSpecInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2957:1: ( rule__FlowSpecInstance__Group__8__Impl rule__FlowSpecInstance__Group__9 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2958:2: rule__FlowSpecInstance__Group__8__Impl rule__FlowSpecInstance__Group__9
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__8__Impl_in_rule__FlowSpecInstance__Group__86005);
            rule__FlowSpecInstance__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__9_in_rule__FlowSpecInstance__Group__86008);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2965:1: rule__FlowSpecInstance__Group__8__Impl : ( ( rule__FlowSpecInstance__Group_8__0 )? ) ;
    public final void rule__FlowSpecInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2969:1: ( ( ( rule__FlowSpecInstance__Group_8__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2970:1: ( ( rule__FlowSpecInstance__Group_8__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2970:1: ( ( rule__FlowSpecInstance__Group_8__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2971:1: ( rule__FlowSpecInstance__Group_8__0 )?
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getGroup_8()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2972:1: ( rule__FlowSpecInstance__Group_8__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==31) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2972:2: rule__FlowSpecInstance__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__FlowSpecInstance__Group_8__0_in_rule__FlowSpecInstance__Group__8__Impl6035);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2982:1: rule__FlowSpecInstance__Group__9 : rule__FlowSpecInstance__Group__9__Impl ;
    public final void rule__FlowSpecInstance__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2986:1: ( rule__FlowSpecInstance__Group__9__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2987:2: rule__FlowSpecInstance__Group__9__Impl
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group__9__Impl_in_rule__FlowSpecInstance__Group__96066);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2993:1: rule__FlowSpecInstance__Group__9__Impl : ( 'end' ) ;
    public final void rule__FlowSpecInstance__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2997:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2998:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2998:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2999:1: 'end'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getEndKeyword_9()); 
            match(input,43,FOLLOW_43_in_rule__FlowSpecInstance__Group__9__Impl6094); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3032:1: rule__FlowSpecInstance__Group_5__0 : rule__FlowSpecInstance__Group_5__0__Impl rule__FlowSpecInstance__Group_5__1 ;
    public final void rule__FlowSpecInstance__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3036:1: ( rule__FlowSpecInstance__Group_5__0__Impl rule__FlowSpecInstance__Group_5__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3037:2: rule__FlowSpecInstance__Group_5__0__Impl rule__FlowSpecInstance__Group_5__1
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_5__0__Impl_in_rule__FlowSpecInstance__Group_5__06145);
            rule__FlowSpecInstance__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_5__1_in_rule__FlowSpecInstance__Group_5__06148);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3044:1: rule__FlowSpecInstance__Group_5__0__Impl : ( 'src' ) ;
    public final void rule__FlowSpecInstance__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3048:1: ( ( 'src' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3049:1: ( 'src' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3049:1: ( 'src' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3050:1: 'src'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getSrcKeyword_5_0()); 
            match(input,48,FOLLOW_48_in_rule__FlowSpecInstance__Group_5__0__Impl6176); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3063:1: rule__FlowSpecInstance__Group_5__1 : rule__FlowSpecInstance__Group_5__1__Impl ;
    public final void rule__FlowSpecInstance__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3067:1: ( rule__FlowSpecInstance__Group_5__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3068:2: rule__FlowSpecInstance__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_5__1__Impl_in_rule__FlowSpecInstance__Group_5__16207);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3074:1: rule__FlowSpecInstance__Group_5__1__Impl : ( ( rule__FlowSpecInstance__SourceAssignment_5_1 ) ) ;
    public final void rule__FlowSpecInstance__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3078:1: ( ( ( rule__FlowSpecInstance__SourceAssignment_5_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3079:1: ( ( rule__FlowSpecInstance__SourceAssignment_5_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3079:1: ( ( rule__FlowSpecInstance__SourceAssignment_5_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3080:1: ( rule__FlowSpecInstance__SourceAssignment_5_1 )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getSourceAssignment_5_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3081:1: ( rule__FlowSpecInstance__SourceAssignment_5_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3081:2: rule__FlowSpecInstance__SourceAssignment_5_1
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__SourceAssignment_5_1_in_rule__FlowSpecInstance__Group_5__1__Impl6234);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3095:1: rule__FlowSpecInstance__Group_6__0 : rule__FlowSpecInstance__Group_6__0__Impl rule__FlowSpecInstance__Group_6__1 ;
    public final void rule__FlowSpecInstance__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3099:1: ( rule__FlowSpecInstance__Group_6__0__Impl rule__FlowSpecInstance__Group_6__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3100:2: rule__FlowSpecInstance__Group_6__0__Impl rule__FlowSpecInstance__Group_6__1
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_6__0__Impl_in_rule__FlowSpecInstance__Group_6__06268);
            rule__FlowSpecInstance__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_6__1_in_rule__FlowSpecInstance__Group_6__06271);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3107:1: rule__FlowSpecInstance__Group_6__0__Impl : ( 'dst' ) ;
    public final void rule__FlowSpecInstance__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3111:1: ( ( 'dst' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3112:1: ( 'dst' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3112:1: ( 'dst' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3113:1: 'dst'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getDstKeyword_6_0()); 
            match(input,49,FOLLOW_49_in_rule__FlowSpecInstance__Group_6__0__Impl6299); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3126:1: rule__FlowSpecInstance__Group_6__1 : rule__FlowSpecInstance__Group_6__1__Impl ;
    public final void rule__FlowSpecInstance__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3130:1: ( rule__FlowSpecInstance__Group_6__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3131:2: rule__FlowSpecInstance__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_6__1__Impl_in_rule__FlowSpecInstance__Group_6__16330);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3137:1: rule__FlowSpecInstance__Group_6__1__Impl : ( ( rule__FlowSpecInstance__DestinationAssignment_6_1 ) ) ;
    public final void rule__FlowSpecInstance__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3141:1: ( ( ( rule__FlowSpecInstance__DestinationAssignment_6_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3142:1: ( ( rule__FlowSpecInstance__DestinationAssignment_6_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3142:1: ( ( rule__FlowSpecInstance__DestinationAssignment_6_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3143:1: ( rule__FlowSpecInstance__DestinationAssignment_6_1 )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getDestinationAssignment_6_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3144:1: ( rule__FlowSpecInstance__DestinationAssignment_6_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3144:2: rule__FlowSpecInstance__DestinationAssignment_6_1
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__DestinationAssignment_6_1_in_rule__FlowSpecInstance__Group_6__1__Impl6357);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3158:1: rule__FlowSpecInstance__Group_7__0 : rule__FlowSpecInstance__Group_7__0__Impl rule__FlowSpecInstance__Group_7__1 ;
    public final void rule__FlowSpecInstance__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3162:1: ( rule__FlowSpecInstance__Group_7__0__Impl rule__FlowSpecInstance__Group_7__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3163:2: rule__FlowSpecInstance__Group_7__0__Impl rule__FlowSpecInstance__Group_7__1
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_7__0__Impl_in_rule__FlowSpecInstance__Group_7__06391);
            rule__FlowSpecInstance__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_7__1_in_rule__FlowSpecInstance__Group_7__06394);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3170:1: rule__FlowSpecInstance__Group_7__0__Impl : ( 'in' ) ;
    public final void rule__FlowSpecInstance__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3174:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3175:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3175:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3176:1: 'in'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInKeyword_7_0()); 
            match(input,31,FOLLOW_31_in_rule__FlowSpecInstance__Group_7__0__Impl6422); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3189:1: rule__FlowSpecInstance__Group_7__1 : rule__FlowSpecInstance__Group_7__1__Impl rule__FlowSpecInstance__Group_7__2 ;
    public final void rule__FlowSpecInstance__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3193:1: ( rule__FlowSpecInstance__Group_7__1__Impl rule__FlowSpecInstance__Group_7__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3194:2: rule__FlowSpecInstance__Group_7__1__Impl rule__FlowSpecInstance__Group_7__2
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_7__1__Impl_in_rule__FlowSpecInstance__Group_7__16453);
            rule__FlowSpecInstance__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_7__2_in_rule__FlowSpecInstance__Group_7__16456);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3201:1: rule__FlowSpecInstance__Group_7__1__Impl : ( 'mode' ) ;
    public final void rule__FlowSpecInstance__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3205:1: ( ( 'mode' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3206:1: ( 'mode' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3206:1: ( 'mode' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3207:1: 'mode'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getModeKeyword_7_1()); 
            match(input,46,FOLLOW_46_in_rule__FlowSpecInstance__Group_7__1__Impl6484); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3220:1: rule__FlowSpecInstance__Group_7__2 : rule__FlowSpecInstance__Group_7__2__Impl ;
    public final void rule__FlowSpecInstance__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3224:1: ( rule__FlowSpecInstance__Group_7__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3225:2: rule__FlowSpecInstance__Group_7__2__Impl
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_7__2__Impl_in_rule__FlowSpecInstance__Group_7__26515);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3231:1: rule__FlowSpecInstance__Group_7__2__Impl : ( ( rule__FlowSpecInstance__InModeAssignment_7_2 ) ) ;
    public final void rule__FlowSpecInstance__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3235:1: ( ( ( rule__FlowSpecInstance__InModeAssignment_7_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3236:1: ( ( rule__FlowSpecInstance__InModeAssignment_7_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3236:1: ( ( rule__FlowSpecInstance__InModeAssignment_7_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3237:1: ( rule__FlowSpecInstance__InModeAssignment_7_2 )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInModeAssignment_7_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3238:1: ( rule__FlowSpecInstance__InModeAssignment_7_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3238:2: rule__FlowSpecInstance__InModeAssignment_7_2
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__InModeAssignment_7_2_in_rule__FlowSpecInstance__Group_7__2__Impl6542);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3254:1: rule__FlowSpecInstance__Group_8__0 : rule__FlowSpecInstance__Group_8__0__Impl rule__FlowSpecInstance__Group_8__1 ;
    public final void rule__FlowSpecInstance__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3258:1: ( rule__FlowSpecInstance__Group_8__0__Impl rule__FlowSpecInstance__Group_8__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3259:2: rule__FlowSpecInstance__Group_8__0__Impl rule__FlowSpecInstance__Group_8__1
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_8__0__Impl_in_rule__FlowSpecInstance__Group_8__06578);
            rule__FlowSpecInstance__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_8__1_in_rule__FlowSpecInstance__Group_8__06581);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3266:1: rule__FlowSpecInstance__Group_8__0__Impl : ( 'in' ) ;
    public final void rule__FlowSpecInstance__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3270:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3271:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3271:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3272:1: 'in'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInKeyword_8_0()); 
            match(input,31,FOLLOW_31_in_rule__FlowSpecInstance__Group_8__0__Impl6609); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3285:1: rule__FlowSpecInstance__Group_8__1 : rule__FlowSpecInstance__Group_8__1__Impl rule__FlowSpecInstance__Group_8__2 ;
    public final void rule__FlowSpecInstance__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3289:1: ( rule__FlowSpecInstance__Group_8__1__Impl rule__FlowSpecInstance__Group_8__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3290:2: rule__FlowSpecInstance__Group_8__1__Impl rule__FlowSpecInstance__Group_8__2
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_8__1__Impl_in_rule__FlowSpecInstance__Group_8__16640);
            rule__FlowSpecInstance__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_8__2_in_rule__FlowSpecInstance__Group_8__16643);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3297:1: rule__FlowSpecInstance__Group_8__1__Impl : ( 'transition' ) ;
    public final void rule__FlowSpecInstance__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3301:1: ( ( 'transition' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3302:1: ( 'transition' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3302:1: ( 'transition' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3303:1: 'transition'
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getTransitionKeyword_8_1()); 
            match(input,47,FOLLOW_47_in_rule__FlowSpecInstance__Group_8__1__Impl6671); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3316:1: rule__FlowSpecInstance__Group_8__2 : rule__FlowSpecInstance__Group_8__2__Impl ;
    public final void rule__FlowSpecInstance__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3320:1: ( rule__FlowSpecInstance__Group_8__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3321:2: rule__FlowSpecInstance__Group_8__2__Impl
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__Group_8__2__Impl_in_rule__FlowSpecInstance__Group_8__26702);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3327:1: rule__FlowSpecInstance__Group_8__2__Impl : ( ( rule__FlowSpecInstance__InModeTransitionAssignment_8_2 ) ) ;
    public final void rule__FlowSpecInstance__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3331:1: ( ( ( rule__FlowSpecInstance__InModeTransitionAssignment_8_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3332:1: ( ( rule__FlowSpecInstance__InModeTransitionAssignment_8_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3332:1: ( ( rule__FlowSpecInstance__InModeTransitionAssignment_8_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3333:1: ( rule__FlowSpecInstance__InModeTransitionAssignment_8_2 )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInModeTransitionAssignment_8_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3334:1: ( rule__FlowSpecInstance__InModeTransitionAssignment_8_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3334:2: rule__FlowSpecInstance__InModeTransitionAssignment_8_2
            {
            pushFollow(FOLLOW_rule__FlowSpecInstance__InModeTransitionAssignment_8_2_in_rule__FlowSpecInstance__Group_8__2__Impl6729);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3350:1: rule__EndToEndFlowInstance__Group__0 : rule__EndToEndFlowInstance__Group__0__Impl rule__EndToEndFlowInstance__Group__1 ;
    public final void rule__EndToEndFlowInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3354:1: ( rule__EndToEndFlowInstance__Group__0__Impl rule__EndToEndFlowInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3355:2: rule__EndToEndFlowInstance__Group__0__Impl rule__EndToEndFlowInstance__Group__1
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__0__Impl_in_rule__EndToEndFlowInstance__Group__06765);
            rule__EndToEndFlowInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__1_in_rule__EndToEndFlowInstance__Group__06768);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3362:1: rule__EndToEndFlowInstance__Group__0__Impl : ( 'etef' ) ;
    public final void rule__EndToEndFlowInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3366:1: ( ( 'etef' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3367:1: ( 'etef' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3367:1: ( 'etef' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3368:1: 'etef'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getEtefKeyword_0()); 
            match(input,51,FOLLOW_51_in_rule__EndToEndFlowInstance__Group__0__Impl6796); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3381:1: rule__EndToEndFlowInstance__Group__1 : rule__EndToEndFlowInstance__Group__1__Impl rule__EndToEndFlowInstance__Group__2 ;
    public final void rule__EndToEndFlowInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3385:1: ( rule__EndToEndFlowInstance__Group__1__Impl rule__EndToEndFlowInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3386:2: rule__EndToEndFlowInstance__Group__1__Impl rule__EndToEndFlowInstance__Group__2
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__1__Impl_in_rule__EndToEndFlowInstance__Group__16827);
            rule__EndToEndFlowInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__2_in_rule__EndToEndFlowInstance__Group__16830);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3393:1: rule__EndToEndFlowInstance__Group__1__Impl : ( 'instance' ) ;
    public final void rule__EndToEndFlowInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3397:1: ( ( 'instance' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3398:1: ( 'instance' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3398:1: ( 'instance' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3399:1: 'instance'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInstanceKeyword_1()); 
            match(input,41,FOLLOW_41_in_rule__EndToEndFlowInstance__Group__1__Impl6858); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3412:1: rule__EndToEndFlowInstance__Group__2 : rule__EndToEndFlowInstance__Group__2__Impl rule__EndToEndFlowInstance__Group__3 ;
    public final void rule__EndToEndFlowInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3416:1: ( rule__EndToEndFlowInstance__Group__2__Impl rule__EndToEndFlowInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3417:2: rule__EndToEndFlowInstance__Group__2__Impl rule__EndToEndFlowInstance__Group__3
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__2__Impl_in_rule__EndToEndFlowInstance__Group__26889);
            rule__EndToEndFlowInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__3_in_rule__EndToEndFlowInstance__Group__26892);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3424:1: rule__EndToEndFlowInstance__Group__2__Impl : ( ( rule__EndToEndFlowInstance__NameAssignment_2 ) ) ;
    public final void rule__EndToEndFlowInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3428:1: ( ( ( rule__EndToEndFlowInstance__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3429:1: ( ( rule__EndToEndFlowInstance__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3429:1: ( ( rule__EndToEndFlowInstance__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3430:1: ( rule__EndToEndFlowInstance__NameAssignment_2 )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3431:1: ( rule__EndToEndFlowInstance__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3431:2: rule__EndToEndFlowInstance__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__NameAssignment_2_in_rule__EndToEndFlowInstance__Group__2__Impl6919);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3441:1: rule__EndToEndFlowInstance__Group__3 : rule__EndToEndFlowInstance__Group__3__Impl rule__EndToEndFlowInstance__Group__4 ;
    public final void rule__EndToEndFlowInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3445:1: ( rule__EndToEndFlowInstance__Group__3__Impl rule__EndToEndFlowInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3446:2: rule__EndToEndFlowInstance__Group__3__Impl rule__EndToEndFlowInstance__Group__4
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__3__Impl_in_rule__EndToEndFlowInstance__Group__36949);
            rule__EndToEndFlowInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__4_in_rule__EndToEndFlowInstance__Group__36952);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3453:1: rule__EndToEndFlowInstance__Group__3__Impl : ( 'of' ) ;
    public final void rule__EndToEndFlowInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3457:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3458:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3458:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3459:1: 'of'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getOfKeyword_3()); 
            match(input,42,FOLLOW_42_in_rule__EndToEndFlowInstance__Group__3__Impl6980); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3472:1: rule__EndToEndFlowInstance__Group__4 : rule__EndToEndFlowInstance__Group__4__Impl rule__EndToEndFlowInstance__Group__5 ;
    public final void rule__EndToEndFlowInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3476:1: ( rule__EndToEndFlowInstance__Group__4__Impl rule__EndToEndFlowInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3477:2: rule__EndToEndFlowInstance__Group__4__Impl rule__EndToEndFlowInstance__Group__5
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__4__Impl_in_rule__EndToEndFlowInstance__Group__47011);
            rule__EndToEndFlowInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__5_in_rule__EndToEndFlowInstance__Group__47014);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3484:1: rule__EndToEndFlowInstance__Group__4__Impl : ( ( rule__EndToEndFlowInstance__EndToEndFlowAssignment_4 ) ) ;
    public final void rule__EndToEndFlowInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3488:1: ( ( ( rule__EndToEndFlowInstance__EndToEndFlowAssignment_4 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3489:1: ( ( rule__EndToEndFlowInstance__EndToEndFlowAssignment_4 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3489:1: ( ( rule__EndToEndFlowInstance__EndToEndFlowAssignment_4 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3490:1: ( rule__EndToEndFlowInstance__EndToEndFlowAssignment_4 )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3491:1: ( rule__EndToEndFlowInstance__EndToEndFlowAssignment_4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3491:2: rule__EndToEndFlowInstance__EndToEndFlowAssignment_4
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__EndToEndFlowAssignment_4_in_rule__EndToEndFlowInstance__Group__4__Impl7041);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3501:1: rule__EndToEndFlowInstance__Group__5 : rule__EndToEndFlowInstance__Group__5__Impl rule__EndToEndFlowInstance__Group__6 ;
    public final void rule__EndToEndFlowInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3505:1: ( rule__EndToEndFlowInstance__Group__5__Impl rule__EndToEndFlowInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3506:2: rule__EndToEndFlowInstance__Group__5__Impl rule__EndToEndFlowInstance__Group__6
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__5__Impl_in_rule__EndToEndFlowInstance__Group__57071);
            rule__EndToEndFlowInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__6_in_rule__EndToEndFlowInstance__Group__57074);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3513:1: rule__EndToEndFlowInstance__Group__5__Impl : ( ( rule__EndToEndFlowInstance__FlowElementAssignment_5 )* ) ;
    public final void rule__EndToEndFlowInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3517:1: ( ( ( rule__EndToEndFlowInstance__FlowElementAssignment_5 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3518:1: ( ( rule__EndToEndFlowInstance__FlowElementAssignment_5 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3518:1: ( ( rule__EndToEndFlowInstance__FlowElementAssignment_5 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3519:1: ( rule__EndToEndFlowInstance__FlowElementAssignment_5 )*
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3520:1: ( rule__EndToEndFlowInstance__FlowElementAssignment_5 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3520:2: rule__EndToEndFlowInstance__FlowElementAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__EndToEndFlowInstance__FlowElementAssignment_5_in_rule__EndToEndFlowInstance__Group__5__Impl7101);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3530:1: rule__EndToEndFlowInstance__Group__6 : rule__EndToEndFlowInstance__Group__6__Impl rule__EndToEndFlowInstance__Group__7 ;
    public final void rule__EndToEndFlowInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3534:1: ( rule__EndToEndFlowInstance__Group__6__Impl rule__EndToEndFlowInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3535:2: rule__EndToEndFlowInstance__Group__6__Impl rule__EndToEndFlowInstance__Group__7
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__6__Impl_in_rule__EndToEndFlowInstance__Group__67132);
            rule__EndToEndFlowInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__7_in_rule__EndToEndFlowInstance__Group__67135);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3542:1: rule__EndToEndFlowInstance__Group__6__Impl : ( ( rule__EndToEndFlowInstance__Group_6__0 )? ) ;
    public final void rule__EndToEndFlowInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3546:1: ( ( ( rule__EndToEndFlowInstance__Group_6__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3547:1: ( ( rule__EndToEndFlowInstance__Group_6__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3547:1: ( ( rule__EndToEndFlowInstance__Group_6__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3548:1: ( rule__EndToEndFlowInstance__Group_6__0 )?
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3549:1: ( rule__EndToEndFlowInstance__Group_6__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==31) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==46) ) {
                    alt23=1;
                }
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3549:2: rule__EndToEndFlowInstance__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_6__0_in_rule__EndToEndFlowInstance__Group__6__Impl7162);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3559:1: rule__EndToEndFlowInstance__Group__7 : rule__EndToEndFlowInstance__Group__7__Impl rule__EndToEndFlowInstance__Group__8 ;
    public final void rule__EndToEndFlowInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3563:1: ( rule__EndToEndFlowInstance__Group__7__Impl rule__EndToEndFlowInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3564:2: rule__EndToEndFlowInstance__Group__7__Impl rule__EndToEndFlowInstance__Group__8
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__7__Impl_in_rule__EndToEndFlowInstance__Group__77193);
            rule__EndToEndFlowInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__8_in_rule__EndToEndFlowInstance__Group__77196);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3571:1: rule__EndToEndFlowInstance__Group__7__Impl : ( ( rule__EndToEndFlowInstance__Group_7__0 )? ) ;
    public final void rule__EndToEndFlowInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3575:1: ( ( ( rule__EndToEndFlowInstance__Group_7__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3576:1: ( ( rule__EndToEndFlowInstance__Group_7__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3576:1: ( ( rule__EndToEndFlowInstance__Group_7__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3577:1: ( rule__EndToEndFlowInstance__Group_7__0 )?
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3578:1: ( rule__EndToEndFlowInstance__Group_7__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==31) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3578:2: rule__EndToEndFlowInstance__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_7__0_in_rule__EndToEndFlowInstance__Group__7__Impl7223);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3588:1: rule__EndToEndFlowInstance__Group__8 : rule__EndToEndFlowInstance__Group__8__Impl ;
    public final void rule__EndToEndFlowInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3592:1: ( rule__EndToEndFlowInstance__Group__8__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3593:2: rule__EndToEndFlowInstance__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group__8__Impl_in_rule__EndToEndFlowInstance__Group__87254);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3599:1: rule__EndToEndFlowInstance__Group__8__Impl : ( 'end' ) ;
    public final void rule__EndToEndFlowInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3603:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3604:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3604:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3605:1: 'end'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_8()); 
            match(input,43,FOLLOW_43_in_rule__EndToEndFlowInstance__Group__8__Impl7282); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3636:1: rule__EndToEndFlowInstance__Group_6__0 : rule__EndToEndFlowInstance__Group_6__0__Impl rule__EndToEndFlowInstance__Group_6__1 ;
    public final void rule__EndToEndFlowInstance__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3640:1: ( rule__EndToEndFlowInstance__Group_6__0__Impl rule__EndToEndFlowInstance__Group_6__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3641:2: rule__EndToEndFlowInstance__Group_6__0__Impl rule__EndToEndFlowInstance__Group_6__1
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_6__0__Impl_in_rule__EndToEndFlowInstance__Group_6__07331);
            rule__EndToEndFlowInstance__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_6__1_in_rule__EndToEndFlowInstance__Group_6__07334);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3648:1: rule__EndToEndFlowInstance__Group_6__0__Impl : ( 'in' ) ;
    public final void rule__EndToEndFlowInstance__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3652:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3653:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3653:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3654:1: 'in'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInKeyword_6_0()); 
            match(input,31,FOLLOW_31_in_rule__EndToEndFlowInstance__Group_6__0__Impl7362); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3667:1: rule__EndToEndFlowInstance__Group_6__1 : rule__EndToEndFlowInstance__Group_6__1__Impl rule__EndToEndFlowInstance__Group_6__2 ;
    public final void rule__EndToEndFlowInstance__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3671:1: ( rule__EndToEndFlowInstance__Group_6__1__Impl rule__EndToEndFlowInstance__Group_6__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3672:2: rule__EndToEndFlowInstance__Group_6__1__Impl rule__EndToEndFlowInstance__Group_6__2
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_6__1__Impl_in_rule__EndToEndFlowInstance__Group_6__17393);
            rule__EndToEndFlowInstance__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_6__2_in_rule__EndToEndFlowInstance__Group_6__17396);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3679:1: rule__EndToEndFlowInstance__Group_6__1__Impl : ( 'mode' ) ;
    public final void rule__EndToEndFlowInstance__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3683:1: ( ( 'mode' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3684:1: ( 'mode' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3684:1: ( 'mode' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3685:1: 'mode'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getModeKeyword_6_1()); 
            match(input,46,FOLLOW_46_in_rule__EndToEndFlowInstance__Group_6__1__Impl7424); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3698:1: rule__EndToEndFlowInstance__Group_6__2 : rule__EndToEndFlowInstance__Group_6__2__Impl ;
    public final void rule__EndToEndFlowInstance__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3702:1: ( rule__EndToEndFlowInstance__Group_6__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3703:2: rule__EndToEndFlowInstance__Group_6__2__Impl
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_6__2__Impl_in_rule__EndToEndFlowInstance__Group_6__27455);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3709:1: rule__EndToEndFlowInstance__Group_6__2__Impl : ( ( rule__EndToEndFlowInstance__InModeAssignment_6_2 ) ) ;
    public final void rule__EndToEndFlowInstance__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3713:1: ( ( ( rule__EndToEndFlowInstance__InModeAssignment_6_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3714:1: ( ( rule__EndToEndFlowInstance__InModeAssignment_6_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3714:1: ( ( rule__EndToEndFlowInstance__InModeAssignment_6_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3715:1: ( rule__EndToEndFlowInstance__InModeAssignment_6_2 )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInModeAssignment_6_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3716:1: ( rule__EndToEndFlowInstance__InModeAssignment_6_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3716:2: rule__EndToEndFlowInstance__InModeAssignment_6_2
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__InModeAssignment_6_2_in_rule__EndToEndFlowInstance__Group_6__2__Impl7482);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3732:1: rule__EndToEndFlowInstance__Group_7__0 : rule__EndToEndFlowInstance__Group_7__0__Impl rule__EndToEndFlowInstance__Group_7__1 ;
    public final void rule__EndToEndFlowInstance__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3736:1: ( rule__EndToEndFlowInstance__Group_7__0__Impl rule__EndToEndFlowInstance__Group_7__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3737:2: rule__EndToEndFlowInstance__Group_7__0__Impl rule__EndToEndFlowInstance__Group_7__1
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_7__0__Impl_in_rule__EndToEndFlowInstance__Group_7__07518);
            rule__EndToEndFlowInstance__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_7__1_in_rule__EndToEndFlowInstance__Group_7__07521);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3744:1: rule__EndToEndFlowInstance__Group_7__0__Impl : ( 'in' ) ;
    public final void rule__EndToEndFlowInstance__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3748:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3749:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3749:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3750:1: 'in'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInKeyword_7_0()); 
            match(input,31,FOLLOW_31_in_rule__EndToEndFlowInstance__Group_7__0__Impl7549); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3763:1: rule__EndToEndFlowInstance__Group_7__1 : rule__EndToEndFlowInstance__Group_7__1__Impl rule__EndToEndFlowInstance__Group_7__2 ;
    public final void rule__EndToEndFlowInstance__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3767:1: ( rule__EndToEndFlowInstance__Group_7__1__Impl rule__EndToEndFlowInstance__Group_7__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3768:2: rule__EndToEndFlowInstance__Group_7__1__Impl rule__EndToEndFlowInstance__Group_7__2
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_7__1__Impl_in_rule__EndToEndFlowInstance__Group_7__17580);
            rule__EndToEndFlowInstance__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_7__2_in_rule__EndToEndFlowInstance__Group_7__17583);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3775:1: rule__EndToEndFlowInstance__Group_7__1__Impl : ( 'som' ) ;
    public final void rule__EndToEndFlowInstance__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3779:1: ( ( 'som' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3780:1: ( 'som' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3780:1: ( 'som' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3781:1: 'som'
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getSomKeyword_7_1()); 
            match(input,52,FOLLOW_52_in_rule__EndToEndFlowInstance__Group_7__1__Impl7611); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3794:1: rule__EndToEndFlowInstance__Group_7__2 : rule__EndToEndFlowInstance__Group_7__2__Impl ;
    public final void rule__EndToEndFlowInstance__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3798:1: ( rule__EndToEndFlowInstance__Group_7__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3799:2: rule__EndToEndFlowInstance__Group_7__2__Impl
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__Group_7__2__Impl_in_rule__EndToEndFlowInstance__Group_7__27642);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3805:1: rule__EndToEndFlowInstance__Group_7__2__Impl : ( ( rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2 ) ) ;
    public final void rule__EndToEndFlowInstance__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3809:1: ( ( ( rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3810:1: ( ( rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3810:1: ( ( rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3811:1: ( rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2 )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeAssignment_7_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3812:1: ( rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3812:2: rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2
            {
            pushFollow(FOLLOW_rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2_in_rule__EndToEndFlowInstance__Group_7__2__Impl7669);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3828:1: rule__SystemOperationMode__Group__0 : rule__SystemOperationMode__Group__0__Impl rule__SystemOperationMode__Group__1 ;
    public final void rule__SystemOperationMode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3832:1: ( rule__SystemOperationMode__Group__0__Impl rule__SystemOperationMode__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3833:2: rule__SystemOperationMode__Group__0__Impl rule__SystemOperationMode__Group__1
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__Group__0__Impl_in_rule__SystemOperationMode__Group__07705);
            rule__SystemOperationMode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemOperationMode__Group__1_in_rule__SystemOperationMode__Group__07708);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3840:1: rule__SystemOperationMode__Group__0__Impl : ( 'som' ) ;
    public final void rule__SystemOperationMode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3844:1: ( ( 'som' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3845:1: ( 'som' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3845:1: ( 'som' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3846:1: 'som'
            {
             before(grammarAccess.getSystemOperationModeAccess().getSomKeyword_0()); 
            match(input,52,FOLLOW_52_in_rule__SystemOperationMode__Group__0__Impl7736); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3859:1: rule__SystemOperationMode__Group__1 : rule__SystemOperationMode__Group__1__Impl ;
    public final void rule__SystemOperationMode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3863:1: ( rule__SystemOperationMode__Group__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3864:2: rule__SystemOperationMode__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__Group__1__Impl_in_rule__SystemOperationMode__Group__17767);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3870:1: rule__SystemOperationMode__Group__1__Impl : ( ( rule__SystemOperationMode__NameAssignment_1 ) ) ;
    public final void rule__SystemOperationMode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3874:1: ( ( ( rule__SystemOperationMode__NameAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3875:1: ( ( rule__SystemOperationMode__NameAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3875:1: ( ( rule__SystemOperationMode__NameAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3876:1: ( rule__SystemOperationMode__NameAssignment_1 )
            {
             before(grammarAccess.getSystemOperationModeAccess().getNameAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3877:1: ( rule__SystemOperationMode__NameAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3877:2: rule__SystemOperationMode__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__NameAssignment_1_in_rule__SystemOperationMode__Group__1__Impl7794);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3891:1: rule__ConnectionInstance__Group__0 : rule__ConnectionInstance__Group__0__Impl rule__ConnectionInstance__Group__1 ;
    public final void rule__ConnectionInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3895:1: ( rule__ConnectionInstance__Group__0__Impl rule__ConnectionInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3896:2: rule__ConnectionInstance__Group__0__Impl rule__ConnectionInstance__Group__1
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__0__Impl_in_rule__ConnectionInstance__Group__07828);
            rule__ConnectionInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__1_in_rule__ConnectionInstance__Group__07831);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3903:1: rule__ConnectionInstance__Group__0__Impl : ( ( rule__ConnectionInstance__KindAssignment_0 ) ) ;
    public final void rule__ConnectionInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3907:1: ( ( ( rule__ConnectionInstance__KindAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3908:1: ( ( rule__ConnectionInstance__KindAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3908:1: ( ( rule__ConnectionInstance__KindAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3909:1: ( rule__ConnectionInstance__KindAssignment_0 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getKindAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3910:1: ( rule__ConnectionInstance__KindAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3910:2: rule__ConnectionInstance__KindAssignment_0
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__KindAssignment_0_in_rule__ConnectionInstance__Group__0__Impl7858);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3920:1: rule__ConnectionInstance__Group__1 : rule__ConnectionInstance__Group__1__Impl rule__ConnectionInstance__Group__2 ;
    public final void rule__ConnectionInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3924:1: ( rule__ConnectionInstance__Group__1__Impl rule__ConnectionInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3925:2: rule__ConnectionInstance__Group__1__Impl rule__ConnectionInstance__Group__2
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__1__Impl_in_rule__ConnectionInstance__Group__17888);
            rule__ConnectionInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__2_in_rule__ConnectionInstance__Group__17891);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3932:1: rule__ConnectionInstance__Group__1__Impl : ( 'connection' ) ;
    public final void rule__ConnectionInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3936:1: ( ( 'connection' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3937:1: ( 'connection' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3937:1: ( 'connection' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3938:1: 'connection'
            {
             before(grammarAccess.getConnectionInstanceAccess().getConnectionKeyword_1()); 
            match(input,53,FOLLOW_53_in_rule__ConnectionInstance__Group__1__Impl7919); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3951:1: rule__ConnectionInstance__Group__2 : rule__ConnectionInstance__Group__2__Impl rule__ConnectionInstance__Group__3 ;
    public final void rule__ConnectionInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3955:1: ( rule__ConnectionInstance__Group__2__Impl rule__ConnectionInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3956:2: rule__ConnectionInstance__Group__2__Impl rule__ConnectionInstance__Group__3
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__2__Impl_in_rule__ConnectionInstance__Group__27950);
            rule__ConnectionInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__3_in_rule__ConnectionInstance__Group__27953);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3963:1: rule__ConnectionInstance__Group__2__Impl : ( 'instance' ) ;
    public final void rule__ConnectionInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3967:1: ( ( 'instance' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3968:1: ( 'instance' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3968:1: ( 'instance' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3969:1: 'instance'
            {
             before(grammarAccess.getConnectionInstanceAccess().getInstanceKeyword_2()); 
            match(input,41,FOLLOW_41_in_rule__ConnectionInstance__Group__2__Impl7981); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3982:1: rule__ConnectionInstance__Group__3 : rule__ConnectionInstance__Group__3__Impl rule__ConnectionInstance__Group__4 ;
    public final void rule__ConnectionInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3986:1: ( rule__ConnectionInstance__Group__3__Impl rule__ConnectionInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3987:2: rule__ConnectionInstance__Group__3__Impl rule__ConnectionInstance__Group__4
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__3__Impl_in_rule__ConnectionInstance__Group__38012);
            rule__ConnectionInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__4_in_rule__ConnectionInstance__Group__38015);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3994:1: rule__ConnectionInstance__Group__3__Impl : ( 'of' ) ;
    public final void rule__ConnectionInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3998:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3999:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3999:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4000:1: 'of'
            {
             before(grammarAccess.getConnectionInstanceAccess().getOfKeyword_3()); 
            match(input,42,FOLLOW_42_in_rule__ConnectionInstance__Group__3__Impl8043); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4013:1: rule__ConnectionInstance__Group__4 : rule__ConnectionInstance__Group__4__Impl rule__ConnectionInstance__Group__5 ;
    public final void rule__ConnectionInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4017:1: ( rule__ConnectionInstance__Group__4__Impl rule__ConnectionInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4018:2: rule__ConnectionInstance__Group__4__Impl rule__ConnectionInstance__Group__5
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__4__Impl_in_rule__ConnectionInstance__Group__48074);
            rule__ConnectionInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__5_in_rule__ConnectionInstance__Group__48077);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4025:1: rule__ConnectionInstance__Group__4__Impl : ( ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )* ) ) ;
    public final void rule__ConnectionInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4029:1: ( ( ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4030:1: ( ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4030:1: ( ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4031:1: ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4031:1: ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4032:1: ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4033:1: ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4033:2: rule__ConnectionInstance__ConnectionReferenceAssignment_4
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__ConnectionReferenceAssignment_4_in_rule__ConnectionInstance__Group__4__Impl8106);
            rule__ConnectionInstance__ConnectionReferenceAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceAssignment_4()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4036:1: ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4037:1: ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )*
            {
             before(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4038:1: ( rule__ConnectionInstance__ConnectionReferenceAssignment_4 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==42) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4038:2: rule__ConnectionInstance__ConnectionReferenceAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__ConnectionInstance__ConnectionReferenceAssignment_4_in_rule__ConnectionInstance__Group__4__Impl8118);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4049:1: rule__ConnectionInstance__Group__5 : rule__ConnectionInstance__Group__5__Impl rule__ConnectionInstance__Group__6 ;
    public final void rule__ConnectionInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4053:1: ( rule__ConnectionInstance__Group__5__Impl rule__ConnectionInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4054:2: rule__ConnectionInstance__Group__5__Impl rule__ConnectionInstance__Group__6
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__5__Impl_in_rule__ConnectionInstance__Group__58151);
            rule__ConnectionInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__6_in_rule__ConnectionInstance__Group__58154);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4061:1: rule__ConnectionInstance__Group__5__Impl : ( 'src' ) ;
    public final void rule__ConnectionInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4065:1: ( ( 'src' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4066:1: ( 'src' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4066:1: ( 'src' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4067:1: 'src'
            {
             before(grammarAccess.getConnectionInstanceAccess().getSrcKeyword_5()); 
            match(input,48,FOLLOW_48_in_rule__ConnectionInstance__Group__5__Impl8182); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4080:1: rule__ConnectionInstance__Group__6 : rule__ConnectionInstance__Group__6__Impl rule__ConnectionInstance__Group__7 ;
    public final void rule__ConnectionInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4084:1: ( rule__ConnectionInstance__Group__6__Impl rule__ConnectionInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4085:2: rule__ConnectionInstance__Group__6__Impl rule__ConnectionInstance__Group__7
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__6__Impl_in_rule__ConnectionInstance__Group__68213);
            rule__ConnectionInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__7_in_rule__ConnectionInstance__Group__68216);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4092:1: rule__ConnectionInstance__Group__6__Impl : ( ( rule__ConnectionInstance__SourceAssignment_6 ) ) ;
    public final void rule__ConnectionInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4096:1: ( ( ( rule__ConnectionInstance__SourceAssignment_6 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4097:1: ( ( rule__ConnectionInstance__SourceAssignment_6 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4097:1: ( ( rule__ConnectionInstance__SourceAssignment_6 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4098:1: ( rule__ConnectionInstance__SourceAssignment_6 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getSourceAssignment_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4099:1: ( rule__ConnectionInstance__SourceAssignment_6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4099:2: rule__ConnectionInstance__SourceAssignment_6
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__SourceAssignment_6_in_rule__ConnectionInstance__Group__6__Impl8243);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4109:1: rule__ConnectionInstance__Group__7 : rule__ConnectionInstance__Group__7__Impl rule__ConnectionInstance__Group__8 ;
    public final void rule__ConnectionInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4113:1: ( rule__ConnectionInstance__Group__7__Impl rule__ConnectionInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4114:2: rule__ConnectionInstance__Group__7__Impl rule__ConnectionInstance__Group__8
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__7__Impl_in_rule__ConnectionInstance__Group__78273);
            rule__ConnectionInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__8_in_rule__ConnectionInstance__Group__78276);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4121:1: rule__ConnectionInstance__Group__7__Impl : ( 'dst' ) ;
    public final void rule__ConnectionInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4125:1: ( ( 'dst' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4126:1: ( 'dst' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4126:1: ( 'dst' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4127:1: 'dst'
            {
             before(grammarAccess.getConnectionInstanceAccess().getDstKeyword_7()); 
            match(input,49,FOLLOW_49_in_rule__ConnectionInstance__Group__7__Impl8304); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4140:1: rule__ConnectionInstance__Group__8 : rule__ConnectionInstance__Group__8__Impl rule__ConnectionInstance__Group__9 ;
    public final void rule__ConnectionInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4144:1: ( rule__ConnectionInstance__Group__8__Impl rule__ConnectionInstance__Group__9 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4145:2: rule__ConnectionInstance__Group__8__Impl rule__ConnectionInstance__Group__9
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__8__Impl_in_rule__ConnectionInstance__Group__88335);
            rule__ConnectionInstance__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__9_in_rule__ConnectionInstance__Group__88338);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4152:1: rule__ConnectionInstance__Group__8__Impl : ( ( rule__ConnectionInstance__DestinationAssignment_8 ) ) ;
    public final void rule__ConnectionInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4156:1: ( ( ( rule__ConnectionInstance__DestinationAssignment_8 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4157:1: ( ( rule__ConnectionInstance__DestinationAssignment_8 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4157:1: ( ( rule__ConnectionInstance__DestinationAssignment_8 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4158:1: ( rule__ConnectionInstance__DestinationAssignment_8 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getDestinationAssignment_8()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4159:1: ( rule__ConnectionInstance__DestinationAssignment_8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4159:2: rule__ConnectionInstance__DestinationAssignment_8
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__DestinationAssignment_8_in_rule__ConnectionInstance__Group__8__Impl8365);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4169:1: rule__ConnectionInstance__Group__9 : rule__ConnectionInstance__Group__9__Impl rule__ConnectionInstance__Group__10 ;
    public final void rule__ConnectionInstance__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4173:1: ( rule__ConnectionInstance__Group__9__Impl rule__ConnectionInstance__Group__10 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4174:2: rule__ConnectionInstance__Group__9__Impl rule__ConnectionInstance__Group__10
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__9__Impl_in_rule__ConnectionInstance__Group__98395);
            rule__ConnectionInstance__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__10_in_rule__ConnectionInstance__Group__98398);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4181:1: rule__ConnectionInstance__Group__9__Impl : ( ( rule__ConnectionInstance__Group_9__0 )? ) ;
    public final void rule__ConnectionInstance__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4185:1: ( ( ( rule__ConnectionInstance__Group_9__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4186:1: ( ( rule__ConnectionInstance__Group_9__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4186:1: ( ( rule__ConnectionInstance__Group_9__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4187:1: ( rule__ConnectionInstance__Group_9__0 )?
            {
             before(grammarAccess.getConnectionInstanceAccess().getGroup_9()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4188:1: ( rule__ConnectionInstance__Group_9__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==31) ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==52) ) {
                    alt26=1;
                }
            }
            switch (alt26) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4188:2: rule__ConnectionInstance__Group_9__0
                    {
                    pushFollow(FOLLOW_rule__ConnectionInstance__Group_9__0_in_rule__ConnectionInstance__Group__9__Impl8425);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4198:1: rule__ConnectionInstance__Group__10 : rule__ConnectionInstance__Group__10__Impl rule__ConnectionInstance__Group__11 ;
    public final void rule__ConnectionInstance__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4202:1: ( rule__ConnectionInstance__Group__10__Impl rule__ConnectionInstance__Group__11 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4203:2: rule__ConnectionInstance__Group__10__Impl rule__ConnectionInstance__Group__11
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__10__Impl_in_rule__ConnectionInstance__Group__108456);
            rule__ConnectionInstance__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__11_in_rule__ConnectionInstance__Group__108459);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4210:1: rule__ConnectionInstance__Group__10__Impl : ( ( rule__ConnectionInstance__Group_10__0 )? ) ;
    public final void rule__ConnectionInstance__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4214:1: ( ( ( rule__ConnectionInstance__Group_10__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4215:1: ( ( rule__ConnectionInstance__Group_10__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4215:1: ( ( rule__ConnectionInstance__Group_10__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4216:1: ( rule__ConnectionInstance__Group_10__0 )?
            {
             before(grammarAccess.getConnectionInstanceAccess().getGroup_10()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4217:1: ( rule__ConnectionInstance__Group_10__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==31) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4217:2: rule__ConnectionInstance__Group_10__0
                    {
                    pushFollow(FOLLOW_rule__ConnectionInstance__Group_10__0_in_rule__ConnectionInstance__Group__10__Impl8486);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4227:1: rule__ConnectionInstance__Group__11 : rule__ConnectionInstance__Group__11__Impl rule__ConnectionInstance__Group__12 ;
    public final void rule__ConnectionInstance__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4231:1: ( rule__ConnectionInstance__Group__11__Impl rule__ConnectionInstance__Group__12 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4232:2: rule__ConnectionInstance__Group__11__Impl rule__ConnectionInstance__Group__12
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__11__Impl_in_rule__ConnectionInstance__Group__118517);
            rule__ConnectionInstance__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__12_in_rule__ConnectionInstance__Group__118520);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4239:1: rule__ConnectionInstance__Group__11__Impl : ( ( rule__ConnectionInstance__CompleteAssignment_11 )? ) ;
    public final void rule__ConnectionInstance__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4243:1: ( ( ( rule__ConnectionInstance__CompleteAssignment_11 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4244:1: ( ( rule__ConnectionInstance__CompleteAssignment_11 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4244:1: ( ( rule__ConnectionInstance__CompleteAssignment_11 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4245:1: ( rule__ConnectionInstance__CompleteAssignment_11 )?
            {
             before(grammarAccess.getConnectionInstanceAccess().getCompleteAssignment_11()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4246:1: ( rule__ConnectionInstance__CompleteAssignment_11 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==61) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4246:2: rule__ConnectionInstance__CompleteAssignment_11
                    {
                    pushFollow(FOLLOW_rule__ConnectionInstance__CompleteAssignment_11_in_rule__ConnectionInstance__Group__11__Impl8547);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4256:1: rule__ConnectionInstance__Group__12 : rule__ConnectionInstance__Group__12__Impl rule__ConnectionInstance__Group__13 ;
    public final void rule__ConnectionInstance__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4260:1: ( rule__ConnectionInstance__Group__12__Impl rule__ConnectionInstance__Group__13 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4261:2: rule__ConnectionInstance__Group__12__Impl rule__ConnectionInstance__Group__13
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__12__Impl_in_rule__ConnectionInstance__Group__128578);
            rule__ConnectionInstance__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__13_in_rule__ConnectionInstance__Group__128581);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4268:1: rule__ConnectionInstance__Group__12__Impl : ( ( rule__ConnectionInstance__BidirectionalAssignment_12 )? ) ;
    public final void rule__ConnectionInstance__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4272:1: ( ( ( rule__ConnectionInstance__BidirectionalAssignment_12 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4273:1: ( ( rule__ConnectionInstance__BidirectionalAssignment_12 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4273:1: ( ( rule__ConnectionInstance__BidirectionalAssignment_12 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4274:1: ( rule__ConnectionInstance__BidirectionalAssignment_12 )?
            {
             before(grammarAccess.getConnectionInstanceAccess().getBidirectionalAssignment_12()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4275:1: ( rule__ConnectionInstance__BidirectionalAssignment_12 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==62) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4275:2: rule__ConnectionInstance__BidirectionalAssignment_12
                    {
                    pushFollow(FOLLOW_rule__ConnectionInstance__BidirectionalAssignment_12_in_rule__ConnectionInstance__Group__12__Impl8608);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4285:1: rule__ConnectionInstance__Group__13 : rule__ConnectionInstance__Group__13__Impl ;
    public final void rule__ConnectionInstance__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4289:1: ( rule__ConnectionInstance__Group__13__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4290:2: rule__ConnectionInstance__Group__13__Impl
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__13__Impl_in_rule__ConnectionInstance__Group__138639);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4296:1: rule__ConnectionInstance__Group__13__Impl : ( 'end' ) ;
    public final void rule__ConnectionInstance__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4300:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4301:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4301:1: ( 'end' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4302:1: 'end'
            {
             before(grammarAccess.getConnectionInstanceAccess().getEndKeyword_13()); 
            match(input,43,FOLLOW_43_in_rule__ConnectionInstance__Group__13__Impl8667); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4343:1: rule__ConnectionInstance__Group_9__0 : rule__ConnectionInstance__Group_9__0__Impl rule__ConnectionInstance__Group_9__1 ;
    public final void rule__ConnectionInstance__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4347:1: ( rule__ConnectionInstance__Group_9__0__Impl rule__ConnectionInstance__Group_9__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4348:2: rule__ConnectionInstance__Group_9__0__Impl rule__ConnectionInstance__Group_9__1
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group_9__0__Impl_in_rule__ConnectionInstance__Group_9__08726);
            rule__ConnectionInstance__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group_9__1_in_rule__ConnectionInstance__Group_9__08729);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4355:1: rule__ConnectionInstance__Group_9__0__Impl : ( 'in' ) ;
    public final void rule__ConnectionInstance__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4359:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4360:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4360:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4361:1: 'in'
            {
             before(grammarAccess.getConnectionInstanceAccess().getInKeyword_9_0()); 
            match(input,31,FOLLOW_31_in_rule__ConnectionInstance__Group_9__0__Impl8757); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4374:1: rule__ConnectionInstance__Group_9__1 : rule__ConnectionInstance__Group_9__1__Impl rule__ConnectionInstance__Group_9__2 ;
    public final void rule__ConnectionInstance__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4378:1: ( rule__ConnectionInstance__Group_9__1__Impl rule__ConnectionInstance__Group_9__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4379:2: rule__ConnectionInstance__Group_9__1__Impl rule__ConnectionInstance__Group_9__2
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group_9__1__Impl_in_rule__ConnectionInstance__Group_9__18788);
            rule__ConnectionInstance__Group_9__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group_9__2_in_rule__ConnectionInstance__Group_9__18791);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4386:1: rule__ConnectionInstance__Group_9__1__Impl : ( 'som' ) ;
    public final void rule__ConnectionInstance__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4390:1: ( ( 'som' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4391:1: ( 'som' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4391:1: ( 'som' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4392:1: 'som'
            {
             before(grammarAccess.getConnectionInstanceAccess().getSomKeyword_9_1()); 
            match(input,52,FOLLOW_52_in_rule__ConnectionInstance__Group_9__1__Impl8819); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4405:1: rule__ConnectionInstance__Group_9__2 : rule__ConnectionInstance__Group_9__2__Impl ;
    public final void rule__ConnectionInstance__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4409:1: ( rule__ConnectionInstance__Group_9__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4410:2: rule__ConnectionInstance__Group_9__2__Impl
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group_9__2__Impl_in_rule__ConnectionInstance__Group_9__28850);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4416:1: rule__ConnectionInstance__Group_9__2__Impl : ( ( rule__ConnectionInstance__InSystemOperationModeAssignment_9_2 ) ) ;
    public final void rule__ConnectionInstance__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4420:1: ( ( ( rule__ConnectionInstance__InSystemOperationModeAssignment_9_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4421:1: ( ( rule__ConnectionInstance__InSystemOperationModeAssignment_9_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4421:1: ( ( rule__ConnectionInstance__InSystemOperationModeAssignment_9_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4422:1: ( rule__ConnectionInstance__InSystemOperationModeAssignment_9_2 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeAssignment_9_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4423:1: ( rule__ConnectionInstance__InSystemOperationModeAssignment_9_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4423:2: rule__ConnectionInstance__InSystemOperationModeAssignment_9_2
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__InSystemOperationModeAssignment_9_2_in_rule__ConnectionInstance__Group_9__2__Impl8877);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4439:1: rule__ConnectionInstance__Group_10__0 : rule__ConnectionInstance__Group_10__0__Impl rule__ConnectionInstance__Group_10__1 ;
    public final void rule__ConnectionInstance__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4443:1: ( rule__ConnectionInstance__Group_10__0__Impl rule__ConnectionInstance__Group_10__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4444:2: rule__ConnectionInstance__Group_10__0__Impl rule__ConnectionInstance__Group_10__1
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group_10__0__Impl_in_rule__ConnectionInstance__Group_10__08913);
            rule__ConnectionInstance__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group_10__1_in_rule__ConnectionInstance__Group_10__08916);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4451:1: rule__ConnectionInstance__Group_10__0__Impl : ( 'in' ) ;
    public final void rule__ConnectionInstance__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4455:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4456:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4456:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4457:1: 'in'
            {
             before(grammarAccess.getConnectionInstanceAccess().getInKeyword_10_0()); 
            match(input,31,FOLLOW_31_in_rule__ConnectionInstance__Group_10__0__Impl8944); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4470:1: rule__ConnectionInstance__Group_10__1 : rule__ConnectionInstance__Group_10__1__Impl rule__ConnectionInstance__Group_10__2 ;
    public final void rule__ConnectionInstance__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4474:1: ( rule__ConnectionInstance__Group_10__1__Impl rule__ConnectionInstance__Group_10__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4475:2: rule__ConnectionInstance__Group_10__1__Impl rule__ConnectionInstance__Group_10__2
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group_10__1__Impl_in_rule__ConnectionInstance__Group_10__18975);
            rule__ConnectionInstance__Group_10__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group_10__2_in_rule__ConnectionInstance__Group_10__18978);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4482:1: rule__ConnectionInstance__Group_10__1__Impl : ( 'transition' ) ;
    public final void rule__ConnectionInstance__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4486:1: ( ( 'transition' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4487:1: ( 'transition' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4487:1: ( 'transition' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4488:1: 'transition'
            {
             before(grammarAccess.getConnectionInstanceAccess().getTransitionKeyword_10_1()); 
            match(input,47,FOLLOW_47_in_rule__ConnectionInstance__Group_10__1__Impl9006); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4501:1: rule__ConnectionInstance__Group_10__2 : rule__ConnectionInstance__Group_10__2__Impl ;
    public final void rule__ConnectionInstance__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4505:1: ( rule__ConnectionInstance__Group_10__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4506:2: rule__ConnectionInstance__Group_10__2__Impl
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group_10__2__Impl_in_rule__ConnectionInstance__Group_10__29037);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4512:1: rule__ConnectionInstance__Group_10__2__Impl : ( ( rule__ConnectionInstance__InModeTransitionAssignment_10_2 ) ) ;
    public final void rule__ConnectionInstance__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4516:1: ( ( ( rule__ConnectionInstance__InModeTransitionAssignment_10_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4517:1: ( ( rule__ConnectionInstance__InModeTransitionAssignment_10_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4517:1: ( ( rule__ConnectionInstance__InModeTransitionAssignment_10_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4518:1: ( rule__ConnectionInstance__InModeTransitionAssignment_10_2 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getInModeTransitionAssignment_10_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4519:1: ( rule__ConnectionInstance__InModeTransitionAssignment_10_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4519:2: rule__ConnectionInstance__InModeTransitionAssignment_10_2
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__InModeTransitionAssignment_10_2_in_rule__ConnectionInstance__Group_10__2__Impl9064);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4535:1: rule__ConnectionReference__Group__0 : rule__ConnectionReference__Group__0__Impl rule__ConnectionReference__Group__1 ;
    public final void rule__ConnectionReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4539:1: ( rule__ConnectionReference__Group__0__Impl rule__ConnectionReference__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4540:2: rule__ConnectionReference__Group__0__Impl rule__ConnectionReference__Group__1
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__0__Impl_in_rule__ConnectionReference__Group__09100);
            rule__ConnectionReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__1_in_rule__ConnectionReference__Group__09103);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4547:1: rule__ConnectionReference__Group__0__Impl : ( 'of' ) ;
    public final void rule__ConnectionReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4551:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4552:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4552:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4553:1: 'of'
            {
             before(grammarAccess.getConnectionReferenceAccess().getOfKeyword_0()); 
            match(input,42,FOLLOW_42_in_rule__ConnectionReference__Group__0__Impl9131); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4566:1: rule__ConnectionReference__Group__1 : rule__ConnectionReference__Group__1__Impl rule__ConnectionReference__Group__2 ;
    public final void rule__ConnectionReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4570:1: ( rule__ConnectionReference__Group__1__Impl rule__ConnectionReference__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4571:2: rule__ConnectionReference__Group__1__Impl rule__ConnectionReference__Group__2
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__1__Impl_in_rule__ConnectionReference__Group__19162);
            rule__ConnectionReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__2_in_rule__ConnectionReference__Group__19165);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4578:1: rule__ConnectionReference__Group__1__Impl : ( ( rule__ConnectionReference__ConnectionAssignment_1 ) ) ;
    public final void rule__ConnectionReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4582:1: ( ( ( rule__ConnectionReference__ConnectionAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4583:1: ( ( rule__ConnectionReference__ConnectionAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4583:1: ( ( rule__ConnectionReference__ConnectionAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4584:1: ( rule__ConnectionReference__ConnectionAssignment_1 )
            {
             before(grammarAccess.getConnectionReferenceAccess().getConnectionAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4585:1: ( rule__ConnectionReference__ConnectionAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4585:2: rule__ConnectionReference__ConnectionAssignment_1
            {
            pushFollow(FOLLOW_rule__ConnectionReference__ConnectionAssignment_1_in_rule__ConnectionReference__Group__1__Impl9192);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4595:1: rule__ConnectionReference__Group__2 : rule__ConnectionReference__Group__2__Impl rule__ConnectionReference__Group__3 ;
    public final void rule__ConnectionReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4599:1: ( rule__ConnectionReference__Group__2__Impl rule__ConnectionReference__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4600:2: rule__ConnectionReference__Group__2__Impl rule__ConnectionReference__Group__3
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__2__Impl_in_rule__ConnectionReference__Group__29222);
            rule__ConnectionReference__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__3_in_rule__ConnectionReference__Group__29225);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4607:1: rule__ConnectionReference__Group__2__Impl : ( 'src' ) ;
    public final void rule__ConnectionReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4611:1: ( ( 'src' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4612:1: ( 'src' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4612:1: ( 'src' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4613:1: 'src'
            {
             before(grammarAccess.getConnectionReferenceAccess().getSrcKeyword_2()); 
            match(input,48,FOLLOW_48_in_rule__ConnectionReference__Group__2__Impl9253); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4626:1: rule__ConnectionReference__Group__3 : rule__ConnectionReference__Group__3__Impl rule__ConnectionReference__Group__4 ;
    public final void rule__ConnectionReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4630:1: ( rule__ConnectionReference__Group__3__Impl rule__ConnectionReference__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4631:2: rule__ConnectionReference__Group__3__Impl rule__ConnectionReference__Group__4
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__3__Impl_in_rule__ConnectionReference__Group__39284);
            rule__ConnectionReference__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__4_in_rule__ConnectionReference__Group__39287);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4638:1: rule__ConnectionReference__Group__3__Impl : ( ( rule__ConnectionReference__SourceAssignment_3 ) ) ;
    public final void rule__ConnectionReference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4642:1: ( ( ( rule__ConnectionReference__SourceAssignment_3 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4643:1: ( ( rule__ConnectionReference__SourceAssignment_3 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4643:1: ( ( rule__ConnectionReference__SourceAssignment_3 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4644:1: ( rule__ConnectionReference__SourceAssignment_3 )
            {
             before(grammarAccess.getConnectionReferenceAccess().getSourceAssignment_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4645:1: ( rule__ConnectionReference__SourceAssignment_3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4645:2: rule__ConnectionReference__SourceAssignment_3
            {
            pushFollow(FOLLOW_rule__ConnectionReference__SourceAssignment_3_in_rule__ConnectionReference__Group__3__Impl9314);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4655:1: rule__ConnectionReference__Group__4 : rule__ConnectionReference__Group__4__Impl rule__ConnectionReference__Group__5 ;
    public final void rule__ConnectionReference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4659:1: ( rule__ConnectionReference__Group__4__Impl rule__ConnectionReference__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4660:2: rule__ConnectionReference__Group__4__Impl rule__ConnectionReference__Group__5
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__4__Impl_in_rule__ConnectionReference__Group__49344);
            rule__ConnectionReference__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__5_in_rule__ConnectionReference__Group__49347);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4667:1: rule__ConnectionReference__Group__4__Impl : ( 'dst' ) ;
    public final void rule__ConnectionReference__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4671:1: ( ( 'dst' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4672:1: ( 'dst' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4672:1: ( 'dst' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4673:1: 'dst'
            {
             before(grammarAccess.getConnectionReferenceAccess().getDstKeyword_4()); 
            match(input,49,FOLLOW_49_in_rule__ConnectionReference__Group__4__Impl9375); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4686:1: rule__ConnectionReference__Group__5 : rule__ConnectionReference__Group__5__Impl rule__ConnectionReference__Group__6 ;
    public final void rule__ConnectionReference__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4690:1: ( rule__ConnectionReference__Group__5__Impl rule__ConnectionReference__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4691:2: rule__ConnectionReference__Group__5__Impl rule__ConnectionReference__Group__6
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__5__Impl_in_rule__ConnectionReference__Group__59406);
            rule__ConnectionReference__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__6_in_rule__ConnectionReference__Group__59409);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4698:1: rule__ConnectionReference__Group__5__Impl : ( ( rule__ConnectionReference__DestinationAssignment_5 ) ) ;
    public final void rule__ConnectionReference__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4702:1: ( ( ( rule__ConnectionReference__DestinationAssignment_5 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4703:1: ( ( rule__ConnectionReference__DestinationAssignment_5 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4703:1: ( ( rule__ConnectionReference__DestinationAssignment_5 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4704:1: ( rule__ConnectionReference__DestinationAssignment_5 )
            {
             before(grammarAccess.getConnectionReferenceAccess().getDestinationAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4705:1: ( rule__ConnectionReference__DestinationAssignment_5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4705:2: rule__ConnectionReference__DestinationAssignment_5
            {
            pushFollow(FOLLOW_rule__ConnectionReference__DestinationAssignment_5_in_rule__ConnectionReference__Group__5__Impl9436);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4715:1: rule__ConnectionReference__Group__6 : rule__ConnectionReference__Group__6__Impl rule__ConnectionReference__Group__7 ;
    public final void rule__ConnectionReference__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4719:1: ( rule__ConnectionReference__Group__6__Impl rule__ConnectionReference__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4720:2: rule__ConnectionReference__Group__6__Impl rule__ConnectionReference__Group__7
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__6__Impl_in_rule__ConnectionReference__Group__69466);
            rule__ConnectionReference__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__7_in_rule__ConnectionReference__Group__69469);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4727:1: rule__ConnectionReference__Group__6__Impl : ( 'context' ) ;
    public final void rule__ConnectionReference__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4731:1: ( ( 'context' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4732:1: ( 'context' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4732:1: ( 'context' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4733:1: 'context'
            {
             before(grammarAccess.getConnectionReferenceAccess().getContextKeyword_6()); 
            match(input,54,FOLLOW_54_in_rule__ConnectionReference__Group__6__Impl9497); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4746:1: rule__ConnectionReference__Group__7 : rule__ConnectionReference__Group__7__Impl ;
    public final void rule__ConnectionReference__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4750:1: ( rule__ConnectionReference__Group__7__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4751:2: rule__ConnectionReference__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__7__Impl_in_rule__ConnectionReference__Group__79528);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4757:1: rule__ConnectionReference__Group__7__Impl : ( ( rule__ConnectionReference__ContextAssignment_7 ) ) ;
    public final void rule__ConnectionReference__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4761:1: ( ( ( rule__ConnectionReference__ContextAssignment_7 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4762:1: ( ( rule__ConnectionReference__ContextAssignment_7 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4762:1: ( ( rule__ConnectionReference__ContextAssignment_7 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4763:1: ( rule__ConnectionReference__ContextAssignment_7 )
            {
             before(grammarAccess.getConnectionReferenceAccess().getContextAssignment_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4764:1: ( rule__ConnectionReference__ContextAssignment_7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4764:2: rule__ConnectionReference__ContextAssignment_7
            {
            pushFollow(FOLLOW_rule__ConnectionReference__ContextAssignment_7_in_rule__ConnectionReference__Group__7__Impl9555);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4790:1: rule__ComponentCategory__Group_8__0 : rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1 ;
    public final void rule__ComponentCategory__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4794:1: ( rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4795:2: rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_8__0__Impl_in_rule__ComponentCategory__Group_8__09601);
            rule__ComponentCategory__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_8__1_in_rule__ComponentCategory__Group_8__09604);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4802:1: rule__ComponentCategory__Group_8__0__Impl : ( 'subprogram' ) ;
    public final void rule__ComponentCategory__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4806:1: ( ( 'subprogram' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4807:1: ( 'subprogram' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4807:1: ( 'subprogram' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4808:1: 'subprogram'
            {
             before(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
            match(input,16,FOLLOW_16_in_rule__ComponentCategory__Group_8__0__Impl9632); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4821:1: rule__ComponentCategory__Group_8__1 : rule__ComponentCategory__Group_8__1__Impl ;
    public final void rule__ComponentCategory__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4825:1: ( rule__ComponentCategory__Group_8__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4826:2: rule__ComponentCategory__Group_8__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_8__1__Impl_in_rule__ComponentCategory__Group_8__19663);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4832:1: rule__ComponentCategory__Group_8__1__Impl : ( 'group' ) ;
    public final void rule__ComponentCategory__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4836:1: ( ( 'group' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4837:1: ( 'group' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4837:1: ( 'group' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4838:1: 'group'
            {
             before(grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
            match(input,55,FOLLOW_55_in_rule__ComponentCategory__Group_8__1__Impl9691); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4855:1: rule__ComponentCategory__Group_12__0 : rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1 ;
    public final void rule__ComponentCategory__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4859:1: ( rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4860:2: rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_12__0__Impl_in_rule__ComponentCategory__Group_12__09726);
            rule__ComponentCategory__Group_12__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_12__1_in_rule__ComponentCategory__Group_12__09729);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4867:1: rule__ComponentCategory__Group_12__0__Impl : ( 'virtual' ) ;
    public final void rule__ComponentCategory__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4871:1: ( ( 'virtual' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4872:1: ( 'virtual' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4872:1: ( 'virtual' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4873:1: 'virtual'
            {
             before(grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
            match(input,56,FOLLOW_56_in_rule__ComponentCategory__Group_12__0__Impl9757); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4886:1: rule__ComponentCategory__Group_12__1 : rule__ComponentCategory__Group_12__1__Impl ;
    public final void rule__ComponentCategory__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4890:1: ( rule__ComponentCategory__Group_12__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4891:2: rule__ComponentCategory__Group_12__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_12__1__Impl_in_rule__ComponentCategory__Group_12__19788);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4897:1: rule__ComponentCategory__Group_12__1__Impl : ( 'bus' ) ;
    public final void rule__ComponentCategory__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4901:1: ( ( 'bus' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4902:1: ( 'bus' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4902:1: ( 'bus' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4903:1: 'bus'
            {
             before(grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
            match(input,10,FOLLOW_10_in_rule__ComponentCategory__Group_12__1__Impl9816); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4920:1: rule__FQCREF__Group__0 : rule__FQCREF__Group__0__Impl rule__FQCREF__Group__1 ;
    public final void rule__FQCREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4924:1: ( rule__FQCREF__Group__0__Impl rule__FQCREF__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4925:2: rule__FQCREF__Group__0__Impl rule__FQCREF__Group__1
            {
            pushFollow(FOLLOW_rule__FQCREF__Group__0__Impl_in_rule__FQCREF__Group__09851);
            rule__FQCREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQCREF__Group__1_in_rule__FQCREF__Group__09854);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4932:1: rule__FQCREF__Group__0__Impl : ( ( ( rule__FQCREF__Group_0__0 ) ) ( ( rule__FQCREF__Group_0__0 )* ) ) ;
    public final void rule__FQCREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4936:1: ( ( ( ( rule__FQCREF__Group_0__0 ) ) ( ( rule__FQCREF__Group_0__0 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4937:1: ( ( ( rule__FQCREF__Group_0__0 ) ) ( ( rule__FQCREF__Group_0__0 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4937:1: ( ( ( rule__FQCREF__Group_0__0 ) ) ( ( rule__FQCREF__Group_0__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4938:1: ( ( rule__FQCREF__Group_0__0 ) ) ( ( rule__FQCREF__Group_0__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4938:1: ( ( rule__FQCREF__Group_0__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4939:1: ( rule__FQCREF__Group_0__0 )
            {
             before(grammarAccess.getFQCREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4940:1: ( rule__FQCREF__Group_0__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4940:2: rule__FQCREF__Group_0__0
            {
            pushFollow(FOLLOW_rule__FQCREF__Group_0__0_in_rule__FQCREF__Group__0__Impl9883);
            rule__FQCREF__Group_0__0();

            state._fsp--;


            }

             after(grammarAccess.getFQCREFAccess().getGroup_0()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4943:1: ( ( rule__FQCREF__Group_0__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4944:1: ( rule__FQCREF__Group_0__0 )*
            {
             before(grammarAccess.getFQCREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4945:1: ( rule__FQCREF__Group_0__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID) ) {
                    int LA30_1 = input.LA(2);

                    if ( (LA30_1==57) ) {
                        alt30=1;
                    }


                }


                switch (alt30) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4945:2: rule__FQCREF__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__FQCREF__Group_0__0_in_rule__FQCREF__Group__0__Impl9895);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4956:1: rule__FQCREF__Group__1 : rule__FQCREF__Group__1__Impl rule__FQCREF__Group__2 ;
    public final void rule__FQCREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4960:1: ( rule__FQCREF__Group__1__Impl rule__FQCREF__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4961:2: rule__FQCREF__Group__1__Impl rule__FQCREF__Group__2
            {
            pushFollow(FOLLOW_rule__FQCREF__Group__1__Impl_in_rule__FQCREF__Group__19928);
            rule__FQCREF__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQCREF__Group__2_in_rule__FQCREF__Group__19931);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4968:1: rule__FQCREF__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__FQCREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4972:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4973:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4973:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4974:1: RULE_ID
            {
             before(grammarAccess.getFQCREFAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQCREF__Group__1__Impl9958); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4985:1: rule__FQCREF__Group__2 : rule__FQCREF__Group__2__Impl ;
    public final void rule__FQCREF__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4989:1: ( rule__FQCREF__Group__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4990:2: rule__FQCREF__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__FQCREF__Group__2__Impl_in_rule__FQCREF__Group__29987);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4996:1: rule__FQCREF__Group__2__Impl : ( ( rule__FQCREF__Group_2__0 )? ) ;
    public final void rule__FQCREF__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5000:1: ( ( ( rule__FQCREF__Group_2__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5001:1: ( ( rule__FQCREF__Group_2__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5001:1: ( ( rule__FQCREF__Group_2__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5002:1: ( rule__FQCREF__Group_2__0 )?
            {
             before(grammarAccess.getFQCREFAccess().getGroup_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5003:1: ( rule__FQCREF__Group_2__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==58) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5003:2: rule__FQCREF__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__FQCREF__Group_2__0_in_rule__FQCREF__Group__2__Impl10014);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5019:1: rule__FQCREF__Group_0__0 : rule__FQCREF__Group_0__0__Impl rule__FQCREF__Group_0__1 ;
    public final void rule__FQCREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5023:1: ( rule__FQCREF__Group_0__0__Impl rule__FQCREF__Group_0__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5024:2: rule__FQCREF__Group_0__0__Impl rule__FQCREF__Group_0__1
            {
            pushFollow(FOLLOW_rule__FQCREF__Group_0__0__Impl_in_rule__FQCREF__Group_0__010051);
            rule__FQCREF__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQCREF__Group_0__1_in_rule__FQCREF__Group_0__010054);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5031:1: rule__FQCREF__Group_0__0__Impl : ( RULE_ID ) ;
    public final void rule__FQCREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5035:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5036:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5036:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5037:1: RULE_ID
            {
             before(grammarAccess.getFQCREFAccess().getIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQCREF__Group_0__0__Impl10081); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5048:1: rule__FQCREF__Group_0__1 : rule__FQCREF__Group_0__1__Impl ;
    public final void rule__FQCREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5052:1: ( rule__FQCREF__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5053:2: rule__FQCREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__FQCREF__Group_0__1__Impl_in_rule__FQCREF__Group_0__110110);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5059:1: rule__FQCREF__Group_0__1__Impl : ( '::' ) ;
    public final void rule__FQCREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5063:1: ( ( '::' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5064:1: ( '::' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5064:1: ( '::' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5065:1: '::'
            {
             before(grammarAccess.getFQCREFAccess().getColonColonKeyword_0_1()); 
            match(input,57,FOLLOW_57_in_rule__FQCREF__Group_0__1__Impl10138); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5082:1: rule__FQCREF__Group_2__0 : rule__FQCREF__Group_2__0__Impl rule__FQCREF__Group_2__1 ;
    public final void rule__FQCREF__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5086:1: ( rule__FQCREF__Group_2__0__Impl rule__FQCREF__Group_2__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5087:2: rule__FQCREF__Group_2__0__Impl rule__FQCREF__Group_2__1
            {
            pushFollow(FOLLOW_rule__FQCREF__Group_2__0__Impl_in_rule__FQCREF__Group_2__010173);
            rule__FQCREF__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQCREF__Group_2__1_in_rule__FQCREF__Group_2__010176);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5094:1: rule__FQCREF__Group_2__0__Impl : ( '.' ) ;
    public final void rule__FQCREF__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5098:1: ( ( '.' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5099:1: ( '.' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5099:1: ( '.' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5100:1: '.'
            {
             before(grammarAccess.getFQCREFAccess().getFullStopKeyword_2_0()); 
            match(input,58,FOLLOW_58_in_rule__FQCREF__Group_2__0__Impl10204); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5113:1: rule__FQCREF__Group_2__1 : rule__FQCREF__Group_2__1__Impl ;
    public final void rule__FQCREF__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5117:1: ( rule__FQCREF__Group_2__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5118:2: rule__FQCREF__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__FQCREF__Group_2__1__Impl_in_rule__FQCREF__Group_2__110235);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5124:1: rule__FQCREF__Group_2__1__Impl : ( RULE_ID ) ;
    public final void rule__FQCREF__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5128:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5129:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5129:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5130:1: RULE_ID
            {
             before(grammarAccess.getFQCREFAccess().getIDTerminalRuleCall_2_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQCREF__Group_2__1__Impl10262); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5145:1: rule__INSTANCEREF__Group__0 : rule__INSTANCEREF__Group__0__Impl rule__INSTANCEREF__Group__1 ;
    public final void rule__INSTANCEREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5149:1: ( rule__INSTANCEREF__Group__0__Impl rule__INSTANCEREF__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5150:2: rule__INSTANCEREF__Group__0__Impl rule__INSTANCEREF__Group__1
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group__0__Impl_in_rule__INSTANCEREF__Group__010295);
            rule__INSTANCEREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREF__Group__1_in_rule__INSTANCEREF__Group__010298);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5157:1: rule__INSTANCEREF__Group__0__Impl : ( ( rule__INSTANCEREF__Group_0__0 )* ) ;
    public final void rule__INSTANCEREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5161:1: ( ( ( rule__INSTANCEREF__Group_0__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5162:1: ( ( rule__INSTANCEREF__Group_0__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5162:1: ( ( rule__INSTANCEREF__Group_0__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5163:1: ( rule__INSTANCEREF__Group_0__0 )*
            {
             before(grammarAccess.getINSTANCEREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5164:1: ( rule__INSTANCEREF__Group_0__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID) ) {
                    int LA32_1 = input.LA(2);

                    if ( (LA32_1==58) ) {
                        alt32=1;
                    }


                }


                switch (alt32) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5164:2: rule__INSTANCEREF__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__INSTANCEREF__Group_0__0_in_rule__INSTANCEREF__Group__0__Impl10325);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5174:1: rule__INSTANCEREF__Group__1 : rule__INSTANCEREF__Group__1__Impl ;
    public final void rule__INSTANCEREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5178:1: ( rule__INSTANCEREF__Group__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5179:2: rule__INSTANCEREF__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group__1__Impl_in_rule__INSTANCEREF__Group__110356);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5185:1: rule__INSTANCEREF__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__INSTANCEREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5189:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5190:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5190:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5191:1: RULE_ID
            {
             before(grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__INSTANCEREF__Group__1__Impl10383); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5206:1: rule__INSTANCEREF__Group_0__0 : rule__INSTANCEREF__Group_0__0__Impl rule__INSTANCEREF__Group_0__1 ;
    public final void rule__INSTANCEREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5210:1: ( rule__INSTANCEREF__Group_0__0__Impl rule__INSTANCEREF__Group_0__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5211:2: rule__INSTANCEREF__Group_0__0__Impl rule__INSTANCEREF__Group_0__1
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_0__0__Impl_in_rule__INSTANCEREF__Group_0__010416);
            rule__INSTANCEREF__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREF__Group_0__1_in_rule__INSTANCEREF__Group_0__010419);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5218:1: rule__INSTANCEREF__Group_0__0__Impl : ( RULE_ID ) ;
    public final void rule__INSTANCEREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5222:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5223:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5223:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5224:1: RULE_ID
            {
             before(grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__INSTANCEREF__Group_0__0__Impl10446); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5235:1: rule__INSTANCEREF__Group_0__1 : rule__INSTANCEREF__Group_0__1__Impl ;
    public final void rule__INSTANCEREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5239:1: ( rule__INSTANCEREF__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5240:2: rule__INSTANCEREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_0__1__Impl_in_rule__INSTANCEREF__Group_0__110475);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5246:1: rule__INSTANCEREF__Group_0__1__Impl : ( '.' ) ;
    public final void rule__INSTANCEREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5250:1: ( ( '.' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5251:1: ( '.' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5251:1: ( '.' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5252:1: '.'
            {
             before(grammarAccess.getINSTANCEREFAccess().getFullStopKeyword_0_1()); 
            match(input,58,FOLLOW_58_in_rule__INSTANCEREF__Group_0__1__Impl10503); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5269:1: rule__SOMID__Group__0 : rule__SOMID__Group__0__Impl rule__SOMID__Group__1 ;
    public final void rule__SOMID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5273:1: ( rule__SOMID__Group__0__Impl rule__SOMID__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5274:2: rule__SOMID__Group__0__Impl rule__SOMID__Group__1
            {
            pushFollow(FOLLOW_rule__SOMID__Group__0__Impl_in_rule__SOMID__Group__010538);
            rule__SOMID__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SOMID__Group__1_in_rule__SOMID__Group__010541);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5281:1: rule__SOMID__Group__0__Impl : ( ( rule__SOMID__Group_0__0 )* ) ;
    public final void rule__SOMID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5285:1: ( ( ( rule__SOMID__Group_0__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5286:1: ( ( rule__SOMID__Group_0__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5286:1: ( ( rule__SOMID__Group_0__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5287:1: ( rule__SOMID__Group_0__0 )*
            {
             before(grammarAccess.getSOMIDAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5288:1: ( rule__SOMID__Group_0__0 )*
            loop33:
            do {
                int alt33=2;
                alt33 = dfa33.predict(input);
                switch (alt33) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5288:2: rule__SOMID__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__SOMID__Group_0__0_in_rule__SOMID__Group__0__Impl10568);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5298:1: rule__SOMID__Group__1 : rule__SOMID__Group__1__Impl ;
    public final void rule__SOMID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5302:1: ( rule__SOMID__Group__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5303:2: rule__SOMID__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SOMID__Group__1__Impl_in_rule__SOMID__Group__110599);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5309:1: rule__SOMID__Group__1__Impl : ( ruleINSTANCEREF ) ;
    public final void rule__SOMID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5313:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5314:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5314:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5315:1: ruleINSTANCEREF
            {
             before(grammarAccess.getSOMIDAccess().getINSTANCEREFParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__SOMID__Group__1__Impl10626);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5330:1: rule__SOMID__Group_0__0 : rule__SOMID__Group_0__0__Impl rule__SOMID__Group_0__1 ;
    public final void rule__SOMID__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5334:1: ( rule__SOMID__Group_0__0__Impl rule__SOMID__Group_0__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5335:2: rule__SOMID__Group_0__0__Impl rule__SOMID__Group_0__1
            {
            pushFollow(FOLLOW_rule__SOMID__Group_0__0__Impl_in_rule__SOMID__Group_0__010659);
            rule__SOMID__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SOMID__Group_0__1_in_rule__SOMID__Group_0__010662);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5342:1: rule__SOMID__Group_0__0__Impl : ( ruleINSTANCEREF ) ;
    public final void rule__SOMID__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5346:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5347:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5347:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5348:1: ruleINSTANCEREF
            {
             before(grammarAccess.getSOMIDAccess().getINSTANCEREFParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__SOMID__Group_0__0__Impl10689);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5359:1: rule__SOMID__Group_0__1 : rule__SOMID__Group_0__1__Impl ;
    public final void rule__SOMID__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5363:1: ( rule__SOMID__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5364:2: rule__SOMID__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__SOMID__Group_0__1__Impl_in_rule__SOMID__Group_0__110718);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5370:1: rule__SOMID__Group_0__1__Impl : ( '#' ) ;
    public final void rule__SOMID__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5374:1: ( ( '#' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5375:1: ( '#' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5375:1: ( '#' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5376:1: '#'
            {
             before(grammarAccess.getSOMIDAccess().getNumberSignKeyword_0_1()); 
            match(input,59,FOLLOW_59_in_rule__SOMID__Group_0__1__Impl10746); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5394:1: rule__SystemInstance__CategoryAssignment_0 : ( ruleComponentCategory ) ;
    public final void rule__SystemInstance__CategoryAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5398:1: ( ( ruleComponentCategory ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5399:1: ( ruleComponentCategory )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5399:1: ( ruleComponentCategory )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5400:1: ruleComponentCategory
            {
             before(grammarAccess.getSystemInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_rule__SystemInstance__CategoryAssignment_010786);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5409:1: rule__SystemInstance__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SystemInstance__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5413:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5414:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5414:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5415:1: RULE_ID
            {
             before(grammarAccess.getSystemInstanceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SystemInstance__NameAssignment_110817); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5424:1: rule__SystemInstance__ComponentImplementationAssignment_3 : ( ( ruleFQCREF ) ) ;
    public final void rule__SystemInstance__ComponentImplementationAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5428:1: ( ( ( ruleFQCREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5429:1: ( ( ruleFQCREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5429:1: ( ( ruleFQCREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5430:1: ( ruleFQCREF )
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationCrossReference_3_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5431:1: ( ruleFQCREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5432:1: ruleFQCREF
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationFQCREFParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_ruleFQCREF_in_rule__SystemInstance__ComponentImplementationAssignment_310852);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5443:1: rule__SystemInstance__SystemOperationModeAssignment_5 : ( ruleSystemOperationMode ) ;
    public final void rule__SystemInstance__SystemOperationModeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5447:1: ( ( ruleSystemOperationMode ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5448:1: ( ruleSystemOperationMode )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5448:1: ( ruleSystemOperationMode )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5449:1: ruleSystemOperationMode
            {
             before(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleSystemOperationMode_in_rule__SystemInstance__SystemOperationModeAssignment_510887);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5458:1: rule__ComponentInstance__CategoryAssignment_0 : ( ruleComponentCategory ) ;
    public final void rule__ComponentInstance__CategoryAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5462:1: ( ( ruleComponentCategory ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5463:1: ( ruleComponentCategory )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5463:1: ( ruleComponentCategory )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5464:1: ruleComponentCategory
            {
             before(grammarAccess.getComponentInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_rule__ComponentInstance__CategoryAssignment_010918);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5473:1: rule__ComponentInstance__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ComponentInstance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5477:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5478:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5478:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5479:1: RULE_ID
            {
             before(grammarAccess.getComponentInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ComponentInstance__NameAssignment_210949); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5488:1: rule__ComponentInstance__IndexAssignment_3_1 : ( ruleINTVALUE ) ;
    public final void rule__ComponentInstance__IndexAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5492:1: ( ( ruleINTVALUE ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5493:1: ( ruleINTVALUE )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5493:1: ( ruleINTVALUE )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5494:1: ruleINTVALUE
            {
             before(grammarAccess.getComponentInstanceAccess().getIndexINTVALUEParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleINTVALUE_in_rule__ComponentInstance__IndexAssignment_3_110980);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5503:1: rule__ComponentInstance__SubcomponentAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__ComponentInstance__SubcomponentAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5507:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5508:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5508:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5509:1: ( RULE_ID )
            {
             before(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentCrossReference_5_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5510:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5511:1: RULE_ID
            {
             before(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ComponentInstance__SubcomponentAssignment_511015); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5522:1: rule__ComponentInstance__FeatureInstanceAssignment_6 : ( ruleFeatureInstance ) ;
    public final void rule__ComponentInstance__FeatureInstanceAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5526:1: ( ( ruleFeatureInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5527:1: ( ruleFeatureInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5527:1: ( ruleFeatureInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5528:1: ruleFeatureInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_rule__ComponentInstance__FeatureInstanceAssignment_611050);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5537:1: rule__ComponentInstance__ComponentInstanceAssignment_7 : ( ruleComponentInstance ) ;
    public final void rule__ComponentInstance__ComponentInstanceAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5541:1: ( ( ruleComponentInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5542:1: ( ruleComponentInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5542:1: ( ruleComponentInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5543:1: ruleComponentInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleComponentInstance_in_rule__ComponentInstance__ComponentInstanceAssignment_711081);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5552:1: rule__ComponentInstance__ModeInstanceAssignment_8 : ( ruleModeInstance ) ;
    public final void rule__ComponentInstance__ModeInstanceAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5556:1: ( ( ruleModeInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5557:1: ( ruleModeInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5557:1: ( ruleModeInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5558:1: ruleModeInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getModeInstanceModeInstanceParserRuleCall_8_0()); 
            pushFollow(FOLLOW_ruleModeInstance_in_rule__ComponentInstance__ModeInstanceAssignment_811112);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5567:1: rule__ComponentInstance__ModeTransitionInstanceAssignment_9 : ( ruleModeTransitionInstance ) ;
    public final void rule__ComponentInstance__ModeTransitionInstanceAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5571:1: ( ( ruleModeTransitionInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5572:1: ( ruleModeTransitionInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5572:1: ( ruleModeTransitionInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5573:1: ruleModeTransitionInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getModeTransitionInstanceModeTransitionInstanceParserRuleCall_9_0()); 
            pushFollow(FOLLOW_ruleModeTransitionInstance_in_rule__ComponentInstance__ModeTransitionInstanceAssignment_911143);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5582:1: rule__ComponentInstance__FlowSpecificationAssignment_10 : ( ruleFlowSpecInstance ) ;
    public final void rule__ComponentInstance__FlowSpecificationAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5586:1: ( ( ruleFlowSpecInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5587:1: ( ruleFlowSpecInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5587:1: ( ruleFlowSpecInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5588:1: ruleFlowSpecInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getFlowSpecificationFlowSpecInstanceParserRuleCall_10_0()); 
            pushFollow(FOLLOW_ruleFlowSpecInstance_in_rule__ComponentInstance__FlowSpecificationAssignment_1011174);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5597:1: rule__ComponentInstance__EndToEndFlowAssignment_11 : ( ruleEndToEndFlowInstance ) ;
    public final void rule__ComponentInstance__EndToEndFlowAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5601:1: ( ( ruleEndToEndFlowInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5602:1: ( ruleEndToEndFlowInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5602:1: ( ruleEndToEndFlowInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5603:1: ruleEndToEndFlowInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getEndToEndFlowEndToEndFlowInstanceParserRuleCall_11_0()); 
            pushFollow(FOLLOW_ruleEndToEndFlowInstance_in_rule__ComponentInstance__EndToEndFlowAssignment_1111205);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5612:1: rule__ComponentInstance__ConnectionInstanceAssignment_12 : ( ruleConnectionInstance ) ;
    public final void rule__ComponentInstance__ConnectionInstanceAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5616:1: ( ( ruleConnectionInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5617:1: ( ruleConnectionInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5617:1: ( ruleConnectionInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5618:1: ruleConnectionInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_12_0()); 
            pushFollow(FOLLOW_ruleConnectionInstance_in_rule__ComponentInstance__ConnectionInstanceAssignment_1211236);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5627:1: rule__ComponentInstance__InModeAssignment_13_2 : ( ( RULE_ID ) ) ;
    public final void rule__ComponentInstance__InModeAssignment_13_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5631:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5632:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5632:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5633:1: ( RULE_ID )
            {
             before(grammarAccess.getComponentInstanceAccess().getInModeModeInstanceCrossReference_13_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5634:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5635:1: RULE_ID
            {
             before(grammarAccess.getComponentInstanceAccess().getInModeModeInstanceIDTerminalRuleCall_13_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ComponentInstance__InModeAssignment_13_211271); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5646:1: rule__FeatureInstance__CategoryAssignment_0 : ( ruleFeatureCategory ) ;
    public final void rule__FeatureInstance__CategoryAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5650:1: ( ( ruleFeatureCategory ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5651:1: ( ruleFeatureCategory )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5651:1: ( ruleFeatureCategory )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5652:1: ruleFeatureCategory
            {
             before(grammarAccess.getFeatureInstanceAccess().getCategoryFeatureCategoryParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleFeatureCategory_in_rule__FeatureInstance__CategoryAssignment_011306);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5661:1: rule__FeatureInstance__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__FeatureInstance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5665:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5666:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5666:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5667:1: RULE_ID
            {
             before(grammarAccess.getFeatureInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FeatureInstance__NameAssignment_211337); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5676:1: rule__FeatureInstance__IndexAssignment_3_1 : ( ruleINTVALUE ) ;
    public final void rule__FeatureInstance__IndexAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5680:1: ( ( ruleINTVALUE ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5681:1: ( ruleINTVALUE )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5681:1: ( ruleINTVALUE )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5682:1: ruleINTVALUE
            {
             before(grammarAccess.getFeatureInstanceAccess().getIndexINTVALUEParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleINTVALUE_in_rule__FeatureInstance__IndexAssignment_3_111368);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5691:1: rule__FeatureInstance__FeatureAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__FeatureInstance__FeatureAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5695:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5696:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5696:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5697:1: ( RULE_ID )
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureCrossReference_5_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5698:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5699:1: RULE_ID
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FeatureInstance__FeatureAssignment_511403); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5710:1: rule__FeatureInstance__DirectionAssignment_6 : ( ruleDirectionType ) ;
    public final void rule__FeatureInstance__DirectionAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5714:1: ( ( ruleDirectionType ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5715:1: ( ruleDirectionType )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5715:1: ( ruleDirectionType )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5716:1: ruleDirectionType
            {
             before(grammarAccess.getFeatureInstanceAccess().getDirectionDirectionTypeParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleDirectionType_in_rule__FeatureInstance__DirectionAssignment_611438);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5725:1: rule__FeatureInstance__FeatureInstanceAssignment_7 : ( ruleFeatureInstance ) ;
    public final void rule__FeatureInstance__FeatureInstanceAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5729:1: ( ( ruleFeatureInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5730:1: ( ruleFeatureInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5730:1: ( ruleFeatureInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5731:1: ruleFeatureInstance
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_rule__FeatureInstance__FeatureInstanceAssignment_711469);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5740:1: rule__ModeInstance__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ModeInstance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5744:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5745:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5745:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5746:1: RULE_ID
            {
             before(grammarAccess.getModeInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ModeInstance__NameAssignment_211500); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5755:1: rule__ModeInstance__ModeAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__ModeInstance__ModeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5759:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5760:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5760:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5761:1: ( RULE_ID )
            {
             before(grammarAccess.getModeInstanceAccess().getModeModeCrossReference_4_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5762:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5763:1: RULE_ID
            {
             before(grammarAccess.getModeInstanceAccess().getModeModeIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ModeInstance__ModeAssignment_411535); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5774:1: rule__ModeInstance__InitialAssignment_5 : ( ( 'initial' ) ) ;
    public final void rule__ModeInstance__InitialAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5778:1: ( ( ( 'initial' ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5779:1: ( ( 'initial' ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5779:1: ( ( 'initial' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5780:1: ( 'initial' )
            {
             before(grammarAccess.getModeInstanceAccess().getInitialInitialKeyword_5_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5781:1: ( 'initial' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5782:1: 'initial'
            {
             before(grammarAccess.getModeInstanceAccess().getInitialInitialKeyword_5_0()); 
            match(input,60,FOLLOW_60_in_rule__ModeInstance__InitialAssignment_511575); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5797:1: rule__ModeTransitionInstance__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__ModeTransitionInstance__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5801:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5802:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5802:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5803:1: RULE_ID
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__NameAssignment_311614); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5812:1: rule__ModeTransitionInstance__ModeTransitionAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__ModeTransitionInstance__ModeTransitionAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5816:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5817:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5817:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5818:1: ( RULE_ID )
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionModeTransitionCrossReference_5_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5819:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5820:1: RULE_ID
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionModeTransitionIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__ModeTransitionAssignment_511649); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5831:1: rule__ModeTransitionInstance__SourceAssignment_7 : ( ( RULE_ID ) ) ;
    public final void rule__ModeTransitionInstance__SourceAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5835:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5836:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5836:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5837:1: ( RULE_ID )
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getSourceModeInstanceCrossReference_7_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5838:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5839:1: RULE_ID
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getSourceModeInstanceIDTerminalRuleCall_7_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__SourceAssignment_711688); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5850:1: rule__ModeTransitionInstance__DestinationAssignment_9 : ( ( RULE_ID ) ) ;
    public final void rule__ModeTransitionInstance__DestinationAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5854:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5855:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5855:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5856:1: ( RULE_ID )
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getDestinationModeInstanceCrossReference_9_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5857:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5858:1: RULE_ID
            {
             before(grammarAccess.getModeTransitionInstanceAccess().getDestinationModeInstanceIDTerminalRuleCall_9_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__DestinationAssignment_911727); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5869:1: rule__FlowSpecInstance__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__FlowSpecInstance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5873:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5874:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5874:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5875:1: RULE_ID
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FlowSpecInstance__NameAssignment_211762); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5884:1: rule__FlowSpecInstance__FlowSpecificationAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__FlowSpecInstance__FlowSpecificationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5888:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5889:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5889:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5890:1: ( RULE_ID )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getFlowSpecificationFlowSpecificationCrossReference_4_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5891:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5892:1: RULE_ID
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getFlowSpecificationFlowSpecificationIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FlowSpecInstance__FlowSpecificationAssignment_411797); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5903:1: rule__FlowSpecInstance__SourceAssignment_5_1 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__FlowSpecInstance__SourceAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5907:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5908:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5908:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5909:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getSourceFeatureInstanceCrossReference_5_1_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5910:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5911:1: ruleINSTANCEREF
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getSourceFeatureInstanceINSTANCEREFParserRuleCall_5_1_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__FlowSpecInstance__SourceAssignment_5_111836);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5922:1: rule__FlowSpecInstance__DestinationAssignment_6_1 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__FlowSpecInstance__DestinationAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5926:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5927:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5927:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5928:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getDestinationFeatureInstanceCrossReference_6_1_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5929:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5930:1: ruleINSTANCEREF
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getDestinationFeatureInstanceINSTANCEREFParserRuleCall_6_1_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__FlowSpecInstance__DestinationAssignment_6_111875);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5941:1: rule__FlowSpecInstance__InModeAssignment_7_2 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__FlowSpecInstance__InModeAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5945:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5946:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5946:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5947:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInModeModeInstanceCrossReference_7_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5948:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5949:1: ruleINSTANCEREF
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInModeModeInstanceINSTANCEREFParserRuleCall_7_2_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__FlowSpecInstance__InModeAssignment_7_211914);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5960:1: rule__FlowSpecInstance__InModeTransitionAssignment_8_2 : ( ( RULE_ID ) ) ;
    public final void rule__FlowSpecInstance__InModeTransitionAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5964:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5965:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5965:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5966:1: ( RULE_ID )
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5967:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5968:1: RULE_ID
            {
             before(grammarAccess.getFlowSpecInstanceAccess().getInModeTransitionModeTransitionInstanceIDTerminalRuleCall_8_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FlowSpecInstance__InModeTransitionAssignment_8_211953); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5979:1: rule__EndToEndFlowInstance__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EndToEndFlowInstance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5983:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5984:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5984:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5985:1: RULE_ID
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EndToEndFlowInstance__NameAssignment_211988); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5994:1: rule__EndToEndFlowInstance__EndToEndFlowAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__EndToEndFlowInstance__EndToEndFlowAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5998:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5999:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5999:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6000:1: ( RULE_ID )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowEndToEndFlowCrossReference_4_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6001:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6002:1: RULE_ID
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowEndToEndFlowIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EndToEndFlowInstance__EndToEndFlowAssignment_412023); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6013:1: rule__EndToEndFlowInstance__FlowElementAssignment_5 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__EndToEndFlowInstance__FlowElementAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6017:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6018:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6018:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6019:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceCrossReference_5_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6020:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6021:1: ruleINSTANCEREF
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceINSTANCEREFParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__EndToEndFlowInstance__FlowElementAssignment_512062);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6032:1: rule__EndToEndFlowInstance__InModeAssignment_6_2 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__EndToEndFlowInstance__InModeAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6036:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6037:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6037:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6038:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInModeModeInstanceCrossReference_6_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6039:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6040:1: ruleINSTANCEREF
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInModeModeInstanceINSTANCEREFParserRuleCall_6_2_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__EndToEndFlowInstance__InModeAssignment_6_212101);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6051:1: rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2 : ( ( ruleSOMID ) ) ;
    public final void rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6055:1: ( ( ( ruleSOMID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6056:1: ( ( ruleSOMID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6056:1: ( ( ruleSOMID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6057:1: ( ruleSOMID )
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_7_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6058:1: ( ruleSOMID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6059:1: ruleSOMID
            {
             before(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeSOMIDParserRuleCall_7_2_0_1()); 
            pushFollow(FOLLOW_ruleSOMID_in_rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_212140);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6070:1: rule__SystemOperationMode__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__SystemOperationMode__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6074:1: ( ( RULE_STRING ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6075:1: ( RULE_STRING )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6075:1: ( RULE_STRING )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6076:1: RULE_STRING
            {
             before(grammarAccess.getSystemOperationModeAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__SystemOperationMode__NameAssignment_112175); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6085:1: rule__ConnectionInstance__KindAssignment_0 : ( ruleConnectionKind ) ;
    public final void rule__ConnectionInstance__KindAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6089:1: ( ( ruleConnectionKind ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6090:1: ( ruleConnectionKind )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6090:1: ( ruleConnectionKind )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6091:1: ruleConnectionKind
            {
             before(grammarAccess.getConnectionInstanceAccess().getKindConnectionKindParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleConnectionKind_in_rule__ConnectionInstance__KindAssignment_012206);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6100:1: rule__ConnectionInstance__ConnectionReferenceAssignment_4 : ( ruleConnectionReference ) ;
    public final void rule__ConnectionInstance__ConnectionReferenceAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6104:1: ( ( ruleConnectionReference ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6105:1: ( ruleConnectionReference )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6105:1: ( ruleConnectionReference )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6106:1: ruleConnectionReference
            {
             before(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceConnectionReferenceParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleConnectionReference_in_rule__ConnectionInstance__ConnectionReferenceAssignment_412237);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6115:1: rule__ConnectionInstance__SourceAssignment_6 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionInstance__SourceAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6119:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6120:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6120:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6121:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndCrossReference_6_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6122:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6123:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndINSTANCEREFParserRuleCall_6_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__SourceAssignment_612272);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6134:1: rule__ConnectionInstance__DestinationAssignment_8 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionInstance__DestinationAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6138:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6139:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6139:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6140:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndCrossReference_8_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6141:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6142:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndINSTANCEREFParserRuleCall_8_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__DestinationAssignment_812311);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6153:1: rule__ConnectionInstance__InSystemOperationModeAssignment_9_2 : ( ( ruleSOMID ) ) ;
    public final void rule__ConnectionInstance__InSystemOperationModeAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6157:1: ( ( ( ruleSOMID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6158:1: ( ( ruleSOMID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6158:1: ( ( ruleSOMID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6159:1: ( ruleSOMID )
            {
             before(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_9_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6160:1: ( ruleSOMID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6161:1: ruleSOMID
            {
             before(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeSOMIDParserRuleCall_9_2_0_1()); 
            pushFollow(FOLLOW_ruleSOMID_in_rule__ConnectionInstance__InSystemOperationModeAssignment_9_212350);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6172:1: rule__ConnectionInstance__InModeTransitionAssignment_10_2 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionInstance__InModeTransitionAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6176:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6177:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6177:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6178:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_10_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6179:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6180:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceINSTANCEREFParserRuleCall_10_2_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__InModeTransitionAssignment_10_212389);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6191:1: rule__ConnectionInstance__CompleteAssignment_11 : ( ( 'complete' ) ) ;
    public final void rule__ConnectionInstance__CompleteAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6195:1: ( ( ( 'complete' ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6196:1: ( ( 'complete' ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6196:1: ( ( 'complete' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6197:1: ( 'complete' )
            {
             before(grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_11_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6198:1: ( 'complete' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6199:1: 'complete'
            {
             before(grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_11_0()); 
            match(input,61,FOLLOW_61_in_rule__ConnectionInstance__CompleteAssignment_1112429); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6214:1: rule__ConnectionInstance__BidirectionalAssignment_12 : ( ( 'bidirectional' ) ) ;
    public final void rule__ConnectionInstance__BidirectionalAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6218:1: ( ( ( 'bidirectional' ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6219:1: ( ( 'bidirectional' ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6219:1: ( ( 'bidirectional' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6220:1: ( 'bidirectional' )
            {
             before(grammarAccess.getConnectionInstanceAccess().getBidirectionalBidirectionalKeyword_12_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6221:1: ( 'bidirectional' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6222:1: 'bidirectional'
            {
             before(grammarAccess.getConnectionInstanceAccess().getBidirectionalBidirectionalKeyword_12_0()); 
            match(input,62,FOLLOW_62_in_rule__ConnectionInstance__BidirectionalAssignment_1212473); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6237:1: rule__ConnectionReference__ConnectionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ConnectionReference__ConnectionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6241:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6242:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6242:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6243:1: ( RULE_ID )
            {
             before(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionCrossReference_1_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6244:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6245:1: RULE_ID
            {
             before(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ConnectionReference__ConnectionAssignment_112516); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6256:1: rule__ConnectionReference__SourceAssignment_3 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionReference__SourceAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6260:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6261:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6261:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6262:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndCrossReference_3_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6263:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6264:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndINSTANCEREFParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__SourceAssignment_312555);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6275:1: rule__ConnectionReference__DestinationAssignment_5 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionReference__DestinationAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6279:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6280:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6280:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6281:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndCrossReference_5_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6282:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6283:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndINSTANCEREFParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__DestinationAssignment_512594);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6294:1: rule__ConnectionReference__ContextAssignment_7 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionReference__ContextAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6298:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6299:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6299:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6300:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceCrossReference_7_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6301:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6302:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceINSTANCEREFParserRuleCall_7_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__ContextAssignment_712633);
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
        "\20\uffff";
    static final String DFA1_eofS =
        "\10\uffff\1\16\7\uffff";
    static final String DFA1_minS =
        "\1\11\7\uffff\1\5\7\uffff";
    static final String DFA1_maxS =
        "\1\70\7\uffff\1\67\7\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\1\13\1\14\1\15\1\16\1\10\1\11";
    static final String DFA1_specialS =
        "\20\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\15\43\uffff\1\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\16\43\uffff\1\16\15\uffff\1\17",
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
    static final String DFA33_eotS =
        "\5\uffff";
    static final String DFA33_eofS =
        "\1\uffff\1\3\3\uffff";
    static final String DFA33_minS =
        "\1\5\1\37\2\uffff\1\5";
    static final String DFA33_maxS =
        "\1\5\1\76\2\uffff\1\5";
    static final String DFA33_acceptS =
        "\2\uffff\1\1\1\2\1\uffff";
    static final String DFA33_specialS =
        "\5\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\1",
            "\1\3\13\uffff\1\3\16\uffff\1\4\1\2\1\uffff\2\3",
            "",
            "",
            "\1\1"
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
            return "()* loopback of 5288:1: ( rule__SOMID__Group_0__0 )*";
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
    public static final BitSet FOLLOW_18_in_rule__ComponentCategory__Alternatives1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ComponentCategory__Alternatives1368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__0_in_rule__ComponentCategory__Alternatives1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ComponentCategory__Alternatives1406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__FeatureCategory__Alternatives1441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__FeatureCategory__Alternatives1461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__FeatureCategory__Alternatives1481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__FeatureCategory__Alternatives1501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__FeatureCategory__Alternatives1521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__FeatureCategory__Alternatives1541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__FeatureCategory__Alternatives1561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__FeatureCategory__Alternatives1581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__FeatureCategory__Alternatives1601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__FeatureCategory__Alternatives1621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__DirectionType__Alternatives1656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__DirectionType__Alternatives1676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__DirectionType__Alternatives1696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__ConnectionKind__Alternatives1731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ConnectionKind__Alternatives1751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ConnectionKind__Alternatives1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ConnectionKind__Alternatives1791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ConnectionKind__Alternatives1811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ConnectionKind__Alternatives1831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__0__Impl_in_rule__SystemInstance__Group__01863 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__1_in_rule__SystemInstance__Group__01866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__CategoryAssignment_0_in_rule__SystemInstance__Group__0__Impl1893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__1__Impl_in_rule__SystemInstance__Group__11923 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__2_in_rule__SystemInstance__Group__11926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__NameAssignment_1_in_rule__SystemInstance__Group__1__Impl1953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__2__Impl_in_rule__SystemInstance__Group__21983 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__3_in_rule__SystemInstance__Group__21986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__SystemInstance__Group__2__Impl2014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__3__Impl_in_rule__SystemInstance__Group__32045 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__4_in_rule__SystemInstance__Group__32048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__ComponentImplementationAssignment_3_in_rule__SystemInstance__Group__3__Impl2075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__4__Impl_in_rule__SystemInstance__Group__42105 = new BitSet(new long[]{0x0010010000000000L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__5_in_rule__SystemInstance__Group__42108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__SystemInstance__Group__4__Impl2136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__5__Impl_in_rule__SystemInstance__Group__52167 = new BitSet(new long[]{0x0010010000000000L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__6_in_rule__SystemInstance__Group__52170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__SystemOperationModeAssignment_5_in_rule__SystemInstance__Group__5__Impl2197 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__6__Impl_in_rule__SystemInstance__Group__62228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__SystemInstance__Group__6__Impl2256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__0__Impl_in_rule__ComponentInstance__Group__02301 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__1_in_rule__ComponentInstance__Group__02304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__CategoryAssignment_0_in_rule__ComponentInstance__Group__0__Impl2331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__1__Impl_in_rule__ComponentInstance__Group__12361 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__2_in_rule__ComponentInstance__Group__12364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ComponentInstance__Group__1__Impl2392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__2__Impl_in_rule__ComponentInstance__Group__22423 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__3_in_rule__ComponentInstance__Group__22426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__NameAssignment_2_in_rule__ComponentInstance__Group__2__Impl2453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__3__Impl_in_rule__ComponentInstance__Group__32483 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__4_in_rule__ComponentInstance__Group__32486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_3__0_in_rule__ComponentInstance__Group__3__Impl2513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__4__Impl_in_rule__ComponentInstance__Group__42544 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__5_in_rule__ComponentInstance__Group__42547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__ComponentInstance__Group__4__Impl2575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__5__Impl_in_rule__ComponentInstance__Group__52606 = new BitSet(new long[]{0x010C483CFFFFFE00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__6_in_rule__ComponentInstance__Group__52609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__SubcomponentAssignment_5_in_rule__ComponentInstance__Group__5__Impl2636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__6__Impl_in_rule__ComponentInstance__Group__62666 = new BitSet(new long[]{0x010C483CFFFFFE00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__7_in_rule__ComponentInstance__Group__62669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__FeatureInstanceAssignment_6_in_rule__ComponentInstance__Group__6__Impl2696 = new BitSet(new long[]{0x000000007FE00002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__7__Impl_in_rule__ComponentInstance__Group__72727 = new BitSet(new long[]{0x010C483CFFFFFE00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__8_in_rule__ComponentInstance__Group__72730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__ComponentInstanceAssignment_7_in_rule__ComponentInstance__Group__7__Impl2757 = new BitSet(new long[]{0x01000000001FFE02L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__8__Impl_in_rule__ComponentInstance__Group__82788 = new BitSet(new long[]{0x010C483CFFFFFE00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__9_in_rule__ComponentInstance__Group__82791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__ModeInstanceAssignment_8_in_rule__ComponentInstance__Group__8__Impl2818 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__9__Impl_in_rule__ComponentInstance__Group__92849 = new BitSet(new long[]{0x010C483CFFFFFE00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__10_in_rule__ComponentInstance__Group__92852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__ModeTransitionInstanceAssignment_9_in_rule__ComponentInstance__Group__9__Impl2879 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__10__Impl_in_rule__ComponentInstance__Group__102910 = new BitSet(new long[]{0x010C483CFFFFFE00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__11_in_rule__ComponentInstance__Group__102913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__FlowSpecificationAssignment_10_in_rule__ComponentInstance__Group__10__Impl2940 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__11__Impl_in_rule__ComponentInstance__Group__112971 = new BitSet(new long[]{0x010C483CFFFFFE00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__12_in_rule__ComponentInstance__Group__112974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__EndToEndFlowAssignment_11_in_rule__ComponentInstance__Group__11__Impl3001 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__12__Impl_in_rule__ComponentInstance__Group__123032 = new BitSet(new long[]{0x010C483CFFFFFE00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__13_in_rule__ComponentInstance__Group__123035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__ConnectionInstanceAssignment_12_in_rule__ComponentInstance__Group__12__Impl3062 = new BitSet(new long[]{0x0000003C21000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__13__Impl_in_rule__ComponentInstance__Group__133093 = new BitSet(new long[]{0x010C483CFFFFFE00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__14_in_rule__ComponentInstance__Group__133096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_13__0_in_rule__ComponentInstance__Group__13__Impl3123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__14__Impl_in_rule__ComponentInstance__Group__143154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__ComponentInstance__Group__14__Impl3182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_3__0__Impl_in_rule__ComponentInstance__Group_3__03243 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_3__1_in_rule__ComponentInstance__Group_3__03246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__ComponentInstance__Group_3__0__Impl3274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_3__1__Impl_in_rule__ComponentInstance__Group_3__13305 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_3__2_in_rule__ComponentInstance__Group_3__13308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__IndexAssignment_3_1_in_rule__ComponentInstance__Group_3__1__Impl3337 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ComponentInstance__IndexAssignment_3_1_in_rule__ComponentInstance__Group_3__1__Impl3349 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_3__2__Impl_in_rule__ComponentInstance__Group_3__23382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__ComponentInstance__Group_3__2__Impl3410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_13__0__Impl_in_rule__ComponentInstance__Group_13__03447 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_13__1_in_rule__ComponentInstance__Group_13__03450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ComponentInstance__Group_13__0__Impl3478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_13__1__Impl_in_rule__ComponentInstance__Group_13__13509 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_13__2_in_rule__ComponentInstance__Group_13__13512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ComponentInstance__Group_13__1__Impl3540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_13__2__Impl_in_rule__ComponentInstance__Group_13__23571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__InModeAssignment_13_2_in_rule__ComponentInstance__Group_13__2__Impl3598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__0__Impl_in_rule__FeatureInstance__Group__03634 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__1_in_rule__FeatureInstance__Group__03637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__CategoryAssignment_0_in_rule__FeatureInstance__Group__0__Impl3664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__1__Impl_in_rule__FeatureInstance__Group__13694 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__2_in_rule__FeatureInstance__Group__13697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__FeatureInstance__Group__1__Impl3725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__2__Impl_in_rule__FeatureInstance__Group__23756 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__3_in_rule__FeatureInstance__Group__23759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__NameAssignment_2_in_rule__FeatureInstance__Group__2__Impl3786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__3__Impl_in_rule__FeatureInstance__Group__33816 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__4_in_rule__FeatureInstance__Group__33819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__0_in_rule__FeatureInstance__Group__3__Impl3846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__4__Impl_in_rule__FeatureInstance__Group__43877 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__5_in_rule__FeatureInstance__Group__43880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__FeatureInstance__Group__4__Impl3908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__5__Impl_in_rule__FeatureInstance__Group__53939 = new BitSet(new long[]{0x0000000380000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__6_in_rule__FeatureInstance__Group__53942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__FeatureAssignment_5_in_rule__FeatureInstance__Group__5__Impl3969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__6__Impl_in_rule__FeatureInstance__Group__63999 = new BitSet(new long[]{0x000000007FE00000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__7_in_rule__FeatureInstance__Group__64002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__DirectionAssignment_6_in_rule__FeatureInstance__Group__6__Impl4029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__7__Impl_in_rule__FeatureInstance__Group__74059 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__8_in_rule__FeatureInstance__Group__74062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__FeatureInstanceAssignment_7_in_rule__FeatureInstance__Group__7__Impl4089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__8__Impl_in_rule__FeatureInstance__Group__84119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__FeatureInstance__Group__8__Impl4147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__0__Impl_in_rule__FeatureInstance__Group_3__04196 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__1_in_rule__FeatureInstance__Group_3__04199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__FeatureInstance__Group_3__0__Impl4227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__1__Impl_in_rule__FeatureInstance__Group_3__14258 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__2_in_rule__FeatureInstance__Group_3__14261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__IndexAssignment_3_1_in_rule__FeatureInstance__Group_3__1__Impl4288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__2__Impl_in_rule__FeatureInstance__Group_3__24318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__FeatureInstance__Group_3__2__Impl4346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__0__Impl_in_rule__ModeInstance__Group__04383 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__1_in_rule__ModeInstance__Group__04386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ModeInstance__Group__0__Impl4414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__1__Impl_in_rule__ModeInstance__Group__14445 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__2_in_rule__ModeInstance__Group__14448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ModeInstance__Group__1__Impl4476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__2__Impl_in_rule__ModeInstance__Group__24507 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__3_in_rule__ModeInstance__Group__24510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__NameAssignment_2_in_rule__ModeInstance__Group__2__Impl4537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__3__Impl_in_rule__ModeInstance__Group__34567 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__4_in_rule__ModeInstance__Group__34570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__ModeInstance__Group__3__Impl4598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__4__Impl_in_rule__ModeInstance__Group__44629 = new BitSet(new long[]{0x1000080000000000L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__5_in_rule__ModeInstance__Group__44632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__ModeAssignment_4_in_rule__ModeInstance__Group__4__Impl4659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__5__Impl_in_rule__ModeInstance__Group__54689 = new BitSet(new long[]{0x1000080000000000L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__6_in_rule__ModeInstance__Group__54692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__InitialAssignment_5_in_rule__ModeInstance__Group__5__Impl4719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeInstance__Group__6__Impl_in_rule__ModeInstance__Group__64750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__ModeInstance__Group__6__Impl4778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__0__Impl_in_rule__ModeTransitionInstance__Group__04823 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__1_in_rule__ModeTransitionInstance__Group__04826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ModeTransitionInstance__Group__0__Impl4854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__1__Impl_in_rule__ModeTransitionInstance__Group__14885 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__2_in_rule__ModeTransitionInstance__Group__14888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__ModeTransitionInstance__Group__1__Impl4916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__2__Impl_in_rule__ModeTransitionInstance__Group__24947 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__3_in_rule__ModeTransitionInstance__Group__24950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ModeTransitionInstance__Group__2__Impl4978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__3__Impl_in_rule__ModeTransitionInstance__Group__35009 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__4_in_rule__ModeTransitionInstance__Group__35012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__NameAssignment_3_in_rule__ModeTransitionInstance__Group__3__Impl5039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__4__Impl_in_rule__ModeTransitionInstance__Group__45069 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__5_in_rule__ModeTransitionInstance__Group__45072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__ModeTransitionInstance__Group__4__Impl5100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__5__Impl_in_rule__ModeTransitionInstance__Group__55131 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__6_in_rule__ModeTransitionInstance__Group__55134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__ModeTransitionAssignment_5_in_rule__ModeTransitionInstance__Group__5__Impl5161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__6__Impl_in_rule__ModeTransitionInstance__Group__65191 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__7_in_rule__ModeTransitionInstance__Group__65194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__ModeTransitionInstance__Group__6__Impl5222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__7__Impl_in_rule__ModeTransitionInstance__Group__75253 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__8_in_rule__ModeTransitionInstance__Group__75256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__SourceAssignment_7_in_rule__ModeTransitionInstance__Group__7__Impl5283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__8__Impl_in_rule__ModeTransitionInstance__Group__85313 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__9_in_rule__ModeTransitionInstance__Group__85316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__ModeTransitionInstance__Group__8__Impl5344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__9__Impl_in_rule__ModeTransitionInstance__Group__95375 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__10_in_rule__ModeTransitionInstance__Group__95378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__DestinationAssignment_9_in_rule__ModeTransitionInstance__Group__9__Impl5405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModeTransitionInstance__Group__10__Impl_in_rule__ModeTransitionInstance__Group__105435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__ModeTransitionInstance__Group__10__Impl5463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__0__Impl_in_rule__FlowSpecInstance__Group__05516 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__1_in_rule__FlowSpecInstance__Group__05519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__FlowSpecInstance__Group__0__Impl5547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__1__Impl_in_rule__FlowSpecInstance__Group__15578 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__2_in_rule__FlowSpecInstance__Group__15581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__FlowSpecInstance__Group__1__Impl5609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__2__Impl_in_rule__FlowSpecInstance__Group__25640 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__3_in_rule__FlowSpecInstance__Group__25643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__NameAssignment_2_in_rule__FlowSpecInstance__Group__2__Impl5670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__3__Impl_in_rule__FlowSpecInstance__Group__35700 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__4_in_rule__FlowSpecInstance__Group__35703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__FlowSpecInstance__Group__3__Impl5731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__4__Impl_in_rule__FlowSpecInstance__Group__45762 = new BitSet(new long[]{0x0003080080000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__5_in_rule__FlowSpecInstance__Group__45765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__FlowSpecificationAssignment_4_in_rule__FlowSpecInstance__Group__4__Impl5792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__5__Impl_in_rule__FlowSpecInstance__Group__55822 = new BitSet(new long[]{0x0003080080000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__6_in_rule__FlowSpecInstance__Group__55825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_5__0_in_rule__FlowSpecInstance__Group__5__Impl5852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__6__Impl_in_rule__FlowSpecInstance__Group__65883 = new BitSet(new long[]{0x0003080080000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__7_in_rule__FlowSpecInstance__Group__65886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_6__0_in_rule__FlowSpecInstance__Group__6__Impl5913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__7__Impl_in_rule__FlowSpecInstance__Group__75944 = new BitSet(new long[]{0x0003080080000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__8_in_rule__FlowSpecInstance__Group__75947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_7__0_in_rule__FlowSpecInstance__Group__7__Impl5974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__8__Impl_in_rule__FlowSpecInstance__Group__86005 = new BitSet(new long[]{0x0003080080000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__9_in_rule__FlowSpecInstance__Group__86008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_8__0_in_rule__FlowSpecInstance__Group__8__Impl6035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group__9__Impl_in_rule__FlowSpecInstance__Group__96066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__FlowSpecInstance__Group__9__Impl6094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_5__0__Impl_in_rule__FlowSpecInstance__Group_5__06145 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_5__1_in_rule__FlowSpecInstance__Group_5__06148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__FlowSpecInstance__Group_5__0__Impl6176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_5__1__Impl_in_rule__FlowSpecInstance__Group_5__16207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__SourceAssignment_5_1_in_rule__FlowSpecInstance__Group_5__1__Impl6234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_6__0__Impl_in_rule__FlowSpecInstance__Group_6__06268 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_6__1_in_rule__FlowSpecInstance__Group_6__06271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__FlowSpecInstance__Group_6__0__Impl6299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_6__1__Impl_in_rule__FlowSpecInstance__Group_6__16330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__DestinationAssignment_6_1_in_rule__FlowSpecInstance__Group_6__1__Impl6357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_7__0__Impl_in_rule__FlowSpecInstance__Group_7__06391 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_7__1_in_rule__FlowSpecInstance__Group_7__06394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__FlowSpecInstance__Group_7__0__Impl6422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_7__1__Impl_in_rule__FlowSpecInstance__Group_7__16453 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_7__2_in_rule__FlowSpecInstance__Group_7__16456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__FlowSpecInstance__Group_7__1__Impl6484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_7__2__Impl_in_rule__FlowSpecInstance__Group_7__26515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__InModeAssignment_7_2_in_rule__FlowSpecInstance__Group_7__2__Impl6542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_8__0__Impl_in_rule__FlowSpecInstance__Group_8__06578 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_8__1_in_rule__FlowSpecInstance__Group_8__06581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__FlowSpecInstance__Group_8__0__Impl6609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_8__1__Impl_in_rule__FlowSpecInstance__Group_8__16640 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_8__2_in_rule__FlowSpecInstance__Group_8__16643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__FlowSpecInstance__Group_8__1__Impl6671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__Group_8__2__Impl_in_rule__FlowSpecInstance__Group_8__26702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecInstance__InModeTransitionAssignment_8_2_in_rule__FlowSpecInstance__Group_8__2__Impl6729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__0__Impl_in_rule__EndToEndFlowInstance__Group__06765 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__1_in_rule__EndToEndFlowInstance__Group__06768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__EndToEndFlowInstance__Group__0__Impl6796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__1__Impl_in_rule__EndToEndFlowInstance__Group__16827 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__2_in_rule__EndToEndFlowInstance__Group__16830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__EndToEndFlowInstance__Group__1__Impl6858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__2__Impl_in_rule__EndToEndFlowInstance__Group__26889 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__3_in_rule__EndToEndFlowInstance__Group__26892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__NameAssignment_2_in_rule__EndToEndFlowInstance__Group__2__Impl6919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__3__Impl_in_rule__EndToEndFlowInstance__Group__36949 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__4_in_rule__EndToEndFlowInstance__Group__36952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__EndToEndFlowInstance__Group__3__Impl6980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__4__Impl_in_rule__EndToEndFlowInstance__Group__47011 = new BitSet(new long[]{0x0000080080000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__5_in_rule__EndToEndFlowInstance__Group__47014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__EndToEndFlowAssignment_4_in_rule__EndToEndFlowInstance__Group__4__Impl7041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__5__Impl_in_rule__EndToEndFlowInstance__Group__57071 = new BitSet(new long[]{0x0000080080000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__6_in_rule__EndToEndFlowInstance__Group__57074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__FlowElementAssignment_5_in_rule__EndToEndFlowInstance__Group__5__Impl7101 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__6__Impl_in_rule__EndToEndFlowInstance__Group__67132 = new BitSet(new long[]{0x0000080080000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__7_in_rule__EndToEndFlowInstance__Group__67135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_6__0_in_rule__EndToEndFlowInstance__Group__6__Impl7162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__7__Impl_in_rule__EndToEndFlowInstance__Group__77193 = new BitSet(new long[]{0x0000080080000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__8_in_rule__EndToEndFlowInstance__Group__77196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_7__0_in_rule__EndToEndFlowInstance__Group__7__Impl7223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group__8__Impl_in_rule__EndToEndFlowInstance__Group__87254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__EndToEndFlowInstance__Group__8__Impl7282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_6__0__Impl_in_rule__EndToEndFlowInstance__Group_6__07331 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_6__1_in_rule__EndToEndFlowInstance__Group_6__07334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__EndToEndFlowInstance__Group_6__0__Impl7362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_6__1__Impl_in_rule__EndToEndFlowInstance__Group_6__17393 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_6__2_in_rule__EndToEndFlowInstance__Group_6__17396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__EndToEndFlowInstance__Group_6__1__Impl7424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_6__2__Impl_in_rule__EndToEndFlowInstance__Group_6__27455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__InModeAssignment_6_2_in_rule__EndToEndFlowInstance__Group_6__2__Impl7482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_7__0__Impl_in_rule__EndToEndFlowInstance__Group_7__07518 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_7__1_in_rule__EndToEndFlowInstance__Group_7__07521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__EndToEndFlowInstance__Group_7__0__Impl7549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_7__1__Impl_in_rule__EndToEndFlowInstance__Group_7__17580 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_7__2_in_rule__EndToEndFlowInstance__Group_7__17583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__EndToEndFlowInstance__Group_7__1__Impl7611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__Group_7__2__Impl_in_rule__EndToEndFlowInstance__Group_7__27642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_2_in_rule__EndToEndFlowInstance__Group_7__2__Impl7669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__0__Impl_in_rule__SystemOperationMode__Group__07705 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__1_in_rule__SystemOperationMode__Group__07708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__SystemOperationMode__Group__0__Impl7736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__1__Impl_in_rule__SystemOperationMode__Group__17767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__NameAssignment_1_in_rule__SystemOperationMode__Group__1__Impl7794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__0__Impl_in_rule__ConnectionInstance__Group__07828 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__1_in_rule__ConnectionInstance__Group__07831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__KindAssignment_0_in_rule__ConnectionInstance__Group__0__Impl7858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__1__Impl_in_rule__ConnectionInstance__Group__17888 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__2_in_rule__ConnectionInstance__Group__17891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__ConnectionInstance__Group__1__Impl7919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__2__Impl_in_rule__ConnectionInstance__Group__27950 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__3_in_rule__ConnectionInstance__Group__27953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ConnectionInstance__Group__2__Impl7981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__3__Impl_in_rule__ConnectionInstance__Group__38012 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__4_in_rule__ConnectionInstance__Group__38015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__ConnectionInstance__Group__3__Impl8043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__4__Impl_in_rule__ConnectionInstance__Group__48074 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__5_in_rule__ConnectionInstance__Group__48077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__ConnectionReferenceAssignment_4_in_rule__ConnectionInstance__Group__4__Impl8106 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__ConnectionReferenceAssignment_4_in_rule__ConnectionInstance__Group__4__Impl8118 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__5__Impl_in_rule__ConnectionInstance__Group__58151 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__6_in_rule__ConnectionInstance__Group__58154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__ConnectionInstance__Group__5__Impl8182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__6__Impl_in_rule__ConnectionInstance__Group__68213 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__7_in_rule__ConnectionInstance__Group__68216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__SourceAssignment_6_in_rule__ConnectionInstance__Group__6__Impl8243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__7__Impl_in_rule__ConnectionInstance__Group__78273 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__8_in_rule__ConnectionInstance__Group__78276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__ConnectionInstance__Group__7__Impl8304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__8__Impl_in_rule__ConnectionInstance__Group__88335 = new BitSet(new long[]{0x6000080080000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__9_in_rule__ConnectionInstance__Group__88338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__DestinationAssignment_8_in_rule__ConnectionInstance__Group__8__Impl8365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__9__Impl_in_rule__ConnectionInstance__Group__98395 = new BitSet(new long[]{0x6000080080000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__10_in_rule__ConnectionInstance__Group__98398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_9__0_in_rule__ConnectionInstance__Group__9__Impl8425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__10__Impl_in_rule__ConnectionInstance__Group__108456 = new BitSet(new long[]{0x6000080080000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__11_in_rule__ConnectionInstance__Group__108459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_10__0_in_rule__ConnectionInstance__Group__10__Impl8486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__11__Impl_in_rule__ConnectionInstance__Group__118517 = new BitSet(new long[]{0x6000080080000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__12_in_rule__ConnectionInstance__Group__118520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__CompleteAssignment_11_in_rule__ConnectionInstance__Group__11__Impl8547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__12__Impl_in_rule__ConnectionInstance__Group__128578 = new BitSet(new long[]{0x6000080080000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__13_in_rule__ConnectionInstance__Group__128581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__BidirectionalAssignment_12_in_rule__ConnectionInstance__Group__12__Impl8608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__13__Impl_in_rule__ConnectionInstance__Group__138639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__ConnectionInstance__Group__13__Impl8667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_9__0__Impl_in_rule__ConnectionInstance__Group_9__08726 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_9__1_in_rule__ConnectionInstance__Group_9__08729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ConnectionInstance__Group_9__0__Impl8757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_9__1__Impl_in_rule__ConnectionInstance__Group_9__18788 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_9__2_in_rule__ConnectionInstance__Group_9__18791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__ConnectionInstance__Group_9__1__Impl8819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_9__2__Impl_in_rule__ConnectionInstance__Group_9__28850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__InSystemOperationModeAssignment_9_2_in_rule__ConnectionInstance__Group_9__2__Impl8877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_10__0__Impl_in_rule__ConnectionInstance__Group_10__08913 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_10__1_in_rule__ConnectionInstance__Group_10__08916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ConnectionInstance__Group_10__0__Impl8944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_10__1__Impl_in_rule__ConnectionInstance__Group_10__18975 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_10__2_in_rule__ConnectionInstance__Group_10__18978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__ConnectionInstance__Group_10__1__Impl9006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group_10__2__Impl_in_rule__ConnectionInstance__Group_10__29037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__InModeTransitionAssignment_10_2_in_rule__ConnectionInstance__Group_10__2__Impl9064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__0__Impl_in_rule__ConnectionReference__Group__09100 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__1_in_rule__ConnectionReference__Group__09103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__ConnectionReference__Group__0__Impl9131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__1__Impl_in_rule__ConnectionReference__Group__19162 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__2_in_rule__ConnectionReference__Group__19165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__ConnectionAssignment_1_in_rule__ConnectionReference__Group__1__Impl9192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__2__Impl_in_rule__ConnectionReference__Group__29222 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__3_in_rule__ConnectionReference__Group__29225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__ConnectionReference__Group__2__Impl9253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__3__Impl_in_rule__ConnectionReference__Group__39284 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__4_in_rule__ConnectionReference__Group__39287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__SourceAssignment_3_in_rule__ConnectionReference__Group__3__Impl9314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__4__Impl_in_rule__ConnectionReference__Group__49344 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__5_in_rule__ConnectionReference__Group__49347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__ConnectionReference__Group__4__Impl9375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__5__Impl_in_rule__ConnectionReference__Group__59406 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__6_in_rule__ConnectionReference__Group__59409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__DestinationAssignment_5_in_rule__ConnectionReference__Group__5__Impl9436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__6__Impl_in_rule__ConnectionReference__Group__69466 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__7_in_rule__ConnectionReference__Group__69469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__ConnectionReference__Group__6__Impl9497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__7__Impl_in_rule__ConnectionReference__Group__79528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__ContextAssignment_7_in_rule__ConnectionReference__Group__7__Impl9555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__0__Impl_in_rule__ComponentCategory__Group_8__09601 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__1_in_rule__ComponentCategory__Group_8__09604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ComponentCategory__Group_8__0__Impl9632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__1__Impl_in_rule__ComponentCategory__Group_8__19663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_rule__ComponentCategory__Group_8__1__Impl9691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__0__Impl_in_rule__ComponentCategory__Group_12__09726 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__1_in_rule__ComponentCategory__Group_12__09729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_rule__ComponentCategory__Group_12__0__Impl9757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__1__Impl_in_rule__ComponentCategory__Group_12__19788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__ComponentCategory__Group_12__1__Impl9816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group__0__Impl_in_rule__FQCREF__Group__09851 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FQCREF__Group__1_in_rule__FQCREF__Group__09854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_0__0_in_rule__FQCREF__Group__0__Impl9883 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_0__0_in_rule__FQCREF__Group__0__Impl9895 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__FQCREF__Group__1__Impl_in_rule__FQCREF__Group__19928 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_rule__FQCREF__Group__2_in_rule__FQCREF__Group__19931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQCREF__Group__1__Impl9958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group__2__Impl_in_rule__FQCREF__Group__29987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_2__0_in_rule__FQCREF__Group__2__Impl10014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_0__0__Impl_in_rule__FQCREF__Group_0__010051 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_0__1_in_rule__FQCREF__Group_0__010054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQCREF__Group_0__0__Impl10081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_0__1__Impl_in_rule__FQCREF__Group_0__110110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_rule__FQCREF__Group_0__1__Impl10138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_2__0__Impl_in_rule__FQCREF__Group_2__010173 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_2__1_in_rule__FQCREF__Group_2__010176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_rule__FQCREF__Group_2__0__Impl10204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQCREF__Group_2__1__Impl_in_rule__FQCREF__Group_2__110235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQCREF__Group_2__1__Impl10262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group__0__Impl_in_rule__INSTANCEREF__Group__010295 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group__1_in_rule__INSTANCEREF__Group__010298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_0__0_in_rule__INSTANCEREF__Group__0__Impl10325 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group__1__Impl_in_rule__INSTANCEREF__Group__110356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__INSTANCEREF__Group__1__Impl10383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_0__0__Impl_in_rule__INSTANCEREF__Group_0__010416 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_0__1_in_rule__INSTANCEREF__Group_0__010419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__INSTANCEREF__Group_0__0__Impl10446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_0__1__Impl_in_rule__INSTANCEREF__Group_0__110475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_rule__INSTANCEREF__Group_0__1__Impl10503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SOMID__Group__0__Impl_in_rule__SOMID__Group__010538 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SOMID__Group__1_in_rule__SOMID__Group__010541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SOMID__Group_0__0_in_rule__SOMID__Group__0__Impl10568 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__SOMID__Group__1__Impl_in_rule__SOMID__Group__110599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__SOMID__Group__1__Impl10626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SOMID__Group_0__0__Impl_in_rule__SOMID__Group_0__010659 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_rule__SOMID__Group_0__1_in_rule__SOMID__Group_0__010662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__SOMID__Group_0__0__Impl10689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SOMID__Group_0__1__Impl_in_rule__SOMID__Group_0__110718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_rule__SOMID__Group_0__1__Impl10746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_rule__SystemInstance__CategoryAssignment_010786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SystemInstance__NameAssignment_110817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQCREF_in_rule__SystemInstance__ComponentImplementationAssignment_310852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_rule__SystemInstance__SystemOperationModeAssignment_510887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_rule__ComponentInstance__CategoryAssignment_010918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ComponentInstance__NameAssignment_210949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTVALUE_in_rule__ComponentInstance__IndexAssignment_3_110980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ComponentInstance__SubcomponentAssignment_511015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_rule__ComponentInstance__FeatureInstanceAssignment_611050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_rule__ComponentInstance__ComponentInstanceAssignment_711081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeInstance_in_rule__ComponentInstance__ModeInstanceAssignment_811112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeTransitionInstance_in_rule__ComponentInstance__ModeTransitionInstanceAssignment_911143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSpecInstance_in_rule__ComponentInstance__FlowSpecificationAssignment_1011174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndToEndFlowInstance_in_rule__ComponentInstance__EndToEndFlowAssignment_1111205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_rule__ComponentInstance__ConnectionInstanceAssignment_1211236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ComponentInstance__InModeAssignment_13_211271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_rule__FeatureInstance__CategoryAssignment_011306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FeatureInstance__NameAssignment_211337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTVALUE_in_rule__FeatureInstance__IndexAssignment_3_111368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FeatureInstance__FeatureAssignment_511403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_rule__FeatureInstance__DirectionAssignment_611438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_rule__FeatureInstance__FeatureInstanceAssignment_711469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ModeInstance__NameAssignment_211500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ModeInstance__ModeAssignment_411535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_rule__ModeInstance__InitialAssignment_511575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__NameAssignment_311614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__ModeTransitionAssignment_511649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__SourceAssignment_711688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ModeTransitionInstance__DestinationAssignment_911727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FlowSpecInstance__NameAssignment_211762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FlowSpecInstance__FlowSpecificationAssignment_411797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__FlowSpecInstance__SourceAssignment_5_111836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__FlowSpecInstance__DestinationAssignment_6_111875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__FlowSpecInstance__InModeAssignment_7_211914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FlowSpecInstance__InModeTransitionAssignment_8_211953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EndToEndFlowInstance__NameAssignment_211988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EndToEndFlowInstance__EndToEndFlowAssignment_412023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__EndToEndFlowInstance__FlowElementAssignment_512062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__EndToEndFlowInstance__InModeAssignment_6_212101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSOMID_in_rule__EndToEndFlowInstance__InSystemOperationModeAssignment_7_212140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__SystemOperationMode__NameAssignment_112175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionKind_in_rule__ConnectionInstance__KindAssignment_012206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionReference_in_rule__ConnectionInstance__ConnectionReferenceAssignment_412237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__SourceAssignment_612272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__DestinationAssignment_812311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSOMID_in_rule__ConnectionInstance__InSystemOperationModeAssignment_9_212350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__InModeTransitionAssignment_10_212389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_rule__ConnectionInstance__CompleteAssignment_1112429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_rule__ConnectionInstance__BidirectionalAssignment_1212473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ConnectionReference__ConnectionAssignment_112516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__SourceAssignment_312555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__DestinationAssignment_512594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__ContextAssignment_712633 = new BitSet(new long[]{0x0000000000000002L});

}