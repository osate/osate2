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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_LONG", "RULE_STRING", "RULE_SL_COMMENT", "RULE_WS", "'->'", "'in'", "'out'", "'dataPort'", "'eventPort'", "'eventDataPort'", "'parameter'", "'busAccess'", "'subprogramAccess'", "'subprogramGroupAccess'", "'featureGroup'", "'abstractFeature'", "'abstract'", "'bus'", "'data'", "'device'", "'memory'", "'process'", "'processor'", "'subprogram'", "'system'", "'thread'", "'featureConnection'", "'accessConnection'", "'parameterConnection'", "'portConnection'", "'modeTransitionConnection'", "'featureGroupConnection'", "'parent'", "':'", "'{'", "'}'", "'['", "']'", "'source'", "'of'", "'('", "')'", "','", "'destination'", "'som'", "'group'", "'virtual'", "'.'", "'::'", "'complete'", "'<->'"
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


    // $ANTLR start "entryRuleSystemOperationMode"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:200:1: entryRuleSystemOperationMode : ruleSystemOperationMode EOF ;
    public final void entryRuleSystemOperationMode() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:201:1: ( ruleSystemOperationMode EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:202:1: ruleSystemOperationMode EOF
            {
             before(grammarAccess.getSystemOperationModeRule()); 
            pushFollow(FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode361);
            ruleSystemOperationMode();

            state._fsp--;

             after(grammarAccess.getSystemOperationModeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemOperationMode368); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:209:1: ruleSystemOperationMode : ( ( rule__SystemOperationMode__Group__0 ) ) ;
    public final void ruleSystemOperationMode() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:213:2: ( ( ( rule__SystemOperationMode__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:214:1: ( ( rule__SystemOperationMode__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:214:1: ( ( rule__SystemOperationMode__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:215:1: ( rule__SystemOperationMode__Group__0 )
            {
             before(grammarAccess.getSystemOperationModeAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:216:1: ( rule__SystemOperationMode__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:216:2: rule__SystemOperationMode__Group__0
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__Group__0_in_ruleSystemOperationMode394);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:228:1: entryRuleDirectionType : ruleDirectionType EOF ;
    public final void entryRuleDirectionType() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:229:1: ( ruleDirectionType EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:230:1: ruleDirectionType EOF
            {
             before(grammarAccess.getDirectionTypeRule()); 
            pushFollow(FOLLOW_ruleDirectionType_in_entryRuleDirectionType421);
            ruleDirectionType();

            state._fsp--;

             after(grammarAccess.getDirectionTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDirectionType428); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:237:1: ruleDirectionType : ( ( rule__DirectionType__Alternatives ) ) ;
    public final void ruleDirectionType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:241:2: ( ( ( rule__DirectionType__Alternatives ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:242:1: ( ( rule__DirectionType__Alternatives ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:242:1: ( ( rule__DirectionType__Alternatives ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:243:1: ( rule__DirectionType__Alternatives )
            {
             before(grammarAccess.getDirectionTypeAccess().getAlternatives()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:244:1: ( rule__DirectionType__Alternatives )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:244:2: rule__DirectionType__Alternatives
            {
            pushFollow(FOLLOW_rule__DirectionType__Alternatives_in_ruleDirectionType454);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:256:1: entryRuleFeatureCategory : ruleFeatureCategory EOF ;
    public final void entryRuleFeatureCategory() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:257:1: ( ruleFeatureCategory EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:258:1: ruleFeatureCategory EOF
            {
             before(grammarAccess.getFeatureCategoryRule()); 
            pushFollow(FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory481);
            ruleFeatureCategory();

            state._fsp--;

             after(grammarAccess.getFeatureCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCategory488); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:265:1: ruleFeatureCategory : ( ( rule__FeatureCategory__Alternatives ) ) ;
    public final void ruleFeatureCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:269:2: ( ( ( rule__FeatureCategory__Alternatives ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:270:1: ( ( rule__FeatureCategory__Alternatives ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:270:1: ( ( rule__FeatureCategory__Alternatives ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:271:1: ( rule__FeatureCategory__Alternatives )
            {
             before(grammarAccess.getFeatureCategoryAccess().getAlternatives()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:272:1: ( rule__FeatureCategory__Alternatives )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:272:2: rule__FeatureCategory__Alternatives
            {
            pushFollow(FOLLOW_rule__FeatureCategory__Alternatives_in_ruleFeatureCategory514);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:284:1: entryRuleComponentCategory : ruleComponentCategory EOF ;
    public final void entryRuleComponentCategory() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:285:1: ( ruleComponentCategory EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:286:1: ruleComponentCategory EOF
            {
             before(grammarAccess.getComponentCategoryRule()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory541);
            ruleComponentCategory();

            state._fsp--;

             after(grammarAccess.getComponentCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentCategory548); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:293:1: ruleComponentCategory : ( ( rule__ComponentCategory__Alternatives ) ) ;
    public final void ruleComponentCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:297:2: ( ( ( rule__ComponentCategory__Alternatives ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:298:1: ( ( rule__ComponentCategory__Alternatives ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:298:1: ( ( rule__ComponentCategory__Alternatives ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:299:1: ( rule__ComponentCategory__Alternatives )
            {
             before(grammarAccess.getComponentCategoryAccess().getAlternatives()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:300:1: ( rule__ComponentCategory__Alternatives )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:300:2: rule__ComponentCategory__Alternatives
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Alternatives_in_ruleComponentCategory574);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:312:1: entryRuleConnectionKind : ruleConnectionKind EOF ;
    public final void entryRuleConnectionKind() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:313:1: ( ruleConnectionKind EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:314:1: ruleConnectionKind EOF
            {
             before(grammarAccess.getConnectionKindRule()); 
            pushFollow(FOLLOW_ruleConnectionKind_in_entryRuleConnectionKind601);
            ruleConnectionKind();

            state._fsp--;

             after(grammarAccess.getConnectionKindRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionKind608); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:321:1: ruleConnectionKind : ( ( rule__ConnectionKind__Alternatives ) ) ;
    public final void ruleConnectionKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:325:2: ( ( ( rule__ConnectionKind__Alternatives ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:326:1: ( ( rule__ConnectionKind__Alternatives ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:326:1: ( ( rule__ConnectionKind__Alternatives ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:327:1: ( rule__ConnectionKind__Alternatives )
            {
             before(grammarAccess.getConnectionKindAccess().getAlternatives()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:328:1: ( rule__ConnectionKind__Alternatives )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:328:2: rule__ConnectionKind__Alternatives
            {
            pushFollow(FOLLOW_rule__ConnectionKind__Alternatives_in_ruleConnectionKind634);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:340:1: entryRuleIMPLREF : ruleIMPLREF EOF ;
    public final void entryRuleIMPLREF() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:341:1: ( ruleIMPLREF EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:342:1: ruleIMPLREF EOF
            {
             before(grammarAccess.getIMPLREFRule()); 
            pushFollow(FOLLOW_ruleIMPLREF_in_entryRuleIMPLREF661);
            ruleIMPLREF();

            state._fsp--;

             after(grammarAccess.getIMPLREFRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIMPLREF668); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:349:1: ruleIMPLREF : ( ( rule__IMPLREF__Group__0 ) ) ;
    public final void ruleIMPLREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:353:2: ( ( ( rule__IMPLREF__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:354:1: ( ( rule__IMPLREF__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:354:1: ( ( rule__IMPLREF__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:355:1: ( rule__IMPLREF__Group__0 )
            {
             before(grammarAccess.getIMPLREFAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:356:1: ( rule__IMPLREF__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:356:2: rule__IMPLREF__Group__0
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group__0_in_ruleIMPLREF694);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:368:1: entryRuleFEATREF : ruleFEATREF EOF ;
    public final void entryRuleFEATREF() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:369:1: ( ruleFEATREF EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:370:1: ruleFEATREF EOF
            {
             before(grammarAccess.getFEATREFRule()); 
            pushFollow(FOLLOW_ruleFEATREF_in_entryRuleFEATREF721);
            ruleFEATREF();

            state._fsp--;

             after(grammarAccess.getFEATREFRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFEATREF728); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:377:1: ruleFEATREF : ( ( rule__FEATREF__Group__0 ) ) ;
    public final void ruleFEATREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:381:2: ( ( ( rule__FEATREF__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:382:1: ( ( rule__FEATREF__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:382:1: ( ( rule__FEATREF__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:383:1: ( rule__FEATREF__Group__0 )
            {
             before(grammarAccess.getFEATREFAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:384:1: ( rule__FEATREF__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:384:2: rule__FEATREF__Group__0
            {
            pushFollow(FOLLOW_rule__FEATREF__Group__0_in_ruleFEATREF754);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:396:1: entryRuleSUBREF : ruleSUBREF EOF ;
    public final void entryRuleSUBREF() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:397:1: ( ruleSUBREF EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:398:1: ruleSUBREF EOF
            {
             before(grammarAccess.getSUBREFRule()); 
            pushFollow(FOLLOW_ruleSUBREF_in_entryRuleSUBREF781);
            ruleSUBREF();

            state._fsp--;

             after(grammarAccess.getSUBREFRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSUBREF788); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:405:1: ruleSUBREF : ( ( rule__SUBREF__Group__0 ) ) ;
    public final void ruleSUBREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:409:2: ( ( ( rule__SUBREF__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:410:1: ( ( rule__SUBREF__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:410:1: ( ( rule__SUBREF__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:411:1: ( rule__SUBREF__Group__0 )
            {
             before(grammarAccess.getSUBREFAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:412:1: ( rule__SUBREF__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:412:2: rule__SUBREF__Group__0
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__0_in_ruleSUBREF814);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:424:1: entryRuleINSTANCEREF : ruleINSTANCEREF EOF ;
    public final void entryRuleINSTANCEREF() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:425:1: ( ruleINSTANCEREF EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:426:1: ruleINSTANCEREF EOF
            {
             before(grammarAccess.getINSTANCEREFRule()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_entryRuleINSTANCEREF841);
            ruleINSTANCEREF();

            state._fsp--;

             after(grammarAccess.getINSTANCEREFRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleINSTANCEREF848); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:433:1: ruleINSTANCEREF : ( ( rule__INSTANCEREF__Group__0 ) ) ;
    public final void ruleINSTANCEREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:437:2: ( ( ( rule__INSTANCEREF__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:438:1: ( ( rule__INSTANCEREF__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:438:1: ( ( rule__INSTANCEREF__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:439:1: ( rule__INSTANCEREF__Group__0 )
            {
             before(grammarAccess.getINSTANCEREFAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:440:1: ( rule__INSTANCEREF__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:440:2: rule__INSTANCEREF__Group__0
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group__0_in_ruleINSTANCEREF874);
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


    // $ANTLR start "entryRuleINSTANCEREFWITHPARENT"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:452:1: entryRuleINSTANCEREFWITHPARENT : ruleINSTANCEREFWITHPARENT EOF ;
    public final void entryRuleINSTANCEREFWITHPARENT() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:453:1: ( ruleINSTANCEREFWITHPARENT EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:454:1: ruleINSTANCEREFWITHPARENT EOF
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTRule()); 
            pushFollow(FOLLOW_ruleINSTANCEREFWITHPARENT_in_entryRuleINSTANCEREFWITHPARENT901);
            ruleINSTANCEREFWITHPARENT();

            state._fsp--;

             after(grammarAccess.getINSTANCEREFWITHPARENTRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleINSTANCEREFWITHPARENT908); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:461:1: ruleINSTANCEREFWITHPARENT : ( ( rule__INSTANCEREFWITHPARENT__Alternatives ) ) ;
    public final void ruleINSTANCEREFWITHPARENT() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:465:2: ( ( ( rule__INSTANCEREFWITHPARENT__Alternatives ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:466:1: ( ( rule__INSTANCEREFWITHPARENT__Alternatives ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:466:1: ( ( rule__INSTANCEREFWITHPARENT__Alternatives ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:467:1: ( rule__INSTANCEREFWITHPARENT__Alternatives )
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getAlternatives()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:468:1: ( rule__INSTANCEREFWITHPARENT__Alternatives )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:468:2: rule__INSTANCEREFWITHPARENT__Alternatives
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Alternatives_in_ruleINSTANCEREFWITHPARENT934);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:480:1: entryRuleCONNINSTREF : ruleCONNINSTREF EOF ;
    public final void entryRuleCONNINSTREF() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:481:1: ( ruleCONNINSTREF EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:482:1: ruleCONNINSTREF EOF
            {
             before(grammarAccess.getCONNINSTREFRule()); 
            pushFollow(FOLLOW_ruleCONNINSTREF_in_entryRuleCONNINSTREF961);
            ruleCONNINSTREF();

            state._fsp--;

             after(grammarAccess.getCONNINSTREFRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCONNINSTREF968); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:489:1: ruleCONNINSTREF : ( ( rule__CONNINSTREF__Group__0 ) ) ;
    public final void ruleCONNINSTREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:493:2: ( ( ( rule__CONNINSTREF__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:494:1: ( ( rule__CONNINSTREF__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:494:1: ( ( rule__CONNINSTREF__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:495:1: ( rule__CONNINSTREF__Group__0 )
            {
             before(grammarAccess.getCONNINSTREFAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:496:1: ( rule__CONNINSTREF__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:496:2: rule__CONNINSTREF__Group__0
            {
            pushFollow(FOLLOW_rule__CONNINSTREF__Group__0_in_ruleCONNINSTREF994);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:508:1: rule__SystemInstance__Alternatives_5 : ( ( ( rule__SystemInstance__FeatureInstanceAssignment_5_0 ) ) | ( ( rule__SystemInstance__ComponentInstanceAssignment_5_1 ) ) | ( ( rule__SystemInstance__ConnectionInstanceAssignment_5_2 ) ) | ( ( rule__SystemInstance__SystemOperationModeAssignment_5_3 ) ) );
    public final void rule__SystemInstance__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:512:1: ( ( ( rule__SystemInstance__FeatureInstanceAssignment_5_0 ) ) | ( ( rule__SystemInstance__ComponentInstanceAssignment_5_1 ) ) | ( ( rule__SystemInstance__ConnectionInstanceAssignment_5_2 ) ) | ( ( rule__SystemInstance__SystemOperationModeAssignment_5_3 ) ) )
            int alt1=4;
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
            case 51:
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
            case 54:
                {
                alt1=3;
                }
                break;
            case 49:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:513:1: ( ( rule__SystemInstance__FeatureInstanceAssignment_5_0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:513:1: ( ( rule__SystemInstance__FeatureInstanceAssignment_5_0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:514:1: ( rule__SystemInstance__FeatureInstanceAssignment_5_0 )
                    {
                     before(grammarAccess.getSystemInstanceAccess().getFeatureInstanceAssignment_5_0()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:515:1: ( rule__SystemInstance__FeatureInstanceAssignment_5_0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:515:2: rule__SystemInstance__FeatureInstanceAssignment_5_0
                    {
                    pushFollow(FOLLOW_rule__SystemInstance__FeatureInstanceAssignment_5_0_in_rule__SystemInstance__Alternatives_51030);
                    rule__SystemInstance__FeatureInstanceAssignment_5_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSystemInstanceAccess().getFeatureInstanceAssignment_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:519:6: ( ( rule__SystemInstance__ComponentInstanceAssignment_5_1 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:519:6: ( ( rule__SystemInstance__ComponentInstanceAssignment_5_1 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:520:1: ( rule__SystemInstance__ComponentInstanceAssignment_5_1 )
                    {
                     before(grammarAccess.getSystemInstanceAccess().getComponentInstanceAssignment_5_1()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:521:1: ( rule__SystemInstance__ComponentInstanceAssignment_5_1 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:521:2: rule__SystemInstance__ComponentInstanceAssignment_5_1
                    {
                    pushFollow(FOLLOW_rule__SystemInstance__ComponentInstanceAssignment_5_1_in_rule__SystemInstance__Alternatives_51048);
                    rule__SystemInstance__ComponentInstanceAssignment_5_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getSystemInstanceAccess().getComponentInstanceAssignment_5_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:525:6: ( ( rule__SystemInstance__ConnectionInstanceAssignment_5_2 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:525:6: ( ( rule__SystemInstance__ConnectionInstanceAssignment_5_2 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:526:1: ( rule__SystemInstance__ConnectionInstanceAssignment_5_2 )
                    {
                     before(grammarAccess.getSystemInstanceAccess().getConnectionInstanceAssignment_5_2()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:527:1: ( rule__SystemInstance__ConnectionInstanceAssignment_5_2 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:527:2: rule__SystemInstance__ConnectionInstanceAssignment_5_2
                    {
                    pushFollow(FOLLOW_rule__SystemInstance__ConnectionInstanceAssignment_5_2_in_rule__SystemInstance__Alternatives_51066);
                    rule__SystemInstance__ConnectionInstanceAssignment_5_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getSystemInstanceAccess().getConnectionInstanceAssignment_5_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:531:6: ( ( rule__SystemInstance__SystemOperationModeAssignment_5_3 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:531:6: ( ( rule__SystemInstance__SystemOperationModeAssignment_5_3 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:532:1: ( rule__SystemInstance__SystemOperationModeAssignment_5_3 )
                    {
                     before(grammarAccess.getSystemInstanceAccess().getSystemOperationModeAssignment_5_3()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:533:1: ( rule__SystemInstance__SystemOperationModeAssignment_5_3 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:533:2: rule__SystemInstance__SystemOperationModeAssignment_5_3
                    {
                    pushFollow(FOLLOW_rule__SystemInstance__SystemOperationModeAssignment_5_3_in_rule__SystemInstance__Alternatives_51084);
                    rule__SystemInstance__SystemOperationModeAssignment_5_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getSystemInstanceAccess().getSystemOperationModeAssignment_5_3()); 

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


    // $ANTLR start "rule__ComponentInstance__Alternatives_7_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:542:1: rule__ComponentInstance__Alternatives_7_1 : ( ( ( rule__ComponentInstance__FeatureInstanceAssignment_7_1_0 ) ) | ( ( rule__ComponentInstance__ComponentInstanceAssignment_7_1_1 ) ) | ( ( rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2 ) ) );
    public final void rule__ComponentInstance__Alternatives_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:546:1: ( ( ( rule__ComponentInstance__FeatureInstanceAssignment_7_1_0 ) ) | ( ( rule__ComponentInstance__ComponentInstanceAssignment_7_1_1 ) ) | ( ( rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2 ) ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 10:
            case 11:
                {
                alt2=1;
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
            case 51:
                {
                alt2=2;
                }
                break;
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 54:
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
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:547:1: ( ( rule__ComponentInstance__FeatureInstanceAssignment_7_1_0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:547:1: ( ( rule__ComponentInstance__FeatureInstanceAssignment_7_1_0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:548:1: ( rule__ComponentInstance__FeatureInstanceAssignment_7_1_0 )
                    {
                     before(grammarAccess.getComponentInstanceAccess().getFeatureInstanceAssignment_7_1_0()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:549:1: ( rule__ComponentInstance__FeatureInstanceAssignment_7_1_0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:549:2: rule__ComponentInstance__FeatureInstanceAssignment_7_1_0
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__FeatureInstanceAssignment_7_1_0_in_rule__ComponentInstance__Alternatives_7_11117);
                    rule__ComponentInstance__FeatureInstanceAssignment_7_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentInstanceAccess().getFeatureInstanceAssignment_7_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:553:6: ( ( rule__ComponentInstance__ComponentInstanceAssignment_7_1_1 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:553:6: ( ( rule__ComponentInstance__ComponentInstanceAssignment_7_1_1 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:554:1: ( rule__ComponentInstance__ComponentInstanceAssignment_7_1_1 )
                    {
                     before(grammarAccess.getComponentInstanceAccess().getComponentInstanceAssignment_7_1_1()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:555:1: ( rule__ComponentInstance__ComponentInstanceAssignment_7_1_1 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:555:2: rule__ComponentInstance__ComponentInstanceAssignment_7_1_1
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__ComponentInstanceAssignment_7_1_1_in_rule__ComponentInstance__Alternatives_7_11135);
                    rule__ComponentInstance__ComponentInstanceAssignment_7_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentInstanceAccess().getComponentInstanceAssignment_7_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:559:6: ( ( rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:559:6: ( ( rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:560:1: ( rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2 )
                    {
                     before(grammarAccess.getComponentInstanceAccess().getConnectionInstanceAssignment_7_1_2()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:561:1: ( rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:561:2: rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2_in_rule__ComponentInstance__Alternatives_7_11153);
                    rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentInstanceAccess().getConnectionInstanceAssignment_7_1_2()); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:570:1: rule__ConnectionInstance__Alternatives_5 : ( ( ( rule__ConnectionInstance__BidirectionalAssignment_5_0 ) ) | ( '->' ) );
    public final void rule__ConnectionInstance__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:574:1: ( ( ( rule__ConnectionInstance__BidirectionalAssignment_5_0 ) ) | ( '->' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==55) ) {
                alt3=1;
            }
            else if ( (LA3_0==9) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:575:1: ( ( rule__ConnectionInstance__BidirectionalAssignment_5_0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:575:1: ( ( rule__ConnectionInstance__BidirectionalAssignment_5_0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:576:1: ( rule__ConnectionInstance__BidirectionalAssignment_5_0 )
                    {
                     before(grammarAccess.getConnectionInstanceAccess().getBidirectionalAssignment_5_0()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:577:1: ( rule__ConnectionInstance__BidirectionalAssignment_5_0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:577:2: rule__ConnectionInstance__BidirectionalAssignment_5_0
                    {
                    pushFollow(FOLLOW_rule__ConnectionInstance__BidirectionalAssignment_5_0_in_rule__ConnectionInstance__Alternatives_51186);
                    rule__ConnectionInstance__BidirectionalAssignment_5_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getConnectionInstanceAccess().getBidirectionalAssignment_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:581:6: ( '->' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:581:6: ( '->' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:582:1: '->'
                    {
                     before(grammarAccess.getConnectionInstanceAccess().getHyphenMinusGreaterThanSignKeyword_5_1()); 
                    match(input,9,FOLLOW_9_in_rule__ConnectionInstance__Alternatives_51205); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:594:1: rule__DirectionType__Alternatives : ( ( 'in' ) | ( 'out' ) | ( ( rule__DirectionType__Group_2__0 ) ) );
    public final void rule__DirectionType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:598:1: ( ( 'in' ) | ( 'out' ) | ( ( rule__DirectionType__Group_2__0 ) ) )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==10) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==EOF||(LA4_1>=12 && LA4_1<=20)) ) {
                    alt4=1;
                }
                else if ( (LA4_1==11) ) {
                    alt4=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA4_0==11) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:599:1: ( 'in' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:599:1: ( 'in' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:600:1: 'in'
                    {
                     before(grammarAccess.getDirectionTypeAccess().getInKeyword_0()); 
                    match(input,10,FOLLOW_10_in_rule__DirectionType__Alternatives1240); 
                     after(grammarAccess.getDirectionTypeAccess().getInKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:607:6: ( 'out' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:607:6: ( 'out' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:608:1: 'out'
                    {
                     before(grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); 
                    match(input,11,FOLLOW_11_in_rule__DirectionType__Alternatives1260); 
                     after(grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:615:6: ( ( rule__DirectionType__Group_2__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:615:6: ( ( rule__DirectionType__Group_2__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:616:1: ( rule__DirectionType__Group_2__0 )
                    {
                     before(grammarAccess.getDirectionTypeAccess().getGroup_2()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:617:1: ( rule__DirectionType__Group_2__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:617:2: rule__DirectionType__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__DirectionType__Group_2__0_in_rule__DirectionType__Alternatives1279);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:626:1: rule__FeatureCategory__Alternatives : ( ( 'dataPort' ) | ( 'eventPort' ) | ( 'eventDataPort' ) | ( 'parameter' ) | ( 'busAccess' ) | ( 'subprogramAccess' ) | ( 'subprogramGroupAccess' ) | ( 'featureGroup' ) | ( 'abstractFeature' ) );
    public final void rule__FeatureCategory__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:630:1: ( ( 'dataPort' ) | ( 'eventPort' ) | ( 'eventDataPort' ) | ( 'parameter' ) | ( 'busAccess' ) | ( 'subprogramAccess' ) | ( 'subprogramGroupAccess' ) | ( 'featureGroup' ) | ( 'abstractFeature' ) )
            int alt5=9;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt5=1;
                }
                break;
            case 13:
                {
                alt5=2;
                }
                break;
            case 14:
                {
                alt5=3;
                }
                break;
            case 15:
                {
                alt5=4;
                }
                break;
            case 16:
                {
                alt5=5;
                }
                break;
            case 17:
                {
                alt5=6;
                }
                break;
            case 18:
                {
                alt5=7;
                }
                break;
            case 19:
                {
                alt5=8;
                }
                break;
            case 20:
                {
                alt5=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:631:1: ( 'dataPort' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:631:1: ( 'dataPort' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:632:1: 'dataPort'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getDataPortKeyword_0()); 
                    match(input,12,FOLLOW_12_in_rule__FeatureCategory__Alternatives1313); 
                     after(grammarAccess.getFeatureCategoryAccess().getDataPortKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:639:6: ( 'eventPort' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:639:6: ( 'eventPort' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:640:1: 'eventPort'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getEventPortKeyword_1()); 
                    match(input,13,FOLLOW_13_in_rule__FeatureCategory__Alternatives1333); 
                     after(grammarAccess.getFeatureCategoryAccess().getEventPortKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:647:6: ( 'eventDataPort' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:647:6: ( 'eventDataPort' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:648:1: 'eventDataPort'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getEventDataPortKeyword_2()); 
                    match(input,14,FOLLOW_14_in_rule__FeatureCategory__Alternatives1353); 
                     after(grammarAccess.getFeatureCategoryAccess().getEventDataPortKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:655:6: ( 'parameter' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:655:6: ( 'parameter' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:656:1: 'parameter'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); 
                    match(input,15,FOLLOW_15_in_rule__FeatureCategory__Alternatives1373); 
                     after(grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:663:6: ( 'busAccess' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:663:6: ( 'busAccess' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:664:1: 'busAccess'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getBusAccessKeyword_4()); 
                    match(input,16,FOLLOW_16_in_rule__FeatureCategory__Alternatives1393); 
                     after(grammarAccess.getFeatureCategoryAccess().getBusAccessKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:671:6: ( 'subprogramAccess' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:671:6: ( 'subprogramAccess' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:672:1: 'subprogramAccess'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getSubprogramAccessKeyword_5()); 
                    match(input,17,FOLLOW_17_in_rule__FeatureCategory__Alternatives1413); 
                     after(grammarAccess.getFeatureCategoryAccess().getSubprogramAccessKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:679:6: ( 'subprogramGroupAccess' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:679:6: ( 'subprogramGroupAccess' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:680:1: 'subprogramGroupAccess'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getSubprogramGroupAccessKeyword_6()); 
                    match(input,18,FOLLOW_18_in_rule__FeatureCategory__Alternatives1433); 
                     after(grammarAccess.getFeatureCategoryAccess().getSubprogramGroupAccessKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:687:6: ( 'featureGroup' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:687:6: ( 'featureGroup' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:688:1: 'featureGroup'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getFeatureGroupKeyword_7()); 
                    match(input,19,FOLLOW_19_in_rule__FeatureCategory__Alternatives1453); 
                     after(grammarAccess.getFeatureCategoryAccess().getFeatureGroupKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:695:6: ( 'abstractFeature' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:695:6: ( 'abstractFeature' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:696:1: 'abstractFeature'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getAbstractFeatureKeyword_8()); 
                    match(input,20,FOLLOW_20_in_rule__FeatureCategory__Alternatives1473); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:708:1: rule__ComponentCategory__Alternatives : ( ( 'abstract' ) | ( 'bus' ) | ( 'data' ) | ( 'device' ) | ( 'memory' ) | ( 'process' ) | ( 'processor' ) | ( 'subprogram' ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( 'system' ) | ( ( rule__ComponentCategory__Group_10__0 ) ) | ( 'thread' ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( ( rule__ComponentCategory__Group_13__0 ) ) );
    public final void rule__ComponentCategory__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:712:1: ( ( 'abstract' ) | ( 'bus' ) | ( 'data' ) | ( 'device' ) | ( 'memory' ) | ( 'process' ) | ( 'processor' ) | ( 'subprogram' ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( 'system' ) | ( ( rule__ComponentCategory__Group_10__0 ) ) | ( 'thread' ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( ( rule__ComponentCategory__Group_13__0 ) ) )
            int alt6=14;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:713:1: ( 'abstract' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:713:1: ( 'abstract' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:714:1: 'abstract'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
                    match(input,21,FOLLOW_21_in_rule__ComponentCategory__Alternatives1508); 
                     after(grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:721:6: ( 'bus' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:721:6: ( 'bus' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:722:1: 'bus'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
                    match(input,22,FOLLOW_22_in_rule__ComponentCategory__Alternatives1528); 
                     after(grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:729:6: ( 'data' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:729:6: ( 'data' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:730:1: 'data'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
                    match(input,23,FOLLOW_23_in_rule__ComponentCategory__Alternatives1548); 
                     after(grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:737:6: ( 'device' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:737:6: ( 'device' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:738:1: 'device'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
                    match(input,24,FOLLOW_24_in_rule__ComponentCategory__Alternatives1568); 
                     after(grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:745:6: ( 'memory' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:745:6: ( 'memory' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:746:1: 'memory'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
                    match(input,25,FOLLOW_25_in_rule__ComponentCategory__Alternatives1588); 
                     after(grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:753:6: ( 'process' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:753:6: ( 'process' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:754:1: 'process'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
                    match(input,26,FOLLOW_26_in_rule__ComponentCategory__Alternatives1608); 
                     after(grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:761:6: ( 'processor' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:761:6: ( 'processor' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:762:1: 'processor'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
                    match(input,27,FOLLOW_27_in_rule__ComponentCategory__Alternatives1628); 
                     after(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:769:6: ( 'subprogram' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:769:6: ( 'subprogram' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:770:1: 'subprogram'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
                    match(input,28,FOLLOW_28_in_rule__ComponentCategory__Alternatives1648); 
                     after(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:777:6: ( ( rule__ComponentCategory__Group_8__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:777:6: ( ( rule__ComponentCategory__Group_8__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:778:1: ( rule__ComponentCategory__Group_8__0 )
                    {
                     before(grammarAccess.getComponentCategoryAccess().getGroup_8()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:779:1: ( rule__ComponentCategory__Group_8__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:779:2: rule__ComponentCategory__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__ComponentCategory__Group_8__0_in_rule__ComponentCategory__Alternatives1667);
                    rule__ComponentCategory__Group_8__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentCategoryAccess().getGroup_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:783:6: ( 'system' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:783:6: ( 'system' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:784:1: 'system'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
                    match(input,29,FOLLOW_29_in_rule__ComponentCategory__Alternatives1686); 
                     after(grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:791:6: ( ( rule__ComponentCategory__Group_10__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:791:6: ( ( rule__ComponentCategory__Group_10__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:792:1: ( rule__ComponentCategory__Group_10__0 )
                    {
                     before(grammarAccess.getComponentCategoryAccess().getGroup_10()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:793:1: ( rule__ComponentCategory__Group_10__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:793:2: rule__ComponentCategory__Group_10__0
                    {
                    pushFollow(FOLLOW_rule__ComponentCategory__Group_10__0_in_rule__ComponentCategory__Alternatives1705);
                    rule__ComponentCategory__Group_10__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentCategoryAccess().getGroup_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:797:6: ( 'thread' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:797:6: ( 'thread' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:798:1: 'thread'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
                    match(input,30,FOLLOW_30_in_rule__ComponentCategory__Alternatives1724); 
                     after(grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:805:6: ( ( rule__ComponentCategory__Group_12__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:805:6: ( ( rule__ComponentCategory__Group_12__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:806:1: ( rule__ComponentCategory__Group_12__0 )
                    {
                     before(grammarAccess.getComponentCategoryAccess().getGroup_12()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:807:1: ( rule__ComponentCategory__Group_12__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:807:2: rule__ComponentCategory__Group_12__0
                    {
                    pushFollow(FOLLOW_rule__ComponentCategory__Group_12__0_in_rule__ComponentCategory__Alternatives1743);
                    rule__ComponentCategory__Group_12__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentCategoryAccess().getGroup_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:811:6: ( ( rule__ComponentCategory__Group_13__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:811:6: ( ( rule__ComponentCategory__Group_13__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:812:1: ( rule__ComponentCategory__Group_13__0 )
                    {
                     before(grammarAccess.getComponentCategoryAccess().getGroup_13()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:813:1: ( rule__ComponentCategory__Group_13__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:813:2: rule__ComponentCategory__Group_13__0
                    {
                    pushFollow(FOLLOW_rule__ComponentCategory__Group_13__0_in_rule__ComponentCategory__Alternatives1761);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:822:1: rule__ConnectionKind__Alternatives : ( ( 'featureConnection' ) | ( 'accessConnection' ) | ( 'parameterConnection' ) | ( 'portConnection' ) | ( 'modeTransitionConnection' ) | ( 'featureGroupConnection' ) );
    public final void rule__ConnectionKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:826:1: ( ( 'featureConnection' ) | ( 'accessConnection' ) | ( 'parameterConnection' ) | ( 'portConnection' ) | ( 'modeTransitionConnection' ) | ( 'featureGroupConnection' ) )
            int alt7=6;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt7=1;
                }
                break;
            case 32:
                {
                alt7=2;
                }
                break;
            case 33:
                {
                alt7=3;
                }
                break;
            case 34:
                {
                alt7=4;
                }
                break;
            case 35:
                {
                alt7=5;
                }
                break;
            case 36:
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
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:827:1: ( 'featureConnection' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:827:1: ( 'featureConnection' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:828:1: 'featureConnection'
                    {
                     before(grammarAccess.getConnectionKindAccess().getFeatureConnectionKeyword_0()); 
                    match(input,31,FOLLOW_31_in_rule__ConnectionKind__Alternatives1795); 
                     after(grammarAccess.getConnectionKindAccess().getFeatureConnectionKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:835:6: ( 'accessConnection' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:835:6: ( 'accessConnection' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:836:1: 'accessConnection'
                    {
                     before(grammarAccess.getConnectionKindAccess().getAccessConnectionKeyword_1()); 
                    match(input,32,FOLLOW_32_in_rule__ConnectionKind__Alternatives1815); 
                     after(grammarAccess.getConnectionKindAccess().getAccessConnectionKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:843:6: ( 'parameterConnection' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:843:6: ( 'parameterConnection' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:844:1: 'parameterConnection'
                    {
                     before(grammarAccess.getConnectionKindAccess().getParameterConnectionKeyword_2()); 
                    match(input,33,FOLLOW_33_in_rule__ConnectionKind__Alternatives1835); 
                     after(grammarAccess.getConnectionKindAccess().getParameterConnectionKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:851:6: ( 'portConnection' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:851:6: ( 'portConnection' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:852:1: 'portConnection'
                    {
                     before(grammarAccess.getConnectionKindAccess().getPortConnectionKeyword_3()); 
                    match(input,34,FOLLOW_34_in_rule__ConnectionKind__Alternatives1855); 
                     after(grammarAccess.getConnectionKindAccess().getPortConnectionKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:859:6: ( 'modeTransitionConnection' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:859:6: ( 'modeTransitionConnection' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:860:1: 'modeTransitionConnection'
                    {
                     before(grammarAccess.getConnectionKindAccess().getModeTransitionConnectionKeyword_4()); 
                    match(input,35,FOLLOW_35_in_rule__ConnectionKind__Alternatives1875); 
                     after(grammarAccess.getConnectionKindAccess().getModeTransitionConnectionKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:867:6: ( 'featureGroupConnection' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:867:6: ( 'featureGroupConnection' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:868:1: 'featureGroupConnection'
                    {
                     before(grammarAccess.getConnectionKindAccess().getFeatureGroupConnectionKeyword_5()); 
                    match(input,36,FOLLOW_36_in_rule__ConnectionKind__Alternatives1895); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:880:1: rule__INSTANCEREFWITHPARENT__Alternatives : ( ( 'parent' ) | ( ( rule__INSTANCEREFWITHPARENT__Group_1__0 ) ) );
    public final void rule__INSTANCEREFWITHPARENT__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:884:1: ( ( 'parent' ) | ( ( rule__INSTANCEREFWITHPARENT__Group_1__0 ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==37) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_ID) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:885:1: ( 'parent' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:885:1: ( 'parent' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:886:1: 'parent'
                    {
                     before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getParentKeyword_0()); 
                    match(input,37,FOLLOW_37_in_rule__INSTANCEREFWITHPARENT__Alternatives1930); 
                     after(grammarAccess.getINSTANCEREFWITHPARENTAccess().getParentKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:893:6: ( ( rule__INSTANCEREFWITHPARENT__Group_1__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:893:6: ( ( rule__INSTANCEREFWITHPARENT__Group_1__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:894:1: ( rule__INSTANCEREFWITHPARENT__Group_1__0 )
                    {
                     before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getGroup_1()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:895:1: ( rule__INSTANCEREFWITHPARENT__Group_1__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:895:2: rule__INSTANCEREFWITHPARENT__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__0_in_rule__INSTANCEREFWITHPARENT__Alternatives1949);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:906:1: rule__SystemInstance__Group__0 : rule__SystemInstance__Group__0__Impl rule__SystemInstance__Group__1 ;
    public final void rule__SystemInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:910:1: ( rule__SystemInstance__Group__0__Impl rule__SystemInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:911:2: rule__SystemInstance__Group__0__Impl rule__SystemInstance__Group__1
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__0__Impl_in_rule__SystemInstance__Group__01980);
            rule__SystemInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__1_in_rule__SystemInstance__Group__01983);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:918:1: rule__SystemInstance__Group__0__Impl : ( ( rule__SystemInstance__CategoryAssignment_0 ) ) ;
    public final void rule__SystemInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:922:1: ( ( ( rule__SystemInstance__CategoryAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:923:1: ( ( rule__SystemInstance__CategoryAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:923:1: ( ( rule__SystemInstance__CategoryAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:924:1: ( rule__SystemInstance__CategoryAssignment_0 )
            {
             before(grammarAccess.getSystemInstanceAccess().getCategoryAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:925:1: ( rule__SystemInstance__CategoryAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:925:2: rule__SystemInstance__CategoryAssignment_0
            {
            pushFollow(FOLLOW_rule__SystemInstance__CategoryAssignment_0_in_rule__SystemInstance__Group__0__Impl2010);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:935:1: rule__SystemInstance__Group__1 : rule__SystemInstance__Group__1__Impl rule__SystemInstance__Group__2 ;
    public final void rule__SystemInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:939:1: ( rule__SystemInstance__Group__1__Impl rule__SystemInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:940:2: rule__SystemInstance__Group__1__Impl rule__SystemInstance__Group__2
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__1__Impl_in_rule__SystemInstance__Group__12040);
            rule__SystemInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__2_in_rule__SystemInstance__Group__12043);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:947:1: rule__SystemInstance__Group__1__Impl : ( ( rule__SystemInstance__NameAssignment_1 ) ) ;
    public final void rule__SystemInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:951:1: ( ( ( rule__SystemInstance__NameAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:952:1: ( ( rule__SystemInstance__NameAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:952:1: ( ( rule__SystemInstance__NameAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:953:1: ( rule__SystemInstance__NameAssignment_1 )
            {
             before(grammarAccess.getSystemInstanceAccess().getNameAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:954:1: ( rule__SystemInstance__NameAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:954:2: rule__SystemInstance__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SystemInstance__NameAssignment_1_in_rule__SystemInstance__Group__1__Impl2070);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:964:1: rule__SystemInstance__Group__2 : rule__SystemInstance__Group__2__Impl rule__SystemInstance__Group__3 ;
    public final void rule__SystemInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:968:1: ( rule__SystemInstance__Group__2__Impl rule__SystemInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:969:2: rule__SystemInstance__Group__2__Impl rule__SystemInstance__Group__3
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__2__Impl_in_rule__SystemInstance__Group__22100);
            rule__SystemInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__3_in_rule__SystemInstance__Group__22103);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:976:1: rule__SystemInstance__Group__2__Impl : ( ':' ) ;
    public final void rule__SystemInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:980:1: ( ( ':' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:981:1: ( ':' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:981:1: ( ':' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:982:1: ':'
            {
             before(grammarAccess.getSystemInstanceAccess().getColonKeyword_2()); 
            match(input,38,FOLLOW_38_in_rule__SystemInstance__Group__2__Impl2131); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:995:1: rule__SystemInstance__Group__3 : rule__SystemInstance__Group__3__Impl rule__SystemInstance__Group__4 ;
    public final void rule__SystemInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:999:1: ( rule__SystemInstance__Group__3__Impl rule__SystemInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1000:2: rule__SystemInstance__Group__3__Impl rule__SystemInstance__Group__4
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__3__Impl_in_rule__SystemInstance__Group__32162);
            rule__SystemInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__4_in_rule__SystemInstance__Group__32165);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1007:1: rule__SystemInstance__Group__3__Impl : ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) ) ;
    public final void rule__SystemInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1011:1: ( ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1012:1: ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1012:1: ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1013:1: ( rule__SystemInstance__ComponentImplementationAssignment_3 )
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentImplementationAssignment_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1014:1: ( rule__SystemInstance__ComponentImplementationAssignment_3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1014:2: rule__SystemInstance__ComponentImplementationAssignment_3
            {
            pushFollow(FOLLOW_rule__SystemInstance__ComponentImplementationAssignment_3_in_rule__SystemInstance__Group__3__Impl2192);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1024:1: rule__SystemInstance__Group__4 : rule__SystemInstance__Group__4__Impl rule__SystemInstance__Group__5 ;
    public final void rule__SystemInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1028:1: ( rule__SystemInstance__Group__4__Impl rule__SystemInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1029:2: rule__SystemInstance__Group__4__Impl rule__SystemInstance__Group__5
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__4__Impl_in_rule__SystemInstance__Group__42222);
            rule__SystemInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__5_in_rule__SystemInstance__Group__42225);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1036:1: rule__SystemInstance__Group__4__Impl : ( '{' ) ;
    public final void rule__SystemInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1040:1: ( ( '{' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1041:1: ( '{' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1041:1: ( '{' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1042:1: '{'
            {
             before(grammarAccess.getSystemInstanceAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,39,FOLLOW_39_in_rule__SystemInstance__Group__4__Impl2253); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1055:1: rule__SystemInstance__Group__5 : rule__SystemInstance__Group__5__Impl rule__SystemInstance__Group__6 ;
    public final void rule__SystemInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1059:1: ( rule__SystemInstance__Group__5__Impl rule__SystemInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1060:2: rule__SystemInstance__Group__5__Impl rule__SystemInstance__Group__6
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__5__Impl_in_rule__SystemInstance__Group__52284);
            rule__SystemInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__6_in_rule__SystemInstance__Group__52287);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1067:1: rule__SystemInstance__Group__5__Impl : ( ( rule__SystemInstance__Alternatives_5 )* ) ;
    public final void rule__SystemInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1071:1: ( ( ( rule__SystemInstance__Alternatives_5 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1072:1: ( ( rule__SystemInstance__Alternatives_5 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1072:1: ( ( rule__SystemInstance__Alternatives_5 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1073:1: ( rule__SystemInstance__Alternatives_5 )*
            {
             before(grammarAccess.getSystemInstanceAccess().getAlternatives_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1074:1: ( rule__SystemInstance__Alternatives_5 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=10 && LA9_0<=11)||(LA9_0>=21 && LA9_0<=36)||LA9_0==49||LA9_0==51||LA9_0==54) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1074:2: rule__SystemInstance__Alternatives_5
            	    {
            	    pushFollow(FOLLOW_rule__SystemInstance__Alternatives_5_in_rule__SystemInstance__Group__5__Impl2314);
            	    rule__SystemInstance__Alternatives_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1084:1: rule__SystemInstance__Group__6 : rule__SystemInstance__Group__6__Impl ;
    public final void rule__SystemInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1088:1: ( rule__SystemInstance__Group__6__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1089:2: rule__SystemInstance__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__6__Impl_in_rule__SystemInstance__Group__62345);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1095:1: rule__SystemInstance__Group__6__Impl : ( '}' ) ;
    public final void rule__SystemInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1099:1: ( ( '}' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1100:1: ( '}' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1100:1: ( '}' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1101:1: '}'
            {
             before(grammarAccess.getSystemInstanceAccess().getRightCurlyBracketKeyword_6()); 
            match(input,40,FOLLOW_40_in_rule__SystemInstance__Group__6__Impl2373); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1128:1: rule__FeatureInstance__Group__0 : rule__FeatureInstance__Group__0__Impl rule__FeatureInstance__Group__1 ;
    public final void rule__FeatureInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1132:1: ( rule__FeatureInstance__Group__0__Impl rule__FeatureInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1133:2: rule__FeatureInstance__Group__0__Impl rule__FeatureInstance__Group__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__0__Impl_in_rule__FeatureInstance__Group__02418);
            rule__FeatureInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__1_in_rule__FeatureInstance__Group__02421);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1140:1: rule__FeatureInstance__Group__0__Impl : ( ( rule__FeatureInstance__DirectionAssignment_0 ) ) ;
    public final void rule__FeatureInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1144:1: ( ( ( rule__FeatureInstance__DirectionAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1145:1: ( ( rule__FeatureInstance__DirectionAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1145:1: ( ( rule__FeatureInstance__DirectionAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1146:1: ( rule__FeatureInstance__DirectionAssignment_0 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getDirectionAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1147:1: ( rule__FeatureInstance__DirectionAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1147:2: rule__FeatureInstance__DirectionAssignment_0
            {
            pushFollow(FOLLOW_rule__FeatureInstance__DirectionAssignment_0_in_rule__FeatureInstance__Group__0__Impl2448);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1157:1: rule__FeatureInstance__Group__1 : rule__FeatureInstance__Group__1__Impl rule__FeatureInstance__Group__2 ;
    public final void rule__FeatureInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1161:1: ( rule__FeatureInstance__Group__1__Impl rule__FeatureInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1162:2: rule__FeatureInstance__Group__1__Impl rule__FeatureInstance__Group__2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__1__Impl_in_rule__FeatureInstance__Group__12478);
            rule__FeatureInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__2_in_rule__FeatureInstance__Group__12481);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1169:1: rule__FeatureInstance__Group__1__Impl : ( ( rule__FeatureInstance__CategoryAssignment_1 ) ) ;
    public final void rule__FeatureInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1173:1: ( ( ( rule__FeatureInstance__CategoryAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1174:1: ( ( rule__FeatureInstance__CategoryAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1174:1: ( ( rule__FeatureInstance__CategoryAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1175:1: ( rule__FeatureInstance__CategoryAssignment_1 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getCategoryAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1176:1: ( rule__FeatureInstance__CategoryAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1176:2: rule__FeatureInstance__CategoryAssignment_1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__CategoryAssignment_1_in_rule__FeatureInstance__Group__1__Impl2508);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1186:1: rule__FeatureInstance__Group__2 : rule__FeatureInstance__Group__2__Impl rule__FeatureInstance__Group__3 ;
    public final void rule__FeatureInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1190:1: ( rule__FeatureInstance__Group__2__Impl rule__FeatureInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1191:2: rule__FeatureInstance__Group__2__Impl rule__FeatureInstance__Group__3
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__2__Impl_in_rule__FeatureInstance__Group__22538);
            rule__FeatureInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__3_in_rule__FeatureInstance__Group__22541);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1198:1: rule__FeatureInstance__Group__2__Impl : ( ( rule__FeatureInstance__NameAssignment_2 ) ) ;
    public final void rule__FeatureInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1202:1: ( ( ( rule__FeatureInstance__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1203:1: ( ( rule__FeatureInstance__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1203:1: ( ( rule__FeatureInstance__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1204:1: ( rule__FeatureInstance__NameAssignment_2 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1205:1: ( rule__FeatureInstance__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1205:2: rule__FeatureInstance__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__NameAssignment_2_in_rule__FeatureInstance__Group__2__Impl2568);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1215:1: rule__FeatureInstance__Group__3 : rule__FeatureInstance__Group__3__Impl rule__FeatureInstance__Group__4 ;
    public final void rule__FeatureInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1219:1: ( rule__FeatureInstance__Group__3__Impl rule__FeatureInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1220:2: rule__FeatureInstance__Group__3__Impl rule__FeatureInstance__Group__4
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__3__Impl_in_rule__FeatureInstance__Group__32598);
            rule__FeatureInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__4_in_rule__FeatureInstance__Group__32601);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1227:1: rule__FeatureInstance__Group__3__Impl : ( ( rule__FeatureInstance__Group_3__0 )? ) ;
    public final void rule__FeatureInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1231:1: ( ( ( rule__FeatureInstance__Group_3__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1232:1: ( ( rule__FeatureInstance__Group_3__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1232:1: ( ( rule__FeatureInstance__Group_3__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1233:1: ( rule__FeatureInstance__Group_3__0 )?
            {
             before(grammarAccess.getFeatureInstanceAccess().getGroup_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1234:1: ( rule__FeatureInstance__Group_3__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==41) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1234:2: rule__FeatureInstance__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__FeatureInstance__Group_3__0_in_rule__FeatureInstance__Group__3__Impl2628);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1244:1: rule__FeatureInstance__Group__4 : rule__FeatureInstance__Group__4__Impl rule__FeatureInstance__Group__5 ;
    public final void rule__FeatureInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1248:1: ( rule__FeatureInstance__Group__4__Impl rule__FeatureInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1249:2: rule__FeatureInstance__Group__4__Impl rule__FeatureInstance__Group__5
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__4__Impl_in_rule__FeatureInstance__Group__42659);
            rule__FeatureInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__5_in_rule__FeatureInstance__Group__42662);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1256:1: rule__FeatureInstance__Group__4__Impl : ( ':' ) ;
    public final void rule__FeatureInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1260:1: ( ( ':' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1261:1: ( ':' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1261:1: ( ':' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1262:1: ':'
            {
             before(grammarAccess.getFeatureInstanceAccess().getColonKeyword_4()); 
            match(input,38,FOLLOW_38_in_rule__FeatureInstance__Group__4__Impl2690); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1275:1: rule__FeatureInstance__Group__5 : rule__FeatureInstance__Group__5__Impl rule__FeatureInstance__Group__6 ;
    public final void rule__FeatureInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1279:1: ( rule__FeatureInstance__Group__5__Impl rule__FeatureInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1280:2: rule__FeatureInstance__Group__5__Impl rule__FeatureInstance__Group__6
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__5__Impl_in_rule__FeatureInstance__Group__52721);
            rule__FeatureInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__6_in_rule__FeatureInstance__Group__52724);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1287:1: rule__FeatureInstance__Group__5__Impl : ( ( rule__FeatureInstance__FeatureAssignment_5 ) ) ;
    public final void rule__FeatureInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1291:1: ( ( ( rule__FeatureInstance__FeatureAssignment_5 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1292:1: ( ( rule__FeatureInstance__FeatureAssignment_5 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1292:1: ( ( rule__FeatureInstance__FeatureAssignment_5 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1293:1: ( rule__FeatureInstance__FeatureAssignment_5 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1294:1: ( rule__FeatureInstance__FeatureAssignment_5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1294:2: rule__FeatureInstance__FeatureAssignment_5
            {
            pushFollow(FOLLOW_rule__FeatureInstance__FeatureAssignment_5_in_rule__FeatureInstance__Group__5__Impl2751);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1304:1: rule__FeatureInstance__Group__6 : rule__FeatureInstance__Group__6__Impl rule__FeatureInstance__Group__7 ;
    public final void rule__FeatureInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1308:1: ( rule__FeatureInstance__Group__6__Impl rule__FeatureInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1309:2: rule__FeatureInstance__Group__6__Impl rule__FeatureInstance__Group__7
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__6__Impl_in_rule__FeatureInstance__Group__62781);
            rule__FeatureInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__7_in_rule__FeatureInstance__Group__62784);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1316:1: rule__FeatureInstance__Group__6__Impl : ( ( rule__FeatureInstance__Group_6__0 )? ) ;
    public final void rule__FeatureInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1320:1: ( ( ( rule__FeatureInstance__Group_6__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1321:1: ( ( rule__FeatureInstance__Group_6__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1321:1: ( ( rule__FeatureInstance__Group_6__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1322:1: ( rule__FeatureInstance__Group_6__0 )?
            {
             before(grammarAccess.getFeatureInstanceAccess().getGroup_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1323:1: ( rule__FeatureInstance__Group_6__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==43) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1323:2: rule__FeatureInstance__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__FeatureInstance__Group_6__0_in_rule__FeatureInstance__Group__6__Impl2811);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1333:1: rule__FeatureInstance__Group__7 : rule__FeatureInstance__Group__7__Impl rule__FeatureInstance__Group__8 ;
    public final void rule__FeatureInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1337:1: ( rule__FeatureInstance__Group__7__Impl rule__FeatureInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1338:2: rule__FeatureInstance__Group__7__Impl rule__FeatureInstance__Group__8
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__7__Impl_in_rule__FeatureInstance__Group__72842);
            rule__FeatureInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__8_in_rule__FeatureInstance__Group__72845);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1345:1: rule__FeatureInstance__Group__7__Impl : ( ( rule__FeatureInstance__Group_7__0 )? ) ;
    public final void rule__FeatureInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1349:1: ( ( ( rule__FeatureInstance__Group_7__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1350:1: ( ( rule__FeatureInstance__Group_7__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1350:1: ( ( rule__FeatureInstance__Group_7__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1351:1: ( rule__FeatureInstance__Group_7__0 )?
            {
             before(grammarAccess.getFeatureInstanceAccess().getGroup_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1352:1: ( rule__FeatureInstance__Group_7__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==48) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1352:2: rule__FeatureInstance__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__FeatureInstance__Group_7__0_in_rule__FeatureInstance__Group__7__Impl2872);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1362:1: rule__FeatureInstance__Group__8 : rule__FeatureInstance__Group__8__Impl ;
    public final void rule__FeatureInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1366:1: ( rule__FeatureInstance__Group__8__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1367:2: rule__FeatureInstance__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__8__Impl_in_rule__FeatureInstance__Group__82903);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1373:1: rule__FeatureInstance__Group__8__Impl : ( ( rule__FeatureInstance__Group_8__0 )? ) ;
    public final void rule__FeatureInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1377:1: ( ( ( rule__FeatureInstance__Group_8__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1378:1: ( ( rule__FeatureInstance__Group_8__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1378:1: ( ( rule__FeatureInstance__Group_8__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1379:1: ( rule__FeatureInstance__Group_8__0 )?
            {
             before(grammarAccess.getFeatureInstanceAccess().getGroup_8()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1380:1: ( rule__FeatureInstance__Group_8__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==39) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1380:2: rule__FeatureInstance__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__FeatureInstance__Group_8__0_in_rule__FeatureInstance__Group__8__Impl2930);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1408:1: rule__FeatureInstance__Group_3__0 : rule__FeatureInstance__Group_3__0__Impl rule__FeatureInstance__Group_3__1 ;
    public final void rule__FeatureInstance__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1412:1: ( rule__FeatureInstance__Group_3__0__Impl rule__FeatureInstance__Group_3__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1413:2: rule__FeatureInstance__Group_3__0__Impl rule__FeatureInstance__Group_3__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__0__Impl_in_rule__FeatureInstance__Group_3__02979);
            rule__FeatureInstance__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__1_in_rule__FeatureInstance__Group_3__02982);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1420:1: rule__FeatureInstance__Group_3__0__Impl : ( '[' ) ;
    public final void rule__FeatureInstance__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1424:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1425:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1425:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1426:1: '['
            {
             before(grammarAccess.getFeatureInstanceAccess().getLeftSquareBracketKeyword_3_0()); 
            match(input,41,FOLLOW_41_in_rule__FeatureInstance__Group_3__0__Impl3010); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1439:1: rule__FeatureInstance__Group_3__1 : rule__FeatureInstance__Group_3__1__Impl rule__FeatureInstance__Group_3__2 ;
    public final void rule__FeatureInstance__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1443:1: ( rule__FeatureInstance__Group_3__1__Impl rule__FeatureInstance__Group_3__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1444:2: rule__FeatureInstance__Group_3__1__Impl rule__FeatureInstance__Group_3__2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__1__Impl_in_rule__FeatureInstance__Group_3__13041);
            rule__FeatureInstance__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__2_in_rule__FeatureInstance__Group_3__13044);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1451:1: rule__FeatureInstance__Group_3__1__Impl : ( ( rule__FeatureInstance__IndexAssignment_3_1 ) ) ;
    public final void rule__FeatureInstance__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1455:1: ( ( ( rule__FeatureInstance__IndexAssignment_3_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1456:1: ( ( rule__FeatureInstance__IndexAssignment_3_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1456:1: ( ( rule__FeatureInstance__IndexAssignment_3_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1457:1: ( rule__FeatureInstance__IndexAssignment_3_1 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getIndexAssignment_3_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1458:1: ( rule__FeatureInstance__IndexAssignment_3_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1458:2: rule__FeatureInstance__IndexAssignment_3_1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__IndexAssignment_3_1_in_rule__FeatureInstance__Group_3__1__Impl3071);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1468:1: rule__FeatureInstance__Group_3__2 : rule__FeatureInstance__Group_3__2__Impl ;
    public final void rule__FeatureInstance__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1472:1: ( rule__FeatureInstance__Group_3__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1473:2: rule__FeatureInstance__Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__2__Impl_in_rule__FeatureInstance__Group_3__23101);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1479:1: rule__FeatureInstance__Group_3__2__Impl : ( ']' ) ;
    public final void rule__FeatureInstance__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1483:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1484:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1484:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1485:1: ']'
            {
             before(grammarAccess.getFeatureInstanceAccess().getRightSquareBracketKeyword_3_2()); 
            match(input,42,FOLLOW_42_in_rule__FeatureInstance__Group_3__2__Impl3129); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1504:1: rule__FeatureInstance__Group_6__0 : rule__FeatureInstance__Group_6__0__Impl rule__FeatureInstance__Group_6__1 ;
    public final void rule__FeatureInstance__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1508:1: ( rule__FeatureInstance__Group_6__0__Impl rule__FeatureInstance__Group_6__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1509:2: rule__FeatureInstance__Group_6__0__Impl rule__FeatureInstance__Group_6__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__0__Impl_in_rule__FeatureInstance__Group_6__03166);
            rule__FeatureInstance__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__1_in_rule__FeatureInstance__Group_6__03169);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1516:1: rule__FeatureInstance__Group_6__0__Impl : ( 'source' ) ;
    public final void rule__FeatureInstance__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1520:1: ( ( 'source' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1521:1: ( 'source' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1521:1: ( 'source' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1522:1: 'source'
            {
             before(grammarAccess.getFeatureInstanceAccess().getSourceKeyword_6_0()); 
            match(input,43,FOLLOW_43_in_rule__FeatureInstance__Group_6__0__Impl3197); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1535:1: rule__FeatureInstance__Group_6__1 : rule__FeatureInstance__Group_6__1__Impl rule__FeatureInstance__Group_6__2 ;
    public final void rule__FeatureInstance__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1539:1: ( rule__FeatureInstance__Group_6__1__Impl rule__FeatureInstance__Group_6__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1540:2: rule__FeatureInstance__Group_6__1__Impl rule__FeatureInstance__Group_6__2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__1__Impl_in_rule__FeatureInstance__Group_6__13228);
            rule__FeatureInstance__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__2_in_rule__FeatureInstance__Group_6__13231);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1547:1: rule__FeatureInstance__Group_6__1__Impl : ( 'of' ) ;
    public final void rule__FeatureInstance__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1551:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1552:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1552:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1553:1: 'of'
            {
             before(grammarAccess.getFeatureInstanceAccess().getOfKeyword_6_1()); 
            match(input,44,FOLLOW_44_in_rule__FeatureInstance__Group_6__1__Impl3259); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1566:1: rule__FeatureInstance__Group_6__2 : rule__FeatureInstance__Group_6__2__Impl rule__FeatureInstance__Group_6__3 ;
    public final void rule__FeatureInstance__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1570:1: ( rule__FeatureInstance__Group_6__2__Impl rule__FeatureInstance__Group_6__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1571:2: rule__FeatureInstance__Group_6__2__Impl rule__FeatureInstance__Group_6__3
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__2__Impl_in_rule__FeatureInstance__Group_6__23290);
            rule__FeatureInstance__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__3_in_rule__FeatureInstance__Group_6__23293);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1578:1: rule__FeatureInstance__Group_6__2__Impl : ( '(' ) ;
    public final void rule__FeatureInstance__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1582:1: ( ( '(' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1583:1: ( '(' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1583:1: ( '(' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1584:1: '('
            {
             before(grammarAccess.getFeatureInstanceAccess().getLeftParenthesisKeyword_6_2()); 
            match(input,45,FOLLOW_45_in_rule__FeatureInstance__Group_6__2__Impl3321); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1597:1: rule__FeatureInstance__Group_6__3 : rule__FeatureInstance__Group_6__3__Impl rule__FeatureInstance__Group_6__4 ;
    public final void rule__FeatureInstance__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1601:1: ( rule__FeatureInstance__Group_6__3__Impl rule__FeatureInstance__Group_6__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1602:2: rule__FeatureInstance__Group_6__3__Impl rule__FeatureInstance__Group_6__4
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__3__Impl_in_rule__FeatureInstance__Group_6__33352);
            rule__FeatureInstance__Group_6__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__4_in_rule__FeatureInstance__Group_6__33355);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1609:1: rule__FeatureInstance__Group_6__3__Impl : ( ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3 ) ) ;
    public final void rule__FeatureInstance__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1613:1: ( ( ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1614:1: ( ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1614:1: ( ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1615:1: ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceAssignment_6_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1616:1: ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1616:2: rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3
            {
            pushFollow(FOLLOW_rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3_in_rule__FeatureInstance__Group_6__3__Impl3382);
            rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3();

            state._fsp--;


            }

             after(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceAssignment_6_3()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1626:1: rule__FeatureInstance__Group_6__4 : rule__FeatureInstance__Group_6__4__Impl rule__FeatureInstance__Group_6__5 ;
    public final void rule__FeatureInstance__Group_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1630:1: ( rule__FeatureInstance__Group_6__4__Impl rule__FeatureInstance__Group_6__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1631:2: rule__FeatureInstance__Group_6__4__Impl rule__FeatureInstance__Group_6__5
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__4__Impl_in_rule__FeatureInstance__Group_6__43412);
            rule__FeatureInstance__Group_6__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__5_in_rule__FeatureInstance__Group_6__43415);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1638:1: rule__FeatureInstance__Group_6__4__Impl : ( ( rule__FeatureInstance__Group_6_4__0 )* ) ;
    public final void rule__FeatureInstance__Group_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1642:1: ( ( ( rule__FeatureInstance__Group_6_4__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1643:1: ( ( rule__FeatureInstance__Group_6_4__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1643:1: ( ( rule__FeatureInstance__Group_6_4__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1644:1: ( rule__FeatureInstance__Group_6_4__0 )*
            {
             before(grammarAccess.getFeatureInstanceAccess().getGroup_6_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1645:1: ( rule__FeatureInstance__Group_6_4__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==47) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1645:2: rule__FeatureInstance__Group_6_4__0
            	    {
            	    pushFollow(FOLLOW_rule__FeatureInstance__Group_6_4__0_in_rule__FeatureInstance__Group_6__4__Impl3442);
            	    rule__FeatureInstance__Group_6_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1655:1: rule__FeatureInstance__Group_6__5 : rule__FeatureInstance__Group_6__5__Impl ;
    public final void rule__FeatureInstance__Group_6__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1659:1: ( rule__FeatureInstance__Group_6__5__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1660:2: rule__FeatureInstance__Group_6__5__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__5__Impl_in_rule__FeatureInstance__Group_6__53473);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1666:1: rule__FeatureInstance__Group_6__5__Impl : ( ')' ) ;
    public final void rule__FeatureInstance__Group_6__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1670:1: ( ( ')' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1671:1: ( ')' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1671:1: ( ')' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1672:1: ')'
            {
             before(grammarAccess.getFeatureInstanceAccess().getRightParenthesisKeyword_6_5()); 
            match(input,46,FOLLOW_46_in_rule__FeatureInstance__Group_6__5__Impl3501); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1697:1: rule__FeatureInstance__Group_6_4__0 : rule__FeatureInstance__Group_6_4__0__Impl rule__FeatureInstance__Group_6_4__1 ;
    public final void rule__FeatureInstance__Group_6_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1701:1: ( rule__FeatureInstance__Group_6_4__0__Impl rule__FeatureInstance__Group_6_4__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1702:2: rule__FeatureInstance__Group_6_4__0__Impl rule__FeatureInstance__Group_6_4__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_6_4__0__Impl_in_rule__FeatureInstance__Group_6_4__03544);
            rule__FeatureInstance__Group_6_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_6_4__1_in_rule__FeatureInstance__Group_6_4__03547);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1709:1: rule__FeatureInstance__Group_6_4__0__Impl : ( ',' ) ;
    public final void rule__FeatureInstance__Group_6_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1713:1: ( ( ',' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1714:1: ( ',' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1714:1: ( ',' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1715:1: ','
            {
             before(grammarAccess.getFeatureInstanceAccess().getCommaKeyword_6_4_0()); 
            match(input,47,FOLLOW_47_in_rule__FeatureInstance__Group_6_4__0__Impl3575); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1728:1: rule__FeatureInstance__Group_6_4__1 : rule__FeatureInstance__Group_6_4__1__Impl ;
    public final void rule__FeatureInstance__Group_6_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1732:1: ( rule__FeatureInstance__Group_6_4__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1733:2: rule__FeatureInstance__Group_6_4__1__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_6_4__1__Impl_in_rule__FeatureInstance__Group_6_4__13606);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1739:1: rule__FeatureInstance__Group_6_4__1__Impl : ( ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1 ) ) ;
    public final void rule__FeatureInstance__Group_6_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1743:1: ( ( ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1744:1: ( ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1744:1: ( ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1745:1: ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceAssignment_6_4_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1746:1: ( rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1746:2: rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1_in_rule__FeatureInstance__Group_6_4__1__Impl3633);
            rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1();

            state._fsp--;


            }

             after(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceAssignment_6_4_1()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1760:1: rule__FeatureInstance__Group_7__0 : rule__FeatureInstance__Group_7__0__Impl rule__FeatureInstance__Group_7__1 ;
    public final void rule__FeatureInstance__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1764:1: ( rule__FeatureInstance__Group_7__0__Impl rule__FeatureInstance__Group_7__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1765:2: rule__FeatureInstance__Group_7__0__Impl rule__FeatureInstance__Group_7__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_7__0__Impl_in_rule__FeatureInstance__Group_7__03667);
            rule__FeatureInstance__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_7__1_in_rule__FeatureInstance__Group_7__03670);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1772:1: rule__FeatureInstance__Group_7__0__Impl : ( 'destination' ) ;
    public final void rule__FeatureInstance__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1776:1: ( ( 'destination' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1777:1: ( 'destination' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1777:1: ( 'destination' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1778:1: 'destination'
            {
             before(grammarAccess.getFeatureInstanceAccess().getDestinationKeyword_7_0()); 
            match(input,48,FOLLOW_48_in_rule__FeatureInstance__Group_7__0__Impl3698); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1791:1: rule__FeatureInstance__Group_7__1 : rule__FeatureInstance__Group_7__1__Impl rule__FeatureInstance__Group_7__2 ;
    public final void rule__FeatureInstance__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1795:1: ( rule__FeatureInstance__Group_7__1__Impl rule__FeatureInstance__Group_7__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1796:2: rule__FeatureInstance__Group_7__1__Impl rule__FeatureInstance__Group_7__2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_7__1__Impl_in_rule__FeatureInstance__Group_7__13729);
            rule__FeatureInstance__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_7__2_in_rule__FeatureInstance__Group_7__13732);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1803:1: rule__FeatureInstance__Group_7__1__Impl : ( 'of' ) ;
    public final void rule__FeatureInstance__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1807:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1808:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1808:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1809:1: 'of'
            {
             before(grammarAccess.getFeatureInstanceAccess().getOfKeyword_7_1()); 
            match(input,44,FOLLOW_44_in_rule__FeatureInstance__Group_7__1__Impl3760); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1822:1: rule__FeatureInstance__Group_7__2 : rule__FeatureInstance__Group_7__2__Impl rule__FeatureInstance__Group_7__3 ;
    public final void rule__FeatureInstance__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1826:1: ( rule__FeatureInstance__Group_7__2__Impl rule__FeatureInstance__Group_7__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1827:2: rule__FeatureInstance__Group_7__2__Impl rule__FeatureInstance__Group_7__3
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_7__2__Impl_in_rule__FeatureInstance__Group_7__23791);
            rule__FeatureInstance__Group_7__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_7__3_in_rule__FeatureInstance__Group_7__23794);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1834:1: rule__FeatureInstance__Group_7__2__Impl : ( '(' ) ;
    public final void rule__FeatureInstance__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1838:1: ( ( '(' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1839:1: ( '(' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1839:1: ( '(' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1840:1: '('
            {
             before(grammarAccess.getFeatureInstanceAccess().getLeftParenthesisKeyword_7_2()); 
            match(input,45,FOLLOW_45_in_rule__FeatureInstance__Group_7__2__Impl3822); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1853:1: rule__FeatureInstance__Group_7__3 : rule__FeatureInstance__Group_7__3__Impl rule__FeatureInstance__Group_7__4 ;
    public final void rule__FeatureInstance__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1857:1: ( rule__FeatureInstance__Group_7__3__Impl rule__FeatureInstance__Group_7__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1858:2: rule__FeatureInstance__Group_7__3__Impl rule__FeatureInstance__Group_7__4
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_7__3__Impl_in_rule__FeatureInstance__Group_7__33853);
            rule__FeatureInstance__Group_7__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_7__4_in_rule__FeatureInstance__Group_7__33856);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1865:1: rule__FeatureInstance__Group_7__3__Impl : ( ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_3 ) ) ;
    public final void rule__FeatureInstance__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1869:1: ( ( ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_3 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1870:1: ( ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_3 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1870:1: ( ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_3 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1871:1: ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_3 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceAssignment_7_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1872:1: ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1872:2: rule__FeatureInstance__DstConnectionInstanceAssignment_7_3
            {
            pushFollow(FOLLOW_rule__FeatureInstance__DstConnectionInstanceAssignment_7_3_in_rule__FeatureInstance__Group_7__3__Impl3883);
            rule__FeatureInstance__DstConnectionInstanceAssignment_7_3();

            state._fsp--;


            }

             after(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceAssignment_7_3()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1882:1: rule__FeatureInstance__Group_7__4 : rule__FeatureInstance__Group_7__4__Impl rule__FeatureInstance__Group_7__5 ;
    public final void rule__FeatureInstance__Group_7__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1886:1: ( rule__FeatureInstance__Group_7__4__Impl rule__FeatureInstance__Group_7__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1887:2: rule__FeatureInstance__Group_7__4__Impl rule__FeatureInstance__Group_7__5
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_7__4__Impl_in_rule__FeatureInstance__Group_7__43913);
            rule__FeatureInstance__Group_7__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_7__5_in_rule__FeatureInstance__Group_7__43916);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1894:1: rule__FeatureInstance__Group_7__4__Impl : ( ( rule__FeatureInstance__Group_7_4__0 )* ) ;
    public final void rule__FeatureInstance__Group_7__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1898:1: ( ( ( rule__FeatureInstance__Group_7_4__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1899:1: ( ( rule__FeatureInstance__Group_7_4__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1899:1: ( ( rule__FeatureInstance__Group_7_4__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1900:1: ( rule__FeatureInstance__Group_7_4__0 )*
            {
             before(grammarAccess.getFeatureInstanceAccess().getGroup_7_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1901:1: ( rule__FeatureInstance__Group_7_4__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==47) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1901:2: rule__FeatureInstance__Group_7_4__0
            	    {
            	    pushFollow(FOLLOW_rule__FeatureInstance__Group_7_4__0_in_rule__FeatureInstance__Group_7__4__Impl3943);
            	    rule__FeatureInstance__Group_7_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1911:1: rule__FeatureInstance__Group_7__5 : rule__FeatureInstance__Group_7__5__Impl ;
    public final void rule__FeatureInstance__Group_7__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1915:1: ( rule__FeatureInstance__Group_7__5__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1916:2: rule__FeatureInstance__Group_7__5__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_7__5__Impl_in_rule__FeatureInstance__Group_7__53974);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1922:1: rule__FeatureInstance__Group_7__5__Impl : ( ')' ) ;
    public final void rule__FeatureInstance__Group_7__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1926:1: ( ( ')' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1927:1: ( ')' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1927:1: ( ')' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1928:1: ')'
            {
             before(grammarAccess.getFeatureInstanceAccess().getRightParenthesisKeyword_7_5()); 
            match(input,46,FOLLOW_46_in_rule__FeatureInstance__Group_7__5__Impl4002); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1953:1: rule__FeatureInstance__Group_7_4__0 : rule__FeatureInstance__Group_7_4__0__Impl rule__FeatureInstance__Group_7_4__1 ;
    public final void rule__FeatureInstance__Group_7_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1957:1: ( rule__FeatureInstance__Group_7_4__0__Impl rule__FeatureInstance__Group_7_4__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1958:2: rule__FeatureInstance__Group_7_4__0__Impl rule__FeatureInstance__Group_7_4__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_7_4__0__Impl_in_rule__FeatureInstance__Group_7_4__04045);
            rule__FeatureInstance__Group_7_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_7_4__1_in_rule__FeatureInstance__Group_7_4__04048);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1965:1: rule__FeatureInstance__Group_7_4__0__Impl : ( ',' ) ;
    public final void rule__FeatureInstance__Group_7_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1969:1: ( ( ',' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1970:1: ( ',' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1970:1: ( ',' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1971:1: ','
            {
             before(grammarAccess.getFeatureInstanceAccess().getCommaKeyword_7_4_0()); 
            match(input,47,FOLLOW_47_in_rule__FeatureInstance__Group_7_4__0__Impl4076); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1984:1: rule__FeatureInstance__Group_7_4__1 : rule__FeatureInstance__Group_7_4__1__Impl ;
    public final void rule__FeatureInstance__Group_7_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1988:1: ( rule__FeatureInstance__Group_7_4__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1989:2: rule__FeatureInstance__Group_7_4__1__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_7_4__1__Impl_in_rule__FeatureInstance__Group_7_4__14107);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1995:1: rule__FeatureInstance__Group_7_4__1__Impl : ( ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1 ) ) ;
    public final void rule__FeatureInstance__Group_7_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1999:1: ( ( ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2000:1: ( ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2000:1: ( ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2001:1: ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceAssignment_7_4_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2002:1: ( rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2002:2: rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1_in_rule__FeatureInstance__Group_7_4__1__Impl4134);
            rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1();

            state._fsp--;


            }

             after(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceAssignment_7_4_1()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2016:1: rule__FeatureInstance__Group_8__0 : rule__FeatureInstance__Group_8__0__Impl rule__FeatureInstance__Group_8__1 ;
    public final void rule__FeatureInstance__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2020:1: ( rule__FeatureInstance__Group_8__0__Impl rule__FeatureInstance__Group_8__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2021:2: rule__FeatureInstance__Group_8__0__Impl rule__FeatureInstance__Group_8__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_8__0__Impl_in_rule__FeatureInstance__Group_8__04168);
            rule__FeatureInstance__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_8__1_in_rule__FeatureInstance__Group_8__04171);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2028:1: rule__FeatureInstance__Group_8__0__Impl : ( '{' ) ;
    public final void rule__FeatureInstance__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2032:1: ( ( '{' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2033:1: ( '{' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2033:1: ( '{' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2034:1: '{'
            {
             before(grammarAccess.getFeatureInstanceAccess().getLeftCurlyBracketKeyword_8_0()); 
            match(input,39,FOLLOW_39_in_rule__FeatureInstance__Group_8__0__Impl4199); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2047:1: rule__FeatureInstance__Group_8__1 : rule__FeatureInstance__Group_8__1__Impl rule__FeatureInstance__Group_8__2 ;
    public final void rule__FeatureInstance__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2051:1: ( rule__FeatureInstance__Group_8__1__Impl rule__FeatureInstance__Group_8__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2052:2: rule__FeatureInstance__Group_8__1__Impl rule__FeatureInstance__Group_8__2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_8__1__Impl_in_rule__FeatureInstance__Group_8__14230);
            rule__FeatureInstance__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_8__2_in_rule__FeatureInstance__Group_8__14233);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2059:1: rule__FeatureInstance__Group_8__1__Impl : ( ( rule__FeatureInstance__FeatureInstanceAssignment_8_1 )* ) ;
    public final void rule__FeatureInstance__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2063:1: ( ( ( rule__FeatureInstance__FeatureInstanceAssignment_8_1 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2064:1: ( ( rule__FeatureInstance__FeatureInstanceAssignment_8_1 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2064:1: ( ( rule__FeatureInstance__FeatureInstanceAssignment_8_1 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2065:1: ( rule__FeatureInstance__FeatureInstanceAssignment_8_1 )*
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceAssignment_8_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2066:1: ( rule__FeatureInstance__FeatureInstanceAssignment_8_1 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=10 && LA16_0<=11)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2066:2: rule__FeatureInstance__FeatureInstanceAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_rule__FeatureInstance__FeatureInstanceAssignment_8_1_in_rule__FeatureInstance__Group_8__1__Impl4260);
            	    rule__FeatureInstance__FeatureInstanceAssignment_8_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2076:1: rule__FeatureInstance__Group_8__2 : rule__FeatureInstance__Group_8__2__Impl ;
    public final void rule__FeatureInstance__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2080:1: ( rule__FeatureInstance__Group_8__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2081:2: rule__FeatureInstance__Group_8__2__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_8__2__Impl_in_rule__FeatureInstance__Group_8__24291);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2087:1: rule__FeatureInstance__Group_8__2__Impl : ( '}' ) ;
    public final void rule__FeatureInstance__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2091:1: ( ( '}' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2092:1: ( '}' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2092:1: ( '}' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2093:1: '}'
            {
             before(grammarAccess.getFeatureInstanceAccess().getRightCurlyBracketKeyword_8_2()); 
            match(input,40,FOLLOW_40_in_rule__FeatureInstance__Group_8__2__Impl4319); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2112:1: rule__ComponentInstance__Group__0 : rule__ComponentInstance__Group__0__Impl rule__ComponentInstance__Group__1 ;
    public final void rule__ComponentInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2116:1: ( rule__ComponentInstance__Group__0__Impl rule__ComponentInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2117:2: rule__ComponentInstance__Group__0__Impl rule__ComponentInstance__Group__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__0__Impl_in_rule__ComponentInstance__Group__04356);
            rule__ComponentInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__1_in_rule__ComponentInstance__Group__04359);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2124:1: rule__ComponentInstance__Group__0__Impl : ( ( rule__ComponentInstance__CategoryAssignment_0 ) ) ;
    public final void rule__ComponentInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2128:1: ( ( ( rule__ComponentInstance__CategoryAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2129:1: ( ( rule__ComponentInstance__CategoryAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2129:1: ( ( rule__ComponentInstance__CategoryAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2130:1: ( rule__ComponentInstance__CategoryAssignment_0 )
            {
             before(grammarAccess.getComponentInstanceAccess().getCategoryAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2131:1: ( rule__ComponentInstance__CategoryAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2131:2: rule__ComponentInstance__CategoryAssignment_0
            {
            pushFollow(FOLLOW_rule__ComponentInstance__CategoryAssignment_0_in_rule__ComponentInstance__Group__0__Impl4386);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2141:1: rule__ComponentInstance__Group__1 : rule__ComponentInstance__Group__1__Impl rule__ComponentInstance__Group__2 ;
    public final void rule__ComponentInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2145:1: ( rule__ComponentInstance__Group__1__Impl rule__ComponentInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2146:2: rule__ComponentInstance__Group__1__Impl rule__ComponentInstance__Group__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__1__Impl_in_rule__ComponentInstance__Group__14416);
            rule__ComponentInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__2_in_rule__ComponentInstance__Group__14419);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2153:1: rule__ComponentInstance__Group__1__Impl : ( ( rule__ComponentInstance__NameAssignment_1 ) ) ;
    public final void rule__ComponentInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2157:1: ( ( ( rule__ComponentInstance__NameAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2158:1: ( ( rule__ComponentInstance__NameAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2158:1: ( ( rule__ComponentInstance__NameAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2159:1: ( rule__ComponentInstance__NameAssignment_1 )
            {
             before(grammarAccess.getComponentInstanceAccess().getNameAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2160:1: ( rule__ComponentInstance__NameAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2160:2: rule__ComponentInstance__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__NameAssignment_1_in_rule__ComponentInstance__Group__1__Impl4446);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2170:1: rule__ComponentInstance__Group__2 : rule__ComponentInstance__Group__2__Impl rule__ComponentInstance__Group__3 ;
    public final void rule__ComponentInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2174:1: ( rule__ComponentInstance__Group__2__Impl rule__ComponentInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2175:2: rule__ComponentInstance__Group__2__Impl rule__ComponentInstance__Group__3
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__2__Impl_in_rule__ComponentInstance__Group__24476);
            rule__ComponentInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__3_in_rule__ComponentInstance__Group__24479);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2182:1: rule__ComponentInstance__Group__2__Impl : ( ( rule__ComponentInstance__Group_2__0 )* ) ;
    public final void rule__ComponentInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2186:1: ( ( ( rule__ComponentInstance__Group_2__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2187:1: ( ( rule__ComponentInstance__Group_2__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2187:1: ( ( rule__ComponentInstance__Group_2__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2188:1: ( rule__ComponentInstance__Group_2__0 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2189:1: ( rule__ComponentInstance__Group_2__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==41) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2189:2: rule__ComponentInstance__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__Group_2__0_in_rule__ComponentInstance__Group__2__Impl4506);
            	    rule__ComponentInstance__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2199:1: rule__ComponentInstance__Group__3 : rule__ComponentInstance__Group__3__Impl rule__ComponentInstance__Group__4 ;
    public final void rule__ComponentInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2203:1: ( rule__ComponentInstance__Group__3__Impl rule__ComponentInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2204:2: rule__ComponentInstance__Group__3__Impl rule__ComponentInstance__Group__4
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__3__Impl_in_rule__ComponentInstance__Group__34537);
            rule__ComponentInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__4_in_rule__ComponentInstance__Group__34540);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2211:1: rule__ComponentInstance__Group__3__Impl : ( ':' ) ;
    public final void rule__ComponentInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2215:1: ( ( ':' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2216:1: ( ':' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2216:1: ( ':' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2217:1: ':'
            {
             before(grammarAccess.getComponentInstanceAccess().getColonKeyword_3()); 
            match(input,38,FOLLOW_38_in_rule__ComponentInstance__Group__3__Impl4568); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2230:1: rule__ComponentInstance__Group__4 : rule__ComponentInstance__Group__4__Impl rule__ComponentInstance__Group__5 ;
    public final void rule__ComponentInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2234:1: ( rule__ComponentInstance__Group__4__Impl rule__ComponentInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2235:2: rule__ComponentInstance__Group__4__Impl rule__ComponentInstance__Group__5
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__4__Impl_in_rule__ComponentInstance__Group__44599);
            rule__ComponentInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__5_in_rule__ComponentInstance__Group__44602);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2242:1: rule__ComponentInstance__Group__4__Impl : ( ( rule__ComponentInstance__SubcomponentAssignment_4 ) ) ;
    public final void rule__ComponentInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2246:1: ( ( ( rule__ComponentInstance__SubcomponentAssignment_4 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2247:1: ( ( rule__ComponentInstance__SubcomponentAssignment_4 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2247:1: ( ( rule__ComponentInstance__SubcomponentAssignment_4 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2248:1: ( rule__ComponentInstance__SubcomponentAssignment_4 )
            {
             before(grammarAccess.getComponentInstanceAccess().getSubcomponentAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2249:1: ( rule__ComponentInstance__SubcomponentAssignment_4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2249:2: rule__ComponentInstance__SubcomponentAssignment_4
            {
            pushFollow(FOLLOW_rule__ComponentInstance__SubcomponentAssignment_4_in_rule__ComponentInstance__Group__4__Impl4629);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2259:1: rule__ComponentInstance__Group__5 : rule__ComponentInstance__Group__5__Impl rule__ComponentInstance__Group__6 ;
    public final void rule__ComponentInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2263:1: ( rule__ComponentInstance__Group__5__Impl rule__ComponentInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2264:2: rule__ComponentInstance__Group__5__Impl rule__ComponentInstance__Group__6
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__5__Impl_in_rule__ComponentInstance__Group__54659);
            rule__ComponentInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__6_in_rule__ComponentInstance__Group__54662);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2271:1: rule__ComponentInstance__Group__5__Impl : ( ( rule__ComponentInstance__Group_5__0 )? ) ;
    public final void rule__ComponentInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2275:1: ( ( ( rule__ComponentInstance__Group_5__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2276:1: ( ( rule__ComponentInstance__Group_5__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2276:1: ( ( rule__ComponentInstance__Group_5__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2277:1: ( rule__ComponentInstance__Group_5__0 )?
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2278:1: ( rule__ComponentInstance__Group_5__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==43) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2278:2: rule__ComponentInstance__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__Group_5__0_in_rule__ComponentInstance__Group__5__Impl4689);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2288:1: rule__ComponentInstance__Group__6 : rule__ComponentInstance__Group__6__Impl rule__ComponentInstance__Group__7 ;
    public final void rule__ComponentInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2292:1: ( rule__ComponentInstance__Group__6__Impl rule__ComponentInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2293:2: rule__ComponentInstance__Group__6__Impl rule__ComponentInstance__Group__7
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__6__Impl_in_rule__ComponentInstance__Group__64720);
            rule__ComponentInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__7_in_rule__ComponentInstance__Group__64723);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2300:1: rule__ComponentInstance__Group__6__Impl : ( ( rule__ComponentInstance__Group_6__0 )? ) ;
    public final void rule__ComponentInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2304:1: ( ( ( rule__ComponentInstance__Group_6__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2305:1: ( ( rule__ComponentInstance__Group_6__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2305:1: ( ( rule__ComponentInstance__Group_6__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2306:1: ( rule__ComponentInstance__Group_6__0 )?
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2307:1: ( rule__ComponentInstance__Group_6__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==48) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2307:2: rule__ComponentInstance__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__Group_6__0_in_rule__ComponentInstance__Group__6__Impl4750);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2317:1: rule__ComponentInstance__Group__7 : rule__ComponentInstance__Group__7__Impl ;
    public final void rule__ComponentInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2321:1: ( rule__ComponentInstance__Group__7__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2322:2: rule__ComponentInstance__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__7__Impl_in_rule__ComponentInstance__Group__74781);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2328:1: rule__ComponentInstance__Group__7__Impl : ( ( rule__ComponentInstance__Group_7__0 )? ) ;
    public final void rule__ComponentInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2332:1: ( ( ( rule__ComponentInstance__Group_7__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2333:1: ( ( rule__ComponentInstance__Group_7__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2333:1: ( ( rule__ComponentInstance__Group_7__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2334:1: ( rule__ComponentInstance__Group_7__0 )?
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup_7()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2335:1: ( rule__ComponentInstance__Group_7__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==39) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2335:2: rule__ComponentInstance__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__Group_7__0_in_rule__ComponentInstance__Group__7__Impl4808);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2361:1: rule__ComponentInstance__Group_2__0 : rule__ComponentInstance__Group_2__0__Impl rule__ComponentInstance__Group_2__1 ;
    public final void rule__ComponentInstance__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2365:1: ( rule__ComponentInstance__Group_2__0__Impl rule__ComponentInstance__Group_2__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2366:2: rule__ComponentInstance__Group_2__0__Impl rule__ComponentInstance__Group_2__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_2__0__Impl_in_rule__ComponentInstance__Group_2__04855);
            rule__ComponentInstance__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_2__1_in_rule__ComponentInstance__Group_2__04858);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2373:1: rule__ComponentInstance__Group_2__0__Impl : ( '[' ) ;
    public final void rule__ComponentInstance__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2377:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2378:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2378:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2379:1: '['
            {
             before(grammarAccess.getComponentInstanceAccess().getLeftSquareBracketKeyword_2_0()); 
            match(input,41,FOLLOW_41_in_rule__ComponentInstance__Group_2__0__Impl4886); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2392:1: rule__ComponentInstance__Group_2__1 : rule__ComponentInstance__Group_2__1__Impl rule__ComponentInstance__Group_2__2 ;
    public final void rule__ComponentInstance__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2396:1: ( rule__ComponentInstance__Group_2__1__Impl rule__ComponentInstance__Group_2__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2397:2: rule__ComponentInstance__Group_2__1__Impl rule__ComponentInstance__Group_2__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_2__1__Impl_in_rule__ComponentInstance__Group_2__14917);
            rule__ComponentInstance__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_2__2_in_rule__ComponentInstance__Group_2__14920);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2404:1: rule__ComponentInstance__Group_2__1__Impl : ( ( rule__ComponentInstance__IndexAssignment_2_1 ) ) ;
    public final void rule__ComponentInstance__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2408:1: ( ( ( rule__ComponentInstance__IndexAssignment_2_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2409:1: ( ( rule__ComponentInstance__IndexAssignment_2_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2409:1: ( ( rule__ComponentInstance__IndexAssignment_2_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2410:1: ( rule__ComponentInstance__IndexAssignment_2_1 )
            {
             before(grammarAccess.getComponentInstanceAccess().getIndexAssignment_2_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2411:1: ( rule__ComponentInstance__IndexAssignment_2_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2411:2: rule__ComponentInstance__IndexAssignment_2_1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__IndexAssignment_2_1_in_rule__ComponentInstance__Group_2__1__Impl4947);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2421:1: rule__ComponentInstance__Group_2__2 : rule__ComponentInstance__Group_2__2__Impl ;
    public final void rule__ComponentInstance__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2425:1: ( rule__ComponentInstance__Group_2__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2426:2: rule__ComponentInstance__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_2__2__Impl_in_rule__ComponentInstance__Group_2__24977);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2432:1: rule__ComponentInstance__Group_2__2__Impl : ( ']' ) ;
    public final void rule__ComponentInstance__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2436:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2437:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2437:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2438:1: ']'
            {
             before(grammarAccess.getComponentInstanceAccess().getRightSquareBracketKeyword_2_2()); 
            match(input,42,FOLLOW_42_in_rule__ComponentInstance__Group_2__2__Impl5005); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2457:1: rule__ComponentInstance__Group_5__0 : rule__ComponentInstance__Group_5__0__Impl rule__ComponentInstance__Group_5__1 ;
    public final void rule__ComponentInstance__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2461:1: ( rule__ComponentInstance__Group_5__0__Impl rule__ComponentInstance__Group_5__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2462:2: rule__ComponentInstance__Group_5__0__Impl rule__ComponentInstance__Group_5__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__0__Impl_in_rule__ComponentInstance__Group_5__05042);
            rule__ComponentInstance__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__1_in_rule__ComponentInstance__Group_5__05045);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2469:1: rule__ComponentInstance__Group_5__0__Impl : ( 'source' ) ;
    public final void rule__ComponentInstance__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2473:1: ( ( 'source' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2474:1: ( 'source' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2474:1: ( 'source' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2475:1: 'source'
            {
             before(grammarAccess.getComponentInstanceAccess().getSourceKeyword_5_0()); 
            match(input,43,FOLLOW_43_in_rule__ComponentInstance__Group_5__0__Impl5073); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2488:1: rule__ComponentInstance__Group_5__1 : rule__ComponentInstance__Group_5__1__Impl rule__ComponentInstance__Group_5__2 ;
    public final void rule__ComponentInstance__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2492:1: ( rule__ComponentInstance__Group_5__1__Impl rule__ComponentInstance__Group_5__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2493:2: rule__ComponentInstance__Group_5__1__Impl rule__ComponentInstance__Group_5__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__1__Impl_in_rule__ComponentInstance__Group_5__15104);
            rule__ComponentInstance__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__2_in_rule__ComponentInstance__Group_5__15107);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2500:1: rule__ComponentInstance__Group_5__1__Impl : ( 'of' ) ;
    public final void rule__ComponentInstance__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2504:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2505:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2505:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2506:1: 'of'
            {
             before(grammarAccess.getComponentInstanceAccess().getOfKeyword_5_1()); 
            match(input,44,FOLLOW_44_in_rule__ComponentInstance__Group_5__1__Impl5135); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2519:1: rule__ComponentInstance__Group_5__2 : rule__ComponentInstance__Group_5__2__Impl rule__ComponentInstance__Group_5__3 ;
    public final void rule__ComponentInstance__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2523:1: ( rule__ComponentInstance__Group_5__2__Impl rule__ComponentInstance__Group_5__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2524:2: rule__ComponentInstance__Group_5__2__Impl rule__ComponentInstance__Group_5__3
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__2__Impl_in_rule__ComponentInstance__Group_5__25166);
            rule__ComponentInstance__Group_5__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__3_in_rule__ComponentInstance__Group_5__25169);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2531:1: rule__ComponentInstance__Group_5__2__Impl : ( '(' ) ;
    public final void rule__ComponentInstance__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2535:1: ( ( '(' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2536:1: ( '(' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2536:1: ( '(' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2537:1: '('
            {
             before(grammarAccess.getComponentInstanceAccess().getLeftParenthesisKeyword_5_2()); 
            match(input,45,FOLLOW_45_in_rule__ComponentInstance__Group_5__2__Impl5197); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2550:1: rule__ComponentInstance__Group_5__3 : rule__ComponentInstance__Group_5__3__Impl rule__ComponentInstance__Group_5__4 ;
    public final void rule__ComponentInstance__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2554:1: ( rule__ComponentInstance__Group_5__3__Impl rule__ComponentInstance__Group_5__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2555:2: rule__ComponentInstance__Group_5__3__Impl rule__ComponentInstance__Group_5__4
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__3__Impl_in_rule__ComponentInstance__Group_5__35228);
            rule__ComponentInstance__Group_5__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__4_in_rule__ComponentInstance__Group_5__35231);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2562:1: rule__ComponentInstance__Group_5__3__Impl : ( ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3 ) ) ;
    public final void rule__ComponentInstance__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2566:1: ( ( ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2567:1: ( ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2567:1: ( ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2568:1: ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3 )
            {
             before(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceAssignment_5_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2569:1: ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2569:2: rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3
            {
            pushFollow(FOLLOW_rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3_in_rule__ComponentInstance__Group_5__3__Impl5258);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2579:1: rule__ComponentInstance__Group_5__4 : rule__ComponentInstance__Group_5__4__Impl rule__ComponentInstance__Group_5__5 ;
    public final void rule__ComponentInstance__Group_5__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2583:1: ( rule__ComponentInstance__Group_5__4__Impl rule__ComponentInstance__Group_5__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2584:2: rule__ComponentInstance__Group_5__4__Impl rule__ComponentInstance__Group_5__5
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__4__Impl_in_rule__ComponentInstance__Group_5__45288);
            rule__ComponentInstance__Group_5__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__5_in_rule__ComponentInstance__Group_5__45291);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2591:1: rule__ComponentInstance__Group_5__4__Impl : ( ( rule__ComponentInstance__Group_5_4__0 )* ) ;
    public final void rule__ComponentInstance__Group_5__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2595:1: ( ( ( rule__ComponentInstance__Group_5_4__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2596:1: ( ( rule__ComponentInstance__Group_5_4__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2596:1: ( ( rule__ComponentInstance__Group_5_4__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2597:1: ( rule__ComponentInstance__Group_5_4__0 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup_5_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2598:1: ( rule__ComponentInstance__Group_5_4__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==47) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2598:2: rule__ComponentInstance__Group_5_4__0
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__Group_5_4__0_in_rule__ComponentInstance__Group_5__4__Impl5318);
            	    rule__ComponentInstance__Group_5_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2608:1: rule__ComponentInstance__Group_5__5 : rule__ComponentInstance__Group_5__5__Impl ;
    public final void rule__ComponentInstance__Group_5__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2612:1: ( rule__ComponentInstance__Group_5__5__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2613:2: rule__ComponentInstance__Group_5__5__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__5__Impl_in_rule__ComponentInstance__Group_5__55349);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2619:1: rule__ComponentInstance__Group_5__5__Impl : ( ')' ) ;
    public final void rule__ComponentInstance__Group_5__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2623:1: ( ( ')' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2624:1: ( ')' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2624:1: ( ')' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2625:1: ')'
            {
             before(grammarAccess.getComponentInstanceAccess().getRightParenthesisKeyword_5_5()); 
            match(input,46,FOLLOW_46_in_rule__ComponentInstance__Group_5__5__Impl5377); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2650:1: rule__ComponentInstance__Group_5_4__0 : rule__ComponentInstance__Group_5_4__0__Impl rule__ComponentInstance__Group_5_4__1 ;
    public final void rule__ComponentInstance__Group_5_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2654:1: ( rule__ComponentInstance__Group_5_4__0__Impl rule__ComponentInstance__Group_5_4__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2655:2: rule__ComponentInstance__Group_5_4__0__Impl rule__ComponentInstance__Group_5_4__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_5_4__0__Impl_in_rule__ComponentInstance__Group_5_4__05420);
            rule__ComponentInstance__Group_5_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_5_4__1_in_rule__ComponentInstance__Group_5_4__05423);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2662:1: rule__ComponentInstance__Group_5_4__0__Impl : ( ',' ) ;
    public final void rule__ComponentInstance__Group_5_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2666:1: ( ( ',' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2667:1: ( ',' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2667:1: ( ',' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2668:1: ','
            {
             before(grammarAccess.getComponentInstanceAccess().getCommaKeyword_5_4_0()); 
            match(input,47,FOLLOW_47_in_rule__ComponentInstance__Group_5_4__0__Impl5451); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2681:1: rule__ComponentInstance__Group_5_4__1 : rule__ComponentInstance__Group_5_4__1__Impl ;
    public final void rule__ComponentInstance__Group_5_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2685:1: ( rule__ComponentInstance__Group_5_4__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2686:2: rule__ComponentInstance__Group_5_4__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_5_4__1__Impl_in_rule__ComponentInstance__Group_5_4__15482);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2692:1: rule__ComponentInstance__Group_5_4__1__Impl : ( ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1 ) ) ;
    public final void rule__ComponentInstance__Group_5_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2696:1: ( ( ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2697:1: ( ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2697:1: ( ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2698:1: ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1 )
            {
             before(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceAssignment_5_4_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2699:1: ( rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2699:2: rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1_in_rule__ComponentInstance__Group_5_4__1__Impl5509);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2713:1: rule__ComponentInstance__Group_6__0 : rule__ComponentInstance__Group_6__0__Impl rule__ComponentInstance__Group_6__1 ;
    public final void rule__ComponentInstance__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2717:1: ( rule__ComponentInstance__Group_6__0__Impl rule__ComponentInstance__Group_6__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2718:2: rule__ComponentInstance__Group_6__0__Impl rule__ComponentInstance__Group_6__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_6__0__Impl_in_rule__ComponentInstance__Group_6__05543);
            rule__ComponentInstance__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_6__1_in_rule__ComponentInstance__Group_6__05546);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2725:1: rule__ComponentInstance__Group_6__0__Impl : ( 'destination' ) ;
    public final void rule__ComponentInstance__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2729:1: ( ( 'destination' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2730:1: ( 'destination' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2730:1: ( 'destination' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2731:1: 'destination'
            {
             before(grammarAccess.getComponentInstanceAccess().getDestinationKeyword_6_0()); 
            match(input,48,FOLLOW_48_in_rule__ComponentInstance__Group_6__0__Impl5574); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2744:1: rule__ComponentInstance__Group_6__1 : rule__ComponentInstance__Group_6__1__Impl rule__ComponentInstance__Group_6__2 ;
    public final void rule__ComponentInstance__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2748:1: ( rule__ComponentInstance__Group_6__1__Impl rule__ComponentInstance__Group_6__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2749:2: rule__ComponentInstance__Group_6__1__Impl rule__ComponentInstance__Group_6__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_6__1__Impl_in_rule__ComponentInstance__Group_6__15605);
            rule__ComponentInstance__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_6__2_in_rule__ComponentInstance__Group_6__15608);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2756:1: rule__ComponentInstance__Group_6__1__Impl : ( 'of' ) ;
    public final void rule__ComponentInstance__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2760:1: ( ( 'of' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2761:1: ( 'of' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2761:1: ( 'of' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2762:1: 'of'
            {
             before(grammarAccess.getComponentInstanceAccess().getOfKeyword_6_1()); 
            match(input,44,FOLLOW_44_in_rule__ComponentInstance__Group_6__1__Impl5636); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2775:1: rule__ComponentInstance__Group_6__2 : rule__ComponentInstance__Group_6__2__Impl rule__ComponentInstance__Group_6__3 ;
    public final void rule__ComponentInstance__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2779:1: ( rule__ComponentInstance__Group_6__2__Impl rule__ComponentInstance__Group_6__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2780:2: rule__ComponentInstance__Group_6__2__Impl rule__ComponentInstance__Group_6__3
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_6__2__Impl_in_rule__ComponentInstance__Group_6__25667);
            rule__ComponentInstance__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_6__3_in_rule__ComponentInstance__Group_6__25670);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2787:1: rule__ComponentInstance__Group_6__2__Impl : ( '(' ) ;
    public final void rule__ComponentInstance__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2791:1: ( ( '(' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2792:1: ( '(' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2792:1: ( '(' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2793:1: '('
            {
             before(grammarAccess.getComponentInstanceAccess().getLeftParenthesisKeyword_6_2()); 
            match(input,45,FOLLOW_45_in_rule__ComponentInstance__Group_6__2__Impl5698); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2806:1: rule__ComponentInstance__Group_6__3 : rule__ComponentInstance__Group_6__3__Impl rule__ComponentInstance__Group_6__4 ;
    public final void rule__ComponentInstance__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2810:1: ( rule__ComponentInstance__Group_6__3__Impl rule__ComponentInstance__Group_6__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2811:2: rule__ComponentInstance__Group_6__3__Impl rule__ComponentInstance__Group_6__4
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_6__3__Impl_in_rule__ComponentInstance__Group_6__35729);
            rule__ComponentInstance__Group_6__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_6__4_in_rule__ComponentInstance__Group_6__35732);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2818:1: rule__ComponentInstance__Group_6__3__Impl : ( ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_3 ) ) ;
    public final void rule__ComponentInstance__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2822:1: ( ( ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_3 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2823:1: ( ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_3 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2823:1: ( ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_3 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2824:1: ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_3 )
            {
             before(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceAssignment_6_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2825:1: ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2825:2: rule__ComponentInstance__DstConnectionInstanceAssignment_6_3
            {
            pushFollow(FOLLOW_rule__ComponentInstance__DstConnectionInstanceAssignment_6_3_in_rule__ComponentInstance__Group_6__3__Impl5759);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2835:1: rule__ComponentInstance__Group_6__4 : rule__ComponentInstance__Group_6__4__Impl rule__ComponentInstance__Group_6__5 ;
    public final void rule__ComponentInstance__Group_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2839:1: ( rule__ComponentInstance__Group_6__4__Impl rule__ComponentInstance__Group_6__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2840:2: rule__ComponentInstance__Group_6__4__Impl rule__ComponentInstance__Group_6__5
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_6__4__Impl_in_rule__ComponentInstance__Group_6__45789);
            rule__ComponentInstance__Group_6__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_6__5_in_rule__ComponentInstance__Group_6__45792);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2847:1: rule__ComponentInstance__Group_6__4__Impl : ( ( rule__ComponentInstance__Group_6_4__0 )* ) ;
    public final void rule__ComponentInstance__Group_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2851:1: ( ( ( rule__ComponentInstance__Group_6_4__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2852:1: ( ( rule__ComponentInstance__Group_6_4__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2852:1: ( ( rule__ComponentInstance__Group_6_4__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2853:1: ( rule__ComponentInstance__Group_6_4__0 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup_6_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2854:1: ( rule__ComponentInstance__Group_6_4__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==47) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2854:2: rule__ComponentInstance__Group_6_4__0
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__Group_6_4__0_in_rule__ComponentInstance__Group_6__4__Impl5819);
            	    rule__ComponentInstance__Group_6_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2864:1: rule__ComponentInstance__Group_6__5 : rule__ComponentInstance__Group_6__5__Impl ;
    public final void rule__ComponentInstance__Group_6__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2868:1: ( rule__ComponentInstance__Group_6__5__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2869:2: rule__ComponentInstance__Group_6__5__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_6__5__Impl_in_rule__ComponentInstance__Group_6__55850);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2875:1: rule__ComponentInstance__Group_6__5__Impl : ( ')' ) ;
    public final void rule__ComponentInstance__Group_6__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2879:1: ( ( ')' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2880:1: ( ')' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2880:1: ( ')' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2881:1: ')'
            {
             before(grammarAccess.getComponentInstanceAccess().getRightParenthesisKeyword_6_5()); 
            match(input,46,FOLLOW_46_in_rule__ComponentInstance__Group_6__5__Impl5878); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2906:1: rule__ComponentInstance__Group_6_4__0 : rule__ComponentInstance__Group_6_4__0__Impl rule__ComponentInstance__Group_6_4__1 ;
    public final void rule__ComponentInstance__Group_6_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2910:1: ( rule__ComponentInstance__Group_6_4__0__Impl rule__ComponentInstance__Group_6_4__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2911:2: rule__ComponentInstance__Group_6_4__0__Impl rule__ComponentInstance__Group_6_4__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_6_4__0__Impl_in_rule__ComponentInstance__Group_6_4__05921);
            rule__ComponentInstance__Group_6_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_6_4__1_in_rule__ComponentInstance__Group_6_4__05924);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2918:1: rule__ComponentInstance__Group_6_4__0__Impl : ( ',' ) ;
    public final void rule__ComponentInstance__Group_6_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2922:1: ( ( ',' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2923:1: ( ',' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2923:1: ( ',' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2924:1: ','
            {
             before(grammarAccess.getComponentInstanceAccess().getCommaKeyword_6_4_0()); 
            match(input,47,FOLLOW_47_in_rule__ComponentInstance__Group_6_4__0__Impl5952); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2937:1: rule__ComponentInstance__Group_6_4__1 : rule__ComponentInstance__Group_6_4__1__Impl ;
    public final void rule__ComponentInstance__Group_6_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2941:1: ( rule__ComponentInstance__Group_6_4__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2942:2: rule__ComponentInstance__Group_6_4__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_6_4__1__Impl_in_rule__ComponentInstance__Group_6_4__15983);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2948:1: rule__ComponentInstance__Group_6_4__1__Impl : ( ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1 ) ) ;
    public final void rule__ComponentInstance__Group_6_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2952:1: ( ( ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2953:1: ( ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2953:1: ( ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2954:1: ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1 )
            {
             before(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceAssignment_6_4_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2955:1: ( rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2955:2: rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1_in_rule__ComponentInstance__Group_6_4__1__Impl6010);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2969:1: rule__ComponentInstance__Group_7__0 : rule__ComponentInstance__Group_7__0__Impl rule__ComponentInstance__Group_7__1 ;
    public final void rule__ComponentInstance__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2973:1: ( rule__ComponentInstance__Group_7__0__Impl rule__ComponentInstance__Group_7__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2974:2: rule__ComponentInstance__Group_7__0__Impl rule__ComponentInstance__Group_7__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_7__0__Impl_in_rule__ComponentInstance__Group_7__06044);
            rule__ComponentInstance__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_7__1_in_rule__ComponentInstance__Group_7__06047);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2981:1: rule__ComponentInstance__Group_7__0__Impl : ( '{' ) ;
    public final void rule__ComponentInstance__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2985:1: ( ( '{' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2986:1: ( '{' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2986:1: ( '{' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2987:1: '{'
            {
             before(grammarAccess.getComponentInstanceAccess().getLeftCurlyBracketKeyword_7_0()); 
            match(input,39,FOLLOW_39_in_rule__ComponentInstance__Group_7__0__Impl6075); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3000:1: rule__ComponentInstance__Group_7__1 : rule__ComponentInstance__Group_7__1__Impl rule__ComponentInstance__Group_7__2 ;
    public final void rule__ComponentInstance__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3004:1: ( rule__ComponentInstance__Group_7__1__Impl rule__ComponentInstance__Group_7__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3005:2: rule__ComponentInstance__Group_7__1__Impl rule__ComponentInstance__Group_7__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_7__1__Impl_in_rule__ComponentInstance__Group_7__16106);
            rule__ComponentInstance__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_7__2_in_rule__ComponentInstance__Group_7__16109);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3012:1: rule__ComponentInstance__Group_7__1__Impl : ( ( rule__ComponentInstance__Alternatives_7_1 )* ) ;
    public final void rule__ComponentInstance__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3016:1: ( ( ( rule__ComponentInstance__Alternatives_7_1 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3017:1: ( ( rule__ComponentInstance__Alternatives_7_1 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3017:1: ( ( rule__ComponentInstance__Alternatives_7_1 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3018:1: ( rule__ComponentInstance__Alternatives_7_1 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getAlternatives_7_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3019:1: ( rule__ComponentInstance__Alternatives_7_1 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=10 && LA23_0<=11)||(LA23_0>=21 && LA23_0<=36)||LA23_0==51||LA23_0==54) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3019:2: rule__ComponentInstance__Alternatives_7_1
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__Alternatives_7_1_in_rule__ComponentInstance__Group_7__1__Impl6136);
            	    rule__ComponentInstance__Alternatives_7_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3029:1: rule__ComponentInstance__Group_7__2 : rule__ComponentInstance__Group_7__2__Impl ;
    public final void rule__ComponentInstance__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3033:1: ( rule__ComponentInstance__Group_7__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3034:2: rule__ComponentInstance__Group_7__2__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_7__2__Impl_in_rule__ComponentInstance__Group_7__26167);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3040:1: rule__ComponentInstance__Group_7__2__Impl : ( '}' ) ;
    public final void rule__ComponentInstance__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3044:1: ( ( '}' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3045:1: ( '}' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3045:1: ( '}' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3046:1: '}'
            {
             before(grammarAccess.getComponentInstanceAccess().getRightCurlyBracketKeyword_7_2()); 
            match(input,40,FOLLOW_40_in_rule__ComponentInstance__Group_7__2__Impl6195); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3065:1: rule__ConnectionInstance__Group__0 : rule__ConnectionInstance__Group__0__Impl rule__ConnectionInstance__Group__1 ;
    public final void rule__ConnectionInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3069:1: ( rule__ConnectionInstance__Group__0__Impl rule__ConnectionInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3070:2: rule__ConnectionInstance__Group__0__Impl rule__ConnectionInstance__Group__1
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__0__Impl_in_rule__ConnectionInstance__Group__06232);
            rule__ConnectionInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__1_in_rule__ConnectionInstance__Group__06235);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3077:1: rule__ConnectionInstance__Group__0__Impl : ( ( rule__ConnectionInstance__CompleteAssignment_0 )? ) ;
    public final void rule__ConnectionInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3081:1: ( ( ( rule__ConnectionInstance__CompleteAssignment_0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3082:1: ( ( rule__ConnectionInstance__CompleteAssignment_0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3082:1: ( ( rule__ConnectionInstance__CompleteAssignment_0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3083:1: ( rule__ConnectionInstance__CompleteAssignment_0 )?
            {
             before(grammarAccess.getConnectionInstanceAccess().getCompleteAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3084:1: ( rule__ConnectionInstance__CompleteAssignment_0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==54) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3084:2: rule__ConnectionInstance__CompleteAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ConnectionInstance__CompleteAssignment_0_in_rule__ConnectionInstance__Group__0__Impl6262);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3094:1: rule__ConnectionInstance__Group__1 : rule__ConnectionInstance__Group__1__Impl rule__ConnectionInstance__Group__2 ;
    public final void rule__ConnectionInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3098:1: ( rule__ConnectionInstance__Group__1__Impl rule__ConnectionInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3099:2: rule__ConnectionInstance__Group__1__Impl rule__ConnectionInstance__Group__2
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__1__Impl_in_rule__ConnectionInstance__Group__16293);
            rule__ConnectionInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__2_in_rule__ConnectionInstance__Group__16296);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3106:1: rule__ConnectionInstance__Group__1__Impl : ( ( rule__ConnectionInstance__KindAssignment_1 ) ) ;
    public final void rule__ConnectionInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3110:1: ( ( ( rule__ConnectionInstance__KindAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3111:1: ( ( rule__ConnectionInstance__KindAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3111:1: ( ( rule__ConnectionInstance__KindAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3112:1: ( rule__ConnectionInstance__KindAssignment_1 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getKindAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3113:1: ( rule__ConnectionInstance__KindAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3113:2: rule__ConnectionInstance__KindAssignment_1
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__KindAssignment_1_in_rule__ConnectionInstance__Group__1__Impl6323);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3123:1: rule__ConnectionInstance__Group__2 : rule__ConnectionInstance__Group__2__Impl rule__ConnectionInstance__Group__3 ;
    public final void rule__ConnectionInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3127:1: ( rule__ConnectionInstance__Group__2__Impl rule__ConnectionInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3128:2: rule__ConnectionInstance__Group__2__Impl rule__ConnectionInstance__Group__3
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__2__Impl_in_rule__ConnectionInstance__Group__26353);
            rule__ConnectionInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__3_in_rule__ConnectionInstance__Group__26356);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3135:1: rule__ConnectionInstance__Group__2__Impl : ( ( rule__ConnectionInstance__NameAssignment_2 ) ) ;
    public final void rule__ConnectionInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3139:1: ( ( ( rule__ConnectionInstance__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3140:1: ( ( rule__ConnectionInstance__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3140:1: ( ( rule__ConnectionInstance__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3141:1: ( rule__ConnectionInstance__NameAssignment_2 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3142:1: ( rule__ConnectionInstance__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3142:2: rule__ConnectionInstance__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__NameAssignment_2_in_rule__ConnectionInstance__Group__2__Impl6383);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3152:1: rule__ConnectionInstance__Group__3 : rule__ConnectionInstance__Group__3__Impl rule__ConnectionInstance__Group__4 ;
    public final void rule__ConnectionInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3156:1: ( rule__ConnectionInstance__Group__3__Impl rule__ConnectionInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3157:2: rule__ConnectionInstance__Group__3__Impl rule__ConnectionInstance__Group__4
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__3__Impl_in_rule__ConnectionInstance__Group__36413);
            rule__ConnectionInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__4_in_rule__ConnectionInstance__Group__36416);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3164:1: rule__ConnectionInstance__Group__3__Impl : ( ':' ) ;
    public final void rule__ConnectionInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3168:1: ( ( ':' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3169:1: ( ':' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3169:1: ( ':' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3170:1: ':'
            {
             before(grammarAccess.getConnectionInstanceAccess().getColonKeyword_3()); 
            match(input,38,FOLLOW_38_in_rule__ConnectionInstance__Group__3__Impl6444); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3183:1: rule__ConnectionInstance__Group__4 : rule__ConnectionInstance__Group__4__Impl rule__ConnectionInstance__Group__5 ;
    public final void rule__ConnectionInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3187:1: ( rule__ConnectionInstance__Group__4__Impl rule__ConnectionInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3188:2: rule__ConnectionInstance__Group__4__Impl rule__ConnectionInstance__Group__5
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__4__Impl_in_rule__ConnectionInstance__Group__46475);
            rule__ConnectionInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__5_in_rule__ConnectionInstance__Group__46478);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3195:1: rule__ConnectionInstance__Group__4__Impl : ( ( rule__ConnectionInstance__SourceAssignment_4 ) ) ;
    public final void rule__ConnectionInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3199:1: ( ( ( rule__ConnectionInstance__SourceAssignment_4 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3200:1: ( ( rule__ConnectionInstance__SourceAssignment_4 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3200:1: ( ( rule__ConnectionInstance__SourceAssignment_4 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3201:1: ( rule__ConnectionInstance__SourceAssignment_4 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getSourceAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3202:1: ( rule__ConnectionInstance__SourceAssignment_4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3202:2: rule__ConnectionInstance__SourceAssignment_4
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__SourceAssignment_4_in_rule__ConnectionInstance__Group__4__Impl6505);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3212:1: rule__ConnectionInstance__Group__5 : rule__ConnectionInstance__Group__5__Impl rule__ConnectionInstance__Group__6 ;
    public final void rule__ConnectionInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3216:1: ( rule__ConnectionInstance__Group__5__Impl rule__ConnectionInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3217:2: rule__ConnectionInstance__Group__5__Impl rule__ConnectionInstance__Group__6
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__5__Impl_in_rule__ConnectionInstance__Group__56535);
            rule__ConnectionInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__6_in_rule__ConnectionInstance__Group__56538);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3224:1: rule__ConnectionInstance__Group__5__Impl : ( ( rule__ConnectionInstance__Alternatives_5 ) ) ;
    public final void rule__ConnectionInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3228:1: ( ( ( rule__ConnectionInstance__Alternatives_5 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3229:1: ( ( rule__ConnectionInstance__Alternatives_5 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3229:1: ( ( rule__ConnectionInstance__Alternatives_5 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3230:1: ( rule__ConnectionInstance__Alternatives_5 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getAlternatives_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3231:1: ( rule__ConnectionInstance__Alternatives_5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3231:2: rule__ConnectionInstance__Alternatives_5
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Alternatives_5_in_rule__ConnectionInstance__Group__5__Impl6565);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3241:1: rule__ConnectionInstance__Group__6 : rule__ConnectionInstance__Group__6__Impl rule__ConnectionInstance__Group__7 ;
    public final void rule__ConnectionInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3245:1: ( rule__ConnectionInstance__Group__6__Impl rule__ConnectionInstance__Group__7 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3246:2: rule__ConnectionInstance__Group__6__Impl rule__ConnectionInstance__Group__7
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__6__Impl_in_rule__ConnectionInstance__Group__66595);
            rule__ConnectionInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__7_in_rule__ConnectionInstance__Group__66598);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3253:1: rule__ConnectionInstance__Group__6__Impl : ( ( rule__ConnectionInstance__DestinationAssignment_6 ) ) ;
    public final void rule__ConnectionInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3257:1: ( ( ( rule__ConnectionInstance__DestinationAssignment_6 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3258:1: ( ( rule__ConnectionInstance__DestinationAssignment_6 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3258:1: ( ( rule__ConnectionInstance__DestinationAssignment_6 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3259:1: ( rule__ConnectionInstance__DestinationAssignment_6 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getDestinationAssignment_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3260:1: ( rule__ConnectionInstance__DestinationAssignment_6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3260:2: rule__ConnectionInstance__DestinationAssignment_6
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__DestinationAssignment_6_in_rule__ConnectionInstance__Group__6__Impl6625);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3270:1: rule__ConnectionInstance__Group__7 : rule__ConnectionInstance__Group__7__Impl rule__ConnectionInstance__Group__8 ;
    public final void rule__ConnectionInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3274:1: ( rule__ConnectionInstance__Group__7__Impl rule__ConnectionInstance__Group__8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3275:2: rule__ConnectionInstance__Group__7__Impl rule__ConnectionInstance__Group__8
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__7__Impl_in_rule__ConnectionInstance__Group__76655);
            rule__ConnectionInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__8_in_rule__ConnectionInstance__Group__76658);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3282:1: rule__ConnectionInstance__Group__7__Impl : ( '{' ) ;
    public final void rule__ConnectionInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3286:1: ( ( '{' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3287:1: ( '{' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3287:1: ( '{' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3288:1: '{'
            {
             before(grammarAccess.getConnectionInstanceAccess().getLeftCurlyBracketKeyword_7()); 
            match(input,39,FOLLOW_39_in_rule__ConnectionInstance__Group__7__Impl6686); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3301:1: rule__ConnectionInstance__Group__8 : rule__ConnectionInstance__Group__8__Impl rule__ConnectionInstance__Group__9 ;
    public final void rule__ConnectionInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3305:1: ( rule__ConnectionInstance__Group__8__Impl rule__ConnectionInstance__Group__9 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3306:2: rule__ConnectionInstance__Group__8__Impl rule__ConnectionInstance__Group__9
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__8__Impl_in_rule__ConnectionInstance__Group__86717);
            rule__ConnectionInstance__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionInstance__Group__9_in_rule__ConnectionInstance__Group__86720);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3313:1: rule__ConnectionInstance__Group__8__Impl : ( ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 )* ) ) ;
    public final void rule__ConnectionInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3317:1: ( ( ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3318:1: ( ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3318:1: ( ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3319:1: ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 ) ) ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3319:1: ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3320:1: ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 )
            {
             before(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceAssignment_8()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3321:1: ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3321:2: rule__ConnectionInstance__ConnectionReferenceAssignment_8
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__ConnectionReferenceAssignment_8_in_rule__ConnectionInstance__Group__8__Impl6749);
            rule__ConnectionInstance__ConnectionReferenceAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceAssignment_8()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3324:1: ( ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3325:1: ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 )*
            {
             before(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceAssignment_8()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3326:1: ( rule__ConnectionInstance__ConnectionReferenceAssignment_8 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ID) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3326:2: rule__ConnectionInstance__ConnectionReferenceAssignment_8
            	    {
            	    pushFollow(FOLLOW_rule__ConnectionInstance__ConnectionReferenceAssignment_8_in_rule__ConnectionInstance__Group__8__Impl6761);
            	    rule__ConnectionInstance__ConnectionReferenceAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3337:1: rule__ConnectionInstance__Group__9 : rule__ConnectionInstance__Group__9__Impl ;
    public final void rule__ConnectionInstance__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3341:1: ( rule__ConnectionInstance__Group__9__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3342:2: rule__ConnectionInstance__Group__9__Impl
            {
            pushFollow(FOLLOW_rule__ConnectionInstance__Group__9__Impl_in_rule__ConnectionInstance__Group__96794);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3348:1: rule__ConnectionInstance__Group__9__Impl : ( '}' ) ;
    public final void rule__ConnectionInstance__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3352:1: ( ( '}' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3353:1: ( '}' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3353:1: ( '}' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3354:1: '}'
            {
             before(grammarAccess.getConnectionInstanceAccess().getRightCurlyBracketKeyword_9()); 
            match(input,40,FOLLOW_40_in_rule__ConnectionInstance__Group__9__Impl6822); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3387:1: rule__ConnectionReference__Group__0 : rule__ConnectionReference__Group__0__Impl rule__ConnectionReference__Group__1 ;
    public final void rule__ConnectionReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3391:1: ( rule__ConnectionReference__Group__0__Impl rule__ConnectionReference__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3392:2: rule__ConnectionReference__Group__0__Impl rule__ConnectionReference__Group__1
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__0__Impl_in_rule__ConnectionReference__Group__06873);
            rule__ConnectionReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__1_in_rule__ConnectionReference__Group__06876);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3399:1: rule__ConnectionReference__Group__0__Impl : ( ( rule__ConnectionReference__SourceAssignment_0 ) ) ;
    public final void rule__ConnectionReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3403:1: ( ( ( rule__ConnectionReference__SourceAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3404:1: ( ( rule__ConnectionReference__SourceAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3404:1: ( ( rule__ConnectionReference__SourceAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3405:1: ( rule__ConnectionReference__SourceAssignment_0 )
            {
             before(grammarAccess.getConnectionReferenceAccess().getSourceAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3406:1: ( rule__ConnectionReference__SourceAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3406:2: rule__ConnectionReference__SourceAssignment_0
            {
            pushFollow(FOLLOW_rule__ConnectionReference__SourceAssignment_0_in_rule__ConnectionReference__Group__0__Impl6903);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3416:1: rule__ConnectionReference__Group__1 : rule__ConnectionReference__Group__1__Impl rule__ConnectionReference__Group__2 ;
    public final void rule__ConnectionReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3420:1: ( rule__ConnectionReference__Group__1__Impl rule__ConnectionReference__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3421:2: rule__ConnectionReference__Group__1__Impl rule__ConnectionReference__Group__2
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__1__Impl_in_rule__ConnectionReference__Group__16933);
            rule__ConnectionReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__2_in_rule__ConnectionReference__Group__16936);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3428:1: rule__ConnectionReference__Group__1__Impl : ( '->' ) ;
    public final void rule__ConnectionReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3432:1: ( ( '->' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3433:1: ( '->' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3433:1: ( '->' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3434:1: '->'
            {
             before(grammarAccess.getConnectionReferenceAccess().getHyphenMinusGreaterThanSignKeyword_1()); 
            match(input,9,FOLLOW_9_in_rule__ConnectionReference__Group__1__Impl6964); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3447:1: rule__ConnectionReference__Group__2 : rule__ConnectionReference__Group__2__Impl rule__ConnectionReference__Group__3 ;
    public final void rule__ConnectionReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3451:1: ( rule__ConnectionReference__Group__2__Impl rule__ConnectionReference__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3452:2: rule__ConnectionReference__Group__2__Impl rule__ConnectionReference__Group__3
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__2__Impl_in_rule__ConnectionReference__Group__26995);
            rule__ConnectionReference__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__3_in_rule__ConnectionReference__Group__26998);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3459:1: rule__ConnectionReference__Group__2__Impl : ( ( rule__ConnectionReference__DestinationAssignment_2 ) ) ;
    public final void rule__ConnectionReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3463:1: ( ( ( rule__ConnectionReference__DestinationAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3464:1: ( ( rule__ConnectionReference__DestinationAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3464:1: ( ( rule__ConnectionReference__DestinationAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3465:1: ( rule__ConnectionReference__DestinationAssignment_2 )
            {
             before(grammarAccess.getConnectionReferenceAccess().getDestinationAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3466:1: ( rule__ConnectionReference__DestinationAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3466:2: rule__ConnectionReference__DestinationAssignment_2
            {
            pushFollow(FOLLOW_rule__ConnectionReference__DestinationAssignment_2_in_rule__ConnectionReference__Group__2__Impl7025);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3476:1: rule__ConnectionReference__Group__3 : rule__ConnectionReference__Group__3__Impl rule__ConnectionReference__Group__4 ;
    public final void rule__ConnectionReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3480:1: ( rule__ConnectionReference__Group__3__Impl rule__ConnectionReference__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3481:2: rule__ConnectionReference__Group__3__Impl rule__ConnectionReference__Group__4
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__3__Impl_in_rule__ConnectionReference__Group__37055);
            rule__ConnectionReference__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__4_in_rule__ConnectionReference__Group__37058);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3488:1: rule__ConnectionReference__Group__3__Impl : ( ':' ) ;
    public final void rule__ConnectionReference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3492:1: ( ( ':' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3493:1: ( ':' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3493:1: ( ':' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3494:1: ':'
            {
             before(grammarAccess.getConnectionReferenceAccess().getColonKeyword_3()); 
            match(input,38,FOLLOW_38_in_rule__ConnectionReference__Group__3__Impl7086); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3507:1: rule__ConnectionReference__Group__4 : rule__ConnectionReference__Group__4__Impl rule__ConnectionReference__Group__5 ;
    public final void rule__ConnectionReference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3511:1: ( rule__ConnectionReference__Group__4__Impl rule__ConnectionReference__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3512:2: rule__ConnectionReference__Group__4__Impl rule__ConnectionReference__Group__5
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__4__Impl_in_rule__ConnectionReference__Group__47117);
            rule__ConnectionReference__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__5_in_rule__ConnectionReference__Group__47120);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3519:1: rule__ConnectionReference__Group__4__Impl : ( ( rule__ConnectionReference__ConnectionAssignment_4 ) ) ;
    public final void rule__ConnectionReference__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3523:1: ( ( ( rule__ConnectionReference__ConnectionAssignment_4 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3524:1: ( ( rule__ConnectionReference__ConnectionAssignment_4 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3524:1: ( ( rule__ConnectionReference__ConnectionAssignment_4 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3525:1: ( rule__ConnectionReference__ConnectionAssignment_4 )
            {
             before(grammarAccess.getConnectionReferenceAccess().getConnectionAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3526:1: ( rule__ConnectionReference__ConnectionAssignment_4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3526:2: rule__ConnectionReference__ConnectionAssignment_4
            {
            pushFollow(FOLLOW_rule__ConnectionReference__ConnectionAssignment_4_in_rule__ConnectionReference__Group__4__Impl7147);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3536:1: rule__ConnectionReference__Group__5 : rule__ConnectionReference__Group__5__Impl rule__ConnectionReference__Group__6 ;
    public final void rule__ConnectionReference__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3540:1: ( rule__ConnectionReference__Group__5__Impl rule__ConnectionReference__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3541:2: rule__ConnectionReference__Group__5__Impl rule__ConnectionReference__Group__6
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__5__Impl_in_rule__ConnectionReference__Group__57177);
            rule__ConnectionReference__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionReference__Group__6_in_rule__ConnectionReference__Group__57180);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3548:1: rule__ConnectionReference__Group__5__Impl : ( 'in' ) ;
    public final void rule__ConnectionReference__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3552:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3553:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3553:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3554:1: 'in'
            {
             before(grammarAccess.getConnectionReferenceAccess().getInKeyword_5()); 
            match(input,10,FOLLOW_10_in_rule__ConnectionReference__Group__5__Impl7208); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3567:1: rule__ConnectionReference__Group__6 : rule__ConnectionReference__Group__6__Impl ;
    public final void rule__ConnectionReference__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3571:1: ( rule__ConnectionReference__Group__6__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3572:2: rule__ConnectionReference__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ConnectionReference__Group__6__Impl_in_rule__ConnectionReference__Group__67239);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3578:1: rule__ConnectionReference__Group__6__Impl : ( ( rule__ConnectionReference__ContextAssignment_6 ) ) ;
    public final void rule__ConnectionReference__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3582:1: ( ( ( rule__ConnectionReference__ContextAssignment_6 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3583:1: ( ( rule__ConnectionReference__ContextAssignment_6 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3583:1: ( ( rule__ConnectionReference__ContextAssignment_6 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3584:1: ( rule__ConnectionReference__ContextAssignment_6 )
            {
             before(grammarAccess.getConnectionReferenceAccess().getContextAssignment_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3585:1: ( rule__ConnectionReference__ContextAssignment_6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3585:2: rule__ConnectionReference__ContextAssignment_6
            {
            pushFollow(FOLLOW_rule__ConnectionReference__ContextAssignment_6_in_rule__ConnectionReference__Group__6__Impl7266);
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


    // $ANTLR start "rule__SystemOperationMode__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3609:1: rule__SystemOperationMode__Group__0 : rule__SystemOperationMode__Group__0__Impl rule__SystemOperationMode__Group__1 ;
    public final void rule__SystemOperationMode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3613:1: ( rule__SystemOperationMode__Group__0__Impl rule__SystemOperationMode__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3614:2: rule__SystemOperationMode__Group__0__Impl rule__SystemOperationMode__Group__1
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__Group__0__Impl_in_rule__SystemOperationMode__Group__07310);
            rule__SystemOperationMode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemOperationMode__Group__1_in_rule__SystemOperationMode__Group__07313);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3621:1: rule__SystemOperationMode__Group__0__Impl : ( 'som' ) ;
    public final void rule__SystemOperationMode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3625:1: ( ( 'som' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3626:1: ( 'som' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3626:1: ( 'som' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3627:1: 'som'
            {
             before(grammarAccess.getSystemOperationModeAccess().getSomKeyword_0()); 
            match(input,49,FOLLOW_49_in_rule__SystemOperationMode__Group__0__Impl7341); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3640:1: rule__SystemOperationMode__Group__1 : rule__SystemOperationMode__Group__1__Impl ;
    public final void rule__SystemOperationMode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3644:1: ( rule__SystemOperationMode__Group__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3645:2: rule__SystemOperationMode__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__Group__1__Impl_in_rule__SystemOperationMode__Group__17372);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3651:1: rule__SystemOperationMode__Group__1__Impl : ( ( rule__SystemOperationMode__NameAssignment_1 ) ) ;
    public final void rule__SystemOperationMode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3655:1: ( ( ( rule__SystemOperationMode__NameAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3656:1: ( ( rule__SystemOperationMode__NameAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3656:1: ( ( rule__SystemOperationMode__NameAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3657:1: ( rule__SystemOperationMode__NameAssignment_1 )
            {
             before(grammarAccess.getSystemOperationModeAccess().getNameAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3658:1: ( rule__SystemOperationMode__NameAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3658:2: rule__SystemOperationMode__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__NameAssignment_1_in_rule__SystemOperationMode__Group__1__Impl7399);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3672:1: rule__DirectionType__Group_2__0 : rule__DirectionType__Group_2__0__Impl rule__DirectionType__Group_2__1 ;
    public final void rule__DirectionType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3676:1: ( rule__DirectionType__Group_2__0__Impl rule__DirectionType__Group_2__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3677:2: rule__DirectionType__Group_2__0__Impl rule__DirectionType__Group_2__1
            {
            pushFollow(FOLLOW_rule__DirectionType__Group_2__0__Impl_in_rule__DirectionType__Group_2__07433);
            rule__DirectionType__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DirectionType__Group_2__1_in_rule__DirectionType__Group_2__07436);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3684:1: rule__DirectionType__Group_2__0__Impl : ( 'in' ) ;
    public final void rule__DirectionType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3688:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3689:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3689:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3690:1: 'in'
            {
             before(grammarAccess.getDirectionTypeAccess().getInKeyword_2_0()); 
            match(input,10,FOLLOW_10_in_rule__DirectionType__Group_2__0__Impl7464); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3703:1: rule__DirectionType__Group_2__1 : rule__DirectionType__Group_2__1__Impl ;
    public final void rule__DirectionType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3707:1: ( rule__DirectionType__Group_2__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3708:2: rule__DirectionType__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__DirectionType__Group_2__1__Impl_in_rule__DirectionType__Group_2__17495);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3714:1: rule__DirectionType__Group_2__1__Impl : ( 'out' ) ;
    public final void rule__DirectionType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3718:1: ( ( 'out' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3719:1: ( 'out' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3719:1: ( 'out' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3720:1: 'out'
            {
             before(grammarAccess.getDirectionTypeAccess().getOutKeyword_2_1()); 
            match(input,11,FOLLOW_11_in_rule__DirectionType__Group_2__1__Impl7523); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3737:1: rule__ComponentCategory__Group_8__0 : rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1 ;
    public final void rule__ComponentCategory__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3741:1: ( rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3742:2: rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_8__0__Impl_in_rule__ComponentCategory__Group_8__07558);
            rule__ComponentCategory__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_8__1_in_rule__ComponentCategory__Group_8__07561);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3749:1: rule__ComponentCategory__Group_8__0__Impl : ( 'subprogram' ) ;
    public final void rule__ComponentCategory__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3753:1: ( ( 'subprogram' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3754:1: ( 'subprogram' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3754:1: ( 'subprogram' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3755:1: 'subprogram'
            {
             before(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
            match(input,28,FOLLOW_28_in_rule__ComponentCategory__Group_8__0__Impl7589); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3768:1: rule__ComponentCategory__Group_8__1 : rule__ComponentCategory__Group_8__1__Impl ;
    public final void rule__ComponentCategory__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3772:1: ( rule__ComponentCategory__Group_8__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3773:2: rule__ComponentCategory__Group_8__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_8__1__Impl_in_rule__ComponentCategory__Group_8__17620);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3779:1: rule__ComponentCategory__Group_8__1__Impl : ( 'group' ) ;
    public final void rule__ComponentCategory__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3783:1: ( ( 'group' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3784:1: ( 'group' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3784:1: ( 'group' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3785:1: 'group'
            {
             before(grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
            match(input,50,FOLLOW_50_in_rule__ComponentCategory__Group_8__1__Impl7648); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3802:1: rule__ComponentCategory__Group_10__0 : rule__ComponentCategory__Group_10__0__Impl rule__ComponentCategory__Group_10__1 ;
    public final void rule__ComponentCategory__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3806:1: ( rule__ComponentCategory__Group_10__0__Impl rule__ComponentCategory__Group_10__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3807:2: rule__ComponentCategory__Group_10__0__Impl rule__ComponentCategory__Group_10__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_10__0__Impl_in_rule__ComponentCategory__Group_10__07683);
            rule__ComponentCategory__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_10__1_in_rule__ComponentCategory__Group_10__07686);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3814:1: rule__ComponentCategory__Group_10__0__Impl : ( 'thread' ) ;
    public final void rule__ComponentCategory__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3818:1: ( ( 'thread' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3819:1: ( 'thread' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3819:1: ( 'thread' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3820:1: 'thread'
            {
             before(grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); 
            match(input,30,FOLLOW_30_in_rule__ComponentCategory__Group_10__0__Impl7714); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3833:1: rule__ComponentCategory__Group_10__1 : rule__ComponentCategory__Group_10__1__Impl ;
    public final void rule__ComponentCategory__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3837:1: ( rule__ComponentCategory__Group_10__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3838:2: rule__ComponentCategory__Group_10__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_10__1__Impl_in_rule__ComponentCategory__Group_10__17745);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3844:1: rule__ComponentCategory__Group_10__1__Impl : ( 'group' ) ;
    public final void rule__ComponentCategory__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3848:1: ( ( 'group' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3849:1: ( 'group' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3849:1: ( 'group' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3850:1: 'group'
            {
             before(grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); 
            match(input,50,FOLLOW_50_in_rule__ComponentCategory__Group_10__1__Impl7773); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3867:1: rule__ComponentCategory__Group_12__0 : rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1 ;
    public final void rule__ComponentCategory__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3871:1: ( rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3872:2: rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_12__0__Impl_in_rule__ComponentCategory__Group_12__07808);
            rule__ComponentCategory__Group_12__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_12__1_in_rule__ComponentCategory__Group_12__07811);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3879:1: rule__ComponentCategory__Group_12__0__Impl : ( 'virtual' ) ;
    public final void rule__ComponentCategory__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3883:1: ( ( 'virtual' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3884:1: ( 'virtual' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3884:1: ( 'virtual' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3885:1: 'virtual'
            {
             before(grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
            match(input,51,FOLLOW_51_in_rule__ComponentCategory__Group_12__0__Impl7839); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3898:1: rule__ComponentCategory__Group_12__1 : rule__ComponentCategory__Group_12__1__Impl ;
    public final void rule__ComponentCategory__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3902:1: ( rule__ComponentCategory__Group_12__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3903:2: rule__ComponentCategory__Group_12__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_12__1__Impl_in_rule__ComponentCategory__Group_12__17870);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3909:1: rule__ComponentCategory__Group_12__1__Impl : ( 'bus' ) ;
    public final void rule__ComponentCategory__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3913:1: ( ( 'bus' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3914:1: ( 'bus' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3914:1: ( 'bus' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3915:1: 'bus'
            {
             before(grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
            match(input,22,FOLLOW_22_in_rule__ComponentCategory__Group_12__1__Impl7898); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3932:1: rule__ComponentCategory__Group_13__0 : rule__ComponentCategory__Group_13__0__Impl rule__ComponentCategory__Group_13__1 ;
    public final void rule__ComponentCategory__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3936:1: ( rule__ComponentCategory__Group_13__0__Impl rule__ComponentCategory__Group_13__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3937:2: rule__ComponentCategory__Group_13__0__Impl rule__ComponentCategory__Group_13__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_13__0__Impl_in_rule__ComponentCategory__Group_13__07933);
            rule__ComponentCategory__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_13__1_in_rule__ComponentCategory__Group_13__07936);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3944:1: rule__ComponentCategory__Group_13__0__Impl : ( 'virtual' ) ;
    public final void rule__ComponentCategory__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3948:1: ( ( 'virtual' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3949:1: ( 'virtual' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3949:1: ( 'virtual' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3950:1: 'virtual'
            {
             before(grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); 
            match(input,51,FOLLOW_51_in_rule__ComponentCategory__Group_13__0__Impl7964); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3963:1: rule__ComponentCategory__Group_13__1 : rule__ComponentCategory__Group_13__1__Impl ;
    public final void rule__ComponentCategory__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3967:1: ( rule__ComponentCategory__Group_13__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3968:2: rule__ComponentCategory__Group_13__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_13__1__Impl_in_rule__ComponentCategory__Group_13__17995);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3974:1: rule__ComponentCategory__Group_13__1__Impl : ( 'processor' ) ;
    public final void rule__ComponentCategory__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3978:1: ( ( 'processor' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3979:1: ( 'processor' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3979:1: ( 'processor' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3980:1: 'processor'
            {
             before(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_13_1()); 
            match(input,27,FOLLOW_27_in_rule__ComponentCategory__Group_13__1__Impl8023); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:3997:1: rule__IMPLREF__Group__0 : rule__IMPLREF__Group__0__Impl rule__IMPLREF__Group__1 ;
    public final void rule__IMPLREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4001:1: ( rule__IMPLREF__Group__0__Impl rule__IMPLREF__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4002:2: rule__IMPLREF__Group__0__Impl rule__IMPLREF__Group__1
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group__0__Impl_in_rule__IMPLREF__Group__08058);
            rule__IMPLREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IMPLREF__Group__1_in_rule__IMPLREF__Group__08061);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4009:1: rule__IMPLREF__Group__0__Impl : ( ( ( rule__IMPLREF__Group_0__0 ) ) ( ( rule__IMPLREF__Group_0__0 )* ) ) ;
    public final void rule__IMPLREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4013:1: ( ( ( ( rule__IMPLREF__Group_0__0 ) ) ( ( rule__IMPLREF__Group_0__0 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4014:1: ( ( ( rule__IMPLREF__Group_0__0 ) ) ( ( rule__IMPLREF__Group_0__0 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4014:1: ( ( ( rule__IMPLREF__Group_0__0 ) ) ( ( rule__IMPLREF__Group_0__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4015:1: ( ( rule__IMPLREF__Group_0__0 ) ) ( ( rule__IMPLREF__Group_0__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4015:1: ( ( rule__IMPLREF__Group_0__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4016:1: ( rule__IMPLREF__Group_0__0 )
            {
             before(grammarAccess.getIMPLREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4017:1: ( rule__IMPLREF__Group_0__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4017:2: rule__IMPLREF__Group_0__0
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group_0__0_in_rule__IMPLREF__Group__0__Impl8090);
            rule__IMPLREF__Group_0__0();

            state._fsp--;


            }

             after(grammarAccess.getIMPLREFAccess().getGroup_0()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4020:1: ( ( rule__IMPLREF__Group_0__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4021:1: ( rule__IMPLREF__Group_0__0 )*
            {
             before(grammarAccess.getIMPLREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4022:1: ( rule__IMPLREF__Group_0__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_ID) ) {
                    int LA26_1 = input.LA(2);

                    if ( (LA26_1==53) ) {
                        alt26=1;
                    }


                }


                switch (alt26) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4022:2: rule__IMPLREF__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__IMPLREF__Group_0__0_in_rule__IMPLREF__Group__0__Impl8102);
            	    rule__IMPLREF__Group_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4033:1: rule__IMPLREF__Group__1 : rule__IMPLREF__Group__1__Impl rule__IMPLREF__Group__2 ;
    public final void rule__IMPLREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4037:1: ( rule__IMPLREF__Group__1__Impl rule__IMPLREF__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4038:2: rule__IMPLREF__Group__1__Impl rule__IMPLREF__Group__2
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group__1__Impl_in_rule__IMPLREF__Group__18135);
            rule__IMPLREF__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IMPLREF__Group__2_in_rule__IMPLREF__Group__18138);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4045:1: rule__IMPLREF__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__IMPLREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4049:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4050:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4050:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4051:1: RULE_ID
            {
             before(grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IMPLREF__Group__1__Impl8165); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4062:1: rule__IMPLREF__Group__2 : rule__IMPLREF__Group__2__Impl rule__IMPLREF__Group__3 ;
    public final void rule__IMPLREF__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4066:1: ( rule__IMPLREF__Group__2__Impl rule__IMPLREF__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4067:2: rule__IMPLREF__Group__2__Impl rule__IMPLREF__Group__3
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group__2__Impl_in_rule__IMPLREF__Group__28194);
            rule__IMPLREF__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IMPLREF__Group__3_in_rule__IMPLREF__Group__28197);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4074:1: rule__IMPLREF__Group__2__Impl : ( '.' ) ;
    public final void rule__IMPLREF__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4078:1: ( ( '.' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4079:1: ( '.' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4079:1: ( '.' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4080:1: '.'
            {
             before(grammarAccess.getIMPLREFAccess().getFullStopKeyword_2()); 
            match(input,52,FOLLOW_52_in_rule__IMPLREF__Group__2__Impl8225); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4093:1: rule__IMPLREF__Group__3 : rule__IMPLREF__Group__3__Impl ;
    public final void rule__IMPLREF__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4097:1: ( rule__IMPLREF__Group__3__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4098:2: rule__IMPLREF__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group__3__Impl_in_rule__IMPLREF__Group__38256);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4104:1: rule__IMPLREF__Group__3__Impl : ( RULE_ID ) ;
    public final void rule__IMPLREF__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4108:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4109:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4109:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4110:1: RULE_ID
            {
             before(grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_3()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IMPLREF__Group__3__Impl8283); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4129:1: rule__IMPLREF__Group_0__0 : rule__IMPLREF__Group_0__0__Impl rule__IMPLREF__Group_0__1 ;
    public final void rule__IMPLREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4133:1: ( rule__IMPLREF__Group_0__0__Impl rule__IMPLREF__Group_0__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4134:2: rule__IMPLREF__Group_0__0__Impl rule__IMPLREF__Group_0__1
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group_0__0__Impl_in_rule__IMPLREF__Group_0__08320);
            rule__IMPLREF__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IMPLREF__Group_0__1_in_rule__IMPLREF__Group_0__08323);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4141:1: rule__IMPLREF__Group_0__0__Impl : ( RULE_ID ) ;
    public final void rule__IMPLREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4145:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4146:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4146:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4147:1: RULE_ID
            {
             before(grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IMPLREF__Group_0__0__Impl8350); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4158:1: rule__IMPLREF__Group_0__1 : rule__IMPLREF__Group_0__1__Impl ;
    public final void rule__IMPLREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4162:1: ( rule__IMPLREF__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4163:2: rule__IMPLREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group_0__1__Impl_in_rule__IMPLREF__Group_0__18379);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4169:1: rule__IMPLREF__Group_0__1__Impl : ( '::' ) ;
    public final void rule__IMPLREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4173:1: ( ( '::' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4174:1: ( '::' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4174:1: ( '::' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4175:1: '::'
            {
             before(grammarAccess.getIMPLREFAccess().getColonColonKeyword_0_1()); 
            match(input,53,FOLLOW_53_in_rule__IMPLREF__Group_0__1__Impl8407); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4192:1: rule__FEATREF__Group__0 : rule__FEATREF__Group__0__Impl rule__FEATREF__Group__1 ;
    public final void rule__FEATREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4196:1: ( rule__FEATREF__Group__0__Impl rule__FEATREF__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4197:2: rule__FEATREF__Group__0__Impl rule__FEATREF__Group__1
            {
            pushFollow(FOLLOW_rule__FEATREF__Group__0__Impl_in_rule__FEATREF__Group__08442);
            rule__FEATREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FEATREF__Group__1_in_rule__FEATREF__Group__08445);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4204:1: rule__FEATREF__Group__0__Impl : ( ( ( rule__FEATREF__Group_0__0 ) ) ( ( rule__FEATREF__Group_0__0 )* ) ) ;
    public final void rule__FEATREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4208:1: ( ( ( ( rule__FEATREF__Group_0__0 ) ) ( ( rule__FEATREF__Group_0__0 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4209:1: ( ( ( rule__FEATREF__Group_0__0 ) ) ( ( rule__FEATREF__Group_0__0 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4209:1: ( ( ( rule__FEATREF__Group_0__0 ) ) ( ( rule__FEATREF__Group_0__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4210:1: ( ( rule__FEATREF__Group_0__0 ) ) ( ( rule__FEATREF__Group_0__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4210:1: ( ( rule__FEATREF__Group_0__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4211:1: ( rule__FEATREF__Group_0__0 )
            {
             before(grammarAccess.getFEATREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4212:1: ( rule__FEATREF__Group_0__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4212:2: rule__FEATREF__Group_0__0
            {
            pushFollow(FOLLOW_rule__FEATREF__Group_0__0_in_rule__FEATREF__Group__0__Impl8474);
            rule__FEATREF__Group_0__0();

            state._fsp--;


            }

             after(grammarAccess.getFEATREFAccess().getGroup_0()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4215:1: ( ( rule__FEATREF__Group_0__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4216:1: ( rule__FEATREF__Group_0__0 )*
            {
             before(grammarAccess.getFEATREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4217:1: ( rule__FEATREF__Group_0__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_ID) ) {
                    int LA27_1 = input.LA(2);

                    if ( (LA27_1==53) ) {
                        int LA27_2 = input.LA(3);

                        if ( (LA27_2==RULE_ID) ) {
                            int LA27_3 = input.LA(4);

                            if ( (LA27_3==53) ) {
                                alt27=1;
                            }


                        }


                    }


                }


                switch (alt27) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4217:2: rule__FEATREF__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__FEATREF__Group_0__0_in_rule__FEATREF__Group__0__Impl8486);
            	    rule__FEATREF__Group_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4228:1: rule__FEATREF__Group__1 : rule__FEATREF__Group__1__Impl rule__FEATREF__Group__2 ;
    public final void rule__FEATREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4232:1: ( rule__FEATREF__Group__1__Impl rule__FEATREF__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4233:2: rule__FEATREF__Group__1__Impl rule__FEATREF__Group__2
            {
            pushFollow(FOLLOW_rule__FEATREF__Group__1__Impl_in_rule__FEATREF__Group__18519);
            rule__FEATREF__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FEATREF__Group__2_in_rule__FEATREF__Group__18522);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4240:1: rule__FEATREF__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__FEATREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4244:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4245:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4245:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4246:1: RULE_ID
            {
             before(grammarAccess.getFEATREFAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FEATREF__Group__1__Impl8549); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4257:1: rule__FEATREF__Group__2 : rule__FEATREF__Group__2__Impl rule__FEATREF__Group__3 ;
    public final void rule__FEATREF__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4261:1: ( rule__FEATREF__Group__2__Impl rule__FEATREF__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4262:2: rule__FEATREF__Group__2__Impl rule__FEATREF__Group__3
            {
            pushFollow(FOLLOW_rule__FEATREF__Group__2__Impl_in_rule__FEATREF__Group__28578);
            rule__FEATREF__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FEATREF__Group__3_in_rule__FEATREF__Group__28581);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4269:1: rule__FEATREF__Group__2__Impl : ( '::' ) ;
    public final void rule__FEATREF__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4273:1: ( ( '::' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4274:1: ( '::' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4274:1: ( '::' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4275:1: '::'
            {
             before(grammarAccess.getFEATREFAccess().getColonColonKeyword_2()); 
            match(input,53,FOLLOW_53_in_rule__FEATREF__Group__2__Impl8609); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4288:1: rule__FEATREF__Group__3 : rule__FEATREF__Group__3__Impl ;
    public final void rule__FEATREF__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4292:1: ( rule__FEATREF__Group__3__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4293:2: rule__FEATREF__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__FEATREF__Group__3__Impl_in_rule__FEATREF__Group__38640);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4299:1: rule__FEATREF__Group__3__Impl : ( RULE_ID ) ;
    public final void rule__FEATREF__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4303:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4304:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4304:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4305:1: RULE_ID
            {
             before(grammarAccess.getFEATREFAccess().getIDTerminalRuleCall_3()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FEATREF__Group__3__Impl8667); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4324:1: rule__FEATREF__Group_0__0 : rule__FEATREF__Group_0__0__Impl rule__FEATREF__Group_0__1 ;
    public final void rule__FEATREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4328:1: ( rule__FEATREF__Group_0__0__Impl rule__FEATREF__Group_0__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4329:2: rule__FEATREF__Group_0__0__Impl rule__FEATREF__Group_0__1
            {
            pushFollow(FOLLOW_rule__FEATREF__Group_0__0__Impl_in_rule__FEATREF__Group_0__08704);
            rule__FEATREF__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FEATREF__Group_0__1_in_rule__FEATREF__Group_0__08707);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4336:1: rule__FEATREF__Group_0__0__Impl : ( RULE_ID ) ;
    public final void rule__FEATREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4340:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4341:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4341:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4342:1: RULE_ID
            {
             before(grammarAccess.getFEATREFAccess().getIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FEATREF__Group_0__0__Impl8734); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4353:1: rule__FEATREF__Group_0__1 : rule__FEATREF__Group_0__1__Impl ;
    public final void rule__FEATREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4357:1: ( rule__FEATREF__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4358:2: rule__FEATREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__FEATREF__Group_0__1__Impl_in_rule__FEATREF__Group_0__18763);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4364:1: rule__FEATREF__Group_0__1__Impl : ( '::' ) ;
    public final void rule__FEATREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4368:1: ( ( '::' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4369:1: ( '::' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4369:1: ( '::' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4370:1: '::'
            {
             before(grammarAccess.getFEATREFAccess().getColonColonKeyword_0_1()); 
            match(input,53,FOLLOW_53_in_rule__FEATREF__Group_0__1__Impl8791); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4387:1: rule__SUBREF__Group__0 : rule__SUBREF__Group__0__Impl rule__SUBREF__Group__1 ;
    public final void rule__SUBREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4391:1: ( rule__SUBREF__Group__0__Impl rule__SUBREF__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4392:2: rule__SUBREF__Group__0__Impl rule__SUBREF__Group__1
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__0__Impl_in_rule__SUBREF__Group__08826);
            rule__SUBREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group__1_in_rule__SUBREF__Group__08829);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4399:1: rule__SUBREF__Group__0__Impl : ( ( ( rule__SUBREF__Group_0__0 ) ) ( ( rule__SUBREF__Group_0__0 )* ) ) ;
    public final void rule__SUBREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4403:1: ( ( ( ( rule__SUBREF__Group_0__0 ) ) ( ( rule__SUBREF__Group_0__0 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4404:1: ( ( ( rule__SUBREF__Group_0__0 ) ) ( ( rule__SUBREF__Group_0__0 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4404:1: ( ( ( rule__SUBREF__Group_0__0 ) ) ( ( rule__SUBREF__Group_0__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4405:1: ( ( rule__SUBREF__Group_0__0 ) ) ( ( rule__SUBREF__Group_0__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4405:1: ( ( rule__SUBREF__Group_0__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4406:1: ( rule__SUBREF__Group_0__0 )
            {
             before(grammarAccess.getSUBREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4407:1: ( rule__SUBREF__Group_0__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4407:2: rule__SUBREF__Group_0__0
            {
            pushFollow(FOLLOW_rule__SUBREF__Group_0__0_in_rule__SUBREF__Group__0__Impl8858);
            rule__SUBREF__Group_0__0();

            state._fsp--;


            }

             after(grammarAccess.getSUBREFAccess().getGroup_0()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4410:1: ( ( rule__SUBREF__Group_0__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4411:1: ( rule__SUBREF__Group_0__0 )*
            {
             before(grammarAccess.getSUBREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4412:1: ( rule__SUBREF__Group_0__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID) ) {
                    int LA28_1 = input.LA(2);

                    if ( (LA28_1==53) ) {
                        alt28=1;
                    }


                }


                switch (alt28) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4412:2: rule__SUBREF__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__SUBREF__Group_0__0_in_rule__SUBREF__Group__0__Impl8870);
            	    rule__SUBREF__Group_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4423:1: rule__SUBREF__Group__1 : rule__SUBREF__Group__1__Impl rule__SUBREF__Group__2 ;
    public final void rule__SUBREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4427:1: ( rule__SUBREF__Group__1__Impl rule__SUBREF__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4428:2: rule__SUBREF__Group__1__Impl rule__SUBREF__Group__2
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__1__Impl_in_rule__SUBREF__Group__18903);
            rule__SUBREF__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group__2_in_rule__SUBREF__Group__18906);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4435:1: rule__SUBREF__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__SUBREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4439:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4440:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4440:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4441:1: RULE_ID
            {
             before(grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SUBREF__Group__1__Impl8933); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4452:1: rule__SUBREF__Group__2 : rule__SUBREF__Group__2__Impl rule__SUBREF__Group__3 ;
    public final void rule__SUBREF__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4456:1: ( rule__SUBREF__Group__2__Impl rule__SUBREF__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4457:2: rule__SUBREF__Group__2__Impl rule__SUBREF__Group__3
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__2__Impl_in_rule__SUBREF__Group__28962);
            rule__SUBREF__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group__3_in_rule__SUBREF__Group__28965);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4464:1: rule__SUBREF__Group__2__Impl : ( '.' ) ;
    public final void rule__SUBREF__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4468:1: ( ( '.' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4469:1: ( '.' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4469:1: ( '.' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4470:1: '.'
            {
             before(grammarAccess.getSUBREFAccess().getFullStopKeyword_2()); 
            match(input,52,FOLLOW_52_in_rule__SUBREF__Group__2__Impl8993); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4483:1: rule__SUBREF__Group__3 : rule__SUBREF__Group__3__Impl rule__SUBREF__Group__4 ;
    public final void rule__SUBREF__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4487:1: ( rule__SUBREF__Group__3__Impl rule__SUBREF__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4488:2: rule__SUBREF__Group__3__Impl rule__SUBREF__Group__4
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__3__Impl_in_rule__SUBREF__Group__39024);
            rule__SUBREF__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group__4_in_rule__SUBREF__Group__39027);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4495:1: rule__SUBREF__Group__3__Impl : ( RULE_ID ) ;
    public final void rule__SUBREF__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4499:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4500:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4500:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4501:1: RULE_ID
            {
             before(grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_3()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SUBREF__Group__3__Impl9054); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4512:1: rule__SUBREF__Group__4 : rule__SUBREF__Group__4__Impl rule__SUBREF__Group__5 ;
    public final void rule__SUBREF__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4516:1: ( rule__SUBREF__Group__4__Impl rule__SUBREF__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4517:2: rule__SUBREF__Group__4__Impl rule__SUBREF__Group__5
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__4__Impl_in_rule__SUBREF__Group__49083);
            rule__SUBREF__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group__5_in_rule__SUBREF__Group__49086);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4524:1: rule__SUBREF__Group__4__Impl : ( '::' ) ;
    public final void rule__SUBREF__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4528:1: ( ( '::' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4529:1: ( '::' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4529:1: ( '::' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4530:1: '::'
            {
             before(grammarAccess.getSUBREFAccess().getColonColonKeyword_4()); 
            match(input,53,FOLLOW_53_in_rule__SUBREF__Group__4__Impl9114); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4543:1: rule__SUBREF__Group__5 : rule__SUBREF__Group__5__Impl ;
    public final void rule__SUBREF__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4547:1: ( rule__SUBREF__Group__5__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4548:2: rule__SUBREF__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__5__Impl_in_rule__SUBREF__Group__59145);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4554:1: rule__SUBREF__Group__5__Impl : ( RULE_ID ) ;
    public final void rule__SUBREF__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4558:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4559:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4559:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4560:1: RULE_ID
            {
             before(grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_5()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SUBREF__Group__5__Impl9172); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4583:1: rule__SUBREF__Group_0__0 : rule__SUBREF__Group_0__0__Impl rule__SUBREF__Group_0__1 ;
    public final void rule__SUBREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4587:1: ( rule__SUBREF__Group_0__0__Impl rule__SUBREF__Group_0__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4588:2: rule__SUBREF__Group_0__0__Impl rule__SUBREF__Group_0__1
            {
            pushFollow(FOLLOW_rule__SUBREF__Group_0__0__Impl_in_rule__SUBREF__Group_0__09213);
            rule__SUBREF__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group_0__1_in_rule__SUBREF__Group_0__09216);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4595:1: rule__SUBREF__Group_0__0__Impl : ( RULE_ID ) ;
    public final void rule__SUBREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4599:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4600:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4600:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4601:1: RULE_ID
            {
             before(grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SUBREF__Group_0__0__Impl9243); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4612:1: rule__SUBREF__Group_0__1 : rule__SUBREF__Group_0__1__Impl ;
    public final void rule__SUBREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4616:1: ( rule__SUBREF__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4617:2: rule__SUBREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__SUBREF__Group_0__1__Impl_in_rule__SUBREF__Group_0__19272);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4623:1: rule__SUBREF__Group_0__1__Impl : ( '::' ) ;
    public final void rule__SUBREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4627:1: ( ( '::' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4628:1: ( '::' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4628:1: ( '::' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4629:1: '::'
            {
             before(grammarAccess.getSUBREFAccess().getColonColonKeyword_0_1()); 
            match(input,53,FOLLOW_53_in_rule__SUBREF__Group_0__1__Impl9300); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4646:1: rule__INSTANCEREF__Group__0 : rule__INSTANCEREF__Group__0__Impl rule__INSTANCEREF__Group__1 ;
    public final void rule__INSTANCEREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4650:1: ( rule__INSTANCEREF__Group__0__Impl rule__INSTANCEREF__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4651:2: rule__INSTANCEREF__Group__0__Impl rule__INSTANCEREF__Group__1
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group__0__Impl_in_rule__INSTANCEREF__Group__09335);
            rule__INSTANCEREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREF__Group__1_in_rule__INSTANCEREF__Group__09338);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4658:1: rule__INSTANCEREF__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__INSTANCEREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4662:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4663:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4663:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4664:1: RULE_ID
            {
             before(grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__INSTANCEREF__Group__0__Impl9365); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4675:1: rule__INSTANCEREF__Group__1 : rule__INSTANCEREF__Group__1__Impl rule__INSTANCEREF__Group__2 ;
    public final void rule__INSTANCEREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4679:1: ( rule__INSTANCEREF__Group__1__Impl rule__INSTANCEREF__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4680:2: rule__INSTANCEREF__Group__1__Impl rule__INSTANCEREF__Group__2
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group__1__Impl_in_rule__INSTANCEREF__Group__19394);
            rule__INSTANCEREF__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREF__Group__2_in_rule__INSTANCEREF__Group__19397);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4687:1: rule__INSTANCEREF__Group__1__Impl : ( ( rule__INSTANCEREF__Group_1__0 )* ) ;
    public final void rule__INSTANCEREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4691:1: ( ( ( rule__INSTANCEREF__Group_1__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4692:1: ( ( rule__INSTANCEREF__Group_1__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4692:1: ( ( rule__INSTANCEREF__Group_1__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4693:1: ( rule__INSTANCEREF__Group_1__0 )*
            {
             before(grammarAccess.getINSTANCEREFAccess().getGroup_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4694:1: ( rule__INSTANCEREF__Group_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==41) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4694:2: rule__INSTANCEREF__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__INSTANCEREF__Group_1__0_in_rule__INSTANCEREF__Group__1__Impl9424);
            	    rule__INSTANCEREF__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4704:1: rule__INSTANCEREF__Group__2 : rule__INSTANCEREF__Group__2__Impl ;
    public final void rule__INSTANCEREF__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4708:1: ( rule__INSTANCEREF__Group__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4709:2: rule__INSTANCEREF__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group__2__Impl_in_rule__INSTANCEREF__Group__29455);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4715:1: rule__INSTANCEREF__Group__2__Impl : ( ( rule__INSTANCEREF__Group_2__0 )* ) ;
    public final void rule__INSTANCEREF__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4719:1: ( ( ( rule__INSTANCEREF__Group_2__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4720:1: ( ( rule__INSTANCEREF__Group_2__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4720:1: ( ( rule__INSTANCEREF__Group_2__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4721:1: ( rule__INSTANCEREF__Group_2__0 )*
            {
             before(grammarAccess.getINSTANCEREFAccess().getGroup_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4722:1: ( rule__INSTANCEREF__Group_2__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==52) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4722:2: rule__INSTANCEREF__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__INSTANCEREF__Group_2__0_in_rule__INSTANCEREF__Group__2__Impl9482);
            	    rule__INSTANCEREF__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4738:1: rule__INSTANCEREF__Group_1__0 : rule__INSTANCEREF__Group_1__0__Impl rule__INSTANCEREF__Group_1__1 ;
    public final void rule__INSTANCEREF__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4742:1: ( rule__INSTANCEREF__Group_1__0__Impl rule__INSTANCEREF__Group_1__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4743:2: rule__INSTANCEREF__Group_1__0__Impl rule__INSTANCEREF__Group_1__1
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_1__0__Impl_in_rule__INSTANCEREF__Group_1__09519);
            rule__INSTANCEREF__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREF__Group_1__1_in_rule__INSTANCEREF__Group_1__09522);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4750:1: rule__INSTANCEREF__Group_1__0__Impl : ( '[' ) ;
    public final void rule__INSTANCEREF__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4754:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4755:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4755:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4756:1: '['
            {
             before(grammarAccess.getINSTANCEREFAccess().getLeftSquareBracketKeyword_1_0()); 
            match(input,41,FOLLOW_41_in_rule__INSTANCEREF__Group_1__0__Impl9550); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4769:1: rule__INSTANCEREF__Group_1__1 : rule__INSTANCEREF__Group_1__1__Impl rule__INSTANCEREF__Group_1__2 ;
    public final void rule__INSTANCEREF__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4773:1: ( rule__INSTANCEREF__Group_1__1__Impl rule__INSTANCEREF__Group_1__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4774:2: rule__INSTANCEREF__Group_1__1__Impl rule__INSTANCEREF__Group_1__2
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_1__1__Impl_in_rule__INSTANCEREF__Group_1__19581);
            rule__INSTANCEREF__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREF__Group_1__2_in_rule__INSTANCEREF__Group_1__19584);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4781:1: rule__INSTANCEREF__Group_1__1__Impl : ( RULE_LONG ) ;
    public final void rule__INSTANCEREF__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4785:1: ( ( RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4786:1: ( RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4786:1: ( RULE_LONG )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4787:1: RULE_LONG
            {
             before(grammarAccess.getINSTANCEREFAccess().getLONGTerminalRuleCall_1_1()); 
            match(input,RULE_LONG,FOLLOW_RULE_LONG_in_rule__INSTANCEREF__Group_1__1__Impl9611); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4798:1: rule__INSTANCEREF__Group_1__2 : rule__INSTANCEREF__Group_1__2__Impl ;
    public final void rule__INSTANCEREF__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4802:1: ( rule__INSTANCEREF__Group_1__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4803:2: rule__INSTANCEREF__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_1__2__Impl_in_rule__INSTANCEREF__Group_1__29640);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4809:1: rule__INSTANCEREF__Group_1__2__Impl : ( ']' ) ;
    public final void rule__INSTANCEREF__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4813:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4814:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4814:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4815:1: ']'
            {
             before(grammarAccess.getINSTANCEREFAccess().getRightSquareBracketKeyword_1_2()); 
            match(input,42,FOLLOW_42_in_rule__INSTANCEREF__Group_1__2__Impl9668); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4834:1: rule__INSTANCEREF__Group_2__0 : rule__INSTANCEREF__Group_2__0__Impl rule__INSTANCEREF__Group_2__1 ;
    public final void rule__INSTANCEREF__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4838:1: ( rule__INSTANCEREF__Group_2__0__Impl rule__INSTANCEREF__Group_2__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4839:2: rule__INSTANCEREF__Group_2__0__Impl rule__INSTANCEREF__Group_2__1
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_2__0__Impl_in_rule__INSTANCEREF__Group_2__09705);
            rule__INSTANCEREF__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREF__Group_2__1_in_rule__INSTANCEREF__Group_2__09708);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4846:1: rule__INSTANCEREF__Group_2__0__Impl : ( '.' ) ;
    public final void rule__INSTANCEREF__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4850:1: ( ( '.' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4851:1: ( '.' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4851:1: ( '.' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4852:1: '.'
            {
             before(grammarAccess.getINSTANCEREFAccess().getFullStopKeyword_2_0()); 
            match(input,52,FOLLOW_52_in_rule__INSTANCEREF__Group_2__0__Impl9736); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4865:1: rule__INSTANCEREF__Group_2__1 : rule__INSTANCEREF__Group_2__1__Impl rule__INSTANCEREF__Group_2__2 ;
    public final void rule__INSTANCEREF__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4869:1: ( rule__INSTANCEREF__Group_2__1__Impl rule__INSTANCEREF__Group_2__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4870:2: rule__INSTANCEREF__Group_2__1__Impl rule__INSTANCEREF__Group_2__2
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_2__1__Impl_in_rule__INSTANCEREF__Group_2__19767);
            rule__INSTANCEREF__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREF__Group_2__2_in_rule__INSTANCEREF__Group_2__19770);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4877:1: rule__INSTANCEREF__Group_2__1__Impl : ( RULE_ID ) ;
    public final void rule__INSTANCEREF__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4881:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4882:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4882:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4883:1: RULE_ID
            {
             before(grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_2_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__INSTANCEREF__Group_2__1__Impl9797); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4894:1: rule__INSTANCEREF__Group_2__2 : rule__INSTANCEREF__Group_2__2__Impl ;
    public final void rule__INSTANCEREF__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4898:1: ( rule__INSTANCEREF__Group_2__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4899:2: rule__INSTANCEREF__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_2__2__Impl_in_rule__INSTANCEREF__Group_2__29826);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4905:1: rule__INSTANCEREF__Group_2__2__Impl : ( ( rule__INSTANCEREF__Group_2_2__0 )* ) ;
    public final void rule__INSTANCEREF__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4909:1: ( ( ( rule__INSTANCEREF__Group_2_2__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4910:1: ( ( rule__INSTANCEREF__Group_2_2__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4910:1: ( ( rule__INSTANCEREF__Group_2_2__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4911:1: ( rule__INSTANCEREF__Group_2_2__0 )*
            {
             before(grammarAccess.getINSTANCEREFAccess().getGroup_2_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4912:1: ( rule__INSTANCEREF__Group_2_2__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==41) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4912:2: rule__INSTANCEREF__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__INSTANCEREF__Group_2_2__0_in_rule__INSTANCEREF__Group_2__2__Impl9853);
            	    rule__INSTANCEREF__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4928:1: rule__INSTANCEREF__Group_2_2__0 : rule__INSTANCEREF__Group_2_2__0__Impl rule__INSTANCEREF__Group_2_2__1 ;
    public final void rule__INSTANCEREF__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4932:1: ( rule__INSTANCEREF__Group_2_2__0__Impl rule__INSTANCEREF__Group_2_2__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4933:2: rule__INSTANCEREF__Group_2_2__0__Impl rule__INSTANCEREF__Group_2_2__1
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_2_2__0__Impl_in_rule__INSTANCEREF__Group_2_2__09890);
            rule__INSTANCEREF__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREF__Group_2_2__1_in_rule__INSTANCEREF__Group_2_2__09893);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4940:1: rule__INSTANCEREF__Group_2_2__0__Impl : ( '[' ) ;
    public final void rule__INSTANCEREF__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4944:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4945:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4945:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4946:1: '['
            {
             before(grammarAccess.getINSTANCEREFAccess().getLeftSquareBracketKeyword_2_2_0()); 
            match(input,41,FOLLOW_41_in_rule__INSTANCEREF__Group_2_2__0__Impl9921); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4959:1: rule__INSTANCEREF__Group_2_2__1 : rule__INSTANCEREF__Group_2_2__1__Impl rule__INSTANCEREF__Group_2_2__2 ;
    public final void rule__INSTANCEREF__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4963:1: ( rule__INSTANCEREF__Group_2_2__1__Impl rule__INSTANCEREF__Group_2_2__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4964:2: rule__INSTANCEREF__Group_2_2__1__Impl rule__INSTANCEREF__Group_2_2__2
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_2_2__1__Impl_in_rule__INSTANCEREF__Group_2_2__19952);
            rule__INSTANCEREF__Group_2_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREF__Group_2_2__2_in_rule__INSTANCEREF__Group_2_2__19955);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4971:1: rule__INSTANCEREF__Group_2_2__1__Impl : ( RULE_LONG ) ;
    public final void rule__INSTANCEREF__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4975:1: ( ( RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4976:1: ( RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4976:1: ( RULE_LONG )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4977:1: RULE_LONG
            {
             before(grammarAccess.getINSTANCEREFAccess().getLONGTerminalRuleCall_2_2_1()); 
            match(input,RULE_LONG,FOLLOW_RULE_LONG_in_rule__INSTANCEREF__Group_2_2__1__Impl9982); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4988:1: rule__INSTANCEREF__Group_2_2__2 : rule__INSTANCEREF__Group_2_2__2__Impl ;
    public final void rule__INSTANCEREF__Group_2_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4992:1: ( rule__INSTANCEREF__Group_2_2__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4993:2: rule__INSTANCEREF__Group_2_2__2__Impl
            {
            pushFollow(FOLLOW_rule__INSTANCEREF__Group_2_2__2__Impl_in_rule__INSTANCEREF__Group_2_2__210011);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:4999:1: rule__INSTANCEREF__Group_2_2__2__Impl : ( ']' ) ;
    public final void rule__INSTANCEREF__Group_2_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5003:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5004:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5004:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5005:1: ']'
            {
             before(grammarAccess.getINSTANCEREFAccess().getRightSquareBracketKeyword_2_2_2()); 
            match(input,42,FOLLOW_42_in_rule__INSTANCEREF__Group_2_2__2__Impl10039); 
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


    // $ANTLR start "rule__INSTANCEREFWITHPARENT__Group_1__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5024:1: rule__INSTANCEREFWITHPARENT__Group_1__0 : rule__INSTANCEREFWITHPARENT__Group_1__0__Impl rule__INSTANCEREFWITHPARENT__Group_1__1 ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5028:1: ( rule__INSTANCEREFWITHPARENT__Group_1__0__Impl rule__INSTANCEREFWITHPARENT__Group_1__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5029:2: rule__INSTANCEREFWITHPARENT__Group_1__0__Impl rule__INSTANCEREFWITHPARENT__Group_1__1
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__0__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1__010076);
            rule__INSTANCEREFWITHPARENT__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__1_in_rule__INSTANCEREFWITHPARENT__Group_1__010079);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5036:1: rule__INSTANCEREFWITHPARENT__Group_1__0__Impl : ( RULE_ID ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5040:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5041:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5041:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5042:1: RULE_ID
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__INSTANCEREFWITHPARENT__Group_1__0__Impl10106); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5053:1: rule__INSTANCEREFWITHPARENT__Group_1__1 : rule__INSTANCEREFWITHPARENT__Group_1__1__Impl rule__INSTANCEREFWITHPARENT__Group_1__2 ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5057:1: ( rule__INSTANCEREFWITHPARENT__Group_1__1__Impl rule__INSTANCEREFWITHPARENT__Group_1__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5058:2: rule__INSTANCEREFWITHPARENT__Group_1__1__Impl rule__INSTANCEREFWITHPARENT__Group_1__2
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__1__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1__110135);
            rule__INSTANCEREFWITHPARENT__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__2_in_rule__INSTANCEREFWITHPARENT__Group_1__110138);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5065:1: rule__INSTANCEREFWITHPARENT__Group_1__1__Impl : ( ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 ) ) ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 )* ) ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5069:1: ( ( ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 ) ) ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5070:1: ( ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 ) ) ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5070:1: ( ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 ) ) ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5071:1: ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 ) ) ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5071:1: ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5072:1: ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 )
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getGroup_1_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5073:1: ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5073:2: rule__INSTANCEREFWITHPARENT__Group_1_1__0
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__0_in_rule__INSTANCEREFWITHPARENT__Group_1__1__Impl10167);
            rule__INSTANCEREFWITHPARENT__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getINSTANCEREFWITHPARENTAccess().getGroup_1_1()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5076:1: ( ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5077:1: ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 )*
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getGroup_1_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5078:1: ( rule__INSTANCEREFWITHPARENT__Group_1_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==41) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5078:2: rule__INSTANCEREFWITHPARENT__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__0_in_rule__INSTANCEREFWITHPARENT__Group_1__1__Impl10179);
            	    rule__INSTANCEREFWITHPARENT__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5089:1: rule__INSTANCEREFWITHPARENT__Group_1__2 : rule__INSTANCEREFWITHPARENT__Group_1__2__Impl ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5093:1: ( rule__INSTANCEREFWITHPARENT__Group_1__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5094:2: rule__INSTANCEREFWITHPARENT__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__2__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1__210212);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5100:1: rule__INSTANCEREFWITHPARENT__Group_1__2__Impl : ( ( rule__INSTANCEREFWITHPARENT__Group_1_2__0 )* ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5104:1: ( ( ( rule__INSTANCEREFWITHPARENT__Group_1_2__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5105:1: ( ( rule__INSTANCEREFWITHPARENT__Group_1_2__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5105:1: ( ( rule__INSTANCEREFWITHPARENT__Group_1_2__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5106:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2__0 )*
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getGroup_1_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5107:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==52) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5107:2: rule__INSTANCEREFWITHPARENT__Group_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__0_in_rule__INSTANCEREFWITHPARENT__Group_1__2__Impl10239);
            	    rule__INSTANCEREFWITHPARENT__Group_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5123:1: rule__INSTANCEREFWITHPARENT__Group_1_1__0 : rule__INSTANCEREFWITHPARENT__Group_1_1__0__Impl rule__INSTANCEREFWITHPARENT__Group_1_1__1 ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5127:1: ( rule__INSTANCEREFWITHPARENT__Group_1_1__0__Impl rule__INSTANCEREFWITHPARENT__Group_1_1__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5128:2: rule__INSTANCEREFWITHPARENT__Group_1_1__0__Impl rule__INSTANCEREFWITHPARENT__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__0__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_1__010276);
            rule__INSTANCEREFWITHPARENT__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__1_in_rule__INSTANCEREFWITHPARENT__Group_1_1__010279);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5135:1: rule__INSTANCEREFWITHPARENT__Group_1_1__0__Impl : ( '[' ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5139:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5140:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5140:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5141:1: '['
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getLeftSquareBracketKeyword_1_1_0()); 
            match(input,41,FOLLOW_41_in_rule__INSTANCEREFWITHPARENT__Group_1_1__0__Impl10307); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5154:1: rule__INSTANCEREFWITHPARENT__Group_1_1__1 : rule__INSTANCEREFWITHPARENT__Group_1_1__1__Impl rule__INSTANCEREFWITHPARENT__Group_1_1__2 ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5158:1: ( rule__INSTANCEREFWITHPARENT__Group_1_1__1__Impl rule__INSTANCEREFWITHPARENT__Group_1_1__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5159:2: rule__INSTANCEREFWITHPARENT__Group_1_1__1__Impl rule__INSTANCEREFWITHPARENT__Group_1_1__2
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__1__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_1__110338);
            rule__INSTANCEREFWITHPARENT__Group_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__2_in_rule__INSTANCEREFWITHPARENT__Group_1_1__110341);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5166:1: rule__INSTANCEREFWITHPARENT__Group_1_1__1__Impl : ( RULE_LONG ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5170:1: ( ( RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5171:1: ( RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5171:1: ( RULE_LONG )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5172:1: RULE_LONG
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getLONGTerminalRuleCall_1_1_1()); 
            match(input,RULE_LONG,FOLLOW_RULE_LONG_in_rule__INSTANCEREFWITHPARENT__Group_1_1__1__Impl10368); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5183:1: rule__INSTANCEREFWITHPARENT__Group_1_1__2 : rule__INSTANCEREFWITHPARENT__Group_1_1__2__Impl ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5187:1: ( rule__INSTANCEREFWITHPARENT__Group_1_1__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5188:2: rule__INSTANCEREFWITHPARENT__Group_1_1__2__Impl
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__2__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_1__210397);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5194:1: rule__INSTANCEREFWITHPARENT__Group_1_1__2__Impl : ( ']' ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5198:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5199:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5199:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5200:1: ']'
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getRightSquareBracketKeyword_1_1_2()); 
            match(input,42,FOLLOW_42_in_rule__INSTANCEREFWITHPARENT__Group_1_1__2__Impl10425); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5219:1: rule__INSTANCEREFWITHPARENT__Group_1_2__0 : rule__INSTANCEREFWITHPARENT__Group_1_2__0__Impl rule__INSTANCEREFWITHPARENT__Group_1_2__1 ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5223:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2__0__Impl rule__INSTANCEREFWITHPARENT__Group_1_2__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5224:2: rule__INSTANCEREFWITHPARENT__Group_1_2__0__Impl rule__INSTANCEREFWITHPARENT__Group_1_2__1
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__0__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2__010462);
            rule__INSTANCEREFWITHPARENT__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__1_in_rule__INSTANCEREFWITHPARENT__Group_1_2__010465);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5231:1: rule__INSTANCEREFWITHPARENT__Group_1_2__0__Impl : ( '.' ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5235:1: ( ( '.' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5236:1: ( '.' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5236:1: ( '.' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5237:1: '.'
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getFullStopKeyword_1_2_0()); 
            match(input,52,FOLLOW_52_in_rule__INSTANCEREFWITHPARENT__Group_1_2__0__Impl10493); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5250:1: rule__INSTANCEREFWITHPARENT__Group_1_2__1 : rule__INSTANCEREFWITHPARENT__Group_1_2__1__Impl rule__INSTANCEREFWITHPARENT__Group_1_2__2 ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5254:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2__1__Impl rule__INSTANCEREFWITHPARENT__Group_1_2__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5255:2: rule__INSTANCEREFWITHPARENT__Group_1_2__1__Impl rule__INSTANCEREFWITHPARENT__Group_1_2__2
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__1__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2__110524);
            rule__INSTANCEREFWITHPARENT__Group_1_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__2_in_rule__INSTANCEREFWITHPARENT__Group_1_2__110527);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5262:1: rule__INSTANCEREFWITHPARENT__Group_1_2__1__Impl : ( RULE_ID ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5266:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5267:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5267:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5268:1: RULE_ID
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getIDTerminalRuleCall_1_2_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__INSTANCEREFWITHPARENT__Group_1_2__1__Impl10554); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5279:1: rule__INSTANCEREFWITHPARENT__Group_1_2__2 : rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5283:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5284:2: rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2__210583);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5290:1: rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl : ( ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 ) ) ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 )* ) ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5294:1: ( ( ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 ) ) ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5295:1: ( ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 ) ) ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5295:1: ( ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 ) ) ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5296:1: ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 ) ) ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5296:1: ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5297:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 )
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getGroup_1_2_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5298:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5298:2: rule__INSTANCEREFWITHPARENT__Group_1_2_2__0
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__0_in_rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl10612);
            rule__INSTANCEREFWITHPARENT__Group_1_2_2__0();

            state._fsp--;


            }

             after(grammarAccess.getINSTANCEREFWITHPARENTAccess().getGroup_1_2_2()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5301:1: ( ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5302:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 )*
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getGroup_1_2_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5303:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==41) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5303:2: rule__INSTANCEREFWITHPARENT__Group_1_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__0_in_rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl10624);
            	    rule__INSTANCEREFWITHPARENT__Group_1_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5320:1: rule__INSTANCEREFWITHPARENT__Group_1_2_2__0 : rule__INSTANCEREFWITHPARENT__Group_1_2_2__0__Impl rule__INSTANCEREFWITHPARENT__Group_1_2_2__1 ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5324:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__0__Impl rule__INSTANCEREFWITHPARENT__Group_1_2_2__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5325:2: rule__INSTANCEREFWITHPARENT__Group_1_2_2__0__Impl rule__INSTANCEREFWITHPARENT__Group_1_2_2__1
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__0__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__010663);
            rule__INSTANCEREFWITHPARENT__Group_1_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__1_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__010666);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5332:1: rule__INSTANCEREFWITHPARENT__Group_1_2_2__0__Impl : ( '[' ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5336:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5337:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5337:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5338:1: '['
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getLeftSquareBracketKeyword_1_2_2_0()); 
            match(input,41,FOLLOW_41_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__0__Impl10694); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5351:1: rule__INSTANCEREFWITHPARENT__Group_1_2_2__1 : rule__INSTANCEREFWITHPARENT__Group_1_2_2__1__Impl rule__INSTANCEREFWITHPARENT__Group_1_2_2__2 ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5355:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__1__Impl rule__INSTANCEREFWITHPARENT__Group_1_2_2__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5356:2: rule__INSTANCEREFWITHPARENT__Group_1_2_2__1__Impl rule__INSTANCEREFWITHPARENT__Group_1_2_2__2
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__1__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__110725);
            rule__INSTANCEREFWITHPARENT__Group_1_2_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__2_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__110728);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5363:1: rule__INSTANCEREFWITHPARENT__Group_1_2_2__1__Impl : ( RULE_LONG ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5367:1: ( ( RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5368:1: ( RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5368:1: ( RULE_LONG )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5369:1: RULE_LONG
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getLONGTerminalRuleCall_1_2_2_1()); 
            match(input,RULE_LONG,FOLLOW_RULE_LONG_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__1__Impl10755); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5380:1: rule__INSTANCEREFWITHPARENT__Group_1_2_2__2 : rule__INSTANCEREFWITHPARENT__Group_1_2_2__2__Impl ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5384:1: ( rule__INSTANCEREFWITHPARENT__Group_1_2_2__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5385:2: rule__INSTANCEREFWITHPARENT__Group_1_2_2__2__Impl
            {
            pushFollow(FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__2__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__210784);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5391:1: rule__INSTANCEREFWITHPARENT__Group_1_2_2__2__Impl : ( ']' ) ;
    public final void rule__INSTANCEREFWITHPARENT__Group_1_2_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5395:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5396:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5396:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5397:1: ']'
            {
             before(grammarAccess.getINSTANCEREFWITHPARENTAccess().getRightSquareBracketKeyword_1_2_2_2()); 
            match(input,42,FOLLOW_42_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__2__Impl10812); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5416:1: rule__CONNINSTREF__Group__0 : rule__CONNINSTREF__Group__0__Impl rule__CONNINSTREF__Group__1 ;
    public final void rule__CONNINSTREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5420:1: ( rule__CONNINSTREF__Group__0__Impl rule__CONNINSTREF__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5421:2: rule__CONNINSTREF__Group__0__Impl rule__CONNINSTREF__Group__1
            {
            pushFollow(FOLLOW_rule__CONNINSTREF__Group__0__Impl_in_rule__CONNINSTREF__Group__010849);
            rule__CONNINSTREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CONNINSTREF__Group__1_in_rule__CONNINSTREF__Group__010852);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5428:1: rule__CONNINSTREF__Group__0__Impl : ( ( rule__CONNINSTREF__Group_0__0 )? ) ;
    public final void rule__CONNINSTREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5432:1: ( ( ( rule__CONNINSTREF__Group_0__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5433:1: ( ( rule__CONNINSTREF__Group_0__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5433:1: ( ( rule__CONNINSTREF__Group_0__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5434:1: ( rule__CONNINSTREF__Group_0__0 )?
            {
             before(grammarAccess.getCONNINSTREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5435:1: ( rule__CONNINSTREF__Group_0__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_LONG) ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==52) ) {
                    alt35=1;
                }
            }
            switch (alt35) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5435:2: rule__CONNINSTREF__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__CONNINSTREF__Group_0__0_in_rule__CONNINSTREF__Group__0__Impl10879);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5445:1: rule__CONNINSTREF__Group__1 : rule__CONNINSTREF__Group__1__Impl ;
    public final void rule__CONNINSTREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5449:1: ( rule__CONNINSTREF__Group__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5450:2: rule__CONNINSTREF__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__CONNINSTREF__Group__1__Impl_in_rule__CONNINSTREF__Group__110910);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5456:1: rule__CONNINSTREF__Group__1__Impl : ( RULE_LONG ) ;
    public final void rule__CONNINSTREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5460:1: ( ( RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5461:1: ( RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5461:1: ( RULE_LONG )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5462:1: RULE_LONG
            {
             before(grammarAccess.getCONNINSTREFAccess().getLONGTerminalRuleCall_1()); 
            match(input,RULE_LONG,FOLLOW_RULE_LONG_in_rule__CONNINSTREF__Group__1__Impl10937); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5477:1: rule__CONNINSTREF__Group_0__0 : rule__CONNINSTREF__Group_0__0__Impl rule__CONNINSTREF__Group_0__1 ;
    public final void rule__CONNINSTREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5481:1: ( rule__CONNINSTREF__Group_0__0__Impl rule__CONNINSTREF__Group_0__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5482:2: rule__CONNINSTREF__Group_0__0__Impl rule__CONNINSTREF__Group_0__1
            {
            pushFollow(FOLLOW_rule__CONNINSTREF__Group_0__0__Impl_in_rule__CONNINSTREF__Group_0__010970);
            rule__CONNINSTREF__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CONNINSTREF__Group_0__1_in_rule__CONNINSTREF__Group_0__010973);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5489:1: rule__CONNINSTREF__Group_0__0__Impl : ( RULE_LONG ) ;
    public final void rule__CONNINSTREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5493:1: ( ( RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5494:1: ( RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5494:1: ( RULE_LONG )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5495:1: RULE_LONG
            {
             before(grammarAccess.getCONNINSTREFAccess().getLONGTerminalRuleCall_0_0()); 
            match(input,RULE_LONG,FOLLOW_RULE_LONG_in_rule__CONNINSTREF__Group_0__0__Impl11000); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5506:1: rule__CONNINSTREF__Group_0__1 : rule__CONNINSTREF__Group_0__1__Impl ;
    public final void rule__CONNINSTREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5510:1: ( rule__CONNINSTREF__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5511:2: rule__CONNINSTREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__CONNINSTREF__Group_0__1__Impl_in_rule__CONNINSTREF__Group_0__111029);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5517:1: rule__CONNINSTREF__Group_0__1__Impl : ( '.' ) ;
    public final void rule__CONNINSTREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5521:1: ( ( '.' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5522:1: ( '.' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5522:1: ( '.' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5523:1: '.'
            {
             before(grammarAccess.getCONNINSTREFAccess().getFullStopKeyword_0_1()); 
            match(input,52,FOLLOW_52_in_rule__CONNINSTREF__Group_0__1__Impl11057); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5541:1: rule__SystemInstance__CategoryAssignment_0 : ( ruleComponentCategory ) ;
    public final void rule__SystemInstance__CategoryAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5545:1: ( ( ruleComponentCategory ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5546:1: ( ruleComponentCategory )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5546:1: ( ruleComponentCategory )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5547:1: ruleComponentCategory
            {
             before(grammarAccess.getSystemInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_rule__SystemInstance__CategoryAssignment_011097);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5556:1: rule__SystemInstance__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SystemInstance__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5560:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5561:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5561:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5562:1: RULE_ID
            {
             before(grammarAccess.getSystemInstanceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SystemInstance__NameAssignment_111128); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5571:1: rule__SystemInstance__ComponentImplementationAssignment_3 : ( ( ruleIMPLREF ) ) ;
    public final void rule__SystemInstance__ComponentImplementationAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5575:1: ( ( ( ruleIMPLREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5576:1: ( ( ruleIMPLREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5576:1: ( ( ruleIMPLREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5577:1: ( ruleIMPLREF )
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationCrossReference_3_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5578:1: ( ruleIMPLREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5579:1: ruleIMPLREF
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationIMPLREFParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_ruleIMPLREF_in_rule__SystemInstance__ComponentImplementationAssignment_311163);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5590:1: rule__SystemInstance__FeatureInstanceAssignment_5_0 : ( ruleFeatureInstance ) ;
    public final void rule__SystemInstance__FeatureInstanceAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5594:1: ( ( ruleFeatureInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5595:1: ( ruleFeatureInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5595:1: ( ruleFeatureInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5596:1: ruleFeatureInstance
            {
             before(grammarAccess.getSystemInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_5_0_0()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_rule__SystemInstance__FeatureInstanceAssignment_5_011198);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5605:1: rule__SystemInstance__ComponentInstanceAssignment_5_1 : ( ruleComponentInstance ) ;
    public final void rule__SystemInstance__ComponentInstanceAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5609:1: ( ( ruleComponentInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5610:1: ( ruleComponentInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5610:1: ( ruleComponentInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5611:1: ruleComponentInstance
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_ruleComponentInstance_in_rule__SystemInstance__ComponentInstanceAssignment_5_111229);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5620:1: rule__SystemInstance__ConnectionInstanceAssignment_5_2 : ( ruleConnectionInstance ) ;
    public final void rule__SystemInstance__ConnectionInstanceAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5624:1: ( ( ruleConnectionInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5625:1: ( ruleConnectionInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5625:1: ( ruleConnectionInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5626:1: ruleConnectionInstance
            {
             before(grammarAccess.getSystemInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_5_2_0()); 
            pushFollow(FOLLOW_ruleConnectionInstance_in_rule__SystemInstance__ConnectionInstanceAssignment_5_211260);
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


    // $ANTLR start "rule__SystemInstance__SystemOperationModeAssignment_5_3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5635:1: rule__SystemInstance__SystemOperationModeAssignment_5_3 : ( ruleSystemOperationMode ) ;
    public final void rule__SystemInstance__SystemOperationModeAssignment_5_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5639:1: ( ( ruleSystemOperationMode ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5640:1: ( ruleSystemOperationMode )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5640:1: ( ruleSystemOperationMode )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5641:1: ruleSystemOperationMode
            {
             before(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_5_3_0()); 
            pushFollow(FOLLOW_ruleSystemOperationMode_in_rule__SystemInstance__SystemOperationModeAssignment_5_311291);
            ruleSystemOperationMode();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_5_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__SystemOperationModeAssignment_5_3"


    // $ANTLR start "rule__FeatureInstance__DirectionAssignment_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5650:1: rule__FeatureInstance__DirectionAssignment_0 : ( ruleDirectionType ) ;
    public final void rule__FeatureInstance__DirectionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5654:1: ( ( ruleDirectionType ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5655:1: ( ruleDirectionType )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5655:1: ( ruleDirectionType )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5656:1: ruleDirectionType
            {
             before(grammarAccess.getFeatureInstanceAccess().getDirectionDirectionTypeParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleDirectionType_in_rule__FeatureInstance__DirectionAssignment_011322);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5665:1: rule__FeatureInstance__CategoryAssignment_1 : ( ruleFeatureCategory ) ;
    public final void rule__FeatureInstance__CategoryAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5669:1: ( ( ruleFeatureCategory ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5670:1: ( ruleFeatureCategory )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5670:1: ( ruleFeatureCategory )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5671:1: ruleFeatureCategory
            {
             before(grammarAccess.getFeatureInstanceAccess().getCategoryFeatureCategoryParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleFeatureCategory_in_rule__FeatureInstance__CategoryAssignment_111353);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5680:1: rule__FeatureInstance__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__FeatureInstance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5684:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5685:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5685:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5686:1: RULE_ID
            {
             before(grammarAccess.getFeatureInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FeatureInstance__NameAssignment_211384); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5695:1: rule__FeatureInstance__IndexAssignment_3_1 : ( RULE_LONG ) ;
    public final void rule__FeatureInstance__IndexAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5699:1: ( ( RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5700:1: ( RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5700:1: ( RULE_LONG )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5701:1: RULE_LONG
            {
             before(grammarAccess.getFeatureInstanceAccess().getIndexLONGTerminalRuleCall_3_1_0()); 
            match(input,RULE_LONG,FOLLOW_RULE_LONG_in_rule__FeatureInstance__IndexAssignment_3_111415); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5710:1: rule__FeatureInstance__FeatureAssignment_5 : ( ( ruleFEATREF ) ) ;
    public final void rule__FeatureInstance__FeatureAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5714:1: ( ( ( ruleFEATREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5715:1: ( ( ruleFEATREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5715:1: ( ( ruleFEATREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5716:1: ( ruleFEATREF )
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureCrossReference_5_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5717:1: ( ruleFEATREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5718:1: ruleFEATREF
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureFEATREFParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_ruleFEATREF_in_rule__FeatureInstance__FeatureAssignment_511450);
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


    // $ANTLR start "rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5729:1: rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3 : ( ( ruleCONNINSTREF ) ) ;
    public final void rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5733:1: ( ( ( ruleCONNINSTREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5734:1: ( ( ruleCONNINSTREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5734:1: ( ( ruleCONNINSTREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5735:1: ( ruleCONNINSTREF )
            {
             before(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_6_3_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5736:1: ( ruleCONNINSTREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5737:1: ruleCONNINSTREF
            {
             before(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_6_3_0_1()); 
            pushFollow(FOLLOW_ruleCONNINSTREF_in_rule__FeatureInstance__SrcConnectionInstanceAssignment_6_311489);
            ruleCONNINSTREF();

            state._fsp--;

             after(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_6_3_0_1()); 

            }

             after(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_6_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3"


    // $ANTLR start "rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5748:1: rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1 : ( ( ruleCONNINSTREF ) ) ;
    public final void rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5752:1: ( ( ( ruleCONNINSTREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5753:1: ( ( ruleCONNINSTREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5753:1: ( ( ruleCONNINSTREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5754:1: ( ruleCONNINSTREF )
            {
             before(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_6_4_1_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5755:1: ( ruleCONNINSTREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5756:1: ruleCONNINSTREF
            {
             before(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_6_4_1_0_1()); 
            pushFollow(FOLLOW_ruleCONNINSTREF_in_rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_111528);
            ruleCONNINSTREF();

            state._fsp--;

             after(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_6_4_1_0_1()); 

            }

             after(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_6_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1"


    // $ANTLR start "rule__FeatureInstance__DstConnectionInstanceAssignment_7_3"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5767:1: rule__FeatureInstance__DstConnectionInstanceAssignment_7_3 : ( ( ruleCONNINSTREF ) ) ;
    public final void rule__FeatureInstance__DstConnectionInstanceAssignment_7_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5771:1: ( ( ( ruleCONNINSTREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5772:1: ( ( ruleCONNINSTREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5772:1: ( ( ruleCONNINSTREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5773:1: ( ruleCONNINSTREF )
            {
             before(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_7_3_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5774:1: ( ruleCONNINSTREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5775:1: ruleCONNINSTREF
            {
             before(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_7_3_0_1()); 
            pushFollow(FOLLOW_ruleCONNINSTREF_in_rule__FeatureInstance__DstConnectionInstanceAssignment_7_311567);
            ruleCONNINSTREF();

            state._fsp--;

             after(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_7_3_0_1()); 

            }

             after(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_7_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__DstConnectionInstanceAssignment_7_3"


    // $ANTLR start "rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5786:1: rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1 : ( ( ruleCONNINSTREF ) ) ;
    public final void rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5790:1: ( ( ( ruleCONNINSTREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5791:1: ( ( ruleCONNINSTREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5791:1: ( ( ruleCONNINSTREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5792:1: ( ruleCONNINSTREF )
            {
             before(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_7_4_1_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5793:1: ( ruleCONNINSTREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5794:1: ruleCONNINSTREF
            {
             before(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_7_4_1_0_1()); 
            pushFollow(FOLLOW_ruleCONNINSTREF_in_rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_111606);
            ruleCONNINSTREF();

            state._fsp--;

             after(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_7_4_1_0_1()); 

            }

             after(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_7_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1"


    // $ANTLR start "rule__FeatureInstance__FeatureInstanceAssignment_8_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5805:1: rule__FeatureInstance__FeatureInstanceAssignment_8_1 : ( ruleFeatureInstance ) ;
    public final void rule__FeatureInstance__FeatureInstanceAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5809:1: ( ( ruleFeatureInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5810:1: ( ruleFeatureInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5810:1: ( ruleFeatureInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5811:1: ruleFeatureInstance
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_rule__FeatureInstance__FeatureInstanceAssignment_8_111641);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5820:1: rule__ComponentInstance__CategoryAssignment_0 : ( ruleComponentCategory ) ;
    public final void rule__ComponentInstance__CategoryAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5824:1: ( ( ruleComponentCategory ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5825:1: ( ruleComponentCategory )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5825:1: ( ruleComponentCategory )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5826:1: ruleComponentCategory
            {
             before(grammarAccess.getComponentInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_rule__ComponentInstance__CategoryAssignment_011672);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5835:1: rule__ComponentInstance__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ComponentInstance__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5839:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5840:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5840:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5841:1: RULE_ID
            {
             before(grammarAccess.getComponentInstanceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ComponentInstance__NameAssignment_111703); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5850:1: rule__ComponentInstance__IndexAssignment_2_1 : ( RULE_LONG ) ;
    public final void rule__ComponentInstance__IndexAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5854:1: ( ( RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5855:1: ( RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5855:1: ( RULE_LONG )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5856:1: RULE_LONG
            {
             before(grammarAccess.getComponentInstanceAccess().getIndexLONGTerminalRuleCall_2_1_0()); 
            match(input,RULE_LONG,FOLLOW_RULE_LONG_in_rule__ComponentInstance__IndexAssignment_2_111734); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5865:1: rule__ComponentInstance__SubcomponentAssignment_4 : ( ( ruleSUBREF ) ) ;
    public final void rule__ComponentInstance__SubcomponentAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5869:1: ( ( ( ruleSUBREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5870:1: ( ( ruleSUBREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5870:1: ( ( ruleSUBREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5871:1: ( ruleSUBREF )
            {
             before(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentCrossReference_4_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5872:1: ( ruleSUBREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5873:1: ruleSUBREF
            {
             before(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentSUBREFParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_ruleSUBREF_in_rule__ComponentInstance__SubcomponentAssignment_411769);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5884:1: rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3 : ( ( ruleCONNINSTREF ) ) ;
    public final void rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5888:1: ( ( ( ruleCONNINSTREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5889:1: ( ( ruleCONNINSTREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5889:1: ( ( ruleCONNINSTREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5890:1: ( ruleCONNINSTREF )
            {
             before(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_5_3_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5891:1: ( ruleCONNINSTREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5892:1: ruleCONNINSTREF
            {
             before(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_5_3_0_1()); 
            pushFollow(FOLLOW_ruleCONNINSTREF_in_rule__ComponentInstance__SrcConnectionInstanceAssignment_5_311808);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5903:1: rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1 : ( ( ruleCONNINSTREF ) ) ;
    public final void rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5907:1: ( ( ( ruleCONNINSTREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5908:1: ( ( ruleCONNINSTREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5908:1: ( ( ruleCONNINSTREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5909:1: ( ruleCONNINSTREF )
            {
             before(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_5_4_1_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5910:1: ( ruleCONNINSTREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5911:1: ruleCONNINSTREF
            {
             before(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_5_4_1_0_1()); 
            pushFollow(FOLLOW_ruleCONNINSTREF_in_rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_111847);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5922:1: rule__ComponentInstance__DstConnectionInstanceAssignment_6_3 : ( ( ruleCONNINSTREF ) ) ;
    public final void rule__ComponentInstance__DstConnectionInstanceAssignment_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5926:1: ( ( ( ruleCONNINSTREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5927:1: ( ( ruleCONNINSTREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5927:1: ( ( ruleCONNINSTREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5928:1: ( ruleCONNINSTREF )
            {
             before(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_6_3_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5929:1: ( ruleCONNINSTREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5930:1: ruleCONNINSTREF
            {
             before(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_6_3_0_1()); 
            pushFollow(FOLLOW_ruleCONNINSTREF_in_rule__ComponentInstance__DstConnectionInstanceAssignment_6_311886);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5941:1: rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1 : ( ( ruleCONNINSTREF ) ) ;
    public final void rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5945:1: ( ( ( ruleCONNINSTREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5946:1: ( ( ruleCONNINSTREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5946:1: ( ( ruleCONNINSTREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5947:1: ( ruleCONNINSTREF )
            {
             before(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_6_4_1_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5948:1: ( ruleCONNINSTREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5949:1: ruleCONNINSTREF
            {
             before(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceConnectionInstanceCONNINSTREFParserRuleCall_6_4_1_0_1()); 
            pushFollow(FOLLOW_ruleCONNINSTREF_in_rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_111925);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5960:1: rule__ComponentInstance__FeatureInstanceAssignment_7_1_0 : ( ruleFeatureInstance ) ;
    public final void rule__ComponentInstance__FeatureInstanceAssignment_7_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5964:1: ( ( ruleFeatureInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5965:1: ( ruleFeatureInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5965:1: ( ruleFeatureInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5966:1: ruleFeatureInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_7_1_0_0()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_rule__ComponentInstance__FeatureInstanceAssignment_7_1_011960);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5975:1: rule__ComponentInstance__ComponentInstanceAssignment_7_1_1 : ( ruleComponentInstance ) ;
    public final void rule__ComponentInstance__ComponentInstanceAssignment_7_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5979:1: ( ( ruleComponentInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5980:1: ( ruleComponentInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5980:1: ( ruleComponentInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5981:1: ruleComponentInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_7_1_1_0()); 
            pushFollow(FOLLOW_ruleComponentInstance_in_rule__ComponentInstance__ComponentInstanceAssignment_7_1_111991);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5990:1: rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2 : ( ruleConnectionInstance ) ;
    public final void rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5994:1: ( ( ruleConnectionInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5995:1: ( ruleConnectionInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5995:1: ( ruleConnectionInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:5996:1: ruleConnectionInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_7_1_2_0()); 
            pushFollow(FOLLOW_ruleConnectionInstance_in_rule__ComponentInstance__ConnectionInstanceAssignment_7_1_212022);
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


    // $ANTLR start "rule__ConnectionInstance__CompleteAssignment_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6005:1: rule__ConnectionInstance__CompleteAssignment_0 : ( ( 'complete' ) ) ;
    public final void rule__ConnectionInstance__CompleteAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6009:1: ( ( ( 'complete' ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6010:1: ( ( 'complete' ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6010:1: ( ( 'complete' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6011:1: ( 'complete' )
            {
             before(grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_0_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6012:1: ( 'complete' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6013:1: 'complete'
            {
             before(grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_0_0()); 
            match(input,54,FOLLOW_54_in_rule__ConnectionInstance__CompleteAssignment_012058); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6028:1: rule__ConnectionInstance__KindAssignment_1 : ( ruleConnectionKind ) ;
    public final void rule__ConnectionInstance__KindAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6032:1: ( ( ruleConnectionKind ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6033:1: ( ruleConnectionKind )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6033:1: ( ruleConnectionKind )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6034:1: ruleConnectionKind
            {
             before(grammarAccess.getConnectionInstanceAccess().getKindConnectionKindParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleConnectionKind_in_rule__ConnectionInstance__KindAssignment_112097);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6043:1: rule__ConnectionInstance__NameAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ConnectionInstance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6047:1: ( ( RULE_STRING ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6048:1: ( RULE_STRING )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6048:1: ( RULE_STRING )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6049:1: RULE_STRING
            {
             before(grammarAccess.getConnectionInstanceAccess().getNameSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ConnectionInstance__NameAssignment_212128); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6058:1: rule__ConnectionInstance__SourceAssignment_4 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionInstance__SourceAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6062:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6063:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6063:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6064:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndCrossReference_4_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6065:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6066:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndINSTANCEREFParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__SourceAssignment_412163);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6077:1: rule__ConnectionInstance__BidirectionalAssignment_5_0 : ( ( '<->' ) ) ;
    public final void rule__ConnectionInstance__BidirectionalAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6081:1: ( ( ( '<->' ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6082:1: ( ( '<->' ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6082:1: ( ( '<->' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6083:1: ( '<->' )
            {
             before(grammarAccess.getConnectionInstanceAccess().getBidirectionalLessThanSignHyphenMinusGreaterThanSignKeyword_5_0_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6084:1: ( '<->' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6085:1: '<->'
            {
             before(grammarAccess.getConnectionInstanceAccess().getBidirectionalLessThanSignHyphenMinusGreaterThanSignKeyword_5_0_0()); 
            match(input,55,FOLLOW_55_in_rule__ConnectionInstance__BidirectionalAssignment_5_012203); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6100:1: rule__ConnectionInstance__DestinationAssignment_6 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionInstance__DestinationAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6104:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6105:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6105:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6106:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndCrossReference_6_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6107:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6108:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndINSTANCEREFParserRuleCall_6_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__DestinationAssignment_612246);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6119:1: rule__ConnectionInstance__ConnectionReferenceAssignment_8 : ( ruleConnectionReference ) ;
    public final void rule__ConnectionInstance__ConnectionReferenceAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6123:1: ( ( ruleConnectionReference ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6124:1: ( ruleConnectionReference )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6124:1: ( ruleConnectionReference )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6125:1: ruleConnectionReference
            {
             before(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceConnectionReferenceParserRuleCall_8_0()); 
            pushFollow(FOLLOW_ruleConnectionReference_in_rule__ConnectionInstance__ConnectionReferenceAssignment_812281);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6134:1: rule__ConnectionReference__SourceAssignment_0 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionReference__SourceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6138:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6139:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6139:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6140:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndCrossReference_0_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6141:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6142:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndINSTANCEREFParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__SourceAssignment_012316);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6153:1: rule__ConnectionReference__DestinationAssignment_2 : ( ( ruleINSTANCEREF ) ) ;
    public final void rule__ConnectionReference__DestinationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6157:1: ( ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6158:1: ( ( ruleINSTANCEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6158:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6159:1: ( ruleINSTANCEREF )
            {
             before(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndCrossReference_2_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6160:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6161:1: ruleINSTANCEREF
            {
             before(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndINSTANCEREFParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__DestinationAssignment_212355);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6172:1: rule__ConnectionReference__ConnectionAssignment_4 : ( ( ruleSUBREF ) ) ;
    public final void rule__ConnectionReference__ConnectionAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6176:1: ( ( ( ruleSUBREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6177:1: ( ( ruleSUBREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6177:1: ( ( ruleSUBREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6178:1: ( ruleSUBREF )
            {
             before(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionCrossReference_4_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6179:1: ( ruleSUBREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6180:1: ruleSUBREF
            {
             before(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionSUBREFParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_ruleSUBREF_in_rule__ConnectionReference__ConnectionAssignment_412394);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6191:1: rule__ConnectionReference__ContextAssignment_6 : ( ( ruleINSTANCEREFWITHPARENT ) ) ;
    public final void rule__ConnectionReference__ContextAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6195:1: ( ( ( ruleINSTANCEREFWITHPARENT ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6196:1: ( ( ruleINSTANCEREFWITHPARENT ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6196:1: ( ( ruleINSTANCEREFWITHPARENT ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6197:1: ( ruleINSTANCEREFWITHPARENT )
            {
             before(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceCrossReference_6_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6198:1: ( ruleINSTANCEREFWITHPARENT )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6199:1: ruleINSTANCEREFWITHPARENT
            {
             before(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceINSTANCEREFWITHPARENTParserRuleCall_6_0_1()); 
            pushFollow(FOLLOW_ruleINSTANCEREFWITHPARENT_in_rule__ConnectionReference__ContextAssignment_612433);
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


    // $ANTLR start "rule__SystemOperationMode__NameAssignment_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6210:1: rule__SystemOperationMode__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__SystemOperationMode__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6214:1: ( ( RULE_STRING ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6215:1: ( RULE_STRING )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6215:1: ( RULE_STRING )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:6216:1: RULE_STRING
            {
             before(grammarAccess.getSystemOperationModeAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__SystemOperationMode__NameAssignment_112468); 
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


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\22\uffff";
    static final String DFA6_eofS =
        "\10\uffff\1\14\1\uffff\1\16\7\uffff";
    static final String DFA6_minS =
        "\1\25\7\uffff\1\4\1\uffff\1\4\1\26\6\uffff";
    static final String DFA6_maxS =
        "\1\63\7\uffff\1\62\1\uffff\1\62\1\33\6\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\2\uffff\1\10\1\11\1\14\1\13\1\15\1\16";
    static final String DFA6_specialS =
        "\22\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\24\uffff\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\14\55\uffff\1\15",
            "",
            "\1\16\55\uffff\1\17",
            "\1\20\4\uffff\1\21",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "708:1: rule__ComponentCategory__Alternatives : ( ( 'abstract' ) | ( 'bus' ) | ( 'data' ) | ( 'device' ) | ( 'memory' ) | ( 'process' ) | ( 'processor' ) | ( 'subprogram' ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( 'system' ) | ( ( rule__ComponentCategory__Group_10__0 ) ) | ( 'thread' ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( ( rule__ComponentCategory__Group_13__0 ) ) );";
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
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemOperationMode368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__0_in_ruleSystemOperationMode394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_entryRuleDirectionType421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDirectionType428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DirectionType__Alternatives_in_ruleDirectionType454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCategory488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCategory__Alternatives_in_ruleFeatureCategory514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentCategory548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Alternatives_in_ruleComponentCategory574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionKind_in_entryRuleConnectionKind601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionKind608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionKind__Alternatives_in_ruleConnectionKind634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIMPLREF_in_entryRuleIMPLREF661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIMPLREF668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__0_in_ruleIMPLREF694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFEATREF_in_entryRuleFEATREF721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFEATREF728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__0_in_ruleFEATREF754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSUBREF_in_entryRuleSUBREF781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSUBREF788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__0_in_ruleSUBREF814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_entryRuleINSTANCEREF841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINSTANCEREF848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group__0_in_ruleINSTANCEREF874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREFWITHPARENT_in_entryRuleINSTANCEREFWITHPARENT901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINSTANCEREFWITHPARENT908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Alternatives_in_ruleINSTANCEREFWITHPARENT934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_entryRuleCONNINSTREF961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCONNINSTREF968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CONNINSTREF__Group__0_in_ruleCONNINSTREF994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__FeatureInstanceAssignment_5_0_in_rule__SystemInstance__Alternatives_51030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__ComponentInstanceAssignment_5_1_in_rule__SystemInstance__Alternatives_51048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__ConnectionInstanceAssignment_5_2_in_rule__SystemInstance__Alternatives_51066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__SystemOperationModeAssignment_5_3_in_rule__SystemInstance__Alternatives_51084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__FeatureInstanceAssignment_7_1_0_in_rule__ComponentInstance__Alternatives_7_11117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__ComponentInstanceAssignment_7_1_1_in_rule__ComponentInstance__Alternatives_7_11135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2_in_rule__ComponentInstance__Alternatives_7_11153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__BidirectionalAssignment_5_0_in_rule__ConnectionInstance__Alternatives_51186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_rule__ConnectionInstance__Alternatives_51205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__DirectionType__Alternatives1240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__DirectionType__Alternatives1260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DirectionType__Group_2__0_in_rule__DirectionType__Alternatives1279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__FeatureCategory__Alternatives1313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__FeatureCategory__Alternatives1333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__FeatureCategory__Alternatives1353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__FeatureCategory__Alternatives1373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__FeatureCategory__Alternatives1393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__FeatureCategory__Alternatives1413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__FeatureCategory__Alternatives1433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__FeatureCategory__Alternatives1453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__FeatureCategory__Alternatives1473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ComponentCategory__Alternatives1508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ComponentCategory__Alternatives1528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ComponentCategory__Alternatives1548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ComponentCategory__Alternatives1568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ComponentCategory__Alternatives1588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ComponentCategory__Alternatives1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ComponentCategory__Alternatives1628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ComponentCategory__Alternatives1648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__0_in_rule__ComponentCategory__Alternatives1667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ComponentCategory__Alternatives1686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_10__0_in_rule__ComponentCategory__Alternatives1705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ComponentCategory__Alternatives1724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__0_in_rule__ComponentCategory__Alternatives1743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_13__0_in_rule__ComponentCategory__Alternatives1761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ConnectionKind__Alternatives1795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ConnectionKind__Alternatives1815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ConnectionKind__Alternatives1835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__ConnectionKind__Alternatives1855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ConnectionKind__Alternatives1875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ConnectionKind__Alternatives1895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__INSTANCEREFWITHPARENT__Alternatives1930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__0_in_rule__INSTANCEREFWITHPARENT__Alternatives1949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__0__Impl_in_rule__SystemInstance__Group__01980 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__1_in_rule__SystemInstance__Group__01983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__CategoryAssignment_0_in_rule__SystemInstance__Group__0__Impl2010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__1__Impl_in_rule__SystemInstance__Group__12040 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__2_in_rule__SystemInstance__Group__12043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__NameAssignment_1_in_rule__SystemInstance__Group__1__Impl2070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__2__Impl_in_rule__SystemInstance__Group__22100 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__3_in_rule__SystemInstance__Group__22103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__SystemInstance__Group__2__Impl2131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__3__Impl_in_rule__SystemInstance__Group__32162 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__4_in_rule__SystemInstance__Group__32165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__ComponentImplementationAssignment_3_in_rule__SystemInstance__Group__3__Impl2192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__4__Impl_in_rule__SystemInstance__Group__42222 = new BitSet(new long[]{0x004A011FFFE00C00L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__5_in_rule__SystemInstance__Group__42225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__SystemInstance__Group__4__Impl2253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__5__Impl_in_rule__SystemInstance__Group__52284 = new BitSet(new long[]{0x004A011FFFE00C00L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__6_in_rule__SystemInstance__Group__52287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Alternatives_5_in_rule__SystemInstance__Group__5__Impl2314 = new BitSet(new long[]{0x004A001FFFE00C02L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__6__Impl_in_rule__SystemInstance__Group__62345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__SystemInstance__Group__6__Impl2373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__0__Impl_in_rule__FeatureInstance__Group__02418 = new BitSet(new long[]{0x00000000001FF000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__1_in_rule__FeatureInstance__Group__02421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__DirectionAssignment_0_in_rule__FeatureInstance__Group__0__Impl2448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__1__Impl_in_rule__FeatureInstance__Group__12478 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__2_in_rule__FeatureInstance__Group__12481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__CategoryAssignment_1_in_rule__FeatureInstance__Group__1__Impl2508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__2__Impl_in_rule__FeatureInstance__Group__22538 = new BitSet(new long[]{0x0000024000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__3_in_rule__FeatureInstance__Group__22541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__NameAssignment_2_in_rule__FeatureInstance__Group__2__Impl2568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__3__Impl_in_rule__FeatureInstance__Group__32598 = new BitSet(new long[]{0x0000024000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__4_in_rule__FeatureInstance__Group__32601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__0_in_rule__FeatureInstance__Group__3__Impl2628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__4__Impl_in_rule__FeatureInstance__Group__42659 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__5_in_rule__FeatureInstance__Group__42662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__FeatureInstance__Group__4__Impl2690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__5__Impl_in_rule__FeatureInstance__Group__52721 = new BitSet(new long[]{0x0001088000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__6_in_rule__FeatureInstance__Group__52724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__FeatureAssignment_5_in_rule__FeatureInstance__Group__5__Impl2751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__6__Impl_in_rule__FeatureInstance__Group__62781 = new BitSet(new long[]{0x0001088000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__7_in_rule__FeatureInstance__Group__62784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__0_in_rule__FeatureInstance__Group__6__Impl2811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__7__Impl_in_rule__FeatureInstance__Group__72842 = new BitSet(new long[]{0x0001088000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__8_in_rule__FeatureInstance__Group__72845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__0_in_rule__FeatureInstance__Group__7__Impl2872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__8__Impl_in_rule__FeatureInstance__Group__82903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_8__0_in_rule__FeatureInstance__Group__8__Impl2930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__0__Impl_in_rule__FeatureInstance__Group_3__02979 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__1_in_rule__FeatureInstance__Group_3__02982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__FeatureInstance__Group_3__0__Impl3010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__1__Impl_in_rule__FeatureInstance__Group_3__13041 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__2_in_rule__FeatureInstance__Group_3__13044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__IndexAssignment_3_1_in_rule__FeatureInstance__Group_3__1__Impl3071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__2__Impl_in_rule__FeatureInstance__Group_3__23101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__FeatureInstance__Group_3__2__Impl3129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__0__Impl_in_rule__FeatureInstance__Group_6__03166 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__1_in_rule__FeatureInstance__Group_6__03169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__FeatureInstance__Group_6__0__Impl3197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__1__Impl_in_rule__FeatureInstance__Group_6__13228 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__2_in_rule__FeatureInstance__Group_6__13231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__FeatureInstance__Group_6__1__Impl3259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__2__Impl_in_rule__FeatureInstance__Group_6__23290 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__3_in_rule__FeatureInstance__Group_6__23293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__FeatureInstance__Group_6__2__Impl3321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__3__Impl_in_rule__FeatureInstance__Group_6__33352 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__4_in_rule__FeatureInstance__Group_6__33355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__SrcConnectionInstanceAssignment_6_3_in_rule__FeatureInstance__Group_6__3__Impl3382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__4__Impl_in_rule__FeatureInstance__Group_6__43412 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__5_in_rule__FeatureInstance__Group_6__43415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6_4__0_in_rule__FeatureInstance__Group_6__4__Impl3442 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__5__Impl_in_rule__FeatureInstance__Group_6__53473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__FeatureInstance__Group_6__5__Impl3501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6_4__0__Impl_in_rule__FeatureInstance__Group_6_4__03544 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6_4__1_in_rule__FeatureInstance__Group_6_4__03547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__FeatureInstance__Group_6_4__0__Impl3575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6_4__1__Impl_in_rule__FeatureInstance__Group_6_4__13606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_1_in_rule__FeatureInstance__Group_6_4__1__Impl3633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__0__Impl_in_rule__FeatureInstance__Group_7__03667 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__1_in_rule__FeatureInstance__Group_7__03670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__FeatureInstance__Group_7__0__Impl3698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__1__Impl_in_rule__FeatureInstance__Group_7__13729 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__2_in_rule__FeatureInstance__Group_7__13732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__FeatureInstance__Group_7__1__Impl3760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__2__Impl_in_rule__FeatureInstance__Group_7__23791 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__3_in_rule__FeatureInstance__Group_7__23794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__FeatureInstance__Group_7__2__Impl3822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__3__Impl_in_rule__FeatureInstance__Group_7__33853 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__4_in_rule__FeatureInstance__Group_7__33856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__DstConnectionInstanceAssignment_7_3_in_rule__FeatureInstance__Group_7__3__Impl3883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__4__Impl_in_rule__FeatureInstance__Group_7__43913 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__5_in_rule__FeatureInstance__Group_7__43916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7_4__0_in_rule__FeatureInstance__Group_7__4__Impl3943 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7__5__Impl_in_rule__FeatureInstance__Group_7__53974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__FeatureInstance__Group_7__5__Impl4002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7_4__0__Impl_in_rule__FeatureInstance__Group_7_4__04045 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7_4__1_in_rule__FeatureInstance__Group_7_4__04048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__FeatureInstance__Group_7_4__0__Impl4076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_7_4__1__Impl_in_rule__FeatureInstance__Group_7_4__14107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_1_in_rule__FeatureInstance__Group_7_4__1__Impl4134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_8__0__Impl_in_rule__FeatureInstance__Group_8__04168 = new BitSet(new long[]{0x0000010000000C00L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_8__1_in_rule__FeatureInstance__Group_8__04171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__FeatureInstance__Group_8__0__Impl4199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_8__1__Impl_in_rule__FeatureInstance__Group_8__14230 = new BitSet(new long[]{0x0000010000000C00L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_8__2_in_rule__FeatureInstance__Group_8__14233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__FeatureInstanceAssignment_8_1_in_rule__FeatureInstance__Group_8__1__Impl4260 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_8__2__Impl_in_rule__FeatureInstance__Group_8__24291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__FeatureInstance__Group_8__2__Impl4319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__0__Impl_in_rule__ComponentInstance__Group__04356 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__1_in_rule__ComponentInstance__Group__04359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__CategoryAssignment_0_in_rule__ComponentInstance__Group__0__Impl4386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__1__Impl_in_rule__ComponentInstance__Group__14416 = new BitSet(new long[]{0x0000024000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__2_in_rule__ComponentInstance__Group__14419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__NameAssignment_1_in_rule__ComponentInstance__Group__1__Impl4446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__2__Impl_in_rule__ComponentInstance__Group__24476 = new BitSet(new long[]{0x0000024000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__3_in_rule__ComponentInstance__Group__24479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__0_in_rule__ComponentInstance__Group__2__Impl4506 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__3__Impl_in_rule__ComponentInstance__Group__34537 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__4_in_rule__ComponentInstance__Group__34540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ComponentInstance__Group__3__Impl4568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__4__Impl_in_rule__ComponentInstance__Group__44599 = new BitSet(new long[]{0x0001088000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__5_in_rule__ComponentInstance__Group__44602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__SubcomponentAssignment_4_in_rule__ComponentInstance__Group__4__Impl4629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__5__Impl_in_rule__ComponentInstance__Group__54659 = new BitSet(new long[]{0x0001088000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__6_in_rule__ComponentInstance__Group__54662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__0_in_rule__ComponentInstance__Group__5__Impl4689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__6__Impl_in_rule__ComponentInstance__Group__64720 = new BitSet(new long[]{0x0001088000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__7_in_rule__ComponentInstance__Group__64723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__0_in_rule__ComponentInstance__Group__6__Impl4750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__7__Impl_in_rule__ComponentInstance__Group__74781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_7__0_in_rule__ComponentInstance__Group__7__Impl4808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__0__Impl_in_rule__ComponentInstance__Group_2__04855 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__1_in_rule__ComponentInstance__Group_2__04858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ComponentInstance__Group_2__0__Impl4886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__1__Impl_in_rule__ComponentInstance__Group_2__14917 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__2_in_rule__ComponentInstance__Group_2__14920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__IndexAssignment_2_1_in_rule__ComponentInstance__Group_2__1__Impl4947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__2__Impl_in_rule__ComponentInstance__Group_2__24977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__ComponentInstance__Group_2__2__Impl5005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__0__Impl_in_rule__ComponentInstance__Group_5__05042 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__1_in_rule__ComponentInstance__Group_5__05045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__ComponentInstance__Group_5__0__Impl5073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__1__Impl_in_rule__ComponentInstance__Group_5__15104 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__2_in_rule__ComponentInstance__Group_5__15107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__ComponentInstance__Group_5__1__Impl5135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__2__Impl_in_rule__ComponentInstance__Group_5__25166 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__3_in_rule__ComponentInstance__Group_5__25169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__ComponentInstance__Group_5__2__Impl5197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__3__Impl_in_rule__ComponentInstance__Group_5__35228 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__4_in_rule__ComponentInstance__Group_5__35231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__SrcConnectionInstanceAssignment_5_3_in_rule__ComponentInstance__Group_5__3__Impl5258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__4__Impl_in_rule__ComponentInstance__Group_5__45288 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__5_in_rule__ComponentInstance__Group_5__45291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5_4__0_in_rule__ComponentInstance__Group_5__4__Impl5318 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__5__Impl_in_rule__ComponentInstance__Group_5__55349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ComponentInstance__Group_5__5__Impl5377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5_4__0__Impl_in_rule__ComponentInstance__Group_5_4__05420 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5_4__1_in_rule__ComponentInstance__Group_5_4__05423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__ComponentInstance__Group_5_4__0__Impl5451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5_4__1__Impl_in_rule__ComponentInstance__Group_5_4__15482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_1_in_rule__ComponentInstance__Group_5_4__1__Impl5509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__0__Impl_in_rule__ComponentInstance__Group_6__05543 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__1_in_rule__ComponentInstance__Group_6__05546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__ComponentInstance__Group_6__0__Impl5574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__1__Impl_in_rule__ComponentInstance__Group_6__15605 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__2_in_rule__ComponentInstance__Group_6__15608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__ComponentInstance__Group_6__1__Impl5636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__2__Impl_in_rule__ComponentInstance__Group_6__25667 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__3_in_rule__ComponentInstance__Group_6__25670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__ComponentInstance__Group_6__2__Impl5698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__3__Impl_in_rule__ComponentInstance__Group_6__35729 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__4_in_rule__ComponentInstance__Group_6__35732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__DstConnectionInstanceAssignment_6_3_in_rule__ComponentInstance__Group_6__3__Impl5759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__4__Impl_in_rule__ComponentInstance__Group_6__45789 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__5_in_rule__ComponentInstance__Group_6__45792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6_4__0_in_rule__ComponentInstance__Group_6__4__Impl5819 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6__5__Impl_in_rule__ComponentInstance__Group_6__55850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ComponentInstance__Group_6__5__Impl5878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6_4__0__Impl_in_rule__ComponentInstance__Group_6_4__05921 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6_4__1_in_rule__ComponentInstance__Group_6_4__05924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__ComponentInstance__Group_6_4__0__Impl5952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_6_4__1__Impl_in_rule__ComponentInstance__Group_6_4__15983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_1_in_rule__ComponentInstance__Group_6_4__1__Impl6010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_7__0__Impl_in_rule__ComponentInstance__Group_7__06044 = new BitSet(new long[]{0x0048011FFFE00C00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_7__1_in_rule__ComponentInstance__Group_7__06047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ComponentInstance__Group_7__0__Impl6075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_7__1__Impl_in_rule__ComponentInstance__Group_7__16106 = new BitSet(new long[]{0x0048011FFFE00C00L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_7__2_in_rule__ComponentInstance__Group_7__16109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Alternatives_7_1_in_rule__ComponentInstance__Group_7__1__Impl6136 = new BitSet(new long[]{0x0048001FFFE00C02L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_7__2__Impl_in_rule__ComponentInstance__Group_7__26167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ComponentInstance__Group_7__2__Impl6195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__0__Impl_in_rule__ConnectionInstance__Group__06232 = new BitSet(new long[]{0x0040001F80000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__1_in_rule__ConnectionInstance__Group__06235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__CompleteAssignment_0_in_rule__ConnectionInstance__Group__0__Impl6262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__1__Impl_in_rule__ConnectionInstance__Group__16293 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__2_in_rule__ConnectionInstance__Group__16296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__KindAssignment_1_in_rule__ConnectionInstance__Group__1__Impl6323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__2__Impl_in_rule__ConnectionInstance__Group__26353 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__3_in_rule__ConnectionInstance__Group__26356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__NameAssignment_2_in_rule__ConnectionInstance__Group__2__Impl6383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__3__Impl_in_rule__ConnectionInstance__Group__36413 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__4_in_rule__ConnectionInstance__Group__36416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ConnectionInstance__Group__3__Impl6444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__4__Impl_in_rule__ConnectionInstance__Group__46475 = new BitSet(new long[]{0x0080000000000200L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__5_in_rule__ConnectionInstance__Group__46478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__SourceAssignment_4_in_rule__ConnectionInstance__Group__4__Impl6505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__5__Impl_in_rule__ConnectionInstance__Group__56535 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__6_in_rule__ConnectionInstance__Group__56538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Alternatives_5_in_rule__ConnectionInstance__Group__5__Impl6565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__6__Impl_in_rule__ConnectionInstance__Group__66595 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__7_in_rule__ConnectionInstance__Group__66598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__DestinationAssignment_6_in_rule__ConnectionInstance__Group__6__Impl6625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__7__Impl_in_rule__ConnectionInstance__Group__76655 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__8_in_rule__ConnectionInstance__Group__76658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ConnectionInstance__Group__7__Impl6686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__8__Impl_in_rule__ConnectionInstance__Group__86717 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__9_in_rule__ConnectionInstance__Group__86720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__ConnectionReferenceAssignment_8_in_rule__ConnectionInstance__Group__8__Impl6749 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__ConnectionReferenceAssignment_8_in_rule__ConnectionInstance__Group__8__Impl6761 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ConnectionInstance__Group__9__Impl_in_rule__ConnectionInstance__Group__96794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ConnectionInstance__Group__9__Impl6822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__0__Impl_in_rule__ConnectionReference__Group__06873 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__1_in_rule__ConnectionReference__Group__06876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__SourceAssignment_0_in_rule__ConnectionReference__Group__0__Impl6903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__1__Impl_in_rule__ConnectionReference__Group__16933 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__2_in_rule__ConnectionReference__Group__16936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_rule__ConnectionReference__Group__1__Impl6964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__2__Impl_in_rule__ConnectionReference__Group__26995 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__3_in_rule__ConnectionReference__Group__26998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__DestinationAssignment_2_in_rule__ConnectionReference__Group__2__Impl7025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__3__Impl_in_rule__ConnectionReference__Group__37055 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__4_in_rule__ConnectionReference__Group__37058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ConnectionReference__Group__3__Impl7086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__4__Impl_in_rule__ConnectionReference__Group__47117 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__5_in_rule__ConnectionReference__Group__47120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__ConnectionAssignment_4_in_rule__ConnectionReference__Group__4__Impl7147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__5__Impl_in_rule__ConnectionReference__Group__57177 = new BitSet(new long[]{0x0000002000000010L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__6_in_rule__ConnectionReference__Group__57180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__ConnectionReference__Group__5__Impl7208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__Group__6__Impl_in_rule__ConnectionReference__Group__67239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionReference__ContextAssignment_6_in_rule__ConnectionReference__Group__6__Impl7266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__0__Impl_in_rule__SystemOperationMode__Group__07310 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__1_in_rule__SystemOperationMode__Group__07313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__SystemOperationMode__Group__0__Impl7341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__1__Impl_in_rule__SystemOperationMode__Group__17372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__NameAssignment_1_in_rule__SystemOperationMode__Group__1__Impl7399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DirectionType__Group_2__0__Impl_in_rule__DirectionType__Group_2__07433 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__DirectionType__Group_2__1_in_rule__DirectionType__Group_2__07436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__DirectionType__Group_2__0__Impl7464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DirectionType__Group_2__1__Impl_in_rule__DirectionType__Group_2__17495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__DirectionType__Group_2__1__Impl7523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__0__Impl_in_rule__ComponentCategory__Group_8__07558 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__1_in_rule__ComponentCategory__Group_8__07561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ComponentCategory__Group_8__0__Impl7589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__1__Impl_in_rule__ComponentCategory__Group_8__17620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__ComponentCategory__Group_8__1__Impl7648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_10__0__Impl_in_rule__ComponentCategory__Group_10__07683 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_10__1_in_rule__ComponentCategory__Group_10__07686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ComponentCategory__Group_10__0__Impl7714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_10__1__Impl_in_rule__ComponentCategory__Group_10__17745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__ComponentCategory__Group_10__1__Impl7773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__0__Impl_in_rule__ComponentCategory__Group_12__07808 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__1_in_rule__ComponentCategory__Group_12__07811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__ComponentCategory__Group_12__0__Impl7839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__1__Impl_in_rule__ComponentCategory__Group_12__17870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ComponentCategory__Group_12__1__Impl7898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_13__0__Impl_in_rule__ComponentCategory__Group_13__07933 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_13__1_in_rule__ComponentCategory__Group_13__07936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__ComponentCategory__Group_13__0__Impl7964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_13__1__Impl_in_rule__ComponentCategory__Group_13__17995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ComponentCategory__Group_13__1__Impl8023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__0__Impl_in_rule__IMPLREF__Group__08058 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__1_in_rule__IMPLREF__Group__08061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group_0__0_in_rule__IMPLREF__Group__0__Impl8090 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group_0__0_in_rule__IMPLREF__Group__0__Impl8102 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__1__Impl_in_rule__IMPLREF__Group__18135 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__2_in_rule__IMPLREF__Group__18138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IMPLREF__Group__1__Impl8165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__2__Impl_in_rule__IMPLREF__Group__28194 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__3_in_rule__IMPLREF__Group__28197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__IMPLREF__Group__2__Impl8225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__3__Impl_in_rule__IMPLREF__Group__38256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IMPLREF__Group__3__Impl8283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group_0__0__Impl_in_rule__IMPLREF__Group_0__08320 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group_0__1_in_rule__IMPLREF__Group_0__08323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IMPLREF__Group_0__0__Impl8350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group_0__1__Impl_in_rule__IMPLREF__Group_0__18379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__IMPLREF__Group_0__1__Impl8407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__0__Impl_in_rule__FEATREF__Group__08442 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__1_in_rule__FEATREF__Group__08445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FEATREF__Group_0__0_in_rule__FEATREF__Group__0__Impl8474 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__FEATREF__Group_0__0_in_rule__FEATREF__Group__0__Impl8486 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__1__Impl_in_rule__FEATREF__Group__18519 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__2_in_rule__FEATREF__Group__18522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FEATREF__Group__1__Impl8549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__2__Impl_in_rule__FEATREF__Group__28578 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__3_in_rule__FEATREF__Group__28581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__FEATREF__Group__2__Impl8609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__3__Impl_in_rule__FEATREF__Group__38640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FEATREF__Group__3__Impl8667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FEATREF__Group_0__0__Impl_in_rule__FEATREF__Group_0__08704 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__FEATREF__Group_0__1_in_rule__FEATREF__Group_0__08707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FEATREF__Group_0__0__Impl8734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FEATREF__Group_0__1__Impl_in_rule__FEATREF__Group_0__18763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__FEATREF__Group_0__1__Impl8791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__0__Impl_in_rule__SUBREF__Group__08826 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__1_in_rule__SUBREF__Group__08829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group_0__0_in_rule__SUBREF__Group__0__Impl8858 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SUBREF__Group_0__0_in_rule__SUBREF__Group__0__Impl8870 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__1__Impl_in_rule__SUBREF__Group__18903 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__2_in_rule__SUBREF__Group__18906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SUBREF__Group__1__Impl8933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__2__Impl_in_rule__SUBREF__Group__28962 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__3_in_rule__SUBREF__Group__28965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__SUBREF__Group__2__Impl8993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__3__Impl_in_rule__SUBREF__Group__39024 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__4_in_rule__SUBREF__Group__39027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SUBREF__Group__3__Impl9054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__4__Impl_in_rule__SUBREF__Group__49083 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__5_in_rule__SUBREF__Group__49086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__SUBREF__Group__4__Impl9114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__5__Impl_in_rule__SUBREF__Group__59145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SUBREF__Group__5__Impl9172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group_0__0__Impl_in_rule__SUBREF__Group_0__09213 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__SUBREF__Group_0__1_in_rule__SUBREF__Group_0__09216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SUBREF__Group_0__0__Impl9243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group_0__1__Impl_in_rule__SUBREF__Group_0__19272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__SUBREF__Group_0__1__Impl9300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group__0__Impl_in_rule__INSTANCEREF__Group__09335 = new BitSet(new long[]{0x0010020000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group__1_in_rule__INSTANCEREF__Group__09338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__INSTANCEREF__Group__0__Impl9365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group__1__Impl_in_rule__INSTANCEREF__Group__19394 = new BitSet(new long[]{0x0010020000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group__2_in_rule__INSTANCEREF__Group__19397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_1__0_in_rule__INSTANCEREF__Group__1__Impl9424 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group__2__Impl_in_rule__INSTANCEREF__Group__29455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2__0_in_rule__INSTANCEREF__Group__2__Impl9482 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_1__0__Impl_in_rule__INSTANCEREF__Group_1__09519 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_1__1_in_rule__INSTANCEREF__Group_1__09522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__INSTANCEREF__Group_1__0__Impl9550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_1__1__Impl_in_rule__INSTANCEREF__Group_1__19581 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_1__2_in_rule__INSTANCEREF__Group_1__19584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_rule__INSTANCEREF__Group_1__1__Impl9611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_1__2__Impl_in_rule__INSTANCEREF__Group_1__29640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__INSTANCEREF__Group_1__2__Impl9668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2__0__Impl_in_rule__INSTANCEREF__Group_2__09705 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2__1_in_rule__INSTANCEREF__Group_2__09708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__INSTANCEREF__Group_2__0__Impl9736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2__1__Impl_in_rule__INSTANCEREF__Group_2__19767 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2__2_in_rule__INSTANCEREF__Group_2__19770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__INSTANCEREF__Group_2__1__Impl9797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2__2__Impl_in_rule__INSTANCEREF__Group_2__29826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2_2__0_in_rule__INSTANCEREF__Group_2__2__Impl9853 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2_2__0__Impl_in_rule__INSTANCEREF__Group_2_2__09890 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2_2__1_in_rule__INSTANCEREF__Group_2_2__09893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__INSTANCEREF__Group_2_2__0__Impl9921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2_2__1__Impl_in_rule__INSTANCEREF__Group_2_2__19952 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2_2__2_in_rule__INSTANCEREF__Group_2_2__19955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_rule__INSTANCEREF__Group_2_2__1__Impl9982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREF__Group_2_2__2__Impl_in_rule__INSTANCEREF__Group_2_2__210011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__INSTANCEREF__Group_2_2__2__Impl10039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__0__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1__010076 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__1_in_rule__INSTANCEREFWITHPARENT__Group_1__010079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__INSTANCEREFWITHPARENT__Group_1__0__Impl10106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__1__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1__110135 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__2_in_rule__INSTANCEREFWITHPARENT__Group_1__110138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__0_in_rule__INSTANCEREFWITHPARENT__Group_1__1__Impl10167 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__0_in_rule__INSTANCEREFWITHPARENT__Group_1__1__Impl10179 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1__2__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1__210212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__0_in_rule__INSTANCEREFWITHPARENT__Group_1__2__Impl10239 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__0__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_1__010276 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__1_in_rule__INSTANCEREFWITHPARENT__Group_1_1__010279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__INSTANCEREFWITHPARENT__Group_1_1__0__Impl10307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__1__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_1__110338 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__2_in_rule__INSTANCEREFWITHPARENT__Group_1_1__110341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_rule__INSTANCEREFWITHPARENT__Group_1_1__1__Impl10368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_1__2__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_1__210397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__INSTANCEREFWITHPARENT__Group_1_1__2__Impl10425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__0__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2__010462 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__1_in_rule__INSTANCEREFWITHPARENT__Group_1_2__010465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__INSTANCEREFWITHPARENT__Group_1_2__0__Impl10493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__1__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2__110524 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__2_in_rule__INSTANCEREFWITHPARENT__Group_1_2__110527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__INSTANCEREFWITHPARENT__Group_1_2__1__Impl10554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2__210583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__0_in_rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl10612 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__0_in_rule__INSTANCEREFWITHPARENT__Group_1_2__2__Impl10624 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__0__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__010663 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__1_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__010666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__0__Impl10694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__1__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__110725 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__2_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__110728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__1__Impl10755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__INSTANCEREFWITHPARENT__Group_1_2_2__2__Impl_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__210784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__INSTANCEREFWITHPARENT__Group_1_2_2__2__Impl10812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CONNINSTREF__Group__0__Impl_in_rule__CONNINSTREF__Group__010849 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__CONNINSTREF__Group__1_in_rule__CONNINSTREF__Group__010852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CONNINSTREF__Group_0__0_in_rule__CONNINSTREF__Group__0__Impl10879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CONNINSTREF__Group__1__Impl_in_rule__CONNINSTREF__Group__110910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_rule__CONNINSTREF__Group__1__Impl10937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CONNINSTREF__Group_0__0__Impl_in_rule__CONNINSTREF__Group_0__010970 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__CONNINSTREF__Group_0__1_in_rule__CONNINSTREF__Group_0__010973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_rule__CONNINSTREF__Group_0__0__Impl11000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CONNINSTREF__Group_0__1__Impl_in_rule__CONNINSTREF__Group_0__111029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__CONNINSTREF__Group_0__1__Impl11057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_rule__SystemInstance__CategoryAssignment_011097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SystemInstance__NameAssignment_111128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIMPLREF_in_rule__SystemInstance__ComponentImplementationAssignment_311163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_rule__SystemInstance__FeatureInstanceAssignment_5_011198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_rule__SystemInstance__ComponentInstanceAssignment_5_111229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_rule__SystemInstance__ConnectionInstanceAssignment_5_211260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_rule__SystemInstance__SystemOperationModeAssignment_5_311291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_rule__FeatureInstance__DirectionAssignment_011322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_rule__FeatureInstance__CategoryAssignment_111353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FeatureInstance__NameAssignment_211384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_rule__FeatureInstance__IndexAssignment_3_111415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFEATREF_in_rule__FeatureInstance__FeatureAssignment_511450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_rule__FeatureInstance__SrcConnectionInstanceAssignment_6_311489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_rule__FeatureInstance__SrcConnectionInstanceAssignment_6_4_111528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_rule__FeatureInstance__DstConnectionInstanceAssignment_7_311567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_rule__FeatureInstance__DstConnectionInstanceAssignment_7_4_111606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_rule__FeatureInstance__FeatureInstanceAssignment_8_111641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_rule__ComponentInstance__CategoryAssignment_011672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ComponentInstance__NameAssignment_111703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_rule__ComponentInstance__IndexAssignment_2_111734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSUBREF_in_rule__ComponentInstance__SubcomponentAssignment_411769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_rule__ComponentInstance__SrcConnectionInstanceAssignment_5_311808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_rule__ComponentInstance__SrcConnectionInstanceAssignment_5_4_111847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_rule__ComponentInstance__DstConnectionInstanceAssignment_6_311886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_rule__ComponentInstance__DstConnectionInstanceAssignment_6_4_111925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_rule__ComponentInstance__FeatureInstanceAssignment_7_1_011960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_rule__ComponentInstance__ComponentInstanceAssignment_7_1_111991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_rule__ComponentInstance__ConnectionInstanceAssignment_7_1_212022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__ConnectionInstance__CompleteAssignment_012058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionKind_in_rule__ConnectionInstance__KindAssignment_112097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ConnectionInstance__NameAssignment_212128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__SourceAssignment_412163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_rule__ConnectionInstance__BidirectionalAssignment_5_012203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionInstance__DestinationAssignment_612246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionReference_in_rule__ConnectionInstance__ConnectionReferenceAssignment_812281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__SourceAssignment_012316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_rule__ConnectionReference__DestinationAssignment_212355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSUBREF_in_rule__ConnectionReference__ConnectionAssignment_412394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREFWITHPARENT_in_rule__ConnectionReference__ContextAssignment_612433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__SystemOperationMode__NameAssignment_112468 = new BitSet(new long[]{0x0000000000000002L});

}