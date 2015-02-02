package org.osate.alisa.common.ui.contentassist.antlr.internal; 

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
import org.osate.alisa.common.services.CommonGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCommonParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'%'", "'.'", "'&'", "'this'"
    };
    public static final int RULE_ID=6;
    public static final int RULE_STRING=5;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=4;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalCommonParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCommonParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCommonParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g"; }


     
     	private CommonGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(CommonGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleModel"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:61:1: ( ruleModel EOF )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel68); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:69:1: ruleModel : ( ( rule__Model__ContentAssignment ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:73:2: ( ( ( rule__Model__ContentAssignment ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:74:1: ( ( rule__Model__ContentAssignment ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:74:1: ( ( rule__Model__ContentAssignment ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:75:1: ( rule__Model__ContentAssignment )
            {
             before(grammarAccess.getModelAccess().getContentAssignment()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:76:1: ( rule__Model__ContentAssignment )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:76:2: rule__Model__ContentAssignment
            {
            pushFollow(FOLLOW_rule__Model__ContentAssignment_in_ruleModel94);
            rule__Model__ContentAssignment();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getContentAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDescription"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:88:1: entryRuleDescription : ruleDescription EOF ;
    public final void entryRuleDescription() throws RecognitionException {
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:89:1: ( ruleDescription EOF )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:90:1: ruleDescription EOF
            {
             before(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription121);
            ruleDescription();

            state._fsp--;

             after(grammarAccess.getDescriptionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription128); 

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
    // $ANTLR end "entryRuleDescription"


    // $ANTLR start "ruleDescription"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:97:1: ruleDescription : ( ( ( rule__Description__DescriptionAssignment ) ) ( ( rule__Description__DescriptionAssignment )* ) ) ;
    public final void ruleDescription() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:101:2: ( ( ( ( rule__Description__DescriptionAssignment ) ) ( ( rule__Description__DescriptionAssignment )* ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:102:1: ( ( ( rule__Description__DescriptionAssignment ) ) ( ( rule__Description__DescriptionAssignment )* ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:102:1: ( ( ( rule__Description__DescriptionAssignment ) ) ( ( rule__Description__DescriptionAssignment )* ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:103:1: ( ( rule__Description__DescriptionAssignment ) ) ( ( rule__Description__DescriptionAssignment )* )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:103:1: ( ( rule__Description__DescriptionAssignment ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:104:1: ( rule__Description__DescriptionAssignment )
            {
             before(grammarAccess.getDescriptionAccess().getDescriptionAssignment()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:105:1: ( rule__Description__DescriptionAssignment )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:105:2: rule__Description__DescriptionAssignment
            {
            pushFollow(FOLLOW_rule__Description__DescriptionAssignment_in_ruleDescription156);
            rule__Description__DescriptionAssignment();

            state._fsp--;


            }

             after(grammarAccess.getDescriptionAccess().getDescriptionAssignment()); 

            }

            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:108:1: ( ( rule__Description__DescriptionAssignment )* )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:109:1: ( rule__Description__DescriptionAssignment )*
            {
             before(grammarAccess.getDescriptionAccess().getDescriptionAssignment()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:110:1: ( rule__Description__DescriptionAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)||(LA1_0>=13 && LA1_0<=14)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:110:2: rule__Description__DescriptionAssignment
            	    {
            	    pushFollow(FOLLOW_rule__Description__DescriptionAssignment_in_ruleDescription168);
            	    rule__Description__DescriptionAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getDescriptionAccess().getDescriptionAssignment()); 

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
    // $ANTLR end "ruleDescription"


    // $ANTLR start "entryRuleDescriptionElement"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:123:1: entryRuleDescriptionElement : ruleDescriptionElement EOF ;
    public final void entryRuleDescriptionElement() throws RecognitionException {
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:124:1: ( ruleDescriptionElement EOF )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:125:1: ruleDescriptionElement EOF
            {
             before(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement198);
            ruleDescriptionElement();

            state._fsp--;

             after(grammarAccess.getDescriptionElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement205); 

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
    // $ANTLR end "entryRuleDescriptionElement"


    // $ANTLR start "ruleDescriptionElement"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:132:1: ruleDescriptionElement : ( ( rule__DescriptionElement__Alternatives ) ) ;
    public final void ruleDescriptionElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:136:2: ( ( ( rule__DescriptionElement__Alternatives ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:137:1: ( ( rule__DescriptionElement__Alternatives ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:137:1: ( ( rule__DescriptionElement__Alternatives ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:138:1: ( rule__DescriptionElement__Alternatives )
            {
             before(grammarAccess.getDescriptionElementAccess().getAlternatives()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:139:1: ( rule__DescriptionElement__Alternatives )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:139:2: rule__DescriptionElement__Alternatives
            {
            pushFollow(FOLLOW_rule__DescriptionElement__Alternatives_in_ruleDescriptionElement231);
            rule__DescriptionElement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDescriptionElementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDescriptionElement"


    // $ANTLR start "entryRuleShowValue"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:151:1: entryRuleShowValue : ruleShowValue EOF ;
    public final void entryRuleShowValue() throws RecognitionException {
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:152:1: ( ruleShowValue EOF )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:153:1: ruleShowValue EOF
            {
             before(grammarAccess.getShowValueRule()); 
            pushFollow(FOLLOW_ruleShowValue_in_entryRuleShowValue258);
            ruleShowValue();

            state._fsp--;

             after(grammarAccess.getShowValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleShowValue265); 

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
    // $ANTLR end "entryRuleShowValue"


    // $ANTLR start "ruleShowValue"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:160:1: ruleShowValue : ( ( rule__ShowValue__Group__0 ) ) ;
    public final void ruleShowValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:164:2: ( ( ( rule__ShowValue__Group__0 ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:165:1: ( ( rule__ShowValue__Group__0 ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:165:1: ( ( rule__ShowValue__Group__0 ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:166:1: ( rule__ShowValue__Group__0 )
            {
             before(grammarAccess.getShowValueAccess().getGroup()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:167:1: ( rule__ShowValue__Group__0 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:167:2: rule__ShowValue__Group__0
            {
            pushFollow(FOLLOW_rule__ShowValue__Group__0_in_ruleShowValue291);
            rule__ShowValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getShowValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleShowValue"


    // $ANTLR start "entryRuleReferencePath"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:179:1: entryRuleReferencePath : ruleReferencePath EOF ;
    public final void entryRuleReferencePath() throws RecognitionException {
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:180:1: ( ruleReferencePath EOF )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:181:1: ruleReferencePath EOF
            {
             before(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath318);
            ruleReferencePath();

            state._fsp--;

             after(grammarAccess.getReferencePathRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath325); 

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
    // $ANTLR end "entryRuleReferencePath"


    // $ANTLR start "ruleReferencePath"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:188:1: ruleReferencePath : ( ( rule__ReferencePath__Group__0 ) ) ;
    public final void ruleReferencePath() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:192:2: ( ( ( rule__ReferencePath__Group__0 ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:193:1: ( ( rule__ReferencePath__Group__0 ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:193:1: ( ( rule__ReferencePath__Group__0 ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:194:1: ( rule__ReferencePath__Group__0 )
            {
             before(grammarAccess.getReferencePathAccess().getGroup()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:195:1: ( rule__ReferencePath__Group__0 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:195:2: rule__ReferencePath__Group__0
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group__0_in_ruleReferencePath351);
            rule__ReferencePath__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReferencePathAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReferencePath"


    // $ANTLR start "entryRuleConstantValue"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:211:1: entryRuleConstantValue : ruleConstantValue EOF ;
    public final void entryRuleConstantValue() throws RecognitionException {
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:212:1: ( ruleConstantValue EOF )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:213:1: ruleConstantValue EOF
            {
             before(grammarAccess.getConstantValueRule()); 
            pushFollow(FOLLOW_ruleConstantValue_in_entryRuleConstantValue382);
            ruleConstantValue();

            state._fsp--;

             after(grammarAccess.getConstantValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstantValue389); 

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
    // $ANTLR end "entryRuleConstantValue"


    // $ANTLR start "ruleConstantValue"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:220:1: ruleConstantValue : ( ( rule__ConstantValue__Alternatives ) ) ;
    public final void ruleConstantValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:224:2: ( ( ( rule__ConstantValue__Alternatives ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:225:1: ( ( rule__ConstantValue__Alternatives ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:225:1: ( ( rule__ConstantValue__Alternatives ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:226:1: ( rule__ConstantValue__Alternatives )
            {
             before(grammarAccess.getConstantValueAccess().getAlternatives()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:227:1: ( rule__ConstantValue__Alternatives )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:227:2: rule__ConstantValue__Alternatives
            {
            pushFollow(FOLLOW_rule__ConstantValue__Alternatives_in_ruleConstantValue415);
            rule__ConstantValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConstantValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstantValue"


    // $ANTLR start "entryRuleStringTerm"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:239:1: entryRuleStringTerm : ruleStringTerm EOF ;
    public final void entryRuleStringTerm() throws RecognitionException {
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:240:1: ( ruleStringTerm EOF )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:241:1: ruleStringTerm EOF
            {
             before(grammarAccess.getStringTermRule()); 
            pushFollow(FOLLOW_ruleStringTerm_in_entryRuleStringTerm442);
            ruleStringTerm();

            state._fsp--;

             after(grammarAccess.getStringTermRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringTerm449); 

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
    // $ANTLR end "entryRuleStringTerm"


    // $ANTLR start "ruleStringTerm"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:248:1: ruleStringTerm : ( ( rule__StringTerm__ValueAssignment ) ) ;
    public final void ruleStringTerm() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:252:2: ( ( ( rule__StringTerm__ValueAssignment ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:253:1: ( ( rule__StringTerm__ValueAssignment ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:253:1: ( ( rule__StringTerm__ValueAssignment ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:254:1: ( rule__StringTerm__ValueAssignment )
            {
             before(grammarAccess.getStringTermAccess().getValueAssignment()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:255:1: ( rule__StringTerm__ValueAssignment )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:255:2: rule__StringTerm__ValueAssignment
            {
            pushFollow(FOLLOW_rule__StringTerm__ValueAssignment_in_ruleStringTerm475);
            rule__StringTerm__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getStringTermAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStringTerm"


    // $ANTLR start "entryRuleRealTerm"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:267:1: entryRuleRealTerm : ruleRealTerm EOF ;
    public final void entryRuleRealTerm() throws RecognitionException {
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:268:1: ( ruleRealTerm EOF )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:269:1: ruleRealTerm EOF
            {
             before(grammarAccess.getRealTermRule()); 
            pushFollow(FOLLOW_ruleRealTerm_in_entryRuleRealTerm502);
            ruleRealTerm();

            state._fsp--;

             after(grammarAccess.getRealTermRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealTerm509); 

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
    // $ANTLR end "entryRuleRealTerm"


    // $ANTLR start "ruleRealTerm"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:276:1: ruleRealTerm : ( ( rule__RealTerm__Group__0 ) ) ;
    public final void ruleRealTerm() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:280:2: ( ( ( rule__RealTerm__Group__0 ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:281:1: ( ( rule__RealTerm__Group__0 ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:281:1: ( ( rule__RealTerm__Group__0 ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:282:1: ( rule__RealTerm__Group__0 )
            {
             before(grammarAccess.getRealTermAccess().getGroup()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:283:1: ( rule__RealTerm__Group__0 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:283:2: rule__RealTerm__Group__0
            {
            pushFollow(FOLLOW_rule__RealTerm__Group__0_in_ruleRealTerm535);
            rule__RealTerm__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRealTermAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRealTerm"


    // $ANTLR start "entryRuleREAL"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:295:1: entryRuleREAL : ruleREAL EOF ;
    public final void entryRuleREAL() throws RecognitionException {
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:296:1: ( ruleREAL EOF )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:297:1: ruleREAL EOF
            {
             before(grammarAccess.getREALRule()); 
            pushFollow(FOLLOW_ruleREAL_in_entryRuleREAL562);
            ruleREAL();

            state._fsp--;

             after(grammarAccess.getREALRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleREAL569); 

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
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:304:1: ruleREAL : ( ( rule__REAL__Group__0 ) ) ;
    public final void ruleREAL() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:308:2: ( ( ( rule__REAL__Group__0 ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:309:1: ( ( rule__REAL__Group__0 ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:309:1: ( ( rule__REAL__Group__0 ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:310:1: ( rule__REAL__Group__0 )
            {
             before(grammarAccess.getREALAccess().getGroup()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:311:1: ( rule__REAL__Group__0 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:311:2: rule__REAL__Group__0
            {
            pushFollow(FOLLOW_rule__REAL__Group__0_in_ruleREAL595);
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


    // $ANTLR start "entryRuleIntegerTerm"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:323:1: entryRuleIntegerTerm : ruleIntegerTerm EOF ;
    public final void entryRuleIntegerTerm() throws RecognitionException {
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:324:1: ( ruleIntegerTerm EOF )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:325:1: ruleIntegerTerm EOF
            {
             before(grammarAccess.getIntegerTermRule()); 
            pushFollow(FOLLOW_ruleIntegerTerm_in_entryRuleIntegerTerm622);
            ruleIntegerTerm();

            state._fsp--;

             after(grammarAccess.getIntegerTermRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerTerm629); 

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
    // $ANTLR end "entryRuleIntegerTerm"


    // $ANTLR start "ruleIntegerTerm"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:332:1: ruleIntegerTerm : ( ( rule__IntegerTerm__Group__0 ) ) ;
    public final void ruleIntegerTerm() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:336:2: ( ( ( rule__IntegerTerm__Group__0 ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:337:1: ( ( rule__IntegerTerm__Group__0 ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:337:1: ( ( rule__IntegerTerm__Group__0 ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:338:1: ( rule__IntegerTerm__Group__0 )
            {
             before(grammarAccess.getIntegerTermAccess().getGroup()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:339:1: ( rule__IntegerTerm__Group__0 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:339:2: rule__IntegerTerm__Group__0
            {
            pushFollow(FOLLOW_rule__IntegerTerm__Group__0_in_ruleIntegerTerm655);
            rule__IntegerTerm__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIntegerTermAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntegerTerm"


    // $ANTLR start "entryRuleTextElement"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:353:1: entryRuleTextElement : ruleTextElement EOF ;
    public final void entryRuleTextElement() throws RecognitionException {
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:354:1: ( ruleTextElement EOF )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:355:1: ruleTextElement EOF
            {
             before(grammarAccess.getTextElementRule()); 
            pushFollow(FOLLOW_ruleTextElement_in_entryRuleTextElement684);
            ruleTextElement();

            state._fsp--;

             after(grammarAccess.getTextElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTextElement691); 

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
    // $ANTLR end "entryRuleTextElement"


    // $ANTLR start "ruleTextElement"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:362:1: ruleTextElement : ( ( rule__TextElement__Alternatives ) ) ;
    public final void ruleTextElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:366:2: ( ( ( rule__TextElement__Alternatives ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:367:1: ( ( rule__TextElement__Alternatives ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:367:1: ( ( rule__TextElement__Alternatives ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:368:1: ( rule__TextElement__Alternatives )
            {
             before(grammarAccess.getTextElementAccess().getAlternatives()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:369:1: ( rule__TextElement__Alternatives )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:369:2: rule__TextElement__Alternatives
            {
            pushFollow(FOLLOW_rule__TextElement__Alternatives_in_ruleTextElement717);
            rule__TextElement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTextElementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTextElement"


    // $ANTLR start "rule__DescriptionElement__Alternatives"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:391:1: rule__DescriptionElement__Alternatives : ( ( ( rule__DescriptionElement__TextAssignment_0 ) ) | ( ( rule__DescriptionElement__ValueAssignment_1 ) ) | ( ( rule__DescriptionElement__NewlineAssignment_2 ) ) | ( ( rule__DescriptionElement__ThisTargetAssignment_3 ) ) );
    public final void rule__DescriptionElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:395:1: ( ( ( rule__DescriptionElement__TextAssignment_0 ) ) | ( ( rule__DescriptionElement__ValueAssignment_1 ) ) | ( ( rule__DescriptionElement__NewlineAssignment_2 ) ) | ( ( rule__DescriptionElement__ThisTargetAssignment_3 ) ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt2=1;
                }
                break;
            case RULE_ID:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            case 14:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:396:1: ( ( rule__DescriptionElement__TextAssignment_0 ) )
                    {
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:396:1: ( ( rule__DescriptionElement__TextAssignment_0 ) )
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:397:1: ( rule__DescriptionElement__TextAssignment_0 )
                    {
                     before(grammarAccess.getDescriptionElementAccess().getTextAssignment_0()); 
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:398:1: ( rule__DescriptionElement__TextAssignment_0 )
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:398:2: rule__DescriptionElement__TextAssignment_0
                    {
                    pushFollow(FOLLOW_rule__DescriptionElement__TextAssignment_0_in_rule__DescriptionElement__Alternatives763);
                    rule__DescriptionElement__TextAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDescriptionElementAccess().getTextAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:402:6: ( ( rule__DescriptionElement__ValueAssignment_1 ) )
                    {
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:402:6: ( ( rule__DescriptionElement__ValueAssignment_1 ) )
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:403:1: ( rule__DescriptionElement__ValueAssignment_1 )
                    {
                     before(grammarAccess.getDescriptionElementAccess().getValueAssignment_1()); 
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:404:1: ( rule__DescriptionElement__ValueAssignment_1 )
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:404:2: rule__DescriptionElement__ValueAssignment_1
                    {
                    pushFollow(FOLLOW_rule__DescriptionElement__ValueAssignment_1_in_rule__DescriptionElement__Alternatives781);
                    rule__DescriptionElement__ValueAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getDescriptionElementAccess().getValueAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:408:6: ( ( rule__DescriptionElement__NewlineAssignment_2 ) )
                    {
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:408:6: ( ( rule__DescriptionElement__NewlineAssignment_2 ) )
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:409:1: ( rule__DescriptionElement__NewlineAssignment_2 )
                    {
                     before(grammarAccess.getDescriptionElementAccess().getNewlineAssignment_2()); 
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:410:1: ( rule__DescriptionElement__NewlineAssignment_2 )
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:410:2: rule__DescriptionElement__NewlineAssignment_2
                    {
                    pushFollow(FOLLOW_rule__DescriptionElement__NewlineAssignment_2_in_rule__DescriptionElement__Alternatives799);
                    rule__DescriptionElement__NewlineAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getDescriptionElementAccess().getNewlineAssignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:414:6: ( ( rule__DescriptionElement__ThisTargetAssignment_3 ) )
                    {
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:414:6: ( ( rule__DescriptionElement__ThisTargetAssignment_3 ) )
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:415:1: ( rule__DescriptionElement__ThisTargetAssignment_3 )
                    {
                     before(grammarAccess.getDescriptionElementAccess().getThisTargetAssignment_3()); 
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:416:1: ( rule__DescriptionElement__ThisTargetAssignment_3 )
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:416:2: rule__DescriptionElement__ThisTargetAssignment_3
                    {
                    pushFollow(FOLLOW_rule__DescriptionElement__ThisTargetAssignment_3_in_rule__DescriptionElement__Alternatives817);
                    rule__DescriptionElement__ThisTargetAssignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getDescriptionElementAccess().getThisTargetAssignment_3()); 

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
    // $ANTLR end "rule__DescriptionElement__Alternatives"


    // $ANTLR start "rule__ConstantValue__Alternatives"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:426:1: rule__ConstantValue__Alternatives : ( ( ruleStringTerm ) | ( ruleRealTerm ) | ( ruleIntegerTerm ) );
    public final void rule__ConstantValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:430:1: ( ( ruleStringTerm ) | ( ruleRealTerm ) | ( ruleIntegerTerm ) )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_STRING) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_INT) ) {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==EOF||LA3_2==RULE_ID) ) {
                    alt3=3;
                }
                else if ( (LA3_2==12) ) {
                    alt3=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:431:1: ( ruleStringTerm )
                    {
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:431:1: ( ruleStringTerm )
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:432:1: ruleStringTerm
                    {
                     before(grammarAccess.getConstantValueAccess().getStringTermParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleStringTerm_in_rule__ConstantValue__Alternatives851);
                    ruleStringTerm();

                    state._fsp--;

                     after(grammarAccess.getConstantValueAccess().getStringTermParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:437:6: ( ruleRealTerm )
                    {
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:437:6: ( ruleRealTerm )
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:438:1: ruleRealTerm
                    {
                     before(grammarAccess.getConstantValueAccess().getRealTermParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleRealTerm_in_rule__ConstantValue__Alternatives868);
                    ruleRealTerm();

                    state._fsp--;

                     after(grammarAccess.getConstantValueAccess().getRealTermParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:443:6: ( ruleIntegerTerm )
                    {
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:443:6: ( ruleIntegerTerm )
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:444:1: ruleIntegerTerm
                    {
                     before(grammarAccess.getConstantValueAccess().getIntegerTermParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleIntegerTerm_in_rule__ConstantValue__Alternatives885);
                    ruleIntegerTerm();

                    state._fsp--;

                     after(grammarAccess.getConstantValueAccess().getIntegerTermParserRuleCall_2()); 

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
    // $ANTLR end "rule__ConstantValue__Alternatives"


    // $ANTLR start "rule__TextElement__Alternatives"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:454:1: rule__TextElement__Alternatives : ( ( ( rule__TextElement__TextAssignment_0 ) ) | ( ( rule__TextElement__NewlineAssignment_1 ) ) );
    public final void rule__TextElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:458:1: ( ( ( rule__TextElement__TextAssignment_0 ) ) | ( ( rule__TextElement__NewlineAssignment_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            else if ( (LA4_0==13) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:459:1: ( ( rule__TextElement__TextAssignment_0 ) )
                    {
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:459:1: ( ( rule__TextElement__TextAssignment_0 ) )
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:460:1: ( rule__TextElement__TextAssignment_0 )
                    {
                     before(grammarAccess.getTextElementAccess().getTextAssignment_0()); 
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:461:1: ( rule__TextElement__TextAssignment_0 )
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:461:2: rule__TextElement__TextAssignment_0
                    {
                    pushFollow(FOLLOW_rule__TextElement__TextAssignment_0_in_rule__TextElement__Alternatives917);
                    rule__TextElement__TextAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTextElementAccess().getTextAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:465:6: ( ( rule__TextElement__NewlineAssignment_1 ) )
                    {
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:465:6: ( ( rule__TextElement__NewlineAssignment_1 ) )
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:466:1: ( rule__TextElement__NewlineAssignment_1 )
                    {
                     before(grammarAccess.getTextElementAccess().getNewlineAssignment_1()); 
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:467:1: ( rule__TextElement__NewlineAssignment_1 )
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:467:2: rule__TextElement__NewlineAssignment_1
                    {
                    pushFollow(FOLLOW_rule__TextElement__NewlineAssignment_1_in_rule__TextElement__Alternatives935);
                    rule__TextElement__NewlineAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getTextElementAccess().getNewlineAssignment_1()); 

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
    // $ANTLR end "rule__TextElement__Alternatives"


    // $ANTLR start "rule__ShowValue__Group__0"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:478:1: rule__ShowValue__Group__0 : rule__ShowValue__Group__0__Impl rule__ShowValue__Group__1 ;
    public final void rule__ShowValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:482:1: ( rule__ShowValue__Group__0__Impl rule__ShowValue__Group__1 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:483:2: rule__ShowValue__Group__0__Impl rule__ShowValue__Group__1
            {
            pushFollow(FOLLOW_rule__ShowValue__Group__0__Impl_in_rule__ShowValue__Group__0966);
            rule__ShowValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ShowValue__Group__1_in_rule__ShowValue__Group__0969);
            rule__ShowValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShowValue__Group__0"


    // $ANTLR start "rule__ShowValue__Group__0__Impl"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:490:1: rule__ShowValue__Group__0__Impl : ( ( rule__ShowValue__RefAssignment_0 ) ) ;
    public final void rule__ShowValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:494:1: ( ( ( rule__ShowValue__RefAssignment_0 ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:495:1: ( ( rule__ShowValue__RefAssignment_0 ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:495:1: ( ( rule__ShowValue__RefAssignment_0 ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:496:1: ( rule__ShowValue__RefAssignment_0 )
            {
             before(grammarAccess.getShowValueAccess().getRefAssignment_0()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:497:1: ( rule__ShowValue__RefAssignment_0 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:497:2: rule__ShowValue__RefAssignment_0
            {
            pushFollow(FOLLOW_rule__ShowValue__RefAssignment_0_in_rule__ShowValue__Group__0__Impl996);
            rule__ShowValue__RefAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getShowValueAccess().getRefAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShowValue__Group__0__Impl"


    // $ANTLR start "rule__ShowValue__Group__1"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:507:1: rule__ShowValue__Group__1 : rule__ShowValue__Group__1__Impl ;
    public final void rule__ShowValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:511:1: ( rule__ShowValue__Group__1__Impl )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:512:2: rule__ShowValue__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ShowValue__Group__1__Impl_in_rule__ShowValue__Group__11026);
            rule__ShowValue__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShowValue__Group__1"


    // $ANTLR start "rule__ShowValue__Group__1__Impl"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:518:1: rule__ShowValue__Group__1__Impl : ( ( rule__ShowValue__Group_1__0 )? ) ;
    public final void rule__ShowValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:522:1: ( ( ( rule__ShowValue__Group_1__0 )? ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:523:1: ( ( rule__ShowValue__Group_1__0 )? )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:523:1: ( ( rule__ShowValue__Group_1__0 )? )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:524:1: ( rule__ShowValue__Group_1__0 )?
            {
             before(grammarAccess.getShowValueAccess().getGroup_1()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:525:1: ( rule__ShowValue__Group_1__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==11) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:525:2: rule__ShowValue__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ShowValue__Group_1__0_in_rule__ShowValue__Group__1__Impl1053);
                    rule__ShowValue__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getShowValueAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShowValue__Group__1__Impl"


    // $ANTLR start "rule__ShowValue__Group_1__0"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:539:1: rule__ShowValue__Group_1__0 : rule__ShowValue__Group_1__0__Impl rule__ShowValue__Group_1__1 ;
    public final void rule__ShowValue__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:543:1: ( rule__ShowValue__Group_1__0__Impl rule__ShowValue__Group_1__1 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:544:2: rule__ShowValue__Group_1__0__Impl rule__ShowValue__Group_1__1
            {
            pushFollow(FOLLOW_rule__ShowValue__Group_1__0__Impl_in_rule__ShowValue__Group_1__01088);
            rule__ShowValue__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ShowValue__Group_1__1_in_rule__ShowValue__Group_1__01091);
            rule__ShowValue__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShowValue__Group_1__0"


    // $ANTLR start "rule__ShowValue__Group_1__0__Impl"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:551:1: rule__ShowValue__Group_1__0__Impl : ( '%' ) ;
    public final void rule__ShowValue__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:555:1: ( ( '%' ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:556:1: ( '%' )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:556:1: ( '%' )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:557:1: '%'
            {
             before(grammarAccess.getShowValueAccess().getPercentSignKeyword_1_0()); 
            match(input,11,FOLLOW_11_in_rule__ShowValue__Group_1__0__Impl1119); 
             after(grammarAccess.getShowValueAccess().getPercentSignKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShowValue__Group_1__0__Impl"


    // $ANTLR start "rule__ShowValue__Group_1__1"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:570:1: rule__ShowValue__Group_1__1 : rule__ShowValue__Group_1__1__Impl ;
    public final void rule__ShowValue__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:574:1: ( rule__ShowValue__Group_1__1__Impl )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:575:2: rule__ShowValue__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ShowValue__Group_1__1__Impl_in_rule__ShowValue__Group_1__11150);
            rule__ShowValue__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShowValue__Group_1__1"


    // $ANTLR start "rule__ShowValue__Group_1__1__Impl"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:581:1: rule__ShowValue__Group_1__1__Impl : ( ( rule__ShowValue__UnitAssignment_1_1 ) ) ;
    public final void rule__ShowValue__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:585:1: ( ( ( rule__ShowValue__UnitAssignment_1_1 ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:586:1: ( ( rule__ShowValue__UnitAssignment_1_1 ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:586:1: ( ( rule__ShowValue__UnitAssignment_1_1 ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:587:1: ( rule__ShowValue__UnitAssignment_1_1 )
            {
             before(grammarAccess.getShowValueAccess().getUnitAssignment_1_1()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:588:1: ( rule__ShowValue__UnitAssignment_1_1 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:588:2: rule__ShowValue__UnitAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ShowValue__UnitAssignment_1_1_in_rule__ShowValue__Group_1__1__Impl1177);
            rule__ShowValue__UnitAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getShowValueAccess().getUnitAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShowValue__Group_1__1__Impl"


    // $ANTLR start "rule__ReferencePath__Group__0"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:602:1: rule__ReferencePath__Group__0 : rule__ReferencePath__Group__0__Impl rule__ReferencePath__Group__1 ;
    public final void rule__ReferencePath__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:606:1: ( rule__ReferencePath__Group__0__Impl rule__ReferencePath__Group__1 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:607:2: rule__ReferencePath__Group__0__Impl rule__ReferencePath__Group__1
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group__0__Impl_in_rule__ReferencePath__Group__01211);
            rule__ReferencePath__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReferencePath__Group__1_in_rule__ReferencePath__Group__01214);
            rule__ReferencePath__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencePath__Group__0"


    // $ANTLR start "rule__ReferencePath__Group__0__Impl"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:614:1: rule__ReferencePath__Group__0__Impl : ( ( rule__ReferencePath__RefAssignment_0 ) ) ;
    public final void rule__ReferencePath__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:618:1: ( ( ( rule__ReferencePath__RefAssignment_0 ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:619:1: ( ( rule__ReferencePath__RefAssignment_0 ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:619:1: ( ( rule__ReferencePath__RefAssignment_0 ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:620:1: ( rule__ReferencePath__RefAssignment_0 )
            {
             before(grammarAccess.getReferencePathAccess().getRefAssignment_0()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:621:1: ( rule__ReferencePath__RefAssignment_0 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:621:2: rule__ReferencePath__RefAssignment_0
            {
            pushFollow(FOLLOW_rule__ReferencePath__RefAssignment_0_in_rule__ReferencePath__Group__0__Impl1241);
            rule__ReferencePath__RefAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getReferencePathAccess().getRefAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencePath__Group__0__Impl"


    // $ANTLR start "rule__ReferencePath__Group__1"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:631:1: rule__ReferencePath__Group__1 : rule__ReferencePath__Group__1__Impl ;
    public final void rule__ReferencePath__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:635:1: ( rule__ReferencePath__Group__1__Impl )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:636:2: rule__ReferencePath__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group__1__Impl_in_rule__ReferencePath__Group__11271);
            rule__ReferencePath__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencePath__Group__1"


    // $ANTLR start "rule__ReferencePath__Group__1__Impl"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:642:1: rule__ReferencePath__Group__1__Impl : ( ( rule__ReferencePath__Group_1__0 ) ) ;
    public final void rule__ReferencePath__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:646:1: ( ( ( rule__ReferencePath__Group_1__0 ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:647:1: ( ( rule__ReferencePath__Group_1__0 ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:647:1: ( ( rule__ReferencePath__Group_1__0 ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:648:1: ( rule__ReferencePath__Group_1__0 )
            {
             before(grammarAccess.getReferencePathAccess().getGroup_1()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:649:1: ( rule__ReferencePath__Group_1__0 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:649:2: rule__ReferencePath__Group_1__0
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group_1__0_in_rule__ReferencePath__Group__1__Impl1298);
            rule__ReferencePath__Group_1__0();

            state._fsp--;


            }

             after(grammarAccess.getReferencePathAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencePath__Group__1__Impl"


    // $ANTLR start "rule__ReferencePath__Group_1__0"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:663:1: rule__ReferencePath__Group_1__0 : rule__ReferencePath__Group_1__0__Impl rule__ReferencePath__Group_1__1 ;
    public final void rule__ReferencePath__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:667:1: ( rule__ReferencePath__Group_1__0__Impl rule__ReferencePath__Group_1__1 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:668:2: rule__ReferencePath__Group_1__0__Impl rule__ReferencePath__Group_1__1
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group_1__0__Impl_in_rule__ReferencePath__Group_1__01332);
            rule__ReferencePath__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReferencePath__Group_1__1_in_rule__ReferencePath__Group_1__01335);
            rule__ReferencePath__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencePath__Group_1__0"


    // $ANTLR start "rule__ReferencePath__Group_1__0__Impl"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:675:1: rule__ReferencePath__Group_1__0__Impl : ( '.' ) ;
    public final void rule__ReferencePath__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:679:1: ( ( '.' ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:680:1: ( '.' )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:680:1: ( '.' )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:681:1: '.'
            {
             before(grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0()); 
            match(input,12,FOLLOW_12_in_rule__ReferencePath__Group_1__0__Impl1363); 
             after(grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencePath__Group_1__0__Impl"


    // $ANTLR start "rule__ReferencePath__Group_1__1"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:694:1: rule__ReferencePath__Group_1__1 : rule__ReferencePath__Group_1__1__Impl ;
    public final void rule__ReferencePath__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:698:1: ( rule__ReferencePath__Group_1__1__Impl )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:699:2: rule__ReferencePath__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group_1__1__Impl_in_rule__ReferencePath__Group_1__11394);
            rule__ReferencePath__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencePath__Group_1__1"


    // $ANTLR start "rule__ReferencePath__Group_1__1__Impl"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:705:1: rule__ReferencePath__Group_1__1__Impl : ( ( rule__ReferencePath__SubpathAssignment_1_1 ) ) ;
    public final void rule__ReferencePath__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:709:1: ( ( ( rule__ReferencePath__SubpathAssignment_1_1 ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:710:1: ( ( rule__ReferencePath__SubpathAssignment_1_1 ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:710:1: ( ( rule__ReferencePath__SubpathAssignment_1_1 ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:711:1: ( rule__ReferencePath__SubpathAssignment_1_1 )
            {
             before(grammarAccess.getReferencePathAccess().getSubpathAssignment_1_1()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:712:1: ( rule__ReferencePath__SubpathAssignment_1_1 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:712:2: rule__ReferencePath__SubpathAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ReferencePath__SubpathAssignment_1_1_in_rule__ReferencePath__Group_1__1__Impl1421);
            rule__ReferencePath__SubpathAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getReferencePathAccess().getSubpathAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencePath__Group_1__1__Impl"


    // $ANTLR start "rule__RealTerm__Group__0"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:728:1: rule__RealTerm__Group__0 : rule__RealTerm__Group__0__Impl rule__RealTerm__Group__1 ;
    public final void rule__RealTerm__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:732:1: ( rule__RealTerm__Group__0__Impl rule__RealTerm__Group__1 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:733:2: rule__RealTerm__Group__0__Impl rule__RealTerm__Group__1
            {
            pushFollow(FOLLOW_rule__RealTerm__Group__0__Impl_in_rule__RealTerm__Group__01457);
            rule__RealTerm__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RealTerm__Group__1_in_rule__RealTerm__Group__01460);
            rule__RealTerm__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealTerm__Group__0"


    // $ANTLR start "rule__RealTerm__Group__0__Impl"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:740:1: rule__RealTerm__Group__0__Impl : ( ( rule__RealTerm__ValueAssignment_0 ) ) ;
    public final void rule__RealTerm__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:744:1: ( ( ( rule__RealTerm__ValueAssignment_0 ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:745:1: ( ( rule__RealTerm__ValueAssignment_0 ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:745:1: ( ( rule__RealTerm__ValueAssignment_0 ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:746:1: ( rule__RealTerm__ValueAssignment_0 )
            {
             before(grammarAccess.getRealTermAccess().getValueAssignment_0()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:747:1: ( rule__RealTerm__ValueAssignment_0 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:747:2: rule__RealTerm__ValueAssignment_0
            {
            pushFollow(FOLLOW_rule__RealTerm__ValueAssignment_0_in_rule__RealTerm__Group__0__Impl1487);
            rule__RealTerm__ValueAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRealTermAccess().getValueAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealTerm__Group__0__Impl"


    // $ANTLR start "rule__RealTerm__Group__1"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:757:1: rule__RealTerm__Group__1 : rule__RealTerm__Group__1__Impl ;
    public final void rule__RealTerm__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:761:1: ( rule__RealTerm__Group__1__Impl )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:762:2: rule__RealTerm__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RealTerm__Group__1__Impl_in_rule__RealTerm__Group__11517);
            rule__RealTerm__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealTerm__Group__1"


    // $ANTLR start "rule__RealTerm__Group__1__Impl"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:768:1: rule__RealTerm__Group__1__Impl : ( ( rule__RealTerm__UnitAssignment_1 )? ) ;
    public final void rule__RealTerm__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:772:1: ( ( ( rule__RealTerm__UnitAssignment_1 )? ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:773:1: ( ( rule__RealTerm__UnitAssignment_1 )? )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:773:1: ( ( rule__RealTerm__UnitAssignment_1 )? )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:774:1: ( rule__RealTerm__UnitAssignment_1 )?
            {
             before(grammarAccess.getRealTermAccess().getUnitAssignment_1()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:775:1: ( rule__RealTerm__UnitAssignment_1 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:775:2: rule__RealTerm__UnitAssignment_1
                    {
                    pushFollow(FOLLOW_rule__RealTerm__UnitAssignment_1_in_rule__RealTerm__Group__1__Impl1544);
                    rule__RealTerm__UnitAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRealTermAccess().getUnitAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealTerm__Group__1__Impl"


    // $ANTLR start "rule__REAL__Group__0"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:789:1: rule__REAL__Group__0 : rule__REAL__Group__0__Impl rule__REAL__Group__1 ;
    public final void rule__REAL__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:793:1: ( rule__REAL__Group__0__Impl rule__REAL__Group__1 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:794:2: rule__REAL__Group__0__Impl rule__REAL__Group__1
            {
            pushFollow(FOLLOW_rule__REAL__Group__0__Impl_in_rule__REAL__Group__01579);
            rule__REAL__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__REAL__Group__1_in_rule__REAL__Group__01582);
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
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:801:1: rule__REAL__Group__0__Impl : ( RULE_INT ) ;
    public final void rule__REAL__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:805:1: ( ( RULE_INT ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:806:1: ( RULE_INT )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:806:1: ( RULE_INT )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:807:1: RULE_INT
            {
             before(grammarAccess.getREALAccess().getINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__REAL__Group__0__Impl1609); 
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
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:818:1: rule__REAL__Group__1 : rule__REAL__Group__1__Impl rule__REAL__Group__2 ;
    public final void rule__REAL__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:822:1: ( rule__REAL__Group__1__Impl rule__REAL__Group__2 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:823:2: rule__REAL__Group__1__Impl rule__REAL__Group__2
            {
            pushFollow(FOLLOW_rule__REAL__Group__1__Impl_in_rule__REAL__Group__11638);
            rule__REAL__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__REAL__Group__2_in_rule__REAL__Group__11641);
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
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:830:1: rule__REAL__Group__1__Impl : ( '.' ) ;
    public final void rule__REAL__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:834:1: ( ( '.' ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:835:1: ( '.' )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:835:1: ( '.' )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:836:1: '.'
            {
             before(grammarAccess.getREALAccess().getFullStopKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__REAL__Group__1__Impl1669); 
             after(grammarAccess.getREALAccess().getFullStopKeyword_1()); 

            }


            }

        }
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
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:849:1: rule__REAL__Group__2 : rule__REAL__Group__2__Impl ;
    public final void rule__REAL__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:853:1: ( rule__REAL__Group__2__Impl )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:854:2: rule__REAL__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__REAL__Group__2__Impl_in_rule__REAL__Group__21700);
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
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:860:1: rule__REAL__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__REAL__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:864:1: ( ( RULE_INT ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:865:1: ( RULE_INT )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:865:1: ( RULE_INT )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:866:1: RULE_INT
            {
             before(grammarAccess.getREALAccess().getINTTerminalRuleCall_2()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__REAL__Group__2__Impl1727); 
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


    // $ANTLR start "rule__IntegerTerm__Group__0"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:883:1: rule__IntegerTerm__Group__0 : rule__IntegerTerm__Group__0__Impl rule__IntegerTerm__Group__1 ;
    public final void rule__IntegerTerm__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:887:1: ( rule__IntegerTerm__Group__0__Impl rule__IntegerTerm__Group__1 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:888:2: rule__IntegerTerm__Group__0__Impl rule__IntegerTerm__Group__1
            {
            pushFollow(FOLLOW_rule__IntegerTerm__Group__0__Impl_in_rule__IntegerTerm__Group__01762);
            rule__IntegerTerm__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IntegerTerm__Group__1_in_rule__IntegerTerm__Group__01765);
            rule__IntegerTerm__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegerTerm__Group__0"


    // $ANTLR start "rule__IntegerTerm__Group__0__Impl"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:895:1: rule__IntegerTerm__Group__0__Impl : ( ( rule__IntegerTerm__ValueAssignment_0 ) ) ;
    public final void rule__IntegerTerm__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:899:1: ( ( ( rule__IntegerTerm__ValueAssignment_0 ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:900:1: ( ( rule__IntegerTerm__ValueAssignment_0 ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:900:1: ( ( rule__IntegerTerm__ValueAssignment_0 ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:901:1: ( rule__IntegerTerm__ValueAssignment_0 )
            {
             before(grammarAccess.getIntegerTermAccess().getValueAssignment_0()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:902:1: ( rule__IntegerTerm__ValueAssignment_0 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:902:2: rule__IntegerTerm__ValueAssignment_0
            {
            pushFollow(FOLLOW_rule__IntegerTerm__ValueAssignment_0_in_rule__IntegerTerm__Group__0__Impl1792);
            rule__IntegerTerm__ValueAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getIntegerTermAccess().getValueAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegerTerm__Group__0__Impl"


    // $ANTLR start "rule__IntegerTerm__Group__1"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:912:1: rule__IntegerTerm__Group__1 : rule__IntegerTerm__Group__1__Impl ;
    public final void rule__IntegerTerm__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:916:1: ( rule__IntegerTerm__Group__1__Impl )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:917:2: rule__IntegerTerm__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IntegerTerm__Group__1__Impl_in_rule__IntegerTerm__Group__11822);
            rule__IntegerTerm__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegerTerm__Group__1"


    // $ANTLR start "rule__IntegerTerm__Group__1__Impl"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:923:1: rule__IntegerTerm__Group__1__Impl : ( ( rule__IntegerTerm__UnitAssignment_1 )? ) ;
    public final void rule__IntegerTerm__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:927:1: ( ( ( rule__IntegerTerm__UnitAssignment_1 )? ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:928:1: ( ( rule__IntegerTerm__UnitAssignment_1 )? )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:928:1: ( ( rule__IntegerTerm__UnitAssignment_1 )? )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:929:1: ( rule__IntegerTerm__UnitAssignment_1 )?
            {
             before(grammarAccess.getIntegerTermAccess().getUnitAssignment_1()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:930:1: ( rule__IntegerTerm__UnitAssignment_1 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:930:2: rule__IntegerTerm__UnitAssignment_1
                    {
                    pushFollow(FOLLOW_rule__IntegerTerm__UnitAssignment_1_in_rule__IntegerTerm__Group__1__Impl1849);
                    rule__IntegerTerm__UnitAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIntegerTermAccess().getUnitAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegerTerm__Group__1__Impl"


    // $ANTLR start "rule__Model__ContentAssignment"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:950:1: rule__Model__ContentAssignment : ( ruleDescription ) ;
    public final void rule__Model__ContentAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:954:1: ( ( ruleDescription ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:955:1: ( ruleDescription )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:955:1: ( ruleDescription )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:956:1: ruleDescription
            {
             before(grammarAccess.getModelAccess().getContentDescriptionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleDescription_in_rule__Model__ContentAssignment1894);
            ruleDescription();

            state._fsp--;

             after(grammarAccess.getModelAccess().getContentDescriptionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ContentAssignment"


    // $ANTLR start "rule__Description__DescriptionAssignment"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:965:1: rule__Description__DescriptionAssignment : ( ruleDescriptionElement ) ;
    public final void rule__Description__DescriptionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:969:1: ( ( ruleDescriptionElement ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:970:1: ( ruleDescriptionElement )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:970:1: ( ruleDescriptionElement )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:971:1: ruleDescriptionElement
            {
             before(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_rule__Description__DescriptionAssignment1925);
            ruleDescriptionElement();

            state._fsp--;

             after(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Description__DescriptionAssignment"


    // $ANTLR start "rule__DescriptionElement__TextAssignment_0"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:980:1: rule__DescriptionElement__TextAssignment_0 : ( RULE_STRING ) ;
    public final void rule__DescriptionElement__TextAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:984:1: ( ( RULE_STRING ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:985:1: ( RULE_STRING )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:985:1: ( RULE_STRING )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:986:1: RULE_STRING
            {
             before(grammarAccess.getDescriptionElementAccess().getTextSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__DescriptionElement__TextAssignment_01956); 
             after(grammarAccess.getDescriptionElementAccess().getTextSTRINGTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptionElement__TextAssignment_0"


    // $ANTLR start "rule__DescriptionElement__ValueAssignment_1"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:995:1: rule__DescriptionElement__ValueAssignment_1 : ( ruleShowValue ) ;
    public final void rule__DescriptionElement__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:999:1: ( ( ruleShowValue ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1000:1: ( ruleShowValue )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1000:1: ( ruleShowValue )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1001:1: ruleShowValue
            {
             before(grammarAccess.getDescriptionElementAccess().getValueShowValueParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleShowValue_in_rule__DescriptionElement__ValueAssignment_11987);
            ruleShowValue();

            state._fsp--;

             after(grammarAccess.getDescriptionElementAccess().getValueShowValueParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptionElement__ValueAssignment_1"


    // $ANTLR start "rule__DescriptionElement__NewlineAssignment_2"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1010:1: rule__DescriptionElement__NewlineAssignment_2 : ( ( '&' ) ) ;
    public final void rule__DescriptionElement__NewlineAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1014:1: ( ( ( '&' ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1015:1: ( ( '&' ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1015:1: ( ( '&' ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1016:1: ( '&' )
            {
             before(grammarAccess.getDescriptionElementAccess().getNewlineAmpersandKeyword_2_0()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1017:1: ( '&' )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1018:1: '&'
            {
             before(grammarAccess.getDescriptionElementAccess().getNewlineAmpersandKeyword_2_0()); 
            match(input,13,FOLLOW_13_in_rule__DescriptionElement__NewlineAssignment_22023); 
             after(grammarAccess.getDescriptionElementAccess().getNewlineAmpersandKeyword_2_0()); 

            }

             after(grammarAccess.getDescriptionElementAccess().getNewlineAmpersandKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptionElement__NewlineAssignment_2"


    // $ANTLR start "rule__DescriptionElement__ThisTargetAssignment_3"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1033:1: rule__DescriptionElement__ThisTargetAssignment_3 : ( ( 'this' ) ) ;
    public final void rule__DescriptionElement__ThisTargetAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1037:1: ( ( ( 'this' ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1038:1: ( ( 'this' ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1038:1: ( ( 'this' ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1039:1: ( 'this' )
            {
             before(grammarAccess.getDescriptionElementAccess().getThisTargetThisKeyword_3_0()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1040:1: ( 'this' )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1041:1: 'this'
            {
             before(grammarAccess.getDescriptionElementAccess().getThisTargetThisKeyword_3_0()); 
            match(input,14,FOLLOW_14_in_rule__DescriptionElement__ThisTargetAssignment_32067); 
             after(grammarAccess.getDescriptionElementAccess().getThisTargetThisKeyword_3_0()); 

            }

             after(grammarAccess.getDescriptionElementAccess().getThisTargetThisKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptionElement__ThisTargetAssignment_3"


    // $ANTLR start "rule__ShowValue__RefAssignment_0"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1056:1: rule__ShowValue__RefAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ShowValue__RefAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1060:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1061:1: ( ( RULE_ID ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1061:1: ( ( RULE_ID ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1062:1: ( RULE_ID )
            {
             before(grammarAccess.getShowValueAccess().getRefEObjectCrossReference_0_0()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1063:1: ( RULE_ID )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1064:1: RULE_ID
            {
             before(grammarAccess.getShowValueAccess().getRefEObjectIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ShowValue__RefAssignment_02110); 
             after(grammarAccess.getShowValueAccess().getRefEObjectIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getShowValueAccess().getRefEObjectCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShowValue__RefAssignment_0"


    // $ANTLR start "rule__ShowValue__UnitAssignment_1_1"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1075:1: rule__ShowValue__UnitAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__ShowValue__UnitAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1079:1: ( ( RULE_ID ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1080:1: ( RULE_ID )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1080:1: ( RULE_ID )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1081:1: RULE_ID
            {
             before(grammarAccess.getShowValueAccess().getUnitIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ShowValue__UnitAssignment_1_12145); 
             after(grammarAccess.getShowValueAccess().getUnitIDTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShowValue__UnitAssignment_1_1"


    // $ANTLR start "rule__ReferencePath__RefAssignment_0"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1090:1: rule__ReferencePath__RefAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ReferencePath__RefAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1094:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1095:1: ( ( RULE_ID ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1095:1: ( ( RULE_ID ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1096:1: ( RULE_ID )
            {
             before(grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1097:1: ( RULE_ID )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1098:1: RULE_ID
            {
             before(grammarAccess.getReferencePathAccess().getRefEObjectIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ReferencePath__RefAssignment_02180); 
             after(grammarAccess.getReferencePathAccess().getRefEObjectIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencePath__RefAssignment_0"


    // $ANTLR start "rule__ReferencePath__SubpathAssignment_1_1"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1109:1: rule__ReferencePath__SubpathAssignment_1_1 : ( ruleReferencePath ) ;
    public final void rule__ReferencePath__SubpathAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1113:1: ( ( ruleReferencePath ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1114:1: ( ruleReferencePath )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1114:1: ( ruleReferencePath )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1115:1: ruleReferencePath
            {
             before(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleReferencePath_in_rule__ReferencePath__SubpathAssignment_1_12215);
            ruleReferencePath();

            state._fsp--;

             after(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencePath__SubpathAssignment_1_1"


    // $ANTLR start "rule__StringTerm__ValueAssignment"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1127:1: rule__StringTerm__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringTerm__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1131:1: ( ( RULE_STRING ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1132:1: ( RULE_STRING )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1132:1: ( RULE_STRING )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1133:1: RULE_STRING
            {
             before(grammarAccess.getStringTermAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringTerm__ValueAssignment2249); 
             after(grammarAccess.getStringTermAccess().getValueSTRINGTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringTerm__ValueAssignment"


    // $ANTLR start "rule__RealTerm__ValueAssignment_0"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1142:1: rule__RealTerm__ValueAssignment_0 : ( ruleREAL ) ;
    public final void rule__RealTerm__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1146:1: ( ( ruleREAL ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1147:1: ( ruleREAL )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1147:1: ( ruleREAL )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1148:1: ruleREAL
            {
             before(grammarAccess.getRealTermAccess().getValueREALParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleREAL_in_rule__RealTerm__ValueAssignment_02280);
            ruleREAL();

            state._fsp--;

             after(grammarAccess.getRealTermAccess().getValueREALParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealTerm__ValueAssignment_0"


    // $ANTLR start "rule__RealTerm__UnitAssignment_1"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1157:1: rule__RealTerm__UnitAssignment_1 : ( RULE_ID ) ;
    public final void rule__RealTerm__UnitAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1161:1: ( ( RULE_ID ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1162:1: ( RULE_ID )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1162:1: ( RULE_ID )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1163:1: RULE_ID
            {
             before(grammarAccess.getRealTermAccess().getUnitIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RealTerm__UnitAssignment_12311); 
             after(grammarAccess.getRealTermAccess().getUnitIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealTerm__UnitAssignment_1"


    // $ANTLR start "rule__IntegerTerm__ValueAssignment_0"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1172:1: rule__IntegerTerm__ValueAssignment_0 : ( RULE_INT ) ;
    public final void rule__IntegerTerm__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1176:1: ( ( RULE_INT ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1177:1: ( RULE_INT )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1177:1: ( RULE_INT )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1178:1: RULE_INT
            {
             before(grammarAccess.getIntegerTermAccess().getValueINTTerminalRuleCall_0_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__IntegerTerm__ValueAssignment_02342); 
             after(grammarAccess.getIntegerTermAccess().getValueINTTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegerTerm__ValueAssignment_0"


    // $ANTLR start "rule__IntegerTerm__UnitAssignment_1"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1187:1: rule__IntegerTerm__UnitAssignment_1 : ( RULE_ID ) ;
    public final void rule__IntegerTerm__UnitAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1191:1: ( ( RULE_ID ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1192:1: ( RULE_ID )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1192:1: ( RULE_ID )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1193:1: RULE_ID
            {
             before(grammarAccess.getIntegerTermAccess().getUnitIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IntegerTerm__UnitAssignment_12373); 
             after(grammarAccess.getIntegerTermAccess().getUnitIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegerTerm__UnitAssignment_1"


    // $ANTLR start "rule__TextElement__TextAssignment_0"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1203:1: rule__TextElement__TextAssignment_0 : ( RULE_STRING ) ;
    public final void rule__TextElement__TextAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1207:1: ( ( RULE_STRING ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1208:1: ( RULE_STRING )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1208:1: ( RULE_STRING )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1209:1: RULE_STRING
            {
             before(grammarAccess.getTextElementAccess().getTextSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__TextElement__TextAssignment_02405); 
             after(grammarAccess.getTextElementAccess().getTextSTRINGTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextElement__TextAssignment_0"


    // $ANTLR start "rule__TextElement__NewlineAssignment_1"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1218:1: rule__TextElement__NewlineAssignment_1 : ( ( '&' ) ) ;
    public final void rule__TextElement__NewlineAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1222:1: ( ( ( '&' ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1223:1: ( ( '&' ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1223:1: ( ( '&' ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1224:1: ( '&' )
            {
             before(grammarAccess.getTextElementAccess().getNewlineAmpersandKeyword_1_0()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1225:1: ( '&' )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:1226:1: '&'
            {
             before(grammarAccess.getTextElementAccess().getNewlineAmpersandKeyword_1_0()); 
            match(input,13,FOLLOW_13_in_rule__TextElement__NewlineAssignment_12441); 
             after(grammarAccess.getTextElementAccess().getNewlineAmpersandKeyword_1_0()); 

            }

             after(grammarAccess.getTextElementAccess().getNewlineAmpersandKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextElement__NewlineAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ContentAssignment_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Description__DescriptionAssignment_in_ruleDescription156 = new BitSet(new long[]{0x0000000000006062L});
    public static final BitSet FOLLOW_rule__Description__DescriptionAssignment_in_ruleDescription168 = new BitSet(new long[]{0x0000000000006062L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement198 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DescriptionElement__Alternatives_in_ruleDescriptionElement231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShowValue_in_entryRuleShowValue258 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShowValue265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShowValue__Group__0_in_ruleShowValue291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath318 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__0_in_ruleReferencePath351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantValue_in_entryRuleConstantValue382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstantValue389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstantValue__Alternatives_in_ruleConstantValue415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_entryRuleStringTerm442 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringTerm449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringTerm__ValueAssignment_in_ruleStringTerm475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_entryRuleRealTerm502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealTerm509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealTerm__Group__0_in_ruleRealTerm535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_entryRuleREAL562 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleREAL569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__REAL__Group__0_in_ruleREAL595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_entryRuleIntegerTerm622 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerTerm629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntegerTerm__Group__0_in_ruleIntegerTerm655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextElement_in_entryRuleTextElement684 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTextElement691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TextElement__Alternatives_in_ruleTextElement717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DescriptionElement__TextAssignment_0_in_rule__DescriptionElement__Alternatives763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DescriptionElement__ValueAssignment_1_in_rule__DescriptionElement__Alternatives781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DescriptionElement__NewlineAssignment_2_in_rule__DescriptionElement__Alternatives799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DescriptionElement__ThisTargetAssignment_3_in_rule__DescriptionElement__Alternatives817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_rule__ConstantValue__Alternatives851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_rule__ConstantValue__Alternatives868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_rule__ConstantValue__Alternatives885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TextElement__TextAssignment_0_in_rule__TextElement__Alternatives917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TextElement__NewlineAssignment_1_in_rule__TextElement__Alternatives935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShowValue__Group__0__Impl_in_rule__ShowValue__Group__0966 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__ShowValue__Group__1_in_rule__ShowValue__Group__0969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShowValue__RefAssignment_0_in_rule__ShowValue__Group__0__Impl996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShowValue__Group__1__Impl_in_rule__ShowValue__Group__11026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShowValue__Group_1__0_in_rule__ShowValue__Group__1__Impl1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShowValue__Group_1__0__Impl_in_rule__ShowValue__Group_1__01088 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ShowValue__Group_1__1_in_rule__ShowValue__Group_1__01091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__ShowValue__Group_1__0__Impl1119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShowValue__Group_1__1__Impl_in_rule__ShowValue__Group_1__11150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShowValue__UnitAssignment_1_1_in_rule__ShowValue__Group_1__1__Impl1177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__0__Impl_in_rule__ReferencePath__Group__01211 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__1_in_rule__ReferencePath__Group__01214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__RefAssignment_0_in_rule__ReferencePath__Group__0__Impl1241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__1__Impl_in_rule__ReferencePath__Group__11271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__0_in_rule__ReferencePath__Group__1__Impl1298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__0__Impl_in_rule__ReferencePath__Group_1__01332 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__1_in_rule__ReferencePath__Group_1__01335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ReferencePath__Group_1__0__Impl1363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__1__Impl_in_rule__ReferencePath__Group_1__11394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__SubpathAssignment_1_1_in_rule__ReferencePath__Group_1__1__Impl1421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealTerm__Group__0__Impl_in_rule__RealTerm__Group__01457 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__RealTerm__Group__1_in_rule__RealTerm__Group__01460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealTerm__ValueAssignment_0_in_rule__RealTerm__Group__0__Impl1487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealTerm__Group__1__Impl_in_rule__RealTerm__Group__11517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealTerm__UnitAssignment_1_in_rule__RealTerm__Group__1__Impl1544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__REAL__Group__0__Impl_in_rule__REAL__Group__01579 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__REAL__Group__1_in_rule__REAL__Group__01582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__REAL__Group__0__Impl1609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__REAL__Group__1__Impl_in_rule__REAL__Group__11638 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__REAL__Group__2_in_rule__REAL__Group__11641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__REAL__Group__1__Impl1669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__REAL__Group__2__Impl_in_rule__REAL__Group__21700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__REAL__Group__2__Impl1727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntegerTerm__Group__0__Impl_in_rule__IntegerTerm__Group__01762 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__IntegerTerm__Group__1_in_rule__IntegerTerm__Group__01765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntegerTerm__ValueAssignment_0_in_rule__IntegerTerm__Group__0__Impl1792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntegerTerm__Group__1__Impl_in_rule__IntegerTerm__Group__11822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntegerTerm__UnitAssignment_1_in_rule__IntegerTerm__Group__1__Impl1849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_rule__Model__ContentAssignment1894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_rule__Description__DescriptionAssignment1925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__DescriptionElement__TextAssignment_01956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShowValue_in_rule__DescriptionElement__ValueAssignment_11987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__DescriptionElement__NewlineAssignment_22023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__DescriptionElement__ThisTargetAssignment_32067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ShowValue__RefAssignment_02110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ShowValue__UnitAssignment_1_12145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ReferencePath__RefAssignment_02180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_rule__ReferencePath__SubpathAssignment_1_12215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringTerm__ValueAssignment2249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_rule__RealTerm__ValueAssignment_02280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RealTerm__UnitAssignment_12311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__IntegerTerm__ValueAssignment_02342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IntegerTerm__UnitAssignment_12373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__TextElement__TextAssignment_02405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__TextElement__NewlineAssignment_12441 = new BitSet(new long[]{0x0000000000000002L});

}