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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_LONG", "RULE_STRING", "RULE_SL_COMMENT", "RULE_WS", "'->'", "'in'", "'out'", "'dataPort'", "'eventPort'", "'eventDataPort'", "'parameter'", "'busAccess'", "'subprogramAccess'", "'subprogramGroupAccess'", "'featureGroup'", "'abstractFeature'", "'abstract'", "'bus'", "'data'", "'device'", "'memory'", "'process'", "'processor'", "'subprogram'", "'system'", "'thread'", "'featureConnection'", "'accessConnection'", "'parameterConnection'", "'portConnection'", "'modeTransitionConnection'", "'featureGroupConnection'", "'parent'", "':'", "'{'", "'}'", "'['", "']'", "'source'", "'of'", "'('", "')'", "','", "'destination'", "'flow'", "'som'", "'group'", "'virtual'", "'.'", "'::'", "'complete'", "'<->'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__10=10;
    public static final int T__54=54;
    public static final int T__9=9;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
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
    public static final int RULE_LONG=5;
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


    // $ANTLR start "entryRuleFeatureInstance"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:88:1: entryRuleFeatureInstance : ruleFeatureInstance EOF ;
    public final void entryRuleFeatureInstance() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:89:1: ( ruleFeatureInstance EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:90:1: ruleFeatureInstance EOF
            {
             before(grammarAccess.getFeatureInstanceRule()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_entryRuleFeatureInstance121);
            ruleFeatureInstance();

            state._fsp--;

             after(grammarAccess.getFeatureInstanceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureInstance128); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:97:1: ruleFeatureInstance : ( ( rule__FeatureInstance__Group__0 ) ) ;
    public final void ruleFeatureInstance() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:101:2: ( ( ( rule__FeatureInstance__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:102:1: ( ( rule__FeatureInstance__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:102:1: ( ( rule__FeatureInstance__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:103:1: ( rule__FeatureInstance__Group__0 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:104:1: ( rule__FeatureInstance__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:104:2: rule__FeatureInstance__Group__0
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__0_in_ruleFeatureInstance154);
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


    // $ANTLR start "entryRuleComponentInstance"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:116:1: entryRuleComponentInstance : ruleComponentInstance EOF ;
    public final void entryRuleComponentInstance() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:117:1: ( ruleComponentInstance EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:118:1: ruleComponentInstance EOF
            {
             before(grammarAccess.getComponentInstanceRule()); 
            pushFollow(FOLLOW_ruleComponentInstance_in_entryRuleComponentInstance181);
            ruleComponentInstance();

            state._fsp--;

             after(grammarAccess.getComponentInstanceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentInstance188); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:125:1: ruleComponentInstance : ( ( rule__ComponentInstance__Group__0 ) ) ;
    public final void ruleComponentInstance() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:129:2: ( ( ( rule__ComponentInstance__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:130:1: ( ( rule__ComponentInstance__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:130:1: ( ( rule__ComponentInstance__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:131:1: ( rule__ComponentInstance__Group__0 )
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:132:1: ( rule__ComponentInstance__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:132:2: rule__ComponentInstance__Group__0
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__0_in_ruleComponentInstance214);
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


    // $ANTLR start "entryRuleConnectionInstance"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:144:1: entryRuleConnectionInstance : ruleConnectionInstance EOF ;
    public final void entryRuleConnectionInstance() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:145:1: ( ruleConnectionInstance EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:146:1: ruleConnectionInstance EOF
            {
             before(grammarAccess.getConnectionInstanceRule()); 
            pushFollow(FOLLOW_ruleConnectionInstance_in_entryRuleConnectionInstance241);
            ruleConnectionInstance();

            state._fsp--;

             after(grammarAccess.getConnectionInstanceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionInstance248); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:153:1: ruleConnectionInstance : ( ( rule__ConnectionInstance__Group__0 ) ) ;
    public final void ruleConnectionInstance() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:157:2: ( ( ( rule__ConnectionInstance__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:158:1: ( ( rule__ConnectionInstance__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:158:1: ( ( rule__ConnectionInstance__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:159:1: ( rule__ConnectionInstance__Group__0 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:160:1: ( rule__ConnectionInstance__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:160:2: rule__ConnectionInstance__Group__0
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__0_in_ruleConnectionInstance274);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:172:1: entryRuleConnectionReference : ruleConnectionReference EOF ;
    public final void entryRuleConnectionReference() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:173:1: ( ruleConnectionReference EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:174:1: ruleConnectionReference EOF
            {
             before(grammarAccess.getConnectionReferenceRule()); 
            pushFollow(FOLLOW_ruleConnectionReference_in_entryRuleConnectionReference301);
            ruleConnectionReference();

            state._fsp--;

             after(grammarAccess.getConnectionReferenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionReference308); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:181:1: ruleConnectionReference : ( ( rule__ConnectionReference__Group__0 ) ) ;
    public final void ruleConnectionReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:185:2: ( ( ( rule__ConnectionReference__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:186:1: ( ( rule__ConnectionReference__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:186:1: ( ( rule__ConnectionReference__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:187:1: ( rule__ConnectionReference__Group__0 )
            {
             before(grammarAccess.getConnectionReferenceAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:188:1: ( rule__ConnectionReference__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:188:2: rule__ConnectionReference__Group__0
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__0_in_ruleConnectionReference334);
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


    // $ANTLR start "entryRuleFlowSpecificationInstance"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:200:1: entryRuleFlowSpecificationInstance : ruleFlowSpecificationInstance EOF ;
    public final void entryRuleFlowSpecificationInstance() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:201:1: ( ruleFlowSpecificationInstance EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:202:1: ruleFlowSpecificationInstance EOF
            {
             before(grammarAccess.getFlowSpecificationInstanceRule()); 
            pushFollow(FOLLOW_ruleFlowSpecificationInstance_in_entryRuleFlowSpecificationInstance361);
            ruleFlowSpecificationInstance();

            state._fsp--;

             after(grammarAccess.getFlowSpecificationInstanceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSpecificationInstance368); 

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
    // $ANTLR end "entryRuleFlowSpecificationInstance"


    // $ANTLR start "ruleFlowSpecificationInstance"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:209:1: ruleFlowSpecificationInstance : ( ( rule__FlowSpecificationInstance__Group__0 ) ) ;
    public final void ruleFlowSpecificationInstance() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:213:2: ( ( ( rule__FlowSpecificationInstance__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:214:1: ( ( rule__FlowSpecificationInstance__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:214:1: ( ( rule__FlowSpecificationInstance__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:215:1: ( rule__FlowSpecificationInstance__Group__0 )
            {
             before(grammarAccess.getFlowSpecificationInstanceAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:216:1: ( rule__FlowSpecificationInstance__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:216:2: rule__FlowSpecificationInstance__Group__0
            {
            pushFollow(FOLLOW_rule__FlowSpecificationInstance__Group__0_in_ruleFlowSpecificationInstance394);
            rule__FlowSpecificationInstance__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFlowSpecificationInstanceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFlowSpecificationInstance"


    // $ANTLR start "entryRuleSystemOperationMode"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:228:1: entryRuleSystemOperationMode : ruleSystemOperationMode EOF ;
    public final void entryRuleSystemOperationMode() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:229:1: ( ruleSystemOperationMode EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:230:1: ruleSystemOperationMode EOF
            {
             before(grammarAccess.getSystemOperationModeRule()); 
            pushFollow(FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode421);
            ruleSystemOperationMode();

            state._fsp--;

             after(grammarAccess.getSystemOperationModeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemOperationMode428); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:237:1: ruleSystemOperationMode : ( ( rule__SystemOperationMode__Group__0 ) ) ;
    public final void ruleSystemOperationMode() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:241:2: ( ( ( rule__SystemOperationMode__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:242:1: ( ( rule__SystemOperationMode__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:242:1: ( ( rule__SystemOperationMode__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:243:1: ( rule__SystemOperationMode__Group__0 )
            {
             before(grammarAccess.getSystemOperationModeAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:244:1: ( rule__SystemOperationMode__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:244:2: rule__SystemOperationMode__Group__0
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__Group__0_in_ruleSystemOperationMode454);
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


    // $ANTLR start "entryRuleDirectionType"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:256:1: entryRuleDirectionType : ruleDirectionType EOF ;
    public final void entryRuleDirectionType() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:257:1: ( ruleDirectionType EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:258:1: ruleDirectionType EOF
            {
             before(grammarAccess.getDirectionTypeRule()); 
            pushFollow(FOLLOW_ruleDirectionType_in_entryRuleDirectionType481);
            ruleDirectionType();

            state._fsp--;

             after(grammarAccess.getDirectionTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDirectionType488); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:265:1: ruleDirectionType : ( ( rule__DirectionType__Alternatives ) ) ;
    public final void ruleDirectionType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:269:2: ( ( ( rule__DirectionType__Alternatives ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:270:1: ( ( rule__DirectionType__Alternatives ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:270:1: ( ( rule__DirectionType__Alternatives ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:271:1: ( rule__DirectionType__Alternatives )
            {
             before(grammarAccess.getDirectionTypeAccess().getAlternatives()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:272:1: ( rule__DirectionType__Alternatives )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:272:2: rule__DirectionType__Alternatives
            {
            pushFollow(FOLLOW_rule__DirectionType__Alternatives_in_ruleDirectionType514);
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


    // $ANTLR start "entryRuleFeatureCategory"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:284:1: entryRuleFeatureCategory : ruleFeatureCategory EOF ;
    public final void entryRuleFeatureCategory() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:285:1: ( ruleFeatureCategory EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:286:1: ruleFeatureCategory EOF
            {
             before(grammarAccess.getFeatureCategoryRule()); 
            pushFollow(FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory541);
            ruleFeatureCategory();

            state._fsp--;

             after(grammarAccess.getFeatureCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCategory548); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:293:1: ruleFeatureCategory : ( ( rule__FeatureCategory__Alternatives ) ) ;
    public final void ruleFeatureCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:297:2: ( ( ( rule__FeatureCategory__Alternatives ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:298:1: ( ( rule__FeatureCategory__Alternatives ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:298:1: ( ( rule__FeatureCategory__Alternatives ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:299:1: ( rule__FeatureCategory__Alternatives )
            {
             before(grammarAccess.getFeatureCategoryAccess().getAlternatives()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:300:1: ( rule__FeatureCategory__Alternatives )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:300:2: rule__FeatureCategory__Alternatives
            {
            pushFollow(FOLLOW_rule__FeatureCategory__Alternatives_in_ruleFeatureCategory574);
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


    // $ANTLR start "entryRuleComponentCategory"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:312:1: entryRuleComponentCategory : ruleComponentCategory EOF ;
    public final void entryRuleComponentCategory() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:313:1: ( ruleComponentCategory EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:314:1: ruleComponentCategory EOF
            {
             before(grammarAccess.getComponentCategoryRule()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory601);
            ruleComponentCategory();

            state._fsp--;

             after(grammarAccess.getComponentCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentCategory608); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:321:1: ruleComponentCategory : ( ( rule__ComponentCategory__Alternatives ) ) ;
    public final void ruleComponentCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:325:2: ( ( ( rule__ComponentCategory__Alternatives ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:326:1: ( ( rule__ComponentCategory__Alternatives ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:326:1: ( ( rule__ComponentCategory__Alternatives ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:327:1: ( rule__ComponentCategory__Alternatives )
            {
             before(grammarAccess.getComponentCategoryAccess().getAlternatives()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:328:1: ( rule__ComponentCategory__Alternatives )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:328:2: rule__ComponentCategory__Alternatives
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Alternatives_in_ruleComponentCategory634);
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


    // $ANTLR start "entryRuleConnectionKind"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:340:1: entryRuleConnectionKind : ruleConnectionKind EOF ;
    public final void entryRuleConnectionKind() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:341:1: ( ruleConnectionKind EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:342:1: ruleConnectionKind EOF
            {
             before(grammarAccess.getConnectionKindRule()); 
            pushFollow(FOLLOW_ruleConnectionKind_in_entryRuleConnectionKind661);
            ruleConnectionKind();

            state._fsp--;

             after(grammarAccess.getConnectionKindRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionKind668); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:349:1: ruleConnectionKind : ( ( rule__ConnectionKind__Alternatives ) ) ;
    public final void ruleConnectionKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:353:2: ( ( ( rule__ConnectionKind__Alternatives ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:354:1: ( ( rule__ConnectionKind__Alternatives ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:354:1: ( ( rule__ConnectionKind__Alternatives ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:355:1: ( rule__ConnectionKind__Alternatives )
            {
             before(grammarAccess.getConnectionKindAccess().getAlternatives()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:356:1: ( rule__ConnectionKind__Alternatives )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:356:2: rule__ConnectionKind__Alternatives
            {
            pushFollow(FOLLOW_rule__ConnectionKind__Alternatives_in_ruleConnectionKind694);
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


    // $ANTLR start "entryRuleIMPLREF"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:368:1: entryRuleIMPLREF : ruleIMPLREF EOF ;
    public final void entryRuleIMPLREF() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:369:1: ( ruleIMPLREF EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:370:1: ruleIMPLREF EOF
            {
             before(grammarAccess.getIMPLREFRule()); 
            pushFollow(FOLLOW_ruleIMPLREF_in_entryRuleIMPLREF721);
            ruleIMPLREF();

            state._fsp--;

             after(grammarAccess.getIMPLREFRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIMPLREF728); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:377:1: ruleIMPLREF : ( ( rule__IMPLREF__Group__0 ) ) ;
    public final void ruleIMPLREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:381:2: ( ( ( rule__IMPLREF__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:382:1: ( ( rule__IMPLREF__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:382:1: ( ( rule__IMPLREF__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:383:1: ( rule__IMPLREF__Group__0 )
            {
             before(grammarAccess.getIMPLREFAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:384:1: ( rule__IMPLREF__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:384:2: rule__IMPLREF__Group__0
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group__0_in_ruleIMPLREF754);
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


    // $ANTLR start "entryRuleFEATREF"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:396:1: entryRuleFEATREF : ruleFEATREF EOF ;
    public final void entryRuleFEATREF() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:397:1: ( ruleFEATREF EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:398:1: ruleFEATREF EOF
            {
             before(grammarAccess.getFEATREFRule()); 
            pushFollow(FOLLOW_ruleFEATREF_in_entryRuleFEATREF781);
            ruleFEATREF();

            state._fsp--;

             after(grammarAccess.getFEATREFRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFEATREF788); 

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
    // $ANTLR end "entryRuleFEATREF"


    // $ANTLR start "ruleFEATREF"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:405:1: ruleFEATREF : ( ( rule__FEATREF__Group__0 ) ) ;
    public final void ruleFEATREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:409:2: ( ( ( rule__FEATREF__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:410:1: ( ( rule__FEATREF__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:410:1: ( ( rule__FEATREF__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:411:1: ( rule__FEATREF__Group__0 )
            {
             before(grammarAccess.getFEATREFAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:412:1: ( rule__FEATREF__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:412:2: rule__FEATREF__Group__0
            {
            pushFollow(FOLLOW_rule__FEATREF__Group__0_in_ruleFEATREF814);
            rule__FEATREF__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFEATREFAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFEATREF"


    // $ANTLR start "entryRuleSUBREF"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:424:1: entryRuleSUBREF : ruleSUBREF EOF ;
    public final void entryRuleSUBREF() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:425:1: ( ruleSUBREF EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:426:1: ruleSUBREF EOF
            {
             before(grammarAccess.getSUBREFRule()); 
            pushFollow(FOLLOW_ruleSUBREF_in_entryRuleSUBREF841);
            ruleSUBREF();

            state._fsp--;

             after(grammarAccess.getSUBREFRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSUBREF848); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:433:1: ruleSUBREF : ( ( rule__SUBREF__Group__0 ) ) ;
    public final void ruleSUBREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:437:2: ( ( ( rule__SUBREF__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:438:1: ( ( rule__SUBREF__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:438:1: ( ( rule__SUBREF__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:439:1: ( rule__SUBREF__Group__0 )
            {
             before(grammarAccess.getSUBREFAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:440:1: ( rule__SUBREF__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:440:2: rule__SUBREF__Group__0
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__0_in_ruleSUBREF874);
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


    // $ANTLR start "entryRuleINSTANCEREF"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:452:1: entryRuleINSTANCEREF : ruleINSTANCEREF EOF ;
    public final void entryRuleINSTANCEREF() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:453:1: ( ruleINSTANCEREF EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:454:1: ruleINSTANCEREF EOF
            {
             before(grammarAccess.getINSTANCEREFRule()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_entryRuleINSTANCEREF901);
            ruleINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getINSTANCEREFRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleINSTANCEREF908); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:461:1: ruleINSTANCEREF : ( ( rule__INSTANCEREF__Group__0 ) ) ;
    public final void ruleINSTANCEREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:465:2: ( ( ( rule__INSTANCEREF__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:466:1: ( ( rule__INSTANCEREF__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:466:1: ( ( rule__INSTANCEREF__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:467:1: ( rule__INSTANCEREF__Group__0 )
            {
             before(grammarAccess.getINSTANCEREFAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:468:1: ( rule__INSTANCEREF__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:468:2: rule__INSTANCEREF__Group__0
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group__0_in_ruleINSTANCEREF934);
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


    // $ANTLR start "entryRuleSIMPLEINSTANCEREF"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:480:1: entryRuleSIMPLEINSTANCEREF : ruleSIMPLEINSTANCEREF EOF ;
    public final void entryRuleSIMPLEINSTANCEREF() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:481:1: ( ruleSIMPLEINSTANCEREF EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:482:1: ruleSIMPLEINSTANCEREF EOF
            {
             before(grammarAccess.getSIMPLEINSTANCEREFRule()); 
            pushFollow(FOLLOW_ruleSIMPLEINSTANCEREF_in_entryRuleSIMPLEINSTANCEREF961);
            ruleSIMPLEINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getSIMPLEINSTANCEREFRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSIMPLEINSTANCEREF968); 

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
    // $ANTLR end "entryRuleSIMPLEINSTANCEREF"


    // $ANTLR start "ruleSIMPLEINSTANCEREF"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:489:1: ruleSIMPLEINSTANCEREF : ( ( rule__SIMPLEINSTANCEREF__Group__0 ) ) ;
    public final void ruleSIMPLEINSTANCEREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:493:2: ( ( ( rule__SIMPLEINSTANCEREF__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:494:1: ( ( rule__SIMPLEINSTANCEREF__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:494:1: ( ( rule__SIMPLEINSTANCEREF__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:495:1: ( rule__SIMPLEINSTANCEREF__Group__0 )
            {
             before(grammarAccess.getSIMPLEINSTANCEREFAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:496:1: ( rule__SIMPLEINSTANCEREF__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:496:2: rule__SIMPLEINSTANCEREF__Group__0
            {
            pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group__0_in_ruleSIMPLEINSTANCEREF994);
            rule__SIMPLEINSTANCEREF__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSIMPLEINSTANCEREFAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSIMPLEINSTANCEREF"


    // $ANTLR start "entryRuleINSTANCEREFWITHPARENT"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:508:1: entryRuleINSTANCEREFWITHPARENT : ruleINSTANCEREFWITHPARENT EOF ;
    public final void entryRuleINSTANCEREFWITHPARENT() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:509:1: ( ruleINSTANCEREFWITHPARENT EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:510:1: ruleINSTANCEREFWITHPARENT EOF
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTRule()); 
            pushFollow(FOLLOW_ruleINSTANCEREFWITHPARENT_in_entryRuleINSTANCEREFWITHPARENT1021);
            ruleINSTANCEREFWITHPARENT();

            state._fsp--;

             after(grammarAccess.getINSTANCEREFWITHPARENTRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleINSTANCEREFWITHPARENT1028); 

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
    // $ANTLR end "entryRuleINSTANCEREFWITHPARENT"


    // $ANTLR start "ruleINSTANCEREFWITHPARENT"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:517:1: ruleINSTANCEREFWITHPARENT : ( ( rule__INSTANCEREFWITHPARENT__Alternatives ) ) ;
    public final void ruleINSTANCEREFWITHPARENT() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:521:2: ( ( ( rule__INSTANCEREFWITHPARENT__Alternatives ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:522:1: ( ( rule__INSTANCEREFWITHPARENT__Alternatives ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:522:1: ( ( rule__INSTANCEREFWITHPARENT__Alternatives ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:523:1: ( rule__INSTANCEREFWITHPARENT__Alternatives )
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getAlternatives()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:524:1: ( rule__INSTANCEREFWITHPARENT__Alternatives )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:524:2: rule__INSTANCEREFWITHPARENT__Alternatives
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Alternatives_in_ruleINSTANCEREFWITHPARENT1054);
            rule__INSTANCEREFWITHPARENT__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getINSTANCEREFWITHPARENTAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleINSTANCEREFWITHPARENT"


    // $ANTLR start "entryRuleCONNINSTREF"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:536:1: entryRuleCONNINSTREF : ruleCONNINSTREF EOF ;
    public final void entryRuleCONNINSTREF() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:537:1: ( ruleCONNINSTREF EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:538:1: ruleCONNINSTREF EOF
            {
             before(grammarAccess.getCONNINSTREFRule()); 
            pushFollow(FOLLOW_ruleCONNINSTREF_in_entryRuleCONNINSTREF1081);
            ruleCONNINSTREF();

            state._fsp--;

             after(grammarAccess.getCONNINSTREFRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCONNINSTREF1088); 

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
    // $ANTLR end "entryRuleCONNINSTREF"


    // $ANTLR start "ruleCONNINSTREF"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:545:1: ruleCONNINSTREF : ( ( rule__CONNINSTREF__Group__0 ) ) ;
    public final void ruleCONNINSTREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:549:2: ( ( ( rule__CONNINSTREF__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:550:1: ( ( rule__CONNINSTREF__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:550:1: ( ( rule__CONNINSTREF__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:551:1: ( rule__CONNINSTREF__Group__0 )
            {
             before(grammarAccess.getCONNINSTREFAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:552:1: ( rule__CONNINSTREF__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:552:2: rule__CONNINSTREF__Group__0
            {
            pushFollow(FOLLOW_rule__CONNINSTREF__Group__0_in_ruleCONNINSTREF1114);
            rule__CONNINSTREF__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCONNINSTREFAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCONNINSTREF"


    // $ANTLR start "rule__SystemInstance__Alternatives_5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:564:1: rule__SystemInstance__Alternatives_5 : ( ( ( rule__SystemInstance__FeatureInstanceAssignment_5_0 ) ) | ( ( rule__SystemInstance__ComponentInstanceAssignment_5_1 ) ) | ( ( rule__SystemInstance__ConnectionInstanceAssignment_5_2 ) ) | ( ( rule__SystemInstance__FlowSpecificationAssignment_5_3 ) ) | ( ( rule__SystemInstance__SystemOperationModeAssignment_5_4 ) ) );
    public final void rule__SystemInstance__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:568:1: ( ( ( rule__SystemInstance__FeatureInstanceAssignment_5_0 ) ) | ( ( rule__SystemInstance__ComponentInstanceAssignment_5_1 ) ) | ( ( rule__SystemInstance__ConnectionInstanceAssignment_5_2 ) ) | ( ( rule__SystemInstance__FlowSpecificationAssignment_5_3 ) ) | ( ( rule__SystemInstance__SystemOperationModeAssignment_5_4 ) ) )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 10:
            case 11:
                {
                alt1=1;
                }
                break;
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 52:
                {
                alt1=2;
                }
                break;
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 55:
                {
                alt1=3;
                }
                break;
            case 49:
                {
                alt1=4;
                }
                break;
            case 50:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:569:1: ( ( rule__SystemInstance__FeatureInstanceAssignment_5_0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:569:1: ( ( rule__SystemInstance__FeatureInstanceAssignment_5_0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:570:1: ( rule__SystemInstance__FeatureInstanceAssignment_5_0 )
                    {
                     before(grammarAccess.getSystemInstanceAccess().getFeatureInstanceAssignment_5_0()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:571:1: ( rule__SystemInstance__FeatureInstanceAssignment_5_0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:571:2: rule__SystemInstance__FeatureInstanceAssignment_5_0
                    {
                    pushFollow(FOLLOW_rule__SystemInstance__FeatureInstanceAssignment_5_0_in_rule__SystemInstance__Alternatives_51150);
                    rule__SystemInstance__FeatureInstanceAssignment_5_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSystemInstanceAccess().getFeatureInstanceAssignment_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:575:6: ( ( rule__SystemInstance__ComponentInstanceAssignment_5_1 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:575:6: ( ( rule__SystemInstance__ComponentInstanceAssignment_5_1 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:576:1: ( rule__SystemInstance__ComponentInstanceAssignment_5_1 )
                    {
                     before(grammarAccess.getSystemInstanceAccess().getComponentInstanceAssignment_5_1()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:577:1: ( rule__SystemInstance__ComponentInstanceAssignment_5_1 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:577:2: rule__SystemInstance__ComponentInstanceAssignment_5_1
                    {
                    pushFollow(FOLLOW_rule__SystemInstance__ComponentInstanceAssignment_5_1_in_rule__SystemInstance__Alternatives_51168);
                    rule__SystemInstance__ComponentInstanceAssignment_5_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getSystemInstanceAccess().getComponentInstanceAssignment_5_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:581:6: ( ( rule__SystemInstance__ConnectionInstanceAssignment_5_2 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:581:6: ( ( rule__SystemInstance__ConnectionInstanceAssignment_5_2 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:582:1: ( rule__SystemInstance__ConnectionInstanceAssignment_5_2 )
                    {
                     before(grammarAccess.getSystemInstanceAccess().getConnectionInstanceAssignment_5_2()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:583:1: ( rule__SystemInstance__ConnectionInstanceAssignment_5_2 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:583:2: rule__SystemInstance__ConnectionInstanceAssignment_5_2
                    {
                    pushFollow(FOLLOW_rule__SystemInstance__ConnectionInstanceAssignment_5_2_in_rule__SystemInstance__Alternatives_51186);
                    rule__SystemInstance__ConnectionInstanceAssignment_5_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getSystemInstanceAccess().getConnectionInstanceAssignment_5_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:587:6: ( ( rule__SystemInstance__FlowSpecificationAssignment_5_3 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:587:6: ( ( rule__SystemInstance__FlowSpecificationAssignment_5_3 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:588:1: ( rule__SystemInstance__FlowSpecificationAssignment_5_3 )
                    {
                     before(grammarAccess.getSystemInstanceAccess().getFlowSpecificationAssignment_5_3()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:589:1: ( rule__SystemInstance__FlowSpecificationAssignment_5_3 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:589:2: rule__SystemInstance__FlowSpecificationAssignment_5_3
                    {
                    pushFollow(FOLLOW_rule__SystemInstance__FlowSpecificationAssignment_5_3_in_rule__SystemInstance__Alternatives_51204);
                    rule__SystemInstance__FlowSpecificationAssignment_5_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getSystemInstanceAccess().getFlowSpecificationAssignment_5_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:593:6: ( ( rule__SystemInstance__SystemOperationModeAssignment_5_4 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:593:6: ( ( rule__SystemInstance__SystemOperationModeAssignment_5_4 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:594:1: ( rule__SystemInstance__SystemOperationModeAssignment_5_4 )
                    {
                     before(grammarAccess.getSystemInstanceAccess().getSystemOperationModeAssignment_5_4()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:595:1: ( rule__SystemInstance__SystemOperationModeAssignment_5_4 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:595:2: rule__SystemInstance__SystemOperationModeAssignment_5_4
                    {
                    pushFollow(FOLLOW_rule__SystemInstance__SystemOperationModeAssignment_5_4_in_rule__SystemInstance__Alternatives_51222);
                    rule__SystemInstance__SystemOperationModeAssignment_5_4();

                    state._fsp--;


                    }

                     after(grammarAccess.getSystemInstanceAccess().getSystemOperationModeAssignment_5_4()); 

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


    // $ANTLR start "rule__FeatureInstance__Alternatives_6_3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:604:1: rule__FeatureInstance__Alternatives_6_3 : ( ( ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3_0 ) ) | ( ( rule__FeatureInstance__SrcFlowSpecAssignment_6_3_1 ) ) );
    public final void rule__FeatureInstance__Alternatives_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:608:1: ( ( ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3_0 ) ) | ( ( rule__FeatureInstance__SrcFlowSpecAssignment_6_3_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_LONG) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:609:1: ( ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3_0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:609:1: ( ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3_0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:610:1: ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3_0 )
                    {
                     before(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceAssignment_6_3_0()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:611:1: ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3_0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:611:2: rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3_0
                    {
                    pushFollow(FOLLOW_rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3_0_in_rule__FeatureInstance__Alternatives_6_31255);
                    rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceAssignment_6_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:615:6: ( ( rule__FeatureInstance__SrcFlowSpecAssignment_6_3_1 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:615:6: ( ( rule__FeatureInstance__SrcFlowSpecAssignment_6_3_1 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:616:1: ( rule__FeatureInstance__SrcFlowSpecAssignment_6_3_1 )
                    {
                     before(grammarAccess.getFeatureInstanceAccess().getSrcFlowSpecAssignment_6_3_1()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:617:1: ( rule__FeatureInstance__SrcFlowSpecAssignment_6_3_1 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:617:2: rule__FeatureInstance__SrcFlowSpecAssignment_6_3_1
                    {
                    pushFollow(FOLLOW_rule__FeatureInstance__SrcFlowSpecAssignment_6_3_1_in_rule__FeatureInstance__Alternatives_6_31273);
                    rule__FeatureInstance__SrcFlowSpecAssignment_6_3_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getFeatureInstanceAccess().getSrcFlowSpecAssignment_6_3_1()); 

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
    // $ANTLR end "rule__FeatureInstance__Alternatives_6_3"


    // $ANTLR start "rule__FeatureInstance__Alternatives_6_4_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:626:1: rule__FeatureInstance__Alternatives_6_4_1 : ( ( ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1_0 ) ) | ( ( rule__FeatureInstance__SrcFlowSpecAssignment_6_4_1_1 ) ) );
    public final void rule__FeatureInstance__Alternatives_6_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:630:1: ( ( ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1_0 ) ) | ( ( rule__FeatureInstance__SrcFlowSpecAssignment_6_4_1_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_LONG) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:631:1: ( ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1_0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:631:1: ( ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1_0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:632:1: ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1_0 )
                    {
                     before(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceAssignment_6_4_1_0()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:633:1: ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1_0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:633:2: rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1_0
                    {
                    pushFollow(FOLLOW_rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1_0_in_rule__FeatureInstance__Alternatives_6_4_11306);
                    rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceAssignment_6_4_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:637:6: ( ( rule__FeatureInstance__SrcFlowSpecAssignment_6_4_1_1 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:637:6: ( ( rule__FeatureInstance__SrcFlowSpecAssignment_6_4_1_1 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:638:1: ( rule__FeatureInstance__SrcFlowSpecAssignment_6_4_1_1 )
                    {
                     before(grammarAccess.getFeatureInstanceAccess().getSrcFlowSpecAssignment_6_4_1_1()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:639:1: ( rule__FeatureInstance__SrcFlowSpecAssignment_6_4_1_1 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:639:2: rule__FeatureInstance__SrcFlowSpecAssignment_6_4_1_1
                    {
                    pushFollow(FOLLOW_rule__FeatureInstance__SrcFlowSpecAssignment_6_4_1_1_in_rule__FeatureInstance__Alternatives_6_4_11324);
                    rule__FeatureInstance__SrcFlowSpecAssignment_6_4_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getFeatureInstanceAccess().getSrcFlowSpecAssignment_6_4_1_1()); 

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
    // $ANTLR end "rule__FeatureInstance__Alternatives_6_4_1"


    // $ANTLR start "rule__FeatureInstance__Alternatives_7_3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:648:1: rule__FeatureInstance__Alternatives_7_3 : ( ( ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_3_0 ) ) | ( ( rule__FeatureInstance__DstFlowSpecAssignment_7_3_1 ) ) );
    public final void rule__FeatureInstance__Alternatives_7_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:652:1: ( ( ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_3_0 ) ) | ( ( rule__FeatureInstance__DstFlowSpecAssignment_7_3_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_LONG) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_ID) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:653:1: ( ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_3_0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:653:1: ( ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_3_0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:654:1: ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_3_0 )
                    {
                     before(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceAssignment_7_3_0()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:655:1: ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_3_0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:655:2: rule__FeatureInstance__DstConnectionInstanceAssignment_7_3_0
                    {
                    pushFollow(FOLLOW_rule__FeatureInstance__DstConnectionInstanceAssignment_7_3_0_in_rule__FeatureInstance__Alternatives_7_31357);
                    rule__FeatureInstance__DstConnectionInstanceAssignment_7_3_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceAssignment_7_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:659:6: ( ( rule__FeatureInstance__DstFlowSpecAssignment_7_3_1 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:659:6: ( ( rule__FeatureInstance__DstFlowSpecAssignment_7_3_1 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:660:1: ( rule__FeatureInstance__DstFlowSpecAssignment_7_3_1 )
                    {
                     before(grammarAccess.getFeatureInstanceAccess().getDstFlowSpecAssignment_7_3_1()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:661:1: ( rule__FeatureInstance__DstFlowSpecAssignment_7_3_1 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:661:2: rule__FeatureInstance__DstFlowSpecAssignment_7_3_1
                    {
                    pushFollow(FOLLOW_rule__FeatureInstance__DstFlowSpecAssignment_7_3_1_in_rule__FeatureInstance__Alternatives_7_31375);
                    rule__FeatureInstance__DstFlowSpecAssignment_7_3_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getFeatureInstanceAccess().getDstFlowSpecAssignment_7_3_1()); 

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
    // $ANTLR end "rule__FeatureInstance__Alternatives_7_3"


    // $ANTLR start "rule__FeatureInstance__Alternatives_7_4_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:670:1: rule__FeatureInstance__Alternatives_7_4_1 : ( ( ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1_0 ) ) | ( ( rule__FeatureInstance__DstFlowSpecAssignment_7_4_1_1 ) ) );
    public final void rule__FeatureInstance__Alternatives_7_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:674:1: ( ( ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1_0 ) ) | ( ( rule__FeatureInstance__DstFlowSpecAssignment_7_4_1_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_LONG) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:675:1: ( ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1_0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:675:1: ( ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1_0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:676:1: ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1_0 )
                    {
                     before(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceAssignment_7_4_1_0()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:677:1: ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1_0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:677:2: rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1_0
                    {
                    pushFollow(FOLLOW_rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1_0_in_rule__FeatureInstance__Alternatives_7_4_11408);
                    rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceAssignment_7_4_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:681:6: ( ( rule__FeatureInstance__DstFlowSpecAssignment_7_4_1_1 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:681:6: ( ( rule__FeatureInstance__DstFlowSpecAssignment_7_4_1_1 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:682:1: ( rule__FeatureInstance__DstFlowSpecAssignment_7_4_1_1 )
                    {
                     before(grammarAccess.getFeatureInstanceAccess().getDstFlowSpecAssignment_7_4_1_1()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:683:1: ( rule__FeatureInstance__DstFlowSpecAssignment_7_4_1_1 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:683:2: rule__FeatureInstance__DstFlowSpecAssignment_7_4_1_1
                    {
                    pushFollow(FOLLOW_rule__FeatureInstance__DstFlowSpecAssignment_7_4_1_1_in_rule__FeatureInstance__Alternatives_7_4_11426);
                    rule__FeatureInstance__DstFlowSpecAssignment_7_4_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getFeatureInstanceAccess().getDstFlowSpecAssignment_7_4_1_1()); 

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
    // $ANTLR end "rule__FeatureInstance__Alternatives_7_4_1"


    // $ANTLR start "rule__ComponentInstance__Alternatives_7_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:692:1: rule__ComponentInstance__Alternatives_7_1 : ( ( ( rule__ComponentInstance__FeatureInstanceAssignment_7_1_0 ) ) | ( ( rule__ComponentInstance__ComponentInstanceAssignment_7_1_1 ) ) | ( ( rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2 ) ) | ( ( rule__ComponentInstance__FlowSpecificationAssignment_7_1_3 ) ) );
    public final void rule__ComponentInstance__Alternatives_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:696:1: ( ( ( rule__ComponentInstance__FeatureInstanceAssignment_7_1_0 ) ) | ( ( rule__ComponentInstance__ComponentInstanceAssignment_7_1_1 ) ) | ( ( rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2 ) ) | ( ( rule__ComponentInstance__FlowSpecificationAssignment_7_1_3 ) ) )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 10:
            case 11:
                {
                alt6=1;
                }
                break;
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 52:
                {
                alt6=2;
                }
                break;
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 55:
                {
                alt6=3;
                }
                break;
            case 49:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:697:1: ( ( rule__ComponentInstance__FeatureInstanceAssignment_7_1_0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:697:1: ( ( rule__ComponentInstance__FeatureInstanceAssignment_7_1_0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:698:1: ( rule__ComponentInstance__FeatureInstanceAssignment_7_1_0 )
                    {
                     before(grammarAccess.getComponentInstanceAccess().getFeatureInstanceAssignment_7_1_0()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:699:1: ( rule__ComponentInstance__FeatureInstanceAssignment_7_1_0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:699:2: rule__ComponentInstance__FeatureInstanceAssignment_7_1_0
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__FeatureInstanceAssignment_7_1_0_in_rule__ComponentInstance__Alternatives_7_11459);
                    rule__ComponentInstance__FeatureInstanceAssignment_7_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentInstanceAccess().getFeatureInstanceAssignment_7_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:703:6: ( ( rule__ComponentInstance__ComponentInstanceAssignment_7_1_1 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:703:6: ( ( rule__ComponentInstance__ComponentInstanceAssignment_7_1_1 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:704:1: ( rule__ComponentInstance__ComponentInstanceAssignment_7_1_1 )
                    {
                     before(grammarAccess.getComponentInstanceAccess().getComponentInstanceAssignment_7_1_1()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:705:1: ( rule__ComponentInstance__ComponentInstanceAssignment_7_1_1 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:705:2: rule__ComponentInstance__ComponentInstanceAssignment_7_1_1
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__ComponentInstanceAssignment_7_1_1_in_rule__ComponentInstance__Alternatives_7_11477);
                    rule__ComponentInstance__ComponentInstanceAssignment_7_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentInstanceAccess().getComponentInstanceAssignment_7_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:709:6: ( ( rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:709:6: ( ( rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:710:1: ( rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2 )
                    {
                     before(grammarAccess.getComponentInstanceAccess().getConnectionInstanceAssignment_7_1_2()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:711:1: ( rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:711:2: rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2_in_rule__ComponentInstance__Alternatives_7_11495);
                    rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentInstanceAccess().getConnectionInstanceAssignment_7_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:715:6: ( ( rule__ComponentInstance__FlowSpecificationAssignment_7_1_3 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:715:6: ( ( rule__ComponentInstance__FlowSpecificationAssignment_7_1_3 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:716:1: ( rule__ComponentInstance__FlowSpecificationAssignment_7_1_3 )
                    {
                     before(grammarAccess.getComponentInstanceAccess().getFlowSpecificationAssignment_7_1_3()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:717:1: ( rule__ComponentInstance__FlowSpecificationAssignment_7_1_3 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:717:2: rule__ComponentInstance__FlowSpecificationAssignment_7_1_3
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__FlowSpecificationAssignment_7_1_3_in_rule__ComponentInstance__Alternatives_7_11513);
                    rule__ComponentInstance__FlowSpecificationAssignment_7_1_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentInstanceAccess().getFlowSpecificationAssignment_7_1_3()); 

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
    // $ANTLR end "rule__ComponentInstance__Alternatives_7_1"


    // $ANTLR start "rule__ConnectionInstance__Alternatives_5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:726:1: rule__ConnectionInstance__Alternatives_5 : ( ( ( rule__ConnectionInstance__BidirectionalAssignment_5_0 ) ) | ( '->' ) );
    public final void rule__ConnectionInstance__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:730:1: ( ( ( rule__ConnectionInstance__BidirectionalAssignment_5_0 ) ) | ( '->' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==56) ) {
                alt7=1;
            }
            else if ( (LA7_0==9) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:731:1: ( ( rule__ConnectionInstance__BidirectionalAssignment_5_0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:731:1: ( ( rule__ConnectionInstance__BidirectionalAssignment_5_0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:732:1: ( rule__ConnectionInstance__BidirectionalAssignment_5_0 )
                    {
                     before(grammarAccess.getConnectionInstanceAccess().getBidirectionalAssignment_5_0()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:733:1: ( rule__ConnectionInstance__BidirectionalAssignment_5_0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:733:2: rule__ConnectionInstance__BidirectionalAssignment_5_0
                    {
                    pushFollow(FOLLOW_rule__ConnectionInstance__BidirectionalAssignment_5_0_in_rule__ConnectionInstance__Alternatives_51546);
                    rule__ConnectionInstance__BidirectionalAssignment_5_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getConnectionInstanceAccess().getBidirectionalAssignment_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:737:6: ( '->' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:737:6: ( '->' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:738:1: '->'
                    {
                     before(grammarAccess.getConnectionInstanceAccess().getHyphenMinusGreaterThanSignKeyword_5_1()); 
                    match(input,9,FOLLOW_9_in_rule__ConnectionInstance__Alternatives_51565); 
                     after(grammarAccess.getConnectionInstanceAccess().getHyphenMinusGreaterThanSignKeyword_5_1()); 

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
    // $ANTLR end "rule__ConnectionInstance__Alternatives_5"


    // $ANTLR start "rule__DirectionType__Alternatives"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:750:1: rule__DirectionType__Alternatives : ( ( 'in' ) | ( 'out' ) | ( ( rule__DirectionType__Group_2__0 ) ) );
    public final void rule__DirectionType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:754:1: ( ( 'in' ) | ( 'out' ) | ( ( rule__DirectionType__Group_2__0 ) ) )
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==10) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==EOF||(LA8_1>=12 && LA8_1<=20)) ) {
                    alt8=1;
                }
                else if ( (LA8_1==11) ) {
                    alt8=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA8_0==11) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:755:1: ( 'in' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:755:1: ( 'in' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:756:1: 'in'
                    {
                     before(grammarAccess.getDirectionTypeAccess().getInKeyword_0()); 
                    match(input,10,FOLLOW_10_in_rule__DirectionType__Alternatives1600); 
                     after(grammarAccess.getDirectionTypeAccess().getInKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:763:6: ( 'out' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:763:6: ( 'out' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:764:1: 'out'
                    {
                     before(grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); 
                    match(input,11,FOLLOW_11_in_rule__DirectionType__Alternatives1620); 
                     after(grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:771:6: ( ( rule__DirectionType__Group_2__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:771:6: ( ( rule__DirectionType__Group_2__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:772:1: ( rule__DirectionType__Group_2__0 )
                    {
                     before(grammarAccess.getDirectionTypeAccess().getGroup_2()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:773:1: ( rule__DirectionType__Group_2__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:773:2: rule__DirectionType__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__DirectionType__Group_2__0_in_rule__DirectionType__Alternatives1639);
                    rule__DirectionType__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDirectionTypeAccess().getGroup_2()); 

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


    // $ANTLR start "rule__FeatureCategory__Alternatives"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:782:1: rule__FeatureCategory__Alternatives : ( ( 'dataPort' ) | ( 'eventPort' ) | ( 'eventDataPort' ) | ( 'parameter' ) | ( 'busAccess' ) | ( 'subprogramAccess' ) | ( 'subprogramGroupAccess' ) | ( 'featureGroup' ) | ( 'abstractFeature' ) );
    public final void rule__FeatureCategory__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:786:1: ( ( 'dataPort' ) | ( 'eventPort' ) | ( 'eventDataPort' ) | ( 'parameter' ) | ( 'busAccess' ) | ( 'subprogramAccess' ) | ( 'subprogramGroupAccess' ) | ( 'featureGroup' ) | ( 'abstractFeature' ) )
            int alt9=9;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt9=1;
                }
                break;
            case 13:
                {
                alt9=2;
                }
                break;
            case 14:
                {
                alt9=3;
                }
                break;
            case 15:
                {
                alt9=4;
                }
                break;
            case 16:
                {
                alt9=5;
                }
                break;
            case 17:
                {
                alt9=6;
                }
                break;
            case 18:
                {
                alt9=7;
                }
                break;
            case 19:
                {
                alt9=8;
                }
                break;
            case 20:
                {
                alt9=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:787:1: ( 'dataPort' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:787:1: ( 'dataPort' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:788:1: 'dataPort'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getDataPortKeyword_0()); 
                    match(input,12,FOLLOW_12_in_rule__FeatureCategory__Alternatives1673); 
                     after(grammarAccess.getFeatureCategoryAccess().getDataPortKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:795:6: ( 'eventPort' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:795:6: ( 'eventPort' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:796:1: 'eventPort'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getEventPortKeyword_1()); 
                    match(input,13,FOLLOW_13_in_rule__FeatureCategory__Alternatives1693); 
                     after(grammarAccess.getFeatureCategoryAccess().getEventPortKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:803:6: ( 'eventDataPort' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:803:6: ( 'eventDataPort' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:804:1: 'eventDataPort'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getEventDataPortKeyword_2()); 
                    match(input,14,FOLLOW_14_in_rule__FeatureCategory__Alternatives1713); 
                     after(grammarAccess.getFeatureCategoryAccess().getEventDataPortKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:811:6: ( 'parameter' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:811:6: ( 'parameter' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:812:1: 'parameter'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); 
                    match(input,15,FOLLOW_15_in_rule__FeatureCategory__Alternatives1733); 
                     after(grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:819:6: ( 'busAccess' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:819:6: ( 'busAccess' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:820:1: 'busAccess'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getBusAccessKeyword_4()); 
                    match(input,16,FOLLOW_16_in_rule__FeatureCategory__Alternatives1753); 
                     after(grammarAccess.getFeatureCategoryAccess().getBusAccessKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:827:6: ( 'subprogramAccess' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:827:6: ( 'subprogramAccess' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:828:1: 'subprogramAccess'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getSubprogramAccessKeyword_5()); 
                    match(input,17,FOLLOW_17_in_rule__FeatureCategory__Alternatives1773); 
                     after(grammarAccess.getFeatureCategoryAccess().getSubprogramAccessKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:835:6: ( 'subprogramGroupAccess' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:835:6: ( 'subprogramGroupAccess' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:836:1: 'subprogramGroupAccess'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getSubprogramGroupAccessKeyword_6()); 
                    match(input,18,FOLLOW_18_in_rule__FeatureCategory__Alternatives1793); 
                     after(grammarAccess.getFeatureCategoryAccess().getSubprogramGroupAccessKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:843:6: ( 'featureGroup' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:843:6: ( 'featureGroup' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:844:1: 'featureGroup'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getFeatureGroupKeyword_7()); 
                    match(input,19,FOLLOW_19_in_rule__FeatureCategory__Alternatives1813); 
                     after(grammarAccess.getFeatureCategoryAccess().getFeatureGroupKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:851:6: ( 'abstractFeature' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:851:6: ( 'abstractFeature' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:852:1: 'abstractFeature'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getAbstractFeatureKeyword_8()); 
                    match(input,20,FOLLOW_20_in_rule__FeatureCategory__Alternatives1833); 
                     after(grammarAccess.getFeatureCategoryAccess().getAbstractFeatureKeyword_8()); 

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


    // $ANTLR start "rule__ComponentCategory__Alternatives"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:864:1: rule__ComponentCategory__Alternatives : ( ( 'abstract' ) | ( 'bus' ) | ( 'data' ) | ( 'device' ) | ( 'memory' ) | ( 'process' ) | ( 'processor' ) | ( 'subprogram' ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( 'system' ) | ( ( rule__ComponentCategory__Group_10__0 ) ) | ( 'thread' ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( ( rule__ComponentCategory__Group_13__0 ) ) );
    public final void rule__ComponentCategory__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:868:1: ( ( 'abstract' ) | ( 'bus' ) | ( 'data' ) | ( 'device' ) | ( 'memory' ) | ( 'process' ) | ( 'processor' ) | ( 'subprogram' ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( 'system' ) | ( ( rule__ComponentCategory__Group_10__0 ) ) | ( 'thread' ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( ( rule__ComponentCategory__Group_13__0 ) ) )
            int alt10=14;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:869:1: ( 'abstract' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:869:1: ( 'abstract' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:870:1: 'abstract'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
                    match(input,21,FOLLOW_21_in_rule__ComponentCategory__Alternatives1868); 
                     after(grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:877:6: ( 'bus' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:877:6: ( 'bus' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:878:1: 'bus'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
                    match(input,22,FOLLOW_22_in_rule__ComponentCategory__Alternatives1888); 
                     after(grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:885:6: ( 'data' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:885:6: ( 'data' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:886:1: 'data'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
                    match(input,23,FOLLOW_23_in_rule__ComponentCategory__Alternatives1908); 
                     after(grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:893:6: ( 'device' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:893:6: ( 'device' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:894:1: 'device'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
                    match(input,24,FOLLOW_24_in_rule__ComponentCategory__Alternatives1928); 
                     after(grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:901:6: ( 'memory' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:901:6: ( 'memory' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:902:1: 'memory'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
                    match(input,25,FOLLOW_25_in_rule__ComponentCategory__Alternatives1948); 
                     after(grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:909:6: ( 'process' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:909:6: ( 'process' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:910:1: 'process'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
                    match(input,26,FOLLOW_26_in_rule__ComponentCategory__Alternatives1968); 
                     after(grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:917:6: ( 'processor' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:917:6: ( 'processor' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:918:1: 'processor'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
                    match(input,27,FOLLOW_27_in_rule__ComponentCategory__Alternatives1988); 
                     after(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:925:6: ( 'subprogram' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:925:6: ( 'subprogram' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:926:1: 'subprogram'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
                    match(input,28,FOLLOW_28_in_rule__ComponentCategory__Alternatives2008); 
                     after(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:933:6: ( ( rule__ComponentCategory__Group_8__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:933:6: ( ( rule__ComponentCategory__Group_8__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:934:1: ( rule__ComponentCategory__Group_8__0 )
                    {
                     before(grammarAccess.getComponentCategoryAccess().getGroup_8()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:935:1: ( rule__ComponentCategory__Group_8__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:935:2: rule__ComponentCategory__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__ComponentCategory__Group_8__0_in_rule__ComponentCategory__Alternatives2027);
                    rule__ComponentCategory__Group_8__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentCategoryAccess().getGroup_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:939:6: ( 'system' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:939:6: ( 'system' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:940:1: 'system'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
                    match(input,29,FOLLOW_29_in_rule__ComponentCategory__Alternatives2046); 
                     after(grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:947:6: ( ( rule__ComponentCategory__Group_10__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:947:6: ( ( rule__ComponentCategory__Group_10__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:948:1: ( rule__ComponentCategory__Group_10__0 )
                    {
                     before(grammarAccess.getComponentCategoryAccess().getGroup_10()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:949:1: ( rule__ComponentCategory__Group_10__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:949:2: rule__ComponentCategory__Group_10__0
                    {
                    pushFollow(FOLLOW_rule__ComponentCategory__Group_10__0_in_rule__ComponentCategory__Alternatives2065);
                    rule__ComponentCategory__Group_10__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentCategoryAccess().getGroup_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:953:6: ( 'thread' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:953:6: ( 'thread' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:954:1: 'thread'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
                    match(input,30,FOLLOW_30_in_rule__ComponentCategory__Alternatives2084); 
                     after(grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:961:6: ( ( rule__ComponentCategory__Group_12__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:961:6: ( ( rule__ComponentCategory__Group_12__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:962:1: ( rule__ComponentCategory__Group_12__0 )
                    {
                     before(grammarAccess.getComponentCategoryAccess().getGroup_12()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:963:1: ( rule__ComponentCategory__Group_12__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:963:2: rule__ComponentCategory__Group_12__0
                    {
                    pushFollow(FOLLOW_rule__ComponentCategory__Group_12__0_in_rule__ComponentCategory__Alternatives2103);
                    rule__ComponentCategory__Group_12__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentCategoryAccess().getGroup_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:967:6: ( ( rule__ComponentCategory__Group_13__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:967:6: ( ( rule__ComponentCategory__Group_13__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:968:1: ( rule__ComponentCategory__Group_13__0 )
                    {
                     before(grammarAccess.getComponentCategoryAccess().getGroup_13()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:969:1: ( rule__ComponentCategory__Group_13__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:969:2: rule__ComponentCategory__Group_13__0
                    {
                    pushFollow(FOLLOW_rule__ComponentCategory__Group_13__0_in_rule__ComponentCategory__Alternatives2121);
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


    // $ANTLR start "rule__ConnectionKind__Alternatives"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:978:1: rule__ConnectionKind__Alternatives : ( ( 'featureConnection' ) | ( 'accessConnection' ) | ( 'parameterConnection' ) | ( 'portConnection' ) | ( 'modeTransitionConnection' ) | ( 'featureGroupConnection' ) );
    public final void rule__ConnectionKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:982:1: ( ( 'featureConnection' ) | ( 'accessConnection' ) | ( 'parameterConnection' ) | ( 'portConnection' ) | ( 'modeTransitionConnection' ) | ( 'featureGroupConnection' ) )
            int alt11=6;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt11=1;
                }
                break;
            case 32:
                {
                alt11=2;
                }
                break;
            case 33:
                {
                alt11=3;
                }
                break;
            case 34:
                {
                alt11=4;
                }
                break;
            case 35:
                {
                alt11=5;
                }
                break;
            case 36:
                {
                alt11=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:983:1: ( 'featureConnection' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:983:1: ( 'featureConnection' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:984:1: 'featureConnection'
                    {
                     before(grammarAccess.getConnectionKindAccess().getFeatureConnectionKeyword_0()); 
                    match(input,31,FOLLOW_31_in_rule__ConnectionKind__Alternatives2155); 
                     after(grammarAccess.getConnectionKindAccess().getFeatureConnectionKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:991:6: ( 'accessConnection' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:991:6: ( 'accessConnection' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:992:1: 'accessConnection'
                    {
                     before(grammarAccess.getConnectionKindAccess().getAccessConnectionKeyword_1()); 
                    match(input,32,FOLLOW_32_in_rule__ConnectionKind__Alternatives2175); 
                     after(grammarAccess.getConnectionKindAccess().getAccessConnectionKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:999:6: ( 'parameterConnection' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:999:6: ( 'parameterConnection' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1000:1: 'parameterConnection'
                    {
                     before(grammarAccess.getConnectionKindAccess().getParameterConnectionKeyword_2()); 
                    match(input,33,FOLLOW_33_in_rule__ConnectionKind__Alternatives2195); 
                     after(grammarAccess.getConnectionKindAccess().getParameterConnectionKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1007:6: ( 'portConnection' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1007:6: ( 'portConnection' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1008:1: 'portConnection'
                    {
                     before(grammarAccess.getConnectionKindAccess().getPortConnectionKeyword_3()); 
                    match(input,34,FOLLOW_34_in_rule__ConnectionKind__Alternatives2215); 
                     after(grammarAccess.getConnectionKindAccess().getPortConnectionKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1015:6: ( 'modeTransitionConnection' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1015:6: ( 'modeTransitionConnection' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1016:1: 'modeTransitionConnection'
                    {
                     before(grammarAccess.getConnectionKindAccess().getModeTransitionConnectionKeyword_4()); 
                    match(input,35,FOLLOW_35_in_rule__ConnectionKind__Alternatives2235); 
                     after(grammarAccess.getConnectionKindAccess().getModeTransitionConnectionKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1023:6: ( 'featureGroupConnection' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1023:6: ( 'featureGroupConnection' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1024:1: 'featureGroupConnection'
                    {
                     before(grammarAccess.getConnectionKindAccess().getFeatureGroupConnectionKeyword_5()); 
                    match(input,36,FOLLOW_36_in_rule__ConnectionKind__Alternatives2255); 
                     after(grammarAccess.getConnectionKindAccess().getFeatureGroupConnectionKeyword_5()); 

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


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Alternatives"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1036:1: rule__INSTANCEREFWITHPARENT__Alternatives : ( ( 'parent' ) | ( ( rule__INSTANCEREFWITHPARENT__Group_1__0 ) ) );
    public final void rule__INSTANCEREFWITHPARENT__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1040:1: ( ( 'parent' ) | ( ( rule__INSTANCEREFWITHPARENT__Group_1__0 ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==37) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1041:1: ( 'parent' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1041:1: ( 'parent' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1042:1: 'parent'
                    {
                     before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getParentKeyword_0()); 
                    match(input,37,FOLLOW_37_in_rule__INSTANCEREFWITHPARENT__Alternatives2290); 
                     after(grammarAccess.getINSTANCEREFWITHPARENTAccess().getParentKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1049:6: ( ( rule__INSTANCEREFWITHPARENT__Group_1__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1049:6: ( ( rule__INSTANCEREFWITHPARENT__Group_1__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1050:1: ( rule__INSTANCEREFWITHPARENT__Group_1__0 )
                    {
                     before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getGroup_1()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1051:1: ( rule__INSTANCEREFWITHPARENT__Group_1__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1051:2: rule__INSTANCEREFWITHPARENT__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__0_in_rule__INSTANCEREFWITHPARENT__Alternatives2309);
                    rule__INSTANCEREFWITHPARENT__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getINSTANCEREFWITHPARENTAccess().getGroup_1()); 

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
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Alternatives"


    // $ANTLR start "rule__SystemInstance__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1062:1: rule__SystemInstance__Group__0 : rule__SystemInstance__Group__0__Impl rule__SystemInstance__Group__1 ;
    public final void rule__SystemInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1066:1: ( rule__SystemInstance__Group__0__Impl rule__SystemInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1067:2: rule__SystemInstance__Group__0__Impl rule__SystemInstance__Group__1
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__0__Impl_in_rule__SystemInstance__Group__02340);
            rule__SystemInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__1_in_rule__SystemInstance__Group__02343);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1074:1: rule__SystemInstance__Group__0__Impl : ( ( rule__SystemInstance__CategoryAssignment_0 ) ) ;
    public final void rule__SystemInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1078:1: ( ( ( rule__SystemInstance__CategoryAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1079:1: ( ( rule__SystemInstance__CategoryAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1079:1: ( ( rule__SystemInstance__CategoryAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1080:1: ( rule__SystemInstance__CategoryAssignment_0 )
            {
             before(grammarAccess.getSystemInstanceAccess().getCategoryAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1081:1: ( rule__SystemInstance__CategoryAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1081:2: rule__SystemInstance__CategoryAssignment_0
            {
            pushFollow(FOLLOW_rule__SystemInstance__CategoryAssignment_0_in_rule__SystemInstance__Group__0__Impl2370);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1091:1: rule__SystemInstance__Group__1 : rule__SystemInstance__Group__1__Impl rule__SystemInstance__Group__2 ;
    public final void rule__SystemInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1095:1: ( rule__SystemInstance__Group__1__Impl rule__SystemInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1096:2: rule__SystemInstance__Group__1__Impl rule__SystemInstance__Group__2
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__1__Impl_in_rule__SystemInstance__Group__12400);
            rule__SystemInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__2_in_rule__SystemInstance__Group__12403);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1103:1: rule__SystemInstance__Group__1__Impl : ( ( rule__SystemInstance__NameAssignment_1 ) ) ;
    public final void rule__SystemInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1107:1: ( ( ( rule__SystemInstance__NameAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1108:1: ( ( rule__SystemInstance__NameAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1108:1: ( ( rule__SystemInstance__NameAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1109:1: ( rule__SystemInstance__NameAssignment_1 )
            {
             before(grammarAccess.getSystemInstanceAccess().getNameAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1110:1: ( rule__SystemInstance__NameAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1110:2: rule__SystemInstance__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SystemInstance__NameAssignment_1_in_rule__SystemInstance__Group__1__Impl2430);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1120:1: rule__SystemInstance__Group__2 : rule__SystemInstance__Group__2__Impl rule__SystemInstance__Group__3 ;
    public final void rule__SystemInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1124:1: ( rule__SystemInstance__Group__2__Impl rule__SystemInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1125:2: rule__SystemInstance__Group__2__Impl rule__SystemInstance__Group__3
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__2__Impl_in_rule__SystemInstance__Group__22460);
            rule__SystemInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__3_in_rule__SystemInstance__Group__22463);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1132:1: rule__SystemInstance__Group__2__Impl : ( ':' ) ;
    public final void rule__SystemInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1136:1: ( ( ':' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1137:1: ( ':' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1137:1: ( ':' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1138:1: ':'
            {
             before(grammarAccess.getSystemInstanceAccess().getColonKeyword_2()); 
            match(input,38,FOLLOW_38_in_rule__SystemInstance__Group__2__Impl2491); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1151:1: rule__SystemInstance__Group__3 : rule__SystemInstance__Group__3__Impl rule__SystemInstance__Group__4 ;
    public final void rule__SystemInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1155:1: ( rule__SystemInstance__Group__3__Impl rule__SystemInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1156:2: rule__SystemInstance__Group__3__Impl rule__SystemInstance__Group__4
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__3__Impl_in_rule__SystemInstance__Group__32522);
            rule__SystemInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__4_in_rule__SystemInstance__Group__32525);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1163:1: rule__SystemInstance__Group__3__Impl : ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) ) ;
    public final void rule__SystemInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1167:1: ( ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1168:1: ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1168:1: ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1169:1: ( rule__SystemInstance__ComponentImplementationAssignment_3 )
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentImplementationAssignment_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1170:1: ( rule__SystemInstance__ComponentImplementationAssignment_3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1170:2: rule__SystemInstance__ComponentImplementationAssignment_3
            {
            pushFollow(FOLLOW_rule__SystemInstance__ComponentImplementationAssignment_3_in_rule__SystemInstance__Group__3__Impl2552);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1180:1: rule__SystemInstance__Group__4 : rule__SystemInstance__Group__4__Impl rule__SystemInstance__Group__5 ;
    public final void rule__SystemInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1184:1: ( rule__SystemInstance__Group__4__Impl rule__SystemInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1185:2: rule__SystemInstance__Group__4__Impl rule__SystemInstance__Group__5
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__4__Impl_in_rule__SystemInstance__Group__42582);
            rule__SystemInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__5_in_rule__SystemInstance__Group__42585);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1192:1: rule__SystemInstance__Group__4__Impl : ( '{' ) ;
    public final void rule__SystemInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1196:1: ( ( '{' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1197:1: ( '{' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1197:1: ( '{' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1198:1: '{'
            {
             before(grammarAccess.getSystemInstanceAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,39,FOLLOW_39_in_rule__SystemInstance__Group__4__Impl2613); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1211:1: rule__SystemInstance__Group__5 : rule__SystemInstance__Group__5__Impl rule__SystemInstance__Group__6 ;
    public final void rule__SystemInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1215:1: ( rule__SystemInstance__Group__5__Impl rule__SystemInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1216:2: rule__SystemInstance__Group__5__Impl rule__SystemInstance__Group__6
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__5__Impl_in_rule__SystemInstance__Group__52644);
            rule__SystemInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__6_in_rule__SystemInstance__Group__52647);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1223:1: rule__SystemInstance__Group__5__Impl : ( ( rule__SystemInstance__Alternatives_5 )* ) ;
    public final void rule__SystemInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1227:1: ( ( ( rule__SystemInstance__Alternatives_5 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1228:1: ( ( rule__SystemInstance__Alternatives_5 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1228:1: ( ( rule__SystemInstance__Alternatives_5 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1229:1: ( rule__SystemInstance__Alternatives_5 )*
            {
             before(grammarAccess.getSystemInstanceAccess().getAlternatives_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1230:1: ( rule__SystemInstance__Alternatives_5 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=10 && LA13_0<=11)||(LA13_0>=21 && LA13_0<=36)||(LA13_0>=49 && LA13_0<=50)||LA13_0==52||LA13_0==55) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1230:2: rule__SystemInstance__Alternatives_5
            	    {
            	    pushFollow(FOLLOW_rule__SystemInstance__Alternatives_5_in_rule__SystemInstance__Group__5__Impl2674);
            	    rule__SystemInstance__Alternatives_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1240:1: rule__SystemInstance__Group__6 : rule__SystemInstance__Group__6__Impl ;
    public final void rule__SystemInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1244:1: ( rule__SystemInstance__Group__6__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1245:2: rule__SystemInstance__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__6__Impl_in_rule__SystemInstance__Group__62705);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1251:1: rule__SystemInstance__Group__6__Impl : ( '}' ) ;
    public final void rule__SystemInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1255:1: ( ( '}' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1256:1: ( '}' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1256:1: ( '}' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1257:1: '}'
            {
             before(grammarAccess.getSystemInstanceAccess().getRightCurlyBracketKeyword_6()); 
            match(input,40,FOLLOW_40_in_rule__SystemInstance__Group__6__Impl2733); 
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


    // $ANTLR start "rule__FeatureInstance__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1284:1: rule__FeatureInstance__Group__0 : rule__FeatureInstance__Group__0__Impl rule__FeatureInstance__Group__1 ;
    public final void rule__FeatureInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1288:1: ( rule__FeatureInstance__Group__0__Impl rule__FeatureInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1289:2: rule__FeatureInstance__Group__0__Impl rule__FeatureInstance__Group__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__0__Impl_in_rule__FeatureInstance__Group__02778);
            rule__FeatureInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__1_in_rule__FeatureInstance__Group__02781);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1296:1: rule__FeatureInstance__Group__0__Impl : ( ( rule__FeatureInstance__DirectionAssignment_0 ) ) ;
    public final void rule__FeatureInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1300:1: ( ( ( rule__FeatureInstance__DirectionAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1301:1: ( ( rule__FeatureInstance__DirectionAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1301:1: ( ( rule__FeatureInstance__DirectionAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1302:1: ( rule__FeatureInstance__DirectionAssignment_0 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getDirectionAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1303:1: ( rule__FeatureInstance__DirectionAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1303:2: rule__FeatureInstance__DirectionAssignment_0
            {
            pushFollow(FOLLOW_rule__FeatureInstance__DirectionAssignment_0_in_rule__FeatureInstance__Group__0__Impl2808);
            rule__FeatureInstance__DirectionAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getFeatureInstanceAccess().getDirectionAssignment_0()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1313:1: rule__FeatureInstance__Group__1 : rule__FeatureInstance__Group__1__Impl rule__FeatureInstance__Group__2 ;
    public final void rule__FeatureInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1317:1: ( rule__FeatureInstance__Group__1__Impl rule__FeatureInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1318:2: rule__FeatureInstance__Group__1__Impl rule__FeatureInstance__Group__2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__1__Impl_in_rule__FeatureInstance__Group__12838);
            rule__FeatureInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__2_in_rule__FeatureInstance__Group__12841);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1325:1: rule__FeatureInstance__Group__1__Impl : ( ( rule__FeatureInstance__CategoryAssignment_1 ) ) ;
    public final void rule__FeatureInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1329:1: ( ( ( rule__FeatureInstance__CategoryAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1330:1: ( ( rule__FeatureInstance__CategoryAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1330:1: ( ( rule__FeatureInstance__CategoryAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1331:1: ( rule__FeatureInstance__CategoryAssignment_1 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getCategoryAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1332:1: ( rule__FeatureInstance__CategoryAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1332:2: rule__FeatureInstance__CategoryAssignment_1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__CategoryAssignment_1_in_rule__FeatureInstance__Group__1__Impl2868);
            rule__FeatureInstance__CategoryAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFeatureInstanceAccess().getCategoryAssignment_1()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1342:1: rule__FeatureInstance__Group__2 : rule__FeatureInstance__Group__2__Impl rule__FeatureInstance__Group__3 ;
    public final void rule__FeatureInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1346:1: ( rule__FeatureInstance__Group__2__Impl rule__FeatureInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1347:2: rule__FeatureInstance__Group__2__Impl rule__FeatureInstance__Group__3
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__2__Impl_in_rule__FeatureInstance__Group__22898);
            rule__FeatureInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__3_in_rule__FeatureInstance__Group__22901);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1354:1: rule__FeatureInstance__Group__2__Impl : ( ( rule__FeatureInstance__NameAssignment_2 ) ) ;
    public final void rule__FeatureInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1358:1: ( ( ( rule__FeatureInstance__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1359:1: ( ( rule__FeatureInstance__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1359:1: ( ( rule__FeatureInstance__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1360:1: ( rule__FeatureInstance__NameAssignment_2 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1361:1: ( rule__FeatureInstance__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1361:2: rule__FeatureInstance__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__NameAssignment_2_in_rule__FeatureInstance__Group__2__Impl2928);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1371:1: rule__FeatureInstance__Group__3 : rule__FeatureInstance__Group__3__Impl rule__FeatureInstance__Group__4 ;
    public final void rule__FeatureInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1375:1: ( rule__FeatureInstance__Group__3__Impl rule__FeatureInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1376:2: rule__FeatureInstance__Group__3__Impl rule__FeatureInstance__Group__4
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__3__Impl_in_rule__FeatureInstance__Group__32958);
            rule__FeatureInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__4_in_rule__FeatureInstance__Group__32961);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1383:1: rule__FeatureInstance__Group__3__Impl : ( ( rule__FeatureInstance__Group_3__0 )? ) ;
    public final void rule__FeatureInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1387:1: ( ( ( rule__FeatureInstance__Group_3__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1388:1: ( ( rule__FeatureInstance__Group_3__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1388:1: ( ( rule__FeatureInstance__Group_3__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1389:1: ( rule__FeatureInstance__Group_3__0 )?
            {
             before(grammarAccess.getFeatureInstanceAccess().getGroup_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1390:1: ( rule__FeatureInstance__Group_3__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==41) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1390:2: rule__FeatureInstance__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__FeatureInstance__Group_3__0_in_rule__FeatureInstance__Group__3__Impl2988);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1400:1: rule__FeatureInstance__Group__4 : rule__FeatureInstance__Group__4__Impl rule__FeatureInstance__Group__5 ;
    public final void rule__FeatureInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1404:1: ( rule__FeatureInstance__Group__4__Impl rule__FeatureInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1405:2: rule__FeatureInstance__Group__4__Impl rule__FeatureInstance__Group__5
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__4__Impl_in_rule__FeatureInstance__Group__43019);
            rule__FeatureInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__5_in_rule__FeatureInstance__Group__43022);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1412:1: rule__FeatureInstance__Group__4__Impl : ( ':' ) ;
    public final void rule__FeatureInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1416:1: ( ( ':' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1417:1: ( ':' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1417:1: ( ':' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1418:1: ':'
            {
             before(grammarAccess.getFeatureInstanceAccess().getColonKeyword_4()); 
            match(input,38,FOLLOW_38_in_rule__FeatureInstance__Group__4__Impl3050); 
             after(grammarAccess.getFeatureInstanceAccess().getColonKeyword_4()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1431:1: rule__FeatureInstance__Group__5 : rule__FeatureInstance__Group__5__Impl rule__FeatureInstance__Group__6 ;
    public final void rule__FeatureInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1435:1: ( rule__FeatureInstance__Group__5__Impl rule__FeatureInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1436:2: rule__FeatureInstance__Group__5__Impl rule__FeatureInstance__Group__6
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__5__Impl_in_rule__FeatureInstance__Group__53081);
            rule__FeatureInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__6_in_rule__FeatureInstance__Group__53084);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1443:1: rule__FeatureInstance__Group__5__Impl : ( ( rule__FeatureInstance__FeatureAssignment_5 ) ) ;
    public final void rule__FeatureInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1447:1: ( ( ( rule__FeatureInstance__FeatureAssignment_5 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1448:1: ( ( rule__FeatureInstance__FeatureAssignment_5 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1448:1: ( ( rule__FeatureInstance__FeatureAssignment_5 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1449:1: ( rule__FeatureInstance__FeatureAssignment_5 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1450:1: ( rule__FeatureInstance__FeatureAssignment_5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1450:2: rule__FeatureInstance__FeatureAssignment_5
            {
            pushFollow(FOLLOW_rule__FeatureInstance__FeatureAssignment_5_in_rule__FeatureInstance__Group__5__Impl3111);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1460:1: rule__FeatureInstance__Group__6 : rule__FeatureInstance__Group__6__Impl rule__FeatureInstance__Group__7 ;
    public final void rule__FeatureInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1464:1: ( rule__FeatureInstance__Group__6__Impl rule__FeatureInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1465:2: rule__FeatureInstance__Group__6__Impl rule__FeatureInstance__Group__7
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__6__Impl_in_rule__FeatureInstance__Group__63141);
            rule__FeatureInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__7_in_rule__FeatureInstance__Group__63144);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1472:1: rule__FeatureInstance__Group__6__Impl : ( ( rule__FeatureInstance__Group_6__0 )? ) ;
    public final void rule__FeatureInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1476:1: ( ( ( rule__FeatureInstance__Group_6__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1477:1: ( ( rule__FeatureInstance__Group_6__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1477:1: ( ( rule__FeatureInstance__Group_6__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1478:1: ( rule__FeatureInstance__Group_6__0 )?
            {
             before(grammarAccess.getFeatureInstanceAccess().getGroup_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1479:1: ( rule__FeatureInstance__Group_6__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==43) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1479:2: rule__FeatureInstance__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__FeatureInstance__Group_6__0_in_rule__FeatureInstance__Group__6__Impl3171);
                    rule__FeatureInstance__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFeatureInstanceAccess().getGroup_6()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1489:1: rule__FeatureInstance__Group__7 : rule__FeatureInstance__Group__7__Impl rule__FeatureInstance__Group__8 ;
    public final void rule__FeatureInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1493:1: ( rule__FeatureInstance__Group__7__Impl rule__FeatureInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1494:2: rule__FeatureInstance__Group__7__Impl rule__FeatureInstance__Group__8
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__7__Impl_in_rule__FeatureInstance__Group__73202);
            rule__FeatureInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__8_in_rule__FeatureInstance__Group__73205);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1501:1: rule__FeatureInstance__Group__7__Impl : ( ( rule__FeatureInstance__Group_7__0 )? ) ;
    public final void rule__FeatureInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1505:1: ( ( ( rule__FeatureInstance__Group_7__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1506:1: ( ( rule__FeatureInstance__Group_7__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1506:1: ( ( rule__FeatureInstance__Group_7__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1507:1: ( rule__FeatureInstance__Group_7__0 )?
            {
             before(grammarAccess.getFeatureInstanceAccess().getGroup_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1508:1: ( rule__FeatureInstance__Group_7__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==48) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1508:2: rule__FeatureInstance__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__FeatureInstance__Group_7__0_in_rule__FeatureInstance__Group__7__Impl3232);
                    rule__FeatureInstance__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFeatureInstanceAccess().getGroup_7()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1518:1: rule__FeatureInstance__Group__8 : rule__FeatureInstance__Group__8__Impl ;
    public final void rule__FeatureInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1522:1: ( rule__FeatureInstance__Group__8__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1523:2: rule__FeatureInstance__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__8__Impl_in_rule__FeatureInstance__Group__83263);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1529:1: rule__FeatureInstance__Group__8__Impl : ( ( rule__FeatureInstance__Group_8__0 )? ) ;
    public final void rule__FeatureInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1533:1: ( ( ( rule__FeatureInstance__Group_8__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1534:1: ( ( rule__FeatureInstance__Group_8__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1534:1: ( ( rule__FeatureInstance__Group_8__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1535:1: ( rule__FeatureInstance__Group_8__0 )?
            {
             before(grammarAccess.getFeatureInstanceAccess().getGroup_8()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1536:1: ( rule__FeatureInstance__Group_8__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==39) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1536:2: rule__FeatureInstance__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__FeatureInstance__Group_8__0_in_rule__FeatureInstance__Group__8__Impl3290);
                    rule__FeatureInstance__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFeatureInstanceAccess().getGroup_8()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1564:1: rule__FeatureInstance__Group_3__0 : rule__FeatureInstance__Group_3__0__Impl rule__FeatureInstance__Group_3__1 ;
    public final void rule__FeatureInstance__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1568:1: ( rule__FeatureInstance__Group_3__0__Impl rule__FeatureInstance__Group_3__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1569:2: rule__FeatureInstance__Group_3__0__Impl rule__FeatureInstance__Group_3__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__0__Impl_in_rule__FeatureInstance__Group_3__03339);
            rule__FeatureInstance__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__1_in_rule__FeatureInstance__Group_3__03342);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1576:1: rule__FeatureInstance__Group_3__0__Impl : ( '[' ) ;
    public final void rule__FeatureInstance__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1580:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1581:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1581:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1582:1: '['
            {
             before(grammarAccess.getFeatureInstanceAccess().getLeftSquareBracketKeyword_3_0()); 
            match(input,41,FOLLOW_41_in_rule__FeatureInstance__Group_3__0__Impl3370); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1595:1: rule__FeatureInstance__Group_3__1 : rule__FeatureInstance__Group_3__1__Impl rule__FeatureInstance__Group_3__2 ;
    public final void rule__FeatureInstance__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1599:1: ( rule__FeatureInstance__Group_3__1__Impl rule__FeatureInstance__Group_3__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1600:2: rule__FeatureInstance__Group_3__1__Impl rule__FeatureInstance__Group_3__2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__1__Impl_in_rule__FeatureInstance__Group_3__13401);
            rule__FeatureInstance__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__2_in_rule__FeatureInstance__Group_3__13404);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1607:1: rule__FeatureInstance__Group_3__1__Impl : ( ( rule__FeatureInstance__IndexAssignment_3_1 ) ) ;
    public final void rule__FeatureInstance__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1611:1: ( ( ( rule__FeatureInstance__IndexAssignment_3_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1612:1: ( ( rule__FeatureInstance__IndexAssignment_3_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1612:1: ( ( rule__FeatureInstance__IndexAssignment_3_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1613:1: ( rule__FeatureInstance__IndexAssignment_3_1 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getIndexAssignment_3_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1614:1: ( rule__FeatureInstance__IndexAssignment_3_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1614:2: rule__FeatureInstance__IndexAssignment_3_1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__IndexAssignment_3_1_in_rule__FeatureInstance__Group_3__1__Impl3431);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1624:1: rule__FeatureInstance__Group_3__2 : rule__FeatureInstance__Group_3__2__Impl ;
    public final void rule__FeatureInstance__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1628:1: ( rule__FeatureInstance__Group_3__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1629:2: rule__FeatureInstance__Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__2__Impl_in_rule__FeatureInstance__Group_3__23461);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1635:1: rule__FeatureInstance__Group_3__2__Impl : ( ']' ) ;
    public final void rule__FeatureInstance__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1639:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1640:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1640:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1641:1: ']'
            {
             before(grammarAccess.getFeatureInstanceAccess().getRightSquareBracketKeyword_3_2()); 
            match(input,42,FOLLOW_42_in_rule__FeatureInstance__Group_3__2__Impl3489); 
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


    // $ANTLR start "rule__FeatureInstance__Group_6__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1660:1: rule__FeatureInstance__Group_6__0 : rule__FeatureInstance__Group_6__0__Impl rule__FeatureInstance__Group_6__1 ;
    public final void rule__FeatureInstance__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1664:1: ( rule__FeatureInstance__Group_6__0__Impl rule__FeatureInstance__Group_6__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1665:2: rule__FeatureInstance__Group_6__0__Impl rule__FeatureInstance__Group_6__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__0__Impl_in_rule__FeatureInstance__Group_6__03526);
            rule__FeatureInstance__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__1_in_rule__FeatureInstance__Group_6__03529);
            rule__FeatureInstance__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_6__0"


    // $ANTLR start "rule__FeatureInstance__Group_6__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1672:1: rule__FeatureInstance__Group_6__0__Impl : ( 'source' ) ;
    public final void rule__FeatureInstance__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1676:1: ( ( 'source' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1677:1: ( 'source' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1677:1: ( 'source' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1678:1: 'source'
            {
             before(grammarAccess.getFeatureInstanceAccess().getSourceKeyword_6_0()); 
            match(input,43,FOLLOW_43_in_rule__FeatureInstance__Group_6__0__Impl3557); 
             after(grammarAccess.getFeatureInstanceAccess().getSourceKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_6__0__Impl"


    // $ANTLR start "rule__FeatureInstance__Group_6__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1691:1: rule__FeatureInstance__Group_6__1 : rule__FeatureInstance__Group_6__1__Impl rule__FeatureInstance__Group_6__2 ;
    public final void rule__FeatureInstance__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1695:1: ( rule__FeatureInstance__Group_6__1__Impl rule__FeatureInstance__Group_6__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1696:2: rule__FeatureInstance__Group_6__1__Impl rule__FeatureInstance__Group_6__2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__1__Impl_in_rule__FeatureInstance__Group_6__13588);
            rule__FeatureInstance__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__2_in_rule__FeatureInstance__Group_6__13591);
            rule__FeatureInstance__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_6__1"


    // $ANTLR start "rule__FeatureInstance__Group_6__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1703:1: rule__FeatureInstance__Group_6__1__Impl : ( 'of' ) ;
    public final void rule__FeatureInstance__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1707:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1708:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1708:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1709:1: 'of'
            {
             before(grammarAccess.getFeatureInstanceAccess().getOfKeyword_6_1()); 
            match(input,44,FOLLOW_44_in_rule__FeatureInstance__Group_6__1__Impl3619); 
             after(grammarAccess.getFeatureInstanceAccess().getOfKeyword_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_6__1__Impl"


    // $ANTLR start "rule__FeatureInstance__Group_6__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1722:1: rule__FeatureInstance__Group_6__2 : rule__FeatureInstance__Group_6__2__Impl rule__FeatureInstance__Group_6__3 ;
    public final void rule__FeatureInstance__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1726:1: ( rule__FeatureInstance__Group_6__2__Impl rule__FeatureInstance__Group_6__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1727:2: rule__FeatureInstance__Group_6__2__Impl rule__FeatureInstance__Group_6__3
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__2__Impl_in_rule__FeatureInstance__Group_6__23650);
            rule__FeatureInstance__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__3_in_rule__FeatureInstance__Group_6__23653);
            rule__FeatureInstance__Group_6__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_6__2"


    // $ANTLR start "rule__FeatureInstance__Group_6__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1734:1: rule__FeatureInstance__Group_6__2__Impl : ( '(' ) ;
    public final void rule__FeatureInstance__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1738:1: ( ( '(' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1739:1: ( '(' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1739:1: ( '(' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1740:1: '('
            {
             before(grammarAccess.getFeatureInstanceAccess().getLeftParenthesisKeyword_6_2()); 
            match(input,45,FOLLOW_45_in_rule__FeatureInstance__Group_6__2__Impl3681); 
             after(grammarAccess.getFeatureInstanceAccess().getLeftParenthesisKeyword_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_6__2__Impl"


    // $ANTLR start "rule__FeatureInstance__Group_6__3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1753:1: rule__FeatureInstance__Group_6__3 : rule__FeatureInstance__Group_6__3__Impl rule__FeatureInstance__Group_6__4 ;
    public final void rule__FeatureInstance__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1757:1: ( rule__FeatureInstance__Group_6__3__Impl rule__FeatureInstance__Group_6__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1758:2: rule__FeatureInstance__Group_6__3__Impl rule__FeatureInstance__Group_6__4
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__3__Impl_in_rule__FeatureInstance__Group_6__33712);
            rule__FeatureInstance__Group_6__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__4_in_rule__FeatureInstance__Group_6__33715);
            rule__FeatureInstance__Group_6__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_6__3"


    // $ANTLR start "rule__FeatureInstance__Group_6__3__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1765:1: rule__FeatureInstance__Group_6__3__Impl : ( ( rule__FeatureInstance__Alternatives_6_3 ) ) ;
    public final void rule__FeatureInstance__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1769:1: ( ( ( rule__FeatureInstance__Alternatives_6_3 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1770:1: ( ( rule__FeatureInstance__Alternatives_6_3 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1770:1: ( ( rule__FeatureInstance__Alternatives_6_3 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1771:1: ( rule__FeatureInstance__Alternatives_6_3 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getAlternatives_6_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1772:1: ( rule__FeatureInstance__Alternatives_6_3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1772:2: rule__FeatureInstance__Alternatives_6_3
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Alternatives_6_3_in_rule__FeatureInstance__Group_6__3__Impl3742);
            rule__FeatureInstance__Alternatives_6_3();

            state._fsp--;


            }

             after(grammarAccess.getFeatureInstanceAccess().getAlternatives_6_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_6__3__Impl"


    // $ANTLR start "rule__FeatureInstance__Group_6__4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1782:1: rule__FeatureInstance__Group_6__4 : rule__FeatureInstance__Group_6__4__Impl rule__FeatureInstance__Group_6__5 ;
    public final void rule__FeatureInstance__Group_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1786:1: ( rule__FeatureInstance__Group_6__4__Impl rule__FeatureInstance__Group_6__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1787:2: rule__FeatureInstance__Group_6__4__Impl rule__FeatureInstance__Group_6__5
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__4__Impl_in_rule__FeatureInstance__Group_6__43772);
            rule__FeatureInstance__Group_6__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__5_in_rule__FeatureInstance__Group_6__43775);
            rule__FeatureInstance__Group_6__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_6__4"


    // $ANTLR start "rule__FeatureInstance__Group_6__4__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1794:1: rule__FeatureInstance__Group_6__4__Impl : ( ( rule__FeatureInstance__Group_6_4__0 )* ) ;
    public final void rule__FeatureInstance__Group_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1798:1: ( ( ( rule__FeatureInstance__Group_6_4__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1799:1: ( ( rule__FeatureInstance__Group_6_4__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1799:1: ( ( rule__FeatureInstance__Group_6_4__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1800:1: ( rule__FeatureInstance__Group_6_4__0 )*
            {
             before(grammarAccess.getFeatureInstanceAccess().getGroup_6_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1801:1: ( rule__FeatureInstance__Group_6_4__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==47) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1801:2: rule__FeatureInstance__Group_6_4__0
            	    {
            	    pushFollow(FOLLOW_rule__FeatureInstance__Group_6_4__0_in_rule__FeatureInstance__Group_6__4__Impl3802);
            	    rule__FeatureInstance__Group_6_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getFeatureInstanceAccess().getGroup_6_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_6__4__Impl"


    // $ANTLR start "rule__FeatureInstance__Group_6__5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1811:1: rule__FeatureInstance__Group_6__5 : rule__FeatureInstance__Group_6__5__Impl ;
    public final void rule__FeatureInstance__Group_6__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1815:1: ( rule__FeatureInstance__Group_6__5__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1816:2: rule__FeatureInstance__Group_6__5__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__5__Impl_in_rule__FeatureInstance__Group_6__53833);
            rule__FeatureInstance__Group_6__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_6__5"


    // $ANTLR start "rule__FeatureInstance__Group_6__5__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1822:1: rule__FeatureInstance__Group_6__5__Impl : ( ')' ) ;
    public final void rule__FeatureInstance__Group_6__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1826:1: ( ( ')' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1827:1: ( ')' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1827:1: ( ')' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1828:1: ')'
            {
             before(grammarAccess.getFeatureInstanceAccess().getRightParenthesisKeyword_6_5()); 
            match(input,46,FOLLOW_46_in_rule__FeatureInstance__Group_6__5__Impl3861); 
             after(grammarAccess.getFeatureInstanceAccess().getRightParenthesisKeyword_6_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_6__5__Impl"


    // $ANTLR start "rule__FeatureInstance__Group_6_4__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1853:1: rule__FeatureInstance__Group_6_4__0 : rule__FeatureInstance__Group_6_4__0__Impl rule__FeatureInstance__Group_6_4__1 ;
    public final void rule__FeatureInstance__Group_6_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1857:1: ( rule__FeatureInstance__Group_6_4__0__Impl rule__FeatureInstance__Group_6_4__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1858:2: rule__FeatureInstance__Group_6_4__0__Impl rule__FeatureInstance__Group_6_4__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_6_4__0__Impl_in_rule__FeatureInstance__Group_6_4__03904);
            rule__FeatureInstance__Group_6_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_6_4__1_in_rule__FeatureInstance__Group_6_4__03907);
            rule__FeatureInstance__Group_6_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_6_4__0"


    // $ANTLR start "rule__FeatureInstance__Group_6_4__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1865:1: rule__FeatureInstance__Group_6_4__0__Impl : ( ',' ) ;
    public final void rule__FeatureInstance__Group_6_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1869:1: ( ( ',' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1870:1: ( ',' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1870:1: ( ',' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1871:1: ','
            {
             before(grammarAccess.getFeatureInstanceAccess().getCommaKeyword_6_4_0()); 
            match(input,47,FOLLOW_47_in_rule__FeatureInstance__Group_6_4__0__Impl3935); 
             after(grammarAccess.getFeatureInstanceAccess().getCommaKeyword_6_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_6_4__0__Impl"


    // $ANTLR start "rule__FeatureInstance__Group_6_4__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1884:1: rule__FeatureInstance__Group_6_4__1 : rule__FeatureInstance__Group_6_4__1__Impl ;
    public final void rule__FeatureInstance__Group_6_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1888:1: ( rule__FeatureInstance__Group_6_4__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1889:2: rule__FeatureInstance__Group_6_4__1__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_6_4__1__Impl_in_rule__FeatureInstance__Group_6_4__13966);
            rule__FeatureInstance__Group_6_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_6_4__1"


    // $ANTLR start "rule__FeatureInstance__Group_6_4__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1895:1: rule__FeatureInstance__Group_6_4__1__Impl : ( ( rule__FeatureInstance__Alternatives_6_4_1 ) ) ;
    public final void rule__FeatureInstance__Group_6_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1899:1: ( ( ( rule__FeatureInstance__Alternatives_6_4_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1900:1: ( ( rule__FeatureInstance__Alternatives_6_4_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1900:1: ( ( rule__FeatureInstance__Alternatives_6_4_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1901:1: ( rule__FeatureInstance__Alternatives_6_4_1 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getAlternatives_6_4_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1902:1: ( rule__FeatureInstance__Alternatives_6_4_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1902:2: rule__FeatureInstance__Alternatives_6_4_1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Alternatives_6_4_1_in_rule__FeatureInstance__Group_6_4__1__Impl3993);
            rule__FeatureInstance__Alternatives_6_4_1();

            state._fsp--;


            }

             after(grammarAccess.getFeatureInstanceAccess().getAlternatives_6_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_6_4__1__Impl"


    // $ANTLR start "rule__FeatureInstance__Group_7__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1916:1: rule__FeatureInstance__Group_7__0 : rule__FeatureInstance__Group_7__0__Impl rule__FeatureInstance__Group_7__1 ;
    public final void rule__FeatureInstance__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1920:1: ( rule__FeatureInstance__Group_7__0__Impl rule__FeatureInstance__Group_7__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1921:2: rule__FeatureInstance__Group_7__0__Impl rule__FeatureInstance__Group_7__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_7__0__Impl_in_rule__FeatureInstance__Group_7__04027);
            rule__FeatureInstance__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_7__1_in_rule__FeatureInstance__Group_7__04030);
            rule__FeatureInstance__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_7__0"


    // $ANTLR start "rule__FeatureInstance__Group_7__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1928:1: rule__FeatureInstance__Group_7__0__Impl : ( 'destination' ) ;
    public final void rule__FeatureInstance__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1932:1: ( ( 'destination' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1933:1: ( 'destination' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1933:1: ( 'destination' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1934:1: 'destination'
            {
             before(grammarAccess.getFeatureInstanceAccess().getDestinationKeyword_7_0()); 
            match(input,48,FOLLOW_48_in_rule__FeatureInstance__Group_7__0__Impl4058); 
             after(grammarAccess.getFeatureInstanceAccess().getDestinationKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_7__0__Impl"


    // $ANTLR start "rule__FeatureInstance__Group_7__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1947:1: rule__FeatureInstance__Group_7__1 : rule__FeatureInstance__Group_7__1__Impl rule__FeatureInstance__Group_7__2 ;
    public final void rule__FeatureInstance__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1951:1: ( rule__FeatureInstance__Group_7__1__Impl rule__FeatureInstance__Group_7__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1952:2: rule__FeatureInstance__Group_7__1__Impl rule__FeatureInstance__Group_7__2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_7__1__Impl_in_rule__FeatureInstance__Group_7__14089);
            rule__FeatureInstance__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_7__2_in_rule__FeatureInstance__Group_7__14092);
            rule__FeatureInstance__Group_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_7__1"


    // $ANTLR start "rule__FeatureInstance__Group_7__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1959:1: rule__FeatureInstance__Group_7__1__Impl : ( 'of' ) ;
    public final void rule__FeatureInstance__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1963:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1964:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1964:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1965:1: 'of'
            {
             before(grammarAccess.getFeatureInstanceAccess().getOfKeyword_7_1()); 
            match(input,44,FOLLOW_44_in_rule__FeatureInstance__Group_7__1__Impl4120); 
             after(grammarAccess.getFeatureInstanceAccess().getOfKeyword_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_7__1__Impl"


    // $ANTLR start "rule__FeatureInstance__Group_7__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1978:1: rule__FeatureInstance__Group_7__2 : rule__FeatureInstance__Group_7__2__Impl rule__FeatureInstance__Group_7__3 ;
    public final void rule__FeatureInstance__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1982:1: ( rule__FeatureInstance__Group_7__2__Impl rule__FeatureInstance__Group_7__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1983:2: rule__FeatureInstance__Group_7__2__Impl rule__FeatureInstance__Group_7__3
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_7__2__Impl_in_rule__FeatureInstance__Group_7__24151);
            rule__FeatureInstance__Group_7__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_7__3_in_rule__FeatureInstance__Group_7__24154);
            rule__FeatureInstance__Group_7__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_7__2"


    // $ANTLR start "rule__FeatureInstance__Group_7__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1990:1: rule__FeatureInstance__Group_7__2__Impl : ( '(' ) ;
    public final void rule__FeatureInstance__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1994:1: ( ( '(' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1995:1: ( '(' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1995:1: ( '(' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1996:1: '('
            {
             before(grammarAccess.getFeatureInstanceAccess().getLeftParenthesisKeyword_7_2()); 
            match(input,45,FOLLOW_45_in_rule__FeatureInstance__Group_7__2__Impl4182); 
             after(grammarAccess.getFeatureInstanceAccess().getLeftParenthesisKeyword_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_7__2__Impl"


    // $ANTLR start "rule__FeatureInstance__Group_7__3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2009:1: rule__FeatureInstance__Group_7__3 : rule__FeatureInstance__Group_7__3__Impl rule__FeatureInstance__Group_7__4 ;
    public final void rule__FeatureInstance__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2013:1: ( rule__FeatureInstance__Group_7__3__Impl rule__FeatureInstance__Group_7__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2014:2: rule__FeatureInstance__Group_7__3__Impl rule__FeatureInstance__Group_7__4
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_7__3__Impl_in_rule__FeatureInstance__Group_7__34213);
            rule__FeatureInstance__Group_7__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_7__4_in_rule__FeatureInstance__Group_7__34216);
            rule__FeatureInstance__Group_7__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_7__3"


    // $ANTLR start "rule__FeatureInstance__Group_7__3__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2021:1: rule__FeatureInstance__Group_7__3__Impl : ( ( rule__FeatureInstance__Alternatives_7_3 ) ) ;
    public final void rule__FeatureInstance__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2025:1: ( ( ( rule__FeatureInstance__Alternatives_7_3 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2026:1: ( ( rule__FeatureInstance__Alternatives_7_3 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2026:1: ( ( rule__FeatureInstance__Alternatives_7_3 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2027:1: ( rule__FeatureInstance__Alternatives_7_3 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getAlternatives_7_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2028:1: ( rule__FeatureInstance__Alternatives_7_3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2028:2: rule__FeatureInstance__Alternatives_7_3
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Alternatives_7_3_in_rule__FeatureInstance__Group_7__3__Impl4243);
            rule__FeatureInstance__Alternatives_7_3();

            state._fsp--;


            }

             after(grammarAccess.getFeatureInstanceAccess().getAlternatives_7_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_7__3__Impl"


    // $ANTLR start "rule__FeatureInstance__Group_7__4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2038:1: rule__FeatureInstance__Group_7__4 : rule__FeatureInstance__Group_7__4__Impl rule__FeatureInstance__Group_7__5 ;
    public final void rule__FeatureInstance__Group_7__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2042:1: ( rule__FeatureInstance__Group_7__4__Impl rule__FeatureInstance__Group_7__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2043:2: rule__FeatureInstance__Group_7__4__Impl rule__FeatureInstance__Group_7__5
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_7__4__Impl_in_rule__FeatureInstance__Group_7__44273);
            rule__FeatureInstance__Group_7__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_7__5_in_rule__FeatureInstance__Group_7__44276);
            rule__FeatureInstance__Group_7__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_7__4"


    // $ANTLR start "rule__FeatureInstance__Group_7__4__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2050:1: rule__FeatureInstance__Group_7__4__Impl : ( ( rule__FeatureInstance__Group_7_4__0 )* ) ;
    public final void rule__FeatureInstance__Group_7__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2054:1: ( ( ( rule__FeatureInstance__Group_7_4__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2055:1: ( ( rule__FeatureInstance__Group_7_4__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2055:1: ( ( rule__FeatureInstance__Group_7_4__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2056:1: ( rule__FeatureInstance__Group_7_4__0 )*
            {
             before(grammarAccess.getFeatureInstanceAccess().getGroup_7_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2057:1: ( rule__FeatureInstance__Group_7_4__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==47) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2057:2: rule__FeatureInstance__Group_7_4__0
            	    {
            	    pushFollow(FOLLOW_rule__FeatureInstance__Group_7_4__0_in_rule__FeatureInstance__Group_7__4__Impl4303);
            	    rule__FeatureInstance__Group_7_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getFeatureInstanceAccess().getGroup_7_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_7__4__Impl"


    // $ANTLR start "rule__FeatureInstance__Group_7__5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2067:1: rule__FeatureInstance__Group_7__5 : rule__FeatureInstance__Group_7__5__Impl ;
    public final void rule__FeatureInstance__Group_7__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2071:1: ( rule__FeatureInstance__Group_7__5__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2072:2: rule__FeatureInstance__Group_7__5__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_7__5__Impl_in_rule__FeatureInstance__Group_7__54334);
            rule__FeatureInstance__Group_7__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_7__5"


    // $ANTLR start "rule__FeatureInstance__Group_7__5__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2078:1: rule__FeatureInstance__Group_7__5__Impl : ( ')' ) ;
    public final void rule__FeatureInstance__Group_7__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2082:1: ( ( ')' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2083:1: ( ')' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2083:1: ( ')' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2084:1: ')'
            {
             before(grammarAccess.getFeatureInstanceAccess().getRightParenthesisKeyword_7_5()); 
            match(input,46,FOLLOW_46_in_rule__FeatureInstance__Group_7__5__Impl4362); 
             after(grammarAccess.getFeatureInstanceAccess().getRightParenthesisKeyword_7_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_7__5__Impl"


    // $ANTLR start "rule__FeatureInstance__Group_7_4__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2109:1: rule__FeatureInstance__Group_7_4__0 : rule__FeatureInstance__Group_7_4__0__Impl rule__FeatureInstance__Group_7_4__1 ;
    public final void rule__FeatureInstance__Group_7_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2113:1: ( rule__FeatureInstance__Group_7_4__0__Impl rule__FeatureInstance__Group_7_4__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2114:2: rule__FeatureInstance__Group_7_4__0__Impl rule__FeatureInstance__Group_7_4__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_7_4__0__Impl_in_rule__FeatureInstance__Group_7_4__04405);
            rule__FeatureInstance__Group_7_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_7_4__1_in_rule__FeatureInstance__Group_7_4__04408);
            rule__FeatureInstance__Group_7_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_7_4__0"


    // $ANTLR start "rule__FeatureInstance__Group_7_4__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2121:1: rule__FeatureInstance__Group_7_4__0__Impl : ( ',' ) ;
    public final void rule__FeatureInstance__Group_7_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2125:1: ( ( ',' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2126:1: ( ',' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2126:1: ( ',' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2127:1: ','
            {
             before(grammarAccess.getFeatureInstanceAccess().getCommaKeyword_7_4_0()); 
            match(input,47,FOLLOW_47_in_rule__FeatureInstance__Group_7_4__0__Impl4436); 
             after(grammarAccess.getFeatureInstanceAccess().getCommaKeyword_7_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_7_4__0__Impl"


    // $ANTLR start "rule__FeatureInstance__Group_7_4__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2140:1: rule__FeatureInstance__Group_7_4__1 : rule__FeatureInstance__Group_7_4__1__Impl ;
    public final void rule__FeatureInstance__Group_7_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2144:1: ( rule__FeatureInstance__Group_7_4__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2145:2: rule__FeatureInstance__Group_7_4__1__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_7_4__1__Impl_in_rule__FeatureInstance__Group_7_4__14467);
            rule__FeatureInstance__Group_7_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_7_4__1"


    // $ANTLR start "rule__FeatureInstance__Group_7_4__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2151:1: rule__FeatureInstance__Group_7_4__1__Impl : ( ( rule__FeatureInstance__Alternatives_7_4_1 ) ) ;
    public final void rule__FeatureInstance__Group_7_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2155:1: ( ( ( rule__FeatureInstance__Alternatives_7_4_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2156:1: ( ( rule__FeatureInstance__Alternatives_7_4_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2156:1: ( ( rule__FeatureInstance__Alternatives_7_4_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2157:1: ( rule__FeatureInstance__Alternatives_7_4_1 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getAlternatives_7_4_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2158:1: ( rule__FeatureInstance__Alternatives_7_4_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2158:2: rule__FeatureInstance__Alternatives_7_4_1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Alternatives_7_4_1_in_rule__FeatureInstance__Group_7_4__1__Impl4494);
            rule__FeatureInstance__Alternatives_7_4_1();

            state._fsp--;


            }

             after(grammarAccess.getFeatureInstanceAccess().getAlternatives_7_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_7_4__1__Impl"


    // $ANTLR start "rule__FeatureInstance__Group_8__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2172:1: rule__FeatureInstance__Group_8__0 : rule__FeatureInstance__Group_8__0__Impl rule__FeatureInstance__Group_8__1 ;
    public final void rule__FeatureInstance__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2176:1: ( rule__FeatureInstance__Group_8__0__Impl rule__FeatureInstance__Group_8__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2177:2: rule__FeatureInstance__Group_8__0__Impl rule__FeatureInstance__Group_8__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_8__0__Impl_in_rule__FeatureInstance__Group_8__04528);
            rule__FeatureInstance__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_8__1_in_rule__FeatureInstance__Group_8__04531);
            rule__FeatureInstance__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_8__0"


    // $ANTLR start "rule__FeatureInstance__Group_8__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2184:1: rule__FeatureInstance__Group_8__0__Impl : ( '{' ) ;
    public final void rule__FeatureInstance__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2188:1: ( ( '{' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2189:1: ( '{' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2189:1: ( '{' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2190:1: '{'
            {
             before(grammarAccess.getFeatureInstanceAccess().getLeftCurlyBracketKeyword_8_0()); 
            match(input,39,FOLLOW_39_in_rule__FeatureInstance__Group_8__0__Impl4559); 
             after(grammarAccess.getFeatureInstanceAccess().getLeftCurlyBracketKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_8__0__Impl"


    // $ANTLR start "rule__FeatureInstance__Group_8__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2203:1: rule__FeatureInstance__Group_8__1 : rule__FeatureInstance__Group_8__1__Impl rule__FeatureInstance__Group_8__2 ;
    public final void rule__FeatureInstance__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2207:1: ( rule__FeatureInstance__Group_8__1__Impl rule__FeatureInstance__Group_8__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2208:2: rule__FeatureInstance__Group_8__1__Impl rule__FeatureInstance__Group_8__2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_8__1__Impl_in_rule__FeatureInstance__Group_8__14590);
            rule__FeatureInstance__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_8__2_in_rule__FeatureInstance__Group_8__14593);
            rule__FeatureInstance__Group_8__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_8__1"


    // $ANTLR start "rule__FeatureInstance__Group_8__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2215:1: rule__FeatureInstance__Group_8__1__Impl : ( ( rule__FeatureInstance__FeatureInstanceAssignment_8_1 )* ) ;
    public final void rule__FeatureInstance__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2219:1: ( ( ( rule__FeatureInstance__FeatureInstanceAssignment_8_1 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2220:1: ( ( rule__FeatureInstance__FeatureInstanceAssignment_8_1 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2220:1: ( ( rule__FeatureInstance__FeatureInstanceAssignment_8_1 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2221:1: ( rule__FeatureInstance__FeatureInstanceAssignment_8_1 )*
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceAssignment_8_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2222:1: ( rule__FeatureInstance__FeatureInstanceAssignment_8_1 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=10 && LA20_0<=11)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2222:2: rule__FeatureInstance__FeatureInstanceAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_rule__FeatureInstance__FeatureInstanceAssignment_8_1_in_rule__FeatureInstance__Group_8__1__Impl4620);
            	    rule__FeatureInstance__FeatureInstanceAssignment_8_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_8__1__Impl"


    // $ANTLR start "rule__FeatureInstance__Group_8__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2232:1: rule__FeatureInstance__Group_8__2 : rule__FeatureInstance__Group_8__2__Impl ;
    public final void rule__FeatureInstance__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2236:1: ( rule__FeatureInstance__Group_8__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2237:2: rule__FeatureInstance__Group_8__2__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_8__2__Impl_in_rule__FeatureInstance__Group_8__24651);
            rule__FeatureInstance__Group_8__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_8__2"


    // $ANTLR start "rule__FeatureInstance__Group_8__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2243:1: rule__FeatureInstance__Group_8__2__Impl : ( '}' ) ;
    public final void rule__FeatureInstance__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2247:1: ( ( '}' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2248:1: ( '}' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2248:1: ( '}' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2249:1: '}'
            {
             before(grammarAccess.getFeatureInstanceAccess().getRightCurlyBracketKeyword_8_2()); 
            match(input,40,FOLLOW_40_in_rule__FeatureInstance__Group_8__2__Impl4679); 
             after(grammarAccess.getFeatureInstanceAccess().getRightCurlyBracketKeyword_8_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__Group_8__2__Impl"


    // $ANTLR start "rule__ComponentInstance__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2268:1: rule__ComponentInstance__Group__0 : rule__ComponentInstance__Group__0__Impl rule__ComponentInstance__Group__1 ;
    public final void rule__ComponentInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2272:1: ( rule__ComponentInstance__Group__0__Impl rule__ComponentInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2273:2: rule__ComponentInstance__Group__0__Impl rule__ComponentInstance__Group__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__0__Impl_in_rule__ComponentInstance__Group__04716);
            rule__ComponentInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__1_in_rule__ComponentInstance__Group__04719);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2280:1: rule__ComponentInstance__Group__0__Impl : ( ( rule__ComponentInstance__CategoryAssignment_0 ) ) ;
    public final void rule__ComponentInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2284:1: ( ( ( rule__ComponentInstance__CategoryAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2285:1: ( ( rule__ComponentInstance__CategoryAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2285:1: ( ( rule__ComponentInstance__CategoryAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2286:1: ( rule__ComponentInstance__CategoryAssignment_0 )
            {
             before(grammarAccess.getComponentInstanceAccess().getCategoryAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2287:1: ( rule__ComponentInstance__CategoryAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2287:2: rule__ComponentInstance__CategoryAssignment_0
            {
            pushFollow(FOLLOW_rule__ComponentInstance__CategoryAssignment_0_in_rule__ComponentInstance__Group__0__Impl4746);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2297:1: rule__ComponentInstance__Group__1 : rule__ComponentInstance__Group__1__Impl rule__ComponentInstance__Group__2 ;
    public final void rule__ComponentInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2301:1: ( rule__ComponentInstance__Group__1__Impl rule__ComponentInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2302:2: rule__ComponentInstance__Group__1__Impl rule__ComponentInstance__Group__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__1__Impl_in_rule__ComponentInstance__Group__14776);
            rule__ComponentInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__2_in_rule__ComponentInstance__Group__14779);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2309:1: rule__ComponentInstance__Group__1__Impl : ( ( rule__ComponentInstance__NameAssignment_1 ) ) ;
    public final void rule__ComponentInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2313:1: ( ( ( rule__ComponentInstance__NameAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2314:1: ( ( rule__ComponentInstance__NameAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2314:1: ( ( rule__ComponentInstance__NameAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2315:1: ( rule__ComponentInstance__NameAssignment_1 )
            {
             before(grammarAccess.getComponentInstanceAccess().getNameAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2316:1: ( rule__ComponentInstance__NameAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2316:2: rule__ComponentInstance__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__NameAssignment_1_in_rule__ComponentInstance__Group__1__Impl4806);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2326:1: rule__ComponentInstance__Group__2 : rule__ComponentInstance__Group__2__Impl rule__ComponentInstance__Group__3 ;
    public final void rule__ComponentInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2330:1: ( rule__ComponentInstance__Group__2__Impl rule__ComponentInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2331:2: rule__ComponentInstance__Group__2__Impl rule__ComponentInstance__Group__3
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__2__Impl_in_rule__ComponentInstance__Group__24836);
            rule__ComponentInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__3_in_rule__ComponentInstance__Group__24839);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2338:1: rule__ComponentInstance__Group__2__Impl : ( ( rule__ComponentInstance__Group_2__0 )* ) ;
    public final void rule__ComponentInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2342:1: ( ( ( rule__ComponentInstance__Group_2__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2343:1: ( ( rule__ComponentInstance__Group_2__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2343:1: ( ( rule__ComponentInstance__Group_2__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2344:1: ( rule__ComponentInstance__Group_2__0 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2345:1: ( rule__ComponentInstance__Group_2__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==41) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2345:2: rule__ComponentInstance__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__Group_2__0_in_rule__ComponentInstance__Group__2__Impl4866);
            	    rule__ComponentInstance__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2355:1: rule__ComponentInstance__Group__3 : rule__ComponentInstance__Group__3__Impl rule__ComponentInstance__Group__4 ;
    public final void rule__ComponentInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2359:1: ( rule__ComponentInstance__Group__3__Impl rule__ComponentInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2360:2: rule__ComponentInstance__Group__3__Impl rule__ComponentInstance__Group__4
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__3__Impl_in_rule__ComponentInstance__Group__34897);
            rule__ComponentInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__4_in_rule__ComponentInstance__Group__34900);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2367:1: rule__ComponentInstance__Group__3__Impl : ( ':' ) ;
    public final void rule__ComponentInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2371:1: ( ( ':' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2372:1: ( ':' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2372:1: ( ':' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2373:1: ':'
            {
             before(grammarAccess.getComponentInstanceAccess().getColonKeyword_3()); 
            match(input,38,FOLLOW_38_in_rule__ComponentInstance__Group__3__Impl4928); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2386:1: rule__ComponentInstance__Group__4 : rule__ComponentInstance__Group__4__Impl rule__ComponentInstance__Group__5 ;
    public final void rule__ComponentInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2390:1: ( rule__ComponentInstance__Group__4__Impl rule__ComponentInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2391:2: rule__ComponentInstance__Group__4__Impl rule__ComponentInstance__Group__5
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__4__Impl_in_rule__ComponentInstance__Group__44959);
            rule__ComponentInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__5_in_rule__ComponentInstance__Group__44962);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2398:1: rule__ComponentInstance__Group__4__Impl : ( ( rule__ComponentInstance__SubcomponentAssignment_4 ) ) ;
    public final void rule__ComponentInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2402:1: ( ( ( rule__ComponentInstance__SubcomponentAssignment_4 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2403:1: ( ( rule__ComponentInstance__SubcomponentAssignment_4 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2403:1: ( ( rule__ComponentInstance__SubcomponentAssignment_4 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2404:1: ( rule__ComponentInstance__SubcomponentAssignment_4 )
            {
             before(grammarAccess.getComponentInstanceAccess().getSubcomponentAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2405:1: ( rule__ComponentInstance__SubcomponentAssignment_4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2405:2: rule__ComponentInstance__SubcomponentAssignment_4
            {
            pushFollow(FOLLOW_rule__ComponentInstance__SubcomponentAssignment_4_in_rule__ComponentInstance__Group__4__Impl4989);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2415:1: rule__ComponentInstance__Group__5 : rule__ComponentInstance__Group__5__Impl rule__ComponentInstance__Group__6 ;
    public final void rule__ComponentInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2419:1: ( rule__ComponentInstance__Group__5__Impl rule__ComponentInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2420:2: rule__ComponentInstance__Group__5__Impl rule__ComponentInstance__Group__6
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__5__Impl_in_rule__ComponentInstance__Group__55019);
            rule__ComponentInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__6_in_rule__ComponentInstance__Group__55022);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2427:1: rule__ComponentInstance__Group__5__Impl : ( ( rule__ComponentInstance__Group_5__0 )? ) ;
    public final void rule__ComponentInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2431:1: ( ( ( rule__ComponentInstance__Group_5__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2432:1: ( ( rule__ComponentInstance__Group_5__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2432:1: ( ( rule__ComponentInstance__Group_5__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2433:1: ( rule__ComponentInstance__Group_5__0 )?
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2434:1: ( rule__ComponentInstance__Group_5__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==43) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2434:2: rule__ComponentInstance__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__Group_5__0_in_rule__ComponentInstance__Group__5__Impl5049);
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


    // $ANTLR start "rule__ComponentInstance__Group__6"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2444:1: rule__ComponentInstance__Group__6 : rule__ComponentInstance__Group__6__Impl rule__ComponentInstance__Group__7 ;
    public final void rule__ComponentInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2448:1: ( rule__ComponentInstance__Group__6__Impl rule__ComponentInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2449:2: rule__ComponentInstance__Group__6__Impl rule__ComponentInstance__Group__7
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__6__Impl_in_rule__ComponentInstance__Group__65080);
            rule__ComponentInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__7_in_rule__ComponentInstance__Group__65083);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2456:1: rule__ComponentInstance__Group__6__Impl : ( ( rule__ComponentInstance__Group_6__0 )? ) ;
    public final void rule__ComponentInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2460:1: ( ( ( rule__ComponentInstance__Group_6__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2461:1: ( ( rule__ComponentInstance__Group_6__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2461:1: ( ( rule__ComponentInstance__Group_6__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2462:1: ( rule__ComponentInstance__Group_6__0 )?
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2463:1: ( rule__ComponentInstance__Group_6__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==48) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2463:2: rule__ComponentInstance__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__Group_6__0_in_rule__ComponentInstance__Group__6__Impl5110);
                    rule__ComponentInstance__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getComponentInstanceAccess().getGroup_6()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2473:1: rule__ComponentInstance__Group__7 : rule__ComponentInstance__Group__7__Impl ;
    public final void rule__ComponentInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2477:1: ( rule__ComponentInstance__Group__7__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2478:2: rule__ComponentInstance__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__7__Impl_in_rule__ComponentInstance__Group__75141);
            rule__ComponentInstance__Group__7__Impl();

            state._fsp--;


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2484:1: rule__ComponentInstance__Group__7__Impl : ( ( rule__ComponentInstance__Group_7__0 )? ) ;
    public final void rule__ComponentInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2488:1: ( ( ( rule__ComponentInstance__Group_7__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2489:1: ( ( rule__ComponentInstance__Group_7__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2489:1: ( ( rule__ComponentInstance__Group_7__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2490:1: ( rule__ComponentInstance__Group_7__0 )?
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2491:1: ( rule__ComponentInstance__Group_7__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==39) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2491:2: rule__ComponentInstance__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__Group_7__0_in_rule__ComponentInstance__Group__7__Impl5168);
                    rule__ComponentInstance__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getComponentInstanceAccess().getGroup_7()); 

            }


            }

        }
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


    // $ANTLR start "rule__ComponentInstance__Group_2__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2517:1: rule__ComponentInstance__Group_2__0 : rule__ComponentInstance__Group_2__0__Impl rule__ComponentInstance__Group_2__1 ;
    public final void rule__ComponentInstance__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2521:1: ( rule__ComponentInstance__Group_2__0__Impl rule__ComponentInstance__Group_2__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2522:2: rule__ComponentInstance__Group_2__0__Impl rule__ComponentInstance__Group_2__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_2__0__Impl_in_rule__ComponentInstance__Group_2__05215);
            rule__ComponentInstance__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_2__1_in_rule__ComponentInstance__Group_2__05218);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2529:1: rule__ComponentInstance__Group_2__0__Impl : ( '[' ) ;
    public final void rule__ComponentInstance__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2533:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2534:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2534:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2535:1: '['
            {
             before(grammarAccess.getComponentInstanceAccess().getLeftSquareBracketKeyword_2_0()); 
            match(input,41,FOLLOW_41_in_rule__ComponentInstance__Group_2__0__Impl5246); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2548:1: rule__ComponentInstance__Group_2__1 : rule__ComponentInstance__Group_2__1__Impl rule__ComponentInstance__Group_2__2 ;
    public final void rule__ComponentInstance__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2552:1: ( rule__ComponentInstance__Group_2__1__Impl rule__ComponentInstance__Group_2__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2553:2: rule__ComponentInstance__Group_2__1__Impl rule__ComponentInstance__Group_2__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_2__1__Impl_in_rule__ComponentInstance__Group_2__15277);
            rule__ComponentInstance__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_2__2_in_rule__ComponentInstance__Group_2__15280);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2560:1: rule__ComponentInstance__Group_2__1__Impl : ( ( rule__ComponentInstance__IndexAssignment_2_1 ) ) ;
    public final void rule__ComponentInstance__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2564:1: ( ( ( rule__ComponentInstance__IndexAssignment_2_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2565:1: ( ( rule__ComponentInstance__IndexAssignment_2_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2565:1: ( ( rule__ComponentInstance__IndexAssignment_2_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2566:1: ( rule__ComponentInstance__IndexAssignment_2_1 )
            {
             before(grammarAccess.getComponentInstanceAccess().getIndexAssignment_2_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2567:1: ( rule__ComponentInstance__IndexAssignment_2_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2567:2: rule__ComponentInstance__IndexAssignment_2_1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__IndexAssignment_2_1_in_rule__ComponentInstance__Group_2__1__Impl5307);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2577:1: rule__ComponentInstance__Group_2__2 : rule__ComponentInstance__Group_2__2__Impl ;
    public final void rule__ComponentInstance__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2581:1: ( rule__ComponentInstance__Group_2__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2582:2: rule__ComponentInstance__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_2__2__Impl_in_rule__ComponentInstance__Group_2__25337);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2588:1: rule__ComponentInstance__Group_2__2__Impl : ( ']' ) ;
    public final void rule__ComponentInstance__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2592:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2593:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2593:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2594:1: ']'
            {
             before(grammarAccess.getComponentInstanceAccess().getRightSquareBracketKeyword_2_2()); 
            match(input,42,FOLLOW_42_in_rule__ComponentInstance__Group_2__2__Impl5365); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2613:1: rule__ComponentInstance__Group_5__0 : rule__ComponentInstance__Group_5__0__Impl rule__ComponentInstance__Group_5__1 ;
    public final void rule__ComponentInstance__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2617:1: ( rule__ComponentInstance__Group_5__0__Impl rule__ComponentInstance__Group_5__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2618:2: rule__ComponentInstance__Group_5__0__Impl rule__ComponentInstance__Group_5__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__0__Impl_in_rule__ComponentInstance__Group_5__05402);
            rule__ComponentInstance__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__1_in_rule__ComponentInstance__Group_5__05405);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2625:1: rule__ComponentInstance__Group_5__0__Impl : ( 'source' ) ;
    public final void rule__ComponentInstance__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2629:1: ( ( 'source' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2630:1: ( 'source' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2630:1: ( 'source' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2631:1: 'source'
            {
             before(grammarAccess.getComponentInstanceAccess().getSourceKeyword_5_0()); 
            match(input,43,FOLLOW_43_in_rule__ComponentInstance__Group_5__0__Impl5433); 
             after(grammarAccess.getComponentInstanceAccess().getSourceKeyword_5_0()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2644:1: rule__ComponentInstance__Group_5__1 : rule__ComponentInstance__Group_5__1__Impl rule__ComponentInstance__Group_5__2 ;
    public final void rule__ComponentInstance__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2648:1: ( rule__ComponentInstance__Group_5__1__Impl rule__ComponentInstance__Group_5__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2649:2: rule__ComponentInstance__Group_5__1__Impl rule__ComponentInstance__Group_5__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__1__Impl_in_rule__ComponentInstance__Group_5__15464);
            rule__ComponentInstance__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__2_in_rule__ComponentInstance__Group_5__15467);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2656:1: rule__ComponentInstance__Group_5__1__Impl : ( 'of' ) ;
    public final void rule__ComponentInstance__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2660:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2661:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2661:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2662:1: 'of'
            {
             before(grammarAccess.getComponentInstanceAccess().getOfKeyword_5_1()); 
            match(input,44,FOLLOW_44_in_rule__ComponentInstance__Group_5__1__Impl5495); 
             after(grammarAccess.getComponentInstanceAccess().getOfKeyword_5_1()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2675:1: rule__ComponentInstance__Group_5__2 : rule__ComponentInstance__Group_5__2__Impl rule__ComponentInstance__Group_5__3 ;
    public final void rule__ComponentInstance__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2679:1: ( rule__ComponentInstance__Group_5__2__Impl rule__ComponentInstance__Group_5__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2680:2: rule__ComponentInstance__Group_5__2__Impl rule__ComponentInstance__Group_5__3
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__2__Impl_in_rule__ComponentInstance__Group_5__25526);
            rule__ComponentInstance__Group_5__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__3_in_rule__ComponentInstance__Group_5__25529);
            rule__ComponentInstance__Group_5__3();

            state._fsp--;


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2687:1: rule__ComponentInstance__Group_5__2__Impl : ( '(' ) ;
    public final void rule__ComponentInstance__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2691:1: ( ( '(' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2692:1: ( '(' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2692:1: ( '(' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2693:1: '('
            {
             before(grammarAccess.getComponentInstanceAccess().getLeftParenthesisKeyword_5_2()); 
            match(input,45,FOLLOW_45_in_rule__ComponentInstance__Group_5__2__Impl5557); 
             after(grammarAccess.getComponentInstanceAccess().getLeftParenthesisKeyword_5_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__ComponentInstance__Group_5__3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2706:1: rule__ComponentInstance__Group_5__3 : rule__ComponentInstance__Group_5__3__Impl rule__ComponentInstance__Group_5__4 ;
    public final void rule__ComponentInstance__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2710:1: ( rule__ComponentInstance__Group_5__3__Impl rule__ComponentInstance__Group_5__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2711:2: rule__ComponentInstance__Group_5__3__Impl rule__ComponentInstance__Group_5__4
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__3__Impl_in_rule__ComponentInstance__Group_5__35588);
            rule__ComponentInstance__Group_5__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__4_in_rule__ComponentInstance__Group_5__35591);
            rule__ComponentInstance__Group_5__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_5__3"


    // $ANTLR start "rule__ComponentInstance__Group_5__3__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2718:1: rule__ComponentInstance__Group_5__3__Impl : ( ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3 ) ) ;
    public final void rule__ComponentInstance__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2722:1: ( ( ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2723:1: ( ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2723:1: ( ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2724:1: ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3 )
            {
             before(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceAssignment_5_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2725:1: ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2725:2: rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3
            {
            pushFollow(FOLLOW_rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3_in_rule__ComponentInstance__Group_5__3__Impl5618);
            rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3();

            state._fsp--;


            }

             after(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceAssignment_5_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_5__3__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_5__4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2735:1: rule__ComponentInstance__Group_5__4 : rule__ComponentInstance__Group_5__4__Impl rule__ComponentInstance__Group_5__5 ;
    public final void rule__ComponentInstance__Group_5__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2739:1: ( rule__ComponentInstance__Group_5__4__Impl rule__ComponentInstance__Group_5__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2740:2: rule__ComponentInstance__Group_5__4__Impl rule__ComponentInstance__Group_5__5
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__4__Impl_in_rule__ComponentInstance__Group_5__45648);
            rule__ComponentInstance__Group_5__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__5_in_rule__ComponentInstance__Group_5__45651);
            rule__ComponentInstance__Group_5__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_5__4"


    // $ANTLR start "rule__ComponentInstance__Group_5__4__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2747:1: rule__ComponentInstance__Group_5__4__Impl : ( ( rule__ComponentInstance__Group_5_4__0 )* ) ;
    public final void rule__ComponentInstance__Group_5__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2751:1: ( ( ( rule__ComponentInstance__Group_5_4__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2752:1: ( ( rule__ComponentInstance__Group_5_4__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2752:1: ( ( rule__ComponentInstance__Group_5_4__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2753:1: ( rule__ComponentInstance__Group_5_4__0 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup_5_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2754:1: ( rule__ComponentInstance__Group_5_4__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==47) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2754:2: rule__ComponentInstance__Group_5_4__0
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__Group_5_4__0_in_rule__ComponentInstance__Group_5__4__Impl5678);
            	    rule__ComponentInstance__Group_5_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getComponentInstanceAccess().getGroup_5_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_5__4__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_5__5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2764:1: rule__ComponentInstance__Group_5__5 : rule__ComponentInstance__Group_5__5__Impl ;
    public final void rule__ComponentInstance__Group_5__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2768:1: ( rule__ComponentInstance__Group_5__5__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2769:2: rule__ComponentInstance__Group_5__5__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__5__Impl_in_rule__ComponentInstance__Group_5__55709);
            rule__ComponentInstance__Group_5__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_5__5"


    // $ANTLR start "rule__ComponentInstance__Group_5__5__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2775:1: rule__ComponentInstance__Group_5__5__Impl : ( ')' ) ;
    public final void rule__ComponentInstance__Group_5__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2779:1: ( ( ')' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2780:1: ( ')' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2780:1: ( ')' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2781:1: ')'
            {
             before(grammarAccess.getComponentInstanceAccess().getRightParenthesisKeyword_5_5()); 
            match(input,46,FOLLOW_46_in_rule__ComponentInstance__Group_5__5__Impl5737); 
             after(grammarAccess.getComponentInstanceAccess().getRightParenthesisKeyword_5_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_5__5__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_5_4__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2806:1: rule__ComponentInstance__Group_5_4__0 : rule__ComponentInstance__Group_5_4__0__Impl rule__ComponentInstance__Group_5_4__1 ;
    public final void rule__ComponentInstance__Group_5_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2810:1: ( rule__ComponentInstance__Group_5_4__0__Impl rule__ComponentInstance__Group_5_4__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2811:2: rule__ComponentInstance__Group_5_4__0__Impl rule__ComponentInstance__Group_5_4__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_5_4__0__Impl_in_rule__ComponentInstance__Group_5_4__05780);
            rule__ComponentInstance__Group_5_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_5_4__1_in_rule__ComponentInstance__Group_5_4__05783);
            rule__ComponentInstance__Group_5_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_5_4__0"


    // $ANTLR start "rule__ComponentInstance__Group_5_4__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2818:1: rule__ComponentInstance__Group_5_4__0__Impl : ( ',' ) ;
    public final void rule__ComponentInstance__Group_5_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2822:1: ( ( ',' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2823:1: ( ',' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2823:1: ( ',' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2824:1: ','
            {
             before(grammarAccess.getComponentInstanceAccess().getCommaKeyword_5_4_0()); 
            match(input,47,FOLLOW_47_in_rule__ComponentInstance__Group_5_4__0__Impl5811); 
             after(grammarAccess.getComponentInstanceAccess().getCommaKeyword_5_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_5_4__0__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_5_4__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2837:1: rule__ComponentInstance__Group_5_4__1 : rule__ComponentInstance__Group_5_4__1__Impl ;
    public final void rule__ComponentInstance__Group_5_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2841:1: ( rule__ComponentInstance__Group_5_4__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2842:2: rule__ComponentInstance__Group_5_4__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_5_4__1__Impl_in_rule__ComponentInstance__Group_5_4__15842);
            rule__ComponentInstance__Group_5_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_5_4__1"


    // $ANTLR start "rule__ComponentInstance__Group_5_4__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2848:1: rule__ComponentInstance__Group_5_4__1__Impl : ( ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1 ) ) ;
    public final void rule__ComponentInstance__Group_5_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2852:1: ( ( ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2853:1: ( ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2853:1: ( ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2854:1: ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1 )
            {
             before(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceAssignment_5_4_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2855:1: ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2855:2: rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1_in_rule__ComponentInstance__Group_5_4__1__Impl5869);
            rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1();

            state._fsp--;


            }

             after(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceAssignment_5_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_5_4__1__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_6__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2869:1: rule__ComponentInstance__Group_6__0 : rule__ComponentInstance__Group_6__0__Impl rule__ComponentInstance__Group_6__1 ;
    public final void rule__ComponentInstance__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2873:1: ( rule__ComponentInstance__Group_6__0__Impl rule__ComponentInstance__Group_6__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2874:2: rule__ComponentInstance__Group_6__0__Impl rule__ComponentInstance__Group_6__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_6__0__Impl_in_rule__ComponentInstance__Group_6__05903);
            rule__ComponentInstance__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_6__1_in_rule__ComponentInstance__Group_6__05906);
            rule__ComponentInstance__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_6__0"


    // $ANTLR start "rule__ComponentInstance__Group_6__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2881:1: rule__ComponentInstance__Group_6__0__Impl : ( 'destination' ) ;
    public final void rule__ComponentInstance__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2885:1: ( ( 'destination' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2886:1: ( 'destination' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2886:1: ( 'destination' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2887:1: 'destination'
            {
             before(grammarAccess.getComponentInstanceAccess().getDestinationKeyword_6_0()); 
            match(input,48,FOLLOW_48_in_rule__ComponentInstance__Group_6__0__Impl5934); 
             after(grammarAccess.getComponentInstanceAccess().getDestinationKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_6__0__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_6__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2900:1: rule__ComponentInstance__Group_6__1 : rule__ComponentInstance__Group_6__1__Impl rule__ComponentInstance__Group_6__2 ;
    public final void rule__ComponentInstance__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2904:1: ( rule__ComponentInstance__Group_6__1__Impl rule__ComponentInstance__Group_6__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2905:2: rule__ComponentInstance__Group_6__1__Impl rule__ComponentInstance__Group_6__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_6__1__Impl_in_rule__ComponentInstance__Group_6__15965);
            rule__ComponentInstance__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_6__2_in_rule__ComponentInstance__Group_6__15968);
            rule__ComponentInstance__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_6__1"


    // $ANTLR start "rule__ComponentInstance__Group_6__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2912:1: rule__ComponentInstance__Group_6__1__Impl : ( 'of' ) ;
    public final void rule__ComponentInstance__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2916:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2917:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2917:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2918:1: 'of'
            {
             before(grammarAccess.getComponentInstanceAccess().getOfKeyword_6_1()); 
            match(input,44,FOLLOW_44_in_rule__ComponentInstance__Group_6__1__Impl5996); 
             after(grammarAccess.getComponentInstanceAccess().getOfKeyword_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_6__1__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_6__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2931:1: rule__ComponentInstance__Group_6__2 : rule__ComponentInstance__Group_6__2__Impl rule__ComponentInstance__Group_6__3 ;
    public final void rule__ComponentInstance__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2935:1: ( rule__ComponentInstance__Group_6__2__Impl rule__ComponentInstance__Group_6__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2936:2: rule__ComponentInstance__Group_6__2__Impl rule__ComponentInstance__Group_6__3
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_6__2__Impl_in_rule__ComponentInstance__Group_6__26027);
            rule__ComponentInstance__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_6__3_in_rule__ComponentInstance__Group_6__26030);
            rule__ComponentInstance__Group_6__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_6__2"


    // $ANTLR start "rule__ComponentInstance__Group_6__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2943:1: rule__ComponentInstance__Group_6__2__Impl : ( '(' ) ;
    public final void rule__ComponentInstance__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2947:1: ( ( '(' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2948:1: ( '(' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2948:1: ( '(' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2949:1: '('
            {
             before(grammarAccess.getComponentInstanceAccess().getLeftParenthesisKeyword_6_2()); 
            match(input,45,FOLLOW_45_in_rule__ComponentInstance__Group_6__2__Impl6058); 
             after(grammarAccess.getComponentInstanceAccess().getLeftParenthesisKeyword_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_6__2__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_6__3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2962:1: rule__ComponentInstance__Group_6__3 : rule__ComponentInstance__Group_6__3__Impl rule__ComponentInstance__Group_6__4 ;
    public final void rule__ComponentInstance__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2966:1: ( rule__ComponentInstance__Group_6__3__Impl rule__ComponentInstance__Group_6__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2967:2: rule__ComponentInstance__Group_6__3__Impl rule__ComponentInstance__Group_6__4
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_6__3__Impl_in_rule__ComponentInstance__Group_6__36089);
            rule__ComponentInstance__Group_6__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_6__4_in_rule__ComponentInstance__Group_6__36092);
            rule__ComponentInstance__Group_6__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_6__3"


    // $ANTLR start "rule__ComponentInstance__Group_6__3__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2974:1: rule__ComponentInstance__Group_6__3__Impl : ( ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_3 ) ) ;
    public final void rule__ComponentInstance__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2978:1: ( ( ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_3 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2979:1: ( ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_3 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2979:1: ( ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_3 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2980:1: ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_3 )
            {
             before(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceAssignment_6_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2981:1: ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2981:2: rule__ComponentInstance__DstConnectionInstanceAssignment_6_3
            {
            pushFollow(FOLLOW_rule__ComponentInstance__DstConnectionInstanceAssignment_6_3_in_rule__ComponentInstance__Group_6__3__Impl6119);
            rule__ComponentInstance__DstConnectionInstanceAssignment_6_3();

            state._fsp--;


            }

             after(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceAssignment_6_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_6__3__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_6__4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2991:1: rule__ComponentInstance__Group_6__4 : rule__ComponentInstance__Group_6__4__Impl rule__ComponentInstance__Group_6__5 ;
    public final void rule__ComponentInstance__Group_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2995:1: ( rule__ComponentInstance__Group_6__4__Impl rule__ComponentInstance__Group_6__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2996:2: rule__ComponentInstance__Group_6__4__Impl rule__ComponentInstance__Group_6__5
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_6__4__Impl_in_rule__ComponentInstance__Group_6__46149);
            rule__ComponentInstance__Group_6__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_6__5_in_rule__ComponentInstance__Group_6__46152);
            rule__ComponentInstance__Group_6__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_6__4"


    // $ANTLR start "rule__ComponentInstance__Group_6__4__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3003:1: rule__ComponentInstance__Group_6__4__Impl : ( ( rule__ComponentInstance__Group_6_4__0 )* ) ;
    public final void rule__ComponentInstance__Group_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3007:1: ( ( ( rule__ComponentInstance__Group_6_4__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3008:1: ( ( rule__ComponentInstance__Group_6_4__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3008:1: ( ( rule__ComponentInstance__Group_6_4__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3009:1: ( rule__ComponentInstance__Group_6_4__0 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup_6_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3010:1: ( rule__ComponentInstance__Group_6_4__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==47) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3010:2: rule__ComponentInstance__Group_6_4__0
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__Group_6_4__0_in_rule__ComponentInstance__Group_6__4__Impl6179);
            	    rule__ComponentInstance__Group_6_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getComponentInstanceAccess().getGroup_6_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_6__4__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_6__5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3020:1: rule__ComponentInstance__Group_6__5 : rule__ComponentInstance__Group_6__5__Impl ;
    public final void rule__ComponentInstance__Group_6__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3024:1: ( rule__ComponentInstance__Group_6__5__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3025:2: rule__ComponentInstance__Group_6__5__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_6__5__Impl_in_rule__ComponentInstance__Group_6__56210);
            rule__ComponentInstance__Group_6__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_6__5"


    // $ANTLR start "rule__ComponentInstance__Group_6__5__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3031:1: rule__ComponentInstance__Group_6__5__Impl : ( ')' ) ;
    public final void rule__ComponentInstance__Group_6__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3035:1: ( ( ')' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3036:1: ( ')' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3036:1: ( ')' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3037:1: ')'
            {
             before(grammarAccess.getComponentInstanceAccess().getRightParenthesisKeyword_6_5()); 
            match(input,46,FOLLOW_46_in_rule__ComponentInstance__Group_6__5__Impl6238); 
             after(grammarAccess.getComponentInstanceAccess().getRightParenthesisKeyword_6_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_6__5__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_6_4__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3062:1: rule__ComponentInstance__Group_6_4__0 : rule__ComponentInstance__Group_6_4__0__Impl rule__ComponentInstance__Group_6_4__1 ;
    public final void rule__ComponentInstance__Group_6_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3066:1: ( rule__ComponentInstance__Group_6_4__0__Impl rule__ComponentInstance__Group_6_4__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3067:2: rule__ComponentInstance__Group_6_4__0__Impl rule__ComponentInstance__Group_6_4__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_6_4__0__Impl_in_rule__ComponentInstance__Group_6_4__06281);
            rule__ComponentInstance__Group_6_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_6_4__1_in_rule__ComponentInstance__Group_6_4__06284);
            rule__ComponentInstance__Group_6_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_6_4__0"


    // $ANTLR start "rule__ComponentInstance__Group_6_4__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3074:1: rule__ComponentInstance__Group_6_4__0__Impl : ( ',' ) ;
    public final void rule__ComponentInstance__Group_6_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3078:1: ( ( ',' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3079:1: ( ',' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3079:1: ( ',' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3080:1: ','
            {
             before(grammarAccess.getComponentInstanceAccess().getCommaKeyword_6_4_0()); 
            match(input,47,FOLLOW_47_in_rule__ComponentInstance__Group_6_4__0__Impl6312); 
             after(grammarAccess.getComponentInstanceAccess().getCommaKeyword_6_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_6_4__0__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_6_4__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3093:1: rule__ComponentInstance__Group_6_4__1 : rule__ComponentInstance__Group_6_4__1__Impl ;
    public final void rule__ComponentInstance__Group_6_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3097:1: ( rule__ComponentInstance__Group_6_4__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3098:2: rule__ComponentInstance__Group_6_4__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_6_4__1__Impl_in_rule__ComponentInstance__Group_6_4__16343);
            rule__ComponentInstance__Group_6_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_6_4__1"


    // $ANTLR start "rule__ComponentInstance__Group_6_4__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3104:1: rule__ComponentInstance__Group_6_4__1__Impl : ( ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1 ) ) ;
    public final void rule__ComponentInstance__Group_6_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3108:1: ( ( ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3109:1: ( ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3109:1: ( ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3110:1: ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1 )
            {
             before(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceAssignment_6_4_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3111:1: ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3111:2: rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1_in_rule__ComponentInstance__Group_6_4__1__Impl6370);
            rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1();

            state._fsp--;


            }

             after(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceAssignment_6_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_6_4__1__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_7__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3125:1: rule__ComponentInstance__Group_7__0 : rule__ComponentInstance__Group_7__0__Impl rule__ComponentInstance__Group_7__1 ;
    public final void rule__ComponentInstance__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3129:1: ( rule__ComponentInstance__Group_7__0__Impl rule__ComponentInstance__Group_7__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3130:2: rule__ComponentInstance__Group_7__0__Impl rule__ComponentInstance__Group_7__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_7__0__Impl_in_rule__ComponentInstance__Group_7__06404);
            rule__ComponentInstance__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_7__1_in_rule__ComponentInstance__Group_7__06407);
            rule__ComponentInstance__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_7__0"


    // $ANTLR start "rule__ComponentInstance__Group_7__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3137:1: rule__ComponentInstance__Group_7__0__Impl : ( '{' ) ;
    public final void rule__ComponentInstance__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3141:1: ( ( '{' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3142:1: ( '{' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3142:1: ( '{' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3143:1: '{'
            {
             before(grammarAccess.getComponentInstanceAccess().getLeftCurlyBracketKeyword_7_0()); 
            match(input,39,FOLLOW_39_in_rule__ComponentInstance__Group_7__0__Impl6435); 
             after(grammarAccess.getComponentInstanceAccess().getLeftCurlyBracketKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_7__0__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_7__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3156:1: rule__ComponentInstance__Group_7__1 : rule__ComponentInstance__Group_7__1__Impl rule__ComponentInstance__Group_7__2 ;
    public final void rule__ComponentInstance__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3160:1: ( rule__ComponentInstance__Group_7__1__Impl rule__ComponentInstance__Group_7__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3161:2: rule__ComponentInstance__Group_7__1__Impl rule__ComponentInstance__Group_7__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_7__1__Impl_in_rule__ComponentInstance__Group_7__16466);
            rule__ComponentInstance__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_7__2_in_rule__ComponentInstance__Group_7__16469);
            rule__ComponentInstance__Group_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_7__1"


    // $ANTLR start "rule__ComponentInstance__Group_7__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3168:1: rule__ComponentInstance__Group_7__1__Impl : ( ( rule__ComponentInstance__Alternatives_7_1 )* ) ;
    public final void rule__ComponentInstance__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3172:1: ( ( ( rule__ComponentInstance__Alternatives_7_1 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3173:1: ( ( rule__ComponentInstance__Alternatives_7_1 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3173:1: ( ( rule__ComponentInstance__Alternatives_7_1 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3174:1: ( rule__ComponentInstance__Alternatives_7_1 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getAlternatives_7_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3175:1: ( rule__ComponentInstance__Alternatives_7_1 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=10 && LA27_0<=11)||(LA27_0>=21 && LA27_0<=36)||LA27_0==49||LA27_0==52||LA27_0==55) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3175:2: rule__ComponentInstance__Alternatives_7_1
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__Alternatives_7_1_in_rule__ComponentInstance__Group_7__1__Impl6496);
            	    rule__ComponentInstance__Alternatives_7_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getComponentInstanceAccess().getAlternatives_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_7__1__Impl"


    // $ANTLR start "rule__ComponentInstance__Group_7__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3185:1: rule__ComponentInstance__Group_7__2 : rule__ComponentInstance__Group_7__2__Impl ;
    public final void rule__ComponentInstance__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3189:1: ( rule__ComponentInstance__Group_7__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3190:2: rule__ComponentInstance__Group_7__2__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_7__2__Impl_in_rule__ComponentInstance__Group_7__26527);
            rule__ComponentInstance__Group_7__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_7__2"


    // $ANTLR start "rule__ComponentInstance__Group_7__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3196:1: rule__ComponentInstance__Group_7__2__Impl : ( '}' ) ;
    public final void rule__ComponentInstance__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3200:1: ( ( '}' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3201:1: ( '}' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3201:1: ( '}' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3202:1: '}'
            {
             before(grammarAccess.getComponentInstanceAccess().getRightCurlyBracketKeyword_7_2()); 
            match(input,40,FOLLOW_40_in_rule__ComponentInstance__Group_7__2__Impl6555); 
             after(grammarAccess.getComponentInstanceAccess().getRightCurlyBracketKeyword_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__Group_7__2__Impl"


    // $ANTLR start "rule__ConnectionInstance__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3221:1: rule__ConnectionInstance__Group__0 : rule__ConnectionInstance__Group__0__Impl rule__ConnectionInstance__Group__1 ;
    public final void rule__ConnectionInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3225:1: ( rule__ConnectionInstance__Group__0__Impl rule__ConnectionInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3226:2: rule__ConnectionInstance__Group__0__Impl rule__ConnectionInstance__Group__1
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__0__Impl_in_rule__ConnectionInstance__Group__06592);
            rule__ConnectionInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__1_in_rule__ConnectionInstance__Group__06595);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3233:1: rule__ConnectionInstance__Group__0__Impl : ( ( rule__ConnectionInstance__CompleteAssignment_0 )? ) ;
    public final void rule__ConnectionInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3237:1: ( ( ( rule__ConnectionInstance__CompleteAssignment_0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3238:1: ( ( rule__ConnectionInstance__CompleteAssignment_0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3238:1: ( ( rule__ConnectionInstance__CompleteAssignment_0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3239:1: ( rule__ConnectionInstance__CompleteAssignment_0 )?
            {
             before(grammarAccess.getConnectionInstanceAccess().getCompleteAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3240:1: ( rule__ConnectionInstance__CompleteAssignment_0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==55) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3240:2: rule__ConnectionInstance__CompleteAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ConnectionInstance__CompleteAssignment_0_in_rule__ConnectionInstance__Group__0__Impl6622);
                    rule__ConnectionInstance__CompleteAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConnectionInstanceAccess().getCompleteAssignment_0()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3250:1: rule__ConnectionInstance__Group__1 : rule__ConnectionInstance__Group__1__Impl rule__ConnectionInstance__Group__2 ;
    public final void rule__ConnectionInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3254:1: ( rule__ConnectionInstance__Group__1__Impl rule__ConnectionInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3255:2: rule__ConnectionInstance__Group__1__Impl rule__ConnectionInstance__Group__2
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__1__Impl_in_rule__ConnectionInstance__Group__16653);
            rule__ConnectionInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__2_in_rule__ConnectionInstance__Group__16656);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3262:1: rule__ConnectionInstance__Group__1__Impl : ( ( rule__ConnectionInstance__KindAssignment_1 ) ) ;
    public final void rule__ConnectionInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3266:1: ( ( ( rule__ConnectionInstance__KindAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3267:1: ( ( rule__ConnectionInstance__KindAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3267:1: ( ( rule__ConnectionInstance__KindAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3268:1: ( rule__ConnectionInstance__KindAssignment_1 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getKindAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3269:1: ( rule__ConnectionInstance__KindAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3269:2: rule__ConnectionInstance__KindAssignment_1
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__KindAssignment_1_in_rule__ConnectionInstance__Group__1__Impl6683);
            rule__ConnectionInstance__KindAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConnectionInstanceAccess().getKindAssignment_1()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3279:1: rule__ConnectionInstance__Group__2 : rule__ConnectionInstance__Group__2__Impl rule__ConnectionInstance__Group__3 ;
    public final void rule__ConnectionInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3283:1: ( rule__ConnectionInstance__Group__2__Impl rule__ConnectionInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3284:2: rule__ConnectionInstance__Group__2__Impl rule__ConnectionInstance__Group__3
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__2__Impl_in_rule__ConnectionInstance__Group__26713);
            rule__ConnectionInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__3_in_rule__ConnectionInstance__Group__26716);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3291:1: rule__ConnectionInstance__Group__2__Impl : ( ( rule__ConnectionInstance__NameAssignment_2 ) ) ;
    public final void rule__ConnectionInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3295:1: ( ( ( rule__ConnectionInstance__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3296:1: ( ( rule__ConnectionInstance__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3296:1: ( ( rule__ConnectionInstance__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3297:1: ( rule__ConnectionInstance__NameAssignment_2 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3298:1: ( rule__ConnectionInstance__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3298:2: rule__ConnectionInstance__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__NameAssignment_2_in_rule__ConnectionInstance__Group__2__Impl6743);
            rule__ConnectionInstance__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getConnectionInstanceAccess().getNameAssignment_2()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3308:1: rule__ConnectionInstance__Group__3 : rule__ConnectionInstance__Group__3__Impl rule__ConnectionInstance__Group__4 ;
    public final void rule__ConnectionInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3312:1: ( rule__ConnectionInstance__Group__3__Impl rule__ConnectionInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3313:2: rule__ConnectionInstance__Group__3__Impl rule__ConnectionInstance__Group__4
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__3__Impl_in_rule__ConnectionInstance__Group__36773);
            rule__ConnectionInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__4_in_rule__ConnectionInstance__Group__36776);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3320:1: rule__ConnectionInstance__Group__3__Impl : ( ':' ) ;
    public final void rule__ConnectionInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3324:1: ( ( ':' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3325:1: ( ':' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3325:1: ( ':' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3326:1: ':'
            {
             before(grammarAccess.getConnectionInstanceAccess().getColonKeyword_3()); 
            match(input,38,FOLLOW_38_in_rule__ConnectionInstance__Group__3__Impl6804); 
             after(grammarAccess.getConnectionInstanceAccess().getColonKeyword_3()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3339:1: rule__ConnectionInstance__Group__4 : rule__ConnectionInstance__Group__4__Impl rule__ConnectionInstance__Group__5 ;
    public final void rule__ConnectionInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3343:1: ( rule__ConnectionInstance__Group__4__Impl rule__ConnectionInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3344:2: rule__ConnectionInstance__Group__4__Impl rule__ConnectionInstance__Group__5
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__4__Impl_in_rule__ConnectionInstance__Group__46835);
            rule__ConnectionInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__5_in_rule__ConnectionInstance__Group__46838);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3351:1: rule__ConnectionInstance__Group__4__Impl : ( ( rule__ConnectionInstance__SourceAssignment_4 ) ) ;
    public final void rule__ConnectionInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3355:1: ( ( ( rule__ConnectionInstance__SourceAssignment_4 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3356:1: ( ( rule__ConnectionInstance__SourceAssignment_4 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3356:1: ( ( rule__ConnectionInstance__SourceAssignment_4 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3357:1: ( rule__ConnectionInstance__SourceAssignment_4 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getSourceAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3358:1: ( rule__ConnectionInstance__SourceAssignment_4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3358:2: rule__ConnectionInstance__SourceAssignment_4
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__SourceAssignment_4_in_rule__ConnectionInstance__Group__4__Impl6865);
            rule__ConnectionInstance__SourceAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getConnectionInstanceAccess().getSourceAssignment_4()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3368:1: rule__ConnectionInstance__Group__5 : rule__ConnectionInstance__Group__5__Impl rule__ConnectionInstance__Group__6 ;
    public final void rule__ConnectionInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3372:1: ( rule__ConnectionInstance__Group__5__Impl rule__ConnectionInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3373:2: rule__ConnectionInstance__Group__5__Impl rule__ConnectionInstance__Group__6
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__5__Impl_in_rule__ConnectionInstance__Group__56895);
            rule__ConnectionInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__6_in_rule__ConnectionInstance__Group__56898);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3380:1: rule__ConnectionInstance__Group__5__Impl : ( ( rule__ConnectionInstance__Alternatives_5 ) ) ;
    public final void rule__ConnectionInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3384:1: ( ( ( rule__ConnectionInstance__Alternatives_5 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3385:1: ( ( rule__ConnectionInstance__Alternatives_5 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3385:1: ( ( rule__ConnectionInstance__Alternatives_5 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3386:1: ( rule__ConnectionInstance__Alternatives_5 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getAlternatives_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3387:1: ( rule__ConnectionInstance__Alternatives_5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3387:2: rule__ConnectionInstance__Alternatives_5
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Alternatives_5_in_rule__ConnectionInstance__Group__5__Impl6925);
            rule__ConnectionInstance__Alternatives_5();

            state._fsp--;


            }

             after(grammarAccess.getConnectionInstanceAccess().getAlternatives_5()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3397:1: rule__ConnectionInstance__Group__6 : rule__ConnectionInstance__Group__6__Impl rule__ConnectionInstance__Group__7 ;
    public final void rule__ConnectionInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3401:1: ( rule__ConnectionInstance__Group__6__Impl rule__ConnectionInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3402:2: rule__ConnectionInstance__Group__6__Impl rule__ConnectionInstance__Group__7
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__6__Impl_in_rule__ConnectionInstance__Group__66955);
            rule__ConnectionInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__7_in_rule__ConnectionInstance__Group__66958);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3409:1: rule__ConnectionInstance__Group__6__Impl : ( ( rule__ConnectionInstance__DestinationAssignment_6 ) ) ;
    public final void rule__ConnectionInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3413:1: ( ( ( rule__ConnectionInstance__DestinationAssignment_6 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3414:1: ( ( rule__ConnectionInstance__DestinationAssignment_6 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3414:1: ( ( rule__ConnectionInstance__DestinationAssignment_6 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3415:1: ( rule__ConnectionInstance__DestinationAssignment_6 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getDestinationAssignment_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3416:1: ( rule__ConnectionInstance__DestinationAssignment_6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3416:2: rule__ConnectionInstance__DestinationAssignment_6
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__DestinationAssignment_6_in_rule__ConnectionInstance__Group__6__Impl6985);
            rule__ConnectionInstance__DestinationAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getConnectionInstanceAccess().getDestinationAssignment_6()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3426:1: rule__ConnectionInstance__Group__7 : rule__ConnectionInstance__Group__7__Impl rule__ConnectionInstance__Group__8 ;
    public final void rule__ConnectionInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3430:1: ( rule__ConnectionInstance__Group__7__Impl rule__ConnectionInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3431:2: rule__ConnectionInstance__Group__7__Impl rule__ConnectionInstance__Group__8
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__7__Impl_in_rule__ConnectionInstance__Group__77015);
            rule__ConnectionInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__8_in_rule__ConnectionInstance__Group__77018);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3438:1: rule__ConnectionInstance__Group__7__Impl : ( '{' ) ;
    public final void rule__ConnectionInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3442:1: ( ( '{' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3443:1: ( '{' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3443:1: ( '{' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3444:1: '{'
            {
             before(grammarAccess.getConnectionInstanceAccess().getLeftCurlyBracketKeyword_7()); 
            match(input,39,FOLLOW_39_in_rule__ConnectionInstance__Group__7__Impl7046); 
             after(grammarAccess.getConnectionInstanceAccess().getLeftCurlyBracketKeyword_7()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3457:1: rule__ConnectionInstance__Group__8 : rule__ConnectionInstance__Group__8__Impl rule__ConnectionInstance__Group__9 ;
    public final void rule__ConnectionInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3461:1: ( rule__ConnectionInstance__Group__8__Impl rule__ConnectionInstance__Group__9 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3462:2: rule__ConnectionInstance__Group__8__Impl rule__ConnectionInstance__Group__9
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__8__Impl_in_rule__ConnectionInstance__Group__87077);
            rule__ConnectionInstance__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__9_in_rule__ConnectionInstance__Group__87080);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3469:1: rule__ConnectionInstance__Group__8__Impl : ( ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 )* ) ) ;
    public final void rule__ConnectionInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3473:1: ( ( ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3474:1: ( ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3474:1: ( ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3475:1: ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3475:1: ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3476:1: ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceAssignment_8()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3477:1: ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3477:2: rule__ConnectionInstance__ConnectionReferenceAssignment_8
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__ConnectionReferenceAssignment_8_in_rule__ConnectionInstance__Group__8__Impl7109);
            rule__ConnectionInstance__ConnectionReferenceAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceAssignment_8()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3480:1: ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3481:1: ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 )*
            {
             before(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceAssignment_8()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3482:1: ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_ID) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3482:2: rule__ConnectionInstance__ConnectionReferenceAssignment_8
            	    {
            	    pushFollow(FOLLOW_rule__ConnectionInstance__ConnectionReferenceAssignment_8_in_rule__ConnectionInstance__Group__8__Impl7121);
            	    rule__ConnectionInstance__ConnectionReferenceAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceAssignment_8()); 

            }


            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3493:1: rule__ConnectionInstance__Group__9 : rule__ConnectionInstance__Group__9__Impl ;
    public final void rule__ConnectionInstance__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3497:1: ( rule__ConnectionInstance__Group__9__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3498:2: rule__ConnectionInstance__Group__9__Impl
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__9__Impl_in_rule__ConnectionInstance__Group__97154);
            rule__ConnectionInstance__Group__9__Impl();

            state._fsp--;


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3504:1: rule__ConnectionInstance__Group__9__Impl : ( '}' ) ;
    public final void rule__ConnectionInstance__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3508:1: ( ( '}' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3509:1: ( '}' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3509:1: ( '}' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3510:1: '}'
            {
             before(grammarAccess.getConnectionInstanceAccess().getRightCurlyBracketKeyword_9()); 
            match(input,40,FOLLOW_40_in_rule__ConnectionInstance__Group__9__Impl7182); 
             after(grammarAccess.getConnectionInstanceAccess().getRightCurlyBracketKeyword_9()); 

            }


            }

        }
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


    // $ANTLR start "rule__ConnectionReference__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3543:1: rule__ConnectionReference__Group__0 : rule__ConnectionReference__Group__0__Impl rule__ConnectionReference__Group__1 ;
    public final void rule__ConnectionReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3547:1: ( rule__ConnectionReference__Group__0__Impl rule__ConnectionReference__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3548:2: rule__ConnectionReference__Group__0__Impl rule__ConnectionReference__Group__1
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__0__Impl_in_rule__ConnectionReference__Group__07233);
            rule__ConnectionReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__1_in_rule__ConnectionReference__Group__07236);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3555:1: rule__ConnectionReference__Group__0__Impl : ( ( rule__ConnectionReference__SourceAssignment_0 ) ) ;
    public final void rule__ConnectionReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3559:1: ( ( ( rule__ConnectionReference__SourceAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3560:1: ( ( rule__ConnectionReference__SourceAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3560:1: ( ( rule__ConnectionReference__SourceAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3561:1: ( rule__ConnectionReference__SourceAssignment_0 )
            {
             before(grammarAccess.getConnectionReferenceAccess().getSourceAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3562:1: ( rule__ConnectionReference__SourceAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3562:2: rule__ConnectionReference__SourceAssignment_0
            {
            pushFollow(FOLLOW_rule__ConnectionReference__SourceAssignment_0_in_rule__ConnectionReference__Group__0__Impl7263);
            rule__ConnectionReference__SourceAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getConnectionReferenceAccess().getSourceAssignment_0()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3572:1: rule__ConnectionReference__Group__1 : rule__ConnectionReference__Group__1__Impl rule__ConnectionReference__Group__2 ;
    public final void rule__ConnectionReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3576:1: ( rule__ConnectionReference__Group__1__Impl rule__ConnectionReference__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3577:2: rule__ConnectionReference__Group__1__Impl rule__ConnectionReference__Group__2
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__1__Impl_in_rule__ConnectionReference__Group__17293);
            rule__ConnectionReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__2_in_rule__ConnectionReference__Group__17296);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3584:1: rule__ConnectionReference__Group__1__Impl : ( '->' ) ;
    public final void rule__ConnectionReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3588:1: ( ( '->' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3589:1: ( '->' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3589:1: ( '->' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3590:1: '->'
            {
             before(grammarAccess.getConnectionReferenceAccess().getHyphenMinusGreaterThanSignKeyword_1()); 
            match(input,9,FOLLOW_9_in_rule__ConnectionReference__Group__1__Impl7324); 
             after(grammarAccess.getConnectionReferenceAccess().getHyphenMinusGreaterThanSignKeyword_1()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3603:1: rule__ConnectionReference__Group__2 : rule__ConnectionReference__Group__2__Impl rule__ConnectionReference__Group__3 ;
    public final void rule__ConnectionReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3607:1: ( rule__ConnectionReference__Group__2__Impl rule__ConnectionReference__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3608:2: rule__ConnectionReference__Group__2__Impl rule__ConnectionReference__Group__3
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__2__Impl_in_rule__ConnectionReference__Group__27355);
            rule__ConnectionReference__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__3_in_rule__ConnectionReference__Group__27358);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3615:1: rule__ConnectionReference__Group__2__Impl : ( ( rule__ConnectionReference__DestinationAssignment_2 ) ) ;
    public final void rule__ConnectionReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3619:1: ( ( ( rule__ConnectionReference__DestinationAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3620:1: ( ( rule__ConnectionReference__DestinationAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3620:1: ( ( rule__ConnectionReference__DestinationAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3621:1: ( rule__ConnectionReference__DestinationAssignment_2 )
            {
             before(grammarAccess.getConnectionReferenceAccess().getDestinationAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3622:1: ( rule__ConnectionReference__DestinationAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3622:2: rule__ConnectionReference__DestinationAssignment_2
            {
            pushFollow(FOLLOW_rule__ConnectionReference__DestinationAssignment_2_in_rule__ConnectionReference__Group__2__Impl7385);
            rule__ConnectionReference__DestinationAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getConnectionReferenceAccess().getDestinationAssignment_2()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3632:1: rule__ConnectionReference__Group__3 : rule__ConnectionReference__Group__3__Impl rule__ConnectionReference__Group__4 ;
    public final void rule__ConnectionReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3636:1: ( rule__ConnectionReference__Group__3__Impl rule__ConnectionReference__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3637:2: rule__ConnectionReference__Group__3__Impl rule__ConnectionReference__Group__4
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__3__Impl_in_rule__ConnectionReference__Group__37415);
            rule__ConnectionReference__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__4_in_rule__ConnectionReference__Group__37418);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3644:1: rule__ConnectionReference__Group__3__Impl : ( ':' ) ;
    public final void rule__ConnectionReference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3648:1: ( ( ':' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3649:1: ( ':' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3649:1: ( ':' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3650:1: ':'
            {
             before(grammarAccess.getConnectionReferenceAccess().getColonKeyword_3()); 
            match(input,38,FOLLOW_38_in_rule__ConnectionReference__Group__3__Impl7446); 
             after(grammarAccess.getConnectionReferenceAccess().getColonKeyword_3()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3663:1: rule__ConnectionReference__Group__4 : rule__ConnectionReference__Group__4__Impl rule__ConnectionReference__Group__5 ;
    public final void rule__ConnectionReference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3667:1: ( rule__ConnectionReference__Group__4__Impl rule__ConnectionReference__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3668:2: rule__ConnectionReference__Group__4__Impl rule__ConnectionReference__Group__5
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__4__Impl_in_rule__ConnectionReference__Group__47477);
            rule__ConnectionReference__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__5_in_rule__ConnectionReference__Group__47480);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3675:1: rule__ConnectionReference__Group__4__Impl : ( ( rule__ConnectionReference__ConnectionAssignment_4 ) ) ;
    public final void rule__ConnectionReference__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3679:1: ( ( ( rule__ConnectionReference__ConnectionAssignment_4 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3680:1: ( ( rule__ConnectionReference__ConnectionAssignment_4 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3680:1: ( ( rule__ConnectionReference__ConnectionAssignment_4 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3681:1: ( rule__ConnectionReference__ConnectionAssignment_4 )
            {
             before(grammarAccess.getConnectionReferenceAccess().getConnectionAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3682:1: ( rule__ConnectionReference__ConnectionAssignment_4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3682:2: rule__ConnectionReference__ConnectionAssignment_4
            {
            pushFollow(FOLLOW_rule__ConnectionReference__ConnectionAssignment_4_in_rule__ConnectionReference__Group__4__Impl7507);
            rule__ConnectionReference__ConnectionAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getConnectionReferenceAccess().getConnectionAssignment_4()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3692:1: rule__ConnectionReference__Group__5 : rule__ConnectionReference__Group__5__Impl rule__ConnectionReference__Group__6 ;
    public final void rule__ConnectionReference__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3696:1: ( rule__ConnectionReference__Group__5__Impl rule__ConnectionReference__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3697:2: rule__ConnectionReference__Group__5__Impl rule__ConnectionReference__Group__6
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__5__Impl_in_rule__ConnectionReference__Group__57537);
            rule__ConnectionReference__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__6_in_rule__ConnectionReference__Group__57540);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3704:1: rule__ConnectionReference__Group__5__Impl : ( 'in' ) ;
    public final void rule__ConnectionReference__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3708:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3709:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3709:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3710:1: 'in'
            {
             before(grammarAccess.getConnectionReferenceAccess().getInKeyword_5()); 
            match(input,10,FOLLOW_10_in_rule__ConnectionReference__Group__5__Impl7568); 
             after(grammarAccess.getConnectionReferenceAccess().getInKeyword_5()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3723:1: rule__ConnectionReference__Group__6 : rule__ConnectionReference__Group__6__Impl ;
    public final void rule__ConnectionReference__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3727:1: ( rule__ConnectionReference__Group__6__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3728:2: rule__ConnectionReference__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__6__Impl_in_rule__ConnectionReference__Group__67599);
            rule__ConnectionReference__Group__6__Impl();

            state._fsp--;


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3734:1: rule__ConnectionReference__Group__6__Impl : ( ( rule__ConnectionReference__ContextAssignment_6 ) ) ;
    public final void rule__ConnectionReference__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3738:1: ( ( ( rule__ConnectionReference__ContextAssignment_6 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3739:1: ( ( rule__ConnectionReference__ContextAssignment_6 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3739:1: ( ( rule__ConnectionReference__ContextAssignment_6 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3740:1: ( rule__ConnectionReference__ContextAssignment_6 )
            {
             before(grammarAccess.getConnectionReferenceAccess().getContextAssignment_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3741:1: ( rule__ConnectionReference__ContextAssignment_6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3741:2: rule__ConnectionReference__ContextAssignment_6
            {
            pushFollow(FOLLOW_rule__ConnectionReference__ContextAssignment_6_in_rule__ConnectionReference__Group__6__Impl7626);
            rule__ConnectionReference__ContextAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getConnectionReferenceAccess().getContextAssignment_6()); 

            }


            }

        }
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


    // $ANTLR start "rule__FlowSpecificationInstance__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3765:1: rule__FlowSpecificationInstance__Group__0 : rule__FlowSpecificationInstance__Group__0__Impl rule__FlowSpecificationInstance__Group__1 ;
    public final void rule__FlowSpecificationInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3769:1: ( rule__FlowSpecificationInstance__Group__0__Impl rule__FlowSpecificationInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3770:2: rule__FlowSpecificationInstance__Group__0__Impl rule__FlowSpecificationInstance__Group__1
            {
            pushFollow(FOLLOW_rule__FlowSpecificationInstance__Group__0__Impl_in_rule__FlowSpecificationInstance__Group__07670);
            rule__FlowSpecificationInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecificationInstance__Group__1_in_rule__FlowSpecificationInstance__Group__07673);
            rule__FlowSpecificationInstance__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecificationInstance__Group__0"


    // $ANTLR start "rule__FlowSpecificationInstance__Group__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3777:1: rule__FlowSpecificationInstance__Group__0__Impl : ( 'flow' ) ;
    public final void rule__FlowSpecificationInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3781:1: ( ( 'flow' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3782:1: ( 'flow' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3782:1: ( 'flow' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3783:1: 'flow'
            {
             before(grammarAccess.getFlowSpecificationInstanceAccess().getFlowKeyword_0()); 
            match(input,49,FOLLOW_49_in_rule__FlowSpecificationInstance__Group__0__Impl7701); 
             after(grammarAccess.getFlowSpecificationInstanceAccess().getFlowKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecificationInstance__Group__0__Impl"


    // $ANTLR start "rule__FlowSpecificationInstance__Group__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3796:1: rule__FlowSpecificationInstance__Group__1 : rule__FlowSpecificationInstance__Group__1__Impl rule__FlowSpecificationInstance__Group__2 ;
    public final void rule__FlowSpecificationInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3800:1: ( rule__FlowSpecificationInstance__Group__1__Impl rule__FlowSpecificationInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3801:2: rule__FlowSpecificationInstance__Group__1__Impl rule__FlowSpecificationInstance__Group__2
            {
            pushFollow(FOLLOW_rule__FlowSpecificationInstance__Group__1__Impl_in_rule__FlowSpecificationInstance__Group__17732);
            rule__FlowSpecificationInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecificationInstance__Group__2_in_rule__FlowSpecificationInstance__Group__17735);
            rule__FlowSpecificationInstance__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecificationInstance__Group__1"


    // $ANTLR start "rule__FlowSpecificationInstance__Group__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3808:1: rule__FlowSpecificationInstance__Group__1__Impl : ( ( rule__FlowSpecificationInstance__NameAssignment_1 ) ) ;
    public final void rule__FlowSpecificationInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3812:1: ( ( ( rule__FlowSpecificationInstance__NameAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3813:1: ( ( rule__FlowSpecificationInstance__NameAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3813:1: ( ( rule__FlowSpecificationInstance__NameAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3814:1: ( rule__FlowSpecificationInstance__NameAssignment_1 )
            {
             before(grammarAccess.getFlowSpecificationInstanceAccess().getNameAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3815:1: ( rule__FlowSpecificationInstance__NameAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3815:2: rule__FlowSpecificationInstance__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__FlowSpecificationInstance__NameAssignment_1_in_rule__FlowSpecificationInstance__Group__1__Impl7762);
            rule__FlowSpecificationInstance__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFlowSpecificationInstanceAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecificationInstance__Group__1__Impl"


    // $ANTLR start "rule__FlowSpecificationInstance__Group__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3825:1: rule__FlowSpecificationInstance__Group__2 : rule__FlowSpecificationInstance__Group__2__Impl rule__FlowSpecificationInstance__Group__3 ;
    public final void rule__FlowSpecificationInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3829:1: ( rule__FlowSpecificationInstance__Group__2__Impl rule__FlowSpecificationInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3830:2: rule__FlowSpecificationInstance__Group__2__Impl rule__FlowSpecificationInstance__Group__3
            {
            pushFollow(FOLLOW_rule__FlowSpecificationInstance__Group__2__Impl_in_rule__FlowSpecificationInstance__Group__27792);
            rule__FlowSpecificationInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecificationInstance__Group__3_in_rule__FlowSpecificationInstance__Group__27795);
            rule__FlowSpecificationInstance__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecificationInstance__Group__2"


    // $ANTLR start "rule__FlowSpecificationInstance__Group__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3837:1: rule__FlowSpecificationInstance__Group__2__Impl : ( '(' ) ;
    public final void rule__FlowSpecificationInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3841:1: ( ( '(' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3842:1: ( '(' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3842:1: ( '(' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3843:1: '('
            {
             before(grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_2()); 
            match(input,45,FOLLOW_45_in_rule__FlowSpecificationInstance__Group__2__Impl7823); 
             after(grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecificationInstance__Group__2__Impl"


    // $ANTLR start "rule__FlowSpecificationInstance__Group__3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3856:1: rule__FlowSpecificationInstance__Group__3 : rule__FlowSpecificationInstance__Group__3__Impl rule__FlowSpecificationInstance__Group__4 ;
    public final void rule__FlowSpecificationInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3860:1: ( rule__FlowSpecificationInstance__Group__3__Impl rule__FlowSpecificationInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3861:2: rule__FlowSpecificationInstance__Group__3__Impl rule__FlowSpecificationInstance__Group__4
            {
            pushFollow(FOLLOW_rule__FlowSpecificationInstance__Group__3__Impl_in_rule__FlowSpecificationInstance__Group__37854);
            rule__FlowSpecificationInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecificationInstance__Group__4_in_rule__FlowSpecificationInstance__Group__37857);
            rule__FlowSpecificationInstance__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecificationInstance__Group__3"


    // $ANTLR start "rule__FlowSpecificationInstance__Group__3__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3868:1: rule__FlowSpecificationInstance__Group__3__Impl : ( ( rule__FlowSpecificationInstance__SourceAssignment_3 )? ) ;
    public final void rule__FlowSpecificationInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3872:1: ( ( ( rule__FlowSpecificationInstance__SourceAssignment_3 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3873:1: ( ( rule__FlowSpecificationInstance__SourceAssignment_3 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3873:1: ( ( rule__FlowSpecificationInstance__SourceAssignment_3 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3874:1: ( rule__FlowSpecificationInstance__SourceAssignment_3 )?
            {
             before(grammarAccess.getFlowSpecificationInstanceAccess().getSourceAssignment_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3875:1: ( rule__FlowSpecificationInstance__SourceAssignment_3 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3875:2: rule__FlowSpecificationInstance__SourceAssignment_3
                    {
                    pushFollow(FOLLOW_rule__FlowSpecificationInstance__SourceAssignment_3_in_rule__FlowSpecificationInstance__Group__3__Impl7884);
                    rule__FlowSpecificationInstance__SourceAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFlowSpecificationInstanceAccess().getSourceAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecificationInstance__Group__3__Impl"


    // $ANTLR start "rule__FlowSpecificationInstance__Group__4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3885:1: rule__FlowSpecificationInstance__Group__4 : rule__FlowSpecificationInstance__Group__4__Impl rule__FlowSpecificationInstance__Group__5 ;
    public final void rule__FlowSpecificationInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3889:1: ( rule__FlowSpecificationInstance__Group__4__Impl rule__FlowSpecificationInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3890:2: rule__FlowSpecificationInstance__Group__4__Impl rule__FlowSpecificationInstance__Group__5
            {
            pushFollow(FOLLOW_rule__FlowSpecificationInstance__Group__4__Impl_in_rule__FlowSpecificationInstance__Group__47915);
            rule__FlowSpecificationInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecificationInstance__Group__5_in_rule__FlowSpecificationInstance__Group__47918);
            rule__FlowSpecificationInstance__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecificationInstance__Group__4"


    // $ANTLR start "rule__FlowSpecificationInstance__Group__4__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3897:1: rule__FlowSpecificationInstance__Group__4__Impl : ( '->' ) ;
    public final void rule__FlowSpecificationInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3901:1: ( ( '->' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3902:1: ( '->' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3902:1: ( '->' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3903:1: '->'
            {
             before(grammarAccess.getFlowSpecificationInstanceAccess().getHyphenMinusGreaterThanSignKeyword_4()); 
            match(input,9,FOLLOW_9_in_rule__FlowSpecificationInstance__Group__4__Impl7946); 
             after(grammarAccess.getFlowSpecificationInstanceAccess().getHyphenMinusGreaterThanSignKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecificationInstance__Group__4__Impl"


    // $ANTLR start "rule__FlowSpecificationInstance__Group__5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3916:1: rule__FlowSpecificationInstance__Group__5 : rule__FlowSpecificationInstance__Group__5__Impl rule__FlowSpecificationInstance__Group__6 ;
    public final void rule__FlowSpecificationInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3920:1: ( rule__FlowSpecificationInstance__Group__5__Impl rule__FlowSpecificationInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3921:2: rule__FlowSpecificationInstance__Group__5__Impl rule__FlowSpecificationInstance__Group__6
            {
            pushFollow(FOLLOW_rule__FlowSpecificationInstance__Group__5__Impl_in_rule__FlowSpecificationInstance__Group__57977);
            rule__FlowSpecificationInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecificationInstance__Group__6_in_rule__FlowSpecificationInstance__Group__57980);
            rule__FlowSpecificationInstance__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecificationInstance__Group__5"


    // $ANTLR start "rule__FlowSpecificationInstance__Group__5__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3928:1: rule__FlowSpecificationInstance__Group__5__Impl : ( ( rule__FlowSpecificationInstance__DestinationAssignment_5 )? ) ;
    public final void rule__FlowSpecificationInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3932:1: ( ( ( rule__FlowSpecificationInstance__DestinationAssignment_5 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3933:1: ( ( rule__FlowSpecificationInstance__DestinationAssignment_5 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3933:1: ( ( rule__FlowSpecificationInstance__DestinationAssignment_5 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3934:1: ( rule__FlowSpecificationInstance__DestinationAssignment_5 )?
            {
             before(grammarAccess.getFlowSpecificationInstanceAccess().getDestinationAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3935:1: ( rule__FlowSpecificationInstance__DestinationAssignment_5 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_ID) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3935:2: rule__FlowSpecificationInstance__DestinationAssignment_5
                    {
                    pushFollow(FOLLOW_rule__FlowSpecificationInstance__DestinationAssignment_5_in_rule__FlowSpecificationInstance__Group__5__Impl8007);
                    rule__FlowSpecificationInstance__DestinationAssignment_5();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFlowSpecificationInstanceAccess().getDestinationAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecificationInstance__Group__5__Impl"


    // $ANTLR start "rule__FlowSpecificationInstance__Group__6"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3945:1: rule__FlowSpecificationInstance__Group__6 : rule__FlowSpecificationInstance__Group__6__Impl rule__FlowSpecificationInstance__Group__7 ;
    public final void rule__FlowSpecificationInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3949:1: ( rule__FlowSpecificationInstance__Group__6__Impl rule__FlowSpecificationInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3950:2: rule__FlowSpecificationInstance__Group__6__Impl rule__FlowSpecificationInstance__Group__7
            {
            pushFollow(FOLLOW_rule__FlowSpecificationInstance__Group__6__Impl_in_rule__FlowSpecificationInstance__Group__68038);
            rule__FlowSpecificationInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecificationInstance__Group__7_in_rule__FlowSpecificationInstance__Group__68041);
            rule__FlowSpecificationInstance__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecificationInstance__Group__6"


    // $ANTLR start "rule__FlowSpecificationInstance__Group__6__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3957:1: rule__FlowSpecificationInstance__Group__6__Impl : ( ')' ) ;
    public final void rule__FlowSpecificationInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3961:1: ( ( ')' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3962:1: ( ')' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3962:1: ( ')' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3963:1: ')'
            {
             before(grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_6()); 
            match(input,46,FOLLOW_46_in_rule__FlowSpecificationInstance__Group__6__Impl8069); 
             after(grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecificationInstance__Group__6__Impl"


    // $ANTLR start "rule__FlowSpecificationInstance__Group__7"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3976:1: rule__FlowSpecificationInstance__Group__7 : rule__FlowSpecificationInstance__Group__7__Impl rule__FlowSpecificationInstance__Group__8 ;
    public final void rule__FlowSpecificationInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3980:1: ( rule__FlowSpecificationInstance__Group__7__Impl rule__FlowSpecificationInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3981:2: rule__FlowSpecificationInstance__Group__7__Impl rule__FlowSpecificationInstance__Group__8
            {
            pushFollow(FOLLOW_rule__FlowSpecificationInstance__Group__7__Impl_in_rule__FlowSpecificationInstance__Group__78100);
            rule__FlowSpecificationInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FlowSpecificationInstance__Group__8_in_rule__FlowSpecificationInstance__Group__78103);
            rule__FlowSpecificationInstance__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecificationInstance__Group__7"


    // $ANTLR start "rule__FlowSpecificationInstance__Group__7__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3988:1: rule__FlowSpecificationInstance__Group__7__Impl : ( ':' ) ;
    public final void rule__FlowSpecificationInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3992:1: ( ( ':' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3993:1: ( ':' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3993:1: ( ':' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3994:1: ':'
            {
             before(grammarAccess.getFlowSpecificationInstanceAccess().getColonKeyword_7()); 
            match(input,38,FOLLOW_38_in_rule__FlowSpecificationInstance__Group__7__Impl8131); 
             after(grammarAccess.getFlowSpecificationInstanceAccess().getColonKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecificationInstance__Group__7__Impl"


    // $ANTLR start "rule__FlowSpecificationInstance__Group__8"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4007:1: rule__FlowSpecificationInstance__Group__8 : rule__FlowSpecificationInstance__Group__8__Impl ;
    public final void rule__FlowSpecificationInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4011:1: ( rule__FlowSpecificationInstance__Group__8__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4012:2: rule__FlowSpecificationInstance__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__FlowSpecificationInstance__Group__8__Impl_in_rule__FlowSpecificationInstance__Group__88162);
            rule__FlowSpecificationInstance__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecificationInstance__Group__8"


    // $ANTLR start "rule__FlowSpecificationInstance__Group__8__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4018:1: rule__FlowSpecificationInstance__Group__8__Impl : ( ( rule__FlowSpecificationInstance__FlowSpecificationAssignment_8 ) ) ;
    public final void rule__FlowSpecificationInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4022:1: ( ( ( rule__FlowSpecificationInstance__FlowSpecificationAssignment_8 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4023:1: ( ( rule__FlowSpecificationInstance__FlowSpecificationAssignment_8 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4023:1: ( ( rule__FlowSpecificationInstance__FlowSpecificationAssignment_8 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4024:1: ( rule__FlowSpecificationInstance__FlowSpecificationAssignment_8 )
            {
             before(grammarAccess.getFlowSpecificationInstanceAccess().getFlowSpecificationAssignment_8()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4025:1: ( rule__FlowSpecificationInstance__FlowSpecificationAssignment_8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4025:2: rule__FlowSpecificationInstance__FlowSpecificationAssignment_8
            {
            pushFollow(FOLLOW_rule__FlowSpecificationInstance__FlowSpecificationAssignment_8_in_rule__FlowSpecificationInstance__Group__8__Impl8189);
            rule__FlowSpecificationInstance__FlowSpecificationAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getFlowSpecificationInstanceAccess().getFlowSpecificationAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecificationInstance__Group__8__Impl"


    // $ANTLR start "rule__SystemOperationMode__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4053:1: rule__SystemOperationMode__Group__0 : rule__SystemOperationMode__Group__0__Impl rule__SystemOperationMode__Group__1 ;
    public final void rule__SystemOperationMode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4057:1: ( rule__SystemOperationMode__Group__0__Impl rule__SystemOperationMode__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4058:2: rule__SystemOperationMode__Group__0__Impl rule__SystemOperationMode__Group__1
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__Group__0__Impl_in_rule__SystemOperationMode__Group__08237);
            rule__SystemOperationMode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemOperationMode__Group__1_in_rule__SystemOperationMode__Group__08240);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4065:1: rule__SystemOperationMode__Group__0__Impl : ( 'som' ) ;
    public final void rule__SystemOperationMode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4069:1: ( ( 'som' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4070:1: ( 'som' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4070:1: ( 'som' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4071:1: 'som'
            {
             before(grammarAccess.getSystemOperationModeAccess().getSomKeyword_0()); 
            match(input,50,FOLLOW_50_in_rule__SystemOperationMode__Group__0__Impl8268); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4084:1: rule__SystemOperationMode__Group__1 : rule__SystemOperationMode__Group__1__Impl ;
    public final void rule__SystemOperationMode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4088:1: ( rule__SystemOperationMode__Group__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4089:2: rule__SystemOperationMode__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__Group__1__Impl_in_rule__SystemOperationMode__Group__18299);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4095:1: rule__SystemOperationMode__Group__1__Impl : ( ( rule__SystemOperationMode__NameAssignment_1 ) ) ;
    public final void rule__SystemOperationMode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4099:1: ( ( ( rule__SystemOperationMode__NameAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4100:1: ( ( rule__SystemOperationMode__NameAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4100:1: ( ( rule__SystemOperationMode__NameAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4101:1: ( rule__SystemOperationMode__NameAssignment_1 )
            {
             before(grammarAccess.getSystemOperationModeAccess().getNameAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4102:1: ( rule__SystemOperationMode__NameAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4102:2: rule__SystemOperationMode__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__NameAssignment_1_in_rule__SystemOperationMode__Group__1__Impl8326);
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


    // $ANTLR start "rule__DirectionType__Group_2__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4116:1: rule__DirectionType__Group_2__0 : rule__DirectionType__Group_2__0__Impl rule__DirectionType__Group_2__1 ;
    public final void rule__DirectionType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4120:1: ( rule__DirectionType__Group_2__0__Impl rule__DirectionType__Group_2__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4121:2: rule__DirectionType__Group_2__0__Impl rule__DirectionType__Group_2__1
            {
            pushFollow(FOLLOW_rule__DirectionType__Group_2__0__Impl_in_rule__DirectionType__Group_2__08360);
            rule__DirectionType__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DirectionType__Group_2__1_in_rule__DirectionType__Group_2__08363);
            rule__DirectionType__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DirectionType__Group_2__0"


    // $ANTLR start "rule__DirectionType__Group_2__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4128:1: rule__DirectionType__Group_2__0__Impl : ( 'in' ) ;
    public final void rule__DirectionType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4132:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4133:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4133:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4134:1: 'in'
            {
             before(grammarAccess.getDirectionTypeAccess().getInKeyword_2_0()); 
            match(input,10,FOLLOW_10_in_rule__DirectionType__Group_2__0__Impl8391); 
             after(grammarAccess.getDirectionTypeAccess().getInKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DirectionType__Group_2__0__Impl"


    // $ANTLR start "rule__DirectionType__Group_2__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4147:1: rule__DirectionType__Group_2__1 : rule__DirectionType__Group_2__1__Impl ;
    public final void rule__DirectionType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4151:1: ( rule__DirectionType__Group_2__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4152:2: rule__DirectionType__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__DirectionType__Group_2__1__Impl_in_rule__DirectionType__Group_2__18422);
            rule__DirectionType__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DirectionType__Group_2__1"


    // $ANTLR start "rule__DirectionType__Group_2__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4158:1: rule__DirectionType__Group_2__1__Impl : ( 'out' ) ;
    public final void rule__DirectionType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4162:1: ( ( 'out' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4163:1: ( 'out' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4163:1: ( 'out' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4164:1: 'out'
            {
             before(grammarAccess.getDirectionTypeAccess().getOutKeyword_2_1()); 
            match(input,11,FOLLOW_11_in_rule__DirectionType__Group_2__1__Impl8450); 
             after(grammarAccess.getDirectionTypeAccess().getOutKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DirectionType__Group_2__1__Impl"


    // $ANTLR start "rule__ComponentCategory__Group_8__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4181:1: rule__ComponentCategory__Group_8__0 : rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1 ;
    public final void rule__ComponentCategory__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4185:1: ( rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4186:2: rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_8__0__Impl_in_rule__ComponentCategory__Group_8__08485);
            rule__ComponentCategory__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_8__1_in_rule__ComponentCategory__Group_8__08488);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4193:1: rule__ComponentCategory__Group_8__0__Impl : ( 'subprogram' ) ;
    public final void rule__ComponentCategory__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4197:1: ( ( 'subprogram' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4198:1: ( 'subprogram' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4198:1: ( 'subprogram' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4199:1: 'subprogram'
            {
             before(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
            match(input,28,FOLLOW_28_in_rule__ComponentCategory__Group_8__0__Impl8516); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4212:1: rule__ComponentCategory__Group_8__1 : rule__ComponentCategory__Group_8__1__Impl ;
    public final void rule__ComponentCategory__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4216:1: ( rule__ComponentCategory__Group_8__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4217:2: rule__ComponentCategory__Group_8__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_8__1__Impl_in_rule__ComponentCategory__Group_8__18547);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4223:1: rule__ComponentCategory__Group_8__1__Impl : ( 'group' ) ;
    public final void rule__ComponentCategory__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4227:1: ( ( 'group' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4228:1: ( 'group' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4228:1: ( 'group' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4229:1: 'group'
            {
             before(grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
            match(input,51,FOLLOW_51_in_rule__ComponentCategory__Group_8__1__Impl8575); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4246:1: rule__ComponentCategory__Group_10__0 : rule__ComponentCategory__Group_10__0__Impl rule__ComponentCategory__Group_10__1 ;
    public final void rule__ComponentCategory__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4250:1: ( rule__ComponentCategory__Group_10__0__Impl rule__ComponentCategory__Group_10__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4251:2: rule__ComponentCategory__Group_10__0__Impl rule__ComponentCategory__Group_10__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_10__0__Impl_in_rule__ComponentCategory__Group_10__08610);
            rule__ComponentCategory__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_10__1_in_rule__ComponentCategory__Group_10__08613);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4258:1: rule__ComponentCategory__Group_10__0__Impl : ( 'thread' ) ;
    public final void rule__ComponentCategory__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4262:1: ( ( 'thread' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4263:1: ( 'thread' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4263:1: ( 'thread' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4264:1: 'thread'
            {
             before(grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); 
            match(input,30,FOLLOW_30_in_rule__ComponentCategory__Group_10__0__Impl8641); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4277:1: rule__ComponentCategory__Group_10__1 : rule__ComponentCategory__Group_10__1__Impl ;
    public final void rule__ComponentCategory__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4281:1: ( rule__ComponentCategory__Group_10__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4282:2: rule__ComponentCategory__Group_10__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_10__1__Impl_in_rule__ComponentCategory__Group_10__18672);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4288:1: rule__ComponentCategory__Group_10__1__Impl : ( 'group' ) ;
    public final void rule__ComponentCategory__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4292:1: ( ( 'group' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4293:1: ( 'group' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4293:1: ( 'group' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4294:1: 'group'
            {
             before(grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); 
            match(input,51,FOLLOW_51_in_rule__ComponentCategory__Group_10__1__Impl8700); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4311:1: rule__ComponentCategory__Group_12__0 : rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1 ;
    public final void rule__ComponentCategory__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4315:1: ( rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4316:2: rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_12__0__Impl_in_rule__ComponentCategory__Group_12__08735);
            rule__ComponentCategory__Group_12__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_12__1_in_rule__ComponentCategory__Group_12__08738);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4323:1: rule__ComponentCategory__Group_12__0__Impl : ( 'virtual' ) ;
    public final void rule__ComponentCategory__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4327:1: ( ( 'virtual' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4328:1: ( 'virtual' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4328:1: ( 'virtual' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4329:1: 'virtual'
            {
             before(grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
            match(input,52,FOLLOW_52_in_rule__ComponentCategory__Group_12__0__Impl8766); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4342:1: rule__ComponentCategory__Group_12__1 : rule__ComponentCategory__Group_12__1__Impl ;
    public final void rule__ComponentCategory__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4346:1: ( rule__ComponentCategory__Group_12__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4347:2: rule__ComponentCategory__Group_12__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_12__1__Impl_in_rule__ComponentCategory__Group_12__18797);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4353:1: rule__ComponentCategory__Group_12__1__Impl : ( 'bus' ) ;
    public final void rule__ComponentCategory__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4357:1: ( ( 'bus' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4358:1: ( 'bus' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4358:1: ( 'bus' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4359:1: 'bus'
            {
             before(grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
            match(input,22,FOLLOW_22_in_rule__ComponentCategory__Group_12__1__Impl8825); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4376:1: rule__ComponentCategory__Group_13__0 : rule__ComponentCategory__Group_13__0__Impl rule__ComponentCategory__Group_13__1 ;
    public final void rule__ComponentCategory__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4380:1: ( rule__ComponentCategory__Group_13__0__Impl rule__ComponentCategory__Group_13__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4381:2: rule__ComponentCategory__Group_13__0__Impl rule__ComponentCategory__Group_13__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_13__0__Impl_in_rule__ComponentCategory__Group_13__08860);
            rule__ComponentCategory__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_13__1_in_rule__ComponentCategory__Group_13__08863);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4388:1: rule__ComponentCategory__Group_13__0__Impl : ( 'virtual' ) ;
    public final void rule__ComponentCategory__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4392:1: ( ( 'virtual' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4393:1: ( 'virtual' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4393:1: ( 'virtual' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4394:1: 'virtual'
            {
             before(grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); 
            match(input,52,FOLLOW_52_in_rule__ComponentCategory__Group_13__0__Impl8891); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4407:1: rule__ComponentCategory__Group_13__1 : rule__ComponentCategory__Group_13__1__Impl ;
    public final void rule__ComponentCategory__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4411:1: ( rule__ComponentCategory__Group_13__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4412:2: rule__ComponentCategory__Group_13__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_13__1__Impl_in_rule__ComponentCategory__Group_13__18922);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4418:1: rule__ComponentCategory__Group_13__1__Impl : ( 'processor' ) ;
    public final void rule__ComponentCategory__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4422:1: ( ( 'processor' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4423:1: ( 'processor' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4423:1: ( 'processor' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4424:1: 'processor'
            {
             before(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_13_1()); 
            match(input,27,FOLLOW_27_in_rule__ComponentCategory__Group_13__1__Impl8950); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4441:1: rule__IMPLREF__Group__0 : rule__IMPLREF__Group__0__Impl rule__IMPLREF__Group__1 ;
    public final void rule__IMPLREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4445:1: ( rule__IMPLREF__Group__0__Impl rule__IMPLREF__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4446:2: rule__IMPLREF__Group__0__Impl rule__IMPLREF__Group__1
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group__0__Impl_in_rule__IMPLREF__Group__08985);
            rule__IMPLREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IMPLREF__Group__1_in_rule__IMPLREF__Group__08988);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4453:1: rule__IMPLREF__Group__0__Impl : ( ( ( rule__IMPLREF__Group_0__0 ) ) ( ( rule__IMPLREF__Group_0__0 )* ) ) ;
    public final void rule__IMPLREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4457:1: ( ( ( ( rule__IMPLREF__Group_0__0 ) ) ( ( rule__IMPLREF__Group_0__0 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4458:1: ( ( ( rule__IMPLREF__Group_0__0 ) ) ( ( rule__IMPLREF__Group_0__0 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4458:1: ( ( ( rule__IMPLREF__Group_0__0 ) ) ( ( rule__IMPLREF__Group_0__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4459:1: ( ( rule__IMPLREF__Group_0__0 ) ) ( ( rule__IMPLREF__Group_0__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4459:1: ( ( rule__IMPLREF__Group_0__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4460:1: ( rule__IMPLREF__Group_0__0 )
            {
             before(grammarAccess.getIMPLREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4461:1: ( rule__IMPLREF__Group_0__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4461:2: rule__IMPLREF__Group_0__0
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group_0__0_in_rule__IMPLREF__Group__0__Impl9017);
            rule__IMPLREF__Group_0__0();

            state._fsp--;


            }

             after(grammarAccess.getIMPLREFAccess().getGroup_0()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4464:1: ( ( rule__IMPLREF__Group_0__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4465:1: ( rule__IMPLREF__Group_0__0 )*
            {
             before(grammarAccess.getIMPLREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4466:1: ( rule__IMPLREF__Group_0__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID) ) {
                    int LA32_1 = input.LA(2);

                    if ( (LA32_1==54) ) {
                        alt32=1;
                    }


                }


                switch (alt32) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4466:2: rule__IMPLREF__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__IMPLREF__Group_0__0_in_rule__IMPLREF__Group__0__Impl9029);
            	    rule__IMPLREF__Group_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4477:1: rule__IMPLREF__Group__1 : rule__IMPLREF__Group__1__Impl rule__IMPLREF__Group__2 ;
    public final void rule__IMPLREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4481:1: ( rule__IMPLREF__Group__1__Impl rule__IMPLREF__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4482:2: rule__IMPLREF__Group__1__Impl rule__IMPLREF__Group__2
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group__1__Impl_in_rule__IMPLREF__Group__19062);
            rule__IMPLREF__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IMPLREF__Group__2_in_rule__IMPLREF__Group__19065);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4489:1: rule__IMPLREF__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__IMPLREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4493:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4494:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4494:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4495:1: RULE_ID
            {
             before(grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IMPLREF__Group__1__Impl9092); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4506:1: rule__IMPLREF__Group__2 : rule__IMPLREF__Group__2__Impl rule__IMPLREF__Group__3 ;
    public final void rule__IMPLREF__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4510:1: ( rule__IMPLREF__Group__2__Impl rule__IMPLREF__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4511:2: rule__IMPLREF__Group__2__Impl rule__IMPLREF__Group__3
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group__2__Impl_in_rule__IMPLREF__Group__29121);
            rule__IMPLREF__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IMPLREF__Group__3_in_rule__IMPLREF__Group__29124);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4518:1: rule__IMPLREF__Group__2__Impl : ( '.' ) ;
    public final void rule__IMPLREF__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4522:1: ( ( '.' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4523:1: ( '.' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4523:1: ( '.' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4524:1: '.'
            {
             before(grammarAccess.getIMPLREFAccess().getFullStopKeyword_2()); 
            match(input,53,FOLLOW_53_in_rule__IMPLREF__Group__2__Impl9152); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4537:1: rule__IMPLREF__Group__3 : rule__IMPLREF__Group__3__Impl ;
    public final void rule__IMPLREF__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4541:1: ( rule__IMPLREF__Group__3__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4542:2: rule__IMPLREF__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group__3__Impl_in_rule__IMPLREF__Group__39183);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4548:1: rule__IMPLREF__Group__3__Impl : ( RULE_ID ) ;
    public final void rule__IMPLREF__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4552:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4553:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4553:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4554:1: RULE_ID
            {
             before(grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_3()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IMPLREF__Group__3__Impl9210); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4573:1: rule__IMPLREF__Group_0__0 : rule__IMPLREF__Group_0__0__Impl rule__IMPLREF__Group_0__1 ;
    public final void rule__IMPLREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4577:1: ( rule__IMPLREF__Group_0__0__Impl rule__IMPLREF__Group_0__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4578:2: rule__IMPLREF__Group_0__0__Impl rule__IMPLREF__Group_0__1
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group_0__0__Impl_in_rule__IMPLREF__Group_0__09247);
            rule__IMPLREF__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IMPLREF__Group_0__1_in_rule__IMPLREF__Group_0__09250);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4585:1: rule__IMPLREF__Group_0__0__Impl : ( RULE_ID ) ;
    public final void rule__IMPLREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4589:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4590:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4590:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4591:1: RULE_ID
            {
             before(grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IMPLREF__Group_0__0__Impl9277); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4602:1: rule__IMPLREF__Group_0__1 : rule__IMPLREF__Group_0__1__Impl ;
    public final void rule__IMPLREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4606:1: ( rule__IMPLREF__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4607:2: rule__IMPLREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group_0__1__Impl_in_rule__IMPLREF__Group_0__19306);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4613:1: rule__IMPLREF__Group_0__1__Impl : ( '::' ) ;
    public final void rule__IMPLREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4617:1: ( ( '::' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4618:1: ( '::' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4618:1: ( '::' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4619:1: '::'
            {
             before(grammarAccess.getIMPLREFAccess().getColonColonKeyword_0_1()); 
            match(input,54,FOLLOW_54_in_rule__IMPLREF__Group_0__1__Impl9334); 
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


    // $ANTLR start "rule__FEATREF__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4636:1: rule__FEATREF__Group__0 : rule__FEATREF__Group__0__Impl rule__FEATREF__Group__1 ;
    public final void rule__FEATREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4640:1: ( rule__FEATREF__Group__0__Impl rule__FEATREF__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4641:2: rule__FEATREF__Group__0__Impl rule__FEATREF__Group__1
            {
            pushFollow(FOLLOW_rule__FEATREF__Group__0__Impl_in_rule__FEATREF__Group__09369);
            rule__FEATREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FEATREF__Group__1_in_rule__FEATREF__Group__09372);
            rule__FEATREF__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEATREF__Group__0"


    // $ANTLR start "rule__FEATREF__Group__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4648:1: rule__FEATREF__Group__0__Impl : ( ( ( rule__FEATREF__Group_0__0 ) ) ( ( rule__FEATREF__Group_0__0 )* ) ) ;
    public final void rule__FEATREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4652:1: ( ( ( ( rule__FEATREF__Group_0__0 ) ) ( ( rule__FEATREF__Group_0__0 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4653:1: ( ( ( rule__FEATREF__Group_0__0 ) ) ( ( rule__FEATREF__Group_0__0 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4653:1: ( ( ( rule__FEATREF__Group_0__0 ) ) ( ( rule__FEATREF__Group_0__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4654:1: ( ( rule__FEATREF__Group_0__0 ) ) ( ( rule__FEATREF__Group_0__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4654:1: ( ( rule__FEATREF__Group_0__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4655:1: ( rule__FEATREF__Group_0__0 )
            {
             before(grammarAccess.getFEATREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4656:1: ( rule__FEATREF__Group_0__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4656:2: rule__FEATREF__Group_0__0
            {
            pushFollow(FOLLOW_rule__FEATREF__Group_0__0_in_rule__FEATREF__Group__0__Impl9401);
            rule__FEATREF__Group_0__0();

            state._fsp--;


            }

             after(grammarAccess.getFEATREFAccess().getGroup_0()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4659:1: ( ( rule__FEATREF__Group_0__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4660:1: ( rule__FEATREF__Group_0__0 )*
            {
             before(grammarAccess.getFEATREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4661:1: ( rule__FEATREF__Group_0__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_ID) ) {
                    int LA33_1 = input.LA(2);

                    if ( (LA33_1==54) ) {
                        int LA33_2 = input.LA(3);

                        if ( (LA33_2==RULE_ID) ) {
                            int LA33_3 = input.LA(4);

                            if ( (LA33_3==54) ) {
                                alt33=1;
                            }


                        }


                    }


                }


                switch (alt33) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4661:2: rule__FEATREF__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__FEATREF__Group_0__0_in_rule__FEATREF__Group__0__Impl9413);
            	    rule__FEATREF__Group_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getFEATREFAccess().getGroup_0()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEATREF__Group__0__Impl"


    // $ANTLR start "rule__FEATREF__Group__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4672:1: rule__FEATREF__Group__1 : rule__FEATREF__Group__1__Impl rule__FEATREF__Group__2 ;
    public final void rule__FEATREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4676:1: ( rule__FEATREF__Group__1__Impl rule__FEATREF__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4677:2: rule__FEATREF__Group__1__Impl rule__FEATREF__Group__2
            {
            pushFollow(FOLLOW_rule__FEATREF__Group__1__Impl_in_rule__FEATREF__Group__19446);
            rule__FEATREF__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FEATREF__Group__2_in_rule__FEATREF__Group__19449);
            rule__FEATREF__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEATREF__Group__1"


    // $ANTLR start "rule__FEATREF__Group__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4684:1: rule__FEATREF__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__FEATREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4688:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4689:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4689:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4690:1: RULE_ID
            {
             before(grammarAccess.getFEATREFAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FEATREF__Group__1__Impl9476); 
             after(grammarAccess.getFEATREFAccess().getIDTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEATREF__Group__1__Impl"


    // $ANTLR start "rule__FEATREF__Group__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4701:1: rule__FEATREF__Group__2 : rule__FEATREF__Group__2__Impl rule__FEATREF__Group__3 ;
    public final void rule__FEATREF__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4705:1: ( rule__FEATREF__Group__2__Impl rule__FEATREF__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4706:2: rule__FEATREF__Group__2__Impl rule__FEATREF__Group__3
            {
            pushFollow(FOLLOW_rule__FEATREF__Group__2__Impl_in_rule__FEATREF__Group__29505);
            rule__FEATREF__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FEATREF__Group__3_in_rule__FEATREF__Group__29508);
            rule__FEATREF__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEATREF__Group__2"


    // $ANTLR start "rule__FEATREF__Group__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4713:1: rule__FEATREF__Group__2__Impl : ( '::' ) ;
    public final void rule__FEATREF__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4717:1: ( ( '::' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4718:1: ( '::' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4718:1: ( '::' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4719:1: '::'
            {
             before(grammarAccess.getFEATREFAccess().getColonColonKeyword_2()); 
            match(input,54,FOLLOW_54_in_rule__FEATREF__Group__2__Impl9536); 
             after(grammarAccess.getFEATREFAccess().getColonColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEATREF__Group__2__Impl"


    // $ANTLR start "rule__FEATREF__Group__3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4732:1: rule__FEATREF__Group__3 : rule__FEATREF__Group__3__Impl ;
    public final void rule__FEATREF__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4736:1: ( rule__FEATREF__Group__3__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4737:2: rule__FEATREF__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__FEATREF__Group__3__Impl_in_rule__FEATREF__Group__39567);
            rule__FEATREF__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEATREF__Group__3"


    // $ANTLR start "rule__FEATREF__Group__3__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4743:1: rule__FEATREF__Group__3__Impl : ( RULE_ID ) ;
    public final void rule__FEATREF__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4747:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4748:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4748:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4749:1: RULE_ID
            {
             before(grammarAccess.getFEATREFAccess().getIDTerminalRuleCall_3()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FEATREF__Group__3__Impl9594); 
             after(grammarAccess.getFEATREFAccess().getIDTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEATREF__Group__3__Impl"


    // $ANTLR start "rule__FEATREF__Group_0__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4768:1: rule__FEATREF__Group_0__0 : rule__FEATREF__Group_0__0__Impl rule__FEATREF__Group_0__1 ;
    public final void rule__FEATREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4772:1: ( rule__FEATREF__Group_0__0__Impl rule__FEATREF__Group_0__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4773:2: rule__FEATREF__Group_0__0__Impl rule__FEATREF__Group_0__1
            {
            pushFollow(FOLLOW_rule__FEATREF__Group_0__0__Impl_in_rule__FEATREF__Group_0__09631);
            rule__FEATREF__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FEATREF__Group_0__1_in_rule__FEATREF__Group_0__09634);
            rule__FEATREF__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEATREF__Group_0__0"


    // $ANTLR start "rule__FEATREF__Group_0__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4780:1: rule__FEATREF__Group_0__0__Impl : ( RULE_ID ) ;
    public final void rule__FEATREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4784:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4785:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4785:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4786:1: RULE_ID
            {
             before(grammarAccess.getFEATREFAccess().getIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FEATREF__Group_0__0__Impl9661); 
             after(grammarAccess.getFEATREFAccess().getIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEATREF__Group_0__0__Impl"


    // $ANTLR start "rule__FEATREF__Group_0__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4797:1: rule__FEATREF__Group_0__1 : rule__FEATREF__Group_0__1__Impl ;
    public final void rule__FEATREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4801:1: ( rule__FEATREF__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4802:2: rule__FEATREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__FEATREF__Group_0__1__Impl_in_rule__FEATREF__Group_0__19690);
            rule__FEATREF__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEATREF__Group_0__1"


    // $ANTLR start "rule__FEATREF__Group_0__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4808:1: rule__FEATREF__Group_0__1__Impl : ( '::' ) ;
    public final void rule__FEATREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4812:1: ( ( '::' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4813:1: ( '::' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4813:1: ( '::' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4814:1: '::'
            {
             before(grammarAccess.getFEATREFAccess().getColonColonKeyword_0_1()); 
            match(input,54,FOLLOW_54_in_rule__FEATREF__Group_0__1__Impl9718); 
             after(grammarAccess.getFEATREFAccess().getColonColonKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEATREF__Group_0__1__Impl"


    // $ANTLR start "rule__SUBREF__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4831:1: rule__SUBREF__Group__0 : rule__SUBREF__Group__0__Impl rule__SUBREF__Group__1 ;
    public final void rule__SUBREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4835:1: ( rule__SUBREF__Group__0__Impl rule__SUBREF__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4836:2: rule__SUBREF__Group__0__Impl rule__SUBREF__Group__1
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__0__Impl_in_rule__SUBREF__Group__09753);
            rule__SUBREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group__1_in_rule__SUBREF__Group__09756);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4843:1: rule__SUBREF__Group__0__Impl : ( ( ( rule__SUBREF__Group_0__0 ) ) ( ( rule__SUBREF__Group_0__0 )* ) ) ;
    public final void rule__SUBREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4847:1: ( ( ( ( rule__SUBREF__Group_0__0 ) ) ( ( rule__SUBREF__Group_0__0 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4848:1: ( ( ( rule__SUBREF__Group_0__0 ) ) ( ( rule__SUBREF__Group_0__0 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4848:1: ( ( ( rule__SUBREF__Group_0__0 ) ) ( ( rule__SUBREF__Group_0__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4849:1: ( ( rule__SUBREF__Group_0__0 ) ) ( ( rule__SUBREF__Group_0__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4849:1: ( ( rule__SUBREF__Group_0__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4850:1: ( rule__SUBREF__Group_0__0 )
            {
             before(grammarAccess.getSUBREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4851:1: ( rule__SUBREF__Group_0__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4851:2: rule__SUBREF__Group_0__0
            {
            pushFollow(FOLLOW_rule__SUBREF__Group_0__0_in_rule__SUBREF__Group__0__Impl9785);
            rule__SUBREF__Group_0__0();

            state._fsp--;


            }

             after(grammarAccess.getSUBREFAccess().getGroup_0()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4854:1: ( ( rule__SUBREF__Group_0__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4855:1: ( rule__SUBREF__Group_0__0 )*
            {
             before(grammarAccess.getSUBREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4856:1: ( rule__SUBREF__Group_0__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_ID) ) {
                    int LA34_1 = input.LA(2);

                    if ( (LA34_1==54) ) {
                        alt34=1;
                    }


                }


                switch (alt34) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4856:2: rule__SUBREF__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__SUBREF__Group_0__0_in_rule__SUBREF__Group__0__Impl9797);
            	    rule__SUBREF__Group_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4867:1: rule__SUBREF__Group__1 : rule__SUBREF__Group__1__Impl rule__SUBREF__Group__2 ;
    public final void rule__SUBREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4871:1: ( rule__SUBREF__Group__1__Impl rule__SUBREF__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4872:2: rule__SUBREF__Group__1__Impl rule__SUBREF__Group__2
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__1__Impl_in_rule__SUBREF__Group__19830);
            rule__SUBREF__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group__2_in_rule__SUBREF__Group__19833);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4879:1: rule__SUBREF__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__SUBREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4883:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4884:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4884:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4885:1: RULE_ID
            {
             before(grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SUBREF__Group__1__Impl9860); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4896:1: rule__SUBREF__Group__2 : rule__SUBREF__Group__2__Impl rule__SUBREF__Group__3 ;
    public final void rule__SUBREF__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4900:1: ( rule__SUBREF__Group__2__Impl rule__SUBREF__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4901:2: rule__SUBREF__Group__2__Impl rule__SUBREF__Group__3
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__2__Impl_in_rule__SUBREF__Group__29889);
            rule__SUBREF__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group__3_in_rule__SUBREF__Group__29892);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4908:1: rule__SUBREF__Group__2__Impl : ( '.' ) ;
    public final void rule__SUBREF__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4912:1: ( ( '.' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4913:1: ( '.' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4913:1: ( '.' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4914:1: '.'
            {
             before(grammarAccess.getSUBREFAccess().getFullStopKeyword_2()); 
            match(input,53,FOLLOW_53_in_rule__SUBREF__Group__2__Impl9920); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4927:1: rule__SUBREF__Group__3 : rule__SUBREF__Group__3__Impl rule__SUBREF__Group__4 ;
    public final void rule__SUBREF__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4931:1: ( rule__SUBREF__Group__3__Impl rule__SUBREF__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4932:2: rule__SUBREF__Group__3__Impl rule__SUBREF__Group__4
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__3__Impl_in_rule__SUBREF__Group__39951);
            rule__SUBREF__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group__4_in_rule__SUBREF__Group__39954);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4939:1: rule__SUBREF__Group__3__Impl : ( RULE_ID ) ;
    public final void rule__SUBREF__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4943:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4944:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4944:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4945:1: RULE_ID
            {
             before(grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_3()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SUBREF__Group__3__Impl9981); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4956:1: rule__SUBREF__Group__4 : rule__SUBREF__Group__4__Impl rule__SUBREF__Group__5 ;
    public final void rule__SUBREF__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4960:1: ( rule__SUBREF__Group__4__Impl rule__SUBREF__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4961:2: rule__SUBREF__Group__4__Impl rule__SUBREF__Group__5
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__4__Impl_in_rule__SUBREF__Group__410010);
            rule__SUBREF__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group__5_in_rule__SUBREF__Group__410013);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4968:1: rule__SUBREF__Group__4__Impl : ( '::' ) ;
    public final void rule__SUBREF__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4972:1: ( ( '::' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4973:1: ( '::' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4973:1: ( '::' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4974:1: '::'
            {
             before(grammarAccess.getSUBREFAccess().getColonColonKeyword_4()); 
            match(input,54,FOLLOW_54_in_rule__SUBREF__Group__4__Impl10041); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4987:1: rule__SUBREF__Group__5 : rule__SUBREF__Group__5__Impl ;
    public final void rule__SUBREF__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4991:1: ( rule__SUBREF__Group__5__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4992:2: rule__SUBREF__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__5__Impl_in_rule__SUBREF__Group__510072);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4998:1: rule__SUBREF__Group__5__Impl : ( RULE_ID ) ;
    public final void rule__SUBREF__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5002:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5003:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5003:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5004:1: RULE_ID
            {
             before(grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_5()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SUBREF__Group__5__Impl10099); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5027:1: rule__SUBREF__Group_0__0 : rule__SUBREF__Group_0__0__Impl rule__SUBREF__Group_0__1 ;
    public final void rule__SUBREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5031:1: ( rule__SUBREF__Group_0__0__Impl rule__SUBREF__Group_0__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5032:2: rule__SUBREF__Group_0__0__Impl rule__SUBREF__Group_0__1
            {
            pushFollow(FOLLOW_rule__SUBREF__Group_0__0__Impl_in_rule__SUBREF__Group_0__010140);
            rule__SUBREF__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group_0__1_in_rule__SUBREF__Group_0__010143);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5039:1: rule__SUBREF__Group_0__0__Impl : ( RULE_ID ) ;
    public final void rule__SUBREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5043:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5044:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5044:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5045:1: RULE_ID
            {
             before(grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SUBREF__Group_0__0__Impl10170); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5056:1: rule__SUBREF__Group_0__1 : rule__SUBREF__Group_0__1__Impl ;
    public final void rule__SUBREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5060:1: ( rule__SUBREF__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5061:2: rule__SUBREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__SUBREF__Group_0__1__Impl_in_rule__SUBREF__Group_0__110199);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5067:1: rule__SUBREF__Group_0__1__Impl : ( '::' ) ;
    public final void rule__SUBREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5071:1: ( ( '::' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5072:1: ( '::' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5072:1: ( '::' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5073:1: '::'
            {
             before(grammarAccess.getSUBREFAccess().getColonColonKeyword_0_1()); 
            match(input,54,FOLLOW_54_in_rule__SUBREF__Group_0__1__Impl10227); 
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


    // $ANTLR start "rule__INSTANCEREF__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5090:1: rule__INSTANCEREF__Group__0 : rule__INSTANCEREF__Group__0__Impl rule__INSTANCEREF__Group__1 ;
    public final void rule__INSTANCEREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5094:1: ( rule__INSTANCEREF__Group__0__Impl rule__INSTANCEREF__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5095:2: rule__INSTANCEREF__Group__0__Impl rule__INSTANCEREF__Group__1
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group__0__Impl_in_rule__INSTANCEREF__Group__010262);
            rule__INSTANCEREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREF__Group__1_in_rule__INSTANCEREF__Group__010265);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5102:1: rule__INSTANCEREF__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__INSTANCEREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5106:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5107:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5107:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5108:1: RULE_ID
            {
             before(grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__INSTANCEREF__Group__0__Impl10292); 
             after(grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5119:1: rule__INSTANCEREF__Group__1 : rule__INSTANCEREF__Group__1__Impl rule__INSTANCEREF__Group__2 ;
    public final void rule__INSTANCEREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5123:1: ( rule__INSTANCEREF__Group__1__Impl rule__INSTANCEREF__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5124:2: rule__INSTANCEREF__Group__1__Impl rule__INSTANCEREF__Group__2
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group__1__Impl_in_rule__INSTANCEREF__Group__110321);
            rule__INSTANCEREF__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREF__Group__2_in_rule__INSTANCEREF__Group__110324);
            rule__INSTANCEREF__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5131:1: rule__INSTANCEREF__Group__1__Impl : ( ( rule__INSTANCEREF__Group_1__0 )* ) ;
    public final void rule__INSTANCEREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5135:1: ( ( ( rule__INSTANCEREF__Group_1__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5136:1: ( ( rule__INSTANCEREF__Group_1__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5136:1: ( ( rule__INSTANCEREF__Group_1__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5137:1: ( rule__INSTANCEREF__Group_1__0 )*
            {
             before(grammarAccess.getINSTANCEREFAccess().getGroup_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5138:1: ( rule__INSTANCEREF__Group_1__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==41) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5138:2: rule__INSTANCEREF__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__INSTANCEREF__Group_1__0_in_rule__INSTANCEREF__Group__1__Impl10351);
            	    rule__INSTANCEREF__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getINSTANCEREFAccess().getGroup_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__INSTANCEREF__Group__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5148:1: rule__INSTANCEREF__Group__2 : rule__INSTANCEREF__Group__2__Impl ;
    public final void rule__INSTANCEREF__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5152:1: ( rule__INSTANCEREF__Group__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5153:2: rule__INSTANCEREF__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group__2__Impl_in_rule__INSTANCEREF__Group__210382);
            rule__INSTANCEREF__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group__2"


    // $ANTLR start "rule__INSTANCEREF__Group__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5159:1: rule__INSTANCEREF__Group__2__Impl : ( ( rule__INSTANCEREF__Group_2__0 )* ) ;
    public final void rule__INSTANCEREF__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5163:1: ( ( ( rule__INSTANCEREF__Group_2__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5164:1: ( ( rule__INSTANCEREF__Group_2__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5164:1: ( ( rule__INSTANCEREF__Group_2__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5165:1: ( rule__INSTANCEREF__Group_2__0 )*
            {
             before(grammarAccess.getINSTANCEREFAccess().getGroup_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5166:1: ( rule__INSTANCEREF__Group_2__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==53) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5166:2: rule__INSTANCEREF__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__INSTANCEREF__Group_2__0_in_rule__INSTANCEREF__Group__2__Impl10409);
            	    rule__INSTANCEREF__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

             after(grammarAccess.getINSTANCEREFAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group__2__Impl"


    // $ANTLR start "rule__INSTANCEREF__Group_1__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5182:1: rule__INSTANCEREF__Group_1__0 : rule__INSTANCEREF__Group_1__0__Impl rule__INSTANCEREF__Group_1__1 ;
    public final void rule__INSTANCEREF__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5186:1: ( rule__INSTANCEREF__Group_1__0__Impl rule__INSTANCEREF__Group_1__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5187:2: rule__INSTANCEREF__Group_1__0__Impl rule__INSTANCEREF__Group_1__1
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_1__0__Impl_in_rule__INSTANCEREF__Group_1__010446);
            rule__INSTANCEREF__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREF__Group_1__1_in_rule__INSTANCEREF__Group_1__010449);
            rule__INSTANCEREF__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group_1__0"


    // $ANTLR start "rule__INSTANCEREF__Group_1__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5194:1: rule__INSTANCEREF__Group_1__0__Impl : ( '[' ) ;
    public final void rule__INSTANCEREF__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5198:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5199:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5199:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5200:1: '['
            {
             before(grammarAccess.getINSTANCEREFAccess().getLeftSquareBracketKeyword_1_0()); 
            match(input,41,FOLLOW_41_in_rule__INSTANCEREF__Group_1__0__Impl10477); 
             after(grammarAccess.getINSTANCEREFAccess().getLeftSquareBracketKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group_1__0__Impl"


    // $ANTLR start "rule__INSTANCEREF__Group_1__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5213:1: rule__INSTANCEREF__Group_1__1 : rule__INSTANCEREF__Group_1__1__Impl rule__INSTANCEREF__Group_1__2 ;
    public final void rule__INSTANCEREF__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5217:1: ( rule__INSTANCEREF__Group_1__1__Impl rule__INSTANCEREF__Group_1__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5218:2: rule__INSTANCEREF__Group_1__1__Impl rule__INSTANCEREF__Group_1__2
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_1__1__Impl_in_rule__INSTANCEREF__Group_1__110508);
            rule__INSTANCEREF__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREF__Group_1__2_in_rule__INSTANCEREF__Group_1__110511);
            rule__INSTANCEREF__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group_1__1"


    // $ANTLR start "rule__INSTANCEREF__Group_1__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5225:1: rule__INSTANCEREF__Group_1__1__Impl : ( RULE_LONG ) ;
    public final void rule__INSTANCEREF__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5229:1: ( ( RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5230:1: ( RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5230:1: ( RULE_LONG )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5231:1: RULE_LONG
            {
             before(grammarAccess.getINSTANCEREFAccess().getLONGTerminalRuleCall_1_1()); 
            match(input,RULE_LONG,FOLLOW_RULE_LONG_in_rule__INSTANCEREF__Group_1__1__Impl10538); 
             after(grammarAccess.getINSTANCEREFAccess().getLONGTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group_1__1__Impl"


    // $ANTLR start "rule__INSTANCEREF__Group_1__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5242:1: rule__INSTANCEREF__Group_1__2 : rule__INSTANCEREF__Group_1__2__Impl ;
    public final void rule__INSTANCEREF__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5246:1: ( rule__INSTANCEREF__Group_1__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5247:2: rule__INSTANCEREF__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_1__2__Impl_in_rule__INSTANCEREF__Group_1__210567);
            rule__INSTANCEREF__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group_1__2"


    // $ANTLR start "rule__INSTANCEREF__Group_1__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5253:1: rule__INSTANCEREF__Group_1__2__Impl : ( ']' ) ;
    public final void rule__INSTANCEREF__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5257:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5258:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5258:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5259:1: ']'
            {
             before(grammarAccess.getINSTANCEREFAccess().getRightSquareBracketKeyword_1_2()); 
            match(input,42,FOLLOW_42_in_rule__INSTANCEREF__Group_1__2__Impl10595); 
             after(grammarAccess.getINSTANCEREFAccess().getRightSquareBracketKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group_1__2__Impl"


    // $ANTLR start "rule__INSTANCEREF__Group_2__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5278:1: rule__INSTANCEREF__Group_2__0 : rule__INSTANCEREF__Group_2__0__Impl rule__INSTANCEREF__Group_2__1 ;
    public final void rule__INSTANCEREF__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5282:1: ( rule__INSTANCEREF__Group_2__0__Impl rule__INSTANCEREF__Group_2__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5283:2: rule__INSTANCEREF__Group_2__0__Impl rule__INSTANCEREF__Group_2__1
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_2__0__Impl_in_rule__INSTANCEREF__Group_2__010632);
            rule__INSTANCEREF__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREF__Group_2__1_in_rule__INSTANCEREF__Group_2__010635);
            rule__INSTANCEREF__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group_2__0"


    // $ANTLR start "rule__INSTANCEREF__Group_2__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5290:1: rule__INSTANCEREF__Group_2__0__Impl : ( '.' ) ;
    public final void rule__INSTANCEREF__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5294:1: ( ( '.' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5295:1: ( '.' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5295:1: ( '.' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5296:1: '.'
            {
             before(grammarAccess.getINSTANCEREFAccess().getFullStopKeyword_2_0()); 
            match(input,53,FOLLOW_53_in_rule__INSTANCEREF__Group_2__0__Impl10663); 
             after(grammarAccess.getINSTANCEREFAccess().getFullStopKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group_2__0__Impl"


    // $ANTLR start "rule__INSTANCEREF__Group_2__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5309:1: rule__INSTANCEREF__Group_2__1 : rule__INSTANCEREF__Group_2__1__Impl rule__INSTANCEREF__Group_2__2 ;
    public final void rule__INSTANCEREF__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5313:1: ( rule__INSTANCEREF__Group_2__1__Impl rule__INSTANCEREF__Group_2__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5314:2: rule__INSTANCEREF__Group_2__1__Impl rule__INSTANCEREF__Group_2__2
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_2__1__Impl_in_rule__INSTANCEREF__Group_2__110694);
            rule__INSTANCEREF__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREF__Group_2__2_in_rule__INSTANCEREF__Group_2__110697);
            rule__INSTANCEREF__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group_2__1"


    // $ANTLR start "rule__INSTANCEREF__Group_2__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5321:1: rule__INSTANCEREF__Group_2__1__Impl : ( RULE_ID ) ;
    public final void rule__INSTANCEREF__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5325:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5326:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5326:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5327:1: RULE_ID
            {
             before(grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_2_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__INSTANCEREF__Group_2__1__Impl10724); 
             after(grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group_2__1__Impl"


    // $ANTLR start "rule__INSTANCEREF__Group_2__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5338:1: rule__INSTANCEREF__Group_2__2 : rule__INSTANCEREF__Group_2__2__Impl ;
    public final void rule__INSTANCEREF__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5342:1: ( rule__INSTANCEREF__Group_2__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5343:2: rule__INSTANCEREF__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_2__2__Impl_in_rule__INSTANCEREF__Group_2__210753);
            rule__INSTANCEREF__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group_2__2"


    // $ANTLR start "rule__INSTANCEREF__Group_2__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5349:1: rule__INSTANCEREF__Group_2__2__Impl : ( ( rule__INSTANCEREF__Group_2_2__0 )* ) ;
    public final void rule__INSTANCEREF__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5353:1: ( ( ( rule__INSTANCEREF__Group_2_2__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5354:1: ( ( rule__INSTANCEREF__Group_2_2__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5354:1: ( ( rule__INSTANCEREF__Group_2_2__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5355:1: ( rule__INSTANCEREF__Group_2_2__0 )*
            {
             before(grammarAccess.getINSTANCEREFAccess().getGroup_2_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5356:1: ( rule__INSTANCEREF__Group_2_2__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==41) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5356:2: rule__INSTANCEREF__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__INSTANCEREF__Group_2_2__0_in_rule__INSTANCEREF__Group_2__2__Impl10780);
            	    rule__INSTANCEREF__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

             after(grammarAccess.getINSTANCEREFAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group_2__2__Impl"


    // $ANTLR start "rule__INSTANCEREF__Group_2_2__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5372:1: rule__INSTANCEREF__Group_2_2__0 : rule__INSTANCEREF__Group_2_2__0__Impl rule__INSTANCEREF__Group_2_2__1 ;
    public final void rule__INSTANCEREF__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5376:1: ( rule__INSTANCEREF__Group_2_2__0__Impl rule__INSTANCEREF__Group_2_2__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5377:2: rule__INSTANCEREF__Group_2_2__0__Impl rule__INSTANCEREF__Group_2_2__1
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_2_2__0__Impl_in_rule__INSTANCEREF__Group_2_2__010817);
            rule__INSTANCEREF__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREF__Group_2_2__1_in_rule__INSTANCEREF__Group_2_2__010820);
            rule__INSTANCEREF__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group_2_2__0"


    // $ANTLR start "rule__INSTANCEREF__Group_2_2__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5384:1: rule__INSTANCEREF__Group_2_2__0__Impl : ( '[' ) ;
    public final void rule__INSTANCEREF__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5388:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5389:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5389:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5390:1: '['
            {
             before(grammarAccess.getINSTANCEREFAccess().getLeftSquareBracketKeyword_2_2_0()); 
            match(input,41,FOLLOW_41_in_rule__INSTANCEREF__Group_2_2__0__Impl10848); 
             after(grammarAccess.getINSTANCEREFAccess().getLeftSquareBracketKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group_2_2__0__Impl"


    // $ANTLR start "rule__INSTANCEREF__Group_2_2__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5403:1: rule__INSTANCEREF__Group_2_2__1 : rule__INSTANCEREF__Group_2_2__1__Impl rule__INSTANCEREF__Group_2_2__2 ;
    public final void rule__INSTANCEREF__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5407:1: ( rule__INSTANCEREF__Group_2_2__1__Impl rule__INSTANCEREF__Group_2_2__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5408:2: rule__INSTANCEREF__Group_2_2__1__Impl rule__INSTANCEREF__Group_2_2__2
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_2_2__1__Impl_in_rule__INSTANCEREF__Group_2_2__110879);
            rule__INSTANCEREF__Group_2_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREF__Group_2_2__2_in_rule__INSTANCEREF__Group_2_2__110882);
            rule__INSTANCEREF__Group_2_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group_2_2__1"


    // $ANTLR start "rule__INSTANCEREF__Group_2_2__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5415:1: rule__INSTANCEREF__Group_2_2__1__Impl : ( RULE_LONG ) ;
    public final void rule__INSTANCEREF__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5419:1: ( ( RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5420:1: ( RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5420:1: ( RULE_LONG )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5421:1: RULE_LONG
            {
             before(grammarAccess.getINSTANCEREFAccess().getLONGTerminalRuleCall_2_2_1()); 
            match(input,RULE_LONG,FOLLOW_RULE_LONG_in_rule__INSTANCEREF__Group_2_2__1__Impl10909); 
             after(grammarAccess.getINSTANCEREFAccess().getLONGTerminalRuleCall_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group_2_2__1__Impl"


    // $ANTLR start "rule__INSTANCEREF__Group_2_2__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5432:1: rule__INSTANCEREF__Group_2_2__2 : rule__INSTANCEREF__Group_2_2__2__Impl ;
    public final void rule__INSTANCEREF__Group_2_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5436:1: ( rule__INSTANCEREF__Group_2_2__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5437:2: rule__INSTANCEREF__Group_2_2__2__Impl
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_2_2__2__Impl_in_rule__INSTANCEREF__Group_2_2__210938);
            rule__INSTANCEREF__Group_2_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group_2_2__2"


    // $ANTLR start "rule__INSTANCEREF__Group_2_2__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5443:1: rule__INSTANCEREF__Group_2_2__2__Impl : ( ']' ) ;
    public final void rule__INSTANCEREF__Group_2_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5447:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5448:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5448:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5449:1: ']'
            {
             before(grammarAccess.getINSTANCEREFAccess().getRightSquareBracketKeyword_2_2_2()); 
            match(input,42,FOLLOW_42_in_rule__INSTANCEREF__Group_2_2__2__Impl10966); 
             after(grammarAccess.getINSTANCEREFAccess().getRightSquareBracketKeyword_2_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREF__Group_2_2__2__Impl"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5468:1: rule__SIMPLEINSTANCEREF__Group__0 : rule__SIMPLEINSTANCEREF__Group__0__Impl rule__SIMPLEINSTANCEREF__Group__1 ;
    public final void rule__SIMPLEINSTANCEREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5472:1: ( rule__SIMPLEINSTANCEREF__Group__0__Impl rule__SIMPLEINSTANCEREF__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5473:2: rule__SIMPLEINSTANCEREF__Group__0__Impl rule__SIMPLEINSTANCEREF__Group__1
            {
            pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group__0__Impl_in_rule__SIMPLEINSTANCEREF__Group__011003);
            rule__SIMPLEINSTANCEREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group__1_in_rule__SIMPLEINSTANCEREF__Group__011006);
            rule__SIMPLEINSTANCEREF__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group__0"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5480:1: rule__SIMPLEINSTANCEREF__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__SIMPLEINSTANCEREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5484:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5485:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5485:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5486:1: RULE_ID
            {
             before(grammarAccess.getSIMPLEINSTANCEREFAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SIMPLEINSTANCEREF__Group__0__Impl11033); 
             after(grammarAccess.getSIMPLEINSTANCEREFAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group__0__Impl"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5497:1: rule__SIMPLEINSTANCEREF__Group__1 : rule__SIMPLEINSTANCEREF__Group__1__Impl rule__SIMPLEINSTANCEREF__Group__2 ;
    public final void rule__SIMPLEINSTANCEREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5501:1: ( rule__SIMPLEINSTANCEREF__Group__1__Impl rule__SIMPLEINSTANCEREF__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5502:2: rule__SIMPLEINSTANCEREF__Group__1__Impl rule__SIMPLEINSTANCEREF__Group__2
            {
            pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group__1__Impl_in_rule__SIMPLEINSTANCEREF__Group__111062);
            rule__SIMPLEINSTANCEREF__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group__2_in_rule__SIMPLEINSTANCEREF__Group__111065);
            rule__SIMPLEINSTANCEREF__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group__1"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5509:1: rule__SIMPLEINSTANCEREF__Group__1__Impl : ( ( rule__SIMPLEINSTANCEREF__Group_1__0 )? ) ;
    public final void rule__SIMPLEINSTANCEREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5513:1: ( ( ( rule__SIMPLEINSTANCEREF__Group_1__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5514:1: ( ( rule__SIMPLEINSTANCEREF__Group_1__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5514:1: ( ( rule__SIMPLEINSTANCEREF__Group_1__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5515:1: ( rule__SIMPLEINSTANCEREF__Group_1__0 )?
            {
             before(grammarAccess.getSIMPLEINSTANCEREFAccess().getGroup_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5516:1: ( rule__SIMPLEINSTANCEREF__Group_1__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==41) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5516:2: rule__SIMPLEINSTANCEREF__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group_1__0_in_rule__SIMPLEINSTANCEREF__Group__1__Impl11092);
                    rule__SIMPLEINSTANCEREF__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSIMPLEINSTANCEREFAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group__1__Impl"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5526:1: rule__SIMPLEINSTANCEREF__Group__2 : rule__SIMPLEINSTANCEREF__Group__2__Impl ;
    public final void rule__SIMPLEINSTANCEREF__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5530:1: ( rule__SIMPLEINSTANCEREF__Group__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5531:2: rule__SIMPLEINSTANCEREF__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group__2__Impl_in_rule__SIMPLEINSTANCEREF__Group__211123);
            rule__SIMPLEINSTANCEREF__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group__2"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5537:1: rule__SIMPLEINSTANCEREF__Group__2__Impl : ( ( rule__SIMPLEINSTANCEREF__Group_2__0 )* ) ;
    public final void rule__SIMPLEINSTANCEREF__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5541:1: ( ( ( rule__SIMPLEINSTANCEREF__Group_2__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5542:1: ( ( rule__SIMPLEINSTANCEREF__Group_2__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5542:1: ( ( rule__SIMPLEINSTANCEREF__Group_2__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5543:1: ( rule__SIMPLEINSTANCEREF__Group_2__0 )*
            {
             before(grammarAccess.getSIMPLEINSTANCEREFAccess().getGroup_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5544:1: ( rule__SIMPLEINSTANCEREF__Group_2__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==53) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5544:2: rule__SIMPLEINSTANCEREF__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group_2__0_in_rule__SIMPLEINSTANCEREF__Group__2__Impl11150);
            	    rule__SIMPLEINSTANCEREF__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

             after(grammarAccess.getSIMPLEINSTANCEREFAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group__2__Impl"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group_1__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5560:1: rule__SIMPLEINSTANCEREF__Group_1__0 : rule__SIMPLEINSTANCEREF__Group_1__0__Impl rule__SIMPLEINSTANCEREF__Group_1__1 ;
    public final void rule__SIMPLEINSTANCEREF__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5564:1: ( rule__SIMPLEINSTANCEREF__Group_1__0__Impl rule__SIMPLEINSTANCEREF__Group_1__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5565:2: rule__SIMPLEINSTANCEREF__Group_1__0__Impl rule__SIMPLEINSTANCEREF__Group_1__1
            {
            pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group_1__0__Impl_in_rule__SIMPLEINSTANCEREF__Group_1__011187);
            rule__SIMPLEINSTANCEREF__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group_1__1_in_rule__SIMPLEINSTANCEREF__Group_1__011190);
            rule__SIMPLEINSTANCEREF__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group_1__0"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group_1__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5572:1: rule__SIMPLEINSTANCEREF__Group_1__0__Impl : ( '[' ) ;
    public final void rule__SIMPLEINSTANCEREF__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5576:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5577:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5577:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5578:1: '['
            {
             before(grammarAccess.getSIMPLEINSTANCEREFAccess().getLeftSquareBracketKeyword_1_0()); 
            match(input,41,FOLLOW_41_in_rule__SIMPLEINSTANCEREF__Group_1__0__Impl11218); 
             after(grammarAccess.getSIMPLEINSTANCEREFAccess().getLeftSquareBracketKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group_1__0__Impl"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group_1__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5591:1: rule__SIMPLEINSTANCEREF__Group_1__1 : rule__SIMPLEINSTANCEREF__Group_1__1__Impl rule__SIMPLEINSTANCEREF__Group_1__2 ;
    public final void rule__SIMPLEINSTANCEREF__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5595:1: ( rule__SIMPLEINSTANCEREF__Group_1__1__Impl rule__SIMPLEINSTANCEREF__Group_1__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5596:2: rule__SIMPLEINSTANCEREF__Group_1__1__Impl rule__SIMPLEINSTANCEREF__Group_1__2
            {
            pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group_1__1__Impl_in_rule__SIMPLEINSTANCEREF__Group_1__111249);
            rule__SIMPLEINSTANCEREF__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group_1__2_in_rule__SIMPLEINSTANCEREF__Group_1__111252);
            rule__SIMPLEINSTANCEREF__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group_1__1"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group_1__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5603:1: rule__SIMPLEINSTANCEREF__Group_1__1__Impl : ( RULE_LONG ) ;
    public final void rule__SIMPLEINSTANCEREF__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5607:1: ( ( RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5608:1: ( RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5608:1: ( RULE_LONG )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5609:1: RULE_LONG
            {
             before(grammarAccess.getSIMPLEINSTANCEREFAccess().getLONGTerminalRuleCall_1_1()); 
            match(input,RULE_LONG,FOLLOW_RULE_LONG_in_rule__SIMPLEINSTANCEREF__Group_1__1__Impl11279); 
             after(grammarAccess.getSIMPLEINSTANCEREFAccess().getLONGTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group_1__1__Impl"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group_1__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5620:1: rule__SIMPLEINSTANCEREF__Group_1__2 : rule__SIMPLEINSTANCEREF__Group_1__2__Impl ;
    public final void rule__SIMPLEINSTANCEREF__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5624:1: ( rule__SIMPLEINSTANCEREF__Group_1__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5625:2: rule__SIMPLEINSTANCEREF__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group_1__2__Impl_in_rule__SIMPLEINSTANCEREF__Group_1__211308);
            rule__SIMPLEINSTANCEREF__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group_1__2"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group_1__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5631:1: rule__SIMPLEINSTANCEREF__Group_1__2__Impl : ( ']' ) ;
    public final void rule__SIMPLEINSTANCEREF__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5635:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5636:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5636:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5637:1: ']'
            {
             before(grammarAccess.getSIMPLEINSTANCEREFAccess().getRightSquareBracketKeyword_1_2()); 
            match(input,42,FOLLOW_42_in_rule__SIMPLEINSTANCEREF__Group_1__2__Impl11336); 
             after(grammarAccess.getSIMPLEINSTANCEREFAccess().getRightSquareBracketKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group_1__2__Impl"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group_2__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5656:1: rule__SIMPLEINSTANCEREF__Group_2__0 : rule__SIMPLEINSTANCEREF__Group_2__0__Impl rule__SIMPLEINSTANCEREF__Group_2__1 ;
    public final void rule__SIMPLEINSTANCEREF__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5660:1: ( rule__SIMPLEINSTANCEREF__Group_2__0__Impl rule__SIMPLEINSTANCEREF__Group_2__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5661:2: rule__SIMPLEINSTANCEREF__Group_2__0__Impl rule__SIMPLEINSTANCEREF__Group_2__1
            {
            pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group_2__0__Impl_in_rule__SIMPLEINSTANCEREF__Group_2__011373);
            rule__SIMPLEINSTANCEREF__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group_2__1_in_rule__SIMPLEINSTANCEREF__Group_2__011376);
            rule__SIMPLEINSTANCEREF__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group_2__0"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group_2__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5668:1: rule__SIMPLEINSTANCEREF__Group_2__0__Impl : ( '.' ) ;
    public final void rule__SIMPLEINSTANCEREF__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5672:1: ( ( '.' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5673:1: ( '.' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5673:1: ( '.' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5674:1: '.'
            {
             before(grammarAccess.getSIMPLEINSTANCEREFAccess().getFullStopKeyword_2_0()); 
            match(input,53,FOLLOW_53_in_rule__SIMPLEINSTANCEREF__Group_2__0__Impl11404); 
             after(grammarAccess.getSIMPLEINSTANCEREFAccess().getFullStopKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group_2__0__Impl"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group_2__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5687:1: rule__SIMPLEINSTANCEREF__Group_2__1 : rule__SIMPLEINSTANCEREF__Group_2__1__Impl rule__SIMPLEINSTANCEREF__Group_2__2 ;
    public final void rule__SIMPLEINSTANCEREF__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5691:1: ( rule__SIMPLEINSTANCEREF__Group_2__1__Impl rule__SIMPLEINSTANCEREF__Group_2__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5692:2: rule__SIMPLEINSTANCEREF__Group_2__1__Impl rule__SIMPLEINSTANCEREF__Group_2__2
            {
            pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group_2__1__Impl_in_rule__SIMPLEINSTANCEREF__Group_2__111435);
            rule__SIMPLEINSTANCEREF__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group_2__2_in_rule__SIMPLEINSTANCEREF__Group_2__111438);
            rule__SIMPLEINSTANCEREF__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group_2__1"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group_2__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5699:1: rule__SIMPLEINSTANCEREF__Group_2__1__Impl : ( RULE_ID ) ;
    public final void rule__SIMPLEINSTANCEREF__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5703:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5704:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5704:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5705:1: RULE_ID
            {
             before(grammarAccess.getSIMPLEINSTANCEREFAccess().getIDTerminalRuleCall_2_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SIMPLEINSTANCEREF__Group_2__1__Impl11465); 
             after(grammarAccess.getSIMPLEINSTANCEREFAccess().getIDTerminalRuleCall_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group_2__1__Impl"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group_2__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5716:1: rule__SIMPLEINSTANCEREF__Group_2__2 : rule__SIMPLEINSTANCEREF__Group_2__2__Impl ;
    public final void rule__SIMPLEINSTANCEREF__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5720:1: ( rule__SIMPLEINSTANCEREF__Group_2__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5721:2: rule__SIMPLEINSTANCEREF__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group_2__2__Impl_in_rule__SIMPLEINSTANCEREF__Group_2__211494);
            rule__SIMPLEINSTANCEREF__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group_2__2"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group_2__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5727:1: rule__SIMPLEINSTANCEREF__Group_2__2__Impl : ( ( rule__SIMPLEINSTANCEREF__Group_2_2__0 )? ) ;
    public final void rule__SIMPLEINSTANCEREF__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5731:1: ( ( ( rule__SIMPLEINSTANCEREF__Group_2_2__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5732:1: ( ( rule__SIMPLEINSTANCEREF__Group_2_2__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5732:1: ( ( rule__SIMPLEINSTANCEREF__Group_2_2__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5733:1: ( rule__SIMPLEINSTANCEREF__Group_2_2__0 )?
            {
             before(grammarAccess.getSIMPLEINSTANCEREFAccess().getGroup_2_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5734:1: ( rule__SIMPLEINSTANCEREF__Group_2_2__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==41) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5734:2: rule__SIMPLEINSTANCEREF__Group_2_2__0
                    {
                    pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group_2_2__0_in_rule__SIMPLEINSTANCEREF__Group_2__2__Impl11521);
                    rule__SIMPLEINSTANCEREF__Group_2_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSIMPLEINSTANCEREFAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group_2__2__Impl"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group_2_2__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5750:1: rule__SIMPLEINSTANCEREF__Group_2_2__0 : rule__SIMPLEINSTANCEREF__Group_2_2__0__Impl rule__SIMPLEINSTANCEREF__Group_2_2__1 ;
    public final void rule__SIMPLEINSTANCEREF__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5754:1: ( rule__SIMPLEINSTANCEREF__Group_2_2__0__Impl rule__SIMPLEINSTANCEREF__Group_2_2__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5755:2: rule__SIMPLEINSTANCEREF__Group_2_2__0__Impl rule__SIMPLEINSTANCEREF__Group_2_2__1
            {
            pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group_2_2__0__Impl_in_rule__SIMPLEINSTANCEREF__Group_2_2__011558);
            rule__SIMPLEINSTANCEREF__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group_2_2__1_in_rule__SIMPLEINSTANCEREF__Group_2_2__011561);
            rule__SIMPLEINSTANCEREF__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group_2_2__0"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group_2_2__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5762:1: rule__SIMPLEINSTANCEREF__Group_2_2__0__Impl : ( '[' ) ;
    public final void rule__SIMPLEINSTANCEREF__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5766:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5767:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5767:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5768:1: '['
            {
             before(grammarAccess.getSIMPLEINSTANCEREFAccess().getLeftSquareBracketKeyword_2_2_0()); 
            match(input,41,FOLLOW_41_in_rule__SIMPLEINSTANCEREF__Group_2_2__0__Impl11589); 
             after(grammarAccess.getSIMPLEINSTANCEREFAccess().getLeftSquareBracketKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group_2_2__0__Impl"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group_2_2__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5781:1: rule__SIMPLEINSTANCEREF__Group_2_2__1 : rule__SIMPLEINSTANCEREF__Group_2_2__1__Impl rule__SIMPLEINSTANCEREF__Group_2_2__2 ;
    public final void rule__SIMPLEINSTANCEREF__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5785:1: ( rule__SIMPLEINSTANCEREF__Group_2_2__1__Impl rule__SIMPLEINSTANCEREF__Group_2_2__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5786:2: rule__SIMPLEINSTANCEREF__Group_2_2__1__Impl rule__SIMPLEINSTANCEREF__Group_2_2__2
            {
            pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group_2_2__1__Impl_in_rule__SIMPLEINSTANCEREF__Group_2_2__111620);
            rule__SIMPLEINSTANCEREF__Group_2_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group_2_2__2_in_rule__SIMPLEINSTANCEREF__Group_2_2__111623);
            rule__SIMPLEINSTANCEREF__Group_2_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group_2_2__1"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group_2_2__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5793:1: rule__SIMPLEINSTANCEREF__Group_2_2__1__Impl : ( RULE_LONG ) ;
    public final void rule__SIMPLEINSTANCEREF__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5797:1: ( ( RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5798:1: ( RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5798:1: ( RULE_LONG )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5799:1: RULE_LONG
            {
             before(grammarAccess.getSIMPLEINSTANCEREFAccess().getLONGTerminalRuleCall_2_2_1()); 
            match(input,RULE_LONG,FOLLOW_RULE_LONG_in_rule__SIMPLEINSTANCEREF__Group_2_2__1__Impl11650); 
             after(grammarAccess.getSIMPLEINSTANCEREFAccess().getLONGTerminalRuleCall_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group_2_2__1__Impl"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group_2_2__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5810:1: rule__SIMPLEINSTANCEREF__Group_2_2__2 : rule__SIMPLEINSTANCEREF__Group_2_2__2__Impl ;
    public final void rule__SIMPLEINSTANCEREF__Group_2_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5814:1: ( rule__SIMPLEINSTANCEREF__Group_2_2__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5815:2: rule__SIMPLEINSTANCEREF__Group_2_2__2__Impl
            {
            pushFollow(FOLLOW_rule__SIMPLEINSTANCEREF__Group_2_2__2__Impl_in_rule__SIMPLEINSTANCEREF__Group_2_2__211679);
            rule__SIMPLEINSTANCEREF__Group_2_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group_2_2__2"


    // $ANTLR start "rule__SIMPLEINSTANCEREF__Group_2_2__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5821:1: rule__SIMPLEINSTANCEREF__Group_2_2__2__Impl : ( ']' ) ;
    public final void rule__SIMPLEINSTANCEREF__Group_2_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5825:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5826:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5826:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5827:1: ']'
            {
             before(grammarAccess.getSIMPLEINSTANCEREFAccess().getRightSquareBracketKeyword_2_2_2()); 
            match(input,42,FOLLOW_42_in_rule__SIMPLEINSTANCEREF__Group_2_2__2__Impl11707); 
             after(grammarAccess.getSIMPLEINSTANCEREFAccess().getRightSquareBracketKeyword_2_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SIMPLEINSTANCEREF__Group_2_2__2__Impl"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5846:1: rule__INSTANCEREFWITHPARENT__Group_1__0 : rule__INSTANCEREFWITHPARENT__Group_1__0__Impl rule__INSTANCEREFWITHPARENT__Group_1__1 ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5850:1: ( rule__INSTANCEREFWITHPARENT__Group_1__0__Impl rule__INSTANCEREFWITHPARENT__Group_1__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5851:2: rule__INSTANCEREFWITHPARENT__Group_1__0__Impl rule__INSTANCEREFWITHPARENT__Group_1__1
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__0__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1__011744);
            rule__INSTANCEREFWITHPARENT__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__1_in_rule__INSTANCEREFWITHPARENT__Group_1__011747);
            rule__INSTANCEREFWITHPARENT__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1__0"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5858:1: rule__INSTANCEREFWITHPARENT__Group_1__0__Impl : ( RULE_ID ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5862:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5863:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5863:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5864:1: RULE_ID
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__INSTANCEREFWITHPARENT__Group_1__0__Impl11774); 
             after(grammarAccess.getINSTANCEREFWITHPARENTAccess().getIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1__0__Impl"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5875:1: rule__INSTANCEREFWITHPARENT__Group_1__1 : rule__INSTANCEREFWITHPARENT__Group_1__1__Impl rule__INSTANCEREFWITHPARENT__Group_1__2 ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5879:1: ( rule__INSTANCEREFWITHPARENT__Group_1__1__Impl rule__INSTANCEREFWITHPARENT__Group_1__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5880:2: rule__INSTANCEREFWITHPARENT__Group_1__1__Impl rule__INSTANCEREFWITHPARENT__Group_1__2
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__1__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1__111803);
            rule__INSTANCEREFWITHPARENT__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__2_in_rule__INSTANCEREFWITHPARENT__Group_1__111806);
            rule__INSTANCEREFWITHPARENT__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1__1"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5887:1: rule__INSTANCEREFWITHPARENT__Group_1__1__Impl : ( ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 ) ) ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 )* ) ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5891:1: ( ( ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 ) ) ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5892:1: ( ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 ) ) ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5892:1: ( ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 ) ) ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5893:1: ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 ) ) ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5893:1: ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5894:1: ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 )
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getGroup_1_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5895:1: ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5895:2: rule__INSTANCEREFWITHPARENT__Group_1_1__0
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__0_in_rule__INSTANCEREFWITHPARENT__Group_1__1__Impl11835);
            rule__INSTANCEREFWITHPARENT__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getINSTANCEREFWITHPARENTAccess().getGroup_1_1()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5898:1: ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5899:1: ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 )*
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getGroup_1_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5900:1: ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==41) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5900:2: rule__INSTANCEREFWITHPARENT__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__0_in_rule__INSTANCEREFWITHPARENT__Group_1__1__Impl11847);
            	    rule__INSTANCEREFWITHPARENT__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

             after(grammarAccess.getINSTANCEREFWITHPARENTAccess().getGroup_1_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1__1__Impl"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5911:1: rule__INSTANCEREFWITHPARENT__Group_1__2 : rule__INSTANCEREFWITHPARENT__Group_1__2__Impl ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5915:1: ( rule__INSTANCEREFWITHPARENT__Group_1__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5916:2: rule__INSTANCEREFWITHPARENT__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__2__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1__211880);
            rule__INSTANCEREFWITHPARENT__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1__2"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5922:1: rule__INSTANCEREFWITHPARENT__Group_1__2__Impl : ( ( rule__INSTANCEREFWITHPARENT__Group_1_2__0 )* ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5926:1: ( ( ( rule__INSTANCEREFWITHPARENT__Group_1_2__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5927:1: ( ( rule__INSTANCEREFWITHPARENT__Group_1_2__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5927:1: ( ( rule__INSTANCEREFWITHPARENT__Group_1_2__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5928:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2__0 )*
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getGroup_1_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5929:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==53) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5929:2: rule__INSTANCEREFWITHPARENT__Group_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__0_in_rule__INSTANCEREFWITHPARENT__Group_1__2__Impl11907);
            	    rule__INSTANCEREFWITHPARENT__Group_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

             after(grammarAccess.getINSTANCEREFWITHPARENTAccess().getGroup_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1__2__Impl"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1_1__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5945:1: rule__INSTANCEREFWITHPARENT__Group_1_1__0 : rule__INSTANCEREFWITHPARENT__Group_1_1__0__Impl rule__INSTANCEREFWITHPARENT__Group_1_1__1 ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5949:1: ( rule__INSTANCEREFWITHPARENT__Group_1_1__0__Impl rule__INSTANCEREFWITHPARENT__Group_1_1__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5950:2: rule__INSTANCEREFWITHPARENT__Group_1_1__0__Impl rule__INSTANCEREFWITHPARENT__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__0__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_1__011944);
            rule__INSTANCEREFWITHPARENT__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__1_in_rule__INSTANCEREFWITHPARENT__Group_1_1__011947);
            rule__INSTANCEREFWITHPARENT__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1_1__0"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1_1__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5957:1: rule__INSTANCEREFWITHPARENT__Group_1_1__0__Impl : ( '[' ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5961:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5962:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5962:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5963:1: '['
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getLeftSquareBracketKeyword_1_1_0()); 
            match(input,41,FOLLOW_41_in_rule__INSTANCEREFWITHPARENT__Group_1_1__0__Impl11975); 
             after(grammarAccess.getINSTANCEREFWITHPARENTAccess().getLeftSquareBracketKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1_1__0__Impl"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1_1__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5976:1: rule__INSTANCEREFWITHPARENT__Group_1_1__1 : rule__INSTANCEREFWITHPARENT__Group_1_1__1__Impl rule__INSTANCEREFWITHPARENT__Group_1_1__2 ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5980:1: ( rule__INSTANCEREFWITHPARENT__Group_1_1__1__Impl rule__INSTANCEREFWITHPARENT__Group_1_1__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5981:2: rule__INSTANCEREFWITHPARENT__Group_1_1__1__Impl rule__INSTANCEREFWITHPARENT__Group_1_1__2
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__1__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_1__112006);
            rule__INSTANCEREFWITHPARENT__Group_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__2_in_rule__INSTANCEREFWITHPARENT__Group_1_1__112009);
            rule__INSTANCEREFWITHPARENT__Group_1_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1_1__1"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1_1__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5988:1: rule__INSTANCEREFWITHPARENT__Group_1_1__1__Impl : ( RULE_LONG ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5992:1: ( ( RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5993:1: ( RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5993:1: ( RULE_LONG )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5994:1: RULE_LONG
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getLONGTerminalRuleCall_1_1_1()); 
            match(input,RULE_LONG,FOLLOW_RULE_LONG_in_rule__INSTANCEREFWITHPARENT__Group_1_1__1__Impl12036); 
             after(grammarAccess.getINSTANCEREFWITHPARENTAccess().getLONGTerminalRuleCall_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1_1__1__Impl"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1_1__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6005:1: rule__INSTANCEREFWITHPARENT__Group_1_1__2 : rule__INSTANCEREFWITHPARENT__Group_1_1__2__Impl ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6009:1: ( rule__INSTANCEREFWITHPARENT__Group_1_1__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6010:2: rule__INSTANCEREFWITHPARENT__Group_1_1__2__Impl
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__2__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_1__212065);
            rule__INSTANCEREFWITHPARENT__Group_1_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1_1__2"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1_1__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6016:1: rule__INSTANCEREFWITHPARENT__Group_1_1__2__Impl : ( ']' ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6020:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6021:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6021:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6022:1: ']'
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getRightSquareBracketKeyword_1_1_2()); 
            match(input,42,FOLLOW_42_in_rule__INSTANCEREFWITHPARENT__Group_1_1__2__Impl12093); 
             after(grammarAccess.getINSTANCEREFWITHPARENTAccess().getRightSquareBracketKeyword_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1_1__2__Impl"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1_2__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6041:1: rule__INSTANCEREFWITHPARENT__Group_1_2__0 : rule__INSTANCEREFWITHPARENT__Group_1_2__0__Impl rule__INSTANCEREFWITHPARENT__Group_1_2__1 ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6045:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2__0__Impl rule__INSTANCEREFWITHPARENT__Group_1_2__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6046:2: rule__INSTANCEREFWITHPARENT__Group_1_2__0__Impl rule__INSTANCEREFWITHPARENT__Group_1_2__1
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__0__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2__012130);
            rule__INSTANCEREFWITHPARENT__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__1_in_rule__INSTANCEREFWITHPARENT__Group_1_2__012133);
            rule__INSTANCEREFWITHPARENT__Group_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1_2__0"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1_2__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6053:1: rule__INSTANCEREFWITHPARENT__Group_1_2__0__Impl : ( '.' ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6057:1: ( ( '.' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6058:1: ( '.' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6058:1: ( '.' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6059:1: '.'
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getFullStopKeyword_1_2_0()); 
            match(input,53,FOLLOW_53_in_rule__INSTANCEREFWITHPARENT__Group_1_2__0__Impl12161); 
             after(grammarAccess.getINSTANCEREFWITHPARENTAccess().getFullStopKeyword_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1_2__0__Impl"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1_2__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6072:1: rule__INSTANCEREFWITHPARENT__Group_1_2__1 : rule__INSTANCEREFWITHPARENT__Group_1_2__1__Impl rule__INSTANCEREFWITHPARENT__Group_1_2__2 ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6076:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2__1__Impl rule__INSTANCEREFWITHPARENT__Group_1_2__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6077:2: rule__INSTANCEREFWITHPARENT__Group_1_2__1__Impl rule__INSTANCEREFWITHPARENT__Group_1_2__2
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__1__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2__112192);
            rule__INSTANCEREFWITHPARENT__Group_1_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__2_in_rule__INSTANCEREFWITHPARENT__Group_1_2__112195);
            rule__INSTANCEREFWITHPARENT__Group_1_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1_2__1"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1_2__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6084:1: rule__INSTANCEREFWITHPARENT__Group_1_2__1__Impl : ( RULE_ID ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6088:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6089:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6089:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6090:1: RULE_ID
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getIDTerminalRuleCall_1_2_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__INSTANCEREFWITHPARENT__Group_1_2__1__Impl12222); 
             after(grammarAccess.getINSTANCEREFWITHPARENTAccess().getIDTerminalRuleCall_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1_2__1__Impl"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1_2__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6101:1: rule__INSTANCEREFWITHPARENT__Group_1_2__2 : rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6105:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6106:2: rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2__212251);
            rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1_2__2"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6112:1: rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl : ( ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 ) ) ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 )* ) ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6116:1: ( ( ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 ) ) ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6117:1: ( ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 ) ) ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6117:1: ( ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 ) ) ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6118:1: ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 ) ) ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6118:1: ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6119:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 )
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getGroup_1_2_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6120:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6120:2: rule__INSTANCEREFWITHPARENT__Group_1_2_2__0
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__0_in_rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl12280);
            rule__INSTANCEREFWITHPARENT__Group_1_2_2__0();

            state._fsp--;


            }

             after(grammarAccess.getINSTANCEREFWITHPARENTAccess().getGroup_1_2_2()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6123:1: ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6124:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 )*
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getGroup_1_2_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6125:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==41) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6125:2: rule__INSTANCEREFWITHPARENT__Group_1_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__0_in_rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl12292);
            	    rule__INSTANCEREFWITHPARENT__Group_1_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

             after(grammarAccess.getINSTANCEREFWITHPARENTAccess().getGroup_1_2_2()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1_2_2__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6142:1: rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 : rule__INSTANCEREFWITHPARENT__Group_1_2_2__0__Impl rule__INSTANCEREFWITHPARENT__Group_1_2_2__1 ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6146:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0__Impl rule__INSTANCEREFWITHPARENT__Group_1_2_2__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6147:2: rule__INSTANCEREFWITHPARENT__Group_1_2_2__0__Impl rule__INSTANCEREFWITHPARENT__Group_1_2_2__1
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__0__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__012331);
            rule__INSTANCEREFWITHPARENT__Group_1_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__1_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__012334);
            rule__INSTANCEREFWITHPARENT__Group_1_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1_2_2__0"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1_2_2__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6154:1: rule__INSTANCEREFWITHPARENT__Group_1_2_2__0__Impl : ( '[' ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6158:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6159:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6159:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6160:1: '['
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getLeftSquareBracketKeyword_1_2_2_0()); 
            match(input,41,FOLLOW_41_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__0__Impl12362); 
             after(grammarAccess.getINSTANCEREFWITHPARENTAccess().getLeftSquareBracketKeyword_1_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1_2_2__0__Impl"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1_2_2__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6173:1: rule__INSTANCEREFWITHPARENT__Group_1_2_2__1 : rule__INSTANCEREFWITHPARENT__Group_1_2_2__1__Impl rule__INSTANCEREFWITHPARENT__Group_1_2_2__2 ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6177:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__1__Impl rule__INSTANCEREFWITHPARENT__Group_1_2_2__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6178:2: rule__INSTANCEREFWITHPARENT__Group_1_2_2__1__Impl rule__INSTANCEREFWITHPARENT__Group_1_2_2__2
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__1__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__112393);
            rule__INSTANCEREFWITHPARENT__Group_1_2_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__2_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__112396);
            rule__INSTANCEREFWITHPARENT__Group_1_2_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1_2_2__1"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1_2_2__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6185:1: rule__INSTANCEREFWITHPARENT__Group_1_2_2__1__Impl : ( RULE_LONG ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6189:1: ( ( RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6190:1: ( RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6190:1: ( RULE_LONG )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6191:1: RULE_LONG
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getLONGTerminalRuleCall_1_2_2_1()); 
            match(input,RULE_LONG,FOLLOW_RULE_LONG_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__1__Impl12423); 
             after(grammarAccess.getINSTANCEREFWITHPARENTAccess().getLONGTerminalRuleCall_1_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1_2_2__1__Impl"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1_2_2__2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6202:1: rule__INSTANCEREFWITHPARENT__Group_1_2_2__2 : rule__INSTANCEREFWITHPARENT__Group_1_2_2__2__Impl ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6206:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6207:2: rule__INSTANCEREFWITHPARENT__Group_1_2_2__2__Impl
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__2__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__212452);
            rule__INSTANCEREFWITHPARENT__Group_1_2_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1_2_2__2"


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1_2_2__2__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6213:1: rule__INSTANCEREFWITHPARENT__Group_1_2_2__2__Impl : ( ']' ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6217:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6218:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6218:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6219:1: ']'
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getRightSquareBracketKeyword_1_2_2_2()); 
            match(input,42,FOLLOW_42_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__2__Impl12480); 
             after(grammarAccess.getINSTANCEREFWITHPARENTAccess().getRightSquareBracketKeyword_1_2_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INSTANCEREFWITHPARENT__Group_1_2_2__2__Impl"


    // $ANTLR start "rule__CONNINSTREF__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6238:1: rule__CONNINSTREF__Group__0 : rule__CONNINSTREF__Group__0__Impl rule__CONNINSTREF__Group__1 ;
    public final void rule__CONNINSTREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6242:1: ( rule__CONNINSTREF__Group__0__Impl rule__CONNINSTREF__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6243:2: rule__CONNINSTREF__Group__0__Impl rule__CONNINSTREF__Group__1
            {
            pushFollow(FOLLOW_rule__CONNINSTREF__Group__0__Impl_in_rule__CONNINSTREF__Group__012517);
            rule__CONNINSTREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CONNINSTREF__Group__1_in_rule__CONNINSTREF__Group__012520);
            rule__CONNINSTREF__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CONNINSTREF__Group__0"


    // $ANTLR start "rule__CONNINSTREF__Group__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6250:1: rule__CONNINSTREF__Group__0__Impl : ( ( rule__CONNINSTREF__Group_0__0 )? ) ;
    public final void rule__CONNINSTREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6254:1: ( ( ( rule__CONNINSTREF__Group_0__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6255:1: ( ( rule__CONNINSTREF__Group_0__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6255:1: ( ( rule__CONNINSTREF__Group_0__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6256:1: ( rule__CONNINSTREF__Group_0__0 )?
            {
             before(grammarAccess.getCONNINSTREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6257:1: ( rule__CONNINSTREF__Group_0__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_LONG) ) {
                int LA44_1 = input.LA(2);

                if ( (LA44_1==53) ) {
                    alt44=1;
                }
            }
            switch (alt44) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6257:2: rule__CONNINSTREF__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__CONNINSTREF__Group_0__0_in_rule__CONNINSTREF__Group__0__Impl12547);
                    rule__CONNINSTREF__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCONNINSTREFAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CONNINSTREF__Group__0__Impl"


    // $ANTLR start "rule__CONNINSTREF__Group__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6267:1: rule__CONNINSTREF__Group__1 : rule__CONNINSTREF__Group__1__Impl ;
    public final void rule__CONNINSTREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6271:1: ( rule__CONNINSTREF__Group__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6272:2: rule__CONNINSTREF__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__CONNINSTREF__Group__1__Impl_in_rule__CONNINSTREF__Group__112578);
            rule__CONNINSTREF__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CONNINSTREF__Group__1"


    // $ANTLR start "rule__CONNINSTREF__Group__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6278:1: rule__CONNINSTREF__Group__1__Impl : ( RULE_LONG ) ;
    public final void rule__CONNINSTREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6282:1: ( ( RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6283:1: ( RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6283:1: ( RULE_LONG )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6284:1: RULE_LONG
            {
             before(grammarAccess.getCONNINSTREFAccess().getLONGTerminalRuleCall_1()); 
            match(input,RULE_LONG,FOLLOW_RULE_LONG_in_rule__CONNINSTREF__Group__1__Impl12605); 
             after(grammarAccess.getCONNINSTREFAccess().getLONGTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CONNINSTREF__Group__1__Impl"


    // $ANTLR start "rule__CONNINSTREF__Group_0__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6299:1: rule__CONNINSTREF__Group_0__0 : rule__CONNINSTREF__Group_0__0__Impl rule__CONNINSTREF__Group_0__1 ;
    public final void rule__CONNINSTREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6303:1: ( rule__CONNINSTREF__Group_0__0__Impl rule__CONNINSTREF__Group_0__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6304:2: rule__CONNINSTREF__Group_0__0__Impl rule__CONNINSTREF__Group_0__1
            {
            pushFollow(FOLLOW_rule__CONNINSTREF__Group_0__0__Impl_in_rule__CONNINSTREF__Group_0__012638);
            rule__CONNINSTREF__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CONNINSTREF__Group_0__1_in_rule__CONNINSTREF__Group_0__012641);
            rule__CONNINSTREF__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CONNINSTREF__Group_0__0"


    // $ANTLR start "rule__CONNINSTREF__Group_0__0__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6311:1: rule__CONNINSTREF__Group_0__0__Impl : ( RULE_LONG ) ;
    public final void rule__CONNINSTREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6315:1: ( ( RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6316:1: ( RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6316:1: ( RULE_LONG )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6317:1: RULE_LONG
            {
             before(grammarAccess.getCONNINSTREFAccess().getLONGTerminalRuleCall_0_0()); 
            match(input,RULE_LONG,FOLLOW_RULE_LONG_in_rule__CONNINSTREF__Group_0__0__Impl12668); 
             after(grammarAccess.getCONNINSTREFAccess().getLONGTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CONNINSTREF__Group_0__0__Impl"


    // $ANTLR start "rule__CONNINSTREF__Group_0__1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6328:1: rule__CONNINSTREF__Group_0__1 : rule__CONNINSTREF__Group_0__1__Impl ;
    public final void rule__CONNINSTREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6332:1: ( rule__CONNINSTREF__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6333:2: rule__CONNINSTREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__CONNINSTREF__Group_0__1__Impl_in_rule__CONNINSTREF__Group_0__112697);
            rule__CONNINSTREF__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CONNINSTREF__Group_0__1"


    // $ANTLR start "rule__CONNINSTREF__Group_0__1__Impl"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6339:1: rule__CONNINSTREF__Group_0__1__Impl : ( '.' ) ;
    public final void rule__CONNINSTREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6343:1: ( ( '.' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6344:1: ( '.' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6344:1: ( '.' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6345:1: '.'
            {
             before(grammarAccess.getCONNINSTREFAccess().getFullStopKeyword_0_1()); 
            match(input,53,FOLLOW_53_in_rule__CONNINSTREF__Group_0__1__Impl12725); 
             after(grammarAccess.getCONNINSTREFAccess().getFullStopKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CONNINSTREF__Group_0__1__Impl"


    // $ANTLR start "rule__SystemInstance__CategoryAssignment_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6363:1: rule__SystemInstance__CategoryAssignment_0 : ( ruleComponentCategory ) ;
    public final void rule__SystemInstance__CategoryAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6367:1: ( ( ruleComponentCategory ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6368:1: ( ruleComponentCategory )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6368:1: ( ruleComponentCategory )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6369:1: ruleComponentCategory
            {
             before(grammarAccess.getSystemInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_rule__SystemInstance__CategoryAssignment_012765);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6378:1: rule__SystemInstance__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SystemInstance__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6382:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6383:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6383:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6384:1: RULE_ID
            {
             before(grammarAccess.getSystemInstanceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SystemInstance__NameAssignment_112796); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6393:1: rule__SystemInstance__ComponentImplementationAssignment_3 : ( ( ruleIMPLREF ) ) ;
    public final void rule__SystemInstance__ComponentImplementationAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6397:1: ( ( ( ruleIMPLREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6398:1: ( ( ruleIMPLREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6398:1: ( ( ruleIMPLREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6399:1: ( ruleIMPLREF )
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationCrossReference_3_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6400:1: ( ruleIMPLREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6401:1: ruleIMPLREF
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationIMPLREFParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_ruleIMPLREF_in_rule__SystemInstance__ComponentImplementationAssignment_312831);
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


    // $ANTLR start "rule__SystemInstance__FeatureInstanceAssignment_5_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6412:1: rule__SystemInstance__FeatureInstanceAssignment_5_0 : ( ruleFeatureInstance ) ;
    public final void rule__SystemInstance__FeatureInstanceAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6416:1: ( ( ruleFeatureInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6417:1: ( ruleFeatureInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6417:1: ( ruleFeatureInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6418:1: ruleFeatureInstance
            {
             before(grammarAccess.getSystemInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_5_0_0()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_rule__SystemInstance__FeatureInstanceAssignment_5_012866);
            ruleFeatureInstance();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_5_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__FeatureInstanceAssignment_5_0"


    // $ANTLR start "rule__SystemInstance__ComponentInstanceAssignment_5_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6427:1: rule__SystemInstance__ComponentInstanceAssignment_5_1 : ( ruleComponentInstance ) ;
    public final void rule__SystemInstance__ComponentInstanceAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6431:1: ( ( ruleComponentInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6432:1: ( ruleComponentInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6432:1: ( ruleComponentInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6433:1: ruleComponentInstance
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_ruleComponentInstance_in_rule__SystemInstance__ComponentInstanceAssignment_5_112897);
            ruleComponentInstance();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__ComponentInstanceAssignment_5_1"


    // $ANTLR start "rule__SystemInstance__ConnectionInstanceAssignment_5_2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6442:1: rule__SystemInstance__ConnectionInstanceAssignment_5_2 : ( ruleConnectionInstance ) ;
    public final void rule__SystemInstance__ConnectionInstanceAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6446:1: ( ( ruleConnectionInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6447:1: ( ruleConnectionInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6447:1: ( ruleConnectionInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6448:1: ruleConnectionInstance
            {
             before(grammarAccess.getSystemInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_5_2_0()); 
            pushFollow(FOLLOW_ruleConnectionInstance_in_rule__SystemInstance__ConnectionInstanceAssignment_5_212928);
            ruleConnectionInstance();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__ConnectionInstanceAssignment_5_2"


    // $ANTLR start "rule__SystemInstance__FlowSpecificationAssignment_5_3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6457:1: rule__SystemInstance__FlowSpecificationAssignment_5_3 : ( ruleFlowSpecificationInstance ) ;
    public final void rule__SystemInstance__FlowSpecificationAssignment_5_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6461:1: ( ( ruleFlowSpecificationInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6462:1: ( ruleFlowSpecificationInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6462:1: ( ruleFlowSpecificationInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6463:1: ruleFlowSpecificationInstance
            {
             before(grammarAccess.getSystemInstanceAccess().getFlowSpecificationFlowSpecificationInstanceParserRuleCall_5_3_0()); 
            pushFollow(FOLLOW_ruleFlowSpecificationInstance_in_rule__SystemInstance__FlowSpecificationAssignment_5_312959);
            ruleFlowSpecificationInstance();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getFlowSpecificationFlowSpecificationInstanceParserRuleCall_5_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__FlowSpecificationAssignment_5_3"


    // $ANTLR start "rule__SystemInstance__SystemOperationModeAssignment_5_4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6472:1: rule__SystemInstance__SystemOperationModeAssignment_5_4 : ( ruleSystemOperationMode ) ;
    public final void rule__SystemInstance__SystemOperationModeAssignment_5_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6476:1: ( ( ruleSystemOperationMode ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6477:1: ( ruleSystemOperationMode )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6477:1: ( ruleSystemOperationMode )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6478:1: ruleSystemOperationMode
            {
             before(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_5_4_0()); 
            pushFollow(FOLLOW_ruleSystemOperationMode_in_rule__SystemInstance__SystemOperationModeAssignment_5_412990);
            ruleSystemOperationMode();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_5_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__SystemOperationModeAssignment_5_4"


    // $ANTLR start "rule__FeatureInstance__DirectionAssignment_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6487:1: rule__FeatureInstance__DirectionAssignment_0 : ( ruleDirectionType ) ;
    public final void rule__FeatureInstance__DirectionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6491:1: ( ( ruleDirectionType ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6492:1: ( ruleDirectionType )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6492:1: ( ruleDirectionType )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6493:1: ruleDirectionType
            {
             before(grammarAccess.getFeatureInstanceAccess().getDirectionDirectionTypeParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleDirectionType_in_rule__FeatureInstance__DirectionAssignment_013021);
            ruleDirectionType();

            state._fsp--;

             after(grammarAccess.getFeatureInstanceAccess().getDirectionDirectionTypeParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__DirectionAssignment_0"


    // $ANTLR start "rule__FeatureInstance__CategoryAssignment_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6502:1: rule__FeatureInstance__CategoryAssignment_1 : ( ruleFeatureCategory ) ;
    public final void rule__FeatureInstance__CategoryAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6506:1: ( ( ruleFeatureCategory ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6507:1: ( ruleFeatureCategory )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6507:1: ( ruleFeatureCategory )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6508:1: ruleFeatureCategory
            {
             before(grammarAccess.getFeatureInstanceAccess().getCategoryFeatureCategoryParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleFeatureCategory_in_rule__FeatureInstance__CategoryAssignment_113052);
            ruleFeatureCategory();

            state._fsp--;

             after(grammarAccess.getFeatureInstanceAccess().getCategoryFeatureCategoryParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__CategoryAssignment_1"


    // $ANTLR start "rule__FeatureInstance__NameAssignment_2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6517:1: rule__FeatureInstance__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__FeatureInstance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6521:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6522:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6522:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6523:1: RULE_ID
            {
             before(grammarAccess.getFeatureInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FeatureInstance__NameAssignment_213083); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6532:1: rule__FeatureInstance__IndexAssignment_3_1 : ( RULE_LONG ) ;
    public final void rule__FeatureInstance__IndexAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6536:1: ( ( RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6537:1: ( RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6537:1: ( RULE_LONG )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6538:1: RULE_LONG
            {
             before(grammarAccess.getFeatureInstanceAccess().getIndexLONGTerminalRuleCall_3_1_0()); 
            match(input,RULE_LONG,FOLLOW_RULE_LONG_in_rule__FeatureInstance__IndexAssignment_3_113114); 
             after(grammarAccess.getFeatureInstanceAccess().getIndexLONGTerminalRuleCall_3_1_0()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6547:1: rule__FeatureInstance__FeatureAssignment_5 : ( ( ruleFEATREF ) ) ;
    public final void rule__FeatureInstance__FeatureAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6551:1: ( ( ( ruleFEATREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6552:1: ( ( ruleFEATREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6552:1: ( ( ruleFEATREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6553:1: ( ruleFEATREF )
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureCrossReference_5_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6554:1: ( ruleFEATREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6555:1: ruleFEATREF
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureFEATREFParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_ruleFEATREF_in_rule__FeatureInstance__FeatureAssignment_513149);
            ruleFEATREF();

            state._fsp--;

             after(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureFEATREFParserRuleCall_5_0_1()); 

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


    // $ANTLR start "rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6566:1: rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3_0 : ( ( ruleCONNINSTREF ) ) ;
    public final void rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6570:1: ( ( ( ruleCONNINSTREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6571:1: ( ( ruleCONNINSTREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6571:1: ( ( ruleCONNINSTREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6572:1: ( ruleCONNINSTREF )
            {
             before(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_6_3_0_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6573:1: ( ruleCONNINSTREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6574:1: ruleCONNINSTREF
            {
             before(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_6_3_0_0_1()); 
            pushFollow(FOLLOW_ruleCONNINSTREF_in_rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3_013188);
            ruleCONNINSTREF();

            state._fsp--;

             after(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_6_3_0_0_1()); 

            }

             after(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_6_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3_0"


    // $ANTLR start "rule__FeatureInstance__SrcFlowSpecAssignment_6_3_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6585:1: rule__FeatureInstance__SrcFlowSpecAssignment_6_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__FeatureInstance__SrcFlowSpecAssignment_6_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6589:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6590:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6590:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6591:1: ( RULE_ID )
            {
             before(grammarAccess.getFeatureInstanceAccess().getSrcFlowSpecFlowSpecificationInstanceCrossReference_6_3_1_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6592:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6593:1: RULE_ID
            {
             before(grammarAccess.getFeatureInstanceAccess().getSrcFlowSpecFlowSpecificationInstanceIDTerminalRuleCall_6_3_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FeatureInstance__SrcFlowSpecAssignment_6_3_113227); 
             after(grammarAccess.getFeatureInstanceAccess().getSrcFlowSpecFlowSpecificationInstanceIDTerminalRuleCall_6_3_1_0_1()); 

            }

             after(grammarAccess.getFeatureInstanceAccess().getSrcFlowSpecFlowSpecificationInstanceCrossReference_6_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__SrcFlowSpecAssignment_6_3_1"


    // $ANTLR start "rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6604:1: rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1_0 : ( ( ruleCONNINSTREF ) ) ;
    public final void rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6608:1: ( ( ( ruleCONNINSTREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6609:1: ( ( ruleCONNINSTREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6609:1: ( ( ruleCONNINSTREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6610:1: ( ruleCONNINSTREF )
            {
             before(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_6_4_1_0_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6611:1: ( ruleCONNINSTREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6612:1: ruleCONNINSTREF
            {
             before(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_6_4_1_0_0_1()); 
            pushFollow(FOLLOW_ruleCONNINSTREF_in_rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1_013266);
            ruleCONNINSTREF();

            state._fsp--;

             after(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_6_4_1_0_0_1()); 

            }

             after(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_6_4_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1_0"


    // $ANTLR start "rule__FeatureInstance__SrcFlowSpecAssignment_6_4_1_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6623:1: rule__FeatureInstance__SrcFlowSpecAssignment_6_4_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__FeatureInstance__SrcFlowSpecAssignment_6_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6627:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6628:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6628:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6629:1: ( RULE_ID )
            {
             before(grammarAccess.getFeatureInstanceAccess().getSrcFlowSpecFlowSpecificationInstanceCrossReference_6_4_1_1_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6630:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6631:1: RULE_ID
            {
             before(grammarAccess.getFeatureInstanceAccess().getSrcFlowSpecFlowSpecificationInstanceIDTerminalRuleCall_6_4_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FeatureInstance__SrcFlowSpecAssignment_6_4_1_113305); 
             after(grammarAccess.getFeatureInstanceAccess().getSrcFlowSpecFlowSpecificationInstanceIDTerminalRuleCall_6_4_1_1_0_1()); 

            }

             after(grammarAccess.getFeatureInstanceAccess().getSrcFlowSpecFlowSpecificationInstanceCrossReference_6_4_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__SrcFlowSpecAssignment_6_4_1_1"


    // $ANTLR start "rule__FeatureInstance__DstConnectionInstanceAssignment_7_3_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6642:1: rule__FeatureInstance__DstConnectionInstanceAssignment_7_3_0 : ( ( ruleCONNINSTREF ) ) ;
    public final void rule__FeatureInstance__DstConnectionInstanceAssignment_7_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6646:1: ( ( ( ruleCONNINSTREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6647:1: ( ( ruleCONNINSTREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6647:1: ( ( ruleCONNINSTREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6648:1: ( ruleCONNINSTREF )
            {
             before(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_7_3_0_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6649:1: ( ruleCONNINSTREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6650:1: ruleCONNINSTREF
            {
             before(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_7_3_0_0_1()); 
            pushFollow(FOLLOW_ruleCONNINSTREF_in_rule__FeatureInstance__DstConnectionInstanceAssignment_7_3_013344);
            ruleCONNINSTREF();

            state._fsp--;

             after(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_7_3_0_0_1()); 

            }

             after(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_7_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__DstConnectionInstanceAssignment_7_3_0"


    // $ANTLR start "rule__FeatureInstance__DstFlowSpecAssignment_7_3_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6661:1: rule__FeatureInstance__DstFlowSpecAssignment_7_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__FeatureInstance__DstFlowSpecAssignment_7_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6665:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6666:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6666:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6667:1: ( RULE_ID )
            {
             before(grammarAccess.getFeatureInstanceAccess().getDstFlowSpecFlowSpecificationInstanceCrossReference_7_3_1_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6668:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6669:1: RULE_ID
            {
             before(grammarAccess.getFeatureInstanceAccess().getDstFlowSpecFlowSpecificationInstanceIDTerminalRuleCall_7_3_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FeatureInstance__DstFlowSpecAssignment_7_3_113383); 
             after(grammarAccess.getFeatureInstanceAccess().getDstFlowSpecFlowSpecificationInstanceIDTerminalRuleCall_7_3_1_0_1()); 

            }

             after(grammarAccess.getFeatureInstanceAccess().getDstFlowSpecFlowSpecificationInstanceCrossReference_7_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__DstFlowSpecAssignment_7_3_1"


    // $ANTLR start "rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6680:1: rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1_0 : ( ( ruleCONNINSTREF ) ) ;
    public final void rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6684:1: ( ( ( ruleCONNINSTREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6685:1: ( ( ruleCONNINSTREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6685:1: ( ( ruleCONNINSTREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6686:1: ( ruleCONNINSTREF )
            {
             before(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_7_4_1_0_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6687:1: ( ruleCONNINSTREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6688:1: ruleCONNINSTREF
            {
             before(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_7_4_1_0_0_1()); 
            pushFollow(FOLLOW_ruleCONNINSTREF_in_rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1_013422);
            ruleCONNINSTREF();

            state._fsp--;

             after(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_7_4_1_0_0_1()); 

            }

             after(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_7_4_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1_0"


    // $ANTLR start "rule__FeatureInstance__DstFlowSpecAssignment_7_4_1_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6699:1: rule__FeatureInstance__DstFlowSpecAssignment_7_4_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__FeatureInstance__DstFlowSpecAssignment_7_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6703:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6704:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6704:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6705:1: ( RULE_ID )
            {
             before(grammarAccess.getFeatureInstanceAccess().getDstFlowSpecFlowSpecificationInstanceCrossReference_7_4_1_1_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6706:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6707:1: RULE_ID
            {
             before(grammarAccess.getFeatureInstanceAccess().getDstFlowSpecFlowSpecificationInstanceIDTerminalRuleCall_7_4_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FeatureInstance__DstFlowSpecAssignment_7_4_1_113461); 
             after(grammarAccess.getFeatureInstanceAccess().getDstFlowSpecFlowSpecificationInstanceIDTerminalRuleCall_7_4_1_1_0_1()); 

            }

             after(grammarAccess.getFeatureInstanceAccess().getDstFlowSpecFlowSpecificationInstanceCrossReference_7_4_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__DstFlowSpecAssignment_7_4_1_1"


    // $ANTLR start "rule__FeatureInstance__FeatureInstanceAssignment_8_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6718:1: rule__FeatureInstance__FeatureInstanceAssignment_8_1 : ( ruleFeatureInstance ) ;
    public final void rule__FeatureInstance__FeatureInstanceAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6722:1: ( ( ruleFeatureInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6723:1: ( ruleFeatureInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6723:1: ( ruleFeatureInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6724:1: ruleFeatureInstance
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_rule__FeatureInstance__FeatureInstanceAssignment_8_113496);
            ruleFeatureInstance();

            state._fsp--;

             after(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__FeatureInstanceAssignment_8_1"


    // $ANTLR start "rule__ComponentInstance__CategoryAssignment_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6733:1: rule__ComponentInstance__CategoryAssignment_0 : ( ruleComponentCategory ) ;
    public final void rule__ComponentInstance__CategoryAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6737:1: ( ( ruleComponentCategory ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6738:1: ( ruleComponentCategory )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6738:1: ( ruleComponentCategory )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6739:1: ruleComponentCategory
            {
             before(grammarAccess.getComponentInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_rule__ComponentInstance__CategoryAssignment_013527);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6748:1: rule__ComponentInstance__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ComponentInstance__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6752:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6753:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6753:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6754:1: RULE_ID
            {
             before(grammarAccess.getComponentInstanceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ComponentInstance__NameAssignment_113558); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6763:1: rule__ComponentInstance__IndexAssignment_2_1 : ( RULE_LONG ) ;
    public final void rule__ComponentInstance__IndexAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6767:1: ( ( RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6768:1: ( RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6768:1: ( RULE_LONG )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6769:1: RULE_LONG
            {
             before(grammarAccess.getComponentInstanceAccess().getIndexLONGTerminalRuleCall_2_1_0()); 
            match(input,RULE_LONG,FOLLOW_RULE_LONG_in_rule__ComponentInstance__IndexAssignment_2_113589); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6778:1: rule__ComponentInstance__SubcomponentAssignment_4 : ( ( ruleSUBREF ) ) ;
    public final void rule__ComponentInstance__SubcomponentAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6782:1: ( ( ( ruleSUBREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6783:1: ( ( ruleSUBREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6783:1: ( ( ruleSUBREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6784:1: ( ruleSUBREF )
            {
             before(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentCrossReference_4_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6785:1: ( ruleSUBREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6786:1: ruleSUBREF
            {
             before(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentSUBREFParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_ruleSUBREF_in_rule__ComponentInstance__SubcomponentAssignment_413624);
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


    // $ANTLR start "rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6797:1: rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3 : ( ( ruleCONNINSTREF ) ) ;
    public final void rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6801:1: ( ( ( ruleCONNINSTREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6802:1: ( ( ruleCONNINSTREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6802:1: ( ( ruleCONNINSTREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6803:1: ( ruleCONNINSTREF )
            {
             before(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_5_3_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6804:1: ( ruleCONNINSTREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6805:1: ruleCONNINSTREF
            {
             before(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_5_3_0_1()); 
            pushFollow(FOLLOW_ruleCONNINSTREF_in_rule__ComponentInstance__SrcConnectionInstanceAssignment_5_313663);
            ruleCONNINSTREF();

            state._fsp--;

             after(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_5_3_0_1()); 

            }

             after(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_5_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3"


    // $ANTLR start "rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6816:1: rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1 : ( ( ruleCONNINSTREF ) ) ;
    public final void rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6820:1: ( ( ( ruleCONNINSTREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6821:1: ( ( ruleCONNINSTREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6821:1: ( ( ruleCONNINSTREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6822:1: ( ruleCONNINSTREF )
            {
             before(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_5_4_1_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6823:1: ( ruleCONNINSTREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6824:1: ruleCONNINSTREF
            {
             before(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_5_4_1_0_1()); 
            pushFollow(FOLLOW_ruleCONNINSTREF_in_rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_113702);
            ruleCONNINSTREF();

            state._fsp--;

             after(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_5_4_1_0_1()); 

            }

             after(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_5_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1"


    // $ANTLR start "rule__ComponentInstance__DstConnectionInstanceAssignment_6_3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6835:1: rule__ComponentInstance__DstConnectionInstanceAssignment_6_3 : ( ( ruleCONNINSTREF ) ) ;
    public final void rule__ComponentInstance__DstConnectionInstanceAssignment_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6839:1: ( ( ( ruleCONNINSTREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6840:1: ( ( ruleCONNINSTREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6840:1: ( ( ruleCONNINSTREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6841:1: ( ruleCONNINSTREF )
            {
             before(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_6_3_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6842:1: ( ruleCONNINSTREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6843:1: ruleCONNINSTREF
            {
             before(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_6_3_0_1()); 
            pushFollow(FOLLOW_ruleCONNINSTREF_in_rule__ComponentInstance__DstConnectionInstanceAssignment_6_313741);
            ruleCONNINSTREF();

            state._fsp--;

             after(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_6_3_0_1()); 

            }

             after(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_6_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__DstConnectionInstanceAssignment_6_3"


    // $ANTLR start "rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6854:1: rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1 : ( ( ruleCONNINSTREF ) ) ;
    public final void rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6858:1: ( ( ( ruleCONNINSTREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6859:1: ( ( ruleCONNINSTREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6859:1: ( ( ruleCONNINSTREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6860:1: ( ruleCONNINSTREF )
            {
             before(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_6_4_1_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6861:1: ( ruleCONNINSTREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6862:1: ruleCONNINSTREF
            {
             before(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_6_4_1_0_1()); 
            pushFollow(FOLLOW_ruleCONNINSTREF_in_rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_113780);
            ruleCONNINSTREF();

            state._fsp--;

             after(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_6_4_1_0_1()); 

            }

             after(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_6_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1"


    // $ANTLR start "rule__ComponentInstance__FeatureInstanceAssignment_7_1_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6873:1: rule__ComponentInstance__FeatureInstanceAssignment_7_1_0 : ( ruleFeatureInstance ) ;
    public final void rule__ComponentInstance__FeatureInstanceAssignment_7_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6877:1: ( ( ruleFeatureInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6878:1: ( ruleFeatureInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6878:1: ( ruleFeatureInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6879:1: ruleFeatureInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_7_1_0_0()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_rule__ComponentInstance__FeatureInstanceAssignment_7_1_013815);
            ruleFeatureInstance();

            state._fsp--;

             after(grammarAccess.getComponentInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_7_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__FeatureInstanceAssignment_7_1_0"


    // $ANTLR start "rule__ComponentInstance__ComponentInstanceAssignment_7_1_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6888:1: rule__ComponentInstance__ComponentInstanceAssignment_7_1_1 : ( ruleComponentInstance ) ;
    public final void rule__ComponentInstance__ComponentInstanceAssignment_7_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6892:1: ( ( ruleComponentInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6893:1: ( ruleComponentInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6893:1: ( ruleComponentInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6894:1: ruleComponentInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_7_1_1_0()); 
            pushFollow(FOLLOW_ruleComponentInstance_in_rule__ComponentInstance__ComponentInstanceAssignment_7_1_113846);
            ruleComponentInstance();

            state._fsp--;

             after(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_7_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__ComponentInstanceAssignment_7_1_1"


    // $ANTLR start "rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6903:1: rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2 : ( ruleConnectionInstance ) ;
    public final void rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6907:1: ( ( ruleConnectionInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6908:1: ( ruleConnectionInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6908:1: ( ruleConnectionInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6909:1: ruleConnectionInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_7_1_2_0()); 
            pushFollow(FOLLOW_ruleConnectionInstance_in_rule__ComponentInstance__ConnectionInstanceAssignment_7_1_213877);
            ruleConnectionInstance();

            state._fsp--;

             after(grammarAccess.getComponentInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_7_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2"


    // $ANTLR start "rule__ComponentInstance__FlowSpecificationAssignment_7_1_3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6918:1: rule__ComponentInstance__FlowSpecificationAssignment_7_1_3 : ( ruleFlowSpecificationInstance ) ;
    public final void rule__ComponentInstance__FlowSpecificationAssignment_7_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6922:1: ( ( ruleFlowSpecificationInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6923:1: ( ruleFlowSpecificationInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6923:1: ( ruleFlowSpecificationInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6924:1: ruleFlowSpecificationInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getFlowSpecificationFlowSpecificationInstanceParserRuleCall_7_1_3_0()); 
            pushFollow(FOLLOW_ruleFlowSpecificationInstance_in_rule__ComponentInstance__FlowSpecificationAssignment_7_1_313908);
            ruleFlowSpecificationInstance();

            state._fsp--;

             after(grammarAccess.getComponentInstanceAccess().getFlowSpecificationFlowSpecificationInstanceParserRuleCall_7_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__FlowSpecificationAssignment_7_1_3"


    // $ANTLR start "rule__ConnectionInstance__CompleteAssignment_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6933:1: rule__ConnectionInstance__CompleteAssignment_0 : ( ( 'complete' ) ) ;
    public final void rule__ConnectionInstance__CompleteAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6937:1: ( ( ( 'complete' ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6938:1: ( ( 'complete' ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6938:1: ( ( 'complete' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6939:1: ( 'complete' )
            {
             before(grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_0_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6940:1: ( 'complete' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6941:1: 'complete'
            {
             before(grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_0_0()); 
            match(input,55,FOLLOW_55_in_rule__ConnectionInstance__CompleteAssignment_013944); 
             after(grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_0_0()); 

            }

             after(grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__CompleteAssignment_0"


    // $ANTLR start "rule__ConnectionInstance__KindAssignment_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6956:1: rule__ConnectionInstance__KindAssignment_1 : ( ruleConnectionKind ) ;
    public final void rule__ConnectionInstance__KindAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6960:1: ( ( ruleConnectionKind ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6961:1: ( ruleConnectionKind )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6961:1: ( ruleConnectionKind )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6962:1: ruleConnectionKind
            {
             before(grammarAccess.getConnectionInstanceAccess().getKindConnectionKindParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleConnectionKind_in_rule__ConnectionInstance__KindAssignment_113983);
            ruleConnectionKind();

            state._fsp--;

             after(grammarAccess.getConnectionInstanceAccess().getKindConnectionKindParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__KindAssignment_1"


    // $ANTLR start "rule__ConnectionInstance__NameAssignment_2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6971:1: rule__ConnectionInstance__NameAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ConnectionInstance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6975:1: ( ( RULE_STRING ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6976:1: ( RULE_STRING )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6976:1: ( RULE_STRING )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6977:1: RULE_STRING
            {
             before(grammarAccess.getConnectionInstanceAccess().getNameSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ConnectionInstance__NameAssignment_214014); 
             after(grammarAccess.getConnectionInstanceAccess().getNameSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__NameAssignment_2"


    // $ANTLR start "rule__ConnectionInstance__SourceAssignment_4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6986:1: rule__ConnectionInstance__SourceAssignment_4 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionInstance__SourceAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6990:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6991:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6991:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6992:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndCrossReference_4_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6993:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6994:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndINSTANCEREFParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__SourceAssignment_414049);
            ruleINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndINSTANCEREFParserRuleCall_4_0_1()); 

            }

             after(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__SourceAssignment_4"


    // $ANTLR start "rule__ConnectionInstance__BidirectionalAssignment_5_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7005:1: rule__ConnectionInstance__BidirectionalAssignment_5_0 : ( ( '<->' ) ) ;
    public final void rule__ConnectionInstance__BidirectionalAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7009:1: ( ( ( '<->' ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7010:1: ( ( '<->' ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7010:1: ( ( '<->' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7011:1: ( '<->' )
            {
             before(grammarAccess.getConnectionInstanceAccess().getBidirectionalLessThanSignHyphenMinusGreaterThanSignKeyword_5_0_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7012:1: ( '<->' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7013:1: '<->'
            {
             before(grammarAccess.getConnectionInstanceAccess().getBidirectionalLessThanSignHyphenMinusGreaterThanSignKeyword_5_0_0()); 
            match(input,56,FOLLOW_56_in_rule__ConnectionInstance__BidirectionalAssignment_5_014089); 
             after(grammarAccess.getConnectionInstanceAccess().getBidirectionalLessThanSignHyphenMinusGreaterThanSignKeyword_5_0_0()); 

            }

             after(grammarAccess.getConnectionInstanceAccess().getBidirectionalLessThanSignHyphenMinusGreaterThanSignKeyword_5_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__BidirectionalAssignment_5_0"


    // $ANTLR start "rule__ConnectionInstance__DestinationAssignment_6"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7028:1: rule__ConnectionInstance__DestinationAssignment_6 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionInstance__DestinationAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7032:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7033:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7033:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7034:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndCrossReference_6_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7035:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7036:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndINSTANCEREFParserRuleCall_6_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__DestinationAssignment_614132);
            ruleINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndINSTANCEREFParserRuleCall_6_0_1()); 

            }

             after(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndCrossReference_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__DestinationAssignment_6"


    // $ANTLR start "rule__ConnectionInstance__ConnectionReferenceAssignment_8"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7047:1: rule__ConnectionInstance__ConnectionReferenceAssignment_8 : ( ruleConnectionReference ) ;
    public final void rule__ConnectionInstance__ConnectionReferenceAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7051:1: ( ( ruleConnectionReference ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7052:1: ( ruleConnectionReference )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7052:1: ( ruleConnectionReference )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7053:1: ruleConnectionReference
            {
             before(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceConnectionReferenceParserRuleCall_8_0()); 
            pushFollow(FOLLOW_ruleConnectionReference_in_rule__ConnectionInstance__ConnectionReferenceAssignment_814167);
            ruleConnectionReference();

            state._fsp--;

             after(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceConnectionReferenceParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionInstance__ConnectionReferenceAssignment_8"


    // $ANTLR start "rule__ConnectionReference__SourceAssignment_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7062:1: rule__ConnectionReference__SourceAssignment_0 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionReference__SourceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7066:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7067:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7067:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7068:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndCrossReference_0_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7069:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7070:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndINSTANCEREFParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__SourceAssignment_014202);
            ruleINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndINSTANCEREFParserRuleCall_0_0_1()); 

            }

             after(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionReference__SourceAssignment_0"


    // $ANTLR start "rule__ConnectionReference__DestinationAssignment_2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7081:1: rule__ConnectionReference__DestinationAssignment_2 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionReference__DestinationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7085:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7086:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7086:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7087:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndCrossReference_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7088:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7089:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndINSTANCEREFParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__DestinationAssignment_214241);
            ruleINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndINSTANCEREFParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionReference__DestinationAssignment_2"


    // $ANTLR start "rule__ConnectionReference__ConnectionAssignment_4"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7100:1: rule__ConnectionReference__ConnectionAssignment_4 : ( ( ruleSUBREF ) ) ;
    public final void rule__ConnectionReference__ConnectionAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7104:1: ( ( ( ruleSUBREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7105:1: ( ( ruleSUBREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7105:1: ( ( ruleSUBREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7106:1: ( ruleSUBREF )
            {
             before(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionCrossReference_4_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7107:1: ( ruleSUBREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7108:1: ruleSUBREF
            {
             before(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionSUBREFParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_ruleSUBREF_in_rule__ConnectionReference__ConnectionAssignment_414280);
            ruleSUBREF();

            state._fsp--;

             after(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionSUBREFParserRuleCall_4_0_1()); 

            }

             after(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionReference__ConnectionAssignment_4"


    // $ANTLR start "rule__ConnectionReference__ContextAssignment_6"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7119:1: rule__ConnectionReference__ContextAssignment_6 : ( ( ruleINSTANCEREFWITHPARENT ) ) ;
    public final void rule__ConnectionReference__ContextAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7123:1: ( ( ( ruleINSTANCEREFWITHPARENT ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7124:1: ( ( ruleINSTANCEREFWITHPARENT ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7124:1: ( ( ruleINSTANCEREFWITHPARENT ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7125:1: ( ruleINSTANCEREFWITHPARENT )
            {
             before(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceCrossReference_6_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7126:1: ( ruleINSTANCEREFWITHPARENT )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7127:1: ruleINSTANCEREFWITHPARENT
            {
             before(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceINSTANCEREFWITHPARENTParserRuleCall_6_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREFWITHPARENT_in_rule__ConnectionReference__ContextAssignment_614319);
            ruleINSTANCEREFWITHPARENT();

            state._fsp--;

             after(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceINSTANCEREFWITHPARENTParserRuleCall_6_0_1()); 

            }

             after(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceCrossReference_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionReference__ContextAssignment_6"


    // $ANTLR start "rule__FlowSpecificationInstance__NameAssignment_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7138:1: rule__FlowSpecificationInstance__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__FlowSpecificationInstance__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7142:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7143:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7143:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7144:1: RULE_ID
            {
             before(grammarAccess.getFlowSpecificationInstanceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FlowSpecificationInstance__NameAssignment_114354); 
             after(grammarAccess.getFlowSpecificationInstanceAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecificationInstance__NameAssignment_1"


    // $ANTLR start "rule__FlowSpecificationInstance__SourceAssignment_3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7153:1: rule__FlowSpecificationInstance__SourceAssignment_3 : ( ( ruleSIMPLEINSTANCEREF ) ) ;
    public final void rule__FlowSpecificationInstance__SourceAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7157:1: ( ( ( ruleSIMPLEINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7158:1: ( ( ruleSIMPLEINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7158:1: ( ( ruleSIMPLEINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7159:1: ( ruleSIMPLEINSTANCEREF )
            {
             before(grammarAccess.getFlowSpecificationInstanceAccess().getSourceFeatureInstanceCrossReference_3_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7160:1: ( ruleSIMPLEINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7161:1: ruleSIMPLEINSTANCEREF
            {
             before(grammarAccess.getFlowSpecificationInstanceAccess().getSourceFeatureInstanceSIMPLEINSTANCEREFParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_ruleSIMPLEINSTANCEREF_in_rule__FlowSpecificationInstance__SourceAssignment_314389);
            ruleSIMPLEINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getFlowSpecificationInstanceAccess().getSourceFeatureInstanceSIMPLEINSTANCEREFParserRuleCall_3_0_1()); 

            }

             after(grammarAccess.getFlowSpecificationInstanceAccess().getSourceFeatureInstanceCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecificationInstance__SourceAssignment_3"


    // $ANTLR start "rule__FlowSpecificationInstance__DestinationAssignment_5"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7172:1: rule__FlowSpecificationInstance__DestinationAssignment_5 : ( ( ruleSIMPLEINSTANCEREF ) ) ;
    public final void rule__FlowSpecificationInstance__DestinationAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7176:1: ( ( ( ruleSIMPLEINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7177:1: ( ( ruleSIMPLEINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7177:1: ( ( ruleSIMPLEINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7178:1: ( ruleSIMPLEINSTANCEREF )
            {
             before(grammarAccess.getFlowSpecificationInstanceAccess().getDestinationFeatureInstanceCrossReference_5_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7179:1: ( ruleSIMPLEINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7180:1: ruleSIMPLEINSTANCEREF
            {
             before(grammarAccess.getFlowSpecificationInstanceAccess().getDestinationFeatureInstanceSIMPLEINSTANCEREFParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_ruleSIMPLEINSTANCEREF_in_rule__FlowSpecificationInstance__DestinationAssignment_514428);
            ruleSIMPLEINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getFlowSpecificationInstanceAccess().getDestinationFeatureInstanceSIMPLEINSTANCEREFParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getFlowSpecificationInstanceAccess().getDestinationFeatureInstanceCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecificationInstance__DestinationAssignment_5"


    // $ANTLR start "rule__FlowSpecificationInstance__FlowSpecificationAssignment_8"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7191:1: rule__FlowSpecificationInstance__FlowSpecificationAssignment_8 : ( ( ruleFEATREF ) ) ;
    public final void rule__FlowSpecificationInstance__FlowSpecificationAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7195:1: ( ( ( ruleFEATREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7196:1: ( ( ruleFEATREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7196:1: ( ( ruleFEATREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7197:1: ( ruleFEATREF )
            {
             before(grammarAccess.getFlowSpecificationInstanceAccess().getFlowSpecificationFlowSpecificationCrossReference_8_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7198:1: ( ruleFEATREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7199:1: ruleFEATREF
            {
             before(grammarAccess.getFlowSpecificationInstanceAccess().getFlowSpecificationFlowSpecificationFEATREFParserRuleCall_8_0_1()); 
            pushFollow(FOLLOW_ruleFEATREF_in_rule__FlowSpecificationInstance__FlowSpecificationAssignment_814467);
            ruleFEATREF();

            state._fsp--;

             after(grammarAccess.getFlowSpecificationInstanceAccess().getFlowSpecificationFlowSpecificationFEATREFParserRuleCall_8_0_1()); 

            }

             after(grammarAccess.getFlowSpecificationInstanceAccess().getFlowSpecificationFlowSpecificationCrossReference_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FlowSpecificationInstance__FlowSpecificationAssignment_8"


    // $ANTLR start "rule__SystemOperationMode__NameAssignment_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7210:1: rule__SystemOperationMode__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__SystemOperationMode__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7214:1: ( ( RULE_STRING ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7215:1: ( RULE_STRING )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7215:1: ( RULE_STRING )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:7216:1: RULE_STRING
            {
             before(grammarAccess.getSystemOperationModeAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__SystemOperationMode__NameAssignment_114502); 
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


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\22\uffff";
    static final String DFA10_eofS =
        "\10\uffff\1\14\1\uffff\1\16\7\uffff";
    static final String DFA10_minS =
        "\1\25\7\uffff\1\4\1\uffff\1\4\1\26\6\uffff";
    static final String DFA10_maxS =
        "\1\64\7\uffff\1\63\1\uffff\1\63\1\33\6\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\2\uffff\1\10\1\11\1\14\1\13\1\15\1\16";
    static final String DFA10_specialS =
        "\22\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\25\uffff\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\14\56\uffff\1\15",
            "",
            "\1\16\56\uffff\1\17",
            "\1\20\4\uffff\1\21",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "864:1: rule__ComponentCategory__Alternatives : ( ( 'abstract' ) | ( 'bus' ) | ( 'data' ) | ( 'device' ) | ( 'memory' ) | ( 'process' ) | ( 'processor' ) | ( 'subprogram' ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( 'system' ) | ( ( rule__ComponentCategory__Group_10__0 ) ) | ( 'thread' ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( ( rule__ComponentCategory__Group_13__0 ) ) );";
        }
    }
 

    public static final BitSet FOLLOW_ruleSystemInstance_in_entryRuleSystemInstance61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemInstance68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__0_in_ruleSystemInstance94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_entryRuleFeatureInstance121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureInstance128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__0_in_ruleFeatureInstance154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_entryRuleComponentInstance181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentInstance188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__0_in_ruleComponentInstance214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_entryRuleConnectionInstance241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionInstance248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__0_in_ruleConnectionInstance274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionReference_in_entryRuleConnectionReference301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionReference308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__0_in_ruleConnectionReference334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSpecificationInstance_in_entryRuleFlowSpecificationInstance361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSpecificationInstance368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecificationInstance__Group__0_in_ruleFlowSpecificationInstance394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemOperationMode428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__0_in_ruleSystemOperationMode454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_entryRuleDirectionType481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDirectionType488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DirectionType__Alternatives_in_ruleDirectionType514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCategory548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCategory__Alternatives_in_ruleFeatureCategory574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentCategory608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Alternatives_in_ruleComponentCategory634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionKind_in_entryRuleConnectionKind661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionKind668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionKind__Alternatives_in_ruleConnectionKind694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIMPLREF_in_entryRuleIMPLREF721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIMPLREF728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__0_in_ruleIMPLREF754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFEATREF_in_entryRuleFEATREF781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFEATREF788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__0_in_ruleFEATREF814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSUBREF_in_entryRuleSUBREF841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSUBREF848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__0_in_ruleSUBREF874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_entryRuleINSTANCEREF901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINSTANCEREF908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group__0_in_ruleINSTANCEREF934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSIMPLEINSTANCEREF_in_entryRuleSIMPLEINSTANCEREF961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSIMPLEINSTANCEREF968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group__0_in_ruleSIMPLEINSTANCEREF994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREFWITHPARENT_in_entryRuleINSTANCEREFWITHPARENT1021 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINSTANCEREFWITHPARENT1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Alternatives_in_ruleINSTANCEREFWITHPARENT1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_entryRuleCONNINSTREF1081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCONNINSTREF1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CONNINSTREF__Group__0_in_ruleCONNINSTREF1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__FeatureInstanceAssignment_5_0_in_rule__SystemInstance__Alternatives_51150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__ComponentInstanceAssignment_5_1_in_rule__SystemInstance__Alternatives_51168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__ConnectionInstanceAssignment_5_2_in_rule__SystemInstance__Alternatives_51186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__FlowSpecificationAssignment_5_3_in_rule__SystemInstance__Alternatives_51204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__SystemOperationModeAssignment_5_4_in_rule__SystemInstance__Alternatives_51222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3_0_in_rule__FeatureInstance__Alternatives_6_31255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__SrcFlowSpecAssignment_6_3_1_in_rule__FeatureInstance__Alternatives_6_31273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1_0_in_rule__FeatureInstance__Alternatives_6_4_11306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__SrcFlowSpecAssignment_6_4_1_1_in_rule__FeatureInstance__Alternatives_6_4_11324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__DstConnectionInstanceAssignment_7_3_0_in_rule__FeatureInstance__Alternatives_7_31357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__DstFlowSpecAssignment_7_3_1_in_rule__FeatureInstance__Alternatives_7_31375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1_0_in_rule__FeatureInstance__Alternatives_7_4_11408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__DstFlowSpecAssignment_7_4_1_1_in_rule__FeatureInstance__Alternatives_7_4_11426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__FeatureInstanceAssignment_7_1_0_in_rule__ComponentInstance__Alternatives_7_11459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__ComponentInstanceAssignment_7_1_1_in_rule__ComponentInstance__Alternatives_7_11477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2_in_rule__ComponentInstance__Alternatives_7_11495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__FlowSpecificationAssignment_7_1_3_in_rule__ComponentInstance__Alternatives_7_11513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__BidirectionalAssignment_5_0_in_rule__ConnectionInstance__Alternatives_51546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_rule__ConnectionInstance__Alternatives_51565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__DirectionType__Alternatives1600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__DirectionType__Alternatives1620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DirectionType__Group_2__0_in_rule__DirectionType__Alternatives1639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__FeatureCategory__Alternatives1673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__FeatureCategory__Alternatives1693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__FeatureCategory__Alternatives1713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__FeatureCategory__Alternatives1733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__FeatureCategory__Alternatives1753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__FeatureCategory__Alternatives1773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__FeatureCategory__Alternatives1793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__FeatureCategory__Alternatives1813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__FeatureCategory__Alternatives1833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ComponentCategory__Alternatives1868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ComponentCategory__Alternatives1888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ComponentCategory__Alternatives1908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ComponentCategory__Alternatives1928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ComponentCategory__Alternatives1948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ComponentCategory__Alternatives1968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ComponentCategory__Alternatives1988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ComponentCategory__Alternatives2008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__0_in_rule__ComponentCategory__Alternatives2027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ComponentCategory__Alternatives2046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_10__0_in_rule__ComponentCategory__Alternatives2065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ComponentCategory__Alternatives2084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__0_in_rule__ComponentCategory__Alternatives2103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_13__0_in_rule__ComponentCategory__Alternatives2121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ConnectionKind__Alternatives2155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ConnectionKind__Alternatives2175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ConnectionKind__Alternatives2195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__ConnectionKind__Alternatives2215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ConnectionKind__Alternatives2235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ConnectionKind__Alternatives2255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__INSTANCEREFWITHPARENT__Alternatives2290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__0_in_rule__INSTANCEREFWITHPARENT__Alternatives2309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__0__Impl_in_rule__SystemInstance__Group__02340 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__1_in_rule__SystemInstance__Group__02343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__CategoryAssignment_0_in_rule__SystemInstance__Group__0__Impl2370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__1__Impl_in_rule__SystemInstance__Group__12400 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__2_in_rule__SystemInstance__Group__12403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__NameAssignment_1_in_rule__SystemInstance__Group__1__Impl2430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__2__Impl_in_rule__SystemInstance__Group__22460 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__3_in_rule__SystemInstance__Group__22463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__SystemInstance__Group__2__Impl2491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__3__Impl_in_rule__SystemInstance__Group__32522 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__4_in_rule__SystemInstance__Group__32525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__ComponentImplementationAssignment_3_in_rule__SystemInstance__Group__3__Impl2552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__4__Impl_in_rule__SystemInstance__Group__42582 = new BitSet(new long[]{0x0096011FFFE00C00L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__5_in_rule__SystemInstance__Group__42585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__SystemInstance__Group__4__Impl2613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__5__Impl_in_rule__SystemInstance__Group__52644 = new BitSet(new long[]{0x0096011FFFE00C00L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__6_in_rule__SystemInstance__Group__52647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Alternatives_5_in_rule__SystemInstance__Group__5__Impl2674 = new BitSet(new long[]{0x0096001FFFE00C02L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__6__Impl_in_rule__SystemInstance__Group__62705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__SystemInstance__Group__6__Impl2733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__0__Impl_in_rule__FeatureInstance__Group__02778 = new BitSet(new long[]{0x00000000001FF000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__1_in_rule__FeatureInstance__Group__02781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__DirectionAssignment_0_in_rule__FeatureInstance__Group__0__Impl2808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__1__Impl_in_rule__FeatureInstance__Group__12838 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__2_in_rule__FeatureInstance__Group__12841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__CategoryAssignment_1_in_rule__FeatureInstance__Group__1__Impl2868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__2__Impl_in_rule__FeatureInstance__Group__22898 = new BitSet(new long[]{0x0000024000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__3_in_rule__FeatureInstance__Group__22901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__NameAssignment_2_in_rule__FeatureInstance__Group__2__Impl2928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__3__Impl_in_rule__FeatureInstance__Group__32958 = new BitSet(new long[]{0x0000024000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__4_in_rule__FeatureInstance__Group__32961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__0_in_rule__FeatureInstance__Group__3__Impl2988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__4__Impl_in_rule__FeatureInstance__Group__43019 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__5_in_rule__FeatureInstance__Group__43022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__FeatureInstance__Group__4__Impl3050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__5__Impl_in_rule__FeatureInstance__Group__53081 = new BitSet(new long[]{0x0001088000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__6_in_rule__FeatureInstance__Group__53084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__FeatureAssignment_5_in_rule__FeatureInstance__Group__5__Impl3111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__6__Impl_in_rule__FeatureInstance__Group__63141 = new BitSet(new long[]{0x0001088000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__7_in_rule__FeatureInstance__Group__63144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__0_in_rule__FeatureInstance__Group__6__Impl3171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__7__Impl_in_rule__FeatureInstance__Group__73202 = new BitSet(new long[]{0x0001088000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__8_in_rule__FeatureInstance__Group__73205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__0_in_rule__FeatureInstance__Group__7__Impl3232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__8__Impl_in_rule__FeatureInstance__Group__83263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_8__0_in_rule__FeatureInstance__Group__8__Impl3290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__0__Impl_in_rule__FeatureInstance__Group_3__03339 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__1_in_rule__FeatureInstance__Group_3__03342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__FeatureInstance__Group_3__0__Impl3370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__1__Impl_in_rule__FeatureInstance__Group_3__13401 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__2_in_rule__FeatureInstance__Group_3__13404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__IndexAssignment_3_1_in_rule__FeatureInstance__Group_3__1__Impl3431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__2__Impl_in_rule__FeatureInstance__Group_3__23461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__FeatureInstance__Group_3__2__Impl3489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__0__Impl_in_rule__FeatureInstance__Group_6__03526 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__1_in_rule__FeatureInstance__Group_6__03529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__FeatureInstance__Group_6__0__Impl3557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__1__Impl_in_rule__FeatureInstance__Group_6__13588 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__2_in_rule__FeatureInstance__Group_6__13591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__FeatureInstance__Group_6__1__Impl3619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__2__Impl_in_rule__FeatureInstance__Group_6__23650 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__3_in_rule__FeatureInstance__Group_6__23653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__FeatureInstance__Group_6__2__Impl3681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__3__Impl_in_rule__FeatureInstance__Group_6__33712 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__4_in_rule__FeatureInstance__Group_6__33715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Alternatives_6_3_in_rule__FeatureInstance__Group_6__3__Impl3742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__4__Impl_in_rule__FeatureInstance__Group_6__43772 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__5_in_rule__FeatureInstance__Group_6__43775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6_4__0_in_rule__FeatureInstance__Group_6__4__Impl3802 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__5__Impl_in_rule__FeatureInstance__Group_6__53833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__FeatureInstance__Group_6__5__Impl3861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6_4__0__Impl_in_rule__FeatureInstance__Group_6_4__03904 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6_4__1_in_rule__FeatureInstance__Group_6_4__03907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__FeatureInstance__Group_6_4__0__Impl3935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6_4__1__Impl_in_rule__FeatureInstance__Group_6_4__13966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Alternatives_6_4_1_in_rule__FeatureInstance__Group_6_4__1__Impl3993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__0__Impl_in_rule__FeatureInstance__Group_7__04027 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__1_in_rule__FeatureInstance__Group_7__04030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__FeatureInstance__Group_7__0__Impl4058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__1__Impl_in_rule__FeatureInstance__Group_7__14089 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__2_in_rule__FeatureInstance__Group_7__14092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__FeatureInstance__Group_7__1__Impl4120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__2__Impl_in_rule__FeatureInstance__Group_7__24151 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__3_in_rule__FeatureInstance__Group_7__24154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__FeatureInstance__Group_7__2__Impl4182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__3__Impl_in_rule__FeatureInstance__Group_7__34213 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__4_in_rule__FeatureInstance__Group_7__34216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Alternatives_7_3_in_rule__FeatureInstance__Group_7__3__Impl4243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__4__Impl_in_rule__FeatureInstance__Group_7__44273 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__5_in_rule__FeatureInstance__Group_7__44276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7_4__0_in_rule__FeatureInstance__Group_7__4__Impl4303 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__5__Impl_in_rule__FeatureInstance__Group_7__54334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__FeatureInstance__Group_7__5__Impl4362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7_4__0__Impl_in_rule__FeatureInstance__Group_7_4__04405 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7_4__1_in_rule__FeatureInstance__Group_7_4__04408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__FeatureInstance__Group_7_4__0__Impl4436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7_4__1__Impl_in_rule__FeatureInstance__Group_7_4__14467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Alternatives_7_4_1_in_rule__FeatureInstance__Group_7_4__1__Impl4494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_8__0__Impl_in_rule__FeatureInstance__Group_8__04528 = new BitSet(new long[]{0x0000010000000C00L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_8__1_in_rule__FeatureInstance__Group_8__04531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__FeatureInstance__Group_8__0__Impl4559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_8__1__Impl_in_rule__FeatureInstance__Group_8__14590 = new BitSet(new long[]{0x0000010000000C00L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_8__2_in_rule__FeatureInstance__Group_8__14593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__FeatureInstanceAssignment_8_1_in_rule__FeatureInstance__Group_8__1__Impl4620 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_8__2__Impl_in_rule__FeatureInstance__Group_8__24651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__FeatureInstance__Group_8__2__Impl4679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__0__Impl_in_rule__ComponentInstance__Group__04716 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__1_in_rule__ComponentInstance__Group__04719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__CategoryAssignment_0_in_rule__ComponentInstance__Group__0__Impl4746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__1__Impl_in_rule__ComponentInstance__Group__14776 = new BitSet(new long[]{0x0000024000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__2_in_rule__ComponentInstance__Group__14779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__NameAssignment_1_in_rule__ComponentInstance__Group__1__Impl4806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__2__Impl_in_rule__ComponentInstance__Group__24836 = new BitSet(new long[]{0x0000024000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__3_in_rule__ComponentInstance__Group__24839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__0_in_rule__ComponentInstance__Group__2__Impl4866 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__3__Impl_in_rule__ComponentInstance__Group__34897 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__4_in_rule__ComponentInstance__Group__34900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ComponentInstance__Group__3__Impl4928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__4__Impl_in_rule__ComponentInstance__Group__44959 = new BitSet(new long[]{0x0001088000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__5_in_rule__ComponentInstance__Group__44962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__SubcomponentAssignment_4_in_rule__ComponentInstance__Group__4__Impl4989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__5__Impl_in_rule__ComponentInstance__Group__55019 = new BitSet(new long[]{0x0001088000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__6_in_rule__ComponentInstance__Group__55022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__0_in_rule__ComponentInstance__Group__5__Impl5049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__6__Impl_in_rule__ComponentInstance__Group__65080 = new BitSet(new long[]{0x0001088000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__7_in_rule__ComponentInstance__Group__65083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__0_in_rule__ComponentInstance__Group__6__Impl5110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__7__Impl_in_rule__ComponentInstance__Group__75141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_7__0_in_rule__ComponentInstance__Group__7__Impl5168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__0__Impl_in_rule__ComponentInstance__Group_2__05215 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__1_in_rule__ComponentInstance__Group_2__05218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ComponentInstance__Group_2__0__Impl5246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__1__Impl_in_rule__ComponentInstance__Group_2__15277 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__2_in_rule__ComponentInstance__Group_2__15280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__IndexAssignment_2_1_in_rule__ComponentInstance__Group_2__1__Impl5307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__2__Impl_in_rule__ComponentInstance__Group_2__25337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__ComponentInstance__Group_2__2__Impl5365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__0__Impl_in_rule__ComponentInstance__Group_5__05402 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__1_in_rule__ComponentInstance__Group_5__05405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__ComponentInstance__Group_5__0__Impl5433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__1__Impl_in_rule__ComponentInstance__Group_5__15464 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__2_in_rule__ComponentInstance__Group_5__15467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__ComponentInstance__Group_5__1__Impl5495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__2__Impl_in_rule__ComponentInstance__Group_5__25526 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__3_in_rule__ComponentInstance__Group_5__25529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__ComponentInstance__Group_5__2__Impl5557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__3__Impl_in_rule__ComponentInstance__Group_5__35588 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__4_in_rule__ComponentInstance__Group_5__35591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3_in_rule__ComponentInstance__Group_5__3__Impl5618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__4__Impl_in_rule__ComponentInstance__Group_5__45648 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__5_in_rule__ComponentInstance__Group_5__45651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5_4__0_in_rule__ComponentInstance__Group_5__4__Impl5678 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__5__Impl_in_rule__ComponentInstance__Group_5__55709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ComponentInstance__Group_5__5__Impl5737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5_4__0__Impl_in_rule__ComponentInstance__Group_5_4__05780 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5_4__1_in_rule__ComponentInstance__Group_5_4__05783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__ComponentInstance__Group_5_4__0__Impl5811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5_4__1__Impl_in_rule__ComponentInstance__Group_5_4__15842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1_in_rule__ComponentInstance__Group_5_4__1__Impl5869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__0__Impl_in_rule__ComponentInstance__Group_6__05903 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__1_in_rule__ComponentInstance__Group_6__05906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__ComponentInstance__Group_6__0__Impl5934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__1__Impl_in_rule__ComponentInstance__Group_6__15965 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__2_in_rule__ComponentInstance__Group_6__15968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__ComponentInstance__Group_6__1__Impl5996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__2__Impl_in_rule__ComponentInstance__Group_6__26027 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__3_in_rule__ComponentInstance__Group_6__26030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__ComponentInstance__Group_6__2__Impl6058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__3__Impl_in_rule__ComponentInstance__Group_6__36089 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__4_in_rule__ComponentInstance__Group_6__36092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__DstConnectionInstanceAssignment_6_3_in_rule__ComponentInstance__Group_6__3__Impl6119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__4__Impl_in_rule__ComponentInstance__Group_6__46149 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__5_in_rule__ComponentInstance__Group_6__46152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6_4__0_in_rule__ComponentInstance__Group_6__4__Impl6179 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__5__Impl_in_rule__ComponentInstance__Group_6__56210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ComponentInstance__Group_6__5__Impl6238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6_4__0__Impl_in_rule__ComponentInstance__Group_6_4__06281 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6_4__1_in_rule__ComponentInstance__Group_6_4__06284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__ComponentInstance__Group_6_4__0__Impl6312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6_4__1__Impl_in_rule__ComponentInstance__Group_6_4__16343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1_in_rule__ComponentInstance__Group_6_4__1__Impl6370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_7__0__Impl_in_rule__ComponentInstance__Group_7__06404 = new BitSet(new long[]{0x0092011FFFE00C00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_7__1_in_rule__ComponentInstance__Group_7__06407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ComponentInstance__Group_7__0__Impl6435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_7__1__Impl_in_rule__ComponentInstance__Group_7__16466 = new BitSet(new long[]{0x0092011FFFE00C00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_7__2_in_rule__ComponentInstance__Group_7__16469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Alternatives_7_1_in_rule__ComponentInstance__Group_7__1__Impl6496 = new BitSet(new long[]{0x0092001FFFE00C02L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_7__2__Impl_in_rule__ComponentInstance__Group_7__26527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ComponentInstance__Group_7__2__Impl6555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__0__Impl_in_rule__ConnectionInstance__Group__06592 = new BitSet(new long[]{0x0080001F80000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__1_in_rule__ConnectionInstance__Group__06595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__CompleteAssignment_0_in_rule__ConnectionInstance__Group__0__Impl6622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__1__Impl_in_rule__ConnectionInstance__Group__16653 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__2_in_rule__ConnectionInstance__Group__16656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__KindAssignment_1_in_rule__ConnectionInstance__Group__1__Impl6683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__2__Impl_in_rule__ConnectionInstance__Group__26713 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__3_in_rule__ConnectionInstance__Group__26716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__NameAssignment_2_in_rule__ConnectionInstance__Group__2__Impl6743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__3__Impl_in_rule__ConnectionInstance__Group__36773 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__4_in_rule__ConnectionInstance__Group__36776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ConnectionInstance__Group__3__Impl6804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__4__Impl_in_rule__ConnectionInstance__Group__46835 = new BitSet(new long[]{0x0100000000000200L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__5_in_rule__ConnectionInstance__Group__46838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__SourceAssignment_4_in_rule__ConnectionInstance__Group__4__Impl6865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__5__Impl_in_rule__ConnectionInstance__Group__56895 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__6_in_rule__ConnectionInstance__Group__56898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Alternatives_5_in_rule__ConnectionInstance__Group__5__Impl6925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__6__Impl_in_rule__ConnectionInstance__Group__66955 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__7_in_rule__ConnectionInstance__Group__66958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__DestinationAssignment_6_in_rule__ConnectionInstance__Group__6__Impl6985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__7__Impl_in_rule__ConnectionInstance__Group__77015 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__8_in_rule__ConnectionInstance__Group__77018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ConnectionInstance__Group__7__Impl7046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__8__Impl_in_rule__ConnectionInstance__Group__87077 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__9_in_rule__ConnectionInstance__Group__87080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__ConnectionReferenceAssignment_8_in_rule__ConnectionInstance__Group__8__Impl7109 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__ConnectionReferenceAssignment_8_in_rule__ConnectionInstance__Group__8__Impl7121 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__9__Impl_in_rule__ConnectionInstance__Group__97154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ConnectionInstance__Group__9__Impl7182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__0__Impl_in_rule__ConnectionReference__Group__07233 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__1_in_rule__ConnectionReference__Group__07236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__SourceAssignment_0_in_rule__ConnectionReference__Group__0__Impl7263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__1__Impl_in_rule__ConnectionReference__Group__17293 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__2_in_rule__ConnectionReference__Group__17296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_rule__ConnectionReference__Group__1__Impl7324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__2__Impl_in_rule__ConnectionReference__Group__27355 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__3_in_rule__ConnectionReference__Group__27358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__DestinationAssignment_2_in_rule__ConnectionReference__Group__2__Impl7385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__3__Impl_in_rule__ConnectionReference__Group__37415 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__4_in_rule__ConnectionReference__Group__37418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ConnectionReference__Group__3__Impl7446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__4__Impl_in_rule__ConnectionReference__Group__47477 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__5_in_rule__ConnectionReference__Group__47480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__ConnectionAssignment_4_in_rule__ConnectionReference__Group__4__Impl7507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__5__Impl_in_rule__ConnectionReference__Group__57537 = new BitSet(new long[]{0x0000002000000010L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__6_in_rule__ConnectionReference__Group__57540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__ConnectionReference__Group__5__Impl7568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__6__Impl_in_rule__ConnectionReference__Group__67599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__ContextAssignment_6_in_rule__ConnectionReference__Group__6__Impl7626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecificationInstance__Group__0__Impl_in_rule__FlowSpecificationInstance__Group__07670 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FlowSpecificationInstance__Group__1_in_rule__FlowSpecificationInstance__Group__07673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__FlowSpecificationInstance__Group__0__Impl7701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecificationInstance__Group__1__Impl_in_rule__FlowSpecificationInstance__Group__17732 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__FlowSpecificationInstance__Group__2_in_rule__FlowSpecificationInstance__Group__17735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecificationInstance__NameAssignment_1_in_rule__FlowSpecificationInstance__Group__1__Impl7762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecificationInstance__Group__2__Impl_in_rule__FlowSpecificationInstance__Group__27792 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_rule__FlowSpecificationInstance__Group__3_in_rule__FlowSpecificationInstance__Group__27795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__FlowSpecificationInstance__Group__2__Impl7823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecificationInstance__Group__3__Impl_in_rule__FlowSpecificationInstance__Group__37854 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_rule__FlowSpecificationInstance__Group__4_in_rule__FlowSpecificationInstance__Group__37857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecificationInstance__SourceAssignment_3_in_rule__FlowSpecificationInstance__Group__3__Impl7884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecificationInstance__Group__4__Impl_in_rule__FlowSpecificationInstance__Group__47915 = new BitSet(new long[]{0x0000400000000010L});
    public static final BitSet FOLLOW_rule__FlowSpecificationInstance__Group__5_in_rule__FlowSpecificationInstance__Group__47918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_rule__FlowSpecificationInstance__Group__4__Impl7946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecificationInstance__Group__5__Impl_in_rule__FlowSpecificationInstance__Group__57977 = new BitSet(new long[]{0x0000400000000010L});
    public static final BitSet FOLLOW_rule__FlowSpecificationInstance__Group__6_in_rule__FlowSpecificationInstance__Group__57980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecificationInstance__DestinationAssignment_5_in_rule__FlowSpecificationInstance__Group__5__Impl8007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecificationInstance__Group__6__Impl_in_rule__FlowSpecificationInstance__Group__68038 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__FlowSpecificationInstance__Group__7_in_rule__FlowSpecificationInstance__Group__68041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__FlowSpecificationInstance__Group__6__Impl8069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecificationInstance__Group__7__Impl_in_rule__FlowSpecificationInstance__Group__78100 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FlowSpecificationInstance__Group__8_in_rule__FlowSpecificationInstance__Group__78103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__FlowSpecificationInstance__Group__7__Impl8131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecificationInstance__Group__8__Impl_in_rule__FlowSpecificationInstance__Group__88162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FlowSpecificationInstance__FlowSpecificationAssignment_8_in_rule__FlowSpecificationInstance__Group__8__Impl8189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__0__Impl_in_rule__SystemOperationMode__Group__08237 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__1_in_rule__SystemOperationMode__Group__08240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__SystemOperationMode__Group__0__Impl8268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__1__Impl_in_rule__SystemOperationMode__Group__18299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__NameAssignment_1_in_rule__SystemOperationMode__Group__1__Impl8326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DirectionType__Group_2__0__Impl_in_rule__DirectionType__Group_2__08360 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__DirectionType__Group_2__1_in_rule__DirectionType__Group_2__08363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__DirectionType__Group_2__0__Impl8391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DirectionType__Group_2__1__Impl_in_rule__DirectionType__Group_2__18422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__DirectionType__Group_2__1__Impl8450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__0__Impl_in_rule__ComponentCategory__Group_8__08485 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__1_in_rule__ComponentCategory__Group_8__08488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ComponentCategory__Group_8__0__Impl8516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__1__Impl_in_rule__ComponentCategory__Group_8__18547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__ComponentCategory__Group_8__1__Impl8575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_10__0__Impl_in_rule__ComponentCategory__Group_10__08610 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_10__1_in_rule__ComponentCategory__Group_10__08613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ComponentCategory__Group_10__0__Impl8641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_10__1__Impl_in_rule__ComponentCategory__Group_10__18672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__ComponentCategory__Group_10__1__Impl8700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__0__Impl_in_rule__ComponentCategory__Group_12__08735 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__1_in_rule__ComponentCategory__Group_12__08738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__ComponentCategory__Group_12__0__Impl8766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__1__Impl_in_rule__ComponentCategory__Group_12__18797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ComponentCategory__Group_12__1__Impl8825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_13__0__Impl_in_rule__ComponentCategory__Group_13__08860 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_13__1_in_rule__ComponentCategory__Group_13__08863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__ComponentCategory__Group_13__0__Impl8891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_13__1__Impl_in_rule__ComponentCategory__Group_13__18922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ComponentCategory__Group_13__1__Impl8950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__0__Impl_in_rule__IMPLREF__Group__08985 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__1_in_rule__IMPLREF__Group__08988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group_0__0_in_rule__IMPLREF__Group__0__Impl9017 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group_0__0_in_rule__IMPLREF__Group__0__Impl9029 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__1__Impl_in_rule__IMPLREF__Group__19062 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__2_in_rule__IMPLREF__Group__19065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IMPLREF__Group__1__Impl9092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__2__Impl_in_rule__IMPLREF__Group__29121 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__3_in_rule__IMPLREF__Group__29124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__IMPLREF__Group__2__Impl9152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__3__Impl_in_rule__IMPLREF__Group__39183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IMPLREF__Group__3__Impl9210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group_0__0__Impl_in_rule__IMPLREF__Group_0__09247 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group_0__1_in_rule__IMPLREF__Group_0__09250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IMPLREF__Group_0__0__Impl9277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group_0__1__Impl_in_rule__IMPLREF__Group_0__19306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__IMPLREF__Group_0__1__Impl9334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__0__Impl_in_rule__FEATREF__Group__09369 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__1_in_rule__FEATREF__Group__09372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FEATREF__Group_0__0_in_rule__FEATREF__Group__0__Impl9401 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__FEATREF__Group_0__0_in_rule__FEATREF__Group__0__Impl9413 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__1__Impl_in_rule__FEATREF__Group__19446 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__2_in_rule__FEATREF__Group__19449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FEATREF__Group__1__Impl9476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__2__Impl_in_rule__FEATREF__Group__29505 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__3_in_rule__FEATREF__Group__29508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__FEATREF__Group__2__Impl9536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__3__Impl_in_rule__FEATREF__Group__39567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FEATREF__Group__3__Impl9594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FEATREF__Group_0__0__Impl_in_rule__FEATREF__Group_0__09631 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_rule__FEATREF__Group_0__1_in_rule__FEATREF__Group_0__09634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FEATREF__Group_0__0__Impl9661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FEATREF__Group_0__1__Impl_in_rule__FEATREF__Group_0__19690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__FEATREF__Group_0__1__Impl9718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__0__Impl_in_rule__SUBREF__Group__09753 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__1_in_rule__SUBREF__Group__09756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group_0__0_in_rule__SUBREF__Group__0__Impl9785 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SUBREF__Group_0__0_in_rule__SUBREF__Group__0__Impl9797 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__1__Impl_in_rule__SUBREF__Group__19830 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__2_in_rule__SUBREF__Group__19833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SUBREF__Group__1__Impl9860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__2__Impl_in_rule__SUBREF__Group__29889 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__3_in_rule__SUBREF__Group__29892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__SUBREF__Group__2__Impl9920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__3__Impl_in_rule__SUBREF__Group__39951 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__4_in_rule__SUBREF__Group__39954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SUBREF__Group__3__Impl9981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__4__Impl_in_rule__SUBREF__Group__410010 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__5_in_rule__SUBREF__Group__410013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__SUBREF__Group__4__Impl10041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__5__Impl_in_rule__SUBREF__Group__510072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SUBREF__Group__5__Impl10099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group_0__0__Impl_in_rule__SUBREF__Group_0__010140 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_rule__SUBREF__Group_0__1_in_rule__SUBREF__Group_0__010143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SUBREF__Group_0__0__Impl10170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group_0__1__Impl_in_rule__SUBREF__Group_0__110199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__SUBREF__Group_0__1__Impl10227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group__0__Impl_in_rule__INSTANCEREF__Group__010262 = new BitSet(new long[]{0x0020020000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group__1_in_rule__INSTANCEREF__Group__010265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__INSTANCEREF__Group__0__Impl10292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group__1__Impl_in_rule__INSTANCEREF__Group__110321 = new BitSet(new long[]{0x0020020000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group__2_in_rule__INSTANCEREF__Group__110324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_1__0_in_rule__INSTANCEREF__Group__1__Impl10351 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group__2__Impl_in_rule__INSTANCEREF__Group__210382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2__0_in_rule__INSTANCEREF__Group__2__Impl10409 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_1__0__Impl_in_rule__INSTANCEREF__Group_1__010446 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_1__1_in_rule__INSTANCEREF__Group_1__010449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__INSTANCEREF__Group_1__0__Impl10477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_1__1__Impl_in_rule__INSTANCEREF__Group_1__110508 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_1__2_in_rule__INSTANCEREF__Group_1__110511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_rule__INSTANCEREF__Group_1__1__Impl10538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_1__2__Impl_in_rule__INSTANCEREF__Group_1__210567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__INSTANCEREF__Group_1__2__Impl10595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2__0__Impl_in_rule__INSTANCEREF__Group_2__010632 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2__1_in_rule__INSTANCEREF__Group_2__010635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__INSTANCEREF__Group_2__0__Impl10663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2__1__Impl_in_rule__INSTANCEREF__Group_2__110694 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2__2_in_rule__INSTANCEREF__Group_2__110697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__INSTANCEREF__Group_2__1__Impl10724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2__2__Impl_in_rule__INSTANCEREF__Group_2__210753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2_2__0_in_rule__INSTANCEREF__Group_2__2__Impl10780 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2_2__0__Impl_in_rule__INSTANCEREF__Group_2_2__010817 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2_2__1_in_rule__INSTANCEREF__Group_2_2__010820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__INSTANCEREF__Group_2_2__0__Impl10848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2_2__1__Impl_in_rule__INSTANCEREF__Group_2_2__110879 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2_2__2_in_rule__INSTANCEREF__Group_2_2__110882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_rule__INSTANCEREF__Group_2_2__1__Impl10909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2_2__2__Impl_in_rule__INSTANCEREF__Group_2_2__210938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__INSTANCEREF__Group_2_2__2__Impl10966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group__0__Impl_in_rule__SIMPLEINSTANCEREF__Group__011003 = new BitSet(new long[]{0x0020020000000000L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group__1_in_rule__SIMPLEINSTANCEREF__Group__011006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SIMPLEINSTANCEREF__Group__0__Impl11033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group__1__Impl_in_rule__SIMPLEINSTANCEREF__Group__111062 = new BitSet(new long[]{0x0020020000000000L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group__2_in_rule__SIMPLEINSTANCEREF__Group__111065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group_1__0_in_rule__SIMPLEINSTANCEREF__Group__1__Impl11092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group__2__Impl_in_rule__SIMPLEINSTANCEREF__Group__211123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group_2__0_in_rule__SIMPLEINSTANCEREF__Group__2__Impl11150 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group_1__0__Impl_in_rule__SIMPLEINSTANCEREF__Group_1__011187 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group_1__1_in_rule__SIMPLEINSTANCEREF__Group_1__011190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__SIMPLEINSTANCEREF__Group_1__0__Impl11218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group_1__1__Impl_in_rule__SIMPLEINSTANCEREF__Group_1__111249 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group_1__2_in_rule__SIMPLEINSTANCEREF__Group_1__111252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_rule__SIMPLEINSTANCEREF__Group_1__1__Impl11279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group_1__2__Impl_in_rule__SIMPLEINSTANCEREF__Group_1__211308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__SIMPLEINSTANCEREF__Group_1__2__Impl11336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group_2__0__Impl_in_rule__SIMPLEINSTANCEREF__Group_2__011373 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group_2__1_in_rule__SIMPLEINSTANCEREF__Group_2__011376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__SIMPLEINSTANCEREF__Group_2__0__Impl11404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group_2__1__Impl_in_rule__SIMPLEINSTANCEREF__Group_2__111435 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group_2__2_in_rule__SIMPLEINSTANCEREF__Group_2__111438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SIMPLEINSTANCEREF__Group_2__1__Impl11465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group_2__2__Impl_in_rule__SIMPLEINSTANCEREF__Group_2__211494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group_2_2__0_in_rule__SIMPLEINSTANCEREF__Group_2__2__Impl11521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group_2_2__0__Impl_in_rule__SIMPLEINSTANCEREF__Group_2_2__011558 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group_2_2__1_in_rule__SIMPLEINSTANCEREF__Group_2_2__011561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__SIMPLEINSTANCEREF__Group_2_2__0__Impl11589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group_2_2__1__Impl_in_rule__SIMPLEINSTANCEREF__Group_2_2__111620 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group_2_2__2_in_rule__SIMPLEINSTANCEREF__Group_2_2__111623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_rule__SIMPLEINSTANCEREF__Group_2_2__1__Impl11650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SIMPLEINSTANCEREF__Group_2_2__2__Impl_in_rule__SIMPLEINSTANCEREF__Group_2_2__211679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__SIMPLEINSTANCEREF__Group_2_2__2__Impl11707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__0__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1__011744 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__1_in_rule__INSTANCEREFWITHPARENT__Group_1__011747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__INSTANCEREFWITHPARENT__Group_1__0__Impl11774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__1__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1__111803 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__2_in_rule__INSTANCEREFWITHPARENT__Group_1__111806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__0_in_rule__INSTANCEREFWITHPARENT__Group_1__1__Impl11835 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__0_in_rule__INSTANCEREFWITHPARENT__Group_1__1__Impl11847 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__2__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1__211880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__0_in_rule__INSTANCEREFWITHPARENT__Group_1__2__Impl11907 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__0__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_1__011944 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__1_in_rule__INSTANCEREFWITHPARENT__Group_1_1__011947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__INSTANCEREFWITHPARENT__Group_1_1__0__Impl11975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__1__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_1__112006 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__2_in_rule__INSTANCEREFWITHPARENT__Group_1_1__112009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_rule__INSTANCEREFWITHPARENT__Group_1_1__1__Impl12036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__2__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_1__212065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__INSTANCEREFWITHPARENT__Group_1_1__2__Impl12093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__0__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2__012130 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__1_in_rule__INSTANCEREFWITHPARENT__Group_1_2__012133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__INSTANCEREFWITHPARENT__Group_1_2__0__Impl12161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__1__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2__112192 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__2_in_rule__INSTANCEREFWITHPARENT__Group_1_2__112195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__INSTANCEREFWITHPARENT__Group_1_2__1__Impl12222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2__212251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__0_in_rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl12280 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__0_in_rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl12292 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__0__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__012331 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__1_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__012334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__0__Impl12362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__1__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__112393 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__2_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__112396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__1__Impl12423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__2__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__212452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__2__Impl12480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CONNINSTREF__Group__0__Impl_in_rule__CONNINSTREF__Group__012517 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__CONNINSTREF__Group__1_in_rule__CONNINSTREF__Group__012520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CONNINSTREF__Group_0__0_in_rule__CONNINSTREF__Group__0__Impl12547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CONNINSTREF__Group__1__Impl_in_rule__CONNINSTREF__Group__112578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_rule__CONNINSTREF__Group__1__Impl12605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CONNINSTREF__Group_0__0__Impl_in_rule__CONNINSTREF__Group_0__012638 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__CONNINSTREF__Group_0__1_in_rule__CONNINSTREF__Group_0__012641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_rule__CONNINSTREF__Group_0__0__Impl12668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CONNINSTREF__Group_0__1__Impl_in_rule__CONNINSTREF__Group_0__112697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__CONNINSTREF__Group_0__1__Impl12725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_rule__SystemInstance__CategoryAssignment_012765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SystemInstance__NameAssignment_112796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIMPLREF_in_rule__SystemInstance__ComponentImplementationAssignment_312831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_rule__SystemInstance__FeatureInstanceAssignment_5_012866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_rule__SystemInstance__ComponentInstanceAssignment_5_112897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_rule__SystemInstance__ConnectionInstanceAssignment_5_212928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSpecificationInstance_in_rule__SystemInstance__FlowSpecificationAssignment_5_312959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_rule__SystemInstance__SystemOperationModeAssignment_5_412990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_rule__FeatureInstance__DirectionAssignment_013021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_rule__FeatureInstance__CategoryAssignment_113052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FeatureInstance__NameAssignment_213083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_rule__FeatureInstance__IndexAssignment_3_113114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFEATREF_in_rule__FeatureInstance__FeatureAssignment_513149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3_013188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FeatureInstance__SrcFlowSpecAssignment_6_3_113227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1_013266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FeatureInstance__SrcFlowSpecAssignment_6_4_1_113305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_rule__FeatureInstance__DstConnectionInstanceAssignment_7_3_013344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FeatureInstance__DstFlowSpecAssignment_7_3_113383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1_013422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FeatureInstance__DstFlowSpecAssignment_7_4_1_113461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_rule__FeatureInstance__FeatureInstanceAssignment_8_113496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_rule__ComponentInstance__CategoryAssignment_013527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ComponentInstance__NameAssignment_113558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_rule__ComponentInstance__IndexAssignment_2_113589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSUBREF_in_rule__ComponentInstance__SubcomponentAssignment_413624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_rule__ComponentInstance__SrcConnectionInstanceAssignment_5_313663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_113702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_rule__ComponentInstance__DstConnectionInstanceAssignment_6_313741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_113780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_rule__ComponentInstance__FeatureInstanceAssignment_7_1_013815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_rule__ComponentInstance__ComponentInstanceAssignment_7_1_113846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_rule__ComponentInstance__ConnectionInstanceAssignment_7_1_213877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSpecificationInstance_in_rule__ComponentInstance__FlowSpecificationAssignment_7_1_313908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_rule__ConnectionInstance__CompleteAssignment_013944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionKind_in_rule__ConnectionInstance__KindAssignment_113983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ConnectionInstance__NameAssignment_214014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__SourceAssignment_414049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_rule__ConnectionInstance__BidirectionalAssignment_5_014089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__DestinationAssignment_614132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionReference_in_rule__ConnectionInstance__ConnectionReferenceAssignment_814167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__SourceAssignment_014202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__DestinationAssignment_214241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSUBREF_in_rule__ConnectionReference__ConnectionAssignment_414280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREFWITHPARENT_in_rule__ConnectionReference__ContextAssignment_614319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FlowSpecificationInstance__NameAssignment_114354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSIMPLEINSTANCEREF_in_rule__FlowSpecificationInstance__SourceAssignment_314389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSIMPLEINSTANCEREF_in_rule__FlowSpecificationInstance__DestinationAssignment_514428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFEATREF_in_rule__FlowSpecificationInstance__FlowSpecificationAssignment_814467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__SystemOperationMode__NameAssignment_114502 = new BitSet(new long[]{0x0000000000000002L});

}