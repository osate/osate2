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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'.'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int T__11=11;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
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

                if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)) ) {
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


    // $ANTLR start "entryRuleReferencePath"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:151:1: entryRuleReferencePath : ruleReferencePath EOF ;
    public final void entryRuleReferencePath() throws RecognitionException {
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:152:1: ( ruleReferencePath EOF )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:153:1: ruleReferencePath EOF
            {
             before(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath258);
            ruleReferencePath();

            state._fsp--;

             after(grammarAccess.getReferencePathRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath265); 

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
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:160:1: ruleReferencePath : ( ( rule__ReferencePath__Group__0 ) ) ;
    public final void ruleReferencePath() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:164:2: ( ( ( rule__ReferencePath__Group__0 ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:165:1: ( ( rule__ReferencePath__Group__0 ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:165:1: ( ( rule__ReferencePath__Group__0 ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:166:1: ( rule__ReferencePath__Group__0 )
            {
             before(grammarAccess.getReferencePathAccess().getGroup()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:167:1: ( rule__ReferencePath__Group__0 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:167:2: rule__ReferencePath__Group__0
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group__0_in_ruleReferencePath291);
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


    // $ANTLR start "entryRuleValueString"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:183:1: entryRuleValueString : ruleValueString EOF ;
    public final void entryRuleValueString() throws RecognitionException {
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:184:1: ( ruleValueString EOF )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:185:1: ruleValueString EOF
            {
             before(grammarAccess.getValueStringRule()); 
            pushFollow(FOLLOW_ruleValueString_in_entryRuleValueString322);
            ruleValueString();

            state._fsp--;

             after(grammarAccess.getValueStringRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueString329); 

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
    // $ANTLR end "entryRuleValueString"


    // $ANTLR start "ruleValueString"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:192:1: ruleValueString : ( RULE_STRING ) ;
    public final void ruleValueString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:196:2: ( ( RULE_STRING ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:197:1: ( RULE_STRING )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:197:1: ( RULE_STRING )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:198:1: RULE_STRING
            {
             before(grammarAccess.getValueStringAccess().getSTRINGTerminalRuleCall()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleValueString355); 
             after(grammarAccess.getValueStringAccess().getSTRINGTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValueString"


    // $ANTLR start "rule__DescriptionElement__Alternatives"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:219:1: rule__DescriptionElement__Alternatives : ( ( ( rule__DescriptionElement__TextAssignment_0 ) ) | ( ( rule__DescriptionElement__RefAssignment_1 ) ) );
    public final void rule__DescriptionElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:223:1: ( ( ( rule__DescriptionElement__TextAssignment_0 ) ) | ( ( rule__DescriptionElement__RefAssignment_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
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
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:224:1: ( ( rule__DescriptionElement__TextAssignment_0 ) )
                    {
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:224:1: ( ( rule__DescriptionElement__TextAssignment_0 ) )
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:225:1: ( rule__DescriptionElement__TextAssignment_0 )
                    {
                     before(grammarAccess.getDescriptionElementAccess().getTextAssignment_0()); 
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:226:1: ( rule__DescriptionElement__TextAssignment_0 )
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:226:2: rule__DescriptionElement__TextAssignment_0
                    {
                    pushFollow(FOLLOW_rule__DescriptionElement__TextAssignment_0_in_rule__DescriptionElement__Alternatives398);
                    rule__DescriptionElement__TextAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDescriptionElementAccess().getTextAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:230:6: ( ( rule__DescriptionElement__RefAssignment_1 ) )
                    {
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:230:6: ( ( rule__DescriptionElement__RefAssignment_1 ) )
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:231:1: ( rule__DescriptionElement__RefAssignment_1 )
                    {
                     before(grammarAccess.getDescriptionElementAccess().getRefAssignment_1()); 
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:232:1: ( rule__DescriptionElement__RefAssignment_1 )
                    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:232:2: rule__DescriptionElement__RefAssignment_1
                    {
                    pushFollow(FOLLOW_rule__DescriptionElement__RefAssignment_1_in_rule__DescriptionElement__Alternatives416);
                    rule__DescriptionElement__RefAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getDescriptionElementAccess().getRefAssignment_1()); 

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


    // $ANTLR start "rule__ReferencePath__Group__0"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:244:1: rule__ReferencePath__Group__0 : rule__ReferencePath__Group__0__Impl rule__ReferencePath__Group__1 ;
    public final void rule__ReferencePath__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:248:1: ( rule__ReferencePath__Group__0__Impl rule__ReferencePath__Group__1 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:249:2: rule__ReferencePath__Group__0__Impl rule__ReferencePath__Group__1
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group__0__Impl_in_rule__ReferencePath__Group__0448);
            rule__ReferencePath__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReferencePath__Group__1_in_rule__ReferencePath__Group__0451);
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
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:256:1: rule__ReferencePath__Group__0__Impl : ( ( rule__ReferencePath__RefAssignment_0 ) ) ;
    public final void rule__ReferencePath__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:260:1: ( ( ( rule__ReferencePath__RefAssignment_0 ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:261:1: ( ( rule__ReferencePath__RefAssignment_0 ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:261:1: ( ( rule__ReferencePath__RefAssignment_0 ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:262:1: ( rule__ReferencePath__RefAssignment_0 )
            {
             before(grammarAccess.getReferencePathAccess().getRefAssignment_0()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:263:1: ( rule__ReferencePath__RefAssignment_0 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:263:2: rule__ReferencePath__RefAssignment_0
            {
            pushFollow(FOLLOW_rule__ReferencePath__RefAssignment_0_in_rule__ReferencePath__Group__0__Impl478);
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
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:273:1: rule__ReferencePath__Group__1 : rule__ReferencePath__Group__1__Impl ;
    public final void rule__ReferencePath__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:277:1: ( rule__ReferencePath__Group__1__Impl )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:278:2: rule__ReferencePath__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group__1__Impl_in_rule__ReferencePath__Group__1508);
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
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:284:1: rule__ReferencePath__Group__1__Impl : ( ( rule__ReferencePath__Group_1__0 ) ) ;
    public final void rule__ReferencePath__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:288:1: ( ( ( rule__ReferencePath__Group_1__0 ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:289:1: ( ( rule__ReferencePath__Group_1__0 ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:289:1: ( ( rule__ReferencePath__Group_1__0 ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:290:1: ( rule__ReferencePath__Group_1__0 )
            {
             before(grammarAccess.getReferencePathAccess().getGroup_1()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:291:1: ( rule__ReferencePath__Group_1__0 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:291:2: rule__ReferencePath__Group_1__0
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group_1__0_in_rule__ReferencePath__Group__1__Impl535);
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
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:305:1: rule__ReferencePath__Group_1__0 : rule__ReferencePath__Group_1__0__Impl rule__ReferencePath__Group_1__1 ;
    public final void rule__ReferencePath__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:309:1: ( rule__ReferencePath__Group_1__0__Impl rule__ReferencePath__Group_1__1 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:310:2: rule__ReferencePath__Group_1__0__Impl rule__ReferencePath__Group_1__1
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group_1__0__Impl_in_rule__ReferencePath__Group_1__0569);
            rule__ReferencePath__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReferencePath__Group_1__1_in_rule__ReferencePath__Group_1__0572);
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
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:317:1: rule__ReferencePath__Group_1__0__Impl : ( '.' ) ;
    public final void rule__ReferencePath__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:321:1: ( ( '.' ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:322:1: ( '.' )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:322:1: ( '.' )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:323:1: '.'
            {
             before(grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0()); 
            match(input,11,FOLLOW_11_in_rule__ReferencePath__Group_1__0__Impl600); 
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
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:336:1: rule__ReferencePath__Group_1__1 : rule__ReferencePath__Group_1__1__Impl ;
    public final void rule__ReferencePath__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:340:1: ( rule__ReferencePath__Group_1__1__Impl )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:341:2: rule__ReferencePath__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group_1__1__Impl_in_rule__ReferencePath__Group_1__1631);
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
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:347:1: rule__ReferencePath__Group_1__1__Impl : ( ( rule__ReferencePath__SubpathAssignment_1_1 ) ) ;
    public final void rule__ReferencePath__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:351:1: ( ( ( rule__ReferencePath__SubpathAssignment_1_1 ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:352:1: ( ( rule__ReferencePath__SubpathAssignment_1_1 ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:352:1: ( ( rule__ReferencePath__SubpathAssignment_1_1 ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:353:1: ( rule__ReferencePath__SubpathAssignment_1_1 )
            {
             before(grammarAccess.getReferencePathAccess().getSubpathAssignment_1_1()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:354:1: ( rule__ReferencePath__SubpathAssignment_1_1 )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:354:2: rule__ReferencePath__SubpathAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ReferencePath__SubpathAssignment_1_1_in_rule__ReferencePath__Group_1__1__Impl658);
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


    // $ANTLR start "rule__Model__ContentAssignment"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:376:1: rule__Model__ContentAssignment : ( ruleDescription ) ;
    public final void rule__Model__ContentAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:380:1: ( ( ruleDescription ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:381:1: ( ruleDescription )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:381:1: ( ruleDescription )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:382:1: ruleDescription
            {
             before(grammarAccess.getModelAccess().getContentDescriptionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleDescription_in_rule__Model__ContentAssignment704);
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
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:391:1: rule__Description__DescriptionAssignment : ( ruleDescriptionElement ) ;
    public final void rule__Description__DescriptionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:395:1: ( ( ruleDescriptionElement ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:396:1: ( ruleDescriptionElement )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:396:1: ( ruleDescriptionElement )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:397:1: ruleDescriptionElement
            {
             before(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_rule__Description__DescriptionAssignment735);
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
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:406:1: rule__DescriptionElement__TextAssignment_0 : ( RULE_STRING ) ;
    public final void rule__DescriptionElement__TextAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:410:1: ( ( RULE_STRING ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:411:1: ( RULE_STRING )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:411:1: ( RULE_STRING )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:412:1: RULE_STRING
            {
             before(grammarAccess.getDescriptionElementAccess().getTextSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__DescriptionElement__TextAssignment_0766); 
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


    // $ANTLR start "rule__DescriptionElement__RefAssignment_1"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:421:1: rule__DescriptionElement__RefAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__DescriptionElement__RefAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:425:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:426:1: ( ( RULE_ID ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:426:1: ( ( RULE_ID ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:427:1: ( RULE_ID )
            {
             before(grammarAccess.getDescriptionElementAccess().getRefEObjectCrossReference_1_0()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:428:1: ( RULE_ID )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:429:1: RULE_ID
            {
             before(grammarAccess.getDescriptionElementAccess().getRefEObjectIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DescriptionElement__RefAssignment_1801); 
             after(grammarAccess.getDescriptionElementAccess().getRefEObjectIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getDescriptionElementAccess().getRefEObjectCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptionElement__RefAssignment_1"


    // $ANTLR start "rule__ReferencePath__RefAssignment_0"
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:440:1: rule__ReferencePath__RefAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ReferencePath__RefAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:444:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:445:1: ( ( RULE_ID ) )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:445:1: ( ( RULE_ID ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:446:1: ( RULE_ID )
            {
             before(grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:447:1: ( RULE_ID )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:448:1: RULE_ID
            {
             before(grammarAccess.getReferencePathAccess().getRefEObjectIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ReferencePath__RefAssignment_0840); 
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
    // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:459:1: rule__ReferencePath__SubpathAssignment_1_1 : ( ruleReferencePath ) ;
    public final void rule__ReferencePath__SubpathAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:463:1: ( ( ruleReferencePath ) )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:464:1: ( ruleReferencePath )
            {
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:464:1: ( ruleReferencePath )
            // ../org.osate.alisa.common.ui/src-gen/org/osate/alisa/common/ui/contentassist/antlr/internal/InternalCommon.g:465:1: ruleReferencePath
            {
             before(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleReferencePath_in_rule__ReferencePath__SubpathAssignment_1_1875);
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

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ContentAssignment_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Description__DescriptionAssignment_in_ruleDescription156 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_rule__Description__DescriptionAssignment_in_ruleDescription168 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement198 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DescriptionElement__Alternatives_in_ruleDescriptionElement231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath258 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__0_in_ruleReferencePath291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_entryRuleValueString322 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueString329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleValueString355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DescriptionElement__TextAssignment_0_in_rule__DescriptionElement__Alternatives398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DescriptionElement__RefAssignment_1_in_rule__DescriptionElement__Alternatives416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__0__Impl_in_rule__ReferencePath__Group__0448 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__1_in_rule__ReferencePath__Group__0451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__RefAssignment_0_in_rule__ReferencePath__Group__0__Impl478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__1__Impl_in_rule__ReferencePath__Group__1508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__0_in_rule__ReferencePath__Group__1__Impl535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__0__Impl_in_rule__ReferencePath__Group_1__0569 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__1_in_rule__ReferencePath__Group_1__0572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__ReferencePath__Group_1__0__Impl600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__1__Impl_in_rule__ReferencePath__Group_1__1631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__SubpathAssignment_1_1_in_rule__ReferencePath__Group_1__1__Impl658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_rule__Model__ContentAssignment704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_rule__Description__DescriptionAssignment735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__DescriptionElement__TextAssignment_0766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DescriptionElement__RefAssignment_1801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ReferencePath__RefAssignment_0840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_rule__ReferencePath__SubpathAssignment_1_1875 = new BitSet(new long[]{0x0000000000000002L});

}