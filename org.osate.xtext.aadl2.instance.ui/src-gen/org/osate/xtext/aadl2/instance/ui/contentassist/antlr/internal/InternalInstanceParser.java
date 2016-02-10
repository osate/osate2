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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_LONG", "RULE_STRING", "RULE_SL_COMMENT", "RULE_WS", "'in'", "'out'", "'dataPort'", "'eventPort'", "'eventDataPort'", "'parameter'", "'busAccess'", "'subprogramAccess'", "'subprogramGroupAccess'", "'featureGroup'", "'abstractFeature'", "'abstract'", "'bus'", "'data'", "'device'", "'memory'", "'process'", "'processor'", "'subprogram'", "'system'", "'thread'", "':'", "'{'", "'}'", "'['", "']'", "'som'", "'group'", "'virtual'", "'.'", "'::'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=7;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__10=10;
    public static final int T__32=32;
    public static final int T__9=9;
    public static final int RULE_ID=4;
    public static final int RULE_WS=8;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
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


    // $ANTLR start "entryRuleSystemOperationMode"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:144:1: entryRuleSystemOperationMode : ruleSystemOperationMode EOF ;
    public final void entryRuleSystemOperationMode() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:145:1: ( ruleSystemOperationMode EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:146:1: ruleSystemOperationMode EOF
            {
             before(grammarAccess.getSystemOperationModeRule()); 
            pushFollow(FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode241);
            ruleSystemOperationMode();

            state._fsp--;

             after(grammarAccess.getSystemOperationModeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemOperationMode248); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:153:1: ruleSystemOperationMode : ( ( rule__SystemOperationMode__Group__0 ) ) ;
    public final void ruleSystemOperationMode() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:157:2: ( ( ( rule__SystemOperationMode__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:158:1: ( ( rule__SystemOperationMode__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:158:1: ( ( rule__SystemOperationMode__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:159:1: ( rule__SystemOperationMode__Group__0 )
            {
             before(grammarAccess.getSystemOperationModeAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:160:1: ( rule__SystemOperationMode__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:160:2: rule__SystemOperationMode__Group__0
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__Group__0_in_ruleSystemOperationMode274);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:172:1: entryRuleDirectionType : ruleDirectionType EOF ;
    public final void entryRuleDirectionType() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:173:1: ( ruleDirectionType EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:174:1: ruleDirectionType EOF
            {
             before(grammarAccess.getDirectionTypeRule()); 
            pushFollow(FOLLOW_ruleDirectionType_in_entryRuleDirectionType301);
            ruleDirectionType();

            state._fsp--;

             after(grammarAccess.getDirectionTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDirectionType308); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:181:1: ruleDirectionType : ( ( rule__DirectionType__Alternatives ) ) ;
    public final void ruleDirectionType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:185:2: ( ( ( rule__DirectionType__Alternatives ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:186:1: ( ( rule__DirectionType__Alternatives ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:186:1: ( ( rule__DirectionType__Alternatives ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:187:1: ( rule__DirectionType__Alternatives )
            {
             before(grammarAccess.getDirectionTypeAccess().getAlternatives()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:188:1: ( rule__DirectionType__Alternatives )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:188:2: rule__DirectionType__Alternatives
            {
            pushFollow(FOLLOW_rule__DirectionType__Alternatives_in_ruleDirectionType334);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:200:1: entryRuleFeatureCategory : ruleFeatureCategory EOF ;
    public final void entryRuleFeatureCategory() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:201:1: ( ruleFeatureCategory EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:202:1: ruleFeatureCategory EOF
            {
             before(grammarAccess.getFeatureCategoryRule()); 
            pushFollow(FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory361);
            ruleFeatureCategory();

            state._fsp--;

             after(grammarAccess.getFeatureCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCategory368); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:209:1: ruleFeatureCategory : ( ( rule__FeatureCategory__Alternatives ) ) ;
    public final void ruleFeatureCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:213:2: ( ( ( rule__FeatureCategory__Alternatives ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:214:1: ( ( rule__FeatureCategory__Alternatives ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:214:1: ( ( rule__FeatureCategory__Alternatives ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:215:1: ( rule__FeatureCategory__Alternatives )
            {
             before(grammarAccess.getFeatureCategoryAccess().getAlternatives()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:216:1: ( rule__FeatureCategory__Alternatives )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:216:2: rule__FeatureCategory__Alternatives
            {
            pushFollow(FOLLOW_rule__FeatureCategory__Alternatives_in_ruleFeatureCategory394);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:228:1: entryRuleComponentCategory : ruleComponentCategory EOF ;
    public final void entryRuleComponentCategory() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:229:1: ( ruleComponentCategory EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:230:1: ruleComponentCategory EOF
            {
             before(grammarAccess.getComponentCategoryRule()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory421);
            ruleComponentCategory();

            state._fsp--;

             after(grammarAccess.getComponentCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentCategory428); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:237:1: ruleComponentCategory : ( ( rule__ComponentCategory__Alternatives ) ) ;
    public final void ruleComponentCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:241:2: ( ( ( rule__ComponentCategory__Alternatives ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:242:1: ( ( rule__ComponentCategory__Alternatives ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:242:1: ( ( rule__ComponentCategory__Alternatives ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:243:1: ( rule__ComponentCategory__Alternatives )
            {
             before(grammarAccess.getComponentCategoryAccess().getAlternatives()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:244:1: ( rule__ComponentCategory__Alternatives )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:244:2: rule__ComponentCategory__Alternatives
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Alternatives_in_ruleComponentCategory454);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:256:1: entryRuleIMPLREF : ruleIMPLREF EOF ;
    public final void entryRuleIMPLREF() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:257:1: ( ruleIMPLREF EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:258:1: ruleIMPLREF EOF
            {
             before(grammarAccess.getIMPLREFRule()); 
            pushFollow(FOLLOW_ruleIMPLREF_in_entryRuleIMPLREF481);
            ruleIMPLREF();

            state._fsp--;

             after(grammarAccess.getIMPLREFRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIMPLREF488); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:265:1: ruleIMPLREF : ( ( rule__IMPLREF__Group__0 ) ) ;
    public final void ruleIMPLREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:269:2: ( ( ( rule__IMPLREF__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:270:1: ( ( rule__IMPLREF__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:270:1: ( ( rule__IMPLREF__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:271:1: ( rule__IMPLREF__Group__0 )
            {
             before(grammarAccess.getIMPLREFAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:272:1: ( rule__IMPLREF__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:272:2: rule__IMPLREF__Group__0
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group__0_in_ruleIMPLREF514);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:284:1: entryRuleFEATREF : ruleFEATREF EOF ;
    public final void entryRuleFEATREF() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:285:1: ( ruleFEATREF EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:286:1: ruleFEATREF EOF
            {
             before(grammarAccess.getFEATREFRule()); 
            pushFollow(FOLLOW_ruleFEATREF_in_entryRuleFEATREF541);
            ruleFEATREF();

            state._fsp--;

             after(grammarAccess.getFEATREFRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFEATREF548); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:293:1: ruleFEATREF : ( ( rule__FEATREF__Group__0 ) ) ;
    public final void ruleFEATREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:297:2: ( ( ( rule__FEATREF__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:298:1: ( ( rule__FEATREF__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:298:1: ( ( rule__FEATREF__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:299:1: ( rule__FEATREF__Group__0 )
            {
             before(grammarAccess.getFEATREFAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:300:1: ( rule__FEATREF__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:300:2: rule__FEATREF__Group__0
            {
            pushFollow(FOLLOW_rule__FEATREF__Group__0_in_ruleFEATREF574);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:312:1: entryRuleSUBREF : ruleSUBREF EOF ;
    public final void entryRuleSUBREF() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:313:1: ( ruleSUBREF EOF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:314:1: ruleSUBREF EOF
            {
             before(grammarAccess.getSUBREFRule()); 
            pushFollow(FOLLOW_ruleSUBREF_in_entryRuleSUBREF601);
            ruleSUBREF();

            state._fsp--;

             after(grammarAccess.getSUBREFRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSUBREF608); 

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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:321:1: ruleSUBREF : ( ( rule__SUBREF__Group__0 ) ) ;
    public final void ruleSUBREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:325:2: ( ( ( rule__SUBREF__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:326:1: ( ( rule__SUBREF__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:326:1: ( ( rule__SUBREF__Group__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:327:1: ( rule__SUBREF__Group__0 )
            {
             before(grammarAccess.getSUBREFAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:328:1: ( rule__SUBREF__Group__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:328:2: rule__SUBREF__Group__0
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__0_in_ruleSUBREF634);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:340:1: rule__SystemInstance__Alternatives_5 : ( ( ( rule__SystemInstance__FeatureInstanceAssignment_5_0 ) ) | ( ( rule__SystemInstance__ComponentInstanceAssignment_5_1 ) ) | ( ( rule__SystemInstance__SystemOperationModeAssignment_5_2 ) ) );
    public final void rule__SystemInstance__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:344:1: ( ( ( rule__SystemInstance__FeatureInstanceAssignment_5_0 ) ) | ( ( rule__SystemInstance__ComponentInstanceAssignment_5_1 ) ) | ( ( rule__SystemInstance__SystemOperationModeAssignment_5_2 ) ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 9:
            case 10:
                {
                alt1=1;
                }
                break;
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 37:
                {
                alt1=2;
                }
                break;
            case 35:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:345:1: ( ( rule__SystemInstance__FeatureInstanceAssignment_5_0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:345:1: ( ( rule__SystemInstance__FeatureInstanceAssignment_5_0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:346:1: ( rule__SystemInstance__FeatureInstanceAssignment_5_0 )
                    {
                     before(grammarAccess.getSystemInstanceAccess().getFeatureInstanceAssignment_5_0()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:347:1: ( rule__SystemInstance__FeatureInstanceAssignment_5_0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:347:2: rule__SystemInstance__FeatureInstanceAssignment_5_0
                    {
                    pushFollow(FOLLOW_rule__SystemInstance__FeatureInstanceAssignment_5_0_in_rule__SystemInstance__Alternatives_5670);
                    rule__SystemInstance__FeatureInstanceAssignment_5_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSystemInstanceAccess().getFeatureInstanceAssignment_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:351:6: ( ( rule__SystemInstance__ComponentInstanceAssignment_5_1 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:351:6: ( ( rule__SystemInstance__ComponentInstanceAssignment_5_1 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:352:1: ( rule__SystemInstance__ComponentInstanceAssignment_5_1 )
                    {
                     before(grammarAccess.getSystemInstanceAccess().getComponentInstanceAssignment_5_1()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:353:1: ( rule__SystemInstance__ComponentInstanceAssignment_5_1 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:353:2: rule__SystemInstance__ComponentInstanceAssignment_5_1
                    {
                    pushFollow(FOLLOW_rule__SystemInstance__ComponentInstanceAssignment_5_1_in_rule__SystemInstance__Alternatives_5688);
                    rule__SystemInstance__ComponentInstanceAssignment_5_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getSystemInstanceAccess().getComponentInstanceAssignment_5_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:357:6: ( ( rule__SystemInstance__SystemOperationModeAssignment_5_2 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:357:6: ( ( rule__SystemInstance__SystemOperationModeAssignment_5_2 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:358:1: ( rule__SystemInstance__SystemOperationModeAssignment_5_2 )
                    {
                     before(grammarAccess.getSystemInstanceAccess().getSystemOperationModeAssignment_5_2()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:359:1: ( rule__SystemInstance__SystemOperationModeAssignment_5_2 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:359:2: rule__SystemInstance__SystemOperationModeAssignment_5_2
                    {
                    pushFollow(FOLLOW_rule__SystemInstance__SystemOperationModeAssignment_5_2_in_rule__SystemInstance__Alternatives_5706);
                    rule__SystemInstance__SystemOperationModeAssignment_5_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getSystemInstanceAccess().getSystemOperationModeAssignment_5_2()); 

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


    // $ANTLR start "rule__ComponentInstance__Alternatives_5_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:368:1: rule__ComponentInstance__Alternatives_5_1 : ( ( ( rule__ComponentInstance__FeatureInstanceAssignment_5_1_0 ) ) | ( ( rule__ComponentInstance__ComponentInstanceAssignment_5_1_1 ) ) );
    public final void rule__ComponentInstance__Alternatives_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:372:1: ( ( ( rule__ComponentInstance__FeatureInstanceAssignment_5_1_0 ) ) | ( ( rule__ComponentInstance__ComponentInstanceAssignment_5_1_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=9 && LA2_0<=10)) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=20 && LA2_0<=29)||LA2_0==37) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:373:1: ( ( rule__ComponentInstance__FeatureInstanceAssignment_5_1_0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:373:1: ( ( rule__ComponentInstance__FeatureInstanceAssignment_5_1_0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:374:1: ( rule__ComponentInstance__FeatureInstanceAssignment_5_1_0 )
                    {
                     before(grammarAccess.getComponentInstanceAccess().getFeatureInstanceAssignment_5_1_0()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:375:1: ( rule__ComponentInstance__FeatureInstanceAssignment_5_1_0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:375:2: rule__ComponentInstance__FeatureInstanceAssignment_5_1_0
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__FeatureInstanceAssignment_5_1_0_in_rule__ComponentInstance__Alternatives_5_1739);
                    rule__ComponentInstance__FeatureInstanceAssignment_5_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentInstanceAccess().getFeatureInstanceAssignment_5_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:379:6: ( ( rule__ComponentInstance__ComponentInstanceAssignment_5_1_1 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:379:6: ( ( rule__ComponentInstance__ComponentInstanceAssignment_5_1_1 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:380:1: ( rule__ComponentInstance__ComponentInstanceAssignment_5_1_1 )
                    {
                     before(grammarAccess.getComponentInstanceAccess().getComponentInstanceAssignment_5_1_1()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:381:1: ( rule__ComponentInstance__ComponentInstanceAssignment_5_1_1 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:381:2: rule__ComponentInstance__ComponentInstanceAssignment_5_1_1
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__ComponentInstanceAssignment_5_1_1_in_rule__ComponentInstance__Alternatives_5_1757);
                    rule__ComponentInstance__ComponentInstanceAssignment_5_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentInstanceAccess().getComponentInstanceAssignment_5_1_1()); 

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
    // $ANTLR end "rule__ComponentInstance__Alternatives_5_1"


    // $ANTLR start "rule__DirectionType__Alternatives"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:390:1: rule__DirectionType__Alternatives : ( ( 'in' ) | ( 'out' ) | ( ( rule__DirectionType__Group_2__0 ) ) );
    public final void rule__DirectionType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:394:1: ( ( 'in' ) | ( 'out' ) | ( ( rule__DirectionType__Group_2__0 ) ) )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==9) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==10) ) {
                    alt3=3;
                }
                else if ( (LA3_1==EOF||(LA3_1>=11 && LA3_1<=19)) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA3_0==10) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:395:1: ( 'in' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:395:1: ( 'in' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:396:1: 'in'
                    {
                     before(grammarAccess.getDirectionTypeAccess().getInKeyword_0()); 
                    match(input,9,FOLLOW_9_in_rule__DirectionType__Alternatives791); 
                     after(grammarAccess.getDirectionTypeAccess().getInKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:403:6: ( 'out' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:403:6: ( 'out' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:404:1: 'out'
                    {
                     before(grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); 
                    match(input,10,FOLLOW_10_in_rule__DirectionType__Alternatives811); 
                     after(grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:411:6: ( ( rule__DirectionType__Group_2__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:411:6: ( ( rule__DirectionType__Group_2__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:412:1: ( rule__DirectionType__Group_2__0 )
                    {
                     before(grammarAccess.getDirectionTypeAccess().getGroup_2()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:413:1: ( rule__DirectionType__Group_2__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:413:2: rule__DirectionType__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__DirectionType__Group_2__0_in_rule__DirectionType__Alternatives830);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:422:1: rule__FeatureCategory__Alternatives : ( ( 'dataPort' ) | ( 'eventPort' ) | ( 'eventDataPort' ) | ( 'parameter' ) | ( 'busAccess' ) | ( 'subprogramAccess' ) | ( 'subprogramGroupAccess' ) | ( 'featureGroup' ) | ( 'abstractFeature' ) );
    public final void rule__FeatureCategory__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:426:1: ( ( 'dataPort' ) | ( 'eventPort' ) | ( 'eventDataPort' ) | ( 'parameter' ) | ( 'busAccess' ) | ( 'subprogramAccess' ) | ( 'subprogramGroupAccess' ) | ( 'featureGroup' ) | ( 'abstractFeature' ) )
            int alt4=9;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt4=1;
                }
                break;
            case 12:
                {
                alt4=2;
                }
                break;
            case 13:
                {
                alt4=3;
                }
                break;
            case 14:
                {
                alt4=4;
                }
                break;
            case 15:
                {
                alt4=5;
                }
                break;
            case 16:
                {
                alt4=6;
                }
                break;
            case 17:
                {
                alt4=7;
                }
                break;
            case 18:
                {
                alt4=8;
                }
                break;
            case 19:
                {
                alt4=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:427:1: ( 'dataPort' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:427:1: ( 'dataPort' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:428:1: 'dataPort'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getDataPortKeyword_0()); 
                    match(input,11,FOLLOW_11_in_rule__FeatureCategory__Alternatives864); 
                     after(grammarAccess.getFeatureCategoryAccess().getDataPortKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:435:6: ( 'eventPort' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:435:6: ( 'eventPort' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:436:1: 'eventPort'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getEventPortKeyword_1()); 
                    match(input,12,FOLLOW_12_in_rule__FeatureCategory__Alternatives884); 
                     after(grammarAccess.getFeatureCategoryAccess().getEventPortKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:443:6: ( 'eventDataPort' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:443:6: ( 'eventDataPort' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:444:1: 'eventDataPort'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getEventDataPortKeyword_2()); 
                    match(input,13,FOLLOW_13_in_rule__FeatureCategory__Alternatives904); 
                     after(grammarAccess.getFeatureCategoryAccess().getEventDataPortKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:451:6: ( 'parameter' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:451:6: ( 'parameter' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:452:1: 'parameter'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); 
                    match(input,14,FOLLOW_14_in_rule__FeatureCategory__Alternatives924); 
                     after(grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:459:6: ( 'busAccess' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:459:6: ( 'busAccess' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:460:1: 'busAccess'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getBusAccessKeyword_4()); 
                    match(input,15,FOLLOW_15_in_rule__FeatureCategory__Alternatives944); 
                     after(grammarAccess.getFeatureCategoryAccess().getBusAccessKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:467:6: ( 'subprogramAccess' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:467:6: ( 'subprogramAccess' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:468:1: 'subprogramAccess'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getSubprogramAccessKeyword_5()); 
                    match(input,16,FOLLOW_16_in_rule__FeatureCategory__Alternatives964); 
                     after(grammarAccess.getFeatureCategoryAccess().getSubprogramAccessKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:475:6: ( 'subprogramGroupAccess' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:475:6: ( 'subprogramGroupAccess' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:476:1: 'subprogramGroupAccess'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getSubprogramGroupAccessKeyword_6()); 
                    match(input,17,FOLLOW_17_in_rule__FeatureCategory__Alternatives984); 
                     after(grammarAccess.getFeatureCategoryAccess().getSubprogramGroupAccessKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:483:6: ( 'featureGroup' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:483:6: ( 'featureGroup' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:484:1: 'featureGroup'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getFeatureGroupKeyword_7()); 
                    match(input,18,FOLLOW_18_in_rule__FeatureCategory__Alternatives1004); 
                     after(grammarAccess.getFeatureCategoryAccess().getFeatureGroupKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:491:6: ( 'abstractFeature' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:491:6: ( 'abstractFeature' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:492:1: 'abstractFeature'
                    {
                     before(grammarAccess.getFeatureCategoryAccess().getAbstractFeatureKeyword_8()); 
                    match(input,19,FOLLOW_19_in_rule__FeatureCategory__Alternatives1024); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:504:1: rule__ComponentCategory__Alternatives : ( ( 'abstract' ) | ( 'bus' ) | ( 'data' ) | ( 'device' ) | ( 'memory' ) | ( 'process' ) | ( 'processor' ) | ( 'subprogram' ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( 'system' ) | ( ( rule__ComponentCategory__Group_10__0 ) ) | ( 'thread' ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( ( rule__ComponentCategory__Group_13__0 ) ) );
    public final void rule__ComponentCategory__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:508:1: ( ( 'abstract' ) | ( 'bus' ) | ( 'data' ) | ( 'device' ) | ( 'memory' ) | ( 'process' ) | ( 'processor' ) | ( 'subprogram' ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( 'system' ) | ( ( rule__ComponentCategory__Group_10__0 ) ) | ( 'thread' ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( ( rule__ComponentCategory__Group_13__0 ) ) )
            int alt5=14;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:509:1: ( 'abstract' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:509:1: ( 'abstract' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:510:1: 'abstract'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
                    match(input,20,FOLLOW_20_in_rule__ComponentCategory__Alternatives1059); 
                     after(grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:517:6: ( 'bus' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:517:6: ( 'bus' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:518:1: 'bus'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
                    match(input,21,FOLLOW_21_in_rule__ComponentCategory__Alternatives1079); 
                     after(grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:525:6: ( 'data' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:525:6: ( 'data' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:526:1: 'data'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
                    match(input,22,FOLLOW_22_in_rule__ComponentCategory__Alternatives1099); 
                     after(grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:533:6: ( 'device' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:533:6: ( 'device' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:534:1: 'device'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
                    match(input,23,FOLLOW_23_in_rule__ComponentCategory__Alternatives1119); 
                     after(grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:541:6: ( 'memory' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:541:6: ( 'memory' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:542:1: 'memory'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
                    match(input,24,FOLLOW_24_in_rule__ComponentCategory__Alternatives1139); 
                     after(grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:549:6: ( 'process' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:549:6: ( 'process' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:550:1: 'process'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
                    match(input,25,FOLLOW_25_in_rule__ComponentCategory__Alternatives1159); 
                     after(grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:557:6: ( 'processor' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:557:6: ( 'processor' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:558:1: 'processor'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
                    match(input,26,FOLLOW_26_in_rule__ComponentCategory__Alternatives1179); 
                     after(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:565:6: ( 'subprogram' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:565:6: ( 'subprogram' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:566:1: 'subprogram'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
                    match(input,27,FOLLOW_27_in_rule__ComponentCategory__Alternatives1199); 
                     after(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:573:6: ( ( rule__ComponentCategory__Group_8__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:573:6: ( ( rule__ComponentCategory__Group_8__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:574:1: ( rule__ComponentCategory__Group_8__0 )
                    {
                     before(grammarAccess.getComponentCategoryAccess().getGroup_8()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:575:1: ( rule__ComponentCategory__Group_8__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:575:2: rule__ComponentCategory__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__ComponentCategory__Group_8__0_in_rule__ComponentCategory__Alternatives1218);
                    rule__ComponentCategory__Group_8__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentCategoryAccess().getGroup_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:579:6: ( 'system' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:579:6: ( 'system' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:580:1: 'system'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
                    match(input,28,FOLLOW_28_in_rule__ComponentCategory__Alternatives1237); 
                     after(grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:587:6: ( ( rule__ComponentCategory__Group_10__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:587:6: ( ( rule__ComponentCategory__Group_10__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:588:1: ( rule__ComponentCategory__Group_10__0 )
                    {
                     before(grammarAccess.getComponentCategoryAccess().getGroup_10()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:589:1: ( rule__ComponentCategory__Group_10__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:589:2: rule__ComponentCategory__Group_10__0
                    {
                    pushFollow(FOLLOW_rule__ComponentCategory__Group_10__0_in_rule__ComponentCategory__Alternatives1256);
                    rule__ComponentCategory__Group_10__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentCategoryAccess().getGroup_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:593:6: ( 'thread' )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:593:6: ( 'thread' )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:594:1: 'thread'
                    {
                     before(grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
                    match(input,29,FOLLOW_29_in_rule__ComponentCategory__Alternatives1275); 
                     after(grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:601:6: ( ( rule__ComponentCategory__Group_12__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:601:6: ( ( rule__ComponentCategory__Group_12__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:602:1: ( rule__ComponentCategory__Group_12__0 )
                    {
                     before(grammarAccess.getComponentCategoryAccess().getGroup_12()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:603:1: ( rule__ComponentCategory__Group_12__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:603:2: rule__ComponentCategory__Group_12__0
                    {
                    pushFollow(FOLLOW_rule__ComponentCategory__Group_12__0_in_rule__ComponentCategory__Alternatives1294);
                    rule__ComponentCategory__Group_12__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComponentCategoryAccess().getGroup_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:607:6: ( ( rule__ComponentCategory__Group_13__0 ) )
                    {
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:607:6: ( ( rule__ComponentCategory__Group_13__0 ) )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:608:1: ( rule__ComponentCategory__Group_13__0 )
                    {
                     before(grammarAccess.getComponentCategoryAccess().getGroup_13()); 
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:609:1: ( rule__ComponentCategory__Group_13__0 )
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:609:2: rule__ComponentCategory__Group_13__0
                    {
                    pushFollow(FOLLOW_rule__ComponentCategory__Group_13__0_in_rule__ComponentCategory__Alternatives1312);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:620:1: rule__SystemInstance__Group__0 : rule__SystemInstance__Group__0__Impl rule__SystemInstance__Group__1 ;
    public final void rule__SystemInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:624:1: ( rule__SystemInstance__Group__0__Impl rule__SystemInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:625:2: rule__SystemInstance__Group__0__Impl rule__SystemInstance__Group__1
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__0__Impl_in_rule__SystemInstance__Group__01343);
            rule__SystemInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__1_in_rule__SystemInstance__Group__01346);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:632:1: rule__SystemInstance__Group__0__Impl : ( ( rule__SystemInstance__CategoryAssignment_0 ) ) ;
    public final void rule__SystemInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:636:1: ( ( ( rule__SystemInstance__CategoryAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:637:1: ( ( rule__SystemInstance__CategoryAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:637:1: ( ( rule__SystemInstance__CategoryAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:638:1: ( rule__SystemInstance__CategoryAssignment_0 )
            {
             before(grammarAccess.getSystemInstanceAccess().getCategoryAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:639:1: ( rule__SystemInstance__CategoryAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:639:2: rule__SystemInstance__CategoryAssignment_0
            {
            pushFollow(FOLLOW_rule__SystemInstance__CategoryAssignment_0_in_rule__SystemInstance__Group__0__Impl1373);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:649:1: rule__SystemInstance__Group__1 : rule__SystemInstance__Group__1__Impl rule__SystemInstance__Group__2 ;
    public final void rule__SystemInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:653:1: ( rule__SystemInstance__Group__1__Impl rule__SystemInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:654:2: rule__SystemInstance__Group__1__Impl rule__SystemInstance__Group__2
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__1__Impl_in_rule__SystemInstance__Group__11403);
            rule__SystemInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__2_in_rule__SystemInstance__Group__11406);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:661:1: rule__SystemInstance__Group__1__Impl : ( ( rule__SystemInstance__NameAssignment_1 ) ) ;
    public final void rule__SystemInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:665:1: ( ( ( rule__SystemInstance__NameAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:666:1: ( ( rule__SystemInstance__NameAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:666:1: ( ( rule__SystemInstance__NameAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:667:1: ( rule__SystemInstance__NameAssignment_1 )
            {
             before(grammarAccess.getSystemInstanceAccess().getNameAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:668:1: ( rule__SystemInstance__NameAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:668:2: rule__SystemInstance__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SystemInstance__NameAssignment_1_in_rule__SystemInstance__Group__1__Impl1433);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:678:1: rule__SystemInstance__Group__2 : rule__SystemInstance__Group__2__Impl rule__SystemInstance__Group__3 ;
    public final void rule__SystemInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:682:1: ( rule__SystemInstance__Group__2__Impl rule__SystemInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:683:2: rule__SystemInstance__Group__2__Impl rule__SystemInstance__Group__3
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__2__Impl_in_rule__SystemInstance__Group__21463);
            rule__SystemInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__3_in_rule__SystemInstance__Group__21466);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:690:1: rule__SystemInstance__Group__2__Impl : ( ':' ) ;
    public final void rule__SystemInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:694:1: ( ( ':' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:695:1: ( ':' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:695:1: ( ':' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:696:1: ':'
            {
             before(grammarAccess.getSystemInstanceAccess().getColonKeyword_2()); 
            match(input,30,FOLLOW_30_in_rule__SystemInstance__Group__2__Impl1494); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:709:1: rule__SystemInstance__Group__3 : rule__SystemInstance__Group__3__Impl rule__SystemInstance__Group__4 ;
    public final void rule__SystemInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:713:1: ( rule__SystemInstance__Group__3__Impl rule__SystemInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:714:2: rule__SystemInstance__Group__3__Impl rule__SystemInstance__Group__4
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__3__Impl_in_rule__SystemInstance__Group__31525);
            rule__SystemInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__4_in_rule__SystemInstance__Group__31528);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:721:1: rule__SystemInstance__Group__3__Impl : ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) ) ;
    public final void rule__SystemInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:725:1: ( ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:726:1: ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:726:1: ( ( rule__SystemInstance__ComponentImplementationAssignment_3 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:727:1: ( rule__SystemInstance__ComponentImplementationAssignment_3 )
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentImplementationAssignment_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:728:1: ( rule__SystemInstance__ComponentImplementationAssignment_3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:728:2: rule__SystemInstance__ComponentImplementationAssignment_3
            {
            pushFollow(FOLLOW_rule__SystemInstance__ComponentImplementationAssignment_3_in_rule__SystemInstance__Group__3__Impl1555);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:738:1: rule__SystemInstance__Group__4 : rule__SystemInstance__Group__4__Impl rule__SystemInstance__Group__5 ;
    public final void rule__SystemInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:742:1: ( rule__SystemInstance__Group__4__Impl rule__SystemInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:743:2: rule__SystemInstance__Group__4__Impl rule__SystemInstance__Group__5
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__4__Impl_in_rule__SystemInstance__Group__41585);
            rule__SystemInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__5_in_rule__SystemInstance__Group__41588);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:750:1: rule__SystemInstance__Group__4__Impl : ( '{' ) ;
    public final void rule__SystemInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:754:1: ( ( '{' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:755:1: ( '{' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:755:1: ( '{' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:756:1: '{'
            {
             before(grammarAccess.getSystemInstanceAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,31,FOLLOW_31_in_rule__SystemInstance__Group__4__Impl1616); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:769:1: rule__SystemInstance__Group__5 : rule__SystemInstance__Group__5__Impl rule__SystemInstance__Group__6 ;
    public final void rule__SystemInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:773:1: ( rule__SystemInstance__Group__5__Impl rule__SystemInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:774:2: rule__SystemInstance__Group__5__Impl rule__SystemInstance__Group__6
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__5__Impl_in_rule__SystemInstance__Group__51647);
            rule__SystemInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemInstance__Group__6_in_rule__SystemInstance__Group__51650);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:781:1: rule__SystemInstance__Group__5__Impl : ( ( rule__SystemInstance__Alternatives_5 )* ) ;
    public final void rule__SystemInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:785:1: ( ( ( rule__SystemInstance__Alternatives_5 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:786:1: ( ( rule__SystemInstance__Alternatives_5 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:786:1: ( ( rule__SystemInstance__Alternatives_5 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:787:1: ( rule__SystemInstance__Alternatives_5 )*
            {
             before(grammarAccess.getSystemInstanceAccess().getAlternatives_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:788:1: ( rule__SystemInstance__Alternatives_5 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=9 && LA6_0<=10)||(LA6_0>=20 && LA6_0<=29)||LA6_0==35||LA6_0==37) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:788:2: rule__SystemInstance__Alternatives_5
            	    {
            	    pushFollow(FOLLOW_rule__SystemInstance__Alternatives_5_in_rule__SystemInstance__Group__5__Impl1677);
            	    rule__SystemInstance__Alternatives_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:798:1: rule__SystemInstance__Group__6 : rule__SystemInstance__Group__6__Impl ;
    public final void rule__SystemInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:802:1: ( rule__SystemInstance__Group__6__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:803:2: rule__SystemInstance__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__SystemInstance__Group__6__Impl_in_rule__SystemInstance__Group__61708);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:809:1: rule__SystemInstance__Group__6__Impl : ( '}' ) ;
    public final void rule__SystemInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:813:1: ( ( '}' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:814:1: ( '}' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:814:1: ( '}' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:815:1: '}'
            {
             before(grammarAccess.getSystemInstanceAccess().getRightCurlyBracketKeyword_6()); 
            match(input,32,FOLLOW_32_in_rule__SystemInstance__Group__6__Impl1736); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:842:1: rule__FeatureInstance__Group__0 : rule__FeatureInstance__Group__0__Impl rule__FeatureInstance__Group__1 ;
    public final void rule__FeatureInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:846:1: ( rule__FeatureInstance__Group__0__Impl rule__FeatureInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:847:2: rule__FeatureInstance__Group__0__Impl rule__FeatureInstance__Group__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__0__Impl_in_rule__FeatureInstance__Group__01781);
            rule__FeatureInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__1_in_rule__FeatureInstance__Group__01784);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:854:1: rule__FeatureInstance__Group__0__Impl : ( ( rule__FeatureInstance__DirectionAssignment_0 ) ) ;
    public final void rule__FeatureInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:858:1: ( ( ( rule__FeatureInstance__DirectionAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:859:1: ( ( rule__FeatureInstance__DirectionAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:859:1: ( ( rule__FeatureInstance__DirectionAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:860:1: ( rule__FeatureInstance__DirectionAssignment_0 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getDirectionAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:861:1: ( rule__FeatureInstance__DirectionAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:861:2: rule__FeatureInstance__DirectionAssignment_0
            {
            pushFollow(FOLLOW_rule__FeatureInstance__DirectionAssignment_0_in_rule__FeatureInstance__Group__0__Impl1811);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:871:1: rule__FeatureInstance__Group__1 : rule__FeatureInstance__Group__1__Impl rule__FeatureInstance__Group__2 ;
    public final void rule__FeatureInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:875:1: ( rule__FeatureInstance__Group__1__Impl rule__FeatureInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:876:2: rule__FeatureInstance__Group__1__Impl rule__FeatureInstance__Group__2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__1__Impl_in_rule__FeatureInstance__Group__11841);
            rule__FeatureInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__2_in_rule__FeatureInstance__Group__11844);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:883:1: rule__FeatureInstance__Group__1__Impl : ( ( rule__FeatureInstance__CategoryAssignment_1 ) ) ;
    public final void rule__FeatureInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:887:1: ( ( ( rule__FeatureInstance__CategoryAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:888:1: ( ( rule__FeatureInstance__CategoryAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:888:1: ( ( rule__FeatureInstance__CategoryAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:889:1: ( rule__FeatureInstance__CategoryAssignment_1 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getCategoryAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:890:1: ( rule__FeatureInstance__CategoryAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:890:2: rule__FeatureInstance__CategoryAssignment_1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__CategoryAssignment_1_in_rule__FeatureInstance__Group__1__Impl1871);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:900:1: rule__FeatureInstance__Group__2 : rule__FeatureInstance__Group__2__Impl rule__FeatureInstance__Group__3 ;
    public final void rule__FeatureInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:904:1: ( rule__FeatureInstance__Group__2__Impl rule__FeatureInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:905:2: rule__FeatureInstance__Group__2__Impl rule__FeatureInstance__Group__3
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__2__Impl_in_rule__FeatureInstance__Group__21901);
            rule__FeatureInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__3_in_rule__FeatureInstance__Group__21904);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:912:1: rule__FeatureInstance__Group__2__Impl : ( ( rule__FeatureInstance__NameAssignment_2 ) ) ;
    public final void rule__FeatureInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:916:1: ( ( ( rule__FeatureInstance__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:917:1: ( ( rule__FeatureInstance__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:917:1: ( ( rule__FeatureInstance__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:918:1: ( rule__FeatureInstance__NameAssignment_2 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:919:1: ( rule__FeatureInstance__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:919:2: rule__FeatureInstance__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__NameAssignment_2_in_rule__FeatureInstance__Group__2__Impl1931);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:929:1: rule__FeatureInstance__Group__3 : rule__FeatureInstance__Group__3__Impl rule__FeatureInstance__Group__4 ;
    public final void rule__FeatureInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:933:1: ( rule__FeatureInstance__Group__3__Impl rule__FeatureInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:934:2: rule__FeatureInstance__Group__3__Impl rule__FeatureInstance__Group__4
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__3__Impl_in_rule__FeatureInstance__Group__31961);
            rule__FeatureInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__4_in_rule__FeatureInstance__Group__31964);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:941:1: rule__FeatureInstance__Group__3__Impl : ( ( rule__FeatureInstance__Group_3__0 )? ) ;
    public final void rule__FeatureInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:945:1: ( ( ( rule__FeatureInstance__Group_3__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:946:1: ( ( rule__FeatureInstance__Group_3__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:946:1: ( ( rule__FeatureInstance__Group_3__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:947:1: ( rule__FeatureInstance__Group_3__0 )?
            {
             before(grammarAccess.getFeatureInstanceAccess().getGroup_3()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:948:1: ( rule__FeatureInstance__Group_3__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==33) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:948:2: rule__FeatureInstance__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__FeatureInstance__Group_3__0_in_rule__FeatureInstance__Group__3__Impl1991);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:958:1: rule__FeatureInstance__Group__4 : rule__FeatureInstance__Group__4__Impl rule__FeatureInstance__Group__5 ;
    public final void rule__FeatureInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:962:1: ( rule__FeatureInstance__Group__4__Impl rule__FeatureInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:963:2: rule__FeatureInstance__Group__4__Impl rule__FeatureInstance__Group__5
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__4__Impl_in_rule__FeatureInstance__Group__42022);
            rule__FeatureInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__5_in_rule__FeatureInstance__Group__42025);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:970:1: rule__FeatureInstance__Group__4__Impl : ( ':' ) ;
    public final void rule__FeatureInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:974:1: ( ( ':' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:975:1: ( ':' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:975:1: ( ':' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:976:1: ':'
            {
             before(grammarAccess.getFeatureInstanceAccess().getColonKeyword_4()); 
            match(input,30,FOLLOW_30_in_rule__FeatureInstance__Group__4__Impl2053); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:989:1: rule__FeatureInstance__Group__5 : rule__FeatureInstance__Group__5__Impl rule__FeatureInstance__Group__6 ;
    public final void rule__FeatureInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:993:1: ( rule__FeatureInstance__Group__5__Impl rule__FeatureInstance__Group__6 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:994:2: rule__FeatureInstance__Group__5__Impl rule__FeatureInstance__Group__6
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__5__Impl_in_rule__FeatureInstance__Group__52084);
            rule__FeatureInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group__6_in_rule__FeatureInstance__Group__52087);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1001:1: rule__FeatureInstance__Group__5__Impl : ( ( rule__FeatureInstance__FeatureAssignment_5 ) ) ;
    public final void rule__FeatureInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1005:1: ( ( ( rule__FeatureInstance__FeatureAssignment_5 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1006:1: ( ( rule__FeatureInstance__FeatureAssignment_5 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1006:1: ( ( rule__FeatureInstance__FeatureAssignment_5 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1007:1: ( rule__FeatureInstance__FeatureAssignment_5 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureAssignment_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1008:1: ( rule__FeatureInstance__FeatureAssignment_5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1008:2: rule__FeatureInstance__FeatureAssignment_5
            {
            pushFollow(FOLLOW_rule__FeatureInstance__FeatureAssignment_5_in_rule__FeatureInstance__Group__5__Impl2114);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1018:1: rule__FeatureInstance__Group__6 : rule__FeatureInstance__Group__6__Impl ;
    public final void rule__FeatureInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1022:1: ( rule__FeatureInstance__Group__6__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1023:2: rule__FeatureInstance__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group__6__Impl_in_rule__FeatureInstance__Group__62144);
            rule__FeatureInstance__Group__6__Impl();

            state._fsp--;


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1029:1: rule__FeatureInstance__Group__6__Impl : ( ( rule__FeatureInstance__Group_6__0 )? ) ;
    public final void rule__FeatureInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1033:1: ( ( ( rule__FeatureInstance__Group_6__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1034:1: ( ( rule__FeatureInstance__Group_6__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1034:1: ( ( rule__FeatureInstance__Group_6__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1035:1: ( rule__FeatureInstance__Group_6__0 )?
            {
             before(grammarAccess.getFeatureInstanceAccess().getGroup_6()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1036:1: ( rule__FeatureInstance__Group_6__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==31) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1036:2: rule__FeatureInstance__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__FeatureInstance__Group_6__0_in_rule__FeatureInstance__Group__6__Impl2171);
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


    // $ANTLR start "rule__FeatureInstance__Group_3__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1060:1: rule__FeatureInstance__Group_3__0 : rule__FeatureInstance__Group_3__0__Impl rule__FeatureInstance__Group_3__1 ;
    public final void rule__FeatureInstance__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1064:1: ( rule__FeatureInstance__Group_3__0__Impl rule__FeatureInstance__Group_3__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1065:2: rule__FeatureInstance__Group_3__0__Impl rule__FeatureInstance__Group_3__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__0__Impl_in_rule__FeatureInstance__Group_3__02216);
            rule__FeatureInstance__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__1_in_rule__FeatureInstance__Group_3__02219);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1072:1: rule__FeatureInstance__Group_3__0__Impl : ( '[' ) ;
    public final void rule__FeatureInstance__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1076:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1077:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1077:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1078:1: '['
            {
             before(grammarAccess.getFeatureInstanceAccess().getLeftSquareBracketKeyword_3_0()); 
            match(input,33,FOLLOW_33_in_rule__FeatureInstance__Group_3__0__Impl2247); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1091:1: rule__FeatureInstance__Group_3__1 : rule__FeatureInstance__Group_3__1__Impl rule__FeatureInstance__Group_3__2 ;
    public final void rule__FeatureInstance__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1095:1: ( rule__FeatureInstance__Group_3__1__Impl rule__FeatureInstance__Group_3__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1096:2: rule__FeatureInstance__Group_3__1__Impl rule__FeatureInstance__Group_3__2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__1__Impl_in_rule__FeatureInstance__Group_3__12278);
            rule__FeatureInstance__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__2_in_rule__FeatureInstance__Group_3__12281);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1103:1: rule__FeatureInstance__Group_3__1__Impl : ( ( rule__FeatureInstance__IndexAssignment_3_1 ) ) ;
    public final void rule__FeatureInstance__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1107:1: ( ( ( rule__FeatureInstance__IndexAssignment_3_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1108:1: ( ( rule__FeatureInstance__IndexAssignment_3_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1108:1: ( ( rule__FeatureInstance__IndexAssignment_3_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1109:1: ( rule__FeatureInstance__IndexAssignment_3_1 )
            {
             before(grammarAccess.getFeatureInstanceAccess().getIndexAssignment_3_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1110:1: ( rule__FeatureInstance__IndexAssignment_3_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1110:2: rule__FeatureInstance__IndexAssignment_3_1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__IndexAssignment_3_1_in_rule__FeatureInstance__Group_3__1__Impl2308);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1120:1: rule__FeatureInstance__Group_3__2 : rule__FeatureInstance__Group_3__2__Impl ;
    public final void rule__FeatureInstance__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1124:1: ( rule__FeatureInstance__Group_3__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1125:2: rule__FeatureInstance__Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_3__2__Impl_in_rule__FeatureInstance__Group_3__22338);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1131:1: rule__FeatureInstance__Group_3__2__Impl : ( ']' ) ;
    public final void rule__FeatureInstance__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1135:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1136:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1136:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1137:1: ']'
            {
             before(grammarAccess.getFeatureInstanceAccess().getRightSquareBracketKeyword_3_2()); 
            match(input,34,FOLLOW_34_in_rule__FeatureInstance__Group_3__2__Impl2366); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1156:1: rule__FeatureInstance__Group_6__0 : rule__FeatureInstance__Group_6__0__Impl rule__FeatureInstance__Group_6__1 ;
    public final void rule__FeatureInstance__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1160:1: ( rule__FeatureInstance__Group_6__0__Impl rule__FeatureInstance__Group_6__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1161:2: rule__FeatureInstance__Group_6__0__Impl rule__FeatureInstance__Group_6__1
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__0__Impl_in_rule__FeatureInstance__Group_6__02403);
            rule__FeatureInstance__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__1_in_rule__FeatureInstance__Group_6__02406);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1168:1: rule__FeatureInstance__Group_6__0__Impl : ( '{' ) ;
    public final void rule__FeatureInstance__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1172:1: ( ( '{' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1173:1: ( '{' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1173:1: ( '{' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1174:1: '{'
            {
             before(grammarAccess.getFeatureInstanceAccess().getLeftCurlyBracketKeyword_6_0()); 
            match(input,31,FOLLOW_31_in_rule__FeatureInstance__Group_6__0__Impl2434); 
             after(grammarAccess.getFeatureInstanceAccess().getLeftCurlyBracketKeyword_6_0()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1187:1: rule__FeatureInstance__Group_6__1 : rule__FeatureInstance__Group_6__1__Impl rule__FeatureInstance__Group_6__2 ;
    public final void rule__FeatureInstance__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1191:1: ( rule__FeatureInstance__Group_6__1__Impl rule__FeatureInstance__Group_6__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1192:2: rule__FeatureInstance__Group_6__1__Impl rule__FeatureInstance__Group_6__2
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__1__Impl_in_rule__FeatureInstance__Group_6__12465);
            rule__FeatureInstance__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__2_in_rule__FeatureInstance__Group_6__12468);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1199:1: rule__FeatureInstance__Group_6__1__Impl : ( ( rule__FeatureInstance__FeatureInstanceAssignment_6_1 )* ) ;
    public final void rule__FeatureInstance__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1203:1: ( ( ( rule__FeatureInstance__FeatureInstanceAssignment_6_1 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1204:1: ( ( rule__FeatureInstance__FeatureInstanceAssignment_6_1 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1204:1: ( ( rule__FeatureInstance__FeatureInstanceAssignment_6_1 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1205:1: ( rule__FeatureInstance__FeatureInstanceAssignment_6_1 )*
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceAssignment_6_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1206:1: ( rule__FeatureInstance__FeatureInstanceAssignment_6_1 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=9 && LA9_0<=10)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1206:2: rule__FeatureInstance__FeatureInstanceAssignment_6_1
            	    {
            	    pushFollow(FOLLOW_rule__FeatureInstance__FeatureInstanceAssignment_6_1_in_rule__FeatureInstance__Group_6__1__Impl2495);
            	    rule__FeatureInstance__FeatureInstanceAssignment_6_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceAssignment_6_1()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1216:1: rule__FeatureInstance__Group_6__2 : rule__FeatureInstance__Group_6__2__Impl ;
    public final void rule__FeatureInstance__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1220:1: ( rule__FeatureInstance__Group_6__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1221:2: rule__FeatureInstance__Group_6__2__Impl
            {
            pushFollow(FOLLOW_rule__FeatureInstance__Group_6__2__Impl_in_rule__FeatureInstance__Group_6__22526);
            rule__FeatureInstance__Group_6__2__Impl();

            state._fsp--;


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1227:1: rule__FeatureInstance__Group_6__2__Impl : ( '}' ) ;
    public final void rule__FeatureInstance__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1231:1: ( ( '}' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1232:1: ( '}' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1232:1: ( '}' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1233:1: '}'
            {
             before(grammarAccess.getFeatureInstanceAccess().getRightCurlyBracketKeyword_6_2()); 
            match(input,32,FOLLOW_32_in_rule__FeatureInstance__Group_6__2__Impl2554); 
             after(grammarAccess.getFeatureInstanceAccess().getRightCurlyBracketKeyword_6_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__ComponentInstance__Group__0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1252:1: rule__ComponentInstance__Group__0 : rule__ComponentInstance__Group__0__Impl rule__ComponentInstance__Group__1 ;
    public final void rule__ComponentInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1256:1: ( rule__ComponentInstance__Group__0__Impl rule__ComponentInstance__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1257:2: rule__ComponentInstance__Group__0__Impl rule__ComponentInstance__Group__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__0__Impl_in_rule__ComponentInstance__Group__02591);
            rule__ComponentInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__1_in_rule__ComponentInstance__Group__02594);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1264:1: rule__ComponentInstance__Group__0__Impl : ( ( rule__ComponentInstance__CategoryAssignment_0 ) ) ;
    public final void rule__ComponentInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1268:1: ( ( ( rule__ComponentInstance__CategoryAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1269:1: ( ( rule__ComponentInstance__CategoryAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1269:1: ( ( rule__ComponentInstance__CategoryAssignment_0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1270:1: ( rule__ComponentInstance__CategoryAssignment_0 )
            {
             before(grammarAccess.getComponentInstanceAccess().getCategoryAssignment_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1271:1: ( rule__ComponentInstance__CategoryAssignment_0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1271:2: rule__ComponentInstance__CategoryAssignment_0
            {
            pushFollow(FOLLOW_rule__ComponentInstance__CategoryAssignment_0_in_rule__ComponentInstance__Group__0__Impl2621);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1281:1: rule__ComponentInstance__Group__1 : rule__ComponentInstance__Group__1__Impl rule__ComponentInstance__Group__2 ;
    public final void rule__ComponentInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1285:1: ( rule__ComponentInstance__Group__1__Impl rule__ComponentInstance__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1286:2: rule__ComponentInstance__Group__1__Impl rule__ComponentInstance__Group__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__1__Impl_in_rule__ComponentInstance__Group__12651);
            rule__ComponentInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__2_in_rule__ComponentInstance__Group__12654);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1293:1: rule__ComponentInstance__Group__1__Impl : ( ( rule__ComponentInstance__NameAssignment_1 ) ) ;
    public final void rule__ComponentInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1297:1: ( ( ( rule__ComponentInstance__NameAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1298:1: ( ( rule__ComponentInstance__NameAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1298:1: ( ( rule__ComponentInstance__NameAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1299:1: ( rule__ComponentInstance__NameAssignment_1 )
            {
             before(grammarAccess.getComponentInstanceAccess().getNameAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1300:1: ( rule__ComponentInstance__NameAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1300:2: rule__ComponentInstance__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__NameAssignment_1_in_rule__ComponentInstance__Group__1__Impl2681);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1310:1: rule__ComponentInstance__Group__2 : rule__ComponentInstance__Group__2__Impl rule__ComponentInstance__Group__3 ;
    public final void rule__ComponentInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1314:1: ( rule__ComponentInstance__Group__2__Impl rule__ComponentInstance__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1315:2: rule__ComponentInstance__Group__2__Impl rule__ComponentInstance__Group__3
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__2__Impl_in_rule__ComponentInstance__Group__22711);
            rule__ComponentInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__3_in_rule__ComponentInstance__Group__22714);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1322:1: rule__ComponentInstance__Group__2__Impl : ( ( rule__ComponentInstance__Group_2__0 )* ) ;
    public final void rule__ComponentInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1326:1: ( ( ( rule__ComponentInstance__Group_2__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1327:1: ( ( rule__ComponentInstance__Group_2__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1327:1: ( ( rule__ComponentInstance__Group_2__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1328:1: ( rule__ComponentInstance__Group_2__0 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup_2()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1329:1: ( rule__ComponentInstance__Group_2__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==33) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1329:2: rule__ComponentInstance__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__Group_2__0_in_rule__ComponentInstance__Group__2__Impl2741);
            	    rule__ComponentInstance__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1339:1: rule__ComponentInstance__Group__3 : rule__ComponentInstance__Group__3__Impl rule__ComponentInstance__Group__4 ;
    public final void rule__ComponentInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1343:1: ( rule__ComponentInstance__Group__3__Impl rule__ComponentInstance__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1344:2: rule__ComponentInstance__Group__3__Impl rule__ComponentInstance__Group__4
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__3__Impl_in_rule__ComponentInstance__Group__32772);
            rule__ComponentInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__4_in_rule__ComponentInstance__Group__32775);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1351:1: rule__ComponentInstance__Group__3__Impl : ( ':' ) ;
    public final void rule__ComponentInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1355:1: ( ( ':' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1356:1: ( ':' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1356:1: ( ':' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1357:1: ':'
            {
             before(grammarAccess.getComponentInstanceAccess().getColonKeyword_3()); 
            match(input,30,FOLLOW_30_in_rule__ComponentInstance__Group__3__Impl2803); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1370:1: rule__ComponentInstance__Group__4 : rule__ComponentInstance__Group__4__Impl rule__ComponentInstance__Group__5 ;
    public final void rule__ComponentInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1374:1: ( rule__ComponentInstance__Group__4__Impl rule__ComponentInstance__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1375:2: rule__ComponentInstance__Group__4__Impl rule__ComponentInstance__Group__5
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__4__Impl_in_rule__ComponentInstance__Group__42834);
            rule__ComponentInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group__5_in_rule__ComponentInstance__Group__42837);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1382:1: rule__ComponentInstance__Group__4__Impl : ( ( rule__ComponentInstance__SubcomponentAssignment_4 ) ) ;
    public final void rule__ComponentInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1386:1: ( ( ( rule__ComponentInstance__SubcomponentAssignment_4 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1387:1: ( ( rule__ComponentInstance__SubcomponentAssignment_4 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1387:1: ( ( rule__ComponentInstance__SubcomponentAssignment_4 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1388:1: ( rule__ComponentInstance__SubcomponentAssignment_4 )
            {
             before(grammarAccess.getComponentInstanceAccess().getSubcomponentAssignment_4()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1389:1: ( rule__ComponentInstance__SubcomponentAssignment_4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1389:2: rule__ComponentInstance__SubcomponentAssignment_4
            {
            pushFollow(FOLLOW_rule__ComponentInstance__SubcomponentAssignment_4_in_rule__ComponentInstance__Group__4__Impl2864);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1399:1: rule__ComponentInstance__Group__5 : rule__ComponentInstance__Group__5__Impl ;
    public final void rule__ComponentInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1403:1: ( rule__ComponentInstance__Group__5__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1404:2: rule__ComponentInstance__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group__5__Impl_in_rule__ComponentInstance__Group__52894);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1410:1: rule__ComponentInstance__Group__5__Impl : ( ( rule__ComponentInstance__Group_5__0 )? ) ;
    public final void rule__ComponentInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1414:1: ( ( ( rule__ComponentInstance__Group_5__0 )? ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1415:1: ( ( rule__ComponentInstance__Group_5__0 )? )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1415:1: ( ( rule__ComponentInstance__Group_5__0 )? )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1416:1: ( rule__ComponentInstance__Group_5__0 )?
            {
             before(grammarAccess.getComponentInstanceAccess().getGroup_5()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1417:1: ( rule__ComponentInstance__Group_5__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==31) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1417:2: rule__ComponentInstance__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__ComponentInstance__Group_5__0_in_rule__ComponentInstance__Group__5__Impl2921);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1439:1: rule__ComponentInstance__Group_2__0 : rule__ComponentInstance__Group_2__0__Impl rule__ComponentInstance__Group_2__1 ;
    public final void rule__ComponentInstance__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1443:1: ( rule__ComponentInstance__Group_2__0__Impl rule__ComponentInstance__Group_2__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1444:2: rule__ComponentInstance__Group_2__0__Impl rule__ComponentInstance__Group_2__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_2__0__Impl_in_rule__ComponentInstance__Group_2__02964);
            rule__ComponentInstance__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_2__1_in_rule__ComponentInstance__Group_2__02967);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1451:1: rule__ComponentInstance__Group_2__0__Impl : ( '[' ) ;
    public final void rule__ComponentInstance__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1455:1: ( ( '[' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1456:1: ( '[' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1456:1: ( '[' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1457:1: '['
            {
             before(grammarAccess.getComponentInstanceAccess().getLeftSquareBracketKeyword_2_0()); 
            match(input,33,FOLLOW_33_in_rule__ComponentInstance__Group_2__0__Impl2995); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1470:1: rule__ComponentInstance__Group_2__1 : rule__ComponentInstance__Group_2__1__Impl rule__ComponentInstance__Group_2__2 ;
    public final void rule__ComponentInstance__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1474:1: ( rule__ComponentInstance__Group_2__1__Impl rule__ComponentInstance__Group_2__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1475:2: rule__ComponentInstance__Group_2__1__Impl rule__ComponentInstance__Group_2__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_2__1__Impl_in_rule__ComponentInstance__Group_2__13026);
            rule__ComponentInstance__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_2__2_in_rule__ComponentInstance__Group_2__13029);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1482:1: rule__ComponentInstance__Group_2__1__Impl : ( ( rule__ComponentInstance__IndexAssignment_2_1 ) ) ;
    public final void rule__ComponentInstance__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1486:1: ( ( ( rule__ComponentInstance__IndexAssignment_2_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1487:1: ( ( rule__ComponentInstance__IndexAssignment_2_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1487:1: ( ( rule__ComponentInstance__IndexAssignment_2_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1488:1: ( rule__ComponentInstance__IndexAssignment_2_1 )
            {
             before(grammarAccess.getComponentInstanceAccess().getIndexAssignment_2_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1489:1: ( rule__ComponentInstance__IndexAssignment_2_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1489:2: rule__ComponentInstance__IndexAssignment_2_1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__IndexAssignment_2_1_in_rule__ComponentInstance__Group_2__1__Impl3056);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1499:1: rule__ComponentInstance__Group_2__2 : rule__ComponentInstance__Group_2__2__Impl ;
    public final void rule__ComponentInstance__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1503:1: ( rule__ComponentInstance__Group_2__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1504:2: rule__ComponentInstance__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_2__2__Impl_in_rule__ComponentInstance__Group_2__23086);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1510:1: rule__ComponentInstance__Group_2__2__Impl : ( ']' ) ;
    public final void rule__ComponentInstance__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1514:1: ( ( ']' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1515:1: ( ']' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1515:1: ( ']' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1516:1: ']'
            {
             before(grammarAccess.getComponentInstanceAccess().getRightSquareBracketKeyword_2_2()); 
            match(input,34,FOLLOW_34_in_rule__ComponentInstance__Group_2__2__Impl3114); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1535:1: rule__ComponentInstance__Group_5__0 : rule__ComponentInstance__Group_5__0__Impl rule__ComponentInstance__Group_5__1 ;
    public final void rule__ComponentInstance__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1539:1: ( rule__ComponentInstance__Group_5__0__Impl rule__ComponentInstance__Group_5__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1540:2: rule__ComponentInstance__Group_5__0__Impl rule__ComponentInstance__Group_5__1
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__0__Impl_in_rule__ComponentInstance__Group_5__03151);
            rule__ComponentInstance__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__1_in_rule__ComponentInstance__Group_5__03154);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1547:1: rule__ComponentInstance__Group_5__0__Impl : ( '{' ) ;
    public final void rule__ComponentInstance__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1551:1: ( ( '{' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1552:1: ( '{' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1552:1: ( '{' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1553:1: '{'
            {
             before(grammarAccess.getComponentInstanceAccess().getLeftCurlyBracketKeyword_5_0()); 
            match(input,31,FOLLOW_31_in_rule__ComponentInstance__Group_5__0__Impl3182); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1566:1: rule__ComponentInstance__Group_5__1 : rule__ComponentInstance__Group_5__1__Impl rule__ComponentInstance__Group_5__2 ;
    public final void rule__ComponentInstance__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1570:1: ( rule__ComponentInstance__Group_5__1__Impl rule__ComponentInstance__Group_5__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1571:2: rule__ComponentInstance__Group_5__1__Impl rule__ComponentInstance__Group_5__2
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__1__Impl_in_rule__ComponentInstance__Group_5__13213);
            rule__ComponentInstance__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__2_in_rule__ComponentInstance__Group_5__13216);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1578:1: rule__ComponentInstance__Group_5__1__Impl : ( ( rule__ComponentInstance__Alternatives_5_1 )* ) ;
    public final void rule__ComponentInstance__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1582:1: ( ( ( rule__ComponentInstance__Alternatives_5_1 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1583:1: ( ( rule__ComponentInstance__Alternatives_5_1 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1583:1: ( ( rule__ComponentInstance__Alternatives_5_1 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1584:1: ( rule__ComponentInstance__Alternatives_5_1 )*
            {
             before(grammarAccess.getComponentInstanceAccess().getAlternatives_5_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1585:1: ( rule__ComponentInstance__Alternatives_5_1 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=9 && LA12_0<=10)||(LA12_0>=20 && LA12_0<=29)||LA12_0==37) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1585:2: rule__ComponentInstance__Alternatives_5_1
            	    {
            	    pushFollow(FOLLOW_rule__ComponentInstance__Alternatives_5_1_in_rule__ComponentInstance__Group_5__1__Impl3243);
            	    rule__ComponentInstance__Alternatives_5_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getComponentInstanceAccess().getAlternatives_5_1()); 

            }


            }

        }
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1595:1: rule__ComponentInstance__Group_5__2 : rule__ComponentInstance__Group_5__2__Impl ;
    public final void rule__ComponentInstance__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1599:1: ( rule__ComponentInstance__Group_5__2__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1600:2: rule__ComponentInstance__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__ComponentInstance__Group_5__2__Impl_in_rule__ComponentInstance__Group_5__23274);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1606:1: rule__ComponentInstance__Group_5__2__Impl : ( '}' ) ;
    public final void rule__ComponentInstance__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1610:1: ( ( '}' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1611:1: ( '}' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1611:1: ( '}' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1612:1: '}'
            {
             before(grammarAccess.getComponentInstanceAccess().getRightCurlyBracketKeyword_5_2()); 
            match(input,32,FOLLOW_32_in_rule__ComponentInstance__Group_5__2__Impl3302); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1631:1: rule__SystemOperationMode__Group__0 : rule__SystemOperationMode__Group__0__Impl rule__SystemOperationMode__Group__1 ;
    public final void rule__SystemOperationMode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1635:1: ( rule__SystemOperationMode__Group__0__Impl rule__SystemOperationMode__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1636:2: rule__SystemOperationMode__Group__0__Impl rule__SystemOperationMode__Group__1
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__Group__0__Impl_in_rule__SystemOperationMode__Group__03339);
            rule__SystemOperationMode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SystemOperationMode__Group__1_in_rule__SystemOperationMode__Group__03342);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1643:1: rule__SystemOperationMode__Group__0__Impl : ( 'som' ) ;
    public final void rule__SystemOperationMode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1647:1: ( ( 'som' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1648:1: ( 'som' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1648:1: ( 'som' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1649:1: 'som'
            {
             before(grammarAccess.getSystemOperationModeAccess().getSomKeyword_0()); 
            match(input,35,FOLLOW_35_in_rule__SystemOperationMode__Group__0__Impl3370); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1662:1: rule__SystemOperationMode__Group__1 : rule__SystemOperationMode__Group__1__Impl ;
    public final void rule__SystemOperationMode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1666:1: ( rule__SystemOperationMode__Group__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1667:2: rule__SystemOperationMode__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__Group__1__Impl_in_rule__SystemOperationMode__Group__13401);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1673:1: rule__SystemOperationMode__Group__1__Impl : ( ( rule__SystemOperationMode__NameAssignment_1 ) ) ;
    public final void rule__SystemOperationMode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1677:1: ( ( ( rule__SystemOperationMode__NameAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1678:1: ( ( rule__SystemOperationMode__NameAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1678:1: ( ( rule__SystemOperationMode__NameAssignment_1 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1679:1: ( rule__SystemOperationMode__NameAssignment_1 )
            {
             before(grammarAccess.getSystemOperationModeAccess().getNameAssignment_1()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1680:1: ( rule__SystemOperationMode__NameAssignment_1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1680:2: rule__SystemOperationMode__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SystemOperationMode__NameAssignment_1_in_rule__SystemOperationMode__Group__1__Impl3428);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1694:1: rule__DirectionType__Group_2__0 : rule__DirectionType__Group_2__0__Impl rule__DirectionType__Group_2__1 ;
    public final void rule__DirectionType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1698:1: ( rule__DirectionType__Group_2__0__Impl rule__DirectionType__Group_2__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1699:2: rule__DirectionType__Group_2__0__Impl rule__DirectionType__Group_2__1
            {
            pushFollow(FOLLOW_rule__DirectionType__Group_2__0__Impl_in_rule__DirectionType__Group_2__03462);
            rule__DirectionType__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DirectionType__Group_2__1_in_rule__DirectionType__Group_2__03465);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1706:1: rule__DirectionType__Group_2__0__Impl : ( 'in' ) ;
    public final void rule__DirectionType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1710:1: ( ( 'in' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1711:1: ( 'in' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1711:1: ( 'in' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1712:1: 'in'
            {
             before(grammarAccess.getDirectionTypeAccess().getInKeyword_2_0()); 
            match(input,9,FOLLOW_9_in_rule__DirectionType__Group_2__0__Impl3493); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1725:1: rule__DirectionType__Group_2__1 : rule__DirectionType__Group_2__1__Impl ;
    public final void rule__DirectionType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1729:1: ( rule__DirectionType__Group_2__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1730:2: rule__DirectionType__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__DirectionType__Group_2__1__Impl_in_rule__DirectionType__Group_2__13524);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1736:1: rule__DirectionType__Group_2__1__Impl : ( 'out' ) ;
    public final void rule__DirectionType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1740:1: ( ( 'out' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1741:1: ( 'out' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1741:1: ( 'out' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1742:1: 'out'
            {
             before(grammarAccess.getDirectionTypeAccess().getOutKeyword_2_1()); 
            match(input,10,FOLLOW_10_in_rule__DirectionType__Group_2__1__Impl3552); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1759:1: rule__ComponentCategory__Group_8__0 : rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1 ;
    public final void rule__ComponentCategory__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1763:1: ( rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1764:2: rule__ComponentCategory__Group_8__0__Impl rule__ComponentCategory__Group_8__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_8__0__Impl_in_rule__ComponentCategory__Group_8__03587);
            rule__ComponentCategory__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_8__1_in_rule__ComponentCategory__Group_8__03590);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1771:1: rule__ComponentCategory__Group_8__0__Impl : ( 'subprogram' ) ;
    public final void rule__ComponentCategory__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1775:1: ( ( 'subprogram' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1776:1: ( 'subprogram' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1776:1: ( 'subprogram' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1777:1: 'subprogram'
            {
             before(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
            match(input,27,FOLLOW_27_in_rule__ComponentCategory__Group_8__0__Impl3618); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1790:1: rule__ComponentCategory__Group_8__1 : rule__ComponentCategory__Group_8__1__Impl ;
    public final void rule__ComponentCategory__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1794:1: ( rule__ComponentCategory__Group_8__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1795:2: rule__ComponentCategory__Group_8__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_8__1__Impl_in_rule__ComponentCategory__Group_8__13649);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1801:1: rule__ComponentCategory__Group_8__1__Impl : ( 'group' ) ;
    public final void rule__ComponentCategory__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1805:1: ( ( 'group' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1806:1: ( 'group' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1806:1: ( 'group' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1807:1: 'group'
            {
             before(grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
            match(input,36,FOLLOW_36_in_rule__ComponentCategory__Group_8__1__Impl3677); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1824:1: rule__ComponentCategory__Group_10__0 : rule__ComponentCategory__Group_10__0__Impl rule__ComponentCategory__Group_10__1 ;
    public final void rule__ComponentCategory__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1828:1: ( rule__ComponentCategory__Group_10__0__Impl rule__ComponentCategory__Group_10__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1829:2: rule__ComponentCategory__Group_10__0__Impl rule__ComponentCategory__Group_10__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_10__0__Impl_in_rule__ComponentCategory__Group_10__03712);
            rule__ComponentCategory__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_10__1_in_rule__ComponentCategory__Group_10__03715);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1836:1: rule__ComponentCategory__Group_10__0__Impl : ( 'thread' ) ;
    public final void rule__ComponentCategory__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1840:1: ( ( 'thread' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1841:1: ( 'thread' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1841:1: ( 'thread' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1842:1: 'thread'
            {
             before(grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); 
            match(input,29,FOLLOW_29_in_rule__ComponentCategory__Group_10__0__Impl3743); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1855:1: rule__ComponentCategory__Group_10__1 : rule__ComponentCategory__Group_10__1__Impl ;
    public final void rule__ComponentCategory__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1859:1: ( rule__ComponentCategory__Group_10__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1860:2: rule__ComponentCategory__Group_10__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_10__1__Impl_in_rule__ComponentCategory__Group_10__13774);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1866:1: rule__ComponentCategory__Group_10__1__Impl : ( 'group' ) ;
    public final void rule__ComponentCategory__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1870:1: ( ( 'group' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1871:1: ( 'group' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1871:1: ( 'group' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1872:1: 'group'
            {
             before(grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); 
            match(input,36,FOLLOW_36_in_rule__ComponentCategory__Group_10__1__Impl3802); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1889:1: rule__ComponentCategory__Group_12__0 : rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1 ;
    public final void rule__ComponentCategory__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1893:1: ( rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1894:2: rule__ComponentCategory__Group_12__0__Impl rule__ComponentCategory__Group_12__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_12__0__Impl_in_rule__ComponentCategory__Group_12__03837);
            rule__ComponentCategory__Group_12__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_12__1_in_rule__ComponentCategory__Group_12__03840);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1901:1: rule__ComponentCategory__Group_12__0__Impl : ( 'virtual' ) ;
    public final void rule__ComponentCategory__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1905:1: ( ( 'virtual' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1906:1: ( 'virtual' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1906:1: ( 'virtual' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1907:1: 'virtual'
            {
             before(grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
            match(input,37,FOLLOW_37_in_rule__ComponentCategory__Group_12__0__Impl3868); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1920:1: rule__ComponentCategory__Group_12__1 : rule__ComponentCategory__Group_12__1__Impl ;
    public final void rule__ComponentCategory__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1924:1: ( rule__ComponentCategory__Group_12__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1925:2: rule__ComponentCategory__Group_12__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_12__1__Impl_in_rule__ComponentCategory__Group_12__13899);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1931:1: rule__ComponentCategory__Group_12__1__Impl : ( 'bus' ) ;
    public final void rule__ComponentCategory__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1935:1: ( ( 'bus' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1936:1: ( 'bus' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1936:1: ( 'bus' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1937:1: 'bus'
            {
             before(grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
            match(input,21,FOLLOW_21_in_rule__ComponentCategory__Group_12__1__Impl3927); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1954:1: rule__ComponentCategory__Group_13__0 : rule__ComponentCategory__Group_13__0__Impl rule__ComponentCategory__Group_13__1 ;
    public final void rule__ComponentCategory__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1958:1: ( rule__ComponentCategory__Group_13__0__Impl rule__ComponentCategory__Group_13__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1959:2: rule__ComponentCategory__Group_13__0__Impl rule__ComponentCategory__Group_13__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_13__0__Impl_in_rule__ComponentCategory__Group_13__03962);
            rule__ComponentCategory__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group_13__1_in_rule__ComponentCategory__Group_13__03965);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1966:1: rule__ComponentCategory__Group_13__0__Impl : ( 'virtual' ) ;
    public final void rule__ComponentCategory__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1970:1: ( ( 'virtual' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1971:1: ( 'virtual' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1971:1: ( 'virtual' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1972:1: 'virtual'
            {
             before(grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); 
            match(input,37,FOLLOW_37_in_rule__ComponentCategory__Group_13__0__Impl3993); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1985:1: rule__ComponentCategory__Group_13__1 : rule__ComponentCategory__Group_13__1__Impl ;
    public final void rule__ComponentCategory__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1989:1: ( rule__ComponentCategory__Group_13__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1990:2: rule__ComponentCategory__Group_13__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group_13__1__Impl_in_rule__ComponentCategory__Group_13__14024);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:1996:1: rule__ComponentCategory__Group_13__1__Impl : ( 'processor' ) ;
    public final void rule__ComponentCategory__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2000:1: ( ( 'processor' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2001:1: ( 'processor' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2001:1: ( 'processor' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2002:1: 'processor'
            {
             before(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_13_1()); 
            match(input,26,FOLLOW_26_in_rule__ComponentCategory__Group_13__1__Impl4052); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2019:1: rule__IMPLREF__Group__0 : rule__IMPLREF__Group__0__Impl rule__IMPLREF__Group__1 ;
    public final void rule__IMPLREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2023:1: ( rule__IMPLREF__Group__0__Impl rule__IMPLREF__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2024:2: rule__IMPLREF__Group__0__Impl rule__IMPLREF__Group__1
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group__0__Impl_in_rule__IMPLREF__Group__04087);
            rule__IMPLREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IMPLREF__Group__1_in_rule__IMPLREF__Group__04090);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2031:1: rule__IMPLREF__Group__0__Impl : ( ( ( rule__IMPLREF__Group_0__0 ) ) ( ( rule__IMPLREF__Group_0__0 )* ) ) ;
    public final void rule__IMPLREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2035:1: ( ( ( ( rule__IMPLREF__Group_0__0 ) ) ( ( rule__IMPLREF__Group_0__0 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2036:1: ( ( ( rule__IMPLREF__Group_0__0 ) ) ( ( rule__IMPLREF__Group_0__0 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2036:1: ( ( ( rule__IMPLREF__Group_0__0 ) ) ( ( rule__IMPLREF__Group_0__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2037:1: ( ( rule__IMPLREF__Group_0__0 ) ) ( ( rule__IMPLREF__Group_0__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2037:1: ( ( rule__IMPLREF__Group_0__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2038:1: ( rule__IMPLREF__Group_0__0 )
            {
             before(grammarAccess.getIMPLREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2039:1: ( rule__IMPLREF__Group_0__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2039:2: rule__IMPLREF__Group_0__0
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group_0__0_in_rule__IMPLREF__Group__0__Impl4119);
            rule__IMPLREF__Group_0__0();

            state._fsp--;


            }

             after(grammarAccess.getIMPLREFAccess().getGroup_0()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2042:1: ( ( rule__IMPLREF__Group_0__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2043:1: ( rule__IMPLREF__Group_0__0 )*
            {
             before(grammarAccess.getIMPLREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2044:1: ( rule__IMPLREF__Group_0__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID) ) {
                    int LA13_1 = input.LA(2);

                    if ( (LA13_1==39) ) {
                        alt13=1;
                    }


                }


                switch (alt13) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2044:2: rule__IMPLREF__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__IMPLREF__Group_0__0_in_rule__IMPLREF__Group__0__Impl4131);
            	    rule__IMPLREF__Group_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2055:1: rule__IMPLREF__Group__1 : rule__IMPLREF__Group__1__Impl rule__IMPLREF__Group__2 ;
    public final void rule__IMPLREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2059:1: ( rule__IMPLREF__Group__1__Impl rule__IMPLREF__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2060:2: rule__IMPLREF__Group__1__Impl rule__IMPLREF__Group__2
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group__1__Impl_in_rule__IMPLREF__Group__14164);
            rule__IMPLREF__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IMPLREF__Group__2_in_rule__IMPLREF__Group__14167);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2067:1: rule__IMPLREF__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__IMPLREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2071:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2072:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2072:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2073:1: RULE_ID
            {
             before(grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IMPLREF__Group__1__Impl4194); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2084:1: rule__IMPLREF__Group__2 : rule__IMPLREF__Group__2__Impl rule__IMPLREF__Group__3 ;
    public final void rule__IMPLREF__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2088:1: ( rule__IMPLREF__Group__2__Impl rule__IMPLREF__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2089:2: rule__IMPLREF__Group__2__Impl rule__IMPLREF__Group__3
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group__2__Impl_in_rule__IMPLREF__Group__24223);
            rule__IMPLREF__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IMPLREF__Group__3_in_rule__IMPLREF__Group__24226);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2096:1: rule__IMPLREF__Group__2__Impl : ( '.' ) ;
    public final void rule__IMPLREF__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2100:1: ( ( '.' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2101:1: ( '.' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2101:1: ( '.' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2102:1: '.'
            {
             before(grammarAccess.getIMPLREFAccess().getFullStopKeyword_2()); 
            match(input,38,FOLLOW_38_in_rule__IMPLREF__Group__2__Impl4254); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2115:1: rule__IMPLREF__Group__3 : rule__IMPLREF__Group__3__Impl ;
    public final void rule__IMPLREF__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2119:1: ( rule__IMPLREF__Group__3__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2120:2: rule__IMPLREF__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group__3__Impl_in_rule__IMPLREF__Group__34285);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2126:1: rule__IMPLREF__Group__3__Impl : ( RULE_ID ) ;
    public final void rule__IMPLREF__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2130:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2131:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2131:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2132:1: RULE_ID
            {
             before(grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_3()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IMPLREF__Group__3__Impl4312); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2151:1: rule__IMPLREF__Group_0__0 : rule__IMPLREF__Group_0__0__Impl rule__IMPLREF__Group_0__1 ;
    public final void rule__IMPLREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2155:1: ( rule__IMPLREF__Group_0__0__Impl rule__IMPLREF__Group_0__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2156:2: rule__IMPLREF__Group_0__0__Impl rule__IMPLREF__Group_0__1
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group_0__0__Impl_in_rule__IMPLREF__Group_0__04349);
            rule__IMPLREF__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IMPLREF__Group_0__1_in_rule__IMPLREF__Group_0__04352);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2163:1: rule__IMPLREF__Group_0__0__Impl : ( RULE_ID ) ;
    public final void rule__IMPLREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2167:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2168:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2168:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2169:1: RULE_ID
            {
             before(grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IMPLREF__Group_0__0__Impl4379); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2180:1: rule__IMPLREF__Group_0__1 : rule__IMPLREF__Group_0__1__Impl ;
    public final void rule__IMPLREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2184:1: ( rule__IMPLREF__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2185:2: rule__IMPLREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__IMPLREF__Group_0__1__Impl_in_rule__IMPLREF__Group_0__14408);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2191:1: rule__IMPLREF__Group_0__1__Impl : ( '::' ) ;
    public final void rule__IMPLREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2195:1: ( ( '::' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2196:1: ( '::' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2196:1: ( '::' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2197:1: '::'
            {
             before(grammarAccess.getIMPLREFAccess().getColonColonKeyword_0_1()); 
            match(input,39,FOLLOW_39_in_rule__IMPLREF__Group_0__1__Impl4436); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2214:1: rule__FEATREF__Group__0 : rule__FEATREF__Group__0__Impl rule__FEATREF__Group__1 ;
    public final void rule__FEATREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2218:1: ( rule__FEATREF__Group__0__Impl rule__FEATREF__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2219:2: rule__FEATREF__Group__0__Impl rule__FEATREF__Group__1
            {
            pushFollow(FOLLOW_rule__FEATREF__Group__0__Impl_in_rule__FEATREF__Group__04471);
            rule__FEATREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FEATREF__Group__1_in_rule__FEATREF__Group__04474);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2226:1: rule__FEATREF__Group__0__Impl : ( ( ( rule__FEATREF__Group_0__0 ) ) ( ( rule__FEATREF__Group_0__0 )* ) ) ;
    public final void rule__FEATREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2230:1: ( ( ( ( rule__FEATREF__Group_0__0 ) ) ( ( rule__FEATREF__Group_0__0 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2231:1: ( ( ( rule__FEATREF__Group_0__0 ) ) ( ( rule__FEATREF__Group_0__0 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2231:1: ( ( ( rule__FEATREF__Group_0__0 ) ) ( ( rule__FEATREF__Group_0__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2232:1: ( ( rule__FEATREF__Group_0__0 ) ) ( ( rule__FEATREF__Group_0__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2232:1: ( ( rule__FEATREF__Group_0__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2233:1: ( rule__FEATREF__Group_0__0 )
            {
             before(grammarAccess.getFEATREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2234:1: ( rule__FEATREF__Group_0__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2234:2: rule__FEATREF__Group_0__0
            {
            pushFollow(FOLLOW_rule__FEATREF__Group_0__0_in_rule__FEATREF__Group__0__Impl4503);
            rule__FEATREF__Group_0__0();

            state._fsp--;


            }

             after(grammarAccess.getFEATREFAccess().getGroup_0()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2237:1: ( ( rule__FEATREF__Group_0__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2238:1: ( rule__FEATREF__Group_0__0 )*
            {
             before(grammarAccess.getFEATREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2239:1: ( rule__FEATREF__Group_0__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    int LA14_1 = input.LA(2);

                    if ( (LA14_1==39) ) {
                        int LA14_2 = input.LA(3);

                        if ( (LA14_2==RULE_ID) ) {
                            int LA14_3 = input.LA(4);

                            if ( (LA14_3==39) ) {
                                alt14=1;
                            }


                        }


                    }


                }


                switch (alt14) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2239:2: rule__FEATREF__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__FEATREF__Group_0__0_in_rule__FEATREF__Group__0__Impl4515);
            	    rule__FEATREF__Group_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2250:1: rule__FEATREF__Group__1 : rule__FEATREF__Group__1__Impl rule__FEATREF__Group__2 ;
    public final void rule__FEATREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2254:1: ( rule__FEATREF__Group__1__Impl rule__FEATREF__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2255:2: rule__FEATREF__Group__1__Impl rule__FEATREF__Group__2
            {
            pushFollow(FOLLOW_rule__FEATREF__Group__1__Impl_in_rule__FEATREF__Group__14548);
            rule__FEATREF__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FEATREF__Group__2_in_rule__FEATREF__Group__14551);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2262:1: rule__FEATREF__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__FEATREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2266:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2267:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2267:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2268:1: RULE_ID
            {
             before(grammarAccess.getFEATREFAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FEATREF__Group__1__Impl4578); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2279:1: rule__FEATREF__Group__2 : rule__FEATREF__Group__2__Impl rule__FEATREF__Group__3 ;
    public final void rule__FEATREF__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2283:1: ( rule__FEATREF__Group__2__Impl rule__FEATREF__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2284:2: rule__FEATREF__Group__2__Impl rule__FEATREF__Group__3
            {
            pushFollow(FOLLOW_rule__FEATREF__Group__2__Impl_in_rule__FEATREF__Group__24607);
            rule__FEATREF__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FEATREF__Group__3_in_rule__FEATREF__Group__24610);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2291:1: rule__FEATREF__Group__2__Impl : ( '::' ) ;
    public final void rule__FEATREF__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2295:1: ( ( '::' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2296:1: ( '::' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2296:1: ( '::' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2297:1: '::'
            {
             before(grammarAccess.getFEATREFAccess().getColonColonKeyword_2()); 
            match(input,39,FOLLOW_39_in_rule__FEATREF__Group__2__Impl4638); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2310:1: rule__FEATREF__Group__3 : rule__FEATREF__Group__3__Impl ;
    public final void rule__FEATREF__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2314:1: ( rule__FEATREF__Group__3__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2315:2: rule__FEATREF__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__FEATREF__Group__3__Impl_in_rule__FEATREF__Group__34669);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2321:1: rule__FEATREF__Group__3__Impl : ( RULE_ID ) ;
    public final void rule__FEATREF__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2325:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2326:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2326:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2327:1: RULE_ID
            {
             before(grammarAccess.getFEATREFAccess().getIDTerminalRuleCall_3()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FEATREF__Group__3__Impl4696); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2346:1: rule__FEATREF__Group_0__0 : rule__FEATREF__Group_0__0__Impl rule__FEATREF__Group_0__1 ;
    public final void rule__FEATREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2350:1: ( rule__FEATREF__Group_0__0__Impl rule__FEATREF__Group_0__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2351:2: rule__FEATREF__Group_0__0__Impl rule__FEATREF__Group_0__1
            {
            pushFollow(FOLLOW_rule__FEATREF__Group_0__0__Impl_in_rule__FEATREF__Group_0__04733);
            rule__FEATREF__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FEATREF__Group_0__1_in_rule__FEATREF__Group_0__04736);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2358:1: rule__FEATREF__Group_0__0__Impl : ( RULE_ID ) ;
    public final void rule__FEATREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2362:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2363:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2363:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2364:1: RULE_ID
            {
             before(grammarAccess.getFEATREFAccess().getIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FEATREF__Group_0__0__Impl4763); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2375:1: rule__FEATREF__Group_0__1 : rule__FEATREF__Group_0__1__Impl ;
    public final void rule__FEATREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2379:1: ( rule__FEATREF__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2380:2: rule__FEATREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__FEATREF__Group_0__1__Impl_in_rule__FEATREF__Group_0__14792);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2386:1: rule__FEATREF__Group_0__1__Impl : ( '::' ) ;
    public final void rule__FEATREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2390:1: ( ( '::' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2391:1: ( '::' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2391:1: ( '::' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2392:1: '::'
            {
             before(grammarAccess.getFEATREFAccess().getColonColonKeyword_0_1()); 
            match(input,39,FOLLOW_39_in_rule__FEATREF__Group_0__1__Impl4820); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2409:1: rule__SUBREF__Group__0 : rule__SUBREF__Group__0__Impl rule__SUBREF__Group__1 ;
    public final void rule__SUBREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2413:1: ( rule__SUBREF__Group__0__Impl rule__SUBREF__Group__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2414:2: rule__SUBREF__Group__0__Impl rule__SUBREF__Group__1
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__0__Impl_in_rule__SUBREF__Group__04855);
            rule__SUBREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group__1_in_rule__SUBREF__Group__04858);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2421:1: rule__SUBREF__Group__0__Impl : ( ( ( rule__SUBREF__Group_0__0 ) ) ( ( rule__SUBREF__Group_0__0 )* ) ) ;
    public final void rule__SUBREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2425:1: ( ( ( ( rule__SUBREF__Group_0__0 ) ) ( ( rule__SUBREF__Group_0__0 )* ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2426:1: ( ( ( rule__SUBREF__Group_0__0 ) ) ( ( rule__SUBREF__Group_0__0 )* ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2426:1: ( ( ( rule__SUBREF__Group_0__0 ) ) ( ( rule__SUBREF__Group_0__0 )* ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2427:1: ( ( rule__SUBREF__Group_0__0 ) ) ( ( rule__SUBREF__Group_0__0 )* )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2427:1: ( ( rule__SUBREF__Group_0__0 ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2428:1: ( rule__SUBREF__Group_0__0 )
            {
             before(grammarAccess.getSUBREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2429:1: ( rule__SUBREF__Group_0__0 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2429:2: rule__SUBREF__Group_0__0
            {
            pushFollow(FOLLOW_rule__SUBREF__Group_0__0_in_rule__SUBREF__Group__0__Impl4887);
            rule__SUBREF__Group_0__0();

            state._fsp--;


            }

             after(grammarAccess.getSUBREFAccess().getGroup_0()); 

            }

            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2432:1: ( ( rule__SUBREF__Group_0__0 )* )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2433:1: ( rule__SUBREF__Group_0__0 )*
            {
             before(grammarAccess.getSUBREFAccess().getGroup_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2434:1: ( rule__SUBREF__Group_0__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    int LA15_1 = input.LA(2);

                    if ( (LA15_1==39) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2434:2: rule__SUBREF__Group_0__0
            	    {
            	    pushFollow(FOLLOW_rule__SUBREF__Group_0__0_in_rule__SUBREF__Group__0__Impl4899);
            	    rule__SUBREF__Group_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2445:1: rule__SUBREF__Group__1 : rule__SUBREF__Group__1__Impl rule__SUBREF__Group__2 ;
    public final void rule__SUBREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2449:1: ( rule__SUBREF__Group__1__Impl rule__SUBREF__Group__2 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2450:2: rule__SUBREF__Group__1__Impl rule__SUBREF__Group__2
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__1__Impl_in_rule__SUBREF__Group__14932);
            rule__SUBREF__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group__2_in_rule__SUBREF__Group__14935);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2457:1: rule__SUBREF__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__SUBREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2461:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2462:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2462:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2463:1: RULE_ID
            {
             before(grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SUBREF__Group__1__Impl4962); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2474:1: rule__SUBREF__Group__2 : rule__SUBREF__Group__2__Impl rule__SUBREF__Group__3 ;
    public final void rule__SUBREF__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2478:1: ( rule__SUBREF__Group__2__Impl rule__SUBREF__Group__3 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2479:2: rule__SUBREF__Group__2__Impl rule__SUBREF__Group__3
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__2__Impl_in_rule__SUBREF__Group__24991);
            rule__SUBREF__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group__3_in_rule__SUBREF__Group__24994);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2486:1: rule__SUBREF__Group__2__Impl : ( '.' ) ;
    public final void rule__SUBREF__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2490:1: ( ( '.' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2491:1: ( '.' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2491:1: ( '.' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2492:1: '.'
            {
             before(grammarAccess.getSUBREFAccess().getFullStopKeyword_2()); 
            match(input,38,FOLLOW_38_in_rule__SUBREF__Group__2__Impl5022); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2505:1: rule__SUBREF__Group__3 : rule__SUBREF__Group__3__Impl rule__SUBREF__Group__4 ;
    public final void rule__SUBREF__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2509:1: ( rule__SUBREF__Group__3__Impl rule__SUBREF__Group__4 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2510:2: rule__SUBREF__Group__3__Impl rule__SUBREF__Group__4
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__3__Impl_in_rule__SUBREF__Group__35053);
            rule__SUBREF__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group__4_in_rule__SUBREF__Group__35056);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2517:1: rule__SUBREF__Group__3__Impl : ( RULE_ID ) ;
    public final void rule__SUBREF__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2521:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2522:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2522:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2523:1: RULE_ID
            {
             before(grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_3()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SUBREF__Group__3__Impl5083); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2534:1: rule__SUBREF__Group__4 : rule__SUBREF__Group__4__Impl rule__SUBREF__Group__5 ;
    public final void rule__SUBREF__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2538:1: ( rule__SUBREF__Group__4__Impl rule__SUBREF__Group__5 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2539:2: rule__SUBREF__Group__4__Impl rule__SUBREF__Group__5
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__4__Impl_in_rule__SUBREF__Group__45112);
            rule__SUBREF__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group__5_in_rule__SUBREF__Group__45115);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2546:1: rule__SUBREF__Group__4__Impl : ( '::' ) ;
    public final void rule__SUBREF__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2550:1: ( ( '::' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2551:1: ( '::' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2551:1: ( '::' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2552:1: '::'
            {
             before(grammarAccess.getSUBREFAccess().getColonColonKeyword_4()); 
            match(input,39,FOLLOW_39_in_rule__SUBREF__Group__4__Impl5143); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2565:1: rule__SUBREF__Group__5 : rule__SUBREF__Group__5__Impl ;
    public final void rule__SUBREF__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2569:1: ( rule__SUBREF__Group__5__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2570:2: rule__SUBREF__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__SUBREF__Group__5__Impl_in_rule__SUBREF__Group__55174);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2576:1: rule__SUBREF__Group__5__Impl : ( RULE_ID ) ;
    public final void rule__SUBREF__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2580:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2581:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2581:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2582:1: RULE_ID
            {
             before(grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_5()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SUBREF__Group__5__Impl5201); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2605:1: rule__SUBREF__Group_0__0 : rule__SUBREF__Group_0__0__Impl rule__SUBREF__Group_0__1 ;
    public final void rule__SUBREF__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2609:1: ( rule__SUBREF__Group_0__0__Impl rule__SUBREF__Group_0__1 )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2610:2: rule__SUBREF__Group_0__0__Impl rule__SUBREF__Group_0__1
            {
            pushFollow(FOLLOW_rule__SUBREF__Group_0__0__Impl_in_rule__SUBREF__Group_0__05242);
            rule__SUBREF__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SUBREF__Group_0__1_in_rule__SUBREF__Group_0__05245);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2617:1: rule__SUBREF__Group_0__0__Impl : ( RULE_ID ) ;
    public final void rule__SUBREF__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2621:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2622:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2622:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2623:1: RULE_ID
            {
             before(grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SUBREF__Group_0__0__Impl5272); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2634:1: rule__SUBREF__Group_0__1 : rule__SUBREF__Group_0__1__Impl ;
    public final void rule__SUBREF__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2638:1: ( rule__SUBREF__Group_0__1__Impl )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2639:2: rule__SUBREF__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__SUBREF__Group_0__1__Impl_in_rule__SUBREF__Group_0__15301);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2645:1: rule__SUBREF__Group_0__1__Impl : ( '::' ) ;
    public final void rule__SUBREF__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2649:1: ( ( '::' ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2650:1: ( '::' )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2650:1: ( '::' )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2651:1: '::'
            {
             before(grammarAccess.getSUBREFAccess().getColonColonKeyword_0_1()); 
            match(input,39,FOLLOW_39_in_rule__SUBREF__Group_0__1__Impl5329); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2669:1: rule__SystemInstance__CategoryAssignment_0 : ( ruleComponentCategory ) ;
    public final void rule__SystemInstance__CategoryAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2673:1: ( ( ruleComponentCategory ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2674:1: ( ruleComponentCategory )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2674:1: ( ruleComponentCategory )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2675:1: ruleComponentCategory
            {
             before(grammarAccess.getSystemInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_rule__SystemInstance__CategoryAssignment_05369);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2684:1: rule__SystemInstance__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SystemInstance__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2688:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2689:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2689:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2690:1: RULE_ID
            {
             before(grammarAccess.getSystemInstanceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SystemInstance__NameAssignment_15400); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2699:1: rule__SystemInstance__ComponentImplementationAssignment_3 : ( ( ruleIMPLREF ) ) ;
    public final void rule__SystemInstance__ComponentImplementationAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2703:1: ( ( ( ruleIMPLREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2704:1: ( ( ruleIMPLREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2704:1: ( ( ruleIMPLREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2705:1: ( ruleIMPLREF )
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationCrossReference_3_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2706:1: ( ruleIMPLREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2707:1: ruleIMPLREF
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationIMPLREFParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_ruleIMPLREF_in_rule__SystemInstance__ComponentImplementationAssignment_35435);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2718:1: rule__SystemInstance__FeatureInstanceAssignment_5_0 : ( ruleFeatureInstance ) ;
    public final void rule__SystemInstance__FeatureInstanceAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2722:1: ( ( ruleFeatureInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2723:1: ( ruleFeatureInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2723:1: ( ruleFeatureInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2724:1: ruleFeatureInstance
            {
             before(grammarAccess.getSystemInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_5_0_0()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_rule__SystemInstance__FeatureInstanceAssignment_5_05470);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2733:1: rule__SystemInstance__ComponentInstanceAssignment_5_1 : ( ruleComponentInstance ) ;
    public final void rule__SystemInstance__ComponentInstanceAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2737:1: ( ( ruleComponentInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2738:1: ( ruleComponentInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2738:1: ( ruleComponentInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2739:1: ruleComponentInstance
            {
             before(grammarAccess.getSystemInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_ruleComponentInstance_in_rule__SystemInstance__ComponentInstanceAssignment_5_15501);
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


    // $ANTLR start "rule__SystemInstance__SystemOperationModeAssignment_5_2"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2748:1: rule__SystemInstance__SystemOperationModeAssignment_5_2 : ( ruleSystemOperationMode ) ;
    public final void rule__SystemInstance__SystemOperationModeAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2752:1: ( ( ruleSystemOperationMode ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2753:1: ( ruleSystemOperationMode )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2753:1: ( ruleSystemOperationMode )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2754:1: ruleSystemOperationMode
            {
             before(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_5_2_0()); 
            pushFollow(FOLLOW_ruleSystemOperationMode_in_rule__SystemInstance__SystemOperationModeAssignment_5_25532);
            ruleSystemOperationMode();

            state._fsp--;

             after(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemInstance__SystemOperationModeAssignment_5_2"


    // $ANTLR start "rule__FeatureInstance__DirectionAssignment_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2763:1: rule__FeatureInstance__DirectionAssignment_0 : ( ruleDirectionType ) ;
    public final void rule__FeatureInstance__DirectionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2767:1: ( ( ruleDirectionType ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2768:1: ( ruleDirectionType )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2768:1: ( ruleDirectionType )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2769:1: ruleDirectionType
            {
             before(grammarAccess.getFeatureInstanceAccess().getDirectionDirectionTypeParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleDirectionType_in_rule__FeatureInstance__DirectionAssignment_05563);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2778:1: rule__FeatureInstance__CategoryAssignment_1 : ( ruleFeatureCategory ) ;
    public final void rule__FeatureInstance__CategoryAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2782:1: ( ( ruleFeatureCategory ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2783:1: ( ruleFeatureCategory )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2783:1: ( ruleFeatureCategory )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2784:1: ruleFeatureCategory
            {
             before(grammarAccess.getFeatureInstanceAccess().getCategoryFeatureCategoryParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleFeatureCategory_in_rule__FeatureInstance__CategoryAssignment_15594);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2793:1: rule__FeatureInstance__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__FeatureInstance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2797:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2798:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2798:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2799:1: RULE_ID
            {
             before(grammarAccess.getFeatureInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FeatureInstance__NameAssignment_25625); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2808:1: rule__FeatureInstance__IndexAssignment_3_1 : ( RULE_LONG ) ;
    public final void rule__FeatureInstance__IndexAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2812:1: ( ( RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2813:1: ( RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2813:1: ( RULE_LONG )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2814:1: RULE_LONG
            {
             before(grammarAccess.getFeatureInstanceAccess().getIndexLONGTerminalRuleCall_3_1_0()); 
            match(input,RULE_LONG,FOLLOW_RULE_LONG_in_rule__FeatureInstance__IndexAssignment_3_15656); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2823:1: rule__FeatureInstance__FeatureAssignment_5 : ( ( ruleFEATREF ) ) ;
    public final void rule__FeatureInstance__FeatureAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2827:1: ( ( ( ruleFEATREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2828:1: ( ( ruleFEATREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2828:1: ( ( ruleFEATREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2829:1: ( ruleFEATREF )
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureCrossReference_5_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2830:1: ( ruleFEATREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2831:1: ruleFEATREF
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureFEATREFParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_ruleFEATREF_in_rule__FeatureInstance__FeatureAssignment_55691);
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


    // $ANTLR start "rule__FeatureInstance__FeatureInstanceAssignment_6_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2842:1: rule__FeatureInstance__FeatureInstanceAssignment_6_1 : ( ruleFeatureInstance ) ;
    public final void rule__FeatureInstance__FeatureInstanceAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2846:1: ( ( ruleFeatureInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2847:1: ( ruleFeatureInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2847:1: ( ruleFeatureInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2848:1: ruleFeatureInstance
            {
             before(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_rule__FeatureInstance__FeatureInstanceAssignment_6_15726);
            ruleFeatureInstance();

            state._fsp--;

             after(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureInstance__FeatureInstanceAssignment_6_1"


    // $ANTLR start "rule__ComponentInstance__CategoryAssignment_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2857:1: rule__ComponentInstance__CategoryAssignment_0 : ( ruleComponentCategory ) ;
    public final void rule__ComponentInstance__CategoryAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2861:1: ( ( ruleComponentCategory ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2862:1: ( ruleComponentCategory )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2862:1: ( ruleComponentCategory )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2863:1: ruleComponentCategory
            {
             before(grammarAccess.getComponentInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_rule__ComponentInstance__CategoryAssignment_05757);
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2872:1: rule__ComponentInstance__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ComponentInstance__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2876:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2877:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2877:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2878:1: RULE_ID
            {
             before(grammarAccess.getComponentInstanceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ComponentInstance__NameAssignment_15788); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2887:1: rule__ComponentInstance__IndexAssignment_2_1 : ( RULE_LONG ) ;
    public final void rule__ComponentInstance__IndexAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2891:1: ( ( RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2892:1: ( RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2892:1: ( RULE_LONG )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2893:1: RULE_LONG
            {
             before(grammarAccess.getComponentInstanceAccess().getIndexLONGTerminalRuleCall_2_1_0()); 
            match(input,RULE_LONG,FOLLOW_RULE_LONG_in_rule__ComponentInstance__IndexAssignment_2_15819); 
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
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2902:1: rule__ComponentInstance__SubcomponentAssignment_4 : ( ( ruleSUBREF ) ) ;
    public final void rule__ComponentInstance__SubcomponentAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2906:1: ( ( ( ruleSUBREF ) ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2907:1: ( ( ruleSUBREF ) )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2907:1: ( ( ruleSUBREF ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2908:1: ( ruleSUBREF )
            {
             before(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentCrossReference_4_0()); 
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2909:1: ( ruleSUBREF )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2910:1: ruleSUBREF
            {
             before(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentSUBREFParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_ruleSUBREF_in_rule__ComponentInstance__SubcomponentAssignment_45854);
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


    // $ANTLR start "rule__ComponentInstance__FeatureInstanceAssignment_5_1_0"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2921:1: rule__ComponentInstance__FeatureInstanceAssignment_5_1_0 : ( ruleFeatureInstance ) ;
    public final void rule__ComponentInstance__FeatureInstanceAssignment_5_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2925:1: ( ( ruleFeatureInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2926:1: ( ruleFeatureInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2926:1: ( ruleFeatureInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2927:1: ruleFeatureInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_5_1_0_0()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_rule__ComponentInstance__FeatureInstanceAssignment_5_1_05889);
            ruleFeatureInstance();

            state._fsp--;

             after(grammarAccess.getComponentInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_5_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__FeatureInstanceAssignment_5_1_0"


    // $ANTLR start "rule__ComponentInstance__ComponentInstanceAssignment_5_1_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2936:1: rule__ComponentInstance__ComponentInstanceAssignment_5_1_1 : ( ruleComponentInstance ) ;
    public final void rule__ComponentInstance__ComponentInstanceAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2940:1: ( ( ruleComponentInstance ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2941:1: ( ruleComponentInstance )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2941:1: ( ruleComponentInstance )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2942:1: ruleComponentInstance
            {
             before(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_5_1_1_0()); 
            pushFollow(FOLLOW_ruleComponentInstance_in_rule__ComponentInstance__ComponentInstanceAssignment_5_1_15920);
            ruleComponentInstance();

            state._fsp--;

             after(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_5_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentInstance__ComponentInstanceAssignment_5_1_1"


    // $ANTLR start "rule__SystemOperationMode__NameAssignment_1"
    // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2951:1: rule__SystemOperationMode__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__SystemOperationMode__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2955:1: ( ( RULE_STRING ) )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2956:1: ( RULE_STRING )
            {
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2956:1: ( RULE_STRING )
            // ../org.osate.xtext.aadl2.instance.ui/src-gen/org/osate/xtext/aadl2/instance/ui/contentassist/antlr/internal/InternalInstance.g:2957:1: RULE_STRING
            {
             before(grammarAccess.getSystemOperationModeAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__SystemOperationMode__NameAssignment_15951); 
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


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\22\uffff";
    static final String DFA5_eofS =
        "\10\uffff\1\14\1\uffff\1\16\7\uffff";
    static final String DFA5_minS =
        "\1\24\7\uffff\1\4\1\uffff\1\4\1\25\6\uffff";
    static final String DFA5_maxS =
        "\1\45\7\uffff\1\44\1\uffff\1\44\1\32\6\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\2\uffff\1\10\1\11\1\14\1\13\1\15\1\16";
    static final String DFA5_specialS =
        "\22\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\7\uffff\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\14\37\uffff\1\15",
            "",
            "\1\16\37\uffff\1\17",
            "\1\20\4\uffff\1\21",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "504:1: rule__ComponentCategory__Alternatives : ( ( 'abstract' ) | ( 'bus' ) | ( 'data' ) | ( 'device' ) | ( 'memory' ) | ( 'process' ) | ( 'processor' ) | ( 'subprogram' ) | ( ( rule__ComponentCategory__Group_8__0 ) ) | ( 'system' ) | ( ( rule__ComponentCategory__Group_10__0 ) ) | ( 'thread' ) | ( ( rule__ComponentCategory__Group_12__0 ) ) | ( ( rule__ComponentCategory__Group_13__0 ) ) );";
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
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemOperationMode248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__0_in_ruleSystemOperationMode274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_entryRuleDirectionType301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDirectionType308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DirectionType__Alternatives_in_ruleDirectionType334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCategory368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureCategory__Alternatives_in_ruleFeatureCategory394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentCategory428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Alternatives_in_ruleComponentCategory454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIMPLREF_in_entryRuleIMPLREF481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIMPLREF488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__0_in_ruleIMPLREF514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFEATREF_in_entryRuleFEATREF541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFEATREF548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__0_in_ruleFEATREF574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSUBREF_in_entryRuleSUBREF601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSUBREF608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__0_in_ruleSUBREF634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__FeatureInstanceAssignment_5_0_in_rule__SystemInstance__Alternatives_5670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__ComponentInstanceAssignment_5_1_in_rule__SystemInstance__Alternatives_5688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__SystemOperationModeAssignment_5_2_in_rule__SystemInstance__Alternatives_5706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__FeatureInstanceAssignment_5_1_0_in_rule__ComponentInstance__Alternatives_5_1739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__ComponentInstanceAssignment_5_1_1_in_rule__ComponentInstance__Alternatives_5_1757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_rule__DirectionType__Alternatives791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__DirectionType__Alternatives811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DirectionType__Group_2__0_in_rule__DirectionType__Alternatives830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__FeatureCategory__Alternatives864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__FeatureCategory__Alternatives884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__FeatureCategory__Alternatives904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__FeatureCategory__Alternatives924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__FeatureCategory__Alternatives944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__FeatureCategory__Alternatives964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__FeatureCategory__Alternatives984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__FeatureCategory__Alternatives1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__FeatureCategory__Alternatives1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ComponentCategory__Alternatives1059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ComponentCategory__Alternatives1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ComponentCategory__Alternatives1099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ComponentCategory__Alternatives1119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ComponentCategory__Alternatives1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ComponentCategory__Alternatives1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ComponentCategory__Alternatives1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ComponentCategory__Alternatives1199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__0_in_rule__ComponentCategory__Alternatives1218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ComponentCategory__Alternatives1237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_10__0_in_rule__ComponentCategory__Alternatives1256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ComponentCategory__Alternatives1275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__0_in_rule__ComponentCategory__Alternatives1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_13__0_in_rule__ComponentCategory__Alternatives1312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__0__Impl_in_rule__SystemInstance__Group__01343 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__1_in_rule__SystemInstance__Group__01346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__CategoryAssignment_0_in_rule__SystemInstance__Group__0__Impl1373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__1__Impl_in_rule__SystemInstance__Group__11403 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__2_in_rule__SystemInstance__Group__11406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__NameAssignment_1_in_rule__SystemInstance__Group__1__Impl1433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__2__Impl_in_rule__SystemInstance__Group__21463 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__3_in_rule__SystemInstance__Group__21466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__SystemInstance__Group__2__Impl1494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__3__Impl_in_rule__SystemInstance__Group__31525 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__4_in_rule__SystemInstance__Group__31528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__ComponentImplementationAssignment_3_in_rule__SystemInstance__Group__3__Impl1555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__4__Impl_in_rule__SystemInstance__Group__41585 = new BitSet(new long[]{0x000000293FF00600L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__5_in_rule__SystemInstance__Group__41588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__SystemInstance__Group__4__Impl1616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__5__Impl_in_rule__SystemInstance__Group__51647 = new BitSet(new long[]{0x000000293FF00600L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__6_in_rule__SystemInstance__Group__51650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemInstance__Alternatives_5_in_rule__SystemInstance__Group__5__Impl1677 = new BitSet(new long[]{0x000000283FF00602L});
    public static final BitSet FOLLOW_rule__SystemInstance__Group__6__Impl_in_rule__SystemInstance__Group__61708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__SystemInstance__Group__6__Impl1736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__0__Impl_in_rule__FeatureInstance__Group__01781 = new BitSet(new long[]{0x00000000000FF800L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__1_in_rule__FeatureInstance__Group__01784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__DirectionAssignment_0_in_rule__FeatureInstance__Group__0__Impl1811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__1__Impl_in_rule__FeatureInstance__Group__11841 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__2_in_rule__FeatureInstance__Group__11844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__CategoryAssignment_1_in_rule__FeatureInstance__Group__1__Impl1871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__2__Impl_in_rule__FeatureInstance__Group__21901 = new BitSet(new long[]{0x0000000240000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__3_in_rule__FeatureInstance__Group__21904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__NameAssignment_2_in_rule__FeatureInstance__Group__2__Impl1931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__3__Impl_in_rule__FeatureInstance__Group__31961 = new BitSet(new long[]{0x0000000240000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__4_in_rule__FeatureInstance__Group__31964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__0_in_rule__FeatureInstance__Group__3__Impl1991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__4__Impl_in_rule__FeatureInstance__Group__42022 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__5_in_rule__FeatureInstance__Group__42025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__FeatureInstance__Group__4__Impl2053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__5__Impl_in_rule__FeatureInstance__Group__52084 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__6_in_rule__FeatureInstance__Group__52087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__FeatureAssignment_5_in_rule__FeatureInstance__Group__5__Impl2114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group__6__Impl_in_rule__FeatureInstance__Group__62144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__0_in_rule__FeatureInstance__Group__6__Impl2171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__0__Impl_in_rule__FeatureInstance__Group_3__02216 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__1_in_rule__FeatureInstance__Group_3__02219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__FeatureInstance__Group_3__0__Impl2247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__1__Impl_in_rule__FeatureInstance__Group_3__12278 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__2_in_rule__FeatureInstance__Group_3__12281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__IndexAssignment_3_1_in_rule__FeatureInstance__Group_3__1__Impl2308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_3__2__Impl_in_rule__FeatureInstance__Group_3__22338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__FeatureInstance__Group_3__2__Impl2366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__0__Impl_in_rule__FeatureInstance__Group_6__02403 = new BitSet(new long[]{0x0000000100000600L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__1_in_rule__FeatureInstance__Group_6__02406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__FeatureInstance__Group_6__0__Impl2434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__1__Impl_in_rule__FeatureInstance__Group_6__12465 = new BitSet(new long[]{0x0000000100000600L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__2_in_rule__FeatureInstance__Group_6__12468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FeatureInstance__FeatureInstanceAssignment_6_1_in_rule__FeatureInstance__Group_6__1__Impl2495 = new BitSet(new long[]{0x0000000000000602L});
    public static final BitSet FOLLOW_rule__FeatureInstance__Group_6__2__Impl_in_rule__FeatureInstance__Group_6__22526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__FeatureInstance__Group_6__2__Impl2554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__0__Impl_in_rule__ComponentInstance__Group__02591 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__1_in_rule__ComponentInstance__Group__02594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__CategoryAssignment_0_in_rule__ComponentInstance__Group__0__Impl2621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__1__Impl_in_rule__ComponentInstance__Group__12651 = new BitSet(new long[]{0x0000000240000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__2_in_rule__ComponentInstance__Group__12654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__NameAssignment_1_in_rule__ComponentInstance__Group__1__Impl2681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__2__Impl_in_rule__ComponentInstance__Group__22711 = new BitSet(new long[]{0x0000000240000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__3_in_rule__ComponentInstance__Group__22714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__0_in_rule__ComponentInstance__Group__2__Impl2741 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__3__Impl_in_rule__ComponentInstance__Group__32772 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__4_in_rule__ComponentInstance__Group__32775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ComponentInstance__Group__3__Impl2803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__4__Impl_in_rule__ComponentInstance__Group__42834 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__5_in_rule__ComponentInstance__Group__42837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__SubcomponentAssignment_4_in_rule__ComponentInstance__Group__4__Impl2864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group__5__Impl_in_rule__ComponentInstance__Group__52894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__0_in_rule__ComponentInstance__Group__5__Impl2921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__0__Impl_in_rule__ComponentInstance__Group_2__02964 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__1_in_rule__ComponentInstance__Group_2__02967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ComponentInstance__Group_2__0__Impl2995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__1__Impl_in_rule__ComponentInstance__Group_2__13026 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__2_in_rule__ComponentInstance__Group_2__13029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__IndexAssignment_2_1_in_rule__ComponentInstance__Group_2__1__Impl3056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_2__2__Impl_in_rule__ComponentInstance__Group_2__23086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__ComponentInstance__Group_2__2__Impl3114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__0__Impl_in_rule__ComponentInstance__Group_5__03151 = new BitSet(new long[]{0x000000213FF00600L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__1_in_rule__ComponentInstance__Group_5__03154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ComponentInstance__Group_5__0__Impl3182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__1__Impl_in_rule__ComponentInstance__Group_5__13213 = new BitSet(new long[]{0x000000213FF00600L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__2_in_rule__ComponentInstance__Group_5__13216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Alternatives_5_1_in_rule__ComponentInstance__Group_5__1__Impl3243 = new BitSet(new long[]{0x000000203FF00602L});
    public static final BitSet FOLLOW_rule__ComponentInstance__Group_5__2__Impl_in_rule__ComponentInstance__Group_5__23274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ComponentInstance__Group_5__2__Impl3302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__0__Impl_in_rule__SystemOperationMode__Group__03339 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__1_in_rule__SystemOperationMode__Group__03342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__SystemOperationMode__Group__0__Impl3370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__Group__1__Impl_in_rule__SystemOperationMode__Group__13401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SystemOperationMode__NameAssignment_1_in_rule__SystemOperationMode__Group__1__Impl3428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DirectionType__Group_2__0__Impl_in_rule__DirectionType__Group_2__03462 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__DirectionType__Group_2__1_in_rule__DirectionType__Group_2__03465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_rule__DirectionType__Group_2__0__Impl3493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DirectionType__Group_2__1__Impl_in_rule__DirectionType__Group_2__13524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__DirectionType__Group_2__1__Impl3552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__0__Impl_in_rule__ComponentCategory__Group_8__03587 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__1_in_rule__ComponentCategory__Group_8__03590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ComponentCategory__Group_8__0__Impl3618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_8__1__Impl_in_rule__ComponentCategory__Group_8__13649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ComponentCategory__Group_8__1__Impl3677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_10__0__Impl_in_rule__ComponentCategory__Group_10__03712 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_10__1_in_rule__ComponentCategory__Group_10__03715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ComponentCategory__Group_10__0__Impl3743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_10__1__Impl_in_rule__ComponentCategory__Group_10__13774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ComponentCategory__Group_10__1__Impl3802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__0__Impl_in_rule__ComponentCategory__Group_12__03837 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__1_in_rule__ComponentCategory__Group_12__03840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ComponentCategory__Group_12__0__Impl3868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_12__1__Impl_in_rule__ComponentCategory__Group_12__13899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ComponentCategory__Group_12__1__Impl3927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_13__0__Impl_in_rule__ComponentCategory__Group_13__03962 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_13__1_in_rule__ComponentCategory__Group_13__03965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ComponentCategory__Group_13__0__Impl3993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group_13__1__Impl_in_rule__ComponentCategory__Group_13__14024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ComponentCategory__Group_13__1__Impl4052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__0__Impl_in_rule__IMPLREF__Group__04087 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__1_in_rule__IMPLREF__Group__04090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group_0__0_in_rule__IMPLREF__Group__0__Impl4119 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group_0__0_in_rule__IMPLREF__Group__0__Impl4131 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__1__Impl_in_rule__IMPLREF__Group__14164 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__2_in_rule__IMPLREF__Group__14167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IMPLREF__Group__1__Impl4194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__2__Impl_in_rule__IMPLREF__Group__24223 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__3_in_rule__IMPLREF__Group__24226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__IMPLREF__Group__2__Impl4254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group__3__Impl_in_rule__IMPLREF__Group__34285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IMPLREF__Group__3__Impl4312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group_0__0__Impl_in_rule__IMPLREF__Group_0__04349 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group_0__1_in_rule__IMPLREF__Group_0__04352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IMPLREF__Group_0__0__Impl4379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IMPLREF__Group_0__1__Impl_in_rule__IMPLREF__Group_0__14408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__IMPLREF__Group_0__1__Impl4436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__0__Impl_in_rule__FEATREF__Group__04471 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__1_in_rule__FEATREF__Group__04474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FEATREF__Group_0__0_in_rule__FEATREF__Group__0__Impl4503 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__FEATREF__Group_0__0_in_rule__FEATREF__Group__0__Impl4515 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__1__Impl_in_rule__FEATREF__Group__14548 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__2_in_rule__FEATREF__Group__14551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FEATREF__Group__1__Impl4578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__2__Impl_in_rule__FEATREF__Group__24607 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__3_in_rule__FEATREF__Group__24610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__FEATREF__Group__2__Impl4638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FEATREF__Group__3__Impl_in_rule__FEATREF__Group__34669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FEATREF__Group__3__Impl4696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FEATREF__Group_0__0__Impl_in_rule__FEATREF__Group_0__04733 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__FEATREF__Group_0__1_in_rule__FEATREF__Group_0__04736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FEATREF__Group_0__0__Impl4763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FEATREF__Group_0__1__Impl_in_rule__FEATREF__Group_0__14792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__FEATREF__Group_0__1__Impl4820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__0__Impl_in_rule__SUBREF__Group__04855 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__1_in_rule__SUBREF__Group__04858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group_0__0_in_rule__SUBREF__Group__0__Impl4887 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SUBREF__Group_0__0_in_rule__SUBREF__Group__0__Impl4899 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__1__Impl_in_rule__SUBREF__Group__14932 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__2_in_rule__SUBREF__Group__14935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SUBREF__Group__1__Impl4962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__2__Impl_in_rule__SUBREF__Group__24991 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__3_in_rule__SUBREF__Group__24994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__SUBREF__Group__2__Impl5022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__3__Impl_in_rule__SUBREF__Group__35053 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__4_in_rule__SUBREF__Group__35056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SUBREF__Group__3__Impl5083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__4__Impl_in_rule__SUBREF__Group__45112 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__5_in_rule__SUBREF__Group__45115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__SUBREF__Group__4__Impl5143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group__5__Impl_in_rule__SUBREF__Group__55174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SUBREF__Group__5__Impl5201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group_0__0__Impl_in_rule__SUBREF__Group_0__05242 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__SUBREF__Group_0__1_in_rule__SUBREF__Group_0__05245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SUBREF__Group_0__0__Impl5272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SUBREF__Group_0__1__Impl_in_rule__SUBREF__Group_0__15301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__SUBREF__Group_0__1__Impl5329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_rule__SystemInstance__CategoryAssignment_05369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SystemInstance__NameAssignment_15400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIMPLREF_in_rule__SystemInstance__ComponentImplementationAssignment_35435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_rule__SystemInstance__FeatureInstanceAssignment_5_05470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_rule__SystemInstance__ComponentInstanceAssignment_5_15501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_rule__SystemInstance__SystemOperationModeAssignment_5_25532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_rule__FeatureInstance__DirectionAssignment_05563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_rule__FeatureInstance__CategoryAssignment_15594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FeatureInstance__NameAssignment_25625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_rule__FeatureInstance__IndexAssignment_3_15656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFEATREF_in_rule__FeatureInstance__FeatureAssignment_55691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_rule__FeatureInstance__FeatureInstanceAssignment_6_15726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_rule__ComponentInstance__CategoryAssignment_05757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ComponentInstance__NameAssignment_15788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_rule__ComponentInstance__IndexAssignment_2_15819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSUBREF_in_rule__ComponentInstance__SubcomponentAssignment_45854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_rule__ComponentInstance__FeatureInstanceAssignment_5_1_05889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_rule__ComponentInstance__ComponentInstanceAssignment_5_1_15920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__SystemOperationMode__NameAssignment_15951 = new BitSet(new long[]{0x0000000000000002L});

}