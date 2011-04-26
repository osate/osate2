package org.osate.xtext.aadl2.properties.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.osate.xtext.aadl2.properties.services.PropertiesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPropertiesParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_SEMI", "RULE_COLON", "RULE_INT", "RULE_DOT", "RULE_NONE", "RULE_LTRANS", "RULE_RTRANS", "RULE_SL_COMMENT", "RULE_COMMA", "RULE_LPARENS", "RULE_RPARENS", "RULE_LBRACKET", "RULE_RBRACKET", "RULE_LCURLY", "RULE_RCURLY", "RULE_ASSIGN", "RULE_APPEND", "RULE_STRING", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'property'", "'set'", "'is'", "'end'", "'type'"
    };
    public static final int RULE_RPARENS=15;
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int RULE_APPEND=21;
    public static final int RULE_ANY_OTHER=25;
    public static final int RULE_LTRANS=10;
    public static final int RULE_COMMA=13;
    public static final int RULE_LBRACKET=16;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=12;
    public static final int RULE_NONE=9;
    public static final int RULE_ML_COMMENT=23;
    public static final int RULE_ASSIGN=20;
    public static final int T__30=30;
    public static final int RULE_COLON=6;
    public static final int RULE_STRING=22;
    public static final int RULE_DOT=8;
    public static final int RULE_LPARENS=14;
    public static final int RULE_INT=7;
    public static final int RULE_RTRANS=11;
    public static final int RULE_WS=24;
    public static final int RULE_RBRACKET=17;
    public static final int RULE_RCURLY=19;
    public static final int RULE_SEMI=5;
    public static final int RULE_LCURLY=18;

    // delegates
    // delegators


        public InternalPropertiesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPropertiesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPropertiesParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g"; }


     
     	private PropertiesGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(PropertiesGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRulePropertySet"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:61:1: entryRulePropertySet : rulePropertySet EOF ;
    public final void entryRulePropertySet() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:62:1: ( rulePropertySet EOF )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:63:1: rulePropertySet EOF
            {
             before(grammarAccess.getPropertySetRule()); 
            pushFollow(FOLLOW_rulePropertySet_in_entryRulePropertySet61);
            rulePropertySet();

            state._fsp--;

             after(grammarAccess.getPropertySetRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertySet68); 

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
    // $ANTLR end "entryRulePropertySet"


    // $ANTLR start "rulePropertySet"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:70:1: rulePropertySet : ( ( rule__PropertySet__Group__0 ) ) ;
    public final void rulePropertySet() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:74:2: ( ( ( rule__PropertySet__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:75:1: ( ( rule__PropertySet__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:75:1: ( ( rule__PropertySet__Group__0 ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:76:1: ( rule__PropertySet__Group__0 )
            {
             before(grammarAccess.getPropertySetAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:77:1: ( rule__PropertySet__Group__0 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:77:2: rule__PropertySet__Group__0
            {
            pushFollow(FOLLOW_rule__PropertySet__Group__0_in_rulePropertySet94);
            rule__PropertySet__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPropertySetAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePropertySet"


    // $ANTLR start "entryRulePropertyType"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:89:1: entryRulePropertyType : rulePropertyType EOF ;
    public final void entryRulePropertyType() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:90:1: ( rulePropertyType EOF )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:91:1: rulePropertyType EOF
            {
             before(grammarAccess.getPropertyTypeRule()); 
            pushFollow(FOLLOW_rulePropertyType_in_entryRulePropertyType121);
            rulePropertyType();

            state._fsp--;

             after(grammarAccess.getPropertyTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyType128); 

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
    // $ANTLR end "entryRulePropertyType"


    // $ANTLR start "rulePropertyType"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:98:1: rulePropertyType : ( ( rule__PropertyType__Group__0 ) ) ;
    public final void rulePropertyType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:102:2: ( ( ( rule__PropertyType__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:103:1: ( ( rule__PropertyType__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:103:1: ( ( rule__PropertyType__Group__0 ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:104:1: ( rule__PropertyType__Group__0 )
            {
             before(grammarAccess.getPropertyTypeAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:105:1: ( rule__PropertyType__Group__0 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:105:2: rule__PropertyType__Group__0
            {
            pushFollow(FOLLOW_rule__PropertyType__Group__0_in_rulePropertyType154);
            rule__PropertyType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPropertyTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePropertyType"


    // $ANTLR start "entryRulePropertyDefinition"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:117:1: entryRulePropertyDefinition : rulePropertyDefinition EOF ;
    public final void entryRulePropertyDefinition() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:118:1: ( rulePropertyDefinition EOF )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:119:1: rulePropertyDefinition EOF
            {
             before(grammarAccess.getPropertyDefinitionRule()); 
            pushFollow(FOLLOW_rulePropertyDefinition_in_entryRulePropertyDefinition181);
            rulePropertyDefinition();

            state._fsp--;

             after(grammarAccess.getPropertyDefinitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyDefinition188); 

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
    // $ANTLR end "entryRulePropertyDefinition"


    // $ANTLR start "rulePropertyDefinition"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:126:1: rulePropertyDefinition : ( ( rule__PropertyDefinition__Group__0 ) ) ;
    public final void rulePropertyDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:130:2: ( ( ( rule__PropertyDefinition__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:131:1: ( ( rule__PropertyDefinition__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:131:1: ( ( rule__PropertyDefinition__Group__0 ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:132:1: ( rule__PropertyDefinition__Group__0 )
            {
             before(grammarAccess.getPropertyDefinitionAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:133:1: ( rule__PropertyDefinition__Group__0 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:133:2: rule__PropertyDefinition__Group__0
            {
            pushFollow(FOLLOW_rule__PropertyDefinition__Group__0_in_rulePropertyDefinition214);
            rule__PropertyDefinition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPropertyDefinitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePropertyDefinition"


    // $ANTLR start "entryRulePropertyExpression"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:147:1: entryRulePropertyExpression : rulePropertyExpression EOF ;
    public final void entryRulePropertyExpression() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:148:1: ( rulePropertyExpression EOF )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:149:1: rulePropertyExpression EOF
            {
             before(grammarAccess.getPropertyExpressionRule()); 
            pushFollow(FOLLOW_rulePropertyExpression_in_entryRulePropertyExpression243);
            rulePropertyExpression();

            state._fsp--;

             after(grammarAccess.getPropertyExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyExpression250); 

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
    // $ANTLR end "entryRulePropertyExpression"


    // $ANTLR start "rulePropertyExpression"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:156:1: rulePropertyExpression : ( ( rule__PropertyExpression__Alternatives ) ) ;
    public final void rulePropertyExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:160:2: ( ( ( rule__PropertyExpression__Alternatives ) ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:161:1: ( ( rule__PropertyExpression__Alternatives ) )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:161:1: ( ( rule__PropertyExpression__Alternatives ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:162:1: ( rule__PropertyExpression__Alternatives )
            {
             before(grammarAccess.getPropertyExpressionAccess().getAlternatives()); 
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:163:1: ( rule__PropertyExpression__Alternatives )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:163:2: rule__PropertyExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__PropertyExpression__Alternatives_in_rulePropertyExpression276);
            rule__PropertyExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPropertyExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePropertyExpression"


    // $ANTLR start "entryRuleLiteral"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:175:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:176:1: ( ruleLiteral EOF )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:177:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral303);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral310); 

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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:184:1: ruleLiteral : ( ( rule__Literal__NameAssignment ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:188:2: ( ( ( rule__Literal__NameAssignment ) ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:189:1: ( ( rule__Literal__NameAssignment ) )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:189:1: ( ( rule__Literal__NameAssignment ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:190:1: ( rule__Literal__NameAssignment )
            {
             before(grammarAccess.getLiteralAccess().getNameAssignment()); 
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:191:1: ( rule__Literal__NameAssignment )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:191:2: rule__Literal__NameAssignment
            {
            pushFollow(FOLLOW_rule__Literal__NameAssignment_in_ruleLiteral336);
            rule__Literal__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getLiteralAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleProbabilityValue"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:203:1: entryRuleProbabilityValue : ruleProbabilityValue EOF ;
    public final void entryRuleProbabilityValue() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:204:1: ( ruleProbabilityValue EOF )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:205:1: ruleProbabilityValue EOF
            {
             before(grammarAccess.getProbabilityValueRule()); 
            pushFollow(FOLLOW_ruleProbabilityValue_in_entryRuleProbabilityValue363);
            ruleProbabilityValue();

            state._fsp--;

             after(grammarAccess.getProbabilityValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProbabilityValue370); 

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
    // $ANTLR end "entryRuleProbabilityValue"


    // $ANTLR start "ruleProbabilityValue"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:212:1: ruleProbabilityValue : ( ( rule__ProbabilityValue__Group__0 ) ) ;
    public final void ruleProbabilityValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:216:2: ( ( ( rule__ProbabilityValue__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:217:1: ( ( rule__ProbabilityValue__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:217:1: ( ( rule__ProbabilityValue__Group__0 ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:218:1: ( rule__ProbabilityValue__Group__0 )
            {
             before(grammarAccess.getProbabilityValueAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:219:1: ( rule__ProbabilityValue__Group__0 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:219:2: rule__ProbabilityValue__Group__0
            {
            pushFollow(FOLLOW_rule__ProbabilityValue__Group__0_in_ruleProbabilityValue396);
            rule__ProbabilityValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getProbabilityValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProbabilityValue"


    // $ANTLR start "entryRuleREAL"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:231:1: entryRuleREAL : ruleREAL EOF ;
    public final void entryRuleREAL() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:232:1: ( ruleREAL EOF )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:233:1: ruleREAL EOF
            {
             before(grammarAccess.getREALRule()); 
            pushFollow(FOLLOW_ruleREAL_in_entryRuleREAL423);
            ruleREAL();

            state._fsp--;

             after(grammarAccess.getREALRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleREAL430); 

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
    // $ANTLR end "entryRuleREAL"


    // $ANTLR start "ruleREAL"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:240:1: ruleREAL : ( ( rule__REAL__Group__0 ) ) ;
    public final void ruleREAL() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:244:2: ( ( ( rule__REAL__Group__0 ) ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:245:1: ( ( rule__REAL__Group__0 ) )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:245:1: ( ( rule__REAL__Group__0 ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:246:1: ( rule__REAL__Group__0 )
            {
             before(grammarAccess.getREALAccess().getGroup()); 
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:247:1: ( rule__REAL__Group__0 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:247:2: rule__REAL__Group__0
            {
            pushFollow(FOLLOW_rule__REAL__Group__0_in_ruleREAL456);
            rule__REAL__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getREALAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleREAL"


    // $ANTLR start "entryRuleINAME"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:263:1: entryRuleINAME : ruleINAME EOF ;
    public final void entryRuleINAME() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:264:1: ( ruleINAME EOF )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:265:1: ruleINAME EOF
            {
             before(grammarAccess.getINAMERule()); 
            pushFollow(FOLLOW_ruleINAME_in_entryRuleINAME487);
            ruleINAME();

            state._fsp--;

             after(grammarAccess.getINAMERule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleINAME494); 

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
    // $ANTLR end "entryRuleINAME"


    // $ANTLR start "ruleINAME"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:272:1: ruleINAME : ( RULE_ID ) ;
    public final void ruleINAME() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:276:2: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:277:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:277:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:278:1: RULE_ID
            {
             before(grammarAccess.getINAMEAccess().getIDTerminalRuleCall()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINAME520); 
             after(grammarAccess.getINAMEAccess().getIDTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleINAME"


    // $ANTLR start "rule__PropertySet__OwnedAlternatives_4_0"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:293:1: rule__PropertySet__OwnedAlternatives_4_0 : ( ( rulePropertyType ) | ( rulePropertyDefinition ) );
    public final void rule__PropertySet__OwnedAlternatives_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:297:1: ( ( rulePropertyType ) | ( rulePropertyDefinition ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==RULE_COLON) ) {
                    int LA1_2 = input.LA(3);

                    if ( (LA1_2==RULE_ID) ) {
                        alt1=2;
                    }
                    else if ( (LA1_2==30) ) {
                        alt1=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:298:1: ( rulePropertyType )
                    {
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:298:1: ( rulePropertyType )
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:299:1: rulePropertyType
                    {
                     before(grammarAccess.getPropertySetAccess().getOwnedPropertyTypeParserRuleCall_4_0_0()); 
                    pushFollow(FOLLOW_rulePropertyType_in_rule__PropertySet__OwnedAlternatives_4_0557);
                    rulePropertyType();

                    state._fsp--;

                     after(grammarAccess.getPropertySetAccess().getOwnedPropertyTypeParserRuleCall_4_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:304:6: ( rulePropertyDefinition )
                    {
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:304:6: ( rulePropertyDefinition )
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:305:1: rulePropertyDefinition
                    {
                     before(grammarAccess.getPropertySetAccess().getOwnedPropertyDefinitionParserRuleCall_4_0_1()); 
                    pushFollow(FOLLOW_rulePropertyDefinition_in_rule__PropertySet__OwnedAlternatives_4_0574);
                    rulePropertyDefinition();

                    state._fsp--;

                     after(grammarAccess.getPropertySetAccess().getOwnedPropertyDefinitionParserRuleCall_4_0_1()); 

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
    // $ANTLR end "rule__PropertySet__OwnedAlternatives_4_0"


    // $ANTLR start "rule__PropertyExpression__Alternatives"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:315:1: rule__PropertyExpression__Alternatives : ( ( ruleLiteral ) | ( ruleProbabilityValue ) );
    public final void rule__PropertyExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:319:1: ( ( ruleLiteral ) | ( ruleProbabilityValue ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_INT) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:320:1: ( ruleLiteral )
                    {
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:320:1: ( ruleLiteral )
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:321:1: ruleLiteral
                    {
                     before(grammarAccess.getPropertyExpressionAccess().getLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleLiteral_in_rule__PropertyExpression__Alternatives606);
                    ruleLiteral();

                    state._fsp--;

                     after(grammarAccess.getPropertyExpressionAccess().getLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:326:6: ( ruleProbabilityValue )
                    {
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:326:6: ( ruleProbabilityValue )
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:327:1: ruleProbabilityValue
                    {
                     before(grammarAccess.getPropertyExpressionAccess().getProbabilityValueParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleProbabilityValue_in_rule__PropertyExpression__Alternatives623);
                    ruleProbabilityValue();

                    state._fsp--;

                     after(grammarAccess.getPropertyExpressionAccess().getProbabilityValueParserRuleCall_1()); 

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
    // $ANTLR end "rule__PropertyExpression__Alternatives"


    // $ANTLR start "rule__PropertySet__Group__0"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:339:1: rule__PropertySet__Group__0 : rule__PropertySet__Group__0__Impl rule__PropertySet__Group__1 ;
    public final void rule__PropertySet__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:343:1: ( rule__PropertySet__Group__0__Impl rule__PropertySet__Group__1 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:344:2: rule__PropertySet__Group__0__Impl rule__PropertySet__Group__1
            {
            pushFollow(FOLLOW_rule__PropertySet__Group__0__Impl_in_rule__PropertySet__Group__0653);
            rule__PropertySet__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertySet__Group__1_in_rule__PropertySet__Group__0656);
            rule__PropertySet__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertySet__Group__0"


    // $ANTLR start "rule__PropertySet__Group__0__Impl"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:351:1: rule__PropertySet__Group__0__Impl : ( 'property' ) ;
    public final void rule__PropertySet__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:355:1: ( ( 'property' ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:356:1: ( 'property' )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:356:1: ( 'property' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:357:1: 'property'
            {
             before(grammarAccess.getPropertySetAccess().getPropertyKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__PropertySet__Group__0__Impl684); 
             after(grammarAccess.getPropertySetAccess().getPropertyKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertySet__Group__0__Impl"


    // $ANTLR start "rule__PropertySet__Group__1"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:370:1: rule__PropertySet__Group__1 : rule__PropertySet__Group__1__Impl rule__PropertySet__Group__2 ;
    public final void rule__PropertySet__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:374:1: ( rule__PropertySet__Group__1__Impl rule__PropertySet__Group__2 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:375:2: rule__PropertySet__Group__1__Impl rule__PropertySet__Group__2
            {
            pushFollow(FOLLOW_rule__PropertySet__Group__1__Impl_in_rule__PropertySet__Group__1715);
            rule__PropertySet__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertySet__Group__2_in_rule__PropertySet__Group__1718);
            rule__PropertySet__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertySet__Group__1"


    // $ANTLR start "rule__PropertySet__Group__1__Impl"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:382:1: rule__PropertySet__Group__1__Impl : ( 'set' ) ;
    public final void rule__PropertySet__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:386:1: ( ( 'set' ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:387:1: ( 'set' )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:387:1: ( 'set' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:388:1: 'set'
            {
             before(grammarAccess.getPropertySetAccess().getSetKeyword_1()); 
            match(input,27,FOLLOW_27_in_rule__PropertySet__Group__1__Impl746); 
             after(grammarAccess.getPropertySetAccess().getSetKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertySet__Group__1__Impl"


    // $ANTLR start "rule__PropertySet__Group__2"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:401:1: rule__PropertySet__Group__2 : rule__PropertySet__Group__2__Impl rule__PropertySet__Group__3 ;
    public final void rule__PropertySet__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:405:1: ( rule__PropertySet__Group__2__Impl rule__PropertySet__Group__3 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:406:2: rule__PropertySet__Group__2__Impl rule__PropertySet__Group__3
            {
            pushFollow(FOLLOW_rule__PropertySet__Group__2__Impl_in_rule__PropertySet__Group__2777);
            rule__PropertySet__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertySet__Group__3_in_rule__PropertySet__Group__2780);
            rule__PropertySet__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertySet__Group__2"


    // $ANTLR start "rule__PropertySet__Group__2__Impl"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:413:1: rule__PropertySet__Group__2__Impl : ( ( rule__PropertySet__NameAssignment_2 ) ) ;
    public final void rule__PropertySet__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:417:1: ( ( ( rule__PropertySet__NameAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:418:1: ( ( rule__PropertySet__NameAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:418:1: ( ( rule__PropertySet__NameAssignment_2 ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:419:1: ( rule__PropertySet__NameAssignment_2 )
            {
             before(grammarAccess.getPropertySetAccess().getNameAssignment_2()); 
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:420:1: ( rule__PropertySet__NameAssignment_2 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:420:2: rule__PropertySet__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__PropertySet__NameAssignment_2_in_rule__PropertySet__Group__2__Impl807);
            rule__PropertySet__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPropertySetAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertySet__Group__2__Impl"


    // $ANTLR start "rule__PropertySet__Group__3"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:430:1: rule__PropertySet__Group__3 : rule__PropertySet__Group__3__Impl rule__PropertySet__Group__4 ;
    public final void rule__PropertySet__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:434:1: ( rule__PropertySet__Group__3__Impl rule__PropertySet__Group__4 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:435:2: rule__PropertySet__Group__3__Impl rule__PropertySet__Group__4
            {
            pushFollow(FOLLOW_rule__PropertySet__Group__3__Impl_in_rule__PropertySet__Group__3837);
            rule__PropertySet__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertySet__Group__4_in_rule__PropertySet__Group__3840);
            rule__PropertySet__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertySet__Group__3"


    // $ANTLR start "rule__PropertySet__Group__3__Impl"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:442:1: rule__PropertySet__Group__3__Impl : ( 'is' ) ;
    public final void rule__PropertySet__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:446:1: ( ( 'is' ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:447:1: ( 'is' )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:447:1: ( 'is' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:448:1: 'is'
            {
             before(grammarAccess.getPropertySetAccess().getIsKeyword_3()); 
            match(input,28,FOLLOW_28_in_rule__PropertySet__Group__3__Impl868); 
             after(grammarAccess.getPropertySetAccess().getIsKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertySet__Group__3__Impl"


    // $ANTLR start "rule__PropertySet__Group__4"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:461:1: rule__PropertySet__Group__4 : rule__PropertySet__Group__4__Impl rule__PropertySet__Group__5 ;
    public final void rule__PropertySet__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:465:1: ( rule__PropertySet__Group__4__Impl rule__PropertySet__Group__5 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:466:2: rule__PropertySet__Group__4__Impl rule__PropertySet__Group__5
            {
            pushFollow(FOLLOW_rule__PropertySet__Group__4__Impl_in_rule__PropertySet__Group__4899);
            rule__PropertySet__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertySet__Group__5_in_rule__PropertySet__Group__4902);
            rule__PropertySet__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertySet__Group__4"


    // $ANTLR start "rule__PropertySet__Group__4__Impl"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:473:1: rule__PropertySet__Group__4__Impl : ( ( ( rule__PropertySet__OwnedAssignment_4 ) ) ( ( rule__PropertySet__OwnedAssignment_4 )* ) ) ;
    public final void rule__PropertySet__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:477:1: ( ( ( ( rule__PropertySet__OwnedAssignment_4 ) ) ( ( rule__PropertySet__OwnedAssignment_4 )* ) ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:478:1: ( ( ( rule__PropertySet__OwnedAssignment_4 ) ) ( ( rule__PropertySet__OwnedAssignment_4 )* ) )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:478:1: ( ( ( rule__PropertySet__OwnedAssignment_4 ) ) ( ( rule__PropertySet__OwnedAssignment_4 )* ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:479:1: ( ( rule__PropertySet__OwnedAssignment_4 ) ) ( ( rule__PropertySet__OwnedAssignment_4 )* )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:479:1: ( ( rule__PropertySet__OwnedAssignment_4 ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:480:1: ( rule__PropertySet__OwnedAssignment_4 )
            {
             before(grammarAccess.getPropertySetAccess().getOwnedAssignment_4()); 
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:481:1: ( rule__PropertySet__OwnedAssignment_4 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:481:2: rule__PropertySet__OwnedAssignment_4
            {
            pushFollow(FOLLOW_rule__PropertySet__OwnedAssignment_4_in_rule__PropertySet__Group__4__Impl931);
            rule__PropertySet__OwnedAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getPropertySetAccess().getOwnedAssignment_4()); 

            }

            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:484:1: ( ( rule__PropertySet__OwnedAssignment_4 )* )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:485:1: ( rule__PropertySet__OwnedAssignment_4 )*
            {
             before(grammarAccess.getPropertySetAccess().getOwnedAssignment_4()); 
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:486:1: ( rule__PropertySet__OwnedAssignment_4 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:486:2: rule__PropertySet__OwnedAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__PropertySet__OwnedAssignment_4_in_rule__PropertySet__Group__4__Impl943);
            	    rule__PropertySet__OwnedAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getPropertySetAccess().getOwnedAssignment_4()); 

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
    // $ANTLR end "rule__PropertySet__Group__4__Impl"


    // $ANTLR start "rule__PropertySet__Group__5"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:497:1: rule__PropertySet__Group__5 : rule__PropertySet__Group__5__Impl rule__PropertySet__Group__6 ;
    public final void rule__PropertySet__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:501:1: ( rule__PropertySet__Group__5__Impl rule__PropertySet__Group__6 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:502:2: rule__PropertySet__Group__5__Impl rule__PropertySet__Group__6
            {
            pushFollow(FOLLOW_rule__PropertySet__Group__5__Impl_in_rule__PropertySet__Group__5976);
            rule__PropertySet__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertySet__Group__6_in_rule__PropertySet__Group__5979);
            rule__PropertySet__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertySet__Group__5"


    // $ANTLR start "rule__PropertySet__Group__5__Impl"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:509:1: rule__PropertySet__Group__5__Impl : ( 'end' ) ;
    public final void rule__PropertySet__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:513:1: ( ( 'end' ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:514:1: ( 'end' )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:514:1: ( 'end' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:515:1: 'end'
            {
             before(grammarAccess.getPropertySetAccess().getEndKeyword_5()); 
            match(input,29,FOLLOW_29_in_rule__PropertySet__Group__5__Impl1007); 
             after(grammarAccess.getPropertySetAccess().getEndKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertySet__Group__5__Impl"


    // $ANTLR start "rule__PropertySet__Group__6"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:528:1: rule__PropertySet__Group__6 : rule__PropertySet__Group__6__Impl rule__PropertySet__Group__7 ;
    public final void rule__PropertySet__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:532:1: ( rule__PropertySet__Group__6__Impl rule__PropertySet__Group__7 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:533:2: rule__PropertySet__Group__6__Impl rule__PropertySet__Group__7
            {
            pushFollow(FOLLOW_rule__PropertySet__Group__6__Impl_in_rule__PropertySet__Group__61038);
            rule__PropertySet__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertySet__Group__7_in_rule__PropertySet__Group__61041);
            rule__PropertySet__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertySet__Group__6"


    // $ANTLR start "rule__PropertySet__Group__6__Impl"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:540:1: rule__PropertySet__Group__6__Impl : ( RULE_ID ) ;
    public final void rule__PropertySet__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:544:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:545:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:545:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:546:1: RULE_ID
            {
             before(grammarAccess.getPropertySetAccess().getIDTerminalRuleCall_6()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PropertySet__Group__6__Impl1068); 
             after(grammarAccess.getPropertySetAccess().getIDTerminalRuleCall_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertySet__Group__6__Impl"


    // $ANTLR start "rule__PropertySet__Group__7"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:557:1: rule__PropertySet__Group__7 : rule__PropertySet__Group__7__Impl ;
    public final void rule__PropertySet__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:561:1: ( rule__PropertySet__Group__7__Impl )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:562:2: rule__PropertySet__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__PropertySet__Group__7__Impl_in_rule__PropertySet__Group__71097);
            rule__PropertySet__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertySet__Group__7"


    // $ANTLR start "rule__PropertySet__Group__7__Impl"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:568:1: rule__PropertySet__Group__7__Impl : ( RULE_SEMI ) ;
    public final void rule__PropertySet__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:572:1: ( ( RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:573:1: ( RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:573:1: ( RULE_SEMI )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:574:1: RULE_SEMI
            {
             before(grammarAccess.getPropertySetAccess().getSEMITerminalRuleCall_7()); 
            match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_rule__PropertySet__Group__7__Impl1124); 
             after(grammarAccess.getPropertySetAccess().getSEMITerminalRuleCall_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertySet__Group__7__Impl"


    // $ANTLR start "rule__PropertyType__Group__0"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:601:1: rule__PropertyType__Group__0 : rule__PropertyType__Group__0__Impl rule__PropertyType__Group__1 ;
    public final void rule__PropertyType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:605:1: ( rule__PropertyType__Group__0__Impl rule__PropertyType__Group__1 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:606:2: rule__PropertyType__Group__0__Impl rule__PropertyType__Group__1
            {
            pushFollow(FOLLOW_rule__PropertyType__Group__0__Impl_in_rule__PropertyType__Group__01169);
            rule__PropertyType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyType__Group__1_in_rule__PropertyType__Group__01172);
            rule__PropertyType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyType__Group__0"


    // $ANTLR start "rule__PropertyType__Group__0__Impl"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:613:1: rule__PropertyType__Group__0__Impl : ( ( rule__PropertyType__NameAssignment_0 ) ) ;
    public final void rule__PropertyType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:617:1: ( ( ( rule__PropertyType__NameAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:618:1: ( ( rule__PropertyType__NameAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:618:1: ( ( rule__PropertyType__NameAssignment_0 ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:619:1: ( rule__PropertyType__NameAssignment_0 )
            {
             before(grammarAccess.getPropertyTypeAccess().getNameAssignment_0()); 
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:620:1: ( rule__PropertyType__NameAssignment_0 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:620:2: rule__PropertyType__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__PropertyType__NameAssignment_0_in_rule__PropertyType__Group__0__Impl1199);
            rule__PropertyType__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPropertyTypeAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyType__Group__0__Impl"


    // $ANTLR start "rule__PropertyType__Group__1"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:630:1: rule__PropertyType__Group__1 : rule__PropertyType__Group__1__Impl rule__PropertyType__Group__2 ;
    public final void rule__PropertyType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:634:1: ( rule__PropertyType__Group__1__Impl rule__PropertyType__Group__2 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:635:2: rule__PropertyType__Group__1__Impl rule__PropertyType__Group__2
            {
            pushFollow(FOLLOW_rule__PropertyType__Group__1__Impl_in_rule__PropertyType__Group__11229);
            rule__PropertyType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyType__Group__2_in_rule__PropertyType__Group__11232);
            rule__PropertyType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyType__Group__1"


    // $ANTLR start "rule__PropertyType__Group__1__Impl"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:642:1: rule__PropertyType__Group__1__Impl : ( RULE_COLON ) ;
    public final void rule__PropertyType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:646:1: ( ( RULE_COLON ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:647:1: ( RULE_COLON )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:647:1: ( RULE_COLON )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:648:1: RULE_COLON
            {
             before(grammarAccess.getPropertyTypeAccess().getCOLONTerminalRuleCall_1()); 
            match(input,RULE_COLON,FOLLOW_RULE_COLON_in_rule__PropertyType__Group__1__Impl1259); 
             after(grammarAccess.getPropertyTypeAccess().getCOLONTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyType__Group__1__Impl"


    // $ANTLR start "rule__PropertyType__Group__2"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:659:1: rule__PropertyType__Group__2 : rule__PropertyType__Group__2__Impl rule__PropertyType__Group__3 ;
    public final void rule__PropertyType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:663:1: ( rule__PropertyType__Group__2__Impl rule__PropertyType__Group__3 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:664:2: rule__PropertyType__Group__2__Impl rule__PropertyType__Group__3
            {
            pushFollow(FOLLOW_rule__PropertyType__Group__2__Impl_in_rule__PropertyType__Group__21288);
            rule__PropertyType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyType__Group__3_in_rule__PropertyType__Group__21291);
            rule__PropertyType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyType__Group__2"


    // $ANTLR start "rule__PropertyType__Group__2__Impl"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:671:1: rule__PropertyType__Group__2__Impl : ( 'type' ) ;
    public final void rule__PropertyType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:675:1: ( ( 'type' ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:676:1: ( 'type' )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:676:1: ( 'type' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:677:1: 'type'
            {
             before(grammarAccess.getPropertyTypeAccess().getTypeKeyword_2()); 
            match(input,30,FOLLOW_30_in_rule__PropertyType__Group__2__Impl1319); 
             after(grammarAccess.getPropertyTypeAccess().getTypeKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyType__Group__2__Impl"


    // $ANTLR start "rule__PropertyType__Group__3"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:690:1: rule__PropertyType__Group__3 : rule__PropertyType__Group__3__Impl ;
    public final void rule__PropertyType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:694:1: ( rule__PropertyType__Group__3__Impl )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:695:2: rule__PropertyType__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__PropertyType__Group__3__Impl_in_rule__PropertyType__Group__31350);
            rule__PropertyType__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyType__Group__3"


    // $ANTLR start "rule__PropertyType__Group__3__Impl"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:701:1: rule__PropertyType__Group__3__Impl : ( RULE_SEMI ) ;
    public final void rule__PropertyType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:705:1: ( ( RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:706:1: ( RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:706:1: ( RULE_SEMI )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:707:1: RULE_SEMI
            {
             before(grammarAccess.getPropertyTypeAccess().getSEMITerminalRuleCall_3()); 
            match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_rule__PropertyType__Group__3__Impl1377); 
             after(grammarAccess.getPropertyTypeAccess().getSEMITerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyType__Group__3__Impl"


    // $ANTLR start "rule__PropertyDefinition__Group__0"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:726:1: rule__PropertyDefinition__Group__0 : rule__PropertyDefinition__Group__0__Impl rule__PropertyDefinition__Group__1 ;
    public final void rule__PropertyDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:730:1: ( rule__PropertyDefinition__Group__0__Impl rule__PropertyDefinition__Group__1 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:731:2: rule__PropertyDefinition__Group__0__Impl rule__PropertyDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__PropertyDefinition__Group__0__Impl_in_rule__PropertyDefinition__Group__01414);
            rule__PropertyDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyDefinition__Group__1_in_rule__PropertyDefinition__Group__01417);
            rule__PropertyDefinition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyDefinition__Group__0"


    // $ANTLR start "rule__PropertyDefinition__Group__0__Impl"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:738:1: rule__PropertyDefinition__Group__0__Impl : ( ( rule__PropertyDefinition__NameAssignment_0 ) ) ;
    public final void rule__PropertyDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:742:1: ( ( ( rule__PropertyDefinition__NameAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:743:1: ( ( rule__PropertyDefinition__NameAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:743:1: ( ( rule__PropertyDefinition__NameAssignment_0 ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:744:1: ( rule__PropertyDefinition__NameAssignment_0 )
            {
             before(grammarAccess.getPropertyDefinitionAccess().getNameAssignment_0()); 
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:745:1: ( rule__PropertyDefinition__NameAssignment_0 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:745:2: rule__PropertyDefinition__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__PropertyDefinition__NameAssignment_0_in_rule__PropertyDefinition__Group__0__Impl1444);
            rule__PropertyDefinition__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPropertyDefinitionAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyDefinition__Group__0__Impl"


    // $ANTLR start "rule__PropertyDefinition__Group__1"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:755:1: rule__PropertyDefinition__Group__1 : rule__PropertyDefinition__Group__1__Impl rule__PropertyDefinition__Group__2 ;
    public final void rule__PropertyDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:759:1: ( rule__PropertyDefinition__Group__1__Impl rule__PropertyDefinition__Group__2 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:760:2: rule__PropertyDefinition__Group__1__Impl rule__PropertyDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__PropertyDefinition__Group__1__Impl_in_rule__PropertyDefinition__Group__11474);
            rule__PropertyDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyDefinition__Group__2_in_rule__PropertyDefinition__Group__11477);
            rule__PropertyDefinition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyDefinition__Group__1"


    // $ANTLR start "rule__PropertyDefinition__Group__1__Impl"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:767:1: rule__PropertyDefinition__Group__1__Impl : ( RULE_COLON ) ;
    public final void rule__PropertyDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:771:1: ( ( RULE_COLON ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:772:1: ( RULE_COLON )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:772:1: ( RULE_COLON )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:773:1: RULE_COLON
            {
             before(grammarAccess.getPropertyDefinitionAccess().getCOLONTerminalRuleCall_1()); 
            match(input,RULE_COLON,FOLLOW_RULE_COLON_in_rule__PropertyDefinition__Group__1__Impl1504); 
             after(grammarAccess.getPropertyDefinitionAccess().getCOLONTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyDefinition__Group__1__Impl"


    // $ANTLR start "rule__PropertyDefinition__Group__2"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:784:1: rule__PropertyDefinition__Group__2 : rule__PropertyDefinition__Group__2__Impl rule__PropertyDefinition__Group__3 ;
    public final void rule__PropertyDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:788:1: ( rule__PropertyDefinition__Group__2__Impl rule__PropertyDefinition__Group__3 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:789:2: rule__PropertyDefinition__Group__2__Impl rule__PropertyDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__PropertyDefinition__Group__2__Impl_in_rule__PropertyDefinition__Group__21533);
            rule__PropertyDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyDefinition__Group__3_in_rule__PropertyDefinition__Group__21536);
            rule__PropertyDefinition__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyDefinition__Group__2"


    // $ANTLR start "rule__PropertyDefinition__Group__2__Impl"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:796:1: rule__PropertyDefinition__Group__2__Impl : ( ( rule__PropertyDefinition__TypeAssignment_2 ) ) ;
    public final void rule__PropertyDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:800:1: ( ( ( rule__PropertyDefinition__TypeAssignment_2 ) ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:801:1: ( ( rule__PropertyDefinition__TypeAssignment_2 ) )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:801:1: ( ( rule__PropertyDefinition__TypeAssignment_2 ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:802:1: ( rule__PropertyDefinition__TypeAssignment_2 )
            {
             before(grammarAccess.getPropertyDefinitionAccess().getTypeAssignment_2()); 
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:803:1: ( rule__PropertyDefinition__TypeAssignment_2 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:803:2: rule__PropertyDefinition__TypeAssignment_2
            {
            pushFollow(FOLLOW_rule__PropertyDefinition__TypeAssignment_2_in_rule__PropertyDefinition__Group__2__Impl1563);
            rule__PropertyDefinition__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPropertyDefinitionAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyDefinition__Group__2__Impl"


    // $ANTLR start "rule__PropertyDefinition__Group__3"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:813:1: rule__PropertyDefinition__Group__3 : rule__PropertyDefinition__Group__3__Impl ;
    public final void rule__PropertyDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:817:1: ( rule__PropertyDefinition__Group__3__Impl )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:818:2: rule__PropertyDefinition__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__PropertyDefinition__Group__3__Impl_in_rule__PropertyDefinition__Group__31593);
            rule__PropertyDefinition__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyDefinition__Group__3"


    // $ANTLR start "rule__PropertyDefinition__Group__3__Impl"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:824:1: rule__PropertyDefinition__Group__3__Impl : ( RULE_SEMI ) ;
    public final void rule__PropertyDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:828:1: ( ( RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:829:1: ( RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:829:1: ( RULE_SEMI )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:830:1: RULE_SEMI
            {
             before(grammarAccess.getPropertyDefinitionAccess().getSEMITerminalRuleCall_3()); 
            match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_rule__PropertyDefinition__Group__3__Impl1620); 
             after(grammarAccess.getPropertyDefinitionAccess().getSEMITerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyDefinition__Group__3__Impl"


    // $ANTLR start "rule__ProbabilityValue__Group__0"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:850:1: rule__ProbabilityValue__Group__0 : rule__ProbabilityValue__Group__0__Impl rule__ProbabilityValue__Group__1 ;
    public final void rule__ProbabilityValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:854:1: ( rule__ProbabilityValue__Group__0__Impl rule__ProbabilityValue__Group__1 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:855:2: rule__ProbabilityValue__Group__0__Impl rule__ProbabilityValue__Group__1
            {
            pushFollow(FOLLOW_rule__ProbabilityValue__Group__0__Impl_in_rule__ProbabilityValue__Group__01658);
            rule__ProbabilityValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ProbabilityValue__Group__1_in_rule__ProbabilityValue__Group__01661);
            rule__ProbabilityValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProbabilityValue__Group__0"


    // $ANTLR start "rule__ProbabilityValue__Group__0__Impl"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:862:1: rule__ProbabilityValue__Group__0__Impl : ( ( rule__ProbabilityValue__NumberAssignment_0 ) ) ;
    public final void rule__ProbabilityValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:866:1: ( ( ( rule__ProbabilityValue__NumberAssignment_0 ) ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:867:1: ( ( rule__ProbabilityValue__NumberAssignment_0 ) )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:867:1: ( ( rule__ProbabilityValue__NumberAssignment_0 ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:868:1: ( rule__ProbabilityValue__NumberAssignment_0 )
            {
             before(grammarAccess.getProbabilityValueAccess().getNumberAssignment_0()); 
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:869:1: ( rule__ProbabilityValue__NumberAssignment_0 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:869:2: rule__ProbabilityValue__NumberAssignment_0
            {
            pushFollow(FOLLOW_rule__ProbabilityValue__NumberAssignment_0_in_rule__ProbabilityValue__Group__0__Impl1688);
            rule__ProbabilityValue__NumberAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getProbabilityValueAccess().getNumberAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProbabilityValue__Group__0__Impl"


    // $ANTLR start "rule__ProbabilityValue__Group__1"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:879:1: rule__ProbabilityValue__Group__1 : rule__ProbabilityValue__Group__1__Impl ;
    public final void rule__ProbabilityValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:883:1: ( rule__ProbabilityValue__Group__1__Impl )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:884:2: rule__ProbabilityValue__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ProbabilityValue__Group__1__Impl_in_rule__ProbabilityValue__Group__11718);
            rule__ProbabilityValue__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProbabilityValue__Group__1"


    // $ANTLR start "rule__ProbabilityValue__Group__1__Impl"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:890:1: rule__ProbabilityValue__Group__1__Impl : ( ( rule__ProbabilityValue__DistributionAssignment_1 ) ) ;
    public final void rule__ProbabilityValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:894:1: ( ( ( rule__ProbabilityValue__DistributionAssignment_1 ) ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:895:1: ( ( rule__ProbabilityValue__DistributionAssignment_1 ) )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:895:1: ( ( rule__ProbabilityValue__DistributionAssignment_1 ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:896:1: ( rule__ProbabilityValue__DistributionAssignment_1 )
            {
             before(grammarAccess.getProbabilityValueAccess().getDistributionAssignment_1()); 
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:897:1: ( rule__ProbabilityValue__DistributionAssignment_1 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:897:2: rule__ProbabilityValue__DistributionAssignment_1
            {
            pushFollow(FOLLOW_rule__ProbabilityValue__DistributionAssignment_1_in_rule__ProbabilityValue__Group__1__Impl1745);
            rule__ProbabilityValue__DistributionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getProbabilityValueAccess().getDistributionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProbabilityValue__Group__1__Impl"


    // $ANTLR start "rule__REAL__Group__0"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:911:1: rule__REAL__Group__0 : rule__REAL__Group__0__Impl rule__REAL__Group__1 ;
    public final void rule__REAL__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:915:1: ( rule__REAL__Group__0__Impl rule__REAL__Group__1 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:916:2: rule__REAL__Group__0__Impl rule__REAL__Group__1
            {
            pushFollow(FOLLOW_rule__REAL__Group__0__Impl_in_rule__REAL__Group__01779);
            rule__REAL__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__REAL__Group__1_in_rule__REAL__Group__01782);
            rule__REAL__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__REAL__Group__0"


    // $ANTLR start "rule__REAL__Group__0__Impl"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:923:1: rule__REAL__Group__0__Impl : ( RULE_INT ) ;
    public final void rule__REAL__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:927:1: ( ( RULE_INT ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:928:1: ( RULE_INT )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:928:1: ( RULE_INT )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:929:1: RULE_INT
            {
             before(grammarAccess.getREALAccess().getINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__REAL__Group__0__Impl1809); 
             after(grammarAccess.getREALAccess().getINTTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__REAL__Group__0__Impl"


    // $ANTLR start "rule__REAL__Group__1"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:940:1: rule__REAL__Group__1 : rule__REAL__Group__1__Impl rule__REAL__Group__2 ;
    public final void rule__REAL__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:944:1: ( rule__REAL__Group__1__Impl rule__REAL__Group__2 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:945:2: rule__REAL__Group__1__Impl rule__REAL__Group__2
            {
            pushFollow(FOLLOW_rule__REAL__Group__1__Impl_in_rule__REAL__Group__11838);
            rule__REAL__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__REAL__Group__2_in_rule__REAL__Group__11841);
            rule__REAL__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__REAL__Group__1"


    // $ANTLR start "rule__REAL__Group__1__Impl"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:952:1: rule__REAL__Group__1__Impl : ( RULE_DOT ) ;
    public final void rule__REAL__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:956:1: ( ( RULE_DOT ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:957:1: ( RULE_DOT )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:957:1: ( RULE_DOT )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:958:1: RULE_DOT
            {
             before(grammarAccess.getREALAccess().getDOTTerminalRuleCall_1()); 
            match(input,RULE_DOT,FOLLOW_RULE_DOT_in_rule__REAL__Group__1__Impl1868); 
             after(grammarAccess.getREALAccess().getDOTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__REAL__Group__1__Impl"


    // $ANTLR start "rule__REAL__Group__2"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:969:1: rule__REAL__Group__2 : rule__REAL__Group__2__Impl ;
    public final void rule__REAL__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:973:1: ( rule__REAL__Group__2__Impl )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:974:2: rule__REAL__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__REAL__Group__2__Impl_in_rule__REAL__Group__21897);
            rule__REAL__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__REAL__Group__2"


    // $ANTLR start "rule__REAL__Group__2__Impl"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:980:1: rule__REAL__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__REAL__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:984:1: ( ( RULE_INT ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:985:1: ( RULE_INT )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:985:1: ( RULE_INT )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:986:1: RULE_INT
            {
             before(grammarAccess.getREALAccess().getINTTerminalRuleCall_2()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__REAL__Group__2__Impl1924); 
             after(grammarAccess.getREALAccess().getINTTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__REAL__Group__2__Impl"


    // $ANTLR start "rule__PropertySet__NameAssignment_2"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1010:1: rule__PropertySet__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__PropertySet__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1014:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1015:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1015:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1016:1: RULE_ID
            {
             before(grammarAccess.getPropertySetAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PropertySet__NameAssignment_21970); 
             after(grammarAccess.getPropertySetAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertySet__NameAssignment_2"


    // $ANTLR start "rule__PropertySet__OwnedAssignment_4"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1025:1: rule__PropertySet__OwnedAssignment_4 : ( ( rule__PropertySet__OwnedAlternatives_4_0 ) ) ;
    public final void rule__PropertySet__OwnedAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1029:1: ( ( ( rule__PropertySet__OwnedAlternatives_4_0 ) ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1030:1: ( ( rule__PropertySet__OwnedAlternatives_4_0 ) )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1030:1: ( ( rule__PropertySet__OwnedAlternatives_4_0 ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1031:1: ( rule__PropertySet__OwnedAlternatives_4_0 )
            {
             before(grammarAccess.getPropertySetAccess().getOwnedAlternatives_4_0()); 
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1032:1: ( rule__PropertySet__OwnedAlternatives_4_0 )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1032:2: rule__PropertySet__OwnedAlternatives_4_0
            {
            pushFollow(FOLLOW_rule__PropertySet__OwnedAlternatives_4_0_in_rule__PropertySet__OwnedAssignment_42001);
            rule__PropertySet__OwnedAlternatives_4_0();

            state._fsp--;


            }

             after(grammarAccess.getPropertySetAccess().getOwnedAlternatives_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertySet__OwnedAssignment_4"


    // $ANTLR start "rule__PropertyType__NameAssignment_0"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1041:1: rule__PropertyType__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__PropertyType__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1045:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1046:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1046:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1047:1: RULE_ID
            {
             before(grammarAccess.getPropertyTypeAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PropertyType__NameAssignment_02034); 
             after(grammarAccess.getPropertyTypeAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyType__NameAssignment_0"


    // $ANTLR start "rule__PropertyDefinition__NameAssignment_0"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1056:1: rule__PropertyDefinition__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__PropertyDefinition__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1060:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1061:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1061:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1062:1: RULE_ID
            {
             before(grammarAccess.getPropertyDefinitionAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PropertyDefinition__NameAssignment_02065); 
             after(grammarAccess.getPropertyDefinitionAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyDefinition__NameAssignment_0"


    // $ANTLR start "rule__PropertyDefinition__TypeAssignment_2"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1071:1: rule__PropertyDefinition__TypeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__PropertyDefinition__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1075:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1076:1: ( ( RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1076:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1077:1: ( RULE_ID )
            {
             before(grammarAccess.getPropertyDefinitionAccess().getTypePropertyTypeCrossReference_2_0()); 
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1078:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1079:1: RULE_ID
            {
             before(grammarAccess.getPropertyDefinitionAccess().getTypePropertyTypeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PropertyDefinition__TypeAssignment_22100); 
             after(grammarAccess.getPropertyDefinitionAccess().getTypePropertyTypeIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getPropertyDefinitionAccess().getTypePropertyTypeCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyDefinition__TypeAssignment_2"


    // $ANTLR start "rule__Literal__NameAssignment"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1092:1: rule__Literal__NameAssignment : ( RULE_ID ) ;
    public final void rule__Literal__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1096:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1097:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1097:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1098:1: RULE_ID
            {
             before(grammarAccess.getLiteralAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Literal__NameAssignment2137); 
             after(grammarAccess.getLiteralAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__NameAssignment"


    // $ANTLR start "rule__ProbabilityValue__NumberAssignment_0"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1107:1: rule__ProbabilityValue__NumberAssignment_0 : ( ruleREAL ) ;
    public final void rule__ProbabilityValue__NumberAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1111:1: ( ( ruleREAL ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1112:1: ( ruleREAL )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1112:1: ( ruleREAL )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1113:1: ruleREAL
            {
             before(grammarAccess.getProbabilityValueAccess().getNumberREALParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleREAL_in_rule__ProbabilityValue__NumberAssignment_02168);
            ruleREAL();

            state._fsp--;

             after(grammarAccess.getProbabilityValueAccess().getNumberREALParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProbabilityValue__NumberAssignment_0"


    // $ANTLR start "rule__ProbabilityValue__DistributionAssignment_1"
    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1122:1: rule__ProbabilityValue__DistributionAssignment_1 : ( RULE_ID ) ;
    public final void rule__ProbabilityValue__DistributionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1126:1: ( ( RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1127:1: ( RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1127:1: ( RULE_ID )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/internal/InternalProperties.g:1128:1: RULE_ID
            {
             before(grammarAccess.getProbabilityValueAccess().getDistributionIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ProbabilityValue__DistributionAssignment_12199); 
             after(grammarAccess.getProbabilityValueAccess().getDistributionIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProbabilityValue__DistributionAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_rulePropertySet_in_entryRulePropertySet61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertySet68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertySet__Group__0_in_rulePropertySet94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyType_in_entryRulePropertyType121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyType128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyType__Group__0_in_rulePropertyType154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyDefinition_in_entryRulePropertyDefinition181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyDefinition188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyDefinition__Group__0_in_rulePropertyDefinition214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_entryRulePropertyExpression243 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyExpression250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyExpression__Alternatives_in_rulePropertyExpression276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral303 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__NameAssignment_in_ruleLiteral336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProbabilityValue_in_entryRuleProbabilityValue363 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProbabilityValue370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProbabilityValue__Group__0_in_ruleProbabilityValue396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_entryRuleREAL423 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleREAL430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__REAL__Group__0_in_ruleREAL456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINAME_in_entryRuleINAME487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINAME494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINAME520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyType_in_rule__PropertySet__OwnedAlternatives_4_0557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyDefinition_in_rule__PropertySet__OwnedAlternatives_4_0574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__PropertyExpression__Alternatives606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProbabilityValue_in_rule__PropertyExpression__Alternatives623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertySet__Group__0__Impl_in_rule__PropertySet__Group__0653 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__PropertySet__Group__1_in_rule__PropertySet__Group__0656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__PropertySet__Group__0__Impl684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertySet__Group__1__Impl_in_rule__PropertySet__Group__1715 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PropertySet__Group__2_in_rule__PropertySet__Group__1718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__PropertySet__Group__1__Impl746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertySet__Group__2__Impl_in_rule__PropertySet__Group__2777 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__PropertySet__Group__3_in_rule__PropertySet__Group__2780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertySet__NameAssignment_2_in_rule__PropertySet__Group__2__Impl807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertySet__Group__3__Impl_in_rule__PropertySet__Group__3837 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PropertySet__Group__4_in_rule__PropertySet__Group__3840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__PropertySet__Group__3__Impl868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertySet__Group__4__Impl_in_rule__PropertySet__Group__4899 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__PropertySet__Group__5_in_rule__PropertySet__Group__4902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertySet__OwnedAssignment_4_in_rule__PropertySet__Group__4__Impl931 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__PropertySet__OwnedAssignment_4_in_rule__PropertySet__Group__4__Impl943 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__PropertySet__Group__5__Impl_in_rule__PropertySet__Group__5976 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PropertySet__Group__6_in_rule__PropertySet__Group__5979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__PropertySet__Group__5__Impl1007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertySet__Group__6__Impl_in_rule__PropertySet__Group__61038 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PropertySet__Group__7_in_rule__PropertySet__Group__61041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PropertySet__Group__6__Impl1068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertySet__Group__7__Impl_in_rule__PropertySet__Group__71097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SEMI_in_rule__PropertySet__Group__7__Impl1124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyType__Group__0__Impl_in_rule__PropertyType__Group__01169 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__PropertyType__Group__1_in_rule__PropertyType__Group__01172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyType__NameAssignment_0_in_rule__PropertyType__Group__0__Impl1199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyType__Group__1__Impl_in_rule__PropertyType__Group__11229 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__PropertyType__Group__2_in_rule__PropertyType__Group__11232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_COLON_in_rule__PropertyType__Group__1__Impl1259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyType__Group__2__Impl_in_rule__PropertyType__Group__21288 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PropertyType__Group__3_in_rule__PropertyType__Group__21291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__PropertyType__Group__2__Impl1319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyType__Group__3__Impl_in_rule__PropertyType__Group__31350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SEMI_in_rule__PropertyType__Group__3__Impl1377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyDefinition__Group__0__Impl_in_rule__PropertyDefinition__Group__01414 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__PropertyDefinition__Group__1_in_rule__PropertyDefinition__Group__01417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyDefinition__NameAssignment_0_in_rule__PropertyDefinition__Group__0__Impl1444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyDefinition__Group__1__Impl_in_rule__PropertyDefinition__Group__11474 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PropertyDefinition__Group__2_in_rule__PropertyDefinition__Group__11477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_COLON_in_rule__PropertyDefinition__Group__1__Impl1504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyDefinition__Group__2__Impl_in_rule__PropertyDefinition__Group__21533 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PropertyDefinition__Group__3_in_rule__PropertyDefinition__Group__21536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyDefinition__TypeAssignment_2_in_rule__PropertyDefinition__Group__2__Impl1563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyDefinition__Group__3__Impl_in_rule__PropertyDefinition__Group__31593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SEMI_in_rule__PropertyDefinition__Group__3__Impl1620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProbabilityValue__Group__0__Impl_in_rule__ProbabilityValue__Group__01658 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ProbabilityValue__Group__1_in_rule__ProbabilityValue__Group__01661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProbabilityValue__NumberAssignment_0_in_rule__ProbabilityValue__Group__0__Impl1688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProbabilityValue__Group__1__Impl_in_rule__ProbabilityValue__Group__11718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProbabilityValue__DistributionAssignment_1_in_rule__ProbabilityValue__Group__1__Impl1745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__REAL__Group__0__Impl_in_rule__REAL__Group__01779 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__REAL__Group__1_in_rule__REAL__Group__01782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__REAL__Group__0__Impl1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__REAL__Group__1__Impl_in_rule__REAL__Group__11838 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__REAL__Group__2_in_rule__REAL__Group__11841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_rule__REAL__Group__1__Impl1868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__REAL__Group__2__Impl_in_rule__REAL__Group__21897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__REAL__Group__2__Impl1924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PropertySet__NameAssignment_21970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertySet__OwnedAlternatives_4_0_in_rule__PropertySet__OwnedAssignment_42001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PropertyType__NameAssignment_02034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PropertyDefinition__NameAssignment_02065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PropertyDefinition__TypeAssignment_22100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Literal__NameAssignment2137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_rule__ProbabilityValue__NumberAssignment_02168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ProbabilityValue__DistributionAssignment_12199 = new BitSet(new long[]{0x0000000000000002L});

}